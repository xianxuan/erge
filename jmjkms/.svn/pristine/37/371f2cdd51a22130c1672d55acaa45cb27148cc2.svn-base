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
 * TFamilyBedHistory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_FAMILY_BED_HISTORY", catalog = "jmjk")
public class TFamilyBedHistory implements java.io.Serializable {

	// Fields

	private Integer familyBedHistoryId;
	private THealthFile THealthFile;
	private Timestamp buildBedDate;
	private Timestamp fromBedDate;
	private String reason;
	private String institution;
	private String medicalNum;
	private String note;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TFamilyBedHistory() {
	}

	/** minimal constructor */
	public TFamilyBedHistory(THealthFile THealthFile) {
		this.THealthFile = THealthFile;
	}

	/** full constructor */
	public TFamilyBedHistory(THealthFile THealthFile, Timestamp buildBedDate,
			Timestamp fromBedDate, String reason, String institution,
			String medicalNum, String note, String one, String two,
			String three, String four, String five) {
		this.THealthFile = THealthFile;
		this.buildBedDate = buildBedDate;
		this.fromBedDate = fromBedDate;
		this.reason = reason;
		this.institution = institution;
		this.medicalNum = medicalNum;
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
	@Column(name = "FAMILY_BED_HISTORY_ID", unique = true, nullable = false)
	public Integer getFamilyBedHistoryId() {
		return this.familyBedHistoryId;
	}

	public void setFamilyBedHistoryId(Integer familyBedHistoryId) {
		this.familyBedHistoryId = familyBedHistoryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HEALTH_FILE_ID", nullable = false)
	public THealthFile getTHealthFile() {
		return this.THealthFile;
	}

	public void setTHealthFile(THealthFile THealthFile) {
		this.THealthFile = THealthFile;
	}

	@Column(name = "BUILD_BED_DATE", length = 19)
	public Timestamp getBuildBedDate() {
		return this.buildBedDate;
	}

	public void setBuildBedDate(Timestamp buildBedDate) {
		this.buildBedDate = buildBedDate;
	}

	@Column(name = "FROM_BED_DATE", length = 19)
	public Timestamp getFromBedDate() {
		return this.fromBedDate;
	}

	public void setFromBedDate(Timestamp fromBedDate) {
		this.fromBedDate = fromBedDate;
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

	@Column(name = "MEDICAL_NUM")
	public String getMedicalNum() {
		return this.medicalNum;
	}

	public void setMedicalNum(String medicalNum) {
		this.medicalNum = medicalNum;
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