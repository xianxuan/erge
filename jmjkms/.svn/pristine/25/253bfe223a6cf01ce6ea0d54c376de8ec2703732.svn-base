package com.jmjk.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.gson.Gson;
import com.jmjk.dao.AuxiliaryExaminationDao;
import com.jmjk.dao.CheckDao;
import com.jmjk.dao.ChinaMedicineDao;
import com.jmjk.dao.DefendInocuDao;
import com.jmjk.dao.GeneralConditionDao;
import com.jmjk.dao.HFDao;
import com.jmjk.dao.HealthExtingProblemDao;
import com.jmjk.dao.HospitalHistoryDao;
import com.jmjk.dao.LifeStyleDao;
import com.jmjk.dao.MedicalUseDao;
import com.jmjk.dao.OrganFunctionDao;
import com.jmjk.dao.PhysicalExamDao;
import com.jmjk.dao.VExamDao;
import com.jmjk.entity.SearchClass;
import com.jmjk.entity.TAuxiliaryExamination;
import com.jmjk.entity.TCheck;
import com.jmjk.entity.TChinaMedicine;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.TDefendInocu;
import com.jmjk.entity.TGeneralCondition;
import com.jmjk.entity.THF;
import com.jmjk.entity.THealthExtingProblem;
import com.jmjk.entity.THealthFile;
import com.jmjk.entity.THospitalHistory;
import com.jmjk.entity.TLifeStyle;
import com.jmjk.entity.TMedicalUse;
import com.jmjk.entity.TOrganFunction;
import com.jmjk.entity.TPhysicalExam;
import com.jmjk.entity.view.VExam;
import com.jmjk.entity.view.VHealthStaff;
import com.jmjk.iservice.IPhysicalExamService;
import com.jmjk.pojo.HealthFileCloudForDetail;
import com.jmjk.pojo.PhysicalExam;
import com.jmjk.pojo.PhysicalExamAndId;
import com.jmjk.pojo.PhysicalExamBypersonal;
import com.jmjk.pojo.HealthFileCloudForDetail.Item;
import com.jmjk.utils.GetSessionPerson;
import com.jmjk.utils.HttpRequest;
import com.jmjk.utils.Page;
import com.jmjk.utils.ReflexByPhysicalExam;
import com.jmjk.utils.SearchMulti;
import com.jmjk.utils.WebXMLParameter;

import net.sf.json.JSONObject;


@Controller("physicalExamService")
public class PhysicalExamService implements IPhysicalExamService{
	@Autowired
	PhysicalExamDao pedao;
	@Autowired
	OrganFunctionDao ofdao;
	@Autowired
	CheckDao ckdao;
	@Autowired
	ChinaMedicineDao cmdao;
	@Autowired
	HealthExtingProblemDao hepdao;
	@Autowired
	GeneralConditionDao gcdao;
	@Autowired
	LifeStyleDao lsdao;
	@Autowired
	AuxiliaryExaminationDao aedao;
	@Autowired
	HospitalHistoryDao hhdao;
	@Autowired
	HFDao hfdao;
	@Autowired
	MedicalUseDao mudao;
	@Autowired
	DefendInocuDao didao;
	@Autowired
	VExamDao vexamdao;
	@Autowired
	PhysicalExamDao phdao;
	@Autowired
	private StaffService staffService;
	@Autowired
	private HealthFileService healthFileService;
	
	
	@Override
	public boolean saveTPhysicalExamBy54(TPhysicalExam tphysicalexam,
			TAuxiliaryExamination tauxiliaryExamination, TCheck tcheck,
			TChinaMedicine tchinaMedicine, TGeneralCondition tgeneralCondition,
			THealthExtingProblem thealthExtingProblem, TLifeStyle tlifeStyle,
			TOrganFunction torganFunction) {
		//String url = "http://222.222.218.52:8185/healthy/physicalExam/addData";
	    StringBuffer url=new StringBuffer();
        url.append(WebXMLParameter.getParamValue("ip_port"));
        url.append("/healthy/physicalExam/addData");
	    PhysicalExam p=new PhysicalExam();
		p=ReflexByPhysicalExam.getNewT(p, tphysicalexam);
		
		Gson gson = new Gson();  
        String physicalExam =gson.toJson(p); 
		
		String auxiliaryExamination = JSON.toJSONString(tauxiliaryExamination,SerializerFeature.WriteMapNullValue); 
		String check = JSON.toJSONString(tcheck,SerializerFeature.WriteMapNullValue); 
		String chinaMedicine = JSON.toJSONString(tchinaMedicine,SerializerFeature.WriteMapNullValue); 
		String generalCondition = JSON.toJSONString(tgeneralCondition,SerializerFeature.WriteMapNullValue); 
		String healthExtingProblem = JSON.toJSONString(thealthExtingProblem,SerializerFeature.WriteMapNullValue); 
		String lifeStyle = JSON.toJSONString(tlifeStyle,SerializerFeature.WriteMapNullValue); 
		String organFunction = JSON.toJSONString(torganFunction,SerializerFeature.WriteMapNullValue); 
		
		String json="physicalExam="+physicalExam;
		json+="&auxiliaryExamination="+auxiliaryExamination;
		json+="&check="+check;
		json+="&chinaMedicine="+chinaMedicine;
		json+="&generalCondition="+generalCondition;
		json+="&healthExtingProblem="+healthExtingProblem;
		json+="&lifeStyle="+lifeStyle;
		json+="&organFunction="+organFunction;

		String resultJson =HttpRequest.sendPost(url.toString(),json);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap =JSON.parseObject(resultJson);
		if(((String) resultMap.get("message")).equals("数据保存成功！")){
			return true;
		}else{
			return false;
		}
	
	}
	public boolean editTPhysicalExamBy54(TPhysicalExam tphysicalexam,
			TAuxiliaryExamination tauxiliaryExamination, TCheck tcheck,
			TChinaMedicine tchinaMedicine, TGeneralCondition tgeneralCondition,
			THealthExtingProblem thealthExtingProblem, TLifeStyle tlifeStyle,
			TOrganFunction torganFunction){
		//String url = "http://222.222.218.52:8185/healthy/physicalExam/editData";
		StringBuffer url=new StringBuffer();
        url.append(WebXMLParameter.getParamValue("ip_port"));
        url.append("/healthy/physicalExam/editData");
		PhysicalExam p=new PhysicalExamAndId(tphysicalexam.getPhysicalExamId());
        
		p=ReflexByPhysicalExam.getNewT(p, tphysicalexam);
		p.setIdNum(tphysicalexam.getTHealthFile().getIdNum());
		Gson gson= new Gson();
		String physicalExam =gson.toJson(p);
		
		String auxiliaryExamination = JSON.toJSONString(tauxiliaryExamination,SerializerFeature.WriteMapNullValue); 
		String check = JSON.toJSONString(tcheck,SerializerFeature.WriteMapNullValue); 
		String chinaMedicine = JSON.toJSONString(tchinaMedicine,SerializerFeature.WriteMapNullValue); 
		String generalCondition = JSON.toJSONString(tgeneralCondition,SerializerFeature.WriteMapNullValue); 
		String healthExtingProblem = JSON.toJSONString(thealthExtingProblem,SerializerFeature.WriteMapNullValue); 
		String lifeStyle = JSON.toJSONString(tlifeStyle,SerializerFeature.WriteMapNullValue); 
		String organFunction = JSON.toJSONString(torganFunction,SerializerFeature.WriteMapNullValue); 
		
		String json="physicalExam="+physicalExam;
		json+="&auxiliaryExamination="+auxiliaryExamination;
		json+="&check="+check;
		json+="&chinaMedicine="+chinaMedicine;
		json+="&generalCondition="+generalCondition;
		json+="&healthExtingProblem="+healthExtingProblem;
		json+="&lifeStyle="+lifeStyle;
		json+="&organFunction="+organFunction;

		String resultJson =HttpRequest.sendPost(url.toString(),json);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap =JSON.parseObject(resultJson);
		if(((String) resultMap.get("message")).equals("数据保存成功！")){
			return true;
		}else{
			return false;
		}
	
	}
	
	public List<VHealthStaff> getVHealthStaffBy54(String name,String idNum,String fileNum,int type,int id){
		//String url="http://222.222.218.52:8185/healthy/healthFile/findListByInfo";
		StringBuffer url=new StringBuffer();
        url.append(WebXMLParameter.getParamValue("ip_port"));
        url.append("/healthy/healthFile/findListByInfo");
		String para="type="+type+"&id="+id;
		if(name!=null){
			 para+="&name="+name;
		}if(idNum!=null){
			 para+="&idNum="+idNum;
		}if(fileNum!=null){
			 para+="&fileNum="+fileNum;
		}
		
		String resultJson =HttpRequest.sendPost(url.toString(),para);
		if(resultJson.equals("")){
			return null;
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap =JSON.parseObject(resultJson);
		if(((String) resultMap.get("message")).equals("数据查询成功！")){
			Object jso=resultMap.get("item");
			List<VHealthStaff> hfList=(List<VHealthStaff>)JSONArray.parseArray(jso.toString(),VHealthStaff.class);
			if(hfList.size()!=0){
				return hfList;
			}
		}
		return null;
	}
	
	public THealthFile getThealthFileBy54(String name,String idNum,String fileNum,int type,int id){
		//String url="http://222.222.218.52:8185/healthy/healthFile/findListByInfo";
		StringBuffer url=new StringBuffer();
        url.append(WebXMLParameter.getParamValue("ip_port"));
        url.append("/healthy/healthFile/findListByInfo");
		String para="type="+type+"&id="+id;
		if(name!=null){
			 para+="&name="+name;
		}if(idNum!=null){
			 para+="&idNum="+idNum;
		}if(fileNum!=null){
			 para+="&fileNum="+fileNum;
		}
		String resultJson =HttpRequest.sendPost(url.toString(),para);
		if(resultJson.equals("")){
			return null;
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap =JSON.parseObject(resultJson);
		if(((String) resultMap.get("message")).equals("数据查询成功！")){
			Object jso=resultMap.get("item");
			List<VHealthStaff> hfList=(List<VHealthStaff>)JSONArray.parseArray(jso.toString(),VHealthStaff.class);
			if(hfList.size()!=0){
				VHealthStaff hf=hfList.get(0);
				THealthFile healthfile=healthFileService.getHealthFileById(hf.getHealthFileId());
				return healthfile;
			}
		}
		return null;
	}
	
	
	@Override
	public boolean deleteTPhysicalExamBy54(int tphysicalexamid  ) {
		String para = "physicalExamId="+tphysicalexamid;
		//String url = "http://222.222.218.52:8185/healthy/physicalExam/deleteData";
		StringBuffer url=new StringBuffer();
        url.append(WebXMLParameter.getParamValue("ip_port"));
        url.append("/healthy/physicalExam/deleteData");
		String resultJson =HttpRequest.sendPost(url.toString(),para);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap =JSON.parseObject(resultJson);
		if(((String) resultMap.get("message")).equals("数据删除成功！")){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public PhysicalExamBypersonal getPhysicalExamBypersonalBy54(int  healthFileId,int belongSystem,int currentPage) {
		String para = "healthFileId="+healthFileId+"&belongSystem="+belongSystem+"&currentPage="+currentPage+"&pageSize=10";
		//String url = "http://222.222.218.52:8185/healthy/physicalExam/findDataByAll";
		StringBuffer url=new StringBuffer();
        url.append(WebXMLParameter.getParamValue("ip_port"));
        url.append("/healthy/physicalExam/findDataByAll");
		String resultJson =HttpRequest.sendPost(url.toString(),para);
		PhysicalExamBypersonal physical=new PhysicalExamBypersonal();
		physical = (PhysicalExamBypersonal)JSON.parseObject(resultJson, PhysicalExamBypersonal.class);
		return physical;
	}
	
	public PhysicalExamBypersonal getPhysicalExamBypersonalBy54(int  healthFileId,int belongSystem) {
		String para = "healthFileId="+healthFileId+"&belongSystem="+belongSystem+"&currentPage="+1+"&pageSize=1000";
		//String url = "http://222.222.218.52:8185/healthy/physicalExam/findDataByAll";
		StringBuffer url=new StringBuffer();
        url.append(WebXMLParameter.getParamValue("ip_port"));
        url.append("/healthy/physicalExam/findDataByAll");
		String resultJson =HttpRequest.sendPost(url.toString(),para);
		PhysicalExamBypersonal physical=new PhysicalExamBypersonal();
		physical = (PhysicalExamBypersonal)JSON.parseObject(resultJson, PhysicalExamBypersonal.class);
		return physical;
	}
	
	
	@Override
	public VExam getOneTPhysicalExamBy54(int tphysicalexamid) {
		 //String url="http://222.222.218.52:8185/healthy/physicalExam/getSingle";
		 StringBuffer url=new StringBuffer();
	     url.append(WebXMLParameter.getParamValue("ip_port"));
	     url.append("/healthy/physicalExam/getSingle2");
		 String para="physicalExamId="+tphysicalexamid;
		 String resultJson =HttpRequest.sendPost(url.toString(),para);
		 if(resultJson.equals("")){
			 return null;
		 }
		 com.alibaba.fastjson.JSONObject jso = JSON.parseObject(resultJson);
		 if(jso.getString("message").equals("数据获取成功！")){
			 String item=jso.getString("item");
			 com.alibaba.fastjson.JSONObject items = JSON.parseObject(item);
			 
			 String auxiliaryExamination = items.getString("auxiliaryExamination");
			 items.remove("auxiliaryExamination");
			 auxiliaryExamination=auxiliaryExamination.replace("{", ""); auxiliaryExamination=auxiliaryExamination.replace("}", "");
			 
			 String check = items.getString("check");
			 items.remove("check");
			 check=check.replace("{", ""); check=check.replace("}", "");
			 
			 String chinaMedicine = items.getString("chinaMedicine");
			 items.remove("chinaMedicine");
			 chinaMedicine=chinaMedicine.replace("{", ""); chinaMedicine=chinaMedicine.replace("}", "");
			 
			 String generalCondition =items.getString("generalCondition");
			 items.remove("generalCondition");
			 generalCondition=generalCondition.replace("{", ""); generalCondition=generalCondition.replace("}", "");
			 
			 String healthExtingProblem = items.getString("healthExtingProblem");
			 items.remove("healthExtingProblem");
			 healthExtingProblem=healthExtingProblem.replace("{", ""); healthExtingProblem=healthExtingProblem.replace("}", "");
			 
			 String lifeStyle =  items.getString("lifeStyle");
			 items.remove("lifeStyle");
			 lifeStyle=lifeStyle.replace("{", ""); lifeStyle=lifeStyle.replace("}", "");
			 
			 String organFunction =  items.getString("organFunction");
			 items.remove("organFunction");
			 organFunction=organFunction.replace("{", ""); organFunction=organFunction.replace("}", "");
			 
			 String healthFile =  items.getString("healthFile");
			 com.alibaba.fastjson.JSONObject healthFileGetName = JSON.parseObject(healthFile);
			 String name=healthFileGetName.getString("name");
			 String a=name;
			 items.remove("healthFile");
			 healthFile=healthFile.replace("{", ""); healthFile=healthFile.replace("}", "");
			 
			 String aitems=items.toString().replace("}", "");
			 aitems=aitems.replace("{", "");
			 String bitems="{"+auxiliaryExamination+","+check+","+chinaMedicine+","+generalCondition+","+healthExtingProblem+","+lifeStyle+","+organFunction+","+aitems+","+healthFile;
			 bitems=bitems+"}";
			 VExam vexam=JSON.parseObject(bitems, VExam.class);
			 vexam.setFileName(name);
			 /*try{
			 VExam vexamLocal= this.searchVExamViewByphysicalexamId(Integer.valueOf(vexam.getOne()));
			 vexam.setFileNum(vexamLocal.getFileNum());
			 vexam.setFileName(vexamLocal.getFileName());
			 vexam.setSex(vexamLocal.getSex());
			 String a=vexamLocal.getName();
			 vexam.setName(a);
			}catch (Exception e) {
			}*/
		 return vexam;
		 }else{
			 return null;
		 }
	}
	
	public List<VExam> searchResponsibleDoctorVExamViewBy54(String responsibleDoctor,int currentPage,int pageSize){
		return null;
	}
	
	public int getVExamListByGid(int gid,int fileType){
		String hql="from VExam vexam where vexam.healthFileType="+fileType+" and vexam.GId="+gid+" and vexam.status=null";
		List<VExam> vexamList=this.vexamdao.find(hql);
		return vexamList.size();
	}
	public List<VExam> getVExamListByGid(int gid ,int fileType,Page<VExam>  page){
		String hql="from VExam vexam where vexam.healthFileType="+fileType+" and vexam.GId="+gid+" and vexam.status=null order by(vexam.physicalExamDate) desc";
		List<VExam> vexamList=this.vexamdao.find(hql,page.getCurrentPage(), page.getPageSize());
		return vexamList;
	}
	public VExam getVExamByGidAndtphysicalexamid(int gid ,int tphysicalexamid){
		String hql="from VExam vexam where vexam.GId="+gid+" and vexam.physicalExamId="+tphysicalexamid;
		VExam ve=this.vexamdao.Get(hql);
		return ve;
	}
	
	@Override
	public TPhysicalExam getOneTPhysicalExamBy54(int tphysicalexamid,
			int fileType) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<VExam> searchResponsibleDoctorVExamViewBy54(
			String responsibleDoctor, int fileType, int currentPage,
			int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public List<VExam> getPhysicalExamListByHealthFileId(int healthFileId,Page<VExam>  page){
		String hql="from VExam ve where ve.healthFileId="+healthFileId;
		List<VExam> ve=vexamdao.find(hql, page.getCurrentPage(), page.getPageSize());
		return ve;
	}
	
	public Long getPhysicalExamListByHealthFileId(int healthFileId){
		String hql="select count(ve.healthFileId) from VExam ve where ve.healthFileId="+healthFileId;
		Long count=vexamdao.count(hql);
		return count;
	}
	
	
	
	
	
	
//=====================================================================================
	
	
	
	
	

	@Override
	public void saveTPhysicalExam(TPhysicalExam tphysicalexam){
		pedao.Save(tphysicalexam);
	}
	@Override
	public int saveTOrganFunction(TOrganFunction torganfunction) {
		//String sql="select auto_increment from information_schema.`TABLES` where table_name = 'T_ORGAN_FUNCTION'";
		ofdao.Save(torganfunction);
		return torganfunction.getOrganFunctionId();
	}
	@Override
	public int saveTCheck(TCheck tcheck) {
		//String sql="select auto_increment from information_schema.`TABLES` where table_name = 'T_CHECK'";
		ckdao.Save(tcheck);
		return tcheck.getCheckId();
	}
	@Override
	public int saveTChinaMedicine(TChinaMedicine tchinamedicine) {
		//String sql="select auto_increment from information_schema.`TABLES` where table_name = 'T_CHINA_MEDICINE'";
		cmdao.Save(tchinamedicine);
		return tchinamedicine.getChinaMedicineId();
	}
	@Override
	public int saveTHealthExtingProblem(THealthExtingProblem thealthexting) {
		//String sql="select auto_increment from information_schema.`TABLES` where table_name = 'T_HEALTH_EXTING_PROBLEM'";
		hepdao.Save(thealthexting);
		return thealthexting.getHealthExistingProblemsId();
	}
	@Override
	public int saveTGeneralCondition(TGeneralCondition tgeneralcondition) {
	//	String sql="select auto_increment from information_schema.`TABLES` where table_name = 'T_GENERAL_CONDITION'";
		gcdao.Save(tgeneralcondition);
	//	return gcdao.getPrefetching(sql);
		return tgeneralcondition.getGeneralConditionId();
	}
	@Override
	public int saveTLifeStyle(TLifeStyle tlifestyle) {
		//String sql="select auto_increment from information_schema.`TABLES` where table_name = 'T_LIFE_STYLE'";
		lsdao.Save(tlifestyle);
		return tlifestyle.getLifeId();
	}
	@Override
	public int saveTAuxiliaryExamination(TAuxiliaryExamination tauxiliaryexamination) {
		//String sql="select auto_increment from information_schema.`TABLES` where table_name = 'T_AUXILIARY_EXAMINATION'";
		aedao.Save(tauxiliaryexamination);
		return tauxiliaryexamination.getAuxiliaryExaminationId();
	}
	@Override
	public void saveTHospitalHistory(List<THospitalHistory> thospitalhistoryList) {
		for(THospitalHistory  t: thospitalhistoryList){
		hhdao.Save(t);
		}
	}
	@Override
	public void saveTHF(List<THF> thfList) {
		for(THF  t: thfList){
			hfdao.Save(t);
			}
	}
	@Override
	public void saveTMedicalUse(List<TMedicalUse> tmedicaluseList) {
		for(TMedicalUse t: tmedicaluseList){
			mudao.Save(t);
		   }
		
	}
	@Override
	public void saveTDefendInocu(List<TDefendInocu> tdefendinocu) {
		for(TDefendInocu t: tdefendinocu){
			didao.Save(t);
		   }
		
	}
//==========================delete=======================================
	
	@Override
	public void deleteTPhysicalExam(TPhysicalExam tphysicalexam) {
		pedao.delete(tphysicalexam);
	}
	@Override
	public void deleteTPhysicalExamByID(int healthfileId) {
		String hql="delete from TPhysicalExam tpe where tpe.physicalExamId= "+healthfileId;
		pedao.delete(hql);
	}
	
	
	@Override
	public void deleteTHospitalHistoryByPhysicalId(int physicalExamId) {
		String hql="delete from THospitalHistory thh where thh.TPhysicalExam.physicalExamId="+physicalExamId;
		hhdao.delete(hql);
	}
	@Override
	public void deleteTHFByPhysicalId(int physicalExamId) {
		String hql="delete from THF thf where thf.TPhysicalExam.physicalExamId="+physicalExamId;
		hfdao.delete(hql);
	}
	@Override
	public void deleteTMedicalUseByPhysicalId(int physicalExamId) {
		String hql="delete from TMedicalUse tmu where tmu.TPhysicalExam.physicalExamId="+physicalExamId;
		mudao.delete(hql);
	}
	@Override
	public void deleteTDefendInocuByPhysicalId(int physicalExamId) {
		String hql="delete from TDefendInocu tdi where tdi.TPhysicalExam.physicalExamId="+physicalExamId;
		mudao.delete(hql);
		
	}
//============================edit=============================================
	@Override
	public void editTPhysicalExam(TPhysicalExam tphysicalexam) {
		 pedao.update(tphysicalexam);
		
	}
	@Override
	public void editTOrganFunction(TOrganFunction torganfunction) {
		ofdao.update(torganfunction);
		
	}
	@Override
	public void editTCheck(TCheck tcheck) {
		ckdao.update(tcheck);
	}
	@Override
	public void editTChinaMedicine(TChinaMedicine tchinamedicine) {
		cmdao.update(tchinamedicine);
		
	}
	@Override
	public void editTHealthExtingProblem(THealthExtingProblem thealthexting) {
		hepdao.update(thealthexting);
		
	}
	@Override
	public void editTGeneralCondition(TGeneralCondition tgeneralcondition) {
		gcdao.update(tgeneralcondition);
		
	}
	@Override
	public void editTLifeStyle(TLifeStyle tlifestyle) {
		lsdao.update(tlifestyle);
		
	}
	@Override
	public void editTAuxiliaryExamination(TAuxiliaryExamination tauxiliaryexamination) {
		aedao.update(tauxiliaryexamination);
	}
//===========4史=====
	/**
	 *编辑4史表    
	 *就是  删除原本的 历史实体  增加新的实体
	 */
	@Override
	public void editTHospitalHistory(List<THospitalHistory> thospitalhistoryList) {
		int a=thospitalhistoryList.get(0).getTPhysicalExam().getPhysicalExamId();
		deleteTHospitalHistoryByPhysicalId(a);
		saveTHospitalHistory(thospitalhistoryList);
		
	}
	@Override
	public void editTHF(List<THF> thfList) {
		deleteTHFByPhysicalId(thfList.get(0).getTPhysicalExam().getPhysicalExamId());
		saveTHF(thfList);
	}
	@Override
	public void editTMedicalUse(List<TMedicalUse> tmedicaluseList) {
		deleteTMedicalUseByPhysicalId(tmedicaluseList.get(0).getTPhysicalExam().getPhysicalExamId());
		saveTMedicalUse(tmedicaluseList);
	}
	@Override
	public void editTDefendInocu(List<TDefendInocu> tdefendinocuList) {
		deleteTDefendInocuByPhysicalId(tdefendinocuList.get(0).getTPhysicalExam().getPhysicalExamId());
		saveTDefendInocu(tdefendinocuList);
	}
//=======================search=============================
	@Override
	public List<THospitalHistory> searchtHospitalHistoryByPhysicalExamId(int physicalexamId) {
		Map<String ,Object> params =new HashMap<String, Object>();
		params.put("physicalexamId", physicalexamId);
		String hql="from THospitalHistory thh where thh.TPhysicalExam.physicalExamId=:physicalexamId";
		List<THospitalHistory>  thhList=this.hhdao.find(hql,params);
		return thhList;
	}
	@Override
	public List<THF> searchTHFListByPhysicalExamId(int physicalexamId) {
		Map<String ,Object> params =new HashMap<String, Object>();
		params.put("physicalexamId", physicalexamId);
		String hql="from THF thf where thf.TPhysicalExam.physicalExamId=:physicalexamId";
		List<THF> thfList=this.hfdao.find(hql,params);
		return thfList;
	}
	@Override
	public List<TMedicalUse> searchTMedicalUseListByPhysicalExamId(int physicalexamId) {
		Map<String ,Object> params =new HashMap<String, Object>();
		params.put("physicalexamId", physicalexamId);
		String hql="from TMedicalUse tmu where tmu.TPhysicalExam.physicalExamId=:physicalexamId";
		List<TMedicalUse> tmuList=this.mudao.find(hql,params);
		return tmuList;
	}
	@Override
	public List<TDefendInocu> searchTDefendInocusListByPhysicalExamId(int physicalexamId) {
		Map<String ,Object> params =new HashMap<String, Object>();
		params.put("physicalexamId", physicalexamId);
		String hql="from TDefendInocu tdi where tdi.TPhysicalExam.physicalExamId=:physicalexamId";
		List<TDefendInocu> tdiList=this.didao.find(hql,params);
		return tdiList;
	}
	public TPhysicalExam searchTPhysicalExamByPhysicalExamId(int physicalexamId){
		Map<String ,Object> params =new HashMap<String, Object>();
		params.put("physicalexamId", physicalexamId);
		String hql="from TPhysicalExam tph where tph.physicalExamId=:physicalexamId";
		return this.phdao.Get(hql,params);
		
	}
	
	public TPhysicalExam searchTPhysicalExamByHealthFileId(int healthFileId){
		Map<String ,Object> params =new HashMap<String, Object>();
		params.put("healthFileId", healthFileId);
		String hql="from TPhysicalExam tph where tph.THealthFile.healthFileId=:healthFileId";
		return this.phdao.Get(hql);
	}
	
	
	//===================searchVExam==================
	
	
	/*@Override
	public List<VExam> searchVExamByFileName(String fileName) {
		String hql="from VExam vexam where vexam.fileName '%"+fileName+"%'";
		List<VExam> vexamList= vexamdao.find(hql, page.getCurrentPage(), page.getPageSize());
		return vexamList;
	}
	@Override
	public List<VExam> searchVExamByHealthFileId(int healthFileId) {
		String hql="from VExam vexam where vexam.healthFileId="+healthFileId;
		List<VExam> vexamList= vexamdao.find(hql, page.getCurrentPage(), page.getPageSize());
		return vexamList;
	}
	@Override
	public List<VExam> searchVExamByIdNum(String idNum) {
		String hql="from VExam vexam where vexam.idNum="+idNum;
		List<VExam> vexamList= vexamdao.find(hql, page.getCurrentPage(), page.getPageSize());
		return vexamList;
	}*/
	@Override
	public List<VExam> searchVExamByFileTypeHosId(int fileType,int hosId,Page<VExam>  page){
		Map<String ,Object> params =new HashMap<String, Object>();
		params.put("fileType", fileType+"");
		params.put("hosId", hosId);
		String hql="from VExam vexam where vexam.healthFileType=:fileType and vexam.communityHospitalId=:hosId and vexam.status=null order by(vexam.physicalExamDate) desc";
		List<VExam> vexamList=this.vexamdao.find(hql,params,page.getCurrentPage(), page.getPageSize());
		return vexamList;
	}
	public List<VExam> searchVExamByFileTypeHosId(int fileType,int hosId){
		Map<String ,Object> params =new HashMap<String, Object>();
		params.put("fileType", fileType+"");
		params.put("hosId", hosId);
		String hql="from VExam vexam where vexam.healthFileType=:fileType and vexam.communityHospitalId=:hosId and vexam.status=null";
		List<VExam> vexamList=this.vexamdao.find(hql,params);
		return vexamList;
	}
	public List<VExam> searchVExamByHosId(int hosId){
		Map<String ,Object> params =new HashMap<String, Object>();
		params.put("hosId", hosId);
		String hql="from VExam vexam where vexam.communityHospitalId=:hosId and vexam.status=null";
		List<VExam> vexamList=this.vexamdao.find(hql,params);
		return vexamList;
	}
	/*暂时废弃*/
	public long searchVExamByFileTypeHosIdCount(int fileType,int hosId){
		//String hql="selete Count(vexam.physicalExamId) from VExam vexam where vexam.healthFileType="+fileType+" and communityHospitalId="+hosId;
		return 0;
	}
	@Override
	public List<VExam> searchVExamView(int healthfileId) {
		Map<String ,Object> params =new HashMap<String, Object>();
		params.put("healthfileId", healthfileId);
		String hql="from VExam vexam where vexam.healthFileId=:healthfileId";
		List<VExam> vexamList=this.vexamdao.find(hql,params);
		return vexamList;
	}
	public List<VExam> searchVExamView(int healthfileId,Page<VExam> page) {
		Map<String ,Object> params =new HashMap<String, Object>();
		params.put("healthfileId", healthfileId);
		String hql="from VExam vexam where vexam.healthFileId=:healthfileId";
		List<VExam> vexamList=this.vexamdao.find(hql,params,page.getCurrentPage(),page.getPageSize());
		return vexamList;
	}
	
	public List<VExam> searchVExamViewLzy(int healthfileId,Page<VExam> page) {
		Map<String ,Object> params =new HashMap<String, Object>();
		params.put("healthfileId", healthfileId);
		String hql="from VExam vexam where vexam.healthFileId=:healthfileId order by vexam.physicalExamDate desc";
		List<VExam> vexamList=this.vexamdao.find(hql,params,page.getCurrentPage(),page.getPageSize());
		return vexamList;
	}
	
	public VExam getVExamByStaffIdPhysicalId(int staffId,int physicalExamId){
		Map<String ,Object> params =new HashMap<String, Object>();
		params.put("physicalExamId", physicalExamId);
		params.put("staffId", staffId);
		String hql="from VExam vexam where vexam.physicalExamId=:physicalExamId and vexam.staffId=:staffId";
		return vexamdao.Get(hql,params);
		
	}
	
	@Override
	public VExam searchVExamViewByphysicalexamId(int physicalexamId){
		String hql="from VExam vexam where vexam.physicalExamId=:physicalexamId" ;
		Map<String , Object> params =new HashMap<String, Object>();
		params.put("physicalexamId", physicalexamId);
		return this.vexamdao.Get(hql,params);
		
	}
	@Override
	public VExam searchVExamView(int healthfileId, int communityhospitalId) {
		Map<String , Object> params =new HashMap<String, Object>();
		params.put("healthfileId", healthfileId);
		params.put("communityhospitalId", communityhospitalId);
		String hql="from VExam vexam where vexam.healthFileId=:healthfileId and vexam.communityHospitalId=:communityhospitalId";
		VExam vexam=this.vexamdao.Get(hql,params);
		return vexam;
	}
	@Override
	public VExam searchVExamViewByphysicalExamIdHosId(int physicalExamId, int communityhospitalId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("physicalExamId", physicalExamId);
		params.put("communityhospitalId", communityhospitalId);
		String hql="from VExam vexam where vexam.physicalExamId=:physicalExamId and vexam.communityHospitalId=:communityhospitalId";
		VExam vexam=this.vexamdao.Get(hql,params);
		return vexam;
	}
	public TPhysicalExam searchTPhysicalExam(int physicalexamId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("physicalexamId", physicalexamId);
		
		String hql="from TPhysicalExam tph where tph.physicalExamId=:physicalexamId";
		return this.phdao.Get(hql,params);
	}
	public TPhysicalExam searchTPhysicalExam(int physicalexamId,int healthfileId){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("physicalexamId", physicalexamId);
		params.put("healthfileId", healthfileId);
		String hql="from TPhysicalExam tph where tph.physicalExamId=:physicalexamId and tph.THealthFile.healthFileId=:healthfileId";
		return this.phdao.Get(hql,params);
	}
	
	public List<VExam> searchVExamViewByStaffId(int staffId, int fileType,Page<VExam> page) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		params.put("fileType", fileType+"");
		String hql="from VExam vexam where vexam.staffId=:staffId and vexam.healthFileType=:fileType and vexam.status=null order by(vexam.physicalExamDate) desc";
		List<VExam>vexamList=vexamdao.find(hql,params,page.getCurrentPage(), page.getPageSize());
		return vexamList;
	}
	public int searchVExamViewByStaffId(int staffId, int fileType) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		params.put("fileType", fileType+"");
		String hql="from VExam vexam where vexam.staffId=:staffId and vexam.healthFileType=:fileType and vexam.status=null";
		List<VExam>vexamList=vexamdao.find(hql,params);
		return (Integer)vexamList.size();
	}
	public List<VExam> searchVExamViewByStaffId(int staffId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("staffId", staffId);
		String hql="from VExam vexam where vexam.staffId=:staffId and vexam.status=null";
		List<VExam>vexamList=vexamdao.find(hql,params);
		return vexamList;
	}
	public List<VExam> getAllVExamView(int fileType,Page<VExam> page){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fileType", fileType+"");
		String hql="from VExam vexam where vexam.healthFileType=:fileType and vexam.status=null";
		List<VExam> vexamList=vexamdao.find(hql,params,page.getCurrentPage(),page.getPageSize());
		return vexamList;
	}
	 public int getAllVExamView(int fileType) {
		 Map<String, Object> params = new HashMap<String, Object>();
			params.put("fileType", fileType+"");
		 String hql="from VExam vexam where vexam.healthFileType=:fileType and vexam.status=null";
			List<VExam> vexamList=vexamdao.find(hql,params);
			return (Integer)vexamList.size();
	}
	 public List<VExam> getAllVExamView() {
		 String hql="from VExam vexam where vexam.status=null";
			List<VExam> vexamList=vexamdao.find(hql);
			return vexamList;
	}
	
	
	@Override
	public List<VExam> searchMultiVExam(SearchClass sc ){
		String multiHql=SearchMulti.Multi(sc);
		Map<String, Object> params = new HashMap<String, Object>();
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group = (TCommunityHospitalGroup) session
				.getAttribute("communityHospitalGroup");
		if(group != null){
			multiHql+=" and ve.GId="+group.getGId();
		}else{//集团else 开始
		
		
		int a=GetSessionPerson.getPerson();
		if(a>0){
			if(healthFileService.getOldStaffHosByStaffId(a)){
				int hosId=staffService.getCommHospitalByStaffId(a);
				params.put("hosId", hosId);
				params.put("a", a);
				multiHql+=" and ve.communityHospitalId=:hosId and ve.status=null and ve.staffId=:a";
				}else{
					int hosId=staffService.getCommHospitalByStaffId(a);
					params.put("hosId", hosId);
					multiHql+=" and ve.communityHospitalId=:hosId and ve.status=null";
				}
		}
		if(a<0){
			int hosId=Math.abs(a);
			params.put("hosId", hosId);
			multiHql+=" and ve.communityHospitalId=:hosId and ve.status=null";
		}
		if(a==0){
			multiHql+=" and ve.status=null";	
			}	
		}//集团结束
 		List<VExam> vexamList=vexamdao.find(multiHql,params);
		return vexamList; 
	}
	public List<VExam> searchMultiVExam(SearchClass sc ,Page<VExam> page){
		String multiHql=SearchMulti.Multi(sc);
		Map<String, Object> params = new HashMap<String, Object>();
		int a=GetSessionPerson.getPerson();
		if(a>0){
			if(healthFileService.getOldStaffHosByStaffId(a)){
				int hosId=staffService.getCommHospitalByStaffId(a);
				params.put("hosId", hosId);
				params.put("a", a);
				multiHql+=" and ve.communityHospitalId=:hosId and ve.status=null and ve.staffId=:a";
				}else{
					int hosId=staffService.getCommHospitalByStaffId(a);
					params.put("hosId", hosId);
					multiHql+=" and ve.communityHospitalId=:hosId and ve.status=null";
				}
		}	
		if(a<0){
			int hosId=Math.abs(a);
			params.put("hosId", hosId);
			multiHql+=" and ve.communityHospitalId=:hosId and ve.status=null";
		}
		if(a==0){
			multiHql+=" and ve.status=null";
		}
		multiHql+=" order by(ve.physicalExamDate) desc";
		List<VExam> vexamList=vexamdao.find(multiHql,params,page.getCurrentPage(),page.getPageSize());
		return vexamList; 
	}
	@Override
	public TOrganFunction searchTOrganFunctionByTOrganFunctionId(Integer torganFunctionId) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("torganFunctionId", torganFunctionId);
		String hql="from TOrganFunction tof where tof.organFunctionId=:torganFunctionId";
		
		return ofdao.Get(hql,params);
	}
 
	



	

	
}


