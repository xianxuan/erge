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
 * TFollowRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_FOLLOW_RECORD", catalog = "jmjk")
public class TFollowRecord implements java.io.Serializable {

	// Fields

	private Integer followRecordId;
	private THealthFile THealthFile;
	private String actionChief;
	private String hip;
	private Double weight;
	private Double bodyTemperature;
	private Integer pulse;
	private Integer breathing;
	private Double fastBloodGlucose;
	private Double postprandialGlucose;
	private Double diastolicBloodPressure;
	private Double sysrolicBloodPressure;
	private String diagnosis;
	private String outcome;
	private String dealWith;
	private Timestamp time;
	private String followDoctor;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TFollowRecord() {
	}

	/** minimal constructor */
	public TFollowRecord(THealthFile THealthFile) {
		this.THealthFile = THealthFile;
	}

	/** full constructor */
	public TFollowRecord(THealthFile THealthFile, String actionChief,
			String hip, Double weight, Double bodyTemperature, Integer pulse,
			Integer breathing, Double fastBloodGlucose,
			Double postprandialGlucose, Double diastolicBloodPressure,
			Double sysrolicBloodPressure, String diagnosis, String outcome,
			String dealWith, Timestamp time, String followDoctor, String one,
			String two, String three, String four, String five) {
		this.THealthFile = THealthFile;
		this.actionChief = actionChief;
		this.hip = hip;
		this.weight = weight;
		this.bodyTemperature = bodyTemperature;
		this.pulse = pulse;
		this.breathing = breathing;
		this.fastBloodGlucose = fastBloodGlucose;
		this.postprandialGlucose = postprandialGlucose;
		this.diastolicBloodPressure = diastolicBloodPressure;
		this.sysrolicBloodPressure = sysrolicBloodPressure;
		this.diagnosis = diagnosis;
		this.outcome = outcome;
		this.dealWith = dealWith;
		this.time = time;
		this.followDoctor = followDoctor;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "FOLLOW_RECORD_ID", unique = true, nullable = false)
	public Integer getFollowRecordId() {
		return this.followRecordId;
	}

	public void setFollowRecordId(Integer followRecordId) {
		this.followRecordId = followRecordId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HEALTH_FILE_ID", nullable = false)
	public THealthFile getTHealthFile() {
		return this.THealthFile;
	}

	public void setTHealthFile(THealthFile THealthFile) {
		this.THealthFile = THealthFile;
	}

	@Column(name = "ACTION_CHIEF", length = 65535)
	public String getActionChief() {
		return this.actionChief;
	}

	public void setActionChief(String actionChief) {
		this.actionChief = actionChief;
	}

	@Column(name = "HIP", length = 65535)
	public String getHip() {
		return this.hip;
	}

	public void setHip(String hip) {
		this.hip = hip;
	}

	@Column(name = "WEIGHT", precision = 22, scale = 0)
	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Column(name = "BODY_TEMPERATURE", precision = 22, scale = 0)
	public Double getBodyTemperature() {
		return this.bodyTemperature;
	}

	public void setBodyTemperature(Double bodyTemperature) {
		this.bodyTemperature = bodyTemperature;
	}

	@Column(name = "PULSE")
	public Integer getPulse() {
		return this.pulse;
	}

	public void setPulse(Integer pulse) {
		this.pulse = pulse;
	}

	@Column(name = "BREATHING")
	public Integer getBreathing() {
		return this.breathing;
	}

	public void setBreathing(Integer breathing) {
		this.breathing = breathing;
	}

	@Column(name = "FAST_BLOOD_GLUCOSE", precision = 22, scale = 0)
	public Double getFastBloodGlucose() {
		return this.fastBloodGlucose;
	}

	public void setFastBloodGlucose(Double fastBloodGlucose) {
		this.fastBloodGlucose = fastBloodGlucose;
	}

	@Column(name = "POSTPRANDIAL_GLUCOSE", precision = 22, scale = 0)
	public Double getPostprandialGlucose() {
		return this.postprandialGlucose;
	}

	public void setPostprandialGlucose(Double postprandialGlucose) {
		this.postprandialGlucose = postprandialGlucose;
	}

	@Column(name = "DIASTOLIC_BLOOD_PRESSURE", precision = 22, scale = 0)
	public Double getDiastolicBloodPressure() {
		return this.diastolicBloodPressure;
	}

	public void setDiastolicBloodPressure(Double diastolicBloodPressure) {
		this.diastolicBloodPressure = diastolicBloodPressure;
	}

	@Column(name = "SYSROLIC_BLOOD_PRESSURE", precision = 22, scale = 0)
	public Double getSysrolicBloodPressure() {
		return this.sysrolicBloodPressure;
	}

	public void setSysrolicBloodPressure(Double sysrolicBloodPressure) {
		this.sysrolicBloodPressure = sysrolicBloodPressure;
	}

	@Column(name = "DIAGNOSIS", length = 65535)
	public String getDiagnosis() {
		return this.diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	@Column(name = "OUTCOME", length = 65535)
	public String getOutcome() {
		return this.outcome;
	}

	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}

	@Column(name = "DEAL_WITH", length = 65535)
	public String getDealWith() {
		return this.dealWith;
	}

	public void setDealWith(String dealWith) {
		this.dealWith = dealWith;
	}

	@Column(name = "TIME", length = 19)
	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	@Column(name = "FOLLOW_DOCTOR")
	public String getFollowDoctor() {
		return this.followDoctor;
	}

	public void setFollowDoctor(String followDoctor) {
		this.followDoctor = followDoctor;
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