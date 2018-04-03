package com.jmjk.export;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jmjk.entity.view.VConsultationRecord;
import com.jmjk.enums.HealthFileCheck;

//会诊记录
public class consultationExport {
  
	
	public String fileNum;//档案编号
	public String Name;//姓名
	public String responsibleDoctor ; //责任医生
	public String conRecDate ; //会诊时间（时间类）
	public String consultationDoctorInstitution ;// 会诊医生及其所在医疗机构
	public String consultationReason;  //会诊原因
	public String consultationOpinion;//  会诊意见
	public String sex;//性别
	public String age;//年龄
	public String healthType;//档案类型
	
	public String[] getTitles(){
		String [] titles={
				"档案编号","姓名","责任医生","会诊时间","会诊医生及其所在医疗机构","会诊原因","会诊意见",
				"性别","年龄","档案类型",
		};
		
		return titles;
	}
	public consultationExport(){}
	public consultationExport(VConsultationRecord vc){
		
		this.fileNum=vc.getFileNum();
		this.Name=vc.getName();
		this.responsibleDoctor=vc.getResponsibleDoctor();
		if(vc.getConRecDate()!=null){
		Date date =vc.getConRecDate();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		this.conRecDate = formatter.format(date);
		}
		if(vc.getConsultationDoctorInstitution()!=null){
		this.consultationDoctorInstitution=vc.getConsultationDoctorInstitution();
		}
		if(vc.getConsultationReason()!=null){
		this.consultationReason=vc.getConsultationReason();
		}
		if(vc.getConsultationOpinion()!=null){
		this.consultationOpinion=vc.getConsultationOpinion();
		}
		if(vc.getSex()==true){
	    	this.sex="女";
	    }else{
	    	this.sex="男";
	    }
	    this.age=vc.getAge().toString();
	    if(vc.getHealthFileType().equals(String.valueOf(HealthFileCheck.zhengchang.getValue()))){
			this.healthType="正常";
		}else if(vc.getHealthFileType().equals(String.valueOf(HealthFileCheck.siwang.getValue()))){
			this.healthType="死亡";
		}else if(vc.getHealthFileType().equals(String.valueOf(HealthFileCheck.shanchu.getValue()))){
			this.healthType="注销";
		}
		

	}
	
	
	
	
	
	//////////////////set 和     get  方法////////////////////////////////////////////////////////////////////////////
	
	public String getFileNum() {
		return fileNum;
	}
	public void setFileNum(String fileNum) {
		this.fileNum = fileNum;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getResponsibleDoctor() {
		return responsibleDoctor;
	}
	public void setResponsibleDoctor(String responsibleDoctor) {
		this.responsibleDoctor = responsibleDoctor;
	}
	public String getConRecDate() {
		return conRecDate;
	}
	public void setConRecDate(String conRecDate) {
		this.conRecDate = conRecDate;
	}
	public String getConsultationDoctorInstitution() {
		return consultationDoctorInstitution;
	}
	public void setConsultationDoctorInstitution(
			String consultationDoctorInstitution) {
		this.consultationDoctorInstitution = consultationDoctorInstitution;
	}
	public String getConsultationReason() {
		return consultationReason;
	}
	public void setConsultationReason(String consultationReason) {
		this.consultationReason = consultationReason;
	}
	public String getConsultationOpinion() {
		return consultationOpinion;
	}
	public void setConsultationOpinion(String consultationOpinion) {
		this.consultationOpinion = consultationOpinion;
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
