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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TCommunityHospital entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_COMMUNITY_HOSPITAL", catalog = "jmjk")
public class TCommunityHospital implements java.io.Serializable {

	// Fields

	private Integer communityHospitalId;
	private TCommunityHospitalGroup TCommunityHospitalGroup;
	private String hospitalCode;
	private String hospitalLevel;
	private String communityHospital;
	private String address;
	private String longitude;
	private String latitude;
	private String name;
	private String phone;
	private String login;
	private String password;
	private String status;
	private Integer isHead;
	private String note;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private Set<TOldStaffHos> TOldStaffHoses = new HashSet<TOldStaffHos>(0);
	private Set<TEquipmentManage> TEquipmentManages = new HashSet<TEquipmentManage>(
			0);
	private Set<TCount> TCounts = new HashSet<TCount>(0);

	// Constructors

	/** default constructor */
	public TCommunityHospital() {
	}
	
//	public TCommunityHospital( int communityHospitalId) {
//		this.communityHospitalId=communityHospitalId;
//	}


	/** minimal constructor */
	public TCommunityHospital(String hospitalLevel, String communityHospital,
			String name, String phone, String login, String password) {
		this.hospitalLevel = hospitalLevel;
		this.communityHospital = communityHospital;
		this.name = name;
		this.phone = phone;
		this.login = login;
		this.password = password;
	}

	/** full constructor */
	public TCommunityHospital(TCommunityHospitalGroup TCommunityHospitalGroup,
			String hospitalCode, String hospitalLevel,
			String communityHospital, String address, String longitude,
			String latitude, String name, String phone, String login,
			String password, String status, Integer isHead, String note,
			String one, String two, String three, String four, String five,
			Set<TOldStaffHos> TOldStaffHoses,
			Set<TEquipmentManage> TEquipmentManages, Set<TCount> TCounts) {
		this.TCommunityHospitalGroup = TCommunityHospitalGroup;
		this.hospitalCode = hospitalCode;
		this.hospitalLevel = hospitalLevel;
		this.communityHospital = communityHospital;
		this.address = address;
		this.longitude = longitude;
		this.latitude = latitude;
		this.name = name;
		this.phone = phone;
		this.login = login;
		this.password = password;
		this.status = status;
		this.isHead = isHead;
		this.note = note;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.TOldStaffHoses = TOldStaffHoses;
		this.TEquipmentManages = TEquipmentManages;
		this.TCounts = TCounts;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "COMMUNITY_HOSPITAL_ID", unique = true, nullable = false)
	public Integer getCommunityHospitalId() {
		return this.communityHospitalId;
	}

	public void setCommunityHospitalId(Integer communityHospitalId) {
		this.communityHospitalId = communityHospitalId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "G_ID")
	public TCommunityHospitalGroup getTCommunityHospitalGroup() {
		return this.TCommunityHospitalGroup;
	}

	public void setTCommunityHospitalGroup(
			TCommunityHospitalGroup TCommunityHospitalGroup) {
		this.TCommunityHospitalGroup = TCommunityHospitalGroup;
	}

	@Column(name = "HOSPITAL_CODE")
	public String getHospitalCode() {
		return this.hospitalCode;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}

	@Column(name = "HOSPITAL_LEVEL", nullable = false)
	public String getHospitalLevel() {
		return this.hospitalLevel;
	}

	public void setHospitalLevel(String hospitalLevel) {
		this.hospitalLevel = hospitalLevel;
	}

	@Column(name = "COMMUNITY_HOSPITAl", nullable = false)
	public String getCommunityHospital() {
		return this.communityHospital;
	}

	public void setCommunityHospital(String communityHospital) {
		this.communityHospital = communityHospital;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "LONGITUDE")
	public String getLongitude() {
		return this.longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	@Column(name = "LATITUDE")
	public String getLatitude() {
		return this.latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@Column(name = "NAME", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "PHONE", nullable = false)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "LOGIN", nullable = false)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "PASSWORD", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "STATUS", length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "IS_HEAD")
	public Integer getIsHead() {
		return this.isHead;
	}

	public void setIsHead(Integer isHead) {
		this.isHead = isHead;
	}

	@Column(name = "NOTE", length = 65535)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TCommunityHospital")
	public Set<TOldStaffHos> getTOldStaffHoses() {
		return this.TOldStaffHoses;
	}

	public void setTOldStaffHoses(Set<TOldStaffHos> TOldStaffHoses) {
		this.TOldStaffHoses = TOldStaffHoses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TCommunityHospital")
	public Set<TEquipmentManage> getTEquipmentManages() {
		return this.TEquipmentManages;
	}

	public void setTEquipmentManages(Set<TEquipmentManage> TEquipmentManages) {
		this.TEquipmentManages = TEquipmentManages;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TCommunityHospital")
	public Set<TCount> getTCounts() {
		return this.TCounts;
	}

	public void setTCounts(Set<TCount> TCounts) {
		this.TCounts = TCounts;
	}

}