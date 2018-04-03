package com.jmjk.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.HighBloodPressureDao;
import com.jmjk.dao.HypertensiveFollowDao;
import com.jmjk.entity.THighBloodPressure;
import com.jmjk.entity.THypertensiveFollow;
import com.jmjk.iservice.IHighBloodPressureService;
/**
 * 高血压档案及高血压随访记录接口实现
 * @author 李卓远
 *
 */
@Controller("highBloodPressureService")
public class HighBloodPressureService implements IHighBloodPressureService {
@Autowired
HighBloodPressureDao highbloodpressuredao;
@Autowired
HypertensiveFollowDao hypertensivefollowdao;
	@Override
	public void saveHighBlood(THighBloodPressure gxy) {
		// TODO Auto-generated method stub
		highbloodpressuredao.Save(gxy);

	}

	@Override
	public void deleteHighBlood(THighBloodPressure gxy) {
		// TODO Auto-generated method stub
		highbloodpressuredao.delete(gxy);

	}

	@Override
	public void editHighBlood(THighBloodPressure gxy) {
		// TODO Auto-generated method stub
		highbloodpressuredao.update(gxy);

	}

	@Override
	public THighBloodPressure getHighBloodById(int mbid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("mbid", mbid);
		String hql = "from THighBloodPressure thbp where thbp.TChronicDisease.chronicDiseaseId = :mbid";
		return highbloodpressuredao.Get(hql,p);
	}

	@Override
	public int saveHyp_Follow(THypertensiveFollow gxyf) {
		// TODO Auto-generated method stub
		String sql = "SELECT auto_increment FROM information_schema.`TABLES` WHERE table_name = 'T_HYPERTENSIVE_FOLLOW' and TABLE_SCHEMA='jmjk'";
		hypertensivefollowdao.Save(gxyf);
		return hypertensivefollowdao.getPrefetching(sql);
	}

	@Override
	public void deleteHyp_Follow(THypertensiveFollow gxyf) {
		// TODO Auto-generated method stub
		hypertensivefollowdao.delete(gxyf);

	}

	@Override
	public void editHyp_Follow(THypertensiveFollow gxyf) {
		// TODO Auto-generated method stub
		hypertensivefollowdao.update(gxyf);

	}

	@Override
	public THypertensiveFollow getHyp_Follow(int mbfid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("mbfid", mbfid);
		String hql = "from THypertensiveFollow tf where tf.TChronicFollow.chronicFollowId = :mbfid";
		return hypertensivefollowdao.Get(hql,p);
	}

	@Override
	public THypertensiveFollow getHyp_FollowByHfid(int hfid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("hfid", hfid);
		String hql = "from THypertensiveFollow tf where tf.hypertensiveFollowId = :hfid";
		return hypertensivefollowdao.Get(hql,p);
	}

}
