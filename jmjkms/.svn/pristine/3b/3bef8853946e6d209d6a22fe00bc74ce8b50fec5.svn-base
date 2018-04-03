package com.jmjk.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.itextpdf.text.log.SysoCounter;
import com.jmjk.dao.CommunityHospitalDao;
import com.jmjk.dao.OldStaffHosDao;
import com.jmjk.dao.RoleDao;
import com.jmjk.dao.StaffDao;
import com.jmjk.dao.VStaffHosDao;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.THealthFile;
import com.jmjk.entity.TOldStaffHos;
import com.jmjk.entity.TRole;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.view.VStaffHos;
import com.jmjk.enums.OperatorState;
import com.jmjk.enums.Result_Login;
import com.jmjk.iservice.IStaffService;
import com.jmjk.utils.HttpRequest;
import com.jmjk.utils.Page;
import com.jmjk.utils.SearchUtil;
import com.jmjk.utils.TypeConverter;
import com.jmjk.utils.WebXMLParameter;

/**
 * 
 * @author Liufengshuang
 *
 */
@Controller("staffService")
public class StaffService implements IStaffService {
	@Autowired
	private StaffDao staffDao;
	@Autowired
	private OldStaffHosDao oldStaffHosDao;
	@Autowired
	private CommunityHospitalDao communityHospitalDao;
	@Autowired
	private VStaffHosDao vstaffHosDao;
	@Autowired
	private RoleDao roleDao;
	@Autowired
	CommunityHospitalService communityHospitalService;
	@Autowired
	HealthFileService healthFileService;

	// 责任医生云同步基础路径
	//private String baseUrl = "http://222.222.218.52:8185/healthy/doctor/";
	// 添加责任医生云同步方法
	//private String addDocUrl = "addData";
	// 删除责任医生云同步方法
	//private String deleteDocUrl = "deleteData";
	// 修改责任医生云同步方法
	//private String editDocUrl = "editData";

	
	/**
	 * 
	 * TODO 添加责任医生,
	 * 其中步骤为:
	 * 	1.同步云,向云端添加数据
	 *  2.修改本地数据, 即更新staff信息
	 * @see 
	 */
	public void addDutyDoctor(TStaff staff){
		staffDao.update(staff);
		//String URL = baseUrl+addDocUrl;
		StringBuffer URL=new StringBuffer();
		URL.append(WebXMLParameter.getParamValue("ip_port"));
		URL.append("/healthy/doctor/addData");
		System.out.println(URL.toString());
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("doctor={\"birthDate\":\""+TypeConverter.dateTimestamp(staff.getBirthDate()));
		if(staff.getCerificateNum() == null){
			stringBuffer.append("\",\"cerificateNum\":\"");
		}else{
			stringBuffer.append("\",\"cerificateNum\":\""+staff.getCerificateNum());
		}
		if(staff.getCertificateName() == null){
			stringBuffer.append("\",\"certificateName\":\"");
		}else{
			stringBuffer.append("\",\"certificateName\":\""+staff.getCertificateName());
		}
		if(staff.getCertificateType() == null){
			stringBuffer.append("\",\"certificateType\":\"");
		}else{
			stringBuffer.append("\",\"certificateType\":\""+staff.getCertificateType());
		}	
		if(staff.getCometoOfficeDate()==null){
			stringBuffer.append("\",\"cometoOfficeDate\":"+staff.getCometoOfficeDate()+",");
		}else{
			stringBuffer.append("\",\"cometoOfficeDate\":\""+TypeConverter.dateTimestamp(staff.getCometoOfficeDate())+"\",");
		}		
		if(staff.getComputerLevel() == null){
			stringBuffer.append("\"computerLevel\":\"");
		}else{
			stringBuffer.append("\"computerLevel\":\""+staff.getComputerLevel());
		}
		if(staff.getDepartment() == null){
			stringBuffer.append("\",\"department\":\"");
		}else{
			stringBuffer.append("\",\"department\":\""+staff.getDepartment());
		}
		if(staff.getEduBackground() == null){
			stringBuffer.append("\",\"eduBackground\":\"");
		}else{
			stringBuffer.append("\",\"eduBackground\":\""+staff.getEduBackground());
		}
		if(staff.getEnglishLevel() == null){
			stringBuffer.append("\",\"englishLevel\":\"");
		}else{
			stringBuffer.append("\",\"englishLevel\":\""+staff.getEnglishLevel());
		}
		if(staff.getFamilyRegister() == null){
			stringBuffer.append("\",\"familyRegister\":\"");
		}else{
			stringBuffer.append("\",\"familyRegister\":\""+staff.getFamilyRegister());
		}
		if(staff.getFive() == null){
			stringBuffer.append("\",\"five\":\"");
		}else{
			stringBuffer.append("\",\"five\":\""+staff.getFive());
		}
		if(staff.getFour() == null){
			stringBuffer.append("\",\"four\":\"");
		}else{
			stringBuffer.append("\",\"four\":\""+staff.getFour());
		}
		if(staff.getGpTrain() == null){
			stringBuffer.append("\",\"gpTrain\":\"");
		}else{
			stringBuffer.append("\",\"gpTrain\":\""+staff.getGpTrain());
		}
		if(staff.getGraduateDate()==null){
			stringBuffer.append("\",\"graduateDate\":"+staff.getGraduateDate()+",");
		}else{
		  stringBuffer.append("\",\"graduateDate\":\""+TypeConverter.dateTimestamp(staff.getGraduateDate())+"\",");
		}
		if(staff.getGraduateSchool() == null){
			stringBuffer.append("\"graduateSchool\":\"");
		}else{
			stringBuffer.append("\"graduateSchool\":\""+staff.getGraduateSchool());
		}
		if(staff.getHealthStatus() == null){
			stringBuffer.append("\",\"healthStatus\":\"");
		}else{
			stringBuffer.append("\",\"healthStatus\":\""+staff.getHealthStatus());
		}
		if(staff.getHireEndDate()==null){
			stringBuffer.append("\",\"hireEndDate\":"+staff.getHireEndDate()+",");
		}else{
			stringBuffer.append("\",\"hireEndDate\":\""+TypeConverter.dateTimestamp(staff.getHireEndDate())+"\",");
		}
		if(staff.getHireStratDate()==null){
			stringBuffer.append("\"hireStratDate\":"+staff.getHireStratDate()+",");
		}else{
			stringBuffer.append("\"hireStratDate\":\""+TypeConverter.dateTimestamp(staff.getHireStratDate())+"\",");
		}
		if(staff.getHireType() == null){
			stringBuffer.append("\"hireType\":\"");
		}else{
			stringBuffer.append("\"hireType\":\""+staff.getHireType());
		}
		if(staff.getIdCardNum() == null){
			stringBuffer.append("\",\"idCardNum\":\"");
		}else{
			stringBuffer.append("\",\"idCardNum\":\""+staff.getIdCardNum());
		}
		if(staff.getIsAgencyOld() == null){
			stringBuffer.append("\",\"isAgencyOld\":");
		}else{
			stringBuffer.append("\",\"isAgencyOld\":"+staff.getIsAgencyOld());
		}
		if(staff.getIsHomeOld() == null){
			stringBuffer.append(",\"isHomeOld\":");
		}else{
			stringBuffer.append(",\"isHomeOld\":"+staff.getIsHomeOld());
		}
		if(staff.getIsSpecialDoctor() == null){
			stringBuffer.append(",\"isSpecialDoctor\":");
		}else{
			stringBuffer.append(",\"isSpecialDoctor\":"+staff.getIsSpecialDoctor());
		}
		if(staff.getJob() == null){
			stringBuffer.append(",\"job\":\"");
		}else{
			stringBuffer.append(",\"job\":\""+staff.getJob());
		}
		if(staff.getJobTitleCertificate() == null){
			stringBuffer.append("\",\"jobTitleCertificate\":\"");
		}else{
			stringBuffer.append("\",\"jobTitleCertificate\":\""+staff.getJobTitleCertificate());
		}
		if(staff.getJobTitleLevel() == null){
			stringBuffer.append("\",\"jobTitleLevel\":\"");
		}else{
			stringBuffer.append("\",\"jobTitleLevel\":\""+staff.getJobTitleLevel());
		}
		if(staff.getJobTitleNum() == null){
			stringBuffer.append("\",\"jobTitleNum\":\"");
		}else{
			stringBuffer.append("\",\"jobTitleNum\":\""+staff.getJobTitleNum());
		}
		if(staff.getLiveAddr() == null){
			stringBuffer.append("\",\"liveAddr\":\"");
		}else{
			stringBuffer.append("\",\"liveAddr\":\""+staff.getLiveAddr());
		}
		if(staff.getLoginName() == null){
			stringBuffer.append("\",\"loginName\":\"");
		}else{
			stringBuffer.append("\",\"loginName\":\""+staff.getLoginName());
		}
		if(staff.getMaritalStatus() == null ){
			stringBuffer.append("\",\"maritalStatus\":\"");
		}else{
			stringBuffer.append("\",\"maritalStatus\":\""+staff.getMaritalStatus());
		}
		if(staff.getName() == null){
			stringBuffer.append("\",\"name\":\"");
		}else{
			stringBuffer.append("\",\"name\":\""+staff.getName());
		}
		if(staff.getNote() == null){
			stringBuffer.append("\",\"note\":\"");
		}else{
			stringBuffer.append("\",\"note\":\""+staff.getNote());
		}
		if(staff.getOne() == null){
			stringBuffer.append("\",\"one\":\"");
		}else{
			stringBuffer.append("\",\"one\":\""+staff.getOne());
		}
		if(staff.getOperateState() == null){
			stringBuffer.append("\",\"operateState\":");
		}else{
			stringBuffer.append("\",\"operateState\":"+staff.getOperateState());
		}
		if(staff.getPassword() == null){
			stringBuffer.append(",\"password\":\"");
		}else{
			stringBuffer.append(",\"password\":\""+staff.getPassword());
		}
		if(staff.getPhone() == null){
			stringBuffer.append("\",\"phone\":\"");
		}else{
			stringBuffer.append("\",\"phone\":\""+staff.getPhone());
		}
		if(staff.getProfessional() == null){
			stringBuffer.append("\",\"professional\":\"");
		}else{
			stringBuffer.append("\",\"professional\":\""+staff.getProfessional());
		}
		stringBuffer.append("\",\"roleId\":"+staff.getTRole().getRoleId());
		if(staff.getSex() == null){
			stringBuffer.append(",\"sex\":");
		}else{
			stringBuffer.append(",\"sex\":"+staff.getSex());
		}		
		stringBuffer.append(",\"staffId\":"+staff.getStaffId());
		if(staff.getStaffNumber() == null){
			stringBuffer.append(",\"staffNumber\":\"");
		}else{
			stringBuffer.append(",\"staffNumber\":\""+staff.getStaffNumber());
		}
		if(staff.getState() == null){
			stringBuffer.append(",\"state\":\"");
		}else{
			stringBuffer.append("\",\"state\":\""+staff.getState());
		}
		if(staff.getStation() == null){
			stringBuffer.append("\",\"station\":\"");
		}else{
			stringBuffer.append("\",\"station\":\""+staff.getStation());
		}
		if(staff.getThree() == null){
			stringBuffer.append("\",\"three\":\"");
		}else{
			stringBuffer.append("\",\"three\":\""+staff.getThree());
		}
		if(staff.getTrainEndDate()==null){
			stringBuffer.append("\",\"trainEndDate\":"+staff.getTrainEndDate()+",");
		}else{
			stringBuffer.append("\",\"trainEndDate\":\""+TypeConverter.dateTimestamp(staff.getTrainEndDate())+"\",");
		}
		if(staff.getTrainStratDate()==null){
			stringBuffer.append("\"trainStratDate\":"+staff.getTrainStratDate()+",");
		}else{
			stringBuffer.append("\"trainStratDate\":\""+TypeConverter.dateTimestamp(staff.getTrainStratDate())+"\",");
		}
		if(staff.getTwo() == null){
			stringBuffer.append("\"two\":\"");
		}else{
			stringBuffer.append("\"two\":\""+staff.getTwo());
		}
		if(staff.getWage() == null){
			stringBuffer.append("\",\"wage\":0");
		}else{
			stringBuffer.append("\",\"wage\":"+staff.getWage());
		}
		if(staff.getZipCode() == null){
			stringBuffer.append(",\"zipCode\":\"");
		}else{
			stringBuffer.append(",\"zipCode\":"+staff.getZipCode());
		}
		stringBuffer.append("\"}"+ "&hosId="+staff.getTRole().getCommunityId());
		System.out.println(stringBuffer.toString());
		String str=HttpRequest.sendPost(URL.toString(), stringBuffer.toString());
		System.out.println(str);

		
		
	}
	

	@Override   //删除责任医生指的是这个医生不是责任医生，但是这个员工仍然存在
	public void deleteDutyDoctor(int id) {
		String hql="update TStaff ts set ts.isSpecialDoctor ="+0+" where ts.staffId="+id;
		staffDao.update(hql);
		System.out.println(id);
		//通过责任医生（员工）ID，得到社区医院
		TCommunityHospital communityHospital=communityHospitalService.getCommunityHospitalByStaffId(id);
		String phone=communityHospital.getPhone();
		//通过社区医院电话，得到社区医院在员工表里的员工    负责人对应的员工实体               社区负责人ID   当新建一个医院的时候往员工表中添加一条记录
		TStaff staff=this.getStaffByPhone(phone);	
		/*TOldStaffHos oldStaffHos=new TOldStaffHos();
		oldStaffHos.setTStaff(staff);//对应的是责任医生
		healthFileService.saveOldStaffHos(oldStaffHos);*/
		
		List<TOldStaffHos> healthList=healthFileService.getOldStaffHosListByStaffId(id);
		healthFileService.deleteOldStaffHosByStaffId(id);
		TCommunityHospital com;
		THealthFile healthFile;
		for(TOldStaffHos oldStaffHos:healthList)
		{
			com=oldStaffHos.getTCommunityHospital();
			healthFile=oldStaffHos.getTHealthFile();
			oldStaffHos=new TOldStaffHos();
			oldStaffHos.setTCommunityHospital(com);
			oldStaffHos.setTHealthFile(healthFile);
			oldStaffHos.setTStaff(staff);			
			healthFileService.saveOldStaffHos(oldStaffHos);
			
		}	
		//URL	
		StringBuffer url=new StringBuffer();
		url.append(WebXMLParameter.getParamValue("ip_port"));
		url.append("/healthy/doctor/deleteData");
		System.out.println(url.toString());
		//参数
		StringBuffer stringBuffer = new StringBuffer();
		//String para = "id="+id;	
		
		stringBuffer.append("id="+id+"&docid="+staff.getStaffId());
		//String str=HttpRequest.sendPost(url.toString(), para);
		System.out.println(stringBuffer.toString());
		String str=HttpRequest.sendPost(url.toString(), stringBuffer.toString());
		System.out.println(str);
		
		
	}
  
	//通过社区医院电话，得到社区医院在员工表里的员工
	public TStaff getStaffByPhone(String phone){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("phone", phone);
		String hql = "from TStaff staff where staff.phone = :phone and staff.birthDate is null";
		return staffDao.Get(hql,params);		
	}


	@Override
	public void updateDutyDoctor(TStaff staff) {

		staffDao.update(staff);
		StringBuffer url=new StringBuffer();
		url.append(WebXMLParameter.getParamValue("ip_port"));
		url.append("/healthy/doctor/editData");
		System.out.println(url.toString());
		StringBuffer stringBuffer = new StringBuffer();
		//String URL = baseUrl+editDocUrl;
		stringBuffer.append("doctor={\"birthDate\":\""+TypeConverter.dateTimestamp(staff.getBirthDate())
		+"\",\"cerificateNum\":\""+staff.getCerificateNum()
		+"\",\"certificateName\":\""+staff.getCertificateName()
		+"\",\"certificateType\":\""+staff.getCertificateType());
		if(staff.getCometoOfficeDate()==null){
			stringBuffer.append("\",\"cometoOfficeDate\":"+staff.getCometoOfficeDate()+",");
		}else{
			stringBuffer.append("\",\"cometoOfficeDate\":\""+TypeConverter.dateTimestamp(staff.getCometoOfficeDate())+"\",");
		}
		stringBuffer.append("\"computerLevel\":\""+staff.getComputerLevel()
		+"\",\"department\":\""+staff.getDepartment()
		+"\",\"eduBackground\":\""+staff.getEduBackground()
		+"\",\"englishLevel\":\""+staff.getEnglishLevel()
		+"\",\"familyRegister\":\""+staff.getFamilyRegister()
		+"\",\"five\":\""+staff.getFive()
		+"\",\"four\":\""+staff.getFour()
		+"\",\"gpTrain\":\""+staff.getGpTrain());
		if(staff.getGraduateDate()==null){
			stringBuffer.append("\",\"graduateDate\":"+staff.getGraduateDate()+",");
		}
		else{
			stringBuffer.append("\",\"graduateDate\":\""+TypeConverter.dateTimestamp(staff.getGraduateDate())+"\",");
		}
		stringBuffer.append("\"graduateSchool\":\""+staff.getGraduateSchool()
		+"\",\"healthStatus\":\""+staff.getHealthStatus());
		if(staff.getHireEndDate()==null){
			stringBuffer.append("\",\"hireEndDate\":"+staff.getHireEndDate()+",");
		}
		else{
			stringBuffer.append("\",\"hireEndDate\":\""+TypeConverter.dateTimestamp(staff.getHireEndDate())+"\",");
		}
		if(staff.getHireStratDate()==null){
			stringBuffer.append("\"hireStratDate\":"+staff.getHireStratDate()+",");
		}
		else{
			stringBuffer.append("\"hireStratDate\":\""+TypeConverter.dateTimestamp(staff.getHireStratDate())+"\",");
		}
		stringBuffer.append("\"hireType\":\""+staff.getHireType()
		+"\",\"idCardNum\":\""+staff.getIdCardNum()
		+"\",\"isAgencyOld\":"+staff.getIsAgencyOld()
		+",\"isHomeOld\":"+staff.getIsHomeOld()
		+",\"isSpecialDoctor\":"+staff.getIsSpecialDoctor()
		+",\"job\":\""+staff.getJob()
		+"\",\"jobTitleCertificate\":\""+staff.getJobTitleCertificate()
		+"\",\"jobTitleLevel\":\""+staff.getJobTitleLevel()
		+"\",\"jobTitleNum\":\""+staff.getJobTitleNum()
		+"\",\"liveAddr\":\""+staff.getLiveAddr()
		+"\",\"loginName\":\""+staff.getLoginName()
		+"\",\"maritalStatus\":\""+staff.getMaritalStatus()
		+"\",\"name\":\""+staff.getName()
		+"\",\"note\":\""+staff.getNote()
		+"\",\"one\":\""+staff.getOne()
		+"\",\"operateState\":"+staff.getOperateState()
		+",\"password\":\""+staff.getPassword()
		+"\",\"phone\":\""+staff.getPhone()
		+"\",\"professional\":\""+staff.getProfessional()
		+"\",\"roleId\":"+staff.getTRole().getRoleId()
		+",\"sex\":"+staff.getSex()
		+",\"staffId\":"+staff.getStaffId()
		+",\"staffNumber\":\""+staff.getStaffNumber()
		+"\",\"state\":\""+staff.getState()
		+"\",\"station\":\""+staff.getStation()
		+"\",\"three\":\""+staff.getThree());
		if(staff.getTrainStratDate()==null){
			stringBuffer.append("\",\"trainEndDate\":"+staff.getTrainEndDate()+",");
		}else{
			stringBuffer.append("\",\"trainEndDate\":\""+TypeConverter.dateTimestamp(staff.getTrainEndDate())+"\",");
		}
		if(staff.getTrainStratDate()==null){
			stringBuffer.append("\"trainStratDate\":"+staff.getTrainStratDate()+",");
		}else{
			stringBuffer.append("\"trainStratDate\":\""+TypeConverter.dateTimestamp(staff.getTrainStratDate())+"\",");
		}
		stringBuffer.append("\"two\":\""+staff.getTwo());		
		if(staff.getWage() == null){
			stringBuffer.append("\",\"wage\":0");
		}else{
			stringBuffer.append("\",\"wage\":"+staff.getWage());
		}
		stringBuffer.append(",\"zipCode\":\""+staff.getZipCode()+"\"}");		
		System.out.println(stringBuffer.toString());
		String str=HttpRequest.sendPost(url.toString(), stringBuffer.toString());
		System.out.println(str);
	
	
	}
	
	
	
	// 加密 by xuleping
	public String encryptString(String password) {
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			messageDigest.update(password.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException e) {
			System.exit(-1);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		byte[] byteArray = messageDigest.digest();
		StringBuffer md5StrBuff = new StringBuffer();
		for (int i = 0; i < byteArray.length; i++) {
			if (Integer.toHexString(0xFF & byteArray[i]).length() == 1)
				md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
			else
				md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
		}
		return md5StrBuff.toString();
	}

	// 登录 by xuleping
	@Override
	public Enum loginCheck(String loginname, String Password) {
		Result_Login result = Result_Login.NO_USER;
		TStaff staff = (TStaff) staffDao.Get("from TStaff ts where ts.loginName = '" + loginname
				+ "' and ts.operateState = " + OperatorState.qiyong.getvalue());
		if (staff == null) {
			return result;
		}
		Password = encryptString(Password);
		String password = staff.getPassword();
		if (Password.equals(password)) {
			result = Result_Login.LOGIN_SUCCESS;
		} else {
			result = Result_Login.PASS_ERROR;
		}
		return result;
	}

	@Override
	public List<TStaff> getStaffByLoginName(String loginName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginName", loginName);
		params.put("operateState", OperatorState.shanchu.getvalue());
		String hql = "from TStaff staff where staff.loginName = :loginName and staff.operateState <> :operateState";
		return staffDao.find(hql, params);
	}

	// 这个需要得到社区实体,然后存关系
	@Override
	public int saveStaff(TStaff staff, int sqId) {
		Map<String, Object> params = new HashMap<String, Object>();
		// params.put("sqId",sqId);
		TCommunityHospital tc = communityHospitalService.getCommunityHospitalById(sqId);
		if (tc == null) {
			return -1;
		} // 如果社区都不存在,那么还存个毛毛
		String staffNum = staff.getStaffNumber();
		String staffIDcardNum = staff.getIdCardNum();
		params.put("staffNum", staffNum);
		// 查一下有木有员工编号和员工身份证有重的么
		String hql = "from TStaff staff where staff.staffNumber = :staffNum ";
		List<TStaff> sts = staffDao.find(hql, params);
		if (sts.size() == 0 || sts == null || sts.equals("")) {// 没有重复的才会被保存
			// 保存了员工
			staffDao.Save(staff);
			// 创建关系实体
			TOldStaffHos sc = new TOldStaffHos();
			sc.setTCommunityHospital(tc);
			sc.setTStaff(staff);
			// 要在关系表中保存关系
			this.saveOldStaffHos(sc);
			return 1;
		} else {
			return -1;
		}
	}

	//添加社区医院的同时，往员工里边添加一条记录  此时已经
	public void saveStaffRecord(TStaff staff, TCommunityHospital communityHospital) {
			// 保存了员工
			staffDao.Save(staff);
			// 创建关系实体
			TOldStaffHos sc = new TOldStaffHos();
			sc.setTCommunityHospital(communityHospital);
			sc.setTStaff(staff);
			// 要在关系表中保存关系
			this.saveOldStaffHos(sc);
	}
	
	//修改社区医院的时候，员工表里的记录也得修改   关系表里
	public void updateStaffRecord(TStaff staff, TCommunityHospital communityHospital) {
        // 保存了员工
        staffDao.update(staff);
       //拿到社区负责人对应的关系表里的数据  （只对应医院和员工，老人为空的那条数据）
        TOldStaffHos sc=this.getOldStaffHosByStaffId(staff.getStaffId());
       // TOldStaffHos sc = new TOldStaffHos();
        sc.setTCommunityHospital(communityHospital);
        sc.setTStaff(staff);
        // 要在关系表中修改关系
        this.updateOldStaffHos(sc);
    }
	
	
	@Override
	public void deleteStaffById(int staffId) {
		// 假删,将状态改为2
		String hql = "update TStaff staff set staff.operateState = " + OperatorState.shanchu.getvalue()
				+ " where staff.staffId =" + staffId;
		staffDao.update(hql);
	}

	@Override
	public void deleteStaffById_Admin(int staffId) {// 真删
		String hql = "delete from TStaff staff where staff.staffId=" + staffId;
		staffDao.delete(hql);
	}

	@Override
	public long countStaff() {
		Map<String, Object> params = new HashMap<String, Object>();
		int roleId=this.getRoleByCom().getRoleId();
		params.put("roleId",roleId);
		params.put("operateState", OperatorState.shanchu.getvalue());
		String hql = "select count(staff.staffId) from TStaff staff where staff.operateState <> :operateState and (staff.TRole.roleId = null or staff.TRole.roleId <> :roleId)";
		return staffDao.count(hql, params);
	}

	@Override
	public List<TStaff> getStaffByPage(Page page) {
		Map<String, Object> params = new HashMap<String, Object>();
		int roleId=this.getRoleByCom().getRoleId();
		params.put("roleId",roleId);
		params.put("operateState", OperatorState.shanchu.getvalue());
		String hql = "from TStaff staff where staff.operateState <> :operateState  and (staff.TRole.roleId = null or staff.TRole.roleId <> :roleId) order by staffId desc ";
		return staffDao.find(hql, params, page.getCurrentPage(), page.getPageSize());
	}

	@Override
	public TStaff getStaffById(int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("operateState", OperatorState.shanchu.getvalue());
		params.put("staffId", staffId);
		String hql = "from TStaff staff where staff.staffId=:staffId and staff.operateState <> :operateState";
		return staffDao.Get(hql, params);
	}

	@Override
	public void updateStaff(TStaff staff) {
		staffDao.update(staff);
	}

	@Override
	public TStaff getStaffByStaffNumber(String staffNumber) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffNumber", staffNumber);
		String hql = "from TStaff staff where staff.staffNumber = :staffNumber";
		return staffDao.Get(hql, params);
	}

	@Override
	public void saveOldStaffHos(TOldStaffHos OldStaffHos) {
		oldStaffHosDao.Save(OldStaffHos);
	}
	
	public void updateOldStaffHos(TOldStaffHos OldStaffHos) {
        oldStaffHosDao.Save(OldStaffHos);
    }

	@Override
	public List<TStaff> getStaffsBySearch(int dis, int flag, String value, String state, String department, int sqId) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (flag != 0) {
			if (value != null && !value.equals("") && value != "") {
				params.put("value", "%" + value + "%");
			}
		}
		if (state != null && !state.equals("") && state != "") {
			params.put("state", state);
		}
		if (department != null && !department.equals("") && department != "") {
			params.put("department", department);
		}
		if (sqId != -1) {// 不是系统管理员 或者是社区集体
			params.put("sqId", sqId);
		}
		SearchUtil su = new SearchUtil();
		String hql = su.getStaffHql(dis, flag, value, state, department, sqId);
		params.put("operateState", OperatorState.shanchu.getvalue());
		String hql2 = " and staff.operateState <> :operateState";
		hql += hql2;
		List<VStaffHos> list = vstaffHosDao.find(hql, params);
		if (list == null || list.size() == 0 || list.equals("")) {
			return null;
		}
		List<TStaff> staffs = new ArrayList<TStaff>();
		for (int i = 0; i < list.size(); i++) {
			int id = list.get(i).getStaffId();
			staffs.add(this.getStaffById(id));
		}
		return staffs;
	}

	@Override
	public int deleteStaffsByList(List<Object> staffIds) {
		if (staffIds.size() == 0 || staffIds == null || staffIds.equals("")) {
			return -1;
		}
		String a = ",";
		String str = TypeConverter.convertList2String(staffIds, a);
		String hql = "update TStaff staff set staff.operateState = " + OperatorState.shanchu.getvalue()
				+ " from TStaff staff where staff.staffId in (" + str + ")";
		staffDao.update(hql);
		return 0;
	}

	@Override
	public List<VStaffHos> getAllStaffByCommunityHospitalId(int sqId) {
		Map<String, Object> params = new HashMap<String, Object>();
		int roleId=this.getRoleByCom().getRoleId();
		params.put("roleId",roleId);
		params.put("sqId", sqId);
		params.put("operateState", OperatorState.shanchu.getvalue());
		String hql = " from VStaffHos vs where vs.communityHospitalId = :sqId and vs.operateState <> :operateState and (vs.roleId <> :roleId or vs.roleId = null) order by vs.staffId desc";
		return vstaffHosDao.find(hql, params);
	}

	@Override
	public List<VStaffHos> getAllStaffByCommunityHospitalId(int communityHospitalId, Page page) {
		Map<String, Object> params = new HashMap<String, Object>();
		int roleId=this.getRoleByCom().getRoleId();
		params.put("sqId", communityHospitalId);
		params.put("operateState", OperatorState.shanchu.getvalue());
		params.put("roleId",roleId);
		String hql = " from VStaffHos vs where vs.communityHospitalId = :sqId and vs.operateState <> :operateState and (vs.roleId <> :roleId or vs.roleId = null) order by staffId desc ";
		return vstaffHosDao.find(hql, params, page.getCurrentPage(), page.getPageSize());
	}

	@Override
	public long countVStaffByCommunityHospitalId(int sqId) {
		List<VStaffHos> list = this.getAllStaffByCommunityHospitalId(sqId);
		if (list == null) {
			return 0;
		}
		return list.size();
	}

	@Override
	public long countStaffByCommunityHospitalId(int sqId) {
		return this.countVStaffByCommunityHospitalId(sqId);
	}

	@Override
	public List<TStaff> getStaffByCommunityHospitalId(int communityHospitalId) {
		List<VStaffHos> list = this.getAllStaffByCommunityHospitalId(communityHospitalId);
		if (list.size() == 0 || list == null || list.equals("")) {
			return null;
		}
		List<TStaff> staffs = new ArrayList<TStaff>();
		for (int i = 0; i < list.size(); i++) {
			int id = list.get(i).getStaffId();
			staffs.add(this.getStaffById(id));
		}
		return staffs;
	}

	@Override
	public List<TStaff> getStaffByCommunityHospitalId(int communityHospitalId, Page page) {
		List<VStaffHos> list = this.getAllStaffByCommunityHospitalId(communityHospitalId, page);
		if (list.size() == 0 || list == null || list.equals("")) {
			return null;
		}
		List<TStaff> staffs = new ArrayList<TStaff>();
		for (int i = 0; i < list.size(); i++) {
			int id = list.get(i).getStaffId();
			staffs.add(this.getStaffById(id));
		}
		return staffs;
	}

	@Override
	public List<TStaff> getStaffByStaffName(String name) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", "%" + name + "%");
		params.put("operateState", OperatorState.qiyong.getvalue());
		String hql = "from TStaff staff where staff.name like :name and staff.operateState = :operateState";
		return staffDao.find(hql, params);
	}

	@Override
	public List<TStaff> getStaffByIDCardNumber(String IDCardNumber) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("IDCardNumber", IDCardNumber);
		params.put("operateState", OperatorState.qiyong.getvalue());
		String hql = "from TStaff staff where staff.idCardNum = :IDCardNumber and staff.operateState = :operateState";
		return staffDao.find(hql, params);
	}

	@Override
	public List getAllStaffNumber() {
		String hql = "from TStaff staff ";
		return staffDao.find(hql);
	}

	@Override
	public String getStaffNumber() {
		String str = staffDao.getStaffNum("select STAFF_NUM()");
		return str;
	}

	@Override
	public TStaff getStaffByloginName(String loginName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginName", loginName);
		String hql = "from TStaff ts where ts.loginName = :loginName";
		return staffDao.Get(hql, params);
	}

	@Override
	public boolean hasThisOperator(String loginName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("loginName", loginName);
		String hql = "from TStaff staff where staff.loginName = :loginName";
		List<TStaff> list = staffDao.find(hql, params);
		if (list == null) {
			return false;
		} else {
			if (list.size() == 0) {
				return false;
			}
			return true;

		}
	}

	@Override
	public List<VStaffHos> getAllOperator(int sqId, Page page) {
		String hql = "";
		Map<String, Object> params = new HashMap<String, Object>();

		// 社区负责人为负值 平台管理员

		params.put("operateState", OperatorState.shanchu.getvalue());
		if (sqId != -1) {
			params.put("sqId", sqId);
			hql = " from VStaffHos vs where vs.communityHospitalId = :sqId and vs.loginName != null and vs.operateState <>:operateState  order by staffId desc";
		} else {
			hql = "from VStaffHos vs where vs.loginName != null and vs.operateState <> :operateState  order by staffId desc";
		}

		return vstaffHosDao.find(hql, params, page.getCurrentPage(), page.getPageSize());
	}

	@Override
	public List<VStaffHos> getAllOperator() {

		Map<String, Object> params = new HashMap<String, Object>();

		params.put("operateState", OperatorState.shanchu.getvalue());

		String hql = "from VStaffHos vs where  vs.loginName != null and vs.operateState <>:operateState  order by staffId desc";

		return vstaffHosDao.find(hql, params);

	}

	@Override
	public List<VStaffHos> getAllOperator(int sqId) {
		String hql = "";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sqId", sqId);
		params.put("operateState", OperatorState.shanchu.getvalue());
		if (sqId != -1) {
			hql = "from VStaffHos vs where vs.communityHospitalId = :sqId and vs.loginName != null and vs.operateState <>:operateState  order by staffId desc";
		} else {
			hql = "from VStaffHos vs where vs.loginName != null and vs.operateState <> :operateState  order by staffId desc";
		}
		return vstaffHosDao.find(hql, params);
	}

	@Override
	public long countOperatorBySQId(int sqId) {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("operateState", OperatorState.shanchu.getvalue());
		String hql = "";
		if (sqId == -1) {
			hql = "from VStaffHos vs where vs.loginName != null and vs.operateState <> :operateState";
		} else {
			params.put("sqId", sqId);
			hql = " from VStaffHos vs where vs.communityHospitalId = :sqId and vs.loginName != null and vs.operateState <> :operateState";
		}
		List<VStaffHos> list = vstaffHosDao.find(hql, params);
		if (list == null) {
			return 0;
		}
		return list.size();
	}

	@Override
	public List<VStaffHos> getAllStaffBySQIdExceptOpe(int sqId) {
		Map<String, Object> params = new HashMap<String, Object>();
		int roleId=this.getRoleByCom().getRoleId();
		params.put("roleId",roleId);
		params.put("sqId", sqId);
		String hql = "";
		if (sqId == -1) {
			hql = "from VStaffHos vs where vs.loginName = null and (vs.roleId = null or vs.roleId <> :roleId) order by staffId desc";
		} else {
			hql = " from VStaffHos vs where vs.communityHospitalId = :sqId  and vs.loginName = null and vs.operateState != "
					+ OperatorState.shanchu.getvalue() + "and (vs.roleId = null or vs.roleId <> :roleId) order by staffId desc";
		}
		
		return vstaffHosDao.find(hql, params);
	}

	@Override
	public List<VStaffHos> getOperatorBySearch(int sqId, int flag, String value) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("value", "%" + value + "%");
		params.put("operateState", OperatorState.shanchu.getvalue());

		if (flag == 0) {// flag 0请选择 1编号 2姓名 3登录名
			return null;
		}
		if (value == null) {
			return null;
		}
		if (value.equals("")) {
			return null;
		}
		String hql = "from VStaffHos vs where 1=1 ";
		if (flag == 1) {
			String hql1 = "and vs.staffNumber like :value ";
			hql += hql1;
		}
		if (flag == 2) {
			String hql2 = " and vs.name like :value ";
			hql += hql2;
		}
		if (flag == 3) {
			String hql3 = " and vs.loginName like :value ";
			hql += hql3;
		}
		String hql4 = " and vs.loginName != null and vs.operateState <> :operateState ";
		hql += hql4;
		if (sqId != -1) {
			params.put("sqId", sqId);
			String hql5 = " and vs.communityHospitalId =:sqId ";
			hql += hql5;
		}
		return vstaffHosDao.find(hql, params);
	}

	@Override
	public long countOpeartorBySearch(int sqId, int flag, String value) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("value", "%" + value + "%");
		params.put("operateState", OperatorState.shanchu.getvalue());
		if (flag == 0) {// flag 0请选择 1编号 2姓名 3登录名
			return 0;
		}
		if (value == null) {
			return 0;
		}
		if (value.equals("")) {
			return 0;
		}
		String hql = "select count(staffId) from VStaffHos vs where 1=1 ";
		if (flag == 1) {
			String hql1 = "and vs.staffNumber like :value ";
			hql += hql1;
		}
		if (flag == 2) {
			String hql2 = "and vs.name like :value ";
			hql += hql2;
		}
		if (flag == 3) {
			String hql3 = "and vs.loginName like :value ";
			hql += hql3;
		}
		if (flag == 4) {
			String hql6 = "and vs.communityHospital like :value ";
			hql += hql6;
		}
		String hql4 = " and vs.loginName != null and vs.operateState <> :operateState ";
		hql += hql4;
		if (sqId != -1) {// 如果不是平台管理员
			params.put("sqId", sqId);
			String hql5 = "and vs.communityHospitalId =:sqId ";
			hql += hql5;
		}
		hql += " order by staffId desc";
		return vstaffHosDao.count(hql, params);
	}

	@Override
	public List<VStaffHos> getOperatorBySearchByPage(int sqId, int flag, String value, Page page) {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("value", "%" + value + "%");
		params.put("operateState", OperatorState.shanchu.getvalue());
		if (flag == 0) {// flag 0请选择 1编号 2姓名 3登录名
			return null;
		}
		if (value == null) {
			return null;
		}
		if (value.equals("")) {
			return null;
		}
		String hql = "from VStaffHos vs where 1=1 ";
		if (flag == 1) {
			String hql1 = "and vs.staffNumber like :value ";
			hql += hql1;
		}
		if (flag == 2) {
			String hql2 = " and vs.name like :value ";
			hql += hql2;
		}
		if (flag == 3) {
			String hql3 = " and vs.loginName like :value ";
			hql += hql3;
		}
		if (flag == 4) {
			String hql5 = " and vs.communityHospital like :value ";
			hql += hql5;
		}
		if (sqId != -1) {
			params.put("sqId", sqId);
			String hql4 = " and vs.communityHospitalId = :sqId  and vs.loginName != null and vs.operateState <> :operateState";
			hql += hql4;
		} else {
			String hql4 = " and vs.loginName != null and vs.operateState <> :operateState";
			hql += hql4;
		}
		hql += "and (vs.roleId <> 0 or vs.roleId = null) order by staffId desc";
		return vstaffHosDao.find(hql, params, page.getCurrentPage(), page.getPageSize());
	}

	@Override
	public long countStaffBySearch(int dis, int flag, String value, String state, String department, int sqId) {
		List<TStaff> staffs = this.getStaffsBySearch(dis, flag, value, state, department, sqId);
		if (staffs == null) {
			return 0;
		}
		return staffs.size();
	}

	@Override
	public List<TStaff> getStaffsBySearch(int dis, int flag, String value, String state, String department, int sqId,
			Page page) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (flag != 0) {
			if (value != null && !value.equals("") && value != "") {
				params.put("value", "%" + value + "%");
			}
		}
		if (state != null && !state.equals("") && state != "") {
			params.put("state", state);
		}
		if (department != null && !department.equals("") && department != "") {
			params.put("department", department);
		}
		if (sqId != -1) {// 不是平台管理员
			params.put("sqId", sqId);
		}

		params.put("operateState", OperatorState.shanchu.getvalue());
		SearchUtil su = new SearchUtil();
		String hql = su.getStaffHql(dis, flag, value, state, department, sqId);
		String hql1 = "  and staff.operateState <> :operateState";
		hql += hql1;
		hql += " order by staffId desc";
		List<VStaffHos> list = vstaffHosDao.find(hql, params, page.getCurrentPage(), page.getPageSize());
		if (list == null || list.size() == 0 || list.equals("")) {
			return null;
		}
		List<TStaff> staffs = new ArrayList<TStaff>();
		for (int i = 0; i < list.size(); i++) {
			int id = list.get(i).getStaffId();
			staffs.add(this.getStaffById(id));
		}
		return staffs;
	}

	@Override
	public TOldStaffHos getOldStaffHosByStaffId(int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String hql = "from TOldStaffHos to where to.TStaff.staffId=:staffId";
		return oldStaffHosDao.Get(hql, params);
	}

	@Override
	public int getCommHospitalByStaffId(int staffId) {
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("staffId", staffId);
			String hql = "from TOldStaffHos to where to.TStaff.staffId=:staffId";
			int comHospital = oldStaffHosDao.Get(hql, params).getTCommunityHospital().getCommunityHospitalId();
			return comHospital;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<TStaff> getStaffBySearch(int flag, String value, String state, String department) {
		SearchUtil su = new SearchUtil();
		Map<String, Object> params = new HashMap<String, Object>();
		if (flag != 0) {
			if (value != null && !value.equals("") && value != "") {
				params.put("value", "%" + value + "%");
			}
		}
		if (state != null && !state.equals("") && state != "") {
			params.put("state", state);
		}
		if (department != null && !department.equals("") && department != "") {
			params.put("department", department);
		}
		// params.put("operateState", OperatorState.shanchu.getvalue());
		String hql = su.getTStaffHql(flag, value, state, department);
		params.put("operateState", OperatorState.shanchu.getvalue());
		String hql3 = " and staff.operateState <> :operateState ";
		hql += hql3;
		
		List<VStaffHos> list = vstaffHosDao.find(hql, params);
		if (list == null || list.size() == 0 || list.equals("")) {
			return null;
		}
		List<TStaff> staffs = new ArrayList<TStaff>();
		for (int i = 0; i < list.size(); i++) {
			int id = list.get(i).getStaffId();
			staffs.add(this.getStaffById(id));
		}
		
		//return staffDao.find(hql, params);
		return staffs;
	}

	@Override
	public long countStaffBySearch(int flag, String value, String state, String department) {
		List<TStaff> list = this.getStaffBySearch(flag, value, state, department);
		if (list == null) {
			return 0;
		}
		return list.size();
	}

	@Override
	public List<TStaff> getStaffBySearch(int flag, String value, String state, String department, Page page) {
		SearchUtil su = new SearchUtil();
		Map<String, Object> params = new HashMap<String, Object>();
		if (flag != 0) {
			if (value != null && !value.equals("") && value != "") {
				params.put("value", "%" + value + "%");
			}
		}
		if (state != null && !state.equals("") && state != "") {
			params.put("state", state);
		}
		if (department != null && !department.equals("") && department != "") {
			params.put("department", department);
		}
		params.put("operateState", OperatorState.shanchu.getvalue());
		String hql = su.getTStaffHql(flag, value, state, department);
		return staffDao.find(hql, params, page.getCurrentPage(), page.getPageSize());
	}

	@Override
	public List<TStaff> getAllStaff() {
		String hql = "from TStaff staff where staff.operateState <> " + OperatorState.shanchu.getvalue()
				+ " order by staff.staffId desc";
		return staffDao.find(hql);
	}

	@Override
	public Boolean getStaffIsHospital(int staffId, int hosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		params.put("hosId", hosId);
		String hql = "from TOldStaffHos to where to.TStaff.staffId=:staffId and to.TCommunityHospital.communityHospitalId =:hosId";
		List<TOldStaffHos> list = oldStaffHosDao.find(hql, params);
		if (list == null) {
			return false;
		} else {
			if (list.size() == 0) {
				return false;
			}
			return true;
		}
	}

	@Override
	public TOldStaffHos gethosByFileid(int fid) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fid", fid);
		String hql = "from TOldStaffHos ts where ts.THealthFile.healthFileId =:fid";
		return oldStaffHosDao.Get(hql, params);
	}

	@Override
	public VStaffHos getVStaffById(int id) {
		String hql = "from VStaffHos where staffId = " + id;
		return vstaffHosDao.Get(hql);
	}

	public List<TStaff> getStaffByCommGroupHospitalId(int groupId, Page page) {
		Map<String, Object> params = new HashMap<String, Object>();
		int roleId=this.getRoleByCom().getRoleId();
		params.put("roleId",roleId);
		params.put("operateState", OperatorState.shanchu.getvalue());
		params.put("groupId", groupId);
		String hql = " from VStaffHos vs where vs.GId = :groupId and vs.operateState <> :operateState and (vs.roleId = null or vs.roleId <> :roleId) order by vs.staffId desc ";
		List<VStaffHos> list = vstaffHosDao.find(hql, params, page.getCurrentPage(), page.getPageSize());
		if (list.size() == 0 || list == null || list.equals("")) {
			return null;
		}
		List<TStaff> staffs = new ArrayList<TStaff>();
		for (int i = 0; i < list.size(); i++) {
			int id = list.get(i).getStaffId();
			staffs.add(this.getStaffById(id));
		}
		return staffs;
	}

	/////// 社区集团
	public long countStaffByCommGroupHospitalId(int sqId) {
		Map<String, Object> params = new HashMap<String, Object>();
		int roleId=this.getRoleByCom().getRoleId();
		params.put("roleId",roleId);
		params.put("operateState", OperatorState.shanchu.getvalue());
		params.put("sqId", sqId);
		String hql = " from VStaffHos vs where vs.GId = :sqId and vs.operateState <> :operateState and (vs.roleId = null or vs.roleId <> :roleId) order by vs.staffId desc";
		List<VStaffHos> list = vstaffHosDao.find(hql, params);
		if (list == null) {
			return 0;
		}
		return list.size();
	}

	/*
	 * public List<TStaff> getStaffsGroupBySearch(int flag, String value, String
	 * state, String department, int GId) { Map<String, Object> params = new
	 * HashMap<String, Object>(); if(flag !=0 ){ if(value != null &&
	 * !value.equals("") && value != ""){ params.put("value", "%"+value+"%"); }
	 * } if(state != null && !state.equals("") && state != ""){
	 * params.put("state", state); } if(department != null &&
	 * !department.equals("") && department != ""){ params.put("department",
	 * department); } params.put("GId", GId); SearchUtil su = new SearchUtil();
	 * String hql = su.getStaffHql(flag, value, state, department,GId);
	 * params.put("operateState", OperatorState.shanchu.getvalue()); String hql3
	 * = " and staff.operateState <> :operateState"; hql+=hql3; List<VStaffHos>
	 * list = vstaffHosDao.find(hql,params); if(list == null || list.size() == 0
	 * || list.equals("")){ return null; } List<TStaff> staffs = new
	 * ArrayList<TStaff>(); for(int i = 0; i<list.size(); i++){ int
	 * id=list.get(i).getStaffId(); staffs.add(this.getStaffById(id)); } return
	 * staffs; }
	 * 
	 * public long countStaffGroupBySearch(int flag, String value, String state,
	 * String department, int sqId) { List<TStaff> staffs =
	 * this.getStaffsGroupBySearch(flag, value, state, department, sqId);
	 * if(staffs == null){ return 0; } return staffs.size(); }
	 */

	// 得到社区医院集团id
	public int getCommHoGroupByStaffId(int staffId) {
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("staffId", staffId);
			String hql = "from TOldStaffHos to where to.TStaff.staffId=:staffId";
			int comHospitalGroup = oldStaffHosDao.Get(hql, params).getTCommunityHospital().getTCommunityHospitalGroup()
					.getGId();
			return comHospitalGroup;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public long countOperatorGroupBySQId(int GId) {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("operateState", OperatorState.shanchu.getvalue());
		String hql = "";
		params.put("GId", GId);
		hql = " from VStaffHos vs where vs.GId = :GId and vs.loginName != null and vs.operateState <> :operateState";
		List<VStaffHos> list = vstaffHosDao.find(hql, params);
		if (list == null) {
			return 0;
		}
		return list.size();
	}

	public List<VStaffHos> getAllOperatorGroup(int GId, Page page) {
		String hql = "";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("operateState", OperatorState.shanchu.getvalue());
		params.put("GId", GId);
		hql = " from VStaffHos vs where vs.GId = :GId and vs.loginName != null and vs.operateState <>:operateState  order by staffId desc";
		return vstaffHosDao.find(hql, params, page.getCurrentPage(), page.getPageSize());
	}

	// 社区集团查询
	public long countOpeartorGroupBySearch(int GId, int flag, String value) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("value", "%" + value + "%");
		params.put("operateState", OperatorState.shanchu.getvalue());
		if (flag == 0) {// flag 0请选择 1编号 2姓名 3登录名  4社区医院
			return 0;
		}
		if (value == null) {
			return 0;
		}
		if (value.equals("")) {
			return 0;
		}
		String hql = "select count(staffId) from VStaffHos vs where 1=1 ";
		if (flag == 1) {
			String hql1 = "and vs.staffNumber like :value ";
			hql += hql1;
		}
		if (flag == 2) {
			String hql2 = "and vs.name like :value ";
			hql += hql2;
		}
		if (flag == 3) {
			String hql3 = "and vs.loginName like :value ";
			hql += hql3;
		}
		if (flag == 4) {
			String hql6 = "and vs.communityHospital like :value ";
			hql += hql6;
		}
		String hql4 = " and vs.loginName != null and vs.operateState <> :operateState ";
		hql += hql4;
		params.put("GId", GId);
		String hql5 = "and vs.GId =:GId ";
		hql += hql5;
		hql += " order by staffId desc";
		return vstaffHosDao.count(hql, params);
	}

	public List<VStaffHos> getOperatorGroupBySearchByPage(int GId, int flag, String value, Page page) {
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("value", "%" + value + "%");
		params.put("operateState", OperatorState.shanchu.getvalue());
		if (flag == 0) {// flag 0请选择 1编号 2姓名 3登录名 4社区医院
			return null;
		}
		if (value == null) {
			return null;
		}
		if (value.equals("")) {
			return null;
		}
		String hql = "from VStaffHos vs where 1=1 ";
		if (flag == 1) {
			String hql1 = "and vs.staffNumber like :value ";
			hql += hql1;
		}
		if (flag == 2) {
			String hql2 = " and vs.name like :value ";
			hql += hql2;
		}
		if (flag == 3) {
			String hql3 = " and vs.loginName like :value ";
			hql += hql3;
		}
		if (flag == 4) {
			String hql5 = " and vs.communityHospital like :value ";
			hql += hql5;
		}
		params.put("GId", GId);
		String hql4 = " and vs.GId = :GId  and vs.loginName != null and vs.operateState <> :operateState";
		hql += hql4;
		hql += " order by staffId desc";
		return vstaffHosDao.find(hql, params, page.getCurrentPage(), page.getPageSize());
	}


    @Override
    public TRole getRoleByCom() {
        String hql="from TRole tr where tr.communityId = 0";
        return roleDao.Get(hql);
    }




}
