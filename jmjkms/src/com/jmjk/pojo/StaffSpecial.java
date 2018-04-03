/**
 *Project Name:jmjkms
 *File Name:staffSpecial.java
 *Package Name:com.jmjk.pojo
 *Date:2017年1月16日下午7:22:08
 *Copyright (c) 2017, chenzhou1025@126.com All Rights Reserved.
 */
package com.jmjk.pojo;

import com.jmjk.entity.TStaff;

/** 
 * ClassName:staffSpecial <br/> 
 * Function: TODO ADD FUNCTION. <br/> 
 * Reason:   TODO ADD REASON. <br/> 
 * Date:     2017年1月16日 下午7:22:08 <br/> 
 * @author   xuleping 1172005694@qq.com 
 * @version   
 * @since    JDK 1.8 
 * @see       
 */
public class StaffSpecial {
	private TStaff sta;
	private String comHos;
	private String comGroup;
	
	public StaffSpecial() {
		super();
	}

	
	public StaffSpecial(TStaff sta, String comHos, String comGroup) {
		super();
		this.sta = sta;
		this.comHos = comHos;
		this.comGroup = comGroup;
	}

	
	public TStaff getSta() {
		return sta;
	}


	public void setSta(TStaff sta) {
		this.sta = sta;
	}


	public String getComHos() {
		return comHos;
	}

	public void setComHos(String comHos) {
		this.comHos = comHos;
	}

	public String getComGroup() {
		return comGroup;
	}

	public void setComGroup(String comGroup) {
		this.comGroup = comGroup;
	}
	

}
  