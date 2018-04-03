package com.jmjk.enums;

/**
 * 员工状态枚举
 * @author Liufengshuang
 *
 */
public enum StaffState {
	tuixiu('3',"退休"),
	shixi('4',"实习"),
	zaizhi('5',"在职"),
	lizhi('6',"离职");
	
	private String description;
	private char value;
	public static StaffState value(char c){
		switch(c){
		case '3':
			return tuixiu;
		case '4':
			return shixi;
		case '5':
			return zaizhi;
		case '6':
			return lizhi;
		default:
			return null;
		}
	}
	private StaffState(char value, String description){
		this.value=value;
		this.description=description;
	}
	
	public char getvalue() {
		return value;
	}

	public void setvalue(char value) {
		this.value = value;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
