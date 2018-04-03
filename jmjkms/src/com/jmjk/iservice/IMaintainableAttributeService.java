package com.jmjk.iservice;

import java.util.List;

import com.jmjk.entity.TMaintainableAttribute;
import com.jmjk.entity.TMaintainableEntry;
import com.jmjk.entity.view.VMaintainable;
import com.jmjk.utils.Page;

/**
 * 可维护字段service接口
 * @author xlp&shl
 * 2016-8-1
 *
 */
public interface IMaintainableAttributeService {
	
	/**
	 * 更新可维护字段名称
	 * @param maintainableAttribute 可维护字段实体
	 */
	public void  updateMaintainableAttribute(TMaintainableAttribute maintainableAttribute);
	/**
	 * 得到所有可维护字段
	 * @return  可维护字段视图列表
	 */
	public List<VMaintainable> getMaintainableNameBySearch();
	
	/**
	 * 查询可维护字段            
	 * @param field      查询字段
	 * @param searchText 查询内容
	 * @param  page      分页对象
	 * @return           可维护字段列表
	 */
	public List<TMaintainableAttribute> getMaintainableNameBySearch(String field,String searchText,Page<TMaintainableAttribute> page);
	
	/**
	 * searchText为空时得到总条数，searchText不为空时为所搜索内容的条数
	 * @param field      查询字段
	 * @param searchText 查询内容
	 * @return           长整型
	 */
	public long getMaintainableNumBySearch(String field,String searchText);
	/**
	 * 查询所有可维护字段
	 * @return 可维护字段列表
	 */
	public List<TMaintainableAttribute> getAttributeListByAll(Page<TMaintainableAttribute> page);
	
	/**
	 * 通过可维护字段id得到可维护字段
	 * @param id  可维护字段id
	 * @return    可维护字段实体
	 */
	public TMaintainableAttribute getAttributeById(int id);
	
	/**
	 * 通过编码得到可维护字段
	 * @param code  编码
	 * @return      可维护字段id
	 */
	public int getAttributeByCode(String code);
	
	/**
	 * 通过编码得到数据项列表
	 * @param code  编码
	 * @return      数据项列表
	 */
	public List<TMaintainableEntry> getmEntriesByCode(String code);
	/**
	 * 修改可维护字段名称
	 * @param id    可维护字段id
	 * @param maintainableName  可维护字段名称
	 * @return 可维护字段实体
	 */
	public TMaintainableAttribute updateMaintainableName(int id,String maintainableName);
	/**
	 * 得到不同类型的可维护字段实体
	 * @return  可维护字段列表
	 */
	public List<TMaintainableAttribute> getTMaintainableAttribute();
}
