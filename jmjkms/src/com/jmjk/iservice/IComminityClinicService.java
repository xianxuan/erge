package com.jmjk.iservice;

import java.util.Date;
import java.util.List;

import com.jmjk.entity.TComminityClinic;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.utils.Page;


/**
* 社区义诊Service
* 2016年8月1
* @author houzichang
*
*/
public interface IComminityClinicService {

	/**
	 * 添加社区义诊信息
	 * @param comminityclinic 社区义诊实体
	 */
	public void saveComminityClinic(TComminityClinic comminityclinic);
	
	/**
	 * 删除社区义诊信息
	 * @param comminityclinicID 社区义诊Id
	 */
	public void deleteComminityClinic(int comminityclinicID);
	
	/**
	 * 修改社区义诊信息
	 * @param comminityclinic 社区义诊实体
	 */
	public void updateComminityClinic(TComminityClinic comminityclinic);
	
	/**
	 * 根据查询条件获得社区义诊列表
	 * @param comHosID 社区医院ID
	 * @param status  状态[暂缓处理，不处理，待处理，已处理]
	 * @param beginTime   计划时间（开始时间）
	 * @param endTime    计划时间（结束时间）
	 * @param Page   分页对象
	 * @return      社区义诊列表
	 */
	public List<TComminityClinic> getComminityClinicListBySearch(int comHosID,String status,Date beginTime,Date endTime,Page<TComminityClinic> page);
	
	/**
	 * 根据查询条件获得查询总数
	 * @param comHosID  社区医院ID
	 * @param status 状态[暂缓处理，不处理，待处理，已处理]
	 * @param beginTime  计划时间（开始时间）
	 * @param endTime  计划时间（结束时间）
	 * @return  查询总数
	 */
	public long getComminityClinicNumBySearch(int comHosID,String status,Date beginTime,Date endTime);
	/**
	 * 根据查询条件获得查询列表(平台管理员)
	 * @param status 状态
	 * @param beginTime 开始时间
	 * @param endTime结束时间
	 * @param page分页
	 * @return
	 */
	public List<TComminityClinic> getTComminityClinicListBySearch(String status,Date beginTime,Date endTime,Page<TComminityClinic> page);
	/**
	 * 根据查询条件获得查询总数(平台管理员)
	 * @param status 状态
	 * @param beginTime开始时间
	 * @param endTime结束时间
	 * @return
	 */
	public long getTComminityClinicNumBySearch(String status,Date beginTime,Date endTime);
	/**
	 * 根据社区义诊Id获取社区义诊详情
	 * @param comminityclinicID 社区义诊ID
	 * @return 社区义诊实体
	 */
	public TComminityClinic getComminityClinicById(int comminityclinicID);
	
	/**
	 * 根据社区医院ID获得社区义诊列表
	 * @param comHosID  社区医院ID
	 * @param 分页对象
	 * @return 社区义诊列表
	 */
	public List<TComminityClinic> getComminityClinicBycomHosID(int comHosID,Page<TComminityClinic> page);
	
	/**
	 * 根据社区医院ID获得社区义诊列表
	 * @param comHosID 社区医院ID
	 * @return 社区义诊列表
	 */
	public List<TComminityClinic> getComminityClinicListById(int comHosID);
	/**
	 * 根据社区医院ID获得查询总数
	 * @param comHousID  社区医院ID
	 * @return 查询总数
	 */
	public long  getComminityClinicNumBycomHosID(int comHousID);
	
	/**
	 * 获得所有社区义诊列表，平台Admin
	 * @param page
	 * @return
	 */
	public List<TComminityClinic> getComminityClinicListByAll(Page page);
	
	
	/**
	 * 获得所有社区义诊总数，平台Admin
	 * @return
	 */
	public long getTComminityClinicNumByAll();
	public List<TComminityClinic> getComminityClinicForSpecial(int staffID,
			Page<TComminityClinic> page) ;
	public long getComminityClinicNumForSpecial(int staffID);
	/**
	 * 医生自己只能插自己管的（数量）
	 * @param staffID
	 * @param status
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public long getCommiSpecialNumBySearch(int staffID,String status,Date beginTime,Date endTime);
	/**
	 * 医生自己只能插自己管的（列表）
	 * @param staffID
	 * @param status
	 * @param beginTime
	 * @param endTime
	 * @param page
	 * @return
	 */
	public List<TComminityClinic> getCommiSpecialListBySearch(int staffID,String status,Date beginTime,Date endTime,Page<TComminityClinic> page);
	/**
	 * 根据集团获得社区义诊数量
	 * @param comHosGroup
	 * @return
	 */
	public long getComminityNumByGroup(TCommunityHospitalGroup comHosGroup);
	/**
	 * 根据集团获得社区义诊列表
	 * @param comHosGroup
	 * @return
	 */
	public List<TComminityClinic> getComminityClinListByGroup(TCommunityHospitalGroup comHosGroup);
    /**
     * 集团查询获得数量
     * @param comHosGroupID
     * @param status
     * @param beginTime
     * @param endTime
     * @return
     */
	public long getCommiNumGroupBySearch(int comHosGroupID,String status,Date beginTime,Date endTime);
    /**
     * 集团查询获得列表
     * @param comHosGroupID
     * @param status
     * @param beginTime
     * @param endTime
     * @param page
     * @return
     */
	public List<TComminityClinic> getCommiListGroupBySearch(int comHosGroupID,String status,Date beginTime,Date endTime,Page<TComminityClinic> page);
}
