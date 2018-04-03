package com.jmjk.iservice;

import java.util.List;
import com.jmjk.utils.Page;

import com.jmjk.entity.TOldStaffHos;

/**
 * 
 * @author Liufengshuang
 *
 */
public interface IOldStaffHosService {
	/**
	 * 根据doctorId  删除关系
	 * @param doctorId
	 */
	public void deleteByDoctorId(int doctorId);
	
	/**
	 * 根据社区医院Id,得到所有医生
	 * @param HosId
	 * @return
	 */
	public List<TOldStaffHos>  getAllDoctorByHosId(int HosId);
	
	/**
	 * 得到一个社区中所有员工的总数,用于分页
	 * @param communityHospitalId 社区Id
	 * @return
	 */
	public long countAllStaffByCommunityHospitalId(int communityHospitalId);
	
	/**
	 * 根据社区医院的ID,得到社区医院下的所有员工, 
	 * 用于操作员登录后看到本社区的员工信息,分页显示, --员工基本信息查询
	 * @param communityHospitalId
	 * @return
	 */
	public List<TOldStaffHos> getAllStaffByCommunityHospitalId(int communityHospitalId, Page<TOldStaffHos> page);
	
	/**
	 * 根据医院ID和健康档案Id得到 OldStaffHos实体,
	 * @param HosId
	 * @param healthId
	 * @return 责任医生
	 */
	public TOldStaffHos getOldStaffHosByHosIdAndHeathFileId(int HosId, int healthId);
	/**
	 *  根据员工ID 得到员工所在医院的  关系表  实体  
	 * @param staffId 员工ID
	 * @return
	 */
	public TOldStaffHos getOldStaffHosByStaffId(int staffId);
	
	/**
	 * 通过慢病档案id得到对应的实体(李卓远)
	 * @param fid 健康档案id
	 * @return 关系表实体
	 */
	public TOldStaffHos getOldStaffHosByHealthId(int fid);
	
	/**
	 * 
	 * @param healthId 档案编号ID 
	 * @param hosId    社区ID
	 * @return  是否存在
	 */
	public boolean getOldStaffHosByHealthIdAndHosId(int healthId,int hosId);
	
	/**
	 * 根据档案id得到 关系表实体
	 * @param fileId
	 * @return
	 */
	public TOldStaffHos getOldStaffHosByFileId(int fileId);
	
	
}
