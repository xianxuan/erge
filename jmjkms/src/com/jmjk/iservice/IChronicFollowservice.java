package com.jmjk.iservice;

import java.util.List;

import com.jmjk.entity.TChronicFollow;

/**
 * 慢病管理-慢病建档-慢病随访记录总表接口
 * @author 李卓远
 * 15530257686
 */

public interface IChronicFollowservice {//
	/**
	 * 添加慢性病随访总表实体
	 * @param mbsf 慢性表随访记录实体
	 * @return 预取慢性病随访记录总表id
	 */
	public int saveTChronicFollow (TChronicFollow mbsf);
	
    /**
     * 删除慢性病随访总表实体
     * @param mbsf 慢性表随访记录实体
     */
    public void deleteTChronicFollow(TChronicFollow mbsf);
	
	/**
	 * 编辑慢性病随访总表实体
	 * @param mbsf 慢性表随访记录实体
	 */
	public void editTChronicFollow(TChronicFollow mbsf);
	
	/**
	 * 通过慢病随访总表id得到慢性病随访总表的一个实体
	 * @param mbsfid 慢性病随访记录总表id
	 * @return 慢性表随访记录总表的一个实体
	 */
	public TChronicFollow getChronicFollowByMbsfId(int mbsfid);
	
	/**
	 * 通过慢病总表id得到相应的慢性病随访记录的实体集合
	 * @param mbid 慢性病总表id
	 * @return 慢性表随访记录总表的一个实体集合
	 */
	public List<TChronicFollow> getChronicFollowByMbId(int mbid);
	


	

	
}
