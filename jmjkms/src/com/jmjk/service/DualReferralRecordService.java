package com.jmjk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.DualReferralRecordDao;
import com.jmjk.dao.FollowRecordDao;
import com.jmjk.dao.VDualReferralRecordDao;
import com.jmjk.entity.TDualReferralRecord;
import com.jmjk.entity.view.VDualReferralRecord;
import com.jmjk.iservice.IDualReferralRecordService;
import com.jmjk.utils.Page;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.SearchBeanSU;
import com.jmjk.utils.TypeConverter;
@Controller("dualReferralRecordService")
public class DualReferralRecordService implements IDualReferralRecordService {
	@Autowired
	private  DualReferralRecordDao dualReferralRecordDao;
	@Autowired
	private  VDualReferralRecordDao vDualReferralRecordDao;
	public String vc="VDualReferralRecord";
	
	
	@Override
	public void saveDRRecord(TDualReferralRecord drrecord) {
		dualReferralRecordDao.Save(drrecord);
		
	}

	@Override
	public void deleteDRRecordByDRRId(int drrId) {
		String hql="delete from TDualReferralRecord tp where tp.dualRefRecId="+drrId;
		dualReferralRecordDao.delete(hql);
		
	}

	@Override
	public void deleteDRRecord(List<Object> deleteList) {
		String str=TypeConverter.convertList2String(deleteList,",");
		String hql="delete from TDualReferralRecord tp where tp.dualRefRecId in ("+str+")";
		dualReferralRecordDao.delete(hql);
		
	}

	@Override
	public void updateDRRecord(TDualReferralRecord drrecord) {
		dualReferralRecordDao.update(drrecord);
		
	}

	@Override
	public TDualReferralRecord getDRRecordByDRRId(int drrId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("drrId", drrId);
		String hql="from TDualReferralRecord tp where tp.dualRefRecId=:drrId";
		return dualReferralRecordDao.Get(hql,params);
	}

	

	@Override
	public long getDualReferralRecordCount(int hosId) {
		String hql="select count(tp.dualRefRecId) from VDualReferralRecord tp where tp.communityHospitalId="+hosId +"and tp.healthFileType =2";
		return vDualReferralRecordDao.count(hql);
	}

	@Override
	public long getDualReferralRecordCount() {
		String hql="select count(tp.dualRefRecId) from VDualReferralRecord tp where tp.healthFileType =2";
		return vDualReferralRecordDao.count(hql);
	}
	@Override
	public long getDualReferralRecordCountForGroup(int groupId){
		String hql="select count(tp.dualRefRecId) from VDualReferralRecord tp where tp.GId="+groupId +"and tp.healthFileType =2";
		return vDualReferralRecordDao.count(hql);
	}
	@Override
	public long getDualReferralRecordCountForSpecial(int staffId) {
		String hql="select count(tp.dualRefRecId) from VDualReferralRecord tp where tp.staffId="+staffId+"and tp.healthFileType =2";
		return vDualReferralRecordDao.count(hql);
	}
	@Override
	public List<VDualReferralRecord> getAllDRRecord(
			Page<VDualReferralRecord> page, int hosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		String hql="from  VDualReferralRecord tp where tp.communityHospitalId=:hosId and tp.healthFileType =2";
		return vDualReferralRecordDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VDualReferralRecord> getAllDRRecord(
			Page<VDualReferralRecord> page) {
		String hql="from  VDualReferralRecord tp where tp.healthFileType =2";
		return vDualReferralRecordDao.find(hql,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VDualReferralRecord> getAllDRRecordForGroup(Page<VDualReferralRecord> page,int groupId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupId", groupId);
		String hql="from  VDualReferralRecord tp where tp.GId=:groupId and tp.healthFileType =2";
		return vDualReferralRecordDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VDualReferralRecord> getAllDRRecordForSpecial(
			Page<VDualReferralRecord> page, int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String hql="from  VDualReferralRecord tp where tp.staffId=:staffId and tp.healthFileType =2";
		return vDualReferralRecordDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
////////////////////////////多条件//////////////////////////////////
	@Override
	public long findChronicPeopleCount(SearchBeanSU se,int hosId) {
		String h = se.getHql(vc);
		String hql ="select count(entity.dualRefRecId) "+ h +" and communityHospitalId="+hosId ;
		return vDualReferralRecordDao.count(hql);
	}

	@Override
	public long findChronicPeopleCount(SearchBeanSU se) {
		String h = se.getHql(vc);
		String hql ="select count(entity.dualRefRecId) "+ h  ;
		return vDualReferralRecordDao.count(hql);
	}
	@Override
	public long findChronicPeopleCountForSpecial(SearchBeanSU se,int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String h = se.getHql(vc);
		String hql ="select count(entity.dualRefRecId) "+ h +" and entity.staffId= :staffId order by entity.fileNum desc" ;
		return vDualReferralRecordDao.count(hql,params);
	}

	@Override
	public List<VDualReferralRecord> findChronicPeople(SearchBeanSU se,
			Page<VDualReferralRecord> page, int hosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		String h = se.getHql(vc);
		String hql =h +"and entity.communityHospitalId= :hosId order by entity.fileNum desc" ;
		return vDualReferralRecordDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VDualReferralRecord> findChronicPeople(SearchBeanSU se,
			Page<VDualReferralRecord> page) {
		
		String h = se.getHql(vc);
		String hql = h +" order by entity.fileNum desc" ;
		return vDualReferralRecordDao.find(hql,page.getCurrentPage(),page.getPageSize());
	}

	@Override
	public List<VDualReferralRecord> findChronicPeopleForSpecial(SearchBeanSU se,
			Page<VDualReferralRecord> page, int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String h = se.getHql(vc);
		String hql =h +"and entity.staffId= :staffId order by entity.fileNum desc" ;
		return vDualReferralRecordDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}

	@Override
	public VDualReferralRecord getVDualReferralRecord(int dualRefRecId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("dualRefRecId", dualRefRecId);
		String hql="from VDualReferralRecord tp where tp.dualRefRecId=:dualRefRecId";
		return vDualReferralRecordDao.Get(hql,params);
	}
	@Override
	public List<VDualReferralRecord> getAllDualReferralRecord(int hosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		String hql ="from VDualReferralRecord tp where tp.communityHospitalId=:hosId and tp.healthFileType =2 order by tp.fileNum desc" ;
		return vDualReferralRecordDao.find(hql,params);
	}

	@Override
	public List<VDualReferralRecord> getAllDualReferralRecordForSpecial(
			int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String hql ="from VDualReferralRecord tp where tp.staffId=:staffId and tp.healthFileType =2 order by tp.fileNum desc" ;
		return vDualReferralRecordDao.find(hql,params);
	}
	@Override
	public List<VDualReferralRecord> getAllDualReferralRecordForGroup(int groupId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupId", groupId);
		String hql ="from VDualReferralRecord tp where tp.GId=:groupId and tp.healthFileType =2 order by tp.fileNum desc" ;
		return vDualReferralRecordDao.find(hql,params);
	}
	@Override
	public List<VDualReferralRecord> getAllDualReferralRecord() {
		String hql="from VDualReferralRecord tp where tp.healthFileType =2 order by tp.fileNum desc";
		return vDualReferralRecordDao.find(hql);
	}

}
