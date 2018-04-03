package com.jmjk.iservice;

import com.jmjk.entity.THighBloodPressure;
import com.jmjk.entity.THypertensiveFollow;
/**
 * 操作高血压表接口
 * @author 李卓远
 * 15530257686
 */
public interface IHighBloodPressureService {//
	
/*******************高血压档案开始处***************************************/
	/**
     * 添加高血压
     * @param gxy 高血压
     */
    public void saveHighBlood (THighBloodPressure gxy);
    
    /**
     * 删除高血压
     * @param gxy 高血压
     */
    public void deleteHighBlood (THighBloodPressure gxy);
    
    /**
     * 编辑高血压
     * @param gxy 高血压
     */
    public void editHighBlood (THighBloodPressure gxy);
    
    /**
     * 通过慢病总表id得到高血压实体（用于真删和编辑）
     * @param mbid 慢病id
     * @return
     */
    public THighBloodPressure getHighBloodById(int mbid);
    
    
    
/*******************高血压档案开始处***************************************/
    
    
/*******************高血压随访记录开始处***************************************/
    
    /**
     * 添加高血压随访记录
     * @param gxyf 高血压随访记录实体
     * @return 预取高血压随访记录表id
     */
    public int saveHyp_Follow(THypertensiveFollow gxyf);
    
    /**
     * 删除高血压随访记录
     * @param gxyf 高血压随访记录实体
     */
    public void deleteHyp_Follow(THypertensiveFollow gxyf);
    
    /**
     * 编辑高血压随访记录
     * @param gxyf
     */
    public void editHyp_Follow(THypertensiveFollow gxyf);
    
    /**
     * 通过慢性病随访记录总表id得到高血压随访记录
     * @param mbfid 慢性病随访记录总表id
     * @return 高血压随访记录实体
     */
    public THypertensiveFollow getHyp_Follow(int mbfid);
    
    /**
     * 通过高血压随访记录id得到高血压随访记录实体
     * @param hfid 高血压随访记录id
     * @return 高血压随访记录实体
     */
    public THypertensiveFollow getHyp_FollowByHfid(int hfid);
    
}
