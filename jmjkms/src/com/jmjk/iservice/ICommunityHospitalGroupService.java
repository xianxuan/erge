package com.jmjk.iservice;

import java.util.List;

import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.utils.Page;

public interface ICommunityHospitalGroupService {
	/**
	  * 保存社区集团实体
	  * @param communityHospital  社区集团实体
	  */
	public void saveComHosGroup(TCommunityHospitalGroup comHosGroup);
	
	/**
	 * 删除社区集团
	 * @param comHosId 社区集团ID
	 */
	public void deleteComHosGroup(int groupId);
	
	/**
	 * 更新社区集团
	 * @param communityHospital 社区集团实体
	 */
	public void updateComHosGroup(TCommunityHospitalGroup comHosGroup);

	/**
	 * 根据社区集团Id获取社区集团实体
	 * @param comHosId 社区集团ID
	 * @return 社区集团实体
	 */
	public TCommunityHospitalGroup getComHosGroupByGroupId(int groupId);
	
	/**
	 * 获得根据社区集团 Id列表 获取社区集团实体列表
	 * @param communityHosIdList 社区集团id列表
	 * @return
	 */
	public List<TCommunityHospitalGroup> getComHosGroupListByGroupIdList(List<Object> communityHosIdList);
	/**
	 * 通过登录名获取社区集团实体,用于查询登录名是否存在,不允许有相同的登录名
	 * @param login  登录名
	 * @return       集团实体
	 */
	public TCommunityHospitalGroup getComHosGroupByLogin(String login);
	
	/**
     * 通过电话获取社区集团实体,用于查询电话是否存在,不允许有相同的电话
     * @param phone  电话
     * @return       集团实体
     */
    public TCommunityHospitalGroup getComHosGroupByPhone(String phone);
    
	/**
	 * 查询集团
	 * @param field       查询字段
	 * @param searchText  搜索内容为空时，显示所有社区集团；不为空时根据搜索内容显示
	 * @param page        分页对象
	 * @return            集团实体
	 */
	public List<TCommunityHospitalGroup> getGroupListBySearch(String field,String searchText,Page<TCommunityHospitalGroup> page);
	
	/**
	 * 得到所有的社区集团，不分页
	 * @return      集团实体列表
	 */
	public List<TCommunityHospitalGroup> getAllGroups();
	
	/**
	 * searchText为空时得到总条数，searchText不为空时为所搜索内容的条数
	 * @param field      查询字段
	 * @param searchText 搜索内容
	 * @return           查询所得条数
	 */
	public long getGroupNumBySearch(String field,String searchText);
	
	/**
	 * 负责人恢复密码
	 * @param comHosId  社区集团id
	 */
	public void changePassword(int groupId);
	
	/**
	 * 改变社区负责人状态
	 * @param comHosId 社区集团id
	 * @param state 改变后的状态
	 */
	public void changeState(int groupId,String state);
	
	/***
	 * 得到所有状态为启用的集团
	 * @return 集团实体列表
	 */
	public List<TCommunityHospitalGroup> getAllQiYongGroups();
	
	/**
	 * 根据社区集团名字获取社区集团实体,用于判断次集团名是否已存在,不允许有重复的集团名
	 * @param name 社区集团名字
	 * @return  社区集团实体
	 */
	public TCommunityHospitalGroup getComHosGroupByName(String name);
	
	/**
	 * 根据社区集团获得该集团下的医院列表
	 * @return
	 */
	public List<TCommunityHospital> getComHosListByGroup(TCommunityHospitalGroup tCommunityHospitalGroup);
		
	/**
	 * 
	 *根据社区集团获得该集团下的医院列表,分页
	 * @author songhuili
	 * @param group
	 * @param page
	 * @return
	 * @since JDK 1.8
	 */
	public List<TCommunityHospital> getComHosListByGroupByPage(TCommunityHospitalGroup group,Page<TCommunityHospital> page);
	
	/**
	 * 
	 * saveCopyComHosGroup:集团增加本集团账号(此方法只有isCopy=0的集团实体可以用). <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 *
	 * @author songhuili
	 * @param tCommunityHospitalGroup 社区集团实体
	 * @since JDK 1.8
	 */
	public void saveCopyComHosGroup(TCommunityHospitalGroup tCommunityHospitalGroup);

	/**
	 * 
	 * getRealComHosGroup:如果根据当前社区集团是copy的,那么返回他一开始的那个集团;否则返回当前社区集团. <br/>
	 * TODO(这里描述这个方法适用条件 – 可选).<br/>
	 *
	 * @author songhuili
	 * @param comHosGroup 集团实体
	 * @return
	 * @since JDK 1.8
	 */
	public TCommunityHospitalGroup getRealComHosGroup(TCommunityHospitalGroup comHosGroup);
}
