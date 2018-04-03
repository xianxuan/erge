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
 * TChronicDisease entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_CHRONIC_DISEASE", catalog = "jmjk")
public class TChronicDisease implements java.io.Serializable {

	// Fields

	private Integer chronicDiseaseId;
	private THealthFile THealthFile;
	private String icd;
	private String diseaseName;
	private Timestamp fileDate;
	private String fileName;
	private Integer status;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private Set<TDiabete> TDiabetes = new HashSet<TDiabete>(0);
	private Set<TChronicFollow> TChronicFollows = new HashSet<TChronicFollow>(0);
	private Set<TInsanityForm> TInsanityForms = new HashSet<TInsanityForm>(0);
	private Set<TCoronaryDisease> TCoronaryDiseases = new HashSet<TCoronaryDisease>(
			0);
	private Set<THcvd> THcvds = new HashSet<THcvd>(0);
	private Set<TTumour> TTumours = new HashSet<TTumour>(0);
	private Set<TDisabilityObstacle> TDisabilityObstacles = new HashSet<TDisabilityObstacle>(
			0);
	private Set<TChronicBronchialDisease> TChronicBronchialDiseases = new HashSet<TChronicBronchialDisease>(
			0);
	private Set<THighBloodPressure> THighBloodPressures = new HashSet<THighBloodPressure>(
			0);

	// Constructors

	/** default constructor */
	public TChronicDisease() {
	}

	/** minimal constructor */
	public TChronicDisease(THealthFile THealthFile, String diseaseName,
			Timestamp fileDate, String fileName) {
		this.THealthFile = THealthFile;
		this.diseaseName = diseaseName;
		this.fileDate = fileDate;
		this.fileName = fileName;
	}

	/** full constructor */
	public TChronicDisease(THealthFile THealthFile, String icd,
			String diseaseName, Timestamp fileDate, String fileName,
			Integer status, String one, String two, String three, String four,
			String five, Set<TDiabete> TDiabetes,
			Set<TChronicFollow> TChronicFollows,
			Set<TInsanityForm> TInsanityForms,
			Set<TCoronaryDisease> TCoronaryDiseases, Set<THcvd> THcvds,
			Set<TTumour> TTumours,
			Set<TDisabilityObstacle> TDisabilityObstacles,
			Set<TChronicBronchialDisease> TChronicBronchialDiseases,
			Set<THighBloodPressure> THighBloodPressures) {
		this.THealthFile = THealthFile;
		this.icd = icd;
		this.diseaseName = diseaseName;
		this.fileDate = fileDate;
		this.fileName = fileName;
		this.status = status;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.TDiabetes = TDiabetes;
		this.TChronicFollows = TChronicFollows;
		this.TInsanityForms = TInsanityForms;
		this.TCoronaryDiseases = TCoronaryDiseases;
		this.THcvds = THcvds;
		this.TTumours = TTumours;
		this.TDisabilityObstacles = TDisabilityObstacles;
		this.TChronicBronchialDiseases = TChronicBronchialDiseases;
		this.THighBloodPressures = THighBloodPressures;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "CHRONIC_DISEASE_ID", unique = true, nullable = false)
	public Integer getChronicDiseaseId() {
		return this.chronicDiseaseId;
	}

	public void setChronicDiseaseId(Integer chronicDiseaseId) {
		this.chronicDiseaseId = chronicDiseaseId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "HEALTH_FILE_ID", nullable = false)
	public THealthFile getTHealthFile() {
		return this.THealthFile;
	}

	public void setTHealthFile(THealthFile THealthFile) {
		this.THealthFile = THealthFile;
	}

	@Column(name = "ICD")
	public String getIcd() {
		return this.icd;
	}

	public void setIcd(String icd) {
		this.icd = icd;
	}

	@Column(name = "DISEASE_NAME", nullable = false)
	public String getDiseaseName() {
		return this.diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	@Column(name = "FILE_DATE", nullable = false, length = 19)
	public Timestamp getFileDate() {
		return this.fileDate;
	}

	public void setFileDate(Timestamp fileDate) {
		this.fileDate = fileDate;
	}

	@Column(name = "FILE_NAME", nullable = false)
	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "STATUS")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TChronicDisease")
	public Set<TDiabete> getTDiabetes() {
		return this.TDiabetes;
	}

	public void setTDiabetes(Set<TDiabete> TDiabetes) {
		this.TDiabetes = TDiabetes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TChronicDisease")
	public Set<TChronicFollow> getTChronicFollows() {
		return this.TChronicFollows;
	}

	public void setTChronicFollows(Set<TChronicFollow> TChronicFollows) {
		this.TChronicFollows = TChronicFollows;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TChronicDisease")
	public Set<TInsanityForm> getTInsanityForms() {
		return this.TInsanityForms;
	}

	public void setTInsanityForms(Set<TInsanityForm> TInsanityForms) {
		this.TInsanityForms = TInsanityForms;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TChronicDisease")
	public Set<TCoronaryDisease> getTCoronaryDiseases() {
		return this.TCoronaryDiseases;
	}

	public void setTCoronaryDiseases(Set<TCoronaryDisease> TCoronaryDiseases) {
		this.TCoronaryDiseases = TCoronaryDiseases;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TChronicDisease")
	public Set<THcvd> getTHcvds() {
		return this.THcvds;
	}

	public void setTHcvds(Set<THcvd> THcvds) {
		this.THcvds = THcvds;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TChronicDisease")
	public Set<TTumour> getTTumours() {
		return this.TTumours;
	}

	public void setTTumours(Set<TTumour> TTumours) {
		this.TTumours = TTumours;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TChronicDisease")
	public Set<TDisabilityObstacle> getTDisabilityObstacles() {
		return this.TDisabilityObstacles;
	}

	public void setTDisabilityObstacles(
			Set<TDisabilityObstacle> TDisabilityObstacles) {
		this.TDisabilityObstacles = TDisabilityObstacles;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TChronicDisease")
	public Set<TChronicBronchialDisease> getTChronicBronchialDiseases() {
		return this.TChronicBronchialDiseases;
	}

	public void setTChronicBronchialDiseases(
			Set<TChronicBronchialDisease> TChronicBronchialDiseases) {
		this.TChronicBronchialDiseases = TChronicBronchialDiseases;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TChronicDisease")
	public Set<THighBloodPressure> getTHighBloodPressures() {
		return this.THighBloodPressures;
	}

	public void setTHighBloodPressures(
			Set<THighBloodPressure> THighBloodPressures) {
		this.THighBloodPressures = THighBloodPressures;
	}

}