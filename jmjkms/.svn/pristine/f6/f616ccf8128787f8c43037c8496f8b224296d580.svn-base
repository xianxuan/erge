package com.jmjk.export;


import com.jmjk.entity.TStaffRewardPunish;
import com.jmjk.entity.view.VStaffRewardPunish;



/*
 * 导出员工奖惩
 * @author  黄仕鑫
 */
public class StaffRewardPunishExport {
    //1员工编码1
	public String staffNumber;  
	//员工姓名2
	public String name;
	//员工的奖惩日期3
	public String  rewardPunishDate; 
	//奖惩类型
	public String rewordPunishType; 
	 //奖惩原因
	public String rewordPunishReason; 
	//金额6
	public String rewordPunishAmount;  
	public String[] getTitles(){
		String [] titles = {//6
				"员工编号","姓名","奖惩日期","奖惩类型","奖惩原因","金额"
		};
		return titles;
	}
	public StaffRewardPunishExport() {}
	
	public StaffRewardPunishExport(TStaffRewardPunish staffRewardPunish) {
		if(staffRewardPunish != null){
			this.staffNumber=staffRewardPunish.getTStaff().getStaffNumber();
			this.name=staffRewardPunish.getTStaff().getName();
			if(staffRewardPunish.getRewardPunishDate() != null){
				this.rewardPunishDate=staffRewardPunish.getRewardPunishDate().toString();
			}
			this.rewordPunishType=staffRewardPunish.getRewordPunishType();
			this.rewordPunishReason=staffRewardPunish.getRewordPunishReason();
			if(staffRewardPunish.getRewordPunishAmount() != null){
				this.rewordPunishAmount=staffRewardPunish.getRewordPunishAmount().toString();
			}
		}
	}
	
	public StaffRewardPunishExport(VStaffRewardPunish sp){
		/*if(sp != null){*/
			this.staffNumber = sp.getStaffNumber();
			this.name = sp.getName();
			if(sp.getRewardPunishDate() != null ){
				this.rewardPunishDate = sp.getRewardPunishDate().toString();
			}
			this.rewordPunishType = sp.getRewordPunishType();
			this.rewordPunishReason = sp.getRewordPunishReason();
			if(sp.getRewordPunishAmount() != null){
				this.rewordPunishAmount =sp.getRewordPunishAmount().toString();
			}
			
	/*	}*/
		
		
		
	}
	
	
	public String getStaffNumber() {
		return staffNumber;
	}
	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRewardPunishDate() {
		return rewardPunishDate;
	}
	public void setRewardPunishDate(String rewardPunishDate) {
		this.rewardPunishDate = rewardPunishDate;
	}
	public String getRewordPunishType() {
		return rewordPunishType;
	}
	public void setRewordPunishType(String rewordPunishType) {
		this.rewordPunishType = rewordPunishType;
	}
	public String getRewordPunishReason() {
		return rewordPunishReason;
	}
	public void setRewordPunishReason(String rewordPunishReason) {
		this.rewordPunishReason = rewordPunishReason;
	}
	public String getRewordPunishAmount() {
		return rewordPunishAmount;
	}
	public void setRewordPunishAmount(String rewordPunishAmount) {
		this.rewordPunishAmount = rewordPunishAmount;
	}
	
	
}
