package com.jmjk.entity.view;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VOldStaff entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "V_OLD_STAFF", catalog = "jmjk")
public class VOldStaff implements java.io.Serializable {

	// Fields

	private Integer healthFileId;
	private String fileNum;
	private String HName; //老人名字
	private Boolean sex;
	private String idNum;
	private String currentResidentCommittee;
	private Integer staffId;
	private String SName; //责任医生名字
	private Integer communityHospitalId;
	private Integer age;
	private Timestamp birthDate;
	private String enterPeople;
	private String filePerson;
	private String otherAddressType;
	private String otherProvince;
	private String otherCity;
	private String otherCounty;
	private String diseaseName;
	private Integer chronicDiseaseId;
	private String healthFileType;
	private Timestamp fileDate;
	private String IPhone;
	private Integer GId;                      //集团ID

	// Constructors

	/** default constructor */
	public VOldStaff() {
	}

	/** minimal constructor */
	public VOldStaff(Integer healthFileId, String HName, String idNum,
			String IPhone) {
		this.healthFileId = healthFileId;
		this.HName = HName;
		this.idNum = idNum;
		this.IPhone = IPhone;
	}

	/** full constructor */
	public VOldStaff(Integer healthFileId, String fileNum, String HName,
			Boolean sex, String idNum, String currentResidentCommittee,
			Integer staffId, String SName, Integer communityHospitalId,
			Integer age, Timestamp birthDate, String enterPeople,
			String filePerson, String otherAddressType, String otherProvince,
			String otherCity, String otherCounty, String diseaseName,
			Integer chronicDiseaseId, String healthFileType,
			Timestamp fileDate, String IPhone) {
		this.healthFileId = healthFileId;
		this.fileNum = fileNum;
		this.HName = HName;
		this.sex = sex;
		this.idNum = idNum;
		this.currentResidentCommittee = currentResidentCommittee;
		this.staffId = staffId;
		this.SName = SName;
		this.communityHospitalId = communityHospitalId;
		this.age = age;
		this.birthDate = birthDate;
		this.enterPeople = enterPeople;
		this.filePerson = filePerson;
		this.otherAddressType = otherAddressType;
		this.otherProvince = otherProvince;
		this.otherCity = otherCity;
		this.otherCounty = otherCounty;
		this.diseaseName = diseaseName;
		this.chronicDiseaseId = chronicDiseaseId;
		this.healthFileType = healthFileType;
		this.fileDate = fileDate;
		this.IPhone = IPhone;
	}

	// Property accessors
	@Id
	@Column(name = "HEALTH_FILE_ID", nullable = false)
	public Integer getHealthFileId() {
		return this.healthFileId;
	}

	public void setHealthFileId(Integer healthFileId) {
		this.healthFileId = healthFileId;
	}

	@Column(name = "FILE_NUM")
	public String getFileNum() {
		return this.fileNum;
	}

	public void setFileNum(String fileNum) {
		this.fileNum = fileNum;
	}

	@Column(name = "H_NAME", nullable = false)
	public String getHName() {
		return this.HName;
	}

	public void setHName(String HName) {
		this.HName = HName;
	}

	@Column(name = "SEX")
	public Boolean getSex() {
		return this.sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	@Column(name = "ID_NUM", nullable = false)
	public String getIdNum() {
		return this.idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	@Column(name = "CURRENT_RESIDENT_COMMITTEE")
	public String getCurrentResidentCommittee() {
		return this.currentResidentCommittee;
	}

	public void setCurrentResidentCommittee(String currentResidentCommittee) {
		this.currentResidentCommittee = currentResidentCommittee;
	}

	@Column(name = "STAFF_ID")
	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	@Column(name = "S_NAME")
	public String getSName() {
		return this.SName;
	}

	public void setSName(String SName) {
		this.SName = SName;
	}

	@Column(name = "COMMUNITY_HOSPITAL_ID")
	public Integer getCommunityHospitalId() {
		return this.communityHospitalId;
	}

	public void setCommunityHospitalId(Integer communityHospitalId) {
		this.communityHospitalId = communityHospitalId;
	}

	@Column(name = "AGE")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "BIRTH_DATE", length = 19)
	public Timestamp getBirthDate() {
		return this.birthDate;
	}

	public void setBirthDate(Timestamp birthDate) {
		this.birthDate = birthDate;
	}

	@Column(name = "ENTER_PEOPLE")
	public String getEnterPeople() {
		return this.enterPeople;
	}

	public void setEnterPeople(String enterPeople) {
		this.enterPeople = enterPeople;
	}

	@Column(name = "FILE_PERSON")
	public String getFilePerson() {
		return this.filePerson;
	}

	public void setFilePerson(String filePerson) {
		this.filePerson = filePerson;
	}

	@Column(name = "OTHER_ADDRESS_TYPE")
	public String getOtherAddressType() {
		return this.otherAddressType;
	}

	public void setOtherAddressType(String otherAddressType) {
		this.otherAddressType = otherAddressType;
	}

	@Column(name = "OTHER_PROVINCE")
	public String getOtherProvince() {
		return this.otherProvince;
	}

	public void setOtherProvince(String otherProvince) {
		this.otherProvince = otherProvince;
	}

	@Column(name = "OTHER_CITY")
	public String getOtherCity() {
		return this.otherCity;
	}

	public void setOtherCity(String otherCity) {
		this.otherCity = otherCity;
	}

	@Column(name = "OTHER_COUNTY")
	public String getOtherCounty() {
		return this.otherCounty;
	}

	public void setOtherCounty(String otherCounty) {
		this.otherCounty = otherCounty;
	}

	@Column(name = "DISEASE_NAME")
	public String getDiseaseName() {
		return this.diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	@Column(name = "CHRONIC_DISEASE_ID")
	public Integer getChronicDiseaseId() {
		return this.chronicDiseaseId;
	}

	public void setChronicDiseaseId(Integer chronicDiseaseId) {
		this.chronicDiseaseId = chronicDiseaseId;
	}

	@Column(name = "HEALTH_FILE_TYPE", length = 1)
	public String getHealthFileType() {
		return this.healthFileType;
	}

	public void setHealthFileType(String healthFileType) {
		this.healthFileType = healthFileType;
	}

	@Column(name = "FILE_DATE", length = 19)
	public Timestamp getFileDate() {
		return this.fileDate;
	}

	public void setFileDate(Timestamp fileDate) {
		this.fileDate = fileDate;
	}

	@Column(name = "I_PHONE", nullable = false)
	public String getIPhone() {
		return this.IPhone;
	}

	public void setIPhone(String IPhone) {
		this.IPhone = IPhone;
	}

	@Column(name = "G_ID")
	public Integer getGId() {
		return this.GId;
	}

	public void setGId(Integer GId) {
		this.GId = GId;
	}
}