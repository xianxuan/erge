package com.jmjk.iservice;


import java.util.List;

import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.TEquipmentManage;
import com.jmjk.entity.TMaintenance;
import com.jmjk.utils.Page;


/**
* 设备管理Service
* 2016年8月1
* @author houzichang
*
*/
public interface IEquipmentManageService {
	
	/**
	 * 添加设备信息
	 * @param equipment  设备实体
	 */
	public void saveEquipmentManage(TEquipmentManage equipment);
	
	/**
	 * 删除设备
	 * @param equipmentId 设备Id
	 */
	public void deleteEquipmentManage(int equipmentId);
	
	/**
	 * 修改设备信息
	 * @param equipment  设备实体
	 */
	public void updateEquipmentManage(TEquipmentManage equipment);
	
	/**
	 * 跟据查询条件获得设备列表
	 * @param comHosId   社区医院Id
	 * @param strSearch  查询条件（设备编号、设备名称、设备型号、设备采购人）
	 * @param strSearchText   查询内容
	 * @param Page 分页对象
	 * @return   设备列表
	 */
	public List<TEquipmentManage> getEquipmentManageListBySearch(int comHosId, String strSearch, String strSearchText,Page<TEquipmentManage> page);
	
	/**
	 * 根据查询条件获得查询总数
	 * @param comHosId  社区医院Id
	 * @param strSearch  查询条件（设备编号、设备名称、设备型号、设备采购人）
	 * @param strSearchText  查询内容
	 * @return  查询总数
	 */
	public long getEquipmentManageNumBySearch(int comHosId, String strSearch, String strSearchText);
	/**
	 * 根据查询条件获得查询列表(平台管理员)
	 * @param strSearch 查询条件
	 * @param strSearchText 查询内容
	 * @param page分页
	 * @return
	 */
	public List<TEquipmentManage> getTEquipmentManageListBySearch(String strSearch, String strSearchText,Page<TEquipmentManage> page);
	/**
	 * 根据查询条件获得查询总数(平台管理员)
	 * @param strSearch 查询条件
	 * @param strSearchText 查询内容
	 * @return
	 */
	public long getTEquipmentManageNumBySearch(String strSearch, String strSearchText);
	/**
	 * 根据设备Id获取设备实体
	 * @param equipmentId  设备id
	 * @return  设备实体
	 */
	public TEquipmentManage getEquipmentManageById(int equipmentId);
	
	/**
	 * 根据社区医院id获取设备列表
	 * @param comHosId 社区医院id
	 * @param page 分页对象
	 * @return  设备列表
	 */
	public List<TEquipmentManage> getEquipmentManageListByComhosId(int comHosId,Page<TEquipmentManage> page);

	/**
	 * 根据社区医院获得总数
	 * @param comHosId  社区医院ID
	 * @return  总数
	 */
	public long getEquipmentManageNumByComhosId(int comHosId);
	
	/**
	 * 根据社区医院ID获得设备管理列表
	 * @param comHosId 社区医院ID
	 * @return
	 */
	public List<TEquipmentManage> getEquipmentManageListById(int comHosId);
	/**
     * 根据设备Id获得维修记录列表
     * @param equipmentManageId
     * @param page
     * @return  维修记录列表
     */
	public List<TMaintenance> getMaintenanceListByEquipmentManageId(
			int equipmentManageId, Page page);

	/**
	 * 获得所有设备列表，平台Admin
	 * @param page
	 * @return
	 */
   public List<TEquipmentManage> getEquipmentManageListByAll(Page page);
   
   /**
    * 获得所有设备总数，平台Admin
    * @return
    */
   public long getEquipmentManageNumByAll();
   /**
    * 根据集团获得设备数量
    * @param comHosGroup
    * @return
    */
   public long getEquipmentNumByGroup(TCommunityHospitalGroup comHosGroup);
   /**
    * 根据集团获得设备列表
    * @param comHosGroup
    * @return
    */
   public List<TEquipmentManage> geTEquipmentListByGroup(TCommunityHospitalGroup comHosGroup);
   
   /**
    * 集团查询获得数量
    * @param comHosGroupId
    * @param strSearch
    * @param strSearchText
    * @return
    */
   public long getEquipNumGroupBySearch(int comHosGroupId, String strSearch, String strSearchText);
   
   /**
    * 集团查询获得列表
    * @param comHosGroupId
    * @param strSearch
    * @param strSearchText
    * @param page
    * @return
    */
   public List<TEquipmentManage> getEquipListGroupBySearch(int comHosGroupId, String strSearch, String strSearchText,Page<TEquipmentManage> page);
   /**
    * 医生登陆获得自己所管的人（数量）
    * @param staffID
    * @return
    */
   public long getEquipNumSpecial(int staffID);
   /**
    * 医生登陆获得自己所管的人（列表）
    * @param staffID
    * @param page
    * @return
    */
   public List<TEquipmentManage> getEquipListSpecial(int staffID,Page<TEquipmentManage> page);
   /**
    * 医生查询自己的（数量）
    * @param staffID
    * @param strSearch
    * @param strSearchText
    * @param page
    * @return
    */
   public long getEquipNumSpecialBySearch(int staffID, String strSearch, String strSearchText);
   /**
    * 医生查询自己的（列表）
    * @param staffID
    * @param strSearch
    * @param strSearchText
    * @param page
    * @return
    */
   public List<TEquipmentManage> getEquipListSpecialBySearch(int staffID, String strSearch, String strSearchText,Page<TEquipmentManage> page);

}
