package com.jmjk.entity.view;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VMentalFollow entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "V_MENTAL_FOLLOW", catalog = "jmjk")
public class VMentalFollow implements java.io.Serializable {

	// Fields

	private Integer chronicFollowId;
	private Integer healthFileId;
	private Integer chronicDiseaseId;
	private String followPeople;
	private String diseasrName;
	private Timestamp followDate;
	private String risk;
	private String presentSymptom;
	private String selfKnowledge;
	private Integer mentalFollowId;
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
	private Integer communityHospitalId;
	private Integer staffId;
	private Integer oldStaffHosId;

	// Constructors

	/** default constructor */
	public VMentalFollow() {
	}

	/** minimal constructor */
	public VMentalFollow(Integer chronicFollowId, Integer healthFileId,
			String followPeople, Timestamp followDate, Integer mentalFollowId,
			Integer oldStaffHosId) {
		this.chronicFollowId = chronicFollowId;
		this.healthFileId = healthFileId;
		this.followPeople = followPeople;
		this.followDate = followDate;
		this.mentalFollowId = mentalFollowId;
		this.oldStaffHosId = oldStaffHosId;
	}

	/** full constructor */
	public VMentalFollow(Integer chronicFollowId, Integer healthFileId,
			Integer chronicDiseaseId, String followPeople, String diseasrName,
			Timestamp followDate, String risk, String presentSymptom,
			String selfKnowledge, Integer mentalFollowId, String sleepQuality,
			String dietCondition, String socialFunction, String housework,
			String productiveLaborAndWork, String learningAbility,
			String socialInterpersonal, String influenceSocietyFamily,
			String closeOrLock, String hospitalization, String laboratoryTests,
			String adverseDrugReactions, String medicationAdherence,
			String classification, String recoveryMeasure,
			String treatmentEffect, String guidance, String whetherTheReferral,
			Timestamp nextDate, String followUpDoctor, Timestamp followUpDate,
			Integer communityHospitalId, Integer staffId, Integer oldStaffHosId) {
		this.chronicFollowId = chronicFollowId;
		this.healthFileId = healthFileId;
		this.chronicDiseaseId = chronicDiseaseId;
		this.followPeople = followPeople;
		this.diseasrName = diseasrName;
		this.followDate = followDate;
		this.risk = risk;
		this.presentSymptom = presentSymptom;
		this.selfKnowledge = selfKnowledge;
		this.mentalFollowId = mentalFollowId;
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
		this.communityHospitalId = communityHospitalId;
		this.staffId = staffId;
		this.oldStaffHosId = oldStaffHosId;
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

	@Column(name = "CHRONIC_DISEASE_ID")
	public Integer getChronicDiseaseId() {
		return this.chronicDiseaseId;
	}

	public void setChronicDiseaseId(Integer chronicDiseaseId) {
		this.chronicDiseaseId = chronicDiseaseId;
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

	@Column(name = "FOLLOW_DATE", nullable = false, length = 19)
	public Timestamp getFollowDate() {
		return this.followDate;
	}

	public void setFollowDate(Timestamp followDate) {
		this.followDate = followDate;
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

	@Column(name = "MENTAL_FOLLOW_ID", nullable = false)
	public Integer getMentalFollowId() {
		return this.mentalFollowId;
	}

	public void setMentalFollowId(Integer mentalFollowId) {
		this.mentalFollowId = mentalFollowId;
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

	@Column(name = "COMMUNITY_HOSPITAL_ID")
	public Integer getCommunityHospitalId() {
		return this.communityHospitalId;
	}

	public void setCommunityHospitalId(Integer communityHospitalId) {
		this.communityHospitalId = communityHospitalId;
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

}