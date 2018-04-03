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
 * TDisabilityObstacle entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_DISABILITY_OBSTACLE", catalog = "jmjk")
public class TDisabilityObstacle implements java.io.Serializable {

	// Fields

	private Integer disabilityObstacleId;
	private TChronicDisease TChronicDisease;
	private String residualVisionGrading;
	private String visionDisabilityReason;
	private String visualImpairment;
	private String gradingOfAuditusDeformity;
	private String theHearingDisabilityReason;
	private String hearingDisorder;
	private Boolean hearingAid;
	private String speechResidualClassification;
	private String speechDisabilityReason;
	private String speechDisorder;
	private String intelligenceResidualClassification;
	private String intellectualDisabilityReason;
	private String dysgnosia;
	private String bodyResidualClassification;
	private String physicalCauses;
	private String mutilation;
	private String bodyResidualClassificatio;
	private String psychiatricClassification;
	private String causesMentalIllness;
	private String psychogeny;
	private String psychiatricDiagnosis;
	private String diagnoseOrganization;
	private Boolean whetheDisability;
	private Boolean whetheGoRecovery;
	private String recoveryOrganization;
	private String noRecoverReason;
	private String remark;
	private Timestamp signatureDate;
	private Timestamp checkDate;
	private Timestamp fileDate;
	private String fileName;
	private String respondent;
	private String checker;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TDisabilityObstacle() {
	}

	/** minimal constructor */
	public TDisabilityObstacle(String diagnoseOrganization,
			Timestamp signatureDate, Timestamp checkDate, String respondent,
			String checker) {
		this.diagnoseOrganization = diagnoseOrganization;
		this.signatureDate = signatureDate;
		this.checkDate = checkDate;
		this.respondent = respondent;
		this.checker = checker;
	}

	/** full constructor */
	public TDisabilityObstacle(TChronicDisease TChronicDisease,
			String residualVisionGrading, String visionDisabilityReason,
			String visualImpairment, String gradingOfAuditusDeformity,
			String theHearingDisabilityReason, String hearingDisorder,
			Boolean hearingAid, String speechResidualClassification,
			String speechDisabilityReason, String speechDisorder,
			String intelligenceResidualClassification,
			String intellectualDisabilityReason, String dysgnosia,
			String bodyResidualClassification, String physicalCauses,
			String mutilation, String bodyResidualClassificatio,
			String psychiatricClassification, String causesMentalIllness,
			String psychogeny, String psychiatricDiagnosis,
			String diagnoseOrganization, Boolean whetheDisability,
			Boolean whetheGoRecovery, String recoveryOrganization,
			String noRecoverReason, String remark, Timestamp signatureDate,
			Timestamp checkDate, Timestamp fileDate, String fileName,
			String respondent, String checker, String one, String two,
			String three, String four, String five) {
		this.TChronicDisease = TChronicDisease;
		this.residualVisionGrading = residualVisionGrading;
		this.visionDisabilityReason = visionDisabilityReason;
		this.visualImpairment = visualImpairment;
		this.gradingOfAuditusDeformity = gradingOfAuditusDeformity;
		this.theHearingDisabilityReason = theHearingDisabilityReason;
		this.hearingDisorder = hearingDisorder;
		this.hearingAid = hearingAid;
		this.speechResidualClassification = speechResidualClassification;
		this.speechDisabilityReason = speechDisabilityReason;
		this.speechDisorder = speechDisorder;
		this.intelligenceResidualClassification = intelligenceResidualClassification;
		this.intellectualDisabilityReason = intellectualDisabilityReason;
		this.dysgnosia = dysgnosia;
		this.bodyResidualClassification = bodyResidualClassification;
		this.physicalCauses = physicalCauses;
		this.mutilation = mutilation;
		this.bodyResidualClassificatio = bodyResidualClassificatio;
		this.psychiatricClassification = psychiatricClassification;
		this.causesMentalIllness = causesMentalIllness;
		this.psychogeny = psychogeny;
		this.psychiatricDiagnosis = psychiatricDiagnosis;
		this.diagnoseOrganization = diagnoseOrganization;
		this.whetheDisability = whetheDisability;
		this.whetheGoRecovery = whetheGoRecovery;
		this.recoveryOrganization = recoveryOrganization;
		this.noRecoverReason = noRecoverReason;
		this.remark = remark;
		this.signatureDate = signatureDate;
		this.checkDate = checkDate;
		this.fileDate = fileDate;
		this.fileName = fileName;
		this.respondent = respondent;
		this.checker = checker;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "DISABILITY_OBSTACLE_ID", unique = true, nullable = false)
	public Integer getDisabilityObstacleId() {
		return this.disabilityObstacleId;
	}

	public void setDisabilityObstacleId(Integer disabilityObstacleId) {
		this.disabilityObstacleId = disabilityObstacleId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHRONIC_DISEASE_ID")
	public TChronicDisease getTChronicDisease() {
		return this.TChronicDisease;
	}

	public void setTChronicDisease(TChronicDisease TChronicDisease) {
		this.TChronicDisease = TChronicDisease;
	}

	@Column(name = "RESIDUAL_VISION_GRADING")
	public String getResidualVisionGrading() {
		return this.residualVisionGrading;
	}

	public void setResidualVisionGrading(String residualVisionGrading) {
		this.residualVisionGrading = residualVisionGrading;
	}

	@Column(name = "VISION_DISABILITY_REASON", length = 65535)
	public String getVisionDisabilityReason() {
		return this.visionDisabilityReason;
	}

	public void setVisionDisabilityReason(String visionDisabilityReason) {
		this.visionDisabilityReason = visionDisabilityReason;
	}

	@Column(name = "VISUAL_IMPAIRMENT")
	public String getVisualImpairment() {
		return this.visualImpairment;
	}

	public void setVisualImpairment(String visualImpairment) {
		this.visualImpairment = visualImpairment;
	}

	@Column(name = "GRADING_OF_AUDITUS_DEFORMITY")
	public String getGradingOfAuditusDeformity() {
		return this.gradingOfAuditusDeformity;
	}

	public void setGradingOfAuditusDeformity(String gradingOfAuditusDeformity) {
		this.gradingOfAuditusDeformity = gradingOfAuditusDeformity;
	}

	@Column(name = "THE_HEARING_DISABILITY_REASON", length = 65535)
	public String getTheHearingDisabilityReason() {
		return this.theHearingDisabilityReason;
	}

	public void setTheHearingDisabilityReason(String theHearingDisabilityReason) {
		this.theHearingDisabilityReason = theHearingDisabilityReason;
	}

	@Column(name = "HEARING_DISORDER")
	public String getHearingDisorder() {
		return this.hearingDisorder;
	}

	public void setHearingDisorder(String hearingDisorder) {
		this.hearingDisorder = hearingDisorder;
	}

	@Column(name = "HEARING_AID")
	public Boolean getHearingAid() {
		return this.hearingAid;
	}

	public void setHearingAid(Boolean hearingAid) {
		this.hearingAid = hearingAid;
	}

	@Column(name = "SPEECH_RESIDUAL_CLASSIFICATION")
	public String getSpeechResidualClassification() {
		return this.speechResidualClassification;
	}

	public void setSpeechResidualClassification(
			String speechResidualClassification) {
		this.speechResidualClassification = speechResidualClassification;
	}

	@Column(name = "SPEECH_DISABILITY_REASON", length = 65535)
	public String getSpeechDisabilityReason() {
		return this.speechDisabilityReason;
	}

	public void setSpeechDisabilityReason(String speechDisabilityReason) {
		this.speechDisabilityReason = speechDisabilityReason;
	}

	@Column(name = "SPEECH_DISORDER")
	public String getSpeechDisorder() {
		return this.speechDisorder;
	}

	public void setSpeechDisorder(String speechDisorder) {
		this.speechDisorder = speechDisorder;
	}

	@Column(name = "INTELLIGENCE_RESIDUAL_CLASSIFICATION")
	public String getIntelligenceResidualClassification() {
		return this.intelligenceResidualClassification;
	}

	public void setIntelligenceResidualClassification(
			String intelligenceResidualClassification) {
		this.intelligenceResidualClassification = intelligenceResidualClassification;
	}

	@Column(name = "INTELLECTUAL_DISABILITY_REASON", length = 65535)
	public String getIntellectualDisabilityReason() {
		return this.intellectualDisabilityReason;
	}

	public void setIntellectualDisabilityReason(
			String intellectualDisabilityReason) {
		this.intellectualDisabilityReason = intellectualDisabilityReason;
	}

	@Column(name = "DYSGNOSIA")
	public String getDysgnosia() {
		return this.dysgnosia;
	}

	public void setDysgnosia(String dysgnosia) {
		this.dysgnosia = dysgnosia;
	}

	@Column(name = "BODY_RESIDUAL_CLASSIFICATION")
	public String getBodyResidualClassification() {
		return this.bodyResidualClassification;
	}

	public void setBodyResidualClassification(String bodyResidualClassification) {
		this.bodyResidualClassification = bodyResidualClassification;
	}

	@Column(name = "PHYSICAL_CAUSES", length = 65535)
	public String getPhysicalCauses() {
		return this.physicalCauses;
	}

	public void setPhysicalCauses(String physicalCauses) {
		this.physicalCauses = physicalCauses;
	}

	@Column(name = "MUTILATION")
	public String getMutilation() {
		return this.mutilation;
	}

	public void setMutilation(String mutilation) {
		this.mutilation = mutilation;
	}

	@Column(name = "BODY_RESIDUAL_CLASSIFICATIO")
	public String getBodyResidualClassificatio() {
		return this.bodyResidualClassificatio;
	}

	public void setBodyResidualClassificatio(String bodyResidualClassificatio) {
		this.bodyResidualClassificatio = bodyResidualClassificatio;
	}

	@Column(name = "PSYCHIATRIC_CLASSIFICATION")
	public String getPsychiatricClassification() {
		return this.psychiatricClassification;
	}

	public void setPsychiatricClassification(String psychiatricClassification) {
		this.psychiatricClassification = psychiatricClassification;
	}

	@Column(name = "CAUSES_MENTAL_ILLNESS", length = 65535)
	public String getCausesMentalIllness() {
		return this.causesMentalIllness;
	}

	public void setCausesMentalIllness(String causesMentalIllness) {
		this.causesMentalIllness = causesMentalIllness;
	}

	@Column(name = "PSYCHOGENY")
	public String getPsychogeny() {
		return this.psychogeny;
	}

	public void setPsychogeny(String psychogeny) {
		this.psychogeny = psychogeny;
	}

	@Column(name = "PSYCHIATRIC_DIAGNOSIS")
	public String getPsychiatricDiagnosis() {
		return this.psychiatricDiagnosis;
	}

	public void setPsychiatricDiagnosis(String psychiatricDiagnosis) {
		this.psychiatricDiagnosis = psychiatricDiagnosis;
	}

	@Column(name = "DIAGNOSE_ORGANIZATION", nullable = false)
	public String getDiagnoseOrganization() {
		return this.diagnoseOrganization;
	}

	public void setDiagnoseOrganization(String diagnoseOrganization) {
		this.diagnoseOrganization = diagnoseOrganization;
	}

	@Column(name = "WHETHE_DISABILITY")
	public Boolean getWhetheDisability() {
		return this.whetheDisability;
	}

	public void setWhetheDisability(Boolean whetheDisability) {
		this.whetheDisability = whetheDisability;
	}

	@Column(name = "WHETHE_GO_RECOVERY")
	public Boolean getWhetheGoRecovery() {
		return this.whetheGoRecovery;
	}

	public void setWhetheGoRecovery(Boolean whetheGoRecovery) {
		this.whetheGoRecovery = whetheGoRecovery;
	}

	@Column(name = "RECOVERY_ORGANIZATION", length = 65535)
	public String getRecoveryOrganization() {
		return this.recoveryOrganization;
	}

	public void setRecoveryOrganization(String recoveryOrganization) {
		this.recoveryOrganization = recoveryOrganization;
	}

	@Column(name = "NO_RECOVER_REASON")
	public String getNoRecoverReason() {
		return this.noRecoverReason;
	}

	public void setNoRecoverReason(String noRecoverReason) {
		this.noRecoverReason = noRecoverReason;
	}

	@Column(name = "REMARK", length = 65535)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "SIGNATURE_DATE", nullable = false, length = 19)
	public Timestamp getSignatureDate() {
		return this.signatureDate;
	}

	public void setSignatureDate(Timestamp signatureDate) {
		this.signatureDate = signatureDate;
	}

	@Column(name = "CHECK_DATE", nullable = false, length = 19)
	public Timestamp getCheckDate() {
		return this.checkDate;
	}

	public void setCheckDate(Timestamp checkDate) {
		this.checkDate = checkDate;
	}

	@Column(name = "FILE_DATE", length = 19)
	public Timestamp getFileDate() {
		return this.fileDate;
	}

	public void setFileDate(Timestamp fileDate) {
		this.fileDate = fileDate;
	}

	@Column(name = "FILE_NAME")
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "RESPONDENT", nullable = false)
	public String getRespondent() {
		return this.respondent;
	}

	public void setRespondent(String respondent) {
		this.respondent = respondent;
	}

	@Column(name = "CHECKER", nullable = false)
	public String getChecker() {
		return this.checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
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