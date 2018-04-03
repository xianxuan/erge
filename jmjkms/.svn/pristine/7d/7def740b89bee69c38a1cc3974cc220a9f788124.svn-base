package com.jmjk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.DrugInformationDao;
import com.jmjk.entity.TDrugInformation;
import com.jmjk.iservice.ISituationOfMedicationService;
/**
 * 用药情况表接口实现
 * @author 李卓远
 *
 */
@Controller("situationOfMedicationService")
public class SituationOfMedicationService implements
		ISituationOfMedicationService {
@Autowired
DrugInformationDao druginformationdao;
	@Override
	public void saveListDrugInformation(List<TDrugInformation> listyg) {
		// TODO Auto-generated method stub
		for (int i = 0; i < listyg.size(); i++) {
			TDrugInformation tf = listyg.get(i);
			druginformationdao.Save(tf);
		}

	}

	@Override
	public void deleteListDrugInformation(List<TDrugInformation> listyg) {
		// TODO Auto-generated method stub
		for (int i = 0; i < listyg.size(); i++) {
			TDrugInformation tf = listyg.get(i);
			druginformationdao.delete(tf);
		}
		

	}

	@Override
	public List<TDrugInformation> getDrugInformationByTnbId(int tnbid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("tnbid", tnbid);
		String hql = "from TDrugInformation tdi where tdi.TDiabetsFollow.diabetsFollowId = :tnbid";
		return druginformationdao.find(hql,p);
	}

	@Override
	public List<TDrugInformation> getDrugInformationByJsbId(int jsbid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("jsbid", jsbid);
		String hql = "from TDrugInformation tdi where tdi.TMentalFollow.mentalFollowId = :jsbid";
		return druginformationdao.find(hql,p);
	}

	@Override
	public List<TDrugInformation> getDrugInformationByGxbId(int gxbid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("gxbid", gxbid);
		String hql = "from TDrugInformation tdi where tdi.TCoronaryHeartDisease.coronaryHeartDiseaseId = :gxbid";
		return druginformationdao.find(hql,p);
	}

	@Override
	public List<TDrugInformation> getDrugInformationByXnId(int xnid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("xnid", xnid);
		String hql = "from TDrugInformation tdi where tdi.TFollowUpCardiovascular.followUpCardiovascularId = :xnid";
		return druginformationdao.find(hql,p);
	}

	@Override
	public List<TDrugInformation> getDrugInformationByQtId(int qtid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("qtid", qtid);
		String hql = "from TDrugInformation tdi where tdi.TRegistrationOtherDiseases.TRegOthDisId = :qtid";
		return druginformationdao.find(hql,p);
	}

	@Override
	public List<TDrugInformation> getDrugInformationByGxyId(int gxyid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("gxyid", gxyid);
		String hql = "from TDrugInformation tdi where tdi.THypertensiveFollow.hypertensiveFollowId = :gxyid";
		return druginformationdao.find(hql,p);
	}



}
