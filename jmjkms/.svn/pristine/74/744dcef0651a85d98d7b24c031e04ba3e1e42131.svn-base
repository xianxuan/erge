package com.jmjk.iservice;

import java.util.Date;
import java.util.List;





import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.TKnowledgeLecture;
import com.jmjk.pojo.KnowledgeLecture;
import com.jmjk.utils.Page;

/**
* 知识讲座Service
* 2016年8月1
* @author houzichang
*
*/

public interface IKnowledgeLectureService {

	/**
	 * 添加知识讲座
	 * @param knowledgelecture 知识讲座实体
	 */	 
	public void saveKnowledgeLecture(TKnowledgeLecture knowledgelecture);
	
	/**
	 * 删除知识讲座信息
	 * @param knowledgelectureID 知识讲座Id
	 */
	public void deleteKnowledgeLecture(int knowledgelectureID);
	
	/**
	 * 修改知识讲座信息
	 * @param knowledgelecture  知识讲座实体
	 */
	public void updateKnowledgeLecture(TKnowledgeLecture knowledgelecture);
	
	/**
	 * 根据查询条件获得知识讲座的列表
	 * @param comHosId  社区医院ID
	 * @param strSearchText 查询内容   讲座名称
	 * @param beginTime  计划时间（开始时间）
	 * @param endTime    计划时间（结束时间）
	 * @param status 状态[暂缓处理，待处理，已处理，待处理]
	 * @param  Page 分页对象
	 * @return   知识讲座列表
	 */
	public List<TKnowledgeLecture> getKnowledgeLectureListBySearch(int comHosId,String strSearchText,String status,Date beginTime,Date endTime,Page<TKnowledgeLecture> page);
	
	/**
	 * 根基查询条件获得查询总数
	 * @param comHosId  社区医院ID
	 * @param strSearchText  查询内容   讲座名称
	 * @param beginTime 计划时间（开始时间）
	 * @param endTime   计划时间（结束时间）
	 * @param status 状态[暂缓处理，待处理，已处理，待处理]
	 * @return  查询总数
	 */
	public long getKnowledgeLectureNumBySearch(int comHosId,String strSearchText,String status,Date beginTime,Date endTime);
	/**
	 * 根据查询条件获得知识讲座的列表(平台管理员)
	 * @param strSearchText 查询内容
	 * @param status 状态
	 * @param beginTime 开始时间
	 * @param endTime 结束时间
	 * @param page 分页
	 * @return
	 */
	public List<TKnowledgeLecture> getTKnowLedgeLectureListBySearch(String strSearchText,String status,Date beginTime,Date endTime,Page<TKnowledgeLecture> page);
	/**
	 * 根据查询条件获得知识讲座的总数(平台管理员)
	 * @param strSearchText 查询内容
	 * @param status 状态
	 * @param beginTime 开始时间
	 * @param endTime 
	 * @return
	 */
	public long getTKnowLedgeLectureNumBySearch(String strSearchText,String status,Date beginTime,Date endTime);
	/**
	 * 根据知识讲座Id获取知识讲座详情
	 * @param knowledgelectureID 知识讲座Id
	 * @return  知识讲座实体
	 */
	public TKnowledgeLecture getKnowledgeLectureById(int knowledgelectureID);
	
	/**
	 * 根据社区医院ID获得知识讲座列表
	 * @param comHosId 社区医院ID
	 * @param page 分页对象
	 * @return 知识讲座列表
	 */
    public List<TKnowledgeLecture> getKnowledgeLectureListByComhosId(int comHosId,Page<TKnowledgeLecture> page);

    /**
     * 根据社区医院ID获得知识讲座列表
     * @param comHosId 社区医院ID
     * @return 知识讲座列表
     */
    public List<TKnowledgeLecture> getKnowledgeLectureListById(int comHosId);
    /**
     * 根据社区医院ID获得查询总数
     * @param comHosId 社区医院ID
     * @return  查询总数
     */
    public long getKnowledgeLectureNumByComhosId(int comHosId);
    
    /**
     * 获得所有知识讲座列表，平台Admin
     * @param page
     * @return
     */
    public List<TKnowledgeLecture> geKnowledgeLectureListByAll(Page page);
    
    /**
     * 获得所有知识讲座总数，平台Admin
     * @return
     */
    public long getKnowledgeLectureNumByAll();
    public List<TKnowledgeLecture> getKnowledgeLectureListForSpecial(
			int staffID, Page<TKnowledgeLecture> page);
    public long getKnowledgeLectureNumForSpecial(int staffID);
    /**
     * 医生自己查到自己的（数量）
     * @param staffID
     * @param strSearchText
     * @param status
     * @param beginTime
     * @param endTime
     * @return
     */
    public long getKnowleSpecialNumBySearch(int staffID,String strSearchText,String status,Date beginTime,Date endTime);
    /**
     * 医生自己查到自己的（列表）
     * @param staffID
     * @param strSearchText
     * @param status
     * @param beginTime
     * @param endTime
     * @param page
     * @return
     */
    public List<TKnowledgeLecture> getKnolSpecialListBySearch(int staffID,String strSearchText,String status,Date beginTime,Date endTime,Page<TKnowledgeLecture> page);
    /**
     * 根据集团获得知识讲座数量
     * @param comHosGroup
     * @return
     */
    public long getKnowledgeNUmByGrop(TCommunityHospitalGroup comHosGroup);
    /**
     * 根据集团获得知识讲座列表
     * @param comHosGroup
     * @return
     */
    public List<TKnowledgeLecture> getKnowledgeListByGrop(TCommunityHospitalGroup comHosGroup);
    /**
     * 集团查询获得数量
     * @param comHosGroupId
     * @param strSearchText
     * @param status
     * @param beginTime
     * @param endTime
     * @return
     */
    public long getKnowledNumGroupBySearch(int comHosGroupId,String strSearchText,String status,Date beginTime,Date endTime);
    /**
     * 集团查询获得列表
     * @param comHosGroupId
     * @param strSearchText
     * @param status
     * @param beginTime
     * @param endTime
     * @param page
     * @return
     */
    public List<TKnowledgeLecture> getKnowledListGroupBySearch(int comHosGroupId,String strSearchText,String status,Date beginTime,Date endTime,Page<TKnowledgeLecture> page);
}
