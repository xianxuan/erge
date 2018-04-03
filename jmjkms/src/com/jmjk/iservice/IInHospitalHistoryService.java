package com.jmjk.iservice;

import java.util.Date;
import java.util.List;

import com.jmjk.entity.TInHospitalHistory;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.view.VInHospitalHistory;
import com.jmjk.utils.Page;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.SearchBeanSU;

public interface IInHospitalHistoryService {
	/**
	 * 添加住院史记录
	 * @param inhospitalhistory  住院史记录
	 */
	public void saveInHospitalHistory(TInHospitalHistory inhospitalhistory);

	/**
	 * 根据住院史记录Id,删除对应的一条住院史记录
	 * @param Id  住院史记录Id
	 */
	public void deleteInHospitalHistoryByIHHId(int ihhId);
	/**
	 * 根据住院史记录Id ，批量删除住院史记录
	 * @param deleteList  住院史记录Id
	 */
	public void deleteDRRecord(List<Object> deleteList);
	/**
	 * 修改住院史记录
	 * @param inhospitalhistory  住院史记录
	 */
	public void updateInHospitalHistory(TInHospitalHistory inhospitalhistory);
	/**
	 * 根据住院史记录Id,得到某个住院史记录实体
	 * @param Id  住院史记录Id
	 * @return  某个住院史记录实体
	 */
	public TInHospitalHistory getInHospitalHistoryByIHHId(int ihhId);
	/**
	 * 在住院记录视图中，根据医院ID得到记录数量(社区医院、普通员工)
	 * @param hosId 医院ID
	 * @return 记录数量
	 */
	public long getInHospitalHistoryCount(int hosId);
	/**
	 * 在住院记录视图中，根据医院ID得到记录数量(平台管理员)
	 * @return
	 */
	public long getInHospitalHistoryCount();
	/**
	 * 在住院记录视图中，得到记录数量(集团)
	 */
	public long getInHospitalHistoryCountForGroup(int groupId);
	/**
	 * 在住院记录视图中，根据医院ID得到记录数量(责任医生)
	 * @param staffId
	 * @return
	 */
	public long getInHospitalHistoryCountForSpecial(int staffId);
	/**
	 * 根据记录id得到视图实体，用于导出
	 * @param inHospitalHistoryId
	 * @return
	 */
	public VInHospitalHistory getVInHospitalHistory(int inHospitalHistoryId);
	/**
	 * 得到所有会诊记录（社区管理员、普通员工）  ,(用于导出)
	 * @param page
	 * @param hosId
	 * @return
	 */
	public List<VInHospitalHistory> getAllInHospitalHistory(int hosId);
	/**
	 * 得到所有会诊记录（责任医生），（用于导出）
	 * @param staffId
	 * @return
	 */
	public List<VInHospitalHistory> getAllInHospitalHistoryForSpecial(int staffId);
	/**
	 * 得到所有会诊记录（集团负责人），（用于导出）
	 * @param groupId集团id
	 * @return
	 */
	public List<VInHospitalHistory> getAllInHospitalHistoryForGroup(int groupId);
	/**
	 * 得到所有会诊记录（平台管理员），（用于导出）
	 * @return
	 */
	public List<VInHospitalHistory> getAllInHospitalHistory();


	/**
	 *分页得到所有的住院史记录，且每个老人只显示最近一次记录（社区医院、普通员工）
	 * @param page
	 */
	public List<VInHospitalHistory> getAllInHospitalHistory(Page<VInHospitalHistory> page,int hosId);
	/**
	 * 分页得到所有的住院史记录，且每个老人只显示最近一次记录（平台管理员）
	 * @param page
	 * @param hosId
	 * @return
	 */
	public List<VInHospitalHistory> getAllInHospitalHistory(Page<VInHospitalHistory> page);
	/**
	 * 分页得到所有的住院史记录，所有记录（集团）
	 * @param page
	 * @param groupId
	 * @return
	 */
	public List<VInHospitalHistory> getAllInHospitalHistoryForGroup(Page<VInHospitalHistory> page,int groupId);
	/**
	 * 分页得到所有的住院史记录，且每个老人只显示最近一次记录（责任医生）
	 * @param page
	 * @param hosId
	 * @return
	 */
	public List<VInHospitalHistory> getAllInHospitalHistoryForSpecial(Page<VInHospitalHistory> page,int staffId);
	/////////////////////////////多条件/////////////////////////////////////////
	/**
	 * 从住院记录记录视图中获取某一医院里的住院记录记录数量(社区管理员、普通员工多条件查询)
	 * @param hosId
	 * @return
	 */
	public long findChronicPeopleCount(SearchBeanSU se,int hosId);
/**
	 * 从住院记录记录视图中获取总的住院记录记录数量(平台管理员多条件)
	 * @return
	 */
	public long findChronicPeopleCount(SearchBeanSU se);
/**
	 * 从住院记录记录视图中获取某责任医生住院记录记录数量(责任医生多条件)
	 * @param staffId
	 * @return
	 */
	public long findChronicPeopleCountForSpecial(SearchBeanSU se,int staffId);
/**
	 * 返回该社区医院的所有住院记录记录视图(社区管理员、普通员工多条件)
	 * @param se
	 * @param page
	 * @param hosId
	 * @return
	 */
	public List<VInHospitalHistory> findChronicPeople(SearchBeanSU se , Page<VInHospitalHistory> page,int hosId);
/**
	 * 返回所有住院记录记录视图(平台管理员多条件)
	 * @param se
	 * @param page
	 * @return
	 */
	public List<VInHospitalHistory> findChronicPeople(SearchBeanSU se , Page<VInHospitalHistory> page);
/**
	 * 返回责任医生住院记录记录视图(责任医生多条件)
	 * @param se
	 * @param page
	 * @param staffId
	 * @return
	 */
	public List<VInHospitalHistory> findChronicPeopleForSpecial(SearchBeanSU se , Page<VInHospitalHistory> page,int staffId);


}
