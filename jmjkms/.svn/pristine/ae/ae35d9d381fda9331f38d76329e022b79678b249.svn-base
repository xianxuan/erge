package com.jmjk.export;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.jmjk.entity.view.VChronic;
import com.jmjk.enums.HealthFileCheck;

public class ChronicExport {

	public String fileNum;//档案编号
	public String fileName;//老人名字
	public String sex;//性别
	public String currentResidentCommittee;//居委会
	public String diseaseName;//慢性病名称
	public String chronicDiseaseFileName;//建档人姓名
	public String chronicDiseaseFileDate;//建档日期
	public String healthyType;//档案状态
	public String[] getTitles(){
		String[] titles={//8
				"档案编号","老人名字","性别","居委会","慢性病名称","建档人姓名","建档日期","档案状态"
		};
		return titles;
	}
	public ChronicExport(){}
	public ChronicExport(VChronic vc){
		super();
		this.fileNum=vc.getFileNum();
		this.fileName=vc.getFileName();
		if(vc.getSex()!=null){
			if(vc.getSex()==true){
				this.sex="女";
			}else{
				this.sex="男";
			}
		}
		if(vc.getHealthFileType().intern()==String.valueOf(HealthFileCheck.zhengchang.getValue()).intern()){
			this.healthyType="正常";
		}
		if(vc.getHealthFileType().equals(String.valueOf(HealthFileCheck.siwang.getValue()))){
			this.healthyType="死亡";
		}
		if(vc.getHealthFileType().equals(String.valueOf(HealthFileCheck.shanchu.getValue()))){
			this.healthyType="删除";
		}
		this.currentResidentCommittee=vc.getCurrentResidentCommittee();
		this.diseaseName=vc.getDiseaseName();
		this.chronicDiseaseFileName=vc.getChronicDiseaseFileName();
		if(vc.getChronicDiseaseFileDate()!=null){
		Date date = vc.getChronicDiseaseFileDate();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		this.chronicDiseaseFileDate = dateString;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public String getFileNum() {
		return fileNum;
	}
	public void setFileNum(String fileNum) {
		this.fileNum = fileNum;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCurrentResidentCommittee() {
		return currentResidentCommittee;
	}
	public void setCurrentResidentCommittee(String currentResidentCommittee) {
		this.currentResidentCommittee = currentResidentCommittee;
	}
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	public String getChronicDiseaseFileName() {
		return chronicDiseaseFileName;
	}
	public void setChronicDiseaseFileName(String chronicDiseaseFileName) {
		this.chronicDiseaseFileName = chronicDiseaseFileName;
	}
	public String getChronicDiseaseFileDate() {
		return chronicDiseaseFileDate;
	}
	public void setChronicDiseaseFileDate(String chronicDiseaseFileDate) {
		this.chronicDiseaseFileDate = chronicDiseaseFileDate;
	}
}
