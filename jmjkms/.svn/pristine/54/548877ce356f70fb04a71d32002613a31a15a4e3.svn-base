package com.jmjk.service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jmjk.dao.OldStaffHosDao;
import com.jmjk.dao.RecoveryOldDao;
import com.jmjk.dao.RecoveryPlanDao;
import com.jmjk.dao.RecoverySchemeDao;
import com.jmjk.entity.TOldStaffHos;
import com.jmjk.entity.TRecoveryOld;
import com.jmjk.entity.TRecoveryPlan;
import com.jmjk.entity.TRecoveryScheme;
import com.jmjk.enums.IS_DELETE;
import com.jmjk.enums.RecoveryPlanStatus;



import com.jmjk.export.recoveryPlanExport;
import com.jmjk.iservice.IRecoveryPlanService;
import com.jmjk.utils.Page;
import com.jmjk.utils.TypeConverter;

/**
 * 康复计划接口实现
 * 
 * @author wq 2016-08-01
 */
@Controller("recoveryPlanService")
public class RecoveryPlanService implements IRecoveryPlanService {
	@Autowired
	private RecoveryPlanDao recoveryPlanDao;
	@Autowired
	private RecoverySchemeDao recoverySchemeDao;
	@Autowired
	private RecoveryOldDao recoveryOldDao;
	
	
	@Override
	public List<TRecoveryPlan> getAllRecoveryPlanForExport(int hosId) {
		
		Map<String, Object> params=new HashMap<String, Object>();
		
		String hql="";
		if(hosId==-1){
			hql="from TRecoveryPlan trp where trp.idDelete="+IS_DELETE.no_Delete.getValue();
		}
		else{
			params.put("hosId", hosId);
			 hql = "from TRecoveryPlan trp where trp.communityHospitalId=:hosId";
			hql +=" and trp.idDelete="+IS_DELETE.no_Delete.getValue();
			hql+=" order by trp.beginTime desc";
		}
		List<TRecoveryPlan> trp = recoveryPlanDao.find(hql,params);
		return trp;
	}
	
	
	@Override
	public List<TRecoveryPlan> getAllRecoveryPlanByHosId(
			Page<TRecoveryPlan> page, int comHosId,int flag) {
		Map<String, Object> params = new HashMap<String, Object>();
		
		
		String hql="";
		if(comHosId==-1){				
			hql="from TRecoveryPlan trp where trp.idDelete="+IS_DELETE.no_Delete.getValue();
		}
		else{
			params.put("comHosId",comHosId);
			 hql = "from TRecoveryPlan trp where trp.communityHospitalId=:comHosId";
			hql +=" and trp.idDelete="+IS_DELETE.no_Delete.getValue();
		}
		if(flag!=-1){
			params.put("staffId",flag);
			hql +="and trp.TStaff.staffId=:staffId";
		}
		hql+=" order by trp.beginTime desc";
		return recoveryPlanDao.find(hql,params, page.getCurrentPage(), page.getPageSize());
	}
	@Override
	public long getAllRecoveryPlanCountByHosId(int comHosId,int flag) {
		Map<String, Object> params = new HashMap<String, Object>();
		
		String hql="";
		if(comHosId==-1){
			hql="select count(*) from TRecoveryPlan trp where trp.idDelete="+IS_DELETE.no_Delete.getValue();
		}
		else{
			params.put("comHosId",comHosId);
			 hql = "select count(*) from TRecoveryPlan trp where trp.communityHospitalId=:comHosId";
			hql +=" and trp.idDelete="+IS_DELETE.no_Delete.getValue();
		}
		if(flag!=-1){
			params.put("staffId",flag);
			hql +="and trp.TStaff.staffId=:staffId";
		}
		return recoveryPlanDao.count(hql,params);
	}

	@Override
	public TRecoveryPlan getRecoveryPlanById(int id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id",id);
		String hql = "from TRecoveryPlan trp where trp.recoveryPlanId=:id" ;

		return recoveryPlanDao.Get(hql,params);
	}

	@Override
	public List<TRecoveryPlan> getRecoveryPlanByCon(TRecoveryPlan plan,
			Page<TRecoveryPlan> page) {
		
		String hql = "from TRecoveryPlan trp  where trp.idDelete="+IS_DELETE.no_Delete.getValue();
		if (plan.getTStaff().getName()!=null&&!plan.getTStaff().getName().equals(""))
		{
			hql += "and  trp.status=" + plan.getStatus();
			hql += " and trp.TStaff.name like'%"
					+ plan.getTStaff().getName() + "%'";
		}
		if(plan.getPlanName()!=null&&!plan.getPlanName().equals(""))
		{	
			hql += " and trp.status=" + plan.getStatus();
			hql += "and trp.planName like'%" + plan.getPlanName() + "%'";
		}
		if((plan.getTStaff().getName()==null||plan.getTStaff().getName().equals(""))&&(plan.getPlanName()==null||plan.getPlanName().equals("")))
		{
			hql+=" and trp.status=" + plan.getStatus();
		}
		if(plan.getCommunityHospitalId()!=-1)
		{
			hql +="and trp.communityHospitalId="+plan.getCommunityHospitalId();
		}
		if(plan.getTStaff()!=null&&plan.getTStaff().getStaffId()!=null)
		{
			hql+="and trp.TStaff.staffId ="+plan.getTStaff().getStaffId();
		}
		hql+=" order by trp.beginTime desc";
		List<TRecoveryPlan> recoveryPlanList = recoveryPlanDao.find(hql,
				page.getCurrentPage(), page.getPageSize());
		return recoveryPlanList;

	}

	@Override
	public List<TRecoveryOld> getRecoveryOldById(int id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id",id);
		String hql = " from TRecoveryOld tro  where tro.TRecoveryPlan.recoveryPlanId =:id ";
		return recoveryOldDao.find(hql,params);
	}

	
	@Override
	public long getRecoveryPlanCountByCon(TRecoveryPlan plan) {

		String hql = "select count(*) from TRecoveryPlan trp  where trp.idDelete="+IS_DELETE.no_Delete.getValue();
		if (plan.getTStaff().getName()!=null&&!plan.getTStaff().getName().equals(""))
		{
			hql += "and  trp.status=" + plan.getStatus();
			hql += " and trp.TStaff.name like'%"
					+ plan.getTStaff().getName() + "%'";
		}
		if(plan.getPlanName()!=null&&!plan.getPlanName().equals(""))
		{	
			hql += " and trp.status=" + plan.getStatus();
			hql += "and trp.planName like'%" + plan.getPlanName() + "%'";
		}
		if((plan.getTStaff().getName()==null||plan.getTStaff().getName().equals(""))&&(plan.getPlanName()==null||plan.getPlanName().equals("")))
		{
			hql+=" and trp.status=" + plan.getStatus();
		}
		if(plan.getCommunityHospitalId()!=-1)
		{
			hql +="and trp.communityHospitalId="+plan.getCommunityHospitalId();
		}
		if(plan.getTStaff()!=null&&plan.getTStaff().getStaffId()!=null)
		{
			hql+="and trp.TStaff.staffId ="+plan.getTStaff().getStaffId();
		}
		return recoveryPlanDao.count(hql);
	}

	@Override
	public int addRecoveryPlan(TRecoveryPlan plan) {
		String sql = "select auto_increment from information_schema.`TABLES` where table_name = 'T_RECOVERY_PLAN' and TABLE_SCHEMA='jmjk'";
		recoveryPlanDao.Save(plan);
		return recoveryPlanDao.getPrefetching(sql);
	}

	@Override
	public void addRecoveryOld(List<TRecoveryOld> recoveryOld) {

		recoveryOldDao.saveList(recoveryOld);

	}

	@Override
	public void deleteRecoveryPlanById(int id) {
	
		String hql = "update  TRecoveryPlan trp set trp.idDelete="+IS_DELETE.delete.getValue()+" where trp.recoveryPlanId = "+id;
				;
		recoveryPlanDao.update(hql);
	}

	@Override
	public void deleteAnyRecoveryPlan(List<Object> idList) {

		String a = ",";
		String str = TypeConverter.convertList2String(idList, a);
		String hql = "delete from TRecoveryPlan trp where trp.recoveryPlanId in ("
				+ str + ")";
		recoveryPlanDao.delete(hql);

	}

	@Override
	public void deleteAnyRecoveryOld(int recoveryPlanId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("recoveryPlanId)",recoveryPlanId);
		String hql = "delete from TRecoveryOld tro where tro.TRecoveryPlan.recoveryPlanId=: recoveryPlanId"
				;
		recoveryPlanDao.delete(hql);

	}

	@Override
	public void updateRecoveryPlan(TRecoveryPlan plan) {
		recoveryPlanDao.update(plan);
		int i=0;
	}

	@Override
	public void changeStatus(int id, String statu) {
		
		String hql = "update TRecoveryPlan tp set tp.status="+ statu
				+ " where TOldStaffHosId.oldStaffHosId="+id ;
		recoveryPlanDao.update(hql);

	}

	@Override
	public boolean checkRecoveryScheme(int id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id",id);
		String hql = "select count(trp.recoveryPlanId) from TRecoveryPlan trp  where trp.TRecoveryScheme.recoverySchemeId= :id";
		if (recoveryPlanDao.count(hql,params)>0) {
			return false;
		} else
			return true;
	}

	@Override
	public boolean checkRecoveryPlan(int id) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id",id);
		String hql =  "from TRecoveryPlan trp  where trp.recoveryPlanId= :id";
		if (recoveryPlanDao.Get(hql,params).getStatus().equals(RecoveryPlanStatus.STARTING.getValue())) {
			return false;
		} else
			
			return true;
	}


	@Override
	public List<TRecoveryOld> getRecoveryPlansByHealthFileId(int healthFileId,String disease,
			Page<TRecoveryOld> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("healthFileId",healthFileId);
		params.put("disease","%"+disease+"%");
		params.put("noDelete", IS_DELETE.no_Delete.getValue());
		String hql = "from TRecoveryOld tro where tro.THealthFile.healthFileId=:healthFileId and tro.TRecoveryPlan.idDelete= :noDelete and tro.TRecoveryPlan.TRecoveryScheme.disease like :disease";
		List<TRecoveryOld> tRecoveryOlds = recoveryOldDao.find(hql,params, page.getCurrentPage(), page.getPageSize());
		return tRecoveryOlds;
	}


	@Override
	public long countRecoverPlanByHealthFileId(int healthFileId,String disease) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("healthFileId",healthFileId);
	    params.put("disease","%"+disease+"%");
	    params.put("noDelete", IS_DELETE.no_Delete.getValue());
		String hql = "select count(tro.TRecoveryPlan.recoveryPlanId) from TRecoveryOld tro where tro.THealthFile.healthFileId=:healthFileId and tro.TRecoveryPlan.idDelete= :noDelete and tro.TRecoveryPlan.TRecoveryScheme.disease like :disease";
		return recoveryOldDao.count(hql,params);
	}


	@Override
	public List<TRecoveryOld> getRecoveryOldList(int healthFileId,
			String disease, Page<TRecoveryOld> page, Date startTime,
			Date endTime, String planName, int planState) {
		//Map<String, Object> params = new HashMap<String, Object>();
		//params.put("healthFileId",healthFileId);
		//params.put("disease", "%"+disease+"%");
		String hql = "from TRecoveryOld tro where tro.THealthFile.healthFileId="+healthFileId+"";
		//+ " and tro.TRecoveryPlan.TRecoveryScheme.disease like'%"+disease+"%' and tro.TRecoveryPlan.planName like'%"+planName+"%' and tro.TRecoveryPlan.status="+planState;
		hql+=" and tro.TRecoveryPlan.TRecoveryScheme.disease like '%"+disease+"%'";
		hql+=" and tro.TRecoveryPlan.idDelete="+IS_DELETE.no_Delete.getValue();
		if(!"".equals(planName)&&planName!=null){
			hql+=" and tro.TRecoveryPlan.planName like '%"+planName+"%'";
		}
		if(planState!=-1){
			hql+=" and tro.TRecoveryPlan.status="+planState+"";
		}
		if(startTime != null){
			hql+=" and tro.TRecoveryPlan.beginTime >= '"+TypeConverter.dateFormat(startTime)+"'";
		}
		if(endTime != null){
			hql += " and tro.TRecoveryPlan.overTime <= '"+TypeConverter.dateFormat(endTime)+"'";
		}
		List<TRecoveryOld> recoveryOldList = recoveryOldDao.find(hql, page.getCurrentPage(), page.getPageSize());		
		return recoveryOldList;
	}


	@Override
	public long countRecoveryOldList(int healthFileId, String disease,
			Date startTime, Date endTime, String planName, int planState) {
		String hql = "select count(tro.recoveryOldId) from TRecoveryOld tro where tro.THealthFile.healthFileId="+healthFileId+"";
		//+ " and tro.TRecoveryPlan.TRecoveryScheme.disease like'%"+disease+"%' and tro.TRecoveryPlan.planName like'%"+planName+"%' and tro.TRecoveryPlan.status="+planState;
			   hql+=" and tro.TRecoveryPlan.TRecoveryScheme.disease like'%"+disease+"%'";
			   hql+=" and tro.TRecoveryPlan.idDelete="+IS_DELETE.no_Delete.getValue();
			if(planState!=-1){
				hql+=" and tro.TRecoveryPlan.status="+planState+"";
			}
			if(!"".equals(planName)&&planName!=null){
				hql+=" and tro.TRecoveryPlan.planName like '%"+planName+"%'";
			}
			if(startTime != null){
				hql+=" and tro.TRecoveryPlan.beginTime >= '"+TypeConverter.dateFormat(startTime)+"'";
			}
			if(endTime != null){
				hql += " and tro.TRecoveryPlan.beginTime <= '"+TypeConverter.dateFormat(endTime)+"'";
			}
			return recoveryOldDao.count(hql);
		}
	@Override
	public Integer getNextId() {
		String sql = "select auto_increment from information_schema.`TABLES` where table_name = 'T_RECOVERY_PLAN' and TABLE_SCHEMA='jmjk'";
		return recoveryPlanDao.getPrefetching(sql)+1;
	}

	//zdj
	@Override
	public void addRecoveryOld(TRecoveryOld reold){
		recoveryOldDao.Save(reold);
	}

	public List<TRecoveryOld> getPlanIdByFileId(int daId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("daId",daId);
		// TODO Auto-generated method stub
		String hql="from TRecoveryOld tro where tro.THealthFile.healthFileId=:daId";
		return recoveryOldDao.find(hql,params);
	}

	@Override
	public List<TRecoveryPlan> getStatisticalAnalysisByDate(
			String select,Page<TRecoveryPlan> page, Date fromDate, Date toDate,
			int comHosId,int flag) {
		String hql = "from TRecoveryPlan trp where 1=1 ";
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //注意yyyy-MM-dd这样的格式,M不能小写
		String fd="",td="";
		if(fromDate!=null)
		{
			fd=sdf.format(fromDate);
		}
		if(toDate!=null)
		{
			td=sdf.format(toDate);
		}
		if(select.equals("开始日期"))
		{
				if(fd != "" && !fd.equals("")){
					
					hql+=" and trp.beginTime >= '";
					hql+=fd;
					hql+="'";
				}
				if(td != null && !td.equals("")){
					hql+=" and trp.beginTime <= '";
					hql+=td;
					hql+="'";
				}
		}
		else{
				if(fd != "" && !fd.equals("")){
					hql+=" and trp.overTime >= '";
					hql+=fd;
					hql+="'";
				}
				if(td != null && !td.equals("")){
					hql+=" and trp.overTime <= '";
					hql+=td;
					hql+="'";
				}
		}
		if(comHosId!=-1)
		{
			hql+=" and trp.communityHospitalId = "+comHosId;
		
		}
		if(flag!=-1){
			
			hql +="and trp.TStaff.staffId="+flag;
		}
		List<TRecoveryPlan> recoveryPlanList = recoveryPlanDao.find(hql,page.getCurrentPage(), page.getPageSize());
		return recoveryPlanList;
		}

	@Override
	public long countBySearch(String select,Date fromDate, Date toDate, int sqId,int flag) {
		Map<String, Object> params = new HashMap<String, Object>();
		
		String hql = " select count(trp.recoveryPlanId) from TRecoveryPlan trp where 1=1 ";
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //注意yyyy-MM-dd这样的格式,M不能小写
		String fd="",td="";
		if(fromDate!=null)
		{
			fd=sdf.format(fromDate);
		}
		if(toDate!=null)
		{
			td=sdf.format(toDate);
		}
		if(select.equals("开始日期"))
		{
				if(fd != "" && !fd.equals("")){
					hql+=" and trp.beginTime >= '";
					hql+=fd;
					hql+="'";
				}
				if(td != null && !td.equals("")){
					hql+=" and trp.beginTime <= '";
					hql+=td;
					hql+="'";
				}
		}
		else{
				if(fd != "" && !fd.equals("")){
					hql+=" and trp.overTime >= '";
					hql+=fd;
					hql+="'";
				}
				if(td != null && !td.equals("")){
					hql+=" and trp.overTime <= '";
					hql+=td;
					hql+="'";
				}
		}
		if(sqId!=-1)
		{
			params.put("sqId",sqId);
			hql+=" and trp.communityHospitalId =:sqId ";
		}
		if(flag!=-1){
			params.put("staffId",flag);
			hql +="and trp.TStaff.staffId=:staffId";
		}
		return recoveryPlanDao.count(hql,params);
	}


	@Override
	public long checkName(int comHos, String planName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("comHos",comHos);
		params.put("planName",planName);
		// TODO Auto-generated method stub
		String hql="select count(*) from TRecoveryPlan trp where trp.communityHospitalId=:comHos and trp.planName=:planName and trp.idDelete="+IS_DELETE.no_Delete.getValue();
		return recoveryPlanDao.count(hql,params);
	}


	
	//***********************zdj**************//
	@Override
	public void updatePlanIsDelete(int planId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("planId",planId);
		// TODO Auto-generated method stub
		String hql="update from TRecoveryPlan tro set tro.isDelete="+IS_DELETE.delete.getValue()+" where tro.recoveryPlanId=:planId" ;
		recoveryPlanDao.update(hql);

	}


	@Override
	public boolean checkHealthIdPlanId(int healthFileId, int recoveryPlanId,String diseaseName) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("healthFileId",healthFileId);
		params.put("recoveryPlanId",recoveryPlanId);
		String hql = " from TRecoveryOld tro  where tro.THealthFile.healthFileId= :healthFileId and tro.TRecoveryPlan.recoveryPlanId= :recoveryPlanId ";
		if(recoveryOldDao.Get(hql,params)!=null&&
				recoveryOldDao.Get(hql,params).getTRecoveryPlan().getTRecoveryScheme().getDisease().equals(diseaseName)){
			return true;
		}
		else {
			return false;
		}
	}
	

}
	
	

