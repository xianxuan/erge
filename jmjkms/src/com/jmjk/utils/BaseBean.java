package com.jmjk.utils;

import java.sql.Timestamp;
import java.util.List;


public class BaseBean {
	private String appKey;//�Խ�ϵͳkey
	private String appUserID;//�Խ�ϵͳ�û�ID
	private Timestamp meaTime;//����ʱ��
	private Integer devID;//�����豸ID
	//private Integer meaState;//����״̬
	private Timestamp startTime;
	private Timestamp endTime;
	
	private String idCard;//�û����֤��
	
	private List<String> userIds;
	
	public String getAppKey() {
		return appKey;
	}
	public void setAppKey(String appKey) {
		this.appKey = appKey;
	}
	public String getAppUserID() {
		return appUserID;
	}
	public void setAppUserID(String appUserID) {
		this.appUserID = appUserID;
	}

	public Integer getDevID() {
		return devID;
	}
	public void setDevID(Integer devID) {
		this.devID = devID;
	}
	public String getMeaTime() {
		return DateUtil.timestamp2Str(meaTime);
	}
	public void setMeaTime(Timestamp meaTime) {
		this.meaTime = meaTime;
	}
	/*public String getStartTime() {
		return DateUtil.timestamp2Str(startTime);
	}*/
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	/*public String getEndTime() {
		return DateUtil.timestamp2Str(endTime);
	}*/
	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}
	public void setUserIds(List<String> userIds) {
		this.userIds = userIds;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getIdCard() {
		return idCard;
	}
	
	
	
}
