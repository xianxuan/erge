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
 * TChronicBronchialDisease entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_CHRONIC_BRONCHIAL_DISEASE", catalog = "jmjk")
public class TChronicBronchialDisease implements java.io.Serializable {

	// Fields

	private Integer chronicBronchialDiseaseId;
	private TChronicDisease TChronicDisease;
	private Timestamp diagnosisDate;
	private String diagnosedHospital;
	private Integer annualIncidence;
	private String eachTimeTreatment;
	private String mainCausesDisease;
	private String coughDegree;
	private String coughColor;
	private String isAccompaniedWheezing;
	private String routineBloodTest;
	private String XRay;
	private String sputumSmearCulture;
	private String lungFunctionTest;
	private String complication;
	private String selefBreath;
	private String heartClass;
	private String remarks;
	private String investigatedPerson;
	private Timestamp fileDate;
	private String fileName;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TChronicBronchialDisease() {
	}

	/** minimal constructor */
	public TChronicBronchialDisease(TChronicDisease TChronicDisease,
			String mainCausesDisease, String coughDegree, String coughColor,
			String isAccompaniedWheezing, String investigatedPerson) {
		this.TChronicDisease = TChronicDisease;
		this.mainCausesDisease = mainCausesDisease;
		this.coughDegree = coughDegree;
		this.coughColor = coughColor;
		this.isAccompaniedWheezing = isAccompaniedWheezing;
		this.investigatedPerson = investigatedPerson;
	}

	/** full constructor */
	public TChronicBronchialDisease(TChronicDisease TChronicDisease,
			Timestamp diagnosisDate, String diagnosedHospital,
			Integer annualIncidence, String eachTimeTreatment,
			String mainCausesDisease, String coughDegree, String coughColor,
			String isAccompaniedWheezing, String routineBloodTest, String XRay,
			String sputumSmearCulture, String lungFunctionTest,
			String complication, String selefBreath, String heartClass,
			String remarks, String investigatedPerson, Timestamp fileDate,
			String fileName, String one, String two, String three, String four,
			String five) {
		this.TChronicDisease = TChronicDisease;
		this.diagnosisDate = diagnosisDate;
		this.diagnosedHospital = diagnosedHospital;
		this.annualIncidence = annualIncidence;
		this.eachTimeTreatment = eachTimeTreatment;
		this.mainCausesDisease = mainCausesDisease;
		this.coughDegree = coughDegree;
		this.coughColor = coughColor;
		this.isAccompaniedWheezing = isAccompaniedWheezing;
		this.routineBloodTest = routineBloodTest;
		this.XRay = XRay;
		this.sputumSmearCulture = sputumSmearCulture;
		this.lungFunctionTest = lungFunctionTest;
		this.complication = complication;
		this.selefBreath = selefBreath;
		this.heartClass = heartClass;
		this.remarks = remarks;
		this.investigatedPerson = investigatedPerson;
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
	@Column(name = "CHRONIC_BRONCHIAL_DISEASE_ID", unique = true, nullable = false)
	public Integer getChronicBronchialDiseaseId() {
		return this.chronicBronchialDiseaseId;
	}

	public void setChronicBronchialDiseaseId(Integer chronicBronchialDiseaseId) {
		this.chronicBronchialDiseaseId = chronicBronchialDiseaseId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHRONIC_DISEASE_ID", nullable = false)
	public TChronicDisease getTChronicDisease() {
		return this.TChronicDisease;
	}

	public void setTChronicDisease(TChronicDisease TChronicDisease) {
		this.TChronicDisease = TChronicDisease;
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

	@Column(name = "ANNUAL_INCIDENCE")
	public Integer getAnnualIncidence() {
		return this.annualIncidence;
	}

	public void setAnnualIncidence(Integer annualIncidence) {
		this.annualIncidence = annualIncidence;
	}

	@Column(name = "EACH_TIME_TREATMENT")
	public String getEachTimeTreatment() {
		return this.eachTimeTreatment;
	}

	public void setEachTimeTreatment(String eachTimeTreatment) {
		this.eachTimeTreatment = eachTimeTreatment;
	}

	@Column(name = "MAIN_CAUSES_DISEASE", nullable = false, length = 65535)
	public String getMainCausesDisease() {
		return this.mainCausesDisease;
	}

	public void setMainCausesDisease(String mainCausesDisease) {
		this.mainCausesDisease = mainCausesDisease;
	}

	@Column(name = "COUGH_DEGREE", nullable = false)
	public String getCoughDegree() {
		return this.coughDegree;
	}

	public void setCoughDegree(String coughDegree) {
		this.coughDegree = coughDegree;
	}

	@Column(name = "COUGH_COLOR", nullable = false)
	public String getCoughColor() {
		return this.coughColor;
	}

	public void setCoughColor(String coughColor) {
		this.coughColor = coughColor;
	}

	@Column(name = "IS_ACCOMPANIED_WHEEZING", nullable = false)
	public String getIsAccompaniedWheezing() {
		return this.isAccompaniedWheezing;
	}

	public void setIsAccompaniedWheezing(String isAccompaniedWheezing) {
		this.isAccompaniedWheezing = isAccompaniedWheezing;
	}

	@Column(name = "ROUTINE_BLOOD_TEST")
	public String getRoutineBloodTest() {
		return this.routineBloodTest;
	}

	public void setRoutineBloodTest(String routineBloodTest) {
		this.routineBloodTest = routineBloodTest;
	}

	@Column(name = "X_RAY")
	public String getXRay() {
		return this.XRay;
	}

	public void setXRay(String XRay) {
		this.XRay = XRay;
	}

	@Column(name = "SPUTUM_SMEAR_CULTURE", length = 65535)
	public String getSputumSmearCulture() {
		return this.sputumSmearCulture;
	}

	public void setSputumSmearCulture(String sputumSmearCulture) {
		this.sputumSmearCulture = sputumSmearCulture;
	}

	@Column(name = "LUNG_FUNCTION_TEST", length = 65535)
	public String getLungFunctionTest() {
		return this.lungFunctionTest;
	}

	public void setLungFunctionTest(String lungFunctionTest) {
		this.lungFunctionTest = lungFunctionTest;
	}

	@Column(name = "COMPLICATION", length = 65535)
	public String getComplication() {
		return this.complication;
	}

	public void setComplication(String complication) {
		this.complication = complication;
	}

	@Column(name = "SELEF_BREATH", length = 65535)
	public String getSelefBreath() {
		return this.selefBreath;
	}

	public void setSelefBreath(String selefBreath) {
		this.selefBreath = selefBreath;
	}

	@Column(name = "HEART_CLASS", length = 65535)
	public String getHeartClass() {
		return this.heartClass;
	}

	public void setHeartClass(String heartClass) {
		this.heartClass = heartClass;
	}

	@Column(name = "REMARKS", length = 65535)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "INVESTIGATED_PERSON", nullable = false)
	public String getInvestigatedPerson() {
		return this.investigatedPerson;
	}

	public void setInvestigatedPerson(String investigatedPerson) {
		this.investigatedPerson = investigatedPerson;
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