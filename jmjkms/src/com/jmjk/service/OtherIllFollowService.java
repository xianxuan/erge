package com.jmjk.service;

import java.util.HashMap;
import java.util.Map;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.RegistrationOtherDiseasesDao;
import com.jmjk.entity.TRegistrationOtherDiseases;
import com.jmjk.iservice.IOtherIllFollowService;
/**
 * 其他疾病（肿瘤、慢性支气管病、残疾障碍）随访记录接口实现
 * @author 李卓远
 *
 */
@Controller("otherIllFollowService")
public class OtherIllFollowService implements IOtherIllFollowService {
@Autowired
RegistrationOtherDiseasesDao registrationotherdiseasesdao;
	@Override
	public int saveOtherIllFollow(TRegistrationOtherDiseases qtf) {
		// TODO Auto-generated method stub
		String sql = "SELECT auto_increment FROM information_schema.`TABLES` WHERE table_name = 'T_REGISTRATION_OTHER_DISEASES' and TABLE_SCHEMA='jmjk'";
		registrationotherdiseasesdao.Save(qtf);
		return registrationotherdiseasesdao.getPrefetching(sql);
	}

	@Override
	public void deleteOtherIllFollow(TRegistrationOtherDiseases qtf) {
		// TODO Auto-generated method stub
		registrationotherdiseasesdao.delete(qtf);

	}

	@Override
	public void editOtherIllFollow(TRegistrationOtherDiseases qtf) {
		// TODO Auto-generated method stub
		registrationotherdiseasesdao.update(qtf);

	}

	@Override
	public TRegistrationOtherDiseases getOtherIllFollowByMbfid(int mbfid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("mbfid", mbfid);
		String hql = "from TRegistrationOtherDiseases trod where trod.TChronicFollow.chronicFollowId = :mbfid";
		return registrationotherdiseasesdao.Get(hql,p);
	}

	@Override
	public TRegistrationOtherDiseases getOtherIllFollowByQtid(int qtfid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("qtfid", qtfid);
		String hql = "from TRegistrationOtherDiseases trod where trod.TRegOthDisId = :qtfid";
		return registrationotherdiseasesdao.Get(hql,p);
	}

}
