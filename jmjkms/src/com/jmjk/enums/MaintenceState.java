package com.jmjk.enums;
/**
 * 维修记录状态
 * 0，已解决
 * 1，未解决
 * @author Administrator
 *
 */
public enum MaintenceState {
	/**
	 * 已解决 0
	 */
	STATU_RESOLVED(0,"已解决"),
	/**
	 * 未解决 1
	 */
	STATUS_NOTRESOLVED(1,"未解决");
	
	private int value;
	private String description;
	private MaintenceState(int value,String description){
		this.value=value;
		this.setDescription(description);
	}
	/**
	 * 返回状态对应值
	 * @return
	 */
	public int getValue() {
		return value;
	}
	/**
	 * 
	 * @param value
	 */
	public void setValue(int value) {
		this.value = value;
	}
	/**
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	public static MaintenceState valueof(int n){
		switch (n) {
		case 1:return MaintenceState.STATU_RESOLVED;
		case 2:return MaintenceState.STATUS_NOTRESOLVED;
		default:return null;   
			
		}
	}	
}
