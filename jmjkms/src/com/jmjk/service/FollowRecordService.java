package com.jmjk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jmjk.dao.FollowRecordDao;
import com.jmjk.dao.MedicalPayMethodDao;
import com.jmjk.dao.VFollowRecordDao;
import com.jmjk.entity.TFollowRecord;
import com.jmjk.entity.view.VFollowRecord;
import com.jmjk.iservice.IFollowRecordService;
import com.jmjk.utils.Page;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.SearchBeanSU;
import com.jmjk.utils.TypeConverter;
@Controller("followRecordService")
public class FollowRecordService implements IFollowRecordService {
	@Autowired
	private  FollowRecordDao followRecordDao;
	@Autowired
	private  VFollowRecordDao vFollowRecordDao;
	public String vc="VFollowRecord";
	
	@Override
	public void saveFollowRecord(TFollowRecord followrecord) {
		followRecordDao.saveOrUpdate(followrecord);
	}

	@Override
	public void deleteFollowRecord(int followId) {
		String hql="delete from TFollowRecord tp where tp.followRecordId="+followId;
		followRecordDao.delete(hql);
		
	}

	@Override
	public void deleteFollowRecord(List<Object> deleteList) {
		String str=TypeConverter.convertList2String(deleteList,",");
		String hql="delete from TFollowRecord tp where tp.followRecordId in ("+str+")";
		followRecordDao.delete(hql);
		
	}

	@Override
	public void updateFollowRecord(TFollowRecord followrecord) {
		followRecordDao.update(followrecord);
		
	}

	@Override
	public TFollowRecord getFollowRecordByFollowId(int followId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("followId", followId);
		String hql="from TFollowRecord tp where tp.followRecordId= :followId";
		return followRecordDao.Get(hql,params);
	}

	

	@Override
	public long getFollowRecordCount(int hosId,int state) {
		String hql="select count(tp.followRecordId) from VFollowRecord tp where tp.communityHospitalId="+hosId+" and tp.healthFileType="+state;
		return vFollowRecordDao.count(hql);
	}
	@Override
	public long getFollowRecordCountForGroup(int groupId ){
		String hql="select count(tp.followRecordId) from VFollowRecord tp where tp.GId="+groupId+" and tp.healthFileType="+2;
		return vFollowRecordDao.count(hql);
	}
	@Override
	public long getFollowRecordCount(int state) {
		String hql="select count(tp.followRecordId) from VFollowRecord tp where tp.healthFileType="+state;
		return vFollowRecordDao.count(hql);
	}
	@Override
	public long findChronicPeopleCountForGroup(SearchBeanSU se,int groupId){
		String hql="select count(tp.followRecordId) from VFollowRecord tp where tp.GId="+groupId+" and tp.healthFileType=2";
		return vFollowRecordDao.count(hql);
	}
	@Override
	public long getFollowRecordCountForSpecial(int staffId,int state) {
		String hql="select count(tp.followRecordId) from VFollowRecord tp where tp.staffId="+staffId+" and tp.healthFileType="+state;
		return vFollowRecordDao.count(hql);
	}
	@Override
	public List<VFollowRecord> getAllFollowRecord(Page<VFollowRecord> page,
			int hosId,int state) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		params.put("state", state+"");
		String hql="from VFollowRecord tp where tp.communityHospitalId= :hosId and tp.healthFileType like :state order by tp.time desc";
		return vFollowRecordDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}

	@Override
	public List<VFollowRecord> getAllFollowRecord(Page<VFollowRecord> page,int state) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("state", state+"");
		String hql="from VFollowRecord tp where  tp.healthFileType like :state order by tp.time desc";
		return vFollowRecordDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	public List<VFollowRecord> getAllFollowRecordForGroup(Page<VFollowRecord> page,int groupId ){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupId", groupId+"");
		String hql="from VFollowRecord tp where  tp.healthFileType =2 and tp.GId= :groupId order by tp.time desc";
		return vFollowRecordDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VFollowRecord> getAllFollowRecordForSpecial(
			Page<VFollowRecord> page, int staffId,int state) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		params.put("state", state+"");
		String hql="from VFollowRecord tp where tp.staffId= :staffId and tp.healthFileType like :state order by tp.time desc";
		return vFollowRecordDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
///////////////////////////////////多条件查询/////////////////////////////////////////////////////////
	@Override
	public long findChronicPeopleCount(SearchBeanSU se,int hosId) {
		String h = se.getHql(vc);
		String hql ="select count(entity.followRecordId) "+ h +" and communityHospitalId="+hosId ;
		return vFollowRecordDao.count(hql);
	}

	@Override
	public long findChronicPeopleCount(SearchBeanSU se) {
		String h = se.getHql(vc);
		String hql ="select count(entity.followRecordId) "+ h  ;
		return vFollowRecordDao.count(hql);
	}
	@Override
	public long findChronicPeopleCountForSpecial(SearchBeanSU se,int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String h = se.getHql(vc);
		String hql ="select count(entity.followRecordId) "+ h +" and entity.staffId= :staffId order by entity.fileNum desc" ;
		return vFollowRecordDao.count(hql,params);
	}

	@Override
	public List<VFollowRecord> findChronicPeople(SearchBeanSU se,
			Page<VFollowRecord> page, int hosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		String h = se.getHql(vc);
		String hql =h +"and entity.communityHospitalId= :hosId order by entity.fileNum desc" ;
		return vFollowRecordDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VFollowRecord> findChronicPeople(SearchBeanSU se,
			Page<VFollowRecord> page) {
		
		String h = se.getHql(vc);
		String hql = h +" order by entity.fileNum desc" ;
		return vFollowRecordDao.find(hql,page.getCurrentPage(),page.getPageSize());
	}

	@Override
	public List<VFollowRecord> findChronicPeopleForSpecial(SearchBeanSU se,
			Page<VFollowRecord> page, int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String h = se.getHql(vc);
		String hql =h +"and entity.staffId= :staffId order by entity.fileNum desc" ;
		return vFollowRecordDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public VFollowRecord getVFollowRecord(int FollowRecordId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("FollowRecordId", FollowRecordId);
		String hql="from VFollowRecord tp where tp.followRecordId=:FollowRecordId";
		return vFollowRecordDao.Get(hql,params);
	}
@Override
	public List<VFollowRecord> getAllFollowRecord(int hosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		String hql ="from VFollowRecord tp where tp.communityHospitalId=:hosId and tp.healthFileType =2 order by tp.fileNum desc" ;
		return vFollowRecordDao.find(hql,params);
	}

	@Override
	public List<VFollowRecord> getAllFollowRecordForSpecial(
			int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String hql ="from VFollowRecord tp where tp.staffId=:staffId and tp.healthFileType =2 order by tp.fileNum desc" ;
		return vFollowRecordDao.find(hql,params);
	}

	@Override
	public List<VFollowRecord> getAllFollowRecord() {
		String hql="from VFollowRecord tp where tp.healthFileType =2 order by tp.fileNum desc";
		return vFollowRecordDao.find(hql);
	}
	@Override
	public List<VFollowRecord> getAllFollowRecordForGroup(int groupId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("groupId", groupId);
		String hql ="from VFollowRecord tp where tp.GId=:groupId and tp.healthFileType =2 order by tp.fileNum desc" ;
		return vFollowRecordDao.find(hql,params);
	}

	
}
