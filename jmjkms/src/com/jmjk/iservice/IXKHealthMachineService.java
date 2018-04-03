package com.jmjk.iservice;

import java.util.Date;
import java.util.List;

import com.jmjk.entity.THealthFile;
import com.jmjk.entity.TOldStaffHos;
import com.jmjk.entity.view.VFollowRecord;
import com.jmjk.pojo.AlarmGetDateGet;
import com.jmjk.pojo.AlarmRequestParam;
import com.jmjk.pojo.AlarmHandleRequest;
import com.jmjk.pojo.AlarmHandleResponse;
import com.jmjk.utils.Page;
/**
 * 熙康一体机体检记录
 * @author dkdh
 *
 */
public interface IXKHealthMachineService {


	/**
	 * 从云端获取社区老人的熙康一体机体检数据并分页
	 * @param IDNumbers
	 * @param JCXM
	 * @param currentPage
	 * @param pageSize
	 * @param startTime
	 * @param endTime
	 * @param appUserID
	 * @return json结果字符串
	 */
	public String getXKHealthMachineList(String IDNumbers,
			String JCXM, Integer currentPage, Integer pageSize,
			String startTime, String endTime, String appUserID);
	
	/**
	 * 查询熙康体检记录详情
	 * @param id
	 * @return json结果字符串
	 */
	public String getXKHealthMachineById(Long id);
	
//	/**
//	  * 预警处理
//	  * @param alarm 
//	  * @return   AlarmHandleResponse的实体
//	  */
//	public String updateAlarmType(int id, int state,int alarmType);
//	
//    /**
//     * 通过员工id拿到健康档案的一个list集合
//     */
//	 public List<TOldStaffHos> getHealthListByStaffId(int staffId);
//	 
//	 //通过社区id拿到健康档案的list
//	
//    public List<TOldStaffHos> getHealthListByCommunityHospitalId(int CommunityHospitalId);
//
//	/**
//	 * 通过责任医生查询老人档案 从三个云端系统中
//	 * @param docId 
//	 * @return
//	 */
//    public String getHealthFileFromCloudByDoctor(int docId);
//    
//    /**
//     *  通过医院负责人查询老人档案 从三个云端系统中
//     * @param hosId
//     * @return
//     */
//    public String getHealthFileFromCloudByHos(int hosI);



	
}
