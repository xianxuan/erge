package com.jmjk.export;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.jmjk.entity.view.VChronic;
import com.jmjk.enums.HealthFileCheck;

public class DiabeteExport {
		public String fileNum;//健康档案编号
		public String filename;//姓名
		public String sex;//性别
		public String IPhone;//联系方式
		public String currentCommunity;//现住址
		public String name;//责任医生
		////////////
		public String typOfDia; //糖尿病类型
		public String coOfDia;  //糖尿病病程
		public String initialDiagnosisTime;  //初次诊断时间
		public String costPerMonth;  //每月治疗费用
		public String mainSyptm;  //目前主要症状
		public String diaCompl;   //糖尿病并发症
		public String diaHistory;   //糖尿病既往史
		public String faMem;  //家庭中糖尿病患者
		public String filingDate;  //建档日期
		public String bookrunner;  //建档人
		public String fileType;//档案状态
		
		
		
		public String[] getTitles(){
			String [] titles = {
				"健康档案编号","姓名","性别","联系方式","现住址","责任医生","糖尿病类型","糖尿病病程",	
				"初次诊断时间","每月治疗费用","目前主要症状","糖尿病并发症","糖尿病既往史","家庭中糖尿病患者","建档日期","建档人",
				"档案状态"
			};
			return titles;
		}
		public DiabeteExport() {}
		public DiabeteExport(VChronic vChronichronic) {
			super();
			this.fileNum = vChronichronic.getFileNum();
			this.name = vChronichronic.getName();
			this.filename=vChronichronic.getFileName();
			this.IPhone = vChronichronic.getIPhone();
			if(vChronichronic.getSex() != null){
				if(vChronichronic.getSex() == true){
					this.sex = "女";
				}else{
					this.sex = "男";
				}
			}
			this.currentCommunity=vChronichronic.getCurrentCommunity();
			this.typOfDia=vChronichronic.getTypOfDia();
			this.coOfDia=vChronichronic.getCoOfDia();
			if(vChronichronic.getDiabeteInitialDiagnosisTime()!=null){
				this.initialDiagnosisTime=vChronichronic.getDiabeteInitialDiagnosisTime().toString();
			}
			if(vChronichronic.getCostPerMonth()!=null){
				this.costPerMonth=vChronichronic.getCostPerMonth().toString();
			}
			this.coOfDia=vChronichronic.getCoOfDia();
			this.mainSyptm=vChronichronic.getMainSyptm();
			this.diaCompl=vChronichronic.getDiaCompl();
			this.diaHistory=vChronichronic.getDiaHistory();
			this.faMem=vChronichronic.getFaMem();
			
			Date date=vChronichronic. getChronicDiseaseFileDate();//jiandang
			SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
			this.filingDate=simpleDateFormat.format(date);
			
			this.bookrunner=vChronichronic.getChronicDiseaseFileName();
				if(vChronichronic.getHealthFileType().equals(String.valueOf(HealthFileCheck.zhengchang.getValue()))){
					this.fileType="正常";
				}else if(vChronichronic.getHealthFileType().equals(String.valueOf(HealthFileCheck.siwang.getValue()))){
					this.fileType="死亡";
				}else if(vChronichronic.getHealthFileType().equals(String.valueOf(HealthFileCheck.shanchu.getValue()))){
					this.fileType="注销";
				}
			 
		}
		 
		 
		 
		 
		 
		 
		 //////////////////////////////////////////////////////////////////////////////////////
		public String getFileNum() {
			return fileNum;
		}
		public void setFileNum(String fileNum) {
			this.fileNum = fileNum;
		}
		public String getFilename() {
			return filename;
		}
		public void setFilename(String filename) {
			this.filename = filename;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
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
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getTypOfDia() {
			return typOfDia;
		}
		public void setTypOfDia(String typOfDia) {
			this.typOfDia = typOfDia;
		}
		public String getCoOfDia() {
			return coOfDia;
		}
		public void setCoOfDia(String coOfDia) {
			this.coOfDia = coOfDia;
		}
		public String getInitialDiagnosisTime() {
			return initialDiagnosisTime;
		}
		public void setInitialDiagnosisTime(String initialDiagnosisTime) {
			this.initialDiagnosisTime = initialDiagnosisTime;
		}
		public String getCostPerMonth() {
			return costPerMonth;
		}
		public void setCostPerMonth(String costPerMonth) {
			this.costPerMonth = costPerMonth;
		}
		public String getMainSyptm() {
			return mainSyptm;
		}
		public void setMainSyptm(String mainSyptm) {
			this.mainSyptm = mainSyptm;
		}
		public String getDiaCompl() {
			return diaCompl;
		}
		public void setDiaCompl(String diaCompl) {
			this.diaCompl = diaCompl;
		}
		public String getDiaHistory() {
			return diaHistory;
		}
		public void setDiaHistory(String diaHistory) {
			this.diaHistory = diaHistory;
		}
		public String getFaMem() {
			return faMem;
		}
		public void setFaMem(String faMem) {
			this.faMem = faMem;
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
		public String getFileType() {
			return fileType;
		}
		public void setFileType(String fileType) {
			this.fileType = fileType;
		}
		 
}
