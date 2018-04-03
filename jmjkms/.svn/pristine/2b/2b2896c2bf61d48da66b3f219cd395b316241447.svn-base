package com.jmjk.enums;

/**
 * 设备管理状态
 * 0,"正常"
 * 1,"问题" 
 * @author houzichang
 * 
 */
public enum EquipmentManageStatus {

	/**
	 * 正常 0
	 */
	STATUS_NORMAL(0,"正常"),
	/**
	 * 问题1
	 */
	STATUS_problem(1,"问题");
	
	private int value;
	private String description;
	private EquipmentManageStatus(int value,String description){
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
	public static EquipmentManageStatus valueof(int n){
		switch (n) {
		case 1:return EquipmentManageStatus.STATUS_NORMAL;
		case 2:return EquipmentManageStatus.STATUS_problem;
		default:return null;   
			
		}
	}	
}