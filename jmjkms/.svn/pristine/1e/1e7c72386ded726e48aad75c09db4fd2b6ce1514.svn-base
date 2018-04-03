package com.jmjk.export;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.jmjk.entity.view.VMedicalRecord;
import com.jmjk.enums.HealthFileCheck;

//长期用药记录 daochu
public class medialExport {

	
	public String  fileNum;//档案编号
	public String  name;// 姓名
	public String drugName;//药物名称
	public String beginDate;//开始用药时间
	public String sex;//性别
	public String age;//年龄
	public String healthType;//档案类型
	
	public String[] getTitles(){
		
		String[] titles={
				"档案编号","姓名","药物名称","开始用药时间","性别","年龄","档案类型",
		};
		return titles;
	}
	
	
	public medialExport(){}
	
	public medialExport(VMedicalRecord vm){
		
		
		this.fileNum=vm.getFileNum();
		this.name=vm.getName();
		this.drugName=vm.getDrugName();
		if(vm.getBeginDate()!=null){
		Date date=vm.getBeginDate();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		this.beginDate=simpleDateFormat.format(date);
		}
		if(vm.getSex()==true){
	    	this.sex="女";
	    }else{
	    	this.sex="男";
	    }
	    this.age=vm.getAge().toString();
	    if(vm.getHealthFileType().equals(String.valueOf(HealthFileCheck.zhengchang.getValue()))){
			this.healthType="正常";
		}else if(vm.getHealthFileType().equals(String.valueOf(HealthFileCheck.siwang.getValue()))){
			this.healthType="死亡";
		}else if(vm.getHealthFileType().equals(String.valueOf(HealthFileCheck.shanchu.getValue()))){
			this.healthType="注销";
		}
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////
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


	public String getDrugName() {
		return drugName;
	}


	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}


	public String getBeginDate() {
		return beginDate;
	}


	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}


	public String getSex() {
		return sex;
	}


	public void setSex(String sex) {
		this.sex = sex;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getHealthType() {
		return healthType;
	}


	public void setHealthType(String healthType) {
		this.healthType = healthType;
	}


	
}
