package com.jmjk.entity.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VHosOldChronic entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "V_HOS_OLD_CHRONIC", catalog = "jmjk")
public class VHosOldChronic implements java.io.Serializable {

	// Fields

	private Integer oldStaffHosId;
	private Integer healthFileId;
	private Integer communityHospitalId;
	private String healthFileType;
	private Integer chronicDiseaseId;
	private Integer age;
	private String fileNum;

	// Constructors

	/** default constructor */
	public VHosOldChronic() {
	}

	/** minimal constructor */
	public VHosOldChronic(Integer oldStaffHosId) {
		this.oldStaffHosId = oldStaffHosId;
	}

	/** full constructor */
	public VHosOldChronic(Integer oldStaffHosId, Integer healthFileId,
			Integer communityHospitalId, String healthFileType,
			Integer chronicDiseaseId, Integer age, String fileNum) {
		this.oldStaffHosId = oldStaffHosId;
		this.healthFileId = healthFileId;
		this.communityHospitalId = communityHospitalId;
		this.healthFileType = healthFileType;
		this.chronicDiseaseId = chronicDiseaseId;
		this.age = age;
		this.fileNum = fileNum;
	}

	// Property accessors
	@Id
	@Column(name = "OLD_STAFF_HOS_ID", nullable = false)
	public Integer getOldStaffHosId() {
		return this.oldStaffHosId;
	}

	public void setOldStaffHosId(Integer oldStaffHosId) {
		this.oldStaffHosId = oldStaffHosId;
	}

	@Column(name = "HEALTH_FILE_ID")
	public Integer getHealthFileId() {
		return this.healthFileId;
	}

	public void setHealthFileId(Integer healthFileId) {
		this.healthFileId = healthFileId;
	}

	@Column(name = "COMMUNITY_HOSPITAL_ID")
	public Integer getCommunityHospitalId() {
		return this.communityHospitalId;
	}

	public void setCommunityHospitalId(Integer communityHospitalId) {
		this.communityHospitalId = communityHospitalId;
	}

	@Column(name = "HEALTH_FILE_TYPE", length = 1)
	public String getHealthFileType() {
		return this.healthFileType;
	}

	public void setHealthFileType(String healthFileType) {
		this.healthFileType = healthFileType;
	}

	@Column(name = "CHRONIC_DISEASE_ID")
	public Integer getChronicDiseaseId() {
		return this.chronicDiseaseId;
	}

	public void setChronicDiseaseId(Integer chronicDiseaseId) {
		this.chronicDiseaseId = chronicDiseaseId;
	}

	@Column(name = "AGE")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Column(name = "FILE_NUM")
	public String getFileNum() {
		return this.fileNum;
	}

	public void setFileNum(String fileNum) {
		this.fileNum = fileNum;
	}

}