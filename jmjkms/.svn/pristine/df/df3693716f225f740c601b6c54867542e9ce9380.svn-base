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
 * THypertensiveFollow entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_HYPERTENSIVE_FOLLOW", catalog = "jmjk")
public class THypertensiveFollow implements java.io.Serializable {

	// Fields

	private Integer hypertensiveFollowId;
	private TLifestyleGuide TLifestyleGuide;
	private TSign TSign;
	private TChronicFollow TChronicFollow;
	private Timestamp date;
	private String way;
	private String doctor;
	private String mainSymptom;
	private String supplementaryExamination;
	private String medicationCompliance;
	private String adverseDrugReactions;
	private String followType;
	private String heartReferral;
	private String dailyTip;
	private Timestamp laterDate;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private Set<TDrugInformation> TDrugInformations = new HashSet<TDrugInformation>(
			0);

	// Constructors

	/** default constructor */
	public THypertensiveFollow() {
	}

	/** full constructor */
	public THypertensiveFollow(TLifestyleGuide TLifestyleGuide, TSign TSign,
			TChronicFollow TChronicFollow, Timestamp date, String way,
			String doctor, String mainSymptom, String supplementaryExamination,
			String medicationCompliance, String adverseDrugReactions,
			String followType, String heartReferral, String dailyTip,
			Timestamp laterDate, String one, String two, String three,
			String four, String five, Set<TDrugInformation> TDrugInformations) {
		this.TLifestyleGuide = TLifestyleGuide;
		this.TSign = TSign;
		this.TChronicFollow = TChronicFollow;
		this.date = date;
		this.way = way;
		this.doctor = doctor;
		this.mainSymptom = mainSymptom;
		this.supplementaryExamination = supplementaryExamination;
		this.medicationCompliance = medicationCompliance;
		this.adverseDrugReactions = adverseDrugReactions;
		this.followType = followType;
		this.heartReferral = heartReferral;
		this.dailyTip = dailyTip;
		this.laterDate = laterDate;
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
	@Column(name = "HYPERTENSIVE_FOLLOW_ID", unique = true, nullable = false)
	public Integer getHypertensiveFollowId() {
		return this.hypertensiveFollowId;
	}

	public void setHypertensiveFollowId(Integer hypertensiveFollowId) {
		this.hypertensiveFollowId = hypertensiveFollowId;
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

	@Column(name = "WAY")
	public String getWay() {
		return this.way;
	}

	public void setWay(String way) {
		this.way = way;
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

	@Column(name = "SUPPLEMENTARY_EXAMINATION", length = 65535)
	public String getSupplementaryExamination() {
		return this.supplementaryExamination;
	}

	public void setSupplementaryExamination(String supplementaryExamination) {
		this.supplementaryExamination = supplementaryExamination;
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

	@Column(name = "FOLLOW_TYPE")
	public String getFollowType() {
		return this.followType;
	}

	public void setFollowType(String followType) {
		this.followType = followType;
	}

	@Column(name = "HEART_REFERRAL", length = 65535)
	public String getHeartReferral() {
		return this.heartReferral;
	}

	public void setHeartReferral(String heartReferral) {
		this.heartReferral = heartReferral;
	}

	@Column(name = "DAILY_TIP", length = 65535)
	public String getDailyTip() {
		return this.dailyTip;
	}

	public void setDailyTip(String dailyTip) {
		this.dailyTip = dailyTip;
	}

	@Column(name = "LATER_DATE", length = 19)
	public Timestamp getLaterDate() {
		return this.laterDate;
	}

	public void setLaterDate(Timestamp laterDate) {
		this.laterDate = laterDate;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "THypertensiveFollow")
	public Set<TDrugInformation> getTDrugInformations() {
		return this.TDrugInformations;
	}

	public void setTDrugInformations(Set<TDrugInformation> TDrugInformations) {
		this.TDrugInformations = TDrugInformations;
	}

}