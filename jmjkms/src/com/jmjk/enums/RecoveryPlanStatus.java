package com.jmjk.enums;

public enum RecoveryPlanStatus {
	NO_STARTED("0","未开始"),
	STARTING("1","正在执行"),
	STARRED("2","已完成");
	private String value;
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private String description;
	private RecoveryPlanStatus(String  value,String description){
	 	   this.value=value;
	 	   this.description=description;
	    }
	

}
