package com.jmjk.pojo;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Id;

import freemarker.cache.StringTemplateLoader;







/**
 * 预警查询拿数据
 * @author 赖清发
 *
 */
public class AlarmGetDateGet {
	
	
	private int code;
	private String message;
	private Page page;
	//private ArrayList<AlarmData> result;
	
	

	public AlarmGetDateGet() {
		super();
	}

	public AlarmGetDateGet(int code, String message, Page page) {
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


	public class AlarmData{
		public String alarmQuota;      //预警指标	
		public String alarmTime;         //结束时间
		public int alarmType;          //预警类型
		public String appKey;
		public int appUserID;
		public int devID;              //设备ID
		public int id; 
	    public String idCard;   //身份证号
	    public int level;              //预警级别
	    public String meaTime;           //测量时间	    
	    public String other1;
	    public String other2;
	    public String other3;
	    public int state;             //状态
		
		public String IPhone;          //本人联系电话电话
		public Boolean sex;            //性别 0  1
		public String fileNum;         //档案编号
		public String name;            //姓名
		public String healthFileId;    //档案id


		@Override
	    public String toString() {
	        return "AlarmData [alarmQuota=" + alarmQuota + ", alarmTime=" + alarmTime
	                + ", alarmType=" + alarmType + ", appKey=" + appKey
	                + ", appUserID=" + appUserID + ", devID=" + devID
	                + ", id=" + id + ", idCard=" + idCard
	                + ", level=" + level + ", meaTime=" + meaTime
	                + ", other1=" + other1 + ", other2=" + other2 + ", other3="
	                + other3 +", state=" + state+", IPhone=" + IPhone+", sex=" + sex
	                +", fileNum=" + fileNum+", name=" + name+", healthFileId=" + healthFileId+ "]";
	    }
	    public AlarmData(String alarmQuota, String alarmTime,int alarmType,
	            String appKey, int appUserID, int devID,int id, String idCard,int level,
	            String meaTime, String other1,String other2,String other3, int state,
	            String IPhone,Boolean sex,String fileNum,String name,String healthFileId) {
	        super();
	        this.alarmQuota = alarmQuota;
	        this.alarmTime = alarmTime;
	        this.alarmType = alarmType;
	        this.appKey = appKey;
	        this.appUserID = appUserID;
	        this.devID = devID;
	        this.id = id;
	        this.idCard = idCard;
	        this.level = level;
	        this.meaTime = meaTime;
	        this.devID = devID;
	        this.other1 = other1;
	        this.other2 = other2;
	        this.other3 = other3;
	        this.state = state;
	        this.IPhone = IPhone;
	        this.sex = sex;
	        this.fileNum = fileNum;
	        this.name = name;
	        this.healthFileId = healthFileId;
	        
	    }
		
		public AlarmData() {
			super();
		}
		public String getIPhone() {
			return IPhone;
		}
		public void setIPhone(String iPhone) {
			IPhone = iPhone;
		}
		public Boolean getSex() {
			return sex;
		}
		public void setSex(Boolean sex) {
			this.sex = sex;
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
	
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getMeaTime() {
			return meaTime;
		}
		public void setMeaTime(String meaTime) {
			this.meaTime = meaTime;
		}
		public String getAlarmTime() {
			return alarmTime;
		}
		public void setAlarmTime(String alarmTime) {
			this.alarmTime = alarmTime;
		}
		public int getAlarmType() {
			return alarmType;
		}
		public void setAlarmType(int alarmType) {
			this.alarmType = alarmType;
		}
		public String getAlarmQuota() {
			return alarmQuota;
		}
		public void setAlarmQuota(String alarmQuota) {
			this.alarmQuota = alarmQuota;
		}
		public int getState() {
			return state;
		}
		public void setState(int state) {
			this.state = state;
		}
		public int getDevID() {
			return devID;
		}
		public void setDevID(int devID) {
			this.devID = devID;
		}
		public int getLevel() {
			return level;
		}
		public String getAppKey() {
			return appKey;
		}
		public void setAppKey(String appKey) {
			this.appKey = appKey;
		}
		public int getAppUserID() {
			return appUserID;
		}
		public void setAppUserID(int appUserID) {
			this.appUserID = appUserID;
		}
	
		public String getIdCard() {
			return idCard;
		}
		public void setIdCard(String idCard) {
			this.idCard = idCard;
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
		public void setLevel(int level) {
			this.level = level;
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
	
//	
//				private int id; //序号
//				private String IPhone;//本人联系电话电话
//				private Boolean sex;//性别 0  1
//				private String sexString;//性别 男女
//				private String fileNum;//档案编号
//				private String name;//姓名
//				private Integer healthFileId;//健康档案ID
//				private Date meaTime; //测量时间
//				private Date alarmTime; //结束时间
//				private int alarmType; //预警类型
//				private String alarmQuota; //预警指标
//				private int status; //状态
//				private String statusString;//状态   1-待处理、2-已处理、3-暂缓处理、4-不处理
//				private Integer devID;//设备ID
//				/**
//				 * 预警级别没有提供数据类型
//				 */
//				private String level; //预警级别			
//				private Page page;
//				
//				
//				
//			    public  String togetsexString (){
//			    	
//			    	if(sex!= null){
//						if(sex== true){
//							sexString = "女";
//						}else{
//							sexString = "男";
//						}
//					}
//					return sexString;
//			    	
//			    }
//				
//				public String togetstatusString(){
//					if(status==1){
//						statusString="待处理";
//					}else if(status==2){
//						statusString="已处理";
//					}else if(status==3){
//						statusString="暂缓处理";
//					}else if(status==4){
//						statusString="不处理";
//					}
//					
//					return statusString;
//				}
//				
//				
//				
//
//					
//				
//				
//				public int getAlarmType() {
//					return alarmType;
//				}
//				public void setAlarmType(int alarmType) {
//					this.alarmType = alarmType;
//				}
//				public String getAlarmQuota() {
//					return alarmQuota;
//				}
//				public void setAlarmQuota(String alarmQuota) {
//					this.alarmQuota = alarmQuota;
//				}
//				public int getStatus() {
//					return status;
//				}
//				public void setStatus(int status) {
//					this.status = status;
//				}
//				
//				public Date getMeaTime() {
//					return meaTime;
//				}
//				public void setMeaTime(Date meaTime) {
//					this.meaTime = meaTime;
//				}
//				public Date getAlarmTime() {
//					return alarmTime;
//				}
//				public void setAlarmTime(Date alarmTime) {
//					this.alarmTime = alarmTime;
//				}
//				public Integer getDevID() {
//					return devID;
//				}
//				public void setDevID(Integer devID) {
//					this.devID = devID;
//				}
//				public String getLevel() {
//					return level;
//				}
//				public void setLevel(String level) {
//					this.level = level;
//				}
//				public String getIPhone() {
//					return IPhone;
//				}
//				public void setIPhone(String iPhone) {
//					IPhone = iPhone;
//				}
//				public Boolean getSex() {
//					return sex;
//				}
//				public void setSex(Boolean sex) {
//					this.sex = sex;
//				}
//				public String getFileNum() {
//					return fileNum;
//				}
//				public void setFileNum(String fileNum) {
//					this.fileNum = fileNum;
//				}
//				public String getName() {
//					return name;
//				}
//				public void setName(String name) {
//					this.name = name;
//				}
//				public Integer getHealthFileId() {
//					return healthFileId;
//				}
//				public void setHealthFileId(Integer healthFileId) {
//					this.healthFileId = healthFileId;
//				}
//				public int getId() {
//					return id;
//				}
//				public void setId(int id) {
//					this.id = id;
//				}
//			
//				public Page getPage() {
//					return page;
//				}
//				public void setPage(Page page) {
//					this.page = page;
//				}
//				public void setAppKey(String appkey) {
//					// TODO Auto-generated method stub
//					
//				}
//				public String getSexString() {
//					return sexString;
//				}
//				public void setSexString(String sexString) {
//					this.sexString = sexString;
//				}
//				public String getStatusString() {
//					return statusString;
//				}
//				public void setStatusString(String statusString) {
//					this.statusString = statusString;
//				}
//				
//				
//				
				


