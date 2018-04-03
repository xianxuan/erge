package com.jmjk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.FileMedicalRecordDao;
import com.jmjk.dao.MedicalRecordDao;
import com.jmjk.entity.TFileMedicalRecord;
import com.jmjk.iservice.IFileMedicalRecordService;
@Controller("fileMedicalRecordService")
public class FileMedicalRecordService implements IFileMedicalRecordService{
	@Autowired
	private  FileMedicalRecordDao medicalRecordDao ;
	@Override
	public void saveFileMedicalRecord(TFileMedicalRecord fileMedicalRecord) {
		medicalRecordDao.Save(fileMedicalRecord);
		
	}

	@Override
	public void deleteFileMedicalRecord(int hFileid) {
		String hql="delete from TFileMedicalRecord tp where tp.THealthFile.healthFileId="+hFileid;
		medicalRecordDao.delete(hql);
	}

	@Override
	public List<TFileMedicalRecord> getFileMedicalRecordList(int hFileId) {
		String hql="from TFileMedicalRecord tp where  tp.THealthFile.healthFileId="+hFileId;
		return medicalRecordDao.find(hql);
	}

}
