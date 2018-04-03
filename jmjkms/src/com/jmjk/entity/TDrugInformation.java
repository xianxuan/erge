package com.jmjk.entity;
// default package

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
 * TDrugInformation entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_DRUG_INFORMATION", catalog = "jmjk")
public class TDrugInformation implements java.io.Serializable {

	// Fields

	private Integer drugInformationId;
	private TMentalFollow TMentalFollow;
	private THypertensiveFollow THypertensiveFollow;
	private TCoronaryHeartDisease TCoronaryHeartDisease;
	private TRegistrationOtherDiseases TRegistrationOtherDiseases;
	private TFollowUpCardiovascular TFollowUpCardiovascular;
	private TDiabetsFollow TDiabetsFollow;
	private String drugName;
	private Integer timesTakeMedicineDaily;
	private String drugPath;
	private Double dailyDose;
	private String adverseReactions;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TDrugInformation() {
	}

	/** full constructor */
	public TDrugInformation(TMentalFollow TMentalFollow,
			THypertensiveFollow THypertensiveFollow,
			TCoronaryHeartDisease TCoronaryHeartDisease,
			TRegistrationOtherDiseases TRegistrationOtherDiseases,
			TFollowUpCardiovascular TFollowUpCardiovascular,
			TDiabetsFollow TDiabetsFollow, String drugName,
			Integer timesTakeMedicineDaily, String drugPath, Double dailyDose,
			String adverseReactions, String one, String two, String three,
			String four, String five) {
		this.TMentalFollow = TMentalFollow;
		this.THypertensiveFollow = THypertensiveFollow;
		this.TCoronaryHeartDisease = TCoronaryHeartDisease;
		this.TRegistrationOtherDiseases = TRegistrationOtherDiseases;
		this.TFollowUpCardiovascular = TFollowUpCardiovascular;
		this.TDiabetsFollow = TDiabetsFollow;
		this.drugName = drugName;
		this.timesTakeMedicineDaily = timesTakeMedicineDaily;
		this.drugPath = drugPath;
		this.dailyDose = dailyDose;
		this.adverseReactions = adverseReactions;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "DRUG_INFORMATION_ID", unique = true, nullable = false)
	public Integer getDrugInformationId() {
		return this.drugInformationId;
	}

	public void setDrugInformationId(Integer drugInformationId) {
		this.drugInformationId = drugInformationId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MENTAL_FOLLOW_ID")
	public TMentalFollow getTMentalFollow() {
		return this.TMentalFollow;
	}

	public void setTMentalFollow(TMentalFollow TMentalFollow) {
		this.TMentalFollow = TMentalFollow;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HYPERTENSIVE_FOLLOW_ID")
	public THypertensiveFollow getTHypertensiveFollow() {
		return this.THypertensiveFollow;
	}

	public void setTHypertensiveFollow(THypertensiveFollow THypertensiveFollow) {
		this.THypertensiveFollow = THypertensiveFollow;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CORONARY_HEART_DISEASE_ID")
	public TCoronaryHeartDisease getTCoronaryHeartDisease() {
		return this.TCoronaryHeartDisease;
	}

	public void setTCoronaryHeartDisease(
			TCoronaryHeartDisease TCoronaryHeartDisease) {
		this.TCoronaryHeartDisease = TCoronaryHeartDisease;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "T_REG_OTH_DIS_ID")
	public TRegistrationOtherDiseases getTRegistrationOtherDiseases() {
		return this.TRegistrationOtherDiseases;
	}

	public void setTRegistrationOtherDiseases(
			TRegistrationOtherDiseases TRegistrationOtherDiseases) {
		this.TRegistrationOtherDiseases = TRegistrationOtherDiseases;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "FOLLOW_UP_CARDIOVASCULAR_ID")
	public TFollowUpCardiovascular getTFollowUpCardiovascular() {
		return this.TFollowUpCardiovascular;
	}

	public void setTFollowUpCardiovascular(
			TFollowUpCardiovascular TFollowUpCardiovascular) {
		this.TFollowUpCardiovascular = TFollowUpCardiovascular;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DIABETS_FOLLOW_ID")
	public TDiabetsFollow getTDiabetsFollow() {
		return this.TDiabetsFollow;
	}

	public void setTDiabetsFollow(TDiabetsFollow TDiabetsFollow) {
		this.TDiabetsFollow = TDiabetsFollow;
	}

	@Column(name = "DRUG_NAME")
	public String getDrugName() {
		return this.drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	@Column(name = "TIMES_TAKE_MEDICINE_DAILY")
	public Integer getTimesTakeMedicineDaily() {
		return this.timesTakeMedicineDaily;
	}

	public void setTimesTakeMedicineDaily(Integer timesTakeMedicineDaily) {
		this.timesTakeMedicineDaily = timesTakeMedicineDaily;
	}

	@Column(name = "DRUG_PATH")
	public String getDrugPath() {
		return this.drugPath;
	}

	public void setDrugPath(String drugPath) {
		this.drugPath = drugPath;
	}

	@Column(name = "DAILY_DOSE", precision = 22, scale = 0)
	public Double getDailyDose() {
		return this.dailyDose;
	}

	public void setDailyDose(Double dailyDose) {
		this.dailyDose = dailyDose;
	}

	@Column(name = "ADVERSE_REACTIONS", length = 65535)
	public String getAdverseReactions() {
		return this.adverseReactions;
	}

	public void setAdverseReactions(String adverseReactions) {
		this.adverseReactions = adverseReactions;
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