package com.jmjk.iservice;

import java.util.List;

import com.jmjk.entity.TConsultationRecord;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.view.VConsultationRecord;
import com.jmjk.utils.Page;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.SearchBeanSU;
/**
 * 
 * @author 苏东航
 *
 */
public interface IConsultationRecordService {
	/**
	 * 添加会诊记录
	 * @param consultationrecord  会诊记录实体
	 */
	public void saveConsultationRecord(TConsultationRecord consultationrecord);
	
	/**
	 * 根据会诊记录Id,删除对应的一条会诊记录
	 * @param crId  会诊记录Id
	 */
	public void deleteConsultationRecordByCRId(int  crId);
	/**
	 * 根据会诊记录Id ，批量删除会诊记录
	 * @param deleteList  会诊记录Id
	 */
	public void deleteConsultationRecord(List<Object> deleteList);
	/**
	 * 修改会诊记录
	 * @param consultationrecord  会诊记录实体
	 */
	public void updateConsultationRecord(TConsultationRecord consultationrecord);
	/**
	 * 根据会诊记录Id,得到某个会诊记录实体
	 * @param crId  会诊记录Id
	 * @return  某个会诊记录实体
	 */
	public TConsultationRecord getConsultationRecordByCRId(int crId);
	/**
	 * 根据医院Id,在会诊记录视图中得到所有记录数量(社区管理员、普通员工)
	 * @param hosId
	 * @return 得到所有记录数量
	 */
	public long getConsultationRecordCount(int hosId);
	/**
	 * 在会诊记录视图中得到所有记录数量(平台管理员)
	 * @return
	 */
	public long getConsultationRecordCount();
	/**
	 * 在会诊记录视图中得到所有记录数量(集团负责人)
	 * @param grooupId
	 * @return
	 */
	public long getConsultationRecordCountForGroup(int groupId);
	/**
	 * 在会诊记录视图中得到责任医生所有记录数量(责任医生)
	 * @param staffId
	 * @return
	 */
	public long getConsultationRecordCountForSpecial(int staffId);
	/**
	 * 根据记录id得到视图实体，用于导出
	 * @param consultationRecordId
	 * @return
	 */
	public VConsultationRecord getVConsultationRecord(int consultationRecordId);
	/**
	 * 得到所有会诊记录（社区管理员、普通员工）  ,(用于导出)
	 * @param page
	 * @param hosId
	 * @return
	 */
	public List<VConsultationRecord> getAllConsultationRecord(int hosId);
	/**
	 * 得到所有会诊记录（责任医生），（用于导出）
	 * @param staffId
	 * @return
	 */
	public List<VConsultationRecord> getAllConsultationRecordForSpecial(int staffId);
	/**
	 *  得到所有会诊记录（集团负责人），（用于导出）
	 * @param groupId集团id
	 * @return
	 */
	public List<VConsultationRecord> getAllConsultationRecordForGroup(int groupId);
	/**
	 * 得到所有会诊记录（平台管理员），（用于导出）
	 * @return
	 */
	public List<VConsultationRecord> getAllConsultationRecord();
	/**
	 * 得到所有会诊记录（社区管理员、普通员工）
	 * @param page
	 * @param hosId
	 * @return
	 */
	public List<VConsultationRecord> getAllConsultationRecord(Page<VConsultationRecord> page,int hosId);
	/**
	 * 得到所有会诊记录（平台管理员）
	 * @param page
	 * @return
	 */
	public List<VConsultationRecord> getAllConsultationRecord(Page<VConsultationRecord> page);
	/**
	 * 得到所有会诊记录（集团负责人）
	 * @param page
	 * @param groupId
	 * @return
	 */
	public List<VConsultationRecord> getAllConsultationRecordForGroup(Page<VConsultationRecord> page,int groupId);
	/**
	 * 得到所有会诊记录（责任医生）
	 * @param page
	 * @return
	 */
	public List<VConsultationRecord> getAllConsultationRecordForSpecial(Page<VConsultationRecord> page,int staffId);
	///////////////////////////////////多条件查询//////////////////////////////////////////////////////
	/**
	 * 从会诊记录视图中获取某一医院里的会诊记录数量(社区管理员、普通员工多条件查询)
	 * @param hosId
	 * @return
	 */
	public long findChronicPeopleCount(SearchBeanSU se,int hosId);
/**
	 * 从会诊记录视图中获取总的会诊记录数量(平台管理员多条件)
	 * @return
	 */
	public long findChronicPeopleCount(SearchBeanSU se);
/**
	 * 从会诊记录视图中获取某责任医生会诊记录数量(责任医生多条件)
	 * @param staffId
	 * @return
	 */
	public long findChronicPeopleCountForSpecial(SearchBeanSU se,int staffId);
/**
	 * 返回该社区医院的所有会诊记录视图(社区管理员、普通员工多条件)
	 * @param se
	 * @param page
	 * @param hosId
	 * @return
	 */
	public List<VConsultationRecord> findChronicPeople(SearchBeanSU se , Page<VConsultationRecord> page,int hosId);
/**
	 * 返回所有会诊记录视图(平台管理员多条件)
	 * @param se
	 * @param page
	 * @return
	 */
	public List<VConsultationRecord> findChronicPeople(SearchBeanSU se , Page<VConsultationRecord> page);
/**
	 * 返回责任医生会诊记录视图(责任医生多条件)
	 * @param se
	 * @param page
	 * @param staffId
	 * @return
	 */
	public List<VConsultationRecord> findChronicPeopleForSpecial(SearchBeanSU se , Page<VConsultationRecord> page,int staffId);

}
