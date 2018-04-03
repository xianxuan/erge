package com.jmjk.iservice;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import com.jmjk.entity.TDoctorDiagnosis;
import com.jmjk.utils.Page;

/**
 * 医生诊断接口
 * @author 张晓光&朱德江&赖清发
 *
 */
public interface  IDoctorDiagnosisService {
	/**
	 * 保存医生诊断实体
	 * @param yszd 医生实体
	 */
	public void saveDoctorDiagnosis(TDoctorDiagnosis yszd);
	/**
	 * 更新医生实体
	 * @param yszd 医生实体
	 */
	public void updateDoctorDiagnosis(TDoctorDiagnosis yszd);
	/**
	 * 删除医生诊断记录
	 * @param yszdId 医生诊断Id
	 */
	public void deteleDoctorDiagnosis(int yszdId);
	/**
	 * 得到单条医生诊断记录(查看）
	 * @param yszdId 医生诊断Id
	 * @return
	 */
	public TDoctorDiagnosis getDoctorDiagnosisByYszdId(int yszdId);
	/**
	 * 查询某人某种病一段时间内医生诊断记录
	 * @param daId 档案Id
	 * @param startTime 起始时间
	 * @param endTime 结束时间
	 * @param chronicName 慢病名称
	 * @param page 分页
	 * @return
	 * @throws ParseException 
	 */
	public List<TDoctorDiagnosis> getDoctorDiagnosisByTime(int daId,String chronicName,Page<TDoctorDiagnosis> page,Date startTime,Date endTime);
	/**
	 * 得到某人某种病全部诊断记录
	 * @param daId
	 * @param page 分页
	 * @param chronicName 慢病名称
	 * @return
	 */
	public List<TDoctorDiagnosis> getAllDoctorDiagnosisByHFileid(int daId,String chronicName,Page<TDoctorDiagnosis> page);
	/**
	 * 得到某人某种病全部诊断记录条数
	 * @param daId
	 * @param startTime
	 * @param endTime
	 * @param chronicName 慢病名称
	 * @return
	 * @throws ParseException 
	 */
	public  long allNumDoctorDiagnosisByTime(int daId,String chronicName,Date startTime,Date endTime) throws ParseException;

}
