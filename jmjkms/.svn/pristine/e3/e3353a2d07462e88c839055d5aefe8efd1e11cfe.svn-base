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
 * TDualReferralRecord entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_DUAL_REFERRAL_RECORD", catalog = "jmjk")
public class TDualReferralRecord implements java.io.Serializable {

	// Fields

	private Integer dualRefRecId;
	private THealthFile THealthFile;
	private Timestamp outTime;
	private String outUnit;
	private String outReferralDoctor;
	private String outPhone;
	private String goUnit;
	private String goDepartment;
	private String outAcceptDoctor;
	private String impression;
	private String outReason;
	private String pastHistory;
	private String treatment;
	private Timestamp cbTime;
	private String cbReferralDoctor;
	private String cbAcceptDoctor;
	private String result;
	private String cbPhone;
	private String checkResult;
	private String goThroughNextAdvice;
	private String medicalNum;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TDualReferralRecord() {
	}

	/** minimal constructor */
	public TDualReferralRecord(THealthFile THealthFile) {
		this.THealthFile = THealthFile;
	}

	/** full constructor */
	public TDualReferralRecord(THealthFile THealthFile, Timestamp outTime,
			String outUnit, String outReferralDoctor, String outPhone,
			String goUnit, String goDepartment, String outAcceptDoctor,
			String impression, String outReason, String pastHistory,
			String treatment, Timestamp cbTime, String cbReferralDoctor,
			String cbAcceptDoctor, String result, String cbPhone,
			String checkResult, String goThroughNextAdvice, String medicalNum,
			String one, String two, String three, String four, String five) {
		this.THealthFile = THealthFile;
		this.outTime = outTime;
		this.outUnit = outUnit;
		this.outReferralDoctor = outReferralDoctor;
		this.outPhone = outPhone;
		this.goUnit = goUnit;
		this.goDepartment = goDepartment;
		this.outAcceptDoctor = outAcceptDoctor;
		this.impression = impression;
		this.outReason = outReason;
		this.pastHistory = pastHistory;
		this.treatment = treatment;
		this.cbTime = cbTime;
		this.cbReferralDoctor = cbReferralDoctor;
		this.cbAcceptDoctor = cbAcceptDoctor;
		this.result = result;
		this.cbPhone = cbPhone;
		this.checkResult = checkResult;
		this.goThroughNextAdvice = goThroughNextAdvice;
		this.medicalNum = medicalNum;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "DUAL_REF_REC_ID", unique = true, nullable = false)
	public Integer getDualRefRecId() {
		return this.dualRefRecId;
	}

	public void setDualRefRecId(Integer dualRefRecId) {
		this.dualRefRecId = dualRefRecId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HEALTH_FILE_ID", nullable = false)
	public THealthFile getTHealthFile() {
		return this.THealthFile;
	}

	public void setTHealthFile(THealthFile THealthFile) {
		this.THealthFile = THealthFile;
	}

	@Column(name = "OUT_TIME", length = 19)
	public Timestamp getOutTime() {
		return this.outTime;
	}

	public void setOutTime(Timestamp outTime) {
		this.outTime = outTime;
	}

	@Column(name = "OUT_UNIT")
	public String getOutUnit() {
		return this.outUnit;
	}

	public void setOutUnit(String outUnit) {
		this.outUnit = outUnit;
	}

	@Column(name = "OUT_REFERRAL_DOCTOR")
	public String getOutReferralDoctor() {
		return this.outReferralDoctor;
	}

	public void setOutReferralDoctor(String outReferralDoctor) {
		this.outReferralDoctor = outReferralDoctor;
	}

	@Column(name = "OUT_PHONE")
	public String getOutPhone() {
		return this.outPhone;
	}

	public void setOutPhone(String outPhone) {
		this.outPhone = outPhone;
	}

	@Column(name = "GO_UNIT")
	public String getGoUnit() {
		return this.goUnit;
	}

	public void setGoUnit(String goUnit) {
		this.goUnit = goUnit;
	}

	@Column(name = "GO_DEPARTMENT")
	public String getGoDepartment() {
		return this.goDepartment;
	}

	public void setGoDepartment(String goDepartment) {
		this.goDepartment = goDepartment;
	}

	@Column(name = "OUT_ACCEPT_DOCTOR")
	public String getOutAcceptDoctor() {
		return this.outAcceptDoctor;
	}

	public void setOutAcceptDoctor(String outAcceptDoctor) {
		this.outAcceptDoctor = outAcceptDoctor;
	}

	@Column(name = "IMPRESSION", length = 65535)
	public String getImpression() {
		return this.impression;
	}

	public void setImpression(String impression) {
		this.impression = impression;
	}

	@Column(name = "OUT_REASON", length = 65535)
	public String getOutReason() {
		return this.outReason;
	}

	public void setOutReason(String outReason) {
		this.outReason = outReason;
	}

	@Column(name = "PAST_HISTORY", length = 65535)
	public String getPastHistory() {
		return this.pastHistory;
	}

	public void setPastHistory(String pastHistory) {
		this.pastHistory = pastHistory;
	}

	@Column(name = "TREATMENT", length = 65535)
	public String getTreatment() {
		return this.treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	@Column(name = "CB_TIME", length = 19)
	public Timestamp getCbTime() {
		return this.cbTime;
	}

	public void setCbTime(Timestamp cbTime) {
		this.cbTime = cbTime;
	}

	@Column(name = "CB_REFERRAL_DOCTOR")
	public String getCbReferralDoctor() {
		return this.cbReferralDoctor;
	}

	public void setCbReferralDoctor(String cbReferralDoctor) {
		this.cbReferralDoctor = cbReferralDoctor;
	}

	@Column(name = "CB_ACCEPT_DOCTOR")
	public String getCbAcceptDoctor() {
		return this.cbAcceptDoctor;
	}

	public void setCbAcceptDoctor(String cbAcceptDoctor) {
		this.cbAcceptDoctor = cbAcceptDoctor;
	}

	@Column(name = "RESULT", length = 65535)
	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Column(name = "CB_PHONE")
	public String getCbPhone() {
		return this.cbPhone;
	}

	public void setCbPhone(String cbPhone) {
		this.cbPhone = cbPhone;
	}

	@Column(name = "CHECK_RESULT", length = 65535)
	public String getCheckResult() {
		return this.checkResult;
	}

	public void setCheckResult(String checkResult) {
		this.checkResult = checkResult;
	}

	@Column(name = "GO_THROUGH_NEXT_ADVICE", length = 65535)
	public String getGoThroughNextAdvice() {
		return this.goThroughNextAdvice;
	}

	public void setGoThroughNextAdvice(String goThroughNextAdvice) {
		this.goThroughNextAdvice = goThroughNextAdvice;
	}

	@Column(name = "MEDICAL_NUM")
	public String getMedicalNum() {
		return this.medicalNum;
	}

	public void setMedicalNum(String medicalNum) {
		this.medicalNum = medicalNum;
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