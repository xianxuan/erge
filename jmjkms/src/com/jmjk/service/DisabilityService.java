package com.jmjk.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.DisabilityObstacleDao;
import com.jmjk.entity.TDisabilityObstacle;
import com.jmjk.iservice.IDisabilityService;
/**
 * 残疾障碍档案接口实现
 * @author 李卓远
 *
 */
@Controller("disabilityService")
public class DisabilityService implements IDisabilityService {
@Autowired
DisabilityObstacleDao disabilityobstacledao;
	@Override
	public void saveDi_Ob(TDisabilityObstacle cj) {
		// TODO Auto-generated method stub
		disabilityobstacledao.Save(cj);

	}

	@Override
	public void deleteDi_Ob(TDisabilityObstacle cj) {
		// TODO Auto-generated method stub
		disabilityobstacledao.delete(cj);

	}

	@Override
	public void editDi_Ob(TDisabilityObstacle cj) {
		// TODO Auto-generated method stub
		disabilityobstacledao.update(cj);

	}

	@Override
	public TDisabilityObstacle getDi_ObById(int mbid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("mbid", mbid);
		String hql = "from TDisabilityObstacle tdo where tdo.TChronicDisease.chronicDiseaseId = :mbid";
		return disabilityobstacledao.Get(hql , p);
	}

}
