package com.jmjk.action;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.itextpdf.text.log.SysoCounter;
import com.jmjk.action.base.BaseAction;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.THealthFile;
import com.jmjk.entity.TOldStaffHos;
import com.jmjk.entity.TPhysicalExam;
import com.jmjk.entity.TRecoveryOld;
import com.jmjk.entity.TRecoveryPlan;
import com.jmjk.entity.TRecoveryScheme;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.view.VHealthStaff;
import com.jmjk.entity.view.VMaintainable;
import com.jmjk.entity.view.VOldStaff;
import com.jmjk.entity.view.VStaffHos;
import com.jmjk.enums.Admin_IsHead;
import com.jmjk.enums.HealthFileCheck;
import com.jmjk.enums.IS_DELETE;
import com.jmjk.enums.RecoveryPlanStatus;
import com.jmjk.iservice.ICommunityHospitalGroupService;
import com.jmjk.iservice.ICommunityHospitalService;
import com.jmjk.iservice.IHealthFileService;
import com.jmjk.iservice.IHealthManagerService;
import com.jmjk.iservice.IMaintainableEntryService;
import com.jmjk.iservice.IPhysicalExamService;
import com.jmjk.iservice.IRecoveryPlanService;
import com.jmjk.iservice.IRecoverySchemeService;
import com.jmjk.pojo.AllInOne;
import com.jmjk.pojo.AllInOneCloud;
import com.jmjk.pojo.BloodOxygen;
import com.jmjk.pojo.BloodOxygenCloud;
import com.jmjk.pojo.BloodPress;
import com.jmjk.pojo.BloodPressCloud;
import com.jmjk.pojo.BloodSuger;
import com.jmjk.pojo.BloodSugerCloud;
import com.jmjk.pojo.HealthFileCloud;
import com.jmjk.pojo.HealthFileSingleCloud;
import com.jmjk.pojo.HealthPhysicEx;
import com.jmjk.pojo.HealthSuggest;
import com.jmjk.pojo.PhysicExemSingle;
import com.jmjk.pojo.Suggest;
import com.jmjk.service.OldStaffHosService;
import com.jmjk.service.StaffService;
import com.jmjk.utils.GetSessionPerson;
import com.jmjk.utils.PDFUtils;
import com.jmjk.utils.Page;
import com.jmjk.utils.Resubmit;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.TokenProccessor;
import com.jmjk.utils.TypeConverter;
import com.jmjk.utils.UploadAndDownload;
import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * 
 * @author 张晓光 2016-8-27
 */
@Component
@Scope("prototype")
@Action(value = "HealthManagerAction", results = {
		@Result(name = "filelist", location = "/jsp/healthManager/filelist.jsp"),  //数据录入页面
		@Result(name = "searchUploadHealthFile", location = "/jsp/healthManager/filelist.jsp"),
		@Result(name = "toUploadData", location = "/jsp/healthManager/uploadData.jsp"),
		@Result(name = "toUploadDataRed", type = "redirectAction", location = "HealthManagerAction!toUploadData.action", params = {"healthFileId", "${healthFileId}" }),
		@Result(name = "uploadBloodPressData", location = "/jsp/healthManager/uploadData.jsp"),
		@Result(name = "uploadBloodSugerData", location = "/jsp/healthManager/uploadData.jsp"),
		@Result(name = "uploadBloodOxygen", location = "/jsp/healthManager/uploadData.jsp"),
		@Result(name = "getDataFromCloud", location = "/jsp/healthManager/scloudData.jsp"),
		@Result(name = "getBloodPressFromCloud0", location = "/jsp/healthManager/bloodPress/bloodpressdataAnalysis.jsp"),
		@Result(name = "getBloodPressFromCloud1", location = "/jsp/healthManager/bloodPress/bloodpresstendAnalysis.jsp"),
		@Result(name = "getBloodPressFromCloud2", location = "/jsp/healthManager/bloodPress/bloodpressdataDetail.jsp"),
		@Result(name = "getBloodPressFromCloud3", location = "/jsp/healthManager/bloodPress/bloodpressrecoverPlan.jsp"),
		@Result(name = "getBloodPressFromCloudAdvice0", location = "/jsp/healthManager/healthAdvice/bloodPress/bloodpressdataAnalysis.jsp"),
		@Result(name = "getBloodPressFromCloudAdvice1", location = "/jsp/healthManager/healthAdvice/bloodPress/bloodpresstendAnalysis.jsp"),
		@Result(name = "getBloodPressFromCloudAdvice2", location = "/jsp/healthManager/healthAdvice/bloodPress/bloodpressdataDetail.jsp"),
		@Result(name = "getBloodPressFromCloudAdvice3", location = "/jsp/healthManager/healthAdvice/bloodPress/bloodpressrecoverPlan.jsp"),
		
		@Result(name = "bloodPressDataAnalysis", location = "/jsp/healthManager/bloodPress/bloodpressdataAnalysis.jsp"),
		@Result(name = "bloodPressTendAnalysis", location = "/jsp/healthManager/bloodPress/bloodpresstendAnalysis.jsp"),
		@Result(name = "deleteBloodPressDataCloud", type = "redirectAction", location = "HealthManagerAction!bloodPressDataDetail.action", params = {"healthFileId", "${healthFileId}", "message", "${message}" }),
		@Result(name = "toEditBPCloud", location = "/jsp/healthManager/bloodPress/editBloodPress.jsp"),
		@Result(name = "editBPCloud", type = "redirectAction", location = "HealthManagerAction!bloodPressDataDetail.action", params = {"healthFileId", "${healthFileId}" }),
		@Result(name = "bloodPressDataDetail", location = "/jsp/healthManager/bloodPress/bloodpressdataDetail.jsp"),
		@Result(name = "bloodPressDataDetailRed", type = "redirectAction", location = "HealthManagerAction!getBloodPressFromCloud.action", params = {"healthFileId", "${healthFileId}", "bloodForward", "2" ,"embeded","${embeded}"}),
		
		@Result(name = "bloodPressDataAnalysisAdvice", location = "/jsp/healthManager/healthAdvice/bloodPress/bloodpressdataAnalysis.jsp"),
		@Result(name = "bloodPressTendAnalysisAdvice", location = "/jsp/healthManager/healthAdvice/bloodPress/bloodpresstendAnalysis.jsp"),
		@Result(name = "deleteBloodPressDataCloudAdvice", type = "redirectAction", location = "HealthManagerAction!bloodPressDataDetail.action", params = {"healthFileId", "${healthFileId}", "message", "${message}" }),
		@Result(name = "toEditBPCloudAdvice", location = "/jsp/healthManager/healthAdvice/bloodPress/editBloodPress.jsp"),
		@Result(name = "bloodPressDataDetailAdvice", location = "/jsp/healthManager/healthAdvice/bloodPress/bloodpressdataDetail.jsp"),
		
		
		@Result(name = "bloodOxygenTendAnalysisRed", type = "redirectAction", location = "HealthManagerAction!bloodOxygenTendAnalysis.action", params = {"healthFileId", "${healthFileId}", "bloodForward", "1" }),
		@Result(name = "bloodSugerTendAnalysisRed", type = "redirectAction", location = "HealthManagerAction!bloodOxygenTendAnalysis.action", params = {"healthFileId", "${healthFileId}", "bloodForward", "1" }),
		@Result(name = "allInOneTendAnalysisRed", type = "redirectAction", location = "HealthManagerAction!bloodOxygenTendAnalysis.action", params = {"healthFileId", "${healthFileId}", "bloodForward", "1" }),
		
		@Result(name = "searchbloodPressRecoverPlan", location = "/jsp/healthManager/bloodPress/bloodpressrecoverPlan.jsp"),
		@Result(name = "toAddBPRecoverPlan", location = "/jsp/healthManager/addRecoverPlan.jsp"),
		@Result(name = "toAddBPRecoverPlanRed", type = "redirectAction", location = "HealthManagerAction!toAddBPRecoverPlan.action", params = {"healthFileId", "${healthFileId}" }),
		@Result(name = "changePlanStatus", location = "HealthManagerAction!searchBloodPressRecoverPlan.action", type = "redirectAction", params = {"diseaseName", "${diseaseName}", "healthFileId","${healthFileId}" }),
		@Result(name = "addBPRecoverPlan", type = "redirectAction", location = "HealthManagerAction!getBloodPressFromCloud.action", params = {"healthFileId", "${healthFileId}", "bloodForward", "3" ,"embeded","${embeded}"}),
		@Result(name = "changeStatesRecoverPlan", type = "redirectAction", location = "HealthManagerAction!getBloodPressFromCloud.action", params = {"healthFileId", "${healthFileId}", "bloodForward", "3","embeded","${embeded}" }),
		@Result(name = "getBloodSugerFromCloud0", location = "/jsp/healthManager/bloodSuger/bloodSugerDataAnalysis.jsp"),
		@Result(name = "getBloodSugerFromCloud1", location = "/jsp/healthManager/bloodSuger/bloodSugerTendAnalysis.jsp"),
		@Result(name = "getBloodSugerFromCloud2", location = "/jsp/healthManager/bloodSuger/bloodSugerDataDetail.jsp"),
		@Result(name = "getBloodSugerFromCloud3", location = "/jsp/healthManager/bloodSuger/bloodSugerRecoverPlan.jsp"),
		@Result(name = "getBloodSugerFromCloudAdvice0", location = "/jsp/healthManager/healthAdvice/bloodSuger/bloodSugerDataAnalysis.jsp"),
		@Result(name = "getBloodSugerFromCloudAdvice1", location = "/jsp/healthManager/healthAdvice/bloodSuger/bloodSugerTendAnalysis.jsp"),
		@Result(name = "getBloodSugerFromCloudAdvice2", location = "/jsp/healthManager/healthAdvice/bloodSuger/bloodSugerDataDetail.jsp"),
		@Result(name = "getBloodSugerFromCloudAdvice3", location = "/jsp/healthManager/healthAdvice/bloodSuger/bloodSugerRecoverPlan.jsp"),
		
		@Result(name = "bloodSugerDataAnalysis", location = "/jsp/healthManager/bloodSuger/bloodSugerDataAnalysis.jsp"),
		@Result(name = "bloodSugerDataAnalysisAdvice", location = "/jsp/healthManager/healthAdvice/bloodSuger/bloodSugerDataAnalysis.jsp"),
		@Result(name = "deleteBloodSugerDataCloud", type = "redirectAction", location = "HealthManagerAction!bloodSugerDataDetail.action", params = {"healthFileId", "${healthFileId}", "message", "${message}" }),
		@Result(name = "bloodSugerTendAnalysis", location = "/jsp/healthManager/bloodSuger/bloodSugerTendAnalysis.jsp"),
		@Result(name = "bloodSugerTendAnalysisAdvice", location = "/jsp/healthManager/healthAdvice/bloodSuger/bloodSugerTendAnalysis.jsp"),
		@Result(name = "bloodSugerDataDetail", location = "/jsp/healthManager/bloodSuger/bloodSugerDataDetail.jsp"),
		@Result(name = "bloodSugerDataDetailAdvice", location = "/jsp/healthManager/healthAdvice/bloodSuger/bloodSugerDataDetail.jsp"),
		@Result(name = "toEditBSCloud", location = "/jsp/healthManager/bloodSuger/editBloodSuger.jsp"),
		@Result(name = "toEditBSCloudAdvice", location = "/jsp/healthManager/healthAdvice/bloodSuger/editBloodSuger.jsp"),
		@Result(name = "editBSCloud", type = "redirectAction", location = "HealthManagerAction!bloodSugerDataDetail.action", params = {"healthFileId", "${healthFileId}", "message", "${message}" }),
		
		@Result(name = "deleteBloodSugerPlan", type = "redirectAction", location = "HealthManagerAction!getBloodSugerFromCloud.action", params = {"healthFileId", "${healthFileId}", "bloodForward", "3" }),
		@Result(name = "bloodSugerDataDetailRed", type = "redirectAction", location = "HealthManagerAction!getBloodSugerFromCloud.action", params = {"healthFileId", "${healthFileId}", "bloodForward", "2" ,"embeded","${embeded}"}),
		@Result(name = "bloodOxygenDataDetailRed", type = "redirectAction", location = "HealthManagerAction!getBloodOxygenFromCloud.action", params = {"healthFileId", "${healthFileId}", "bloodForward", "2" }),
		@Result(name = "allInOneDataDetailRed", type = "redirectAction", location = "HealthManagerAction!getAllInOneFromCloud.action", params = {"healthFileId", "${healthFileId}", "bloodForward", "2" }),
		@Result(name = "bloodSugerPlanInfo", location = "/jsp/healthManager/bloodSuger/infoRecoveryPlan.jsp"),
		@Result(name = "bloodPressPlanInfo", location = "/jsp/healthManager/bloodPress/infoRecoveryPlan.jsp"),
		
		@Result(name = "searchbloodSugerRecoverPlan", location = "/jsp/healthManager/bloodSuger/bloodSugerRecoverPlan.jsp"),
		@Result(name = "getBloodOxygenFromCloud0", location = "/jsp/healthManager/bloodOxygen/bloodOxygenDataAnalysis.jsp"),
		@Result(name = "getBloodOxygenFromCloud1", location = "/jsp/healthManager/bloodOxygen/bloodOxygenTendAnalysis.jsp"),
		@Result(name = "getBloodOxygenFromCloud2", location = "/jsp/healthManager/bloodOxygen/bloodOxygenDataDetail.jsp"),
		@Result(name = "getBloodOxygenFromCloudAdvice0", location = "/jsp/healthManager/healthAdvice/bloodOxygen/bloodOxygenDataAnalysis.jsp"),
		@Result(name = "getBloodOxygenFromCloudAdvice1", location = "/jsp/healthManager/healthAdvice/bloodOxygen/bloodOxygenTendAnalysis.jsp"),
		@Result(name = "getBloodOxygenFromCloudAdvice2", location = "/jsp/healthManager/healthAdvice/bloodOxygen/bloodOxygenDataDetail.jsp"),
		
		@Result(name = "bloodOxygenDataAnalysis", location = "/jsp/healthManager/bloodOxygen/bloodOxygenDataAnalysis.jsp"),
		@Result(name = "bloodOxygenDataAnalysisAdvice", location = "/jsp/healthManager/healthAdvice/bloodOxygen/bloodOxygenDataAnalysis.jsp"),
		@Result(name = "bloodOxygenTendAnalysis", location = "/jsp/healthManager/bloodOxygen/bloodOxygenTendAnalysis.jsp"),
		@Result(name = "bloodOxygenTendAnalysisAdvice", location = "/jsp/healthManager/healthAdvice/bloodOxygen/bloodOxygenTendAnalysis.jsp"),
		@Result(name = "bloodOxygenDataDetail", location = "/jsp/healthManager/bloodOxygen/bloodOxygenDataDetail.jsp"),
		@Result(name = "bloodOxygenDataDetailAdvice", location = "/jsp/healthManager/healthAdvice/bloodOxygen/bloodOxygenDataDetail.jsp"),
		@Result(name = "deleteBloodOxygenDataCloud", type = "redirectAction", location = "HealthManagerAction!bloodOxygenDataDetail.action", params = {"healthFileId", "${healthFileId}", "message", "${message}" }),
		@Result(name = "editBOCloud", type = "redirectAction", location = "HealthManagerAction!bloodOxygenDataDetail.action", params = {"healthFileId", "${healthFileId}", "message", "${message}" }),
		@Result(name = "toEditBOCloud", location = "/jsp/healthManager/bloodOxygen/editBloodOxygen.jsp"),
		@Result(name = "toEditBOCloudAdvice", location = "/jsp/healthManager/healthAdvice/bloodOxygen/editBloodOxygen.jsp"),
		
		@Result(name = "getPhysicalExamByHealthFileId", location = "/jsp/healthManager/allInOne/physicalExam.jsp"),
		@Result(name = "getPhysicalExamByHealthFileIdAdvice", location = "/jsp/healthManager/healthAdvice/allInOne/physicalExam.jsp"),
		@Result(name = "getAllInOneData", location = "/jsp/healthManager/allInOne/allInOneData.jsp"),
		@Result(name = "getAllInOneDataAdvice", location = "/jsp/healthManager/healthAdvice/allInOne/allInOneData.jsp"),
		@Result(name = "getAllInOneFromCloud0", location = "/jsp/healthManager/allInOne/allInOneDataAnalysis.jsp"),
		@Result(name = "getAllInOneFromCloud1", location = "/jsp/healthManager/allInOne/allInOneTendAnalysis.jsp"),
		@Result(name = "getAllInOneFromCloud2", location = "/jsp/healthManager/allInOne/allInOneDataDetail.jsp"),
		@Result(name = "getAllInOneFromCloudAdvice0", location = "/jsp/healthManager/healthAdvice/allInOne/allInOneDataAnalysis.jsp"),
		@Result(name = "getAllInOneFromCloudAdvice1", location = "/jsp/healthManager/healthAdvice/allInOne/allInOneTendAnalysis.jsp"),
		@Result(name = "getAllInOneFromCloudAdvice2", location = "/jsp/healthManager/healthAdvice/allInOne/allInOneDataDetail.jsp"),
		@Result(name = "allInOneDataAnalysis", location = "/jsp/healthManager/allInOne/allInOneDataAnalysis.jsp"),
		@Result(name = "allInOneDataAnalysisAdvice", location = "/jsp/healthManager/healthAdvice/allInOne/allInOneDataAnalysis.jsp"),
		@Result(name = "allInOneTendAnalysis", location = "/jsp/healthManager/allInOne/allInOneTendAnalysis.jsp"),
		@Result(name = "allInOneTendAnalysisAdvice", location = "/jsp/healthManager/healthAdvice/allInOne/allInOneTendAnalysis.jsp"),
		@Result(name = "allInOneDataDetail", location = "/jsp/healthManager/allInOne/allInOneDataDetail.jsp"),
		@Result(name = "allInOneDataDetailAdvice", location = "/jsp/healthManager/healthAdvice/allInOne/allInOneDataDetail.jsp"),
		@Result(name = "uploadAllInOneRed", type = "redirectAction", location = "HealthManagerAction!getAllInOneData.action", params = {"healthFileId", "${healthFileId}"}),
		@Result(name = "error", location = "/error.jsp"),
		@Result(name = "DataGetFileList", location = "/jsp/healthManager/filelist.jsp"),
		@Result(name = "getHealthFileList", location = "/jsp/healthManager/healthFilelist.jsp"),
		@Result(name = "getHealthFileListRed",type = "redirectAction", location = "HealthDailyCheckAction!getHealthFileList.action",params = {"healthFileId", "${healthFileId}"}),
		
		@Result(name = "suggestList", location = "/jsp/healthManager/suggestList.jsp"),
		@Result(name = "groupFileList", location = "/jsp/healthManager/groupFilelist.jsp"),
		@Result(name = "physicExem", location = "/jsp/healthManager/healthPhysicExm.jsp"),
		@Result(name = "healthPhysicExem", location = "/jsp/healthManager/healthPhysicalExamTable.jsp"),
		@Result(name = "addSuggestsRed",type = "redirectAction", location = "HealthManagerAction!getSuggests.action",params = {"message", "${message}" ,"healthFileId", "${healthFileId}"}),
		@Result(name = "addHealthAdvice", location = "/jsp/healthManager/addHealthAdvice.jsp"),
		@Result(name = "editHealthAdvice", location = "/jsp/healthManager/editHealthAdvice.jsp"),
		@Result(name = "jumpHealthAdviceInfo", location = "/jsp/healthManager/healthAdviceInfo.jsp"),
		@Result(name = "deleteSuggests",type = "redirectAction", location = "HealthManagerAction!getSuggests.action",params = {"healthFileId", "${healthFileId}","userId","${userId}"}),
})

public class HealthManagerAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@Autowired
	private ICommunityHospitalGroupService communityHospitalGroupService;
	@Autowired
	private IHealthFileService healthFileService;
	@Autowired
	private IHealthManagerService healthManagerService;
	@Autowired
	private IMaintainableEntryService maintainableEntryService;
	@Autowired
	private IRecoveryPlanService recoveryPlanService;
	@Autowired
	private IRecoverySchemeService recoverySchemeService;
	@Autowired
	private ICommunityHospitalService communityHospitalService;
	@Autowired
	private IPhysicalExamService physicalExamService;
	@Autowired
	private StaffService staffService;
	@Autowired
	private OldStaffHosService oldStaffHosService;
	private List<VOldStaff> vOldStaffs;
	private VOldStaff voldStaff;
	private int cp = 1;
	private int cp1 = 1;
	private String searflag;
	private String pageHtml;
	private int healthFileId;
	private HealthFileSingleCloud.HealthFile healthFile;
	private BloodPress bloodPress;
	private BloodSuger bloodSuger;
	private BloodOxygen bloodOxygen;
	private List<VMaintainable> vMaintainables;
	private String message;
	private String uploadDataType;
	private Date startTime;
	private Date endTime;
	private int searchType = -1;
	private Integer totalSize;
	private int bloodForward;
	private BloodPressCloud bloodPressCloud;
	private BloodSugerCloud bloodSugerCloud;
	private BloodOxygenCloud bloodOxygenCloud;
	private List<BloodOxygen> bloodOxygens;
	private List<BloodPress> bloodPresses = new ArrayList<BloodPress>();
	private List<BloodPress> bloodPresseList = new ArrayList<BloodPress>();
	private List<BloodSuger> bloodSugerList = new ArrayList<BloodSuger>();
	private List<BloodOxygen> bloodOxygenList = new ArrayList<BloodOxygen>();
	private String xAxis;
	private String yAxisHigh;
	private String yAxisLow;
	private String yAxisPulse;
	private String yAxisOxygen;
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
	private String appUserID;
	private int id;
	private int meaState;
	private Double diaPre;
	private Double sysPre;
	private Integer pulse;
	private int arm;
	private String appKey;
	private String meaTime;
	private Date meatime;
	private int devID;
	private int takeMed;
	private String medName;
	private double bloodSugar;
	private String abnAlarm;
	private String analysisResult;
	private String advice;
	private String guide;
	private double temperature;
	private double fbs;
	private double pbs;
	private double rbs;
	private double height;
	private double weight;
	private double oximeter;
	private String bmia;
	private double fat;
	private double muscle;
	private String oxygen;
	private String jkzd;
	private String jkpj;
	private int scrollLength;
	private int cloudId;
	private String meaTimeString;
	private List<TRecoveryOld> recoveryOldList;
	private String planName;
	private int planState = -1;
	private String diseaseName;
	private String schemaType;
	private Timestamp beginTime;
	private Timestamp overTime;
	private TRecoveryPlan recoveryPlan;
	private List<TRecoveryScheme> schemeList = new ArrayList<TRecoveryScheme>();
	private List<Double> bloodSugerMax;
	private List<Double> bloodSugerMin;
	private List<Double> bloodSugerAvg;
	private TPhysicalExam tPhysicalExam;
	private int recoveryPlanId;
	private String recoverStates;
	private String yAxisFbs;
	private String yAxisPbs;
	private String yAxisRbs;
	private AllInOne allInOne;
	private List<AllInOne> aios;
	private List<AllInOne> bloodAIO;
	private List<AllInOne> sugerAIO;
	private Page<VOldStaff> page;
	private Page<VOldStaff> pagePlus;
	private SearchBean searchbean;
	private List<TStaff> staffs;// 员工表集合
	private List<TStaff> zrstaffs;
	private boolean flag = false;
	private TStaff tuser;
	private int sqid;
	private boolean issetsearch;
	private int[] chlist = null;// 用于多条件查询的慢病种类回显
	private List<TCommunityHospital> hospitals;// 所有社区医院
	//private boolean issq = false;// 判断是否是平台管理员的状态量，用于是否显示社区医院搜索医院选项
	private int issq = 2;// 判断是否是平台管理员的状态量，用于是否显示社区医院搜索医院选项
	private String outPutPath;
	private List<TStaff> specialDoctor;
	private String token;//防止重复提交令牌
	public List<HealthFileCloud.Page.HealthFile> healthFileCloudList;
	public String suggestJson;
	public String doctorAdvice;
	public boolean doctorAdviceSwal;//弹出插件是空值，返回false
	public List<HealthSuggest.Page.Suggest> suggestList;
	public List<HealthPhysicEx.Page.PhysicEx> physicExList;
	public PhysicExemSingle physicExemSingle;
	public int physicalExamId;
	private List<VHealthStaff> vhealthStaffList;
	private List<TCommunityHospitalGroup> groups; 
	//private List<THealthFile> healthFileList;
	private THealthFile localHealthFile;
	private List<VStaffHos> allDoctor;
	private boolean flagPingTai = false;
	private List<VStaffHos> allEnterPeople;
	private int indexFlag=0;
	private String idNum;
	private String localOrClound;
	private String doctorName;
	private String userName;
	private int schema;
	private int suggestId;
	private String createTime;
	private String start;//用于时间回显
	private String end;//用于时间回显
	private String wenti;
	private int userId;
	//用于判断是否嵌入到门诊接诊记录页面 false:没有嵌入，true:嵌入
	private boolean embeded = false;
	
	/**
	 * 查询默认的页面的老人档案列表，进入健康采集首页
	 * 
	 * @return
	 */
	public String getHealthFileList() {
		
		int userId = -1;
		//员工
		TStaff tStaff = (TStaff) ActionContext.getContext().getSession().get("tstaff");
		//社区负责人
		TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext.getContext().getSession().get("comHospital");
		//社区集团负责人
		TCommunityHospitalGroup tCommunityHospitalGroup = (TCommunityHospitalGroup) ActionContext.getContext().getSession().get("communityHospitalGroup");
		// 分页处理
		Page<VOldStaff> page = new Page<VOldStaff>();
		page.setCurrentPage(cp);
		if(tStaff != null){
			int hosId = staffService.getCommHospitalByStaffId(tStaff.getStaffId());
			allDoctor = healthFileService.getAllDoctorByHosId(hosId);
			allEnterPeople = staffService.getAllOperator(hosId);
			staffs = staffService.getStaffByCommunityHospitalId(hosId);
			//责任医生
			if(healthFileService.getOldStaffHosByStaffId(tStaff.getStaffId())){ 
			indexFlag=1;
			flag = true;	
			userId = tStaff.getStaffId();
			page.setTotalNum(healthFileService.countOldStaffByStaff(userId));
			vOldStaffs = healthFileService.getOldStaffsListByStaff(page,
					userId);
			this.pageHtml = page.getPage("HealthManagerAction!getHealthFileList.action");
			return "filelist";
		}
		else{
			page.setTotalNum(healthFileService
					.countOldStaffBycommunityAdmin(hosId));
			vOldStaffs = healthFileService
					.getOldStaffsListBycommunityAdmin(page, hosId);
			flag = true;      //控制建档人是否显示 true不显示
			this.pageHtml = page.getPage("HealthManagerAction!getHealthFileList.action");
			return "filelist";  //非责任医生、社区负责人所看页面
		}
	  }
		//获得医院表里的平台管理员和社区负责人
		else if(tCommunityHospital != null){
			if (tCommunityHospital.getIsHead() == Admin_IsHead.guanliyuan.getValue()) {
				groups = communityHospitalGroupService.getAllGroups();
				//hospitals = communityHospitalService.getAllHospitals();
				issq = 0;//0是平台管理员登陆，1是集团登陆，2是其他登陆
				allDoctor = healthFileService.getAllDoctorByHosId();
				allEnterPeople = staffService.getAllOperator();
				staffs = staffService.getStaffByCommunityHospitalId(tCommunityHospital.getCommunityHospitalId());
				flagPingTai = true;
				indexFlag=1;
				flag = true;
				vOldStaffs = healthFileService.getOldStaffByPlatAdmin(page);
				page.setTotalNum(healthFileService.countStaffByPlatAdmin());
				this.pageHtml = page.getPage("HealthManagerAction!getHealthFileList.action");
				return "filelist";  //非责任医生、社区负责人所看页面
			} 
			//社区负责人
			else {
			userId = tCommunityHospital.getCommunityHospitalId();
			allDoctor = healthFileService.getAllDoctorByHosId(tCommunityHospital.getCommunityHospitalId());
			specialDoctor =healthFileService.getSpeciallDoctor(tCommunityHospital.getCommunityHospitalId());
			allEnterPeople = staffService.getAllOperator(tCommunityHospital.getCommunityHospitalId());
			staffs = staffService.getStaffByCommunityHospitalId(tCommunityHospital.getCommunityHospitalId());
			page.setTotalNum(healthFileService
					.countOldStaffBycommunityAdmin(userId));
			vOldStaffs = healthFileService.getOldStaffsListBycommunityAdmin(
					page, userId);
			this.pageHtml = page.getPage("HealthManagerAction!getHealthFileList.action");
			return "filelist";
		 }
		}
		//集团
		else if(tCommunityHospitalGroup != null){
			issq = 1;//0是平台管理员登陆，1是集团登陆，2是其他登陆
			hospitals = communityHospitalGroupService.getComHosListByGroup(tCommunityHospitalGroup);
			page.setTotalNum(healthFileService.getHealthFileCountGroup(tCommunityHospitalGroup.getGId()));
			vOldStaffs=healthFileService.getAllHealthFileGroup(page, tCommunityHospitalGroup.getGId());
			flagPingTai = true;
			indexFlag=1;
			flag = true;      //控制建档人是否显示 true不显示
			this.pageHtml = page.getPage("HealthManagerAction!getHealthFileList.action");
			return "filelist";
		}
		return "filelist";
	}
	


	/**
	 * 从云平台上根据老人id获取其所用的建议列表
	 * @return
	 */
	public String getSuggests(){//1
		healthFile = healthManagerService.getHealthfileCloudById(Math.abs(healthFileId));
	    HealthSuggest healthSuggest =  (HealthSuggest) ActionContext.getContext().getSession().get("healthSuggest");
		if(healthSuggest == null){
			healthSuggest = this.getSuggestPageInfo(healthFileId,healthFile.getBelongSystem());
			ActionContext.getContext().getSession().put("healthSuggest", healthSuggest);
		}
		Page<HealthSuggest.Page.Suggest> page = new Page<HealthSuggest.Page.Suggest>();
	    String resultJson = healthManagerService.getSuggestsByHealthFileId(userId,healthFile.getBelongSystem(),cp,page.getPageSize());
	    healthSuggest = JSON.parseObject(resultJson,HealthSuggest.class);
		page.setCurrentPage(cp);
		page.setTotalNum(healthSuggest.getPage().getTotal());
		page.setPageSize(healthSuggest.getPage().getPageSize());
		suggestList = healthSuggest.getPage().getResult();
		//System.out.println(suggestList.get(1).getCreateTime());
	    this.pageHtml = page.getPage("HealthManagerAction!getSuggests.action?healthFileId="+healthFileId+"&userId="+userId);
        ////////////***********方法修改******************//////
	   // healthFile = healthFileService.getHealthFileById(healthFileId);
		return "suggestList";
	}
	
	public String jumpAddHealthAdvice(){
		token = TokenProccessor.getInstance().makeToken();//创建令牌
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
		return "addHealthAdvice";
	}
	
	
	/**
	 * 添加建议
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String addSuggestByHealthFileId() throws UnsupportedEncodingException{
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "getHealthFileListRed";
		}
		request.getSession().removeAttribute("token");//移除session中的token
		Suggest suggest = new Suggest();
		String resultJson = "";
		TStaff tStaff = (TStaff) ActionContext.getContext().getSession().get("tstaff");
		//社区负责人
		TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext.getContext().getSession().get("comHospital");
		if(tStaff!=null){
			suggest.setDoctorId(tStaff.getStaffId());
			suggest.setDoctorName(tStaff.getName());
		}
		if(tCommunityHospital!=null){
			suggest.setDoctorId(tCommunityHospital.getCommunityHospitalId());
			suggest.setDoctorName(tCommunityHospital.getName());
		}
		suggest.setProblem(wenti);
		suggest.setDoctorAdvice(doctorAdvice);
		//suggest.setDoctorId(tStaff.getStaffId());
		
		suggest.setCreateTime(createTime);
        ////////////***********方法修改******************//////
		//healthFile = healthFileService.getHealthFileById(healthFileId);
		healthFile = healthManagerService.getHealthfileCloudById(Math.abs(healthFileId));
		suggest.setUserId(userId);
		suggest.setIdNum(healthFile.getIdNum());
		suggest.setUserName(healthFile.getName());
		suggest.setBelongSystem(healthFile.getBelongSystem());
		try {
			resultJson = healthManagerService.addSuggestCloud(suggest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "getHealthFileListRed"; 
	}
	
	/**
	 * 删除建议
	 * @return
	 */
	public String deleteSuggests(){
		healthFileId=Math.abs(healthFileId);
		String resultJson = healthManagerService.deleteSuggestCloud(id);
		if(!resultJson.equals("")){
			Map<String, Object> resultMap = new HashMap<String, Object>();
			//将json串转化成map
			resultMap =JSON.parseObject(resultJson);
			message = (String) resultMap.get("message");
		}else{
			message = "建议删除失败";
		}
		
		return "deleteSuggests";
	}
	public String jumpEditHealthAdvice(){
		return "editHealthAdvice";
	}
	
	/**
	 * 修改健康建议
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public String editSuggest() throws UnsupportedEncodingException{
		healthFile = healthManagerService.getHealthfileCloudById(Math.abs(healthFileId));
		TStaff tStaff = (TStaff) ActionContext.getContext().getSession().get("tstaff");
		String resultJson;
		Suggest suggest = new Suggest();
		//社区负责人
		TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext.getContext().getSession().get("comHospital");
		if(tStaff!=null){
			suggest.setDoctorId(tStaff.getStaffId());
			suggest.setDoctorName(tStaff.getName());
		}
		if(tCommunityHospital!=null){
			suggest.setDoctorId(tCommunityHospital.getCommunityHospitalId());
			suggest.setDoctorName(tCommunityHospital.getName());
		}
		suggest.setDoctorAdvice(doctorAdvice);
		suggest.setId(suggestId);
		suggest.setProblem(wenti);
		suggest.setUserId(userId);
		suggest.setIdNum(healthFile.getIdNum());
		suggest.setUserName(healthFile.getName());
		suggest.setBelongSystem(healthFile.getBelongSystem());
		String suggestJson=JSON.toJSONString(suggest);
		//{"belongSystem":"1","doctorAdvice":"发D","doctorId":142,"doctorName":"楚云飞","idNum":"130825199302091579","userId":180,"userName":"ZFL添加"}
		resultJson = healthManagerService.editSuggest(suggestJson);
		return "deleteSuggests";
	}
	/**
	 * 健康建议详情
	 */
	public String jumpHealthAdviceInfo(){
		return "jumpHealthAdviceInfo";
	}
	
	/**
	 * 获取老人档案的体检列表
	 * @return
	 */
	public String getPhysicExemByHealthFileId(){
		
		healthFile = healthManagerService.getHealthfileCloudById(Math.abs(healthFileId));
		HealthPhysicEx healthPhysicEx =  (HealthPhysicEx) ActionContext.getContext().getSession().get("healthPhysicEx");
		if(healthPhysicEx == null){
			healthPhysicEx = this.getPhysicExemPageInfo(healthFileId,healthFile.getBelongSystem());
			ActionContext.getContext().getSession().put("HealthPhysicExem", healthPhysicEx);
		}
		Page<HealthPhysicEx.Page.PhysicEx> page = new Page<HealthPhysicEx.Page.PhysicEx>();
		page.setCurrentPage(cp);
		String resultJson = healthManagerService.getPhysicExemCloud(healthFileId,healthFile.getBelongSystem(),page.getCurrentPage(),page.getPageSize());
		healthPhysicEx = JSON.parseObject(resultJson,HealthPhysicEx.class);
		physicExList = healthPhysicEx.getPage().getResult();
		page.setTotalNum(healthPhysicEx.getPage().getTotal());
		page.setPageSize(healthPhysicEx.getPage().getPageSize());
		this.pageHtml = page.getPage("HealthManagerAction!getPhysicExemByHealthFileId.action");
		
		return "physicExem";
	}
	
	/**
	 * 根据id获取单个体检信息
	 * @return
	 */
	public String getPhysicExemById(){
		
		String resultJson = healthManagerService.getPhysicExemByIdCloudDetail(physicalExamId);
		physicExemSingle = JSON.parseObject(resultJson,PhysicExemSingle.class);
		return "healthPhysicExem";
	}
	
	
	
		/**
		 * 进入健康管理的档案管理
		 * 
		 * @return 返回到血压、血糖、血氧、心电、一体机的管理页面
		 */
		public String getDataFromCloud() {
			if (checkAddressHealthFileId(healthFileId).equals("error")) {
				return "error";
			}
            ////////////***********方法修改******************//////
			localHealthFile = healthFileService.getHealthFileById(healthFileId);
		    //healthFile = healthManagerService.getHealthfileCloudById(Math.abs(healthFileId));
			return "getDataFromCloud";
		}
		
		
	/**
	 * 判断当前登录用户
	 * 
	 * @return
	 */
	public Integer getNowSqid() {
		// 从session里拿到当前登录用户的id
				HttpSession session = ServletActionContext.getRequest().getSession();
				TCommunityHospitalGroup group = (TCommunityHospitalGroup) session
						.getAttribute("communityHospitalGroup");
				if (group != null) {
					return -1;
				} // 调用该类拿到对应的数(如果是员工则拿到员工id,如果是平台管理员则为0,如果是社区管理员则返回社区医院id的负数)
				else {
					int userId = GetSessionPerson.getPerson();
					// user大于0,员工id
					if (userId > 0) {
						sqid = staffService.getCommHospitalByStaffId(userId);
						// user小于0,社区负责人id;等于0,平台admin
					} else if (userId < 0 || userId == 0) {
						sqid = Math.abs(userId);
					}
					return sqid;
				}
	}
	
	/**
	 * 健康采集首页多条件查询 he健康监测查询Zhudejiang LaiQingFa 9、11
	 * 
	 * @return
	 */
	public String getHealthFileListBySearchBean() {

		// 调用该类拿到对应的数(如果是员工则拿到员工id,如果是平台管理员则为0,如果是社区管理员则返回社区医院id的负数)
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
		chlist = new int[8];
		pagePlus = new Page<VOldStaff>();
		if(group!=null){//集团负责人登陆
			hospitals = communityHospitalGroupService.getComHosListByGroup(group);
			searchbean.setShenfen(4);
			if(searchbean.getSqid()==0){   //查询全部传集团id 
				searchbean.setSqid(group.getGId());
				searchbean.setAll(true);
			}else{
				searchbean.setSqid(searchbean.getSqid());  //查询医院传医院id
			}
			flag = true;//隐去责任医生 录入人建档人
			issq = 1;//0是平台管理员登陆，1是集团登陆，2是其他登陆 
		}
		else{
		int userId = GetSessionPerson.getPerson();
		sqid = getNowSqid();
		if (userId == 0) {
			groups = communityHospitalGroupService.getAllGroups();
			issq = 0; //0是平台管理员登陆，1是集团登陆，2是其他登陆
			flag = true;
		} else if (userId > 0
				&& healthFileService.getOldStaffHosByStaffId(userId) == false) {
			staffs = staffService.getStaffByCommunityHospitalId(sqid);
			specialDoctor=healthFileService.getSpeciallDoctor(sqid);
			searchbean.setShenfen(2);
			searchbean.setSqid(sqid);
			flag = true;
		} else if (userId < 0) {
			staffs = staffService.getStaffByCommunityHospitalId(sqid);
			specialDoctor=healthFileService.getSpeciallDoctor(sqid);
			searchbean.setShenfen(1);
			searchbean.setSqid(sqid);
		} else if (userId > 0
				&& healthFileService.getOldStaffHosByStaffId(userId) == true) {
			searchbean.setShenfen(3);
			searchbean.setYsid(userId);
			searchbean.setSqid(sqid);
			staffs = staffService.getStaffByCommunityHospitalId(sqid);
			flag = true;
		}
		if (searchbean.getRenqun() != null) {
			for (int i = 0; i < searchbean.getRenqun().length; i++) {
				int m = searchbean.getRenqun()[i];
				chlist[i] = m;
			}
		}
		}
		pagePlus.setCurrentPage(cp1);
		pagePlus.setTotalNum(healthManagerService
				.findvOldStaffsListCount(searchbean));
		vOldStaffs = healthManagerService.getvOldStaffsList(searchbean, pagePlus);
		this.pageHtml=pagePlus.getPageForChronic("entity");
		return "DataGetFileList";

	}
	
	/**
	 * 进入数据采集页
	 * 
	 * @return 结果集字符串
	 */
	public String toUploadData() {
		// 根据档案id 获取档案实体
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
   
		localHealthFile = healthFileService.getHealthFileById(healthFileId);
		return "toUploadData";
	}

	/**
	 * 上传血压信息,并获取目标主机的返回信息
	 * 
	 * @return
	 */
	public String uploadBloodPressData() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		// 值分别为press,suger,oxygen分别控制jsp显示相应的form
		uploadDataType = "press";
		// 访问对接系统,并返回对接系统的反馈信息
		bloodPress.setAppUserID(healthFileId + "");
		if (bloodPress.getDiaPre() == null || bloodPress.getMeaTime() == null
				|| bloodPress.getPulse() == null
				|| bloodPress.getSysPre() == null) {
			return "toUploadDataRed";
		}
		// 上传数据并返回反馈信息
		message = healthManagerService.addBloodPressData(bloodPress);
		// 根据档案id 获取档案实体
        ////////////***********方法修改******************//////
		localHealthFile = healthFileService.getHealthFileById(healthFileId);
		//healthFile = healthManagerService.getHealthfileCloudById(Math.abs(healthFileId));
		return "uploadBloodPressData";
	}

	/**
	 * 上传血糖信息,并获取目标主机的返回信息
	 * 
	 * @return
	 */
	public String uploadBloodSugerData() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		// 为返回页面做准备
		uploadDataType = "suger";
		// 访问对接系统,并返回对接系统的反馈信息
		bloodSuger.setAppUserID(healthFileId + "");
		if (bloodSuger.getAnalysisResult() == null
				|| bloodSuger.getBloodSugar() == 0
				|| bloodSuger.getMeaTime() == null) {
			return "toUploadDataRed";
		}
		message = healthManagerService.addBloodSugarData(bloodSuger);
		// 根据档案id 获取档案实体
        ////////////***********方法修改******************//////
		localHealthFile = healthFileService.getHealthFileById(healthFileId);
	    //healthFile = healthManagerService.getHealthfileCloudById(Math.abs(healthFileId));
		return "uploadBloodSugerData";
	}

	/**
	 * 上传血氧信息,并获取目标主机的返回信息
	 * 
	 * @return
	 */
	public String uploadBloodOxygen() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		// 为返回页面做准备
		uploadDataType = "oxygen";
		// 访问对接系统,并返回对接系统的反馈信息
		bloodOxygen.setAppUserID(healthFileId + "");
		if (bloodOxygen.getAnalysisResult() == null
				|| bloodOxygen.getMeaTime() == null
				|| bloodOxygen.getOxygen() == 0 || bloodOxygen.getPulse() == 0) {
			return "toUploadDataRed";
		}
		message = healthManagerService.addBloodOxygenData(bloodOxygen);
		// 根据档案id 获取档案实体
        ////////////***********方法修改******************//////
		localHealthFile = healthFileService.getHealthFileById(healthFileId);
		//healthFile = healthManagerService.getHealthfileCloudById(Math.abs(healthFileId));
		return "uploadBloodOxygen";
	}

	

	/**
	 * 健康管理血压分析 ，进入血压档案（第一个链接），也可以用于四个页面之间切换
	 * 
	 * @return
	 */
	public String getBloodPressFromCloud() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		// 根据档案id 获取档案实体
        ////////////***********方法修改******************//////
		String appUserId;
		localHealthFile = healthFileService.getHealthFileById(healthFileId);     //本地老人
		if(localHealthFile==null){
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			appUserId=healthFileId+"--"+healthFile.getIdNum();
			healthFile.setId(-healthFileId);
		}
		else{
			appUserId=healthFileId+"--"+localHealthFile.getIdNum();
		}
		// 用于四个页面间的切换
		switch (bloodForward) {
		case 0:
				if(localHealthFile==null&&healthFile!=null){
					return "getBloodPressFromCloudAdvice0"; //返回数据分析页  健康建议菜单下       本地老人数据页面
				}
				return "getBloodPressFromCloud0"; // 返回数据分析页  数据数据采集菜单下       本地老人数据页面
		case 1:
			if(localHealthFile==null&&healthFile!=null){
				return "getBloodPressFromCloudAdvice1"; //返回数据分析页  健康建议菜单下       本地老人数据页面
			}
			return "getBloodPressFromCloud1"; // 返回趋势分析页
		case 2:
			Page<BloodPress> page1 = new Page<BloodPress>();
			page1.setCurrentPage(cp);
			String resultJson = healthManagerService.getAllBloodPressData(
					appUserId, page1.getCurrentPage(),
					page1.getPageSize());
			// 将json串转换成目标对象
			bloodPressCloud = JSON.parseObject(resultJson,
					BloodPressCloud.class);
			String jsonString = bloodPressCloud.getPage().getResult();// [{"appKey":"ac6b5a57f3d04e328a1e79facc860e1d","appUserID":"1","arm":0,"devID":0,"diaPre":90,"id":91,"meaState":0,"meaTime":"2016-09-13 00:00:00","medName":"","other1":"111","other2":"222","other3":"333","pulse":79,"sysPre":89,"takeMed":0}
			bloodPresseList = (List<BloodPress>) JSONArray.parseArray(
					jsonString, BloodPress.class);
			// 获取分页的总数
			page1.setTotalNum(bloodPressCloud.getPage().getTotal());

			Collections.sort(bloodPresseList, new Comparator<BloodPress>() {
				@Override
				public int compare(com.jmjk.pojo.BloodPress o1,
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
			if(healthFile!=null){
				healthFileId=-healthFileId;
			}
			this.pageHtml = page1
							.getPage("HealthManagerAction!getBloodPressFromCloud.action?bloodForward=2&healthFileId="
							+ healthFileId+"&embeded="+embeded);
			if(localHealthFile==null&&healthFile!=null){
				return "getBloodPressFromCloudAdvice2"; //返回数据分析页  健康建议菜单下       本地老人数据页面
			}
			return "getBloodPressFromCloud2"; // 返回数据详细页
		case 3:
			Page<TRecoveryOld> page = new Page<TRecoveryOld>();
			page.setCurrentPage(cp);
			page.setTotalNum(recoveryPlanService
					.countRecoverPlanByHealthFileId(healthFileId, "高血压"));
			this.pageHtml = page
					.getPage("HealthManagerAction!getBloodPressFromCloud.action?bloodForward="
							+ bloodForward+"&embeded="+embeded);
	        ////////////***********方法修改******************//////
			localHealthFile = healthFileService.getHealthFileById(healthFileId);
			//healthFile = healthManagerService.getHealthfileCloudById(Math.abs(healthFileId));
			recoveryOldList = recoveryPlanService
					.getRecoveryPlansByHealthFileId(healthFileId, "高血压", page);
			return "getBloodPressFromCloud3"; // 返回康复计划页
		default:
			if(localHealthFile==null&&healthFile!=null){
				return "getBloodPressFromCloudAdvice0"; //返回数据分析页  健康建议菜单下       本地老人数据页面
			}
			return "getBloodPressFromCloud0"; // 返回数据分析页
		}
	}

	/**
	 * 血压数据的数据分析
	 * 
	 * @return
	 */
	public String bloodPressDataAnalysis() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		// 根据档案id 获取档案实体
        ////////////***********方法修改******************//////
		localHealthFile = healthFileService.getHealthFileById(healthFileId);
		String appUserId;
		if(localHealthFile==null){
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			appUserId=healthFileId+"--"+healthFile.getIdNum();
			healthFile.setId(-healthFileId);
		}
		else{
			appUserId=healthFileId+"--"+localHealthFile.getIdNum();                //本地老人
		}
		String resultJson = ""; // 返回的数据json串
		if (searchType == 0 && startTime != null && endTime != null) { // 搜索条件按时间查询
			resultJson = healthManagerService.getBloodPressData(appUserId, startTime, endTime, 1, 1000);
		} else if (searchType == 1 && totalSize != null) { // 搜索条件按条数查询
			resultJson = healthManagerService.getBloodPressData(appUserId, totalSize, 1, 1000);
		} else {
			searchType = 0;
			if(localHealthFile==null&&healthFile!=null){
				return "bloodPressDataAnalysisAdvice"; //返回数据分析页  健康建议菜单下       本地老人数据页面
			}
			return "bloodPressDataAnalysis";
		}
		// 将json串转换成目标对象
		BloodPressCloud bloodPressCloud = JSON.parseObject(resultJson,
				BloodPressCloud.class);
		if (bloodPressCloud.getCode() == 0) { // 服务器响应成功
			message = bloodPressCloud.getMessage();
			String jsonString = bloodPressCloud.getPage().getResult();
			bloodPresses = (List<BloodPress>) JSONArray.parseArray(jsonString,
					BloodPress.class);
			List<BloodPress> bloodPresses1 = (List<BloodPress>) JSONArray
					.parseArray(jsonString, BloodPress.class);
			List<BloodPress> bloodPresses2 = (List<BloodPress>) JSONArray
					.parseArray(jsonString, BloodPress.class);
			if (bloodPresses.size() != 0) {
				// 定义收缩压最高的实体
				BloodPress bloodPressMax = new BloodPress();
				bloodPressMax = bloodPresses.get(0);
				// 定义舒张压最低的实体
				BloodPress bloodPressMin = new BloodPress();
				bloodPressMin = bloodPresses1.get(0);
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
				double diaPre = 0;
				double sysPre = 0;
				int pulse = 0;
				double sixToNineDiaPre = 0;
				double sixToNineSysPre = 0;
				int sixToNinePulse = 0;
				double wsixToNineDiaPre = 0;
				double wsixToNineSysPre = 0;
				int wsixToNinePulse = 0;
				for (BloodPress xbloodPress : bloodPresses) {
					// 求收缩压、舒张压、血压最高的实体引用
					if (xbloodPress.getSysPre() > bloodPressMax.getSysPre()) {
						bloodPressMax.setSysPre(xbloodPress.getSysPre());
						;
					}
					if (xbloodPress.getDiaPre() > bloodPressMax.getDiaPre()) {
						bloodPressMax.setDiaPre(xbloodPress.getDiaPre());
					}
					if (xbloodPress.getPulse() > bloodPressMax.getPulse()) {
						bloodPressMax.setPulse(xbloodPress.getPulse());
					}
				}

				for (BloodPress xbloodPress : bloodPresses1) {
					// 求收缩压、舒张压、血压最低的实体引用
					if (xbloodPress.getSysPre() < bloodPressMin.getSysPre()) {
						bloodPressMin.setSysPre(xbloodPress.getSysPre());
					}
					if (xbloodPress.getDiaPre() < bloodPressMin.getDiaPre()) {
						bloodPressMin.setDiaPre(xbloodPress.getDiaPre());
					}
					if (xbloodPress.getPulse() < bloodPressMin.getPulse()) {
						bloodPressMin.setPulse(xbloodPress.getPulse());
					}

				}

				for (BloodPress xbloodPress : bloodPresses2) {
					time = xbloodPress.getMeaTime();
					// 求各参数的的和
					diaPre = diaPre + xbloodPress.getDiaPre();
					sysPre = sysPre + xbloodPress.getSysPre();
					pulse = pulse + xbloodPress.getPulse();
					// 求6-9点的实体的各参数的和
					if (compareTime(time, "06:00", "09:00") == true) {
						countSixToNine++;
						sixToNineDiaPre = sixToNineDiaPre
								+ xbloodPress.getDiaPre();
						sixToNineSysPre = sixToNineSysPre
								+ xbloodPress.getSysPre();
						sixToNinePulse = sixToNinePulse
								+ xbloodPress.getPulse();
					}
					// 求18-21点的实体的各参数的和
					if (compareTime(time, "18:00", "21:00")) {
						countWSixToNine++;
						wsixToNineDiaPre = wsixToNineDiaPre
								+ xbloodPress.getDiaPre();
						wsixToNineSysPre = wsixToNineSysPre
								+ xbloodPress.getSysPre();
						wsixToNinePulse = wsixToNinePulse
								+ xbloodPress.getPulse();
					}
				}
				try {
					// 计算平均值
					bloodPressAvg.setSysPre(sysPre / bloodPresses.size());
					bloodPressAvg.setDiaPre(diaPre / bloodPresses.size());
					bloodPressAvg.setPulse(pulse / bloodPresses.size());
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					/*
					 * if(countSixToNine==0){
					 * bloodPressAvgSixToNine.setSysPre((double) 0);
					 * bloodPressAvgSixToNine.setDiaPre((double) 0);
					 * bloodPressAvgSixToNine.setPulse(0); }
					 */
					// 计算6-9点各个平均值
					if (countSixToNine != 0) {
						bloodPressAvgSixToNine.setSysPre(sixToNineSysPre
								/ countSixToNine);
						bloodPressAvgSixToNine.setDiaPre(sixToNineDiaPre
								/ countSixToNine);
						bloodPressAvgSixToNine.setPulse(sixToNinePulse
								/ countSixToNine);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					/*
					 * if(countWSixToNine==0){
					 * bloodPressAvgWSixToNine.setSysPre((double) 0);
					 * bloodPressAvgWSixToNine.setDiaPre((double) 0);
					 * bloodPressAvgWSixToNine.setPulse(0); }
					 */
					// 18-21计算平均值
					if (countWSixToNine != 0) {
						bloodPressAvgWSixToNine.setSysPre(wsixToNineSysPre
								/ countWSixToNine);
						bloodPressAvgWSixToNine.setDiaPre(wsixToNineDiaPre
								/ countWSixToNine);
						bloodPressAvgWSixToNine.setPulse(wsixToNinePulse
								/ countWSixToNine);
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
		if(localHealthFile==null&&healthFile!=null){
			return "bloodPressDataAnalysisAdvice"; //返回数据分析页  健康建议菜单下       本地老人数据页面
		}
		return "bloodPressDataAnalysis";
	}

	/**
	 * 血压数据的趋势分析
	 * 
	 * @return
	 */
	public String bloodPressTendAnalysis() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		// 根据档案id 获取档案实体
        ////////////***********方法修改******************//////
		localHealthFile = healthFileService.getHealthFileById(healthFileId);
		String appUserId;
		if(localHealthFile==null){
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			appUserId=healthFileId+"--"+healthFile.getIdNum();
			healthFile.setId(-healthFileId);
		}
		else{
			appUserId=healthFileId+"--"+localHealthFile.getIdNum();                //本地老人
		}
		String resultJson = ""; // 返回的数据json串
		if (searchType == 0 && startTime != null && endTime != null) { // 搜索条件按时间查询
			resultJson = healthManagerService.getBloodPressData(appUserId, startTime, endTime, 1, 1000);
			// resultJson="{\"code\":0,\"message\":\"数据查询成功！\",\"page\":{\"endRow\":16,\"pageNum\":1,\"pageSize\":16,\"pages\":1,\"result\":[{\"appKey\":\"112113\",\"appUserID\":\"0000001\",\"arm\":3,\"devID\":21,\"diaPre\":4,\"id\":3,\"meaState\":0,\"meaTime\":\"2011-01-01 10:03:40\",\"other1\":\"\",\"other2\":\"\",\"other3\":\"\",\"pulse\":53,\"sysPre\":2},{\"appKey\":\"112113\",\"appUserID\":\"0000001\",\"arm\":3,\"devID\":21,\"diaPre\":4,\"id\":4,\"meaState\":2,\"meaTime\":\"2011-01-01 10:03:40\",\"other1\":\"111\",\"other2\":\"222\",\"other3\":\"333\",\"pulse\":53,\"sysPre\":2}],\"startRow\":0,\"total\":2}}";
		} else if (searchType == 1 && totalSize != null) { // 搜索条件按条数查询
			resultJson = healthManagerService.getBloodPressData(appUserId, totalSize, 1, 1000);
		} else {
			searchType = 0;
			if(localHealthFile==null&&healthFile!=null){
				return "bloodPressTendAnalysisAdvice"; //返回数据分析页  健康建议菜单下       本地老人数据页面
			}
			return "bloodPressTendAnalysis";
		}

		// 将json串转换成目标对象
		BloodPressCloud bloodPressCloud = JSON.parseObject(resultJson,
				BloodPressCloud.class);
		if (bloodPressCloud.getCode() == 0) {
			String jsonString = bloodPressCloud.getPage().getResult();
			bloodPresses = (List<BloodPress>) JSONArray.parseArray(jsonString,
					BloodPress.class);
			// 用于前台显示时如何数据量太大，强迫页面出现左右的滚动条
			if (bloodPresses.size() != 0) {
				scrollLength = bloodPresses.size() * 150;
				// 查询成功实体中的code值为0，注意此处不是服务器返回的状态码
				message = bloodPressCloud.getMessage();
				// collection集合类的帮助类collections提供的排序方法，按照时间将list中的数据排序
				Collections.sort(bloodPresses, new Comparator<BloodPress>() {
					@Override
					public int compare(com.jmjk.pojo.BloodPress o1,
							com.jmjk.pojo.BloodPress o2) {
						Date time1 = TypeConverter.convertString2Date(
								o1.getMeaTime(), "yyyy-MM-dd HH:mm");
						Date time2 = TypeConverter.convertString2Date(
								o2.getMeaTime(), "yyyy-MM-dd HH:mm");
						if (time2.before(time1)) {
							return 1;
						} else if (time2.after(time1)) {
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
				xAxis = "[" + xAxisBuilder.toString() + "]";// ['2016-09-05
															// 00:00:00','2016-09-08
															// 00:00:00']
				// 拼接收缩压构成的数据
				yAxisHigh = "[" + yAxisBuilderHigh.toString() + "]";// [78.0,33.0]
				// 拼接舒张压构成的数据
				yAxisLow = "[" + yAxisBuilderLow.toString() + "]";// [78.0,22.0]
				// 拼接脉率值构成的数据
				yAxisPulse = "[" + yAxisBuilderPulse.toString() + "]";// [89,54]
			} else {
				xAxis = "[0]";
				yAxisHigh = "[0]";
				yAxisLow = "[0]";
				yAxisPulse = "[0]";
				if(localHealthFile==null&&healthFile!=null){
					return "bloodPressTendAnalysisAdvice"; //返回数据分析页  健康建议菜单下       本地老人数据页面
				}
				return "bloodPressTendAnalysis";
			}
		}
		if(localHealthFile==null&&healthFile!=null){
			return "bloodPressTendAnalysisAdvice"; //返回数据分析页  健康建议菜单下       本地老人数据页面
		}
		return "bloodPressTendAnalysis";
	}

	/**
	 * 查看血压详细数据
	 * 
	 * @return
	 */
	public String bloodPressDataDetail() {
		if (checkAddressHealthFileId(Math.abs(healthFileId)).equals("error")) {
			return "error";
		}
		// 根据档案id 获取档案实体
		localHealthFile = healthFileService.getHealthFileById(healthFileId);
		String appUserId;
		if(localHealthFile==null){
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			appUserId=healthFileId+"--"+healthFile.getIdNum();
			healthFile.setId(-healthFileId);
		}
		else{
			appUserId=healthFileId+"--"+localHealthFile.getIdNum();                //本地老人
		}
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

		// 血压数据详情，默认查询所有
		if (searchType == 0 && startTime != null && endTime != null) { // 搜索条件按时间查询

			resultJson = healthManagerService.getBloodPressData(appUserId, startTime, endTime, page.getCurrentPage(),
					page.getPageSize());
			
			// 将json串转换成目标对象
			bloodPressCloud = JSON.parseObject(resultJson,
					BloodPressCloud.class);
			if (bloodPressCloud.getCode() == 0) {
				String jsonString = bloodPressCloud.getPage().getResult();
				bloodPresseList = (List<BloodPress>) JSONArray.parseArray(
						jsonString, BloodPress.class);
				if (bloodPresseList.size() > 2) {
					Collections.sort(bloodPresseList,
							new Comparator<BloodPress>() {
								@Override
								public int compare(com.jmjk.pojo.BloodPress o1,
										com.jmjk.pojo.BloodPress o2) {
									Date time1 = TypeConverter
											.convertString2Date(
													o1.getMeaTime(),
													"yyyy-MM-dd HH:mm");
									Date time2 = TypeConverter
											.convertString2Date(
													o2.getMeaTime(),
													"yyyy-MM-dd HH:mm");
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
		        if(healthFile!=null){
		        	healthFileId=-healthFileId;
		        }
				this.pageHtml = page
						.getPage("HealthManagerAction!bloodPressDataDetail.action?healthFileId="
								+ healthFileId
								+ "&start="
								+ start
								+ "&end="
								+ end
								+ "&searchType="
								+ searchType
								+"&embeded="+embeded);
			}
		} else if (searchType == 1 && totalSize != null) { // 搜索条件按条数查询
			resultJson = healthManagerService.getBloodPressData(appUserId, totalSize, page.getCurrentPage(), page.getPageSize());
			bloodPressCloud = JSON.parseObject(resultJson,
					BloodPressCloud.class);
			if (bloodPressCloud.getCode() == 0) {
				String jsonString = bloodPressCloud.getPage().getResult();
				bloodPresseList = (List<BloodPress>) JSONArray.parseArray(
						jsonString, BloodPress.class);
				if (bloodPresseList.size() > 2) {
					Collections.sort(bloodPresseList,
							new Comparator<BloodPress>() {
								@Override
								public int compare(com.jmjk.pojo.BloodPress o1,
										com.jmjk.pojo.BloodPress o2) {
									Date time1 = TypeConverter
											.convertString2Date(
													o1.getMeaTime(),
													"yyyy-MM-dd HH:mm:ss");
									Date time2 = TypeConverter
											.convertString2Date(
													o2.getMeaTime(),
													"yyyy-MM-dd HH:mm:ss");
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
				if(healthFile!=null){
					healthFileId=-healthFileId;
				}
				this.pageHtml = page
						.getPage("HealthManagerAction!bloodPressDataDetail.action?healthFileId="
								+ healthFileId + "&totalSize=" + totalSize+"&embeded="+embeded);
			}
		} else {
			return "bloodPressDataDetailRed";
		}
		if(localHealthFile==null&&healthFile!=null){
			return "bloodPressDataDetailAdvice"; //返回数据分析页  健康建议菜单下       本地老人数据页面
		}
		return "bloodPressDataDetail";
	}

	/**
	 * 删除自己上传的血压数据
	 * 
	 * @return
	 */
	public String deleteBloodPressDataCloud() {
		// 删除云上的血压数据，返回反馈信息 这种删除怎么做校验
		message = healthManagerService.deleteBPCloud(cloudId);
		return "bloodPressDataDetailRed";
	}

	/**
	 * 跳转到修改云端血压数据页
	 * 
	 * @return
	 */
	public String toEditBPCloud() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		// 根据档案id 获取档案实体
        ////////////***********方法修改******************//////
		localHealthFile = healthFileService.getHealthFileById(healthFileId);
		if(localHealthFile==null){
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			healthFile.setId(-healthFileId);
			}
		//healthFile = healthManagerService.getHealthfileCloudById(Math.abs(healthFileId));
		// 由于显示要修改的血压数据
		// bloodPress.setMeaTime(meaTimeString);
		if(localHealthFile==null&&healthFile!=null){
			return "toEditBPCloudAdvice"; //返回数据分析页  健康建议菜单下       其他平台老人数据页面
		}
		return "toEditBPCloud";
	}

	/**
	 * 修改云端血压数据
	 * 
	 * @return
	 */
	public String editBPCloud() {
		// 根据档案id 获取档案实体
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
        ////////////***********方法修改******************//////
		localHealthFile = healthFileService.getHealthFileById(healthFileId);
		String appUserId;
		if(localHealthFile==null){
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			appUserId=healthFileId+"--"+healthFile.getIdNum();
			healthFile.setHealthFileId(-healthFileId);
		}
		else{
			appUserId=healthFileId+"--"+localHealthFile.getIdNum();                //本地老人
		}
		//healthFile = healthManagerService.getHealthfileCloudById(Math.abs(healthFileId));
		bloodPress.setAppUserID(appUserId);
		if (bloodPress.getDiaPre() == null || bloodPress.getMeaTime() == null
				|| bloodPress.getPulse() == null
				|| bloodPress.getSysPre() == null
				|| bloodPress.getTakeMed() == null) {
			return "toEditBPCloud";
		}
		// 修改血压数据并等到反馈信息
		message = healthManagerService.updateBPCloud(cloudId, bloodPress);
		return "bloodPressDataDetailRed";
	}

	/**
	 * 查询血压，血糖公用的康复计划
	 * 
	 * @return
	 */
	public String searchBloodPressRecoverPlan() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		// 分页处理
		Page<TRecoveryOld> page = new Page<TRecoveryOld>();
		page.setCurrentPage(cp);
		page.setTotalNum(recoveryPlanService.countRecoveryOldList(healthFileId,
				diseaseName, startTime, endTime, planName, planState));
		this.pageHtml = page
				.getPage("HealthManagerAction!searchBloodPressRecoverPlan.action?healthFileId"
						+ healthFileId
						+ "&startTime="
						+ startTime
						+ "&endTime"
						+ endTime
						+ "&planName="
						+ planName
						+ "&planState="
						+ planState
						+"&embeded="+embeded);
		// diseaseName的值为高血压和高血糖
		recoveryOldList = recoveryPlanService.getRecoveryOldList(healthFileId,
				diseaseName, page, startTime, endTime, planName, planState);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		String timenow = df.format(new Date());

		for (TRecoveryOld list : recoveryOldList) {
			if (timenow.compareTo(list.getTRecoveryPlan().getOverTime()
					.toString()) > 0) {
				list.getTRecoveryPlan().setStatus(
						RecoveryPlanStatus.STARRED.getValue());
				recoveryPlanService.updateRecoveryPlan(list.getTRecoveryPlan());
			}
		}

		if (diseaseName.equals("高血压")) {
			return "searchbloodPressRecoverPlan";
		}
		return "searchbloodSugerRecoverPlan";
	}

	/**
	 * 跳转添加指定档案的康复计划页
	 * 
	 * @return
	 */
	public String toAddBPRecoverPlan() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		token = TokenProccessor.getInstance().makeToken();//创建令牌
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)

		// 根据档案id 获取档案实体
        ////////////***********方法修改******************//////
		//健康建议无链接，healthFileId肯定为本地数据   healthFileId正值
		localHealthFile = healthFileService.getHealthFileById(healthFileId);
		return "toAddBPRecoverPlan";
	}

	/**
	 * 获取康复方案，ajax用
	 * 
	 * @return
	 */
	public String getRecoverSchema() {

		// 从session里拿到当前登录用户的id
		int person = GetSessionPerson.getPerson();

		// 从session中员工实体
		int hosId = 0;
		List<TRecoveryScheme> schemes = new ArrayList<TRecoveryScheme>();
		if (person > 0) {
			hosId = staffService.getCommHospitalByStaffId(person);
		}
		if (person < 0) {
			hosId = Math.abs(person);
		}
		if (schemaType.equals("专家方案")) {
			List<TCommunityHospital> hospitals = communityHospitalService
					.getWuShiSi();
			if (hospitals != null) {
				for (TCommunityHospital hos : hospitals) {
					schemes = recoverySchemeService.getRecoverySchemesByHosId(
							hos.getCommunityHospitalId(), diseaseName);
					if (schemes != null) {
						for (TRecoveryScheme list : schemes) {
							schemeList.add(list);
						}
					}
				}
			}
		}
		// 获取康复计划列表
		else {
			schemeList = recoverySchemeService.getRecoverySchemeByNameAndType(
					hosId, diseaseName, schemaType);
		}
		String json = "[";// 将数据拼接成json串
		for (TRecoveryScheme recoveryScheme : schemeList) {
			json += "{\"recoverySchemeId\":\""
					+ recoveryScheme.getRecoverySchemeId() + "\","
					+ "\"schemeName\":\"" + recoveryScheme.getSchemeName()
					+ "\"},";
		}
		json = json.substring(0, json.length() - 1);
		json = json + "]";
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		try {
			// 将json串写回前台
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 保存康复方案(已经过期)
	 * 
	 * @return
	 */
	public String addBPRecoverPlan() {
		// 根据档案id 获取档案实体
        ////////////***********方法修改******************//////
		localHealthFile = healthFileService.getHealthFileById(healthFileId);
		//healthFile = healthManagerService.getHealthfileCloudById(Math.abs(healthFileId));
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "addBPRecoverPlan";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		TStaff tStaff = (TStaff) ActionContext.getContext().getSession()
				.get("tstaff");
		int HosId = staffService.getCommHospitalByStaffId(tStaff.getStaffId());
		recoveryPlan.setPlanName(planName);
		if (recoveryPlanService.checkName(HosId, planName) > 0) {
			return "toAddBPRecoverPlanRed";
		}
/*		recoveryPlan.setTStaff(tStaff);
		recoveryPlan.setStatus(RecoveryPlanStatus.NO_STARTED.getValue());
		recoveryPlan.setIdDelete(IS_DELETE.no_Delete.getValue());
		recoveryPlan.setRecoveryPlanId(recoveryPlanService.getNextId());
		recoveryPlan.setCommunityHospitalId(communityHospitalService
				.getCommunityHospitalByStaffId(tStaff.getStaffId(),
						healthFileId).getCommunityHospitalId());
		recoveryPlanService.addRecoveryPlan(recoveryPlan);
		TRecoveryOld tRecoveryOld = new TRecoveryOld();
		//tRecoveryOld.setTHealthFile(healthFile);
		tRecoveryOld.setTRecoveryPlan(recoveryPlan);
		List<TRecoveryOld> recoveryOlds = new ArrayList<TRecoveryOld>();
		recoveryOlds.add(tRecoveryOld);
		recoveryPlanService.addRecoveryOld(recoveryOlds);*/
		TRecoveryScheme trecoveryScheme=recoverySchemeService.getRecoverySchemeById(schema);
		recoveryPlan.setTRecoveryScheme(trecoveryScheme);
		recoveryPlan.setCommunityHospitalId(HosId);
		recoveryPlan.setStatus(RecoveryPlanStatus.NO_STARTED.getValue());
		recoveryPlan.setIdDelete(IS_DELETE.no_Delete.getValue());
		//TStaff staff=new TStaff(select);
		recoveryPlan.setTStaff(tStaff);
		int planId=recoveryPlanService.addRecoveryPlan(recoveryPlan);
		//保存计划老人关系表
		//隐藏提交一个老人档案id(daId)
		TRecoveryOld recoveryOld=new TRecoveryOld();
		//保存康复计划外键
		//TRecoveryPlan recoveryPlan=new TRecoveryPlan(planId);       /////
		TRecoveryPlan recoveryPlan=recoveryPlanService.getRecoveryPlanById(planId);
		recoveryOld.setTRecoveryPlan(recoveryPlan);
		//保存健康档案外键
		recoveryOld.setTHealthFile(localHealthFile);
		recoveryPlanService.addRecoveryOld(recoveryOld);
		return "addBPRecoverPlan";
	}

	public int getSchema() {
		return schema;
	}



	public void setSchema(int schema) {
		this.schema = schema;
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
			return "changePlanStatus";
		} catch (Exception e) {
			// TODO: handle exception
			return "errorplan";
		}

	}

	/**
	 * 跳转至康复计划详情页面
	 * @return
	 */
	public String jumpInfoRecoveryPlan() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		if (recoveryPlanService.checkHealthIdPlanId(healthFileId,
				recoveryPlanId, diseaseName) == false) {
			return "error";
		}
		recoveryPlan = recoveryPlanService.getRecoveryPlanById(recoveryPlanId);
        ////////////***********方法修改******************//////
		localHealthFile = healthFileService.getHealthFileById(healthFileId);
		//healthFile = healthManagerService.getHealthfileCloudById(Math.abs(healthFileId));
		if (recoveryPlan.getTRecoveryScheme().getDisease().equals("高血压"))
			return "bloodPressPlanInfo";
		else
			return "bloodSugerPlanInfo";
	}

	/**
	 * 通过Id删除康复计划 (更新状态)
	 * 
	 * @return
	 */
	public String deletePlanById() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		if (recoveryPlanService.checkHealthIdPlanId(healthFileId,
				recoveryPlanId, diseaseName) == false)
			return "error";
		recoveryPlan = recoveryPlanService.getRecoveryPlanById(recoveryPlanId);
		recoveryPlan.setIdDelete(IS_DELETE.delete.getValue());
		recoveryPlanService.updateRecoveryPlan(recoveryPlan);
		if (recoveryPlan.getTRecoveryScheme().getDisease().equals("高血压"))
			return "addBPRecoverPlan"; // 重定向回查询页
		else
			return "deleteBloodSugerPlan";
	}

	/**
	 * 获取云端的血糖数据并分析
	 * 
	 * @return
	 */
	public String getBloodSugerFromCloud() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		// 根据档案id 获取档案实体
        ////////////***********方法修改******************//////
		String appUserId;
		localHealthFile = healthFileService.getHealthFileById(healthFileId);     //本地老人
		if(localHealthFile==null){
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			appUserId=healthFileId+"--"+healthFile.getIdNum();
			healthFile.setId(-healthFileId);
		}
		else{
			appUserId=healthFileId+"--"+localHealthFile.getIdNum();
		}
		switch (bloodForward) {
		case 0:
			if(localHealthFile==null&&healthFile!=null){
				return "getBloodSugerFromCloudAdvice0"; // 返回数据分析页 中心服务器数据
			}
			return "getBloodSugerFromCloud0"; // 返回数据分析页
		case 1:
			if(localHealthFile==null&&healthFile!=null){
				return "getBloodSugerFromCloudAdvice1"; // 返回数据分析页 中心服务器数据
			}
			return "getBloodSugerFromCloud1"; // 返回趋势分析页
		case 2:
			Page<BloodSuger> page1 = new Page<BloodSuger>();
			page1.setCurrentPage(cp);
			String resultJson = healthManagerService.getAllBloodSugerData(
					appUserId, page1.getCurrentPage(), page1.getPageSize());
			// 将json串转换成目标对象
			bloodSugerCloud = JSON.parseObject(resultJson,
					BloodSugerCloud.class);
			String jsonString = bloodSugerCloud.getPage().getResult();// [{"appKey":"ac6b5a57f3d04e328a1e79facc860e1d","appUserID":"1","arm":0,"devID":0,"diaPre":90,"id":91,"meaState":0,"meaTime":"2016-09-13 00:00:00","medName":"","other1":"111","other2":"222","other3":"333","pulse":79,"sysPre":89,"takeMed":0}
			bloodSugerList = (List<BloodSuger>) JSONArray.parseArray(
					jsonString, BloodSuger.class);
			// 获取分页的总数
			page1.setTotalNum(bloodSugerCloud.getPage().getTotal());
			// 对数据按照时间排序
			Collections.sort(bloodSugerList, new Comparator<BloodSuger>() {
				@Override
				public int compare(com.jmjk.pojo.BloodSuger o1,
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
			if(healthFile!=null){
				healthFileId=-healthFileId;
			}
			this.pageHtml = page1
					.getPage("HealthManagerAction!getBloodSugerFromCloud.action?bloodForward=2&healthFileId="
							+ healthFileId+"&embeded="+embeded);
			if(localHealthFile==null&&healthFile!=null){
				return "getBloodSugerFromCloudAdvice2"; // 返回数据分析页 中心服务器数据
			}
			return "getBloodSugerFromCloud2"; // 返回数据详细页
		case 3:
			Page<TRecoveryOld> page = new Page<TRecoveryOld>();
			page.setCurrentPage(cp);
			page.setTotalNum(recoveryPlanService
					.countRecoverPlanByHealthFileId(healthFileId, "糖尿病"));
			this.pageHtml = page
					.getPage("HealthManagerAction!getBloodSugerFromCloud.action?bloodForward="
							+ bloodForward+"&embeded="+embeded);
			recoveryOldList = recoveryPlanService
					.getRecoveryPlansByHealthFileId(healthFileId, "糖尿病", page);
			if(localHealthFile==null&&healthFile!=null){
				return "getBloodSugerFromCloudAdvice3"; // 返回数据分析页 中心服务器数据
			}
			return "getBloodSugerFromCloud3"; // 返回康复计划页
		default:
			if(localHealthFile==null&&healthFile!=null){
				return "getBloodSugerFromCloudAdvice0"; // 返回数据分析页 中心服务器数据
			}
			return "getBloodSugerFromCloud0";
		}
	}

	/**
	 * 血糖数据的数据分析
	 * 
	 * @return
	 */
	public String bloodSugerDataAnalysis() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		// 根据档案id 获取档案实体
        ////////////***********方法修改******************//////
		String appUserId;
		localHealthFile = healthFileService.getHealthFileById(healthFileId);     //本地老人
		if(localHealthFile==null){
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			appUserId=healthFileId+"--"+healthFile.getIdNum();
			healthFile.setId(-healthFileId);
		}
		else{
			appUserId=healthFileId+"--"+localHealthFile.getIdNum();
		}
		String resultJson = ""; // 返回的数据json串
		if (searchType == 0 && startTime != null && endTime != null) { // 搜索条件按时间查询
			resultJson = healthManagerService.getBloodSugerData(appUserId, startTime, endTime, 1, 1000);
		} else if (searchType == 1 && totalSize != null) { // 搜索条件按条数查询
			resultJson = healthManagerService.getBloodSugerData(appUserId, totalSize, 1, 1000);
		} else {
			if(healthFile!=null&&localHealthFile==null){
				return "bloodSugerDataAnalysisAdvice";
			}
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
		if(healthFile!=null&&localHealthFile==null){
			return "bloodSugerDataAnalysisAdvice";
		}
		return "bloodSugerDataAnalysis";
	}

	/**
	 * 血糖的趋势分析
	 * 
	 * @return
	 */
	public String bloodSugerTendAnalysis() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		// 根据档案id 获取档案实体
        ////////////***********方法修改******************//////
		String appUserId;
		localHealthFile = healthFileService.getHealthFileById(healthFileId);     //本地老人
		if(localHealthFile==null){
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			appUserId=healthFileId+"--"+healthFile.getIdNum();
			healthFile.setId(-healthFileId);
		}
		else{
			appUserId=healthFileId+"--"+localHealthFile.getIdNum();
		}
		String resultJson = ""; // 返回的数据json串
		if (searchType == 0 && startTime != null && endTime != null) { // 搜索条件按时间查询
			resultJson = healthManagerService.getBloodSugerData(appUserId, startTime, endTime, 1, 1000);
		} else if (searchType == 1 && totalSize != null) { // 搜索条件按条数查询
			resultJson = healthManagerService.getBloodSugerData(appUserId, totalSize, 1, 1000);
		} else {
			searchType = 0;
			if(healthFile!=null&&localHealthFile==null){
				return "bloodSugerTendAnalysisAdvice";
			}
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
		if(healthFile!=null&&localHealthFile==null){
			return "bloodSugerTendAnalysisAdvice";
		}
		return "bloodSugerTendAnalysis";
	}

	/**
	 * 血糖的详细数据
	 * 
	 * @return
	 */
	public String bloodSugerDataDetail() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		// 根据档案id 获取档案实体
        ////////////***********方法修改******************//////
		String appUserId;
		localHealthFile = healthFileService.getHealthFileById(healthFileId);     //本地老人
		if(localHealthFile==null){
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			appUserId=healthFileId+"--"+healthFile.getIdNum();
			healthFile.setId(-healthFileId);
		}
		else{
			appUserId=healthFileId+"--"+localHealthFile.getIdNum();
		}
		Page<BloodSugerCloud.BloodSuger> page = new Page<BloodSugerCloud.BloodSuger>();
		page.setCurrentPage(cp);
		// 返回的数据json串
		String resultJson = "";
		// 搜索条件按时间查询  时间参数带空格，不能传空格后的部分
		if(start!=null||end!=null){
			start=start.replace("/", " ");
			end=end.replace("/", " ");
			startTime=TypeConverter.stringToDate(start);
			endTime=TypeConverter.stringToDate(end);
		}
		if (searchType == 0 && startTime != null && endTime != null) {
			resultJson = healthManagerService.getBloodSugerData(appUserId, startTime, endTime, page.getCurrentPage(), page.getPageSize());
			// 搜索条件按条数查询
		} else if (searchType == 1 && totalSize != null) {
			resultJson = healthManagerService.getBloodSugerData(appUserId, totalSize, page.getCurrentPage(), page.getPageSize());
		} else {
			return "bloodSugerDataDetailRed";
		}
		// 将json串转换成目标对象
		BloodSugerCloud bloodSugerCloud = JSON.parseObject(resultJson,
				BloodSugerCloud.class);
		// 服务器响应成功
		if (bloodSugerCloud.getCode() == 0) {
			message = bloodSugerCloud.getMessage();
			String jsonString = bloodSugerCloud.getPage().getResult();
			bloodSugerList = (List<BloodSuger>) JSONArray.parseArray(
					jsonString, BloodSuger.class);
			page.setTotalNum(bloodSugerCloud.getPage().getTotal());
			// 对数据按照时间排序
			Collections.sort(bloodSugerList, new Comparator<BloodSuger>() {
				@Override
				public int compare(com.jmjk.pojo.BloodSuger o1,
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
			if(healthFile!=null&&localHealthFile==null){
				return "bloodSugerDataDetailAdvice";
			}
			return "bloodSugerDataDetail";
		}
		if (searchType == 0 && startTime != null && endTime != null) {
			//用于时间回显
	        start=TypeConverter.convertDate2String(startTime, "yyyy-MM-dd HH:mm:ss");
	        start=start.replace(" ", "/");
	        end=TypeConverter.convertDate2String(endTime, "yyyy-MM-dd HH:mm:ss");
	        end=end.replace(" ", "/");
	        if(healthFile!=null){
				healthFileId=-healthFileId;
			}
			this.pageHtml = page
				 .getPage("HealthManagerAction!bloodSugerDataDetail.action?healthFileId="
							+ healthFileId+"&start="+ start + "&end="
							+ end+"&searchType="+searchType+"&embeded="+embeded);
		}
		if (searchType == 1 && totalSize != null) {
			if(healthFile!=null){
				healthFileId=-healthFileId;
			}
			this.pageHtml = page
					.getPage("HealthManagerAction!bloodSugerDataDetail.action?healthFileId="
							+healthFileId+"&searchType="+searchType+"&totalSize="+ totalSize+"&embeded="+embeded);
		}
		if(healthFile!=null&&localHealthFile==null){
			return "bloodSugerDataDetailAdvice";
		}
		return "bloodSugerDataDetail";
	}

	/**
	 * 删除自己上传的血糖数据
	 * 
	 * @return
	 */
	public String deleteBloodSugerDataCloud() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		// 删除血糖数据，返回反馈信息
		message = healthManagerService.deleteBSCloud(cloudId);
		return "bloodSugerDataDetailRed";
	}

	/**
	 * 跳转修改云端血压数据页
	 * 
	 * @return
	 */
	public String toEditBSCloud() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		// 根据档案id 获取档案实体
        ////////////***********方法修改******************//////
		localHealthFile = healthFileService.getHealthFileById(healthFileId);
		if(localHealthFile==null){
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			healthFile.setId(-healthFileId);
			}
		// meatime=TypeConverter.convertString2Date(meaTime,
		// "yyyy-MM-dd hh:mm:ss");
		if(healthFile!=null&&localHealthFile==null){
			return "toEditBSCloudAdvice";
		}
		return "toEditBSCloud";
	}

	/**
	 * 修改云端血糖数据
	 * 
	 * @return
	 */
	public String editBSCloud() {
		// 根据档案id 获取档案实体
        ////////////***********方法修改******************//////
		String appUserId;
		localHealthFile = healthFileService.getHealthFileById(healthFileId);
		if(localHealthFile==null){
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			appUserId=healthFileId+"--"+healthFile.getIdNum();
			healthFile.setId(-healthFileId);
			}
		else {
			appUserId=healthFileId+"--"+localHealthFile.getIdNum();
		}
		bloodSuger.setAppUserID(appUserId);
		if (bloodSuger.getAnalysisResult() == null
				|| bloodSuger.getBloodSugar() == 0
				|| bloodSuger.getMeaTime() == null) {
			if(healthFile!=null&&localHealthFile==null){
				return "toEditBSCloudAdvice";
			}
			return "toEditBSCloud";
		}
		// 修改血糖数据，返回反馈信息
		message = healthManagerService.updateBSCloud(cloudId, bloodSuger);
		return "bloodSugerDataDetailRed";
	}

	/**
	 * 用于血氧三个页面之间的切换
	 * 
	 * @return
	 */
	public String getBloodOxygenFromCloud() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
	        ////////////***********方法修改******************//////
			localHealthFile = healthFileService.getHealthFileById(healthFileId);
			//healthFile = healthManagerService.getHealthfileCloudById(Math.abs(healthFileId));
			return "error";
		}
		// 根据档案id 获取档案实体
        ////////////***********方法修改******************//////
		String appUserId;
		localHealthFile = healthFileService.getHealthFileById(healthFileId);
		if(localHealthFile==null){
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			appUserId=healthFileId+"--"+healthFile.getIdNum();
			healthFile.setId(-healthFileId);
			}
		else {
			appUserId=healthFileId+"--"+localHealthFile.getIdNum();
		}
		switch (bloodForward) {
		case 0:
			if(healthFile!=null&&localHealthFile==null){
				return "getBloodOxygenFromCloudAdvice0";
			}
			return "getBloodOxygenFromCloud0"; // 返回数据分析页
		case 1:
			if(healthFile!=null&&localHealthFile==null){
				return "getBloodOxygenFromCloudAdvice1";
			}
			return "getBloodOxygenFromCloud1"; // 返回趋势分析页
		case 2:
			Page<BloodOxygen> page = new Page<BloodOxygen>();
			page.setCurrentPage(cp);
			String resultJson = healthManagerService.getAllBloodOxygenData(appUserId, page.getCurrentPage(),
					page.getPageSize());
			// 将json串转换成目标对象
			bloodOxygenCloud = JSON.parseObject(resultJson,
					BloodOxygenCloud.class);
			String jsonString = bloodOxygenCloud.getPage().getResult();
			// {"abnAlarm":1,"analysisResult":"阿达","id":3,"meaState":1,"meaTime":"2016-01-01 10:03:40","medName":"阿莫""oxygen":2,"pulse":45,"takeMed":2},
			bloodOxygenList = (List<BloodOxygen>) JSONArray.parseArray(
					jsonString, BloodOxygen.class);
			Collections.sort(bloodOxygenList, new Comparator<BloodOxygen>() {
				@Override
				public int compare(BloodOxygen o1, BloodOxygen o2) {
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
			});// 获取分页的总数
			page.setTotalNum(bloodOxygenCloud.getPage().getTotal());
			if(healthFile!=null){
				healthFileId=-healthFileId;
			}
			this.pageHtml = page
					.getPage("HealthManagerAction!getBloodOxygenFromCloud.action?bloodForward=2&healthFileId="
							+ healthFileId+"&embeded="+embeded);
			if(healthFile!=null&&localHealthFile==null){
				return "getBloodOxygenFromCloudAdvice2";
			}
			return "getBloodOxygenFromCloud2"; // 返回数据详细页
		default:
			if(healthFile!=null&&localHealthFile==null){
				return "getBloodOxygenFromCloudAdvice0";
			}
			return "getBloodOxygenFromCloud0"; // 返回数据分析页
		}
	}

	/**
	 * 血氧的的数据分析页
	 * 
	 * @return
	 */
	public String bloodOxygenDataAnalysis() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		// 根据档案id 获取档案实体
        ////////////***********方法修改******************//////
		String appUserId;
		localHealthFile = healthFileService.getHealthFileById(healthFileId);
		if(localHealthFile==null){
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			appUserId=healthFileId+"--"+healthFile.getIdNum();
			healthFile.setId(-healthFileId);
			}
		else {
			appUserId=healthFileId+"--"+localHealthFile.getIdNum();
		}
		String resultJson = ""; // 返回的数据json串
		if (searchType == 0 && startTime != null && endTime != null) { // 搜索条件按时间查询
			resultJson = healthManagerService.getBloodOxygenData(appUserId, startTime, endTime, 1, 1000);
		} else if (searchType == 1 && totalSize != null) { // 搜索条件按条数查询
			resultJson = healthManagerService.getBloodOxygenData(appUserId, totalSize, 1, 1000);
		} else {
			if(healthFile!=null&&localHealthFile==null){
				return "bloodOxygenDataAnalysisAdvice";
			}
			return "bloodOxygenDataAnalysis";
		}
		// 将json串转换成目标对象
		bloodOxygenCloud = JSON.parseObject(resultJson, BloodOxygenCloud.class);
		if (bloodOxygenCloud.getCode() == 0) {
			String jsonString = bloodOxygenCloud.getPage().getResult();
			bloodOxygens = (List<BloodOxygen>) JSONArray.parseArray(jsonString,
					BloodOxygen.class);
			// 按照血氧的值进行排序
			if (bloodOxygens.size() != 0) {
				Collections.sort(bloodOxygens, new Comparator<BloodOxygen>() {
					@Override
					public int compare(BloodOxygen o1, BloodOxygen o2) {

						if (o1.getOxygen() > o2.getOxygen()) {
							return 1;
						} else if (o1.getOxygen() < o2.getOxygen()) {
							return -1;
						} else {
							return 0;
						}
					}
				});
				// 把血氧值最大和最小的实体放入前台要展示list
				bloodOxygenList.add(bloodOxygens.get(bloodOxygens.size() - 1));
				bloodOxygenList.add(bloodOxygens.get(0));
				// 求血氧值的平均值
				double oxygen = 0;
				double pulse = 0;
				BloodOxygen bloodOxygen = new BloodOxygen();
				if (bloodOxygens != null) {
					for (BloodOxygen xbloodOxygen : bloodOxygens) {
						oxygen = oxygen + xbloodOxygen.getOxygen();
						pulse = pulse + xbloodOxygen.getPulse();
					}
					try {
						bloodOxygen.setOxygen(oxygen / bloodOxygens.size());
						bloodOxygen
								.setPulse((int) (pulse / bloodOxygens.size()));
					} catch (Exception e) {
						e.printStackTrace();
					}
					// 将血氧的平均值放入list
					bloodOxygenList.add(bloodOxygen);
				}
			} 
		}
		if(healthFile!=null&&localHealthFile==null){
			return "bloodOxygenDataAnalysisAdvice";
		}
		return "bloodOxygenDataAnalysis";
	}

	/**
	 * 血氧数据的趋势分析
	 * 
	 * @return
	 */
	public String bloodOxygenTendAnalysis() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		// 根据档案id 获取档案实体
        ////////////***********方法修改******************//////
		String appUserId;
		localHealthFile = healthFileService.getHealthFileById(healthFileId);
		if(localHealthFile==null){
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			appUserId=healthFileId+"--"+healthFile.getIdNum();
			healthFile.setId(-healthFileId);
			}
		else {
			appUserId=healthFileId+"--"+localHealthFile.getIdNum();
		}
		String resultJson = ""; // 返回的数据json串
		if (searchType == 0 && startTime != null && endTime != null) { // 搜索条件按时间查询
			resultJson = healthManagerService.getBloodOxygenData(appUserId, startTime, endTime, 1, 1000);
		} else if (searchType == 1 && totalSize != null) { // 搜索条件按条数查询
			resultJson = healthManagerService.getBloodOxygenData(appUserId, totalSize, 1, 1000);
		} else {
			searchType = 0;
			if(healthFile!=null&&localHealthFile==null){
				return "bloodOxygenTendAnalysisAdvice";
			}
			return "bloodOxygenTendAnalysis";
		}
		// 将json串转换成目标对象
		BloodOxygenCloud bloodOxygenCloud = JSON.parseObject(resultJson,
				BloodOxygenCloud.class);
		if (bloodOxygenCloud.getCode() == 0) {
			String jsonString = bloodOxygenCloud.getPage().getResult();
			bloodOxygenList = (List<BloodOxygen>) JSONArray.parseArray(
					jsonString, BloodOxygen.class);
			// 按照时间排序
			if (bloodOxygenList.size() != 0) {
				Collections.sort(bloodOxygenList,
						new Comparator<BloodOxygen>() {
							@Override
							public int compare(BloodOxygen o1, BloodOxygen o2) {
								Date time1 = TypeConverter.convertString2Date(
										o1.getMeaTime(), "yyyy-MM-dd HH:mm:ss");
								Date time2 = TypeConverter.convertString2Date(
										o2.getMeaTime(), "yyyy-MM-dd HH:mm:ss");
								
								if (time2.before(time1)) {
									return 1;
								} else if (time2.after(time1)) {
									return -1;
								} else {
									return 0;
								}
							}
						});
				// 用于前台显示时如何数据量太大，强迫页面出现左右的滚动条
				scrollLength = bloodOxygenList.size() * 150;
				StringBuilder xAxisBuilder = new StringBuilder();
				StringBuilder yAxisPulseBuilder = new StringBuilder();
				StringBuilder yAxisoxygeBuilder = new StringBuilder();
				// 拼接前台要显示的数据格式
				for (BloodOxygen bloodOxygen : bloodOxygenList) {
					xAxisBuilder.append("'" + bloodOxygen.getMeaTime() + "'");
					xAxisBuilder.append(",");
					yAxisoxygeBuilder.append(bloodOxygen.getOxygen());
					yAxisoxygeBuilder.append(",");
					yAxisPulseBuilder.append(bloodOxygen.getPulse());
					yAxisPulseBuilder.append(",");

				}
				// x轴数据
				xAxis = "["
						+ xAxisBuilder.deleteCharAt(xAxisBuilder.length() - 1)
								.toString() + "]";
				// 血氧数据
				 yAxisOxygen = "["
						+ yAxisoxygeBuilder.deleteCharAt(
								yAxisoxygeBuilder.length() - 1).toString()
						+ "]";
				// 脉率数据
				 yAxisPulse = "["
						+ yAxisPulseBuilder.deleteCharAt(
								yAxisPulseBuilder.length() - 1).toString()
						+ "]";
			} else {
				xAxis = "[0]";
				yAxisPulse = "[0]";
				yAxisOxygen = "[0]";
				if(healthFile!=null&&localHealthFile==null){
					return "bloodOxygenTendAnalysisAdvice";
				}
				return "bloodOxygenTendAnalysis";
			}
		}
		if(healthFile!=null&&localHealthFile==null){
			return "bloodOxygenTendAnalysisAdvice";
		}
		return "bloodOxygenTendAnalysis";
	}

	/**
	 * 血氧数据详情
	 * 
	 * @return
	 */
	public String bloodOxygenDataDetail() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		// 根据档案id 获取档案实体
        ////////////***********方法修改******************//////
		String appUserId;
		localHealthFile = healthFileService.getHealthFileById(healthFileId);
		if(localHealthFile==null){
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			appUserId=healthFileId+"--"+healthFile.getIdNum();
			healthFile.setId(-healthFileId);
			}
		else {
			appUserId=healthFileId+"--"+localHealthFile.getIdNum();
		}
		Page<BloodOxygen> page1 = new Page<BloodOxygen>();
		page1.setCurrentPage(cp);
		String resultJson = ""; // 返回的数据json串
		if(start!=null||end!=null){
			start=start.replace("/", " ");
			end=end.replace("/", " ");
			startTime=TypeConverter.stringToDate(start);
			endTime=TypeConverter.stringToDate(end);
		}
		if (searchType == 0 && startTime != null && endTime != null) { // 搜索条件按时间查询
			resultJson = healthManagerService.getBloodOxygenData(appUserId, startTime, endTime, page1.getCurrentPage(),
					page1.getPageSize());
			// 将json串转换成目标对象
			bloodOxygenCloud = JSON.parseObject(resultJson,
					BloodOxygenCloud.class);
			if (bloodOxygenCloud.getCode() == 0) {
				String jsonString = bloodOxygenCloud.getPage().getResult();
				bloodOxygenList = (List<BloodOxygen>) JSONArray.parseArray(
						jsonString, BloodOxygen.class);
				// 获取分页的总数
				if (bloodOxygenList.size() != 0) {
					page1.setTotalNum(bloodOxygenCloud.getPage().getTotal());
					//用于时间回显
			        start=TypeConverter.convertDate2String(startTime, "yyyy-MM-dd HH:mm:ss");
			        start=start.replace(" ", "/");
			        end=TypeConverter.convertDate2String(endTime, "yyyy-MM-dd HH:mm:ss");
			        end=end.replace(" ", "/");
			        if(healthFile!=null){
						healthFileId=-healthFileId;
					}
					this.pageHtml = page1
							.getPage("HealthManagerAction!bloodOxygenDataDetail.action?healthFileId="
							+ healthFileId+"&start="+ start + "&end="+ end+"&searchType="+searchType+"&embeded="+embeded);
				}
			}
		} else if (searchType == 1 && totalSize != null) { // 搜索条件按条数查询
			resultJson = healthManagerService
					.getBloodOxygenData(appUserId, totalSize,
							page1.getCurrentPage(), page1.getPageSize());
			// 将json串转换成目标对象
			bloodOxygenCloud = JSON.parseObject(resultJson,
					BloodOxygenCloud.class);
			if (bloodOxygenCloud.getCode() == 0) {
				String jsonString = bloodOxygenCloud.getPage().getResult();
				bloodOxygenList = (List<BloodOxygen>) JSONArray.parseArray(
						jsonString, BloodOxygen.class);
				// 获取分页的总数
				if (bloodOxygenList.size() != 0) {
					page1.setTotalNum(bloodOxygenCloud.getPage().getTotal());
					if(healthFile!=null){
						healthFileId=-healthFileId;
					}
					this.pageHtml = page1
							.getPage("HealthManagerAction!bloodOxygenDataDetail.action?healthFileId="
							+healthFileId+"&searchType="+searchType+"&totalSize="+ totalSize+"&embeded="+embeded);
				}
			}
		} 
		// 按照时间排序
		Collections.sort(bloodOxygenList, new Comparator<BloodOxygen>() {
			@Override
			public int compare(BloodOxygen o1, BloodOxygen o2) {
				Date time1 = TypeConverter.convertString2Date(o1.getMeaTime(),
						"yyyy-MM-dd HH:mm:ss");
				Date time2 = TypeConverter.convertString2Date(o2.getMeaTime(),
						"yyyy-MM-dd HH:mm:ss");
				if (time2.before(time1)) {
					return 1;
				} else if (time2.after(time1)) {
					return -1;
				} else {
					return 0;
				}
			}
		});
		if(healthFile!=null&&localHealthFile==null){
			return "bloodOxygenDataDetailAdvice";
		}
		return "bloodOxygenDataDetail";
	}

	/**
	 * 删除自己上传的血氧数据
	 * 
	 * @return
	 */
	public String deleteBloodOxygenDataCloud() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		// 删除上传的血氧数据并返回反馈信息
		message = healthManagerService.deleteBOCloud(cloudId);
		return "deleteBloodOxygenDataCloud";
	}

	/**
	 * 跳转修改云端血氧数据页
	 * 
	 * @return
	 */
	public String toEditBOCloud() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		// 根据档案id 获取档案实体
        ////////////***********方法修改******************//////
		localHealthFile = healthFileService.getHealthFileById(healthFileId);
		if(localHealthFile==null){       
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			healthFile.setId(-healthFileId);
			return "toEditBOCloudAdvice";
		}
		else {
			return "toEditBOCloud";
		}
	
	}

	/**
	 * 修改云端血氧数据
	 * 
	 * @return
	 */
	public String editBOCloud() {
		// 根据档案id 获取档案实体
        ////////////***********方法修改******************//////
		String appUserId;
		localHealthFile = healthFileService.getHealthFileById(healthFileId);
		if(localHealthFile==null){       
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			appUserId=healthFileId+"--"+healthFile.getIdNum();
			healthFile.setId(-healthFileId);
		}
		else {
			appUserId=healthFileId+"--"+localHealthFile.getIdNum();
		}
		bloodOxygen.setAppUserID(appUserId);
		if (bloodOxygen.getAnalysisResult() == null
				|| bloodOxygen.getMeaTime() == null
				|| bloodOxygen.getOxygen() == 0 || bloodOxygen.getPulse() == 0) {
			if(healthFile!=null&&localHealthFile==null){
				return "toEditBOCloudAdvice";
			}
			return "toEditBOCloud";
		}
		// 修改数据并返回反馈信息
		message = healthManagerService.updateBOCloud(cloudId, bloodOxygen);
		return "bloodOxygenDataDetailRed";
	}

	/**
	 * 一体机进入页面
	 * 
	 * @return
	 */
	public String getAllInOneData() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		// 根据档案id 获取档案实体
        ////////////***********方法修改******************//////
		String iphone;
		localHealthFile = healthFileService.getHealthFileById(healthFileId);     //本地老人
		if(localHealthFile==null){
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			iphone=healthFile.getiPhone();
			healthFile.setId(-healthFileId);
		}
		else{
			iphone=localHealthFile.getIPhone();
		}
		Page<AllInOneCloud> page = new Page<AllInOneCloud>();
		page.setCurrentPage(cp);
		// 返回的json串
		String resultJson = healthManagerService.getAIOData(iphone,
				page.getCurrentPage(), page.getPageSize());
		// 将json串转化成实体
		AllInOneCloud allInOneCloud = JSON.parseObject(resultJson,
				AllInOneCloud.class);
		if (allInOneCloud.getCode() == 0) {
			String jsonString = allInOneCloud.getPage().getResult();
			aios = (List<AllInOne>) JSONArray.parseArray(jsonString,
					AllInOne.class);
			page.setTotalNum(allInOneCloud.getPage().getTotal());
			if(healthFile!=null){
				healthFileId=-healthFileId;
			}
			this.pageHtml = page
					.getPage("HealthManagerAction!getAllInOneData.action?healthFileId="+healthFileId+"&embeded="+embeded);
		} else {
			message = allInOneCloud.getMessage();
		}
		if(healthFile!=null&&localHealthFile==null){
			return "getAllInOneDataAdvice";
		}
		return "getAllInOneData";
	}

	/**
	 * 获得指定老人的健康一体机报表
	 * 
	 * @return
	 */
	public String getPhysicalExamByHealthFileId() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		// 根据档案id 获取档案实体
        ////////////***********方法修改******************//////
		localHealthFile = healthFileService.getHealthFileById(healthFileId);
		if(localHealthFile==null){
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			healthFile.setId(-healthFileId);
			//TStaff tStaff = (TStaff) ActionContext.getContext().getSession().get("tstaff");
			return "getPhysicalExamByHealthFileIdAdvice";
		}
		//healthFile = healthManagerService.getHealthfileCloudById(Math.abs(healthFileId));
		voldStaff = healthFileService.getOldStaffByhealthId(healthFileId);
		return "getPhysicalExamByHealthFileId";
	}

	/**
	 * 一体机数据的四个页面
	 * 
	 * @return
	 */
	public String getAllInOneFromCloud() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		// 根据档案id 获取档案实体
		String iphone;
		localHealthFile = healthFileService.getHealthFileById(healthFileId);     //本地老人
		if(localHealthFile==null){
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			iphone=healthFile.getiPhone();
			healthFile.setId(-healthFileId);
		}
		else{
			iphone=localHealthFile.getIPhone();
		}
		switch (bloodForward) {
		case 0:
			if(healthFile!=null&&localHealthFile==null){
				return "getAllInOneFromCloudAdvice0";
			}
			return "getAllInOneFromCloud0"; // 返回数据分析页
		case 1:
			if(healthFile!=null&&localHealthFile==null){
				return "getAllInOneFromCloudAdvice1";
			}
			return "getAllInOneFromCloud1"; // 返回趋势分析页
		case 2:
			Page<AllInOne> page = new Page<AllInOne>();
			page.setCurrentPage(cp);
			String resultJson = "";
			//这里的接口正在协调中
			resultJson = healthManagerService.getAIOData(iphone,
				page.getCurrentPage(), page.getPageSize());
			AllInOneCloud allInOneCloud = JSON.parseObject(resultJson,
					AllInOneCloud.class);
			if (allInOneCloud.getCode() == 0) {
				String jsonString = allInOneCloud.getPage().getResult();
				aios = (List<AllInOne>) JSONArray.parseArray(jsonString,
						AllInOne.class);
				sortAllInOne(aios, "测量时间");
			}
			page.setTotalNum(allInOneCloud.getPage().getTotal());
			this.pageHtml = page
					.getPage("HealthManagerAction!getAllInOneFromCloud.action?bloodForward=2&healthFileId="
							+ healthFileId+"&embeded="+embeded);
			if(healthFile!=null&&localHealthFile==null){
				return "getAllInOneFromCloudAdvice2";
			}
			return "getAllInOneFromCloud2"; // 返回数据详细页
		default:
			if(healthFile!=null&&localHealthFile==null){
				return "getAllInOneFromCloudAdvice0";
			}
			return "getAllInOneFromCloud0"; // 返回数据分析页
		}
	}

	/**
	 * 一体机数据的数据分析
	 * 
	 * @return
	 */
	public String allInOneDataAnalysis() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		// 根据档案id 获取档案实体
        ////////////***********方法修改******************//////
		String iphone;
		localHealthFile = healthFileService.getHealthFileById(healthFileId);     //本地老人
		if(localHealthFile==null){
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			iphone=healthFile.getiPhone();
			healthFile.setId(-healthFileId);
		}
		else{
			iphone=localHealthFile.getIPhone();
		}
		String resultJson = ""; // 返回的数据json串
		if (searchType == 0 && startTime != null && endTime != null) { // 搜索条件按时间查询
			resultJson = healthManagerService.getAIODataByTime(iphone, 1, 1000, startTime, endTime);
			// result":[{"appKey":"ac6b5a57f3d04e328a1e79facc860e1d","appUserID":"0000001","basalMeta":333,
			// "bmi":111,"devID":28,"diaPre":494,"fat":333,"fbs":445,"height":443,"id":4,"meaTime":"2011-01-01 10:03:40",
			// "oxygen":222,"pbs":447,"pulse":333,"rbs":464,"sysPre":484,"temperature":33,"weight":442,"xyjy":"","xypg":""},
		} else if (searchType == 1 && totalSize != null) { // 搜索条件按条数查询
			resultJson = healthManagerService.getAIODataByCount(iphone, 1, 1000, totalSize);
		} else {
			if(healthFile!=null&&localHealthFile==null){
				return "allInOneDataAnalysisAdvice";
			}
			return "allInOneDataAnalysis";
		}
		AllInOneCloud allInOneCloud = JSON.parseObject(resultJson,
				AllInOneCloud.class);
		if (allInOneCloud.getCode() == 0) {
			String jsonString = allInOneCloud.getPage().getResult();
			aios = (List<AllInOne>) JSONArray.parseArray(jsonString,
					AllInOne.class);
			
			// 用于存放血压的前台展示数据
			bloodAIO = new ArrayList<AllInOne>();
			// 用于存放血糖的前台展示数据
			sugerAIO = new ArrayList<AllInOne>();
			// 求血压的三个展示数据的值
			// 按照收缩压排序
			if (aios.size() != 0) {
				sortAllInOne(aios, "收缩压值");
				bloodAIO.add(aios.get(0));
				bloodAIO.add(aios.get(aios.size()-1));
				// 按照舒张压排序
				sortAllInOne(aios, "舒张压值");//可以得到舒展张压最高低值
				bloodAIO.add(aios.get(0));
				bloodAIO.add(aios.get(aios.size()-1));
				// 按照血压排序
				sortAllInOne(aios, "血压值");//可以得到舒展张压最高低值
				bloodAIO.add(aios.get(0));
				bloodAIO.add(aios.get(aios.size()-1));
				
				AllInOne aIO = new AllInOne();
				double diaPre = 0;
				double sysPre = 0;
				int pulse = 0;
				// 计算求平均值
				for (AllInOne aio : aios) {
					sysPre = sysPre + aio.getSysPre();
					diaPre = diaPre + aio.getDiaPre();
					pulse = pulse + aio.getPulse();
				}
				try {
					aIO.setSysPre(sysPre / aios.size());
					aIO.setDiaPre(diaPre / aios.size());
					aIO.setPulse(pulse / aios.size());
				} catch (Exception e) {
					e.printStackTrace();
				}
				bloodAIO.add(aIO);
				
				// 求血糖展示数据的值
				sortAllInOne(aios, "餐前血糖值");
				sugerAIO.add(aios.get(0));        //取空腹血糖最高[0]
				sugerAIO.add(aios.get(aios.size() - 1));//取空腹血糖最低[1]
			
				sortAllInOne(aios, "餐后血糖值");//取餐后血糖最高
				sugerAIO.add(aios.get(0));
				sugerAIO.add(aios.get(aios.size() - 1));
				sortAllInOne(aios, "随机血糖值");
				sugerAIO.add(aios.get(0));
				sugerAIO.add(aios.get(aios.size() - 1));
				// 计算求平均值
				double fbs=0,pbs=0,rbs=0;
				for (AllInOne aio : aios) {
					fbs=fbs+aio.getFbs();
					pbs=pbs+aio.getPbs();
					rbs=rbs+aio.getRbs();
				}
				try {
					aIO.setFbs(fbs / aios.size());
					aIO.setPbs(pbs / aios.size());
					aIO.setRbs(rbs / aios.size());
				} catch (Exception e) {
					e.printStackTrace();
				}
				sugerAIO.add(aIO);
			} 
		}
		if(healthFile!=null&&localHealthFile==null){
			return "allInOneDataAnalysisAdvice";
		}
		return "allInOneDataAnalysis";
	}

	/**
	 * 一体机数据的趋势分析
	 * 
	 * @return
	 */
	public String allInOneTendAnalysis() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		// 根据档案id 获取档案实体
        ////////////***********方法修改******************//////
		String iphone;
		localHealthFile = healthFileService.getHealthFileById(healthFileId);     //本地老人
		if(localHealthFile==null){
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			iphone=healthFile.getiPhone();
			healthFile.setId(-healthFileId);
		}
		else{
			iphone=localHealthFile.getIPhone();
		}
		String resultJson = ""; // 返回的数据json串
		if (searchType == 0 && startTime != null && endTime != null) { // 搜索条件按时间查询
			resultJson = healthManagerService.getAIODataByTime(iphone, 1, 1000, startTime, endTime);
		} else if (searchType == 1 && totalSize != null) { // 搜索条件按条数查询
			resultJson = healthManagerService.getAIODataByCount(iphone, 1, 1000, totalSize);
		} else {
			searchType = 0;
			if(healthFile!=null&&localHealthFile==null){
				return "allInOneDataAnalysisAdvice";
			}
			return "allInOneTendAnalysis";
		}
		AllInOneCloud allInOneCloud = JSON.parseObject(resultJson,
				AllInOneCloud.class);
		if (allInOneCloud.getCode() == 0) {
			String jsonString = allInOneCloud.getPage().getResult();
			aios = (List<AllInOne>) JSONArray.parseArray(jsonString,
					AllInOne.class);
			if (aios.size() != 0) {
				sortAllInOne(aios, "测量时间");
				scrollLength = aios.size() * 150;
				StringBuilder xAxisBuilder = new StringBuilder();
				StringBuilder yAxisBuilderHigh = new StringBuilder();
				StringBuilder yAxisBuilderLow = new StringBuilder();
				StringBuilder yAxisBuilderPulse = new StringBuilder();
				StringBuilder yAxisBuilderPbs = new StringBuilder();
				StringBuilder yAxisBuilderFbs = new StringBuilder();
				StringBuilder yAxisBuilderRbs = new StringBuilder();
				StringBuilder yAxisBuilderOxygen = new StringBuilder();
				// 按照highchars格式要求拼接数据
				for (AllInOne aio : aios) {
					xAxisBuilder.append("'" + aio.getMeaTime() + "'");
					xAxisBuilder.append(",");
					yAxisBuilderHigh.append(aio.getSysPre());
					yAxisBuilderHigh.append(",");
					yAxisBuilderLow.append(aio.getDiaPre());
					yAxisBuilderLow.append(",");
					yAxisBuilderPulse.append(aio.getPulse());
					yAxisBuilderPulse.append(",");
					yAxisBuilderPbs.append(aio.getPbs());
					yAxisBuilderPbs.append(",");
					yAxisBuilderFbs.append(aio.getFbs());
					yAxisBuilderFbs.append(",");
					yAxisBuilderRbs.append(aio.getRbs());
					yAxisBuilderRbs.append(",");
					yAxisBuilderOxygen.append(aio.getOximeter());
					yAxisBuilderOxygen.append(",");
				}
				xAxisBuilder.deleteCharAt(xAxisBuilder.length() - 1);
				yAxisBuilderHigh.deleteCharAt(yAxisBuilderHigh.length() - 1);
				yAxisBuilderLow.deleteCharAt(yAxisBuilderLow.length() - 1);
				yAxisBuilderPulse.deleteCharAt(yAxisBuilderPulse.length() - 1);
				yAxisBuilderOxygen
						.deleteCharAt(yAxisBuilderOxygen.length() - 1);
				yAxisBuilderFbs.deleteCharAt(yAxisBuilderFbs.length() - 1);
				yAxisBuilderPbs.deleteCharAt(yAxisBuilderPbs.length() - 1);
				yAxisBuilderRbs.deleteCharAt(yAxisBuilderRbs.length() - 1);
				// x轴数据
				xAxis = "[" + xAxisBuilder.toString() + "]";
				// 收缩压数据
				yAxisHigh = "[" + yAxisBuilderHigh.toString() + "]";
				// 舒张压数据
				yAxisLow = "[" + yAxisBuilderLow.toString() + "]";
				// 脉率数据值
				yAxisPulse = "[" + yAxisBuilderPulse.toString() + "]";
				// 血氧数据
				yAxisOxygen = "[" + yAxisBuilderOxygen.toString() + "]";
				// 餐前血糖数据
				yAxisFbs = "[" + yAxisBuilderFbs.toString() + "]";
				// 餐后血糖数据
				yAxisPbs = "[" + yAxisBuilderPbs.toString() + "]";
				// 随机血糖数据
				yAxisRbs = "[" + yAxisBuilderRbs.toString() + "]";
			} 
		}
		if(healthFile!=null&&localHealthFile==null){
			return "allInOneTendAnalysisAdvice";
		}
		return "allInOneTendAnalysis";
	}

	/**
	 * 一体机详细数据
	 * 
	 * @return
	 */
	public String allInOneDataDetail() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
		Page<AllInOne> page = new Page<AllInOne>();
		page.setCurrentPage(cp);
		// 根据档案id 获取档案实体
        ////////////***********方法修改******************//////
		String iphone;
		localHealthFile = healthFileService.getHealthFileById(healthFileId);     //本地老人
		if(localHealthFile==null){
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			iphone=healthFile.getiPhone();
			healthFile.setId(-healthFileId);
		}
		else{
			iphone=localHealthFile.getIPhone();
		}
		String resultJson = ""; // 返回的数据json串
		if(start!=null||end!=null){
			start=start.replace("/", " ");
			end=end.replace("/", " ");
			startTime=TypeConverter.stringToDate(start);
			endTime=TypeConverter.stringToDate(end);
		}
		if (searchType == 0 && startTime != null && endTime != null) { // 搜索条件按时间查询
			//用于时间回显
	        start=TypeConverter.convertDate2String(startTime, "yyyy-MM-dd HH:mm:ss");
	        start=start.replace(" ", "/");
	        end=TypeConverter.convertDate2String(endTime, "yyyy-MM-dd HH:mm:ss");
	        end=end.replace(" ", "/");
			resultJson = healthManagerService.getAIODataByTime(iphone, page.getCurrentPage(), page.getPageSize(), startTime,
					endTime);
			if(healthFile!=null){
				healthFileId=-healthFileId;
			}
			this.pageHtml = page
					.getPage("HealthManagerAction!allInOneDataDetail.action?healthFileId="
								+ healthFileId+"&start="+ start + "&end="+ end+"&searchType="+searchType+"&embeded="+embeded);
		} else if (searchType == 1 && totalSize != null) { // 搜索条件按条数查询
			resultJson = healthManagerService.getAIODataByCount(iphone, page.getCurrentPage(), page.getPageSize(), totalSize);
			if(healthFile!=null){
				healthFileId=-healthFileId;
			}
			this.pageHtml = page
					.getPage("HealthManagerAction!allInOneDataDetail.action?healthFileId="
					+healthFileId+"&searchType="+searchType+"&totalSize="+ totalSize+"&embeded="+embeded);
		} else {
			return "allInOneDataDetailRed";
		}
		AllInOneCloud allInOneCloud = JSON.parseObject(resultJson,
				AllInOneCloud.class);
		if (allInOneCloud.getCode() == 0) {
			String jsonString = allInOneCloud.getPage().getResult();
			aios = (List<AllInOne>) JSONArray.parseArray(jsonString,
					AllInOne.class);
			sortAllInOne(aios, "测量时间");
		}
		page.setTotalNum(allInOneCloud.getPage().getTotal());
		if(healthFile!=null&&localHealthFile==null){
			return "allInOneDataDetailAdvice";
		}
		return "allInOneDataDetail";
	}

	/**
	 * 上传健康一体机健康评价指导数据
	 * 
	 * @return
	 */
	public String uploadAllInOne() {
		if (checkAddressHealthFileId(healthFileId).equals("error")) {
			return "error";
		}
        ////////////***********方法修改******************//////
		String iphone;
		localHealthFile = healthFileService.getHealthFileById(healthFileId);     //本地老人
		if(localHealthFile==null){
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			iphone=healthFile.getiPhone();
			healthFile.setId(-healthFileId);
		}
		else{
			iphone=localHealthFile.getIPhone();
		}
		healthManagerService.addHealthGuide(iphone, cloudId, advice,
				guide);
		return "uploadAllInOneRed";
	}

	/**
	 * 下载健康一体机报表
	 */
	@SuppressWarnings("static-access")
	public void downloadHealthReport() {

		Map<String, String> params = new HashMap<String, String>();
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		
		TCommunityHospital tc = (TCommunityHospital) session
				.getAttribute("comHospital");
		
		TStaff ts = (TStaff) session.getAttribute("tstaff");
        ////////////***********方法修改******************//////
		//healthFile = healthManagerService.getHealthfileCloudById(Math.abs(healthFileId));
		localHealthFile = healthFileService.getHealthFileById(healthFileId);     //本地老人
		if(localHealthFile!=null){
		THealthFile healthFile=localHealthFile;
		TOldStaffHos toldStaffhos = healthFileService
		.getOldStaffHosByHeathFileId(healthFile.getHealthFileId());
		if (tc != null) {
			params.put("communityHospital", tc.getCommunityHospital());
		}
		
		if (ts != null) {
			sqid = staffService.getCommHospitalByStaffId(ts.getStaffId());
			String communtityName = communityHospitalService
					.getCommunityHospitalById(sqid).getCommunityHospital();
			params.put("communityHospital", communtityName);
		}
		
		//向pdf中注入数据
		params.put("healthFileId", healthFileId + "");
		params.put("elderAge", healthFile.getAge() + "");

		params.put("healthFileNum", healthFile.getFileNum());
		params.put("eldeIdCard", healthFile.getIdNum());
		params.put("elderAge", healthFile.getAge() + "");
		params.put("staffName", toldStaffhos.getTStaff().getName());
		params.put(
				"eldeAdress",
				healthFile.getCurrentProvince() + healthFile.getCurrentCity()
						+ healthFile.getCurrentCounty()
						+ healthFile.getCurrentCommunity());
		params.put("pbs", pbs + "");

		params.put("elderName", healthFile.getName());
		params.put("elderPhone", healthFile.getIPhone());
		params.put("elderAdress", healthFile.getCurrentCommunity());
		
		if (healthFile.getSex() == true) {
			params.put("elderSex", "女");
		}
		if (healthFile.getSex() == false) {
			params.put("elderSex", "男");
		}
		params.put("currentTime",
				TypeConverter.convertDate2String(new Date(), "yyyy-MM-dd") +"  "+"制");
		params.put("BMI", bmia);
		params.put("diaPre", diaPre + "");
		params.put("fat", fat + "");
		params.put("fbs", fbs + "");
		params.put("height", height + "");
		params.put("jkpj", advice);
		params.put("jkzd", guide);
		params.put("meaTime", meaTime);
		params.put("oximeter", oxygen + "");
		params.put("pulse", pulse + "");
		params.put("rbs", rbs + "");
		params.put("sysPre", sysPre + "");
		params.put("temperature", temperature + "");
		params.put("weight", weight + "");
		
		//一体机模板文件
		String pdfFormFile = "/downloadFile/HealthReportTem/HealthReport.pdf";
		
		//一体机报告生成目录
		String aimPdfPath = "/downloadFile/downloadHealthReport";
		
		//创建pdf工具类
		PDFUtils puPdfUtils = new PDFUtils();
		
		//调用pdf工具类,在目标路径下生成一体机报告
		outPutPath = puPdfUtils.fromPDFTempletToPdfWithValue(pdfFormFile,
				params, aimPdfPath, healthFileId);

		//截取文件在应用中的路径
		String inputPath = outPutPath.substring(
				outPutPath.indexOf("downloadFile")).replace('\\', '/');
			
		//文件类型
		String fileType = outPutPath.substring(outPutPath.lastIndexOf("."));
		
		//文件名
		String filename=healthFileId+fileType;
		
		try {
			
			//下载一体机报告
			UploadAndDownload.download(inputPath, filename);
			
			// 下载完之后,为了避免过多占用服务器磁盘空间,此文件将被删除,但是会保留空文件夹,文件夹名称为此文件下载时间
			try {
				this.clearFiles(inputPath);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		
		//老人从中心服务器中获取的一体数据
		if(localHealthFile==null){
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			healthFile.setId(-healthFileId);
				//TOldStaffHos toldStaffhos = healthFileService
				//.getOldStaffHosByHeathFileId(healthFile.getHealthFileId());
				if (tc != null) {
					params.put("communityHospital", tc.getCommunityHospital());
				}
				
				if (ts != null) {
					sqid = staffService.getCommHospitalByStaffId(ts.getStaffId());
					String communtityName = communityHospitalService
							.getCommunityHospitalById(sqid).getCommunityHospital();
					params.put("communityHospital", communtityName);
				}
				
				//向pdf中注入数据
				params.put("healthFileId", healthFileId + "");
				params.put("elderAge", healthFile.getAge() + "");

				params.put("healthFileNum", healthFile.getFileNum());
				params.put("eldeIdCard", healthFile.getIdNum());
				params.put("elderAge", healthFile.getAge() + "");
				params.put("staffName", ts.getName());
				params.put(
						"eldeAdress",
						healthFile.getCurrentProvince() + healthFile.getCurrentCity()
								+ healthFile.getCurrentCounty()
								+ healthFile.getCurrentCommunity());
				params.put("pbs", pbs + "");

				params.put("elderName", healthFile.getName());
				params.put("elderPhone", healthFile.getiPhone());
				params.put("elderAdress", healthFile.getCurrentCommunity());
				
				if (healthFile.getSex() == true) {
					params.put("elderSex", "女");
				}
				if (healthFile.getSex() == false) {
					params.put("elderSex", "男");
				}
				params.put("currentTime",
						TypeConverter.convertDate2String(new Date(), "yyyy-MM-dd") +"  "+"制");
				params.put("BMI", bmia);
				params.put("diaPre", diaPre + "");
				params.put("fat", fat + "");
				params.put("fbs", fbs + "");
				params.put("height", height + "");
				params.put("jkpj", advice);
				params.put("jkzd", guide);
				params.put("meaTime", meaTime);
				params.put("oximeter", oxygen + "");
				params.put("pulse", pulse + "");
				params.put("rbs", rbs + "");
				params.put("sysPre", sysPre + "");
				params.put("temperature", temperature + "");
				params.put("weight", weight + "");
				
				//一体机模板文件
				String pdfFormFile = "/downloadFile/HealthReportTem/HealthReport.pdf";
				
				//一体机报告生成目录
				String aimPdfPath = "/downloadFile/downloadHealthReport";
				
				//创建pdf工具类
				PDFUtils puPdfUtils = new PDFUtils();
				
				//调用pdf工具类,在目标路径下生成一体机报告
				outPutPath = puPdfUtils.fromPDFTempletToPdfWithValue(pdfFormFile,
						params, aimPdfPath, healthFileId);

				//截取文件在应用中的路径
				String inputPath = outPutPath.substring(
						outPutPath.indexOf("downloadFile")).replace('\\', '/');
					
				//文件类型
				String fileType = outPutPath.substring(outPutPath.lastIndexOf("."));
				
				//文件名
				String filename=healthFileId+fileType;
				
				try {
					
					//下载一体机报告
					UploadAndDownload.download(inputPath, filename);
					
					// 下载完之后,为了避免过多占用服务器磁盘空间,此文件将被删除,但是会保留空文件夹,文件夹名称为此文件下载时间
					try {
						this.clearFiles(inputPath);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				}
	}

	/**
	 * 删除文件
	 * @param workspaceRootPath
	 */
	private void clearFiles(String workspaceRootPath) {
		String path = ServletActionContext.getServletContext().getRealPath(
				"/"+workspaceRootPath);
		File file = new File(path);

		if (file.exists()) {
			deleteFile(file);
		}
	}

	/**
	 * 删除文件
	 * @param file
	 */
	private void deleteFile(File file) {
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) {
				deleteFile(files[i]);
			}
		}
		file.delete();
	}
	
	
	
	
//************************以下为工具方法***************************//	

	
	/**
	 * 获取体检的分页相关信息
	 * @return
	 */
	public HealthPhysicEx getPhysicExemPageInfo(int healthFileId,String belongSys){
		
		String resultJson = healthManagerService.getPhysicExemCloud(healthFileId,belongSys,1,10);
		return JSON.parseObject(resultJson,HealthPhysicEx.class);
	}
	/**
	 * 获取建议的分页相关信息
	 * @return
	 */
	public HealthSuggest getSuggestPageInfo(int healthFileId,String belongSys){
		
		String resultJson = healthManagerService.getSuggestsByHealthFileId(healthFileId,belongSys,1,10);
		return JSON.parseObject(resultJson,HealthSuggest.class);
	}
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

	/**
	 * 判断老人是否为该责任医生下
	 * @param healthFileId
	 * @return
	 */
	public String checkAddressHealthFileId(int healthFileId) {
		/**
		 * 等接口，他们那边返回是否属于该责任医生、社区负责人、社区集团
		 */
		
		/*// 从session里拿到当前登录用户的id
		int person = GetSessionPerson.getPerson();
		if (person < 0) {
			if (oldStaffHosService.oldInHos(healthFileId, Math.abs(person)) == false) {
				return "error";
			}
		}
		if (person > 0) {
			// 责任医生
			if (healthFileService.getOldStaffHosByStaffId(person)) {
				// 判断老人在不在责任医生和该社区下
				if (!oldStaffHosService.oldInSpecialHos(healthFileId, person)) {
					return "error";
				}
			}
		}*/
		return "pass";
	}

	/**
	 * 自己使用的工具方法 ,用于比较字符串类型的日期是否在另外两个字符串日期中间
	 * 
	 * @param reallyTime
	 *            传入的真实时间
	 * @param bloorTime
	 *            下限时间
	 * @param ceilTime
	 *            上限时间
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
		/*if(date2.equals(date1)||date3.equals(date1)){
			return true;
		}*/
		return false;
	}

	/**
	 * 对各血糖测量状态的排序
	 * 
	 * @param bloodSugers
	 *            要排序的list
	 */
	public void sort(List<BloodSuger> bloodSugers, String sortParams) {
		if (sortParams.equals("血糖值")) {
			Collections.sort(bloodSugers, new Comparator<BloodSuger>() {
				@Override
				public int compare(com.jmjk.pojo.BloodSuger o1,
						com.jmjk.pojo.BloodSuger o2) {
					if (o1.getBloodSugar() < o2.getBloodSugar()) {
						return 1;
					} else if (o1.getBloodSugar() > o2.getBloodSugar()) {
						return -1;
					} else {
						return 0;
					}
				}
			});
		}
		if (sortParams.equals("测量时间")) {
			Collections.sort(bloodSugers, new Comparator<BloodSuger>() {
				@Override
				public int compare(com.jmjk.pojo.BloodSuger o1,
						com.jmjk.pojo.BloodSuger o2) {
					Date time1 = TypeConverter.convertString2Date(
							o1.getMeaTime(), "yyyy-MM-dd HH:mm:ss");
					Date time2 = TypeConverter.convertString2Date(
							o2.getMeaTime(), "yyyy-MM-dd HH:mm:ss");
					if (time2.before(time1)) {
						return 1;
					} else if (time2.after(time1)) {
						return -1;
					} else {
						return 0;
					}
				}
			});
		}
	}

	/**
	 * 求list中的血糖平均值
	 * 
	 * @param bloodSugers
	 *            血糖列表
	 * @return
	 */
	public double getBloodSugerAvg(List<BloodSuger> bloodSugers)
			throws Exception {
		double sumSuger = 0;
		for (BloodSuger bloodSuger : bloodSugers) {
			sumSuger += bloodSuger.getBloodSugar();
		}
		if (bloodSugers.size() != 0) {
			return sumSuger / bloodSugers.size();
		} else {
			return 0;
		}
	}

	/**
	 * 根据传入的实体，返回可以在前台进行趋势展示的字符串
	 * 
	 * @param bloodSugers
	 * @return
	 */
	public List<String> getXAxisAndYAxis(List<BloodSuger> bloodSugers) {

		StringBuilder xAxisBuilder = new StringBuilder();
		StringBuilder yAxisBuilder = new StringBuilder();
		for (BloodSuger bloodSuger : bloodSugers) {

			xAxisBuilder.append("'" + bloodSuger.getMeaTime() + "'");
			xAxisBuilder.append(",");
			yAxisBuilder.append(bloodSuger.getBloodSugar());
			yAxisBuilder.append(",");
		}
		xAxisBuilder.deleteCharAt(xAxisBuilder.length() - 1);
		yAxisBuilder.deleteCharAt(yAxisBuilder.length() - 1);
		List<String> axis = new ArrayList<String>();
		axis.add("[" + xAxisBuilder + "]");
		axis.add("[" + yAxisBuilder + "]");
		return axis;
	}
	
	/**
	 * 对一体机数据排序
	 * 
	 * @param aios
	 * @param sortName
	 */
	public void sortAllInOne(List<AllInOne> aios, String sortName) {

		if (sortName.equals("收缩压值")) {
			Collections.sort(aios, new Comparator<AllInOne>() {
				@Override
				public int compare(com.jmjk.pojo.AllInOne o1,
						com.jmjk.pojo.AllInOne o2) {

					if (o1.getSysPre() < o2.getSysPre()) {
						return 1;
					} else if (o1.getSysPre() > o2.getSysPre()) {
						return -1;
					} else {
						return 0;
					}
				}
			});
		}

		if (sortName.equals("舒张压值")) {
			Collections.sort(aios, new Comparator<AllInOne>() {
				@Override
				public int compare(com.jmjk.pojo.AllInOne o1,
						com.jmjk.pojo.AllInOne o2) {

					if (o1.getDiaPre() < o2.getDiaPre()) {
						return 1;
					} else if (o1.getDiaPre() > o2.getDiaPre()) {
						return -1;
					} else {
						return 0;
					}
				}
			});
		}
		
		if (sortName.equals("血压值")) {
			Collections.sort(aios, new Comparator<AllInOne>() {
				@Override
				public int compare(com.jmjk.pojo.AllInOne o1,
						com.jmjk.pojo.AllInOne o2) {

					if (o1.getPulse() < o2.getPulse()) {
						return 1;
					} else if (o1.getPulse() > o2.getPulse()) {
						return -1;
					} else {
						return 0;
					}
				}
			});
		}
		
		if (sortName.equals("餐前血糖值")) {
			Collections.sort(aios, new Comparator<AllInOne>() {
				@Override
				public int compare(com.jmjk.pojo.AllInOne o1,
						com.jmjk.pojo.AllInOne o2) {

					if (o1.getFbs() < o2.getFbs()) {
						return 1;
					} else if (o1.getFbs() > o2.getFbs()) {
						return -1;
					} else {
						return 0;
					}
				}
			});
		}
		if (sortName.equals("餐后血糖值")) {
			Collections.sort(aios, new Comparator<AllInOne>() {
				@Override
				public int compare(com.jmjk.pojo.AllInOne o1,
						com.jmjk.pojo.AllInOne o2) {

					if (o1.getPbs() < o2.getPbs()) {
						return 1;
					} else if (o1.getPbs() > o2.getPbs()) {
						return -1;
					} else {
						return 0;
					}
				}
			});
		}
		if (sortName.equals("随机血糖值")) {
			Collections.sort(aios, new Comparator<AllInOne>() {
				@Override
				public int compare(com.jmjk.pojo.AllInOne o1,
						com.jmjk.pojo.AllInOne o2) {

					if (o1.getRbs() < o2.getRbs()) {
						return 1;
					} else if (o1.getRbs() > o2.getRbs()) {
						return -1;
					} else {
						return 0;
					}
				}
			});

		}

		if (sortName.equals("测量时间")) {
			Collections.sort(aios, new Comparator<AllInOne>() {
				@Override
				public int compare(com.jmjk.pojo.AllInOne o1,
						com.jmjk.pojo.AllInOne o2) {
					Date time1 = TypeConverter.convertString2Date(
							o1.getMeaTime(), "yyyy-MM-dd HH:mm:ss");
					if(time1 == null){
						time1 = Calendar.getInstance().getTime();
					}
					Date time2 = TypeConverter.convertString2Date(
							o2.getMeaTime(), "yyyy-MM-dd HH:mm:ss");
					if(time2 == null){
						time2 = Calendar.getInstance().getTime();
					}
					if (time2.before(time1)) {
						return 1;
					} else if (time2.after(time1)) {
						return -1;
					} else {
						return 0;
					}
				}
			});
		}
	}

	
	
//************************以下为所有的setter和getter方法***************************//
	
	
	public List<VOldStaff> getVOldStaffs() {
		return vOldStaffs;
	}
	public void setVOldStaffs(List<VOldStaff> vOldStaffs) {
		this.vOldStaffs = vOldStaffs;
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
	public int getHealthFileId() {
		return healthFileId;
	}
	public void setHealthFileId(int healthFileId) {
		this.healthFileId = healthFileId;
	}
	public BloodPress getBloodPress() {
		return bloodPress;
	}
	public void setBloodPress(BloodPress bloodPress) {
		this.bloodPress = bloodPress;
	}
	public List<VMaintainable> getVMaintainables() {
		return vMaintainables;
	}
	public void setVMaintainables(List<VMaintainable> vMaintainables) {
		this.vMaintainables = vMaintainables;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUploadDataType() {
		return uploadDataType;
	}
	public void setUploadDataType(String uploadDataType) {
		this.uploadDataType = uploadDataType;
	}
	public BloodSuger getBloodSuger() {
		return bloodSuger;
	}
	public void setBloodSuger(BloodSuger bloodSuger) {
		this.bloodSuger = bloodSuger;
	}
	public BloodOxygen getBloodOxygen() {
		return bloodOxygen;
	}
	public void setBloodOxygen(BloodOxygen bloodOxygen) {
		this.bloodOxygen = bloodOxygen;
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
	public int getSearchType() {
		return searchType;
	}
	public void setSearchType(int searchType) {
		this.searchType = searchType;
	}
	public Integer getTotalSize() {
		return totalSize;
	}
	public void setTotalSize(Integer totalSize) {
		this.totalSize = totalSize;
	}
	public int getBloodForward() {
		return bloodForward;
	}
	public void setBloodForward(int bloodForward) {
		this.bloodForward = bloodForward;
	}
	public List<BloodPress> getBloodPresseList() {
		return bloodPresseList;
	}
	public void setBloodPresseList(List<BloodPress> bloodPresseList) {
		this.bloodPresseList = bloodPresseList;
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
	public int getScrollLength() {
		return scrollLength;
	}
	public void setScrollLength(int scrollLength) {
		this.scrollLength = scrollLength;
	}
	public String getYAxisPulse() {
		return yAxisPulse;
	}
	public void setYAxisPulse(String yAxisPulse) {
		this.yAxisPulse = yAxisPulse;
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
	public List<TRecoveryOld> getRecoveryOldList() {
		return recoveryOldList;
	}
	public void setRecoveryOldList(List<TRecoveryOld> recoveryOldList) {
		this.recoveryOldList = recoveryOldList;
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
	public TRecoveryPlan getRecoveryPlan() {
		return recoveryPlan;
	}
	public void setRecoveryPlan(TRecoveryPlan recoveryPlan) {
		this.recoveryPlan = recoveryPlan;
	}
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	public String getSchemaType() {
		return schemaType;
	}
	public void setSchemaType(String schemaType) {
		this.schemaType = schemaType;
	}
	public List<BloodSuger> getBloodSugerList() {
		return bloodSugerList;
	}
	public void setBloodSugerList(List<BloodSuger> bloodSugerList) {
		this.bloodSugerList = bloodSugerList;
	}
	public List<BloodOxygen> getBloodOxygens() {
		return bloodOxygens;
	}
	public void setBloodOxygens(List<BloodOxygen> bloodOxygens) {
		this.bloodOxygens = bloodOxygens;
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
	public TPhysicalExam getTPhysicalExam() {
		return tPhysicalExam;
	}
	public void setTPhysicalExam(TPhysicalExam tPhysicalExam) {
		this.tPhysicalExam = tPhysicalExam;
	}
	public int getRecoveryPlanId() {
		return recoveryPlanId;
	}
	public void setRecoveryPlanId(int recoveryPlanId) {
		this.recoveryPlanId = recoveryPlanId;
	}
	public String getRecoverStates() {
		return recoverStates;
	}
	public void setRecoverStates(String recoverStates) {
		this.recoverStates = recoverStates;
	}
	public List<BloodOxygen> getBloodOxygenList() {
		return bloodOxygenList;
	}
	public void setBloodOxygenList(List<BloodOxygen> bloodOxygenList) {
		this.bloodOxygenList = bloodOxygenList;
	}
	public String getYAxisOxygen() {
		return yAxisOxygen;
	}
	public void setYAxisOxygen(String yAxisOxygen) {
		this.yAxisOxygen = yAxisOxygen;
	}
	public AllInOne getAllInOne() {
		return allInOne;
	}
	public void setAllInOne(AllInOne allInOne) {
		this.allInOne = allInOne;
	}
	public List<AllInOne> getBloodAIO() {
		return bloodAIO;
	}
	public void setBloodAIO(List<AllInOne> bloodAIO) {
		this.bloodAIO = bloodAIO;
	}
	public List<AllInOne> getSugerAIO() {
		return sugerAIO;
	}
	public void setSugerAIO(List<AllInOne> sugerAIO) {
		this.sugerAIO = sugerAIO;
	}
	public String getYAxisFbs() {
		return yAxisFbs;
	}
	public void setYAxisFbs(String yAxisFbs) {
		this.yAxisFbs = yAxisFbs;
	}
	public String getYAxisPbs() {
		return yAxisPbs;
	}
	public void setYAxisPbs(String yAxisPbs) {
		this.yAxisPbs = yAxisPbs;
	}
	public String getYAxisRbs() {
		return yAxisRbs;
	}
	public void setYAxisRbs(String yAxisRbs) {
		this.yAxisRbs = yAxisRbs;
	}
	public IHealthFileService getHealthFileService() {
		return healthFileService;
	}
	public void setHealthFileService(IHealthFileService healthFileService) {
		this.healthFileService = healthFileService;
	}
	public IHealthManagerService getHealthManagerService() {
		return healthManagerService;
	}
	public void setHealthManagerService(
			IHealthManagerService healthManagerService) {
		this.healthManagerService = healthManagerService;
	}
	public IMaintainableEntryService getMaintainableEntryService() {
		return maintainableEntryService;
	}
	public void setMaintainableEntryService(
			IMaintainableEntryService maintainableEntryService) {
		this.maintainableEntryService = maintainableEntryService;
	}
	public IRecoveryPlanService getRecoveryPlanService() {
		return recoveryPlanService;
	}
	public void setRecoveryPlanService(IRecoveryPlanService recoveryPlanService) {
		this.recoveryPlanService = recoveryPlanService;
	}
	public IRecoverySchemeService getRecoverySchemeService() {
		return recoverySchemeService;
	}
	public void setRecoverySchemeService(
			IRecoverySchemeService recoverySchemeService) {
		this.recoverySchemeService = recoverySchemeService;
	}
	public ICommunityHospitalService getCommunityHospitalService() {
		return communityHospitalService;
	}
	public void setCommunityHospitalService(
			ICommunityHospitalService communityHospitalService) {
		this.communityHospitalService = communityHospitalService;
	}
	public IPhysicalExamService getPhysicalExamService() {
		return physicalExamService;
	}
	public void setPhysicalExamService(IPhysicalExamService physicalExamService) {
		this.physicalExamService = physicalExamService;
	}
	public StaffService getStaffService() {
		return staffService;
	}
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	public OldStaffHosService getOldStaffHosService() {
		return oldStaffHosService;
	}
	public void setOldStaffHosService(OldStaffHosService oldStaffHosService) {
		this.oldStaffHosService = oldStaffHosService;
	}
	public List<VOldStaff> getvOldStaffs() {
		return vOldStaffs;
	}
	public void setvOldStaffs(List<VOldStaff> vOldStaffs) {
		this.vOldStaffs = vOldStaffs;
	}
	public List<VMaintainable> getvMaintainables() {
		return vMaintainables;
	}
	public void setvMaintainables(List<VMaintainable> vMaintainables) {
		this.vMaintainables = vMaintainables;
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
	public String getyAxisOxygen() {
		return yAxisOxygen;
	}
	public void setyAxisOxygen(String yAxisOxygen) {
		this.yAxisOxygen = yAxisOxygen;
	}
	public TPhysicalExam gettPhysicalExam() {
		return tPhysicalExam;
	}
	public void settPhysicalExam(TPhysicalExam tPhysicalExam) {
		this.tPhysicalExam = tPhysicalExam;
	}
	public List<AllInOne> getAios() {
		return aios;
	}
	public void setAios(List<AllInOne> aios) {
		this.aios = aios;
	}
	public Page<VOldStaff> getPage() {
		return page;
	}
	public void setPage(Page<VOldStaff> page) {
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
	public static long getSerialversionuid() {
		return serialVersionUID;
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
	public List<BloodPress> getBloodPresses() {
		return bloodPresses;
	}
	public void setBloodPresses(List<BloodPress> bloodPresses) {
		this.bloodPresses = bloodPresses;
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
	public BloodOxygenCloud getBloodOxygenCloud() {
		return bloodOxygenCloud;
	}
	public void setBloodOxygenCloud(BloodOxygenCloud bloodOxygenCloud) {
		this.bloodOxygenCloud = bloodOxygenCloud;
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
	public Timestamp getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}
	public Timestamp getOverTime() {
		return overTime;
	}
	public void setOverTime(Timestamp overTime) {
		this.overTime = overTime;
	}
	public String getAppUserID() {
		return appUserID;
	}
	public void setAppUserID(String appUserID) {
		this.appUserID = appUserID;
	}
	public Integer getMeaState() {
		return meaState;
	}
	public void setMeaState(Integer meaState) {
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
	public Integer getArm() {
		return arm;
	}
	public void setArm(Integer arm) {
		this.arm = arm;
	}
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public String getMeaTime() {
		return meaTime;
	}
	public void setMeaTime(String meaTime) {
		this.meaTime = meaTime;
	}
	public Integer getDevID() {
		return devID;
	}
	public void setDevID(Integer devID) {
		this.devID = devID;
	}
	public Integer getTakeMed() {
		return takeMed;
	}
	public void setTakeMed(Integer takeMed) {
		this.takeMed = takeMed;
	}
	public String getMedName() {
		return medName;
	}
	public void setMedName(String medName) {
		this.medName = medName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Date getMeatime() {
		return meatime;
	}
	public void setMeatime(Date meatime) {
		this.meatime = meatime;
	}
	public void setMeaState(int meaState) {
		this.meaState = meaState;
	}
	public void setArm(int arm) {
		this.arm = arm;
	}
	public void setDevID(int devID) {
		this.devID = devID;
	}
	public void setTakeMed(int takeMed) {
		this.takeMed = takeMed;
	}
	public String getAdvice() {
		return advice;
	}
	public void setAdvice(String advice) {
		this.advice = advice;
	}
	public String getGuide() {
		return guide;
	}
	public void setGuide(String guide) {
		this.guide = guide;
	}
	public VOldStaff getVoldStaff() {
		return voldStaff;
	}
	public void setVoldStaff(VOldStaff voldStaff) {
		this.voldStaff = voldStaff;
	}
	public List<TCommunityHospital> getHospitals() {
		return hospitals;
	}
	public void setHospitals(List<TCommunityHospital> hospitals) {
		this.hospitals = hospitals;
	}
	public List<TRecoveryScheme> getSchemeList() {
		return schemeList;
	}
	public void setSchemeList(List<TRecoveryScheme> schemeList) {
		this.schemeList = schemeList;
	}
	public String getOutPutPath() {
		return outPutPath;
	}
	public void setOutPutPath(String outPutPath) {
		this.outPutPath = outPutPath;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public double getFbs() {
		return fbs;
	}
	public void setFbs(double fbs) {
		this.fbs = fbs;
	}
	public double getPbs() {
		return pbs;
	}
	public void setPbs(double pbs) {
		this.pbs = pbs;
	}
	public double getRbs() {
		return rbs;
	}
	public void setRbs(double rbs) {
		this.rbs = rbs;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getOximeter() {
		return oximeter;
	}
	public void setOximeter(double oximeter) {
		this.oximeter = oximeter;
	}
	public double getFat() {
		return fat;
	}
	public void setFat(double fat) {
		this.fat = fat;
	}
	public double getMuscle() {
		return muscle;
	}
	public void setMuscle(double muscle) {
		this.muscle = muscle;
	}
	public String getOxygen() {
		return oxygen;
	}
	public void setOxygen(String oxygen) {
		this.oxygen = oxygen;
	}
	public String getJkzd() {
		return jkzd;
	}
	public void setJkzd(String jkzd) {
		this.jkzd = jkzd;
	}
	public String getJkpj() {
		return jkpj;
	}
	public void setJkpj(String jkpj) {
		this.jkpj = jkpj;
	}
	public List<TStaff> getSpecialDoctor() {
		return specialDoctor;
	}
	public void setSpecialDoctor(List<TStaff> specialDoctor) {
		this.specialDoctor = specialDoctor;
	}
	public int getCp1() {
		return cp1;
	}
	public void setCp1(int cp1) {
		this.cp1 = cp1;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Page<VOldStaff> getPagePlus() {
		return pagePlus;
	}
	public void setPagePlus(Page<VOldStaff> pagePlus) {
		this.pagePlus = pagePlus;
	}
	public String getSearflag() {
		return searflag;
	}
	public void setSearflag(String searflag) {
		this.searflag = searflag;
	}
	public String getBmia() {
		return bmia;
	}
	public void setBmia(String bmia) {
		this.bmia = bmia;
	}
	public List<HealthFileCloud.Page.HealthFile> getHealthFileCloudList() {
		return healthFileCloudList;
	}
	public void setHealthFileCloudList(List<HealthFileCloud.Page.HealthFile> healthFileCloudList) {
		this.healthFileCloudList = healthFileCloudList;
	}
	
	public String getSuggestJson() {
		return suggestJson;
	}

	public void setSuggestJson(String suggestJson) {
		this.suggestJson = suggestJson;
	}
	
	public String getDoctorAdvice() {
		return doctorAdvice;
	}

	public void setDoctorAdvice(String doctorAdvice) {
		this.doctorAdvice = doctorAdvice;
	}
	public List<HealthSuggest.Page.Suggest> getSuggestList() {
		return suggestList;
	}

	public void setSuggestList(List<HealthSuggest.Page.Suggest> suggestList) {
		this.suggestList = suggestList;
	}
	
	public List<HealthPhysicEx.Page.PhysicEx> getPhysicExList() {
		return physicExList;
	}

	public void setPhysicExList(List<HealthPhysicEx.Page.PhysicEx> physicExList) {
		this.physicExList = physicExList;
	}
	public PhysicExemSingle getPhysicExemSingle() {
		return physicExemSingle;
	}

	public void setPhysicExemSingle(PhysicExemSingle physicExemSingle) {
		this.physicExemSingle = physicExemSingle;
	}
	
	public int getPhysicalExamId() {
		return physicalExamId;
	}

	public void setPhysicalExamId(int physicalExamId) {
		this.physicalExamId = physicalExamId;
	}
	public List<VHealthStaff> getVhealthStaffList() {
		return vhealthStaffList;
	}
	public void setVhealthStaffList(List<VHealthStaff> vhealthStaffList) {
		this.vhealthStaffList = vhealthStaffList;
	}
	
	public HealthFileSingleCloud.HealthFile getHealthFile() {
		return healthFile;
	}
	public void setHealthFile(HealthFileSingleCloud.HealthFile healthFile) {
		this.healthFile = healthFile;
	}
	public int getIssq() {
		return issq;
	}

	public void setIssq(int issq) {
		this.issq = issq;
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

	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	public void setIndexFlag(int indexFlag) {
		this.indexFlag = indexFlag;
	}
	public THealthFile getLocalHealthFile() {
		return localHealthFile;
	}
	public void setLocalHealthFile(THealthFile localHealthFile) {
		this.localHealthFile = localHealthFile;
	}
	public String getLocalOrClound() {
		return localOrClound;
	}
	public void setLocalOrClound(String localOrClound) {
		this.localOrClound = localOrClound;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getSuggestId() {
		return suggestId;
	}
	public void setSuggestId(int suggestId) {
		this.suggestId = suggestId;
	}
	public boolean isDoctorAdviceSwal() {
		return doctorAdviceSwal;
	}
	public void setDoctorAdviceSwal(boolean doctorAdviceSwal) {
		this.doctorAdviceSwal = doctorAdviceSwal;
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
	public String getWenti() {
		return wenti;
	}
	public void setWenti(String wenti) {
		this.wenti = wenti;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}



	public boolean isEmbeded() {
		return embeded;
	}



	public void setEmbeded(boolean embeded) {
		this.embeded = embeded;
	}




	
}
