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
 * TLifestyleGuide entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_LIFESTYLE_GUIDE", catalog = "jmjk")
public class TLifestyleGuide implements java.io.Serializable {

	// Fields

	private Integer lifestyleGuideId;
	private Integer dailyCigaretteSmoking;
	private Double dailyDrinking;
	private Double stapleFood;
	private String takenSaltSituation;
	private Integer timesSports;
	private Double exerciseDuration;
	private String psychologicalAdjustment;
	private String treatmentCompliance;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private Set<TDiabetsFollow> TDiabetsFollows = new HashSet<TDiabetsFollow>(0);
	private Set<THypertensiveFollow> THypertensiveFollows = new HashSet<THypertensiveFollow>(
			0);

	// Constructors

	/** default constructor */
	public TLifestyleGuide() {
	}

	/** full constructor */
	public TLifestyleGuide(Integer dailyCigaretteSmoking, Double dailyDrinking,
			Double stapleFood, String takenSaltSituation, Integer timesSports,
			Double exerciseDuration, String psychologicalAdjustment,
			String treatmentCompliance, String one, String two, String three,
			String four, String five, Set<TDiabetsFollow> TDiabetsFollows,
			Set<THypertensiveFollow> THypertensiveFollows) {
		this.dailyCigaretteSmoking = dailyCigaretteSmoking;
		this.dailyDrinking = dailyDrinking;
		this.stapleFood = stapleFood;
		this.takenSaltSituation = takenSaltSituation;
		this.timesSports = timesSports;
		this.exerciseDuration = exerciseDuration;
		this.psychologicalAdjustment = psychologicalAdjustment;
		this.treatmentCompliance = treatmentCompliance;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.TDiabetsFollows = TDiabetsFollows;
		this.THypertensiveFollows = THypertensiveFollows;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "LIFESTYLE_GUIDE_ID", unique = true, nullable = false)
	public Integer getLifestyleGuideId() {
		return this.lifestyleGuideId;
	}

	public void setLifestyleGuideId(Integer lifestyleGuideId) {
		this.lifestyleGuideId = lifestyleGuideId;
	}

	@Column(name = "DAILY_CIGARETTE_SMOKING")
	public Integer getDailyCigaretteSmoking() {
		return this.dailyCigaretteSmoking;
	}

	public void setDailyCigaretteSmoking(Integer dailyCigaretteSmoking) {
		this.dailyCigaretteSmoking = dailyCigaretteSmoking;
	}

	@Column(name = "DAILY_DRINKING", precision = 22, scale = 0)
	public Double getDailyDrinking() {
		return this.dailyDrinking;
	}

	public void setDailyDrinking(Double dailyDrinking) {
		this.dailyDrinking = dailyDrinking;
	}

	@Column(name = "STAPLE_FOOD", precision = 22, scale = 0)
	public Double getStapleFood() {
		return this.stapleFood;
	}

	public void setStapleFood(Double stapleFood) {
		this.stapleFood = stapleFood;
	}

	@Column(name = "TAKEN_SALT_SITUATION")
	public String getTakenSaltSituation() {
		return this.takenSaltSituation;
	}

	public void setTakenSaltSituation(String takenSaltSituation) {
		this.takenSaltSituation = takenSaltSituation;
	}

	@Column(name = "TIMES_SPORTS")
	public Integer getTimesSports() {
		return this.timesSports;
	}

	public void setTimesSports(Integer timesSports) {
		this.timesSports = timesSports;
	}

	@Column(name = "EXERCISE_DURATION", precision = 22, scale = 0)
	public Double getExerciseDuration() {
		return this.exerciseDuration;
	}

	public void setExerciseDuration(Double exerciseDuration) {
		this.exerciseDuration = exerciseDuration;
	}

	@Column(name = "PSYCHOLOGICAL_ADJUSTMENT")
	public String getPsychologicalAdjustment() {
		return this.psychologicalAdjustment;
	}

	public void setPsychologicalAdjustment(String psychologicalAdjustment) {
		this.psychologicalAdjustment = psychologicalAdjustment;
	}

	@Column(name = "TREATMENT_COMPLIANCE")
	public String getTreatmentCompliance() {
		return this.treatmentCompliance;
	}

	public void setTreatmentCompliance(String treatmentCompliance) {
		this.treatmentCompliance = treatmentCompliance;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TLifestyleGuide")
	public Set<TDiabetsFollow> getTDiabetsFollows() {
		return this.TDiabetsFollows;
	}

	public void setTDiabetsFollows(Set<TDiabetsFollow> TDiabetsFollows) {
		this.TDiabetsFollows = TDiabetsFollows;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TLifestyleGuide")
	public Set<THypertensiveFollow> getTHypertensiveFollows() {
		return this.THypertensiveFollows;
	}

	public void setTHypertensiveFollows(
			Set<THypertensiveFollow> THypertensiveFollows) {
		this.THypertensiveFollows = THypertensiveFollows;
	}

}