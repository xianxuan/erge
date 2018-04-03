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
 * TConsultationRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_CONSULTATION_RECORD", catalog = "jmjk")
public class TConsultationRecord implements java.io.Serializable {

	// Fields

	private Integer consultationRecordId;
	private THealthFile THealthFile;
	private String consultationReason;
	private String consultationOpinion;
	private String consultationDoctorInstitution;
	private String responsibleDoctor;
	private Timestamp conRecDate;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TConsultationRecord() {
	}

	/** minimal constructor */
	public TConsultationRecord(THealthFile THealthFile) {
		this.THealthFile = THealthFile;
	}

	/** full constructor */
	public TConsultationRecord(THealthFile THealthFile,
			String consultationReason, String consultationOpinion,
			String consultationDoctorInstitution, String responsibleDoctor,
			Timestamp conRecDate, String one, String two, String three,
			String four, String five) {
		this.THealthFile = THealthFile;
		this.consultationReason = consultationReason;
		this.consultationOpinion = consultationOpinion;
		this.consultationDoctorInstitution = consultationDoctorInstitution;
		this.responsibleDoctor = responsibleDoctor;
		this.conRecDate = conRecDate;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CONSULTATION_RECORD_ID", unique = true, nullable = false)
	public Integer getConsultationRecordId() {
		return this.consultationRecordId;
	}

	public void setConsultationRecordId(Integer consultationRecordId) {
		this.consultationRecordId = consultationRecordId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HEALTH_FILE_ID", nullable = false)
	public THealthFile getTHealthFile() {
		return this.THealthFile;
	}

	public void setTHealthFile(THealthFile THealthFile) {
		this.THealthFile = THealthFile;
	}

	@Column(name = "CONSULTATION_REASON", length = 65535)
	public String getConsultationReason() {
		return this.consultationReason;
	}

	public void setConsultationReason(String consultationReason) {
		this.consultationReason = consultationReason;
	}

	@Column(name = "CONSULTATION_OPINION", length = 65535)
	public String getConsultationOpinion() {
		return this.consultationOpinion;
	}

	public void setConsultationOpinion(String consultationOpinion) {
		this.consultationOpinion = consultationOpinion;
	}

	@Column(name = "CONSULTATION_DOCTOR_INSTITUTION", length = 1000)
	public String getConsultationDoctorInstitution() {
		return this.consultationDoctorInstitution;
	}

	public void setConsultationDoctorInstitution(
			String consultationDoctorInstitution) {
		this.consultationDoctorInstitution = consultationDoctorInstitution;
	}

	@Column(name = "RESPONSIBLE_DOCTOR")
	public String getResponsibleDoctor() {
		return this.responsibleDoctor;
	}

	public void setResponsibleDoctor(String responsibleDoctor) {
		this.responsibleDoctor = responsibleDoctor;
	}

	@Column(name = "CON_REC_DATE", length = 19)
	public Timestamp getConRecDate() {
		return this.conRecDate;
	}

	public void setConRecDate(Timestamp conRecDate) {
		this.conRecDate = conRecDate;
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