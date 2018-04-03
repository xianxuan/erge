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
import com.jmjk.entity.THealthFile;
import com.jmjk.entity.TInHospitalHistory;
import com.jmjk.entity.TOldStaffHos;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.view.VFollowRecord;
import com.jmjk.entity.view.VHealthStaff;
import com.jmjk.entity.view.VInHospitalHistory;
import com.jmjk.entity.view.VIncompleteRecord;
import com.jmjk.entity.view.VStaffHos;
import com.jmjk.enums.Admin_IsHead;
import com.jmjk.enums.HealthFileCheck;
import com.jmjk.export.inHospitalExport;
import com.jmjk.service.CommunityHospitalGroupService;
import com.jmjk.service.CommunityHospitalService;
import com.jmjk.service.HealthFileService;
import com.jmjk.service.InHospitalHistoryService;
import com.jmjk.service.StaffService;
import com.jmjk.utils.JxlExcel;
import com.jmjk.utils.Page;
import com.jmjk.utils.Resubmit;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.SearchBeanSU;
import com.jmjk.utils.TokenProccessor;
@Component
@Scope("prototype")
@Action(value="inHospitalHistoryAction",results={
		@Result(name="addInHospitalHistory",type = "redirectAction", location = "inHospitalHistoryAction!showInHospitalHistory.action"),
		@Result(name="success",location="/success.jsp"),
		@Result(name="showInHospitalHistory",location="/jsp/inHospitalHistory/inHospitalHistoryMain.jsp"),
		@Result(name="findInHospitalHistory",location="/jsp/inHospitalHistory/inHospitalHistoryAdd.jsp"),
		@Result(name="error",location="/error.jsp"),
		@Result(name="findAndAddInHospitalHistory",location="/jsp/inHospitalHistory/inHospitalHistoryAdd.jsp"),
		@Result(name="turnToAddPersonInHospitalHistory",location="/jsp/inHospitalHistory/inHospitalHistoryAddPerson.jsp"),
		@Result(name="turnToDetailInHospitalHistory",location="/jsp/inHospitalHistory/inHospitalHistoryDetail.jsp"),
		@Result(name="turnToUpdateInHospitalHistory",location="/jsp/inHospitalHistory/inHospitalHistoryAlter.jsp"),
		@Result(name="deleteInHospitalHistory",type = "redirectAction", location = "inHospitalHistoryAction!showInHospitalHistory.action"),
		@Result(name="updateInHospitalHistory",type = "redirectAction", location = "inHospitalHistoryAction!showInHospitalHistory.action"),
		@Result(name="deleteMoreInHospitalHistory",type = "redirectAction", location = "inHospitalHistoryAction!showInHospitalHistory.action"),
		@Result(name="DocDRedir",type = "redirectAction", location = "inHospitalHistoryAction!showInHospitalHistory.action"),
		@Result(name="inHospitalHistoryError",type = "redirectAction", location = "inHospitalHistoryAction!findAndAddInHospitalHistory.action",params = {"str","${str}"}),
		@Result(name="searchInHospitalHistory",location="/jsp/inHospitalHistory/inHospitalHistoryMain.jsp"),
		@Result(name="searchInHospitalHistoryKill",location="/jsp/inHospitalHistory/inHospitalHistoryMainPlus.jsp"),
		})


public class InHospitalHistoryAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	InHospitalHistoryService inHospitalHistoryService;	
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
	List<VInHospitalHistory> vinHospitalHistoryList;
	TInHospitalHistory  inHospitalHistory;
	private Page<VInHospitalHistory> page;
	private String pageHtml;//分页
	private int cp=1;//分页
	private int hosId=4;
	private int flag=2;//0是档案编号1是身份证号
	private String value;//前台传来的档案编号或者身份证号Id内容
	private THealthFile healthFile;
	private int healthFileId;
	private int ihhId;
	private int choice[];
	private List<Object> allInHospitalHistoryId;
	private TCommunityHospital communityHospital;
	private TStaff  tstaff;
	private String str;
	private int conFlag; 
	private int issq = 2;//判断是否是平台管理员的状态量，用于是否显示社区医院搜索医院选项
	private List<TCommunityHospital> hospitals; //社区医院list
	private VInHospitalHistory vinHospitalHistory;
	private boolean flagPingTai=false;
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


	public String fuction() throws Exception{
		if(conFlag==1){//导出本页
			List<inHospitalExport> conList=new ArrayList<inHospitalExport>();
			if(choice!=null){
				for(int i=0;i<choice.length;i++){
					vinHospitalHistory=inHospitalHistoryService.getVInHospitalHistory(choice[i]);
					if(vinHospitalHistory!=null){
						inHospitalExport ct=new inHospitalExport(vinHospitalHistory);
						conList.add(ct);
					}
					
				}
			}
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("content-disposition", "attachment;filename="+4+".xls");
			ServletOutputStream output = response.getOutputStream();
			inHospitalExport ct = new inHospitalExport();
			String [] titles = ct.getTitles();
			JxlExcel he = new JxlExcel(titles);
    		he.write(conList, output);
    		response.flushBuffer();
		}
		
		if(conFlag==2){//导出全部
			List<inHospitalExport> conList=new ArrayList<inHospitalExport>();
			String [] titles=(new inHospitalExport()).getTitles();
			HttpSession session = ServletActionContext.getRequest().getSession();
			if(session.getAttribute("comHospital")!=null){
				communityHospital = (TCommunityHospital) session.getAttribute("comHospital");
				if(communityHospital.getIsHead()==Admin_IsHead.guanliyuan.getValue()){
					this.pageHtml=page.getPage("inHospitalHistoryAction!showInHospitalHistory.action");
					vinHospitalHistoryList=inHospitalHistoryService.getAllInHospitalHistory();
				}
				else {
					vinHospitalHistoryList=inHospitalHistoryService.getAllInHospitalHistory(communityHospital.getCommunityHospitalId());
				}
			}
			else if(session.getAttribute("tstaff")!=null){
				tstaff =  (TStaff) session.getAttribute("tstaff");
				hosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId());
				if(healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())){//判断员工是否为责任医生，若是，则只能看到所对应的老人
					vinHospitalHistoryList=inHospitalHistoryService.getAllInHospitalHistoryForSpecial(tstaff.getStaffId());
				}else{
					vinHospitalHistoryList=inHospitalHistoryService.getAllInHospitalHistory(communityHospital.getCommunityHospitalId());
				}
			}
			
		
			for(VInHospitalHistory vInHospitalHistory : vinHospitalHistoryList){
				if(vInHospitalHistory!=null){
					inHospitalExport cExport=new inHospitalExport(vInHospitalHistory);//*
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
	public String searchInHospitalHistory(){
		page = new Page<VInHospitalHistory>();
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
			page.setTotalNum(inHospitalHistoryService.findChronicPeopleCount(searchbean));
			this.pageHtml=page.getPage("entity");
			vinHospitalHistoryList=inHospitalHistoryService.findChronicPeople(searchbean, page);
			flagPingTai=true;//当flagPingTai==true时，会隐藏多条件查询里的录入人、责任医生等选项
			if(searchbean.getDanganzhuangtai()!=0){
				return "searchInHospitalHistoryKill";
			}
			else{
				return "searchInHospitalHistory";
			}
		}
		if(session.getAttribute("comHospital")!=null){
			communityHospital = (TCommunityHospital) session.getAttribute("comHospital");
			//communityHospital=communityHospitalService.getCommunityHospitalById(hosId);
			//hosName=communityHospital.getCommunityHospital();
			if(communityHospital.getIsHead()==Admin_IsHead.guanliyuan.getValue()){
				//setHospitals(communityHospitalService.getAllHospitals());
				setGroups(communityHospitalGroupService.getAllGroups());
				searchbean.setShenfen(4);
				issq = 0;//0是平台管理员登陆，1是集团登陆，2是其他登陆 
				page.setTotalNum(inHospitalHistoryService.findChronicPeopleCount(searchbean));
				this.pageHtml=page.getPage("entity");
				vinHospitalHistoryList=inHospitalHistoryService.findChronicPeople(searchbean, page);
				allDoctor=healthFileService.getAllDoctorByHosId();
				allEnterPeople=staffService.getAllOperator();
				flagPingTai=true;
				if(searchbean.getDanganzhuangtai()!=0){
					return "searchInHospitalHistoryKill";
				}
				else{
					return "searchInHospitalHistory";
				}
				
			}
			else {
				page.setTotalNum(inHospitalHistoryService.findChronicPeopleCount(searchbean, communityHospital.getCommunityHospitalId()));
				this.pageHtml=page.getPage("entity");
				vinHospitalHistoryList=inHospitalHistoryService.findChronicPeople(searchbean, page, communityHospital.getCommunityHospitalId());
				allDoctor=healthFileService.getAllDoctorByHosId(communityHospital.getCommunityHospitalId());
				specialDoctor =healthFileService.getSpeciallDoctor(communityHospital.getCommunityHospitalId());
				allEnterPeople=staffService.getAllOperator(communityHospital.getCommunityHospitalId());
				staffs = staffService.getStaffByCommunityHospitalId(communityHospital.getCommunityHospitalId());
				if(searchbean.getDanganzhuangtai()!=0){
					return "searchInHospitalHistoryKill";
				}
				else{
					return "searchInHospitalHistory";
				}
			}
		}
		else if(session.getAttribute("tstaff")!=null){
			tstaff =  (TStaff) session.getAttribute("tstaff");
			hosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId());
			if(healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())){//判断员工是否为责任医生，若是，则只能看到所对应的老人
				page.setTotalNum(inHospitalHistoryService.findChronicPeopleCountForSpecial(searchbean, tstaff.getStaffId()));
				vinHospitalHistoryList=inHospitalHistoryService.findChronicPeopleForSpecial(searchbean, page, tstaff.getStaffId());
				allDoctor=healthFileService.getAllDoctorByHosId(hosId);
				allEnterPeople=staffService.getAllOperator(hosId);
				staffs = staffService.getStaffByCommunityHospitalId(hosId);
				flagDuo=true;
			}else{
				page.setTotalNum(inHospitalHistoryService.findChronicPeopleCount(searchbean, hosId));
				vinHospitalHistoryList=inHospitalHistoryService.findChronicPeople(searchbean, page, hosId);
				allDoctor=healthFileService.getAllDoctorByHosId(hosId);
				specialDoctor =healthFileService.getSpeciallDoctor(hosId);
				allEnterPeople=staffService.getAllOperator(hosId);
				staffs = staffService.getStaffByCommunityHospitalId(hosId);
			}
			this.pageHtml=page.getPage("entity");
			if(searchbean.getDanganzhuangtai()!=0){
				return "searchInHospitalHistoryKill";
			}
			else{
				return "searchInHospitalHistory";
			}
		}
		else{
			return "error";
		}
		
	}

	public String showInHospitalHistory(){
		page = new Page<VInHospitalHistory>();
		page.setCurrentPage(cp);
		page.setPageSize(10);
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
		if(group!=null){//集团负责人登陆
			issq = 1;//0是平台管理员登陆，1是集团登陆，2是其他登陆
			hospitals = communityHospitalGroupService.getComHosListByGroup(group);
			page.setTotalNum(inHospitalHistoryService.getInHospitalHistoryCountForGroup(group.getGId()));
			this.pageHtml = page.getPage("inHospitalHistoryAction!showInHospitalHistory.action");
			vinHospitalHistoryList=inHospitalHistoryService.getAllInHospitalHistoryForGroup(page, group.getGId());
			flagPingTai = true;
			return "showInHospitalHistory";
		}
		if(session.getAttribute("comHospital")!=null){
			communityHospital = (TCommunityHospital) session.getAttribute("comHospital");
			//communityHospital=communityHospitalService.getCommunityHospitalById(hosId);
			//hosName=communityHospital.getCommunityHospital();
			if(communityHospital.getIsHead()==Admin_IsHead.guanliyuan.getValue()){
				//setHospitals(communityHospitalService.getAllHospitals());
				setGroups(communityHospitalGroupService.getAllGroups());
				setIssq(0);//0是平台管理员登陆，1是集团登陆，2是其他登陆
				page.setTotalNum(inHospitalHistoryService.getInHospitalHistoryCount());
				this.pageHtml=page.getPage("inHospitalHistoryAction!showInHospitalHistory.action");
				vinHospitalHistoryList=inHospitalHistoryService.getAllInHospitalHistory(page);
				allDoctor=healthFileService.getAllDoctorByHosId();
				allEnterPeople=staffService.getAllOperator();
				flagPingTai=true;
				return "showInHospitalHistory";
			}
			else {
				page.setTotalNum(inHospitalHistoryService.getInHospitalHistoryCount(communityHospital.getCommunityHospitalId()));
				this.pageHtml=page.getPage("inHospitalHistoryAction!showInHospitalHistory.action");
				vinHospitalHistoryList=inHospitalHistoryService.getAllInHospitalHistory(page, communityHospital.getCommunityHospitalId());
				allDoctor=healthFileService.getAllDoctorByHosId(communityHospital.getCommunityHospitalId());
				specialDoctor =healthFileService.getSpeciallDoctor(communityHospital.getCommunityHospitalId());
				allEnterPeople=staffService.getAllOperator(communityHospital.getCommunityHospitalId());
				staffs = staffService.getStaffByCommunityHospitalId(communityHospital.getCommunityHospitalId());
				return "showInHospitalHistory";
			}
		}
		else if(session.getAttribute("tstaff")!=null){
			tstaff =  (TStaff) session.getAttribute("tstaff");
			hosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId());
			if(healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())){//判断员工是否为责任医生，若是，则只能看到所对应的老人
				page.setTotalNum(inHospitalHistoryService.getInHospitalHistoryCountForSpecial(tstaff.getStaffId()));
				vinHospitalHistoryList=inHospitalHistoryService.getAllInHospitalHistoryForSpecial(page, tstaff.getStaffId());
				allDoctor=healthFileService.getAllDoctorByHosId(hosId);
				allEnterPeople=staffService.getAllOperator(hosId);
				staffs = staffService.getStaffByCommunityHospitalId(hosId);
				flagDuo=true;
			}else{
				page.setTotalNum(inHospitalHistoryService.getInHospitalHistoryCount(hosId));
				vinHospitalHistoryList=inHospitalHistoryService.getAllInHospitalHistory(page, hosId);
				allDoctor=healthFileService.getAllDoctorByHosId(hosId);
				specialDoctor =healthFileService.getSpeciallDoctor(hosId);
				allEnterPeople=staffService.getAllOperator(hosId);
				staffs = staffService.getStaffByCommunityHospitalId(hosId);
			}
			this.pageHtml=page.getPage("inHospitalHistoryAction!showInHospitalHistory.action");
			return "showInHospitalHistory";
		}
		else{
			return "error";
		}

	}
	/**
	 * 转到新增界面
	 * @return
	 */
	public String findAndAddInHospitalHistory(){
		conFlag=0;
		return "findAndAddInHospitalHistory";
	}
	/**
	 * 新增记录时先精确查找老人（健康档案）
	 * @return
	 */
	public String findInHospitalHistory(){
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
					return "findAndAddInHospitalHistory";
				}
				else if(listolder.size()==1){
					int hid=listolder.get(0).getHealthFileId();
					healthFile=healthFileService.getHealthFileById(hid);
				}
				else if(listolder.size()>1){
					showwindow=true;
					conFlag=0;//不显示列表信息
					return "findAndAddInHospitalHistory";
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
						return "findAndAddInHospitalHistory";
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
					return "findAndAddInHospitalHistory";
				 }
				if(healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())){
					oldstaffhos=staffService.gethosByFileid(healthFile.getHealthFileId());
					int test1=oldstaffhos.getTStaff().getStaffId();
					if(test1!=tstaff.getStaffId()){
						str="未找到该老人信息";
						conFlag=0;healthFile=null;
						return "findAndAddInHospitalHistory";
					}
				}
			}
			conFlag=1;
			token = TokenProccessor.getInstance().makeToken();//创建令牌
			HttpServletRequest request=ServletActionContext.getRequest();
			request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
			return "findInHospitalHistory";
		}
		else {
			str="未找到该老人信息";
			conFlag=0;
			return "findAndAddInHospitalHistory";
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
		return "findInHospitalHistory";
	}
	/**
	 * 添加随诊记录
	 * @return
	 */
	public String addInHospitalHistory(){
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "DocDRedir";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		////////////////
		healthFile=healthFileService.getHealthFileById(healthFileId);
		if(healthFile == null){
			str="未找到老人信息";
			return "inHospitalHistoryError";
		}
		inHospitalHistory.setTHealthFile(healthFile);
		inHospitalHistoryService.saveInHospitalHistory(inHospitalHistory);
		return "addInHospitalHistory";
	}
	public String turnToAddPersonInHospitalHistory(){
		token = TokenProccessor.getInstance().makeToken();//创建令牌
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
		//////////
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
		return "turnToAddPersonInHospitalHistory";
	}
	public String turnToDetailInHospitalHistory(){
		if(healthFileService.getHealthFileById(healthFileId)==null||inHospitalHistoryService.getInHospitalHistoryByIHHId(ihhId)==null){
			return "error";
		}
		healthFile=healthFileService.getHealthFileById(healthFileId);
		inHospitalHistory=inHospitalHistoryService.getInHospitalHistoryByIHHId(ihhId);
		if(inHospitalHistory.getTHealthFile().getHealthFileId()!=healthFileId){
			return "error";
		}
		return "turnToDetailInHospitalHistory";
	}
	public String deleteInHospitalHistory(){
		inHospitalHistory=inHospitalHistoryService.getInHospitalHistoryByIHHId(ihhId);
		if(inHospitalHistory==null){
			return "error";
		}
		healthFileId=inHospitalHistory.getTHealthFile().getHealthFileId();
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
		inHospitalHistoryService.deleteInHospitalHistoryByIHHId(ihhId);
		return "deleteInHospitalHistory";
	}
	/*public String deleteInHospitalHistoryList(){
		inHospitalHistoryService.deleteInHospitalHistory(deleteList);
	}*/
	public String updateInHospitalHistory(){
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "DocDRedir";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		///////////////
		healthFile=healthFileService.getHealthFileById(healthFileId);
		inHospitalHistory.setTHealthFile(healthFile);
		inHospitalHistoryService.updateInHospitalHistory(inHospitalHistory);
		return "updateInHospitalHistory";
	}
	public String turnToUpdateInHospitalHistory(){
		token = TokenProccessor.getInstance().makeToken();//创建令牌
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
		/////////////////
		if(healthFileService.getHealthFileById(healthFileId)==null||inHospitalHistoryService.getInHospitalHistoryByIHHId(ihhId)==null){
			return "error";
		}
		healthFile=healthFileService.getHealthFileById(healthFileId);
		inHospitalHistory=inHospitalHistoryService.getInHospitalHistoryByIHHId(ihhId);
		if(inHospitalHistory.getTHealthFile().getHealthFileId()!=healthFileId){
			return "error";
		}
		return "turnToUpdateInHospitalHistory";
	}
	public String deleteMoreInHospitalHistory(){
		inHospitalHistoryService.deleteDRRecord(allInHospitalHistoryId);
		return "deleteMoreInHospitalHistory";
	}
	public List<VInHospitalHistory> getVinHospitalHistoryList() {
		return vinHospitalHistoryList;
	}
	public void setVinHospitalHistoryList(
			List<VInHospitalHistory> vinHospitalHistoryList) {
		this.vinHospitalHistoryList = vinHospitalHistoryList;
	}
	public TInHospitalHistory getInHospitalHistory() {
		return inHospitalHistory;
	}
	public void setInHospitalHistory(TInHospitalHistory inHospitalHistory) {
		this.inHospitalHistory = inHospitalHistory;
	}
	public Page<VInHospitalHistory> getPage() {
		return page;
	}
	public void setPage(Page<VInHospitalHistory> page) {
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
	public int getIhhId() {
		return ihhId;
	}
	public void setIhhId(int ihhId) {
		this.ihhId = ihhId;
	}
	public int[] getChoice() {
		return choice;
	}
	public void setChoice(int[] choice) {
		this.choice = choice;
	}
	public List<Object> getAllInHospitalHistoryId() {
		return allInHospitalHistoryId;
	}
	public void setAllInHospitalHistoryId(List<Object> allInHospitalHistoryId) {
		this.allInHospitalHistoryId = allInHospitalHistoryId;
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

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}


	public int getConFlag() {
		return conFlag;
	}


	public void setConFlag(int conFlag) {
		this.conFlag = conFlag;
	}


	public VInHospitalHistory getVinHospitalHistory() {
		return vinHospitalHistory;
	}


	public void setVinHospitalHistory(VInHospitalHistory vinHospitalHistory) {
		this.vinHospitalHistory = vinHospitalHistory;
	}



	public List<TCommunityHospital> getHospitals() {
		return hospitals;
	}


	public void setHospitals(List<TCommunityHospital> hospitals) {
		this.hospitals = hospitals;
	}


	public int getIssq() {
		return issq;
	}


	public void setIssq(int issq) {
		this.issq = issq;
	}


	public boolean isFlagPingTai() {
		return flagPingTai;
	}


	public void setFlagPingTai(boolean flagPingTai) {
		this.flagPingTai = flagPingTai;
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
