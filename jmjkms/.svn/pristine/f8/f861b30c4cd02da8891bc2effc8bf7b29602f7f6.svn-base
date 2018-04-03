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
import com.alibaba.fastjson.JSONObject;
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
import com.jmjk.entity.view.VOldStaff;
import com.jmjk.entity.view.VStaffHos;
import com.jmjk.enums.Admin_IsHead;
import com.jmjk.enums.CHRONIC_MANAGER;
import com.jmjk.enums.HealthFileCheck;
import com.jmjk.enums.IS_DELETE;
import com.jmjk.enums.RecoveryPlanStatus;
import com.jmjk.iservice.ICommunityHospitalService;
import com.jmjk.export.DiabeteExport;
import com.jmjk.export.highBloodExport;
import com.jmjk.iservice.IHealthAlarmService;
import com.jmjk.iservice.IHealthFileService;
import com.jmjk.iservice.IHealthManagerService;
import com.jmjk.iservice.IRecoverySchemeService;
import com.jmjk.iservice.IStaffService;
import com.jmjk.pojo.AlarmData;
import com.jmjk.pojo.AlarmGetDateGet;
import com.jmjk.pojo.BloodPress;
import com.jmjk.pojo.BloodPressCloud;
import com.jmjk.pojo.BloodSuger;
import com.jmjk.pojo.BloodSugerCloud;
import com.jmjk.pojo.HealthFileCloud;
import com.jmjk.pojo.HealthFileCloud.Page.HealthFile;
import com.jmjk.pojo.XKHealthMachineCloud;
import com.jmjk.pojo.XKHealthMachineCloud.XKHealthMachine;
import com.jmjk.service.AllChronicDiseaseService;
import com.jmjk.service.CommunityHospitalGroupService;
import com.jmjk.service.HealthAlarmService;
import com.jmjk.service.HealthFileService;
import com.jmjk.service.OldStaffHosService;
import com.jmjk.service.RecoveryPlanService;
import com.jmjk.service.StaffService;
import com.jmjk.service.XKHealthMachineService;
import com.jmjk.utils.GetSessionPerson;
import com.jmjk.utils.JxlExcel;
import com.jmjk.utils.Page;
import com.jmjk.utils.Resubmit;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.SearchBeanSU;
import com.jmjk.utils.TokenProccessor;
import com.jmjk.utils.TypeConverter;
import com.jmjk.utils.WebXMLParameter;
import com.opensymphony.xwork2.ActionContext;

@Component
@Scope("prototype")
@Action(value = "xkHealthMachineAction", results = {
		@Result(name = "getList", location = "/jsp/healthManager/zwb/main.jsp"),
		// @Result(name = "getListByCX", type = "redirectAction", location =
		// "xkHealthMachineAction!getList.action", params = {
		// " IDNumbers", "${IDNumbers }", "startTime", "${startTime}",
		// "endTime", "${endTime}", "JCXM", "${JCXM}", "currentPage",
		// "${currentPage}", "pageSize", "${pageSize}" }),
		@Result(name = "getListByCX", location = "/jsp/healthManager/zwb/main.jsp"),
		@Result(name = "showDetail", location = "/jsp/healthManager/zwb/detail.jsp") })
public class XKHealthMachineAction extends BaseAction {

	@Autowired
	private XKHealthMachineService xkHealthMachineService;
	@Autowired
	private HealthFileService healthFileService;
	@Autowired
	private StaffService staffService;
	@Autowired
	private HealthAlarmService healthAlarmService;

	private String appKey = WebXMLParameter.getParamByappkey("appkey1");
	private static final long serialVersionUID = 1L;
	private int cp = 1;
	private Date startTime;
	private Date endTime;
	private String start;
	private String end;
	private Long id;
	private int state = 2;// 档案状态
	private String resultJson;
	private int currentPage = 1;
	private String pageHtml;
	private String PersonName;
	private String JCXM;
	private String IDNumber;
	private String IDNumbers = "";
	private List<XKHealthMachine> theItems;
	private XKHealthMachine xkHealthMachine;
	// 用于数据总数
	private int pagenumT = 0;
	private List<THealthFile> healthFileList;
	private List<VOldStaff> voldStaff;
	private List<HealthFile> healthFileCloudList;
	private SearchBeanSU searchbean;// （多条件查询）
	private int pageSize;

	private VOldStaff old;

	public VOldStaff getOld() {
		return old;
	}

	public void setOld(VOldStaff old) {
		this.old = old;
	}

	public IStaffService getStaffService() {
		return staffService;
	}

	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}

	public List<VOldStaff> getVoldStaff() {
		return voldStaff;
	}

	public void setVoldStaff(List<VOldStaff> voldStaff) {
		this.voldStaff = voldStaff;
	}

//	public void setStartTime(Date startTime) {
//		this.startTime = startTime;
//	}
//
//	public void setEndTime(Date endTime) {
//		this.endTime = endTime;
//	}

	public XKHealthMachine getXkHealthMachine() {
		return xkHealthMachine;
	}

	public void setXkHealthMachine(XKHealthMachine xkHealthMachine) {
		this.xkHealthMachine = xkHealthMachine;
	}

	public XKHealthMachineService getXkHealthMachineService() {
		return xkHealthMachineService;
	}

	public void setXkHealthMachineService(
			XKHealthMachineService xkHealthMachineService) {
		this.xkHealthMachineService = xkHealthMachineService;
	}

	public IHealthFileService getHealthFileService() {
		return healthFileService;
	}

	public void setHealthFileService(HealthFileService healthFileService) {
		this.healthFileService = healthFileService;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		if (startTime != null && !startTime.equals("")) {
			this.startTime = TypeConverter.convertString2Date(startTime,
					"yyyy-MM-dd");
		} else {
			startTime = null;
		}
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		if (endTime != null && !endTime.equals("")) {
			this.endTime = TypeConverter.convertString2Date(endTime,
					"yyyy-MM-dd");
		} else {
			endTime = null;
		}
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getResultJson() {
		return resultJson;
	}

	public void setResultJson(String resultJson) {
		this.resultJson = resultJson;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getPageHtml() {
		return pageHtml;
	}

	public void setPageHtml(String pageHtml) {
		this.pageHtml = pageHtml;
	}

	public String getPersonName() {
		return PersonName;
	}

	public void setPersonName(String personName) {
		PersonName = personName;
	}

	public String getJCXM() {
		return JCXM;
	}

	public void setJCXM(String jCXM) {
		JCXM = jCXM;
	}

	public String getIDNumber() {
		return IDNumber;
	}

	public void setIDNumber(String iDNumber) {
		IDNumber = iDNumber;
	}

	public String getIDNumbers() {
		return IDNumbers;
	}

	public void setIDNumbers(String iDNumbers) {
		IDNumbers = iDNumbers;
	}

	public List<XKHealthMachine> getTheItems() {
		return theItems;
	}

	public void setTheItems(List<XKHealthMachine> theItems) {
		this.theItems = theItems;
	}

	public int getPagenumT() {
		return pagenumT;
	}

	public void setPagenumT(int pagenumT) {
		this.pagenumT = pagenumT;
	}

	public List<THealthFile> getHealthFileList() {
		return healthFileList;
	}

	public void setHealthFileList(List<THealthFile> healthFileList) {
		this.healthFileList = healthFileList;
	}

	public String getList() {
		// 分页
		Page<XKHealthMachineCloud> page = new Page<XKHealthMachineCloud>();
		page.setCurrentPage(cp);
		String resultJson = "";
		// Page<THealthFile> page2 = new Page<THealthFile>();
		// page2.setTotalNum(healthFileService.getHealthFileCount());
		// healthFileList = healthFileService.getAllHealthFile(page2,
		// HealthFileCheck.zhengchang.getValue());// 得到档案正常的所有老人
		// if (healthFileList.size() > 0) {
		// for (THealthFile healthFile : healthFileList) {
		// IDNumbers += "," + healthFile.getIdNum();
		// }
		// } else {
		// IDNumbers += ",-1";
		// }
		// IDNumbers = IDNumbers.substring(1);

		// 如果初始查询的两个时间任意一个为空 直接返回页面
		// if (startTime==null || endTime==null) {
		// //用于时间回显
		// start=TypeConverter.convertDate2String(startTime, "yyyy-MM-dd");
		// end=TypeConverter.convertDate2String(endTime, "yyyy-MM-dd");
		// page.setTotalNum(0);
		// page.setCurrentPage(1);
		// currentPage=page.getCurrentPage();
		// this.pageHtml =
		// page.getPage("healthAlarmAction!getAlarmData.action?startTime="+start+"&endTime="+end);
		//
		// return "getList";
		//
		// }

		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group = (TCommunityHospitalGroup) session
				.getAttribute("communityHospitalGroup");
		if (group != null) {// 集团管理员，可以看到集团下属所有社区医院（服务站）的内容
			voldStaff = healthFileService.getOldStaffsListByGroupAdmin(group
					.getGId());
			for (VOldStaff old : voldStaff) {
				if (old.getIdNum() == null || old.getIdNum().equals("")) {
					continue;
				}
				IDNumbers += "," + old.getIdNum();
			}
			if (IDNumbers.length() == 0) {
				IDNumbers += ",-1";
			}
			IDNumbers = IDNumbers.substring(1);
		} else {
			// 从session里拿到当前登录用户的id
			int person = GetSessionPerson.getPerson();
			// 平台管理员
			if (person == Admin_IsHead.guanliyuan.getValue()) {
				// 平台管理员查数据库所有档案list
				voldStaff = healthFileService.getOldStaffsListByPlatAdmin();
				if (voldStaff.size() > 0) {
					for (VOldStaff old : voldStaff) {
						if (old.getIdNum() == null || old.getIdNum().equals("")) {
							continue;
						}
						IDNumbers += "," + old.getIdNum();
					}
					if (IDNumbers.length() == 0) {
						IDNumbers += ",-1";
					}
					IDNumbers = IDNumbers.substring(1);
				} else {
					IDNumbers += ",-1";
					IDNumbers = IDNumbers.substring(1);
				}

			}
			int staffId = -1;
			// 社区其他员工（含责任医生、其他员工）
			if (person > 0) {
				// pepl用于判断当前登陆员工是否是责任医生
				boolean pepl = healthFileService
						.getOldStaffHosByStaffId(person);

				// 责任医生
				if (pepl == true) {
					staffId = person;
					healthFileList = healthFileService
							.getHealthFileListByStaffIdForSpeciall(state,
									staffId);
					if (healthFileList.size() > 0) {
						for (THealthFile healthFile : healthFileList) {
							if (healthFile.getIdNum() == null
									|| healthFile.getIdNum().equals("")) {
								continue;
							}
							IDNumbers += "," + healthFile.getIdNum();
						}
						if (IDNumbers.length() == 0) {
							IDNumbers += ",-1";
						}

					} else {
						IDNumbers += ",-1";
					}
					IDNumbers = IDNumbers.substring(1);

				}
				// 其他员工（普通员工或操作员，不常用，登录界面选医生登录）
				else {
					staffId = person;
					// 获取当前普通员工所在医院实体
					int communityHospitalId = staffService
							.getCommHospitalByStaffId(staffId);
					// 获取普通员工所辖的医院 整个医院的档案list
					voldStaff = healthFileService
							.getOldStaffsListBycommunityid(communityHospitalId);
					if (voldStaff.size() > 0) {
						for (VOldStaff old : voldStaff) {
							if (old.getIdNum() == null
									|| old.getIdNum().equals("")) {
								continue;
							}
							IDNumbers += "," + old.getIdNum();
						}
						if (IDNumbers.length() == 0) {
							IDNumbers += ",-1";
						}
						IDNumbers = IDNumbers.substring(1);
					} else {
						IDNumbers += ",-1";
						IDNumbers = IDNumbers.substring(1);
					}

				}
			} else if (person < 0) {// 社区管理员（社区负责人）
				int communityHosiptalId = -person;

				voldStaff = healthFileService
						.getOldStaffsListBycommunityid(communityHosiptalId);
				if (voldStaff.size() > 0) {
					for (VOldStaff old : voldStaff) {
						if (old.getIdNum() == null || old.getIdNum().equals("")) {
							continue;
						}
						IDNumbers += "," + old.getIdNum();
					}
					if (IDNumbers.length() == 0) {
						IDNumbers += ",-1";
					}
					IDNumbers = IDNumbers.substring(1);
				} else {
					IDNumbers += ",-1";
					IDNumbers = IDNumbers.substring(1);
				}
				// 获取一个社区的档案list
				// healthFileList=healthFileService.getOldStaffsListBycommunityid(communityHosiptalId);
			}
		}

		// 访问预警数据接口，查询预警数据 currentPage设置为1 pageSize设置为1000000 用于在第一页将全部数据取到
		// 然后在本地进行分页
		// start = TypeConverter.convertDate2String(startTime, "yyyy-MM-dd");
		// end = TypeConverter.convertDate2String(endTime, "yyyy-MM-dd");
		resultJson = xkHealthMachineService
				.getXKHealthMachineList(IDNumbers, JCXM, page.getCurrentPage(),
						page.getPageSize(), start, end, "");

		if (resultJson != "") {

			// 解析json
			XKHealthMachineCloud xk = JSON.parseObject(resultJson,
					XKHealthMachineCloud.class);
			// 获取数据失败直接返回页面
			if (xk.getCode() == 0) {
				// 解析json
				String jsonString = xk.getPage().getResult();
				theItems = (List<XKHealthMachine>) JSONArray.parseArray(
						jsonString, XKHealthMachine.class);

				pagenumT = xk.getPage().getTotal();
				for (int i = 0; i < theItems.size(); i++) {

				}
			}

		}
		// //用于时间回显
		// start=TypeConverter.convertDate2String(startTime, "yyyy-MM-dd");
		// end=TypeConverter.convertDate2String(endTime, "yyyy-MM-dd");
		page.setTotalNum(pagenumT);
		page.setCurrentPage(cp);
		currentPage = page.getCurrentPage();
		this.pageHtml = page.getPage("xkHealthMachineAction!getList.action");

		return "getList";
	}

	/**
	 * 查询记录
	 * 
	 * @return
	 */
	public String getListByCX2() {
		// 分页
		Page<XKHealthMachine> page = new Page<XKHealthMachine>();
		page.setCurrentPage(cp);
		String resultJson = "";

		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group = (TCommunityHospitalGroup) session
				.getAttribute("communityHospitalGroup");
		// 从session里拿到当前登录用户的id
		int person = GetSessionPerson.getPerson();
		if ((PersonName == null && IDNumber == null)
				|| (PersonName.equals("") && IDNumber.equals(""))) {// 没有按姓名、身份证号查询，则带出登录用户名下的所有老人

			// Page<THealthFile> page2 = new Page<THealthFile>();
			// page2.setTotalNum(healthFileService.getHealthFileCount());
			// healthFileList = healthFileService.getAllHealthFile(page2,
			// HealthFileCheck.zhengchang.getValue());// 得到档案正常的所有老人
			// if (healthFileList.size() > 0) {
			// for (THealthFile healthFile : healthFileList) {
			// IDNumbers += "," + healthFile.getIdNum();
			// }
			//
			// } else {
			// IDNumbers += ",-1";
			// }
			// IDNumbers = IDNumbers.substring(1);

			if (group != null) {// 集团管理员，可以看到集团下属所有社区医院（服务站）的内容
				voldStaff = healthFileService
						.getOldStaffsListByGroupAdmin(group.getGId());
				for (VOldStaff old : voldStaff) {
					if (old.getIdNum() == null || old.getIdNum().equals("")) {
						continue;
					}
					IDNumbers += "," + old.getIdNum();
				}
				if (IDNumbers.length() == 0) {
					IDNumbers += ",-1";
				}
				// IDNumbers = IDNumbers.substring(1);
			} else {

				// 平台管理员
				if (person == Admin_IsHead.guanliyuan.getValue()) {
					// 平台管理员查数据库所有档案list
					voldStaff = healthFileService.getOldStaffsListByPlatAdmin();
					if (voldStaff.size() > 0) {
						for (VOldStaff old : voldStaff) {
							if (old.getIdNum() == null
									|| old.getIdNum().equals("")) {
								continue;
							}
							IDNumbers += "," + old.getIdNum();
						}
						if (IDNumbers.length() == 0) {
							IDNumbers += ",-1";
						}
						// IDNumbers = IDNumbers.substring(1);
					} else {
						IDNumbers += ",-1";
						// IDNumbers = IDNumbers.substring(1);
					}

				}
				int staffId = -1;
				// 社区其他员工（含责任医生、其他员工）
				if (person > 0) {
					// pepl用于判断当前登陆员工是否是责任医生
					boolean pepl = healthFileService
							.getOldStaffHosByStaffId(person);

					// 责任医生
					if (pepl == true) {
						staffId = person;
						healthFileList = healthFileService
								.getHealthFileListByStaffIdForSpeciall(state,
										staffId);
						if (healthFileList.size() > 0) {
							for (THealthFile healthFile : healthFileList) {
								if (healthFile.getIdNum() == null
										|| healthFile.getIdNum().equals("")) {
									continue;
								}
								IDNumbers += "," + healthFile.getIdNum();
							}
							if (IDNumbers.length() == 0) {
								IDNumbers += ",-1";
							}

						} else {
							IDNumbers += ",-1";
						}
						// IDNumbers = IDNumbers.substring(1);

					}
					// 其他员工（普通员工或操作员，不常用，登录界面选医生登录）
					else {
						staffId = person;
						// 获取当前普通员工所在医院实体
						int communityHospitalId = staffService
								.getCommHospitalByStaffId(staffId);
						// 获取普通员工所辖的医院 整个医院的档案list
						voldStaff = healthFileService
								.getOldStaffsListBycommunityid(communityHospitalId);
						if (voldStaff.size() > 0) {
							for (VOldStaff old : voldStaff) {
								if (old.getIdNum() == null
										|| old.getIdNum().equals("")) {
									continue;
								}
								IDNumbers += "," + old.getIdNum();
							}
							if (IDNumbers.length() == 0) {
								IDNumbers += ",-1";
							}
							// IDNumbers = IDNumbers.substring(1);
						} else {
							IDNumbers += ",-1";
							// IDNumbers = IDNumbers.substring(1);
						}

					}
				} else if (person < 0) {// 社区管理员（社区负责人）
					int communityHosiptalId = -person;

					voldStaff = healthFileService
							.getOldStaffsListBycommunityid(communityHosiptalId);
					if (voldStaff.size() > 0) {
						for (VOldStaff old : voldStaff) {
							if (old.getIdNum() == null
									|| old.getIdNum().equals("")) {
								continue;
							}
							IDNumbers += "," + old.getIdNum();
						}
						if (IDNumbers.length() == 0) {
							IDNumbers += ",-1";
						}
						// IDNumbers = IDNumbers.substring(1);
					} else {
						IDNumbers += ",-1";
						// IDNumbers = IDNumbers.substring(1);
					}
					// 获取一个社区的档案list
					// healthFileList=healthFileService.getOldStaffsListBycommunityid(communityHosiptalId);
				}
			}
		} else {// 按姓名或身份证号条件进行查询
			if (PersonName != null && !PersonName.equals("")) {// 按姓名条件查询
//				Page<THealthFile> page2 = new Page<THealthFile>();
//				page2.setTotalNum(healthFileService.getHealthFileCount());
//				healthFileList = healthFileService.getAllHealthFileByOldName(
//						page2, PersonName);// 得到档案正常的所有老人
//				if (healthFileList.size() > 0) {
//					for (THealthFile healthFile : healthFileList) {
//						IDNumbers += "," + healthFile.getIdNum();
//					}
//					// IDNumbers = IDNumbers.substring(1);
//				} else {
//					IDNumbers += ",-1";
//				}
				
				if (group != null) {// 集团管理员，可以看到集团下属所有社区医院（服务站）的内容
					voldStaff = healthFileService
							.getOldStaffsListByGroupAdminAndOldName(group.getGId(), PersonName);
					for (VOldStaff old : voldStaff) {
						if (old.getIdNum() == null || old.getIdNum().equals("")) {
							continue;
						}
						IDNumbers += "," + old.getIdNum();
					}
					if (IDNumbers.length() == 0) {
						IDNumbers += ",-1";
					}
					// IDNumbers = IDNumbers.substring(1);
				} else {

					// 平台管理员
					if (person == Admin_IsHead.guanliyuan.getValue()) {
						// 平台管理员查数据库所有档案list
						voldStaff = healthFileService.getOldStaffsListByPlatAdminAndOldName(PersonName);
						if (voldStaff.size() > 0) {
							for (VOldStaff old : voldStaff) {
								if (old.getIdNum() == null
										|| old.getIdNum().equals("")) {
									continue;
								}
								IDNumbers += "," + old.getIdNum();
							}
							if (IDNumbers.length() == 0) {
								IDNumbers += ",-1";
							}
							// IDNumbers = IDNumbers.substring(1);
						} else {
							IDNumbers += ",-1";
							// IDNumbers = IDNumbers.substring(1);
						}

					}
					int staffId = -1;
					// 社区其他员工（含责任医生、其他员工）
					if (person > 0) {
						// pepl用于判断当前登陆员工是否是责任医生
						boolean pepl = healthFileService
								.getOldStaffHosByStaffId(person);

						// 责任医生
						if (pepl == true) {
							staffId = person;
							voldStaff = healthFileService
									.getOldStaffsListBystaffIdAndOldName(staffId,
											PersonName);
							if (voldStaff.size() > 0) {
								for (VOldStaff v : voldStaff) {
									if (v.getIdNum() == null
											|| v.getIdNum().equals("")) {
										continue;
									}
									IDNumbers += "," + v.getIdNum();
								}
								if (IDNumbers.length() == 0) {
									IDNumbers += ",-1";
								}

							} else {
								IDNumbers += ",-1";
							}
							// IDNumbers = IDNumbers.substring(1);

						}
						// 其他员工（普通员工或操作员，不常用，登录界面选医生登录）
						else {
							staffId = person;
							// 获取当前普通员工所在医院实体
							voldStaff = healthFileService
									.getOldStaffsListBystaffIdAndOldName(staffId,
											PersonName);
							if (voldStaff.size() > 0) {
								for (VOldStaff old : voldStaff) {
									if (old.getIdNum() == null
											|| old.getIdNum().equals("")) {
										continue;
									}
									IDNumbers += "," + old.getIdNum();
								}
								if (IDNumbers.length() == 0) {
									IDNumbers += ",-1";
								}
								// IDNumbers = IDNumbers.substring(1);
							} else {
								IDNumbers += ",-1";
								// IDNumbers = IDNumbers.substring(1);
							}

						}
					} else if (person < 0) {// 社区管理员（社区负责人）
						int communityHosiptalId = -person;

						voldStaff = healthFileService
								.getOldStaffsListBycommunityidAndOldName(communityHosiptalId,PersonName);
						if (voldStaff.size() > 0) {
							for (VOldStaff old : voldStaff) {
								if (old.getIdNum() == null
										|| old.getIdNum().equals("")) {
									continue;
								}
								IDNumbers += "," + old.getIdNum();
							}
							if (IDNumbers.length() == 0) {
								IDNumbers += ",-1";
							}
							// IDNumbers = IDNumbers.substring(1);
						} else {
							IDNumbers += ",-1";
							// IDNumbers = IDNumbers.substring(1);
						}
						// 获取一个社区的档案list
						// healthFileList=healthFileService.getOldStaffsListBycommunityid(communityHosiptalId);
					}
				}
			}
			if (IDNumber != null && !IDNumber.equals("")) {// 按身份证号条件查询,首先判断是否是登录账号能够查看的老人，是：拼接到查询参数后；否：拼接"-1"。
				old = healthFileService.getHealthFileByIdCard(IDNumber);
				if (old != null) {
					if (group != null) {// 集团管理员 登录
						if (old.getGId() == group.getGId()) {
							IDNumbers += "," + IDNumber;
						} else {
							IDNumbers += ",-1";
						}
					} else {
						if (person == Admin_IsHead.guanliyuan.getValue()) {// 平台管理员，直接带上IDNumber，因为平台管理员可以看到所有老人信息
							IDNumbers += "," + IDNumber;
						} else {// 社区其他员工（含责任医生、其他员工）登录
							int staffId = -1;

							if (person > 0) {//责任医生 登录
								// pepl用于判断当前登陆员工是否是责任医生
								boolean pepl = healthFileService
										.getOldStaffHosByStaffId(person);

								// 责任医生
								if (pepl == true) {
									staffId = person;
									if (old.getStaffId() != null) {
                                       if(old.getStaffId()==staffId){//是责任医生的老人，能查看体检信息
                                    	   IDNumbers += ","+IDNumber;
                                       } else {//不是责任医生的老人，不能查看体检信息
                                    	   IDNumbers += ",-1";
                                       }
									}
								}
								// 其他员工（普通员工或操作员，不常用，登录界面选医生登录）
								else {
									staffId = person;
									// 获取当前普通员工所在医院实体
									int communityHospitalId = staffService
											.getCommHospitalByStaffId(staffId);
									 if(old.getCommunityHospitalId()!=null){
		                                	if(old.getCommunityHospitalId()==communityHospitalId){//是本医院（服务站）的老人，能查看体检信息
		                                		IDNumbers += ","+IDNumber;
		                                	} else {//不是本医院（服务站）的老人，不能查看体检信息
		                                		IDNumbers += ",-1";
		                                	}
		                                } else {
		                                	IDNumbers += ",-1";
		                                }
//									// 获取普通员工所辖的医院 整个医院的档案list
//									voldStaff = healthFileService
//											.getOldStaffsListBycommunityid(communityHospitalId);
//									if (voldStaff.size() > 0) {
//										for (VOldStaff old : voldStaff) {
//											if (old.getIdNum() == null
//													|| old.getIdNum()
//															.equals("")) {
//												continue;
//											}
//											IDNumbers += "," + old.getIdNum();
//										}
//										if (IDNumbers.length() == 0) {
//											IDNumbers += ",-1";
//										}
//										// IDNumbers = IDNumbers.substring(1);
//									} else {
//										IDNumbers += ",-1";
//										// IDNumbers = IDNumbers.substring(1);
//									}
//
								}
							} else if (person < 0) {// 社区管理员（社区负责人） 登录
								int communityHospitalId = -person;
                                if(old.getCommunityHospitalId()!=null){
                                	if(old.getCommunityHospitalId()==communityHospitalId){//是社区管理员的老人，能查看体检信息
                                		IDNumbers += ","+IDNumber;
                                	} else {//不是社区管理员的老人，不能查看体检信息
                                		IDNumbers += ",-1";
                                	}
                                } else {
                                	IDNumbers += ",-1";
                                }
							}
						}
					}

				} else {
					IDNumbers += ",-1";
				}

			}

		}
		IDNumbers = IDNumbers.substring(1);
		if (startTime != null && !startTime.equals("")) {
			start = TypeConverter.convertDate2String(startTime, "yyyy-MM-dd");
		}
		if (endTime != null && !endTime.equals("")) {
			end = TypeConverter.convertDate2String(endTime, "yyyy-MM-dd");
		}
		resultJson = xkHealthMachineService
				.getXKHealthMachineList(IDNumbers, JCXM, page.getCurrentPage(),
						page.getPageSize(), start, end, "");

		if (resultJson != "") {

			// 解析json
			XKHealthMachineCloud xk = JSON.parseObject(resultJson,
					XKHealthMachineCloud.class);
			// 获取数据失败直接返回页面
			if (xk.getCode() == 0) {
				// 解析json
				String jsonString = xk.getPage().getResult();
				theItems = (List<XKHealthMachine>) JSONArray.parseArray(
						jsonString, XKHealthMachine.class);

				pagenumT = xk.getPage().getTotal();
				for (int i = 0; i < theItems.size(); i++) {

				}
			}

		}
		// //用于时间回显
		// start = TypeConverter.convertDate2String(startTime, "yyyy-MM-dd");
		// end = TypeConverter.convertDate2String(endTime, "yyyy-MM-dd");
		page.setTotalNum(pagenumT);
		page.setCurrentPage(cp);
		currentPage = page.getCurrentPage();
		this.pageHtml = page
				.getPage("xkHealthMachineAction!getListByCX.action?IDNumber="
						+ IDNumber + "&JCXM=" + JCXM + "&startTime=" + start
						+ "&endTime=" + end + "&PersonName=" + PersonName);

		return "getListByCX";
	}
	
	/**
	 * 查询记录
	 * 
	 * @return
	 */
	public String getListByCX() {
		// 分页
		Page<XKHealthMachine> page = new Page<XKHealthMachine>();
		page.setCurrentPage(cp);
		String resultJson = "";

		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group = (TCommunityHospitalGroup) session
				.getAttribute("communityHospitalGroup");
		// 从session里拿到当前登录用户的id
		int person = GetSessionPerson.getPerson();
		if ((PersonName == null && IDNumber == null)
				|| (PersonName.equals("") && IDNumber.equals(""))) {// 没有按姓名、身份证号查询，则带出登录用户名下的所有老人

			// Page<THealthFile> page2 = new Page<THealthFile>();
			// page2.setTotalNum(healthFileService.getHealthFileCount());
			// healthFileList = healthFileService.getAllHealthFile(page2,
			// HealthFileCheck.zhengchang.getValue());// 得到档案正常的所有老人
			// if (healthFileList.size() > 0) {
			// for (THealthFile healthFile : healthFileList) {
			// IDNumbers += "," + healthFile.getIdNum();
			// }
			//
			// } else {
			// IDNumbers += ",-1";
			// }
			// IDNumbers = IDNumbers.substring(1);

			if (group != null) {// 集团管理员，可以看到集团下属所有社区医院（服务站）的内容
				voldStaff = healthFileService
						.getOldStaffsListByGroupAdmin(group.getGId());
				for (VOldStaff old : voldStaff) {
					if (old.getIdNum() == null || old.getIdNum().equals("")) {
						continue;
					}
					IDNumbers += "," + old.getIdNum();
				}
				if (IDNumbers.length() == 0) {
					IDNumbers += ",-1";
				}
				// IDNumbers = IDNumbers.substring(1);
			} else {

				// 平台管理员
				if (person == Admin_IsHead.guanliyuan.getValue()) {
					// 平台管理员查数据库所有档案list
					voldStaff = healthFileService.getOldStaffsListByPlatAdmin();
					if (voldStaff.size() > 0) {
						for (VOldStaff old : voldStaff) {
							if (old.getIdNum() == null
									|| old.getIdNum().equals("")) {
								continue;
							}
							IDNumbers += "," + old.getIdNum();
						}
						if (IDNumbers.length() == 0) {
							IDNumbers += ",-1";
						}
						// IDNumbers = IDNumbers.substring(1);
					} else {
						IDNumbers += ",-1";
						// IDNumbers = IDNumbers.substring(1);
					}

				}
				int staffId = -1;
				// 社区其他员工（含责任医生、其他员工）
				if (person > 0) {
					// pepl用于判断当前登陆员工是否是责任医生
					boolean pepl = healthFileService
							.getOldStaffHosByStaffId(person);

					// 责任医生
					if (pepl == true) {
						staffId = person;
						healthFileList = healthFileService
								.getHealthFileListByStaffIdForSpeciall(state,
										staffId);
						if (healthFileList.size() > 0) {
							for (THealthFile healthFile : healthFileList) {
								if (healthFile.getIdNum() == null
										|| healthFile.getIdNum().equals("")) {
									continue;
								}
								IDNumbers += "," + healthFile.getIdNum();
							}
							if (IDNumbers.length() == 0) {
								IDNumbers += ",-1";
							}

						} else {
							IDNumbers += ",-1";
						}
						// IDNumbers = IDNumbers.substring(1);

					}
					// 其他员工（普通员工或操作员，不常用，登录界面选医生登录）
					else {
						staffId = person;
						// 获取当前普通员工所在医院实体
						int communityHospitalId = staffService
								.getCommHospitalByStaffId(staffId);
						// 获取普通员工所辖的医院 整个医院的档案list
						voldStaff = healthFileService
								.getOldStaffsListBycommunityid(communityHospitalId);
						if (voldStaff.size() > 0) {
							for (VOldStaff old : voldStaff) {
								if (old.getIdNum() == null
										|| old.getIdNum().equals("")) {
									continue;
								}
								IDNumbers += "," + old.getIdNum();
							}
							if (IDNumbers.length() == 0) {
								IDNumbers += ",-1";
							}
							// IDNumbers = IDNumbers.substring(1);
						} else {
							IDNumbers += ",-1";
							// IDNumbers = IDNumbers.substring(1);
						}

					}
				} else if (person < 0) {// 社区管理员（社区负责人）
					int communityHosiptalId = -person;

					voldStaff = healthFileService
							.getOldStaffsListBycommunityid(communityHosiptalId);
					if (voldStaff.size() > 0) {
						for (VOldStaff old : voldStaff) {
							if (old.getIdNum() == null
									|| old.getIdNum().equals("")) {
								continue;
							}
							IDNumbers += "," + old.getIdNum();
						}
						if (IDNumbers.length() == 0) {
							IDNumbers += ",-1";
						}
						// IDNumbers = IDNumbers.substring(1);
					} else {
						IDNumbers += ",-1";
						// IDNumbers = IDNumbers.substring(1);
					}
					// 获取一个社区的档案list
					// healthFileList=healthFileService.getOldStaffsListBycommunityid(communityHosiptalId);
				}
			}
		} else {// 按姓名或身份证号条件进行查询
				if (group != null) {// 集团管理员，可以看到集团下属所有社区医院（服务站）的内容
					voldStaff = healthFileService
							.getOldStaffsListByGroupAdminAndOldNameIDNum(group.getGId(), PersonName, IDNumber);
					for (VOldStaff old : voldStaff) {
						if (old.getIdNum() == null || old.getIdNum().equals("")) {
							continue;
						}
						IDNumbers += "," + old.getIdNum();
					}
					if (IDNumbers.length() == 0) {
						IDNumbers += ",-1";
					}
					// IDNumbers = IDNumbers.substring(1);
				} else {

					// 平台管理员
					if (person == Admin_IsHead.guanliyuan.getValue()) {
						// 平台管理员查数据库所有档案list
						voldStaff = healthFileService.getOldStaffsListByPlatAdminAndOldNameIDNum(PersonName,IDNumber);
						if (voldStaff.size() > 0) {
							for (VOldStaff old : voldStaff) {
								if (old.getIdNum() == null
										|| old.getIdNum().equals("")) {
									continue;
								}
								IDNumbers += "," + old.getIdNum();
							}
							if (IDNumbers.length() == 0) {
								IDNumbers += ",-1";
							}
							// IDNumbers = IDNumbers.substring(1);
						} else {
							IDNumbers += ",-1";
							// IDNumbers = IDNumbers.substring(1);
						}

					}
					int staffId = -1;
					// 社区其他员工（含责任医生、其他员工）
					if (person > 0) {
						// pepl用于判断当前登陆员工是否是责任医生
						boolean pepl = healthFileService
								.getOldStaffHosByStaffId(person);

						// 责任医生
						if (pepl == true) {
							staffId = person;
							voldStaff = healthFileService
									.getOldStaffsListBystaffIdAndOldNameIDNum(staffId,
											PersonName,IDNumber);
							if (voldStaff.size() > 0) {
								for (VOldStaff v : voldStaff) {
									if (v.getIdNum() == null
											|| v.getIdNum().equals("")) {
										continue;
									}
									IDNumbers += "," + v.getIdNum();
								}
								if (IDNumbers.length() == 0) {
									IDNumbers += ",-1";
								}

							} else {
								IDNumbers += ",-1";
							}
							// IDNumbers = IDNumbers.substring(1);

						}
						// 其他员工（普通员工或操作员，不常用，登录界面选医生登录）
						else {
							staffId = person;
							// 获取当前普通员工所在医院实体
							voldStaff = healthFileService
									.getOldStaffsListBystaffIdAndOldNameIDNum(staffId,
											PersonName,IDNumber);
							if (voldStaff.size() > 0) {
								for (VOldStaff old : voldStaff) {
									if (old.getIdNum() == null
											|| old.getIdNum().equals("")) {
										continue;
									}
									IDNumbers += "," + old.getIdNum();
								}
								if (IDNumbers.length() == 0) {
									IDNumbers += ",-1";
								}
								// IDNumbers = IDNumbers.substring(1);
							} else {
								IDNumbers += ",-1";
								// IDNumbers = IDNumbers.substring(1);
							}

						}
					} else if (person < 0) {// 社区管理员（社区负责人）
						int communityHosiptalId = -person;

						voldStaff = healthFileService
								.getOldStaffsListBycommunityidAndOldNameIDNum(communityHosiptalId,PersonName,IDNumber);
						if (voldStaff.size() > 0) {
							for (VOldStaff old : voldStaff) {
								if (old.getIdNum() == null
										|| old.getIdNum().equals("")) {
									continue;
								}
								IDNumbers += "," + old.getIdNum();
							}
							if (IDNumbers.length() == 0) {
								IDNumbers += ",-1";
							}
							// IDNumbers = IDNumbers.substring(1);
						} else {
							IDNumbers += ",-1";
							// IDNumbers = IDNumbers.substring(1);
						}
						// 获取一个社区的档案list
						// healthFileList=healthFileService.getOldStaffsListBycommunityid(communityHosiptalId);
					}
				}
			
		}
		IDNumbers = IDNumbers.substring(1);
		if (startTime != null && !startTime.equals("")) {
			start = TypeConverter.convertDate2String(startTime, "yyyy-MM-dd");
		}
		if (endTime != null && !endTime.equals("")) {
			end = TypeConverter.convertDate2String(endTime, "yyyy-MM-dd");
		}
		resultJson = xkHealthMachineService
				.getXKHealthMachineList(IDNumbers, JCXM, page.getCurrentPage(),
						page.getPageSize(), start, end, "");

		if (resultJson != "") {

			// 解析json
			XKHealthMachineCloud xk = JSON.parseObject(resultJson,
					XKHealthMachineCloud.class);
			// 获取数据失败直接返回页面
			if (xk.getCode() == 0) {
				// 解析json
				String jsonString = xk.getPage().getResult();
				theItems = (List<XKHealthMachine>) JSONArray.parseArray(
						jsonString, XKHealthMachine.class);

				pagenumT = xk.getPage().getTotal();
				for (int i = 0; i < theItems.size(); i++) {

				}
			}

		}
		// //用于时间回显
		// start = TypeConverter.convertDate2String(startTime, "yyyy-MM-dd");
		// end = TypeConverter.convertDate2String(endTime, "yyyy-MM-dd");
		page.setTotalNum(pagenumT);
		page.setCurrentPage(cp);
		currentPage = page.getCurrentPage();
		this.pageHtml = page
				.getPage("xkHealthMachineAction!getListByCX.action?IDNumber="
						+ IDNumber + "&JCXM=" + JCXM + "&startTime=" + start
						+ "&endTime=" + end + "&PersonName=" + PersonName);

		return "getListByCX";
	}
	

	/**
	 * 展示详情
	 * 
	 * @return
	 */
	public String showDetail() {
		String resultJson = "";
		if (id != null) {
			resultJson = xkHealthMachineService.getXKHealthMachineById(id);
			if (resultJson != null && !resultJson.equals("")) {
				JSONObject obj = JSON.parseObject(resultJson);
				String item = obj.get("item") + "";
				if (item != null && !item.equals("")) {
					xkHealthMachine = JSON.parseObject(item,
							XKHealthMachine.class);
				}
			}
		}
		return "showDetail";
	}
}
