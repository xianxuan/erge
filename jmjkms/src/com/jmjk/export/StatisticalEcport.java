package com.jmjk.export;

import java.util.List;

import com.jmjk.entity.TRecoveryOld;
import com.jmjk.entity.TRecoveryPlan;

public class StatisticalEcport {
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

		public StatisticalEcport() {
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
