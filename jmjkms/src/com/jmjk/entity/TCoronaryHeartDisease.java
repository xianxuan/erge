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
 * TCoronaryHeartDisease entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_CORONARY_HEART_DISEASE", catalog = "jmjk")
public class TCoronaryHeartDisease implements java.io.Serializable {

	// Fields

	private Integer coronaryHeartDiseaseId;
	private TChronicFollow TChronicFollow;
	private String testingBloodPressure;
	private Double averageMeasurementTime;
	private String whetherDrug;
	private Double diastolicBloodPressure;
	private Double systolicBloodPressure;
	private Integer heartRate;
	private Boolean whetherArrhythmia;
	private Double weight;
	private String mainSymptoms;
	private String dietState;
	private String treatment;
	private Timestamp appointmentTimeNext;
	private String guidance;
	private String remark;
	private String byFollowUp;
	private String followUpPerson;
	private Timestamp followUpDate;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private Set<TDrugInformation> TDrugInformations = new HashSet<TDrugInformation>(
			0);

	// Constructors

	/** default constructor */
	public TCoronaryHeartDisease() {
	}

	/** full constructor */
	public TCoronaryHeartDisease(TChronicFollow TChronicFollow,
			String testingBloodPressure, Double averageMeasurementTime,
			String whetherDrug, Double diastolicBloodPressure,
			Double systolicBloodPressure, Integer heartRate,
			Boolean whetherArrhythmia, Double weight, String mainSymptoms,
			String dietState, String treatment, Timestamp appointmentTimeNext,
			String guidance, String remark, String byFollowUp,
			String followUpPerson, Timestamp followUpDate, String one,
			String two, String three, String four, String five,
			Set<TDrugInformation> TDrugInformations) {
		this.TChronicFollow = TChronicFollow;
		this.testingBloodPressure = testingBloodPressure;
		this.averageMeasurementTime = averageMeasurementTime;
		this.whetherDrug = whetherDrug;
		this.diastolicBloodPressure = diastolicBloodPressure;
		this.systolicBloodPressure = systolicBloodPressure;
		this.heartRate = heartRate;
		this.whetherArrhythmia = whetherArrhythmia;
		this.weight = weight;
		this.mainSymptoms = mainSymptoms;
		this.dietState = dietState;
		this.treatment = treatment;
		this.appointmentTimeNext = appointmentTimeNext;
		this.guidance = guidance;
		this.remark = remark;
		this.byFollowUp = byFollowUp;
		this.followUpPerson = followUpPerson;
		this.followUpDate = followUpDate;
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
	@Column(name = "CORONARY_HEART_DISEASE_ID", unique = true, nullable = false)
	public Integer getCoronaryHeartDiseaseId() {
		return this.coronaryHeartDiseaseId;
	}

	public void setCoronaryHeartDiseaseId(Integer coronaryHeartDiseaseId) {
		this.coronaryHeartDiseaseId = coronaryHeartDiseaseId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHRONIC_FOLLOW_ID")
	public TChronicFollow getTChronicFollow() {
		return this.TChronicFollow;
	}

	public void setTChronicFollow(TChronicFollow TChronicFollow) {
		this.TChronicFollow = TChronicFollow;
	}

	@Column(name = "TESTING_BLOOD_PRESSURE")
	public String getTestingBloodPressure() {
		return this.testingBloodPressure;
	}

	public void setTestingBloodPressure(String testingBloodPressure) {
		this.testingBloodPressure = testingBloodPressure;
	}

	@Column(name = "AVERAGE_MEASUREMENT_TIME", precision = 22, scale = 0)
	public Double getAverageMeasurementTime() {
		return this.averageMeasurementTime;
	}

	public void setAverageMeasurementTime(Double averageMeasurementTime) {
		this.averageMeasurementTime = averageMeasurementTime;
	}

	@Column(name = "WHETHER_DRUG")
	public String getWhetherDrug() {
		return this.whetherDrug;
	}

	public void setWhetherDrug(String whetherDrug) {
		this.whetherDrug = whetherDrug;
	}

	@Column(name = "DIASTOLIC_BLOOD_PRESSURE", precision = 22, scale = 0)
	public Double getDiastolicBloodPressure() {
		return this.diastolicBloodPressure;
	}

	public void setDiastolicBloodPressure(Double diastolicBloodPressure) {
		this.diastolicBloodPressure = diastolicBloodPressure;
	}

	@Column(name = "SYSTOLIC_BLOOD_PRESSURE", precision = 22, scale = 0)
	public Double getSystolicBloodPressure() {
		return this.systolicBloodPressure;
	}

	public void setSystolicBloodPressure(Double systolicBloodPressure) {
		this.systolicBloodPressure = systolicBloodPressure;
	}

	@Column(name = "HEART_RATE")
	public Integer getHeartRate() {
		return this.heartRate;
	}

	public void setHeartRate(Integer heartRate) {
		this.heartRate = heartRate;
	}

	@Column(name = "WHETHER_ARRHYTHMIA")
	public Boolean getWhetherArrhythmia() {
		return this.whetherArrhythmia;
	}

	public void setWhetherArrhythmia(Boolean whetherArrhythmia) {
		this.whetherArrhythmia = whetherArrhythmia;
	}

	@Column(name = "WEIGHT", precision = 22, scale = 0)
	public Double getWeight() {
		return this.weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	@Column(name = "MAIN_SYMPTOMS", length = 65535)
	public String getMainSymptoms() {
		return this.mainSymptoms;
	}

	public void setMainSymptoms(String mainSymptoms) {
		this.mainSymptoms = mainSymptoms;
	}

	@Column(name = "DIET_STATE", length = 65535)
	public String getDietState() {
		return this.dietState;
	}

	public void setDietState(String dietState) {
		this.dietState = dietState;
	}

	@Column(name = "TREATMENT", length = 65535)
	public String getTreatment() {
		return this.treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	@Column(name = "APPOINTMENT_TIME_NEXT", length = 19)
	public Timestamp getAppointmentTimeNext() {
		return this.appointmentTimeNext;
	}

	public void setAppointmentTimeNext(Timestamp appointmentTimeNext) {
		this.appointmentTimeNext = appointmentTimeNext;
	}

	@Column(name = "GUIDANCE", length = 65535)
	public String getGuidance() {
		return this.guidance;
	}

	public void setGuidance(String guidance) {
		this.guidance = guidance;
	}

	@Column(name = "REMARK", length = 65535)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "BY_FOLLOW_UP")
	public String getByFollowUp() {
		return this.byFollowUp;
	}

	public void setByFollowUp(String byFollowUp) {
		this.byFollowUp = byFollowUp;
	}

	@Column(name = "FOLLOW_UP_PERSON")
	public String getFollowUpPerson() {
		return this.followUpPerson;
	}

	public void setFollowUpPerson(String followUpPerson) {
		this.followUpPerson = followUpPerson;
	}

	@Column(name = "FOLLOW_UP_DATE", length = 19)
	public Timestamp getFollowUpDate() {
		return this.followUpDate;
	}

	public void setFollowUpDate(Timestamp followUpDate) {
		this.followUpDate = followUpDate;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TCoronaryHeartDisease")
	public Set<TDrugInformation> getTDrugInformations() {
		return this.TDrugInformations;
	}

	public void setTDrugInformations(Set<TDrugInformation> TDrugInformations) {
		this.TDrugInformations = TDrugInformations;
	}

}