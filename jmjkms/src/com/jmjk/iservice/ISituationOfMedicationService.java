package com.jmjk.iservice;

import java.util.List;

import com.jmjk.entity.TDrugInformation;
/**
 * 随访记录用药情况表接口
 * @author 李卓远
 *
 */
public interface ISituationOfMedicationService {//

	/**
	 * 添加用药情况
	 * @param listyg 用药情况实体集合
	 */
	public void saveListDrugInformation (List<TDrugInformation> listyg );
	
	/**
	 * 删除用药情况实体（同时用于编辑，先删除再添加）
	 * @param tf 用药情况表实体
	 */
	public void deleteListDrugInformation(List<TDrugInformation> listyg);
	
	/**
	 * 通过糖尿病随访记录id拿到其对应的用药记录
	 * @param tnbid 糖尿病随访记录id
	 * @return 糖尿病随访记录用药情况实体
	 */
	public List<TDrugInformation> getDrugInformationByTnbId(int tnbid);
	
	/**
	 * 通过重性精神疾病随访记录id拿到其对应的用药记录
	 * @param jsbid 重性精神疾病随访记录id
	 * @return 重性精神疾病随访记录用药情况实体
	 */
	public List<TDrugInformation> getDrugInformationByJsbId(int jsbid);
	
	/**
	 * 通过冠心病随访记录id拿到其对应的用药记录
	 * @param gxbid 冠心病随访记录id
	 * @return 冠心病随访记录用药情况实体
	 */
	public List<TDrugInformation> getDrugInformationByGxbId(int gxbid);
	
	
	/**
	 * 通过心脑血管病随访记录id拿到其对应的用药记录
	 * @param xnid 心脑血管随访记录id
	 * @return 心脑血管随访记录用药情况实体
	 */
	public List<TDrugInformation> getDrugInformationByXnId(int xnid);
	
	/**
	 * 通过其他病（肿瘤、慢性支气管病、残疾障碍）随访记录id拿到其对应的用药记录
	 * @param qtid 其他疾病id
	 * @return 其他疾病随访记录用药情况实体
	 */
	public List<TDrugInformation> getDrugInformationByQtId(int qtid);
	
	/**
	 * 通过高血压随访记录id拿到其对应的用药记录
	 * @param gxyid 高血压随访记录id
	 * @return 高血压随访记录用药情况实体
	 */
	public List<TDrugInformation> getDrugInformationByGxyId(int gxyid);
	
	
	
}
