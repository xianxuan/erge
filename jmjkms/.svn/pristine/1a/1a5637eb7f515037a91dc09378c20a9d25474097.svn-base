package com.jmjk.export;

import com.jmjk.entity.TRecoveryPlan;
import com.jmjk.enums.RecoveryPlanStatus;

public class recoveryPlanExport {
	//康复计划名称
	public String planName;
	//姓名
	public String name;
	//开始日期
	public String beginTime;
	//结束日期
	public String overTime;
	//状态
	public String status;
	 public String[] getTitles(){
	 		String [] titles = {//5g
	 			"康复计划名称","姓名","开始日期","结束日期","状态"
	 		};
	 		return titles;
	 	}


public recoveryPlanExport (){}
public recoveryPlanExport(TRecoveryPlan trecoveryPlan) {
	 super();
	 if(trecoveryPlan.getPlanName() == null){
		 this.planName= "";
	 }else{
		 this.planName=trecoveryPlan.getPlanName();
	 }
	 if(trecoveryPlan.getTStaff().getName() == null ){
		 this.name = "";
	 }else{
	     this.name=trecoveryPlan.getTStaff().getName();}
	 if(trecoveryPlan.getBeginTime() == null){
		 this.beginTime = "";
	 }else{
		 this.beginTime=trecoveryPlan.getBeginTime().toString();
	 }
	 if(trecoveryPlan.getOverTime() == null){
		 this.overTime = "";
	 }else{
		 this.overTime=trecoveryPlan.getOverTime().toString();
	 }
	 if(trecoveryPlan.getStatus() == null){
		 this.status="";
	 }else{
		 if(trecoveryPlan.getStatus().equals(RecoveryPlanStatus.NO_STARTED.getValue()))
   		 {
   			this.status="未开始";
   		 }
   		 if(trecoveryPlan.getStatus().equals(RecoveryPlanStatus.STARRED.getValue()))
   		 {
   			 this.status="已完成";
   		 }
   		 if(trecoveryPlan.getStatus().equals(RecoveryPlanStatus.STARTING.getValue()))
   		 {
   			 this.status="正在执行";
   		 }
	 }
}
public String getPlanName() {
	return planName;
}

public void setPlanName(String planName) {
	this.planName = planName;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getBeginTime() {
	return beginTime;
}

public void setBeginTime(String beginTime) {
	this.beginTime = beginTime;
}

public String getOverTime() {
	return overTime;
}

public void setOverTime(String overTime) {
	this.overTime = overTime;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

}