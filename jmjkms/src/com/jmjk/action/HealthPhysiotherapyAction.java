package com.jmjk.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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

import com.alibaba.fastjson.JSON;
import com.jmjk.action.base.BaseAction;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.THealthFile;
import com.jmjk.entity.TRecoveryOld;
import com.jmjk.entity.TRecoveryPlan;
import com.jmjk.entity.TRecoveryScheme;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.view.VChronic;
import com.jmjk.entity.view.VStaffHos;
import com.jmjk.enums.IS_DELETE;
import com.jmjk.enums.RecoveryPlanStatus;
import com.jmjk.export.StatisticalEcport;
import com.jmjk.export.recoveryPlanExport;
import com.jmjk.export.recoverySchemeExport;
import com.jmjk.export.statisticalAnalysisExport;
import com.jmjk.iservice.IStaffService;
import com.jmjk.service.AllChronicDiseaseService;
import com.jmjk.service.CommunityHospitalGroupService;
import com.jmjk.service.CommunityHospitalService;
import com.jmjk.service.HealthFileService;
import com.jmjk.service.RecoveryPlanService;
import com.jmjk.service.RecoverySchemeService;
import com.jmjk.utils.JxlExcel;
import com.jmjk.utils.Page;
import com.jmjk.utils.Resubmit;
import com.jmjk.utils.TokenProccessor;
import com.jmjk.utils.TypeConverter;
import com.opensymphony.xwork2.ActionContext;

@Component
@Scope("prototype")
@Action(value = "healthPhysiotherapyAction", results = {
		// 康复方案首页
		@Result(name = "success", location = "/jsp/healthPhysiotherapy/recoveryScheme.jsp"),
		// 康复方案查询
		@Result(name = "getSchemes", location = "/jsp/healthPhysiotherapy/recoveryScheme.jsp"),
		// 跳转到添加康复方案
		@Result(name = "jumpAddScheme", location = "/jsp/healthPhysiotherapy/addRecoveryScheme.jsp"),
		// 康复方案详情页
		@Result(name = "recoverySchemeDetails", location = "/jsp/healthPhysiotherapy/recoverySchemeDetails.jsp"),
		// 提交康复方案
		@Result(name = "addRecoveryScheme", location = "healthPhysiotherapyAction!getSchemes.action", type = "redirectAction", params = {
				"json", "${json}" }),
		@Result(name = "deleteScheme", location = "healthPhysiotherapyAction.action", type = "redirectAction", params = {
				"jsonString", "${jsonString}" }),
		@Result(name = "jumpAddPlan", location = "/jsp/healthPhysiotherapy/addRecoveryPlan.jsp"),
		@Result(name = "getAllPlan", location = "/jsp/healthPhysiotherapy/recoveryPlan.jsp"),
		@Result(name = "addPlan", location = "healthPhysiotherapyAction!getRecoveryPlan.action", type = "redirectAction", params = {
				"json", "${json}" }),
		// @Result(name = "jumpEditScheme", location =
		// "/jsp/healthPhysiotherapy/editRecoveryScheme.jsp"),
		// @Result(name = "editRecoveryScheme", location =
		// "healthPhysiotherapyAction.action", type = "redirectAction"),
		// @Result(name = "jumpEditPlan", location =
		// "/jsp/healthPhysiotherapy/editRecoveryPlan.jsp"),
		// @Result(name = "editRecoveryPlan", location =
		// "healthPhysiotherapyAction!getAllPlan.action", type =
		// "redirectAction"),
		@Result(name = "getRecoveryPlan", location = "/jsp/healthPhysiotherapy/recoveryPlan.jsp"),
		@Result(name = "getPlanById", location = "/jsp/healthPhysiotherapy/planDetail.jsp"),
		@Result(name = "deletePlanId", location = "healthPhysiotherapyAction!getAllPlan.action", type = "redirectAction", params = {
				"jsonString", "${jsonString}" }),

		@Result(name = "changePlanStatus", location = "healthPhysiotherapyAction!getAllPlan.action", type = "redirectAction"),
		@Result(name = "jumpAddExpertScheme", location = "/jsp/healthPhysiotherapy/addExpertRecoveryScheme.jsp"),
		@Result(name = "getExpertScheme", location = "/jsp/healthPhysiotherapy/expertRecoveryScheme.jsp"),
		@Result(name = "addExpertScheme", location = "healthPhysiotherapyAction!getExpertScheme.action", type = "redirectAction", params = {
				"json", "${json}" }),
		@Result(name = "deleteExpertSchemeById", location = "healthPhysiotherapyAction!getExpertScheme.action", type = "redirectAction", params = {
				"jsonString", "${jsonString}" }),
		// @Result(name = "editExpertRecoveryScheme",location =
		// "healthPhysiotherapyAction!getExpertScheme.action", type =
		// "redirectAction"),
		// @Result(name = "jumpEditExpertScheme", location =
		// "/jsp/healthPhysiotherapy/editRecoveryExpertScheme.jsp"),
		@Result(name = "expertSchemeDetails", location = "/jsp/healthPhysiotherapy/expertSchemeDetail.jsp"),
		@Result(name = "getRecovery", location = "/jsp/healthPhysiotherapy/statisticalAnalysis.jsp"),
		@Result(name = "getRocoveryById", location = "/jsp/healthPhysiotherapy/statisticalAnalysicDetail.jsp"),
		@Result(name = "deletestStisticalById", location = "healthPhysiotherapyAction!getRecovery.action", type = "redirectAction", params = {
				"json", "${json}" }),
		@Result(name = "getSearchRecovery", location = "/jsp/healthPhysiotherapy/statisticalAnalysis.jsp"),
		// 报错跳转到康复方案首页
		@Result(name = "error", location = "healthPhysiotherapyAction.action", type = "redirectAction"),
		// 报错跳转到康复计划首页
		@Result(name = "errorplan", location = "healthPhysiotherapyAction!getAllPlan.action", type = "redirectAction"),
		// 报错跳转到统计查询首页
		@Result(name = "errorStatistical", location = "healthPhysiotherapyAction!getRecovery.action", type = "redirectAction"),
		// 报错跳转到专家康复方案首页
		@Result(name = "errorExpertScheme", location = "healthPhysiotherapyAction!getExpertScheme.action", type = "redirectAction"),
		@Result(name = "test", type = "redirectAction", location = "healthPhysiotherapyAction.action"),
		@Result(name = "function", type = "redirectAction", location = "healthPhysiotherapyAction.action"),
		@Result(name = "exportAnalysis", type = "redirectAction", location = "healthPhysiotherapyAction.action"),
		@Result(name = "expertExport", location = "healthPhysiotherapyAction!getExpertScheme.action", type = "redirectAction")
		})
public class HealthPhysiotherapyAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	@Autowired
	private RecoverySchemeService recoverySchemeService;
	@Autowired
	private IStaffService staffService;
	@Autowired
	private AllChronicDiseaseService chronicDiseaseService;
	@Autowired
	private CommunityHospitalGroupService communityHospitalGroupService;
	@Autowired
	private RecoveryPlanService recoveryPlanService;
	@Autowired
	CommunityHospitalService communityHospitalService;
	@Autowired
	HealthFileService healthFileService;
	private TRecoveryScheme trecoveryScheme;
	private TRecoveryPlan plan;
	private List<TRecoveryScheme> schemeList;
	private List<VStaffHos> staffHosList;
	private List<VChronic> chroniclist;
	private List<TRecoveryPlan> planList;
	private List<TRecoveryOld> oldList;
	private TStaff staffRe;
	public int select;// 前台所选员工Id
	private int id;// 详情页和删除的id
	private int flag;

	private String pageHtml;// 分页
	private int cp = 1;// 当前页
	private String data;// 康复计划多级联动的疾病参数
	private String type;// 康复计划多级联动的方案类型
	private String json;// 添加康复计划时康复方案的联动
	private String jsonString;// 添加康复计划时老人的json串
	private int scheme;// 康复方案Id
	private List<Object> checkbox;// 老人复选框
	private String jString;// 康复计划编辑老人时用到的json串
	private String schemeString;// 编辑康复计划时用到的名称
	private String planName;// 查询康复计划时的条件
	private String planStatus;// 查询康复计划时的条件
	private String disease;// 所选疾病名称
	private String staffname;// 员工姓名
	private Date startTime;// 康复计划开始时间
	private Date endTime;// 康复计划结束时间
	private String jsons;
	private List<String> diseaseList = new ArrayList<String>();
	private String mySelect;
	private String st;
	private String et;
	private String HosId;
	private int[] ids;
	private Date timenow;
	private String df;
    //后台防止重复提交页面
	private String token;
	private int zhuanjia;
    private List<TCommunityHospital> tCommunityHospital;
	
	static TRecoveryScheme ceshi=new TRecoveryScheme();
	private String oldString;
	// ////////////////////////////////康复方案/////////////////////////////////////////////////
	/**
	 * 默认方法，显示所有康复方案
	 */
	public String execute() {
		
		//获取社区集团
        HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        int groupId=0;
        int HosId=0;
        if(group!=null)
        {
        	groupId=group.getGId();
        	/*tCommunityHospital=communityHospitalGroupService.getComHosListByGroup(group);
        	for(int i=0;i<tCommunityHospital.size();i++){
        		int id=tCommunityHospital.get(i).getCommunityHospitalId();*/
        		Page page = new Page();
        		page.setCurrentPage(cp);
        		page.setTotalNum(recoverySchemeService
        				.getAllRecoverySchemeCount(HosId, groupId));
        		schemeList = recoverySchemeService.getAllRecoveryScheme(HosId, groupId, page);
        		pageHtml = page.getPage("healthPhysiotherapyAction.action");// 查找该社区下所有的康复方案并显示
        		return SUCCESS;
        	}
        else{
        	
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
			if (tCommunityHospital.getIsHead() == 0) {
				comHosId = -1;// 管理员
			} else {
				comHosId = tCommunityHospital.getCommunityHospitalId();
			}

		}// 得到社区医院id

		Page page = new Page();
		page.setCurrentPage(cp);
		page.setTotalNum(recoverySchemeService
				.getAllRecoverySchemeCount(comHosId, groupId));
		schemeList = recoverySchemeService.getAllRecoveryScheme(comHosId,groupId,page);
		pageHtml = page.getPage("healthPhysiotherapyAction.action");// 查找该社区下所有的康复方案并显示
		return SUCCESS;
	}
        
	}

	/**
	 * 导出康复方案
	 * 
	 * @return
	 * @throws Exception
	 */
	public String test() throws Exception {
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
			if (tCommunityHospital.getIsHead() == 0) {
				comHosId = -1;// 管理员
			} else {
				comHosId = tCommunityHospital.getCommunityHospitalId();
			}

		}// 得到社区医院id

		// 判断flag --- 1导出全部 2导出本页
		if (flag == 1) { // 导出全部
			List<recoverySchemeExport> exportscheme = new ArrayList<recoverySchemeExport>();
			schemeList = recoverySchemeService.getAllRecoveryPlanForExport(comHosId);
			if (schemeList != null) {
				for (TRecoveryScheme list : schemeList) {
					recoverySchemeExport rsp = new recoverySchemeExport(list);
					exportscheme.add(rsp);
				}
			}else{
				return "error";
			}
			recoverySchemeExport rsp = new recoverySchemeExport();
			String[] titles = rsp.getTitles();
			JxlExcel jxl = new JxlExcel(titles);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("content-disposition", "attachment;filename="
					+ 1+ ".xls");
			ServletOutputStream output = response.getOutputStream();
			jxl.write(exportscheme, output);
			response.flushBuffer();
			return null;
		}
		if (flag == 2) { // 导出本页
			TCommunityHospital tCommunityHospitals = (TCommunityHospital) ActionContext
					.getContext().getSession().get("comHospital");
			TStaff tstaff1 = (TStaff) ActionContext.getContext().getSession()
					.get("tstaff");
			int comHosIds = 0;
			List<recoverySchemeExport> exportschemes = new ArrayList<recoverySchemeExport>();
			if (tstaff1 != null) {
				comHosIds = staffService.getCommHospitalByStaffId(tstaff1
						.getStaffId());
			}
			if (tCommunityHospitals != null) {
				if (tCommunityHospitals.getIsHead() == 0) {
					comHosIds = -1;// 管理员
				} else {
					comHosIds = tCommunityHospitals.getCommunityHospitalId();
				}

			}
			if(ids==null||ids.length==0){
				return "error";
			}
			for (int i = 0; i < ids.length; i++) {
				TRecoveryScheme trs = recoverySchemeService
						.getRecoverySchemeById(ids[i]);
				if (trs != null) {
					recoverySchemeExport rsp = new recoverySchemeExport(trs);
					exportschemes.add(rsp);
				}
			}

			recoverySchemeExport rsp = new recoverySchemeExport();
			String[] titles = rsp.getTitles();
			JxlExcel jxl = new JxlExcel(titles);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("content-disposition", "attachment;filename="+1+".xls");
			ServletOutputStream output = response.getOutputStream();
			jxl.write(exportschemes, output);
			response.flushBuffer();
			return null;
		}
		// 因为是一个请求一个相应,如果是一个下载请求,应该返回null,在用action 里返回json 数据时，不能return SUCCESS
		// ，必须return null 否则报此错误!
		return "test";
	}
	/**
	 * 导出专家康复方案
	 * 
	 * @return
	 * @throws Exception
	 */
	public String expertExport() throws Exception {
		// 判断flag --- 1导出全部 2导出本页
		if (flag == 1) { // 导出全部
			List<recoverySchemeExport> exportscheme = new ArrayList<recoverySchemeExport>();
			schemeList = recoverySchemeService.getAllRecoveryPlanForExport(-2);
			if (schemeList != null) {
				for (TRecoveryScheme list : schemeList) {
					recoverySchemeExport rsp = new recoverySchemeExport(list);
					exportscheme.add(rsp);
				}
			}else{
				return"errorExpertScheme";
			}
			recoverySchemeExport rsp = new recoverySchemeExport();
			String[] titles = rsp.getTitles();
			JxlExcel jxl = new JxlExcel(titles);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("content-disposition", "attachment;filename="
					+ 1+ ".xls");
			ServletOutputStream output = response.getOutputStream();
			jxl.write(exportscheme, output);
			response.flushBuffer();
			return null;
		}
		if (flag == 2) { // 导出本页
			List<recoverySchemeExport> exportschemes = new ArrayList<recoverySchemeExport>();
			if(ids==null||ids.length==0){
				return "errorExpertScheme";
			}
			for (int i = 0; i < ids.length; i++) {
				TRecoveryScheme trs = recoverySchemeService
						.getRecoverySchemeById(ids[i]);
				if (trs != null) {
					recoverySchemeExport rsp = new recoverySchemeExport(trs);
					exportschemes.add(rsp);
				}
			}

			recoverySchemeExport rsp = new recoverySchemeExport();
			String[] titles = rsp.getTitles();
			JxlExcel jxl = new JxlExcel(titles);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("content-disposition", "attachment;filename="+1+".xls");
			ServletOutputStream output = response.getOutputStream();
			jxl.write(exportschemes, output);
			response.flushBuffer();
			return null;
		}
		// 因为是一个请求一个相应,如果是一个下载请求,应该返回null,在用action 里返回json 数据时，不能return SUCCESS
		// ，必须return null 否则报此错误!
		return "expertExport";
	}
	/**
	 * 导出统计分析
	 * @return
	 * @throws Exception
	 */
	public String exportAnalysis() throws Exception {
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
			if (tCommunityHospital.getIsHead() == 0) {
				comHosId = -1;// 管理员
			} else {
				comHosId = tCommunityHospital.getCommunityHospitalId();
			}

		}// 得到社区医院id

		// 判断flag --- 1导出全部 2导出本页
		if (flag == 1) { // 导出全部
			List<statisticalAnalysisExport> planExport  = new ArrayList<statisticalAnalysisExport>();
			planList=recoveryPlanService.getAllRecoveryPlanForExport(comHosId);
			if(planList==null||planExport==null){
				return "errorStatistical";
			}
			if (planExport != null) {
				for (TRecoveryPlan list : planList) {
					statisticalAnalysisExport planExp = new statisticalAnalysisExport(list);
					planExport.add(planExp);
				}
			}
			List<StatisticalEcport> export=new ArrayList<StatisticalEcport>();
			for(statisticalAnalysisExport list:planExport)
			{
				StatisticalEcport ssEcport=new StatisticalEcport();
				ssEcport.setBeginTime(list.getBeginTime());
				ssEcport.setOld(list.getOld());
				ssEcport.setOverTime(list.getOverTime());
				ssEcport.setPlanName(list.getPlanName());
				ssEcport.setSchemeName(list.getSchemeName());
				ssEcport.setStatus(list.getStatus());
				export.add(ssEcport);
			}
			statisticalAnalysisExport planExp = new statisticalAnalysisExport();
			String[] titles = planExp.getTitles();
			JxlExcel jxl = new JxlExcel(titles);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("content-disposition", "attachment;filename="
					+ 1 + ".xls");
			ServletOutputStream output = response.getOutputStream();
			jxl.write(export, output);
			response.flushBuffer();
			return null;
		}
		if (flag == 2) { // 导出本页
			List<statisticalAnalysisExport> planExport11  = new ArrayList<statisticalAnalysisExport>();
			if(ids==null||ids.length==0){
					return"errorStatistical";
			}
			for (int i = 0; i < ids.length; i++) {
				TRecoveryPlan trp= recoveryPlanService.getRecoveryPlanById(ids[i]);
				if (trp != null) {
					statisticalAnalysisExport rpp = new statisticalAnalysisExport(trp);
					planExport11.add(rpp);
				}
			}
			List<StatisticalEcport> export=new ArrayList<StatisticalEcport>();
			for(statisticalAnalysisExport list:planExport11)
			{
				StatisticalEcport ssEcport=new StatisticalEcport();
				ssEcport.setBeginTime(list.getBeginTime());
				ssEcport.setOld(list.getOld());
				ssEcport.setOverTime(list.getOverTime());
				ssEcport.setPlanName(list.getPlanName());
				ssEcport.setSchemeName(list.getSchemeName());
				ssEcport.setStatus(list.getStatus());
				export.add(ssEcport);
			}
			statisticalAnalysisExport rpp = new statisticalAnalysisExport();
			String[] titles = rpp.getTitles();
			JxlExcel jxl = new JxlExcel(titles);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("content-disposition", "attachment;filename="
					+ 1 + ".xls");
			ServletOutputStream output = response.getOutputStream();
			jxl.write(export, output);
			response.flushBuffer();
			return null;
		}
		// 因为是一个请求一个相应,如果是一个下载请求,应该返回null,在用action 里返回json 数据时，不能return SUCCESS
		// ，必须return null 否则报此错误!
		return "exportAnalysis";
	}
	/**
	 * 导出康复计划
	 * @return
	 * @throws Exception
	 */
	public String function() throws Exception {
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
			if (tCommunityHospital.getIsHead() == 0) {
				comHosId = -1;// 管理员
			} else {
				comHosId = tCommunityHospital.getCommunityHospitalId();
			}

		}// 得到社区医院id

		// 判断flag --- 1导出全部  
		if (flag == 1) { // 导出全部
			List<recoveryPlanExport> planExport  = new ArrayList<recoveryPlanExport>();
			planList=recoveryPlanService.getAllRecoveryPlanForExport(comHosId);
			if(planExport==null||planList==null){
				return "errorplan";
			}
			if (planExport != null) {
				for (TRecoveryPlan list : planList) {
					recoveryPlanExport planExp = new recoveryPlanExport(list);
					planExport.add(planExp);
				}
			}
			recoveryPlanExport planExp = new recoveryPlanExport();
			String[] titles = planExp.getTitles();
			JxlExcel jxl = new JxlExcel(titles);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("content-disposition", "attachment;filename="
					+ 1 + ".xls");
			ServletOutputStream output = response.getOutputStream();
			jxl.write(planExport, output);
			response.flushBuffer();
			return null;
		}
		if (flag == 2) { // 导出本页
			
			List<recoveryPlanExport> planExport11  = new ArrayList<recoveryPlanExport>();
			if(ids==null||ids.length==0){
				return "errorplan";
			}
			for (int i = 0; i < ids.length; i++) {
				TRecoveryPlan trp= recoveryPlanService.getRecoveryPlanById(ids[i]);
				if (trp != null) {
					recoveryPlanExport rpp = new recoveryPlanExport(trp);
					planExport11.add(rpp);
				}
			}

			recoveryPlanExport rpp = new recoveryPlanExport();
			String[] titles = rpp.getTitles();
			JxlExcel jxl = new JxlExcel(titles);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("content-disposition", "attachment;filename="
					+ 1 + ".xls");
			ServletOutputStream output = response.getOutputStream();
			jxl.write(planExport11, output);
			response.flushBuffer();
			return null;
		}
		// 因为是一个请求一个相应,如果是一个下载请求,应该返回null,在用action 里返回json 数据时，不能return SUCCESS
		// ，必须return null 否则报此错误!
		return "function";
	}
	/**
	 * 跳转到添加康复方案页面
	 * 
	 * @return
	 */
	public String jumpAddScheme() {
		// 从session中获取社区医院Id
		TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext
				.getContext().getSession().get("comHospital");
		TStaff tstaff = (TStaff) ActionContext.getContext().getSession()
				.get("tstaff");
		//后台防止重复提交
		token = TokenProccessor.getInstance().makeToken();//创建令牌
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)

		
		int comHosId = 0;
		if (tstaff != null) {
			comHosId = staffService.getCommHospitalByStaffId(tstaff
					.getStaffId());
		}
		if (tCommunityHospital != null) {
			comHosId = tCommunityHospital.getCommunityHospitalId();
		}
		diseaseList.add("残疾障碍");
		diseaseList.add("高血压");
		diseaseList.add("糖尿病");
		diseaseList.add("重性精神疾病");
		diseaseList.add("冠心病");
		diseaseList.add("心脑血管病");
		diseaseList.add("肿瘤");
		diseaseList.add("慢性支气管病");
		staffHosList = staffService.getAllStaffByCommunityHospitalId(comHosId);// 得到当前社区下所有员工
		if (tstaff != null) {
			if (healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())) {// 判断员工是否为责任医生，若是，则只能看到所对应的老人
						staffHosList=null;
						staffRe=tstaff;
			}
		}
		return "jumpAddScheme";
	}

	/**
	 * 添加康复方案，并跳到康复方案首页
	 * 
	 * @return
	 */
	public String addRecoveryScheme() {
		try {
			 
			  HttpSession session = ServletActionContext.getRequest().getSession();
	          TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
	          if(group!=null){
	        	int comHosId = 0;
	  			trecoveryScheme.setGroupId(group.getGId());
	  			trecoveryScheme.setCommunityHospitalId(comHosId);
	  			trecoveryScheme.setIdDelete(IS_DELETE.no_Delete.getValue());
	  			if (trecoveryScheme.getSchemeName().equals("")) {
	  				throw new Exception();
	  			}
	  			trecoveryScheme.setNote(group.getGroupName());
	  			trecoveryScheme.setConstituteTime(TypeConverter.date2Timestamp(new Date()));
	  			recoverySchemeService.addRecoveryScheme(trecoveryScheme);
	  			// 跳转到查询页面的条件
	  			json = "{schemeName:'" + trecoveryScheme.getSchemeName()
	  					+ "',type:'" + trecoveryScheme.getType() + "'}";
	  			return "addRecoveryScheme";
	        	 
	         }
	          else{
	        	  int comHosId = 0;
	        	  int groupId=0;
	        	
	        	TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext
	  					.getContext().getSession().get("comHospital");
	  			TStaff tstaff = (TStaff) ActionContext.getContext().getSession()
	  					.get("tstaff");
	  		
	  		if (tstaff != null) {
	  			
	  			int staffId=tstaff.getStaffId();
	  			comHosId=staffService.getCommHospitalByStaffId(staffId);
	  			groupId=communityHospitalService.getCommunityHospitalById(comHosId).getTCommunityHospitalGroup().getGId();
	  			
	  			}
	  		if (tCommunityHospital != null) {
	  				comHosId = tCommunityHospital.getCommunityHospitalId();
	  				groupId=communityHospitalService.getCommunityHospitalById(comHosId).getTCommunityHospitalGroup().getGId();
		  			
	  			}
	  		if (tstaff != null&&healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())) {
	  				// 判断员工是否为责任医生，若是，则只能看到所对应的老人
	  					TStaff staff = new TStaff(tstaff.getStaffId());
	  					trecoveryScheme.setTStaff(staff);
	  				
	  			}
	  			else{
	  				TStaff staff =new TStaff(select);// 用构造方法生成一个员工对象
	  				trecoveryScheme.setTStaff(staff);
	  			}
	  			trecoveryScheme.setGroupId(groupId);
	  			trecoveryScheme.setCommunityHospitalId(comHosId);
	  			trecoveryScheme.setIdDelete(IS_DELETE.no_Delete.getValue());
	  			if (trecoveryScheme.getSchemeName().equals("")) {
	  				throw new Exception();
	  			}
	  			/*if (recoverySchemeService.checkSchemeName(comHosId, trecoveryScheme.getSchemeName()) > 0)
	  			{
	  				throw new Exception();
	  			}*/
	  			trecoveryScheme.setNote(communityHospitalService
						.getCommunityHospitalById(comHosId).getName());
	  			trecoveryScheme.setConstituteTime(TypeConverter.date2Timestamp(new Date()));
	  			recoverySchemeService.addRecoveryScheme(trecoveryScheme);
	  			// 跳转到查询页面的条件
	  			json = "{schemeName:'" + trecoveryScheme.getSchemeName()
	  					+ "',type:'" + trecoveryScheme.getType() + "'}";
	  			return "addRecoveryScheme";
	          }
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		// 保存出错时重新跳转到添加页面
		TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext
				.getContext().getSession().get("comHospital");
		TStaff tstaff = (TStaff) ActionContext.getContext().getSession()
				.get("tstaff");
		
		
		//后台防止重复提交
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "success";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		

		
		int comHosId = 0;
		if (tstaff != null) {
			comHosId = staffService.getCommHospitalByStaffId(tstaff
					.getStaffId());
		}
		if (tCommunityHospital != null) {
			comHosId = tCommunityHospital.getCommunityHospitalId();
		}
		diseaseList.add("残疾障碍");
		diseaseList.add("高血压");
		diseaseList.add("糖尿病");
		diseaseList.add("重性精神疾病");
		diseaseList.add("冠心病");
		diseaseList.add("心脑血管病");
		diseaseList.add("肿瘤");
		diseaseList.add("慢性支气管病");
		staffHosList = staffService.getAllStaffByCommunityHospitalId(comHosId);
		if (tstaff != null) {
			if (healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())) {// 判断员工是否为责任医生，若是，则只能看到所对应的老人
						staffHosList=null;
						staffRe=tstaff;
			}
		}
		return "jumpAddScheme";
	}

	/**
	 * 检查当前社区下是否重名
	 * 
	 * @return
	 */
	public String checkScheme() {
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
			if (tCommunityHospital.getIsHead() == 0) {
				comHosId = -1;// 管理员
			} else {
				comHosId = tCommunityHospital.getCommunityHospitalId();
			}
		}
	/*	if (recoverySchemeService.checkSchemeName(comHosId, schemeString) > 0)// 如果查出的数据大于零则重名
		{
			json = "康复方案重名";// 前台判断如果json不为空就弹框
		} else {
			json = "";
		}*/
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(
						org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		try {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据康复方案Id删除康复方案
	 * 
	 * @return
	 */
	public String deleteSchemeById() {
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
		if (recoveryPlanService.checkRecoveryScheme(id)) {
			jsonString = "";
		} else {
			jsonString = " ";
		}
		if (recoverySchemeService.getRecoverySchemeById(id).getType()
				.equals("推荐方案")) {

			return "deleteScheme";
		}
		if (recoverySchemeService.getRecoverySchemeById(id)
				.getCommunityHospitalId() == comHosId
				&& recoveryPlanService.checkRecoveryScheme(id)) {
			recoverySchemeService.deleteRecoverySchemeById(id);
			return "deleteScheme";
		} else {
			return "deleteScheme";
		}

	}

	/*	*//**
	 * 跳转到编辑康复方案页面
	 * 
	 * @return
	 */
	/*
	 * public String jumpEditScheme() { try { // 从session中获取社区医院Id
	 * TCommunityHospital tCommunityHospital = (TCommunityHospital)
	 * ActionContext .getContext().getSession().get("comHospital"); TStaff
	 * tstaff = (TStaff) ActionContext.getContext().getSession() .get("tstaff");
	 * int comHosId=0; if(tstaff!=null) {
	 * comHosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId()); }
	 * if(tCommunityHospital!=null) { comHosId =
	 * tCommunityHospital.getCommunityHospitalId(); } trecoveryScheme =
	 * recoverySchemeService.getRecoverySchemeById(id); staffHosList =
	 * staffService.getAllStaffByCommunityHospitalId(comHosId); return
	 * "jumpEditScheme"; } catch (Exception e) { // TODO: handle exception
	 * return "error"; } }
	 *//**
	 * 编辑康复方案
	 * 
	 * @return
	 */
	/*
	 * public String editRecoveryScheme() { try { // 从session中获取社区医院Id
	 * TCommunityHospital tCommunityHospital = (TCommunityHospital)
	 * ActionContext .getContext().getSession().get("comHospital"); TStaff
	 * tstaff = (TStaff) ActionContext.getContext().getSession() .get("tstaff");
	 * int comHosId=0; if(tstaff!=null) {
	 * comHosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId()); }
	 * if(tCommunityHospital!=null) { comHosId =
	 * tCommunityHospital.getCommunityHospitalId(); }
	 * 
	 * TStaff staff = new TStaff(select); trecoveryScheme.setTStaff(staff);
	 * trecoveryScheme.setRecoverySchemeId(trecoveryScheme
	 * .getRecoverySchemeId());
	 * trecoveryScheme.setCommunityHospitalId(comHosId); int
	 * hos=recoverySchemeService
	 * .getRecoverySchemeById(trecoveryScheme.getRecoverySchemeId
	 * ()).getCommunityHospitalId(); if(comHosId!=hos) { return "error"; }
	 * recoverySchemeService.updateRecoveryScheme(trecoveryScheme); return
	 * "editRecoveryScheme"; } catch (Exception e) { // TODO: handle exception }
	 * // 从session中获取社区医院Id TCommunityHospital tCommunityHospital =
	 * (TCommunityHospital) ActionContext
	 * .getContext().getSession().get("comHospital"); TStaff tstaff = (TStaff)
	 * ActionContext.getContext().getSession() .get("tstaff"); int comHosId=0;
	 * if(tstaff!=null) {
	 * comHosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId()); }
	 * if(tCommunityHospital!=null) { comHosId =
	 * tCommunityHospital.getCommunityHospitalId(); } trecoveryScheme =
	 * recoverySchemeService
	 * .getRecoverySchemeById(trecoveryScheme.getRecoverySchemeId());
	 * staffHosList = staffService.getAllStaffByCommunityHospitalId(comHosId);
	 * 
	 * return "jumpEditScheme"; }
	 */

	/**
	 * 康复方案首页的查询
	 * 
	 * @return
	 */
	public String getSchemes() {
	
		
			
			//获取社区集团
	        HttpSession session = ServletActionContext.getRequest().getSession();
	        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
	        int comHosId=0;
	        int groupId=0;
 	        if(group!=null)
	        {
	        	groupId = group.getGId();
	        	if (json != null) {
					trecoveryScheme = JSON.parseObject(json, TRecoveryScheme.class);
				}
				if (trecoveryScheme == null) {
					trecoveryScheme = new TRecoveryScheme();
					trecoveryScheme.setTStaff(new TStaff());
				} else {
					if (trecoveryScheme.getTStaff() == null) {
						if (staffname != null && staffname != "") // 查询条件的指定人姓名
						{
							trecoveryScheme.setTStaff(new TStaff(staffname));
						} else {
							trecoveryScheme.setTStaff(new TStaff());
							trecoveryScheme.getTStaff().setName("");
						}
					}
				}
				trecoveryScheme.setGroupId(groupId); 
				Page page = new Page();
				
				page.setTotalNum(recoverySchemeService.getRecoverySchemeCountBySearch(trecoveryScheme,groupId));
				
				schemeList = recoverySchemeService.getRecoveryScheme(
						trecoveryScheme, groupId,page);
				pageHtml = page
						.getPage("entity");
				// <%=basePath
				// %>healthPhysiotherapyAction!changePlanStatus.action?json={recoveryPlanId:'${list.recoveryPlanId}'}
				return "getSchemes";
	        }
	        else{
	        	// 从session中获取社区医院Id
				TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext
						.getContext().getSession().get("comHospital");
				TStaff tstaff = (TStaff) ActionContext.getContext().getSession()
						.get("tstaff");
				
				if (tstaff != null) {
					comHosId = staffService.getCommHospitalByStaffId(tstaff
							.getStaffId());
				}
				if (tCommunityHospital != null) {
					if (tCommunityHospital.getIsHead() == 0) {
						comHosId = -1;// 管理员
					} else {
						comHosId = tCommunityHospital.getCommunityHospitalId();
					}
				}
				
				
				
				if (json != null) {
					trecoveryScheme = JSON.parseObject(json, TRecoveryScheme.class);
				}
				if (trecoveryScheme == null) {
					trecoveryScheme = new TRecoveryScheme();
					trecoveryScheme.setTStaff(new TStaff());
				} else {
					if (trecoveryScheme.getTStaff() == null) {
						if (staffname != null && staffname != "") // 查询条件的指定人姓名
						{
							trecoveryScheme.setTStaff(new TStaff(staffname));
						} else {
							trecoveryScheme.setTStaff(new TStaff());
							trecoveryScheme.getTStaff().setName("");
						}
					}
				}
				trecoveryScheme.setCommunityHospitalId(comHosId);
				Page page = new Page();
				page.setCurrentPage(cp);                	
				page.setTotalNum(recoverySchemeService
				 		.getRecoverySchemeCountBySearch(trecoveryScheme,groupId));
				
 				schemeList = recoverySchemeService.getExpertRecoveryScheme(
						trecoveryScheme,groupId, page);
				pageHtml = page
						.getPage("entity");
				// <%=basePath
				// %>healthPhysiotherapyAction!changePlanStatus.action?json={recoveryPlanId:'${list.recoveryPlanId}'}
				return "getSchemes";
	        }
			
		}
	


	/**
	 * 康复方案详情页
	 * 
	 * @return
	 */
	public String recoverySchemeDetails() {
		try {
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
				if (tCommunityHospital.getIsHead() == 0) {
					comHosId = -1;// 管理员
				} else {
					comHosId = tCommunityHospital.getCommunityHospitalId();
				}
			}
			int hos = recoverySchemeService.getRecoverySchemeById(id)
					.getCommunityHospitalId();
			if (comHosId != hos&&!recoverySchemeService.getRecoverySchemeById(id).getType().equals("推荐方案") && comHosId != -1) {
				return "error";
			}
			trecoveryScheme = recoverySchemeService.getRecoverySchemeById(id);
			return "recoverySchemeDetails";
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}

	}

	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * 
	 * 康复计划
	 */
	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 得到该社区下所有的康复计划
	 * 
	 * @return
	 */
	public String getAllPlan() {
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
			if (tCommunityHospital.getIsHead() == 0) {
				comHosId = -1;// 管理员
			} else {
				comHosId = tCommunityHospital.getCommunityHospitalId();
			}
		}
		Page page = new Page();
		page.setCurrentPage(cp);
		int flag = -1;
		if(tstaff!=null&&healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())){
			flag=tstaff.getStaffId();
		}
		page.setTotalNum(recoveryPlanService
				.getAllRecoveryPlanCountByHosId(comHosId,flag));
		planList = recoveryPlanService
				.getAllRecoveryPlanByHosId(page, comHosId,flag);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String timenow=df.format(new Date());
	
		if (planList != null) {
		
			for(TRecoveryPlan list:planList)
		{
			if(timenow.compareTo(list.getOverTime().toString())>0){
				list.setStatus(RecoveryPlanStatus.STARRED.getValue());
				recoveryPlanService.updateRecoveryPlan(list);
			}
			List<TRecoveryOld> olds = recoveryPlanService.getRecoveryOldById(list.getRecoveryPlanId());
			String name = "";
			if (olds != null) {
			for (TRecoveryOld ll : olds)
			{
				name+=ll.getTHealthFile().getName()+",";
			}
			if(!name.equals(""))
			{
				list.setOne(name.substring(0, name.length()-1));
			}
		}}
		}
		pageHtml = page.getPage("healthPhysiotherapyAction!getAllPlan.action");
		return "getAllPlan";

	}

	/**
	 * 跳到添加康复计划页
	 * 
	 * @return
	 */
	public String jumpAddPlan() {
		// 从session中获取社区医院Id
		TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext
				.getContext().getSession().get("comHospital");
		TStaff tstaff = (TStaff) ActionContext.getContext().getSession()
				.get("tstaff");
		
		//后台防止重复提交
				token = TokenProccessor.getInstance().makeToken();//创建令牌
				HttpServletRequest request=ServletActionContext.getRequest();
				request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)

		
		int comHosId = 0;
		if (tstaff != null) {
			comHosId = staffService.getCommHospitalByStaffId(tstaff
					.getStaffId());
		}
		if (tCommunityHospital != null) {
			comHosId = tCommunityHospital.getCommunityHospitalId();
		}
		diseaseList.add("残疾障碍");
		diseaseList.add("高血压");
		diseaseList.add("糖尿病");
		diseaseList.add("重性精神疾病");
		diseaseList.add("冠心病");
		diseaseList.add("心脑血管病");
		diseaseList.add("肿瘤");
		diseaseList.add("慢性支气管病");
		jsonString = "0";
		staffHosList = staffService.getAllStaffByCommunityHospitalId(comHosId);
		if (tstaff != null) {
			if (healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())) {// 判断员工是否为责任医生，若是，则只能看到所对应的老人
						staffHosList=null;
						staffRe=tstaff;
			}
		}
		return "jumpAddPlan";
	}

	/**
	 * 添加康复计划
	 * 
	 * @return
	 */
	public String addPlan() {
		try {
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
			if (recoveryPlanService.checkName(comHosId, plan.getPlanName()) > 0)
			{
				throw new Exception();
			}
			
			//后台防止重复提交
			HttpServletRequest request=ServletActionContext.getRequest();
			boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
			if(b==true){
				return "success" ;//重定向回首页
			}
			request.getSession().removeAttribute("token");//移除session中的token
			
			
			
			trecoveryScheme = recoverySchemeService
					.getRecoverySchemeById(scheme);
			plan.setTRecoveryScheme(trecoveryScheme);
			plan.setCommunityHospitalId(comHosId);
			plan.setStatus(RecoveryPlanStatus.STARTING.getValue());
			if (tstaff != null&&healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())) {
				// 判断员工是否为责任医生，若是，则只能看到所对应的老人
					TStaff staff = new TStaff(tstaff.getStaffId());
					plan.setTStaff(staff);
				
			}
			else{
				TStaff staff = new TStaff(select);
				plan.setTStaff(staff);
			}
			
			plan.setIdDelete(IS_DELETE.no_Delete.getValue());
			if(checkbox==null)
			{
				oldString=" ";
				throw new Exception();
			}
			Date date = new Date();
			plan.setConstituteTime(TypeConverter.date2Timestamp(date));
			int planId = recoveryPlanService.addRecoveryPlan(plan);
			List<TRecoveryOld> recoveryOldList = new ArrayList<TRecoveryOld>();
			for (Object list : checkbox) {
					THealthFile healthFile = new THealthFile(
							Integer.parseInt(String.valueOf(list)));
					TRecoveryPlan recoveryPlan = new TRecoveryPlan(planId);
					TRecoveryOld recoveryOld = new TRecoveryOld();
					recoveryOld.setTRecoveryPlan(recoveryPlan);
					recoveryOld.setTHealthFile(healthFile);
					recoveryOldList.add(recoveryOld);
				}
				recoveryPlanService.addRecoveryOld(recoveryOldList);
			
			json = "{planName:'" + plan.getPlanName() + "',status:'"
					+ plan.getStatus() + "'}";
			return "addPlan";
		} catch (Exception e) {
			// TODO: handle exception
		}
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
		diseaseList.add("残疾障碍");
		diseaseList.add("高血压");
		diseaseList.add("糖尿病");
		diseaseList.add("重性精神疾病");
		diseaseList.add("冠心病");
		diseaseList.add("心脑血管病");
		diseaseList.add("肿瘤");
		diseaseList.add("慢性支气管病");
		jsonString = "[{";
		if (checkbox != null) {
			jsonString = "[{";
			for (Object list : checkbox) {
				jsonString += "\"value\":" + list
						+ ",\"checked\":\"checked\"},{";
			}
			jsonString = jsonString.substring(0, jsonString.length() - 2);
			jsonString += "]";
		} else {
			jsonString = "0";
		}
		staffHosList = staffService.getAllStaffByCommunityHospitalId(comHosId);
		if (tstaff != null) {
			if (healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())) {// 判断员工是否为责任医生，若是，则只能看到所对应的老人
						staffHosList=null;
						staffRe=tstaff;
			}
		}
		return "jumpAddPlan";
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
			jsons = "康复计划重名";// 前台判断如果json不为空就弹框
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
	 * 通过Id删除康复计划
	 * 
	 * @return
	 */
	public String deletePlanById() {

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
		if (recoveryPlanService.checkRecoveryPlan(id)) {
			jsonString = "";
		} else {
			jsonString = " ";
		}
		if (recoveryPlanService.getRecoveryPlanById(id)
				.getCommunityHospitalId() == comHosId
				&& recoveryPlanService.checkRecoveryPlan(id)) {
			recoveryPlanService.deleteRecoveryPlanById(id);
		}
		return "deletePlanId";

	}

	/**
	 * 跳到编辑康复计划页
	 * 
	 * @return
	 */
	/*
	 * public String jumpEditPlan() { try { // 从session中获取社区医院Id
	 * TCommunityHospital tCommunityHospital = (TCommunityHospital)
	 * ActionContext .getContext().getSession().get("comHospital"); TStaff
	 * tstaff = (TStaff) ActionContext.getContext().getSession() .get("tstaff");
	 * int comHosId = 0; if (tstaff != null) { comHosId =
	 * staffService.getCommHospitalByStaffId(tstaff .getStaffId()); } if
	 * (tCommunityHospital != null) { comHosId =
	 * tCommunityHospital.getCommunityHospitalId(); } // 判断社区医院Id是否为当前社区医院Id int
	 * hos = recoveryPlanService.getRecoveryPlanById(id)
	 * .getCommunityHospitalId(); if (comHosId != hos) { return "errorplan"; }
	 * plan = recoveryPlanService.getRecoveryPlanById(id); staffHosList =
	 * staffService .getAllStaffByCommunityHospitalId(comHosId); return
	 * "jumpEditPlan"; } catch (Exception e) { // TODO: handle exception
	 * 
	 * } return "errorplan"; }
	 * 
	 * 
	 * /**
	 * 
	 * 
	 * 编辑康复计划
	 * 
	 * @return
	 */
	/*
	 * public String editRecoveryPlan() { try { // 从session中获取社区医院Id
	 * TCommunityHospital tCommunityHospital = (TCommunityHospital)
	 * ActionContext .getContext().getSession().get("comHospital"); TStaff
	 * tstaff = (TStaff) ActionContext.getContext().getSession() .get("tstaff");
	 * int comHosId=0; if(tstaff!=null) {
	 * comHosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId()); }
	 * if(tCommunityHospital!=null) { comHosId =
	 * tCommunityHospital.getCommunityHospitalId(); } TStaff staff = new
	 * TStaff(select); if (!schemeString.equals("")) { trecoveryScheme =
	 * recoverySchemeService .getRecoverySchemeBySchemeName(schemeString,
	 * comHosId); } else { trecoveryScheme = recoverySchemeService
	 * .getRecoverySchemeById(scheme); }
	 * 
	 * plan.setTStaff(staff); plan.setTRecoveryScheme(trecoveryScheme);
	 * plan.setCommunityHospitalId(comHosId); plan.setStatus("0");
	 * 
	 * recoveryPlanService.updateRecoveryPlan(plan);
	 * recoveryPlanService.deleteAnyRecoveryOld(plan.getRecoveryPlanId());
	 * oldList = recoveryPlanService.getRecoveryOldById(plan
	 * .getRecoveryPlanId()); List<TRecoveryOld> recoveryOldList = new
	 * ArrayList<TRecoveryOld>(); if (checkbox != null) { for (Object list :
	 * checkbox) { THealthFile healthFile = new THealthFile(
	 * Integer.parseInt(String.valueOf(list))); TRecoveryPlan recoveryPlan = new
	 * TRecoveryPlan( plan.getRecoveryPlanId()); TRecoveryOld recoveryOld = new
	 * TRecoveryOld(); recoveryOld.setTRecoveryPlan(recoveryPlan);
	 * recoveryOld.setTHealthFile(healthFile); recoveryOldList.add(recoveryOld);
	 * } recoveryPlanService.addRecoveryOld(recoveryOldList); } return
	 * "editRecoveryPlan"; } catch (Exception e) { // TODO: handle exception }//
	 * 从session中获取社区医院Id TCommunityHospital tCommunityHospital =
	 * (TCommunityHospital) ActionContext
	 * .getContext().getSession().get("comHospital"); TStaff tstaff = (TStaff)
	 * ActionContext.getContext().getSession() .get("tstaff"); int comHosId=0;
	 * if(tstaff!=null) {
	 * comHosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId()); }
	 * if(tCommunityHospital!=null) { comHosId =
	 * tCommunityHospital.getCommunityHospitalId(); } trecoveryScheme =
	 * recoverySchemeService
	 * .getRecoverySchemeById(trecoveryScheme.getRecoverySchemeId());
	 * staffHosList = staffService.getAllStaffByCommunityHospitalId(comHosId);
	 * 
	 * return "jumpEditPlan"; }
	 */
	/**
	 * 康复计划首页查询
	 * 
	 * @return
	 */
	public String getRecoveryPlan() {

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
			if (tCommunityHospital.getIsHead() == 0) {
				comHosId = -1;// 管理员
			} else {
				comHosId = tCommunityHospital.getCommunityHospitalId();
			}
		}
		if (json != null) {
			plan = JSON.parseObject(json, TRecoveryPlan.class);
		}
		if (staffname != null) {
			plan.setTStaff(new TStaff(staffname));
		}
		if (plan.getTStaff() == null) {
			plan.setTStaff(new TStaff());
		}
			   plan.setCommunityHospitalId(comHosId);
				Page page = new Page();
				page.setCurrentPage(cp);
				if(tstaff!=null&&healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())){
					plan.getTStaff().setStaffId(tstaff.getStaffId());
				}
				page.setTotalNum(recoveryPlanService.getRecoveryPlanCountByCon(plan));
				planList = recoveryPlanService.getRecoveryPlanByCon(plan, page);
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
				String timenow=df.format(new Date());
				
				for(TRecoveryPlan list:planList)
				{
					if(timenow.compareTo(list.getOverTime().toString())>0){
						list.setStatus(RecoveryPlanStatus.STARRED.getValue());
						recoveryPlanService.updateRecoveryPlan(list);
					}
					List<TRecoveryOld> olds = recoveryPlanService.getRecoveryOldById(list.getRecoveryPlanId());
					String name = "";
					for (TRecoveryOld ll : olds)
					{
						name+=ll.getTHealthFile().getName()+",";
					}
					if(!name.equals(""))
					{
						list.setOne(name.substring(0, name.length()-1));
					}
				}
				pageHtml = page
						.getPage("healthPhysiotherapyAction!getRecoveryPlan.action?json={planName:'"
								+ plan.getPlanName()
								+ "',status:'"
								+ plan.getStatus()
								+ "'}&staffname=" + plan.getTStaff().getName());
				return "getRecoveryPlan";

	
	}

	/**
	 * 康复计划详情页
	 * 
	 * @return
	 */
	public String getPlanById() {
		try {
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
				if (tCommunityHospital.getIsHead() == 0) {
					comHosId = -1;// 管理员
				} else {
					comHosId = tCommunityHospital.getCommunityHospitalId();
				}
			}
			int hos = recoveryPlanService.getRecoveryPlanById(id)
					.getCommunityHospitalId();
			if (comHosId != hos && comHosId != -1) {
				return "errorplan";
			}
			plan = recoveryPlanService.getRecoveryPlanById(id);
			oldList = recoveryPlanService.getRecoveryOldById(id);
			return "getPlanById";
		} catch (Exception e) {
			// TODO: handle exception
			return "errorplan";
		}

	}

	/**
	 * 改变康复计划状态
	 * 
	 * @return
	 */
	public String changePlanStatus() {
		try {
			if (plan == null) {
				TRecoveryPlan recoveryPlan = recoveryPlanService
						.getRecoveryPlanById(id);
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
				TRecoveryPlan recoveryPlan = recoveryPlanService
						.getRecoveryPlanById(plan.getRecoveryPlanId());
				recoveryPlan.setStatus(RecoveryPlanStatus.NO_STARTED.getValue());
				recoveryPlan.setBeginTime(plan.getBeginTime());
				recoveryPlan.setOverTime(plan.getOverTime());
				recoveryPlanService.updateRecoveryPlan(recoveryPlan);
			}
			return "changePlanStatus";
		} catch (Exception e) {
			// TODO: handle exception
			return "errorplan";
		}

	}

	// 添加计划时用到的康复方案
	public String jsonChuan() {
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
		if (type.equals("专家方案")) {
			List<TCommunityHospital> hospitals = communityHospitalService
					.getWuShiSi();
			schemeList = new ArrayList<TRecoveryScheme>();
			if (hospitals != null) {
				for (TCommunityHospital hos : hospitals) {
					List<TRecoveryScheme> schemes = recoverySchemeService
							.getRecoverySchemesByHosId(
									hos.getCommunityHospitalId(), data);
					if (schemes != null) {
						for (TRecoveryScheme list : schemes) {
							schemeList.add(list);
						}

					}

				}
			}
		}
		else if(type.equals("推荐方案")){
			schemeList = recoverySchemeService.getTuIjianRecoverySchemeByNameAndType( data, type);
		}
		
		else {
			schemeList = recoverySchemeService.getRecoverySchemeByNameAndType(
					comHosId, data, type);// 根据疾病名称和方案类型得到当前社区下的康复方案
		}

		/* [{key:value},{key:value}] */
		jsonString = "[{";
		for (TRecoveryScheme scheme : schemeList) {
			jsonString += "\"value\":" + scheme.getRecoverySchemeId()
					+ ",\"text\":\"" + scheme.getSchemeName() + "\"},{";
		}
		jsonString = jsonString.substring(0, jsonString.length() - 2);
		jsonString += "]";
		if (schemeList.size() == 0) {
			jsonString = "[]";
		}
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
		return null;
	}

	/**
	 * 增加计划是用到老人
	 * 
	 * @return
	 */
	public String getAddOld() {
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
		int flag = -1;
		if(tstaff!=null&&healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())){
			flag=tstaff.getStaffId();
		}
		chroniclist = chronicDiseaseService.getAllPeople(comHosId, data,flag);// 根据疾病名称和当前社区id得到符合条件的老人
		
		json = "[{";
		for (VChronic chronic : chroniclist) {
			json += "\"value\":" + chronic.getHealthFileId() + ",\"text\":\""
					+ chronic.getFileName() + "\"},{";
		}
		json = json.substring(0, json.length() - 2);
		json += "]";
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(
						org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		try {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 修改康复计划的
	 * 
	 * @return
	 */
/*	public String getEditAddOld() {
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
		chroniclist = chronicDiseaseService.getAllPeople(comHosId, data);
		List<TRecoveryOld> olds = new ArrayList<TRecoveryOld>();
		olds = recoveryPlanService.getRecoveryOldById(id);
		json = "[{";
		for (VChronic chronic : chroniclist) {
			if (olds.size() > 0 && olds != null) {
				for (TRecoveryOld old : olds) {

					if (old.getTHealthFile().getHealthFileId() == chronic
							.getHealthFileId()
							&& disease.equalsIgnoreCase(data)) {
						jString = "\"value\":" + chronic.getHealthFileId()
								+ ",\"text\":\"" + chronic.getFileName()
								+ "\",\"checked\":\"checked\"},{";
						break;
					}
					jString = "\"value\":" + chronic.getHealthFileId()
							+ ",\"text\":\"" + chronic.getFileName()
							+ "\",\"checked\":\"\"},{";
				}
				json = json + jString;
			} else {
				json += "\"value\":" + chronic.getHealthFileId()
						+ ",\"text\":\"" + chronic.getFileName()
						+ "\",\"checked\":\"\"},{";
			}

		}
		System.out.println(json);
		json = json.substring(0, json.length() - 2);
		json += "]";
		HttpServletResponse response = (HttpServletResponse) ActionContext
				.getContext().get(
						org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
		try {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}
*/
	// ////////////////////////////////统计分析///////////////////////////////////////////////
	/**
	 * 根据康复方案Id删除康复方案
	 * 
	 * @return
	 */
	public String deletestStisticalById() {
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
		if (recoveryPlanService.checkRecoveryPlan(id)) {
			json = "";
		} else {
			json = " ";
		}
		if (recoveryPlanService.getRecoveryPlanById(id)
				.getCommunityHospitalId() == comHosId
				&& recoveryPlanService.checkRecoveryPlan(id)) {
			recoveryPlanService.deleteRecoveryPlanById(id);
		}
		return "deletestStisticalById";

	}

	/**
	 * 得到该社区下所有的统计分析 统计分析首页显示
	 * 
	 * @return
	 */
	public String getRecovery() {
		try {
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
				if (tCommunityHospital.getIsHead() == 0) {
					comHosId = -1;// 管理员
				} else {
					comHosId = tCommunityHospital.getCommunityHospitalId();
				}

			}
			int flag=-1;
			if(tstaff!=null&&healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())){
				flag=tstaff.getStaffId();
			}
			Page page = new Page();
			page.setCurrentPage(cp);
			page.setTotalNum(recoveryPlanService
					.getAllRecoveryPlanCountByHosId(comHosId,flag));
			planList = recoveryPlanService.getAllRecoveryPlanByHosId(page,
					comHosId,flag);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			String timenow=df.format(new Date());
			
			for(TRecoveryPlan list:planList)
			{
				if(timenow.compareTo(list.getOverTime().toString())>0){
					list.setStatus(RecoveryPlanStatus.STARRED.getValue());
					recoveryPlanService.updateRecoveryPlan(list);
				}
				List<TRecoveryOld> olds = recoveryPlanService.getRecoveryOldById(list.getRecoveryPlanId());
				String name = "";
				for (TRecoveryOld ll : olds)
				{
					name+=ll.getTHealthFile().getName()+",";
				}
				if(!name.equals(""))
				{
					list.setOne(name.substring(0, name.length()-1));
				}
			}
			
			pageHtml = page
					.getPage("healthPhysiotherapyAction!getRecovery.action");
			;
			return "getRecovery";
		} catch (Exception e) {
			// TODO: handle exception
			return "errorStatistical";
		}

	}

	public List<TCommunityHospital> gettCommunityHospital() {
		return tCommunityHospital;
	}

	public void settCommunityHospital(List<TCommunityHospital> tCommunityHospital) {
		this.tCommunityHospital = tCommunityHospital;
	}

	/**
	 * 统计分析首页查询
	 * 
	 * @return
	 */
	public String getSearchRecovery() {
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
			if (tCommunityHospital.getIsHead() == 0) {
				comHosId = -1;// 管理员
			} else {
				comHosId = tCommunityHospital.getCommunityHospitalId();
			}

		}
		if (startTime != null) {
			st = TypeConverter.dateFormat(startTime);
		}
		if (endTime != null) {
			et = TypeConverter.dateFormat(endTime);
		}
		if (st != null && startTime == null) {
			startTime = TypeConverter.convertString2Date(st, "yyyy-MM-dd");
		}
		if (et != null && endTime == null) {
			endTime = TypeConverter.convertString2Date(et, "yyyy-MM-dd");
		}
		int flag=-1;
		if(tstaff!=null&&healthFileService.getOldStaffHosByStaffId(tstaff.getStaffId())){
			flag=tstaff.getStaffId();
		}
		Page page = new Page();
		page.setCurrentPage(cp);
		page.setTotalNum(recoveryPlanService.countBySearch(mySelect, startTime,
				endTime, comHosId,flag));
		planList = recoveryPlanService.getStatisticalAnalysisByDate(mySelect,
				page, startTime, endTime, comHosId,flag);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
		String timenow=df.format(new Date());
		
		for(TRecoveryPlan list:planList)
		{
			if(timenow.compareTo(list.getOverTime().toString())>0){
				list.setStatus(RecoveryPlanStatus.STARRED.getValue());
				recoveryPlanService.updateRecoveryPlan(list);
			}
			List<TRecoveryOld> olds = recoveryPlanService.getRecoveryOldById(list.getRecoveryPlanId());
			String name = "";
			for (TRecoveryOld ll : olds)
			{
				name+=ll.getTHealthFile().getName()+",";
			}
			if(!name.equals(""))
			{
				list.setOne(name.substring(0, name.length()-1));
			}
		}
		
		pageHtml = page
				.getPage("healthPhysiotherapyAction!getSearchRecovery.action?st="
						+ st + "&et=" + et + "&mySelect=" + mySelect);
		return "getSearchRecovery";
	}

	/**
	 * 统计分析详情
	 * 
	 * @return
	 */
	public String getRocoveryById() {
		try {
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
				if (tCommunityHospital.getIsHead() == 0) {
					comHosId = -1;// 管理员
				} else {
					comHosId = tCommunityHospital.getCommunityHospitalId();
				}
			}
			int hos = recoveryPlanService.getRecoveryPlanById(id)
					.getCommunityHospitalId();

			if (comHosId != hos && comHosId != -1) {
				return "errorStatistical";
			}
			plan = recoveryPlanService.getRecoveryPlanById(id);
			oldList = recoveryPlanService.getRecoveryOldById(id);
			return "getRocoveryById";
		} catch (Exception e) {
			// TODO: handle exception
			return "errorStatistical";
		}

	}

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * 
	 * 
	 * 
	 * 专家康复方案
	 */
	// //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	/**
	 * 跳 到添加专家康复方案
	 * 
	 * @return
	 */
	public String jumpAddExpertScheme() {
		
		
		
		//获取社区集团
        HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        
        if(group!=null)
        {
        	zhuanjia=0;
        }else{
        	//TCommunityHospital comHos=(TCommunityHospital) session.getAttribute("comHospital");
        	zhuanjia=1;
        }
        
		
		try {
			diseaseList.add("残疾障碍");
			diseaseList.add("高血压");
			diseaseList.add("糖尿病");
			diseaseList.add("重性精神疾病");
			diseaseList.add("冠心病");
			diseaseList.add("心脑血管病");
			diseaseList.add("肿瘤");
			diseaseList.add("慢性支气管病");
			//后台防止重复提交
			token = TokenProccessor.getInstance().makeToken();//创建令牌
			HttpServletRequest request=ServletActionContext.getRequest();
			request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
			return "jumpAddExpertScheme";

		} catch (Exception e) {
			// TODO: handle exception
			


			
			
			
		}
		return "errorExpertScheme";
	}

	/**
	 * 添加推荐康复方案，并跳到专家康复方案首页
	 * 
	 * @return
	 */
	public String addExpertScheme() {
			try {
				
				//判断表单重复提交
				HttpServletRequest request=ServletActionContext.getRequest();
				boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
				if(b==true){
					return "getExpertScheme";//重定向回首页
				}
				request.getSession().removeAttribute("token");//移除session中的token
				
				
				
				HttpSession session = ServletActionContext.getRequest().getSession();
		        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
		        if(group!=null){
		        int comHosId=0;
		        int GId=group.getGId();
		        trecoveryScheme.setGroupId(GId);
		 		trecoveryScheme.setIdDelete(IS_DELETE.no_Delete.getValue());
    			trecoveryScheme.setCommunityHospitalId(comHosId);
    			trecoveryScheme.setNote(group.getGroupName());
	  			if (trecoveryScheme.getSchemeName().equals("")) {	
	  				trecoveryScheme.setSchemeName(null);
		  			}
		  		/*	if (recoverySchemeService.checkSchemeName(comHosId, trecoveryScheme.getSchemeName()) > 0)
		  			{
		  				throw new Exception();
		  			}*/
		  		/*	trecoveryScheme.setNote(communityHospitalService
		  					.getCommunityHospitalById(comHosId).getName());*/
		  			
		  		Date date = new Date();
		  		trecoveryScheme.setConstituteTime(TypeConverter.date2Timestamp(date));
		  		recoverySchemeService.addExpertRecoveryScheme(trecoveryScheme);
	 			json = "{schemeName:'" + trecoveryScheme.getSchemeName() + "'}";
	 			return "addExpertScheme";
		        	 
		         }
			 else{
			
			// 从session中获取社区医院Id
			TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext
					.getContext().getSession().get("comHospital");
			TStaff tstaff = (TStaff) ActionContext.getContext().getSession()
					.get("tstaff");
			int groupId=0;
			int comHosId = 0;
			if (tstaff != null) {
				if (tCommunityHospital.getIsHead() == 0) {
					comHosId = -1;// 管理员
				} else {
					comHosId = tCommunityHospital.getCommunityHospitalId();
				}
			}
			if (tCommunityHospital != null) {
				comHosId = tCommunityHospital.getCommunityHospitalId();
			}
			trecoveryScheme.setGroupId(groupId);
			trecoveryScheme.setIdDelete(IS_DELETE.no_Delete.getValue());
  			trecoveryScheme.setCommunityHospitalId(comHosId);
  			if (trecoveryScheme.getSchemeName().equals("")) {
  				trecoveryScheme.setSchemeName(null);
  			}
  		/*	if (recoverySchemeService.checkSchemeName(comHosId, trecoveryScheme.getSchemeName()) > 0)
  			{
  				throw new Exception();
  			}*/
  		/*	trecoveryScheme.setNote(communityHospitalService
  					.getCommunityHospitalById(comHosId).getName());*/
  			
  			Date date = new Date();
  			trecoveryScheme.setConstituteTime(TypeConverter.date2Timestamp(date));
  			recoverySchemeService.addExpertRecoveryScheme(trecoveryScheme);
  			json = "{schemeName:'" + trecoveryScheme.getSchemeName() + "'}";
  			return "addExpertScheme";
			/*if (recoverySchemeService.checkSchemeName(comHosId, trecoveryScheme.getSchemeName()) > 0)
			{
				throw new Exception();
			}
*/
		
	 }
		
		} catch (Exception e) {
			// TODO: handle exception
		
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
		diseaseList.add("残疾障碍");
		diseaseList.add("高血压");
		diseaseList.add("糖尿病");
		diseaseList.add("重性精神疾病");
		diseaseList.add("冠心病");
		diseaseList.add("心脑血管病");
		diseaseList.add("肿瘤");
		diseaseList.add("慢性支气管病");
		return "jumpAddExpertScheme";
	}
	}
	/**
	 * 根据康复方案Id删除专家康复方案
	 * 
	 * @return
	 */
	public String deleteExpertSchemeById() {
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
		if (recoveryPlanService.checkRecoveryScheme(id)) {
			jsonString = "";
		} else {
			jsonString = " ";
		}
		if (recoverySchemeService.getRecoverySchemeById(id)
				.getCommunityHospitalId() == comHosId
				&& recoveryPlanService.checkRecoveryScheme(id)) {
			recoverySchemeService.deleteRecoverySchemeById(id);
			return "deleteExpertSchemeById";
		} else {
			return "deleteExpertSchemeById";
		}
	}

	/*	*//**
	 * 跳转到专家康复方案编辑页面
	 * 
	 * @return
	 */
	/*
	 * public String jumpEditExpertScheme() { try { // 从session中获取社区医院Id
	 * TCommunityHospital tCommunityHospital = (TCommunityHospital)
	 * ActionContext .getContext().getSession().get("comHospital"); TStaff
	 * tstaff = (TStaff) ActionContext.getContext().getSession() .get("tstaff");
	 * int comHosId=0; if(tstaff!=null) {
	 * comHosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId()); }
	 * if(tCommunityHospital!=null) { comHosId =
	 * tCommunityHospital.getCommunityHospitalId(); } trecoveryScheme =
	 * recoverySchemeService.getRecoverySchemeById(id); staffHosList =
	 * staffService.getAllStaffByCommunityHospitalId(comHosId);
	 * 
	 * return "jumpEditExpertScheme"; } catch (Exception e) { // TODO: handle
	 * exception return "errorExpertScheme"; }
	 * 
	 * }
	 *//**
	 * 编辑专家康复方案
	 * 
	 * @return
	 */
	/*
	 * public String editExpertRecoveryScheme() { try { // 从session中获取社区医院Id
	 * TCommunityHospital tCommunityHospital = (TCommunityHospital)
	 * ActionContext .getContext().getSession().get("comHospital"); TStaff
	 * tstaff = (TStaff) ActionContext.getContext().getSession() .get("tstaff");
	 * int comHosId=0; if(tstaff!=null) {
	 * comHosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId()); }
	 * if(tCommunityHospital!=null) { comHosId =
	 * tCommunityHospital.getCommunityHospitalId(); } TStaff staff = new
	 * TStaff(select); trecoveryScheme.setTStaff(staff);
	 * trecoveryScheme.setRecoverySchemeId(trecoveryScheme
	 * .getRecoverySchemeId());
	 * trecoveryScheme.setCommunityHospitalId(comHosId);
	 * recoverySchemeService.updateExpertRecoveryScheme(trecoveryScheme); return
	 * "editExpertRecoveryScheme"; } catch (Exception e) { // TODO: handle
	 * exception // 从session中获取社区医院Id TCommunityHospital tCommunityHospital =
	 * (TCommunityHospital) ActionContext
	 * .getContext().getSession().get("comHospital"); TStaff tstaff = (TStaff)
	 * ActionContext.getContext().getSession() .get("tstaff"); int comHosId=0;
	 * if(tstaff!=null) {
	 * comHosId=staffService.getCommHospitalByStaffId(tstaff.getStaffId()); }
	 * if(tCommunityHospital!=null) { comHosId =
	 * tCommunityHospital.getCommunityHospitalId(); } trecoveryScheme =
	 * recoverySchemeService
	 * .getRecoverySchemeById(trecoveryScheme.getRecoverySchemeId());
	 * staffHosList = staffService.getAllStaffByCommunityHospitalId(comHosId);
	 * return"jumpEditExpertScheme"; }
	 * 
	 * }
	 */

	/**
	 * 推荐康复方案首页的查询
	 * 
	 * @return
	 */
	public String getExpertScheme() {
		
		  HttpSession session = ServletActionContext.getRequest().getSession();
	       TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
          int  groupId=0;
          int comHosId=0;
	        if(group!=null)
	        {
                
	        	groupId = group.getGId();
	        	if (json != null) {
					trecoveryScheme = JSON.parseObject(json, TRecoveryScheme.class);
				}
				if (trecoveryScheme == null) {
					trecoveryScheme = new TRecoveryScheme();
					trecoveryScheme.setTStaff(new TStaff());
				} else {
					if (trecoveryScheme.getTStaff() == null) {
						if (staffname != null && staffname != "") // 查询条件的指定人姓名
						{
							trecoveryScheme.setTStaff(new TStaff(staffname));
						} else {
							trecoveryScheme.setTStaff(new TStaff());
							trecoveryScheme.getTStaff().setName("");
						}
					}
				}
				trecoveryScheme.setGroupId(groupId); 
				trecoveryScheme.setType("专家方案,推荐方案");
				Page page = new Page();
		        page.setCurrentPage(cp);                
		    	
				page.setTotalNum(recoverySchemeService
						.getExpertRecoverySchemeCountBySearch(trecoveryScheme,groupId));
				
				schemeList = recoverySchemeService.getExpertRecoveryScheme(
						trecoveryScheme, groupId,page);
			
				pageHtml = page
						.getPage("entity");
				
				
				
        		
				
				
				
				// <%=basePath
				// %>healthPhysiotherapyAction!changePlanStatus.action?json={recoveryPlanId:'${list.recoveryPlanId}'}
				return "getExpertScheme";
	        }
	       else{
		
		TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext
				.getContext().getSession().get("comHospital");
		TStaff tstaff = (TStaff) ActionContext.getContext().getSession()
				.get("tstaff");
		
		if (tstaff != null) {
			comHosId = staffService.getCommHospitalByStaffId(tstaff
					.getStaffId());
		}
		if (tCommunityHospital != null) {
			if (tCommunityHospital.getIsHead() == 0) {
				comHosId = -1;// 管理员
			} else {
				comHosId = tCommunityHospital.getCommunityHospitalId();
			}

		}// 得到社区医院id
		if (json != null) {
			trecoveryScheme = JSON.parseObject(json, TRecoveryScheme.class);
		}
		if (trecoveryScheme == null) {
			trecoveryScheme = new TRecoveryScheme();
			trecoveryScheme.setTStaff(new TStaff());
		} else {
			if (trecoveryScheme.getTStaff() == null) {
				if (staffname != null && staffname != "") // 查询条件的指定人姓名
				{
					trecoveryScheme.setTStaff(new TStaff(staffname));
				} else {
					trecoveryScheme.setTStaff(new TStaff());
					trecoveryScheme.getTStaff().setName("");
				}
			}
		}
		if (trecoveryScheme != null) {
			if (trecoveryScheme.getSchemeName() != null
					&& trecoveryScheme.getSchemeName().equals("null")) {
				trecoveryScheme.setSchemeName("");
			}
			if (trecoveryScheme.getTStaff() != null
					&& trecoveryScheme.getTStaff().getName() != null
					&& trecoveryScheme.getTStaff().getName().equals("null")) {
				trecoveryScheme.getTStaff().setName("");
				;
			}
		}
		trecoveryScheme.setType("推荐方案,专家方案");
		Page page = new Page();
		page.setCurrentPage(cp);
		trecoveryScheme.setCommunityHospitalId(comHosId);
		
		page.setTotalNum(recoverySchemeService
				.getExpertRecoverySchemeCountBySearch(trecoveryScheme,groupId));
		
		schemeList = recoverySchemeService.getExpertRecoveryScheme(
				trecoveryScheme, groupId,page);
				
		for (TRecoveryScheme list : schemeList) {
			TCommunityHospital hospital=communityHospitalService.getCommunityHospitalById(
					
					list.getCommunityHospitalId());
			if(hospital!=null&&hospital.getName()!=null){
				list.setNote(hospital.getName());
			}
			
		}
		pageHtml = page
				.getPage("healthPhysiotherapyAction!getExpertScheme.action?json={schemeName:'"
						+ trecoveryScheme.getSchemeName()
						+ "'}&staffname="
						+ trecoveryScheme.getTStaff().getName());
		return "getExpertScheme";
	        }
	}

	/**
	 * 专家康复方案详情页
	 * 
	 * @return
	 */
	public String expertSchemeDetails() {
		try {
			TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext
					.getContext().getSession().get("comHospital");
			TStaff tstaff = (TStaff) ActionContext.getContext().getSession()
					.get("tstaff");
			int comHosId = 0;

			trecoveryScheme = recoverySchemeService.getRecoverySchemeById(id);
			return "expertSchemeDetails";
		} catch (Exception e) {
			// TODO: handle exception
			return "errorExpertScheme";
		}

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// ///////////////////////////////////////////set
	// get方法////////////////////////////////////////////
	public TRecoveryScheme getTrecoveryScheme() {
		return trecoveryScheme;
	}

	public void setTrecoveryScheme(TRecoveryScheme trecoveryScheme) {
		this.trecoveryScheme = trecoveryScheme;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	RecoverySchemeService getRecoverySchemeService() {
		return recoverySchemeService;
	}

	public void setRecoverySchemeService(
			RecoverySchemeService recoverySchemeService) {
		this.recoverySchemeService = recoverySchemeService;
	}

	public List<VStaffHos> getStaffHosList() {
		return staffHosList;
	}

	public void setStaffHosList(List<VStaffHos> staffHosList) {
		this.staffHosList = staffHosList;
	}

	public int getSelect() {
		return select;
	}

	public void setSelect(int select) {
		this.select = select;
	}

	public List<TRecoveryScheme> getSchemeList() {
		return schemeList;
	}

	public void setSchemeList(List<TRecoveryScheme> schemeList) {
		this.schemeList = schemeList;
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

	public TRecoveryPlan getPlan() {
		return plan;
	}

	public void setPlan(TRecoveryPlan plan) {
		this.plan = plan;
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

	public String getData() {
		return data;
	}

	public int getZhuanjia() {
		return zhuanjia;
	}

	public void setZhuanjia(int zhuanjia) {
		this.zhuanjia = zhuanjia;
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
	private int i;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	


	public List<VChronic> getChroniclist() {
		return chroniclist;
	}

	public void setChroniclist(List<VChronic> chroniclist) {
		this.chroniclist = chroniclist;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public static TRecoveryScheme getCeshi() {
		return ceshi;
	}

	public static void setCeshi(TRecoveryScheme ceshi) {
		HealthPhysiotherapyAction.ceshi = ceshi;
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

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public List<Object> getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(List<Object> checkbox) {
		this.checkbox = checkbox;
	}

	public List<TRecoveryPlan> getPlanList() {
		return planList;
	}

	public void setPlanList(List<TRecoveryPlan> planList) {
		this.planList = planList;
	}
	public Date getTimenow() {
		return timenow;
	}

	public void setTimenow(Date timenow) {
		this.timenow = timenow;
	}

	public String getDf() {
		return df;
	}

	public void setDf(String df) {
		this.df = df;
	}

	public List<TRecoveryOld> getOldList() {
		return oldList;
	}

	public void setOldList(List<TRecoveryOld> oldList) {
		this.oldList = oldList;
	}

	public String getjString() {
		return jString;
	}

	public void setjString(String jString) {
		this.jString = jString;
	}

	public int getScheme() {
		return scheme;
	}

	public void setScheme(int scheme) {
		this.scheme = scheme;
	}

	public String getSchemeString() {
		return schemeString;
	}

	public void setSchemeString(String schemeString) {
		this.schemeString = schemeString;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getPlanStatus() {
		return planStatus;
	}

	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}

	public String getDisease() {
		return disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	public String getStaffname() {
		return staffname;
	}

	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}

	public String getJsons() {
		return jsons;
	}

	public void setJsons(String jsons) {
		this.jsons = jsons;
	}

	public List<String> getDiseaseList() {
		return diseaseList;
	}

	public void setDiseaseList(List<String> diseaseList) {
		this.diseaseList = diseaseList;
	}

	public String getMySelect() {
		return mySelect;
	}

	public void setMySelect(String mySelect) {
		this.mySelect = mySelect;
	}

	public String getSt() {
		return st;
	}

	public void setSt(String st) {
		this.st = st;
	}

	public String getEt() {
		return et;
	}

	public void setEt(String et) {
		this.et = et;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public String getHosId() {
		return HosId;
	}

	public void setHosId(String hosId) {
		HosId = hosId;
	}

	public int[] getIds() {
		return ids;
	}

	public void setIds(int[] ids) {
		this.ids = ids;
	}

	public String getOldString() {
		return oldString;
	}

	public void setOldString(String oldString) {
		this.oldString = oldString;
	}

	public TStaff getStaffRe() {
		return staffRe;
	}

	public void setStaffRe(TStaff staffRe) {
		this.staffRe = staffRe;
	}
}
