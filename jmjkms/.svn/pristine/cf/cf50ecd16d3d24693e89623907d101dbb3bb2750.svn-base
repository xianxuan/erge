package com.jmjk.service;

import java.util.HashMap;
import java.util.Map;

import javax.swing.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.InsanityFormDao;
import com.jmjk.dao.MentalFollowDao;
import com.jmjk.entity.TInsanityForm;
import com.jmjk.entity.TMentalFollow;
import com.jmjk.iservice.IPsychosisService;
/**
 * 重性精神疾病档案及随访记录接口实现
 * @author 李卓远
 *
 */
@Controller("psychosisService")
public class PsychosisService implements IPsychosisService {
@Autowired
InsanityFormDao insanityformdao;
@Autowired
MentalFollowDao mentalfollowdao;
	@Override
	public void saveInsanityForm(TInsanityForm jsb) {
		// TODO Auto-generated method stub
		insanityformdao.Save(jsb);

	}

	@Override
	public void deleteInsanityForm(TInsanityForm jsb) {
		// TODO Auto-generated method stub
		insanityformdao.delete(jsb);

	}

	@Override
	public void editInsanityForm(TInsanityForm jsb) {
		// TODO Auto-generated method stub
		insanityformdao.update(jsb);

	}

	@Override
	public TInsanityForm getInsanityForm(int mbid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("mbid", mbid);
		String hql = "from TInsanityForm tif where tif.TChronicDisease.chronicDiseaseId = :mbid";
		return insanityformdao.Get(hql,p);
	}

	@Override
	public int saveMentalFollow(TMentalFollow jsbf) {
		// TODO Auto-generated method stub
		String sql = "SELECT auto_increment FROM information_schema.`TABLES` WHERE table_name = 'T_MENTAL_FOLLOW' and TABLE_SCHEMA='jmjk'";
		mentalfollowdao.Save(jsbf);
		return mentalfollowdao.getPrefetching(sql);
	}

	@Override
	public void deleteMentalFollow(TMentalFollow jsbf) {
		// TODO Auto-generated method stub
		mentalfollowdao.delete(jsbf);

	}

	@Override
	public void editMentalFollow(TMentalFollow jsbf) {
		// TODO Auto-generated method stub
		mentalfollowdao.update(jsbf);

	}

	@Override
	public TMentalFollow getMentalFollow(int mbfid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("mbfid", mbfid);
		String hql = "from TMentalFollow tmf where tmf.TChronicFollow.chronicFollowId = :mbfid";
		return mentalfollowdao.Get(hql,p);
	}

	@Override
	public TMentalFollow getMentalFollowByJfId(int jfid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("jfid", jfid);
		String hql = "from TMentalFollow tmf where tmf.mentalFollowId = :jfid";
		return mentalfollowdao.Get(hql,p);
	}

}
