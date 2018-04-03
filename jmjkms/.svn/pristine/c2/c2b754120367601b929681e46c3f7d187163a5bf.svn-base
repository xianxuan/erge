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
 * THF entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_H_F", catalog = "jmjk")
public class THF implements java.io.Serializable {

	// Fields

	private Integer fshId;
	private TPhysicalExam TPhysicalExam;
	private Timestamp createBedTime;
	private Timestamp revokeBedTime;
	private String reason;
	private String medicalInstitution;
	private String medicalRecordNum;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public THF() {
	}

	/** full constructor */
	public THF(TPhysicalExam TPhysicalExam, Timestamp createBedTime,
			Timestamp revokeBedTime, String reason, String medicalInstitution,
			String medicalRecordNum, String one, String two, String three,
			String four, String five) {
		this.TPhysicalExam = TPhysicalExam;
		this.createBedTime = createBedTime;
		this.revokeBedTime = revokeBedTime;
		this.reason = reason;
		this.medicalInstitution = medicalInstitution;
		this.medicalRecordNum = medicalRecordNum;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "FSH_ID", unique = true, nullable = false)
	public Integer getFshId() {
		return this.fshId;
	}

	public void setFshId(Integer fshId) {
		this.fshId = fshId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PHYSICAL_EXAM_ID")
	public TPhysicalExam getTPhysicalExam() {
		return this.TPhysicalExam;
	}

	public void setTPhysicalExam(TPhysicalExam TPhysicalExam) {
		this.TPhysicalExam = TPhysicalExam;
	}

	@Column(name = "CREATE_BED_TIME", length = 19)
	public Timestamp getCreateBedTime() {
		return this.createBedTime;
	}

	public void setCreateBedTime(Timestamp createBedTime) {
		this.createBedTime = createBedTime;
	}

	@Column(name = "REVOKE_BED_TIME", length = 19)
	public Timestamp getRevokeBedTime() {
		return this.revokeBedTime;
	}

	public void setRevokeBedTime(Timestamp revokeBedTime) {
		this.revokeBedTime = revokeBedTime;
	}

	@Column(name = "REASON", length = 65535)
	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	@Column(name = "MEDICAL_INSTITUTION")
	public String getMedicalInstitution() {
		return this.medicalInstitution;
	}

	public void setMedicalInstitution(String medicalInstitution) {
		this.medicalInstitution = medicalInstitution;
	}

	@Column(name = "MEDICAL_RECORD_NUM")
	public String getMedicalRecordNum() {
		return this.medicalRecordNum;
	}

	public void setMedicalRecordNum(String medicalRecordNum) {
		this.medicalRecordNum = medicalRecordNum;
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