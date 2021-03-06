package com.jmjk.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletOutputStream;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jmjk.action.base.BaseAction;
import com.jmjk.entity.TChronicDisease;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.THealthFile;
import com.jmjk.entity.TRecoveryOld;
import com.jmjk.entity.TRecoveryPlan;
import com.jmjk.entity.TRecoveryScheme;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.view.VChronic;
import com.jmjk.entity.view.VStaffHos;
import com.jmjk.enums.Admin_IsHead;
import com.jmjk.enums.CHRONIC_MANAGER;
import com.jmjk.enums.HealthFileCheck;
import com.jmjk.enums.IS_DELETE;
import com.jmjk.enums.RecoveryPlanStatus;
import com.jmjk.iservice.ICommunityHospitalService;
import com.jmjk.export.DiabeteExport;
import com.jmjk.export.highBloodExport;
import com.jmjk.iservice.IHealthManagerService;
import com.jmjk.iservice.IRecoverySchemeService;
import com.jmjk.pojo.BloodPress;
import com.jmjk.pojo.BloodPressCloud;
import com.jmjk.pojo.BloodSuger;
import com.jmjk.pojo.BloodSugerCloud;
import com.jmjk.service.AllChronicDiseaseService;
import com.jmjk.service.CommunityHospitalGroupService;
import com.jmjk.service.HealthFileService;
import com.jmjk.service.OldStaffHosService;
import com.jmjk.service.RecoveryPlanService;
import com.jmjk.service.StaffService;
import com.jmjk.utils.GetSessionPerson;
import com.jmjk.utils.JxlExcel;
import com.jmjk.utils.Page;
import com.jmjk.utils.Resubmit;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.TokenProccessor;
import com.jmjk.utils.TypeConverter;
import com.opensymphony.xwork2.ActionContext;
@Component
@Scope("prototype")
@Action(value="chronicManagerAction",results={
		@Result(name="allDiabeteManager",location="/jsp/ChronicManager/DiabeteManager/diabeteManager.jsp"),
		@Result(name="addDiabeteManager",location="/jsp/ChronicManager/DiabeteManager/addOldDiabeteManager.jsp"),
		@Result(name="allHighBloodManager",location="/jsp/ChronicManager/HighBloodManager/highBloodManager.jsp"),
		@Result(name="addHighManager",location="/jsp/ChronicManager/HighBloodManager/addOldHighManager.jsp"),
		@Result(name="otherManager",location="/jsp/ChronicManager/OtherChronicManager/otherChronicManager.jsp"),
		@Result(name="addOtherManager",location="/jsp/ChronicManager/OtherChronicManager/addOldOtherManager.jsp"),
		@Result(name="deleteDiabeteDir",type="redirectAction",location="chronicManagerAction!getAllDiabeteManager.action"),
		@Result(name="deleteHighDir",type="redirectAction",location="chronicManagerAction!getAllHighBloodManager.action"),
		@Result(name="deleteOtherDir",type="redirectAction",location="chronicManagerAction!getAllOtherManager.action"),		
		@Result(name= "gxy",location="/jsp/ChronicManager/HighBloodManager/showHighBloodFile.jsp"),
		@Result(name= "tnb",location="/jsp/ChronicManager/DiabeteManager/showDiabeteFile.jsp"),
		@Result(name= "zhongliu",location="/jsp/ChronicManager/OtherChronicManager/tumourMessage.jsp"),
		@Result(name= "xnxgb",location="/jsp/ChronicManager/OtherChronicManager/HCVDMessage.jsp"),
		@Result(name= "gxb",location="/jsp/ChronicManager/OtherChronicManager/coronaryHeartDiseaseMessage.jsp"),
		@Result(name= "cjza",location="/jsp/ChronicManager/OtherChronicManager/disabilityMessage.jsp"),
		@Result(name= "zxjsjb",location="/jsp/ChronicManager/OtherChronicManager/severeMentalIllnessMessage.jsp"),
		@Result(name= "mxzqgb",location="/jsp/ChronicManager/OtherChronicManager/chronicBronchialMessage.jsp"),
		//慢病康复计划添加跳转页
		@Result(name="tnbToAdd",location="/jsp/ChronicManager/RecoveryPlan/diabeteRecoveryPlan/addRecovery.jsp"),
		@Result(name="gxyToAdd",location="/jsp/ChronicManager/RecoveryPlan/highBloodRecoveryPlan/addRecovery.jsp"),
		@Result(name="toAddRed",type="redirectAction",location="chronicManagerAction!addRecoveryPlan.action",params={"chronicId","${chronicId}"}),
		//@Result(name = "changePlanStatus", location = "chronicManagerAction!searchBloodPressRecoverPlan.action", type = "redirectAction",params={
				//"chronicId", "${chronicId}"}),
				
		
		
		@Result(name="otherToAdd",location="/jsp/ChronicManager/RecoveryPlan/otherRecoveryPlan/addRecovery.jsp"),
		//慢病康复计划首页
		@Result(name="tnbShowPlan",location="/jsp/ChronicManager/RecoveryPlan/diabeteRecoveryPlan/showRecovery.jsp"),
		@Result(name="gxyShowPlan",location="/jsp/ChronicManager/RecoveryPlan/highBloodRecoveryPlan/showRecovery.jsp"),
		@Result(name="otherShowPlan",location="/jsp/ChronicManager/RecoveryPlan/otherRecoveryPlan/showRecovery.jsp"),
		//重定向回该慢病康复计划首页
		@Result(name="planRed",type="redirectAction",location="chronicManagerAction!searchRecoveryPlan.action",params={"chronicId","${chronicId}"}),
		//康复计划详情
		@Result(name="tnbPlanToInfo",location="/jsp/ChronicManager/RecoveryPlan/diabeteRecoveryPlan/infoRecoveryPlan.jsp"),
		@Result(name="gxyPlanToInfo",location="/jsp/ChronicManager/RecoveryPlan/highBloodRecoveryPlan/infoRecoveryPlan.jsp"),
		@Result(name="otherPlanToInfo",location="/jsp/ChronicManager/RecoveryPlan/otherRecoveryPlan/infoRecoveryPlan.jsp"),
		@Result(name="error",location="/error.jsp"),
	//血压管理详情	
		@Result(name ="bloodPressDataAnalysis" , location ="/jsp/ChronicManager/HighBloodManager/bloodPressManageDateAnalysis.jsp"),
		//@Result(name ="bloodPressTendAnalysisi" , location ="/jsp/ChronicManager/HighBloodManager/bloodPressManageTendAnalysisi.jsp"),
		@Result(name = "bloodPressTendAnalysisi", location ="/jsp/ChronicManager/HighBloodManager/bloodPressManageTendAnalysisi.jsp"),
		@Result(name ="bloodPressDataDetail" , location ="/jsp/ChronicManager/HighBloodManager/bloodPressManageDateDetail.jsp"),
		@Result(name ="getBloodPressFromCloud0" , location ="/jsp/ChronicManager/HighBloodManager/bloodPressManageDateAnalysis.jsp"),
		@Result(name ="getBloodPressFromCloud1" , location ="/jsp/ChronicManager/HighBloodManager/bloodPressManageTendAnalysisi.jsp"),
		@Result(name ="getBloodPressFromCloud2" , location ="/jsp/ChronicManager/HighBloodManager/bloodPressManageDateDetail.jsp"),
		@Result(name = "bloodPressDataDetailRed", type = "redirectAction", location = "chronicManagerAction!getBloodPressFromCloud.action", params = {
				"healthFileId", "${healthFileId}", "bloodForward", "2" }),
		@Result(name ="deleteBloodPressDataCloud" ,type="redirectAction", location ="chronicManagerAction!bloodPressDateDetail.action",params={"healthFileId","${healthFileId}","message","${message}"}),
		@Result(name ="toEditBPCloud" , location ="/jsp/ChronicManager/HighBloodManager/editBloodPress.jsp"),
		@Result(name ="editBPCloud" ,type="redirectAction", location ="chronicManagerAction!bloodPressDataDetail.action",params={"healthFileId","${healthFileId}","message","${message}"}),
	//血糖管理详情	
		@Result(name ="getBloodSugerFromCloud0" , location ="/jsp/ChronicManager/DiabeteManager/diabetDateAnalysis.jsp"),
		@Result(name ="getBloodSugerFromCloud1" , location ="/jsp/ChronicManager/DiabeteManager/diabetTendAnalysis.jsp"),
		@Result(name ="getBloodSugerFromCloud2" , location ="/jsp/ChronicManager/DiabeteManager/diabetDateDetail.jsp"),
		@Result(name ="bloodSugerDataAnalysis" , location ="/jsp/ChronicManager/DiabeteManager/diabetDateAnalysis.jsp"),
		@Result(name ="deleteBloodSugerDataCloud" ,type="redirectAction",location ="chronicManagerAction!bloodSugerDataDetail.action",params={"healthFileId","${healthFileId}","message","${message}"}),
		@Result(name ="bloodSugerTendAnalysis" , location ="/jsp/ChronicManager/DiabeteManager/diabetTendAnalysis.jsp"),
		@Result(name ="bloodSugerDataDetail" , location ="/jsp/ChronicManager/DiabeteManager/diabetDateDetail.jsp"),
		@Result(name ="toEditBSCloud" , location ="/jsp/ChronicManager/DiabeteManager/editBloodSuger.jsp"),
		@Result(name ="editBSCloud" ,type="redirectAction",location ="chronicManagerAction!bloodSugerDataDetail.action",params={"healthFileId","${healthFileId}","message","${message}"}),
		@Result(name = "bloodSugerDataDetailRed", type = "redirectAction", location = "chronicManagerAction!getBloodSugerFromCloud.action", params = {
				"healthFileId", "${healthFileId}", "bloodForward", "2" }),
		
		//糖尿病多条件查询
		@Result(name ="DataGetFileList" , location ="/jsp/ChronicManager/DiabeteManager/diabeteManager.jsp"),
})
public class ChronicManagerAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AllChronicDiseaseService chronicDiseaseService;
	@Autowired
	private HealthFileService healthFileService;
	@Autowired
	private RecoveryPlanService recoveryPlanService;
	@Autowired
	private IHealthManagerService healthManagerService;
	@Autowired
	private ICommunityHospitalService communityHospitalService;
	@Autowired
	private IRecoverySchemeService recoverySchemeService;
	@Autowired
	private StaffService staffService;
	@Autowired
	private OldStaffHosService oldStaffHosService;
	@Autowired
	private CommunityHospitalGroupService communityHospitalGroupService;
	private List<VChronic> vcdiabeteList;    //筛选糖尿病老人
	
	private List<VChronic> vchighbloodList;  //
	private List<VChronic> otherChroniclList; //
	private List<VChronic> vcnodiabeteList;
	private List<VChronic> vcnoHighList;
	private List<VChronic> vcnoOtherList;
	
	private List<BloodPress> bloodPresseList=new ArrayList<BloodPress>();
	private List<BloodSuger> bloodSugerList=new ArrayList<BloodSuger>();
	private BloodPressCloud bloodPressCloud;
	private BloodSugerCloud bloodSugerCloud;
	private List<BloodPress> bloodPresses=new ArrayList<BloodPress>();
	private List<TChronicDisease> noManagetList; //没有管理的老人
	private List<VChronic> vclist;        		//所有慢病老人
	private BloodPress bloodPress;
	private List<TRecoveryPlan> planList;    
	private String fileNum;					//档案编号
	private String chronicName;             //疾病名称
	private int cp=1;                       //当前页
	private int daId;                       //档案id
	private List<Object> oldids;           //批量添加老人至慢病管理
	private int chronicId;                 //慢病中慢病主键chronicDiseaseId
	private VChronic vchronic;             //慢病详情实体
	private String  schemeString;          //编辑康复计划时用到的名称
	private String planName;
	private int planState=-1;
	private TRecoveryPlan recoveryPlan;
	private int planId;
	private int recoveryPlanId;
	private TRecoveryPlan plan;            //康复计划实体保存
	private List<TRecoveryPlan> recoveryPlanList; //康复计划实体集合
	private List<TRecoveryOld> recoveryOldList;
	private TRecoveryScheme trecoveryScheme;
	private String jsons;
	private String cname;
	
	

	private TCommunityHospital communityHospital;
	private TStaff tstaff;
	
	public int select;//前台所选员工Id
	private int scheme;
	private List<TRecoveryScheme> schemeList;
	
	private String data;//康复计划多级联动的疾病参数 疾病名称
	private String type;//康复计划多级联动的方案类型
	private String json;
	private String jsonString;
	private List<VStaffHos> staffHosList;
	
	private THealthFile healthFile;
	private String pageHtml;
	private String xAxis;
	private String yAxisHigh;
    private String yAxisLow;
    private String yAxisPulse;
	
	private String appUserID;
	private int id;
	private int meaState;
	private Double diaPre;
	private Double sysPre;
	private Integer pulse;
	private int arm;
	private String appKey;
	private String  meaTime;
	private Date meatime;
	private int devID;
	private int takeMed;
	private String medName;
	private double bloodSugar;
    private String abnAlarm;
	private String analysisResult;
    
	
	//private Object healthFile;
	private String message;
	private int healthFileId;
	
	private int bloodForward;
	private int scrollLength;
	private int searchType=-1;
	
	private Date startTime;
	private Date endTime;
	private Integer totalSize;
	private int cloudId;
	private String meaTimeString;
	//用于触发程序的传参
	private int[] ids;
	private int exportFlag;
	private int sqid;	
	private BloodSuger bloodSuger;
	private List<Double> bloodSugerMax;
	private List<Double> bloodSugerMin;
	private List<Double> bloodSugerAvg;
	
	private String xaxisBb;
	private String yaxisBb;
	private String xaxisAb;
	private String yaxisAb;
	private String xaxisBl;
	private String yaxisBl;
	private String xaxisAl;
	private String yaxisAl;
	private String xaxisBd;
	private String yaxisBd;
	private String xaxisAd;
	private String yaxisAd;
	private String xaxisBs;
	private String yaxisBs;
	private Page<VChronic> page;
	private SearchBean searchbean ;
	private List<TStaff> staffs;//员工表集合
    private List<TStaff> zrstaffs;
	private boolean flag =false;
	private TStaff tuser;
	private boolean issetsearch;
	private List<TCommunityHospital> hospitals;//所有社区医院
	private int[] chlist=null;//用于多条件查询的慢病种类回显
	private int issq = 2;//判断是否是平台管理员的状态量，用于是否显示所有集团()，所有社区医院搜索选项,2为默认不显示该两项
	private List<TStaff> specialDoctor;
	private String token;
	List<TCommunityHospitalGroup> groups;//集团集合
	private String start;//用于时间的分页参数传递
	private String end;//用于时间的分页参数传递
	private Integer person=null;
    //糖尿病管理首页
	public String getAllDiabeteManager(){
		Page<VChronic> page=new Page<VChronic>();
		page.setCurrentPage(cp);
		 HttpSession session = ServletActionContext.getRequest().getSession();
		 TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
		 if(group!=null){
			hospitals=communityHospitalGroupService.getComHosListByGroup(group);
			page.setTotalNum(chronicDiseaseService.getGroupCountChronicManager(group.getGId(),HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.DIABETE_MANAGER.getValue()));
			vclist=chronicDiseaseService.getGroupChronicManager(group.getGId(),HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.DIABETE_MANAGER.getValue(),page);
			this.pageHtml=page.getPage("chronicManagerAction!getAllDiabeteManager.action");
			issq = 0;
			return "allDiabeteManager";
		}
		else{
			//获取当前登录用户
			Integer person=GetSessionPerson.getPerson();
		//系统管理员
		if(person==0){
				//hospitals = communityHospitalService.getAllHospitals();      //得到所有集团----
				groups=communityHospitalGroupService.getAllQiYongGroups();
				page.setTotalNum(chronicDiseaseService.getAdminCountChronicManager(HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.DIABETE_MANAGER.getValue()));
				vclist=chronicDiseaseService.getAdminChronicManagerPage(HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.DIABETE_MANAGER.getValue(),page);
				//staffs=staffService.getAllStaff();
				issq = 1;
				this.pageHtml=page.getPage("chronicManagerAction!getAllDiabeteManager.action");
				return "allDiabeteManager";
			}
		//社区管理员
		if(person<0){
				page.setTotalNum(chronicDiseaseService.getcountChronicManager(Math.abs(person), HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.DIABETE_MANAGER.getValue()));
				vclist=chronicDiseaseService.getChronicManager(Math.abs(person), HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.DIABETE_MANAGER.getValue(), page);
				staffs=staffService.getStaffByCommunityHospitalId(Math.abs(person));
				specialDoctor=healthFileService.getSpeciallDoctor(Math.abs(person));
				issq = 2;
				this.pageHtml=page.getPage("chronicManagerAction!getAllDiabeteManager.action");
				return "allDiabeteManager";
			}
		//医生 护士 责任医生
		else{
				int hosId=staffService.getCommHospitalByStaffId(person);
				//责任医生
				if(healthFileService.getOldStaffHosByStaffId(person)){
					flag=true;//前台判断隐去收索责任医生项
					page.setTotalNum(chronicDiseaseService.getallCountDiabeteManagerSpecial(hosId, person, HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.DIABETE_MANAGER.getValue()));
					vclist=chronicDiseaseService.getallDiabeteManagerSpecial(hosId,person, HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.DIABETE_MANAGER.getValue(), page);
					this.pageHtml=page.getPage("chronicManagerAction!getAllDiabeteManager.action");
			     }
				//医生护士
				else {
					vclist=chronicDiseaseService.getChronicManager(hosId, HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.DIABETE_MANAGER.getValue(), page);
					staffs=staffService.getStaffByCommunityHospitalId(hosId);
					specialDoctor=healthFileService.getSpeciallDoctor(hosId);
					page.setTotalNum(chronicDiseaseService.getcountChronicManager(hosId, HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.DIABETE_MANAGER.getValue()));
					this.pageHtml=page.getPage("chronicManagerAction!getAllDiabeteManager.action");
				}
				 staffs=staffService.getStaffByCommunityHospitalId(hosId);
		    }
		 }
			 return "allDiabeteManager";
	}

	//高血压管理首页
	public String getAllHighBloodManager(){
		Page<VChronic> page=new Page<VChronic>();
		page.setCurrentPage(cp);
		 HttpSession session = ServletActionContext.getRequest().getSession();
		 TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
		 if(group!=null){
			hospitals=communityHospitalGroupService.getComHosListByGroup(group);
			page.setTotalNum(chronicDiseaseService.getGroupCountChronicManager(group.getGId(),HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.HIGHBLOODPRESSURE_MANAGER.getValue()));
			vclist=chronicDiseaseService.getGroupChronicManager(group.getGId(),HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.HIGHBLOODPRESSURE_MANAGER.getValue(),page);
			this.pageHtml=page.getPage("chronicManagerAction!getAllHighBloodManager.action");
			issq = 0;
			return "allHighBloodManager";
		}
		 else {
			//获取当前登录用户
				int person=GetSessionPerson.getPerson();
	    //管理员
		if(person==0){
			groups=communityHospitalGroupService.getAllQiYongGroups();
			page.setTotalNum(chronicDiseaseService.getAdminCountChronicManager(HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.HIGHBLOODPRESSURE_MANAGER.getValue()));
			vclist=chronicDiseaseService.getAdminChronicManagerPage(HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.HIGHBLOODPRESSURE_MANAGER.getValue(),page);
			//staffs=staffService.getAllStaff();
			//specialDoctor=healthFileService.getSpeciallDoctor(Math.abs(person));
			this.pageHtml=page.getPage("chronicManagerAction!getAllHighBloodManager.action");
			issq = 1;
			return "allHighBloodManager";
		}
		//社区管理员
		if(person<0){
				page.setTotalNum(chronicDiseaseService.getcountChronicManager(Math.abs(person), HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.HIGHBLOODPRESSURE_MANAGER.getValue()));
				vclist=chronicDiseaseService.getChronicManager(Math.abs(person), HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.HIGHBLOODPRESSURE_MANAGER.getValue(), page);
				staffs=staffService.getStaffByCommunityHospitalId(Math.abs(person));
				this.pageHtml=page.getPage("chronicManagerAction!getAllHighBloodManager.action");
				return "allHighBloodManager";
			}
		//医生 责任医生
		else{
				int hosId=staffService.getCommHospitalByStaffId(person);
				//责任医生
				if(healthFileService.getOldStaffHosByStaffId(person)){
				flag=true;//前台判断隐去收索责任医生项
				page.setTotalNum(chronicDiseaseService.getallCountDiabeteManagerSpecial(hosId, person, HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.HIGHBLOODPRESSURE_MANAGER.getValue()));
				vclist=chronicDiseaseService.getallDiabeteManagerSpecial(hosId,person, HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.HIGHBLOODPRESSURE_MANAGER.getValue(), page);
				this.pageHtml=page.getPage("chronicManagerAction!getAllHighBloodManager.action");
				}
				//医生护士
				else {
					vclist=chronicDiseaseService.getChronicManager(hosId, HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.HIGHBLOODPRESSURE_MANAGER.getValue(), page);
					specialDoctor=healthFileService.getSpeciallDoctor(hosId);
					page.setTotalNum(chronicDiseaseService.getcountChronicManager(hosId, HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.HIGHBLOODPRESSURE_MANAGER.getValue()));
					this.pageHtml=page.getPage("chronicManagerAction!getAllHighBloodManager.action");
				}
					staffs=staffService.getStaffByCommunityHospitalId(hosId);
			}
		 }	
					return "allHighBloodManager";
	}
	//其他慢病管理首页
	public String getAllOtherManager(){
		Page<VChronic> page=new Page<VChronic>();
		page.setCurrentPage(cp);
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
		if(group!=null){
			hospitals=communityHospitalGroupService.getComHosListByGroup(group);
			page.setTotalNum(chronicDiseaseService.getGroupCountChronicManager(group.getGId(),HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.OTHER_MANAGER.getValue()));
			vclist=chronicDiseaseService.getGroupChronicManager(group.getGId(),HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.OTHER_MANAGER.getValue(),page);
			this.pageHtml=page.getPage("chronicManagerAction!getAllOtherManager.action");
			issq = 0;
			return "otherManager";
		}
		else{
			//获取当前登录用户
			Integer person=GetSessionPerson.getPerson();
		//管理员
		if(person==0){
			groups = communityHospitalGroupService.getAllQiYongGroups();
			page.setTotalNum(chronicDiseaseService.getAdminCountOtherManager(HealthFileCheck.zhengchang.getValue()));
			vclist=chronicDiseaseService.getAdminOtherManager(HealthFileCheck.zhengchang.getValue(), page);
			//staffs=staffService.getAllStaff();
			this.pageHtml=page.getPage("chronicManagerAction!getAllOtherManager.action");
			issq = 1;
			return "otherManager";
		}
		//社区管理员 社区医院id
		if(person<0){
			page.setTotalNum(chronicDiseaseService.getcountOtherChronicManager(Math.abs(person), HealthFileCheck.zhengchang.getValue()));
			vclist=chronicDiseaseService.getOtherChronicManager(Math.abs(person), HealthFileCheck.zhengchang.getValue() ,page);
			staffs=staffService.getStaffByCommunityHospitalId(Math.abs(person));
			specialDoctor=healthFileService.getSpeciallDoctor(Math.abs(person));
			this.pageHtml=page.getPage("chronicManagerAction!getAllOtherManager.action");
			return "otherManager";
		}
		//员工医生 责任医生
		else{
			int hosId=staffService.getCommHospitalByStaffId(person);
			//责任医生
			if(healthFileService.getOldStaffHosByStaffId(person)==true){
				flag=true;//前台判断隐去收索责任医生项
				page.setTotalNum(chronicDiseaseService.getallCountOtherManagerSpecial(hosId, person, HealthFileCheck.zhengchang.getValue()));
				vclist=chronicDiseaseService.getallOtherManagerSpecial(hosId,person, HealthFileCheck.zhengchang.getValue(), page);
				this.pageHtml=page.getPage("chronicManagerAction!getAllOtherManager.action");
			 }
			//医生护士
			else {
				vclist=chronicDiseaseService.getOtherChronicManager(hosId, HealthFileCheck.zhengchang.getValue() ,page);
				specialDoctor=healthFileService.getSpeciallDoctor(hosId);
				page.setTotalNum(chronicDiseaseService.getcountOtherChronicManager(hosId, HealthFileCheck.zhengchang.getValue()));
				this.pageHtml=page.getPage("chronicManagerAction!getAllOtherManager.action");
			}
				staffs=staffService.getStaffByCommunityHospitalId(hosId);
		}
		}
			return "otherManager";
	}
	
	//从糖尿病管理中删除
	public String deleteDiabeteManager(){
		TChronicDisease chronicDisease=chronicDiseaseService.getChronicDiseaseByNumName(daId, chronicName);
		chronicDisease.setStatus(CHRONIC_MANAGER.NO_MANAGER.getValue());
		chronicDiseaseService.editChronicDisease(chronicDisease);
		return "deleteDiabeteDir";
	}
	//从高血压管理中删除
		public String deleteHighManager(){
			TChronicDisease chronicDisease=chronicDiseaseService.getChronicDiseaseByNumName(daId, chronicName);
			chronicDisease.setStatus(CHRONIC_MANAGER.NO_MANAGER.getValue());
			chronicDiseaseService.editChronicDisease(chronicDisease);
			return "deleteHighDir";
		}
	//从其他慢病管理中删除
		public String deleteOtherManager(){
			TChronicDisease chronicDisease=chronicDiseaseService.getChronicDiseaseByNumName(daId, chronicName);
			chronicDisease.setStatus(CHRONIC_MANAGER.NO_MANAGER.getValue());
			chronicDiseaseService.editChronicDisease(chronicDisease);
			return "deleteOtherDir";
		}
	//  添加该社区的老人，或者该责任医生下的老人
		public String addDiabeteManager(){
			//获取当前登录用户
			int person=GetSessionPerson.getPerson();
			
			if(person<0)
				sqid=Math.abs(person);
			if(person>0)
				sqid=staffService.getCommHospitalByStaffId(person);
			String name="糖尿病";
			Page<VChronic> page=new Page<VChronic>();
			page.setCurrentPage(cp);
			page.setTotalNum(chronicDiseaseService.getNoDiabeteHighManager(sqid, HealthFileCheck.zhengchang.getValue(), name, page).size());
			vcnodiabeteList=chronicDiseaseService.getNoDiabeteHighManager(sqid, HealthFileCheck.zhengchang.getValue(), name, page);
			pageHtml=page.getPage("chronicManagerAction!addDiabeteManager.action");
			return "addDiabeteManager";
		}
	
	//确认添加老人至糖尿病管理
		public String addDiabeteConfirm(){
			chronicDiseaseService.addAnyDiabeteManager(oldids);
			return "deleteDiabeteDir";
		}
		
	//添加老人高血压管理
		public String addHighManager(){
			//获取当前登录用户
			int person=GetSessionPerson.getPerson();
			if(person<0)
					sqid=Math.abs(person);
				if(person>0)
					sqid=staffService.getCommHospitalByStaffId(person);
				String name="高血压";
				Page<VChronic> page=new Page<VChronic>();
				page.setCurrentPage(cp);
				page.setTotalNum(chronicDiseaseService.getcountNoDiabeteHighManager(sqid, HealthFileCheck.zhengchang.getValue(), name));
				vcnoHighList=chronicDiseaseService.getNoDiabeteHighManager(sqid, HealthFileCheck.zhengchang.getValue(), name, page);
				pageHtml=page.getPage("chronicManagerAction!addHighManager.action");
				return "addHighManager";
			}
		
		//确认添加老人至糖尿病管理
			public String addHighConfirm(){
				chronicDiseaseService.addAnyHighManager(oldids);
				return "deleteHighDir";
			}
		
	//to其他慢病添加页 添加该社区的老人，或者该责任医生下的老人
		public String addOtherManager(){
			//获取当前登录用户
			int person=GetSessionPerson.getPerson();
			if(person<0)
				sqid=Math.abs(person);
			if(person>0)
				sqid=staffService.getCommHospitalByStaffId(person);
			String dname="糖尿病";
			String hname="高血压";
			Page<VChronic> page=new Page<VChronic>();
			page.setCurrentPage(cp);
			page.setTotalNum(chronicDiseaseService.getcountNoOtherManager(sqid, HealthFileCheck.zhengchang.getValue(), dname, hname));
			vcnoOtherList=chronicDiseaseService.getNoOtherManager(sqid, HealthFileCheck.zhengchang.getValue(), dname, hname, page);
			pageHtml=page.getPage("chronicManagerAction!addOtherManager.action");
			return "addOtherManager";
		}
		
		//确认添加老人至其他管理
		public String addOtherConfirm(){
			chronicDiseaseService.addAnyOtherManager(oldids);
			return "deleteOtherDir";
		}
	
		//查看疾病详情
		public String infoChronic()
		{
			HttpSession session = ServletActionContext.getRequest().getSession();
			TCommunityHospitalGroup group = (TCommunityHospitalGroup) session
					.getAttribute("communityHospitalGroup");
			if (group!=null) {
				vchronic=chronicDiseaseService.getVChronicByChronicDiseaseId(chronicId);
			}
			else{
			//获取当前登录用户
			person=GetSessionPerson.getPerson();
			vchronic=chronicDiseaseService.getVChronicByChronicDiseaseId(chronicId);
			if(vchronic==null)
				return "error";
			//社区管理员
			if(person<0 && vchronic!=null){
				if(!oldStaffHosService.oldInHos(vchronic.getHealthFileId(), Math.abs(person))){
					return "error";
				}
			}
			
			if(person>0){
				//责任医生
				if(healthFileService.getOldStaffHosByStaffId(person)){
					if (!oldStaffHosService.oldInSpecialHos(vchronic.getHealthFileId(), person)) {
						return "error";
					 }
					}
			}
			}
			if(vchronic.getDiseaseName().equals("高血压"))
				return "gxy";
			if(vchronic.getDiseaseName().equals("糖尿病"))
				return "tnb";
			if(vchronic.getDiseaseName().equals("肿瘤"))
				return "zhongliu";
			if(vchronic.getDiseaseName().equals("慢性支气管病"))
				return "mxzqgb";
			if(vchronic.getDiseaseName().equals("冠心病"))
				return "gxb";
			if(vchronic.getDiseaseName().equals("残疾障碍"))
				return "cjza";
			if(vchronic.getDiseaseName().equals("心脑血管病"))
				return "xnxgb";
			else{
				vchronic.getDiseaseName().equals("重性精神病");
				return "zxjsjb";
			}
		}

		//康复计划查询  康复计划首页
		public String searchRecoveryPlan(){
			HttpSession session = ServletActionContext.getRequest().getSession();
			TCommunityHospitalGroup group = (TCommunityHospitalGroup) session
					.getAttribute("communityHospitalGroup");
			if (group!=null) {
				vchronic=chronicDiseaseService.getVChronicByChronicDiseaseId(chronicId);
			}
			else{
			//获取当前登录用户
			int person=GetSessionPerson.getPerson();
			vchronic=chronicDiseaseService.getVChronicByChronicDiseaseId(chronicId);
			if(vchronic==null)
				return "error";
			//社区管理员
			if(person<0 && vchronic!=null){
				if(!oldStaffHosService.oldInHos(vchronic.getHealthFileId(), Math.abs(person))){
					return "error";
				}
			}
			if(person>0){
				flag=true;//非员工不能添加康复计划。管理员登入隐去添加按钮标记
				//责任医生
				if(healthFileService.getOldStaffHosByStaffId(person)){
					if (!oldStaffHosService.oldInSpecialHos(vchronic.getHealthFileId(), person)) {
						return "error";
					 }
					}
			}
			}
			Page<TRecoveryOld> page = new Page<TRecoveryOld>();
			page.setCurrentPage(cp);
			page.setTotalNum(recoveryPlanService.countRecoveryOldList(vchronic.getHealthFileId(), vchronic.getDiseaseName(), startTime, endTime, planName, planState));
			recoveryOldList=recoveryPlanService.getRecoveryOldList(vchronic.getHealthFileId(), vchronic.getDiseaseName(), page, startTime,endTime, planName, planState);
			if(recoveryOldList.size()!=0){
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			String timenow=df.format(new Date());
			for(TRecoveryOld list:recoveryOldList)
			{
				if(timenow.compareTo(list.getTRecoveryPlan().getOverTime().toString())>0){
					list.getTRecoveryPlan().setStatus(RecoveryPlanStatus.STARRED.getValue());
					recoveryPlanService.updateRecoveryPlan(list.getTRecoveryPlan());
				}
			}
			}
			this.pageHtml = page
					.getPage("chronicManagerAction!searchRecoveryPlan.action?chronicId"
							+ chronicId
							+ "&startTime="
							+ startTime
							+ "&endTime"
							+ endTime
							+ "&planName="
							+ planName
							+ "&planState="
							+ planState);
			if(vchronic.getDiseaseName().equals("高血压"))
				return "gxyShowPlan";
			if(vchronic.getDiseaseName().equals("糖尿病"))
				return "tnbShowPlan";
			else{
				return "otherShowPlan";
		 }
		}
		
		//跳转康复计划添加页
		public String addRecoveryPlan(){
			//获取当前登录用户
			int person=GetSessionPerson.getPerson();
			vchronic=chronicDiseaseService.getVChronicByChronicDiseaseId(chronicId);
			token = TokenProccessor.getInstance().makeToken();//创建令牌
			HttpServletRequest request=ServletActionContext.getRequest();
			request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
			
			if(vchronic==null)
				return "error";
			//社区管理员
			if(person<0 && vchronic!=null){
				if(!oldStaffHosService.oldInHos(vchronic.getHealthFileId(), Math.abs(person))){
					return "error";
				}
				//得到该社区医生              应该是所有启用医生
				//allDoctor=healthFileService.getAllDoctorByHosId(Math.abs(person));
				staffHosList=healthFileService.getAllDoctorByHosId(Math.abs(person));
			}
			if(person>0){
				flag=true;//制定人如果是员工直接显示员工姓名
				int HosId=staffService.getCommHospitalByStaffId(person);
				//责任医生
				if(healthFileService.getOldStaffHosByStaffId(person)){
					if (!oldStaffHosService.oldInSpecialHos(vchronic.getHealthFileId(), person)) {
						return "error";
					 }
						staffHosList=healthFileService.getAllDoctorByHosId(HosId);
					}
			}
			if(vchronic.getDiseaseName().equals("高血压"))
				return "gxyToAdd";
			if(vchronic.getDiseaseName().equals("糖尿病"))
				return "tnbToAdd";
			else{
				return "otherToAdd";
			}
		}
	
		/**
		 * 添加康复计划
		 * @return
		 */
		public String addPlan(){
			//获取当前登录用户
			int person=GetSessionPerson.getPerson();
			int HosId=0;
			if(person<0){
				HosId=Math.abs(person);
			}
			if (person>0) {
				HosId=staffService.getCommHospitalByStaffId(person);
			}
			
			HttpServletRequest request=ServletActionContext.getRequest();
			boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
			if(b==true){
				return "planRed";  //重定向回首页
			}
			request.getSession().removeAttribute("token");//移除session中的token
			

			plan.setPlanName(planName);
			if(recoveryPlanService.checkName(HosId, planName) > 0){
				if(chronicName.equals("高血压"))
					return "toAddRed";
				if(chronicName.equals("糖尿病"))
					return "toAddRed";
				else{
					return "toAddRed";
				}
			}
			trecoveryScheme=recoverySchemeService.getRecoverySchemeById(scheme);
			plan.setTRecoveryScheme(trecoveryScheme);
			plan.setCommunityHospitalId(HosId);
			plan.setStatus(RecoveryPlanStatus.NO_STARTED.getValue());
			plan.setIdDelete(IS_DELETE.no_Delete.getValue());
			//TStaff staff=new TStaff(select);
			//保存员工的id
			if(person>0){
				TStaff staff=staffService.getStaffById(person);
				plan.setTStaff(staff);
			}
			//社区负责人添加时保存的员工id
			if(person<0){
				TStaff staff=staffService.getStaffById(select);
				plan.setTStaff(staff);
			}
			int planId=recoveryPlanService.addRecoveryPlan(plan);
			//保存计划老人关系表
			//隐藏提交一个老人档案id(daId)
			TRecoveryOld recoveryOld=new TRecoveryOld();
			//保存康复计划外键
			//TRecoveryPlan recoveryPlan=new TRecoveryPlan(planId);       /////
			TRecoveryPlan recoveryPlan=recoveryPlanService.getRecoveryPlanById(planId);
			recoveryOld.setTRecoveryPlan(recoveryPlan);
			//保存健康档案外键
			recoveryOld.setTHealthFile(healthFileService.getHealthFileById(chronicDiseaseService.getVChronicByChronicDiseaseId(chronicId).getHealthFileId()));
			recoveryPlanService.addRecoveryOld(recoveryOld);
			return"planRed";
		}
		
		public String jsonChuan() {
			// schemeList = recoverySchemeService.getRecoverySchemeByName(data);
			// 从session中获取社区医院Id
					TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext
							.getContext().getSession().get("comHospital");
					TStaff tstaff = (TStaff) ActionContext.getContext().getSession()
							.get("tstaff");
					int comHosId = 0;
					if (tstaff != null) {
						comHosId = staffService.getCommHospitalByStaffId(tstaff
								.getStaffId());
					}
					if (tCommunityHospital != null) {
						comHosId = tCommunityHospital.getCommunityHospitalId();
					}
			if(type.equals("专家方案"))
			{
				List<TCommunityHospital> hospitals=communityHospitalService.getWuShiSi();
				schemeList=new ArrayList<TRecoveryScheme>();
				if(hospitals!=null)
				{
				for(TCommunityHospital hos:hospitals)
				{
					List<TRecoveryScheme> schemes=recoverySchemeService.getRecoverySchemesByHosId(hos.getCommunityHospitalId(),data);
					if(schemes!=null)
					{	
						for(TRecoveryScheme list:schemes)
						{
							schemeList.add(list);
						}
					
					}
					
				}
				}
			}
			else if(type.equals("推荐方案")){
				schemeList = recoverySchemeService.getTuIjianRecoverySchemeByNameAndType(data, type);
			}
			
			else {
				schemeList = recoverySchemeService.getRecoverySchemeByNameAndType(
						comHosId, data, type);// 根据疾病名称和方案类型得到当前社区下的康复方案
			}
			jsonString = "[{";
			if(schemeList.size()!=0){
			for (TRecoveryScheme scheme : schemeList) {
				jsonString += "\"value\":" + scheme.getRecoverySchemeId()
						+ ",\"text\":\"" + scheme.getSchemeName() + "\"},{";
			}
			jsonString = jsonString.substring(0, jsonString.length() - 2);
			jsonString += "]";
			HttpServletResponse response = (HttpServletResponse) ActionContext
					.getContext().get(
							org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
			try {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.write(jsonString);
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			}
			return null;
		}

		/**
		 * 检查是否重名
		 * 
		 * @return
		 */
		public String checkPlan() {
			// 通过session的得到当前社区id
			TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext
					.getContext().getSession().get("comHospital");
			TStaff tstaff = (TStaff) ActionContext.getContext().getSession()
					.get("tstaff");
			int comHosId = 0;
			if (tstaff != null) {
				comHosId = staffService.getCommHospitalByStaffId(tstaff
						.getStaffId());
			}
			if (tCommunityHospital != null) {
				comHosId = tCommunityHospital.getCommunityHospitalId();
			}
			if (recoveryPlanService.checkName(comHosId, planName) > 0)// 如果查出的数据大于零则重名
			{
				jsons = "chongming";// 前台判断如果json不为空就弹框
			} else {
				jsons = "";
			}
			HttpServletResponse response = (HttpServletResponse) ActionContext
					.getContext().get(
							org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
			try {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.write(jsons);
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		/**
		 * 改变康复计划状态
		 * 
		 * @return
		 */
		public String changePlanStatus() {
			try {
				if (recoveryPlan == null) {
					TRecoveryPlan recoveryPlan = recoveryPlanService
							.getRecoveryPlanById(recoveryPlanId);
					if (recoveryPlan.getStatus().equals(
							RecoveryPlanStatus.NO_STARTED.getValue())) {
						recoveryPlan.setStatus(RecoveryPlanStatus.STARTING
								.getValue());
					} else if (recoveryPlan.getStatus().equals(
							RecoveryPlanStatus.STARTING.getValue())) {
						recoveryPlan.setStatus(RecoveryPlanStatus.STARRED
								.getValue());
					} else if (recoveryPlan.getStatus().equals(
							RecoveryPlanStatus.STARRED.getValue())) {
						recoveryPlan.setStatus(RecoveryPlanStatus.NO_STARTED
								.getValue());
					}
					recoveryPlanService.updateRecoveryPlan(recoveryPlan);
				} else {
					TRecoveryPlan plan = recoveryPlanService
							.getRecoveryPlanById(recoveryPlan.getRecoveryPlanId());
					plan.setStatus(RecoveryPlanStatus.NO_STARTED.getValue());
					plan.setBeginTime(recoveryPlan.getBeginTime());
					plan.setOverTime(recoveryPlan.getOverTime());
					recoveryPlanService.updateRecoveryPlan(plan);
				}
				return "planRed";
			} catch (Exception e) {
				// TODO: handle exception
				return "errorplan";
			}

		}
		
		
		//跳转至康复计划详情页面
		public String jumpInfoRecoveryPlan(){
			HttpSession session = ServletActionContext.getRequest().getSession();
			TCommunityHospitalGroup group = (TCommunityHospitalGroup) session
					.getAttribute("communityHospitalGroup");
			if (group!=null) {
				vchronic=chronicDiseaseService.getVChronicByChronicDiseaseId(chronicId);
			}
			else{
			//获取当前登录用户
			int person=GetSessionPerson.getPerson();
			vchronic=chronicDiseaseService.getVChronicByChronicDiseaseId(chronicId);
			if(vchronic==null)
				return "error";
			//社区管理员
			if(person<0 && vchronic!=null){
				if(!oldStaffHosService.oldInHos(vchronic.getHealthFileId(), Math.abs(person))){
					return "error";
				}
				staffHosList=staffService.getAllStaffByCommunityHospitalId(Math.abs(person));
			}
			if(person>0){
				int HosId=staffService.getCommHospitalByStaffId(person);
				//责任医生
				if(healthFileService.getOldStaffHosByStaffId(person)){
					if (!oldStaffHosService.oldInSpecialHos(vchronic.getHealthFileId(), person)) {
						return "error";
					 }
					staffHosList=staffService.getAllStaffByCommunityHospitalId(HosId);
					}
			}
			}
			plan=recoveryPlanService.getRecoveryPlanById(planId);
			if(vchronic.getDiseaseName().equals("高血压"))
				return "gxyPlanToInfo";
			if(vchronic.getDiseaseName().equals("糖尿病"))
				return "tnbPlanToInfo";
			else{
				return "otherPlanToInfo";
			}
		}
		
		/**
		 * 通过Id删除康复计划 (更新状态)
		 * @return
		 */
		public String deletePlanById(){
			//recoveryPlanService.deleteAnyRecoveryOld(planId);
			//recoveryPlanService.deleteRecoveryPlanById(planId);
			recoveryPlan=recoveryPlanService.getRecoveryPlanById(planId);
			recoveryPlan.setIdDelete(IS_DELETE.delete.getValue());
			recoveryPlanService.updateRecoveryPlan(recoveryPlan);
			//recoveryPlanService.updatePlanIsDelete(planId);
			return"planRed";
		}
	
		
		
		
		
		

		 /****************      血压管理的三个页面              赖清发                ********************/
		/**
		 * 健康管理高血压管理 血压详情 ，进入数据分析页（第一个链接），也可以用于三个页面之间切换
		 * @return 
		 */
		public String getBloodPressFromCloud(){
			if(checkAddressHealthFileId(healthFileId).equals("error")){
				return "error";
			}
			//根据档案id 获取档案实体
			healthFile = healthFileService.getHealthFileById(healthFileId);
			switch (bloodForward) {
			case 0:
				return "getBloodPressFromCloud0";  //返回数据分析页
			case 1:
				return "getBloodPressFromCloud1";  //返回趋势分析页
			case 2:
				Page<BloodPress> page1=new Page<BloodPress>();
				page1.setCurrentPage(cp);
				String resultJson = healthManagerService.getAllBloodPressData(healthFileId+"--"+healthFile.getIdNum(),
						page1.getCurrentPage(),page1.getPageSize());
				// 将json串转换成目标对象
				bloodPressCloud = JSON.parseObject(resultJson,BloodPressCloud.class);
				String jsonString=bloodPressCloud.getPage().getResult();//[{"appKey":"ac6b5a57f3d04e328a1e79facc860e1d","appUserID":"1","arm":0,"devID":0,"diaPre":90,"id":91,"meaState":0,"meaTime":"2016-09-13 00:00:00","medName":"","other1":"111","other2":"222","other3":"333","pulse":79,"sysPre":89,"takeMed":0}
				bloodPresseList = (List<BloodPress>)JSONArray.parseArray(jsonString, BloodPress.class);
				// 获取分页的总数
				page1.setTotalNum(bloodPressCloud.getPage().getTotal());
				Collections.sort(bloodPresseList,
						new Comparator<BloodPress>() {
					@Override
					public int compare(
							com.jmjk.pojo.BloodPress o1,
							com.jmjk.pojo.BloodPress o2) {
						Date time1 = TypeConverter.convertString2Date(
								o1.getMeaTime(), "yyyy-MM-dd HH:mm:ss");
						Date time2 = TypeConverter.convertString2Date(
								o2.getMeaTime(), "yyyy-MM-dd HH:mm:ss");
						if (time2.after(time1)) {
							return 1;
						} else if (time2.before(time1)) {
							return -1;
						} else {
							return 0;
						}
					}
				});
				this.pageHtml = page1
						.getPage("chronicManagerAction!getBloodPressFromCloud.action?bloodForward=2&healthFileId="+healthFileId);
				return "getBloodPressFromCloud2";  //返回数据详细页
			default:
				return "getBloodPressFromCloud0";  //返回数据分析页
			}
		}
		
		/**
		 * 血压数据的数据分析
		 * @return
		 */
		public String bloodPressDataAnalysis(){
			if(checkAddressHealthFileId(healthFileId).equals("error")){
				return "error";
			}
			// 根据档案id 获取档案实体
			healthFile = healthFileService.getHealthFileById(healthFileId);
			String resultJson = ""; // 返回的数据json串
			if (searchType == 0 &&startTime!=null&&endTime!=null) { // 搜索条件按时间查询
				resultJson = healthManagerService.getBloodPressData(healthFileId+"--"+healthFile.getIdNum(),
						startTime, endTime, 1, 1000);
			} else if (searchType == 1&&totalSize!=null) { // 搜索条件按条数查询
				resultJson = healthManagerService.getBloodPressData(healthFileId+"--"+healthFile.getIdNum(),
						totalSize, 1, 1000);
			} else {
				searchType=0;
				return "bloodPressDataAnalysis";
			}
			// 将json串转换成目标对象
			BloodPressCloud bloodPressCloud = JSON.parseObject(resultJson,BloodPressCloud.class);
			if (bloodPressCloud.getCode() == 0) { // 服务器响应成功
				message = bloodPressCloud.getMessage();
				String jsonString=bloodPressCloud.getPage().getResult();
				bloodPresses = (List<BloodPress>)JSONArray.parseArray(jsonString, BloodPress.class);
				List<BloodPress> bloodPresses1 = (List<BloodPress>)JSONArray.parseArray(jsonString, BloodPress.class);
				List<BloodPress> bloodPresses2 = (List<BloodPress>)JSONArray.parseArray(jsonString, BloodPress.class);
				if(bloodPresses.size()!=0){
				// 定义收缩压最高的实体
				BloodPress bloodPressMax =new BloodPress(); 
				bloodPressMax=bloodPresses.get(0);
				// 定义舒张压最低的实体
				BloodPress bloodPressMin =new BloodPress();
				bloodPressMin= bloodPresses1.get(0);
				// 定义各参数的平均实体
				BloodPress bloodPressAvg = new BloodPress();
				// 定义6点到9点的各参数的平均实体
				BloodPress bloodPressAvgSixToNine = new BloodPress();
				int countSixToNine = 0;
				// 定义18点到21点的各参数的平均实体
				BloodPress bloodPressAvgWSixToNine = new BloodPress();
				// 记录数量
				int countWSixToNine = 0;
				String time = "";
				double diaPre=0;
				double sysPre=0;
				int pulse=0;
				double sixToNineDiaPre=0;
				double sixToNineSysPre=0;
				int sixToNinePulse=0;
				double wsixToNineDiaPre=0;
				double wsixToNineSysPre=0;
				int wsixToNinePulse=0;
				for (BloodPress xbloodPress : bloodPresses) {
					// 求收缩压、舒张压、血压最高的实体引用
					 if(xbloodPress.getSysPre()>bloodPressMax.getSysPre()){
							bloodPressMax.setSysPre(xbloodPress.getSysPre());;
						 }
					 if(xbloodPress.getDiaPre()>bloodPressMax.getDiaPre()){
							bloodPressMax.setDiaPre(xbloodPress.getDiaPre());
						 }
					 if(xbloodPress.getPulse()>bloodPressMax.getPulse()){
							bloodPressMax.setPulse(xbloodPress.getPulse());
						 }
				}
				
				for (BloodPress xbloodPress : bloodPresses1) {
					// 求收缩压、舒张压、血压最低的实体引用
					if(xbloodPress.getSysPre()<bloodPressMin.getSysPre()){
						bloodPressMin.setSysPre(xbloodPress.getSysPre());
					 }
					if(xbloodPress.getDiaPre()<bloodPressMin.getDiaPre()){
							bloodPressMin.setDiaPre(xbloodPress.getDiaPre());
						 }
					if(xbloodPress.getPulse()<bloodPressMin.getPulse()){
						bloodPressMin.setPulse(xbloodPress.getPulse());;
					 }
					
				}
				
				for (BloodPress xbloodPress : bloodPresses2) {
					time = xbloodPress.getMeaTime();
					// 求各参数的的和
					diaPre=diaPre+xbloodPress.getDiaPre();
					sysPre=sysPre+xbloodPress.getSysPre();
					pulse=pulse+xbloodPress.getPulse();
					// 求6-9点的实体的各参数的和
					if (compareTime(time, "06:00", "09:00")==true) {
						countSixToNine++;
						sixToNineDiaPre=sixToNineDiaPre + xbloodPress.getDiaPre();
						sixToNineSysPre=sixToNineSysPre + xbloodPress.getSysPre();
						sixToNinePulse=sixToNinePulse + xbloodPress.getPulse();
					}
					// 求18-21点的实体的各参数的和
					if (compareTime(time, "18:00", "21:00")) {
						countWSixToNine++;
						wsixToNineDiaPre=wsixToNineDiaPre + xbloodPress.getDiaPre();
						wsixToNineSysPre=wsixToNineSysPre + xbloodPress.getSysPre();
						wsixToNinePulse =wsixToNinePulse + xbloodPress.getPulse();
					}
				}
				try {
					// 计算平均值
					bloodPressAvg.setSysPre(sysPre
							/ bloodPresses.size());
					bloodPressAvg.setDiaPre(diaPre
							/ bloodPresses.size());
					bloodPressAvg.setPulse(pulse
							/ bloodPresses.size());
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					/*if(countSixToNine==0){
						bloodPressAvgSixToNine.setSysPre((double) 0);
						bloodPressAvgSixToNine.setDiaPre((double) 0);
						bloodPressAvgSixToNine.setPulse(0);
					}*/
					// 计算6-9点各个平均值
					if(countSixToNine!=0) {
						bloodPressAvgSixToNine.setSysPre(sixToNineSysPre/ countSixToNine);
						bloodPressAvgSixToNine.setDiaPre(sixToNineDiaPre / countSixToNine);
						bloodPressAvgSixToNine.setPulse(sixToNinePulse / countSixToNine);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					/*if(countWSixToNine==0){
						bloodPressAvgWSixToNine.setSysPre((double) 0);
						bloodPressAvgWSixToNine.setDiaPre((double) 0);
						bloodPressAvgWSixToNine.setPulse(0);
					}*/
					// 18-21计算平均值
					if(countWSixToNine!=0) {
						bloodPressAvgWSixToNine.setSysPre(wsixToNineSysPre/ countWSixToNine);
						bloodPressAvgWSixToNine.setDiaPre(wsixToNineDiaPre / countWSixToNine);
						bloodPressAvgWSixToNine.setPulse(wsixToNinePulse / countWSixToNine);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				// 添加符合条件的实体			
				bloodPresseList.add(bloodPressMax);
				bloodPresseList.add(bloodPressMin);
				bloodPresseList.add(bloodPressAvg);
				bloodPresseList.add(bloodPressAvgSixToNine);
				bloodPresseList.add(bloodPressAvgWSixToNine);
			  }
			}
			return "bloodPressDataAnalysis";
		}
		
		/**
		 * 血压数据的趋势分析
		 * @return
		 */
		public String bloodPressTendAnalysis() {
			if(checkAddressHealthFileId(healthFileId).equals("error")){
				return "error";
			}
			// 根据档案id 获取档案实体
			healthFile = healthFileService.getHealthFileById(healthFileId);
			String resultJson = ""; // 返回的数据json串
			if (searchType == 0&&startTime!=null&&endTime!=null) { // 搜索条件按时间查询
				resultJson = healthManagerService.getBloodPressData(healthFileId+"--"+healthFile.getIdNum(),
						startTime, endTime,1, 1000);
				//resultJson="{\"code\":0,\"message\":\"数据查询成功！\",\"page\":{\"endRow\":16,\"pageNum\":1,\"pageSize\":16,\"pages\":1,\"result\":[{\"appKey\":\"112113\",\"appUserID\":\"0000001\",\"arm\":3,\"devID\":21,\"diaPre\":4,\"id\":3,\"meaState\":0,\"meaTime\":\"2011-01-01 10:03:40\",\"other1\":\"\",\"other2\":\"\",\"other3\":\"\",\"pulse\":53,\"sysPre\":2},{\"appKey\":\"112113\",\"appUserID\":\"0000001\",\"arm\":3,\"devID\":21,\"diaPre\":4,\"id\":4,\"meaState\":2,\"meaTime\":\"2011-01-01 10:03:40\",\"other1\":\"111\",\"other2\":\"222\",\"other3\":\"333\",\"pulse\":53,\"sysPre\":2}],\"startRow\":0,\"total\":2}}";
			} else if (searchType == 1&&totalSize!=null) { // 搜索条件按条数查询
				resultJson = healthManagerService.getBloodPressData(healthFileId+"--"+healthFile.getIdNum(),
						totalSize, 1, 1000);
			} else {
				searchType=0;
				return "bloodPressTendAnalysisi";
			}
			// 将json串转换成目标对象
			BloodPressCloud bloodPressCloud = JSON.parseObject(resultJson,
					BloodPressCloud.class);
			if(bloodPressCloud.getCode()==0){
			String jsonString=bloodPressCloud.getPage().getResult();
			bloodPresses = (List<BloodPress>)JSONArray.parseArray(jsonString, BloodPress.class);
			// 用于前台显示时如何数据量太大，强迫页面出现左右的滚动条
			if(bloodPresses.size()!=0){
			scrollLength = bloodPresses.size() * 150;
			// 查询成功实体中的code值为0，注意此处不是服务器返回的状态码
					message = bloodPressCloud.getMessage();
					// collection集合类的帮助类collections提供的排序方法，按照时间将list中的数据排序
					Collections.sort(bloodPresses,
							new Comparator<BloodPress>() {
						@Override
						public int compare(
								com.jmjk.pojo.BloodPress o1,
								com.jmjk.pojo.BloodPress o2) {
							Date time1 = TypeConverter.convertString2Date(
									o1.getMeaTime(), "yyyy-MM-dd HH:mm");
							Date time2 = TypeConverter.convertString2Date(
									o2.getMeaTime(), "yyyy-MM-dd HH:mm");
							if (time2.after(time1)) {
								return 1;
							} else if (time2.before(time1)) {
								return -1;
							} else {
								return 0;
							}
						}
					});
					StringBuilder xAxisBuilder = new StringBuilder();
					StringBuilder yAxisBuilderHigh = new StringBuilder();
					StringBuilder yAxisBuilderLow = new StringBuilder();
					StringBuilder yAxisBuilderPulse = new StringBuilder();
					// 将服务器返回的数据整合成highchars需要的格式
					for (BloodPress bloodPress : bloodPresses) {
						xAxisBuilder.append("'" + bloodPress.getMeaTime() + "'");
						xAxisBuilder.append(",");
						yAxisBuilderHigh.append(bloodPress.getSysPre());
						yAxisBuilderHigh.append(",");
						yAxisBuilderLow.append(bloodPress.getDiaPre());
						yAxisBuilderLow.append(",");
						yAxisBuilderPulse.append(bloodPress.getPulse());
						yAxisBuilderPulse.append(",");
					}
					xAxisBuilder.deleteCharAt(xAxisBuilder.length() - 1);
					yAxisBuilderHigh.deleteCharAt(yAxisBuilderHigh.length() - 1);
					yAxisBuilderLow.deleteCharAt(yAxisBuilderLow.length() - 1);
					yAxisBuilderPulse.deleteCharAt(yAxisBuilderPulse.length() - 1);
					// 由时间构成的x轴数据
					xAxis = "[" + xAxisBuilder.toString() + "]";//['2016-09-05 00:00:00','2016-09-08 00:00:00']
					// 拼接收缩压构成的数据
					yAxisHigh = "[" + yAxisBuilderHigh.toString() + "]";//[78.0,33.0]
					// 拼接舒张压构成的数据
					yAxisLow = "[" + yAxisBuilderLow.toString() + "]";//[78.0,22.0]
					// 拼接脉率值构成的数据
					yAxisPulse = "[" + yAxisBuilderPulse.toString() + "]";//[89,54]
	 		}
			else{
				xAxis="[0]";
				yAxisHigh="[0]";
				yAxisLow="[0]";
				yAxisPulse="[0]";
				return "bloodPressTendAnalysisi";
			}
			}
			return "bloodPressTendAnalysisi";
		}

		
		/**
		 * 查看血压详情
		 * @return
		 */
		public String bloodPressDataDetail(){
			if(checkAddressHealthFileId(healthFileId).equals("error")){
				return "error";
			}
			// 根据档案id 获取档案实体
			healthFile = healthFileService.getHealthFileById(healthFileId);
			// 分页处理
			Page<BloodPress> page = new Page<BloodPress>();
			page.setCurrentPage(cp);
			String resultJson = ""; // 返回的数据json串
			if(start!=null||end!=null){
				start=start.replace("/", " ");
				end=end.replace("/", " ");
				startTime=TypeConverter.stringToDate(start);
				endTime=TypeConverter.stringToDate(end);
			}
			//血压数据详情，默认查询所有
			if (searchType == 0&&startTime!=null&&endTime!=null) { // 搜索条件按时间查询
				resultJson = healthManagerService.getBloodPressData(healthFileId+"--"+healthFile.getIdNum(),
						startTime, endTime, page.getCurrentPage(),page.getPageSize());
				// 将json串转换成目标对象
				bloodPressCloud = JSON.parseObject(resultJson,BloodPressCloud.class);
				if(bloodPressCloud.getCode()==0){
				String jsonString=bloodPressCloud.getPage().getResult();
				bloodPresseList = (List<BloodPress>)JSONArray.parseArray(jsonString, BloodPress.class);
				if(bloodPresseList.size()>2){
					Collections.sort(bloodPresseList,
							new Comparator<BloodPress>() {
								@Override
								public int compare(
										com.jmjk.pojo.BloodPress o1,
										com.jmjk.pojo.BloodPress o2) {
									Date time1 = TypeConverter.convertString2Date(
											o1.getMeaTime(), "yyyy-MM-dd HH:mm");
									Date time2 = TypeConverter.convertString2Date(
											o2.getMeaTime(), "yyyy-MM-dd HH:mm");
									if (time2.after(time1)) {
										return 1;
									} else if (time2.before(time1)) {
										return -1;
									} else {
										return 0;
									}
								}
							});
				}
				// 获取分页的总数
				page.setTotalNum(bloodPressCloud.getPage().getTotal());
				//用于时间回显
		        start=TypeConverter.convertDate2String(startTime, "yyyy-MM-dd HH:mm:ss");
		        start=start.replace(" ", "/");
		        end=TypeConverter.convertDate2String(endTime, "yyyy-MM-dd HH:mm:ss");
		        end=end.replace(" ", "/");
		        this.pageHtml = page
						.getPage("chronicManagerAction!bloodPressDataDetail.action?healthFileId="
								+ healthFileId
								+ "&start="
								+ start
								+ "&end="
								+ end
								+ "&searchType="
								+ searchType);
				}
			} else if (searchType == 1&&totalSize!=null) { // 搜索条件按条数查询
				resultJson = healthManagerService.getBloodPressData(healthFileId+"--"+healthFile.getIdNum(),
						totalSize, page.getCurrentPage(), page.getPageSize());
				bloodPressCloud = JSON.parseObject(resultJson,
						BloodPressCloud.class);
				if(bloodPressCloud.getCode()==0){
				String jsonString=bloodPressCloud.getPage().getResult();
				bloodPresseList = (List<BloodPress>)JSONArray.parseArray(jsonString, BloodPress.class);
				if(bloodPresseList.size()>2){
					Collections.sort(bloodPresseList,
							new Comparator<BloodPress>() {
								@Override
								public int compare(
										com.jmjk.pojo.BloodPress o1,
										com.jmjk.pojo.BloodPress o2) {
									Date time1 = TypeConverter.convertString2Date(
											o1.getMeaTime(), "yyyy-MM-dd HH:mm");
									Date time2 = TypeConverter.convertString2Date(
											o2.getMeaTime(), "yyyy-MM-dd HH:mm");
									if (time2.after(time1)) {
										return 1;
									} else if (time2.before(time1)) {
										return -1;
									} else {
										return 0;
									}
								}
							});
				}
				page.setTotalNum(bloodPressCloud.getPage().getTotal());
				this.pageHtml = page
							.getPage("chronicManagerAction!bloodPressDataDetail.action?healthFileId="
									+ healthFileId + "&totalSize=" + totalSize+
									"&=searchType"+searchType);
				}
			} else {
				return "bloodPressDataDetailRed";
			}
			return "bloodPressDataDetail";
		}
		
		/**
		 * 删除自己上传的血压数据
		 * @return
		 */
		public String deleteBloodPressDataCloud(){
			 // 删除云上的血压数据，返回反馈信息                                    这种删除怎么做校验
			message = healthManagerService.deleteBPCloud(cloudId);
			return "bloodPressDataDetailRed";
		}
		
		
		/**
		 * 修改云端血压数据
		 * @return 
		 */
		public String toEditBPCloud(){
			//根据档案id 获取档案实体
			healthFile = healthFileService.getHealthFileById(healthFileId);
			return "toEditBPCloud";
		}
		public String editBPCloud(){
			//根据档案id 获取档案实体
			healthFile = healthFileService.getHealthFileById(healthFileId);
			bloodSuger.setAppUserID(healthFileId+"");
			if(bloodPress.getDiaPre()==null||
					bloodPress.getMeaTime()==null||bloodPress.getPulse()==null||bloodPress.getSysPre()==null
					||bloodPress.getTakeMed()==null){
				return "toEditBPCloud";
			}
			message = healthManagerService.updateBPCloud(cloudId, bloodPress);
			return "editBPCloud";
		}



		/****************血糖管理的三个页面********************/
		/**
		 * 获取云端的血糖数据并分析
		 * @return
		 */
		public String getBloodSugerFromCloud(){
			if(checkAddressHealthFileId(healthFileId).equals("error")){
				return "error";
			}
			//根据档案id 获取档案实体
			healthFile = healthFileService.getHealthFileById(healthFileId);
			switch (bloodForward) {
			case 0:
				return "getBloodSugerFromCloud0";  //返回数据分析页
			case 1:
				return "getBloodSugerFromCloud1";  //返回趋势分析页
			case 2:
				Page<BloodSuger> page1=new Page<BloodSuger>();
				page1.setCurrentPage(cp);
				String resultJson = healthManagerService.getAllBloodSugerData(healthFileId+"--"+healthFile.getIdNum(),
						page1.getCurrentPage(),page1.getPageSize());
				// 将json串转换成目标对象
				bloodSugerCloud = JSON.parseObject(resultJson,BloodSugerCloud.class);
				String jsonString=bloodSugerCloud.getPage().getResult();//[{"appKey":"ac6b5a57f3d04e328a1e79facc860e1d","appUserID":"1","arm":0,"devID":0,"diaPre":90,"id":91,"meaState":0,"meaTime":"2016-09-13 00:00:00","medName":"","other1":"111","other2":"222","other3":"333","pulse":79,"sysPre":89,"takeMed":0}
				bloodSugerList = (List<BloodSuger>)JSONArray.parseArray(jsonString, BloodSuger.class);
				// 获取分页的总数
				page1.setTotalNum(bloodSugerCloud.getPage().getTotal());
				// 对数据按照时间排序
				Collections.sort(bloodSugerList,
						new Comparator<BloodSuger>() {
							@Override
							public int compare(
									com.jmjk.pojo.BloodSuger o1,
									com.jmjk.pojo.BloodSuger o2) {
								Date time1 = TypeConverter.convertString2Date(
										o1.getMeaTime(), "yyyy-MM-dd HH:mm:ss");
								Date time2 = TypeConverter.convertString2Date(
										o2.getMeaTime(), "yyyy-MM-dd HH:mm:ss");
								if (time2.after(time1)) {
									return 1;
								} else if (time2.before(time1)) {
									return -1;
								} else {
									return 0;
								}
							}
						});
				this.pageHtml = page1
						.getPage("chronicManagerAction!getBloodSugerFromCloud.action?bloodForward=2&healthFileId="+healthFileId);
				return "getBloodSugerFromCloud2"; //返回数据详细页						
			default:
				return "getBloodSugerFromCloud0";
			}
		}

		/**
		 * 血糖数据的数据分析
		 * @return
		 */
		public String bloodSugerDataAnalysis(){
			if(checkAddressHealthFileId(healthFileId).equals("error")){
				return "error";
			}
			// 根据档案id 获取档案实体
			healthFile = healthFileService.getHealthFileById(healthFileId);
			String resultJson = ""; // 返回的数据json串
			if (searchType == 0 && startTime != null && endTime != null) { // 搜索条件按时间查询
				resultJson = healthManagerService.getBloodSugerData(healthFileId
						+ "", startTime, endTime, 1, 1000);
			} else if (searchType == 1 && totalSize != null) { // 搜索条件按条数查询
				resultJson = healthManagerService.getBloodSugerData(healthFileId
						+ "", totalSize, 1, 1000);
			} else {
				return "bloodSugerDataAnalysis";
			}
			// 将json串转换成目标对象
			bloodSugerCloud = JSON.parseObject(resultJson, BloodSugerCloud.class);
			if (bloodSugerCloud.getCode() == 0) { // 服务器响应成功
				message = bloodSugerCloud.getMessage();
				String jsonString = bloodSugerCloud.getPage().getResult();
				bloodSugerList = (List<BloodSuger>) JSONArray.parseArray(
						jsonString, BloodSuger.class);
				// 得到不同测量状态血糖数据列表
				// 早餐前
				List<BloodSuger> beferBreakfast = new ArrayList<BloodSuger>();
				// 早餐后
				List<BloodSuger> afterBreakfast = new ArrayList<BloodSuger>();
				// 午餐前
				List<BloodSuger> beferLunch = new ArrayList<BloodSuger>();
				
				// 按上述分类，分类赋值
				for (BloodSuger xbloodSuger : bloodSugerList) {
					switch (xbloodSuger.getMeaState()) {
					case 0:
						beferBreakfast.add(xbloodSuger);
						break;
					case 1:
						afterBreakfast.add(xbloodSuger);
						break;
					case 2:
						beferLunch.add(xbloodSuger);
						break;
					default:
						break;
					}
				}
				// 将所得的列表按照血糖值的高低进行排序
				sort(beferBreakfast, "血糖值");
				sort(afterBreakfast, "血糖值");
				sort(beferLunch, "血糖值");
				bloodSugerAvg = new ArrayList<Double>();
				bloodSugerMax = new ArrayList<Double>();
				bloodSugerMin = new ArrayList<Double>();
				// 将排好序的各个类别的值按顺序放入相应的list中
				// 早餐前的最大、最小、平均值
				if (beferBreakfast.size() != 0) {
					bloodSugerMax.add(new Double(beferBreakfast.get(0)
							.getBloodSugar()));
					bloodSugerMin.add(new Double(beferBreakfast.get(
							beferBreakfast.size() - 1).getBloodSugar()));
					try {
						bloodSugerAvg.add(new Double(
								getBloodSugerAvg(beferBreakfast)));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				// 早餐后的最大、最小、平均值
				if (afterBreakfast.size() != 0) {
					bloodSugerMax.add(new Double(afterBreakfast.get(0)
							.getBloodSugar()));
					bloodSugerMin.add(new Double(afterBreakfast.get(
							afterBreakfast.size() - 1).getBloodSugar()));
					try {
						bloodSugerAvg.add(new Double(
								getBloodSugerAvg(afterBreakfast)));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				// 午餐前的最大、最小、平均值
				if (beferLunch.size() != 0) {
					bloodSugerMax
							.add(new Double(beferLunch.get(0).getBloodSugar()));
					bloodSugerMin.add(new Double(beferLunch.get(
							beferLunch.size() - 1).getBloodSugar()));
					try {
						bloodSugerAvg.add(new Double(getBloodSugerAvg(beferLunch)));
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				}
			return "bloodSugerDataAnalysis";
		}

		/**
		 * 血糖的趋势分析
		 * @return
		 */
		public String bloodSugerTendAnalysis(){   
			if(checkAddressHealthFileId(healthFileId).equals("error")){
				return "error";
			}
			// 根据档案id 获取档案实体
			healthFile = healthFileService.getHealthFileById(healthFileId);
			String resultJson = ""; // 返回的数据json串
			if (searchType == 0 && startTime != null && endTime != null) { // 搜索条件按时间查询
				resultJson = healthManagerService.getBloodSugerData(healthFileId
						+ "", startTime, endTime, 1, 1000);
			} else if (searchType == 1 && totalSize != null) { // 搜索条件按条数查询
				resultJson = healthManagerService.getBloodSugerData(healthFileId
						+ "", totalSize, 1, 1000);
			} else {
				searchType = 0;
				return "bloodSugerTendAnalysis";
			}
			// 将json串转换成目标对象
			BloodSugerCloud bloodSugerCloud = JSON.parseObject(resultJson,
					BloodSugerCloud.class);
			if (bloodSugerCloud.getCode() == 0) { // 服务器响应成功
				message = bloodSugerCloud.getMessage();
				String jsonString = bloodSugerCloud.getPage().getResult();
				bloodSugerList = (List<BloodSuger>) JSONArray.parseArray(
						jsonString, BloodSuger.class);
				// 得到不同测量状态血糖数据列表
				List<BloodSuger> beferBreakfast = new ArrayList<BloodSuger>();
				List<BloodSuger> afterBreakfast = new ArrayList<BloodSuger>();
				List<BloodSuger> beferLunch = new ArrayList<BloodSuger>();
				
				for (BloodSuger xbloodSuger : bloodSugerList) {
					switch (xbloodSuger.getMeaState()) {
					case 0:
						beferBreakfast.add(xbloodSuger);
						break;
					case 1:
						afterBreakfast.add(xbloodSuger);
						break;
					case 2:
						beferLunch.add(xbloodSuger);
						break;
					default:
						break;
					}
				}
				// 按照测量时间进行排序
				sort(beferBreakfast, "测量时间");
				sort(afterBreakfast, "测量时间");
				sort(beferLunch, "测量时间");
				// 用于前台显示时如何数据量太大，强迫页面出现左右的滚动条
				scrollLength = beferBreakfast.size() * 200;
				List<String> axisBuffer; // 中间变量
				// 对传入的实体进行highchars展示的要求进行数据的格式化 \
				// ['2016-09-12 00:00:00','2016-09-13 00:00:00','2016-09-14
				// 00:00:00','2016-09-22 00:00:00']
				// '2016-09-12 00:00:00','2016-09-13 00:00:00','2016-09-14
				// 00:00:00','2016-09-22 00:00:00'
				// 获取早餐前的x轴和y轴的值
				if (beferBreakfast != null && beferBreakfast.size() != 0) {
					axisBuffer = getXAxisAndYAxis(beferBreakfast);
					if (axisBuffer.size() != 0) {
						xaxisBb = axisBuffer.get(0);
						yaxisBb = axisBuffer.get(1);
					}
				}
				if (beferBreakfast.size() == 0) {
					xaxisBb = "['0000-00-00 00:00:00']";
					yaxisBb = "[0]";
				}

				// 获取早餐后的x轴和y轴的值
				if (afterBreakfast != null && afterBreakfast.size() != 0) {
					axisBuffer = getXAxisAndYAxis(afterBreakfast);
					if (axisBuffer.size() != 0) {
						xaxisAb = axisBuffer.get(0);
						yaxisAb = axisBuffer.get(1);
					}
				}
				if (afterBreakfast.size() == 0) {
					xaxisAb = "['0000-00-00 00:00:00']";
					yaxisAb = "[0]";
				}
				// 获取午餐前的x轴和y轴的值
				if (beferLunch != null && beferLunch.size() != 0) {
					axisBuffer = getXAxisAndYAxis(beferLunch);
					if (axisBuffer.size() != 0) {
						xaxisBl = axisBuffer.get(0);
						// System.out.println(xaxisBl);
						yaxisBl = axisBuffer.get(1);
					}
				}
				if (beferLunch.size() == 0) {
					xaxisBl = "['0000-00-00 00:00:00']";
					yaxisBl = "[0]";
				}
			}
			return "bloodSugerTendAnalysis";
		}

		/**
		 * 血糖的详细数据
		 * @return
		 */
		public String bloodSugerDataDetail(){
			if(checkAddressHealthFileId(healthFileId).equals("error")){
				return "error";
			}
			healthFile = healthFileService.getHealthFileById(healthFileId);
			Page<BloodSugerCloud.BloodSuger> page = new Page<BloodSugerCloud.BloodSuger>();
			page.setCurrentPage(cp);
			// 返回的数据json串
			String resultJson = "";
			// 搜索条件按时间查询
			if(start!=null||end!=null){
				start=start.replace("/", " ");
				end=end.replace("/", " ");
				startTime=TypeConverter.stringToDate(start);
				endTime=TypeConverter.stringToDate(end);
			}
			if (searchType == 0 &&startTime!=null&&endTime!=null) {
				resultJson = healthManagerService.getBloodSugerData(healthFileId+"--"+healthFile.getIdNum(),
						startTime, endTime, page.getCurrentPage(),page.getPageSize());
				// 搜索条件按条数查询
			} else if (searchType == 1&&totalSize!=null) {
				resultJson = healthManagerService.getBloodSugerData(healthFileId+"--"+healthFile.getIdNum(),
						totalSize, page.getCurrentPage(), page.getPageSize());
			} else {
				return "bloodSugerDataDetailRed";
			}
			// 将json串转换成目标对象
			BloodSugerCloud bloodSugerCloud = JSON.parseObject(resultJson,
					BloodSugerCloud.class);
			// 服务器响应成功 
			if (bloodSugerCloud.getCode() == 0) {
				message = bloodSugerCloud.getMessage();
				String jsonString=bloodSugerCloud.getPage().getResult();
				bloodSugerList = (List<BloodSuger>)JSONArray.parseArray(jsonString, BloodSuger.class);
				page.setTotalNum(bloodSugerCloud.getPage().getTotal());
				// 对数据按照时间排序
				Collections.sort(bloodSugerList,
						new Comparator<BloodSuger>() {
							@Override
							public int compare(
									com.jmjk.pojo.BloodSuger o1,
									com.jmjk.pojo.BloodSuger o2) {
								Date time1 = TypeConverter.convertString2Date(
										o1.getMeaTime(), "yyyy-MM-dd HH:mm:ss");
								Date time2 = TypeConverter.convertString2Date(
										o2.getMeaTime(), "yyyy-MM-dd HH:mm:ss");
								if (time2.after(time1)) {
									return 1;
								} else if (time2.before(time1)) {
									return -1;
								} else {
									return 0;
								}
							}
						});
			} else { // 服务器响应失败
				return "bloodSugerDataDetail";
			}
			if(searchType == 0 &&startTime!=null&&endTime!=null){
				start=TypeConverter.convertDate2String(startTime, "yyyy-MM-dd HH:mm:ss");
		        start=start.replace(" ", "/");
		        end=TypeConverter.convertDate2String(endTime, "yyyy-MM-dd HH:mm:ss");
		        end=end.replace(" ", "/");
				this.pageHtml = page
						.getPage("chronicManagerAction!bloodSugerDataDetail.action?healthFileId="
							+ healthFileId+"&start="+ start + "&end="+ end+"&searchType="+searchType);
			}
			if(searchType == 1&&totalSize!=null){
				this.pageHtml = page
						.getPage("chronicManagerAction!bloodSugerDataDetail.action?healthFileId="
							+healthFileId+"&searchType="+searchType+"&totalSize="+ totalSize);
			}
			return "bloodSugerDataDetail";
		}

		/**
		 * 跳转修改云端血压数据页
		 * 
		 * @return
		 */
		public String toEditBSCloud() {
			if(checkAddressHealthFileId(healthFileId).equals("error")){
				return "error";
			}
			// 根据档案id 获取档案实体
			healthFile = healthFileService.getHealthFileById(healthFileId);
			return "toEditBSCloud";
		}
		/**
		 * 修改云端血糖数据
		 * 
		 * @return
		 */
		public String editBSCloud() {
			// 根据档案id 获取档案实体
			healthFile = healthFileService.getHealthFileById(healthFileId);
			bloodSuger.setAppUserID(healthFileId+"--"+healthFile.getIdNum());
			if(bloodSuger.getAnalysisResult()==null||bloodSuger.getBloodSugar()==0
					||bloodSuger.getMeaTime()==null){
				return "toEditBSCloud";
			}
			// 修改血糖数据，返回反馈信息
			message = healthManagerService.updateBSCloud(cloudId, bloodSuger);
			return "bloodSugerDataDetailRed";
		}

		/**
		 * 删除自己上传的血糖数据
		 * @return
		 */
		public String deleteBloodSugerDataCloud(){
			if(checkAddressHealthFileId(healthFileId).equals("error")){
				return "error";
			}
			message = healthManagerService.deleteBSCloud(cloudId); 
			return "bloodSugerDataDetailRed";
		}
		
		/*****************************以下为工具方法*********************************************************/
			/**
			 *       张晓光
			 * 自己使用的工具方法 ,用于比较字符串类型的日期是否在另外两个字符串日期中间
			 * @param reallyTime 传入的真实时间
			 * @param bloorTime 下限时间
			 * @param ceilTime 上限时间
			 * @return 返回真假
			 */
		public boolean compareTime(String reallyTime, String bloorTime,
				String ceilTime) {

			String[] timeBuffer = reallyTime.split(" ");
			bloorTime = timeBuffer[0] + " " + bloorTime; // 构造日期类型的字符串
			ceilTime = timeBuffer[0] + " " + ceilTime;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			Date date1 = null, date2 = null, date3 = null;
			try {
				date1 = sdf.parse(reallyTime); // 将字符串转换成日期类型
				date2 = sdf.parse(bloorTime);
				date3 = sdf.parse(ceilTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (date2.before(date1) && date1.before(date3)) { // 判断
				return true;
			}
			return false;
		}

	
			/**
			 * 对各血糖测量状态的排序
			 * @param bloodSugers 要排序的list
			 */
			public void sort(List<BloodSuger> bloodSugers,String sortParams){
				if(sortParams.equals("血糖值")){
					Collections.sort(bloodSugers, new Comparator<BloodSuger>(){
						@Override
						public int compare(BloodSuger o1,
								BloodSuger o2) {
							if(o1.getBloodSugar()<o2.getBloodSugar()){
								return 1;
							}else if(o1.getBloodSugar()>o2.getBloodSugar()){
								return -1;
							}else{
								return 0;
							}
						}
				  });
				}
			    if(sortParams.equals("测量时间")){
			    	Collections.sort(bloodSugers, new Comparator<BloodSuger>(){
						@Override
						public int compare(BloodSuger o1,
								BloodSuger o2) {
							Date time1 = TypeConverter.convertString2Date(o1.getMeaTime(),"yyyy-MM-dd HH:mm:ss");
							Date time2 = TypeConverter.convertString2Date(o2.getMeaTime(),"yyyy-MM-dd HH:mm:ss");
							if(time2.before(time1)){
								return 1;
							}else if(time2.after(time1)){
								return -1;
							}else{
								return 0;
							}
						}
				  });
			    }
			}
			/**
			 * 求list中的血糖平均值
			 * @param bloodSugers 血糖列表
			 * @return
			 */
			public double getBloodSugerAvg(List<BloodSuger> bloodSugers) throws Exception{
				  double sumSuger = 0;
				  for (BloodSuger bloodSuger : bloodSugers) {
					     sumSuger += bloodSuger.getBloodSugar();
				  }
				  return sumSuger / bloodSugers.size();
			}
			
			/**
			 * 根据传入的实体，返回可以在前台进行趋势展示的字符串
			 * @param bloodSugers
			 * @return
			 */
			public List<String> getXAxisAndYAxis(List<BloodSuger> bloodSugers){
				
				StringBuilder xAxisBuilder = new StringBuilder();
				StringBuilder yAxisBuilder = new StringBuilder();
				for (BloodSuger bloodSuger : bloodSugers) {
					
						xAxisBuilder.append("'"+bloodSuger.getMeaTime()+"'");
						xAxisBuilder.append(",");
						yAxisBuilder.append(bloodSuger.getBloodSugar());
						yAxisBuilder.append(",");
					}
				xAxisBuilder.deleteCharAt(xAxisBuilder.length()-1);
				yAxisBuilder.deleteCharAt(yAxisBuilder.length()-1);
				List<String> axis = new ArrayList<String>();
				axis.add("["+xAxisBuilder+"]");
				axis.add("["+yAxisBuilder+"]");
				return axis;
			}
			
	/**
	 ************************** 赖清发 8-14  糖尿病管理导出 ********************** */
			public String checkAddressHealthFileId(int healthFileId){
				 HttpSession session = ServletActionContext.getRequest().getSession();
				 TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
				 if(group!=null){
					 if(!healthFileService.isGroupOld(healthFileId, group.getGId())){
						 return "error";
					 }
				 }
				else{
				//获取当前登录用户
				int person=GetSessionPerson.getPerson();
				if(person<0){
					if (oldStaffHosService.oldInHos(healthFileId, Math.abs(person))==false) {
						return "error";
					}
				}
				if(person>0){
					//责任医生
					if(healthFileService.getOldStaffHosByStaffId(person)){
						//判断老人在不在责任医生和该社区下
						if (!oldStaffHosService.oldInSpecialHos(healthFileId, person)) {
							return "error";
						 }
					}
				  }
			   }
				return "pass";
			}
			
	
			public String diabeteExport() throws Exception{	
				//获取当前登录用户
				int person=GetSessionPerson.getPerson();
				
				//DiabeteExport diabeteExport=null;
				if(exportFlag==1){//导出本页
					List<DiabeteExport> diabeteExports = new ArrayList<DiabeteExport>();
					if(ids!=null){
					for(int i=0;i<ids.length;i++){
						vchronic=chronicDiseaseService.getVChronicByChronicDiseaseId(ids[i]);
						if(vchronic!=null){
							DiabeteExport diabeteExport=new DiabeteExport(vchronic);
							diabeteExports.add(diabeteExport);
						}
					}
					}
					HttpServletResponse response = ServletActionContext.getResponse();
					response.setHeader("content-disposition", "attachment;filename="+3+".xls");
					ServletOutputStream output = response.getOutputStream();
					DiabeteExport diabeteExport0=new DiabeteExport();
					String[] titles=diabeteExport0.getTitles();
					JxlExcel he = new JxlExcel(titles);
					he.write(diabeteExports, output);
					response.flushBuffer();
				}
				if(exportFlag==2){//导出全部
					if(person==0){
						vclist=chronicDiseaseService.getAdminChronicManager(HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.DIABETE_MANAGER.getValue());
					}else if(person<0){
						vclist=chronicDiseaseService.getChronicManager(Math.abs(person), HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.DIABETE_MANAGER.getValue());
					}
					else{
						int hosId=staffService.getCommHospitalByStaffId(person);
						//责任医生
						if(healthFileService.getOldStaffHosByStaffId(person)){
							vclist=chronicDiseaseService.getallDiabeteManagerSpecialNoPage(hosId,person, HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.DIABETE_MANAGER.getValue());
						}
						//医生护士
						else {
							vclist=chronicDiseaseService.getChronicManager(person, HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.DIABETE_MANAGER.getValue());
						}
					}
					List<DiabeteExport> diabeteExports = new ArrayList<DiabeteExport>();
					String[] titles=(new DiabeteExport()).getTitles();//新添
					for(VChronic vc: vclist){
						if(vc != null){
							DiabeteExport diabeteExport = new DiabeteExport(vc);
							diabeteExports.add(diabeteExport);
						}
					}
					HttpServletResponse response = ServletActionContext.getResponse();
					response.setHeader("content-disposition", "attachment;filename="+1+".xls");
					ServletOutputStream output = response.getOutputStream();
					DiabeteExport db =new DiabeteExport();
					//String [] titles = db.getTitles();
					JxlExcel he = new JxlExcel(titles);
					he.write(diabeteExports, output);
					response.flushBuffer();
				}
				return   null;
			}

///////////////////////// 导出高血压              黄仕鑫 ///////////////////////////////////////////////////////////////////
    public String function() throws  Exception{
    	//获取当前登录用户
    	int person=GetSessionPerson.getPerson();
    	
    	if(exportFlag==1){//导出本页
		  	 List<highBloodExport>  hbExport=new ArrayList<highBloodExport>();
		  	 if(ids!=null){
		  		 for(int i=0;i<ids.length;i++){
		  			 VChronic vc=chronicDiseaseService.getVChronicByChronicDiseaseId(ids[i]);
		  			 if(vc!=null){
		  				 highBloodExport hBloodExport=new highBloodExport(vc);
		  				 hbExport.add(hBloodExport);
		  			 }
		  		 }
		  	 }
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setHeader("content-disposition", "attachment;filename="+1+".xls");
		ServletOutputStream output = response.getOutputStream();
		highBloodExport hBloodExport=new highBloodExport();
		String [] titles = hBloodExport.getTitles();
		JxlExcel he = new JxlExcel(titles);
		he.write(hbExport, output);
		response.flushBuffer();
	}
		if(exportFlag==2){//导出全部
    		if(person == 0){
    			vclist=chronicDiseaseService.getAdminChronicManager(HealthFileCheck.zhengchang.getValue(),
    					CHRONIC_MANAGER.HIGHBLOODPRESSURE_MANAGER.getValue());
    		}else if(person <0){
    			vclist=chronicDiseaseService.getChronicManager(Math.abs(person), HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.HIGHBLOODPRESSURE_MANAGER.getValue());
    		}
    		else{
				int hosId=staffService.getCommHospitalByStaffId(person);
				//责任医生
				if(healthFileService.getOldStaffHosByStaffId(person)){
					vclist=chronicDiseaseService.getallDiabeteManagerSpecialNoPage(hosId,person, HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.HIGHBLOODPRESSURE_MANAGER.getValue());
				}
				//医生护士
				else {
					vclist=chronicDiseaseService.getChronicManager(person, HealthFileCheck.zhengchang.getValue(), CHRONIC_MANAGER.HIGHBLOODPRESSURE_MANAGER.getValue());
				}
			}
		   List<highBloodExport>  hbList=new ArrayList<highBloodExport>();
		   String[] titles=(new highBloodExport()).getTitles();//新添
		   for(VChronic vc: vclist){
		           if(vc != null){
			          highBloodExport hbe = new highBloodExport(vc);
			           hbList.add(hbe);
		            }
		          }
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("content-disposition", "attachment;filename="+1+".xls");
			ServletOutputStream output = response.getOutputStream();
			highBloodExport hb =new highBloodExport();
			//String[] titles = hb.getTitles();
			JxlExcel he = new JxlExcel(titles);
			he.write(hbList, output);
			response.flushBuffer();
    		}
		 return  null;
    }
    
    
	
	public List<VChronic> getVclist() {
		return vclist;
	}
	public void setVclist(List<VChronic> vclist) {
		this.vclist = vclist;
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


	public String getFileNum() {
		return fileNum;
	}


	public void setFileNum(String fileNum) {
		this.fileNum = fileNum;
	}


	public String getChronicName() {
		return chronicName;
	}


	public void setChronicName(String chronicName) {
		this.chronicName = chronicName;
	}


	public List<TRecoveryPlan> getPlanList() {
		return planList;
	}
	public int getDaId() {
		return daId;
	}

	public void setDaId(int daId) {
		this.daId = daId;
	}

	public void setPlanList(List<TRecoveryPlan> planList) {
		this.planList = planList;
	}


	public List<VChronic> getVcdiabeteList() {
		return vcdiabeteList;
	}

	public void setVcdiabeteList(List<VChronic> vcdiabeteList) {
		this.vcdiabeteList = vcdiabeteList;
	}

	public List<VChronic> getVchighbloodList() {
		return vchighbloodList;
	}

	public void setVchighbloodList(List<VChronic> vchighbloodList) {
		this.vchighbloodList = vchighbloodList;
	}


	public List<TChronicDisease> getNoManagetList() {
		return noManagetList;
	}
	public void setNoManagetList(List<TChronicDisease> noManagetList) {
		this.noManagetList = noManagetList;
	}
	public List<VChronic> getVcnodiabeteList() {
		return vcnodiabeteList;
	}
	public void setVcnodiabeteList(List<VChronic> vcnodiabeteList) {
		this.vcnodiabeteList = vcnodiabeteList;
	}
	public List<Object> getOldids() {
		return oldids;
	}
	public void setOldids(List<Object> oldids) {
		this.oldids = oldids;
	}
	public List<VChronic> getVcnoHighList() {
		return vcnoHighList;
	}
	public void setVcnoHighList(List<VChronic> vcnoHighList) {
		this.vcnoHighList = vcnoHighList;
	}
	public List<VChronic> getVcnoOtherList() {
		return vcnoOtherList;
	}
	public void setVcnoOtherList(List<VChronic> vcnoOtherList) {
		this.vcnoOtherList = vcnoOtherList;
	}
 
	public List<VChronic> getOtherChroniclList() {
		return otherChroniclList;
	}


	public void setOtherChroniclList(List<VChronic> otherChroniclList) {
		this.otherChroniclList = otherChroniclList;
	}
	public AllChronicDiseaseService getChronicDiseaseService() {
		return chronicDiseaseService;
	}
	public void setChronicDiseaseService(
			AllChronicDiseaseService chronicDiseaseService) {
		this.chronicDiseaseService = chronicDiseaseService;
	}
	public HealthFileService getHealthFileService() {
		return healthFileService;
	}
	public void setHealthFileService(HealthFileService healthFileService) {
		this.healthFileService = healthFileService;
	}
	public RecoveryPlanService getRecoveryPlanService() {
		return recoveryPlanService;
	}
	public void setRecoveryPlanService(RecoveryPlanService recoveryPlanService) {
		this.recoveryPlanService = recoveryPlanService;
	}
	public IHealthManagerService getHealthManagerService() {
		return healthManagerService;
	}
	public void setHealthManagerService(IHealthManagerService healthManagerService) {
		this.healthManagerService = healthManagerService;
	}
	public BloodPress getBloodPress() {
		return bloodPress;
	}
	public void setBloodPress(BloodPress bloodPress) {
		this.bloodPress = bloodPress;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getHealthFileId() {
		return healthFileId;
	}
	public void setHealthFileId(int healthFileId) {
		this.healthFileId = healthFileId;
	}
	public int getBloodForward() {
		return bloodForward;
	}
	public void setBloodForward(int bloodForward) {
		this.bloodForward = bloodForward;
	}
	public int getScrollLength() {
		return scrollLength;
	}
	public void setScrollLength(int scrollLength) {
		this.scrollLength = scrollLength;
	}
	public int getSearchType() {
		return searchType;
	}
	public void setSearchType(int searchType) {
		this.searchType = searchType;
	}
	
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Integer getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}
	public int getCloudId() {
		return cloudId;
	}
	public void setCloudId(int cloudId) {
		this.cloudId = cloudId;
	}
	public String getMeaTimeString() {
		return meaTimeString;
	}
	public void setMeaTimeString(String meaTimeString) {
		this.meaTimeString = meaTimeString;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getChronicId() {
		return chronicId;
	}
	public void setChronicId(int chronicId) {
		this.chronicId = chronicId;
	}
	public TRecoveryPlan getRecoveryPlan() {
		return recoveryPlan;
	}
	public void setRecoveryPlan(TRecoveryPlan recoveryPlan) {
		this.recoveryPlan = recoveryPlan;
	}
	public VChronic getVchronic() {
		return vchronic;
	}
	public void setVchronic(VChronic vchronic) {
		this.vchronic = vchronic;
	}
	public TRecoveryPlan getPlan() {
		return plan;
	}
	public void setPlan(TRecoveryPlan plan) {
		this.plan = plan;
	}
	public TRecoveryScheme getTrecoveryScheme() {
		return trecoveryScheme;
	}
	public void setTrecoveryScheme(TRecoveryScheme trecoveryScheme) {
		this.trecoveryScheme = trecoveryScheme;
	}
	public int getSelect() {
		return select;
	}
	public void setSelect(int select) {
		this.select = select;
	}
	public int getScheme() {
		return scheme;
	}
	public void setScheme(int scheme) {
		this.scheme = scheme;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	public String getJsonString() {
		return jsonString;
	}
	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}
	public List<VStaffHos> getStaffHosList() {
		return staffHosList;
	}
	public void setStaffHosList(List<VStaffHos> staffHosList) {
		this.staffHosList = staffHosList;
	}
	public THealthFile getHealthFile() {
		return healthFile;
	}
	public void setHealthFile(THealthFile healthFile) {
		this.healthFile = healthFile;
	}
	public List<TRecoveryPlan> getRecoveryPlanList() {
		return recoveryPlanList;
	}
	public void setRecoveryPlanList(List<TRecoveryPlan> recoveryPlanList) {
		this.recoveryPlanList = recoveryPlanList;
	}
	public List<TRecoveryScheme> getSchemeList() {
		return schemeList;
	}
	public void setSchemeList(List<TRecoveryScheme> schemeList) {
		this.schemeList = schemeList;
	}
	public int[] getIds() {
		return ids;
	}
	public void setIds(int[] ids) {
		this.ids = ids;
	}
	
	public int getExportFlag() {
		return exportFlag;
	}

	public void setExportFlag(int exportFlag) {
		this.exportFlag = exportFlag;
	}

	public int getPlanId() {
		return planId;
	}
	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public ICommunityHospitalService getCommunityHospitalService() {
		return communityHospitalService;
	}

	public void setCommunityHospitalService(
			ICommunityHospitalService communityHospitalService) {
		this.communityHospitalService = communityHospitalService;
	}

	public IRecoverySchemeService getRecoverySchemeService() {
		return recoverySchemeService;
	}

	public void setRecoverySchemeService(
			IRecoverySchemeService recoverySchemeService) {
		this.recoverySchemeService = recoverySchemeService;
	}

	public StaffService getStaffService() {
		return staffService;
	}

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}

	public int getSqid() {
		return sqid;
	}

	public void setSqid(int sqid) {
		this.sqid = sqid;
	}
	public String getSchemeString() {
		return schemeString;
	}
	public void setSchemeString(String schemeString) {
		this.schemeString = schemeString;
	}
	public TCommunityHospital getCommunityHospital() {
		return communityHospital;
	}
	public void setCommunityHospital(TCommunityHospital communityHospital) {
		this.communityHospital = communityHospital;
	}

	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public int getPlanState() {
		return planState;
	}
	public void setPlanState(int planState) {
		this.planState = planState;
	}

	public List<TRecoveryOld> getRecoveryOldList() {
		return recoveryOldList;
	}

	public void setRecoveryOldList(List<TRecoveryOld> recoveryOldList) {
		this.recoveryOldList = recoveryOldList;
	}
	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public OldStaffHosService getOldStaffHosService() {
		return oldStaffHosService;
	}

	public void setOldStaffHosService(OldStaffHosService oldStaffHosService) {
		this.oldStaffHosService = oldStaffHosService;
	}

	public TStaff getTstaff() {
		return tstaff;
	}

	public void setTstaff(TStaff tstaff) {
		this.tstaff = tstaff;
	}

	public BloodSuger getBloodSuger() {
		return bloodSuger;
	}

	public void setBloodSuger(BloodSuger bloodSuger) {
		this.bloodSuger = bloodSuger;
	}


	public List<Double> getBloodSugerMax() {
		return bloodSugerMax;
	}

	public void setBloodSugerMax(List<Double> bloodSugerMax) {
		this.bloodSugerMax = bloodSugerMax;
	}

	public List<Double> getBloodSugerMin() {
		return bloodSugerMin;
	}

	public void setBloodSugerMin(List<Double> bloodSugerMin) {
		this.bloodSugerMin = bloodSugerMin;
	}

	public List<Double> getBloodSugerAvg() {
		return bloodSugerAvg;
	}

	public void setBloodSugerAvg(List<Double> bloodSugerAvg) {
		this.bloodSugerAvg = bloodSugerAvg;
	}

	

	
	public String getJsons() {
		return jsons;
	}
	public void setJsons(String jsons) {
		this.jsons = jsons;
	}
	public String getXAxis() {
		return xAxis;
	}

	public void setXAxis(String xAxis) {
		this.xAxis = xAxis;
	}

	public String getYAxisHigh() {
		return yAxisHigh;
	}

	public void setYAxisHigh(String yAxisHigh) {
		this.yAxisHigh = yAxisHigh;
	}

	public String getYAxisLow() {
		return yAxisLow;
	}

	public void setYAxisLow(String yAxisLow) {
		this.yAxisLow = yAxisLow;
	}
	public String getYAxisPulse() {
		return yAxisPulse;
	}

	public void setYAxisPulse(String yAxisPulse) {
		this.yAxisPulse = yAxisPulse;
	}
	public String getxAxis() {
		return xAxis;
	}
	public void setxAxis(String xAxis) {
		this.xAxis = xAxis;
	}
	public String getyAxisHigh() {
		return yAxisHigh;
	}
	public void setyAxisHigh(String yAxisHigh) {
		this.yAxisHigh = yAxisHigh;
	}
	public String getyAxisLow() {
		return yAxisLow;
	}
	public void setyAxisLow(String yAxisLow) {
		this.yAxisLow = yAxisLow;
	}
	public String getyAxisPulse() {
		return yAxisPulse;
	}
	public void setyAxisPulse(String yAxisPulse) {
		this.yAxisPulse = yAxisPulse;
	}
	
	public String getXaxisBb() {
		return xaxisBb;
	}
	public void setXaxisBb(String xaxisBb) {
		this.xaxisBb = xaxisBb;
	}
	public String getYaxisBb() {
		return yaxisBb;
	}
	public void setYaxisBb(String yaxisBb) {
		this.yaxisBb = yaxisBb;
	}
	public String getXaxisAb() {
		return xaxisAb;
	}
	public void setXaxisAb(String xaxisAb) {
		this.xaxisAb = xaxisAb;
	}
	public String getYaxisAb() {
		return yaxisAb;
	}
	public void setYaxisAb(String yaxisAb) {
		this.yaxisAb = yaxisAb;
	}
	public String getXaxisBl() {
		return xaxisBl;
	}
	public void setXaxisBl(String xaxisBl) {
		this.xaxisBl = xaxisBl;
	}
	public String getYaxisBl() {
		return yaxisBl;
	}
	public void setYaxisBl(String yaxisBl) {
		this.yaxisBl = yaxisBl;
	}
	public String getXaxisAl() {
		return xaxisAl;
	}
	public void setXaxisAl(String xaxisAl) {
		this.xaxisAl = xaxisAl;
	}
	public String getYaxisAl() {
		return yaxisAl;
	}
	public void setYaxisAl(String yaxisAl) {
		this.yaxisAl = yaxisAl;
	}
	public String getXaxisBd() {
		return xaxisBd;
	}
	public void setXaxisBd(String xaxisBd) {
		this.xaxisBd = xaxisBd;
	}
	public String getYaxisBd() {
		return yaxisBd;
	}
	public void setYaxisBd(String yaxisBd) {
		this.yaxisBd = yaxisBd;
	}
	public String getXaxisAd() {
		return xaxisAd;
	}
	public void setXaxisAd(String xaxisAd) {
		this.xaxisAd = xaxisAd;
	}
	public String getYaxisAd() {
		return yaxisAd;
	}
	public void setYaxisAd(String yaxisAd) {
		this.yaxisAd = yaxisAd;
	}
	public String getXaxisBs() {
		return xaxisBs;
	}
	public void setXaxisBs(String xaxisBs) {
		this.xaxisBs = xaxisBs;
	}
	public String getYaxisBs() {
		return yaxisBs;
	}
	public void setYaxisBs(String yaxisBs) {
		this.yaxisBs = yaxisBs;
	}
	public Page<VChronic> getPage() {
		return page;
	}
	public void setPage(Page<VChronic> page) {
		this.page = page;
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
	
	public List<BloodPress> getBloodPresseList() {
		return bloodPresseList;
	}
	public void setBloodPresseList(List<BloodPress> bloodPresseList) {
		this.bloodPresseList = bloodPresseList;
	}
	public List<BloodSuger> getBloodSugerList() {
		return bloodSugerList;
	}
	public void setBloodSugerList(List<BloodSuger> bloodSugerList) {
		this.bloodSugerList = bloodSugerList;
	}
	public BloodPressCloud getBloodPressCloud() {
		return bloodPressCloud;
	}
	public void setBloodPressCloud(BloodPressCloud bloodPressCloud) {
		this.bloodPressCloud = bloodPressCloud;
	}
	public BloodSugerCloud getBloodSugerCloud() {
		return bloodSugerCloud;
	}
	public void setBloodSugerCloud(BloodSugerCloud bloodSugerCloud) {
		this.bloodSugerCloud = bloodSugerCloud;
	}
	public List<BloodPress> getBloodPresses() {
		return bloodPresses;
	}
	public void setBloodPresses(List<BloodPress> bloodPresses) {
		this.bloodPresses = bloodPresses;
	}
	public void setIssq(int issq) {
		this.issq = issq;
	}
	
	public int getRecoveryPlanId() {
		return recoveryPlanId;
	}
	public void setRecoveryPlanId(int recoveryPlanId) {
		this.recoveryPlanId = recoveryPlanId;
	}
	public List<TCommunityHospital> getHospitals() {
		return hospitals;
	}
	public void setHospitals(List<TCommunityHospital> hospitals) {
		this.hospitals = hospitals;
	}
	public String getAppUserID() {
		return appUserID;
	}
	public void setAppUserID(String appUserID) {
		this.appUserID = appUserID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMeaState() {
		return meaState;
	}
	public void setMeaState(int meaState) {
		this.meaState = meaState;
	}
	public Double getDiaPre() {
		return diaPre;
	}
	public void setDiaPre(Double diaPre) {
		this.diaPre = diaPre;
	}
	public Double getSysPre() {
		return sysPre;
	}
	public void setSysPre(Double sysPre) {
		this.sysPre = sysPre;
	}
	public Integer getPulse() {
		return pulse;
	}
	public void setPulse(Integer pulse) {
		this.pulse = pulse;
	}
	public int getArm() {
		return arm;
	}
	public void setArm(int arm) {
		this.arm = arm;
	}
	public String getMeaTime() {
		return meaTime;
	}
	public void setMeaTime(String meaTime) {
		this.meaTime = meaTime;
	}
	public Date getMeatime() {
		return meatime;
	}
	public void setMeatime(Date meatime) {
		this.meatime = meatime;
	}
	public int getDevID() {
		return devID;
	}
	public void setDevID(int devID) {
		this.devID = devID;
	}
	public int getTakeMed() {
		return takeMed;
	}
	public void setTakeMed(int takeMed) {
		this.takeMed = takeMed;
	}
	public String getMedName() {
		return medName;
	}
	public void setMedName(String medName) {
		this.medName = medName;
	}
	public double getBloodSugar() {
		return bloodSugar;
	}
	public void setBloodSugar(double bloodSugar) {
		this.bloodSugar = bloodSugar;
	}
	public String getAbnAlarm() {
		return abnAlarm;
	}
	public void setAbnAlarm(String abnAlarm) {
		this.abnAlarm = abnAlarm;
	}
	public String getAnalysisResult() {
		return analysisResult;
	}
	public void setAnalysisResult(String analysisResult) {
		this.analysisResult = analysisResult;
	}
	public List<TStaff> getSpecialDoctor() {
		return specialDoctor;
	}
	public void setSpecialDoctor(List<TStaff> specialDoctor) {
		this.specialDoctor = specialDoctor;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public List<TCommunityHospitalGroup> getGroups() {
		return groups;
	}
	public void setGroups(List<TCommunityHospitalGroup> groups) {
		this.groups = groups;
	}
	public int getIssq() {
		return issq;
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

}
