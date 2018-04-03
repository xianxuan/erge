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
 * TInHospitalHistory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_IN_HOSPITAL_HISTORY", catalog = "jmjk")
public class TInHospitalHistory implements java.io.Serializable {

	// Fields

	private Integer inHospitalHistoryId;
	private THealthFile THealthFile;
	private Timestamp inDate;
	private Timestamp outDate;
	private String reason;
	private String institution;
	private String medicalRecord;
	private String note;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TInHospitalHistory() {
	}

	/** minimal constructor */
	public TInHospitalHistory(THealthFile THealthFile) {
		this.THealthFile = THealthFile;
	}

	/** full constructor */
	public TInHospitalHistory(THealthFile THealthFile, Timestamp inDate,
			Timestamp outDate, String reason, String institution,
			String medicalRecord, String note, String one, String two,
			String three, String four, String five) {
		this.THealthFile = THealthFile;
		this.inDate = inDate;
		this.outDate = outDate;
		this.reason = reason;
		this.institution = institution;
		this.medicalRecord = medicalRecord;
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
	@Column(name = "IN_HOSPITAL_HISTORY_ID", unique = true, nullable = false)
	public Integer getInHospitalHistoryId() {
		return this.inHospitalHistoryId;
	}

	public void setInHospitalHistoryId(Integer inHospitalHistoryId) {
		this.inHospitalHistoryId = inHospitalHistoryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HEALTH_FILE_ID", nullable = false)
	public THealthFile getTHealthFile() {
		return this.THealthFile;
	}

	public void setTHealthFile(THealthFile THealthFile) {
		this.THealthFile = THealthFile;
	}

	@Column(name = "IN_DATE", length = 19)
	public Timestamp getInDate() {
		return this.inDate;
	}

	public void setInDate(Timestamp inDate) {
		this.inDate = inDate;
	}

	@Column(name = "OUT_DATE", length = 19)
	public Timestamp getOutDate() {
		return this.outDate;
	}

	public void setOutDate(Timestamp outDate) {
		this.outDate = outDate;
	}

	@Column(name = "REASON", length = 65535)
	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Column(name = "INSTITUTION")
	public String getInstitution() {
		return this.institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	@Column(name = "MEDICAL_RECORD")
	public String getMedicalRecord() {
		return this.medicalRecord;
	}

	public void setMedicalRecord(String medicalRecord) {
		this.medicalRecord = medicalRecord;
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