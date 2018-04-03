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
 * TDoctorDiagnosis entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_DOCTOR_DIAGNOSIS", catalog = "jmjk")
public class TDoctorDiagnosis implements java.io.Serializable {

	// Fields

	private Integer doctorDiagnosisId;
	private THealthFile THealthFile;
	private TStaff TStaff;
	private String chronic;
	private String opinion;
	private String advice;
	private Timestamp date;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TDoctorDiagnosis() {
	}

	/** full constructor */
	public TDoctorDiagnosis(THealthFile THealthFile, TStaff TStaff,
			String chronic, String opinion, String advice, Timestamp date,
			String one, String two, String three, String four, String five) {
		this.THealthFile = THealthFile;
		this.TStaff = TStaff;
		this.chronic = chronic;
		this.opinion = opinion;
		this.advice = advice;
		this.date = date;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "DOCTOR_DIAGNOSIS_ID", unique = true, nullable = false)
	public Integer getDoctorDiagnosisId() {
		return this.doctorDiagnosisId;
	}

	public void setDoctorDiagnosisId(Integer doctorDiagnosisId) {
		this.doctorDiagnosisId = doctorDiagnosisId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HEALTH_FILE_ID")
	public THealthFile getTHealthFile() {
		return this.THealthFile;
	}

	public void setTHealthFile(THealthFile THealthFile) {
		this.THealthFile = THealthFile;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STAFF_ID")
	public TStaff getTStaff() {
		return this.TStaff;
	}

	public void setTStaff(TStaff TStaff) {
		this.TStaff = TStaff;
	}

	@Column(name = "CHRONIC")
	public String getChronic() {
		return this.chronic;
	}

	public void setChronic(String chronic) {
		this.chronic = chronic;
	}

	@Column(name = "OPINION", length = 65535)
	public String getOpinion() {
		return this.opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	@Column(name = "ADVICE", length = 65535)
	public String getAdvice() {
		return this.advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	@Column(name = "DATE", length = 19)
	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
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