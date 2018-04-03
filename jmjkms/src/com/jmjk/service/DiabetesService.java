package com.jmjk.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.DiabeteDao;
import com.jmjk.dao.DiabetsFollowDao;
import com.jmjk.entity.TDiabete;
import com.jmjk.entity.TDiabetsFollow;
import com.jmjk.iservice.IDiabetesService;
/**
 * 糖尿病档案及随访记录接口实现
 * @author 李卓远
 *
 */
@Controller("diabetesService")
public class DiabetesService implements IDiabetesService {
@Autowired
DiabeteDao diabetedao;
@Autowired
DiabetsFollowDao diabetsfollowdao;
	@Override
	public void saveDiabete(TDiabete tnb) {
		// TODO Auto-generated method stub
		diabetedao.Save(tnb);

	}

	@Override
	public void deleteDiabete(TDiabete tnb) {
		// TODO Auto-generated method stub
		diabetedao.delete(tnb);

	}

	@Override
	public void editDiabete(TDiabete tnb) {
		// TODO Auto-generated method stub
		diabetedao.update(tnb);

	}

	@Override
	public TDiabete getDiabeteById(int mbid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("mbid", mbid);
		String hql = "from TDiabete tb where tb.TChronicDisease.chronicDiseaseId = :mbid";
		return diabetedao.Get(hql , p);
	}

	@Override
	public int saveDiabetsFollow(TDiabetsFollow tnbf) {
		// TODO Auto-generated method stub
		String sql = "SELECT auto_increment FROM information_schema.`TABLES` WHERE table_name = 'T_DIABETS_FOLLOW' and TABLE_SCHEMA='jmjk'";
		diabetsfollowdao.Save(tnbf);
		return diabetsfollowdao.getPrefetching(sql);
	}

	@Override
	public void deleteDiabetsFollow(TDiabetsFollow tnbf) {
		// TODO Auto-generated method stub
		diabetsfollowdao.delete(tnbf);

	}

	@Override
	public void editDiabetsFollow(TDiabetsFollow tnbf) {
		// TODO Auto-generated method stub
		diabetsfollowdao.update(tnbf);

	}

	@Override
	public TDiabetsFollow getDiabetsFollow(int mbfid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("mbfid", mbfid);
		String hql = "from TDiabetsFollow tbf where tbf.TChronicFollow.chronicFollowId = :mbfid";
		return diabetsfollowdao.Get(hql , p);
	}

	@Override
	public TDiabetsFollow getDiabetsFollowByTfId(int tfid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("tfid", tfid);
		String hql = "from TDiabetsFollow tbf where tbf.diabetsFollowId = :tfid";
		return diabetsfollowdao.Get(hql , p);
	}

}
