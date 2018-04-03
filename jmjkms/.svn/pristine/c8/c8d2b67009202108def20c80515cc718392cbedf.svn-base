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
 * THospitalHistory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_HOSPITAL_HISTORY", catalog = "jmjk")
public class THospitalHistory implements java.io.Serializable {

	// Fields

	private Integer hhId;
	private TPhysicalExam TPhysicalExam;
	private Timestamp admitHosTime;
	private Timestamp leaveHosTime;
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
	public THospitalHistory() {
	}

	/** full constructor */
	public THospitalHistory(TPhysicalExam TPhysicalExam,
			Timestamp admitHosTime, Timestamp leaveHosTime, String reason,
			String medicalInstitution, String medicalRecordNum, String one,
			String two, String three, String four, String five) {
		this.TPhysicalExam = TPhysicalExam;
		this.admitHosTime = admitHosTime;
		this.leaveHosTime = leaveHosTime;
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
	@Column(name = "HH_ID", unique = true, nullable = false)
	public Integer getHhId() {
		return this.hhId;
	}

	public void setHhId(Integer hhId) {
		this.hhId = hhId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PHYSICAL_EXAM_ID")
	public TPhysicalExam getTPhysicalExam() {
		return this.TPhysicalExam;
	}

	public void setTPhysicalExam(TPhysicalExam TPhysicalExam) {
		this.TPhysicalExam = TPhysicalExam;
	}

	@Column(name = "ADMIT_HOS_TIME", length = 19)
	public Timestamp getAdmitHosTime() {
		return this.admitHosTime;
	}

	public void setAdmitHosTime(Timestamp admitHosTime) {
		this.admitHosTime = admitHosTime;
	}

	@Column(name = "LEAVE_HOS_TIME", length = 19)
	public Timestamp getLeaveHosTime() {
		return this.leaveHosTime;
	}

	public void setLeaveHosTime(Timestamp leaveHosTime) {
		this.leaveHosTime = leaveHosTime;
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