package com.jmjk.iservice;

import java.util.List;

import com.jmjk.entity.TOldStaffHos;
import com.jmjk.entity.TRole;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.view.VStaffHos;
import com.jmjk.utils.Page;

/**
 * 员工信息管理接口
 * @author Liufengshuang
 *
 */
public interface IStaffService {
	
	/**
	 * 
	 * addDutyDoctor:添加责任医生 <br/> 
	 * TODO(这里描述这个方法适用条件 – 可选).<br/> 
	 * @author liufengshuang
	 * @param staff 
	 * @since JDK 1.8
	 */
	public void addDutyDoctor(TStaff staff);
	/**
	 * 
	 * deleteDutyDoctor:删除责任医生. <br/> 
	 * TODO(这里描述这个方法适用条件 – 可选).<br/> 
	 * @author liufengshuang
	 * @param id 
	 * @since JDK 1.8
	 */
	public void deleteDutyDoctor(int id);
	/**
	 * 
	 * updateDutyDoctor:修改责任医生. <br/> 
	 * TODO(这里描述这个方法适用条件 – 可选).<br/> 
	 * @author liufengshuang
	 * @param staff 
	 * @since JDK 1.8
	 */
	public void updateDutyDoctor(TStaff staff);
	/**
	 * 通过员工ID得到社区员工视图 实体 
	 * @param id
	 * @return
	 */
	public VStaffHos getVStaffById(int id);
	/**
	 * 系统管理员看到的所有员工信息
	 * @return
	 */
	public List<TStaff>getAllStaff();
	/**
	 * 系统管理员的查询 --分页
	 * @param flag
	 * @param value
	 * @param state
	 * @param department
	 * @param page
	 * @return
	 */
	public List<TStaff> getStaffBySearch(int flag, String value,String state, String department,Page page);
	/**
	 * 系统管理员的查询统计 -- 用于分页
	 * @param flag
	 * @param value
	 * @param state
	 * @param department
	 * @return
	 */
	public long countStaffBySearch(int flag, String value,String state, String department );
	
	/**
	 * 系统管理员得到查询的所有结果  
	 * @param flag
	 * @param value
	 * @param state
	 * @param department
	 * @return
	 */
	public List<TStaff> getStaffBySearch(int flag, String value,String state, String department );
	
	public List<VStaffHos> getOperatorBySearchByPage(int sqId, int flag, String value, Page page);
	
	/**
	 * 查询统计,用于分页
	 * @param sqId
	 * @param flag
	 * @param hql
	 * @return
	 */
	public long countOpeartorBySearch(int sqId, int flag, String hql);
	/**
	 * 获得当前社区下的所有的操作员, 根据查询条件
	 * @param sqId
	 * @param flag
	 * @param value
	 * @return
	 */
	public List<VStaffHos> getOperatorBySearch(int sqId, int flag, String value);
	/**
	 * 通过社区Id ,获得所有的不是操作员的员工
	 * @param sqId
	 * @return
	 */
	public List<VStaffHos> getAllStaffBySQIdExceptOpe(int sqId);
	
	/**
	 * 统计一个社区下的 操作员数量,用于分页
	 * @param sqId
	 * @return
	 */
	public long countOperatorBySQId(int sqId);
	/**
	 * 得到一个社区下的所有操作员
	 * @param sqId
	 * @param page
	 * @return
	 */
	public List<VStaffHos> getAllOperator(int sqId, Page page);
	/**
	 * 得到一个平台下的所有操作员(不分页)
	 * @return
	 */
	public List<VStaffHos> getAllOperator();
	/**
	 * 得到一个社区下的所有操作员(不分页)
	 * @param sqId
	 * @return
	 */
	public List<VStaffHos> getAllOperator(int sqId);
	/**
	 * 查看是否有该登录名的员工
	 * @param loginName
	 * @return
	 */
	public boolean hasThisOperator(String loginName);
	
	/**
	 * |获得员工编码
	 * @return
	 */
	public String getStaffNumber();
	public List<TStaff> getStaffsBySearch(int dis,int flag, String value, String state, String department, int sqId, Page page);
	/**
	 * 用于查询的分页统计
	 * @param flag
	 * @param value
	 * @param state
	 * @param department
	 * @param sqId
	 * @return
	 */
	public long countStaffBySearch(int dis,int flag, String value, String state, String department, int sqId);
	/**
	 * 一个社区中的查询
	 * @param flag 查询标记 1身份证,2员工编号,3员工姓名
	 * @param value 承接查询值
	 * @param state员工状态
	 * @param department 部门
	 * @param sqId 社区Id
	 * @return
	 */
	public List<TStaff> getStaffsBySearch(int dis,int flag, String value, String state, String department, int sqId);
	/**
	 * 传入的是员工的IDlist ,不是实体list
	 * @param staffIds
	 * @return
	 */
	public int deleteStaffsByList(List<Object> staffIds);
	
	
	
	/**
	 * 添加关系:
	 * 社区医院与员工 
	 * @param OldStaffHos
	 */
	public void saveOldStaffHos(TOldStaffHos  OldStaffHos);
	///////////////////////////////////////////////////////////////
	/**
	 * 根据社区Id获得社区下的所有实体
	 * @param sqId
	 * @return
	 */
	public List<VStaffHos> getAllStaffByCommunityHospitalId(int sqId);
	/**
	 * 根据社区Id获得该社区下的所有的员工,用于封社区号的时候,修改(禁用)该社区下的所有员工的状态
	 * @param communityHospitalId
	 * @return
	 */
	public List<VStaffHos> getAllStaffByCommunityHospitalId(int communityHospitalId,Page page);

	
	/**
	 * 根据社区ID , 获得所有员工的数量--视图  分页
	 * @param sqId
	 * @return
	 */
	public long countVStaffByCommunityHospitalId(int sqId);
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 通过社区id获得该社区下的所有员工的数量 -- 分页
	 * @param sqId
	 * @return
	 */
	public long countStaffByCommunityHospitalId(int sqId);
	
	/**
	 * 根据社区Id, 获得该社区下的所有员工
	 * @param communityHospitalId
	 * @return
	 */
	public List<TStaff> getStaffByCommunityHospitalId(int communityHospitalId);
	/**
	 * 根据社区Id  获得社区下的所有员工
	 * @param communityHospitalId
	 * @return
	 */
	public List<TStaff> getStaffByCommunityHospitalId(int communityHospitalId, Page page);
	
	
	
	
	
	/////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 根据员工姓名得到员工实体列表  模糊查询
	 * 用于添加员工奖惩或者员工请假的时候,自动显示信息  
	 * @param name 员工姓名
	 * @return
	 */
	public List<TStaff> getStaffByStaffName(String name);
	
	/**
	 * 根据员工的身份证号,获得员工实体 
	 * 用于社区添加员工的时候,如果员工已存在,那么直接回显信息
	 * @param IDCardNumber  身份证号
	 * @return 
	 */
	public List<TStaff> getStaffByIDCardNumber(String IDCardNumber );
	
	/**
	 * 操作员登录
	 * @param loginname 登录名(账号)
	 * @param Password  密码
	 * @return 返回登录类型
	 */
	 public Enum loginCheck(String loginname, String Password);
	
	/**
	 * 根据员工的登录名来获得员工实体,用于操作员登录
	 * @param loginName 登录名
	 * @return
	 */
	public List<TStaff> getStaffByLoginName(String loginName);
	/**
	 * 添加员工信息
	 * @param staff 员工实体
	 * @param sqId 社区Id
	 * @return  返回保存结果, 如果返回-1说明没有保存, 如果返回1表明保存成功
	 */
	public int  saveStaff(TStaff staff, int sqId);
	
	/**
	 * 社区负责人删除
	 * 根据员工ID删除员工信息条目  --假删  修改状态 
	 * @param staffId  员工Id
	 */
	public void deleteStaffById(int staffId);
	
	/**
	 * 管理员删除员工, 跳过社区Id的验证
	 * @param staffId
	 */
	public void deleteStaffById_Admin(int staffId);
	
	/**
	 * 系统管理员来看所有的员工信息,不分社区
	 * 统计所有员工数目   用于分页
	 * @return
	 */
	public long countStaff();
	
	/**
	 * 系统管理员来看所有的员工信息,不分社区
	 * 通过分页得到员工基本信息实体列表
	 * @param page
	 * @return
	 */
	public List<TStaff> getStaffByPage(Page page );
	
	/**
	 * 根据staffId得到员工基本信息实体  安全验证 添加一个社区Id
	 * @param staffId 
	 * @return
	 */
	public TStaff getStaffById(int staffId);
	
	/**
	 * 更新员工基本信息
	 * @param staff
	 */
	public void updateStaff(TStaff staff);
	
	/**
	 * 根据员工编码得到员工基本信息实体
	 * @param staffNumber  员工编号
	 * @return
	 */
	public TStaff getStaffByStaffNumber(String staffNumber);

	/**
	 * 黄仕鑫
	 * @return 获得员工编号的List
	 */
	public List getAllStaffNumber();
	/**
	 * xuleping
	 * 通过登录名得到员工实体
	 * @param loginName 登录名
	 * @return  员工实体
	 */
	public TStaff getStaffByloginName(String loginName);
	
	/**
	 * 通过员工id得到 关系表的实体
	 * @param staffId  员工id
	 * @return
	 */
	public TOldStaffHos getOldStaffHosByStaffId(int staffId) ;
	
	/**
	 * 根据员工Id获取社区医院Id
	 * @param staffId  员工Id
	 * @return   社区医院Id
	 */
	public int getCommHospitalByStaffId(int staffId);
	/**
	 * 根据员工Id和社区医院Id，判断是否为该社区员工
	 * @param staffId  员工Id
	 * @param hosId    社区医院Id
	 * @return
	 */
	public Boolean getStaffIsHospital(int staffId, int hosId);
	
	/**
	 * 通过健康档案id拿到老人关系表实体(李卓远)
	 * @param fid 健康档案id
	 * @return 老人关系表实体
	 */
	public TOldStaffHos gethosByFileid(int fid);
	//List<TStaff> getStaffsBySearch(int dis, int flag, String value, String state, String department, int sqId);
	
	/**
	 * 
	 * getRoleByCom:通过医院id得到角色. <br/> 
	 * TODO(这里描述这个方法适用条件 – 可选).<br/> 
	 * @author xuleping
	 * @param comId
	 * @return 
	 * @since JDK 1.8
	 */
	public TRole getRoleByCom();
	
}
