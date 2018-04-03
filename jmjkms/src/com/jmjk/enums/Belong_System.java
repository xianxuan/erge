package com.jmjk.enums;

public enum Belong_System {
	shequ(1,"社区医院"),
	yanglao(2,"养老机构"),
	jujia(3,"居家养老");
	private int value;
	private String description;
	private Belong_System(int value,String description){
		this.value=value;
		this.description=description;
	}
	
	public static Belong_System value(int n){
		switch(n){
		case 1:
			return shequ;
		case 2:
			return yanglao;
		case 3:
			return jujia;
			
		default:
			return null;
		}
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
