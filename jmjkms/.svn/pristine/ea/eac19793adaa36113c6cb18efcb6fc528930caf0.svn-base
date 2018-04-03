package com.jmjk.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.druid.util.StringUtils;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jmjk.dao.ComminityClinicDao;
import com.jmjk.entity.TComminityClinic;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.iservice.IComminityClinicService;
import com.jmjk.utils.Page;
import com.jmjk.utils.TypeConverter;

@Controller("comminityClinicService")
public class ComminityClinicService implements IComminityClinicService{

	@Autowired
	private ComminityClinicDao comminityClinicDao;
	@Autowired
	private CommunityHospitalGroupService communityHospitalGroupService;
	@Override
	public void saveComminityClinic(TComminityClinic comminityclinic) {
		comminityClinicDao.Save(comminityclinic);
	}

	@Override
	public void deleteComminityClinic(int comminityclinicID) {
		String hql="delete from TComminityClinic tcc where tcc.comminityClinicId="+comminityclinicID;
		comminityClinicDao.delete(hql);
	}

	
	@Override
	public void updateComminityClinic(TComminityClinic comminityclinic) {
		comminityClinicDao.update(comminityclinic);
	}

	@Override
	public List<TComminityClinic> getComminityClinicListBySearch(int comHosID,
			String status, Date beginTime, Date endTime,
			Page<TComminityClinic> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("comHosID", comHosID);
		String hql = "from TComminityClinic tcc where tcc.communityHospitalId = :comHosID";
		if (status!=""&!"".equals(status)) {
			params.put("status", status);
			hql+=" and tcc.status = :status";
		}
		if(beginTime!=null){
			hql += " and  DATE_FORMAT(tcc.planTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(tcc.planTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		hql+=" order by tcc.planTime desc";
		List<TComminityClinic> comminityClinics = comminityClinicDao.find(hql,params,page.getCurrentPage(),page.getPageSize());		
		return comminityClinics;
	}

	@Override
	public long getComminityClinicNumBySearch(int comHosID, String status,
			Date beginTime, Date endTime) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("comHosID", comHosID);
		String hql = "select count(comminityClinicId) from TComminityClinic tcc where tcc.communityHospitalId = :comHosID";
		if (status!=""&!"".equals(status)) {
			params.put("status", status);
			hql+=" and tcc.status = :status";
		}
		
		if(beginTime!=null){
			hql += " and DATE_FORMAT(tcc.planTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		
		if(endTime!=null){
			hql += " and DATE_FORMAT(tcc.planTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		hql+=" order by tcc.planTime desc";
		long num = comminityClinicDao.count(hql,params);
		return num;
	}

	@Override
	public TComminityClinic getComminityClinicById(int comminityclinicID) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("comminityclinicID", comminityclinicID);
		String hql="from TComminityClinic tcc where tcc.comminityClinicId= :comminityclinicID";
		TComminityClinic tComminityClinic=comminityClinicDao.Get(hql,params);
		return tComminityClinic;
	}

	@Override
	public List<TComminityClinic> getComminityClinicBycomHosID(int comHosID,
			Page<TComminityClinic> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("comHosID", comHosID);
		String hql = "from TComminityClinic tcc where tcc.communityHospitalId = :comHosID";
		hql+=" order by tcc.planTime desc";
		List<TComminityClinic> list=comminityClinicDao.find(hql,params,page.getCurrentPage(),page.getPageSize());		   
		return list;
	}
	public List<TComminityClinic> getComminityClinicForSpecial(int staffID,
			Page<TComminityClinic> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffID",staffID);
		String hql = "from TComminityClinic tcc where tcc.TStaff.staffId = :staffID";
		hql+=" order by tcc.planTime desc";
		List<TComminityClinic> list=comminityClinicDao.find(hql,params,page.getCurrentPage(),page.getPageSize());		   
		return list;
	}
	@Override
	public long getComminityClinicNumBycomHosID(int comHousID) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("comHousID", comHousID);
		String hql = "select count(*) from TComminityClinic tcc where tcc.communityHospitalId = :comHousID";
		long count=comminityClinicDao.count(hql,params);
		return count;
	}
	public long getComminityClinicNumForSpecial(int staffID) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffID", staffID);
		String hql = "select count(*) from TComminityClinic tcc where tcc.TStaff.staffId = :staffID";
		long count=comminityClinicDao.count(hql,params);
		return count;
	}
	@Override
	public long getCommiSpecialNumBySearch(int staffID, String status,
			Date beginTime, Date endTime) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffID", staffID);
		String hql = "select count(*) from TComminityClinic tcc where tcc.TStaff.staffId = :staffID";
		if (status!=""&!"".equals(status)) {
			params.put("status", status);
			hql+=" and tcc.status = :status";
		}
		
		if(beginTime!=null){
			hql += " and DATE_FORMAT(tcc.planTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		
		if(endTime!=null){
			hql += " and DATE_FORMAT(tcc.planTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		hql+=" order by tcc.planTime desc";
		long num = comminityClinicDao.count(hql,params);
		return num;
	}

	@Override
	public List<TComminityClinic> getCommiSpecialListBySearch(int staffID,
			String status, Date beginTime, Date endTime,
			Page<TComminityClinic> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffID", staffID);
		String hql = "from TComminityClinic tcc where tcc.TStaff.staffId = :staffID";
		if (status!=""&!"".equals(status)) {
			params.put("status", status);
			hql+=" and tcc.status = :status";
		}
		if(beginTime!=null){
			hql += " and  DATE_FORMAT(tcc.planTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(tcc.planTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		hql+=" order by tcc.planTime desc";
		List<TComminityClinic> comminityClinics = comminityClinicDao.find(hql,params,page.getCurrentPage(),page.getPageSize());		
		return comminityClinics;
	}
	@Override
	public List<TComminityClinic> getComminityClinicListByAll(Page page) {
		 String hql = "from TComminityClinic tcc order by tcc.planTime desc" ;
		 List<TComminityClinic> list = comminityClinicDao.find(hql,page.getCurrentPage(),page.getPageSize());
		return list;
	}

	@Override
	public long getTComminityClinicNumByAll() {
		String hql = "select count(*) from TComminityClinic";
		long count = comminityClinicDao.count(hql);
		return count;
	}

	@Override
	public List<TComminityClinic> getComminityClinicListById(int comHosID) {
		String hql = " from TComminityClinic tcc where tcc.communityHospitalId ="+comHosID;
		hql +=" order by tcc.planTime desc";
		List<TComminityClinic> list = comminityClinicDao.find(hql);
		return list;
	}

	@Override
	public List<TComminityClinic> getTComminityClinicListBySearch(
			String status, Date beginTime, Date endTime,
			Page<TComminityClinic> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from TComminityClinic tcc where 1=1";
		if (status!=""&!"".equals(status)) {
			params.put("status", status);
			hql+=" and tcc.status = :status";
		}
		if(beginTime!=null){
			hql += " and  DATE_FORMAT(tcc.planTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(tcc.planTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		hql+=" order by tcc.planTime desc";
		List<TComminityClinic> list = comminityClinicDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
		return list;
	}

	@Override
	public long getTComminityClinicNumBySearch(String status, Date beginTime,
			Date endTime) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " select count(*) from TComminityClinic tcc where 1=1";
		if (status!=""&!"".equals(status)) {
			params.put("status", status);
			hql+=" and tcc.status = :status";
		}
		if(beginTime!=null){
			hql += " and  DATE_FORMAT(tcc.planTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(tcc.planTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		long num = comminityClinicDao.count(hql,params);
		return num;
	}

	@Override
	public long getComminityNumByGroup(TCommunityHospitalGroup comHosGroup) {
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
		String hql="select count(*) from TComminityClinic tc where tc.communityHospitalId in ("+str+")";
		return comminityClinicDao.count(hql);
	}

	@Override
	public List<TComminityClinic> getComminityClinListByGroup(
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
		String hql="from TComminityClinic tc where tc.communityHospitalId in ("+str+")";
		hql+=" order by tc.planTime desc";
		return comminityClinicDao.find(hql);
	}

	@Override
	public long getCommiNumGroupBySearch(int comHosGroupID, String status,
			Date beginTime, Date endTime) {
		TCommunityHospitalGroup comHosGroup = communityHospitalGroupService.getComHosGroupByGroupId(comHosGroupID);
		List<TCommunityHospital> listcomHospitals=new ArrayList<TCommunityHospital>();
		listcomHospitals=communityHospitalGroupService.getComHosListByGroup(comHosGroup);
		List<Object> listcomHosId=new ArrayList<Object>();
		for(int i=0;i<listcomHospitals.size();i++){
			listcomHosId.add(listcomHospitals.get(i).getCommunityHospitalId());
		}
		String a = ",";
		String str = TypeConverter.convertList2String(listcomHosId,a);
		Map<String, Object> params = new HashMap<String, Object>();
		String hql="select count(*) from TComminityClinic tcc where tcc.communityHospitalId in ("+str+")";
		if (status!=""&!"".equals(status)) {
			params.put("status", status);
			hql+=" and tcc.status = :status";
		}
		
		if(beginTime!=null){
			hql += " and DATE_FORMAT(tcc.planTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		
		if(endTime!=null){
			hql += " and DATE_FORMAT(tcc.planTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		long num = comminityClinicDao.count(hql,params);
		return num;
	}

	@Override
	public List<TComminityClinic> getCommiListGroupBySearch(int comHosGroupID,
			String status, Date beginTime, Date endTime,
			Page<TComminityClinic> page) {
		TCommunityHospitalGroup comHosGroup = communityHospitalGroupService.getComHosGroupByGroupId(comHosGroupID);
		List<TCommunityHospital> listcomHospitals=new ArrayList<TCommunityHospital>();
		listcomHospitals=communityHospitalGroupService.getComHosListByGroup(comHosGroup);
		List<Object> listcomHosId=new ArrayList<Object>();
		for(int i=0;i<listcomHospitals.size();i++){
			listcomHosId.add(listcomHospitals.get(i).getCommunityHospitalId());
		}
		String a = ",";
		String str = TypeConverter.convertList2String(listcomHosId,a);
		Map<String, Object> params = new HashMap<String, Object>();
		String hql="from TComminityClinic tcc where tcc.communityHospitalId in ("+str+")";
		if (status!=""&!"".equals(status)) {
			params.put("status", status);
			hql+=" and tcc.status = :status";
		}
		if(beginTime!=null){
			hql += " and  DATE_FORMAT(tcc.planTime,'%Y-%m-%d') >= '"+beginTime+"'";
		}
		if(endTime!=null){
			hql += " and DATE_FORMAT(tcc.planTime,'%Y-%m-%d') <= '"+endTime+"'";
		}
		hql+=" order by tcc.planTime desc";
		List<TComminityClinic> comminityClinics = comminityClinicDao.find(hql,params,page.getCurrentPage(),page.getPageSize());		
		return comminityClinics;
	}

	

	

}
