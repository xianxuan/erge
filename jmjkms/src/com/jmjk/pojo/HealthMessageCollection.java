package com.jmjk.pojo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.jmjk.enums.ESex_State;

/**
 * 专门为健康管理 信息采集的多条件查询建的！！
 * @author LaiQingFa
 *
 */
public class HealthMessageCollection {
	private int selectFlag; //查询选项---居民条件 0空  1姓名  fileName 2身份证号  idNum  3档案编号 fileNum 
	private String selectValue; //查询值   
	private int highAge;  //年龄 高 age
	private int lowAge; //年龄 低 age
	private Date highFileDate; // 建档日期 高 fileFileDate
	private Date lowFileDate; //建档日期  低
	private String name;  //责任医生 name
	private String filePeople;  //建档人   filePerson
	private String  sheng;//地址省 otherProvince
	private String shi;//市 otherCity
	private String qu; //区otherCounty
	private int[] renqun; //diseaseName 在慢病总表中存的疾病名称
	private String jutidizhi;//详细地址   otherCommunity
	
	
	private String vChronic;//用于输入实体名
	
	public String getHql(String vChronic){
		this.vChronic = vChronic;//传入实体名称
		String hql="from "+vChronic+" entity where 1=1 ";//拼好基础的hql
		StringBuffer buffer =new StringBuffer(hql);
		//<1>如果输入框有值
		if(selectValue != null){
			if(selectValue.equals("") || selectValue == ""){
				//同样说明传入的值为空
			}else{
				//判断selectFlag的值,拼入
				if(selectFlag == 0){
					//请选择.不用拼
				}else if(selectFlag == 1){//拼入档案名称
					buffer.append(" and vChronic.fileName like '%"+selectValue+"%' ");
				}else if(selectFlag == 2){//拼入身份证号
					buffer.append(" and vChronic.idNum = '"+selectValue+"' ");
				}else if(selectFlag == 3){
					buffer.append(" and vChronic.fileNum = '"+selectValue+"'");
				}
			}
		}
		//<2>拼入年龄查询 同样,如果框框有值
		if(highAge != 0 ){
			buffer.append(" and vChronic.age < "+highAge); //小于最高
		}
		if(lowAge != 0){
			buffer.append(" and vChronic.age > "+lowAge); //大于最低
		}

		//<3>拼入建档日期
		if(highFileDate != null){//小于最高日期
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(highFileDate); //变成"yyyy-MM-dd"这种格式
			buffer.append(" and vChronic.fileFileDate < "+dateStr+"'");
		}
		if(lowFileDate != null){//大于最低日期
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String dateStr = sdf.format(lowFileDate); //变成"yyyy-MM-dd"这种格式
			buffer.append(" and vChronic.fileFileDate > "+dateStr+"'");
		}
		//<4>拼入责任医生姓名
		if(name != null){
			if(!name.equals("") && name!=""){ //非空的情况
				buffer.append(" and vChronic.name like '%"+name+"%'");
			}
		}
		//<5>拼入建档人
		if(filePeople !=null){
			if(!filePeople.equals("") && filePeople != ""){
				buffer.append(" and vChronic.filePerson like '%"+filePeople+"%'");
			}
		}
		//<6>拼入地址:
		//<6.1>.省
		if(sheng != null && !sheng.equals("") && sheng != ""){
			buffer.append(" and vChronic.otherProvince like '%"+sheng+"%'");
		}
		//<6.2>市
		if(shi != null && !sheng.equals("") && sheng != ""){
			buffer.append(" and vChronic.otherCity like '%"+shi+"%'");
		}
		//<6.3>区
		if(qu!=null&&!qu.equals("") && qu != ""){
			buffer.append(" and vChronic.otherCounty like %"+qu+"%");
		}
		//<6.4>具体地址
		if(jutidizhi != null){
			if(jutidizhi != "" && !jutidizhi.equals("")){
				buffer.append(" and vChronic.otherCommunity like '%"+jutidizhi+"%'");
			}
		}
		//<7>拼入慢病 1高血压 2糖尿病 3脑卒中 4冠心病5恶性肿瘤 6重性精神病 7肺结核病
		if(renqun != null){
			StringBuffer bf = new StringBuffer("( 1 <> 1 ");
			for(int i = 0; i<renqun.length; i++){
				if(renqun[i] == 1){
					bf.append(" or vChronic.diseaseName = '高血压' ");
				}else if(renqun[i] == 2){
					bf.append(" or vChronic.diseaseName = '糖尿病' ");
				}else if(renqun[i] == 3){
					bf.append(" or vChronic.diseaseName = '脑卒中' ");
				}else if(renqun[i] == 4){
					bf.append(" or vChronic.diseaseName = '冠心病' ");
				}else if(renqun[i] == 5){
					bf.append(" or vChronic.diseaseName = '恶性肿瘤' ");
				}else if(renqun[i] == 6){
					bf.append(" or vChronic.diseaseName = '重性精神 病' ");
				}else if(renqun[i] == 7){
					bf.append(" or vChronic.diseaseName = '肺结核病' ");
				}
			}
			bf.append(")");
			buffer.append(" and "+ bf);
		}
		return buffer.toString();
	}

	//默认构造函数
	public HealthMessageCollection(){}
	
	
	





	public HealthMessageCollection(int selectFlag, String selectValue, int highAge,
			int lowAge, Date highBrithday, Date lowBrithday, Date highFileDate,
			Date lowFileDate, String name, String filePeople,
			String enterPeople, int sex, int danganzhuangtai, String sheng,
			String shi, String qu, int[] renqun, String jutidizhi,
			String vChronic) {
		super();
		this.selectFlag = selectFlag;
		this.selectValue = selectValue;
		this.highAge = highAge;
		this.lowAge = lowAge;
		this.highFileDate = highFileDate;
		this.lowFileDate = lowFileDate;
		this.name = name;
		this.filePeople = filePeople;
		this.sheng = sheng;
		this.shi = shi;
		this.qu = qu;
		this.renqun = renqun;
		this.jutidizhi = jutidizhi;
		vChronic = vChronic;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

	public String getvChronic() {
		return vChronic;
	}

	public void setvChronic(String vChronic) {
		this.vChronic = vChronic;
	}

	public int[] getRenqun() {
		return renqun;
	}
	public void setRenqun(int[] renqun) {
		this.renqun = renqun;
	}
	
	
	
	
	

}
