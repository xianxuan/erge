package com.jmjk.pojo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.jmjk.utils.TypeConverter;

public class XKHealthMachineCloud {

	
	private int code;
	private String message;
	private Page page;
	//private ArrayList<BloodOxygen> result;
	
	

	public XKHealthMachineCloud() {
		super();
	}

	public XKHealthMachineCloud(int code, String message, Page page) {
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


	public static class XKHealthMachine{
		
		private Integer id;
		private String machineID;
		private String examTime;
		private Integer JCXMID;//检测项目ID
		private String JCXM;//检测项目
		private String personName;
		private String IDNumber;
		private String nation;
		private String sex;
		private Integer age;
		private String address;
		private String telephone;
		private String ZS;//主诉
		private String JWS;//既往史
		private String testData;//检测记录
		private String ZDBG;//诊断报告
		private String JJFA;//解决方案
		private String appKey;//对接系统key
		private String appUserID;//对接系统用户ID
		private Timestamp meaTime;//测量时间
		private Integer devID;//测量设备ID
		//private Integer meaState;//测量状态
		private Timestamp startTime;
		private Timestamp endTime;
		
		private String idCard;//用户身份证号
		
		private List<String> userIds;
		
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
			Date date = new Date(meaTime.getTime());
			return TypeConverter.convertDate2String(date, "yyyy-MM-dd HH:mm:ss");
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
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getMachineID() {
			return machineID;
		}
		public void setMachineID(String machineID) {
			this.machineID = machineID;
		}
		public String getExamTime() {
			return examTime;
		}
		public void setExamTime(String examTime) {
			this.examTime = examTime;
		}
		public Integer getJCXMID() {
			return JCXMID;
		}
		public void setJCXMID(Integer jCXMID) {
			JCXMID = jCXMID;
		}
		public String getJCXM() {
			return JCXM;
		}
		public void setJCXM(String jCXM) {
			JCXM = jCXM;
		}
		public String getPersonName() {
			return personName;
		}
		public void setPersonName(String personName) {
			this.personName = personName;
		}
		public String getIDNumber() {
			return IDNumber;
		}
		public void setIDNumber(String iDNumber) {
			IDNumber = iDNumber;
		}
		public String getNation() {
			return nation;
		}
		public void setNation(String nation) {
			this.nation = nation;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		public String getZS() {
			return ZS;
		}
		public void setZS(String zS) {
			ZS = zS.replace("\r", "<br>");
		}
		public String getJWS() {
			return JWS;
		}
		public void setJWS(String jWS) {
			JWS = jWS.replace("\r", "<br>");
		}
		public String getTestData() {
			return testData;
		}
		public void setTestData(String testData) {
			this.testData = testData;
		}
		public String getZDBG() {
			return ZDBG;
		}
		public void setZDBG(String zDBG) {
			ZDBG = zDBG.replace("\r", "<br>");
		}
		public String getJJFA() {
			return JJFA;
		}
		public void setJJFA(String jJFA) {
			JJFA = jJFA.replace("\r", "<br>");
		}
		@Override
		public String toString() {
			return "XKHealthMachine [id=" + id + ", machineID=" + machineID
					+ ", examTime=" + examTime + ", JCXMID=" + JCXMID
					+ ", JCXM=" + JCXM + ", personName=" + personName
					+ ", IDNumber=" + IDNumber + ", nation=" + nation
					+ ", sex=" + sex + ", age=" + age + ", address=" + address
					+ ", telephone=" + telephone + ", ZS=" + ZS + ", JWS="
					+ JWS + ", testData=" + testData + ", ZDBG=" + ZDBG
					+ ", JJFA=" + JJFA + ", appKey=" + appKey + ", appUserID="
					+ appUserID + ", meaTime=" + meaTime + ", devID=" + devID
					+ ", startTime=" + startTime + ", endTime=" + endTime
					+ ", idCard=" + idCard + ", userIds=" + userIds + "]";
		}
		public XKHealthMachine() {
			super();
		}
		
		public XKHealthMachine(Integer id, String machineID, String examTime,
				Integer jCXMID, String jCXM, String personName,
				String iDNumber, String nation, String sex, Integer age,
				String address, String telephone, String zS, String jWS,
				String testData, String zDBG, String jJFA) {
			super();
			this.id = id;
			this.machineID = machineID;
			this.examTime = examTime;
			JCXMID = jCXMID;
			JCXM = jCXM;
			this.personName = personName;
			IDNumber = iDNumber;
			this.nation = nation;
			this.sex = sex;
			this.age = age;
			this.address = address;
			this.telephone = telephone;
			ZS = zS.replace("\r", "<br>");
			JWS = jWS.replace("\r", "<br>");
			this.testData = testData;
			ZDBG = zDBG.replace("\r", "<br>");
			JJFA = jJFA.replace("\r", "<br>");
		}
		public XKHealthMachine(Integer id, String machineID, String examTime,
				Integer jCXMID, String jCXM, String personName,
				String iDNumber, String nation, String sex, Integer age,
				String address, String telephone, String zS, String jWS,
				String testData, String zDBG, String jJFA, String appKey,
				String appUserID, Timestamp meaTime, Integer devID,
				Timestamp startTime, Timestamp endTime, String idCard,
				List<String> userIds) {
			super();
			this.id = id;
			this.machineID = machineID;
			this.examTime = examTime;
			JCXMID = jCXMID;
			JCXM = jCXM;
			this.personName = personName;
			IDNumber = iDNumber;
			this.nation = nation;
			this.sex = sex;
			this.age = age;
			this.address = address;
			this.telephone = telephone;
			ZS = zS.replace("\r", "<br>");
			JWS = jWS.replace("\r", "<br>");
			this.testData = testData;
			ZDBG = zDBG.replace("\r", "<br>");
			JJFA = jJFA.replace("\r", "<br>");
			this.appKey = appKey;
			this.appUserID = appUserID;
			this.meaTime = meaTime;
			this.devID = devID;
			this.startTime = startTime;
			this.endTime = endTime;
			this.idCard = idCard;
			this.userIds = userIds;
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
