package com.jmjk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.FamilyBedHistoryDao;
import com.jmjk.dao.FollowRecordDao;
import com.jmjk.dao.VFamilyBedHistoryDao;
import com.jmjk.entity.TFamilyBedHistory;
import com.jmjk.entity.view.VFamilyBedHistory;
import com.jmjk.iservice.IFamilyBedHistoryService;
import com.jmjk.utils.Page;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.SearchBeanSU;
import com.jmjk.utils.TypeConverter;
@Controller("familyBedHistoryService")
public class FamilyBedHistoryService implements IFamilyBedHistoryService{
	@Autowired
	private  FamilyBedHistoryDao familyBedHistoryDao;
	@Autowired
	private  VFamilyBedHistoryDao vFamilyBedHistoryDao;
	public String vc="VFamilyBedHistory";
	
	
	@Override
	public void saveFamilyBedHistory(TFamilyBedHistory familybedhistory) {
		familyBedHistoryDao.Save(familybedhistory);
		
	}

	@Override
	public void deleteFamilyBedHistory(List<Object> deleteList) {
		String str=TypeConverter.convertList2String(deleteList,",");
		String hql="delete from TFamilyBedHistory tp where tp.familyBedHistoryId in ("+str+")";
		familyBedHistoryDao.delete(hql);
		
	}

	@Override
	public void deleteFamilyBedHistoryByFBHId(int fbhId) {
		String hql="delete from TFamilyBedHistory tp where tp.familyBedHistoryId="+fbhId;
		familyBedHistoryDao.delete(hql);
		
	}

	@Override
	public void updateFamilyBedHistory(TFamilyBedHistory familybedhistory) {
		familyBedHistoryDao.update(familybedhistory);
		
	}

	@Override
	public TFamilyBedHistory getFamilyBedHistoryByFBHId(int fbhId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fbhId", fbhId);
		String hql="from TFamilyBedHistory tp where tp.familyBedHistoryId=:fbhId";
		return familyBedHistoryDao.Get(hql,params);
	}

	

	@Override
	public long getFamilyBedHistoryCount(int hosId) {
		String hql="select count(tp.familyBedHistoryId) from VFamilyBedHistory tp where tp.communityHospitalId="+hosId+"and tp.healthFileType =2 ";
		return vFamilyBedHistoryDao.count(hql);
	}

	@Override
	public long getFamilyBedHistoryCount() {
		String hql="select count(tp.familyBedHistoryId) from VFamilyBedHistory tp where tp.healthFileType =2 ";
		return vFamilyBedHistoryDao.count(hql);
	}
	@Override
	public long getFamilyBedHistoryCountForGroup(int groupId){
		String hql="select count(tp.familyBedHistoryId) from VFamilyBedHistory tp where tp.GId="+groupId+"and tp.healthFileType =2 ";
		return vFamilyBedHistoryDao.count(hql);
	}
	@Override
	public long getFamilyBedHistoryCountForSpecial(int staffId) {
		String hql="select count(tp.familyBedHistoryId) from VFamilyBedHistory tp where tp.staffId="+staffId+" and tp.healthFileType =2 ";
		return vFamilyBedHistoryDao.count(hql);
	}
	@Override
	public List<VFamilyBedHistory> getAllFamilyBedHistory(
			Page<VFamilyBedHistory> page, int hosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		String hql="from VFamilyBedHistory tp where tp.communityHospitalId=:hosId and tp.healthFileType =2 ";
		return vFamilyBedHistoryDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VFamilyBedHistory> getAllFamilyBedHistory(
			Page<VFamilyBedHistory> page) {
		String hql="from VFamilyBedHistory tp where tp.healthFileType =2  ";
		return vFamilyBedHistoryDao.find(hql,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VFamilyBedHistory> getAllFamilyBedHistoryForGroup(Page<VFamilyBedHistory> page,int groupId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupId", groupId);
		String hql="from VFamilyBedHistory tp where tp.GId=:groupId and tp.healthFileType =2 ";
		return vFamilyBedHistoryDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VFamilyBedHistory> getAllFamilyBedHistoryForSpecial(
			Page<VFamilyBedHistory> page, int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String hql="from VFamilyBedHistory tp where tp.staffId=:staffId and tp.healthFileType =2 ";
		return vFamilyBedHistoryDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
//////////////////////////多条件/////////////////////////////////////////////////
	@Override
	public long findChronicPeopleCount(SearchBeanSU se,int hosId) {
		String h = se.getHql(vc);
		String hql ="select count(entity.familyBedHistoryId) "+ h +" and communityHospitalId="+hosId ;
		return vFamilyBedHistoryDao.count(hql);
	}

	@Override
	public long findChronicPeopleCount(SearchBeanSU se) {
		String h = se.getHql(vc);
		String hql ="select count(entity.familyBedHistoryId) "+ h  ;
		return vFamilyBedHistoryDao.count(hql);
	}
	@Override
	public long findChronicPeopleCountForSpecial(SearchBeanSU se,int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String h = se.getHql(vc);
		String hql ="select count(entity.familyBedHistoryId) "+ h +" and entity.staffId= :staffId order by entity.fileNum desc" ;
		return vFamilyBedHistoryDao.count(hql,params);
	}

	@Override
	public List<VFamilyBedHistory> findChronicPeople(SearchBeanSU se,
			Page<VFamilyBedHistory> page, int hosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		String h = se.getHql(vc);
		String hql =h +"and entity.communityHospitalId= :hosId order by entity.fileNum desc" ;
		return vFamilyBedHistoryDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VFamilyBedHistory> findChronicPeople(SearchBeanSU se,
			Page<VFamilyBedHistory> page) {
		
		String h = se.getHql(vc);
		String hql = h +" order by entity.fileNum desc" ;
		return vFamilyBedHistoryDao.find(hql,page.getCurrentPage(),page.getPageSize());
	}

	@Override
	public List<VFamilyBedHistory> findChronicPeopleForSpecial(SearchBeanSU se,
			Page<VFamilyBedHistory> page, int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String h = se.getHql(vc);
		String hql =h +"and entity.staffId= :staffId order by entity.fileNum desc" ;
		return vFamilyBedHistoryDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}

	@Override
	public VFamilyBedHistory getVFamilyBedHistory(int familyBedHistoryId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("familyBedHistoryId", familyBedHistoryId);
		String hql="from VFamilyBedHistory tp where tp.familyBedHistoryId=:familyBedHistoryId";
		return vFamilyBedHistoryDao.Get(hql,params);
	}
	@Override
	public List<VFamilyBedHistory> getAllFamilyBedHistory(int hosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		String hql ="from VFamilyBedHistory tp where tp.communityHospitalId=:hosId and tp.healthFileType =2 order by tp.fileNum desc" ;
		return vFamilyBedHistoryDao.find(hql,params);
	}

	@Override
	public List<VFamilyBedHistory> getAllFamilyBedHistoryForSpecial(
			int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String hql ="from VFamilyBedHistory tp where tp.staffId=:staffId and tp.healthFileType =2 order by tp.fileNum desc" ;
		return vFamilyBedHistoryDao.find(hql,params);
	}
	@Override
	public List<VFamilyBedHistory> getAllFamilyBedHistoryForGroup(int groupId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupId", groupId);
		String hql ="from VFamilyBedHistory tp where tp.GId=:groupId and tp.healthFileType =2 order by tp.fileNum desc" ;
		return vFamilyBedHistoryDao.find(hql,params);
	}
	@Override
	public List<VFamilyBedHistory> getAllFamilyBedHistory() {
		String hql="from VFamilyBedHistory tp where tp.healthFileType =2 order by tp.fileNum desc";
		return vFamilyBedHistoryDao.find(hql);
	}

}
