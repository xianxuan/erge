package com.jmjk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.MedicalPayMethodDao;
import com.jmjk.entity.TMedicalPayMethod;
import com.jmjk.iservice.IMedicalPayMethodService;
@Controller("medicalPayMethodService")
public class MedicalPayMethodService implements IMedicalPayMethodService {
	@Autowired
	private  MedicalPayMethodDao medicalPayMethodDao;
	@Override
	public void saveMedicalPayMethod(List<TMedicalPayMethod> mpm) {
		medicalPayMethodDao.saveList(mpm);
		/*for(int i=0;i<mpm.size();i++){
			medicalPayMethodDao.Save(mpm.get(i));
		}*/
		/*for(TMedicalPayMethod test:mpm){
			medicalPayMethodDao.Save(test);
		}*/
	}

	@Override
	public void dedleteMedicalPayMethod(int hFileid) {
		String hql="delete from TMedicalPayMethod tp where tp.THealthFile.healthFileId="+hFileid;
		medicalPayMethodDao.delete(hql);
		
	}

	@Override
	public List<TMedicalPayMethod> getMedicalPayMethodByHFileId(int hFileId) {
		String hql="from TMedicalPayMethod tp where  tp.THealthFile.healthFileId="+hFileId;
		return medicalPayMethodDao.find(hql);
	}

}
