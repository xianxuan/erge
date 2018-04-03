package com.jmjk.entity.view;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VDiabetsFollow entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "V_DIABETS_FOLLOW", catalog = "jmjk")
public class VDiabetsFollow implements java.io.Serializable {

	// Fields

	private Integer chronicFollowId;
	private Integer chronicDiseaseId;
	private Integer diabetsFollowId;
	private Integer lifestyleGuideId;
	private String method;
	private String doctor;
	private String mainSymptom;
	private Double fastingBloodGlucose;
	private Double glycosylatedHemoglobin;
	private Timestamp inspectionDate;
	private String otherInspection;
	private String medicationCompliance;
	private String adverseDrugReactions;
	private String hypoglycemicReaction;
	private String classification;
	private String insulin;
	private String transfer;
	private Timestamp nextFollow;
	private String note;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private Timestamp date;
	private Integer signId;
	private Integer healthFileId;
	private Integer oldStaffHosId;
	private Integer staffId;
	private Integer communityHospitalId;
	private Timestamp followDate;
	private String followPeople;
	private String diseasrName;
	private Integer dailyCigaretteSmoking;
	private Double dailyDrinking;
	private Double stapleFood;
	private String takenSaltSituation;
	private Integer timesSports;
	private Double exerciseDuration;
	private String psychologicalAdjustment;
	private String treatmentCompliance;
	private Double wight;
	private Double height;
	private Double bmi;
	private Double bloodPressureL;
	private Double bloodPressureH;
	private String heartRate;
	private String others;

	// Constructors

	/** default constructor */
	public VDiabetsFollow() {
	}

	/** minimal constructor */
	public VDiabetsFollow(Integer chronicFollowId, Integer diabetsFollowId,
			Integer healthFileId, Integer oldStaffHosId, Timestamp followDate,
			String followPeople) {
		this.chronicFollowId = chronicFollowId;
		this.diabetsFollowId = diabetsFollowId;
		this.healthFileId = healthFileId;
		this.oldStaffHosId = oldStaffHosId;
		this.followDate = followDate;
		this.followPeople = followPeople;
	}

	/** full constructor */
	public VDiabetsFollow(Integer chronicFollowId, Integer chronicDiseaseId,
			Integer diabetsFollowId, Integer lifestyleGuideId, String method,
			String doctor, String mainSymptom, Double fastingBloodGlucose,
			Double glycosylatedHemoglobin, Timestamp inspectionDate,
			String otherInspection, String medicationCompliance,
			String adverseDrugReactions, String hypoglycemicReaction,
			String classification, String insulin, String transfer,
			Timestamp nextFollow, String note, String one, String two,
			String three, String four, String five, Timestamp date,
			Integer signId, Integer healthFileId, Integer oldStaffHosId,
			Integer staffId, Integer communityHospitalId, Timestamp followDate,
			String followPeople, String diseasrName,
			Integer dailyCigaretteSmoking, Double dailyDrinking,
			Double stapleFood, String takenSaltSituation, Integer timesSports,
			Double exerciseDuration, String psychologicalAdjustment,
			String treatmentCompliance, Double wight, Double height,
			Double bmi, Double bloodPressureL, Double bloodPressureH,
			String heartRate, String others) {
		this.chronicFollowId = chronicFollowId;
		this.chronicDiseaseId = chronicDiseaseId;
		this.diabetsFollowId = diabetsFollowId;
		this.lifestyleGuideId = lifestyleGuideId;
		this.method = method;
		this.doctor = doctor;
		this.mainSymptom = mainSymptom;
		this.fastingBloodGlucose = fastingBloodGlucose;
		this.glycosylatedHemoglobin = glycosylatedHemoglobin;
		this.inspectionDate = inspectionDate;
		this.otherInspection = otherInspection;
		this.medicationCompliance = medicationCompliance;
		this.adverseDrugReactions = adverseDrugReactions;
		this.hypoglycemicReaction = hypoglycemicReaction;
		this.classification = classification;
		this.insulin = insulin;
		this.transfer = transfer;
		this.nextFollow = nextFollow;
		this.note = note;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.date = date;
		this.signId = signId;
		this.healthFileId = healthFileId;
		this.oldStaffHosId = oldStaffHosId;
		this.staffId = staffId;
		this.communityHospitalId = communityHospitalId;
		this.followDate = followDate;
		this.followPeople = followPeople;
		this.diseasrName = diseasrName;
		this.dailyCigaretteSmoking = dailyCigaretteSmoking;
		this.dailyDrinking = dailyDrinking;
		this.stapleFood = stapleFood;
		this.takenSaltSituation = takenSaltSituation;
		this.timesSports = timesSports;
		this.exerciseDuration = exerciseDuration;
		this.psychologicalAdjustment = psychologicalAdjustment;
		this.treatmentCompliance = treatmentCompliance;
		this.wight = wight;
		this.height = height;
		this.bmi = bmi;
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

	@Column(name = "CHRONIC_DISEASE_ID")
	public Integer getChronicDiseaseId() {
		return this.chronicDiseaseId;
	}

	public void setChronicDiseaseId(Integer chronicDiseaseId) {
		this.chronicDiseaseId = chronicDiseaseId;
	}

	@Column(name = "DIABETS_FOLLOW_ID", nullable = false)
	public Integer getDiabetsFollowId() {
		return this.diabetsFollowId;
	}

	public void setDiabetsFollowId(Integer diabetsFollowId) {
		this.diabetsFollowId = diabetsFollowId;
	}

	@Column(name = "LIFESTYLE_GUIDE_ID")
	public Integer getLifestyleGuideId() {
		return this.lifestyleGuideId;
	}

	public void setLifestyleGuideId(Integer lifestyleGuideId) {
		this.lifestyleGuideId = lifestyleGuideId;
	}

	@Column(name = "METHOD")
	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	@Column(name = "DOCTOR")
	public String getDoctor() {
		return this.doctor;
	}

	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}

	@Column(name = "MAIN_SYMPTOM", length = 65535)
	public String getMainSymptom() {
		return this.mainSymptom;
	}

	public void setMainSymptom(String mainSymptom) {
		this.mainSymptom = mainSymptom;
	}

	@Column(name = "FASTING_BLOOD_GLUCOSE", precision = 22, scale = 0)
	public Double getFastingBloodGlucose() {
		return this.fastingBloodGlucose;
	}

	public void setFastingBloodGlucose(Double fastingBloodGlucose) {
		this.fastingBloodGlucose = fastingBloodGlucose;
	}

	@Column(name = "GLYCOSYLATED_HEMOGLOBIN", precision = 22, scale = 0)
	public Double getGlycosylatedHemoglobin() {
		return this.glycosylatedHemoglobin;
	}

	public void setGlycosylatedHemoglobin(Double glycosylatedHemoglobin) {
		this.glycosylatedHemoglobin = glycosylatedHemoglobin;
	}

	@Column(name = "INSPECTION_DATE", length = 19)
	public Timestamp getInspectionDate() {
		return this.inspectionDate;
	}

	public void setInspectionDate(Timestamp inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	@Column(name = "OTHER_INSPECTION", length = 65535)
	public String getOtherInspection() {
		return this.otherInspection;
	}

	public void setOtherInspection(String otherInspection) {
		this.otherInspection = otherInspection;
	}

	@Column(name = "MEDICATION_COMPLIANCE")
	public String getMedicationCompliance() {
		return this.medicationCompliance;
	}

	public void setMedicationCompliance(String medicationCompliance) {
		this.medicationCompliance = medicationCompliance;
	}

	@Column(name = "ADVERSE_DRUG_REACTIONS")
	public String getAdverseDrugReactions() {
		return this.adverseDrugReactions;
	}

	public void setAdverseDrugReactions(String adverseDrugReactions) {
		this.adverseDrugReactions = adverseDrugReactions;
	}

	@Column(name = "HYPOGLYCEMIC_REACTION")
	public String getHypoglycemicReaction() {
		return this.hypoglycemicReaction;
	}

	public void setHypoglycemicReaction(String hypoglycemicReaction) {
		this.hypoglycemicReaction = hypoglycemicReaction;
	}

	@Column(name = "CLASSIFICATION")
	public String getClassification() {
		return this.classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	@Column(name = "INSULIN", length = 65535)
	public String getInsulin() {
		return this.insulin;
	}

	public void setInsulin(String insulin) {
		this.insulin = insulin;
	}

	@Column(name = "TRANSFER", length = 65535)
	public String getTransfer() {
		return this.transfer;
	}

	public void setTransfer(String transfer) {
		this.transfer = transfer;
	}

	@Column(name = "NEXT_FOLLOW", length = 19)
	public Timestamp getNextFollow() {
		return this.nextFollow;
	}

	public void setNextFollow(Timestamp nextFollow) {
		this.nextFollow = nextFollow;
	}

	@Column(name = "NOTE", length = 65535)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
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

	@Column(name = "DATE", length = 19)
	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	@Column(name = "SIGN_ID")
	public Integer getSignId() {
		return this.signId;
	}

	public void setSignId(Integer signId) {
		this.signId = signId;
	}

	@Column(name = "HEALTH_FILE_ID", nullable = false)
	public Integer getHealthFileId() {
		return this.healthFileId;
	}

	public void setHealthFileId(Integer healthFileId) {
		this.healthFileId = healthFileId;
	}

	@Column(name = "OLD_STAFF_HOS_ID", nullable = false)
	public Integer getOldStaffHosId() {
		return this.oldStaffHosId;
	}

	public void setOldStaffHosId(Integer oldStaffHosId) {
		this.oldStaffHosId = oldStaffHosId;
	}

	@Column(name = "STAFF_ID")
	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	@Column(name = "COMMUNITY_HOSPITAL_ID")
	public Integer getCommunityHospitalId() {
		return this.communityHospitalId;
	}

	public void setCommunityHospitalId(Integer communityHospitalId) {
		this.communityHospitalId = communityHospitalId;
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

	@Column(name = "DAILY_CIGARETTE_SMOKING")
	public Integer getDailyCigaretteSmoking() {
		return this.dailyCigaretteSmoking;
	}

	public void setDailyCigaretteSmoking(Integer dailyCigaretteSmoking) {
		this.dailyCigaretteSmoking = dailyCigaretteSmoking;
	}

	@Column(name = "DAILY_DRINKING", precision = 22, scale = 0)
	public Double getDailyDrinking() {
		return this.dailyDrinking;
	}

	public void setDailyDrinking(Double dailyDrinking) {
		this.dailyDrinking = dailyDrinking;
	}

	@Column(name = "STAPLE_FOOD", precision = 22, scale = 0)
	public Double getStapleFood() {
		return this.stapleFood;
	}

	public void setStapleFood(Double stapleFood) {
		this.stapleFood = stapleFood;
	}

	@Column(name = "TAKEN_SALT_SITUATION")
	public String getTakenSaltSituation() {
		return this.takenSaltSituation;
	}

	public void setTakenSaltSituation(String takenSaltSituation) {
		this.takenSaltSituation = takenSaltSituation;
	}

	@Column(name = "TIMES_SPORTS")
	public Integer getTimesSports() {
		return this.timesSports;
	}

	public void setTimesSports(Integer timesSports) {
		this.timesSports = timesSports;
	}

	@Column(name = "EXERCISE_DURATION", precision = 22, scale = 0)
	public Double getExerciseDuration() {
		return this.exerciseDuration;
	}

	public void setExerciseDuration(Double exerciseDuration) {
		this.exerciseDuration = exerciseDuration;
	}

	@Column(name = "PSYCHOLOGICAL_ADJUSTMENT")
	public String getPsychologicalAdjustment() {
		return this.psychologicalAdjustment;
	}

	public void setPsychologicalAdjustment(String psychologicalAdjustment) {
		this.psychologicalAdjustment = psychologicalAdjustment;
	}

	@Column(name = "TREATMENT_COMPLIANCE")
	public String getTreatmentCompliance() {
		return this.treatmentCompliance;
	}

	public void setTreatmentCompliance(String treatmentCompliance) {
		this.treatmentCompliance = treatmentCompliance;
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

	@Column(name = "BMI", precision = 22, scale = 0)
	public Double getBmi() {
		return this.bmi;
	}

	public void setBmi(Double bmi) {
		this.bmi = bmi;
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