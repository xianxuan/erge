package com.jmjk.utils;

public class operatorManageBean {
	private String staffNumber;
	private String staffName;
	private String loginName;
	private String department;
	private String job;
	private int isStart;//状态
	private String note;
	public String getStaffNumber() {
		return staffNumber;
	}
	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public int getIsStart() {
		return isStart;
	}
	public void setIsStart(int isStart) {
		this.isStart = isStart;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public operatorManageBean(String staffNumber, String staffName,
			String loginName, String department, String job, int isStart,
			String note) {
		super();
		this.staffNumber = staffNumber;
		this.staffName = staffName;
		this.loginName = loginName;
		this.department = department;
		this.job = job;
		this.isStart = isStart;
		this.note = note;
	}
	
	
	

}
