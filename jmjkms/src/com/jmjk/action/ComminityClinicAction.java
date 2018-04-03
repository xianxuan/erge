package com.jmjk.action;

import java.sql.Date;
import java.util.ArrayList;
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

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jmjk.action.base.BaseAction;
import com.jmjk.entity.TComminityClinic;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.TStaff;
import com.jmjk.export.ComminityClinicExport;
import com.jmjk.iservice.IComminityClinicService;
import com.jmjk.iservice.ICommunityHospitalService;
import com.jmjk.iservice.IStaffService;
import com.jmjk.pojo.ComminityClinic;
import com.jmjk.service.HealthFileService;
import com.jmjk.utils.GetSessionPerson;
import com.jmjk.utils.JxlExcel;
import com.jmjk.utils.Page;
import com.jmjk.utils.Resubmit;
import com.jmjk.utils.TokenProccessor;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 社区义诊Action
 * @author houzichang
 */
@Component
@Scope("prototype")
@Action(value="comminityClinicAction",results={
		@Result(name="addComminityClinic",location="/jsp/comminityClinic/addComminityClinic.jsp"),
		@Result(name="saveSuccess",type="redirectAction", location="comminityClinicAction!getComminityClinicListById.action"),
		@Result(name="getComminityClinicListById",location="/jsp/comminityClinic/showComminityClinic.jsp"),
		@Result(name="editComminityClinic",location="/jsp/comminityClinic/editComminityClinic.jsp"),
		@Result(name="updateSuccess",type="redirectAction", location="comminityClinicAction!getComminityClinicListById.action"),
		@Result(name="deleteComminityClinic",type="redirectAction", location="comminityClinicAction!getComminityClinicListById.action"),
		@Result(name="comminityClinicDetails",location="/jsp/comminityClinic/comminityClinicDetails.jsp"),
		@Result(name="getComminityClinicBySearch",location="/jsp/comminityClinic/showComminityClinic.jsp"),
		@Result(name="success",type="redirectAction", location="comminityClinicAction!getComminityClinicListById.action"),
		@Result(name="error", location="/error.jsp"),
		@Result(name="test", type="redirectAction",location="comminityClinicAction.action"),
		@Result(name="DocDRedir",type="redirectAction",location="comminityClinicAction!getComminityClinicListById.action"),
})
public class ComminityClinicAction extends BaseAction{
	@Autowired
    IComminityClinicService comminityClinicService;
	@Autowired
	ICommunityHospitalService communityHospitalService;
	@Autowired
	IStaffService staffService;
	@Autowired
	HealthFileService healthFileService;
	
	private TComminityClinic comminityClinic;
	private List<TStaff> staffList;
	private int staffsId;
	Page page = new Page();                //分页对象
	private int cp=1;                              //当前页码
	private String pageHtml; 
	private List<TComminityClinic> comminityClinicList;
	private int comminityClinicId;
	
	private String comminityClinicStatus;
	private Date startDate;
	private Date endDate;
	private String token;
	// 导出
	 private int flag;
	 private int[] ids;
	
	private ComminityClinic comminiTal = new ComminityClinic();
	private List<ComminityClinic> comminiListTal = new ArrayList<ComminityClinic>();
	private TCommunityHospital communityHospital;
    private String communityHospitalName;
    private int hosId;
    private String groupName;
    private int groupId;
    
	//添加社区义诊实体
	public String addComminityClinic(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){
        	return "error";      //如果集团能够添加的话报错
        }else {
        	//从session里拿到当前登录用户的id
    		int userId = GetSessionPerson.getPerson();
    		int hosId = 0;
    		//user大于0,员工id
    		if (userId>0) {
    			hosId = staffService.getCommHospitalByStaffId(userId);
    		//user小于0,社区负责人id;等于0,平台admin
    		}else if (userId<0) {
    			hosId = Math.abs(userId);
    		}else {
    			return "error";
    		}
    		token = TokenProccessor.getInstance().makeToken();//创建令牌
    		HttpServletRequest request=ServletActionContext.getRequest();
    		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
    		staffList = staffService.getStaffByCommunityHospitalId(hosId);//需有参数值
    		return "addComminityClinic";	
		}
	}
	//保存社区义诊实体
	public String saveComminityClinic(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){
        	return "error";      //如果集团能够保存的话报错
        }else {
        	//从session里拿到当前登录用户的id
    		int userId = GetSessionPerson.getPerson();
    		int hosId = 0;
    		//user大于0,员工id
    		if (userId>0) {
    			hosId = staffService.getCommHospitalByStaffId(userId);
    		//user小于0,社区负责人id;等于0,平台admin
    		}else if (userId<0) {
    			hosId = Math.abs(userId);
    		}else {
    			return "error";
    		}
    		
    		HttpServletRequest request=ServletActionContext.getRequest();
    		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
    		if(b==true){
    			return "DocDRedir";  //重定向回首页
    		}
    		request.getSession().removeAttribute("token");//移除session中的token
    		
    		TStaff staff = staffService.getStaffById(staffsId);  
    		comminityClinic.setTStaff(staff); 
    		comminityClinic.setCommunityHospitalId(hosId);
    		try {
    			comminityClinicService.saveComminityClinic(comminityClinic);
    		} catch (Exception e) {
    			staffList = staffService.getStaffByCommunityHospitalId(hosId);
    			return "addComminityClinic"; 
    		} 
		}
		return "saveSuccess";
	}
	
	//修改社区义诊
	public String editComminityClinic(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){
        	return "error";      //如果集团能够修改的话报错
        }else {
        	//从session里拿到当前登录用户的id
    		int userId = GetSessionPerson.getPerson();
    		int hosId = 0;
    		//user大于0,员工id
    		if (userId>0) {
    			hosId = staffService.getCommHospitalByStaffId(userId);
    		//user小于0,社区负责人id;等于0,平台admin
    		}else if (userId<0 ) {
    			hosId = Math.abs(userId);
    		}else {
    			return "error";
    		}
           if (hosId == comminityClinicService.getComminityClinicById(comminityClinicId).getCommunityHospitalId()) {
            	staffList = staffService.getStaffByCommunityHospitalId(hosId);
            	comminityClinic=comminityClinicService.getComminityClinicById(comminityClinicId);
        		staffsId = comminityClinic.getTStaff().getStaffId();
        		return "editComminityClinic";
    		}
		}
		return "success";
	}
	//保存修改社区义诊
	public String updateComminityClinic(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){
        	return "error";      //如果集团能够保存修改的话报错
        }else {
        	//从session里拿到当前登录用户的id
    		int userId = GetSessionPerson.getPerson();
    		int hosId = 0;
    		//user大于0,员工id
    		if (userId>0) {
    			hosId = staffService.getCommHospitalByStaffId(userId);
    		//user小于0,社区负责人id;等于0,平台admin
    		}else if (userId<0) {
    			hosId = Math.abs(userId);
    		}else {
    			return "error";
    		}
    		
    		if (hosId == comminityClinic.getCommunityHospitalId()) {
    			TStaff staff = staffService.getStaffById(staffsId);  //根据负责人Id获得员工实体
    			comminityClinic.setTStaff(staff); //将员工实体保存到健康教育活动中
    			comminityClinicService.updateComminityClinic(comminityClinic);
    			return "updateSuccess";
    		} 
		}
		return	"success";
	}
    //删除社区义诊
	public String deleteComminityClinic(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){
        	return "error";      //如果集团能够删除的话报错
        }else {
        	//从session里拿到当前登录用户的id
    		int userId = GetSessionPerson.getPerson();
    		int hosId = 0;
    		//user大于0,员工id
    		if (userId>0) {
    			hosId = staffService.getCommHospitalByStaffId(userId);
    		//user小于0,社区负责人id;等于0,平台admin
    		}else if (userId<0) {
    			hosId = Math.abs(userId);
    		}else {
    			return "error";
    		}
    		
    		if (hosId == comminityClinicService.getComminityClinicById(comminityClinicId).getCommunityHospitalId()) {
    			try {
    				comminityClinicService.deleteComminityClinic(comminityClinicId);
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			return "deleteComminityClinic";
    		}	
		}
        return "success";
	}

	//根据社区医院Id获取社区义诊列表
		public String getComminityClinicListById(){
			HttpSession session = ServletActionContext.getRequest().getSession();
	        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
	        if(group!=null){ 
	        	page.setCurrentPage(cp);
	        	page.setTotalNum(comminityClinicService.getComminityNumByGroup(group));
	        	comminityClinicList = comminityClinicService.getComminityClinListByGroup(group);
	        	if (comminityClinicList!=null) {
					
	        	for (TComminityClinic tcc:comminityClinicList) {
					comminiTal = new ComminityClinic();
					communityHospital = communityHospitalService.getCommunityHospitalById(tcc.getCommunityHospitalId());
					communityHospitalName = communityHospital.getCommunityHospital();
					comminiTal.setClinic(tcc);
					comminiTal.setCommunityHospital(communityHospitalName);
					comminiListTal.add(comminiTal);   //总的列表..........
				}
				}
	        	pageHtml=page.getPage("comminityClinicAction!getComminityClinicListById.action");
				return "getComminityClinicListById";
	        }else {
	        	//从session里拿到当前登录用户的id
				int userId = GetSessionPerson.getPerson();
				//user等于0，平台管理员
				if (userId==0) {
					page.setCurrentPage(cp);
					page.setTotalNum(comminityClinicService.getTComminityClinicNumByAll());  
					comminityClinicList=comminityClinicService.getComminityClinicListByAll(page);
					if (comminityClinicList!=null) {
					
					for (TComminityClinic tcc:comminityClinicList) {
						comminiTal = new ComminityClinic();
						hosId = tcc.getCommunityHospitalId();
						communityHospital = communityHospitalService.getCommunityHospitalById(hosId);//社区医院实体
	    				groupName = communityHospital.getTCommunityHospitalGroup().getGroupName();//集团名称
	    				communityHospitalName = communityHospital.getCommunityHospital(); //社区医院名称
	    				comminiTal.setClinic(tcc);
	    				comminiTal.setCommunitygroup(groupName);
	    				comminiTal.setCommunityHospital(communityHospitalName);
	    				comminiListTal.add(comminiTal);   //总的列表
					}	
					}
					pageHtml=page.getPage("comminityClinicAction!getComminityClinicListById.action");
					return "getComminityClinicListById";
				}
				
				int hosId = 0;
				//user大于0,员工id
				if (userId>0) {
					if(healthFileService.getOldStaffHosByStaffId(userId)) {// 判断员工是否为责任医生，若是，则只能看到所对应的老人){
						page.setCurrentPage(cp);
						page.setTotalNum(comminityClinicService.getComminityClinicNumForSpecial(userId));  
						comminityClinicList=comminityClinicService.getComminityClinicForSpecial(userId,page);
						if (comminityClinicList!=null) {
							
						for (TComminityClinic tcc:comminityClinicList) {
							comminiTal = new ComminityClinic();
							comminiTal.setClinic(tcc);
							comminiListTal.add(comminiTal);
						}
						}
						pageHtml=page.getPage("comminityClinicAction!getComminityClinicListById.action");
						return "getComminityClinicListById";
					}
					hosId = staffService.getCommHospitalByStaffId(userId);
				//user小于0,社区负责人id;等于0,平台admin
				}else if (userId<0 ) {
					hosId = Math.abs(userId);
				}else {
					return "error";
				}
				page.setCurrentPage(cp);
				page.setTotalNum(comminityClinicService.getComminityClinicNumBycomHosID(hosId));  
				comminityClinicList=comminityClinicService.getComminityClinicBycomHosID(hosId, page);
				if (comminityClinicList!=null) {
					
				for (TComminityClinic tcc:comminityClinicList) {
					comminiTal =new ComminityClinic();
					comminiTal.setClinic(tcc);
					comminiListTal.add(comminiTal);
				}
				}
				pageHtml=page.getPage("comminityClinicAction!getComminityClinicListById.action");
				return "getComminityClinicListById";
			}
		}
		
    //社区义诊详情
	public  String comminityClinicDetails(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){ 
        	staffList = staffService.getAllStaff();
			comminityClinic=comminityClinicService.getComminityClinicById(comminityClinicId);
			hosId = comminityClinic.getCommunityHospitalId();
			communityHospital = communityHospitalService.getCommunityHospitalById(hosId);
			communityHospitalName = communityHospital.getCommunityHospital(); //社区医院名称
			comminiTal.setClinic(comminityClinic);
			comminiTal.setCommunityHospital(communityHospitalName);
			staffsId = comminityClinic.getTStaff().getStaffId();
			return "comminityClinicDetails";
        }else {
        	//从session里拿到当前登录用户的id
    		int userId = GetSessionPerson.getPerson();
    		int hosId = 0;
    		//user大于0,员工id
    		if (userId>0) {
    			hosId = staffService.getCommHospitalByStaffId(userId);
    		//user小于0,社区负责人id;等于0,平台admin
    		}else if (userId<0 ) {
    			hosId = Math.abs(userId);
    		}else {
    			staffList = staffService.getAllStaff();
    			comminityClinic=comminityClinicService.getComminityClinicById(comminityClinicId);
    			hosId = comminityClinic.getCommunityHospitalId();
    			communityHospital = communityHospitalService.getCommunityHospitalById(hosId);
    			communityHospitalName = communityHospital.getCommunityHospital(); //社区医院名称
    			groupName = communityHospital.getTCommunityHospitalGroup().getGroupName();
    			comminiTal.setCommunitygroup(groupName);
    			comminiTal.setClinic(comminityClinic);
    			comminiTal.setCommunityHospital(communityHospitalName);
    			staffsId = comminityClinic.getTStaff().getStaffId();
    			return "comminityClinicDetails";
    		}
    		if (hosId == comminityClinicService.getComminityClinicById(comminityClinicId).getCommunityHospitalId()) {
    			comminityClinic=comminityClinicService.getComminityClinicById(comminityClinicId);
    			comminiTal.setClinic(comminityClinic);
    			staffList = staffService.getStaffByCommunityHospitalId(hosId);//需有参数值
    			staffsId = comminityClinic.getTStaff().getStaffId();
    			return "comminityClinicDetails";
    		}
		}
		return "success";
	}
    //查询
	public String getComminityClinicBySearch(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){
        	groupId = group.getGId();
        	page.setCurrentPage(cp);
        	page.setTotalNum(comminityClinicService.getCommiNumGroupBySearch(groupId, comminityClinicStatus, startDate, endDate));
			comminityClinicList=comminityClinicService.getCommiListGroupBySearch(groupId, comminityClinicStatus, startDate, endDate, page);
			for (TComminityClinic tcc:comminityClinicList) {
				comminiTal = new ComminityClinic();
				communityHospital = communityHospitalService.getCommunityHospitalById(tcc.getCommunityHospitalId());
				communityHospitalName = communityHospital.getCommunityHospital();
				comminiTal.setClinic(tcc);
				comminiTal.setCommunityHospital(communityHospitalName);
				comminiListTal.add(comminiTal);   //总的列表..........
			}
			pageHtml=page.getPage("comminityClinicAction!getComminityClinicBySearch.action?comminityClinicStatus="+comminityClinicStatus+"&startDate="+startDate+"&endDate="+endDate);				
			return "getComminityClinicBySearch";
        }else {
        	//从session里拿到当前登录用户的id
    		int userId = GetSessionPerson.getPerson();
    		int hosId = 0;
    		//user大于0,员工id
    		if (userId>0) {
    			/*hosId = staffService.getCommHospitalByStaffId(userId);*/
    			page.setCurrentPage(cp);
        		page.setTotalNum(comminityClinicService.getCommiSpecialNumBySearch(userId, comminityClinicStatus, startDate, endDate));
        		comminityClinicList=comminityClinicService.getCommiSpecialListBySearch(userId, comminityClinicStatus, startDate, endDate, page);
        		for (TComminityClinic tcc:comminityClinicList) {
    				comminiTal =new ComminityClinic();
    				comminiTal.setClinic(tcc);
    				comminiListTal.add(comminiTal);
    			}
        		pageHtml=page.getPage("comminityClinicAction!getComminityClinicBySearch.action?comminityClinicStatus="+comminityClinicStatus+"&startDate="+startDate+"&endDate="+endDate);				
        		return "getComminityClinicBySearch";
    		//user小于0,社区负责人id;等于0,平台admin
    		}else if (userId<0 ) {
    			hosId = Math.abs(userId);
    		}else {
    			page.setCurrentPage(cp);
    			page.setTotalNum(comminityClinicService.getTComminityClinicNumBySearch(comminityClinicStatus, startDate, endDate));
    			comminityClinicList=comminityClinicService.getTComminityClinicListBySearch(comminityClinicStatus, startDate, endDate, page);
    			for (TComminityClinic tcc:comminityClinicList) {
					comminiTal = new ComminityClinic();
					hosId = tcc.getCommunityHospitalId();
					communityHospital = communityHospitalService.getCommunityHospitalById(hosId);//社区医院实体
    				groupName = communityHospital.getTCommunityHospitalGroup().getGroupName();//集团名称
    				communityHospitalName = communityHospital.getCommunityHospital(); //社区医院名称
    				comminiTal.setClinic(tcc);
    				comminiTal.setCommunitygroup(groupName);
    				comminiTal.setCommunityHospital(communityHospitalName);
    				comminiListTal.add(comminiTal);   //总的列表
				}
    			pageHtml=page.getPage("comminityClinicAction!getComminityClinicBySearch.action?comminityClinicStatus="+comminityClinicStatus+"&startDate="+startDate+"&endDate="+endDate);				
    			return "getComminityClinicBySearch";
    		}
    		page.setCurrentPage(cp);
    		page.setTotalNum(comminityClinicService.getComminityClinicNumBySearch(hosId, comminityClinicStatus, startDate, endDate));
    		comminityClinicList=comminityClinicService.getComminityClinicListBySearch(hosId, comminityClinicStatus, startDate, endDate, page);
    		for (TComminityClinic tcc:comminityClinicList) {
				comminiTal =new ComminityClinic();
				comminiTal.setClinic(tcc);
				comminiListTal.add(comminiTal);
			}
    		pageHtml=page.getPage("comminityClinicAction!getComminityClinicBySearch.action?comminityClinicStatus="+comminityClinicStatus+"&startDate="+startDate+"&endDate="+endDate);				
    		return "getComminityClinicBySearch";
		}
	}
		// 导出
	public String test() throws Exception{
		//从session里拿到当前登录用户的id
		int userId = GetSessionPerson.getPerson();
		//判断flag-----1导出全部2导出本页
		if (flag == 1) {
			List<ComminityClinicExport> expoetComminityClinic = new ArrayList<ComminityClinicExport>();
			int hosId = 0;
			//user大于0,员工id
			if (userId>0) {
				hosId = staffService.getCommHospitalByStaffId(userId);
			//user小于0,社区负责人id;等于0,平台admin
			}else if (userId<0 || userId ==0) {
				hosId = Math.abs(userId);
			}
			comminityClinicList = comminityClinicService.getComminityClinicListById(hosId);
			if (comminityClinicList != null) {
				for (TComminityClinic comminityClinic : comminityClinicList) {
					ComminityClinicExport cc = new ComminityClinicExport(comminityClinic);
					expoetComminityClinic.add(cc);
				}
			}
		    ComminityClinicExport cc = new ComminityClinicExport();
		    String[] titles = cc.getTitles();
			JxlExcel Jxl = new JxlExcel(titles);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("content-disposition", "attachment;filename="+1+".xls");
			ServletOutputStream output = response.getOutputStream();
			Jxl.write(expoetComminityClinic, output);
		    response.flushBuffer();
		    return null;
		}
		if (flag == 2) {
			List<ComminityClinicExport> comminityClinicList = new ArrayList<ComminityClinicExport>();
			if (ids!=null) {
			 for (int i = 0; i < ids.length; i++) {
				TComminityClinic tc = comminityClinicService.getComminityClinicById(ids[i]);
				if (tc != null) {
					ComminityClinicExport cc = new ComminityClinicExport(tc);
					comminityClinicList.add(cc);
				}
			}	
			}
			ComminityClinicExport cc = new ComminityClinicExport();
			String[] titles = cc.getTitles();
			JxlExcel Jxl = new JxlExcel(titles);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("content-disposition", "attachment;filename="+2+".xls");
			ServletOutputStream output = response.getOutputStream();
			Jxl.write(comminityClinicList, output);
		    response.flushBuffer();
		    return null;
		}
		return "test";}
			
			
			
	/*Geter  and  seter*/
	public TComminityClinic getComminityClinic() {
		return comminityClinic;
	}
	public void setComminityClinic(TComminityClinic comminityClinic) {
		this.comminityClinic = comminityClinic;
	}
	public List<TStaff> getStaffList() {
		return staffList;
	}
	public void setStaffList(List<TStaff> staffList) {
		this.staffList = staffList;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public String getPageHtml() {
		return pageHtml;
	}
	public void setPageHtml(String pageHtml) {
		this.pageHtml = pageHtml;
	}
	public List<TComminityClinic> getComminityClinicList() {
		return comminityClinicList;
	}
	public void setComminityClinicList(List<TComminityClinic> comminityClinicList) {
		this.comminityClinicList = comminityClinicList;
	}
	public int getComminityClinicId() {
		return comminityClinicId;
	}
	public void setComminityClinicId(int comminityClinicId) {
		this.comminityClinicId = comminityClinicId;
	}
	public int getStaffsId() {
		return staffsId;
	}
	public void setStaffsId(int staffsId) {
		this.staffsId = staffsId;
	}
	
	public String getComminityClinicStatus() {
		return comminityClinicStatus;
	}
	public void setComminityClinicStatus(String comminityClinicStatus) {
		this.comminityClinicStatus = comminityClinicStatus;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public IComminityClinicService getComminityClinicService() {
		return comminityClinicService;
	}
	public void setComminityClinicService(
			IComminityClinicService comminityClinicService) {
		this.comminityClinicService = comminityClinicService;
	}
	public IStaffService getStaffService() {
		return staffService;
	}
	public void setStaffService(IStaffService staffService) {
		this.staffService = staffService;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int[] getIds() {
		return ids;
	}
	public void setIds(int[] ids) {
		this.ids = ids;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public ICommunityHospitalService getCommunityHospitalService() {
		return communityHospitalService;
	}
	public void setCommunityHospitalService(
			ICommunityHospitalService communityHospitalService) {
		this.communityHospitalService = communityHospitalService;
	}
	public HealthFileService getHealthFileService() {
		return healthFileService;
	}
	public void setHealthFileService(HealthFileService healthFileService) {
		this.healthFileService = healthFileService;
	}
	public ComminityClinic getComminiTal() {
		return comminiTal;
	}
	public void setComminiTal(ComminityClinic comminiTal) {
		this.comminiTal = comminiTal;
	}
	public List<ComminityClinic> getComminiListTal() {
		return comminiListTal;
	}
	public void setComminiListTal(List<ComminityClinic> comminiListTal) {
		this.comminiListTal = comminiListTal;
	}
	public TCommunityHospital getCommunityHospital() {
		return communityHospital;
	}
	public void setCommunityHospital(TCommunityHospital communityHospital) {
		this.communityHospital = communityHospital;
	}
	public String getCommunityHospitalName() {
		return communityHospitalName;
	}
	public void setCommunityHospitalName(String communityHospitalName) {
		this.communityHospitalName = communityHospitalName;
	}
	public int getHosId() {
		return hosId;
	}
	public void setHosId(int hosId) {
		this.hosId = hosId;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
}
