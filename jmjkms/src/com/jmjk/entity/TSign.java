package com.jmjk.entity;
// default package

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TSign entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_SIGN", catalog = "jmjk")
public class TSign implements java.io.Serializable {

	// Fields

	private Integer signId;
	private Double wight;
	private Double height;
	private Double bmi;
	private Double bloodPressureL;
	private Double bloodPressureH;
	private String heartRate;
	private String others;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private Set<TRegistrationOtherDiseases> TRegistrationOtherDiseaseses = new HashSet<TRegistrationOtherDiseases>(
			0);
	private Set<TDiabetsFollow> TDiabetsFollows = new HashSet<TDiabetsFollow>(0);
	private Set<THypertensiveFollow> THypertensiveFollows = new HashSet<THypertensiveFollow>(
			0);

	// Constructors

	/** default constructor */
	public TSign() {
	}

	/** full constructor */
	public TSign(Double wight, Double height, Double bmi,
			Double bloodPressureL, Double bloodPressureH, String heartRate,
			String others, String one, String two, String three, String four,
			String five,
			Set<TRegistrationOtherDiseases> TRegistrationOtherDiseaseses,
			Set<TDiabetsFollow> TDiabetsFollows,
			Set<THypertensiveFollow> THypertensiveFollows) {
		this.wight = wight;
		this.height = height;
		this.bmi = bmi;
		this.bloodPressureL = bloodPressureL;
		this.bloodPressureH = bloodPressureH;
		this.heartRate = heartRate;
		this.others = others;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.TRegistrationOtherDiseaseses = TRegistrationOtherDiseaseses;
		this.TDiabetsFollows = TDiabetsFollows;
		this.THypertensiveFollows = THypertensiveFollows;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "SIGN_ID", unique = true, nullable = false)
	public Integer getSignId() {
		return this.signId;
	}

	public void setSignId(Integer signId) {
		this.signId = signId;
	}

	@Column(name = "WIGHT", precision = 22, scale = 0)
	public Double getWight() {
		return this.wight;
	}

	public void setWight(Double wight) {
		this.wight = wight;
	}

	@Column(name = "HEIGHT", precision = 22, scale = 0)
	public Double getHeight() {
		return this.height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	@Column(name = "BMI", precision = 22, scale = 0)
	public Double getBmi() {
		return this.bmi;
	}

	public void setBmi(Double bmi) {
		this.bmi = bmi;
	}

	@Column(name = "BLOOD_PRESSURE_L", precision = 22, scale = 0)
	public Double getBloodPressureL() {
		return this.bloodPressureL;
	}

	public void setBloodPressureL(Double bloodPressureL) {
		this.bloodPressureL = bloodPressureL;
	}

	@Column(name = "BLOOD_PRESSURE_H", precision = 22, scale = 0)
	public Double getBloodPressureH() {
		return this.bloodPressureH;
	}

	public void setBloodPressureH(Double bloodPressureH) {
		this.bloodPressureH = bloodPressureH;
	}

	@Column(name = "HEART_RATE", length = 11)
	public String getHeartRate() {
		return this.heartRate;
	}

	public void setHeartRate(String heartRate) {
		this.heartRate = heartRate;
	}

	@Column(name = "OTHERS", length = 65535)
	public String getOthers() {
		return this.others;
	}

	public void setOthers(String others) {
		this.others = others;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TSign")
	public Set<TRegistrationOtherDiseases> getTRegistrationOtherDiseaseses() {
		return this.TRegistrationOtherDiseaseses;
	}

	public void setTRegistrationOtherDiseaseses(
			Set<TRegistrationOtherDiseases> TRegistrationOtherDiseaseses) {
		this.TRegistrationOtherDiseaseses = TRegistrationOtherDiseaseses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TSign")
	public Set<TDiabetsFollow> getTDiabetsFollows() {
		return this.TDiabetsFollows;
	}

	public void setTDiabetsFollows(Set<TDiabetsFollow> TDiabetsFollows) {
		this.TDiabetsFollows = TDiabetsFollows;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TSign")
	public Set<THypertensiveFollow> getTHypertensiveFollows() {
		return this.THypertensiveFollows;
	}

	public void setTHypertensiveFollows(
			Set<THypertensiveFollow> THypertensiveFollows) {
		this.THypertensiveFollows = THypertensiveFollows;
	}

}