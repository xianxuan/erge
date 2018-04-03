package com.jmjk.enums;

/**
 * 区分社区负责人和平台管理员
 * @author Songhuili
 *
 */
public enum Admin_IsHead {
	
	/**
	 * 管理员0
	 */
	guanliyuan(0,"系统管理员"),
	
	/**
	 * 社区负责人1
	 */
	shequfuzeren(1,"社区负责人");
	
	private int value;
	private String description;
	
	public static Admin_IsHead value(int c){
		switch(c){
		case 0:
			return guanliyuan;
		case 1:
			return shequfuzeren;
		default:
			return null;
		}
	}
	
	private Admin_IsHead(int value, String description) {
		this.value = value;
		this.description = description;
	}
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
