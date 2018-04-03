package com.jmjk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.hql.internal.ast.tree.MapValueNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.itextpdf.text.Paragraph;
import com.jmjk.dao.MaintainableAttributeDao;
import com.jmjk.dao.MaintainableEntryDao;
import com.jmjk.dao.VMaintainableDao;
import com.jmjk.entity.TMaintainableAttribute;
import com.jmjk.entity.TMaintainableEntry;
import com.jmjk.entity.view.VMaintainable;
import com.jmjk.iservice.IMaintainableEntryService;


/**
 * 可维护条目service接口
 * @author xuleping
 *
 */
@Controller("maintainableEntryService")
public class MaintainableEntryService implements IMaintainableEntryService {
	
	@Autowired
	private MaintainableEntryDao maintainableEntryDao;	
	@Autowired
	private VMaintainableDao vMaintainableDao;
	@Override
	public void addMaintainableEntry(TMaintainableEntry maintainableEntry) {
		maintainableEntryDao.Save(maintainableEntry);
	}

	@Override
	public void deleteMaintainableEntry(int maintainableEntryId) {
		String hql="delete from TMaintainableEntry tme where tme.maintainableEntryId="+maintainableEntryId;
		maintainableEntryDao.delete(hql);
	}

	@Override
	public void updateMaintainableEntry(TMaintainableEntry maintainableEntry) {
		maintainableEntryDao.update(maintainableEntry);
	}

	@Override
	public TMaintainableEntry updateMaintainableEntry(int id,String entryName){
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("id", id);
		String hql="from TMaintainableEntry tme where tme.maintainableEntryId=:id";
		TMaintainableEntry tme=maintainableEntryDao.Get(hql,params);
		tme.setName(entryName);
		return tme;
		/*String hql="update from TMaintainableEntry tme set tme.name='"+entryName+"' where tme.maintainableEntryId="+id;
		maintainableEntryDao.update(hql);	*/	
	}

	@Override
	public List<TMaintainableEntry> getMaintainableEntryById(
			int maintainableAttributeId) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("maintainableAttributeId", maintainableAttributeId);
		String hql="from TMaintainableEntry tme where tme.TMaintainableAttribute.maintainableAttributeId=:maintainableAttributeId order by tme.name";
		return maintainableEntryDao.find(hql,params);
	}

	@Override
	public List<VMaintainable> getMaintainablesByCode(String code) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("code",code);
		String hql = "from VMaintainable vmt where vmt.code=:code";
		List<VMaintainable> vMaintainables = vMaintainableDao.find(hql,params);
		return vMaintainables;
	}
	
	@Override
	public List<TMaintainableEntry> getMaintainableEntriesListByAll(){
		String hql = "from TMaintainableEntry tme order by tme.name";
		return maintainableEntryDao.find(hql);
	}
	@Override
	 public TMaintainableEntry getMaintainableEntryByName(String name){
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("name", name);
		 String hql = "from TMaintainableEntry tme where tme.name=:name";
		 return maintainableEntryDao.Get(hql,params);
	 }
	//通过数据项id获得数据项实体
	public TMaintainableEntry getMaintainableEntryByEntryId(int entryId){
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("entryId",entryId);
		String hql="from TMaintainableEntry tme where tme.maintainableEntryId=:entryId";
		return maintainableEntryDao.Get(hql,params);
	}
	/*//通过数据项名称更新数据项
	public void updateMaintainableEntryByName(String name){
		String hql="update from TMaintainableEntry tme where set tme.name='"+name+"'";
		 maintainableEntryDao.update(hql);
	}*/
	
}
