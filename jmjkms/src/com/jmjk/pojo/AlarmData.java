package com.jmjk.pojo;
public class AlarmData{
	
	public String alarmQuota;      //预警指标	
	public String alarmTime;         //结束时间
	public int alarmType;          //预警类型
	public String appKey;
	public int appUserID;
	public int devID;              //设备ID
	public int id; 
    public String idCard;   //身份证号
    public int level;              //预警级别
    public String meaTime;           //测量时间	    
    public String other1;
    public String other2;
    public String other3;
    public int state;             //状态
	
	public String IPhone;          //本人联系电话电话
	public Boolean sex;            //性别 0  1
	public String fileNum;         //档案编号
	public String name;            //姓名
	public String healthFileId;    //档案id

	
	@Override
	public String toString() {
		return "AlarmData [alarmQuota=" + alarmQuota + ", alarmTime=" + alarmTime
				+ ", alarmType=" + alarmType + ", appKey=" + appKey
				+ ", appUserID=" + appUserID + ", devID=" + devID
				+ ", id=" + id + ", idCard=" + idCard
				+ ", level=" + level + ", meaTime=" + meaTime
				+ ", other1=" + other1 + ", other2=" + other2 + ", other3="
				+ other3 +", state=" + state+", IPhone=" + IPhone+", sex=" + sex
				+", fileNum=" + fileNum+", name=" + name+", healthFileId=" + healthFileId+ "]";
	}
	public AlarmData(String alarmQuota, String alarmTime,int alarmType,
			String appKey, int appUserID, int devID,int id, String idCard,int level,
			String meaTime, String other1,String other2,String other3, int state,
			String IPhone,Boolean sex,String fileNum,String name,String healthFileId) {
		super();
		this.alarmQuota = alarmQuota;
		this.alarmTime = alarmTime;
		this.alarmType = alarmType;
		this.appKey = appKey;
		this.appUserID = appUserID;
		this.devID = devID;
		this.id = id;
		this.idCard = idCard;
		this.level = level;
		this.meaTime = meaTime;
		this.devID = devID;
		this.other1 = other1;
		this.other2 = other2;
		this.other3 = other3;
		this.state = state;
		this.IPhone = IPhone;
		this.sex = sex;
		this.fileNum = fileNum;
		this.name = name;
		this.healthFileId = healthFileId;
		
	}
	public String getHealthFileId() {
        return healthFileId;
    }
    public void setHealthFileId(String healthFileId) {
        this.healthFileId = healthFileId;
    }
    public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getOther1() {
		return other1;
	}
	public void setOther1(String other1) {
		this.other1 = other1;
	}
	public String getOther2() {
		return other2;
	}
	public void setOther2(String other2) {
		this.other2 = other2;
	}
	public String getOther3() {
		return other3;
	}
	public void setOther3(String other3) {
		this.other3 = other3;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getAppUserID() {
		return appUserID;
	}
	public void setAppUserID(int appUserID) {
		this.appUserID = appUserID;
	}
	public AlarmData() {
		super();
	}
	public String getIPhone() {
		return IPhone;
	}
	public void setIPhone(String iPhone) {
		IPhone = iPhone;
	}
	public Boolean getSex() {
		return sex;
	}
	public void setSex(Boolean sex) {
		this.sex = sex;
	}
	public String getFileNum() {
		return fileNum;
	}
	public void setFileNum(String fileNum) {
		this.fileNum = fileNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMeaTime() {
		return meaTime;
	}
	public void setMeaTime(String meaTime) {
		this.meaTime = meaTime;
	}
	public String getAlarmTime() {
		return alarmTime;
	}
	public void setAlarmTime(String alarmTime) {
		this.alarmTime = alarmTime;
	}
	public int getAlarmType() {
		return alarmType;
	}
	public void setAlarmType(int alarmType) {
		this.alarmType = alarmType;
	}
	public String getAlarmQuota() {
		return alarmQuota;
	}
	public void setAlarmQuota(String alarmQuota) {
		this.alarmQuota = alarmQuota;
	}

	public int getDevID() {
		return devID;
	}
	public void setDevID(int devID) {
		this.devID = devID;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	
}