package com.jmjk.enums;

public enum IS_DELETE {
	
	delete(0,"已删除"),
	no_Delete(1,"未删除");
	private int value;
	private String description;
	private IS_DELETE(int value,String description){
		this.setValue(value);
		this.setDescription(description);
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