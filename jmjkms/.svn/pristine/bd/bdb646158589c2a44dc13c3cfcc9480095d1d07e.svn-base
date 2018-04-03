package com.jmjk.export;

import java.text.SimpleDateFormat;
import java.util.Date;






import com.jmjk.entity.view.VFamilyBedHistory;
import com.jmjk.enums.HealthFileCheck;

//家庭病床记录
public class familyExport {

	
	public String fileNum;//档案编号
	public String name;//姓名
	public String institution;//医疗机构名称 
	public String medicalNum;//病案号
	public String buildBedDate;//建床日期  data
	public String sex;//性别
	public String age;//年龄
	public String healthType;//档案类型
	
	
	public String[] getTitles(){
		String[] titles={
				"档案编号","姓名","医疗机构名称 ","病案号","建床日期 ","性别","年龄","档案类型",
		};
		return  titles;
	}
	
	public familyExport(){}
	
	public familyExport(VFamilyBedHistory vf){
		
		super();
		this.fileNum=vf.getFileNum();
		this.name=vf.getName();
		this.institution=vf.getInstitution();
		this.medicalNum=vf.getMedicalNum();
		if(vf.getBuildBedDate()!=null){
		Date data=vf.getBuildBedDate();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		this.buildBedDate=formatter.format(data);
		}
		if(vf.getSex()==true){
	    	this.sex="女";
	    }else{
	    	this.sex="男";
	    }
	    this.age=vf.getAge().toString();
	    if(vf.getHealthFileType().equals(String.valueOf(HealthFileCheck.zhengchang.getValue()))){
			this.healthType="正常";
		}else if(vf.getHealthFileType().equals(String.valueOf(HealthFileCheck.siwang.getValue()))){
			this.healthType="死亡";
		}else if(vf.getHealthFileType().equals(String.valueOf(HealthFileCheck.shanchu.getValue()))){
			this.healthType="注销";
		}
	}
	////////////////////////////////////////////////////////////////////////////////////////////////
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
	public String getMedicalNum() {
		return medicalNum;
	}
	public void setMedicalNum(String medicalNum) {
		this.medicalNum = medicalNum;
	}
	public String getBuildBedDate() {
		return buildBedDate;
	}
	public void setBuildBedDate(String buildBedDate) {
		this.buildBedDate = buildBedDate;
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
