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
 * TMedicalRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_MEDICAL_RECORD", catalog = "jmjk")
public class TMedicalRecord implements java.io.Serializable {

	// Fields

	private Integer medicalRecordId;
	private THealthFile THealthFile;
	private Timestamp beginDate;
	private Timestamp stopDate;
	private String drugName;
	private String usages;
	private String dosage;
	private String medicationAdherence;
	private String note;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TMedicalRecord() {
	}

	/** minimal constructor */
	public TMedicalRecord(THealthFile THealthFile) {
		this.THealthFile = THealthFile;
	}

	/** full constructor */
	public TMedicalRecord(THealthFile THealthFile, Timestamp beginDate,
			Timestamp stopDate, String drugName, String usages, String dosage,
			String medicationAdherence, String note, String one, String two,
			String three, String four, String five) {
		this.THealthFile = THealthFile;
		this.beginDate = beginDate;
		this.stopDate = stopDate;
		this.drugName = drugName;
		this.usages = usages;
		this.dosage = dosage;
		this.medicationAdherence = medicationAdherence;
		this.note = note;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MEDICAL_RECORD_ID", unique = true, nullable = false)
	public Integer getMedicalRecordId() {
		return this.medicalRecordId;
	}

	public void setMedicalRecordId(Integer medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HEALTH_FILE_ID", nullable = false)
	public THealthFile getTHealthFile() {
		return this.THealthFile;
	}

	public void setTHealthFile(THealthFile THealthFile) {
		this.THealthFile = THealthFile;
	}

	@Column(name = "BEGIN_DATE", length = 19)
	public Timestamp getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(Timestamp beginDate) {
		this.beginDate = beginDate;
	}

	@Column(name = "STOP_DATE", length = 19)
	public Timestamp getStopDate() {
		return this.stopDate;
	}

	public void setStopDate(Timestamp stopDate) {
		this.stopDate = stopDate;
	}

	@Column(name = "DRUG_NAME")
	public String getDrugName() {
		return this.drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	@Column(name = "USAGES", length = 65535)
	public String getUsages() {
		return this.usages;
	}

	public void setUsages(String usages) {
		this.usages = usages;
	}

	@Column(name = "DOSAGE", length = 65535)
	public String getDosage() {
		return this.dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	@Column(name = "MEDICATION_ADHERENCE", length = 65535)
	public String getMedicationAdherence() {
		return this.medicationAdherence;
	}

	public void setMedicationAdherence(String medicationAdherence) {
		this.medicationAdherence = medicationAdherence;
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

}