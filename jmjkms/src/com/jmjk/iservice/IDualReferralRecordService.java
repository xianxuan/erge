package com.jmjk.iservice;

import java.util.List;

import com.jmjk.entity.TDualReferralRecord;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.view.VDualReferralRecord;
import com.jmjk.utils.Page;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.SearchBeanSU;
/**
 * 
 * @author 苏东航
 *
 */
public interface IDualReferralRecordService {
	/**
	 * 添加双向转诊记录
	 * @param dualreferralrecord  双向转诊记录
	 */
	public void saveDRRecord(TDualReferralRecord drrecord);
	
	/**
	 * 根据双向转诊记录Id,删除对应的一条双向转诊记录
	 * @param Id  双向转诊记录Id
	 */
	public void deleteDRRecordByDRRId(int  drrId);
	/**
	 * 根据双向转诊记录Id ，批量删除双向转诊记录
	 * @param deleteList  双向转诊记录Id
	 */
	public void deleteDRRecord(List<Object> deleteList);
	/**
	 * 修改双向转诊记录
	 * @param dualreferralrecord  双向转诊记录
	 */
	public void updateDRRecord(TDualReferralRecord drrecord);
	/**
	 * 根据双向转诊记录Id,得到某个双向转诊记录实体
	 * @param Id  双向转诊记录Id
	 * @return  某个双向转诊记录实体
	 */
	public TDualReferralRecord getDRRecordByDRRId(int drrId);
	/**
	 * 通过双向转诊视图得到记录数量(社区管理员、普通医院)
	 * @param hosId 医院Id
	 * @return
	 */
	public long getDualReferralRecordCount(int hosId);
	/**
	 * 通过双向转诊视图得到记录数量（平台管理员）
	 * @return
	 */
	public long getDualReferralRecordCount();
	/**
	 * 通过双向转诊视图得到记录数量(集团负责人)
	 * @param groupId
	 * @return
	 */
	public long getDualReferralRecordCountForGroup(int groupId);
	/**
	 * 通过双向转诊视图得到记录数量（责任医生）
	 * @param staffId
	 * @return
	 */
	public long getDualReferralRecordCountForSpecial(int staffId);
	/**
	 * 得到双向转诊的试图实体，用于导出
	 * @param dualRefRecId试图中双向转诊记录实体
	 * @return
	 */
	public VDualReferralRecord getVDualReferralRecord(int dualRefRecId);
	/**
	 * 得到所有双向转诊记录（社区管理员、普通员工）  ,(用于导出)
	 * @param page
	 * @param hosId
	 * @return
	 */
	public List<VDualReferralRecord> getAllDualReferralRecord(int hosId);
	/**
	 * 得到所有双向转诊记录（责任医生），（用于导出）
	 * @param staffId
	 * @return
	 */
	public List<VDualReferralRecord> getAllDualReferralRecordForSpecial(int staffId);
	/**
	 * 得到所有双向转诊记录（集团负责人），（用于导出）
	 * @param groupId集团id
	 * @return
	 */
	public List<VDualReferralRecord> getAllDualReferralRecordForGroup(int groupId);
	/**
	 * 得到所有双向转诊记录（平台管理员），（用于导出）
	 * @return
	 */
	public List<VDualReferralRecord> getAllDualReferralRecord();

	/**
	 * 分页得到所有的双向转诊记录(社区管理员、普通医院)
	 * @param page
	 * @return
	 */
	public List<VDualReferralRecord> getAllDRRecord(Page<VDualReferralRecord> page,int hosId);
	/**
	 * 分页得到所有的双向转诊记录(平台管理员)
	 * @param page
	 * @return
	 */
	public List<VDualReferralRecord> getAllDRRecord(Page<VDualReferralRecord> page);
	/**
	 * 分页得到所有的双向转诊记录(集团负责人)
	 * @param page
	 * @param groupId
	 * @return
	 */
	public List<VDualReferralRecord> getAllDRRecordForGroup(Page<VDualReferralRecord> page,int groupId);
	/**
	 * 分页得到所有的双向转诊记录(责任医生)
	 * @param page
	 * @param staffId
	 * @return
	 */
	public List<VDualReferralRecord> getAllDRRecordForSpecial(Page<VDualReferralRecord> page,int staffId);
	//////////////////////////////多条件//////////////////////////////////////////////////
	/**
	 * 从双向转诊记录视图中获取某一医院里的双向转诊记录数量(社区管理员、普通员工多条件查询)
	 * @param hosId
	 * @return
	 */
	public long findChronicPeopleCount(SearchBeanSU se,int hosId);
/**
	 * 从双向转诊记录视图中获取总的双向转诊记录数量(平台管理员多条件)
	 * @return
	 */
	public long findChronicPeopleCount(SearchBeanSU se);
/**
	 * 从双向转诊记录视图中获取某责任医生双向转诊记录数量(责任医生多条件)
	 * @param staffId
	 * @return
	 */
	public long findChronicPeopleCountForSpecial(SearchBeanSU se,int staffId);
/**
	 * 返回该社区医院的所有双向转诊记录视图(社区管理员、普通员工多条件)
	 * @param se
	 * @param page
	 * @param hosId
	 * @return
	 */
	public List<VDualReferralRecord> findChronicPeople(SearchBeanSU se , Page<VDualReferralRecord> page,int hosId);
/**
	 * 返回所有双向转诊记录视图(平台管理员多条件)
	 * @param se
	 * @param page
	 * @return
	 */
	public List<VDualReferralRecord> findChronicPeople(SearchBeanSU se , Page<VDualReferralRecord> page);
/**
	 * 返回责任医生双向转诊记录视图(责任医生多条件)
	 * @param se
	 * @param page
	 * @param staffId
	 * @return
	 */
	public List<VDualReferralRecord> findChronicPeopleForSpecial(SearchBeanSU se , Page<VDualReferralRecord> page,int staffId);


}
