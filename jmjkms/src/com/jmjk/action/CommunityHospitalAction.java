package com.jmjk.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import com.jmjk.entity.TMaintainableEntry;
import com.jmjk.entity.TStaff;
import com.jmjk.iservice.ICommunityHospitalGroupService;
import com.jmjk.iservice.ICommunityHospitalService;
import com.jmjk.iservice.IMaintainableAttributeService;
import com.jmjk.service.CommunityHospitalService;
import com.jmjk.service.StaffService;
import com.jmjk.utils.Page;
import com.jmjk.utils.Resubmit;
import com.jmjk.utils.TokenProccessor;

/**
 * 医院管理部分
 * @author Songhuili
 * 18803096552
 */

@Component
@Scope("prototype")
@Action(value="communityHospitalAction",results={
		@Result(name ="hospitallist", location = "/jsp/systemManage/communityHospital/hospital.jsp"),
		@Result(name="jumpAddHospital",location="/jsp/systemManage/communityHospital/addHospital.jsp"),
		@Result(name="jumpEditHospital",location="/jsp/systemManage/communityHospital/editHospital.jsp"),
		@Result(name ="hospital", type = "redirectAction",location = "communityHospitalAction!getHospitalList"),
		@Result(name="error",location="/error.jsp"),
		@Result(name = "jumpCopyGroup", location = "/jsp/systemManage/communityHospital/copyGroup.jsp"),
        
		
		})
public class CommunityHospitalAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ICommunityHospitalService communityHospitalService;
	@Autowired
	private IMaintainableAttributeService maintainableAttributeService;
	@Autowired
	private ICommunityHospitalGroupService communityHospitalGroupService;
	@Autowired
	private StaffService staffService;
	

	private int cp = 1; // current page
	private int comHosId; 
	private String pageHtml; // 分页
	private String field="communityHospital"; // 搜索字段
	private String searchText = ""; // 搜索内容
	private TCommunityHospital ccommunityHospital;
	private List<TCommunityHospital> listHospitals;
	private String communityHospital; //医院名称
	private String hospitalCode;    //医院编码
	private String address;      //医院地址
	private String hospitalLevel;   //医院等级
	private String name;     //负责人
	private String login;    //账号
	private String password;  //密码
	private String phone;   //电话
	private String status;   //状态
	private String note;    //状态
	private List<String> listname;
	private String result;  //结果
	private List<TMaintainableEntry> listDengJi;//医院等级
	String token;
	private TCommunityHospitalGroup ccommunityHospitalGroup;
	private String groupLoginname; // 账号
    private String groupPhone; // 电话
    private String groupNote; // 说明
    private String groupHostName;// 集团负责人姓名
	
	//医院管理_查询医院
	public String getHospitalList(){
		Page<TCommunityHospital> page = new Page<TCommunityHospital>();
		List<String> fieldList=new ArrayList<String>(); //医院管理首页搜索类型
		fieldList.add("communityHospital"); //社区医院名称
		fieldList.add("name");				//负责人
		fieldList.add("login");				//账号
		fieldList.add("phone");				//电话
		
		if(fieldList.contains(field)||field==null||field.equals("")){
			page.setCurrentPage(cp);
			page.setTotalNum(communityHospitalService.getHospitalNumBySearch(field, searchText));
			listHospitals = communityHospitalService.getHospitalListBySearch(field, searchText, page);
			pageHtml = page
					.getPage("communityHospitalAction!getHospitalList.action?searchText="+ searchText + "&field=" + field);
			return "hospitallist";
		}
		else{
			return "error";
		}
	}
	
	//判断当前集团的医院数量是否达到上限
	public void ifMaxHosNum(){
	  //获取社区集团
        HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group1=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        TCommunityHospitalGroup group=communityHospitalGroupService.getRealComHosGroup(group1);
        if(group.getGroupHosptialCurrentNum()<group.getGroupHosptialNum())
        {
            result="1";
        }
        else{
            result="0";//需要改
        }
        this.writeJson(result);
	}
	
	//跳转到增加医院的页面
	public String jumpAddHospital(){
		//getHospitalList();
		listDengJi=maintainableAttributeService.getmEntriesByCode("18001");//获得可维护字段  医院等级
		//防止表单重复提交
		token = TokenProccessor.getInstance().makeToken();//创建令牌
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
		return "jumpAddHospital";
	}

	//增加医院
	public String addHospital(){
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "hospital";  //重定向回首页
		}
		
        
		communityHospital=ccommunityHospital.getCommunityHospital();//医院名称
		communityHospital=communityHospital.trim();
		ccommunityHospital.setCommunityHospital(communityHospital);
		hospitalCode=ccommunityHospital.getHospitalCode(); //医院编码
		hospitalCode=hospitalCode.trim();
		ccommunityHospital.setHospitalCode(hospitalCode);
		address=ccommunityHospital.getAddress();     		//医院地址
		address=address.trim();
		ccommunityHospital.setAddress(address);
		hospitalLevel=ccommunityHospital.getHospitalLevel();//医院等级
		hospitalLevel=hospitalLevel.trim();
		ccommunityHospital.setHospitalLevel(hospitalLevel);
		name=ccommunityHospital.getName();					//负责人姓名
		name=name.trim();
		ccommunityHospital.setName(name);
		login=ccommunityHospital.getLogin();				//负责人账号
		login=login.trim();
		ccommunityHospital.setLogin(login);
		phone=ccommunityHospital.getPhone();       			//负责人电话
		phone=phone.trim();
		ccommunityHospital.setPhone(phone);

		//必填项
		if(communityHospital==null||hospitalCode==null||address==null||hospitalLevel==null||name==null||login==null||phone==null||communityHospital.equals("")||hospitalCode.equals("")||address.equals("")||hospitalLevel.equals("")||name.equals("")||login.equals("")||phone.equals("")){
			listDengJi=maintainableAttributeService.getmEntriesByCode("18001");//获得可维护字段  医院等级
			return "jumpAddHospital";
		}
		
		//社区医院名称和社区负责人账号不允许有重名
		if(communityHospitalService.getCommunityHospitalByLogin(login)==null&&communityHospitalService.getCommunityHospitalByName(communityHospital)==null){
			communityHospitalService.saveCommunityHospital(ccommunityHospital);
			request.getSession().removeAttribute("token");//移除session中的token
			return "hospital";
		}
		else{
			listDengJi=maintainableAttributeService.getmEntriesByCode("18001");//获得可维护字段  医院等级
			return "jumpAddHospital";
		}
	}
	
	//跳转到编辑医院的页面
	public String jumpEditHospital(){
	    ccommunityHospital=communityHospitalService.getCommunityHospitalById(comHosId);
	    //判断当前医院是否是该集团的医院
	    HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        if(ccommunityHospital.getTCommunityHospitalGroup().getGId()==group.getGId())
		//获取可维护字段"等级"的数据项
		listDengJi=maintainableAttributeService.getmEntriesByCode("18001");
		//防止表单重复提交
		token = TokenProccessor.getInstance().makeToken();//创建令牌
		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
		return "jumpEditHospital";
	}

	//编辑医院  相同的也得更新员工表里对应的记录
	public String editHospital(){
		
		HttpServletRequest request=ServletActionContext.getRequest();
		boolean b = Resubmit.isRepeatSubmit(request,token);//判断用户是否是重复提交
		if(b==true){
			return "hospital";  //重定向回首页
		}

		//必填项
		if(address==null||hospitalLevel==null||name==null||phone==null||address.equals("")||hospitalLevel.equals("")||name.equals("")||phone.equals("")){
			listDengJi=maintainableAttributeService.getmEntriesByCode("18001");
			return "jumpEditHospital";
		}
		ccommunityHospital=communityHospitalService.getCommunityHospitalById(comHosId);
		
		TStaff oldStaff=staffService.getStaffByPhone(ccommunityHospital.getPhone());
		
		address=address.trim();
		hospitalLevel=hospitalLevel.trim();
		name=name.trim();
		phone=phone.trim();
		status=status.trim();
		
		ccommunityHospital.setAddress(address);
		ccommunityHospital.setHospitalLevel(hospitalLevel);
		ccommunityHospital.setName(name);
		ccommunityHospital.setNote(note);
		ccommunityHospital.setPhone(phone);
		ccommunityHospital.setStatus(status);

		
		//communityHospitalService.updateCommunityHospital(ccommunityHospital);
		communityHospitalService.updateCommunityHospital(ccommunityHospital, oldStaff);
		request.getSession().removeAttribute("token");//移除session中的token
		return "hospital";
	}

	//密码恢复
	public String changePassword(){
		communityHospitalService.changePassword(comHosId);
		return "hospital";
	}
	
	//删除医院
	public String deleteHospital(){
		TCommunityHospital communityHospital=communityHospitalService.getCommunityHospitalById(comHosId);
		String name=communityHospital.getCommunityHospital()+"delete";
		communityHospital.setCommunityHospital(name);
		communityHospitalService.deleteCommunityHospital(comHosId);		
		return "hospital";
	}
	
	//复制集团账号
    public String jumpCopyGroup(){
      //获取社区集团
        HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group1=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        TCommunityHospitalGroup group=communityHospitalGroupService.getRealComHosGroup(group1);
        return "jumpCopyGroup";
    }
    
  //复制集团账号
    public String copyGroup(){
      //获取社区集团
        ccommunityHospitalGroup=new TCommunityHospitalGroup();
        ccommunityHospitalGroup.setGroupHostName(groupHostName);
        ccommunityHospitalGroup.setGroupLoginname(groupLoginname);
        ccommunityHospitalGroup.setGroupNote(groupNote);
        ccommunityHospitalGroup.setGroupPhone(groupPhone);
        communityHospitalGroupService.saveCopyComHosGroup(ccommunityHospitalGroup);
        return "hospital";
    }
	
	//更改医院状态
	public String changeState(){
		communityHospitalService.changeState(comHosId, status);	
		return  "hospital";
		
	}
	
	//判断该医院名字是否已经存在,如果不存在返回1;存在返回0
	public void  ifHaveComHosName(){
		ccommunityHospital=communityHospitalService.getCommunityHospitalByName(name);
		if(ccommunityHospital==null){
			result="1";
		}
		else{
			result="0";
		}
		this.writeJson(result);
	}
	
	//判断该电话是否已经登记,如果不存在返回1;存在返回0
	public void ifHavePhonenum(){
	    ccommunityHospital=communityHospitalService.getCommunityHospitalByPhone(phone);
        if(ccommunityHospital==null){
            result="1";
        }
        else{
            if(comHosId!=0){
                if(ccommunityHospital.getCommunityHospitalId()==comHosId)
                    result="1";
            }
            else
                result="0";
        }
        this.writeJson(result);
	}
	
	//判断该医院编码是否已经登记,如果不存在返回1;存在返回0
    public void ifHaveCode(){
        ccommunityHospital=communityHospitalService.getCommunityHospitalByCode(hospitalCode);
        if(ccommunityHospital==null){
            result="1";
        }
        else{
            result="0";
        }
        this.writeJson(result);
    }
	
	//判断登录名是否已经存在,如果不存在返回1;存在返回0
		public void  ifHaveLogin(){
			ccommunityHospital=communityHospitalService.getCommunityHospitalByLogin(login);
			if(ccommunityHospital==null){
				result="1";
			}
			else{
				result="0";
			}
			this.writeJson(result);
		}
	
	
	
	//////////////////////////////////////////////////////////////////////
	
	public String getHospitalCode() {
		return hospitalCode;
	}

	public List<String> getListname() {
		return listname;
	}

	public void setListname(List<String> listname) {
		this.listname = listname;
	}

	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}
	public TCommunityHospital getCcommunityHospital() {
		return ccommunityHospital;
	}

	public void setCcommunityHospital(TCommunityHospital ccommunityHospital) {
		this.ccommunityHospital = ccommunityHospital;
	}
	public String getCommunityHospital() {
		return communityHospital;
	}
	
	public int getComHosId() {
		return comHosId;
	}
	public void setComHosId(int comHosId) {
		this.comHosId = comHosId;
	}
	public void setCommunityHospitalService(
			CommunityHospitalService communityHospitalService) {
		this.communityHospitalService = communityHospitalService;
	}

	/*public Page<TCommunityHospital> getPage() {
		return page;
	}

	public void setPage(Page<TCommunityHospital> page) {
		this.page = page;
	}*/

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setCommunityHospital(String communityHospital) {
		this.communityHospital = communityHospital;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getHospitalLevel() {
		return hospitalLevel;
	}
	public void setHospitalLevel(String hospitalLevel) {
		this.hospitalLevel = hospitalLevel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLogin() {
		return login;
	}
	public String getGroupLoginname() {
        return groupLoginname;
    }

    public void setGroupLoginname(String groupLoginname) {
        this.groupLoginname = groupLoginname;
    }

    public String getGroupPhone() {
        return groupPhone;
    }

    public void setGroupPhone(String groupPhone) {
        this.groupPhone = groupPhone;
    }

    public String getGroupNote() {
        return groupNote;
    }

    public void setGroupNote(String groupNote) {
        this.groupNote = groupNote;
    }

    public String getGroupHostName() {
        return groupHostName;
    }

    public void setGroupHostName(String groupHostName) {
        this.groupHostName = groupHostName;
    }

    public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}

	public int getCp() {
		return cp;
	}

	public List<TMaintainableEntry> getListDengJi() {
		return listDengJi;
	}

	public void setListDengJi(List<TMaintainableEntry> listDengJi) {
		this.listDengJi = listDengJi;
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

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public List<TCommunityHospital> getListHospitals() {
		return listHospitals;
	}

	public void setListHospitals(List<TCommunityHospital> listHospitals) {
		this.listHospitals = listHospitals;
	}


}
