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
 * TCount entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_COUNT", catalog = "jmjk")
public class TCount implements java.io.Serializable {

	// Fields

	private Integer countId;
	private TCommunityHospital TCommunityHospital;
	private String disease;
	private String yearMounth;
	private Integer num;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TCount() {
	}

	/** full constructor */
	public TCount(TCommunityHospital TCommunityHospital, String disease,
			String yearMounth, Integer num, String one, String two,
			String three, String four, String five) {
		this.TCommunityHospital = TCommunityHospital;
		this.disease = disease;
		this.yearMounth = yearMounth;
		this.num = num;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "COUNT_ID", unique = true, nullable = false)
	public Integer getCountId() {
		return this.countId;
	}

	public void setCountId(Integer countId) {
		this.countId = countId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMMUNITY_HOSPITAL_ID")
	public TCommunityHospital getTCommunityHospital() {
		return this.TCommunityHospital;
	}

	public void setTCommunityHospital(TCommunityHospital TCommunityHospital) {
		this.TCommunityHospital = TCommunityHospital;
	}

	@Column(name = "DISEASE")
	public String getDisease() {
		return this.disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	@Column(name = "YEAR_MOUNTH")
	public String getYearMounth() {
		return this.yearMounth;
	}

	public void setYearMounth(String yearMounth) {
		this.yearMounth = yearMounth;
	}

	@Column(name = "NUM")
	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
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