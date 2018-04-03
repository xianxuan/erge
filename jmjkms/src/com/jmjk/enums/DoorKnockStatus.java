package com.jmjk.enums;

/**
 * 上门随访状态
 * 0,"暂缓处理"
 * 1,"待处理" 
 * 2,"不处理" 
 * 3,"已处理"
 * @author houzichang
 * 
 */
public enum DoorKnockStatus {

	/**
	 * 暂缓处理0
	 */
	STATUS_TEMPORARY(0,"暂缓处理"),
	/**
	 * 待处理1
	 */
	STATUS_STAY(1,"待处理"),
	/**
	 * 不处理2
	 */
	STATUS_NO(2,"不处理"),
	/**
	 * 已处理3
	 */
	STATUS_ALREADY(3,"已处理");
	private int value;
	private String description;
	private DoorKnockStatus(int value,String description){
		this.value=value;
		this.setDescription(description);
	}
	/**
	 * 返回状态对应值
	 * @return
	 */
	public int getValue() {
		return value;
	}
	/**
	 * 
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}
	/**
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	public static DoorKnockStatus valueof(int n){
		switch (n) {
		case 1:return DoorKnockStatus.STATUS_TEMPORARY;
		case 2:return DoorKnockStatus.STATUS_STAY;
		case 3:return DoorKnockStatus.STATUS_NO;
		case 4:return DoorKnockStatus.STATUS_ALREADY;
		default:return null;   
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
