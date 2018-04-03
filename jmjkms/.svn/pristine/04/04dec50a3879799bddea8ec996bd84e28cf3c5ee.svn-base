package com.jmjk.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jmjk.action.base.BaseAction;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.THealthFile;
import com.jmjk.entity.view.VOldStaff;
import com.jmjk.enums.Admin_IsHead;
import com.jmjk.iservice.IHealthManagerService;
import com.jmjk.pojo.EcgCloud;
import com.jmjk.pojo.EcgCloud.Ecg;
import com.jmjk.pojo.HealthFileSingleCloud;
import com.jmjk.pojo.UrineCloud;
import com.jmjk.pojo.UrineCloud.Urine;
import com.jmjk.pojo.XKHealthMachineCloud;
import com.jmjk.pojo.XKHealthMachineCloud.XKHealthMachine;
import com.jmjk.service.EcgService;
import com.jmjk.service.HealthFileService;
import com.jmjk.service.UrineService;
import com.jmjk.utils.GetSessionPerson;
import com.jmjk.utils.MyHttpClient;
import com.jmjk.utils.Page;
import com.jmjk.utils.TypeConverter;
import com.jmjk.utils.WebXMLParameter;

@Component
@Scope("prototype")
@Action(value = "EcgAction", results = {
		@Result(name = "getList", location = "/jsp/healthManager/ecg/main.jsp"), //心电列表页  
		@Result(name = "getListByCX", location = "/jsp/healthManager/ecg/main.jsp"), //心电列表页 -查询 
		@Result(name = "showDetail", location = "/jsp/healthManager/ecg/detail.jsp"),  //心电详情页
		@Result(name = "getListFromCloud", location = "/jsp/healthManager/healthAdvice/ecg/main.jsp"),
		@Result(name = "getListByCXFromCloud", location = "/jsp/healthManager/healthAdvice/ecg/main.jsp"),  
		@Result(name = "showDetailFromCloud", location = "/jsp/healthManager/healthAdvice/ecg/detail.jsp"),  
		})
public class EcgAction extends BaseAction{

	@Autowired
	private EcgService ecgService;
	@Autowired
	private HealthFileService healthFileService;
	@Autowired
	private IHealthManagerService healthManagerService;
	private String avf ;
	private String avl ;
	private String avr ;
	private int devID;
	private String diagnosis;
	private String duration;
	private String ecgLeadList;
	private int hr;//心率
	private int id2;
	private String idCard;
	private String l;
	private String ll;
	private String lll;
	private String meaTime;
	private int paxis;
	private int pr;
	private int qrs;
	private int qrsaxis;
	private int qt;
	private int qtc;
	private int rv5;
	private String sample;
	private int sv1;
	private int taxis;
	private String v1;
	private String v2;
	private String v3;
	private String v4;
	private String v5;
	private String v6;
	
	private String appKey = WebXMLParameter.getParamByappkey("appkey1");
	private static final long serialVersionUID = 1L;
	private int healthFileId;
	private THealthFile localHealthFile;
	private int cp = 1;
	private Date startTime;
	private Date endTime;
	private String start;
	private String end;
	private String strSFZH;//身份证号
	private String name;
	private Long id;
	private int state = 2;// 档案状态
	private String resultJson;
	private int currentPage = 1;
	private String pageHtml;
	private List<Ecg> theItems;
	private EcgCloud ecgCloud;
	private Ecg ecg;
	// 用于数据总数
	private int pagenumT = 0;
	private int pageSize;
	private HealthFileSingleCloud.HealthFile healthFile;
	
	//用于判断是否嵌入到门诊接诊记录页面 false:没有嵌入，true:嵌入
	private boolean embeded = false;
	
	
	public boolean isEmbeded() {
		return embeded;
	}
	public void setEmbeded(boolean embeded) {
		this.embeded = embeded;
	}
	public HealthFileSingleCloud.HealthFile getHealthFile() {
		return healthFile;
	}
	public void setHealthFile(HealthFileSingleCloud.HealthFile healthFile) {
		this.healthFile = healthFile;
	}
	public THealthFile getLocalHealthFile() {
		return localHealthFile;
	}
	public void setLocalHealthFile(THealthFile localHealthFile) {
		this.localHealthFile = localHealthFile;
	}
	public int getHealthFileId() {
		return healthFileId;
	}
	public void setHealthFileId(int healthFileId) {
		this.healthFileId = healthFileId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public EcgService getEcgService() {
		return ecgService;
	}
	public void setEcgService(EcgService ecgService) {
		this.ecgService = ecgService;
	}
	public HealthFileService getHealthFileService() {
		return healthFileService;
	}
	public void setHealthFileService(HealthFileService healthFileService) {
		this.healthFileService = healthFileService;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	
	public String getStrSFZH() {
		return strSFZH;
	}
	public void setStrSFZH(String strSFZH) {
		this.strSFZH = strSFZH;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getResultJson() {
		return resultJson;
	}
	public void setResultJson(String resultJson) {
		this.resultJson = resultJson;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public String getPageHtml() {
		return pageHtml;
	}
	public void setPageHtml(String pageHtml) {
		this.pageHtml = pageHtml;
	}
	public int getPagenumT() {
		return pagenumT;
	}
	public void setPagenumT(int pagenumT) {
		this.pagenumT = pagenumT;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public IHealthManagerService getHealthManagerService() {
		return healthManagerService;
	}
	public void setHealthManagerService(IHealthManagerService healthManagerService) {
		this.healthManagerService = healthManagerService;
	}
	public List<Ecg> getTheItems() {
		return theItems;
	}
	public void setTheItems(List<Ecg> theItems) {
		this.theItems = theItems;
	}
	public EcgCloud getEcgCloud() {
		return ecgCloud;
	}
	public void setEcgCloud(EcgCloud ecgCloud) {
		this.ecgCloud = ecgCloud;
	}
	public Ecg getEcg() {
		return ecg;
	}
	public void setEcg(Ecg ecg) {
		this.ecg = ecg;
	}
	
	public String getAvf() {
		return avf;
	}
	public void setAvf(String avf) {
		this.avf = avf;
	}
	public String getAvl() {
		return avl;
	}
	public void setAvl(String avl) {
		this.avl = avl;
	}
	public String getAvr() {
		return avr;
	}
	public void setAvr(String avr) {
		this.avr = avr;
	}
	public int getDevID() {
		return devID;
	}
	public void setDevID(int devID) {
		this.devID = devID;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getEcgLeadList() {
		return ecgLeadList;
	}
	public void setEcgLeadList(String ecgLeadList) {
		this.ecgLeadList = ecgLeadList;
	}
	public int getHr() {
		return hr;
	}
	public void setHr(int hr) {
		this.hr = hr;
	}
	public int getId2() {
		return id2;
	}
	public void setId2(int id2) {
		this.id2 = id2;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getL() {
		return l;
	}
	public void setL(String l) {
		this.l = l;
	}
	public String getLl() {
		return ll;
	}
	public void setLl(String ll) {
		this.ll = ll;
	}
	public String getLll() {
		return lll;
	}
	public void setLll(String lll) {
		this.lll = lll;
	}
	public String getMeaTime() {
		return meaTime;
	}
	public void setMeaTime(String meaTime) {
		this.meaTime = meaTime;
	}
	public int getPaxis() {
		return paxis;
	}
	public void setPaxis(int paxis) {
		this.paxis = paxis;
	}
	public int getPr() {
		return pr;
	}
	public void setPr(int pr) {
		this.pr = pr;
	}
	public int getQrs() {
		return qrs;
	}
	public void setQrs(int qrs) {
		this.qrs = qrs;
	}
	public int getQrsaxis() {
		return qrsaxis;
	}
	public void setQrsaxis(int qrsaxis) {
		this.qrsaxis = qrsaxis;
	}
	public int getQt() {
		return qt;
	}
	public void setQt(int qt) {
		this.qt = qt;
	}
	public int getQtc() {
		return qtc;
	}
	public void setQtc(int qtc) {
		this.qtc = qtc;
	}
	public int getRv5() {
		return rv5;
	}
	public void setRv5(int rv5) {
		this.rv5 = rv5;
	}
	public String getSample() {
		return sample;
	}
	public void setSample(String sample) {
		this.sample = sample;
	}
	public int getSv1() {
		return sv1;
	}
	public void setSv1(int sv1) {
		this.sv1 = sv1;
	}
	public int getTaxis() {
		return taxis;
	}
	public void setTaxis(int taxis) {
		this.taxis = taxis;
	}
	public String getV1() {
		return v1;
	}
	public void setV1(String v1) {
		this.v1 = v1;
	}
	public String getV2() {
		return v2;
	}
	public void setV2(String v2) {
		this.v2 = v2;
	}
	public String getV3() {
		return v3;
	}
	public void setV3(String v3) {
		this.v3 = v3;
	}
	public String getV4() {
		return v4;
	}
	public void setV4(String v4) {
		this.v4 = v4;
	}
	public String getV5() {
		return v5;
	}
	public void setV5(String v5) {
		this.v5 = v5;
	}
	public String getV6() {
		return v6;
	}
	public void setV6(String v6) {
		this.v6 = v6;
	}
	public String getList() {
		// 分页
		Page<EcgCloud> page = new Page<EcgCloud>();
		page.setCurrentPage(cp);
		String resultJson = "";

		//默认显示一年内的记录
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		end = sdf.format(d);
		// endTime += " 23:59:59";
		Calendar ca = Calendar.getInstance();
		ca.setTime(d);
		ca.add(Calendar.YEAR, -1);
		start = sdf.format(ca.getTime());
		startTime = TypeConverter.convertString2Date(start, "yyyy-MM-dd");
		endTime = TypeConverter.convertString2Date(end, "yyyy-MM-dd");
		localHealthFile = healthFileService.getHealthFileById(healthFileId);
		if(localHealthFile!=null){//本地老人
			if(!localHealthFile.getIdNum().equals("")){
				strSFZH = localHealthFile.getIdNum().trim();
			} else {
				strSFZH = "-1";
			}
			if(localHealthFile.getName()!=null){
				name= localHealthFile.getName();
			} else {
				name = "";
			}
		} else { //其他平台老人
//			strSFZH = "-1";
//			name="";
			
//			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(Math.abs(healthFileId));  //其他平台老人
			healthFile.setId(healthFileId);
			
			strSFZH = healthFile.getIdNum();
			name = healthFile.getName();
			
		}
		resultJson = ecgService.getList(strSFZH, start, end, page.getCurrentPage(),
				page.getPageSize());

		if (resultJson != "") {

			// 解析json
			EcgCloud ecg = JSON.parseObject(resultJson, EcgCloud.class);
			// 获取数据失败直接返回页面
			if (ecg.getCode() == 0) {
				// 解析json
				String jsonString = ecg.getPage().getResult();
				theItems = (List<Ecg>) JSONArray.parseArray(jsonString,
						Ecg.class);

				pagenumT = ecg.getPage().getTotal();
				// for (int i = 0; i < theItems.size(); i++) {
				//
				// }
			}

		}
		// //用于时间回显
		// start=TypeConverter.convertDate2String(startTime, "yyyy-MM-dd");
		// end=TypeConverter.convertDate2String(endTime, "yyyy-MM-dd");
		page.setTotalNum(pagenumT);
		page.setCurrentPage(cp);
		currentPage = page.getCurrentPage();
		this.pageHtml = page.getPage("EcgAction!getList.action?healthFileId="+healthFileId);
		if(localHealthFile==null&&healthFile!=null){
			return "getListFromCloud"; //返回 健康建议菜单下       本地老人数据页面
		}
		return "getList";
	}
	
	public String getListByCX(){
		// 分页
		Page<XKHealthMachine> page = new Page<XKHealthMachine>();
		page.setCurrentPage(cp);
		String resultJson = "";
		
		if (checkEmpty(startTime) || checkEmpty(endTime)) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date d = new Date();
			end = sdf.format(d);
			// endTime += " 23:59:59";
			Calendar ca = Calendar.getInstance();
			ca.setTime(d);
			ca.add(Calendar.YEAR, -1);
			start = sdf.format(ca.getTime());
			// startTime += " 00:00:00";
			//用于时间回显
			startTime = TypeConverter.convertString2Date(start, "yyyy-MM-dd");
			endTime = TypeConverter.convertString2Date(end, "yyyy-MM-dd");
		} else {
			start = TypeConverter.convertDate2String(startTime, "yyyy-MM-dd");
			end = TypeConverter.convertDate2String(endTime, "yyyy-MM-dd");
		}
		localHealthFile = healthFileService.getHealthFileById(healthFileId);
		if(localHealthFile!=null){//本地老人
			if(!localHealthFile.getIdNum().equals("")){
				strSFZH = localHealthFile.getIdNum().trim();
			} else {
				strSFZH = "-1";
			}
			if(localHealthFile.getName()!=null){
				name= localHealthFile.getName();
			} else {
				name = "";
			}
		} else { //其他平台老人
//			strSFZH = "-1";
//			name="";
			
//			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(Math.abs(healthFileId));  //其他平台老人
			
			strSFZH = healthFile.getIdNum();
			name = healthFile.getName();
			
		}
		resultJson = ecgService.getList(strSFZH, start, end, page.getCurrentPage(),
				page.getPageSize());
		if (resultJson != "") {

			// 解析json
			EcgCloud ecg = JSON.parseObject(resultJson, EcgCloud.class);
			// 获取数据失败直接返回页面
			if (ecg.getCode() == 0) {
				// 解析json
				String jsonString = ecg.getPage().getResult();
				theItems = (List<Ecg>) JSONArray.parseArray(jsonString,
						Ecg.class);

				pagenumT = ecg.getPage().getTotal();
				// for (int i = 0; i < theItems.size(); i++) {
				//
				// }
			}

		}
		// //用于时间回显
		// start=TypeConverter.convertDate2String(startTime, "yyyy-MM-dd");
		// end=TypeConverter.convertDate2String(endTime, "yyyy-MM-dd");
		page.setTotalNum(pagenumT);
		page.setCurrentPage(cp);
		currentPage = page.getCurrentPage();
		this.pageHtml = page.getPage("EcgAction!getListByCX.action?startTime="+start+"&endTime="+end+"&healthFileId="+healthFileId);
		if(localHealthFile==null&&healthFile!=null){
			return "getListByCXFromCloud"; //返回 健康建议菜单下       本地老人数据页面
		}
		return "getListByCX";
	}
	
	private boolean checkEmpty(String str) {
		if (str == null) {
			return true;
		} else {
			return str.length() > 0 ? false : true;
		}
	}
	
	private boolean checkEmpty(Date d) {
		return d == null ? true : false;
	}
	
	public String showDetail(){
		if (id != null) {
			String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/ecg/getSingle";
			String appkey=WebXMLParameter.getParamByappkey("appkey1");
			Map<String, String> params = new HashMap<String, String>();
		
	    	params.put("id", id+"");
	    	String result=MyHttpClient.sendHttpPost(url, params);
	    	if(null!=result&&!"".equals(result)){
		    	JSONObject obj = JSONObject.parseObject(result);
		    	int code = obj.getIntValue("code");
		    	if(code == 0){//成功
		    		String item = obj.getString("item");
		    		if(null!=item&&!"".equals(item)){
		    			JSONObject itemObj = JSONObject.parseObject(item);
			    		avf = itemObj.getString("avf");
			    		 avl = itemObj.getString("avl");
			    		 avr = itemObj.getString("avr");
			    		 devID = itemObj.getIntValue("devID");
			    		 diagnosis = itemObj.getString("diagnosis");
			    		 duration = itemObj.getString("duration");
			    		 ecgLeadList = itemObj.getString("ecgLeadList");
			    		 hr = itemObj.getIntValue("hr");//心率
			    		 id2 = itemObj.getIntValue("id");
			    		 idCard = itemObj.getString("idCard");
			    		 l = itemObj.getString("l");
			    		 ll = itemObj.getString("ll");
			    		 lll = itemObj.getString("lll");
			    		 meaTime = itemObj.getString("meaTime");
			    		 paxis = itemObj.getIntValue("paxis");
			    		 pr = itemObj.getIntValue("pr");
			    		 qrs = itemObj.getIntValue("qrs");
			    		 qrsaxis = itemObj.getIntValue("qrsaxis");
			    		 qt = itemObj.getIntValue("qt");
			    		 qtc = itemObj.getIntValue("qtc");
			    		 rv5 = itemObj.getIntValue("rv5");
			    		 sample = itemObj.getString("sample");
			    		 sv1 = itemObj.getIntValue("sv1");
			    		 taxis = itemObj.getIntValue("taxis");
			    		 v1 = itemObj.getString("v1");
			    		 v2 = itemObj.getString("v2");
			    		 v3 = itemObj.getString("v3");
			    		 v4 = itemObj.getString("v4");
			    		 v5 = itemObj.getString("v5");
			    		 v6 = itemObj.getString("v6");
		    		}
		    	}
		    }
		}
		localHealthFile = healthFileService.getHealthFileById(healthFileId);
		if(localHealthFile!=null){//本地老人
			if(!localHealthFile.getIdNum().equals("")){
				strSFZH = localHealthFile.getIdNum().trim();
			} else {
				strSFZH = "-1";
			}
			if(localHealthFile.getName()!=null){
				name= localHealthFile.getName();
			} else {
				name = "";
			}
		} else { //其他平台老人
//			strSFZH = "-1";
//			name="";
			
			healthFileId=Math.abs(healthFileId);
			healthFile = healthManagerService.getHealthfileCloudById(healthFileId);  //其他平台老人
			
			strSFZH = healthFile.getIdNum();
			name = healthFile.getName();
			
		}
		if(localHealthFile==null&&healthFile!=null){
			return "showDetailFromCloud"; //返回 健康建议菜单下       本地老人数据页面
		}
		return "showDetail";
	}
}
