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
 * TAuxiliaryExamination entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_AUXILIARY_EXAMINATION", catalog = "jmjk")
public class TAuxiliaryExamination implements java.io.Serializable {

	// Fields

	private Integer auxiliaryExaminationId;
	private Double fbg;
	private Double glycatedHemoglobin;
	private String hbsag;
	private Double hemoglobin;
	private Double leukocyte;
	private Double platelet;
	private String othersRb;
	private String urineProtein;
	private String urineGlucose;
	private String ketone;
	private String ery;
	private String othersRu;
	private Double mau;
	private Boolean sedOccultBlood;
	private Double serumAlanineAminoAcid;
	private Double serumAspertateAminoAcid;
	private Double albumin;
	private Double tbil;
	private Double dbil;
	private Double cr;
	private Double bun;
	private Double serumPotassiumLevel;
	private Double serumNatriumLevel;
	private Double totalCholesterol;
	private Double ldlC;
	private Double triglyceride;
	private Double hdlC;
	private String papSmear;
	private String ecg;
	private String chestXRay;
	private String BScanUltrasonography;
	private String others;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private Set<TPhysicalExam> TPhysicalExams = new HashSet<TPhysicalExam>(0);
	private Set<TDiabete> TDiabetes = new HashSet<TDiabete>(0);

	// Constructors

	/** default constructor */
	public TAuxiliaryExamination() {
	}
	public TAuxiliaryExamination(Integer auxiliaryExaminationId) {
	    this.auxiliaryExaminationId=auxiliaryExaminationId;
    }
	/** full constructor */
	public TAuxiliaryExamination(Double fbg, Double glycatedHemoglobin,
			String hbsag, Double hemoglobin, Double leukocyte, Double platelet,
			String othersRb, String urineProtein, String urineGlucose,
			String ketone, String ery, String othersRu, Double mau,
			Boolean sedOccultBlood, Double serumAlanineAminoAcid,
			Double serumAspertateAminoAcid, Double albumin, Double tbil,
			Double dbil, Double cr, Double bun, Double serumPotassiumLevel,
			Double serumNatriumLevel, Double totalCholesterol, Double ldlC,
			Double triglyceride, Double hdlC, String papSmear, String ecg,
			String chestXRay, String BScanUltrasonography, String others,
			String one, String two, String three, String four, String five,
			Set<TPhysicalExam> TPhysicalExams, Set<TDiabete> TDiabetes) {
		this.fbg = fbg;
		this.glycatedHemoglobin = glycatedHemoglobin;
		this.hbsag = hbsag;
		this.hemoglobin = hemoglobin;
		this.leukocyte = leukocyte;
		this.platelet = platelet;
		this.othersRb = othersRb;
		this.urineProtein = urineProtein;
		this.urineGlucose = urineGlucose;
		this.ketone = ketone;
		this.ery = ery;
		this.othersRu = othersRu;
		this.mau = mau;
		this.sedOccultBlood = sedOccultBlood;
		this.serumAlanineAminoAcid = serumAlanineAminoAcid;
		this.serumAspertateAminoAcid = serumAspertateAminoAcid;
		this.albumin = albumin;
		this.tbil = tbil;
		this.dbil = dbil;
		this.cr = cr;
		this.bun = bun;
		this.serumPotassiumLevel = serumPotassiumLevel;
		this.serumNatriumLevel = serumNatriumLevel;
		this.totalCholesterol = totalCholesterol;
		this.ldlC = ldlC;
		this.triglyceride = triglyceride;
		this.hdlC = hdlC;
		this.papSmear = papSmear;
		this.ecg = ecg;
		this.chestXRay = chestXRay;
		this.BScanUltrasonography = BScanUltrasonography;
		this.others = others;
		this.one = one;
		this.two = two;
		this.three = three;
		this.four = four;
		this.five = five;
		this.TPhysicalExams = TPhysicalExams;
		this.TDiabetes = TDiabetes;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "AUXILIARY_EXAMINATION_ID", unique = true, nullable = false)
	public Integer getAuxiliaryExaminationId() {
		return this.auxiliaryExaminationId;
	}

	public void setAuxiliaryExaminationId(Integer auxiliaryExaminationId) {
		this.auxiliaryExaminationId = auxiliaryExaminationId;
	}

	@Column(name = "FBG", precision = 22, scale = 0)
	public Double getFbg() {
		return this.fbg;
	}

	public void setFbg(Double fbg) {
		this.fbg = fbg;
	}

	@Column(name = "GLYCATED_HEMOGLOBIN", precision = 22, scale = 0)
	public Double getGlycatedHemoglobin() {
		return this.glycatedHemoglobin;
	}

	public void setGlycatedHemoglobin(Double glycatedHemoglobin) {
		this.glycatedHemoglobin = glycatedHemoglobin;
	}

	@Column(name = "HBSAG")
	public String getHbsag() {
		return this.hbsag;
	}

	public void setHbsag(String hbsag) {
		this.hbsag = hbsag;
	}

	@Column(name = "HEMOGLOBIN", precision = 22, scale = 0)
	public Double getHemoglobin() {
		return this.hemoglobin;
	}

	public void setHemoglobin(Double hemoglobin) {
		this.hemoglobin = hemoglobin;
	}

	@Column(name = "LEUKOCYTE", precision = 22, scale = 0)
	public Double getLeukocyte() {
		return this.leukocyte;
	}

	public void setLeukocyte(Double leukocyte) {
		this.leukocyte = leukocyte;
	}

	@Column(name = "PLATELET", precision = 22, scale = 0)
	public Double getPlatelet() {
		return this.platelet;
	}

	public void setPlatelet(Double platelet) {
		this.platelet = platelet;
	}

	@Column(name = "OTHERS_RB", length = 65535)
	public String getOthersRb() {
		return this.othersRb;
	}

	public void setOthersRb(String othersRb) {
		this.othersRb = othersRb;
	}

	@Column(name = "URINE_PROTEIN")
	public String getUrineProtein() {
		return this.urineProtein;
	}

	public void setUrineProtein(String urineProtein) {
		this.urineProtein = urineProtein;
	}

	@Column(name = "URINE_GLUCOSE")
	public String getUrineGlucose() {
		return this.urineGlucose;
	}

	public void setUrineGlucose(String urineGlucose) {
		this.urineGlucose = urineGlucose;
	}

	@Column(name = "KETONE")
	public String getKetone() {
		return this.ketone;
	}

	public void setKetone(String ketone) {
		this.ketone = ketone;
	}

	@Column(name = "ERY")
	public String getEry() {
		return this.ery;
	}

	public void setEry(String ery) {
		this.ery = ery;
	}

	@Column(name = "OTHERS_RU", length = 65535)
	public String getOthersRu() {
		return this.othersRu;
	}

	public void setOthersRu(String othersRu) {
		this.othersRu = othersRu;
	}

	@Column(name = "MAU", precision = 22, scale = 0)
	public Double getMau() {
		return this.mau;
	}

	public void setMau(Double mau) {
		this.mau = mau;
	}

	@Column(name = "SED_OCCULT_BLOOD")
	public Boolean getSedOccultBlood() {
		return this.sedOccultBlood;
	}

	public void setSedOccultBlood(Boolean sedOccultBlood) {
		this.sedOccultBlood = sedOccultBlood;
	}

	@Column(name = "SERUM_ALANINE_AMINO_ACID", precision = 22, scale = 0)
	public Double getSerumAlanineAminoAcid() {
		return this.serumAlanineAminoAcid;
	}

	public void setSerumAlanineAminoAcid(Double serumAlanineAminoAcid) {
		this.serumAlanineAminoAcid = serumAlanineAminoAcid;
	}

	@Column(name = "SERUM_ASPERTATE_AMINO_ACID", precision = 22, scale = 0)
	public Double getSerumAspertateAminoAcid() {
		return this.serumAspertateAminoAcid;
	}

	public void setSerumAspertateAminoAcid(Double serumAspertateAminoAcid) {
		this.serumAspertateAminoAcid = serumAspertateAminoAcid;
	}

	@Column(name = "ALBUMIN", precision = 22, scale = 0)
	public Double getAlbumin() {
		return this.albumin;
	}

	public void setAlbumin(Double albumin) {
		this.albumin = albumin;
	}

	@Column(name = "TBIL", precision = 22, scale = 0)
	public Double getTbil() {
		return this.tbil;
	}

	public void setTbil(Double tbil) {
		this.tbil = tbil;
	}

	@Column(name = "DBIL", precision = 22, scale = 0)
	public Double getDbil() {
		return this.dbil;
	}

	public void setDbil(Double dbil) {
		this.dbil = dbil;
	}

	@Column(name = "CR", precision = 22, scale = 0)
	public Double getCr() {
		return this.cr;
	}

	public void setCr(Double cr) {
		this.cr = cr;
	}

	@Column(name = "BUN", precision = 22, scale = 0)
	public Double getBun() {
		return this.bun;
	}

	public void setBun(Double bun) {
		this.bun = bun;
	}

	@Column(name = "SERUM_POTASSIUM_LEVEL", precision = 22, scale = 0)
	public Double getSerumPotassiumLevel() {
		return this.serumPotassiumLevel;
	}

	public void setSerumPotassiumLevel(Double serumPotassiumLevel) {
		this.serumPotassiumLevel = serumPotassiumLevel;
	}

	@Column(name = "SERUM_NATRIUM_LEVEL", precision = 22, scale = 0)
	public Double getSerumNatriumLevel() {
		return this.serumNatriumLevel;
	}

	public void setSerumNatriumLevel(Double serumNatriumLevel) {
		this.serumNatriumLevel = serumNatriumLevel;
	}

	@Column(name = "TOTAL_CHOLESTEROL", precision = 22, scale = 0)
	public Double getTotalCholesterol() {
		return this.totalCholesterol;
	}

	public void setTotalCholesterol(Double totalCholesterol) {
		this.totalCholesterol = totalCholesterol;
	}

	@Column(name = "LDL_C", precision = 22, scale = 0)
	public Double getLdlC() {
		return this.ldlC;
	}

	public void setLdlC(Double ldlC) {
		this.ldlC = ldlC;
	}

	@Column(name = "TRIGLYCERIDE", precision = 22, scale = 0)
	public Double getTriglyceride() {
		return this.triglyceride;
	}

	public void setTriglyceride(Double triglyceride) {
		this.triglyceride = triglyceride;
	}

	@Column(name = "HDL_C", precision = 22, scale = 0)
	public Double getHdlC() {
		return this.hdlC;
	}

	public void setHdlC(Double hdlC) {
		this.hdlC = hdlC;
	}

	@Column(name = "PAP_SMEAR")
	public String getPapSmear() {
		return this.papSmear;
	}

	public void setPapSmear(String papSmear) {
		this.papSmear = papSmear;
	}

	@Column(name = "ECG")
	public String getEcg() {
		return this.ecg;
	}

	public void setEcg(String ecg) {
		this.ecg = ecg;
	}

	@Column(name = "CHEST_X_RAY")
	public String getChestXRay() {
		return this.chestXRay;
	}

	public void setChestXRay(String chestXRay) {
		this.chestXRay = chestXRay;
	}

	@Column(name = "B_SCAN_ULTRASONOGRAPHY")
	public String getBScanUltrasonography() {
		return this.BScanUltrasonography;
	}

	public void setBScanUltrasonography(String BScanUltrasonography) {
		this.BScanUltrasonography = BScanUltrasonography;
	}

	@Column(name = "OTHERS", length = 65535)
	public String getOthers() {
		return this.others;
	}

	public void setOthers(String others) {
		this.others = others;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TAuxiliaryExamination")
	public Set<TPhysicalExam> getTPhysicalExams() {
		return this.TPhysicalExams;
	}

	public void setTPhysicalExams(Set<TPhysicalExam> TPhysicalExams) {
		this.TPhysicalExams = TPhysicalExams;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TAuxiliaryExamination")
	public Set<TDiabete> getTDiabetes() {
		return this.TDiabetes;
	}

	public void setTDiabetes(Set<TDiabete> TDiabetes) {
		this.TDiabetes = TDiabetes;
	}

}