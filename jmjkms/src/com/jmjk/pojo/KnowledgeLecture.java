package com.jmjk.pojo;

import com.jmjk.entity.TKnowledgeLecture;

public class KnowledgeLecture {

	private TKnowledgeLecture knowledge;
	private String communitygroup;
	private String communityHospital;
	
	public KnowledgeLecture(){
		super();
	}
	public KnowledgeLecture(TKnowledgeLecture knowledge,String communitygroup,String communityHospital){
		super();
		
		this.knowledge = knowledge;
		this.communitygroup = communitygroup;
		this.communityHospital = communityHospital;
	}
	
	public TKnowledgeLecture getKnowledge() {
		return knowledge;
	}
	public void setKnowledge(TKnowledgeLecture knowledge) {
		this.knowledge = knowledge;
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
