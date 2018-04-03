package com.jmjk.enums;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

public enum StaffRewardPunishEnum {

	
	
	rewordPunishReason_1(1,"年终奖"),
	rewordPunishReason_2(2,"加班奖"),
	rewordPunishReason_3(3,"救死扶伤奖"),
	rewordPunishReason_4(4,"迟到惩罚");
	
	private int value;
	private String description;
	private StaffRewardPunishEnum(int value,String description){
		this.value=value;
		this.description=description;
	}
	
	
	public static StaffRewardPunishEnum value(int n){
		switch(n){
		case 0:
			return rewordPunishReason_1;
		case 1:
			return 	rewordPunishReason_2;
		case 2:
			return  rewordPunishReason_3;
		case 3:
			return  rewordPunishReason_4;
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
