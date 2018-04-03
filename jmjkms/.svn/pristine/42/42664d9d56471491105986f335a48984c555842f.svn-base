package com.jmjk.iservice;

import java.util.Date;
import java.util.List;

import com.jmjk.entity.TStaffLeave;
import com.jmjk.entity.view.VStaffLeave;
import com.jmjk.utils.Page;

/**
 * 员工请假管理接口
 * @author Liufengshuang
 *
 */
public interface IStaffLeaveService {
	public void comeBackStart(int staffLeaveId);
	
	/**
	 * 平台管理员查询员工请假,分页
	 * @param page
	 * @return
	 */
	public List<VStaffLeave> getAllStaffLeave(Page page);
	/**
	 * 根据社区Id统计员工请假的数量,用于分页
	 * @param sqId
	 * @return
	 */
	public long countStaffLeaveByCommunityHospitalId(int sqId);
	/**
	 * 通过社区Id 得到所有的员工请假信息,用于打印全部员工请假
	 * @param sqId
	 * @return
	 */
	public List<VStaffLeave> getStaffLeavesByCommunityHospitalId(int sqId);
	
	/**
	 * 批量删除
	 * @param staffLeaveIds
	 * @return
	 */
	public int deleteStaffList(List<Object> staffLeaveIds);
	/**
	 * 用于查询员工信息的 分页
	 * @param staffNumber
	 * @param name
	 * @param comHos
	 * @param leaveDate
	 * @param comeBackDate
	 * @param sqId
	 * @param page
	 * @return
	 */
	public List<VStaffLeave> getStaffLeaveBySearch(int flag,String staffNumber, String name,String comHos, Date leaveDateHige,Date leaveDateLow, Date comeBackDateHigh,Date comebackDateLow, int sqId,Page page);
	/**
	 * 用于员工请假查询的分页 总数统计
	 * @param staffNumber
	 * @param name
	 * @param leaveDate
	 * @param comeBackDate
	 * @param sqId
	 * @return
	 */
	public long countStaffLeaveBySearch(int flag,String staffNumber,
			String name, String comHos,Date leaveDateHigh,Date leaveDateLow, Date comeBackDateHigh,Date comeBackDateLow, int sqId) ;
	/**
	 * 员工请假管理中的查询  没有分页的
	 * @param staffNumber
	 * @param name
	 * @param leaveDate
	 * @param comeBackDate
	 * @param sqId
	 * @return
	 */
	
	public List<VStaffLeave> getStaffLeaveBySearch(int flag,String staffNumber,
			String name,String comHos, Date leaveDateHigh,Date leaveDateLow, Date comeBackDateHigh,Date comeBackDateLow, int sqId) ;
	/**
	 * 传入员工请假Id, 将销假的时间填入
	 * @param staffLeaveId
	 */
	public void comeBack(int staffLeaveId);
	
	/**
	 * 传入社区Id, 得到该社区下的所有员工请假,用于社区管理员和操作员登录后,显示本社区员工请假
	 * @param communityHospitalId  社区Id
	 * @return
	 */
	public List<VStaffLeave> getVStaffLeaveBycommunityHospitalId(int communityHospitalId, Page page);
	
	
	/**
	 * 添加员工请假
	 * @param staffLeave
	 */
	public void saveStaffLeave(TStaffLeave staffLeave);
	
	/**
	 * 根据员工请假ID删除员工请假条目
	 * @param staffLeaveId  员工请假Id
	 * @param sqId  社区Id
	 */
	public void deleteStaffLeaveById(int staffLeaveId);
	
	/**
	 * 更新员工请假信息
	 * @param staffLeave
	 * @param sqId  社区Id
	 */
	public void updateStaffLeave(TStaffLeave staffLeave);
	
	/**
	 * 用于系统管理员查看所有的员工请假
	 * 统计员工请假条目总数   用于分页
	 * @return
	 */
	public long countStaffLeave();
	
	/**
	 * 系统管理员
	 * 分页得到员工请假实体列表
	 * @param page
	 * @return
	 */
	public List<TStaffLeave> getStaffLeaveByPage(Page page);
	
	/**
	 * 根据员工请假ID得到员工请假信息实体 
	 * @param staffLeaveId
	 * @return
	 */
	public TStaffLeave getStaffLeaveById(int staffLeaveId);
	
}
