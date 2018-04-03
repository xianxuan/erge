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
 * THealthEdu entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_HEALTH_EDU", catalog = "jmjk")
public class THealthEdu implements java.io.Serializable {

	// Fields

	private Integer healthEduId;
	private TStaff TStaff;
	private Integer communityHospitalId;
	private Timestamp activeTime;
	private String activePlace;
	private String activeType;
	private String organizer;
	private String activePeople;
	private Integer peopleNumber;
	private String peopleType;
	private String activeTheme;
	private String eduPeople;
	private String activeContent;
	private String activeEvalut;
	private String information;
	private Timestamp fillFormTime;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public THealthEdu() {
	}

	/** minimal constructor */
	public THealthEdu(TStaff TStaff, Timestamp activeTime, String activePlace,
			String activeTheme, Timestamp fillFormTime) {
		this.TStaff = TStaff;
		this.activeTime = activeTime;
		this.activePlace = activePlace;
		this.activeTheme = activeTheme;
		this.fillFormTime = fillFormTime;
	}

	/** full constructor */
	public THealthEdu(TStaff TStaff, Integer communityHospitalId,
			Timestamp activeTime, String activePlace, String activeType,
			String organizer, String activePeople, Integer peopleNumber,
			String peopleType, String activeTheme, String eduPeople,
			String activeContent, String activeEvalut, String information,
			Timestamp fillFormTime, String one, String two, String three,
			String four, String five) {
		this.TStaff = TStaff;
		this.communityHospitalId = communityHospitalId;
		this.activeTime = activeTime;
		this.activePlace = activePlace;
		this.activeType = activeType;
		this.organizer = organizer;
		this.activePeople = activePeople;
		this.peopleNumber = peopleNumber;
		this.peopleType = peopleType;
		this.activeTheme = activeTheme;
		this.eduPeople = eduPeople;
		this.activeContent = activeContent;
		this.activeEvalut = activeEvalut;
		this.information = information;
		this.fillFormTime = fillFormTime;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "HEALTH_EDU_ID", unique = true, nullable = false)
	public Integer getHealthEduId() {
		return this.healthEduId;
	}

	public void setHealthEduId(Integer healthEduId) {
		this.healthEduId = healthEduId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STAFF_ID", nullable = false)
	public TStaff getTStaff() {
		return this.TStaff;
	}

	public void setTStaff(TStaff TStaff) {
		this.TStaff = TStaff;
	}

	@Column(name = "COMMUNITY_HOSPITAL_ID")
	public Integer getCommunityHospitalId() {
		return this.communityHospitalId;
	}

	public void setCommunityHospitalId(Integer communityHospitalId) {
		this.communityHospitalId = communityHospitalId;
	}

	@Column(name = "ACTIVE_TIME", nullable = false, length = 19)
	public Timestamp getActiveTime() {
		return this.activeTime;
	}

	public void setActiveTime(Timestamp activeTime) {
		this.activeTime = activeTime;
	}

	@Column(name = "ACTIVE_PLACE", nullable = false)
	public String getActivePlace() {
		return this.activePlace;
	}

	public void setActivePlace(String activePlace) {
		this.activePlace = activePlace;
	}

	@Column(name = "ACTIVE_TYPE")
	public String getActiveType() {
		return this.activeType;
	}

	public void setActiveType(String activeType) {
		this.activeType = activeType;
	}

	@Column(name = "ORGANIZER")
	public String getOrganizer() {
		return this.organizer;
	}

	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}

	@Column(name = "ACTIVE_PEOPLE")
	public String getActivePeople() {
		return this.activePeople;
	}

	public void setActivePeople(String activePeople) {
		this.activePeople = activePeople;
	}

	@Column(name = "PEOPLE_NUMBER")
	public Integer getPeopleNumber() {
		return this.peopleNumber;
	}

	public void setPeopleNumber(Integer peopleNumber) {
		this.peopleNumber = peopleNumber;
	}

	@Column(name = "PEOPLE_TYPE")
	public String getPeopleType() {
		return this.peopleType;
	}

	public void setPeopleType(String peopleType) {
		this.peopleType = peopleType;
	}

	@Column(name = "ACTIVE_THEME", nullable = false)
	public String getActiveTheme() {
		return this.activeTheme;
	}

	public void setActiveTheme(String activeTheme) {
		this.activeTheme = activeTheme;
	}

	@Column(name = "EDU_PEOPLE")
	public String getEduPeople() {
		return this.eduPeople;
	}

	public void setEduPeople(String eduPeople) {
		this.eduPeople = eduPeople;
	}

	@Column(name = "ACTIVE_CONTENT", length = 65535)
	public String getActiveContent() {
		return this.activeContent;
	}

	public void setActiveContent(String activeContent) {
		this.activeContent = activeContent;
	}

	@Column(name = "ACTIVE_EVALUT", length = 65535)
	public String getActiveEvalut() {
		return this.activeEvalut;
	}

	public void setActiveEvalut(String activeEvalut) {
		this.activeEvalut = activeEvalut;
	}

	@Column(name = "INFORMATION", length = 1000)
	public String getInformation() {
		return this.information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	@Column(name = "FILL_FORM_TIME", nullable = false, length = 19)
	public Timestamp getFillFormTime() {
		return this.fillFormTime;
	}

	public void setFillFormTime(Timestamp fillFormTime) {
		this.fillFormTime = fillFormTime;
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