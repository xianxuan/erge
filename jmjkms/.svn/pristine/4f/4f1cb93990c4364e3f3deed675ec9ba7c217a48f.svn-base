package com.jmjk.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jmjk.action.base.BaseAction;
import com.jmjk.entity.TChronicDisease;
import com.jmjk.entity.TChronicFollow;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.TCoronaryHeartDisease;
import com.jmjk.entity.TDiabetsFollow;
import com.jmjk.entity.TDrugInformation;
import com.jmjk.entity.TFollowUpCardiovascular;
import com.jmjk.entity.THealthFile;
import com.jmjk.entity.THypertensiveFollow;
import com.jmjk.entity.TLifestyleGuide;
import com.jmjk.entity.TMaintainableEntry;
import com.jmjk.entity.TMentalFollow;
import com.jmjk.entity.TRegistrationOtherDiseases;
import com.jmjk.entity.TSign;
import com.jmjk.entity.view.VCardiovascularFollow;
import com.jmjk.entity.view.VChronic;
import com.jmjk.entity.view.VCoronaryFollow;
import com.jmjk.entity.view.VDiabetsFollow;
import com.jmjk.entity.view.VHealthStaff;
import com.jmjk.entity.view.VHypertensiveFollow;
import com.jmjk.entity.view.VMentalFollow;
import com.jmjk.entity.view.VOtherillFollow;
import com.jmjk.enums.HealthFileCheck;
import com.jmjk.service.AllChronicDiseaseService;
import com.jmjk.service.ChronicFollowService;
import com.jmjk.service.CoronaryHeartService;
import com.jmjk.service.DiabetesService;
import com.jmjk.service.HealthFileService;
import com.jmjk.service.HeartAndCerebralService;
import com.jmjk.service.HighBloodPressureService;
import com.jmjk.service.LifeAndSignService;
import com.jmjk.service.MaintainableAttributeService;
import com.jmjk.service.OtherIllFollowService;
import com.jmjk.service.PsychosisService;
import com.jmjk.service.SituationOfMedicationService;
import com.jmjk.service.StaffService;
import com.jmjk.service.VchronicFollowService;
import com.jmjk.utils.ChronicVerifyFollow;
import com.jmjk.utils.GetSessionPerson;
import com.jmjk.utils.Page;
import com.jmjk.utils.Resubmit;
import com.jmjk.utils.TokenProccessor;

/**
 * 随访记录action
 * 
 * @author 李卓远
 *
 */
@Scope("prototype")
@Component
@Action(value = "oldChronicFollowAction", results = {
//		@Result(name = "gxyEmbeded", location = "/jsp/incompleteRecord2/addGxysfPart.jsp"),
//		@Result(name = "tnbEmbeded", location = "/jsp/incompleteRecord2/addTnbsfPart.jsp"),
		@Result(name = "gxy", location = "/jsp/oldfile/follow/addHighBloodFollow.jsp"),
		@Result(name = "tnb", location = "/jsp/oldfile/follow/addDiabets.jsp"),
		@Result(name = "jsb", location = "/jsp/oldfile/follow/addMental.jsp"),
		@Result(name = "gxb", location = "/jsp/oldfile/follow/addCornaryFollow.jsp"),
		@Result(name = "xn", location = "/jsp/oldfile/follow/addCardiovascularFollow.jsp"),
		@Result(name = "qt", location = "/jsp/oldfile/follow/addOtherIll.jsp"),
		@Result(name = "gxyf", location = "/jsp/oldfile/follow/homePageFollow.jsp"),
		@Result(name = "tnbf", location = "/jsp/oldfile/follow/homePageFollow1.jsp"),
		@Result(name = "jsbf", location = "/jsp/oldfile/follow/homePageFollow2.jsp"),
		@Result(name = "gxbf", location = "/jsp/oldfile/follow/homePageFollow3.jsp"),
		@Result(name = "xnf", location = "/jsp/oldfile/follow/homePageFollow4.jsp"),
		@Result(name = "qtf", location = "/jsp/oldfile/follow/homePageFollow5.jsp"),
		@Result(name = "xnfc", location = "/jsp/oldfile/follow/showCardiovascularFollow.jsp"),
		@Result(name = "tnbfc", location = "/jsp/oldfile/follow/showDiabetsFollow.jsp"),
		@Result(name = "jsbfc", location = "/jsp/oldfile/follow/showMentalFollow.jsp"),
		@Result(name = "gxbfc", location = "/jsp/oldfile/follow/showCornaryFollow.jsp"),
		@Result(name = "gxyfc", location = "/jsp/oldfile/follow/showHighBloodFollow.jsp"),
		@Result(name = "qtfc", location = "/jsp/oldfile/follow/showOtherIllFollow.jsp"),
		@Result(name = "xnfb", location = "/jsp/oldfile/follow/editCardFollow.jsp"),
		@Result(name = "gxbfb", location = "/jsp/oldfile/follow/editCornaryFollow.jsp"),
		@Result(name = "gxyfb", location = "/jsp/oldfile/follow/editHighBloodFollow.jsp"),
		@Result(name = "tnbfb", location = "/jsp/oldfile/follow/editDiabetsFollow.jsp"),
		@Result(name = "jsbfb", location = "/jsp/oldfile/follow/editMentalFollow.jsp"),
		@Result(name = "qtfb", location = "/jsp/oldfile/follow/editOtherIll.jsp"),
		@Result(name = "error", location = "/error.jsp"),
		@Result(name = "editCardFollow", type = "redirectAction", params = {
				"cid", "${cid}", "hid", "${hid}" }, location = "oldChronicFollowAction!showOneAllFollow.action"),
		@Result(name = "editCornaryFollow", type = "redirectAction", params = {
				"cid", "${cid}", "hid", "${hid}" }, location = "oldChronicFollowAction!showOneAllFollow.action"),
		@Result(name = "editHighBloodFollow", type = "redirectAction", params = {
				"cid", "${cid}", "hid", "${hid}" }, location = "oldChronicFollowAction!showOneAllFollow.action"),
		@Result(name = "editDiabetsFollow", type = "redirectAction", params = {
				"cid", "${cid}", "hid", "${hid}" }, location = "oldChronicFollowAction!showOneAllFollow.action"),
		@Result(name = "editMentalFollow", type = "redirectAction", params = {
				"cid", "${cid}", "hid", "${hid}" }, location = "oldChronicFollowAction!showOneAllFollow.action"),
		@Result(name = "editOtherIllFollow", type = "redirectAction", params = {
				"cid", "${cid}", "hid", "${hid}" }, location = "oldChronicFollowAction!showOneAllFollow.action"),
		@Result(name = "deleteFollow", type = "redirectAction", params = {
				"cid", "${cid}", "hid", "${hid}" }, location = "oldChronicFollowAction!showOneAllFollow.action"),
		@Result(name = "addHighFollow", type = "redirectAction", location = "showOldChronicAction!firstShowChronic.action"),
		@Result(name = "addMental", type = "redirectAction", location = "showOldChronicAction!firstShowChronic.action"),
		@Result(name = "addCoronary", type = "redirectAction", location = "showOldChronicAction!firstShowChronic.action"),
		@Result(name = "addCarddiovascular", type = "redirectAction", location = "showOldChronicAction!firstShowChronic.action"),
		@Result(name = "addOtherIll", type = "redirectAction", location = "showOldChronicAction!firstShowChronic.action"),
		@Result(name = "addDiabets", type = "redirectAction", location = "showOldChronicAction!firstShowChronic.action"),
		@Result(name = "no", type = "redirectAction", params = { "cid",
				"${cid}", "hid", "${hid}" }, location = "oldChronicFollowAction!jumpAddFollow.action"),
//		@Result(name = "addHighFollowFromEmbeded", type = "redirectAction", location = "incompleteRecordAction2!showIncompleteRecord.action"),
//		@Result(name = "noFromEmbeded", type = "redirectAction", location = "incompleteRecordAction2!showIncompleteRecord.action")
		

})
public class OldChronicFollowAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	@Autowired
	private ChronicFollowService chFollowService;// 慢病随访总表
	@Autowired
	private AllChronicDiseaseService allChronicDiseaseService;// 慢病总表
	@Autowired
	private HighBloodPressureService highBloodPressureService;// 高血压及随访记录表
	@Autowired
	private LifeAndSignService lifeAndSignService;// 生活指导表
	@Autowired
	private DiabetesService diabetesService;// 糖尿病及随访记录表
	@Autowired
	private SituationOfMedicationService sOfMedicationService;// 用药情况表
	@Autowired
	private HealthFileService healthFileService;// 健康档案表
	@Autowired
	private PsychosisService psychosisService;// 重性精神疾病及随访记录表
	@Autowired
	private CoronaryHeartService coronaryHeartService;// 冠心病及随访记录表
	@Autowired
	private HeartAndCerebralService heartAndCerebralService;// 心脑血管及随访记录表
	@Autowired
	private OtherIllFollowService otherIllFollowService;// 其他随访记录
	@Autowired
	private VchronicFollowService vchronicFollowService;// 慢病随访记录视图
	@Autowired
	StaffService staffservice;
	@Autowired
	MaintainableAttributeService maintainableAttributeService;// 可维护字段

	ChronicVerifyFollow chronicVerifyFollow = new ChronicVerifyFollow();

	private TRegistrationOtherDiseases otherill;// 其他疾病随访记录接口（肿瘤、慢性支气管病、残疾障碍随访记录）
	private TFollowUpCardiovascular followcardheart;// 心脑血管病随访记录实体
	private TCoronaryHeartDisease cheart;// 冠心病随访记录实体
	private TChronicFollow chronicFollow;// 慢病随访总表实体
	private THypertensiveFollow thypertensiveFollow;// 高血压随访记录实体
	private TDiabetsFollow diabetsFollow;// 糖尿病随访实体
	private TMentalFollow mentalFollow;// 重性精神疾病随访记录实体
	private TLifestyleGuide lifestyleGuide;// 生活方式指导实体
	private TChronicDisease chronicDisease;// 慢病总表实体
	private TSign sign;// 体征表实体
	private TDrugInformation drugInformation;// 用药情况表实体
	private THealthFile healthFile;// 健康档案实体
	private VChronic chronic;// 慢病档案视图实体
	private List<VChronic> vcList;// 慢病档案视图实体集合
	private List<TChronicFollow> cflist;// 慢病随访记录实体集合
	private int hid;// 健康档案id
	private int cid;// 慢病总表id
	private int sqid;// 社区医院id（暂时无法使用）
	private int fcid;// 慢病随访总表id
	private List<TDrugInformation> listdrug;// 用药情况实体集合
	private VCardiovascularFollow cardiovascularfollow;// 心脑血管随访记录视图实体
	private VCoronaryFollow coronaryFollow;// 冠心病随访记录视图实体
	private VDiabetsFollow diabetsfollowview;// 糖尿病随访记录视图实体
	private VHypertensiveFollow hypertensiveFollow;// 高血压随访记录视图实体
	private VMentalFollow mentalfollowview;// 重性精神疾病随访记录视图实体
	private VOtherillFollow otherillFollow;// 其他疾病随访记录视图实体
	private List<VCardiovascularFollow> calist;// 心脑血管随访集合
	private List<VCoronaryFollow> colist;// 冠心病随访集合
	private List<VHypertensiveFollow> hylist;// 高血压随访集合
	private List<VMentalFollow> melist;// 重型精神疾病随访集合
	private List<VOtherillFollow> otlist;// 其他随访记录集合（慢性支气管病，肿瘤，残疾障碍）
	private List<VDiabetsFollow> dilist;// 糖尿病随访集合
	private String pageHtml;// 分页
	private int cp = 1;// 分页
	private Page page;
	private int xnid;// 心脑血管随访id
	private int gxbid;// 冠心病随访id
	private int gxyid;// 高血压随访记录id
	private int tnbid;// 糖尿病随访记录id
	private int jsbid;// 重性精神疾病随访记录id
	private int qtid;// 其他慢病随访id(包括 残疾障碍,肿瘤,慢性支气管病)
	private int signid;// 体征表id
	private int lifeid;// 生活方式指导表id
	private String htype;// 健康档案状态
	private String token;
	private VHealthStaff vhealthstaff;//健康档案社区医院老人视图
	
	

	/**
	 * 获取员工社区id
	 * 
	 * @return
	 */
	public int getNowSqid() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group = (TCommunityHospitalGroup) session
				.getAttribute("communityHospitalGroup");
		if (group != null) {
			return -1;
		}else{
			// 从session里拿到当前登录用户的id
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

	/**
	 * 防止重复提交的方法的前提
	 */
	public void Repetition(){
		token = TokenProccessor.getInstance().makeToken();//创建令牌
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
	}
	
	/**
	 * 跳转到添加随访记录的方法
	 * 
	 * @return
	 */
	public String jumpAddFollow() {
		Repetition();
		chronicVerifyFollow.setCid(cid);
		chronicVerifyFollow.setHid(hid);
		if (chronicVerifyFollow.verifyFollow() == false) {
			return "error";
		}
		healthFile = healthFileService.getHealthFileById(hid);
		chronicDisease = allChronicDiseaseService.getChronicDiseaseByID(cid);
		String name = chronicDisease.getDiseaseName();
		if (name.equals("高血压")) {
			gxyf();
			return "gxy";
		} else if (name.equals("糖尿病")) {
			tnbsf();
			return "tnb";
		} else if (name.equals("重性精神疾病")) {
			zxjsbsf();
			return "jsb";
		} else if (name.equals("冠心病")) {
			gxbsf();
			return "gxb";
		} else if (name.equals("心脑血管病")) {
			xnsf();
			return "xn";
		}
		qtjbsf();
		return "qt";
	}

	/**
	 * 门诊接诊跳转到添加随访记录的方法
	 * 
	 * @return
	 */
	public String jumpAddFollowFromEmbeded() {
		Repetition();
		chronicVerifyFollow.setCid(cid);
		chronicVerifyFollow.setHid(hid);
		if (chronicVerifyFollow.verifyFollow() == false) {
			return "error";
		}
		healthFile = healthFileService.getHealthFileById(hid);
		chronicDisease = allChronicDiseaseService.getChronicDiseaseByID(cid);
		String name = chronicDisease.getDiseaseName();
		if (name.equals("高血压")) {
			gxyf();
			return "gxyEmbeded";
		} else if (name.equals("糖尿病")) {
			tnbsf();
			return "tnbEmbeded";
		} 
//		else if (name.equals("重性精神疾病")) {
//			zxjsbsf();
//			return "jsb";
//		} else if (name.equals("冠心病")) {
//			gxbsf();
//			return "gxb";
//		} else if (name.equals("心脑血管病")) {
//			xnsf();
//			return "xn";
//		}
		qtjbsf();
		return "qt";
	}
	
	/**
	 * 添加高血压随访记录
	 * 
	 * @return
	 */
	public String addHighFollow() {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "addHighFollow";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		
		if (chronicFollow.getFollowDate() == null
				|| chronicFollow.getFollowPeople() == null) {
			return "no";
		}
		healthFile = healthFileService.getHealthFileById(hid);// 用于校验死亡
																// 或注销的人不能添加
		if (healthFile.getHealthFileType().equals(
				String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| healthFile.getHealthFileType().equals(
						String.valueOf(HealthFileCheck.siwang.getValue()))) {
			return "error";// 用于校验死亡 或注销的人不能添加
		}
		chronicDisease = allChronicDiseaseService.getChronicDiseaseByID(cid);
		chronicFollow.setTChronicDisease(chronicDisease);
		int m = chFollowService.saveTChronicFollow(chronicFollow);
		chronicFollow = chFollowService.getChronicFollowByMbsfId(m);
		lifestyleGuide = lifeAndSignService.getLifeGuideById(lifeAndSignService
				.saveLifeGuide(lifestyleGuide));
		sign = lifeAndSignService
				.getSignById(lifeAndSignService.saveSign(sign));
		thypertensiveFollow.setTChronicFollow(chronicFollow);
		thypertensiveFollow.setTLifestyleGuide(lifestyleGuide);
		thypertensiveFollow.setTSign(sign);
		highBloodPressureService.saveHyp_Follow(thypertensiveFollow);
		thypertensiveFollow = highBloodPressureService
				.getHyp_FollowByHfid(highBloodPressureService
						.saveHyp_Follow(thypertensiveFollow));
		for (int i = 0; i < listdrug.size(); i++) {
			TDrugInformation t = listdrug.get(i);
			t.setTHypertensiveFollow(thypertensiveFollow);
		}
		sOfMedicationService.saveListDrugInformation(listdrug);
		return "addHighFollow";
	}

	/**
	 * 添加高血压随访记录
	 * 从接诊记录中嵌入式页面跳转过来
	 * @return
	 */
	public String addHighFollowFromEmbeded() {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "addHighFollowFromEmbeded";  //重定向回接诊记录列表页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		
		if (chronicFollow.getFollowDate() == null
				|| chronicFollow.getFollowPeople() == null) {
			return "noFromEmbeded";
		}
		healthFile = healthFileService.getHealthFileById(hid);// 用于校验死亡
																// 或注销的人不能添加
		if (healthFile.getHealthFileType().equals(
				String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| healthFile.getHealthFileType().equals(
						String.valueOf(HealthFileCheck.siwang.getValue()))) {
			return "error";// 用于校验死亡 或注销的人不能添加
		}
		chronicDisease = allChronicDiseaseService.getChronicDiseaseByID(cid);
		chronicFollow.setTChronicDisease(chronicDisease);
		int m = chFollowService.saveTChronicFollow(chronicFollow);
		chronicFollow = chFollowService.getChronicFollowByMbsfId(m);
		lifestyleGuide = lifeAndSignService.getLifeGuideById(lifeAndSignService
				.saveLifeGuide(lifestyleGuide));
		sign = lifeAndSignService
				.getSignById(lifeAndSignService.saveSign(sign));
		thypertensiveFollow.setTChronicFollow(chronicFollow);
		thypertensiveFollow.setTLifestyleGuide(lifestyleGuide);
		thypertensiveFollow.setTSign(sign);
		highBloodPressureService.saveHyp_Follow(thypertensiveFollow);
		thypertensiveFollow = highBloodPressureService
				.getHyp_FollowByHfid(highBloodPressureService
						.saveHyp_Follow(thypertensiveFollow));
		for (int i = 0; i < listdrug.size(); i++) {
			TDrugInformation t = listdrug.get(i);
			t.setTHypertensiveFollow(thypertensiveFollow);
		}
		sOfMedicationService.saveListDrugInformation(listdrug);
		return "addHighFollowFromEmbeded";
	}

	
	/**
	 * 添加糖尿病随访记录
	 * 
	 * @return
	 */
	public String addDiabets() {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "addDiabets";  //重定向回接诊记录列表页面
		}
		request.getSession().removeAttribute("token");//移除session中的token
		
		if (chronicFollow.getFollowDate() == null
				|| chronicFollow.getFollowPeople() == null) {
			return "no";
		}
		healthFile = healthFileService.getHealthFileById(hid);// 用于校验死亡
																// 或注销的人不能添加
		if (healthFile.getHealthFileType().equals(
				String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| healthFile.getHealthFileType().equals(
						String.valueOf(HealthFileCheck.siwang.getValue()))) {
			return "error";// 用于校验死亡 或注销的人不能添加
		}
		chronicDisease = allChronicDiseaseService.getChronicDiseaseByID(cid);
		chronicFollow.setTChronicDisease(chronicDisease);
		int m = chFollowService.saveTChronicFollow(chronicFollow);
		chronicFollow = chFollowService.getChronicFollowByMbsfId(m);
		lifestyleGuide = lifeAndSignService.getLifeGuideById(lifeAndSignService
				.saveLifeGuide(lifestyleGuide));
		sign = lifeAndSignService
				.getSignById(lifeAndSignService.saveSign(sign));
		diabetsFollow.setTChronicFollow(chronicFollow);
		diabetsFollow.setTLifestyleGuide(lifestyleGuide);
		diabetsFollow.setTSign(sign);
		diabetesService.saveDiabetsFollow(diabetsFollow);
		diabetsFollow = diabetesService.getDiabetsFollowByTfId(diabetesService
				.saveDiabetsFollow(diabetsFollow));
		for (int i = 0; i < listdrug.size(); i++) {
			TDrugInformation t = listdrug.get(i);
			t.setTDiabetsFollow(diabetsFollow);
		}
		sOfMedicationService.saveListDrugInformation(listdrug);
		return "addDiabets";
	}

	/**
	 * 添加糖尿病随访记录
	 * 从接诊记录页面跳转进来
	 * @return
	 */
	public String addDiabetsFromEmbeded() {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "addHighFollow";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		
		if (chronicFollow.getFollowDate() == null
				|| chronicFollow.getFollowPeople() == null) {
			return "no";
		}
		healthFile = healthFileService.getHealthFileById(hid);// 用于校验死亡
																// 或注销的人不能添加
		if (healthFile.getHealthFileType().equals(
				String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| healthFile.getHealthFileType().equals(
						String.valueOf(HealthFileCheck.siwang.getValue()))) {
			return "error";// 用于校验死亡 或注销的人不能添加
		}
		chronicDisease = allChronicDiseaseService.getChronicDiseaseByID(cid);
		chronicFollow.setTChronicDisease(chronicDisease);
		int m = chFollowService.saveTChronicFollow(chronicFollow);
		chronicFollow = chFollowService.getChronicFollowByMbsfId(m);
		lifestyleGuide = lifeAndSignService.getLifeGuideById(lifeAndSignService
				.saveLifeGuide(lifestyleGuide));
		sign = lifeAndSignService
				.getSignById(lifeAndSignService.saveSign(sign));
		diabetsFollow.setTChronicFollow(chronicFollow);
		diabetsFollow.setTLifestyleGuide(lifestyleGuide);
		diabetsFollow.setTSign(sign);
		diabetesService.saveDiabetsFollow(diabetsFollow);
		diabetsFollow = diabetesService.getDiabetsFollowByTfId(diabetesService
				.saveDiabetsFollow(diabetsFollow));
		for (int i = 0; i < listdrug.size(); i++) {
			TDrugInformation t = listdrug.get(i);
			t.setTDiabetsFollow(diabetsFollow);
		}
		sOfMedicationService.saveListDrugInformation(listdrug);
		return "addDiabets";
	}
	
	/**
	 * 添加重性精神疾病随访记录
	 * 
	 * @return
	 */
	public String addMental() {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "addHighFollow";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		
		if (chronicFollow.getFollowDate() == null
				|| chronicFollow.getFollowPeople() == null) {
			return "no";
		}
		healthFile = healthFileService.getHealthFileById(hid);// 用于校验死亡
																// 或注销的人不能添加
		if (healthFile.getHealthFileType().equals(
				String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| healthFile.getHealthFileType().equals(
						String.valueOf(HealthFileCheck.siwang.getValue()))) {
			return "error";// 用于校验死亡 或注销的人不能添加
		}
		chronicDisease = allChronicDiseaseService.getChronicDiseaseByID(cid);
		chronicFollow.setTChronicDisease(chronicDisease);
		int m = chFollowService.saveTChronicFollow(chronicFollow);
		chronicFollow = chFollowService.getChronicFollowByMbsfId(m);
		mentalFollow.setTChronicFollow(chronicFollow);
		psychosisService.saveMentalFollow(mentalFollow);
		mentalFollow = psychosisService.getMentalFollowByJfId(psychosisService
				.saveMentalFollow(mentalFollow));
		for (int i = 0; i < listdrug.size(); i++) {
			TDrugInformation t = listdrug.get(i);
			t.setTMentalFollow(mentalFollow);
		}
		sOfMedicationService.saveListDrugInformation(listdrug);
		return "addMental";
	}

	/**
	 * 添加冠心病随访记录
	 * 
	 * @return
	 */
	public String addCoronary() {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "addHighFollow";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		
		if (chronicFollow.getFollowDate() == null
				|| chronicFollow.getFollowPeople() == null) {
			return "no";
		}
		healthFile = healthFileService.getHealthFileById(hid);// 用于校验死亡
																// 或注销的人不能添加
		if (healthFile.getHealthFileType().equals(
				String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| healthFile.getHealthFileType().equals(
						String.valueOf(HealthFileCheck.siwang.getValue()))) {
			return "error";// 用于校验死亡 或注销的人不能添加
		}
		chronicDisease = allChronicDiseaseService.getChronicDiseaseByID(cid);
		chronicFollow.setTChronicDisease(chronicDisease);
		int m = chFollowService.saveTChronicFollow(chronicFollow);
		chronicFollow = chFollowService.getChronicFollowByMbsfId(m);
		cheart.setTChronicFollow(chronicFollow);
		cheart.setByFollowUp(healthFile.getName());
		coronaryHeartService.saveCoronaryHeartFollow(cheart);
		cheart = coronaryHeartService
				.getCoronaryHeartFollowByGxfId(coronaryHeartService
						.saveCoronaryHeartFollow(cheart));
		for (int i = 0; i < listdrug.size(); i++) {
			TDrugInformation t = listdrug.get(i);
			t.setTCoronaryHeartDisease(cheart);
		}
		sOfMedicationService.saveListDrugInformation(listdrug);
		return "addCoronary";
	}

	/**
	 * 添加心脑血管病随访记录
	 * 
	 * @return
	 */
	public String addCarddiovascular() {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "addHighFollow";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		
		if (chronicFollow.getFollowDate() == null
				|| chronicFollow.getFollowPeople() == null) {
			return "no";
		}
		healthFile = healthFileService.getHealthFileById(hid);// 用于校验死亡
																// 或注销的人不能添加
		if (healthFile.getHealthFileType().equals(
				String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| healthFile.getHealthFileType().equals(
						String.valueOf(HealthFileCheck.siwang.getValue()))) {
			return "error";// 用于校验死亡 或注销的人不能添加
		}
		chronicDisease = allChronicDiseaseService.getChronicDiseaseByID(cid);
		chronicFollow.setTChronicDisease(chronicDisease);
		int m = chFollowService.saveTChronicFollow(chronicFollow);
		chronicFollow = chFollowService.getChronicFollowByMbsfId(m);
		followcardheart.setTChronicFollow(chronicFollow);
		followcardheart.setFllowedUp(healthFile.getName());
		followcardheart = heartAndCerebralService
				.getFoUpByFid(heartAndCerebralService
						.saveFollowUp_Cardio(followcardheart));
		for (int i = 0; i < listdrug.size(); i++) {
			TDrugInformation t = listdrug.get(i);
			t.setTFollowUpCardiovascular(followcardheart);
		}
		sOfMedicationService.saveListDrugInformation(listdrug);
		return "addCarddiovascular";
	}

	/**
	 * 添加其他疾病方法（慢性支气管、肿瘤、残疾障碍）
	 * 
	 * @return
	 */
	public String addOtherIll() {
		
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "addHighFollow";  //重定向回首页
		}
		request.getSession().removeAttribute("token");//移除session中的token
		
		if (chronicFollow.getFollowDate() == null
				|| chronicFollow.getFollowPeople() == null) {
			return "no";
		}
		healthFile = healthFileService.getHealthFileById(hid);// 用于校验死亡
																// 或注销的人不能添加
		if (healthFile.getHealthFileType().equals(
				String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| healthFile.getHealthFileType().equals(
						String.valueOf(HealthFileCheck.siwang.getValue()))) {
			return "error";// 用于校验死亡 或注销的人不能添加
		}
		chronicDisease = allChronicDiseaseService.getChronicDiseaseByID(cid);
		chronicFollow.setTChronicDisease(chronicDisease);
		int m = chFollowService.saveTChronicFollow(chronicFollow);
		chronicFollow = chFollowService.getChronicFollowByMbsfId(m);
		sign = lifeAndSignService
				.getSignById(lifeAndSignService.saveSign(sign));
		otherill.setFollowedUp(healthFile.getName());
		otherill.setTChronicFollow(chronicFollow);
		otherill.setTSign(sign);
		otherIllFollowService.saveOtherIllFollow(otherill);
		otherill = otherIllFollowService
				.getOtherIllFollowByQtid(otherIllFollowService
						.saveOtherIllFollow(otherill));
		for (int i = 0; i < listdrug.size(); i++) {
			TDrugInformation t = listdrug.get(i);
			t.setTRegistrationOtherDiseases(otherill);
		}
		sOfMedicationService.saveListDrugInformation(listdrug);
		return "addOtherIll";
	}

	/**
	 * 删除慢病随访记录方法
	 * 
	 * @return
	 */
	public String deleteFollow() {
		chronicFollow = chFollowService.getChronicFollowByMbsfId(fcid);
		chFollowService.deleteTChronicFollow(chronicFollow);
		return "deleteFollow";
	}

	/**
	 * 通过疾病名称跳转到每种慢病随访记录的列表页
	 * 
	 * @return
	 */
	public String showOneAllFollow() {
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group = (TCommunityHospitalGroup) session
				.getAttribute("communityHospitalGroup");
		if(group != null){
			int gid = group.getGId();
			vhealthstaff = healthFileService.getGroup(hid);
			if(gid!=vhealthstaff.getGId()){
				return "error";
			}
		}else{
		// 从session里拿到当前登录用户的id
			int userId = GetSessionPerson.getPerson();

			chronicVerifyFollow.setCid(cid);
			chronicVerifyFollow.setHid(hid);
			if (chronicVerifyFollow.verifyFollow() == false) {
				return "error";
			}
		}
		getNowSqid();
		chronicDisease = allChronicDiseaseService.getChronicDiseaseByID(cid);
		healthFile = healthFileService.getHealthFileById(hid);
		String name = chronicDisease.getDiseaseName();
		if (name.equals("高血压")) {
			page = new Page<VHypertensiveFollow>();
			page.setCurrentPage(cp);
			page.setTotalNum(vchronicFollowService
					.getHypertensiveFollowListCount(cid));
			this.pageHtml = page
					.getPage("oldChronicFollowAction!showOneAllFollow.action?cid= "
							+ cid + " &hid= " + hid);

				hylist = vchronicFollowService
						.getHypertensiveFollowListForSupper(cid, page);

			return "gxyf";
		} else if (name.equals("糖尿病")) {
			page = new Page<VDiabetsFollow>();
			page.setCurrentPage(cp);
			page.setTotalNum(vchronicFollowService
					.getDiabetsFollowListCount(cid));
			this.pageHtml = page
					.getPage("oldChronicFollowAction!showOneAllFollow.action?cid="
							+ cid + "&hid=" + hid);

				dilist = vchronicFollowService.getDiabetsFollowListForSupper(
						cid, page);
			return "tnbf";
		} else if (name.equals("重性精神疾病")) {
			page = new Page<VMentalFollow>();
			page.setCurrentPage(cp);
			page.setTotalNum(vchronicFollowService
					.getMentalFollowLIstCount(cid));
			this.pageHtml = page
					.getPage("oldChronicFollowAction!showOneAllFollow.action?cid="
							+ cid + "&hid=" + hid);

				melist = vchronicFollowService.getMentalFollowLIstForSupper(
						cid, page);
			return "jsbf";
		} else if (name.equals("冠心病")) {
			page = new Page<VCoronaryFollow>();
			page.setCurrentPage(cp);
			page.setTotalNum(vchronicFollowService
					.getCoronaryFollowListCount(cid));
			this.pageHtml = page
					.getPage("oldChronicFollowAction!showOneAllFollow.action?cid= "
							+ cid + " &hid= " + hid);
				colist = vchronicFollowService.getCoronaryFollowListForSupper(
						cid, page);
			return "gxbf";
		} else if (name.equals("心脑血管病")) {
			page = new Page<VCardiovascularFollow>();
			page.setCurrentPage(cp);
			page.setTotalNum(vchronicFollowService.getCardFollowListCount(cid));
			this.pageHtml = page
					.getPage("oldChronicFollowAction!showOneAllFollow.action?cid= "
							+ cid + " &hid= " + hid);
				calist = vchronicFollowService.getCardFollowListForSupper(cid,
						page);
			return "xnf";
		}
		page = new Page<VOtherillFollow>();
		page.setCurrentPage(cp);
		page.setTotalNum(vchronicFollowService.getOtherillFollowListCount(cid));
		this.pageHtml = page
				.getPage("oldChronicFollowAction!showOneAllFollow.action?cid= "
						+ cid + " &hid= " + hid);
			otlist = vchronicFollowService.getOtherillFollowListForSupper(cid,
					page);
		return "qtf";
	}

	/**
	 * 得到每种慢病随访记录的视图实体用于展示
	 * 
	 * @return
	 */
	public String jumpShowFollow() {
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group = (TCommunityHospitalGroup) session
				.getAttribute("communityHospitalGroup");
		if(group != null){
			int gid = group.getGId();
			vhealthstaff = healthFileService.getGroup(hid);
			if(gid!=vhealthstaff.getGId()){
				return "error";
			}
		}else{
		
			// 从session里拿到当前登录用户的id
			int userId = GetSessionPerson.getPerson();

			chronicVerifyFollow.setCid(cid);
			chronicVerifyFollow.setHid(hid);
			chronicVerifyFollow.setCfid(fcid);
			if (chronicVerifyFollow.verifyFollow() == false) {
				return "error";
			}
		}
		getNowSqid();
		chronicDisease = allChronicDiseaseService.getChronicDiseaseByID(cid);
		healthFile = healthFileService.getHealthFileById(hid);
		String name = chronicDisease.getDiseaseName();
		if (name.equals("高血压")) {
				hypertensiveFollow = vchronicFollowService
						.getHypertensiveFollowForSupper(fcid);
			int hfid = hypertensiveFollow.getHypertensiveFollowId();
			listdrug = sOfMedicationService.getDrugInformationByGxyId(hfid);
			return "gxyfc";
		} else if (name.equals("糖尿病")) {
				diabetsfollowview = vchronicFollowService
						.getDiabetsFollowForSupper(fcid);
			int did = diabetsfollowview.getDiabetsFollowId();
			listdrug = sOfMedicationService.getDrugInformationByTnbId(did);
			return "tnbfc";
		} else if (name.equals("重性精神疾病")) {
				mentalfollowview = vchronicFollowService
						.getMentalFollowvForSupper(fcid);
			int mid = mentalfollowview.getMentalFollowId();
			listdrug = sOfMedicationService.getDrugInformationByJsbId(mid);
			return "jsbfc";
		} else if (name.equals("冠心病")) {
				coronaryFollow = vchronicFollowService
						.getCoronaryFollowForSupper(fcid);
			int coid = coronaryFollow.getCoronaryHeartDiseaseId();
			listdrug = sOfMedicationService.getDrugInformationByGxbId(coid);
			return "gxbfc";
		} else if (name.equals("心脑血管病")) {
				cardiovascularfollow = vchronicFollowService
						.getcardfollowForSupper(fcid);
			int caid = cardiovascularfollow.getFollowUpCardiovascularId();
			listdrug = sOfMedicationService.getDrugInformationByXnId(caid);
			return "xnfc";
		}
			otherillFollow = vchronicFollowService
					.getOtherillFollowForSupper(fcid);
		int oid = otherillFollow.getTRegOthDisId();
		listdrug = sOfMedicationService.getDrugInformationByQtId(oid);
		return "qtfc";
	}

	/**
	 * 跳转到编辑随访记录方法
	 * 
	 * @return
	 */
	public String jumpEditFollow() {
		chronicVerifyFollow.setCid(cid);
		chronicVerifyFollow.setHid(hid);
		chronicVerifyFollow.setCfid(fcid);
		if (chronicVerifyFollow.verifyFollow() == false) {
			return "error";
		}
		getNowSqid();
		chronicDisease = allChronicDiseaseService.getChronicDiseaseByID(cid);
		healthFile = healthFileService.getHealthFileById(hid);
		String name = chronicDisease.getDiseaseName();
		if (name.equals("高血压")) {
			gxyf();
			hypertensiveFollow = vchronicFollowService.getHypertensiveFollow(
					fcid, sqid);// 当前sqid默认暂时使用sqid
			int hfid = hypertensiveFollow.getHypertensiveFollowId();
			listdrug = sOfMedicationService.getDrugInformationByGxyId(hfid);
			return "gxyfb";
		} else if (name.equals("糖尿病")) {
			tnbsf();
			diabetsfollowview = vchronicFollowService.getDiabetsFollow(fcid,
					sqid);
			int did = diabetsfollowview.getDiabetsFollowId();
			listdrug = sOfMedicationService.getDrugInformationByTnbId(did);
			return "tnbfb";
		} else if (name.equals("重性精神疾病")) {
			zxjsbsf();
			mentalfollowview = vchronicFollowService
					.getMentalFollow(fcid, sqid);
			int mid = mentalfollowview.getMentalFollowId();
			listdrug = sOfMedicationService.getDrugInformationByJsbId(mid);
			return "jsbfb";
		} else if (name.equals("冠心病")) {
			gxbsf();
			coronaryFollow = vchronicFollowService
					.getCoronaryFollow(fcid, sqid);
			int coid = coronaryFollow.getCoronaryHeartDiseaseId();
			listdrug = sOfMedicationService.getDrugInformationByGxbId(coid);
			return "gxbfb";
		} else if (name.equals("心脑血管病")) {
			xnsf();
			cardiovascularfollow = vchronicFollowService.getcardfollow(fcid,
					sqid);
			int caid = cardiovascularfollow.getFollowUpCardiovascularId();
			listdrug = sOfMedicationService.getDrugInformationByXnId(caid);
			return "xnfb";
		}
		qtjbsf();
		otherillFollow = vchronicFollowService.getOtherillFollow(fcid, sqid);
		int oid = otherillFollow.getTRegOthDisId();
		listdrug = sOfMedicationService.getDrugInformationByQtId(oid);
		return "qtfb";
	}

	/**
	 * 编辑心脑血管随访记录方法
	 * 
	 * @return
	 */
	public String editCardFollow() {
		if (htype.equals(String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| htype.equals(String.valueOf(HealthFileCheck.siwang
						.getValue()))) {
			return "error";
		}
		List<TDrugInformation> list = sOfMedicationService
				.getDrugInformationByXnId(xnid);
		sOfMedicationService.deleteListDrugInformation(list);
		for (int i = 0; i < listdrug.size(); i++) {
			TDrugInformation t = listdrug.get(i);
			t.setTFollowUpCardiovascular(followcardheart);
		}
		sOfMedicationService.saveListDrugInformation(listdrug);
		followcardheart.setTChronicFollow(chronicFollow);
		heartAndCerebralService.editFollowUp_Cardio(followcardheart);
		return "editCardFollow";
	}

	/**
	 * 编辑冠心病随访记录方法
	 * 
	 * @return
	 */
	public String editCornaryFollow() {
		if (htype.equals(String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| htype.equals(String.valueOf(HealthFileCheck.siwang
						.getValue()))) {
			return "error";
		}
		List<TDrugInformation> list = sOfMedicationService
				.getDrugInformationByGxbId(gxbid);
		sOfMedicationService.deleteListDrugInformation(list);
		for (int i = 0; i < listdrug.size(); i++) {
			TDrugInformation t = listdrug.get(i);
			t.setTCoronaryHeartDisease(cheart);
		}
		sOfMedicationService.saveListDrugInformation(listdrug);
		cheart.setTChronicFollow(chronicFollow);
		coronaryHeartService.editCoronaryHeartFollow(cheart);
		return "editCornaryFollow";
	}

	/**
	 * 编辑高血压随访记录方法
	 * 
	 * @return
	 */
	public String editHighBloodFollow() {
		if (htype.equals(String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| htype.equals(String.valueOf(HealthFileCheck.siwang
						.getValue()))) {
			return "error";
		}
		List<TDrugInformation> list = sOfMedicationService
				.getDrugInformationByGxyId(gxyid);
		sOfMedicationService.deleteListDrugInformation(list);
		for (int i = 0; i < listdrug.size(); i++) {
			TDrugInformation t = listdrug.get(i);
			t.setTHypertensiveFollow(thypertensiveFollow);
		}
		sOfMedicationService.saveListDrugInformation(listdrug);
		thypertensiveFollow.setTLifestyleGuide(lifestyleGuide);
		thypertensiveFollow.setTSign(sign);
		thypertensiveFollow.setTChronicFollow(chronicFollow);
		sign.setSignId(signid);
		lifeAndSignService.editSign(sign);
		lifestyleGuide.setLifestyleGuideId(lifeid);
		lifeAndSignService.editLifeGuide(lifestyleGuide);
		highBloodPressureService.editHyp_Follow(thypertensiveFollow);
		return "editHighBloodFollow";
	}

	/**
	 * 编辑糖尿病随访记录方法
	 * 
	 * @return
	 */
	public String editDiabetsFollow() {
		if (htype.equals(String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| htype.equals(String.valueOf(HealthFileCheck.siwang
						.getValue()))) {
			return "error";
		}
		List<TDrugInformation> list = sOfMedicationService
				.getDrugInformationByTnbId(tnbid);
		sOfMedicationService.deleteListDrugInformation(list);
		for (int i = 0; i < listdrug.size(); i++) {
			TDrugInformation t = listdrug.get(i);
			t.setTDiabetsFollow(diabetsFollow);
		}
		sOfMedicationService.saveListDrugInformation(listdrug);
		diabetsFollow.setTLifestyleGuide(lifestyleGuide);
		diabetsFollow.setTSign(sign);
		diabetsFollow.setTChronicFollow(chronicFollow);
		sign.setSignId(signid);
		lifeAndSignService.editSign(sign);
		lifestyleGuide.setLifestyleGuideId(lifeid);
		lifeAndSignService.editLifeGuide(lifestyleGuide);
		diabetesService.editDiabetsFollow(diabetsFollow);
		return "editDiabetsFollow";
	}

	/**
	 * 编辑重性精神疾病随访记录方法
	 * 
	 * @return
	 */
	public String editMentalFollow() {
		if (htype.equals(String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| htype.equals(String.valueOf(HealthFileCheck.siwang
						.getValue()))) {
			return "error";
		}
		List<TDrugInformation> list = sOfMedicationService
				.getDrugInformationByJsbId(jsbid);
		sOfMedicationService.deleteListDrugInformation(list);
		for (int i = 0; i < listdrug.size(); i++) {
			TDrugInformation t = listdrug.get(i);
			t.setTMentalFollow(mentalFollow);
		}
		sOfMedicationService.saveListDrugInformation(listdrug);
		mentalFollow.setTChronicFollow(chronicFollow);
		psychosisService.editMentalFollow(mentalFollow);
		return "editMentalFollow";
	}

	/**
	 * 编辑其他疾病随访记录方法(包括 残疾障碍,慢性支气管病,肿瘤)
	 * 
	 * @return
	 */
	public String editOtherIllFollow() {
		if (htype.equals(String.valueOf(HealthFileCheck.zhuxiao.getValue()))
				|| htype.equals(String.valueOf(HealthFileCheck.siwang
						.getValue()))) {
			return "error";
		}
		List<TDrugInformation> list = sOfMedicationService
				.getDrugInformationByQtId(qtid);
		sOfMedicationService.deleteListDrugInformation(list);
		for (int i = 0; i < listdrug.size(); i++) {
			TDrugInformation t = listdrug.get(i);
			t.setTRegistrationOtherDiseases(otherill);
		}
		sOfMedicationService.saveListDrugInformation(listdrug);

		otherill.setTSign(sign);
		otherill.setTChronicFollow(chronicFollow);
		sign.setSignId(signid);
		lifeAndSignService.editSign(sign);
		otherIllFollowService.editOtherIllFollow(otherill);
		return "editOtherIllFollow";
	}

	public THypertensiveFollow getThypertensiveFollow() {
		return thypertensiveFollow;
	}

	public void setThypertensiveFollow(THypertensiveFollow thypertensiveFollow) {
		this.thypertensiveFollow = thypertensiveFollow;
	}

	public TDiabetsFollow getDiabetsFollow() {
		return diabetsFollow;
	}

	public void setDiabetsFollow(TDiabetsFollow diabetsFollow) {
		this.diabetsFollow = diabetsFollow;
	}

	public TLifestyleGuide getLifestyleGuide() {
		return lifestyleGuide;
	}

	public void setLifestyleGuide(TLifestyleGuide lifestyleGuide) {
		this.lifestyleGuide = lifestyleGuide;
	}

	public TChronicDisease getChronicDisease() {
		return chronicDisease;
	}

	public void setChronicDisease(TChronicDisease chronicDisease) {
		this.chronicDisease = chronicDisease;
	}

	public TSign getSign() {
		return sign;
	}

	public void setSign(TSign sign) {
		this.sign = sign;
	}

	public TDrugInformation getDrugInformation() {
		return drugInformation;
	}

	public void setDrugInformation(TDrugInformation drugInformation) {
		this.drugInformation = drugInformation;
	}

	public THealthFile getHealthFile() {
		return healthFile;
	}

	public void setHealthFile(THealthFile healthFile) {
		this.healthFile = healthFile;
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

	public VChronic getChronic() {
		return chronic;
	}

	public void setChronic(VChronic chronic) {
		this.chronic = chronic;
	}

	public List<VChronic> getVcList() {
		return vcList;
	}

	public void setVcList(List<VChronic> vcList) {
		this.vcList = vcList;
	}

	public int getSqid() {
		return sqid;
	}

	public void setSqid(int sqid) {
		this.sqid = sqid;
	}

	public TChronicFollow getChronicFollow() {
		return chronicFollow;
	}

	public void setChronicFollow(TChronicFollow chronicFollow) {
		this.chronicFollow = chronicFollow;
	}

	public TMentalFollow getMentalFollow() {
		return mentalFollow;
	}

	public void setMentalFollow(TMentalFollow mentalFollow) {
		this.mentalFollow = mentalFollow;
	}

	public TCoronaryHeartDisease getCheart() {
		return cheart;
	}

	public void setCheart(TCoronaryHeartDisease cheart) {
		this.cheart = cheart;
	}

	public TFollowUpCardiovascular getFollowcardheart() {
		return followcardheart;
	}

	public void setFollowcardheart(TFollowUpCardiovascular followcardheart) {
		this.followcardheart = followcardheart;
	}

	public TRegistrationOtherDiseases getOtherill() {
		return otherill;
	}

	public void setOtherill(TRegistrationOtherDiseases otherill) {
		this.otherill = otherill;
	}

	public int getFcid() {
		return fcid;
	}

	public void setFcid(int fcid) {
		this.fcid = fcid;
	}

	public List<TDrugInformation> getListdrug() {
		return listdrug;
	}

	public void setListdrug(List<TDrugInformation> listdrug) {
		this.listdrug = listdrug;
	}

	public VCoronaryFollow getCoronaryFollow() {
		return coronaryFollow;
	}

	public void setCoronaryFollow(VCoronaryFollow coronaryFollow) {
		this.coronaryFollow = coronaryFollow;
	}

	public VDiabetsFollow getDiabetsfollowview() {
		return diabetsfollowview;
	}

	public void setDiabetsfollowview(VDiabetsFollow diabetsfollowview) {
		this.diabetsfollowview = diabetsfollowview;
	}

	public VHypertensiveFollow getHypertensiveFollow() {
		return hypertensiveFollow;
	}

	public void setHypertensiveFollow(VHypertensiveFollow hypertensiveFollow) {
		this.hypertensiveFollow = hypertensiveFollow;
	}

	public VMentalFollow getMentalfollowview() {
		return mentalfollowview;
	}

	public void setMentalfollowview(VMentalFollow mentalfollowview) {
		this.mentalfollowview = mentalfollowview;
	}

	public VOtherillFollow getOtherillFollow() {
		return otherillFollow;
	}

	public void setOtherillFollow(VOtherillFollow otherillFollow) {
		this.otherillFollow = otherillFollow;
	}

	public List<TChronicFollow> getCflist() {
		return cflist;
	}

	public void setCflist(List<TChronicFollow> cflist) {
		this.cflist = cflist;
	}

	public VCardiovascularFollow getCardiovascularfollow() {
		return cardiovascularfollow;
	}

	public void setCardiovascularfollow(
			VCardiovascularFollow cardiovascularfollow) {
		this.cardiovascularfollow = cardiovascularfollow;
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

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public List<VCardiovascularFollow> getCalist() {
		return calist;
	}

	public void setCalist(List<VCardiovascularFollow> calist) {
		this.calist = calist;
	}

	public List<VCoronaryFollow> getColist() {
		return colist;
	}

	public void setColist(List<VCoronaryFollow> colist) {
		this.colist = colist;
	}

	public List<VHypertensiveFollow> getHylist() {
		return hylist;
	}

	public void setHylist(List<VHypertensiveFollow> hylist) {
		this.hylist = hylist;
	}

	public List<VMentalFollow> getMelist() {
		return melist;
	}

	public void setMelist(List<VMentalFollow> melist) {
		this.melist = melist;
	}

	public List<VOtherillFollow> getOtlist() {
		return otlist;
	}

	public void setOtlist(List<VOtherillFollow> otlist) {
		this.otlist = otlist;
	}

	public List<VDiabetsFollow> getDilist() {
		return dilist;
	}

	public void setDilist(List<VDiabetsFollow> dilist) {
		this.dilist = dilist;
	}

	public int getXnid() {
		return xnid;
	}

	public void setXnid(int xnid) {
		this.xnid = xnid;
	}

	public int getGxbid() {
		return gxbid;
	}

	public void setGxbid(int gxbid) {
		this.gxbid = gxbid;
	}

	public int getGxyid() {
		return gxyid;
	}

	public void setGxyid(int gxyid) {
		this.gxyid = gxyid;
	}

	public int getTnbid() {
		return tnbid;
	}

	public void setTnbid(int tnbid) {
		this.tnbid = tnbid;
	}

	public int getJsbid() {
		return jsbid;
	}

	public void setJsbid(int jsbid) {
		this.jsbid = jsbid;
	}

	public int getQtid() {
		return qtid;
	}

	public void setQtid(int qtid) {
		this.qtid = qtid;
	}

	public int getSignid() {
		return signid;
	}

	public void setSignid(int signid) {
		this.signid = signid;
	}

	public int getLifeid() {
		return lifeid;
	}

	public void setLifeid(int lifeid) {
		this.lifeid = lifeid;
	}

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
	// 重性精神病随访记录
	private List<TMaintainableEntry> wxx;// 危险性
	private List<TMaintainableEntry> zzl;// 自知力
	private List<TMaintainableEntry> smqk;// 睡眠情况
	private List<TMaintainableEntry> scld;// 生产劳动
	private List<TMaintainableEntry> hbdjtyx;// 患病对家庭影响
	private List<TMaintainableEntry> zyqk;// 住院情况
	private List<TMaintainableEntry> kfcs;// 康复措施
	private List<TMaintainableEntry> grshll;// 个人生活料理
	private List<TMaintainableEntry> jwld;// 家务劳动
	private List<TMaintainableEntry> xxnl;// 学习能力
	private List<TMaintainableEntry> shjjnll;// 社会交际能力
	private List<TMaintainableEntry> zxjsbmqzz;// 重性精神病目前状况
	private List<TMaintainableEntry> zxjsbywycx;// 重性精神病药物依从性
	private List<TMaintainableEntry> gsqk;// 重性精神疾病随访记录关锁情况
	private List<TMaintainableEntry> zlxg;// 治疗效果
	// 冠心病随访记录
	private List<TMaintainableEntry> sfdqcxy;// 是否定期测血压
	private List<TMaintainableEntry> sfyy;// 是否用药
	private List<TMaintainableEntry> kfzlqk;// 康复治疗情况
	private List<TMaintainableEntry> gxbzyzz;// 冠心病主要症状
	private List<TMaintainableEntry> xnzyzz;// 心脑血管主要症状
	// 其他疾病随访
	private List<TMaintainableEntry> xlzk;// 心理状况
	private List<TMaintainableEntry> yskzqk;// 饮食控制情况
	private List<TMaintainableEntry> ysxg;// 饮食习惯
	private List<TMaintainableEntry> zlzztd;// 肿瘤整张特点
	private List<TMaintainableEntry> cjzztd;// 残疾障碍症状特点
	private List<TMaintainableEntry> mxzztd;// 慢性支气管病症状特点

	/**
	 * 其他疾病随访
	 */
	public void qtjbsf() {
		xlzk = maintainableAttributeService.getmEntriesByCode("13001");
		yskzqk = maintainableAttributeService.getmEntriesByCode("13002");
		zyxw = maintainableAttributeService.getmEntriesByCode("13003");
		ysxg = maintainableAttributeService.getmEntriesByCode("02008");
		zlzztd = maintainableAttributeService.getmEntriesByCode("13004");
		cjzztd = maintainableAttributeService.getmEntriesByCode("13006");
		mxzztd = maintainableAttributeService.getmEntriesByCode("13005");

	}

	/**
	 * 冠心病随访记录
	 */
	public void gxbsf() {
		sfdqcxy = maintainableAttributeService.getmEntriesByCode("12001");
		sfyy = maintainableAttributeService.getmEntriesByCode("12002");
		kfzlqk = maintainableAttributeService.getmEntriesByCode("12003");
		ysxg = maintainableAttributeService.getmEntriesByCode("02008");
		gxbzyzz = maintainableAttributeService.getmEntriesByCode("12004");

	}

	/**
	 * 心脑血管随访记录可维护字段
	 */
	public void xnsf() {
		sfdqcxy = maintainableAttributeService.getmEntriesByCode("12001");
		sfyy = maintainableAttributeService.getmEntriesByCode("12002");
		kfzlqk = maintainableAttributeService.getmEntriesByCode("12003");
		ysxg = maintainableAttributeService.getmEntriesByCode("02008");
		xnzyzz = maintainableAttributeService.getmEntriesByCode("19001");
	}

	/**
	 * 重性精神病随访记录
	 */
	public void zxjsbsf() {
		wxx = maintainableAttributeService.getmEntriesByCode("11001");
		zzl = maintainableAttributeService.getmEntriesByCode("11002");
		smqk = maintainableAttributeService.getmEntriesByCode("11003");
		scld = maintainableAttributeService.getmEntriesByCode("11004");
		hbdjtyx = maintainableAttributeService.getmEntriesByCode("11005");
		zyqk = maintainableAttributeService.getmEntriesByCode("11006");
		kfcs = maintainableAttributeService.getmEntriesByCode("11007");
		grshll = maintainableAttributeService.getmEntriesByCode("11008");
		jwld = maintainableAttributeService.getmEntriesByCode("11009");
		xxnl = maintainableAttributeService.getmEntriesByCode("11010");
		gsqk = maintainableAttributeService.getmEntriesByCode("04006");
		shjjnll = maintainableAttributeService.getmEntriesByCode("11011");
		zxjsbmqzz = maintainableAttributeService.getmEntriesByCode("11012");
		zxjsbywycx = maintainableAttributeService.getmEntriesByCode("11013");
		gxysflx = maintainableAttributeService.getmEntriesByCode("09004");
		zlxg = maintainableAttributeService.getmEntriesByCode("04004");

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

	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public List<TMaintainableEntry> getGxysffs() {
		return gxysffs;
	}

	public List<TMaintainableEntry> getZzl() {
		return zzl;
	}

	public void setZzl(List<TMaintainableEntry> zzl) {
		this.zzl = zzl;
	}

	public List<TMaintainableEntry> getSmqk() {
		return smqk;
	}

	public void setSmqk(List<TMaintainableEntry> smqk) {
		this.smqk = smqk;
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

	public List<TMaintainableEntry> getDxtfy() {
		return dxtfy;
	}

	public void setDxtfy(List<TMaintainableEntry> dxtfy) {
		this.dxtfy = dxtfy;
	}

	public List<TMaintainableEntry> getWxx() {
		return wxx;
	}

	public void setWxx(List<TMaintainableEntry> wxx) {
		this.wxx = wxx;
	}

	public List<TMaintainableEntry> getHbdjtyx() {
		return hbdjtyx;
	}

	public void setHbdjtyx(List<TMaintainableEntry> hbdjtyx) {
		this.hbdjtyx = hbdjtyx;
	}

	public List<TMaintainableEntry> getZyqk() {
		return zyqk;
	}

	public void setZyqk(List<TMaintainableEntry> zyqk) {
		this.zyqk = zyqk;
	}

	public List<TMaintainableEntry> getGrshll() {
		return grshll;
	}

	public void setGrshll(List<TMaintainableEntry> grshll) {
		this.grshll = grshll;
	}

	public List<TMaintainableEntry> getKfcs() {
		return kfcs;
	}

	public void setKfcs(List<TMaintainableEntry> kfcs) {
		this.kfcs = kfcs;
	}

	public List<TMaintainableEntry> getScld() {
		return scld;
	}

	public void setScld(List<TMaintainableEntry> scld) {
		this.scld = scld;
	}

	public List<TMaintainableEntry> getJwld() {
		return jwld;
	}

	public void setJwld(List<TMaintainableEntry> jwld) {
		this.jwld = jwld;
	}

	public List<TMaintainableEntry> getXxnl() {
		return xxnl;
	}

	public void setXxnl(List<TMaintainableEntry> xxnl) {
		this.xxnl = xxnl;
	}

	public List<TMaintainableEntry> getShjjnll() {
		return shjjnll;
	}

	public void setShjjnll(List<TMaintainableEntry> shjjnll) {
		this.shjjnll = shjjnll;
	}

	public List<TMaintainableEntry> getZxjsbmqzz() {
		return zxjsbmqzz;
	}

	public void setZxjsbmqzz(List<TMaintainableEntry> zxjsbmqzz) {
		this.zxjsbmqzz = zxjsbmqzz;
	}

	public List<TMaintainableEntry> getZxjsbywycx() {
		return zxjsbywycx;
	}

	public void setZxjsbywycx(List<TMaintainableEntry> zxjsbywycx) {
		this.zxjsbywycx = zxjsbywycx;
	}

	public List<TMaintainableEntry> getSfdqcxy() {
		return sfdqcxy;
	}

	public void setSfdqcxy(List<TMaintainableEntry> sfdqcxy) {
		this.sfdqcxy = sfdqcxy;
	}

	public List<TMaintainableEntry> getSfyy() {
		return sfyy;
	}

	public void setSfyy(List<TMaintainableEntry> sfyy) {
		this.sfyy = sfyy;
	}

	public List<TMaintainableEntry> getKfzlqk() {
		return kfzlqk;
	}

	public void setKfzlqk(List<TMaintainableEntry> kfzlqk) {
		this.kfzlqk = kfzlqk;
	}

	public List<TMaintainableEntry> getYskzqk() {
		return yskzqk;
	}

	public void setYskzqk(List<TMaintainableEntry> yskzqk) {
		this.yskzqk = yskzqk;
	}

	public List<TMaintainableEntry> getXlzk() {
		return xlzk;
	}

	public void setXlzk(List<TMaintainableEntry> xlzk) {
		this.xlzk = xlzk;
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

	public List<TMaintainableEntry> getTnbmqzyzz() {
		return tnbmqzyzz;
	}

	public void setTnbmqzyzz(List<TMaintainableEntry> tnbmqzyzz) {
		this.tnbmqzyzz = tnbmqzyzz;
	}

	public String getHtype() {
		return htype;
	}

	public void setHtype(String htype) {
		this.htype = htype;
	}

	public List<TMaintainableEntry> getTnbxltz() {
		return tnbxltz;
	}

	public void setTnbxltz(List<TMaintainableEntry> tnbxltz) {
		this.tnbxltz = tnbxltz;
	}

	public List<TMaintainableEntry> getGsqk() {
		return gsqk;
	}

	public void setGsqk(List<TMaintainableEntry> gsqk) {
		this.gsqk = gsqk;
	}

	public List<TMaintainableEntry> getZlxg() {
		return zlxg;
	}

	public void setZlxg(List<TMaintainableEntry> zlxg) {
		this.zlxg = zlxg;
	}

	public List<TMaintainableEntry> getYsxg() {
		return ysxg;
	}

	public void setYsxg(List<TMaintainableEntry> ysxg) {
		this.ysxg = ysxg;
	}

	public List<TMaintainableEntry> getGxbzyzz() {
		return gxbzyzz;
	}

	public void setGxbzyzz(List<TMaintainableEntry> gxbzyzz) {
		this.gxbzyzz = gxbzyzz;
	}

	public List<TMaintainableEntry> getZlzztd() {
		return zlzztd;
	}

	public void setZlzztd(List<TMaintainableEntry> zlzztd) {
		this.zlzztd = zlzztd;
	}

	public List<TMaintainableEntry> getCjzztd() {
		return cjzztd;
	}

	public void setCjzztd(List<TMaintainableEntry> cjzztd) {
		this.cjzztd = cjzztd;
	}

	public List<TMaintainableEntry> getMxzztd() {
		return mxzztd;
	}

	public void setMxzztd(List<TMaintainableEntry> mxzztd) {
		this.mxzztd = mxzztd;
	}

	public List<TMaintainableEntry> getXnzyzz() {
		return xnzyzz;
	}

	public void setXnzyzz(List<TMaintainableEntry> xnzyzz) {
		this.xnzyzz = xnzyzz;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	// /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
