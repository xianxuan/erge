package com.jmjk.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.FollowRecordDao;
import com.jmjk.dao.InHospitalHistoryDao;
import com.jmjk.dao.VInHospitalHistoryDao;
import com.jmjk.entity.TInHospitalHistory;
import com.jmjk.entity.view.VInHospitalHistory;
import com.jmjk.iservice.IInHospitalHistoryService;
import com.jmjk.utils.Page;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.SearchBeanSU;
import com.jmjk.utils.TypeConverter;
@Controller("inHospitalHistoryService")
public class InHospitalHistoryService implements IInHospitalHistoryService{
	@Autowired
	private  InHospitalHistoryDao inHospitalHistoryDao;
	@Autowired
	private  VInHospitalHistoryDao vInHospitalHistoryDao;
	public String vc="VInHospitalHistory";
	
	@Override
	public void saveInHospitalHistory(TInHospitalHistory inhospitalhistory) {
		inHospitalHistoryDao.Save(inhospitalhistory);
		
	}

	@Override
	public void deleteInHospitalHistoryByIHHId(int ihhId) {
		String hql="delete from TInHospitalHistory tp where tp.inHospitalHistoryId="+ihhId;
		inHospitalHistoryDao.delete(hql);
		
	}

	@Override
	public void deleteDRRecord(List<Object> deleteList) {
		String str=TypeConverter.convertList2String(deleteList,",");
		String hql="delete from TInHospitalHistory tp where tp.inHospitalHistoryId in ("+str+")";
		inHospitalHistoryDao.delete(hql);
		
	}

	@Override
	public void updateInHospitalHistory(TInHospitalHistory inhospitalhistory) {
		inHospitalHistoryDao.update(inhospitalhistory);
		
		
	}
	@Override
	public TInHospitalHistory getInHospitalHistoryByIHHId(int ihhId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ihhId", ihhId);
		String hql="from TInHospitalHistory tp where tp.inHospitalHistoryId=:ihhId";
		return inHospitalHistoryDao.Get(hql,params);
	}

	

	@Override
	public long getInHospitalHistoryCount(int hosId) {
		String hql="select count(tp.inHospitalHistoryId) from VInHospitalHistory tp where tp.communityHospitalId="+hosId+" and tp.healthFileType =2";
		return vInHospitalHistoryDao.count(hql);
	}

	@Override
	public long getInHospitalHistoryCount() {
		String hql="select count(tp.inHospitalHistoryId) from VInHospitalHistory tp where tp.healthFileType =2";
		return vInHospitalHistoryDao.count(hql);
	}
	@Override
	public long getInHospitalHistoryCountForGroup(int groupId){
		String hql="select count(tp.inHospitalHistoryId) from VInHospitalHistory tp where tp.GId="+groupId+" and tp.healthFileType =2";
		return vInHospitalHistoryDao.count(hql);
	}
	@Override
	public long getInHospitalHistoryCountForSpecial(int staffId) {
		String hql="select count(tp.inHospitalHistoryId) from VInHospitalHistory tp where tp.staffId="+staffId+" and tp.healthFileType =2";
		return vInHospitalHistoryDao.count(hql);
	}

	@Override
	public List<VInHospitalHistory> getAllInHospitalHistory(
			Page<VInHospitalHistory> page) {
		String hql="from VInHospitalHistory tp where  tp.healthFileType =2";
		return vInHospitalHistoryDao.find(hql,page.getCurrentPage(),page.getPageSize());
	}
	public List<VInHospitalHistory> getAllInHospitalHistoryForGroup(Page<VInHospitalHistory> page,int groupId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupId", groupId);
		String hql="from VInHospitalHistory tp where tp.GId=:groupId and  tp.healthFileType =2";
		return vInHospitalHistoryDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VInHospitalHistory> getAllInHospitalHistory(
			Page<VInHospitalHistory> page, int hosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		String hql="from VInHospitalHistory tp where tp.communityHospitalId=:hosId and  tp.healthFileType =2";
		return vInHospitalHistoryDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VInHospitalHistory> getAllInHospitalHistoryForSpecial(
			Page<VInHospitalHistory> page, int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String hql="from VInHospitalHistory tp where tp.staffId=:staffId and tp.healthFileType =2";
		return vInHospitalHistoryDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
////////////////////////////多条件///////////////////////////////////////////
	@Override
	public long findChronicPeopleCount(SearchBeanSU se,int hosId) {
		String h = se.getHql(vc);
		String hql ="select count(entity.inHospitalHistoryId) "+ h +" and communityHospitalId="+hosId ;
		return vInHospitalHistoryDao.count(hql);
	}

	@Override
	public long findChronicPeopleCount(SearchBeanSU se) {
		String h = se.getHql(vc);
		String hql ="select count(entity.inHospitalHistoryId) "+ h  ;
		return vInHospitalHistoryDao.count(hql);
	}
	@Override
	public long findChronicPeopleCountForSpecial(SearchBeanSU se,int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String h = se.getHql(vc);
		String hql ="select count(entity.inHospitalHistoryId) "+ h +" and entity.staffId= :staffId " ;
		return vInHospitalHistoryDao.count(hql,params);
	}

	@Override
	public List<VInHospitalHistory> findChronicPeople(SearchBeanSU se,
			Page<VInHospitalHistory> page, int hosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		String h = se.getHql(vc);
		String hql =h +"and entity.communityHospitalId= :hosId order by entity.fileNum desc" ;
		return vInHospitalHistoryDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VInHospitalHistory> findChronicPeople(SearchBeanSU se,
			Page<VInHospitalHistory> page) {
		
		String h = se.getHql(vc);
		String hql = h +" order by entity.fileNum desc" ;
		return vInHospitalHistoryDao.find(hql,page.getCurrentPage(),page.getPageSize());
	}

	@Override
	public List<VInHospitalHistory> findChronicPeopleForSpecial(SearchBeanSU se,
			Page<VInHospitalHistory> page, int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String h = se.getHql(vc);
		String hql =h +"and entity.staffId= :staffId order by entity.fileNum desc" ;
		return vInHospitalHistoryDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public VInHospitalHistory getVInHospitalHistory(int inHospitalHistoryId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("inHospitalHistoryId", inHospitalHistoryId);
		String hql="from VInHospitalHistory tp where tp.inHospitalHistoryId=:inHospitalHistoryId";
		return vInHospitalHistoryDao.Get(hql,params);
	}
	@Override
	public List<VInHospitalHistory> getAllInHospitalHistory(int hosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		String hql ="from VInHospitalHistory tp where tp.communityHospitalId=:hosId and tp.healthFileType =2 order by tp.fileNum desc" ;
		return vInHospitalHistoryDao.find(hql,params);
	}
	@Override
	public List<VInHospitalHistory> getAllInHospitalHistoryForSpecial(
			int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String hql ="from VInHospitalHistory tp where tp.staffId=:staffId and tp.healthFileType =2 order by tp.fileNum desc" ;
		return vInHospitalHistoryDao.find(hql,params);
	}

	@Override
	public List<VInHospitalHistory> getAllInHospitalHistory() {
		String hql="from VInHospitalHistory tp where tp.healthFileType =2 order by tp.fileNum desc";
		return vInHospitalHistoryDao.find(hql);
	}

	@Override
	public List<VInHospitalHistory> getAllInHospitalHistoryForGroup(int groupId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupId", groupId);
		String hql ="from VInHospitalHistory tp where tp.GId=:groupId and tp.healthFileType =2 order by tp.fileNum desc" ;
		return vInHospitalHistoryDao.find(hql,params);
	}

	

}
