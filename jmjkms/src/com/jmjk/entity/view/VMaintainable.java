package com.jmjk.entity.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VMaintainable entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "V_MAINTAINABLE", catalog = "jmjk")
public class VMaintainable implements java.io.Serializable {

	// Fields

	private Integer maintainableEntryId;
	private String code;
	private String type;
	private String attributeName;
	private String attributeOne;
	private String attributeTwo;
	private String attributeThree;
	private String attributeFour;
	private String attributeFive;
	private String entryName;
	private String entryOne;
	private String entryTwo;
	private String entryThree;
	private String entryFour;
	private String entryFive;
	private Integer maintainableAttributeId;

	// Constructors

	/** default constructor */
	public VMaintainable() {
	}

	/** minimal constructor */
	public VMaintainable(Integer maintainableEntryId, String code, String type,
			String attributeName, Integer maintainableAttributeId) {
		this.maintainableEntryId = maintainableEntryId;
		this.code = code;
		this.type = type;
		this.attributeName = attributeName;
		this.maintainableAttributeId = maintainableAttributeId;
	}

	/** full constructor */
	public VMaintainable(Integer maintainableEntryId, String code, String type,
			String attributeName, String attributeOne, String attributeTwo,
			String attributeThree, String attributeFour, String attributeFive,
			String entryName, String entryOne, String entryTwo,
			String entryThree, String entryFour, String entryFive,
			Integer maintainableAttributeId) {
		this.maintainableEntryId = maintainableEntryId;
		this.code = code;
		this.type = type;
		this.attributeName = attributeName;
		this.attributeOne = attributeOne;
		this.attributeTwo = attributeTwo;
		this.attributeThree = attributeThree;
		this.attributeFour = attributeFour;
		this.attributeFive = attributeFive;
		this.entryName = entryName;
		this.entryOne = entryOne;
		this.entryTwo = entryTwo;
		this.entryThree = entryThree;
		this.entryFour = entryFour;
		this.entryFive = entryFive;
		this.maintainableAttributeId = maintainableAttributeId;
	}

	// Property accessors
	@Id
	@Column(name = "MAINTAINABLE_ENTRY_ID", nullable = false)
	public Integer getMaintainableEntryId() {
		return this.maintainableEntryId;
	}

	public void setMaintainableEntryId(Integer maintainableEntryId) {
		this.maintainableEntryId = maintainableEntryId;
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

	@Column(name = "ATTRIBUTE_NAME", nullable = false)
	public String getAttributeName() {
		return this.attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	@Column(name = "ATTRIBUTE_ONE", length = 1000)
	public String getAttributeOne() {
		return this.attributeOne;
	}

	public void setAttributeOne(String attributeOne) {
		this.attributeOne = attributeOne;
	}

	@Column(name = "ATTRIBUTE_TWO", length = 1000)
	public String getAttributeTwo() {
		return this.attributeTwo;
	}

	public void setAttributeTwo(String attributeTwo) {
		this.attributeTwo = attributeTwo;
	}

	@Column(name = "ATTRIBUTE_THREE", length = 1000)
	public String getAttributeThree() {
		return this.attributeThree;
	}

	public void setAttributeThree(String attributeThree) {
		this.attributeThree = attributeThree;
	}

	@Column(name = "ATTRIBUTE_FOUR", length = 1000)
	public String getAttributeFour() {
		return this.attributeFour;
	}

	public void setAttributeFour(String attributeFour) {
		this.attributeFour = attributeFour;
	}

	@Column(name = "ATTRIBUTE_FIVE", length = 1000)
	public String getAttributeFive() {
		return this.attributeFive;
	}

	public void setAttributeFive(String attributeFive) {
		this.attributeFive = attributeFive;
	}

	@Column(name = "ENTRY_NAME")
	public String getEntryName() {
		return this.entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}

	@Column(name = "ENTRY_ONE", length = 1000)
	public String getEntryOne() {
		return this.entryOne;
	}

	public void setEntryOne(String entryOne) {
		this.entryOne = entryOne;
	}

	@Column(name = "ENTRY_TWO", length = 1000)
	public String getEntryTwo() {
		return this.entryTwo;
	}

	public void setEntryTwo(String entryTwo) {
		this.entryTwo = entryTwo;
	}

	@Column(name = "ENTRY_THREE", length = 1000)
	public String getEntryThree() {
		return this.entryThree;
	}

	public void setEntryThree(String entryThree) {
		this.entryThree = entryThree;
	}

	@Column(name = "ENTRY_FOUR", length = 1000)
	public String getEntryFour() {
		return this.entryFour;
	}

	public void setEntryFour(String entryFour) {
		this.entryFour = entryFour;
	}

	@Column(name = "ENTRY_FIVE", length = 1000)
	public String getEntryFive() {
		return this.entryFive;
	}

	public void setEntryFive(String entryFive) {
		this.entryFive = entryFive;
	}

	@Column(name = "MAINTAINABLE_ATTRIBUTE_ID", nullable = false)
	public Integer getMaintainableAttributeId() {
		return this.maintainableAttributeId;
	}

	public void setMaintainableAttributeId(Integer maintainableAttributeId) {
		this.maintainableAttributeId = maintainableAttributeId;
	}

}