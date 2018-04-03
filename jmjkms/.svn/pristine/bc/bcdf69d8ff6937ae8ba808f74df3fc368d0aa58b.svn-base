package com.jmjk.export;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.jmjk.entity.TRecoveryOld;
import com.jmjk.entity.TRecoveryPlan;
import com.jmjk.enums.RecoveryPlanStatus;
import com.jmjk.service.RecoveryPlanService;
@Controller("statisticalAnalysisExport")
public class statisticalAnalysisExport extends SpringBeanAutowiringSupport {
	@Autowired
	private RecoveryPlanService recoveryPlanService;
	// 康复方案名称
	public String schemeName;
	// 康复计划名称
	public String planName;
	// 老人
	public String old;
	// 开始日期
	public String beginTime;
	// 结束日期
	public String overTime;
	// 状态
	public String status;

	public String[] getTitles() {
		String[] titles = {// 5g
		"康复方案名称", "康复计划名称", "老人", "开始日期", "结束日期", "状态" };
		return titles;
	}

	public statisticalAnalysisExport() {
	}

	public statisticalAnalysisExport(TRecoveryPlan trecoveryPlan) {
		super();
		if (trecoveryPlan.getTRecoveryScheme().getSchemeName() == null) {
			this.schemeName = "";
		} else {
			this.schemeName = trecoveryPlan.getTRecoveryScheme()
					.getSchemeName();
		}
		if(trecoveryPlan.getPlanName()==null){
			this.planName="";
		}else{
			this.planName = trecoveryPlan.getPlanName();
		}
		if(trecoveryPlan.getRecoveryPlanId()==null){
			this.old="";
		}else {
			
			List<TRecoveryOld> oldList=recoveryPlanService.getRecoveryOldById(trecoveryPlan.getRecoveryPlanId());
			if(oldList==null)
			{
				this.old="";
			}
			else{
				this.old="";
				for(TRecoveryOld list:oldList)
				{
					this.old+=list.getTHealthFile().getName();
					this.old+="，";
				}
				if(old.equals("")){
					this.old="";
				}
				else{
					this.old = this.old.substring(0, this.old.length()-1);
				}
			}
			
		}
        if(trecoveryPlan.getBeginTime()==null){
        	this.beginTime="";
        }else{
        	this.beginTime = trecoveryPlan.getBeginTime().toString();
        }
        if(trecoveryPlan.getOverTime()==null){
        	this.overTime="";
        }else{
        	this.overTime = trecoveryPlan.getOverTime().toString();
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

	// /////////////////////////////////////////////////////////////////////
	public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getOld() {
		return old;
	}

	public void setOld(String old) {
		this.old = old;
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
