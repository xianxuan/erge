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
 * TComminityClinic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_COMMINITY_CLINIC", catalog = "jmjk")
public class TComminityClinic implements java.io.Serializable {

	// Fields

	private Integer comminityClinicId;
	private TStaff TStaff;
	private Integer communityHospitalId;
	private String forPerson;
	private Timestamp formulateTime2;
	private Timestamp planTime;
	private String participatePerson;
	private Timestamp formulateTime;
	private String note;
	private String content;
	private String status;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TComminityClinic() {
	}

	/** minimal constructor */
	public TComminityClinic(TStaff TStaff, Timestamp planTime) {
		this.TStaff = TStaff;
		this.planTime = planTime;
	}

	/** full constructor */
	public TComminityClinic(TStaff TStaff, Integer communityHospitalId,
			String forPerson, Timestamp formulateTime2, Timestamp planTime,
			String participatePerson, Timestamp formulateTime, String note,
			String content, String status, String one, String two,
			String three, String four, String five) {
		this.TStaff = TStaff;
		this.communityHospitalId = communityHospitalId;
		this.forPerson = forPerson;
		this.formulateTime2 = formulateTime2;
		this.planTime = planTime;
		this.participatePerson = participatePerson;
		this.formulateTime = formulateTime;
		this.note = note;
		this.content = content;
		this.status = status;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "COMMINITY_CLINIC_ID", unique = true, nullable = false)
	public Integer getComminityClinicId() {
		return this.comminityClinicId;
	}

	public void setComminityClinicId(Integer comminityClinicId) {
		this.comminityClinicId = comminityClinicId;
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

	@Column(name = "FOR_PERSON")
	public String getForPerson() {
		return this.forPerson;
	}

	public void setForPerson(String forPerson) {
		this.forPerson = forPerson;
	}

	@Column(name = "FORMULATE_TIME2", length = 19)
	public Timestamp getFormulateTime2() {
		return this.formulateTime2;
	}

	public void setFormulateTime2(Timestamp formulateTime2) {
		this.formulateTime2 = formulateTime2;
	}

	@Column(name = "PLAN_TIME", nullable = false, length = 19)
	public Timestamp getPlanTime() {
		return this.planTime;
	}

	public void setPlanTime(Timestamp planTime) {
		this.planTime = planTime;
	}

	@Column(name = "PARTICIPATE_PERSON")
	public String getParticipatePerson() {
		return this.participatePerson;
	}

	public void setParticipatePerson(String participatePerson) {
		this.participatePerson = participatePerson;
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

	@Column(name = "CONTENT", length = 65535)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
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

}