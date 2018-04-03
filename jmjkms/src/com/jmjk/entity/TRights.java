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
 * TRights entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RIGHTS", catalog = "jmjk")
public class TRights implements java.io.Serializable {

	// Fields

	private Integer rightsId;
	private TRole TRole;
	private String module;
	private String rightsName;
	private String rightsCode;
	private Integer rightsValue;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TRights() {
	}

	/** minimal constructor */
	public TRights(TRole TRole, String module, String rightsCode) {
		this.TRole = TRole;
		this.module = module;
		this.rightsCode = rightsCode;
	}

	/** full constructor */
	public TRights(TRole TRole, String module, String rightsName,
			String rightsCode, Integer rightsValue, String one, String two,
			String three, String four, String five) {
		this.TRole = TRole;
		this.module = module;
		this.rightsName = rightsName;
		this.rightsCode = rightsCode;
		this.rightsValue = rightsValue;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "RIGHTS_ID", unique = true, nullable = false)
	public Integer getRightsId() {
		return this.rightsId;
	}

	public void setRightsId(Integer rightsId) {
		this.rightsId = rightsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID", nullable = false)
	public TRole getTRole() {
		return this.TRole;
	}

	public void setTRole(TRole TRole) {
		this.TRole = TRole;
	}

	@Column(name = "MODULE", nullable = false)
	public String getModule() {
		return this.module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	@Column(name = "RIGHTS_NAME")
	public String getRightsName() {
		return this.rightsName;
	}

	public void setRightsName(String rightsName) {
		this.rightsName = rightsName;
	}

	@Column(name = "RIGHTS_CODE", nullable = false)
	public String getRightsCode() {
		return this.rightsCode;
	}

	public void setRightsCode(String rightsCode) {
		this.rightsCode = rightsCode;
	}

	@Column(name = "RIGHTS_VALUE")
	public Integer getRightsValue() {
		return this.rightsValue;
	}

	public void setRightsValue(Integer rightsValue) {
		this.rightsValue = rightsValue;
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