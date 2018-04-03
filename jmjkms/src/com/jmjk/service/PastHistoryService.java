package com.jmjk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.MedicalPayMethodDao;
import com.jmjk.dao.PastHistoryDao;
import com.jmjk.entity.TMedicalPayMethod;
import com.jmjk.entity.TPastHistory;
import com.jmjk.iservice.IPastHistoryService;
@Controller("pastHistoryService")
public class PastHistoryService  implements IPastHistoryService{
	@Autowired
	private  PastHistoryDao pastHistoryDao;
	@Override
	public void savePastHistory(TPastHistory pasthistory) {
		
			pastHistoryDao.Save(pasthistory);
		
		
	}

	@Override
	public void deletePastHistory(int hFileid) {
		String hql="delete from TPastHistory tp where tp.THealthFile.healthFileId="+hFileid;
		pastHistoryDao.delete(hql);
		
	}

	@Override
	public List<TPastHistory> getPastHistory(int hFileId,String name) {
		String hql="from TPastHistory tp where  tp.THealthFile.healthFileId="+hFileId+" and tp.pastType='"+name+"'";
		return pastHistoryDao.find(hql);
	}
	@Override
	public List<TPastHistory> getPastHistory(int hFileId ){
		String hql="from TPastHistory tp where  tp.THealthFile.healthFileId="+hFileId;
		return pastHistoryDao.find(hql);
	}
}
