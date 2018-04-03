package com.jmjk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.FollowRecordDao;
import com.jmjk.dao.IncompleteRecordDao;
import com.jmjk.dao.VIncompleteRecordDao;
import com.jmjk.entity.TIncompleteRecord;
import com.jmjk.entity.view.VIncompleteRecord;
import com.jmjk.iservice.IIncompleteRecordService;
import com.jmjk.utils.Page;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.SearchBeanSU;
import com.jmjk.utils.TypeConverter;
@Controller("incompleteRecordService")
public class IncompleteRecordService implements IIncompleteRecordService {
	@Autowired
	private  IncompleteRecordDao incompleteRecordDao;
	@Autowired
	private VIncompleteRecordDao vIncompleteRecordDao;
	public String vc="VIncompleteRecord";
	
	@Override
	public void saveIncompleteRecord(TIncompleteRecord incompleterecord) {
		incompleteRecordDao.Save(incompleterecord);
		
	}

	@Override
	public void deleteIncompleteRecordByIRd(int irId) {
		String hql="delete from TIncompleteRecord tp where tp.incompleteRecordId="+irId;
		incompleteRecordDao.delete(hql);
		
	}

	@Override
	public void deleteIncompleteRecord(List<Object> deleteList) {
		String str=TypeConverter.convertList2String(deleteList,",");
		String hql="delete from TIncompleteRecord tp where tp.incompleteRecordId in ("+str+")";
		incompleteRecordDao.delete(hql);
		
	}

	@Override
	public void updateIncompleteRecord(TIncompleteRecord incompleterecord) {
		incompleteRecordDao.update(incompleterecord);
		
	}

	@Override
	public TIncompleteRecord getIncompleteRecordByIRId(int irId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("irId", irId);
		String hql="from TIncompleteRecord tp where tp.incompleteRecordId= :irId";
		return incompleteRecordDao.Get(hql,params);
	}

	

	@Override
	public long getIncompleteRecordCount(int hosId) {
		String hql="select count(tp.incompleteRecordId) from VIncompleteRecord tp where tp.communityHospitalId="+hosId+"and tp.healthFileType =2";
		return vIncompleteRecordDao.count(hql);
	}

	@Override
	public long getIncompleteRecordCount() {
		String hql="select count(tp.incompleteRecordId) from VIncompleteRecord tp where tp.healthFileType =2";
		return vIncompleteRecordDao.count(hql);
	}
	public long getIncompleteRecordCountForGroup(int groupId) {
		String hql="select count(tp.incompleteRecordId) from VIncompleteRecord tp where tp.GId="+groupId+"and tp.healthFileType =2";
		return vIncompleteRecordDao.count(hql);
	}
	@Override
	public long getIncompleteRecordCountForSpecial(int staffId) {
		String hql="select count(tp.incompleteRecordId) from VIncompleteRecord tp where tp.staffId="+staffId+"and tp.healthFileType =2";
		return vIncompleteRecordDao.count(hql);
	}
	@Override
	public List<VIncompleteRecord> getAllIncompleteRecord(
			Page<VIncompleteRecord> page, int hosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		String hql="from  VIncompleteRecord tp where tp.communityHospitalId=:hosId and tp.healthFileType =2 order by tp.incompleteRecordDate desc";
		return vIncompleteRecordDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VIncompleteRecord> getAllIncompleteRecord(
			Page<VIncompleteRecord> page) {
		String hql="from  VIncompleteRecord tp where tp.healthFileType =2 order by tp.incompleteRecordDate desc";
		return vIncompleteRecordDao.find(hql,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VIncompleteRecord> getAllIncompleteRecordForGroup(Page<VIncompleteRecord> page,int groupId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupId", groupId);
		String hql="from  VIncompleteRecord tp where tp.GId=:groupId and tp.healthFileType =2 order by tp.incompleteRecordDate desc";
		return vIncompleteRecordDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VIncompleteRecord> getAllIncompleteRecordForSpecial(
			Page<VIncompleteRecord> page, int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String hql="from  VIncompleteRecord tp where tp.staffId=:staffId and tp.healthFileType =2 order by tp.incompleteRecordDate desc";
		return vIncompleteRecordDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
////////////////////////////////多条件查询////////////////////////////////////////////
	@Override
	public long findChronicPeopleCount(SearchBeanSU se,int hosId) {
		String h = se.getHql(vc);
		String hql ="select count(entity.incompleteRecordId) "+ h +" and communityHospitalId="+hosId ;
		return vIncompleteRecordDao.count(hql);
	}

	@Override
	public long findChronicPeopleCount(SearchBeanSU se) {
		String h = se.getHql(vc);
		String hql ="select count(entity.incompleteRecordId) "+ h  ;
		return vIncompleteRecordDao.count(hql);
	}
	@Override
	public long findChronicPeopleCountForSpecial(SearchBeanSU se,int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String h = se.getHql(vc);
		String hql ="select count(entity.incompleteRecordId) "+ h +" and entity.staffId= :staffId order by entity.fileNum desc" ;
		return vIncompleteRecordDao.count(hql,params);
	}

	@Override
	public List<VIncompleteRecord> findChronicPeople(SearchBeanSU se,
			Page<VIncompleteRecord> page, int hosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		String h = se.getHql(vc);
		String hql =h +"and entity.communityHospitalId= :hosId order by entity.fileNum desc" ;
		return vIncompleteRecordDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VIncompleteRecord> findChronicPeople(SearchBeanSU se,
			Page<VIncompleteRecord> page) {
		
		String h = se.getHql(vc);
		String hql = h +" order by entity.fileNum desc" ;
		return vIncompleteRecordDao.find(hql,page.getCurrentPage(),page.getPageSize());
	}

	@Override
	public List<VIncompleteRecord> findChronicPeopleForSpecial(SearchBeanSU se,
			Page<VIncompleteRecord> page, int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String h = se.getHql(vc);
		String hql =h +"and entity.staffId= :staffId order by entity.fileNum desc" ;
		return vIncompleteRecordDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public VIncompleteRecord getVIncompleteRecord(int IncompleteRecordId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("IncompleteRecordId", IncompleteRecordId);
		String hql="from VIncompleteRecord tp where tp.incompleteRecordId=:IncompleteRecordId";
		return vIncompleteRecordDao.Get(hql,params);
	}
@Override
	public List<VIncompleteRecord> getAllIncompleteRecord(int hosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		String hql ="from VIncompleteRecord tp where tp.communityHospitalId=:hosId and tp.healthFileType =2 order by tp.fileNum desc" ;
		return vIncompleteRecordDao.find(hql,params);
	}

	@Override
	public List<VIncompleteRecord> getAllIncompleteRecordForSpecial(
			int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String hql ="from VIncompleteRecord tp where tp.staffId=:staffId and tp.healthFileType =2 order by tp.fileNum desc" ;
		return vIncompleteRecordDao.find(hql,params);
	}

	@Override
	public List<VIncompleteRecord> getAllIncompleteRecord() {
		String hql="from VIncompleteRecord tp where tp.healthFileType =2 order by tp.fileNum desc";
		return vIncompleteRecordDao.find(hql);
	}

	@Override
	public List<VIncompleteRecord> getAllIncompleteRecordForGroup(int groupId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupId", groupId);
		String hql ="from VIncompleteRecord tp where tp.GId=:groupId and tp.healthFileType =2 order by tp.fileNum desc" ;
		return vIncompleteRecordDao.find(hql,params);
	}


}
