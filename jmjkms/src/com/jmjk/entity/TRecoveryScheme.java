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
 * TRecoveryScheme entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_RECOVERY_SCHEME", catalog = "jmjk")
public class TRecoveryScheme implements java.io.Serializable {

	// Fields

	private Integer recoverySchemeId;
	private TStaff TStaff;
	private Integer communityHospitalId;
	private Integer groupId;
	private String type;
	private String disease;
	private String schemeName;
	private String recoveryPaln;
	private Timestamp constituteTime;
	private String note;
	private Integer idDelete;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private Set<TRecoveryPlan> TRecoveryPlans = new HashSet<TRecoveryPlan>(0);

	// Constructors

	/** default constructor */
	public TRecoveryScheme() {
	}

	/** minimal constructor */
	public TRecoveryScheme(String type, String disease, String schemeName,
			Timestamp constituteTime) {
		this.type = type;
		this.disease = disease;
		this.schemeName = schemeName;
		this.constituteTime = constituteTime;
	}

	/** full constructor */
	public TRecoveryScheme(TStaff TStaff, Integer communityHospitalId,
			String type, String disease, String schemeName,
			String recoveryPaln, Timestamp constituteTime, String note,
			Integer idDelete, String one, String two, String three,
			String four, String five, Set<TRecoveryPlan> TRecoveryPlans) {
		this.TStaff = TStaff;
		this.communityHospitalId = communityHospitalId;
		this.type = type;
		this.disease = disease;
		this.schemeName = schemeName;
		this.recoveryPaln = recoveryPaln;
		this.constituteTime = constituteTime;
		this.note = note;
		this.idDelete = idDelete;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.TRecoveryPlans = TRecoveryPlans;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "RECOVERY_SCHEME_ID", unique = true, nullable = false)
	public Integer getRecoverySchemeId() {
		return this.recoverySchemeId;
	}

	public void setRecoverySchemeId(Integer recoverySchemeId) {
		this.recoverySchemeId = recoverySchemeId;
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

	
	
	@Column(name = "GROUP_ID")
	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	@Column(name = "TYPE", nullable = false)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "DISEASE", nullable = false)
	public String getDisease() {
		return this.disease;
	}

	public void setDisease(String disease) {
		this.disease = disease;
	}

	@Column(name = "SCHEME_NAME", nullable = false)
	public String getSchemeName() {
		return this.schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	@Column(name = "RECOVERY_PALN", length = 65535)
	public String getRecoveryPaln() {
		return this.recoveryPaln;
	}

	public void setRecoveryPaln(String recoveryPaln) {
		this.recoveryPaln = recoveryPaln;
	}

	@Column(name = "CONSTITUTE_TIME", nullable = false, length = 19)
	public Timestamp getConstituteTime() {
		return this.constituteTime;
	}

	public void setConstituteTime(Timestamp constituteTime) {
		this.constituteTime = constituteTime;
	}

	@Column(name = "NOTE", length = 65535)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TRecoveryScheme")
	public Set<TRecoveryPlan> getTRecoveryPlans() {
		return this.TRecoveryPlans;
	}

	public void setTRecoveryPlans(Set<TRecoveryPlan> TRecoveryPlans) {
		this.TRecoveryPlans = TRecoveryPlans;
	}

}