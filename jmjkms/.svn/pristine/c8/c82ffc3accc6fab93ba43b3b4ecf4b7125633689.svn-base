package com.jmjk.iservice;

import java.util.List;

import com.jmjk.entity.TRights;

/**
 * 权限service接口
 * @author xlp&shl
 * 2016-8-2
 */
public interface IRightsService {
	
	/**
	 * 保存权限
	 * @param rights 权限实体
	 */
	public void saveRights(TRights rights);
	
	/**
	 * 清空角色的权限
	 * @param roleId 角色id
	 */
	public void deleteRights(int roleId);
	
	/**
	 * 得到所有权限（平台管理员）
	 * @return     权限列表
	 */
	public List<TRights> getAllRights();
	
	/**
	 * 根据角色Id获得权限列表
	 * @param roleId  角色id
	 * @return        权限列表
	 */
	public List<TRights> getAllRights(int roleId);
	
	/**
	 * 通过权限id获得权限实体
	 * @param rightsId  权限id
	 * @return          权限实体
	 */
	public TRights getRightsById(int rightsId);
	
	/**
	 * 当员工登录后，根据员工所拥有的角色，判断他是否具有查看该功能模块的权限，true表示具有该权限,false表示不具有权限
	 * @param staffId  员工id
	 * @param rightValue  权限值
	 * @return  true表示具有该权限,false表示不具有权限
	 */
	public boolean ifHaveRights(int staffId,String rightsCode,int rightValue);
	
	/**
	 * 当员工登录后,根据员工id获取其权限,并显示其对应页面
	 * @param staffId
	 * @return        权限列表
	 */
	public List<TRights> getAllRightsByStaffId(int staffId);
	
	/**
	 * 根据栏目编码获得该栏目的权限值
	 * @param staffId    员工Id
	 * @param columnCod  栏目编码
	 * @return 栏目的权限值
	 */
	public int getStaffValueByColumnCod(int staffId,String columnCod);
	
	/**
	 * 根据员工id获得栏目权限编码
	 * @param staffId  员工Id
	 * @return  员工所有授权栏目编码
	 */
	public List<String> getAllRightValueByStaffId(int staffId);
}
