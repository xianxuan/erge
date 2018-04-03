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
 * TOldStaffHos entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_OLD_STAFF_HOS", catalog = "jmjk")
public class TOldStaffHos implements java.io.Serializable {

	// Fields

	private Integer oldStaffHosId;
	private THealthFile THealthFile;
	private TStaff TStaff;
	private TCommunityHospital TCommunityHospital;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TOldStaffHos() {
	}

	/** full constructor */
	public TOldStaffHos(THealthFile THealthFile, TStaff TStaff,
			TCommunityHospital TCommunityHospital, String one, String two,
			String three, String four, String five) {
		this.THealthFile = THealthFile;
		this.TStaff = TStaff;
		this.TCommunityHospital = TCommunityHospital;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "OLD_STAFF_HOS_ID", unique = true, nullable = false)
	public Integer getOldStaffHosId() {
		return this.oldStaffHosId;
	}

	public void setOldStaffHosId(Integer oldStaffHosId) {
		this.oldStaffHosId = oldStaffHosId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HEALTH_FILE_ID")
	public THealthFile getTHealthFile() {
		return this.THealthFile;
	}

	public void setTHealthFile(THealthFile THealthFile) {
		this.THealthFile = THealthFile;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STAFF_ID")
	public TStaff getTStaff() {
		return this.TStaff;
	}

	public void setTStaff(TStaff TStaff) {
		this.TStaff = TStaff;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMMUNITY_HOSPITAL_ID")
	public TCommunityHospital getTCommunityHospital() {
		return this.TCommunityHospital;
	}

	public void setTCommunityHospital(TCommunityHospital TCommunityHospital) {
		this.TCommunityHospital = TCommunityHospital;
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