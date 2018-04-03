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
import com.jmjk.enums.Admin_IsHead;
import com.jmjk.iservice.ICommunityHospitalGroupService;
import com.jmjk.iservice.ICommunityHospitalService;
import com.jmjk.utils.Page;
import com.jmjk.utils.Resubmit;
import com.jmjk.utils.TokenProccessor;

@Component
@Scope("prototype")
@Action(value = "communityHospitalGroupAction", results = {
        @Result(name = "grouplist", location = "/jsp/systemManage/communityGroup/group.jsp"),
        @Result(name = "jumpAddHospitalGroup", location = "/jsp/systemManage/communityGroup/addGroup.jsp"),
        @Result(name = "jumpEditHospitalGroup", location = "/jsp/systemManage/communityGroup/editGroup.jsp"),
        @Result(name = "group", type = "redirectAction", location = "communityHospitalGroupAction!getHosGroupList"),
        @Result(name = "error", location = "/error.jsp"),
        @Result(name = "HosInfo", location = "/jsp/systemManage/communityGroup/hospitalInfo.jsp"),
        })

public class CommunityHospitalGroupAction extends BaseAction {

    @Autowired
    private ICommunityHospitalGroupService communityHospitalGroupService;
    @Autowired
    private ICommunityHospitalService communityHospitalService;

    private int GId;// 集团id
    private String groupName; // 集团名称
    private String groupAddress; // 集团地址
    private String groupLoginname; // 账号
    private String groupPassword; // 密码
    private String groupPhone; // 电话
    private String groupStatus; // 状态
    private String groupNote; // 说明
    private Integer groupHosptialNum; // 集团医院数量上限
    private String groupHostName;// 集团负责人姓名
    private String searchText = ""; // 搜索内容
    private String field = "groupName"; // 搜索字段,默认为集团名称
    private String pageHtml; // 分页
    private int cp = 1; // current page
    private List<TCommunityHospitalGroup> listGroups;
    private List<TCommunityHospital> listHos;
    private String result;

    private TCommunityHospitalGroup ccommunityHospitalGroup;

    String token;

    // 医院管理_查询医院
    public String getHosGroupList() {
        Page<TCommunityHospitalGroup> page = new Page<TCommunityHospitalGroup>();
        List<String> fieldList = new ArrayList<String>(); // 医院管理首页搜索类型
        fieldList.add("groupName"); // 社区集团名称
        fieldList.add("groupHostName"); // 负责人
        fieldList.add("groupLoginname"); // 账号
        fieldList.add("groupPhone"); // 电话

        if (fieldList.contains(field) || field == null || field.equals("")) {
            page.setCurrentPage(cp);
            page.setTotalNum(communityHospitalGroupService.getGroupNumBySearch(field, searchText));
            listGroups = communityHospitalGroupService.getGroupListBySearch(field, searchText, page);
            pageHtml = page.getPage(
                    "communityHospitalGroupAction!getHosGroupList.action?searchText=" + searchText + "&field=" + field);
            return "grouplist";
        } else {
            return "error";
        }
    }

    // 跳转到增加医院集团的页面
    public String jumpAddHospitalGroup() {
        // 防止表单重复提交
        token = TokenProccessor.getInstance().makeToken();// 创建令牌
        HttpServletRequest request = ServletActionContext.getRequest();
        request.getSession().setAttribute("token", token); // 在服务器使用session保存token(令牌)
        return "jumpAddHospitalGroup";
    }

    // 增加集团
    public String addHospitalGroup() {
        HttpServletRequest request = ServletActionContext.getRequest();
        boolean b = Resubmit.isRepeatSubmit(request, token);// 判断用户是否是重复提交
        if (b == true) {
            return "group"; // 重定向回首页
        }
        request.getSession().removeAttribute("token");// 移除session中的token

        groupName = ccommunityHospitalGroup.getGroupName();// 集团名称
        groupName = groupName.trim();
        ccommunityHospitalGroup.setGroupName(groupName);

        groupAddress = ccommunityHospitalGroup.getGroupAddress(); // 集团地址
        groupAddress = groupAddress.trim();
        ccommunityHospitalGroup.setGroupAddress(groupAddress);

        groupHosptialNum = ccommunityHospitalGroup.getGroupHosptialNum(); // 集团医院数量上限
        ccommunityHospitalGroup.setGroupHosptialCurrentNum(groupHosptialNum);

        groupLoginname = ccommunityHospitalGroup.getGroupLoginname(); // 账号
        groupLoginname = groupLoginname.trim();
        ccommunityHospitalGroup.setGroupLoginname(groupLoginname);

        groupPhone = ccommunityHospitalGroup.getGroupPhone(); // 电话
        groupPhone = groupPhone.trim();
        ccommunityHospitalGroup.setGroupPhone(groupPhone);

        groupStatus = ccommunityHospitalGroup.getGroupStatus(); // 状态
        groupStatus = groupStatus.trim();
        ccommunityHospitalGroup.setGroupStatus(groupStatus);

        groupNote = ccommunityHospitalGroup.getGroupNote(); // 说明
        groupNote = groupNote.trim();
        ccommunityHospitalGroup.setGroupNote(groupNote);

        communityHospitalGroupService.saveComHosGroup(ccommunityHospitalGroup);

        return "group";
    }

    // 跳转到编辑集团的页面
    public String jumpEditHospitalGroup() {
        ccommunityHospitalGroup=communityHospitalGroupService.getComHosGroupByGroupId(GId);
 	    
 		//防止表单重复提交
		token = TokenProccessor.getInstance().makeToken();//创建令牌
 		HttpServletRequest request=ServletActionContext.getRequest();
		request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
 		
        return "jumpEditHospitalGroup";
    }
    //编辑医院
    public String editHospitalGroup() {

        HttpServletRequest request = ServletActionContext.getRequest();
        boolean b = Resubmit.isRepeatSubmit(request, token);// 判断用户是否是重复提交
        if (b == true) {
            return "group"; // 重定向回首页
        }

        // 必填项
        if (groupAddress == null|| groupHosptialNum==null|| groupPhone == null|| groupStatus == null || groupNote==null) {

            return "jumpEditHospitalGroup";
        }
        ccommunityHospitalGroup = communityHospitalGroupService.getComHosGroupByGroupId(GId);
        groupAddress = groupAddress.trim();
        groupPhone = groupPhone.trim();
        groupStatus = groupStatus.trim();
        groupNote = groupNote.trim();

        ccommunityHospitalGroup.setGroupAddress(groupAddress);
        ccommunityHospitalGroup.setGroupHostName(groupHostName);
        ccommunityHospitalGroup.setGroupPhone(groupPhone);
        ccommunityHospitalGroup.setGroupStatus(groupStatus);
        ccommunityHospitalGroup.setGroupNote(groupNote);
        ccommunityHospitalGroup.setGroupHosptialNum(groupHosptialNum);
        communityHospitalGroupService.updateComHosGroup(ccommunityHospitalGroup);

        return "group";
    }

    // 密码恢复
    public String changePassword() {
        communityHospitalGroupService.changePassword(GId);
        return "group";
    }

    // 删除集团,同时删除复制产生的账号,和该集团下面的医院
    public String deleteHosGroup() {
        TCommunityHospitalGroup communityHospitalGroup = communityHospitalGroupService.getComHosGroupByGroupId(GId);
        String name = communityHospitalGroup.getTCommunityHospitals() + "delete";
        communityHospitalGroup.setGroupHostName(groupHostName);
        communityHospitalGroupService.deleteComHosGroup(GId);;
        return "group";
    }

    // 更改集团状态
    public String changeState() {
        communityHospitalGroupService.changeState(GId, groupStatus);
        return "group";
    }

    
    //获取当前集团下医院的信息
    public String getHosInfo(){
        Page<TCommunityHospital> page = new Page<TCommunityHospital>();
        TCommunityHospitalGroup group = communityHospitalGroupService.getComHosGroupByGroupId(GId);
        
        
        page.setCurrentPage(cp);
        page.setTotalNum(group.getGroupHosptialCurrentNum());
        listHos = communityHospitalGroupService.getComHosListByGroupByPage(group,page);
        pageHtml = page.getPage("communityHospitalGroupAction!getHosInfo.action");
        
        return "HosInfo";
    }
    
    // 判断该集团名字是否已经存在,如果不存在返回1;存在返回0
    public void ifHaveGroupName() {
        ccommunityHospitalGroup = communityHospitalGroupService.getComHosGroupByName(groupName);
        if (ccommunityHospitalGroup == null) {
            result = "1";
        } else {
            result = "0";
        }
        this.writeJson(result);
    }

  //判断该电话是否已经登记,如果不存在返回1;存在返回0
    public void ifHavePhonenumg(){
        ccommunityHospitalGroup=communityHospitalGroupService.getComHosGroupByPhone(groupPhone);
        if(ccommunityHospitalGroup==null){
            result="1";
        }
        else{
            if(GId!=0){
                if(ccommunityHospitalGroup.getGId()==GId){
                    result="1";
                }
            }
            else
                result="0";
        }
        this.writeJson(result);
    }
    
    // 判断登录名是否已经存在,如果不存在返回1;存在返回0
    public void ifHaveLogin() {
        ccommunityHospitalGroup = communityHospitalGroupService.getComHosGroupByLogin(groupLoginname);
        TCommunityHospital hospital=communityHospitalService.getCommunityHospitalByLogin(groupLoginname);
        if (ccommunityHospitalGroup == null){
            if(hospital==null||hospital.getIsHead()!=Admin_IsHead.guanliyuan.getValue()) {
            result = "1";
            } else {
                result = "0";
            }
        }
        else
            result="0";
        this.writeJson(result);
    }

    public String getCommunityHospitalGroup() {
        return groupName;
    }

    public void setCommunityHospitalGroup(String communityHospitalGroup) {
        this.groupName = communityHospitalGroup;
    }

    public String getGroupAddress() {
        return groupAddress;
    }

    public void setGroupAddress(String groupAddress) {
        this.groupAddress = groupAddress;
    }

    public String getGroupLoginname() {
        return groupLoginname;
    }

    public void setGroupLoginname(String groupLoginname) {
        this.groupLoginname = groupLoginname;
    }

    public String getGroupPassword() {
        return groupPassword;
    }

    public void setGroupPassword(String groupPassword) {
        this.groupPassword = groupPassword;
    }

    public String getGroupPhone() {
        return groupPhone;
    }

    public void setGroupPhone(String groupPhone) {
        this.groupPhone = groupPhone;
    }

    public String getGroupStatus() {
        return groupStatus;
    }

    public void setGroupStatus(String groupStatus) {
        this.groupStatus = groupStatus;
    }

    public String getGroupHostName() {
        return groupHostName;
    }

    public void setGroupHostName(String groupHostName) {
        this.groupHostName = groupHostName;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getPageHtml() {
        return pageHtml;
    }

    public void setPageHtml(String pageHtml) {
        this.pageHtml = pageHtml;
    }

    public int getCp() {
        return cp;
    }

    public int getGId() {
        return GId;
    }

    public void setGId(int gId) {
        GId = gId;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public List<TCommunityHospital> getListHos() {
        return listHos;
    }

    public void setListHos(List<TCommunityHospital> listHos) {
        this.listHos = listHos;
    }

    public String getGroupName() {
        return groupName;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupNote() {
        return groupNote;
    }

    public void setGroupNote(String groupNote) {
        this.groupNote = groupNote;
    }

    public Integer getGroupHosptialNum() {
        return groupHosptialNum;
    }

    public void setGroupHosptialNum(Integer groupHosptialNum) {
        this.groupHosptialNum = groupHosptialNum;
    }

    public List<TCommunityHospitalGroup> getListGroups() {
        return listGroups;
    }

    public void setListGroups(List<TCommunityHospitalGroup> listGroups) {
        this.listGroups = listGroups;
    }

    public TCommunityHospitalGroup getCcommunityHospitalGroup() {
        return ccommunityHospitalGroup;
    }

    public void setCcommunityHospitalGroup(TCommunityHospitalGroup ccommunityHospitalGroup) {
        this.ccommunityHospitalGroup = ccommunityHospitalGroup;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}