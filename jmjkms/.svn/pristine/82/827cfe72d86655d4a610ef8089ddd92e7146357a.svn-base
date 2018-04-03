package com.jmjk.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;


import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;

import com.jmjk.dao.HealthEduDao;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.THealthEdu;
import com.jmjk.iservice.IHealthEduService;
import com.jmjk.utils.Page;
import com.jmjk.utils.TypeConverter;
@Controller("healthEduService")
public class HealthEduService implements IHealthEduService{
    
	
	@Autowired
	private HealthEduDao healthEduDao;
	@Autowired
	private CommunityHospitalGroupService communityHospitalGroupService;
	@Override
	public void saveHealthEdu(THealthEdu healthedu) {
		// TODO Auto-generated method stub
		healthEduDao.Save(healthedu);
	}

	@Override
	public void deleteHealthEdu(int healtheduID) {
		// TODO Auto-generated method stub
		String hql="delete from THealthEdu the where the.healthEduId="+healtheduID;
		healthEduDao.delete(hql);
	}

	@Override
	public void updateHealthEdu(THealthEdu healthedu) {
		// TODO Auto-generated method stub
		healthEduDao.update(healthedu);
	}

	@Override
	public List<THealthEdu> getHealthEduListBySearch(int comHosId,
			String searchCondition,String searchText, Date beginTime,
			Date endTime, Page<THealthEdu> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("comHosId", comHosId);
		
		String hql = "from THealthEdu the where the.communityHospitalId = :comHosId";
		if(searchCondition=="负责人" ||searchCondition.equals("负责人") ){
			if(StringUtils.isNotBlank(searchText)){
				params.put("searchText", "%"+searchText+"%");
				hql += " and the.TStaff.name like :searchText";
			}
		}
		if(searchCondition=="组织者" ||searchCondition.equals("组织者")){
			if(StringUtils.isNotBlank(searchText)){
				params.put("searchText", "%"+searchText+"%");
				hql += " and the.organizer like :searchText";
			}
		}
		
		if(beginTime!=null){
			hql += " and DATE_FORMAT(the.activeTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(the.activeTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		hql+=" order by the.activeTime desc";
		List<THealthEdu> list = healthEduDao.find(hql,params,page.getCurrentPage(), page.getPageSize());
		return list;
	}

	@Override
	public long getHealthEduNumBySearch(int comHosId,
			String searchCondition,String searchText, Date beginTime, Date endTime) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("comHosId", comHosId);
		String hql = "select count(*) from THealthEdu the where the.communityHospitalId = :comHosId";
		if(searchCondition=="负责人"||searchCondition.equals("负责人")){
			if(StringUtils.isNotBlank(searchText)){
				params.put("searchText", "%"+searchText+"%");
				hql += " and the.TStaff.name like :searchText ";
			}
		}
		if(searchCondition=="组织者"||searchCondition.equals("组织者")){
			if(StringUtils.isNotBlank(searchText)){
				params.put("searchText", "%"+searchText+"%");
				hql += " and the.organizer like :searchText ";
			}
		}
		
		if(beginTime!=null){
			hql += " and DATE_FORMAT(the.activeTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(the.activeTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		hql+=" order by the.activeTime desc";
		long num = healthEduDao.count(hql,params);
		return num;
	}

	@Override
	public THealthEdu getHealthEduById(int healtheduID) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("healtheduID",healtheduID);
		String hql="from THealthEdu the where the.healthEduId=:healtheduID";
		THealthEdu tHealthEdu=healthEduDao.Get(hql,params);
		return tHealthEdu;
	}

	@Override
	public List<THealthEdu> getHealthEduListByComhosId(int comHosId,
			Page<THealthEdu> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("comHosId", comHosId);
		String hql = "from THealthEdu the where the.communityHospitalId = :comHosId";
		hql+=" order by the.activeTime desc";
		List<THealthEdu> list = healthEduDao.find(hql,params, page.getCurrentPage(), page.getPageSize());
		return list;
	}
	@Override
	public List<THealthEdu> getHealthEduListForSpecial(int staffID,
			Page<THealthEdu> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffID", staffID);
		String hql = "from THealthEdu the where the.TStaff.staffId = :staffID";
		hql+=" order by the.activeTime desc";
		List<THealthEdu> list = healthEduDao.find(hql,params, page.getCurrentPage(), page.getPageSize());
		return list;
	}
	@Override
	public long getHealthEduNumByComhosId(int ComhosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ComhosId", ComhosId);
		String hql="select count(*) from THealthEdu the where the.communityHospitalId=:ComhosId";
		long count=healthEduDao.count(hql,params);
		return count;
	}
	public long getHealthEduNumForSpecial(int staffID) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffID", staffID);
		String hql="select count(*) from THealthEdu the where the.TStaff.staffId = :staffID";
		long count=healthEduDao.count(hql,params);
		return count;
	}
	@Override
	public List<THealthEdu> getHealthEdusListForExport(int comHosId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("comHosId", comHosId); 
		String hql ="from THealthEdu the where the.communityHospitalId =:comHosId";
		hql+=" order by the.activeTime desc";
		List<THealthEdu> list = healthEduDao.find(hql,params);
		return list;
	}
	@Override
	public long getHealSpecialNumBySearch(int staffID, String searchCondition,
			String searchText, Date beginTime, Date endTime) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffID", staffID);
		String hql="select count(*) from THealthEdu the where the.TStaff.staffId = :staffID";
		if(searchCondition=="负责人"||searchCondition.equals("负责人")){
			if(StringUtils.isNotBlank(searchText)){
				params.put("searchText", "%"+searchText+"%");
				hql += " and the.TStaff.name like :searchText ";
			}
		}
		if(searchCondition=="组织者"||searchCondition.equals("组织者")){
			if(StringUtils.isNotBlank(searchText)){
				params.put("searchText", "%"+searchText+"%");
				hql += " and the.organizer like :searchText ";
			}
		}
		
		if(beginTime!=null){
			hql += " and DATE_FORMAT(the.activeTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(the.activeTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		hql+=" order by the.activeTime desc";
		long num = healthEduDao.count(hql,params);
		return num;
	}

	@Override
	public List<THealthEdu> getHealSpecialListBySearch(int staffID,
			String searchCondition, String searchText, Date beginTime,
			Date endTime, Page<THealthEdu> page) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffID", staffID);
		
		String hql = "from THealthEdu the where the.TStaff.staffId = :staffID";
		if(searchCondition=="负责人" ||searchCondition.equals("负责人") ){
			if(StringUtils.isNotBlank(searchText)){
				params.put("searchText", "%"+searchText+"%");
				hql += " and the.TStaff.name like :searchText";
			}
		}
		if(searchCondition=="组织者" ||searchCondition.equals("组织者")){
			if(StringUtils.isNotBlank(searchText)){
				params.put("searchText", "%"+searchText+"%");
				hql += " and the.organizer like :searchText";
			}
		}
		
		if(beginTime!=null){
			hql += " and DATE_FORMAT(the.activeTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(the.activeTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		hql+=" order by the.activeTime desc";
		List<THealthEdu> list = healthEduDao.find(hql,params,page.getCurrentPage(), page.getPageSize());
		return list;
	}
	
	
	@Override
	public List<THealthEdu> getHealthEduListByAll(Page page) {
		String hql = "from THealthEdu th order by th.activeTime desc"; 
		List<THealthEdu> list = healthEduDao.find( hql, page.getCurrentPage(), page.getPageSize());
		return list;
	}
	
	@Override
	public long getHealthEduNumByAll() {
		String hql = "select count(*) from THealthEdu";
		long count = healthEduDao.count(hql);
		return count;
	}

	@Override
	public List<THealthEdu> getHealthEducationListBySearch(
			String searchCondition, String searchText, Date beginTime,
			Date endTime,Page<THealthEdu> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from THealthEdu the where 1=1";
		if(searchCondition=="负责人" ||searchCondition.equals("负责人") ){
			if(StringUtils.isNotBlank(searchText)){
				params.put("searchText", "%"+searchText+"%");
				hql += " and the.TStaff.name like :searchText";
			}
		}
		if(searchCondition=="组织者" ||searchCondition.equals("组织者")){
			if(StringUtils.isNotBlank(searchText)){
				params.put("searchText", "%"+searchText+"%");
				hql += " and the.organizer like :searchText";
			}
		}
		
		if(beginTime!=null){
			hql += " and DATE_FORMAT(the.activeTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(the.activeTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		hql+=" order by the.activeTime desc";
		List<THealthEdu> list;
		try {
			list = healthEduDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
			return list;
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public long getHealthEducationNumBySearch(String searchCondition,
			String searchText, Date beginTime, Date endTime) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " select count(*) from THealthEdu the where 1=1";
		if(searchCondition=="负责人" ||searchCondition.equals("负责人") ){
			if(StringUtils.isNotBlank(searchText)){
				params.put("searchText", "%"+searchText+"%");
				hql += " and the.TStaff.name like :searchText";
			}
		}
		if(searchCondition=="组织者" ||searchCondition.equals("组织者")){
			if(StringUtils.isNotBlank(searchText)){
				params.put("searchText", "%"+searchText+"%");
				hql += " and the.organizer like :searchText";
			}
		}
		
		if(beginTime!=null){
			hql += " and DATE_FORMAT(the.activeTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(the.activeTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		long num = healthEduDao.count(hql,params);
		return num;
	}

	@Override
	public long getHealthEduNumByGroup(TCommunityHospitalGroup comHosGroup) {
		// TODO Auto-generated method stub
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
		String hql="select count(*) from THealthEdu the where the.communityHospitalId in ("+str+")";
		return healthEduDao.count(hql);
	}

	@Override
	public List<THealthEdu> getHealthEduListByGroup(TCommunityHospitalGroup comHosGroup) {
		List<TCommunityHospital> listcomHospitals=new ArrayList<TCommunityHospital>();
		listcomHospitals=communityHospitalGroupService.getComHosListByGroup(comHosGroup);
		List<Object> listcomHosId=new ArrayList<Object>();
		if(listcomHospitals.size()==0)
		    return null; 
		for(int i=0;i<listcomHospitals.size();i++){
			listcomHosId.add(listcomHospitals.get(i).getCommunityHospitalId());
		}  //根据社区医院IDList获得 健康教育数量
		String a = ",";
		String str = TypeConverter.convertList2String(listcomHosId,a);
		String hql="from THealthEdu the where the.communityHospitalId in ("+str+")";
		hql+=" order by the.activeTime desc";
		return healthEduDao.find(hql);
	}

	@Override
	public long getHealthNumGroupBySearch(int comHosGroupId,
			String searchCondition, String searchText, Date beginTime,
			Date endTime) {
		TCommunityHospitalGroup comHosGroup = communityHospitalGroupService.getComHosGroupByGroupId(comHosGroupId);
		List<TCommunityHospital> listcomHospitals=new ArrayList<TCommunityHospital>();
		listcomHospitals=communityHospitalGroupService.getComHosListByGroup(comHosGroup);
		List<Object> listcomHosId=new ArrayList<Object>();
		for(int i=0;i<listcomHospitals.size();i++){
			listcomHosId.add(listcomHospitals.get(i).getCommunityHospitalId());
		}
		String a = ",";
		String str = TypeConverter.convertList2String(listcomHosId,a);
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = "select count(*) from THealthEdu the where the.communityHospitalId in ("+str+")";
		if(searchCondition=="负责人"||searchCondition.equals("负责人")){
			if(StringUtils.isNotBlank(searchText)){
				params.put("searchText", "%"+searchText+"%");
				hql += " and the.TStaff.name like :searchText ";
			}
		}
		if(searchCondition=="组织者"||searchCondition.equals("组织者")){
			if(StringUtils.isNotBlank(searchText)){
				params.put("searchText", "%"+searchText+"%");
				hql += " and the.organizer like :searchText ";
			}
		}
		if(beginTime!=null){
			hql += " and DATE_FORMAT(the.activeTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(the.activeTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		return healthEduDao.count(hql, params);
	}

	@Override
	public List<THealthEdu> getHealListGroupBySearch(int comHosGroupId,
			String searchCondition, String searchText, Date beginTime,
			Date endTime, Page<THealthEdu> page) {

		TCommunityHospitalGroup comHosGroup = communityHospitalGroupService.getComHosGroupByGroupId(comHosGroupId);
		List<TCommunityHospital> listcomHospitals=new ArrayList<TCommunityHospital>();
		listcomHospitals=communityHospitalGroupService.getComHosListByGroup(comHosGroup);
		List<Object> listcomHosId=new ArrayList<Object>();
		for(int i=0;i<listcomHospitals.size();i++){
			listcomHosId.add(listcomHospitals.get(i).getCommunityHospitalId());
		}
		String a = ",";
		String str = TypeConverter.convertList2String(listcomHosId,a);
		String hql="from THealthEdu the where the.communityHospitalId in ("+str+")";
		Map<String, Object> params = new HashMap<String, Object>();
		if(searchCondition=="负责人" ||searchCondition.equals("负责人") ){
			if(StringUtils.isNotBlank(searchText)){
				params.put("searchText", "%"+searchText+"%");
				hql += " and the.TStaff.name like :searchText";
			}
		}
		if(searchCondition=="组织者" ||searchCondition.equals("组织者")){
			if(StringUtils.isNotBlank(searchText)){
				params.put("searchText", "%"+searchText+"%");
				hql += " and the.organizer like :searchText";
			}
		}
		
		if(beginTime!=null){
			hql += " and DATE_FORMAT(the.activeTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(the.activeTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		hql+=" order by the.activeTime desc";
		return healthEduDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}

	

}
