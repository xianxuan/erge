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
 * TPhysicalExam entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_PHYSICAL_EXAM", catalog = "jmjk")
public class TPhysicalExam implements java.io.Serializable {

	// Fields

	private Integer physicalExamId;
	private TLifeStyle TLifeStyle;
	private THealthFile THealthFile;
	private TAuxiliaryExamination TAuxiliaryExamination;
	private TCheck TCheck;
	private TChinaMedicine TChinaMedicine;
	private TOrganFunction TOrganFunction;
	private TGeneralCondition TGeneralCondition;
	private THealthExtingProblem THealthExtingProblem;
	private String characteristicSymptom;
	private String physicalExamType;
	private Timestamp physicalExamDate;
	private String responsibleDoctor;
	private String operator;
	private String healthAssessment;
	private String healthGuide;
	private String riskFactorControl;
	private Boolean isChronic;
	private String status;
	private String belongSystem;
	
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private Set<THF> THFs = new HashSet<THF>(0);
	private Set<THospitalHistory> THospitalHistories = new HashSet<THospitalHistory>(
			0);
	private Set<TDefendInocu> TDefendInocus = new HashSet<TDefendInocu>(0);
	private Set<TMedicalUse> TMedicalUses = new HashSet<TMedicalUse>(0);

	// Constructors

	/** default constructor */
	public TPhysicalExam() {
	}

	/** minimal constructor */
	public TPhysicalExam(String characteristicSymptom, String physicalExamType,
			Timestamp physicalExamDate, String operator) {
		this.characteristicSymptom = characteristicSymptom;
		this.physicalExamType = physicalExamType;
		this.physicalExamDate = physicalExamDate;
		this.operator = operator;
	}

	/** full constructor */
	public TPhysicalExam(TLifeStyle TLifeStyle, THealthFile THealthFile,
			TAuxiliaryExamination TAuxiliaryExamination, TCheck TCheck,
			TChinaMedicine TChinaMedicine, TOrganFunction TOrganFunction,
			TGeneralCondition TGeneralCondition,
			String belongSystem,
			THealthExtingProblem THealthExtingProblem,
			String characteristicSymptom, String physicalExamType,
			Timestamp physicalExamDate, String responsibleDoctor,
			String operator, String healthAssessment, String healthGuide,
			String riskFactorControl, Boolean isChronic, String status,
			String one, String two, String three, String four, String five,
			Set<THF> THFs, Set<THospitalHistory> THospitalHistories,
			Set<TDefendInocu> TDefendInocus, Set<TMedicalUse> TMedicalUses) {
		this.TLifeStyle = TLifeStyle;
		this.THealthFile = THealthFile;
		this.TAuxiliaryExamination = TAuxiliaryExamination;
		this.TCheck = TCheck;
		this.belongSystem = belongSystem;
		this.TChinaMedicine = TChinaMedicine;
		this.TOrganFunction = TOrganFunction;
		this.TGeneralCondition = TGeneralCondition;
		this.THealthExtingProblem = THealthExtingProblem;
		this.characteristicSymptom = characteristicSymptom;
		this.physicalExamType = physicalExamType;
		this.physicalExamDate = physicalExamDate;
		this.responsibleDoctor = responsibleDoctor;
		this.operator = operator;
		this.healthAssessment = healthAssessment;
		this.healthGuide = healthGuide;
		this.riskFactorControl = riskFactorControl;
		this.isChronic = isChronic;
		this.status = status;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.THFs = THFs;
		this.THospitalHistories = THospitalHistories;
		this.TDefendInocus = TDefendInocus;
		this.TMedicalUses = TMedicalUses;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "PHYSICAL_EXAM_ID", unique = true, nullable = false)
	public Integer getPhysicalExamId() {
		return this.physicalExamId;
	}

	public void setPhysicalExamId(Integer physicalExamId) {
		this.physicalExamId = physicalExamId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LIFE_ID")
	public TLifeStyle getTLifeStyle() {
		return this.TLifeStyle;
	}

	public void setTLifeStyle(TLifeStyle TLifeStyle) {
		this.TLifeStyle = TLifeStyle;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HEALTH_FILE_ID")
	public THealthFile getTHealthFile() {
		return this.THealthFile;
	}

	public void setTHealthFile(THealthFile THealthFile) {
		this.THealthFile = THealthFile;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AUXILIARY_EXAMINATION_ID")
	public TAuxiliaryExamination getTAuxiliaryExamination() {
		return this.TAuxiliaryExamination;
	}

	public void setTAuxiliaryExamination(
			TAuxiliaryExamination TAuxiliaryExamination) {
		this.TAuxiliaryExamination = TAuxiliaryExamination;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHECK_ID")
	public TCheck getTCheck() {
		return this.TCheck;
	}

	public void setTCheck(TCheck TCheck) {
		this.TCheck = TCheck;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHINA_MEDICINE_ID")
	public TChinaMedicine getTChinaMedicine() {
		return this.TChinaMedicine;
	}

	public void setTChinaMedicine(TChinaMedicine TChinaMedicine) {
		this.TChinaMedicine = TChinaMedicine;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORGAN_FUNCTION_ID")
	public TOrganFunction getTOrganFunction() {
		return this.TOrganFunction;
	}

	public void setTOrganFunction(TOrganFunction TOrganFunction) {
		this.TOrganFunction = TOrganFunction;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GENERAL_CONDITION_ID")
	public TGeneralCondition getTGeneralCondition() {
		return this.TGeneralCondition;
	}

	public void setTGeneralCondition(TGeneralCondition TGeneralCondition) {
		this.TGeneralCondition = TGeneralCondition;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HEALTH_EXISTING_PROBLEMS_ID")
	public THealthExtingProblem getTHealthExtingProblem() {
		return this.THealthExtingProblem;
	}

	public void setTHealthExtingProblem(
			THealthExtingProblem THealthExtingProblem) {
		this.THealthExtingProblem = THealthExtingProblem;
	}

	@Column(name = "CHARACTERISTIC_SYMPTOM", nullable = false)
	public String getCharacteristicSymptom() {
		return this.characteristicSymptom;
	}

	public void setCharacteristicSymptom(String characteristicSymptom) {
		this.characteristicSymptom = characteristicSymptom;
	}

	@Column(name = "PHYSICAL_EXAM_TYPE", nullable = false)
	public String getPhysicalExamType() {
		return this.physicalExamType;
	}

	public void setPhysicalExamType(String physicalExamType) {
		this.physicalExamType = physicalExamType;
	}

	@Column(name = "PHYSICAL_EXAM_DATE", nullable = false, length = 19)
	public Timestamp getPhysicalExamDate() {
		return this.physicalExamDate;
	}

	public void setPhysicalExamDate(Timestamp physicalExamDate) {
		this.physicalExamDate = physicalExamDate;
	}

	@Column(name = "RESPONSIBLE_DOCTOR")
	public String getResponsibleDoctor() {
		return this.responsibleDoctor;
	}

	public void setResponsibleDoctor(String responsibleDoctor) {
		this.responsibleDoctor = responsibleDoctor;
	}

	@Column(name = "OPERATOR", nullable = false)
	public String getOperator() {
		return this.operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	@Column(name = "HEALTH_ASSESSMENT", length = 65535)
	public String getHealthAssessment() {
		return this.healthAssessment;
	}

	public void setHealthAssessment(String healthAssessment) {
		this.healthAssessment = healthAssessment;
	}

	@Column(name = "HEALTH_GUIDE", length = 65535)
	public String getHealthGuide() {
		return this.healthGuide;
	}

	public void setHealthGuide(String healthGuide) {
		this.healthGuide = healthGuide;
	}

	@Column(name = "RISK_FACTOR_CONTROL", length = 65535)
	public String getRiskFactorControl() {
		return this.riskFactorControl;
	}

	public void setRiskFactorControl(String riskFactorControl) {
		this.riskFactorControl = riskFactorControl;
	}

	@Column(name = "IS_CHRONIC")
	public Boolean getIsChronic() {
		return this.isChronic;
	}

	public void setIsChronic(Boolean isChronic) {
		this.isChronic = isChronic;
	}

	@Column(name = "STATUS", length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TPhysicalExam")
	public Set<THF> getTHFs() {
		return this.THFs;
	}

	public void setTHFs(Set<THF> THFs) {
		this.THFs = THFs;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TPhysicalExam")
	public Set<THospitalHistory> getTHospitalHistories() {
		return this.THospitalHistories;
	}

	public void setTHospitalHistories(Set<THospitalHistory> THospitalHistories) {
		this.THospitalHistories = THospitalHistories;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TPhysicalExam")
	public Set<TDefendInocu> getTDefendInocus() {
		return this.TDefendInocus;
	}

	public void setTDefendInocus(Set<TDefendInocu> TDefendInocus) {
		this.TDefendInocus = TDefendInocus;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TPhysicalExam")
	public Set<TMedicalUse> getTMedicalUses() {
		return this.TMedicalUses;
	}

	public void setTMedicalUses(Set<TMedicalUse> TMedicalUses) {
		this.TMedicalUses = TMedicalUses;
	}
	
	@Column(name = "BELONG_SYSTEM", length = 255)
	public String getBelongSystem() {
		return this.belongSystem;
	}

	public void setBelongSystem(String belongSystem) {
		this.belongSystem = belongSystem;
	}

	
	
}