package com.jmjk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.PowerDao;
import com.jmjk.entity.TPower;
import com.jmjk.iservice.IPowerService;
/*
 * 社区医院service实现
 * @author songhuili
 *   18803096552
 */

@Controller("powerService")
public class PowerService implements IPowerService {
	@Autowired
	private PowerDao powerDao;
	
	@Override
	public List<TPower> getPowers() {
		String hql="from TPower tp order by tp.code";
		return powerDao.find(hql);
	}

	@Override
	public TPower getTPowerFirstBySecond(String code) {
 		String hql1="from TPower tp where tp.code="+code;
		TPower power=powerDao.Get(hql1);
		String firstname=power.getFirst();
		String hql="from TPower tp where tp.first = '"+firstname+"'and tp.vauleName=null";
		return powerDao.Get(hql);
	}

}
