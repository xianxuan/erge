package com.jmjk.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jmjk.dao.KnowledgeLectureDao;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.TKnowledgeLecture;
import com.jmjk.iservice.IKnowledgeLectureService;
import com.jmjk.utils.Page;
import com.jmjk.utils.TypeConverter;

@Controller("knowledgeLectureService")
public class KnowledgeLectureService implements IKnowledgeLectureService{
    
	@Autowired
	private KnowledgeLectureDao knowledgeLectureDao;
	@Autowired
	private CommunityHospitalGroupService communityHospitalGroupService;
	@Override
	public void saveKnowledgeLecture(TKnowledgeLecture knowledgelecture) {
		knowledgeLectureDao.Save(knowledgelecture);
	}

	@Override
	public void deleteKnowledgeLecture(int knowledgelectureID) {
		String hql="delete from TKnowledgeLecture tkl where tkl.knowledgeLectureId="+knowledgelectureID;
		knowledgeLectureDao.delete(hql);
	}

	@Override
	public void updateKnowledgeLecture(TKnowledgeLecture knowledgelecture) {
		knowledgeLectureDao.update(knowledgelecture);
	}

	@Override
	public List<TKnowledgeLecture> getKnowledgeLectureListBySearch(
			int comHosId, String strSearchText,String status,
			Date beginTime, Date endTime, Page<TKnowledgeLecture> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("comHosId", comHosId);
		String hql = "from TKnowledgeLecture tkl where tkl.communityHospitalId = :comHosId";
		if (status!=""&!"".equals(status)) {
			params.put("status", status);
			hql+=" and tkl.status = :status";
		}
		if (StringUtils.isNotBlank(strSearchText)) {
			params.put("strSearchText", "%"+strSearchText+"%");
			hql += " and tkl.lectureName like :strSearchText";
		}
		if(beginTime!=null){
			hql += " and DATE_FORMAT(tkl.planTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(tkl.planTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		hql+=" order by tkl.planTime desc";
		List<TKnowledgeLecture> knowledgeLectures = knowledgeLectureDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
		return knowledgeLectures;
	}

	@Override
	public long getKnowledgeLectureNumBySearch(int comHosId,
			String strSearchText, String status,Date beginTime, Date endTime) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("comHosId", comHosId);
		String hql = "select count(knowledgeLectureId) from TKnowledgeLecture tkl where tkl.communityHospitalId = :comHosId";
		if (status!=""&!"".equals(status)) {
			params.put("status", status);
			hql+=" and tkl.status = :status";
		}
		if (StringUtils.isNotBlank(strSearchText)) {
			params.put("strSearchText", "%"+strSearchText+"%");
			hql += " and tkl.lectureName like :strSearchText";
		}
		if(beginTime!=null){
			hql += " and DATE_FORMAT(tkl.planTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(tkl.planTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		hql+=" order by tkl.planTime desc";
		long num=knowledgeLectureDao.count(hql,params);
		return num;
	}

	@Override
	public TKnowledgeLecture getKnowledgeLectureById(int knowledgelectureID) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("knowledgelectureID", knowledgelectureID);
		String hql="from TKnowledgeLecture tkl where tkl.knowledgeLectureId= :knowledgelectureID";
		TKnowledgeLecture tKnowledgeLecture=knowledgeLectureDao.Get(hql,params);
		return tKnowledgeLecture;
	}

	@Override
	public List<TKnowledgeLecture> getKnowledgeLectureListByComhosId(
			int comHosId, Page<TKnowledgeLecture> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("comHosId", comHosId);
		String hql = "from TKnowledgeLecture tkl where tkl.communityHospitalId = :comHosId";
		hql+=" order by tkl.planTime desc";
		List<TKnowledgeLecture> list = knowledgeLectureDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
		return list;
	}
	public List<TKnowledgeLecture> getKnowledgeLectureListForSpecial(
			int staffID, Page<TKnowledgeLecture> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffID", staffID);
		String hql = "from TKnowledgeLecture tkl where tkl.TStaff.staffId = :staffID";
		hql+=" order by tkl.planTime desc";
		List<TKnowledgeLecture> list = knowledgeLectureDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
		return list;
	}
	@Override
	public long getKnowledgeLectureNumByComhosId(int comHosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("comHosId", comHosId);
		String hql = "select count(*) from TKnowledgeLecture tkl where tkl.communityHospitalId = :comHosId";
		long count=knowledgeLectureDao.count(hql,params);
		return count;
	}
	public long getKnowledgeLectureNumForSpecial(int staffID) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffID", staffID);
		String hql = "select count(*) from TKnowledgeLecture tkl where tkl.TStaff.staffId = :staffID";
		long count=knowledgeLectureDao.count(hql,params);
		return count;
	}

	@Override
	public long getKnowleSpecialNumBySearch(int staffID, String strSearchText,
			String status, Date beginTime, Date endTime) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffID", staffID);
		String hql = "select count(*) from TKnowledgeLecture tkl where tkl.TStaff.staffId = :staffID";
		if (status!=""&!"".equals(status)) {
			params.put("status", status);
			hql+=" and tkl.status = :status";
		}
		if (StringUtils.isNotBlank(strSearchText)) {
			params.put("strSearchText", "%"+strSearchText+"%");
			hql += " and tkl.lectureName like :strSearchText";
		}
		if(beginTime!=null){
			hql += " and DATE_FORMAT(tkl.planTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(tkl.planTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		hql+=" order by tkl.planTime desc";
		long num=knowledgeLectureDao.count(hql,params);
		return num;
	}

	@Override
	public List<TKnowledgeLecture> getKnolSpecialListBySearch(int staffID,
			String strSearchText, String status, Date beginTime, Date endTime,
			Page<TKnowledgeLecture> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffID", staffID);
		String hql = "from TKnowledgeLecture tkl where tkl.TStaff.staffId = :staffID";
		if (status!=""&!"".equals(status)) {
			params.put("status", status);
			hql+=" and tkl.status = :status";
		}
		if (StringUtils.isNotBlank(strSearchText)) {
			params.put("strSearchText", "%"+strSearchText+"%");
			hql += " and tkl.lectureName like :strSearchText";
		}
		if(beginTime!=null){
			hql += " and DATE_FORMAT(tkl.planTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(tkl.planTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		hql+=" order by tkl.planTime desc";
		List<TKnowledgeLecture> knowledgeLectures = knowledgeLectureDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
		return knowledgeLectures;
	}
	@Override
	public List<TKnowledgeLecture> geKnowledgeLectureListByAll(Page page) {
		String hql = "from TKnowledgeLecture  tkg order by tkg.planTime desc" ;
		List<TKnowledgeLecture> list = knowledgeLectureDao.find(hql,page.getCurrentPage(),page.getPageSize());
		return list;
	}

	@Override
	public long getKnowledgeLectureNumByAll() {
		String hql = "select count(*) from TKnowledgeLecture";
		long count = knowledgeLectureDao.count(hql);
		return count;
	}

	@Override
	public List<TKnowledgeLecture> getKnowledgeLectureListById(int comHosId) {
		
		String hql = " from TKnowledgeLecture tkl where tkl.communityHospitalId ="+comHosId;
		hql+=" order by tkl.planTime desc";
		List<TKnowledgeLecture> list = knowledgeLectureDao.find(hql);
		return list;
	}

	@Override
	public List<TKnowledgeLecture> getTKnowLedgeLectureListBySearch(
			String strSearchText, String status, Date beginTime, Date endTime,
			Page<TKnowledgeLecture> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from TKnowledgeLecture tkl where 1=1";
		if (status!=""&!"".equals(status)) {
			params.put("status", status);
			hql+=" and tkl.status = :status";
		}
		if (StringUtils.isNotBlank(strSearchText)) {
			params.put("strSearchText", "%"+strSearchText+"%");
			hql += " and tkl.lectureName like :strSearchText";
		}
		if(beginTime!=null){
			hql += " and DATE_FORMAT(tkl.planTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(tkl.planTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		hql+=" order by tkl.planTime desc";
		List<TKnowledgeLecture> list = knowledgeLectureDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
		return list;
	}

	@Override
	public long getTKnowLedgeLectureNumBySearch(String strSearchText,
			String status, Date beginTime, Date endTime) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " select count(*) from TKnowledgeLecture tkl where 1=1";
		if (status!=""&!"".equals(status)) {
			params.put("status", status);
			hql+=" and tkl.status = :status";
		}
		if (StringUtils.isNotBlank(strSearchText)) {
			params.put("strSearchText", "%"+strSearchText+"%");
			hql += " and tkl.lectureName like :strSearchText";
		}
		if(beginTime!=null){
			hql += " and DATE_FORMAT(tkl.planTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(tkl.planTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		long num = knowledgeLectureDao.count(hql,params);
		return num;
	}

	@Override
	public long getKnowledgeNUmByGrop(TCommunityHospitalGroup comHosGroup) {
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
		String hql="select count(*) from TKnowledgeLecture tk where tk.communityHospitalId in ("+str+")";
		return knowledgeLectureDao.count(hql);
	}

	@Override
	public List<TKnowledgeLecture> getKnowledgeListByGrop(
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
		String hql="from TKnowledgeLecture tk where tk.communityHospitalId in ("+str+")";
		hql+=" order by tk.planTime desc";
		return knowledgeLectureDao.find(hql);
	}

	@Override
	public long getKnowledNumGroupBySearch(int comHosGroupId,
			String strSearchText, String status, Date beginTime, Date endTime) {
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
		String hql="select count(*) from TKnowledgeLecture tkl where tkl.communityHospitalId in ("+str+")";
		if (status!=""&!"".equals(status)) {
			params.put("status", status);
			hql+=" and tkl.status = :status";
		}
		if (StringUtils.isNotBlank(strSearchText)) {
			params.put("strSearchText", "%"+strSearchText+"%");
			hql += " and tkl.lectureName like :strSearchText";
		}
		if(beginTime!=null){
			hql += " and DATE_FORMAT(tkl.planTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(tkl.planTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		hql+=" order by tkl.planTime desc";
		long num=knowledgeLectureDao.count(hql,params);
		return num;
	}

	@Override
	public List<TKnowledgeLecture> getKnowledListGroupBySearch(
			int comHosGroupId, String strSearchText, String status,
			Date beginTime, Date endTime, Page<TKnowledgeLecture> page) {
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
		String hql="from TKnowledgeLecture tkl where tkl.communityHospitalId in ("+str+")";
		if (status!=""&!"".equals(status)) {
			params.put("status", status);
			hql+=" and tkl.status = :status";
		}
		if (StringUtils.isNotBlank(strSearchText)) {
			params.put("strSearchText", "%"+strSearchText+"%");
			hql += " and tkl.lectureName like :strSearchText";
		}
		if(beginTime!=null){
			hql += " and DATE_FORMAT(tkl.planTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(tkl.planTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		hql+=" order by tkl.planTime desc";
		List<TKnowledgeLecture> knowledgeLectures = knowledgeLectureDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
		return knowledgeLectures;
	}

	

	
	

}
