package com.jmjk.iservice;

import com.jmjk.entity.TInsanityForm;
import com.jmjk.entity.TMentalFollow;
/**
 * 操作重性精神疾病表接口
 * @author 李卓远
 * 15530257686
 */
public interface IPsychosisService {//
	
/******************重性精神疾病档案开始处*******************************/
	
	
	/**
     * 添加重性精神疾病
     * @param jsb 重性精神疾病
     */
    public void saveInsanityForm (TInsanityForm jsb);
    
    /**
     * 删除重性精神疾病
     * @param jsb 重性精神疾病
     */
    public void deleteInsanityForm (TInsanityForm jsb);
	
	/**
     * 编辑重性精神疾病
     * @param jsb 重性精神疾病
     */
    public void editInsanityForm (TInsanityForm jsb);
    
    /**
     * 通过慢病总表id拿到重性精神疾病实体
     * @param mbid 慢病总表id
     * @return 重性精神疾病实体
     */
    public TInsanityForm getInsanityForm(int mbid);
    
    
/******************重性精神疾病档案结束处*******************************/
    
    
/******************重性精神疾病随访记录开始处*******************************/
    
    /**
     * 添加重性精神疾病随访记录
     * @param jsbf 重性精神疾病随访记录实体
     * @return 预取重性精神疾病随访记录表id
     */
    public int saveMentalFollow(TMentalFollow jsbf);
    
    /**
     * 删除重性精神疾病随访记录
     * @param jsbf 重性精神疾病实体
     */
    public void deleteMentalFollow(TMentalFollow jsbf);
    
    /**
     * 编辑重性精神疾病随访记录
     * @param jsbf 重性精神疾病实体
     */
    public void editMentalFollow(TMentalFollow jsbf);
    
    /**
     * 通过慢病随访记录总表记录得到重性精神疾病实体
     * @param mbfid 慢病随访记录总表id
     * @return 重性精神疾病实体
     */
    public TMentalFollow getMentalFollow(int mbfid);
    
    /**
     * 通过重性精神疾病随访记录id得到重性精神疾病随访实体
     * @param jfid 重性精神疾病随访记录id
     * @return 重性精神疾病随访实体
     */
    public TMentalFollow getMentalFollowByJfId(int jfid);
    
    
/******************重性精神疾病随访记录结束处*******************************/
    
}
