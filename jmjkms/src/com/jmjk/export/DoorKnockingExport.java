package com.jmjk.export;

import com.jmjk.entity.TDoorKnocking;


/**
 * 上门随访
 * @author houzichang
 * @param <TStaff>
 */
public class DoorKnockingExport {

	//1 随访名称
	public String visiteName;
	//2随访对象
	public String visitePeople;
	//3参与者
	public String participatePeople;
	//4计划时间
	public String planTime;
	//5制定时间
	public String formulateTime;
	//6状态
	public String status;
	//7制定人
	public String TStaff;
	
	
	public String[] getTitles() {
		String [] titles = {"随方名称","随访对象","参与者","计划时间","制定时间","状态","制定人"};
		return titles;
	}
	public DoorKnockingExport(){}
	public DoorKnockingExport(TDoorKnocking doorKnocking){
		super();
		this.visiteName = doorKnocking.getVisiteName();
		this.visitePeople = doorKnocking.getVisitePeople();
		this.participatePeople = doorKnocking.getParticipatePeople();
		if (doorKnocking.getPlanTime() != null) {
			this.planTime = doorKnocking.getPlanTime().toString();
		}
		if (doorKnocking.getFormulateTime()!= null) {
			this.formulateTime = doorKnocking.getFormulateTime().toString();
		}
		if (doorKnocking.getStatus() != null) {
			if (doorKnocking.getStatus().equals("0")) {
				this.status = "暂缓处理";
			}else if (doorKnocking.getStatus().equals("1")) {
				this.status = "待处理";
			}else if (doorKnocking.getStatus().equals("2")) {
				this.status = "不处理";
			}else {
				this.status = "已处理";
			}
		}
		this.TStaff = doorKnocking.getTStaff().getName();
	}
	

	
	/****get set ****/
	public String getVisiteName() {
		return visiteName;
		
	}
	public void setVisiteName(String visiteName) {
		this.visiteName = visiteName;
	}
	public String getVisitePeople() {
		return visitePeople;
	}
	public void setVisitePeople(String visitePeople) {
		this.visitePeople = visitePeople;
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
