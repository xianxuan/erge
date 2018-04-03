package com.jmjk.pojo;

import com.jmjk.entity.TEquipmentManage;

public class EquipmentManage {

	private TEquipmentManage equipment;
	private String communitygroup;
	private String communityHospital;
	
	public EquipmentManage(){
		super();
	}
	public EquipmentManage(TEquipmentManage equipment,String communitygroup,String communityHospital){
		super();
		
		this.equipment = equipment;
		this.communitygroup = communitygroup;
		this.communityHospital = communityHospital;
	}
	
	public TEquipmentManage getEquipment() {
		return equipment;
	}
	public void setEquipment(TEquipmentManage equipment) {
		this.equipment = equipment;
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
