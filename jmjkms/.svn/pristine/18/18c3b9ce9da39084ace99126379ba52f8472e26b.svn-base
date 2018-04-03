package com.jmjk.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.ChronicBrochialDiseaseDao;
import com.jmjk.entity.TChronicBronchialDisease;
import com.jmjk.iservice.IChronicBronchialService;
/**
 * 慢性支气管病档案实现接口
 * @author 李卓远
 *
 */
@Controller("chronicBronchialService")
public class ChronicBronchialService implements IChronicBronchialService {
@Autowired
ChronicBrochialDiseaseDao chronicbrochialdiseasedao;
	@Override
	public void saveCh_Br_Di(TChronicBronchialDisease mxqg) {
		// TODO Auto-generated method stub
		chronicbrochialdiseasedao.Save(mxqg);

	}

	@Override
	public void deleteCh_Br_Di(TChronicBronchialDisease mxqg) {
		// TODO Auto-generated method stub
		chronicbrochialdiseasedao.delete(mxqg);

	}

	@Override
	public void editCh_Br_Di(TChronicBronchialDisease mxqg) {
		// TODO Auto-generated method stub
		chronicbrochialdiseasedao.update(mxqg);

	}

	@Override
	public TChronicBronchialDisease getCh_Br_DiById(int mbid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("mbid", mbid);
		String hql = "from TChronicBronchialDisease tcbd where tcbd.TChronicDisease.chronicDiseaseId = :mbid";
		return chronicbrochialdiseasedao.Get(hql,p);
	}

}
