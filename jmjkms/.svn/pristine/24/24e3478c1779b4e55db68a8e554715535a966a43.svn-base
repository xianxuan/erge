package com.jmjk.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.service.CommunityHospitalGroupService;
 
/** ok ,现在开始,不要动了,只提交,不更新!
 * 这个是员工管理查询的工具类,用来拼接hql语句,
 * @author Liufengshuang
 *15930779009 
 */
@Controller("searchUtil")
public class SearchUtil extends SpringBeanAutowiringSupport{
	@Autowired
	private CommunityHospitalGroupService communityHospitalGroupService;
	private String staffRewardPunishHql=" from VStaffRewardPunish staffRewardPunish where 1=1 ";
	public String getStaffRewardPunishHql(int flag, Date fromDate, Date toDate, String  rewordPunishType, String name){
		//1.拼入name
		if(name != null){
			if( !name.equals("") && name != ""){
				staffRewardPunishHql+="and staffRewardPunish.name like :name";
			}
		}
		//2.拼入rewordPunishType
		if(rewordPunishType!= null ){
			if(!rewordPunishType .equals("") &&rewordPunishType != ""){
				staffRewardPunishHql +="and staffRewardPunish.rewordPunishType = :rewordPunishType";
			}
		}
		Date date = new Date();
		//这些都是错误的输入值
		
		//如果toDate输入有误,到当前值
		if( toDate != null){
			if(toDate.after(date) ){
				toDate = date;
			}
		}else{
			toDate = date;
		}
		if(fromDate == null){
			return staffRewardPunishHql;
		}
		if(fromDate.after(toDate) || fromDate.after(date) ){
			return staffRewardPunishHql;
		}
		//拼入时间段
		String from = TypeConverter.dateFormat(fromDate);
		String to = TypeConverter.dateFormat(toDate);
		staffRewardPunishHql += "and ( staffRewardPunish.rewardPunishDate >= '";
		staffRewardPunishHql += from;
		staffRewardPunishHql +="'";
		staffRewardPunishHql += " and  staffRewardPunish.rewardPunishDate <= '";
		staffRewardPunishHql += to;
		staffRewardPunishHql +="' )";
		
		/*if(department.equals("") || department == null || department == "" ){}else{
			staffRewardPunishHql +=" and staffRewardPunish.department = '";
			staffRewardPunishHql +=department;
			staffRewardPunishHql +="'";
		}*/
		return staffRewardPunishHql;
	}
	 
	 
	//员工请假管理
	private String staffLeaveHql="from VStaffLeave staffLeave where 1=1 ";
	/**
	 * 暂时测试完毕......ok
	 * 这里有一个存储的时候的注意!!!  那就是存的时候不能把时分秒给存上!!!
	 * @param staffNumber 员工编码  --staffNumber
	 * @param name 员工姓名  --name
	 * @param leaveDate  请假日期 --leaveDate
	 * @param comebackDate   销假日期  --comebackDate
	 * @return
	 */
	public String getStaffLeaveHql(String staffNumber, String name, String comHos,Date leaveDateHigh,Date leaveDateLow, Date comebackDateHigh,Date comebackDateLow){
		//1.拼员工编码
		if(staffNumber != null && !staffNumber.equals("") && staffNumber != ""){
			staffLeaveHql+=" and staffLeave.staffNumber like :staffNumber";
		}
		//2.拼员工姓名
		if(name != null && !name.equals("") && name != ""){
			staffLeaveHql += " and staffLeave.name like :name";
		}
		if(comHos != null && !comHos.equals("") && comHos != ""){
			staffLeaveHql += " and staffLeave.communityHospital like :comHos";
		}
		//如果高请假时间
		if(leaveDateHigh != null){
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //注意yyyy-MM-dd这样的格式,M不能小写
			String dateStr = sdf.format(leaveDateHigh);
			String in = " and staffLeave.leaveDate <= '"+dateStr+"'";
			staffLeaveHql +=in;
		}
		//如果低请假时间
		if(leaveDateLow != null){
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //注意yyyy-MM-dd这样的格式,M不能小写
			String dateStr = sdf.format(leaveDateLow);
			String in = " and staffLeave.leaveDate >= '"+dateStr+"'";
			staffLeaveHql +=in;
		}
		//拼入销假时间上
		if(comebackDateHigh != null){
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //注意yyyy-MM-dd这样的格式,M不能小写
			String dateStr = sdf.format(comebackDateHigh);
			String in = " and staffLeave.comebackDate <= '"+dateStr+"'";
			staffLeaveHql +=in;
		}
		//拼入销假时间下
		if(comebackDateLow != null){
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //注意yyyy-MM-dd这样的格式,M不能小写
			String dateStr = sdf.format(comebackDateLow);
			String in = " and staffLeave.comebackDate >= '"+dateStr+"'";
			staffLeaveHql +=in;
		}
		return staffLeaveHql;
	}
	

	
	public SearchUtil(){}
	
	//员工信息管理
	private String staffhql="from VStaffHos staff where 1=1 ";
	//员工信息管理的查询hql拼接
	/**
	 * 暂时测试完成.....OK!
	 * @param flag 用来标记身份证号 还是员工编号  身份证号1 员工编号2  (身份证号--idCardNum  员工编号 --staffNumber)
	 * @param value 用来承接身份证号和员工编号的值
	 * @param name 姓名   --name
	 * @param state 状态 --state
	 * @param department 部门 --department
	 * @return
	 */
	 public String getStaffHql(int dis,int flag, String value, String state, String department, int sqId){
		 //2.如果value值不为空
		 if(value != null && !value.equals("") && value != ""){
			 //2.1判断flag
			 if(flag==1){//2.1.1拼入身份证号 
				 staffhql+=" and staff.idCardNum like :value ";
			 }
			 if(flag == 2){//2.1.2拼入员工编号
				 staffhql+=" and staff.staffNumber like :value ";
			 }
			 if(flag == 3){//拼入员工姓名
				 staffhql += "and staff.name like :value ";
			 }
			 if(flag==4){//拼入社区医院
				 staffhql += "and staff.communityHospital like :value ";
			 }
		 }
		 //3.拼入状态属性state
		 if(state != null && !state.equals("") && state != ""){
			 staffhql+=" and staff.state = :state";
		 }
		 //4.拼入职务属性department
		 if(department != null && !department.equals("") && department != ""){
			 staffhql+=" and staff.department = :department";
		 }
		 //拼入社区Id
		 if(sqId != -1 && dis==2){
			 staffhql += " and staff.communityHospitalId=:sqId";
		 }else if(dis==1){
			 
			 staffhql += " and staff.GId=:sqId";

		 }
		 return staffhql;
	 }
	 
	 private String Tstaffhql="from VStaffHos staff where 1=1 ";
	 public String getTStaffHql(int flag, String value, String state, String department){
		 //2.如果value值不为空
		 if(value != null && !value.equals("") && value != ""){
			 //2.1判断flag
			 if(flag==1){//2.1.1拼入身份证号
				 Tstaffhql+=" and staff.idCardNum = :value";
			 }
			 if(flag == 2){//2.1.2拼入员工编号
				 Tstaffhql+=" and staff.staffNumber like :value";
			 }
			 if(flag == 3){//拼入员工姓名
				 Tstaffhql += "and staff.name like :value";
			 }
			 if(flag==4){//拼入社区医院
				 Tstaffhql += "and staff.communityHospital like :value ";
			 }
		 }
		 //3.拼入状态属性state
		 if(state != null && !state.equals("") && state != ""){
			 Tstaffhql+=" and staff.state =:state";
		 }
		 //4.拼入职务属性department
		 if(department != null && !department.equals("") && department != ""){
			 Tstaffhql+=" and staff.department = :department";
		 }
		 return Tstaffhql;
	 }
}
