package com.jmjk.action;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jmjk.action.base.BaseAction;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.THealthEdu;
import com.jmjk.entity.TStaff;
import com.jmjk.export.HealthEducationExport;
import com.jmjk.iservice.ICommunityHospitalGroupService;
import com.jmjk.iservice.ICommunityHospitalService;
import com.jmjk.iservice.IHealthEduService;
import com.jmjk.iservice.IStaffService;
import com.jmjk.pojo.HealtEducation;
import com.jmjk.service.CommunityHospitalService;
import com.jmjk.service.HealthFileService;
import com.jmjk.utils.GetSessionPerson;
import com.jmjk.utils.JxlExcel;
import com.jmjk.utils.Page;
import com.jmjk.utils.Resubmit;
import com.jmjk.utils.TokenProccessor;
import com.jmjk.utils.TypeConverter;
import com.jmjk.utils.UploadAndDownload;

/**
 * 健康教育action
 * @author houzichang
 *
 */
@Component 
@Scope("prototype") 
@Action(value="healthEducationAction",results={
		@Result(name="addHealthEducation",location="/jsp/healthEducation/addHealthEducation.jsp"),
		@Result(name="saveSuccess",type="redirectAction",location="healthEducationAction!getHealthEducationList.action"),
		@Result(name="getHealthEducationList",location="/jsp/healthEducation/showHealthEducation.jsp"),
		@Result(name="editHealthEducation",location="/jsp/healthEducation/editHealthEducation.jsp"),
		@Result(name="deleteHealthEducation",type="redirectAction",location="healthEducationAction!getHealthEducationList.action"),
		@Result(name="getHealthEducationDetail",location="/jsp/healthEducation/healthEducationDetail.jsp"),
		@Result(name="updateSuccess",type="redirectAction",location="healthEducationAction!getHealthEducationList.action"),
		@Result(name="getHealthEducationBySearch",location="/jsp/healthEducation/showHealthEducation.jsp"),
		@Result(name="success",type="redirectAction",location="healthEducationAction!getHealthEducationList.action"),
		@Result(name="error",location="/error.jsp"),
		@Result(name="test",type="redirectAction",location="healthEducationAction.action"),
		@Result(name="DocDRedir",type="redirectAction",location="healthEducationAction!getHealthEducationList.action")
})

public class HealthEducationAction extends BaseAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private IHealthEduService healthEduService;     //健康教育service
	@Autowired
	private ICommunityHospitalService communityHospitalService;
	@Autowired
	private ICommunityHospitalGroupService comHosGroupService;
	@Autowired  
	private IStaffService staffService;   			//员工service
	@Autowired
	HealthFileService healthFileService;
	
	private THealthEdu healthEducation;    			//健康教育实体
	private List<TStaff> staffList;        			//社区医院员工列表
	private int staffsId;                   	    //员工id

	private List<THealthEdu> healthEduList = new ArrayList<THealthEdu>();         //健康教育列表
	private int healthEducationId;                  //健康教育Id
	private String token;
	//分页
	private Page page = new Page();                 //分页对象
	private int cp=1;                               //当前页码
	private String pageHtml;                        //分页html
	
	//导出
	private int flag;
	private int[] ids;
	
	//上传文件
	private File upload;
	private String uploadFileName;
	private String savaPartPath="/uploadFile/HealthEducationFile/";
	
	//查询
	private String searchCondition;
	private String searchText;
	private Date startDate;
	private Date endDate;

	private int hosId; 
	private TCommunityHospital communityHospital;
	private String groupName;
	private String communityHospitalName;
	private HealtEducation healtEducation = new HealtEducation() ;  //总的pojo
	private List<HealtEducation>  healtEducatioList = new ArrayList<HealtEducation>(); //总表
	private List<TCommunityHospital> comHosList = new ArrayList<TCommunityHospital>();
	private int groupId;
	/*private List<TStaff> staffs = new ArrayList<TStaff>();*/
	
	//增加健康教育实体
	public String addHealthEducation(){
		
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){
        	return "error";
        }else{
        	//从session里拿到当前登录用户的id
    		int userId = GetSessionPerson.getPerson();
    		int hosId = 0;
    		//user大于0,员工id
    		if (userId>0) {
    			hosId = staffService.getCommHospitalByStaffId(userId);
    		//user小于0,社区负责人id;等于0,平台admin
    		}else if (userId<0) {
    			hosId = Math.abs(userId);
    		}else {
    			return "error";
    		}	
    		token = TokenProccessor.getInstance().makeToken();//创建令牌
    		HttpServletRequest request=ServletActionContext.getRequest();
    		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
    		staffList = staffService.getStaffByCommunityHospitalId(hosId);
    		return "addHealthEducation";  
        }
	}
	
	
	//保存健康教育实体
	public String saveHealthEducation(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){
        	return "error";      //如果集团能够保存的话报错
        }else {
        	//从session里拿到当前登录用户的id
    		int userId = GetSessionPerson.getPerson();
    		int hosId = 0;
    		//user大于0,员工id
    		if (userId>0) {
    			hosId = staffService.getCommHospitalByStaffId(userId);
    		//user小于0,社区负责人id;等于0,平台admin
    		}else if (userId<0) {
    			hosId = Math.abs(userId);
    		}
    		HttpServletRequest request=ServletActionContext.getRequest();
    		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
    		if(b==true){
    			return "DocDRedir";  //重定向回首页
    		}
    		request.getSession().removeAttribute("token");//移除session中的token
    		TStaff staff = staffService.getStaffById(staffsId);  //根据负责人Id获得员工实体
    		healthEducation.setTStaff(staff); //将员工实体保存到健康教育活动中
    		healthEducation.setCommunityHospitalId(hosId);
    		
    		String fileUrl="";
    		try {
    			fileUrl = UploadAndDownload.upload(upload, uploadFileName, savaPartPath);
    		} catch (Exception e) {
    			//上传文件出错,保存路径为空
    			fileUrl="";
    		}
    		if (fileUrl.contains("error")) {
    			fileUrl="";
    		}
    		healthEducation.setInformation(fileUrl);
    		
    		try {
    			healthEduService.saveHealthEdu(healthEducation);
    			return "saveSuccess";  
    		} catch (Exception e) {
    			staffList = staffService.getStaffByCommunityHospitalId(hosId);	
    			return "addHealthEducation";  
    		}  
		}
	}
	
	
	//修改健康教育
	public String editHealthEducation(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){
        	return "error";      //如果集团能够修改的话报错
        }else {
        	//从session里拿到当前登录用户的id
    		int userId = GetSessionPerson.getPerson();
    		int hosId = 0;
    		//user大于0,员工id
    		if (userId>0) {
    			hosId = staffService.getCommHospitalByStaffId(userId);
    		//user小于0,社区负责人id;等于0,平台admin
    		}else if (userId<0) {
    			hosId = Math.abs(userId);
    		}
    		THealthEdu healthEdu = healthEduService.getHealthEduById(healthEducationId);
    		if ((healthEdu!=null)&&(hosId==healthEdu.getCommunityHospitalId())) {
    			staffList = staffService.getStaffByCommunityHospitalId(hosId);
    			healthEducation=healthEduService.getHealthEduById(healthEducationId);
    			staffsId = healthEducation.getTStaff().getStaffId();
    			return "editHealthEducation";
    		}
    		return "error";
		}
	}
	
	
	//保存修改健康教育
	public String updateHealthEducation(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){
        	return "error";      //如果集团能够保存修改的话报错
        }else {
        	//从session里拿到当前登录用户的id
    		int userId = GetSessionPerson.getPerson();
    		int hosId = 0;
    		//user大于0,员工id
    		if (userId>0) {
    			hosId = staffService.getCommHospitalByStaffId(userId);
    		//user小于0,社区负责人id;等于0,平台admin
    		}else if (userId<0) {
    			hosId = Math.abs(userId);
    		}
    		if (hosId==healthEducation.getCommunityHospitalId()) {
    			TStaff staff = staffService.getStaffById(staffsId);  
    			healthEducation.setTStaff(staff); 
    			String fileUrl =healthEduService.getHealthEduById(healthEducation.getHealthEduId()).getInformation();
    			try {
    				if (upload!=null) {
    					fileUrl = UploadAndDownload.upload(upload, uploadFileName, savaPartPath);
    				}
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			healthEducation.setInformation(fileUrl);
    			healthEduService.updateHealthEdu(healthEducation);
    			return "updateSuccess";
    		}
    		return "error";
		}
	}
	
	
	//删除健康教育
	public String deleteHealthEducation(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){
        	return "error";      //如果集团能够删除的话报错
        }else {
        	//从session里拿到当前登录用户的id
    		int userId = GetSessionPerson.getPerson();
    		int hosId = 0;
    		//user大于0,员工id
    		if (userId>0) {
    			hosId = staffService.getCommHospitalByStaffId(userId);
    		//user小于0,社区负责人id;等于0,平台admin
    		}else if (userId<0) {
    			hosId = Math.abs(userId);
    		}else {
    			return "error";
    		}
    		if (hosId==healthEduService.getHealthEduById(healthEducationId).getCommunityHospitalId()) {
    			try {
    				healthEduService.deleteHealthEdu(healthEducationId);
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			return "deleteHealthEducation";
    		}
    		return "error";
		}
	}
	

	//根据社区医院Id获取健康教育列表(*******)
	public String getHealthEducationList(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){
        	page.setCurrentPage(cp);
			page.setTotalNum(healthEduService.getHealthEduNumByGroup(group));
			healthEduList = healthEduService.getHealthEduListByGroup(group);
			if (healthEduList!=null) {
				
			 for (THealthEdu theu:healthEduList) {
				    healtEducation=new HealtEducation();
					communityHospital = communityHospitalService.getCommunityHospitalById(theu.getCommunityHospitalId());
					communityHospitalName = communityHospital.getCommunityHospital();
					healtEducation.setHealth(theu);
					healtEducation.setCommunityHospital(communityHospitalName);
					healtEducatioList.add(healtEducation);   //总的列表..........
				}
			
			}
        	pageHtml=page.getPage("healthEducationAction!getHealthEducationList.action");
			return "getHealthEducationList";
        }else {
        	//从session里拿到当前登录用户的id
    		int userId = GetSessionPerson.getPerson();
    		//user等于0,平台管理员
    		if (userId==0) {
    			page.setCurrentPage(cp);
    			page.setTotalNum(healthEduService.getHealthEduNumByAll()); 
    			healthEduList=healthEduService.getHealthEduListByAll(page);
    			if (healthEduList!=null) {
					
    			for (THealthEdu theu:healthEduList) {
    				healtEducation=new HealtEducation();
    				hosId = theu.getCommunityHospitalId();
    				communityHospital = communityHospitalService.getCommunityHospitalById(hosId);//社区医院实体
    				groupName = communityHospital.getTCommunityHospitalGroup().getGroupName();//集团名称
    				communityHospitalName = communityHospital.getCommunityHospital(); //社区医院名称
    				healtEducation.setHealth(theu);
    				healtEducation.setCommunitygroup(groupName);
    				healtEducation.setCommunityHospital(communityHospitalName);
    				healtEducatioList.add(healtEducation);   //总的列表
    			}
				}
    			pageHtml=page.getPage("healthEducationAction!getHealthEducationList.action");
    			return "getHealthEducationList";
    		}
    		int hosId = 0;
    		//user大于0,员工id
    		if (userId>0) {
    			if(healthFileService.getOldStaffHosByStaffId(userId)) {// 判断员工是否为责任医生，若是，则只能看到所对应的老人){
    				page.setCurrentPage(cp);                                                //制定的时候可以指定到别的医生
    				page.setTotalNum(healthEduService.getHealthEduNumForSpecial(userId));   //根据员工Id获得员工自己所管理的
    				healthEduList=healthEduService.getHealthEduListForSpecial(userId,page); //医生只能看见自己所管理的
    				if (healthEduList!=null) {
						
    				for (THealthEdu the:healthEduList) {
    					healtEducation=new HealtEducation();
    					healtEducation.setHealth(the);
    					healtEducatioList.add(healtEducation);
					}
					}
    				pageHtml=page.getPage("healthEducationAction!getHealthEducationList.action");
    				return "getHealthEducationList";
    			}
    		hosId = staffService.getCommHospitalByStaffId(userId);
    		//user小于0,社区负责人id;等于0,平台admin
    		}else if (userId<0) {
    			hosId = Math.abs(userId);
    		}
    		page.setCurrentPage(cp);
    		page.setTotalNum(healthEduService.getHealthEduNumByComhosId(hosId));  
    		healthEduList=healthEduService.getHealthEduListByComhosId(hosId, page);
    		if (healthEduList!=null) {
				
    		for (THealthEdu the:healthEduList) {
    			healtEducation=new HealtEducation();
    			healtEducation.setHealth(the);
    			healtEducatioList.add(healtEducation);
    		}
			}
    		pageHtml=page.getPage("healthEducationAction!getHealthEducationList.action");
    		return "getHealthEducationList";
		}
	}
	
	//健康教育详情(******************)
	public String getHealthEducationDetail(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){
        	staffList = staffService.getAllStaff();
			healthEducation = healthEduService.getHealthEduById(healthEducationId);
			int comHosId = healthEducation.getCommunityHospitalId();
			communityHospital = communityHospitalService.getCommunityHospitalById(comHosId);
			communityHospitalName = communityHospital.getCommunityHospital(); //社区医院名称
			healtEducation.setHealth(healthEducation);
			healtEducation.setCommunityHospital(communityHospitalName);
			staffsId = healthEducation.getTStaff().getStaffId();
			return "getHealthEducationDetail";
        }else {
        	int userId = GetSessionPerson.getPerson();
    		int hosId = 0;  
    		//user大于0,员工id
    		if (userId>0) {
    			hosId = staffService.getCommHospitalByStaffId(userId);
    		//user小于0,社区负责人id;等于0,平台admin
    		}else if (userId<0 ) {
    			hosId = Math.abs(userId);
    		}else {
    			staffList = staffService.getAllStaff();
    			healthEducation = healthEduService.getHealthEduById(healthEducationId);
    			int comHosId = healthEducation.getCommunityHospitalId();
    			communityHospital = communityHospitalService.getCommunityHospitalById(comHosId);
    			groupName = communityHospital.getTCommunityHospitalGroup().getGroupName();//集团名称
				communityHospitalName = communityHospital.getCommunityHospital(); //社区医院名称
				healtEducation.setHealth(healthEducation);
				healtEducation.setCommunitygroup(groupName);
				healtEducation.setCommunityHospital(communityHospitalName);
    			staffsId = healthEducation.getTStaff().getStaffId();
    			return "getHealthEducationDetail";
    		}
    		//从session里拿到当前登录用户的id
    		if (hosId==healthEduService.getHealthEduById(healthEducationId).getCommunityHospitalId()) {
    			staffList = staffService.getStaffByCommunityHospitalId(hosId);	
    			healthEducation=healthEduService.getHealthEduById(healthEducationId);
    			healtEducation.setHealth(healthEducation);
    			staffsId = healthEducation.getTStaff().getStaffId();
    			return "getHealthEducationDetail";
    		}
		}
		return "error";
	}
	
	
	//查询(*************)
	public String getHealthEducationBySearch(){
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){
        	groupId = group.getGId();
        	page.setCurrentPage(cp);
			page.setTotalNum(healthEduService.getHealthNumGroupBySearch(groupId, searchCondition, searchText, startDate, endDate));
			healthEduList=healthEduService.getHealListGroupBySearch(groupId, searchCondition, searchText, startDate, endDate, page);
			for (THealthEdu theu:healthEduList) {
				healtEducation=new HealtEducation();
				communityHospital = communityHospitalService.getCommunityHospitalById(theu.getCommunityHospitalId());
				communityHospitalName = communityHospital.getCommunityHospital();
				healtEducation.setHealth(theu);
				healtEducation.setCommunityHospital(communityHospitalName); 
				healtEducatioList.add(healtEducation);   //总的列表..........
			}
			pageHtml=page.getPage("healthEducationAction!getHealthEducationBySearch.action?searchCondition="+ searchCondition + "&searchText="+ searchText + "&startDate=" + startDate + "&endDate="+ endDate);
			return "getHealthEducationBySearch";
        }else {
    		//从session里拿到当前登录用户的id
    		int userId = GetSessionPerson.getPerson();
    		if (userId==0) {
    			page.setCurrentPage(cp);
    			page.setTotalNum(healthEduService.getHealthEducationNumBySearch(searchCondition, searchText, startDate, endDate));
    			healthEduList=healthEduService.getHealthEducationListBySearch(searchCondition, searchText, startDate, endDate,page);
    			for (THealthEdu theu:healthEduList) {
    				healtEducation=new HealtEducation();
    				hosId = theu.getCommunityHospitalId();
    				communityHospital = communityHospitalService.getCommunityHospitalById(hosId);//社区医院实体
    				groupName = communityHospital.getTCommunityHospitalGroup().getGroupName();//集团名称
    				communityHospitalName = communityHospital.getCommunityHospital(); //社区医院名称
    				healtEducation.setHealth(theu);
    				healtEducation.setCommunitygroup(groupName);
    				healtEducation.setCommunityHospital(communityHospitalName);
    				healtEducatioList.add(healtEducation);   //总的列表
    			}
    			pageHtml=page.getPage("healthEducationAction!getHealthEducationBySearch.action?searchCondition="+ searchCondition + "&searchText="+ searchText + "&startDate=" + startDate + "&endDate="+ endDate);
    			return "getHealthEducationBySearch";
    		}
    		int hosId =0;
    		//user大于0,员工id
    		if (userId>0) {
    			/*hosId = staffService.getCommHospitalByStaffId(userId);*/	
    			page.setCurrentPage(cp);
    			page.setTotalNum(healthEduService.getHealSpecialNumBySearch(userId, searchCondition, searchText, startDate, endDate));
    			healthEduList=healthEduService.getHealSpecialListBySearch(userId, searchCondition, searchText, startDate, endDate, page);
    			for (THealthEdu the:healthEduList) {
    				healtEducation=new HealtEducation();
    				healtEducation.setHealth(the);
    				healtEducatioList.add(healtEducation);
    			}
    			pageHtml=page.getPage("healthEducationAction!getHealthEducationBySearch.action?searchCondition="+ searchCondition + "&searchText="+ searchText + "&startDate=" + startDate + "&endDate="+ endDate);
    			return "getHealthEducationBySearch";
    		//user小于0,社区负责人id,为负值
    		}else {
    			hosId = Math.abs(userId);
    			page.setCurrentPage(cp);
    			page.setTotalNum(healthEduService.getHealthEduNumBySearch(hosId, searchCondition,searchText, startDate, endDate));
    			healthEduList=healthEduService.getHealthEduListBySearch(hosId, searchCondition,searchText, startDate, endDate, page);
    			for (THealthEdu the:healthEduList) {
    				healtEducation=new HealtEducation();
    				healtEducation.setHealth(the);
    				healtEducatioList.add(healtEducation);
    			}
    			pageHtml=page.getPage("healthEducationAction!getHealthEducationBySearch.action?searchCondition="+ searchCondition + "&searchText="+ searchText + "&startDate=" + startDate + "&endDate="+ endDate);
    			return "getHealthEducationBySearch";
    		}
		}
	}
	
	//下载文件
	public void downLoadFile(){
		String inputPath;
		try {
			inputPath = healthEduService.getHealthEduById(healthEducationId).getInformation();
		
		String  fileType = inputPath.substring(inputPath.indexOf("."));
		String filename = TypeConverter.convertDate2String(Calendar.getInstance()
				.getTime(), "yyyyMMddHHmmss")+fileType;
		UploadAndDownload.download(inputPath, filename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//导出
	public String test() throws Exception{
		//从session里拿到当前登录用户的id
		int userId = GetSessionPerson.getPerson();
		
		// 判断flag -----1导出全部 2导出本页
		if (flag == 1) {
			List<HealthEducationExport> exportHealthEducation = new ArrayList<HealthEducationExport>();
			int hosId = 0;
			//user大于0,员工id
			if (userId>0) {
				hosId = staffService.getCommHospitalByStaffId(userId);
			//user小于0,社区负责人id;等于0,平台admin
			}else if (userId<0 || userId ==0) {
				hosId = Math.abs(userId);
			}
			healthEduList = healthEduService.getHealthEdusListForExport(hosId);
			if (healthEduList != null) {
				for (THealthEdu healthEdu : healthEduList) {
					HealthEducationExport he = new HealthEducationExport(healthEdu);
					exportHealthEducation.add(he);
				}
			}
			HealthEducationExport he = new HealthEducationExport();
			String[] titles = he.getTitles();
			JxlExcel Jxl = new JxlExcel(titles);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("content-disposition", "attachment;filename="+1+".xls");
			ServletOutputStream output = response.getOutputStream();
			Jxl.write(exportHealthEducation, output);
		    response.flushBuffer();
		    return null;
		}
		if (flag == 2) {
			List<HealthEducationExport> healthEduList = new ArrayList<HealthEducationExport>();
			if (ids!=null) {
			  for (int i = 0; i < ids.length; i++) {
				THealthEdu ed = healthEduService.getHealthEduById(ids[i]);
				if (ed != null) {
					HealthEducationExport he = new HealthEducationExport(ed);
					healthEduList.add(he);
				}
			}
			}
			HealthEducationExport he = new HealthEducationExport();
			String[] titles = he.getTitles();
			JxlExcel Jxl = new JxlExcel(titles);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("content-disposition", "attachment;filename="+1+".xls");
			ServletOutputStream output = response.getOutputStream();
			Jxl.write(healthEduList, output);
		    response.flushBuffer();
		    return null;
		}
		
		return "test";
		
	}
	
	
	
	
	
	
	/*getters和setters的方法*/
	public THealthEdu getHealthEducation() {
		return healthEducation;
	}

	public void setHealthEducation(THealthEdu healthEducation) {
		this.healthEducation = healthEducation;
	}

	public List<TStaff> getStaffList() {
		return staffList;
	}

	public void setStaffList(List<TStaff> staffList) {
		this.staffList = staffList;
	}

	public int getStaffsId() {
		return staffsId;
	}
	public void setStaffsId(int staffsId) {
		this.staffsId = staffsId;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public String getPageHtml() {
		return pageHtml;
	}
	public void setPageHtml(String pageHtml) {
		this.pageHtml = pageHtml;
	}
	public int getHealthEducationId() {
		return healthEducationId;
	}
	public void setHealthEducationId(int healthEducationId) {
		this.healthEducationId = healthEducationId;
	}

	public List<THealthEdu> getHealthEduList() {
		return healthEduList;
	}
	public void setHealthEduList(List<THealthEdu> healthEduList) {
		this.healthEduList = healthEduList;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getSavaPartPath() {
		return savaPartPath;
	}
	public void setSavaPartPath(String savaPartPath) {
		this.savaPartPath = savaPartPath;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public String getSearchCondition() {
		return searchCondition;
	}
	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
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


	public int getHosId() {
		return hosId;
	}


	public void setHosId(int hosId) {
		this.hosId = hosId;
	}


	public TCommunityHospital getCommunityHospital() {
		return communityHospital;
	}


	public void setCommunityHospital(TCommunityHospital communityHospital) {
		this.communityHospital = communityHospital;
	}


	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	public String getCommunityHospitalName() {
		return communityHospitalName;
	}


	public void setCommunityHospitalName(String communityHospitalName) {
		this.communityHospitalName = communityHospitalName;
	}


	public HealtEducation getHealtEducation() {
		return healtEducation;
	}


	public void setHealtEducation(HealtEducation healtEducation) {
		this.healtEducation = healtEducation;
	}


	public List<HealtEducation> getHealtEducatioList() {
		return healtEducatioList;
	}


	public void setHealtEducatioList(List<HealtEducation> healtEducatioList) {
		this.healtEducatioList = healtEducatioList;
	}


	public List<TCommunityHospital> getComHosList() {
		return comHosList;
	}


	public void setComHosList(List<TCommunityHospital> comHosList) {
		this.comHosList = comHosList;
	}


	/*public List<TStaff> getStaffs() {
		return staffs;
	}


	public void setStaffs(List<TStaff> staffs) {
		this.staffs = staffs;
	}*/

	
	
	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public int getGroupId() {
		return groupId;
	}


	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}



}
