package com.jmjk.action;

import java.sql.Date;
import java.util.ArrayList;
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
import com.jmjk.entity.TKnowledgeLecture;
import com.jmjk.entity.TStaff;
import com.jmjk.export.KnowledgeLectureExport;
import com.jmjk.iservice.ICommunityHospitalService;
import com.jmjk.iservice.IKnowledgeLectureService;
import com.jmjk.iservice.IStaffService;
import com.jmjk.pojo.DoorKnocking;
import com.jmjk.pojo.KnowledgeLecture;
import com.jmjk.service.HealthFileService;
import com.jmjk.utils.GetSessionPerson;
import com.jmjk.utils.JxlExcel;
import com.jmjk.utils.Page;
import com.jmjk.utils.Resubmit;
import com.jmjk.utils.TokenProccessor;

/**
 * 知识讲座Action
 * 
 * @author 侯子昌
 */
@Component
@Scope("prototype")
@Action(value = "knowledgeLectureAction", results = {
		@Result(name = "addKnowledgeLecture", location = "/jsp/knowledgeLecture/addKnowledgeLecture.jsp"),
		@Result(name = "saveSuccess", type = "redirectAction", location = "knowledgeLectureAction!getKnowledgeLectureListById.action"),
		@Result(name = "getKnowledgeLectureListById", location = "/jsp/knowledgeLecture/showKnowledgeLecture.jsp"),
		@Result(name = "editKnowledgeLecture", location = "/jsp/knowledgeLecture/editKnowledgeLecture.jsp"),
		@Result(name = "updateSuccess", type = "redirectAction", location = "knowledgeLectureAction!getKnowledgeLectureListById.action"),
		@Result(name = "delectKnowledgeLecture", type = "redirectAction", location = "knowledgeLectureAction!getKnowledgeLectureListById.action"),
		@Result(name = "knowledgeLectureDetails", location = "/jsp/knowledgeLecture/knowledgeledgeLectureDetails.jsp"),
		@Result(name = "getKnowledgeLectureBySearch", location = "/jsp/knowledgeLecture/showKnowledgeLecture.jsp"),
		@Result(name = "success", type = "redirectAction", location = "knowledgeLectureAction!getKnowledgeLectureListById.action"),
		@Result(name = "error", location = "/error.jsp"),
		@Result(name = "test", type = "redirectAction", location = "knowledgeLectureAction.action"), 
		@Result(name = "DocDRedir",type="redirectAction",location="knowledgeLectureAction!getKnowledgeLectureListById.action")
})
public class KnowledgeLectureAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	@Autowired
	IKnowledgeLectureService knowledgeLectureService;
	@Autowired
	IStaffService staffService;
	@Autowired
	private ICommunityHospitalService communityHospitalService;
	@Autowired
	HealthFileService healthFileService;

	private TKnowledgeLecture knowledgeLecture;
	private List<TStaff> staffList;
	private int staffsId;
	Page page = new Page(); // 分页对象
	private int cp = 1; // 当前页码
	private String pageHtml;
	private List<TKnowledgeLecture> knowledgeLectureList;
	private int knowledgeLectureId;
	private String token;
	private String searchText;
	private String knowledgeLectureStatus;
	private Date startDate;
	private Date endDate;

	// 导出
	private int flag;
	private int[] ids;

	private KnowledgeLecture knowlectal = new KnowledgeLecture(); //总的pojo
	private List<KnowledgeLecture> knowlectalList = new ArrayList<KnowledgeLecture>(); //总的pojo列表
	private TCommunityHospital communityHospital;
	private String comhosName;   //医院名称
	private String groupName;    //分组名称
	private int hospId;          //医院ID
	private int groupId;         //集团ID
	
	// 添加知识讲座实体
	public String addKnowledgeLecture() {
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){
        	return "error";      //如果集团能够添加的话报错
        }else {
        	// 从session里拿到当前登录用户的id
    		int userId = GetSessionPerson.getPerson();
    		int hosId = 0;
    		// user大于0,员工id
    		if (userId > 0) {
    			hosId = staffService.getCommHospitalByStaffId(userId);
    			// user小于0,社区负责人id;等于0,平台admin
    		} else if (userId < 0) {
    			hosId = Math.abs(userId);
    		} else {
    			return "error";
    		}
    		token = TokenProccessor.getInstance().makeToken();//创建令牌
    		HttpServletRequest request=ServletActionContext.getRequest();
    		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
    		staffList = staffService.getStaffByCommunityHospitalId(hosId);
    		return "addKnowledgeLecture";
		}
	}

	// 保存知识讲座实体
	public String saveKnowledgeLecture() {
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){
        	return "error";      //如果集团能够保存的话报错
        }else {
        	// 从session里拿到当前登录用户的id
    		int userId = GetSessionPerson.getPerson();
    		int hosId = 0;
    		// user大于0,员工id
    		if (userId > 0) {
    			hosId = staffService.getCommHospitalByStaffId(userId);
    			// user小于0,社区负责人id;等于0,平台admin
    		} else if (userId < 0) {
    			hosId = Math.abs(userId);
    		} else {
    			return "error";
    		}
    		HttpServletRequest request=ServletActionContext.getRequest();
    		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
    		if(b==true){
    			return "DocDRedir";  //重定向回首页
    		}
    		request.getSession().removeAttribute("token");//移除session中的token
    		TStaff staff = staffService.getStaffById(staffsId);
    		knowledgeLecture.setTStaff(staff);
    		knowledgeLecture.setCommunityHospitalId(hosId);

    		try {
    			knowledgeLectureService.saveKnowledgeLecture(knowledgeLecture);
    			return "saveSuccess";
    		} catch (Exception e) {
    			staffList = staffService.getStaffByCommunityHospitalId(hosId);
    			return "addKnowledgeLecture";
    		}
		}
	}

	
	// 修改知识讲座
	public String editKnowledgeLecture() {
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){
        	return "error";      //如果集团能够修改的话报错
        }else {
        	// 从session里拿到当前登录用户的id
    		int userId = GetSessionPerson.getPerson();
    		int hosId = 0;
    		// user大于0,员工id
    		if (userId > 0) {
    			hosId = staffService.getCommHospitalByStaffId(userId);
    			// user小于0,社区负责人id;等于0,平台admin
    		} else if (userId < 0) {
    			hosId = Math.abs(userId);
    		} else {
    			return "error";
    		}

    		if (hosId == knowledgeLectureService.getKnowledgeLectureById(
    				knowledgeLectureId).getCommunityHospitalId()) {
    			staffList = staffService.getStaffByCommunityHospitalId(hosId);
    			knowledgeLecture = knowledgeLectureService
    					.getKnowledgeLectureById(knowledgeLectureId);
    			staffsId = knowledgeLecture.getTStaff().getStaffId();
    			return "editKnowledgeLecture";
    		}
    		return "success";
		}
	}

	// 保存修改知识讲座
	public String updateKnowledgeLecture() {
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){
        	return "error";      //如果集团能够保存修改的话报错
        }else {
        	// 从session里拿到当前登录用户的id
    		int userId = GetSessionPerson.getPerson();
    		int hosId = 0;
    		// user大于0,员工id
    		if (userId > 0) {
    			hosId = staffService.getCommHospitalByStaffId(userId);
    			// user小于0,社区负责人id;等于0,平台admin
    		} else if (userId < 0) {
    			hosId = Math.abs(userId);
    		} else {
    			return "error";
    		}
    		if (hosId == knowledgeLecture.getCommunityHospitalId()) {
    			TStaff staff = staffService.getStaffById(staffsId);
    			knowledgeLecture.setTStaff(staff);
    			knowledgeLectureService.updateKnowledgeLecture(knowledgeLecture);
    			return "updateSuccess";
    		}
    		return "success";
		}
	}

	// 删除知识讲座
	public String deleteKnowledgeLecture() {
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){
        	return "error";      //如果集团能够删除的话报错
        }else {
        	// 从session里拿到当前登录用户的id
    		int userId = GetSessionPerson.getPerson();
    		int hosId = 0;
    		// user大于0,员工id
    		if (userId > 0) {
    			hosId = staffService.getCommHospitalByStaffId(userId);
    			// user小于0,社区负责人id;等于0,平台admin
    		} else if (userId < 0) {
    			hosId = Math.abs(userId);
    		} else {
    			return "error";
    		}

    		if (hosId == knowledgeLectureService.getKnowledgeLectureById(
    				knowledgeLectureId).getCommunityHospitalId()) {
    			try {
    				knowledgeLectureService
    						.deleteKnowledgeLecture(knowledgeLectureId);
    			} catch (Exception e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    			return "delectKnowledgeLecture";
    		}
    		return "success";
		}
	}

	// 根据社区医院Id获取知识讲座列表
		public String getKnowledgeLectureListById() {
			HttpSession session = ServletActionContext.getRequest().getSession();
	        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
	        if(group!=null){ 
	        	page.setCurrentPage(cp);
	        	page.setTotalNum(knowledgeLectureService.getKnowledgeNUmByGrop(group));
	        	knowledgeLectureList = knowledgeLectureService.getKnowledgeListByGrop(group);
	        	if (knowledgeLectureList!=null) {
				
	        	for (TKnowledgeLecture tkg:knowledgeLectureList) {
					knowlectal = new KnowledgeLecture();
					communityHospital = communityHospitalService.getCommunityHospitalById(tkg.getCommunityHospitalId());
					comhosName = communityHospital.getCommunityHospital();
					knowlectal.setKnowledge(tkg);
					knowlectal.setCommunityHospital(comhosName);
					knowlectalList.add(knowlectal);   //总的列表..........
				}	
				}
	        	pageHtml = page.getPage("knowledgeLectureAction!getKnowledgeLectureListById.action");
				return "getKnowledgeLectureListById";
	        }else {
	        	// 从session里拿到当前登录用户的id
				int userId = GetSessionPerson.getPerson();
				// user等于0，平台管理员
				if (userId == 0) {
					page.setCurrentPage(cp);
					page.setTotalNum(knowledgeLectureService.getKnowledgeLectureNumByAll());
					knowledgeLectureList = knowledgeLectureService.geKnowledgeLectureListByAll(page);
					if (knowledgeLectureList!=null) {
					
					for (TKnowledgeLecture tkg:knowledgeLectureList) {
						knowlectal = new KnowledgeLecture();
						hospId = tkg.getCommunityHospitalId();
						communityHospital = communityHospitalService.getCommunityHospitalById(hospId);//社区医院实体
	    				groupName = communityHospital.getTCommunityHospitalGroup().getGroupName();//集团名称
	    				comhosName = communityHospital.getCommunityHospital(); //社区医院名称
	    				knowlectal.setKnowledge(tkg);
	    				knowlectal.setCommunitygroup(groupName);
	    				knowlectal.setCommunityHospital(comhosName);
	    				knowlectalList.add(knowlectal);   //总的列表
					}	
					}
					pageHtml = page.getPage("knowledgeLectureAction!getKnowledgeLectureListById.action");
					return "getKnowledgeLectureListById";
				}
				int hosId = 0;
				// user大于0,员工id
				if (userId > 0) {
					if (healthFileService.getOldStaffHosByStaffId(userId)) {// 判断员工是否为责任医生，若是，则只能看到所对应的老人){
						page.setCurrentPage(cp);
						page.setTotalNum(knowledgeLectureService.getKnowledgeLectureNumForSpecial(userId));
						knowledgeLectureList = knowledgeLectureService.getKnowledgeLectureListForSpecial(userId, page);
						if (knowledgeLectureList!=null) {
							
						for (TKnowledgeLecture tkg:knowledgeLectureList) {
							knowlectal = new KnowledgeLecture();
							knowlectal.setKnowledge(tkg);
							knowlectalList.add(knowlectal);
						}
						}
						pageHtml = page.getPage("knowledgeLectureAction!getKnowledgeLectureListById.action");
						return "getKnowledgeLectureListById";
					}
					hosId = staffService.getCommHospitalByStaffId(userId);
					// user小于0,社区负责人id;等于0,平台admin
				} else if (userId < 0) {
					hosId = Math.abs(userId);
				} else {
					return "error";
				}
				page.setCurrentPage(cp);
				page.setTotalNum(knowledgeLectureService.getKnowledgeLectureNumByComhosId(hosId));
				knowledgeLectureList = knowledgeLectureService.getKnowledgeLectureListByComhosId(hosId, page);
				if (knowledgeLectureList!=null) {
					
				for (TKnowledgeLecture tkg:knowledgeLectureList) {
					knowlectal = new KnowledgeLecture();
					knowlectal.setKnowledge(tkg);
					knowlectalList.add(knowlectal);
				}
				}
				pageHtml = page.getPage("knowledgeLectureAction!getKnowledgeLectureListById.action");
				return "getKnowledgeLectureListById";
			}
		}

	// 知识讲座详情
	public String knowledgeLectureDetails() {
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){ 
        	staffList = staffService.getAllStaff();
			knowledgeLecture = knowledgeLectureService.getKnowledgeLectureById(knowledgeLectureId);
			hospId = knowledgeLecture.getCommunityHospitalId();
			communityHospital = communityHospitalService.getCommunityHospitalById(hospId);
			comhosName = communityHospital.getCommunityHospital(); //社区医院名称
			knowlectal.setKnowledge(knowledgeLecture);
			knowlectal.setCommunityHospital(comhosName);
			staffsId = knowledgeLecture.getTStaff().getStaffId();
			return "knowledgeLectureDetails";
        }else {
        	// 从session里拿到当前登录用户的id
    		int userId = GetSessionPerson.getPerson();
    		int hosId = 0;
    		// user大于0,员工id
    		if (userId > 0) {
    			hosId = staffService.getCommHospitalByStaffId(userId);
    			// user小于0,社区负责人id;等于0,平台admin
    		} else if (userId < 0) {
    			hosId = Math.abs(userId);
    		} else {
    			staffList = staffService.getAllStaff();
    			knowledgeLecture = knowledgeLectureService.getKnowledgeLectureById(knowledgeLectureId);
    			hospId = knowledgeLecture.getCommunityHospitalId();
    			communityHospital = communityHospitalService.getCommunityHospitalById(hospId);
    			comhosName = communityHospital.getCommunityHospital(); //社区医院名称
    			groupName = communityHospital.getTCommunityHospitalGroup().getGroupName();
    			knowlectal.setKnowledge(knowledgeLecture);
    			knowlectal.setCommunityHospital(comhosName);
    			knowlectal.setCommunitygroup(groupName);
    			staffsId = knowledgeLecture.getTStaff().getStaffId();
    			return "knowledgeLectureDetails";
    		}
    		if (hosId == knowledgeLectureService.getKnowledgeLectureById(knowledgeLectureId).getCommunityHospitalId()) {
    			knowledgeLecture = knowledgeLectureService.getKnowledgeLectureById(knowledgeLectureId);
    			knowlectal.setKnowledge(knowledgeLecture);
    			staffList = staffService.getStaffByCommunityHospitalId(hosId);// 需有参数值
    			staffsId = knowledgeLecture.getTStaff().getStaffId();
    			return "knowledgeLectureDetails";
    		}
    		return "success";
		}
	}

	// 查询
	public String getKnowledgeLectureBySearch() {
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(group!=null){
        	groupId = group.getGId();
        	page.setCurrentPage(cp);
        	page.setTotalNum(knowledgeLectureService.getKnowledNumGroupBySearch(groupId, searchText, knowledgeLectureStatus, startDate, endDate));
        	knowledgeLectureList = knowledgeLectureService.getKnowledListGroupBySearch(groupId, searchText, knowledgeLectureStatus, startDate, endDate, page);
        	for (TKnowledgeLecture tkg:knowledgeLectureList) {
				knowlectal = new KnowledgeLecture();
				communityHospital = communityHospitalService.getCommunityHospitalById(tkg.getCommunityHospitalId());
				comhosName = communityHospital.getCommunityHospital();
				knowlectal.setKnowledge(tkg);
				knowlectal.setCommunityHospital(comhosName);
				knowlectalList.add(knowlectal);   //总的列表..........
			}
			pageHtml = page.getPage("knowledgeLectureAction!getKnowledgeLectureBySearch.action?searchText="+searchText+"&knowledgeLectureStatus="+knowledgeLectureStatus+"&startDate="+startDate+"&endDate="+endDate);
			return "getKnowledgeLectureBySearch";
        }else {
        	// 从session里拿到当前登录用户的id
    		int userId = GetSessionPerson.getPerson();
    		int hosId = 0;
    		// user大于0,员工id
    		if (userId > 0) {
    			/*hosId = staffService.getCommHospitalByStaffId(userId);*/
    			page.setCurrentPage(cp);
        		page.setTotalNum(knowledgeLectureService.getKnowleSpecialNumBySearch(hosId, searchText, knowledgeLectureStatus, startDate, endDate));
        		knowledgeLectureList = knowledgeLectureService.getKnolSpecialListBySearch(userId, searchText, knowledgeLectureStatus, startDate, endDate, page);
        		for (TKnowledgeLecture tkg:knowledgeLectureList) {
    				knowlectal = new KnowledgeLecture();
    				knowlectal.setKnowledge(tkg);
    				knowlectalList.add(knowlectal);
    			}
        		pageHtml = page.getPage("knowledgeLectureAction!getKnowledgeLectureBySearch.action?searchText="+searchText+"&knowledgeLectureStatus="+knowledgeLectureStatus+"&startDate="+startDate+"&endDate="+endDate);
        		return "getKnowledgeLectureBySearch";
    			// user小于0,社区负责人id;等于0,平台admin
    		} else if (userId < 0) {
    			hosId = Math.abs(userId);
    		} else {
    			page.setCurrentPage(cp);
    			page.setTotalNum(knowledgeLectureService.getTKnowLedgeLectureNumBySearch(searchText,knowledgeLectureStatus, startDate, endDate));
    			knowledgeLectureList = knowledgeLectureService.getTKnowLedgeLectureListBySearch(searchText,knowledgeLectureStatus, startDate, endDate, page);
    			for (TKnowledgeLecture tkg:knowledgeLectureList) {
					knowlectal = new KnowledgeLecture();
					hospId = tkg.getCommunityHospitalId();
					communityHospital = communityHospitalService.getCommunityHospitalById(hospId);//社区医院实体
    				groupName = communityHospital.getTCommunityHospitalGroup().getGroupName();//集团名称
    				comhosName = communityHospital.getCommunityHospital(); //社区医院名称
    				knowlectal.setKnowledge(tkg);
    				knowlectal.setCommunitygroup(groupName);
    				knowlectal.setCommunityHospital(comhosName);
    				knowlectalList.add(knowlectal);   //总的列表
				}
    			pageHtml = page.getPage("knowledgeLectureAction!getKnowledgeLectureBySearch.action?searchText="+searchText+"&knowledgeLectureStatus="+knowledgeLectureStatus+"&startDate="+startDate+"&endDate="+endDate);
    			return "getKnowledgeLectureBySearch";
    		}
    		page.setCurrentPage(cp);
    		page.setTotalNum(knowledgeLectureService.getKnowledgeLectureNumBySearch(hosId, searchText,knowledgeLectureStatus, startDate, endDate));
    		knowledgeLectureList = knowledgeLectureService.getKnowledgeLectureListBySearch(hosId, searchText,knowledgeLectureStatus, startDate, endDate, page);
    		for (TKnowledgeLecture tkg:knowledgeLectureList) {
				knowlectal = new KnowledgeLecture();
				knowlectal.setKnowledge(tkg);
				knowlectalList.add(knowlectal);
			}
    		pageHtml = page.getPage("knowledgeLectureAction!getKnowledgeLectureBySearch.action?searchText="+searchText+"&knowledgeLectureStatus="+knowledgeLectureStatus+"&startDate="+startDate+"&endDate="+endDate);
    		return "getKnowledgeLectureBySearch";
		}
	}

	// 导出
	public String test() throws Exception {

		// 从session里拿到当前登录用户的id
		int userId = GetSessionPerson.getPerson();// 判断 flag-----1 导出全部 2导出本页
		if (flag == 1) {
			List<KnowledgeLectureExport> exportKnowledgeLecture = new ArrayList<KnowledgeLectureExport>();
			int hosId = 0;
			// user大于0,员工id
			if (userId > 0) {
				hosId = staffService.getCommHospitalByStaffId(userId);
				// user小于0,社区负责人id;等于0,平台admin
			} else if (userId < 0 || userId == 0) {
				hosId = Math.abs(userId);
			}
			knowledgeLectureList = knowledgeLectureService
					.getKnowledgeLectureListById(hosId);
			if (knowledgeLectureList != null) {
				for (TKnowledgeLecture knowledgeLecture : knowledgeLectureList) {
					KnowledgeLectureExport kl = new KnowledgeLectureExport(
							knowledgeLecture);
					exportKnowledgeLecture.add(kl);
				}
			}
			KnowledgeLectureExport kl = new KnowledgeLectureExport();
			String[] titles = kl.getTitles();
			JxlExcel Jxl = new JxlExcel(titles);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("content-disposition", "attachment;filename="
					+ 2 + ".xls");
			ServletOutputStream output = response.getOutputStream();
			Jxl.write(exportKnowledgeLecture, output);
			response.flushBuffer();
			return null;
		}
		if (flag == 2) {
			List<KnowledgeLectureExport> knowledgeLectureList = new ArrayList<KnowledgeLectureExport>();
			if (ids != null) {
				for (int i = 0; i < ids.length; i++) {
					TKnowledgeLecture st = knowledgeLectureService
							.getKnowledgeLectureById(ids[i]);
					if (st != null) {
						KnowledgeLectureExport kl = new KnowledgeLectureExport(
								st);
						knowledgeLectureList.add(kl);
					}
				}
			}
			KnowledgeLectureExport kl = new KnowledgeLectureExport();
			String[] titles = kl.getTitles();
			JxlExcel Jxl = new JxlExcel(titles);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setHeader("content-disposition", "attachment;filename="
					+ 1 + ".xls");
			ServletOutputStream output = response.getOutputStream();
			Jxl.write(knowledgeLectureList, output);
			response.flushBuffer();
			return null;
		}
		return "test";
	}

	/* Gerters Seters */
	public TKnowledgeLecture getKnowledgeLecture() {
		return knowledgeLecture;
	}

	public void setKnowledgeLecture(TKnowledgeLecture knowledgeLecture) {
		this.knowledgeLecture = knowledgeLecture;
	}

	public List<TStaff> getStaffList() {
		return staffList;
	}

	public void setStaffList(List<TStaff> staffList) {
		this.staffList = staffList;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
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

	public List<TKnowledgeLecture> getKnowledgeLectureList() {
		return knowledgeLectureList;
	}

	public void setKnowledgeLectureList(
			List<TKnowledgeLecture> knowledgeLectureList) {
		this.knowledgeLectureList = knowledgeLectureList;
	}

	public int getKnowledgeLectureId() {
		return knowledgeLectureId;
	}

	public void setKnowledgeLectureId(int knowledgeLectureId) {
		this.knowledgeLectureId = knowledgeLectureId;
	}

	public int getStaffsId() {
		return staffsId;
	}

	public void setStaffsId(int staffsId) {
		this.staffsId = staffsId;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public String getKnowledgeLectureStatus() {
		return knowledgeLectureStatus;
	}

	public void setKnowledgeLectureStatus(String knowledgeLectureStatus) {
		this.knowledgeLectureStatus = knowledgeLectureStatus;
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

	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public IKnowledgeLectureService getKnowledgeLectureService() {
		return knowledgeLectureService;
	}

	public void setKnowledgeLectureService(
			IKnowledgeLectureService knowledgeLectureService) {
		this.knowledgeLectureService = knowledgeLectureService;
	}

	public IStaffService getStaffService() {
		return staffService;
	}

	public void setStaffService(IStaffService staffService) {
		this.staffService = staffService;
	}

	public ICommunityHospitalService getCommunityHospitalService() {
		return communityHospitalService;
	}

	public void setCommunityHospitalService(
			ICommunityHospitalService communityHospitalService) {
		this.communityHospitalService = communityHospitalService;
	}

	public HealthFileService getHealthFileService() {
		return healthFileService;
	}

	public void setHealthFileService(HealthFileService healthFileService) {
		this.healthFileService = healthFileService;
	}

	public KnowledgeLecture getKnowlectal() {
		return knowlectal;
	}

	public void setKnowlectal(KnowledgeLecture knowlectal) {
		this.knowlectal = knowlectal;
	}

	public List<KnowledgeLecture> getKnowlectalList() {
		return knowlectalList;
	}

	public void setKnowlectalList(List<KnowledgeLecture> knowlectalList) {
		this.knowlectalList = knowlectalList;
	}

	public TCommunityHospital getCommunityHospital() {
		return communityHospital;
	}

	public void setCommunityHospital(TCommunityHospital communityHospital) {
		this.communityHospital = communityHospital;
	}

	public String getComhosName() {
		return comhosName;
	}

	public void setComhosName(String comhosName) {
		this.comhosName = comhosName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public int getHospId() {
		return hospId;
	}

	public void setHospId(int hospId) {
		this.hospId = hospId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

}
