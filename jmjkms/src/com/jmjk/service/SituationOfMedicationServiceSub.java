package com.jmjk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.DrugInformationDao;
import com.jmjk.dao.DrugInformationIncompleteDao;
import com.jmjk.entity.TDrugInformation;
import com.jmjk.entity.TDrugInformationIncomplete;
import com.jmjk.iservice.ISituationOfMedicationService;
import com.jmjk.iservice.ISituationOfMedicationServiceSub;
/**
 * 用药情况表接口实现
 * @author 
 *
 */
@Controller("situationOfMedicationServiceSub")
public class SituationOfMedicationServiceSub
		 implements ISituationOfMedicationServiceSub {
@Autowired
DrugInformationIncompleteDao druginformationdao;
	public void saveListDrugInformationIncomplete(List<TDrugInformationIncomplete> listyg) {
		// TODO Auto-generated method stub
		for (int i = 0; i < listyg.size(); i++) {
			TDrugInformationIncomplete tf = listyg.get(i);
			druginformationdao.Save(tf);
		}

	}

	public void deleteListDrugInformationIncomplete(List<TDrugInformationIncomplete> listyg) {
		// TODO Auto-generated method stub
		for (int i = 0; i < listyg.size(); i++) {
			TDrugInformationIncomplete tf = listyg.get(i);
			druginformationdao.delete(tf);
		}
		

	}


	@Override
	public List<TDrugInformationIncomplete> getDrugInformationByJzId(int jzid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("jzid", jzid);
		String hql = "from TDrugInformationIncomplete tdi where tdi.TIncompleteRecord2.incompleteRecordId = :jzid";
		return druginformationdao.find(hql,p);
	}




}
