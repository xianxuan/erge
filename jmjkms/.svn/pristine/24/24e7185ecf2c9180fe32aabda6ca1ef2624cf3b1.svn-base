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

import com.jmjk.action.base.BaseAction;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.THealthFile;
import com.jmjk.entity.TMedicalRecord;
import com.jmjk.entity.TOldStaffHos;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.view.VHealthStaff;
import com.jmjk.entity.view.VMedicalRecord;
import com.jmjk.entity.view.VStaffHos;
import com.jmjk.enums.Admin_IsHead;
import com.jmjk.enums.HealthFileCheck;
import com.jmjk.export.medialExport;
import com.jmjk.service.CommunityHospitalGroupService;
import com.jmjk.service.CommunityHospitalService;
import com.jmjk.service.HealthFileService;
import com.jmjk.service.MedicalRecordService;
import com.jmjk.service.StaffService;
import com.jmjk.utils.JxlExcel;
import com.jmjk.utils.Page;
import com.jmjk.utils.Resubmit;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.SearchBeanSU;
import com.jmjk.utils.TokenProccessor;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
@Component
@Scope("prototype")
@Action(value="medicalRecordAction",results={
		@Result(name="addMedicalRecord",type = "redirectAction", location = "medicalRecordAction!showMedicalRecord.action"),
		@Result(name="success",location="/success.jsp"),
		@Result(name="showMedicalRecord",location="/jsp/medicalRecord/medicalRecordMain.jsp"),
		@Result(name="findMedicalRecord",location="/jsp/medicalRecord/medicalRecordAdd.jsp"),
		@Result(name="error",location="/error.jsp"),
		@Result(name="findAndAddMedicalRecord",location="/jsp/medicalRecord/medicalRecordAdd.jsp"),
		@Result(name="turnToAddPersonMedicalRecord",location="/jsp/medicalRecord/medicalRecordAddPerson.jsp"),
		@Result(name="turnToDetailMedicalRecord",location="/jsp/medicalRecord/medicalRecordDetail.jsp"),
		@Result(name="turnToUpdateMedicalRecord",location="/jsp/medicalRecord/medicalRecordAlter.jsp"),
		@Result(name="deleteMedicalRecord",type = "redirectAction", location = "medicalRecordAction!showMedicalRecord.action"),
		@Result(name="updateMedicalRecord",type = "redirectAction", location = "medicalRecordAction!showMedicalRecord.action"),
		@Result(name="deleteMoreMedicalRecord",type = "redirectAction", location = "medicalRecordAction!showMedicalRecord.action"),
		@Result(name="DocDRedir",type = "redirectAction", location = "medicalRecordAction!showMedicalRecord.action"),
		@Result(name="medicalRecordError",type = "redirectAction", location = "medicalRecordAction!findAndAddMedicalRecord.action",params = {"str","${str}"}),
		@Result(name="searchMedicalRecord",location="/jsp/medicalRecord/medicalRecordMain.jsp"),
		@Result(name="searchMedicalRecordKill",location="/jsp/medicalRecord/medicalRecordMainPlus.jsp"),
		})

public class MedicalRecordAction extends BaseAction {
	@Autowired
	MedicalRecordService medicalRecordService;	
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
	List<VMedicalRecord> vmedicalRecordList;
	TMedicalRecord  medicalRecord;
	private Page<VMedicalRecord> page;
	private String pageHtml;//分页
	private int cp=1;//分页
	private int hosId=4;
	private int flag=2;//0是档案编号1是身份证号
	private String value;//前台传来的档案编号或者身份证号Id内容
	private THealthFile healthFile;
	private int healthFileId;
	private int mrId;
	private int choice[];
	private List<Object> allMedicalRecordId;
	private TCommunityHospital communityHospital;
	private TStaff  tstaff;
	private String str;
	private int conFlag;
	private int issq = 2;//判断是否是平台管理员的状态量，用于是否显示社区医院搜索医院选项
	private List<TCommunityHospital> hospitals; //社区医院list
	private VMedicalRecord vmedicalRecord;
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
			List<medialExport> conList=new ArrayList<medialExport>();
			if(choice!=null){
				for(int i=0;i<choice.length;i++){
					vmedicalRecord=medicalRecordService.getVMedicalRecord(choice[i]);
					if(vmedicalRecord!=null){
						medialExport ct=new medialExport(vmedicalRecord);
						conList.add(ct);
					}
					
				}
			}
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("content-disposition", "attachment;filename="+4+".xls");
			ServletOutputStream output = response.getOutputStream();
			medialExport ct = new medialExport();
			String [] titles = ct.getTitles();
			JxlExcel he = new JxlExcel(titles);
    		he.write(conList, output);
    		response.flushBuffer();
		}
		
		if(conFlag==2){//导出全部
			List<medialExport> conList=new ArrayList<medialExport>();
			String [] titles=(new medialExport()).getTitles();
			HttpSession session = ServletActionContext.getRequest().getSession();
			if(session.getAttribute("comHospital")!=null){
				communityHospital = (TCommunityHospital) session.getAttribute("comHospital");
				if(communityHospital.getIsHead()==Admin_IsHead.guanliyuan.getValue()){
					this.pageHtml=page.getPage("medicalRecordAction!showMedicalRecord.action");
					vmedicalRecordList=medicalRecordService.getAllMedicalRecord();
				}
				else {
					vmedicalRecordList=medicalRecordService.getAllMedicalRecord(communityHospital.getCommunityHospitalId());
				}
			}
			else if(session.getAttribute("tstaff")!=null){
				tstaff =  (TStaff) session.getAttribute("tstaff");
				hosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId());
				if(healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())){//判断员工是否为责任医生，若是，则只能看到所对应的老人
					vmedicalRecordList=medicalRecordService.getAllMedicalRecordForSpecial(tstaff.getStaffId());
				}else{
					vmedicalRecordList=medicalRecordService.getAllMedicalRecord(communityHospital.getCommunityHospitalId());
				}
			}
			
		
			for(VMedicalRecord vMedicalRecord : vmedicalRecordList){
				if(vMedicalRecord!=null){
					medialExport cExport=new medialExport(vMedicalRecord);//*
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
	public String searchMedicalRecord(){
		page = new Page<VMedicalRecord>();
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
			page.setTotalNum(medicalRecordService.findChronicPeopleCount(searchbean));
			this.pageHtml=page.getPage("entity");
			vmedicalRecordList=medicalRecordService.findChronicPeople(searchbean, page);
			flagPingTai=true;//当flagPingTai==true时，会隐藏多条件查询里的录入人、责任医生等选项
			if(searchbean.getDanganzhuangtai()!=0){
				return "searchMedicalRecordKill";
			}
			else{
				return "searchMedicalRecord";
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
				page.setTotalNum(medicalRecordService.findChronicPeopleCount(searchbean));
				this.pageHtml=page.getPage("entity");
				vmedicalRecordList=medicalRecordService.findChronicPeople(searchbean, page);
				allDoctor=healthFileService.getAllDoctorByHosId();
				allEnterPeople=staffService.getAllOperator();
				
				flagPingTai=true;
				if(searchbean.getDanganzhuangtai()!=0){
					return "searchMedicalRecordKill";
				}
				else{
					return "searchMedicalRecord";
				}
				
			}
			else {
				page.setTotalNum(medicalRecordService.findChronicPeopleCount(searchbean, communityHospital.getCommunityHospitalId()));
				this.pageHtml=page.getPage("entity");
				vmedicalRecordList=medicalRecordService.findChronicPeople(searchbean, page, communityHospital.getCommunityHospitalId());
				allDoctor=healthFileService.getAllDoctorByHosId(communityHospital.getCommunityHospitalId());
				allEnterPeople=staffService.getAllOperator(communityHospital.getCommunityHospitalId());
				staffs = staffService.getStaffByCommunityHospitalId(communityHospital.getCommunityHospitalId());
				specialDoctor =healthFileService.getSpeciallDoctor(communityHospital.getCommunityHospitalId());
				if(searchbean.getDanganzhuangtai()!=0){
					return "searchMedicalRecordKill";
				}
				else{
					return "searchMedicalRecord";
				}
				
			}
		}
		else if(session.getAttribute("tstaff")!=null){
			tstaff =  (TStaff) session.getAttribute("tstaff");
			hosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId());
			if(healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())){//判断员工是否为责任医生，若是，则只能看到所对应的老人
				page.setTotalNum(medicalRecordService.findChronicPeopleCountForSpecial(searchbean, tstaff.getStaffId()));
				vmedicalRecordList=medicalRecordService.findChronicPeopleForSpecial(searchbean, page, tstaff.getStaffId());
				allDoctor=healthFileService.getAllDoctorByHosId(hosId);
				allEnterPeople=staffService.getAllOperator(hosId);
				staffs = staffService.getStaffByCommunityHospitalId(hosId);
				flagDuo=true;
			}else{
				page.setTotalNum(medicalRecordService.findChronicPeopleCount(searchbean, hosId));
				vmedicalRecordList=medicalRecordService.findChronicPeople(searchbean, page,hosId);
				allDoctor=healthFileService.getAllDoctorByHosId(hosId);
				specialDoctor =healthFileService.getSpeciallDoctor(hosId);
				allEnterPeople=staffService.getAllOperator(hosId);
				staffs = staffService.getStaffByCommunityHospitalId(hosId);
			}
			this.pageHtml=page.getPage("entity");
			
			if(searchbean.getDanganzhuangtai()!=0){
				return "searchMedicalRecordKill";
			}
			else{
				return "searchMedicalRecord";
			}
			
		}
		else{
			return "error";
		}
		
	}

	public String showMedicalRecord(){
		page = new Page<VMedicalRecord>();
		page.setCurrentPage(cp);
		page.setPageSize(10);
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
		if(group!=null){//集团负责人登陆
			issq = 1;//0是平台管理员登陆，1是集团登陆，2是其他登陆
			hospitals = communityHospitalGroupService.getComHosListByGroup(group);
			page.setTotalNum(medicalRecordService.getMedicalRecordCountForGroup(group.getGId()));
			this.pageHtml = page.getPage("medicalRecordAction!showMedicalRecord.action");
			vmedicalRecordList=medicalRecordService.getAllMedicalRecordForGroup(page, group.getGId());
			flagPingTai = true;
			return "showMedicalRecord";
		}
		if(session.getAttribute("comHospital")!=null){
			communityHospital = (TCommunityHospital) session.getAttribute("comHospital");
			//communityHospital=communityHospitalService.getCommunityHospitalById(hosId);
			//hosName=communityHospital.getCommunityHospital();
			if(communityHospital.getIsHead()==Admin_IsHead.guanliyuan.getValue()){
				setGroups(communityHospitalGroupService.getAllGroups());
				//setHospitals(communityHospitalService.getAllHospitals());
				issq = 0;//0是平台管理员登陆，1是集团登陆，2是其他登陆 
				page.setTotalNum(medicalRecordService.getMedicalRecordCount());
				this.pageHtml=page.getPage("medicalRecordAction!showMedicalRecord.action");
				vmedicalRecordList=medicalRecordService.getAllMedicalRecord(page);
				allDoctor=healthFileService.getAllDoctorByHosId();
				allEnterPeople=staffService.getAllOperator();
				flagPingTai=true;
				return "showMedicalRecord";
			}
			else {
				page.setTotalNum(medicalRecordService.getMedicalRecordCount(communityHospital.getCommunityHospitalId()));
				this.pageHtml=page.getPage("medicalRecordAction!showMedicalRecord.action");
				vmedicalRecordList=medicalRecordService.getAllMedicalRecord(page, communityHospital.getCommunityHospitalId());
				allDoctor=healthFileService.getAllDoctorByHosId(communityHospital.getCommunityHospitalId());
				allEnterPeople=staffService.getAllOperator(communityHospital.getCommunityHospitalId());
				specialDoctor =healthFileService.getSpeciallDoctor(communityHospital.getCommunityHospitalId());
				staffs = staffService.getStaffByCommunityHospitalId(communityHospital.getCommunityHospitalId());
				return "showMedicalRecord";
			}
		}
		else if(session.getAttribute("tstaff")!=null){
			tstaff =  (TStaff) session.getAttribute("tstaff");
			hosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId());
			if(healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())){//判断员工是否为责任医生，若是，则只能看到所对应的老人
				page.setTotalNum(medicalRecordService.getMedicalRecordCountForSpecial(tstaff.getStaffId()));
				vmedicalRecordList=medicalRecordService.getAllMedicalRecordForSpecial(page, tstaff.getStaffId());
				allDoctor=healthFileService.getAllDoctorByHosId(hosId);
				allEnterPeople=staffService.getAllOperator(hosId);
				staffs = staffService.getStaffByCommunityHospitalId(hosId);
				flagDuo=true;
			}else{
				page.setTotalNum(medicalRecordService.getMedicalRecordCount(hosId));
				vmedicalRecordList=medicalRecordService.getAllMedicalRecord(page, hosId);
				allDoctor=healthFileService.getAllDoctorByHosId(hosId);
				specialDoctor =healthFileService.getSpeciallDoctor(hosId);
				allEnterPeople=staffService.getAllOperator(hosId);
				staffs = staffService.getStaffByCommunityHospitalId(hosId);
			}
			this.pageHtml=page.getPage("medicalRecordAction!showMedicalRecord.action");
			return "showMedicalRecord";
		}
		else{
			return "error";
		}

	}
	/**
	 * 转到新增界面
	 * @return
	 */
	public String findAndAddMedicalRecord(){
		conFlag=0;
		return "findAndAddMedicalRecord";
	}
	/**
	 * 新增记录时先精确查找老人（健康档案）
	 * @return
	 */
	public String findMedicalRecord(){
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
					return "findAndAddMedicalRecord";
				}
				else if(listolder.size()==1){
					int hid=listolder.get(0).getHealthFileId();
					healthFile=healthFileService.getHealthFileById(hid);
				}
				else if(listolder.size()>1){
					showwindow=true;
					conFlag=0;//不显示列表信息
					return "findAndAddMedicalRecord";
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
						return "findAndAddMedicalRecord";
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
					return "findAndAddMedicalRecord";
				 }
				if(healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())){
					oldstaffhos=staffService.gethosByFileid(healthFile.getHealthFileId());
					int test1=oldstaffhos.getTStaff().getStaffId();
					if(test1!=tstaff.getStaffId()){
						str="未找到该老人信息";
						conFlag=0;healthFile=null;
						return "findAndAddMedicalRecord";
					}
				}
			}
			conFlag=1;
			token = TokenProccessor.getInstance().makeToken();//创建令牌
			HttpServletRequest request=ServletActionContext.getRequest();
			request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
			return "findMedicalRecord";
		}
		else {
			str="未找到该老人信息";
			conFlag=0;
			return "findAndAddMedicalRecord";
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
		return "findMedicalRecord";
	}
	/**
	 * 添加随诊记录
	 * @return
	 */
	public String addMedicalRecord(){
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "DocDRedir";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		///////////////
		healthFile=healthFileService.getHealthFileById(healthFileId);
		if(healthFile == null){
			str="未找到老人信息";
			return "medicalRecordError";
		}
		medicalRecord.setTHealthFile(healthFile);
		medicalRecordService.saveMedicalRecord(medicalRecord);
		return "addMedicalRecord";
	}
	public String turnToAddPersonMedicalRecord(){
		token = TokenProccessor.getInstance().makeToken();//创建令牌
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
		////////////
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
		return "turnToAddPersonMedicalRecord";
	}
	public String turnToDetailMedicalRecord(){
		if(healthFileService.getHealthFileById(healthFileId)==null||medicalRecordService.getMedicalRecordByMRId(mrId)==null){
			return "error";
		}
		healthFile=healthFileService.getHealthFileById(healthFileId);
		medicalRecord=medicalRecordService.getMedicalRecordByMRId(mrId);
		if(medicalRecord.getTHealthFile().getHealthFileId()!=healthFileId){
			return "error";
		}
		return "turnToDetailMedicalRecord";
	}
	public String deleteMedicalRecord(){
		medicalRecord=medicalRecordService.getMedicalRecordByMRId(mrId);
		if(medicalRecord==null){
			return "error";
		}
		healthFileId=medicalRecord.getTHealthFile().getHealthFileId();
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
		medicalRecordService.deleteMedicalRecordByMRId(mrId);
		return "deleteMedicalRecord";
	}
	/*public String deleteMedicalRecordList(){
		medicalRecordService.deleteMedicalRecord(deleteList);
	}*/
	public String updateMedicalRecord(){
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "DocDRedir";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		///////////////
		healthFile=healthFileService.getHealthFileById(healthFileId);
		medicalRecord.setTHealthFile(healthFile);
		medicalRecordService.updateMedicalRecord(medicalRecord);
		return "updateMedicalRecord";
	}
	public String turnToUpdateMedicalRecord(){
		token = TokenProccessor.getInstance().makeToken();//创建令牌
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
		/////////////
		if(healthFileService.getHealthFileById(healthFileId)==null||medicalRecordService.getMedicalRecordByMRId(mrId)==null){
			return "error";
		}
		healthFile=healthFileService.getHealthFileById(healthFileId);
		medicalRecord=medicalRecordService.getMedicalRecordByMRId(mrId);
		if(medicalRecord.getTHealthFile().getHealthFileId()!=healthFileId){
			return "error";
		}
		return "turnToUpdateMedicalRecord";
	}
	public String deleteMoreMedicalRecord(){
		medicalRecordService.deleteMedicalRecordByMRId(mrId);
		return "deleteMoreInHospitalHistory";
	}
	public List<Object> getAllMedicalRecordId() {
		return allMedicalRecordId;
	}
	public void setAllMedicalRecordId(List<Object> allMedicalRecordId) {
		this.allMedicalRecordId = allMedicalRecordId;
	}

	public List<VMedicalRecord> getVmedicalRecordList() {
		return vmedicalRecordList;
	}
	public void setVmedicalRecordList(List<VMedicalRecord> vmedicalRecordList) {
		this.vmedicalRecordList = vmedicalRecordList;
	}
	public TMedicalRecord getMedicalRecord() {
		return medicalRecord;
	}
	public void setMedicalRecord(TMedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}
	public Page<VMedicalRecord> getPage() {
		return page;
	}
	public void setPage(Page<VMedicalRecord> page) {
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
	public int getMrId() {
		return mrId;
	}
	public void setMrId(int mrId) {
		this.mrId = mrId;
	}
	public int[] getChoice() {
		return choice;
	}
	public void setChoice(int[] choice) {
		this.choice = choice;
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


	public VMedicalRecord getVmedicalRecord() {
		return vmedicalRecord;
	}


	public void setVmedicalRecord(VMedicalRecord vmedicalRecord) {
		this.vmedicalRecord = vmedicalRecord;
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
