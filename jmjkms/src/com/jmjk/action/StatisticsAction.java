package com.jmjk.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import oracle.net.aso.i;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jmjk.action.base.BaseAction;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.TCount;
import com.jmjk.entity.TRecoveryPlan;
import com.jmjk.entity.view.VChronic;
import com.jmjk.entity.view.VHealthStaff;
import com.jmjk.pojo.Device;
import com.jmjk.pojo.DeviceType;
import com.jmjk.service.CommunityHospitalGroupService;
import com.jmjk.service.CommunityHospitalService;
import com.jmjk.service.HealthFileService;
import com.jmjk.service.StatisticsService;
import com.jmjk.utils.WebXMLParameter;
import com.opensymphony.xwork2.ActionContext;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 统计分析ACTION
 * 
 * @author liuyichang 2016-8-5
 */
@Component
@Scope("prototype")
@Action(value = "statisticsAction", results = {
        // 跳转到社区医院统计分析页
        @Result(name = "staticicsListBySuperAdmin", location = "/jsp/Statistics/admin_group/getHosBySuperAdmin.jsp"),
        @Result(name = "staticticsList", location = "/jsp/Statistics/getComHos.jsp"),
        @Result(name = "staticticsListRe", location = "/jsp/Statistics/getComHosRe.jsp"),
        // 选择医院后跳转到社区医院统计分析页
        @Result(name = "getStatisticsListSA", location = "/jsp/Statistics/admin_group/getHosBySuperAdmin.jsp"),
        @Result(name = "getStatisticsList", location = "/jsp/Statistics/getComHos.jsp"),
        // 选择疾病后的highchart
        @Result(name = "getComHosDiseaseAnalyse", location = "/jsp/Statistics/getCurrentCount.jsp"),
        @Result(name = "getComHosDiseaseAnalyseAD", location = "/jsp/Statistics/admin_group/getCurrentCountByAD.jsp"),
        // 所有医院的highchart
        @Result(name = "getAllComHosDiseaseAnalyse", location = "/jsp/Statistics/getAllComHosCount.jsp"),
        @Result(name = "getGroupDiseaseAnalyse", location = "/jsp/Statistics/admin_group/getAllComHosCountAD.jsp"),
        // 跳转到疾病状况分析页
        @Result(name = "jumpCurrentCountAD", location = "/jsp/Statistics/admin_group/getCurrentCountByAD.jsp"),
        @Result(name = "jumpCurrentCount", location = "/jsp/Statistics/getCurrentCount.jsp"),
        // 跳转到所有医院的疾病状况分析页
        @Result(name = "jumpALLCurrentCount", location = "/jsp/Statistics/getAllComHosCount.jsp"),
        @Result(name = "jumpALLCurrentCountAD", location = "/jsp/Statistics/admin_group/getAllComHosCountAD.jsp"),
        // 跳转到设备统计分析页
        @Result(name = "jumpDeviceStatisticsAD", location = "/jsp/Statistics/admin_group/deviceStatisticsAD.jsp"),
        @Result(name = "jumpDeviceStatistics", location = "/jsp/Statistics/deviceStatistics.jsp"),
        @Result(name = "jumpDeviceStatisticsRe", location = "/jsp/Statistics/deviceStatisticsRe.jsp"),
        // 设备统计分析
        @Result(name = "deviceStatisticsAD", location = "/jsp/Statistics/admin_group/deviceStatisticsAD.jsp"),
        @Result(name = "deviceStatistics", location = "/jsp/Statistics/deviceStatistics.jsp"),
        @Result(name = "deviceStatisticsRe", location = "/jsp/Statistics/deviceStatisticsRe.jsp"),
        // 当没有选择进行跳转时,进行跳转
        @Result(name = "error", location = "statisticsAction!staticticsList.action", type = "redirectAction", params = {
                "flag", "${flag}", "yiYuan", "${yiYuan}" }),
        // 没有选择时错误跳转
        @Result(name = "errorDeviceStatisticsAD", location = "/jsp/Statistics/admin_group/deviceStatisticsAD.jsp"),
        @Result(name = "errorDeviceStatistics", location = "/jsp/Statistics/deviceStatistics.jsp"),
        // 跳转到老人统计分析页
        @Result(name = "jumpOldStatisticsAD", location = "/jsp/Statistics/admin_group/oldStatisticsAD.jsp"),
        @Result(name = "jumpOldStatistics", location = "/jsp/Statistics/oldStatistics.jsp"),
        @Result(name = "jumpOldStatisticsRe", location = "/jsp/Statistics/oldStatisticsRe.jsp"),
        // 老人统计分析
        @Result(name = "oldStatisticsAD", location = "/jsp/Statistics/admin_group/oldStatisticsAD.jsp"),
        @Result(name = "oldStatistics", location = "/jsp/Statistics/oldStatistics.jsp"),
        @Result(name = "oldStatisticsRe", location = "/jsp/Statistics/oldStatisticsRe.jsp") })
public class StatisticsAction extends BaseAction {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    @Autowired
    CommunityHospitalService communityHospitalService;
    @Autowired
    StatisticsService statisticsService;
    @Autowired
    HealthFileService healthFileService;
    @Autowired
    CommunityHospitalGroupService communityHospitalGroupService;

    private List<TCommunityHospitalGroup> groupList;// 全部集团list
    private List<Object> groupIdList;// 集团id list
    private List<TCommunityHospitalGroup> selectGroups;// 所选集团
    private List<TCommunityHospital> communityHospitalList;// 全部医院LIST
    private List<Object> communityHospitalIdList;// 所选的医院IDLIST
    private List<Long> communityHospitalCount;// 根据所选医院得到统计数据
    private List<TCount> countList; // 所选社区医院疾病分析所得到的数据
    private List<Object> chronicDiseaseIdList; // 所选社区医院疾病IDLIST
    private String recent;// 最近一年、两年
    private List<TCommunityHospital> selectHospitals;// 所选社区医院实体
    private String time;// highchart中的时间
    private String cjza = "";// one 残疾障碍
    private String gxy = "";// two 高血压
    private String tnb = "";// three 糖尿病
    private String zxjsjb = "";// four 重性精神疾病
    private String gxb = "";// five 冠心病
    private String xnxgb = "";// six 心脑血管病
    private String zl = "";// seven 肿瘤
    private String mxzqgb = "";// eight 慢性支气管病
    private String diseasegxy = "";
    private String diseasecjza = "";
    private String diseasetnb = "";
    private String diseasezxjsjb = "";
    private String diseasegxb = "";
    private String diseasexnxgb = "";
    private String diseasezl = "";
    private String diseasemxzqgb = "";
    private String flag = "";// 前台校验返回值
    private String json;
    private List<Object> checkbox;
    private String jsonString;
    private String yiYuan;
    private String select;// 所选设备
    private String equipment;
    private String statistics;
    private List<Device> devicelist = new ArrayList<Device>();
    private List<DeviceType> deviceTypes = new ArrayList<DeviceType>();
    private Date oldTime = new Date();
    private int count;

    // 获得全部医院,社区负责人和社区集团专用方法
    public String staticticsList() {
        int comHosId = 0;
        // 获取当前session社区集团
        HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group1 = (TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");

        if (group1 != null) {
            // 获取真正的社区集团
            TCommunityHospitalGroup group = communityHospitalGroupService.getRealComHosGroup(group1);
            group = communityHospitalGroupService.getRealComHosGroup(group);
            communityHospitalList = communityHospitalGroupService.getComHosListByGroup(group);// 得到全部社区医院
        } else {
            TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext.getContext().getSession()
                    .get("comHospital");
            if (tCommunityHospital.getIsHead() == 0) {
                comHosId = -1;// 管理员
            } else {
                comHosId = tCommunityHospital.getCommunityHospitalId();
            }
            if (comHosId == -1) {
                groupList = communityHospitalGroupService.getAllQiYongGroups();
                // communityHospitalList =
                // communityHospitalService.getAllQiYongHos();//得到全部社区集团
            } else {
                communityHospitalIdList = null;
                communityHospitalIdList = new ArrayList<Object>();
                communityHospitalIdList.add(comHosId);
                communityHospitalList = communityHospitalService.getCommunityHospitalByID(communityHospitalIdList);
            }
        }
        if (comHosId != -1) {
            json = "[{";
            for (TCommunityHospital hos : communityHospitalList) {
                json += "\"value\":" + hos.getCommunityHospitalId() + ",\"text\":\"" + hos.getCommunityHospital()
                        + "\"},{";
            }
            json = json.substring(0, json.length() - 2);
            json += "]";
            jsonString = "0";
        } else {
            json = "[{";
            for (TCommunityHospitalGroup hosGroup : groupList) {
                json += "\"value\":" + hosGroup.getGId() + ",\"text\":\"" + hosGroup.getGroupName() + "\"},{";
            }
            json = json.substring(0, json.length() - 2);
            json += "]";
            jsonString = "0";
            return "staticicsListBySuperAdmin";
        }
        if (group1 != null) {
            return "staticticsList";
        } else {
            communityHospitalCount = statisticsService.getComHosCount(communityHospitalIdList);// 得到所选社区医院的数据
            for (Object ll : communityHospitalIdList) {
                String ids = "";
                List<VHealthStaff> vHealthStaffs = healthFileService
                        .getAllHealthFileByHospitalId(Integer.parseInt(ll.toString()));
                for (VHealthStaff v : vHealthStaffs) {
                    ids += v.getHealthFileId();
                    ids += ",";
                }
                if (ids.length() == 0) {
                    break;
                }
                ids = ids.substring(0, ids.length() - 1);
                String communityId = ll.toString();
                String fanhui = statisticsService.getTotalNumDevice(ids);
                JSONObject chushiJsonObject = JSONObject.parseObject(fanhui);
                count = count + Integer.parseInt(chushiJsonObject.getString("message"));
            }
            return "staticticsListRe";
        }
    }

    // 根据所选医院得到统计数据,系统管理员调用
    public String getStatisticsListBySuperAdmin() {

        if (groupIdList == null || groupIdList.size() == 0) {
            yiYuan = " ";
            return "error";
        }
        groupList = communityHospitalGroupService.getAllQiYongGroups();
        selectGroups = communityHospitalGroupService.getComHosGroupListByGroupIdList(groupIdList);
        communityHospitalIdList = new ArrayList<>();
        // 得到所选集团的社区医院Id
        for (TCommunityHospitalGroup grou : selectGroups) {
            List<TCommunityHospital> listHos = communityHospitalGroupService.getComHosListByGroup(grou);
            for (TCommunityHospital hosCom : listHos) {
                communityHospitalIdList.add(hosCom.getCommunityHospitalId());
            }
        }
        if (communityHospitalIdList.size() == 0) {
            long a = 0;
            communityHospitalCount = new ArrayList<>();
            communityHospitalCount.add(a);
            communityHospitalCount.add(a);
            communityHospitalCount.add(a);
        } else {
            communityHospitalCount = statisticsService.getComHosCount(communityHospitalIdList);// 得到所选社区集团的数据
        }

        json = "[{";
        for (TCommunityHospitalGroup group : groupList) {
            json += "\"value\":" + group.getGId() + ",\"text\":\"" + group.getGroupName() + "\"},{";
        }
        json = json.substring(0, json.length() - 2);
        json += "]";
        jsonString = "[{";
        if (selectGroups != null) {
            jsonString = "[{";
            for (TCommunityHospitalGroup list : selectGroups) {
                jsonString += "\"value\":" + list.getGId() + ",\"checked\":\"checked\"},{";
            }
            jsonString = jsonString.substring(0, jsonString.length() - 2);
            jsonString += "]";
        } else {
            jsonString = "0";
        }
        count = 0;
        for (Object ll : communityHospitalIdList) {
            String ids = "";
            List<VHealthStaff> vHealthStaffs = healthFileService
                    .getAllHealthFileByHospitalId(Integer.parseInt(ll.toString()));
            for (VHealthStaff v : vHealthStaffs) {
                ids += v.getHealthFileId();
                ids += ",";
            }
            if (ids.length() == 0) {
                break;
            }
            ids = ids.substring(0, ids.length() - 1);
            String communityId = ll.toString();
            String fanhui = statisticsService.getTotalNumDevice(ids);
            JSONObject chushiJsonObject = JSONObject.parseObject(fanhui);
            count = count + Integer.parseInt(chushiJsonObject.getString("message"));
        }
        return "getStatisticsListSA";
    }

    // 根据所选医院得到统计数据,只有社区集团调用
    public String getStatisticsList() {
        try {
            if (communityHospitalIdList == null || communityHospitalIdList.size() == 0) {
                yiYuan = " ";
                return "error";
            }
            // 获取社区集团
            HttpSession session = ServletActionContext.getRequest().getSession();
            TCommunityHospitalGroup group1 = (TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");

            if (group1 != null) {
                TCommunityHospitalGroup group = communityHospitalGroupService.getRealComHosGroup(group1);
                communityHospitalList = communityHospitalGroupService.getComHosListByGroup(group);
            }
            selectHospitals = communityHospitalService.getCommunityHospitalByID(communityHospitalIdList);// 得到所选社区医院实体
            communityHospitalCount = statisticsService.getComHosCount(communityHospitalIdList);// 得到所选社区医院的数据
            json = "[{";
            for (TCommunityHospital hos : communityHospitalList) {
                json += "\"value\":" + hos.getCommunityHospitalId() + ",\"text\":\"" + hos.getCommunityHospital()
                        + "\"},{";
            }
            json = json.substring(0, json.length() - 2);
            json += "]";
            jsonString = "[{";
            if (communityHospitalIdList != null) {
                jsonString = "[{";
                for (Object list : communityHospitalIdList) {
                    jsonString += "\"value\":" + list + ",\"checked\":\"checked\"},{";
                }
                jsonString = jsonString.substring(0, jsonString.length() - 2);
                jsonString += "]";
            } else {
                jsonString = "0";
            }
            count = 0;
            for (Object ll : communityHospitalIdList) {
                String ids = "";
                List<VHealthStaff> vHealthStaffs = healthFileService
                        .getAllHealthFileByHospitalId(Integer.parseInt(ll.toString()));
                for (VHealthStaff v : vHealthStaffs) {
                    ids += v.getHealthFileId();
                    ids += ",";
                }
                if (ids.length() == 0) {
                    break;
                }
                ids = ids.substring(0, ids.length() - 1);
                String communityId = ll.toString();
                String fanhui = statisticsService.getTotalNumDevice(ids);
                JSONObject chushiJsonObject = JSONObject.parseObject(fanhui);
                count = count + Integer.parseInt(chushiJsonObject.getString("message"));
            }
            return "getStatisticsList";

        } catch (Exception e) {
            // TODO: handle exception
        }
        return "getStatisticsList";
    }

    // 跳转到设备统计分析,社区集团,系统管理员,社区负责人共同调用
    public String jumpDeviceStatistics() {
        // 获取社区集团
        int comHosId = 0;
        HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group = (TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if (group != null) {
            communityHospitalList = communityHospitalGroupService.getComHosListByGroup(group);
        } else {
            TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext.getContext().getSession()
                    .get("comHospital");
            if (tCommunityHospital.getIsHead() == 0) {
                comHosId = -1;// 管理员
            } else {
                comHosId = tCommunityHospital.getCommunityHospitalId();
            }
            if (comHosId == -1) {
                groupList = communityHospitalGroupService.getAllQiYongGroups();
            } else {
                communityHospitalIdList = null;
                communityHospitalIdList = new ArrayList<Object>();
                communityHospitalIdList.add(comHosId);
                communityHospitalList = communityHospitalService.getCommunityHospitalByID(communityHospitalIdList);
            }
        }
        if (comHosId == -1) {
            json = "[{";
            for (TCommunityHospitalGroup hosGroup : groupList) {
                json += "\"value\":" + hosGroup.getGId() + ",\"text\":\"" + hosGroup.getGroupName() + "\"},{";
            }
            json = json.substring(0, json.length() - 2);
            json += "]";
            jsonString = "0";
        } else {
            json = "[{";
            for (TCommunityHospital hos : communityHospitalList) {
                json += "\"value\":" + hos.getCommunityHospitalId() + ",\"text\":\"" + hos.getCommunityHospital()
                        + "\"},{";
            }
            json = json.substring(0, json.length() - 2);
            json += "]";
            jsonString = "0";
        }
        time = "[";
        for (int i = 12 - 1; i >= 0; i--) // 获取时间
        {
            Calendar ca = Calendar.getInstance();// 得到一个Calendar的实例
            Date now = ca.getTime();
            ca.add(Calendar.MONTH, -i); // 月份减1
            Date shuju = ca.getTime(); // 结果
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM");
            time += "'" + sf.format(shuju) + "',";
        }
        time = time.substring(0, time.length() - 1);
        time += "]";
        String str = WebXMLParameter.getParamValue("devName");// 原始字符串
        String[] arrayStr = new String[] {};// 字符数组
        List list = new ArrayList<>();// list
        arrayStr = str.split(",");// 字符串转字符数组
        list = java.util.Arrays.asList(arrayStr);// 字符数组转list
        for (int i = 0; i < list.size(); i++) {
            DeviceType deviceType = new DeviceType();
            deviceType.setType((String) list.get(i));
            deviceTypes.add(deviceType);

        }
        str = WebXMLParameter.getParamValue("devCode");// 原始字符串
        arrayStr = str.split(",");// 字符串转字符数组
        list = java.util.Arrays.asList(arrayStr);// 字符数组转list
        for (int i = 0; i < list.size(); i++) {
            deviceTypes.get(i).setCode((String) list.get(i));
        }
        jsonString = "0";
        if (comHosId == -1) {
            return "jumpDeviceStatisticsAD";
        } else if (group != null) {
            return "jumpDeviceStatistics";
        } else {
            return "jumpDeviceStatisticsRe";
        }

    }

    // 设备统计分析,系统管理员调用
    public String deviceStatisticsAD() {
        communityHospitalIdList = new ArrayList<>();
        groupList = communityHospitalGroupService.getAllQiYongGroups();// 得到全部集团
        if (groupIdList == null || groupIdList.size() == 0) {
            yiYuan = " ";
            groupList = communityHospitalGroupService.getAllQiYongGroups();// 得到全部集团
            json = "[{";
            for (TCommunityHospitalGroup gro : groupList) {
                json += "\"value\":" + gro.getGId() + ",\"text\":\"" + gro.getGroupName() + "\"},{";
            }
            json = json.substring(0, json.length() - 2);
            json += "]";
            jsonString = "0";
            time = "[";
            for (int i = 12 - 1; i >= 0; i--) // 获取时间
            {
                Calendar ca = Calendar.getInstance();// 得到一个Calendar的实例
                Date now = ca.getTime();
                ca.add(Calendar.MONTH, -i); // 月份减1
                Date shuju = ca.getTime(); // 结果
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM");
                time += "'" + sf.format(shuju) + "',";
            }
            time = time.substring(0, time.length() - 1);
            time += "]";
            String str = WebXMLParameter.getParamValue("devName");// 原始字符串
            String[] arrayStr = new String[] {};// 字符数组
            List list = new ArrayList<>();// list
            arrayStr = str.split(",");// 字符串转字符数组
            list = java.util.Arrays.asList(arrayStr);// 字符数组转list
            for (int i = 0; i < list.size(); i++) {
                DeviceType deviceType = new DeviceType();
                deviceType.setType((String) list.get(i));
                deviceTypes.add(deviceType);

            }
            str = WebXMLParameter.getParamValue("devCode");// 原始字符串
            arrayStr = str.split(",");// 字符串转字符数组
            list = java.util.Arrays.asList(arrayStr);// 字符数组转list
            for (int i = 0; i < list.size(); i++) {
                deviceTypes.get(i).setCode((String) list.get(i));
            }
            jsonString = "0";
            return "errorDeviceStatisticsAD";
        }
        // 前台选择了集团
        selectGroups = communityHospitalGroupService.getComHosGroupListByGroupIdList(groupIdList);// 得到所选集团实体
        json = "[{";
        for (TCommunityHospitalGroup gro : groupList) {
            json += "\"value\":" + gro.getGId() + ",\"text\":\"" + gro.getGroupName() + "\"},{";
        }
        json = json.substring(0, json.length() - 2);
        json += "]";
        jsonString = "[{";
        if (groupIdList != null) {
            selectGroups = communityHospitalGroupService.getComHosGroupListByGroupIdList(groupIdList);
            // 得到所选集团的社区医院Id
            for (TCommunityHospitalGroup grou : selectGroups) {
                List<TCommunityHospital> listHos = communityHospitalGroupService.getComHosListByGroup(grou);
                for (TCommunityHospital hosCom : listHos) {
                    communityHospitalIdList.add(hosCom.getCommunityHospitalId());
                }
            }
            jsonString = "[{";
            for (Object list : groupIdList) {
                jsonString += "\"value\":" + list + ",\"checked\":\"checked\"},{";
            }
            jsonString = jsonString.substring(0, jsonString.length() - 2);
            jsonString += "]";
        } else {
            jsonString = "0";
        }
        time = "[";
        String startTime = "";
        String endTime = "";
        int year = 0;
        if (recent.equals("最近一年")) {
            year = 12;
        }
        if (recent.equals("最近两年")) {
            year = 24;
        }
        for (int i = year - 1; i >= 0; i--) // 获取时间
        {
            Calendar ca = Calendar.getInstance();// 得到一个Calendar的实例
            Date now = ca.getTime();
            ca.add(Calendar.MONTH, -i); // 月份减1
            Date shuju = ca.getTime(); // 结果
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM");
            time += "'" + sf.format(shuju) + "',";
        }
        time = time.substring(0, time.length() - 1);
        time += "]";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal_1 = Calendar.getInstance();// 获取当前日期
        cal_1.add(Calendar.MONTH, -0);
        cal_1.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        cal_1.set(Calendar.DAY_OF_MONTH, 1);
        // 将小时至0
        cal_1.set(Calendar.HOUR_OF_DAY, 0);
        // 将分钟至0
        cal_1.set(Calendar.MINUTE, 0);
        // 将秒至0
        cal_1.set(Calendar.SECOND, 0);
        // 将毫秒至0
        cal_1.set(Calendar.MILLISECOND, 0);
        endTime = format.format(cal_1.getTime());
        Calendar cal_2 = Calendar.getInstance();// 获取当前日期
        cal_2.add(Calendar.MONTH, -(year - 1));
        cal_2.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        cal_2.set(Calendar.DAY_OF_MONTH, 1);
        // 将小时至0
        cal_2.set(Calendar.HOUR_OF_DAY, 0);
        // 将分钟至0
        cal_2.set(Calendar.MINUTE, 0);
        // 将秒至0
        cal_2.set(Calendar.SECOND, 0);
        // 将毫秒至0
        cal_2.set(Calendar.MILLISECOND, 0);
        startTime = format.format(cal_2.getTime());
        String str = WebXMLParameter.getParamValue("devName");// 原始字符串
        String[] arrayStr = new String[] {};// 字符数组
        List list = new ArrayList<>();// list
        arrayStr = str.split(",");// 字符串转字符数组
        list = java.util.Arrays.asList(arrayStr);// 字符数组转list
        for (int i = 0; i < list.size(); i++) {
            DeviceType deviceType = new DeviceType();
            deviceType.setType((String) list.get(i));
            deviceTypes.add(deviceType);

        }
        str = WebXMLParameter.getParamValue("devCode");// 原始字符串
        arrayStr = str.split(",");// 字符串转字符数组
        list = java.util.Arrays.asList(arrayStr);// 字符数组转list
        for (int i = 0; i < list.size(); i++) {
            deviceTypes.get(i).setCode((String) list.get(i));
        }
        equipment = "[{";
        statistics = "[{";
        for (TCommunityHospitalGroup grou1 : selectGroups) {
            List<Integer> comHosIds = new ArrayList<>();
            String ids = "";
            List<TCommunityHospital> comHosLists = communityHospitalGroupService.getComHosListByGroup(grou1);
            for (TCommunityHospital hosCom : comHosLists) {
                comHosIds.add(hosCom.getCommunityHospitalId());
            }
            for (Object ll : communityHospitalIdList) {
                List<VHealthStaff> vHealthStaffs = healthFileService
                        .getAllHealthFileByHospitalId(Integer.parseInt(ll.toString()));
                for (VHealthStaff v : vHealthStaffs) {
                    ids += v.getHealthFileId();
                    ids += ",";
                }
            }
            if (ids.length() == 0) {
                equipment += "\"value\":" + grou1.getGId() + ",\"text\":\"" + grou1.getGroupName() + "\"},{";
                for (int i = 0; i < year; i++) {
                    statistics += "\"value\":" + grou1.getGId() + ",\"text\":" + 0 + "},{";
                }
                continue;
            }
            ids = ids.substring(0, ids.length() - 1);
            equipment += "\"value\":" + grou1.getGId() + ",\"text\":\"" + grou1.getGroupName() + "\"},{";
            String communityId = grou1.getGId().toString();
            String fanhui = statisticsService.getDeviceStatics(ids, select, communityId, startTime, endTime);
            JSONObject reultObject = JSONObject.parseObject(fanhui);
            JSONArray array = JSONArray.parseArray(reultObject.getString("item"));
            for (int j = year - 1; j >= 0; j--) {
                int count = 0;
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM");
                Calendar cal_3 = Calendar.getInstance();// 获取当前日期
                cal_3.add(Calendar.MONTH, -j);
                String bijiao = format.format(cal_1.getTime());
                for (int i = 0; i < array.size(); i++) {
                    JSONObject jsonObject = array.getJSONObject(i);
                    if (bijiao.equals(jsonObject.getString("month"))) {
                        count = count + Integer.parseInt(jsonObject.getString("num"));
                    }
                }
                statistics += "\"value\":" + grou1.getGId() + ",\"text\":" + count + "},{";
            }
        }
        equipment = equipment.substring(0, equipment.length() - 2);
        statistics = statistics.substring(0, statistics.length() - 2);
        equipment += "]";
        statistics += "]";
        yiYuan = "";
        return "deviceStatisticsAD";

    }

    // 设备统计分析,社区集团和社区负责人调用
    public String deviceStatistics() {
        int comHosId = 0;
        // 获取当前session社区集团
        HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group1 = (TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");

        if (group1 != null) {
            // 获取真正的社区集团
            TCommunityHospitalGroup group = communityHospitalGroupService.getRealComHosGroup(group1);
            group = communityHospitalGroupService.getRealComHosGroup(group);
            communityHospitalList = communityHospitalGroupService.getComHosListByGroup(group);// 得到全部社区医院
        } else {
            TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext.getContext().getSession()
                    .get("comHospital");
            comHosId = tCommunityHospital.getCommunityHospitalId();
            communityHospitalIdList = null;
            communityHospitalIdList = new ArrayList<Object>();
            communityHospitalIdList.add(comHosId);
            communityHospitalList = communityHospitalService.getCommunityHospitalByID(communityHospitalIdList);

        }

        if (communityHospitalIdList == null || communityHospitalIdList.size() == 0) {
            yiYuan = " ";
            communityHospitalList = communityHospitalService.getAllQiYongHos();// 得到全部社区医院
            json = "[{";
            for (TCommunityHospital hos : communityHospitalList) {
                json += "\"value\":" + hos.getCommunityHospitalId() + ",\"text\":\"" + hos.getCommunityHospital()
                        + "\"},{";
            }
            json = json.substring(0, json.length() - 2);
            json += "]";
            jsonString = "0";
            time = "[";
            for (int i = 12 - 1; i >= 0; i--) // 获取时间
            {
                Calendar ca = Calendar.getInstance();// 得到一个Calendar的实例
                Date now = ca.getTime();
                ca.add(Calendar.MONTH, -i); // 月份减1
                Date shuju = ca.getTime(); // 结果
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM");
                time += "'" + sf.format(shuju) + "',";
            }
            time = time.substring(0, time.length() - 1);
            time += "]";
            String str = WebXMLParameter.getParamValue("devName");// 原始字符串
            String[] arrayStr = new String[] {};// 字符数组
            List list = new ArrayList<>();// list
            arrayStr = str.split(",");// 字符串转字符数组
            list = java.util.Arrays.asList(arrayStr);// 字符数组转list
            for (int i = 0; i < list.size(); i++) {
                DeviceType deviceType = new DeviceType();
                deviceType.setType((String) list.get(i));
                deviceTypes.add(deviceType);

            }
            str = WebXMLParameter.getParamValue("devCode");// 原始字符串
            arrayStr = str.split(",");// 字符串转字符数组
            list = java.util.Arrays.asList(arrayStr);// 字符数组转list
            for (int i = 0; i < list.size(); i++) {
                deviceTypes.get(i).setCode((String) list.get(i));
            }
            jsonString = "0";
            return "errorDeviceStatistics";
        }
        selectHospitals = communityHospitalService.getCommunityHospitalByID(communityHospitalIdList);// 得到所选社区医院实体
        json = "[{";
        for (TCommunityHospital hos : communityHospitalList) {
            json += "\"value\":" + hos.getCommunityHospitalId() + ",\"text\":\"" + hos.getCommunityHospital() + "\"},{";
        }
        json = json.substring(0, json.length() - 2);
        json += "]";
        jsonString = "[{";
        if (communityHospitalIdList != null) {
            jsonString = "[{";
            for (Object list : communityHospitalIdList) {
                jsonString += "\"value\":" + list + ",\"checked\":\"checked\"},{";
            }
            jsonString = jsonString.substring(0, jsonString.length() - 2);
            jsonString += "]";
        } else {
            jsonString = "0";
        }
        time = "[";
        String startTime = "";
        String endTime = "";
        int year = 0;
        if (recent.equals("最近一年")) {
            year = 12;
        }
        if (recent.equals("最近两年")) {
            year = 24;
        }
        for (int i = year - 1; i >= 0; i--) // 获取时间
        {
            Calendar ca = Calendar.getInstance();// 得到一个Calendar的实例
            Date now = ca.getTime();
            ca.add(Calendar.MONTH, -i); // 月份减1
            Date shuju = ca.getTime(); // 结果
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM");
            time += "'" + sf.format(shuju) + "',";
        }
        time = time.substring(0, time.length() - 1);
        time += "]";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cal_1 = Calendar.getInstance();// 获取当前日期
        cal_1.add(Calendar.MONTH, -0);
        cal_1.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        cal_1.set(Calendar.DAY_OF_MONTH, 1);
        // 将小时至0
        cal_1.set(Calendar.HOUR_OF_DAY, 0);
        // 将分钟至0
        cal_1.set(Calendar.MINUTE, 0);
        // 将秒至0
        cal_1.set(Calendar.SECOND, 0);
        // 将毫秒至0
        cal_1.set(Calendar.MILLISECOND, 0);
        endTime = format.format(cal_1.getTime());
        Calendar cal_2 = Calendar.getInstance();// 获取当前日期
        cal_2.add(Calendar.MONTH, -(year - 1));
        cal_2.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        cal_2.set(Calendar.DAY_OF_MONTH, 1);
        // 将小时至0
        cal_2.set(Calendar.HOUR_OF_DAY, 0);
        // 将分钟至0
        cal_2.set(Calendar.MINUTE, 0);
        // 将秒至0
        cal_2.set(Calendar.SECOND, 0);
        // 将毫秒至0
        cal_2.set(Calendar.MILLISECOND, 0);
        startTime = format.format(cal_2.getTime());
        String str = WebXMLParameter.getParamValue("devName");// 原始字符串
        String[] arrayStr = new String[] {};// 字符数组
        List list = new ArrayList<>();// list
        arrayStr = str.split(",");// 字符串转字符数组
        list = java.util.Arrays.asList(arrayStr);// 字符数组转list
        for (int i = 0; i < list.size(); i++) {
            DeviceType deviceType = new DeviceType();
            deviceType.setType((String) list.get(i));
            deviceTypes.add(deviceType);

        }
        str = WebXMLParameter.getParamValue("devCode");// 原始字符串
        arrayStr = str.split(",");// 字符串转字符数组
        list = java.util.Arrays.asList(arrayStr);// 字符数组转list
        for (int i = 0; i < list.size(); i++) {
            deviceTypes.get(i).setCode((String) list.get(i));
        }
        equipment = "[{";
        statistics = "[{";
        for (Object ll : communityHospitalIdList) {
            String ids = "";
            List<VHealthStaff> vHealthStaffs = healthFileService
                    .getAllHealthFileByHospitalId(Integer.parseInt(ll.toString()));
            for (VHealthStaff v : vHealthStaffs) {
                ids += v.getHealthFileId();
                ids += ",";
            }
            if (ids.length() == 0) {
                equipment += "\"value\":" + ll
                        + ",\"text\":\"" + communityHospitalService
                                .getCommunityHospitalById(Integer.parseInt(ll.toString())).getCommunityHospital()
                        + "\"},{";
                for (int i = 0; i < year; i++) {
                    statistics += "\"value\":" + ll + ",\"text\":" + 0 + "},{";
                }
                continue;
            }
            ids = ids.substring(0, ids.length() - 1);
            equipment += "\"value\":" + ll + ",\"text\":\"" + communityHospitalService
                    .getCommunityHospitalById(Integer.parseInt(ll.toString())).getCommunityHospital() + "\"},{";
            String communityId = ll.toString();
            String fanhui = statisticsService.getDeviceStatics(ids, select, communityId, startTime, endTime);
            JSONObject reultObject = JSONObject.parseObject(fanhui);
            JSONArray array = JSONArray.parseArray(reultObject.getString("item"));
            for (int j = year - 1; j >= 0; j--) {
                int count = 0;
                SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM");
                Calendar cal_3 = Calendar.getInstance();// 获取当前日期
                cal_3.add(Calendar.MONTH, -j);
                String bijiao = format.format(cal_1.getTime());
                for (int i = 0; i < array.size(); i++) {
                    JSONObject jsonObject = array.getJSONObject(i);
                    if (bijiao.equals(jsonObject.getString("month"))) {
                        count = count + Integer.parseInt(jsonObject.getString("num"));
                    }
                }
                statistics += "\"value\":" + ll + ",\"text\":" + count + "},{";
            }

        }
        equipment = equipment.substring(0, equipment.length() - 2);
        statistics = statistics.substring(0, statistics.length() - 2);
        equipment += "]";
        statistics += "]";
        yiYuan = "";
        if (comHosId == -1) {
            return "deviceStatistics";
        } else {
            return "deviceStatisticsRe";
        }

    }

    public String jumpOldStatistics() {
        int comHosId = 0;
        HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group1 = (TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if (group1 != null) {
            TCommunityHospitalGroup group = communityHospitalGroupService.getRealComHosGroup(group1);
            communityHospitalList = communityHospitalGroupService.getComHosListByGroup(group);
        } else {
            TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext.getContext().getSession()
                    .get("comHospital");
            if (tCommunityHospital.getIsHead() == 0) {
                comHosId = -1;// 管理员
            } else {
                comHosId = tCommunityHospital.getCommunityHospitalId();
            }
            if (comHosId == -1) {
                groupList = communityHospitalGroupService.getAllQiYongGroups();// 得到全部社区集团
            } else {
                communityHospitalIdList = null;
                communityHospitalIdList = new ArrayList<Object>();
                communityHospitalIdList.add(comHosId);
                communityHospitalList = communityHospitalService.getCommunityHospitalByID(communityHospitalIdList);
            }
        }

        json = "[{";
        if (comHosId == -1) {
            for (TCommunityHospitalGroup gro : groupList) {
                json += "\"value\":" + gro.getGId() + ",\"text\":\"" + gro.getGroupName() + "\"},{";
            }
        } else {
            for (TCommunityHospital hos : communityHospitalList) {
                json += "\"value\":" + hos.getCommunityHospitalId() + ",\"text\":\"" + hos.getCommunityHospital()
                        + "\"},{";
            }
        }
        json = json.substring(0, json.length() - 2);
        json += "]";
        jsonString = "0";
        String str = WebXMLParameter.getParamValue("devName");// 原始字符串
        String[] arrayStr = new String[] {};// 字符数组
        List list = new ArrayList<>();// list
        arrayStr = str.split(",");// 字符串转字符数组
        list = java.util.Arrays.asList(arrayStr);// 字符数组转list
        for (int i = 0; i < list.size(); i++) {
            DeviceType deviceType = new DeviceType();
            deviceType.setType((String) list.get(i));
            deviceTypes.add(deviceType);

        }
        str = WebXMLParameter.getParamValue("devCode");// 原始字符串
        arrayStr = str.split(",");// 字符串转字符数组
        list = java.util.Arrays.asList(arrayStr);// 字符数组转list
        for (int i = 0; i < list.size(); i++) {
            deviceTypes.get(i).setCode((String) list.get(i));
        }
        jsonString = "0";
        if (group1 != null) {
            return "jumpOldStatistics";
        } else if (comHosId == -1) {
            return "jumpOldStatisticsAD";
        } else {
            return "jumpOldStatisticsRe";
        }

    }

    // 社区负责人和社区集团专用
    public String oldStatistics() {
        int comHosId = 0;
        HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group = (TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if (group != null) {
            communityHospitalList = communityHospitalGroupService.getComHosListByGroup(group);
        } else {
            TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext.getContext().getSession()
                    .get("comHospital");
            if (tCommunityHospital.getIsHead() == 0) {
                comHosId = -1;// 管理员
            } else {
                comHosId = tCommunityHospital.getCommunityHospitalId();
            }
            if (comHosId == -1) {
                groupList = communityHospitalGroupService.getAllQiYongGroups();// 得到全部的社区集团
            } else {
                communityHospitalIdList = null;
                communityHospitalIdList = new ArrayList<Object>();
                communityHospitalIdList.add(comHosId);
                communityHospitalList = communityHospitalService.getCommunityHospitalByID(communityHospitalIdList);
            }
        }

        if (communityHospitalIdList == null || communityHospitalIdList.size() == 0) {
            yiYuan = " ";
            communityHospitalList = communityHospitalService.getAllQiYongHos();// 得到全部社区医院
            json = "[{";
            for (TCommunityHospital hos : communityHospitalList) {
                json += "\"value\":" + hos.getCommunityHospitalId() + ",\"text\":\"" + hos.getCommunityHospital()
                        + "\"},{";
            }
            json = json.substring(0, json.length() - 2);
            json += "]";
            jsonString = "0";
            String str = WebXMLParameter.getParamValue("devName");// 原始字符串
            String[] arrayStr = new String[] {};// 字符数组
            List list = new ArrayList<>();// list
            arrayStr = str.split(",");// 字符串转字符数组
            list = java.util.Arrays.asList(arrayStr);// 字符数组转list
            for (int i = 0; i < list.size(); i++) {
                DeviceType deviceType = new DeviceType();
                deviceType.setType((String) list.get(i));
                deviceTypes.add(deviceType);
            }
            str = WebXMLParameter.getParamValue("devCode");// 原始字符串
            arrayStr = str.split(",");// 字符串转字符数组
            list = java.util.Arrays.asList(arrayStr);// 字符数组转list
            for (int i = 0; i < list.size(); i++) {
                deviceTypes.get(i).setCode((String) list.get(i));
            }
            jsonString = "0";
            return "errorDeviceStatistics";
        }
        // communityHospitalList = communityHospitalService.getAllQiYongHos();
        selectHospitals = communityHospitalService.getCommunityHospitalByID(communityHospitalIdList);// 得到所选社区医院实体
        json = "[{";
        for (TCommunityHospital hos : communityHospitalList) {
            json += "\"value\":" + hos.getCommunityHospitalId() + ",\"text\":\"" + hos.getCommunityHospital() + "\"},{";
        }
        json = json.substring(0, json.length() - 2);
        json += "]";
        jsonString = "[{";
        if (communityHospitalIdList != null) {
            jsonString = "[{";
            for (Object list : communityHospitalIdList) {
                jsonString += "\"value\":" + list + ",\"checked\":\"checked\"},{";
            }
            jsonString = jsonString.substring(0, jsonString.length() - 2);
            jsonString += "]";
        } else {
            jsonString = "0";
        }
        String startTime = "";
        String endTime = "";
        startTime = time + "-01 00:00:00";
        String jiaoyan = time.substring(5, 7);
        if (jiaoyan.equals("12")) {
            int addYear = Integer.parseInt(time.substring(0, 4)) + 1;
            endTime = addYear + "-01-01 00:00:00";
        } else {
            int addMonth = Integer.parseInt(jiaoyan) + 1;
            endTime = time.substring(0, 4) + "-" + addMonth + "-01 00:00:00";
        }
        String str = WebXMLParameter.getParamValue("devName");// 原始字符串
        String[] arrayStr = new String[] {};// 字符数组
        List list = new ArrayList<>();// list
        arrayStr = str.split(",");// 字符串转字符数组
        list = java.util.Arrays.asList(arrayStr);// 字符数组转list
        for (int i = 0; i < list.size(); i++) {
            DeviceType deviceType = new DeviceType();
            deviceType.setType((String) list.get(i));
            deviceTypes.add(deviceType);
        }
        str = WebXMLParameter.getParamValue("devCode");// 原始字符串
        arrayStr = str.split(",");// 字符串转字符数组
        list = java.util.Arrays.asList(arrayStr);// 字符数组转list
        for (int i = 0; i < list.size(); i++) {
            deviceTypes.get(i).setCode((String) list.get(i));
        }
        equipment = "[{";
        statistics = "[{";
        for (Object ll : communityHospitalIdList) {
            String ids = "";
            List<VHealthStaff> vHealthStaffs = healthFileService
                    .getAllHealthFileByHospitalId(Integer.parseInt(ll.toString()));
            for (VHealthStaff v : vHealthStaffs) {
                ids += v.getHealthFileId();
                ids += ",";
            }
            if (ids.length() == 0) {
                continue;
            }
            ids = ids.substring(0, ids.length() - 1);
            String communityId = ll.toString();
            String fanhui = statisticsService.getDeviceStatics(ids, select, communityId, startTime, endTime);
            JSONObject reultObject = JSONObject.parseObject(fanhui);
            JSONArray array = JSONArray.parseArray(reultObject.getString("item"));
            for (int i = 0; i < array.size(); i++) {
                JSONObject jsonObject = array.getJSONObject(i);
                String name = healthFileService.getHealthFileById(Integer.parseInt(jsonObject.getString("appUserID")))
                        .getName();
                devicelist.add(new Device(jsonObject.getString("devType"), jsonObject.getString("devType"), name,
                        jsonObject.getString("num")));
            }
        }
        yiYuan = "";
        if (comHosId == -1) {
            return "oldStatistics";
        } else {
            return "oldStatisticsRe";
        }

    }

    // 系统管理员专用
    public String oldStatisticsByAD() {
        TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext.getContext().getSession()
                .get("comHospital");
        groupList = communityHospitalGroupService.getAllQiYongGroups();// 得到全部的社区集团

        if (groupIdList == null || groupIdList.size() == 0) {
            yiYuan = " ";
            groupList = communityHospitalGroupService.getAllQiYongGroups();// 得到全部的社区集团
            json = "[{";
            for (TCommunityHospitalGroup grou : groupList) {
                json += "\"value\":" + grou.getGId() + ",\"text\":\"" + grou.getGroupName() + "\"},{";
            }
            json = json.substring(0, json.length() - 2);
            json += "]";
            jsonString = "0";
            String str = WebXMLParameter.getParamValue("devName");// 原始字符串
            String[] arrayStr = new String[] {};// 字符数组
            List list = new ArrayList<>();// list
            arrayStr = str.split(",");// 字符串转字符数组
            list = java.util.Arrays.asList(arrayStr);// 字符数组转list
            for (int i = 0; i < list.size(); i++) {
                DeviceType deviceType = new DeviceType();
                deviceType.setType((String) list.get(i));
                deviceTypes.add(deviceType);
            }
            str = WebXMLParameter.getParamValue("devCode");// 原始字符串
            arrayStr = str.split(",");// 字符串转字符数组
            list = java.util.Arrays.asList(arrayStr);// 字符数组转list
            for (int i = 0; i < list.size(); i++) {
                deviceTypes.get(i).setCode((String) list.get(i));
            }
            jsonString = "0";
            return "errorDeviceStatisticsAD";
        }
        selectGroups = communityHospitalGroupService.getComHosGroupListByGroupIdList(groupIdList);// 得到所选社区集团实体
        json = "[{";
        for (TCommunityHospitalGroup grou : groupList) {
            json += "\"value\":" + grou.getGId() + ",\"text\":\"" + grou.getGroupName() + "\"},{";
        }
        json = json.substring(0, json.length() - 2);
        json += "]";
        jsonString = "[{";
        if (groupIdList != null) {
            jsonString = "[{";
            for (Object list : groupIdList) {
                jsonString += "\"value\":" + list + ",\"checked\":\"checked\"},{";
            }
            jsonString = jsonString.substring(0, jsonString.length() - 2);
            jsonString += "]";
        } else {
            jsonString = "0";
        }
        String startTime = "";
        String endTime = "";
        startTime = time + "-01 00:00:00";
        String jiaoyan = time.substring(5, 7);
        if (jiaoyan.equals("12")) {
            int addYear = Integer.parseInt(time.substring(0, 4)) + 1;
            endTime = addYear + "-01-01 00:00:00";
        } else {
            int addMonth = Integer.parseInt(jiaoyan) + 1;
            endTime = time.substring(0, 4) + "-" + addMonth + "-01 00:00:00";
        }
        String str = WebXMLParameter.getParamValue("devName");// 原始字符串
        String[] arrayStr = new String[] {};// 字符数组
        List list = new ArrayList<>();// list
        arrayStr = str.split(",");// 字符串转字符数组
        list = java.util.Arrays.asList(arrayStr);// 字符数组转list
        for (int i = 0; i < list.size(); i++) {
            DeviceType deviceType = new DeviceType();
            deviceType.setType((String) list.get(i));
            deviceTypes.add(deviceType);
        }
        str = WebXMLParameter.getParamValue("devCode");// 原始字符串
        arrayStr = str.split(",");// 字符串转字符数组
        list = java.util.Arrays.asList(arrayStr);// 字符数组转list
        for (int i = 0; i < list.size(); i++) {
            deviceTypes.get(i).setCode((String) list.get(i));
        }
        equipment = "[{";
        statistics = "[{";
        for (TCommunityHospitalGroup group1 : selectGroups) {
            List<Integer> comHosIds = new ArrayList<>();
            String ids = "";
            List<TCommunityHospital> comHosLists = communityHospitalGroupService.getComHosListByGroup(group1);
            for (TCommunityHospital hosCom : comHosLists) {
                comHosIds.add(hosCom.getCommunityHospitalId());
            }
            for (Object ll : comHosIds) {
                List<VHealthStaff> vHealthStaffs = healthFileService
                        .getAllHealthFileByHospitalId(Integer.parseInt(ll.toString()));
                for (VHealthStaff v : vHealthStaffs) {
                    ids += v.getHealthFileId();
                    ids += ",";
                }
                if (ids.length() == 0) {
                    continue;
                }
                ids = ids.substring(0, ids.length() - 1);
                String communityId = ll.toString();
                String fanhui = statisticsService.getDeviceStatics(ids, select, communityId, startTime, endTime);
                JSONObject reultObject = JSONObject.parseObject(fanhui);
                JSONArray array = JSONArray.parseArray(reultObject.getString("item"));
                for (int i = 0; i < array.size(); i++) {
                    JSONObject jsonObject = array.getJSONObject(i);
                    String name = healthFileService
                            .getHealthFileById(Integer.parseInt(jsonObject.getString("appUserID"))).getName();
                    devicelist.add(new Device(jsonObject.getString("devType"), jsonObject.getString("devType"),
                            name, jsonObject.getString("num")));
                }
            }
        }

        yiYuan = "";
        return "oldStatisticsAD";
    }

    // 跳转到疾病分析页
    public String jumpCurrentCount() {
        int comHosId = 0;
        // 获取社区集团
        HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group = (TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if (group != null) {

        } else {
            TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext.getContext().getSession()
                    .get("comHospital");

            if (tCommunityHospital.getIsHead() == 0) {
                comHosId = -1;// 管理员
            } else {
                comHosId = tCommunityHospital.getCommunityHospitalId();
            }
            if (comHosId == -1) {
                groupList = communityHospitalGroupService.getAllQiYongGroups();// 得到全部社区医院
            } else {
                communityHospitalIdList = null;
                communityHospitalIdList = new ArrayList<Object>();
                communityHospitalIdList.add(comHosId);
                communityHospitalList = communityHospitalService.getCommunityHospitalByID(communityHospitalIdList);
            }
        }

        flag = "";
        if (comHosId == -1) {
            selectGroups = communityHospitalGroupService.getComHosGroupListByGroupIdList(groupIdList);
            return "jumpCurrentCountAD";
        } else {
            if (communityHospitalIdList == null) {
                flag = " ";
                return "error";// 没有进行查询时的报错
            }
            selectHospitals = communityHospitalService.getCommunityHospitalByID(communityHospitalIdList);// 得到所选社区医院
            return "jumpCurrentCount";
        }

    }

    // 所选社区医院疾病分析
    public String getComHosDiseaseAnalyseByAD() {
        try {
            flag = "";
            if (chronicDiseaseIdList == null) {
                flag = "请选择疾病名称";
                selectGroups = communityHospitalGroupService.getComHosGroupListByGroupIdList(groupIdList);
                return "getComHosDiseaseAnalyseAD";// 没有选择疾病时的弹框
            }
            groupList = communityHospitalGroupService.getAllQiYongGroups();
            selectGroups = communityHospitalGroupService.getComHosGroupListByGroupIdList(groupIdList);
            communityHospitalIdList = new ArrayList<>();
            // 得到所选集团的社区医院Id
            for (TCommunityHospitalGroup grou : selectGroups) {
                List<TCommunityHospital> listHos = communityHospitalGroupService.getComHosListByGroup(grou);
                for (TCommunityHospital hosCom : listHos) {
                    communityHospitalIdList.add(hosCom.getCommunityHospitalId());
                }
            }
            if (communityHospitalIdList.size() > 0) {
                countList = statisticsService.getRecentCount(communityHospitalIdList, chronicDiseaseIdList);// 得到数据得实体
            } else {
                countList = new ArrayList<>();
            }
            selectGroups = communityHospitalGroupService.getComHosGroupListByGroupIdList(groupIdList);
            diseasegxy = "";
            diseasecjza = "";
            diseasetnb = "";
            diseasezxjsjb = "";
            diseasegxb = "";
            diseasexnxgb = "";
            diseasezl = "";
            diseasemxzqgb = "";
            for (Object list : chronicDiseaseIdList) {
                if (list.equals("'残疾障碍'")) {
                    diseasecjza = "残疾障碍";
                }
                if (list.equals("'高血压'")) {
                    diseasegxy = "高血压";
                }
                if (list.equals("'糖尿病'")) {
                    diseasetnb = "糖尿病";
                }
                if (list.equals("'重性精神疾病'")) {
                    diseasezxjsjb = "重性精神疾病";
                }
                if (list.equals("'冠心病'")) {
                    diseasegxb = "冠心病";
                }
                if (list.equals("'心脑血管病'")) {
                    diseasexnxgb = "心脑血管病";
                }
                if (list.equals("'肿瘤'")) {
                    diseasezl = "肿瘤";
                }
                if (list.equals("'慢性支气管病'")) {
                    diseasemxzqgb = "慢性支气管病";
                }
            }
            int year = 0;
            if (recent.equals("最近一年")) {
                year = 12;
            }
            if (recent.equals("最近两年")) {
                year = 24;
            }
            time = "[";
            for (int i = year - 1; i >= 0; i--) // 获取时间
            {
                Calendar ca = Calendar.getInstance();// 得到一个Calendar的实例
                Date now = ca.getTime();
                ca.add(Calendar.MONTH, -i); // 月份减1
                Date shuju = ca.getTime(); // 结果
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM");
                time += "'" + sf.format(shuju) + "',";

            }
            time = time.substring(0, time.length() - 1);
            time += "]";
            int one = 0;
            int two = 0;
            int three = 0;
            int four = 0;
            int five = 0;
            int six = 0;
            int seven = 0;
            int eight = 0;
            for (TCount list : countList)// 数据分类
            {
                if (one < year) {
                    if (list.getDisease().equals("残疾障碍")) {
                        cjza += "" + list.getNum() + ",";
                        one = one + 1;
                    }
                }
                if (two < year) {
                    if (list.getDisease().equals("高血压")) {
                        gxy += "" + list.getNum() + ",";
                        two = two + 1;
                    }
                }
                if (three < year) {
                    if (list.getDisease().equals("糖尿病")) {
                        tnb += "" + list.getNum() + ",";
                        three = three + 1;
                    }
                }
                if (four < year) {
                    if (list.getDisease().equals("重性精神疾病")) {
                        zxjsjb += "" + list.getNum() + ",";
                        four = four + 1;
                    }
                }
                if (five < year) {
                    if (list.getDisease().equals("冠心病")) {
                        gxb += "" + list.getNum() + ",";
                        five = five + 1;
                    }
                }
                if (six < year) {
                    if (list.getDisease().equals("心脑血管病")) {
                        xnxgb += "" + list.getNum() + ",";
                        six = six + 1;
                    }
                }
                if (seven < year) {
                    if (list.getDisease().equals("肿瘤")) {
                        zl += "" + list.getNum() + ",";
                        seven = seven + 1;
                    }
                }
                if (eight < year) {
                    if (list.getDisease().equals("慢性支气管病")) {
                        mxzqgb += "" + list.getNum() + ",";
                        eight = eight + 1;
                    }
                }
            }

            if (one < year && one > 0) {
                cjza = cjza.substring(0, cjza.length() - 1);
                cjza += "]";
                for (int i = 0; i < year - one; i++) {
                    cjza = "0," + cjza;
                }
                cjza = "[" + cjza;
            }

            if (two < year && two > 0) {
                gxy = gxy.substring(0, gxy.length() - 1);
                gxy += "]";
                for (int i = 0; i < year - two; i++) {
                    gxy = "0," + gxy;
                }
                gxy = "[" + gxy;
            }
            if (three < year && three > 0) {
                tnb = tnb.substring(0, tnb.length() - 1);
                tnb += "]";
                for (int i = 0; i < year - three; i++) {
                    tnb = "0," + tnb;
                }
                tnb = "[" + tnb;
            }
            if (four < year && four > 0) {
                zxjsjb = zxjsjb.substring(0, zxjsjb.length() - 1);
                zxjsjb += "]";
                for (int i = 0; i < year - four; i++) {
                    zxjsjb = "0," + zxjsjb;
                }
                zxjsjb = "[" + zxjsjb;
            }
            if (five < year && five > 0) {
                gxb = gxb.substring(0, gxb.length() - 1);
                gxb += "]";
                for (int i = 0; i < year - five; i++) {
                    gxb = "0," + gxb;
                }
                gxb = "[" + gxb;
            }
            if (six < year && six > 0) {
                xnxgb = xnxgb.substring(0, xnxgb.length() - 1);
                xnxgb += "]";
                for (int i = 0; i < year - six; i++) {
                    xnxgb = "0," + xnxgb;
                }
                xnxgb = "[" + xnxgb;
            }
            if (seven < year && seven > 0) {
                zl = zl.substring(0, zl.length() - 1);
                zl += "]";
                for (int i = 0; i < year - seven; i++) {
                    zl = "0," + zl;
                }
                zl = "[" + zl;
            }
            if (eight < year && eight > 0) {
                mxzqgb = mxzqgb.substring(0, mxzqgb.length() - 1);
                mxzqgb += "]";
                for (int i = 0; i < year - eight; i++) {
                    mxzqgb = "0," + mxzqgb;
                }
                mxzqgb = "[" + mxzqgb;
            }

            if("".equals(diseasegxy)){
                gxy = "[]";
            }
            else
            {
                if("".equals(gxy)){
                    gxy="[";
                    for(int m=0;m<year-1;m++){
                        gxy=gxy+"0,";
                    }
                    gxy=gxy+"0]";
                }
            }
            
            
            if("".equals(diseasecjza)){
                cjza = "[]";
            }
            else
            {
                if("".equals(cjza)){
                    cjza="[";
                    for(int m=0;m<year-1;m++){
                        cjza=cjza+"0,";
                    }
                    cjza=cjza+"0]";
                }
            }
            
            if("".equals(diseasetnb)){
                tnb = "[]";
            }
            else
            {
                if("".equals(tnb)){
                    tnb="[";
                    for(int m=0;m<year-1;m++){
                        tnb=tnb+"0,";
                    }
                    tnb=tnb+"0]";
                }
            }
            
            
            if("".equals(diseasezxjsjb)){
                zxjsjb = "[]";
            }
            else
            {
                if("".equals(zxjsjb)){
                    zxjsjb="[";
                    for(int m=0;m<year-1;m++){
                        zxjsjb=zxjsjb+"0,";
                    }
                    zxjsjb=zxjsjb+"0]";
                }
            }
            
            if("".equals(diseasegxb)){
                gxb = "[]";
            }
            else
            {
                if("".equals(gxb)){
                    gxb="[";
                    for(int m=0;m<year-1;m++){
                        gxb=gxb+"0,";
                    }
                    gxb=gxb+"0]";
                }
            }
            
            if("".equals(diseasexnxgb)){
                xnxgb = "[]";
            }
            else
            {
                if("".equals(xnxgb)){
                    xnxgb="[";
                    for(int m=0;m<year-1;m++){
                        xnxgb=xnxgb+"0,";
                    }
                    xnxgb=xnxgb+"0]";
                }
            }
            
            if("".equals(diseasezl)){
                zl = "[]";
            }
            else
            {
                if("".equals(zl)){
                    zl="[";
                    for(int m=0;m<year-1;m++){
                        zl=zl+"0,";
                    }
                    zl=zl+"0]";
                }
            }
            
            if("".equals(diseasemxzqgb)){
                mxzqgb = "[]";
            }
            else
            {
                if("".equals(mxzqgb)){
                    mxzqgb="[";
                    for(int m=0;m<year-1;m++){
                        mxzqgb=mxzqgb+"0,";
                    }
                    mxzqgb=mxzqgb+"0]";
                }
            }
            
            /*if (one == 0) {
                cjza = "[]";
            }
            if (two == 0) {
                gxy = "[]";
            }
            if (three == 0) {
                tnb = "[]";
            }
            if (four == 0) {
                zxjsjb = "[]";
            }
            if (five == 0) {
                gxb = "[]";
            }
            if (six == 0) {
                xnxgb = "[]";
            }
            if (seven == 0) {
                zl = "[]";
            }
            if (eight == 0) {
                mxzqgb = "[]";
            }*/

            return "getComHosDiseaseAnalyseAD";
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "getComHosDiseaseAnalyseAD";
    }

    // 所选社区医院疾病分析,社区负责人和社区集团调用
    public String getComHosDiseaseAnalyse() {
        try {
            flag = "";
            if (chronicDiseaseIdList == null) {
                flag = "请选择疾病名称";
                selectHospitals = communityHospitalService.getCommunityHospitalByID(communityHospitalIdList);
                return "getComHosDiseaseAnalyse";// 没有选择疾病时的弹框
            }
            countList = statisticsService.getRecentCount(communityHospitalIdList, chronicDiseaseIdList);// 得到数据得实体
            selectHospitals = communityHospitalService.getCommunityHospitalByID(communityHospitalIdList);
            diseasegxy = "";
            diseasecjza = "";
            diseasetnb = "";
            diseasezxjsjb = "";
            diseasegxb = "";
            diseasexnxgb = "";
            diseasezl = "";
            diseasemxzqgb = "";
            for (Object list : chronicDiseaseIdList) {
                if (list.equals("'残疾障碍'")) {
                    diseasecjza = "残疾障碍";
                }
                if (list.equals("'高血压'")) {
                    diseasegxy = "高血压";
                }
                if (list.equals("'糖尿病'")) {
                    diseasetnb = "糖尿病";
                }
                if (list.equals("'重性精神疾病'")) {
                    diseasezxjsjb = "重性精神疾病";
                }
                if (list.equals("'冠心病'")) {
                    diseasegxb = "冠心病";
                }
                if (list.equals("'心脑血管病'")) {
                    diseasexnxgb = "心脑血管病";
                }
                if (list.equals("'肿瘤'")) {
                    diseasezl = "肿瘤";
                }
                if (list.equals("'慢性支气管病'")) {
                    diseasemxzqgb = "慢性支气管病";
                }
            }
            int year = 0;
            if (recent.equals("最近一年")) {
                year = 12;
            }
            if (recent.equals("最近两年")) {
                year = 24;
            }
            time = "[";
            for (int i = year - 1; i >= 0; i--) // 获取时间
            {
                Calendar ca = Calendar.getInstance();// 得到一个Calendar的实例
                Date now = ca.getTime();
                ca.add(Calendar.MONTH, -i); // 月份减1
                Date shuju = ca.getTime(); // 结果
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM");
                time += "'" + sf.format(shuju) + "',";

            }
            time = time.substring(0, time.length() - 1);
            time += "]";
            int one = 0;
            int two = 0;
            int three = 0;
            int four = 0;
            int five = 0;
            int six = 0;
            int seven = 0;
            int eight = 0;
            for (TCount list : countList)// 数据分类
            {
                if (one < year) {
                    if (list.getDisease().equals("残疾障碍")) {
                        cjza += "" + list.getNum() + ",";
                        one = one + 1;
                    }
                }
                if (two < year) {
                    if (list.getDisease().equals("高血压")) {
                        gxy += "" + list.getNum() + ",";
                        two = two + 1;
                    }
                }
                if (three < year) {
                    if (list.getDisease().equals("糖尿病")) {
                        tnb += "" + list.getNum() + ",";
                        three = three + 1;
                    }
                }
                if (four < year) {
                    if (list.getDisease().equals("重性精神疾病")) {
                        zxjsjb += "" + list.getNum() + ",";
                        four = four + 1;
                    }
                }
                if (five < year) {
                    if (list.getDisease().equals("冠心病")) {
                        gxb += "" + list.getNum() + ",";
                        five = five + 1;
                    }
                }
                if (six < year) {
                    if (list.getDisease().equals("心脑血管病")) {
                        xnxgb += "" + list.getNum() + ",";
                        six = six + 1;
                    }
                }
                if (seven < year) {
                    if (list.getDisease().equals("肿瘤")) {
                        zl += "" + list.getNum() + ",";
                        seven = seven + 1;
                    }
                }
                if (eight < year) {
                    if (list.getDisease().equals("慢性支气管病")) {
                        mxzqgb += "" + list.getNum() + ",";
                        eight = eight + 1;
                    }
                }
            }

            if (one < year && one > 0) {
                cjza = cjza.substring(0, cjza.length() - 1);
                cjza += "]";
                for (int i = 0; i < year - one; i++) {
                    cjza = "0," + cjza;
                }
                cjza = "[" + cjza;
            }

            if (two < year && two > 0) {
                gxy = gxy.substring(0, gxy.length() - 1);
                gxy += "]";
                for (int i = 0; i < year - two; i++) {
                    gxy = "0," + gxy;
                }
                gxy = "[" + gxy;
            }
            if (three < year && three > 0) {
                tnb = tnb.substring(0, tnb.length() - 1);
                tnb += "]";
                for (int i = 0; i < year - three; i++) {
                    tnb = "0," + tnb;
                }
                tnb = "[" + tnb;
            }
            if (four < year && four > 0) {
                zxjsjb = zxjsjb.substring(0, zxjsjb.length() - 1);
                zxjsjb += "]";
                for (int i = 0; i < year - four; i++) {
                    zxjsjb = "0," + zxjsjb;
                }
                zxjsjb = "[" + zxjsjb;
            }
            if (five < year && five > 0) {
                gxb = gxb.substring(0, gxb.length() - 1);
                gxb += "]";
                for (int i = 0; i < year - five; i++) {
                    gxb = "0," + gxb;
                }
                gxb = "[" + gxb;
            }
            if (six < year && six > 0) {
                xnxgb = xnxgb.substring(0, xnxgb.length() - 1);
                xnxgb += "]";
                for (int i = 0; i < year - six; i++) {
                    xnxgb = "0," + xnxgb;
                }
                xnxgb = "[" + xnxgb;
            }
            if (seven < year && seven > 0) {
                zl = zl.substring(0, zl.length() - 1);
                zl += "]";
                for (int i = 0; i < year - seven; i++) {
                    zl = "0," + zl;
                }
                zl = "[" + zl;
            }
            if (eight < year && eight > 0) {
                mxzqgb = mxzqgb.substring(0, mxzqgb.length() - 1);
                mxzqgb += "]";
                for (int i = 0; i < year - eight; i++) {
                    mxzqgb = "0," + mxzqgb;
                }
                mxzqgb = "[" + mxzqgb;
            }
            if("".equals(diseasegxy)){
                gxy = "[]";
            }
            else
            {
                if("".equals(gxy)){
                    gxy="[";
                    for(int m=0;m<year-1;m++){
                        gxy=gxy+"0,";
                    }
                    gxy=gxy+"0]";
                }
            }
            
            
            if("".equals(diseasecjza)){
                cjza = "[]";
            }
            else
            {
                if("".equals(cjza)){
                    cjza="[";
                    for(int m=0;m<year-1;m++){
                        cjza=cjza+"0,";
                    }
                    cjza=cjza+"0]";
                }
            }
            
            if("".equals(diseasetnb)){
                tnb = "[]";
            }
            else
            {
                if("".equals(tnb)){
                    tnb="[";
                    for(int m=0;m<year-1;m++){
                        tnb=tnb+"0,";
                    }
                    tnb=tnb+"0]";
                }
            }
            
            
            if("".equals(diseasezxjsjb)){
                zxjsjb = "[]";
            }
            else
            {
                if("".equals(zxjsjb)){
                    zxjsjb="[";
                    for(int m=0;m<year-1;m++){
                        zxjsjb=zxjsjb+"0,";
                    }
                    zxjsjb=zxjsjb+"0]";
                }
            }
            
            if("".equals(diseasegxb)){
                gxb = "[]";
            }
            else
            {
                if("".equals(gxb)){
                    gxb="[";
                    for(int m=0;m<year-1;m++){
                        gxb=gxb+"0,";
                    }
                    gxb=gxb+"0]";
                }
            }
            
            if("".equals(diseasexnxgb)){
                xnxgb = "[]";
            }
            else
            {
                if("".equals(xnxgb)){
                    xnxgb="[";
                    for(int m=0;m<year-1;m++){
                        xnxgb=xnxgb+"0,";
                    }
                    xnxgb=xnxgb+"0]";
                }
            }
            
            if("".equals(diseasezl)){
                zl = "[]";
            }
            else
            {
                if("".equals(zl)){
                    zl="[";
                    for(int m=0;m<year-1;m++){
                        zl=zl+"0,";
                    }
                    zl=zl+"0]";
                }
            }
            
            if("".equals(diseasemxzqgb)){
                mxzqgb = "[]";
            }
            else
            {
                if("".equals(mxzqgb)){
                    mxzqgb="[";
                    for(int m=0;m<year-1;m++){
                        mxzqgb=mxzqgb+"0,";
                    }
                    mxzqgb=mxzqgb+"0]";
                }
            }

            /*if (one == 0) {
                cjza = "[]";
            }
            if (two == 0) {
                gxy = "[]";
            }
            if (three == 0) {
                tnb = "[]";
            }
            if (four == 0) {
                zxjsjb = "[]";
            }
            if (five == 0) {
                gxb = "[]";
            }
            if (six == 0) {
                xnxgb = "[]";
            }
            if (seven == 0) {
                zl = "[]";
            }
            if (eight == 0) {
                mxzqgb = "[]";
            }*/

            return "getComHosDiseaseAnalyse";
        } catch (Exception e) {
            // TODO: handle exception
        }
        return "getComHosDiseaseAnalyse";
    }

    // 跳转到全部医院疾病分析页
    public String jumpALLCurrentCount() {
        int comHosId = 0;
        HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group = (TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if (group != null) {
            selectHospitals = communityHospitalGroupService.getComHosListByGroup(group);
        } else {
            TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext.getContext().getSession()
                    .get("comHospital");
            if (tCommunityHospital.getIsHead() == 0) {
                comHosId = -1;// 管理员
            } else {
                comHosId = tCommunityHospital.getCommunityHospitalId();
            }
            if (comHosId == -1) {
                selectGroups = communityHospitalGroupService.getAllQiYongGroups();// 得到全部社区医院
                return "jumpALLCurrentCountAD";
            } else {
                communityHospitalIdList = null;
                communityHospitalIdList = new ArrayList<Object>();
                communityHospitalIdList.add(comHosId);
                selectHospitals = communityHospitalService.getCommunityHospitalByID(communityHospitalIdList);
            }
        }

        return "jumpALLCurrentCount";
    }

    // 全部社区医院疾病分析
    public String getAllGroupDiseaseAnalyse() {
        if (chronicDiseaseIdList == null) {
            flag = "请选择疾病名称";
            selectGroups = communityHospitalGroupService.getComHosGroupListByGroupIdList(groupIdList);
            return "getGroupDiseaseAnalyse";
        }
        groupList = communityHospitalGroupService.getAllQiYongGroups();
        selectGroups = communityHospitalGroupService.getComHosGroupListByGroupIdList(groupIdList);
        communityHospitalIdList = new ArrayList<>();
        // 得到所选集团的社区医院Id
        for (TCommunityHospitalGroup grou : selectGroups) {
            List<TCommunityHospital> listHos = communityHospitalGroupService.getComHosListByGroup(grou);
            for (TCommunityHospital hosCom : listHos) {
                communityHospitalIdList.add(hosCom.getCommunityHospitalId());
            }
        }
        if (communityHospitalIdList.size() > 0) {
            countList = statisticsService.getRecentCount(communityHospitalIdList, chronicDiseaseIdList);// 得到数据得实体
        } else {
            countList = new ArrayList<>();
        }
        selectGroups = communityHospitalGroupService.getComHosGroupListByGroupIdList(groupIdList);
        diseasegxy = "";
        diseasecjza = "";
        diseasetnb = "";
        diseasezxjsjb = "";
        diseasegxb = "";
        diseasexnxgb = "";
        diseasezl = "";
        diseasemxzqgb = "";
        for (Object list : chronicDiseaseIdList) {
            if (list.equals("'残疾障碍'")) {
                diseasecjza = "残疾障碍";
            }
            if (list.equals("'高血压'")) {
                diseasegxy = "高血压";
            }
            if (list.equals("'糖尿病'")) {
                diseasetnb = "糖尿病";
            }
            if (list.equals("'重性精神疾病'")) {
                diseasezxjsjb = "重性精神疾病";
            }
            if (list.equals("'冠心病'")) {
                diseasegxb = "冠心病";
            }
            if (list.equals("'心脑血管病'")) {
                diseasexnxgb = "心脑血管病";
            }
            if (list.equals("'肿瘤'")) {
                diseasezl = "肿瘤";
            }
            if (list.equals("'慢性支气管病'")) {
                diseasemxzqgb = "慢性支气管病";
            }
        }
        int year = 0;
        if (recent.equals("最近一年")) {
            year = 12;
        }
        if (recent.equals("最近两年")) {
            year = 24;
        }
        time = "[";
        for (int i = year - 1; i >= 0; i--) {
            Calendar ca = Calendar.getInstance();// 得到一个Calendar的实例
            Date now = ca.getTime();
            ca.add(Calendar.MONTH, -i); // 月份减1
            Date shuju = ca.getTime(); // 结果
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM");
            time += "'" + sf.format(shuju) + "',";

        }
        time = time.substring(0, time.length() - 1);
        time += "]";
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int five = 0;
        int six = 0;
        int seven = 0;
        int eight = 0;
        for (TCount list : countList) {
            if (one < year) {
                if (list.getDisease().equals("残疾障碍")) {
                    cjza += "" + list.getNum() + ",";
                    one = one + 1;
                }
            }
            if (two < year) {
                if (list.getDisease().equals("高血压")) {
                    gxy += "" + list.getNum() + ",";
                    two = two + 1;
                }
            }
            if (three < year) {
                if (list.getDisease().equals("糖尿病")) {
                    tnb += "" + list.getNum() + ",";
                    three = three + 1;
                }
            }
            if (four < year) {
                if (list.getDisease().equals("重性精神疾病")) {
                    zxjsjb += "" + list.getNum() + ",";
                    four = four + 1;
                }
            }
            if (five < year) {
                if (list.getDisease().equals("冠心病")) {
                    gxb += "" + list.getNum() + ",";
                    five = five + 1;
                }
            }
            if (six < year) {
                if (list.getDisease().equals("心脑血管病")) {
                    xnxgb += "" + list.getNum() + ",";
                    six = six + 1;
                }
            }
            if (seven < year) {
                if (list.getDisease().equals("肿瘤")) {
                    zl += "" + list.getNum() + ",";
                    seven = seven + 1;
                }
            }
            if (eight < year) {
                if (list.getDisease().equals("慢性支气管病")) {
                    mxzqgb += "" + list.getNum() + ",";
                    eight = eight + 1;
                }
            }
        }

        if (one < year && one > 0) {
            cjza = cjza.substring(0, cjza.length() - 1);
            cjza += "]";
            for (int i = 0; i < year - one; i++) {
                cjza = "0," + cjza;
            }
            cjza = "[" + cjza;
        }

        if (two < year && two > 0) {
            gxy = gxy.substring(0, gxy.length() - 1);
            gxy += "]";
            for (int i = 0; i < year - two; i++) {
                gxy = "0," + gxy;
            }
            gxy = "[" + gxy;
        }
        if (three < year && three > 0) {
            tnb = tnb.substring(0, tnb.length() - 1);
            tnb += "]";
            for (int i = 0; i < year - three; i++) {
                tnb = "0," + tnb;
            }
            tnb = "[" + tnb;
        }
        if (four < year && four > 0) {
            zxjsjb = zxjsjb.substring(0, zxjsjb.length() - 1);
            zxjsjb += "]";
            for (int i = 0; i < year - four; i++) {
                zxjsjb = "0," + zxjsjb;
            }
            zxjsjb = "[" + zxjsjb;
        }
        if (five < year && five > 0) {
            gxb = gxb.substring(0, gxb.length() - 1);
            gxb += "]";
            for (int i = 0; i < year - five; i++) {
                gxb = "0," + gxb;
            }
            gxb = "[" + gxb;
        }
        if (six < year && six > 0) {
            xnxgb = xnxgb.substring(0, xnxgb.length() - 1);
            xnxgb += "]";
            for (int i = 0; i < year - six; i++) {
                xnxgb = "0," + xnxgb;
            }
            xnxgb = "[" + xnxgb;
        }
        if (seven < year && seven > 0) {
            zl = zl.substring(0, zl.length() - 1);
            zl += "]";
            for (int i = 0; i < year - seven; i++) {
                zl = "0," + zl;
            }
            zl = "[" + zl;
        }
        if (eight < year && eight > 0) {
            mxzqgb = mxzqgb.substring(0, mxzqgb.length() - 1);
            mxzqgb += "]";
            for (int i = 0; i < year - eight; i++) {
                mxzqgb = "0," + mxzqgb;
            }
            mxzqgb = "[" + mxzqgb;
        }
        
        if("".equals(diseasegxy)){
            gxy = "[]";
        }
        else
        {
            if("".equals(gxy)){
                gxy="[";
                for(int m=0;m<year-1;m++){
                    gxy=gxy+"0,";
                }
                gxy=gxy+"0]";
            }
        }
        
        
        if("".equals(diseasecjza)){
            cjza = "[]";
        }
        else
        {
            if("".equals(cjza)){
                cjza="[";
                for(int m=0;m<year-1;m++){
                    cjza=cjza+"0,";
                }
                cjza=cjza+"0]";
            }
        }
        
        if("".equals(diseasetnb)){
            tnb = "[]";
        }
        else
        {
            if("".equals(tnb)){
                tnb="[";
                for(int m=0;m<year-1;m++){
                    tnb=tnb+"0,";
                }
                tnb=tnb+"0]";
            }
        }
        
        
        if("".equals(diseasezxjsjb)){
            zxjsjb = "[]";
        }
        else
        {
            if("".equals(zxjsjb)){
                zxjsjb="[";
                for(int m=0;m<year-1;m++){
                    zxjsjb=zxjsjb+"0,";
                }
                zxjsjb=zxjsjb+"0]";
            }
        }
        
        if("".equals(diseasegxb)){
            gxb = "[]";
        }
        else
        {
            if("".equals(gxb)){
                gxb="[";
                for(int m=0;m<year-1;m++){
                    gxb=gxb+"0,";
                }
                gxb=gxb+"0]";
            }
        }
        
        if("".equals(diseasexnxgb)){
            xnxgb = "[]";
        }
        else
        {
            if("".equals(xnxgb)){
                xnxgb="[";
                for(int m=0;m<year-1;m++){
                    xnxgb=xnxgb+"0,";
                }
                xnxgb=xnxgb+"0]";
            }
        }
        
        if("".equals(diseasezl)){
            zl = "[]";
        }
        else
        {
            if("".equals(zl)){
                zl="[";
                for(int m=0;m<year-1;m++){
                    zl=zl+"0,";
                }
                zl=zl+"0]";
            }
        }
        
        if("".equals(diseasemxzqgb)){
            mxzqgb = "[]";
        }
        else
        {
            if("".equals(mxzqgb)){
                mxzqgb="[";
                for(int m=0;m<year-1;m++){
                    mxzqgb=mxzqgb+"0,";
                }
                mxzqgb=mxzqgb+"0]";
            }
        }

        /*if (one == 0) {
            cjza = "[]";
        }
        if (two == 0) {
            gxy = "[]";
        }
        if (three == 0) {
            tnb = "[]";
        }
        if (four == 0) {
            zxjsjb = "[]";
        }
        if (five == 0) {
            gxb = "[]";
        }
        if (six == 0) {
            xnxgb = "[]";
        }
        if (seven == 0) {
            zl = "[]";
        }
        if (eight == 0) {
            mxzqgb = "[]";
        }*/

        return "getGroupDiseaseAnalyse";
    }

    // 全部社区医院疾病分析
    public String getAllComHosDiseaseAnalyse() {
        try {
            if (chronicDiseaseIdList == null) {
                flag = "请选择疾病名称";
                selectHospitals = communityHospitalService.getCommunityHospitalByID(communityHospitalIdList);
                return "getComHosDiseaseAnalyse";
            }
            countList = statisticsService.getRecentCount(communityHospitalIdList, chronicDiseaseIdList);
            selectHospitals = communityHospitalService.getCommunityHospitalByID(communityHospitalIdList);
            diseasegxy = "";
            diseasecjza = "";
            diseasetnb = "";
            diseasezxjsjb = "";
            diseasegxb = "";
            diseasexnxgb = "";
            diseasezl = "";
            diseasemxzqgb = "";
            for (Object list : chronicDiseaseIdList) {
                if (list.equals("'残疾障碍'")) {
                    diseasecjza = "残疾障碍";
                }
                if (list.equals("'高血压'")) {
                    diseasegxy = "高血压";
                }
                if (list.equals("'糖尿病'")) {
                    diseasetnb = "糖尿病";
                }
                if (list.equals("'重性精神疾病'")) {
                    diseasezxjsjb = "重性精神疾病";
                }
                if (list.equals("'冠心病'")) {
                    diseasegxb = "冠心病";
                }
                if (list.equals("'心脑血管病'")) {
                    diseasexnxgb = "心脑血管病";
                }
                if (list.equals("'肿瘤'")) {
                    diseasezl = "肿瘤";
                }
                if (list.equals("'慢性支气管病'")) {
                    diseasemxzqgb = "慢性支气管病";
                }
            }
            int year = 0;
            if (recent.equals("最近一年")) {
                year = 12;
            }
            if (recent.equals("最近两年")) {
                year = 24;
            }
            time = "[";
            for (int i = year - 1; i >= 0; i--) {
                Calendar ca = Calendar.getInstance();// 得到一个Calendar的实例
                Date now = ca.getTime();
                ca.add(Calendar.MONTH, -i); // 月份减1
                Date shuju = ca.getTime(); // 结果
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM");
                time += "'" + sf.format(shuju) + "',";

            }
            time = time.substring(0, time.length() - 1);
            time += "]";
            int one = 0;
            int two = 0;
            int three = 0;
            int four = 0;
            int five = 0;
            int six = 0;
            int seven = 0;
            int eight = 0;
            for (TCount list : countList) {
                if (one < year) {
                    if (list.getDisease().equals("残疾障碍")) {
                        cjza += "" + list.getNum() + ",";
                        one = one + 1;
                    }
                }
                if (two < year) {
                    if (list.getDisease().equals("高血压")) {
                        gxy += "" + list.getNum() + ",";
                        two = two + 1;
                    }
                }
                if (three < year) {
                    if (list.getDisease().equals("糖尿病")) {
                        tnb += "" + list.getNum() + ",";
                        three = three + 1;
                    }
                }
                if (four < year) {
                    if (list.getDisease().equals("重性精神疾病")) {
                        zxjsjb += "" + list.getNum() + ",";
                        four = four + 1;
                    }
                }
                if (five < year) {
                    if (list.getDisease().equals("冠心病")) {
                        gxb += "" + list.getNum() + ",";
                        five = five + 1;
                    }
                }
                if (six < year) {
                    if (list.getDisease().equals("心脑血管病")) {
                        xnxgb += "" + list.getNum() + ",";
                        six = six + 1;
                    }
                }
                if (seven < year) {
                    if (list.getDisease().equals("肿瘤")) {
                        zl += "" + list.getNum() + ",";
                        seven = seven + 1;
                    }
                }
                if (eight < year) {
                    if (list.getDisease().equals("慢性支气管病")) {
                        mxzqgb += "" + list.getNum() + ",";
                        eight = eight + 1;
                    }
                }
            }

            if (one < year && one > 0) {
                cjza = cjza.substring(0, cjza.length() - 1);
                cjza += "]";
                for (int i = 0; i < year - one; i++) {
                    cjza = "0," + cjza;
                }
                cjza = "[" + cjza;
            }

            if (two < year && two > 0) {
                gxy = gxy.substring(0, gxy.length() - 1);
                gxy += "]";
                for (int i = 0; i < year - two; i++) {
                    gxy = "0," + gxy;
                }
                gxy = "[" + gxy;
            }
            if (three < year && three > 0) {
                tnb = tnb.substring(0, tnb.length() - 1);
                tnb += "]";
                for (int i = 0; i < year - three; i++) {
                    tnb = "0," + tnb;
                }
                tnb = "[" + tnb;
            }
            if (four < year && four > 0) {
                zxjsjb = zxjsjb.substring(0, zxjsjb.length() - 1);
                zxjsjb += "]";
                for (int i = 0; i < year - four; i++) {
                    zxjsjb = "0," + zxjsjb;
                }
                zxjsjb = "[" + zxjsjb;
            }
            if (five < year && five > 0) {
                gxb = gxb.substring(0, gxb.length() - 1);
                gxb += "]";
                for (int i = 0; i < year - five; i++) {
                    gxb = "0," + gxb;
                }
                gxb = "[" + gxb;
            }
            if (six < year && six > 0) {
                xnxgb = xnxgb.substring(0, xnxgb.length() - 1);
                xnxgb += "]";
                for (int i = 0; i < year - six; i++) {
                    xnxgb = "0," + xnxgb;
                }
                xnxgb = "[" + xnxgb;
            }
            if (seven < year && seven > 0) {
                zl = zl.substring(0, zl.length() - 1);
                zl += "]";
                for (int i = 0; i < year - seven; i++) {
                    zl = "0," + zl;
                }
                zl = "[" + zl;
            }
            if (eight < year && eight > 0) {
                mxzqgb = mxzqgb.substring(0, mxzqgb.length() - 1);
                mxzqgb += "]";
                for (int i = 0; i < year - eight; i++) {
                    mxzqgb = "0," + mxzqgb;
                }
                mxzqgb = "[" + mxzqgb;
            }
            
            if("".equals(diseasegxy)){
                gxy = "[]";
            }
            else
            {
                if("".equals(gxy)){
                    gxy="[";
                    for(int m=0;m<year-1;m++){
                        gxy=gxy+"0,";
                    }
                    gxy=gxy+"0]";
                }
            }
            
            
            if("".equals(diseasecjza)){
                cjza = "[]";
            }
            else
            {
                if("".equals(cjza)){
                    cjza="[";
                    for(int m=0;m<year-1;m++){
                        cjza=cjza+"0,";
                    }
                    cjza=cjza+"0]";
                }
            }
            
            if("".equals(diseasetnb)){
                tnb = "[]";
            }
            else
            {
                if("".equals(tnb)){
                    tnb="[";
                    for(int m=0;m<year-1;m++){
                        tnb=tnb+"0,";
                    }
                    tnb=tnb+"0]";
                }
            }
            
            
            if("".equals(diseasezxjsjb)){
                zxjsjb = "[]";
            }
            else
            {
                if("".equals(zxjsjb)){
                    zxjsjb="[";
                    for(int m=0;m<year-1;m++){
                        zxjsjb=zxjsjb+"0,";
                    }
                    zxjsjb=zxjsjb+"0]";
                }
            }
            
            if("".equals(diseasegxb)){
                gxb = "[]";
            }
            else
            {
                if("".equals(gxb)){
                    gxb="[";
                    for(int m=0;m<year-1;m++){
                        gxb=gxb+"0,";
                    }
                    gxb=gxb+"0]";
                }
            }
            
            if("".equals(diseasexnxgb)){
                xnxgb = "[]";
            }
            else
            {
                if("".equals(xnxgb)){
                    xnxgb="[";
                    for(int m=0;m<year-1;m++){
                        xnxgb=xnxgb+"0,";
                    }
                    xnxgb=xnxgb+"0]";
                }
            }
            
            if("".equals(diseasezl)){
                zl = "[]";
            }
            else
            {
                if("".equals(zl)){
                    zl="[";
                    for(int m=0;m<year-1;m++){
                        zl=zl+"0,";
                    }
                    zl=zl+"0]";
                }
            }
            
            if("".equals(diseasemxzqgb)){
                mxzqgb = "[]";
            }
            else
            {
                if("".equals(mxzqgb)){
                    mxzqgb="[";
                    for(int m=0;m<year-1;m++){
                        mxzqgb=mxzqgb+"0,";
                    }
                    mxzqgb=mxzqgb+"0]";
                }
            }

            /*if (one == 0) {
                cjza = "[]";
            }
            if (two == 0) {
                gxy = "[]";
            }
            if (three == 0) {
                tnb = "[]";
            }
            if (four == 0) {
                zxjsjb = "[]";
            }
            if (five == 0) {
                gxb = "[]";
            }
            if (six == 0) {
                xnxgb = "[]";
            }
            if (seven == 0) {
                zl = "[]";
            }
            if (eight == 0) {
                mxzqgb = "[]";
            }*/

            return "getAllComHosDiseaseAnalyse";

        } catch (Exception e) {
            // TODO: handle exception
        }
        return "getAllComHosDiseaseAnalyse";
    }

    public List<TCommunityHospital> getCommunityHospitalList() {
        return communityHospitalList;
    }

    public void setCommunityHospitalList(List<TCommunityHospital> communityHospitalList) {
        this.communityHospitalList = communityHospitalList;
    }

    public List<Long> getCommunityHospitalCount() {
        return communityHospitalCount;
    }

    public void setCommunityHospitalCount(List<Long> communityHospitalCount) {
        this.communityHospitalCount = communityHospitalCount;
    }

    public List<TCount> getCountList() {
        return countList;
    }

    public void setCountList(List<TCount> countList) {
        this.countList = countList;
    }

    public List<Object> getCommunityHospitalIdList() {
        return communityHospitalIdList;
    }

    public void setCommunityHospitalIdList(List<Object> communityHospitalIdList) {
        this.communityHospitalIdList = communityHospitalIdList;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public List<Object> getChronicDiseaseIdList() {
        return chronicDiseaseIdList;
    }

    public void setChronicDiseaseIdList(List<Object> chronicDiseaseIdList) {
        this.chronicDiseaseIdList = chronicDiseaseIdList;
    }

    public List<TCommunityHospital> getSelectHospitals() {
        return selectHospitals;
    }

    public void setSelectHospitals(List<TCommunityHospital> selectHospitals) {
        this.selectHospitals = selectHospitals;
    }

    public String getRecent() {
        return recent;
    }

    public void setRecent(String recent) {
        this.recent = recent;
    }

    public String getTime() {
        return time;
    }

    public List<TCommunityHospitalGroup> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<TCommunityHospitalGroup> groupList) {
        this.groupList = groupList;
    }

    public Date getOldTime() {
        return oldTime;
    }

    public void setOldTime(Date oldTime) {
        this.oldTime = oldTime;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public CommunityHospitalService getCommunityHospitalService() {
        return communityHospitalService;
    }

    public void setCommunityHospitalService(CommunityHospitalService communityHospitalService) {
        this.communityHospitalService = communityHospitalService;
    }

    public StatisticsService getStatisticsService() {
        return statisticsService;
    }

    public void setStatisticsService(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    public String getCjza() {
        return cjza;
    }

    public void setCjza(String cjza) {
        this.cjza = cjza;
    }

    public String getGxy() {
        return gxy;
    }

    public void setGxy(String gxy) {
        this.gxy = gxy;
    }

    public String getTnb() {
        return tnb;
    }

    public void setTnb(String tnb) {
        this.tnb = tnb;
    }

    public String getZxjsjb() {
        return zxjsjb;
    }

    public void setZxjsjb(String zxjsjb) {
        this.zxjsjb = zxjsjb;
    }

    public String getGxb() {
        return gxb;
    }

    public void setGxb(String gxb) {
        this.gxb = gxb;
    }

    public String getXnxgb() {
        return xnxgb;
    }

    public void setXnxgb(String xnxgb) {
        this.xnxgb = xnxgb;
    }

    public String getZl() {
        return zl;
    }

    public void setZl(String zl) {
        this.zl = zl;
    }

    public String getMxzqigb() {
        return mxzqgb;
    }

    public void setMxzqigb(String mxzqigb) {
        this.mxzqgb = mxzqigb;
    }

    public String getMxzqgb() {
        return mxzqgb;
    }

    public void setMxzqgb(String mxzqgb) {
        this.mxzqgb = mxzqgb;
    }

    public String getDiseasegxy() {
        return diseasegxy;
    }

    public void setDiseasegxy(String diseasegxy) {
        this.diseasegxy = diseasegxy;
    }

    public String getDiseasecjza() {
        return diseasecjza;
    }

    public void setDiseasecjza(String diseasecjza) {
        this.diseasecjza = diseasecjza;
    }

    public String getDiseasetnb() {
        return diseasetnb;
    }

    public void setDiseasetnb(String diseasetnb) {
        this.diseasetnb = diseasetnb;
    }

    public String getDiseasezxjsjb() {
        return diseasezxjsjb;
    }

    public void setDiseasezxjsjb(String diseasezxjsjb) {
        this.diseasezxjsjb = diseasezxjsjb;
    }

    public String getDiseasegxb() {
        return diseasegxb;
    }

    public void setDiseasegxb(String diseasegxb) {
        this.diseasegxb = diseasegxb;
    }

    public String getDiseasexnxgb() {
        return diseasexnxgb;
    }

    public void setDiseasexnxgb(String diseasexnxgb) {
        this.diseasexnxgb = diseasexnxgb;
    }

    public String getDiseasezl() {
        return diseasezl;
    }

    public void setDiseasezl(String diseasezl) {
        this.diseasezl = diseasezl;
    }

    public String getDiseasemxzqgb() {
        return diseasemxzqgb;
    }

    public void setDiseasemxzqgb(String diseasemxzqgb) {
        this.diseasemxzqgb = diseasemxzqgb;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public List<Object> getCheckbox() {
        return checkbox;
    }

    public void setCheckbox(List<Object> checkbox) {
        this.checkbox = checkbox;
    }

    public String getJsonString() {
        return jsonString;
    }

    public void setJsonString(String jsonString) {
        this.jsonString = jsonString;
    }

    public String getYiYuan() {
        return yiYuan;
    }

    public void setYiYuan(String yiYuan) {
        this.yiYuan = yiYuan;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getStatistics() {
        return statistics;
    }

    public List<Object> getGroupIdList() {
        return groupIdList;
    }

    public void setGroupIdList(List<Object> groupIdList) {
        this.groupIdList = groupIdList;
    }

    public List<TCommunityHospitalGroup> getSelectGroups() {
        return selectGroups;
    }

    public void setSelectGroups(List<TCommunityHospitalGroup> selectGroups) {
        this.selectGroups = selectGroups;
    }

    public void setStatistics(String statistics) {
        this.statistics = statistics;
    }

    public List<Device> getDevicelist() {
        return devicelist;
    }

    public void setDevicelist(List<Device> devicelist) {
        this.devicelist = devicelist;
    }

    public List<DeviceType> getDeviceTypes() {
        return deviceTypes;
    }

    public void setDeviceTypes(List<DeviceType> deviceTypes) {
        this.deviceTypes = deviceTypes;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
