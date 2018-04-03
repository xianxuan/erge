package com.jmjk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.ConsultationRecordDao;
import com.jmjk.dao.FollowRecordDao;
import com.jmjk.dao.VConsultationRecordDao;
import com.jmjk.entity.TConsultationRecord;
import com.jmjk.entity.TFollowRecord;
import com.jmjk.entity.view.VConsultationRecord;
import com.jmjk.iservice.IConsultationRecordService;
import com.jmjk.utils.Page;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.SearchBeanSU;
import com.jmjk.utils.TypeConverter;
@Controller("consultationRecordService")
public class ConsultationRecordService implements IConsultationRecordService {
	@Autowired
	private  ConsultationRecordDao consultationRecordDao;
	@Autowired
	private  VConsultationRecordDao vConsultationRecordDao;
	public String vc="VConsultationRecord";
	
	
	@Override
	public void saveConsultationRecord(TConsultationRecord consultationrecord) {
		consultationRecordDao.Save(consultationrecord);
		
	}

	@Override
	public void deleteConsultationRecordByCRId(int crId) {
		String hql="delete from TConsultationRecord tp where tp.consultationRecordId="+crId;
		consultationRecordDao.delete(hql);
		
	}

	@Override
	public void deleteConsultationRecord(List<Object> deleteList) {
		String str=TypeConverter.convertList2String(deleteList,",");
		String hql="delete from TConsultationRecord tp where tp.consultationRecordId in ("+str+")";
		consultationRecordDao.delete(hql);
		
	}

	@Override
	public void updateConsultationRecord(TConsultationRecord consultationrecord) {
		consultationRecordDao.update(consultationrecord);
		
	}

	@Override
	public TConsultationRecord getConsultationRecordByCRId(int crId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("crId", crId);
		String hql="from TConsultationRecord tp where tp.consultationRecordId=:crId";
		return consultationRecordDao.Get(hql,params);
	}

	

	@Override
	public long getConsultationRecordCount(int hosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		String hql="select count(tp.consultationRecordId) from VConsultationRecord tp where tp.communityHospitalId=:hosId and tp.healthFileType =2 ";
		return vConsultationRecordDao.count(hql,params);
	}

	@Override
	public long getConsultationRecordCount() {
		String hql="select count(tp.consultationRecordId) from VConsultationRecord tp where  tp.healthFileType =2 ";
		return vConsultationRecordDao.count(hql);
	}
	@Override
	public long getConsultationRecordCountForGroup(int groupId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupId", groupId);
		String hql="select count(tp.consultationRecordId) from VConsultationRecord tp where tp.GId=:groupId and tp.healthFileType =2 ";
		return vConsultationRecordDao.count(hql,params);
	}
	@Override
	public long getConsultationRecordCountForSpecial(int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String hql="select count(tp.consultationRecordId) from VConsultationRecord tp where tp.staffId=:staffId and tp.healthFileType =2 ";
		return vConsultationRecordDao.count(hql,params);
	}
	@Override
	public List<VConsultationRecord> getAllConsultationRecord(
			Page<VConsultationRecord> page, int hosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		String hql="from VConsultationRecord tp where tp.communityHospitalId=:hosId and tp.healthFileType =2 order by tp.conRecDate desc";
		return vConsultationRecordDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VConsultationRecord> getAllConsultationRecord(
			Page<VConsultationRecord> page) {
		String hql="from VConsultationRecord tp where tp.healthFileType =2 order by tp.conRecDate desc";
		return vConsultationRecordDao.find(hql,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VConsultationRecord> getAllConsultationRecordForGroup(Page<VConsultationRecord> page,int groupId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupId", groupId);
		String hql="from VConsultationRecord tp where tp.GId=:groupId and tp.healthFileType =2 order by tp.conRecDate desc";
		return vConsultationRecordDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
		
	}
	@Override
	public List<VConsultationRecord> getAllConsultationRecordForSpecial(
			Page<VConsultationRecord> page, int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String hql="from VConsultationRecord tp where tp.staffId=:staffId and tp.healthFileType =2 order by tp.conRecDate desc";
		return vConsultationRecordDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	////////////////////////////////多条件查询//////////////////////////////
	@Override
	public long findChronicPeopleCount(SearchBeanSU se,int hosId) {
		String h = se.getHql(vc);
		String hql ="select count(entity.consultationRecordId) "+ h +" and communityHospitalId="+hosId ;
		return vConsultationRecordDao.count(hql);
	}

	@Override
	public long findChronicPeopleCount(SearchBeanSU se) {
		String h = se.getHql(vc);
		String hql ="select count(entity.consultationRecordId) "+ h  ;
		return vConsultationRecordDao.count(hql);
	}
	@Override
	public long findChronicPeopleCountForSpecial(SearchBeanSU se,int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String h = se.getHql(vc);
		String hql ="select count(entity.consultationRecordId) "+ h +" and entity.staffId= :staffId order by entity.fileNum desc" ;
		return vConsultationRecordDao.count(hql,params);
	}

	@Override
	public List<VConsultationRecord> findChronicPeople(SearchBeanSU se,
			Page<VConsultationRecord> page, int hosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		String h = se.getHql(vc);
		String hql =h +"and entity.communityHospitalId= :hosId order by entity.fileNum desc" ;
		return vConsultationRecordDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VConsultationRecord> findChronicPeople(SearchBeanSU se,
			Page<VConsultationRecord> page) {
		
		String h = se.getHql(vc);
		String hql = h +" order by entity.fileNum desc" ;
		return vConsultationRecordDao.find(hql,page.getCurrentPage(),page.getPageSize());
	}

	@Override
	public List<VConsultationRecord> findChronicPeopleForSpecial(SearchBeanSU se,
			Page<VConsultationRecord> page, int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String h = se.getHql(vc);
		String hql =h +"and entity.staffId= :staffId order by entity.fileNum desc" ;
		return vConsultationRecordDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}

	@Override
	public VConsultationRecord getVConsultationRecord(int consultationRecordId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("consultationRecordId", consultationRecordId);
		String hql="from VConsultationRecord tp where tp.consultationRecordId=:consultationRecordId";
		return vConsultationRecordDao.Get(hql,params);
	}

	@Override
	public List<VConsultationRecord> getAllConsultationRecord(int hosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		String hql ="from VConsultationRecord tp where tp.communityHospitalId=:hosId and tp.healthFileType =2 order by tp.fileNum desc" ;
		return vConsultationRecordDao.find(hql,params);
	}

	@Override
	public List<VConsultationRecord> getAllConsultationRecordForSpecial(
			int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String hql ="from VConsultationRecord tp where tp.staffId=:staffId and tp.healthFileType =2 order by tp.fileNum desc" ;
		return vConsultationRecordDao.find(hql,params);
	}
	@Override
	public List<VConsultationRecord> getAllConsultationRecordForGroup(int groupId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupId", groupId);
		String hql ="from VConsultationRecord tp where tp.GId=:groupId and tp.healthFileType =2 order by tp.fileNum desc" ;
		return vConsultationRecordDao.find(hql,params);
	}
	@Override
	public List<VConsultationRecord> getAllConsultationRecord() {
		String hql="from VConsultationRecord tp where tp.healthFileType =2 order by tp.fileNum desc";
		return vConsultationRecordDao.find(hql);
	}

	
}
