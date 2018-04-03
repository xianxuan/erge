package com.jmjk.iservice;

import java.util.Date;
import java.util.List;

import javax.swing.Spring;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jmjk.dao.HospitalHistoryDao;
import com.jmjk.dao.MedicalUseDao;
import com.jmjk.dao.VExamDao;
import com.jmjk.entity.SearchClass;
import com.jmjk.entity.TAuxiliaryExamination;
import com.jmjk.entity.TCheck;
import com.jmjk.entity.TChinaMedicine;
import com.jmjk.entity.TDefendInocu;
import com.jmjk.entity.TGeneralCondition;
import com.jmjk.entity.THF;
import com.jmjk.entity.THealthExtingProblem;
import com.jmjk.entity.THealthFile;
import com.jmjk.entity.THospitalHistory;
import com.jmjk.entity.TLifeStyle;
import com.jmjk.entity.TMedicalUse;
import com.jmjk.entity.TOrganFunction;
import com.jmjk.entity.TPhysicalExam;
import com.jmjk.entity.view.VExam;
import com.jmjk.entity.view.VHealthStaff;
import com.jmjk.pojo.PhysicalExamBypersonal;
import com.jmjk.utils.Page;

/**
 * 健康体检
 * @author zfl
 *
 */

public interface IPhysicalExamService {
	
	//====================================服务器接口交互==========================================
	/**
	 * 保存体检 在54服务器
	 */
	public boolean saveTPhysicalExamBy54(TPhysicalExam tphysicalexam, TAuxiliaryExamination auxiliaryExamination
			,TCheck check,TChinaMedicine chinaMedicine,TGeneralCondition generalCondition,
			THealthExtingProblem healthExtingProblem,TLifeStyle lifeStyle,TOrganFunction organFunction );
	/**
	 * 删除体检 在54服务器
	 * @param tphysicalexamid 
	 * @return
	 */
	
	public boolean deleteTPhysicalExamBy54(int tphysicalexamid);
	/**
	 * 返回 健康档案 视图 实体 姓名搜索 可能 是List
	 * @param name  老人姓名（可选项）
	 * @param idNum 身份证号（可选项）
	 * @param fileNum fileNum 档案号（可选项）
	 * @return
	 */
	public List<VHealthStaff> getVHealthStaffBy54(String name,String idNum,String fileNum,int type,int id);
	
	/**
	 * 返回 一个 健康档案 实体
	 * @param name  老人姓名（可选项）
	 * @param idNum 身份证号（可选项）
	 * @param fileNum fileNum 档案号（可选项）
	 * @return
	 */
	public THealthFile getThealthFileBy54(String name,String idNum,String fileNum,int type,int id);
	
	/**
	 * 修改体检
	 * @param tphysicalexamid
	 * @return
	 */
	public boolean editTPhysicalExamBy54(TPhysicalExam tphysicalexam, TAuxiliaryExamination auxiliaryExamination
			,TCheck check,TChinaMedicine chinaMedicine,TGeneralCondition generalCondition,
			THealthExtingProblem healthExtingProblem,TLifeStyle lifeStyle,TOrganFunction organFunction);
	/**
	 * 根据 健康档案ID 获取体检列表带分页
	 * @param healthFileId 健康档案ID
	 * @return
	 */
	public PhysicalExamBypersonal getPhysicalExamBypersonalBy54(int  healthFileId,int belongSystem,int currentPage);
	/**
	 * 根据 健康档案ID 获取全部1000条体检列表 不带分页
	 * @param healthFileId 健康档案ID
	 * @return
	 */
	public PhysicalExamBypersonal getPhysicalExamBypersonalBy54(int  healthFileId,int belongSystem);
	/**
	 * 获得单个体检 在54服务器
	 * @param tphysicalexamid
	 * @return
	 */
	public TPhysicalExam getOneTPhysicalExamBy54(int tphysicalexamid,int fileType);
	/**
	 * 责任医生获取 所管辖病人  带分页
	 * @param responsibleDoctor 责任医生名
	 * @param currentPage 页码
	 * @param pageSize 
	 * @return
	 */
	public List<VExam> searchResponsibleDoctorVExamViewBy54(String responsibleDoctor,int fileType,int currentPage,int pageSize);
	/**
	 * 根据集团ID获取 体检视图  数量 
	 * @param gid集团ID
	 * @return
	 */
	public int getVExamListByGid(int gid,int fileType);
	
	/**
	 * 根据健康档案ID 获取所有实体List 带分页
	 * @param healthFileId
	 * @param page
	 * @return
	 */
	public List<VExam> getPhysicalExamListByHealthFileId(int healthFileId,Page<VExam>  page);
	/**
	 * 根据健康档案ID 获取所有实体List 是数量
	 * @param healthFileId
	 * @param page
	 * @return
	 */
	public Long getPhysicalExamListByHealthFileId(int healthFileId);
	/**
	 * 根据集团ID获取 体检视图  带分页
	 * @param gid 
	 * @param page
	 * @return
	 */
	public List<VExam> getVExamListByGid(int gid ,int fileType,Page<VExam>  page);
	/**
	 * 根据集团ID和 体检ID 获取一条体检视图实体
	 * @param gid
	 * @param tphysicalexamid
	 * @return
	 */
	public VExam getVExamByGidAndtphysicalexamid(int gid ,int tphysicalexamid);
	
	/**
	 * 获取单条 体检记录
	 * @param tphysicalexamid 
	 * @return
	 */
	public VExam getOneTPhysicalExamBy54(int tphysicalexamid);
	
	
	//====================================
	/**
	 * 保存体检总表
	 * @param tphysicalexam
	 */
	public void saveTPhysicalExam(TPhysicalExam tphysicalexam);
	/**保存脏器功能表
	 *  
	 * @param TOrgan   
	 * @return  脏器功能表ID
	 */
	public int saveTOrganFunction(TOrganFunction torganfunction);
	/**
	 *  保存查体表
	 * @param tcheck
	 * @return  查体表ID
	 */
	public int saveTCheck(TCheck tcheck);
	/**
	 * 保存 中医体质辨识表
	 * @param tchinamedicine
	 * @return 中医体质辨识表ID
	 */
	public int saveTChinaMedicine(TChinaMedicine tchinamedicine);
	
	/**
	 * 保存现存主要问题表
	 * @param Thealthexting 
	 * @return  现存主要问题表ID
	 */
	public int saveTHealthExtingProblem(THealthExtingProblem thealthexting);
	/**
	 * 保存一般状况表
	 * @param TGeneralCondition 
	 * @return  一般状况表ID
	 */
	public int saveTGeneralCondition(TGeneralCondition tgeneralcondition);
	
	/**
	 * 	保存生活方式表
	 * @param tlifestyle  
	 * @return  生活方式表id
	 */
	public int saveTLifeStyle(TLifeStyle tlifestyle);
	
	/**
	 * 保存辅助检查表
	 * @param tauxiliaryexamination
	 * @return  辅助检查表ID
	 */
	public int saveTAuxiliaryExamination(TAuxiliaryExamination tauxiliaryexamination);
	/**
	 * 保存住院治疗史表
	 * @param thospitalhistory
	 * @return  住院治疗史表(hospital history)ID
	 */
	public void saveTHospitalHistory(List<THospitalHistory> thospitalhistory);
	/**
	 * 保存家庭病床史表
	 * @param thf
	 */
	public void saveTHF(List<THF> thfList);
	/**
	 * 保存住院用药情况表
	 * @param tmedicaluse
	 */
	public void saveTMedicalUse(List<TMedicalUse> tmedicaluseList);
	/**
	 * 保存非免疫规划预防接种史表
	 * @param tdefendinocu
	 */
	public void saveTDefendInocu(List<TDefendInocu> tdefendinocu);
	
//=============delete========
	/**
	 * 真删  体检总表
	 * @param tphysicalexam 体检实体
	 */
	public void deleteTPhysicalExam(TPhysicalExam tphysicalexam);

	/**
	 * 根据体检ID 真删一条实体 
	 * @param healthfileId 体检ID
	 */
	public void deleteTPhysicalExamByID(int healthfileId);

	/**
	 * 根据体检ID 真删 住院治疗史List 
	 * @param healthfileId  体检ID
	 */
	public void deleteTHospitalHistoryByPhysicalId(int physicalExamId );
	/**
	 * 根据体检ID 真删 家庭病床史List 
	 * @param healthfileId  体检ID
	 */
	public void deleteTHFByPhysicalId(int physicalExamId );
	/**
	 * 根据体检ID 真删 住院用药情况表 List 
	 * @param healthfileId  体检ID
	 */
	public void deleteTMedicalUseByPhysicalId(int physicalExamId );
	/**
	 * 根据体检ID 真删 非免疫规划预防接种史List 
	 * @param healthfileId  体检ID
	 */
	public void deleteTDefendInocuByPhysicalId(int physicalExamId );
	
//=============update========
	/**
	 * 更新体检总表
	 * @param tphysicalexam
	 */
	public void editTPhysicalExam(TPhysicalExam tphysicalexam);
	/**更新脏器功能表
	 *  
	 * @param TOrgan   
	 * @return  脏器功能表ID
	 */
	public void editTOrganFunction(TOrganFunction torganfunction);
	/**
	 *  更新查体表
	 * @param tck
	 * @return  查体表ID
	 */
	public void editTCheck(TCheck tcheck);
	/**
	 * 更新 中医体质辨识表
	 * @param 
	 * @return 中医体质辨识表ID
	 */
	public void editTChinaMedicine(TChinaMedicine tchinamedicine);
	
	/**
	 * 更新现存主要问题表
	 * @param Thealthexting 
	 * @return  现存主要问题表ID
	 */
	public void editTHealthExtingProblem(THealthExtingProblem thealthexting);
	/**
	 * 更新一般状况表
	 * @param TGeneralCondition 
	 * @return  一般状况表ID
	 */
	public void editTGeneralCondition(TGeneralCondition tgeneralcondition);
	
	/**
	 * 	更新生活方式表
	 * @param tlifestyle  
	 * @return  生活方式表id
	 */
	public void editTLifeStyle(TLifeStyle tlifestyle);
	
	/**
	 * 更新辅助检查表
	 * @param tauxiliaryexamination
	 * @return  辅助检查表ID
	 */
	public void editTAuxiliaryExamination(TAuxiliaryExamination tauxiliaryexamination);
	
	
	
	/**
	 * 更新住院治疗史表
	 * @param thospitalhistoryList  住院治疗史	List
	 * @return  住院治疗史表(hospital history)ID
	 */
	public void editTHospitalHistory(List<THospitalHistory> thospitalhistoryList);
	/**
	 * 更新家庭病床史表
	 * @param thfList  家庭病床史List
	 */
	public void editTHF(List<THF> thfList);
	/**
	 * 更新住院用药情况表
	 * @param tmedicaluseList 住院用药情况List
	 */
	public void editTMedicalUse(List<TMedicalUse> tmedicaluseList);
	/**
	 * 更新非免疫规划预防接种史表
	 * @param tdefendinocuList 非免疫规划预防接种史List
	 */ 
	public void editTDefendInocu(List<TDefendInocu> tdefendinocuList);
	
//==========搜索的方法===============	
	
	/**
	 * 根据脏器功能表ID 查询一条脏器功能表
	 * @return torganFunctionId 脏器功能表Id
	 */
	public TOrganFunction searchTOrganFunctionByTOrganFunctionId(Integer torganFunctionId);
	
	
	/**
	 *  根据体检ID 查询 住院治疗史 的List
	 * @param physicalExamId   体检ID	
	 * 
	 * @return    住院治疗史 的List
	 */
	public List<THospitalHistory> searchtHospitalHistoryByPhysicalExamId(int physicalexamId);
	/**
	 *  根据体检ID 查询 家庭病床史表 的List
	 * @param physicalExamId   体检ID	
	 * @return    家庭病床史 的List
	 */
	public List<THF> searchTHFListByPhysicalExamId(int physicalexamId);
	/**
	 *  根据体检ID 查询  住院用药情况  的List
	 * @param physicalExamId   体检ID	
	 * @return    住院用药情 的List
	 */
	public List<TMedicalUse> searchTMedicalUseListByPhysicalExamId(int physicalexamId);
	/**
	 *  根据体检ID 查询    非免疫规划预防接种史表   的List
	 * @param physicalExamId   体检ID	
	 * @return    非免疫规划预防接种史 的List
	 */
	public List<TDefendInocu> searchTDefendInocusListByPhysicalExamId(int physicalexamId);
	/**
	 * 根据体检ID 查询    体检总表
	 * @param physicalexamId   体检ID
	 * @return   体检总表实体
	 */
	public TPhysicalExam searchTPhysicalExamByPhysicalExamId(int physicalexamId);
	/**
	 * 根据健康档案Id  查询    体检总表
	 * @param healthFileId   健康档案Id
	 * @return   体检总表实体
	 */
	public TPhysicalExam searchTPhysicalExamByHealthFileId(int healthFileId);
	
	/**
	 * 
	 * @param staffId 员工ID 
	 * @param physicalExamId  体检ID
	 * @return  体检视图视图
	 */
	public VExam getVExamByStaffIdPhysicalId(int staffId,int physicalExamId);
	/**
	 * 根据  名字  查询 体检视图实体 List
	 * @param fileName  名字
	 * @return 体检视图实体 List
	 *//*
	public VExam searchVExamByFileName(String fileName);
	*//**
	 * 根据健康档案的 ID 查询 体检视图实体 List
	 * @param healthFileId 健康档案的 ID
	 * @return    体检视图实体 List
	 *//* 
	public VExam searchVExamByHealthFileId(int healthFileId);
	/**
	 * 根据 身份证 号码 查询体检视图 List
	 * @param idNum
	 * @return 体检视图实体 List
	 *//*
	public VExam searchVExamByIdNum(String idNum);*/
	
	/**
	 *  根据 社区ID 和   档案状态 查询 体检视图实体 
	 * @param fileType 档案状态
	 * @param hosId  社区ID
	 * @param page 分页
	 * @return 体检视图实体 List
	 */
	public List<VExam> searchVExamByFileTypeHosId(int fileType,int hosId,Page<VExam> page);
	/**
	 * 
	 *   根据 社区ID 和   档案状态 查询 体检视图实体 
	 * @param fileType 档案状态
	 * @param hosId  社区ID
	 * @return 体检视图实体 List
	 */
	public List<VExam> searchVExamByFileTypeHosId(int fileType,int hosId);
	/**
	 * 根据 社区ID   查询 体检视图实体 
	 * @param hosId
	 * @return
	 */
	public List<VExam> searchVExamByHosId(int hosId);
	/**
	 * 
	 * @param fileType 档案状态
	 * @param hosId    社区ID
	 * @return 体检视图实体 的数量 
	 */
	public long searchVExamByFileTypeHosIdCount(int fileType,int hosId);
	
	/**
	 * 根据健康档案ID 查询 体检视图实体 List（多条体检实体）
	 * @param healthFileId  健康档案ID
	 * @return 体检实体视图List 
	 */
	public List<VExam> searchVExamView(int healthfileId);
	/**
	 * 根据 健康档案ID  社区医院ID 校验 查询一条 体检视图实体 
	 * @param healthfileId  健康档案ID
	 * @return 一条 体检视图实体
	 */
	public VExam searchVExamView(int healthfileId, int communityhospitalId);
	/**
	 * 根据 健康档案ID  社区医院ID 校验 查询一条 体检视图实体 
	 * @param healthfileId 健康档案ID
	 * @param page
	 * @return
	 */
	public List<VExam> searchVExamView(int healthfileId,Page<VExam> page);
	
	/**
	 * 根据 健康档案ID  社区医院ID 校验 查询一条 体检视图实体 
	 * @param healthfileId 健康档案ID
	 * @param page
	 * @return
	 */
	public List<VExam> searchVExamViewLzy(int healthfileId,Page<VExam> page);
	
	/**
	 * 根据 体检Id  社区医院ID 校验 查询一条 体检视图实体 
	 * @param physicalExamId 
	 * @param communityhospitalId
	 * @return  一条 体检视图实体
	 */
	public VExam searchVExamViewByphysicalExamIdHosId(int physicalExamId, int communityhospitalId);
	/**
	 * 根据 体检ID查询一条 体检视图 实体 
	 * @param physicalexamId
	 * @return  一条 体检视图实体
	 */
	public VExam searchVExamViewByphysicalexamId(int physicalexamId);
	/**
	 * 根据责任医生ID 获取 其管辖的 所有 老人档案
	 * @param staffId 员工的ID 一般用于 责任医生
	 * @return  当前 责任医生 管辖的 档案视图实体 
	 */
	public List<VExam> searchVExamViewByStaffId(int staffId,int fileType,Page<VExam> page);
	/**
	 * 根据责任医生ID 档案状态  获取 其管辖的 所有 老人档案 的数量
	 * @param staffId 员工的ID 一般用于 责任医生
	 * @param fileType 档案状态
	 * @return  当前 责任医生 管辖的 档案视图实体 数量
	 */
	public int searchVExamViewByStaffId(int staffId,int fileType);
	/**
	 * 根据责任医生ID 获取 其管辖的 所有 老人档案 的数量
	 * @param staffId 员工的ID 一般用于 责任医生
	 * @return  当前 责任医生 管辖的 档案视图实体 数量
	 */
	public List<VExam> searchVExamViewByStaffId(int staffId);
	/**
	 * 得到全部 档案状态 的体检视图实体
	 * @param fileType 档案状态
	 * @param page	分页
	 * @return
	 */
	public List<VExam> getAllVExamView(int fileType,Page<VExam> page);
	/**
	 * 得到全部 档案状态 的体检视图实体 的数量
	 * @param fileType 档案状态 
	 * @return 档案状态 的体检视图实体 的数量
	 */
	public int getAllVExamView(int fileType);
	/**
	 * 根据 体检ID  健康档案ID 查询一条 体检实体 
	 * @param physicalExamId  体检ID
	 * @param healthFileId  健康档案ID
	 * @return 一条 体检视图实体
	 */
//	public TPhysicalExam serchVExamView(int physicalexamId,int healthfileId);
	/**
	 * 根据 体检ID  健康档案ID 查询 校验 一条 体检总表实体 
	 * @param physicalexamId
	 * @param healthfileId
	 * @param time
	 * @return
	 */
	public TPhysicalExam searchTPhysicalExam(int physicalexamId,int healthfileId);
	/**
	 * 根据传入的多条件 搜索类 得到对应的VExamList
	 *@param sc 所搜条件类
	 * @return  对应的VExamList
	 * @return
	 */
	public List<VExam> searchMultiVExam(SearchClass sc ,Page<VExam> page);
	/**
	 * 根据传入的多条件 搜索类 得到对应的VExamList
	 * @param sc 所搜条件类
	 * @return  对应的VExamList
	 */
	public List<VExam> searchMultiVExam(SearchClass sc);
}
