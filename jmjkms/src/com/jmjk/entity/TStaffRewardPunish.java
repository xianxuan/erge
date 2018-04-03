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
 * TStaffRewardPunish entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_STAFF_REWARD_PUNISH", catalog = "jmjk")
public class TStaffRewardPunish implements java.io.Serializable {

	// Fields

	private Integer staffRewardPunishId;
	private TStaff TStaff;
	private Timestamp operateDate;
	private Timestamp rewardPunishDate;
	private String rewordPunishType;
	private String rewordPunishReason;
	private Double rewordPunishAmount;
	private String note;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TStaffRewardPunish() {
	}

	/** minimal constructor */
	public TStaffRewardPunish(TStaff TStaff, String rewordPunishType) {
		this.TStaff = TStaff;
		this.rewordPunishType = rewordPunishType;
	}

	/** full constructor */
	public TStaffRewardPunish(TStaff TStaff, Timestamp operateDate,
			Timestamp rewardPunishDate, String rewordPunishType,
			String rewordPunishReason, Double rewordPunishAmount, String note,
			String one, String two, String three, String four, String five) {
		this.TStaff = TStaff;
		this.operateDate = operateDate;
		this.rewardPunishDate = rewardPunishDate;
		this.rewordPunishType = rewordPunishType;
		this.rewordPunishReason = rewordPunishReason;
		this.rewordPunishAmount = rewordPunishAmount;
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
	@Column(name = "STAFF_REWARD_PUNISH_ID", unique = true, nullable = false)
	public Integer getStaffRewardPunishId() {
		return this.staffRewardPunishId;
	}

	public void setStaffRewardPunishId(Integer staffRewardPunishId) {
		this.staffRewardPunishId = staffRewardPunishId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STAFF_ID", nullable = false)
	public TStaff getTStaff() {
		return this.TStaff;
	}

	public void setTStaff(TStaff TStaff) {
		this.TStaff = TStaff;
	}

	@Column(name = "OPERATE_DATE", length = 19)
	public Timestamp getOperateDate() {
		return this.operateDate;
	}

	public void setOperateDate(Timestamp operateDate) {
		this.operateDate = operateDate;
	}

	@Column(name = "REWARD_PUNISH_DATE", length = 19)
	public Timestamp getRewardPunishDate() {
		return this.rewardPunishDate;
	}

	public void setRewardPunishDate(Timestamp rewardPunishDate) {
		this.rewardPunishDate = rewardPunishDate;
	}

	@Column(name = "REWORD_PUNISH_TYPE", nullable = false)
	public String getRewordPunishType() {
		return this.rewordPunishType;
	}

	public void setRewordPunishType(String rewordPunishType) {
		this.rewordPunishType = rewordPunishType;
	}

	@Column(name = "REWORD_PUNISH_REASON", length = 65535)
	public String getRewordPunishReason() {
		return this.rewordPunishReason;
	}

	public void setRewordPunishReason(String rewordPunishReason) {
		this.rewordPunishReason = rewordPunishReason;
	}

	@Column(name = "REWORD_PUNISH_AMOUNT", precision = 22, scale = 0)
	public Double getRewordPunishAmount() {
		return this.rewordPunishAmount;
	}

	public void setRewordPunishAmount(Double rewordPunishAmount) {
		this.rewordPunishAmount = rewordPunishAmount;
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