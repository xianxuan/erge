package com.jmjk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.FollowRecordDao;
import com.jmjk.dao.IncompleteRecordDao2;
import com.jmjk.dao.VIncompleteRecordDao2;
import com.jmjk.entity.TIncompleteRecord;
import com.jmjk.entity.TIncompleteRecord2;
import com.jmjk.entity.view.VIncompleteRecord2;
import com.jmjk.iservice.IIncompleteRecordService;
import com.jmjk.iservice.IIncompleteRecordService2;
import com.jmjk.utils.Page;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.SearchBeanSU;
import com.jmjk.utils.TypeConverter;
@Controller("incompleteRecordService2")
public class IncompleteRecordService2 implements IIncompleteRecordService2 {
	@Autowired
	private  IncompleteRecordDao2 incompleteRecordDao2;
	@Autowired
	private VIncompleteRecordDao2 vIncompleteRecordDao2;
	public String vc="VIncompleteRecord2";
	
	@Override
	public void saveIncompleteRecord(TIncompleteRecord2 incompleterecord) {
		incompleteRecordDao2.Save(incompleterecord);
		
	}

	@Override
	public void deleteIncompleteRecordByIRd(int irId) {
		String hql="delete from TIncompleteRecord2 tp where tp.incompleteRecordId="+irId;
		incompleteRecordDao2.delete(hql);
		
	}

	@Override
	public void deleteIncompleteRecord(List<Object> deleteList) {
		String str=TypeConverter.convertList2String(deleteList,",");
		String hql="delete from TIncompleteRecord2 tp where tp.incompleteRecordId in ("+str+")";
		incompleteRecordDao2.delete(hql);
		
	}

	@Override
	public void updateIncompleteRecord(TIncompleteRecord2 incompleterecord) {
		incompleteRecordDao2.update(incompleterecord);
		
	}

	@Override
	public TIncompleteRecord2 getIncompleteRecordByIRId(int irId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("irId", irId);
		String hql=" from TIncompleteRecord2 tp where tp.incompleteRecordId= :irId";
		return incompleteRecordDao2.Get(hql,params);
	}

	

	@Override
	public long getIncompleteRecordCount(int hosId) {
		String hql="select count(tp.incompleteRecordId) from VIncompleteRecord2 tp where tp.communityHospitalId="+hosId+" and tp.healthFileType =2";
		return vIncompleteRecordDao2.count(hql);
	}

	@Override
	public long getIncompleteRecordCount() {
		String hql="select count(tp.incompleteRecordId) from VIncompleteRecord2 tp where tp.healthFileType =2";
		return vIncompleteRecordDao2.count(hql);
	}
	public long getIncompleteRecordCountForGroup(int groupId) {
		String hql=" select count(tp.incompleteRecordId) from VIncompleteRecord2 tp where tp.GId="+groupId+" and tp.healthFileType =2";
		return vIncompleteRecordDao2.count(hql);
	}
	@Override
	public long getIncompleteRecordCountForSpecial(int staffId) {
		String hql=" select count(tp.incompleteRecordId) from VIncompleteRecord2 tp where tp.staffId="+staffId+" and tp.healthFileType =2";
		return vIncompleteRecordDao2.count(hql);
	}
	@Override
	public List<VIncompleteRecord2> getAllIncompleteRecord(
			Page<VIncompleteRecord2> page, int hosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		String hql=" from  VIncompleteRecord2 tp where tp.communityHospitalId=:hosId and tp.healthFileType =2 order by tp.incompleteRecordDate desc";
		return vIncompleteRecordDao2.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VIncompleteRecord2> getAllIncompleteRecord(
			Page<VIncompleteRecord2> page) {
		String hql=" from  VIncompleteRecord2 tp where tp.healthFileType =2 order by tp.incompleteRecordDate desc";
		return vIncompleteRecordDao2.find(hql,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VIncompleteRecord2> getAllIncompleteRecordForGroup(Page<VIncompleteRecord2> page,int groupId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupId", groupId);
		String hql=" from  VIncompleteRecord2 tp where tp.GId=:groupId and tp.healthFileType =2 order by tp.incompleteRecordDate desc";
		return vIncompleteRecordDao2.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VIncompleteRecord2> getAllIncompleteRecordForSpecial(
			Page<VIncompleteRecord2> page, int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String hql=" from  VIncompleteRecord2 tp where tp.staffId=:staffId and tp.healthFileType =2 order by tp.incompleteRecordDate desc";
		return vIncompleteRecordDao2.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
////////////////////////////////多条件查询////////////////////////////////////////////
	@Override
	public long findChronicPeopleCount(SearchBeanSU se,int hosId) {
		String h = se.getHql(vc);
		String hql ="select count(entity.incompleteRecordId) "+ h +" and communityHospitalId="+hosId ;
		return vIncompleteRecordDao2.count(hql);
	}

	@Override
	public long findChronicPeopleCount(SearchBeanSU se) {
		String h = se.getHql(vc);
		String hql ="select count(entity.incompleteRecordId) "+ h  ;
		return vIncompleteRecordDao2.count(hql);
	}
	@Override
	public long findChronicPeopleCountForSpecial(SearchBeanSU se,int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String h = se.getHql(vc);
		String hql =" select count(entity.incompleteRecordId) "+ h +" and entity.staffId= :staffId order by entity.fileNum desc" ;
		return vIncompleteRecordDao2.count(hql,params);
	}

	@Override
	public List<VIncompleteRecord2> findChronicPeople(SearchBeanSU se,
			Page<VIncompleteRecord2> page, int hosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		String h = se.getHql(vc);
		String hql =h +" and entity.communityHospitalId= :hosId order by entity.fileNum desc" ;
		return vIncompleteRecordDao2.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VIncompleteRecord2> findChronicPeople(SearchBeanSU se,
			Page<VIncompleteRecord2> page) {
		
		String h = se.getHql(vc);
		String hql = h +" order by entity.fileNum desc" ;
		return vIncompleteRecordDao2.find(hql,page.getCurrentPage(),page.getPageSize());
	}

	@Override
	public List<VIncompleteRecord2> findChronicPeopleForSpecial(SearchBeanSU se,
			Page<VIncompleteRecord2> page, int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String h = se.getHql(vc);
		String hql =h +" and entity.staffId= :staffId order by entity.fileNum desc" ;
		return vIncompleteRecordDao2.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public VIncompleteRecord2 getVIncompleteRecord(int IncompleteRecordId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("IncompleteRecordId", IncompleteRecordId);
		String hql=" from VIncompleteRecord2 tp where tp.incompleteRecordId=:IncompleteRecordId";
		return vIncompleteRecordDao2.Get(hql,params);
	}
@Override
	public List<VIncompleteRecord2> getAllIncompleteRecord(int hosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		String hql =" from VIncompleteRecord2 tp where tp.communityHospitalId=:hosId and tp.healthFileType =2 order by tp.fileNum desc" ;
		return vIncompleteRecordDao2.find(hql,params);
	}

	@Override
	public List<VIncompleteRecord2> getAllIncompleteRecordForSpecial(
			int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String hql =" from VIncompleteRecord2 tp where tp.staffId=:staffId and tp.healthFileType =2 order by tp.fileNum desc" ;
		return vIncompleteRecordDao2.find(hql,params);
	}

	@Override
	public List<VIncompleteRecord2> getAllIncompleteRecord() {
		String hql=" from VIncompleteRecord2 tp where tp.healthFileType =2 order by tp.fileNum desc";
		return vIncompleteRecordDao2.find(hql);
	}

	@Override
	public List<VIncompleteRecord2> getAllIncompleteRecordForGroup(int groupId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupId", groupId);
		String hql =" from VIncompleteRecord2 tp where tp.GId=:groupId and tp.healthFileType =2 order by tp.fileNum desc" ;
		return vIncompleteRecordDao2.find(hql,params);
	}



}
