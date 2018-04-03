package com.jmjk.export;

import com.jmjk.pojo.AlarmGetDateGet;

/**
 * 健康管理预警导出类   8、10
 * @author  赖清发
 *
 */
public class AlarmExport {
	private String fileNum;//1.档案编号
	private String name;//2.姓名	
	private String sexName;//3.性别
	private String IPhone;//4.本人联系电话电话	
	private String alarmQuota; //5.预警指标
	private String level; //6.预警级别
	private String statusName; //7.状态
	
	
	public String[] getTitles(){
		String [] titles = {//7g
			"居民健康档案编号","姓名","性别","联系方式","预警指标","预警级别","状态"
		};
		return titles;
	}
	
	public AlarmExport() {}
	public AlarmExport(AlarmGetDateGet alarmget) {
		super();
//		this.fileNum = alarmget.getFileNum();
//		this.name = alarmget.getName();
//		this.sexName=alarmget.togetsexString();
//		this.IPhone = alarmget.getIPhone();
//		this.alarmQuota=alarmget.getAlarmQuota();
//		this.level=alarmget.getLevel();
//		this.statusName=alarmget.togetstatusString();
		
		
		}

	public String getFileNum() {
		return fileNum;
	}

	public void setFileNum(String fileNum) {
		this.fileNum = fileNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSexName() {
		return sexName;
	}

	public void setSexName(String sexName) {
		this.sexName = sexName;
	}

	public String getIPhone() {
		return IPhone;
	}

	public void setIPhone(String iPhone) {
		IPhone = iPhone;
	}

	public String getAlarmQuota() {
		return alarmQuota;
	}

	public void setAlarmQuota(String alarmQuota) {
		this.alarmQuota = alarmQuota;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	
	
}
