package com.jmjk.entity;
// default package

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TRecoveryPlan entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RECOVERY_PLAN", catalog = "jmjk")
public class TRecoveryPlan implements java.io.Serializable {

	// Fields

	private Integer recoveryPlanId;
	private TRecoveryScheme TRecoveryScheme;
	private TStaff TStaff;
	private Integer communityHospitalId;
	private String planName;
	private Timestamp beginTime;
	private Timestamp overTime;
	private String status;
	private Timestamp constituteTime;
	private String planContent;
	private String operation;
	private Integer idDelete;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private Set<TRecoveryOld> TRecoveryOlds = new HashSet<TRecoveryOld>(0);

	// Constructors

	/** default constructor */
	public TRecoveryPlan() {
	}

	public TRecoveryPlan(int planId){
		this.recoveryPlanId=planId;
	}
	/** minimal constructor */
	public TRecoveryPlan(TRecoveryScheme TRecoveryScheme, String planName,
			Timestamp beginTime, Timestamp overTime, String status,
			Timestamp constituteTime) {
		this.TRecoveryScheme = TRecoveryScheme;
		this.planName = planName;
		this.beginTime = beginTime;
		this.overTime = overTime;
		this.status = status;
		this.constituteTime = constituteTime;
	}

	/** full constructor */
	public TRecoveryPlan(TRecoveryScheme TRecoveryScheme, TStaff TStaff,
			Integer communityHospitalId, String planName, Timestamp beginTime,
			Timestamp overTime, String status, Timestamp constituteTime,
			String planContent, String operation, Integer idDelete, String one,
			String two, String three, String four, String five,
			Set<TRecoveryOld> TRecoveryOlds) {
		this.TRecoveryScheme = TRecoveryScheme;
		this.TStaff = TStaff;
		this.communityHospitalId = communityHospitalId;
		this.planName = planName;
		this.beginTime = beginTime;
		this.overTime = overTime;
		this.status = status;
		this.constituteTime = constituteTime;
		this.planContent = planContent;
		this.operation = operation;
		this.idDelete = idDelete;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.TRecoveryOlds = TRecoveryOlds;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "RECOVERY_PLAN_ID", unique = true, nullable = false)
	public Integer getRecoveryPlanId() {
		return this.recoveryPlanId;
	}

	public void setRecoveryPlanId(Integer recoveryPlanId) {
		this.recoveryPlanId = recoveryPlanId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCHEME_ID", nullable = false)
	public TRecoveryScheme getTRecoveryScheme() {
		return this.TRecoveryScheme;
	}

	public void setTRecoveryScheme(TRecoveryScheme TRecoveryScheme) {
		this.TRecoveryScheme = TRecoveryScheme;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STAFF_ID")
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

	@Column(name = "PLAN_NAME", nullable = false)
	public String getPlanName() {
		return this.planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	@Column(name = "BEGIN_TIME", nullable = false, length = 19)
	public Timestamp getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Timestamp beginTime) {
		this.beginTime = beginTime;
	}

	@Column(name = "OVER_TIME", nullable = false, length = 19)
	public Timestamp getOverTime() {
		return this.overTime;
	}

	public void setOverTime(Timestamp overTime) {
		this.overTime = overTime;
	}

	@Column(name = "STATUS", nullable = false, length = 1)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "CONSTITUTE_TIME", nullable = false, length = 19)
	public Timestamp getConstituteTime() {
		return this.constituteTime;
	}

	public void setConstituteTime(Timestamp constituteTime) {
		this.constituteTime = constituteTime;
	}

	@Column(name = "PLAN_CONTENT", length = 65535)
	public String getPlanContent() {
		return this.planContent;
	}

	public void setPlanContent(String planContent) {
		this.planContent = planContent;
	}

	@Column(name = "OPERATION", length = 1)
	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Column(name = "ID_DELETE")
	public Integer getIdDelete() {
		return this.idDelete;
	}

	public void setIdDelete(Integer idDelete) {
		this.idDelete = idDelete;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TRecoveryPlan")
	public Set<TRecoveryOld> getTRecoveryOlds() {
		return this.TRecoveryOlds;
	}

	public void setTRecoveryOlds(Set<TRecoveryOld> TRecoveryOlds) {
		this.TRecoveryOlds = TRecoveryOlds;
	}

}