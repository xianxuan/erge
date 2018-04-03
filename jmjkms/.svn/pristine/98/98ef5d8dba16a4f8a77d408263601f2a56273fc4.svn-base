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

import com.jmjk.action.base.BaseAction;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.TDoorKnocking;
import com.jmjk.entity.TStaff;
import com.jmjk.export.DoorKnockingExport;
import com.jmjk.iservice.ICommunityHospitalGroupService;
import com.jmjk.iservice.ICommunityHospitalService;
import com.jmjk.iservice.IDoorKnockingService;
import com.jmjk.iservice.IStaffService;
import com.jmjk.pojo.DoorKnocking;
import com.jmjk.service.HealthFileService;
import com.jmjk.utils.GetSessionPerson;
import com.jmjk.utils.JxlExcel;
import com.jmjk.utils.Page;
import com.jmjk.utils.Resubmit;
import com.jmjk.utils.TokenProccessor;

/**
 * 上门随访Action
 * 
 * @author houzichang
 */
@Component
@Scope("prototype")
@Action(value = "doorKnockingAction", results = {
		@Result(name = "addDoorKnocking", location = "/jsp/doorKnocking/addDoorKnocking.jsp"),
		@Result(name = "saveSuccess", type = "redirectAction", location = "doorKnockingAction!getDoorKnockingListById.action"),
		@Result(name = "getDoorKnockingListById", location = "/jsp/doorKnocking/showDoorKnocking.jsp"),
		@Result(name = "editDoorKnocking", location = "/jsp/doorKnocking/editDoorKnocking.jsp"),
		@Result(name = "doorKnockingDetails", location = "/jsp/doorKnocking/doorKnockingDetails.jsp"),
		@Result(name = "delectDoorKnoching", type = "redirectAction", location = "doorKnockingAction!getDoorKnockingListById.action"),
		@Result(name = "updateSuccess", type = "redirectAction", location = "doorKnockingAction!getDoorKnockingListById.action"),
		@Result(name = "getDoorknockingBySearch", location = "/jsp/doorKnocking/showDoorKnocking.jsp"),
		@Result(name = "success", type = "redirectAction", location = "doorKnockingAction!getDoorKnockingListById.action"),
		@Result(name="error", location="/error.jsp"),
		@Result(name = "test",type = "redirectAction",location = "doorKnockingAction.action"),
		@Result(name="DocDRedir",type = "redirectAction",location="doorKnockingAction!getDoorKnockingListById.action")
})
public class DoorKnockingAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	IDoorKnockingService doorKnockingService;
	@Autowired
	private ICommunityHospitalService communityHospitalService;
	@Autowired
	private ICommunityHospitalGroupService comHosGroupService;
	@Autowired
	IStaffService staffService;
	@Autowired
	HealthFileService healthFileService;

	private TDoorKnocking doorKnocking;
	List<TStaff> staffList;                  // 社区医院员工列表
	int staffsId;                            // 员工id
	
	List<TDoorKnocking> doorKnockingList; // 健康教育列表
	int doorKnockingId;
	private String token;
	
	private String searchText;
	private String doorKnockStatus;
	private Date startDate;
	private Date endDate;
	
	// 导出
	private int flag;
	private int[] ids;
	
	Page page = new Page(); // 分页对象
	int cp = 1; // 当前页码
	String pageHtml; // 分页html
	
	private DoorKnocking doorKnokingTal = new DoorKnocking();    //pojo总的
	private List<DoorKnocking> dorKnckingTalList= new ArrayList<DoorKnocking>();
	private TCommunityHospital communityHospital;
    private String communityHospitalName;
    private int hosId;
    private String groupName;
    private int groupId;
	// 添加上门随访实体
	public String addDoorKnocking() {
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
  		}else if (userId<0 ) {
  			hosId = Math.abs(userId);
  		}else {
  			return "error";
  		}
  		token = TokenProccessor.getInstance().makeToken();//创建令牌
  		HttpServletRequest request=ServletActionContext.getRequest();
  		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
  		staffList = staffService.getStaffByCommunityHospitalId(hosId);// 需有参数值
  		return "addDoorKnocking";
		}
	}

	// 保存上门随访实体
	public String saveDoorKnocking() {
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
    		doorKnocking.setTStaff(staff); 
    		doorKnocking.setCommunityHospitalId(hosId);
    		try {
    			doorKnockingService.saveDoorKnocking(doorKnocking); 
    			return "saveSuccess";
    		} catch (Exception e) {
    			staffList = staffService.getStaffByCommunityHospitalId(hosId);
    			return "addDoorKnocking";
    		}
		}
	}

	
	// 修改上门随访
	public String editDoorKnocking() {
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
    		}else if (userId<0) {
    			hosId = Math.abs(userId);
    		}else {
    			return "error";
    		}
    		
    		if (hosId==doorKnockingService.getDoorKnockingById(doorKnockingId).getCommunityHospitalId()) {
    			staffList = staffService.getStaffByCommunityHospitalId(hosId);
    			doorKnocking=doorKnockingService.getDoorKnockingById(doorKnockingId);
    			staffsId = doorKnocking.getTStaff().getStaffId();
    			return "editDoorKnocking";
    		}
    		return "success";
		}
	}

	// 保存修改健康教育
	public String updateDoorKnocking() {
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
    		}else if (userId<0 ) {
    			hosId = Math.abs(userId);
    		}else {
    			return "error";
    		}
    		if (hosId==doorKnocking.getCommunityHospitalId()) {
    		TStaff staff = staffService.getStaffById(staffsId); // 根据负责人Id获得员工实体
    		doorKnocking.setTStaff(staff);
    		doorKnockingService.updateDoorKnocking(doorKnocking);
    		return "updateSuccess";
    		}
    		return "success";
		}
	}

	// 删除上门随访
	public String deleteDoorKnocking() {
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
    		}else if (userId<0 ) {
    			hosId = Math.abs(userId);
    		}else {
    			return "error";
    		}
    		if (hosId==doorKnockingService.getDoorKnockingById(doorKnockingId).getCommunityHospitalId()) {
    			try {
    				doorKnockingService.deleteDoorKnocking(doorKnockingId);
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			return "delectDoorKnoching";
    		}
    		return "success";
		}
	}
	    
	   // 根据社区医院Id获取上门随访列表......
	
		public String getDoorKnockingListById() {
			HttpSession session = ServletActionContext.getRequest().getSession();
	        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
	        if(group!=null){ 
	        	page.setCurrentPage(cp);
	        	page.setTotalNum(doorKnockingService.getDoorKnockingNumByGroup(group));
	        	doorKnockingList = doorKnockingService.getDoorKnockingListByGroup(group);
	            if (doorKnockingList!=null) {
	        	for (TDoorKnocking tdk:doorKnockingList) {
					doorKnokingTal = new DoorKnocking();
					communityHospital = communityHospitalService.getCommunityHospitalById(tdk.getCommunityHospitalId());
					communityHospitalName = communityHospital.getCommunityHospital();
					doorKnokingTal.setDoornock(tdk);
					doorKnokingTal.setCommunityHospital(communityHospitalName);
					dorKnckingTalList.add(doorKnokingTal);   //总的列表..........
				}
				}
	        	pageHtml = page.getPage("doorKnockingAction!getDoorKnockingListById.action");
				return "getDoorKnockingListById";
	        }else {
	        	//从session里拿到当前登录用户的id
				int userId = GetSessionPerson.getPerson();
				//user等于0,平台管理员
				if (userId==0) {
					page.setCurrentPage(cp);
					page.setTotalNum(doorKnockingService.getDoorKnockingNumByAll());
					doorKnockingList = doorKnockingService.getDoorKnockingListByAll(page);
					if (doorKnockingList!=null) {
						
					for (TDoorKnocking tdk:doorKnockingList) {
						doorKnokingTal = new DoorKnocking();
						hosId = tdk.getCommunityHospitalId();
						communityHospital = communityHospitalService.getCommunityHospitalById(hosId);//社区医院实体
	    				groupName = communityHospital.getTCommunityHospitalGroup().getGroupName();//集团名称
	    				communityHospitalName = communityHospital.getCommunityHospital(); //社区医院名称
	    				doorKnokingTal.setDoornock(tdk);
	    				doorKnokingTal.setCommunitygroup(groupName);
	    				doorKnokingTal.setCommunityHospital(communityHospitalName);
	    				dorKnckingTalList.add(doorKnokingTal);   //总的列表
					}
					}
					pageHtml = page.getPage("doorKnockingAction!getDoorKnockingListById.action");
					return "getDoorKnockingListById";
				}
				int hosId = 0;
				//user大于0,员工id
				if (userId>0) {
					if(healthFileService.getOldStaffHosByStaffId(userId)) {// 判断员工是否为责任医生，若是，则只能看到所对应的老人){
						page.setCurrentPage(cp);
						page.setTotalNum(doorKnockingService.getDoorKnockingNumForSpecial(userId));
						doorKnockingList = doorKnockingService.getDoorKnockingListForSpecial(userId,page);
						if (doorKnockingList!=null) {
							
						for (TDoorKnocking tdk:doorKnockingList) {
							doorKnokingTal = new DoorKnocking();
							doorKnokingTal.setDoornock(tdk);
							dorKnckingTalList.add(doorKnokingTal);
						}
						}
						pageHtml = page.getPage("doorKnockingAction!getDoorKnockingListById.action");
						return "getDoorKnockingListById";
					}
					hosId = staffService.getCommHospitalByStaffId(userId);
				//user小于0,社区负责人id;
				}else if (userId<0) {
					hosId = Math.abs(userId);
				}else {
					return "error";
				}
				page.setCurrentPage(cp);
				page.setTotalNum(doorKnockingService.getDoorKnockingNumByComhosId(hosId));
				doorKnockingList = doorKnockingService.getDoorKnockingListByComhosId(hosId,page);
				if (doorKnockingList!=null) {
				
				for (TDoorKnocking tdk:doorKnockingList) {
					doorKnokingTal = new DoorKnocking();
					doorKnokingTal.setDoornock(tdk);
					dorKnckingTalList.add(doorKnokingTal);
				}	
				}
				pageHtml = page.getPage("doorKnockingAction!getDoorKnockingListById.action");
				return "getDoorKnockingListById";
			}
		}

	// 上门随访详情
	public String doorKnockingDetails() {
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){ 
        	staffList = staffService.getStaffByCommunityHospitalId(hosId);
			doorKnocking = doorKnockingService.getDoorKnockingById(doorKnockingId);
			 hosId = doorKnocking.getCommunityHospitalId();
			communityHospital = communityHospitalService.getCommunityHospitalById(hosId);
			communityHospitalName = communityHospital.getCommunityHospital(); //社区医院名称
			doorKnokingTal.setDoornock(doorKnocking);
			doorKnokingTal.setCommunityHospital(communityHospitalName);
			staffsId = doorKnocking.getTStaff().getStaffId();
			return "doorKnockingDetails";
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
    			doorKnocking = doorKnockingService.getDoorKnockingById(doorKnockingId);
    			hosId = doorKnocking.getCommunityHospitalId();
    			communityHospital = communityHospitalService.getCommunityHospitalById(hosId);
    			communityHospitalName = communityHospital.getCommunityHospital(); //社区医院名称
    			groupName = communityHospital.getTCommunityHospitalGroup().getGroupName();
    			doorKnokingTal.setCommunitygroup(groupName);
    			doorKnokingTal.setDoornock(doorKnocking);
    			doorKnokingTal.setCommunityHospital(communityHospitalName);
    			staffsId = doorKnocking.getTStaff().getStaffId();
    			return "doorKnockingDetails";
    		}
    		if (hosId==doorKnockingService.getDoorKnockingById(doorKnockingId).getCommunityHospitalId()) {
    			staffList = staffService.getStaffByCommunityHospitalId(hosId);
    			doorKnocking = doorKnockingService.getDoorKnockingById(doorKnockingId);
    			doorKnokingTal.setDoornock(doorKnocking);
    			/*dorKnckingTalList.add(doorKnokingTal);*/
    			staffsId = doorKnocking.getTStaff().getStaffId();
    			return "doorKnockingDetails";
    		}
    		return "success";
		}
	}
   // 查询
	public String getDoorknockingBySearch(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){
        	groupId = group.getGId();
        	page.setCurrentPage(cp);
			page.setTotalNum(doorKnockingService.getDoorkNumGroupNumBySearch(groupId, searchText, doorKnockStatus, startDate, endDate));
			doorKnockingList = doorKnockingService.getDoorkListGroupListBySearch(groupId, searchText, doorKnockStatus, startDate, endDate, page);
			for (TDoorKnocking tdk:doorKnockingList) {
				doorKnokingTal = new DoorKnocking();
				communityHospital = communityHospitalService.getCommunityHospitalById(tdk.getCommunityHospitalId());
				communityHospitalName = communityHospital.getCommunityHospital();
				doorKnokingTal.setDoornock(tdk);
				doorKnokingTal.setCommunityHospital(communityHospitalName);
				dorKnckingTalList.add(doorKnokingTal);   //总的列表..........
			}
			pageHtml = page.getPage("doorKonckingAction!getDoorknockingBySearch.action?searchText="+searchText+"&doorKnockStatus="+doorKnockStatus+"&startDate="+startDate+"&endDate="+endDate);
			return "getDoorknockingBySearch";
        }else {
        	 //从session里拿到当前登录用户的id
    		int userId = GetSessionPerson.getPerson();
    		int hosId = 0;
    		//user大于0,员工id
    		if (userId>0) {
    			/*hosId = staffService.getCommHospitalByStaffId(userId);*/
    			page.setCurrentPage(cp);
        		page.setTotalNum(doorKnockingService.getDoorNumSpecialBySearch(userId, searchText, doorKnockStatus, startDate, endDate));
        		doorKnockingList = doorKnockingService.getDoorListSpecialBySearch(userId, searchText, doorKnockStatus, startDate, endDate, page);
        		for (TDoorKnocking tdk:doorKnockingList) {
        			doorKnokingTal = new DoorKnocking();
    				doorKnokingTal.setDoornock(tdk);        
    				dorKnckingTalList.add(doorKnokingTal);
    			}
        		pageHtml = page.getPage("doorKnockingAction!getDoorknockingBySearch.action?searchText="+searchText+"&doorKnockStatus="+doorKnockStatus+"&startDate="+startDate+"&endDate="+endDate);
        		return "getDoorknockingBySearch";
    		//user小于0,社区负责人id;等于0,平台admin
    		}else if (userId<0 ) {
    			hosId = Math.abs(userId);
    		}else {
    			page.setCurrentPage(cp);
    			page.setTotalNum(doorKnockingService.getDoorKnockingNumBySearch(searchText, doorKnockStatus, startDate, endDate));
    			doorKnockingList = doorKnockingService.getDoorKnockingListBySearch(searchText, doorKnockStatus, startDate, endDate, page);
    			for (TDoorKnocking tdk:doorKnockingList) {
					doorKnokingTal = new DoorKnocking();
					hosId = tdk.getCommunityHospitalId();
					communityHospital = communityHospitalService.getCommunityHospitalById(hosId);//社区医院实体
    				groupName = communityHospital.getTCommunityHospitalGroup().getGroupName();//集团名称
    				communityHospitalName = communityHospital.getCommunityHospital(); //社区医院名称
    				doorKnokingTal.setDoornock(tdk);
    				doorKnokingTal.setCommunitygroup(groupName);
    				doorKnokingTal.setCommunityHospital(communityHospitalName);
    				dorKnckingTalList.add(doorKnokingTal);   //总的列表
				}
    			pageHtml = page.getPage("doorKonckingAction!getDoorknockingBySearch.action?searchText="+searchText+"&doorKnockStatus="+doorKnockStatus+"&startDate="+startDate+"&endDate="+endDate);
    			return "getDoorknockingBySearch";
    		}
    		page.setCurrentPage(cp);
    		page.setTotalNum(doorKnockingService.getTDoorKnockingNumBySearch(hosId, searchText,doorKnockStatus, startDate, endDate));
    		doorKnockingList = doorKnockingService.getTDoorKnockingListBySearch(hosId, searchText,doorKnockStatus, startDate, endDate, page);
    		for (TDoorKnocking tdk:doorKnockingList) {
    			doorKnokingTal = new DoorKnocking();
				doorKnokingTal.setDoornock(tdk);        
				dorKnckingTalList.add(doorKnokingTal);
			}
    		pageHtml = page.getPage("doorKnockingAction!getDoorknockingBySearch.action?searchText="+searchText+"&doorKnockStatus="+doorKnockStatus+"&startDate="+startDate+"&endDate="+endDate);
    		return "getDoorknockingBySearch";
		}
	}
	
	//导出
	@SuppressWarnings("rawtypes")
	public String test() throws Exception{
		  //从session里拿到当前登录用户的id
		int userId = GetSessionPerson.getPerson();
		
		// 判断flag -----1 导出全部   2 导出本页
		if(flag == 1){ // 导出全部
			List<DoorKnockingExport> exportDoorKnocking = new ArrayList<DoorKnockingExport>();
			int hosId = 0;
			//user大于0,员工id
			if (userId>0) {
				hosId = staffService.getCommHospitalByStaffId(userId);
			//user小于0,社区负责人id;等于0,平台admin
			}else if (userId<0 || userId ==0) {
				hosId = Math.abs(userId);
			}
			doorKnockingList = doorKnockingService.geTDoorKnockingListById(hosId);
			if (doorKnockingList != null) {
				for (TDoorKnocking doorKnocking : doorKnockingList) {
					DoorKnockingExport sp = new DoorKnockingExport(doorKnocking);
					exportDoorKnocking.add(sp);
				}
			}
			DoorKnockingExport sp = new DoorKnockingExport();
			String[] titles = sp.getTitles();
			JxlExcel Jxl = new JxlExcel(titles);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("content-disposition", "attachment;filename="+1+".xls");
			ServletOutputStream output = response.getOutputStream();
			Jxl.write(exportDoorKnocking, output);
		    response.flushBuffer();
		    return null;}
		if (flag == 2) { // 导出本页
			List<DoorKnockingExport>  doorKnockingList= new ArrayList<DoorKnockingExport>();
			if (ids!=null) {
			  for (int i = 0; i < ids.length; i++) {
				TDoorKnocking st = doorKnockingService.getDoorKnockingById(ids[i]);
				if (st != null) {
					DoorKnockingExport sp = new DoorKnockingExport(st);
					doorKnockingList.add(sp);
				}
			}	
			}
			DoorKnockingExport sp = new DoorKnockingExport();
			String[] titles = sp.getTitles();
			JxlExcel Jxl = new JxlExcel(titles);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("content-disposition", "attachment;filename="+1+".xls");
			ServletOutputStream output = response.getOutputStream();
			Jxl.write(doorKnockingList, output);
		    response.flushBuffer();
		    return null;
		}
		return "test";}
	
	/* getters setters */
	public TDoorKnocking getDoorKnocking() {
		return doorKnocking;
	}

	public void setDoorKnocking(TDoorKnocking doorKnocking) {
		this.doorKnocking = doorKnocking;
	}

	public List<TStaff> getStaffList() {
		return staffList;
	}

	public void setStaffList(List<TStaff> staffList) {
		this.staffList = staffList;
	}

	public int getStaffsId() {
		return staffsId;
	}

	public void setStaffsId(int staffsId) {
		this.staffsId = staffsId;
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

	public List<TDoorKnocking> getDoorKnockingList() {
		return doorKnockingList;
	}

	public void setDoorKnockingList(List<TDoorKnocking> doorKnockingList) {
		this.doorKnockingList = doorKnockingList;
	}

	public int getDoorKnockingId() {
		return doorKnockingId;
	}

	public void setDoorKnockingId(int doorKnockingId) {
		this.doorKnockingId = doorKnockingId;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	

	public String getDoorKnockStatus() {
		return doorKnockStatus;
	}

	public void setDoorKnockStatus(String doorKnockStatus) {
		this.doorKnockStatus = doorKnockStatus;
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

	public IDoorKnockingService getDoorKnockingService() {
		return doorKnockingService;
	}

	public void setDoorKnockingService(IDoorKnockingService doorKnockingService) {
		this.doorKnockingService = doorKnockingService;
	}

	public IStaffService getStaffService() {
		return staffService;
	}

	public void setStaffService(IStaffService staffService) {
		this.staffService = staffService;
	}

	public HealthFileService getHealthFileService() {
		return healthFileService;
	}

	public void setHealthFileService(HealthFileService healthFileService) {
		this.healthFileService = healthFileService;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public DoorKnocking getDoorKnokingTal() {
		return doorKnokingTal;
	}

	public void setDoorKnokingTal(DoorKnocking doorKnokingTal) {
		this.doorKnokingTal = doorKnokingTal;
	}

	public List<DoorKnocking> getDorKnckingTalList() {
		return dorKnckingTalList;
	}

	public void setDorKnckingTalList(List<DoorKnocking> dorKnckingTalList) {
		this.dorKnckingTalList = dorKnckingTalList;
	}

	public ICommunityHospitalService getCommunityHospitalService() {
		return communityHospitalService;
	}

	public void setCommunityHospitalService(
			ICommunityHospitalService communityHospitalService) {
		this.communityHospitalService = communityHospitalService;
	}

	public ICommunityHospitalGroupService getComHosGroupService() {
		return comHosGroupService;
	}

	public void setComHosGroupService(
			ICommunityHospitalGroupService comHosGroupService) {
		this.comHosGroupService = comHosGroupService;
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
