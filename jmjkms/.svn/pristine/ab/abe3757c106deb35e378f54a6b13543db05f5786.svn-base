package com.jmjk.iservice;

import com.jmjk.entity.TFollowUpCardiovascular;
import com.jmjk.entity.THcvd;
/**
 * 操作心脑血管病接口
 * @author 李卓远
 * 15530257686
 */
public interface IHeartAndCerebralService {//

/***************心脑血管档案开始处***********************/
	/**
     * 保存心脑血管病
     * @param xn 心脑血管病
     */
    public void saveHcvd (THcvd xn);
    
    /**
     * 删除心脑血管病
     * @param xn 心脑血管病
     */
    public void deleteHcvd (THcvd xn);
    
    /**
     * 编辑心脑血管病
     * @param xn 心脑血管病
     */
    public void editHcvd (THcvd xn);
    
    /**
     * 通过慢病总表id得到心脑血管病实体（用于真删）
     * @param mbid 慢病id
     * @return 心脑血管病实体
     */
    public THcvd getHcvdById(int mbid);
    
    
    
/***************心脑血管档案结束处***********************/  
    
    
/***************心脑血管随访记录开始处***********************/
    
    /**
     * 添加心脑血管随访记录
     * @param xnf 心脑血管随访记录表实体
     * @return 心脑血管病随访记录表id
     */
    public int saveFollowUp_Cardio(TFollowUpCardiovascular xnf);
    
    /**
     * 删除心脑血管随访记录
     * @param xnf 心脑血管随访记录表实体
     */
    public void deleteFollowUp_Cardio(TFollowUpCardiovascular xnf);
    
    /**
     * 编辑心脑血管随访记录
     * @param xnf 心脑血管随访记录表实体
     */
    public void editFollowUp_Cardio(TFollowUpCardiovascular xnf);
    
    /**
     * 通过慢病随访记录总表id得到心脑血管随访记录实体
     * @param mbfid 慢性病随访记录总表id
     * @return 心脑血管随访记录实体
     */
    public TFollowUpCardiovascular getFollowUp_Cardio(int mbfid);
    
    /**
     * 通过心脑血管随访记录id得到心脑血管随访记录实体
     * @param xnfid 心脑血管随访记录id
     * @return 心脑血管随访记录实体
     */
    public TFollowUpCardiovascular getFoUpByFid(int xnfid);
/***************心脑血管随访记录开始处***********************/
    
    
    
}
