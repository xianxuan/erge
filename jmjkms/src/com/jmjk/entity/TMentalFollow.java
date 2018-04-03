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
 * TMentalFollow entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_MENTAL_FOLLOW", catalog = "jmjk")
public class TMentalFollow implements java.io.Serializable {

	// Fields

	private Integer mentalFollowId;
	private TChronicFollow TChronicFollow;
	private String risk;
	private String presentSymptom;
	private String selfKnowledge;
	private String sleepQuality;
	private String dietCondition;
	private String socialFunction;
	private String housework;
	private String productiveLaborAndWork;
	private String learningAbility;
	private String socialInterpersonal;
	private String influenceSocietyFamily;
	private String closeOrLock;
	private String hospitalization;
	private String laboratoryTests;
	private String adverseDrugReactions;
	private String medicationAdherence;
	private String classification;
	private String recoveryMeasure;
	private String treatmentEffect;
	private String guidance;
	private String whetherTheReferral;
	private Timestamp nextDate;
	private String followUpDoctor;
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
	public TMentalFollow() {
	}

	/** full constructor */
	public TMentalFollow(TChronicFollow TChronicFollow, String risk,
			String presentSymptom, String selfKnowledge, String sleepQuality,
			String dietCondition, String socialFunction, String housework,
			String productiveLaborAndWork, String learningAbility,
			String socialInterpersonal, String influenceSocietyFamily,
			String closeOrLock, String hospitalization, String laboratoryTests,
			String adverseDrugReactions, String medicationAdherence,
			String classification, String recoveryMeasure,
			String treatmentEffect, String guidance, String whetherTheReferral,
			Timestamp nextDate, String followUpDoctor, Timestamp followUpDate,
			String one, String two, String three, String four, String five,
			Set<TDrugInformation> TDrugInformations) {
		this.TChronicFollow = TChronicFollow;
		this.risk = risk;
		this.presentSymptom = presentSymptom;
		this.selfKnowledge = selfKnowledge;
		this.sleepQuality = sleepQuality;
		this.dietCondition = dietCondition;
		this.socialFunction = socialFunction;
		this.housework = housework;
		this.productiveLaborAndWork = productiveLaborAndWork;
		this.learningAbility = learningAbility;
		this.socialInterpersonal = socialInterpersonal;
		this.influenceSocietyFamily = influenceSocietyFamily;
		this.closeOrLock = closeOrLock;
		this.hospitalization = hospitalization;
		this.laboratoryTests = laboratoryTests;
		this.adverseDrugReactions = adverseDrugReactions;
		this.medicationAdherence = medicationAdherence;
		this.classification = classification;
		this.recoveryMeasure = recoveryMeasure;
		this.treatmentEffect = treatmentEffect;
		this.guidance = guidance;
		this.whetherTheReferral = whetherTheReferral;
		this.nextDate = nextDate;
		this.followUpDoctor = followUpDoctor;
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
	@Column(name = "MENTAL_FOLLOW_ID", unique = true, nullable = false)
	public Integer getMentalFollowId() {
		return this.mentalFollowId;
	}

	public void setMentalFollowId(Integer mentalFollowId) {
		this.mentalFollowId = mentalFollowId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHRONIC_FOLLOW_ID")
	public TChronicFollow getTChronicFollow() {
		return this.TChronicFollow;
	}

	public void setTChronicFollow(TChronicFollow TChronicFollow) {
		this.TChronicFollow = TChronicFollow;
	}

	@Column(name = "RISK")
	public String getRisk() {
		return this.risk;
	}

	public void setRisk(String risk) {
		this.risk = risk;
	}

	@Column(name = "PRESENT_SYMPTOM")
	public String getPresentSymptom() {
		return this.presentSymptom;
	}

	public void setPresentSymptom(String presentSymptom) {
		this.presentSymptom = presentSymptom;
	}

	@Column(name = "SELF_KNOWLEDGE")
	public String getSelfKnowledge() {
		return this.selfKnowledge;
	}

	public void setSelfKnowledge(String selfKnowledge) {
		this.selfKnowledge = selfKnowledge;
	}

	@Column(name = "SLEEP_QUALITY")
	public String getSleepQuality() {
		return this.sleepQuality;
	}

	public void setSleepQuality(String sleepQuality) {
		this.sleepQuality = sleepQuality;
	}

	@Column(name = "DIET_CONDITION")
	public String getDietCondition() {
		return this.dietCondition;
	}

	public void setDietCondition(String dietCondition) {
		this.dietCondition = dietCondition;
	}

	@Column(name = "SOCIAL_FUNCTION")
	public String getSocialFunction() {
		return this.socialFunction;
	}

	public void setSocialFunction(String socialFunction) {
		this.socialFunction = socialFunction;
	}

	@Column(name = "HOUSEWORK")
	public String getHousework() {
		return this.housework;
	}

	public void setHousework(String housework) {
		this.housework = housework;
	}

	@Column(name = "PRODUCTIVE_LABOR_AND_WORK")
	public String getProductiveLaborAndWork() {
		return this.productiveLaborAndWork;
	}

	public void setProductiveLaborAndWork(String productiveLaborAndWork) {
		this.productiveLaborAndWork = productiveLaborAndWork;
	}

	@Column(name = "LEARNING_ABILITY")
	public String getLearningAbility() {
		return this.learningAbility;
	}

	public void setLearningAbility(String learningAbility) {
		this.learningAbility = learningAbility;
	}

	@Column(name = "SOCIAL_INTERPERSONAL")
	public String getSocialInterpersonal() {
		return this.socialInterpersonal;
	}

	public void setSocialInterpersonal(String socialInterpersonal) {
		this.socialInterpersonal = socialInterpersonal;
	}

	@Column(name = "INFLUENCE_SOCIETY_FAMILY")
	public String getInfluenceSocietyFamily() {
		return this.influenceSocietyFamily;
	}

	public void setInfluenceSocietyFamily(String influenceSocietyFamily) {
		this.influenceSocietyFamily = influenceSocietyFamily;
	}

	@Column(name = "CLOSE_OR_LOCK", length = 65535)
	public String getCloseOrLock() {
		return this.closeOrLock;
	}

	public void setCloseOrLock(String closeOrLock) {
		this.closeOrLock = closeOrLock;
	}

	@Column(name = "HOSPITALIZATION", length = 65535)
	public String getHospitalization() {
		return this.hospitalization;
	}

	public void setHospitalization(String hospitalization) {
		this.hospitalization = hospitalization;
	}

	@Column(name = "LABORATORY_TESTS", length = 65535)
	public String getLaboratoryTests() {
		return this.laboratoryTests;
	}

	public void setLaboratoryTests(String laboratoryTests) {
		this.laboratoryTests = laboratoryTests;
	}

	@Column(name = "ADVERSE_DRUG_REACTIONS", length = 65535)
	public String getAdverseDrugReactions() {
		return this.adverseDrugReactions;
	}

	public void setAdverseDrugReactions(String adverseDrugReactions) {
		this.adverseDrugReactions = adverseDrugReactions;
	}

	@Column(name = "MEDICATION_ADHERENCE")
	public String getMedicationAdherence() {
		return this.medicationAdherence;
	}

	public void setMedicationAdherence(String medicationAdherence) {
		this.medicationAdherence = medicationAdherence;
	}

	@Column(name = "CLASSIFICATION")
	public String getClassification() {
		return this.classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	@Column(name = "RECOVERY_MEASURE", length = 65535)
	public String getRecoveryMeasure() {
		return this.recoveryMeasure;
	}

	public void setRecoveryMeasure(String recoveryMeasure) {
		this.recoveryMeasure = recoveryMeasure;
	}

	@Column(name = "TREATMENT_EFFECT", length = 65535)
	public String getTreatmentEffect() {
		return this.treatmentEffect;
	}

	public void setTreatmentEffect(String treatmentEffect) {
		this.treatmentEffect = treatmentEffect;
	}

	@Column(name = "GUIDANCE", length = 65535)
	public String getGuidance() {
		return this.guidance;
	}

	public void setGuidance(String guidance) {
		this.guidance = guidance;
	}

	@Column(name = "WHETHER_THE_REFERRAL")
	public String getWhetherTheReferral() {
		return this.whetherTheReferral;
	}

	public void setWhetherTheReferral(String whetherTheReferral) {
		this.whetherTheReferral = whetherTheReferral;
	}

	@Column(name = "NEXT_DATE", length = 19)
	public Timestamp getNextDate() {
		return this.nextDate;
	}

	public void setNextDate(Timestamp nextDate) {
		this.nextDate = nextDate;
	}

	@Column(name = "FOLLOW_UP_DOCTOR")
	public String getFollowUpDoctor() {
		return this.followUpDoctor;
	}

	public void setFollowUpDoctor(String followUpDoctor) {
		this.followUpDoctor = followUpDoctor;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TMentalFollow")
	public Set<TDrugInformation> getTDrugInformations() {
		return this.TDrugInformations;
	}

	public void setTDrugInformations(Set<TDrugInformation> TDrugInformations) {
		this.TDrugInformations = TDrugInformations;
	}

}