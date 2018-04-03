package com.jmjk.iservice;

import java.util.List;

import antlr.collections.impl.LList;

import com.jmjk.entity.TFileLifeStyle;
import com.jmjk.entity.TFileMedicalRecord;
import com.jmjk.entity.THealthFile;
import com.jmjk.entity.TMedicalPayMethod;
import com.jmjk.entity.TOldStaffHos;
import com.jmjk.entity.TPastHistory;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.view.VChronic;
import com.jmjk.entity.view.VHealthStaff;
import com.jmjk.entity.view.VOldStaff;
import com.jmjk.entity.view.VStaffHos;
import com.jmjk.entity.view.VStaffHosSu;
import com.jmjk.pojo.HealthFileCloud;
import com.jmjk.utils.Page;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.SearchBeanSU;
/**
 * 
 * @author 苏东航
 *
 */
public interface IHealthFileService {
	/**
	 * 根据在服务器端的档案id得到档案json串，包括4个子表，【用于详情展示、编辑】
	 * @param id
	 * @return 返回档案实体的json串，包括4个子表
	 */
	public String getHealthFileCloudForDetail(int id);
	/**
	 * [责任医生，多条件查询]从服务器得到老人的list,返回json串
	 * @param searchbean 多条件查询得到的参数
	 * @param currentPage
	 * @param pageSize
	 * @return 返回json串
	 */
	public String getHealthFileCloudForManySpecial(SearchBeanSU searchbean ,int docId,int currentPage,int pageSize);
	/**
	 * [社区负责人，多条件查询]从服务器得到老人的list,返回json串
	 * @param searchbean 多条件查询得到的参数
	 * @param currentPage
	 * @param pageSize
	 * @return 返回json串
	 */
	public String getHealthFileCloudForMany(SearchBeanSU searchbean ,int hosId,int currentPage,int pageSize);
	/**
	 * 保存健康档案
	 * @param healthfile 健康档案实体
	 */
	public void saveHealthFile(THealthFile healthfile);
	
	/**
	 * 根据档案Id删除健康档案
	 * @param healthFileId 健康档案Id
	 */
	public void deleteHealthFile(int hFileid);
	/**
	 * 根据档案Id死亡登记健康档案
	 * @param id
	 */
	public void killHealthFile(int hFileid);
	/**
	 * 根据档案Id注销健康档案
	 * @param hFileid
	 */
	public void cancelHealthFile(int hFileid);
	/**
	 * 批量删除健康档案
	 * @param deleteList
	 */
	public void deleteHealthyFile(List<Object> deleteList);
	/**
	 * 批量死亡注销健康档案
	 * @param killList
	 */
	public void killHealthyFile(List<Object> killList);
	/**
	 * 更改健康档案
	 * @param healthfile
	 */
	public void updateHealthFile(THealthFile healthfile);
	/**
	 * 预取健康档案Id
	 * @return
	 */
	public int getAutoId();
	/**
	 * 通过添加健康档案得到刚添加的健康档案的Id
	 * @param healthfile 添加健康档案
	 * @return
	 */
	public int getAutoIdBySaveHealthFile(THealthFile healthfile);
	/**
	 * 根据档案编号得到档案ID
	 * @param fileNum
	 * @return
	 */
	public int gethFileidByfileNum(String fileNum);
	/**
	 * 通过档案编号fileNum得到健康档案
	 * @param fileNum档案编号
	 * @return
	 */
	public THealthFile getHealthFileByFileNum(String fileNum);
	/**
	 * 通过档案编号fileNum得到健康档案,社区医院Id校验
	 * @param fileNum
	 * @param hosName 社区医院名称
	 * @return
	 */
	public THealthFile getHealthFileByFileNum(String fileNum ,String hosName);
	
	/**
	 * 根据健康档案Id得到健康档案
	 * @param healthFileId
	 * @return
	 */
	public THealthFile getHealthFileById(int hFileid);
	/**
	 * 根据健康档案Id得到健康档案,并且进行社区Id校验
	 * @param hFileid
	 * @param hosName  社区医院名称
	 * @return
	 */
	public THealthFile getHealthFileById(int hFileid,String hosName);
	/**
	 * 根据身份证号得到健康档案
	 * @param idNum身份证号
	 * @return
	 */
	public THealthFile getHealthFileByIdNum(String idNum);
	/**
	 * 根据身份证号得到健康档案,并且进行社区Id校验
	 * @param idNum
	 * @param hosName 社区名称
	 * @return
	 */
	public THealthFile getHealthFileByIdNum(String idNum,String hosName);
	/**
	 * 根据责任医生的Id,得到该医生所对应的老人数量(责任医生)
	 * @param staffId
	 * @return
	 */
	public long getHealthFileCountForSpecial(int staffId,int state);
	/**
	 * 根据责任医生的Id,得到该医生所对应的老人数量(责任医生多条件)
	 * @param se
	 * @param staffId
	 * @param state
	 * @return
	 */
	public long findChronicPeopleCount(SearchBeanSU se,int staffId) ;
	/**
	 * 获取整个平台健康档案的数量(平台管理员)
	 * @return 整个平台健康档案的数量
	 */
	public long getHealthFileCount();
	/**
	 * 获取集团的老人数量(集团登陆时的首页展示)
	 * @param groupId 集团id
	 * @return
	 */
	public long getHealthFileCountForGroup(int groupId);
	/**
	 * 得到集团下所有老人
	 * @param groupId集团id
	 * @return
	 */
	public List<VHealthStaff> getAllHealthFileForGroup(Page<THealthFile> page,int groupId,int state);
	/**
	 * 首页多条件查询，得到总条数，用于分页（平台管理员多条件）
	 * @param se
	 * @return
	 */
	public long findChronicPeopleCount(SearchBeanSU se) ;
	/**
	 * 根据社区医院的名称得到该医院的健康档案数量(社区管理员)
	 * @param hosName
	 * @return
	 */
	public long getHealthFileCount(String hosName);
	/**
	 * 根据社区医院的名称得到该医院的健康档案数量(社区管理员多条件)
	 * @param se
	 * @param hosName
	 * @return
	 */
	public long findChronicPeopleCount(SearchBeanSU se,String hosName) ;
	public  List<TStaff> getSpeciallDoctor(int hosId);
	/**
	 * 手机号检查时候已经注册
	 * @param iphone
	 * @return
	 */
	public THealthFile getHealthFileByIphone(String iphone);
	/**
	 * 得到某医院某状态的全部健康档案(社区管理员),(导出)
	 * @param state
	 * @param hosName
	 * @return
	 */
	public List<THealthFile> getAllHealthFile(int state,String hosName);
	
	/**
	 * 根据老人姓名查找健康档案
	 * @param name 老人姓名
	 * @return
	 */
	public List<THealthFile> getAllHealthFileByOldName(Page<THealthFile> page,String name);
	/**
	 * 根据医院id得到该医院所有健康状态下VHealthStaff视图实体
	 * @param hosId
	 * @return
	 */
	public List<VHealthStaff> getAllHealthFileByHospitalId(int hosId);
	/**
	 * 得到某医院某状态的全部健康档案(社区管理员)
	 * @param page
	 * @param state
	 * @param hosName
	 * @return
	 */
	public List<THealthFile> getAllHealthFile(Page<THealthFile> page,int state,String hosName);
	/**
	 * 得到某医院某状态的全部健康档案(社区管理员多条件)
	 * @param se
	 * @param page
	 * @param state
	 * @param hosName
	 * @return
	 */
	public List<VHealthStaff> findChronicPeople(SearchBeanSU se , Page<VHealthStaff> page,String hosName);
	/**
	 * 得到所有老人档案（用于集团负责人）（用于多条件查询）
	 * @param se
	 * @param page
	 * @param groupId
	 * @return
	 */
	public List<VHealthStaff> findChronicPeopleForGroup(SearchBeanSU se , Page<VHealthStaff> page,int groupId);
	/**
	 * 得到所有老人档案（用于集团负责人）（用于导出）
	 * @param groupId 集团id
	 * @return
	 */
	public List<VHealthStaff> findOldPeopleForGroup(int groupId);
	/**
	 * 得到某状态的全部健康档案(平台管理员)，（导出）
	 * @param state
	 * @return
	 */
	public List<THealthFile> getAllHealthFile(int state);
	/**
	 * 得到某状态的全部健康档案(平台管理员)
	 * @param page
	 * @param state
	 * @return
	 */
	public List<THealthFile> getAllHealthFile(Page<THealthFile> page,int state);
	//public List<THealthFile> getAllHealthFileForGroup(Page<THealthFile> page,int state);
	/**
	 * 首页多条件查询，得到所有数据，用于分页（平台管理员多条件）
	 * @param se
	 * @param page
	 * @return
	 */
	public List<VHealthStaff> findChronicPeople(SearchBeanSU se , Page<VHealthStaff> page);
	/**
	 * 根据员工id得到责任医生对应的健康档案list(责任医生得到对应的老人)，（导出）
	 * @param state
	 * @param staffId
	 * @return
	 */
	public List<THealthFile> getHealthFileListByStaffIdForSpeciall(int state,int staffId);
	/**
	 * 根据员工id得到责任医生对应的健康档案list(责任医生得到对应的老人)
	 * @param staffId 员工id
	 * @return 健康档案list
	 */
	public List<THealthFile> getHealthFileListByStaffIdForSpeciall(Page<THealthFile> page,int state,int staffId);
	/**
	 * 根据员工id得到责任医生对应的健康档案list(责任医生多条件)
	 * @param se
	 * @param page
	 * @param state
	 * @param staffId
	 * @return
	 */
	public List<VHealthStaff> findChronicPeople(SearchBeanSU se , Page<VHealthStaff> page,int staffId);
	/**
	 * 根据健康档案Id得到健康档案编号
	 * @param healthFileId 据健康档案Id
	 * @return
	 */
	public String getFileNum(int healthFileId);
	/**
	 * 修改健康档案同步到服务器
	 * @param healthfile 健康档案表 
	 * @param pastHistoryList 既往史表
	 * @param medicalPayMethodList 付费方式表
	 * @param docId 责任医生id
	 * @return 是否上传成功，ture为上传成功
	 */
	public boolean editHealthFileToCloulds(THealthFile healthFile,List<TPastHistory> pastHistoryList,List<TMedicalPayMethod> medicalPayMethodList,List<TFileLifeStyle> tlifestyleList,List<TFileMedicalRecord>  fileMedicalRecordList,int docId);
	/**
	 * 添加健康档案同步到服务器
	 * @param healthfile 健康档案表 
	 * @param pastHistoryList 既往史表
	 * @param medicalPayMethodList 付费方式表
	 * @param docId 责任医生id
	 * @return 是否上传成功，ture为上传成功
	 */
	public boolean addHealthFileToCloulds(THealthFile healthFile,List<TPastHistory> pastHistoryList,List<TMedicalPayMethod> medicalPayMethodList,List<TFileLifeStyle> tlifestyleList,List<TFileMedicalRecord> fileMedicalRecordList,int docId);
	/**
	 * 删除健康档案，同步到服务器
	 * @param healthFileId 老人id
	 * @return
	 */
	public boolean deleteHealthFileToCloulds(int healthFileId,int type);
	/**
	 * 责任医生从服务器得到自己的老人（责任医生-服务器）
	 * @param staffId 责任医生的员工id
	 * @param apppKey
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public String getHealthFilesFromCloudsForSpecial(int staffId,String apppKey,int currentPage,int pageSize);//应该返回json串
	/**
	 * 社区负责人从服务器得到自己老人（社区负责人-服务器）
	 * @param staffIds 社区医院下的所有责任医生的id
	 * @param apppKey
	 * @param currentPage
	 * @param pageSize
	 * @return
	 */
	public String getHealthFilesFromCloudsForNormal(List<Integer> staffIds,String apppKey,int currentPage,int pageSize);//应该返回json串
	/**
	 * 得到健康档案的分页信息(责任医生从服务器获取)
	 * @return
	 */
	public HealthFileCloud getInfoFromCloudsForSpecial();
	/**
	 * 得到健康档案的分页信息（社区负责人从服务器获取）
	 * @return
	 */
	public HealthFileCloud getInfoFromCloudsForNormal();
	/****************************老人/员工/医院关系表（苏东航）********************************************/
	/**
	 * 得到平台所有医生
	 * @param HosId
	 * @return
	 */
	public List<VStaffHos>  getAllDoctorByHosId();
	/**
	 * 根据社区医院Id,得到所有医生
	 * @param HosId
	 * @return
	 */
	public List<VStaffHos>  getAllDoctorByHosId(int HosId);
	/**
	 * 根据老人Id得到试图实体
	 * @param heathFileId
	 * @return
	 */
	public VStaffHos getVStaffHosByHeathFileId(int heathFileId);
	/**
	 * 根据老人Id得到试图实体(su方法),用于责任医生
	 * @param heathFileId
	 * @param state
	 * @return
	 */
	public VStaffHosSu getVStaffHosSuByHeathFileId(int heathFileId,int state);
	/**
	 * 根据医院ID和健康档案Id得到 OldStaffHos实体,
	 * @param HosId
	 * @param healthId
	 * @return 责任医生
	 */
	public TOldStaffHos getOldStaffHosByHosIdAndHeathFileId(int HosId, int healthId);
	/**
	 * 根据责任医生id得到关系表实体list(为许乐平提供)
	 * @param HosPeopleId 社区负责人id
	 * @param staffId 责任医生id
	 * @return  关系表实体list
	 */
	public List<TOldStaffHos> getOldStaffHosListByStaffId( int staffId);
	
	/**
	 * 通过员工Id,得到关系实体，用于检测该员工是否为责任医生
	 * @param staffId 员工Id
	 * @return 返回值为空时，说明不是责任医生
	 */
	public boolean getOldStaffHosByStaffId(int staffId);
	/**
	 * 在员工、医院、老人关系表里，通过员工Id,得到责任医生负责的所有老人id
	 * @param staffId 员工Id
	 * @return 责任医生负责的所有老人id
	 *//*
	public List<Integer> getHealthFileIdListByStaffId(int staffId);*/
	/**
	 * 添加关系:
	 * 健康档案与责任医生
	 * 社区医院与员工
	 * 
	 * @param OldStaffHos
	 */
	public void saveOldStaffHos(TOldStaffHos  OldStaffHos);
	/**
	 * 删除关系（苏东航）
	 * @param OldStaffHos
	 */
	public void deleteOldStaffHos(int heathFileId);
	/**
	 * 根据责任医生id,批量删除关系（为许乐平提供）
	 * @param staffId  责任医生id
	 */
	public void deleteOldStaffHosByStaffId(int staffId);
	/**
	 * 用于添加门诊查找对应老人时，根据姓名查找老人(用于责任医生)
	 * @return 老人list  VHealthStaff类
	 */
	public List<VHealthStaff> getVHealthStaffByOldNameForSpecial(int staffId,String name);
	/**
	 *  用于添加门诊查找对应老人时，根据姓名查找老人(用于普通医生、社区负责任人)
	 * @param name
	 * @return 老人list  VHealthStaff类
	 */
	public List<VHealthStaff> getVHealthStaffByOldNameForNormal(int hospitalId,String name);
	/******************************晓光的代码**************************************************************************/
	/**
	 * @author 张晓光
	 * 健康管理医生获取老人档案基本信息
	 * @return
	 */
	public List<VOldStaff> getOldStaffsListByStaff(Page<VOldStaff> page,int staffId);
	public long countOldStaffByStaff(int staffId);
	/**
	 * 健康管理社区管理员获取老人档案基本信息
	 * @author 张晓光
	 * @param page
	 * @param communityHosiptalId
	 * @return
	 */
	public List<VOldStaff> getOldStaffsListBycommunityAdmin(Page<VOldStaff> page,int communityHosiptalId);
	public long countOldStaffBycommunityAdmin(int communityHosiptalId);
	/**
	 * 健康管理平台管理员获取老人档案基本信息
	 * @author 张晓光
	 * @param page
	 * @return
	 */
	public List<VOldStaff> getOldStaffByPlatAdmin(Page<VOldStaff> page);
	public long countStaffByPlatAdmin();
	/**
	 * 根据档案id列表获得档案实体列表
	 * @author 张晓光
	 * @param healthFileIds 档案id列表
	 * @param page
	 * @return
	 */
	public List<THealthFile> getHealthFilesByIds(List<Integer> healthFileIds ,Page<THealthFile> page);
	/**
	 * 健康平台管理员获取老人档案基本信息  不分页
	 * 赖清发
	 * @return
	 */
	public List<VOldStaff> getOldStaffsListByPlatAdmin();
	/**
	 * 员工id获取老人档案基本信息  不分页
	 *     赖清发
	 * @return
	 */
	public List<VOldStaff> getOldStaffsListBystaffId(int staffId );
	/**
	 * 健康管理社区管理员获取老人档案基本信息
	 * @author 赖清发
	 * 
	 * @param communityHosiptalId
	 * @return
	 */
	public List<VOldStaff> getOldStaffsListBycommunityid(int communityHosiptalId);

	/**
	 * 根据健康档案Id得到 OldStaffHos实体,
	 * @param HosId
	 * @param healthId
	 * @return 责任医生
	 */
	public TOldStaffHos getOldStaffHosByHeathFileId( int healthId);
	/**
	 * 
	 * @param idNum  身份证号
	 * @return
	 */
	public THealthFile gethealthFileByIdNum( String idNum);
	
//==========================================ZFL===================================	
	/**
	 *  通过健康档案ID 得到  关系表实体
	 * @param healthId   健康档案ID
	 * @return
	 */
	public TOldStaffHos getTOldStaffHosByhealthId(int healthId);
	
//================================================================================	
	/**
	 * 根据老人身份证号查询老人-社区-责任医生实体
	 * @param idCard   老人id
	 * @return  老人-社区-责任医生实体
	 */
	public VOldStaff  getHealthFileByIdCard(String idCard);
	/**
	 * 根据老人id得到VOldStaff实体
	 * @param healthFileId
	 * @return
	 */
	public VOldStaff getOldStaffByhealthId(int healthFileId);
    
	
	//-----------------------最新添加-------------朱德江
	/**
	 * 通过集团gid得到集团下所有老人
	 * @param gId
	 * @return
	 */
	public List<THealthFile> getGroupAllOldsByGId(int gId);
	/**
	 * 地址栏校验 通过老人id判断是否是属于该集团
	 * @param healthFileId 老人档案id
	 * @param gId 集团id
	 * @return
	 */
	public boolean isGroupOld(int healthFileId, int gId);
	


//----------------------↓最新添加↓2017-1-16--------------------------------李卓远

	/**
	 * 李卓远
	 * 通过健康档案id拿到  一个视图实体 用于校验一个老人是否属于这个集团
	 * @param hid
	 * @return
	 */
	public VHealthStaff getGroup(int hid);
	/**
	 * 得到集团下的所有老人
	 * @param gid
	 * @return
	 */
	public List<VOldStaff> getOldStaffsListByGroupAdmin(int gid);
	//----------------------↓最新添加↓2017-3-7-------------------------------朱德江
	/**
	 * VOldStaff中得到集团下所有老人数量
	 * @param gId 
	 * @return
	 */
	public long getHealthFileCountGroup(Integer gId);
	/**
	 * VOldStaff中得到集团下所有老人并分页
	 * @param page
	 * @param gId
	 * @return
	 */
	public List<VOldStaff> getAllHealthFileGroup(Page<VOldStaff> page,Integer gId);
	
//----------------------↑最新添加↑------------------------------------

	/****************add byzxf 20170512********************/
	/**
	 * 通过老人名字查找平台管理员下的老人
	 * @param name
	 * @return
	 */
	public List<VOldStaff> getOldStaffsListByPlatAdminAndOldName(String name);
	/**
	 * 通过老人名字查找集团管理员下的老人
	 * @param gid
	 * @param name
	 * @return
	 */
	public List<VOldStaff> getOldStaffsListByGroupAdminAndOldName(int gid, String name);
	/**
	 * 通过老人名字查找员工下的老人
	 * @param staffId
	 * @param name
	 * @return
	 */
	public List<VOldStaff> getOldStaffsListBystaffIdAndOldName(int staffId, String name);
	/**
	 * 通过老人名字查找社区管理员下的老人
	 * @param communityHosiptalId
	 * @param name
	 * @return
	 */
	public List<VOldStaff> getOldStaffsListBycommunityidAndOldName(
			int communityHosiptalId, String name);
	/****************add byzxf 20170512********************/
	
	/****************add byzxf 20170517********************/
	/**
	 * 通过老人名字和身份证号查找平台管理员下的老人
	 * @param name
	 * @param idNum
	 * @return
	 */
	public List<VOldStaff> getOldStaffsListByPlatAdminAndOldNameIDNum(String name, String idNum);
	/**
	 * 通过老人名字和身份证号查找集团管理员下的老人
	 * @param gid
	 * @param name
	 * @param idNum
	 * @return
	 */
	public List<VOldStaff> getOldStaffsListByGroupAdminAndOldNameIDNum(int gid, String name,String idNum);
	/**
	 * 通过老人名字和身份证号查找员工下的老人
	 * @param staffId
	 * @param name
	 * @param idNum
	 * @return
	 */
	public List<VOldStaff> getOldStaffsListBystaffIdAndOldNameIDNum(int staffId, String name,String idNum);
	/**
	 * 通过老人名字和身份证号查找社区管理员下的老人
	 * @param communityHosiptalId
	 * @param name
	 * @param idNum
	 * @return
	 */
	public List<VOldStaff> getOldStaffsListBycommunityidAndOldNameIDNum(
			int communityHosiptalId, String name,String idNum);
	/****************add byzxf 20170517********************/
	
}
