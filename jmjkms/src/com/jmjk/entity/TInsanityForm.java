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
 * TInsanityForm entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_INSANITY_FORM", catalog = "jmjk")
public class TInsanityForm implements java.io.Serializable {

	// Fields

	private Integer insanityId;
	private TChronicDisease TChronicDisease;
	private String guardianName;
	private String patientRelation;
	private String guardianAddress;
	private String guardianPhone;
	private String neighborhoodLinkman;
	private String neighborhoodPhone;
	private Timestamp firstAttackTime;
	private String beforeSymptom;
	private String beforeCureOutpatient;
	private String beforeCureHospital;
	private String recentlyDiagnose;
	private String affirmHospital;
	private Timestamp confirmedDate;
	private String recentlyCureEffect;
	private String influence;
	private String locks;
	private Timestamp filingDate;
	private String bookrunner;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TInsanityForm() {
	}

	/** minimal constructor */
	public TInsanityForm(TChronicDisease TChronicDisease, String guardianName,
			String guardianAddress, String guardianPhone,
			String neighborhoodLinkman, String neighborhoodPhone) {
		this.TChronicDisease = TChronicDisease;
		this.guardianName = guardianName;
		this.guardianAddress = guardianAddress;
		this.guardianPhone = guardianPhone;
		this.neighborhoodLinkman = neighborhoodLinkman;
		this.neighborhoodPhone = neighborhoodPhone;
	}

	/** full constructor */
	public TInsanityForm(TChronicDisease TChronicDisease, String guardianName,
			String patientRelation, String guardianAddress,
			String guardianPhone, String neighborhoodLinkman,
			String neighborhoodPhone, Timestamp firstAttackTime,
			String beforeSymptom, String beforeCureOutpatient,
			String beforeCureHospital, String recentlyDiagnose,
			String affirmHospital, Timestamp confirmedDate,
			String recentlyCureEffect, String influence, String locks,
			Timestamp filingDate, String bookrunner, String one, String two,
			String three, String four, String five) {
		this.TChronicDisease = TChronicDisease;
		this.guardianName = guardianName;
		this.patientRelation = patientRelation;
		this.guardianAddress = guardianAddress;
		this.guardianPhone = guardianPhone;
		this.neighborhoodLinkman = neighborhoodLinkman;
		this.neighborhoodPhone = neighborhoodPhone;
		this.firstAttackTime = firstAttackTime;
		this.beforeSymptom = beforeSymptom;
		this.beforeCureOutpatient = beforeCureOutpatient;
		this.beforeCureHospital = beforeCureHospital;
		this.recentlyDiagnose = recentlyDiagnose;
		this.affirmHospital = affirmHospital;
		this.confirmedDate = confirmedDate;
		this.recentlyCureEffect = recentlyCureEffect;
		this.influence = influence;
		this.locks = locks;
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
	@Column(name = "INSANITY_ID", unique = true, nullable = false)
	public Integer getInsanityId() {
		return this.insanityId;
	}

	public void setInsanityId(Integer insanityId) {
		this.insanityId = insanityId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHRONIC_DISEASE_ID", nullable = false)
	public TChronicDisease getTChronicDisease() {
		return this.TChronicDisease;
	}

	public void setTChronicDisease(TChronicDisease TChronicDisease) {
		this.TChronicDisease = TChronicDisease;
	}

	@Column(name = "GUARDIAN_NAME", nullable = false)
	public String getGuardianName() {
		return this.guardianName;
	}

	public void setGuardianName(String guardianName) {
		this.guardianName = guardianName;
	}

	@Column(name = "PATIENT_RELATION")
	public String getPatientRelation() {
		return this.patientRelation;
	}

	public void setPatientRelation(String patientRelation) {
		this.patientRelation = patientRelation;
	}

	@Column(name = "GUARDIAN_ADDRESS", nullable = false)
	public String getGuardianAddress() {
		return this.guardianAddress;
	}

	public void setGuardianAddress(String guardianAddress) {
		this.guardianAddress = guardianAddress;
	}

	@Column(name = "GUARDIAN_PHONE", nullable = false)
	public String getGuardianPhone() {
		return this.guardianPhone;
	}

	public void setGuardianPhone(String guardianPhone) {
		this.guardianPhone = guardianPhone;
	}

	@Column(name = "NEIGHBORHOOD_LINKMAN", nullable = false)
	public String getNeighborhoodLinkman() {
		return this.neighborhoodLinkman;
	}

	public void setNeighborhoodLinkman(String neighborhoodLinkman) {
		this.neighborhoodLinkman = neighborhoodLinkman;
	}

	@Column(name = "NEIGHBORHOOD_PHONE", nullable = false)
	public String getNeighborhoodPhone() {
		return this.neighborhoodPhone;
	}

	public void setNeighborhoodPhone(String neighborhoodPhone) {
		this.neighborhoodPhone = neighborhoodPhone;
	}

	@Column(name = "FIRST_ATTACK_TIME", length = 19)
	public Timestamp getFirstAttackTime() {
		return this.firstAttackTime;
	}

	public void setFirstAttackTime(Timestamp firstAttackTime) {
		this.firstAttackTime = firstAttackTime;
	}

	@Column(name = "BEFORE_SYMPTOM", length = 65535)
	public String getBeforeSymptom() {
		return this.beforeSymptom;
	}

	public void setBeforeSymptom(String beforeSymptom) {
		this.beforeSymptom = beforeSymptom;
	}

	@Column(name = "BEFORE_CURE_OUTPATIENT", length = 65535)
	public String getBeforeCureOutpatient() {
		return this.beforeCureOutpatient;
	}

	public void setBeforeCureOutpatient(String beforeCureOutpatient) {
		this.beforeCureOutpatient = beforeCureOutpatient;
	}

	@Column(name = "BEFORE_CURE_HOSPITAL", length = 65535)
	public String getBeforeCureHospital() {
		return this.beforeCureHospital;
	}

	public void setBeforeCureHospital(String beforeCureHospital) {
		this.beforeCureHospital = beforeCureHospital;
	}

	@Column(name = "RECENTLY_DIAGNOSE", length = 65535)
	public String getRecentlyDiagnose() {
		return this.recentlyDiagnose;
	}

	public void setRecentlyDiagnose(String recentlyDiagnose) {
		this.recentlyDiagnose = recentlyDiagnose;
	}

	@Column(name = "AFFIRM_HOSPITAL")
	public String getAffirmHospital() {
		return this.affirmHospital;
	}

	public void setAffirmHospital(String affirmHospital) {
		this.affirmHospital = affirmHospital;
	}

	@Column(name = "CONFIRMED_DATE", length = 19)
	public Timestamp getConfirmedDate() {
		return this.confirmedDate;
	}

	public void setConfirmedDate(Timestamp confirmedDate) {
		this.confirmedDate = confirmedDate;
	}

	@Column(name = "RECENTLY_CURE_EFFECT", length = 65535)
	public String getRecentlyCureEffect() {
		return this.recentlyCureEffect;
	}

	public void setRecentlyCureEffect(String recentlyCureEffect) {
		this.recentlyCureEffect = recentlyCureEffect;
	}

	@Column(name = "INFLUENCE", length = 65535)
	public String getInfluence() {
		return this.influence;
	}

	public void setInfluence(String influence) {
		this.influence = influence;
	}

	@Column(name = "LOCKS", length = 65535)
	public String getLocks() {
		return this.locks;
	}

	public void setLocks(String locks) {
		this.locks = locks;
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