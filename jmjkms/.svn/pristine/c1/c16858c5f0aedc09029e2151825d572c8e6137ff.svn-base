package com.jmjk.iservice;

import java.util.List;



import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.THealthFile;
import com.jmjk.entity.TStaff;
import com.jmjk.utils.Page;

/**
 * 社区医院Service接口 
 * @author xlp&shl
 * 2016-8-2
 *
 */
public interface ICommunityHospitalService {
	
	 /**
	  * 保存社区医院实体
	  * @param communityHospital  社区医院实体
	  */
	public void saveCommunityHospital(TCommunityHospital communityHospital);
	
	/**
	 * 删除社区医院
	 * @param comHosId 社区医院ID
	 */
	public void deleteCommunityHospital(int comHosId);
	
	/**
	 * 更新社区医院
	 * @param communityHospital 社区医院实体
	 */
	public void updateCommunityHospital(TCommunityHospital communityHospital);
	
	/**
	 * 
	 * updateCommunityHospital:更新社区医院的同时也更新社区负责人在员工表里的记录. <br/> 
	 * TODO(这里描述这个方法适用条件 – 可选).<br/> 
	 * @author xuleping
	 * @param communityHospital
	 * @param staff 
	 * @since JDK 1.8
	 */
	public void updateCommunityHospital(TCommunityHospital communityHospital,TStaff staff);

	/**
	 * 根据社区医院Id获取社区医院实体
	 * @param comHosId 社区医院ID
	 * @return 社区医院实体
	 */
	public TCommunityHospital getCommunityHospitalById(int comHosId);
	
	/**
	 * 获得根据社区医院 Id列表 获取社区医院实体列表
	 * @param communityHosIdList 社区医院id列表
	 * @return
	 */
	public List<TCommunityHospital> getCommunityHospitalByID(List<Object> communityHosIdList);
	/**
	 * 通过登录名获取社区医院实体,用于查询登录名是否存在,不允许有相同的登录名
	 * @param login  登录名
	 * @return       医院实体
	 */
	public TCommunityHospital getCommunityHospitalByLogin(String login);
	
	/**
     * 用于查询该电话是否存在,不允许有相同的电话
     * @param phone  电话
     * @return       医院实体
     */
    public TCommunityHospital getCommunityHospitalByPhone(String phone);
    
    /**
     * 用于查询该编码是否存在,不允许有相同的编码
     * @param code  编码
     * @return       医院实体
     */
    public TCommunityHospital getCommunityHospitalByCode(String code);
	
	/**
	 * 查询医院
	 * @param field       查询字段
	 * @param searchText  搜索内容为空时，显示所有社区医院；不为空时根据搜索内容显示
	 * @param page        分页对象
	 * @return            医院实体
	 */
	public List<TCommunityHospital> getHospitalListBySearch(String field,String searchText,Page<TCommunityHospital> page);
	
	/**
	 * 得到所有的社区医院，不分页
	 * @return      医院实体列表
	 */
	public List<TCommunityHospital> getAllHospitals();
	
	/**
	 * searchText为空时得到总条数，searchText不为空时为所搜索内容的条数
	 * @param field      查询字段
	 * @param searchText 搜索内容
	 * @return           查询所得条数
	 */
	public long getHospitalNumBySearch(String field,String searchText);
	
	/**
	 * 负责人恢复密码
	 * @param comHosId  社区医院id
	 */
	public void changePassword(int comHosId);
	
	/**
	 * 改变社区负责人状态
	 * @param comHosId 社区医院id
	 * @param state 改变后的状态
	 */
	public void changeState(int comHosId,String state);
	
	/***
	 * 得到所有状态为启用的医院
	 * @return 医院实体列表
	 */
	public List<TCommunityHospital> getAllQiYongHos();
	
	/**
	 * 通过员工的id 获取他所在的社区医院
	 * @author 张晓光
	 * @param staffId 员工id
	 * @return  医院实体
	 */
	public TCommunityHospital getCommunityHospitalByStaffId(int staffId,int healthFileId);

	/**
	 * 根据社区医院名字获取社区医院实体,用于判断次医院名是否已存在,不允许有重复的医院名
	 * @param name 社区医院名字
	 * @return  社区医院实体
	 */
	public TCommunityHospital getCommunityHospitalByName(String name);
	
	/**
	 * 查询列出平台管理员
	 * @return 社区医院实体列表
	 */
	public List<TCommunityHospital> getWuShiSi();
	
	/**
	 * 判断Id是否为社区医院Id
	 * @param communityHostpitalId  社区医院Id
	 * @return  为社区医院true,不在社区医院false
	 */
	public Boolean getCommunityHospitalIsContain(int communityHostpitalId);
	
	/**
	 * 查询所有社区医院列表,提供E暖家接口
	 * @param currentPage  当前页
	 * @param pageSize     显示条数
	 * @return             社区医院列表
	 */
	public List<TCommunityHospital> getHospitalByAll(int currentPage, int pageSize);
	
	/**
	 * 查询所有社区医院数量,提供E暖家接口
	 * @param currentPage  当前页
	 * @param pageSize     显示条数
	 * @return             社区医院数量
	 */
	public int getHospitalNumByAll(int currentPage, int pageSize);
	/**
	 * 
	 * getCommunityHospitalByStaffId:(根据当前登录员工查询起当前所在社区). <br/>
      
	 * @author 赖清发   2016 10 30  2511695066@qq.com
	 * @param staffId  员工id
	 * @return
	 * @since JDK 1.6
	 */

	public TCommunityHospital getCommunityHospitalByStaffId(int staffId) ;
		
}
