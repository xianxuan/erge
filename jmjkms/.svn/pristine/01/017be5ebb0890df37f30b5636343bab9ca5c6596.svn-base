package com.jmjk.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.jmjk.action.base.BaseAction;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.THealthFile;
import com.jmjk.entity.TOldStaffHos;
import com.jmjk.entity.TRole;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.view.VStaffHos;
import com.jmjk.enums.OperatorState;
import com.jmjk.service.CommunityHospitalGroupService;
import com.jmjk.service.CommunityHospitalService;
import com.jmjk.service.HealthFileService;
import com.jmjk.service.OldStaffHosService;
import com.jmjk.service.RoleService;
import com.jmjk.service.StaffService;
import com.jmjk.utils.Encryt;
import com.jmjk.utils.GetSessionPerson;
import com.jmjk.utils.Page;
import com.jmjk.utils.TypeConverter;
import com.jmjk.utils.operatorManageBean;



@Component
@Scope("prototype")
@Action(value="oparetorAction",results={
		@Result(name="rolelist", location = "/jsp/staffManage/operatorManage/addOperatorInfo.jsp"),
		@Result(name="error", location = "/error.jsp"),
		@Result(name="TestError", type="redirect",location = "/jsp/staffManage/operatorManage/addOperatorInfo.jsp"),
		@Result(name="getAllStaffExceptOperator", location = "/jsp/staffManage/operatorManage/addOperatorInfo.jsp"),
		@Result(name="recoverPassword", type = "redirectAction", location = "oparetorAction!getAllOperators.action"),
		@Result(name="changeUperatorState", type = "redirectAction", location = "oparetorAction!getAllOperators.action"),
		@Result(name="getAllOperators", location = "/jsp/staffManage/operatorManage/oparetorManage.jsp"),
		@Result(name="getUpdateOperatorById", location = "/jsp/staffManage/operatorManage/updateOperatorInfo.jsp"),
		@Result(name="addOperator",type = "redirectAction", location = "oparetorAction!getAllOperators.action"),
		@Result(name="false", location = "/jsp/staffManage/operatorManage/addOperatorInfo.jsp"),
		})
public class OperatorAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	//@Autowired
	//private OldStaffHosService oldStaffHosService;
	@Autowired
	private StaffService staffService;	
	@Autowired
	private RoleService roleService;
	@Autowired
	private OldStaffHosService oldStaffHosService;
	@Autowired
	private CommunityHospitalService communityHospitalService;
	@Autowired
	private HealthFileService healthFileService;
	@Autowired
	private CommunityHospitalGroupService communityHospitalGroupService;
	private List<TRole> listRoles;
	private String loginName;
	private int oparetorState;
	private TStaff staff;
	private TCommunityHospitalGroup communityHospitalGroup;
	private String note;
	private int roleId;
	private int staffId;
	private String stuffNumber;  //员工编号
	private String remind;
	private int flag;
	private VStaffHos vstaff;
	private List<VStaffHos> vstaffs;
	private Page<TStaff>  page;
	private String   pageHtml;
	private int  cp = 1;
	private List<operatorManageBean> beans;
	private String department;
	private String value;
	private int zerendoctor;//是否是责任医生
	private int manageHome;//是否管理居家老人，0为不管，1为管理
	private int manageAgency;//是否管理机构老人，0为不管，1为管理
	private String staffname;
	public String msg;
	
	


	public String  getRoleList(){
		listRoles=roleService.getAllRole();
		//System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^"+listRoles.size());
		return "rolelist";
	}
	 
	public String deleteOperator(){
		
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
        
        if(communityHosGroup!=null){//社区集团
        	return "error";
        }
        else{
			//从session里拿到当前登录用户的id		
			int person = GetSessionPerson.getPerson();
			staff = staffService.getStaffById(staffId);
			int csqId = staffService.getCommHospitalByStaffId(staffId);
			if(person == 0){//平台管理员  
				if(staff != null){
					staff.setLoginName(null);
					staff.setPassword(null);
					staffService.updateStaff(staff);
					oldStaffHosService.deleteByDoctorId(staff.getStaffId());
					
					
				}
			}else if(person < 0){//社区负责人
				int ssqId = Math.abs(person);
				if(csqId == ssqId){
					if(staff != null){
						staff.setLoginName(null);
						staff.setPassword(null);
						/*staff.setOperateState(OperatorState.shanchu.getvalue());*/
						if(staff.getIsSpecialDoctor()){							
							staffService.updateStaff(staff);
							staffService.deleteDutyDoctor(staff.getStaffId());
							
						}else{
							staffService.updateStaff(staff);
							oldStaffHosService.deleteByDoctorId(staff.getStaffId());
						}
						
					}
				}
			}else{//员工
				int ssqId = staffService.getCommHospitalByStaffId(person);
				if(csqId == ssqId){
					if(staff != null){
						staff.setLoginName(null);
						staff.setPassword(null);
						if(staff.getIsSpecialDoctor()){
						    staffService.updateStaff(staff);
							staffService.deleteDutyDoctor(staff.getStaffId());
						}
						else{
    						staffService.updateStaff(staff);
    						oldStaffHosService.deleteByDoctorId(staff.getStaffId());
						}
					}
				}
			}
			return "addOperator";
        }
	}

	//查找
	public String search(){
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
		
		int sqId = -1;
		//flag 0请选择   1编号  2姓名  3登录名 4社区医院
		if(flag == 0){
			return "addOperator";
		}
		if(value==null){
			return "addOperator";
			
		}
		if(value.equals("")){
			return "addOperator";
		}
		page = new Page();
		page.setCurrentPage(cp);
		if(communityHosGroup!=null){//社区集团
			communityHospitalGroup=communityHospitalGroupService.getRealComHosGroup(communityHosGroup);
			int gid=communityHospitalGroup.getGId();
			page.setTotalNum(staffService.countOpeartorGroupBySearch(gid, flag, value));
			vstaffs = staffService.getOperatorGroupBySearchByPage(gid, flag, value, page);
		}
		else{
			//从session里拿到当前登录用户的id
			int person = GetSessionPerson.getPerson();
			
			if(person == 0){
				sqId = -1;
			}else if(person < 0){
				sqId = Math.abs(person);
			}else{
				sqId = staffService.getCommHospitalByStaffId(person);
			}
			page.setTotalNum(staffService.countOpeartorBySearch(sqId, flag, value));//先写死社区Id
			vstaffs = staffService.getOperatorBySearchByPage(sqId, flag, value, page);
		}
		//value = HtmlEscape.escapeHtml(value);//转义,用于前台显示
		pageHtml = page.getPage("oparetorAction!search.action?flag="+flag+"&value="+value);
		return "getAllOperators";
	}
	
	//修改操作员状态
	public String changeUperatorState(){
		staff = staffService.getStaffById(staffId);
		if(staff != null ){//这个员工存在
			int state = staff.getOperateState();
			if(state == OperatorState.qiyong.getvalue()){
				staff.setOperateState(OperatorState.gerenjinyong.getvalue());
			}
			if(state == OperatorState.gerenjinyong.getvalue()){
				staff.setOperateState(OperatorState.qiyong.getvalue());
			}
			staffService.updateStaff(staff);
		}
		return "changeUperatorState";
	}


	//分页展示所有的操作员
	public String getAllOperators(){
		//从session里拿到当前登录用户的id
		int sqId ;
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
		if(communityHosGroup!=null){
			communityHospitalGroup=communityHospitalGroupService.getRealComHosGroup(communityHosGroup);
			sqId=communityHospitalGroup.getGId();	
			page = new Page();
			page.setCurrentPage(cp);
			page.setTotalNum(staffService.countOperatorGroupBySQId(sqId));
			beans = new ArrayList<operatorManageBean>();
			vstaffs = staffService.getAllOperatorGroup(sqId, page);
			pageHtml = page.getPage("oparetorAction!getAllOperators.action");
		}
	 else{
			int person = GetSessionPerson.getPerson();
			flag=2;
			if(person == 0){
				sqId = -1;
			}else if(person < 0){
				sqId = Math.abs(person);
			}else{
				sqId = staffService.getCommHospitalByStaffId(person);
			}
			page = new Page();
			page.setCurrentPage(cp);
			page.setTotalNum(staffService.countOperatorBySQId(sqId));
			beans = new ArrayList<operatorManageBean>();
			vstaffs = staffService.getAllOperator(sqId,page);
			pageHtml = page.getPage("oparetorAction!getAllOperators.action");
		}		
		return "getAllOperators";
	}

	//恢复密码
	public String recoverPassword(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
        
        if(communityHosGroup!=null){//社区集团
        	return "error";
        }
        else{
			//从session里拿到当前登录用户的id
			int person = GetSessionPerson.getPerson();
			
			staff = staffService.getStaffById(staffId);
			int csqId = staffService.getCommHospitalByStaffId(staffId);
			int sqId ;
			if(person == 0){
				sqId = -1;
			}else if(person < 0){
				sqId = Math.abs(person);
				if(sqId != csqId){return "error";}
			}else{
				sqId = staffService.getCommHospitalByStaffId(person);
				if(sqId != csqId){return "error";}
			}
			if(staff != null){
				String loginName = staff.getLoginName();
				if(loginName != null ){
					if(loginName.equals("")){
						return "error";
					}else{
						String password  = Encryt.encryptString_md5(loginName);
						staff.setPassword(password);
						staffService.updateStaff(staff);
						return "recoverPassword";
					}
				}
			}
			return "recoverPassword";
        }
	}
	
	//用于添加时查询没有添加操作员的员工
	public String getAllStaffExceptOperator(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
        
        if(communityHosGroup!=null){//社区集团
        	return "error";
        }
        else{
			//从session里拿到当前登录用户的id
			int person = GetSessionPerson.getPerson();
			int sqId ;
			if(person == 0){
				sqId = -1;
			}else if(person < 0){
				sqId = Math.abs(person);
			}else{
				sqId = staffService.getCommHospitalByStaffId(person);
			}
			vstaffs = staffService.getAllStaffBySQIdExceptOpe(sqId);//先写死
			return "getAllStaffExceptOperator";
        }
	}
	public void getAllStaffExceptOperator2(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
        
        if(communityHosGroup!=null){//社区集团
        	
        }
        else{
			//从session里拿到当前登录用户的id
			int person = GetSessionPerson.getPerson();
			int sqId ;
			if(person == 0){
				sqId = -1;
			}else if(person < 0){
				sqId = Math.abs(person);
			}else{
				sqId = staffService.getCommHospitalByStaffId(person);
			}
			vstaffs = staffService.getAllStaffBySQIdExceptOpe(sqId);//先写死
			msg = JSON.toJSONString(vstaffs);
			this.writeJson(msg);
        }
	}
	

	//添加操作员
	public String addOperator(){
		//1.判断这个员工是否存在
		staff = staffService.getStaffByStaffNumber(stuffNumber);
		int comId=staffService.getCommHospitalByStaffId(staff.getStaffId());
		TCommunityHospital tCommunityHospital=communityHospitalService.getCommunityHospitalById(comId);
		//判断登录名是否存在
		loginName = loginName.trim();
		Boolean is = staffService.hasThisOperator(loginName);
		if(staff != null &&  !is){
			TRole role = roleService.getRoleById(roleId);
			if(loginName.equals("")){
				return "TestError";
			}
			if(role == null){
				return "TestError";
			}
			//置为责任医生
			if(zerendoctor==1){
				staff.setIsSpecialDoctor(true);
				if(manageAgency==1){//养老机构
					staff.setIsAgencyOld(true);
				}else
				{
					staff.setIsAgencyOld(false);
				}
				if(manageHome==1){//居家老人
					staff.setIsHomeOld(true);
				}else{
					staff.setIsHomeOld(false);
				}
				staff.setTRole(role);
				staff.setLoginName(loginName);
				String password = Encryt.encryptString_md5(loginName);//默认密码是登录名
				staff.setPassword(password);
				staff.setNote(note);
				staff.setOperateState(oparetorState);
				staffService.addDutyDoctor(staff);
			}
			else{
				staff.setIsSpecialDoctor(false);
				staff.setIsAgencyOld(false);
				staff.setIsHomeOld(false);
				staff.setTRole(role);
				staff.setLoginName(loginName);
				String password = Encryt.encryptString_md5(loginName);//默认密码是登录名
				staff.setPassword(password);
				staff.setNote(note);
				staff.setOperateState(oparetorState);				
				staffService.updateStaff(staff);
			}
			
			
		}
		if(staff == null && !is){ //员工不存在
			flag = 1;
			return "false";
		}
		if(is){ //登录名重名
			flag = 0;
			//staff = null;
			staffname = staff.getName();
			return "false";
		}
		return "addOperator";
	}
	
	
	public String getUpdateOperatorById(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
        
        if(communityHosGroup!=null){//社区集团
        	return "error";
        }
        else{
			//从session里拿到当前登录用户的id
			int person = GetSessionPerson.getPerson();
			
			//session 判断社区Id
			staff = staffService.getStaffById(staffId);
			int oldzerendoctor;
			if(healthFileService.getOldStaffHosByStaffId(staffId)){
				 zerendoctor=1;				
			}
			else {
				zerendoctor=0;
			}
			if(staff.getIsAgencyOld()!=null)
			{
				if(staff.getIsAgencyOld()){
					manageAgency=1;
				
				}else{
					manageAgency=0;
				}
				if(staff.getIsHomeOld()){
					manageHome=1;
					
				}else{
					manageHome=0;
				}
			}			
			int csqId = staffService.getCommHospitalByStaffId(staffId);
			int sqId ;
			if(person == 0){
				sqId = -1;
			}else if(person < 0){
				sqId = Math.abs(person);
				if(sqId != csqId){return "error";}
			}else{
				sqId = staffService.getCommHospitalByStaffId(person);
				if(sqId != csqId){return "error";}
			}
			return "getUpdateOperatorById";
        }
	}
	//更新操作员并保存
	public String updateOperatorSave(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup communityHosGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");	    
        
        if(communityHosGroup!=null){//社区集团
        	return "error";
        }
        else{
			//从session里拿到当前登录用户的id
			int person = GetSessionPerson.getPerson();
			TRole role = roleService.getRoleById(roleId);
			staff = staffService.getStaffById(staffId);
			staff = staffService.getStaffById(staffId);
			int csqId = staffService.getCommHospitalByStaffId(staffId);
			int sqId ;
			if(person == 0){//平台管理员
				sqId = -1;
			}else if(person < 0){//社区负责人
				sqId = Math.abs(person);
				if(sqId != csqId){return "error";}
			}else{//员工
				sqId = staffService.getCommHospitalByStaffId(person);
				if(sqId != csqId){return "error";}
			}
			if(staff != null ){
				if(role != null ){
					int oldzerendoctor;
					staff.setTRole(role);
					//原来是责任医生，现在又选择了
					if(healthFileService.getOldStaffHosByStaffId(staffId)){						
						oldzerendoctor=1;						
						
					}else{
						oldzerendoctor=0;
					}										
					//原来是责任医生，现在还是，只修改了管理机构 不上传至云端   原来不是，现在还是不是
					if(oldzerendoctor==1&&zerendoctor==1)
					{
						if(manageAgency==1){//养老机构
							staff.setIsAgencyOld(true);
						}else
						{
							staff.setIsAgencyOld(false);
						}
						if(manageHome==1){//居家老人
							staff.setIsHomeOld(true);
						}else{
							staff.setIsHomeOld(false);
						}
						staff.setIsSpecialDoctor(true);
						staff.setDepartment(department);
                        staff.setOperateState(flag);
                        staff.setNote(note);
                        staffService.updateDutyDoctor(staff);
						
					}
					else if(oldzerendoctor==0&&zerendoctor==0){//原来不是责任医生，现在也不是责任医生
					    staff.setIsSpecialDoctor(false);
					    staff.setIsAgencyOld(false);
					    staff.setIsHomeOld(false);
					    staff.setDepartment(department);
                        staff.setOperateState(flag);
                        staff.setNote(note);
                        staffService.updateDutyDoctor(staff);
					}
					//原来是责任医生，现在不是  删除
					else if(oldzerendoctor==1&&zerendoctor==0){
						staffService.deleteDutyDoctor(staffId);;
					}
					//原来不是责任医生，现在是   增加
					else if(oldzerendoctor==0&&zerendoctor==1){
						
						if(manageAgency==1){//养老机构
							staff.setIsAgencyOld(true);
						}else
						{
							staff.setIsAgencyOld(false);
						}
						if(manageHome==1){//居家老人
							staff.setIsHomeOld(true);
						}else{
							staff.setIsHomeOld(false);
						}	
						staff.setIsSpecialDoctor(true);
						staff.setDepartment(department);
		                staff.setOperateState(flag);
		                staff.setNote(note);
						staffService.addDutyDoctor(staff);						
					}
					
				}				
				
			}			
			return "addOperator";
        }
	}
	
	
	///////////////////////////////////////////////////////////////////////////
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getZerendoctor() {
		return zerendoctor;
	}
	public void setZerendoctor(int zerendoctor) {
		this.zerendoctor = zerendoctor;
	}

	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public List<operatorManageBean> getBeans() {
		return beans;
	}
	public void setBeans(List<operatorManageBean> beans) {
		this.beans = beans;
	}
	public List<VStaffHos> getVstaffs() {
		return vstaffs;
	}
	public void setVstaffs(List<VStaffHos> vstaffs) {
		this.vstaffs = vstaffs;
	}
	
	public String getStaffname() {
		return staffname;
	}

	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getRemind() {
		return remind;
	}
	public void setRemind(String remind) {
		this.remind = remind;
	}
	public String getStuffNumber() {
		return stuffNumber;
	}
	public void setStuffNumber(String stuffNumber) {
		this.stuffNumber = stuffNumber;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public int getOparetorState() {
		return oparetorState;
	}
	public void setOparetorState(int oparetorState) {
		this.oparetorState = oparetorState;
	}
	public TStaff getStaff() {
		return staff;
	}
	public void setStaff(TStaff staff) {
		this.staff = staff;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public VStaffHos getVstaff() {
		return vstaff;
	}
	public void setVstaff(VStaffHos vstaff) {
		this.vstaff = vstaff;
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
	public List<TRole> getListRoles() {
		return listRoles;
	}
	public void setListRoles(List<TRole> listRoles) {
		this.listRoles = listRoles;
	}

	public TCommunityHospitalGroup getCommunityHospitalGroup() {
		return communityHospitalGroup;
	}

	public void setCommunityHospitalGroup(TCommunityHospitalGroup communityHospitalGroup) {
		this.communityHospitalGroup = communityHospitalGroup;
	}

	public int getManageHome() {
		return manageHome;
	}

	public void setManageHome(int manageHome) {
		this.manageHome = manageHome;
	}

	public int getManageAgency() {
		return manageAgency;
	}

	public void setManageAgency(int manageAgency) {
		this.manageAgency = manageAgency;
	}

	
	
}
