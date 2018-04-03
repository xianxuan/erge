package com.jmjk.iservice;

import java.util.List;

import com.jmjk.entity.TPower;

public interface IPowerService {
	
	/**
	 * 从数据库中读取权限信息
	 * @return
	 */
	public List<TPower> getPowers();
	
	/**
	 * * 由二级菜单的编码得到一个一级菜单的实体
	 * @param code  二级菜单编码
	 * @return 返回一级菜单的实体
	 */
	public TPower getTPowerFirstBySecond(String code);

}
