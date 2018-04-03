package com.jmjk.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.StaffLeaveDao;
import com.jmjk.dao.VStaffLeaveDao;
import com.jmjk.entity.TStaffLeave;
import com.jmjk.entity.view.VStaffLeave;
import com.jmjk.iservice.IStaffLeaveService;
import com.jmjk.utils.Page;
import com.jmjk.utils.SearchUtil;
import com.jmjk.utils.TypeConverter;

/**
 * 
 * @author Liufengshuang
 *   15930779009
 */
@Controller("staffLeaveService")
public class StaffLeaveService implements IStaffLeaveService{

	@Autowired
	private VStaffLeaveDao vstaffLeaveDao;
	@Autowired
	private StaffLeaveDao staffLeaveDao;
	@Override
	public List<VStaffLeave> getVStaffLeaveBycommunityHospitalId(
			int communityHospitalId, Page  page) {
		String hql="from VStaffLeave v where v.communityHospitalId="+communityHospitalId +" order by staffLeaveId desc";
		return vstaffLeaveDao.find(hql,page.getCurrentPage(),page.getPageSize());
	}

	@Override
	public void saveStaffLeave(TStaffLeave staffLeave) {
		staffLeaveDao.Save(staffLeave);
	}

	@Override
	public void deleteStaffLeaveById(int staffLeaveId) {
		String hql="delete from TStaffLeave sl where sl.staffLeaveId = "+staffLeaveId;
		staffLeaveDao.delete(hql);
	}

	@Override
	public void updateStaffLeave(TStaffLeave staffLeave) {
		staffLeaveDao.update(staffLeave);
	}

	@Override
	public long countStaffLeave() {
		String hql = "select count(staffLeave.staffLeaveId) from TStaffLeave staffLeave ";
		return staffLeaveDao.count(hql);
	}

	@Override
	public List<TStaffLeave> getStaffLeaveByPage(Page page) {
		String hql ="from TStaffLeave ";
		return staffLeaveDao.find(hql, page.getCurrentPage(), page.getPageSize());
	}

	@Override
	public TStaffLeave getStaffLeaveById(int staffLeaveId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffLeaveId", staffLeaveId);
		String hql="from TStaffLeave sl where sl.staffLeaveId=:staffLeaveId";
		return staffLeaveDao.Get(hql,params);
	}
	public void comeBackStart(int staffLeaveId){
		//1.将销假日期填上
		Date date = new Date();
		long come = date.getTime();
		String str = TypeConverter.dateFormat(date);
		String hql = "update TStaffLeave staffLeave set staffLeave.comebackDate = '"+str+"'  where staffLeave.staffLeaveId = "+staffLeaveId ;
		//2.将请假天数填上
		staffLeaveDao.update(hql);
	}
	@Override
	public void comeBack(int staffLeaveId) {
		Date date = new Date();
		long come = date.getTime();
		//1.
		TStaffLeave staffLeave = this.getStaffLeaveById(staffLeaveId);
		Timestamp comedate=TypeConverter.date2Timestamp(date);
		staffLeave.setComebackDate(comedate);
		//2.将请假天数填上
		if(staffLeave.getLeaveDate() != null){
			Date leaveDate = staffLeave.getLeaveDate();
			long leave = leaveDate.getTime();
			if(come > leave){ //
				double days = (come-leave)/(1000 * 60 * 60 * 24);
				staffLeave.setActualDays(days);
			}else{
				staffLeave.setActualDays((double)0);
			}
		}
		staffLeaveDao.update(staffLeave);
	}
	@Override
	public long countStaffLeaveBySearch(int flag,String staffNumber,
			String name,String comHos, Date leaveDateHigh,Date leaveDateLow, Date comeBackDateHigh,Date comeBackDateLow, int sqId)  {
		 List<VStaffLeave> list = this.getStaffLeaveBySearch(flag,staffNumber,name,comHos, leaveDateHigh,leaveDateLow, comeBackDateHigh,comeBackDateLow, sqId);
		if(list == null){return 0;}
		 return list.size();
	}
	@Override
	public List<VStaffLeave> getStaffLeaveBySearch(int flag,String staffNumber,
			String name,String comHos, Date leaveDateHigh,Date leaveDateLow, Date comeBackDateHigh,Date comeBackDateLow, int sqId) {
		SearchUtil su = new SearchUtil();
		Map<String, Object> params = new HashMap<String, Object>();
		if(staffNumber != null && !staffNumber.equals("") && staffNumber != ""){
			params.put("staffNumber", staffNumber);
		}
		if(name != null && !name.equals("") && name != ""){
			params.put("name", "%"+name+"%");
		}
		if(comHos != null && !comHos.equals("") && comHos != ""){
			params.put("comHos", "%"+comHos+"%");
		}
		params.put("sqId", sqId);
		String hql = su.getStaffLeaveHql(staffNumber, name, comHos,leaveDateHigh,leaveDateLow, comeBackDateHigh,comeBackDateLow);
		if(flag==2){
			hql += " and staffLeave.communityHospitalId = :sqId";
		}
		else
			hql += " and staffLeave.GId = :sqId";
		List<VStaffLeave> list = vstaffLeaveDao.find(hql,params);
		return list;
	}

	@Override
	public int deleteStaffList(List<Object> staffLeaveIds) {
		if(staffLeaveIds.size() == 0 || staffLeaveIds == null || staffLeaveIds.equals("")){
			return -1;
		}
		String a=",";
		String str = TypeConverter.convertList2String(staffLeaveIds, a);
		String hql="delete from TStaffLeave staffleave where staffleave.staffLeaveId in ("+str+")";
		return 0;
	}

	@Override
	public List<VStaffLeave> getStaffLeavesByCommunityHospitalId(int communityHospitalId) {
		String hql="";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("communityHospitalId", communityHospitalId);
		if(communityHospitalId != -1){
			hql=" from VStaffLeave v where v.communityHospitalId =:communityHospitalId";
		}else{
			hql=" from VStaffLeave v ";
		}
		return vstaffLeaveDao.find(hql,params);
	}

	@Override
	public long countStaffLeaveByCommunityHospitalId(int sqId) {
		List<VStaffLeave> list =this.getStaffLeavesByCommunityHospitalId(sqId);
		if(list == null || list.size() == 0){return 0;}
		return list.size();
	}



	@Override
	public List<VStaffLeave> getStaffLeaveBySearch(int flag,String staffNumber, String name,String comHos, Date leaveDateHigh,Date leaveDateLow, Date comeBackDateHigh,Date comebackDateLow, int sqId,Page page){
		SearchUtil su = new SearchUtil();
		Map<String, Object> params = new HashMap<String, Object>();
		if(staffNumber != null && !staffNumber.equals("") && staffNumber != ""){
			params.put("staffNumber", "%"+staffNumber+"%");
		}
		if(name != null && !name.equals("") && name != ""){
			params.put("name", "%"+name+"%");
		}
		if(comHos != null && !comHos.equals("") && comHos != ""){
			params.put("comHos", "%"+comHos+"%");
		}
		String hql = su.getStaffLeaveHql(staffNumber,name,comHos, leaveDateHigh,leaveDateLow,comeBackDateHigh, comebackDateLow);
		if(sqId != -1 && flag==2){
			params.put("sqId", sqId);
			hql += " and staffLeave.communityHospitalId = :sqId";
		}
		else if(flag==1){
			params.put("sqId", sqId);
			hql += " and staffLeave.GId = :sqId";
		}
		List<VStaffLeave> list = vstaffLeaveDao.find(hql,params,page.getCurrentPage(), page.getPageSize());
		return list;
	}

	@Override
	public List<VStaffLeave> getAllStaffLeave(Page page) {
		String hql="from VStaffLeave order by staffLeaveId desc";
		return vstaffLeaveDao.find(hql,page.getCurrentPage(), page.getPageSize());
	}

	public long countStaffLeaveGroupByCommunityHospitalId(int sqId) {
		String hql="";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sqId", sqId);
		hql=" from VStaffLeave v where v.GId =:sqId";
		List<VStaffLeave> list= vstaffLeaveDao.find(hql,params);
		if(list == null || list.size() == 0){return 0;}
		return list.size();
	}

	public List<VStaffLeave> getVStaffLeaveGroupBycommunityHospitalId(
			int GId, Page  page) {
		String hql="from VStaffLeave v where v.GId="+GId +" order by staffLeaveId desc";
		return vstaffLeaveDao.find(hql,page.getCurrentPage(),page.getPageSize());
	}
	
}
