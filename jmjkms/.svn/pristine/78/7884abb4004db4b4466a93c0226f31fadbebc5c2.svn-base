package com.jmjk.entity;
// default package

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TPower entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_POWER", catalog = "jmjk")
public class TPower implements java.io.Serializable {

	// Fields

	private Integer powerId;
	private String first;
	private String second;
	private String code;
	private String vauleName;
	private Integer value;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TPower() {
	}

	/** full constructor */
	public TPower(String first, String second, String code, String vauleName,
			Integer value, String one, String two, String three, String four,
			String five) {
		this.first = first;
		this.second = second;
		this.code = code;
		this.vauleName = vauleName;
		this.value = value;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "POWER_ID", unique = true, nullable = false)
	public Integer getPowerId() {
		return this.powerId;
	}

	public void setPowerId(Integer powerId) {
		this.powerId = powerId;
	}

	@Column(name = "FIRST")
	public String getFirst() {
		return this.first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	@Column(name = "SECOND")
	public String getSecond() {
		return this.second;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	@Column(name = "CODE")
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "VAULE_NAME")
	public String getVauleName() {
		return this.vauleName;
	}

	public void setVauleName(String vauleName) {
		this.vauleName = vauleName;
	}

	@Column(name = "VALUE")
	public Integer getValue() {
		return this.value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	@Column(name = "ONE")
	public String getOne() {
		return this.one;
	}

	public void setOne(String one) {
		this.one = one;
	}

	@Column(name = "TWO")
	public String getTwo() {
		return this.two;
	}

	public void setTwo(String two) {
		this.two = two;
	}

	@Column(name = "THREE")
	public String getThree() {
		return this.three;
	}

	public void setThree(String three) {
		this.three = three;
	}

	@Column(name = "FOUR")
	public String getFour() {
		return this.four;
	}

	public void setFour(String four) {
		this.four = four;
	}

	@Column(name = "FIVE")
	public String getFive() {
		return this.five;
	}

	public void setFive(String five) {
		this.five = five;
	}

}