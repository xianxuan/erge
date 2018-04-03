package com.jmjk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.MaintenanceDao;
import com.jmjk.entity.TMaintenance;
import com.jmjk.iservice.IMaintenanceService;
import com.jmjk.utils.Page;

@Controller("maintenanceService")
public class MaintenanceService implements IMaintenanceService{

	@Autowired
	private MaintenanceDao maintenanceDao;
	@Override
	public void saveMaintenance(TMaintenance maintenance) {
		maintenanceDao.Save(maintenance);
	}

	@Override
	public void deleteMaintenance(int maintenanceId) {
		String hql="delete from TMaintenance tm where tm.manitenanceId="+maintenanceId;
		maintenanceDao.delete(hql);
	}

	@Override
	public void updateMaintenance(TMaintenance maintenance) {
		maintenanceDao.update(maintenance);
	}

	@Override
	public List<TMaintenance> getMaintenanceListById(int equipmentId) {
		Map<String, Object>  params = new HashMap<String, Object>();
		params.put("equipmentId", equipmentId);
		String hql = "from TMaintenance tm where tm.TEquipmentManage.equipId = :equipmentId";
		List<TMaintenance> list=maintenanceDao.find(hql,params);		
		return list;
	}
	
	@Override
	public List<TMaintenance> getMaintenanceListById(int equipmentId,Page page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("equipmentId", equipmentId);
		String hql = "from TMaintenance tm where tm.TEquipmentManage.equipId = :equipmentId";
		List<TMaintenance> list=maintenanceDao.find(hql,params,page.getCurrentPage(),page.getPageSize());		
		return list;
	}

	@Override
	public long getMaintenanceNumById(int equipmentId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("equipmentId", equipmentId);
		String hql = "select count(*) from TMaintenance tm where tm.TEquipmentManage.equipId = :equipmentId";
		long count=maintenanceDao.count(hql,params);
		return count;
	}

	@Override
	public TMaintenance getMaintenanceById(int maintenanceId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("maintenanceId", maintenanceId);
		String hql = "from TMaintenance tm where tm.manitenanceId = :maintenanceId";
		TMaintenance tMaintenance=maintenanceDao.Get(hql,params);		
		return tMaintenance;
	}

	@Override
	public List<TMaintenance> getMaintenanceListByAll(Page page) {
		String hql = "from TMaintenance ";
		List<TMaintenance> list = maintenanceDao.find(hql,page.getCurrentPage(),page.getPageSize());
		return list;
	}

	@Override
	public long getMaintenanceNumByAll() {
		String hql = "select count(*) from TMaintenance";
		long count = maintenanceDao.count(hql);
		return count;
	}

}
