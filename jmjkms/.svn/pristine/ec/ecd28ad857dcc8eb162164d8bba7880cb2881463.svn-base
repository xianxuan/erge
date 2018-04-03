package com.jmjk.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.jmjk.action.base.BaseAction;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.TFamilyBedHistory;
import com.jmjk.entity.THealthFile;
import com.jmjk.entity.TOldStaffHos;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.view.VFamilyBedHistory;
import com.jmjk.entity.view.VHealthStaff;
import com.jmjk.entity.view.VStaffHos;
import com.jmjk.enums.Admin_IsHead;
import com.jmjk.enums.HealthFileCheck;
import com.jmjk.export.familyExport;
import com.jmjk.service.CommunityHospitalGroupService;
import com.jmjk.service.CommunityHospitalService;
import com.jmjk.service.FamilyBedHistoryService;
import com.jmjk.service.HealthFileService;
import com.jmjk.service.StaffService;
import com.jmjk.utils.JxlExcel;
import com.jmjk.utils.Page;
import com.jmjk.utils.Resubmit;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.SearchBeanSU;
import com.jmjk.utils.TokenProccessor;
@Component
@Scope("prototype")
@Action(value="familyBedHistoryAction",results={
		@Result(name="addFamilyBedHistory",type = "redirectAction", location = "familyBedHistoryAction!showFamilyBedHistory.action"),
		@Result(name="success",location="/success.jsp"),
		@Result(name="showFamilyBedHistory",location="/jsp/familyBedHistory/familyBedHistoryMain.jsp"),
		@Result(name="findFamilyBedHistory",location="/jsp/familyBedHistory/familyBedHistoryAdd.jsp"),
		@Result(name="error",location="/error.jsp"),
		@Result(name="findAndAddFamilyBedHistory",location="/jsp/familyBedHistory/familyBedHistoryAdd.jsp"),
		@Result(name="turnToAddPersonFamilyBedHistory",location="/jsp/familyBedHistory/familyBedHistoryAddPerson.jsp"),
		@Result(name="turnToDetailFamilyBedHistory",location="/jsp/familyBedHistory/familyBedHistoryDetail.jsp"),
		@Result(name="turnToUpdateFamilyBedHistory",location="/jsp/familyBedHistory/familyBedHistoryAlter.jsp"),
		@Result(name="deleteFamilyBedHistory",type = "redirectAction", location = "familyBedHistoryAction!showFamilyBedHistory.action"),
		@Result(name="DocDRedir",type = "redirectAction", location = "familyBedHistoryAction!showFamilyBedHistory.action"),
		@Result(name="updateFamilyBedHistory",type = "redirectAction", location = "familyBedHistoryAction!showFamilyBedHistory.action"),
		@Result(name="deleteMoreFamilyBedHistory",type = "redirectAction", location = "familyBedHistoryAction!showFamilyBedHistory.action"),
		@Result(name="familyBedHistoryError",type = "redirectAction", location = "familyBedHistoryAction!findAndAddFamilyBedHistory.action",params = {"str","${str}"}),
		@Result(name="searchFamilyBedHistory",location="/jsp/familyBedHistory/familyBedHistoryMain.jsp"),
		@Result(name="searchFamilyBedHistoryKill",location="/jsp/familyBedHistory/familyBedHistoryMainPlus.jsp"),
		})

public class FamilyBedHistoryAction extends BaseAction {
	@Autowired
	FamilyBedHistoryService familyBedHistoryService;	
	@Autowired
	HealthFileService healthFileService;
	@Autowired
	StaffService staffService;
	@Autowired
	CommunityHospitalService communityHospitalService;
	@Autowired
	CommunityHospitalGroupService communityHospitalGroupService;
	private TOldStaffHos oldstaffhos;// 老人,医院,员工
	private String token;
	private List<TStaff>  staffs;
	private boolean flagDuo=false;
	private List<VStaffHos> allEnterPeople;
	private SearchBeanSU searchbean;//（多条件查询）
	private List<VStaffHos> allDoctor;
	List<VFamilyBedHistory> vfamilyBedHistoryList;
	TFamilyBedHistory  familyBedHistory;
	private Page<VFamilyBedHistory> page;
	private String pageHtml;//分页
	private int cp=1;//分页
	private int hosId=4;
	private int flag=2;//0是档案编号1是身份证号
	private String value;//前台传来的档案编号或者身份证号Id内容
	private THealthFile healthFile;
	private int healthFileId;
	private int fbhId;
	private int choice[];
	private List<Object> allFamilyBedHistoryId;
	private TCommunityHospital communityHospital;
	private TStaff  tstaff;
	private String str;
	private List<TStaff> specialDoctor;
	private List<VHealthStaff> listolder;
	private boolean showwindow;
	private List<TCommunityHospitalGroup> groups;
	
	public List<TStaff> getSpecialDoctor() {
		return specialDoctor;
	}


	public void setSpecialDoctor(List<TStaff> specialDoctor) {
		this.specialDoctor = specialDoctor;
	}


	public boolean isFlagPingTai() {
		return flagPingTai;
	}


	public void setFlagPingTai(boolean flagPingTai) {
		this.flagPingTai = flagPingTai;
	}


	private int conFlag; 
	private int issq = 2;;//判断是否是平台管理员的状态量，用于是否显示社区医院搜索医院选项
	private List<TCommunityHospital> hospitals; //社区医院list
	private VFamilyBedHistory vfamilyBedHistory;
	private boolean flagPingTai=false;
	public String fuction() throws Exception{
		if(conFlag==1){//导出本页
			List<familyExport> conList=new ArrayList<familyExport>();
			if(choice!=null){
				for(int i=0;i<choice.length;i++){
					vfamilyBedHistory=familyBedHistoryService.getVFamilyBedHistory(choice[i]);
					if(vfamilyBedHistory!=null){
						familyExport ct=new familyExport(vfamilyBedHistory);
						conList.add(ct);
					}
					
				}
			}
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("content-disposition", "attachment;filename="+4+".xls");
			ServletOutputStream output = response.getOutputStream();
			familyExport ct = new familyExport();
			String [] titles = ct.getTitles();
			JxlExcel he = new JxlExcel(titles);
    		he.write(conList, output);
    		response.flushBuffer();
		}
		
		if(conFlag==2){//导出全部
			List<familyExport> conList=new ArrayList<familyExport>();
			String [] titles=(new familyExport()).getTitles();
			HttpSession session = ServletActionContext.getRequest().getSession();
			if(session.getAttribute("comHospital")!=null){
				communityHospital = (TCommunityHospital) session.getAttribute("comHospital");
				if(communityHospital.getIsHead()==Admin_IsHead.guanliyuan.getValue()){
					this.pageHtml=page.getPage("familyBedHistoryAction!showFamilyBedHistory.action");
					vfamilyBedHistoryList=familyBedHistoryService.getAllFamilyBedHistory();
				}
				else {
					vfamilyBedHistoryList=familyBedHistoryService.getAllFamilyBedHistory(communityHospital.getCommunityHospitalId());
				}
			}
			else if(session.getAttribute("tstaff")!=null){
				tstaff =  (TStaff) session.getAttribute("tstaff");
				hosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId());
				if(healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())){//判断员工是否为责任医生，若是，则只能看到所对应的老人
					vfamilyBedHistoryList=familyBedHistoryService.getAllFamilyBedHistoryForSpecial(tstaff.getStaffId());
				}else{
					vfamilyBedHistoryList=familyBedHistoryService.getAllFamilyBedHistory(communityHospital.getCommunityHospitalId());
				}
			}
			
		
			for(VFamilyBedHistory vFamilyBedHistory : vfamilyBedHistoryList){
				if(vFamilyBedHistory!=null){
					familyExport cExport=new familyExport(vFamilyBedHistory);//*
					conList.add(cExport);
				}
			}
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("content-disposition", "attachment;filename="+4+".xls");
			ServletOutputStream output = response.getOutputStream();
    		JxlExcel he = new JxlExcel(titles);   
    		he.write(conList, output);
    		response.flushBuffer();
		}
		
		
		return null;
	}
	

	/**
	 * 展示所有记录（无条件限制）
	 * @return
	 */
	public String searchFamilyBedHistory(){
		page = new Page<VFamilyBedHistory>();
		page.setCurrentPage(cp);
		page.setPageSize(10);
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
		if(group!=null){//集团负责人登陆
			hospitals = communityHospitalGroupService.getComHosListByGroup(group);
			searchbean.setShenfen(0);
			if(searchbean.getSqid()==0){
				searchbean.setShenfen(4);//假定为平台管理员登陆，查自己的集团
				searchbean.setSqid(group.getGId());
			}
			//searchbean.setSqid(searchbean.getSqid());
			issq = 1;//0是平台管理员登陆，1是集团登陆，2是其他登陆 
			page.setTotalNum(familyBedHistoryService.findChronicPeopleCount(searchbean));
			this.pageHtml=page.getPage("entity");
			vfamilyBedHistoryList=familyBedHistoryService.findChronicPeople(searchbean, page);
			flagPingTai=true;//当flagPingTai==true时，会隐藏多条件查询里的录入人、责任医生等选项
			if(searchbean.getDanganzhuangtai()!=0){
				return "searchFamilyBedHistoryKill";
			}
			else{
				return "searchFamilyBedHistory";
			}
		}
		if(session.getAttribute("comHospital")!=null){
			communityHospital = (TCommunityHospital) session.getAttribute("comHospital");
			//communityHospital=communityHospitalService.getCommunityHospitalById(hosId);
			//hosName=communityHospital.getCommunityHospital();
			if(communityHospital.getIsHead()==Admin_IsHead.guanliyuan.getValue()){
				setGroups(communityHospitalGroupService.getAllGroups());
				searchbean.setShenfen(4);
				issq = 0;//0是平台管理员登陆，1是集团登陆，2是其他登陆 
				page.setTotalNum(familyBedHistoryService.findChronicPeopleCount(searchbean));
				this.pageHtml=page.getPage("entity");
				vfamilyBedHistoryList=familyBedHistoryService.findChronicPeople(searchbean, page);
				allDoctor=healthFileService.getAllDoctorByHosId();
				allEnterPeople=staffService.getAllOperator();
				flagPingTai=true;
				if(searchbean.getDanganzhuangtai()!=0){
					return "searchFamilyBedHistoryKill";
				}
				else{
					return "searchFamilyBedHistory";
				}
				
			}
			else {
				page.setTotalNum(familyBedHistoryService.findChronicPeopleCount(searchbean, communityHospital.getCommunityHospitalId()));
				this.pageHtml=page.getPage("entity");
				vfamilyBedHistoryList=familyBedHistoryService.findChronicPeople(searchbean, page, communityHospital.getCommunityHospitalId());
				allDoctor=healthFileService.getAllDoctorByHosId(communityHospital.getCommunityHospitalId());
				allEnterPeople=staffService.getAllOperator(communityHospital.getCommunityHospitalId());
				specialDoctor =healthFileService.getSpeciallDoctor(communityHospital.getCommunityHospitalId());
				staffs = staffService.getStaffByCommunityHospitalId(communityHospital.getCommunityHospitalId());
				if(searchbean.getDanganzhuangtai()!=0){
					return "searchFamilyBedHistoryKill";
				}
				else{
					return "searchFamilyBedHistory";
				}
			}
		}
		else if(session.getAttribute("tstaff")!=null){
			tstaff =  (TStaff) session.getAttribute("tstaff");
			hosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId());
			if(healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())){//判断员工是否为责任医生，若是，则只能看到所对应的老人
				page.setTotalNum(familyBedHistoryService.findChronicPeopleCountForSpecial(searchbean, tstaff.getStaffId()));
				vfamilyBedHistoryList=familyBedHistoryService.findChronicPeopleForSpecial(searchbean, page, tstaff.getStaffId());
				allDoctor=healthFileService.getAllDoctorByHosId(hosId);
				allEnterPeople=staffService.getAllOperator(hosId);
				staffs = staffService.getStaffByCommunityHospitalId(hosId);
				flagDuo=true;
			}else{
				page.setTotalNum(familyBedHistoryService.findChronicPeopleCount(searchbean,hosId));
				vfamilyBedHistoryList=familyBedHistoryService.findChronicPeople(searchbean, page, hosId);
				allDoctor=healthFileService.getAllDoctorByHosId(hosId);
				specialDoctor =healthFileService.getSpeciallDoctor(hosId);
				allEnterPeople=staffService.getAllOperator(hosId);
				staffs = staffService.getStaffByCommunityHospitalId(hosId);
			}
			this.pageHtml=page.getPage("entity");
			if(searchbean.getDanganzhuangtai()!=0){
				return "searchFamilyBedHistoryKill";
			}
			else{
				return "searchFamilyBedHistory";
			}
		}
		else{
			return "error";
		}
		
	}

	public String showFamilyBedHistory(){
		page = new Page<VFamilyBedHistory>();
		page.setCurrentPage(cp);
		page.setPageSize(10);
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
		if(group!=null){//集团负责人登陆
			issq = 1;//0是平台管理员登陆，1是集团登陆，2是其他登陆
			hospitals = communityHospitalGroupService.getComHosListByGroup(group);
			page.setTotalNum(familyBedHistoryService.getFamilyBedHistoryCountForGroup(group.getGId()));
			this.pageHtml = page.getPage("familyBedHistoryAction!showFamilyBedHistory.action");
			vfamilyBedHistoryList=familyBedHistoryService.getAllFamilyBedHistoryForGroup(page, group.getGId());
			flagPingTai = true;
			return "showFamilyBedHistory";
		}
		if(session.getAttribute("comHospital")!=null){
			communityHospital = (TCommunityHospital) session.getAttribute("comHospital");
			//communityHospital=communityHospitalService.getCommunityHospitalById(hosId);
			//hosName=communityHospital.getCommunityHospital();
			if(communityHospital.getIsHead()==Admin_IsHead.guanliyuan.getValue()){
				//hospitals = communityHospitalService.getAllHospitals();
				setGroups(communityHospitalGroupService.getAllGroups());
				issq = 0;//0是平台管理员登陆，1是集团登陆，2是其他登陆 
				page.setTotalNum(familyBedHistoryService.getFamilyBedHistoryCount());
				this.pageHtml=page.getPage("familyBedHistoryAction!showFamilyBedHistory.action");
				vfamilyBedHistoryList=familyBedHistoryService.getAllFamilyBedHistory(page);
				allDoctor=healthFileService.getAllDoctorByHosId();
				allEnterPeople=staffService.getAllOperator();
				
				flagPingTai=true;
				return "showFamilyBedHistory";
			}
			else {
				page.setTotalNum(familyBedHistoryService.getFamilyBedHistoryCount(communityHospital.getCommunityHospitalId()));
				this.pageHtml=page.getPage("familyBedHistoryAction!showFamilyBedHistory.action");
				vfamilyBedHistoryList=familyBedHistoryService.getAllFamilyBedHistory(page, communityHospital.getCommunityHospitalId());
				allDoctor=healthFileService.getAllDoctorByHosId(communityHospital.getCommunityHospitalId());
				specialDoctor =healthFileService.getSpeciallDoctor(communityHospital.getCommunityHospitalId());
				allEnterPeople=staffService.getAllOperator(communityHospital.getCommunityHospitalId());
				staffs = staffService.getStaffByCommunityHospitalId(communityHospital.getCommunityHospitalId());
				return "showFamilyBedHistory";
			}
		}
		else if(session.getAttribute("tstaff")!=null){
			tstaff =  (TStaff) session.getAttribute("tstaff");
			hosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId());
			if(healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())){//判断员工是否为责任医生，若是，则只能看到所对应的老人
				page.setTotalNum(familyBedHistoryService.getFamilyBedHistoryCountForSpecial(tstaff.getStaffId()));
				vfamilyBedHistoryList=familyBedHistoryService.getAllFamilyBedHistoryForSpecial(page, tstaff.getStaffId());
				allDoctor=healthFileService.getAllDoctorByHosId(hosId);
				allEnterPeople=staffService.getAllOperator(hosId);
				staffs = staffService.getStaffByCommunityHospitalId(hosId);
				flagDuo=true;
			}else{
				page.setTotalNum(familyBedHistoryService.getFamilyBedHistoryCount(hosId));
				vfamilyBedHistoryList=familyBedHistoryService.getAllFamilyBedHistory(page, hosId);
				allDoctor=healthFileService.getAllDoctorByHosId(hosId);
				allEnterPeople=staffService.getAllOperator(hosId);
				specialDoctor =healthFileService.getSpeciallDoctor(hosId);
				staffs = staffService.getStaffByCommunityHospitalId(hosId);
				flagDuo=true;
			}
			this.pageHtml=page.getPage("familyBedHistoryAction!showFamilyBedHistory.action");
			return "showFamilyBedHistory";
		}
		else{
			return "error";
		}

	}
	/**
	 * 转到新增界面
	 * @return
	 */
	public String findAndAddFamilyBedHistory(){
		conFlag=0;
		return "findAndAddFamilyBedHistory";
	}
	/**
	 * 新增记录时先精确查找老人（健康档案）
	 * @return
	 */
	public String findFamilyBedHistory(){
		if(flag==0){
			if(!value.equals("")){
			healthFile=healthFileService.getHealthFileByFileNum(value);
			}
		}
		else if (flag==1) {
			if(!value.equals("")){
			healthFile=healthFileService.getHealthFileByIdNum(value);
			}
		}
		else if(flag==2){//按照姓名查找
			if(!value.equals("")){
				HttpSession session = ServletActionContext.getRequest().getSession();
				if(session.getAttribute("comHospital")!=null){
					communityHospital=(TCommunityHospital) session.getAttribute("comHospital");
					if(communityHospital.getIsHead()!=Admin_IsHead.guanliyuan.getValue()){//社区负责人
						 hosId=communityHospital.getCommunityHospitalId();
						 allDoctor=healthFileService.getAllDoctorByHosId(hosId);
						 staffs = staffService.getStaffByCommunityHospitalId(hosId);
						 listolder=healthFileService.getVHealthStaffByOldNameForNormal(hosId, value);
					}
				}
				else if(session.getAttribute("tstaff")!=null){
					tstaff =  (TStaff) session.getAttribute("tstaff");
					hosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId());
					boolean doctor =healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId());
					if(doctor){//是责任医生
						listolder=healthFileService.getVHealthStaffByOldNameForSpecial(tstaff.getStaffId(), value);
					}else{//普通医生
						listolder=healthFileService.getVHealthStaffByOldNameForNormal(hosId, value);
					}
				}
				if(listolder.size()==0){
					str="未找到该老人信息";
					conFlag=0;//不显示列表信息
					return "findAndAddFamilyBedHistory";
				}
				else if(listolder.size()==1){
					int hid=listolder.get(0).getHealthFileId();
					healthFile=healthFileService.getHealthFileById(hid);
				}
				else if(listolder.size()>1){
					showwindow=true;
					conFlag=0;//不显示列表信息
					return "findAndAddFamilyBedHistory";
				}
				
				
			}
		}
		if(healthFile!=null){
			HttpSession session = ServletActionContext.getRequest().getSession();
			if(session.getAttribute("comHospital")!=null){
				communityHospital=(TCommunityHospital) session.getAttribute("comHospital");
				if(communityHospital.getIsHead()!=Admin_IsHead.guanliyuan.getValue()){//社区负责人
					 hosId=communityHospital.getCommunityHospitalId();
					 allDoctor=healthFileService.getAllDoctorByHosId(hosId);
					 staffs = staffService.getStaffByCommunityHospitalId(hosId);
					 if(healthFileService.getOldStaffHosByHosIdAndHeathFileId(hosId,healthFile.getHealthFileId())==null){
					    str="未找到该老人信息";
						conFlag=0;healthFile=null;
						return "findAndAddFamilyBedHistory";
					 }
				}
			}
			else if(session.getAttribute("tstaff")!=null){
				tstaff =  (TStaff) session.getAttribute("tstaff");
				hosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId());
				allDoctor=healthFileService.getAllDoctorByHosId(hosId);
				staffs = staffService.getStaffByCommunityHospitalId(hosId);
				if(healthFileService.getOldStaffHosByHosIdAndHeathFileId(hosId,healthFile.getHealthFileId())==null){
				    str="未找到该老人信息";
					conFlag=0;healthFile=null;
					return "findAndAddFamilyBedHistory";
				 }
				if(healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())){
					oldstaffhos=staffService.gethosByFileid(healthFile.getHealthFileId());
					int test1=oldstaffhos.getTStaff().getStaffId();
					if(test1!=tstaff.getStaffId()){
						str="未找到该老人信息";
						conFlag=0;healthFile=null;
						return "findAndAddFamilyBedHistory";
					}
				}
			}
			conFlag=1;
			token = TokenProccessor.getInstance().makeToken();//创建令牌
			HttpServletRequest request=ServletActionContext.getRequest();
			request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
			return "findFamilyBedHistory";
		}
		else {
			str="未找到该老人信息";
			conFlag=0;
			return "findAndAddFamilyBedHistory";
		}
	}
	/**
	 * 用于添加门诊时用姓名查询（适用于按照姓名查找得到多个老人，选中弹框中具体老人，调用这个方法）
	 * @return
	 */
	public String ReOlder(){
	
		healthFile = healthFileService.getHealthFileById(healthFileId);
		conFlag=1;
		token = TokenProccessor.getInstance().makeToken();//创建令牌
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("comHospital")!=null){
			communityHospital=(TCommunityHospital) session.getAttribute("comHospital");
			if(communityHospital.getIsHead()!=Admin_IsHead.guanliyuan.getValue()){//社区负责人
				 hosId=communityHospital.getCommunityHospitalId();
				 allDoctor=healthFileService.getAllDoctorByHosId(hosId);
				 staffs = staffService.getStaffByCommunityHospitalId(hosId);
			}
		}
		else if(session.getAttribute("tstaff")!=null){
			tstaff =  (TStaff) session.getAttribute("tstaff");
			hosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId());
			allDoctor=healthFileService.getAllDoctorByHosId(hosId);
			staffs = staffService.getStaffByCommunityHospitalId(hosId);
		}
		//vclist = allChronicDiseaseService.getPeoPleAllIll(helid, sqid, stasus);
		//findFollowRecord
		value=healthFile.getName();
		return "findFamilyBedHistory";
	}
	/**
	 * 添加随诊记录
	 * @return
	 */
	public String addFamilyBedHistory(){
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "DocDRedir";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		////////////
		healthFile=healthFileService.getHealthFileById(healthFileId);
		if(healthFile == null){
			str="未找到老人信息";
			return "familyBedHistoryError";
		}
		familyBedHistory.setTHealthFile(healthFile);
		familyBedHistoryService.saveFamilyBedHistory(familyBedHistory);
		return "addFamilyBedHistory";
	}
	public String turnToAddPersonFamilyBedHistory(){
		token = TokenProccessor.getInstance().makeToken();//创建令牌
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
		//////////////
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("comHospital")!=null){
			communityHospital=(TCommunityHospital) session.getAttribute("comHospital");
			if(communityHospital.getIsHead()!=Admin_IsHead.guanliyuan.getValue()){
				 hosId=communityHospital.getCommunityHospitalId();
				 if(healthFileService.getOldStaffHosByHosIdAndHeathFileId(hosId, healthFileId)==null){
						return "error";
					}
			}
		}
		else if(session.getAttribute("tstaff")!=null){
			tstaff =  (TStaff) session.getAttribute("tstaff");
			hosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId());
			if(healthFileService.getOldStaffHosByHosIdAndHeathFileId(hosId, healthFileId)==null){
				return "error";
			}
		}
		healthFile=healthFileService.getHealthFileById(healthFileId);
		return "turnToAddPersonFamilyBedHistory";
	}
	public String turnToDetailFamilyBedHistory(){
		
		if(healthFileService.getHealthFileById(healthFileId)==null||familyBedHistoryService.getFamilyBedHistoryByFBHId(fbhId)==null){
			return "error";
		}
		healthFile=healthFileService.getHealthFileById(healthFileId);
		familyBedHistory=familyBedHistoryService.getFamilyBedHistoryByFBHId(fbhId);
		if(familyBedHistory.getTHealthFile().getHealthFileId()!=healthFileId){
			return "error";
		}
		return "turnToDetailFamilyBedHistory";
	}
	public String deleteFamilyBedHistory(){
		familyBedHistory=familyBedHistoryService.getFamilyBedHistoryByFBHId(fbhId);
		if(familyBedHistory==null){
			return "error";
		}
		healthFileId=familyBedHistory.getTHealthFile().getHealthFileId();
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("comHospital")!=null){
			communityHospital=(TCommunityHospital) session.getAttribute("comHospital");
			if(communityHospital.getIsHead()!=Admin_IsHead.guanliyuan.getValue()){
				 hosId=communityHospital.getCommunityHospitalId();
				 if(healthFileService.getOldStaffHosByHosIdAndHeathFileId(hosId, healthFileId)==null){
						return "error";
					}
			}
		}
		else if(session.getAttribute("tstaff")!=null){
			tstaff =  (TStaff) session.getAttribute("tstaff");
			hosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId());
			if(healthFileService.getOldStaffHosByHosIdAndHeathFileId(hosId, healthFileId)==null){
				return "error";
			}
		}
		familyBedHistoryService.deleteFamilyBedHistoryByFBHId(fbhId);
		return "deleteFamilyBedHistory";
	}
	/*public String deleteFamilyBedHistoryList(){
		familyBedHistoryService.deleteFamilyBedHistory(deleteList);
	}*/
	public String updateFamilyBedHistory(){
		
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "DocDRedir";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		////////////
		healthFile=healthFileService.getHealthFileById(healthFileId);
		familyBedHistory.setTHealthFile(healthFile);
		familyBedHistoryService.updateFamilyBedHistory(familyBedHistory);
		return "updateFamilyBedHistory";
	}
	public String turnToUpdateFamilyBedHistory(){
		token = TokenProccessor.getInstance().makeToken();//创建令牌
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
		/////////
		if(healthFileService.getHealthFileById(healthFileId)==null||familyBedHistoryService.getFamilyBedHistoryByFBHId(fbhId)==null){
			return "error";
		}
		healthFile=healthFileService.getHealthFileById(healthFileId);
		familyBedHistory=familyBedHistoryService.getFamilyBedHistoryByFBHId(fbhId);
		if(familyBedHistory.getTHealthFile().getHealthFileId()!=healthFileId){
			return "error";
		}
		return "turnToUpdateFamilyBedHistory";
	}
	public String deleteMoreFamilyBedHistory(){
		familyBedHistoryService.deleteFamilyBedHistory(allFamilyBedHistoryId);
		return "deleteMoreFamilyBedHistory";
	}
	public List<VFamilyBedHistory> getVfamilyBedHistoryList() {
		return vfamilyBedHistoryList;
	}
	public void setVfamilyBedHistoryList(
			List<VFamilyBedHistory> vfamilyBedHistoryList) {
		this.vfamilyBedHistoryList = vfamilyBedHistoryList;
	}
	public TFamilyBedHistory getFamilyBedHistory() {
		return familyBedHistory;
	}
	public void setFamilyBedHistory(TFamilyBedHistory familyBedHistory) {
		this.familyBedHistory = familyBedHistory;
	}
	public Page<VFamilyBedHistory> getPage() {
		return page;
	}
	public void setPage(Page<VFamilyBedHistory> page) {
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
	public int getHosId() {
		return hosId;
	}
	public void setHosId(int hosId) {
		this.hosId = hosId;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public THealthFile getHealthFile() {
		return healthFile;
	}
	public void setHealthFile(THealthFile healthFile) {
		this.healthFile = healthFile;
	}
	public int getHealthFileId() {
		return healthFileId;
	}
	public void setHealthFileId(int healthFileId) {
		this.healthFileId = healthFileId;
	}
	public int getFbhId() {
		return fbhId;
	}
	public void setFbhId(int fbhId) {
		this.fbhId = fbhId;
	}
	public int[] getChoice() {
		return choice;
	}
	public void setChoice(int[] choice) {
		this.choice = choice;
	}
	public List<Object> getAllFamilyBedHistoryId() {
		return allFamilyBedHistoryId;
	}
	public void setAllFamilyBedHistoryId(List<Object> allFamilyBedHistoryId) {
		this.allFamilyBedHistoryId = allFamilyBedHistoryId;
	}

	public boolean isFlagDuo() {
		return flagDuo;
	}

	public void setFlagDuo(boolean flagDuo) {
		this.flagDuo = flagDuo;
	}

	public List<VStaffHos> getAllEnterPeople() {
		return allEnterPeople;
	}

	public void setAllEnterPeople(List<VStaffHos> allEnterPeople) {
		this.allEnterPeople = allEnterPeople;
	}

	

	public SearchBeanSU getSearchbean() {
		return searchbean;
	}

	public void setSearchbean(SearchBeanSU searchbean) {
		this.searchbean = searchbean;
	}

	public List<VStaffHos> getAllDoctor() {
		return allDoctor;
	}

	public void setAllDoctor(List<VStaffHos> allDoctor) {
		this.allDoctor = allDoctor;
	}

	public TCommunityHospital getCommunityHospital() {
		return communityHospital;
	}

	public void setCommunityHospital(TCommunityHospital communityHospital) {
		this.communityHospital = communityHospital;
	}

	public TStaff getTstaff() {
		return tstaff;
	}

	public void setTstaff(TStaff tstaff) {
		this.tstaff = tstaff;
	}


	public int getConFlag() {
		return conFlag;
	}


	public void setConFlag(int conFlag) {
		this.conFlag = conFlag;
	}


	public VFamilyBedHistory getVfamilyBedHistory() {
		return vfamilyBedHistory;
	}


	public void setVfamilyBedHistory(VFamilyBedHistory vfamilyBedHistory) {
		this.vfamilyBedHistory = vfamilyBedHistory;
	}

	public int getIssq() {
		return issq;
	}


	public void setIssq(int issq) {
		this.issq = issq;
	}


	public List<TCommunityHospital> getHospitals() {
		return hospitals;
	}


	public void setHospitals(List<TCommunityHospital> hospitals) {
		this.hospitals = hospitals;
	}


	public String getStr() {
		return str;
	}


	public void setStr(String str) {
		this.str = str;
	}


	public List<TStaff> getStaffs() {
		return staffs;
	}


	public void setStaffs(List<TStaff> staffs) {
		this.staffs = staffs;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public TOldStaffHos getOldstaffhos() {
		return oldstaffhos;
	}


	public void setOldstaffhos(TOldStaffHos oldstaffhos) {
		this.oldstaffhos = oldstaffhos;
	}


	public List<VHealthStaff> getListolder() {
		return listolder;
	}


	public void setListolder(List<VHealthStaff> listolder) {
		this.listolder = listolder;
	}


	public boolean isShowwindow() {
		return showwindow;
	}


	public void setShowwindow(boolean showwindow) {
		this.showwindow = showwindow;
	}


	public List<TCommunityHospitalGroup> getGroups() {
		return groups;
	}


	public void setGroups(List<TCommunityHospitalGroup> groups) {
		this.groups = groups;
	}
	
	
}
