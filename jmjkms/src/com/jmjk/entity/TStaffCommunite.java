package com.jmjk.entity;

public class TStaffCommunite {
	private TStaff staff;
	private String commName;
	public TStaffCommunite(TStaff staff, String commName){
		this.staff = staff;
		this.commName = commName;
	}
	public TStaffCommunite(){}
	public TStaff getStaff() {
		return staff;
	}
	public void setStaff(TStaff staff) {
		this.staff = staff;
	}
	public String getCommName() {
		return commName;
	}
	public void setCommName(String commName) {
		this.commName = commName;
	}
	
}
