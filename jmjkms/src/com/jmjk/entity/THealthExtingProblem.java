package com.jmjk.entity;
// default package

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * THealthExtingProblem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_HEALTH_EXTING_PROBLEM", catalog = "jmjk")
public class THealthExtingProblem implements java.io.Serializable {

	// Fields

	private Integer healthExistingProblemsId;
	private String cerebrovascularDisease;
	private String kidneyDisease;
	private String vascularDisease;
	private String ophthalmicDiseases;
	private String nervousSystemDisease;
	private String otherNeurologicalDisorders;
	private String heartDiseases;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private Set<TPhysicalExam> TPhysicalExams = new HashSet<TPhysicalExam>(0);

	// Constructors

	/** default constructor */
	public THealthExtingProblem() {
	}
	public THealthExtingProblem(Integer healthExistingProblemsId) {
	    this.healthExistingProblemsId=healthExistingProblemsId;
    }
	/** full constructor */
	public THealthExtingProblem(String cerebrovascularDisease,
			String kidneyDisease, String vascularDisease,
			String ophthalmicDiseases, String nervousSystemDisease,
			String otherNeurologicalDisorders, String heartDiseases,
			String one, String two, String three, String four, String five,
			Set<TPhysicalExam> TPhysicalExams) {
		this.cerebrovascularDisease = cerebrovascularDisease;
		this.kidneyDisease = kidneyDisease;
		this.vascularDisease = vascularDisease;
		this.ophthalmicDiseases = ophthalmicDiseases;
		this.nervousSystemDisease = nervousSystemDisease;
		this.otherNeurologicalDisorders = otherNeurologicalDisorders;
		this.heartDiseases = heartDiseases;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.TPhysicalExams = TPhysicalExams;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "HEALTH_EXISTING_PROBLEMS_ID", unique = true, nullable = false)
	public Integer getHealthExistingProblemsId() {
		return this.healthExistingProblemsId;
	}

	public void setHealthExistingProblemsId(Integer healthExistingProblemsId) {
		this.healthExistingProblemsId = healthExistingProblemsId;
	}

	@Column(name = "CEREBROVASCULAR_DISEASE")
	public String getCerebrovascularDisease() {
		return this.cerebrovascularDisease;
	}

	public void setCerebrovascularDisease(String cerebrovascularDisease) {
		this.cerebrovascularDisease = cerebrovascularDisease;
	}

	@Column(name = "KIDNEY_DISEASE")
	public String getKidneyDisease() {
		return this.kidneyDisease;
	}

	public void setKidneyDisease(String kidneyDisease) {
		this.kidneyDisease = kidneyDisease;
	}

	@Column(name = "VASCULAR_DISEASE")
	public String getVascularDisease() {
		return this.vascularDisease;
	}

	public void setVascularDisease(String vascularDisease) {
		this.vascularDisease = vascularDisease;
	}

	@Column(name = "OPHTHALMIC_DISEASES")
	public String getOphthalmicDiseases() {
		return this.ophthalmicDiseases;
	}

	public void setOphthalmicDiseases(String ophthalmicDiseases) {
		this.ophthalmicDiseases = ophthalmicDiseases;
	}

	@Column(name = "NERVOUS_SYSTEM_DISEASE")
	public String getNervousSystemDisease() {
		return this.nervousSystemDisease;
	}

	public void setNervousSystemDisease(String nervousSystemDisease) {
		this.nervousSystemDisease = nervousSystemDisease;
	}

	@Column(name = "OTHER_NEUROLOGICAL_DISORDERS")
	public String getOtherNeurologicalDisorders() {
		return this.otherNeurologicalDisorders;
	}

	public void setOtherNeurologicalDisorders(String otherNeurologicalDisorders) {
		this.otherNeurologicalDisorders = otherNeurologicalDisorders;
	}

	@Column(name = "HEART_DISEASES")
	public String getHeartDiseases() {
		return this.heartDiseases;
	}

	public void setHeartDiseases(String heartDiseases) {
		this.heartDiseases = heartDiseases;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "THealthExtingProblem")
	public Set<TPhysicalExam> getTPhysicalExams() {
		return this.TPhysicalExams;
	}

	public void setTPhysicalExams(Set<TPhysicalExam> TPhysicalExams) {
		this.TPhysicalExams = TPhysicalExams;
	}

}