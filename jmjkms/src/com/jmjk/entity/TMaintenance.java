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
 * TMaintenance entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_MAINTENANCE", catalog = "jmjk")
public class TMaintenance implements java.io.Serializable {

	// Fields

	private Integer manitenanceId;
	private TEquipmentManage TEquipmentManage;
	private Timestamp date;
	private String company;
	private String person;
	private String problem;
	private Double fee;
	private String state;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TMaintenance() {
	}

	/** minimal constructor */
	public TMaintenance(TEquipmentManage TEquipmentManage, String state) {
		this.TEquipmentManage = TEquipmentManage;
		this.state = state;
	}

	/** full constructor */
	public TMaintenance(TEquipmentManage TEquipmentManage, Timestamp date,
			String company, String person, String problem, Double fee,
			String state, String one, String two, String three, String four,
			String five) {
		this.TEquipmentManage = TEquipmentManage;
		this.date = date;
		this.company = company;
		this.person = person;
		this.problem = problem;
		this.fee = fee;
		this.state = state;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "MANITENANCE_ID", unique = true, nullable = false)
	public Integer getManitenanceId() {
		return this.manitenanceId;
	}

	public void setManitenanceId(Integer manitenanceId) {
		this.manitenanceId = manitenanceId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EQUIP_ID", nullable = false)
	public TEquipmentManage getTEquipmentManage() {
		return this.TEquipmentManage;
	}

	public void setTEquipmentManage(TEquipmentManage TEquipmentManage) {
		this.TEquipmentManage = TEquipmentManage;
	}

	@Column(name = "DATE", length = 19)
	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	@Column(name = "COMPANY")
	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "PERSON")
	public String getPerson() {
		return this.person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	@Column(name = "PROBLEM", length = 65535)
	public String getProblem() {
		return this.problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	@Column(name = "FEE", precision = 22, scale = 0)
	public Double getFee() {
		return this.fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	@Column(name = "STATE", nullable = false, length = 1)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
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