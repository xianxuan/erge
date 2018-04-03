package com.jmjk.export;



import java.text.SimpleDateFormat;
import java.util.Date;

import com.jmjk.entity.view.VFollowRecord;
import com.jmjk.enums.HealthFileCheck;

//随诊记录
public class followExport {

	public String fileNum;//档案编号
	public String name;//姓名
	public String followDoctor;//随诊医生
	public String time ;//随诊时间  (时间类)
	public String sex;//性别
	public String age;//年龄
	public String healthType;//档案类型
	

	public String[] getTitles(){
		
		String[] titles={
				"档案编号","姓名","随诊医生","随诊时间","性别","年龄","档案类型",
		};
		return titles;
	}
	
	public followExport(){}
	
	public followExport(VFollowRecord vf){
		
		
		this.fileNum=vf.getFileNum();
		this.name=vf.getName();
		this.followDoctor=vf.getFollowDoctor();
		if(vf.getTime()!=null){
		Date date=vf.getTime();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		this.time=simpleDateFormat.format(date);
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
	
	
	
	
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////
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
	public String getFollowDoctor() {
		return followDoctor;
	}
	public void setFollowDoctor(String followDoctor) {
		this.followDoctor = followDoctor;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
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
