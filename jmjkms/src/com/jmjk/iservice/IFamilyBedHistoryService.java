package com.jmjk.iservice;

import java.util.List;

import com.jmjk.entity.TFamilyBedHistory;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.view.VFamilyBedHistory;
import com.jmjk.utils.Page;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.SearchBeanSU;

public interface IFamilyBedHistoryService {
	/**
	 * 添加家庭病床史记录
	 * @param familybedhistory  家庭病床史记录
	 */
	public void saveFamilyBedHistory(TFamilyBedHistory familybedhistory);
	
	/**
	 * 根据家庭病床史记录Id ，批量删除家庭病床史记录Id记录
	 * @param deleteList  家庭病床史记录IdId
	 */
	public void deleteFamilyBedHistory(List<Object> deleteList);
	/**
	 * 根据家庭病床史记录Id,删除对应的一条家庭病床史记录
	 * @param fbhId  家庭病床史记录Id
	 */
	public void deleteFamilyBedHistoryByFBHId(int fbhId);
	/**
	 * 修改家庭病床史记录
	 * @param familybedhistory  家庭病床史记录
	 */
	public void updateFamilyBedHistory(TFamilyBedHistory familybedhistory);
	/**
	 * 根据家庭病床史记录Id,得到某个家庭病床史记录实体
	 * @param fbhId  家庭病床史记录Id
	 * @return  某个家庭病床史记录实体
	 */
	public TFamilyBedHistory getFamilyBedHistoryByFBHId(int fbhId);
	/**
	 * 在家庭病床记录视图中，根据医院ID得到记录数量(社区医院、普通员工)
	 * @param hosId 医院ID
	 * @return 记录数量
	 */
	public long getFamilyBedHistoryCount(int hosId);
	/**
	 * 在家庭病床记录视图中，根据医院ID得到记录数量(平台管理员)
	 * @return
	 */
	public long getFamilyBedHistoryCount();
	/**
	 * 在家庭病床记录视图中，得到记录数量(集团)
	 * @param groupId
	 * @return
	 */
	public long getFamilyBedHistoryCountForGroup(int groupId);
	/**
	 * 在家庭病床记录视图中，根据医院ID得到记录数量(责任医生)
	 * @param staffId
	 * @return
	 */
	public long getFamilyBedHistoryCountForSpecial(int staffId);
	/**
	 * 根据病床记录id得到视图实体，{用于导出
	 * @param familyBedHistoryId
	 * @return
	 */
	public VFamilyBedHistory getVFamilyBedHistory(int familyBedHistoryId);
	/**
	 * 得到所有家庭病床记录（社区管理员、普通员工）  ,(用于导出)
	 * @param page
	 * @param hosId
	 * @return
	 */
	public List<VFamilyBedHistory> getAllFamilyBedHistory(int hosId);
	/**
	 * 得到所有家庭病床记录（责任医生），（用于导出）
	 * @param staffId
	 * @return
	 */
	public List<VFamilyBedHistory> getAllFamilyBedHistoryForSpecial(int staffId);
	/**
	 * 得到所有家庭病床记录（集团负责人）  ,(用于导出)
	 * @param groupId
	 * @return
	 */
	public List<VFamilyBedHistory> getAllFamilyBedHistoryForGroup(int groupId);
	/**
	 * 得到所有家庭病床记录（平台管理员），（用于导出）
	 * @return
	 */
	public List<VFamilyBedHistory> getAllFamilyBedHistory();

	/**
	 * 分页得到所有的家庭病床史记录(社区医院、普通员工)
	 * @param page
	 */
	public List<VFamilyBedHistory> getAllFamilyBedHistory(Page<VFamilyBedHistory> page,int hosId);
	/**
	 * 分页得到所有的家庭病床史记录(社区医院、普通员工)
	 * @param page
	 * @param hosId
	 * @return
	 */
	public List<VFamilyBedHistory> getAllFamilyBedHistory(Page<VFamilyBedHistory> page);
	/**
	 *  分页得到所有的家庭病床史记录(集团)
	 */
	public List<VFamilyBedHistory> getAllFamilyBedHistoryForGroup(Page<VFamilyBedHistory> page,int groupId);
	/**
	 * 分页得到所有的家庭病床史记录(责任医生)
	 * @param page
	 * @param staffId
	 * @return
	 */
	public List<VFamilyBedHistory> getAllFamilyBedHistoryForSpecial(Page<VFamilyBedHistory> page,int staffId);
	//////////////////////多条件////////////////////////////////
	/**
	 * 从家庭病床记录记录视图中获取某一医院里的家庭病床记录记录数量(社区管理员、普通员工多条件查询)
	 * @param hosId
	 * @return
	 */
	public long findChronicPeopleCount(SearchBeanSU se,int hosId);
/**
	 * 从家庭病床记录记录视图中获取总的家庭病床记录记录数量(平台管理员多条件)
	 * @return
	 */
	public long findChronicPeopleCount(SearchBeanSU se);
/**
	 * 从家庭病床记录记录视图中获取某责任医生家庭病床记录记录数量(责任医生多条件)
	 * @param staffId
	 * @return
	 */
	public long findChronicPeopleCountForSpecial(SearchBeanSU se,int staffId);
/**
	 * 返回该社区医院的所有家庭病床记录记录视图(社区管理员、普通员工多条件)
	 * @param se
	 * @param page
	 * @param hosId
	 * @return
	 */
	public List<VFamilyBedHistory> findChronicPeople(SearchBeanSU se , Page<VFamilyBedHistory> page,int hosId);
/**
	 * 返回所有家庭病床记录记录视图(平台管理员多条件)
	 * @param se
	 * @param page
	 * @return
	 */
	public List<VFamilyBedHistory> findChronicPeople(SearchBeanSU se , Page<VFamilyBedHistory> page);
/**
	 * 返回责任医生家庭病床记录记录视图(责任医生多条件)
	 * @param se
	 * @param page
	 * @param staffId
	 * @return
	 */
	public List<VFamilyBedHistory> findChronicPeopleForSpecial(SearchBeanSU se , Page<VFamilyBedHistory> page,int staffId);


}
