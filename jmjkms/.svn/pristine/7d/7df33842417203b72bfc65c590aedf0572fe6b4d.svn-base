package com.jmjk.export;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.jmjk.entity.view.VIncompleteRecord;
import com.jmjk.entity.view.VIncompleteRecord2;
import com.jmjk.enums.HealthFileCheck;


//接诊、记录
public class incompleteExport2 {

	
	public String  fileNum;//档案编号
	public String  name;// 姓名
	public String  incompleteDoctor;//接诊医生
	public String incompleteRecordDate;//接诊日期 (时间类)
	public String sex;//性别
	public String age;//年龄
	public String healthType;//档案类型
	
	
public String[] getTitles(){
		
		String[] titles={
				"档案编号","姓名","接诊医生","接诊日期","性别","年龄","档案类型",
		};
		return titles;
	}

public incompleteExport2(){}
public incompleteExport2(VIncompleteRecord2 vil ){
	
	this.fileNum=vil.getFileNum();
	this.name=vil.getName();
	this.incompleteDoctor=vil.getIncompleteDoctor();
	if(vil.getIncompleteRecordDate()!=null){
	Date date=vil.getIncompleteRecordDate();
	SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");//"yyyy-MM-dd"
	this.incompleteRecordDate=simpleDateFormat.format(date);
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

///////////////////////////////////////////////////////

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


public String getIncompleteDoctor() {
	return incompleteDoctor;
}


public void setIncompleteDoctor(String incompleteDoctor) {
	this.incompleteDoctor = incompleteDoctor;
}


public String getIncompleteRecordDate() {
	return incompleteRecordDate;
}


public void setIncompleteRecordDate(String incompleteRecordDate) {
	this.incompleteRecordDate = incompleteRecordDate;
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
