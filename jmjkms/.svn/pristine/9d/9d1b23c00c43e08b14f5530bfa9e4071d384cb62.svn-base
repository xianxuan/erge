package com.jmjk.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.MaintainableAttributeDao;
import com.jmjk.dao.MaintainableEntryDao;
import com.jmjk.dao.VMaintainableDao;
import com.jmjk.entity.TMaintainableAttribute;
import com.jmjk.entity.TMaintainableEntry;
import com.jmjk.entity.view.VMaintainable;
import com.jmjk.iservice.IMaintainableAttributeService;
import com.jmjk.utils.Page;

/**
 * 可维护字段名称service实现
 * @author xuleping
 *
 */
@Controller("maintainableAttributeService")
public class MaintainableAttributeService implements IMaintainableAttributeService{
	
	@Autowired
	private MaintainableAttributeDao maintainableAttributeDao;
	@Autowired
	private VMaintainableDao vmaintainableDao;
	@Autowired
	private MaintainableEntryDao maintainableEntryDao;
	
	@Override
	public void updateMaintainableAttribute(TMaintainableAttribute maintainableAttribute) {		
		maintainableAttributeDao.update(maintainableAttribute);
	}
//分页和统计数量方法中hql语句不一致，会出错
	@Override
	public List<TMaintainableAttribute> getMaintainableNameBySearch(String field,String searchText, Page<TMaintainableAttribute> page) {		
		//List<TMaintainableAttribute> listMaintainables=new ArrayList<TMaintainableAttribute>();
		Map<String, Object> params=new HashMap<String, Object>();
		if(field==null||field.equals("null")){					
			String hql="from TMaintainableAttribute mt order by mt.name asc";
			return maintainableAttributeDao.find(hql,page.getCurrentPage(),page.getPageSize());
		}else if(field.equals("请选择")&&searchText==null){
			String hql="from TMaintainableAttribute mt order by mt.name asc";
			return maintainableAttributeDao.find(hql,page.getCurrentPage(),page.getPageSize());
		}else if(field.equals("请选择")&&searchText!=null){
			params.put("searchText", "%"+searchText+"%");
			String hql = "from TMaintainableAttribute mt where mt.name like:searchText order by mt.name asc";
			return maintainableAttributeDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
		}else{
			if(searchText==null||searchText.equals("")){
				params.put("field", field);
				String hql = "from TMaintainableAttribute mt where mt.type=:field order by mt.name asc";
				return maintainableAttributeDao.find(hql,params,page.getCurrentPage(),page.getPageSize());
			}
			else{
				params.put("field", field);
				params.put("searchText", "%"+searchText+"%");
//				params.put("searchText",searchText);
				String hql = "from TMaintainableAttribute mt where mt.type=:field and mt.name like:searchText order by mt.name asc";
//				String hql = "from TMaintainableAttribute mt where mt.type='" + field + "'and mt.name like '%"+searchText+"%'";
				return maintainableAttributeDao.find(hql,params, page.getCurrentPage(), page.getPageSize());
			}
		}
	}

	@Override
	public long getMaintainableNumBySearch(String field, String searchText) {
		Map<String, Object> params=new HashMap<String, Object>();
		if(field==null||field.equals("null")){
			String hql="select count(mt.maintainableAttributeId) from TMaintainableAttribute mt";
			return maintainableAttributeDao.count(hql);
		}else if(field.equals("请选择")&&searchText==null){
			String hql="select count(mt.maintainableAttributeId) from TMaintainableAttribute mt";
			return maintainableAttributeDao.count(hql);
		}else if(field.equals("请选择")&&searchText!=null){
			params.put("searchText", "%"+searchText+"%");
			String hql="select count(mt.maintainableAttributeId) from TMaintainableAttribute mt where mt.name like:searchText";
			return maintainableAttributeDao.count(hql,params);
		}else{  
				if(searchText==null||searchText.equals(""))
				{
					params.put("field", field);
					String hql="select count(mt.maintainableAttributeId) from TMaintainableAttribute mt where mt.type=:field";
					return maintainableAttributeDao.count(hql,params);
				}
				else{
					params.put("field", field);
					params.put("searchText", "%"+searchText+"%");
					String hql = "select count(mt.maintainableAttributeId) from TMaintainableAttribute mt where mt.type=:field and mt.name like:searchText";
					Long num= maintainableAttributeDao.count(hql,params);
					return num;
				}
		}
	}

	@Override
	public List<VMaintainable> getMaintainableNameBySearch() {
		List<VMaintainable> listVMaintainables=new ArrayList<VMaintainable>();
		String hql = "from VMaintainable vmt order by vmt.maintainableAttributeId desc";
		listVMaintainables = vmaintainableDao.find(hql);
		return listVMaintainables;
	}
	
	@Override
	public List<TMaintainableAttribute> getAttributeListByAll(Page<TMaintainableAttribute> page){
		String hql="from TMaintainableAttribute";
		return maintainableAttributeDao.find(hql,page.getCurrentPage(),page.getPageSize());
	}

	@Override
	public TMaintainableAttribute getAttributeById(int id) {
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("id", id);
		String hql="from TMaintainableAttribute tma where tma.maintainableAttributeId=:id";
		return maintainableAttributeDao.Get(hql,params);
	}
	
	@Override
	public int getAttributeByCode(String code){
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("code", code);
		String hql="from TMaintainableAttribute tme where tme.code=:code";
		try {
			return this.maintainableAttributeDao.Get(hql,params).getMaintainableAttributeId();
		} catch (Exception e) {
			return (Integer)null;
		}
	}
	
	@Override
	public List<TMaintainableEntry> getmEntriesByCode(String code){
		Map<String, Object> params=new HashMap<String, Object>();		
		int maintainableAttributeId=getAttributeByCode(code);
		params.put("maintainableAttributeId", maintainableAttributeId);
		String hql="from TMaintainableEntry tm where tm.TMaintainableAttribute.maintainableAttributeId=:maintainableAttributeId";
		return maintainableEntryDao.find(hql,params);
	}
  
	//修改可维护字段名称
	public TMaintainableAttribute updateMaintainableName(int id,String maintainableName){
		Map<String, Object> params=new HashMap<String, Object>();
		params.put("id", id);
		String hql="from TMaintainableAttribute tme where tme.maintainableAttributeId=:id";
		TMaintainableAttribute tme=maintainableAttributeDao.Get(hql,params);
		tme.setName(maintainableName);
		return tme;
	}
	//通过不同类型的可维护字段实体
	public List<TMaintainableAttribute> getTMaintainableAttribute(){
		String hql="select distinct tm.type from TMaintainableAttribute tm order by tm.type asc";	
		return maintainableAttributeDao.find(hql);
		
	}

}
