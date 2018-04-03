package com.jmjk.enums;
/**
 * 用于在 个人 新增 体检页面 的精确搜索 
 * @author zfl
 *
 */
public enum AddPhysicalExamSearch {
	
	healthFileId(3,"档案编号"),
	idNum(1,"身份证号"),
	name(2,"姓名");
	
	private int value;
	private String description;
	private AddPhysicalExamSearch(int value,String description){
		this.value=value;
		this.description=description;
	}
	
	public static AddPhysicalExamSearch value(int n){
		switch(n){
		case 0:
			return healthFileId;
		case 1:
			return idNum;
		case 2:
			return name;
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
