package com.jmjk.export;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jmjk.entity.view.VChronic;
import com.jmjk.enums.HealthFileCheck;

public class highBloodExport {

	
	
	
	public String fileNum;//健康档案编号 1
	public String  sex;//性别 3/
	public String fileName;//姓名 2
	public String IPhone;//联系方式 4  
	public String currentCommunity;//现住址 5
	//////////////////////////////////
	public String highBloodTypr; //高血压类 型 6
	public String managementClass; //高血压管理分级 7
	public String initialDiagnosisTime;  //初次确诊时间 8 ==
	public String mainSymptoms;  //目前主要症状 9
	public String hypertensionComplication;  //高血压并发症 10
	public String howLongTakeBlood;  //多长时间测一次血压 11
	public String takeMedication;  //是否服用降压药 12 
	public String notTakeReason;  //不服或者不规律服药原因13 
	public String drugCost;  //每日高血压药物费用 14  ==
	public String nonDrugTreatment;  //非药物方法治疗高血压 15
	public String familyWhitHighBlood;  //家族中高血压患者 16
	public String filingDate;  //建档日期 17  ==
	public String bookrunner;  //建档人 18
	public String fileType;//档案状态
	

	public String [] getTitles(){//18个
	String [] titles ={
			"健康档案编号","性别","姓名","联系方式","现住址","高血压类型","高血压管理分级"
			,"初次确诊时间","目前主要症状","高血压并发症","多长时间测一次血压","是否服用降压药","不服或者不规律服药原因"
			,"每日高血压药物费用","非药物方法治疗高血压","家族中高血压患者","建档日期","建档人","档案状态"
	};
	return  titles;
	}
	
	
	public  highBloodExport(){}
	public highBloodExport(VChronic vc){
		
		/*this.healthNum=*/		
			this.fileNum=vc.getFileNum();
			if(vc.getSex() != null){
				if(vc.getSex() == true){
					this.sex = "女";
				}else{
					this.sex = "男";
				}
			}			
			this.fileName=vc.getFileName();
			this.IPhone=vc.getIPhone();
			this.currentCommunity=vc.getCurrentCommunity();
			this.highBloodTypr=vc.getHighBloodTypr(); 
			this.managementClass=vc.getManagementClass();
			if(vc.getHighBloodInitialDiagnosisTime()!=null){
				this.initialDiagnosisTime=vc.getHighBloodInitialDiagnosisTime().toString();
			}
				this.mainSymptoms=vc.getMainSymptoms();
				this.hypertensionComplication=vc.getHypertensionComplication();
				this.howLongTakeBlood=vc.getHowLongTakeBlood();
				this.takeMedication=vc.getTakeMedication();
				this.notTakeReason=vc.getNotTakeReason();
				if(vc.getDrugCost()!=null){
					this.drugCost=vc.getDrugCost().toString();
				}
				this.nonDrugTreatment=vc.getNonDrugTreatment();
				this.familyWhitHighBlood=vc.getFamilyWhitHighBlood();
				
				Date date=vc.getChronicDiseaseFileDate();//jiandang
				SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
				this.filingDate=simpleDateFormat.format(date);
				
				this.bookrunner=vc.getChronicDiseaseFileName();
				 if(vc.getHealthFileType().equals(String.valueOf(HealthFileCheck.zhengchang.getValue()))){
						this.fileType="正常";
					}else if(vc.getHealthFileType().equals(String.valueOf(HealthFileCheck.siwang.getValue()))){
						this.fileType="死亡";
					}else if(vc.getHealthFileType().equals(String.valueOf(HealthFileCheck.shanchu.getValue()))){
						this.fileType="注销";
					}
					
		
	}
	
	
	
	
	
	
	
	
	///////////////////////////////////////////////////////////////////////////
	public String getFileNum() {
		return fileNum;
	}
	public void setFileNum(String fileNum) {
		this.fileNum = fileNum;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getFileName() {
		return fileName;
	}
    public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getIPhone() {
		return IPhone;
	}
	public void setIPhone(String iPhone) {
		IPhone = iPhone;
	}
	public String getCurrentCommunity() {
		return currentCommunity;
	}
	public void setCurrentCommunity(String currentCommunity) {
		this.currentCommunity = currentCommunity;
	}
	public String getHighBloodTypr() {
		return highBloodTypr;
	}
	public void setHighBloodTypr(String highBloodTypr) {
		this.highBloodTypr = highBloodTypr;
	}
	public String getManagementClass() {
		return managementClass;
	}
	public void setManagementClass(String managementClass) {
		this.managementClass = managementClass;
	}
	/*public Timestamp getInitialDiagnosisTime() {
		return initialDiagnosisTime;
	}
	public void setInitialDiagnosisTime(Timestamp initialDiagnosisTime) {
		this.initialDiagnosisTime = initialDiagnosisTime;
	}*/
	public String getMainSymptoms() {
		return mainSymptoms;
	}
	public void setMainSymptoms(String mainSymptoms) {
		this.mainSymptoms = mainSymptoms;
	}
	public String getHypertensionComplication() {
		return hypertensionComplication;
	}
	public void setHypertensionComplication(String hypertensionComplication) {
		this.hypertensionComplication = hypertensionComplication;
	}
	public String getHowLongTakeBlood() {
		return howLongTakeBlood;
	}
	public void setHowLongTakeBlood(String howLongTakeBlood) {
		this.howLongTakeBlood = howLongTakeBlood;
	}
	public String getTakeMedication() {
		return takeMedication;
	}
	public void setTakeMedication(String takeMedication) {
		this.takeMedication = takeMedication;
	}
	public String getNotTakeReason() {
		return notTakeReason;
	}
	public void setNotTakeReason(String notTakeReason) {
		this.notTakeReason = notTakeReason;
	}
	public String getDrugCost() {
		return drugCost;
	}
	public void setDrugCost(String drugCost) {
		this.drugCost = drugCost;
	}
	public String getNonDrugTreatment() {
		return nonDrugTreatment;
	}
	public void setNonDrugTreatment(String nonDrugTreatment) {
		this.nonDrugTreatment = nonDrugTreatment;
	}
	public String getFamilyWhitHighBlood() {
		return familyWhitHighBlood;
	}
	public void setFamilyWhitHighBlood(String familyWhitHighBlood) {
		this.familyWhitHighBlood = familyWhitHighBlood;
	}
	public String getFilingDate() {
		return filingDate;
	}
	public void setFilingDate(String filingDate) {
		this.filingDate = filingDate;
	}
	public String getBookrunner() {
		return bookrunner;
	}
	public void setBookrunner(String bookrunner) {
		this.bookrunner = bookrunner;
	}
	public String getInitialDiagnosisTime() {
		return initialDiagnosisTime;
	}
	public void setInitialDiagnosisTime(String initialDiagnosisTime) {
		this.initialDiagnosisTime = initialDiagnosisTime;
	}


	public String getFileType() {
		return fileType;
	}


	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
}
