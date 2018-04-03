package com.jmjk.pojo;

import java.util.ArrayList;
import java.util.Date;

/**
 *  封装从目标系统获取的数据
 * @author 张晓光
 * 2016年8月8号
 */
public class BloodSugerCloud {

	private int code;
	private String message;
	//private ArrayList<BloodSuger> result;
	private Page page;
	

	public BloodSugerCloud() {
		super();
	}
   
	public BloodSugerCloud(int code, String message, Page page) {
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
	
	
	
	public class BloodSuger{
		
		public BloodSuger(int abnAlarm, String analysisRresult,
				double bloodSugar, String devID, int id, int meaState,
				String meaTime, String medName, int takeMed) {
			super();
			this.abnAlarm = abnAlarm;
			this.analysisRresult = analysisRresult;
			this.bloodSugar = bloodSugar;
			this.devID = devID;
			this.id = id;
			this.meaState = meaState;
			this.meaTime = meaTime;
			this.medName = medName;
			this.takeMed = takeMed;
		}
		public BloodSuger() {
			super();
		}
		
		@Override
		public String toString() {
			return "BloodSuger [abnAlarm=" + abnAlarm + ", analysisRresult="
					+ analysisRresult + ", bloodSugar=" + bloodSugar
					+ ", devID=" + devID + ", id=" + id + ", meaState="
					+ meaState + ", meaTime=" + meaTime + ", medName="
					+ medName + ", takeMed=" + takeMed + "]";
		}

		public int abnAlarm;
		public String analysisRresult;
		public double bloodSugar;
		public String devID;
		public int id;
		public int  meaState;
		public String meaTime;
		public String medName;
		public int  takeMed;
		
		public int getAbnAlarm() {
			return abnAlarm;
		}
		public void setAbnAlarm(int abnAlarm) {
			this.abnAlarm = abnAlarm;
		}
		public String getAnalysisRresult() {
			return analysisRresult;
		}
		public void setAnalysisRresult(String analysisRresult) {
			this.analysisRresult = analysisRresult;
		}
		public double getBloodSugar() {
			return bloodSugar;
		}
		public void setBloodSugar(double bloodSugar) {
			this.bloodSugar = bloodSugar;
		}
		public String getDevID() {
			return devID;
		}
		public void setDevID(String devID) {
			this.devID = devID;
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
		public String getMeaTime() {
			return meaTime;
		}
		public void setMeaTime(String meaTime) {
			this.meaTime = meaTime;
		}
		public String getMedName() {
			return medName;
		}
		public void setMedName(String medName) {
			this.medName = medName;
		}
		public int getTakeMed() {
			return takeMed;
		}
		public void setTakeMed(int takeMed) {
			this.takeMed = takeMed;
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
