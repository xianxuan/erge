package com.jmjk.geetest;

/**
 * GeetestWeb配置文件
 * 
 *
 */
public class GeetestConfig {

	// 填入自己的captcha_id和private_key
	private static final String captcha_id = "a81813ef00ffb437fd8c297619e12b0b";
	private static final String private_key = "b497b0eefd53d32c60c9e56e495c21cc";

	public static final String getCaptcha_id() {
		return captcha_id;
	}

	public static final String getPrivate_key() {
		return private_key;
	}

}
