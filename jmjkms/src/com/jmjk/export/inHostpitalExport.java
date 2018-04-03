package com.jmjk.export;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.jmjk.entity.view.VInHospitalHistory;


//住院记录
public class inHostpitalExport {

	
	public String fileNum;//档案编号
	public String name ;//姓名
    public String institution;//医疗机构名称
	public String medicalRecord;//病案号
	public String inDate ; //入院时间
	
	
	public String[] getTitles(){
		
		String[] titles={
				"档案编号","姓名","医疗机构名称","病案号","入院时间"
		};
		return titles;
	}
	
	
	
	
	
	public inHostpitalExport(){}
	
	public inHostpitalExport(VInHospitalHistory vil){
	this.fileNum=vil.getFileNum();
	this.name=vil.getName();
	this.institution=vil.getInstitution();
	this.medicalRecord=vil.getMedicalRecord();
	Date date =vil.getInDate();
	SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
	this.inDate=simpleDateFormat.format(date);
		
		
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
	
}
