package com.jmjk.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.jmjk.action.base.BaseAction;
import com.jmjk.entity.TPower;
import com.jmjk.entity.TRights;
import com.jmjk.entity.TRole;
import com.jmjk.enums.RightsValue;
import com.jmjk.iservice.IPowerService;
import com.jmjk.iservice.IRightsService;
import com.jmjk.iservice.IRoleService;
import com.jmjk.pojo.Rights;
import com.jmjk.pojo.Rights.Right;
import com.jmjk.utils.WebXMLParameter;

/**
 * 角色与权限部分
 * 
 * @author Songhuili 18803096552
 */
@Component
@Scope("prototype")
@Action(value = "roleAction", results = {
		@Result(name = "rolelist", location = "/jsp/systemManage/roleRights/roleindex.jsp"),
		@Result(name = "addrole", location = "/jsp/systemManage/roleRights/addRole.jsp"),
		@Result(name = "listrole", type = "redirectAction", location = "roleAction!getRoleList"),
		@Result(name = "findRoleInfo", location = "/jsp/systemManage/roleRights/roleInfo.jsp"),
		@Result(name = "editrole", location = "/jsp/systemManage/roleRights/editRole.jsp"),

})
public class RoleAction extends BaseAction {

	private static final long serialVersionUID = 1L;

	@Autowired
	private IRoleService roleService;
	@Autowired
	private IRightsService rightsService;
	@Autowired
	private IPowerService powerService;

	private int roleId;
	private TRole role;
	private TRights trights;
	private String roleName;
	private String module;
	private String rightsName;
	private String rightsCode;
	private Integer rightsValue;
	private List<TRole> listRoles;
	private List<TRights> listRights;
	private String rights;
	private String msg;
	private List<TPower> listpowers;
	private List<Map<String, Object>> listmap;
	private List<Map<String, Object>> listmapchildren;
	private List<Integer> listval;
	private List<Integer> listvalchildren;
	private List<String> listMo = new ArrayList<String>();
	private List<String> listModule = new ArrayList<String>();
	private List<String> listNoMenue = new ArrayList<String>();
	private int staffId;
	public String result;

	// //用于查询显示所有角色
	public String getRoleList() {
		listRoles = roleService.getAllRole();
		return "rolelist";
	}

	// 跳转页面到增加角色的页面
	public String jumpAddRole() {
		this.getPowerlist();
		return "addrole";
	}

	// 判断是否存在改角色
	public void ifHaveRole() {
		if (roleId == 0) {
			role = roleService.getRoleByRoleName(roleName);
		} else {
			role = roleService.getRoleByName(roleName, roleId);
		}
		if (role == null) {
			result = "1";
		} else {
			result = "0";
		}
		this.writeJson(result);
	}

	// 新增角色
	public void addRole() {

		role = new TRole();
		roleName = roleName.trim();
		role.setRoleName(roleName);
		roleService.addRole(role);
		rights = "{\"Rights\":" + rights + "}";
		Rights myRights = JSON.parseObject(rights, Rights.class);
		// System.out.println(myRights);
		for (int i = 0; i < myRights.getRights().size(); i++) {
			trights = new TRights();
			trights.setTRole(role);
			trights.setModule(myRights.getRights().get(i).getModule());
			trights.setRightsCode(myRights.getRights().get(i).getRightsCode());
			trights.setRightsName(myRights.getRights().get(i).getRightsName());
			String val = myRights.getRights().get(i).getRightsValue();
			String[] rightValue = val.split(",");
			int value = 0;
			List<Integer> listvalue1 = new ArrayList<Integer>();
			for (String string : rightValue) {
				int a = Integer.parseInt(string);
				listvalue1.add(a);
				value = value + a;
			}
			if (!(listvalue1.contains(1))) {
				value = value + 1;
			}
			trights.setRightsValue(value);
			rightsService.saveRights(trights);
		}
		this.writeJson("200");

	}

	// 删除角色
	public String deleteRole() {
		roleService.deleteRole(roleId);
		return "listrole";
	}

	// 查询角色的权限信息
	public void findRoleInfo() {
		Rights myRights = new Rights();
		ArrayList<Right> riglist = new ArrayList<Right>();
		role = roleService.getRoleById(roleId);
		listRights = rightsService.getAllRights(roleId);
		for (int i = 0; i < listRights.size(); i++) {
			String value = "";
			rightsValue = listRights.get(i).getRightsValue();
			if ((rightsValue & RightsValue.xianshi.getValue()) != 0) {
				value = value + RightsValue.xianshi.getValue() + ",";
			}
			if ((rightsValue & RightsValue.tianjia.getValue()) != 0) {
				value = value + RightsValue.tianjia.getValue() + ",";
			}
			if ((rightsValue & RightsValue.xiugai.getValue()) != 0) {
				value = value + RightsValue.xiugai.getValue() + ",";
			}
			if ((rightsValue & RightsValue.shanchu.getValue()) != 0) {
				value = value + RightsValue.shanchu.getValue() + ",";
			}
			if ((rightsValue & RightsValue.dayin.getValue()) != 0) {
				value = value + RightsValue.dayin.getValue() + ",";
			}
			if ((rightsValue & RightsValue.daochu.getValue()) != 0) {
				value = value + RightsValue.daochu.getValue() + ",";
			}
			if (value == "") {
				break;
			} else {
				Right rig = myRights.new Right();
				String val = value.substring(0, value.length() - 1);
				module = listRights.get(i).getModule();
				rightsCode = listRights.get(i).getRightsCode();
				rightsName = listRights.get(i).getRightsName();
				rig.setModule(module);
				rig.setRightsCode(rightsCode);
				rig.setRightsName(rightsName);
				rig.setRightsValue(val);
				riglist.add(rig);

			}
		}
		myRights.setRights(riglist);
		// System.out.println(JSON.toJSONString(riglist));
		msg = JSON.toJSONString(riglist);
		this.writeJson(msg);
	}

	// ///跳转到查看角色权限的页面
	public String jumpFindRoleInfo() {
		this.getPowerlist();
		role = roleService.getRoleById(roleId);
		return "findRoleInfo";
	}

	// //编辑角色的权限
	public void editRole() {

		role = roleService.getRoleById(roleId);
		roleName = roleName.trim();
		role.setRoleName(roleName);
		rightsService.deleteRights(roleId);
		rights = "{\"Rights\":" + rights + "}";
		Rights myRights = JSON.parseObject(rights, Rights.class);
		// System.out.println(myRights);
		for (int i = 0; i < myRights.getRights().size(); i++) {
			trights = new TRights();
			trights.setTRole(role);
			trights.setModule(myRights.getRights().get(i).getModule());
			trights.setRightsCode(myRights.getRights().get(i).getRightsCode());
			trights.setRightsName(myRights.getRights().get(i).getRightsName());
			String val = myRights.getRights().get(i).getRightsValue();
			String[] rightValue = val.split(",");
			int value = 0;
			List<Integer> listvalue1 = new ArrayList<Integer>();
			for (String string : rightValue) {
				int a = Integer.parseInt(string);
				listvalue1.add(a);
				value = value + a;
			}
			if (!(listvalue1.contains(1))) {
				value = value + 1;
			}
			/*
			 * if(value>=2){ int
			 * flag=0;//falg为0的时候表示包含显示的权限，也就是包含1；falg为1的时候表示不包含显示的权限，也就是不包含1
			 * for(int k=0;k<rightValue.length;k++)
			 * if(rightValue[k].indexOf("1")!=-1)//包含“1” { flag=1; }
			 * if(flag==0){ value=value+1; } }
			 */
			trights.setRightsValue(value);
			rightsService.saveRights(trights);
		}
		this.writeJson("200");
	}

	public String jumpEditRole() {
		this.getPowerlist();
		role = roleService.getRoleById(roleId);
		return "editrole";
	}

	// 得到全部权限,用于在jsp页面中显示,其中不包含系统管理和统计分析
	public void getPowerlist() {
		listpowers = powerService.getPowers();
		// System.out.println(listModule);
		listmap = new ArrayList<Map<String, Object>>();
		listval = new ArrayList<Integer>();
		listmapchildren = new ArrayList<Map<String, Object>>();
		Map<String, Object> m1 = new HashMap<String, Object>();
		Map<String, Object> m2 = new HashMap<String, Object>();
		int flag = 1;// flag=1,此时为一级菜单,flag=2时为二级菜单,flag=0时此一级菜单无二级菜单
		for (int i = 0; i < listpowers.size(); i++) {
			if (listpowers.get(i).getCode()
					.equals(WebXMLParameter.getColumnCod("ten"))
					|| listpowers.get(i).getCode()
							.equals(WebXMLParameter.getColumnCod("ten_one"))
					|| listpowers.get(i).getCode()
							.equals(WebXMLParameter.getColumnCod("ten_two"))
					|| listpowers.get(i).getCode()
							.equals(WebXMLParameter.getColumnCod("ten_three"))
					|| listpowers.get(i).getCode()
							.equals(WebXMLParameter.getColumnCod("ten_four"))
					||listpowers.get(i).getCode()
							.equals(WebXMLParameter.getColumnCod("ten_five"))
					||listpowers.get(i).getCode()
							.equals(WebXMLParameter.getColumnCod("two_two"))
					|| listpowers.get(i).getCode()
							.equals(WebXMLParameter.getColumnCod("eight"))
					|| listpowers.get(i).getCode()
							.equals(WebXMLParameter.getColumnCod("eight_one"))
					|| listpowers.get(i).getCode()
							.equals(WebXMLParameter.getColumnCod("eight_two"))
					|| listpowers.get(i).getCode()
							.equals(WebXMLParameter.getColumnCod("eight_three"))) {
				continue;
			} else {
				if (flag == 1) {
					m1 = new HashMap<String, Object>();
					m2 = new HashMap<String, Object>();
					listval = new ArrayList<Integer>();
					listmapchildren = new ArrayList<Map<String, Object>>();
					module = listpowers.get(i).getFirst();
					rightsName = listpowers.get(i).getSecond();
					rightsCode = listpowers.get(i).getCode();
					// co=listpowers.get(i).getValue()+"";
					listval.add(listpowers.get(i).getValue());
					m1.put("module", module);
					m1.put("rightsName", rightsName);
					m1.put("rightsCode", rightsCode);
					if (listpowers.get(i).getValue() == null) // 此时有二级菜单
					{
						listvalchildren = new ArrayList<Integer>();
						flag = 2;
					} else { // 无二级菜单
						flag = 0;
						listmapchildren.add(null);
						m1.put("value", listval);
					}
				} else if (flag == 0) {
					listval.add(listpowers.get(i).getValue());
					m1.put("value", listval);
				} else if (flag == 2) {
					String ccode = listpowers.get(i).getCode();
					String mmodule = listpowers.get(i).getFirst();
					if ((!(ccode.equals(rightsCode))) && mmodule.equals(module)) {
						if (!(ccode.equals(listpowers.get(i - 1).getCode()))) {
							m2 = new HashMap<String, Object>();
							String name = listpowers.get(i).getSecond();
							listvalchildren = new ArrayList<Integer>();
							listvalchildren.add(listpowers.get(i).getValue());
							m2.put("module", mmodule);
							m2.put("rightsName", name);
							m2.put("rightsCode", ccode);
							m2.put("value", listvalchildren);
						} else {
							listvalchildren.add(listpowers.get(i).getValue());
							m2.put("value", listvalchildren);
						}
						if (i < listpowers.size() - 1) {
							if (!(ccode.equals(listpowers.get(i + 1).getCode()))) {
								listmapchildren.add(m2);
							}
						} else {
							listmapchildren.add(m2);
						}
					}
				}
				if (i < listpowers.size() - 1) {
					if (!(module.equals(listpowers.get(i + 1).getFirst()))) {
						flag = 1;
						m1.put("children", listmapchildren);
						listmap.add(m1);
					}
				} else {
					m1.put("children", listmapchildren);
					listmap.add(m1);
				}
			}
		}

	}

	// //////////////////////////////////////////////

	public String getMsg() {
		return msg;
	}

	public List<Map<String, Object>> getListmap() {
		return listmap;
	}

	public void setListmap(List<Map<String, Object>> listmap) {
		this.listmap = listmap;
	}

	public List<Map<String, Object>> getListmapchildren() {
		return listmapchildren;
	}

	public void setListmapchildren(List<Map<String, Object>> listmapchildren) {
		this.listmapchildren = listmapchildren;
	}

	public List<Integer> getListval() {
		return listval;
	}

	public void setListval(List<Integer> listval) {
		this.listval = listval;
	}

	public List<Integer> getListvalchildren() {
		return listvalchildren;
	}

	public void setListvalchildren(List<Integer> listvalchildren) {
		this.listvalchildren = listvalchildren;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getRights() {
		return rights;
	}

	public void setRights(String rights) {
		this.rights = rights;
	}

	public List<TPower> getListpowers() {
		return listpowers;
	}

	public void setListpowers(List<TPower> listpowers) {
		this.listpowers = listpowers;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public TRole getRole() {
		return role;
	}

	public void setRole(TRole role) {
		this.role = role;
	}

	public TRights getTrights() {
		return trights;
	}

	public void setTrights(TRights trights) {
		this.trights = trights;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
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

	public String getRightsCode() {
		return rightsCode;
	}

	public void setRightsCode(String rightsCode) {
		this.rightsCode = rightsCode;
	}

	public Integer getRightsValue() {
		return rightsValue;
	}

	public void setRightsValue(Integer rightsValue) {
		this.rightsValue = rightsValue;
	}

	public List<TRole> getListRoles() {
		return listRoles;
	}

	public void setListRoles(List<TRole> listRoles) {
		this.listRoles = listRoles;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

}
