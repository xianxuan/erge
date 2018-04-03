package com.jmjk.iservice;

import java.util.Date;
import java.util.List;

import com.jmjk.entity.TFollowRecord;
import com.jmjk.entity.THealthFile;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.view.VFollowRecord;
import com.jmjk.utils.Page;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.SearchBeanSU;
/**
 * 
 * @author 苏东航
 *
 */
public interface IFollowRecordService {
	/**
	 * 添加随诊记录
	 * @param followrecord  随诊记录实体
	 */
	public void saveFollowRecord(TFollowRecord followrecord);
	
	/**
	 * 根据随诊记录Id,删除对应的一条随诊记录
	 * @param followId  随诊记录Id
	 */
	public void deleteFollowRecord(int followId);
	/**
	 * 根据随诊记录Id ，批量删除随诊记录
	 * @param deleteList  随诊记录Id
	 */
	public void deleteFollowRecord(List<Object> deleteList);
	/**
	 * 修改随诊记录
	 * @param followrecord  随诊记录实体
	 */
	public void updateFollowRecord(TFollowRecord followrecord);
	
	/**
	 * 根据随诊记录Id,得到某个随诊记录实体
	 * @param followId  随诊记录Id
	 * @return  某个随诊记录实体
	 */
	public TFollowRecord getFollowRecordByFollowId(int followId);
	/**
	 * 从随诊记录视图中获取某一医院里的随诊记录数量(社区管理员、普通员工)
	 * @param hosId
	 * @return  某一医院里的随诊记录数量
	 */
	public long getFollowRecordCount(int hosId ,int state);
	/**
	 * 从随诊记录视图中获取某一集团里的随诊记录数量(集团负责人)
	 * @param groupId集团id
	 * @return
	 */
	public long getFollowRecordCountForGroup(int groupId );
	/**
	 * 从随诊记录视图中获取某一医院里的随诊记录数量(社区管理员、普通员工多条件查询)
	 * @param hosId
	 * @return
	 */
	public long findChronicPeopleCount(SearchBeanSU se,int hosId);
	/**
	 * 从随诊记录视图中获取总的随诊记录数量(平台管理员)
	 * @return
	 */
	public long getFollowRecordCount(int state);
	/**
	 * 从随诊记录视图中获取总的随诊记录数量(集团)
	 */
	public long findChronicPeopleCountForGroup(SearchBeanSU se,int groupId);
	/**
	 * 从随诊记录视图中获取总的随诊记录数量(平台管理员多条件)
	 * @return
	 */
	public long findChronicPeopleCount(SearchBeanSU se);
	/**
	 * 从随诊记录视图中获取某责任医生随诊记录数量(责任医生)
	 * @param staffId
	 * @return
	 */
	public long getFollowRecordCountForSpecial(int staffId,int state);
	/**
	 * 从随诊记录视图中获取某责任医生随诊记录数量(责任医生多条件)
	 * @param staffId
	 * @return
	 */
	public long findChronicPeopleCountForSpecial(SearchBeanSU se,int staffId);
	
	/**
	 * 根据记录id得到视图实体，用于导出
	 * @param FollowRecordId
	 * @return
	 */
	public VFollowRecord getVFollowRecord(int FollowRecordId);
	/**
	 * 得到所有随诊记录（社区管理员、普通员工）  ,(用于导出)
	 * @param page
	 * @param hosId
	 * @return
	 */
	public List<VFollowRecord> getAllFollowRecord(int hosId);
	/**
	 * 得到所有随诊记录（责任医生），（用于导出）
	 * @param staffId
	 * @return
	 */
	public List<VFollowRecord> getAllFollowRecordForSpecial(int staffId);
	/**
	 * 得到所有随诊记录（集团负责人），（用于导出）
	 * @param groupId集团id
	 * @return
	 */
	public List<VFollowRecord> getAllFollowRecordForGroup(int groupId);
	/**
	 * 得到所有随诊记录（平台管理员），（用于导出）
	 * @return
	 */
	public List<VFollowRecord> getAllFollowRecord();
	/**
	 * 返回该社区医院的所有随诊记录视图(社区管理员、普通员工)
	 * @param page 分页
	 * @param hosId 社区Id
	 * @return
	 */
	public List<VFollowRecord> getAllFollowRecord(Page<VFollowRecord> page ,int hosId,int state);
	/**
	 * 返回该社区医院的所有随诊记录视图(社区管理员、普通员工多条件)
	 * @param se
	 * @param page
	 * @param hosId
	 * @return
	 */
	public List<VFollowRecord> findChronicPeople(SearchBeanSU se , Page<VFollowRecord> page,int hosId);
	/**
	 * 返回所有随诊记录视图(平台管理员)
	 * @param page
	 * @return
	 */
	public List<VFollowRecord> getAllFollowRecord(Page<VFollowRecord> page,int state );
	/**
	 * 返回所有随诊记录视图(平台管理员多条件)
	 * @param se
	 * @param page
	 * @return
	 */
	public List<VFollowRecord> findChronicPeople(SearchBeanSU se , Page<VFollowRecord> page);
	/**
	 * 返回所有随诊记录视图(集团)
	 * @param page
	 * @param groupId
	 * @return
	 */
	public List<VFollowRecord> getAllFollowRecordForGroup(Page<VFollowRecord> page,int groupId );
	/**
	 * 返回责任医生随诊记录视图(责任医生)
	 * @param page
	 * @param staffId
	 * @return
	 */
	public List<VFollowRecord> getAllFollowRecordForSpecial(Page<VFollowRecord> page,int staffId ,int state);
	/**
	 * 返回责任医生随诊记录视图(责任医生多条件)
	 * @param se
	 * @param page
	 * @param staffId
	 * @return
	 */
	public List<VFollowRecord> findChronicPeopleForSpecial(SearchBeanSU se , Page<VFollowRecord> page,int staffId);
	
	
	
}
