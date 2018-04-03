package com.jmjk.action;


import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jmjk.action.base.BaseAction;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.TMaintainableEntry;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.TStaffCommunite;
import com.jmjk.entity.TStaffLeave;
import com.jmjk.entity.view.VStaffLeave;
import com.jmjk.enums.OperatorState;
import com.jmjk.enums.StaffState;
import com.jmjk.export.StaffExport;
import com.jmjk.export.StaffLeaveExport;
import com.jmjk.pojo.StaffSpecial;
import com.jmjk.service.CommunityHospitalGroupService;
import com.jmjk.service.CommunityHospitalService;
import com.jmjk.service.MaintainableAttributeService;
import com.jmjk.service.RoleService;
import com.jmjk.service.StaffLeaveService;
import com.jmjk.service.StaffService;
import com.jmjk.utils.GetSessionPerson;
import com.jmjk.utils.HtmlEscape;
import com.jmjk.utils.JxlExcel;
import com.jmjk.utils.Page;
import com.jmjk.utils.Resubmit;
import com.jmjk.utils.TokenProccessor;
import com.jmjk.utils.TypeConverter;


/**
 * 注意所有的查询都还没有写!!!!  
 * 包括员工管理里面的员工基本信息管理和员工请假管理
 * @author Liufengshuang
 *  15930779009
 */
@Component
@Scope("prototype")
@Action(value="staffAction",results={
		@Result(name="getKWHZDUpdate",location="/jsp/staffManage/staffInfoManage/updateInfo.jsp"),
		@Result(name="getKWHZD",location = "/jsp/staffManage/staffInfoManage/addStaffInfo.jsp"),
		@Result(name="toAdd",location = "/jsp/staffManage/staffInfoManage/addStaffInfo.jsp"),
		@Result(name="error",location = "/error.jsp"),
		@Result(name="selectStaffLeaves",location = "/jsp/staffManage/staffLeaveManage/staffLeaveManage.jsp"),
		@Result(name="function", type = "redirectAction",location = "staffAction!getAllStaffLeaves.action"),
		@Result(name="comeBack", type = "redirectAction",location = "staffAction!getAllStaffLeaves.action"),
		@Result(name="getAllStaffLeaves",location = "/jsp/staffManage/staffLeaveManage/staffLeaveManage.jsp"),
		@Result(name="getAllStaffsBySQId",location = "/jsp/staffManage/staffLeaveManage/addStaffLeave.jsp"),
		@Result(name="addStaffLeave", type = "redirectAction",location = "staffAction!getAllStaffLeaves.action"),
		@Result(name="updateStaffLeaveById",location = "/jsp/staffManage/staffLeaveManage/updateStaffLeave.jsp"),
		@Result(name="check",location = "/jsp/staffManage/staffInfoManage/addStaffInfo.jsp"),
		@Result(name="test", type = "redirectAction",location = "staffAction.action"),
		@Result(name="updateSave", type = "redirectAction",location = "staffAction.action"),
		@Result(name="search",location="/jsp/staffManage/staffInfoManage/staffInfoManage.jsp"),
		@Result(name="showStaffLeave",location="/jsp/staffManage/staffLeaveManage/showStaffLeaveInfo.jsp"),
		@Result(name="updateStaff",location="/jsp/staffManage/staffInfoManage/updateInfo.jsp"),
		@Result(name="addStaff", type = "redirectAction",location = "staffAction.action"),
		@Result(name="success",location="/jsp/staffManage/staffInfoManage/staffInfoManage.jsp"),
		@Result(name="showStaffInfo",location="/jsp/staffManage/staffInfoManage/showInfo.jsp"),
		@Result(name="TestErrorAddStaff", type = "redirect",location="/jsp/staffManage/staffInfoManage/addStaffInfo.jsp"),
		@Result(name="TestErrorAddStaffLeave", type = "redirect",location="/jsp/staffManage/staffLeaveManage/addStaffLeave.jsp"),
		})
public class StaffAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private StaffService staffService;	
	@Autowired
	private StaffLeaveService staffLeaveService;	
	@Autowired
	private CommunityHospitalService communityHospitalService;
	@Autowired
	private CommunityHospitalGroupService communityHospitalGroupService;
	@Autowired
	private RoleService roleService;
	@Autowired
    MaintainableAttributeService maintainableAttributeService; //可维护字段
	
	

	private int[] ids;
	private String name;
	private String staffNumber;
	private int flagThree;
	private  int flag;
	private String value;
	private String state;
	private String department;
	private TStaff staff;
	private TStaffLeave staffLeave;
	private TCommunityHospitalGroup communityHospitalGroup;
	private List<TStaffLeave> staffLeaves;
	private List<VStaffLeave> vstaffleaves;
	private int staffId;
	private List<TStaff> staffs;
	private List<StaffSpecial> staffSpecials;
	private int communityHospitalId;
	private int staffLeaveId;
	private Page<TStaff>  page;
	private String   pageHtml;
	private int  cp = 1;
	private String idcard;
	private String leaveDateHighStr;
	private Date leaveDateHigh;
	private String leaveDateLowStr;
	private Date leaveDateLow;
	private String comeBackDateHighStr;
	private Date comeBackDateHigh;
	private String comeBackDateLowStr;
	private Date comeBackDateLow;
	private int sex;
	private String comebackDateString;
	private String leaveDateString;
	private TStaffCommunite cstaff;
	//private StaffSpecial cstaff;
	private String token;
	private int sqId ;
	
    ////////////////////////////员工基本信息管理/////////////////////////////////

	public String toAdd(){
		
		token = TokenProccessor.getInstance().makeToken();//创建令牌
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
		return "toAdd";
	}
	
	/**
	 * 前台传过来一个身份证号,查看数据库是否存在,如果不存在,那么直接添加,如果存在,那么
	 * @return
	 */
	/*public String check(){
		List<TStaff> staff = staffService.getStaffByIDCardNumber(idcard);
		if(staff != null){
			if(staff.size() == 0 ){
				//staffNumber = staffService.getStaffNumber();
				return "check";
			}else{
				flag = 1; 
				//staffNumber = staffService.getStaffNumber();
			}
		}
		return "check";
	}*/
	
	/**
	 * 
	 * checkIdNum:检查身份证号是否存在 <br/> 
	 * TODO(这里描述这个方法适用条件 – 可选).<br/> 
	 * @author liufengshuang
	 * @return 
	 * @since JDK 1.8
	 */
	public String checkIdNum(){
		String json=null;
		List<TStaff> staff = staffService.getStaffByIDCardNumber(idcard);
		if(staff.size() == 0){
			 json = "{\"checkResult\":\"" +"ok"+"\"}";
		}
		else{
			 json = "{\"checkResult\":\"" +"no"+"\"}";
		}
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	// 员工信息管理的查询
	public String search(){
		int dis;
		if(flag == 0 && value == null && state == null && department == null){
			return "updateSave";//如果全部为空,那么跳转到远页面                            																						
		}
		if(value.equals("") && state.equals("")&&department.equals("")){
			return "updateSave";
		}
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
	       //获取真正的社区集团 
	   
        if(communityHosGroup!=null){//社区集团
        	communityHospitalGroup=communityHospitalGroupService.getRealComHosGroup(communityHosGroup);
        	dis=1;
        	sqId =communityHospitalGroup.getGId();
			//下面进行查询的分页
			Page page = new Page();
			page.setCurrentPage(cp);
			page.setTotalNum(staffService.countStaffBySearch(dis,flag, value, state, department, sqId));
			staffs = staffService.getStaffsBySearch(dis,flag, value, state, department, sqId,page);
			String comHos;
			String comGroup;
			staffSpecials=new ArrayList<StaffSpecial>();
			if(staffs!=null){
				for(TStaff ts:staffs){
					StaffSpecial staffSpecial=new StaffSpecial();
						int comId=staffService.getCommHospitalByStaffId(ts.getStaffId());
						comHos=communityHospitalService.getCommunityHospitalById(comId).getCommunityHospital();
						comGroup=communityHospitalService.getCommunityHospitalById(comId).getTCommunityHospitalGroup().getGroupName();
						staffSpecial.setComHos(comHos);
						staffSpecial.setComGroup(comGroup);				
						staffSpecial.setSta(ts);
						staffSpecials.add(staffSpecial);
				}
			}
			value = HtmlEscape.escapeHtml(value);
			pageHtml = page.getPage("staffAction!search.action?flag="+flag+"&value="+value+"&state="+state+"&department="+department);
			return "search";
        }
		//平台管理员是0  社区管理员返回社区医院ID的负值，员工则返回员工ID
        else{
        	dis=2;
			int a = GetSessionPerson.getPerson();  
			
			
			if(a>0){ //员工登录
				//反转义
				value = HtmlEscape.unEscapeHtml(value);
				sqId = staffService.getCommHospitalByStaffId(a);//根据员工ID获得sqId
				Page page = new Page();
				page.setCurrentPage(cp);
				page.setTotalNum(staffService.countStaffBySearch(dis,flag, value, state, department, sqId));				
				staffs = staffService.getStaffsBySearch(dis,flag, value, state, department, sqId,page);
				String comHos=communityHospitalService.getCommunityHospitalById(sqId).getCommunityHospital();
				String comGroup=communityHospitalService.getCommunityHospitalById(sqId).getTCommunityHospitalGroup().getGroupName();
				staffSpecials=new ArrayList<StaffSpecial>();
				if(staffs!=null){
					for(TStaff ts:staffs){
						StaffSpecial staffSpecial=new StaffSpecial();				
						staffSpecial.setComHos(comHos);
						staffSpecial.setComGroup(comGroup);				
						staffSpecial.setSta(ts);
						staffSpecials.add(staffSpecial);
					}
				}
				//转义
				value = HtmlEscape.escapeHtml(value);
				pageHtml = page.getPage("staffAction!search.action?flag="+flag+"&value="+value+"&state="+state+"&department="+department);
				return "search";
			}else if(a < 0){  //社区管理员登录 
				sqId = -a;
				//下面进行查询的分页
				Page page = new Page();
				page.setCurrentPage(cp);
				page.setTotalNum(staffService.countStaffBySearch(dis,flag, value, state, department, sqId));
				staffs = staffService.getStaffsBySearch(dis,flag, value, state, department, sqId,page);
				String comHos=communityHospitalService.getCommunityHospitalById(sqId).getCommunityHospital();
				String comGroup=communityHospitalService.getCommunityHospitalById(sqId).getTCommunityHospitalGroup().getGroupName();
				staffSpecials=new ArrayList<StaffSpecial>();
				if(staffs!=null){
					for(TStaff ts:staffs){
						StaffSpecial staffSpecial=new StaffSpecial();				
						staffSpecial.setComHos(comHos);
						staffSpecial.setComGroup(comGroup);				
						staffSpecial.setSta(ts);
						staffSpecials.add(staffSpecial);
					}
				}
				value = HtmlEscape.escapeHtml(value);
				pageHtml = page.getPage("staffAction!search.action?flag="+flag+"&value="+value+"&state="+state+"&department="+department);
				return "search";
			}else{  //系统管理员登录
				Page page = new Page();
				page.setCurrentPage(cp);
				page.setTotalNum(staffService.countStaffBySearch(flag, value, state, department));
				staffs = staffService.getStaffBySearch(flag, value, state, department);
				String comHos;
				String comGroup;
				staffSpecials=new ArrayList<StaffSpecial>();
				if(staffs!=null){
					for(TStaff ts:staffs){
						StaffSpecial staffSpecial=new StaffSpecial();
							int comId=staffService.getCommHospitalByStaffId(ts.getStaffId());
							comHos=communityHospitalService.getCommunityHospitalById(comId).getCommunityHospital();
							comGroup=communityHospitalService.getCommunityHospitalById(comId).getTCommunityHospitalGroup().getGroupName();
							staffSpecial.setComHos(comHos);
							staffSpecial.setComGroup(comGroup);				
							staffSpecial.setSta(ts);
							staffSpecials.add(staffSpecial);
					}
				}
				value = HtmlEscape.escapeHtml(value);
				pageHtml = page.getPage("staffAction!search.action?flag="+flag+"&value="+value+"&state="+state+"&department="+department);
			}			
        }
        return "search";
	}
	
	
	//默认方法, 用于查询员工信息   员工信息的展示 
	public String execute(){
		//平台管理员是0  社区管理员返回社区医院ID的负值，员工则返回员工ID
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
       
        
		if(communityHosGroup!=null){//社区集团
			//获取真正的社区集团 
	        communityHospitalGroup=communityHospitalGroupService.getRealComHosGroup(communityHosGroup);
			sqId=communityHospitalGroup.getGId();	
			Page<TStaff> page = new Page<TStaff>();
			page.setCurrentPage(cp);
			page.setTotalNum(staffService.countStaffByCommGroupHospitalId(sqId));
			staffs=staffService.getStaffByCommGroupHospitalId(sqId,page);//得到所有的员工
			staffSpecials=new ArrayList<StaffSpecial>();
			String comHos;
			String comGroup;
			if(staffs!=null){
				for(TStaff ts:staffs){
					StaffSpecial staffSpecial=new StaffSpecial();
						int comId=staffService.getCommHospitalByStaffId(ts.getStaffId());
						comHos=communityHospitalService.getCommunityHospitalById(comId).getCommunityHospital();
						comGroup=communityHospitalService.getCommunityHospitalById(comId).getTCommunityHospitalGroup().getGroupName();
						staffSpecial.setComHos(comHos);
						staffSpecial.setComGroup(comGroup);				
						staffSpecial.setSta(ts);
						staffSpecials.add(staffSpecial);
				}
			}
			pageHtml = page.getPage("staffAction.action");
		}
		else{
			int a = GetSessionPerson.getPerson();  
			
			if(a > 0){ //员工登录
				//根据员工ID获得sqId
				sqId = staffService.getCommHospitalByStaffId(a);
				Page<TStaff> page = new Page<TStaff>();
				page.setCurrentPage(cp);
				page.setTotalNum(staffService.countStaffByCommunityHospitalId(sqId));
				staffs = staffService.getStaffByCommunityHospitalId(sqId,page);			
				String comHos=communityHospitalService.getCommunityHospitalById(sqId).getCommunityHospital();
				String comGroup=communityHospitalService.getCommunityHospitalById(sqId).getTCommunityHospitalGroup().getGroupName();
				staffSpecials=new ArrayList<StaffSpecial>();
				if(staffs!=null){
					for(TStaff ts:staffs){
						StaffSpecial staffSpecial=new StaffSpecial();				
						staffSpecial.setComHos(comHos);
						staffSpecial.setComGroup(comGroup);				
						staffSpecial.setSta(ts);
						staffSpecials.add(staffSpecial);
					}
				}
				pageHtml = page.getPage("staffAction.action");
			}else if(a < 0){ //社区管理员登录,社区管理员只管理一个医院
				sqId = -a;
				Page<TStaff> page = new Page<TStaff>();
				page.setCurrentPage(cp);
				page.setTotalNum(staffService.countStaffByCommunityHospitalId(sqId));
				staffs = staffService.getStaffByCommunityHospitalId(sqId,page);
				String comHos=communityHospitalService.getCommunityHospitalById(sqId).getCommunityHospital();
				String comGroup=communityHospitalService.getCommunityHospitalById(sqId).getTCommunityHospitalGroup().getGroupName();
				staffSpecials=new ArrayList<StaffSpecial>();
				if(staffs!=null){
					for(TStaff ts:staffs){
						StaffSpecial staffSpecial=new StaffSpecial();				
						staffSpecial.setComHos(comHos);
						staffSpecial.setComGroup(comGroup);				
						staffSpecial.setSta(ts);
						staffSpecials.add(staffSpecial);
					}
				}
				pageHtml = page.getPage("staffAction.action");
			}else{  //系统管理员登录
				Page<TStaff> page = new Page<TStaff>();
				page.setCurrentPage(cp);
				page.setTotalNum(staffService.countStaff());
				staffs = staffService.getStaffByPage(page);
				String comHos;
				String comGroup;
				staffSpecials=new ArrayList<StaffSpecial>();
				if(staffs!=null){
					for(TStaff ts:staffs){
						StaffSpecial staffSpecial=new StaffSpecial();
							int comId=staffService.getCommHospitalByStaffId(ts.getStaffId());
							comHos=communityHospitalService.getCommunityHospitalById(comId).getCommunityHospital();
							comGroup=communityHospitalService.getCommunityHospitalById(comId).getTCommunityHospitalGroup().getGroupName();
							staffSpecial.setComHos(comHos);
							staffSpecial.setComGroup(comGroup);				
							staffSpecial.setSta(ts);
							staffSpecials.add(staffSpecial);
					}
				}
				pageHtml = page.getPage("staffAction.action");
			 }		
		}
		return SUCCESS;
	}
		
/**
 * 名字就不改了.....这个是员工信息管理里面的
 * @return
 * @throws Exception
 */
	public String test() throws Exception{
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
		if(communityHosGroup!=null){//社区集团
			return "error";
		}
		else{
			//平台管理员是0  社区管理员返回社区医院ID的负值，员工则返回员工ID
	
			int a = GetSessionPerson.getPerson();  
			
			//判断flag --- 1打印    2导出   3删除
			if(flag == 1){ //导出全部
				List<StaffExport> exportstaffs = new ArrayList<StaffExport>();
				if(a>0){//员工
					sqId = staffService.getCommHospitalByStaffId(a);//根据员工ID获得sqId
					staffs = staffService.getStaffByCommunityHospitalId(sqId);
				}else if(a<0){//社区负责人
					sqId = -a;
					staffs = staffService.getStaffByCommunityHospitalId(sqId);
				}else{//平台管理员
					staffs = staffService.getAllStaff();
				}
				staffs = staffService.getStaffByCommunityHospitalId(sqId);//这里也是先取出社区Id,然后取出所有的员工信息
				if(staffs != null){
					for(TStaff staff : staffs){
						StaffExport sp = new StaffExport(staff);
						exportstaffs.add(sp);
					}
				}
				StaffExport sp = new StaffExport();
				String[] titles = sp.getTitles() ;
				JxlExcel jxl = new JxlExcel(titles);
				HttpServletResponse response = ServletActionContext.getResponse();
				String  filename = new String("staffLeaveInfo".getBytes("UTF-8"), "ISO8859-1");  
				response.setHeader("content-disposition", "attachment;filename="+filename+".xls");
				ServletOutputStream output = response.getOutputStream();
				jxl.write(exportstaffs, output);
				response.flushBuffer();
				return null;
			}
			if(flag==2){ //导出本页
				List<StaffExport> staffs = new ArrayList<StaffExport>();
				if(ids != null){
					for(int i = 0; i<ids.length; i++){
						TStaff st = staffService.getStaffById(ids[i]);
						if(st != null){
							StaffExport sp = new StaffExport(st);
							staffs.add(sp);
						}
					}
				}
				StaffExport sp = new StaffExport();
				String[] titles = sp.getTitles() ;
				JxlExcel jxl = new JxlExcel(titles);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setHeader("content-disposition", "attachment;filename="+"staffInfo"+".xls");
				ServletOutputStream output = response.getOutputStream();
				jxl.write(staffs, output);
				response.flushBuffer();
				return null;
			}
			//因为是一个请求一个相应,如果是一个下载请求,应该返回null,在用action 里返回json 数据时，不能return SUCCESS ，必须return null 否则报此错误!
			return "test";
		}
	}


	/**
	 * 显示一个员工的信息
	 * @return
	 * @throws Exception
	 */
	public String showStaffInfo() throws Exception{
		
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
        
        if(communityHosGroup!=null){//社区集团
        	//获取真正的社区集团 
            communityHospitalGroup=communityHospitalGroupService.getRealComHosGroup(communityHosGroup);
	        int gid=communityHospitalGroup.getGId();
	        int comId = staffService.getCommHospitalByStaffId(staffId);//通过员工id获取社区id
	        int staffSQId=communityHospitalService.getCommunityHospitalById(comId).getTCommunityHospitalGroup().getGId();
			if(staffSQId != gid){
				return "error";//跳错误页面
			}else{
				
				cstaff = new TStaffCommunite();
				//获得员工实体
				staff = staffService.getStaffById(staffId);
				//获得社区实体
				TCommunityHospital c = communityHospitalService.getCommunityHospitalById(comId);
				cstaff.setStaff(staff);
				cstaff.setCommName(c.getCommunityHospital());
			}
         
        }
        else{
			//平台管理员是0  社区管理员返回社区医院ID的负值，员工则返回员工ID
	
			int a = GetSessionPerson.getPerson();  
			
			//需要看一下当前管理员Id和员工所在的社区是否相同,相同才会去显示
			if(a > 0){ //员工登录
				int staffSQId = staffService.getCommHospitalByStaffId(staffId);
				if(staffSQId != staffService.getCommHospitalByStaffId(a)){
					return "error";//跳错误页面
				}else{
					cstaff = new TStaffCommunite();
					staff = staffService.getStaffById(staffId);
					//获得社区实体
					TCommunityHospital c = communityHospitalService.getCommunityHospitalById(staffSQId);
					cstaff.setStaff(staff);
					cstaff.setCommName(c.getCommunityHospital());
				}
			}else if(a < 0){ //社区管理员
				int staffSQId = staffService.getCommHospitalByStaffId(staffId);
				if(staffSQId != -a){
					return "error";//跳错误页面
				}else{
					cstaff = new TStaffCommunite();
					//获得员工实体
					staff = staffService.getStaffById(staffId);
					//获得社区实体
					TCommunityHospital c = communityHospitalService.getCommunityHospitalById(staffSQId);
					cstaff.setStaff(staff);
					cstaff.setCommName(c.getCommunityHospital());
				}
			}else{ //平台管理员
				cstaff = new TStaffCommunite();
				int staffSQId = staffService.getCommHospitalByStaffId(staffId);
				staff = staffService.getStaffById(staffId);
				TCommunityHospital c = communityHospitalService.getCommunityHospitalById(staffSQId);
				cstaff.setStaff(staff);
				cstaff.setCommName(c.getCommunityHospital());
				
			}
        }
		return "showStaffInfo";
	}
	
	/**
	 * 添加员工基本信息实体
	 * @return
	 */
	public  String addStaff(){
		
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
        
        if(communityHosGroup!=null){//社区集团
        	return "error";
        }
        else{
			//平台管理员是0  社区管理员返回社区医院ID的负值，员工则返回员工ID
	
			int a = GetSessionPerson.getPerson();  
			
			//-1.后台校验, input框输入:
			if(staff != null){
				String idcard = staff.getIdCardNum();
				String phone = staff.getPhone();
				String name = staff.getName();
				String job = staff.getJob();
				String professional = staff.getProfessional();
				String graduateSchool = staff.getGraduateSchool();
				if(idcard == null || phone == null || name ==null || job == null || professional == null || graduateSchool == null){
					return "TestErrorAddStaff";
				}
				if(idcard == "" || phone == "" || name =="" || job == "" || professional == "" || graduateSchool == ""){
					return "TestErrorAddStaff";
				}
				if(idcard.equals("") || phone.equals("") || name.equals("") || job.equals("") || professional.equals("") || graduateSchool.equals("")){
					return "TestErrorAddStaff";
				}
				//得到当前社区ID
				int sqId ;
				if(a>0){
					sqId = staffService.getCommHospitalByStaffId(a);
				}else if(a < 0){
					sqId = -a;
				}else{
					sqId = staffService.getCommHospitalByStaffId(a);
				}
				
				HttpServletRequest request=ServletActionContext.getRequest();
				boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
				if(b==true){
					return "addStaff";  //重定向回首页
				}
				request.getSession().removeAttribute("token");//移除session中的token
				
				if(flag == 1){
					
					//如果已经存在,那么将原来的职工状态改为离职,
					//2 取得身份证号相同的实体
					List<TStaff> sts = staffService.getStaffByIDCardNumber(staff.getIdCardNum());
									
					//遍历得到的实体
					for(TStaff st: sts){
						//3.得到该实体的社区ID
						int staffSQID = staffService.getCommHospitalByStaffId(st.getStaffId());
						if(staffSQID == sqId){//4.如果是当前社区的,更新实体
							staff = this.update(st, staff);
							staffService.updateStaff(staff);
						}else{//5.如果不是当前社区的实体,将其他的状态改为离职
							st.setState(""+StaffState.lizhi.getvalue());
							staffService.updateStaff(st);
						}
					}
				}else{//检查中没有这个身份证号
					staffNumber = staffService.getStaffNumber();
					staff.setStaffNumber(staffNumber);
					staff.setOperateState(OperatorState.qiyong.getvalue());
					staffService.saveStaff(staff, sqId);
				}
				return "addStaff";
			}else{
				return "error";
			}
        }
	}
	
	/**
	 * 用于更新员工基本信息后的保存
	 * @return
	 */
	public String updateSave(){
		
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
        
        if(communityHosGroup!=null){//社区集团
        	return "error";
        }
        else{
			//平台管理员是0  社区管理员返回社区医院ID的负值，员工则返回员工ID
			int a = GetSessionPerson.getPerson();  
			
			int id = staff.getStaffId();
			if(staff != null){
				String idcard = staff.getIdCardNum();
				String phone = staff.getPhone();
				String name = staff.getName();
				String job = staff.getJob();
				String professional = staff.getProfessional();
				String graduateSchool = staff.getGraduateSchool();
				if(idcard == null || phone == null || name ==null || job == null || professional == null || graduateSchool == null){
					return "error";
				}
				if(idcard == "" || phone == "" || name =="" || job == "" || professional == "" || graduateSchool == ""){
					return "error";
				}
				if(idcard.equals("") || phone.equals("") || name.equals("") || job.equals("") || professional.equals("") || graduateSchool.equals("")){
					return "error";
				}
			}
			int sqID = staffService.getCommHospitalByStaffId(id);
			if(a == 0){
				TStaff former = staffService.getStaffById(id);
				staff = this.update(former, staff);
				staffService.updateStaff(staff);
			}else if(a > 0){//员工
				int sq = staffService.getCommHospitalByStaffId(a);
				if(sq == sqID ){
					TStaff former = staffService.getStaffById(id);
					staff = this.update(former, staff);
					staffService.updateStaff(staff);
				}else{
					return "error";
				}
			}else{//社区管理员
				int sq = -a;
				if(sq == sqID ){
					TStaff former = staffService.getStaffById(id);
					staff = this.update(former, staff);
					staffService.updateStaff(staff);
				}else{
					return "error";
				}
			}
			return "updateSave";
        }
	}
	
	/**
	 * 修改员工基本信息
	 * @return
	 */
	public String updateStaff(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
        
        if(communityHosGroup!=null){//社区集团
        	return "error";
        }
        else{
			//平台管理员是0  社区管理员返回社区医院ID的负值，员工则返回员工ID
			int a = GetSessionPerson.getPerson();  
	
			int sqID = staffService.getCommHospitalByStaffId(staffId);
			if(a == 0){
				staff = staffService.getStaffById(staffId);
			}else if(a > 0){ //  a>0
				if(staffService.getCommHospitalByStaffId(a) == sqID ){
					staff = staffService.getStaffById(staffId);
				}else{
					return "error";
				}
			}else {//  a < 0
				int sq = -a;
				if(sq == sqID ){
					staff = staffService.getStaffById(staffId);
				}else{
					return "error";
				}
			}
			return "updateStaff";
        }
	}
	
	/**
	 * 管理员删除员工
	 * @return
	 */
	public String deleteStaff(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
        
        if(communityHosGroup!=null){//社区集团
        	return "error";
        }
        else{
			//平台管理员是0  社区管理员返回社区医院ID的负值，员工则返回员工ID
			int a = GetSessionPerson.getPerson();  
			
			int sqID = staffService.getCommHospitalByStaffId(staffId);
			if(a == 0){
				staffService.deleteStaffById(staffId);
			}else if(a > 0){
				if(staffService.getCommHospitalByStaffId(a) == sqID ){
					staffService.deleteStaffById(staffId);
				}else{
					return "error";
				}
			}else{ //a<0
				int sq = -a;
				if(sq == sqID ){
					staffService.deleteStaffById(staffId);
				}else{
					return "error";
				}
			}
			return "updateSave";
        }
	}
	/**
	 * 通过社区Id得到所有的员工
	 * @return
	 */
	public String getAllStaffsBySQId(){


		//平台管理员是0  社区管理员返回社区医院ID的负值，员工则返回员工ID
		int a = GetSessionPerson.getPerson();  
		 
		int sqId = -1;
			if(a <0){
				sqId = Math.abs(a);
				
			}else if(a > 0){
				sqId = staffService.getCommHospitalByStaffId(a);
			}
		staffs = staffService.getStaffByCommunityHospitalId(sqId);
		token = TokenProccessor.getInstance().makeToken();//创建令牌
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)

		return "getAllStaffsBySQId";
	}
	
	
	
	///////////////////////////////////////员工请假管理////////////////////////////////////////
	/**
	 * 用于员工请假管理的1打印,3导出全部,2导出本页
	 * @return
	 */
	public String function() throws Exception{

		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
        
        if(communityHosGroup!=null){//社区集团
        	return "error";
        }
        else{
			//平台管理员是0  社区管理员返回社区医院ID的负值，员工则返回员工ID
			int a = GetSessionPerson.getPerson();  
			
			if(flag == 1){
				return "error";
			}
			if(flag == 2){//导出本页
				List<StaffLeaveExport> staffLeaves = new ArrayList<StaffLeaveExport>();
				String [] titles = (new StaffLeaveExport()).getTitles();
				if(ids != null){
					for(int i = 0; i<ids.length; i++){
						TStaffLeave staffLeave = staffLeaveService.getStaffLeaveById(ids[i]);
						StaffLeaveExport sle = new StaffLeaveExport(staffLeave);
						staffLeaves.add(sle);
					}
				}
				JxlExcel jxl = new JxlExcel(titles);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setHeader("content-disposition", "attachment;filename="+"staffLeaveInfo"+".xls");
				ServletOutputStream output = response.getOutputStream();
				jxl.write(staffLeaves, output);
				response.flushBuffer();
				
				return null;	
			}
			if(flag == 3){//导出全部
				List<StaffLeaveExport> staffLeaves = new ArrayList<StaffLeaveExport>();
				if(a == 0){
					String [] titles = (new StaffLeaveExport()).getTitles();
					List<VStaffLeave> vs = staffLeaveService.getStaffLeavesByCommunityHospitalId(-1);
					for(VStaffLeave VV: vs){
						StaffLeaveExport sle = new StaffLeaveExport(VV);
						staffLeaves.add(sle);
					}
					JxlExcel jxl = new JxlExcel(titles);
					HttpServletResponse response = ServletActionContext.getResponse();
					response.setHeader("content-disposition", "attachment;filename="+"staffLeaveInfo"+".xls");
					ServletOutputStream output = response.getOutputStream();
					jxl.write(staffLeaves, output);
					response.flushBuffer();
				}else if (a <0){
					int sqId = Math.abs(a);
					String [] titles = (new StaffLeaveExport()).getTitles();
					List<VStaffLeave> vs = staffLeaveService.getStaffLeavesByCommunityHospitalId(sqId);
					for(VStaffLeave VV: vs){
						StaffLeaveExport sle = new StaffLeaveExport(VV);
						staffLeaves.add(sle);
					}
					JxlExcel jxl = new JxlExcel(titles);
					HttpServletResponse response = ServletActionContext.getResponse();
					response.setHeader("content-disposition", "attachment;filename="+"staffLeaveInfo"+".xls");
					ServletOutputStream output = response.getOutputStream();
					jxl.write(staffLeaves, output);
					response.flushBuffer();
				}else{
					int sqId = staffService.getCommHospitalByStaffId(a);
					String [] titles = (new StaffLeaveExport()).getTitles();
					List<VStaffLeave> vs = staffLeaveService.getStaffLeavesByCommunityHospitalId(sqId);
					for(VStaffLeave VV: vs){
						StaffLeaveExport sle = new StaffLeaveExport(VV);
						staffLeaves.add(sle);
					}
					JxlExcel jxl = new JxlExcel(titles);
					HttpServletResponse response = ServletActionContext.getResponse();
					response.setHeader("content-disposition", "attachment;filename="+"staffLeaveInfo"+".xls");
					ServletOutputStream output = response.getOutputStream();
					jxl.write(staffLeaves, output);
					response.flushBuffer();
				}
				return null;	
			}else{
				return SUCCESS;
			}
        }
	}
	
	/**
	 * 查询员工请假
	 * @return
	 */
	public String selectStaffLeaves(){
		
		
		//将字符串转成
		if(comeBackDateLowStr != null){
			if(comeBackDateLowStr != "" || comeBackDateLowStr.equals("")){
				comeBackDateLow = TypeConverter.convertString2Date(comeBackDateLowStr, "yyyy-MM-dd");
			}
		}
		if(comeBackDateHighStr != null){
			if(comeBackDateHighStr != "" || comeBackDateHighStr.equals("")){
				comeBackDateHigh = TypeConverter.convertString2Date(comeBackDateHighStr, "yyyy-MM-dd");
			}
		}
		if(leaveDateLowStr != null){
			if(leaveDateLowStr != "" || leaveDateLowStr.equals("")){
				leaveDateLow = TypeConverter.convertString2Date(leaveDateLowStr, "yyyy-MM-dd");
			}
		}
		if(leaveDateHighStr != null){
			if(leaveDateHighStr != "" || leaveDateHighStr.equals("")){
				leaveDateHigh = TypeConverter.convertString2Date(leaveDateHighStr, "yyyy-MM-dd");
			}
		}
		
		int flag;
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
		if(communityHosGroup!=null){//社区集团
			communityHospitalGroup=communityHospitalGroupService.getRealComHosGroup(communityHosGroup);
			flag=1;
			int gid=communityHospitalGroup.getGId();
			//int sqId = staffService.getCommHospitalByStaffId(a) ;
			String staffNumber = "";
			String staffName="";
			String comHos="";
			if(flagThree == 1){
				
			}else if(flagThree == 2){
				staffName=value;
			}else if(flagThree == 3){
				staffNumber = value;
			}else if(flagThree == 6){
				comHos = value;
			}
			Page<VStaffLeave> page = new Page<VStaffLeave>();
			page.setTotalNum(staffLeaveService.countStaffLeaveBySearch(flag,staffNumber, staffName,comHos,leaveDateHigh, leaveDateLow,comeBackDateHigh, comeBackDateLow, gid));//!!!这个要在session中取值
			page.setCurrentPage(cp);
			vstaffleaves = staffLeaveService.getStaffLeaveBySearch(flag,staffNumber, staffName,comHos, leaveDateHigh, leaveDateLow,comeBackDateHigh, comeBackDateLow, gid, page);
			//将时间转换为字符串
			if(leaveDateHigh != null){
				leaveDateHighStr = TypeConverter.dateFormat(leaveDateHigh);
			}else{
				leaveDateHighStr="";
			}
			if(leaveDateLow != null){
				leaveDateLowStr = TypeConverter.dateFormat(leaveDateLow);
			}else{
				leaveDateLowStr="";
			}
			if(comeBackDateHigh != null){
				comeBackDateHighStr = TypeConverter.dateFormat(comeBackDateHigh);
			}else{
				comeBackDateHighStr="";
			}
			if(comeBackDateLow != null){
				comeBackDateLowStr = TypeConverter.dateFormat(comeBackDateLow);
			}else{
				comeBackDateLowStr="";
			}
			pageHtml = page.getPage("staffAction!selectStaffLeaves.action?flagThree="+flagThree+"&value="+value);
		}
		else{
			flag=2;
			//平台管理员是0  社区管理员返回社区医院ID的负值，员工则返回员工ID
			int a = GetSessionPerson.getPerson();  
			if(a == 0){//这里的写系统管理员的查询
				String staffNumber = "";
				String staffName="";
				String comHos="";
				if(flagThree == 1){
					
				}else if(flagThree == 2){
					staffName=value;
				}else if(flagThree == 3){
					staffNumber = value;
				}
				else if(flagThree == 6){
					comHos = value;
				}
				Page<VStaffLeave> page = new Page<VStaffLeave>();
			//	page.setTotalNum(staffLeaveService.countStaffLeaveBySearch(staffNumber, staffName,leaveDateHigh, leaveDateLow,comeBackDateHigh, comeBackDateLow, -1));//!!!这个要在session中取值
				page.setCurrentPage(cp);
				vstaffleaves = staffLeaveService.getStaffLeaveBySearch(flag,staffNumber, staffName,comHos, leaveDateHigh, leaveDateLow,comeBackDateHigh, comeBackDateLow,-1, page);
				page.setTotalNum(vstaffleaves.size());
				pageHtml = page.getPage("staffAction!selectStaffLeaves.action?flagThree="+flagThree+"&value="+value+"&leaveDateHighStr="+leaveDateHighStr+"&leaveDateLowStr="+leaveDateLow+"&comeBackDateHighStr="+comeBackDateHighStr+"&comeBackDateLowStr"+comeBackDateLowStr);	
			}else if(a<0){ //社区管理员的员工的查询
				int sqId = Math.abs(a);
				String staffNumber = "";
				String staffName="";
				String comHos="";
				if(flagThree == 1){
					
				}else if(flagThree == 2){
					staffName=value;
				}else if(flagThree == 3){
					staffNumber = value;
				}
				else if(flagThree == 6){
					comHos = value;
				}
				Page<VStaffLeave> page = new Page<VStaffLeave>();
				page.setTotalNum(staffLeaveService.countStaffLeaveBySearch(flag,staffNumber, staffName,comHos, leaveDateHigh, leaveDateLow,comeBackDateHigh, comeBackDateLow, sqId));//!!!这个要在session中取值
				page.setCurrentPage(cp);
				vstaffleaves = staffLeaveService.getStaffLeaveBySearch(flag,staffNumber, staffName,comHos, leaveDateHigh, leaveDateLow,comeBackDateHigh, comeBackDateLow, sqId, page);
				//将时间转换为字符串
				if(leaveDateHigh != null){
					leaveDateHighStr = TypeConverter.dateFormat(leaveDateHigh);
				}else{
					leaveDateHighStr="";
				}
				if(leaveDateLow != null){
					leaveDateLowStr = TypeConverter.dateFormat(leaveDateLow);
				}else{
					leaveDateLowStr="";
				}
				if(comeBackDateHigh != null){
					comeBackDateHighStr = TypeConverter.dateFormat(comeBackDateHigh);
				}else{
					comeBackDateHighStr="";
				}
				if(comeBackDateLow != null){
					comeBackDateLowStr = TypeConverter.dateFormat(comeBackDateLow);
				}else{
					comeBackDateLowStr="";
				}
				pageHtml = page.getPage("staffAction!selectStaffLeaves.action?flagThree="+flagThree+"&value="+value);
			}else{
				int sqId = staffService.getCommHospitalByStaffId(a) ;
				String staffNumber = "";
				String staffName="";
				String comHos="";
				if(flagThree == 1){
					
				}else if(flagThree == 2){
					staffName=value;
				}else if(flagThree == 3){
					staffNumber = value;
				}
				else if(flagThree == 6){
					comHos = value;
				}
				Page<VStaffLeave> page = new Page<VStaffLeave>();
				page.setTotalNum(staffLeaveService.countStaffLeaveBySearch(flag,staffNumber, staffName,comHos,leaveDateHigh, leaveDateLow,comeBackDateHigh, comeBackDateLow, sqId));//!!!这个要在session中取值
				page.setCurrentPage(cp);
				vstaffleaves = staffLeaveService.getStaffLeaveBySearch(flag,staffNumber, staffName,comHos, leaveDateHigh, leaveDateLow,comeBackDateHigh, comeBackDateLow, sqId, page);
				//将时间转换为字符串
				if(leaveDateHigh != null){
					leaveDateHighStr = TypeConverter.dateFormat(leaveDateHigh);
				}else{
					leaveDateHighStr="";
				}
				if(leaveDateLow != null){
					leaveDateLowStr = TypeConverter.dateFormat(leaveDateLow);
				}else{
					leaveDateLowStr="";
				}
				if(comeBackDateHigh != null){
					comeBackDateHighStr = TypeConverter.dateFormat(comeBackDateHigh);
				}else{
					comeBackDateHighStr="";
				}
				if(comeBackDateLow != null){
					comeBackDateLowStr = TypeConverter.dateFormat(comeBackDateLow);
				}else{
					comeBackDateLowStr="";
				}
				pageHtml = page.getPage("staffAction!selectStaffLeaves.action?flagThree="+flagThree+"&value="+value);
			}
		}
		return "selectStaffLeaves";
		
	}
	
	//用于员工请假的销假
	public String comeBack(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
        
        if(communityHosGroup!=null){//社区集团
        	return "error";
        }
        else{
			//平台管理员是0  社区管理员返回社区医院ID的负值，员工则返回员工ID
			int a = GetSessionPerson.getPerson();  
			
			staffLeave = staffLeaveService.getStaffLeaveById(staffLeaveId);
			if(staffLeave!= null ){
				int SQID = staffService.getCommHospitalByStaffId(staffLeave.getTStaff().getStaffId());
				if(a == 0){//平台管理员
					staffLeaveService.comeBack(staffLeaveId);
				}else if(a<0){  
					if(Math.abs(a) == SQID){//判断当前 社区ID 与  被操作者 的社区ID 是否相同
						staffLeaveService.comeBack(staffLeaveId);
					}else{
						return "error";
					}
				}else{
					if(staffService.getCommHospitalByStaffId(a) == SQID){
						staffLeaveService.comeBack(staffLeaveId);
					}else{
						return "error";
					}
				}
			}else{
				return "error";
			}
			return "comeBack";
        }
	}
	
	
	/**
	 * 得到所有的员工请假,用于一开始的显示
	 * @return
	 */
	public String getAllStaffLeaves() {
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(communityHosGroup!=null){//社区集团
        	communityHospitalGroup=communityHospitalGroupService.getRealComHosGroup(communityHosGroup);
        	int sqId=communityHospitalGroup.getGId();
			Page<VStaffLeave> page = new Page<VStaffLeave>();
			page.setTotalNum(staffLeaveService.countStaffLeaveGroupByCommunityHospitalId(sqId));
			page.setCurrentPage(cp);
			vstaffleaves = staffLeaveService.getVStaffLeaveGroupBycommunityHospitalId(sqId, page);
			pageHtml = page.getPage("staffAction!getAllStaffLeaves.action");
        }
        else{
		//平台管理员是0  社区管理员返回社区医院ID的负值，员工则返回员工ID
			int a = GetSessionPerson.getPerson();  
			
			if(a == 0){//系统管理员
				Page<VStaffLeave> page = new Page<VStaffLeave>();
				page.setTotalNum(staffLeaveService.countStaffLeave());
				page.setCurrentPage(cp);
				vstaffleaves = staffLeaveService.getAllStaffLeave(page);
				pageHtml = page.getPage("staffAction!getAllStaffLeaves.action");
			}else if(a<0){ //非社区管理员
				int sqId = Math.abs(a);
				Page<VStaffLeave> page = new Page<VStaffLeave>();
				page.setTotalNum(staffLeaveService.countStaffLeaveByCommunityHospitalId(sqId));//!!!这个要在session中取值
				page.setCurrentPage(cp);
				vstaffleaves = staffLeaveService.getVStaffLeaveBycommunityHospitalId(sqId,page);
				pageHtml = page.getPage("staffAction!getAllStaffLeaves.action");
			}else{//a>0
				int sqId = staffService.getCommHospitalByStaffId(a);
				Page<VStaffLeave> page = new Page<VStaffLeave>();
				page.setTotalNum(staffLeaveService.countStaffLeaveByCommunityHospitalId(sqId));//!!!这个要在session中取值
				page.setCurrentPage(cp);
				vstaffleaves = staffLeaveService.getVStaffLeaveBycommunityHospitalId(sqId,page);
				pageHtml = page.getPage("staffAction!getAllStaffLeaves.action");
			}
        }
		token = TokenProccessor.getInstance().makeToken();//创建令牌
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
		return "getAllStaffLeaves";
	}
	
	/**
	 * 通过员工请假Id得到实体
	 * @return
	 */
	public String updateStaffLeaveById(){

		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
        
        if(communityHosGroup!=null){//社区集团
        	return "error";
        }
        else{
			//平台管理员是0  社区管理员返回社区医院ID的负值，员工则返回员工ID
			int a = GetSessionPerson.getPerson();  
			
			staffLeave = staffLeaveService.getStaffLeaveById(staffLeaveId);
			int staffId = staffLeave.getTStaff().getStaffId();
			int ss = staffService.getCommHospitalByStaffId(staffId);
			if(a == 0){//管理员修改
				
			}else if(a < 0){
				if(Math.abs(a) != ss){ //如果社区不符,那么,清空
					staffLeave = null;
					return "error";
				}
			}else{
				int sqId = staffService.getCommHospitalByStaffId(a);
				if(sqId != ss){ //如果社区不符,那么,清空
					staffLeave = null;
					return "error";
				}
			}
			return "updateStaffLeaveById";
        }
	}
	
	/**
	 * 更新后保存
	 * @return
	 */
	public String updateStaffLeaveSave(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
        
        if(communityHosGroup!=null){//社区集团
        	return "error";
        }
        else{
			//平台管理员是0  社区管理员返回社区医院ID的负值，员工则返回员工ID
			int a = GetSessionPerson.getPerson();  
			
			TStaffLeave former = staffLeaveService.getStaffLeaveById(staffLeave.getStaffLeaveId());
			if(a == 0){//管理员修改
				if(former != null){
					if(staffLeave.getLeaveDate() != null ){
						former.setLeaveDate(staffLeave.getLeaveDate());
					}
					if(staffLeave.getDays() != null ){
						former.setDays(staffLeave.getDays());
					}
					if(staffLeave.getLeaveReason() != null || !staffLeave.getLeaveReason().equals("")){
						former.setLeaveReason(staffLeave.getLeaveReason());
					}
					if(staffLeave.getNote() != null || !staffLeave.getNote().equals("")){
						former.setNote(staffLeave.getNote());
					}
				}else{
					return "error";
				}
			}else if(a<0){//非管理员修改
				if(former != null){
					if(Math.abs(a) == staffService.getCommHospitalByStaffId(former.getTStaff().getStaffId())){
						if(staffLeave.getLeaveDate() != null ){
							former.setLeaveDate(staffLeave.getLeaveDate());
						}
						if(staffLeave.getDays() != null ){
							former.setActualDays(staffLeave.getDays());
						}
						if(staffLeave.getLeaveReason() != null || !staffLeave.getLeaveReason().equals("")){
							former.setLeaveReason(staffLeave.getLeaveReason());
						}
						if(staffLeave.getNote() != null || !staffLeave.getNote().equals("")){
							former.setNote(staffLeave.getNote());
						}
					}else{
						return "error";
					}
				}
			}else{ //A>0
				if(former != null){
					if(staffService.getCommHospitalByStaffId(a) == staffService.getCommHospitalByStaffId(former.getTStaff().getStaffId())){
						if(staffLeave.getLeaveDate() != null ){
							former.setLeaveDate(staffLeave.getLeaveDate());
						}
						if(staffLeave.getDays() != null ){
							former.setActualDays(staffLeave.getDays());
						}
						if(staffLeave.getLeaveReason() != null || !staffLeave.getLeaveReason().equals("")){
							former.setLeaveReason(staffLeave.getLeaveReason());
						}
						if(staffLeave.getNote() != null || !staffLeave.getNote().equals("")){
							former.setNote(staffLeave.getNote());
						}
					}else{
						return "error";
					}
				}
			}
			staffLeaveService.updateStaffLeave(former);
			return "function";
        }
	}
	
	/**
	 * 用户获得员工请假实体
	 * @return
	 */
	public String showStaffLeave(){
		staffLeave = staffLeaveService.getStaffLeaveById(staffLeaveId);
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
		if(communityHosGroup!=null){//社区集团
			if(staffLeave != null){
				communityHospitalGroup=communityHospitalGroupService.getRealComHosGroup(communityHosGroup);
				int SQID = staffService.getCommHospitalByStaffId(staffLeave.getTStaff().getStaffId());//获取社区医院id
				int gid=communityHospitalGroup.getGId();
				int hgid=communityHospitalService.getCommunityHospitalById(SQID).getTCommunityHospitalGroup().getGId();
				
				if(gid != hgid){
					staffLeave = null;
					return "error";
				}
			}else{
				return "error";
			}
		}
		else{
			//平台管理员是0  社区管理员返回社区医院ID的负值，员工则返回员工ID
			int a = GetSessionPerson.getPerson();  
			
			
			if(a == 0){ //平台管理员
				if(staffLeave == null){
					return "error";
				}
			}else if(a<0){
				if(staffLeave != null){
					int SQID = staffService.getCommHospitalByStaffId(staffLeave.getTStaff().getStaffId());
					if(SQID != Math.abs(a)){
						staffLeave = null;
						return "error";
					}
				}else{
					return "error";
				}
			}else{
				if(staffLeave != null){
					int SQID = staffService.getCommHospitalByStaffId(staffLeave.getTStaff().getStaffId());
					if(SQID != staffService.getCommHospitalByStaffId(a)){
						staffLeave = null;
						return "error";
					}
				}else{
					return "error";
				}
			}
		}
		return "showStaffLeave";
	}
	/**
	 * 添加员工请假
	 * @return
	 */
	public String addStaffLeave(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
        
        if(communityHosGroup!=null){//社区集团
        	return "error";
        }
        else{
			//平台管理员是0  社区管理员返回社区医院ID的负值，员工则返回员工ID
			int a = GetSessionPerson.getPerson();  
			
			//-1.后台校验
			if(staffLeave != null){
				Timestamp leaveDate = staffLeave.getLeaveDate();
				String leaveReason = staffLeave.getLeaveReason();
				if(staffNumber == null || leaveReason == null || leaveDate == null){
					return "TestErrorAddStaffLeave";
				}else{
					if(staffNumber == "" || leaveReason == ""){
						return "TestErrorAddStaffLeave";
					}
					if(staffNumber.equals("")||leaveReason.equals("")){
						return "TestErrorAddStaffLeave";
					}
				}
			}else{
				return "TestErrorAddStaffLeave";
			}
			
			HttpServletRequest request=ServletActionContext.getRequest();
			boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
			if(b==true){
				return "addStaffLeave";  //重定向回首页
			}
			request.getSession().removeAttribute("token");//移除session中的token
			//////////////////////////////////////////////////////
			staff = staffService.getStaffByStaffNumber(staffNumber);
			if(staff == null){
				return "error";
			}else{ //如果这个 员工存在
				int SQID = staffService.getCommHospitalByStaffId(staff.getStaffId());
				if(a == 0){//平台管理员
					staffLeave.setTStaff(staff);
					staffLeaveService.saveStaffLeave(staffLeave);
				}else if(a <0){//社区管理员
					if(Math.abs(a) == SQID){
						staffLeave.setTStaff(staff);
						staffLeaveService.saveStaffLeave(staffLeave);
					}else{ 
						return "error";
					}
				}else{//操作员
					if(staffService.getCommHospitalByStaffId(a) != SQID ){
						return "error";
					}else{
						staffLeave.setTStaff(staff);
						staffLeaveService.saveStaffLeave(staffLeave);
					}
				}
				
			}
			return "addStaffLeave";
        }
	}
	
	/**
	 * 更新员工请假实体
	 * @return
	 */
	public String updateStaffLeave(){
		//HttpSession session = ServletActionContext.getRequest().getSession();
	
		return "updateStaffLeave";
	}
	
	/**
	 * 删除员工请假
	 * @return
	 */
	public String deleteStaffLeave(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
        
        if(communityHosGroup!=null){//社区集团
        	return "error";
        }
        else{
			//平台管理员是0  社区管理员返回社区医院ID的负值，员工则返回员工ID
			int a = GetSessionPerson.getPerson();  
			
			staffLeave = staffLeaveService.getStaffLeaveById(staffLeaveId);
			if(a == 0){
				if(staffLeave == null){
					return "error";
				}else{
					staffLeaveService.deleteStaffLeaveById(staffLeaveId);
				} 
			}else if(a < 0){  //社区管理员
				if(staffLeave != null){
					int SQID = staffService.getCommHospitalByStaffId(staffLeave.getTStaff().getStaffId());
					if(SQID != Math.abs(a)){//不符  
						return "error";
					}else{
						staffLeaveService.deleteStaffLeaveById(staffLeaveId);
					}
				}else{
					return "error";
				}
			}else{ //员工操作员
				if(staffLeave != null){
					int SQID = staffService.getCommHospitalByStaffId(staffLeave.getTStaff().getStaffId());
					if(SQID != staffService.getCommHospitalByStaffId(a)){//不符  
						return "error";
					}else{
						staffLeaveService.deleteStaffLeaveById(staffLeaveId);
					}
				}else{
					return "error";
				}
			}
			return "function";
        }
	}
	
  ///////////////////////////取得可维护字段的值/////////////////////////////////
	private List<TMaintainableEntry> zw;  //职务
	private List<TMaintainableEntry> pylx; //聘用类型
	private List<TMaintainableEntry> gw;  //岗位
	private List<TMaintainableEntry> zcdj;  //职称等级
	private List<TMaintainableEntry> zyzgzslx;  //执业资格证书类型
	private List<TMaintainableEntry> jclx;
	


	public String getKWHZD(){
		zw = maintainableAttributeService.getmEntriesByCode("17001");
		pylx = maintainableAttributeService.getmEntriesByCode("17002");
		gw = maintainableAttributeService.getmEntriesByCode("17003");
		zcdj = maintainableAttributeService.getmEntriesByCode("17004");
		zyzgzslx = maintainableAttributeService.getmEntriesByCode("17005");
		jclx = maintainableAttributeService.getmEntriesByCode("17006");
		return "getKWHZD";
	}
	
	public String getKWHZDUpdate(){
		zw = maintainableAttributeService.getmEntriesByCode("17001");
		pylx = maintainableAttributeService.getmEntriesByCode("17002");
		gw = maintainableAttributeService.getmEntriesByCode("17003");
		zcdj = maintainableAttributeService.getmEntriesByCode("17004");
		zyzgzslx = maintainableAttributeService.getmEntriesByCode("17005");
		jclx = maintainableAttributeService.getmEntriesByCode("17006");
		return "getKWHZDUpdate";
	}
	////////////////////////////////工具方法/////////////////////////////////////////////////
	/**
	 * 单独的将这个更新抽出来
	 * @param former
	 * @param staff
	 * @return
	 */
	public TStaff update(TStaff former, TStaff staff){//依次查看属性为空的值,如果为空,将原来的值设置进去  ...........没错.......就是傻逼的把属性都TM判断了一遍
		if(staff.getBirthDate() != null ){former.setBirthDate(staff.getBirthDate());}
		if(staff.getCerificateNum() != null ){former.setCerificateNum(staff.getCerificateNum());}
		if(staff.getCertificateName() != null){former.setCertificateName(staff.getCertificateName());}
		if(staff.getCertificateType() != null ){former.setCertificateType(staff.getCertificateType());}
		if(staff.getCometoOfficeDate() != null){former.setCometoOfficeDate(staff.getCometoOfficeDate());}	
		if(staff.getComputerLevel() != null ){former.setComputerLevel(staff.getComputerLevel());}
		if(staff.getDepartment() != null ){former.setDepartment(staff.getDepartment());}
		if(staff.getEduBackground() != null ){former.setEduBackground(staff.getEduBackground());}
		if(staff.getEnglishLevel() != null ){former.setEnglishLevel(staff.getEnglishLevel());}
		if(staff.getFamilyRegister() != null){former.setFamilyRegister(staff.getFamilyRegister());}
		if(staff.getGpTrain() != null){former.setGpTrain(staff.getGpTrain());}
		if(staff.getGraduateDate() != null){former.setGraduateDate(staff.getGraduateDate());}
		if(staff.getGraduateSchool() != null ){former.setGraduateSchool(staff.getGraduateSchool());}
		if(staff.getHealthStatus() != null ){former.setHealthStatus(staff.getHealthStatus());}
		if(staff.getHireEndDate() != null ){former.setHireEndDate(staff.getHireEndDate());}
		if(staff.getHireStratDate() != null){former.setHireStratDate(staff.getHireStratDate());}
		if(staff.getHireType() != null ){former.setHireType(staff.getHireType());}
		if(staff.getIdCardNum() != null ){former.setIdCardNum(staff.getIdCardNum());}
		if(staff.getJob() != null ){former.setJob(staff.getJob());}
		if(staff.getJobTitleCertificate() != null ){former.setJobTitleCertificate(staff.getJobTitleCertificate());}
		if(staff.getJobTitleLevel() != null ){former.setJobTitleLevel(staff.getJobTitleLevel());}
		if(staff.getJobTitleNum() != null){former.setJobTitleNum(staff.getJobTitleNum());}
		if(staff.getLiveAddr() != null ){former.setLiveAddr(staff.getLiveAddr());}
		if(staff.getLoginName() != null){former.setLoginName(staff.getLoginName());}
		if(staff.getMaritalStatus() != null ){former.setMaritalStatus(staff.getMaritalStatus());}
		if(staff.getName() != null ){former.setName(staff.getName());}
		if(staff.getNote() != null){former.setNote(staff.getNote());}
		if(staff.getPassword() != null){former.setPassword(staff.getPassword());}
		if(staff.getPhone() != null){former.setPhone(staff.getPhone());}
		if(staff.getProfessional() != null ){former.setProfessional(staff.getProfessional());}
		if(staff.getStation() != null ){former.setStation(staff.getStation());}
		if(staff.getStaffNumber() != null ){former.setStaffNumber(staff.getStaffNumber());}
		if(staff.getState() != null){former.setState(staff.getState());}
		if(staff.getSex() != null){former.setSex(staff.getSex());}
		if(staff.getStation() != null ){former.setStation(staff.getStation());}
		if(staff.getTComminityClinics() != null){former.setTComminityClinics(staff.getTComminityClinics());}
		if(staff.getTDoctorDiagnosises() != null ){former.setTDoctorDiagnosises(staff.getTDoctorDiagnosises());}
		if(staff.getTDoorKnockings() != null ){former.setTDoorKnockings(staff.getTDoorKnockings());}
		if(staff.getTEquipmentManages() != null){former.setTEquipmentManages(staff.getTEquipmentManages());}
		if(staff.getTHealthEdus() != null ){former.setTHealthEdus(staff.getTHealthEdus());}
		if(staff.getTKnowledgeLectures() != null ){former.setTKnowledgeLectures(staff.getTKnowledgeLectures());}
		if(staff.getTOldStaffHoses() != null ){former.setTOldStaffHoses(staff.getTOldStaffHoses());}
		if(staff.getTrainEndDate()!=null){former.setTrainEndDate(staff.getTrainEndDate());}
		if(staff.getTrainStratDate() != null){former.setTrainStratDate(staff.getTrainStratDate());}
		if(staff.getTRecoveryPlans() != null ){former.setTRecoveryPlans(staff.getTRecoveryPlans());}
		if(staff.getTRecoverySchemes() != null ){former.setTRecoverySchemes(staff.getTRecoverySchemes());}
		if(staff.getTRole() != null ){former.setTRole(staff.getTRole());}
		if(staff.getWage() != null){former.setWage(staff.getWage());}
		if(staff.getZipCode() != null ){former.setZipCode(staff.getZipCode());}
		return former;
	}
	
	
	
	//////////////////////////////////////////////////////////////////////////////
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getValue() {
		return value;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public List<TStaff> getStaffs() {
		return staffs;
	}
	public void setStaffs(List<TStaff> staffs) {
		this.staffs = staffs;
	}
	public List<TMaintainableEntry> getJclx() {
		return jclx;
	}
	public void setJclx(List<TMaintainableEntry> jclx) {
		this.jclx = jclx;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public int getCommunityHospitalId() {
		return communityHospitalId;
	}
	public void setCommunityHospitalId(int communityHospitalId) {
		this.communityHospitalId = communityHospitalId;
	}
	public int getStaffLeaveId() {
		return staffLeaveId;
	}
	public void setStaffLeaveId(int staffLeaveId) {
		this.staffLeaveId = staffLeaveId;
	}
	public String getStaffNumber() {
		return staffNumber;
	}
	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TStaff getStaff() {
		return staff;
	}
	public List<TMaintainableEntry> getZw() {
		return zw;
	}

	public void setZw(List<TMaintainableEntry> zw) {
		this.zw = zw;
	}

	public List<TMaintainableEntry> getPylx() {
		return pylx;
	}

	public void setPylx(List<TMaintainableEntry> pylx) {
		this.pylx = pylx;
	}

	public List<TMaintainableEntry> getGw() {
		return gw;
	}

	public void setGw(List<TMaintainableEntry> gw) {
		this.gw = gw;
	}

	public List<TMaintainableEntry> getZcdj() {
		return zcdj;
	}

	public Date getLeaveDateHigh() {
		return leaveDateHigh;
	}

	public void setLeaveDateHigh(Date leaveDateHigh) {
		this.leaveDateHigh = leaveDateHigh;
	}

	public Date getLeaveDateLow() {
		return leaveDateLow;
	}

	public void setLeaveDateLow(Date leaveDateLow) {
		this.leaveDateLow = leaveDateLow;
	}

	public Date getComeBackDateHigh() {
		return comeBackDateHigh;
	}

	public void setComeBackDateHigh(Date comeBackDateHigh) {
		this.comeBackDateHigh = comeBackDateHigh;
	}

	public Date getComeBackDateLow() {
		return comeBackDateLow;
	}

	public void setComeBackDateLow(Date comeBackDateLow) {
		this.comeBackDateLow = comeBackDateLow;
	}

	public void setZcdj(List<TMaintainableEntry> zcdj) {
		this.zcdj = zcdj;
	}

	public List<TMaintainableEntry> getZyzgzslx() {
		return zyzgzslx;
	}

	public void setZyzgzslx(List<TMaintainableEntry> zyzgzslx) {
		this.zyzgzslx = zyzgzslx;
	}

	public void setStaff(TStaff staff) {
		this.staff = staff;
	}
	public TStaffLeave getStaffLeave() {
		return staffLeave;
	}
	public void setStaffLeave(TStaffLeave staffLeave) {
		this.staffLeave = staffLeave;
	}
	public String getLeaveDateHighStr() {
		return leaveDateHighStr;
	}

	public void setLeaveDateHighStr(String leaveDateHighStr) {
		this.leaveDateHighStr = leaveDateHighStr;
	}

	public String getLeaveDateLowStr() {
		return leaveDateLowStr;
	}

	public void setLeaveDateLowStr(String leaveDateLowStr) {
		this.leaveDateLowStr = leaveDateLowStr;
	}

	public String getComeBackDateHighStr() {
		return comeBackDateHighStr;
	}

	public void setComeBackDateHighStr(String comeBackDateHighStr) {
		this.comeBackDateHighStr = comeBackDateHighStr;
	}

	public String getComeBackDateLowStr() {
		return comeBackDateLowStr;
	}

	public void setComeBackDateLowStr(String comeBackDateLowStr) {
		this.comeBackDateLowStr = comeBackDateLowStr;
	}

	public Page<TStaff> getPage() {
		return page;
	}
	public void setPage(Page<TStaff> page) {
		this.page = page;
	}
	public String getPageHtml() {
		return pageHtml;
	}
	public void setPageHtml(String pageHtml) {
		this.pageHtml = pageHtml;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public int[] getIds() {
		return ids;
	}
	public void setIds(int[] ids) {
		this.ids = ids;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getComebackDateString() {
		return comebackDateString;
	}
	public void setComebackDateString(String comebackDateString) {
		this.comebackDateString = comebackDateString;
	}
	public String getLeaveDateString() {
		return leaveDateString;
	}
	public void setLeaveDateString(String leaveDateString) {
		this.leaveDateString = leaveDateString;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public List<TStaffLeave> getStaffLeaves() {
		return staffLeaves;
	}
	public void setStaffLeaves(List<TStaffLeave> staffLeaves) {
		this.staffLeaves = staffLeaves;
	}
	public int getFlagThree() {
		return flagThree;
	}
	public void setFlagThree(int flagThree) {
		this.flagThree = flagThree;
	}
	public List<VStaffLeave> getVstaffleaves() {
		return vstaffleaves;
	}
	public void setVstaffleaves(List<VStaffLeave> vstaffleaves) {
		this.vstaffleaves = vstaffleaves;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public TStaffCommunite getCstaff() {
		return cstaff;
	}
	public void setCstaff(TStaffCommunite cstaff) {
		this.cstaff = cstaff;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<StaffSpecial> getStaffSpecials() {
		return staffSpecials;
	}

	public void setStaffSpecials(List<StaffSpecial> staffSpecials) {
		this.staffSpecials = staffSpecials;
	}

	public int getSqId() {
		return sqId;
	}

	public void setSqId(int sqId) {
		this.sqId = sqId;
	}

	public TCommunityHospitalGroup getCommunityHospitalGroup() {
		return communityHospitalGroup;
	}

	public void setCommunityHospitalGroup(TCommunityHospitalGroup communityHospitalGroup) {
		this.communityHospitalGroup = communityHospitalGroup;
	}

	

}
