package com.jmjk.enums;


public enum CHRONIC_MANAGER {
	NO_MANAGER(0,"没加入慢病管理"),
	DIABETE_MANAGER(1,"加入糖尿病管理"),
	HIGHBLOODPRESSURE_MANAGER(2,"加入高血压管理"),
	OTHER_MANAGER(3,"加入其他慢病管理"),
	DELETE_CHRONICFILE(9,"删除慢病档案/假删");
	
	private int value;
    private String description;
	

	private CHRONIC_MANAGER(int value, String description) {
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


	public static CHRONIC_MANAGER valueOf(int n){
    	switch (n) {
		case 0:return CHRONIC_MANAGER.NO_MANAGER;
		case 1:return CHRONIC_MANAGER.DIABETE_MANAGER;
		case 2:return CHRONIC_MANAGER.HIGHBLOODPRESSURE_MANAGER;
		case 3:return CHRONIC_MANAGER.OTHER_MANAGER;
		case 9:return CHRONIC_MANAGER.DELETE_CHRONICFILE;
		default:return  null;
    	}

	}
}