package com.jmjk.enums;

public enum SEX_INT {
	MAN(2,"男"),
	WOMAN(1,"女"),
	ALL(0,"全部");
	
	private int value;
	private String description;
	private SEX_INT(int value,String description){
		this.value=value;
		this.description=description;
	}
	
	public static SEX_INT value(int n){
		switch(n){
		case 3:
			return MAN;
		case 1:
			return WOMAN;
		case 2:
			return ALL;
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
