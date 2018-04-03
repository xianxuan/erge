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
 * TDefendInocu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_DEFEND_INOCU", catalog = "jmjk")
public class TDefendInocu implements java.io.Serializable {

	// Fields

	private Integer diId;
	private TPhysicalExam TPhysicalExam;
	private String vaccineName;
	private Timestamp vaccineTime;
	private String vaccineInstit;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TDefendInocu() {
	}

	/** full constructor */
	public TDefendInocu(TPhysicalExam TPhysicalExam, String vaccineName,
			Timestamp vaccineTime, String vaccineInstit, String one,
			String two, String three, String four, String five) {
		this.TPhysicalExam = TPhysicalExam;
		this.vaccineName = vaccineName;
		this.vaccineTime = vaccineTime;
		this.vaccineInstit = vaccineInstit;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "DI_ID", unique = true, nullable = false)
	public Integer getDiId() {
		return this.diId;
	}

	public void setDiId(Integer diId) {
		this.diId = diId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PHYSICAL_EXAM_ID")
	public TPhysicalExam getTPhysicalExam() {
		return this.TPhysicalExam;
	}

	public void setTPhysicalExam(TPhysicalExam TPhysicalExam) {
		this.TPhysicalExam = TPhysicalExam;
	}

	@Column(name = "VACCINE_NAME")
	public String getVaccineName() {
		return this.vaccineName;
	}

	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}

	@Column(name = "VACCINE_TIME", length = 19)
	public Timestamp getVaccineTime() {
		return this.vaccineTime;
	}

	public void setVaccineTime(Timestamp vaccineTime) {
		this.vaccineTime = vaccineTime;
	}

	@Column(name = "VACCINE_INSTIT")
	public String getVaccineInstit() {
		return this.vaccineInstit;
	}

	public void setVaccineInstit(String vaccineInstit) {
		this.vaccineInstit = vaccineInstit;
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