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

import com.alibaba.fastjson.JSON;
import com.jmjk.action.base.BaseAction;
import com.jmjk.entity.TChronicDisease;
import com.jmjk.entity.TChronicFollow;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.TDiabetsFollow;
import com.jmjk.entity.TDrugInformation;
import com.jmjk.entity.TDrugInformationIncomplete;
import com.jmjk.entity.TFileLifeStyle;
import com.jmjk.entity.TFileMedicalRecord;
import com.jmjk.entity.THealthFile;
import com.jmjk.entity.THypertensiveFollow;
import com.jmjk.entity.TIncompleteRecord;
import com.jmjk.entity.TIncompleteRecord2;
import com.jmjk.entity.TLifestyleGuide;
import com.jmjk.entity.TMaintainableEntry;
import com.jmjk.entity.TMedicalPayMethod;
import com.jmjk.entity.TOldStaffHos;
import com.jmjk.entity.TPastHistory;
import com.jmjk.entity.TSign;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.view.VHealthStaff;
import com.jmjk.entity.view.VIncompleteRecord;
import com.jmjk.entity.view.VIncompleteRecord2;
import com.jmjk.entity.view.VStaffHos;
import com.jmjk.entity.view.VStaffHosSu;
import com.jmjk.enums.Admin_IsHead;
import com.jmjk.enums.HealthFileCheck;
import com.jmjk.export.incompleteExport;
import com.jmjk.export.incompleteExport2;
import com.jmjk.pojo.HealthFileCloud;
import com.jmjk.pojo.HealthFileCloudForDetail;
import com.jmjk.pojo.HealthFileCloud.Page.HealthFile;
import com.jmjk.pojo.HealthFileCloudForDetail.Item.PastHistory;
import com.jmjk.service.AllChronicDiseaseService;
import com.jmjk.service.ChronicFollowService;
import com.jmjk.service.CommunityHospitalGroupService;
import com.jmjk.service.CommunityHospitalService;
import com.jmjk.service.DiabetesService;
import com.jmjk.service.FileLifeStyleService;
import com.jmjk.service.FileMedicalRecordService;
import com.jmjk.service.HealthFileService;
import com.jmjk.service.HealthManagerService;
import com.jmjk.service.HighBloodPressureService;
import com.jmjk.service.IncompleteRecordService;
import com.jmjk.service.IncompleteRecordService2;
import com.jmjk.service.LifeAndSignService;
import com.jmjk.service.MaintainableAttributeService;
import com.jmjk.service.MedicalPayMethodService;
import com.jmjk.service.PastHistoryService;
import com.jmjk.service.SituationOfMedicationService;
import com.jmjk.service.SituationOfMedicationServiceSub;
import com.jmjk.service.StaffService;
import com.jmjk.utils.ChronicVerifyFollow;
import com.jmjk.utils.JxlExcel;
import com.jmjk.utils.Page;
import com.jmjk.utils.Resubmit;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.SearchBeanSU;
import com.jmjk.utils.TokenProccessor;
import com.jmjk.utils.TypeConverter;
import com.opensymphony.xwork2.ActionContext;
@Component
@Scope("prototype")
@Action(value="incompleteRecordAction2",results={
		@Result(name="success",location="/success.jsp"),
		@Result(name="showIncompleteRecord",location="/jsp/incompleteRecord2/incompleteRecordMain.jsp"),
		@Result(name="error",location="/error.jsp"),
		@Result(name="findIncompleteRecord",location="/jsp/incompleteRecord2/incompleteRecordAdd.jsp"),
		@Result(name="findAndAddIncompleteRecord",location="/jsp/incompleteRecord2/incompleteRecordAdd.jsp"),
		@Result(name="addIncompleteRecord",type = "redirectAction",location="incompleteRecordAction2!showIncompleteRecord.action"),
		@Result(name="turnToAddPersonIncompleteRecord",location="/jsp/incompleteRecord2/incompleteRecordAddPerson.jsp"),
//		@Result(name="turnToDetailIncompleteRecord",location="/jsp/incompleteRecord2/incompleteRecordDetail.jsp"),
		@Result(name="turnToDetailIncompleteRecord",location="/jsp/incompleteRecord2/incompleteRecordDetailNew.jsp"),
		@Result(name="deleteIncompleteRecord",type = "redirectAction",location="incompleteRecordAction2!showIncompleteRecord.action"),
		@Result(name="updateIncompleteRecord",type = "redirectAction",location="incompleteRecordAction2!showIncompleteRecord.action"),
		@Result(name="turnToUpdateIncompleteRecord",location="/jsp/incompleteRecord2/incompleteRecordAlter.jsp"),
		@Result(name="deleteMoreIncompleteRecord",type = "redirectAction",location="incompleteRecordAction2!showIncompleteRecord.action"),
		@Result(name="DocDRedir",type = "redirectAction",location="incompleteRecordAction2!showIncompleteRecord.action"),
		@Result(name="incompleteRecordError",type = "redirectAction",location="incompleteRecordAction2!findAndAddIncompleteRecord.action",params = {"str","${str}"}),
		@Result(name="searchIncompleteRecord",location="/jsp/incompleteRecord2/incompleteRecordMain.jsp"),
		@Result(name="searchIncompleteRecordKill",location="/jsp/incompleteRecord2/incompleteRecordMainPlus.jsp"),
		@Result(name="turnToHealthFileView", location="/jsp/incompleteRecord2/jkdaPart.jsp"),
		@Result(name="addDiabetsFromEmbeded", type = "redirectAction", location="incompleteRecordAction2!showIncompleteRecord.action"),
		
       })
public class IncompleteRecordAction2 extends BaseAction {
	@Autowired
	HealthManagerService healthManagerService;
	@Autowired
	HealthFileService healthFileService;
	@Autowired
	IncompleteRecordService2 incompleteRecordService;
	@Autowired
	StaffService staffService;
	@Autowired
	CommunityHospitalService communityHospitalService;
	@Autowired
	CommunityHospitalGroupService communityHospitalGroupService;
	@Autowired
	SituationOfMedicationServiceSub sOfMedicationService;// 用药情况表
	@Autowired
	SituationOfMedicationService sOfMedicationMxbService;// 用药情况表
	@Autowired
	MedicalPayMethodService medicalPayMethodService;
	@Autowired
	FileMedicalRecordService fileMedicalRecordService;
	@Autowired
	PastHistoryService pastHistoryService;
	@Autowired
	FileLifeStyleService  fileLifeStyleService;
	@Autowired
	ChronicFollowService chFollowService;// 慢病随访总表
	@Autowired
	AllChronicDiseaseService allChronicDiseaseService;// 慢病总表
	@Autowired
	LifeAndSignService lifeAndSignService;// 生活指导表
	@Autowired
	HighBloodPressureService highBloodPressureService;// 高血压及随访记录表
	@Autowired
	MaintainableAttributeService maintainableAttributeService;// 可维护字段
	@Autowired
	DiabetesService diabetesService;// 糖尿病及随访记录表
	
	private List<TDrugInformationIncomplete> listdrug;// 用药情况实体集合
	private TOldStaffHos oldstaffhos;// 老人,医院,员工
	private String token;
	private String tokenGxy;
	private String tokenTnb;
	private List<TStaff>  staffs;
	private boolean flagDuo=false;
	private List<VStaffHos> allEnterPeople;
	private SearchBeanSU searchbean;//（多条件查询）
	private List<VStaffHos> allDoctor;
	private  Page<VIncompleteRecord2>  page;
	private int hosId;
	private String pageHtml;//分页
	private List<VIncompleteRecord2> vincompleteRecordList;
	private int cp=1;
	private List<Object> allIncompleteRecordId;
	private int flag=2;//0是档案编号1是身份证号
	private THealthFile healthFile;
	Page<THealthFile> page2;
	Page<VHealthStaff> pagePlus;
	
	private HealthFile rHealthFile;//deprecated
	private int healthCloudId;
	private int belongSystemQianDuan;
	private int id;
	
	private int healthFileId;
	private int healthFileIdGxy;
	private int healthFileIdTnb;
	private TIncompleteRecord2 incompleteRecord;
	private int irId;
	private String value;//前台传来的档案编号或者身份证号Id内容
	private TCommunityHospital communityHospital;
	private TStaff  tstaff;
	private String str;
	private int conFlag; 
	private int issq = 2;//判断是否是平台管理员的状态量，用于是否显示社区医院搜索医院选项
	private List<TCommunityHospital> hospitals; //社区医院list
	private VIncompleteRecord2 vincompleteRecord;
	private int choice[];
	private boolean flagPingTai=false;
	private List<TStaff> specialDoctor;
	private List<VHealthStaff> listolder;
	private boolean showwindow;
	private List<TCommunityHospitalGroup> groups;
	private List<HealthFile> healthFileCloudList;
	private List<THealthFile> healthFileList;
	int state = 2;// 档案状态
	private boolean issetsearch;
	private List<TMedicalPayMethod> medicalPayMethodList;
	private List<String> medicalPayMethodNameList;
	private List<String> medicalPayMethodCardNumList;
	private VStaffHosSu vstaffHosSu;
	private String choiceResultAllergyName;
	private String choiceResultExposeName;
	private String choiceResultDisability;
	private String choiceResultFather;
	private String choiceResultMother;
	private String choiceResultBroSis;
	private String choiceResultChild;
	private List<TFileMedicalRecord>  fileMedicalRecordList;
	private List<TPastHistory> pastHistoryList;
	private List<TPastHistory> pastHistoryShouShuList;
	private List<TPastHistory> pastHistoryWaiShangList;
	private List<TPastHistory> pastHistoryShuXieList;
	//增加的子表：生活方式
	private TFileLifeStyle tlifestyle;
	private TFileLifeStyle tlifestyleGxy;
	private TFileLifeStyle tlifestyleTnb;
	private TChronicFollow chronicFollow;// 慢病随访总表实体
	private TChronicDisease chronicDisease;// 慢病总表实体
	private TChronicDisease gxy;// 高血压慢病总表实体
	private TChronicDisease tnb;// 糖尿病慢病总表实体
	private TLifestyleGuide lifestyleGuide;// 生活方式指导实体
	private TLifestyleGuide lifestyleGuideGxy;//高血压 生活方式指导实体
	private TLifestyleGuide lifestyleGuideTnb;//糖尿病 生活方式指导实体
	private TSign sign;// 体征表实体
	private TSign signGxy;//高血压 体征表实体
	private TSign signTnb;//糖尿病 体征表实体
	private int hid;// 健康档案id
	private int cid;// 慢病总表id
	private int gxyCid;//高血压慢性病id
	private int tnbCid;//糖尿病慢性病id
	private THypertensiveFollow thypertensiveFollow;// 高血压随访记录实体
	private List<TDrugInformation> listdrugGxy;// 用药情况实体集合
	private List<TDrugInformation> listdrugTnb;// 用药情况实体集合
	ChronicVerifyFollow chronicVerifyFollow = new ChronicVerifyFollow();
	ChronicVerifyFollow chronicVerifyFollowGxy = new ChronicVerifyFollow();
	ChronicVerifyFollow chronicVerifyFollowTnb = new ChronicVerifyFollow();
	private TDiabetsFollow diabetsFollow;// 糖尿病随访实体
	// ///////////////////////////////////////慢病随访可维护字段//////////////////////////////////////////////////////////////
		// 高血压随访记录
		private List<TMaintainableEntry> gxysffs;// 高血压随访记录随访方式
		private List<TMaintainableEntry> gxyfxl;// 高血压随访记录心里调整
		private List<TMaintainableEntry> gxyfsyqk;// 高血压随访记录摄盐情况
		private List<TMaintainableEntry> gxysflx;// 高血压随访记录随访类型
		private List<TMaintainableEntry> gxyfyycx;// 高血压服药依从性
		private List<TMaintainableEntry> zyxw;// 遵医行为
		private List<TMaintainableEntry> mqzyzz;// 高血压目前主要症状
		// 糖尿病随访记录
		private List<TMaintainableEntry> dxtfy;// 低血糖反应
		private List<TMaintainableEntry> tnbmqzyzz;// 糖尿病目前主要症状
		private List<TMaintainableEntry> tnbxltz;// 糖尿病随访记录心理调整
	///////////////////////////////////////////////////////////////////////////
	
		
	public ChronicFollowService getChFollowService() {
		return chFollowService;
	}
	

	public TDiabetsFollow getDiabetsFollow() {
		return diabetsFollow;
	}


	public void setDiabetsFollow(TDiabetsFollow diabetsFollow) {
		this.diabetsFollow = diabetsFollow;
	}


	public String getTokenGxy() {
		return tokenGxy;
	}


	public void setTokenGxy(String tokenGxy) {
		this.tokenGxy = tokenGxy;
	}


	public String getTokenTnb() {
		return tokenTnb;
	}


	public void setTokenTnb(String tokenTnb) {
		this.tokenTnb = tokenTnb;
	}


	public int getHealthFileIdGxy() {
		return healthFileIdGxy;
	}


	public void setHealthFileIdGxy(int healthFileIdGxy) {
		this.healthFileIdGxy = healthFileIdGxy;
	}


	public int getHealthFileIdTnb() {
		return healthFileIdTnb;
	}


	public void setHealthFileIdTnb(int healthFileIdTnb) {
		this.healthFileIdTnb = healthFileIdTnb;
	}


	public TFileLifeStyle getTlifestyleGxy() {
		return tlifestyleGxy;
	}


	public void setTlifestyleGxy(TFileLifeStyle tlifestyleGxy) {
		this.tlifestyleGxy = tlifestyleGxy;
	}


	public TFileLifeStyle getTlifestyleTnb() {
		return tlifestyleTnb;
	}


	public void setTlifestyleTnb(TFileLifeStyle tlifestyleTnb) {
		this.tlifestyleTnb = tlifestyleTnb;
	}


	public TChronicDisease getGxy() {
		return gxy;
	}


	public void setGxy(TChronicDisease gxy) {
		this.gxy = gxy;
	}


	public TChronicDisease getTnb() {
		return tnb;
	}


	public void setTnb(TChronicDisease tnb) {
		this.tnb = tnb;
	}


	public TLifestyleGuide getLifestyleGuideGxy() {
		return lifestyleGuideGxy;
	}


	public void setLifestyleGuideGxy(TLifestyleGuide lifestyleGuideGxy) {
		this.lifestyleGuideGxy = lifestyleGuideGxy;
	}


	public TLifestyleGuide getLifestyleGuideTnb() {
		return lifestyleGuideTnb;
	}


	public void setLifestyleGuideTnb(TLifestyleGuide lifestyleGuideTnb) {
		this.lifestyleGuideTnb = lifestyleGuideTnb;
	}


	public TSign getSignGxy() {
		return signGxy;
	}


	public void setSignGxy(TSign signGxy) {
		this.signGxy = signGxy;
	}


	public TSign getSignTnb() {
		return signTnb;
	}


	public void setSignTnb(TSign signTnb) {
		this.signTnb = signTnb;
	}


	public int getGxyCid() {
		return gxyCid;
	}


	public void setGxyCid(int gxyCid) {
		this.gxyCid = gxyCid;
	}


	public int getTnbCid() {
		return tnbCid;
	}


	public void setTnbCid(int tnbCid) {
		this.tnbCid = tnbCid;
	}


	public List<TDrugInformation> getListdrugTnb() {
		return listdrugTnb;
	}


	public void setListdrugTnb(List<TDrugInformation> listdrugTnb) {
		this.listdrugTnb = listdrugTnb;
	}


	public List<TMaintainableEntry> getGxysffs() {
		return gxysffs;
	}

	public void setGxysffs(List<TMaintainableEntry> gxysffs) {
		this.gxysffs = gxysffs;
	}

	public List<TMaintainableEntry> getGxyfxl() {
		return gxyfxl;
	}

	public void setGxyfxl(List<TMaintainableEntry> gxyfxl) {
		this.gxyfxl = gxyfxl;
	}

	public List<TMaintainableEntry> getGxyfsyqk() {
		return gxyfsyqk;
	}

	public void setGxyfsyqk(List<TMaintainableEntry> gxyfsyqk) {
		this.gxyfsyqk = gxyfsyqk;
	}

	public List<TMaintainableEntry> getGxysflx() {
		return gxysflx;
	}

	public void setGxysflx(List<TMaintainableEntry> gxysflx) {
		this.gxysflx = gxysflx;
	}

	public List<TMaintainableEntry> getGxyfyycx() {
		return gxyfyycx;
	}

	public void setGxyfyycx(List<TMaintainableEntry> gxyfyycx) {
		this.gxyfyycx = gxyfyycx;
	}

	public List<TMaintainableEntry> getZyxw() {
		return zyxw;
	}

	public void setZyxw(List<TMaintainableEntry> zyxw) {
		this.zyxw = zyxw;
	}

	public List<TMaintainableEntry> getMqzyzz() {
		return mqzyzz;
	}

	public void setMqzyzz(List<TMaintainableEntry> mqzyzz) {
		this.mqzyzz = mqzyzz;
	}

	public List<TMaintainableEntry> getDxtfy() {
		return dxtfy;
	}

	public void setDxtfy(List<TMaintainableEntry> dxtfy) {
		this.dxtfy = dxtfy;
	}

	public List<TMaintainableEntry> getTnbmqzyzz() {
		return tnbmqzyzz;
	}

	public void setTnbmqzyzz(List<TMaintainableEntry> tnbmqzyzz) {
		this.tnbmqzyzz = tnbmqzyzz;
	}

	public List<TMaintainableEntry> getTnbxltz() {
		return tnbxltz;
	}

	public void setTnbxltz(List<TMaintainableEntry> tnbxltz) {
		this.tnbxltz = tnbxltz;
	}

	public void setChFollowService(ChronicFollowService chFollowService) {
		this.chFollowService = chFollowService;
	}

	public TChronicFollow getChronicFollow() {
		return chronicFollow;
	}

	public void setChronicFollow(TChronicFollow chronicFollow) {
		this.chronicFollow = chronicFollow;
	}

	public TChronicDisease getChronicDisease() {
		return chronicDisease;
	}

	public void setChronicDisease(TChronicDisease chronicDisease) {
		this.chronicDisease = chronicDisease;
	}

	public TLifestyleGuide getLifestyleGuide() {
		return lifestyleGuide;
	}

	public void setLifestyleGuide(TLifestyleGuide lifestyleGuide) {
		this.lifestyleGuide = lifestyleGuide;
	}

	public TSign getSign() {
		return sign;
	}

	public void setSign(TSign sign) {
		this.sign = sign;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public THypertensiveFollow getThypertensiveFollow() {
		return thypertensiveFollow;
	}

	public void setThypertensiveFollow(THypertensiveFollow thypertensiveFollow) {
		this.thypertensiveFollow = thypertensiveFollow;
	}

	public List<TDrugInformation> getListdrugGxy() {
		return listdrugGxy;
	}

	public void setListdrugGxy(List<TDrugInformation> listdrugGxy) {
		this.listdrugGxy = listdrugGxy;
	}

	public SituationOfMedicationServiceSub getsOfMedicationService() {
		return sOfMedicationService;
	}

	public void setsOfMedicationService(
			SituationOfMedicationServiceSub sOfMedicationService) {
		this.sOfMedicationService = sOfMedicationService;
	}

	public List<String> getMedicalPayMethodNameList() {
		return medicalPayMethodNameList;
	}

	public void setMedicalPayMethodNameList(List<String> medicalPayMethodNameList) {
		this.medicalPayMethodNameList = medicalPayMethodNameList;
	}

	public List<String> getMedicalPayMethodCardNumList() {
		return medicalPayMethodCardNumList;
	}

	public void setMedicalPayMethodCardNumList(
			List<String> medicalPayMethodCardNumList) {
		this.medicalPayMethodCardNumList = medicalPayMethodCardNumList;
	}

	public VStaffHosSu getVstaffHosSu() {
		return vstaffHosSu;
	}

	public void setVstaffHosSu(VStaffHosSu vstaffHosSu) {
		this.vstaffHosSu = vstaffHosSu;
	}

	public String getChoiceResultAllergyName() {
		return choiceResultAllergyName;
	}

	public void setChoiceResultAllergyName(String choiceResultAllergyName) {
		this.choiceResultAllergyName = choiceResultAllergyName;
	}

	public String getChoiceResultExposeName() {
		return choiceResultExposeName;
	}

	public void setChoiceResultExposeName(String choiceResultExposeName) {
		this.choiceResultExposeName = choiceResultExposeName;
	}

	public String getChoiceResultDisability() {
		return choiceResultDisability;
	}

	public void setChoiceResultDisability(String choiceResultDisability) {
		this.choiceResultDisability = choiceResultDisability;
	}

	public String getChoiceResultFather() {
		return choiceResultFather;
	}

	public void setChoiceResultFather(String choiceResultFather) {
		this.choiceResultFather = choiceResultFather;
	}

	public String getChoiceResultMother() {
		return choiceResultMother;
	}

	public void setChoiceResultMother(String choiceResultMother) {
		this.choiceResultMother = choiceResultMother;
	}

	public String getChoiceResultBroSis() {
		return choiceResultBroSis;
	}

	public void setChoiceResultBroSis(String choiceResultBroSis) {
		this.choiceResultBroSis = choiceResultBroSis;
	}

	public String getChoiceResultChild() {
		return choiceResultChild;
	}

	public void setChoiceResultChild(String choiceResultChild) {
		this.choiceResultChild = choiceResultChild;
	}

	public List<TFileMedicalRecord> getFileMedicalRecordList() {
		return fileMedicalRecordList;
	}

	public void setFileMedicalRecordList(
			List<TFileMedicalRecord> fileMedicalRecordList) {
		this.fileMedicalRecordList = fileMedicalRecordList;
	}

	public List<TPastHistory> getPastHistoryList() {
		return pastHistoryList;
	}

	public void setPastHistoryList(List<TPastHistory> pastHistoryList) {
		this.pastHistoryList = pastHistoryList;
	}

	public List<TPastHistory> getPastHistoryShouShuList() {
		return pastHistoryShouShuList;
	}

	public void setPastHistoryShouShuList(List<TPastHistory> pastHistoryShouShuList) {
		this.pastHistoryShouShuList = pastHistoryShouShuList;
	}

	public List<TPastHistory> getPastHistoryWaiShangList() {
		return pastHistoryWaiShangList;
	}

	public void setPastHistoryWaiShangList(
			List<TPastHistory> pastHistoryWaiShangList) {
		this.pastHistoryWaiShangList = pastHistoryWaiShangList;
	}

	public List<TPastHistory> getPastHistoryShuXieList() {
		return pastHistoryShuXieList;
	}

	public void setPastHistoryShuXieList(List<TPastHistory> pastHistoryShuXieList) {
		this.pastHistoryShuXieList = pastHistoryShuXieList;
	}

	public TFileLifeStyle getTlifestyle() {
		return tlifestyle;
	}

	public void setTlifestyle(TFileLifeStyle tlifestyle) {
		this.tlifestyle = tlifestyle;
	}

	public List<TMedicalPayMethod> getMedicalPayMethodList() {
		return medicalPayMethodList;
	}

	public void setMedicalPayMethodList(List<TMedicalPayMethod> medicalPayMethodList) {
		this.medicalPayMethodList = medicalPayMethodList;
	}
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public List<TDrugInformationIncomplete> getListdrug() {
		return listdrug;
	}


	public void setListdrug(List<TDrugInformationIncomplete> listdrug) {
		this.listdrug = listdrug;
	}


	public boolean isIssetsearch() {
		return issetsearch;
	}


	public void setIssetsearch(boolean issetsearch) {
		this.issetsearch = issetsearch;
	}


	public Page<THealthFile> getPage2() {
		return page2;
	}


	public void setPage2(Page<THealthFile> page2) {
		this.page2 = page2;
	}


	public Page<VHealthStaff> getPagePlus() {
		return pagePlus;
	}


	public void setPagePlus(Page<VHealthStaff> pagePlus) {
		this.pagePlus = pagePlus;
	}


	public int getState() {
		return state;
	}


	public void setState(int state) {
		this.state = state;
	}


	public List<THealthFile> getHealthFileList() {
		return healthFileList;
	}


	public void setHealthFileList(List<THealthFile> healthFileList) {
		this.healthFileList = healthFileList;
	}


	public List<HealthFile> getHealthFileCloudList() {
		return healthFileCloudList;
	}


	public void setHealthFileCloudList(List<HealthFile> healthFileCloudList) {
		this.healthFileCloudList = healthFileCloudList;
	}


	public List<TStaff> getSpecialDoctor() {
		return specialDoctor;
	}


	public void setSpecialDoctor(List<TStaff> specialDoctor) {
		this.specialDoctor = specialDoctor;
	}


	public String fuction() throws Exception{
		if(conFlag==1){//导出本页
			List<incompleteExport2> conList=new ArrayList<incompleteExport2>();
			if(choice!=null){
				for(int i=0;i<choice.length;i++){
					vincompleteRecord=incompleteRecordService.getVIncompleteRecord(choice[i]);
					if(vincompleteRecord!=null){
						incompleteExport2 ct=new incompleteExport2(vincompleteRecord);
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
			List<incompleteExport2> conList=new ArrayList<incompleteExport2>();
			String [] titles=(new incompleteExport()).getTitles();
			HttpSession session = ServletActionContext.getRequest().getSession();
			if(session.getAttribute("comHospital")!=null){
				communityHospital = (TCommunityHospital) session.getAttribute("comHospital");
				if(communityHospital.getIsHead()==Admin_IsHead.guanliyuan.getValue()){
					this.pageHtml=page.getPage("incompleteRecordAction2!showIncompleteRecord.action");
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
			
		
			for(VIncompleteRecord2 vIncompleteRecord : vincompleteRecordList){
				if(vIncompleteRecord!=null){
					incompleteExport2 cExport=new incompleteExport2(vIncompleteRecord);//*
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
		page = new Page<VIncompleteRecord2>();
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
		page = new Page<VIncompleteRecord2>();
		page.setCurrentPage(cp);
		page.setPageSize(10);
		page2 = new Page<THealthFile>();
		page2.setCurrentPage(cp);
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
		if(group!=null){//集团负责人登陆
			issq = 1;//0是平台管理员登陆，1是集团登陆，2是其他登陆
			hospitals = communityHospitalGroupService.getComHosListByGroup(group);
			page.setTotalNum(incompleteRecordService.getIncompleteRecordCountForGroup(group.getGId()));
			this.pageHtml = page.getPage("incompleteRecordAction2!showIncompleteRecord.action");
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
				this.pageHtml=page.getPage("incompleteRecordAction2!showIncompleteRecord.action");
				vincompleteRecordList=incompleteRecordService.getAllIncompleteRecord(page);
				allDoctor=healthFileService.getAllDoctorByHosId();
				allEnterPeople=staffService.getAllOperator();
				flagPingTai=true;
				return "showIncompleteRecord";
			}
			else {//社区负责人
				page.setTotalNum(incompleteRecordService.getIncompleteRecordCount(communityHospital.getCommunityHospitalId()));
				this.pageHtml=page.getPage("incompleteRecordAction2!showIncompleteRecord.action");
				vincompleteRecordList=incompleteRecordService.getAllIncompleteRecord(page, communityHospital.getCommunityHospitalId());
				allDoctor=healthFileService.getAllDoctorByHosId(communityHospital.getCommunityHospitalId());
				specialDoctor =healthFileService.getSpeciallDoctor(communityHospital.getCommunityHospitalId());
				allEnterPeople=staffService.getAllOperator(communityHospital.getCommunityHospitalId());
				staffs = staffService.getStaffByCommunityHospitalId(communityHospital.getCommunityHospitalId());
//				healthFileCloudList=getHealthFileListInfo(page2);
				healthFileCloudList=getHealthFileListInfo(page2);
//				setIncompletRecordCloudId(vincompleteRecordList,healthFileCloudList);
				return "showIncompleteRecord";
			}
		}
		else if(session.getAttribute("tstaff")!=null){
			tstaff =  (TStaff) session.getAttribute("tstaff");
			hosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId());
			if(healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())){//判断员工是否为责任医生，若是，则只能看到所对应的老人
				page.setTotalNum(incompleteRecordService.getIncompleteRecordCountForSpecial(tstaff.getStaffId()));
				vincompleteRecordList=incompleteRecordService.getAllIncompleteRecordForSpecial(page, tstaff.getStaffId());
				healthFileList = healthFileService.getHealthFileListByStaffIdForSpeciall(page2, state,
						tstaff.getStaffId());
				allDoctor=healthFileService.getAllDoctorByHosId(hosId);
				allEnterPeople=staffService.getAllOperator(hosId);
				staffs = staffService.getStaffByCommunityHospitalId(hosId);
				flagDuo=true;
				
				healthFileCloudList=getHealthFileListInfo(page2);
//				setIncompletRecordCloudId(vincompleteRecordList,healthFileCloudList);
			}else{
				page.setTotalNum(incompleteRecordService.getIncompleteRecordCount(hosId));
				vincompleteRecordList=incompleteRecordService.getAllIncompleteRecord(page, hosId);
				allDoctor=healthFileService.getAllDoctorByHosId(hosId);
				allEnterPeople=staffService.getAllOperator(hosId);
				specialDoctor =healthFileService.getSpeciallDoctor(hosId);
				staffs = staffService.getStaffByCommunityHospitalId(hosId);
			}
			this.pageHtml=page.getPage("incompleteRecordAction2!showIncompleteRecord.action");
			return "showIncompleteRecord";
		}
		else{
			return "error";
		}

		
	}
	
	private void setIncompletRecordCloudId(
			List<VIncompleteRecord2> vincompleteRecordList2,
			List<HealthFile> healthFileCloudList2) {
		// TODO Auto-generated method stub
		//接诊记录为空，直接返回
		if (vincompleteRecordList2 == null) {
			return;
		}
//		int size = vincompleteRecordList2.size();
//		//健康库云健康档案为空，则给每个接诊记录cloudId设为-1
//		if(healthFileCloudList2 == null){
//			for(int i = 0; i<size;i++){
//				vincompleteRecordList2.get(i).setId(-1);
//			}
//			return;
//		}
//		int cloudSize = healthFileCloudList2.size();
//		for( int i=0;i<size;i++){
//			VIncompleteRecord2 incom = vincompleteRecordList2.get(i);
//			for(int j=0;j<cloudSize;j++){
//				HealthFile h = healthFileCloudList2.get(j);
//				if(incom.getHealthFileId() == h.getHealthFileId()){
//					incom.setId(h.getId());
//					break;
//				}
//			}
//		}
		return;
	}

	public String turnToHealthFileView() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		//当前用户是社区负责人或者责任医生时
				communityHospital = (TCommunityHospital) session.getAttribute("comHospital");
				tstaff = (TStaff) session.getAttribute("tstaff");
				if ((communityHospital!= null&&communityHospital.getIsHead() != Admin_IsHead.guanliyuan.getValue())||(tstaff!=null&&healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId()))) {
					//德江方法 健康档案详情
//					String jiankangjianyi=""; //朱德江健康建议页面使用！！！！！！
//					if(healthCloudId<0){
//						healthCloudId=Math.abs(healthCloudId);
//						jiankangjianyi="showHealthFileHealthAdvice";
//					}
//					
//					String resultJson=healthFileService.getHealthFileCloudForDetail(healthCloudId);
//					HealthFileCloudForDetail healthSingle=JSON.parseObject(resultJson,HealthFileCloudForDetail.class);
//					healthFileCloudSingle=healthSingle.getItem();
//					String re1[];
//					re1=healthFileCloudSingle.getBirthDate().split(" ");
//					healthFileCloudSingle.setBirthDate(re1[0]);
//					doctorName=staffService.getStaffById(healthFileCloudSingle.getDoctorID()).getName();  
//					vstaffHosSu = healthFileService.getVStaffHosSuByHeathFileId(healthFileCloudSingle.getHealthFileId(), state);//用来显示责任医生
//					choiceResultFather = healthFileCloudSingle.getFatherDisease();//家族史
//					choiceResultMother = healthFileCloudSingle.getMotherDisease();
//					choiceResultBroSis = healthFileCloudSingle.getBorSisDisease();
//					choiceResultChild = healthFileCloudSingle.getChildDisease();
//					choiceResultDisability = healthFileCloudSingle.getDisabilityName();//残疾状况
//					choiceResultExposeName = healthFileCloudSingle.getExposeName();//暴露史
//					choiceResultAllergyName = healthFileCloudSingle.getAllergyName();//药物过敏史
//					//医疗付费方式子表
//					payMethodList=healthFileCloudSingle.getMpmList();
//					//生活方式子表
//					lifestyleList=healthFileCloudSingle.getFlsList();
//					if(lifestyleList!=null&&lifestyleList.size()!=0){
//						lifestyle=lifestyleList.get(0);
//					}
//					//用药记录子表
//					//这里面的时间也不是字符串，而是一个类，以后也得改
//					MedicalRecordList=healthFileCloudSingle.getFmrList();
//					if(belongSystemQianDuan==2&&MedicalRecordList!=null){//老人来自养老机构
//						for(int i=0;i<MedicalRecordList.size();i++){
//							String[] re = MedicalRecordList.get(i).getDosage().split(" ");
//							yongLiangCiShu=re[1];
//							meiCiYongLiang=re[2];
//							MedicalRecordList.get(i).setDosage("每日"+yongLiangCiShu+"次，每次"+meiCiYongLiang+"毫克");
//						}
//					}
//					//既往史子表
//					pastAllList=healthFileCloudSingle.getFphList();
//					pastList=new ArrayList<PastHistory>();//初始化list
//					pastWaiShangList=new ArrayList<PastHistory>();//初始化list
//					pastShouShuList=new ArrayList<PastHistory>();//初始化list
//					pastShuXieList=new ArrayList<PastHistory>();//初始化list
					//因为fphl中date不是string类型所以无法完成赋值
//					if(pastAllList!=null&&pastAllList.size()!=0){
//						for(int i=0;i<pastAllList.size();i++){
//							if(pastAllList.get(i).getPastType().equals("疾病")){
//								try {
//									pastList.add(pastAllList.get(i));
//								} catch (Exception e) {
//									// TODO Auto-generated catch block
//									e.printStackTrace();
//								}
//							}
//							else if(pastAllList.get(i).getPastType().equals("手术")){
//								pastShouShuList.add(pastAllList.get(i));
//							}
//							else if(pastAllList.get(i).getPastType().equals("外伤")){
//								pastWaiShangList.add(pastAllList.get(i));
//							}
//							else if(pastAllList.get(i).getPastType().equals("输血")){
//								pastShuXieList.add(pastAllList.get(i));
//							}
//						}
//					}
					
					//德江方法健康建议查看健康档案
//					if(jiankangjianyi.equals("")){
//						return "turnToHealthFileViewInfo";
//					}else{
//						return jiankangjianyi;
//					}
				}
		//当前用户不是社区负责人或者责任医生，是其他角色时
		if (session.getAttribute("comHospital") != null) {
			communityHospital = (TCommunityHospital) session.getAttribute("comHospital");
			if (communityHospital.getIsHead() != Admin_IsHead.guanliyuan.getValue()) {
				hosId = communityHospital.getCommunityHospitalId();
				if (healthFileService.getOldStaffHosByHosIdAndHeathFileId(hosId, healthFileId) == null) {
					return "error";
				}
			}

		} else if (session.getAttribute("tstaff") != null) {
			tstaff = (TStaff) session.getAttribute("tstaff");
			if (healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())) {// 判断员工是否为责任医生，若是，则只能看到所对应的老人
				if (healthFileService.getOldStaffHosByStaffIdAndHeathFileId(tstaff.getStaffId(),
						healthFileId) == null) {
					return "error";
				}
			}
			hosId = staffService.getCommHospitalByStaffId(tstaff.getStaffId());
			if (healthFileService.getOldStaffHosByHosIdAndHeathFileId(hosId, healthFileId) == null) {

				return "error";
			}
		}
		
		medicalPayMethodList = medicalPayMethodService.getMedicalPayMethodByHFileId(healthFileId);
		medicalPayMethodNameList = new ArrayList<String>();
		medicalPayMethodCardNumList = new ArrayList<String>();
		if (medicalPayMethodList != null) {
			for (int i = 0; i < medicalPayMethodList.size(); i++) {
				medicalPayMethodNameList.add(medicalPayMethodList.get(i).getName());
				if (medicalPayMethodList.get(i).getCardNum() != null) {
					medicalPayMethodCardNumList.add(medicalPayMethodList.get(i).getCardNum());
				}
			}
			if (medicalPayMethodNameList.size() > 0) {
				str = TypeConverter.list3FormatString(medicalPayMethodNameList, ",");
			} else {
				str = "ee";
			}
		}

		//allHos = communityHospitalService.getAllHospitals();123
		healthFile = healthFileService.getHealthFileById(healthFileId);
		//boolean a=healthFileService.editHealthFileToCloulds(healthFile);
		// vstaffHos=healthFileService.getVStaffHosByHeathFileId(healthFileId);//参数是healthFileId，默认为1
		vstaffHosSu = healthFileService.getVStaffHosSuByHeathFileId(healthFileId, state);//用来显示责任医生
		choiceResultFather = healthFile.getFatherDisease();//家族史
		choiceResultMother = healthFile.getMotherDisease();
		choiceResultBroSis = healthFile.getBorSisDisease();
		choiceResultChild = healthFile.getChildDisease();
		choiceResultDisability = healthFile.getDisabilityName();//残疾状况
		choiceResultExposeName = healthFile.getExposeName();//暴露史
		choiceResultAllergyName = healthFile.getAllergyName();//药物过敏史
		fileMedicalRecordList=fileMedicalRecordService.getFileMedicalRecordList(healthFileId);
		pastHistoryList = pastHistoryService.getPastHistory(healthFileId, "疾病");
		pastHistoryShouShuList = pastHistoryService.getPastHistory(healthFileId, "手术");// 得到既往史
		pastHistoryWaiShangList = pastHistoryService.getPastHistory(healthFileId, "外伤");
		pastHistoryShuXieList = pastHistoryService.getPastHistory(healthFileId, "输血");
		tlifestyle=fileLifeStyleService.getFileLifeStyleByhealthID(healthFileId);
		return "turnToHealthFileView";
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
			tokenGxy = TokenProccessor.getInstance().makeToken();//创建gxy令牌
			tokenTnb = TokenProccessor.getInstance().makeToken();//创建tnb令牌
			HttpServletRequest request=ServletActionContext.getRequest();
			request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
			request.getSession().setAttribute("tokenGxy", tokenGxy);  //在服务器使用session保存token(令牌)
			request.getSession().setAttribute("tokenTnb", tokenTnb);  //在服务器使用session保存token(令牌)
			//根据健康档案id和慢性病名字，找到对应的慢性病高血压id和糖尿病id
			gxy = (TChronicDisease)allChronicDiseaseService.getChronicDiseaseByNumName(healthFile.getHealthFileId(),"高血压");
			tnb = (TChronicDisease)allChronicDiseaseService.getChronicDiseaseByNumName(healthFile.getHealthFileId(),"糖尿病");
			if(gxy!=null){
				gxyCid = gxy.getChronicDiseaseId();
				chronicVerifyFollowGxy.setCid(gxyCid);
				chronicVerifyFollowGxy.setHid(healthFile.getHealthFileId());
				if (chronicVerifyFollowGxy.verifyFollow() == false) {
					return "error";
				}
				gxyf();
			}
			if(tnb!=null){
				tnbCid = tnb.getChronicDiseaseId();
				chronicVerifyFollowTnb.setCid(tnbCid);
				chronicVerifyFollowTnb.setHid(healthFile.getHealthFileId());
				if (chronicVerifyFollowTnb.verifyFollow() == false) {
					return "error";
				}
				tnbsf();
			}
			return "findIncompleteRecord";
		}
		else {
			str="未找到该老人信息";
			conFlag=0;
			return "findAndAddIncompleteRecord";
		}
		
	}
	/**
	 * 添加高血压随访记录
	 * 从接诊记录中嵌入式页面跳转过来
	 * @return
	 */
	public void addHighFollowFromEmbeded() {
		String results = "-1";
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,tokenGxy,"tokenGxy");//判断用户是否是重复提交
		if(b==true){
//			return "addHighFollowFromEmbeded";  //重定向回接诊记录列表页
			this.writeJson(results);
			return;
		}
		request.getSession().removeAttribute("tokenGxy");//移除session中的token
		
		if (chronicFollow.getFollowDate() == null
				|| chronicFollow.getFollowPeople() == null) {
//			return "error";
			this.writeJson(results);
			return;
		}
		healthFile = healthFileService.getHealthFileById(healthFileIdGxy);// 用于校验死亡
																// 或注销的人不能添加
		if (healthFile.getHealthFileType().equals(
				String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| healthFile.getHealthFileType().equals(
						String.valueOf(HealthFileCheck.siwang.getValue()))) {
//			return "error";// 用于校验死亡 或注销的人不能添加
			this.writeJson(results);
			return;
		}
		gxy = allChronicDiseaseService.getChronicDiseaseByID(gxyCid);
		chronicFollow.setTChronicDisease(gxy);
		int m = chFollowService.saveTChronicFollow(chronicFollow);
		chronicFollow = chFollowService.getChronicFollowByMbsfId(m);
		lifestyleGuideGxy = lifeAndSignService.getLifeGuideById(lifeAndSignService
				.saveLifeGuide(lifestyleGuideGxy));
		signGxy = lifeAndSignService
				.getSignById(lifeAndSignService.saveSign(signGxy));
		thypertensiveFollow.setTChronicFollow(chronicFollow);
		thypertensiveFollow.setTLifestyleGuide(lifestyleGuideGxy);
		thypertensiveFollow.setTSign(signGxy);
		highBloodPressureService.saveHyp_Follow(thypertensiveFollow);
		thypertensiveFollow = highBloodPressureService
				.getHyp_FollowByHfid(highBloodPressureService
						.saveHyp_Follow(thypertensiveFollow));
		for (int i = 0; i < listdrugGxy.size(); i++) {
			TDrugInformation t = listdrugGxy.get(i);
			if(t!=null){
				t.setTHypertensiveFollow(thypertensiveFollow);
			}
		}
		sOfMedicationMxbService.saveListDrugInformation(listdrugGxy);
//		return "addHighFollowFromEmbeded";
		results = "1";
		this.writeJson(results);
		return;
	}
	/**
	 * 添加糖尿病随访记录
	 * 从接诊记录页面跳转进来
	 * @return
	 */
	public void addDiabetsFromEmbeded() {
		String results = "-1";
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,tokenTnb,"tokenTnb");//判断用户是否是重复提交
		if(b==true){
			this.writeJson(results);
			return;
		}
		request.getSession().removeAttribute("tokenTnb");//移除session中的token
		
		if (chronicFollow.getFollowDate() == null
				|| chronicFollow.getFollowPeople() == null) {
			this.writeJson(results);
			return;
		}
		healthFile = healthFileService.getHealthFileById(healthFileIdTnb);// 用于校验死亡
																// 或注销的人不能添加
		if (healthFile.getHealthFileType().equals(
				String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| healthFile.getHealthFileType().equals(
						String.valueOf(HealthFileCheck.siwang.getValue()))) {
			this.writeJson(results);
			return;
		}
		tnb = allChronicDiseaseService.getChronicDiseaseByID(tnbCid);
		chronicFollow.setTChronicDisease(tnb);
		int m = chFollowService.saveTChronicFollow(chronicFollow);
		chronicFollow = chFollowService.getChronicFollowByMbsfId(m);
		lifestyleGuideTnb = lifeAndSignService.getLifeGuideById(lifeAndSignService
				.saveLifeGuide(lifestyleGuideTnb));
		signTnb = lifeAndSignService
				.getSignById(lifeAndSignService.saveSign(signTnb));
		diabetsFollow.setTChronicFollow(chronicFollow);
		diabetsFollow.setTLifestyleGuide(lifestyleGuideTnb);
		diabetsFollow.setTSign(signTnb);
		diabetesService.saveDiabetsFollow(diabetsFollow);
		diabetsFollow = diabetesService.getDiabetsFollowByTfId(diabetesService
				.saveDiabetsFollow(diabetsFollow));
		for (int i = 0; i < listdrugTnb.size(); i++) {
			TDrugInformation t = listdrugTnb.get(i);
			if(t!=null){
				t.setTDiabetsFollow(diabetsFollow);
			}
		}
		sOfMedicationMxbService.saveListDrugInformation(listdrugTnb);
		results = "1";
		this.writeJson(results);
		return;
	}
	/**
	 * 查询默认的页面的老人档案列表，【进入健康采集首页】
	 * 
	 * @return
	 */
	public List<HealthFile> getHealthFileListInfo(Page page) {
		
		int userId = 1;
		//责任医生
		TStaff tStaff = (TStaff) ActionContext.getContext().getSession().get("tstaff");
		//社区负责人
		TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext.getContext().getSession().get("comHospital");
		if(tStaff != null){
			userId = tStaff.getStaffId();
			//userId = 1; //测试专用，运行阶段删除
			//HealthFileCloud healthFileCloud = (HealthFileCloud) ActionContext.getContext().getSession().get("healthFileCloudDoc");
			//if(healthFileCloud == null){
			HealthFileCloud healthFileCloud = getHealthFilePageInfoByDoctor(userId);
			//	if(healthFileCloud.getPage() != null){
			//		ActionContext.getContext().getSession().put("healthFileCloudDoc", healthFileCloud);
			//	}
			//}
			if(healthFileCloud.getPage() != null){
				page2.setPageSize(healthFileCloud.getPage().getPageSize());
				page2.setTotal(healthFileCloud.getPage().getTotal());
				page2.setTotalNum(healthFileCloud.getPage().getTotal());
				String resultJson = healthManagerService.getHealthFileFromCloudByDoctor(userId, page.getCurrentPage(), page.getPageSize());
				healthFileCloud = JSON.parseObject(resultJson,HealthFileCloud.class);
				healthFileCloudList = healthFileCloud.getPage().getResult();
			}
		}else if(tCommunityHospital != null){
			//userId = tCommunityHospital.getCommunityHospitalId();--运行时撤销注释
			hosId=tCommunityHospital.getCommunityHospitalId();
			//HealthFileCloud healthFileCloud = (HealthFileCloud) ActionContext.getContext().getSession().get("healthFileCloudHos");
			//if(healthFileCloud == null){
				HealthFileCloud healthFileCloud = getHealthFilePageInfoByHos(hosId);
			//	if(healthFileCloud.getPage() != null){
			//		ActionContext.getContext().getSession().put("healthFileCloudHos", healthFileCloud);
			//	}
			//}
			if(healthFileCloud.getPage() != null){
				page2.setPageSize(healthFileCloud.getPage().getPageSize());
				page2.setTotal(healthFileCloud.getPage().getTotal());
				page2.setTotalNum(healthFileCloud.getPage().getTotal());
				String resultJson = healthManagerService.getHealthFileFromCloudByHos(hosId, page.getCurrentPage(), page.getPageSize());
				healthFileCloud = JSON.parseObject(resultJson,HealthFileCloud.class);
				healthFileCloudList = healthFileCloud.getPage().getResult();
			}
		}
		return healthFileCloudList;
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
		for (int i = 0; i < listdrug.size(); i++) {
			TDrugInformationIncomplete t = listdrug.get(i);
			t.setTIncompleteRecord2(incompleteRecord);
		}
		sOfMedicationService.saveListDrugInformationIncomplete(listdrug);
		
		
		incompleteRecordService.saveIncompleteRecord(incompleteRecord);
		return "addIncompleteRecord";
	}
	/**
	 * 防止重复提交的方法的前提
	 */
	public void Repetition(){
		token = TokenProccessor.getInstance().makeToken();//创建令牌
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
	}
	/**
	 * 高血压可维护字段
	 */
	public void gxyf() {
		gxysffs = maintainableAttributeService.getmEntriesByCode("09001");
		gxyfxl = maintainableAttributeService.getmEntriesByCode("09002");
		gxyfsyqk = maintainableAttributeService.getmEntriesByCode("09003");
		gxysflx = maintainableAttributeService.getmEntriesByCode("09004");
		gxyfyycx = maintainableAttributeService.getmEntriesByCode("09005");
		zyxw = maintainableAttributeService.getmEntriesByCode("02009");
		mqzyzz = maintainableAttributeService.getmEntriesByCode("02015");
	}

	/**
	 * 糖尿病随访可维护字段
	 * 
	 */
	public void tnbsf() {
		gxysffs = maintainableAttributeService.getmEntriesByCode("09001");
		dxtfy = maintainableAttributeService.getmEntriesByCode("10001");
		gxysflx = maintainableAttributeService.getmEntriesByCode("09004");
		tnbxltz = maintainableAttributeService.getmEntriesByCode("09002");
		zyxw = maintainableAttributeService.getmEntriesByCode("02009");
		gxyfyycx = maintainableAttributeService.getmEntriesByCode("09005");
		tnbmqzyzz = maintainableAttributeService.getmEntriesByCode("03006");
	}
	
	public String turnToAddPersonIncompleteRecord(){
//		token = TokenProccessor.getInstance().makeToken();//创建令牌
//		HttpServletRequest request=ServletActionContext.getRequest();
//		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
//		Repetition();
		token = TokenProccessor.getInstance().makeToken();//创建令牌
		tokenGxy = TokenProccessor.getInstance().makeToken();//创建gxy令牌
		tokenTnb = TokenProccessor.getInstance().makeToken();//创建tnb令牌
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
		request.getSession().setAttribute("tokenGxy", tokenGxy);  //在服务器使用session保存token(令牌)
		request.getSession().setAttribute("tokenTnb", tokenTnb);  //在服务器使用session保存token(令牌)
		//根据健康档案id和慢性病名字，找到对应的慢性病高血压id和糖尿病id
		gxy = (TChronicDisease)allChronicDiseaseService.getChronicDiseaseByNumName(hid,"高血压");
		tnb = (TChronicDisease)allChronicDiseaseService.getChronicDiseaseByNumName(hid,"糖尿病");
		if(gxy!=null){
			gxyCid = gxy.getChronicDiseaseId();
			chronicVerifyFollowGxy.setCid(gxyCid);
			chronicVerifyFollowGxy.setHid(hid);
			if (chronicVerifyFollowGxy.verifyFollow() == false) {
				return "error";
			}
			gxyf();
		}
		if(tnb!=null){
			tnbCid = tnb.getChronicDiseaseId();
			chronicVerifyFollowTnb.setCid(tnbCid);
			chronicVerifyFollowTnb.setHid(hid);
			if (chronicVerifyFollowTnb.verifyFollow() == false) {
				return "error";
			}
			tnbsf();
		}
		
		
//		chronicVerifyFollow.setCid(cid);
//		chronicVerifyFollow.setHid(hid);
//		if (chronicVerifyFollow.verifyFollow() == false) {
//			return "error";
//		}
		
//		healthFile = healthFileService.getHealthFileById(hid);
//		chronicDisease = allChronicDiseaseService.getChronicDiseaseByID(cid);
//		String name = chronicDisease.getDiseaseName();
//		if (name.equals("高血压")) {
//			gxyf();
////			return "gxyEmbeded";
//		} else if (name.equals("糖尿病")) {
//			tnbsf();
////			return "tnbEmbeded";
//		} 
		
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
//	public String turnToDetailIncompleteRecord(){
//		if(healthFileService.getHealthFileById(healthFileId)==null||incompleteRecordService.getIncompleteRecordByIRId(irId)==null){
//			return "error";
//		}
//		healthFile=healthFileService.getHealthFileById(healthFileId);
//		incompleteRecord=incompleteRecordService.getIncompleteRecordByIRId(irId);
//		//////////////////////////////////////////////////
//		if(incompleteRecord.getTHealthFile().getHealthFileId()!=healthFileId){
//			return "error";
//		}
//		//////////////////////////////////////////////
//		return "turnToDetailIncompleteRecord";
//	}
	
	/**接诊记录详情的新的处理逻辑 和上边没变
	 * @return
	 */
	public String turnToDetailIncompleteRecord(){
		if(healthFileService.getHealthFileById(healthFileId)==null||incompleteRecordService.getIncompleteRecordByIRId(irId)==null){
			return "error";
		}
		healthFile=healthFileService.getHealthFileById(healthFileId);
		incompleteRecord=incompleteRecordService.getIncompleteRecordByIRId(irId);
		listdrug=sOfMedicationService.getDrugInformationByJzId(irId);
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
//		incompleteRecord=incompleteRecordService.getIncompleteRecordByIRId(irId);
//		if(incompleteRecord==null){
//			return "error";
//		}
		healthFile=healthFileService.getHealthFileById(healthFileId);
		incompleteRecord.setTHealthFile(healthFile);
		List<TDrugInformationIncomplete> list = sOfMedicationService
				.getDrugInformationByJzId(irId);
		sOfMedicationService.deleteListDrugInformationIncomplete(list);
		for (int i = 0; i < listdrug.size(); i++) {
			TDrugInformationIncomplete t = listdrug.get(i);
			t.setTIncompleteRecord2(incompleteRecord);
		}
		sOfMedicationService.saveListDrugInformationIncomplete(listdrug);
		
		
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
		listdrug=sOfMedicationService.getDrugInformationByJzId(irId);
		if(incompleteRecord.getTHealthFile().getHealthFileId()!=healthFileId){
			return "error";
		}
		return "turnToUpdateIncompleteRecord";
	}
	
	public String deleteMoreIncompleteRecord(){
		incompleteRecordService.deleteIncompleteRecord(allIncompleteRecordId);
		return "deleteMoreIncompleteRecord";
	}
	
	
	//判断是否存在高血压慢病档案
	public String checkHighBloodMXB(){
		
		return "hasHighBloodMXB";
	}
	public Page<VIncompleteRecord2> getPage() {
		return page;
	}
	public void setPage(Page<VIncompleteRecord2> page) {
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
	public List<VIncompleteRecord2> getVincompleteRecordList() {
		return vincompleteRecordList;
	}
	public void setVincompleteRecordList(
			List<VIncompleteRecord2> vincompleteRecordList) {
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
	public TIncompleteRecord2 getIncompleteRecord() {
		return incompleteRecord;
	}
	public void setIncompleteRecord(TIncompleteRecord2 incompleteRecord) {
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


	public VIncompleteRecord2 getVincompleteRecord() {
		return vincompleteRecord;
	}


	public void setVincompleteRecord(VIncompleteRecord2 vincompleteRecord) {
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


	public HealthFile getrHealthFile() {
		return rHealthFile;
	}


	public void setrHealthFile(HealthFile rHealthFile) {
		this.rHealthFile = rHealthFile;
	}


	public int getHealthCloudId() {
		return healthCloudId;
	}


	public void setHealthCloudId(int healthCloudId) {
		this.healthCloudId = healthCloudId;
	}


	public int getBelongSystemQianDuan() {
		return belongSystemQianDuan;
	}


	public void setBelongSystemQianDuan(int belongSystemQianDuan) {
		this.belongSystemQianDuan = belongSystemQianDuan;
	}

	
	
}
