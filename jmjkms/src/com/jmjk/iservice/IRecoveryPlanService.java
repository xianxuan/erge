package com.jmjk.iservice;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.jmjk.entity.*;
import com.jmjk.utils.Page;

/**
 * 康复计划接口
 * @author ykx
 * 2016-08-01
 */
public interface IRecoveryPlanService {
	
	/**
	 * 导出康复计划通过社区医院ID
	 * @param hosId
	 * @return
	 */
	public List<TRecoveryPlan> getAllRecoveryPlanForExport(int hosId) ;
	
	/*
	 * 统计分析的按时间查询
	 */
	public long countBySearch(String select,Date fromDate, Date toDate, int sqId,int flag);

	/**
	 * 通过社区Id得到所有的康复计划
	 * @param page(分页)
	 * @param comHosId（当前社区Id）
	 * @return（当前社区的所有康复计划）
	 */
	public List<TRecoveryPlan> getAllRecoveryPlanByHosId(Page<TRecoveryPlan> page,int comHosId,int flag);
	/**
	 * 得到该社区下所有的康复计划数量
	 * @param hosId（社区医院Id）
	 * @return(该社区下的康复计划的总数)
	 */

	public long getAllRecoveryPlanCountByHosId(int comHosId,int flag);

	/**
	 * 统计分析页通过当前社区Id 和时间段查询统计分析结果
	 * @param page
	 * @param beginDate
	 * @param overDate
	 * @param comHosId（当前社区Id）
	 * @return
	 */
	public List<TRecoveryPlan> getStatisticalAnalysisByDate(String select,Page<TRecoveryPlan> page,Date fromDate,Date toDate,int comHosId,int flag);
	/**
	 * 根据康复计划id得到康复计划实体
	 * @param id(康复计划id)
	 * @return(康复计划实体)
	 */
	public TRecoveryPlan getRecoveryPlanById(int id);
	/**
	 * 查询康复计划(根据传回来的查询条件)
	 * @param plan(将查询条件封装到实体里传回来)
	 * @param page
	 * @return(康复计划实体)
	 */
	public List<TRecoveryPlan> getRecoveryPlanByCon(TRecoveryPlan plan,Page<TRecoveryPlan> page);	
	/**
	 * 根据康复计划id得到TRecoveryOld实体
	 * @param id(康复计划id)
	 * @return（RecoveryOld实体）
	 */
	public List<TRecoveryOld> getRecoveryOldById(int id);	
	
	/**
	 * 根据查询条件得到查询数量
	 * @param plan（查询条件）
	 * @return（根据查询条件查出来的康复计划数量）
	 */
	public long getRecoveryPlanCountByCon(TRecoveryPlan plan);
	/**
	 * 添加康复计划
	 * @param plan
	 * @return (预取的康复 计划Id)
	 */
	public int addRecoveryPlan(TRecoveryPlan plan);
	/**
	 * 康复计划中添加老人
	 * @param recoveryOld
	 */
	public void addRecoveryOld(List<TRecoveryOld> recoveryOld);
	
	/**
	 * 通过id删除康复计划
	 * @param id（康复计划Id）
	 */
	public void deleteRecoveryPlanById(int id);
	/**
	 * 根据id批量删除康复计划
	 * @param idList（康复计划Id）
	 */
	public void deleteAnyRecoveryPlan(List<Object> idList);
	/**
	 * 根据康复计划id删除关系表
	 * @param recoveryPlanId(康复计划Id)
	 */
	public void deleteAnyRecoveryOld(int recoveryPlanId);
	/**
	 *  修改康复计划
	 * @param plan(康复计划实体)
	 */
	public void updateRecoveryPlan(TRecoveryPlan plan);
	/**
	 * 根据id更改康复计划的状态
	 * @param id（康复计划Id）
	 */
	public void changeStatus(int id,String statu);
	/**
	 * 检查康复方案下是否有康复计划
	 * @param id（康复方案Id）
	 * @return
	 */
	public boolean checkRecoveryScheme(int id);
	/**
	 * 检查康复计划下是否有老人
	 * @param id（康复计划Id）
	 * @return
	 */
	public boolean checkRecoveryPlan(int id);
	/**
	 *  通过档案id获取其康复方案
	 *  @author 张晓光
	 * @param healthFileId 档案id
	 * @param page 分页
	 * @return 康复方案列表
	 */
	public List<TRecoveryOld> getRecoveryPlansByHealthFileId(int healthFileId,String disease,Page<TRecoveryOld> page);
	/**
	 * 通过档案id获取其康复方案的数量
	 * @author 张晓光
	 * @param healthFileId 档案id
	 * @return 康复方案列表数量
	 */
	public long countRecoverPlanByHealthFileId(int healthFileId,String disease);
	/**
	 * 查询符合条件的康复方案
	 * @author 张晓光
	 * @param healthFileId 档案id
	 * @param disease 疾病名称
	 * @param page 分页
	 * @param startTime 开始时间
	 * @param endTime 结束时间
	 * @param planName 计划名称
	 * @param planState 计划状态
	 * @return 康复方案列表
	 */
	public List<TRecoveryOld> getRecoveryOldList(int healthFileId,String disease,Page<TRecoveryOld> page,Date startTime,Date endTime,String planName,int planState);
	/**
	 * 查询符合条件的康复方案数量
	 * @author 张晓光
	 * @param healthFileId
	 * @param disease
	 * @param startTime
	 * @param endTime
	 * @param planName
	 * @param planState
	 * @return
	 */
	public long countRecoveryOldList(int healthFileId,String disease,Date startTime,Date endTime,String planName,int planState);
	/**
	 * 预取主键
	 * @return
	 */
	public Integer getNextId();
	
	
	//zdj
	/**
	 * 保存健康计划老人关系表实体，（指某个老人）
	 * @param reold
	 */
	public void addRecoveryOld(TRecoveryOld reold);

	/**
	 * 判断康复计划是否有重名
	 * @param comHos
	 * @param planName
	 * @return
	 */
	public long checkName(int comHos,String planName);

	/**
	 * 假删
	 * @param planId 康复计划id
	 */
	public void updatePlanIsDelete(int planId);
	/**
	 * 用于地址栏校验
	 * @param healthFileId 档案id
	 * @param recoveryPlanId 康复计划id
	 * @return
	 */
	public boolean checkHealthIdPlanId(int healthFileId, int recoveryPlanId,String diseaseName);

	
	
}
