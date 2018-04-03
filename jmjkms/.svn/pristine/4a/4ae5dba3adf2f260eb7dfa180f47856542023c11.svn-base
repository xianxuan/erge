package com.jmjk.entity;
// default package

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
 * TGeneralCondition entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_GENERAL_CONDITION", catalog = "jmjk")
public class TGeneralCondition implements java.io.Serializable {

	// Fields

	private Integer generalConditionId;
	private Double temperature;
	private Integer breathingRate;
	private Double diastolicPressure;
	private Double systolicPressure;
	private Integer pulseRate;
	private Double height;
	private Double weight;
	private Double bmi;
	private Double waistline;
	private Double hip;
	private Double ratio;
	private String healthAssessment;
	private String selfAssessment;
	private String cognitiveFunction;
	private String emotion;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private Set<TDiabete> TDiabetes = new HashSet<TDiabete>(0);
	private Set<TPhysicalExam> TPhysicalExams = new HashSet<TPhysicalExam>(0);
	private Set<THighBloodPressure> THighBloodPressures = new HashSet<THighBloodPressure>(
			0);

	// Constructors

	/** default constructor */
	public TGeneralCondition() {
	}
	public TGeneralCondition(Integer generalConditionId) {
	    this.generalConditionId=generalConditionId;
    }
	/** full constructor */
	public TGeneralCondition(Double temperature, Integer breathingRate,
			Double diastolicPressure, Double systolicPressure,
			Integer pulseRate, Double height, Double weight, Double bmi,
			Double waistline, Double hip, Double ratio,
			String healthAssessment, String selfAssessment,
			String cognitiveFunction, String emotion, String one, String two,
			String three, String four, String five, Set<TDiabete> TDiabetes,
			Set<TPhysicalExam> TPhysicalExams,
			Set<THighBloodPressure> THighBloodPressures) {
		this.temperature = temperature;
		this.breathingRate = breathingRate;
		this.diastolicPressure = diastolicPressure;
		this.systolicPressure = systolicPressure;
		this.pulseRate = pulseRate;
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.waistline = waistline;
		this.hip = hip;
		this.ratio = ratio;
		this.healthAssessment = healthAssessment;
		this.selfAssessment = selfAssessment;
		this.cognitiveFunction = cognitiveFunction;
		this.emotion = emotion;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.TDiabetes = TDiabetes;
		this.TPhysicalExams = TPhysicalExams;
		this.THighBloodPressures = THighBloodPressures;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "GENERAL_CONDITION_ID", unique = true, nullable = false)
	public Integer getGeneralConditionId() {
		return this.generalConditionId;
	}

	public void setGeneralConditionId(Integer generalConditionId) {
		this.generalConditionId = generalConditionId;
	}

	@Column(name = "TEMPERATURE", precision = 22, scale = 0)
	public Double getTemperature() {
		return this.temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	@Column(name = "BREATHING_RATE")
	public Integer getBreathingRate() {
		return this.breathingRate;
	}

	public void setBreathingRate(Integer breathingRate) {
		this.breathingRate = breathingRate;
	}

	@Column(name = "DIASTOLIC_PRESSURE", precision = 22, scale = 0)
	public Double getDiastolicPressure() {
		return this.diastolicPressure;
	}

	public void setDiastolicPressure(Double diastolicPressure) {
		this.diastolicPressure = diastolicPressure;
	}

	@Column(name = "SYSTOLIC_PRESSURE", precision = 22, scale = 0)
	public Double getSystolicPressure() {
		return this.systolicPressure;
	}

	public void setSystolicPressure(Double systolicPressure) {
		this.systolicPressure = systolicPressure;
	}

	@Column(name = "PULSE_RATE")
	public Integer getPulseRate() {
		return this.pulseRate;
	}

	public void setPulseRate(Integer pulseRate) {
		this.pulseRate = pulseRate;
	}

	@Column(name = "HEIGHT", precision = 22, scale = 0)
	public Double getHeight() {
		return this.height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	@Column(name = "WEIGHT", precision = 22, scale = 0)
	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Column(name = "BMI", precision = 22, scale = 0)
	public Double getBmi() {
		return this.bmi;
	}

	public void setBmi(Double bmi) {
		this.bmi = bmi;
	}

	@Column(name = "WAISTLINE", precision = 22, scale = 0)
	public Double getWaistline() {
		return this.waistline;
	}

	public void setWaistline(Double waistline) {
		this.waistline = waistline;
	}

	@Column(name = "HIP", precision = 22, scale = 0)
	public Double getHip() {
		return this.hip;
	}

	public void setHip(Double hip) {
		this.hip = hip;
	}

	@Column(name = "RATIO", precision = 22, scale = 0)
	public Double getRatio() {
		return this.ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

	@Column(name = "HEALTH_ASSESSMENT", length = 65535)
	public String getHealthAssessment() {
		return this.healthAssessment;
	}

	public void setHealthAssessment(String healthAssessment) {
		this.healthAssessment = healthAssessment;
	}

	@Column(name = "SELF_ASSESSMENT", length = 65535)
	public String getSelfAssessment() {
		return this.selfAssessment;
	}

	public void setSelfAssessment(String selfAssessment) {
		this.selfAssessment = selfAssessment;
	}

	@Column(name = "COGNITIVE_FUNCTION", length = 65535)
	public String getCognitiveFunction() {
		return this.cognitiveFunction;
	}

	public void setCognitiveFunction(String cognitiveFunction) {
		this.cognitiveFunction = cognitiveFunction;
	}

	@Column(name = "EMOTION", length = 1000)
	public String getEmotion() {
		return this.emotion;
	}

	public void setEmotion(String emotion) {
		this.emotion = emotion;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TGeneralCondition")
	public Set<TDiabete> getTDiabetes() {
		return this.TDiabetes;
	}

	public void setTDiabetes(Set<TDiabete> TDiabetes) {
		this.TDiabetes = TDiabetes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TGeneralCondition")
	public Set<TPhysicalExam> getTPhysicalExams() {
		return this.TPhysicalExams;
	}

	public void setTPhysicalExams(Set<TPhysicalExam> TPhysicalExams) {
		this.TPhysicalExams = TPhysicalExams;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TGeneralCondition")
	public Set<THighBloodPressure> getTHighBloodPressures() {
		return this.THighBloodPressures;
	}

	public void setTHighBloodPressures(
			Set<THighBloodPressure> THighBloodPressures) {
		this.THighBloodPressures = THighBloodPressures;
	}

}