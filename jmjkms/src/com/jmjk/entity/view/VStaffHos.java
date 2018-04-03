package com.jmjk.entity.view;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VStaffHos entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "V_STAFF_HOS", catalog = "jmjk")
public class VStaffHos implements java.io.Serializable {

	// Fields

	private Integer healthFileId;
	private Integer roleId;
	private String staffNumber;
	private String state;
	private String name;
	private String loginName;
	private String password;
	private Boolean sex;
	private String idCardNum;
	private Timestamp birthDate;
	private String maritalStatus;
	private String healthStatus;
	private String department;
	private String job;
	private String hireType;
	private Timestamp cometoOfficeDate;
	private Timestamp hireStratDate;
	private Timestamp hireEndDate;
	private String eduBackground;
	private String graduateSchool;
	private Timestamp graduateDate;
	private String professional;
	private String jobTitleLevel;
	private String jobTitleCertificate;
	private String jobTitleNum;
	private String englishLevel;
	private String computerLevel;
	private String certificateType;
	private String certificateName;
	private String cerificateNum;
	private String familyRegister;
	private Double wage;
	private String phone;
	private String zipCode;
	private String liveAddr;
	private String note;
	private String gpTrain;
	private Timestamp trainStratDate;
	private Timestamp trainEndDate;
	private String station;
	private String staffOne;
	private String staffTwo;
	private String staffThree;
	private String staffFour;
	private String staffFive;
	private Integer oldStaffHosId;
	private Integer staffId;
	private Integer communityHospitalId;
	private String hosOne;
	private String hosTwo;
	private String hosThree;
	private String hosFour;
	private String hosFive;
	private Integer operateState;
	private String roleName;
	private Integer GId;
	private String groupName;
	private String communityHospital;

	// Constructors

	/** default constructor */
	public VStaffHos() {
	}

	/** minimal constructor */
	public VStaffHos(Integer healthFileId, String staffNumber, String state,
			String name, String idCardNum, String department, String job,
			String phone) {
		this.healthFileId = healthFileId;
		this.staffNumber = staffNumber;
		this.state = state;
		this.name = name;
		this.idCardNum = idCardNum;
		this.department = department;
		this.job = job;
		this.phone = phone;
	}

	/** full constructor */
	public VStaffHos(Integer healthFileId, Integer roleId, String staffNumber,
			String state, String name, String loginName, String password,
			Boolean sex, String idCardNum, Timestamp birthDate,
			String maritalStatus, String healthStatus, String department,
			String job, String hireType, Timestamp cometoOfficeDate,
			Timestamp hireStratDate, Timestamp hireEndDate,
			String eduBackground, String graduateSchool,
			Timestamp graduateDate, String professional, String jobTitleLevel,
			String jobTitleCertificate, String jobTitleNum,
			String englishLevel, String computerLevel, String certificateType,
			String certificateName, String cerificateNum,
			String familyRegister, Double wage, String phone, String zipCode,
			String liveAddr, String note, String gpTrain,
			Timestamp trainStratDate, Timestamp trainEndDate, String station,
			String staffOne, String staffTwo, String staffThree,
			String staffFour, String staffFive, Integer oldStaffHosId,
			Integer staffId, Integer communityHospitalId, String hosOne,
			String hosTwo, String hosThree, String hosFour, String hosFive,
			Integer operateState, String roleName, Integer GId, String groupName) {
		this.healthFileId = healthFileId;
		this.roleId = roleId;
		this.staffNumber = staffNumber;
		this.state = state;
		this.name = name;
		this.loginName = loginName;
		this.password = password;
		this.sex = sex;
		this.idCardNum = idCardNum;
		this.birthDate = birthDate;
		this.maritalStatus = maritalStatus;
		this.healthStatus = healthStatus;
		this.department = department;
		this.job = job;
		this.hireType = hireType;
		this.cometoOfficeDate = cometoOfficeDate;
		this.hireStratDate = hireStratDate;
		this.hireEndDate = hireEndDate;
		this.eduBackground = eduBackground;
		this.graduateSchool = graduateSchool;
		this.graduateDate = graduateDate;
		this.professional = professional;
		this.jobTitleLevel = jobTitleLevel;
		this.jobTitleCertificate = jobTitleCertificate;
		this.jobTitleNum = jobTitleNum;
		this.englishLevel = englishLevel;
		this.computerLevel = computerLevel;
		this.certificateType = certificateType;
		this.certificateName = certificateName;
		this.cerificateNum = cerificateNum;
		this.familyRegister = familyRegister;
		this.wage = wage;
		this.phone = phone;
		this.zipCode = zipCode;
		this.liveAddr = liveAddr;
		this.note = note;
		this.gpTrain = gpTrain;
		this.trainStratDate = trainStratDate;
		this.trainEndDate = trainEndDate;
		this.station = station;
		this.staffOne = staffOne;
		this.staffTwo = staffTwo;
		this.staffThree = staffThree;
		this.staffFour = staffFour;
		this.staffFive = staffFive;
		this.oldStaffHosId = oldStaffHosId;
		this.staffId = staffId;
		this.communityHospitalId = communityHospitalId;
		this.hosOne = hosOne;
		this.hosTwo = hosTwo;
		this.hosThree = hosThree;
		this.hosFour = hosFour;
		this.hosFive = hosFive;
		this.operateState = operateState;
		this.roleName = roleName;
		this.GId = GId;
		this.groupName = groupName;
	}

	// Property accessors

	@Column(name = "HEALTH_FILE_ID")
	public Integer getHealthFileId() {
		return this.healthFileId;
	}

	public void setHealthFileId(Integer healthFileId) {
		this.healthFileId = healthFileId;
	}

	@Column(name = "ROLE_ID")
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Id
	@Column(name = "STAFF_NUMBER", nullable = false)
	public String getStaffNumber() {
		return this.staffNumber;
	}

	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}

	@Column(name = "STATE", nullable = false, length = 1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "NAME", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "LOGIN_NAME")
	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "SEX")
	public Boolean getSex() {
		return this.sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	@Column(name = "ID_CARD_NUM", nullable = false)
	public String getIdCardNum() {
		return this.idCardNum;
	}

	public void setIdCardNum(String idCardNum) {
		this.idCardNum = idCardNum;
	}

	@Column(name = "BIRTH_DATE", length = 19)
	public Timestamp getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "MARITAL_STATUS")
	public String getMaritalStatus() {
		return this.maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	@Column(name = "HEALTH_STATUS")
	public String getHealthStatus() {
		return this.healthStatus;
	}

	public void setHealthStatus(String healthStatus) {
		this.healthStatus = healthStatus;
	}

	@Column(name = "DEPARTMENT", nullable = false)
	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "JOB", nullable = false)
	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	@Column(name = "HIRE_TYPE")
	public String getHireType() {
		return this.hireType;
	}

	public void setHireType(String hireType) {
		this.hireType = hireType;
	}

	@Column(name = "COMETO_OFFICE_DATE", length = 19)
	public Timestamp getCometoOfficeDate() {
		return this.cometoOfficeDate;
	}

	public void setCometoOfficeDate(Timestamp cometoOfficeDate) {
		this.cometoOfficeDate = cometoOfficeDate;
	}

	@Column(name = "HIRE_STRAT_DATE", length = 19)
	public Timestamp getHireStratDate() {
		return this.hireStratDate;
	}

	public void setHireStratDate(Timestamp hireStratDate) {
		this.hireStratDate = hireStratDate;
	}

	@Column(name = "HIRE_END_DATE", length = 19)
	public Timestamp getHireEndDate() {
		return this.hireEndDate;
	}

	public void setHireEndDate(Timestamp hireEndDate) {
		this.hireEndDate = hireEndDate;
	}

	@Column(name = "EDU_BACKGROUND")
	public String getEduBackground() {
		return this.eduBackground;
	}

	public void setEduBackground(String eduBackground) {
		this.eduBackground = eduBackground;
	}

	@Column(name = "GRADUATE_SCHOOL")
	public String getGraduateSchool() {
		return this.graduateSchool;
	}

	public void setGraduateSchool(String graduateSchool) {
		this.graduateSchool = graduateSchool;
	}

	@Column(name = "GRADUATE_DATE", length = 19)
	public Timestamp getGraduateDate() {
		return this.graduateDate;
	}

	public void setGraduateDate(Timestamp graduateDate) {
		this.graduateDate = graduateDate;
	}

	@Column(name = "PROFESSIONAL")
	public String getProfessional() {
		return this.professional;
	}

	public void setProfessional(String professional) {
		this.professional = professional;
	}

	@Column(name = "JOB_TITLE_LEVEL")
	public String getJobTitleLevel() {
		return this.jobTitleLevel;
	}

	public void setJobTitleLevel(String jobTitleLevel) {
		this.jobTitleLevel = jobTitleLevel;
	}

	@Column(name = "JOB_TITLE_CERTIFICATE")
	public String getJobTitleCertificate() {
		return this.jobTitleCertificate;
	}

	public void setJobTitleCertificate(String jobTitleCertificate) {
		this.jobTitleCertificate = jobTitleCertificate;
	}

	@Column(name = "JOB_TITLE_NUM")
	public String getJobTitleNum() {
		return this.jobTitleNum;
	}

	public void setJobTitleNum(String jobTitleNum) {
		this.jobTitleNum = jobTitleNum;
	}

	@Column(name = "ENGLISH_LEVEL")
	public String getEnglishLevel() {
		return this.englishLevel;
	}

	public void setEnglishLevel(String englishLevel) {
		this.englishLevel = englishLevel;
	}

	@Column(name = "COMPUTER_LEVEL")
	public String getComputerLevel() {
		return this.computerLevel;
	}

	public void setComputerLevel(String computerLevel) {
		this.computerLevel = computerLevel;
	}

	@Column(name = "CERTIFICATE_TYPE")
	public String getCertificateType() {
		return this.certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	@Column(name = "CERTIFICATE_NAME")
	public String getCertificateName() {
		return this.certificateName;
	}

	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	@Column(name = "CERIFICATE_NUM")
	public String getCerificateNum() {
		return this.cerificateNum;
	}

	public void setCerificateNum(String cerificateNum) {
		this.cerificateNum = cerificateNum;
	}

	@Column(name = "FAMILY_REGISTER")
	public String getFamilyRegister() {
		return this.familyRegister;
	}

	public void setFamilyRegister(String familyRegister) {
		this.familyRegister = familyRegister;
	}

	@Column(name = "WAGE", precision = 22, scale = 0)
	public Double getWage() {
		return this.wage;
	}

	public void setWage(Double wage) {
		this.wage = wage;
	}

	@Column(name = "PHONE", nullable = false)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "ZIP_CODE")
	public String getZipCode() {
		return this.zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Column(name = "LIVE_ADDR")
	public String getLiveAddr() {
		return this.liveAddr;
	}

	public void setLiveAddr(String liveAddr) {
		this.liveAddr = liveAddr;
	}

	@Column(name = "NOTE", length = 65535)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "GP_TRAIN")
	public String getGpTrain() {
		return this.gpTrain;
	}

	public void setGpTrain(String gpTrain) {
		this.gpTrain = gpTrain;
	}

	@Column(name = "TRAIN_STRAT_DATE", length = 19)
	public Timestamp getTrainStratDate() {
		return this.trainStratDate;
	}

	public void setTrainStratDate(Timestamp trainStratDate) {
		this.trainStratDate = trainStratDate;
	}

	@Column(name = "TRAIN_END_DATE", length = 19)
	public Timestamp getTrainEndDate() {
		return this.trainEndDate;
	}

	public void setTrainEndDate(Timestamp trainEndDate) {
		this.trainEndDate = trainEndDate;
	}

	@Column(name = "STATION")
	public String getStation() {
		return this.station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	@Column(name = "STAFF_ONE", length = 1000)
	public String getStaffOne() {
		return this.staffOne;
	}

	public void setStaffOne(String staffOne) {
		this.staffOne = staffOne;
	}

	@Column(name = "STAFF_TWO", length = 1000)
	public String getStaffTwo() {
		return this.staffTwo;
	}

	public void setStaffTwo(String staffTwo) {
		this.staffTwo = staffTwo;
	}

	@Column(name = "STAFF_THREE", length = 1000)
	public String getStaffThree() {
		return this.staffThree;
	}

	public void setStaffThree(String staffThree) {
		this.staffThree = staffThree;
	}

	@Column(name = "STAFF_FOUR", length = 1000)
	public String getStaffFour() {
		return this.staffFour;
	}

	public void setStaffFour(String staffFour) {
		this.staffFour = staffFour;
	}

	@Column(name = "STAFF_FIVE", length = 1000)
	public String getStaffFive() {
		return this.staffFive;
	}

	public void setStaffFive(String staffFive) {
		this.staffFive = staffFive;
	}

	@Column(name = "OLD_STAFF_HOS_ID")
	public Integer getOldStaffHosId() {
		return this.oldStaffHosId;
	}

	public void setOldStaffHosId(Integer oldStaffHosId) {
		this.oldStaffHosId = oldStaffHosId;
	}

	@Column(name = "STAFF_ID")
	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	@Column(name = "COMMUNITY_HOSPITAL_ID")
	public Integer getCommunityHospitalId() {
		return this.communityHospitalId;
	}

	public void setCommunityHospitalId(Integer communityHospitalId) {
		this.communityHospitalId = communityHospitalId;
	}

	@Column(name = "HOS_ONE", length = 1000)
	public String getHosOne() {
		return this.hosOne;
	}

	public void setHosOne(String hosOne) {
		this.hosOne = hosOne;
	}

	@Column(name = "HOS_TWO", length = 1000)
	public String getHosTwo() {
		return this.hosTwo;
	}

	public void setHosTwo(String hosTwo) {
		this.hosTwo = hosTwo;
	}

	@Column(name = "HOS_THREE", length = 1000)
	public String getHosThree() {
		return this.hosThree;
	}

	public void setHosThree(String hosThree) {
		this.hosThree = hosThree;
	}

	@Column(name = "HOS_FOUR", length = 1000)
	public String getHosFour() {
		return this.hosFour;
	}

	public void setHosFour(String hosFour) {
		this.hosFour = hosFour;
	}

	@Column(name = "HOS_FIVE", length = 1000)
	public String getHosFive() {
		return this.hosFive;
	}

	public void setHosFive(String hosFive) {
		this.hosFive = hosFive;
	}

	@Column(name = "OPERATE_STATE")
	public Integer getOperateState() {
		return this.operateState;
	}

	public void setOperateState(Integer operateState) {
		this.operateState = operateState;
	}

	@Column(name = "ROLE_NAME")
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "G_ID")
	public Integer getGId() {
		return this.GId;
	}

	public void setGId(Integer GId) {
		this.GId = GId;
	}

	@Column(name = "GROUP_NAME")
	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	@Column(name = "COMMUNITY_HOSPITAl", nullable = false)
	public String getCommunityHospital() {
		return this.communityHospital;
	}

	public void setCommunityHospital(String communityHospital) {
		this.communityHospital = communityHospital;
	}

}