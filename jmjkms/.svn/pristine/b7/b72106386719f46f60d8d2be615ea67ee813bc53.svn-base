package com.jmjk.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.taglibs.standard.lang.jstl.Literal;
import org.hibernate.engine.query.spi.ReturnMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.druid.sql.dialect.oracle.ast.stmt.OracleIfStatement.Else;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.itextpdf.text.log.SysoCounter;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jmjk.dao.HealthFileDao;
import com.jmjk.dao.OldStaffHosDao;
import com.jmjk.dao.StaffDao;
import com.jmjk.dao.VChronicDao;
import com.jmjk.dao.VHealthStaffDao;
import com.jmjk.dao.VOldStaffDao;
import com.jmjk.dao.VStaffHosDao;
import com.jmjk.dao.VStaffHosSuDao;
import com.jmjk.entity.TFileLifeStyle;
import com.jmjk.entity.TFileMedicalRecord;
import com.jmjk.entity.THealthFile;
import com.jmjk.entity.TMedicalPayMethod;
import com.jmjk.entity.TOldStaffHos;
import com.jmjk.entity.TPastHistory;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.view.VChronic;
import com.jmjk.entity.view.VHealthStaff;
import com.jmjk.entity.view.VOldStaff;
import com.jmjk.entity.view.VStaffHos;
import com.jmjk.entity.view.VStaffHosSu;
import com.jmjk.enums.HealthFileCheck;
import com.jmjk.enums.OperatorState;
import com.jmjk.iservice.IHealthFileService;
import com.jmjk.pojo.HealthFileCloud;
import com.jmjk.pojo.Ids.healthFileId;
import com.jmjk.utils.HttpRequest;
import com.jmjk.utils.ListToJson;
import com.jmjk.utils.MyHttpClient;
import com.jmjk.utils.Page;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.SearchBeanSU;
import com.jmjk.utils.TypeConverter;
import com.jmjk.utils.WebXMLParameter;
import com.sun.org.apache.xpath.internal.operations.And;
@Controller("healthFileService")
public class HealthFileService  implements IHealthFileService{
	@Autowired
	private HealthFileDao healthFileDao;
	@Autowired
	private OldStaffHosDao oldStaffHosDao;
	@Autowired
	private VOldStaffDao voldStaffDao;
	@Autowired
	private VStaffHosDao vStaffHosDao;
	@Autowired
	private VStaffHosSuDao vstaffHosSuDao;
	@Autowired
	private VChronicDao vchronicDao;
	@Autowired
	private VHealthStaffDao vhealthStaffDao;
	@Autowired
	private StaffDao staffDao;	
	public String vc="THealthFile";
	public String vs="VHealthStaff";
	
	@Override
	public void saveHealthFile(THealthFile healthfile) {
		healthFileDao.Save(healthfile);
		
	}

	@Override
	public void deleteHealthFile(int hFileid) {
		String hql="update THealthFile tf set tf.healthFileType=3 where tf.healthFileId="+hFileid;
		healthFileDao.update(hql);
		
	}

	@Override
	public void killHealthFile(int hFileid) {
		String hql="update THealthFile tf set tf.healthFileType=1 where tf.healthFileId="+hFileid;
		healthFileDao.update(hql);
		
	}
	@Override
	public void cancelHealthFile(int hFileid) {
		String hql="update THealthFile tf set tf.healthFileType=0 where tf.healthFileId="+hFileid;
		healthFileDao.update(hql);
	}
	@Override
	public void deleteHealthyFile(List<Object> deleteList) {
		String str=TypeConverter.convertList2String(deleteList,",");
		String hql="update THealthFile tf set tf.healthFileType=1 where tf.healthFileId in ("+str+")";
		healthFileDao.update(hql);
		
	}

	@Override
	public void killHealthyFile(List<Object> killList) {
		String str=TypeConverter.convertList2String(killList,",");
		String hql="update THealthFile tf set tf.healthFileType=0 where tf.healthFileId in ("+str+")";
		healthFileDao.update(hql);
		
	}

	@Override
	public void updateHealthFile(THealthFile healthfile) {
		healthFileDao.update(healthfile);
		
	}

	@Override
	public int getAutoId() {
		// TODO Auto-generated method stub
		String sql = "SELECT auto_increment FROM information_schema.`TABLES` WHERE table_name = 'T_HEALTH_FILE' and TABLE_SCHEMA='jmjk'";
		return healthFileDao.getPrefetching(sql)+1;
	}
	@Override
	public int getAutoIdBySaveHealthFile(THealthFile healthfile) {
		String sql = "SELECT auto_increment FROM information_schema.`TABLES` WHERE table_name = 'T_HEALTH_FILE' and TABLE_SCHEMA='jmjk'";
		this.saveHealthFile(healthfile);
		return healthFileDao.getPrefetching(sql);
	}

	@Override
	public int gethFileidByfileNum(String fileNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public THealthFile getHealthFileByFileNum(String fileNum) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("fileNum", fileNum);
		String hql="from THealthFile tf where tf.fileNum like :fileNum ";
		return healthFileDao.Get(hql,params);
	}
	@Override
	public THealthFile getHealthFileByFileNum(String fileNum, String hosName) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("fileNum", fileNum);
		params.put("hosName", hosName);
		String hql="from THealthFile tf where tf.fileNum like :fileNum and tf.hospital like :hosName";
		return healthFileDao.Get(hql,params);
	}

	@Override
	public THealthFile getHealthFileById(int hFileid) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("hFileid", hFileid);
		String hql="from THealthFile tf where tf.healthFileId =:hFileid";
		THealthFile t = healthFileDao.Get(hql,params);
		return t;
	}
	@Override
	public THealthFile getHealthFileByIdNum(String idNum) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("idNum", idNum);
		String hql="from THealthFile tf where tf.idNum like :idNum";
		return healthFileDao.Get(hql,params);
	}
	@Override
	public THealthFile getHealthFileByIphone(String iphone) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("iphone", iphone);
		String hql="from THealthFile tf where tf.IPhone =:iphone";
		return healthFileDao.Get(hql,params);
	}
	@Override
	public THealthFile getHealthFileByIdNum(String idNum, String hosName) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("idNum", idNum);
		params.put("hosName", hosName);
		String hql="from THealthFile tf where tf.idNum like :idNum and tf.hospital like :hosName";
		return healthFileDao.Get(hql,params);
	}
	@Override
	public THealthFile getHealthFileById(int hFileid, String hosName) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public long getHealthFileCountForSpecial(int staffId,int state) {
		String hql="select count(th.healthFileId) from THealthFile th where th.healthFileId in (select tf.THealthFile.healthFileId from TOldStaffHos tf where tf.TStaff.staffId="+staffId+")"+"and th.healthFileType ="+state+"";

/*		String hql="select count(tp.oldStaffHosId) from TOldStaffHos tp where tp.TStaff.staffId="+staffId;
	return oldStaffHosDao.count(hql);*/
		return healthFileDao.count(hql);
	}
	@Override
	public long getHealthFileCountForGroup(int groupId){
		String hql="select count(tp.healthFileId) from VHealthStaff tp where tp.GId ="+ groupId +"and tp.healthFileType =2";
		return vStaffHosDao.count(hql);
	}
	@Override
	public long getHealthFileCount() {
		String hql="select count(tp.healthFileId) from THealthFile tp where tp.healthFileType =2 ";
		return healthFileDao.count(hql);
	}
	@Override
	public long getHealthFileCount(String hosName) {
		String hql="select count(tp.healthFileId) from THealthFile tp where tp.hospital='"+hosName+"'"+" and tp.healthFileType =2";
		return healthFileDao.count(hql);
	}

	@Override
	public List<THealthFile> getAllHealthFile(Page<THealthFile> page,
			int state, String hosName) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("state", state+"");
		params.put("hosName", hosName);
		String hql="from THealthFile tf where tf.healthFileType like :state and tf.hospital like :hosName and tf.fileNum<>'00000000000000000000' and tf.healthFileId in (select th.THealthFile.healthFileId from TOldStaffHos th) order by tf.fileNum desc";
		List<THealthFile> healthFileList = this.healthFileDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
		return healthFileList;
	}
	@Override
	public List<VHealthStaff> getAllHealthFileForGroup(Page<THealthFile> page,int groupId,int state){
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("state", state+"");
		params.put("groupId", groupId+"");
		String hql="from VHealthStaff tf where tf.healthFileType =:state"+" and tf.GId = :groupId order by tf.fileNum desc";
		List<VHealthStaff> vhealthStaffList = this.vhealthStaffDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
		return vhealthStaffList;
	}
	
	@Override
	public List<THealthFile> getHealthFileListByStaffIdForSpeciall(Page<THealthFile> page,int state,int staffId) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("state", state+"");
		params.put("staffId", staffId);
		String hql="from THealthFile th where th.healthFileId in (select tf.THealthFile.healthFileId from TOldStaffHos tf where tf.TStaff.staffId=:staffId ) and th.healthFileType =:state and th.fileNum<>'00000000000000000000'  order by th.fileNum desc";
		return healthFileDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
	}
	@Override
	public List<TStaff> getSpeciallDoctor(int hosId){
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("hosId", hosId);
		params.put("operateState", OperatorState.qiyong.getvalue());
		String hql="from TStaff th where th.staffId in (select tf.TStaff.staffId from TOldStaffHos tf where   tf.TCommunityHospital.communityHospitalId=:hosId) and th.operateState = :operateState and th.isSpecialDoctor = true order by th.name ";
		return staffDao.find(hql,params);
	}
	public List<TStaff> getStaffs(int hosId){
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("hosId", hosId);
		params.put("operateState", OperatorState.qiyong.getvalue());
		String hql="from TStaff th where th.staffId in (select tf.TStaff.staffId from TOldStaffHos tf where   tf.TCommunityHospital.communityHospitalId=:hosId) and th.operateState = :operateState and th.loginName <> null  order by th.name ";
		return staffDao.find(hql,params);
	}
	@Override
	public String getFileNum(int healthFileId) {
		String sql="select FILE_NUM ("+healthFileId+")";
		return healthFileDao.getFileNum(sql);
		
	}
	
	@Override
	public boolean editHealthFileToCloulds(THealthFile healthFile,List<TPastHistory> pastHistoryList,List<TMedicalPayMethod> medicalPayMethodList,List<TFileLifeStyle> tlifestyleList,List<TFileMedicalRecord>  fileMedicalRecordList,int docId){
		String url = WebXMLParameter.getParamValue("ip_port")+"/healthy/healthFile/editData";
		Map<String , String> params = new HashMap<String, String>();
		String json;
		String strPastHistory="";
		String strPayMethod="";
		String strPayEnd="";
		String strPastEnd="";
		String strLifestyle="";
		String strLife="";
		String strLifeEnd="";
		String strMedicalRecordEnd="";
		int i;
		int id=healthFile.getHealthFileId();
		try {
			Gson gson = new Gson();  
			//健康档案转化为json串
			String str = gson.toJson(healthFile);  
			//生活方式转化为json串
			if(tlifestyleList.size()!=0&&tlifestyleList!=null){
				for(i=0;i<tlifestyleList.size();i++){
					String strFileS=gson.toJson(tlifestyleList.get(i));
					strFileS=strFileS.substring(strFileS.indexOf(",")+1);
					strFileS="{"+strFileS;
					strLife=strLife+","+strFileS;
				}
				strLifestyle=strLife.substring(1);
				strLifeEnd="&fileLifeStyle=["+strLifestyle+"]";
			}
			//用药记录转化为json串
			if(fileMedicalRecordList.size()!=0&&fileMedicalRecordList!=null){
				strLife="";
				strLifestyle="";
				for(i=0;i<fileMedicalRecordList.size();i++){
					String strMedicalRecord=gson.toJson(fileMedicalRecordList.get(i));
					if(strMedicalRecord!=null&&!strMedicalRecord.equals("")){
						strMedicalRecord=strMedicalRecord.substring(strMedicalRecord.indexOf(",")+1);
						strMedicalRecord="{"+strMedicalRecord;
					}
					strLife=strLife+","+strMedicalRecord;
				}
				strLifestyle=strLife.substring(1);
				strMedicalRecordEnd="&fileMedicalRecord=["+strLifestyle+"]";
			}
			//既往史转化为json串
			if(pastHistoryList.size()!=0&&pastHistoryList!=null){
				for(i=0;i<pastHistoryList.size();i++){
					String strPast=gson.toJson(pastHistoryList.get(i));
					strPast=strPast.substring(strPast.indexOf(",")+1);
					strPast="{"+strPast;
					strPastHistory=strPastHistory+","+strPast;
				}
				strPastHistory=strPastHistory.substring(1);
				strPastEnd="&filePastHistory=["+strPastHistory+"]";
			}
			//付费方式转化为json串
			if(medicalPayMethodList.size()!=0&&medicalPayMethodList!=null){
				for(i=0;i<medicalPayMethodList.size();i++){
					String strPay=gson.toJson(medicalPayMethodList.get(i));
					if(strPay!=null&&!strPay.equals("")){
						strPay=strPay.substring(strPay.indexOf(",")+1);
						strPay="{"+strPay;
					}
					strPayMethod=strPayMethod+","+strPay;
				}
				strPayMethod=strPayMethod.substring(1);
				strPayEnd="&medicalPayMethod=["+strPayMethod+"]";
			}
			str="healthFile="+str+"&docId="+docId+strPastEnd+strPayEnd+strLifeEnd+strMedicalRecordEnd;
			System.out.println(str);
			String sr=HttpRequest.sendPost(url, str);
			System.out.println(sr);
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap =JSON.parseObject(sr);
			if(((String) resultMap.get("message")).equals("数据修改成功！")){
				return true;
			}
			else 
				return false;
 		} catch (Exception e1) {
			e1.printStackTrace();
		}
		//调用封装好的httpclient 请求方法,并返回json数据串
   
    	/*Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//将json串转化成map
			resultMap =JSON.parseObject(sr);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		//返回结果信息
		//return (String) resultMap.get("message");
		return false ;
	}
	@Override
	public String getHealthFileCloudForManySpecial(SearchBeanSU searchbean ,int docId,int currentPage,int pageSize){
		String url =  WebXMLParameter.getParamValue("ip_port")+"/healthy/healthFile/findDataByDocId";
		Map<String , String> params = new HashMap<String, String>();
		params.put("docId", docId+"");
		params.put("currentPage", currentPage+"");
		params.put("pageSize", pageSize+"");
		if(searchbean.getSex()==1||searchbean.getSex()==0){//0男1女，除此之外默认是全部
			params.put("sex", searchbean.getSex()+"");
		}
		params.put("healthFileType", searchbean.getDanganzhuangtai()+"");
		if(searchbean.getSelectValue()!=null&&!searchbean.getSelectValue().equals("")){
			if(searchbean.getSelectFlag() ==1){//根据姓名查找
				params.put("name", searchbean.getSelectValue());
			}
			if(searchbean.getSelectFlag() ==2){//根据身份证号查找
				params.put("idNum", searchbean.getSelectValue());
			}
			if(searchbean.getSelectFlag() ==3){//根据档案编号查找
				params.put("fileNum", searchbean.getSelectValue());
			}
		}
		if(searchbean.getLowAge()>0) params.put("ageStart", searchbean.getLowAge()+"");
		if(searchbean.getHighAge()>0) params.put("ageEnd", searchbean.getHighAge()+"");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //date类型转化为String 
		if(searchbean.getLowFileDate()!=null) {
			String strFileDateStart=sdf.format(searchbean.getLowFileDate());
			params.put("fileDateStart", strFileDateStart);
		}
		if(searchbean.getHighFileDate()!=null) {
			String strFileDateEnd=sdf.format(searchbean.getHighFileDate());
			params.put("fileDateEnd", strFileDateEnd);
		}
		String resultJson = MyHttpClient.sendHttpPost(url, params);
		System.out.println(resultJson);
		return resultJson;
	}
	@Override
	public String getHealthFileCloudForMany(SearchBeanSU searchbean ,int hosId,int currentPage,int pageSize){
		String url =  WebXMLParameter.getParamValue("ip_port")+"/healthy/healthFile/findDataByHosId";
		Map<String , String> params = new HashMap<String, String>();
		params.put("hosId", hosId+"");
		params.put("currentPage", currentPage+"");
		params.put("pageSize", pageSize+"");
		if(searchbean.getSex()==1||searchbean.getSex()==0){//0男1女，除此之外默认是全部
			params.put("sex", searchbean.getSex()+"");
		}
		params.put("healthFileType", searchbean.getDanganzhuangtai()+"");
		if(searchbean.getSelectValue()!=null&&!searchbean.getSelectValue().equals("")){
			if(searchbean.getSelectFlag() ==1){//根据姓名查找
				params.put("name", searchbean.getSelectValue());
			}
			if(searchbean.getSelectFlag() ==2){//根据身份证号查找
				params.put("idNum", searchbean.getSelectValue());
			}
			if(searchbean.getSelectFlag() ==3){//根据档案编号查找
				params.put("fileNum", searchbean.getSelectValue());
			}
		}
		if(searchbean.getLowAge()>0) params.put("ageStart", searchbean.getLowAge()+"");
		if(searchbean.getHighAge()>0) params.put("ageEnd", searchbean.getHighAge()+"");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd"); //date类型转化为String 
		if(searchbean.getLowFileDate()!=null) {
			String strFileDateStart=sdf.format(searchbean.getLowFileDate());
			params.put("fileDateStart", strFileDateStart);
		}
		if(searchbean.getHighFileDate()!=null) {
			String strFileDateEnd=sdf.format(searchbean.getHighFileDate());
			params.put("fileDateEnd", strFileDateEnd);
		}
		if(searchbean.getEnterPeople()!=null&&!searchbean.getEnterPeople().equals("")) {//录入人
			params.put("enterPeople", searchbean.getEnterPeople()+"");
		}
		if(searchbean.getFilePeople()!=null&&!searchbean.getFilePeople().equals("")) {//建档人
			System.out.println("ss"+searchbean.getFilePeople()+"ss");
			params.put("filePerson", searchbean.getFilePeople()+"");
		}
		if(searchbean.getStaffId()>0) {//责任医生id
			params.put("doctorId", searchbean.getStaffId()+"");
		}
		String resultJson = MyHttpClient.sendHttpPost(url, params);
		System.out.println(resultJson);
		return resultJson;
	}
	@Override
	public String getHealthFileCloudForDetail(int id){
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/healthFile/getSingle";
		Map<String , String> params = new HashMap<String, String>();
		params.put("id", id+"");
		String resultJson = MyHttpClient.sendHttpPost(url, params);
		System.out.println(resultJson);
		return resultJson;
	}
	@Override
	public boolean deleteHealthFileToCloulds(int healthFileId,int type){
		String url = WebXMLParameter.getParamValue("ip_port")+"/healthy/healthFile/deleteData";
		//String appkey=WebXMLParameter.getParamByappkey("appkey1");
		Map<String , String> params = new HashMap<String, String>();
		//params.put("appKey", appkey);
		params.put("id", healthFileId+"");
		params.put("type", type+"");
		//调用封装好的httpclient 请求方法,并返回json数据串
    	String resultJson = MyHttpClient.sendHttpPost(url, params);
    	System.out.println(resultJson);
    	Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//将json串转化成map
			resultMap =JSON.parseObject(resultJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回结果信息
		System.out.println((String) resultMap.get("message")); 
		return true;
	}
	@Override
	public boolean addHealthFileToCloulds(THealthFile healthFile,List<TPastHistory> pastHistoryList,List<TMedicalPayMethod> medicalPayMethodList,List<TFileLifeStyle> tlifestyleList,List<TFileMedicalRecord> fileMedicalRecordList,int docId){
		String url =WebXMLParameter.getParamValue("ip_port")+"/healthy/healthFile/addData";
		Map<String , String> params = new HashMap<String, String>();
		String json;
		String strPastHistory="";
		String strPayMethod="";
		String strPayEnd="";
		String strPastEnd="";
		String strFileStyle="";
		
		String strLifestyle="";
		String strLife="";
		String strLifeEnd="";
		
		String strMedicalRecordEnd="";
		int i;
		int id=healthFile.getHealthFileId();
		try {
			Gson gson = new Gson();  
			//健康档案转化为json串
			String str = gson.toJson(healthFile);  
			//生活方式转化为json串
			//strFileStyle="&filePastHistory=["+gson.toJson(tlifestyle)+"]";
			if(tlifestyleList.size()!=0&&tlifestyleList!=null){
				for(i=0;i<tlifestyleList.size();i++){
					String strFileS=gson.toJson(tlifestyleList.get(i));
					strFileS=strFileS.substring(strFileS.indexOf(",")+1);
					strFileS="{"+strFileS;
					strLife=strLife+","+strFileS;
				}
				strLifestyle=strLife.substring(1);
				strLifeEnd="&fileLifeStyle=["+strLifestyle+"]";
			}
			//用药记录转化为json串
			if(fileMedicalRecordList.size()!=0&&fileMedicalRecordList!=null){
				strLife="";
				strLifestyle="";
				for(i=0;i<fileMedicalRecordList.size();i++){
					String strMedicalRecord=gson.toJson(fileMedicalRecordList.get(i));
					if(strMedicalRecord!=null&&!strMedicalRecord.equals("")){
						strMedicalRecord=strMedicalRecord.substring(strMedicalRecord.indexOf(",")+1);
						strMedicalRecord="{"+strMedicalRecord;
					}
					strLife=strLife+","+strMedicalRecord;
				}
				strLifestyle=strLife.substring(1);
				strMedicalRecordEnd="&fileMedicalRecord=["+strLifestyle+"]";
			}
			//既往史转化为json串
			if(pastHistoryList.size()!=0&&pastHistoryList!=null){
				for(i=0;i<pastHistoryList.size();i++){
					String strPast=gson.toJson(pastHistoryList.get(i));
					strPast=strPast.substring(strPast.indexOf(",")+1);
					strPast="{"+strPast;
					strPastHistory=strPastHistory+","+strPast;
				}
				strPastHistory=strPastHistory.substring(1);
				strPastEnd="&filePastHistory=["+strPastHistory+"]";
			}
			//付费方式转化为json串
			if(medicalPayMethodList.size()!=0&&medicalPayMethodList!=null){
				for(i=0;i<medicalPayMethodList.size();i++){
					String strPay=gson.toJson(medicalPayMethodList.get(i));
					if(strPay!=null&&!strPay.equals("")){
						strPay=strPay.substring(strPay.indexOf(",")+1);
						strPay="{"+strPay;
					}
					strPayMethod=strPayMethod+","+strPay;
				}
				strPayMethod=strPayMethod.substring(1);
				strPayEnd="&medicalPayMethod=["+strPayMethod+"]";
			}
			/*List<String> fieldList=new ArrayList<String>();
			fieldList.add("id" );fieldList.add("age" ); fieldList.add("allergyName"); fieldList.add("healthFileId" ); fieldList.add("birthDate" ); fieldList.add("bloodTypr"); fieldList.add("borSisDisease" ); fieldList.add("childDisease"); fieldList.add("country"); fieldList.add("crowdClass"); fieldList.add("currentCity"); fieldList.add("currentCommunity"); fieldList.add("currentCounty"); fieldList.add("currentOffice"); fieldList.add("currentProvince"); fieldList.add("currentResidentCommittee"); fieldList.add("diastolicBloodPressure"); fieldList.add("disabilitity" ); fieldList.add("disabilityName" ); fieldList.add("drinkWater"); fieldList.add("eduLevel" ); fieldList.add("email" ); fieldList.add("enterPeople" ); fieldList.add("exposeName" ); fieldList.add("exposeNote");fieldList.add("fatherDisease" ); fieldList.add("fileDate");fieldList.add("fileNum");fieldList.add("filePerson");fieldList.add("five" );fieldList.add("four" ); fieldList.add("fuelType");fieldList.add("geneticHistory");fieldList.add("healthFileType" ); fieldList.add("height");fieldList.add("hipline" ); fieldList.add("hospital" ); fieldList.add("iPhone");fieldList.add("idNum" ); fieldList.add("job" ); fieldList.add("kitVenFac");fieldList.add("livestockBar");fieldList.add("maritalStatus" ); fieldList.add("motherDisease" ); fieldList.add("name");fieldList.add("nation" ); fieldList.add("nfc");fieldList.add("one" ); fieldList.add("otherAddressType" ); fieldList.add("otherCity");fieldList.add("otherCommunity");fieldList.add("otherCounty" ); fieldList.add("otherDisease" ); fieldList.add("otherName");fieldList.add("otherPhone");fieldList.add("otherProvince");fieldList.add("permanentType" ); fieldList.add("pic");fieldList.add("rhNegative");fieldList.add("sex" ); fieldList.add("systolicBloodPressure");fieldList.add("three" ); fieldList.add("toilet");fieldList.add("two" ); fieldList.add("waistline");fieldList.add("weihth" ); fieldList.add("work");fieldList.add("workUnit");
			String str=new ListToJson<THealthFile>().entityToJson(healthFile, fieldList);*/
			str="healthFile="+str+"&docId="+docId+strPastEnd+strPayEnd+strLifeEnd+strMedicalRecordEnd;
			System.out.println(str);
			String sr=HttpRequest.sendPost(url, str);
			System.out.println(sr);
			Map<String, Object> resultMap = new HashMap<String, Object>();
			resultMap =JSON.parseObject(sr);
			if(((String) resultMap.get("message")).equals("数据修改成功！")){
				return true;
			}
			else 
				return false;
 		} catch (Exception e1) {
			e1.printStackTrace();
		}
		//调用封装好的httpclient 请求方法,并返回json数据串
   
    	/*Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//将json串转化成map
			resultMap =JSON.parseObject(sr);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		//返回结果信息
		//return (String) resultMap.get("message");
		return false ;
	}
	@Override
	public String getHealthFilesFromCloudsForSpecial(int staffId,String apppKey,int currentPage,int pageSize){
		return null;
	}
	@Override
	public String getHealthFilesFromCloudsForNormal(List<Integer> staffIds,String apppKey,int currentPage,int pageSize){
		return null;
	}
	@Override
	public HealthFileCloud getInfoFromCloudsForSpecial(){
		return null;
	}
	@Override
	public HealthFileCloud getInfoFromCloudsForNormal(){
		return null;
	}
/************************************老人与责任医生**********************************/
	@Override
	public List<VStaffHos>  getAllDoctorByHosId(){
		String hql="from VStaffHos tf where  tf.state=4 or tf.state=5 or tf.state=0 order by tf.name";
		return vStaffHosDao.find(hql);
	}
	@Override
	public List<VStaffHos> getAllDoctorByHosId(int HosId) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("HosId", HosId);
		params.put("operateState", OperatorState.shanchu.getvalue());
		String hql="from VStaffHos tf where tf.communityHospitalId =:HosId and (tf.state=4 or tf.state=5 or tf.state=0) and tf.operateState <> :operateState  order by tf.name";
		return vStaffHosDao.find(hql,params);
	}
	@Override
	public VStaffHos getVStaffHosByHeathFileId(int heathFileId) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("heathFileId", heathFileId);
		String hql="from VStaffHos tf where tf.healthFileId =:heathFileId";
		return vStaffHosDao.Get(hql,params);
	}
	@Override
	public VStaffHosSu getVStaffHosSuByHeathFileId(int heathFileId, int state) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("heathFileId", heathFileId);
		params.put("state", state+"");
		String hql="from VStaffHosSu tf where tf.healthFileId =:heathFileId and tf.healthFileType=:state";
		return vstaffHosSuDao.Get(hql,params);
	}
	@Override
	public TOldStaffHos getOldStaffHosByHosIdAndHeathFileId(int HosId,
			int healthId) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("HosId", HosId);
		params.put("healthId", healthId);
		String hql="from TOldStaffHos tf where tf.THealthFile.healthFileId=:healthId and tf.TCommunityHospital.communityHospitalId=:HosId";
		return oldStaffHosDao.Get(hql,params);
	}
	//为许乐平提供
	public List<TOldStaffHos> getOldStaffHosListByStaffId(int staffId){
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("staffId", staffId);
		String hql="from TOldStaffHos tf where tf.TStaff.staffId=:staffId and  tf.THealthFile.healthFileId <> null";
		return oldStaffHosDao.find(hql,params);
	}

	public TOldStaffHos getOldStaffHosByStaffIdAndHeathFileId(int staffId,
			int healthId) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("staffId", staffId);
		params.put("healthId", healthId);
		String hql="from TOldStaffHos tf where tf.THealthFile.healthFileId=:healthId and tf.TStaff.staffId=:staffId";
		return oldStaffHosDao.Get(hql,params);
	}
	@Override
	public void saveOldStaffHos(TOldStaffHos OldStaffHos) {
		oldStaffHosDao.Save(OldStaffHos);
		
	}

	@Override
	public void deleteOldStaffHos(int heathFileId) {
		String hql="delete from TOldStaffHos the where the.THealthFile.healthFileId = "+heathFileId;
		oldStaffHosDao.delete(hql);
	}
	//为许乐平提供
	@Override
	public void deleteOldStaffHosByStaffId(int staffId){
		String hql="delete from TOldStaffHos the where the.TStaff.staffId = "+staffId+"and the.THealthFile.healthFileId <> null";
		oldStaffHosDao.delete(hql);
	}
	@Override
	public boolean getOldStaffHosByStaffId(int staffId) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("staffId", staffId);
	//	String hql="from TOldStaffHos tf where tf.TStaff.staffId="+staffId;
		//档案编号为20个零表明为责任医生

		String hql="from TStaff tf where tf.staffId=:staffId and tf.isSpecialDoctor=1";//1是责任医生
		List<TOldStaffHos> list= oldStaffHosDao.find(hql,params);
		if(list.size()!=0){
			return true;
		}
		else {
			return false;
		}

		
	}
	@Override
	public List<VHealthStaff> getVHealthStaffByOldNameForSpecial(int staffId,String name){
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("staffId", staffId);
		params.put("name", name+"");
		String hql="from VHealthStaff tf where tf.name=:name and tf.staffId=:staffId and tf.healthFileType=2";
		return vhealthStaffDao.find(hql,params);
	}
	@Override
	public List<VHealthStaff> getVHealthStaffByOldNameForNormal(int hospitalId,String name){
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("hospitalId", hospitalId);
		params.put("name", name+"");
		String hql="from VHealthStaff tf where tf.name=:name and tf.communityHospitalId=:hospitalId and tf.healthFileType=2";
		return vhealthStaffDao.find(hql,params);
	}
	
/**************************************晓光代码**********************************/
	@Override
	public List<VOldStaff> getOldStaffByPlatAdmin(Page<VOldStaff> page) {
		String hql = "from VOldStaff vos where vos.fileNum<>'00000000000000000000' group by vos.fileNum order by vos.fileNum desc";
		List<VOldStaff> list=voldStaffDao.find(hql,page.getCurrentPage(),page.getPageSize());
		return list;
	}
	@Override
	public long countStaffByPlatAdmin() {
		String hql = "from VOldStaff vos where vos.fileNum<>'00000000000000000000' group by vos.fileNum";
		return voldStaffDao.find(hql).size();
	}
	@Override
	public List<VOldStaff> getOldStaffsListByStaff(Page<VOldStaff> page,int staffId) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		params.put("state", HealthFileCheck.zhengchang.getValue()+"");
		System.out.println(HealthFileCheck.zhengchang.getValue());
		String hql = "from VOldStaff vos where vos.staffId=:staffId and vos.healthFileType=:state";
		hql +=" group by vos.fileNum order by vos.fileNum desc";
		List<VOldStaff> vs=voldStaffDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
		for(VOldStaff a:vs){
			System.out.println(a.getStaffId());
		}
		return vs;
	}

	@Override
	public long countOldStaffByStaff(int staffId) {
		//SELECT count(*) FROM (SELECT * FROM V_OLD_STAFF  WHERE V_OLD_STAFF.STAFF_ID=90 GROUP BY FILE_NUM) V_OLD_STAFF
		//String hql ="select count(*) from (select vos.idNum from VOldStaff vos where vos.staffId='"+staffId+"' group by vos.fileNum) VOldStaff vos";   
		// hql +=" group by vos.fileNum";
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		params.put("state", HealthFileCheck.zhengchang.getValue()+"");
		String hql = "from VOldStaff vos where vos.staffId= :staffId and vos.healthFileType= :state and vos.fileNum<>'00000000000000000000'";
		hql +=" group by vos.fileNum";
		List<VOldStaff> vs=voldStaffDao.find(hql,params);
		return (long) vs.size();
	}

	@Override
	public List<THealthFile> getHealthFilesByIds(List<Integer> healthFileIds ,Page<THealthFile> page) {
		String ids = "(";
		for (Integer integer : healthFileIds) {
			ids +=integer.intValue() + ",";
		}
		ids = ids.substring(0, healthFileIds.size()-1);
		ids += ")";
		String hql = "from THealthFile tf where tf.healthFileId in "+ids;
		return healthFileDao.find(hql, page.getCurrentPage(),page.getPageSize());
	}

	@Override
	public List<VOldStaff> getOldStaffsListBycommunityAdmin(
			Page<VOldStaff> page, int communityHosiptalId) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("communityHosiptalId", communityHosiptalId);
		params.put("state", HealthFileCheck.zhengchang.getValue()+"");
		String hql = "from VOldStaff vos where vos.communityHospitalId=:communityHosiptalId and vos.healthFileType=:state and vos.fileNum<>'00000000000000000000'";//where 1=1 group by vos.flieNum";
	    	   hql +=" group by vos.fileNum order by vos.fileNum desc";
		return voldStaffDao.find(hql, params,page.getCurrentPage(), page.getPageSize());
	}

	@Override
	public long countOldStaffBycommunityAdmin(int communityHosiptalId) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("communityHosiptalId", communityHosiptalId);
		params.put("state", HealthFileCheck.zhengchang.getValue()+"");
		String hql = "from VOldStaff vos where vos.communityHospitalId= :communityHosiptalId and vos.healthFileType= :state and vos.fileNum<>'00000000000000000000'";
	 	hql +=" group by vos.fileNum";
	 	return voldStaffDao.find(hql,params).size();
	}


	/**************************************清发代码**********************************/
	@Override
	public List<VOldStaff> getOldStaffsListByGroupAdmin(int gid) {
		String hql = "from VOldStaff vos where vos.fileNum<>'00000000000000000000' and vos.GId="+gid;
		hql +=" order by vos.fileNum desc";
		return voldStaffDao.find(hql);
	}
	
	@Override
	public List<VOldStaff> getOldStaffsListByPlatAdmin() {
		String hql = "from VOldStaff vos where vos.fileNum<>'00000000000000000000'";
		hql +=" order by vos.fileNum desc";
		return voldStaffDao.find(hql);
	}
	@Override
	public List<VOldStaff> getOldStaffsListBystaffId(int staffId ){
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String hql = "from VOldStaff vos where vos.staffId= :staffId and vos.fileNum<>'00000000000000000000'";
		hql +=" order by vos.fileNum desc";
		return voldStaffDao.find(hql,params);
	
	}
	@Override
	public List<VOldStaff> getOldStaffsListBycommunityid(int communityHosiptalId){
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("communityHosiptalId", communityHosiptalId);	
		String hql = "from VOldStaff vos where vos.communityHospitalId=:communityHosiptalId and vos.fileNum<>'00000000000000000000'";
		hql +=" order by vos.fileNum desc";
		return voldStaffDao.find(hql, params);	
	}
	
	@Override
	public TOldStaffHos getOldStaffHosByHeathFileId(int healthId) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("healthId", healthId);
		String hql="from TOldStaffHos tf where tf.THealthFile.healthFileId=:healthId";
		return oldStaffHosDao.Get(hql,params);
	}
		
	/*//==========================================ZFL===================================	*/
		public TOldStaffHos getTOldStaffHosByhealthId(int healthId){
			Map<String,Object> params = new HashMap<String, Object>();
			params.put("healthId", healthId);
			String hql="from TOldStaffHos to where to.THealthFile.healthFileId= :healthId";
			 return oldStaffHosDao.Get(hql,params);
		}

		
		
	//================================================================================	
		@Override
		public long findChronicPeopleCount(SearchBeanSU se) {
			String h = se.getHql(vs);
			String hql ="select count(entity.healthFileId) " + h  ;
			return healthFileDao.count(hql);
		}

		@Override
		public List<VHealthStaff> findChronicPeople(SearchBeanSU se,
				Page<VHealthStaff> page) {
			String h = se.getHql(vs);
			String hql = h + "  order by entity.fileNum desc";//9为已删除的状态量
			List<VHealthStaff> vclist = vhealthStaffDao.find(hql , page.getCurrentPage(), page.getPageSize());
			return vclist;
		}

		@Override
		public long findChronicPeopleCount(SearchBeanSU se, int staffId) {
			String h = se.getHql(vs);
			String hql ="select count(entity.healthFileId) " + h +" and entity.healthFileId in (select tf.THealthFile.healthFileId from TOldStaffHos tf where tf.TStaff.staffId="+staffId+")"  ;
			return healthFileDao.count(hql);
		}

		@Override
		public long findChronicPeopleCount(SearchBeanSU se, String hosName) {
			String h = se.getHql(vs);
			String hql ="select count(entity.healthFileId) " + h +" and entity.hospital='"+hosName+"'" ;
			return healthFileDao.count(hql);
		}
		@Override
		public List<VHealthStaff> findChronicPeople(SearchBeanSU se,
				Page<VHealthStaff> page, String hosName) {
			Map<String, Object> params=new HashMap<String, Object>();
			params.put("hosName", hosName);
			String h = se.getHql(vs);
			String hql = h + " and  entity.hospital like :hosName order by entity.fileNum desc";//9为已删除的状态量
			List<VHealthStaff> vclist = vhealthStaffDao.find(hql , params,page.getCurrentPage(), page.getPageSize());
			return vclist;
		}
		@Override
		public List<VHealthStaff> findChronicPeople(SearchBeanSU se,
				Page<VHealthStaff> page, int staffId) {
			Map<String, Object> params=new HashMap<String, Object>();
			params.put("staffId", staffId);
			String h = se.getHql(vs);
			String hql = h + " and entity.healthFileId in (select tf.THealthFile.healthFileId from TOldStaffHos tf where tf.TStaff.staffId=:staffId ) order by entity.fileNum desc";//9为已删除的状态量
			List<VHealthStaff> vclist = vhealthStaffDao.find(hql ,params, page.getCurrentPage(), page.getPageSize());
			return vclist;
		}
		@Override
		public List<VHealthStaff> findChronicPeopleForGroup(SearchBeanSU se, Page<VHealthStaff> page, int groupId) {
			Map<String, Object> params=new HashMap<String, Object>();
			params.put("groupId", groupId);
			String h = se.getHql(vs);
			String hql = h + " and  entity.GId like :groupId order by entity.fileNum desc";//9为已删除的状态量
			List<VHealthStaff> vclist = vhealthStaffDao.find(hql , params,page.getCurrentPage(), page.getPageSize());
			return vclist;
		}

		@Override
		public List<VHealthStaff> findOldPeopleForGroup(int groupId) {
			Map<String, Object> params=new HashMap<String, Object>();
			params.put("groupId", groupId+"");
			String hql="from VHealthStaff tf where tf.GId =:groupId"+" order by tf.fileNum desc";
			List<VHealthStaff> vhealthStaffList = this.vhealthStaffDao.find(hql,params);
			return vhealthStaffList;
		}

		

	//查询的所有档案
	/*public List<THealthFile> getHealthFileBySearchDate(Date startDate, Date endDate){
		String hql = "from THealthFile th where DATE_FORMAT(th.fileDate,'%Y-%m-%d') >= '"+startDate+"' and DATE_FORMAT(th.fileDate,'%Y-%m-%d')<= '"+endDate+"'";
		Map< String, Object> params = new HashMap<String, Object>();
		//params.put("startDate", startDate);
		//params.put("endDate", endDate);
		List<THealthFile> healthFileList =healthFileDao.find(hql);
		return healthFileList;
	} 
	*/

	@Override
	public List<THealthFile> getAllHealthFile(int state, String hosName) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("state", state+"");
		params.put("hosName", hosName);
		String hql="from THealthFile tf where tf.healthFileType like :state and tf.hospital like :hosName order by tf.fileNum desc";
		List<THealthFile> healthFileList = this.healthFileDao.find(hql,params);
		return healthFileList;
	}

	@Override
	public List<THealthFile> getAllHealthFile(int state) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("state", state+"");
		String hql="from THealthFile tf where tf.healthFileType =:state"+" order by tf.fileNum desc";
		List<THealthFile> healthFileList = this.healthFileDao.find(hql,params);
		return healthFileList;
	}

	@Override
	public List<THealthFile> getHealthFileListByStaffIdForSpeciall(int state,
			int staffId) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("state", state+"");
		params.put("staffId", staffId);
		String hql="from THealthFile th where th.healthFileId in (select tf.THealthFile.healthFileId from TOldStaffHos tf where tf.TStaff.staffId=:staffId ) and th.healthFileType =:state order by th.fileNum desc";
		return healthFileDao.find(hql,params);
	} 

	@Override
	public VOldStaff  getHealthFileByIdCard(String idCard){
		
		String hql = "from VOldStaff vos where vos.idNum = :idCard";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("idCard", idCard);
		VOldStaff vOldStaffs;
		
		try {
			vOldStaffs = voldStaffDao.Get(hql,params);
			return vOldStaffs;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public VOldStaff getOldStaffByhealthId(int healthFileId) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("healthFileId", healthFileId);
		String hql = "from VOldStaff vos where vos.healthFileId = :healthFileId";
		return voldStaffDao.Get(hql, params);
	}

	@Override
	public List<VHealthStaff> getAllHealthFileByHospitalId(int hosId) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("hosId", hosId);
		String hql="from VHealthStaff tf where tf.healthFileType =2 and tf.communityHospitalId = :hosId order by tf.fileDate desc";
		List<VHealthStaff> vhealthStaffList = this.vhealthStaffDao.find(hql,params);
		return vhealthStaffList;
	}
	
	//----------------------最新添加--------------------------------朱德江
	@Override
	public List<THealthFile> getGroupAllOldsByGId(int gId) {
		// TODO Auto-generated method stub
		String hql="from VHealthStaff vhs where vhs.GId="+gId;
		return healthFileDao.find(hql);
	}
	@Override
	public boolean isGroupOld(int healthFileId,int gId){
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("healthFileId", healthFileId);
		params.put("gId", gId);
		String hql="from VHealthStaff vhs where vhs.healthFileId =:healthFileId and vhs.GId =:gId";
		VHealthStaff vhs=vhealthStaffDao.Get(hql,params);
		if(vhs!=null){
			return true;
		}
		else {
			return false;
		}
	}
	
	
	//----------------------↓最新添加↓--------------------------------李卓远
	
	
	@Override
	public VHealthStaff getGroup(int hid) {
		// TODO Auto-generated method stub
		String hql = "from VHealthStaff vhs where vhs.healthFileId= "+hid;
		return vhealthStaffDao.Get(hql);
	}
	
	
	
	
	//----------------------↑最新添加↑------------------------------------李卓远
	
	
////////////////////////用于导入健康档案，添加默认员工//////////////////////////////////////
	/**
	 *（导入健康档案专用）把员工和关系实体分别添加
	 * @param staff
	 * @param oldStaffHos
	 */
	public void addStaffDefault(TStaff staff,TOldStaffHos oldStaffHos){
		staffDao.Save(staff);
		oldStaffHosDao.Save(oldStaffHos);
	}
	/**
	 * （导入健康档案专用）如果在该医院里没有员工Id为0的员工，则返回true，有，则返回false
	 * @param hosId
	 * @return
	 */
	public boolean checkStaff0(int hosId){
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("hosId", hosId);
		String hql="from TOldStaffHos tf where tf.TStaff.staffNumber ='0' and tf.TCommunityHospital.communityHospitalId = :hosId ";
		List<TOldStaffHos> oldStaffHosList = this.oldStaffHosDao.find(hql,params);
		if(oldStaffHosList.size()!=0){
			return false;
		}
		else {
			return true;
		}
		
	}
	/**
	 * （导入健康档案专用）返回该医院员工编号为0的TOldStaffHos实体
	 * @param hosId
	 * @return
	 */
	
	public TOldStaffHos getOldStaffHos0(int hosId){
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("hosId", hosId);
		String hql="from TOldStaffHos tf where tf.TStaff.staffNumber ='0' and tf.TCommunityHospital.communityHospitalId = :hosId and tf.THealthFile.healthFileId=null";
		return oldStaffHosDao.Get(hql,params);
	}
	/**
	 * （导入健康档案专用）添加关系表实体
	 * @param oldStaffHos
	 */
	public void addOldStaffHos0(TOldStaffHos oldStaffHos){
		oldStaffHosDao.Save(oldStaffHos);
	}

	@Override
	public THealthFile gethealthFileByIdNum(String idNum) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("idNum", idNum);
		String hql="from THealthFile tf where tf.idNum = :idNum ";
		return healthFileDao.Get(hql,params);
	}

	@Override
	public long getHealthFileCountGroup(Integer gId) {
		// TODO Auto-generated method stub
		String hql="select count(vo.healthFileId) from VOldStaff vo where vo.GId="+gId;
		hql=hql+" and vo.healthFileType="+HealthFileCheck.zhengchang.getValue();
		return voldStaffDao.count(hql);
	}

	@Override
	public List<VOldStaff> getAllHealthFileGroup(Page<VOldStaff> page,
			Integer gId) {
		// TODO Auto-generated method stub
		String hql="from VOldStaff vo where vo.GId="+gId;
		hql=hql+" and vo.healthFileType="+HealthFileCheck.zhengchang.getValue();
		hql=hql+"order by vo.fileNum desc";
		return voldStaffDao.find(hql,page.getCurrentPage(),page.getPageSize());
	}

	@Override
	public List<THealthFile> getAllHealthFileByOldName(Page<THealthFile> page,String name) {
		// TODO Auto-generated method stub
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("name", name);
		String hql="from THealthFile tf where tf.name like :name order by tf.fileNum desc";
		List<THealthFile> healthFileList = this.healthFileDao.find(hql,params);
		return healthFileList;
	}
	@Override
	public List<THealthFile> getAllHealthFile(Page<THealthFile> page, int state) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("state", state+"");
		String hql="from THealthFile tf where tf.healthFileType =:state"+" and tf.fileNum<>'00000000000000000000'  and tf.healthFileId in (select th.THealthFile.healthFileId from TOldStaffHos th) order by tf.fileNum desc";
		List<THealthFile> healthFileList = this.healthFileDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
		return healthFileList;
	}
	
	
	/****************add by zxf 20170512********************/
	@Override
	public List<VOldStaff> getOldStaffsListByPlatAdminAndOldName(String name) {
		String hql = "from VOldStaff vos where vos.fileNum<>'00000000000000000000'"+" and vos.HName like :name";
		hql +=" order by vos.fileNum desc";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("name", name);
		return voldStaffDao.find(hql,params);
	}
	@Override
	public List<VOldStaff> getOldStaffsListByGroupAdminAndOldName(int gid, String name) {
		String hql = "from VOldStaff vos where vos.fileNum<>'00000000000000000000' and vos.GId="+gid+" and vos.HName like :name ";
		hql +=" order by vos.fileNum desc";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("name", name);
		return voldStaffDao.find(hql,params);
	}
	@Override
	public List<VOldStaff> getOldStaffsListBystaffIdAndOldName(int staffId, String name){
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		params.put("name", name);
		String hql = "from VOldStaff vos where vos.staffId= :staffId and vos.fileNum<>'00000000000000000000'"+" and vos.HName like :name ";
		hql +=" order by vos.fileNum desc";
		return voldStaffDao.find(hql,params);
	
	}
	@Override
	public List<VOldStaff> getOldStaffsListBycommunityidAndOldName(int communityHosiptalId, String name){
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("communityHosiptalId", communityHosiptalId);	
		params.put("name", name);
		String hql = "from VOldStaff vos where vos.communityHospitalId=:communityHosiptalId and vos.fileNum<>'00000000000000000000'"+" and vos.HName like :name ";
		hql +=" order by vos.fileNum desc";
		return voldStaffDao.find(hql, params);	
	}
	/****************add byzxf 20170512********************/
	
	/****************add byzxf 20170517********************/
	@Override
	public List<VOldStaff> getOldStaffsListByPlatAdminAndOldNameIDNum(
			String name, String idNum) {
		String hql = "from VOldStaff vos where vos.fileNum<>'00000000000000000000'"+" and vos.HName like :name and vos.idNum like :idNum";
		hql +=" order by vos.fileNum desc";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("name", name);
		params.put("idNum", idNum);
		return voldStaffDao.find2(hql,params);
	}

	@Override
	public List<VOldStaff> getOldStaffsListByGroupAdminAndOldNameIDNum(int gid,
			String name, String idNum) {
		String hql = "from VOldStaff vos where vos.fileNum<>'00000000000000000000' and vos.GId="+gid+" and vos.HName like :name  and vos.idNum like :idNum";
		hql +=" order by vos.fileNum desc";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("name", name);
		params.put("idNum", idNum);
		return voldStaffDao.find2(hql,params);
	}

	@Override
	public List<VOldStaff> getOldStaffsListBystaffIdAndOldNameIDNum(
			int staffId, String name, String idNum) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		params.put("name", name);
		params.put("idNum", idNum);
		String hql = "from VOldStaff vos where vos.staffId= :staffId and vos.fileNum<>'00000000000000000000'"+" and vos.HName like :name  and vos.idNum like :idNum";
		hql +=" order by vos.fileNum desc";
		return voldStaffDao.find2(hql,params);
	}

	@Override
	public List<VOldStaff> getOldStaffsListBycommunityidAndOldNameIDNum(
			int communityHosiptalId, String name, String idNum) {
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("communityHosiptalId", communityHosiptalId);	
		params.put("name", name);
		params.put("idNum", idNum);
		String hql = "from VOldStaff vos where vos.communityHospitalId=:communityHosiptalId and vos.fileNum<>'00000000000000000000'"+" and vos.HName like :name  and vos.idNum like :idNum";
		hql +=" order by vos.fileNum desc";
		return voldStaffDao.find2(hql, params);	
	}
	
	/****************add byzxf 20170517********************/
}
