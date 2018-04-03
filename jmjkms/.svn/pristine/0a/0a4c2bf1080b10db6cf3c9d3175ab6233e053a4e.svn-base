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
 * TDiabete entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_DIABETE", catalog = "jmjk")
public class TDiabete implements java.io.Serializable {

	// Fields

	private Integer diabeteId;
	private TLifeStyle TLifeStyle;
	private TAuxiliaryExamination TAuxiliaryExamination;
	private TChronicDisease TChronicDisease;
	private TGeneralCondition TGeneralCondition;
	private Timestamp initialDiagnosisTime;
	private String coOfDia;
	private String typOfDia;
	private Double costPerMonth;
	private String mainSyptm;
	private String diaCompl;
	private String diaHistory;
	private String faMem;
	private Timestamp filingDate;
	private String bookrunner;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TDiabete() {
	}

	/** minimal constructor */
	public TDiabete(TLifeStyle TLifeStyle,
			TAuxiliaryExamination TAuxiliaryExamination,
			TChronicDisease TChronicDisease,
			TGeneralCondition TGeneralCondition, String typOfDia) {
		this.TLifeStyle = TLifeStyle;
		this.TAuxiliaryExamination = TAuxiliaryExamination;
		this.TChronicDisease = TChronicDisease;
		this.TGeneralCondition = TGeneralCondition;
		this.typOfDia = typOfDia;
	}

	/** full constructor */
	public TDiabete(TLifeStyle TLifeStyle,
			TAuxiliaryExamination TAuxiliaryExamination,
			TChronicDisease TChronicDisease,
			TGeneralCondition TGeneralCondition,
			Timestamp initialDiagnosisTime, String coOfDia, String typOfDia,
			Double costPerMonth, String mainSyptm, String diaCompl,
			String diaHistory, String faMem, Timestamp filingDate,
			String bookrunner, String one, String two, String three,
			String four, String five) {
		this.TLifeStyle = TLifeStyle;
		this.TAuxiliaryExamination = TAuxiliaryExamination;
		this.TChronicDisease = TChronicDisease;
		this.TGeneralCondition = TGeneralCondition;
		this.initialDiagnosisTime = initialDiagnosisTime;
		this.coOfDia = coOfDia;
		this.typOfDia = typOfDia;
		this.costPerMonth = costPerMonth;
		this.mainSyptm = mainSyptm;
		this.diaCompl = diaCompl;
		this.diaHistory = diaHistory;
		this.faMem = faMem;
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
	@Column(name = "DIABETE_ID", unique = true, nullable = false)
	public Integer getDiabeteId() {
		return this.diabeteId;
	}

	public void setDiabeteId(Integer diabeteId) {
		this.diabeteId = diabeteId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LIFE_ID", nullable = false)
	public TLifeStyle getTLifeStyle() {
		return this.TLifeStyle;
	}

	public void setTLifeStyle(TLifeStyle TLifeStyle) {
		this.TLifeStyle = TLifeStyle;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AUXILIARY_EXAMINATION_ID", nullable = false)
	public TAuxiliaryExamination getTAuxiliaryExamination() {
		return this.TAuxiliaryExamination;
	}

	public void setTAuxiliaryExamination(
			TAuxiliaryExamination TAuxiliaryExamination) {
		this.TAuxiliaryExamination = TAuxiliaryExamination;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHRONIC_DISEASE_ID", nullable = false)
	public TChronicDisease getTChronicDisease() {
		return this.TChronicDisease;
	}

	public void setTChronicDisease(TChronicDisease TChronicDisease) {
		this.TChronicDisease = TChronicDisease;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GENERAL_CONDITION_ID", nullable = false)
	public TGeneralCondition getTGeneralCondition() {
		return this.TGeneralCondition;
	}

	public void setTGeneralCondition(TGeneralCondition TGeneralCondition) {
		this.TGeneralCondition = TGeneralCondition;
	}

	@Column(name = "INITIAL_DIAGNOSIS_TIME", length = 19)
	public Timestamp getInitialDiagnosisTime() {
		return this.initialDiagnosisTime;
	}

	public void setInitialDiagnosisTime(Timestamp initialDiagnosisTime) {
		this.initialDiagnosisTime = initialDiagnosisTime;
	}

	@Column(name = "CO_OF_DIA")
	public String getCoOfDia() {
		return this.coOfDia;
	}

	public void setCoOfDia(String coOfDia) {
		this.coOfDia = coOfDia;
	}

	@Column(name = "TYP_OF_DIA", nullable = false)
	public String getTypOfDia() {
		return this.typOfDia;
	}

	public void setTypOfDia(String typOfDia) {
		this.typOfDia = typOfDia;
	}

	@Column(name = "COST_PER_MONTH", precision = 22, scale = 0)
	public Double getCostPerMonth() {
		return this.costPerMonth;
	}

	public void setCostPerMonth(Double costPerMonth) {
		this.costPerMonth = costPerMonth;
	}

	@Column(name = "MAIN_SYPTM", length = 65535)
	public String getMainSyptm() {
		return this.mainSyptm;
	}

	public void setMainSyptm(String mainSyptm) {
		this.mainSyptm = mainSyptm;
	}

	@Column(name = "DIA_COMPL")
	public String getDiaCompl() {
		return this.diaCompl;
	}

	public void setDiaCompl(String diaCompl) {
		this.diaCompl = diaCompl;
	}

	@Column(name = "DIA_HISTORY", length = 65535)
	public String getDiaHistory() {
		return this.diaHistory;
	}

	public void setDiaHistory(String diaHistory) {
		this.diaHistory = diaHistory;
	}

	@Column(name = "FA_MEM")
	public String getFaMem() {
		return this.faMem;
	}

	public void setFaMem(String faMem) {
		this.faMem = faMem;
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