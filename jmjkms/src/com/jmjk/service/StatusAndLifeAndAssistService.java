package com.jmjk.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.AuxiliaryExaminationDao;
import com.jmjk.dao.GeneralConditionDao;
import com.jmjk.dao.LifeStyleDao;
import com.jmjk.entity.TAuxiliaryExamination;
import com.jmjk.entity.TGeneralCondition;
import com.jmjk.entity.TLifeStyle;
import com.jmjk.iservice.IStatusAndLifeAndAssistService;
/**
 * 一般状况、生活方式、辅助检查接口实现
 * @author 李卓远
 *
 */
@Controller("statusAndLifeAndAssistService")
public class StatusAndLifeAndAssistService implements
		IStatusAndLifeAndAssistService {
@Autowired
GeneralConditionDao generalconditiondao;
@Autowired
LifeStyleDao lifestyledao;
@Autowired 
AuxiliaryExaminationDao auxiliaryexaminationdao;
	@Override
	public int saveGen_Con(TGeneralCondition zk) {
		// TODO Auto-generated method stub
		String sql = "SELECT auto_increment FROM information_schema.`TABLES` WHERE table_name = 'T_GENERAL_CONDITION' and TABLE_SCHEMA='jmjk'";
		generalconditiondao.Save(zk);
		return generalconditiondao.getPrefetching(sql);
	}

	@Override
	public int saveLifeStyle(TLifeStyle sh) {
		// TODO Auto-generated method stub
		String sql = "SELECT auto_increment FROM information_schema.`TABLES` WHERE table_name = 'T_LIFE_STYLE' and TABLE_SCHEMA='jmjk'";
		lifestyledao.Save(sh);
		return lifestyledao.getPrefetching(sql);
	}

	@Override
	public int saveAuxi_Exam(TAuxiliaryExamination fz) {
		// TODO Auto-generated method stub
		String sql = "SELECT auto_increment FROM information_schema.`TABLES` WHERE table_name = 'T_AUXILIARY_EXAMINATION' and TABLE_SCHEMA='jmjk'";
		auxiliaryexaminationdao.Save(fz);
		return auxiliaryexaminationdao.getPrefetching(sql);
	}

	@Override
	public void deleteGen_Con(TGeneralCondition zk) {
		// TODO Auto-generated method stub
		generalconditiondao.delete(zk);

	}

	@Override
	public void deleteLifeStyle(TLifeStyle sh) {
		// TODO Auto-generated method stub
		lifestyledao.delete(sh);

	}

	@Override
	public void deleteAuxi_Exam(TAuxiliaryExamination fz) {
		// TODO Auto-generated method stub
		auxiliaryexaminationdao.delete(fz);

	}

	@Override
	public void editGen_Con(TGeneralCondition zk) {
		// TODO Auto-generated method stub
		generalconditiondao.update(zk);

	}

	@Override
	public void editLifeStyle(TLifeStyle sh) {
		// TODO Auto-generated method stub
		lifestyledao.update(sh);

	}

	@Override
	public void editAuxi_Exam(TAuxiliaryExamination fz) {
		// TODO Auto-generated method stub
		auxiliaryexaminationdao.update(fz);

	}

	@Override
	public TGeneralCondition getGen_ConByZkId(int zkid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("zkid", zkid);
		String hql = "from TGeneralCondition tc where tc.generalConditionId = :zkid";
		return generalconditiondao.Get(hql,p);
	}

	@Override
	public TLifeStyle getLifeStyleByLifeId(int lfid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("lfid", lfid);
		String hql = "from TLifeStyle tl where tl.lifeId = :lfid";
		return lifestyledao.Get(hql,p);
	}

	@Override
	public TAuxiliaryExamination getAuxi_ExamByFzId(int fzid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("fzid", fzid);
		String hql = "from TAuxiliaryExamination te where te.auxiliaryExaminationId = :fzid";
		return auxiliaryexaminationdao.Get(hql,p);
	}

}
