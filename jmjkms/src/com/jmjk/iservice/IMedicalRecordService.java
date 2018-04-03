package com.jmjk.iservice;

import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.jmjk.entity.TMedicalRecord;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.view.VMedicalRecord;
import com.jmjk.utils.Page;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.SearchBeanSU;

public interface IMedicalRecordService {
	/**
	 * 添加长期用药记录
	 * @param medicalrecord  长期用药记录实体
	 */
	public void saveMedicalRecord(TMedicalRecord medicalrecord);
	
	/**
	 * 根据长期用药记录Id,删除对应的一条长期用药记录
	 * @param mrId  长期用药记录Id
	 */
	public void deleteMedicalRecordByMRId(int mrId);
	/**
	 * 根据长期用药记录Id ，批量删除长期用药记录
	 * @param deleteList  长期用药记录Id
	 */
	public void deleteMedicalRecord(List<Object> deleteList);
	/**
	 * 修改长期用药记录
	 * @param medicalrecord  长期用药记录实体
	 */
	public void updateMedicalRecord(TMedicalRecord medicalrecord);
	/**
	 * 根据长期用药记录Id,得到某个长期用药记录实体
	 * @param mrId  长期用药记录Id
	 * @return  某个长期用药记录实体
	 */
	public TMedicalRecord getMedicalRecordByMRId(int mrId);
	/**
	 * 在长期用药视图中，根据医院Id ，得到长期用药记录的数量(社区管理员、普通医生)
	 * @param hosId
	 * @return 长期用药记录的数量
	 */
	public long getMedicalRecordCount(int hosId);
	/**
	 * 在长期用药视图中得到长期用药记录的数量(平台管理员)
	 * @return
	 */
	public long getMedicalRecordCount();
	/**
	 * 在长期用药视图中得到长期用药记录的数量(集团)
	 * @param groupId
	 * @return
	 */
	public long getMedicalRecordCountForGroup(int groupId);
	/**
	 * 得到长期用药记录的数量(责任医生)
	 * @param staffId
	 * @return
	 */
	public long getMedicalRecordCountForSpecial(int staffId);
	/**
	 * 根据记录id得到视图实体，用于导出
	 * @param medicalRecordId
	 * @return
	 */
	public VMedicalRecord getVMedicalRecord(int medicalRecordId);
	/**
	 * 得到所有会诊记录（社区管理员、普通员工）  ,(用于导出)
	 * @param page
	 * @param hosId
	 * @return
	 */
	public List<VMedicalRecord> getAllMedicalRecord(int hosId);
	/**
	 * 得到所有会诊记录（责任医生），（用于导出）
	 * @param staffId
	 * @return
	 */
	public List<VMedicalRecord> getAllMedicalRecordForSpecial(int staffId);
	/**
	 * 得到所有会诊记录（集团负责人），（用于导出）
	 * @param groupId集团id
	 * @return
	 */
	public List<VMedicalRecord> getAllMedicalRecordForGroup(int groupId);
	/**
	 * 得到所有会诊记录（平台管理员），（用于导出）
	 * @return
	 */
	public List<VMedicalRecord> getAllMedicalRecord();

	/**
	 * 分页得到所有的长期用药记录(社区管理员、普通医生)
	 * @param page
	 */
	public List<VMedicalRecord> getAllMedicalRecord(Page<VMedicalRecord> page,int hosId);
	/**
	 * 分页得到所有的长期用药记录(平台管理员)
	 * @param page
	 * @return
	 */
	public List<VMedicalRecord> getAllMedicalRecord(Page<VMedicalRecord> page);
	/**
	 * 分页得到所有的长期用药记录(集团)
	 * @param page
	 * @param groupId
	 * @return
	 */
	public List<VMedicalRecord> getAllMedicalRecordForGroup(Page<VMedicalRecord> page,int groupId);
	/**
	 * 分页得到所有的长期用药记录(责任医生)
	 * @param page
	 * @param staffId
	 * @return
	 */
	public List<VMedicalRecord> getAllMedicalRecordForSpecial(Page<VMedicalRecord> page,int staffId);
	/////////////////////////////////多条件/////////////////////////////////////////////////
	/**
	 * 从用药记录记录视图中获取某一医院里的用药记录记录数量(社区管理员、普通员工多条件查询)
	 * @param hosId
	 * @return
	 */
	public long findChronicPeopleCount(SearchBeanSU se,int hosId);
/**
	 * 从用药记录记录视图中获取总的用药记录记录数量(平台管理员多条件)
	 * @return
	 */
	public long findChronicPeopleCount(SearchBeanSU se);
/**
	 * 从用药记录记录视图中获取某责任医生用药记录记录数量(责任医生多条件)
	 * @param staffId
	 * @return
	 */
	public long findChronicPeopleCountForSpecial(SearchBeanSU se,int staffId);
/**
	 * 返回该社区医院的所有用药记录记录视图(社区管理员、普通员工多条件)
	 * @param se
	 * @param page
	 * @param hosId
	 * @return
	 */
	public List<VMedicalRecord> findChronicPeople(SearchBeanSU se , Page<VMedicalRecord> page,int hosId);
/**
	 * 返回所有用药记录记录视图(平台管理员多条件)
	 * @param se
	 * @param page
	 * @return
	 */
	public List<VMedicalRecord> findChronicPeople(SearchBeanSU se , Page<VMedicalRecord> page);
/**
	 * 返回责任医生用药记录记录视图(责任医生多条件)
	 * @param se
	 * @param page
	 * @param staffId
	 * @return
	 */
	public List<VMedicalRecord> findChronicPeopleForSpecial(SearchBeanSU se , Page<VMedicalRecord> page,int staffId);

	

}
