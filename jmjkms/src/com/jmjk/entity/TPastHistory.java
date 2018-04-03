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
 * TPastHistory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_PAST_HISTORY", catalog = "jmjk")
public class TPastHistory implements java.io.Serializable {

	// Fields

	private Integer pastHistoryId;
	private THealthFile THealthFile;
	private String pastType;
	private String pastName;
	private Timestamp pastDate;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TPastHistory() {
	}

	/** minimal constructor */
	public TPastHistory(THealthFile THealthFile) {
		this.THealthFile = THealthFile;
	}

	/** full constructor */
	public TPastHistory(THealthFile THealthFile, String pastType,
			String pastName, Timestamp pastDate, String one, String two,
			String three, String four, String five) {
		this.THealthFile = THealthFile;
		this.pastType = pastType;
		this.pastName = pastName;
		this.pastDate = pastDate;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "PAST_HISTORY_ID", unique = true, nullable = false)
	public Integer getPastHistoryId() {
		return this.pastHistoryId;
	}

	public void setPastHistoryId(Integer pastHistoryId) {
		this.pastHistoryId = pastHistoryId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HEALTH_FILE_ID", nullable = false)
	public THealthFile getTHealthFile() {
		return this.THealthFile;
	}

	public void setTHealthFile(THealthFile THealthFile) {
		this.THealthFile = THealthFile;
	}

	@Column(name = "PAST_TYPE")
	public String getPastType() {
		return this.pastType;
	}

	public void setPastType(String pastType) {
		this.pastType = pastType;
	}

	@Column(name = "PAST_NAME")
	public String getPastName() {
		return this.pastName;
	}

	public void setPastName(String pastName) {
		this.pastName = pastName;
	}

	@Column(name = "PAST_DATE", length = 19)
	public Timestamp getPastDate() {
		return this.pastDate;
	}

	public void setPastDate(Timestamp pastDate) {
		this.pastDate = pastDate;
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