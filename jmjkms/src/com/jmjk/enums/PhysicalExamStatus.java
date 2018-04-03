package com.jmjk.enums;
/**
 *    假删标识
 * @author zfl
 *
 */
public enum PhysicalExamStatus {
	
	delete(0,"删除");
	
	private int value;
	private String description;
	private PhysicalExamStatus(int value,String description){
		this.value=value;
		this.description=description;
	}
	
	public static PhysicalExamStatus value(int n){
		switch(n){
		case 0:
			return delete;
		default:
			return null;
		}
	}

	public int getvalue() {
		return value;
	}

	public void setvalue(int value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
