package com.jmjk.iservice;

import java.util.List;

import com.jmjk.entity.TMaintainableEntry;
import com.jmjk.entity.view.VMaintainable;

/**
 * 可维护条目service接口
 * @author xlp&shl
 * 2016-8-2
 *
 */
public interface IMaintainableEntryService {
	
	/**
	 * 添加数据项
	 * @param maintainableEntry  数据项
	 */
	public void addMaintainableEntry(TMaintainableEntry maintainableEntry);
	
	/**
	 * 删除数据项
	 * @param maintainableEntryId 数据项id
	 */
	public void deleteMaintainableEntry(int maintainableEntryId);
	
	/**
	 * 修改数据项
	 * @param maintainableEntry 数据项
	 */
	public void updateMaintainableEntry(TMaintainableEntry maintainableEntry);
	
	/**
	 * 通过可维护字段id查询数据项
	 * @param MaintainableAttributeId 可维护字段id
	 * @return                         数据项列表
	 */
	public List<TMaintainableEntry> getMaintainableEntryById(int MaintainableAttributeId);
	/**
	 * 通过设备的编号获取具体设备
	 * @author 张晓光
	 * @param code 设备的编号
	 * @return 设备视图实体
	 */
	public List<VMaintainable> getMaintainablesByCode(String code);
	/**
	 * 得到所有数据项列表
	 * @return  数据项列表
	 */
	public List<TMaintainableEntry> getMaintainableEntriesListByAll();
	/**
	 * 修改数据项名称
	 * @param id    数据项id
	 * @param entryName  要修改成的数据项名称
	 * @return  数据项实体
	 */
	public TMaintainableEntry updateMaintainableEntry(int id,String entryName);
	/**
	 * 通过数据项名称得到数据项实体
	 * @param name  数据项名称
	 * @return      数据项实体
	 */
	public TMaintainableEntry getMaintainableEntryByName(String name);
	/**
	 * 通过数据项id获得数据项实体
	 * @param entryId 数据项ID
	 * @return   数据项实体
	 */
	public TMaintainableEntry getMaintainableEntryByEntryId(int entryId);
}
