package com.jmjk.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.CoronaryDiseaseDao;
import com.jmjk.dao.CoronaryHeartDiseaseDao;
import com.jmjk.entity.TCoronaryDisease;
import com.jmjk.entity.TCoronaryHeartDisease;
import com.jmjk.iservice.ICoronaryHeartService;
/**
 * 冠心病档案及随访记录接口实现
 * @author 李卓远
 *
 */
@Controller("coronaryHeartService")
public class CoronaryHeartService implements ICoronaryHeartService {
@Autowired
CoronaryDiseaseDao coronarydiseasedao;
@Autowired
CoronaryHeartDiseaseDao coronaryheartdiseasedao;
	@Override
	public void saveCornaryDisease(TCoronaryDisease gxb) {
		// TODO Auto-generated method stub
		coronarydiseasedao.saveOrUpdate(gxb);

	}

	@Override
	public void deleteCornaryDisease(TCoronaryDisease gxb) {
		// TODO Auto-generated method stub
		coronarydiseasedao.delete(gxb);

	}

	@Override
	public void editCornaryDisease(TCoronaryDisease gxb) {
		// TODO Auto-generated method stub
		coronarydiseasedao.update(gxb);

	}

	@Override
	public TCoronaryDisease getCornaryDiseaseById(int mbid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("mbid", mbid);
		String hql = "from TCoronaryDisease tcd where tcd.TChronicDisease.chronicDiseaseId = :mbid";
		return coronarydiseasedao.Get(hql , p);
	}

	@Override
	public int saveCoronaryHeartFollow(TCoronaryHeartDisease gxbf) {
		// TODO Auto-generated method stub
		String sql = "SELECT auto_increment FROM information_schema.`TABLES` WHERE table_name = 'T_CORONARY_HEART_DISEASE' and TABLE_SCHEMA='jmjk'";
		coronaryheartdiseasedao.Save(gxbf);
		return coronaryheartdiseasedao.getPrefetching(sql);
	}

	@Override
	public void deleteCoronaryHeartFollow(TCoronaryHeartDisease gxbf) {
		// TODO Auto-generated method stub
		coronaryheartdiseasedao.delete(gxbf);

	}

	@Override
	public void editCoronaryHeartFollow(TCoronaryHeartDisease gxbf) {
		// TODO Auto-generated method stub
		coronaryheartdiseasedao.update(gxbf);

	}

	@Override
	public TCoronaryHeartDisease getCoronaryHeartFollowByMbfId(int mbfid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("mbfid", mbfid);
		String hql = "from TCoronaryHeartDisease tchd where tchd.TChronicFollow.chronicFollowId = :mbfid";
		return coronaryheartdiseasedao.Get(hql , p);
	}

	@Override
	public TCoronaryHeartDisease getCoronaryHeartFollowByGxfId(int gxid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("gxid", gxid);
		String hql = "from TCoronaryHeartDisease tchd where tchd.coronaryHeartDiseaseId = :gxid";
		return coronaryheartdiseasedao.Get(hql , p);
	}
	
	

}
