package com.jmjk.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.jmjk.dao.CommunityHospitalDao;
import com.jmjk.dao.CommunityHospitalGroupDao;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TCommunityHospitalGroup;
import com.jmjk.enums.OperatorState;
import com.jmjk.enums.Result_Login;
import com.jmjk.iservice.ICommunityHospitalGroupService;
import com.jmjk.utils.Encryt;
import com.jmjk.utils.Page;
import com.jmjk.utils.TypeConverter;

@Controller("communityHospitalGroupService")
public class CommunityHospitalGroupService implements ICommunityHospitalGroupService {

    @Autowired
    private CommunityHospitalGroupDao communityHospitalGroupDao;
    @Autowired
    private CommunityHospitalDao communityHospitalDao;

    @Override
    public void saveComHosGroup(TCommunityHospitalGroup comHosGroup) {
        // TODO Auto-generated method stub
        comHosGroup.setIsCopy(0);
        String pa = Encryt.encryptString_md5(comHosGroup.getGroupLoginname());
        comHosGroup.setGroupPassword(pa);
        comHosGroup.setGroupHosptialCurrentNum(0);
        communityHospitalGroupDao.Save(comHosGroup);
    }

    @Override
    public void deleteComHosGroup(int groupId) {
        // TODO Auto-generated method stub
        // 状态0表示启用，1表示禁用，2表示删除
        // 删除为假删，删除该集团的同时删除该集团复制产生的集团以及该集团下的医院,通过触发器实现
        String hql = "update TCommunityHospitalGroup thg set thg.groupStatus='" + OperatorState.shanchu.getvalue()
                + "' where thg.GId=" + groupId + " or thg.isCopy=" + groupId;
        communityHospitalGroupDao.update(hql);

    }

    @Override
    public void updateComHosGroup(TCommunityHospitalGroup comHosGroup) {
        // TODO Auto-generated method stub
        communityHospitalGroupDao.update(comHosGroup);

    }

    @Override
    public TCommunityHospitalGroup getComHosGroupByGroupId(int groupId) {
        // TODO Auto-generated method stub
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("groupId", groupId);
        String hql = "from TCommunityHospitalGroup thg where thg.GId =:groupId";
        TCommunityHospitalGroup tCommunityHospitalGroup = communityHospitalGroupDao.Get(hql, params);
        return tCommunityHospitalGroup;
    }

    @Override
    public List<TCommunityHospitalGroup> getComHosGroupListByGroupIdList(List<Object> commHosGroupIdList) {
        // TODO Auto-generated method stub
        String a = ",";
        String str = TypeConverter.convertList2String(commHosGroupIdList, a);
        String hql = "from TCommunityHospitalGroup tchg where tchg.GId in (" + str + ") order by tchg.groupName asc";
        return communityHospitalGroupDao.find(hql);
    }

    @Override
    public TCommunityHospitalGroup getComHosGroupByLogin(String login) {
        // TODO Auto-generated method stub
        String hql = "from TCommunityHospitalGroup tchg where tchg.groupLoginname=:login";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("login", login);
        TCommunityHospitalGroup tCommunityHospitalGroup = communityHospitalGroupDao.Get(hql, params);
        return tCommunityHospitalGroup;
    }

    @Override
    public List<TCommunityHospitalGroup> getGroupListBySearch(String field, String searchText,
            Page<TCommunityHospitalGroup> page) {
        // TODO Auto-generated method stub
        List<TCommunityHospitalGroup> listComHosGroups = new ArrayList<TCommunityHospitalGroup>();
        if (field == null) {
            String hql = "from  TCommunityHospitalGroup tchg where tchg.groupStatus <>'"
                    + OperatorState.shanchu.getvalue() + "' and tchg.isCopy=0 order by tchg.GId desc";
            listComHosGroups = communityHospitalGroupDao.find(hql, page.getCurrentPage(), page.getPageSize());
        } else {
            if (searchText == null || searchText.equals("")) {
                String hql = "from  TCommunityHospitalGroup tchg where tchg.groupStatus <>'"
                        + OperatorState.shanchu.getvalue() + "' and tchg.isCopy=0  order by tchg.GId desc";
                listComHosGroups = communityHospitalGroupDao.find(hql, page.getCurrentPage(), page.getPageSize());
            } else {
                String hql = "from TCommunityHospitalGroup tchg where tchg." + field
                        + " like:searchText and tchg.groupStatus <>'" + OperatorState.shanchu.getvalue()
                        + "' and tchg.isCopy=0 order by tchg.GId desc";
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("searchText", "%" + searchText + "%");
                listComHosGroups = communityHospitalGroupDao.find(hql, params, page.getCurrentPage(),
                        page.getPageSize());
            }
        }
        return listComHosGroups;
    }

    @Override
    public List<TCommunityHospitalGroup> getAllGroups() {
        // TODO Auto-generated method stub
        String hql = "from TCommunityHospitalGroup tch where tch.groupStatus <>'" + OperatorState.shanchu.getvalue()
                + "' and tch.isCopy=0 order by tch.groupName asc";
        return communityHospitalGroupDao.find(hql);
    }

    @Override
    public long getGroupNumBySearch(String field, String searchText) {
        // TODO Auto-generated method stub
        if (field == null) {
            String hql = "select count(tch.GId) from TCommunityHospitalGroup tch where tch.groupStatus <>'"
                    + OperatorState.shanchu.getvalue() + "' and tch.isCopy=0";
            Long count = communityHospitalGroupDao.count(hql);
            return count;
        } else {
            if (searchText == null || searchText.equals("")) {
                String hql = "select count(GId) from TCommunityHospitalGroup tch where tch.groupStatus <>'"
                        + OperatorState.shanchu.getvalue() + "' and tch.isCopy=0";
                Long count = communityHospitalGroupDao.count(hql);
                return count;

            } else {
                String hql = "select count(GId) from TCommunityHospitalGroup tch where tch." + field
                        + " like:searchText and tch.groupStatus <>'" + OperatorState.shanchu.getvalue()
                        + "' and tch.isCopy=0";
                Map<String, Object> params = new HashMap<String, Object>();
                params.put("searchText", "%" + searchText + "%");
                Long count = communityHospitalGroupDao.count(hql, params);
                return count;
            }
        }
    }

    @Override
    public void changePassword(int groupId) {
        // TODO Auto-generated method stub
        // 负责人恢复密码，恢复为初始密码，即登陆名
        String pa = Encryt.encryptString_md5(this.getComHosGroupByGroupId(groupId).getGroupLoginname());
        String hql = "update TCommunityHospitalGroup tch set tch.groupPassword='" + pa + "' where tch.GId=" + groupId;
        communityHospitalGroupDao.update(hql);
    }

    @Override
    public void changeState(int groupId, String state) {
        // TODO Auto-generated method stub
        // 状态0表示启用，1表示禁用，2表示删除
        // 禁用该医院的同时，该医院的员工也被禁用，用触发器实现
        String hql = "update TCommunityHospitalGroup tch set tch.groupStatus=" + state + " where tch.GId=" + groupId
                + " or tch.isCopy=" + groupId;
        communityHospitalGroupDao.update(hql);
    }

    @Override
    public List<TCommunityHospitalGroup> getAllQiYongGroups() {
        // TODO Auto-generated method stub
        String hql = "from TCommunityHospitalGroup tch where tch.groupStatus = '" + OperatorState.qiyong.getvalue()
                + "' and tch.isCopy=0 order by tch.groupName asc";
        return communityHospitalGroupDao.find(hql);
    }

    @Override
    public TCommunityHospitalGroup getComHosGroupByName(String groupName) {
        // TODO Auto-generated method stub
        String hql = "from TCommunityHospitalGroup tch where tch.groupName=:groupName and tch.isCopy=0";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("groupName", groupName);
        TCommunityHospitalGroup tCommunityHospitalGroup = communityHospitalGroupDao.Get(hql, params);
        return tCommunityHospitalGroup;
    }

    @Override
    public List<TCommunityHospital> getComHosListByGroup(TCommunityHospitalGroup tCommunityHospitalGroup) {
        TCommunityHospitalGroup group = this.getRealComHosGroup(tCommunityHospitalGroup);
        String hql = "from TCommunityHospital tch where tch.TCommunityHospitalGroup.GId = " + group.getGId()
                + " and tch.status <>" + OperatorState.shanchu.getvalue()+" order by tch.communityHospital asc";
        return communityHospitalDao.find(hql);
    }

    @Override
    public void saveCopyComHosGroup(TCommunityHospitalGroup tCommunityHospitalGroup) {
        // TODO Auto-generated method stub
        HttpSession session = ServletActionContext.getRequest().getSession();
        TCommunityHospitalGroup group1 = (TCommunityHospitalGroup) session.getAttribute("communityHospitalGroup");
        TCommunityHospitalGroup group = this.getRealComHosGroup(group1);
        String pa = Encryt.encryptString_md5(tCommunityHospitalGroup.getGroupLoginname());
        tCommunityHospitalGroup.setGroupPassword(pa);
        tCommunityHospitalGroup.setIsCopy(group.getGId());
        tCommunityHospitalGroup.setGroupAddress(group.getGroupAddress());
        tCommunityHospitalGroup.setGroupName(group.getGroupName());
        tCommunityHospitalGroup.setGroupStatus(group.getGroupStatus());
        communityHospitalGroupDao.Save(tCommunityHospitalGroup);

    }

    // 登录by xuleping
    public Enum loginCheck(String loginname, String Password) {
        Result_Login result = Result_Login.NO_USER;
        TCommunityHospitalGroup comHospitalGroup = communityHospitalGroupDao
                .Get("from TCommunityHospitalGroup ty where ty.groupLoginname = '" + loginname + "'");
        Password = Encryt.encryptString_md5(Password);
        String password = comHospitalGroup.getGroupPassword();
        if (Password.equals(password)) {
            result = Result_Login.LOGIN_SUCCESS;
        } else {
            result = Result_Login.PASS_ERROR;
        }
        return result;
    }

    @Override
    public TCommunityHospitalGroup getRealComHosGroup(TCommunityHospitalGroup comHosGroup) {
        // TODO Auto-generated method stub
        int a = comHosGroup.getIsCopy();
        if (a == 0) {
            return comHosGroup;
        } else {
            return this.getComHosGroupByGroupId(a);
        }
    }

    @Override
    public TCommunityHospitalGroup getComHosGroupByPhone(String phone) {
        
        String hql = "from TCommunityHospitalGroup tch where tch.groupPhone=:groupPhone and tch.isCopy=0";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("groupPhone", phone);
        TCommunityHospitalGroup tCommunityHospitalGroup = communityHospitalGroupDao.Get(hql, params);
        return tCommunityHospitalGroup;
    }

    @Override
    public List<TCommunityHospital> getComHosListByGroupByPage(TCommunityHospitalGroup group1,
            Page<TCommunityHospital> page) {
        TCommunityHospitalGroup group = this.getRealComHosGroup(group1);
        String hql = "from TCommunityHospital tch where tch.TCommunityHospitalGroup.GId = " + group.getGId()
                + " and tch.status <>" + OperatorState.shanchu.getvalue()+" order by tch.communityHospital asc";
        return communityHospitalDao.find(hql,page.getCurrentPage(),page.getPageSize());
        
    }

}
