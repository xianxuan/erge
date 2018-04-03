package com.jmjk.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jmjk.iservice.IEcgService;
import com.jmjk.iservice.IUrineService;
import com.jmjk.pojo.UrineCloud.Urine;
import com.jmjk.utils.MyHttpClient;
import com.jmjk.utils.WebXMLParameter;

@Controller("ecgService")
public class EcgService implements IEcgService {

	@Override
	public String getList(String strSFZH, String startTime, String endTime,
			Integer currentPage, Integer pageSize) {
		// TODO Auto-generated method stub
		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/ecg/findDataByAll";
		String appkey=WebXMLParameter.getParamByappkey("appkey1");
		Map<String, String> params = new HashMap<String, String>();
	
    	params.put("IDNumbers", strSFZH);
//		params.put("appKey", appkey+"");
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

//	@Override
//	public Urine getDetail(Long id) {
//		// TODO Auto-generated method stub
//		Urine urine = null;
//		String url=WebXMLParameter.getParamValue("ip_port")+"/healthy/urine/getSingle";
//		String appkey=WebXMLParameter.getParamByappkey("appkey1");
//		Map<String, String> params = new HashMap<String, String>();
//	
//		params.put("id", id+"");
//		//调用封装好的httpclient 请求方法,并返回json数据串
//		String result=MyHttpClient.sendHttpPost(url, params);	
//		if(result!=null&&!result.equals("")){
//			JSONObject objResult = JSONObject.parseObject(result);
//			if(objResult.getIntValue("code") == 0){
////				JSONObject objItem = objResult.getJSONObject("item");
//				String objItem = objResult.getString("item");
//				urine = JSON.parseObject(objItem, Urine.class);
//			}
//		}
//		System.out.println(urine.toString());
//		return urine ;	
//	}

//	public static void main(String[] args){
//		String url = "http://222.222.218.52:8185/healthy/urine/findDataByAll";
//		Map<String, String> params = new HashMap<String, String>();
//		params.put("IDNumbers", "202423194303152825");
////		params.put("appKey", appkey+"");
//    	params.put("startTime", "2012-01-01 00:00:00");
//    	params.put("endTime", "2017-12-31 23:59:59");
//		params.put("currentPage", 1+"");
//		params.put("pageSize", 10+"");
//		String s = MyHttpClient.sendHttpPost(url, params);
//		System.out.println(s);
//	}
}
