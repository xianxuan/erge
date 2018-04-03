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
 * TRecoveryOld entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RECOVERY_OLD", catalog = "jmjk")
public class TRecoveryOld implements java.io.Serializable {

	// Fields

	private Integer recoveryOldId;
	private THealthFile THealthFile;
	private TRecoveryPlan TRecoveryPlan;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TRecoveryOld() {
	}

	/** full constructor */
	public TRecoveryOld(THealthFile THealthFile, TRecoveryPlan TRecoveryPlan,
			String one, String two, String three, String four, String five) {
		this.THealthFile = THealthFile;
		this.TRecoveryPlan = TRecoveryPlan;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "RECOVERY_OLD_ID", unique = true, nullable = false)
	public Integer getRecoveryOldId() {
		return this.recoveryOldId;
	}

	public void setRecoveryOldId(Integer recoveryOldId) {
		this.recoveryOldId = recoveryOldId;
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
	@JoinColumn(name = "REPL_ID")
	public TRecoveryPlan getTRecoveryPlan() {
		return this.TRecoveryPlan;
	}

	public void setTRecoveryPlan(TRecoveryPlan TRecoveryPlan) {
		this.TRecoveryPlan = TRecoveryPlan;
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