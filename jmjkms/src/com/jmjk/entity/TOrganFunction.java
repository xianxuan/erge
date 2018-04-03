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
 * TOrganFunction entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_ORGAN_FUNCTION", catalog = "jmjk")
public class TOrganFunction implements java.io.Serializable {

	// Fields

	private Integer organFunctionId;
	private String oralLip;
	private String dentition;
	private String pharynx;
	private Double visionLeftEye;
	private Double visionRightEye;
	private Double correctedVisionLeftEye;
	private Double correctedVisionRightEye;
	private String hearing;
	private String motorFunction;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private Set<TPhysicalExam> TPhysicalExams = new HashSet<TPhysicalExam>(0);

	// Constructors

	/** default constructor */
	public TOrganFunction() {
	}
	public TOrganFunction(Integer organFunctionId) {
	    this.organFunctionId=organFunctionId;
    }

	/** full constructor */
	public TOrganFunction(String oralLip, String dentition, String pharynx,
			Double visionLeftEye, Double visionRightEye,
			Double correctedVisionLeftEye, Double correctedVisionRightEye,
			String hearing, String motorFunction, String one, String two,
			String three, String four, String five,
			Set<TPhysicalExam> TPhysicalExams) {
		this.oralLip = oralLip;
		this.dentition = dentition;
		this.pharynx = pharynx;
		this.visionLeftEye = visionLeftEye;
		this.visionRightEye = visionRightEye;
		this.correctedVisionLeftEye = correctedVisionLeftEye;
		this.correctedVisionRightEye = correctedVisionRightEye;
		this.hearing = hearing;
		this.motorFunction = motorFunction;
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
	@Column(name = "ORGAN_FUNCTION_ID", unique = true, nullable = false)
	public Integer getOrganFunctionId() {
		return this.organFunctionId;
	}

	public void setOrganFunctionId(Integer organFunctionId) {
		this.organFunctionId = organFunctionId;
	}

	@Column(name = "ORAL_LIP")
	public String getOralLip() {
		return this.oralLip;
	}

	public void setOralLip(String oralLip) {
		this.oralLip = oralLip;
	}

	@Column(name = "DENTITION")
	public String getDentition() {
		return this.dentition;
	}

	public void setDentition(String dentition) {
		this.dentition = dentition;
	}

	@Column(name = "PHARYNX")
	public String getPharynx() {
		return this.pharynx;
	}

	public void setPharynx(String pharynx) {
		this.pharynx = pharynx;
	}

	@Column(name = "VISION_LEFT_EYE", precision = 22, scale = 0)
	public Double getVisionLeftEye() {
		return this.visionLeftEye;
	}

	public void setVisionLeftEye(Double visionLeftEye) {
		this.visionLeftEye = visionLeftEye;
	}

	@Column(name = "VISION_RIGHT_EYE", precision = 22, scale = 0)
	public Double getVisionRightEye() {
		return this.visionRightEye;
	}

	public void setVisionRightEye(Double visionRightEye) {
		this.visionRightEye = visionRightEye;
	}

	@Column(name = "CORRECTED_VISION_LEFT_EYE", precision = 22, scale = 0)
	public Double getCorrectedVisionLeftEye() {
		return this.correctedVisionLeftEye;
	}

	public void setCorrectedVisionLeftEye(Double correctedVisionLeftEye) {
		this.correctedVisionLeftEye = correctedVisionLeftEye;
	}

	@Column(name = "CORRECTED_VISION_RIGHT_EYE", precision = 22, scale = 0)
	public Double getCorrectedVisionRightEye() {
		return this.correctedVisionRightEye;
	}

	public void setCorrectedVisionRightEye(Double correctedVisionRightEye) {
		this.correctedVisionRightEye = correctedVisionRightEye;
	}

	@Column(name = "HEARING")
	public String getHearing() {
		return this.hearing;
	}

	public void setHearing(String hearing) {
		this.hearing = hearing;
	}

	@Column(name = "MOTOR_FUNCTION")
	public String getMotorFunction() {
		return this.motorFunction;
	}

	public void setMotorFunction(String motorFunction) {
		this.motorFunction = motorFunction;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TOrganFunction")
	public Set<TPhysicalExam> getTPhysicalExams() {
		return this.TPhysicalExams;
	}

	public void setTPhysicalExams(Set<TPhysicalExam> TPhysicalExams) {
		this.TPhysicalExams = TPhysicalExams;
	}

}