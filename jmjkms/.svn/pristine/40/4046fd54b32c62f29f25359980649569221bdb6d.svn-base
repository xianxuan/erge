package com.jmjk.iservice;

import java.util.Date;
import java.util.List;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.TDoorKnocking;
import com.jmjk.utils.Page;



/**
* 上门随访Service
* 2016年8月1
* @author houzichang
*
*/

public interface IDoorKnockingService {

	/**
	 * 添加上门随访
	 * @param doorknocking 上门随访实体
	 */	 
	public void saveDoorKnocking(TDoorKnocking doorknocking); 
	
	/**
	 * 删除上门随访信息
	 * @param doorknockingID 上门随访Id
	 */
	public void deleteDoorKnocking(int doorknockingID);
	
	/**
	 * 修改上门随访信息
	 * @param doorknocking 上门随访实体
	 */
	public void updateDoorKnocking(TDoorKnocking doorknocking);
	
	/**
	 * 根据查询条件得到TDoorKnocking的列表
	 * @param comHosId  社区医院ID
	 * @param strSearchText   查询内容
	 * @param status  状态[暂缓处理，不处理，已处理，待处理]
	 * @param beginTime  计划时间（开始时间）
	 * @param endTime    计划时间（结束时间）
	 * @param page 分页对象
	 * @return  上门随访列表
	 */
	public List<TDoorKnocking> getTDoorKnockingListBySearch(int comHosId,String strSearchText,String status, Date beginTime,Date endTime,Page<TDoorKnocking> page);
	
	/**
	 * 根据查询条件获得查询总数
	 * @param comHosId  社区医院ID
	 * @param strSearchText  查询内容
	 * @param beginTime  计划时间（开始时间）
	 * @param endTime    计划时间（结束时间）
	 * @param status      状态[暂缓处理，不处理，已处理，待处理]
	 * @return   查询总数
	 */
	public long getTDoorKnockingNumBySearch(int comHosId,String strSearchText,String status,Date beginTime,Date endTime);
	/**
	 * 根据查询获得条件查询列表(平台管理员)
	 * @param strSearchText 查询内容
	 * @param status  状态
	 * @param beginTime  开始时间
	 * @param endTime  结束时间
	 * @param page  分页
	 * @return
	 */
	public List<TDoorKnocking> getDoorKnockingListBySearch(String strSearchText,String status, Date beginTime,Date endTime,Page<TDoorKnocking> page);
    /**
     * 根据查询获得条件查询总数(平台管理员)
     * @param strSearchText  查询内容
     * @param status 状态
     * @param beginTime 开始时间
     * @param endTime 结束时间
     * @return
     */
	public long getDoorKnockingNumBySearch(String strSearchText,String status,Date beginTime,Date endTime);
	/**
     * 根据社区医院ID获得健康教育列表
     * @param comHosId 社区医院ID
     * @return 健康教育列表
     */
	public List<TDoorKnocking> geTDoorKnockingListById(int comHosId);
	/**
	 * 根据上门随访Id获取上门随访详情
	 * @param doorknockinID 上门随访Id
	 * @return 上门随访实体
	 */
	public TDoorKnocking getDoorKnockingById(int doorknockinID);
	
	/**
	 * 根据社区医院id获取上门随访列表
	 * @param comHosId
	 * @param page 分页对象
	 * @return 上门随访列表
	 */
	public List<TDoorKnocking> getDoorKnockingListByComhosId(int comHosId,Page<TDoorKnocking> page);
	
	/**
	 * 根据社区医院ID获得查询总数
	 * @param comHosId 社区医院ID
	 * @return  查询总数
	 */
	public long getDoorKnockingNumByComhosId(int comHosId);
	
	/**
	 *  获得所有上门随访列表，平台Admin
	 * @param page
	 * @return
	 */
	public  List<TDoorKnocking> getDoorKnockingListByAll(Page page);
	
	/**
	 * 获得健康教育总数，平台Admin
	 * @return
	 */
	public  long getDoorKnockingNumByAll();
	public List<TDoorKnocking> getDoorKnockingListForSpecial(int staffID,
			Page<TDoorKnocking> page);
	public long getDoorKnockingNumForSpecial(int staffID);
	/**
	 * 责任医生只能查询自己医生所管辖的区域（数量）
	 * @param staffID
	 * @param strSearchText
	 * @param status
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public long getDoorNumSpecialBySearch(int staffID,String strSearchText,String status,Date beginTime,Date endTime);
	/**
	 * 责任医生只能查询自己医生所管辖的区域（列表）
	 * @param staffID
	 * @param strSearchText
	 * @param status
	 * @param beginTime
	 * @param endTime
	 * @param page
	 * @return
	 */
	public List<TDoorKnocking> getDoorListSpecialBySearch(int staffID,String strSearchText,String status, Date beginTime,Date endTime,Page<TDoorKnocking> page);
	/**
	 * 根据分组获得上门随访数量
	 * @param comHosGroup
	 * @return
	 */
	public long getDoorKnockingNumByGroup(TCommunityHospitalGroup comHosGroup);
	/**
	 * 根据集团获得上门随访的列表
	 * @param comHosGroup
	 * @return
	 */
	public List<TDoorKnocking> getDoorKnockingListByGroup(TCommunityHospitalGroup comHosGroup);
	/**
	 * 集团查询获得数量
	 * @param groupId
	 * @param strSearchText
	 * @param status
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public long getDoorkNumGroupNumBySearch(int groupId,String strSearchText,String status,Date beginTime,Date endTime);
    /**
     * 集团查询获得列表
     * @param groupId
     * @param strSearchText
     * @param status
     * @param beginTime
     * @param endTime
     * @param page
     * @return
     */
	public List<TDoorKnocking> getDoorkListGroupListBySearch(int groupId,String strSearchText,String status, Date beginTime,Date endTime,Page<TDoorKnocking> page);
}
