package com.jmjk.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jmjk.action.base.BaseAction;
import com.jmjk.entity.TMaintainableAttribute;
import com.jmjk.entity.TMaintainableEntry;
import com.jmjk.service.MaintainableAttributeService;
import com.jmjk.service.MaintainableEntryService;
import com.jmjk.utils.Page;

/**
 * 可维护字段
 * @author xuleping
 *
 */
@Scope("prototype")
@Component
@Action(value = "MaintainaleAction", results = {
		@Result(name = "list",location = "/jsp/systemManage/maintainable/MaintainableAttribute.jsp"),
		@Result(name = "types",location="/jsp/systemManage/maintainable/MaintainableAttribute.jsp"),
		/*location="MaintainaleAction!getMaintainableEntry.action", type="redirectAction" ,params={"maintainableAttributeId","${maintainableAttributeId}"}*/
		@Result(name="maintainable",location="/jsp/systemManage/maintainable/MaintainableEntry.jsp"),
		@Result(name="entryList",location="/jsp/systemManage/maintainable/MaintainableEntry.jsp"),
		//params={"maintainableAttributeId","${maintainableAttributeId}"}直接加参数不写
		/*@Result(name = "addEntry",type="redirectAction",params={"maintainableAttributeId","${maintainableAttributeId}"},location="MaintainaleAction!getMaintainableEntry.action"),
		@Result(name = "updateEntry",type="redirectAction",params={"maintainableAttributeId","${maintainableAttributeId}"},location="MaintainaleAction!getMaintainableEntry.action"),
		//带参数的重定向，jsp中也得写对应的参数
		@Result(name = "deleteEntry",type="redirectAction", params={"maintainableAttributeId","${maintainableAttributeId}"},location="MaintainaleAction!getMaintainableEntry.action")*/
		@Result(name = "test",location = "/success.jsp")
		
})
public class MaintainableAction extends BaseAction {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private MaintainableAttributeService maintainableAttributeService;
	@Autowired
	private MaintainableEntryService maintainableEntryService;
	
	private String pageHtml; // 分页
	private int cp = 1; // current page
	//private String field; // 搜索字段  下拉的菜单里边
	private String searchText = ""; // 搜索内容   输入的内容
	//private List<VMaintainable> mainList;
	private String file; //搜索名称 下拉的菜单里边与jsp中对应
	private List<TMaintainableEntry> mateList;                 //数据项列表
	private int maintainableAttributeId;                       //可维护字段id
	private String name;                                      //可维护字段名称(数据项中回显可维护字段名称的时候用)
	private String newName;                                  //修改成的数据项名称
	private TMaintainableAttribute tattribute;                //可维护字段
	private TMaintainableEntry entry;                         //数据项
	private List<TMaintainableAttribute> maintainableAttributes;   //属性列表
	private String message="";
	private String entryName;                                 //要修改成的数据项名称
	private int entryId;									  //数据项id
	private List<TMaintainableEntry> maintainableEntries;//数据项列表
	private String code;	
	private List<TMaintainableEntry> mateEntryName;
	private List<TMaintainableEntry> tmEntries;
	private List<TMaintainableAttribute> typeList;
	private List<String> list;
	
	public String getTypes(){
		typeList=maintainableAttributeService.getTMaintainableAttribute();
		list =new ArrayList<String>();
		for(Object tm:typeList){
			list.add(tm.toString());
		}
		return "types";
	}

	//得到可维护字段名称和数据项内容
	public String getMaintainableByPage(){	
		Page<TMaintainableAttribute> page=new Page<TMaintainableAttribute>();
			//得到所有的数据项，与jsp中对应
			mateList=maintainableEntryService.getMaintainableEntriesListByAll();			
			//通过可维护字段id得到可维护字段(与jsp中对应)
			tattribute=maintainableAttributeService.getAttributeById(maintainableAttributeId);
			page.setCurrentPage(cp);
			page.setTotalNum(maintainableAttributeService.getMaintainableNumBySearch(file, searchText));
			//根据搜索获取可维护字段
			maintainableAttributes=maintainableAttributeService.getMaintainableNameBySearch(file, searchText, page);
			//同一可维护字段下的数据项
			/*List<TMaintainableEntry> tmEntries =new ArrayList<TMaintainableEntry>();
			//最终所要的数据项（前几项）
			mateEntryName=new ArrayList<TMaintainableEntry>();
			//高级for循环	格式：for（数据类型 变量名：被遍历的集合（conllection）或者数组）
			for(TMaintainableAttribute tma:maintainableAttributes){	
				tmEntries =new ArrayList<TMaintainableEntry>();
				for(TMaintainableEntry tm: mateList){
					if(tmEntries.size()<5){
						if(tma.getMaintainableAttributeId()==tm.getTMaintainableAttribute().getMaintainableAttributeId()){					
							tmEntries.add(tm);
							mateEntryName.add(tm);
						}
					}else{
						continue;
					}											
				}					
			}*/
			
			pageHtml = page
					.getPage("MaintainaleAction!getMaintainableByPage.action?searchText="+ searchText + "&file="+file);		
			getTypes();
			return "list";
	}
	
	//得到对应的可维护字段名称
	public String getMaintainableEntry(){
		//通过可维护字段id拿到可维护字段实体与jsp中相对应
		tattribute=maintainableAttributeService.getAttributeById(maintainableAttributeId);
		//通过可维护字段id拿到数据项列表与jsp中相对应
		mateList=maintainableEntryService.getMaintainableEntryById(maintainableAttributeId);
		return "entryList";
	}
	
/*	//修改可维护字段名称
	public String updateMaintainableName() {
		if(newName==null||newName.equals("")||newName.trim().equals("")){
			return "maintainable";
		}else{
			tattribute=maintainableAttributeService.updateMaintainableName(maintainableAttributeId, newName);	
			return "maintainable";
		}
	}*/
	
	//测试得到数据项
	 public String getEStringByCode(){
		 maintainableEntries=maintainableAttributeService.getmEntriesByCode("15001");
		 return "test";
	 }

	 ///////////////////////////////////////////////////////////////////////////////////////
	public String getPageHtml() {
		return pageHtml;
	}

	public void setPageHtml(String pageHtml) {
		this.pageHtml = pageHtml;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}


	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}


	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public List<TMaintainableEntry> getMateList() {
		return mateList;
	}

	public void setMateList(List<TMaintainableEntry> mateList) {
		this.mateList = mateList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public int getMaintainableAttributeId() {
		return maintainableAttributeId;
	}



	public void setMaintainableAttributeId(int maintainableAttributeId) {
		this.maintainableAttributeId = maintainableAttributeId;
	}



	public List<TMaintainableAttribute> getMaintainableAttributes() {
		return maintainableAttributes;
	}



	public void setMaintainableAttributes(
			List<TMaintainableAttribute> maintainableAttributes) {
		this.maintainableAttributes = maintainableAttributes;
	}
	
	public TMaintainableAttribute getTattribute() {
		return tattribute;
	}

	public void setTattribute(TMaintainableAttribute tattribute) {
		this.tattribute = tattribute;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public TMaintainableEntry getEntry() {
		return entry;
	}

	public void setEntry(TMaintainableEntry entry) {
		this.entry = entry;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		try {
			this.message = java.net.URLDecoder.decode(message, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	public String getEntryName() {
		return entryName;
	}

	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}

	public int getEntryId() {
		return entryId;
	}

	public void setEntryId(int entryId) {
		this.entryId = entryId;
	}

	public List<TMaintainableEntry> getMaintainableEntries() {
		return maintainableEntries;
	}

	public void setMaintainableEntries(List<TMaintainableEntry> maintainableEntries) {
		this.maintainableEntries = maintainableEntries;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<TMaintainableEntry> getMateEntryName() {
		return mateEntryName;
	}

	public void setMateEntryName(List<TMaintainableEntry> mateEntryName) {
		this.mateEntryName = mateEntryName;
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public List<TMaintainableEntry> getTmEntries() {
		return tmEntries;
	}

	public void setTmEntries(List<TMaintainableEntry> tmEntries) {
		this.tmEntries = tmEntries;
	}

	public List<TMaintainableAttribute> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<TMaintainableAttribute> typeList) {
		this.typeList = typeList;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}


	
}
