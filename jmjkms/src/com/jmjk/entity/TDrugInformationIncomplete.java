package com.jmjk.entity;
// default package

import javax.persistence.CascadeType;
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
@Table(name = "T_DRUG_INFORMATION_INCOMPLETE", catalog = "jmjk")
public class TDrugInformationIncomplete implements java.io.Serializable {

	// Fields

	private Integer drugInformationId;
	private TIncompleteRecord2 TIncompleteRecord2;
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
	public TDrugInformationIncomplete() {
	}

	/** full constructor */
	public TDrugInformationIncomplete(Integer drugInformationId,
			com.jmjk.entity.TIncompleteRecord2 tIncompleteRecord2,
			String drugName, Integer timesTakeMedicineDaily, String drugPath,
			Double dailyDose, String adverseReactions, String one, String two,
			String three, String four, String five) {
		super();
		this.drugInformationId = drugInformationId;
		TIncompleteRecord2 = tIncompleteRecord2;
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

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "INCOMPLETE_RECORD_ID", nullable = false)
	public TIncompleteRecord2 getTIncompleteRecord2() {
		return this.TIncompleteRecord2;
	}

	public void setTIncompleteRecord2(TIncompleteRecord2 TIncompleteRecord2) {
		this.TIncompleteRecord2 = TIncompleteRecord2;
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