package com.jmjk.action;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
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
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.TDoctorDiagnosis;
import com.jmjk.entity.THealthFile;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.view.VStaffHos;
import com.jmjk.service.DoctorDiagnosisService;
import com.jmjk.service.HealthFileService;
import com.jmjk.service.OldStaffHosService;
import com.jmjk.service.StaffService;
import com.jmjk.utils.GetSessionPerson;
import com.jmjk.utils.Page;
import com.jmjk.utils.Resubmit;
import com.jmjk.utils.TokenProccessor;
@Component
@Scope("prototype")
@Action(value="doctorDiagnosisAction",results={
		@Result(name="doctorDiagnosis",location="/jsp/DoctorDiagnosis/doctorDiagnosis.jsp"),
		//八种慢病医生诊断首页
		@Result(name="gxy",location="/jsp/DoctorDiagnosis/highBloodDiagnosis/doctorDiagnosis.jsp"),
		@Result(name="tnb",location="/jsp/DoctorDiagnosis/diabeteDiagnosis/doctorDiagnosis.jsp"),
		@Result(name="other",location="/jsp/DoctorDiagnosis/otherChronicDiagnosis/doctorDiagnosis.jsp"),
		//八种慢病医生诊断重定向回诊断首页
		@Result(name="addDoctorDiagnosis",type="redirectAction",location="doctorDiagnosisAction!doctorDiagnosis.action"),
		
		//跳转医生诊断添加跳转页
		@Result(name="gxyToAdd",location="/jsp/DoctorDiagnosis/highBloodDiagnosis/addDoctorDiagnosis.jsp"),
		@Result(name="tnbToAdd",location="/jsp/DoctorDiagnosis/diabeteDiagnosis/addDoctorDiagnosis.jsp"),
		@Result(name="otherToAdd",location="/jsp/DoctorDiagnosis/otherChronicDiagnosis/addDoctorDiagnosis.jsp"),
		
		//八种编辑跳转页
		@Result(name="gxyToEdit",location="/jsp/DoctorDiagnosis/highBloodDiagnosis/editDoctorDiagnosis.jsp"),
		@Result(name="tnbToEdit",location="/jsp/DoctorDiagnosis/diabeteDiagnosis/editDoctorDiagnosis.jsp"),
		@Result(name="otherToEdit",location="/jsp/DoctorDiagnosis/otherChronicDiagnosis/editDoctorDiagnosis.jsp"),
		//八种慢病医生诊断重定向回诊断首页
		@Result(name="DocDRedir",type="redirectAction",location="doctorDiagnosisAction!showDoctorDiagnosis.action",params={"daId","${daId}","chronicName","${chronicName}"}),
		//八种慢病医生诊断信息详情页
		@Result(name="gxyToInfo",location="/jsp/DoctorDiagnosis/highBloodDiagnosis/infoDiagnosis.jsp"),
		@Result(name="tnbToInfo",location="/jsp/DoctorDiagnosis/diabeteDiagnosis/infoDiagnosis.jsp"),
		@Result(name="otherToInfo",location="/jsp/DoctorDiagnosis/otherChronicDiagnosis/infoDiagnosis.jsp"),
		@Result(name="error",location="/error.jsp"),
})
public class DoctorDiagnosisAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	@Autowired
	private DoctorDiagnosisService doctorDiagnosisService;
	@Autowired
	private StaffService staffService;
	@Autowired
	private HealthFileService healthFileService;
	@Autowired
	private OldStaffHosService oldStaffHosService;
	private Date startTime;
	private Date endTime;
    private TDoctorDiagnosis doctorDiagnosis;
    private List<TDoctorDiagnosis> doctorDiagnosisList;
    private List<VStaffHos> allDoctor;   //拿到所有医生
	private int cp=1;
	private int daId;            //档案ID
	private String pageHtml;
	private String healthNum;	//档案编号
	private String staffNum;	//员工ID
	private int yszdId;			//医生诊断ID
	private String chronicName; //慢病名称 
	private int staffDoctor;
	
	private String advice;
	private Timestamp date;
	private String opinion;
	private String chronic;
	private String token;
	String mbname = "";
	private boolean flag0=false;
	//显示某人某种病全部诊断记录
	public String showDoctorDiagnosis() throws UnsupportedEncodingException{
		
		Page<TDoctorDiagnosis> page=new Page<TDoctorDiagnosis>();
		page.setCurrentPage(cp);
		 HttpSession session = ServletActionContext.getRequest().getSession();
		 TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
		 if(group!=null){
			 if(!healthFileService.isGroupOld(daId, group.getGId())){
				 return "error";
			 }
		 }
		else{
		int person=GetSessionPerson.getPerson();
		//社区管理员sqid  传的daId只能是该社区下的daId  根据daid拿到老人医院关系实体  
		if(person<0){
			if (oldStaffHosService.oldInHos(daId, Math.abs(person))==false) {
				return "error";
			}
		}
		if(person>0){
			//责任医生
			if(healthFileService.getOldStaffHosByStaffId(person)){
				//判断老人在不在责任医生和该社区下
				if (!oldStaffHosService.oldInSpecialHos(daId, person)) {
					return "error";
				 }
				}
		   } 
		}
		//传档案id
		doctorDiagnosisList=doctorDiagnosisService.getAllDoctorDiagnosisByHFileid(daId,chronicName,page);
		page.setTotalNum(doctorDiagnosisList.size());
		pageHtml=page.getPage("doctorDiagnosisAction!showDoctorDiagnosis.action");
		if(chronicName.equals("高血压")){
			return "gxy";
		}
		if(chronicName.equals("糖尿病"))
			return "tnb";
		else{
			return "other";
		}
	}
	
	//医生诊断首页，查询该人某段时间诊断记录，并分页
	public String  searchDoctorDiagnosis() throws ParseException{
		Page<TDoctorDiagnosis> page=new Page<TDoctorDiagnosis>();
		page.setCurrentPage(cp);
		doctorDiagnosisList=doctorDiagnosisService.getDoctorDiagnosisByTime(daId,chronicName, page, startTime, endTime);
		page.setTotalNum(doctorDiagnosisList.size());
		pageHtml=page.getPage("doctorDiagnosisAction!searchDoctorDiagnosis.action");
		if(chronicName.equals("高血压")){
			return "gxy";
		}
		if(chronicName.equals("糖尿病"))
			return "tnb";
		else{
			return "other";
		}
	}
	public String addDoctorDiagnosis() throws UnsupportedEncodingException{
		int person=GetSessionPerson.getPerson();
		//社区管理员sqid  传的daId只能是该社区下的daId  根据daid拿到老人医院关系实体  
		if(person<0){
			flag0=true;
			if (oldStaffHosService.oldInHos(daId, Math.abs(person))==false) {
				return "error";
			}
			//得到该社区医生              应该是所有启用医生
			allDoctor=healthFileService.getAllDoctorByHosId(Math.abs(person));
		}
		//员工 责任医生 医生  传的daid只能是该社区下的daid 和 该责任医生   
		if(person>0){
			
			int hosId=staffService.getCommHospitalByStaffId(person);
			//责任医生
			if(healthFileService.getOldStaffHosByStaffId(person)){
				if (!oldStaffHosService.oldInSpecialHos(daId, person)) {
					return "error";
				 }
				}
			allDoctor=healthFileService.getAllDoctorByHosId(hosId);	
		}
		
		String token = TokenProccessor.getInstance().makeToken();//创建令牌
	    HttpServletRequest request=ServletActionContext.getRequest();
	    request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)//502cfc9b1984fee89b7adec86023d7ee
	  //  chronicName = new String(chronicName.getBytes("iso8859-1"), "UTF-8");
	    
	    if(chronicName.equals("高血压")){
			return "gxyToAdd";
		}
		if(chronicName.equals("糖尿病"))
			return "tnbToAdd";
		else{
			return "otherToAdd";
		}
	}
	
	public String addDoctorDiagnosisAction(){
		int person=GetSessionPerson.getPerson();
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "DocDRedir";
		}
		request.getSession().removeAttribute("token");//移除session中的token
		THealthFile hf=healthFileService.getHealthFileById(daId);
		doctorDiagnosis.setTHealthFile(hf);
		//TStaff staff=staffService.getStaffById(staffDoctor);
		//保存员工的id
		if(person>0){
			TStaff staff=staffService.getStaffById(person);
			doctorDiagnosis.setTStaff(staff);
		}
		//社区负责人添加时保存的员工id
		if(person<0){
			TStaff staff=staffService.getStaffById(staffDoctor);
			doctorDiagnosis.setTStaff(staff);
		}
		doctorDiagnosisService.saveDoctorDiagnosis(doctorDiagnosis);
		return "DocDRedir";
	}
	
	public String deleteDoctorDiagnosis() throws UnsupportedEncodingException{
		doctorDiagnosisService.deteleDoctorDiagnosis(yszdId);
		//chronicName = new String(chronicName.getBytes("iso8859-1"), "UTF-8");
		return "DocDRedir";
	}
	
	public String editDoctorDiagnosis() throws UnsupportedEncodingException{
		int person=GetSessionPerson.getPerson();
		if(person<0){
			flag0=true;
			if (oldStaffHosService.oldInHos(daId, Math.abs(person))==false) {
				return "error";
			}
			allDoctor=healthFileService.getAllDoctorByHosId(Math.abs(person));
		}
		if(person>0){
			int hosId=staffService.getCommHospitalByStaffId(person);
			//责任医生
			if(healthFileService.getOldStaffHosByStaffId(person)){
				if (!oldStaffHosService.oldInSpecialHos(daId, person)) {
					return "error";
				 }
				}
			allDoctor=healthFileService.getAllDoctorByHosId(hosId);	
		}
		//chronicName = new String(chronicName.getBytes("iso8859-1"), "UTF-8");
		doctorDiagnosis=doctorDiagnosisService.getDoctorDiagnosisByYszdId(yszdId);
		if(doctorDiagnosis.getChronic().equals("高血压")){
			return "gxyToEdit";
		}
		if(doctorDiagnosis.getChronic().equals("糖尿病"))
			return "tnbToEdit";
		else{
			return "otherToEdit";
		}
	}
	public String editDoctorDiagnosisAction(){
		doctorDiagnosis=doctorDiagnosisService.getDoctorDiagnosisByYszdId(yszdId);
		int person=GetSessionPerson.getPerson();
		//保存员工的id
		if(person>0){
			TStaff staff=staffService.getStaffById(person);
			doctorDiagnosis.setTStaff(staff);
		}
		//社区负责人添加时保存的员工id
		if(person<0){
			TStaff staff=staffService.getStaffById(staffDoctor);
			doctorDiagnosis.setTStaff(staff);
		}
		doctorDiagnosis.setTHealthFile(healthFileService.getHealthFileById(daId));
		doctorDiagnosis.setAdvice(advice);
		doctorDiagnosis.setChronic(chronicName);
		doctorDiagnosis.setDate(date);
		doctorDiagnosis.setOpinion(opinion);
		doctorDiagnosisService.updateDoctorDiagnosis(doctorDiagnosis);
		//重定向参数chronicName需要？daid
		return "DocDRedir";
	}
	
	public String infoDoctorDiagnosis(){
		 HttpSession session = ServletActionContext.getRequest().getSession();
		 TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
		 if(group!=null){
			 if(!healthFileService.isGroupOld(doctorDiagnosisService.getDoctorDiagnosisByYszdId(yszdId).getTHealthFile().getHealthFileId(), group.getGId())){
				 return "error";
			 }
			 doctorDiagnosis=doctorDiagnosisService.getDoctorDiagnosisByYszdId(yszdId);
		 }
		else{
		doctorDiagnosis=doctorDiagnosisService.getDoctorDiagnosisByYszdId(yszdId);
		if(doctorDiagnosis==null){
			return "error";
		}
		
		//未检测能否查出其他社区老人信息
		int person=GetSessionPerson.getPerson();
		if(doctorDiagnosisService.getDoctorDiagnosisByYszdId(yszdId)==null){
			return "error";
		}
		if(person<0){
			if (oldStaffHosService.oldInHos(doctorDiagnosisService.getDoctorDiagnosisByYszdId(yszdId).getTHealthFile().getHealthFileId(), Math.abs(person))==false) {
				return "error";
			}
		}
		if(person>0){
			//责任医生
			if(healthFileService.getOldStaffHosByStaffId(person)){
				if (!oldStaffHosService.oldInSpecialHos(doctorDiagnosisService.getDoctorDiagnosisByYszdId(yszdId).getTHealthFile().getHealthFileId(), person)) {
					return "error";
				 }
				}
		}
		}
		if(doctorDiagnosis.getChronic().equals("高血压")){
			return "gxyToInfo";
		}
		if(doctorDiagnosis.getChronic().equals("糖尿病"))
			return "tnbToInfo";
		else{
			return "otherToInfo";
		}
	}
	
	

	
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public int getDaId() {
		return daId;
	}
	public void setDaId(int daId) {
		this.daId = daId;
	}
	public void setDoctorDiagnosisService(
			DoctorDiagnosisService doctorDiagnosisService) {
		this.doctorDiagnosisService = doctorDiagnosisService;
	}
	public DoctorDiagnosisService getDoctorDiagnosisService() {
		return doctorDiagnosisService;
	}
	public TDoctorDiagnosis getDoctorDiagnosis() {
		return doctorDiagnosis;
	}
	public void setDoctorDiagnosis(TDoctorDiagnosis doctorDiagnosis) {
		this.doctorDiagnosis = doctorDiagnosis;
	}
	public String getPageHtml() {
		return pageHtml;
	}
	public void setPageHtml(String pageHtml) {
		this.pageHtml = pageHtml;
	}

	public List<TDoctorDiagnosis> getDoctorDiagnosisList() {
		return doctorDiagnosisList;
	}
	public void setDoctorDiagnosisList(List<TDoctorDiagnosis> doctorDiagnosisList) {
		this.doctorDiagnosisList = doctorDiagnosisList;
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

	public String getStaffNum() {
		return staffNum;
	}

	public void setStaffNum(String staffNum) {
		this.staffNum = staffNum;
	}
	public int  getYszdId() {
		return yszdId;
	}

	public void setYszdId(int yszdId) {
		this.yszdId = yszdId;
	}

	public String getChronicName() {
		return chronicName;
	}

	public void setChronicName(String chronicName) throws UnsupportedEncodingException {
		this .chronicName= java.net.URLDecoder.decode (chronicName, "UTF-8" ); 
	//	this.chronicName = chronicName;
	}

	public String getHealthNum() {
		return healthNum;
	}

	public void setHealthNum(String healthNum) {
		this.healthNum = healthNum;
	}
	public List<VStaffHos> getAllDoctor() {
		return allDoctor;
	}
	public void setAllDoctor(List<VStaffHos> allDoctor) {
		this.allDoctor = allDoctor;
	}
	public int getStaffDoctor() {
		return staffDoctor;
	}
	public void setStaffDoctor(int staffDoctor) {
		this.staffDoctor = staffDoctor;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public String getChronic() {
		return chronic;
	}

	public void setChronic(String chronic) {
		this.chronic = chronic;
	}
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isFlag0() {
		return flag0;
	}

	public void setFlag0(boolean flag0) {
		this.flag0 = flag0;
	}

}
