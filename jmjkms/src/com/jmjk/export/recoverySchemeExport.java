package com.jmjk.export;

import com.jmjk.entity.TRecoveryScheme;

public class recoverySchemeExport {
	 //康复方案名称
     public String schemeName;
     //康复方案简介
     public String recoveryPaln;
     //制定人
     public String name;
     //方案类型
     public String type;
     //日期
     public String constituteTime;
     public String[] getTitles(){
 		String [] titles = {//5g
 			"康复方案名称","康复方案简介","制定人","方案类型","日期"
 		};
 		return titles;
 	}
     public recoverySchemeExport (){}
     public recoverySchemeExport(TRecoveryScheme trecoveryScheme) {
    	 super();
    	 if(trecoveryScheme.getSchemeName() == null){
    		 this.schemeName = "";
    	 }else{
    		 this.schemeName=trecoveryScheme.getSchemeName();
    	 }
    	 if(trecoveryScheme.getRecoveryPaln() == null ){
    		 this.recoveryPaln = "";
    	 }else{
    	     this.recoveryPaln=trecoveryScheme.getRecoveryPaln();}
    	 if(trecoveryScheme.getTStaff() == null&&!trecoveryScheme.getType().equals("专家方案")){
    		 this.name = "";
    	 }else{
    		 if(trecoveryScheme.getType().equals("专家方案")&&trecoveryScheme.getNote()!=null)
    		 {
    			 this.name=trecoveryScheme.getNote();
    		 }
    		 else if(trecoveryScheme.getType().equals("专家方案")&&trecoveryScheme.getNote()==null)
    		 {
    			 this.name="";
    		 }
    		 else{
    			 this.name=trecoveryScheme.getTStaff().getName();
    		 }
    	 }
    	 if(trecoveryScheme.getType() == null){
    		 this.type = "";
    	 }else{
    		 this.type=trecoveryScheme.getType();
    	 }
    	 if(trecoveryScheme.getConstituteTime() == null){
    		 this.constituteTime="";
    	 }else{
    		 this.constituteTime=trecoveryScheme.getConstituteTime().toString();
    	 }
     }
     
     
     
     
public String getSchemeName() {
		return schemeName;
	}

	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}

	public String getRecoveryPaln() {
		return recoveryPaln;
	}

	public void setRecoveryPaln(String recoveryPaln) {
		this.recoveryPaln = recoveryPaln;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getConstituteTime() {
		return constituteTime;
	}

	public void setConstituteTime(String constituteTime) {
		this.constituteTime = constituteTime;
	}

}