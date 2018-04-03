package com.jmjk.export;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.Data;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jmjk.entity.view.VDualReferralRecord;
import com.jmjk.enums.HealthFileCheck;

//双向转诊记录
public class dualReferralExport {

	
	public String fileNum;//档案编号
	public String name;//姓名
	public String outTime;//转出日期
	public String outUnit;//转出单位
	public String goUnit;//转至单位
	public String sex;//性别
	public String age;//年龄
	public String healthType;//档案类型
	
	public String[] getTitles(){
		
		String[] titles={
				"档案编号","姓名","转出日期","转出单位","转至单位","性别","年龄","档案类型",
		};
		return titles;
	}
	
	public dualReferralExport(){}
	
	public dualReferralExport(VDualReferralRecord  vd){
		
		this.fileNum=vd.getFileNum();
		this.name=vd.getName();
		if(vd.getOutTime()!=null){
		Date data=vd.getOutTime();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		this.outTime = formatter.format(data);
		}
		this.outUnit=vd.getOutUnit();
		this.goUnit=vd.getGoUnit();
		if(vd.getSex()==true){
	    	this.sex="女";
	    }else{
	    	this.sex="男";
	    }
	    this.age=vd.getAge().toString();
	    if(vd.getHealthFileType().equals(String.valueOf(HealthFileCheck.zhengchang.getValue()))){
			this.healthType="正常";
		}else if(vd.getHealthFileType().equals(String.valueOf(HealthFileCheck.siwang.getValue()))){
			this.healthType="死亡";
		}else if(vd.getHealthFileType().equals(String.valueOf(HealthFileCheck.shanchu.getValue()))){
			this.healthType="注销";
		}
	}
	
	
	
	
	
	
	
	
	
	
	/////////////////////////////////////////////////////////////////////////
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
	public String getOutTime() {
		return outTime;
	}
	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}
	public String getOutUnit() {
		return outUnit;
	}
	public void setOutUnit(String outUnit) {
		this.outUnit = outUnit;
	}
	public String getGoUnit() {
		return goUnit;
	}
	public void setGoUnit(String goUnit) {
		this.goUnit = goUnit;
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
