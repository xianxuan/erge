package com.jmjk.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.FollowUpCardiovascularDao;
import com.jmjk.dao.HcvdDao;
import com.jmjk.entity.TFollowUpCardiovascular;
import com.jmjk.entity.THcvd;
import com.jmjk.iservice.IHeartAndCerebralService;
/**
 * 心脑血管病档案及随访记录接口实现
 * @author 李卓远
 *
 */
@Controller("heartAndCerebralService")
public class HeartAndCerebralService implements IHeartAndCerebralService {
@Autowired
HcvdDao hcvddao;
@Autowired
FollowUpCardiovascularDao followupcardiovasculardao;
	@Override
	public void saveHcvd(THcvd xn) {
		// TODO Auto-generated method stub
		hcvddao.Save(xn);

	}

	@Override
	public void deleteHcvd(THcvd xn) {
		// TODO Auto-generated method stub
		hcvddao.delete(xn);

	}

	@Override
	public void editHcvd(THcvd xn) {
		// TODO Auto-generated method stub
		hcvddao.update(xn);

	}

	@Override
	public THcvd getHcvdById(int mbid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("mbid", mbid);
		String hql = "from THcvd th where th.TChronicDisease.chronicDiseaseId = :mbid";
		return hcvddao.Get(hql,p);
	}

	@Override
	public int saveFollowUp_Cardio(TFollowUpCardiovascular xnf) {
		// TODO Auto-generated method stub
		String sql = "SELECT auto_increment FROM information_schema.`TABLES` WHERE table_name = 'T_FOLLOW_UP_CARDIOVASCULAR' and TABLE_SCHEMA='jmjk'";
		followupcardiovasculardao.Save(xnf);
		return followupcardiovasculardao.getPrefetching(sql);
	}

	@Override
	public void deleteFollowUp_Cardio(TFollowUpCardiovascular xnf) {
		// TODO Auto-generated method stub
		followupcardiovasculardao.delete(xnf);

	}

	@Override
	public void editFollowUp_Cardio(TFollowUpCardiovascular xnf) {
		// TODO Auto-generated method stub
		followupcardiovasculardao.update(xnf);

	}

	@Override
	public TFollowUpCardiovascular getFollowUp_Cardio(int mbfid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("mbfid", mbfid);
		String hql = "from TFollowUpCardiovascular tfuc where tfuc.TChronicFollow.chronicFollowId = :mbfid";
		return followupcardiovasculardao.Get(hql,p);
	}

	@Override
	public TFollowUpCardiovascular getFoUpByFid(int xnfid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("xnfid", xnfid);
		String hql = "from TFollowUpCardiovascular tfuc where tfuc.followUpCardiovascularId = :xnfid"; 
		return followupcardiovasculardao.Get(hql,p);
	}

}
