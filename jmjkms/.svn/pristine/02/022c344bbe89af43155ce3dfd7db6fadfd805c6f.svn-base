package com.jmjk.entity;
// default package

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TTumour entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_TUMOUR", catalog = "jmjk")
public class TTumour implements java.io.Serializable {

	// Fields

	private Integer tumourId;
	private TChronicDisease TChronicDisease;
	private String diagnosticInformation;
	private Timestamp emergenceDate;
	private Timestamp treatmentDate;
	private Timestamp diagnosisDate;
	private String diagnosedHospital;
	private String pathologicalType;
	private String confirmationBasis;
	private String diagnosisPeriod;
	private String outpatientNumber;
	private String inpatientNumber;
	private Timestamp signatureDate;
	private Timestamp reviewDate;
	private String investigatedPerson;
	private String reviewperson;
	private String treatment;
	private String tranferSituation;
	private String chemotherapyHospital;
	private String radiotherapyHospital;
	private String surgicalHospital;
	private String onceTreatment;
	private String currentTreatmentSituation;
	private Timestamp operateTime;
	private String operateHospital;
	private String admissionNum;
	private String operateProperty;
	private Timestamp firstTime;
	private Timestamp secondTime;
	private Timestamp thirdTime;
	private String cancerFamilyHistory;
	private Timestamp changeDate;
	private String changeDepartment;
	private String deathAddress;
	private String deathReason;
	private Timestamp deathDate;
	private String year;
	private String mounth;
	private String withdrawalDate;
	private String withdrawalReason;
	private String findWay;
	private String registrationWay;
	private String diagnosisBasis;
	private String cytology;
	private String hyphology;
	private String histologicalType;
	private String byStage;
	private Timestamp fileDate;
	private String fileName;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TTumour() {
	}

	/** minimal constructor */
	public TTumour(TChronicDisease TChronicDisease, String pathologicalType,
			String confirmationBasis, String diagnosisPeriod,
			Timestamp signatureDate, Timestamp reviewDate,
			String investigatedPerson, String reviewperson) {
		this.TChronicDisease = TChronicDisease;
		this.pathologicalType = pathologicalType;
		this.confirmationBasis = confirmationBasis;
		this.diagnosisPeriod = diagnosisPeriod;
		this.signatureDate = signatureDate;
		this.reviewDate = reviewDate;
		this.investigatedPerson = investigatedPerson;
		this.reviewperson = reviewperson;
	}

	/** full constructor */
	public TTumour(TChronicDisease TChronicDisease,
			String diagnosticInformation, Timestamp emergenceDate,
			Timestamp treatmentDate, Timestamp diagnosisDate,
			String diagnosedHospital, String pathologicalType,
			String confirmationBasis, String diagnosisPeriod,
			String outpatientNumber, String inpatientNumber,
			Timestamp signatureDate, Timestamp reviewDate,
			String investigatedPerson, String reviewperson, String treatment,
			String tranferSituation, String chemotherapyHospital,
			String radiotherapyHospital, String surgicalHospital,
			String onceTreatment, String currentTreatmentSituation,
			Timestamp operateTime, String operateHospital, String admissionNum,
			String operateProperty, Timestamp firstTime, Timestamp secondTime,
			Timestamp thirdTime, String cancerFamilyHistory,
			Timestamp changeDate, String changeDepartment, String deathAddress,
			String deathReason, Timestamp deathDate, String year,
			String mounth, String withdrawalDate, String withdrawalReason,
			String findWay, String registrationWay, String diagnosisBasis,
			String cytology, String hyphology, String histologicalType,
			String byStage, Timestamp fileDate, String fileName, String one,
			String two, String three, String four, String five) {
		this.TChronicDisease = TChronicDisease;
		this.diagnosticInformation = diagnosticInformation;
		this.emergenceDate = emergenceDate;
		this.treatmentDate = treatmentDate;
		this.diagnosisDate = diagnosisDate;
		this.diagnosedHospital = diagnosedHospital;
		this.pathologicalType = pathologicalType;
		this.confirmationBasis = confirmationBasis;
		this.diagnosisPeriod = diagnosisPeriod;
		this.outpatientNumber = outpatientNumber;
		this.inpatientNumber = inpatientNumber;
		this.signatureDate = signatureDate;
		this.reviewDate = reviewDate;
		this.investigatedPerson = investigatedPerson;
		this.reviewperson = reviewperson;
		this.treatment = treatment;
		this.tranferSituation = tranferSituation;
		this.chemotherapyHospital = chemotherapyHospital;
		this.radiotherapyHospital = radiotherapyHospital;
		this.surgicalHospital = surgicalHospital;
		this.onceTreatment = onceTreatment;
		this.currentTreatmentSituation = currentTreatmentSituation;
		this.operateTime = operateTime;
		this.operateHospital = operateHospital;
		this.admissionNum = admissionNum;
		this.operateProperty = operateProperty;
		this.firstTime = firstTime;
		this.secondTime = secondTime;
		this.thirdTime = thirdTime;
		this.cancerFamilyHistory = cancerFamilyHistory;
		this.changeDate = changeDate;
		this.changeDepartment = changeDepartment;
		this.deathAddress = deathAddress;
		this.deathReason = deathReason;
		this.deathDate = deathDate;
		this.year = year;
		this.mounth = mounth;
		this.withdrawalDate = withdrawalDate;
		this.withdrawalReason = withdrawalReason;
		this.findWay = findWay;
		this.registrationWay = registrationWay;
		this.diagnosisBasis = diagnosisBasis;
		this.cytology = cytology;
		this.hyphology = hyphology;
		this.histologicalType = histologicalType;
		this.byStage = byStage;
		this.fileDate = fileDate;
		this.fileName = fileName;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "TUMOUR_ID", unique = true, nullable = false)
	public Integer getTumourId() {
		return this.tumourId;
	}

	public void setTumourId(Integer tumourId) {
		this.tumourId = tumourId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHRONIC_DISEASE_ID", nullable = false)
	public TChronicDisease getTChronicDisease() {
		return this.TChronicDisease;
	}

	public void setTChronicDisease(TChronicDisease TChronicDisease) {
		this.TChronicDisease = TChronicDisease;
	}

	@Column(name = "DIAGNOSTIC_INFORMATION")
	public String getDiagnosticInformation() {
		return this.diagnosticInformation;
	}

	public void setDiagnosticInformation(String diagnosticInformation) {
		this.diagnosticInformation = diagnosticInformation;
	}

	@Column(name = "EMERGENCE_DATE", length = 19)
	public Timestamp getEmergenceDate() {
		return this.emergenceDate;
	}

	public void setEmergenceDate(Timestamp emergenceDate) {
		this.emergenceDate = emergenceDate;
	}

	@Column(name = "TREATMENT_DATE", length = 19)
	public Timestamp getTreatmentDate() {
		return this.treatmentDate;
	}

	public void setTreatmentDate(Timestamp treatmentDate) {
		this.treatmentDate = treatmentDate;
	}

	@Column(name = "DIAGNOSIS_DATE", length = 19)
	public Timestamp getDiagnosisDate() {
		return this.diagnosisDate;
	}

	public void setDiagnosisDate(Timestamp diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}

	@Column(name = "DIAGNOSED_HOSPITAL")
	public String getDiagnosedHospital() {
		return this.diagnosedHospital;
	}

	public void setDiagnosedHospital(String diagnosedHospital) {
		this.diagnosedHospital = diagnosedHospital;
	}

	@Column(name = "PATHOLOGICAL_TYPE", nullable = false)
	public String getPathologicalType() {
		return this.pathologicalType;
	}

	public void setPathologicalType(String pathologicalType) {
		this.pathologicalType = pathologicalType;
	}

	@Column(name = "CONFIRMATION_BASIS", nullable = false, length = 65535)
	public String getConfirmationBasis() {
		return this.confirmationBasis;
	}

	public void setConfirmationBasis(String confirmationBasis) {
		this.confirmationBasis = confirmationBasis;
	}

	@Column(name = "DIAGNOSIS_PERIOD", nullable = false, length = 65535)
	public String getDiagnosisPeriod() {
		return this.diagnosisPeriod;
	}

	public void setDiagnosisPeriod(String diagnosisPeriod) {
		this.diagnosisPeriod = diagnosisPeriod;
	}

	@Column(name = "OUTPATIENT_NUMBER")
	public String getOutpatientNumber() {
		return this.outpatientNumber;
	}

	public void setOutpatientNumber(String outpatientNumber) {
		this.outpatientNumber = outpatientNumber;
	}

	@Column(name = "INPATIENT_NUMBER")
	public String getInpatientNumber() {
		return this.inpatientNumber;
	}

	public void setInpatientNumber(String inpatientNumber) {
		this.inpatientNumber = inpatientNumber;
	}

	@Column(name = "SIGNATURE_DATE", nullable = false, length = 19)
	public Timestamp getSignatureDate() {
		return this.signatureDate;
	}

	public void setSignatureDate(Timestamp signatureDate) {
		this.signatureDate = signatureDate;
	}

	@Column(name = "REVIEW_DATE", nullable = false, length = 19)
	public Timestamp getReviewDate() {
		return this.reviewDate;
	}

	public void setReviewDate(Timestamp reviewDate) {
		this.reviewDate = reviewDate;
	}

	@Column(name = "INVESTIGATED_PERSON", nullable = false)
	public String getInvestigatedPerson() {
		return this.investigatedPerson;
	}

	public void setInvestigatedPerson(String investigatedPerson) {
		this.investigatedPerson = investigatedPerson;
	}

	@Column(name = "REVIEWPERSON", nullable = false)
	public String getReviewperson() {
		return this.reviewperson;
	}

	public void setReviewperson(String reviewperson) {
		this.reviewperson = reviewperson;
	}

	@Column(name = "TREATMENT")
	public String getTreatment() {
		return this.treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	@Column(name = "TRANFER_SITUATION")
	public String getTranferSituation() {
		return this.tranferSituation;
	}

	public void setTranferSituation(String tranferSituation) {
		this.tranferSituation = tranferSituation;
	}

	@Column(name = "CHEMOTHERAPY_HOSPITAL", length = 65535)
	public String getChemotherapyHospital() {
		return this.chemotherapyHospital;
	}

	public void setChemotherapyHospital(String chemotherapyHospital) {
		this.chemotherapyHospital = chemotherapyHospital;
	}

	@Column(name = "RADIOTHERAPY_HOSPITAL", length = 65535)
	public String getRadiotherapyHospital() {
		return this.radiotherapyHospital;
	}

	public void setRadiotherapyHospital(String radiotherapyHospital) {
		this.radiotherapyHospital = radiotherapyHospital;
	}

	@Column(name = "SURGICAL_HOSPITAL", length = 65535)
	public String getSurgicalHospital() {
		return this.surgicalHospital;
	}

	public void setSurgicalHospital(String surgicalHospital) {
		this.surgicalHospital = surgicalHospital;
	}

	@Column(name = "ONCE_TREATMENT", length = 65535)
	public String getOnceTreatment() {
		return this.onceTreatment;
	}

	public void setOnceTreatment(String onceTreatment) {
		this.onceTreatment = onceTreatment;
	}

	@Column(name = "CURRENT_TREATMENT_SITUATION", length = 65535)
	public String getCurrentTreatmentSituation() {
		return this.currentTreatmentSituation;
	}

	public void setCurrentTreatmentSituation(String currentTreatmentSituation) {
		this.currentTreatmentSituation = currentTreatmentSituation;
	}

	@Column(name = "OPERATE_TIME", length = 19)
	public Timestamp getOperateTime() {
		return this.operateTime;
	}

	public void setOperateTime(Timestamp operateTime) {
		this.operateTime = operateTime;
	}

	@Column(name = "OPERATE_HOSPITAL", length = 65535)
	public String getOperateHospital() {
		return this.operateHospital;
	}

	public void setOperateHospital(String operateHospital) {
		this.operateHospital = operateHospital;
	}

	@Column(name = "ADMISSION_NUM")
	public String getAdmissionNum() {
		return this.admissionNum;
	}

	public void setAdmissionNum(String admissionNum) {
		this.admissionNum = admissionNum;
	}

	@Column(name = "OPERATE_PROPERTY")
	public String getOperateProperty() {
		return this.operateProperty;
	}

	public void setOperateProperty(String operateProperty) {
		this.operateProperty = operateProperty;
	}

	@Column(name = "FIRST_TIME", length = 19)
	public Timestamp getFirstTime() {
		return this.firstTime;
	}

	public void setFirstTime(Timestamp firstTime) {
		this.firstTime = firstTime;
	}

	@Column(name = "SECOND_TIME", length = 19)
	public Timestamp getSecondTime() {
		return this.secondTime;
	}

	public void setSecondTime(Timestamp secondTime) {
		this.secondTime = secondTime;
	}

	@Column(name = "THIRD_TIME", length = 19)
	public Timestamp getThirdTime() {
		return this.thirdTime;
	}

	public void setThirdTime(Timestamp thirdTime) {
		this.thirdTime = thirdTime;
	}

	@Column(name = "CANCER_FAMILY_HISTORY", length = 65535)
	public String getCancerFamilyHistory() {
		return this.cancerFamilyHistory;
	}

	public void setCancerFamilyHistory(String cancerFamilyHistory) {
		this.cancerFamilyHistory = cancerFamilyHistory;
	}

	@Column(name = "CHANGE_DATE", length = 19)
	public Timestamp getChangeDate() {
		return this.changeDate;
	}

	public void setChangeDate(Timestamp changeDate) {
		this.changeDate = changeDate;
	}

	@Column(name = "CHANGE_DEPARTMENT")
	public String getChangeDepartment() {
		return this.changeDepartment;
	}

	public void setChangeDepartment(String changeDepartment) {
		this.changeDepartment = changeDepartment;
	}

	@Column(name = "DEATH_ADDRESS")
	public String getDeathAddress() {
		return this.deathAddress;
	}

	public void setDeathAddress(String deathAddress) {
		this.deathAddress = deathAddress;
	}

	@Column(name = "DEATH_REASON")
	public String getDeathReason() {
		return this.deathReason;
	}

	public void setDeathReason(String deathReason) {
		this.deathReason = deathReason;
	}

	@Column(name = "DEATH_DATE", length = 19)
	public Timestamp getDeathDate() {
		return this.deathDate;
	}

	public void setDeathDate(Timestamp deathDate) {
		this.deathDate = deathDate;
	}

	@Column(name = "YEAR")
	public String getYear() {
		return this.year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Column(name = "MOUNTH")
	public String getMounth() {
		return this.mounth;
	}

	public void setMounth(String mounth) {
		this.mounth = mounth;
	}

	@Column(name = "WITHDRAWAL_DATE")
	public String getWithdrawalDate() {
		return this.withdrawalDate;
	}

	public void setWithdrawalDate(String withdrawalDate) {
		this.withdrawalDate = withdrawalDate;
	}

	@Column(name = "WITHDRAWAL_REASON", length = 65535)
	public String getWithdrawalReason() {
		return this.withdrawalReason;
	}

	public void setWithdrawalReason(String withdrawalReason) {
		this.withdrawalReason = withdrawalReason;
	}

	@Column(name = "FIND_WAY")
	public String getFindWay() {
		return this.findWay;
	}

	public void setFindWay(String findWay) {
		this.findWay = findWay;
	}

	@Column(name = "REGISTRATION_WAY")
	public String getRegistrationWay() {
		return this.registrationWay;
	}

	public void setRegistrationWay(String registrationWay) {
		this.registrationWay = registrationWay;
	}

	@Column(name = "DIAGNOSIS_BASIS")
	public String getDiagnosisBasis() {
		return this.diagnosisBasis;
	}

	public void setDiagnosisBasis(String diagnosisBasis) {
		this.diagnosisBasis = diagnosisBasis;
	}

	@Column(name = "CYTOLOGY")
	public String getCytology() {
		return this.cytology;
	}

	public void setCytology(String cytology) {
		this.cytology = cytology;
	}

	@Column(name = "HYPHOLOGY")
	public String getHyphology() {
		return this.hyphology;
	}

	public void setHyphology(String hyphology) {
		this.hyphology = hyphology;
	}

	@Column(name = "HISTOLOGICAL_TYPE")
	public String getHistologicalType() {
		return this.histologicalType;
	}

	public void setHistologicalType(String histologicalType) {
		this.histologicalType = histologicalType;
	}

	@Column(name = "BY_STAGE")
	public String getByStage() {
		return this.byStage;
	}

	public void setByStage(String byStage) {
		this.byStage = byStage;
	}

	@Column(name = "FILE_DATE", length = 19)
	public Timestamp getFileDate() {
		return this.fileDate;
	}

	public void setFileDate(Timestamp fileDate) {
		this.fileDate = fileDate;
	}

	@Column(name = "FILE_NAME")
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
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

}