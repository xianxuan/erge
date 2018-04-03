package com.jmjk.action;

import java.util.List;




import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jmjk.action.base.BaseAction;
import com.jmjk.entity.view.VChronic;
import com.jmjk.entity.view.VOldStaff;
import com.jmjk.service.AllChronicDiseaseService;
import com.jmjk.utils.Page;
import com.opensymphony.xwork2.ActionContext;
@Component
@Scope("prototype")
@Action(value="bloodPressHealthManageAction",results={
		@Result(name="getBloodPressHealthList",location="/jsp/healthManager/bloodPressManageFirst.jsp"),
		
})
/**
 *  健康管理- 血压管理  
 * @author 赖清发&朱德江
 *
 */

public class BloodPressHealthManageAction extends BaseAction{
	private static final long serialVersionUID = 1L;
	private AllChronicDiseaseService chronicDiseaseService;
	private List<VChronic> vcmanagerlist;
	private int cp;
	private String pageHtml;

	
	public String getBloodPressHealthList(){		
			Page<VChronic> page=new Page<VChronic>();
			page.setCurrentPage(cp);
			//2为加入高血压管理
			vcmanagerlist=chronicDiseaseService.getAllDiabeteManager(2, page);
			page.setTotalNum(vcmanagerlist.size());
			setPageHtml(page.getPage("bloodPressHealthManageAction!getBloodPressHealthList.action"));
			return "getBloodPressHealthList";
		}

    



	public AllChronicDiseaseService getChronicDiseaseService() {
	
		return chronicDiseaseService;
	}


	public void setChronicDiseaseService(
			AllChronicDiseaseService chronicDiseaseService) {
		this.chronicDiseaseService = chronicDiseaseService;
	}


	public List<VChronic> getVcmanagerlist() {
		return vcmanagerlist;
	}


	public void setVcmanagerlist(List<VChronic> vcmanagerlist) {
		this.vcmanagerlist = vcmanagerlist;
	}


	public int getCp() {
		return cp;
	}


	public void setCp(int cp) {
		this.cp = cp;
	}


	public String getPageHtml() {
		return pageHtml;
	}


	public void setPageHtml(String pageHtml) {
		this.pageHtml = pageHtml;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
