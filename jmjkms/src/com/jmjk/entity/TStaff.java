package com.jmjk.entity;
// default package

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TStaff entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_STAFF", catalog = "jmjk")
public class TStaff implements java.io.Serializable {

	// Fields

	private Integer staffId;
	private TRole TRole;
	private String staffNumber;
	private String state;
	private String name;
	private String loginName;
	private String password;
	private Integer operateState;
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
	private Boolean isSpecialDoctor;
	private Boolean isHomeOld;
	private Boolean isAgencyOld;
	private String station;
	private String province;
	private String city;
	private String county;
	private String detailAddress;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private Set<TOldStaffHos> TOldStaffHoses = new HashSet<TOldStaffHos>(0);
	private Set<TComminityClinic> TComminityClinics = new HashSet<TComminityClinic>(
			0);
	private Set<TStaffRewardPunish> TStaffRewardPunishs = new HashSet<TStaffRewardPunish>(
			0);
	private Set<TRecoveryScheme> TRecoverySchemes = new HashSet<TRecoveryScheme>(
			0);
	private Set<TDoctorDiagnosis> TDoctorDiagnosises = new HashSet<TDoctorDiagnosis>(
			0);
	private Set<TStaffLeave> TStaffLeaves = new HashSet<TStaffLeave>(0);
	private Set<TEquipmentManage> TEquipmentManages = new HashSet<TEquipmentManage>(
			0);
	private Set<TKnowledgeLecture> TKnowledgeLectures = new HashSet<TKnowledgeLecture>(
			0);
	private Set<TDoorKnocking> TDoorKnockings = new HashSet<TDoorKnocking>(0);
	private Set<THealthEdu> THealthEdus = new HashSet<THealthEdu>(0);
	private Set<TRecoveryPlan> TRecoveryPlans = new HashSet<TRecoveryPlan>(0);

	// Constructors

	/** default constructor */
	public TStaff() {
	}

	/** minimal constructor */
	public TStaff(String staffNumber, String state, String name,
			String idCardNum, String department, String job, String phone) {
		this.staffNumber = staffNumber;
		this.state = state;
		this.name = name;
		this.idCardNum = idCardNum;
		this.department = department;
		this.job = job;
		this.phone = phone;
	}

	/** full constructor */
	public TStaff(int staffId){
		this.staffId=staffId;
	}
	public TStaff(String name){
		this.name=name;
	}
	public TStaff(TRole TRole, String staffNumber, String state, String name,
			String loginName, String password, Integer operateState,
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
			Timestamp trainStratDate, Timestamp trainEndDate,
			Boolean isSpecialDoctor, Boolean isHomeOld, Boolean isAgencyOld,
			String province, String city, String county, String detailAddress,
			String station, String one, String two, String three, String four,
			String five, Set<TOldStaffHos> TOldStaffHoses,
			Set<TComminityClinic> TComminityClinics,
			Set<TStaffRewardPunish> TStaffRewardPunishs,
			Set<TRecoveryScheme> TRecoverySchemes,
			Set<TDoctorDiagnosis> TDoctorDiagnosises,
			Set<TStaffLeave> TStaffLeaves,
			Set<TEquipmentManage> TEquipmentManages,
			Set<TKnowledgeLecture> TKnowledgeLectures,
			Set<TDoorKnocking> TDoorKnockings, Set<THealthEdu> THealthEdus,
			Set<TRecoveryPlan> TRecoveryPlans) {
		this.TRole = TRole;
		this.staffNumber = staffNumber;
		this.state = state;
		this.name = name;
		this.loginName = loginName;
		this.password = password;
		this.operateState = operateState;
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
		this.province=province;
		this.city =city;
		this.county = county;
		this.detailAddress = detailAddress;
		this.trainStratDate = trainStratDate;
		this.trainEndDate = trainEndDate;
		this.isSpecialDoctor = isSpecialDoctor;
		this.isHomeOld = isHomeOld;
		this.isAgencyOld = isAgencyOld;
		this.station = station;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.TOldStaffHoses = TOldStaffHoses;
		this.TComminityClinics = TComminityClinics;
		this.TStaffRewardPunishs = TStaffRewardPunishs;
		this.TRecoverySchemes = TRecoverySchemes;
		this.TDoctorDiagnosises = TDoctorDiagnosises;
		this.TStaffLeaves = TStaffLeaves;
		this.TEquipmentManages = TEquipmentManages;
		this.TKnowledgeLectures = TKnowledgeLectures;
		this.TDoorKnockings = TDoorKnockings;
		this.THealthEdus = THealthEdus;
		this.TRecoveryPlans = TRecoveryPlans;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "STAFF_ID", unique = true, nullable = false)
	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID")
	public TRole getTRole() {
		return this.TRole;
	}

	public void setTRole(TRole TRole) {
		this.TRole = TRole;
	}

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

	@Column(name = "OPERATE_STATE")
	public Integer getOperateState() {
		return this.operateState;
	}

	public void setOperateState(Integer operateState) {
		this.operateState = operateState;
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

	@Column(name = "IS_SPECIAL_DOCTOR")
	public Boolean getIsSpecialDoctor() {
		return this.isSpecialDoctor;
	}

	public void setIsSpecialDoctor(Boolean isSpecialDoctor) {
		this.isSpecialDoctor = isSpecialDoctor;
	}

	@Column(name = "IS_HOME_OLD")
	public Boolean getIsHomeOld() {
		return this.isHomeOld;
	}

	public void setIsHomeOld(Boolean isHomeOld) {
		this.isHomeOld = isHomeOld;
	}

	@Column(name = "IS_AGENCY_OLD")
	public Boolean getIsAgencyOld() {
		return this.isAgencyOld;
	}

	public void setIsAgencyOld(Boolean isAgencyOld) {
		this.isAgencyOld = isAgencyOld;
	}

	@Column(name = "STATION")
	public String getStation() {
		return this.station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	@Column(name = "ONE", length = 1000)
	public String getOne() {
		return this.one;
	}

	public void setOne(String one) {
		this.one = one;
	}

	@Column(name = "TWO", length = 1000)
	public String getTwo() {
		return this.two;
	}

	public void setTwo(String two) {
		this.two = two;
	}

	@Column(name = "THREE", length = 1000)
	public String getThree() {
		return this.three;
	}

	public void setThree(String three) {
		this.three = three;
	}

	@Column(name = "FOUR", length = 1000)
	public String getFour() {
		return this.four;
	}

	public void setFour(String four) {
		this.four = four;
	}

	@Column(name = "FIVE", length = 1000)
	public String getFive() {
		return this.five;
	}

	public void setFive(String five) {
		this.five = five;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TStaff")
	public Set<TOldStaffHos> getTOldStaffHoses() {
		return this.TOldStaffHoses;
	}

	public void setTOldStaffHoses(Set<TOldStaffHos> TOldStaffHoses) {
		this.TOldStaffHoses = TOldStaffHoses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TStaff")
	public Set<TComminityClinic> getTComminityClinics() {
		return this.TComminityClinics;
	}

	public void setTComminityClinics(Set<TComminityClinic> TComminityClinics) {
		this.TComminityClinics = TComminityClinics;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TStaff")
	public Set<TStaffRewardPunish> getTStaffRewardPunishs() {
		return this.TStaffRewardPunishs;
	}

	public void setTStaffRewardPunishs(
			Set<TStaffRewardPunish> TStaffRewardPunishs) {
		this.TStaffRewardPunishs = TStaffRewardPunishs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TStaff")
	public Set<TRecoveryScheme> getTRecoverySchemes() {
		return this.TRecoverySchemes;
	}

	public void setTRecoverySchemes(Set<TRecoveryScheme> TRecoverySchemes) {
		this.TRecoverySchemes = TRecoverySchemes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TStaff")
	public Set<TDoctorDiagnosis> getTDoctorDiagnosises() {
		return this.TDoctorDiagnosises;
	}

	public void setTDoctorDiagnosises(Set<TDoctorDiagnosis> TDoctorDiagnosises) {
		this.TDoctorDiagnosises = TDoctorDiagnosises;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TStaff")
	public Set<TStaffLeave> getTStaffLeaves() {
		return this.TStaffLeaves;
	}

	public void setTStaffLeaves(Set<TStaffLeave> TStaffLeaves) {
		this.TStaffLeaves = TStaffLeaves;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TStaff")
	public Set<TEquipmentManage> getTEquipmentManages() {
		return this.TEquipmentManages;
	}

	public void setTEquipmentManages(Set<TEquipmentManage> TEquipmentManages) {
		this.TEquipmentManages = TEquipmentManages;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TStaff")
	public Set<TKnowledgeLecture> getTKnowledgeLectures() {
		return this.TKnowledgeLectures;
	}

	public void setTKnowledgeLectures(Set<TKnowledgeLecture> TKnowledgeLectures) {
		this.TKnowledgeLectures = TKnowledgeLectures;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TStaff")
	public Set<TDoorKnocking> getTDoorKnockings() {
		return this.TDoorKnockings;
	}

	public void setTDoorKnockings(Set<TDoorKnocking> TDoorKnockings) {
		this.TDoorKnockings = TDoorKnockings;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TStaff")
	public Set<THealthEdu> getTHealthEdus() {
		return this.THealthEdus;
	}

	public void setTHealthEdus(Set<THealthEdu> THealthEdus) {
		this.THealthEdus = THealthEdus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TStaff")
	public Set<TRecoveryPlan> getTRecoveryPlans() {
		return this.TRecoveryPlans;
	}

	public void setTRecoveryPlans(Set<TRecoveryPlan> TRecoveryPlans) {
		this.TRecoveryPlans = TRecoveryPlans;
	}

	@Column(name = "PROVINCE", length = 255)
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}
	@Column(name = "CITY", length = 255)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	@Column(name = "COUNTY", length = 255)
	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}
	@Column(name = "DETAIL_ADDRESS", length = 255)
	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}
	
	
	
	
	
	

}