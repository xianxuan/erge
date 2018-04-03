package com.jmjk.iservice;

import java.util.Date;
import java.util.List;

import com.jmjk.entity.TStaffRewardPunish;
import com.jmjk.entity.view.VStaffRewardPunish;
import com.jmjk.utils.Page;


/**]
 * 员工奖惩的Service接口
 * @author 黄仕鑫
 *
 */

public interface IStaffRewardPunishService {
		public List<VStaffRewardPunish>  getCommunicityAllTStaffRewardPunish(int sqId);
	
  
		/**
		 * 添加奖惩员工 的实体
		 * @param staffRewardPunish  
		 */		  
	 	public void addStaffRewardPunish(TStaffRewardPunish  staffRewardPunish );
	 	
	 	/**
	 	 * 删除奖惩员工  通过ID
	 	 * @param staffRewardPunishId
	 	 */
	 	public void deleteStaffRewardPunishById(int  staffRewardPunishId);
	 	
	 	/**
	 	 * 批量删除奖惩员工
	 	 * @param deleteList
	 	 */
	 	public void deleteMoreStaffRewardPunish(List<Object> deleteList) ;
	 	
	 	/**
	 	 * 更新员工的实体 
	 	 * @param staffRewardPunish
	 	 */
	 	public void updateTstaffRewardPunish(TStaffRewardPunish  staffRewardPunish );
	 	 	
	 	/**
	 	 * 获得所有该社区奖惩员工的 分页
	 	 * @param page
	 	 * @return
	 	 */
	 	public List<VStaffRewardPunish>  getCommunicityTStaffRewardPunish(Page<VStaffRewardPunish> page,int communityHospitalId);
	 		 	
	 	/**
	 	 * 获得奖惩员工的数量
	 	 * @param 
	 	 */
	 	public long countTStaffRewardPunish(int communityHospitalId);
	 	
	 	/**
	 	 * 根据id获得奖惩员工的实体 
	 	 * @param StaffId   奖惩员工id
	 	 * @param VStaffRewardPunish （视图）
	 	 * @return
	 	 */
	 	public VStaffRewardPunish getTStaffRewardPunishByStaffId(int StaffId);
	 	
	 	/** id     
	 	 * 通过 时间以及奖惩类型 和 员工姓名进行查询  并且分页
	 	 * @param page 分页
	 	 * @param beginTime 起始时间
	 	 * @param overTime 结束时间
	 	 * @param name 员工姓名
	 	 * @param rewordPunishType rewordPunishType 奖惩类型
	 	 * @return
	 	 */
	 	public List<VStaffRewardPunish> searchStaffRewardPunish(Page<VStaffRewardPunish> page,int communityHospitalId,int flag,Date beginTime,Date overTime,String rewordPunishType,String name);
	 	
	 	/**id
	 	 * 获得奖惩员工的数量
	 	 * @param beginTime
	 	 * @param overTime
	 	 * @param rewordPunishType
	 	 * @param name
	 	 * @return
	 	 */
	 	public long countStaffRewardPunish(int falg, int communityHospitalId,Date beginTime,Date overTime,String rewordPunishType,String name,String department);

	 	/**
	 	 * 通过奖惩员工的id获得实体
	 	 * @param staffRewardPunishId
	 	 * @return
	 	 */
	 	public TStaffRewardPunish getTStaffRewardPunishBysrpId(int staffRewardPunishId);
	 	
	 	/**
	 	 * 通过id获得视图的List  不分页
	 	 * @param staffRewardPunishId
	 	 */
	 	public List<VStaffRewardPunish>  getVStaffRewardPunishsByStaffRewardPunishId(int staffRewardPunishId);
	 	
	 	/**
	 	 * 根据员工奖惩，判断是否为该员工
	 	 * @param staffId
	 	 * @param staffRPId
	 	 * @return
	 	 */
	 	public Boolean getStaffRPIsStaff(int staffId, int staffRPId);
	 	
	 	/**
	 	 * 根据员工的id判断是否属于该社区
	 	 * @param staffId
	 	 * @param hospitalId
	 	 * @return
	 	 */
	 	public Boolean getStaffIsHos(int staffId,int hospitalId);
	 	
	 	/**
	 	 * 根据奖惩员工的id判断是否属于该社区
	 	 * @param staffRewardPunishId 奖惩员工id
	 	 * @param hospitalId 社区医院id
	 	 */
	 	public Boolean getStaffPunishIsHos(int staffRewardPunishId,int hospitalId);
}
