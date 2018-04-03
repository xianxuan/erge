package com.jmjk.pojo;

import com.jmjk.entity.TComminityClinic;

public class ComminityClinic {

	private TComminityClinic clinic;
	private String communitygroup;
	private String communityHospital;
	
	public ComminityClinic(){
		super();
	}
	public ComminityClinic(TComminityClinic clinic,String communitygroup,String communityHospital){
		super();
		
		this.clinic = clinic;
		this.communitygroup = communitygroup;
		this.communityHospital = communityHospital;
	}
	
	public TComminityClinic getClinic() {
		return clinic;
	}
	public void setClinic(TComminityClinic clinic) {
		this.clinic = clinic;
	}
	public String getCommunitygroup() {
		return communitygroup;
	}
	public void setCommunitygroup(String communitygroup) {
		this.communitygroup = communitygroup;
	}
	public String getCommunityHospital() {
		return communityHospital;
	}
	public void setCommunityHospital(String communityHospital) {
		this.communityHospital = communityHospital;
	}
	
}
