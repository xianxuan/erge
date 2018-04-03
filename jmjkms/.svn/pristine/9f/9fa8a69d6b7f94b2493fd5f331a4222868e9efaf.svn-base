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
 * TChinaMedicine entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_CHINA_MEDICINE", catalog = "jmjk")
public class TChinaMedicine implements java.io.Serializable {

	// Fields

	private Integer chinaMedicineId;
	private String deficiency;
	private String deficiencyGuidance;
	private String qiDeficiency;
	private String qiDeficiencyGuidance;
	private String yangDeficiency;
	private String yangDeficiencyGuidance;
	private String yingDecifiency;
	private String yingDecifiencyGuidance;
	private String phlegmDampness;
	private String phlegmDampnessGuidance;
	private String dampHeatConstitution;
	private String dampHeatConstitutionGuidance;
	private String bloodySputum;
	private String bloodySputumGuidance;
	private String qiStagnation;
	private String qiStagnationGuidance;
	private String grasp;
	private String graspGuidance;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private Set<TPhysicalExam> TPhysicalExams = new HashSet<TPhysicalExam>(0);

	// Constructors

	/** default constructor */
	public TChinaMedicine() {
	}
	public TChinaMedicine(Integer chinaMedicineId) {
	    this.chinaMedicineId=chinaMedicineId;
    }
	/** full constructor */
	public TChinaMedicine(String deficiency, String deficiencyGuidance,
			String qiDeficiency, String qiDeficiencyGuidance,
			String yangDeficiency, String yangDeficiencyGuidance,
			String yingDecifiency, String yingDecifiencyGuidance,
			String phlegmDampness, String phlegmDampnessGuidance,
			String dampHeatConstitution, String dampHeatConstitutionGuidance,
			String bloodySputum, String bloodySputumGuidance,
			String qiStagnation, String qiStagnationGuidance, String grasp,
			String graspGuidance, String one, String two, String three,
			String four, String five, Set<TPhysicalExam> TPhysicalExams) {
		this.deficiency = deficiency;
		this.deficiencyGuidance = deficiencyGuidance;
		this.qiDeficiency = qiDeficiency;
		this.qiDeficiencyGuidance = qiDeficiencyGuidance;
		this.yangDeficiency = yangDeficiency;
		this.yangDeficiencyGuidance = yangDeficiencyGuidance;
		this.yingDecifiency = yingDecifiency;
		this.yingDecifiencyGuidance = yingDecifiencyGuidance;
		this.phlegmDampness = phlegmDampness;
		this.phlegmDampnessGuidance = phlegmDampnessGuidance;
		this.dampHeatConstitution = dampHeatConstitution;
		this.dampHeatConstitutionGuidance = dampHeatConstitutionGuidance;
		this.bloodySputum = bloodySputum;
		this.bloodySputumGuidance = bloodySputumGuidance;
		this.qiStagnation = qiStagnation;
		this.qiStagnationGuidance = qiStagnationGuidance;
		this.grasp = grasp;
		this.graspGuidance = graspGuidance;
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
	@Column(name = "CHINA_MEDICINE_ID", unique = true, nullable = false)
	public Integer getChinaMedicineId() {
		return this.chinaMedicineId;
	}

	public void setChinaMedicineId(Integer chinaMedicineId) {
		this.chinaMedicineId = chinaMedicineId;
	}

	@Column(name = "DEFICIENCY")
	public String getDeficiency() {
		return this.deficiency;
	}

	public void setDeficiency(String deficiency) {
		this.deficiency = deficiency;
	}

	@Column(name = "DEFICIENCY_GUIDANCE", length = 65535)
	public String getDeficiencyGuidance() {
		return this.deficiencyGuidance;
	}

	public void setDeficiencyGuidance(String deficiencyGuidance) {
		this.deficiencyGuidance = deficiencyGuidance;
	}

	@Column(name = "QI_DEFICIENCY")
	public String getQiDeficiency() {
		return this.qiDeficiency;
	}

	public void setQiDeficiency(String qiDeficiency) {
		this.qiDeficiency = qiDeficiency;
	}

	@Column(name = "QI_DEFICIENCY_GUIDANCE", length = 65535)
	public String getQiDeficiencyGuidance() {
		return this.qiDeficiencyGuidance;
	}

	public void setQiDeficiencyGuidance(String qiDeficiencyGuidance) {
		this.qiDeficiencyGuidance = qiDeficiencyGuidance;
	}

	@Column(name = "YANG_DEFICIENCY")
	public String getYangDeficiency() {
		return this.yangDeficiency;
	}

	public void setYangDeficiency(String yangDeficiency) {
		this.yangDeficiency = yangDeficiency;
	}

	@Column(name = "YANG_DEFICIENCY_GUIDANCE", length = 65535)
	public String getYangDeficiencyGuidance() {
		return this.yangDeficiencyGuidance;
	}

	public void setYangDeficiencyGuidance(String yangDeficiencyGuidance) {
		this.yangDeficiencyGuidance = yangDeficiencyGuidance;
	}

	@Column(name = "YING_DECIFIENCY")
	public String getYingDecifiency() {
		return this.yingDecifiency;
	}

	public void setYingDecifiency(String yingDecifiency) {
		this.yingDecifiency = yingDecifiency;
	}

	@Column(name = "YING_DECIFIENCY_GUIDANCE", length = 65535)
	public String getYingDecifiencyGuidance() {
		return this.yingDecifiencyGuidance;
	}

	public void setYingDecifiencyGuidance(String yingDecifiencyGuidance) {
		this.yingDecifiencyGuidance = yingDecifiencyGuidance;
	}

	@Column(name = "PHLEGM_DAMPNESS")
	public String getPhlegmDampness() {
		return this.phlegmDampness;
	}

	public void setPhlegmDampness(String phlegmDampness) {
		this.phlegmDampness = phlegmDampness;
	}

	@Column(name = "PHLEGM_DAMPNESS_GUIDANCE", length = 65535)
	public String getPhlegmDampnessGuidance() {
		return this.phlegmDampnessGuidance;
	}

	public void setPhlegmDampnessGuidance(String phlegmDampnessGuidance) {
		this.phlegmDampnessGuidance = phlegmDampnessGuidance;
	}

	@Column(name = "DAMP_HEAT_CONSTITUTION")
	public String getDampHeatConstitution() {
		return this.dampHeatConstitution;
	}

	public void setDampHeatConstitution(String dampHeatConstitution) {
		this.dampHeatConstitution = dampHeatConstitution;
	}

	@Column(name = "DAMP_HEAT_CONSTITUTION_GUIDANCE", length = 65535)
	public String getDampHeatConstitutionGuidance() {
		return this.dampHeatConstitutionGuidance;
	}

	public void setDampHeatConstitutionGuidance(
			String dampHeatConstitutionGuidance) {
		this.dampHeatConstitutionGuidance = dampHeatConstitutionGuidance;
	}

	@Column(name = "BLOODY_SPUTUM")
	public String getBloodySputum() {
		return this.bloodySputum;
	}

	public void setBloodySputum(String bloodySputum) {
		this.bloodySputum = bloodySputum;
	}

	@Column(name = "BLOODY_SPUTUM_GUIDANCE", length = 65535)
	public String getBloodySputumGuidance() {
		return this.bloodySputumGuidance;
	}

	public void setBloodySputumGuidance(String bloodySputumGuidance) {
		this.bloodySputumGuidance = bloodySputumGuidance;
	}

	@Column(name = "QI_STAGNATION")
	public String getQiStagnation() {
		return this.qiStagnation;
	}

	public void setQiStagnation(String qiStagnation) {
		this.qiStagnation = qiStagnation;
	}

	@Column(name = "QI_STAGNATION_GUIDANCE", length = 65535)
	public String getQiStagnationGuidance() {
		return this.qiStagnationGuidance;
	}

	public void setQiStagnationGuidance(String qiStagnationGuidance) {
		this.qiStagnationGuidance = qiStagnationGuidance;
	}

	@Column(name = "GRASP")
	public String getGrasp() {
		return this.grasp;
	}

	public void setGrasp(String grasp) {
		this.grasp = grasp;
	}

	@Column(name = "GRASP_GUIDANCE", length = 65535)
	public String getGraspGuidance() {
		return this.graspGuidance;
	}

	public void setGraspGuidance(String graspGuidance) {
		this.graspGuidance = graspGuidance;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TChinaMedicine")
	public Set<TPhysicalExam> getTPhysicalExams() {
		return this.TPhysicalExams;
	}

	public void setTPhysicalExams(Set<TPhysicalExam> TPhysicalExams) {
		this.TPhysicalExams = TPhysicalExams;
	}

}