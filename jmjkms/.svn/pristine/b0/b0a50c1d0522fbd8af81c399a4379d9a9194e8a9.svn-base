package com.jmjk.iservice;

import com.jmjk.entity.TCoronaryDisease;
import com.jmjk.entity.TCoronaryHeartDisease;
/**
 * 操作冠心病表接口
 * @author 李卓远
 * 15530257686
 */
public interface ICoronaryHeartService {//

/************************冠心病档案开始处**************************************/
	/**
     * 添加冠心病
     * @param gxb 冠心病
     */
    public void saveCornaryDisease (TCoronaryDisease gxb);
    
    /**
     * 删除冠心病
     * @param gxb 冠心病
     */
    public void deleteCornaryDisease (TCoronaryDisease gxb);
    
    /**
     * 编辑冠心病
     * @param gxb 冠心病
     */
    public void editCornaryDisease (TCoronaryDisease gxb);
    
    /**
     * 通过慢病总表id拿到冠心病实体（用于真删）
     * @param mbid 慢病总表id
     * @return 冠心病实体
     */
    public TCoronaryDisease getCornaryDiseaseById(int mbid);
    
    
    
    
/************************冠心病档案开始处**************************************/
    
    
/************************冠心病随访记录开始处**************************************/
    
    /**
     * 添加冠心病随访记录
     * @param gxbf 冠心病随访记录实体
     * @return 预取冠心病随访记录表id
     */
    public int saveCoronaryHeartFollow(TCoronaryHeartDisease gxbf);
    
    /**
     * 删除冠心病随访记录
     * @param gxbf 冠心病随访记录实体
     */
    public void deleteCoronaryHeartFollow(TCoronaryHeartDisease gxbf);
    
    /**
     * 编辑冠心病随访记录
     * @param gxbf 冠心病随访记录实体
     */
    public void editCoronaryHeartFollow(TCoronaryHeartDisease gxbf);
    
    /**
     * 通过慢病随访总表id得到冠心病随访记录实体
     * @param mbfid 慢性病随访记录总表id
     * @return 冠心病随访记录实体
     */
    public TCoronaryHeartDisease getCoronaryHeartFollowByMbfId(int mbfid);

    /**
     * 通过冠心病随访记录id得到冠心病随访实体
     * @param gxid 冠心病随访记录id
     * @return 冠心病随访实体
     */
    public TCoronaryHeartDisease getCoronaryHeartFollowByGxfId(int gxid);
    
   
/************************冠心病随访记录结束处**************************************/   
}
