package com.jmjk.enums;

import org.hibernate.type.TrueFalseType;

/**
 * 性别的类别
 * @author 张晓光
 * 2016年8月
 */
public enum ESex_State {

	/**
	 * 男为true
	 */
	MALE(true,"男"),
	/**
	 * 女为false
	 */
    FEMALE(false,"女");
    
	private boolean value;
    private String description;
    
    private ESex_State(Boolean value,String description){
 	   this.value=value;
 	   this.setDescription(description);
    }
    /**
     * @return
     * return the value
     * 返回状态对应值
     */
    public boolean getValue() {
        return value;
    }
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    public static ESex_State valueOf(Boolean n){
    	if(n == true){
    		return ESex_State.MALE;
    	}else{
    		return ESex_State.FEMALE;
    	}
    }
}
