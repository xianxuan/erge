package com.jmjk.pojo;

public class Device {
	private String type;   //设备类型
	private String code; 	//设备编号
	private String users;//使用者
	private String rate;//频率
	
	public Device() {
	      
	}
	
	public Device(String type, String code,
			String users, String rate) {
		super();
		this.setType(type);
		this.setCode(code);
		this.setUsers(users);
		this.setRate(rate);
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	
	
	
	
	
}

