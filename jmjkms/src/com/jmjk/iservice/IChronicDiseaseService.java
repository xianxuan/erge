package com.jmjk.iservice;

import com.jmjk.entity.TAuxiliaryExamination;
import com.jmjk.entity.TChronicBronchialDisease;
import com.jmjk.entity.TChronicDisease;
import com.jmjk.entity.TCoronaryDisease;
import com.jmjk.entity.TDiabete;
import com.jmjk.entity.TDisabilityObstacle;
import com.jmjk.entity.TGeneralCondition;
import com.jmjk.entity.THcvd;
import com.jmjk.entity.THighBloodPressure;
import com.jmjk.entity.TInsanityForm;
import com.jmjk.entity.TLifeStyle;
import com.jmjk.entity.TTumour;

/**
 * 老人管理慢病档案-慢病建档
 * @author 李卓远
 * 电话：15530257686
 *
 */
public interface IChronicDiseaseService {
	/**
	 * 保存慢性病总表
	 * @param mb
	 * @return  慢性病总表的ID 为了各种慢性病（如高血压表）set总表ID
	 */
    public int saveTChronicDisease (TChronicDisease mb);
   
    /**
     * 添加高血压
     * @param gxy
     */
    public void saveTHighBlood (THighBloodPressure gxy);
    
    /**
     * 添加糖尿病
     * @param tnb
     */
    public void  saveTDiabete (TDiabete tnb);
    
    /**
     * 添加重性精神疾病
     * @param jsb
     */
    public void saveTInsanityForm (TInsanityForm jsb);
    
    /**
     * 添加冠心病
     * @param gxb
     */
    public void saveTCornaryDisease (TCoronaryDisease gxb);
    
    /**
     * 保存心脑血管病
     * @param xn
     */
    public void saveTHcvd (THcvd xn);
    
    /**
     * 添加肿瘤
     * @param zl
     */
    public void saveTTumour (TTumour zl);
    
    /**
     * 添加慢性支气管病
     * @param mxqg
     */
    public void saveTCh_Br_Di (TChronicBronchialDisease mxqg);
    
    /**
     * 添加残疾障碍
     * @param cj
     */
    public void saveTDi_Ob (TDisabilityObstacle cj);
    
    /**
     * 添加一般状况表实体表并返回这个实体的id
     * @param zk
     * @return generalConditionId
     */
    public int saveTGen_Con (TGeneralCondition zk);
    
    /**
     * 添加生活方式表实体并返回此表ID
     * @param sh
     * @return 生活方式表id
     */
    public int saveTLifeStyle (TLifeStyle sh);
    
    /**
     * 添加辅助检查表实体并返回此表ID
     * @param fz
     * @return 辅助检查表Id
     */
    public int saveTAuxi_Exam (TAuxiliaryExamination fz);
    
    /**
	 * 删除慢性病总表
	 * @param mb
	 */
    public void deleteTChronicDisease (TChronicDisease mb);
   
    /**
     * 删除高血压
     * @param gxy
     */
    public void deleteTHighBlood (THighBloodPressure gxy);
    
    /**
     * 删除糖尿病
     * @param tnb
     */
    public void  deleteTDiabete (TDiabete tnb);
    
    /**
     * 删除重性精神疾病
     * @param jsb
     */
    public void deleteTInsanityForm (TInsanityForm jsb);
    
    /**
     * 删除冠心病
     * @param gxb
     */
    public void deleteTCornaryDisease (TCoronaryDisease gxb);
    
    /**
     * 删除心脑血管病
     * @param xn
     */
    public void deleteTHcvd (THcvd xn);
    
    /**
     * 删除肿瘤
     * @param zl
     */
    public void deleteTTumour (TTumour zl);
    
    /**
     * 删除慢性支气管病
     * @param mxqg
     */
    public void deleteTCh_Br_Di (TChronicBronchialDisease mxqg);
    
    /**
     * 删除残疾障碍
     * @param cj
     */
    public void deleteTDi_Ob (TDisabilityObstacle cj);
    
    /**
     * 删除一般状况表
     * @param zk
     */
    public void deleteTGen_Con (TGeneralCondition zk);
    
    /**
     * 删除生活方式表
     * @param sh
     * @return lifeId
     */
    public void deleteTLifeStyle (TLifeStyle sh);
    
    /**
     * 删除辅助检查表
     * @param fz
     */
    public void deleteTAuxi_Exam (TAuxiliaryExamination fz);
    
    /**
	 * 编辑慢性病总表
	 * @param mb
	 */
    public void editTChronicDisease (TChronicDisease mb);
   
    /**
     * 编辑高血压
     * @param gxy
     */
    public void editTHighBlood (THighBloodPressure gxy);
    
    /**
     * 编辑糖尿病
     * @param tnb
     */
    public void  editTDiabete (TDiabete tnb);
    
    /**
     * 编辑重性精神疾病
     * @param jsb
     */
    public void editTInsanityForm (TInsanityForm jsb);
    
    /**
     * 编辑冠心病
     * @param gxb
     */
    public void editTCornaryDisease (TCoronaryDisease gxb);
    
    /**
     * 编辑心脑血管病
     * @param xn
     */
    public void editTHcvd (THcvd xn);
    
    /**
     * 编辑肿瘤
     * @param zl
     */
    public void editTTumour (TTumour zl);
    
    /**
     * 编辑慢性支气管病
     * @param mxqg
     */
    public void editTCh_Br_Di (TChronicBronchialDisease mxqg);
    
    /**
     * 编辑残疾障碍
     * @param cj
     */
    public void editTDi_Ob (TDisabilityObstacle cj);
    
    /**
     * 编辑一般状况表实体表并
     * @param zk
     */
    public void editTGen_Con (TGeneralCondition zk);
    
    /**
     * 编辑生活方式表
     * @param sh
     * @return lifeId
     */
    public void editTLifeStyle (TLifeStyle sh);
    
    /**
     * 编辑辅助检查表
     * @param fz
     */
    public void editTAuxi_Exam (TAuxiliaryExamination fz);
    
    /*还差查找  回显*/
    
    
    
}
