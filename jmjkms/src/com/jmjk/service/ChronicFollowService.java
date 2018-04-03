package com.jmjk.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.ChronicFollowDao;
import com.jmjk.entity.TChronicFollow;
import com.jmjk.iservice.IChronicFollowservice;
/**
 * 慢病随访记录接口及随访记录视图接口实现
 * @author 李卓远
 *
 */
@Controller("chronicFollowService")
public class ChronicFollowService implements IChronicFollowservice {
@Autowired
ChronicFollowDao chronicfollowdao;

	@Override
	public int saveTChronicFollow(TChronicFollow mbsf) {
		// TODO Auto-generated method stub
		String sql = "SELECT auto_increment FROM information_schema.`TABLES` WHERE table_name = 'T_CHRONIC_FOLLOW' and TABLE_SCHEMA='jmjk'";
		chronicfollowdao.Save(mbsf);
		return chronicfollowdao.getPrefetching(sql);
		
	}

	@Override
	public void deleteTChronicFollow(TChronicFollow mbsf) {
		// TODO Auto-generated method stub
		chronicfollowdao.delete(mbsf);

	}

	@Override
	public void editTChronicFollow(TChronicFollow mbsf) {
		// TODO Auto-generated method stub
		chronicfollowdao.update(mbsf);

	}

	@Override
	public TChronicFollow getChronicFollowByMbsfId(int mbsfid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("mbsfid", mbsfid);
		String hql = "from TChronicFollow tcf where tcf.chronicFollowId = :mbsfid";
		return chronicfollowdao.Get(hql , p);
	}

	@Override
	public List<TChronicFollow> getChronicFollowByMbId(int mbid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("mbid", mbid);
		String hql = "from TChronicFollow tcf where tcf.TChronicDisease.chronicDiseaseId = :mbid";
		return chronicfollowdao.find(hql,p);
	}

	

	



}
