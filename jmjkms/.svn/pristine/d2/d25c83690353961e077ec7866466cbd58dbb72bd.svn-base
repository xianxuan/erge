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
 * TDoorKnocking entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_DOOR_KNOCKING", catalog = "jmjk")
public class TDoorKnocking implements java.io.Serializable {

	// Fields

	private Integer doorKnockingId;
	private TStaff TStaff;
	private Integer communityHospitalId;
	private String visiteName;
	private String visitePeople;
	private Timestamp planTime;
	private Timestamp formulateTime;
	private String participatePeople;
	private String status;
	private String content;
	private String note;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TDoorKnocking() {
	}

	/** minimal constructor */
	public TDoorKnocking(TStaff TStaff, String visiteName, Timestamp planTime) {
		this.TStaff = TStaff;
		this.visiteName = visiteName;
		this.planTime = planTime;
	}

	/** full constructor */
	public TDoorKnocking(TStaff TStaff, Integer communityHospitalId,
			String visiteName, String visitePeople, Timestamp planTime,
			Timestamp formulateTime, String participatePeople, String status,
			String content, String note, String one, String two, String three,
			String four, String five) {
		this.TStaff = TStaff;
		this.communityHospitalId = communityHospitalId;
		this.visiteName = visiteName;
		this.visitePeople = visitePeople;
		this.planTime = planTime;
		this.formulateTime = formulateTime;
		this.participatePeople = participatePeople;
		this.status = status;
		this.content = content;
		this.note = note;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "DOOR_KNOCKING_ID", unique = true, nullable = false)
	public Integer getDoorKnockingId() {
		return this.doorKnockingId;
	}

	public void setDoorKnockingId(Integer doorKnockingId) {
		this.doorKnockingId = doorKnockingId;
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

	@Column(name = "VISITE_NAME", nullable = false)
	public String getVisiteName() {
		return this.visiteName;
	}

	public void setVisiteName(String visiteName) {
		this.visiteName = visiteName;
	}

	@Column(name = "VISITE_PEOPLE")
	public String getVisitePeople() {
		return this.visitePeople;
	}

	public void setVisitePeople(String visitePeople) {
		this.visitePeople = visitePeople;
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

	@Column(name = "PARTICIPATE_PEOPLE")
	public String getParticipatePeople() {
		return this.participatePeople;
	}

	public void setParticipatePeople(String participatePeople) {
		this.participatePeople = participatePeople;
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

}