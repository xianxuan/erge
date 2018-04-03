package com.jmjk.pojo;

import java.util.ArrayList;
import java.util.Date;

/**
 *  封装从目标系统获取的数据
 * @author 张晓光
 * 2016年8月8号
 */
public class BloodPressCloud {

	private int code;
	private String message;
	//private ArrayList<BloodPress> result;
	private Page page;
	

	public BloodPressCloud() {
		super();
	}
   
	public BloodPressCloud(int code, String message,Page page) {
		super();
		this.code = code;
		this.message = message;
		this.page = page;
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
	
	
	
	
	
	public class BloodPress{
		public int id;
		public int meaState;
		public double diaPre;
		public double sysPre;
		public int pulse;
		public int arm;
		public String meaTime;
		public int devID;
		public int takeMed;
		public String medName;
		public int abnAlarm;
		//public String analysisRresult;
		
		@Override
		public String toString() {
			return "BloodPress [id=" + id + ", meaState=" + meaState
					+ ", diaPre=" + diaPre + ", sysPre=" + sysPre + ", pulse="
					+ pulse + ", arm=" + arm + ", meaTime=" + meaTime
					+ ", devID=" + devID + ", takeMed=" + takeMed
					+ ", medName=" + medName + ", abnAlarm=" + abnAlarm
					+ ", analysisRresult=";
		}

		public BloodPress(int id, int meaState, double diaPre, double sysPre,
				int pulse, int arm, String meaTime, int devID, int takeMed,
				String medName, int abnAlarm) {
			super();
			this.id = id;
			this.meaState = meaState;
			this.diaPre = diaPre;
			this.sysPre = sysPre;
			this.pulse = pulse;
			this.arm = arm;
			this.meaTime = meaTime;
			this.devID = devID;
			this.takeMed = takeMed;
			this.medName = medName;
			this.abnAlarm = abnAlarm;
		}
		
		public BloodPress() {
			super();
		}

		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getMeaState() {
			return meaState;
		}
		public void setMeaState(int meaState) {
			this.meaState = meaState;
		}
		public double getDiaPre() {
			return diaPre;
		}
		public void setDiaPre(double diaPre) {
			this.diaPre = diaPre;
		}
		public double getSysPre() {
			return sysPre;
		}
		public void setSysPre(double sysPre) {
			this.sysPre = sysPre;
		}
		public int getPulse() {
			return pulse;
		}
		public void setPulse(int pulse) {
			this.pulse = pulse;
		}
		public int getArm() {
			return arm;
		}
		public void setArm(int arm) {
			this.arm = arm;
		}
		public String getMeaTime() {
			return meaTime;
		}
		public void setMeaTime(String meaTime) {
			this.meaTime = meaTime;
		}
		public int getDevID() {
			return devID;
		}
		public void setDevID(int devID) {
			this.devID = devID;
		}
		public int getTakeMed() {
			return takeMed;
		}
		public void setTakeMed(int takeMed) {
			this.takeMed = takeMed;
		}
		public String getMedName() {
			return medName;
		}
		public void setMedName(String medName) {
			this.medName = medName;
		}
		public int getAbnAlarm() {
			return abnAlarm;
		}
		public void setAbnAlarm(int abnAlarm) {
			this.abnAlarm = abnAlarm;
		}
	}
	public class Page{
		private String  result;
		public int pageSize;
		private int endRow;
		private int pageNum;
		private int pages;
		private int startRow;
		private int total;
		public int getEndRow() {
			return endRow;
		}
		public void setEndRow(int endRow) {
			this.endRow = endRow;
		}
		public int getPageNum() {
			return pageNum;
		}
		public void setPageNum(int pageNum) {
			this.pageNum = pageNum;
		}
		public int getPages() {
			return pages;
		}
		public void setPages(int pages) {
			this.pages = pages;
		}
		public int getStartRow() {
			return startRow;
		}
		public void setStartRow(int startRow) {
			this.startRow = startRow;
		}
		public int getTotal() {
			return total;
		}
		public void setTotal(int total) {
			this.total = total;
		}
	
		
		/*@Override
		public String toString() {
			return "Page [totalSize=" + totalSize + ", totalPage=" + totalPage
					+ ", pageSize=" + pageSize + ", currentPage=" + currentPage
					+ "]";
		}*/
		public Page() {
			super();
		}
		//page\":{\"endRow\":10,\"pageNum\":1,\"pageSize\":10,\"pages\":1,\"startRow\":0,\"total\":2
		public Page(String result,int endRow, int pageNum, int pageSize,int pages,int startRow,int total) {
			super();
			this.result=result;
			this.endRow = endRow;
			this.pageNum = pageNum;
			this.pageSize = pageSize;
			this.pages = pages;
			this.startRow=startRow;
			this.total=total;
		}

		public int getPageSize() {
			return pageSize;
		}
		public String getResult() {
			return result;
		}
		public void setResult(String result) {
			this.result = result;
		}
		public void setPageSize(int pageSize) {
			this.pageSize = pageSize;
		}
	}
}
