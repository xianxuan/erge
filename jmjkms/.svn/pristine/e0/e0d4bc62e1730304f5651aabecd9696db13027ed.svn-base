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
 * TCheck entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "T_CHECK", catalog = "jmjk")
public class TCheck implements java.io.Serializable {

	// Fields

	private Integer checkId;
	private String skin;
	private String sclera;
	private String lymphNode;
	private String barrelChest;
	private String breathSounds;
	private String rale;
	private Integer heartRate;
	private String rhythmOfTheHeart;
	private String noise;
	private String tenderness;
	private String masses;
	private String hepatomegaly;
	private String splenomegaly;
	private String shiftingDullness;
	private String lowerExtremityEdema;
	private String dorsalisPedisPulse;
	private String theAnusDre;
	private String fundus;
	private String mammaryGland;
	private String vulva;
	private String vagina;
	private String cervix;
	private String corpus;
	private String attachment;
	private String others;
	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private Set<TPhysicalExam> TPhysicalExams = new HashSet<TPhysicalExam>(0);

	// Constructors

	/** default constructor */
	public TCheck() {
	}
	public TCheck(Integer checkId) {
	    this.checkId=checkId;
    }

	/** full constructor */
	public TCheck(String skin, String sclera, String lymphNode,
			String barrelChest, String breathSounds, String rale,
			Integer heartRate, String rhythmOfTheHeart, String noise,
			String tenderness, String masses, String hepatomegaly,
			String splenomegaly, String shiftingDullness,
			String lowerExtremityEdema, String dorsalisPedisPulse,
			String theAnusDre, String fundus, String mammaryGland,
			String vulva, String vagina, String cervix, String corpus,
			String attachment, String others, String one, String two,
			String three, String four, String five,
			Set<TPhysicalExam> TPhysicalExams) {
		this.skin = skin;
		this.sclera = sclera;
		this.lymphNode = lymphNode;
		this.barrelChest = barrelChest;
		this.breathSounds = breathSounds;
		this.rale = rale;
		this.heartRate = heartRate;
		this.rhythmOfTheHeart = rhythmOfTheHeart;
		this.noise = noise;
		this.tenderness = tenderness;
		this.masses = masses;
		this.hepatomegaly = hepatomegaly;
		this.splenomegaly = splenomegaly;
		this.shiftingDullness = shiftingDullness;
		this.lowerExtremityEdema = lowerExtremityEdema;
		this.dorsalisPedisPulse = dorsalisPedisPulse;
		this.theAnusDre = theAnusDre;
		this.fundus = fundus;
		this.mammaryGland = mammaryGland;
		this.vulva = vulva;
		this.vagina = vagina;
		this.cervix = cervix;
		this.corpus = corpus;
		this.attachment = attachment;
		this.others = others;
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
	@Column(name = "CHECK_ID", unique = true, nullable = false)
	public Integer getCheckId() {
		return this.checkId;
	}

	public void setCheckId(Integer checkId) {
		this.checkId = checkId;
	}

	@Column(name = "SKIN")
	public String getSkin() {
		return this.skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
	}

	@Column(name = "SCLERA")
	public String getSclera() {
		return this.sclera;
	}

	public void setSclera(String sclera) {
		this.sclera = sclera;
	}

	@Column(name = "LYMPH_NODE")
	public String getLymphNode() {
		return this.lymphNode;
	}

	public void setLymphNode(String lymphNode) {
		this.lymphNode = lymphNode;
	}

	@Column(name = "BARREL_CHEST")
	public String getBarrelChest() {
		return this.barrelChest;
	}

	public void setBarrelChest(String barrelChest) {
		this.barrelChest = barrelChest;
	}

	@Column(name = "BREATH_SOUNDS")
	public String getBreathSounds() {
		return this.breathSounds;
	}

	public void setBreathSounds(String breathSounds) {
		this.breathSounds = breathSounds;
	}

	@Column(name = "RALE")
	public String getRale() {
		return this.rale;
	}

	public void setRale(String rale) {
		this.rale = rale;
	}

	@Column(name = "HEART_RATE")
	public Integer getHeartRate() {
		return this.heartRate;
	}

	public void setHeartRate(Integer heartRate) {
		this.heartRate = heartRate;
	}

	@Column(name = "RHYTHM_OF_THE_HEART")
	public String getRhythmOfTheHeart() {
		return this.rhythmOfTheHeart;
	}

	public void setRhythmOfTheHeart(String rhythmOfTheHeart) {
		this.rhythmOfTheHeart = rhythmOfTheHeart;
	}

	@Column(name = "NOISE")
	public String getNoise() {
		return this.noise;
	}

	public void setNoise(String noise) {
		this.noise = noise;
	}

	@Column(name = "TENDERNESS")
	public String getTenderness() {
		return this.tenderness;
	}

	public void setTenderness(String tenderness) {
		this.tenderness = tenderness;
	}

	@Column(name = "MASSES")
	public String getMasses() {
		return this.masses;
	}

	public void setMasses(String masses) {
		this.masses = masses;
	}

	@Column(name = "HEPATOMEGALY")
	public String getHepatomegaly() {
		return this.hepatomegaly;
	}

	public void setHepatomegaly(String hepatomegaly) {
		this.hepatomegaly = hepatomegaly;
	}

	@Column(name = "SPLENOMEGALY")
	public String getSplenomegaly() {
		return this.splenomegaly;
	}

	public void setSplenomegaly(String splenomegaly) {
		this.splenomegaly = splenomegaly;
	}

	@Column(name = "SHIFTING_DULLNESS")
	public String getShiftingDullness() {
		return this.shiftingDullness;
	}

	public void setShiftingDullness(String shiftingDullness) {
		this.shiftingDullness = shiftingDullness;
	}

	@Column(name = "LOWER_EXTREMITY_EDEMA")
	public String getLowerExtremityEdema() {
		return this.lowerExtremityEdema;
	}

	public void setLowerExtremityEdema(String lowerExtremityEdema) {
		this.lowerExtremityEdema = lowerExtremityEdema;
	}

	@Column(name = "DORSALIS_PEDIS_PULSE")
	public String getDorsalisPedisPulse() {
		return this.dorsalisPedisPulse;
	}

	public void setDorsalisPedisPulse(String dorsalisPedisPulse) {
		this.dorsalisPedisPulse = dorsalisPedisPulse;
	}

	@Column(name = "THE_ANUS_DRE")
	public String getTheAnusDre() {
		return this.theAnusDre;
	}

	public void setTheAnusDre(String theAnusDre) {
		this.theAnusDre = theAnusDre;
	}

	@Column(name = "FUNDUS")
	public String getFundus() {
		return this.fundus;
	}

	public void setFundus(String fundus) {
		this.fundus = fundus;
	}

	@Column(name = "MAMMARY_GLAND")
	public String getMammaryGland() {
		return this.mammaryGland;
	}

	public void setMammaryGland(String mammaryGland) {
		this.mammaryGland = mammaryGland;
	}

	@Column(name = "VULVA")
	public String getVulva() {
		return this.vulva;
	}

	public void setVulva(String vulva) {
		this.vulva = vulva;
	}

	@Column(name = "VAGINA")
	public String getVagina() {
		return this.vagina;
	}

	public void setVagina(String vagina) {
		this.vagina = vagina;
	}

	@Column(name = "CERVIX")
	public String getCervix() {
		return this.cervix;
	}

	public void setCervix(String cervix) {
		this.cervix = cervix;
	}

	@Column(name = "CORPUS")
	public String getCorpus() {
		return this.corpus;
	}

	public void setCorpus(String corpus) {
		this.corpus = corpus;
	}

	@Column(name = "ATTACHMENT")
	public String getAttachment() {
		return this.attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "TCheck")
	public Set<TPhysicalExam> getTPhysicalExams() {
		return this.TPhysicalExams;
	}

	public void setTPhysicalExams(Set<TPhysicalExam> TPhysicalExams) {
		this.TPhysicalExams = TPhysicalExams;
	}

}