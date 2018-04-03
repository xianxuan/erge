package com.jmjk.iservice;

import java.util.Date;
import java.util.List;

import org.hibernate.service.jta.platform.internal.OC4JJtaPlatform;

import com.jmjk.entity.view.VChronic;
import com.jmjk.entity.view.VOldStaff;
import com.jmjk.pojo.BloodOxygen;
import com.jmjk.pojo.BloodPress;
import com.jmjk.pojo.BloodSuger;
import com.jmjk.pojo.HealthFileSingleCloud;
import com.jmjk.pojo.Suggest;
import com.jmjk.utils.Page;
import com.jmjk.utils.SearchBean;
 
/**
  * 
  * @author 张晓光
  * 2016年8月4号
  *
  */
public interface IHealthManagerService {
	/**
	 * 检测上传血压的数据
	 * @param bloodPress 血压的pojo参数类
	 * @return 对接系统的反馈信息
	 */
	public String addBloodPressData(BloodPress bloodPress);
	
	/**
	 * 检测上传血糖的数据
	 * @param bloodSuger 血糖的pojo参数类
	 * @return 对接系统的反馈信息
	 */
	public String addBloodSugarData(BloodSuger bloodSuger);
	/**
	 * 检测上传血氧的数据
	 * @param bloodOxygen 血氧的pojo参数类
	 * @return 对接系统的反馈信息
	 */
	public String addBloodOxygenData(BloodOxygen bloodOxygen);
	/**
	 * 拿到所有血压数据
	 * @param appUserID
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public String getAllBloodPressData(String appUserID,int currentPage,int pageSize);
	/**
	 *  按照时间条件查询血压数据
	 * @param appUserID 对接系统用户id
	 * @param startTime 查询开始的时间查询开始的时间
	 * @param endTime 查询结束时间
	 * @param currentPage 当前页
	 * @param pageSize 页面容量
	 * @return 返回一个json 串
	 */
	public String getBloodPressData(String appUserID,Date startTime,Date endTime,int currentPage,int pageSize);
	/**
	 * 按照条数条件查询血压数据
	 * @param appUserID 对接系统用户id
	 * @param totalSize 查询的总条数
	 * @param currentPage 当前页
	 * @param pageSize 页面容量
	 * @return 返回一个json 串
	 */
	public String getBloodPressData(String appUserID,int totalSize,int currentPage,int pageSize);
	/**
	 *  删除指定的血压数据
	 * @param id 对接档案id
	 * @param appUserID 对接用户id
	 * @return 返回反馈信息
	 */
	public String deleteBPCloud(int id);
	/**
	 * 更新目标系统上的血压数据
	 * @param id 目标血压数据id
	 * @param bloodPress 封装的血压基本数据对象
	 * @return 返回目标系统的反馈信息
	 */
	public String updateBPCloud(int id,BloodPress bloodPress);
	/**
	 * 拿到所有血糖数据
	 * @param appUserID
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public String getAllBloodSugerData(String appUserID,int currentPage,int pageSize);
	/**
	 *  按照时间条件查询血糖数据
	 * @param appUserID 对接系统用户id
	 * @param startTime 查询开始的时间查询开始的时间
	 * @param endTime 查询结束时间
	 * @param currentPage 当前页
	 * @param pageSize 页面容量
	 * @return 返回一个json 串
	 */
	public String getBloodSugerData(String appUserID,Date startTime,Date endTime,int currentPage,int pageSize);
	/**
	 * 按照条数条件查询血糖数据
	 * @param appUserID 对接系统用户id
	 * @param totalSize 查询的总条数
	 * @param currentPage 当前页
	 * @param pageSize 页面容量
	 * @return 返回一个json 串
	 */
	public String getBloodSugerData(String appUserID,int totalSize,int currentPage,int pageSize);
	/**
	 *  删除指定的血糖数据
	 * @param id 对接档案id
	 * @param appUserID 对接用户id
	 * @return 返回反馈信息
	 */
	public String deleteBSCloud(int id);
	/**
	 * 更新目标系统上的血糖数据
	 * @param id 目标血糖数据id
	 * @param bloodPress 封装的血压基本数据对象
	 * @return 返回目标系统的反馈信息
	 */
	public String updateBSCloud(int id,BloodSuger bloodSuger);
	/**
	 * 拿到所有血氧数据
	 * @param appUserID
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public String getAllBloodOxygenData(String appUserID,int currentPage, int pageSize);
	/**
	 *  按照时间条件查询血氧数据
	 * @param appUserID 对接系统用户id
	 * @param startTime 查询开始的时间查询开始的时间
	 * @param endTime 查询结束时间
	 * @param currentPage 当前页
	 * @param pageSize 页面容量
	 * @return 返回一个json 串
	 */
	public String getBloodOxygenData(String appUserID,Date startTime,Date endTime,int currentPage,int pageSize);
	/**
	 * 按照条数条件查询血氧数据
	 * @param appUserID 对接系统用户id
	 * @param totalSize 查询的总条数
	 * @param currentPage 当前页
	 * @param pageSize 页面容量
	 * @return 返回一个json 串
	 */
	public String getBloodOxygenData(String appUserID,int totalSize,int currentPage,int pageSize);
	/**
	 *  删除指定的血氧数据
	 * @param id 对接档案id
	 * @return 返回反馈信息
	 */
	public String deleteBOCloud(int id);
	/**
	 * 更新目标系统上的血氧数据
	 * @param id 目标血氧数据id
	 * @param bloodOxygen 封装的血压基本数据对象
	 * @return 返回目标系统的反馈信息
	 */
	public String updateBOCloud(int id,BloodOxygen bloodOxygen);
	
	/**
	 *  分页获取所有的一体机数据
	 * @param appUserID 对接系统用户
	 * @param currentPage 当前页
	 * @param pageSize 页容量
	 * @return 返回数据json串
	 */
	public String getAIOData(String appUserID, int currentPage,int pageSize);
	/**
	 * 按时间查询一体机数据
	 * @param appUserID
	 * @param currentPage
	 * @param pageSize
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public String getAIODataByTime(String appUserID,int currentPage,int pageSize,Date startTime,Date endTime);
	/**
	 * 按数量查询一体机数据
	 * @param appUserID
	 * @param currentPage
	 * @param pageSize
	 * @param count
	 * @return
	 */
	public String getAIODataByCount(String appUserID,int currentPage,int pageSize,int count);
	/**
     * 责任医生从云平台上获取老人的信息列表
     * @param currentPage
     * @param pageSize
     * @return
     */
    public String getHealthFileFromCloudByDoctor(int docId ,int currentPage,int pageSize);
	/**
	 * 社区负责人从云平台上获取老人的信息列表
	 * @param hosId
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public String getHealthFileFromCloudByHos(int hosId,int currentPage,int pageSize);
    /**
     * 修改健康建议
     * @param suggestJson
     * @return
     */
    public String editSuggest(String suggestJson);
    
	  /**
	  * 从云端根据云端档案的id，获取档案
	  * @param id
	  * @return
	  */
	 public HealthFileSingleCloud.HealthFile getHealthfileCloudById(int id);

    
    
	/*************     赖清发      ****************/
	/**
	 * 多条件查询
	 * @param bean
	 * @param page
	 * @return
	 */
	List<VOldStaff> getvOldStaffsList(SearchBean bean, Page<VOldStaff> page);
	/**
	 * 总数
	 * @param se
	 * @return
	 */
	public long findvOldStaffsListCount(SearchBean se);
	/**
	 * 三种疾病多条件查询
	 * @param bean
	 * @param page
	 * @return
	 */
	List<VChronic> getVChronicList(SearchBean bean, Page<VChronic> page);
	/**
	 * 三种疾病多条件查询总数
	 * @param se
	 * @return
	 */
	public long findVChronicListCount(SearchBean se);
	/**
	 * 保存一体机中健康指导和健康评价数据
	 * @param appUserID 老人id
	 * @param id	健康一体机数据id
	 * @param advice 健康评价
	 * @param guide  健康指导
	 * @return
	 */
	public String addHealthGuide(String appUserID, int id, String advice, String guide);

	
	
	
	
	
	
	

    /**
     * 获取某一个档案的建议列表
     * @param healthFileId
     * @param currentPage
     * @param pageSize
     * @return
     */
	public String getSuggestsByHealthFileId(int healthFileId ,String belongSys, int currentPage , int pageSize);
    /**
     * 添加医生建议
     * @param suggest
     */
	public String addSuggestCloud(Suggest suggest);

	/**
	 * 删除医生建议
	 * @param id
	 * @return
	 */
	public String deleteSuggestCloud(int id);

	
	/**
	 * 得到体检信息
	 * @param temp
	 */
	public String getPhysicExemCloud(int Id,String blongSys,int currentPage,int pageSize);

	/**
	 * 根据体检信息获取详细的体检信息
	 * @param physicalExamId
	 */
	public String getPhysicExemByIdCloudDetail(int physicalExamId);

	
}
