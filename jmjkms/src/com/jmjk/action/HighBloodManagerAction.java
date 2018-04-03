package com.jmjk.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jmjk.action.base.BaseAction;
import com.jmjk.entity.view.VChronic;
import com.jmjk.service.AllChronicDiseaseService;
import com.jmjk.utils.Page;

@Component
@Scope("prototype")
@Action(value="highBloodManagerAction",results={
		@Result(name="getAllHighManager",location="/jsp/ChronicManager/DiabeteManager/diabeteManager.jsp"),
		//@Result(name="edit",location="doctorDiagnosisAction!searchDoctorDiagnosis.action"),
		//@Result(name="addDoctorDiagnosis",type="redirectAction",location="doctorDiagnosisAction!doctorDiagnosis.action"),
})
public class HighBloodManagerAction extends BaseAction{

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private AllChronicDiseaseService chronicDiseaseService;
	
	private List<VChronic> vcmanagerlist;
	private String pageHtml;

	private int cp=1;                            //当前页
	
	/////
	public String getAllHighManager(){
		Page<VChronic> page=new Page<VChronic>();
		page.setCurrentPage(cp);
		//2为加入高血压管理
		vcmanagerlist=chronicDiseaseService.getAllDiabeteManager(2, page);
		page.setTotalNum(vcmanagerlist.size());
		setPageHtml(page.getPage("highBloodManagerAction!getAllHighManager.action"));
		return "getAllHighManager";
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
}
