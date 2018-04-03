package com.jmjk.export;

import com.jmjk.entity.TEquipmentManage;

/**
 * 设备管理
 * @author houzichang
 *
 */
public class EquipmentManageExport {

	// 设备编号
	public String equipNumber;
	// 设备名称
	public String equipName;
	// 设备型号
	public String equipModel;
	// 设备采购人
	public String equipPeople;
	// 采购时间
	public String selectTime;
	// 负责人
	public String TStaff;
	// 联系方式
	public String contact;
	
	public String[] getTitles(){
		String[] titles = {"设备编号","设备名称","设备型号","设备采购人","采购时间","负责人","联系方式"};
		return titles;}
	public EquipmentManageExport(){}
	public EquipmentManageExport(TEquipmentManage equipmentManage){
		super();
		this.equipNumber = equipmentManage.getEquipNumber();
		this.equipName = equipmentManage.getEquipName();
		this.equipModel = equipmentManage.getEquipModel();
		this.equipPeople = equipmentManage.getEquipPeople();
		if (equipmentManage.getSelectTime() != null) {
			this.selectTime  = equipmentManage.getSelectTime().toString();
		}
		
		this.TStaff = equipmentManage.getTStaff().getName();
		this.contact = equipmentManage.getContact();
	}
	
	/*********get set************/
	public String getEquipNumber() {
		return equipNumber;
	}
	public void setEquipNumber(String equipNumber) {
		this.equipNumber = equipNumber;
	}
	public String getEquipName() {
		return equipName;
	}
	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}
	public String getEquipModel() {
		return equipModel;
	}
	public void setEquipModel(String equipModel) {
		this.equipModel = equipModel;
	}
	public String getEquipPeople() {
		return equipPeople;
	}
	public void setEquipPeople(String equipPeople) {
		this.equipPeople = equipPeople;
	}
	public String getSelectTime() {
		return selectTime;
	}
	public void setSelectTime(String selectTime) {
		this.selectTime = selectTime;
	}
	public String getTStaff() {
		return TStaff;
	}
	public void setTStaff(String tStaff) {
		TStaff = tStaff;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	
}
