package com.jmjk.iservice;

import java.util.List;

import com.jmjk.entity.TRole;

/**
 * 角色service接口
 * @author xlp&shl
 * 2016-8-2
 *
 */
public interface IRoleService {
	
	/**
	 * 新增角色
	 * @param role  角色实体
	 */
	public void addRole(TRole role); 
	
	/**
	 * 编辑角色权限
	 * @param role  角色实体
	 */
	public void updateRole(TRole role);

	/**
	 * 删除角色
	 * @param roleId  角色id
	 */
	public void deleteRole(int roleId);
	
	/**
	 * 得到所有角色
	 * @return   角色列表
	 */
	public List<TRole> getAllRole(); 
	
	/**
	 * 根据id获得角色实体
	 * @param roleId  角色id
	 * @return        角色实体
	 */
	public TRole getRoleById(int roleId);
	
	/**
	 * 根据角色名字获得角色实体
	 * @param roleName 角色名字
	 * @return   角色实体
	 */
	public TRole getRoleByRoleName(String roleName);
	
	/**
	 * 用于编辑角色的时候,判断该角色的名字是否已占用
	 * @param name  角色名称
	 * @param id  角色id
	 * @return  角色实体
	 */
	public TRole getRoleByName(String name,int id);
	/**
	 * 通过医院id,得到角色实体（苏东航专用）。用于检查是否存在医院id为0的实体，使得特殊医生有实体，以便形成vstaffhos,用于修改、详情健康档案责任医生的回显
	 * @param hosId  医院id
	 * @return 角色实体
	 */
	public TRole getRoleByHosIdForSu(int hosId);
	
}
