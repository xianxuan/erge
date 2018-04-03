package com.jmjk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.RoleDao;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TRole;
import com.jmjk.entity.TStaff;
import com.jmjk.iservice.IRoleService;
import com.jmjk.iservice.IStaffService;

/**
 * 实现IRoleService
 * @author Songhuili
 *  18803096552
 *
 */

@Controller("roleService")

public class RoleService implements IRoleService {
	
	@Autowired
	private RoleDao roleDao;
	@Autowired
	private IStaffService staffService;
	
	@Override
	public void addRole(TRole role) {
		int communityId=this.getCommunityId();
		role.setCommunityId(communityId);
		roleDao.Save(role);
		
	}
	
	public void addRoleForSu(TRole role) {
		
		roleDao.Save(role);
		
	}
	@Override
	public void updateRole(TRole role) {
		roleDao.update(role);
		
	}

	@Override
	public void deleteRole(int roleId) {
		//当删除这个角色时，具有该角色的员工的角色id置为空,通过触发器实现
		String hql="delete from TRole tr where tr.roleId="+roleId;
		roleDao.delete(hql);
		
	}

	@Override
	public List<TRole> getAllRole() {
		int communityId=this.getCommunityId();
		String hql="from TRole tr where tr.communityId="+communityId +" order by tr.roleName desc";
		return roleDao.find(hql);
		
	}

	@Override
	public TRole getRoleById(int roleId) {
		String hql="from TRole tr where tr.roleId=:roleId";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("roleId", roleId);
		return roleDao.Get(hql, params);
		
	}

	@Override
	public TRole getRoleByRoleName(String roleName) {
		String hql="from TRole tr where tr.roleName=:roleName and tr.communityId=:communityId";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("roleName", roleName);
		int communityId=this.getCommunityId();
		params.put("communityId", communityId);
		return roleDao.Get(hql, params);
	}
	@Override
	public TRole getRoleByHosIdForSu(int hosId) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("communityId", hosId);
		String hql="from TRole tr where tr.communityId=:communityId ";
		return roleDao.Get(hql, params);
	}

	@Override
	public TRole getRoleByName(String name, int id) {
		String hql="from TRole tr where tr.roleName=:name and tr.communityId=:communityId and tr.roleId<>:id";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("name", name);
		params.put("id", id);
		int communityId=this.getCommunityId();
		params.put("communityId", communityId);
		return roleDao.Get(hql, params);
	}
	
	public int getCommunityId()
	{
		int communityId;
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospital tc=(TCommunityHospital)session.getAttribute("comHospital");   
		//如果是空   那就是 员工  
		if(tc==null){
			TStaff ts=(TStaff)session.getAttribute("tstaff"); //员工实体
			int a=ts.getStaffId(); 				  //返回  是员工的Id
			communityId=staffService.getCommHospitalByStaffId(a);
		}
		else{
			communityId=tc.getCommunityHospitalId();
		}
		return communityId;
	}

}
