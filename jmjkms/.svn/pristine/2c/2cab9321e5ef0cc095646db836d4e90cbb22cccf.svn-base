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
 * TMaintainableAttribute entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_MAINTAINABLE_ATTRIBUTE", catalog = "jmjk")
public class TMaintainableAttribute implements java.io.Serializable {

	// Fields

	private Integer maintainableAttributeId;
	private String code;
	private String type;
	private String name;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private Set<TMaintainableEntry> TMaintainableEntries = new HashSet<TMaintainableEntry>(
			0);

	// Constructors

	/** default constructor */
	public TMaintainableAttribute() {
	}

	/** minimal constructor */
	public TMaintainableAttribute(String code, String type, String name) {
		this.code = code;
		this.type = type;
		this.name = name;
	}

	/** full constructor */
	public TMaintainableAttribute(String code, String type, String name,
			String one, String two, String three, String four, String five,
			Set<TMaintainableEntry> TMaintainableEntries) {
		this.code = code;
		this.type = type;
		this.name = name;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.TMaintainableEntries = TMaintainableEntries;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MAINTAINABLE_ATTRIBUTE_ID", unique = true, nullable = false)
	public Integer getMaintainableAttributeId() {
		return this.maintainableAttributeId;
	}

	public void setMaintainableAttributeId(Integer maintainableAttributeId) {
		this.maintainableAttributeId = maintainableAttributeId;
	}

	@Column(name = "CODE", nullable = false)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "TYPE", nullable = false)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "NAME", nullable = false)
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TMaintainableAttribute")
	public Set<TMaintainableEntry> getTMaintainableEntries() {
		return this.TMaintainableEntries;
	}

	public void setTMaintainableEntries(
			Set<TMaintainableEntry> TMaintainableEntries) {
		this.TMaintainableEntries = TMaintainableEntries;
	}

}