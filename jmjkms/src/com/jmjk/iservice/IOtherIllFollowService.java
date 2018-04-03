package com.jmjk.iservice;

import com.jmjk.entity.TRegistrationOtherDiseases;
/**
 * 其他疾病随访记录表接口
 * @author 李卓远
 * 
 */
public interface IOtherIllFollowService {//
 
	/**
     * 添加其他病随访记录
     * @param qtf 其他病随访记录实体
     * @return 预取其他疾病随访记录表id
     */
    public int saveOtherIllFollow(TRegistrationOtherDiseases qtf);
    
    /**
     * 删除其他病随访记录
     * @param qtf 其他病随访记录实体
     */
    public void deleteOtherIllFollow(TRegistrationOtherDiseases qtf);
    
    /**
     * 编辑其他病随访记录
     * @param qtf 其他病随访记录实体
     */
    public void editOtherIllFollow(TRegistrationOtherDiseases qtf);
    
    /**
     * 通过慢性病随访总表id得到其他病随访记录
     * @param mbfid 慢性病随访记录总表id
     * @return 其他病随访记录实体
     */
    public TRegistrationOtherDiseases getOtherIllFollowByMbfid(int mbfid);
    
    /**
     * 通过其他疾病随访记录id得到其他疾病随访记录实体（肿瘤、慢性支气管、残疾障碍随访记录）
     * @param qtfid 其他疾病随访记录id
     * @return 其他疾病随访记录实体
     */
    public TRegistrationOtherDiseases getOtherIllFollowByQtid(int qtfid);
    
    
}
