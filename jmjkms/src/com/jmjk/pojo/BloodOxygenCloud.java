package com.jmjk.pojo;

import java.util.ArrayList;
import java.util.Date;

public class BloodOxygenCloud {

	
	private int code;
	private String message;
	private Page page;
	//private ArrayList<BloodOxygen> result;
	
	

	public BloodOxygenCloud() {
		super();
	}

	public BloodOxygenCloud(int code, String message, Page page) {
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


	public class BloodOxygen{
		
		public int id;
		public int meaState;
		public double oxygen;
		public int pulse;
		public String meaTime;
		public int devID;
		public int takeMed;
		public String medName;
		public int abnAlarm;
		public String analysisRresult;
		
		@Override
		public String toString() {
			return "BloodOxygen [id=" + id + ", meaState=" + meaState
					+ ", oxygen=" + oxygen + ", pulse=" + pulse + ", meaTime="
					+ meaTime + ", devID=" + devID + ", takeMed=" + takeMed
					+ ", medName=" + medName + ", abnAlarm=" + abnAlarm
					+ ", analysisRresult=" + analysisRresult + "]";
		}
		public BloodOxygen() {
			super();
		}
		public BloodOxygen(int id, int meaState, double oxygen, int pulse,
				String meaTime, int devID, int takeMed, String medName,
				int abnAlarm, String analysisRresult) {
			super();
			this.id = id;
			this.meaState = meaState;
			this.oxygen = oxygen;
			this.pulse = pulse;
			this.meaTime = meaTime;
			this.devID = devID;
			this.takeMed = takeMed;
			this.medName = medName;
			this.abnAlarm = abnAlarm;
			this.analysisRresult = analysisRresult;
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
		public double getOxygen() {
			return oxygen;
		}
		public void setOxygen(double oxygen) {
			this.oxygen = oxygen;
		}
		public int getPulse() {
			return pulse;
		}
		public void setPulse(int pulse) {
			this.pulse = pulse;
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
		public String getAnalysisRresult() {
			return analysisRresult;
		}
		public void setAnalysisRresult(String analysisRresult) {
			this.analysisRresult = analysisRresult;
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
