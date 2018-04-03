package com.jmjk.entity;
// default package

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
 * TMedicalPayMethod entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_MEDICAL_PAY_METHOD", catalog = "jmjk")
public class TMedicalPayMethod implements java.io.Serializable {

	// Fields

	private Integer medicalPayMethodId;
	private THealthFile THealthFile;
	private String name;
	private String cardNum;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TMedicalPayMethod() {
	}

	/** minimal constructor */
	public TMedicalPayMethod(THealthFile THealthFile) {
		this.THealthFile = THealthFile;
	}

	/** full constructor */
	public TMedicalPayMethod(THealthFile THealthFile, String name,
			String cardNum, String one, String two, String three, String four,
			String five) {
		this.THealthFile = THealthFile;
		this.name = name;
		this.cardNum = cardNum;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MEDICAL_PAY_METHOD_ID", unique = true, nullable = false)
	public Integer getMedicalPayMethodId() {
		return this.medicalPayMethodId;
	}

	public void setMedicalPayMethodId(Integer medicalPayMethodId) {
		this.medicalPayMethodId = medicalPayMethodId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HEALTH_FILE_ID", nullable = false)
	public THealthFile getTHealthFile() {
		return this.THealthFile;
	}

	public void setTHealthFile(THealthFile THealthFile) {
		this.THealthFile = THealthFile;
	}

	@Column(name = "NAME")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "CARD_NUM")
	public String getCardNum() {
		return this.cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
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