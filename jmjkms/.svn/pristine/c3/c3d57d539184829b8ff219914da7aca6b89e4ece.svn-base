package com.jmjk.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.EquipmentManageDao;
import com.jmjk.dao.MaintenanceDao;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.TEquipmentManage;
import com.jmjk.entity.TMaintenance;
import com.jmjk.iservice.ICommunityHospitalService;
import com.jmjk.iservice.IEquipmentManageService;
import com.jmjk.utils.Page;
import com.jmjk.utils.TypeConverter;
@Controller("equipmentManageService")
public class EquipmentManageService implements IEquipmentManageService{

	@Autowired
	private EquipmentManageDao equipmentManageDao;
	@Autowired
	private CommunityHospitalGroupService communityHospitalGroupService;
	@Autowired
	private MaintenanceDao maintenanceDao;
	
	@Override
	public void saveEquipmentManage(TEquipmentManage equipment) {
		equipmentManageDao.Save(equipment);
	}

	@Override
	public void deleteEquipmentManage(int equipmentId) {
		String hql="delete from TEquipmentManage tem where tem.equipId="+equipmentId;
		equipmentManageDao.delete(hql);
	}

	@Override
	public void updateEquipmentManage(TEquipmentManage equipment) {
		equipmentManageDao.update(equipment);
	}

	@Override
	public List<TEquipmentManage> getEquipmentManageListBySearch(int comHosId,
			String strSearch, String strSearchText, Page<TEquipmentManage> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("comHosId", comHosId);
		
		String hql = "from TEquipmentManage tem where tem.TCommunityHospital.communityHospitalId = :comHosId";
		if(strSearch != null){
			if(strSearch=="设备名称"||strSearch.equals("设备名称")){
				if(StringUtils.isNotBlank(strSearchText)){
					params.put("strSearchText", "%"+strSearchText+"%");
					hql += " and tem.equipName like :strSearchText";
					}
			}
	
			if(strSearch=="设备型号"||strSearch.equals("设备型号")){
				if(StringUtils.isNotBlank(strSearchText)){
					params.put("strSearchText", "%"+strSearchText+"%");
					hql += " and tem.equipModel like :strSearchText";
				}
			}
			if(strSearch=="设备编号"||strSearch.equals("设备编号")){
				if(StringUtils.isNotBlank(strSearchText)){
					params.put("strSearchText", "%"+strSearchText+"%");
					hql += " and tem.equipNumber like :strSearchText";
				}
			}
			if(strSearch=="设备采购人"||strSearch.equals("设备采购人")){
				if(StringUtils.isNotBlank(strSearchText)){
					params.put("strSearchText", "%"+strSearchText+"%");
					hql += " and tem.equipPeople like :strSearchText";
				}
			}
		}
		hql+=" order by tem.selectTime desc";
		List<TEquipmentManage> list = equipmentManageDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
		return list;
	}

	@Override
	public long getEquipmentManageNumBySearch(int comHosId, String strSearch,
			String strSearchText) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("comHosId", comHosId);
		
		String hql = "select count(*) from TEquipmentManage tem where tem.TCommunityHospital.communityHospitalId = :comHosId";
		if(strSearch=="设备名称"||strSearch.equals("设备名称")){
			if(StringUtils.isNotBlank(strSearchText)){
				params.put("strSearchText", "%"+strSearchText+"%");
				hql += " and tem.equipName like :strSearchText";
			}
		}
		if(strSearch=="设备型号"||strSearch.equals("设备型号")){
			if(StringUtils.isNotBlank(strSearchText)){
				params.put("strSearchText", "%"+strSearchText+"%");
				hql += " and tem.equipModel like :strSearchText";
			}
		}
		if(strSearch=="设备编号"||strSearch.equals("设备编号")){
			if(StringUtils.isNotBlank(strSearchText)){
				params.put("strSearchText", "%"+strSearchText+"%");
				hql += " and tem.equipNumber like :strSearchText";
			}
		}
		if(strSearch=="设备采购人"||strSearch.equals("设备采购人")){
			if(StringUtils.isNotBlank(strSearchText)){
				params.put("strSearchText", "%"+strSearchText+"%");
				hql += " and tem.equipPeople like :strSearchText";
			}
		}
		hql+=" order by tem.selectTime desc";
		long num = equipmentManageDao.count(hql,params);
		return num;
	}

	@Override
	public TEquipmentManage getEquipmentManageById(int equipmentId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("equipmentId", equipmentId);
		String hql="from TEquipmentManage tem where tem.equipId = :equipmentId";
		TEquipmentManage tEquipmentManage=equipmentManageDao.Get(hql,params);
		return tEquipmentManage;
	}

	@Override
	public List<TEquipmentManage> getEquipmentManageListByComhosId(
			int comHosId, Page<TEquipmentManage> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("comHosId", comHosId);
		String hql = "from TEquipmentManage tem where tem.TCommunityHospital.communityHospitalId = :comHosId order by selectTime desc";
		List<TEquipmentManage> list=equipmentManageDao.find(hql,params,page.getCurrentPage(),page.getPageSize());	
		return list;
	}

	@Override
	public long getEquipmentManageNumByComhosId(int comHosId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("comHosId", comHosId);
		String hql = "select count(*) from TEquipmentManage tem where tem.TCommunityHospital.communityHospitalId = :comHosId";
		return equipmentManageDao.count(hql,params);
	}

	@Override
	public List<TMaintenance> getMaintenanceListByEquipmentManageId(
			int equipmentManageId, Page page){
		Map<String, Object> paramts = new HashMap<String, Object>();
		paramts.put("equipmentManageId", equipmentManageId);
		String hql = "from TMaintenance tm where tm.TEquipmentManage.equipId = :equipmentManageId";
		List<TMaintenance> list;
			list = maintenanceDao.find(hql,paramts,page.getCurrentPage(),page.getPageSize());
			return list;
		
	}

	@Override
	public List<TEquipmentManage> getEquipmentManageListByAll(Page page) {
		String hql = "from TEquipmentManage tm  order by tm.selectTime desc";
		List<TEquipmentManage> list = equipmentManageDao.find(hql,page.getCurrentPage(),page.getPageSize());
		return list;
	}

	@Override
	public long getEquipmentManageNumByAll() {
		String hql = "select count(*) from TEquipmentManage";
		long count = equipmentManageDao.count(hql);
		return count;
	}

	@Override
	public List<TEquipmentManage> getEquipmentManageListById(int comHosId) {
		String hql = " from TEquipmentManage tem where tem.TCommunityHospital.communityHospitalId ="+comHosId;
		hql+=" order by tem.selectTime desc";
		List<TEquipmentManage> list = equipmentManageDao.find(hql);
		return list;
	}

	@Override
	public List<TEquipmentManage> getTEquipmentManageListBySearch(
			String strSearch, String strSearchText, Page<TEquipmentManage> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		String hql = " from TEquipmentManage tem where 1=1";
		if(strSearch != null){
			if(strSearch=="设备名称"||strSearch.equals("设备名称")){
				if(StringUtils.isNotBlank(strSearchText)){
					params.put("strSearchText", "%"+strSearchText+"%");
					hql += " and tem.equipName like :strSearchText";
					}
			}
	
			if(strSearch=="设备型号"||strSearch.equals("设备型号")){
				if(StringUtils.isNotBlank(strSearchText)){
					params.put("strSearchText", "%"+strSearchText+"%");
					hql += " and tem.equipModel like :strSearchText";
				}
			}
			if(strSearch=="设备编号"||strSearch.equals("设备编号")){
				if(StringUtils.isNotBlank(strSearchText)){
					params.put("strSearchText", "%"+strSearchText+"%");
					hql += " and tem.equipNumber like :strSearchText";
				}
			}
			if(strSearch=="设备采购人"||strSearch.equals("设备采购人")){
				if(StringUtils.isNotBlank(strSearchText)){
					params.put("strSearchText", "%"+strSearchText+"%");
					hql += " and tem.equipPeople like :strSearchText";
				}
			}
		}
		hql+=" order by tem.selectTime desc";
		List<TEquipmentManage> list = equipmentManageDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
		return list;
	}

	@Override
	public long getTEquipmentManageNumBySearch(String strSearch,
			String strSearchText) {
		Map<String, Object > params = new HashMap<String, Object>();
		String hql = " select count(*) from TEquipmentManage tem where 1=1";
		if(strSearch != null){
			if(strSearch=="设备名称"||strSearch.equals("设备名称")){
				if(StringUtils.isNotBlank(strSearchText)){
					params.put("strSearchText", "%"+strSearchText+"%");
					hql += " and tem.equipName like :strSearchText";
					}
			}
	
			if(strSearch=="设备型号"||strSearch.equals("设备型号")){
				if(StringUtils.isNotBlank(strSearchText)){
					params.put("strSearchText", "%"+strSearchText+"%");
					hql += " and tem.equipModel like :strSearchText";
				}
			}
			if(strSearch=="设备编号"||strSearch.equals("设备编号")){
				if(StringUtils.isNotBlank(strSearchText)){
					params.put("strSearchText", "%"+strSearchText+"%");
					hql += " and tem.equipNumber like :strSearchText";
				}
			}
			if(strSearch=="设备采购人"||strSearch.equals("设备采购人")){
				if(StringUtils.isNotBlank(strSearchText)){
					params.put("strSearchText", "%"+strSearchText+"%");
					hql += " and tem.equipPeople like :strSearchText";
				}
			}
		}
		long num = equipmentManageDao.count(hql,params);
		return num;
	}

	@Override
	public long getEquipmentNumByGroup(TCommunityHospitalGroup comHosGroup) {
		List<TCommunityHospital> listcomHospitals=new ArrayList<TCommunityHospital>();
		listcomHospitals=communityHospitalGroupService.getComHosListByGroup(comHosGroup);
		if(listcomHospitals.size()==0)
		    return  0; 
		List<Object> listcomHosId=new ArrayList<Object>();
		for(int i=0;i<listcomHospitals.size();i++){
			listcomHosId.add(listcomHospitals.get(i).getCommunityHospitalId());
		}  //根据社区医院IDList获得 健康教育数量
		String a = ",";
		String str = TypeConverter.convertList2String(listcomHosId,a);
		String hql="select count(*) from TEquipmentManage tem where tem.TCommunityHospital.communityHospitalId in ("+str+")";
		return equipmentManageDao.count(hql);
	}

	@Override
	public List<TEquipmentManage> geTEquipmentListByGroup(
			TCommunityHospitalGroup comHosGroup) {
		List<TCommunityHospital> listcomHospitals=new ArrayList<TCommunityHospital>();
		listcomHospitals=communityHospitalGroupService.getComHosListByGroup(comHosGroup);
		if(listcomHospitals.size()==0)
		    return  null; 
		List<Object> listcomHosId=new ArrayList<Object>();
		for(int i=0;i<listcomHospitals.size();i++){
			listcomHosId.add(listcomHospitals.get(i).getCommunityHospitalId());
		}  //根据社区医院IDList获得 健康教育列表
		String a = ",";
		String str = TypeConverter.convertList2String(listcomHosId,a);
		String hql="from TEquipmentManage tem where tem.TCommunityHospital.communityHospitalId in ("+str+")";
		hql+=" order by tem.selectTime desc";
		return equipmentManageDao.find(hql);
	}

	@Override
	public long getEquipNumGroupBySearch(int comHosGroupId, String strSearch,
			String strSearchText) {
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
		String hql="select count(*) from TEquipmentManage tem where tem.TCommunityHospital.communityHospitalId in ("+str+")";
		if(strSearch=="设备名称"||strSearch.equals("设备名称")){
			if(StringUtils.isNotBlank(strSearchText)){
				params.put("strSearchText", "%"+strSearchText+"%");
				hql += " and tem.equipName like :strSearchText";
			}
		}
		if(strSearch=="设备型号"||strSearch.equals("设备型号")){
			if(StringUtils.isNotBlank(strSearchText)){
				params.put("strSearchText", "%"+strSearchText+"%");
				hql += " and tem.equipModel like :strSearchText";
			}
		}
		if(strSearch=="设备编号"||strSearch.equals("设备编号")){
			if(StringUtils.isNotBlank(strSearchText)){
				params.put("strSearchText", "%"+strSearchText+"%");
				hql += " and tem.equipNumber like :strSearchText";
			}
		}
		if(strSearch=="设备采购人"||strSearch.equals("设备采购人")){
			if(StringUtils.isNotBlank(strSearchText)){
				params.put("strSearchText", "%"+strSearchText+"%");
				hql += " and tem.equipPeople like :strSearchText";
			}
		}
		long num = equipmentManageDao.count(hql,params);
		return num;
	}

	@Override
	public List<TEquipmentManage> getEquipListGroupBySearch(int comHosGroupId,
			String strSearch, String strSearchText, Page<TEquipmentManage> page) {
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
		String hql="from TEquipmentManage tem where tem.TCommunityHospital.communityHospitalId in ("+str+")";
		if(strSearch != null){
			if(strSearch=="设备名称"||strSearch.equals("设备名称")){
				if(StringUtils.isNotBlank(strSearchText)){
					params.put("strSearchText", "%"+strSearchText+"%");
					hql += " and tem.equipName like :strSearchText";
					}
			}
	
			if(strSearch=="设备型号"||strSearch.equals("设备型号")){
				if(StringUtils.isNotBlank(strSearchText)){
					params.put("strSearchText", "%"+strSearchText+"%");
					hql += " and tem.equipModel like :strSearchText";
				}
			}
			if(strSearch=="设备编号"||strSearch.equals("设备编号")){
				if(StringUtils.isNotBlank(strSearchText)){
					params.put("strSearchText", "%"+strSearchText+"%");
					hql += " and tem.equipNumber like :strSearchText";
				}
			}
			if(strSearch=="设备采购人"||strSearch.equals("设备采购人")){
				if(StringUtils.isNotBlank(strSearchText)){
					params.put("strSearchText", "%"+strSearchText+"%");
					hql += " and tem.equipPeople like :strSearchText";
				}
			}
		}
		hql+=" order by tem.selectTime desc";
		List<TEquipmentManage> list = equipmentManageDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
		return list;
	}

	@Override
	public long getEquipNumSpecial(int staffID) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffID", staffID);
		String hql = "select count(*) from TEquipmentManage tem where tem.TStaff.staffId = :staffID";
		long num = equipmentManageDao.count(hql, params);
		return num;
	}

	@Override
	public List<TEquipmentManage> getEquipListSpecial(int staffID,
			Page<TEquipmentManage> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffID", staffID);
		String hql = "from TEquipmentManage tem where tem.TStaff.staffId = :staffID";
		hql+=" order by tem.selectTime desc";
		List<TEquipmentManage> list = equipmentManageDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
		return list;
	}

	@Override
	public long getEquipNumSpecialBySearch(int staffID, String strSearch,
			String strSearchText) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffID", staffID);
		String hql = "select count(*) from TEquipmentManage tem where tem.TStaff.staffId = :staffID";
		if(strSearch=="设备名称"||strSearch.equals("设备名称")){
			if(StringUtils.isNotBlank(strSearchText)){
				params.put("strSearchText", "%"+strSearchText+"%");
				hql += " and tem.equipName like :strSearchText";
			}
		}
		if(strSearch=="设备型号"||strSearch.equals("设备型号")){
			if(StringUtils.isNotBlank(strSearchText)){
				params.put("strSearchText", "%"+strSearchText+"%");
				hql += " and tem.equipModel like :strSearchText";
			}
		}
		if(strSearch=="设备编号"||strSearch.equals("设备编号")){
			if(StringUtils.isNotBlank(strSearchText)){
				params.put("strSearchText", "%"+strSearchText+"%");
				hql += " and tem.equipNumber like :strSearchText";
			}
		}
		if(strSearch=="设备采购人"||strSearch.equals("设备采购人")){
			if(StringUtils.isNotBlank(strSearchText)){
				params.put("strSearchText", "%"+strSearchText+"%");
				hql += " and tem.equipPeople like :strSearchText";
			}
		}
		hql+=" order by tem.selectTime desc";
		long num = equipmentManageDao.count(hql,params);
		return num;
	}

	@Override
	public List<TEquipmentManage> getEquipListSpecialBySearch(int staffID,
			String strSearch, String strSearchText, Page<TEquipmentManage> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffID", staffID);
		String hql = "from TEquipmentManage tem where tem.TStaff.staffId = :staffID";
		if(strSearch != null){
			if(strSearch=="设备名称"||strSearch.equals("设备名称")){
				if(StringUtils.isNotBlank(strSearchText)){
					params.put("strSearchText", "%"+strSearchText+"%");
					hql += " and tem.equipName like :strSearchText";
					}
			}
	
			if(strSearch=="设备型号"||strSearch.equals("设备型号")){
				if(StringUtils.isNotBlank(strSearchText)){
					params.put("strSearchText", "%"+strSearchText+"%");
					hql += " and tem.equipModel like :strSearchText";
				}
			}
			if(strSearch=="设备编号"||strSearch.equals("设备编号")){
				if(StringUtils.isNotBlank(strSearchText)){
					params.put("strSearchText", "%"+strSearchText+"%");
					hql += " and tem.equipNumber like :strSearchText";
				}
			}
			if(strSearch=="设备采购人"||strSearch.equals("设备采购人")){
				if(StringUtils.isNotBlank(strSearchText)){
					params.put("strSearchText", "%"+strSearchText+"%");
					hql += " and tem.equipPeople like :strSearchText";
				}
			}
		}
		hql+=" order by tem.selectTime desc";
		List<TEquipmentManage> list = equipmentManageDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
		return list;
	}
}
