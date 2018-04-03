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
 * TIncompleteRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_INCOMPLETE_RECORD", catalog = "jmjk")
public class TIncompleteRecord implements java.io.Serializable {

	// Fields

	private Integer incompleteRecordId;
	private THealthFile THealthFile;
	private Timestamp incompleteRecordDate;
	private String incompleteDoctor;
	private String subInfor;
	private String objInfor;
	private String assess;
	private String disposalPlan;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TIncompleteRecord() {
	}

	/** minimal constructor */
	public TIncompleteRecord(THealthFile THealthFile) {
		this.THealthFile = THealthFile;
	}

	/** full constructor */
	public TIncompleteRecord(THealthFile THealthFile,
			Timestamp incompleteRecordDate, String incompleteDoctor,
			String subInfor, String objInfor, String assess,
			String disposalPlan, String one, String two, String three,
			String four, String five) {
		this.THealthFile = THealthFile;
		this.incompleteRecordDate = incompleteRecordDate;
		this.incompleteDoctor = incompleteDoctor;
		this.subInfor = subInfor;
		this.objInfor = objInfor;
		this.assess = assess;
		this.disposalPlan = disposalPlan;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "INCOMPLETE_RECORD_ID", unique = true, nullable = false)
	public Integer getIncompleteRecordId() {
		return this.incompleteRecordId;
	}

	public void setIncompleteRecordId(Integer incompleteRecordId) {
		this.incompleteRecordId = incompleteRecordId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HEALTH_FILE_ID", nullable = false)
	public THealthFile getTHealthFile() {
		return this.THealthFile;
	}

	public void setTHealthFile(THealthFile THealthFile) {
		this.THealthFile = THealthFile;
	}

	@Column(name = "INCOMPLETE_RECORD_DATE", length = 19)
	public Timestamp getIncompleteRecordDate() {
		return this.incompleteRecordDate;
	}

	public void setIncompleteRecordDate(Timestamp incompleteRecordDate) {
		this.incompleteRecordDate = incompleteRecordDate;
	}

	@Column(name = "INCOMPLETE_DOCTOR")
	public String getIncompleteDoctor() {
		return this.incompleteDoctor;
	}

	public void setIncompleteDoctor(String incompleteDoctor) {
		this.incompleteDoctor = incompleteDoctor;
	}

	@Column(name = "SUB_INFOR", length = 65535)
	public String getSubInfor() {
		return this.subInfor;
	}

	public void setSubInfor(String subInfor) {
		this.subInfor = subInfor;
	}

	@Column(name = "OBJ_INFOR", length = 65535)
	public String getObjInfor() {
		return this.objInfor;
	}

	public void setObjInfor(String objInfor) {
		this.objInfor = objInfor;
	}

	@Column(name = "ASSESS", length = 65535)
	public String getAssess() {
		return this.assess;
	}

	public void setAssess(String assess) {
		this.assess = assess;
	}

	@Column(name = "DISPOSAL_PLAN", length = 65535)
	public String getDisposalPlan() {
		return this.disposalPlan;
	}

	public void setDisposalPlan(String disposalPlan) {
		this.disposalPlan = disposalPlan;
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