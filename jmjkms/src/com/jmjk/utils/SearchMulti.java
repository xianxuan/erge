package com.jmjk.utils;

import com.jmjk.entity.SearchClass;
import com.jmjk.enums.AddPhysicalExamSearch;
import com.jmjk.enums.ESex_State;
import com.jmjk.enums.HEALTH_FILE_TYPE;
import com.jmjk.enums.HealthFileCheck;
import com.jmjk.enums.SEX_INT;


/**
 * 多条件搜索
 * @author zfl
 */
public class SearchMulti {
	private static String multiHql=null;
	
	
	public static String Multi(SearchClass sc){
	if(sc==null){
			return "";
		}
	multiHql="from VExam ve where 1=1";
	
	if(sc.getSqId()!=0){
		multiHql+=" and ve.communityHospitalId="+sc.getSqId();
	}
	
	//根据搜索条件拼入搜索参数
	if(sc.getConditionsNum()!=null && sc.getConditionsNum().trim().length()!=0){ //搜索条件有参数时	
		
		if(sc.getConditions()==AddPhysicalExamSearch.healthFileId.getvalue()){ //当搜索条件是 档案编号时 (0)
			multiHql+=" and ve.fileNum like '%"+sc.getConditionsNum()+"%' ";   //档案编号拼入 搜索条件
		}
		if(sc.getConditions()==AddPhysicalExamSearch.idNum.getvalue()){
			multiHql+=" and ve.idNum like'%"+sc.getConditionsNum()+"%' "; //身份证号拼入搜索条件
		}
		if(sc.getConditions()==AddPhysicalExamSearch.name.getvalue()){
			multiHql+=" and ve.fileName like'%"+sc.getConditionsNum()+"%'"; //名字拼入搜索条件
		}
		
	}
	/*	
	if(sc.getAgeStart()!=0){ 	//判断年龄 起始 搜索条件是否存在
		multiHql+=" and　(ve.age >= '"+sc.getAgeStart()+"' ";
				if(sc.getAgeEnd()!=0 || sc.getAgeEnd()!=(Integer)null){ //年龄设置终止
					multiHql+=" and ve.age <= '"+sc.getAgeEnd()+"')";
				}else{  //年龄没有设置终止
					multiHql+=")";
					}
	}
	*/
	if(sc.getBirthDateStart()!=null && sc.getBirthDateStart().trim().length()!=0){ //生日这个搜索条件存在
		multiHql+=" and (ve.birthDate >= '"+sc.getBirthDateStart()+"' ";
				if(sc.getBirthDateEnd()!=null && sc.getBirthDateEnd().trim().length()!=0){ //生日有终止
					multiHql+=" and ve.birthDate <= '"+sc.getBirthDateEnd()+"')";
				}else{//生日没有设置终止
					multiHql+=")";
				}
		}else{ //生日没有开始  的时候
			if(sc.getBirthDateEnd()!=null && sc.getBirthDateEnd().trim().length()!=0){
				multiHql+=" and (ve.birthDate <= '"+sc.getBirthDateEnd()+"')";
			}
			
		}

	if(sc.getCreatedDateStart()!=null && sc.getCreatedDateStart().trim().length()!=0){ //建档日期这个搜索条件存在
		multiHql+=" and (ve.fileDate>= '"+sc.getCreatedDateStart()+"'";
				if(sc.getCreatedDateEnd()!=null && sc.getCreatedDateEnd().trim().length()!=0){//建档有终止
					multiHql+=" and ve.fileDate <= '"+sc.getCreatedDateEnd()+"')";
				}else{//建档日期没有设置终止
					multiHql+=")";
				}
		}else{
			if(sc.getCreatedDateEnd()!=null && sc.getCreatedDateEnd().trim().length()!=0){
				multiHql+=" and (ve.fileDate<= '"+sc.getCreatedDateEnd()+"')";
			}
		}
	
	if(sc.getResponsibility()!=null && sc.getResponsibility()!=0){//拼责任医生  使用ID 进行精确搜索
		multiHql+=" and ve.staffId="+sc.getResponsibility();
	}
	
	if(sc.getFilePerson()!=null && sc.getFilePerson().trim().length()!=0){//拼建档人  不使用模糊搜索
		multiHql+=" and ve.filePerson like '"+sc.getFilePerson()+"'";
	}
	
	if(sc.getPhysicalExamDateStart()!=null && sc.getPhysicalExamDateStart().trim().length()!=0){ //拼体检时间
		multiHql+=" and (ve.physicalExamDate >='"+sc.getPhysicalExamDateStart()+"'";
				if(sc.getPhysicalExamDateEnd()!=null && sc.getPhysicalExamDateEnd().trim().length()!=0){//体检结束时间
					multiHql+=" and ve.physicalExamDate <= '"+sc.getPhysicalExamDateEnd()+"')";
				}else{
					multiHql+=")";
				}
		}else{ //体检没有开始时间 的时候  判断是否有结束时间
			if(sc.getPhysicalExamDateEnd()!=null && sc.getPhysicalExamDateEnd().trim().length()!=0){
				multiHql+=" and(ve.physicalExamDate <= '"+sc.getPhysicalExamDateEnd()+"')";
			}
		}
	
	if(sc.getOperator()!=null && sc.getOperator().trim().length()!=0){ //拼体检录入员 不使用模糊搜索
		multiHql+=" and ve.operator like '"+sc.getOperator()+"'";
	}
	
	if(sc.getSex()==SEX_INT.ALL.getvalue()){
	
	}
	if(sc.getSex()==SEX_INT.MAN.getvalue()){
		multiHql+=" and ve.sex=1";
	}
	if(sc.getSex()==SEX_INT.WOMAN.getvalue()){
		multiHql+=" and ve.sex=0";
	}
	
	
	if(sc.getHealthFileType()==HEALTH_FILE_TYPE.siwang.getValue()){
		multiHql+=" and ve.healthFileType=1";
	}
	if(sc.getHealthFileType()==HEALTH_FILE_TYPE.zhuxiao.getValue()){
		multiHql+=" and ve.healthFileType=0";
	}
	if(sc.getHealthFileType()==HEALTH_FILE_TYPE.zhengchang.getValue()){
		multiHql+=" and ve.healthFileType=2";
	}

	
	
		
	
	return multiHql;	
	}


	
	
}
