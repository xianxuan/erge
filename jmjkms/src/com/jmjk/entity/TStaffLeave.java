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
 * TStaffLeave entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_STAFF_LEAVE", catalog = "jmjk")
public class TStaffLeave implements java.io.Serializable {

	// Fields

	private Integer staffLeaveId;
	private TStaff TStaff;
	private String leaveReason;
	private Timestamp leaveDate;
	private Double days;
	private Double actualDays;
	private Timestamp comebackDate;
	private String note;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TStaffLeave() {
	}

	/** minimal constructor */
	public TStaffLeave(TStaff TStaff, String leaveReason, Timestamp leaveDate) {
		this.TStaff = TStaff;
		this.leaveReason = leaveReason;
		this.leaveDate = leaveDate;
	}

	/** full constructor */
	public TStaffLeave(TStaff TStaff, String leaveReason, Timestamp leaveDate,
			Double days, Double actualDays, Timestamp comebackDate,
			String note, String one, String two, String three, String four,
			String five) {
		this.TStaff = TStaff;
		this.leaveReason = leaveReason;
		this.leaveDate = leaveDate;
		this.days = days;
		this.actualDays = actualDays;
		this.comebackDate = comebackDate;
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
	@Column(name = "STAFF_LEAVE_ID", unique = true, nullable = false)
	public Integer getStaffLeaveId() {
		return this.staffLeaveId;
	}

	public void setStaffLeaveId(Integer staffLeaveId) {
		this.staffLeaveId = staffLeaveId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STAFF_ID", nullable = false)
	public TStaff getTStaff() {
		return this.TStaff;
	}

	public void setTStaff(TStaff TStaff) {
		this.TStaff = TStaff;
	}

	@Column(name = "LEAVE_REASON", nullable = false, length = 65535)
	public String getLeaveReason() {
		return this.leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	@Column(name = "LEAVE_DATE", nullable = false, length = 19)
	public Timestamp getLeaveDate() {
		return this.leaveDate;
	}

	public void setLeaveDate(Timestamp leaveDate) {
		this.leaveDate = leaveDate;
	}

	@Column(name = "DAYS", precision = 22, scale = 0)
	public Double getDays() {
		return this.days;
	}

	public void setDays(Double days) {
		this.days = days;
	}

	@Column(name = "ACTUAL_DAYS", precision = 22, scale = 0)
	public Double getActualDays() {
		return this.actualDays;
	}

	public void setActualDays(Double actualDays) {
		this.actualDays = actualDays;
	}

	@Column(name = "COMEBACK_DATE", length = 19)
	public Timestamp getComebackDate() {
		return this.comebackDate;
	}

	public void setComebackDate(Timestamp comebackDate) {
		this.comebackDate = comebackDate;
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