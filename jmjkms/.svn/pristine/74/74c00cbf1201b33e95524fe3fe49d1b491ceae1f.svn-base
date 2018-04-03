package com.jmjk.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import sun.rmi.runtime.Log;

import com.alibaba.fastjson.JSON;
import com.jmjk.dao.OldStaffHosDao;
import com.jmjk.entity.TOldStaffHos;
import com.jmjk.entity.view.VOldStaff;
import com.jmjk.enums.Admin_IsHead;
import com.jmjk.iservice.IHealthAlarmService;
import com.jmjk.iservice.IXKHealthMachineService;
import com.jmjk.pojo.Ids;
import com.jmjk.pojo.Ids.healthFileId;
import com.jmjk.utils.ListToJson;
import com.jmjk.utils.MyHttpClient;
import com.jmjk.utils.TypeConverter;
import com.jmjk.utils.WebXMLParameter;
/**
 * 熙康中医一体机-----中医治未病
 * @author 张晓光&赖清发&朱德江
 *
 */
@Controller("xkHealthMachineService")
public class XKHealthMachineService  implements IXKHealthMachineService{

	@Autowired
	private OldStaffHosDao oldStaffHosDao;
	@Autowired
	private HealthFileService healthFileService;
	@Autowired
	private StaffService staffService;
	  
	private int[] ids;
	private List<String> interfaceHealthFileList =new ArrayList<String>();
	private List<String> appUserID =new ArrayList<String>();
	


	@Override
	public String getXKHealthMachineById(Long id) {
		// TODO Auto-generated method stub
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/xkHealthMachine/getSingle";
		String appkey=WebXMLParameter.getParamByappkey("appkey1");
		Map<String, String> params = new HashMap<String, String>();
	
//    	params.put("appUserID", appUserID);
//		params.put("appKey", appkey+"");
//		params.put("startTime", TypeConverter.convertDate2String(startTime, "yyyy-MM-dd HH:mm:ss"));
//		params.put("endTime", TypeConverter.convertDate2String(endTime, "yyyy-MM-dd HH:mm:ss"));
//		params.put("currentPage", currentPage+"");
		params.put("id", id+"");
		//调用封装好的httpclient 请求方法,并返回json数据串
		String resultJson=MyHttpClient.sendHttpPost(url, params);	
		return resultJson ;	
	}



	@Override
	public String getXKHealthMachineList(String IDNumbers, String JCXM,
			Integer currentPage, Integer pageSize, String startTime,
			String endTime, String appUserID) {
		// TODO Auto-generated method stub
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/xkHealthMachine/findDataByAll";
		String appkey=WebXMLParameter.getParamByappkey("appkey1");
		Map<String, String> params = new HashMap<String, String>();
	
    	params.put("IDNumbers", IDNumbers);
//		params.put("appKey", appkey+"");
    	if(JCXM!=null&&!JCXM.equals("")){
    		params.put("JCXM", "%"+JCXM+"%");
    	}
    	if(startTime!=null&&!startTime.equals("")){
    		params.put("startTime", startTime+" 00:00:00");
    	}
    	if(endTime!=null&&!endTime.equals("")){
    		params.put("endTime", endTime+" 23:59:59");
    	}
		params.put("currentPage", currentPage+"");
		params.put("pageSize", pageSize+"");
		//调用封装好的httpclient 请求方法,并返回json数据串
		String resultJson=MyHttpClient.sendHttpPost(url, params);
		return resultJson ;	
	}

	
	
}
