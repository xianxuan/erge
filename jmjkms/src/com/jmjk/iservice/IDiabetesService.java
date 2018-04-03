package com.jmjk.iservice;

import com.jmjk.entity.TDiabete;
import com.jmjk.entity.TDiabetsFollow;
/**
 * 操作糖尿病表接口
 * @author 李卓远
 *15530257686
 */
public interface IDiabetesService {//

/*********************糖尿病档案开始处******************************************/
	
	/**
     * 添加糖尿病
     * @param tnb 糖尿病
     */
    public void  saveDiabete (TDiabete tnb);
    
    /**
     * 删除糖尿病
     * @param tnb 糖尿病
     */
    public void  deleteDiabete (TDiabete tnb);
    
    /**
     * 编辑糖尿病
     * @param tnb 糖尿病
     */
    public void  editDiabete (TDiabete tnb);
    
    /**
     * 通过慢病总表id得到糖尿病实体（用于真删）
     * @param mbid 慢病id
     * @return 糖尿病实体
     */
    public TDiabete getDiabeteById(int mbid);
    
    
    
/*********************糖尿病档案结束处******************************************/
    
/*********************糖尿病随访记录开始处****************************************/
    
    /**
     * 添加糖尿病随访记录
     * @param tnbf 糖尿病随访记录实体
     * @return 预取的糖尿病随访记录表id
     */
    public int saveDiabetsFollow(TDiabetsFollow tnbf);
    
    /**
     * 删除糖尿病随访记录
     * @param tnbf 糖尿病随访记录实体
     */
    public void deleteDiabetsFollow(TDiabetsFollow tnbf);
    
    /**
     * 编辑糖尿病随访记录
     * @param tnbf 糖尿病随访记录实体
     */
    public void editDiabetsFollow(TDiabetsFollow tnbf);
    
    /**
     * 通过慢病随访记录总表id得到糖尿病随访记录实体
     * @param mbfid 慢病随访总表id
     * @return 糖尿病随访记录实体
     */
    public TDiabetsFollow getDiabetsFollow(int mbfid);
    
    /**
     * 通过糖尿病随访id得到糖尿病随访实体
     * @param tfid 糖尿病随访记录id
     * @return 糖尿病随访实体
     */
    public TDiabetsFollow getDiabetsFollowByTfId(int tfid);
/*********************糖尿病随访记录结束处****************************************/
    
}
