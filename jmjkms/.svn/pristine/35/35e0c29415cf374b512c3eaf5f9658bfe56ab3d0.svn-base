package com.jmjk.enums;

/**
 * 权限值value
 * @author Songhuili
 *
 */
public enum RightsValue {
	
	/**
	 * 显示1
	 */
	xianshi(1,"显示"),
	
	/**
	 * 添加2
	 */
	tianjia(2,"添加"),
	
	/**
	 * 修改4
	 */
	xiugai(4,"修改"),
	
	/**
	 * 删除8
	 */
	shanchu(8,"删除"),
	
	/**
	 * 打印16
	 */
	dayin(16,"打印"),
	
	/**
	 * 导出32
	 */
	daochu(32,"导出");
	
	private String description;
	private int value;
	
	public static RightsValue value(int c){
		switch(c){
		case 1:
			return xianshi;
		case 2:
			return tianjia;
		case 4:
			return xiugai;
		case 8:
			return shanchu;
		case 16:
			return dayin;
		case 32:
			return daochu;
		default:
			return null;
		}
	}

	private RightsValue( int value,String description) {
		this.description = description;
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	

}
