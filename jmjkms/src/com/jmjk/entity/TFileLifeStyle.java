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
 * TFileLifeStyle entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_file_life_style", catalog = "jmjk")
public class TFileLifeStyle implements java.io.Serializable {

	// Fields

	private Integer lifeId;
	private THealthFile THealthFile;
	private String exerciseFrequency;
	private String exerciseTime;
	private String allExerciseTime;
	private String exerciseType;
	private String dietaryHabit;
	private String smokingStatus;
	private Double smokingOneday;
	private Integer startsmokingAge;
	private Integer giveupSmokingAge;
	private String drinkingFrequency;
	private Double monthlyDrinking;
	private String abstinence;
	private Integer startDrinkingAge;
	private Boolean recentlyYearDrinking;
	private String drinkingType;
	private String occupationalDisease;
	private String typeWork;
	private Timestamp year;
	private String dust;
	private String dustFence;
	private String chemicalSubstances;
	private String chSubFence;
	private String radiogen;
	private String radiogenFence;
	private String physicalFactor;
	private String physicalFactorFence;
	private String other;
	private String otherFence;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;

	// Constructors

	/** default constructor */
	public TFileLifeStyle() {
	}

	/** minimal constructor */
	public TFileLifeStyle(THealthFile THealthFile) {
		this.THealthFile = THealthFile;
	}

	/** full constructor */
	public TFileLifeStyle(THealthFile THealthFile, String exerciseFrequency,
			String exerciseTime, String allExerciseTime, String exerciseType,
			String dietaryHabit, String smokingStatus, Double smokingOneday,
			Integer startsmokingAge, Integer giveupSmokingAge,
			String drinkingFrequency, Double monthlyDrinking,
			String abstinence, Integer startDrinkingAge,
			Boolean recentlyYearDrinking, String drinkingType,
			String occupationalDisease, String typeWork, Timestamp year,
			String dust, String dustFence, String chemicalSubstances,
			String chSubFence, String radiogen, String radiogenFence,
			String physicalFactor, String physicalFactorFence, String other,
			String otherFence, String one, String two, String three,
			String four, String five) {
		this.THealthFile = THealthFile;
		this.exerciseFrequency = exerciseFrequency;
		this.exerciseTime = exerciseTime;
		this.allExerciseTime = allExerciseTime;
		this.exerciseType = exerciseType;
		this.dietaryHabit = dietaryHabit;
		this.smokingStatus = smokingStatus;
		this.smokingOneday = smokingOneday;
		this.startsmokingAge = startsmokingAge;
		this.giveupSmokingAge = giveupSmokingAge;
		this.drinkingFrequency = drinkingFrequency;
		this.monthlyDrinking = monthlyDrinking;
		this.abstinence = abstinence;
		this.startDrinkingAge = startDrinkingAge;
		this.recentlyYearDrinking = recentlyYearDrinking;
		this.drinkingType = drinkingType;
		this.occupationalDisease = occupationalDisease;
		this.typeWork = typeWork;
		this.year = year;
		this.dust = dust;
		this.dustFence = dustFence;
		this.chemicalSubstances = chemicalSubstances;
		this.chSubFence = chSubFence;
		this.radiogen = radiogen;
		this.radiogenFence = radiogenFence;
		this.physicalFactor = physicalFactor;
		this.physicalFactorFence = physicalFactorFence;
		this.other = other;
		this.otherFence = otherFence;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "LIFE_ID", unique = true, nullable = false)
	public Integer getLifeId() {
		return this.lifeId;
	}

	public void setLifeId(Integer lifeId) {
		this.lifeId = lifeId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HEALTH_FILE_ID", nullable = false)
	public THealthFile getTHealthFile() {
		return this.THealthFile;
	}

	public void setTHealthFile(THealthFile THealthFile) {
		this.THealthFile = THealthFile;
	}

	@Column(name = "EXERCISE_FREQUENCY")
	public String getExerciseFrequency() {
		return this.exerciseFrequency;
	}

	public void setExerciseFrequency(String exerciseFrequency) {
		this.exerciseFrequency = exerciseFrequency;
	}

	@Column(name = "EXERCISE_TIME")
	public String getExerciseTime() {
		return this.exerciseTime;
	}

	public void setExerciseTime(String exerciseTime) {
		this.exerciseTime = exerciseTime;
	}

	@Column(name = "ALL_EXERCISE_TIME")
	public String getAllExerciseTime() {
		return this.allExerciseTime;
	}

	public void setAllExerciseTime(String allExerciseTime) {
		this.allExerciseTime = allExerciseTime;
	}

	@Column(name = "EXERCISE_TYPE")
	public String getExerciseType() {
		return this.exerciseType;
	}

	public void setExerciseType(String exerciseType) {
		this.exerciseType = exerciseType;
	}

	@Column(name = "DIETARY_HABIT")
	public String getDietaryHabit() {
		return this.dietaryHabit;
	}

	public void setDietaryHabit(String dietaryHabit) {
		this.dietaryHabit = dietaryHabit;
	}

	@Column(name = "SMOKING_STATUS")
	public String getSmokingStatus() {
		return this.smokingStatus;
	}

	public void setSmokingStatus(String smokingStatus) {
		this.smokingStatus = smokingStatus;
	}

	@Column(name = "SMOKING_ONEDAY", precision = 22, scale = 0)
	public Double getSmokingOneday() {
		return this.smokingOneday;
	}

	public void setSmokingOneday(Double smokingOneday) {
		this.smokingOneday = smokingOneday;
	}

	@Column(name = "STARTSMOKING_AGE")
	public Integer getStartsmokingAge() {
		return this.startsmokingAge;
	}

	public void setStartsmokingAge(Integer startsmokingAge) {
		this.startsmokingAge = startsmokingAge;
	}

	@Column(name = "GIVEUP_SMOKING_AGE")
	public Integer getGiveupSmokingAge() {
		return this.giveupSmokingAge;
	}

	public void setGiveupSmokingAge(Integer giveupSmokingAge) {
		this.giveupSmokingAge = giveupSmokingAge;
	}

	@Column(name = "DRINKING_FREQUENCY")
	public String getDrinkingFrequency() {
		return this.drinkingFrequency;
	}

	public void setDrinkingFrequency(String drinkingFrequency) {
		this.drinkingFrequency = drinkingFrequency;
	}

	@Column(name = "MONTHLY_DRINKING", precision = 22, scale = 0)
	public Double getMonthlyDrinking() {
		return this.monthlyDrinking;
	}

	public void setMonthlyDrinking(Double monthlyDrinking) {
		this.monthlyDrinking = monthlyDrinking;
	}

	@Column(name = "ABSTINENCE")
	public String getAbstinence() {
		return this.abstinence;
	}

	public void setAbstinence(String abstinence) {
		this.abstinence = abstinence;
	}

	@Column(name = "START_DRINKING_AGE")
	public Integer getStartDrinkingAge() {
		return this.startDrinkingAge;
	}

	public void setStartDrinkingAge(Integer startDrinkingAge) {
		this.startDrinkingAge = startDrinkingAge;
	}

	@Column(name = "RECENTLY_YEAR_DRINKING")
	public Boolean getRecentlyYearDrinking() {
		return this.recentlyYearDrinking;
	}

	public void setRecentlyYearDrinking(Boolean recentlyYearDrinking) {
		this.recentlyYearDrinking = recentlyYearDrinking;
	}

	@Column(name = "DRINKING_TYPE")
	public String getDrinkingType() {
		return this.drinkingType;
	}

	public void setDrinkingType(String drinkingType) {
		this.drinkingType = drinkingType;
	}

	@Column(name = "OCCUPATIONAL_DISEASE", length = 65535)
	public String getOccupationalDisease() {
		return this.occupationalDisease;
	}

	public void setOccupationalDisease(String occupationalDisease) {
		this.occupationalDisease = occupationalDisease;
	}

	@Column(name = "TYPE_WORK")
	public String getTypeWork() {
		return this.typeWork;
	}

	public void setTypeWork(String typeWork) {
		this.typeWork = typeWork;
	}

	@Column(name = "YEAR", length = 19)
	public Timestamp getYear() {
		return this.year;
	}

	public void setYear(Timestamp year) {
		this.year = year;
	}

	@Column(name = "DUST")
	public String getDust() {
		return this.dust;
	}

	public void setDust(String dust) {
		this.dust = dust;
	}

	@Column(name = "DUST_FENCE")
	public String getDustFence() {
		return this.dustFence;
	}

	public void setDustFence(String dustFence) {
		this.dustFence = dustFence;
	}

	@Column(name = "CHEMICAL_SUBSTANCES")
	public String getChemicalSubstances() {
		return this.chemicalSubstances;
	}

	public void setChemicalSubstances(String chemicalSubstances) {
		this.chemicalSubstances = chemicalSubstances;
	}

	@Column(name = "CH_SUB_FENCE")
	public String getChSubFence() {
		return this.chSubFence;
	}

	public void setChSubFence(String chSubFence) {
		this.chSubFence = chSubFence;
	}

	@Column(name = "RADIOGEN")
	public String getRadiogen() {
		return this.radiogen;
	}

	public void setRadiogen(String radiogen) {
		this.radiogen = radiogen;
	}

	@Column(name = "RADIOGEN_FENCE")
	public String getRadiogenFence() {
		return this.radiogenFence;
	}

	public void setRadiogenFence(String radiogenFence) {
		this.radiogenFence = radiogenFence;
	}

	@Column(name = "PHYSICAL_FACTOR")
	public String getPhysicalFactor() {
		return this.physicalFactor;
	}

	public void setPhysicalFactor(String physicalFactor) {
		this.physicalFactor = physicalFactor;
	}

	@Column(name = "PHYSICAL_FACTOR_FENCE")
	public String getPhysicalFactorFence() {
		return this.physicalFactorFence;
	}

	public void setPhysicalFactorFence(String physicalFactorFence) {
		this.physicalFactorFence = physicalFactorFence;
	}

	@Column(name = "OTHER", length = 65535)
	public String getOther() {
		return this.other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	@Column(name = "OTHER_FENCE", length = 65535)
	public String getOtherFence() {
		return this.otherFence;
	}

	public void setOtherFence(String otherFence) {
		this.otherFence = otherFence;
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