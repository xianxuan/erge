package com.jmjk.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.TumourDao;
import com.jmjk.entity.TTumour;
import com.jmjk.iservice.ITumourService;
/**
 * 肿瘤档案接口实现
 * @author 李卓远
 *
 */
@Controller("tumourService")
public class TumourService implements ITumourService {
@Autowired
TumourDao tumourdao;
	@Override
	public void saveTumour(TTumour zl) {
		// TODO Auto-generated method stub
		tumourdao.Save(zl);

	}

	@Override
	public void deleteTumour(TTumour zl) {
		// TODO Auto-generated method stub
		tumourdao.delete(zl);

	}

	@Override
	public void editTumour(TTumour zl) {
		// TODO Auto-generated method stub
		tumourdao.update(zl);

	}

	@Override
	public TTumour getTumour(int mbid) {
		// TODO Auto-generated method stub
		Map<String, Object> p =new HashMap<String, Object>();
		p.put("mbid", mbid);
		String hql = "from TTumour tt where tt.TChronicDisease.chronicDiseaseId = :mbid";
		return tumourdao.Get(hql,p);
	}

}
