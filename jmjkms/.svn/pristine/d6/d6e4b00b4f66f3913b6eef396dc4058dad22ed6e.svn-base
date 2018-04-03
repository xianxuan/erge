package com.jmjk.iservice;



import java.util.List;

import com.jmjk.entity.TMaintenance;
import com.jmjk.utils.Page;

/**
* 设备维修记录Service接口
* 2016年8月1
* @author houzichang
*
*/
public interface IMaintenanceService {
	
	/**
	 * 添加设备维修记录
	 * @param maintenance  维修记录实体
	 */
	public void saveMaintenance(TMaintenance maintenance); 
	
	/**
	 * 删除维修记录
	 * @param maintenanceID 维修记录ID
	 */
	public void deleteMaintenance(int maintenanceID);
	
	/**
	 * 修改设备维修记录
	 * @param maintenance   维修记录实体
	 */	
	public void updateMaintenance(TMaintenance maintenance);
	
	/**
	 * 查看某个设备维修记录
	 * @param equipmentId 设备Id
	 * @return  某设备维修记录
	 */
	public List<TMaintenance> getMaintenanceListById(int equipmentId);
	
	/**
	 * 根据设备ID获得总数
	 * @param equipmentId 设备ID
	 * @return  总数
	 */
	public long getMaintenanceNumById(int equipmentId);

	/**
	 * 根据维修记录Id获得维修记录实体
	 * @param manitenanceId
	 * @return
	 */
	public TMaintenance getMaintenanceById(int manitenanceId);
	
	/**
	 * 查看某个设备维修记录
	 * @param equipmentId 设备Id
	 * @param page 分页对象
	 * @return  某设备维修记录
	 */
	public List<TMaintenance> getMaintenanceListById(int equipmentId,Page page);
	
	/**
	 * 获得所有维修记录列表，平台Admin
	 * @param page
	 * @return
	 */
	public List<TMaintenance> getMaintenanceListByAll(Page page);
	
	/**
	 * 获得所有维修记录总数，平台Admin
	 * @return
	 */
	public long getMaintenanceNumByAll();
}
