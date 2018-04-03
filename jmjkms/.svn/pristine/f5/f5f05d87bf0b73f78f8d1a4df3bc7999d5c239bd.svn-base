package com.jmjk.export;

import java.text.SimpleDateFormat;
import java.util.Date;

import oracle.net.resolver.TNSNamesNamingAdapter;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jmjk.entity.THealthFile;
import com.jmjk.enums.HealthFileCheck;


//健康档案
public class healthFileExport {

	public String fileNum;//档案编号
	public String idNum;//身份证号
	public String name;//姓名
	public String sex ;//性别
	public String birthDate;//出生日期
	public String IPhone;//本人电话
	public String hospital;//所在社区医院
	public String fileType;//档案状态
	
	
	public String[] getTiles(){
		
		String[] titles={
			"档案编号","身份证号","姓名","性别","出生日期","本人电话","所在社区医院",	"档案状态"
		};
		return titles;
	}
	
	public healthFileExport(){}
	public healthFileExport(THealthFile th){
		
		this.fileNum=th.getFileNum();
		this.idNum=th.getIdNum();
		this.name=th.getName();
		if(th.getSex()==true){
			this.sex="女";
		}else{
			this.sex="男";
		}
		if(th.getBirthDate()!=null){
		Date data=th.getBirthDate();
		SimpleDateFormat simple=new SimpleDateFormat("yyyy-MM-dd");
		this.birthDate=simple.format(data);
		}
		this.IPhone=th.getIPhone();
		this.hospital=th.getHospital();
		
		if(th.getHealthFileType().equals(String.valueOf(HealthFileCheck.zhengchang.getValue()))){
			this.fileType="正常";
		}else if(th.getHealthFileType().equals(String.valueOf(HealthFileCheck.siwang.getValue()))){
			this.fileType="死亡";
		}else if(th.getHealthFileType().equals(String.valueOf(HealthFileCheck.shanchu.getValue()))){
			this.fileType="注销";
		}
	}
	
	
	
	
	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFileNum() {
		return fileNum;
	}
	public void setFileNum(String fileNum) {
		this.fileNum = fileNum;
	}
	public String getIdNum() {
		return idNum;
	}
	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getIPhone() {
		return IPhone;
	}
	public void setIPhone(String iPhone) {
		IPhone = iPhone;
	}
	public String getHospital() {
		return hospital;
	}
	public void setHospital(String hospital) {
		this.hospital = hospital;
	}
	
	
	
	
	
	
	
	
	
	///////////////////////////////////////////////////////////////////////////////
	
	
}
