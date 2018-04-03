package com.jmjk.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.RightsDao;
import com.jmjk.entity.TRights;
import com.jmjk.entity.TRole;
import com.jmjk.entity.TStaff;
import com.jmjk.iservice.IRightsService;

@Controller("rightsService")
public class RightsService implements IRightsService {

	@Autowired
	private RightsDao rightsDao;
	@Autowired
	private StaffService staffSerrvice;
	
	@Override
	public void saveRights(TRights rights) {
		rightsDao.Save(rights);
	}

	@Override
	public void deleteRights(int roleId) {
		String hql="delete from TRights tr where tr.TRole.roleId="+roleId;
		rightsDao.delete(hql);
	}

	@Override
	public List<TRights> getAllRights() {
		String hql="from TRights";
		return rightsDao.find(hql);
	}

	@Override
	public List<TRights> getAllRights(int roleId) {
		String hql="from TRights tr where tr.TRole.roleId=:roleId";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("roleId", roleId);
		return rightsDao.find(hql, params);
	}

	@Override
	public TRights getRightsById(int rightsId) {
		String hql="from TRights tr where tr.rightsId=:rightsId";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("rightsId", rightsId);
		return rightsDao.Get(hql, params);
	}

	@Override
	public boolean ifHaveRights(int staffId, String rightsCode,
			int rightValue) {
		TRole tRole=staffSerrvice.getStaffById(staffId).getTRole();
		List<TRights> listRights=this.getAllRights(tRole.getRoleId());
		for(int i=0;i<listRights.size();i++){
			if(listRights.get(i).getRightsCode()==rightsCode&&listRights.get(i).getRightsValue()==rightValue){
				return true;
			}
		}
		return false;
	}

	@Override
	public List<TRights> getAllRightsByStaffId(int staffId) {
		TRole tRole=staffSerrvice.getStaffById(staffId).getTRole();
		String hql="from TRights tr where tr.TRole.roleId="+tRole.getRoleId()+" order by tr.rightsCode";
		return rightsDao.find(hql);
	}

	
	
	@Override
	public int getStaffValueByColumnCod(int staffId, String columnCod) {
		TStaff staff=staffSerrvice.getStaffById(staffId);
		int roleId=staff.getTRole().getRoleId();
		String hql="from TRights tr where tr.TRole.roleId=:roleId and tr.rightsCode=:columnCod";
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("roleId", roleId);
		params.put("columnCod", columnCod);
		int value=rightsDao.Get(hql, params).getRightsValue();
		return value;
	}

	@Override
	public List<String> getAllRightValueByStaffId(int staffId) {
		TRole tRole=staffSerrvice.getStaffById(staffId).getTRole();
		String hql="from TRights tr where tr.TRole.roleId="+tRole.getRoleId();
		List<TRights> tRightsList = rightsDao.find(hql);
		List<String> rightValueList = new ArrayList<String>();
		for (int i = 0; i < tRightsList.size(); i++) {
			rightValueList.add(tRightsList.get(i).getRightsCode());
		}

		return rightValueList;
	}
	
}
