package com.jmjk.export;

import com.jmjk.entity.TKnowledgeLecture;

/**
 * 知识讲座
 * @author houzichang
 */
public class KnowledgeLectureExport {

	//1 讲座名称
	public String lectureName;
	//2 讲座对象
	public String forPerson;
	//3 参与者
	public String participatePeople;
	//4 计划时间
	public String planTime;
	//5 制定时间
	public String formulateTime;
	//6 状态
	public String status;
	//7 制定人
	public String TStaff;
	
	public String[] getTitles(){
		String[] titles = {"讲座名称","讲座对象","参与者","计划时间","制定时间","状态","制定人"};
		return titles;
	}
	
	public KnowledgeLectureExport(){};
	public KnowledgeLectureExport(TKnowledgeLecture knowledgeLecture){
		super();
		this.lectureName = knowledgeLecture.getLectureName();
		this.forPerson = knowledgeLecture.getForPerson();
		this.participatePeople = knowledgeLecture.getParticipatePeople();
		if (knowledgeLecture.getPlanTime() != null) {
			this.planTime = knowledgeLecture.getPlanTime().toString();
		}
		if (knowledgeLecture.getFormulateTime() != null) {
			this.formulateTime = knowledgeLecture.getFormulateTime().toString();
		}
		if (knowledgeLecture.getStatus() != null) {
			if (knowledgeLecture.getStatus().equals("0")) {
				this.status = "暂缓处理";
			}else if (knowledgeLecture.getStatus().equals("1")) {
				this.status = "待处理";
			}else if (knowledgeLecture.getStatus().equals("2")) {
				this.status = "不处理";
			}else {
				this.status = "已处理";
			}
		}
		this.TStaff = knowledgeLecture.getTStaff().getName();
	}

	
	/*****get set ********/
	public String getLectureName() {
		return lectureName;
	}

	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}

	public String getForPerson() {
		return forPerson;
	}

	public void setForPerson(String forPerson) {
		this.forPerson = forPerson;
	}

	public String getParticipatePeople() {
		return participatePeople;
	}

	public void setParticipatePeople(String participatePeople) {
		this.participatePeople = participatePeople;
	}

	public String getPlanTime() {
		return planTime;
	}

	public void setPlanTime(String planTime) {
		this.planTime = planTime;
	}

	public String getFormulateTime() {
		return formulateTime;
	}

	public void setFormulateTime(String formulateTime) {
		this.formulateTime = formulateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTStaff() {
		return TStaff;
	}

	public void setTStaff(String tStaff) {
		TStaff = tStaff;
	}
	
	
}
