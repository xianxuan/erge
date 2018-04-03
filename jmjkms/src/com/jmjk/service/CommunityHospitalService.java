package com.jmjk.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jmjk.dao.CommunityHospitalDao;
import com.jmjk.dao.OldStaffHosDao;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.entity.TOldStaffHos;
import com.jmjk.entity.TRole;
import com.jmjk.entity.TStaff;
import com.jmjk.enums.Admin_IsHead;
import com.jmjk.enums.OperatorState;
import com.jmjk.enums.Result_Login;
import com.jmjk.iservice.ICommunityHospitalService;
import com.jmjk.utils.Encryt;
import com.jmjk.utils.HttpRequest;
import com.jmjk.utils.MyHttpClient;
import com.jmjk.utils.Page;
import com.jmjk.utils.TypeConverter;
import com.jmjk.utils.WebXMLParameter;

/*
 * 社区医院service实现
 * @author songhuili
 *   18803096552
 */
@Controller("communityHospitalService")
public class CommunityHospitalService implements ICommunityHospitalService {
	@Autowired
	private CommunityHospitalDao communityHospitalDao;
	@Autowired
	private CommunityHospitalGroupService communityHospitalGroupService;
	@Autowired
	private StaffService staffService;
	@Autowired
	private OldStaffHosDao oldStaffHosDao;
	
	
	@Override
	public void saveCommunityHospital(TCommunityHospital communityHospital) {
	    //得到当前session中的集团
	    HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group1=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        //获得"真正"的集团
        TCommunityHospitalGroup group=communityHospitalGroupService.getRealComHosGroup(group1);
        
        communityHospital.setTCommunityHospitalGroup(group);
	    communityHospital.setIsHead(Admin_IsHead.shequfuzeren.getValue());
		String pa=Encryt.encryptString_md5(communityHospital.getLogin());
		communityHospital.setPassword(pa);
		communityHospitalDao.Save(communityHospital);
		
		
		
		TStaff staff=new TStaff();
		staff.setName(communityHospital.getName());
		staff.setPhone(communityHospital.getPhone());
		//通过医院id,得到角色表里的实体
		TRole role=staffService.getRoleByCom();
	    staff.setTRole(role);
		staff.setIsSpecialDoctor(true);
		staff.setOperateState(OperatorState.qiyong.getvalue());
		staff.setDepartment("");
		staff.setJob("");
		staff.setIdCardNum("");
		staff.setState("");
		staff.setStaffNumber("");
		staffService.saveStaffRecord(staff, communityHospital);
		
		//存储到中间服务器上
		String para = "communityHospital={\"address\":\""+communityHospital.getAddress()
		+"\",\"communityHospital\":\""+communityHospital.getCommunityHospital()
		+"\",\"communityHospitalId\":"+communityHospital.getCommunityHospitalId()
		+",\"five\":\""+communityHospital.getFive()
		+"\",\"four\":\""+communityHospital.getFour()
		+"\",\"gId\":"+communityHospital.getTCommunityHospitalGroup().getGId()
		+",\"hospitalCode\":\""+communityHospital.getHospitalCode()
		+"\",\"hospitalLevel\":\""+communityHospital.getHospitalLevel()
		+"\",\"isHead\":"+communityHospital.getIsHead()
		+",\"latitude\":\""+communityHospital.getLatitude()
		+"\",\"login\":\""+communityHospital.getLogin()
		+"\",\"longitude\":\""+communityHospital.getLongitude()
		+"\",\"name\":\""+communityHospital.getName()
		+"\",\"note\":\""+communityHospital.getNote()
		+"\",\"one\":\""+communityHospital.getOne()
		+"\",\"password\":\""+communityHospital.getPassword()
		+"\",\"phone\":\""+communityHospital.getPhone()
		+"\",\"status\":\""+communityHospital.getStatus()
		+"\",\"three\":\""+communityHospital.getThree()
		+"\",\"two\":\""+communityHospital.getTwo()+"\"}";
        StringBuffer url=new StringBuffer();
        url.append(WebXMLParameter.getParamValue("ip_port"));
        url.append("/healthy/communityHospital/addData");
        //System.out.println(para);
        String str=HttpRequest.sendPost(url.toString(), para);
        System.out.println(str);
        
        
        //把社区负责人的员工记录当做责任医生上传到服务器
        //String URL = baseUrl+addDocUrl;
        StringBuffer URL=new StringBuffer();
        URL.append(WebXMLParameter.getParamValue("ip_port"));
        URL.append("/healthy/doctor/addData");
        System.out.println(URL.toString());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("doctor={\"staffId\":\""+staff.getStaffId());  
        stringBuffer.append("\"}"+ "&hosId="+communityHospital.getCommunityHospitalId());
        System.out.println(stringBuffer.toString());
        String ss=HttpRequest.sendPost(URL.toString(), stringBuffer.toString());
        System.out.println(ss);

        

		group.setGroupHosptialCurrentNum(group.getGroupHosptialCurrentNum()+1);
		communityHospitalGroupService.updateComHosGroup(group);
	}

	@Override
	public void deleteCommunityHospital(int comHosId) {
		//状态0表示启用，1表示禁用，2表示删除
		//删除为假删，删除该医院的同时删除医院的员工,通过触发器实现
		String hql="update TCommunityHospital tch set tch.status="+OperatorState.shanchu.getvalue()+" where tch.communityHospitalId="+comHosId;;
		communityHospitalDao.update(hql);
		
		//从中间服务器上删除
		String para = "id="+comHosId;
		StringBuffer url=new StringBuffer();
        url.append(WebXMLParameter.getParamValue("ip_port"));
        url.append("/healthy/communityHospital/deleteData");
        String str=HttpRequest.sendPost(url.toString(), para);
        System.out.println(str);

        //得到当前社区集团
		HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group1=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        TCommunityHospitalGroup group=communityHospitalGroupService.getRealComHosGroup(group1);
        //修改社区集团当前医院数量
        group.setGroupHosptialCurrentNum(group.getGroupHosptialCurrentNum()-1);
        communityHospitalGroupService.updateComHosGroup(group);
		
	}
	
	@Override
    public void updateCommunityHospital(TCommunityHospital communityHospital,TStaff staff) {
        communityHospitalDao.update(communityHospital);
        

        staff.setName(communityHospital.getName());
        staff.setPhone(communityHospital.getPhone());
        staffService.updateStaffRecord(staff, communityHospital);
        
        //修改中间服务器上的数据
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append("communityHospital={\"address\":\""+communityHospital.getAddress()
        +"\",\"communityHospital\":\""+communityHospital.getCommunityHospital()
        +"\",\"communityHospitalId\":"+communityHospital.getCommunityHospitalId()
        +",\"five\":\""+communityHospital.getFive()
        +"\",\"four\":\""+communityHospital.getFour());
        if(communityHospital.getTCommunityHospitalGroup()==null){
            stringBuffer.append("\",\"gId\":"+communityHospital.getTCommunityHospitalGroup());
        }else{
            stringBuffer.append("\",\"gId\":"+communityHospital.getTCommunityHospitalGroup().getGId());
        }
        stringBuffer.append(",\"hospitalCode\":\""+communityHospital.getHospitalCode()
        +"\",\"hospitalLevel\":\""+communityHospital.getHospitalLevel()
        +"\",\"isHead\":"+communityHospital.getIsHead()
        +",\"latitude\":\""+communityHospital.getLatitude()
        +"\",\"login\":\""+communityHospital.getLogin()
        +"\",\"longitude\":\""+communityHospital.getLongitude()
        +"\",\"name\":\""+communityHospital.getName()
        +"\",\"note\":\""+communityHospital.getNote()
        +"\",\"one\":\""+communityHospital.getOne()
        +"\",\"password\":\""+communityHospital.getPassword()
        +"\",\"phone\":\""+communityHospital.getPhone()
        +"\",\"status\":\""+communityHospital.getStatus()
        +"\",\"three\":\""+communityHospital.getThree()
        +"\",\"two\":\""+communityHospital.getTwo()+"\"}");
       
        StringBuffer url=new StringBuffer();
        url.append(WebXMLParameter.getParamValue("ip_port"));
        url.append("/healthy/communityHospital/editData");
        String str=HttpRequest.sendPost(url.toString(), stringBuffer.toString());
        System.out.println(str);
        
    }

	@Override
	public void updateCommunityHospital(TCommunityHospital communityHospital) {
		communityHospitalDao.update(communityHospital);
		
		//修改中间服务器上的数据
		StringBuffer stringBuffer=new StringBuffer();
		stringBuffer.append("communityHospital={\"address\":\""+communityHospital.getAddress()
        +"\",\"communityHospital\":\""+communityHospital.getCommunityHospital()
        +"\",\"communityHospitalId\":"+communityHospital.getCommunityHospitalId()
        +",\"five\":\""+communityHospital.getFive()
        +"\",\"four\":\""+communityHospital.getFour());
		if(communityHospital.getTCommunityHospitalGroup()==null){
			stringBuffer.append("\",\"gId\":"+communityHospital.getTCommunityHospitalGroup());
		}else{
			stringBuffer.append("\",\"gId\":"+communityHospital.getTCommunityHospitalGroup().getGId());
		}
		stringBuffer.append(",\"hospitalCode\":\""+communityHospital.getHospitalCode()
        +"\",\"hospitalLevel\":\""+communityHospital.getHospitalLevel()
        +"\",\"isHead\":"+communityHospital.getIsHead()
        +",\"latitude\":\""+communityHospital.getLatitude()
        +"\",\"login\":\""+communityHospital.getLogin()
        +"\",\"longitude\":\""+communityHospital.getLongitude()
        +"\",\"name\":\""+communityHospital.getName()
        +"\",\"note\":\""+communityHospital.getNote()
        +"\",\"one\":\""+communityHospital.getOne()
        +"\",\"password\":\""+communityHospital.getPassword()
        +"\",\"phone\":\""+communityHospital.getPhone()
        +"\",\"status\":\""+communityHospital.getStatus()
        +"\",\"three\":\""+communityHospital.getThree()
        +"\",\"two\":\""+communityHospital.getTwo()+"\"}");
		
		StringBuffer url=new StringBuffer();
        url.append(WebXMLParameter.getParamValue("ip_port"));
        url.append("/healthy/communityHospital/editData");
		String str=HttpRequest.sendPost(url.toString(), stringBuffer.toString());
        System.out.println(str);
		
	}
	
	

	@Override
	public TCommunityHospital getCommunityHospitalById(int comHosId) {
		
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("comHosId", comHosId);
		String hql = "from TCommunityHospital tch where tch.communityHospitalId =:comHosId";
		TCommunityHospital tCommunityHospital = communityHospitalDao.Get(hql, params);
		return tCommunityHospital;
	}

	@Override
	public List<TCommunityHospital> getHospitalListBySearch(String field,
			String searchText, Page<TCommunityHospital> page) {
	    
	    HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group1=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        TCommunityHospitalGroup group=communityHospitalGroupService.getRealComHosGroup(group1);
        
        List<TCommunityHospital> listCommunityHospitals=new ArrayList<TCommunityHospital>();
		if(field == null){
			String hql="from  TCommunityHospital tch where tch.status <>"+OperatorState.shanchu.getvalue()+" and tch.isHead ="+Admin_IsHead.shequfuzeren.getValue()+" and tch.TCommunityHospitalGroup.GId="+group.getGId()+" order by tch.communityHospitalId desc";
			listCommunityHospitals = communityHospitalDao.find(hql,page.getCurrentPage(),page.getPageSize());
		}
		else{
			if(searchText == null||searchText.equals("")){
				String hql="from  TCommunityHospital tch where tch.status <>"+OperatorState.shanchu.getvalue()+" and tch.isHead ="+Admin_IsHead.shequfuzeren.getValue()+" and tch.TCommunityHospitalGroup.GId="+group.getGId()+"  order by tch.communityHospitalId desc";
				listCommunityHospitals = communityHospitalDao.find(hql,page.getCurrentPage(),page.getPageSize());
				}
			else{
				String hql = "from TCommunityHospital tch where tch."+field+" like:searchText and tch.status <>"+OperatorState.shanchu.getvalue()+" and tch.isHead ="+Admin_IsHead.shequfuzeren.getValue()+" and tch.TCommunityHospitalGroup.GId="+group.getGId()+" order by tch.communityHospitalId desc";
				Map<String, Object> params=new HashMap<String, Object>();
				params.put("searchText", "%"+searchText+"%");
				listCommunityHospitals = communityHospitalDao.find(hql, params, page.getCurrentPage(), page.getPageSize());
				}
		}
		return listCommunityHospitals;
		
	}
	
	@Override
	public List<TCommunityHospital> getAllHospitals(){
	    //得到当前session中的集团
        HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group1=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        //获得"真正"的集团
        TCommunityHospitalGroup group=communityHospitalGroupService.getRealComHosGroup(group1);
        
		String hql="from TCommunityHospital tch where tch.status <>"+OperatorState.shanchu.getvalue()+" and tch.isHead ="+Admin_IsHead.shequfuzeren.getValue()+" and tch.TCommunityHospitalGroup.GId="+group.getGId()+" order by tch.communityHospital asc";
		return communityHospitalDao.find(hql);
		
	}
	
	@Override
	public long getHospitalNumBySearch(String field, String searchText) {
	    HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group1=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        TCommunityHospitalGroup group=communityHospitalGroupService.getRealComHosGroup(group1);
        
		if(field ==null){
			String hql = "select count(tch.communityHospitalId) from TCommunityHospital tch where tch.status <>"+OperatorState.shanchu.getvalue()+" and tch.isHead ="+Admin_IsHead.shequfuzeren.getValue()+" and tch.TCommunityHospitalGroup.GId="+group.getGId();
			Long count = communityHospitalDao.count(hql);
			return count;
		}
		else{
			if(searchText == null||searchText.equals("")){
				String hql = "select count(communityHospitalId) from TCommunityHospital tch where tch.status <>"+OperatorState.shanchu.getvalue()+" and tch.isHead ="+Admin_IsHead.shequfuzeren.getValue()+" and tch.TCommunityHospitalGroup.GId="+group.getGId();
				Long count = communityHospitalDao.count(hql);
				return count;
				
			}
			else {
				String hql = "select count(communityHospitalId) from TCommunityHospital tch where tch."+field+" like:searchText and tch.status <>"+OperatorState.shanchu.getvalue()+" and tch.isHead ="+Admin_IsHead.shequfuzeren.getValue()+" and tch.TCommunityHospitalGroup.GId="+group.getGId();
				Map<String, Object> params=new HashMap<String, Object>();
				params.put("searchText", "%"+searchText+"%");
				Long count =communityHospitalDao.count(hql, params);
				return count;
			}
		}
	}

	@Override
	public void changePassword(int comHosId) {
		//负责人恢复密码，恢复为初始密码，即登陆名
		String pa=Encryt.encryptString_md5(this.getCommunityHospitalById(comHosId).getLogin());
		String hql="update TCommunityHospital tch set tch.password='" + pa + "' where tch.communityHospitalId="+comHosId;
		communityHospitalDao.update(hql);
	}

	@Override
	public void changeState(int comHosId, String state) {
		//状态0表示启用，1表示禁用，2表示删除
		//禁用该医院的同时，该医院的员工也被禁用，用触发器实现
		String hql = "update TCommunityHospital tch set tch.status=" + state + " where tch.communityHospitalId="+comHosId;
		communityHospitalDao.update(hql);
	
	}

	@Override
	public TCommunityHospital getCommunityHospitalByLogin(String login) {
		String hql="from TCommunityHospital tch where tch.login=:login";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("login", login);
		TCommunityHospital tCommunityHospital = communityHospitalDao.Get(hql, params);
		return tCommunityHospital;
	}

	
	@Override
	public List<TCommunityHospital> getAllQiYongHos() {
	  //得到当前session中的集团
        HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group1=(TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        //获得"真正"的集团
        TCommunityHospitalGroup group=communityHospitalGroupService.getRealComHosGroup(group1);
	    
		String hql="from TCommunityHospital tch where tch.isHead <>"+Admin_IsHead.guanliyuan.getValue()+" and tch.status = " +OperatorState.qiyong.getvalue()+ " and tch.TCommunityHospitalGroup.GId="+group.getGId()+" order by tch.communityHospital asc";
		return communityHospitalDao.find(hql);
	}

	@Override
	public List<TCommunityHospital> getCommunityHospitalByID(
			List<Object> communityHosIdList) {
		String a = ",";
		String str = TypeConverter.convertList2String(communityHosIdList,
				a);
		String hql="from TCommunityHospital tch where tch.communityHospitalId in ("+str+") order by tch.communityHospital asc";//改过
		return communityHospitalDao.find(hql);
	}
	
	//登录by xuleping
	public Enum loginCheck(String loginname, String Password) {
		Result_Login result = Result_Login.NO_USER;	
		TCommunityHospital comHospital =communityHospitalDao.Get("from TCommunityHospital ty where ty.login = '"+loginname+"'"); 
		Password =Encryt.encryptString_md5(Password);
		String password = comHospital.getPassword();
		if (Password.equals(password)) {
			result = Result_Login.LOGIN_SUCCESS;
		} else {
			result = Result_Login.PASS_ERROR;
		}
		return result;
	}

	@Override
	public TCommunityHospital getCommunityHospitalByStaffId(int staffId,int healthFileId) {
		String hql = "from TOldStaffHos tosh where tosh.TStaff.staffId=:staffId and tosh.THealthFile.healthFileId=:healthFileId";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("staffId", staffId);
		params.put("healthFileId", healthFileId);
		TOldStaffHos tOldStaffHos = oldStaffHosDao.Get(hql, params);
		return tOldStaffHos.getTCommunityHospital();
	}

	@Override
	public TCommunityHospital getCommunityHospitalByName(String name) {
		String hql="from TCommunityHospital tch where tch.communityHospital=:name and tch.isHead ="+Admin_IsHead.shequfuzeren.getValue();
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("name", name);
		TCommunityHospital tCommunityHospital = communityHospitalDao.Get(hql,params);
		return tCommunityHospital;
	}

	@Override
	public List<TCommunityHospital> getWuShiSi() {
		String hql="from TCommunityHospital tch where tch.isHead ="+Admin_IsHead.guanliyuan.getValue();
		return communityHospitalDao.find(hql);
	}
	
	//为甲方提供的接口
	public List<TCommunityHospital> getHospitalByAll(int currentPage, int pageSize){
		String hql="from TCommunityHospital tch where tch.status <>"+OperatorState.shanchu.getvalue()+" and tch.isHead ="+Admin_IsHead.shequfuzeren.getValue()+" order by tch.communityHospital asc";
		List<TCommunityHospital> communityHospitalList=communityHospitalDao.find(hql,currentPage,pageSize);		
		return communityHospitalList;	
	}
	
	public int getHospitalNumByAll(int currentPage, int pageSize){
		String hql="select count(communityHospitalId) from TCommunityHospital tch where tch.status <>"+OperatorState.shanchu.getvalue()+" and tch.isHead ="+Admin_IsHead.shequfuzeren.getValue();
		return new Long(communityHospitalDao.count(hql)).intValue();
	}
	
	@Override
	public Boolean getCommunityHospitalIsContain(int communityHostpitalId){
		try {
			String hql = "from TCommunityHospital tch where tch.communityHospitalId =:comHosId and tch.isHead=1";
			Map<String, Object> params=new HashMap<String, Object>();
			params.put("comHosId", communityHostpitalId);
			TCommunityHospital tCommunityHospital = communityHospitalDao.Get(hql, params);
			if (tCommunityHospital!=null) {
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public TCommunityHospital getCommunityHospitalByStaffId(int staffId) {
		String hql = "from TOldStaffHos tosh where tosh.TStaff.staffId=:staffId ";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("staffId", staffId);
		TOldStaffHos tOldStaffHos = oldStaffHosDao.Get(hql, params);
		return tOldStaffHos.getTCommunityHospital();
	}

    @Override
    public TCommunityHospital getCommunityHospitalByPhone(String phone) {
        String hql="from TCommunityHospital tch where tch.phone=:phone";
        Map<String, Object> params=new HashMap<String, Object>();
        params.put("phone", phone);
        TCommunityHospital tCommunityHospital = communityHospitalDao.Get(hql, params);
        return tCommunityHospital;
    }

    @Override
    public TCommunityHospital getCommunityHospitalByCode(String hospitalCode) {
        String hql="from TCommunityHospital tch where tch.hospitalCode=:hospitalCode";
        Map<String, Object> params=new HashMap<String, Object>();
        params.put("hospitalCode", hospitalCode);
        TCommunityHospital tCommunityHospital = communityHospitalDao.Get(hql, params);
        return tCommunityHospital;
    }


	
}
