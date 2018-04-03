package com.jmjk.service;

import java.awt.Stroke;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.config.OxmNamespaceHandler;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jmjk.dao.HealthFileDao;
import com.jmjk.dao.VChronicDao;
import com.jmjk.dao.VOldStaffDao;
import com.jmjk.entity.THealthFile;
import com.jmjk.entity.view.VChronic;
import com.jmjk.entity.view.VOldStaff;
import com.jmjk.iservice.IHealthManagerService;
import com.jmjk.pojo.BloodOxygen;
import com.jmjk.pojo.BloodPress;
import com.jmjk.pojo.BloodSuger;
import com.jmjk.pojo.BloodSugerCloud;
import com.jmjk.pojo.HealthFileCloud;
import com.jmjk.pojo.HealthFileSingleCloud;
import com.jmjk.pojo.Suggest;
import com.jmjk.utils.MyHttpClient;
import com.jmjk.utils.Page;
import com.jmjk.utils.SearchBean;
import com.jmjk.utils.TypeConverter;
import com.jmjk.utils.WebXMLParameter;
/**
 * 
 * @author 张晓光
 * 2016年8月5号
 */
@Controller("healthManagerService")
public class HealthManagerService implements IHealthManagerService {
	@Autowired
    private VOldStaffDao voldStaffDao;
    @Autowired
    private VChronicDao vchronicDao;
    @Autowired
    private HealthFileDao healthFileDao;
    

	private String vs = "VOldStaff";
	private String vc = "VChronic";

	@Override
	public String addBloodPressData(BloodPress bloodPress) {
		//目标系统的资源url
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/bloodPressure/addData";
		//从web.xml中读取appkey的值
		String appkey=WebXMLParameter.getParamByappkey("appkey1");
		bloodPress.setAppKey(appkey);
		//准备请求参数
		Map<String, String> params = new HashMap<String, String>();
		//设置appUserID时，带上用户的身份证号，中间以--分隔。
		THealthFile item = this.getHealthFileById(Integer.parseInt(bloodPress.getAppUserID()));
		String idcard = "";
		if(!item.getIdNum().equals("")){
			idcard= "--"+item.getIdNum();
		}
		params.put("appUserID", bloodPress.getAppUserID()+idcard);
		//params.put("appUserID", bloodPress.getAppUserID());
		params.put("devID", "0");
		if(bloodPress.getMeaState()!=null){
			params.put("meaState", bloodPress.getMeaState()+"");
		}
		if(bloodPress.getDiaPre()!=null){
			params.put("diaPre", bloodPress.getDiaPre()+"");
		}
		if(bloodPress.getSysPre()!=null){
			params.put("sysPre", bloodPress.getSysPre()+"");
		}
		if(bloodPress.getPulse()!=null){
			params.put("pulse", bloodPress.getPulse()+"");
		}
		if(bloodPress.getArm()!=null){
			params.put("arm", bloodPress.getArm()+"");
		}
		params.put("appKey", bloodPress.getAppKey()+"");
		params.put("meaTime", bloodPress.getMeaTime());
		params.put("takeMed", bloodPress.getTakeMed()+"");
		if(bloodPress.getTakeMed()==1){
			params.put("medName", bloodPress.getMedName()+"");
		}
		else {
			params.put("medName", "");
		}
		params.put("other1", "111");
	    params.put("other2", "222");
	    params.put("other3", "333");
		//调用封装好的httpclient 请求方法,并返回json数据串
    	String resultJson = MyHttpClient.sendHttpPost(url, params);
    	Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//将json串转化成map
			resultMap =JSON.parseObject(resultJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回结果信息
		try {
			return (String) resultMap.get("message");
		} catch (Exception e) {
			return null;
		}
	}

	@Override
    public String addBloodSugarData(BloodSuger bloodSuger) {
		//目标系统的资源url
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/bloodSugar/addData";
		//从web.xml中读取appkey的值
		String appkey=WebXMLParameter.getParamByappkey("appkey1");
		bloodSuger.setAppKey(appkey);
		Map<String, String> params = new HashMap<String, String>();
		params.put("bloodSugar", bloodSuger.getBloodSugar()+"");
		params.put("meaState", bloodSuger.getMeaState()+"");
		params.put("appKey", bloodSuger.getAppKey());
		//设置appUserID时，带上用户的身份证号，中间以--分隔。
		THealthFile item = this.getHealthFileById(Integer.parseInt(bloodSuger.getAppUserID()));
		String idcard = "";
			if(!item.getIdNum().equals("")){
				idcard= "--"+item.getIdNum();
			}
		params.put("appUserID", bloodSuger.getAppUserID()+idcard);
		//params.put("appUserID", bloodSuger.getAppUserID()+"");
		params.put("devID", "0");
		params.put("meaTime", bloodSuger.getMeaTime());
		params.put("takeMed", bloodSuger.getTakeMed()+"");
		if(bloodSuger.getTakeMed()==1){
			params.put("medName", bloodSuger.getMedName());
		}
		else {
			params.put("medName","");
		}
		params.put("abnAlarm", bloodSuger.getAbnAlarm());
		params.put("analysisResult", bloodSuger.getAnalysisResult());
		params.put("other1", "111");
	    params.put("other2", "222");
	    params.put("other3", "333");
		//调用封装好的httpclient 请求方法,并返回json数据串
    	String resultJson = MyHttpClient.sendHttpPost(url, params);
    	Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//将json串转化成map
			resultMap =JSON.parseObject(resultJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			//返回结果信息
			return (String) resultMap.get("message");
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public String addBloodOxygenData(BloodOxygen bloodOxygen) {
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/bloodOxygen/addData";
		//从web.xml中读取appkey的值
		String appkey=WebXMLParameter.getParamByappkey("appkey1");
		bloodOxygen.setAppKey(appkey);
		 //"appKey=ac6b5a57f3d04e328a1e79facc860e1d&appUserID=1&meaTime=2011-01-01 10:03:40&devID=22&oxygen=2.2
		//&pulse=45&meaState=1&takeMed=2&medName=阿莫&abnAlarm=1&analysisResult=analysisResult&other1=111&other2=222&other3=333";
		Map<String, String> params = new LinkedHashMap<String, String>();
		//设置appUserID时，带上用户的身份证号，中间以--分隔。
		THealthFile item = this.getHealthFileById(Integer.parseInt(bloodOxygen.getAppUserID()));
		String idcard = "";
		if(!item.getIdNum().equals("")){
			idcard= "--"+item.getIdNum();
		}
		params.put("appUserID", bloodOxygen.getAppUserID()+idcard);
		params.put("appKey", bloodOxygen.getAppKey());
		//params.put("appUserID", bloodOxygen.getAppUserID()+"");
		params.put("devID", "0");
		params.put("meaTime", bloodOxygen.getMeaTime()+"");
		params.put("meaState", bloodOxygen.getMeaState()+"");
		params.put("oxygen", bloodOxygen.getOxygen()+"");
		params.put("pulse", bloodOxygen.getPulse()+"");
		params.put("takeMed", bloodOxygen.getTakeMed()+"");
		if( bloodOxygen.getTakeMed()==1){
			params.put("medName", bloodOxygen.getMedName()+"");
		}
		else {
			params.put("medName","");
		}
		params.put("abnAlarm", bloodOxygen.getAbnAlarm()+"");
		params.put("analysisResult", bloodOxygen.getAnalysisResult()+"");
		params.put("other1", "111"+"");
	    params.put("other2", "222"+"");
	    params.put("other3", "333");
		//调用封装好的httpclient 请求方法,并返回json数据串
	    //String para=     "appKey=ac6b5a57f3d04e328a1e79facc860e1d&appUserID=1&meaTime=2016-05-01 10:03:40&devID=2&oxygen=2.2&pulse=65.6&meaState=0&takeMed=1&medName=韩国&abnAlarm=0&analysisResult=惹我额&other1=111&other2=222&other3=333";
	   // String a =       "appKey=ac6b5a57f3d04e328a1e79facc860e1d&appUserID=1&meaTime=2016-05-01 10:03:40&devID=2&oxygen=2.2&pulse=65&meaState=1&takeMed=2&medName=莫232&abnAlarm=1&analysisResult=达&other1=111&other2=222&other3=333";
    	String resultJson = MyHttpClient.sendHttpPost(url, params);
    	Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//将json串转化成map
			resultMap =JSON.parseObject(resultJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			//返回结果信息
			return (String) resultMap.get("message");
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public String getAllBloodPressData(String appUserID,int currentPage,int pageSize) {
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/bloodPressure/findDataByAll";
		String appkey=WebXMLParameter.getParamByappkey("appkey1");
		Map<String , String> params = new HashMap<String, String>();
		/*//设置appUserID时，带上用户的身份证号，中间以--分隔。
		THealthFile item = this.getHealthFileById(Integer.parseInt(appUserID));
		String idcard = "";
		if(!item.getIdNum().equals("")){
			idcard= "--"+item.getIdNum();
		}
		params.put("appUserID", appUserID+idcard);*/
		params.put("appUserID", appUserID);
		params.put("appKey", appkey);
		params.put("currentPage", currentPage+"");
		params.put("pageSize", pageSize+"");
		String result= MyHttpClient.sendHttpPost(url, params);
		return result;
	}
	@Override
	public String getBloodPressData(String appUserID, Date startTime,Date endTime,int currentPage,int pageSize) {
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/bloodPressure/findDataByTime";
		String appkey=WebXMLParameter.getParamByappkey("appkey1");
		Map<String , String> params = new LinkedHashMap<String, String>();
		/*//设置appUserID时，带上用户的身份证号，中间以--分隔。
		THealthFile item = this.getHealthFileById(Integer.parseInt(appUserID));
		String idcard = "";
		if(!item.getIdNum().equals("")){
			idcard= "--"+item.getIdNum();
		}
		params.put("appUserID", appUserID+idcard);*/
		params.put("appUserID", appUserID);
		params.put("startTime", TypeConverter.convertDate2String(startTime, "yyyy-MM-dd HH:mm:ss"));
		params.put("endTime", TypeConverter.convertDate2String(endTime, "yyyy-MM-dd HH:mm:ss"));
		params.put("appKey", appkey+"");
		params.put("currentPage", currentPage+"");
		params.put("pageSize", pageSize+"");
		String result= MyHttpClient.sendHttpPost(url, params);
		return result;
 	}

	@Override
	public String getBloodPressData(String appUserID, int totalSize,int currentPage,int pageSize) {
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/bloodPressure/findDataByCount";
		String appkey=WebXMLParameter.getParamByappkey("appkey1");
		Map<String , String> params = new HashMap<String, String>();
	/*	//设置appUserID时，带上用户的身份证号，中间以--分隔。
		THealthFile item = this.getHealthFileById(Integer.parseInt(appUserID));
		String idcard = "";
		if(!item.getIdNum().equals("")){
			idcard= "--"+item.getIdNum();
		}*/
		params.put("appUserID", appUserID);
		//params.put("appUserID", appUserID);
		params.put("count", totalSize+"");
		params.put("appKey", appkey);
		params.put("currentPage", currentPage+"");
		params.put("pageSize", pageSize+"");
		return MyHttpClient.sendHttpPost(url, params);
	}
	
	@Override
	public String deleteBPCloud(int id) {
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/bloodPressure/deleteData";
		String appkey=WebXMLParameter.getParamByappkey("appkey1");
		Map<String , String> params = new HashMap<String, String>();
		params.put("appKey", appkey);
		params.put("id", id+"");
		//调用封装好的httpclient 请求方法,并返回json数据串
    	String resultJson = MyHttpClient.sendHttpPost(url, params);
    	Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//将json串转化成map
			resultMap =JSON.parseObject(resultJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回结果信息
		return (String) resultMap.get("message");
	}
	
	@Override
	public String updateBPCloud(int id, BloodPress bloodPress) {
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/bloodPressure/editData";
		//String para = "id=2&appKey=ac6b5a57f3d04e328a1e79facc860e1d&appUserID=0000001&meaTime=2011-01-01 10:03:40
		//&devID=21&meaState=2&diaPre=4.5&sysPre=2.1&pulse=53&arm=3&other1=111&other2=222&other3=333";
		
		String appkey=WebXMLParameter.getParamByappkey("appkey1");
		Map<String , String> params = new HashMap<String, String>();
		//设置appUserID时，带上用户的身份证号，中间以--分隔。
		/*THealthFile item = this.getHealthFileById(Integer.parseInt(bloodPress.getAppUserID()));
		String idcard = "";
		if(!item.getIdNum().equals("")){
			idcard= "--"+item.getIdNum();
		}
		params.put("appUserID", bloodPress.getAppUserID()+idcard);*/
		params.put("appUserID", bloodPress.getAppUserID());
		params.put("id", id+"");
		params.put("appKey", appkey);
		params.put("meaTime", bloodPress.getMeaTime());
		params.put("devID", "0");
		params.put("meaState", bloodPress.getMeaState()+"");
		params.put("diaPre", bloodPress.getDiaPre()+"");
		params.put("pulse", bloodPress.getPulse()+"");
		params.put("sysPre", bloodPress.getSysPre()+"");
		params.put("arm", bloodPress.getArm()+"");
		params.put("takeMed", bloodPress.getTakeMed()+"");
		if(bloodPress.getTakeMed()==1){
			params.put("medName", bloodPress.getMedName());
		}
		else {
			params.put("medName", "");
		}
		
		params.put("other1", "111");
		params.put("other2", "222");
		params.put("other3", "333");
		//调用封装好的httpclient 请求方法,并返回json数据串
    	String resultJson = MyHttpClient.sendHttpPost(url, params);
    	Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//将json串转化成map
			resultMap =JSON.parseObject(resultJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回结果信息
		return (String) resultMap.get("message");
	}
	
	@Override
	public String getAllBloodSugerData(String appUserID,int currentPage,int pageSize){
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/bloodSugar/findDataByAll";
		String appkey=WebXMLParameter.getParamByappkey("appkey1");
		Map<String , String> params = new HashMap<String, String>();
		/*//设置appUserID时，带上用户的身份证号，中间以--分隔。
		THealthFile item = this.getHealthFileById(Integer.parseInt(appUserID));
		String idcard = "";
		if(!item.getIdNum().equals("")){
			idcard= "--"+item.getIdNum();
		}
		params.put("appUserID", appUserID+idcard);*/
		params.put("appUserID", appUserID);
		params.put("appKey", appkey);
		params.put("currentPage", currentPage+"");
		params.put("pageSize", pageSize+"");
		return MyHttpClient.sendHttpPost(url, params);
	}
	@Override
	public String getBloodSugerData(String appUserID, Date startTime,
			Date endTime, int currentPage, int pageSize) {
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/bloodSugar/findDataByTime";
		String appkey=WebXMLParameter.getParamByappkey("appkey1");
		Map<String , String> params = new HashMap<String, String>();
		/*//设置appUserID时，带上用户的身份证号，中间以--分隔。
		THealthFile item = this.getHealthFileById(Integer.parseInt(appUserID));
		String idcard = "";
		if(!item.getIdNum().equals("")){
			idcard= "--"+item.getIdNum();
		}
		params.put("appUserID", appUserID+idcard);*/
		params.put("appUserID", appUserID);
		params.put("startTime", TypeConverter.convertDate2String(startTime, "yyyy-MM-dd HH:mm:ss"));
		params.put("endTime", TypeConverter.convertDate2String(endTime, "yyyy-MM-dd HH:mm:ss"));
		params.put("appKey", appkey);
		params.put("currentPage", currentPage+"");
		params.put("pageSize", pageSize+"");
		return MyHttpClient.sendHttpPost(url,params);
	}
	
	@Override
	public String getBloodSugerData(String appUserID, int totalSize,
			int currentPage, int pageSize) {
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/bloodSugar/findDataByCount";
		String appkey=WebXMLParameter.getParamByappkey("appkey1");
		Map<String , String> params = new HashMap<String, String>();
		/*//设置appUserID时，带上用户的身份证号，中间以--分隔。
		THealthFile item = this.getHealthFileById(Integer.parseInt(appUserID));
		String idcard = "";
		if(!item.getIdNum().equals("")){
			idcard= "--"+item.getIdNum();
		}
		params.put("appUserID", appUserID+idcard);*/
		params.put("appUserID", appUserID);
	    params.put("appKey", appkey);
	    params.put("count", totalSize+"");
	    params.put("currentPage", currentPage+"");
	    params.put("pageSize", pageSize+"");
		return MyHttpClient.sendHttpPost(url, params);
	}
	
	@Override
	public String deleteBSCloud(int id) {
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/bloodSugar/deleteData";
		String appkey=WebXMLParameter.getParamByappkey("appkey1");
		Map<String , String> params = new HashMap<String, String>();
		//params.put("appUserID", appUserID+"");
		params.put("id", id+"");
		params.put("appKey",appkey);
		//调用封装好的httpclient 请求方法,并返回json数据串
    	String resultJson = MyHttpClient.sendHttpPost(url, params);
    	Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//将json串转化成map
			resultMap =JSON.parseObject(resultJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回结果信息
		return (String) resultMap.get("message");
	}
	@Override
	public String updateBSCloud(int id, BloodSuger bloodSuger) {
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/bloodSugar/editData";
		String appkey=WebXMLParameter.getParamByappkey("appkey1");
		//String para = "id=2&appKey=ac6b5a57f3d04e328a1e79facc860e1d&appUserID=0000001
		//&meaTime=2011-01-01 10:03:40&devID=23&bloodSugar=2.2&meaState=1&takeMed=0&medName=阿莫&
		//abnAlarm=1&analysisResult=analysisResult&other1=111&other2=222&other3=333444";
		
		Map<String , String> params = new HashMap<String, String>();
		params.put("appKey", appkey);
		/*//设置appUserID时，带上用户的身份证号，中间以--分隔。
		THealthFile item = this.getHealthFileById(Integer.parseInt(bloodSuger.getAppUserID()));
		String idcard = "";
		if(!item.getIdNum().equals("")){
			idcard= "--"+item.getIdNum();
		}
		params.put("appUserID", bloodSuger.getAppUserID()+""+idcard);*/
		params.put("appUserID",bloodSuger.getAppUserID());
		params.put("abnAlarm", bloodSuger.getAbnAlarm()+"");
		params.put("analysisResult", bloodSuger.getAnalysisResult());
		params.put("bloodSugar", bloodSuger.getBloodSugar()+"");
		params.put("devID", "0");
		params.put("meaState", bloodSuger.getMeaState()+"");
		params.put("meaTime", bloodSuger.getMeaTime());
		if(bloodSuger.getTakeMed()==1){
			params.put("medName", bloodSuger.getMedName());
		}
		else {
			params.put("medName", "");
		}
		params.put("takeMed", bloodSuger.getTakeMed()+"");		
		params.put("id", id+"");
		params.put("other1", "111");
		params.put("other2", "222");
		params.put("other3", "333");
		
		//调用封装好的httpclient 请求方法,并返回json数据串
    	String resultJson = MyHttpClient.sendHttpPost(url, params);
    	Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//将json串转化成map
			resultMap =JSON.parseObject(resultJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回结果信息
		return (String) resultMap.get("message");
	}
	@Override
	public String getAllBloodOxygenData(String appUserID,int currentPage, int pageSize) {
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/bloodOxygen/findDataByAll";
		String appkey=WebXMLParameter.getParamByappkey("appkey1");
		Map<String , String> params = new HashMap<String, String>();
		/*//设置appUserID时，带上用户的身份证号，中间以--分隔。
		THealthFile item = this.getHealthFileById(Integer.parseInt(appUserID));
		String idcard = "";
		if(!item.getIdNum().equals("")){
			idcard= "--"+item.getIdNum();
		}
		params.put("appUserID", appUserID+idcard);*/
		params.put("appUserID", appUserID);
		params.put("appKey", appkey);
		params.put("currentPage", currentPage+"");
		params.put("pageSize", pageSize+"");
		return MyHttpClient.sendHttpPost(url, params);
	}
	@Override
	public String getBloodOxygenData(String appUserID, Date startTime,
			Date endTime, int currentPage, int pageSize) {
		//String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/bloodOxygen/findDataByTime";
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/bloodOxygen/findDataByAll";
		String appkey=WebXMLParameter.getParamByappkey("appkey1");
		Map<String , String> params = new HashMap<String, String>();
		/*//设置appUserID时，带上用户的身份证号，中间以--分隔。
		THealthFile item = this.getHealthFileById(Integer.parseInt(appUserID));
		String idcard = "";
		if(!item.getIdNum().equals("")){
			idcard= "--"+item.getIdNum();
		}
		params.put("appUserID", appUserID+idcard);*/
		params.put("appUserID", appUserID);
		params.put("startTime", TypeConverter.convertDate2String(startTime, "yyyy-MM-dd HH:mm:ss"));
		params.put("endTime", TypeConverter.convertDate2String(endTime, "yyyy-MM-dd HH:mm:ss"));
		params.put("appKey", appkey);
		params.put("currentPage", currentPage+"");
		params.put("pageSize", pageSize+"");
		String result=MyHttpClient.sendHttpPost(url, params);
		return result;
	}
	
	@Override
	public String getBloodOxygenData(String appUserID, int totalSize,
			int currentPage, int pageSize) {
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/bloodOxygen/findDataByCount";
		String appkey=WebXMLParameter.getParamByappkey("appkey1");
		Map<String , String> params = new HashMap<String, String>();
		/*//设置appUserID时，带上用户的身份证号，中间以--分隔。
		THealthFile item = this.getHealthFileById(Integer.parseInt(appUserID));
		String idcard = "";
		if(!item.getIdNum().equals("")){
			idcard= "--"+item.getIdNum();
		}
		params.put("appUserID", appUserID+idcard);*/
		params.put("appUserID", appUserID);
		params.put("count", totalSize+"");
		params.put("appKey", appkey);
		params.put("currentPage", currentPage+"");
		params.put("pageSize", pageSize+"");
		String aString=MyHttpClient.sendHttpPost(url, params);
		return aString;
	}
	
	@Override
	public String deleteBOCloud(int id) {
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/bloodOxygen/deleteData";
		String appkey=WebXMLParameter.getParamByappkey("appkey1");
		Map<String , String> params = new HashMap<String, String>();
		params.put("id", id+"");
		params.put("appKey", appkey);
		//params.put("appUserID", appUserID+"");
		//调用封装好的httpclient 请求方法,并返回json数据串
    	String resultJson = MyHttpClient.sendHttpPost(url, params);
    	Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			//将json串转化成map
			resultMap =JSON.parseObject(resultJson);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//返回结果信息
		return (String) resultMap.get("message");
	}
	
	@Override
	public String updateBOCloud(int id, BloodOxygen bloodOxygen) {
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/bloodOxygen/editData";
		String appkey=WebXMLParameter.getParamByappkey("appkey1");
		Map<String , String> params = new HashMap<String, String>();
		//String para = "id=2&appKey=ac6b5a57f3d04e328a1e79facc860e1d&appUserID=0000001&meaTime=2011-01-01 10:03:40
		//&devID=22&oxygen=2.2&pulse=45&meaState=1&takeMed=2&medName=阿莫&abnAlarm=1&analysisResult=analysisResult&other1=111&other2=222&other3=333444";
		//String para="{id=4, takeMed=0, oxygen=2.0, other1=111, other2=222, other3=333, medName=, appUserID=1, pulse=65, meaTime=2016-01-01 10:03:40, analysisResult=达,
		//meaState=1, devID=0, appKey=ac6b5a57f3d04e328a1e79facc860e1d}";
		params.put("appKey", appkey);
		/*//设置appUserID时，带上用户的身份证号，中间以--分隔。
		THealthFile item = this.getHealthFileById(Integer.parseInt(bloodOxygen.getAppUserID()));
		String idcard = "";
		if(!item.getIdNum().equals("")){
			idcard= "--"+item.getIdNum();
		}
		params.put("appUserID", bloodOxygen.getAppUserID()+""+idcard);*/
		params.put("appUserID", bloodOxygen.getAppUserID());
		params.put("id", id+"");
		params.put("devID", "0");
		params.put("meaState", bloodOxygen.getMeaState()+"");
		params.put("meaTime", bloodOxygen.getMeaTime());
		params.put("oxygen", bloodOxygen.getOxygen()+"");
		params.put("pulse", bloodOxygen.getPulse()+"");
		params.put("takeMed", bloodOxygen.getTakeMed()+"");
		params.put("abnAlarm", bloodOxygen.getAbnAlarm()+"");		
		params.put("analysisResult", bloodOxygen.getAnalysisResult());
		//服药
		if(bloodOxygen.getTakeMed()==1){
			params.put("medName", bloodOxygen.getMedName());
		}
		else{
			params.put("medName", "");
		}
		params.put("other1", "111");
		params.put("other2", "222");
		params.put("other3", "333");
		String result = MyHttpClient.sendHttpPost(url, params);
		return result;
	}
	
	
	@Override
	public String getAIOData(String appUserID, int currentPage, int pageSize) {
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/healthMachine/findDataByAll";
		String appkey=WebXMLParameter.getParamByappkey("appkey1");
		Map<String , String> params = new LinkedHashMap<String, String>();
		params.put("appUserID", appUserID);
		//params.put("appUserID", "0000001"+"");
		params.put("appKey", appkey+"");
		params.put("currentPage", currentPage+"");
		params.put("pageSize", pageSize+"");
		String resultJson = MyHttpClient.sendHttpPost(url, params);
		return resultJson;
	}

	@Override
	public String getAIODataByTime(String appUserID, int currentPage,
			int pageSize, Date startTime, Date endTime) {
		//String para="appKey=ac6b5a57f3d04e328a1e79facc860e1d&appUserID=0000001&startTime=2010-01-01 08:03:40&endTime=2015-01-01 11:03:40&currentPage=1&pageSize=10";
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/healthMachine/findDataByTime";
		String appkey=WebXMLParameter.getParamByappkey("appkey1");
		Map<String,String> params = new HashMap<String, String>();
		params.put("appUserID", appUserID);
		//params.put("appUserID", "0000001"+"");
		params.put("currentPage", currentPage+"");
		params.put("pageSize", pageSize+"");
		params.put("appKey", appkey);
		params.put("startTime", TypeConverter.convertDate2String(startTime, "yyyy-MM-dd HH:mm:ss"));
		params.put("endTime", TypeConverter.convertDate2String(startTime, "yyyy-MM-dd HH:mm:ss"));
		return MyHttpClient.sendHttpPost(url, params);
	}

	@Override
	public String getAIODataByCount(String appUserID, int currentPage,
			int pageSize, int count) {
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/healthMachine/findDataByCount";
		String appkey=WebXMLParameter.getParamByappkey("appkey1");
		Map<String,String> params = new HashMap<String, String>();
		params.put("appUserID", appUserID);
		params.put("currentPage", currentPage+"");
		params.put("pageSize", pageSize+"");
		params.put("appKey", appkey);
		params.put("count", count+"");
		return MyHttpClient.sendHttpPost(url, params);
	}
	@Override
	public String addHealthGuide(String appUserID,int id,String advice,String guide){
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/healthMachine/updateAdvice";
		String appkey=WebXMLParameter.getParamByappkey("appkey1");
		Map<String,String> params = new HashMap<String, String>();
		params.put("appKey", appkey);
		params.put("appUserID", appUserID);
		params.put("id", id+"");
		params.put("jkpj", advice);
		params.put("jkzd", guide);
		//pojo
		String resultString= MyHttpClient.sendHttpPost(url, params);
		return resultString;
	}
	
	@Override//苏东航的，用于健康档案
	public String getHealthFileFromCloudByDoctor(int docId ,int currentPage,int pageSize){
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/healthFile/findDataByDocId";
		Map<String,String> params = new HashMap<String, String>();
		params.put("docId", docId+"");
		params.put("healthFileType", 2+"");//默认是正常状态，用于首页展示
		params.put("currentPage", currentPage+"");
		params.put("pageSize", pageSize+"");
		return MyHttpClient.sendHttpPost(url, params);
	}
	@Override//苏东航的，用于健康档案
	public String getHealthFileFromCloudByHos(int hosId,int currentPage,int pageSize){
		
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/healthFile/findDataByHosId";
		Map<String,String> params = new HashMap<String, String>();
		params.put("hosId", hosId+"");
		params.put("healthFileType", 2+"");//默认是正常状态，用于首页展示
		params.put("currentPage", currentPage+"");
		params.put("pageSize", pageSize+"");
		return MyHttpClient.sendHttpPost(url, params);
	}
	
	
	
	
	
	
	
	
	@Override
	public String getSuggestsByHealthFileId(int healthFileId ,String blongSys, int currentPage , int pageSize) {
		//belongSystem=2&healthFileId=1&currentPage=1&pageSize=10&startTime=2010-01-01 08:03:40&endTime=2019-01-01 11:03:40";
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/doctorAdvice/findDataByAll";
		Map<String,String> params = new HashMap<String, String>();
		params.put("healthFileId", healthFileId+"");
		params.put("currentPage", currentPage+"");
		params.put("belongSystem", blongSys);
		params.put("startTime", "1900-01-01 08:03:40");
		params.put("endTime", "2200-01-01 08:03:40");
		params.put("pageSize", pageSize+"");
		String aString=MyHttpClient.sendHttpPost(url, params);
		return aString;
	}

	@Override
	public String addSuggestCloud(Suggest suggest) {
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/doctorAdvice/addData";
		Map<String,String> params = new HashMap<String, String>();
	    String json = JSON.toJSONString(suggest);
	    params.put("advice", json);
		String a= MyHttpClient.sendHttpPost(url, params);
		return a;
	}

	@Override
	public String deleteSuggestCloud(int id) {
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/doctorAdvice/deleteData";
		Map<String,String> params = new HashMap<String, String>();
		params.put("id", id+"");
		return MyHttpClient.sendHttpPost(url, params);
	}

	@Override
	public String editSuggest(String suggestJson){
		
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/doctorAdvice/editData";
		Map<String,String> params = new HashMap<String, String>();
		params.put("advice", suggestJson);
		return MyHttpClient.sendHttpPost(url, params);
	}
	
	
	@Override
	public String getPhysicExemCloud(int healthFileId,String blongSys,int currentPage,int pageSize) {
		//http://222.222.218.52:8185/healthy/physicalExam/findDataByAll?healthFileId=2,3&belongSystem=2&currentPage=1&pageSize=10&startTime=2010-01-01 08:03:40&endTime=2019-01-01 11:03:40
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/physicalExam/findDataByAll";
		Map<String,String> params = new HashMap<String, String>();
		params.put("healthFileId", healthFileId+"");
		params.put("belongSystem", blongSys);
		params.put("startTime", "1900-01-01 08:03:40");
		params.put("endTime", "2200-01-01 08:03:40");
		params.put("currentPage", currentPage+"");
		params.put("pageSize", pageSize+"");
		String a=MyHttpClient.sendHttpPost(url, params);
		return a;
	}

	@Override
	public String getPhysicExemByIdCloudDetail(int physicalExamId) {
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/physicalExam/getSingle";
		Map<String,String> params = new HashMap<String, String>();
		params.put("physicalExamId", physicalExamId+"");
		return MyHttpClient.sendHttpPost(url, params);
	}
	
	
	
	
	
	
	
	public THealthFile getHealthFileById(int hFileid) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("hFileid", hFileid);
		String hql="from THealthFile tf where tf.healthFileId= :hFileid";
		THealthFile t = healthFileDao.Get(hql,params);
		return t;
	}
	@Override
	public List<VOldStaff> getvOldStaffsList(SearchBean bean, Page<VOldStaff> page) {
		// TODO Auto-generated method stub
		String h = bean.getHql(vs);
		String hql = h + " group by entity.fileNum order by entity.fileNum desc";
		hql = hql.replace("fileName", "HName");
		hql = hql.replace("fileFileDate", "fileDate");
		hql = hql.replace("name", "SName");
		List<VOldStaff> vclist = voldStaffDao.find(hql,page.getCurrentPage(),page.getPageSize());
		return vclist;
	}
	
	@Override
	public long findvOldStaffsListCount(SearchBean se) {
		// TODO Auto-generated method stub
		String h = se.getHql(vs);
		String hql = h + " group by entity.fileNum";
		hql = hql.replace("fileName", "HName");
		hql = hql.replace("fileFileDate", "fileDate");
		hql = hql.replace("name", "SName");
		List<VOldStaff> vclist = voldStaffDao.find(hql);
		return vclist.size();
	}

	@Override
	public List<VChronic> getVChronicList(SearchBean bean, Page<VChronic> page) {
		String h = bean.getHql(vc);
		String hql = h + " order by entity.fileNum desc";
		List<VChronic> vclist = vchronicDao.find(hql,page.getCurrentPage(),page.getPageSize());
		return vclist;
	}

	@Override
	public long findVChronicListCount(SearchBean se) {
		String h = se.getHql(vc);
		String hql ="select count(entity.healthFileId) " + h ;
		return vchronicDao.count(hql);
	}
	
	  public HealthFileSingleCloud.HealthFile getHealthfileCloudById(int id){
		  String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/healthFile/getSingle";
		  Map<String,String> params = new HashMap<String, String>();
		  params.put("id", id+"");
		  String resultJson =  MyHttpClient.sendHttpPost(url, params);
		  HealthFileSingleCloud healthFileSingleCloud = JSON.parseObject(resultJson,HealthFileSingleCloud.class);
		  return healthFileSingleCloud.getItem();
	}
}
