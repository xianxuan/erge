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
 * THighBloodPressure entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_HIGH_BLOOD_PRESSURE", catalog = "jmjk")
public class THighBloodPressure implements java.io.Serializable {

	// Fields

	private Integer highBloodPressureId;
	private TLifeStyle TLifeStyle;
	private TChronicDisease TChronicDisease;
	private TGeneralCondition TGeneralCondition;
	private String highBloodTypr;
	private String managementClass;
	private Timestamp initialDiagnosisTime;
	private String mainSymptoms;
	private String hypertensionComplication;
	private String howLongTakeBlood;
	private String takeMedication;
	private String notTakeReason;
	private Double drugCost;
	private String nonDrugTreatment;
	private String familyWhitHighBlood;
	private Timestamp filingDate;
	private String bookrunner;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public THighBloodPressure() {
	}

	/** minimal constructor */
	public THighBloodPressure(TLifeStyle TLifeStyle,
			TChronicDisease TChronicDisease,
			TGeneralCondition TGeneralCondition, String highBloodTypr) {
		this.TLifeStyle = TLifeStyle;
		this.TChronicDisease = TChronicDisease;
		this.TGeneralCondition = TGeneralCondition;
		this.highBloodTypr = highBloodTypr;
	}

	/** full constructor */
	public THighBloodPressure(TLifeStyle TLifeStyle,
			TChronicDisease TChronicDisease,
			TGeneralCondition TGeneralCondition, String highBloodTypr,
			String managementClass, Timestamp initialDiagnosisTime,
			String mainSymptoms, String hypertensionComplication,
			String howLongTakeBlood, String takeMedication,
			String notTakeReason, Double drugCost, String nonDrugTreatment,
			String familyWhitHighBlood, Timestamp filingDate,
			String bookrunner, String one, String two, String three,
			String four, String five) {
		this.TLifeStyle = TLifeStyle;
		this.TChronicDisease = TChronicDisease;
		this.TGeneralCondition = TGeneralCondition;
		this.highBloodTypr = highBloodTypr;
		this.managementClass = managementClass;
		this.initialDiagnosisTime = initialDiagnosisTime;
		this.mainSymptoms = mainSymptoms;
		this.hypertensionComplication = hypertensionComplication;
		this.howLongTakeBlood = howLongTakeBlood;
		this.takeMedication = takeMedication;
		this.notTakeReason = notTakeReason;
		this.drugCost = drugCost;
		this.nonDrugTreatment = nonDrugTreatment;
		this.familyWhitHighBlood = familyWhitHighBlood;
		this.filingDate = filingDate;
		this.bookrunner = bookrunner;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "HIGH_BLOOD_PRESSURE_ID", unique = true, nullable = false)
	public Integer getHighBloodPressureId() {
		return this.highBloodPressureId;
	}

	public void setHighBloodPressureId(Integer highBloodPressureId) {
		this.highBloodPressureId = highBloodPressureId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LIFE_ID", nullable = false)
	public TLifeStyle getTLifeStyle() {
		return this.TLifeStyle;
	}

	public void setTLifeStyle(TLifeStyle TLifeStyle) {
		this.TLifeStyle = TLifeStyle;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHRONIC_DISEASE_ID", nullable = false)
	public TChronicDisease getTChronicDisease() {
		return this.TChronicDisease;
	}

	public void setTChronicDisease(TChronicDisease TChronicDisease) {
		this.TChronicDisease = TChronicDisease;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GENERAL_CONDITION_ID", nullable = false)
	public TGeneralCondition getTGeneralCondition() {
		return this.TGeneralCondition;
	}

	public void setTGeneralCondition(TGeneralCondition TGeneralCondition) {
		this.TGeneralCondition = TGeneralCondition;
	}

	@Column(name = "HIGH_BLOOD_TYPR", nullable = false)
	public String getHighBloodTypr() {
		return this.highBloodTypr;
	}

	public void setHighBloodTypr(String highBloodTypr) {
		this.highBloodTypr = highBloodTypr;
	}

	@Column(name = "MANAGEMENT_CLASS")
	public String getManagementClass() {
		return this.managementClass;
	}

	public void setManagementClass(String managementClass) {
		this.managementClass = managementClass;
	}

	@Column(name = "INITIAL_DIAGNOSIS_TIME", length = 19)
	public Timestamp getInitialDiagnosisTime() {
		return this.initialDiagnosisTime;
	}

	public void setInitialDiagnosisTime(Timestamp initialDiagnosisTime) {
		this.initialDiagnosisTime = initialDiagnosisTime;
	}

	@Column(name = "MAIN_SYMPTOMS")
	public String getMainSymptoms() {
		return this.mainSymptoms;
	}

	public void setMainSymptoms(String mainSymptoms) {
		this.mainSymptoms = mainSymptoms;
	}

	@Column(name = "HYPERTENSION_COMPLICATION")
	public String getHypertensionComplication() {
		return this.hypertensionComplication;
	}

	public void setHypertensionComplication(String hypertensionComplication) {
		this.hypertensionComplication = hypertensionComplication;
	}

	@Column(name = "HOW_LONG_TAKE_BLOOD")
	public String getHowLongTakeBlood() {
		return this.howLongTakeBlood;
	}

	public void setHowLongTakeBlood(String howLongTakeBlood) {
		this.howLongTakeBlood = howLongTakeBlood;
	}

	@Column(name = "TAKE_MEDICATION")
	public String getTakeMedication() {
		return this.takeMedication;
	}

	public void setTakeMedication(String takeMedication) {
		this.takeMedication = takeMedication;
	}

	@Column(name = "NOT_TAKE_REASON", length = 65535)
	public String getNotTakeReason() {
		return this.notTakeReason;
	}

	public void setNotTakeReason(String notTakeReason) {
		this.notTakeReason = notTakeReason;
	}

	@Column(name = "DRUG_COST", precision = 22, scale = 0)
	public Double getDrugCost() {
		return this.drugCost;
	}

	public void setDrugCost(Double drugCost) {
		this.drugCost = drugCost;
	}

	@Column(name = "NON_DRUG_TREATMENT")
	public String getNonDrugTreatment() {
		return this.nonDrugTreatment;
	}

	public void setNonDrugTreatment(String nonDrugTreatment) {
		this.nonDrugTreatment = nonDrugTreatment;
	}

	@Column(name = "FAMILY_WHIT_HIGH_BLOOD")
	public String getFamilyWhitHighBlood() {
		return this.familyWhitHighBlood;
	}

	public void setFamilyWhitHighBlood(String familyWhitHighBlood) {
		this.familyWhitHighBlood = familyWhitHighBlood;
	}

	@Column(name = "FILING_DATE", length = 19)
	public Timestamp getFilingDate() {
		return this.filingDate;
	}

	public void setFilingDate(Timestamp filingDate) {
		this.filingDate = filingDate;
	}

	@Column(name = "BOOKRUNNER")
	public String getBookrunner() {
		return this.bookrunner;
	}

	public void setBookrunner(String bookrunner) {
		this.bookrunner = bookrunner;
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