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
 * TMaintainableEntry entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_MAINTAINABLE_ENTRY", catalog = "jmjk")
public class TMaintainableEntry implements java.io.Serializable {

	// Fields

	private Integer maintainableEntryId;
	private TMaintainableAttribute TMaintainableAttribute;
	private String name;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TMaintainableEntry() {
	}

	/** minimal constructor */
	public TMaintainableEntry(TMaintainableAttribute TMaintainableAttribute) {
		this.TMaintainableAttribute = TMaintainableAttribute;
	}

	/** full constructor */
	public TMaintainableEntry(TMaintainableAttribute TMaintainableAttribute,
			String name, String one, String two, String three, String four,
			String five) {
		this.TMaintainableAttribute = TMaintainableAttribute;
		this.name = name;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MAINTAINABLE_ENTRY_ID", unique = true, nullable = false)
	public Integer getMaintainableEntryId() {
		return this.maintainableEntryId;
	}

	public void setMaintainableEntryId(Integer maintainableEntryId) {
		this.maintainableEntryId = maintainableEntryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MAINTAINABLE_ATTRIBUTE_ID", nullable = false)
	public TMaintainableAttribute getTMaintainableAttribute() {
		return this.TMaintainableAttribute;
	}

	public void setTMaintainableAttribute(
			TMaintainableAttribute TMaintainableAttribute) {
		this.TMaintainableAttribute = TMaintainableAttribute;
	}

	@Column(name = "NAME")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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