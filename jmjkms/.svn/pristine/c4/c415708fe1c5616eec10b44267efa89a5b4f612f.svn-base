package com.jmjk.iservice;

import java.util.List;

import com.jmjk.entity.TCount;
import com.jmjk.entity.TRecoveryPlan;

/*package com.jmjk.iservice;



import java.util.List;

import com.jmjk.entity.TCount;


 * 统计分析接口
 * @author liuyichang
 *2016-8-1
 */

public interface IStatisticsService {
	/**
	 * 统计社区医院的信息（总人口数，老人数，患病人数）
	 * @param communityHospitalIdList(社区医院Id)
	 * @return（总人数，老人数，患病人数在一个list中）
	 */
	
	public List<Long> getComHosCount(List<Object> communityHospitalIdList);
	/**
	 * 根据社区Id和疾病名称得到统计数量
	 * @param hosId（社区Id）
	 * @param diseaseName（疾病名称）
	 * @return（TCount实体）
	 */
	public List<TCount> getRecentCount(List<Object> hosId,List<Object> diseaseName);
	/**
	 * 导出统计分析
	 * @param hosId
	 * @return
	 */
	public List<TRecoveryPlan> getAllStatisticalAnalysisForExport(int hosId);
	/**
	 * 设备统计
	 * @param ids
	 * @param devType
	 * @param communityId
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public String getDeviceStatics(String ids,String devType,String communityId,String startTime,String endTime);
	/**
	 * 统计所有设备数量
	 * @param ids
	 * @return
	 */
	public String getTotalNumDevice(String ids);
	
   /* *//**
     * 
     * getGroupCount:统计社区集团的信息（总人口数，老人数，患病人数. <br/>
     * TODO(这里描述这个方法适用条件 – 可选).<br/>
     *
     * @author songhuili
     * @param groupIdList集团Id list
     * @return（总人数，老人数，患病人数在一个list中）
     * @since JDK 1.8
     *//*
    public List<Long> getGroupCount(List<Object> groupIdList);*/
	
   
}
