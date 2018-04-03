package com.jmjk.export;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;

import com.jmjk.entity.view.VExam;
import com.jmjk.enums.HealthFileCheck;
@Controller("PhysicalExport")
public class PhysicalExport {
	public String fileNum;//档案编号
	public String fileName;//老人名字
	public String sex;//性别
	public String operator;//录入员
	public String responsibleDoctor;//体检医生
	public String filePerson;//建档人姓名
	/*public String fileDate;//建档日期
	public String healthyType;//档案状态 */
	
	public String[] getTitles(){
		String[] titles={//8
				"档案编号","老人名字","性别","录入员","体检医生","建档人姓名"
		};
		return titles;
	}
	public PhysicalExport(){}
	public PhysicalExport(VExam ve){
		super();
		this.fileNum=ve.getFileNum();
		this.fileName=ve.getFileName();
		if(ve.getSex()!=null){
			if(ve.getSex()==true){
				this.sex="女";
			}else{
				this.sex="男";
			}
		}
		this.operator=ve.getOperator();
		this.responsibleDoctor=ve.getResponsibleDoctor();
		this.filePerson=ve.getFilePerson();
		/*Date date = ve.getFileDate();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		this.fileDate=dateString;*/
		//.intern()==String.valueOf(HealthFileCheck.zhengchang.getValue()).intern()
		//.equals(String.valueOf(HealthFileCheck.zhengchang.getValue()))
		/*if(ve.getHealthFileType().intern()==String.valueOf(HealthFileCheck.zhengchang.getValue()).intern()){
			this.healthyType="正常";
		}
		if(ve.getHealthFileType().equals(String.valueOf(HealthFileCheck.siwang.getValue()))){
			this.healthyType="死亡";
		}
		if(ve.getHealthFileType().equals(String.valueOf(HealthFileCheck.shanchu.getValue()))){
			this.healthyType="删除";
		}
		*/
	}
	
	
	
	
	
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
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getResponsibleDoctor() {
		return responsibleDoctor;
	}
	public void setResponsibleDoctor(String responsibleDoctor) {
		this.responsibleDoctor = responsibleDoctor;
	}
	public String getFilePerson() {
		return filePerson;
	}
	public void setFilePerson(String filePerson) {
		this.filePerson = filePerson;
	}
	
	
	
	
}
