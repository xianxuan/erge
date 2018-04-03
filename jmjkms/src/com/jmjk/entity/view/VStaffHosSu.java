package com.jmjk.entity.view;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VStaffHosSu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "V_STAFF_HOS_SU", catalog = "jmjk")
public class VStaffHosSu implements java.io.Serializable {

	// Fields

	private Integer healthFileId;
	private Integer roleId;
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
	private String station;
	private Integer oldStaffHosId;
	private Integer staffId;
	private Integer communityHospitalId;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private String roleName;
	private String fileNum;
	private String fileName;
	private Timestamp fileDate;
	private String enterPeople;
	private String filePerson;
	private Boolean fileSex;
	private String idNum;
	private Timestamp fileBirthDate;
	private Integer age;
	private String workUnit;
	private String IPhone;
	private String pic;
	private String otherName;
	private String otherPhone;
	private String hospital;
	private String permanentType;
	private String nation;
	private String eduLevel;
	private String fileJob;
	private String bloodTypr;
	private String rhNegative;
	private String fileMaritalStatus;
	private String email;
	private String currentProvince;
	private String currentOffice;
	private String currentResidentCommittee;
	private String currentCommunity;
	private String otherAddressType;
	private String otherProvince;
	private String otherCity;
	private String otherCounty;
	private String otherCommunity;
	private String allergyName;
	private String exposeName;
	private String exposeNote;
	private String fatherDisease;
	private String motherDisease;
	private String borSisDisease;
	private String childDisease;
	private String otherDisease;
	private String disabilityName;
	private String geneticHistory;
	private String kitVenFac;
	private String fuelType;
	private String drinkWater;
	private String toilet;
	private String livestockBar;
	private String crowdClass;
	private String healthFileType;
	private String currentCity;
	private String currentCounty;
	private Integer GId;

	// Constructors

	/** default constructor */
	public VStaffHosSu() {
	}

	/** minimal constructor */
	public VStaffHosSu(Integer healthFileId, String staffNumber, String state,
			String name, String idCardNum, String department, String job,
			String phone, Integer oldStaffHosId, String roleName,
			String fileName, String idNum, String IPhone) {
		this.healthFileId = healthFileId;
		this.staffNumber = staffNumber;
		this.state = state;
		this.name = name;
		this.idCardNum = idCardNum;
		this.department = department;
		this.job = job;
		this.phone = phone;
		this.oldStaffHosId = oldStaffHosId;
		this.roleName = roleName;
		this.fileName = fileName;
		this.idNum = idNum;
		this.IPhone = IPhone;
	}

	/** full constructor */
	public VStaffHosSu(Integer healthFileId, Integer roleId,
			String staffNumber, String state, String name, String loginName,
			String password, Integer operateState, Boolean sex,
			String idCardNum, Timestamp birthDate, String maritalStatus,
			String healthStatus, String department, String job,
			String hireType, Timestamp cometoOfficeDate,
			Timestamp hireStratDate, Timestamp hireEndDate,
			String eduBackground, String graduateSchool,
			Timestamp graduateDate, String professional, String jobTitleLevel,
			String jobTitleCertificate, String jobTitleNum,
			String englishLevel, String computerLevel, String certificateType,
			String certificateName, String cerificateNum,
			String familyRegister, Double wage, String phone, String zipCode,
			String liveAddr, String note, String gpTrain,
			Timestamp trainStratDate, Timestamp trainEndDate, String station,
			Integer oldStaffHosId, Integer staffId,
			Integer communityHospitalId, String one, String two, String three,
			String four, String five, String roleName, String fileNum,
			String fileName, Timestamp fileDate, String enterPeople,
			String filePerson, Boolean fileSex, String idNum,
			Timestamp fileBirthDate, Integer age, String workUnit,
			String IPhone, String pic, String otherName, String otherPhone,
			String hospital, String permanentType, String nation,
			String eduLevel, String fileJob, String bloodTypr,
			String rhNegative, String fileMaritalStatus, String email,
			String currentProvince, String currentOffice,
			String currentResidentCommittee, String currentCommunity,
			String otherAddressType, String otherProvince, String otherCity,
			String otherCounty, String otherCommunity, String allergyName,
			String exposeName, String exposeNote, String fatherDisease,
			String motherDisease, String borSisDisease, String childDisease,
			String otherDisease, String disabilityName, String geneticHistory,
			String kitVenFac, String fuelType, String drinkWater,
			String toilet, String livestockBar, String crowdClass,
			String healthFileType, String currentCity, String currentCounty,
			Integer GId) {
		this.healthFileId = healthFileId;
		this.roleId = roleId;
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
		this.trainStratDate = trainStratDate;
		this.trainEndDate = trainEndDate;
		this.station = station;
		this.oldStaffHosId = oldStaffHosId;
		this.staffId = staffId;
		this.communityHospitalId = communityHospitalId;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.roleName = roleName;
		this.fileNum = fileNum;
		this.fileName = fileName;
		this.fileDate = fileDate;
		this.enterPeople = enterPeople;
		this.filePerson = filePerson;
		this.fileSex = fileSex;
		this.idNum = idNum;
		this.fileBirthDate = fileBirthDate;
		this.age = age;
		this.workUnit = workUnit;
		this.IPhone = IPhone;
		this.pic = pic;
		this.otherName = otherName;
		this.otherPhone = otherPhone;
		this.hospital = hospital;
		this.permanentType = permanentType;
		this.nation = nation;
		this.eduLevel = eduLevel;
		this.fileJob = fileJob;
		this.bloodTypr = bloodTypr;
		this.rhNegative = rhNegative;
		this.fileMaritalStatus = fileMaritalStatus;
		this.email = email;
		this.currentProvince = currentProvince;
		this.currentOffice = currentOffice;
		this.currentResidentCommittee = currentResidentCommittee;
		this.currentCommunity = currentCommunity;
		this.otherAddressType = otherAddressType;
		this.otherProvince = otherProvince;
		this.otherCity = otherCity;
		this.otherCounty = otherCounty;
		this.otherCommunity = otherCommunity;
		this.allergyName = allergyName;
		this.exposeName = exposeName;
		this.exposeNote = exposeNote;
		this.fatherDisease = fatherDisease;
		this.motherDisease = motherDisease;
		this.borSisDisease = borSisDisease;
		this.childDisease = childDisease;
		this.otherDisease = otherDisease;
		this.disabilityName = disabilityName;
		this.geneticHistory = geneticHistory;
		this.kitVenFac = kitVenFac;
		this.fuelType = fuelType;
		this.drinkWater = drinkWater;
		this.toilet = toilet;
		this.livestockBar = livestockBar;
		this.crowdClass = crowdClass;
		this.healthFileType = healthFileType;
		this.currentCity = currentCity;
		this.currentCounty = currentCounty;
		this.GId = GId;
	}

	// Property accessors
	@Id
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

	@Column(name = "STATION")
	public String getStation() {
		return this.station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	@Column(name = "OLD_STAFF_HOS_ID", nullable = false)
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

	@Column(name = "ROLE_NAME", nullable = false)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Column(name = "FILE_NUM")
	public String getFileNum() {
		return this.fileNum;
	}

	public void setFileNum(String fileNum) {
		this.fileNum = fileNum;
	}

	@Column(name = "FILE_NAME", nullable = false)
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "FILE_DATE", length = 19)
	public Timestamp getFileDate() {
		return this.fileDate;
	}

	public void setFileDate(Timestamp fileDate) {
		this.fileDate = fileDate;
	}

	@Column(name = "ENTER_PEOPLE")
	public String getEnterPeople() {
		return this.enterPeople;
	}

	public void setEnterPeople(String enterPeople) {
		this.enterPeople = enterPeople;
	}

	@Column(name = "FILE_PERSON")
	public String getFilePerson() {
		return this.filePerson;
	}

	public void setFilePerson(String filePerson) {
		this.filePerson = filePerson;
	}

	@Column(name = "FILE_SEX")
	public Boolean getFileSex() {
		return this.fileSex;
	}

	public void setFileSex(Boolean fileSex) {
		this.fileSex = fileSex;
	}

	@Column(name = "ID_NUM", nullable = false)
	public String getIdNum() {
		return this.idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	@Column(name = "FILE_BIRTH_DATE", length = 19)
	public Timestamp getFileBirthDate() {
		return this.fileBirthDate;
	}

	public void setFileBirthDate(Timestamp fileBirthDate) {
		this.fileBirthDate = fileBirthDate;
	}

	@Column(name = "AGE")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "WORK_UNIT")
	public String getWorkUnit() {
		return this.workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	@Column(name = "I_PHONE", nullable = false)
	public String getIPhone() {
		return this.IPhone;
	}

	public void setIPhone(String IPhone) {
		this.IPhone = IPhone;
	}

	@Column(name = "PIC")
	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Column(name = "OTHER_NAME")
	public String getOtherName() {
		return this.otherName;
	}

	public void setOtherName(String otherName) {
		this.otherName = otherName;
	}

	@Column(name = "OTHER_PHONE")
	public String getOtherPhone() {
		return this.otherPhone;
	}

	public void setOtherPhone(String otherPhone) {
		this.otherPhone = otherPhone;
	}

	@Column(name = "HOSPITAL")
	public String getHospital() {
		return this.hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	@Column(name = "PERMANENT_TYPE", length = 1)
	public String getPermanentType() {
		return this.permanentType;
	}

	public void setPermanentType(String permanentType) {
		this.permanentType = permanentType;
	}

	@Column(name = "NATION")
	public String getNation() {
		return this.nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	@Column(name = "EDU_LEVEL")
	public String getEduLevel() {
		return this.eduLevel;
	}

	public void setEduLevel(String eduLevel) {
		this.eduLevel = eduLevel;
	}

	@Column(name = "FILE_JOB")
	public String getFileJob() {
		return this.fileJob;
	}

	public void setFileJob(String fileJob) {
		this.fileJob = fileJob;
	}

	@Column(name = "BLOOD_TYPR", length = 1)
	public String getBloodTypr() {
		return this.bloodTypr;
	}

	public void setBloodTypr(String bloodTypr) {
		this.bloodTypr = bloodTypr;
	}

	@Column(name = "RH_NEGATIVE", length = 1)
	public String getRhNegative() {
		return this.rhNegative;
	}

	public void setRhNegative(String rhNegative) {
		this.rhNegative = rhNegative;
	}

	@Column(name = "FILE_MARITAL_STATUS")
	public String getFileMaritalStatus() {
		return this.fileMaritalStatus;
	}

	public void setFileMaritalStatus(String fileMaritalStatus) {
		this.fileMaritalStatus = fileMaritalStatus;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "CURRENT_PROVINCE")
	public String getCurrentProvince() {
		return this.currentProvince;
	}

	public void setCurrentProvince(String currentProvince) {
		this.currentProvince = currentProvince;
	}

	@Column(name = "CURRENT_OFFICE")
	public String getCurrentOffice() {
		return this.currentOffice;
	}

	public void setCurrentOffice(String currentOffice) {
		this.currentOffice = currentOffice;
	}

	@Column(name = "CURRENT_RESIDENT_COMMITTEE")
	public String getCurrentResidentCommittee() {
		return this.currentResidentCommittee;
	}

	public void setCurrentResidentCommittee(String currentResidentCommittee) {
		this.currentResidentCommittee = currentResidentCommittee;
	}

	@Column(name = "CURRENT_COMMUNITY")
	public String getCurrentCommunity() {
		return this.currentCommunity;
	}

	public void setCurrentCommunity(String currentCommunity) {
		this.currentCommunity = currentCommunity;
	}

	@Column(name = "OTHER_ADDRESS_TYPE")
	public String getOtherAddressType() {
		return this.otherAddressType;
	}

	public void setOtherAddressType(String otherAddressType) {
		this.otherAddressType = otherAddressType;
	}

	@Column(name = "OTHER_PROVINCE")
	public String getOtherProvince() {
		return this.otherProvince;
	}

	public void setOtherProvince(String otherProvince) {
		this.otherProvince = otherProvince;
	}

	@Column(name = "OTHER_CITY")
	public String getOtherCity() {
		return this.otherCity;
	}

	public void setOtherCity(String otherCity) {
		this.otherCity = otherCity;
	}

	@Column(name = "OTHER_COUNTY")
	public String getOtherCounty() {
		return this.otherCounty;
	}

	public void setOtherCounty(String otherCounty) {
		this.otherCounty = otherCounty;
	}

	@Column(name = "OTHER_COMMUNITY")
	public String getOtherCommunity() {
		return this.otherCommunity;
	}

	public void setOtherCommunity(String otherCommunity) {
		this.otherCommunity = otherCommunity;
	}

	@Column(name = "ALLERGY_NAME")
	public String getAllergyName() {
		return this.allergyName;
	}

	public void setAllergyName(String allergyName) {
		this.allergyName = allergyName;
	}

	@Column(name = "EXPOSE_NAME")
	public String getExposeName() {
		return this.exposeName;
	}

	public void setExposeName(String exposeName) {
		this.exposeName = exposeName;
	}

	@Column(name = "EXPOSE_NOTE", length = 65535)
	public String getExposeNote() {
		return this.exposeNote;
	}

	public void setExposeNote(String exposeNote) {
		this.exposeNote = exposeNote;
	}

	@Column(name = "FATHER_DISEASE")
	public String getFatherDisease() {
		return this.fatherDisease;
	}

	public void setFatherDisease(String fatherDisease) {
		this.fatherDisease = fatherDisease;
	}

	@Column(name = "MOTHER_DISEASE")
	public String getMotherDisease() {
		return this.motherDisease;
	}

	public void setMotherDisease(String motherDisease) {
		this.motherDisease = motherDisease;
	}

	@Column(name = "BOR_SIS_DISEASE")
	public String getBorSisDisease() {
		return this.borSisDisease;
	}

	public void setBorSisDisease(String borSisDisease) {
		this.borSisDisease = borSisDisease;
	}

	@Column(name = "CHILD_DISEASE")
	public String getChildDisease() {
		return this.childDisease;
	}

	public void setChildDisease(String childDisease) {
		this.childDisease = childDisease;
	}

	@Column(name = "OTHER_DISEASE", length = 1000)
	public String getOtherDisease() {
		return this.otherDisease;
	}

	public void setOtherDisease(String otherDisease) {
		this.otherDisease = otherDisease;
	}

	@Column(name = "DISABILITY_NAME")
	public String getDisabilityName() {
		return this.disabilityName;
	}

	public void setDisabilityName(String disabilityName) {
		this.disabilityName = disabilityName;
	}

	@Column(name = "GENETIC_HISTORY")
	public String getGeneticHistory() {
		return this.geneticHistory;
	}

	public void setGeneticHistory(String geneticHistory) {
		this.geneticHistory = geneticHistory;
	}

	@Column(name = "KIT_VEN_FAC")
	public String getKitVenFac() {
		return this.kitVenFac;
	}

	public void setKitVenFac(String kitVenFac) {
		this.kitVenFac = kitVenFac;
	}

	@Column(name = "FUEL_TYPE")
	public String getFuelType() {
		return this.fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	@Column(name = "DRINK_WATER")
	public String getDrinkWater() {
		return this.drinkWater;
	}

	public void setDrinkWater(String drinkWater) {
		this.drinkWater = drinkWater;
	}

	@Column(name = "TOILET")
	public String getToilet() {
		return this.toilet;
	}

	public void setToilet(String toilet) {
		this.toilet = toilet;
	}

	@Column(name = "LIVESTOCK_BAR")
	public String getLivestockBar() {
		return this.livestockBar;
	}

	public void setLivestockBar(String livestockBar) {
		this.livestockBar = livestockBar;
	}

	@Column(name = "CROWD_CLASS", length = 1)
	public String getCrowdClass() {
		return this.crowdClass;
	}

	public void setCrowdClass(String crowdClass) {
		this.crowdClass = crowdClass;
	}

	@Column(name = "HEALTH_FILE_TYPE", length = 1)
	public String getHealthFileType() {
		return this.healthFileType;
	}

	public void setHealthFileType(String healthFileType) {
		this.healthFileType = healthFileType;
	}

	@Column(name = "CURRENT_CITY")
	public String getCurrentCity() {
		return this.currentCity;
	}

	public void setCurrentCity(String currentCity) {
		this.currentCity = currentCity;
	}

	@Column(name = "CURRENT_COUNTY")
	public String getCurrentCounty() {
		return this.currentCounty;
	}

	public void setCurrentCounty(String currentCounty) {
		this.currentCounty = currentCounty;
	}

	@Column(name = "G_ID")
	public Integer getGId() {
		return this.GId;
	}

	public void setGId(Integer GId) {
		this.GId = GId;
	}

}