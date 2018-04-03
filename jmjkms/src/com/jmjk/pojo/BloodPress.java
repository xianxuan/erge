package com.jmjk.pojo;
/**
 *  封装血压请求参数的pojo类
 * @author 张晓光
 *  2015年8月8号
 */
public class BloodPress {
	
	public BloodPress() {
		super();
	}
	
	public BloodPress(String appUserID,int id, Integer meaState, Double diaPre,
			Double sysPre, Integer pulse, Integer arm, String appKey,
			String  meaTime, Integer devID, Integer takeMed, String medName) {
		super();
		this.appUserID = appUserID;
		this.id=id;
		this.meaState = meaState;
		this.diaPre = diaPre;
		this.sysPre = sysPre;
		this.pulse = pulse;
		this.arm = arm;
		this.setAppKey(appKey);
		this.meaTime = meaTime;
		this.devID = devID;
		this.takeMed = takeMed;
		this.medName = medName;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	private int id;
	private String appUserID;
	private Integer meaState;
	private Double diaPre;
	private Double sysPre;
	private Integer pulse;
	private Integer arm;
	private String appKey;
	private String  meaTime;
	private Integer devID;
	private Integer takeMed;
	private String medName;
	
	public String getAppUserID() {
		return appUserID;
	}
	public void setAppUserID(String appUserID) {
		this.appUserID = appUserID;
	}
	public Integer getMeaState() {
		return meaState;
	}
	public void setMeaState(Integer meaState) {
		this.meaState = meaState;
	}
	public Double getDiaPre() {
		return diaPre;
	}
	public void setDiaPre(Double diaPre) {
		this.diaPre = diaPre;
	}
	public Double getSysPre() {
		return sysPre;
	}
	public void setSysPre(Double sysPre) {
		this.sysPre = sysPre;
	}
	public Integer getPulse() {
		return pulse;
	}
	public void setPulse(Integer pulse) {
		this.pulse = pulse;
	}
	public Integer getArm() {
		return arm;
	}
	public void setArm(Integer arm) {
		this.arm = arm;
	}

	public String getMeaTime() {
		return meaTime;
	}

	public void setMeaTime(String meaTime) {
		this.meaTime = meaTime;
	}

	public Integer getDevID() {
		return devID;
	}
	public void setDevID(Integer devID) {
		this.devID = devID;
	}
	public Integer getTakeMed() {
		return takeMed;
	}
	public void setTakeMed(Integer takeMed) {
		this.takeMed = takeMed;
	}
	public String getMedName() {
		return medName;
	}
	public void setMedName(String medName) {
		this.medName = medName;
	}

	public String getAppKey() {
		return appKey;
	}

	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}

}
