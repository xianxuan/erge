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
 * TRegistrationOtherDiseases entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_REGISTRATION_OTHER_DISEASES", catalog = "jmjk")
public class TRegistrationOtherDiseases implements java.io.Serializable {

	// Fields

	private Integer TRegOthDisId;
	private TSign TSign;
	private TChronicFollow TChronicFollow;
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
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private Set<TDrugInformation> TDrugInformations = new HashSet<TDrugInformation>(
			0);

	// Constructors

	/** default constructor */
	public TRegistrationOtherDiseases() {
	}

	/** full constructor */
	public TRegistrationOtherDiseases(TSign TSign,
			TChronicFollow TChronicFollow, String diseasesName,
			String symptomCharacteristic, String everyTime, String week,
			String saltIntake, String medicalState, String eatingHabits,
			String metalState, String smoke, String drink,
			Double fastingBloodGlucose, String otherInspection,
			String dietControl, String otherTrett,
			Timestamp nextAppointmentDate, String followUpGuidance,
			String note, String followedUp, String followUp,
			Timestamp followUpDate, String one, String two, String three,
			String four, String five, Set<TDrugInformation> TDrugInformations) {
		this.TSign = TSign;
		this.TChronicFollow = TChronicFollow;
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
	@Column(name = "T_REG_OTH_DIS_ID", unique = true, nullable = false)
	public Integer getTRegOthDisId() {
		return this.TRegOthDisId;
	}

	public void setTRegOthDisId(Integer TRegOthDisId) {
		this.TRegOthDisId = TRegOthDisId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SIGN_ID")
	public TSign getTSign() {
		return this.TSign;
	}

	public void setTSign(TSign TSign) {
		this.TSign = TSign;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHRONIC_FOLLOW_ID")
	public TChronicFollow getTChronicFollow() {
		return this.TChronicFollow;
	}

	public void setTChronicFollow(TChronicFollow TChronicFollow) {
		this.TChronicFollow = TChronicFollow;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TRegistrationOtherDiseases")
	public Set<TDrugInformation> getTDrugInformations() {
		return this.TDrugInformations;
	}

	public void setTDrugInformations(Set<TDrugInformation> TDrugInformations) {
		this.TDrugInformations = TDrugInformations;
	}

}