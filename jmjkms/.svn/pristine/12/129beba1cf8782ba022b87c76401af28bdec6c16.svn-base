package com.jmjk.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.DoorKnockingDao;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.TDoorKnocking;
import com.jmjk.iservice.IDoorKnockingService;
import com.jmjk.utils.Page;
import com.jmjk.utils.TypeConverter;

@Controller("doorKnockingService")
public class DoorKnockingService implements IDoorKnockingService{

	@Autowired
	private DoorKnockingDao doorKnockingDao;
	@Autowired
	private CommunityHospitalGroupService communityHospitalGroupService;
	@Override
	public void saveDoorKnocking(TDoorKnocking doorknocking) {
		
		doorKnockingDao.Save(doorknocking);
	}

	@Override
	public void deleteDoorKnocking(int doorknockingID) {
	
		String hql="delete from TDoorKnocking tdk where tdk.doorKnockingId="+doorknockingID;
		doorKnockingDao.delete(hql);
	}

	@Override
	public void updateDoorKnocking(TDoorKnocking doorknocking) {
		doorKnockingDao.update(doorknocking);
	}

	@Override
	public List<TDoorKnocking> getTDoorKnockingListBySearch(int comHosId,
			 String strSearchText, String status, Date beginTime,
			Date endTime, Page<TDoorKnocking> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("comHosId", comHosId);
		String hql= "from TDoorKnocking tdk where tdk.communityHospitalId = :comHosId";
		if (StringUtils.isNotBlank(strSearchText)) {
			params.put("strSearchText", "%"+strSearchText+"%");
			hql += " and tdk.visiteName like :strSearchText";
		}
		if (status!=""&!"".equals(status)) {
			params.put("status", status);
			hql+=" and tdk.status= :status";
		}
		
		if(beginTime!=null){
			hql += " and DATE_FORMAT(tdk.planTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(tdk.planTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		hql+=" order by tdk.planTime desc";
		List<TDoorKnocking> doorKnockings = doorKnockingDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
		return doorKnockings;
	}

	@Override
	public long getTDoorKnockingNumBySearch(int comHosId,String strSearchText, String status,Date beginTime, Date endTime) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("comHosId", comHosId);
		String hql = " select count(tdk.doorKnockingId) from TDoorKnocking tdk where tdk.communityHospitalId = :comHosId";
		if (StringUtils.isNotBlank(strSearchText)) {
			params.put("strSearchText","%"+strSearchText+"%");
			hql += " and tdk.visiteName like :strSearchText";
		}
		
		if (status!=""&!"".equals(status)) {
			params.put("status",status);
			hql+=" and tdk.status= :status";
		}
		
		if(beginTime!=null){
			hql += " and DATE_FORMAT(tdk.planTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(tdk.planTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		return doorKnockingDao.count(hql,params);
	}

	@Override
	public TDoorKnocking getDoorKnockingById(int doorknockinID) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("doorknockinID", doorknockinID);
		String hql="from TDoorKnocking tdk where tdk.doorKnockingId = :doorknockinID";
		TDoorKnocking tDoorKnocking=doorKnockingDao.Get(hql,params);
		return tDoorKnocking;
	}

	@Override
	public List<TDoorKnocking> getDoorKnockingListByComhosId(int comHosId,
			Page<TDoorKnocking> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("comHosId", comHosId);
		String hql = "from TDoorKnocking tdk where tdk.communityHospitalId = :comHosId";
		hql+=" order by tdk.planTime desc";
		List<TDoorKnocking> list = doorKnockingDao.find(hql,params,page.getCurrentPage(), page.getPageSize());
		return list;
	}
	public List<TDoorKnocking> getDoorKnockingListForSpecial(int staffID,
			Page<TDoorKnocking> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffID", staffID);
		String hql = "from TDoorKnocking tdk where tdk.TStaff.staffId = :staffID";
		hql+=" order by tdk.planTime desc";
		List<TDoorKnocking> list = doorKnockingDao.find(hql,params,page.getCurrentPage(), page.getPageSize());
		return list;
	}

	@Override
	public long getDoorKnockingNumByComhosId(int comHosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("comHosId", comHosId);
		String hql = "select count(*) from TDoorKnocking tdk where tdk.communityHospitalId = :comHosId";
		long count=doorKnockingDao.count(hql,params);
		return count;
	}
	public long getDoorKnockingNumForSpecial(int staffID) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffID", staffID);
		String hql = "select count(*) from TDoorKnocking tdk where tdk.TStaff.staffId = :staffID";
		long count=doorKnockingDao.count(hql,params);
		return count;
	}
	@Override
	public List<TDoorKnocking> getDoorKnockingListByAll(Page page) {
		String hql ="from TDoorKnocking tdk order by tdk.planTime desc";
		List<TDoorKnocking> list = doorKnockingDao.find(hql,page.getCurrentPage(),page.getPageSize());
		return list;
	}


	@Override
	public long getDoorNumSpecialBySearch(int staffID, String strSearchText,
			String status, Date beginTime, Date endTime) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffID", staffID);
		String hql = "select count(*) from TDoorKnocking tdk where tdk.TStaff.staffId = :staffID";
		/*String hql = " select count(tdk.doorKnockingId) from TDoorKnocking tdk where tdk.communityHospitalId = :comHosId";*/
		if (StringUtils.isNotBlank(strSearchText)) {
			params.put("strSearchText","%"+strSearchText+"%");
			hql += " and tdk.visiteName like :strSearchText";
		}
		
		if (status!=""&!"".equals(status)) {
			params.put("status",status);
			hql+=" and tdk.status= :status";
		}
		
		if(beginTime!=null){
			hql += " and DATE_FORMAT(tdk.planTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(tdk.planTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		return doorKnockingDao.count(hql,params);
	}

	@Override
	public List<TDoorKnocking> getDoorListSpecialBySearch(int staffID,
			String strSearchText, String status, Date beginTime, Date endTime,
			Page<TDoorKnocking> page) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffID", staffID);
		/*String hql= "from TDoorKnocking tdk where tdk.communityHospitalId = :comHosId";*/
		String hql = "from TDoorKnocking tdk where tdk.TStaff.staffId = :staffID";
		if (StringUtils.isNotBlank(strSearchText)) {
			params.put("strSearchText", "%"+strSearchText+"%");
			hql += " and tdk.visiteName like :strSearchText";
		}
		if (status!=""&!"".equals(status)) {
			params.put("status", status);
			hql+=" and tdk.status= :status";
		}
		
		if(beginTime!=null){
			hql += " and DATE_FORMAT(tdk.planTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(tdk.planTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		hql+=" order by tdk.planTime desc";
		List<TDoorKnocking> doorKnockings = doorKnockingDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
		return doorKnockings;
	}
	@Override
	public long getDoorKnockingNumByAll() {
		String hql = "select count(*) from TDoorKnocking";
		long count = doorKnockingDao.count(hql);
		return count;
	}
 
	@Override
	public List<TDoorKnocking> geTDoorKnockingListById(int comHosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("comHosId", comHosId);
		String hql = " from TDoorKnocking tdk where tdk.communityHospitalId = :comHosId";
		hql+=" order by tdk.planTime desc";
		List<TDoorKnocking> list = doorKnockingDao.find(hql,params);
		return list;
	}

	@Override
	public List<TDoorKnocking> getDoorKnockingListBySearch(
			String strSearchText, String status, Date beginTime, Date endTime,
			Page<TDoorKnocking> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from TDoorKnocking tdk where 1=1";
		if (StringUtils.isNotBlank(strSearchText)) {
			params.put("strSearchText", "%"+strSearchText+"%");
			hql += " and tdk.visiteName like :strSearchText";
		}
		if (status!=""&!"".equals(status)) {
			params.put("status", status);
			hql+=" and tdk.status= :status";
		}
		
		if(beginTime!=null){
			hql += " and DATE_FORMAT(tdk.planTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(tdk.planTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		hql+=" order by tdk.planTime desc";
		List<TDoorKnocking> list = doorKnockingDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
		return list;
	}

	@Override
	public long getDoorKnockingNumBySearch(String strSearchText, String status,
			Date beginTime, Date endTime) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " select count(*) from TDoorKnocking tdk where 1=1";
		if (StringUtils.isNotBlank(strSearchText)) {
			params.put("strSearchText", "%"+strSearchText+"%");
			hql += " and tdk.visiteName like :strSearchText";
		}
		if (status!=""&!"".equals(status)) {
			params.put("status", status);
			hql+=" and tdk.status= :status";
		}
		
		if(beginTime!=null){
			hql += " and DATE_FORMAT(tdk.planTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(tdk.planTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		hql+=" order by tdk.planTime desc";
		long num = doorKnockingDao.count(hql,params);
		return num;
	}

	@Override
	public long getDoorKnockingNumByGroup(TCommunityHospitalGroup comHosGroup) {
		List<TCommunityHospital> listcomHospitals=new ArrayList<TCommunityHospital>();
		listcomHospitals=communityHospitalGroupService.getComHosListByGroup(comHosGroup);
		if(listcomHospitals.size()==0)
		    return 0; 
		List<Object> listcomHosId=new ArrayList<Object>();
		for(int i=0;i<listcomHospitals.size();i++){
			listcomHosId.add(listcomHospitals.get(i).getCommunityHospitalId());
		}  //根据社区医院IDList获得 健康教育数量
		String a = ",";
		String str = TypeConverter.convertList2String(listcomHosId,a);
		String hql="select count(*) from TDoorKnocking td where td.communityHospitalId in ("+str+")";
		return doorKnockingDao.count(hql);
	}

	@Override
	public List<TDoorKnocking> getDoorKnockingListByGroup(
			TCommunityHospitalGroup comHosGroup) {
		List<TCommunityHospital> listcomHospitals=new ArrayList<TCommunityHospital>();
		listcomHospitals=communityHospitalGroupService.getComHosListByGroup(comHosGroup);
		if(listcomHospitals.size()==0)
		    return null; 
		List<Object> listcomHosId=new ArrayList<Object>();
		for(int i=0;i<listcomHospitals.size();i++){
			listcomHosId.add(listcomHospitals.get(i).getCommunityHospitalId());
		}  //根据社区医院IDList获得 健康教育数量
		String a = ",";
		String str = TypeConverter.convertList2String(listcomHosId,a);
		String hql="from TDoorKnocking td where td.communityHospitalId in ("+str+")";
		hql+=" order by td.planTime desc";
		return doorKnockingDao.find(hql);
	}

	@Override
	public long getDoorkNumGroupNumBySearch(int groupId, String strSearchText,
			String status, Date beginTime, Date endTime) {
		TCommunityHospitalGroup comHosGroup = communityHospitalGroupService.getComHosGroupByGroupId(groupId);
		List<TCommunityHospital> listcomHospitals=new ArrayList<TCommunityHospital>();
		listcomHospitals=communityHospitalGroupService.getComHosListByGroup(comHosGroup);
		List<Object> listcomHosId=new ArrayList<Object>();
		for(int i=0;i<listcomHospitals.size();i++){
			listcomHosId.add(listcomHospitals.get(i).getCommunityHospitalId());
		}
		String a = ",";
		String str = TypeConverter.convertList2String(listcomHosId,a);
		Map<String, Object> params = new HashMap<String, Object>();
		String hql="select count(*) from TDoorKnocking td where td.communityHospitalId in ("+str+")";
		if (StringUtils.isNotBlank(strSearchText)) {
			params.put("strSearchText","%"+strSearchText+"%");
			hql += " and td.visiteName like :strSearchText";
		}
		
		if (status!=""&!"".equals(status)) {
			params.put("status",status);
			hql+=" and td.status= :status";
		}
		
		if(beginTime!=null){
			hql += " and DATE_FORMAT(td.planTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(td.planTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		long num = doorKnockingDao.count(hql, params);
		return num;
	}

	@Override
	public List<TDoorKnocking> getDoorkListGroupListBySearch(int groupId,
			String strSearchText, String status, Date beginTime, Date endTime,
			Page<TDoorKnocking> page) {
		TCommunityHospitalGroup comHosGroup = communityHospitalGroupService.getComHosGroupByGroupId(groupId);
		List<TCommunityHospital> listcomHospitals=new ArrayList<TCommunityHospital>();
		listcomHospitals=communityHospitalGroupService.getComHosListByGroup(comHosGroup);
		List<Object> listcomHosId=new ArrayList<Object>();
		for(int i=0;i<listcomHospitals.size();i++){
			listcomHosId.add(listcomHospitals.get(i).getCommunityHospitalId());
		}
		String a = ",";
		String str = TypeConverter.convertList2String(listcomHosId,a);
		Map<String, Object> params = new HashMap<String, Object>();
		String hql="from TDoorKnocking td where td.communityHospitalId in ("+str+")";
		if (StringUtils.isNotBlank(strSearchText)) {
			params.put("strSearchText", "%"+strSearchText+"%");
			hql += " and td.visiteName like :strSearchText";
		}
		if (status!=""&!"".equals(status)) {
			params.put("status", status);
			hql+=" and td.status= :status";
		}
		
		if(beginTime!=null){
			hql += " and DATE_FORMAT(td.planTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(td.planTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		hql+=" order by td.planTime desc";
		List<TDoorKnocking> doorKnockings = doorKnockingDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
		return doorKnockings;
	}


}
