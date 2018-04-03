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
 * TCoronaryDisease entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_CORONARY_DISEASE", catalog = "jmjk")
public class TCoronaryDisease implements java.io.Serializable {

	// Fields

	private Integer coronaryDiseaseId;
	private TChronicDisease TChronicDisease;
	private String type;
	private String fristDiagnose;
	private String cause;
	private String form;
	private String complication;
	private String useDrug;
	private String electrocardiogram;
	private String electroencephalogram;
	private String x;
	private String ct;
	private String cerebralBloodVessel;
	private String remarks;
	private String ivestingPerson;
	private Timestamp filingDate;
	private String bookrunner;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TCoronaryDisease() {
	}

	/** minimal constructor */
	public TCoronaryDisease(TChronicDisease TChronicDisease, String type) {
		this.TChronicDisease = TChronicDisease;
		this.type = type;
	}

	/** full constructor */
	public TCoronaryDisease(TChronicDisease TChronicDisease, String type,
			String fristDiagnose, String cause, String form,
			String complication, String useDrug, String electrocardiogram,
			String electroencephalogram, String x, String ct,
			String cerebralBloodVessel, String remarks, String ivestingPerson,
			Timestamp filingDate, String bookrunner, String one, String two,
			String three, String four, String five) {
		this.TChronicDisease = TChronicDisease;
		this.type = type;
		this.fristDiagnose = fristDiagnose;
		this.cause = cause;
		this.form = form;
		this.complication = complication;
		this.useDrug = useDrug;
		this.electrocardiogram = electrocardiogram;
		this.electroencephalogram = electroencephalogram;
		this.x = x;
		this.ct = ct;
		this.cerebralBloodVessel = cerebralBloodVessel;
		this.remarks = remarks;
		this.ivestingPerson = ivestingPerson;
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
	@Column(name = "CORONARY_DISEASE_ID", unique = true, nullable = false)
	public Integer getCoronaryDiseaseId() {
		return this.coronaryDiseaseId;
	}

	public void setCoronaryDiseaseId(Integer coronaryDiseaseId) {
		this.coronaryDiseaseId = coronaryDiseaseId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHRONIC_DISEASE_ID", nullable = false)
	public TChronicDisease getTChronicDisease() {
		return this.TChronicDisease;
	}

	public void setTChronicDisease(TChronicDisease TChronicDisease) {
		this.TChronicDisease = TChronicDisease;
	}

	@Column(name = "TYPE", nullable = false)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "FRIST_DIAGNOSE", length = 65535)
	public String getFristDiagnose() {
		return this.fristDiagnose;
	}

	public void setFristDiagnose(String fristDiagnose) {
		this.fristDiagnose = fristDiagnose;
	}

	@Column(name = "CAUSE")
	public String getCause() {
		return this.cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	@Column(name = "FORM")
	public String getForm() {
		return this.form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	@Column(name = "COMPLICATION")
	public String getComplication() {
		return this.complication;
	}

	public void setComplication(String complication) {
		this.complication = complication;
	}

	@Column(name = "USE_DRUG", length = 65535)
	public String getUseDrug() {
		return this.useDrug;
	}

	public void setUseDrug(String useDrug) {
		this.useDrug = useDrug;
	}

	@Column(name = "ELECTROCARDIOGRAM")
	public String getElectrocardiogram() {
		return this.electrocardiogram;
	}

	public void setElectrocardiogram(String electrocardiogram) {
		this.electrocardiogram = electrocardiogram;
	}

	@Column(name = "ELECTROENCEPHALOGRAM")
	public String getElectroencephalogram() {
		return this.electroencephalogram;
	}

	public void setElectroencephalogram(String electroencephalogram) {
		this.electroencephalogram = electroencephalogram;
	}

	@Column(name = "X")
	public String getX() {
		return this.x;
	}

	public void setX(String x) {
		this.x = x;
	}

	@Column(name = "CT")
	public String getCt() {
		return this.ct;
	}

	public void setCt(String ct) {
		this.ct = ct;
	}

	@Column(name = "CEREBRAL_BLOOD_VESSEL")
	public String getCerebralBloodVessel() {
		return this.cerebralBloodVessel;
	}

	public void setCerebralBloodVessel(String cerebralBloodVessel) {
		this.cerebralBloodVessel = cerebralBloodVessel;
	}

	@Column(name = "REMARKS", length = 65535)
	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Column(name = "IVESTING_PERSON")
	public String getIvestingPerson() {
		return this.ivestingPerson;
	}

	public void setIvestingPerson(String ivestingPerson) {
		this.ivestingPerson = ivestingPerson;
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