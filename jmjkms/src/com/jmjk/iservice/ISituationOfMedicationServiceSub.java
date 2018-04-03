package com.jmjk.iservice;

import java.util.List;

import com.jmjk.entity.TDrugInformation;
import com.jmjk.entity.TDrugInformationIncomplete;
/**
 * 随访记录用药情况表接口
 * @author 
 *
 */
public interface ISituationOfMedicationServiceSub{//

	/**
	 * 添加用药情况
	 * @param listyg 用药情况实体集合
	 */
	public void saveListDrugInformationIncomplete (List<TDrugInformationIncomplete> listyg );
	
	/**
	 * 删除用药情况实体（同时用于编辑，先删除再添加）
	 * @param tf 用药情况表实体
	 */
	public void deleteListDrugInformationIncomplete(List<TDrugInformationIncomplete> listyg);
	
	/**
	 * 通过接诊记录id拿到其对应的用药记录
	 * @param jzjlid 接诊记录记录id
	 * @return 接诊记录用药情况实体
	 */
	public List<TDrugInformationIncomplete> getDrugInformationByJzId(int jzid);
}
