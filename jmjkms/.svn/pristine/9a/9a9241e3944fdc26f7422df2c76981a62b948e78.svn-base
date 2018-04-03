package com.jmjk.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jmjk.enums.ESex_State;
import com.jmjk.enums.HealthFileCheck;

/**
 * 先用着看看, 记得用的时候debug 看看hql 语句拼的对不对 !!!
 * @author Liufengshuang
 *
 */
public class SearchBeanSU {
	private int selectFlag; //查询选项---居民条件 0空  1姓名  name 2身份证号  idNum  3档案编号 fileNum 
	private String selectValue; //查询值   
	private int highAge;  //年龄 高 age
	private int lowAge; //年龄 低 age
	private Date highBrithday; //出生日期 高 birthDate
	private Date lowBrithday; //出生日期  低
	private Date highFileDate; // 建档日期 高 fileFileDate
	private Date lowFileDate; //建档日期  低
	private String staffName;  //责任医生 staffName
	private int staffId;  //责任医生 id
	private String filePeople;  //建档人   filePerson
	private String enterPeople; //录入人 enterPeople
	private int sex;//性别查询 sex
	private int danganzhuangtai;//档案状态 healthFileType
	private String  sheng;//地址省 otherProvince
	private String shi;//市 otherCity
	private String qu; //区otherCounty
	private int[] renqun; //diseaseName 在慢病总表中存的疾病名称
	private String jutidizhi;//详细地址   otherCommunity
	private int shenfen;//登录身份
	private int sqid;//社区医院id
	private int ysid;//责任医生id
	int zc = HealthFileCheck.zhengchang.getValue();
	int zx = HealthFileCheck.zhuxiao.getValue();
	int sw = HealthFileCheck.siwang.getValue();
	
	private String EntityName;//用于输入实体名
	
	public String getHql(String entityName){
		this.EntityName = entityName;//传入实体名称
		String hql="from "+entityName+" entity where 1=1 ";//拼好基础的hql
		System.out.println(hql);
		StringBuffer buffer =new StringBuffer(hql);
		//判断不同身份。只有平台管理员、集团负责人登陆时，sqid才不会等于0，走下面的方法
		if(sqid != 0){
			if(shenfen==1 || shenfen == 2 || shenfen==0){//身份==0，集团负责人登陆，选择医院
				buffer.append(" and entity.communityHospitalId = " + sqid);
			}else if (shenfen == 3) {//社区负责人
				buffer.append(" and entity.staffId = " + ysid + " and entity.communityHospitalId = " + sqid);
			}else if(shenfen==4){//身份==4，平台管理员登陆，选择集团
				buffer.append(" and entity.GId = " + sqid);
			}
		}
		//<1>如果输入框有值
		if(selectValue != null){
			if(selectValue.equals("") || selectValue == ""){
				//同样说明传入的值为空
			}else{
				//判断selectFlag的值,拼入
				if(selectFlag == 0){
					//请选择.不用拼
				}else if(selectFlag == 1){//拼入档案名称
					buffer.append(" and entity.name like '%"+selectValue+"%' ");
				}else if(selectFlag == 2){//拼入身份证号
					buffer.append(" and entity.idNum like '%"+selectValue+"%' ");
				}else if(selectFlag == 3){
					buffer.append(" and entity.fileNum like '%"+selectValue+"%'");
				}
			}
		}
		//<2>拼入年龄查询 同样,如果框框有值
		if(highAge != 0 ){
			buffer.append(" and entity.age <= "+highAge); //小于最高
		}
		if(lowAge != 0){
			buffer.append(" and entity.age >= "+lowAge); //大于最低
		}
		//<3>拼入出生日期
		if(highBrithday != null){// 小于出生日期高
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(highBrithday); //变成"yyyy-MM-dd"这种格式
			buffer.append(" and entity.birthDate < '"+dateStr+"' ");
		}
		if(lowBrithday != null){//大于出生日期低
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(lowBrithday); //变成"yyyy-MM-dd"这种格式
			buffer.append(" and entity.birthDate > ' "+ dateStr+"'");
		}
		//<4>拼入建档日期
		if(highFileDate != null){//小于最高日期
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(highFileDate); //变成"yyyy-MM-dd"这种格式
			buffer.append(" and entity.fileDate <=' "+dateStr+"'");
		}
		if(lowFileDate != null){//大于最低日期
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(lowFileDate); //变成"yyyy-MM-dd"这种格式
			buffer.append(" and entity.fileDate >=' "+dateStr+"'");
		}
		//<5>拼入责任医生姓名
		if(staffName != null){
			if(!staffName.equals("") && staffName!=""){ //非空的情况
				buffer.append(" and entity.staffName like '%"+staffName+"%'");
			}
		}
		//<6>拼入建档人
		if(filePeople !=null){
			if(!filePeople.equals("") && filePeople != ""){
				buffer.append(" and entity.filePerson like '%"+filePeople+"%'");
			}
		}
		//<7>拼入录入人
		if( enterPeople != null){
			if(!enterPeople.equals("") && enterPeople != ""){
				buffer.append(" and entity.enterPeople like '%"+enterPeople+"%'");
			}
		}
		//<8>拼入性别   0全部 1男 2女
		if(sex != -1){
			if(sex == 0){
				//没有限制
			}else if(sex == 1){
				buffer.append(" and entity.sex = "+ESex_State.MALE.getValue());
			}else if(sex == 2){
				buffer.append(" and entity.sex = "+ESex_State.FEMALE.getValue());
			}
		}
		//<9>拼入档案状态  0正常 1注销 2 死亡
		if(danganzhuangtai != -1){
			if(danganzhuangtai == 0){
				buffer.append(" and entity.healthFileType = " + zc);
			}
			if(danganzhuangtai == 1){
				buffer.append(" and entity.healthFileType = " + zx);
			}
			if(danganzhuangtai == 2){
				buffer.append(" and entity.healthFileType = " + sw);
			}
		}
		//<10>拼入地址:
		//<10.1>.省
		if(sheng != null && !sheng.equals("") && sheng != ""){
			buffer.append(" and entity.otherProvince like '%"+sheng+"%'");
		}
		//<10.2>市
		if(shi != null && !sheng.equals("") && sheng != ""){
			buffer.append(" and entity.otherCity like '%"+shi+"%'");
		}
		//<10.3>区
		if(qu!=null&&!qu.equals("") && qu != ""){
			buffer.append(" and entity.otherCounty like ' %"+qu+"%'" );
		}
		//<10.4>具体地址
		if(jutidizhi != null){
			if(jutidizhi != "" && !jutidizhi.equals("")){
				buffer.append(" and entity.otherCommunity like '%"+jutidizhi+"%'");
			}
		}
		//<11>拼入慢病 1高血压 2糖尿病 3脑卒中 4冠心病5恶性肿瘤 6重性精神病 7肺结核病
		if(renqun != null){
			StringBuffer bf = new StringBuffer("( 1 <> 1 ");
			for(int i = 0; i<renqun.length; i++){
				if(renqun[i] == 1){
					bf.append(" or entity.diseaseName = '高血压' ");
				}else if(renqun[i] == 2){
					bf.append(" or entity.diseaseName = '糖尿病' ");
				}else if(renqun[i] == 3){
					bf.append(" or entity.diseaseName = '心脑血管病' ");
				}else if(renqun[i] == 4){
					bf.append(" or entity.diseaseName = '冠心病' ");
				}else if(renqun[i] == 5){
					bf.append(" or entity.diseaseName = '肿瘤' ");
				}else if(renqun[i] == 6){
					bf.append(" or entity.diseaseName = '重性精神疾病' ");
				}else if(renqun[i] == 7){
					bf.append(" or entity.diseaseName = '慢性支气管病' ");
				}else if(renqun[i] == 8){
					bf.append(" or entity.diseaseName = '残疾障碍' ");
				}
			}
			bf.append(")");
			buffer.append(" and "+ bf);
		}
		return buffer.toString();
	}

	//默认构造函数
	public SearchBeanSU(){}
	
	
	





	public SearchBeanSU(int selectFlag, String selectValue, int highAge,
			int lowAge, Date highBrithday, Date lowBrithday, Date highFileDate,
			Date lowFileDate, String staffName, String filePeople,
			String enterPeople, int sex, int danganzhuangtai, String sheng,
			String shi, String qu, int[] renqun, String jutidizhi,
			String entityName) {
		super();
		this.selectFlag = selectFlag;
		this.selectValue = selectValue;
		this.highAge = highAge;
		this.lowAge = lowAge;
		this.highBrithday = highBrithday;
		this.lowBrithday = lowBrithday;
		this.highFileDate = highFileDate;
		this.lowFileDate = lowFileDate;
		this.staffName = staffName;
		this.filePeople = filePeople;
		this.enterPeople = enterPeople;
		this.sex = sex;
		this.danganzhuangtai = danganzhuangtai;
		this.sheng = sheng;
		this.shi = shi;
		this.qu = qu;
		this.renqun = renqun;
		this.jutidizhi = jutidizhi;
		EntityName = entityName;
	}

	public String getName() {
		return staffName;
	}
	public void setName(String staffName) {
		this.staffName = staffName;
	}
	public String getSheng() {
		return sheng;
	}

	public void setSheng(String sheng) {
		this.sheng = sheng;
	}

	public String getShi() {
		return shi;
	}

	public void setShi(String shi) {
		this.shi = shi;
	}

	public String getQu() {
		return qu;
	}

	public void setQu(String qu) {
		this.qu = qu;
	}

	public String getJutidizhi() {
		return jutidizhi;
	}
	public void setJutidizhi(String jutidizhi) {
		this.jutidizhi = jutidizhi;
	}
	public int getSelectFlag() {
		return selectFlag;
	}
	public void setSelectFlag(int selectFlag) {
		this.selectFlag = selectFlag;
	}
	
	public String getSelectValue() {
		return selectValue;
	}

	public void setSelectValue(String selectValue) {
		this.selectValue = selectValue;
	}

	public int getHighAge() {
		return highAge;
	}
	public void setHighAge(int highAge) {
		this.highAge = highAge;
	}
	public int getLowAge() {
		return lowAge;
	}
	public void setLowAge(int lowAge) {
		this.lowAge = lowAge;
	}
	public Date getHighBrithday() {
		return highBrithday;
	}
	public void setHighBrithday(Date highBrithday) {
		this.highBrithday = highBrithday;
	}
	public Date getLowBrithday() {
		return lowBrithday;
	}
	public void setLowBrithday(Date lowBrithday) {
		this.lowBrithday = lowBrithday;
	}
	public Date getHighFileDate() {
		return highFileDate;
	}
	public void setHighFileDate(Date highFileDate) {
		this.highFileDate = highFileDate;
	}
	public Date getLowFileDate() {
		return lowFileDate;
	}
	public void setLowFileDate(Date lowFileDate) {
		this.lowFileDate = lowFileDate;
	}
	
	public String getFilePeople() {
		return filePeople;
	}
	public void setFilePeople(String filePeople) {
		this.filePeople = filePeople;
	}
	
	public String getEnterPeople() {
		return enterPeople;
	}
	public void setEnterPeople(String enterPeople) {
		this.enterPeople = enterPeople;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getDanganzhuangtai() {
		return danganzhuangtai;
	}
	public void setDanganzhuangtai(int danganzhuangtai) {
		this.danganzhuangtai = danganzhuangtai;
	}
	
	public String getEntityName() {
		return EntityName;
	}
	public void setEntityName(String entityName) {
		EntityName = entityName;
	}
	public int[] getRenqun() {
		return renqun;
	}
	public void setRenqun(int[] renqun) {
		this.renqun = renqun;
	}

	public int getShenfen() {
		return shenfen;
	}

	public void setShenfen(int shenfen) {
		this.shenfen = shenfen;
	}

	public int getSqid() {
		return sqid;
	}

	public void setSqid(int sqid) {
		this.sqid = sqid;
	}

	public int getYsid() {
		return ysid;
	}

	public void setYsid(int ysid) {
		this.ysid = ysid;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	
	
	
	
	

}
