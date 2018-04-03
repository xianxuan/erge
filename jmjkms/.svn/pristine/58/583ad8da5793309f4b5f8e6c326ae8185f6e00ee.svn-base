package com.jmjk.action;

import java.util.ArrayList;
import java.util.List;

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
import com.jmjk.entity.TStaff;
import com.jmjk.entity.view.VHealthStaff;
import com.jmjk.entity.view.VOldStaff;
import com.jmjk.entity.view.VStaffHos;
import com.jmjk.enums.Admin_IsHead;
import com.jmjk.enums.HealthFileCheck;
import com.jmjk.iservice.ICommunityHospitalGroupService;
import com.jmjk.iservice.IHealthFileService;
import com.jmjk.iservice.IHealthManagerService;
import com.jmjk.pojo.HealthFileCloud;
import com.jmjk.service.CommunityHospitalService;
import com.jmjk.service.StaffService;
import com.jmjk.utils.GetSessionPerson;
import com.jmjk.utils.Page;
import com.jmjk.utils.SearchBean;
import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * @author 张晓光 2016-8-27
 */
@Component
@Scope("prototype")
@Action(value = "HealthDailyCheckAction", results = {
		@Result(name = "getHealthFileList", location = "/jsp/healthManager/healthFilelist.jsp"),
		@Result(name = "DataMonitorFileList", location = "/jsp/healthManager/healthFilelist.jsp"),
		@Result(name = "groupSuggestFileList", location = "/jsp/healthManager/groupHealthFilelist.jsp"),
		})
public class HealthDailyCheckAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<VOldStaff> vOldStaffs;
	@Autowired
	private StaffService staffService;
	@Autowired
	private IHealthFileService healthFileService;
	@Autowired
	private IHealthManagerService healthManagerService;
	@Autowired
	private CommunityHospitalService communityHospitalService;//管理员表
	@Autowired
	private ICommunityHospitalGroupService communityHospitalGroupService;
	private int cp = 1;
	private String pageHtml;
	private SearchBean searchbean ;
	private List<TStaff> staffs;//员工表集合
    private List<TStaff> zrstaffs;
	private boolean flag =false;
	private TStaff tuser;
	private int sqid;
	private boolean issetsearch;
	private int[] chlist=null;//用于多条件查询的慢病种类回显
	private Page<VOldStaff> page;
	private List<TCommunityHospital> hospitals;//所有社区医院
	//private boolean issq = false;//判断是否是平台管理员的状态量，用于是否显示社区医院搜索医院选项
	private int issq = 2;// 判断是否是平台管理员的状态量，用于是否显示社区医院搜索医院选项
	private List<TStaff> specialDoctor;
	public List<HealthFileCloud.Page.HealthFile> healthFileCloudList;
	private List<VHealthStaff> vhealthStaffList;
	private List<THealthFile> healthFiles;

	private List<TCommunityHospitalGroup> groups; 
	private List<THealthFile> healthFileList;
	private List<VStaffHos> allDoctor;
	private boolean flagPingTai = false;
	private List<VStaffHos> allEnterPeople;
	private int indexFlag=0;
	
	
	/**
	 *  LaiQingFa
	 * 判断当前登录用户
	 * @return
	 */
	public int getNowSqid(){	

    	//从session里拿到当前登录用户的id
    	int userId = GetSessionPerson.getPerson();

		//user大于0,员工id
		if (userId>0) {
			 sqid = staffService.getCommHospitalByStaffId(userId);
		//user小于0,社区负责人id;等于0,平台admin
		}else if (userId<0 || userId ==0) {
			 sqid = Math.abs(userId);
		}

		return sqid;
	}
	
	/**
	 * 查询默认的页面的老人档案列表，进入日常监测首页
	 * 
	 * @return
	 */
	/*public String getHealthFileList() {
		
		int userId = -1;
		Page<HealthFileCloud.Page.HealthFile> page = new Page<HealthFileCloud.Page.HealthFile>();
		page.setCurrentPage(cp);
	    this.pageHtml = page.getPage("HealthManagerAction!getHealthFileList.action");
		//责任医生
		TStaff tStaff = (TStaff) ActionContext.getContext().getSession().get("tstaff");
		//社区负责人
		TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext.getContext().getSession().get("comHospital");
		//社区集团负责人
		TCommunityHospitalGroup tCommunityHospitalGroup = (TCommunityHospitalGroup) ActionContext.getContext().getSession().get("communityHospitalGroup");
		if(tStaff != null){
			userId = tStaff.getStaffId();
			userId = 1; //测试专用，运行阶段删除
			HealthFileCloud healthFileCloud = (HealthFileCloud) ActionContext.getContext().getSession().get("healthFileCloudDoc");
			if(healthFileCloud == null){
				healthFileCloud = getHealthFilePageInfoByDoctor(userId);
				if(healthFileCloud.getPage() != null){
					ActionContext.getContext().getSession().put("healthFileCloudDoc", healthFileCloud);
				}
			}
			if(healthFileCloud.getPage() != null){
				page.setPageSize(healthFileCloud.getPage().getPageSize());
				page.setTotal(healthFileCloud.getPage().getTotal());
				String resultJson = healthManagerService.getHealthFileFromCloudByDoctor(userId, page.getCurrentPage(), page.getPageSize());
				healthFileCloud = JSON.parseObject(resultJson,HealthFileCloud.class);
				healthFileCloudList = healthFileCloud.getPage().getResult();
			}
		}else if(tCommunityHospital != null){
			userId = tCommunityHospital.getCommunityHospitalId();
			HealthFileCloud healthFileCloud = (HealthFileCloud) ActionContext.getContext().getSession().get("healthFileCloudHos");
			if(healthFileCloud == null){
				healthFileCloud = getHealthFilePageInfoByHos(userId);
				if(healthFileCloud.getPage() != null){
					ActionContext.getContext().getSession().put("healthFileCloudHos", healthFileCloud);
				}
			}
			if(healthFileCloud.getPage() != null){
				page.setPageSize(healthFileCloud.getPage().getPageSize());
				page.setTotal(healthFileCloud.getPage().getTotal());
				String resultJson = healthManagerService.getHealthFileFromCloudByHos(userId, page.getCurrentPage(), page.getPageSize());
				healthFileCloud = JSON.parseObject(resultJson,HealthFileCloud.class);
				healthFileCloudList = healthFileCloud.getPage().getResult();
			}
		}else if(tCommunityHospitalGroup != null){
           
			Page<THealthFile> page1 = new Page<THealthFile>();
			page1.setCurrentPage(cp);
			page1.setTotalNum(healthFileService.getHealthFileCountForGroup(tCommunityHospitalGroup.getGId()));
			this.pageHtml = page.getPage("HealthManagerAction!getHealthFileList.action");
			vhealthStaffList=healthFileService.getAllHealthFileForGroup(page1, tCommunityHospitalGroup.getGId(), 2);
			healthFiles = new ArrayList<THealthFile>();
			if (vhealthStaffList.size() > 0) {
				for (int i = 0; i < vhealthStaffList.size(); i++) {
					healthFiles
							.add(healthFileService.getHealthFileById(vhealthStaffList.get(i).getHealthFileId()));
				}
			}
			return "groupSuggestFileList";
			
		}
		return "getHealthFileList";
	}
	*/
public String getHealthFileList() {
		
		int userId = -1;
		//员工
		TStaff tStaff = (TStaff) ActionContext.getContext().getSession().get("tstaff");
		//社区负责人
		TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext.getContext().getSession().get("comHospital");
		//社区集团负责人
		//TCommunityHospitalGroup tCommunityHospitalGroup = (TCommunityHospitalGroup) ActionContext.getContext().getSession().get("communityHospitalGroup");
		if(tStaff != null){
			int hosId = staffService.getCommHospitalByStaffId(tStaff.getStaffId());
			TCommunityHospital communityHospital = communityHospitalService.getCommunityHospitalById(hosId);
			allDoctor = healthFileService.getAllDoctorByHosId(hosId);
			allEnterPeople = staffService.getAllOperator(hosId);
			staffs = staffService.getStaffByCommunityHospitalId(hosId);
			//责任医生
			if(healthFileService.getOldStaffHosByStaffId(tStaff.getStaffId())){ 
			indexFlag=1;
			flag = true;	
			userId = tStaff.getStaffId();
			//userId = 1; //测试专用，运行阶段删除
			HealthFileCloud healthFileCloud = (HealthFileCloud) ActionContext.getContext().getSession().get("healthFileCloudDoc");
			Page<HealthFileCloud.Page.HealthFile> page = new Page<HealthFileCloud.Page.HealthFile>();
			page.setCurrentPage(cp);
			if(healthFileCloud == null){
				healthFileCloud = getHealthFilePageInfoByDoctor(userId);
				if(healthFileCloud.getPage() != null){
					ActionContext.getContext().getSession().put("healthFileCloudDoc", healthFileCloud);
				}
			}
			if(healthFileCloud.getPage() != null){
				String resultJson = healthManagerService.getHealthFileFromCloudByDoctor(userId, page.getCurrentPage(), page.getPageSize());
				healthFileCloud = JSON.parseObject(resultJson,HealthFileCloud.class);
				healthFileCloudList = healthFileCloud.getPage().getResult();           //得到老人集合
				page.setPageSize(healthFileCloud.getPage().getPageSize());
				page.setTotalNum(healthFileCloud.getPage().getTotal());
			}
			this.pageHtml = page.getPage("HealthDailyCheckAction!getHealthFileList.action");
			return "getHealthFileList";
		}
		else{
			//一般员工 
			Page<THealthFile> page0 = new Page<THealthFile>();
			page0.setCurrentPage(cp);
			communityHospital = communityHospitalService.getCommunityHospitalById(hosId);
			page0.setTotalNum(healthFileService.getHealthFileCount(communityHospital.getCommunityHospital()));
			String hosname=communityHospital.getCommunityHospital();
			healthFileList = healthFileService.getAllHealthFile(page0, HealthFileCheck.zhengchang.getValue(),hosname);	
			this.pageHtml = page.getPage("HealthDailyCheckAction!getHealthFileList.action");
			return "groupSuggestFileList";  //非责任医生、社区负责人所看页面
		}
	  }
		//获得医院表里的平台管理员和社区负责人
		else if(tCommunityHospital != null){
			if (tCommunityHospital.getIsHead() == Admin_IsHead.guanliyuan.getValue()) {
				groups = communityHospitalGroupService.getAllGroups();
				//hospitals = communityHospitalService.getAllHospitals();
				issq = 0;//0是平台管理员登陆，1是集团登陆，2是其他登陆
				Page<THealthFile> page2=new Page<THealthFile>(); 
				page2.setTotalNum(healthFileService.getHealthFileCount());
				healthFileList = healthFileService.getAllHealthFile(page2,HealthFileCheck.zhengchang.getValue());//得到档案正常的所有老人
				allDoctor = healthFileService.getAllDoctorByHosId();
				allEnterPeople = staffService.getAllOperator();
				staffs = staffService.getStaffByCommunityHospitalId(tCommunityHospital.getCommunityHospitalId());
				flagPingTai = true;
				indexFlag=1;
				this.pageHtml = page2.getPage("HealthDailyCheckAction!getHealthFileList.action");
				return "groupSuggestFileList";  //非责任医生、社区负责人所看页面
			} 
			//社区负责人
			else {
			userId = tCommunityHospital.getCommunityHospitalId();
			//str = communityHospital.getName();
			//hosName = communityHospital.getCommunityHospital();
			allDoctor = healthFileService.getAllDoctorByHosId(tCommunityHospital.getCommunityHospitalId());
			specialDoctor =healthFileService.getSpeciallDoctor(tCommunityHospital.getCommunityHospitalId());
			allEnterPeople = staffService.getAllOperator(tCommunityHospital.getCommunityHospitalId());
			staffs = staffService.getStaffByCommunityHospitalId(tCommunityHospital.getCommunityHospitalId());
			//获取中心服务器下所有社区老人
			HealthFileCloud healthFileCloud = (HealthFileCloud) ActionContext.getContext().getSession().get("healthFileCloudHos");
			Page<HealthFileCloud.Page.HealthFile> page = new Page<HealthFileCloud.Page.HealthFile>();
			page.setCurrentPage(cp);
			if(healthFileCloud == null){
				healthFileCloud = getHealthFilePageInfoByHos(userId);
				if(healthFileCloud.getPage() != null){
					ActionContext.getContext().getSession().put("healthFileCloudHos", healthFileCloud);
				}
			}
			if(healthFileCloud.getPage() != null){
				String resultJson = healthManagerService.getHealthFileFromCloudByHos(userId, page.getCurrentPage(), page.getPageSize());
				healthFileCloud = JSON.parseObject(resultJson,HealthFileCloud.class);
				healthFileCloudList = healthFileCloud.getPage().getResult();
				page.setPageSize(healthFileCloud.getPage().getPageSize());
				page.setTotalNum(healthFileCloud.getPage().getTotal());
			}
			this.pageHtml = page.getPage("HealthDailyCheckAction!getHealthFileList.action");
			return "getHealthFileList";
		 }
		}
		/*//集团
		else if(tCommunityHospitalGroup != null){
			issq = 1;//0是平台管理员登陆，1是集团登陆，2是其他登陆
			hospitals = communityHospitalGroupService.getComHosListByGroup(tCommunityHospitalGroup);
			Page<THealthFile> page1 = new Page<THealthFile>();
			page1.setCurrentPage(cp);
			page1.setTotalNum(healthFileService.getHealthFileCountForGroup(tCommunityHospitalGroup.getGId()));
			vhealthStaffList=healthFileService.getAllHealthFileForGroup(page1, tCommunityHospitalGroup.getGId(), 2);
			healthFileList = new ArrayList<THealthFile>();
			if (vhealthStaffList.size() > 0) {
				for (int i = 0; i < vhealthStaffList.size(); i++) {
					healthFileList
							.add(healthFileService.getHealthFileById(vhealthStaffList.get(i).getHealthFileId()));
				}
			}
			flagPingTai = true;
			indexFlag=1;
			this.pageHtml = page1.getPage("HealthDailyCheckAction!getHealthFileList.action");
			return "groupSuggestFileList";
			
		}*/
		return "getHealthFileList";
	}
	

       //---------------------------新增在健康建议下的血压、血氧、血糖数据分析页面












































	/**
	 * 获取责任医生可以查询的健康档案的分页信息
	 * @param doctorId
	 * @return
	 */
	public HealthFileCloud getHealthFilePageInfoByDoctor(int doctorId){
		
		String resultJson = healthManagerService.getHealthFileFromCloudByDoctor(doctorId, 1, 10);
		return JSON.parseObject(resultJson,HealthFileCloud.class);
	}
	/**
	 * 获取社区医院可以查询的健康档案的分页信息
	 * @param hosId
	 * @return
	 */
	public HealthFileCloud getHealthFilePageInfoByHos(int hosId){
		String resultJson = healthManagerService.getHealthFileFromCloudByHos(hosId, 1, 10);
		return JSON.parseObject(resultJson,HealthFileCloud.class);
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

	public List<VOldStaff> getVOldStaffs() {
		return vOldStaffs;
	}

	public void setVOldStaffs(List<VOldStaff> vOldStaffs) {
		this.vOldStaffs = vOldStaffs;
	}
	public List<VOldStaff> getvOldStaffs() {
		return vOldStaffs;
	}
	public void setvOldStaffs(List<VOldStaff> vOldStaffs) {
		this.vOldStaffs = vOldStaffs;
	}
	public StaffService getStaffService() {
		return staffService;
	}
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	public IHealthFileService getHealthFileService() {
		return healthFileService;
	}
	public void setHealthFileService(IHealthFileService healthFileService) {
		this.healthFileService = healthFileService;
	}
	
	public SearchBean getSearchbean() {
		return searchbean;
	}
	public void setSearchbean(SearchBean searchbean) {
		this.searchbean = searchbean;
	}
	public List<TStaff> getStaffs() {
		return staffs;
	}
	public void setStaffs(List<TStaff> staffs) {
		this.staffs = staffs;
	}
	public List<TStaff> getZrstaffs() {
		return zrstaffs;
	}
	public void setZrstaffs(List<TStaff> zrstaffs) {
		this.zrstaffs = zrstaffs;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public TStaff getTuser() {
		return tuser;
	}
	public void setTuser(TStaff tuser) {
		this.tuser = tuser;
	}
	public int getSqid() {
		return sqid;
	}
	public void setSqid(int sqid) {
		this.sqid = sqid;
	}
	public boolean isIssetsearch() {
		return issetsearch;
	}
	public void setIssetsearch(boolean issetsearch) {
		this.issetsearch = issetsearch;
	}
	public int[] getChlist() {
		return chlist;
	}
	public void setChlist(int[] chlist) {
		this.chlist = chlist;
	}
	public Page<VOldStaff> getPage() {
		return page;
	}
	public void setPage(Page<VOldStaff> page) {
		this.page = page;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public List<TCommunityHospital> getHospitals() {
		return hospitals;
	}
	public void setHospitals(List<TCommunityHospital> hospitals) {
		this.hospitals = hospitals;
	}
	public int isIssq() {
		return issq;
	}
	public void setIssq(int issq) {
		this.issq = issq;
	}
	public List<TStaff> getSpecialDoctor() {
		return specialDoctor;
	}
	public void setSpecialDoctor(List<TStaff> specialDoctor) {
		this.specialDoctor = specialDoctor;
	}
	public List<HealthFileCloud.Page.HealthFile> getHealthFileCloudList() {
		return healthFileCloudList;
	}
	public void setHealthFileCloudList(List<HealthFileCloud.Page.HealthFile> healthFileCloudList) {
		this.healthFileCloudList = healthFileCloudList;
	}
	public List<VHealthStaff> getVhealthStaffList() {
		return vhealthStaffList;
	}
	public void setVhealthStaffList(List<VHealthStaff> vhealthStaffList) {
		this.vhealthStaffList = vhealthStaffList;
	}
	public List<THealthFile> getHealthFiles() {
		return healthFiles;
	}
	public void setHealthFiles(List<THealthFile> healthFiles) {
		this.healthFiles = healthFiles;
	}
	public CommunityHospitalService getCommunityHospitalService() {
		return communityHospitalService;
	}
	public void setCommunityHospitalService(
			CommunityHospitalService communityHospitalService) {
		this.communityHospitalService = communityHospitalService;
	}
	public List<TCommunityHospitalGroup> getGroups() {
		return groups;
	}
	public void setGroups(List<TCommunityHospitalGroup> groups) {
		this.groups = groups;
	}
	public List<VStaffHos> getAllDoctor() {
		return allDoctor;
	}
	public void setAllDoctor(List<VStaffHos> allDoctor) {
		this.allDoctor = allDoctor;
	}
	public boolean isFlagPingTai() {
		return flagPingTai;
	}
	public void setFlagPingTai(boolean flagPingTai) {
		this.flagPingTai = flagPingTai;
	}
	public List<VStaffHos> getAllEnterPeople() {
		return allEnterPeople;
	}
	public void setAllEnterPeople(List<VStaffHos> allEnterPeople) {
		this.allEnterPeople = allEnterPeople;
	}
	public int getIndexFlag() {
		return indexFlag;
	}
	public void setIndexFlag(int indexFlag) {
		this.indexFlag = indexFlag;
	}
	public void setHealthFileList(List<THealthFile> healthFileList) {
		this.healthFileList = healthFileList;
	}
}
