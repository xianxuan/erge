package com.jmjk.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.net.aso.n;

import org.apache.poi.hssf.record.chart.AxisUsedRecord;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jmjk.action.base.BaseAction;
import com.jmjk.entity.TAuxiliaryExamination;
import com.jmjk.entity.TChronicBronchialDisease;
import com.jmjk.entity.TChronicDisease;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.TCoronaryDisease;
import com.jmjk.entity.TDiabete;
import com.jmjk.entity.TDisabilityObstacle;
import com.jmjk.entity.TGeneralCondition;
import com.jmjk.entity.THcvd;
import com.jmjk.entity.THealthFile;
import com.jmjk.entity.THighBloodPressure;
import com.jmjk.entity.TInsanityForm;
import com.jmjk.entity.TLifeStyle;
import com.jmjk.entity.TMaintainableEntry;
import com.jmjk.entity.TOldStaffHos;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.TTumour;
import com.jmjk.entity.view.VChronic;
import com.jmjk.entity.view.VExam;
import com.jmjk.entity.view.VHealthStaff;
import com.jmjk.enums.CHRONIC_MANAGER;
import com.jmjk.enums.HealthFileCheck;
import com.jmjk.export.ChronicExport;
import com.jmjk.service.AllChronicDiseaseService;
import com.jmjk.service.ChronicBronchialService;
import com.jmjk.service.CommunityHospitalGroupService;
import com.jmjk.service.CommunityHospitalService;
import com.jmjk.service.CoronaryHeartService;
import com.jmjk.service.DiabetesService;
import com.jmjk.service.DisabilityService;
import com.jmjk.service.HealthFileService;
import com.jmjk.service.HeartAndCerebralService;
import com.jmjk.service.HighBloodPressureService;
import com.jmjk.service.MaintainableAttributeService;
import com.jmjk.service.PhysicalExamService;
import com.jmjk.service.PsychosisService;
import com.jmjk.service.StaffService;
import com.jmjk.service.StatusAndLifeAndAssistService;
import com.jmjk.service.TumourService;
import com.jmjk.utils.ChronicVerify;
import com.jmjk.utils.GetSessionPerson;
import com.jmjk.utils.JxlExcel;
import com.jmjk.utils.Page;
import com.jmjk.utils.Reflex;
import com.jmjk.utils.Resubmit;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.TokenProccessor;

@Scope("prototype")
@Component
@Action(value = "showOldChronicAction", results = {
		/**
		 * 慢病档案首页action
		 * 
		 * @author 李卓远
		 *
		 */

		@Result(name = "firstShowChronic", location = "/jsp/oldfile/oldchronicfile/homePage.jsp"),
		
		@Result(name = "searchChronicPeople", location = "/jsp/oldfile/oldchronicfile/homePage.jsp"),
		@Result(name = "showSlowChronic", location = "/jsp/oldfile/oldchronicfile/showPhy.jsp"),
		@Result(name = "oneOneHighBlood", location = "/jsp/oldfile/oldchronicfile/addOneHighBloodPage.jsp"),
		// @Result(name="jumpadd",location="/jsp/oldfile/oldchronicfile/addOneHighBloodPage.jsp"),
		@Result(name = "jumpadd", location = "/jsp/oldfile/oldchronicfile/jumpChronic.jsp"),// 1
		@Result(name = "onePeopleJump", location = "/jsp/oldfile/oldchronicfile/jumpChronic.jsp"),// 2
		@Result(name = "jumpDiabete", location = "/jsp/oldfile/oldchronicfile/addDiabete.jsp"),
		@Result(name = "jumpInsanityform", location = "/jsp/oldfile/oldchronicfile/addInsanityForm.jsp"),
		@Result(name = "jumpCoronary", location = "/jsp/oldfile/oldchronicfile/addCoronary.jsp"),
		@Result(name = "jumpBronchial", location = "/jsp/oldfile/oldchronicfile/addBronchial.jsp"),
		@Result(name = "jumpTumour", location = "/jsp/oldfile/oldchronicfile/addTumour.jsp"),
		@Result(name = "jumpHcvd", location = "/jsp/oldfile/oldchronicfile/addHcvd.jsp"),
		@Result(name = "jumpDisability", location = "/jsp/oldfile/oldchronicfile/addDisability.jsp"),
		// @Result(name="searchOlder",location="/jsp/oldfile/oldchronicfile/addOneHighBloodPage.jsp"),
		@Result(name = "searchOlder", location = "/jsp/oldfile/oldchronicfile/jumpChronic.jsp"),// 3
		@Result(name = "showHighBlood", location = "/jsp/oldfile/oldchronicfile/showHighBlood.jsp"),
		@Result(name = "ctnb", location = "/jsp/oldfile/oldchronicfile/showDiabete.jsp"),
		@Result(name = "cgxb", location = "/jsp/oldfile/oldchronicfile/showCoronary.jsp"),
		@Result(name = "cjsb", location = "/jsp/oldfile/oldchronicfile/showInsanityForm.jsp"),
		@Result(name = "czqg", location = "/jsp/oldfile/oldchronicfile/showBronchial.jsp"),
		@Result(name = "czl", location = "/jsp/oldfile/oldchronicfile/showTumour.jsp"),
		@Result(name = "czcj", location = "/jsp/oldfile/oldchronicfile/showDisability.jsp"),
		@Result(name = "cxn", location = "/jsp/oldfile/oldchronicfile/showHvcd.jsp"),
		@Result(name = "bzqg", location = "/jsp/oldfile/oldchronicfile/editBronchial.jsp"),
		@Result(name = "bgxy", location = "/jsp/oldfile/oldchronicfile/editOneHighBloodPage.jsp"),
		@Result(name = "bgxb", location = "/jsp/oldfile/oldchronicfile/editCoronary.jsp"),
		@Result(name = "btnb", location = "/jsp/oldfile/oldchronicfile/editDiabete.jsp"),
		@Result(name = "editDiabete", type = "redirectAction", location = "showOldChronicAction!firstShowChronic.action"),
		@Result(name = "editCoronnary", type = "redirectAction", location = "showOldChronicAction!firstShowChronic.action"),
		@Result(name = "editHighBlood", type = "redirectAction", location = "showOldChronicAction!firstShowChronic.action"),
		@Result(name = "bjsb", location = "/jsp/oldfile/oldchronicfile/editInsanityForm.jsp"),
		@Result(name = "bzl", location = "/jsp/oldfile/oldchronicfile/editTumour.jsp"),
		@Result(name = "bzcj", location = "/jsp/oldfile/oldchronicfile/editDisability.jsp"),
		@Result(name = "bxn", location = "/jsp/oldfile/oldchronicfile/editHcvd.jsp"),
		@Result(name = "error", location = "/error.jsp"),
		//@Result(name = "jump", type = "redirectAction",params = { "nulloldmessage","${nulloldmessage}" }, location = "showOldChronicAction!jumpadd.action"),
		@Result(name="jump",location="/jsp/oldfile/oldchronicfile/jumpChronic.jsp"),//上面为以前路径
		@Result(name = "addOneHighBlood", type = "redirectAction", location = "showOldChronicAction!firstShowChronic.action"),
		@Result(name = "addInsanity", type = "redirectAction", location = "showOldChronicAction!firstShowChronic.action"),
		@Result(name = "addCoronary", type = "redirectAction", location = "showOldChronicAction!firstShowChronic.action"),
		@Result(name = "addBronchial", type = "redirectAction", location = "showOldChronicAction!firstShowChronic.action"),
		@Result(name = "addTumour", type = "redirectAction", location = "showOldChronicAction!firstShowChronic.action"),
		@Result(name = "addHcvd", type = "redirectAction", location = "showOldChronicAction!firstShowChronic.action"),
		@Result(name = "addDisability", type = "redirectAction", location = "showOldChronicAction!firstShowChronic.action"),
		@Result(name = "editBronchial", type = "redirectAction", location = "showOldChronicAction!firstShowChronic.action"),
		@Result(name = "editMental", type = "redirectAction", location = "showOldChronicAction!firstShowChronic.action"),
		@Result(name = "editTumour", type = "redirectAction", location = "showOldChronicAction!firstShowChronic.action"),
		@Result(name = "editDisability", type = "redirectAction", location = "showOldChronicAction!firstShowChronic.action"),
		@Result(name = "editHcvd", type = "redirectAction", location = "showOldChronicAction!firstShowChronic.action"),
		@Result(name = "fdeleteChronic", type = "redirectAction", location = "showOldChronicAction!firstShowChronic.action"),
		@Result(name = "deleteChronic", type = "redirectAction", location = "showOldChronicAction!firstShowChronic.action"),
		@Result(name = "addDiabete", type = "redirectAction", location = "showOldChronicAction!firstShowChronic.action"),
		@Result(name = "tnbno", type = "redirectAction", params = { "helid",
				"${helid}" }, location = "showOldChronicAction!jumpDiabete.action"),
		@Result(name = "gxyno", type = "redirectAction", params = { "helid",
				"${helid}" }, location = "showOldChronicAction!jumpOneHighBlood.action"),
		@Result(name = "jsbno", type = "redirectAction", params = { "helid",
				"${helid}" }, location = "showOldChronicAction!jumpInsanityform.action"),
		@Result(name = "gxbno", type = "redirectAction", params = { "helid",
				"${helid}" }, location = "showOldChronicAction!jumpCoronary.action"),
		@Result(name = "zqgno", type = "redirectAction", params = { "helid",
				"${helid}" }, location = "showOldChronicAction!jumpBronchial.action"),
		@Result(name = "zlno", type = "redirectAction", params = { "helid",
				"${helid}" }, location = "showOldChronicAction!jumpTumour.action"),
		@Result(name = "xnno", type = "redirectAction", params = { "helid",
				"${helid}" }, location = "showOldChronicAction!jumpHcvd.action"),
		@Result(name = "cjno", type = "redirectAction", params = { "helid",
				"${helid}" }, location = "showOldChronicAction!jumpDisability.action"),
		@Result(name = "zhenshan", type = "redirectAction", params = { "chid",
				"${chid}" }, location = "showOldChronicAction!deleteChronic.action"),
		@Result(name = "jiashan", type = "redirectAction", params = { "chid",
				"${chid}" }, location = "showOldChronicAction!fdeleteChronic.action"),
		@Result(name = "bjsbno", type = "redirectAction", params = { "chid",
				"${chid}", "helid", "${helid}" }, location = "showOldChronicAction!jumpEditChronic.action"),
		@Result(name = "allDiabeteManager", location = "/jsp/ChronicManager/DiabeteManager/diabeteManager.jsp"),
		@Result(name = "allHighBloodManager", location = "/jsp/ChronicManager/HighBloodManager/highBloodManager.jsp"),
		@Result(name = "otherManager", location = "/jsp/ChronicManager/OtherChronicManager/otherChronicManager.jsp"),

		@Result(name = "addOneHighBloodFromEmbeded", type="redirectAction", location = "incompleteRecordAction2!turnToAddPersonIncompleteRecord.action",
		        params = {"healthFileId","${helid}","hid","${helid}"}),
	    @Result(name = "addDiabeteFromEmbeded", type="redirectAction", location = "incompleteRecordAction2!turnToAddPersonIncompleteRecord.action",
		        params = {"healthFileId","${helid}","hid","${helid}"}),
})
public class ShowOldChronicAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	@Autowired
	private AllChronicDiseaseService allChronicDiseaseService;// 慢病总表
	@Autowired
	private HighBloodPressureService highBloodPressureService;// 高血压表
	@Autowired
	private HealthFileService healthFileService;// 健康档案
	@Autowired
	private StatusAndLifeAndAssistService salaAssistService;// 一般状况,生活方式,辅助检查
	@Autowired
	private DiabetesService diabetesService;// 糖尿病
	@Autowired
	private PsychosisService psychosisService;// 重性精神疾病
	@Autowired
	private CoronaryHeartService coronaryHeartService;// 冠心病
	@Autowired
	private ChronicBronchialService cBronchialService;// 慢性支气管病
	@Autowired
	private TumourService tumourService;// 肿瘤
	@Autowired
	private HeartAndCerebralService hAndCerebralService;// 心脑血管
	@Autowired
	private DisabilityService diService;// 残疾障碍
	@Autowired
	private StaffService staffservice;// 员工
	@Autowired
	private MaintainableAttributeService maintainableAttributeService;// 可维护字段
	@Autowired
	private CommunityHospitalService communityHospitalService;// 管理员表
	@Autowired
	private PhysicalExamService physicalExamService;
	@Autowired
	private CommunityHospitalGroupService communityHospitalGroupService;
	
	private Integer chronicId;
	ChronicVerify chronicVerify = new ChronicVerify();
	private TDisabilityObstacle disability;
	private THcvd hcvd;// 心脑血管档案实体
	private TTumour tumour;// 肿瘤实体
	private TChronicBronchialDisease cbronchialDisease;// 慢性支气管病实体
	private TCoronaryDisease coronaryDisease;// 冠心病实体
	private TAuxiliaryExamination auxiliaryExamination;// 辅助检查实体
	private TDiabete diabete;// 糖尿病实体
	private VChronic vchronic;// 慢病视图实体
	private VHealthStaff vhealthstaff;//健康档案老人医生关系表视图
	private List<VHealthStaff> listolder;
	private TChronicDisease chronicDisease;// 慢病总表实体
	private int cp = 1;
	private int cp1 = 1;
	private List<VChronic> vclist;
	private String fileNum;// 健康档案编号
	private Page<VChronic> page;
	private Page<VChronic> pagePlus;
	private Page<VExam> epage;
	private int sqid;// 社区id
	private String pageHtml;
	private TInsanityForm inForm;// 重性精神疾病实体
	private THighBloodPressure highBloodPressure;// 高血压实体
	private TGeneralCondition generalCondition; // 一般状况实体
	private TLifeStyle lifeStyle;// 生活方式实体
	private THealthFile healthFile;// 健康档案实体
	private SearchBean searchbean;// search查询工具类（感谢双姐提供支持）
	// private SearchBean search;
	// private static SearchBean searched;
	private String flagsear;
	private int[] ids;
	private int chid;// 慢病总表id
	private int helid; // 健康档案id
	private int idOrfid;// 选择条件判断用的变量
	private String idcardOrfild;// 身份证号或者档案编号
	private String dqname;// 当前疾病名称
	private String tishi;// 提示信息
	private int zqgid;// 慢性支气管病id
	private int jsbid;// 重性精神疾病id
	private int zlid;// 肿瘤id
	private int cjid;// 残疾障碍id
	private int xnid;// 心脑血管病id
	private TStaff tuser; // 普通员工实体
	private List<TStaff> staffs;// 员工表集合
	// private List<TStaff> zrstaffs;//用于责任医生下拉框
	private TCommunityHospital admin;// 管理员
	private List<TCommunityHospital> hospitals; // 社区医院list
	private List<TCommunityHospitalGroup> groups;//社区集团list
	private TOldStaffHos oldstaffhos;// 老人,医院,员工
	private String filename;// 建档人名称
	private ArrayList<String> list;
	private int zhuangtai;// 档案状态
	private boolean flag = false;
	private int[] chlist = null;// 用于多条件查询的慢病种类回显
	private List<VExam> velist;// 体检视图集合
	private int chrionFlag;// 导出全部或本业的判断量
	// private int ptsqid = 0;//平台管理员社区id
	private int issq = 2;// 判断是否是平台管理员的状态量，用于是否显示社区医院搜索医院选项,默认不显示集团、社区医院查询选项
	int stasus = CHRONIC_MANAGER.DELETE_CHRONICFILE.getValue();// 慢病删除状态量
	private String htype;// 健康档案状态
	private String nulloldmessage;//未查到老人提示信息
	private List<TStaff> specialDoctor;
	private String token;
	private boolean showwindow = false;
	//用于判断是否嵌入到门诊接诊记录页面 false:没有嵌入，true:嵌入
	private boolean embeded = false;
	

	/**
	 * 导出慢病档案
	 */
	public String fuction() throws Exception {
		// 从session里拿到当前登录用户的id
			int userId = GetSessionPerson.getPerson();
			if (chrionFlag == 2) {
				List<ChronicExport> chronicList = new ArrayList<ChronicExport>();
				if (ids != null) {
					for (int i = 0; i < ids.length; i++) {
						VChronic vc = allChronicDiseaseService
								.getOneVcForSupper(ids[i]);
						if (vc != null) {
							ChronicExport ce = new ChronicExport(vc);// 需要传实体
							chronicList.add(ce);
						}
					}
				}
				ChronicExport ce = new ChronicExport();
				String[] titles = ce.getTitles();
				JxlExcel he = new JxlExcel(titles);
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setHeader("content-disposition", "attachment;filename="
						+ 4 + ".xls");
				ServletOutputStream output = response.getOutputStream();
				he.write(chronicList, output);
				response.flushBuffer();
			}
			if (chrionFlag == 1) {// 导出全部
				getNowSqid();
				if (userId == 0) {

				} else if (userId > 0
						&& healthFileService.getOldStaffHosByStaffId(userId)) {
					vclist = allChronicDiseaseService.getSomeInformationsForDoctor(
							userId, sqid);
				} else if (!healthFileService.getOldStaffHosByStaffId(userId)
						|| userId < 0) {
					vclist = allChronicDiseaseService
							.someInformationForNurseAndSmalladmin(sqid);
				}

				List<ChronicExport> chronicList = new ArrayList<ChronicExport>();
				String[] titles = (new ChronicExport()).getTitles();
				for (VChronic vc : vclist) {
					if (vc != null) {
						ChronicExport ce = new ChronicExport(vc);
						chronicList.add(ce);
					}
				}
				HttpServletResponse response = ServletActionContext.getResponse();
				response.setHeader("content-disposition", "attachment;filename="
						+ 4 + ".xls");
				ServletOutputStream output = response.getOutputStream();
				JxlExcel he = new JxlExcel(titles);
				he.write(chronicList, output);
				response.flushBuffer();
			}
		return "error";
	}

	/**
	 * 获取员工社区id
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
		} else {
			int userId = GetSessionPerson.getPerson();


			// user大于0,员工id
			if (userId > 0) {
				sqid = staffservice.getCommHospitalByStaffId(userId);
				// user小于0,社区负责人id;等于0,平台admin
			} else if (userId < 0 || userId == 0) {
				sqid = Math.abs(userId);
			}
		
			return sqid;
		}
	}

	public String onePeopleJump() {
		getNowSqid();
		

		healthFile = healthFileService.getHealthFileById(helid);
		vclist = allChronicDiseaseService.getPeoPleAllIll(helid, sqid, stasus);
		return "onePeopleJump";
	}

	public String searchChronicPeople() {
		//集团
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
		chlist = new int[8];
		if(group!=null){
			hospitals=communityHospitalGroupService.getComHosListByGroup(group);//该集团下所有社区医院
			searchbean.setShenfen(4);
			if(searchbean.getSqid()==0){   //查询全部传集团id 
				searchbean.setSqid(group.getGId());
				searchbean.setAll(true);
			}else{
				searchbean.setSqid(searchbean.getSqid());  //查询医院传医院id
			}
			issq = 0;
		}
		else{
		// 从session里拿到当前登录用户的id
		int userId = GetSessionPerson.getPerson();
		getNowSqid();
		if (userId == 0) {
			groups=communityHospitalGroupService.getAllQiYongGroups(); //得到所有启用集团
			searchbean.setShenfen(0);
			issq = 1;//1代表超级管理员显示集团查询项
		} else if (userId > 0
				&& !healthFileService.getOldStaffHosByStaffId(userId)) {         //普通员工
			staffs = staffservice.getStaffByCommunityHospitalId(sqid);
			specialDoctor=healthFileService.getSpeciallDoctor(sqid);
			// zrstaffs = staffservice.getStaffByCommunityHospitalId(sqid);
			searchbean.setShenfen(2);// 非责任医生的普通员工，则向SearchBean里面设置shenfen值为2
			searchbean.setSqid(sqid);
		} else if (userId < 0) {
			staffs = staffservice.getStaffByCommunityHospitalId(sqid);
			specialDoctor=healthFileService.getSpeciallDoctor(sqid);
			// zrstaffs = staffservice.getStaffByCommunityHospitalId(sqid);
			searchbean.setShenfen(1);// 社区管理员，则向SearchBean里面设置shenfen值为1
			searchbean.setSqid(sqid);
		} else if (userId > 0
				&& healthFileService.getOldStaffHosByStaffId(userId)) {
			searchbean.setShenfen(3);// 责任医生，则向SearchBean里面设置shenfen值为3
			staffs = staffservice.getStaffByCommunityHospitalId(sqid);
			searchbean.setYsid(userId);
			searchbean.setSqid(sqid);
			flag = true;
		}
		}
		pagePlus = new Page<VChronic>();
		if (searchbean.getRenqun() != null) {
			for (int i = 0; i < searchbean.getRenqun().length; i++) {
				int m = searchbean.getRenqun()[i];
				chlist[i] = m;
			}
		}
		if(flagsear==null){
			pagePlus.setCurrentPage(cp1);
			pagePlus.setTotalNum(allChronicDiseaseService
					.findChronicPeopleCount(searchbean));
			this.pageHtml = pagePlus.getPageForChronic("entity");
			vclist = allChronicDiseaseService.findChronicPeople(searchbean, pagePlus);
		}
		if (flagsear != null) {
			if (flagsear.equals("flagDiabete")) {
				int status = CHRONIC_MANAGER.DIABETE_MANAGER.getValue();
				pagePlus.setTotalNum(allChronicDiseaseService
						.findHealtherCount(searchbean,status));
				vclist = allChronicDiseaseService.findHealther(searchbean, pagePlus, status);
				this.pageHtml = pagePlus.getPageForChronic("entity");
				return "allDiabeteManager";
			}
			if (flagsear.equals("flagBlood")) {
				int status = CHRONIC_MANAGER.HIGHBLOODPRESSURE_MANAGER.getValue();
				pagePlus.setTotalNum(allChronicDiseaseService
						.findHealtherCount(searchbean,status));
				vclist = allChronicDiseaseService.findHealther(searchbean, pagePlus, status);
				this.pageHtml = pagePlus.getPageForChronic("entity");
				return "allHighBloodManager";
			}
			if (flagsear.equals("flagOther")) {
				int status = CHRONIC_MANAGER.OTHER_MANAGER.getValue();
				pagePlus.setTotalNum(allChronicDiseaseService
						.findHealtherCount(searchbean,status));
				vclist = allChronicDiseaseService.findHealther(searchbean,
						pagePlus, status);
				this.pageHtml = pagePlus.getPageForChronic("entity");
				return "otherManager";
			}
		}
		return "searchChronicPeople";
	}
   
	//检查是否有慢性病，返回对应慢性病的id。如果有对应的慢性病，则只会返回一个慢性病id。
	public void checkHasChronic() {
		//集团
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
		chlist = new int[8];
		if(group!=null){
			hospitals=communityHospitalGroupService.getComHosListByGroup(group);//该集团下所有社区医院
			searchbean.setShenfen(4);
			if(searchbean.getSqid()==0){   //查询全部传集团id 
				searchbean.setSqid(group.getGId());
				searchbean.setAll(true);
			}else{
				searchbean.setSqid(searchbean.getSqid());  //查询医院传医院id
			}
			issq = 0;
		}
		else{
		// 从session里拿到当前登录用户的id
		int userId = GetSessionPerson.getPerson();
		getNowSqid();
		if (userId == 0) {
			groups=communityHospitalGroupService.getAllQiYongGroups(); //得到所有启用集团
			searchbean.setShenfen(0);
			issq = 1;//1代表超级管理员显示集团查询项
		} else if (userId > 0
				&& !healthFileService.getOldStaffHosByStaffId(userId)) {         //普通员工
			staffs = staffservice.getStaffByCommunityHospitalId(sqid);
			specialDoctor=healthFileService.getSpeciallDoctor(sqid);
			// zrstaffs = staffservice.getStaffByCommunityHospitalId(sqid);
			searchbean.setShenfen(2);// 非责任医生的普通员工，则向SearchBean里面设置shenfen值为2
			searchbean.setSqid(sqid);
		} else if (userId < 0) {
			staffs = staffservice.getStaffByCommunityHospitalId(sqid);
			specialDoctor=healthFileService.getSpeciallDoctor(sqid);
			// zrstaffs = staffservice.getStaffByCommunityHospitalId(sqid);
			searchbean.setShenfen(1);// 社区管理员，则向SearchBean里面设置shenfen值为1
			searchbean.setSqid(sqid);
		} else if (userId > 0
				&& healthFileService.getOldStaffHosByStaffId(userId)) {
			searchbean.setShenfen(3);// 责任医生，则向SearchBean里面设置shenfen值为3
			staffs = staffservice.getStaffByCommunityHospitalId(sqid);
			searchbean.setYsid(userId);
			searchbean.setSqid(sqid);
			flag = true;
		}
		}
		pagePlus = new Page<VChronic>();
		if (searchbean.getRenqun() != null) {
			for (int i = 0; i < searchbean.getRenqun().length; i++) {
				int m = searchbean.getRenqun()[i];
				chlist[i] = m;
			}
		}
		if(flagsear==null){
			pagePlus.setCurrentPage(cp1);
			pagePlus.setTotalNum(allChronicDiseaseService
					.findChronicPeopleCount(searchbean));
			this.pageHtml = pagePlus.getPageForChronic("entity");
			vclist = allChronicDiseaseService.findChronicPeople(searchbean, pagePlus);
		}
		if (flagsear != null) {
			if (flagsear.equals("flagDiabete")) {
				int status = CHRONIC_MANAGER.DIABETE_MANAGER.getValue();
				pagePlus.setTotalNum(allChronicDiseaseService
						.findHealtherCount(searchbean,status));
				vclist = allChronicDiseaseService.findHealther(searchbean, pagePlus, status);
				this.pageHtml = pagePlus.getPageForChronic("entity");
				if(vclist!=null&&vclist.size()>0){
					chronicId = vclist.get(0).getChronicDiseaseId();
				} else {
					chronicId = -1;
				}
				this.writeJson(chronicId);
				return;
			}
			if (flagsear.equals("flagBlood")) {
				int status = CHRONIC_MANAGER.HIGHBLOODPRESSURE_MANAGER.getValue();
				pagePlus.setTotalNum(allChronicDiseaseService
						.findHealtherCount(searchbean,status));
				vclist = allChronicDiseaseService.findHealther(searchbean, pagePlus, status);
				this.pageHtml = pagePlus.getPageForChronic("entity");
				if(vclist!=null&&vclist.size()>0){
					chronicId = vclist.get(0).getChronicDiseaseId();
				} else {
					chronicId = -1;
				}
				this.writeJson(chronicId);
				return;
			}
			if (flagsear.equals("flagOther")) {
				int status = CHRONIC_MANAGER.OTHER_MANAGER.getValue();
				pagePlus.setTotalNum(allChronicDiseaseService
						.findHealtherCount(searchbean,status));
				vclist = allChronicDiseaseService.findHealther(searchbean,
						pagePlus, status);
				this.pageHtml = pagePlus.getPageForChronic("entity");
				if(vclist!=null&&vclist.size()>0){
					chronicId = vclist.get(0).getChronicDiseaseId();
				} else {
					chronicId = -1;
				}
				this.writeJson(chronicId);
				return;
			}
		}
		if(vclist!=null&&vclist.size()>0){
			chronicId = vclist.get(0).getChronicDiseaseId();
		} else {
			chronicId = -1;
		}
		
		this.writeJson(chronicId);
		return;
	}
	
	/**
	 * 得到当前登录用户名字，用于慢病建档人
	 */
	public void showFileName() {
		// 从session里拿到当前登录用户的id
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group = (TCommunityHospitalGroup) session
				.getAttribute("communityHospitalGroup");
		if (group != null) {
			
		} else {
			int userId = GetSessionPerson.getPerson();

			getNowSqid();
			if (userId > 0) {
				tuser = staffservice.getStaffById(userId);
				filename = tuser.getName();
			} else {
				admin = communityHospitalService.getCommunityHospitalById(sqid);
				filename = admin.getName();
			}
		}
	}

	/**
	 * 慢病年检查看
	 * 
	 * @return
	 */
	public String showSlowChronic() {
		epage = new Page<VExam>();
		epage.setCurrentPage(cp);
		// 从session里拿到当前登录用户的id
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group = (TCommunityHospitalGroup) session
				.getAttribute("communityHospitalGroup");
		if(group != null){
			int gid = group.getGId();
			vhealthstaff = healthFileService.getGroup(helid);
			if(vhealthstaff==null||vhealthstaff.equals(null)){
				return "error";
			}
			int oldGid = vhealthstaff.getGId();
			if(gid == oldGid){
				velist = physicalExamService.searchVExamViewLzy(helid, epage);
				healthFile = healthFileService.getHealthFileById(helid);
				epage.setTotalNum(physicalExamService.searchVExamView(helid).size());
				pageHtml = epage
						.getPage("showOldChronicAction!showSlowChronic.action?helid="
								+ helid);
				return "showSlowChronic";
			}else{
				return "error";
			}
		}
		int userId = GetSessionPerson.getPerson();

		if (userId != 0) {// 如果是平台管理员则不用校验，这里不等于0，说明不是平台管理员
			chronicVerify.setHelid(helid);
			if (chronicVerify.verify() == false) {
				return "error";
			}
		}
		velist = physicalExamService.searchVExamViewLzy(helid, epage);
		healthFile = healthFileService.getHealthFileById(helid);
		epage.setTotalNum(physicalExamService.searchVExamView(helid).size());
		pageHtml = epage
				.getPage("showOldChronicAction!showSlowChronic.action?helid="
						+ helid);
		return "showSlowChronic";

	}

	/**
	 * 首页展示方法
	 * 
	 * @return
	 */
	public String firstShowChronic() {
		page = new Page<VChronic>();
		page.setCurrentPage(cp);
		// 从session里拿到当前登录用户的id
		int zt = HealthFileCheck.zhengchang.getValue();
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group = (TCommunityHospitalGroup) session
				.getAttribute("communityHospitalGroup");
		if (group != null) {
			int gid = group.getGId();
			hospitals = communityHospitalGroupService.getComHosListByGroup(group);
			issq = 0;//0代表集团显示医院查询项
			page.setTotalNum(allChronicDiseaseService.getAllPeopleNumForGroup(gid, zt));
			this.pageHtml = page.getPage("showOldChronicAction!firstShowChronic.action");
			vclist = allChronicDiseaseService.getAllPeopleForGroup(gid, zt, page);
			return "firstShowChronic";
		} else {
			int userId = GetSessionPerson.getPerson();
			getNowSqid();
			// staffs = staffservice.getStaffByCommunityHospitalId(sqid);
			if (userId == 0) {
				//hospitals = communityHospitalService.getAllHospitals();
				groups = communityHospitalGroupService.getAllGroups();
				// admin = hospitals.get(0);
				// staffs =
				// staffservice.getStaffByCommunityHospitalId(admin.getCommunityHospitalId());
				// zrstaffs =
				// staffservice.getStaffByCommunityHospitalId(admin.getCommunityHospitalId());
				issq = 1;
			} else if (userId > 0
					&& !healthFileService.getOldStaffHosByStaffId(userId)) {
				staffs = staffservice.getStaffByCommunityHospitalId(sqid);
				specialDoctor = healthFileService.getSpeciallDoctor(sqid);
				// zrstaffs = staffservice.getStaffByCommunityHospitalId(sqid);
			} else if (userId < 0) {
				staffs = staffservice.getStaffByCommunityHospitalId(sqid);
				specialDoctor = healthFileService.getSpeciallDoctor(sqid);
				// zrstaffs = staffservice.getStaffByCommunityHospitalId(sqid);
			} else if (userId > 0
					&& healthFileService.getOldStaffHosByStaffId(userId)) {
				staffs = staffservice.getStaffByCommunityHospitalId(sqid);
				flag = true;
			}
			/*
			 * if(healthFileService.getOldStaffHosByStaffId(userId)==null){ for
			 * (int i = 0; i < zrstaffs.size(); i++) { tuser = zrstaffs.get(i);
			 * int sid = tuser.getStaffId();
			 * if(healthFileService.getOldStaffHosByStaffId(sid)==null){
			 * zrstaffs.remove(i); } } }
			 */
			if (userId > 0) {// 判断普通员工是否为空(包括 责任医生和普通员工)
				if (healthFileService.getOldStaffHosByStaffId(userId)) {// 判断是否是责任医生
					page.setTotalNum(allChronicDiseaseService
							.getSomePeopleCountForDoctor(zt, userId, sqid));
					this.pageHtml = page
							.getPage("showOldChronicAction!firstShowChronic.action");
					vclist = allChronicDiseaseService.getSomePeopleForDoctor(
							zt, userId, sqid, page);
					return "firstShowChronic";
				} else {
					page.setTotalNum(allChronicDiseaseService.getAllVcCount(
							sqid, zt));
					this.pageHtml = page
							.getPage("showOldChronicAction!firstShowChronic.action");
					vclist = allChronicDiseaseService.firstGetAllVc(sqid, zt,
							page);
					return "firstShowChronic";
				}
			} else if (userId < 0) {// 如果userId<0,则是社区管理员此时的userId是社区id的负数
				page.setTotalNum(allChronicDiseaseService.getAllVcCount(sqid,
						zt));
				this.pageHtml = page
						.getPage("showOldChronicAction!firstShowChronic.action");
				vclist = allChronicDiseaseService.firstGetAllVc(sqid, zt, page);
				return "firstShowChronic";
			}
			page.setTotalNum(allChronicDiseaseService
					.getAllPeopleCountForSupper(zt));
			this.pageHtml = page
					.getPage("showOldChronicAction!firstShowChronic.action");
			vclist = allChronicDiseaseService.getAllPeopleForSupper(zt, page);
			return "firstShowChronic";
		}
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
	 * 跳转到添加高血压添加页
	 * 
	 * @return
	 */
	public String jumpOneHighBlood() {
		if (helid == 0) {
			// highBloodMain();
			// showFileName();
			return "jumpadd";
		}
		Repetition();
		getNowSqid();
		chronicVerify.setHelid(helid);
		if (chronicVerify.verify() == true) {
			healthFile = healthFileService.getHealthFileById(helid);
			showFileName();
			highBloodMain();
			healthFile = healthFileService.getHealthFileById(helid);
			vclist = allChronicDiseaseService.getPeoPleAllIll(helid, sqid,
					stasus);
			return "oneOneHighBlood";
		} else {
			return "error";
		}
	}

	/**
	 * 高血压可维护字段
	 */
	public void highBloodMain() {
		gxytype = maintainableAttributeService.getmEntriesByCode("02001");
		gxybfz = maintainableAttributeService.getmEntriesByCode("02002");
		gxyglfj = maintainableAttributeService.getmEntriesByCode("02016");
		dcsjlycxy = maintainableAttributeService.getmEntriesByCode("02003");
		sffjyy = maintainableAttributeService.getmEntriesByCode("02004");
		bfhbglfyyy = maintainableAttributeService.getmEntriesByCode("02005");
		fywffzlgxy = maintainableAttributeService.getmEntriesByCode("02006");
		jzzgxyhz = maintainableAttributeService.getmEntriesByCode("02007");
		ysxg = maintainableAttributeService.getmEntriesByCode("02008");
		tydlpl = maintainableAttributeService.getmEntriesByCode("02010");
		dlfs = maintainableAttributeService.getmEntriesByCode("02011");
		yjpl = maintainableAttributeService.getmEntriesByCode("02012");
		xyzk = maintainableAttributeService.getmEntriesByCode("02013");
		yjzl = maintainableAttributeService.getmEntriesByCode("02014");
		mqzyzz = maintainableAttributeService.getmEntriesByCode("02015");
	}

	/**
	 * 从首页跳转到添加页的方法
	 * 
	 * @return
	 */
	public String jumpadd() {
		// highBloodMain();
		// getNowSqid();
		// showFileName();
		return "jumpadd";
	}

	/**
	 * 跳转到添加糖尿病的方法
	 * 
	 * @return
	 */
	public String jumpDiabete() {
		if (helid == 0) {
			// diabeteMain();
			// showFileName();
			return "jumpadd";
		}
		Repetition();
		getNowSqid();
		chronicVerify.setHelid(helid);
		if (chronicVerify.verify() == false) {
			return "error";
		}
		diabeteMain();
		showFileName();
		healthFile = healthFileService.getHealthFileById(helid);
		vclist = allChronicDiseaseService.getPeoPleAllIll(helid, sqid, stasus);
		return "jumpDiabete";
	}

	/**
	 * 糖尿病可维护字段
	 */
	public void diabeteMain() {
		tnbc = maintainableAttributeService.getmEntriesByCode("03001");
		tnblx = maintainableAttributeService.getmEntriesByCode("03002");
		tnbbfz = maintainableAttributeService.getmEntriesByCode("03003");
		tnbjws = maintainableAttributeService.getmEntriesByCode("03004");
		xyzk = maintainableAttributeService.getmEntriesByCode("02013");
		tydlpl = maintainableAttributeService.getmEntriesByCode("02010");
		dlfs = maintainableAttributeService.getmEntriesByCode("02011");
		ysxg = maintainableAttributeService.getmEntriesByCode("02008");
		yjpl = maintainableAttributeService.getmEntriesByCode("02012");
		yjzl = maintainableAttributeService.getmEntriesByCode("02014");
		jtztnbhz = maintainableAttributeService.getmEntriesByCode("03005");
		tnbmqzyzz = maintainableAttributeService.getmEntriesByCode("03006");
	}

	/**
	 * 跳转到添加重性精神疾病方法
	 * 
	 * @return
	 */
	public String jumpInsanityform() {
		if (helid == 0) {
			// insanityformMain();
			// showFileName();
			return "jumpadd";
		}
		Repetition();
		getNowSqid();
		chronicVerify.setHelid(helid);
		if (chronicVerify.verify() == false) {
			return "error";
		}
		insanityformMain();
		showFileName();
		healthFile = healthFileService.getHealthFileById(helid);
		vclist = allChronicDiseaseService.getPeoPleAllIll(helid, sqid, stasus);
		return "jumpInsanityform";
	}

	/**
	 * 重性精神疾病可维护字段
	 */
	public void insanityformMain() {
		jwzyzz = maintainableAttributeService.getmEntriesByCode("04001");
		jwzlqkmz = maintainableAttributeService.getmEntriesByCode("04002");
		jwzlqkzy = maintainableAttributeService.getmEntriesByCode("04003");
		zhyczlxg = maintainableAttributeService.getmEntriesByCode("04004");
		hbdjtshdyx = maintainableAttributeService.getmEntriesByCode("04005");// 页面无法显示,但是这里正常,待解决
		gsqk = maintainableAttributeService.getmEntriesByCode("04006");
	}

	/**
	 * 跳转添加到冠心病方法
	 * 
	 * @return
	 */
	public String jumpCoronary() {
		if (helid == 0) {
			// coronaryMain();
			// showFileName();
			return "jumpadd";
		}
		chronicVerify.setHelid(helid);
		if (chronicVerify.verify() == false) {
			return "error";
		}
		Repetition();
		getNowSqid();
		coronaryMain();
		showFileName();
		healthFile = healthFileService.getHealthFileById(helid);
		vclist = allChronicDiseaseService.getPeoPleAllIll(helid, sqid, stasus);
		return "jumpCoronary";
	}

	/**
	 * 冠心病可维护字段
	 */
	public void coronaryMain() {
		wxyy = maintainableAttributeService.getmEntriesByCode("05002");
		qbxs = maintainableAttributeService.getmEntriesByCode("05003");
		xdt = maintainableAttributeService.getmEntriesByCode("05004");
		ndt = maintainableAttributeService.getmEntriesByCode("05005");
		yyqk = maintainableAttributeService.getmEntriesByCode("05006");
		xx = maintainableAttributeService.getmEntriesByCode("05007");
		ct = maintainableAttributeService.getmEntriesByCode("05008");
		nxgzy = maintainableAttributeService.getmEntriesByCode("05009");
		gxblx = maintainableAttributeService.getmEntriesByCode("05010");
		bfz = maintainableAttributeService.getmEntriesByCode("05011");
	}

	/**
	 * 跳转到添加慢性支气管病档案
	 * 
	 * @return
	 */
	public String jumpBronchial() {
		if (helid == 0) {
			// bronchialMain();
			// showFileName();
			return "jumpadd";
		}
		chronicVerify.setHelid(helid);
		if (chronicVerify.verify() == false) {
			return "error";
		}
		Repetition();
		getNowSqid();
		bronchialMain();
		showFileName();
		healthFile = healthFileService.getHealthFileById(helid);
		vclist = allChronicDiseaseService.getPeoPleAllIll(helid, sqid, stasus);
		return "jumpBronchial";
	}

	/**
	 * 慢性支气管病可维护字段
	 */
	public void bronchialMain() {
		fbzyyy = maintainableAttributeService.getmEntriesByCode("07001");
		ksys = maintainableAttributeService.getmEntriesByCode("07002");
		zjqdpd = maintainableAttributeService.getmEntriesByCode("07003");
		xzgnfj = maintainableAttributeService.getmEntriesByCode("07004");
		kscd = maintainableAttributeService.getmEntriesByCode("07005");
		xcg = maintainableAttributeService.getmEntriesByCode("07006");
		ttphpy = maintainableAttributeService.getmEntriesByCode("07007");
		xx = maintainableAttributeService.getmEntriesByCode("05007");
		fgncd = maintainableAttributeService.getmEntriesByCode("07008");
		mxzqgbbfz = maintainableAttributeService.getmEntriesByCode("07009");
	}

	/**
	 * 跳转到添加肿瘤档案方法
	 * 
	 * @return
	 */
	public String jumpTumour() {
		if (helid == 0) {
			// tumonrMain();
			// showFileName();
			return "jumpadd";
		}
		chronicVerify.setHelid(helid);
		if (chronicVerify.verify() == false) {
			return "error";
		}
		Repetition();
		getNowSqid();
		tumonrMain();
		showFileName();
		healthFile = healthFileService.getHealthFileById(helid);
		vclist = allChronicDiseaseService.getPeoPleAllIll(helid, sqid, stasus);
		return "jumpTumour";
	}

	/**
	 * 肿瘤可维护字段
	 */
	public void tumonrMain() {// 转移情况未显示,需要在数据库的数据字典里面添加转移情况字段
		blxlx = maintainableAttributeService.getmEntriesByCode("06001");
		qzyj = maintainableAttributeService.getmEntriesByCode("06002");
		qzsqb = maintainableAttributeService.getmEntriesByCode("06003");
		cjzlqk = maintainableAttributeService.getmEntriesByCode("06004");
		mqzlqk = maintainableAttributeService.getmEntriesByCode("06005");
		cxsfjlyy = maintainableAttributeService.getmEntriesByCode("06006");
		fxfs = maintainableAttributeService.getmEntriesByCode("06007");
		djfs = maintainableAttributeService.getmEntriesByCode("06008");
		xbx = maintainableAttributeService.getmEntriesByCode("06009");
		zzx = maintainableAttributeService.getmEntriesByCode("06010");
		zzlx = maintainableAttributeService.getmEntriesByCode("06011");
		zlqk = maintainableAttributeService.getmEntriesByCode("06012");
		fq = maintainableAttributeService.getmEntriesByCode("06013");
	}

	/**
	 * 跳转到心脑血管档案添加方法
	 * 
	 * @return
	 */
	public String jumpHcvd() {
		if (helid == 0) {
			// hcvdMain();
			// showFileName();
			return "jumpadd";
		}
		chronicVerify.setHelid(helid);
		if (chronicVerify.verify() == false) {
			return "error";
		}
		Repetition();
		getNowSqid();
		hcvdMain();
		showFileName();
		healthFile = healthFileService.getHealthFileById(helid);
		vclist = allChronicDiseaseService.getPeoPleAllIll(helid, sqid, stasus);
		return "jumpHcvd";
	}

	/**
	 * 心脑血管可维护字段
	 */
	public void hcvdMain() {
		xnxgblx = maintainableAttributeService.getmEntriesByCode("05001");// 存在该数据列表但是页面不显示
		wxyy = maintainableAttributeService.getmEntriesByCode("05002");
		qbxs = maintainableAttributeService.getmEntriesByCode("05003");
		xdt = maintainableAttributeService.getmEntriesByCode("05004");
		ndt = maintainableAttributeService.getmEntriesByCode("05005");
		yyqk = maintainableAttributeService.getmEntriesByCode("05006");
		xx = maintainableAttributeService.getmEntriesByCode("05007");
		ct = maintainableAttributeService.getmEntriesByCode("05008");
		nxgzy = maintainableAttributeService.getmEntriesByCode("05009");
		gxblx = maintainableAttributeService.getmEntriesByCode("05010");
		bfz = maintainableAttributeService.getmEntriesByCode("05011");
	}

	/**
	 * 跳转到残疾障碍添加页面方法
	 * 
	 * @return
	 */
	public String jumpDisability() {
		if (helid == 0) {
			// disabilityMain();
			// showFileName();
			return "jumpadd";
		}
		chronicVerify.setHelid(helid);
		if (chronicVerify.verify() == false) {
			return "error";
		}
		Repetition();
		getNowSqid();
		disabilityMain();
		showFileName();
		healthFile = healthFileService.getHealthFileById(helid);
		vclist = allChronicDiseaseService.getPeoPleAllIll(helid, sqid, stasus);
		return "jumpDisability";
	}

	/**
	 * 残疾障碍可维护字段
	 */
	public void disabilityMain() {
		cjyy = maintainableAttributeService.getmEntriesByCode("08001");
		ztcfl = maintainableAttributeService.getmEntriesByCode("08002");
		kfjg = maintainableAttributeService.getmEntriesByCode("08003");
		bkfyy = maintainableAttributeService.getmEntriesByCode("08004");
		jsbfj = maintainableAttributeService.getmEntriesByCode("08005");
		tlcfj = maintainableAttributeService.getmEntriesByCode("08006");
		zlcjfj = maintainableAttributeService.getmEntriesByCode("08007");
		yycjfj = maintainableAttributeService.getmEntriesByCode("08008");
		slcfj = maintainableAttributeService.getmEntriesByCode("08009");
		ztcfj = maintainableAttributeService.getmEntriesByCode("08010");
	}

	/**
	 * 通过健康档案编号或居民身份证得到老人
	 * 
	 * @return
	 */
	public String searchOlder() {

		// 从session里拿到当前登录用户的id
		int userId = GetSessionPerson.getPerson();
		getNowSqid();
		int doctorid = 0;
		if (idOrfid == 2) {// 如果等于0,则是用档案编号进行查询
			if (idcardOrfild.equals("")) {
				nulloldmessage="请输入档案编号或身份证号！";
				return "jump";
			}// 这里应该在当前页弹窗"请填写查询信息",暂时返回jump
			healthFile = healthFileService.getHealthFileByFileNum(idcardOrfild);
			if (healthFile == null||Integer.valueOf(healthFile.getHealthFileType())==HealthFileCheck.zhuxiao.getValue()||
					Integer.valueOf(healthFile.getHealthFileType())==HealthFileCheck.siwang.getValue()) {
				nulloldmessage=" 未找到该老人信息";
				return "jump";
			}// 返回jump
			int hid = healthFile.getHealthFileId();// 拿到健康档案id
			oldstaffhos = staffservice.gethosByFileid(hid);// 拿到老人,医院,员工表实体
			if (oldstaffhos == null) {
				nulloldmessage=" 未找到该老人信息";
				healthFile = null;
				return "jump";
			}
			int hosid = oldstaffhos.getTCommunityHospital()
					.getCommunityHospitalId();
			if (hosid != sqid) {// 如果查到的人的医院id不等于社区医院id,则返回当前页
				healthFile = null;
				nulloldmessage=" 未找到该老人信息";
				return "jump";
			} else if (userId > 0
					&& healthFileService.getOldStaffHosByStaffId(userId)) {// 如果userId大于0且后面的执行不为空
				doctorid = oldstaffhos.getTStaff().getStaffId();// 则是责任医生且拿到该责任医生的id
				if (doctorid != userId) {// 如果该责任医生id与老人的对应的责任医生id不对应则返回当前页面
					nulloldmessage=" 未找到该老人信息";
					healthFile = null;
					return "jump";
				}
			}
			vclist = allChronicDiseaseService
					.getPeoPleAllIll(hid, sqid, stasus);
			highBloodMain();
			showFileName();
			return "searchOlder";
		} else if(idOrfid==1){// 这个是通过身份证号进行查询
			if (idcardOrfild.equals("")) {
				nulloldmessage="请输入档案编号或身份证号！";
				return "jump";
			}// 这里应该在当前页弹窗"请填写查询信息"
			healthFile = healthFileService.getHealthFileByIdNum(idcardOrfild);
			if (healthFile == null||Integer.valueOf(healthFile.getHealthFileType())==HealthFileCheck.zhuxiao.getValue()||
					Integer.valueOf(healthFile.getHealthFileType())==HealthFileCheck.siwang.getValue()) {
				nulloldmessage="未找到该老人信息";
				return "jump";
			}// 这里应该是返回到当前页面并弹窗提示查无此人
			int hid = healthFile.getHealthFileId();
			oldstaffhos = staffservice.gethosByFileid(hid);
			if (oldstaffhos == null) {
				nulloldmessage=" 未找到该老人信息";
				healthFile = null;
				return "jump";
			}
			int hosid = oldstaffhos.getTCommunityHospital()
					.getCommunityHospitalId();
			if (hosid != sqid) {
				nulloldmessage=" 未找到该老人信息";
				healthFile = null;
				return "jump";
			} else if (userId > 0
					&& healthFileService.getOldStaffHosByStaffId(userId)) {
				doctorid = oldstaffhos.getTStaff().getStaffId();
				if (doctorid != userId) {
					nulloldmessage=" 未找到该老人信息";
					healthFile = null;
					return "jump";
				}
			}
			showFileName();
			vclist = allChronicDiseaseService
					.getPeoPleAllIll(hid, sqid, stasus);
			return "searchOlder";
		}else{
			getNowSqid();
			if(userId > 0){
				boolean doctor = healthFileService.getOldStaffHosByStaffId(userId);
				if(doctor == true){
					doctorid = userId;
					listolder = healthFileService.getVHealthStaffByOldNameForSpecial(doctorid, idcardOrfild);
				}else{
					listolder = healthFileService.getVHealthStaffByOldNameForNormal(sqid, idcardOrfild);
				}
			}else if(userId<0){
				listolder = healthFileService.getVHealthStaffByOldNameForNormal(sqid, idcardOrfild);
			}
			if(listolder.size()==0){
				nulloldmessage=" 未找到该老人信息";
				healthFile = null;
				return "jump";
			}else if(listolder.size()==1){
				vhealthstaff = listolder.get(0);
				int hid = vhealthstaff.getHealthFileId();
				healthFile = healthFileService.getHealthFileById(hid);
				vclist = allChronicDiseaseService
						.getPeoPleAllIll(hid, sqid, stasus);
				return "searchOlder";
			}else if(listolder.size()>1){
				showwindow=true;
				return "searchOlder";
			}
			return null;
		}
	}

	/**
	 * 用于添加慢病时用姓名查询
	 * @return
	 */
	public String ReOlder(){
		chronicVerify.setHelid(helid);
		if (chronicVerify.verify() == false) {
			return "error";
		}
		getNowSqid();
		healthFile = healthFileService.getHealthFileById(helid);
		vclist = allChronicDiseaseService.getPeoPleAllIll(helid, sqid, stasus);
		return "searchOlder";
	}
	
	
	
	
	/**
	 * 添加糖尿病的方法
	 * 
	 * @return
	 */
	public String addDiabete() {
		getNowSqid();
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "addDiabete";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		VChronic vc = null;
		boolean y = false;
		vclist = allChronicDiseaseService.getPeoPleAllIll(helid, sqid, stasus);// sqid现在为默认的社区医院id，后期将从session里面拿到
		for (int a = 0; a < vclist.size(); a++) {// 次循环方法用于拿到老人所有慢病，并在下面判断
			vc = vclist.get(a);
			if (vc.getDiseaseName().equals("糖尿病")) {
				y = true;
			}
		}
		if (y == true) {
			return "addDiabete";
		}
		if (helid == 0 || diabete.getTypOfDia().equals("")
				|| diabete.getTypOfDia() == null
				|| chronicDisease.getFileDate() == null
				|| chronicDisease.getFileName() == null) {
			return "tnbno";
		}
		healthFile = healthFileService.getHealthFileById(helid);
		if (healthFile.getHealthFileType().equals(
				String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| healthFile.getHealthFileType().equals(
						String.valueOf(HealthFileCheck.siwang.getValue()))) {
			return "error";// 用于校验死亡或注销的人不能添加
		}
		chronicDisease.setTHealthFile(healthFile);
		int m = allChronicDiseaseService.saveChronicDisease(chronicDisease);
		TChronicDisease c = allChronicDiseaseService.getChronicDiseaseByID(m);// 拿到慢病总表实体
		diabete.setTChronicDisease(c);
		diabete.setBookrunner(chronicDisease.getDiseaseName());
		diabete.setFilingDate(c.getFileDate());
		int s = salaAssistService.saveGen_Con(generalCondition);
		TGeneralCondition g = salaAssistService.getGen_ConByZkId(s);
		diabete.setTGeneralCondition(g);
		int n = salaAssistService.saveLifeStyle(lifeStyle);
		TLifeStyle tl = salaAssistService.getLifeStyleByLifeId(n);
		diabete.setTLifeStyle(tl);
		int dia = salaAssistService.saveAuxi_Exam(auxiliaryExamination);
		TAuxiliaryExamination ta = salaAssistService.getAuxi_ExamByFzId(dia);
		diabete.setTAuxiliaryExamination(ta);
		diabetesService.saveDiabete(diabete);
		return "addDiabete";
	}
	/**
	 * 添加糖尿病的方法
	 * 从门诊接诊记录跳转到此处
	 * @return
	 */
	public String addDiabeteFromEmbeded() {
		getNowSqid();
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "addDiabeteFromEmbeded";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		VChronic vc = null;
		boolean y = false;
		vclist = allChronicDiseaseService.getPeoPleAllIll(helid, sqid, stasus);// sqid现在为默认的社区医院id，后期将从session里面拿到
		for (int a = 0; a < vclist.size(); a++) {// 次循环方法用于拿到老人所有慢病，并在下面判断
			vc = vclist.get(a);
			if (vc.getDiseaseName().equals("糖尿病")) {
				y = true;
			}
		}
		if (y == true) {
			return "addDiabeteFromEmbeded";
		}
		if (helid == 0 || diabete.getTypOfDia().equals("")
				|| diabete.getTypOfDia() == null
				|| chronicDisease.getFileDate() == null
				|| chronicDisease.getFileName() == null) {
			return "tnbno";
		}
		healthFile = healthFileService.getHealthFileById(helid);
		if (healthFile.getHealthFileType().equals(
				String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| healthFile.getHealthFileType().equals(
						String.valueOf(HealthFileCheck.siwang.getValue()))) {
			return "error";// 用于校验死亡或注销的人不能添加
		}
		chronicDisease.setTHealthFile(healthFile);
		int m = allChronicDiseaseService.saveChronicDisease(chronicDisease);
		TChronicDisease c = allChronicDiseaseService.getChronicDiseaseByID(m);// 拿到慢病总表实体
		diabete.setTChronicDisease(c);
		diabete.setBookrunner(chronicDisease.getDiseaseName());
		diabete.setFilingDate(c.getFileDate());
		int s = salaAssistService.saveGen_Con(generalCondition);
		TGeneralCondition g = salaAssistService.getGen_ConByZkId(s);
		diabete.setTGeneralCondition(g);
		int n = salaAssistService.saveLifeStyle(lifeStyle);
		TLifeStyle tl = salaAssistService.getLifeStyleByLifeId(n);
		diabete.setTLifeStyle(tl);
		int dia = salaAssistService.saveAuxi_Exam(auxiliaryExamination);
		TAuxiliaryExamination ta = salaAssistService.getAuxi_ExamByFzId(dia);
		diabete.setTAuxiliaryExamination(ta);
		diabetesService.saveDiabete(diabete);
		return "addDiabeteFromEmbeded";
	}
	/**
	 * 添加高血压的方法
	 * 
	 * @return
	 */
	public String addOneHighBlood() {
		getNowSqid();
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "addOneHighBlood";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		VChronic vc = null;
		boolean y = false;
		vclist = allChronicDiseaseService.getPeoPleAllIll(helid, sqid, stasus);
		for (int a = 0; a < vclist.size(); a++) {// 次循环方法用于拿到老人所有慢病，并在下面判断
			vc = vclist.get(a);
			if (vc.getDiseaseName().equals("高血压")) {
				y = true;
			}
		}
		if (y == true) {
			return "addOneHighBlood";
		}
		if (helid == 0 || chronicDisease.getFileName() == null
				|| chronicDisease.getFileDate() == null
				|| highBloodPressure.getHighBloodTypr().equals("")
				|| highBloodPressure.getHighBloodTypr() == null) {
			return "gxyno";
		}
		healthFile = healthFileService.getHealthFileById(helid);
		if (healthFile.getHealthFileType().equals(
				String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| healthFile.getHealthFileType().equals(
						String.valueOf(HealthFileCheck.siwang.getValue()))) {
			return "error";// 用于校验死亡或注销的人不能添加
		}
		chronicDisease.setTHealthFile(healthFile);
		int m = allChronicDiseaseService.saveChronicDisease(chronicDisease);
		TChronicDisease c = allChronicDiseaseService.getChronicDiseaseByID(m);
		highBloodPressure.setTChronicDisease(c);
		highBloodPressure.setBookrunner(chronicDisease.getDiseaseName());
		highBloodPressure.setFilingDate(c.getFileDate());
		int s = salaAssistService.saveGen_Con(generalCondition);
		TGeneralCondition g = salaAssistService.getGen_ConByZkId(s);
		highBloodPressure.setTGeneralCondition(g);
		int n = salaAssistService.saveLifeStyle(lifeStyle);
		TLifeStyle tl = salaAssistService.getLifeStyleByLifeId(n);
		highBloodPressure.setTLifeStyle(tl);
		highBloodPressureService.saveHighBlood(highBloodPressure);
		if (highBloodPressure.getHighBloodTypr() == null) {
			return "oneOneHighBlood";
		}
		return "addOneHighBlood";
	}

	/**
	 * 添加高血压的方法
	 * 从门诊随访跳转到此处
	 * @return
	 */
	public String addOneHighBloodFromEmbeded() {
		getNowSqid();
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "addOneHighBloodFromEmbeded";  //重定向回门诊随访页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		VChronic vc = null;
		boolean y = false;
		vclist = allChronicDiseaseService.getPeoPleAllIll(helid, sqid, stasus);
		for (int a = 0; a < vclist.size(); a++) {// 次循环方法用于拿到老人所有慢病，并在下面判断
			vc = vclist.get(a);
			if (vc.getDiseaseName().equals("高血压")) {
				y = true;
			}
		}
		if (y == true) {
			return "addOneHighBloodFromEmbeded";
		}
		if (helid == 0 || chronicDisease.getFileName() == null
				|| chronicDisease.getFileDate() == null
				|| highBloodPressure.getHighBloodTypr().equals("")
				|| highBloodPressure.getHighBloodTypr() == null) {
			return "gxyno";
		}
		healthFile = healthFileService.getHealthFileById(helid);
		if (healthFile.getHealthFileType().equals(
				String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| healthFile.getHealthFileType().equals(
						String.valueOf(HealthFileCheck.siwang.getValue()))) {
			return "error";// 用于校验死亡或注销的人不能添加
		}
		chronicDisease.setTHealthFile(healthFile);
		int m = allChronicDiseaseService.saveChronicDisease(chronicDisease);
		TChronicDisease c = allChronicDiseaseService.getChronicDiseaseByID(m);
		highBloodPressure.setTChronicDisease(c);
		highBloodPressure.setBookrunner(chronicDisease.getDiseaseName());
		highBloodPressure.setFilingDate(c.getFileDate());
		int s = salaAssistService.saveGen_Con(generalCondition);
		TGeneralCondition g = salaAssistService.getGen_ConByZkId(s);
		highBloodPressure.setTGeneralCondition(g);
		int n = salaAssistService.saveLifeStyle(lifeStyle);
		TLifeStyle tl = salaAssistService.getLifeStyleByLifeId(n);
		highBloodPressure.setTLifeStyle(tl);
		highBloodPressureService.saveHighBlood(highBloodPressure);
		if (highBloodPressure.getHighBloodTypr() == null) {
			return "oneOneHighBlood";
		}
		return "addOneHighBloodFromEmbeded";
	}
	
	/**
	 * 添加重性精神疾病的方法
	 * 
	 * @return
	 */
	public String addInsanity() {
		getNowSqid();
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "addInsanity";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		VChronic vc = null;
		boolean y = false;
		vclist = allChronicDiseaseService.getPeoPleAllIll(helid, sqid, stasus);
		for (int a = 0; a < vclist.size(); a++) {// 次循环方法用于拿到老人所有慢病，并在下面判断
			vc = vclist.get(a);
			if (vc.getDiseaseName().equals("重性精神疾病")) {
				y = true;
			}
		}
		if (y == true) {
			return "addInsanity";
		}
		if (helid == 0 || chronicDisease.getFileDate() == null
				|| chronicDisease.getFileName() == null
				|| inForm.getGuardianName().equals("")
				|| inForm.getGuardianPhone().equals("")
				|| inForm.getGuardianAddress().equals("")
				|| inForm.getNeighborhoodLinkman().equals("")
				|| inForm.getNeighborhoodPhone().equals("")) {
			return "jsbno";
		}
		healthFile = healthFileService.getHealthFileById(helid);
		if (healthFile.getHealthFileType().equals(
				String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| healthFile.getHealthFileType().equals(
						String.valueOf(HealthFileCheck.siwang.getValue()))) {
			return "error";// 用于校验死亡或注销的人不能添加
		}
		chronicDisease.setTHealthFile(healthFile);
		int m = allChronicDiseaseService.saveChronicDisease(chronicDisease);
		TChronicDisease c = allChronicDiseaseService.getChronicDiseaseByID(m);
		inForm.setTChronicDisease(c);
		inForm.setBookrunner(chronicDisease.getDiseaseName());
		inForm.setFilingDate(c.getFileDate());
		psychosisService.saveInsanityForm(inForm);
		return "addInsanity";
	}

	/**
	 * 添加冠心病方法
	 * 
	 * @return
	 */
	public String addCoronary() {
		getNowSqid();
		
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "addInsanity";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		
		VChronic vc = null;
		boolean y = false;
		vclist = allChronicDiseaseService.getPeoPleAllIll(helid, sqid, stasus);
		for (int a = 0; a < vclist.size(); a++) {// 次循环方法用于拿到老人所有慢病，并在下面判断
			vc = vclist.get(a);
			if (vc.getDiseaseName().equals("冠心病")) {
				y = true;
			}
		}
		if (y == true) {
			return "addInsanity";
		}
		healthFile = healthFileService.getHealthFileById(helid);
		coronaryDisease.setIvestingPerson(healthFile.getName());
		if (helid == 0 || chronicDisease.getFileDate() == null
				|| chronicDisease.getFileName() == null
				|| coronaryDisease.getType() == null
				|| coronaryDisease.getType().equals("")
				|| coronaryDisease.getIvestingPerson() == null
				|| coronaryDisease.getIvestingPerson().equals("")) {
			return "gxbno";
		}

		if (healthFile.getHealthFileType().equals(
				String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| healthFile.getHealthFileType().equals(
						String.valueOf(HealthFileCheck.siwang.getValue()))) {
			return "error";// 用于校验死亡或注销的人不能添加
		}
		chronicDisease.setTHealthFile(healthFile);
		int m = allChronicDiseaseService.saveChronicDisease(chronicDisease);
		TChronicDisease c = allChronicDiseaseService.getChronicDiseaseByID(m);
		coronaryDisease.setTChronicDisease(c);
		coronaryDisease.setBookrunner(chronicDisease.getDiseaseName());
		coronaryDisease.setFilingDate(c.getFileDate());
		coronaryHeartService.saveCornaryDisease(coronaryDisease);
		return "addCoronary";
	}

	/**
	 * 添加慢性支气管病方法
	 * 
	 * @return
	 */
	public String addBronchial() {
		getNowSqid();
		
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "addInsanity";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		
		VChronic vc = null;
		boolean y = false;
		vclist = allChronicDiseaseService.getPeoPleAllIll(helid, sqid, stasus);
		for (int a = 0; a < vclist.size(); a++) {// 次循环方法用于拿到老人所有慢病，并在下面判断
			vc = vclist.get(a);
			if (vc.getDiseaseName().equals("慢性支气管病")) {
				y = true;
			}
		}
		if (y == true) {
			return "addInsanity";
		}
		healthFile = healthFileService.getHealthFileById(helid);
		cbronchialDisease.setInvestigatedPerson(healthFile.getName());
		if (chronicDisease.getFileDate() == null
				|| chronicDisease.getFileName() == null || helid == 0
				|| cbronchialDisease.getIsAccompaniedWheezing() == null
				|| cbronchialDisease.getIsAccompaniedWheezing().equals("")
				|| cbronchialDisease.getMainCausesDisease() == null
				|| cbronchialDisease.getMainCausesDisease().equals("")
				|| cbronchialDisease.getCoughDegree() == null
				|| cbronchialDisease.getCoughDegree().equals("")
				|| cbronchialDisease.getCoughColor() == null
				|| cbronchialDisease.getCoughColor().equals("")
				|| cbronchialDisease.getInvestigatedPerson() == null
				|| cbronchialDisease.getInvestigatedPerson().equals("")) {
			return "zqgno";
		}

		if (healthFile.getHealthFileType().equals(
				String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| healthFile.getHealthFileType().equals(
						String.valueOf(HealthFileCheck.siwang.getValue()))) {
			return "error";// 用于校验死亡或注销的人不能添加
		}
		chronicDisease.setTHealthFile(healthFile);
		int m = allChronicDiseaseService.saveChronicDisease(chronicDisease);
		TChronicDisease c = allChronicDiseaseService.getChronicDiseaseByID(m);
		cbronchialDisease.setTChronicDisease(c);
		cbronchialDisease.setFileName(chronicDisease.getDiseaseName());
		cbronchialDisease.setFileDate(c.getFileDate());
		cBronchialService.saveCh_Br_Di(cbronchialDisease);
		return "addBronchial";
	}

	/**
	 * 添加肿瘤
	 * 
	 * @return
	 */
	public String addTumour() {
		getNowSqid();
		
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "addInsanity";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		
		VChronic vc = null;
		boolean y = false;
		vclist = allChronicDiseaseService.getPeoPleAllIll(helid, sqid, stasus);
		for (int a = 0; a < vclist.size(); a++) {// 次循环方法用于拿到老人所有慢病，并在下面判断
			vc = vclist.get(a);
			if (vc.getDiseaseName().equals("肿瘤")) {
				y = true;
			}
		}
		if (y == true) {
			return "addInsanity";
		}
		healthFile = healthFileService.getHealthFileById(helid);
		tumour.setSignatureDate(healthFile.getFileDate());
		tumour.setInvestigatedPerson(healthFile.getName());
		tumour.setReviewDate(healthFile.getFileDate());
		tumour.setReviewperson(healthFile.getName());
		if (chronicDisease.getFileDate() == null
				|| chronicDisease.getFileName() == null || helid == 0
				|| tumour.getPathologicalType() == null
				|| tumour.getPathologicalType().equals("")
				|| tumour.getConfirmationBasis() == null
				|| tumour.getConfirmationBasis().equals("")
				|| tumour.getDiagnosisPeriod() == null
				|| tumour.getDiagnosisPeriod().equals("")
				|| tumour.getSignatureDate() == null
				|| tumour.getSignatureDate().equals("")
				|| tumour.getReviewDate() == null
				|| tumour.getReviewDate().equals("")
				|| tumour.getInvestigatedPerson() == null
				|| tumour.getInvestigatedPerson().equals("")
				|| tumour.getReviewperson() == null
				|| tumour.getReviewperson().equals("")) {
			return "zlno";
		}
		if (healthFile.getHealthFileType().equals(
				String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| healthFile.getHealthFileType().equals(
						String.valueOf(HealthFileCheck.siwang.getValue()))) {
			return "error";// 用于校验死亡或注销的人不能添加
		}
		chronicDisease.setTHealthFile(healthFile);
		int m = allChronicDiseaseService.saveChronicDisease(chronicDisease);
		TChronicDisease c = allChronicDiseaseService.getChronicDiseaseByID(m);
		tumour.setTChronicDisease(c);
		tumour.setFileName(chronicDisease.getDiseaseName());
		tumour.setFileDate(c.getFileDate());
		tumourService.saveTumour(tumour);
		return "addTumour";
	}

	/**
	 * 添加心脑血管病
	 * 
	 * @return
	 */
	public String addHcvd() {
		getNowSqid();
		
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "addInsanity";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		
		VChronic vc = null;
		boolean y = false;
		vclist = allChronicDiseaseService.getPeoPleAllIll(helid, sqid, stasus);
		for (int a = 0; a < vclist.size(); a++) {// 次循环方法用于拿到老人所有慢病，并在下面判断
			vc = vclist.get(a);
			if (vc.getDiseaseName().equals("心脑血管病")) {
				y = true;
			}
		}
		if (y == true) {
			return "addInsanity";
		}
		healthFile = healthFileService.getHealthFileById(helid);
		hcvd.setInvestigatedPerson(healthFile.getName());
		if (chronicDisease.getFileDate() == null
				|| chronicDisease.getFileName() == null || helid == 0
				|| hcvd.getType() == null || hcvd.getType().equals("")) {
			return "xnno";
		}

		if (healthFile.getHealthFileType().equals(
				String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| healthFile.getHealthFileType().equals(
						String.valueOf(HealthFileCheck.siwang.getValue()))) {
			return "error";// 用于校验死亡或注销的人不能添加
		}
		chronicDisease.setTHealthFile(healthFile);
		int m = allChronicDiseaseService.saveChronicDisease(chronicDisease);
		TChronicDisease c = allChronicDiseaseService.getChronicDiseaseByID(m);
		hcvd.setTChronicDisease(c);
		hcvd.setBookrunner(chronicDisease.getDiseaseName());
		hcvd.setFilingDate(c.getFileDate());
		hAndCerebralService.saveHcvd(hcvd);
		return "addHcvd";
	}

	/**
	 * 添加残疾障碍
	 * 
	 * @return
	 */
	public String addDisability() {
		getNowSqid();
		
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "addInsanity";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		
		VChronic vc = null;
		boolean y = false;
		vclist = allChronicDiseaseService.getPeoPleAllIll(helid, sqid, stasus);
		for (int a = 0; a < vclist.size(); a++) {// 次循环方法用于拿到老人所有慢病，并在下面判断
			vc = vclist.get(a);
			if (vc.getDiseaseName().equals("残疾障碍")) {
				y = true;
			}
		}
		if (y == true) {
			return "addInsanity";
		}
		healthFile = healthFileService.getHealthFileById(helid);// 由于去掉了被调查人等内容
																// 但是数据库不能为空
																// 所以执行以下四个set
		disability.setSignatureDate(healthFile.getFileDate());
		disability.setRespondent(healthFile.getName());
		disability.setCheckDate(healthFile.getFileDate());
		disability.setChecker(healthFile.getName());
		if (chronicDisease.getFileDate() == null
				|| chronicDisease.getFileName() == null || helid == 0
				|| disability.getDiagnoseOrganization() == null
				|| disability.getDiagnoseOrganization().equals("")
				|| disability.getSignatureDate() == null
				|| disability.getSignatureDate().equals("")
				|| disability.getCheckDate() == null
				|| disability.getCheckDate().equals("")
				|| disability.getRespondent() == null
				|| disability.getRespondent().equals("")
				|| disability.getChecker() == null
				|| disability.getChecker().equals("")) {
			return "cjno";
		}
		// healthFile = healthFileService.getHealthFileById(helid);
		if (healthFile.getHealthFileType().equals(
				String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| healthFile.getHealthFileType().equals(
						String.valueOf(HealthFileCheck.siwang.getValue()))) {
			return "error";// 用于校验死亡或注销的人不能添加
		}
		chronicDisease.setTHealthFile(healthFile);
		int m = allChronicDiseaseService.saveChronicDisease(chronicDisease);
		TChronicDisease c = allChronicDiseaseService.getChronicDiseaseByID(m);
		disability.setTChronicDisease(c);
		disability.setFileName(chronicDisease.getDiseaseName());
		disability.setFileDate(c.getFileDate());
		diService.saveDi_Ob(disability);
		return "addDisability";
	}

	/**
	 * 选择真删假删方法,平台管理员和社区负责人真删,普通员工假删
	 * 
	 * @return
	 */
	public String chooseDelete() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group = (TCommunityHospitalGroup) session
				.getAttribute("communityHospitalGroup");
		if (group != null){
			return null;
		}
		// 从session里拿到当前登录用户的id
		int userId = GetSessionPerson.getPerson();
		if (userId > 0) {
			return "jiashan";
		} else {
			return "zhenshan";
		}
	}

	/**
	 * 假删方法
	 * 
	 * @return
	 */
	public String fdeleteChronic() {

		chronicDisease = allChronicDiseaseService.getChronicDiseaseByID(chid);
		chronicDisease.setStatus(9);
		allChronicDiseaseService.editChronicDisease(chronicDisease);
		System.out.println(chronicDisease.getStatus());
		return "fdeleteChronic";
	}

	/**
	 * 真删方法
	 * 
	 * @return
	 */
	public String deleteChronic() {

		chronicDisease = allChronicDiseaseService.getChronicDiseaseByID(chid);
		allChronicDiseaseService.deleteChronicDisease(chronicDisease);
		return "deleteChronic";
	}

	/**
	 * 跳转到展示方法
	 * 
	 * @return
	 */
	public String jumpShowChronic() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group = (TCommunityHospitalGroup) session
				.getAttribute("communityHospitalGroup");
		if (group != null){
			int gid = group.getGId();
			vhealthstaff = healthFileService.getGroup(helid);
			if(gid!=vhealthstaff.getGId()){
				return "error";
			}
		}else{
			chronicVerify.setChid(chid);
			chronicVerify.setHelid(helid);
			if (chronicVerify.verify() == false) {
				return "error";
			}
		}
		chronicDisease = allChronicDiseaseService.getChronicDiseaseByID(chid);
		dqname = chronicDisease.getDiseaseName();
		if (dqname.equals("高血压")) {
			showChronic();
			highBloodPressure = highBloodPressureService.getHighBloodById(chid);
			return "showHighBlood";
		} else if (dqname.equals("糖尿病")) {
			showChronic();
			diabete = diabetesService.getDiabeteById(chid);
			return "ctnb";
		} else if (dqname.equals("冠心病")) {
			showChronic();
			return "cgxb";
		} else if (dqname.equals("重性精神疾病")) {
			showChronic();
			return "cjsb";
		} else if (dqname.equals("慢性支气管病")) {
			showChronic();
			return "czqg";
		} else if (dqname.equals("肿瘤")) {
			showChronic();
			return "czl";
		} else if (dqname.equals("残疾障碍")) {
			showChronic();
			return "czcj";
		}
		showChronic();
		return "cxn";
	}

	/**
	 * 平台管理员或其他人用的查看方法公用封装(通过社区id和慢病id拿到慢病视图实体和集合)
	 */
	public void showChronic() {

		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group = (TCommunityHospitalGroup) session
				.getAttribute("communityHospitalGroup");
		if (group != null){
			vchronic = allChronicDiseaseService.getOneVcForSupper(chid);
			vclist = allChronicDiseaseService.getPeopleAllIllForSuper(helid,
					stasus);
		}else{
			// 从session里拿到当前登录用户的id
			int userId = GetSessionPerson.getPerson();
			getNowSqid();
			if (userId != 0) {// 如果不是平台管理员则执行以下方法
				vchronic = allChronicDiseaseService.getOneVc(sqid, chid);
				vclist = allChronicDiseaseService.getPeoPleAllIll(helid, sqid,
						stasus);
			} else {
				vchronic = allChronicDiseaseService.getOneVcForSupper(chid);
				vclist = allChronicDiseaseService.getPeopleAllIllForSuper(helid,
						stasus);
			}
		}
	}

	/**
	 * 跳转到编辑页方法
	 * 
	 * @return
	 */
	public String jumpEditChronic() {
		chronicVerify.setChid(chid);
		chronicVerify.setHelid(helid);
		if (chronicVerify.verify() == false) {
			return "error";
		}
		chronicDisease = allChronicDiseaseService.getChronicDiseaseByID(chid);
		dqname = chronicDisease.getDiseaseName();
		if (dqname.equals("高血压")) {
			highBloodMain();
			showChronic();
			highBloodPressure = highBloodPressureService.getHighBloodById(chid);
			return "bgxy";
		} else if (dqname.equals("糖尿病")) {
			diabeteMain();
			showChronic();
			diabete = diabetesService.getDiabeteById(chid);
			return "btnb";
		} else if (dqname.equals("冠心病")) {
			coronaryMain();
			showChronic();
			return "bgxb";
		} else if (dqname.equals("重性精神疾病")) {
			insanityformMain();
			showChronic();
			return "bjsb";
		} else if (dqname.equals("慢性支气管病")) {
			bronchialMain();
			showChronic();
			return "bzqg";
		} else if (dqname.equals("肿瘤")) {
			tumonrMain();
			showChronic();
			return "bzl";
		} else if (dqname.equals("残疾障碍")) {
			disabilityMain();
			showChronic();
			return "bzcj";
		}
		showChronic();
		hcvdMain();
		return "bxn";
	}

	/**
	 * 编辑冠心病方法
	 * 
	 * @return
	 */
	public String editCoronnary() {
		if (htype.equals(String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| htype.equals(String.valueOf(HealthFileCheck.siwang
						.getValue()))) {
			return "error";// 校验死亡或注销的人无法编辑暂时返回404
		}
		TCoronaryDisease tc = new TCoronaryDisease();
		tc = Reflex.getNewT(tc, coronaryDisease);
		tc.setTChronicDisease(chronicDisease);
		coronaryHeartService.editCornaryDisease(tc);
		return "editCoronnary";
	}

	/**
	 * 编辑慢性支气管病方法
	 * 
	 * @return
	 */
	public String editBronchial() {

		if (htype.equals(String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| htype.equals(String.valueOf(HealthFileCheck.siwang
						.getValue()))) {
			return "error";// 校验死亡或注销的人无法编辑暂时返回404
		}
		cbronchialDisease.setTChronicDisease(chronicDisease);
		cbronchialDisease.setChronicBronchialDiseaseId(zqgid);
		cBronchialService.editCh_Br_Di(cbronchialDisease);
		return "editBronchial";
	}

	/**
	 * 编辑糖尿病方法
	 * 
	 * @return
	 */
	public String editDiabete() {
		if (htype.equals(String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| htype.equals(String.valueOf(HealthFileCheck.siwang
						.getValue()))) {
			return "error";// 校验死亡或注销的人无法编辑暂时返回404
		}
		TAuxiliaryExamination ta = new TAuxiliaryExamination();
		ta = Reflex.getNewT(ta, auxiliaryExamination);
		salaAssistService.editAuxi_Exam(ta);

		TLifeStyle tl = new TLifeStyle();
		tl = Reflex.getNewT(tl, lifeStyle);
		salaAssistService.editLifeStyle(tl);

		TGeneralCondition tg = new TGeneralCondition();
		tg = Reflex.getNewT(tg, generalCondition);
		salaAssistService.editGen_Con(tg);

		TDiabete td = new TDiabete();
		td = Reflex.getNewT(td, diabete);

		td.setTAuxiliaryExamination(ta);
		td.setTChronicDisease(chronicDisease);
		td.setTGeneralCondition(tg);
		td.setTLifeStyle(tl);
		diabetesService.editDiabete(td);

		return "editDiabete";
	}

	/**
	 * 编辑重型精神疾病方法
	 * 
	 * @return
	 */
	public String editMental() {
		if (inForm.getGuardianName().equals("")
				|| inForm.getGuardianPhone().equals("")
				|| inForm.getGuardianAddress().equals("")
				|| inForm.getNeighborhoodLinkman().equals("")
				|| inForm.getNeighborhoodPhone().equals("")) {
			return "bjsbno";
		}
		if (htype.equals(String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| htype.equals(String.valueOf(HealthFileCheck.siwang
						.getValue()))) {
			return "error";// 校验死亡或注销的人无法编辑暂时返回404
		}
		inForm.setTChronicDisease(chronicDisease);
		inForm.setInsanityId(jsbid);
		psychosisService.editInsanityForm(inForm);
		return "editMental";
	}

	/**
	 * 编辑肿瘤方法
	 * 
	 * @return
	 */
	public String editTumour() {
		if (htype.equals(String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| htype.equals(String.valueOf(HealthFileCheck.siwang
						.getValue()))) {
			return "error";// 校验死亡或注销的人无法编辑暂时返回404
		}
		tumour.setTChronicDisease(chronicDisease);
		tumour.setTumourId(zlid);
		tumourService.editTumour(tumour);
		return "editTumour";
	}

	/**
	 * 编辑残疾障碍方法
	 * 
	 * @return
	 */
	public String editDisability() {
		if (htype.equals(String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| htype.equals(String.valueOf(HealthFileCheck.siwang
						.getValue()))) {
			return "error";// 校验死亡或注销的人无法编辑暂时返回404
		}
		disability.setTChronicDisease(chronicDisease);
		disability.setDisabilityObstacleId(cjid);
		diService.editDi_Ob(disability);
		return "editDisability";
	}

	/**
	 * 编辑高血压方法
	 * 
	 * @return
	 */
	public String editHighBlood() {
		if (htype.equals(String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| htype.equals(String.valueOf(HealthFileCheck.siwang
						.getValue()))) {
			return "error";// 校验死亡或注销的人无法编辑暂时返回404
		}
		TLifeStyle tl = new TLifeStyle();
		tl = Reflex.getNewT(tl, lifeStyle);
		salaAssistService.editLifeStyle(tl);

		TGeneralCondition tg = new TGeneralCondition();
		tg = Reflex.getNewT(tg, generalCondition);
		salaAssistService.editGen_Con(tg);

		THighBloodPressure th = new THighBloodPressure();
		th = Reflex.getNewT(th, highBloodPressure);
		// set外键
		th.setTChronicDisease(chronicDisease);
		th.setTGeneralCondition(tg);
		th.setTLifeStyle(tl);
		highBloodPressureService.editHighBlood(th);
		return "editHighBlood";
	}

	/**
	 * 编辑心脑血管方法
	 * 
	 * @return
	 */
	public String editHcvd() {
		if (htype.equals(String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| htype.equals(String.valueOf(HealthFileCheck.siwang
						.getValue()))) {
			return "error";// 校验死亡或注销的人无法编辑暂时返回404
		}
		hcvd.setTChronicDisease(chronicDisease);
		hcvd.setHvcdId(xnid);
		hAndCerebralService.editHcvd(hcvd);
		return "editHcvd";
	}

	/******************************************************************************************************************/

	public String getFileNum() {
		return fileNum;
	}

	public void setFileNum(String fileNum) {
		this.fileNum = fileNum;
	}

	public Page<VChronic> getPage() {
		return page;
	}

	public void setPage(Page<VChronic> page) {
		this.page = page;
	}

	public int getSqid() {
		return sqid;
	}

	public void setSqid(int sqid) {
		this.sqid = sqid;
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

	public String getIdcardOrfild() {
		return idcardOrfild;
	}

	public void setIdcardOrfild(String idcardOrfild) {
		this.idcardOrfild = idcardOrfild;
	}

	public THighBloodPressure getHighBloodPressure() {
		return highBloodPressure;
	}

	public void setHighBloodPressure(THighBloodPressure highBloodPressure) {
		this.highBloodPressure = highBloodPressure;
	}

	public TGeneralCondition getGeneralCondition() {
		return generalCondition;
	}

	public void setGeneralCondition(TGeneralCondition generalCondition) {
		this.generalCondition = generalCondition;
	}

	public TLifeStyle getLifeStyle() {
		return lifeStyle;
	}

	public void setLifeStyle(TLifeStyle lifeStyle) {
		this.lifeStyle = lifeStyle;
	}

	public TChronicDisease getChronicDisease() {
		return chronicDisease;
	}

	public void setChronicDisease(TChronicDisease chronicDisease) {
		this.chronicDisease = chronicDisease;
	}

	public int getChid() {
		return chid;
	}

	public void setChid(int chid) {
		this.chid = chid;
	}

	public int getHelid() {
		return helid;
	}

	public void setHelid(int helid) {
		this.helid = helid;
	}

	public THealthFile getHealthFile() {
		return healthFile;
	}

	public void setHealthFile(THealthFile healthFile) {
		this.healthFile = healthFile;
	}

	public int getIdOrfid() {
		return idOrfid;
	}

	public void setIdOrfid(int idOrfid) {
		this.idOrfid = idOrfid;
	}

	public String getTishi() {
		return tishi;
	}

	public void setTishi(String tishi) {
		this.tishi = tishi;
	}

	public TDiabete getDiabete() {
		return diabete;
	}

	public void setDiabete(TDiabete diabete) {
		this.diabete = diabete;
	}

	public TAuxiliaryExamination getAuxiliaryExamination() {
		return auxiliaryExamination;
	}

	public void setAuxiliaryExamination(
			TAuxiliaryExamination auxiliaryExamination) {
		this.auxiliaryExamination = auxiliaryExamination;
	}

	public List<VChronic> getVclist() {
		return vclist;
	}

	public void setVclist(List<VChronic> vclist) {
		this.vclist = vclist;
	}

	public TInsanityForm getInForm() {
		return inForm;
	}

	public void setInForm(TInsanityForm inForm) {
		this.inForm = inForm;
	}

	public TCoronaryDisease getCoronaryDisease() {
		return coronaryDisease;
	}

	public void setCoronaryDisease(TCoronaryDisease coronaryDisease) {
		this.coronaryDisease = coronaryDisease;
	}

	public TChronicBronchialDisease getCbronchialDisease() {
		return cbronchialDisease;
	}

	public void setCbronchialDisease(TChronicBronchialDisease cbronchialDisease) {
		this.cbronchialDisease = cbronchialDisease;
	}

	public TTumour getTumour() {
		return tumour;
	}

	public void setTumour(TTumour tumour) {
		this.tumour = tumour;
	}

	public THcvd getHcvd() {
		return hcvd;
	}

	public void setHcvd(THcvd hcvd) {
		this.hcvd = hcvd;
	}

	public TDisabilityObstacle getDisability() {
		return disability;
	}

	public void setDisability(TDisabilityObstacle disability) {
		this.disability = disability;
	}

	public VChronic getVchronic() {
		return vchronic;
	}

	public void setVchronic(VChronic vchronic) {
		this.vchronic = vchronic;
	}

	public String getDqname() {
		return dqname;
	}

	public void setDqname(String dqname) {
		this.dqname = dqname;
	}

	public int getZqgid() {
		return zqgid;
	}

	public void setZqgid(int zqgid) {
		this.zqgid = zqgid;
	}

	public int getZlid() {
		return zlid;
	}

	public void setZlid(int zlid) {
		this.zlid = zlid;
	}

	public int getCjid() {
		return cjid;
	}

	public void setCjid(int cjid) {
		this.cjid = cjid;
	}

	public int getXnid() {
		return xnid;
	}

	public void setXnid(int xnid) {
		this.xnid = xnid;
	}

	public int getJsbid() {
		return jsbid;
	}

	public void setJsbid(int jsbid) {
		this.jsbid = jsbid;
	}

	public TStaff getTuser() {
		return tuser;
	}

	public void setTuser(TStaff tuser) {
		this.tuser = tuser;
	}

	public TCommunityHospital getAdmin() {
		return admin;
	}

	public void setAdmin(TCommunityHospital admin) {
		this.admin = admin;
	}

	public SearchBean getSearchbean() {
		return searchbean;
	}

	public void setSearchbean(SearchBean searchbean) {
		this.searchbean = searchbean;
	}

	// /////////////////////////////////////////////////////////////////////////////////////////
	// 高血压档案
	private List<TMaintainableEntry> gxytype;// 高血压类型
	private List<TMaintainableEntry> gxybfz;// 高血压并发症
	private List<TMaintainableEntry> gxyglfj;// 高血压管理分级
	private List<TMaintainableEntry> dcsjlycxy;// 多长时间量一次血压
	private List<TMaintainableEntry> sffjyy;// 是否服降压药
	private List<TMaintainableEntry> bfhbglfyyy;// 不服或不规律服药原因
	private List<TMaintainableEntry> fywffzlgxy;// 非药物方法治疗高血压
	private List<TMaintainableEntry> jzzgxyhz;// 家族中高血压患者
	private List<TMaintainableEntry> ysxg;// 饮食习惯
	private List<TMaintainableEntry> tydlpl;// 体育锻炼频率
	private List<TMaintainableEntry> dlfs;// 锻炼方式
	private List<TMaintainableEntry> yjpl;// 饮酒频率
	private List<TMaintainableEntry> xyzk;// 吸烟状况
	private List<TMaintainableEntry> yjzl;// 饮酒种类
	private List<TMaintainableEntry> mqzyzz;// 高血压目前主要症状

	// 糖尿病档案
	private List<TMaintainableEntry> tnbc;// 糖尿病程
	private List<TMaintainableEntry> tnblx;// 糖尿病类型
	private List<TMaintainableEntry> tnbbfz;// 糖尿病并发症
	private List<TMaintainableEntry> tnbjws;// 糖尿病既往史
	private List<TMaintainableEntry> jtztnbhz;// 家庭中糖尿病患者
	private List<TMaintainableEntry> tnbmqzyzz;// 糖尿病目前主要症状

	// 重要精神病疾病档案
	private List<TMaintainableEntry> jwzyzz;// 既往主要症状
	private List<TMaintainableEntry> jwzlqkmz;// 既往治疗情况（门诊）
	private List<TMaintainableEntry> jwzlqkzy;// 既往治疗情况（住院）
	private List<TMaintainableEntry> zhyczlxg;// 最后一次治疗效果
	private List<TMaintainableEntry> hbdjtshdyx;// 患者对家庭社会的影响
	private List<TMaintainableEntry> gsqk;// 关锁情况
	// 新建心脑血管/冠心病档案
	private List<TMaintainableEntry> xnxgblx;// 心脑血管类型
	private List<TMaintainableEntry> wxyy;// 危险原因
	private List<TMaintainableEntry> qbxs;// 起病形式
	private List<TMaintainableEntry> xdt;// 心电图
	private List<TMaintainableEntry> ndt;// 脑电图
	private List<TMaintainableEntry> yyqk;// 用药情况
	private List<TMaintainableEntry> xx;// X线
	private List<TMaintainableEntry> ct;// CT
	private List<TMaintainableEntry> nxgzy;// 脑血管造影
	private List<TMaintainableEntry> gxblx;// 冠心病类型
	private List<TMaintainableEntry> bfz;// 并发症
	// 新建肿瘤档案
	private List<TMaintainableEntry> blxlx;// 病理学类型
	private List<TMaintainableEntry> qzyj;// 确诊依据
	private List<TMaintainableEntry> qzsqb;// 确诊时期
	private List<TMaintainableEntry> cjzlqk;// 曾经治疗情况
	private List<TMaintainableEntry> mqzlqk;// 目前治疗情况
	private List<TMaintainableEntry> cxsfjlyy;// 撤销随访记录原因
	private List<TMaintainableEntry> fxfs;// 发现方式
	private List<TMaintainableEntry> djfs;// 登记方式
	private List<TMaintainableEntry> xbx;// 细胞学
	private List<TMaintainableEntry> zzx;// 组织学
	private List<TMaintainableEntry> zzlx;// 组织类型
	private List<TMaintainableEntry> zlqk;// 治疗情况
	private List<TMaintainableEntry> fq;// 分期
	// 慢性支气管病档案
	private List<TMaintainableEntry> fbzyyy;// 发病主要原因
	private List<TMaintainableEntry> ksys;// 咳嗽颜色
	private List<TMaintainableEntry> zjqdpd;// 自觉气短评定
	private List<TMaintainableEntry> xzgnfj;// 心脏功能分级
	private List<TMaintainableEntry> kscd;// 咳嗽程度
	private List<TMaintainableEntry> xcg;// 血常规
	private List<TMaintainableEntry> ttphpy;// 痰涂片或培养
	private List<TMaintainableEntry> fgncd;// 肺功能测定
	private List<TMaintainableEntry> mxzqgbbfz;// 慢性支气管病并发症
	// 残疾障碍
	private List<TMaintainableEntry> cjyy;// 残疾原因
	private List<TMaintainableEntry> ztcfl;// 肢体残分类
	private List<TMaintainableEntry> kfjg;// 康复机构
	private List<TMaintainableEntry> bkfyy;// 不康复原因
	private List<TMaintainableEntry> jsbfj;// 精神病分级
	private List<TMaintainableEntry> tlcfj;// 听力残分级
	private List<TMaintainableEntry> zlcjfj;// 智力残疾分级
	private List<TMaintainableEntry> yycjfj;// 言语残疾分级
	private List<TMaintainableEntry> slcfj;// 视力残分级
	private List<TMaintainableEntry> ztcfj;// 肢体残分级

	// //////////////////////////////////////////////////////////////////////////

	public List<TMaintainableEntry> getZtcfj() {
		return ztcfj;
	}

	public List<TMaintainableEntry> getHbdjtshdyx() {
		return hbdjtshdyx;
	}

	public void setHbdjtshdyx(List<TMaintainableEntry> hbdjtshdyx) {
		this.hbdjtshdyx = hbdjtshdyx;
	}

	public List<TMaintainableEntry> getXnxgblx() {
		return xnxgblx;
	}

	public void setXnxgblx(List<TMaintainableEntry> xnxgblx) {
		this.xnxgblx = xnxgblx;
	}

	public void setZtcfj(List<TMaintainableEntry> ztcfj) {
		this.ztcfj = ztcfj;
	}

	public List<TMaintainableEntry> getSlcfj() {
		return slcfj;
	}

	public void setSlcfj(List<TMaintainableEntry> slcfj) {
		this.slcfj = slcfj;
	}

	public List<TMaintainableEntry> getYycjfj() {
		return yycjfj;
	}

	public void setYycjfj(List<TMaintainableEntry> yycjfj) {
		this.yycjfj = yycjfj;
	}

	public List<TMaintainableEntry> getZlcjfj() {
		return zlcjfj;
	}

	public void setZlcjfj(List<TMaintainableEntry> zlcjfj) {
		this.zlcjfj = zlcjfj;
	}

	public List<TMaintainableEntry> getTlcfj() {
		return tlcfj;
	}

	public void setTlcfj(List<TMaintainableEntry> tlcfj) {
		this.tlcfj = tlcfj;
	}

	public List<TMaintainableEntry> getJsbfj() {
		return jsbfj;
	}

	public void setJsbfj(List<TMaintainableEntry> jsbfj) {
		this.jsbfj = jsbfj;
	}

	public List<TMaintainableEntry> getBkfyy() {
		return bkfyy;
	}

	public void setBkfyy(List<TMaintainableEntry> bkfyy) {
		this.bkfyy = bkfyy;
	}

	public List<TMaintainableEntry> getKfjg() {
		return kfjg;
	}

	public void setKfjg(List<TMaintainableEntry> kfjg) {
		this.kfjg = kfjg;
	}

	public List<TMaintainableEntry> getZtcfl() {
		return ztcfl;
	}

	public void setZtcfl(List<TMaintainableEntry> ztcfl) {
		this.ztcfl = ztcfl;
	}

	public List<TMaintainableEntry> getCjyy() {
		return cjyy;
	}

	public void setCjyy(List<TMaintainableEntry> cjyy) {
		this.cjyy = cjyy;
	}

	public List<TMaintainableEntry> getMxzqgbbfz() {
		return mxzqgbbfz;
	}

	public void setMxzqgbbfz(List<TMaintainableEntry> mxzqgbbfz) {
		this.mxzqgbbfz = mxzqgbbfz;
	}

	public List<TMaintainableEntry> getFgncd() {
		return fgncd;
	}

	public void setFgncd(List<TMaintainableEntry> fgncd) {
		this.fgncd = fgncd;
	}

	public List<TMaintainableEntry> getTtphpy() {
		return ttphpy;
	}

	public void setTtphpy(List<TMaintainableEntry> ttphpy) {
		this.ttphpy = ttphpy;
	}

	public List<TMaintainableEntry> getXcg() {
		return xcg;
	}

	public void setXcg(List<TMaintainableEntry> xcg) {
		this.xcg = xcg;
	}

	public List<TMaintainableEntry> getKscd() {
		return kscd;
	}

	public void setKscd(List<TMaintainableEntry> kscd) {
		this.kscd = kscd;
	}

	public List<TMaintainableEntry> getXzgnfj() {
		return xzgnfj;
	}

	public void setXzgnfj(List<TMaintainableEntry> xzgnfj) {
		this.xzgnfj = xzgnfj;
	}

	public List<TMaintainableEntry> getZjqdpd() {
		return zjqdpd;
	}

	public void setZjqdpd(List<TMaintainableEntry> zjqdpd) {
		this.zjqdpd = zjqdpd;
	}

	public List<TMaintainableEntry> getKsys() {
		return ksys;
	}

	public void setKsys(List<TMaintainableEntry> ksys) {
		this.ksys = ksys;
	}

	public List<TMaintainableEntry> getFbzyyy() {
		return fbzyyy;
	}

	public void setFbzyyy(List<TMaintainableEntry> fbzyyy) {
		this.fbzyyy = fbzyyy;
	}

	public List<TMaintainableEntry> getFq() {
		return fq;
	}

	public void setFq(List<TMaintainableEntry> fq) {
		this.fq = fq;
	}

	public List<TMaintainableEntry> getZlqk() {
		return zlqk;
	}

	public void setZlqk(List<TMaintainableEntry> zlqk) {
		this.zlqk = zlqk;
	}

	public List<TMaintainableEntry> getZzx() {
		return zzx;
	}

	public void setZzx(List<TMaintainableEntry> zzx) {
		this.zzx = zzx;
	}

	public List<TMaintainableEntry> getZzlx() {
		return zzlx;
	}

	public void setZzlx(List<TMaintainableEntry> zzlx) {
		this.zzlx = zzlx;
	}

	public List<TMaintainableEntry> getXbx() {
		return xbx;
	}

	public void setXbx(List<TMaintainableEntry> xbx) {
		this.xbx = xbx;
	}

	public List<TMaintainableEntry> getDjfs() {
		return djfs;
	}

	public void setDjfs(List<TMaintainableEntry> djfs) {
		this.djfs = djfs;
	}

	public List<TMaintainableEntry> getFxfs() {
		return fxfs;
	}

	public void setFxfs(List<TMaintainableEntry> fxfs) {
		this.fxfs = fxfs;
	}

	public List<TMaintainableEntry> getCxsfjlyy() {
		return cxsfjlyy;
	}

	public void setCxsfjlyy(List<TMaintainableEntry> cxsfjlyy) {
		this.cxsfjlyy = cxsfjlyy;
	}

	public List<TMaintainableEntry> getCjzlqk() {
		return cjzlqk;
	}

	public void setCjzlqk(List<TMaintainableEntry> cjzlqk) {
		this.cjzlqk = cjzlqk;
	}

	public List<TMaintainableEntry> getMqzlqk() {
		return mqzlqk;
	}

	public void setMqzlqk(List<TMaintainableEntry> mqzlqk) {
		this.mqzlqk = mqzlqk;
	}

	public List<TMaintainableEntry> getQzsqb() {
		return qzsqb;
	}

	public void setQzsqb(List<TMaintainableEntry> qzsqb) {
		this.qzsqb = qzsqb;
	}

	public List<TMaintainableEntry> getQzyj() {
		return qzyj;
	}

	public void setQzyj(List<TMaintainableEntry> qzyj) {
		this.qzyj = qzyj;
	}

	public List<TMaintainableEntry> getBlxlx() {
		return blxlx;
	}

	public void setBlxlx(List<TMaintainableEntry> blxlx) {
		this.blxlx = blxlx;
	}

	public List<TMaintainableEntry> getBfz() {
		return bfz;
	}

	public void setBfz(List<TMaintainableEntry> bfz) {
		this.bfz = bfz;
	}

	public List<TMaintainableEntry> getGxblx() {
		return gxblx;
	}

	public void setGxblx(List<TMaintainableEntry> gxblx) {
		this.gxblx = gxblx;
	}

	public List<TMaintainableEntry> getNxgzy() {
		return nxgzy;
	}

	public void setNxgzy(List<TMaintainableEntry> nxgzy) {
		this.nxgzy = nxgzy;
	}

	public List<TMaintainableEntry> getCt() {
		return ct;
	}

	public void setCt(List<TMaintainableEntry> ct) {
		this.ct = ct;
	}

	public List<TMaintainableEntry> getXx() {
		return xx;
	}

	public void setXx(List<TMaintainableEntry> xx) {
		this.xx = xx;
	}

	public List<TMaintainableEntry> getYyqk() {
		return yyqk;
	}

	public void setYyqk(List<TMaintainableEntry> yyqk) {
		this.yyqk = yyqk;
	}

	public List<TMaintainableEntry> getXdt() {
		return xdt;
	}

	public void setXdt(List<TMaintainableEntry> xdt) {
		this.xdt = xdt;
	}

	public List<TMaintainableEntry> getNdt() {
		return ndt;
	}

	public void setNdt(List<TMaintainableEntry> ndt) {
		this.ndt = ndt;
	}

	public List<TMaintainableEntry> getQbxs() {
		return qbxs;
	}

	public void setQbxs(List<TMaintainableEntry> qbxs) {
		this.qbxs = qbxs;
	}

	public List<TMaintainableEntry> getWxyy() {
		return wxyy;
	}

	public void setWxyy(List<TMaintainableEntry> wxyy) {
		this.wxyy = wxyy;
	}

	public List<TMaintainableEntry> getXnxglx() {
		return xnxgblx;
	}

	public void setXnxglx(List<TMaintainableEntry> xnxglx) {
		this.xnxgblx = xnxglx;
	}

	public List<TMaintainableEntry> getGsqk() {
		return gsqk;
	}

	public void setGsqk(List<TMaintainableEntry> gsqk) {
		this.gsqk = gsqk;
	}

	public List<TMaintainableEntry> getZhyczlxg() {
		return zhyczlxg;
	}

	public void setZhyczlxg(List<TMaintainableEntry> zhyczlxg) {
		this.zhyczlxg = zhyczlxg;
	}

	public List<TMaintainableEntry> getJwzlqkzy() {
		return jwzlqkzy;
	}

	public void setJwzlqkzy(List<TMaintainableEntry> jwzlqkzy) {
		this.jwzlqkzy = jwzlqkzy;
	}

	public List<TMaintainableEntry> getJwzlqkmz() {
		return jwzlqkmz;
	}

	public void setJwzlqkmz(List<TMaintainableEntry> jwzlqkmz) {
		this.jwzlqkmz = jwzlqkmz;
	}

	public List<TMaintainableEntry> getJwzyzz() {
		return jwzyzz;
	}

	public void setJwzyzz(List<TMaintainableEntry> jwzyzz) {
		this.jwzyzz = jwzyzz;
	}

	public List<TMaintainableEntry> getTnbmqzyzz() {
		return tnbmqzyzz;
	}

	public void setTnbmqzyzz(List<TMaintainableEntry> tnbmqzyzz) {
		this.tnbmqzyzz = tnbmqzyzz;
	}

	public List<TMaintainableEntry> getJtztnbhz() {
		return jtztnbhz;
	}

	public void setJtztnbhz(List<TMaintainableEntry> jtztnbhz) {
		this.jtztnbhz = jtztnbhz;
	}

	public List<TMaintainableEntry> getTnbjws() {
		return tnbjws;
	}

	public void setTnbjws(List<TMaintainableEntry> tnbjws) {
		this.tnbjws = tnbjws;
	}

	public List<TMaintainableEntry> getTnbbfz() {
		return tnbbfz;
	}

	public void setTnbbfz(List<TMaintainableEntry> tnbbfz) {
		this.tnbbfz = tnbbfz;
	}

	public List<TMaintainableEntry> getTnblx() {
		return tnblx;
	}

	public void setTnblx(List<TMaintainableEntry> tnblx) {
		this.tnblx = tnblx;
	}

	public List<TMaintainableEntry> getTnbc() {
		return tnbc;
	}

	public void setTnbc(List<TMaintainableEntry> tnbc) {
		this.tnbc = tnbc;
	}

	public List<TMaintainableEntry> getMqzyzz() {
		return mqzyzz;
	}

	public void setMqzyzz(List<TMaintainableEntry> mqzyzz) {
		this.mqzyzz = mqzyzz;
	}

	public List<TMaintainableEntry> getYjzl() {
		return yjzl;
	}

	public void setYjzl(List<TMaintainableEntry> yjzl) {
		this.yjzl = yjzl;
	}

	public List<TMaintainableEntry> getXyzk() {
		return xyzk;
	}

	public void setXyzk(List<TMaintainableEntry> xyzk) {
		this.xyzk = xyzk;
	}

	public List<TMaintainableEntry> getYjpl() {
		return yjpl;
	}

	public void setYjpl(List<TMaintainableEntry> yjpl) {
		this.yjpl = yjpl;
	}

	public List<TMaintainableEntry> getDlfs() {
		return dlfs;
	}

	public void setDlfs(List<TMaintainableEntry> dlfs) {
		this.dlfs = dlfs;
	}

	public List<TMaintainableEntry> getTydlpl() {
		return tydlpl;
	}

	public void setTydlpl(List<TMaintainableEntry> tydlpl) {
		this.tydlpl = tydlpl;
	}

	public List<TMaintainableEntry> getYsxg() {
		return ysxg;
	}

	public void setYsxg(List<TMaintainableEntry> ysxg) {
		this.ysxg = ysxg;
	}

	public List<TMaintainableEntry> getJzzgxyhz() {
		return jzzgxyhz;
	}

	public void setJzzgxyhz(List<TMaintainableEntry> jzzgxyhz) {
		this.jzzgxyhz = jzzgxyhz;
	}

	public List<TMaintainableEntry> getFywffzlgxy() {
		return fywffzlgxy;
	}

	public void setFywffzlgxy(List<TMaintainableEntry> fywffzlgxy) {
		this.fywffzlgxy = fywffzlgxy;
	}

	public List<TMaintainableEntry> getBfhbglfyyy() {
		return bfhbglfyyy;
	}

	public void setBfhbglfyyy(List<TMaintainableEntry> bfhbglfyyy) {
		this.bfhbglfyyy = bfhbglfyyy;
	}

	public List<TMaintainableEntry> getSffjyy() {
		return sffjyy;
	}

	public void setSffjyy(List<TMaintainableEntry> sffjyy) {
		this.sffjyy = sffjyy;
	}

	public List<TMaintainableEntry> getDcsjlycxy() {
		return dcsjlycxy;
	}

	public void setDcsjlycxy(List<TMaintainableEntry> dcsjlycxy) {
		this.dcsjlycxy = dcsjlycxy;
	}

	public List<TMaintainableEntry> getGxytype() {
		return gxytype;
	}

	public void setGxytype(List<TMaintainableEntry> gxytype) {
		this.gxytype = gxytype;
	}

	public List<TMaintainableEntry> getGxybfz() {
		return gxybfz;
	}

	public void setGxybfz(List<TMaintainableEntry> gxybfz) {
		this.gxybfz = gxybfz;
	}

	public TOldStaffHos getOldstaffhos() {
		return oldstaffhos;
	}

	public void setOldstaffhos(TOldStaffHos oldstaffhos) {
		this.oldstaffhos = oldstaffhos;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public List<TStaff> getStaffs() {
		return staffs;
	}

	public void setStaffs(List<TStaff> staffs) {
		this.staffs = staffs;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public ArrayList<String> getList() {
		return list;
	}

	public void setList(ArrayList<String> list) {
		this.list = list;
	}

	public int[] getChlist() {
		return chlist;
	}

	public void setChlist(int[] chlist) {
		this.chlist = chlist;
	}

	/*
	 * public List<TStaff> getZrstaffs() { return zrstaffs; }
	 * 
	 * public void setZrstaffs(List<TStaff> zrstaffs) { this.zrstaffs =
	 * zrstaffs; }
	 */

	public List<VExam> getVelist() {
		return velist;
	}

	public void setVelist(List<VExam> velist) {
		this.velist = velist;
	}

	public Page<VExam> getEpage() {
		return epage;
	}

	public void setEpage(Page<VExam> epage) {
		this.epage = epage;
	}

	/*
	 * public static SearchBean getSearched() { return searched; }
	 * 
	 * public static void setSearched(SearchBean searched) {
	 * ShowOldChronicAction.searched = searched; }
	 */

	/*
	 * public SearchBean getSearch() { return search; }
	 * 
	 * public void setSearch(SearchBean search) { this.search = search; }
	 */

	public String getFlagsear() {
		return flagsear;
	}

	public void setFlagsear(String flagsear) {
		this.flagsear = flagsear;
	}

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

	public int getZhuangtai() {
		return zhuangtai;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setZhuangtai(int zhuangtai) {
		this.zhuangtai = zhuangtai;
	}

	public int getChrionFlag() {
		return chrionFlag;
	}

	public void setChrionFlag(int chrionFlag) {
		this.chrionFlag = chrionFlag;
	}

	public String getHtype() {
		return htype;
	}

	public void setHtype(String htype) {
		this.htype = htype;
	}

	public List<TCommunityHospital> getHospitals() {
		return hospitals;
	}

	public void setHospitals(List<TCommunityHospital> hospitals) {
		this.hospitals = hospitals;
	}

	/*
	 * public int getPtsqid() { return ptsqid; }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * public void setPtsqid(int ptsqid) { this.ptsqid = ptsqid; }
	 */

	

	public List<TMaintainableEntry> getGxyglfj() {
		return gxyglfj;
	}

	public int getIssq() {
		return issq;
	}

	public void setIssq(int issq) {
		this.issq = issq;
	}

	public void setGxyglfj(List<TMaintainableEntry> gxyglfj) {
		this.gxyglfj = gxyglfj;
	}

	public String getNulloldmessage() {
		return nulloldmessage;
	}

	public void setNulloldmessage(String nulloldmessage) {
		this.nulloldmessage = nulloldmessage;
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

	public Page<VChronic> getPagePlus() {
		return pagePlus;
	}

	public void setPagePlus(Page<VChronic> pagePlus) {
		this.pagePlus = pagePlus;
	}

	public VHealthStaff getVhealthstaff() {
		return vhealthstaff;
	}

	public void setVhealthstaff(VHealthStaff vhealthstaff) {
		this.vhealthstaff = vhealthstaff;
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

	public boolean isEmbeded() {
		return embeded;
	}

	public void setEmbeded(boolean embeded) {
		this.embeded = embeded;
	}
	
	// ///////////////////////////////////////////////////////////////////////////////////////////
}
