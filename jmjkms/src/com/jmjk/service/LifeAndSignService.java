package com.jmjk.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.LifestyleGuideDao;
import com.jmjk.dao.SignDao;
import com.jmjk.entity.TLifestyleGuide;
import com.jmjk.entity.TSign;
import com.jmjk.iservice.ILifeAndSignService;
/**
 * 慢病随访-生活方式表和体征表接口实现
 * @author 李卓远
 *
 */
@Controller("lifeAndSignService")
public class LifeAndSignService implements ILifeAndSignService {
@Autowired
LifestyleGuideDao lifestyleguidedao;
@Autowired
SignDao signdao;
	@Override
	public int saveLifeGuide(TLifestyleGuide lg) {
		// TODO Auto-generated method stub
		String sql = "SELECT auto_increment FROM information_schema.`TABLES` WHERE table_name = 'T_LIFESTYLE_GUIDE' and TABLE_SCHEMA='jmjk'";
		lifestyleguidedao.Save(lg);
		return lifestyleguidedao.getPrefetching(sql);

	}

	@Override
	public void deleteLifeGuide(TLifestyleGuide lg) {
		// TODO Auto-generated method stub
		lifestyleguidedao.delete(lg);

	}

	@Override
	public void editLifeGuide(TLifestyleGuide lg) {
		// TODO Auto-generated method stub
		lifestyleguidedao.update(lg);

	}

	@Override
	public TLifestyleGuide getLifeGuideById(int lgid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("lgid", lgid);
		String hql = "from TLifestyleGuide tlg where tlg.lifestyleGuideId = :lgid";
		return lifestyleguidedao.Get(hql,p);
	}

	@Override
	public int saveSign(TSign ts) {
		// TODO Auto-generated method stub
		String sql = "SELECT auto_increment FROM information_schema.`TABLES` WHERE table_name = 'T_SIGN' and TABLE_SCHEMA='jmjk'";
		signdao.Save(ts);
		return signdao.getPrefetching(sql);

	}

	@Override
	public void deleteSign(TSign ts) {
		// TODO Auto-generated method stub
		signdao.delete(ts);

	}

	@Override
	public void editSign(TSign ts) {
		// TODO Auto-generated method stub
		signdao.update(ts);

	}

	@Override
	public TSign getSignById(int sid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("sid", sid);
		String hql = "from TSign ts where ts.signId = :sid";
		return signdao.Get(hql,p);
	}

}
