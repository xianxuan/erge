package com.jmjk.entity.view;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VCardiovascularFollow entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "V_CARDIOVASCULAR_FOLLOW", catalog = "jmjk")
public class VCardiovascularFollow implements java.io.Serializable {

	// Fields

	private Integer followUpCardiovascularId;
	private Integer healthFileId;
	private Integer staffId;
	private Integer oldStaffHosId;
	private Integer communityHospitalId;
	private Integer chronicDiseaseId;
	private Integer chronicFollowId;
	private Timestamp followDate;
	private String followPeople;
	private String diseasrName;
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

	// Constructors

	/** default constructor */
	public VCardiovascularFollow() {
	}

	/** minimal constructor */
	public VCardiovascularFollow(Integer followUpCardiovascularId,
			Integer healthFileId, Integer oldStaffHosId, Timestamp followDate,
			String followPeople) {
		this.followUpCardiovascularId = followUpCardiovascularId;
		this.healthFileId = healthFileId;
		this.oldStaffHosId = oldStaffHosId;
		this.followDate = followDate;
		this.followPeople = followPeople;
	}

	/** full constructor */
	public VCardiovascularFollow(Integer followUpCardiovascularId,
			Integer healthFileId, Integer staffId, Integer oldStaffHosId,
			Integer communityHospitalId, Integer chronicDiseaseId,
			Integer chronicFollowId, Timestamp followDate, String followPeople,
			String diseasrName, String measureBloodPressure, String isDrug,
			String meanTimeMeasureBloodPressure, Integer heartRate,
			Double diastolicBlood, Double systolicBlood,
			Boolean isHeartRateDistory, Double weight,
			String currentMainSymptoms, String diet,
			String rehabilitationTreatment, Timestamp nextAppointmentDate,
			String appointmentIdea, String tip, String fllowedUp,
			String fllowUp, Timestamp fllowDate) {
		this.followUpCardiovascularId = followUpCardiovascularId;
		this.healthFileId = healthFileId;
		this.staffId = staffId;
		this.oldStaffHosId = oldStaffHosId;
		this.communityHospitalId = communityHospitalId;
		this.chronicDiseaseId = chronicDiseaseId;
		this.chronicFollowId = chronicFollowId;
		this.followDate = followDate;
		this.followPeople = followPeople;
		this.diseasrName = diseasrName;
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
	}

	// Property accessors
	@Id
	@Column(name = "FOLLOW_UP_CARDIOVASCULAR_ID", nullable = false)
	public Integer getFollowUpCardiovascularId() {
		return this.followUpCardiovascularId;
	}

	public void setFollowUpCardiovascularId(Integer followUpCardiovascularId) {
		this.followUpCardiovascularId = followUpCardiovascularId;
	}

	@Column(name = "HEALTH_FILE_ID", nullable = false)
	public Integer getHealthFileId() {
		return this.healthFileId;
	}

	public void setHealthFileId(Integer healthFileId) {
		this.healthFileId = healthFileId;
	}

	@Column(name = "STAFF_ID")
	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
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

	@Column(name = "CHRONIC_DISEASE_ID")
	public Integer getChronicDiseaseId() {
		return this.chronicDiseaseId;
	}

	public void setChronicDiseaseId(Integer chronicDiseaseId) {
		this.chronicDiseaseId = chronicDiseaseId;
	}

	@Column(name = "CHRONIC_FOLLOW_ID")
	public Integer getChronicFollowId() {
		return this.chronicFollowId;
	}

	public void setChronicFollowId(Integer chronicFollowId) {
		this.chronicFollowId = chronicFollowId;
	}

	@Column(name = "FOLLOW_DATE", nullable = false, length = 19)
	public Timestamp getFollowDate() {
		return this.followDate;
	}

	public void setFollowDate(Timestamp followDate) {
		this.followDate = followDate;
	}

	@Column(name = "FOLLOW_PEOPLE", nullable = false)
	public String getFollowPeople() {
		return this.followPeople;
	}

	public void setFollowPeople(String followPeople) {
		this.followPeople = followPeople;
	}

	@Column(name = "DISEASR_NAME")
	public String getDiseasrName() {
		return this.diseasrName;
	}

	public void setDiseasrName(String diseasrName) {
		this.diseasrName = diseasrName;
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

}