package com.jmjk.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.DoctorDiagnosisDao;
import com.jmjk.entity.TDoctorDiagnosis;
import com.jmjk.iservice.IDoctorDiagnosisService;
import com.jmjk.utils.Page;
@Controller("doctorDiagnosisService")
public class DoctorDiagnosisService implements IDoctorDiagnosisService{
	@Autowired
	private DoctorDiagnosisDao doctorDiagnosisDao;
	@Override
	public void saveDoctorDiagnosis(TDoctorDiagnosis yszd) {
		doctorDiagnosisDao.Save(yszd);
	}

	@Override
	public void updateDoctorDiagnosis(TDoctorDiagnosis yszd) {
		doctorDiagnosisDao.update(yszd);
	}

	@Override
	public void deteleDoctorDiagnosis(int yszdId) {
		String hql="delete from TDoctorDiagnosis dd where dd.doctorDiagnosisId="+yszdId;
		doctorDiagnosisDao.delete(hql);
	}

	@Override
	public TDoctorDiagnosis getDoctorDiagnosisByYszdId(int yszdId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("yszdId", yszdId);
		String hql="from TDoctorDiagnosis dd where dd.doctorDiagnosisId =:yszdId";
		return doctorDiagnosisDao.Get(hql,params);
	}

	@Override
	public List<TDoctorDiagnosis> getAllDoctorDiagnosisByHFileid(int daId,String chronicName,
			Page<TDoctorDiagnosis> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("daId", daId);
		params.put("chronicName", chronicName);
		String hql="from TDoctorDiagnosis dd where dd.THealthFile.healthFileId = :daId and dd.chronic = :chronicName order by dd.date desc";
		return doctorDiagnosisDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}

	@Override
	public List<TDoctorDiagnosis> getDoctorDiagnosisByTime(int daId,String chronicName,
			Page<TDoctorDiagnosis> page, Date startTime, Date endTime){
		String hql="from TDoctorDiagnosis dd where dd.THealthFile.healthFileId = "+daId+" and dd.chronic = '"+chronicName+"'";
		if(startTime!=null){
			hql+=" and DATE_FORMAT(dd.date,'%Y-%m-%d') >= '"+startTime+"'";
		}
		if (endTime!=null) {
			hql+=" and DATE_FORMAT(dd.date,'%Y-%m-%d') <= '"+endTime+"'";
		}
		hql+=" order by dd.date desc";
		List<TDoctorDiagnosis> listDoctorDiagnosis=doctorDiagnosisDao.find(hql,page.getCurrentPage(),page.getPageSize());
		
		return listDoctorDiagnosis;
	}

	@Override
	public long allNumDoctorDiagnosisByTime(int daId,String chronicName,Date startTime,
			Date endTime) throws ParseException {
		//StringBuffer hql = new StringBuffer("select count(dd.doctorDiagnosisId) from TDoctorDiagnosis dd where dd.THealthFile.healthFileId="+daId);
		String hql="select count(dd.doctorDiagnosisId) from TDoctorDiagnosis dd where dd.THealthFile.healthFileId = "+daId+" and dd.chronic = '"+chronicName+"' ";
		if(startTime!=null){
			hql+="and dd.date >= "+startTime+" ";
		}
		if (endTime!=null) {
			hql+="and dd.date >= "+endTime+" ";
		}
		hql+="order by dd.date desc";
		return doctorDiagnosisDao.count(hql);
	}

	


}
