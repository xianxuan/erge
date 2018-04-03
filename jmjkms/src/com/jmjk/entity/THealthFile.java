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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * THealthFile entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_health_file", catalog = "jmjk")
public class THealthFile implements java.io.Serializable {

	// Fields

	private Integer healthFileId;
	private Integer id;
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
	private String belongSystem;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private String currentCity;
	private String currentCounty;
	private String country;
	private String work;
	private String disabilitity;
	private Double height;
	private Double weihth;
	private Double waistline;
	private Double hipline;
	private Double diastolicBloodPressure;
	private Double systolicBloodPressure;
	private String nfc;
	private Set<TOldStaffHos> TOldStaffHoses = new HashSet<TOldStaffHos>(0);
	private Set<TDoctorDiagnosis> TDoctorDiagnosises = new HashSet<TDoctorDiagnosis>(
			0);
	private Set<TRecoveryOld> TRecoveryOlds = new HashSet<TRecoveryOld>(0);
	private Set<TPhysicalExam> TPhysicalExams = new HashSet<TPhysicalExam>(0);
	private Set<TFileLifeStyle> TFileLifeStyles = new HashSet<TFileLifeStyle>(0);
	private Set<TFollowRecord> TFollowRecords = new HashSet<TFollowRecord>(0);
	private Set<TFileMedicalRecord> TFileMedicalRecords = new HashSet<TFileMedicalRecord>(
			0);
	private Set<TConsultationRecord> TConsultationRecords = new HashSet<TConsultationRecord>(
			0);
	private Set<TIncompleteRecord> TIncompleteRecords = new HashSet<TIncompleteRecord>(
			0);
	private Set<TIncompleteRecord2> TIncompleteRecords2 = new HashSet<TIncompleteRecord2>(
			0);
	private Set<TMedicalRecord> TMedicalRecords = new HashSet<TMedicalRecord>(0);
	private Set<TDualReferralRecord> TDualReferralRecords = new HashSet<TDualReferralRecord>(
			0);
	private Set<TPastHistory> TPastHistories = new HashSet<TPastHistory>(0);
	private Set<TChronicDisease> TChronicDiseases = new HashSet<TChronicDisease>(
			0);
	private Set<TFamilyBedHistory> TFamilyBedHistories = new HashSet<TFamilyBedHistory>(
			0);
	private Set<TMedicalPayMethod> TMedicalPayMethods = new HashSet<TMedicalPayMethod>(
			0);
	private Set<TInHospitalHistory> TInHospitalHistories = new HashSet<TInHospitalHistory>(
			0);

	// Constructors

	/** default constructor */
	public THealthFile() {
	}
	
	/** default constructor */
	public THealthFile(int x) {
		this.healthFileId = x;
	}

	/** minimal constructor */
	public THealthFile(String name, String idNum, String IPhone) {
		this.name = name;
		this.idNum = idNum;
		this.IPhone = IPhone;
	}

	/** full constructor */
	public THealthFile(Integer id, String fileNum, String name,
			Timestamp fileDate, String enterPeople, String filePerson,
			Boolean sex, String idNum, Timestamp birthDate, Integer age,
			String workUnit, String IPhone, String pic, String otherName,
			String otherPhone, String hospital, String permanentType,
			String nation, String eduLevel, String job, String bloodTypr,
			String rhNegative, String maritalStatus, String email,
			String currentProvince, String currentOffice,
			String currentResidentCommittee, String currentCommunity,
			String otherAddressType, String otherProvince, String otherCity,
			String otherCounty, String otherCommunity, String allergyName,
			String exposeName, String exposeNote, String fatherDisease,
			String motherDisease, String borSisDisease, String childDisease,
			String otherDisease, String disabilityName, String geneticHistory,
			String kitVenFac, String fuelType, String drinkWater,
			String toilet, String livestockBar, String crowdClass,
			String healthFileType, String belongSystem, String one, String two,
			String three, String four, String five, String currentCity,
			String currentCounty, String country, String work,
			String disabilitity, Double height, Double weihth,
			Double waistline, Double hipline, Double diastolicBloodPressure,
			Double systolicBloodPressure, String nfc,
			Set<TOldStaffHos> TOldStaffHoses,
			Set<TDoctorDiagnosis> TDoctorDiagnosises,
			Set<TRecoveryOld> TRecoveryOlds, Set<TPhysicalExam> TPhysicalExams,
			Set<TFileLifeStyle> TFileLifeStyles,
			Set<TFollowRecord> TFollowRecords,
			Set<TFileMedicalRecord> TFileMedicalRecords,
			Set<TConsultationRecord> TConsultationRecords,
//			Set<TIncompleteRecord> TIncompleteRecords,
			Set<TIncompleteRecord2> TIncompleteRecords2,
			Set<TMedicalRecord> TMedicalRecords,
			Set<TDualReferralRecord> TDualReferralRecords,
			Set<TPastHistory> TPastHistories,
			Set<TChronicDisease> TChronicDiseases,
			Set<TFamilyBedHistory> TFamilyBedHistories,
			Set<TMedicalPayMethod> TMedicalPayMethods,
			Set<TInHospitalHistory> TInHospitalHistories) {
		this.id = id;
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
		this.belongSystem = belongSystem;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.currentCity = currentCity;
		this.currentCounty = currentCounty;
		this.country = country;
		this.work = work;
		this.disabilitity = disabilitity;
		this.height = height;
		this.weihth = weihth;
		this.waistline = waistline;
		this.hipline = hipline;
		this.diastolicBloodPressure = diastolicBloodPressure;
		this.systolicBloodPressure = systolicBloodPressure;
		this.nfc = nfc;
		this.TOldStaffHoses = TOldStaffHoses;
		this.TDoctorDiagnosises = TDoctorDiagnosises;
		this.TRecoveryOlds = TRecoveryOlds;
		this.TPhysicalExams = TPhysicalExams;
		this.TFileLifeStyles = TFileLifeStyles;
		this.TFollowRecords = TFollowRecords;
		this.TFileMedicalRecords = TFileMedicalRecords;
		this.TConsultationRecords = TConsultationRecords;
//		this.TIncompleteRecords = TIncompleteRecords;
		this.TIncompleteRecords2 = TIncompleteRecords2;
		this.TMedicalRecords = TMedicalRecords;
		this.TDualReferralRecords = TDualReferralRecords;
		this.TPastHistories = TPastHistories;
		this.TChronicDiseases = TChronicDiseases;
		this.TFamilyBedHistories = TFamilyBedHistories;
		this.TMedicalPayMethods = TMedicalPayMethods;
		this.TInHospitalHistories = TInHospitalHistories;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "HEALTH_FILE_ID", unique = true, nullable = false)
	public Integer getHealthFileId() {
		return this.healthFileId;
	}

	public void setHealthFileId(Integer healthFileId) {
		this.healthFileId = healthFileId;
	}

	@Column(name = "id")
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	@Column(name = "BELONG_SYSTEM")
	public String getBelongSystem() {
		return this.belongSystem;
	}

	public void setBelongSystem(String belongSystem) {
		this.belongSystem = belongSystem;
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

	@Column(name = "COUNTRY")
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "WORK")
	public String getWork() {
		return this.work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	@Column(name = "DISABILITITY")
	public String getDisabilitity() {
		return this.disabilitity;
	}

	public void setDisabilitity(String disabilitity) {
		this.disabilitity = disabilitity;
	}

	@Column(name = "HEIGHT", precision = 10, scale = 3)
	public Double getHeight() {
		return this.height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	@Column(name = "WEIHTH", precision = 10, scale = 3)
	public Double getWeihth() {
		return this.weihth;
	}

	public void setWeihth(Double weihth) {
		this.weihth = weihth;
	}

	@Column(name = "WAISTLINE", precision = 10, scale = 3)
	public Double getWaistline() {
		return this.waistline;
	}

	public void setWaistline(Double waistline) {
		this.waistline = waistline;
	}

	@Column(name = "HIPLINE", precision = 10, scale = 3)
	public Double getHipline() {
		return this.hipline;
	}

	public void setHipline(Double hipline) {
		this.hipline = hipline;
	}

	@Column(name = "DIASTOLIC_BLOOD_PRESSURE", precision = 10, scale = 3)
	public Double getDiastolicBloodPressure() {
		return this.diastolicBloodPressure;
	}

	public void setDiastolicBloodPressure(Double diastolicBloodPressure) {
		this.diastolicBloodPressure = diastolicBloodPressure;
	}

	@Column(name = "SYSTOLIC_BLOOD_PRESSURE", precision = 10, scale = 3)
	public Double getSystolicBloodPressure() {
		return this.systolicBloodPressure;
	}

	public void setSystolicBloodPressure(Double systolicBloodPressure) {
		this.systolicBloodPressure = systolicBloodPressure;
	}

	@Column(name = "NFC")
	public String getNfc() {
		return this.nfc;
	}

	public void setNfc(String nfc) {
		this.nfc = nfc;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "THealthFile")
	public Set<TOldStaffHos> getTOldStaffHoses() {
		return this.TOldStaffHoses;
	}

	public void setTOldStaffHoses(Set<TOldStaffHos> TOldStaffHoses) {
		this.TOldStaffHoses = TOldStaffHoses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "THealthFile")
	public Set<TDoctorDiagnosis> getTDoctorDiagnosises() {
		return this.TDoctorDiagnosises;
	}

	public void setTDoctorDiagnosises(Set<TDoctorDiagnosis> TDoctorDiagnosises) {
		this.TDoctorDiagnosises = TDoctorDiagnosises;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "THealthFile")
	public Set<TRecoveryOld> getTRecoveryOlds() {
		return this.TRecoveryOlds;
	}

	public void setTRecoveryOlds(Set<TRecoveryOld> TRecoveryOlds) {
		this.TRecoveryOlds = TRecoveryOlds;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "THealthFile")
	public Set<TPhysicalExam> getTPhysicalExams() {
		return this.TPhysicalExams;
	}

	public void setTPhysicalExams(Set<TPhysicalExam> TPhysicalExams) {
		this.TPhysicalExams = TPhysicalExams;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "THealthFile")
	public Set<TFileLifeStyle> getTFileLifeStyles() {
		return this.TFileLifeStyles;
	}

	public void setTFileLifeStyles(Set<TFileLifeStyle> TFileLifeStyles) {
		this.TFileLifeStyles = TFileLifeStyles;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "THealthFile")
	public Set<TFollowRecord> getTFollowRecords() {
		return this.TFollowRecords;
	}

	public void setTFollowRecords(Set<TFollowRecord> TFollowRecords) {
		this.TFollowRecords = TFollowRecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "THealthFile")
	public Set<TFileMedicalRecord> getTFileMedicalRecords() {
		return this.TFileMedicalRecords;
	}

	public void setTFileMedicalRecords(
			Set<TFileMedicalRecord> TFileMedicalRecords) {
		this.TFileMedicalRecords = TFileMedicalRecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "THealthFile")
	public Set<TConsultationRecord> getTConsultationRecords() {
		return this.TConsultationRecords;
	}

	public void setTConsultationRecords(
			Set<TConsultationRecord> TConsultationRecords) {
		this.TConsultationRecords = TConsultationRecords;
	}

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "THealthFile")
//	public Set<TIncompleteRecord> getTIncompleteRecords() {
//		return this.TIncompleteRecords;
//	}
//
//	public void setTIncompleteRecords(Set<TIncompleteRecord> TIncompleteRecords) {
//		this.TIncompleteRecords = TIncompleteRecords;
//	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "THealthFile")
	public Set<TIncompleteRecord2> getTIncompleteRecords2() {
		return this.TIncompleteRecords2;
	}

	public void setTIncompleteRecords2(Set<TIncompleteRecord2> TIncompleteRecords2) {
		this.TIncompleteRecords2 = TIncompleteRecords2;
	}
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "THealthFile")
	public Set<TMedicalRecord> getTMedicalRecords() {
		return this.TMedicalRecords;
	}

	public void setTMedicalRecords(Set<TMedicalRecord> TMedicalRecords) {
		this.TMedicalRecords = TMedicalRecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "THealthFile")
	public Set<TDualReferralRecord> getTDualReferralRecords() {
		return this.TDualReferralRecords;
	}

	public void setTDualReferralRecords(
			Set<TDualReferralRecord> TDualReferralRecords) {
		this.TDualReferralRecords = TDualReferralRecords;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "THealthFile")
	public Set<TPastHistory> getTPastHistories() {
		return this.TPastHistories;
	}

	public void setTPastHistories(Set<TPastHistory> TPastHistories) {
		this.TPastHistories = TPastHistories;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "THealthFile")
	public Set<TChronicDisease> getTChronicDiseases() {
		return this.TChronicDiseases;
	}

	public void setTChronicDiseases(Set<TChronicDisease> TChronicDiseases) {
		this.TChronicDiseases = TChronicDiseases;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "THealthFile")
	public Set<TFamilyBedHistory> getTFamilyBedHistories() {
		return this.TFamilyBedHistories;
	}

	public void setTFamilyBedHistories(
			Set<TFamilyBedHistory> TFamilyBedHistories) {
		this.TFamilyBedHistories = TFamilyBedHistories;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "THealthFile")
	public Set<TMedicalPayMethod> getTMedicalPayMethods() {
		return this.TMedicalPayMethods;
	}

	public void setTMedicalPayMethods(Set<TMedicalPayMethod> TMedicalPayMethods) {
		this.TMedicalPayMethods = TMedicalPayMethods;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "THealthFile")
	public Set<TInHospitalHistory> getTInHospitalHistories() {
		return this.TInHospitalHistories;
	}

	public void setTInHospitalHistories(
			Set<TInHospitalHistory> TInHospitalHistories) {
		this.TInHospitalHistories = TInHospitalHistories;
	}

}