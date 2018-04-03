package com.jmjk.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;




import com.jmjk.dao.RecoveryPlanDao;
import com.jmjk.dao.CountDao;
import com.jmjk.dao.HosOldChronicDao;
import com.jmjk.entity.TCount;
import com.jmjk.entity.TRecoveryPlan;
import com.jmjk.entity.TRecoveryScheme;
import com.jmjk.enums.IS_DELETE;
import com.jmjk.iservice.IStatisticsService;
import com.jmjk.utils.MyHttpClient;
import com.jmjk.utils.TypeConverter;
import com.jmjk.utils.WebXMLParameter;

/**
 * 统计分析接口实现
 * 
 * @author liuyichang
 *
 */
@Controller("statisticsService")
public class StatisticsService implements IStatisticsService {

	@Autowired
	private HosOldChronicDao hosOldChronicDao;
	@Autowired
	private CountDao countDao;
	@Autowired
	private RecoveryPlanDao recoveryPlanDao;
	@Override
	public List<Long> getComHosCount(List<Object> communityHospitalIdList) {
		
	    String a = ",";
		String str = TypeConverter.convertList2String(communityHospitalIdList,
				a);
		
		//sqlAllCount 得到所选社区总人数的SQL语句
		String sqlAllCount = "select count(distinct total.healthFileId) from VHosOldChronic total where total.communityHospitalId in (" +str+ ") "
				+ "and total.healthFileId is not null and total.healthFileType="
				+ 2;
		//sqlOldCount 得到所选社区老年人数（55岁以上）的SQL语句
		String sqlOldCount = "select count(distinct age.healthFileId) from VHosOldChronic age where age.communityHospitalId in (" +str+ ") "
				+ "and age.healthFileId is not null and age.healthFileType="
				+ 2
				+ "and age.age>"
				+ 55;
		//sqlIllOldCount 得到所选社区老年患病人数（55岁以上）的SQL语句
		String sqlIllOldCount = "select count(distinct disease.healthFileId) from VHosOldChronic disease where disease.communityHospitalId in (" +str+ ")"
				+ "and disease.healthFileId is not null and disease.healthFileType="
				+ 2 + "and disease.chronicDiseaseId is not null and disease.age>" + 55;
		long allCount=hosOldChronicDao.count(sqlAllCount);
		long oldCount=hosOldChronicDao.count(sqlOldCount);
		long illOldCount=hosOldChronicDao.count(sqlIllOldCount);
		List<Long> listAllCount = new ArrayList<Long>();
		listAllCount.add(allCount);
		listAllCount.add(oldCount);
		listAllCount.add(illOldCount);
		return listAllCount;
	}

	@Override
	public List<TCount> getRecentCount(List<Object> hosId,
			List<Object> diseaseName) {
		String a = ",";
		String hosIdString = TypeConverter.convertList2String(hosId,
				a);
		String diseaseNameString = TypeConverter.convertList2String(diseaseName,
				a);
		String hql="from TCount tc where tc.TCommunityHospital.communityHospitalId in ("+hosIdString+")"
				+ "and tc.disease in ("+diseaseNameString+") order by tc.yearMounth desc";
		/*for(Object list : diseaseName)
		{
			hql+="'"+list+"',";
		}
		hql = hql.substring(0, hql.length() - 1);
		hql+=")";*/
		return countDao.find(hql);
	}

		@Override
		public List<TRecoveryPlan> getAllStatisticalAnalysisForExport(int hosId) {
			Map<String, Object> params=new HashMap<String, Object>();
			params.put("hosId", hosId);
			String hql="";
			if(hosId==-1){
				hql="from TRecoveryPlan trp where trp.idDelete="+IS_DELETE.no_Delete.getValue();
			}
			else{
				 hql = "from TRecoveryPlan trp where trp.communityHospitalId=:hosId";
				hql +=" and trp.idDelete="+IS_DELETE.no_Delete.getValue();
			}
			List<TRecoveryPlan> trp = recoveryPlanDao.find(hql,params);
			return trp;
		}

		@Override
		public String getDeviceStatics(String ids,String devType,String communityId,String startTime,String endTime) {
			// TODO Auto-generated method stub
			String para = "ids=1,2,13&devType=4&communityId=5&startTime=2016-09-01 00:00:00&endTime=2016-10-01 00:00:00";
			//String url = "http://222.222.218.52:8185/healthy/devices/getDevicesStatistics";
			StringBuffer url=new StringBuffer();
	        url.append(WebXMLParameter.getParamValue("ip_port"));
	        url.append("/healthy/devices/getDevicesStatistics");
			String appkey=WebXMLParameter.getParamByappkey("appkey1");
			Map<String , String> params = new LinkedHashMap<String, String>();
			params.put("ids", ids);
			params.put("devType", devType);
			params.put("communityId", communityId);
			params.put("startTime",startTime);
			params.put("endTime",endTime);
			params.put("appKey", appkey);
			String str=MyHttpClient.sendHttpPost(url.toString(), params);
			  System.out.println(str);
			return str;
		}

		@Override
		public String getTotalNumDevice(String ids) {
			//String url = "http://222.222.218.52:8185/healthy/devices/findDataNum";
		    StringBuffer url=new StringBuffer();
            url.append(WebXMLParameter.getParamValue("ip_port"));
            url.append("/healthy/devices/findDataNum");
		    String appkey=WebXMLParameter.getParamByappkey("appkey1");
			Map<String , String> params = new LinkedHashMap<String, String>();
			params.put("ids", ids);
			params.put("appKey", appkey);
			 String str=MyHttpClient.sendHttpPost(url.toString(), params);
		        System.out.println(str);
			return str;
		}

}
