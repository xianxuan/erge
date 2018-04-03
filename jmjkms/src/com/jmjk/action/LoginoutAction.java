package com.jmjk.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.jmjk.action.base.BaseAction;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.TPower;
import com.jmjk.entity.TRights;
import com.jmjk.entity.TRole;
import com.jmjk.entity.TStaff;
import com.jmjk.enums.Admin_IsHead;
import com.jmjk.enums.OperatorState;
import com.jmjk.enums.Result_Login;
import com.jmjk.enums.RightsValue;
import com.jmjk.geetest.GeetestConfig;
import com.jmjk.geetest.GeetestLib;
import com.jmjk.pojo.Rights;
import com.jmjk.pojo.Rights.Right;
import com.jmjk.service.CommunityHospitalGroupService;
import com.jmjk.service.CommunityHospitalService;
import com.jmjk.service.HealthFileService;
import com.jmjk.service.PowerService;
import com.jmjk.service.RightsService;
import com.jmjk.service.RoleService;
import com.jmjk.service.StaffService;
import com.jmjk.utils.Encryt;
import com.jmjk.utils.GetSessionPerson;
import com.jmjk.utils.WebXMLParameter;

/**
 * 登录，注销以及修改密码
 * @author xuleping
 *
 */

@Scope("prototype")
@Component
@Action(value="LoginoutAction", results={
	@Result(name="login",location="/login.jsp"),
	@Result(name="adminLogin",location="/adminLogin.jsp"),
	//用action跳到jsp时,重定向显示的是jsp地址；如果需要重定向的话，跳到jsp用redirect,跳到action用redirection
	@Result(name="logout",location="/login.jsp",type="redirect"),
	@Result(name="adminLogout",location="/adminLogin.jsp",type="redirect"),
	@Result(name="index",location="/index.jsp"),
	//@Result(name="hqRoleList",location="/login.jsp"),
	@Result(name="jumpToChangePassword",location="/jsp/staffManage/staffInfoManage/changePassword.jsp"),
	@Result(name="changePassword",location="/jsp/staffManage/staffInfoManage/changePassword.jsp"),
	@Result(name="jumpToadminChangePassword",location="/jsp/staffManage/staffInfoManage/adminChangePassword.jsp"),
	@Result(name="adminChangePassword",location="/jsp/staffManage/staffInfoManage/adminChangePassword.jsp"),
	
	
})
public class LoginoutAction extends BaseAction {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private StaffService staffService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private CommunityHospitalService communityHospitalService;
	@Autowired
	private RightsService rightsService;
	@Autowired
	private PowerService powerService;
	@Autowired
	private HealthFileService healthFileService;
	@Autowired
	private CommunityHospitalGroupService communityHospitalGroupService;
	
	private TStaff tstaff;  
	private TCommunityHospital comHospital;
	private TCommunityHospitalGroup communityHospitalGroup;
	private int resultcode; // 0,初始,1,"密码错误" 3,验证码错误 2,"登录成功" 4.用户不存在 5.该用户被禁用
	private String verifysession; // session中的验证码
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response = ServletActionContext.getResponse();
	private String loginName;//账号
	private String password;//密码
	private String vcode;
	
	private List<TRole> roleList;//角色列表
	private String roleOption; 
	private int staffId;
	private String newpassword;//新密码
	private String prepassword;//旧密码
	private int result=0;
	private TRole role;//角色实体
	private String roleName;//角色名称（后台传过来的）
	//private String name;//角色名称
	List<TRights> rightsList;
	private String option;//员工下拉框名称（角色选项）
	//private int IsAdmin;//后台取得是否是社区负责人
	//private int admin;  //前台传过来的，管理员下拉框
	private String denglu;
	private int communityHospitalId;//社区医院id
	private int groupId;
//	private String pass;//从数据库中读取的密码
	
	private List<TPower> listpowers;
	private List<String> listModule=new ArrayList<String>();
	private List<String> listNoMenue=new ArrayList<String>();
	private String rightsCode;
	private List<TRights> listRights;
	private List<String> listMo =new ArrayList<String>();
	private int rightsValue;
	private String module;
	private String rightsName;
	private String msg;
	private String identity;
	private Cookie cookie;
	/*private HttpServletRequest request=ServletActionContext.getRequest();
	private HttpServletResponse response=ServletActionContext.getResponse();*/

	
	//从数据库中读取数据到页面上的时候用
	/*public String hqRoleList(){
		roleList=roleService.getAllRole();
		return "hqRoleList";
	}*/
	//管理员登录
	public String adminCheck(){
		if (loginName.equals("") || password .equals("")) {
			return "adminLogin";
		}	
		comHospital=communityHospitalService.getCommunityHospitalByLogin(loginName);
		communityHospitalGroup=communityHospitalGroupService.getComHosGroupByLogin(loginName);
		if(comHospital==null && communityHospitalGroup==null){
			resultcode = Result_Login.NO_USER.getValue();
			return "adminLogin";
		}else if(comHospital!=null&&communityHospitalGroup==null){
		    if(comHospital.getIsHead()==Admin_IsHead.shequfuzeren.getValue()){
		        resultcode = Result_Login.NO_USER.getValue();
	            return "adminLogin"; 
		    }
			Result_Login result =(Result_Login) communityHospitalService.loginCheck(loginName, password); 
			if (result.getValue() == Result_Login.PASS_ERROR.getValue()) {
				resultcode=Result_Login.PASS_ERROR.getValue();
				return "adminLogin";
			} else {
				//0为启用，1为禁用
				if (comHospital.getStatus().equals("1")) {
					resultcode=Result_Login.USEABLE_ERROR.getValue();
					return "adminLogin";
				}
				resultcode=Result_Login.LOGIN_SUCCESS.getValue();
				
				//增加登录cookie,用于自动跳转页面
				cookie=new Cookie("user", "adminLogin");
				response.addCookie(cookie);
				
				//communityHospitalService.updateCommunityHospital(comHospital);
				HttpSession session = ServletActionContext.getRequest().getSession();
				session.removeAttribute("comHospital");
				session.removeAttribute("communityHospitalGroup");
				session.removeAttribute("tstaff");
				session.setAttribute("comHospital", comHospital);
				return "index";
			}		
		}
		else{
			Result_Login result =(Result_Login) communityHospitalGroupService.loginCheck(loginName, password); 
			if (result.getValue() == Result_Login.PASS_ERROR.getValue()) {
				resultcode=Result_Login.PASS_ERROR.getValue();
				return "adminLogin";
			} else {
				//0为启用，1为禁用
				if (communityHospitalGroup.getGroupStatus().equals("1")) {
					resultcode=Result_Login.USEABLE_ERROR.getValue();
					return "adminLogin";
				}
				resultcode=Result_Login.LOGIN_SUCCESS.getValue();
				communityHospitalGroupService.updateComHosGroup(communityHospitalGroup);
				HttpSession session = ServletActionContext.getRequest().getSession();
				session.removeAttribute("comHospital");
				session.removeAttribute("tstaff");
				session.removeAttribute("communityHospitalGroup");
				session.setAttribute("communityHospitalGroup", communityHospitalGroup);
				
				//增加登录cookie,用于自动跳转页面
				cookie=new Cookie("user", "adminLogin");
				response.addCookie(cookie);
				
				return "index";
			}
		}
	}
	//角色登录
	public String check() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		//用户或者密码为空
		if (loginName.equals("") || password.equals("")) {
			return "login";
		}
		
		if("staff".equals(identity))
		{
		 // 0,初始,1,"密码错误" 3,验证码错误 2,"登录成功" 4.用户不存在 5.该用户被禁用
	        tstaff = staffService.getStaffByloginName(loginName);       
	        if (tstaff == null||tstaff.getOperateState()==OperatorState.shanchu.getvalue()) {
	            resultcode = Result_Login.NO_USER.getValue();       
	            return "login";
	        } else {
	            Result_Login result = (Result_Login) staffService.loginCheck(loginName, password);
	            if (result.getValue() == Result_Login.PASS_ERROR.getValue()) {
	                resultcode = Result_Login.PASS_ERROR.getValue();
	                return "login";
	            } else {
	                //0为启用，1为禁用
//	             字符串用equal，注意！！！！
	                if (tstaff.getOperateState()==OperatorState.yiyuanjinyong.getvalue()||tstaff.getOperateState()==OperatorState.gerenjinyong.getvalue()) {                    
	                    //resultcode = "用户被禁用";
	                    resultcode = Result_Login.USEABLE_ERROR.getValue();
	                    return "login";
	                }
	                session.removeAttribute("comHospital");
	                session.removeAttribute("communityHospitalGroup");
	                session.removeAttribute("tstaff");
	                session.setAttribute("tstaff", tstaff); 
	                String comHosName = staffService.getOldStaffHosByStaffId(tstaff.getStaffId()).getTCommunityHospital().getCommunityHospital();
	                session.setAttribute("comHosName", comHosName);
	                
	                //增加登录cookie,用于自动跳转页面
	                cookie=new Cookie("user", "login");
	                response.addCookie(cookie);
	                
	                return "index";
	            }
	        }
		}
		else
		{
		    comHospital=communityHospitalService.getCommunityHospitalByLogin(loginName);
		    if(comHospital==null||comHospital.getIsHead()==Admin_IsHead.guanliyuan.getValue()){
	            resultcode = Result_Login.NO_USER.getValue();
	            return "login";
	        }else{
	            Result_Login result =(Result_Login) communityHospitalService.loginCheck(loginName, password); 
	            if (result.getValue() == Result_Login.PASS_ERROR.getValue()) {
	                resultcode=Result_Login.PASS_ERROR.getValue();
	                return "login";
	            } else {
	                //0为启用，1为禁用
	                if (comHospital.getStatus().equals("1")) {
	                    resultcode=Result_Login.USEABLE_ERROR.getValue();
	                    return "login";
	                }
	                resultcode=Result_Login.LOGIN_SUCCESS.getValue();
	                
	                //增加登录cookie,用于自动跳转页面
	                cookie=new Cookie("user", "login");
	                response.addCookie(cookie);
	                
	                session.removeAttribute("comHospital");
	                session.removeAttribute("communityHospitalGroup");
	                session.removeAttribute("tstaff");
	                session.setAttribute("comHospital", comHospital);
	                return "index";
	            }       
	        }
		}
		
	}

	public void StartCaptchaServlet() {
		request = ServletActionContext.getRequest();
		response = ServletActionContext.getResponse();
		HttpSession session = ServletActionContext.getRequest().getSession();
		GeetestLib gtSdk = new GeetestLib(GeetestConfig.getCaptcha_id(),
				GeetestConfig.getPrivate_key());

		String resStr = "{}";

		// 进行验证预处理
		int gtServerStatus = gtSdk.preProcess();

		// 将服务器状态设置到session中
		request.getSession().setAttribute(gtSdk.gtServerStatusSessionKey,
				gtServerStatus);

		resStr = gtSdk.getResponseStr();

		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(resStr);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 //验证码
	public int getValidateCode() {
		request = ServletActionContext.getRequest();
		HttpSession session = ServletActionContext.getRequest().getSession();
		GeetestLib gtSdk = new GeetestLib(GeetestConfig.getCaptcha_id(),GeetestConfig.getPrivate_key());
		String challenge = request.getParameter(GeetestLib.fn_geetest_challenge);
		String validate = request.getParameter(GeetestLib.fn_geetest_validate);
		String seccode = request.getParameter(GeetestLib.fn_geetest_seccode);
		// 从session中获取gt-server状态
		int gt_server_status_code = (Integer) request.getSession().getAttribute(gtSdk.gtServerStatusSessionKey);
		int gtResult = 0;
		if (gt_server_status_code == 1) {
			// gt-server正常，向gt-server进行二次验证
			gtResult = gtSdk.enhencedValidateRequest(challenge, validate,
					seccode);
		} else {
			// gt-server非正常情况下，进行failback模式验证
			gtResult = gtSdk.failbackValidateRequest(challenge, validate,
					seccode);
		}
		return gtResult;
	}
	
	
	
	//角色注销
	 public String logout() {
		 HttpSession session = ServletActionContext.getRequest().getSession();
		 	session.invalidate();
			return "logout";
		}
	 //管理员注销
	 public String adminLogout() {
		 HttpSession session = ServletActionContext.getRequest().getSession();
		 	session.invalidate();
			return "adminLogout";
		}
	//测试登录							
	 public String test(){
		 HttpSession session = ServletActionContext.getRequest().getSession();
		 comHospital=communityHospitalService.getCommunityHospitalById(2);
		 session.setAttribute("comHospital", comHospital);
		 //staff=staffService.getStaffById(staffId);
		 tstaff=staffService.getStaffById(55);
		 session.setAttribute("staff", tstaff);
		 return "index";
	 }
	 
	 //普通员工修改密码
	 public String changePassword() {
			HttpSession session = ServletActionContext.getRequest().getSession();
			TStaff tstaff =(TStaff) session.getAttribute("tstaff");
			TCommunityHospital comHospital =(TCommunityHospital) session.getAttribute("comHospital");
			//旧密码经加密之后的密码		
			String password =Encryt.encryptString_md5(prepassword);
			if(tstaff!=null){
			    if (!password.equals(tstaff.getPassword())) {
	                //原密码错误
	                result=2;
	                return "changePassword";
	            } else {
	                if(tstaff.getPassword().equals(Encryt.encryptString_md5(newpassword))){
	                    //与原密码相同请重新修改
	                    result=3;
	                    return "changePassword";
	                }
	                tstaff = staffService.getStaffById(staffId);
	                tstaff.setPassword(Encryt.encryptString_md5(newpassword));
	                staffService.updateStaff(tstaff);
	                session.setAttribute("tstaff",tstaff);
	                //修改成功
	                result=1;
	                return "login";
	            }
			}
			else{
                if (!password.equals(comHospital.getPassword())) {
                    //原密码错误
                    result=2;
                    return "changePassword";
                } else {                
                        if(comHospital.getPassword().equals(Encryt.encryptString_md5(newpassword))){
                        //与原密码相同请重新修改
                        result=3;
                        return "changePassword";
                    }
                        comHospital=communityHospitalService.getCommunityHospitalById(communityHospitalId);
                        comHospital.setPassword(Encryt.encryptString_md5(newpassword));
                        communityHospitalService.updateCommunityHospital(comHospital);
                        session.setAttribute("comHospital",comHospital);
                        //修改成功
                        result=1;
                        return "login";
                }
			}
	 }
                                
	 
	//角色修改密码页面
	 public String jumpToChangePassword(){
		 return "jumpToChangePassword";
	 }
	 
	 //管理员修改密码
	 public String adminChangePassword() {
			HttpSession session = ServletActionContext.getRequest().getSession();			
			TCommunityHospitalGroup communityHospitalGroup=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
			TCommunityHospital comHospital =(TCommunityHospital) session.getAttribute("comHospital");
			if(communityHospitalGroup!=null){
				String password =Encryt.encryptString_md5(prepassword);
				if (!password.equals(communityHospitalGroup.getGroupPassword())) {
					//原密码错误
					result=2;
					return "adminChangePassword";
				} else {
					if(communityHospitalGroup.getGroupPassword().equals(Encryt.encryptString_md5(newpassword))){
						//与原密码相同请重新修改
						result=3;
						return "adminChangePassword";
					}
					communityHospitalGroup =communityHospitalGroupService.getComHosGroupByGroupId(groupId);
					communityHospitalGroup.setGroupPassword(Encryt.encryptString_md5(newpassword));
					communityHospitalGroupService.updateComHosGroup(communityHospitalGroup);
					session.setAttribute("communityHospitalGroup",communityHospitalGroup);
					//修改成功
					result=1;
					return "adminLogin";
				}
			}				
			if(comHospital!=null){				
				String password =Encryt.encryptString_md5(prepassword);					
					if (!password.equals(comHospital.getPassword())) {
						//原密码错误
						result=2;
						return "adminChangePassword";
					} else {				
							if(comHospital.getPassword().equals(Encryt.encryptString_md5(newpassword))){
							//与原密码相同请重新修改
							result=3;
							return "adminChangePassword";
						}
							comHospital=communityHospitalService.getCommunityHospitalById(communityHospitalId);
							comHospital.setPassword(Encryt.encryptString_md5(newpassword));
							communityHospitalService.updateCommunityHospital(comHospital);
							session.setAttribute("comHospital",comHospital);
							//修改成功
							result=1;
							return "adminLogin";	
									
				}
			}
			return "adminLogin";
		}
	 
	 //管理员修改密码页面
	 public String jumpToadminChangePassword(){
		 return "jumpToadminChangePassword";
	 }
	 
	/**
	 * 根据角色动态显示菜单
	 * @author 宋慧丽
	 */
		public void getMenuList(){
			//得到所有菜单名称
			listpowers=powerService.getPowers();
			int flag1=1;//1代表当前的一级菜单已经放入list中,2代表当前的TPower实体为二级菜单,并且已经放入list中;
			for(int i=0;i<listpowers.size();i++)
			{
				if(listpowers.get(i).getValue()==null){
					flag1=1;
					rightsCode=listpowers.get(i).getCode();
					listModule.add(rightsCode);
				}
				else if(listpowers.get(i).getFirst()==listpowers.get(i).getSecond())
					//代表当前TPower实体没有 
				{
					listModule.add(listpowers.get(i).getCode());
					
				}
				else{
					if(flag1==1){
						listModule.add(listpowers.get(i).getCode());
					}
					if(i<listpowers.size()-1){
						if(listpowers.get(i).getCode().equals(listpowers.get(i+1).getCode())){
							flag1=2;
						}
						else {
							flag1=1;
						}
					}
				}
			}
			//获取社区集团
			HttpSession session = ServletActionContext.getRequest().getSession();
			TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
			if(group!=null){
			    listNoMenue.add("10203");
			    listNoMenue.add("10204");
			    listNoMenue.add("10205");
			    listNoMenue.add("02202");
			}
			else{
			        //////////////以下为获取员工 所具有的权限菜单名称
			    int a=GetSessionPerson.getPerson();//获得当前登录用户的ID或者管理员 或 社区负责人
	            //平台管理员(返回0)  社区负责人(返回 社区医院ID的负值 )  若都不是   则获取当前登录   员工的ID(正值)  
	            
	            //////员工
	            if(a>0){
	                staffId=a;
	                listRights=rightsService.getAllRightsByStaffId(staffId);
	                int flag2=1;//1代表要加入一级菜单,2代表只加入二级菜单
	                for(int i=0;i<listRights.size();i++)
	                {
	                    if(listRights.get(i).getModule().equals(listRights.get(i).getRightsName())){
	                        listMo.add(listRights.get(i).getRightsCode());
	                        flag2=1;
	                    }
	                    else{
	                        if(flag2==1){
	                            ////////
	                            listMo.add(powerService.getTPowerFirstBySecond(listRights.get(i).getRightsCode()).getCode());
	                            listMo.add(listRights.get(i).getRightsCode());
	                            
	                        }
	                        else {
	                            listMo.add(listRights.get(i).getRightsCode());
	                        }
	                    }
	                    if(i<listRights.size()-1){
	                        if(listRights.get(i).getModule().equals(listRights.get(i+1).getModule())){
	                            flag2=2;
	                        }
	                        else{
	                            flag2=1;
	                        }
	                    }
	                    
	                }
	                if(healthFileService.getOldStaffHosByStaffId(staffId)){
	                    listMo.add(WebXMLParameter.getColumnCod("two_two"));
	                }
	                
	                for(String str2 : listModule){
	                    if(!listMo.contains(str2)){
	                        listNoMenue.add(str2);
	                    }
	                }
	            }
	            ////////如果是系统管理员,不显示权限分配模块，其余模块都显示
	            else if(a==0){//管理员
	                listNoMenue.add("10201");
	                listNoMenue.add("10204");
	                listNoMenue.add("02202");//不显示健康建议
	            }
	            //////社区负责人不能查看系统管理和统计分析
	            else if(a<0) {//社区负责人
	                listNoMenue.add("10201");
	                listNoMenue.add("10202");
	                listNoMenue.add("10203");
	                listNoMenue.add("10205");
	            }
			}
			
			this.writeJson(listNoMenue);
		}
	 
		/**
		 * 根据登录用户的权限,动态显示按钮,其中管理员在系统管理和统计分析里具有所有权限,在其他模块中只具有查看打印的权限;
		 * 社区负责人具有系统管理和统计分析之外其他模块的全部权限
		 * @author 宋慧丽
		 */
		public void  getButtonlist(){
			Rights myRights=new Rights();
			ArrayList<Right> riglist=new ArrayList<Right>();
			
			//获取社区集团
            HttpSession session = ServletActionContext.getRequest().getSession();
            TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
            if(group!=null){
                listpowers=new ArrayList<TPower>();
                listpowers=powerService.getPowers();
                List<String> listnames=new ArrayList<String>();
                for(int i=0;i<listpowers.size();i++){
                    if(listnames.contains(listpowers.get(i).getSecond())){
                        continue;
                    }
                    else{
                        if(listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("ten_four"))
                                ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("ten_five"))
                                ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("two_two"))
                                ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("ten_three"))){
                            continue;
                        }
                    if (listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("ten_one"))
                            || listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("ten_two"))
                            || listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("eight_one"))
                            || listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("eight_two"))
                            || listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("eight_three"))) {
                        Right rig=myRights.new Right();
                            rig.setModule(listpowers.get(i).getFirst());
                            rig.setRightsCode(listpowers.get(i).getCode());
                            rig.setRightsName(listpowers.get(i).getSecond());
                            rig.setRightsValue(RightsValue.xianshi.getValue()+","+RightsValue.tianjia.getValue()+","+RightsValue.xiugai.getValue()+","+RightsValue.shanchu.getValue()+","+RightsValue.daochu.getValue()+","+RightsValue.dayin.getValue());
                            riglist.add(rig);
                            listnames.add(listpowers.get(i).getSecond());
                        }
                        /*else if(listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("one_one"))
                                ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("one_two"))
                                ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("three"))
                                ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("six_one"))
                                ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("six_two"))
                                ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("six_three"))
                                ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("six_four"))
                                ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("six_five"))
                                ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("six_six"))
                                ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("six_seven"))
                                ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("seven_one"))
                                ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("seven_two"))
                                ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("seven_three"))
                                ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("seven_four"))
                                ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("nine"))){
                            
                        }*/
                        else if(listpowers.get(i).getValue()!=null){
                            Right rig=myRights.new Right();
                            rig.setModule(listpowers.get(i).getFirst());
                            rig.setRightsCode(listpowers.get(i).getCode());
                            rig.setRightsName(listpowers.get(i).getSecond());
                            rig.setRightsValue(RightsValue.xianshi.getValue()+","+RightsValue.dayin.getValue());
                            riglist.add(rig);
                            listnames.add(listpowers.get(i).getSecond());
                        }
                    }
                    
                    
                }
                myRights.setRights(riglist);
            }
            else{
                int a=GetSessionPerson.getPerson();//获得当前登录用户的ID或者管理员 或 社区负责人
                //平台管理员(返回0)  社区负责人(返回 社区医院ID的负值 )  若都不是   则获取当前登录   员工的ID(正值)  
                
                ///员工
                if(a>0){
                    staffId=a;
                    listRights=rightsService.getAllRightsByStaffId(staffId);
                    for(int i=0;i<listRights.size();i++){
                        String value="";
                        rightsValue=listRights.get(i).getRightsValue();
                        if((rightsValue&RightsValue.xianshi.getValue())!=0){
                            value=value+RightsValue.xianshi.getValue()+",";
                        }
                        if((rightsValue&RightsValue.tianjia.getValue())!=0){
                            value=value+RightsValue.tianjia.getValue()+",";
                        }
                        if((rightsValue&RightsValue.xiugai.getValue())!=0){
                            value=value+RightsValue.xiugai.getValue()+",";
                        }
                        if((rightsValue&RightsValue.shanchu.getValue())!=0){
                            value=value+RightsValue.shanchu.getValue()+",";
                        }
                        if((rightsValue&RightsValue.dayin.getValue())!=0){
                            value=value+RightsValue.dayin.getValue()+",";
                        }
                        if((rightsValue&RightsValue.daochu.getValue())!=0){
                            value=value+RightsValue.daochu.getValue()+",";
                        }
                        if(value==""){
                            break;
                        }
                        else{
                            Right rig=myRights.new Right();
                            String val=value.substring(0, value.length()-1);
                            module=listRights.get(i).getModule();
                            rightsCode=listRights.get(i).getRightsCode();
                            rightsName=listRights.get(i).getRightsName();
                            rig.setModule(module);
                            rig.setRightsCode(rightsCode);
                            rig.setRightsName(rightsName);
                            rig.setRightsValue(val);
                            riglist.add(rig);
                        }
                    }
                    myRights.setRights(riglist);
                }
                ////////管理员
                else if(a==0){
                    listpowers=new ArrayList<TPower>();
                    listpowers=powerService.getPowers();
                    List<String> listnames=new ArrayList<String>();
                    for(int i=0;i<listpowers.size();i++){
                        if(listnames.contains(listpowers.get(i).getSecond())){
                            continue;
                        }
                        else {
						if (listpowers
								.get(i)
								.getCode()
								.equals(WebXMLParameter
										.getColumnCod("ten_four"))) {
							continue;
						}
						if (listpowers
										.get(i)
										.getCode()
										.equals(WebXMLParameter
												.getColumnCod("ten_two"))
								|| listpowers
										.get(i)
										.getCode()
										.equals(WebXMLParameter
												.getColumnCod("ten_three"))
												|| listpowers
										.get(i)
										.getCode()
										.equals(WebXMLParameter
												.getColumnCod("ten_five"))
								|| listpowers
										.get(i)
										.getCode()
										.equals(WebXMLParameter
												.getColumnCod("eight_one"))
								|| listpowers
										.get(i)
										.getCode()
										.equals(WebXMLParameter
												.getColumnCod("eight_two"))
								|| listpowers
										.get(i)
										.getCode()
										.equals(WebXMLParameter
												.getColumnCod("eight_three"))) {
							Right rig = myRights.new Right();
							rig.setModule(listpowers.get(i).getFirst());
							rig.setRightsCode(listpowers.get(i).getCode());
							rig.setRightsName(listpowers.get(i).getSecond());
							rig.setRightsValue(RightsValue.xianshi.getValue()
									+ "," + RightsValue.tianjia.getValue()
									+ "," + RightsValue.xiugai.getValue() + ","
									+ RightsValue.shanchu.getValue() + ","
									+ RightsValue.daochu.getValue() + ","
									+ RightsValue.dayin.getValue());
							riglist.add(rig);
							listnames.add(listpowers.get(i).getSecond());
						}
                            /*else if(listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("one_one"))
                                    ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("one_two"))
                                    ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("three"))
                                    ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("six_one"))
                                    ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("six_two"))
                                    ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("six_three"))
                                    ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("six_four"))
                                    ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("six_five"))
                                    ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("six_six"))
                                    ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("six_seven"))
                                    ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("seven_one"))
                                    ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("seven_two"))
                                    ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("seven_three"))
                                    ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("seven_four"))
                                    ||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("nine"))){
                                
                            }*/
                            else if(listpowers.get(i).getValue()!=null){
                                Right rig=myRights.new Right();
                                rig.setModule(listpowers.get(i).getFirst());
                                rig.setRightsCode(listpowers.get(i).getCode());
                                rig.setRightsName(listpowers.get(i).getSecond());
                                rig.setRightsValue(RightsValue.xianshi.getValue()+","+RightsValue.dayin.getValue());
                                riglist.add(rig);
                                listnames.add(listpowers.get(i).getSecond());
                            }
                        }
                        
                        
                    }
                    myRights.setRights(riglist);
                }
                /////////社区负责人
                else if(a<0){
                    listpowers=new ArrayList<TPower>();
                    listpowers=powerService.getPowers();
                    List<String> listnames=new ArrayList<String>();
                    for(int i=0;i<listpowers.size();i++){
                        if(listnames.contains(listpowers.get(i).getSecond())){
                            continue;
                        }
                        else{
                            if(listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("ten_one"))||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("ten_two"))||listpowers.get(i).getCode().equals(WebXMLParameter.getColumnCod("ten_three"))){
                                continue;
                            }
                            else if(listpowers.get(i).getValue()!=null){
                                Right rig=myRights.new Right();
                                rig.setModule(listpowers.get(i).getFirst());
                                rig.setRightsCode(listpowers.get(i).getCode());
                                rig.setRightsName(listpowers.get(i).getSecond());
                                rig.setRightsValue(RightsValue.xianshi.getValue()+","+RightsValue.tianjia.getValue()+","+RightsValue.xiugai.getValue()+","+RightsValue.shanchu.getValue()+","+RightsValue.daochu.getValue()+","+RightsValue.dayin.getValue());
                                riglist.add(rig);
                                listnames.add(listpowers.get(i).getSecond());
                            }
                        }
                    }
                    myRights.setRights(riglist);
                }
            }
			msg=JSON.toJSONString(riglist);
			this.writeJson(msg);
		}	
		
	public TStaff getTstaff() {
		return tstaff;
	}

	public void setTstaff(TStaff tstaff) {
		this.tstaff = tstaff;
	}

	public TCommunityHospital getComHospital() {
		return comHospital;
	}
	public void setComHospital(TCommunityHospital comHospital) {
		this.comHospital = comHospital;
	}

	public int getResultcode() {
		return resultcode;
	}
	public void setResultcode(int resultcode) {
		this.resultcode = resultcode;
	}
	
	public StaffService getStaffService() {
		return staffService;
	}
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	public RoleService getRoleService() {
		return roleService;
	}
	public void setRoleService(RoleService roleService) {
		this.roleService = roleService;
	}
	public CommunityHospitalService getCommunityHospitalService() {
		return communityHospitalService;
	}
	public void setCommunityHospitalService(
			CommunityHospitalService communityHospitalService) {
		this.communityHospitalService = communityHospitalService;
	}
	public RightsService getRightsService() {
		return rightsService;
	}
	public void setRightsService(RightsService rightsService) {
		this.rightsService = rightsService;
	}
	public PowerService getPowerService() {
		return powerService;
	}
	public CommunityHospitalGroupService getCommunityHospitalGroupService() {
        return communityHospitalGroupService;
    }
    public void setCommunityHospitalGroupService(CommunityHospitalGroupService communityHospitalGroupService) {
        this.communityHospitalGroupService = communityHospitalGroupService;
    }
    public String getIdentity() {
        return identity;
    }
    public void setIdentity(String identity) {
        this.identity = identity;
    }
    public Cookie getCookie() {
        return cookie;
    }
    public void setCookie(Cookie cookie) {
        this.cookie = cookie;
    }
    public void setPowerService(PowerService powerService) {
		this.powerService = powerService;
	}
	public List<TPower> getListpowers() {
		return listpowers;
	}
	public void setListpowers(List<TPower> listpowers) {
		this.listpowers = listpowers;
	}
	public List<String> getListModule() {
		return listModule;
	}
	public void setListModule(List<String> listModule) {
		this.listModule = listModule;
	}
	public List<String> getListNoMenue() {
		return listNoMenue;
	}
	public void setListNoMenue(List<String> listNoMenue) {
		this.listNoMenue = listNoMenue;
	}
	public String getRightsCode() {
		return rightsCode;
	}
	public void setRightsCode(String rightsCode) {
		this.rightsCode = rightsCode;
	}
	public List<TRights> getListRights() {
		return listRights;
	}
	public void setListRights(List<TRights> listRights) {
		this.listRights = listRights;
	}
	public List<String> getListMo() {
		return listMo;
	}
	public void setListMo(List<String> listMo) {
		this.listMo = listMo;
	}
	public int getRightsValue() {
		return rightsValue;
	}
	public void setRightsValue(int rightsValue) {
		this.rightsValue = rightsValue;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getRightsName() {
		return rightsName;
	}
	public void setRightsName(String rightsName) {
		this.rightsName = rightsName;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getVerifysession() {
		return verifysession;
	}
	public void setVerifysession(String verifysession) {
		this.verifysession = verifysession;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVcode() {
		return vcode;
	}
	public void setVcode(String vcode) {
		this.vcode = vcode;
	}
	/*public HttpSession getSession() {
		return session;
	}
	public void setSession(HttpSession session) {
		this.session = session;
	}*/
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public List<TRole> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<TRole> roleList) {
		this.roleList = roleList;
	}
	public String getRoleOption() {
		return roleOption;
	}
	public void setRoleOption(String roleOption) {
		this.roleOption = roleOption;
	}
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getPrepassword() {
		return prepassword;
	}
	public void setPrepassword(String prepassword) {
		this.prepassword = prepassword;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
/*	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}*/
	public TRole getRole() {
		return role;
	}
	public void setRole(TRole role) {
		this.role = role;
	}
	public List<TRights> getRightsList() {
		return rightsList;
	}
	public void setRightsList(List<TRights> rightsList) {
		this.rightsList = rightsList;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	/*public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

	public int getIsAdmin() {
		return IsAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		IsAdmin = isAdmin;
	}*/

	public String getDenglu() {
		return denglu;
	}

	public void setDenglu(String denglu) {
		this.denglu = denglu;
	}

	public int getCommunityHospitalId() {
		return communityHospitalId;
	}

	public void setCommunityHospitalId(int communityHospitalId) {
		this.communityHospitalId = communityHospitalId;
	}
	public TCommunityHospitalGroup getCommunityHospitalGroup() {
		return communityHospitalGroup;
	}
	public void setCommunityHospitalGroup(TCommunityHospitalGroup communityHospitalGroup) {
		this.communityHospitalGroup = communityHospitalGroup;
	}
	public HealthFileService getHealthFileService() {
		return healthFileService;
	}
	public void setHealthFileService(HealthFileService healthFileService) {
		this.healthFileService = healthFileService;
	}
	/*public CommunityHospitalGroupService getCommunityHospitalGroupService() {
		return communityHospitalGroupService;
	}
	public void setCommunityHospitalGroupService(CommunityHospitalGroupService communityHospitalGroupService) {
		this.communityHospitalGroupService = communityHospitalGroupService;
	}*/
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	
	
	
  
	
}
