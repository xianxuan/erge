package com.jmjk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.FollowRecordDao;
import com.jmjk.dao.MedicalRecordDao;
import com.jmjk.dao.VMedicalRecordDao;
import com.jmjk.entity.TMedicalRecord;
import com.jmjk.entity.view.VMedicalRecord;
import com.jmjk.iservice.IMedicalRecordService;
import com.jmjk.utils.Page;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.SearchBeanSU;
import com.jmjk.utils.TypeConverter;
@Controller("medicalRecordService")
public class MedicalRecordService implements IMedicalRecordService {
	@Autowired
	private  MedicalRecordDao medicalRecordDao;
	@Autowired
	private  VMedicalRecordDao vMedicalRecordDao;
	public String vc="VMedicalRecord";
	
	
	@Override
	public void saveMedicalRecord(TMedicalRecord medicalrecord) {
		medicalRecordDao.Save(medicalrecord);
	}
	@Override
	public void deleteMedicalRecordByMRId(int mrId) {
		String hql="delete from TMedicalRecord tp where tp.medicalRecordId="+mrId;
		medicalRecordDao.delete(hql);
		
		
	}

	@Override
	public void deleteMedicalRecord(List<Object> deleteList) {
		String str=TypeConverter.convertList2String(deleteList,",");
		String hql="delete from TMedicalRecord tp where tp.medicalRecordId in ("+str+")";
		medicalRecordDao.delete(hql);
		
	}

	@Override
	public void updateMedicalRecord(TMedicalRecord medicalrecord) {
		medicalRecordDao.update(medicalrecord);
		
	}

	@Override
	public TMedicalRecord getMedicalRecordByMRId(int mrId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mrId", mrId);
		String hql="from TMedicalRecord tp where tp.medicalRecordId=:mrId";
		return medicalRecordDao.Get(hql,params);
	}

	@Override
	public long getMedicalRecordCount(int hosId) {
		String hql="select count(tp.medicalRecordId) from VMedicalRecord tp where tp.communityHospitalId="+hosId+" and tp.healthFileType =2";
		return vMedicalRecordDao.count(hql);
	}
	@Override
	public long getMedicalRecordCount() {
		String hql="select count(tp.medicalRecordId) from VMedicalRecord tp where tp.healthFileType =2 ";
		return vMedicalRecordDao.count(hql);
	}
	@Override
	public long getMedicalRecordCountForGroup(int groupId){
		String hql="select count(tp.medicalRecordId) from VMedicalRecord tp where tp.GId="+groupId+" and tp.healthFileType =2";
		return vMedicalRecordDao.count(hql);
	}
	@Override
	public long getMedicalRecordCountForSpecial(int staffId) {
		String hql="select count(tp.medicalRecordId) from VMedicalRecord tp where tp.staffId="+staffId+" and tp.healthFileType =2";
		return vMedicalRecordDao.count(hql);
	}

	@Override
	public List<VMedicalRecord> getAllMedicalRecord(Page<VMedicalRecord> page,
			int hosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		String hql="from VMedicalRecord tp where tp.communityHospitalId=:hosId and tp.healthFileType =2";
		return vMedicalRecordDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VMedicalRecord> getAllMedicalRecord(Page<VMedicalRecord> page) {
		String hql="from VMedicalRecord tp where tp.healthFileType =2";
		return vMedicalRecordDao.find(hql,page.getCurrentPage(),page.getPageSize());
	}
	public List<VMedicalRecord> getAllMedicalRecordForGroup(Page<VMedicalRecord> page,int groupId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupId", groupId);
		String hql="from VMedicalRecord tp where tp.GId=:groupId and tp.healthFileType =2";
		return vMedicalRecordDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VMedicalRecord> getAllMedicalRecordForSpecial(
			Page<VMedicalRecord> page, int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String hql="from VMedicalRecord tp where tp.staffId=:staffId and tp.healthFileType =2";
		return vMedicalRecordDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	/////////////////////////////多条件////////////////////////////
	@Override
	public long findChronicPeopleCount(SearchBeanSU se,int hosId) {
		String h = se.getHql(vc);
		String hql ="select count(entity.medicalRecordId) "+ h +" and entity.communityHospitalId="+hosId ;
		return vMedicalRecordDao.count(hql);
	}

	@Override
	public long findChronicPeopleCount(SearchBeanSU se) {
		String h = se.getHql(vc);
		String hql ="select count(entity.medicalRecordId) "+ h  ;
		return vMedicalRecordDao.count(hql);
	}
	@Override
	public long findChronicPeopleCountForSpecial(SearchBeanSU se,int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String h = se.getHql(vc);
		String hql ="select count(entity.medicalRecordId) "+ h +" and entity.staffId= :staffId order by entity.fileNum desc" ;
		return vMedicalRecordDao.count(hql,params);
	}

	@Override
	public List<VMedicalRecord> findChronicPeople(SearchBeanSU se,
			Page<VMedicalRecord> page, int hosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		String h = se.getHql(vc);
		String hql =h +"and entity.communityHospitalId= :hosId " ;
		return vMedicalRecordDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VMedicalRecord> findChronicPeople(SearchBeanSU se,
			Page<VMedicalRecord> page) {
		
		String h = se.getHql(vc);
		String hql = h +" order by entity.fileNum desc" ;
		return vMedicalRecordDao.find(hql,page.getCurrentPage(),page.getPageSize());
	}

	@Override
	public List<VMedicalRecord> findChronicPeopleForSpecial(SearchBeanSU se,
			Page<VMedicalRecord> page, int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String h = se.getHql(vc);
		String hql =h +"and entity.staffId= :staffId order by entity.fileNum desc" ;
		return vMedicalRecordDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public VMedicalRecord getVMedicalRecord(int medicalRecordId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("medicalRecordId", medicalRecordId);
		String hql="from VMedicalRecord tp where tp.medicalRecordId=:medicalRecordId";
		return vMedicalRecordDao.Get(hql,params);
	}

	@Override
	public List<VMedicalRecord> getAllMedicalRecord(int hosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		String hql ="from VMedicalRecord tp where tp.communityHospitalId=:hosId and tp.healthFileType =2 order by tp.fileNum desc" ;
		return vMedicalRecordDao.find(hql,params);
	}

	@Override
	public List<VMedicalRecord> getAllMedicalRecordForSpecial(
			int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String hql ="from VMedicalRecord tp where tp.staffId=:staffId and tp.healthFileType =2 order by tp.fileNum desc" ;
		return vMedicalRecordDao.find(hql,params);
	}

	@Override
	public List<VMedicalRecord> getAllMedicalRecord() {
		String hql="from VMedicalRecord tp where tp.healthFileType =2 order by tp.fileNum desc";
		return vMedicalRecordDao.find(hql);
	}
	@Override
	public List<VMedicalRecord> getAllMedicalRecordForGroup(int groupId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupId", groupId);
		String hql ="from VMedicalRecord tp where tp.GId=:groupId and tp.healthFileType =2 order by tp.fileNum desc" ;
		return vMedicalRecordDao.find(hql,params);
	}

	


}
