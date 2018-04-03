package com.jmjk.pojo;

import com.jmjk.entity.THealthEdu;

public class HealtEducation{

	private THealthEdu health;
	private String communitygroup;
	private String communityHospital;
	
	
	
	public HealtEducation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public HealtEducation(THealthEdu health, String communitygroup, String communityHospital) {
		super();
		this.health = health;
		this.communitygroup = communitygroup;
		this.communityHospital = communityHospital;
	}

	public THealthEdu getHealth() {
		return health;
	}

	public void setHealth(THealthEdu health) {
		this.health = health;
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

	/*@Override
	public String toString() {
		return "HealtEducation [tHealthEdu=" + tHealthEdu + ", communitygroup="
				+ communitygroup + ", communityHospital=" + communityHospital
				+ "]";
	}*/
    
	
}
