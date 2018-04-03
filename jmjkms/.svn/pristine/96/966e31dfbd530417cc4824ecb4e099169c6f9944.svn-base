package com.jmjk.enums;

/**
 *登录结果:
 * 1,"密码错误";2,"登录成功";3,验证码错误  ;4.用户不存在 ;5.该用户被禁用
 * @author 许乐平&宋慧丽
 */
public enum Result_Login {
					
    /**
     * 密码错误1
     */
	PASS_ERROR(1,"密码错误"),
    /**
     * 登录成功2
     */
    LOGIN_SUCCESS(2,"登录成功"),
    /**
     * 验证码错误3
     */
    VALI_ERROR(3,"验证码错误"),
    /**
     * 用户不存在4
     */
    
    NO_USER(4,"用户不存在"),
    /**
     * 用户被禁用5
     */
    USEABLE_ERROR(5,"用户被禁用"),
	ROLE_ERROR(6,"角色错误");
    private int value;
    private String description;
    private Result_Login(int value,String description){
 	   this.value=value;
 	   this.setDescription(description);
    }
    /**
     * @return
     * return the value
     * 返回状态对应值
     */
    public int getValue() {
        return value;
    }
	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
    public static Result_Login valueOf(int n){
    	switch (n) {
		case 1:return Result_Login.PASS_ERROR;
		case 2:return Result_Login.LOGIN_SUCCESS;
		case 3:return Result_Login.VALI_ERROR;
		case 4:return Result_Login.NO_USER;
		case 5:return Result_Login.USEABLE_ERROR;
		case 6:return Result_Login.ROLE_ERROR;
		default:return  null;
    	}
    	
    }
    
}

