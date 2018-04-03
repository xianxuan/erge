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
 * TKnowledgeLecture entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_KNOWLEDGE_LECTURE", catalog = "jmjk")
public class TKnowledgeLecture implements java.io.Serializable {

	// Fields

	private Integer knowledgeLectureId;
	private TStaff TStaff;
	private Integer communityHospitalId;
	private String lectureName;
	private String forPerson;
	private String participatePeople;
	private Timestamp planTime;
	private Timestamp formulateTime;
	private String note;
	private String status;
	private String content;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TKnowledgeLecture() {
	}

	/** minimal constructor */
	public TKnowledgeLecture(TStaff TStaff, String lectureName,
			Timestamp planTime) {
		this.TStaff = TStaff;
		this.lectureName = lectureName;
		this.planTime = planTime;
	}

	/** full constructor */
	public TKnowledgeLecture(TStaff TStaff, Integer communityHospitalId,
			String lectureName, String forPerson, String participatePeople,
			Timestamp planTime, Timestamp formulateTime, String note,
			String status, String content, String one, String two,
			String three, String four, String five) {
		this.TStaff = TStaff;
		this.communityHospitalId = communityHospitalId;
		this.lectureName = lectureName;
		this.forPerson = forPerson;
		this.participatePeople = participatePeople;
		this.planTime = planTime;
		this.formulateTime = formulateTime;
		this.note = note;
		this.status = status;
		this.content = content;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "KNOWLEDGE_LECTURE_ID", unique = true, nullable = false)
	public Integer getKnowledgeLectureId() {
		return this.knowledgeLectureId;
	}

	public void setKnowledgeLectureId(Integer knowledgeLectureId) {
		this.knowledgeLectureId = knowledgeLectureId;
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

	@Column(name = "LECTURE_NAME", nullable = false)
	public String getLectureName() {
		return this.lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	@Column(name = "FOR_PERSON")
	public String getForPerson() {
		return this.forPerson;
	}

	public void setForPerson(String forPerson) {
		this.forPerson = forPerson;
	}

	@Column(name = "PARTICIPATE_PEOPLE")
	public String getParticipatePeople() {
		return this.participatePeople;
	}

	public void setParticipatePeople(String participatePeople) {
		this.participatePeople = participatePeople;
	}

	@Column(name = "PLAN_TIME", nullable = false, length = 19)
	public Timestamp getPlanTime() {
		return this.planTime;
	}

	public void setPlanTime(Timestamp planTime) {
		this.planTime = planTime;
	}

	@Column(name = "FORMULATE_TIME", length = 19)
	public Timestamp getFormulateTime() {
		return this.formulateTime;
	}

	public void setFormulateTime(Timestamp formulateTime) {
		this.formulateTime = formulateTime;
	}

	@Column(name = "NOTE", length = 65535)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "STATUS", length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "CONTENT", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
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