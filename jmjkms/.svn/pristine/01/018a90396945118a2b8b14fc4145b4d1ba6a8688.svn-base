package com.jmjk.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import com.jmjk.entity.TOldStaffHos;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.TStaffRewardPunish;
import com.jmjk.entity.view.VStaffRewardPunish;
import com.jmjk.export.StaffRewardPunishExport;
import com.jmjk.iservice.IStaffService;
import com.jmjk.service.StaffRewardPunishService;
import com.jmjk.service.CommunityHospitalGroupService;
import com.jmjk.service.CommunityHospitalService;
import com.jmjk.utils.GetSessionPerson;
import com.jmjk.utils.HtmlEscape;
import com.jmjk.utils.JxlExcel;
import com.jmjk.utils.Page;
import com.jmjk.utils.Resubmit;
import com.jmjk.utils.TokenProccessor;
import com.jmjk.utils.TypeConverter;
import com.opensymphony.xwork2.ActionContext;



/**
 * 
 * @author 查询  导出!!!!
 *
 */
@Component
@Scope("prototype")
@Action(value="staffRewardPunishAction",results={
		@Result(name="error",location = "/error.jsp"),
		@Result(name="search",location="/jsp/staffManage/staffRewardPunishManage/staffRewardPunishSearch.jsp"),
		@Result(name="getAllStaffRewardPunish",location="/jsp/staffManage/staffRewardPunishManage/staffRewardPunishSearch.jsp"),
		@Result(name="noSearch",location="staffRewardPunishAction!getAllStaffRewardPunish.action",type ="redirectAction"),
		@Result(name="error",location="/error.jsp"),
		@Result(name="TestErrorStaffR",type="redirect",location="/jsp/staffManage/staffRewardPunishManage/addStaffRewardPunish.jsp"),
		@Result(name="addRewardPunish",type ="redirectAction",location="staffRewardPunishAction!getAllStaffRewardPunish.action"),
		@Result(name="toAdd",location="/jsp/staffManage/staffRewardPunishManage/addStaffPunish.jsp"),
		@Result(name="deletestaffRewardPunish",location="staffRewardPunishAction!getAllStaffRewardPunish.action" ,type = "redirectAction"),
		@Result(name="staffRewardPunishDetail",location="/jsp/staffManage/staffRewardPunishManage/staffRewardPunishDetail.jsp"),
		@Result(name="jumpUpdateStaffRewardPunish",location="/jsp/staffManage/staffRewardPunishManage/editStaffPunish.jsp"),//获得实体并且回显
		@Result(name="editstaffRewardPunish",location="staffRewardPunishAction!getAllStaffRewardPunish.action" ,type = "redirectAction")
		})
	public class StaffRewardPunishAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	@Autowired
	private StaffRewardPunishService staffRewardPunishService;
	@Autowired
	private CommunityHospitalService CommunityHospitalService;
	@Autowired 
	private IStaffService staffService;
	@Autowired
	private CommunityHospitalGroupService communityHospitalGroupService;
	
	/*变量参数*/
	private String value;
	private int cp=1;
	private TStaffRewardPunish staffRewardPunish;
	private TStaff staff;
	private TOldStaffHos OldStaffHos;
	private VStaffRewardPunish  vstaffRewardPunish;
	private TCommunityHospital communityHospital;
	private TCommunityHospitalGroup communityHospitalGroup;
	private int srpId;
	private int comHosId;
	private String staffNumber;
	private String name;
	private Timestamp rewardPunishDate;
	private String rewordPunishType;
	private Double rewordPunishAmount;
	private String rewordPunishReason;
	private String note;
	private List<TStaff> AllStaffNumberList;
	private List<TStaffRewardPunish>  staffRewardPunishList;
	private List<VStaffRewardPunish> vstaffRewardPunishList;
	private Page<VStaffRewardPunish> page;
	private int staffRewardPunishId;
	private int staffId;
	private List<Object> allstaffId;
	private int flag;
	private Date fromDate;
	private Date toDate;
    private String department;
    private int communityHospitalId;
    private String pageHtml;
    private String hhhString;
	private int[] ids;
	private String token;
	
	private String  start = "";
	private String end = "";


	
	/*  进入首页后的查询方法
	 * 
	 *  
	 *  */
    public String search(){
    	
    	if(flag == 1){//本月
    		toDate = new Date();
    		Calendar cal = Calendar.getInstance();
    		cal.set(Calendar.DAY_OF_MONTH, 1);//当前月的第一天
    		fromDate = cal.getTime();
    	}
    	if(flag == 2){//上月
    		Calendar cal = Calendar.getInstance();
    		cal.add(Calendar.MONTH, -1);//得到上个月
    		cal.set(Calendar.DAY_OF_MONTH, 1);//上个月的第一天
    		fromDate = cal.getTime();
    		cal.add(Calendar.MONTH, 1);//当前月第一天
    		cal.add(Calendar.DAY_OF_MONTH, -1);//上月最后一天
    		toDate = cal.getTime();
    	}
    	if(flag == 3){//本季度
    		Calendar cal = Calendar.getInstance();
    		int yue = cal.get(Calendar.MONTH);
    		if(yue >=5){
    			cal.set(Calendar.MONTH,5);
    			cal.set(Calendar.DAY_OF_MONTH, 1);
    			fromDate = cal.getTime();
    		}else{
    			cal.set(Calendar.MONTH,0);
    			cal.set(Calendar.DAY_OF_MONTH, 1);
    			fromDate = cal.getTime();
    		}
    		toDate = new Date();
    	}
    	if(flag == 4){//本年
    		Calendar cal = Calendar.getInstance();
    		cal.set(Calendar.MONTH, 0);
    		cal.set(Calendar.DAY_OF_MONTH, 1);
    		fromDate = cal.getTime();
    		toDate = new Date();
    	}
    	if(fromDate == null){
    		start = "";
    	}else{
    		start = TypeConverter.dateFormat(fromDate);
    	}
    	if(toDate == null){
    		end = "";
    	}else{
    		end = TypeConverter.dateFormat(toDate);
    	}
    	
   	 	Page<VStaffRewardPunish> page=new Page<VStaffRewardPunish>();
		page.setCurrentPage(cp);
		
    	HttpSession session = ServletActionContext.getRequest().getSession();
    	communityHospitalGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
    	int sqId;
    	if(communityHospitalGroup!=null){//社区集团
    		int gid=communityHospitalGroup.getGId();
    		page.setTotalNum(staffRewardPunishService.countStaffRewardGroupPunish(flag, gid, fromDate, toDate, rewordPunishType, name, department));
	    	vstaffRewardPunishList = staffRewardPunishService.searchStaffRewardGroupPunish(page, gid, flag, fromDate, toDate, rewordPunishType, name);
			name = HtmlEscape.escapeHtml(name);

    	}
    	else{
	    	int person = GetSessionPerson.getPerson();//获取session中的值
	    	
			if(person == 0){
				sqId = -1;
			}else if(person <0){
				sqId = Math.abs(person);
			}else{
				sqId = staffService.getCommHospitalByStaffId(person);
			}
			page.setTotalNum(staffRewardPunishService.countStaffRewardPunish(flag, sqId, fromDate, toDate, rewordPunishType, name, department));
	    	vstaffRewardPunishList = staffRewardPunishService.searchStaffRewardPunish(page, sqId, flag, fromDate, toDate, rewordPunishType, name);
			name = HtmlEscape.escapeHtml(name);
    	}	
    	pageHtml = page.getPage("staffRewardPunishAction!search.action?start="+start+"&end="+end+"&name="+name);
    	return "search";
	}
	
         /*  界面中的打印和导出方法*/
    public String function()throws Exception{
    	HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
        
        if(communityHosGroup!=null){//社区集团
        	return "error";
        }
        else{
	    	int person = GetSessionPerson.getPerson();//获取session中的值
	    	
	     	if(flag == 1){//导出本页
	     		List<StaffRewardPunishExport> list = new ArrayList<StaffRewardPunishExport>();
	    		if(ids != null){
		     		for(int i = 0; i<ids.length; i++){
		    			TStaffRewardPunish rp = staffRewardPunishService.getTStaffRewardPunishBysrpId(ids[i]);
		    			if(rp != null ){
		    				StaffRewardPunishExport se = new StaffRewardPunishExport(rp);
		    				list.add(se);
		    			}
		    		}
	    		}
	    		HttpServletResponse response = ServletActionContext.getResponse();
				response.setHeader("content-disposition", "attachment;filename="+4+".xls");
				ServletOutputStream output = response.getOutputStream();
	    		StaffRewardPunishExport se = new StaffRewardPunishExport();
	    		String [] titles = se.getTitles();
	    		JxlExcel he = new JxlExcel(titles);
	    		he.write(list, output);
	    		response.flushBuffer();
	     	}
	     	if(flag == 2){//导出全部
	     		int sqId;
	    		if(person == 0){
	    			sqId = -1;
	    		}else if(person <0){
	    			sqId = Math.abs(person);
	    		}else{
	    			sqId = staffService.getCommHospitalByStaffId(person);
	    		}
	     		List<StaffRewardPunishExport> elists = new ArrayList<StaffRewardPunishExport>();
	     		String[] titles=(new StaffRewardPunishExport()).getTitles();//新添
	     		List<VStaffRewardPunish> list = staffRewardPunishService.getCommunicityAllTStaffRewardPunish(sqId);
	     		for(VStaffRewardPunish vv: list){
	     			if(vv != null){
	     				StaffRewardPunishExport se = new StaffRewardPunishExport(vv);
	     				elists.add(se);
	     			}
	     		}
	     		HttpServletResponse response = ServletActionContext.getResponse();
				response.setHeader("content-disposition", "attachment;filename="+4+".xls");
				ServletOutputStream output = response.getOutputStream();
	    		JxlExcel he = new JxlExcel(titles);   
	    		he.write(elists, output);
	    		response.flushBuffer();
	     	}
			 return  "addRewardPunish";
        }
	 }
    
    /**
     * 
     * @return
     */
	public String getAllStaffRewardPunish(){

		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
		if(communityHosGroup!=null){//社区集团
			communityHospitalGroup=communityHospitalGroupService.getRealComHosGroup(communityHosGroup);
			 int sqId =communityHospitalGroup.getGId();
			 Page<VStaffRewardPunish> page=new Page<VStaffRewardPunish>();
			 page.setCurrentPage(cp);
			 page.setTotalNum(staffRewardPunishService.countTStaffGroupRewardPunish(sqId));
			 vstaffRewardPunishList= staffRewardPunishService.getCommunicityTStaffGroupRewardPunish(page, sqId);
			 this.pageHtml = page.getPage("staffRewardPunishAction!getAllStaffRewardPunish.action");
			 return  "getAllStaffRewardPunish";
		}
		else{
	    	int person = GetSessionPerson.getPerson();//获取session中的值
	    	
			int sqId;
			if(person == 0){
				sqId = -1;
			}else if(person <0){
				sqId = Math.abs(person);
			}else{
				sqId = staffService.getCommHospitalByStaffId(person);
			}		
			 Page<VStaffRewardPunish> page=new Page<VStaffRewardPunish>();
			 page.setCurrentPage(cp);
			 page.setTotalNum(staffRewardPunishService.countTStaffRewardPunish(sqId));
			 vstaffRewardPunishList= staffRewardPunishService.getCommunicityTStaffRewardPunish(page, sqId);
			 this.pageHtml = page.getPage("staffRewardPunishAction!getAllStaffRewardPunish.action");
			 return  "getAllStaffRewardPunish";
		}
		
	}




	/* 通过员工编号获得员工姓名的方法  
	 *   添加界面 里面通过员工编号回显  员工姓名
	 *   完成*/
	public  String getStaffNumberPunish(){
		 
		String name = staffService.getStaffByStaffNumber(staffNumber).getName();
		String json= "[{\"name\": \""+name+"\"}]";               
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(
						org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		try {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(json);
			out.flush(); 
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	
	/* 转到新增奖惩员工的  
	 * 获得奖惩员工的List 
	 * 完成*/
	public String toAdd(){

		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
        
        if(communityHosGroup!=null){//社区集团
        	return "error";
        }
        else{
	    	int person = GetSessionPerson.getPerson();//获取session中的值
	    	
			//session中取shequId
			int sqId;
			if(person == 0){
				sqId = -1;
			}else if(person <0){
				sqId = Math.abs(person);
				AllStaffNumberList= staffService.getStaffByCommunityHospitalId(sqId);
			}else{
				sqId = staffService.getCommHospitalByStaffId(person);
				AllStaffNumberList= staffService.getStaffByCommunityHospitalId(sqId);
			}
			
			token = TokenProccessor.getInstance().makeToken();//创建令牌
			HttpServletRequest request=ServletActionContext.getRequest();
			request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
	
			return "toAdd";
        }
	}
	
	/*新增员工奖惩  
	 *  
	 *  完成*/
	public String addRewardPunish(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
        
        if(communityHosGroup!=null){//社区集团
        	return "error";
        }
        else{
	    	int person = GetSessionPerson.getPerson();//获取session中的值
	    	
			//-1. 后台验证
			if(staffNumber == null){
				return null;
			}else{
				if(staffNumber == "" || staffNumber.equals("")){
					return "TestErrorStaffR";
				}
			}
			Timestamp datep = staffRewardPunish.getRewardPunishDate();
			if(datep == null){
				return "TestErrorStaffR";
			}
			staff = staffService.getStaffByStaffNumber(staffNumber);
			if(staff == null){
				return "TestErrorStaffR";
			}
			
			///////////////////////////////////////////////////////////////
			int ssqId = staffService.getCommHospitalByStaffId(staff.getStaffId());
			int sqId;
			if(person == 0){
				sqId = -1;
			}else if(person <0){
				sqId = Math.abs(person);
				if(sqId != ssqId){
					return "error";
				}
			}else{
				sqId = staffService.getCommHospitalByStaffId(person);
				if(sqId != ssqId){
					return "error";
				}
			}
			
			HttpServletRequest request=ServletActionContext.getRequest();
			boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
			if(b==true){
				return "addRewardPunish";  //重定向回首页
			}
			request.getSession().removeAttribute("token");//移除session中的token
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String dd = sdf.format(date);
			staffRewardPunish.setTStaff(staff);
			staffRewardPunish.setRewordPunishReason(hhhString);
			Timestamp tt =Timestamp.valueOf(dd);
			staffRewardPunish.setOperateDate(tt);  
			staffRewardPunishService.addStaffRewardPunish(staffRewardPunish);	
		
			return "addRewardPunish";
        }
	}
	
	
	
	
	 /*员工管理的详情信息     完成*/
	   public String staffRewardPunishDetail(){
		   
		   //srpId员工奖惩ID
		   TStaffRewardPunish punish = staffRewardPunishService.getTStaffRewardPunishBysrpId(srpId);
		   if(punish == null ){
			   return "error";
		   }
		   HttpSession session = ServletActionContext.getRequest().getSession();
		   TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
		   if(communityHosGroup!=null){//社区集团
			   communityHospitalGroup=communityHospitalGroupService.getRealComHosGroup(communityHosGroup);
			   int ssqId = staffService.getCommHospitalByStaffId(punish.getTStaff().getStaffId());//社区医院id
			   int gid=CommunityHospitalService.getCommunityHospitalById(ssqId).getTCommunityHospitalGroup().getGId();
			   int sqId=communityHospitalGroup.getGId();
			   if(gid != sqId){
					return "error";
			   }
			   vstaffRewardPunish=staffRewardPunishService.getTStaffRewardPunishByStaffId(srpId);			   
		   }
		   else{

		       int person = GetSessionPerson.getPerson();//获取session中的值
			   
			   int ssqId = staffService.getCommHospitalByStaffId(punish.getTStaff().getStaffId());
			   int sqId;
			   if(person == 0){//平台管理员
					sqId = -1;
				}else if(person <0){//社区负责人
					sqId = Math.abs(person);
					if(sqId != ssqId){
						return "error";
					}
				}else{//员工
					sqId = staffService.getCommHospitalByStaffId(person);
					if(sqId != ssqId){
						return "error";
					}
				}		   
		  vstaffRewardPunish=staffRewardPunishService.getTStaffRewardPunishByStaffId(srpId);
		 }
		return "staffRewardPunishDetail";
	}
	
	
	/* 编辑的跳转方法 点击编辑的时候跳转到编辑界面并且获得实体 完成 */
	public String jumpUpdateStaffRewardPunish() {
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
        
        if(communityHosGroup!=null){//社区集团
        	return "error";
        }
        else{
	    	int person = GetSessionPerson.getPerson();//获取session中的值
	    	
			int sqId;
			 int ssqId = staffService.getCommHospitalByStaffId(staffId);
			if(person == 0){
				sqId = -1;
			}else if(person <0){
				sqId = Math.abs(person);
				if(sqId != ssqId){
					return "error";
				}
			}else{
				sqId = staffService.getCommHospitalByStaffId(person);
				if(sqId != ssqId){
					return "error";
				}
			}
			staffRewardPunish = staffRewardPunishService.getTStaffRewardPunishBysrpId(staffRewardPunishId);
			if(staffRewardPunish == null){
				return "error";
			}
			return "jumpUpdateStaffRewardPunish";
        }

	}

	
		/* 修改奖惩员工的信息        */
	public String editstaffRewardPunish(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
        
        if(communityHosGroup!=null){//社区集团
        	return "error";
        }
        else{
	    	int person = GetSessionPerson.getPerson();//获取session中的值
	    	
			int sqId;
			 int ssqId = staffService.getCommHospitalByStaffId(staffId);
			 if(staffId == 0 || ssqId == 0){
				 return "error";
			 }
			if(person == 0){
				sqId = -1;
			}else if(person <0){
				sqId = Math.abs(person);
				if(sqId != ssqId){
					return "error";
				}
			}else{
				sqId = staffService.getCommHospitalByStaffId(person);
				if(sqId != ssqId){
					return "error";
				}
			}
			TStaff staff = staffService.getStaffById(staffId);
			if(staff == null){
				return "error";
			}
			staffRewardPunish.setTStaff(staff);
			staffRewardPunishService.updateTstaffRewardPunish(staffRewardPunish);
			return "addRewardPunish";
        }
	}

	
	
	
	/*删除奖惩员工  完成 */
	public String deletestaffRewardPunish()
	{	
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
        
        if(communityHosGroup!=null){//社区集团
        	return "error";
        }
        else{
	    	int person = GetSessionPerson.getPerson();//获取session中的值
	    	
			TStaffRewardPunish punish = staffRewardPunishService.getTStaffRewardPunishBysrpId(srpId);
			if(punish == null ){
			      return "error";
		    }
			int ssqId = staffService.getCommHospitalByStaffId(punish.getTStaff().getStaffId());
		    int sqId;
			if(person == 0){
				sqId = -1;
			}else if(person <0){
				sqId = Math.abs(person);
				if(sqId != ssqId){
					return "error";
				}
			}else{
				sqId = staffService.getCommHospitalByStaffId(person);
				if(sqId != ssqId){
					return "error";
				}
			}
			staffRewardPunishService.deleteStaffRewardPunishById(srpId);
			return "deletestaffRewardPunish";
        }
				
	}
	
	
	//////////////////////////////////set和get方法////////////////////////////////////////////////////////////////////
	
	public TStaffRewardPunish getStaffRewardPunish() { 
		return staffRewardPunish;
	}
	public void setStaffRewardPunish(TStaffRewardPunish staffRewardPunish) {
		this.staffRewardPunish = staffRewardPunish;
	}

	public int getSrpId() {
		return srpId;
	}
	public void setSrpId(int srpId) {
		this.srpId = srpId;                                                                                                                                                                                                                                                                                                         
	}
	public VStaffRewardPunish getVstaffRewardPunish() {
		return vstaffRewardPunish;
	}
	public void setVstaffRewardPunish(VStaffRewardPunish vstaffRewardPunish) {
		this.vstaffRewardPunish = vstaffRewardPunish;
	}
	public TCommunityHospital getCommunityHospital() {
		return communityHospital;
	}
	public void setCommunityHospital(TCommunityHospital communityHospital) {
		this.communityHospital = communityHospital;
	}
	public int getComHosId() {
		return comHosId;
	}
	public void setComHosId(int comHosId) {
		this.comHosId = comHosId;
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
	public Timestamp getRewardPunishDate() {
		return rewardPunishDate;
	}
	public void setRewardPunishDate(Timestamp rewardPunishDate) {
		this.rewardPunishDate = rewardPunishDate;
	}
	public String getRewordPunishType() {
		return rewordPunishType;
	}
	public void setRewordPunishType(String rewordPunishType) {
		this.rewordPunishType = rewordPunishType;
	}
	public Double getRewordPunishAmount() {
		return rewordPunishAmount;
	}
	public void setRewordPunishAmount(Double rewordPunishAmount) {
		this.rewordPunishAmount = rewordPunishAmount;
	}
	public String getRewordPunishReason() {
		return rewordPunishReason;
	}
	public void setRewordPunishReason(String rewordPunishReason) {
		this.rewordPunishReason = rewordPunishReason;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public int[] getIds() {
		return ids;
	}
	public void setIds(int[] ids) {
		this.ids = ids;
	}
	public TStaff getStaff() {
		return staff;
	}
	public void setStaff(TStaff staff) {
		this.staff = staff;
	}
	
	public List<TStaff> getAllStaffNumberList() {
		return AllStaffNumberList;
	}
	public void setAllStaffNumberList(List<TStaff> allStaffNumberList) {
		AllStaffNumberList = allStaffNumberList;
	}

	public TOldStaffHos getOldStaffHos() {
		return OldStaffHos;
	}
	public void setOldStaffHos(TOldStaffHos oldStaffHos) {
		OldStaffHos = oldStaffHos;
	}
	public int getStaffRewardPunishId() {
		return staffRewardPunishId;
	}
	public void setStaffRewardPunishId(int staffRewardPunishId) {
		this.staffRewardPunishId = staffRewardPunishId;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public List<Object> getAllstaffId() {
		return allstaffId;
	}
	public void setAllstaffId(List<Object> allstaffId) {
		this.allstaffId = allstaffId;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public Date getFromDate() {
		return fromDate;
	}
	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}
	public Date getToDate() {
		return toDate;
	}
	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}	
	public List<TStaffRewardPunish> getStaffRewardPunishList() {
		return staffRewardPunishList;
	}
	public void setStaffRewardPunishList(
			List<TStaffRewardPunish> staffRewardPunishList) {
		this.staffRewardPunishList = staffRewardPunishList;
	}
	public List<VStaffRewardPunish> getVstaffRewardPunishList() {
		return vstaffRewardPunishList;
	}
	public void setVstaffRewardPunishList(
			List<VStaffRewardPunish> vstaffRewardPunishList) {
		this.vstaffRewardPunishList = vstaffRewardPunishList;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Page<VStaffRewardPunish> getPage() {
		return page;
	}
	public void setPage(Page<VStaffRewardPunish> page) {
		this.page = page;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public int getCommunityHospitalId() {
		return communityHospitalId;
	}
	public void setCommunityHospitalId(int communityHospitalId) {
		this.communityHospitalId = communityHospitalId;
	}
	public String getPageHtml() {
		return pageHtml;
	}
	public void setPageHtml(String pageHtml) {
		this.pageHtml = pageHtml;
	}
	public String getHhhString() {
		return hhhString;
	}
	public void setHhhString(String hhhString) {
		this.hhhString = hhhString;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public TCommunityHospitalGroup getCommunityHospitalGroup() {
		return communityHospitalGroup;
	}

	public void setCommunityHospitalGroup(TCommunityHospitalGroup communityHospitalGroup) {
		this.communityHospitalGroup = communityHospitalGroup;
	}
	
}
