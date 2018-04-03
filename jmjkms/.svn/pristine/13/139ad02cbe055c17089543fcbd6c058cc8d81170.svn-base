package com.jmjk.action;

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
import com.jmjk.entity.THealthFile;
import com.jmjk.entity.TIncompleteRecord;
import com.jmjk.entity.TOldStaffHos;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.view.VHealthStaff;
import com.jmjk.entity.view.VIncompleteRecord;
import com.jmjk.entity.view.VStaffHos;
import com.jmjk.enums.Admin_IsHead;
import com.jmjk.enums.HealthFileCheck;
import com.jmjk.export.incompleteExport;
import com.jmjk.service.CommunityHospitalGroupService;
import com.jmjk.service.CommunityHospitalService;
import com.jmjk.service.HealthFileService;
import com.jmjk.service.IncompleteRecordService;
import com.jmjk.service.StaffService;
import com.jmjk.utils.JxlExcel;
import com.jmjk.utils.Page;
import com.jmjk.utils.Resubmit;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.SearchBeanSU;
import com.jmjk.utils.TokenProccessor;
@Component
@Scope("prototype")
@Action(value="incompleteRecordAction",results={
		@Result(name="success",location="/success.jsp"),
		@Result(name="showIncompleteRecord",location="/jsp/incompleteRecord/incompleteRecordMain.jsp"),
		@Result(name="error",location="/error.jsp"),
		@Result(name="findIncompleteRecord",location="/jsp/incompleteRecord/incompleteRecordAdd.jsp"),
		@Result(name="findAndAddIncompleteRecord",location="/jsp/incompleteRecord/incompleteRecordAdd.jsp"),
		@Result(name="addIncompleteRecord",type = "redirectAction",location="incompleteRecordAction!showIncompleteRecord.action"),
		@Result(name="turnToAddPersonIncompleteRecord",location="/jsp/incompleteRecord/incompleteRecordAddPerson.jsp"),
		@Result(name="turnToDetailIncompleteRecord",location="/jsp/incompleteRecord/incompleteRecordDetail.jsp"),
		@Result(name="deleteIncompleteRecord",type = "redirectAction",location="incompleteRecordAction!showIncompleteRecord.action"),
		@Result(name="updateIncompleteRecord",type = "redirectAction",location="incompleteRecordAction!showIncompleteRecord.action"),
		@Result(name="turnToUpdateIncompleteRecord",location="/jsp/incompleteRecord/incompleteRecordAlter.jsp"),
		@Result(name="deleteMoreIncompleteRecord",type = "redirectAction",location="incompleteRecordAction!showIncompleteRecord.action"),
		@Result(name="DocDRedir",type = "redirectAction",location="incompleteRecordAction!showIncompleteRecord.action"),
		@Result(name="incompleteRecordError",type = "redirectAction",location="incompleteRecordAction!findAndAddIncompleteRecord.action",params = {"str","${str}"}),
		@Result(name="searchIncompleteRecord",location="/jsp/incompleteRecord/incompleteRecordMain.jsp"),
		@Result(name="searchIncompleteRecordKill",location="/jsp/incompleteRecord/incompleteRecordMainPlus.jsp"),
       })
public class IncompleteRecordAction extends BaseAction {
	@Autowired
	HealthFileService healthFileService;
	@Autowired
	IncompleteRecordService incompleteRecordService;
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
	private  Page<VIncompleteRecord>  page;
	private int hosId;
	private String pageHtml;//分页
	private List<VIncompleteRecord> vincompleteRecordList;
	private int cp=1;
	private List<Object> allIncompleteRecordId;
	private int flag=2;//0是档案编号1是身份证号
	private THealthFile healthFile;
	private int healthFileId;
	private TIncompleteRecord incompleteRecord;
	private int irId;
	private String value;//前台传来的档案编号或者身份证号Id内容
	private TCommunityHospital communityHospital;
	private TStaff  tstaff;
	private String str;
	private int conFlag; 
	private int issq = 2;//判断是否是平台管理员的状态量，用于是否显示社区医院搜索医院选项
	private List<TCommunityHospital> hospitals; //社区医院list
	private VIncompleteRecord vincompleteRecord;
	private int choice[];
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
			List<incompleteExport> conList=new ArrayList<incompleteExport>();
			if(choice!=null){
				for(int i=0;i<choice.length;i++){
					vincompleteRecord=incompleteRecordService.getVIncompleteRecord(choice[i]);
					if(vincompleteRecord!=null){
						incompleteExport ct=new incompleteExport(vincompleteRecord);
						conList.add(ct);
					}
					
				}
			}
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("content-disposition", "attachment;filename="+4+".xls");
			ServletOutputStream output = response.getOutputStream();
			incompleteExport ct = new incompleteExport();
			String [] titles = ct.getTitles();
			JxlExcel he = new JxlExcel(titles);
    		he.write(conList, output);
    		response.flushBuffer();
		}
		
		if(conFlag==2){//导出全部
			List<incompleteExport> conList=new ArrayList<incompleteExport>();
			String [] titles=(new incompleteExport()).getTitles();
			HttpSession session = ServletActionContext.getRequest().getSession();
			if(session.getAttribute("comHospital")!=null){
				communityHospital = (TCommunityHospital) session.getAttribute("comHospital");
				if(communityHospital.getIsHead()==Admin_IsHead.guanliyuan.getValue()){
					this.pageHtml=page.getPage("incompleteRecordAction!showIncompleteRecord.action");
					vincompleteRecordList=incompleteRecordService.getAllIncompleteRecord();
				}
				else {
					vincompleteRecordList=incompleteRecordService.getAllIncompleteRecord(communityHospital.getCommunityHospitalId());
				}
			}
			else if(session.getAttribute("tstaff")!=null){
				tstaff =  (TStaff) session.getAttribute("tstaff");
				hosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId());
				if(healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())){//判断员工是否为责任医生，若是，则只能看到所对应的老人
					vincompleteRecordList=incompleteRecordService.getAllIncompleteRecordForSpecial(tstaff.getStaffId());
				}else{
					vincompleteRecordList=incompleteRecordService.getAllIncompleteRecord(communityHospital.getCommunityHospitalId());
				}
			}
			
		
			for(VIncompleteRecord vIncompleteRecord : vincompleteRecordList){
				if(vIncompleteRecord!=null){
					incompleteExport cExport=new incompleteExport(vIncompleteRecord);//*
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
	

	public String searchIncompleteRecord(){
		page = new Page<VIncompleteRecord>();
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
			page.setTotalNum(incompleteRecordService.findChronicPeopleCount(searchbean));
			this.pageHtml=page.getPage("entity");
			vincompleteRecordList=incompleteRecordService.findChronicPeople(searchbean, page);
			flagPingTai=true;//当flagPingTai==true时，会隐藏多条件查询里的录入人、责任医生等选项
			if(searchbean.getDanganzhuangtai()!=0){
				return "searchIncompleteRecordKill";
			}
			else{
				return "searchIncompleteRecord";
			}
		}
		if(session.getAttribute("comHospital")!=null){
			communityHospital = (TCommunityHospital) session.getAttribute("comHospital");
			//communityHospital=communityHospitalService.getCommunityHospitalById(hosId);
			//hosName=communityHospital.getCommunityHospital();
			if(communityHospital.getIsHead()==Admin_IsHead.guanliyuan.getValue()){
				//hospitals = communityHospitalService.getAllHospitals();
				setGroups(communityHospitalGroupService.getAllGroups());
				searchbean.setShenfen(4);
				issq = 0;//0是平台管理员登陆，1是集团登陆，2是其他登陆 
				page.setTotalNum(incompleteRecordService.findChronicPeopleCount(searchbean));
				this.pageHtml=page.getPage("entity");
				vincompleteRecordList=incompleteRecordService.findChronicPeople(searchbean, page);
				allDoctor=healthFileService.getAllDoctorByHosId();
				allEnterPeople=staffService.getAllOperator();
				flagPingTai=true;
				if(searchbean.getDanganzhuangtai()!=0){
					return "searchIncompleteRecordKill";
				}
				else{
					return "searchIncompleteRecord";
				}
				
			}
			else {
				page.setTotalNum(incompleteRecordService.findChronicPeopleCount(searchbean, communityHospital.getCommunityHospitalId()));
				this.pageHtml=page.getPage("entity");
				vincompleteRecordList=incompleteRecordService.findChronicPeople(searchbean, page, communityHospital.getCommunityHospitalId());
				allDoctor=healthFileService.getAllDoctorByHosId(communityHospital.getCommunityHospitalId());
				specialDoctor =healthFileService.getSpeciallDoctor(communityHospital.getCommunityHospitalId());
				allEnterPeople=staffService.getAllOperator(communityHospital.getCommunityHospitalId());
				staffs = staffService.getStaffByCommunityHospitalId(communityHospital.getCommunityHospitalId());
				if(searchbean.getDanganzhuangtai()!=0){
					return "searchIncompleteRecordKill";
				}
				else{
					return "searchIncompleteRecord";
				}
			}
		}
		else if(session.getAttribute("tstaff")!=null){
			tstaff =  (TStaff) session.getAttribute("tstaff");
			hosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId());
			if(healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())){//判断员工是否为责任医生，若是，则只能看到所对应的老人
				page.setTotalNum(incompleteRecordService.findChronicPeopleCountForSpecial(searchbean, tstaff.getStaffId()));
				vincompleteRecordList=incompleteRecordService.findChronicPeopleForSpecial(searchbean, page, tstaff.getStaffId());
				allDoctor=healthFileService.getAllDoctorByHosId(hosId);
				allEnterPeople=staffService.getAllOperator(hosId);
				staffs = staffService.getStaffByCommunityHospitalId(hosId);
				flagDuo=true;
			}else{
				page.setTotalNum(incompleteRecordService.findChronicPeopleCount(searchbean, hosId));
				vincompleteRecordList=incompleteRecordService.findChronicPeople(searchbean, page, hosId);
				allDoctor=healthFileService.getAllDoctorByHosId(hosId);
				allEnterPeople=staffService.getAllOperator(hosId);
				specialDoctor =healthFileService.getSpeciallDoctor(hosId);
				staffs = staffService.getStaffByCommunityHospitalId(hosId);
			}
			this.pageHtml=page.getPage("entity");
			if(searchbean.getDanganzhuangtai()!=0){
				return "searchIncompleteRecordKill";
			}
			else{
				return "searchIncompleteRecord";
			}
		}
		else{
			return "error";
		}
		
	}

	public  String showIncompleteRecord(){
		page = new Page<VIncompleteRecord>();
		page.setCurrentPage(cp);
		page.setPageSize(10);
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
		if(group!=null){//集团负责人登陆
			issq = 1;//0是平台管理员登陆，1是集团登陆，2是其他登陆
			hospitals = communityHospitalGroupService.getComHosListByGroup(group);
			page.setTotalNum(incompleteRecordService.getIncompleteRecordCountForGroup(group.getGId()));
			this.pageHtml = page.getPage("incompleteRecordAction!showIncompleteRecord.action");
			vincompleteRecordList=incompleteRecordService.getAllIncompleteRecordForGroup(page, group.getGId());
			flagPingTai = true;
			return "showIncompleteRecord";
		}
		if(session.getAttribute("comHospital")!=null){
			communityHospital = (TCommunityHospital) session.getAttribute("comHospital");
			//communityHospital=communityHospitalService.getCommunityHospitalById(hosId);
			//hosName=communityHospital.getCommunityHospital();
			if(communityHospital.getIsHead()==Admin_IsHead.guanliyuan.getValue()){
				//hospitals = communityHospitalService.getAllHospitals();
				setGroups(communityHospitalGroupService.getAllGroups());
				issq = 0;//0是平台管理员登陆，1是集团登陆，2是其他登陆
				page.setTotalNum(incompleteRecordService.getIncompleteRecordCount());
				this.pageHtml=page.getPage("incompleteRecordAction!showIncompleteRecord.action");
				vincompleteRecordList=incompleteRecordService.getAllIncompleteRecord(page);
				allDoctor=healthFileService.getAllDoctorByHosId();
				allEnterPeople=staffService.getAllOperator();
				flagPingTai=true;
				return "showIncompleteRecord";
			}
			else {
				page.setTotalNum(incompleteRecordService.getIncompleteRecordCount(communityHospital.getCommunityHospitalId()));
				this.pageHtml=page.getPage("incompleteRecordAction!showIncompleteRecord.action");
				vincompleteRecordList=incompleteRecordService.getAllIncompleteRecord(page, communityHospital.getCommunityHospitalId());
				allDoctor=healthFileService.getAllDoctorByHosId(communityHospital.getCommunityHospitalId());
				specialDoctor =healthFileService.getSpeciallDoctor(communityHospital.getCommunityHospitalId());
				allEnterPeople=staffService.getAllOperator(communityHospital.getCommunityHospitalId());
				staffs = staffService.getStaffByCommunityHospitalId(communityHospital.getCommunityHospitalId());
				return "showIncompleteRecord";
			}
		}
		else if(session.getAttribute("tstaff")!=null){
			tstaff =  (TStaff) session.getAttribute("tstaff");
			hosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId());
			if(healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())){//判断员工是否为责任医生，若是，则只能看到所对应的老人
				page.setTotalNum(incompleteRecordService.getIncompleteRecordCountForSpecial(tstaff.getStaffId()));
				vincompleteRecordList=incompleteRecordService.getAllIncompleteRecordForSpecial(page, tstaff.getStaffId());
				allDoctor=healthFileService.getAllDoctorByHosId(hosId);
				allEnterPeople=staffService.getAllOperator(hosId);
				staffs = staffService.getStaffByCommunityHospitalId(hosId);
				flagDuo=true;
			}else{
				page.setTotalNum(incompleteRecordService.getIncompleteRecordCount(hosId));
				vincompleteRecordList=incompleteRecordService.getAllIncompleteRecord(page, hosId);
				allDoctor=healthFileService.getAllDoctorByHosId(hosId);
				allEnterPeople=staffService.getAllOperator(hosId);
				specialDoctor =healthFileService.getSpeciallDoctor(hosId);
				staffs = staffService.getStaffByCommunityHospitalId(hosId);
			}
			this.pageHtml=page.getPage("incompleteRecordAction!showIncompleteRecord.action");
			return "showIncompleteRecord";
		}
		else{
			return "error";
		}

		
	}
	public String findAndAddIncompleteRecord(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("comHospital")!=null){
			communityHospital=(TCommunityHospital) session.getAttribute("comHospital");
			if(communityHospital.getIsHead()!=Admin_IsHead.guanliyuan.getValue()){
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
		conFlag=0;
		return "findAndAddIncompleteRecord";
	}
	public String findIncompleteRecord(){
		

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
					return "findAndAddIncompleteRecord";
				}
				else if(listolder.size()==1){
					int hid=listolder.get(0).getHealthFileId();
					healthFile=healthFileService.getHealthFileById(hid);
				}
				else if(listolder.size()>1){
					showwindow=true;
					conFlag=0;//不显示列表信息
					return "findAndAddIncompleteRecord";
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
						return "findAndAddIncompleteRecord";
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
					return "findAndAddIncompleteRecord";
				 }
				if(healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())){
					oldstaffhos=staffService.gethosByFileid(healthFile.getHealthFileId());
					int test1=oldstaffhos.getTStaff().getStaffId();
					if(test1!=tstaff.getStaffId()){
						int i=oldstaffhos.getTStaff().getStaffId();//如果不加这句话，导致oldstaffhos.getTStaff().getStaffId()为null
						str="未找到该老人信息";
						conFlag=0;healthFile=null;
						return "findAndAddIncompleteRecord";
					}
				}
			}
			conFlag=1;
			token = TokenProccessor.getInstance().makeToken();//创建令牌
			HttpServletRequest request=ServletActionContext.getRequest();
			request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
			return "findIncompleteRecord";
		}
		else {
			str="未找到该老人信息";
			conFlag=0;
			return "findAndAddIncompleteRecord";
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
		return "findIncompleteRecord";
	}
	public String addIncompleteRecord(){
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "DocDRedir";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		///////////////////
		healthFile=healthFileService.getHealthFileById(healthFileId);
		if(healthFile == null){
			str="未找到老人信息";
			return "incompleteRecordError";
		}
		incompleteRecord.setTHealthFile(healthFile);
		incompleteRecordService.saveIncompleteRecord(incompleteRecord);
		return "addIncompleteRecord";
	}
	public String turnToAddPersonIncompleteRecord(){
		token = TokenProccessor.getInstance().makeToken();//创建令牌
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
		/////////////////////////////////////////////
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("comHospital")!=null){
			communityHospital=(TCommunityHospital) session.getAttribute("comHospital");
			if(communityHospital.getIsHead()!=Admin_IsHead.guanliyuan.getValue()){
				hosId=communityHospital.getCommunityHospitalId();
				allDoctor=healthFileService.getAllDoctorByHosId(hosId);
				staffs = staffService.getStaffByCommunityHospitalId(hosId);
				if(healthFileService.getOldStaffHosByHosIdAndHeathFileId(hosId, healthFileId)==null){
					return "error";
				}
			}
		}
		else if(session.getAttribute("tstaff")!=null){
			tstaff =  (TStaff) session.getAttribute("tstaff");
			hosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId());
			allDoctor=healthFileService.getAllDoctorByHosId(hosId);
			staffs = staffService.getStaffByCommunityHospitalId(hosId);
			if(healthFileService.getOldStaffHosByHosIdAndHeathFileId(hosId, healthFileId)==null){
				return "error";
			}
		}
		/////////////////////////
		healthFile=healthFileService.getHealthFileById(healthFileId);
		return "turnToAddPersonIncompleteRecord";
	}
	public String turnToDetailIncompleteRecord(){
		if(healthFileService.getHealthFileById(healthFileId)==null||incompleteRecordService.getIncompleteRecordByIRId(irId)==null){
			return "error";
		}
		healthFile=healthFileService.getHealthFileById(healthFileId);
		incompleteRecord=incompleteRecordService.getIncompleteRecordByIRId(irId);
		//////////////////////////////////////////////////
		if(incompleteRecord.getTHealthFile().getHealthFileId()!=healthFileId){
			return "error";
		}
		//////////////////////////////////////////////
		return "turnToDetailIncompleteRecord";
	}
	public String deleteIncompleteRecord(){
		////////////////////////////////////
		incompleteRecord=incompleteRecordService.getIncompleteRecordByIRId(irId);
		if(incompleteRecord==null){
			return "error";
		}
		healthFileId=incompleteRecord.getTHealthFile().getHealthFileId();
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
		//////////////////////////////////
		incompleteRecordService.deleteIncompleteRecordByIRd(irId);
		return "deleteIncompleteRecord";
	}
	public String updateIncompleteRecord(){
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "DocDRedir";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		//////////////
		healthFile=healthFileService.getHealthFileById(healthFileId);
		incompleteRecord.setTHealthFile(healthFile);
		incompleteRecordService.updateIncompleteRecord(incompleteRecord);
		return "updateIncompleteRecord";
	}
	public String turnToUpdateIncompleteRecord(){
		token = TokenProccessor.getInstance().makeToken();//创建令牌
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
		/////////////////////////////////
		if(healthFileService.getHealthFileById(healthFileId)==null||incompleteRecordService.getIncompleteRecordByIRId(irId)==null){
			return "error";
		}
		///////////////////////////////////
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session.getAttribute("comHospital")!=null){
			communityHospital=(TCommunityHospital) session.getAttribute("comHospital");
			if(communityHospital.getIsHead()!=Admin_IsHead.guanliyuan.getValue()){
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
		healthFile=healthFileService.getHealthFileById(healthFileId);
		incompleteRecord=incompleteRecordService.getIncompleteRecordByIRId(irId);
		if(incompleteRecord.getTHealthFile().getHealthFileId()!=healthFileId){
			return "error";
		}
		return "turnToUpdateIncompleteRecord";
	}
	public String deleteMoreIncompleteRecord(){
		incompleteRecordService.deleteIncompleteRecord(allIncompleteRecordId);
		return "deleteMoreIncompleteRecord";
	}
	public Page<VIncompleteRecord> getPage() {
		return page;
	}
	public void setPage(Page<VIncompleteRecord> page) {
		this.page = page;
	}
	public int getHosId() {
		return hosId;
	}
	public void setHosId(int hosId) {
		this.hosId = hosId;
	}
	public String getPageHtml() {
		return pageHtml;
	}
	public void setPageHtml(String pageHtml) {
		this.pageHtml = pageHtml;
	}
	public List<VIncompleteRecord> getVincompleteRecordList() {
		return vincompleteRecordList;
	}
	public void setVincompleteRecordList(
			List<VIncompleteRecord> vincompleteRecordList) {
		this.vincompleteRecordList = vincompleteRecordList;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public List<Object> getAllIncompleteRecordId() {
		return allIncompleteRecordId;
	}
	public void setAllIncompleteRecordId(List<Object> allIncompleteRecordId) {
		this.allIncompleteRecordId = allIncompleteRecordId;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
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
	public TIncompleteRecord getIncompleteRecord() {
		return incompleteRecord;
	}
	public void setIncompleteRecord(TIncompleteRecord incompleteRecord) {
		this.incompleteRecord = incompleteRecord;
	}
	public int getIrId() {
		return irId;
	}
	public void setIrId(int irId) {
		this.irId = irId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
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


	public VIncompleteRecord getVincompleteRecord() {
		return vincompleteRecord;
	}


	public void setVincompleteRecord(VIncompleteRecord vincompleteRecord) {
		this.vincompleteRecord = vincompleteRecord;
	}


	public int[] getChoice() {
		return choice;
	}


	public void setChoice(int[] choice) {
		this.choice = choice;
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
