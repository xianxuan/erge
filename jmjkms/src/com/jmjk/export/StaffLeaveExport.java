package com.jmjk.export;

import java.sql.Timestamp;

import com.jmjk.entity.TStaffLeave;
import com.jmjk.entity.view.VStaffLeave;

public class StaffLeaveExport {
	//1.员工编码
	public String staffNum;
	//2.员工姓名
	public String staffName;
	//3.请假原因
	public String leaveReason;
	//4.请假时间
	public String leaveDate;
	//5.请假天数
	public String days;
	//6.实际请假天数
	public String  actualDays;
	//7.销假时间
	public String comebackDate;
	//8.说明
	public String note;
	
	public String[] getTitles(){
		String[] titles = {
				"员工编码","员工姓名","请假原因","请假时间","请假天数","实际请假天数","销假时间","说明"
		};
		return titles;
	}
	public StaffLeaveExport(){}
	public StaffLeaveExport(TStaffLeave staffLeave){
		this.staffNum = staffLeave.getTStaff().getStaffNumber();
		this.staffName = staffLeave.getTStaff().getName();
		this.leaveReason = staffLeave.getLeaveReason();
		if(staffLeave.getLeaveDate() != null){
		this.leaveDate = staffLeave.getLeaveDate().toString();
		}
		if(staffLeave.getDays() != null){
			this.days = staffLeave.getDays().toString();
		}
		if(staffLeave.getActualDays() != null){
			this.actualDays = staffLeave.getActualDays().toString();
		}
		if(staffLeave.getComebackDate() != null){
			this.comebackDate = staffLeave.getComebackDate().toString();
		}
		this.note = staffLeave.getNote();
		
	}
	public StaffLeaveExport(VStaffLeave staffLeave){
		this.staffNum = staffLeave.getStaffNumber();
		this.staffName = staffLeave.getName();
		this.leaveReason = staffLeave.getLeaveReason();
		if(staffLeave.getLeaveDate() != null){
		this.leaveDate = staffLeave.getLeaveDate().toString();
		}
		if(staffLeave.getDays() != null){
			this.days = staffLeave.getDays().toString();
		}
		if(staffLeave.getActualDays() != null){
			this.actualDays = staffLeave.getActualDays().toString();
		}
		if(staffLeave.getComebackDate() != null){
			this.comebackDate = staffLeave.getComebackDate().toString();
		}
		this.note = staffLeave.getNote();
	}

	public String getStaffNum() {
		return staffNum;
	}

	public void setStaffNum(String staffNum) {
		this.staffNum = staffNum;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public String getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}

	public String getDays() {
		return days;
	}

	public void setDays(String days) {
		this.days = days;
	}

	public String getActualDays() {
		return actualDays;
	}

	public void setActualDays(String actualDays) {
		this.actualDays = actualDays;
	}

	public String getComebackDate() {
		return comebackDate;
	}

	public void setComebackDate(String comebackDate) {
		this.comebackDate = comebackDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	

}
