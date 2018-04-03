package com.jmjk.iservice;

import java.util.Date;
import java.util.List;

import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.THealthEdu;
import com.jmjk.utils.Page;

/**
* 健康教育Service
* 2016年8月1
* @author houzichang
*
*/

public interface IHealthEduService {
	
	/**
	 * 添加健康教育活动
	 * @param healthedu
	 */	 
	public void saveHealthEdu(THealthEdu healthedu); 
	
	/**
	 * 删除健康教育活动信息
	 * @param healtheduID 健康教育Id
	 */
	public void deleteHealthEdu(int healtheduID);
	
	/**
	 * 修改健康教育活动信息
	 * @param healthedu
	 */
	public void updateHealthEdu(THealthEdu healthedu);	
	
	/**
	 * 根据查询条件得到THealthEdu的列表
	 * @param comHosId  社区医院ID 
	 * @param  searchCondition
	 * @param searchText  查询内容（负责人 组织者）
	 * @param beginTime  活动时间（开始时间）
	 * @param endTime    活动时间（结束时间）
	 * @param page       分页对象
	 * @return 健康教育活动列表
	 */
	public List<THealthEdu> getHealthEduListBySearch(int comHosId,String searchCondition,String searchText, Date beginTime,Date endTime,Page<THealthEdu> page);
	
	/**
	 * 根据搜索条件获得查询总数
	 * @param comHosId  社区医院ID
	 * @param searchCondition
	 * @param searchCondition 查询内容（负责人 组织者）
	 * @param beginTime  活动时间（开始时间）
	 * @param endTime    活动时间（结束时间）
	 * @return  查询总数
	 */
	public long getHealthEduNumBySearch(int comHosId,String searchCondition,String searchText, Date beginTime,Date endTime);
	
	/**
	 * 根据搜索条件获得查询列表(平台管理员)
	 * @param searchCondition 查询条件
	 * @param searchText  查询内容
	 * @param beginTime  开始时间
	 * @param endTime 结束时间
	 * @param page  分页
	 * @return
	 */
	public List<THealthEdu> getHealthEducationListBySearch(String searchCondition,String searchText, Date beginTime,Date endTime,Page<THealthEdu> page);
	
	/**
	 * 根据查询条件获得查询总数
	 * @param searchCondition  查询条件
	 * @param searchText  查询内容
	 * @param beginTime  开始时间
	 * @param endTime  结束时间
	 * @return
	 */
	public long getHealthEducationNumBySearch(String searchCondition,String searchText, Date beginTime,Date endTime);
	/**
	 * 根据健康教育Id获取健康教育详情
	 * @param healtheduID 健康教育Id
	 * @return  健康教育活动实体
	 */
	public THealthEdu getHealthEduById(int healtheduID);
	
	/**
	 * 根据社区医院id获取健康教育活动列表
	 * @param comHosId 社区医院id
	 * @param 分页对象
	 * @return  健康教育活动列表
	 */
	public List<THealthEdu> getHealthEduListByComhosId(int comHosId, Page<THealthEdu> page);
	
	/**
	 * 根据社区医院ID获得查询总数
	 * @param ComhosId  社区医院ID
	 * @return  查询总数
	 */	 
	public long getHealthEduNumByComhosId(int ComhosId);
	
	/**
	 * 根据社区医院Id获取健康教育列表,无分页
	 * 导出功能使用
	 * @param comHosId  社区医院Id
	 * @return 健康教育列表,无分页
	 */
	public List<THealthEdu> getHealthEdusListForExport(int comHosId);
	
	/**
	 * 获得所有健康教育活动列表,平台Admin
	 * @param page  分页对象
	 * @return  所有健康教育活动列表
	 */
	public List<THealthEdu> getHealthEduListByAll(Page page);
	
	/**
	 * 获得健康教育总数,平台admin
	 * @return  健康教育总数
	 */
	public long getHealthEduNumByAll();
	public  List<THealthEdu> getHealthEduListForSpecial(int staffID,
			Page<THealthEdu> page) ;
	public long getHealthEduNumForSpecial(int staffID) ;
	/**
	 * 医生只负责查询自己医生的（数量）
	 * @param staffID
	 * @param searchCondition
	 * @param searchText
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public long getHealSpecialNumBySearch(int staffID,String searchCondition,String searchText, Date beginTime,Date endTime);
	/**
	 * 医生只负责查询自己医生的（列表）
	 * @param staffID
	 * @param searchCondition
	 * @param searchText
	 * @param beginTime
	 * @param endTime
	 * @param page
	 * @return
	 */
	public List<THealthEdu> getHealSpecialListBySearch(int staffID,String searchCondition,String searchText, Date beginTime,Date endTime,Page<THealthEdu> page);
	/**
	 * 根据集团实体获得健康教育数量
	 * @param comHosGroup
	 * @return
	 */
	public long getHealthEduNumByGroup(TCommunityHospitalGroup comHosGroup);
	
	/**
	 * 根据集团实体获得健康教育列表
	 * @param comHosGroup
	 * @return
	 */
	public List<THealthEdu> getHealthEduListByGroup(TCommunityHospitalGroup comHosGroup);
	/**
	 * 集团查询专用（通过查询获得数量）
	 * @param comHosGroupId
	 * @param searchCondition
	 * @param searchText
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public long getHealthNumGroupBySearch(int comHosGroupId,String searchCondition,String searchText, Date beginTime,Date endTime);
	/**
	 * 集团查询（根据查询获得列表）
	 * @param comHosGroupId
	 * @param searchCondition
	 * @param searchText
	 * @param beginTime
	 * @param endTime
	 * @param page
	 * @return
	 */
	public List<THealthEdu> getHealListGroupBySearch(int comHosGroupId,String searchCondition,String searchText, Date beginTime,Date endTime,Page<THealthEdu> page);
}
