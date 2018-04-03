package com.jmjk.pojo;

import java.util.ArrayList;

public class AllInOneCloud {

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

	private int code;
	private String message;
	//private ArrayList<AIO> result;
	private Page page;

	public AllInOneCloud() {
		super();
	}

	public AllInOneCloud(int code, String message, Page page) {
		super();
		this.code = code;
		this.message = message;
		this.page = page;
	}

	/*@Override
	public String toString() {
		return "AllInOne [code=" + code + ", message=" + message + ", result="
				+ result + ", page=" + page + "]";
	}*/

	public class AIO {
		//{"appKey":"ac6b5a57f3d04e328a1e79facc860e1d","appUserID":"0000001","basalMeta":333,"bmi":111,
		//"devID":28,"diaPre":494,"fat":333,"fbs":445,"height":443,"id":4,"meaTime":"2011-01-01 10:03:40","oxygen"
		//:222,"pbs":447,"pulse":333,"rbs":464,"sysPre":484,"temperature":33,"weight":442,"xyjy":"","xypg":""}
		public int id;
		public String appID;
		public String appUserID;
		public String  devID;
		public String  meaTime;
		public double temperature;
		public double fbs;
		public double pbs;
		public double rbs;
		public int constriction;
		public int diastolic;
		public double height;
		public double weight;
		public double oximeter;
		public int bmi;
		public int pules;
		public double fat;
		public double muscle;
		private String diaPre;
		private String oxygen;
		private String sysPre;
		private String xyjy;
		private String xypg;
		
		public AIO() {
			super();
		}
		public AIO(int id,String diaPre, String oxygen, String sysPre,String appID, String appUserID, String devID,
				String meaTime, double temperature, double fbs, double pbs,
				double rbs, int constriction, int diastolic, double height,
				double weight, double oximeter, int bmi, int pules, double fat,
				double muscle,String xyjy,String xypg) {
			super();
			this.xypg=xypg;
			this.xyjy=xyjy;
			this.sysPre=sysPre;
			this.oxygen=oxygen;
			this.diaPre=diaPre;
			this.id = id;
			this.appID = appID;
			this.appUserID = appUserID;
			this.devID = devID;
			this.meaTime = meaTime;
			this.temperature = temperature;
			this.fbs = fbs;
			this.pbs = pbs;
			this.rbs = rbs;
			this.constriction = constriction;
			this.diastolic = diastolic;
			this.height = height;
			this.weight = weight;
			this.oximeter = oximeter;
			this.bmi = bmi;
			this.pules = pules;
			this.fat = fat;
			this.muscle = muscle;
		}
		public String getDiaPre() {
			return diaPre;
		}
		public void setDiaPre(String diaPre) {
			this.diaPre = diaPre;
		}
		public String getOxygen() {
			return oxygen;
		}
		public void setOxygen(String oxygen) {
			this.oxygen = oxygen;
		}
		public String getSysPre() {
			return sysPre;
		}
		public void setSysPre(String sysPre) {
			this.sysPre = sysPre;
		}
		public String getXyjy() {
			return xyjy;
		}
		public void setXyjy(String xyjy) {
			this.xyjy = xyjy;
		}
		public String getXypg() {
			return xypg;
		}
		public void setXypg(String xypg) {
			this.xypg = xypg;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getAppID() {
			return appID;
		}
		public void setAppID(String appID) {
			this.appID = appID;
		}
		public String getAppUserID() {
			return appUserID;
		}
		public void setAppUserID(String appUserID) {
			this.appUserID = appUserID;
		}
		public String getDevID() {
			return devID;
		}
		public void setDevID(String devID) {
			this.devID = devID;
		}
		public String getMeaTime() {
			return meaTime;
		}
		public void setMeaTime(String meaTime) {
			this.meaTime = meaTime;
		}
		public double getTemperature() {
			return temperature;
		}
		public void setTemperature(double temperature) {
			this.temperature = temperature;
		}
		public double getFbs() {
			return fbs;
		}
		public void setFbs(double fbs) {
			this.fbs = fbs;
		}
		public double getPbs() {
			return pbs;
		}
		public void setPbs(double pbs) {
			this.pbs = pbs;
		}
		public double getRbs() {
			return rbs;
		}
		public void setRbs(double rbs) {
			this.rbs = rbs;
		}
		public int getConstriction() {
			return constriction;
		}
		public void setConstriction(int constriction) {
			this.constriction = constriction;
		}
		public int getDiastolic() {
			return diastolic;
		}
		public void setDiastolic(int diastolic) {
			this.diastolic = diastolic;
		}
		public double getHeight() {
			return height*100;
		}
		public void setHeight(double height) {
			this.height = height;
		}
		public double getWeight() {
			return weight;
		}
		public void setWeight(double weight) {
			this.weight = weight;
		}
		public double getOximeter() {
			return oximeter;
		}
		public void setOximeter(double oximeter) {
			this.oximeter = oximeter;
		}
		public int getBmi() {
			return bmi;
		}
		public void setBmi(int bmi) {
			this.bmi = bmi;
		}
		public int getPules() {
			return pules;
		}
		public void setPules(int pules) {
			this.pules = pules;
		}
		public double getFat() {
			return fat;
		}
		public void setFat(double fat) {
			this.fat = fat;
		}
		public double getMuscle() {
			return muscle;
		}
		public void setMuscle(double muscle) {
			this.muscle = muscle;
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
