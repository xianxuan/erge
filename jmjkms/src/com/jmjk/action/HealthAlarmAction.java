package com.jmjk.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.THealthFile;
import com.jmjk.entity.TOldStaffHos;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.view.VOldStaff;
import com.jmjk.enums.Admin_IsHead;
import com.jmjk.enums.CHRONIC_MANAGER;
import com.jmjk.enums.HealthFileCheck;
import com.jmjk.iservice.IHealthAlarmService;
import com.jmjk.pojo.AlarmGetDateGet;
import com.jmjk.pojo.AlarmData;
import com.jmjk.pojo.AlarmRequestParam;
import com.jmjk.pojo.BloodPressCloud;
import com.jmjk.pojo.BloodPressCloud.BloodPress;
import com.jmjk.pojo.HealthFileCloud;
import com.jmjk.pojo.AlarmHandleRequest;
import com.jmjk.pojo.AlarmHandleResponse;
import com.jmjk.pojo.Ids;
import com.jmjk.pojo.HealthFileCloud.Page.HealthFile;
import com.jmjk.pojo.Ids.healthFileId;
import com.jmjk.service.CommunityHospitalGroupService;
import com.jmjk.service.CommunityHospitalService;
import com.jmjk.service.HealthAlarmService;
import com.jmjk.service.HealthFileService;
import com.jmjk.service.HealthManagerService;
import com.jmjk.service.StaffService;
import com.jmjk.utils.GetSessionPerson;
import com.jmjk.utils.ListToJson;
import com.jmjk.utils.Page;
import com.jmjk.utils.TypeConverter;
import com.opensymphony.xwork2.ActionContext;

@Component
@Scope("prototype")
@Action(value = "healthAlarmAction", results = {
        @Result(name = "getAlarmData", location = "/jsp/healthManager/healthAlarm.jsp"),
        @Result(name = "toAlarmManager", type = "redirectAction", location = "healthAlarmAction!getAlarmData.action", params = {
                " id", "${id }","startTime","${startTime}","endTime", "${endTime}" }),
        @Result(name = "hanglehealthAlarm", type = "redirectAction", location = "healthAlarmAction!getAlarmData.action", params = {
                " id", "${id }","startTime","${startTime}","endTime", "${endTime}","code", "${code}","message","${message}"  }),
        @Result(name = "getBloodPressureDetail", location = "/jsp/healthManager/bloodPressDetail.jsp", params = {"bpID","${bpID}","healthFileId","${healthFileId}"}),
        @Result(name = "getBloodSugarDetail", location = "/jsp/healthManager/bloodSugarDetail.jsp", params = {"bsID","${bsID}","healthFileId","${healthFileId}"}),
        @Result(name="error", location="/error.jsp")})
/**
 * 
 * @author 赖清发  健康预警
 *
 */
public class HealthAlarmAction extends BaseAction {
	@Autowired
	HealthManagerService healthManagerService;
    @Autowired
    private HealthAlarmService healthAlarmService;
    @Autowired
    private HealthFileService healthFileService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private CommunityHospitalGroupService communityHospitalGroupService;
   
    private static final long serialVersionUID = 1L;
    private AlarmHandleRequest alarmHandleRequest;
    private String idCard;
    private String IPhone;// 本人联系电话电话
    private Boolean sex;// 性别
    private String fileNum;// 档案编号
    private String name;// 姓名
    private THealthFile healthfile;
    private IHealthAlarmService iHealthAlarmService;
    private TOldStaffHos OldStaffHos;
    private TCommunityHospital CommunityHospital;
    private TStaff tStaff;
    private AlarmRequestParam alarmsent;
    private Object body;
    private Object Size;
    private int mansize;
    private AlarmHandleRequest alarmhandleresquest;
    private int code=-1;
    private List<AlarmData> alarmDataList;

    private AlarmHandleResponse alarmHandleResponse;
    private String pageHtml;
    private int cp=1;
    private int flag; // 传参 用于判断打印全部还是本页
    private int[] ids;// 用于触发程序的传参
    private String RId;
    private Date startTime;
    private Date endTime;
    private List<TOldStaffHos> listTHealthFile;
    private String message;
    private Date beginTime;
    private Date overTime;
    private int alarmType;
    private String alarmQuota;
    private int status;
    private int alarmId;
    
    private int id;
    private int state;
    private String resultJson;
    private int currentPage;
    private  List<VOldStaff> healthFileList;
    //private int person=0;
    private int staffId;
    private int communityHosiptalId;
    private String returnJson;
    private String start;
    private List<String> appUserID =new ArrayList<String>();
    private String end;
    //用于数据总数
    private int pagenumT=0;
    //用于传值
    private int pageflag;
    //用于判断
    private boolean pepl=false;
    private List<AlarmData> listaa=new ArrayList<AlarmData>();
    private CommunityHospitalService communityHospitalService;
    private int pageSize;
    private List<TCommunityHospital> hospitals;//所有社区医院
	private List<HealthFile> healthFileCloudList;
    
	private int healthFileId;
	private BloodPress bp;
	private int bpID;
	private int meaState;
	private int takeMed;
	private String meaTime;
	private String medName;
	private int arm;
	private Integer pulse;
	private int sysPre;
	private int diaPre;
	
	private int bsID;
	private Double bloodSugar;
	private String abnAlarm;
	private String analysisResult;
	
	
    public int getBsID() {
		return bsID;
	}

	public void setBsID(int bsID) {
		this.bsID = bsID;
	}

	public Double getBloodSugar() {
		return bloodSugar;
	}

	public void setBloodSugar(Double bloodSugar) {
		this.bloodSugar = bloodSugar;
	}

	public String getAbnAlarm() {
		return abnAlarm;
	}

	public void setAbnAlarm(String abnAlarm) {
		this.abnAlarm = abnAlarm;
	}

	public String getAnalysisResult() {
		return analysisResult;
	}

	public void setAnalysisResult(String analysisResult) {
		this.analysisResult = analysisResult;
	}

	public int getHealthFileId() {
		return healthFileId;
	}

	public void setHealthFileId(int healthFileId) {
		this.healthFileId = healthFileId;
	}

	public BloodPress getBp() {
		return bp;
	}

	public void setBp(BloodPress bp) {
		this.bp = bp;
	}

	public int getBpID() {
		return bpID;
	}

	public void setBpID(int bpID) {
		this.bpID = bpID;
	}

	public int getMeaState() {
		return meaState;
	}

	public void setMeaState(int meaState) {
		this.meaState = meaState;
	}

	public int getTakeMed() {
		return takeMed;
	}

	public void setTakeMed(int takeMed) {
		this.takeMed = takeMed;
	}

	public String getMeaTime() {
		return meaTime;
	}

	public void setMeaTime(String meaTime) {
		this.meaTime = meaTime;
	}

	public String getMedName() {
		return medName;
	}

	public void setMedName(String medName) {
		this.medName = medName;
	}

	public int getArm() {
		return arm;
	}

	public void setArm(int arm) {
		this.arm = arm;
	}

	public Integer getPulse() {
		return pulse;
	}

	public void setPulse(Integer pulse) {
		this.pulse = pulse;
	}

	public int getSysPre() {
		return sysPre;
	}

	public void setSysPre(int sysPre) {
		this.sysPre = sysPre;
	}

	public int getDiaPre() {
		return diaPre;
	}

	public void setDiaPre(int diaPre) {
		this.diaPre = diaPre;
	}

	public String toAlarmManager(){
    	Date date = new Date();// 新建此时的的系统时间
    	endTime=date;
    	Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, -7);//-7  今天的时间往前推7天
        date = calendar.getTime();
        startTime=date;
 
        return "toAlarmManager"; 
    }
    
//	public String getBloodPressureDetail() throws IOException {
//		HttpSession session = ServletActionContext.getRequest().getSession();
//		TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
//		if(group==null){
//			int person = GetSessionPerson.getPerson();
//			if((Integer)person == null){
//				return "error";
//			}
//		}
//		healthfile = healthFileService.getHealthFileById(healthFileId);
//		resultJson = healthAlarmService.getAlarmBloodPressureDetail(bpID);
//		if(resultJson!=null){
//			JSONObject bpCloud = JSON.parseObject(resultJson);
//			if(bpCloud.getIntValue("code")== 0){
//				String tmp = bpCloud.getString("item");
//				JSONObject bpObj = JSON.parseObject(tmp);
//				meaState  = bpObj.getIntValue("meaState");
//				takeMed = bpObj.getIntValue("takeMed");
//				meaTime = bpObj.getString("meaTime");
//				medName = bpObj.getString("medName");
//				arm = bpObj.getIntValue("arm");
//				pulse = bpObj.getIntValue("pulse");
//				sysPre = bpObj.getIntValue("sysPre");
//				diaPre = bpObj.getIntValue("diaPre");
//			}
//		}
//		return "getBloodPressureDetail";
//	}
	
	public void getBloodPressureDetail() throws IOException {
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
		if(group==null){
			int person = GetSessionPerson.getPerson();
			if((Integer)person == null){
				return;
			}
		}
		healthfile = healthFileService.getHealthFileById(healthFileId);
		resultJson = healthAlarmService.getAlarmBloodPressureDetail(bpID);
		if(resultJson!=null){
			JSONObject bpCloud = JSON.parseObject(resultJson);
			if(bpCloud.getIntValue("code")== 0){
				bpCloud.put("name", healthfile.getName());
				bpCloud.put("sex", healthfile.getSex());
				bpCloud.put("IPhone", healthfile.getIPhone());
				this.writeJson(bpCloud.toString());
				return;
//				String tmp = bpCloud.getString("item");
//				JSONObject bpObj = JSON.parseObject(tmp);
//				meaState  = bpObj.getIntValue("meaState");
//				takeMed = bpObj.getIntValue("takeMed");
//				meaTime = bpObj.getString("meaTime");
//				medName = bpObj.getString("medName");
//				arm = bpObj.getIntValue("arm");
//				pulse = bpObj.getIntValue("pulse");
//				sysPre = bpObj.getIntValue("sysPre");
//				diaPre = bpObj.getIntValue("diaPre");
			}
		}
		return;
	}
	
//	public String getBloodSugarDetail() throws IOException {
//		HttpSession session = ServletActionContext.getRequest().getSession();
//		TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
//		if(group==null){
//			int person = GetSessionPerson.getPerson();
//			if((Integer)person == null){
//				return "error";
//			}
//		}
//		healthfile = healthFileService.getHealthFileById(healthFileId);
//		resultJson = healthAlarmService.getAlarmBloodSugarDetail(bsID);
//		if(resultJson!=null){
//			JSONObject bsCloud = JSON.parseObject(resultJson);
//			if(bsCloud.getIntValue("code")== 0){
//				String tmp = bsCloud.getString("item");
//				JSONObject bsObj = JSON.parseObject(tmp);
//				meaState  = bsObj.getIntValue("meaState");
//				takeMed = bsObj.getIntValue("takeMed");
//				meaTime = bsObj.getString("meaTime");
//				medName = bsObj.getString("medName");
//				bloodSugar = bsObj.getDouble("bloodSugar");
//				abnAlarm = bsObj.getString("abnAlarm");
//				analysisResult = bsObj.getString("analysisResult");
//
//			}
//		}
//		return "getBloodSugarDetail";
//	}
	
	public void getBloodSugarDetail() throws IOException {
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
		if(group==null){
			int person = GetSessionPerson.getPerson();
			if((Integer)person == null){
				return;
			}
		}
		healthfile = healthFileService.getHealthFileById(healthFileId);
		resultJson = healthAlarmService.getAlarmBloodSugarDetail(bsID);
		if(resultJson!=null){
			JSONObject bsCloud = JSON.parseObject(resultJson);
			if(bsCloud.getIntValue("code")== 0){
				bsCloud.put("name", healthfile.getName());
				bsCloud.put("sex", healthfile.getSex());
				bsCloud.put("IPhone", healthfile.getIPhone());
				this.writeJson(bsCloud.toString());
				return;
//				String tmp = bsCloud.getString("item");
//				JSONObject bsObj = JSON.parseObject(tmp);
//				meaState  = bsObj.getIntValue("meaState");
//				takeMed = bsObj.getIntValue("takeMed");
//				meaTime = bsObj.getString("meaTime");
//				medName = bsObj.getString("medName");
//				bloodSugar = bsObj.getDouble("bloodSugar");
//				abnAlarm = bsObj.getString("abnAlarm");
//				analysisResult = bsObj.getString("analysisResult");

			}
		}
		return;
	}
	
    public String getAlarmData() throws IOException {
        
        //分页
        Page<AlarmGetDateGet> page = new Page<AlarmGetDateGet>();
        page.setCurrentPage(cp);
        String resultJson="";
        //如果初始查询的两个时间任意一个为空  直接返回页面
        if (startTime==null || endTime==null) {
        
            page.setTotalNum(0);
            page.setCurrentPage(1);
            currentPage=page.getCurrentPage();          
            this.pageHtml = page.getPage("healthAlarmAction!getAlarmData.action");

            return "getAlarmData";
            
        }
        //将时间转换为结束时间的  23：59：59
        Calendar c = Calendar.getInstance();
        c.setTime(endTime);
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
    	endTime=c.getTime();
    	
        HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
		if(group!=null){
			 healthFileList=healthFileService.getOldStaffsListByGroupAdmin(group.getGId());
		}
		else{ 
        //从session里拿到当前登录用户的id
        int person = GetSessionPerson.getPerson();
        //平台管理员
        if(person==Admin_IsHead.guanliyuan.getValue()){
            //平台管理员查数据库所有档案list
            healthFileList=healthFileService.getOldStaffsListByPlatAdmin();     
        }
        //员工
        if(person>0){
           //pepl用于判断当前登陆员工是否是责任医生
            pepl=healthFileService.getOldStaffHosByStaffId(person);
            //责任医生
            if(pepl==true){
            staffId=person;
            
            String healthFileListFromCloud = healthAlarmService.getHealthFileFromCloudByDoctor(staffId);
            if(healthFileListFromCloud!="")
            {
	            HealthFileCloud healthFileCloud = JSON.parseObject(healthFileListFromCloud,HealthFileCloud.class);
	            if(healthFileCloud.code==0)
	            {
				    healthFileCloudList = healthFileCloud.getPage().getResult();
	            }
	            else
	            {
	                //用于时间回显
	                start=TypeConverter.convertDate2String(startTime, "yyyy-MM-dd");
	                end=TypeConverter.convertDate2String(endTime, "yyyy-MM-dd");
	                page.setTotalNum(0);
	                page.setCurrentPage(1);
	                currentPage=page.getCurrentPage();          
	                this.pageHtml = page.getPage("healthAlarmAction!getAlarmData.action?startTime="+start+"&endTime="+end);
	                return "getAlarmData";
		        }
            }
            else
            {
                //用于时间回显
                start=TypeConverter.convertDate2String(startTime, "yyyy-MM-dd");
                end=TypeConverter.convertDate2String(endTime, "yyyy-MM-dd");
                page.setTotalNum(0);
                page.setCurrentPage(1);
                currentPage=page.getCurrentPage();          
                this.pageHtml = page.getPage("healthAlarmAction!getAlarmData.action?startTime="+start+"&endTime="+end);

                return "getAlarmData";
            }
            
//            //责任医生查询其管辖下的档案list
//            healthFileList=healthFileService.getOldStaffsListBystaffId(staffId);
            //普通员工
            }else{
                staffId=person;
                //获取当前普通员工所在医院实体
                int communityHospitalId=staffService.getCommHospitalByStaffId(staffId);
                //获取普通员工所辖的医院  整个医院的档案list
                healthFileList=healthFileService.getOldStaffsListBycommunityid(communityHospitalId);
            }
        }
        //社区管理员
        if(person<0)
        {
            communityHosiptalId=-person;
            String healthFileListFromCloud = healthAlarmService.getHealthFileFromCloudByHos(communityHosiptalId);
            if(healthFileListFromCloud!="")
            {
	            HealthFileCloud healthFileCloud = JSON.parseObject(healthFileListFromCloud,HealthFileCloud.class);
	            if(healthFileCloud.code==0)
	            {
	            	healthFileCloudList = healthFileCloud.getPage().getResult();
	            }
	            else{
	                //用于时间回显
	                start=TypeConverter.convertDate2String(startTime, "yyyy-MM-dd");
	                end=TypeConverter.convertDate2String(endTime, "yyyy-MM-dd");
	                page.setTotalNum(0);
	                page.setCurrentPage(1);
	                currentPage=page.getCurrentPage();          
	                this.pageHtml = page.getPage("healthAlarmAction!getAlarmData.action?startTime="+start+"&endTime="+end);

	                return "getAlarmData";
	            }
            }else{
                //用于时间回显
                start=TypeConverter.convertDate2String(startTime, "yyyy-MM-dd");
                end=TypeConverter.convertDate2String(endTime, "yyyy-MM-dd");
                page.setTotalNum(0);
                page.setCurrentPage(1);
                currentPage=page.getCurrentPage();          
                this.pageHtml = page.getPage("healthAlarmAction!getAlarmData.action?startTime="+start+"&endTime="+end);

                return "getAlarmData";
            }
            //获取一个社区的档案list
//            healthFileList=healthFileService.getOldStaffsListBycommunityid(communityHosiptalId);
         }
		}
		

		 //拼凑接口需要的数据 appUserIds 数据类型：'130126199502282714','130126199502282715'
        if (healthFileList!=null||healthFileCloudList!=null)
        {
        	
        	if (healthFileList!=null)
        	{
        		if(healthFileList.size()==0){
        			 //用于时间回显
	                start=TypeConverter.convertDate2String(startTime, "yyyy-MM-dd");
	                end=TypeConverter.convertDate2String(endTime, "yyyy-MM-dd");
	                page.setTotalNum(0);
	                page.setCurrentPage(1);
	                currentPage=page.getCurrentPage();          
	                this.pageHtml = page.getPage("healthAlarmAction!getAlarmData.action?startTime="+start+"&endTime="+end);
	                return "getAlarmData";
	
        		}else{
		            //遍历healthFileList 取出身份证号 放进appUserID
		            for(int s=0;s<healthFileList.size();s++)
		            {
		                //拼凑接口需要的数据类型
		                appUserID.add("'"+healthFileList.get(s).getIdNum()+"'");            
		            }
        		}
        	}else 
	        	{	
	               //遍历healthFileCloudList 取出身份证号 放进appUserID
	               for(int s=0;s<healthFileCloudList.size();s++){
	                    //拼凑接口需要的数据类型
	               appUserID.add("'"+healthFileCloudList.get(s).getIdNum()+"'");            
	             }
        		
        	}
  
        String appUserIds=TypeConverter.list3FormatString(appUserID, ",");
//        List<String> fileList = new ArrayList<String>();
//        fileList.add("healthFileId");
//        returnJson=new ListToJson<VOldStaff>().listToJson(healthFileList, fileList);
//        returnJson = "{'healthFileIds':"+returnJson+"}";        
//        String ids = "";
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("(");
//        List<Ids.healthFileId> healthFileIdList = JSON.parseObject(returnJson, Ids.class).getHealthFileIds();   
//        //如果当前登陆用户没有管理病人的话  也就是healthFileIdList为空  直接返回页面
//    
//        for (healthFileId healthFileId : healthFileIdList) {
//            stringBuilder.append(healthFileId.getHealthfileid());
//            stringBuilder.append(",");
//        }
//        stringBuilder.deleteCharAt(stringBuilder.length()-1);
//        stringBuilder.append(")");
//        ids = stringBuilder.toString();    
        //访问预警数据接口，查询预警数据  currentPage设置为1   pageSize设置为1000000  用于在第一页将全部数据取到 然后在本地进行分页 
        resultJson=healthAlarmService.getAlarmData(page.getCurrentPage(),  page.getPageSize(), startTime, endTime, appUserIds);
        
        if(resultJson!="")
        {

        //解析json
        AlarmGetDateGet alarmGetDateGet=JSON.parseObject(resultJson,AlarmGetDateGet.class);
        //获取数据失败直接返回页面
        if(alarmGetDateGet.getCode()==0){
            //解析json
            String jsonString=alarmGetDateGet.getPage().getResult();
            alarmDataList=JSONArray.parseArray(jsonString, AlarmData.class);//AlarmDatas该类是内部类还是外部类
           // JSON串转预警对象列表
            THealthFile tHealthFile = null;
            pagenumT=alarmGetDateGet.getPage().getTotal();
            for(int i=0;i<alarmDataList.size();i++){                        
                idCard=alarmDataList.get(i).getIdCard();
                //获取档案实体
                try{
	                tHealthFile = healthFileService.gethealthFileByIdNum(idCard);
                }catch( Exception e){
                	System.out.print("根据身份证号查询档案出现异常    异常位于HealthAlarmAction的340行  "+"idCard="+idCard+"         ");
                }
                if(tHealthFile!=null){
	                alarmDataList.get(i).setFileNum(tHealthFile.getFileNum());
	                alarmDataList.get(i).setName(tHealthFile.getName());
	                alarmDataList.get(i).setHealthFileId(tHealthFile.getHealthFileId()+"");
	                alarmDataList.get(i).setIPhone(tHealthFile.getIPhone());
	                alarmDataList.get(i).setSex(tHealthFile.getSex());
                }
           }
         }

        }
        }   
        //用于时间回显
        start=TypeConverter.convertDate2String(startTime, "yyyy-MM-dd");
        end=TypeConverter.convertDate2String(endTime, "yyyy-MM-dd");
        page.setTotalNum(pagenumT);
        page.setCurrentPage(cp);
        currentPage=page.getCurrentPage();          
        this.pageHtml = page.getPage("healthAlarmAction!getAlarmData.action?startTime="+start+"&endTime="+end);
            return "getAlarmData";
    }

    
    
/*********************************************************************************/
    
    public String hanglehealthAlarm() {

        /**
         * 需要修改 前台隐藏域带 会当前老人的档案id 状态 然后用session获得当前医生id
         * 传给alarmhandleresquest这个对象送生给云端 拿到code 后判断这个对象在list中的位置 把status改一下
         * 返回页面
         */
        startTime=beginTime;
        endTime=overTime;
        id=alarmhandleresquest.getId();
        status=alarmhandleresquest.getStatus();
        alarmType=alarmhandleresquest.getAlarmType();
        state=status;
        resultJson= healthAlarmService.updateAlarmType(id,state,alarmType);
        Map<String, Object> resultMap = new HashMap<String, Object>();
        try {
            //将json串转化成map
            resultMap =JSON.parseObject(resultJson);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //返回结果信息
        message=  (String) resultMap.get("message");
        code=  (int) resultMap.get("code");;
        if(message!=null&&message.equals("")){
            message=alarmHandleResponse.getMessage();
        }
        return "hanglehealthAlarm";
    }

    
    
    // 导出
    public String export() throws IOException {

        return null;

    }

    public AlarmHandleRequest getAlarmHandleRequest() {
        return alarmHandleRequest;
    }

    public void setAlarmHandleRequest(AlarmHandleRequest alarmHandleRequest) {
        this.alarmHandleRequest = alarmHandleRequest;
    }

    public String getIPhone() {
        return IPhone;
    }

    public void setIPhone(String iPhone) {
        IPhone = iPhone;
    }

    public List<AlarmData> getListaa() {
        return listaa;
    }

    public void setListaa(List<AlarmData> listaa) {
        this.listaa = listaa;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getFileNum() {
        return fileNum;
    }

    public void setFileNum(String fileNum) {
        this.fileNum = fileNum;
    }
    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public THealthFile getHealthfile() {
        return healthfile;
    }

    public void setHealthfile(THealthFile healthfile) {
        this.healthfile = healthfile;
    }

    public IHealthAlarmService getiHealthAlarmService() {
        return iHealthAlarmService;
    }

    public void setiHealthAlarmService(IHealthAlarmService iHealthAlarmService) {
        this.iHealthAlarmService = iHealthAlarmService;
    }

    public TOldStaffHos getOldStaffHos() {
        return OldStaffHos;
    }

    public void setOldStaffHos(TOldStaffHos oldStaffHos) {
        OldStaffHos = oldStaffHos;
    }

    public TCommunityHospital getCommunityHospital() {
        return CommunityHospital;
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

    public void setCommunityHospital(TCommunityHospital communityHospital) {
        CommunityHospital = communityHospital;
    }

    public TStaff gettStaff() {
        return tStaff;
    }

    public void settStaff(TStaff tStaff) {
        this.tStaff = tStaff;
    }

    public AlarmRequestParam getAlarmsent() {
        return alarmsent;
    }

    public void setAlarmsent(AlarmRequestParam alarmsent) {
        this.alarmsent = alarmsent;
    }

    public HealthAlarmService getHealthAlarmService() {
        return healthAlarmService;
    }

    public void setHealthAlarmService(HealthAlarmService healthAlarmService) {
        this.healthAlarmService = healthAlarmService;
    }

    public HealthFileService getHealthFileService() {
        return healthFileService;
    }

    public void setHealthFileService(HealthFileService healthFileService) {
        this.healthFileService = healthFileService;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public Object getSize() {
        return Size;
    }

    public void setSize(Object size) {
        Size = size;
    }

    public int getMansize() {
        return mansize;
    }

    public void setMansize(int mansize) {
        this.mansize = mansize;
    }

    public AlarmHandleRequest getAlarmhandleresquest() {
        return alarmhandleresquest;
    }

    public void setAlarmhandleresquest(AlarmHandleRequest alarmhandleresquest) {
        this.alarmhandleresquest = alarmhandleresquest;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }



    public AlarmHandleResponse getAlarmHandleResponse() {
        return alarmHandleResponse;
    }

    public void setAlarmHandleResponse(AlarmHandleResponse alarmHandleResponse) {
        this.alarmHandleResponse = alarmHandleResponse;
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

    public int getPageflag() {
        return pageflag;
    }

    public void setPageflag(int pageflag) {
        this.pageflag = pageflag;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public int[] getIds() {
        return ids;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }

    public String getRId() {
        return RId;
    }

    public void setRId(String rId) {
        RId = rId;
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


    public int getCp() {
        return cp;
    }


    public void setCp(int cp) {
        this.cp = cp;
    }

    public List<TOldStaffHos> getListTHealthFile() {
        return listTHealthFile;
    }

    public void setListTHealthFile(List<TOldStaffHos> listTHealthFile) {
        this.listTHealthFile = listTHealthFile;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    
    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getOverTime() {
        return overTime;
    }

    public void setOverTime(Date overTime) {
        this.overTime = overTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getAlarmType() {
        return alarmType;
    }

    public void setAlarmType(int alarmType) {
        this.alarmType = alarmType;
    }

    public String getAlarmQuota() {
        return alarmQuota;
    }

    public void setAlarmQuota(String alarmQuota) {
        this.alarmQuota = alarmQuota;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public List<AlarmData> getAlarmDataList() {
        return alarmDataList;
    }

    public void setAlarmDataList(List<AlarmData> alarmDataList) {
        this.alarmDataList = alarmDataList;
    }

    public Object getCurrentPage() {
        return currentPage;
    }

    public List<VOldStaff> getHealthFileList() {
        return healthFileList;
    }

    public void setHealthFileList(List<VOldStaff> healthFileList) {
        this.healthFileList = healthFileList;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public int getCommunityHosiptalId() {
        return communityHosiptalId;
    }

    public void setCommunityHosiptalId(int communityHosiptalId) {
        this.communityHosiptalId = communityHosiptalId;
    }

    public String getReturnJson() {
        return returnJson;
    }

    public void setReturnJson(String returnJson) {
        this.returnJson = returnJson;
    }

    public int getAlarmId() {
        return alarmId;
    }

    public void setAlarmId(int alarmId) {
        this.alarmId = alarmId;
    }

}
