package com.jmjk.action;

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

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jmjk.action.base.BaseAction;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.TFollowRecord;
import com.jmjk.entity.THealthFile;
import com.jmjk.entity.TMaintainableEntry;
import com.jmjk.entity.TOldStaffHos;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.view.VFollowRecord;
import com.jmjk.entity.view.VHealthStaff;
import com.jmjk.entity.view.VStaffHos;
import com.jmjk.enums.Admin_IsHead;
import com.jmjk.enums.HealthFileCheck;
import com.jmjk.export.followExport;
import com.jmjk.service.CommunityHospitalGroupService;
import com.jmjk.service.CommunityHospitalService;
import com.jmjk.service.FollowRecordService;
import com.jmjk.service.HealthFileService;
import com.jmjk.service.MaintainableAttributeService;
import com.jmjk.service.StaffService;
import com.jmjk.utils.JxlExcel;
import com.jmjk.utils.Page;
import com.jmjk.utils.Resubmit;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.SearchBeanSU;
import com.jmjk.utils.TokenProccessor;
@Component
@Scope("prototype")
@Action(value="followRecordAction",results={
		@Result(name="addFollowRecord",type = "redirectAction", location = "followRecordAction!showFollowRecord.action"),
		@Result(name="success",location="/success.jsp"),
		@Result(name="showFollowRecord",location="/jsp/followRecord/followRecordMain.jsp"),
		@Result(name="findFollowRecord",location="/jsp/followRecord/followRecordAdd.jsp"),
		@Result(name="error",location="/error.jsp"),
		@Result(name="findAndAddFollowRecord",location="/jsp/followRecord/followRecordAdd.jsp"),
		@Result(name="turnToAddPersonFollowRecord",location="/jsp/followRecord/followRecordAddPerson.jsp"),
		@Result(name="turnToDetailFollowRecord",location="/jsp/followRecord/followRecordDetail.jsp"),
		@Result(name="turnToUpdateFollowRecord",location="/jsp/followRecord/followRecordAlter.jsp"),
		@Result(name="deleteFollowRecord",type = "redirectAction", location = "followRecordAction!showFollowRecord.action"),
		@Result(name="DocDRedir",type = "redirectAction", location = "followRecordAction!showFollowRecord.action"),
		@Result(name="updateFollowRecord",type = "redirectAction", location = "followRecordAction!showFollowRecord.action"),
		@Result(name="deleteMoreFollowRecord",type = "redirectAction", location = "followRecordAction!showFollowRecord.action"),
		@Result(name="followRecordError",type = "redirectAction", location = "followRecordAction!findAndAddFollowRecord.action",params = {"str","${str}"}),
		@Result(name="searchFollowRecord",location="/jsp/followRecord/followRecordMain.jsp"),
		@Result(name="searchFollowRecordKill",location="/jsp/followRecord/followRecordMainPlus.jsp"),
		})
public class FollowRecordAction extends BaseAction {
	@Autowired
	FollowRecordService followRecordService;	
	@Autowired
	HealthFileService healthFileService;
	@Autowired
	StaffService staffService;
	@Autowired
    MaintainableAttributeService maintainableAttributeService;
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
	List<VFollowRecord> vfollowRecordList;
	TFollowRecord  followRecord;
	private Page<VFollowRecord> page;
	private String pageHtml;//分页
	private int cp=1;//分页
	private int hosId;
	private int state=2;
	private int flag=2;//0是档案编号1是身份证号
	private String value;//前台传来的档案编号或者身份证号Id内容
	private THealthFile healthFile;
	private int healthFileId;
	private int indexFlag;
	private int followId;
	private int choice[];
	private List<Object> allFollowRecordId;
	private TCommunityHospital communityHospital;
	private TStaff  tstaff;
	private String  str;
	private int conFlag;
	private int issq = 2;//判断是否是平台管理员的状态量，用于是否显示社区医院搜索医院选项
	private List<TCommunityHospital> hospitals; //社区医院list
	private VFollowRecord vfollowRecord;
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
			List<followExport> conList=new ArrayList<followExport>();
			if(choice!=null){
				for(int i=0;i<choice.length;i++){
					vfollowRecord=followRecordService.getVFollowRecord(choice[i]);
					if(vfollowRecord!=null){
						followExport ct=new followExport(vfollowRecord);
						conList.add(ct);
					}
					
				}
			}
			
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("content-disposition", "attachment;filename="+4+".xls");
			ServletOutputStream output = response.getOutputStream();
			followExport ct = new followExport();
			String [] titles = ct.getTitles();
			JxlExcel he = new JxlExcel(titles);
    		he.write(conList, output);
    		response.flushBuffer();
		}
		
		if(conFlag==2){//导出全部
			List<followExport> conList=new ArrayList<followExport>();
			String [] titles=(new followExport()).getTitles();
			HttpSession session = ServletActionContext.getRequest().getSession();
			if(session.getAttribute("comHospital")!=null){
				communityHospital = (TCommunityHospital) session.getAttribute("comHospital");
				if(communityHospital.getIsHead()==Admin_IsHead.guanliyuan.getValue()){
					this.pageHtml=page.getPage("followRecordAction!showFollowRecord.action");
					vfollowRecordList=followRecordService.getAllFollowRecord();
				}
				else {
					vfollowRecordList=followRecordService.getAllFollowRecord(communityHospital.getCommunityHospitalId());
				}
			}
			else if(session.getAttribute("tstaff")!=null){
				tstaff =  (TStaff) session.getAttribute("tstaff");
				hosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId());
				if(healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())){//判断员工是否为责任医生，若是，则只能看到所对应的老人
					vfollowRecordList=followRecordService.getAllFollowRecordForSpecial(tstaff.getStaffId());
				}else{
					vfollowRecordList=followRecordService.getAllFollowRecord(communityHospital.getCommunityHospitalId());
				}
			}
			
		
			for(VFollowRecord vFollowRecord : vfollowRecordList){
				if(vFollowRecord!=null){
					followExport cExport=new followExport(vFollowRecord);//*
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
	public String searchFollowRecord(){
		page = new Page<VFollowRecord>();
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
			page.setTotalNum(followRecordService.findChronicPeopleCount(searchbean));
			this.pageHtml=page.getPage("entity");
			vfollowRecordList=followRecordService.findChronicPeople(searchbean, page);
			flagPingTai=true;//当flagPingTai==true时，会隐藏多条件查询里的录入人、责任医生等选项
			setIndexFlag(1);
			if(searchbean.getDanganzhuangtai()!=0){
				return "searchFollowRecordKill";
			}
			else{
				return "searchFollowRecord";
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
				page.setTotalNum(followRecordService.findChronicPeopleCount(searchbean));
				this.pageHtml=page.getPage("entity");
				vfollowRecordList=followRecordService.findChronicPeople(searchbean, page);
				allDoctor=healthFileService.getAllDoctorByHosId();
				allEnterPeople=staffService.getAllOperator();
				flagPingTai=true;
				setIndexFlag(1);
				if(searchbean.getDanganzhuangtai()!=0){
					return "searchFollowRecordKill";
				}
				else{
					return "searchFollowRecord";
				}
				
			}
			else {
				page.setTotalNum(followRecordService.findChronicPeopleCount(searchbean, communityHospital.getCommunityHospitalId()));
				this.pageHtml=page.getPage("entity");
				vfollowRecordList=followRecordService.findChronicPeople(searchbean, page, communityHospital.getCommunityHospitalId());
				allDoctor=healthFileService.getAllDoctorByHosId(communityHospital.getCommunityHospitalId());
				allEnterPeople=staffService.getAllOperator(communityHospital.getCommunityHospitalId());
				specialDoctor =healthFileService.getSpeciallDoctor(communityHospital.getCommunityHospitalId());
				staffs = staffService.getStaffByCommunityHospitalId(communityHospital.getCommunityHospitalId());
				if(searchbean.getDanganzhuangtai()!=0){
					return "searchFollowRecordKill";
				}
				else{
					return "searchFollowRecord";
				}
			}
		}
		else if(session.getAttribute("tstaff")!=null){
			tstaff =  (TStaff) session.getAttribute("tstaff");
			hosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId());
			if(healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())){//判断员工是否为责任医生，若是，则只能看到所对应的老人
				page.setTotalNum(followRecordService.findChronicPeopleCountForSpecial(searchbean, tstaff.getStaffId()));
				vfollowRecordList=followRecordService.findChronicPeopleForSpecial(searchbean, page, tstaff.getStaffId());
				allDoctor=healthFileService.getAllDoctorByHosId(hosId);
				allEnterPeople=staffService.getAllOperator(hosId);
				staffs = staffService.getStaffByCommunityHospitalId(hosId);
				flagDuo=true;
				setIndexFlag(1);
			}else{
				page.setTotalNum(followRecordService.findChronicPeopleCount(searchbean,hosId));
				vfollowRecordList=followRecordService.findChronicPeople(searchbean, page, hosId);
				allDoctor=healthFileService.getAllDoctorByHosId(hosId);
				specialDoctor =healthFileService.getSpeciallDoctor(hosId);
				allEnterPeople=staffService.getAllOperator(hosId);
				staffs = staffService.getStaffByCommunityHospitalId(hosId);
			}
			this.pageHtml=page.getPage("entity");
			if(searchbean.getDanganzhuangtai()!=0){
				return "searchFollowRecordKill";
			}
			else{
				return "searchFollowRecord";
			}
		}
		else{
			return "error";
		}
		
	}
	public String showFollowRecord(){
		page = new Page<VFollowRecord>();
		page.setCurrentPage(cp);
		page.setPageSize(10);
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
		if(group!=null){//集团负责人登陆
			issq = 1;//0是平台管理员登陆，1是集团登陆，2是其他登陆
			hospitals = communityHospitalGroupService.getComHosListByGroup(group);
			page.setTotalNum(followRecordService.getFollowRecordCountForGroup(group.getGId()));
			this.pageHtml = page.getPage("followRecordAction!showFollowRecord.action");
			vfollowRecordList=followRecordService.getAllFollowRecordForGroup(page, group.getGId());
			flagPingTai = true;
			setIndexFlag(1);
			return "showFollowRecord";
		}
		if(session.getAttribute("comHospital")!=null){
			communityHospital = (TCommunityHospital) session.getAttribute("comHospital");
			//communityHospital=communityHospitalService.getCommunityHospitalById(hosId);
			//hosName=communityHospital.getCommunityHospital();
			if(communityHospital.getIsHead()==Admin_IsHead.guanliyuan.getValue()){
				//hospitals = communityHospitalService.getAllHospitals();
				groups = communityHospitalGroupService.getAllGroups();
				issq = 0;//0是平台管理员登陆，1是集团登陆，2是其他登陆 
				page.setTotalNum(followRecordService.getFollowRecordCount(state));
				this.pageHtml=page.getPage("followRecordAction!showFollowRecord.action");
				vfollowRecordList=followRecordService.getAllFollowRecord(page,state);
				allDoctor=healthFileService.getAllDoctorByHosId();
				allEnterPeople=staffService.getAllOperator();
				
				flagPingTai=true;
				setIndexFlag(1);
				return "showFollowRecord";
			}
			else {
				page.setTotalNum(followRecordService.getFollowRecordCount(communityHospital.getCommunityHospitalId(),state));
				this.pageHtml=page.getPage("followRecordAction!showFollowRecord.action");
				vfollowRecordList=followRecordService.getAllFollowRecord(page, communityHospital.getCommunityHospitalId(),state);
				allDoctor=healthFileService.getAllDoctorByHosId(communityHospital.getCommunityHospitalId());
				allEnterPeople=staffService.getAllOperator(communityHospital.getCommunityHospitalId());
				specialDoctor =healthFileService.getSpeciallDoctor(communityHospital.getCommunityHospitalId());
				staffs = staffService.getStaffByCommunityHospitalId(communityHospital.getCommunityHospitalId());
				flagPingTai=false;
				flagDuo=false;
				return "showFollowRecord";
			}
		}
		else if(session.getAttribute("tstaff")!=null){
			tstaff =  (TStaff) session.getAttribute("tstaff");
			hosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId());
			if(healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())){//判断员工是否为责任医生，若是，则只能看到所对应的老人
				page.setTotalNum(followRecordService.getFollowRecordCountForSpecial(tstaff.getStaffId(),state));
				vfollowRecordList=followRecordService.getAllFollowRecordForSpecial(page, tstaff.getStaffId(),state);
				allDoctor=healthFileService.getAllDoctorByHosId(hosId);
				allEnterPeople=staffService.getAllOperator(hosId);
				staffs = staffService.getStaffByCommunityHospitalId(hosId);
				flagDuo=true;
				setIndexFlag(1);
			}else{
				page.setTotalNum(followRecordService.getFollowRecordCount(hosId,state));
				vfollowRecordList=followRecordService.getAllFollowRecord(page, hosId,state);
				allDoctor=healthFileService.getAllDoctorByHosId(hosId);
				allEnterPeople=staffService.getAllOperator(hosId);
				specialDoctor =healthFileService.getSpeciallDoctor(hosId);
				staffs = staffService.getStaffByCommunityHospitalId(hosId);
			}
			this.pageHtml=page.getPage("followRecordAction!showFollowRecord.action");
			return "showFollowRecord";
		}
		else{
			return "error";
		}
		//HttpSession session = ServletActionContext.getRequest().getSession();
		//hosId = (int) session.getAttribute("hosId");
		/*page = new Page<VFollowRecord>();
		page.setCurrentPage(cp);
		page.setPageSize(10);
		page.setTotalNum(followRecordService.getFollowRecordCount(hosId));
		this.pageHtml=page.getPage("followRecordAction!showFollowRecord.action");
		vfollowRecordList=followRecordService.getAllFollowRecord(page, hosId);
		return "showFollowRecord";*/
	}
	/**
	 * 转到新增界面
	 * @return
	 */
	public String findAndAddFollowRecord(){
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
		/////////////////////////
		zg=maintainableAttributeService.getmEntriesByCode("16001");//转归
		zd=maintainableAttributeService.getmEntriesByCode("16002");//诊断
		zs=maintainableAttributeService.getmEntriesByCode("16004");//主诉
		clqk=maintainableAttributeService.getmEntriesByCode("16003");//处理情况
		///////////////////////////////////////
		conFlag=0;//初始状态
		return "findAndAddFollowRecord";
	}
	/**
	 * 新增记录时先精确查找老人（健康档案）
	 * @return
	 */
	public String findFollowRecord(){
		
		/////////////////////////
		zg=maintainableAttributeService.getmEntriesByCode("16001");//转归
		zd=maintainableAttributeService.getmEntriesByCode("16002");//诊断
		zs=maintainableAttributeService.getmEntriesByCode("16004");//主诉
		clqk=maintainableAttributeService.getmEntriesByCode("16003");//处理情况
		///////////////////////////////////////
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
					return "findAndAddFollowRecord";
				}
				else if(listolder.size()==1){
					int hid=listolder.get(0).getHealthFileId();
					healthFile=healthFileService.getHealthFileById(hid);
				}
				else if(listolder.size()>1){
					showwindow=true;
					conFlag=0;//不显示列表信息
					return "findAndAddFollowRecord";
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
						return "findAndAddFollowRecord";
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
					return "findAndAddFollowRecord";
				 }
				if(healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())){
					oldstaffhos=staffService.gethosByFileid(healthFile.getHealthFileId());
					//if(oldstaffhos.getTStaff().getStaffId()!=tstaff.getStaffId()){
					int test1=oldstaffhos.getTStaff().getStaffId();
					if(test1!=tstaff.getStaffId()){
						str="未找到该老人信息";
						conFlag=0;healthFile=null;
						return "findAndAddFollowRecord";
					}
				}
			}
			/////////
			conFlag=1;
			token = TokenProccessor.getInstance().makeToken();//创建令牌
			HttpServletRequest request=ServletActionContext.getRequest();
			request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
			return "findFollowRecord";
		}
		else {
			str="未找到该老人信息";
			conFlag=0;
			return "findAndAddFollowRecord";
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
		return "findFollowRecord";
	}
	/**
	 * 添加随诊记录
	 * @return
	 */
	public String addFollowRecord(){
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "DocDRedir";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		System.out.println(followRecord.getTime());
		healthFile=healthFileService.getHealthFileById(healthFileId);
		if(healthFile == null){
			str="未找到老人信息";
			return "followRecordError";
		}
		followRecord.setTHealthFile(healthFile);
		followRecordService.saveFollowRecord(followRecord);
		return "addFollowRecord";
	}
	
	
	
	
	public String turnToAddPersonFollowRecord(){
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
		 zg=maintainableAttributeService.getmEntriesByCode("16001");//转归
		 zd=maintainableAttributeService.getmEntriesByCode("16002");//诊断
	     zs=maintainableAttributeService.getmEntriesByCode("16004");//主诉
	     clqk=maintainableAttributeService.getmEntriesByCode("16003");//处理情况
		 ///////////////////////////////////////
		healthFile=healthFileService.getHealthFileById(healthFileId);
		return "turnToAddPersonFollowRecord";
	}
	
	
	
	
	
	public String turnToDetailFollowRecord(){
		if(healthFileService.getHealthFileById(healthFileId)==null||followRecordService.getFollowRecordByFollowId(followId)==null){
			return "error";
		}
		healthFile=healthFileService.getHealthFileById(healthFileId);
		followRecord=followRecordService.getFollowRecordByFollowId(followId);
		//////////////////////////////////////////////////
		if(followRecord.getTHealthFile().getHealthFileId()!=healthFileId){
			return "error";
		}
		//////////////////////////////////////////////
		return "turnToDetailFollowRecord";
	}
	
	
	
	
	
	
	public String deleteFollowRecord(){
		////////////////////////////////////
		followRecord=followRecordService.getFollowRecordByFollowId(followId);
		if(followRecord==null){
			return "error";
		}
		healthFileId=followRecord.getTHealthFile().getHealthFileId();
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
		followRecordService.deleteFollowRecord(followId);
		return "deleteFollowRecord";
	}
	
	
	
	
	
	
	/*public String deleteFollowRecordList(){
		followRecordService.deleteFollowRecord(deleteList);
	}*/
	public String updateFollowRecord(){
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "DocDRedir";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		healthFile=healthFileService.getHealthFileById(healthFileId);
		followRecord.setTHealthFile(healthFile);
		followRecordService.updateFollowRecord(followRecord);
		return "updateFollowRecord";
	}
	public String turnToUpdateFollowRecord(){
		token = TokenProccessor.getInstance().makeToken();//创建令牌
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
		/////////////////////////////////
		if(healthFileService.getHealthFileById(healthFileId)==null||followRecordService.getFollowRecordByFollowId(followId)==null){
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
		followRecord=followRecordService.getFollowRecordByFollowId(followId);
		//////////////////////////////////////
		if(followRecord.getTHealthFile().getHealthFileId()!=healthFileId){
			return "error";
		}
		///////////////////////////////////////
		/////////////////////////
		zg=maintainableAttributeService.getmEntriesByCode("16001");//转归
		zd=maintainableAttributeService.getmEntriesByCode("16002");//诊断
		zs=maintainableAttributeService.getmEntriesByCode("16004");//主诉
		clqk=maintainableAttributeService.getmEntriesByCode("16003");//处理情况
		///////////////////////////////////////
		return "turnToUpdateFollowRecord";
	}
	public String deleteMoreFollowRecord(){
		followRecordService.deleteFollowRecord(allFollowRecordId);
		return "deleteMoreFollowRecord";
	}
	
	
	
	
	public List<VFollowRecord> getVfollowRecordList() {
		return vfollowRecordList;
	}
	public void setVfollowRecordList(List<VFollowRecord> vfollowRecordList) {
		this.vfollowRecordList = vfollowRecordList;
	}
	public TFollowRecord getFollowRecord() {
		return followRecord;
	}
	public void setFollowRecord(TFollowRecord followRecord) {
		this.followRecord = followRecord;
	}
	public Page<VFollowRecord> getPage() {
		return page;
	}
	public void setPage(Page<VFollowRecord> page) {
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
	public int getFollowId() {
		return followId;
	}
	public void setFollowId(int followId) {
		this.followId = followId;
	}
	public int[] getChoice() {
		return choice;
	}
	public void setChoice(int[] choice) {
		this.choice = choice;
	}
	public List<Object> getAllFollowRecordId() {
		return allFollowRecordId;
	}
	public void setAllFollowRecordId(List<Object> allFollowRecordId) {
		this.allFollowRecordId = allFollowRecordId;
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
	public List<VStaffHos> getAllDoctor() {
		return allDoctor;
	}
	public void setAllDoctor(List<VStaffHos> allDoctor) {
		this.allDoctor = allDoctor;
	}
	///////////////////////////////////////////////////////////////////////
	private List<TMaintainableEntry> zg;//转归
	private List<TMaintainableEntry> zd;//诊断
	private List<TMaintainableEntry> clqk;//处理情况
	private List<TMaintainableEntry> zs;//主诉
	////////////////////////////////////////////////////////////////////////////
	public List<TMaintainableEntry> getZg() {
		return zg;
	}
	public void setZg(List<TMaintainableEntry> zg) {
		this.zg = zg;
	}
	public List<TMaintainableEntry> getZd() {
		return zd;
	}
	public void setZd(List<TMaintainableEntry> zd) {
		this.zd = zd;
	}
	public List<TMaintainableEntry> getClqk() {
		return clqk;
	}
	public void setClqk(List<TMaintainableEntry> clqk) {
		this.clqk = clqk;
	}
	public List<TMaintainableEntry> getZs() {
		return zs;
	}
	public void setZs(List<TMaintainableEntry> zs) {
		this.zs = zs;
	}
	
	public SearchBeanSU getSearchbean() {
		return searchbean;
	}
	public void setSearchbean(SearchBeanSU searchbean) {
		this.searchbean = searchbean;
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
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public int getConFlag() {
		return conFlag;
	}


	public void setConFlag(int conFlag) {
		this.conFlag = conFlag;
	}


	public VFollowRecord getVfollowRecord() {
		return vfollowRecord;
	}


	public void setVfollowRecord(VFollowRecord vfollowRecord) {
		this.vfollowRecord = vfollowRecord;
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


	public int getIndexFlag() {
		return indexFlag;
	}


	public void setIndexFlag(int indexFlag) {
		this.indexFlag = indexFlag;
	}


	public List<TCommunityHospitalGroup> getGroups() {
		return groups;
	}


	public void setGroups(List<TCommunityHospitalGroup> groups) {
		this.groups = groups;
	}

	
}
