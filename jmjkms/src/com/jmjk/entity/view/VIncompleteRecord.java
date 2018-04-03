package com.jmjk.entity.view;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VIncompleteRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "V_INCOMPLETE_RECORD", catalog = "jmjk")
public class VIncompleteRecord implements java.io.Serializable {

	// Fields

	private Integer incompleteRecordId;
	private String fileNum;
	private String name;
	private Timestamp fileDate;
	private String enterPeople;
	private String filePerson;
	private Boolean sex;
	private String idNum;
	private Timestamp birthDate;
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
	private String job;
	private String bloodTypr;
	private String rhNegative;
	private String maritalStatus;
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
	private String fileOne;
	private String fileTwo;
	private String fileThree;
	private String fileFour;
	private String fileFive;
	private String currentCity;
	private String currentCounty;
	private Integer healthFileId;
	private Timestamp incompleteRecordDate;
	private String incompleteDoctor;
	private String subInfor;
	private String objInfor;
	private String assess;
	private String disposalPlan;
	private String incompleteRecordOne;
	private String incompleteRecordTwo;
	private String incompleteRecordThree;
	private String incompleteRecordFour;
	private String incompleteRecordFive;
	private Integer oldStaffHosId;
	private Integer communityHospitalId;
	private Integer staffId;
	private String staffName;
	private Integer GId;

	// Constructors

	/** default constructor */
	public VIncompleteRecord() {
	}

	/** minimal constructor */
	public VIncompleteRecord(Integer incompleteRecordId, String name,
			String idNum, String IPhone, Integer healthFileId,
			Integer oldStaffHosId, String staffName) {
		this.incompleteRecordId = incompleteRecordId;
		this.name = name;
		this.idNum = idNum;
		this.IPhone = IPhone;
		this.healthFileId = healthFileId;
		this.oldStaffHosId = oldStaffHosId;
		this.staffName = staffName;
	}

	/** full constructor */
	public VIncompleteRecord(Integer incompleteRecordId, String fileNum,
			String name, Timestamp fileDate, String enterPeople,
			String filePerson, Boolean sex, String idNum, Timestamp birthDate,
			Integer age, String workUnit, String IPhone, String pic,
			String otherName, String otherPhone, String hospital,
			String permanentType, String nation, String eduLevel, String job,
			String bloodTypr, String rhNegative, String maritalStatus,
			String email, String currentProvince, String currentOffice,
			String currentResidentCommittee, String currentCommunity,
			String otherAddressType, String otherProvince, String otherCity,
			String otherCounty, String otherCommunity, String allergyName,
			String exposeName, String exposeNote, String fatherDisease,
			String motherDisease, String borSisDisease, String childDisease,
			String otherDisease, String disabilityName, String geneticHistory,
			String kitVenFac, String fuelType, String drinkWater,
			String toilet, String livestockBar, String crowdClass,
			String healthFileType, String fileOne, String fileTwo,
			String fileThree, String fileFour, String fileFive,
			String currentCity, String currentCounty, Integer healthFileId,
			Timestamp incompleteRecordDate, String incompleteDoctor,
			String subInfor, String objInfor, String assess,
			String disposalPlan, String incompleteRecordOne,
			String incompleteRecordTwo, String incompleteRecordThree,
			String incompleteRecordFour, String incompleteRecordFive,
			Integer oldStaffHosId, Integer communityHospitalId,
			Integer staffId, String staffName, Integer GId) {
		this.incompleteRecordId = incompleteRecordId;
		this.fileNum = fileNum;
		this.name = name;
		this.fileDate = fileDate;
		this.enterPeople = enterPeople;
		this.filePerson = filePerson;
		this.sex = sex;
		this.idNum = idNum;
		this.birthDate = birthDate;
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
		this.job = job;
		this.bloodTypr = bloodTypr;
		this.rhNegative = rhNegative;
		this.maritalStatus = maritalStatus;
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
		this.fileOne = fileOne;
		this.fileTwo = fileTwo;
		this.fileThree = fileThree;
		this.fileFour = fileFour;
		this.fileFive = fileFive;
		this.currentCity = currentCity;
		this.currentCounty = currentCounty;
		this.healthFileId = healthFileId;
		this.incompleteRecordDate = incompleteRecordDate;
		this.incompleteDoctor = incompleteDoctor;
		this.subInfor = subInfor;
		this.objInfor = objInfor;
		this.assess = assess;
		this.disposalPlan = disposalPlan;
		this.incompleteRecordOne = incompleteRecordOne;
		this.incompleteRecordTwo = incompleteRecordTwo;
		this.incompleteRecordThree = incompleteRecordThree;
		this.incompleteRecordFour = incompleteRecordFour;
		this.incompleteRecordFive = incompleteRecordFive;
		this.oldStaffHosId = oldStaffHosId;
		this.communityHospitalId = communityHospitalId;
		this.staffId = staffId;
		this.staffName = staffName;
		this.GId = GId;
	}

	// Property accessors
	@Id
	@Column(name = "INCOMPLETE_RECORD_ID", nullable = false)
	public Integer getIncompleteRecordId() {
		return this.incompleteRecordId;
	}

	public void setIncompleteRecordId(Integer incompleteRecordId) {
		this.incompleteRecordId = incompleteRecordId;
	}

	@Column(name = "FILE_NUM")
	public String getFileNum() {
		return this.fileNum;
	}

	public void setFileNum(String fileNum) {
		this.fileNum = fileNum;
	}

	@Column(name = "NAME", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	@Column(name = "SEX")
	public Boolean getSex() {
		return this.sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	@Column(name = "ID_NUM", nullable = false)
	public String getIdNum() {
		return this.idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	@Column(name = "BIRTH_DATE", length = 19)
	public Timestamp getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
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

	@Column(name = "JOB")
	public String getJob() {
		return this.job;
	}

	public void setJob(String job) {
		this.job = job;
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

	@Column(name = "MARITAL_STATUS")
	public String getMaritalStatus() {
		return this.maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
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

	@Column(name = "FILE_ONE", length = 1000)
	public String getFileOne() {
		return this.fileOne;
	}

	public void setFileOne(String fileOne) {
		this.fileOne = fileOne;
	}

	@Column(name = "FILE_TWO", length = 1000)
	public String getFileTwo() {
		return this.fileTwo;
	}

	public void setFileTwo(String fileTwo) {
		this.fileTwo = fileTwo;
	}

	@Column(name = "FILE_THREE", length = 1000)
	public String getFileThree() {
		return this.fileThree;
	}

	public void setFileThree(String fileThree) {
		this.fileThree = fileThree;
	}

	@Column(name = "FILE_FOUR", length = 1000)
	public String getFileFour() {
		return this.fileFour;
	}

	public void setFileFour(String fileFour) {
		this.fileFour = fileFour;
	}

	@Column(name = "FILE_FIVE", length = 1000)
	public String getFileFive() {
		return this.fileFive;
	}

	public void setFileFive(String fileFive) {
		this.fileFive = fileFive;
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

	@Column(name = "HEALTH_FILE_ID", nullable = false)
	public Integer getHealthFileId() {
		return this.healthFileId;
	}

	public void setHealthFileId(Integer healthFileId) {
		this.healthFileId = healthFileId;
	}

	@Column(name = "INCOMPLETE_RECORD_DATE", length = 19)
	public Timestamp getIncompleteRecordDate() {
		return this.incompleteRecordDate;
	}

	public void setIncompleteRecordDate(Timestamp incompleteRecordDate) {
		this.incompleteRecordDate = incompleteRecordDate;
	}

	@Column(name = "INCOMPLETE_DOCTOR")
	public String getIncompleteDoctor() {
		return this.incompleteDoctor;
	}

	public void setIncompleteDoctor(String incompleteDoctor) {
		this.incompleteDoctor = incompleteDoctor;
	}

	@Column(name = "SUB_INFOR", length = 65535)
	public String getSubInfor() {
		return this.subInfor;
	}

	public void setSubInfor(String subInfor) {
		this.subInfor = subInfor;
	}

	@Column(name = "OBJ_INFOR", length = 65535)
	public String getObjInfor() {
		return this.objInfor;
	}

	public void setObjInfor(String objInfor) {
		this.objInfor = objInfor;
	}

	@Column(name = "ASSESS", length = 65535)
	public String getAssess() {
		return this.assess;
	}

	public void setAssess(String assess) {
		this.assess = assess;
	}

	@Column(name = "DISPOSAL_PLAN", length = 65535)
	public String getDisposalPlan() {
		return this.disposalPlan;
	}

	public void setDisposalPlan(String disposalPlan) {
		this.disposalPlan = disposalPlan;
	}

	@Column(name = "INCOMPLETE_RECORD_ONE", length = 1000)
	public String getIncompleteRecordOne() {
		return this.incompleteRecordOne;
	}

	public void setIncompleteRecordOne(String incompleteRecordOne) {
		this.incompleteRecordOne = incompleteRecordOne;
	}

	@Column(name = "INCOMPLETE_RECORD_TWO", length = 1000)
	public String getIncompleteRecordTwo() {
		return this.incompleteRecordTwo;
	}

	public void setIncompleteRecordTwo(String incompleteRecordTwo) {
		this.incompleteRecordTwo = incompleteRecordTwo;
	}

	@Column(name = "INCOMPLETE_RECORD_THREE", length = 1000)
	public String getIncompleteRecordThree() {
		return this.incompleteRecordThree;
	}

	public void setIncompleteRecordThree(String incompleteRecordThree) {
		this.incompleteRecordThree = incompleteRecordThree;
	}

	@Column(name = "INCOMPLETE_RECORD_FOUR", length = 1000)
	public String getIncompleteRecordFour() {
		return this.incompleteRecordFour;
	}

	public void setIncompleteRecordFour(String incompleteRecordFour) {
		this.incompleteRecordFour = incompleteRecordFour;
	}

	@Column(name = "INCOMPLETE_RECORD_FIVE", length = 1000)
	public String getIncompleteRecordFive() {
		return this.incompleteRecordFive;
	}

	public void setIncompleteRecordFive(String incompleteRecordFive) {
		this.incompleteRecordFive = incompleteRecordFive;
	}

	@Column(name = "OLD_STAFF_HOS_ID", nullable = false)
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

	@Column(name = "STAFF_ID")
	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	@Column(name = "STAFF_NAME", nullable = false)
	public String getStaffName() {
		return this.staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	@Column(name = "G_ID")
	public Integer getGId() {
		return this.GId;
	}

	public void setGId(Integer GId) {
		this.GId = GId;
	}

}