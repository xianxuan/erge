package com.jmjk.export;

import com.jmjk.entity.THealthEdu;

/**
 * 健康教育
 * @author houzichang
 *
 */
public class HealthEducationExport {

	// 活动主题
	public String activeTheme;
	// 活动地点
	public String activePlace;
	// 活动形式
	public String activeType;
	// 活动时间
	public String activeTime;
	// 填表时间
	public String fillFormTime;
	// 组织者
	public String organizer;
	//活动对象
	public String activePeople;
	// 接受教育人员种类
	public String peopleType;
	// 接受教育人数
	public String peopleNumber;
	// 负责人
	public String TStaff;
	
	public String[] getTitles(){
		String[] titles = {"活动主题","活动地点","活动形式","活动时间","填表时间","组织者","活动对象","接受健康教育人员种类","接受健康教育人数","负责人"};
		return titles;
		
	}
	public HealthEducationExport(){}
	public HealthEducationExport(THealthEdu healthEdu){
		super();
		this.activeTheme = healthEdu.getActiveTheme();
		this.activePlace = healthEdu.getActivePlace();
		this.activeType  = healthEdu.getActiveType();
		if (healthEdu.getActiveTime() != null) {
			this.activeTime  = healthEdu.getActiveTime().toString();
		}
		if (healthEdu.getFillFormTime() != null) {
			this.fillFormTime = healthEdu.getFillFormTime().toString();
		}
		
		this.organizer = healthEdu.getOrganizer();
		this.activePeople = healthEdu.getActivePeople();
		this.peopleType = healthEdu.getPeopleType();
		if (healthEdu.getPeopleNumber() != null) {
			this.peopleNumber = healthEdu.getPeopleNumber().toString();
		}
		this.TStaff = healthEdu.getTStaff().getName();
	}
	
	/******get set ***********/
	public String getActiveTheme() {
		return activeTheme;
	}
	public void setActiveTheme(String activeTheme) {
		this.activeTheme = activeTheme;
	}
	public String getActivePlace() {
		return activePlace;
	}
	public void setActivePlace(String activePlace) {
		this.activePlace = activePlace;
	}
	public String getActiveType() {
		return activeType;
	}
	public void setActiveType(String activeType) {
		this.activeType = activeType;
	}
	public String getActiveTime() {
		return activeTime;
	}
	public void setActiveTime(String activeTime) {
		this.activeTime = activeTime;
	}
	public String getFillFormTime() {
		return fillFormTime;
	}
	public void setFillFormTime(String fillFormTime) {
		this.fillFormTime = fillFormTime;
	}
	public String getOrganizer() {
		return organizer;
	}
	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}
	public String getActivePeople() {
		return activePeople;
	}
	public void setActivePeople(String activePeople) {
		this.activePeople = activePeople;
	}
	public String getPeopleType() {
		return peopleType;
	}
	public void setPeopleType(String peopleType) {
		this.peopleType = peopleType;
	}
	public String getPeopleNumber() {
		return peopleNumber;
	}
	public void setPeopleNumber(String peopleNumber) {
		this.peopleNumber = peopleNumber;
	}
	public String getTStaff() {
		return TStaff;
	}
	public void setTStaff(String tStaff) {
		TStaff = tStaff;
	}
	
	
}
