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
 * TFollowUpCardiovascular entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_FOLLOW_UP_CARDIOVASCULAR", catalog = "jmjk")
public class TFollowUpCardiovascular implements java.io.Serializable {

	// Fields

	private Integer followUpCardiovascularId;
	private TChronicFollow TChronicFollow;
	private String measureBloodPressure;
	private String isDrug;
	private String meanTimeMeasureBloodPressure;
	private Integer heartRate;
	private Double diastolicBlood;
	private Double systolicBlood;
	private Boolean isHeartRateDistory;
	private Double weight;
	private String currentMainSymptoms;
	private String diet;
	private String rehabilitationTreatment;
	private Timestamp nextAppointmentDate;
	private String appointmentIdea;
	private String tip;
	private String fllowedUp;
	private String fllowUp;
	private Timestamp fllowDate;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private Set<TDrugInformation> TDrugInformations = new HashSet<TDrugInformation>(
			0);

	// Constructors

	/** default constructor */
	public TFollowUpCardiovascular() {
	}

	/** full constructor */
	public TFollowUpCardiovascular(TChronicFollow TChronicFollow,
			String measureBloodPressure, String isDrug,
			String meanTimeMeasureBloodPressure, Integer heartRate,
			Double diastolicBlood, Double systolicBlood,
			Boolean isHeartRateDistory, Double weight,
			String currentMainSymptoms, String diet,
			String rehabilitationTreatment, Timestamp nextAppointmentDate,
			String appointmentIdea, String tip, String fllowedUp,
			String fllowUp, Timestamp fllowDate, String one, String two,
			String three, String four, String five,
			Set<TDrugInformation> TDrugInformations) {
		this.TChronicFollow = TChronicFollow;
		this.measureBloodPressure = measureBloodPressure;
		this.isDrug = isDrug;
		this.meanTimeMeasureBloodPressure = meanTimeMeasureBloodPressure;
		this.heartRate = heartRate;
		this.diastolicBlood = diastolicBlood;
		this.systolicBlood = systolicBlood;
		this.isHeartRateDistory = isHeartRateDistory;
		this.weight = weight;
		this.currentMainSymptoms = currentMainSymptoms;
		this.diet = diet;
		this.rehabilitationTreatment = rehabilitationTreatment;
		this.nextAppointmentDate = nextAppointmentDate;
		this.appointmentIdea = appointmentIdea;
		this.tip = tip;
		this.fllowedUp = fllowedUp;
		this.fllowUp = fllowUp;
		this.fllowDate = fllowDate;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.TDrugInformations = TDrugInformations;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "FOLLOW_UP_CARDIOVASCULAR_ID", unique = true, nullable = false)
	public Integer getFollowUpCardiovascularId() {
		return this.followUpCardiovascularId;
	}

	public void setFollowUpCardiovascularId(Integer followUpCardiovascularId) {
		this.followUpCardiovascularId = followUpCardiovascularId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHRONIC_FOLLOW_ID")
	public TChronicFollow getTChronicFollow() {
		return this.TChronicFollow;
	}

	public void setTChronicFollow(TChronicFollow TChronicFollow) {
		this.TChronicFollow = TChronicFollow;
	}

	@Column(name = "MEASURE_BLOOD_PRESSURE")
	public String getMeasureBloodPressure() {
		return this.measureBloodPressure;
	}

	public void setMeasureBloodPressure(String measureBloodPressure) {
		this.measureBloodPressure = measureBloodPressure;
	}

	@Column(name = "IS_DRUG")
	public String getIsDrug() {
		return this.isDrug;
	}

	public void setIsDrug(String isDrug) {
		this.isDrug = isDrug;
	}

	@Column(name = "MEAN_TIME_MEASURE_BLOOD_PRESSURE")
	public String getMeanTimeMeasureBloodPressure() {
		return this.meanTimeMeasureBloodPressure;
	}

	public void setMeanTimeMeasureBloodPressure(
			String meanTimeMeasureBloodPressure) {
		this.meanTimeMeasureBloodPressure = meanTimeMeasureBloodPressure;
	}

	@Column(name = "HEART_RATE")
	public Integer getHeartRate() {
		return this.heartRate;
	}

	public void setHeartRate(Integer heartRate) {
		this.heartRate = heartRate;
	}

	@Column(name = "DIASTOLIC_BLOOD", precision = 22, scale = 0)
	public Double getDiastolicBlood() {
		return this.diastolicBlood;
	}

	public void setDiastolicBlood(Double diastolicBlood) {
		this.diastolicBlood = diastolicBlood;
	}

	@Column(name = "SYSTOLIC_BLOOD", precision = 22, scale = 0)
	public Double getSystolicBlood() {
		return this.systolicBlood;
	}

	public void setSystolicBlood(Double systolicBlood) {
		this.systolicBlood = systolicBlood;
	}

	@Column(name = "IS_HEART_RATE_DISTORY")
	public Boolean getIsHeartRateDistory() {
		return this.isHeartRateDistory;
	}

	public void setIsHeartRateDistory(Boolean isHeartRateDistory) {
		this.isHeartRateDistory = isHeartRateDistory;
	}

	@Column(name = "WEIGHT", precision = 22, scale = 0)
	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Column(name = "CURRENT_MAIN_SYMPTOMS", length = 65535)
	public String getCurrentMainSymptoms() {
		return this.currentMainSymptoms;
	}

	public void setCurrentMainSymptoms(String currentMainSymptoms) {
		this.currentMainSymptoms = currentMainSymptoms;
	}

	@Column(name = "DIET", length = 65535)
	public String getDiet() {
		return this.diet;
	}

	public void setDiet(String diet) {
		this.diet = diet;
	}

	@Column(name = "REHABILITATION_TREATMENT", length = 65535)
	public String getRehabilitationTreatment() {
		return this.rehabilitationTreatment;
	}

	public void setRehabilitationTreatment(String rehabilitationTreatment) {
		this.rehabilitationTreatment = rehabilitationTreatment;
	}

	@Column(name = "NEXT_APPOINTMENT_DATE", length = 19)
	public Timestamp getNextAppointmentDate() {
		return this.nextAppointmentDate;
	}

	public void setNextAppointmentDate(Timestamp nextAppointmentDate) {
		this.nextAppointmentDate = nextAppointmentDate;
	}

	@Column(name = "APPOINTMENT_IDEA", length = 65535)
	public String getAppointmentIdea() {
		return this.appointmentIdea;
	}

	public void setAppointmentIdea(String appointmentIdea) {
		this.appointmentIdea = appointmentIdea;
	}

	@Column(name = "TIP", length = 65535)
	public String getTip() {
		return this.tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	@Column(name = "FLLOWED_UP")
	public String getFllowedUp() {
		return this.fllowedUp;
	}

	public void setFllowedUp(String fllowedUp) {
		this.fllowedUp = fllowedUp;
	}

	@Column(name = "FLLOW_UP")
	public String getFllowUp() {
		return this.fllowUp;
	}

	public void setFllowUp(String fllowUp) {
		this.fllowUp = fllowUp;
	}

	@Column(name = "FLLOW_DATE", length = 19)
	public Timestamp getFllowDate() {
		return this.fllowDate;
	}

	public void setFllowDate(Timestamp fllowDate) {
		this.fllowDate = fllowDate;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TFollowUpCardiovascular")
	public Set<TDrugInformation> getTDrugInformations() {
		return this.TDrugInformations;
	}

	public void setTDrugInformations(Set<TDrugInformation> TDrugInformations) {
		this.TDrugInformations = TDrugInformations;
	}

}