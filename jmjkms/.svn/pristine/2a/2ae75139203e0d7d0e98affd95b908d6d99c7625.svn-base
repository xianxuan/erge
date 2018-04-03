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
 * TMedicalUse entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_MEDICAL_USE", catalog = "jmjk")
public class TMedicalUse implements java.io.Serializable {

	// Fields

	private Integer muId;
	private TPhysicalExam TPhysicalExam;
	private String medicalName;
	private String useMethod;
	private String useAccount;
	private Timestamp useTime;
	private String medicalComl;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TMedicalUse() {
	}

	/** full constructor */
	public TMedicalUse(TPhysicalExam TPhysicalExam, String medicalName,
			String useMethod, String useAccount, Timestamp useTime,
			String medicalComl, String one, String two, String three,
			String four, String five) {
		this.TPhysicalExam = TPhysicalExam;
		this.medicalName = medicalName;
		this.useMethod = useMethod;
		this.useAccount = useAccount;
		this.useTime = useTime;
		this.medicalComl = medicalComl;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MU_ID", unique = true, nullable = false)
	public Integer getMuId() {
		return this.muId;
	}

	public void setMuId(Integer muId) {
		this.muId = muId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PHYSICAL_EXAM_ID")
	public TPhysicalExam getTPhysicalExam() {
		return this.TPhysicalExam;
	}

	public void setTPhysicalExam(TPhysicalExam TPhysicalExam) {
		this.TPhysicalExam = TPhysicalExam;
	}

	@Column(name = "MEDICAL_NAME")
	public String getMedicalName() {
		return this.medicalName;
	}

	public void setMedicalName(String medicalName) {
		this.medicalName = medicalName;
	}

	@Column(name = "USE_METHOD", length = 65535)
	public String getUseMethod() {
		return this.useMethod;
	}

	public void setUseMethod(String useMethod) {
		this.useMethod = useMethod;
	}

	@Column(name = "USE_ACCOUNT", length = 65535)
	public String getUseAccount() {
		return this.useAccount;
	}

	public void setUseAccount(String useAccount) {
		this.useAccount = useAccount;
	}

	@Column(name = "USE_TIME", length = 19)
	public Timestamp getUseTime() {
		return this.useTime;
	}

	public void setUseTime(Timestamp useTime) {
		this.useTime = useTime;
	}

	@Column(name = "MEDICAL_COML", length = 65535)
	public String getMedicalComl() {
		return this.medicalComl;
	}

	public void setMedicalComl(String medicalComl) {
		this.medicalComl = medicalComl;
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