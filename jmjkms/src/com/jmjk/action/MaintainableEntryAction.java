package com.jmjk.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
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
import com.jmjk.utils.Reflex;
import com.opensymphony.xwork2.ActionContext;

/**
 * 数据项
 * @author xuleping
 *
 */
@Scope("prototype")
@Component
@Action(value = "MaintainableEntryAction", results = {
		@Result(name="entryList",location="/jsp/systemManage/maintainable/MaintainableEntry.jsp"),
		/*@Result(name = "addEntry",type="redirectAction",location="MaintainableEntryAction!getMaintainableEntry"),
		@Result(name = "updateEntry",type="redirectAction",location="MaintainableEntryAction!getMaintainableEntry"),*/
		@Result(name = "deleteEntry",type="redirectAction",params={"maintainableAttributeId","${maintainableAttributeId}"},location="MaintainableEntryAction!getMaintainableEntry.action")
})
public class MaintainableEntryAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private MaintainableAttributeService maintainableAttributeService;
	@Autowired
	private MaintainableEntryService maintainableEntryService;
	private TMaintainableEntry entry;                         //数据项
	private String message="";
	private String entryName;                                 //要修改成的数据项名称
	private int maintainableEntryId;									  //数据项id
	private TMaintainableAttribute tattribute;                //可维护字段
	private int maintainableAttributeId;                       //可维护字段id
	private List<TMaintainableEntry> mateList;                 //数据项列表
	private String oldName;
	private String name;
	private String newName;
	private String json;
	
	//得到数据项
	public String getMaintainableEntry(){
		tattribute=maintainableAttributeService.getAttributeById(maintainableAttributeId);
		mateList=maintainableEntryService.getMaintainableEntryById(maintainableAttributeId);
		return "entryList";
	}
	
	//添加数据项
	public String addEntry() throws IOException{		
		//从服务器传给客户端
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		List<TMaintainableEntry> maintainableEntries=maintainableEntryService.getMaintainableEntryById(maintainableAttributeId);
		if(entryName==null || entryName.equals("") || entryName.trim().equals("")){
			return null;
		}		
			entry=new TMaintainableEntry();					
			tattribute=maintainableAttributeService.getAttributeById(maintainableAttributeId);
			entry.setTMaintainableAttribute(tattribute);
			entry.setName(entryName);
			maintainableEntryService.addMaintainableEntry(entry);
			TMaintainableEntry tMaintainableEntry = maintainableEntryService.getMaintainableEntryByName(entryName);
			String json = "{\"maintainableAttributeId\":\""+tMaintainableEntry.getTMaintainableAttribute().getMaintainableAttributeId()+"\","+
			               "\"maintainableEntryId\":\""+tMaintainableEntry.getMaintainableEntryId()+"\","+
					       "\"name\":\""+tMaintainableEntry.getName()+"\"}";
			this.writeJson(json);	
		return null;
	}
	
	
	/**
	 * 编辑数据项
	 * @return
	 * @throws IOException 
	 */
	public String updateEntry() throws IOException{
		HttpServletResponse response=ServletActionContext.getResponse();
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");
		if(entryName==null || entryName.equals("") || entryName.trim().equals("")){
			return null;
		}
		TMaintainableEntry entryEdit=maintainableEntryService.updateMaintainableEntry(maintainableEntryId, entryName);			
		String json = "{\"maintainableEntryId\":\""+entryEdit.getMaintainableEntryId()+"\","+
	               "\"maintainableAttributeId\":\""+entryEdit.getTMaintainableAttribute().getMaintainableAttributeId()+"\","+
			       "\"name\":\""+entryEdit.getName()+"\"}";
		
		this.writeJson(json);
		return null;
	}

	//修改可维护字段名称
		public String updateMaintainableName() throws IOException {
			
			if(newName==null||newName.equals("")||newName.trim().equals("")){
				return null;
			}else{
				tattribute=maintainableAttributeService.updateMaintainableName(maintainableAttributeId, newName);	
				json = "{\"maintainableEntryId\":\""+tattribute.getMaintainableAttributeId()+"\","+	              
					       "\"name\":\""+newName+"\"}";				
			}
			HttpServletResponse response = (HttpServletResponse) ActionContext
					.getContext().get(
							org.apache.struts2.StrutsStatics.HTTP_RESPONSE);
			try {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.write(json);
				out.flush();
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
	
	/**
	 * 删除数据项
	 * @return
	 */
	public String deleteEntry(){
		//id不赋值默认的是0，需要在jsp的action方法中传入参数
		maintainableEntryService.deleteMaintainableEntry(maintainableEntryId);
		return "deleteEntry";
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////
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

	public int getMaintainableEntryId() {
		return maintainableEntryId;
	}

	public void setMaintainableEntryId(int maintainableEntryId) {
		this.maintainableEntryId = maintainableEntryId;
	}

	public TMaintainableAttribute getTattribute() {
		return tattribute;
	}

	public void setTattribute(TMaintainableAttribute tattribute) {
		this.tattribute = tattribute;
	}

	public int getMaintainableAttributeId() {
		return maintainableAttributeId;
	}

	public void setMaintainableAttributeId(int maintainableAttributeId) {
		this.maintainableAttributeId = maintainableAttributeId;
	}
	public List<TMaintainableEntry> getMateList() {
		return mateList;
	}
	public void setMateList(List<TMaintainableEntry> mateList) {
		this.mateList = mateList;
	}

	public String getOldName() {
		return oldName;
	}
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	public String getNewName() {
		return newName;
	}
	public void setNewName(String newName) {
		this.newName = newName;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
