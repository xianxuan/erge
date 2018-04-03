package com.jmjk.enums;
/**
 * 档案状态
 * @author 苏东航
 *
 */
public enum HealthFileCheck {
	/**
	 * 注销0
	 */
	zhuxiao(0,"注销"),
	
	/**
	 * 死亡1
	 */
	siwang(1,"死亡"),
	/**
	 * 正常0
	 */
    zhengchang(2,"正常"),
	/**
	 * 删除3
	 */
	shanchu(3,"删除");
	private int value;
	private String description;
	
	public static HealthFileCheck value(int c){
		switch(c){
		case 0:
			return zhuxiao;
		case 1:
			return siwang;
		case 2:
			return zhengchang;
		case 3:
			return shanchu;
		default:
			return null;
		}
	}
	
	private HealthFileCheck(int value, String description) {
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
