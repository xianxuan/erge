package com.jmjk.export;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.jmjk.entity.view.VInHospitalHistory;
import com.jmjk.enums.HealthFileCheck;


//住院记录
public class inHospitalExport {

	
	public String fileNum;//档案编号
	public String name ;//姓名
    public String institution;//医疗机构名称
	public String medicalRecord;//病案号
	public String inDate ; //入院时间
	public String sex;//性别
	public String age;//年龄
	public String healthType;//档案类型
	
	public String[] getTitles(){
		
		String[] titles={
				"档案编号","姓名","医疗机构名称","病案号","入院时间","性别","年龄","档案类型",
		};
		return titles;
	}
	
	
	
	
	
	public inHospitalExport(){}
	
	public inHospitalExport(VInHospitalHistory vil){
	this.fileNum=vil.getFileNum();
	this.name=vil.getName();
	this.institution=vil.getInstitution();
	this.medicalRecord=vil.getMedicalRecord();
	if(vil.getInDate()!=null){
	Date date =vil.getInDate();
	SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
	this.inDate=simpleDateFormat.format(date);
	}
    if(vil.getSex()==true){
    	this.sex="女";
    }else{
    	this.sex="男";
    }
    this.age=vil.getAge().toString();
    if(vil.getHealthFileType().equals(String.valueOf(HealthFileCheck.zhengchang.getValue()))){
		this.healthType="正常";
	}else if(vil.getHealthFileType().equals(String.valueOf(HealthFileCheck.siwang.getValue()))){
		this.healthType="死亡";
	}else if(vil.getHealthFileType().equals(String.valueOf(HealthFileCheck.shanchu.getValue()))){
		this.healthType="注销";
	}
		
		
	}
	//////////////////////////////////////////////////////////////////////////////
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
	public String getInstitution() {
		return institution;
	}
	public void setInstitution(String institution) {
		this.institution = institution;
	}
	public String getMedicalRecord() {
		return medicalRecord;
	}
	public void setMedicalRecord(String medicalRecord) {
		this.medicalRecord = medicalRecord;
	}
	public String getInDate() {
		return inDate;
	}
	public void setInDate(String inDate) {
		this.inDate = inDate;
	}
	public String getHealthType() {
		return healthType;
	}





	public void setHealthType(String healthType) {
		this.healthType = healthType;
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
	
}
