package com.jmjk.iservice;

import com.jmjk.entity.TChronicBronchialDisease;
import com.jmjk.entity.TRegistrationOtherDiseases;
/**
 * 操作慢性支气管病接口
 * 慢性支气管病随访记录的接口在IOtherIllFollowService下
 * @author 李卓远
 * 15530257686
 */
public interface IChronicBronchialService {//

	/**
     * 添加慢性支气管病
     * @param mxqg 慢性支气管病
     */
    public void saveCh_Br_Di (TChronicBronchialDisease mxqg);
    
    /**
     * 删除慢性支气管病
     * @param mxqg 慢性不支气管病
     */
    public void deleteCh_Br_Di (TChronicBronchialDisease mxqg);
    
    /**
     * 编辑慢性支气管病
     * @param mxqg  慢性支气管病
     */
    public void editCh_Br_Di (TChronicBronchialDisease mxqg);
    
    /**
     * 通过慢病总表id拿到慢性支气管病实体（用于真删）
     * @param mbid 慢病总表id
     * @return 慢性支气管病实体
     */
    public TChronicBronchialDisease getCh_Br_DiById (int mbid);
    
    
    
   
    
}
