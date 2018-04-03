package com.jmjk.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.formula.functions.T;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jmjk.action.base.BaseAction;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.TEquipmentManage;
import com.jmjk.entity.TMaintenance;
import com.jmjk.entity.TStaff;
import com.jmjk.export.EquipmentManageExport;
import com.jmjk.iservice.ICommunityHospitalService;
import com.jmjk.iservice.IEquipmentManageService;
import com.jmjk.iservice.IMaintenanceService;
import com.jmjk.iservice.IStaffService;
import com.jmjk.pojo.EquipmentManage;
import com.jmjk.service.CommunityHospitalService;
import com.jmjk.utils.GetSessionPerson;
import com.jmjk.utils.JxlExcel;
import com.jmjk.utils.Page;
import com.jmjk.utils.Resubmit;
import com.jmjk.utils.TokenProccessor;

@Component
@Scope("prototype")
@Action(value="equipmentManageAction",results={
	    @Result(name="addEquipmentManage",location="/jsp/equipmentManage/addEquipmentManage.jsp"),
	    @Result(name="saveEquipmentSuccess",type="redirectAction",location="equipmentManageAction!getEquipmentManageListById.action"),
	    @Result(name="getEquipmentManageListById",location="/jsp/equipmentManage/showEquipmentManage.jsp"),
	    @Result(name="editEquipmentManage",location="/jsp/equipmentManage/editEquipmentManage.jsp"),
	    @Result(name="updateEquipmentManage",type="redirectAction",location="equipmentManageAction!getEquipmentManageListById.action"),
	    @Result(name="deleteEquipmentManage",type="redirectAction",location="equipmentManageAction!getEquipmentManageListById.action"),
	    @Result(name="equipmentManageDetails",location="/jsp/equipmentManage/equipmentManageDetails.jsp"),
		@Result(name="getEquipmentManageBySearch",location="/jsp/equipmentManage/showEquipmentManage.jsp"),
	    @Result(name="addMaintence",location="/jsp/equipmentManage/addMaintence.jsp"),
	    @Result(name="saveMaintenanceSuccess",type="redirectAction",location="equipmentManageAction!getMaintenanceListById.action", params={"equipmentManageId","${equipmentManageId}"}),
	    @Result(name="updateSuccess",type="redirectAction",location="equipmentManageAction!getMaintenanceListById.action", params={"equipmentManageId","${equipmentManageId}"}),
	    @Result(name="editMaintenance",location="/jsp/equipmentManage/editMaintence.jsp"),
	    @Result(name="deletMaintenance",type="redirectAction",location="equipmentManageAction!getMaintenanceListById.action" ,params={"equipmentManageId","${equipmentManageId}"}),
        @Result(name="getMaintenanceListById",location="/jsp/equipmentManage/seeMaintence.jsp"),
        @Result(name="success",type="redirectAction",location="equipmentManageAction!getMaintenanceListById.action", params={"equipmentManageId","${equipmentManageId}"}),
	    @Result(name="successes",type="redirectAction",location="equipmentManageAction!getMaintenanceListById.action", params={"equipmentManageId","${equipmentManageId}"}),
	    @Result(name="test",type="redirectAction",location="equipmentManageAction.action"),
	    @Result(name="DocDRedir",type="redirectAction",location="equipmentManageAction!getEquipmentManageListById.action"),
	    @Result(name="DocDRedirs",type="redirectAction",location="equipmentManageAction!getMaintenanceListById.action", params={"equipmentManageId","${equipmentManageId}"})
} )
public class EquipmentManageAction extends BaseAction {
    @Autowired
	private IEquipmentManageService equipmentManageService;//健康教育Service
    @Autowired
    private ICommunityHospitalService communityHospitalService;
    @Autowired
    private IStaffService staffService;
    @Autowired
    private IMaintenanceService maintenanceService;
    
    
    private TEquipmentManage equipmentManage;
    private List<TStaff> staffList;
    private int staffsId;
    
    private List<TEquipmentManage> equipmentManageList;
    private int equipmentManageId;
    
    //分页
    private Page page = new Page();
    private int cp=1;
    private String pageHtml;
    
    //查询
    private String strSearch;
    private String strSearchText;
    
    //获得设备维修记录列表
	private List<TMaintenance> maintenanceList;
    
	//维修记录实体
	 private TMaintenance maintenance;
	
	 //维修记录id
	 private int manitenanceId;
	 private String token;
	 
	// 导出
	private int flag;
	private int[] ids;
	
	//寒假添加
	private EquipmentManage equipmentTal = new EquipmentManage();
	private List<EquipmentManage> equipmentListTal = new ArrayList<EquipmentManage>();
	private TCommunityHospital communityHospital;
    private String communityHospitalName;
    private int hosId;
    private String groupName;
	private int groupId;
    
    //添加设备实体
    public String addEquipmentManage(){
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
    		}
    		token = TokenProccessor.getInstance().makeToken();//创建令牌
    		HttpServletRequest request=ServletActionContext.getRequest();
    		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
        	staffList = staffService.getStaffByCommunityHospitalId(hosId);
    		return "addEquipmentManage";
		}
    }
    //保存设备实体
    public String saveEquipmentManage(){
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
    		}
    		HttpServletRequest request=ServletActionContext.getRequest();
    		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
    		if(b==true){
    			return "DocDRedir";  //重定向回首页
    		}
    		request.getSession().removeAttribute("token");//移除session中的token
        	TStaff staff = staffService.getStaffById(staffsId);
        	equipmentManage.setTStaff(staff);
        	TCommunityHospital communityHospital=communityHospitalService.getCommunityHospitalById(hosId); 	
        	
        	equipmentManage.setTCommunityHospital(communityHospital);
        	
        	try {
    			equipmentManageService.saveEquipmentManage(equipmentManage);
    		} catch (Exception e) {
    			
    			staffList = staffService.getStaffByCommunityHospitalId(hosId);
    			return "addEquipmentManage";

    		}
    		return "saveEquipmentSuccess";
		}
    }
    
    //修改设备管理
    public  String editEquipmentManage(){
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
    		}
    		if (hosId == equipmentManageService.getEquipmentManageById(equipmentManageId).getTCommunityHospital().getCommunityHospitalId()) {
    			equipmentManage=equipmentManageService.getEquipmentManageById(equipmentManageId);	
    	    	staffList = staffService.getStaffByCommunityHospitalId(hosId);    	
    	    	staffsId = equipmentManage.getTStaff().getStaffId();
    	    	return "editEquipmentManage";
    		}
        	return "success";
		}
    }
    //保存修改设备
    public String updateEquipmentManage(){
    	HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){
        	return "error";      //如果集团能够保存修改的话报错
        }else {
        	//从session里拿到当前登录用户的id
        	int userId = GetSessionPerson.getPerson();
        	//"equipmentManageId"
        	int hosId = 0;
    		//user大于0,员工id
    		if (userId>0) {
    			hosId = staffService.getCommHospitalByStaffId(userId);
    		//user小于0,社区负责人id;等于0,平台admin
    		}else if (userId<0 ) {
    			hosId = Math.abs(userId);
    		}
    		TEquipmentManage equip = equipmentManageService.getEquipmentManageById(equipmentManageId);
    		if (hosId==equip.getTCommunityHospital().getCommunityHospitalId()) {
    			TStaff staff = staffService.getStaffById(staffsId);
    			equipmentManage.setEquipId(equipmentManageId);
    			TCommunityHospital communityHospital=communityHospitalService.getCommunityHospitalById(hosId);
    	    	equipmentManage.setTCommunityHospital(communityHospital);
    	    	if(staff != null){
    	    		equipmentManage.setTStaff(staff);
    	    		equipmentManageService.updateEquipmentManage(equipmentManage);
    	    	}
    			return "updateEquipmentManage";
    		}    	
		}
		return "success";
    }
    //删除设备管理
    public String deleteEquipmentManage(){
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
    		}
    		
    		if (hosId == equipmentManageService.getEquipmentManageById(equipmentManageId).getTCommunityHospital().getCommunityHospitalId()) {
    			try {
    				equipmentManageService.deleteEquipmentManage(equipmentManageId);
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			return "deleteEquipmentManage";
    		}   	
		}
		return "success";    	
    }
    
  //根据社区医院id 获取设备列表
    public String getEquipmentManageListById(){
    	HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){ 
        	page.setCurrentPage(cp);
        	page.setTotalNum(equipmentManageService.getEquipmentNumByGroup(group));
        	equipmentManageList = equipmentManageService.geTEquipmentListByGroup(group);
        	if(equipmentManageList!=null){
        	for (TEquipmentManage tee:equipmentManageList) {
				equipmentTal = new EquipmentManage();
				hosId = tee.getTCommunityHospital().getCommunityHospitalId();
				communityHospital = communityHospitalService.getCommunityHospitalById(hosId);
				communityHospitalName = communityHospital.getCommunityHospital();
				equipmentTal.setEquipment(tee);
				equipmentTal.setCommunityHospital(communityHospitalName);
				equipmentListTal.add(equipmentTal);   //总的列表..........
			}
        	}
        	pageHtml=page.getPage("equipmentManageAction!getEquipmentManageListById.action");    	
        	return "getEquipmentManageListById";
        }else {
        	//从session里拿到当前登录用户的id
        	int userId = GetSessionPerson.getPerson();
        	//user等于0，平台管理员
        	if (userId==0) {
        		page.setCurrentPage(cp);
            	page.setTotalNum(equipmentManageService.getEquipmentManageNumByAll());
            	equipmentManageList=equipmentManageService.getEquipmentManageListByAll(page);
            	if (equipmentManageList!=null) {
				
            	for (TEquipmentManage tee:equipmentManageList) {
					equipmentTal = new EquipmentManage();
					hosId = tee.getTCommunityHospital().getCommunityHospitalId();
					communityHospital = communityHospitalService.getCommunityHospitalById(hosId);//社区医院实体
    				groupName = communityHospital.getTCommunityHospitalGroup().getGroupName();//集团名称
    				communityHospitalName = communityHospital.getCommunityHospital(); //社区医院名称
    				equipmentTal.setEquipment(tee);
    				equipmentTal.setCommunitygroup(groupName);
    				equipmentTal.setCommunityHospital(communityHospitalName);
    				equipmentListTal.add(equipmentTal);   //总的列表
				}	
				}
        		pageHtml=page.getPage("equipmentManageAction!getEquipmentManageListById.action");    	
            	return "getEquipmentManageListById";
    		}
        	int hosId = 0;
    		//user大于0,员工id
    		if (userId>0) {
    			/*hosId = staffService.getCommHospitalByStaffId(userId);*/
    			page.setCurrentPage(cp);
            	page.setTotalNum(equipmentManageService.getEquipNumSpecial(userId));
            	equipmentManageList=equipmentManageService.getEquipListSpecial(userId, page);
            	if (equipmentManageList!=null) {
					
            	for (TEquipmentManage tee:equipmentManageList) {
            		equipmentTal = new EquipmentManage();
    				equipmentTal.setEquipment(tee);
    				equipmentListTal.add(equipmentTal);
    			}
				}
        		pageHtml=page.getPage("equipmentManageAction!getEquipmentManageListById.action");    	
            	return "getEquipmentManageListById";
    		//user小于0,社区负责人id;等于0,平台admin
    		}else if (userId<0) {
    			hosId = Math.abs(userId);
    		}
        	page.setCurrentPage(cp);
        	page.setTotalNum(equipmentManageService.getEquipmentManageNumByComhosId(hosId));
        	equipmentManageList=equipmentManageService.getEquipmentManageListByComhosId(hosId, page);
        	if (equipmentManageList!=null) {
				
        	for (TEquipmentManage tee:equipmentManageList) {
        		equipmentTal = new EquipmentManage();
				equipmentTal.setEquipment(tee);
				equipmentListTal.add(equipmentTal);
			}
			}
    		pageHtml=page.getPage("equipmentManageAction!getEquipmentManageListById.action");    	
        	return "getEquipmentManageListById";
		}
    }
    
    //设备详情
    public String getEquipmentManageDetails(){
    	HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){
        	staffList = staffService.getAllStaff();
			equipmentManage = equipmentManageService.getEquipmentManageById(equipmentManageId);
			hosId = equipmentManage.getTCommunityHospital().getCommunityHospitalId();
			communityHospital = communityHospitalService.getCommunityHospitalById(hosId);
			communityHospitalName = communityHospital.getCommunityHospital(); //社区医院名称
			equipmentTal.setEquipment(equipmentManage);
			equipmentTal.setCommunityHospital(communityHospitalName);
			staffsId = equipmentManage.getTStaff().getStaffId();
			maintenanceList = maintenanceService.getMaintenanceListById(equipmentManageId);
			return "equipmentManageDetails";
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
    			equipmentManage = equipmentManageService.getEquipmentManageById(equipmentManageId);
    			hosId = equipmentManage.getTCommunityHospital().getCommunityHospitalId();
    			communityHospital = communityHospitalService.getCommunityHospitalById(hosId);
    			communityHospitalName = communityHospital.getCommunityHospital(); //社区医院名称
    			groupName = communityHospital.getTCommunityHospitalGroup().getGroupName();
    			equipmentTal.setEquipment(equipmentManage);
    			equipmentTal.setCommunitygroup(groupName);
    			equipmentTal.setCommunityHospital(communityHospitalName);
    			staffsId = equipmentManage.getTStaff().getStaffId();
    			maintenanceList = maintenanceService.getMaintenanceListById(equipmentManageId);
    			return "equipmentManageDetails";
    		}
    		if (hosId == equipmentManageService.getEquipmentManageById(equipmentManageId).getTCommunityHospital().getCommunityHospitalId()) {
    			equipmentManage = equipmentManageService.getEquipmentManageById(equipmentManageId);
    			equipmentTal.setEquipment(equipmentManage);
    	    	staffList = staffService.getStaffByCommunityHospitalId(hosId);
    	    	staffsId = equipmentManage.getTStaff().getStaffId();
    	    	maintenanceList = maintenanceService.getMaintenanceListById(equipmentManageId);
    			return "equipmentManageDetails";
    		}
    		return "success";
		}
    }
    //查询获得设备实体
    public String  getEquipmentManageBySearch(){
    	HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){
        	groupId = group.getGId();
        	page.setCurrentPage(cp);
        	page.setTotalNum(equipmentManageService.getEquipNumGroupBySearch(groupId, strSearch, strSearchText));
        	equipmentManageList = equipmentManageService.getEquipListGroupBySearch(groupId, strSearch, strSearchText, page);
        	for (TEquipmentManage tee:equipmentManageList) {
				equipmentTal = new EquipmentManage();
				hosId = tee.getTCommunityHospital().getCommunityHospitalId();
				communityHospital = communityHospitalService.getCommunityHospitalById(hosId);
				communityHospitalName = communityHospital.getCommunityHospital();
				equipmentTal.setEquipment(tee);
				equipmentTal.setCommunityHospital(communityHospitalName);
				equipmentListTal.add(equipmentTal);   //总的列表..........
			}
	    	pageHtml = page.getPage("equipmentManageAction!getEquipmentManageBySearch.action");
	    	return "getEquipmentManageBySearch";
        }else {
        	//从session里拿到当前登录用户的id
        	int userId = GetSessionPerson.getPerson();
        	int hosId = 0;
    		//user大于0,员工id
    		if (userId>0) {
    			/*hosId = staffService.getCommHospitalByStaffId(userId);*/
    			page.setCurrentPage(cp);
            	page.setTotalNum(equipmentManageService.getEquipNumSpecialBySearch(userId, strSearch, strSearchText));
        		equipmentManageList = equipmentManageService.getEquipListSpecialBySearch(userId, strSearch, strSearchText, page);
        		for (TEquipmentManage tee:equipmentManageList) {
    				equipmentTal = new EquipmentManage();
    				equipmentTal.setEquipment(tee);
    				equipmentListTal.add(equipmentTal);
    			}
            	pageHtml = page.getPage("equipmentManageAction!getEquipmentManageBySearch.action");
            	return "getEquipmentManageBySearch";
    		//user小于0,社区负责人id;等于0,平台admin
    		}else if (userId<0 ) {
    			hosId = Math.abs(userId);
    		}else {
    			page.setCurrentPage(cp);
    	    	page.setTotalNum(equipmentManageService.getTEquipmentManageNumBySearch(strSearch, strSearchText));
    			equipmentManageList = equipmentManageService.getTEquipmentManageListBySearch(strSearch, strSearchText, page);
    			for (TEquipmentManage tee:equipmentManageList) {
					equipmentTal = new EquipmentManage();
					hosId = tee.getTCommunityHospital().getCommunityHospitalId();
					communityHospital = communityHospitalService.getCommunityHospitalById(hosId);//社区医院实体
    				groupName = communityHospital.getTCommunityHospitalGroup().getGroupName();//集团名称
    				communityHospitalName = communityHospital.getCommunityHospital(); //社区医院名称
    				equipmentTal.setEquipment(tee);
    				equipmentTal.setCommunitygroup(groupName);
    				equipmentTal.setCommunityHospital(communityHospitalName);
    				equipmentListTal.add(equipmentTal);   //总的列表		
				}
    	    	pageHtml = page.getPage("equipmentManageAction!getEquipmentManageBySearch.action");
    	    	return "getEquipmentManageBySearch";
    		}
        	page.setCurrentPage(cp);
        	page.setTotalNum(equipmentManageService.getEquipmentManageNumBySearch(hosId, strSearch, strSearchText));
    		equipmentManageList = equipmentManageService.getEquipmentManageListBySearch(hosId, strSearch, strSearchText, page);
    		for (TEquipmentManage tee:equipmentManageList) {
				equipmentTal = new EquipmentManage();
				equipmentTal.setEquipment(tee);
				equipmentListTal.add(equipmentTal);
			}
        	pageHtml = page.getPage("equipmentManageAction!getEquipmentManageBySearch.action");
        	return "getEquipmentManageBySearch";
		}
    } 
    //添加维修记录实体
    public String addMaintence(){
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
    		}
    		token = TokenProccessor.getInstance().makeToken();//创建令牌
    		HttpServletRequest request=ServletActionContext.getRequest();
    		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
        	equipmentManage = equipmentManageService.getEquipmentManageById(equipmentManageId);
    		return "addMaintence";
		}
    }
    //保存维修记录实体
    public String saveMaintence(){
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
    		}
        	TEquipmentManage equipmentManage = equipmentManageService.getEquipmentManageById(equipmentManageId);
        	if(equipmentManage != null ){
        		HttpServletRequest request=ServletActionContext.getRequest();
        		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
        		if(b==true){
        			return "DocDRedirs";  //重定向回首页
        		}
        		request.getSession().removeAttribute("token");//移除session中的token
        		maintenance.setTEquipmentManage(equipmentManage);
        		maintenanceService.saveMaintenance(maintenance);
        	}
        	
    		staffList = staffService.getStaffByCommunityHospitalId(hosId);
    		return "saveMaintenanceSuccess";
		}
    }
    //更新维修记录
    public String updateMaintenance(){
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
    		}
    		equipmentManage = equipmentManageService.getEquipmentManageById(equipmentManageId);
    		if (hosId == equipmentManageService.getEquipmentManageById(equipmentManageId).getTCommunityHospital().getCommunityHospitalId()) {
    			TEquipmentManage equipmentManage = equipmentManageService.getEquipmentManageById(equipmentManageId);
    	    	maintenance.setTEquipmentManage(equipmentManage);
    	    	maintenanceService.updateMaintenance(maintenance);
    			return "updateSuccess";	
    		}
        	return "successes";
		}
    }
    //根据设备Id获得维修记录列表
    public String getMaintenanceListById(){
    	HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){
        	page.setCurrentPage(cp);
        	page.setTotalNum(maintenanceService.getMaintenanceNumById(equipmentManageId));
        	maintenanceList =maintenanceService.getMaintenanceListById(equipmentManageId);
        	pageHtml = page.getPage("equipmentManageAction!getMaintenanceListById.action?equipmentManageId="+equipmentManageId);
        	return "getMaintenanceListById";
        }else {
        	//从session里拿到当前登录用户的id
        	int userId = GetSessionPerson.getPerson();
        	//user等于0,平台管理员
        	if (userId==0) {
        		page.setCurrentPage(cp);
            	page.setTotalNum(maintenanceService.getMaintenanceNumById(equipmentManageId));
            	maintenanceList =maintenanceService.getMaintenanceListById(equipmentManageId);
            	pageHtml = page.getPage("equipmentManageAction!getMaintenanceListById.action?equipmentManageId="+equipmentManageId);
            	return "getMaintenanceListById";
    		}
        	int hosId = 0;
    		//user大于0,员工id
    		if (userId>0) {
    			hosId = staffService.getCommHospitalByStaffId(userId);
    		//user小于0,社区负责人id;等于0,平台admin
    		}else if (userId<0 ) {
    			hosId = Math.abs(userId);
    		}
        	page.setCurrentPage(cp);
        	page.setTotalNum(maintenanceService.getMaintenanceNumById(equipmentManageId));
        	maintenanceList =maintenanceService.getMaintenanceListById(equipmentManageId, page);
        	pageHtml = page.getPage("equipmentManageAction!getMaintenanceListById.action?equipmentManageId="+equipmentManageId);
        	return "getMaintenanceListById";
		}
    }
    
    //修改维修记录
    public String editMaintenance(){
    	HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){
        	return "error";
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
    		}
    		if (hosId == equipmentManageService.getEquipmentManageById(equipmentManageId).getTCommunityHospital().getCommunityHospitalId()) {
    			staffList = staffService.getStaffByCommunityHospitalId(hosId);
    			maintenance = maintenanceService.getMaintenanceById(manitenanceId);
    	    	equipmentManage = equipmentManageService.getEquipmentManageById(equipmentManageId);
    			return "editMaintenance";
    		}
    		return "successes";
		}
    }
    //删除维修记录
    public String deletMaintenance(){
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
    		}
    		
    		if (hosId == equipmentManageService.getEquipmentManageById(equipmentManageId).getTCommunityHospital().getCommunityHospitalId()) {
    			try {
    				equipmentManageId = maintenanceService.getMaintenanceById(manitenanceId).getTEquipmentManage().getEquipId(); 
    				maintenanceService.deleteMaintenance(manitenanceId);
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			} 
    			return "deletMaintenance";
    		}
        	return "successes";
		}
    }
    // 导出
    public String test() throws Exception{

    	//从session里拿到当前登录用户的id
    	int userId = GetSessionPerson.getPerson();
    	
    	//flag -----1导出全部 2导出本页
    	if (flag == 1) {
			List<EquipmentManageExport> exportEquipmentManage = new ArrayList<EquipmentManageExport>();
			int hosId = 0;
			//user大于0,员工id
			if (userId>0) {
				hosId = staffService.getCommHospitalByStaffId(userId);
			//user小于0,社区负责人id;等于0,平台admin
			}else if (userId<0 || userId ==0) {
				hosId = Math.abs(userId);
			}
			equipmentManageList = equipmentManageService.getEquipmentManageListById(hosId);
			if (equipmentManageList != null) {
				for (TEquipmentManage equipmentManage : equipmentManageList) {
					EquipmentManageExport em = new EquipmentManageExport(equipmentManage);
					exportEquipmentManage.add(em);
				}
			}
			EquipmentManageExport em = new EquipmentManageExport();
			String[] titles = em.getTitles();
			JxlExcel Jxl = new JxlExcel(titles);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("content-disposition", "attachment;filename="+1+".xls");
			ServletOutputStream output = response.getOutputStream();
			Jxl.write(exportEquipmentManage, output);
		    response.flushBuffer();
		    return null;
		}
    	if (flag == 2) {
			List<EquipmentManageExport> equipmentManageList = new ArrayList<EquipmentManageExport>();
			if (ids!=null) {
			for (int i = 0; i < ids.length; i++) {
				TEquipmentManage te = equipmentManageService.getEquipmentManageById(ids[i]);
				if (te != null) {
					EquipmentManageExport em = new EquipmentManageExport(te);
					equipmentManageList.add(em);
				}
			}
			}
			EquipmentManageExport em = new EquipmentManageExport();
			String[] titles = em.getTitles();
			JxlExcel Jxl = new JxlExcel(titles);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("content-disposition", "attachment;filename="+1+".xls");
			ServletOutputStream output = response.getOutputStream();
			Jxl.write(equipmentManageList, output);
		    response.flushBuffer();
		    return null;
		}
		return "test";}
    
    
    /*get set*/

  
	public TEquipmentManage getEquipmentManage() {
		return equipmentManage;
	}
	public void setEquipmentManage(TEquipmentManage equipmentManage) {
		this.equipmentManage = equipmentManage;
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
	public List<TEquipmentManage> getEquipmentManageList() {
		return equipmentManageList;
	}
	public void setEquipmentManageList(List<TEquipmentManage> equipmentManageList) {
		this.equipmentManageList = equipmentManageList;
	}
	public int getEquipId() {
		return equipmentManageId;
	}
	public void setEquipId(int equipId) {
		this.equipmentManageId = equipId;
	}
	
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
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
	public String getStrSearch() {
		return strSearch;
	}
	public void setStrSearch(String strSearch) {
		this.strSearch = strSearch;
	}
	public String getStrSearchText() {
		return strSearchText;
	}
	public void setStrSearchText(String strSearchText) {
		this.strSearchText = strSearchText;
	}
	public int getEquipmentManageId() {
		return equipmentManageId;
	}
	public void setEquipmentManageId(int equipmentManageId) {
		this.equipmentManageId = equipmentManageId;
	}
	public List<TMaintenance> getMaintenanceList() {
		return maintenanceList;
	}
	public void setMaintenanceList(List<TMaintenance> maintenanceList) {
		this.maintenanceList = maintenanceList;
	}
	public TMaintenance getMaintenance() {
		return maintenance;
	}
	public void setMaintenance(TMaintenance maintenance) {
		this.maintenance = maintenance;
	}
	public int getManitenanceId() {
		return manitenanceId;
	}
	public void setManitenanceId(int manitenanceId) {
		this.manitenanceId = manitenanceId;
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
	public IEquipmentManageService getEquipmentManageService() {
		return equipmentManageService;
	}
	public void setEquipmentManageService(
			IEquipmentManageService equipmentManageService) {
		this.equipmentManageService = equipmentManageService;
	}
	public ICommunityHospitalService getCommunityHospitalService() {
		return communityHospitalService;
	}
	public void setCommunityHospitalService(
			ICommunityHospitalService communityHospitalService) {
		this.communityHospitalService = communityHospitalService;
	}
	public IStaffService getStaffService() {
		return staffService;
	}
	public void setStaffService(IStaffService staffService) {
		this.staffService = staffService;
	}
	public IMaintenanceService getMaintenanceService() {
		return maintenanceService;
	}
	public void setMaintenanceService(IMaintenanceService maintenanceService) {
		this.maintenanceService = maintenanceService;
	}
	public EquipmentManage getEquipmentTal() {
		return equipmentTal;
	}
	public void setEquipmentTal(EquipmentManage equipmentTal) {
		this.equipmentTal = equipmentTal;
	}
	public List<EquipmentManage> getEquipmentListTal() {
		return equipmentListTal;
	}
	public void setEquipmentListTal(List<EquipmentManage> equipmentListTal) {
		this.equipmentListTal = equipmentListTal;
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
