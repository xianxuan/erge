package com.jmjk.entity;
// default package

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TEquipmentManage entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_EQUIPMENT_MANAGE", catalog = "jmjk")
public class TEquipmentManage implements java.io.Serializable {

	// Fields

	private Integer equipId;
	private TCommunityHospital TCommunityHospital;
	private TStaff TStaff;
	private String equipNumber;
	private String equipName;
	private String equipModel;
	private String equipPeople;
	private String equipCompany;
	private String contact;
	private String selectContract;
	private Timestamp selectTime;
	private String status;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private Set<TMaintenance> TMaintenances = new HashSet<TMaintenance>(0);

	// Constructors

	/** default constructor */
	public TEquipmentManage() {
	}

	/** minimal constructor */
	public TEquipmentManage(TCommunityHospital TCommunityHospital,
			String equipNumber, String equipName) {
		this.TCommunityHospital = TCommunityHospital;
		this.equipNumber = equipNumber;
		this.equipName = equipName;
	}

	/** full constructor */
	public TEquipmentManage(TCommunityHospital TCommunityHospital,
			TStaff TStaff, String equipNumber, String equipName,
			String equipModel, String equipPeople, String equipCompany,
			String contact, String selectContract, Timestamp selectTime,
			String status, String one, String two, String three, String four,
			String five, Set<TMaintenance> TMaintenances) {
		this.TCommunityHospital = TCommunityHospital;
		this.TStaff = TStaff;
		this.equipNumber = equipNumber;
		this.equipName = equipName;
		this.equipModel = equipModel;
		this.equipPeople = equipPeople;
		this.equipCompany = equipCompany;
		this.contact = contact;
		this.selectContract = selectContract;
		this.selectTime = selectTime;
		this.status = status;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.TMaintenances = TMaintenances;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "EQUIP_ID", unique = true, nullable = false)
	public Integer getEquipId() {
		return this.equipId;
	}

	public void setEquipId(Integer equipId) {
		this.equipId = equipId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMMUNITY_ID", nullable = false)
	public TCommunityHospital getTCommunityHospital() {
		return this.TCommunityHospital;
	}

	public void setTCommunityHospital(TCommunityHospital TCommunityHospital) {
		this.TCommunityHospital = TCommunityHospital;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STAFF_ID")
	public TStaff getTStaff() {
		return this.TStaff;
	}

	public void setTStaff(TStaff TStaff) {
		this.TStaff = TStaff;
	}

	@Column(name = "EQUIP_NUMBER", nullable = false)
	public String getEquipNumber() {
		return this.equipNumber;
	}

	public void setEquipNumber(String equipNumber) {
		this.equipNumber = equipNumber;
	}

	@Column(name = "EQUIP_NAME", nullable = false)
	public String getEquipName() {
		return this.equipName;
	}

	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}

	@Column(name = "EQUIP_MODEL")
	public String getEquipModel() {
		return this.equipModel;
	}

	public void setEquipModel(String equipModel) {
		this.equipModel = equipModel;
	}

	@Column(name = "EQUIP_PEOPLE")
	public String getEquipPeople() {
		return this.equipPeople;
	}

	public void setEquipPeople(String equipPeople) {
		this.equipPeople = equipPeople;
	}

	@Column(name = "EQUIP_COMPANY")
	public String getEquipCompany() {
		return this.equipCompany;
	}

	public void setEquipCompany(String equipCompany) {
		this.equipCompany = equipCompany;
	}

	@Column(name = "CONTACT")
	public String getContact() {
		return this.contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Column(name = "SELECT_CONTRACT", length = 65535)
	public String getSelectContract() {
		return this.selectContract;
	}

	public void setSelectContract(String selectContract) {
		this.selectContract = selectContract;
	}

	@Column(name = "SELECT_TIME", length = 19)
	public Timestamp getSelectTime() {
		return this.selectTime;
	}

	public void setSelectTime(Timestamp selectTime) {
		this.selectTime = selectTime;
	}

	@Column(name = "STATUS", length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TEquipmentManage")
	public Set<TMaintenance> getTMaintenances() {
		return this.TMaintenances;
	}

	public void setTMaintenances(Set<TMaintenance> TMaintenances) {
		this.TMaintenances = TMaintenances;
	}

}