package com.jmjk.entity.view;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VOtherillFollow entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "V_OTHERILL_FOLLOW", catalog = "jmjk")
public class VOtherillFollow implements java.io.Serializable {

	// Fields

	private Integer chronicFollowId;
	private Integer healthFileId;
	private Integer staffId;
	private Integer oldStaffHosId;
	private Integer communityHospitalId;
	private Integer chronicDiseaseId;
	private String diseasrName;
	private String followPeople;
	private Timestamp followDate;
	private Integer TRegOthDisId;
	private String diseasesName;
	private String symptomCharacteristic;
	private String everyTime;
	private String week;
	private String saltIntake;
	private String medicalState;
	private String eatingHabits;
	private String metalState;
	private String smoke;
	private String drink;
	private Double fastingBloodGlucose;
	private String otherInspection;
	private String dietControl;
	private String otherTrett;
	private Timestamp nextAppointmentDate;
	private String followUpGuidance;
	private String note;
	private String followedUp;
	private String followUp;
	private Timestamp followUpDate;
	private Double bmi;
	private Integer signId;
	private Double wight;
	private Double height;
	private Double bloodPressureL;
	private Double bloodPressureH;
	private String heartRate;
	private String others;

	// Constructors

	/** default constructor */
	public VOtherillFollow() {
	}

	/** minimal constructor */
	public VOtherillFollow(Integer chronicFollowId, Integer healthFileId,
			Integer oldStaffHosId, String followPeople, Timestamp followDate,
			Integer TRegOthDisId, Integer signId) {
		this.chronicFollowId = chronicFollowId;
		this.healthFileId = healthFileId;
		this.oldStaffHosId = oldStaffHosId;
		this.followPeople = followPeople;
		this.followDate = followDate;
		this.TRegOthDisId = TRegOthDisId;
		this.signId = signId;
	}

	/** full constructor */
	public VOtherillFollow(Integer chronicFollowId, Integer healthFileId,
			Integer staffId, Integer oldStaffHosId,
			Integer communityHospitalId, Integer chronicDiseaseId,
			String diseasrName, String followPeople, Timestamp followDate,
			Integer TRegOthDisId, String diseasesName,
			String symptomCharacteristic, String everyTime, String week,
			String saltIntake, String medicalState, String eatingHabits,
			String metalState, String smoke, String drink,
			Double fastingBloodGlucose, String otherInspection,
			String dietControl, String otherTrett,
			Timestamp nextAppointmentDate, String followUpGuidance,
			String note, String followedUp, String followUp,
			Timestamp followUpDate, Double bmi, Integer signId, Double wight,
			Double height, Double bloodPressureL, Double bloodPressureH,
			String heartRate, String others) {
		this.chronicFollowId = chronicFollowId;
		this.healthFileId = healthFileId;
		this.staffId = staffId;
		this.oldStaffHosId = oldStaffHosId;
		this.communityHospitalId = communityHospitalId;
		this.chronicDiseaseId = chronicDiseaseId;
		this.diseasrName = diseasrName;
		this.followPeople = followPeople;
		this.followDate = followDate;
		this.TRegOthDisId = TRegOthDisId;
		this.diseasesName = diseasesName;
		this.symptomCharacteristic = symptomCharacteristic;
		this.everyTime = everyTime;
		this.week = week;
		this.saltIntake = saltIntake;
		this.medicalState = medicalState;
		this.eatingHabits = eatingHabits;
		this.metalState = metalState;
		this.smoke = smoke;
		this.drink = drink;
		this.fastingBloodGlucose = fastingBloodGlucose;
		this.otherInspection = otherInspection;
		this.dietControl = dietControl;
		this.otherTrett = otherTrett;
		this.nextAppointmentDate = nextAppointmentDate;
		this.followUpGuidance = followUpGuidance;
		this.note = note;
		this.followedUp = followedUp;
		this.followUp = followUp;
		this.followUpDate = followUpDate;
		this.bmi = bmi;
		this.signId = signId;
		this.wight = wight;
		this.height = height;
		this.bloodPressureL = bloodPressureL;
		this.bloodPressureH = bloodPressureH;
		this.heartRate = heartRate;
		this.others = others;
	}

	// Property accessors
	@Id
	@Column(name = "CHRONIC_FOLLOW_ID")
	public Integer getChronicFollowId() {
		return this.chronicFollowId;
	}

	public void setChronicFollowId(Integer chronicFollowId) {
		this.chronicFollowId = chronicFollowId;
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

	@Column(name = "DISEASR_NAME")
	public String getDiseasrName() {
		return this.diseasrName;
	}

	public void setDiseasrName(String diseasrName) {
		this.diseasrName = diseasrName;
	}

	@Column(name = "FOLLOW_PEOPLE", nullable = false)
	public String getFollowPeople() {
		return this.followPeople;
	}

	public void setFollowPeople(String followPeople) {
		this.followPeople = followPeople;
	}

	@Column(name = "FOLLOW_DATE", nullable = false, length = 19)
	public Timestamp getFollowDate() {
		return this.followDate;
	}

	public void setFollowDate(Timestamp followDate) {
		this.followDate = followDate;
	}

	@Column(name = "T_REG_OTH_DIS_ID", nullable = false)
	public Integer getTRegOthDisId() {
		return this.TRegOthDisId;
	}

	public void setTRegOthDisId(Integer TRegOthDisId) {
		this.TRegOthDisId = TRegOthDisId;
	}

	@Column(name = "DISEASES_NAME")
	public String getDiseasesName() {
		return this.diseasesName;
	}

	public void setDiseasesName(String diseasesName) {
		this.diseasesName = diseasesName;
	}

	@Column(name = "SYMPTOM_CHARACTERISTIC", length = 65535)
	public String getSymptomCharacteristic() {
		return this.symptomCharacteristic;
	}

	public void setSymptomCharacteristic(String symptomCharacteristic) {
		this.symptomCharacteristic = symptomCharacteristic;
	}

	@Column(name = "EVERY_TIME")
	public String getEveryTime() {
		return this.everyTime;
	}

	public void setEveryTime(String everyTime) {
		this.everyTime = everyTime;
	}

	@Column(name = "WEEK")
	public String getWeek() {
		return this.week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	@Column(name = "SALT_INTAKE")
	public String getSaltIntake() {
		return this.saltIntake;
	}

	public void setSaltIntake(String saltIntake) {
		this.saltIntake = saltIntake;
	}

	@Column(name = "MEDICAL_STATE")
	public String getMedicalState() {
		return this.medicalState;
	}

	public void setMedicalState(String medicalState) {
		this.medicalState = medicalState;
	}

	@Column(name = "EATING_HABITS")
	public String getEatingHabits() {
		return this.eatingHabits;
	}

	public void setEatingHabits(String eatingHabits) {
		this.eatingHabits = eatingHabits;
	}

	@Column(name = "METAL_STATE")
	public String getMetalState() {
		return this.metalState;
	}

	public void setMetalState(String metalState) {
		this.metalState = metalState;
	}

	@Column(name = "SMOKE")
	public String getSmoke() {
		return this.smoke;
	}

	public void setSmoke(String smoke) {
		this.smoke = smoke;
	}

	@Column(name = "DRINK")
	public String getDrink() {
		return this.drink;
	}

	public void setDrink(String drink) {
		this.drink = drink;
	}

	@Column(name = "FASTING_BLOOD_GLUCOSE", precision = 22, scale = 0)
	public Double getFastingBloodGlucose() {
		return this.fastingBloodGlucose;
	}

	public void setFastingBloodGlucose(Double fastingBloodGlucose) {
		this.fastingBloodGlucose = fastingBloodGlucose;
	}

	@Column(name = "OTHER_INSPECTION", length = 65535)
	public String getOtherInspection() {
		return this.otherInspection;
	}

	public void setOtherInspection(String otherInspection) {
		this.otherInspection = otherInspection;
	}

	@Column(name = "DIET_CONTROL", length = 65535)
	public String getDietControl() {
		return this.dietControl;
	}

	public void setDietControl(String dietControl) {
		this.dietControl = dietControl;
	}

	@Column(name = "OTHER_TRETT", length = 65535)
	public String getOtherTrett() {
		return this.otherTrett;
	}

	public void setOtherTrett(String otherTrett) {
		this.otherTrett = otherTrett;
	}

	@Column(name = "NEXT_APPOINTMENT_DATE", length = 19)
	public Timestamp getNextAppointmentDate() {
		return this.nextAppointmentDate;
	}

	public void setNextAppointmentDate(Timestamp nextAppointmentDate) {
		this.nextAppointmentDate = nextAppointmentDate;
	}

	@Column(name = "FOLLOW_UP_GUIDANCE", length = 65535)
	public String getFollowUpGuidance() {
		return this.followUpGuidance;
	}

	public void setFollowUpGuidance(String followUpGuidance) {
		this.followUpGuidance = followUpGuidance;
	}

	@Column(name = "NOTE", length = 65535)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "FOLLOWED_UP")
	public String getFollowedUp() {
		return this.followedUp;
	}

	public void setFollowedUp(String followedUp) {
		this.followedUp = followedUp;
	}

	@Column(name = "FOLLOW_UP")
	public String getFollowUp() {
		return this.followUp;
	}

	public void setFollowUp(String followUp) {
		this.followUp = followUp;
	}

	@Column(name = "FOLLOW_UP_DATE", length = 19)
	public Timestamp getFollowUpDate() {
		return this.followUpDate;
	}

	public void setFollowUpDate(Timestamp followUpDate) {
		this.followUpDate = followUpDate;
	}

	@Column(name = "BMI", precision = 22, scale = 0)
	public Double getBmi() {
		return this.bmi;
	}

	public void setBmi(Double bmi) {
		this.bmi = bmi;
	}

	@Column(name = "SIGN_ID", nullable = false)
	public Integer getSignId() {
		return this.signId;
	}

	public void setSignId(Integer signId) {
		this.signId = signId;
	}

	@Column(name = "WIGHT", precision = 22, scale = 0)
	public Double getWight() {
		return this.wight;
	}

	public void setWight(Double wight) {
		this.wight = wight;
	}

	@Column(name = "HEIGHT", precision = 22, scale = 0)
	public Double getHeight() {
		return this.height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	@Column(name = "BLOOD_PRESSURE_L", precision = 22, scale = 0)
	public Double getBloodPressureL() {
		return this.bloodPressureL;
	}

	public void setBloodPressureL(Double bloodPressureL) {
		this.bloodPressureL = bloodPressureL;
	}

	@Column(name = "BLOOD_PRESSURE_H", precision = 22, scale = 0)
	public Double getBloodPressureH() {
		return this.bloodPressureH;
	}

	public void setBloodPressureH(Double bloodPressureH) {
		this.bloodPressureH = bloodPressureH;
	}

	@Column(name = "HEART_RATE", length = 11)
	public String getHeartRate() {
		return this.heartRate;
	}

	public void setHeartRate(String heartRate) {
		this.heartRate = heartRate;
	}

	@Column(name = "OTHERS", length = 65535)
	public String getOthers() {
		return this.others;
	}

	public void setOthers(String others) {
		this.others = others;
	}

}