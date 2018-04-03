package com.jmjk.iservice;

import java.util.Date;
import java.util.List;

import com.jmjk.entity.TIncompleteRecord;
import com.jmjk.entity.view.VIncompleteRecord;
import com.jmjk.utils.Page;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.SearchBeanSU;
/**
 * 
 * @author 苏东航
 *
 */
public interface IIncompleteRecordService {
	/**
	 * 添加接诊记录
	 * @param incompleterecord  接诊记录实体
	 */
	public void saveIncompleteRecord(TIncompleteRecord incompleterecord);
	
	/**
	 * 根据接诊记录Id,删除对应的一条接诊记录
	 * @param irId  接诊记录Id
	 */
	public void deleteIncompleteRecordByIRd(int irId);
	/**
	 * 根据接诊记录Id ，批量删除接诊记录
	 * @param deleteList  接诊记录Id
	 */
	public void deleteIncompleteRecord(List<Object> deleteList);
	/**
	 * 修改接诊记录
	 * @param incompleterecord  接诊记录实体
	 */
	public void updateIncompleteRecord(TIncompleteRecord incompleterecord);
	
	
	/**
	 * 根据接诊记录Id,得到某个接诊记录实体
	 * @param  irId  接诊记录Id
	 * @return  某个接诊记录实体
	 */
	public TIncompleteRecord getIncompleteRecordByIRId(int irId);
	/**
	 * 从接诊记录视图中根据医院Id得到该医院的全部记录数量(社区管理员、普通医生)
	 * @param hosId
	 * @return
	 */
	public long getIncompleteRecordCount(int hosId) ;
	/**
	 * 从接诊记录视图中得到全部记录数量(平台管理员)
	 * @return
	 */
	public long getIncompleteRecordCount();
	/**
	 * 从接诊记录视图中得到全部记录数量(集团)
	 * @param groupId
	 * @return
	 */
	public long getIncompleteRecordCountForGroup(int groupId) ;
	/**
	 * 从接诊记录视图中得到责任医生全部记录数量(责任医生)
	 * @param staffId
	 * @return
	 */
	public long getIncompleteRecordCountForSpecial(int staffId) ;
	/**
	 * 得到接诊记录试图(社区管理员、普通医生)
	 * @param page
	 * @param hosId 医院Id
	 * @return
	 */
	/**
	 * 根据记录id得到视图实体，用于导出
	 * @param IncompleteRecordId
	 * @return
	 */
	public VIncompleteRecord getVIncompleteRecord(int IncompleteRecordId);
	/**
	 * 得到所有随诊记录（社区管理员、普通员工）  ,(用于导出)
	 * @param page
	 * @param hosId
	 * @return
	 */
	public List<VIncompleteRecord> getAllIncompleteRecord(int hosId);
	/**
	 * 得到所有随诊记录（责任医生），（用于导出）
	 * @param staffId
	 * @return
	 */
	public List<VIncompleteRecord> getAllIncompleteRecordForSpecial(int staffId);
	/**
	 * 得到所有随诊记录（集团负责人），（用于导出）
	 * @param groupId集团id
	 * @return
	 */
	public List<VIncompleteRecord> getAllIncompleteRecordForGroup(int groupId);
	/**
	 * 得到所有随诊记录（平台管理员），（用于导出）
	 * @return
	 */
	public List<VIncompleteRecord> getAllIncompleteRecord();

	public List<VIncompleteRecord> getAllIncompleteRecord(Page<VIncompleteRecord> page,int hosId);
	/**
	 * 得到接诊记录试图(平台管理员)
	 * @param page
	 * @return
	 */
	public List<VIncompleteRecord> getAllIncompleteRecord(Page<VIncompleteRecord> page);
	/**
	 * 得到接诊记录试图(集团)
	 * @param page
	 * @param groupId
	 * @return
	 */
	public List<VIncompleteRecord> getAllIncompleteRecordForGroup(Page<VIncompleteRecord> page,int groupId);
	/**
	 * 得到接诊记录试图(责任医生)
	 * @param page
	 * @return
	 */
	public List<VIncompleteRecord> getAllIncompleteRecordForSpecial(Page<VIncompleteRecord> page,int staffId);
	/////////////////////////////////////////多条件查询///////////////////////////////////////
	/**
	 * 从接诊记录视图中获取某一医院里的接诊记录数量(社区管理员、普通员工多条件查询)
	 * @param hosId
	 * @return
	 */
	public long findChronicPeopleCount(SearchBeanSU se,int hosId);
/**
	 * 从接诊记录视图中获取总的接诊记录数量(平台管理员多条件)
	 * @return
	 */
	public long findChronicPeopleCount(SearchBeanSU se);
/**
	 * 从接诊记录视图中获取某责任医生接诊记录数量(责任医生多条件)
	 * @param staffId
	 * @return
	 */
	public long findChronicPeopleCountForSpecial(SearchBeanSU se,int staffId);
/**
	 * 返回该社区医院的所有接诊记录视图(社区管理员、普通员工多条件)
	 * @param se
	 * @param page
	 * @param hosId
	 * @return
	 */
	public List<VIncompleteRecord> findChronicPeople(SearchBeanSU se , Page<VIncompleteRecord> page,int hosId);
/**
	 * 返回所有接诊记录视图(平台管理员多条件)
	 * @param se
	 * @param page
	 * @return
	 */
	public List<VIncompleteRecord> findChronicPeople(SearchBeanSU se , Page<VIncompleteRecord> page);
/**
	 * 返回责任医生接诊记录视图(责任医生多条件)
	 * @param se
	 * @param page
	 * @param staffId
	 * @return
	 */
	public List<VIncompleteRecord> findChronicPeopleForSpecial(SearchBeanSU se , Page<VIncompleteRecord> page,int staffId);

}
