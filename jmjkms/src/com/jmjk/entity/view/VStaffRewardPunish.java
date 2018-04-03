package com.jmjk.entity.view;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VStaffRewardPunish entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "V_STAFF_REWARD_PUNISH", catalog = "jmjk")
public class VStaffRewardPunish implements java.io.Serializable {

	// Fields

	private Integer staffRewardPunishId;
	private Timestamp operateDate;
	private Timestamp rewardPunishDate;
	private String rewordPunishType;
	private String rewordPunishReason;
	private Double rewordPunishAmount;
	private String rewardPunishNote;
	private String rewardPunishOne;
	private String rewardPunishTwo;
	private String rewardPunishThree;
	private String rewardPunishFour;
	private String rewardPunishFive;
	private Integer staffId;
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
	private Integer roleId;
	private Integer oldStaffHosId;
	private Integer communityHospitalId;
	private String ROne;
	private String RTwo;
	private String RThree;
	private String RFour;
	private String RFive;
	private Integer healthFileId;
	private Integer operateState;
	private Integer GId;
	private String groupName;
	private String communityHospital;
	// Constructors

	/** default constructor */
	public VStaffRewardPunish() {
	}

	/** minimal constructor */
	public VStaffRewardPunish(Integer staffRewardPunishId,
			String rewordPunishType) {
		this.staffRewardPunishId = staffRewardPunishId;
		this.rewordPunishType = rewordPunishType;
	}

	/** full constructor */
	public VStaffRewardPunish(Integer staffRewardPunishId,
			Timestamp operateDate, Timestamp rewardPunishDate,
			String rewordPunishType, String rewordPunishReason,
			Double rewordPunishAmount, String rewardPunishNote,
			String rewardPunishOne, String rewardPunishTwo,
			String rewardPunishThree, String rewardPunishFour,
			String rewardPunishFive, Integer staffId, String staffNumber,
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
			String staffFour, String staffFive, Integer roleId,
			Integer oldStaffHosId, Integer communityHospitalId, String ROne,
			String RTwo, String RThree, String RFour, String RFive,
			Integer healthFileId, Integer operateState, Integer GId,
			String groupName) {
		this.staffRewardPunishId = staffRewardPunishId;
		this.operateDate = operateDate;
		this.rewardPunishDate = rewardPunishDate;
		this.rewordPunishType = rewordPunishType;
		this.rewordPunishReason = rewordPunishReason;
		this.rewordPunishAmount = rewordPunishAmount;
		this.rewardPunishNote = rewardPunishNote;
		this.rewardPunishOne = rewardPunishOne;
		this.rewardPunishTwo = rewardPunishTwo;
		this.rewardPunishThree = rewardPunishThree;
		this.rewardPunishFour = rewardPunishFour;
		this.rewardPunishFive = rewardPunishFive;
		this.staffId = staffId;
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
		this.roleId = roleId;
		this.oldStaffHosId = oldStaffHosId;
		this.communityHospitalId = communityHospitalId;
		this.ROne = ROne;
		this.RTwo = RTwo;
		this.RThree = RThree;
		this.RFour = RFour;
		this.RFive = RFive;
		this.healthFileId = healthFileId;
		this.operateState = operateState;
		this.GId = GId;
		this.groupName = groupName;
	}

	// Property accessors
	@Id
	@Column(name = "STAFF_REWARD_PUNISH_ID", nullable = false)
	public Integer getStaffRewardPunishId() {
		return this.staffRewardPunishId;
	}

	public void setStaffRewardPunishId(Integer staffRewardPunishId) {
		this.staffRewardPunishId = staffRewardPunishId;
	}

	@Column(name = "OPERATE_DATE", length = 19)
	public Timestamp getOperateDate() {
		return this.operateDate;
	}

	public void setOperateDate(Timestamp operateDate) {
		this.operateDate = operateDate;
	}

	@Column(name = "REWARD_PUNISH_DATE", length = 19)
	public Timestamp getRewardPunishDate() {
		return this.rewardPunishDate;
	}

	public void setRewardPunishDate(Timestamp rewardPunishDate) {
		this.rewardPunishDate = rewardPunishDate;
	}

	@Column(name = "REWORD_PUNISH_TYPE", nullable = false)
	public String getRewordPunishType() {
		return this.rewordPunishType;
	}

	public void setRewordPunishType(String rewordPunishType) {
		this.rewordPunishType = rewordPunishType;
	}

	@Column(name = "REWORD_PUNISH_REASON", length = 65535)
	public String getRewordPunishReason() {
		return this.rewordPunishReason;
	}

	public void setRewordPunishReason(String rewordPunishReason) {
		this.rewordPunishReason = rewordPunishReason;
	}

	@Column(name = "REWORD_PUNISH_AMOUNT", precision = 22, scale = 0)
	public Double getRewordPunishAmount() {
		return this.rewordPunishAmount;
	}

	public void setRewordPunishAmount(Double rewordPunishAmount) {
		this.rewordPunishAmount = rewordPunishAmount;
	}

	@Column(name = "REWARD_PUNISH_NOTE", length = 65535)
	public String getRewardPunishNote() {
		return this.rewardPunishNote;
	}

	public void setRewardPunishNote(String rewardPunishNote) {
		this.rewardPunishNote = rewardPunishNote;
	}

	@Column(name = "REWARD_PUNISH_ONE", length = 1000)
	public String getRewardPunishOne() {
		return this.rewardPunishOne;
	}

	public void setRewardPunishOne(String rewardPunishOne) {
		this.rewardPunishOne = rewardPunishOne;
	}

	@Column(name = "REWARD_PUNISH_TWO", length = 1000)
	public String getRewardPunishTwo() {
		return this.rewardPunishTwo;
	}

	public void setRewardPunishTwo(String rewardPunishTwo) {
		this.rewardPunishTwo = rewardPunishTwo;
	}

	@Column(name = "REWARD_PUNISH_THREE", length = 1000)
	public String getRewardPunishThree() {
		return this.rewardPunishThree;
	}

	public void setRewardPunishThree(String rewardPunishThree) {
		this.rewardPunishThree = rewardPunishThree;
	}

	@Column(name = "REWARD_PUNISH_FOUR", length = 1000)
	public String getRewardPunishFour() {
		return this.rewardPunishFour;
	}

	public void setRewardPunishFour(String rewardPunishFour) {
		this.rewardPunishFour = rewardPunishFour;
	}

	@Column(name = "REWARD_PUNISH_FIVE", length = 1000)
	public String getRewardPunishFive() {
		return this.rewardPunishFive;
	}

	public void setRewardPunishFive(String rewardPunishFive) {
		this.rewardPunishFive = rewardPunishFive;
	}

	@Column(name = "STAFF_ID")
	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	@Column(name = "STAFF_NUMBER")
	public String getStaffNumber() {
		return this.staffNumber;
	}

	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}

	@Column(name = "STATE", length = 1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "NAME")
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

	@Column(name = "ID_CARD_NUM")
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

	@Column(name = "DEPARTMENT")
	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name = "JOB")
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

	@Column(name = "PHONE")
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

	@Column(name = "ROLE_ID")
	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	@Column(name = "OLD_STAFF_HOS_ID")
	public Integer getOldStaffHosId() {
		return this.oldStaffHosId;
	}

	public void setOldStaffHosId(Integer oldStaffHosId) {
		this.oldStaffHosId = oldStaffHosId;
	}

	@Column(name = "COMMUNITY_HOSPITAL_ID")
	public Integer getCommunityHospitalId() {
		return this.communityHospitalId;
	}

	public void setCommunityHospitalId(Integer communityHospitalId) {
		this.communityHospitalId = communityHospitalId;
	}

	@Column(name = "R_ONE", length = 1000)
	public String getROne() {
		return this.ROne;
	}

	public void setROne(String ROne) {
		this.ROne = ROne;
	}

	@Column(name = "R_TWO", length = 1000)
	public String getRTwo() {
		return this.RTwo;
	}

	public void setRTwo(String RTwo) {
		this.RTwo = RTwo;
	}

	@Column(name = "R_THREE", length = 1000)
	public String getRThree() {
		return this.RThree;
	}

	public void setRThree(String RThree) {
		this.RThree = RThree;
	}

	@Column(name = "R_FOUR", length = 1000)
	public String getRFour() {
		return this.RFour;
	}

	public void setRFour(String RFour) {
		this.RFour = RFour;
	}

	@Column(name = "R_FIVE", length = 1000)
	public String getRFive() {
		return this.RFive;
	}

	public void setRFive(String RFive) {
		this.RFive = RFive;
	}

	@Column(name = "HEALTH_FILE_ID")
	public Integer getHealthFileId() {
		return this.healthFileId;
	}

	public void setHealthFileId(Integer healthFileId) {
		this.healthFileId = healthFileId;
	}

	@Column(name = "OPERATE_STATE")
	public Integer getOperateState() {
		return this.operateState;
	}

	public void setOperateState(Integer operateState) {
		this.operateState = operateState;
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