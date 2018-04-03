package com.jmjk.pojo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.jmjk.utils.DateUtil;
import com.jmjk.utils.TypeConverter;

public class EcgCloud {

	private int code;
	private String message;
	private Page page;
	//private ArrayList<BloodOxygen> result;
	
	

	public EcgCloud() {
		super();
	}

	public EcgCloud(int code, String message, Page page) {
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

	public static class Ecg{
		  
		private Integer id;
		private Integer hr;
		private Integer paxis;
		private Integer taxis;
		private Integer qrsaxis;
		private Integer pr;
		private Integer qt;
		private Integer qtc;
		private Integer qrs;
		private Integer rv5;
		private Integer sv1;
		private String diagnosis;
		
		private String other1;
		private String other2;
		private String other3;
		
		private String appKey;//对接系统key
		private String appUserID;//对接系统用户ID
		private Timestamp meaTime;//测量时间
		private Integer devID;//测量设备ID
		//private Integer meaState;//测量状态
		private Timestamp startTime;
		private Timestamp endTime;
		
		private String idCard;//用户身份证号
		
		private List<String> userIds;
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getHr() {
			return hr;
		}
		public void setHr(Integer hr) {
			this.hr = hr;
		}
		public Integer getPaxis() {
			return paxis;
		}
		public void setPaxis(Integer paxis) {
			this.paxis = paxis;
		}
		public Integer getTaxis() {
			return taxis;
		}
		public void setTaxis(Integer taxis) {
			this.taxis = taxis;
		}
		public Integer getQrsaxis() {
			return qrsaxis;
		}
		public void setQrsaxis(Integer qrsaxis) {
			this.qrsaxis = qrsaxis;
		}
		public Integer getPr() {
			return pr;
		}
		public void setPr(Integer pr) {
			this.pr = pr;
		}
		public Integer getQt() {
			return qt;
		}
		public void setQt(Integer qt) {
			this.qt = qt;
		}
		public Integer getQtc() {
			return qtc;
		}
		public void setQtc(Integer qtc) {
			this.qtc = qtc;
		}
		public Integer getQrs() {
			return qrs;
		}
		public void setQrs(Integer qrs) {
			this.qrs = qrs;
		}
		public Integer getRv5() {
			return rv5;
		}
		public void setRv5(Integer rv5) {
			this.rv5 = rv5;
		}
		public Integer getSv1() {
			return sv1;
		}
		public void setSv1(Integer sv1) {
			this.sv1 = sv1;
		}
		public String getDiagnosis() {
			return diagnosis;
		}
		public void setDiagnosis(String diagnosis) {
			this.diagnosis = diagnosis;
		}
		public String getOther1() {
			return other1;
		}
		public void setOther1(String other1) {
			this.other1 = other1;
		}
		public String getOther2() {
			return other2;
		}
		public void setOther2(String other2) {
			this.other2 = other2;
		}
		public String getOther3() {
			return other3;
		}
		public void setOther3(String other3) {
			this.other3 = other3;
		}

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

		public Integer getDevID() {
			return devID;
		}
		public void setDevID(Integer devID) {
			this.devID = devID;
		}
		public String getMeaTime() {
			return DateUtil.timestamp2Str(meaTime);
		}
		public void setMeaTime(Timestamp meaTime) {
			this.meaTime = meaTime;
		}
		/*public String getStartTime() {
			return DateUtil.timestamp2Str(startTime);
		}*/
		public void setStartTime(Timestamp startTime) {
			this.startTime = startTime;
		}
		/*public String getEndTime() {
			return DateUtil.timestamp2Str(endTime);
		}*/
		public void setEndTime(Timestamp endTime) {
			this.endTime = endTime;
		}
		public void setUserIds(List<String> userIds) {
			this.userIds = userIds;
		}
		public void setIdCard(String idCard) {
			this.idCard = idCard;
		}
		public String getIdCard() {
			return idCard;
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
