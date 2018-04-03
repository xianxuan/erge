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
 * TChronicFollow entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_CHRONIC_FOLLOW", catalog = "jmjk")
public class TChronicFollow implements java.io.Serializable {

	// Fields

	private Integer chronicFollowId;
	private TChronicDisease TChronicDisease;
	private String diseasrName;
	private String followPeople;
	private Timestamp followDate;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private Set<TMentalFollow> TMentalFollows = new HashSet<TMentalFollow>(0);
	private Set<TCoronaryHeartDisease> TCoronaryHeartDiseases = new HashSet<TCoronaryHeartDisease>(
			0);
	private Set<TFollowUpCardiovascular> TFollowUpCardiovasculars = new HashSet<TFollowUpCardiovascular>(
			0);
	private Set<TRegistrationOtherDiseases> TRegistrationOtherDiseaseses = new HashSet<TRegistrationOtherDiseases>(
			0);
	private Set<THypertensiveFollow> THypertensiveFollows = new HashSet<THypertensiveFollow>(
			0);
	private Set<TDiabetsFollow> TDiabetsFollows = new HashSet<TDiabetsFollow>(0);

	// Constructors

	/** default constructor */
	public TChronicFollow() {
	}

	/** minimal constructor */
	public TChronicFollow(String followPeople, Timestamp followDate) {
		this.followPeople = followPeople;
		this.followDate = followDate;
	}

	/** full constructor */
	public TChronicFollow(TChronicDisease TChronicDisease, String diseasrName,
			String followPeople, Timestamp followDate, String one, String two,
			String three, String four, String five,
			Set<TMentalFollow> TMentalFollows,
			Set<TCoronaryHeartDisease> TCoronaryHeartDiseases,
			Set<TFollowUpCardiovascular> TFollowUpCardiovasculars,
			Set<TRegistrationOtherDiseases> TRegistrationOtherDiseaseses,
			Set<THypertensiveFollow> THypertensiveFollows,
			Set<TDiabetsFollow> TDiabetsFollows) {
		this.TChronicDisease = TChronicDisease;
		this.diseasrName = diseasrName;
		this.followPeople = followPeople;
		this.followDate = followDate;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.TMentalFollows = TMentalFollows;
		this.TCoronaryHeartDiseases = TCoronaryHeartDiseases;
		this.TFollowUpCardiovasculars = TFollowUpCardiovasculars;
		this.TRegistrationOtherDiseaseses = TRegistrationOtherDiseaseses;
		this.THypertensiveFollows = THypertensiveFollows;
		this.TDiabetsFollows = TDiabetsFollows;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CHRONIC_FOLLOW_ID", unique = true, nullable = false)
	public Integer getChronicFollowId() {
		return this.chronicFollowId;
	}

	public void setChronicFollowId(Integer chronicFollowId) {
		this.chronicFollowId = chronicFollowId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CHRONIC_DISEASE_ID")
	public TChronicDisease getTChronicDisease() {
		return this.TChronicDisease;
	}

	public void setTChronicDisease(TChronicDisease TChronicDisease) {
		this.TChronicDisease = TChronicDisease;
	}

	@Column(name = "DISEASR_NAME")
	public String getDiseasrName() {
		return this.diseasrName;
	}

	public void setDiseasrName(String diseasrName) {
		this.diseasrName = diseasrName;
	}

	@Column(name = "FOLLOW_PEOPLE", nullable = false)
	public String getFollowPeople() {
		return this.followPeople;
	}

	public void setFollowPeople(String followPeople) {
		this.followPeople = followPeople;
	}

	@Column(name = "FOLLOW_DATE", nullable = false, length = 19)
	public Timestamp getFollowDate() {
		return this.followDate;
	}

	public void setFollowDate(Timestamp followDate) {
		this.followDate = followDate;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TChronicFollow")
	public Set<TMentalFollow> getTMentalFollows() {
		return this.TMentalFollows;
	}

	public void setTMentalFollows(Set<TMentalFollow> TMentalFollows) {
		this.TMentalFollows = TMentalFollows;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TChronicFollow")
	public Set<TCoronaryHeartDisease> getTCoronaryHeartDiseases() {
		return this.TCoronaryHeartDiseases;
	}

	public void setTCoronaryHeartDiseases(
			Set<TCoronaryHeartDisease> TCoronaryHeartDiseases) {
		this.TCoronaryHeartDiseases = TCoronaryHeartDiseases;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TChronicFollow")
	public Set<TFollowUpCardiovascular> getTFollowUpCardiovasculars() {
		return this.TFollowUpCardiovasculars;
	}

	public void setTFollowUpCardiovasculars(
			Set<TFollowUpCardiovascular> TFollowUpCardiovasculars) {
		this.TFollowUpCardiovasculars = TFollowUpCardiovasculars;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TChronicFollow")
	public Set<TRegistrationOtherDiseases> getTRegistrationOtherDiseaseses() {
		return this.TRegistrationOtherDiseaseses;
	}

	public void setTRegistrationOtherDiseaseses(
			Set<TRegistrationOtherDiseases> TRegistrationOtherDiseaseses) {
		this.TRegistrationOtherDiseaseses = TRegistrationOtherDiseaseses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TChronicFollow")
	public Set<THypertensiveFollow> getTHypertensiveFollows() {
		return this.THypertensiveFollows;
	}

	public void setTHypertensiveFollows(
			Set<THypertensiveFollow> THypertensiveFollows) {
		this.THypertensiveFollows = THypertensiveFollows;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TChronicFollow")
	public Set<TDiabetsFollow> getTDiabetsFollows() {
		return this.TDiabetsFollows;
	}

	public void setTDiabetsFollows(Set<TDiabetsFollow> TDiabetsFollows) {
		this.TDiabetsFollows = TDiabetsFollows;
	}

}