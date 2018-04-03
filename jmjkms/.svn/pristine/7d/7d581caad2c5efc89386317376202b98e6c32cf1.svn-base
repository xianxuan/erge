package com.jmjk.iservice;

import com.jmjk.entity.TAuxiliaryExamination;
import com.jmjk.entity.TGeneralCondition;
import com.jmjk.entity.TLifeStyle;
/**
 * 操作一般状况表、生活方式表、辅助检查表接口
 * @author 李卓远
 * 15530257686
 */
public interface IStatusAndLifeAndAssistService {//

	/**
     * 添加一般状况表实体
     * @param zk 一般状况
     * @return 预取的一般状况表id
     */
    public int saveGen_Con (TGeneralCondition zk);
    
    /**
     * 添加生活方式实体
     * @param sh 生活方式
     * @return 预取的生活方式表id
     */
    public int saveLifeStyle (TLifeStyle sh);
    
    /**
     * 添加辅助检查表实体
     * @param fz 辅助检查
     * @return 预取的辅助检查表id
     */
    public int saveAuxi_Exam (TAuxiliaryExamination fz);
    
    /**
     * 删除一般状况表
     * @param zk 一般状况
     */
    public void deleteGen_Con (TGeneralCondition zk);
    
    /**
     * 删除生活方式表
     * @param sh 生活方式
     */
    public void deleteLifeStyle (TLifeStyle sh);
    
    /**
     * 删除辅助检查表
     * @param fz  辅助检查
     */
    public void deleteAuxi_Exam (TAuxiliaryExamination fz);
    
    /**
     * 编辑一般状况表实体表并
     * @param zk 一般状况
     */
    public void editGen_Con (TGeneralCondition zk);
    
    /**
     * 编辑生活方式表
     * @param sh 生活方式
     */
    public void editLifeStyle (TLifeStyle sh);
    
    /**
     * 编辑辅助检查表
     * @param fz 辅助检查
     */
    public void editAuxi_Exam (TAuxiliaryExamination fz);
    
    /**
     * 通过一般状况表id得到一般状况实体
     * @param zkid 一般状况id
     * @return 一般状况实体
     */
    public TGeneralCondition getGen_ConByZkId(int zkid);
    
    /**
     * 通过生活方式表id得到生活方式表实体
     * @param lfid 生活方式id
     * @return 生活方式表实体
     */
    public TLifeStyle getLifeStyleByLifeId(int lfid);
    
    /**
     * 通过辅助检查表id得到辅助检查表实体
     * @param fzid 辅助检查表id
     * @return 辅助检查表实体
     */
    public TAuxiliaryExamination getAuxi_ExamByFzId(int fzid);
    
}
