package com.jmjk.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jmjk.dao.OldStaffHosDao;
import com.jmjk.dao.StaffRewardPunishDao;
import com.jmjk.dao.VStaffRewardPunishDao;
import com.jmjk.entity.TStaffRewardPunish;
import com.jmjk.entity.view.VStaffRewardPunish;
import com.jmjk.enums.OperatorState;
import com.jmjk.iservice.IStaffRewardPunishService;
import com.jmjk.utils.Page;
import com.jmjk.utils.SearchUtil;
import com.jmjk.utils.TypeConverter;

/**
 *   员工奖惩接口的实现
 * @author 黄仕鑫
 *
 */
@Controller("staffRewardPunishService")
public class StaffRewardPunishService implements IStaffRewardPunishService{

	@Autowired
	StaffRewardPunishDao staffRewardPunishDao;
	@Autowired
	OldStaffHosDao oldStaffHosDao;
	@Autowired
	VStaffRewardPunishDao vstaffRewardPunishDao;
	
	@Override
	public void addStaffRewardPunish(TStaffRewardPunish staffRewardPunish) {
		// TODO Auto-generated method stub
		staffRewardPunishDao.Save(staffRewardPunish);
	}

	@Override
	public void deleteStaffRewardPunishById(int staffRewardPunishId) {
		// TODO Auto-generated method stub
		String hql="delete TStaffRewardPunish tsrp where tsrp.staffRewardPunishId="+staffRewardPunishId;
		staffRewardPunishDao.delete(hql);
		
	}

	@Override
	public void updateTstaffRewardPunish(TStaffRewardPunish staffRewardPunish) {
		// TODO Auto-generated method stub
		staffRewardPunishDao.update(staffRewardPunish);
	}

	@Override
	public List<VStaffRewardPunish> getCommunicityTStaffRewardPunish(
			Page<VStaffRewardPunish> page, int communityHospitalId) {
		// TODO Auto-generated method stub
		String hql = "";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("operateState", OperatorState.shanchu.getvalue());
		if(communityHospitalId != -1){
			params.put("communityHospitalId", communityHospitalId);
			hql="from VStaffRewardPunish vsrp where vsrp.communityHospitalId=:communityHospitalId and vsrp.operateState <> :operateState order by staffRewardPunishId desc";
		}else{
			hql="from VStaffRewardPunish vsrp where vsrp.operateState <> :operateState order by staffRewardPunishId desc";
		}
		return vstaffRewardPunishDao.find(hql,params, page.getCurrentPage(), page.getPageSize());
	}

	@Override
	public long countTStaffRewardPunish(int communityHospitalId) {
		// TODO Auto-generated method stub
		String hql="";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("operateState", OperatorState.shanchu.getvalue());		
		if(communityHospitalId != -1){
			params.put("communityHospitalId", communityHospitalId);
			hql="select count(vsrp.staffRewardPunishId) from VStaffRewardPunish vsrp where vsrp.communityHospitalId=:communityHospitalId and vsrp.operateState <> :operateState";
		}else{
			 hql="select count(vsrp.staffRewardPunishId) from VStaffRewardPunish vsrp where vsrp.operateState <> :operateState";
		}
		return vstaffRewardPunishDao.count(hql,params);
	}

	@Override
	public VStaffRewardPunish getTStaffRewardPunishByStaffId(int StaffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("StaffId", StaffId);
		params.put("operateState", OperatorState.shanchu.getvalue());
		String hql="from VStaffRewardPunish vsp where vsp.staffRewardPunishId = :StaffId and vsp.operateState <> :operateState" ;
		VStaffRewardPunish vsp=vstaffRewardPunishDao.Get(hql,params);
		return vsp;
	}

	@Override
	public List<VStaffRewardPunish> searchStaffRewardPunish(
			Page<VStaffRewardPunish> page, int communityHospitalId,int flag,
			Date beginTime, Date overTime, String rewordPunishType, String name) {
		Map<String, Object> params = new HashMap<String, Object>();
		String staffRewardPunishHql=" from VStaffRewardPunish staffRewardPunish where 1=1 ";
		if(name != null){
			if( !name.equals("") && name != ""){
				params.put("name", "%"+name+"%");
				staffRewardPunishHql+="and staffRewardPunish.name like :name ";
			}
		}
		//2.拼入rewordPunishType
		if(rewordPunishType!= null ){
			if(!rewordPunishType .equals("") &&rewordPunishType != ""){
				params.put("rewordPunishType", rewordPunishType);
				staffRewardPunishHql +="and staffRewardPunish.rewordPunishType like :rewordPunishType ";
			}
		}
		if(flag != 0){
			if(overTime != null){
				String to = TypeConverter.dateFormat(overTime);
				staffRewardPunishHql += " and  staffRewardPunish.rewardPunishDate <= '";
				staffRewardPunishHql += to;
				staffRewardPunishHql +="' ";
			}
			if(beginTime != null){
				String from = TypeConverter.dateFormat(beginTime);
				staffRewardPunishHql += "and  staffRewardPunish.rewardPunishDate >= '";
				staffRewardPunishHql += from;
				staffRewardPunishHql +="'";
			}
		}
		String hql = staffRewardPunishHql;
		if(communityHospitalId != -1){
			params.put("communityHospitalId", communityHospitalId);
			hql+=" and staffRewardPunish.communityHospitalId=:communityHospitalId";
		}
		List<VStaffRewardPunish> list=vstaffRewardPunishDao.find(hql,params,page.getCurrentPage(), page.getPageSize());
		    return list;
	}

	@Override
	public long countStaffRewardPunish(int flag, int communityHospitalId,Date beginTime, Date overTime,
			String rewordPunishType, String name,String department) {
		Map<String, Object> params = new HashMap<String, Object>();
		String staffRewardPunishHql=" from VStaffRewardPunish staffRewardPunish where 1=1 ";
		if(name != null){
			if( !name.equals("") && name != ""){
				params.put("name", "%"+name+"%");
				staffRewardPunishHql+="and staffRewardPunish.name like :name ";
			}
		}
		//2.拼入rewordPunishType
		if(rewordPunishType!= null ){
			if(!rewordPunishType .equals("") &&rewordPunishType != ""){
				params.put("rewordPunishType", rewordPunishType);
				staffRewardPunishHql +="and staffRewardPunish.rewordPunishType = :rewordPunishType ";
			}
		}
		if(flag != 0){
			if(overTime != null){
				String to = TypeConverter.dateFormat(overTime);
				staffRewardPunishHql += " and  staffRewardPunish.rewardPunishDate <= '";
				staffRewardPunishHql += to;
				staffRewardPunishHql +="' ";
			}
			if(beginTime != null){
				String from = TypeConverter.dateFormat(beginTime);
				staffRewardPunishHql += "and  staffRewardPunish.rewardPunishDate >= '";
				staffRewardPunishHql += from;
				staffRewardPunishHql +="'";
			}
		}
		String hql = staffRewardPunishHql;
		if(communityHospitalId != -1){
			params.put("communityHospitalId", communityHospitalId);
			hql+=" and staffRewardPunish.communityHospitalId= :communityHospitalId ";
		}
		List<VStaffRewardPunish> list = vstaffRewardPunishDao.find(hql,params);
		if(list == null){
			return 0;
		}
		return list.size();
	}
	@Override
	public TStaffRewardPunish getTStaffRewardPunishBysrpId(int staffRewardPunishId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffRewardPunishId", staffRewardPunishId);
		String hql="from TStaffRewardPunish srp where srp.staffRewardPunishId=:staffRewardPunishId ";
		return staffRewardPunishDao.Get(hql,params);
	}

	@Override
	public void deleteMoreStaffRewardPunish(List<Object> deleteList) {
		// TODO Auto-generated method stub
		String str=TypeConverter.convertList2String(deleteList,",");
		String hql="delete from TStaffRewardPunish srp  where srp.staffRewardPunishId in ("+str+")";
		staffRewardPunishDao.delete(hql);
		
	}

	@Override
	public List<VStaffRewardPunish> getVStaffRewardPunishsByStaffRewardPunishId(
			int staffRewardPunishId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffRewardPunishId", staffRewardPunishId);
		String hql="from VStaffRewardPunish vrsp where vrsp.staffRewardPunishId =:staffRewardPunishId";
		return vstaffRewardPunishDao.find(hql,params);
	}
	

	@Override
	public List<VStaffRewardPunish> getCommunicityAllTStaffRewardPunish(int sqId) {
		String hql="";
		Map<String, Object> params = new HashMap<String, Object>();
		if(sqId == -1){
			hql="from VStaffRewardPunish vrsp";
		}else{
			params.put("sqId", sqId);
			hql="from VStaffRewardPunish vrsp where vrsp.communityHospitalId =:sqId";
		}
		return vstaffRewardPunishDao.find(hql,params);
	}

	@Override
	public Boolean getStaffRPIsStaff(int staffId, int staffRPId) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		params.put("staffRPId", staffRPId);
		String hql="from TStaffRewardPunish ts where ts.TStaff.staffId =:staffId  and ts.staffRewardPunishId =:staffRPId";
		return (staffRewardPunishDao.Get(hql,params)!=null);
	}

	@Override
	public Boolean getStaffIsHos(int staffId, int hospitalId) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		params.put("hospitalId", hospitalId);
		String hql="from TOldStaffHos toh where toh.TStaff.staffId =:staffId and toh.TCommunityHospital.communityHospitalId =:hospitalId";
		return (oldStaffHosDao.Get(hql,params)!=null);
	}

	@Override
	public Boolean getStaffPunishIsHos(int staffRewardPunishId, int hospitalId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffRewardPunishId", staffRewardPunishId);
		params.put("hospitalId", hospitalId);
		String hql="from VStaffRewardPunish vrsp where vrsp.staffRewardPunishId =:staffRewardPunishId  and vrsp.communityHospitalId=:hospitalId";
		return (vstaffRewardPunishDao.Get(hql,params)!=null);
	}
	//社区集团
	public long countTStaffGroupRewardPunish(int GId) {
		String hql="";	
		Map<String, Object> params=new HashMap<String, Object>();		
		params.put("operateState", OperatorState.shanchu.getvalue());
		params.put("GId", GId);
	    hql="select count(vsrp.staffRewardPunishId) from VStaffRewardPunish vsrp where vsrp.GId=:GId and vsrp.operateState <> :operateState";		
		return vstaffRewardPunishDao.count(hql,params);
	}
	
	public List<VStaffRewardPunish> getCommunicityTStaffGroupRewardPunish(
			Page<VStaffRewardPunish> page, int GId) {
		String hql = "";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("GId", GId);
		params.put("operateState", OperatorState.shanchu.getvalue());
		hql="from VStaffRewardPunish vsrp where vsrp.GId=:GId and vsrp.operateState <> :operateState order by staffRewardPunishId desc";		
		return vstaffRewardPunishDao.find(hql,params, page.getCurrentPage(), page.getPageSize());
	}
	
	public long countStaffRewardGroupPunish(int flag, int GId,Date beginTime, Date overTime,
			String rewordPunishType, String name,String department) {
		Map<String, Object> params = new HashMap<String, Object>();
		String staffRewardPunishHql=" from VStaffRewardPunish staffRewardPunish where 1=1 ";
		if(name != null){
			if( !name.equals("") && name != ""){
				params.put("name", "%"+name+"%");
				staffRewardPunishHql+="and staffRewardPunish.name like :name ";
			}
		}
		//2.拼入rewordPunishType
		if(rewordPunishType!= null ){
			if(!rewordPunishType .equals("") &&rewordPunishType != ""){
				params.put("rewordPunishType", rewordPunishType);
				staffRewardPunishHql +="and staffRewardPunish.rewordPunishType = :rewordPunishType ";
			}
		}
		if(flag != 0){
			if(overTime != null){
				String to = TypeConverter.dateFormat(overTime);
				staffRewardPunishHql += " and  staffRewardPunish.rewardPunishDate <= '";
				staffRewardPunishHql += to;
				staffRewardPunishHql +="' ";
			}
			if(beginTime != null){
				String from = TypeConverter.dateFormat(beginTime);
				staffRewardPunishHql += "and  staffRewardPunish.rewardPunishDate >= '";
				staffRewardPunishHql += from;
				staffRewardPunishHql +="'";
			}
		}
		String hql = staffRewardPunishHql;
		params.put("GId", GId);
		hql+=" and staffRewardPunish.GId= :GId ";
		List<VStaffRewardPunish> list = vstaffRewardPunishDao.find(hql,params);
		if(list == null){
			return 0;
		}
		return list.size();
	}
	
	public List<VStaffRewardPunish> searchStaffRewardGroupPunish(
			Page<VStaffRewardPunish> page, int GId,int flag,
			Date beginTime, Date overTime, String rewordPunishType, String name) {
		Map<String, Object> params = new HashMap<String, Object>();
		String staffRewardPunishHql=" from VStaffRewardPunish staffRewardPunish where 1=1 ";
		if(name != null){
			if( !name.equals("") && name != ""){
				params.put("name", "%"+name+"%");
				staffRewardPunishHql+="and staffRewardPunish.name like :name ";
			}
		}
		//2.拼入rewordPunishType
		if(rewordPunishType!= null ){
			if(!rewordPunishType .equals("") &&rewordPunishType != ""){
				params.put("rewordPunishType", rewordPunishType);
				staffRewardPunishHql +="and staffRewardPunish.rewordPunishType like :rewordPunishType ";
			}
		}
		if(flag != 0){
			if(overTime != null){
				String to = TypeConverter.dateFormat(overTime);
				staffRewardPunishHql += " and  staffRewardPunish.rewardPunishDate <= '";
				staffRewardPunishHql += to;
				staffRewardPunishHql +="' ";
			}
			if(beginTime != null){
				String from = TypeConverter.dateFormat(beginTime);
				staffRewardPunishHql += "and  staffRewardPunish.rewardPunishDate >= '";
				staffRewardPunishHql += from;
				staffRewardPunishHql +="'";
			}
		}
		String hql = staffRewardPunishHql;
		params.put("GId", GId);
		hql+=" and staffRewardPunish.GId=:GId";
		List<VStaffRewardPunish> list=vstaffRewardPunishDao.find(hql,params,page.getCurrentPage(), page.getPageSize());
		return list;
	}


}
