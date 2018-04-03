package com.jmjk.pojo;

import java.util.Date;

/**
 *  预警请求参数实体
 * @author 赖清发
 *
 */
public class AlarmRequestParam {
	
		private String appKey;        //对接系统Key
		private String appUserID;	  //对接系统用户ID
		private Date startTime;       //起始时间
		private Date endTime;         //结束时间
		
		public String getAppKey() {
			return appKey;
		}
		public void setAppKey(String appKey) {
			this.appKey = appKey;
		}
		public String getAppUserID() {
			return appUserID;
		}
		public void setAppUserID(String appUserID) {
			this.appUserID = appUserID;
		}
		public Date getStartTime() {
			return startTime;
		}
		public void setStartTime(Date startTime) {
			this.startTime = startTime;
		}
		public Date getEndTime() {
			return endTime;
		}
		public void setEndTime(Date endTime) {
			this.endTime = endTime;
		}
	
}
