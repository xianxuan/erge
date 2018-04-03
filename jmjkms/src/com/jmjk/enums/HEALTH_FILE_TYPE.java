package com.jmjk.enums;

public enum HEALTH_FILE_TYPE {
	
	zhuxiao(2,"注销"),
	
	siwang(4,"死亡"),
	
    zhengchang(8,"正常");
	
	private int value;
	private String description;
	
	public static HEALTH_FILE_TYPE value(int c){
		switch(c){
		case 0:
			return zhuxiao;
		case 1:
			return siwang;
		case 2:
			return zhengchang;
		
		default:
			return null;
		}
	}
	
	private HEALTH_FILE_TYPE(int value, String description) {
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
