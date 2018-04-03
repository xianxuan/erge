package com.jmjk.export;

import com.jmjk.entity.TComminityClinic;

/**
 * 社区义诊
 * @author houzichang
 *
 */
public class ComminityClinicExport {

	//1 义诊对象
	public String forPerson;
	//2 参与者
	public String participatePerson;
	//3计划时间
	public String planTime;
	//4制定时间
	public String formulateTime;
	//5状态
	public String status;
	//6制定人
	public String TStaff;
	
	public String[] getTitles(){
		String[] titles = {"义诊对象","参与者","计划时间","制定时间","状态","制定人"};
		return titles;
	}
	public ComminityClinicExport(){}
	public ComminityClinicExport(TComminityClinic comminityClinic){
		super();
		this.forPerson = comminityClinic.getForPerson();
		this.participatePerson = comminityClinic.getParticipatePerson();
		if (comminityClinic.getPlanTime() != null) {
			this.planTime = comminityClinic.getPlanTime().toString();
		}
		if (comminityClinic.getFormulateTime() != null) {
			this.formulateTime = comminityClinic.getFormulateTime().toString();
		}
		if (comminityClinic.getStatus() != null) {
			if (comminityClinic.getStatus().equals("0")) {
				this.status = "暂缓处理";
			}else if (comminityClinic.getStatus().equals("1")) {
				this.status = "待处理";
			}else if (comminityClinic.getStatus().equals("2")) {
				this.status = "不处理";
			}else {
				this.status = "已处理";
			}
		}
		this.TStaff = comminityClinic.getTStaff().getName();
	}
	
	/*** get set ******/
	public String getForPerson() {
		return forPerson;
	}
	public void setForPerson(String forPerson) {
		this.forPerson = forPerson;
	}
	public String getParticipatePerson() {
		return participatePerson;
	}
	public void setParticipatePerson(String participatePerson) {
		this.participatePerson = participatePerson;
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
    
