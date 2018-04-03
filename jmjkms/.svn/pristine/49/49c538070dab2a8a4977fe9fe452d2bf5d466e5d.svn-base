package com.jmjk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.jmjk.dao.ChronicDiseaseDao;
import com.jmjk.dao.VChronicDao;
import com.jmjk.entity.TChronicDisease;
import com.jmjk.entity.view.VChronic;
import com.jmjk.enums.CHRONIC_MANAGER;
import com.jmjk.iservice.IAllChronicDiseaseService;
import com.jmjk.utils.Page;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.TypeConverter;
/**
 * 慢病总表及慢病视图接口实现
 * @author 李卓远
 *
 */
@Controller("chronicDiseaseService")
public class AllChronicDiseaseService implements IAllChronicDiseaseService {
	@Autowired
	ChronicDiseaseDao chronicdao;
	@Autowired
	VChronicDao vchronicDao;
	public String vc = "VChronic";
	
	@Override
	public int saveChronicDisease(TChronicDisease mb) {
		// TODO Auto-generated method stub
		String sql = "SELECT auto_increment FROM information_schema.`TABLES` WHERE table_name = 'T_CHRONIC_DISEASE' and TABLE_SCHEMA='jmjk'";
		chronicdao.Save(mb);
		return vchronicDao.getPrefetching(sql);
	}

	@Override
	public void deleteChronicDisease(TChronicDisease mb) {
		// TODO Auto-generated method stub
		chronicdao.delete(mb);

	}

	@Override
	public void editChronicDisease(TChronicDisease mb) {
		// TODO Auto-generated method stub
		chronicdao.update(mb);

	}
	
	@Override
	public List<VChronic> findChronicPeople(SearchBean se , Page<VChronic> page) {
		// TODO Auto-generated method stub
		String h = se.getHql(vc);
		String hql = h + " and entity.status != 9 order by entity.fileNum desc";//9为已删除的状态量
		List<VChronic> vclist = vchronicDao.find(hql , page.getCurrentPage(), page.getPageSize());
		return vclist;
	}
	
/*	@Override
	public List<VChronic> findBooldPressHealther(SearchBean se, Page<VChronic> page,
			int status) {
		// TODO Auto-generated method stub
		String h = se.getHql(vc);
		String hql = h + " and entity.status != 9 and entity.status = " + status;
		hql=hql+" order by vc.fileNum desc";
		return vchronicDao.find(hql,page.getCurrentPage(),page.getPageSize());
	}
	*/
	@Override
	public List<VChronic> findHealther(SearchBean se, Page<VChronic> page,
			int status) {
		// TODO Auto-generated method stub
		String h = se.getHql(vc);
		String hql = h + " and entity.status = " + status;
		hql=hql+" order by entity.fileNum desc";
		return vchronicDao.find(hql,page.getCurrentPage(),page.getPageSize());
	}
	
	@Override
	public long findHealtherCount(SearchBean se, int status) {
		// TODO Auto-generated method stub
		String h = se.getHql(vc);
		String hql = h + " and entity.status = " + status;
		return vchronicDao.find(hql).size();
	}
	
	@Override
	public long findChronicPeopleCount(SearchBean se) {
		// TODO Auto-generated method stub
		String h = se.getHql(vc);
		String hql ="select count(entity.chronicDiseaseId) " + h + " and entity.status != 9";
		long a=vchronicDao.count(hql);
		return a;
	}
	
	@Override
	public TChronicDisease getChronicDiseaseByID(int mbid) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mbid", mbid);
		String hql = "from TChronicDisease td where td.chronicDiseaseId = :mbid";
		return chronicdao.Get(hql , params);
	}

	@Override
	public List<VChronic> firstGetAllVc(int sqid, int zt, Page<VChronic> page) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sqid", sqid);
		params.put("zt", zt+"");
		String hql = " from VChronic vc where vc.communityHospitalId = :sqid  and vc.healthFileType= :zt and vc.status != 9 order by vc.fileNum desc";
		List<VChronic> vchroniclist = vchronicDao.find(hql, params, page.getCurrentPage(), page.getPageSize());
		return vchroniclist;
	}

	@Override
	public List<VChronic> someInformationForNurseAndSmalladmin(int sqid) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sqid", sqid);
		String hql = " from VChronic vc where vc.communityHospitalId = :sqid and vc.status != 9 order by vc.fileNum desc";
		return vchronicDao.find(hql , params);
	}
	
	@Override
	public long getAllVcCount(int sqid, int zt) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sqid", sqid);
		params.put("zt", zt+"");
		String hql = "select count (vc.chronicDiseaseId) from VChronic vc where vc.communityHospitalId = :sqid and vc.healthFileType = :zt and vc.status != 9";
		return vchronicDao.count(hql,params);
	}

	@Override
	public List<VChronic> getPeoPleAllIll(int fid, int sqid , int status) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fid", fid);
		params.put("sqid", sqid);
		params.put("status", status);
		String hql = "from VChronic vc where vc.healthFileId = :fid and vc.communityHospitalId = :sqid and vc.status != :status order by vc.fileNum desc";
		List<VChronic> vchroniclist = vchronicDao.find(hql,params);
		return vchroniclist;
	}
		
	@Override
	public List<VChronic> getPeopleAllIllForSuper(int fid ,int status) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fid", fid);
		params.put("status", status);
		String hql = "from VChronic vc where vc.healthFileId = :fid and vc.status != :status order by vc.fileNum desc";
		List<VChronic> vchroniclist = vchronicDao.find(hql,params);
		return vchroniclist;
	}
	
	@Override
	public VChronic getOneVc(int sqid, int mbid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("sqid", sqid);
		p.put("mbid", mbid);
		String hql = "from VChronic vc where vc.chronicDiseaseId = :mbid and vc.communityHospitalId = :sqid";
		return vchronicDao.Get(hql,p);
	}

	@Override
	public VChronic getOneVcForSupper(int mbid) {
		// TODO Auto-generated method stub
		Map<String, Object> p = new HashMap<String, Object>();
		p.put("mbid", mbid);
		String hql = "from VChronic vc where vc.chronicDiseaseId = :mbid";
		return vchronicDao.Get(hql , p);
	}
	
	@Override
	public List<VChronic> getAllPeople(int sqid , String illname,int flag) {
		// TODO Auto-generated method stub
		String hql = "from VChronic vc where vc.communityHospitalId = "+ sqid +" and vc.diseaseName = '"+illname+"'and vc.healthFileType='"+'2'+"'and vc.status!="+9; 
		if(flag!=-1){
			hql = "from VChronic vc where vc.communityHospitalId = "+ sqid +" and vc.diseaseName = '"+illname+"'and vc.healthFileType='"+'2'+"'and vc.status!="+9+"and vc.staffId="+flag;; 
			
		}
		List<VChronic> vclist = vchronicDao.find(hql);
		return vclist;
	}
	
	
	
	
	
	//////////////zdj
	@Override
	public VChronic getVChronicByChronicDiseaseId(int mbid) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mbid", mbid);
		String hql = "from VChronic vc where vc.chronicDiseaseId =:mbid";
		return vchronicDao.Get(hql, params);
	}
	
	@Override
	public List<VChronic> getAllDiabeteManager(int i,Page<VChronic> page){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("i", i);
		String hql="from VChronic vc where vc.status =:i";
		hql+=" order by vc.fileNum desc";
		List<VChronic> vcmanagerlist = vchronicDao.find(hql,params);
		return vcmanagerlist;
		
	}
	
	@Override
	public TChronicDisease getChronicDiseaseByNumName(int daId , String name){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("daId", daId);
		params.put("name", name);
		String hql = "from TChronicDisease td where td.THealthFile.healthFileId =:daId and td.diseaseName =:name";
		return chronicdao.Get(hql,params);
		
	}
	
	@Override
	public List<VChronic> getChronicManager(int sqid, int zt, int status ,Page<VChronic> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sqid", sqid);
		params.put("zt", zt+"");
		params.put("status", status);
		String hql = " from VChronic vc where vc.communityHospitalId = :sqid and vc.healthFileType = :zt and vc.status = :status order by vc.fileNum desc";
		return vchronicDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public long getcountChronicManager(int sqid, int zt, int status) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sqid", sqid);
		params.put("zt", zt+"");
		params.put("status", status);
		String hql = "select count (vc.chronicDiseaseId) from VChronic vc where vc.communityHospitalId =:sqid and vc.healthFileType =:zt and vc.status =:status order by vc.fileNum desc";
		return vchronicDao.count(hql,params);
	}
	@Override
	public long getAdminCountChronicManager(int zt, int status) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("zt", zt+"");
		params.put("status", status);
		String hql = "select count (vc.chronicDiseaseId) from VChronic vc where vc.healthFileType =:zt and vc.status =:status order by vc.fileNum desc";
		return vchronicDao.count(hql,params);
	}
	@Override
	public List<VChronic> getAdminChronicManagerPage(int zt, int status,Page<VChronic> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("zt", zt+"");
		params.put("status", status);
		String hql = "from VChronic vc where vc.healthFileType =:zt and vc.status =:status order by vc.fileNum desc";
		return vchronicDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VChronic> getAdminChronicManager(int zt, int status) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("zt", zt+"");
		params.put("status", status);
		String hql = "from VChronic vc where vc.healthFileType =:zt and vc.status =:status order by vc.fileNum desc";
		return vchronicDao.find(hql,params);
	}
	@Override
	public List<VChronic> getallDiabeteManagerSpecial(int hosId, int person,
			int m, int status , Page<VChronic> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		params.put("m", m+"");
		params.put("person", person);
		params.put("status", status);
		String hql = "from VChronic vc where vc.communityHospitalId =:hosId and vc.healthFileType =:m and vc.staffId =:person and vc.status =:status order by vc.fileNum desc";
 //from VChronic vc where vc.communityHospitalId =:hosId and vc.healthFileType =:m and vc.staffId =:person and vc.status =:status order by vc.fileNum desc
//from VChronic entity where 1=1  and entity.staffId = 1 and entity.communityHospitalId = 59 and entity.healthFileType = 2 and ( 1 <> 1  or entity.diseaseName = '高血压' ) and entity.status = 1		
		return vchronicDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<VChronic> getallDiabeteManagerSpecialNoPage(int hosId,
			int person, int m, int status) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		params.put("m", m+"");
		params.put("person", person);
		params.put("status", status);
		String hql = "from VChronic vc where vc.communityHospitalId =:hosId and vc.healthFileType =:m and vc.staffId =:person and vc.status =:status order by vc.fileNum desc";
		return vchronicDao.find(hql,params);
	}
	@Override
	public long getallCountDiabeteManagerSpecial(int hosId, int person,
			int m, int status) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		params.put("m", m+"");
		params.put("person", person);
		params.put("status", status);
		String hql = "select count (vc.chronicDiseaseId) from VChronic vc where vc.communityHospitalId =:hosId and vc.healthFileType =:m and vc.staffId =:person and vc.status =:status";
		return vchronicDao.count(hql,params);
	}
	
	@Override
	public List<VChronic> getOtherChronicManager(int sqid, int zt, Page<VChronic> page){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sqid", sqid);
		params.put("zt", zt+"");
		params.put("status", CHRONIC_MANAGER.OTHER_MANAGER.getValue());
		String hql = "from VChronic vc where vc.communityHospitalId =:sqid and vc.healthFileType =:zt and vc.status =:status order by vc.fileNum desc";
		List<VChronic> list=vchronicDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
		return list;
	}
	@Override
	public List<VChronic> getOtherChronicManagerNoPage(int sqid, int zt) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sqid", sqid);
		params.put("zt", zt+"");
		params.put("status", CHRONIC_MANAGER.OTHER_MANAGER.getValue());
		String hql = "from VChronic vc where vc.communityHospitalId =:sqid and vc.healthFileType =:zt and vc.status =:status order by vc.fileNum desc";
		return vchronicDao.find(hql,params);
	}
	@Override
	public long getcountOtherChronicManager(int sqid, int zt){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sqid", sqid);
		params.put("zt", zt+"");
		params.put("status", CHRONIC_MANAGER.OTHER_MANAGER.getValue());
		String hql = "select count (vc.chronicDiseaseId) from VChronic vc where vc.communityHospitalId =:sqid and vc.healthFileType =:zt and vc.status =:status";
		return vchronicDao.count(hql,params);
	}
	@Override
	public List<VChronic> getAdminOtherManager(int zt,Page<VChronic> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("zt", zt+"");
		params.put("status", CHRONIC_MANAGER.OTHER_MANAGER.getValue());
		String hql = "from VChronic vc where vc.healthFileType =:zt and vc.status =:status order by vc.fileNum desc";
		return vchronicDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public long getAdminCountOtherManager(int zt) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("zt", zt+"");
		params.put("status", CHRONIC_MANAGER.OTHER_MANAGER.getValue());
		String hql = "select count (vc.chronicDiseaseId) from VChronic vc where vc.healthFileType =:zt and vc.status =:status";
		return vchronicDao.count(hql,params);
	}
	@Override
	public List<VChronic> getallOtherManagerSpecial(int hosId,
			int personOtherChronic, int m, Page<VChronic> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		params.put("personOtherChronic", personOtherChronic);
		params.put("m", m+"");
		params.put("status", CHRONIC_MANAGER.OTHER_MANAGER.getValue());
		String hql = " from VChronic vc where vc.communityHospitalId =:hosId and vc.healthFileType =:m and vc.staffId =:personOtherChronic and vc.status =:status";
			   hql+= " order by vc.fileNum desc";
		return vchronicDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public long getallCountOtherManagerSpecial(int hosId,
			int personOtherChronic, int m) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("hosId", hosId);
		params.put("personOtherChronic", personOtherChronic);
		params.put("m", m+"");
		params.put("status", CHRONIC_MANAGER.OTHER_MANAGER.getValue());
		String hql = "select count (vc.chronicDiseaseId) from VChronic vc where vc.communityHospitalId =:hosId and vc.healthFileType =:m and vc.staffId =:personOtherChronic and vc.status =:status";
		return vchronicDao.count(hql,params);
	}
	@Override
	public List<VChronic> getNoDiabeteHighManager(int sqid, int m,
			String chronicName, Page<VChronic> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sqid", sqid);
		params.put("chronicName", chronicName);
		params.put("m", m+"");
		params.put("status", CHRONIC_MANAGER.NO_MANAGER.getValue());
		String hql="from VChronic vc where vc.communityHospitalId =:sqid and vc.healthFileType =:m and vc.diseaseName =:chronicName and vc.status =:status";
		hql+=" order by vc.fileNum desc";
		return vchronicDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public long getcountNoDiabeteHighManager(int sqid, int m,
			String chronicName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sqid", sqid);
		params.put("chronicName", chronicName);
		params.put("m", m+"");
		params.put("status", CHRONIC_MANAGER.NO_MANAGER.getValue());
		String hql="select count (vc.chronicDiseaseId) from VChronic vc where vc.communityHospitalId =:sqid and vc.healthFileType =:m and vc.diseaseName =:chronicName and vc.status =:status";
		return vchronicDao.count(hql,params);
	}
	
	@Override
	public List<VChronic> getNoOtherManager(int sqid, int m,String diabeteName,
			String highName, Page<VChronic> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sqid", sqid);
		params.put("diabeteName", diabeteName);
		params.put("highName", highName);
		params.put("m", m+"");
		params.put("status", CHRONIC_MANAGER.NO_MANAGER.getValue());
		String hql="from VChronic vc where vc.communityHospitalId =:sqid and vc.healthFileType =:m and vc.diseaseName <>:diabeteName and vc.diseaseName <>:highName and vc.status =:status";
		hql+=" order by vc.fileNum desc";
		return vchronicDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public long getcountNoOtherManager(int sqid, int m,String diabeteName,
			String highName) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sqid", sqid);
		params.put("diabeteName", diabeteName);
		params.put("highName", highName);
		params.put("m", m+"");
		params.put("status", CHRONIC_MANAGER.NO_MANAGER.getValue());
		String hql="select count (vc.chronicDiseaseId) from VChronic vc where vc.communityHospitalId =:sqid and vc.healthFileType =:m and vc.diseaseName <>:diabeteName and vc.diseaseName <>:highName and vc.status =:status";
	 	return vchronicDao.count(hql,params);
	}
	
	@Override
	public void addAnyDiabeteManager(List<Object> idList) {
		String a = ",";
		String str = TypeConverter.convertList2String(idList, a);
		System.out.println(str);
		String hql = "update from TChronicDisease cd set cd.status=1 where cd.chronicDiseaseId in (" + str + ")";
		chronicdao.update(hql);
	}
	@Override
	public void addAnyHighManager(List<Object> idList) {
		String a = ",";
		String str = TypeConverter.convertList2String(idList, a);
		System.out.println(str);
		String hql = "update from TChronicDisease cd set cd.status=2 where cd.chronicDiseaseId in (" + str + ")";
		chronicdao.update(hql);
	}
	@Override
	public void addAnyOtherManager(List<Object> oldids) {
		String a = ",";
		String str = TypeConverter.convertList2String(oldids, a);
		System.out.println(str);
		String hql = "update from TChronicDisease cd set cd.status=3 where cd.chronicDiseaseId in (" + str + ")";
		chronicdao.update(hql);
	} 

	@Override
	public List<VChronic> getChronicManager(int sqid, int zt, int status) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("sqid", sqid);
		params.put("zt", zt+"");
		params.put("status", status);
		String hql = "from VChronic vc where vc.communityHospitalId =:sqid and vc.healthFileType =:zt and vc.status =:status";
		hql+=" order by vc.fileNum desc";
		return vchronicDao.find(hql,params);
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public List<VChronic> getAllPeopleForSupper(int zt , Page<VChronic> page) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("zt", zt+"");
		String hql = "from VChronic vc where vc.healthFileType = :zt and vc.status != 9 order by vc.fileNum desc";//9为删除的状态量，下同
		return vchronicDao.find(hql , params , page.getCurrentPage() , page.getPageSize());
	}
	
	@Override
	public List<VChronic> getInformationForSupper(int zt) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("zt", zt+"");
		String hql = "from VChronic vc where vc.healthFileType = :zt and vc.status != 9 order by vc.fileNum desc";//9为删除的状态量，下同
		return vchronicDao.find(hql,params);
	}
	
	@Override
	public List<VChronic> getSomePeopleForDoctor(int zt, int zrid , int sqid , Page<VChronic> page) {
		// TODO Auto-generated method stub
		//String hql = "from VChronic vc where vc.healthFileType = " + zt +" and vc.staffId = " + zrid + " and vc.communityHospitalId = " + sqid + " order by vc.chronicDiseaseId desc";
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("zt", zt+"");//将状态转成String类型
		params.put("zrid", zrid);
		params.put("sqid", sqid);
		String hql = "from VChronic vc where vc.healthFileType = :zt and vc.staffId = :zrid and vc.communityHospitalId = :sqid and vc.status!=9 order by vc.fileNum desc";
		return vchronicDao.find(hql , params , page.getCurrentPage() , page.getPageSize());
	}

	@Override
	public List<VChronic> getAllPeopleForGroup(int gid, int zt,
			Page<VChronic> page) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("gid", gid);
		params.put("zt", zt+"");
		String hql = "from VChronic vc where vc.healthFileType =:zt and vc.GId =:gid and vc.status != 9 order by vc.fileNum desc";
		return vchronicDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	
	@Override
	public long getAllPeopleNumForGroup(int gid, int zt) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("gid", gid);
		params.put("zt", zt+"");
		String hql = "select count (vc.chronicDiseaseId) from VChronic vc where vc.healthFileType =:zt and vc.GId =:gid and vc.status != 9";
		return vchronicDao.count(hql,params);
	}
	
	@Override
	public List<VChronic> getAllPeopleForGroup(int gid) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("gid", gid);
		String hql = "from VChronic vc where vc.GId =:gid and vc.status != 9";
		return vchronicDao.find(hql);
	}
	
	@Override
	public List<VChronic> getSomeInformationsForDoctor(int zrid,
			int sqid) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("zrid", zrid);
		params.put("sqid", sqid);
		String hql = "from VChronic vc where vc.staffId = :zrid and vc.communityHospitalId = :sqid and vc.status!=9 order by vc.fileNum desc";
		return vchronicDao.find(hql , params);
	}
	
	@Override
	public long getAllPeopleCountForSupper(int zt) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("zt", zt+"");
		String hql = "select count (vc.chronicDiseaseId) from VChronic vc where vc.healthFileType = :zt and vc.status != 9"; 
		return vchronicDao.count(hql , params);
	}

	@Override
	public long getSomePeopleCountForDoctor(int zt, int zrid, int sqid) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("zt", zt+"");//将状态转成String类型
		params.put("zrid", zrid);
		params.put("sqid", sqid);
		String hql = "select count (vc.chronicDiseaseId) from VChronic vc where vc.healthFileType = :zt  and vc.staffId = :zrid and vc.communityHospitalId = :sqid and vc.status != 9";
		return vchronicDao.count(hql,params);
	}

	//------------------------------最新添加-----------------------------朱德江
	@Override
	public long getGroupCountChronicManager(Integer gId, int zt, int status) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("gId", gId);
		params.put("zt", zt+"");
		params.put("status", status);
		String hql="select count(vc.chronicDiseaseId) from VChronic vc where vc.healthFileType =:zt and vc.GId =:gId and vc.status=:status";
		return vchronicDao.count(hql,params);
	}

	@Override
	public List<VChronic> getGroupChronicManager(Integer gId, int zt,
			int status, Page<VChronic> page) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("gId", gId);
		params.put("zt", zt+"");
		params.put("status", status);
		String hql="from VChronic vc where vc.healthFileType =:zt and vc.GId =:gId and vc.status =:status";
		List<VChronic> list= vchronicDao.find(hql, params, page.getCurrentPage(),page.getPageSize());
		return list;
	}

	


	

	

	

	

	

	

	

	
	


}