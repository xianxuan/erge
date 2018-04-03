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
 * TDiabetsFollow entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_DIABETS_FOLLOW", catalog = "jmjk")
public class TDiabetsFollow implements java.io.Serializable {

	// Fields

	private Integer diabetsFollowId;
	private TLifestyleGuide TLifestyleGuide;
	private TSign TSign;
	private TChronicFollow TChronicFollow;
	private Timestamp date;
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
	private Set<TDrugInformation> TDrugInformations = new HashSet<TDrugInformation>(
			0);

	// Constructors

	/** default constructor */
	public TDiabetsFollow() {
	}

	/** full constructor */
	public TDiabetsFollow(TLifestyleGuide TLifestyleGuide, TSign TSign,
			TChronicFollow TChronicFollow, Timestamp date, String method,
			String doctor, String mainSymptom, Double fastingBloodGlucose,
			Double glycosylatedHemoglobin, Timestamp inspectionDate,
			String otherInspection, String medicationCompliance,
			String adverseDrugReactions, String hypoglycemicReaction,
			String classification, String insulin, String transfer,
			Timestamp nextFollow, String note, String one, String two,
			String three, String four, String five,
			Set<TDrugInformation> TDrugInformations) {
		this.TLifestyleGuide = TLifestyleGuide;
		this.TSign = TSign;
		this.TChronicFollow = TChronicFollow;
		this.date = date;
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
		this.TDrugInformations = TDrugInformations;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "DIABETS_FOLLOW_ID", unique = true, nullable = false)
	public Integer getDiabetsFollowId() {
		return this.diabetsFollowId;
	}

	public void setDiabetsFollowId(Integer diabetsFollowId) {
		this.diabetsFollowId = diabetsFollowId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LIFESTYLE_GUIDE_ID")
	public TLifestyleGuide getTLifestyleGuide() {
		return this.TLifestyleGuide;
	}

	public void setTLifestyleGuide(TLifestyleGuide TLifestyleGuide) {
		this.TLifestyleGuide = TLifestyleGuide;
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

	@Column(name = "DATE", length = 19)
	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TDiabetsFollow")
	public Set<TDrugInformation> getTDrugInformations() {
		return this.TDrugInformations;
	}

	public void setTDrugInformations(Set<TDrugInformation> TDrugInformations) {
		this.TDrugInformations = TDrugInformations;
	}

}