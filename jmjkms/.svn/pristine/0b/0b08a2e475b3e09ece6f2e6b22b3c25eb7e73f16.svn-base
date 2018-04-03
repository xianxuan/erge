package com.jmjk.iservice;
import java.util.List;

import com.jmjk.entity.*;
import com.jmjk.utils.Page;
/**
 * 康复方案接口
 * @author ykx
 * 2016-08-01
 */
public interface IRecoverySchemeService {
	
	
	
	
	/**
	 * 得到当前社区下的所有康复方案
	 * @param hosId
	 * @return
	 */
	public List<TRecoveryScheme> getAllRecoveryPlanForExport(int hosId);
	
	

	/**
	 * 根据社区Id得到该社区下所有的康复方案
	 * @param HosId（社区Id）
	 * @param page
	 * @return（康复方案实体）
	 */
	public List<TRecoveryScheme> getAllRecoveryScheme(int HosId,int groupId,Page<TRecoveryScheme> page);
	/**
	 * 根据社区Id拿到该社区下所有康复方案的数量
	 * @param HosId（社区Id）
	 * @return（康复方案数量）
	 */ 
	public long getAllRecoverySchemeCount(int HosId,int groupId);
	/**
	 * 通过康复方案id得到某一个康复方案
	 * @param id（康复方案Id）
	 * @return（康复方案实体）
	 */
	public TRecoveryScheme getRecoverySchemeById(int id);
	/**
	 * 通过疾病名称的到康复方案
	 * @param disease
	 * @return
	 */
	
	/**
	 * 根据康复方案名称
	 * 得到康复方案名称
	 * @param name
	 * @return
	 */
	public TRecoveryScheme getRecoveryScheme(String name);
	
	
	/**
	 * 根据疾病名称和方案类型查询康复方案
	 * @param disease
	 * @param type
	 * @return
	 */
	public List<TRecoveryScheme> getRecoverySchemeByNameAndType(int hosId,String disease,String type);
	
	

	/**
	 * 根据疾病名称和方案类型查询推荐康复方案
	 * @param disease
	 * @param type
	 * @return
	 */
	public List<TRecoveryScheme> getTuIjianRecoverySchemeByNameAndType(String disease,
			String type);
	/**
	 * 根据康复方案名称和社区Id得到康复方案实体
	 * @param scheme
	 * @param comHosId
	 * @return
	 */
	public TRecoveryScheme getRecoverySchemeBySchemeName(String scheme,int comHosId);
	/**
	 * 查询康复方案
	 * @param scheme(将查询条件封装到TRecoveryScheme传回来)
	 * @param page(分页)
	 * @return（查询出来的康复方案）
	 */
	public List<TRecoveryScheme> getRecoveryScheme(TRecoveryScheme scheme,int groupId,Page<TRecoveryScheme> page);
	/**
	 * 查询推荐康复方案
	 * @param scheme(将查询条件封装到TRecoveryScheme传回来)
	 * @param page(分页)
	 * @return（查询出来的推荐康复方案）
	 */
	public List<TRecoveryScheme> getExpertRecoveryScheme(TRecoveryScheme scheme,int groupId,Page<TRecoveryScheme> page);
	
	/**
	 * 通过查询条件得到康复方案的数量
	 * @param scheme(将所有的查询条件封装到康复方案实体中)
	 * @return（查询结果的康复方案数量）
	 */
	public long getRecoverySchemeCountBySearch(TRecoveryScheme scheme,int groupId);
	
	
	
	/**
	 * 通过查询条件得到推荐康复方案的数量
	 * @param scheme(将所有的查询条件封装到康复方案实体中)
	 * @return（查询结果的推荐康复方案数量）
	 */
	public long getExpertRecoverySchemeCountBySearch(TRecoveryScheme scheme,int groupId);
	
	/**
	 * 根据当前登陆的集团社区的ID拿到该集团下所有的社区医院康复方案的数量
	 */
	public long  getRecoverySchemeCountByGroupId(int groupId,TRecoveryScheme scheme);
	
	/**
	 * 添加康复方案
	 * @param scheme
	 */
	public void addRecoveryScheme(TRecoveryScheme scheme);
	
	/**
	 * 添加专家康复方案
	 * @param scheme
	 */
	public void addExpertRecoveryScheme(TRecoveryScheme expertscheme);
	
	/**
	 * 根据id删除康复方案
	 * @param id（康复方案的Id）
	 */
	public void deleteRecoverySchemeById(int id);
	
	/**
	 * 根据id删除专家康复方案
	 * @param id（康复方案的Id）
	 */
	public void deleteExpertRecoverySchemeById(int id);
	/**
	 * 根据id批量删除
	 * @param idList（康复方案的Id）
	 */
	public void deleteAnyRecoveryScheme(List<Object> idList);
	/**
	 * 修改康复方案
	 * @param scheme（康复方案的实体）
	 */
	public void updateRecoveryScheme(TRecoveryScheme scheme);

	/**
	 * 修改专家康复方案
	 * @param scheme（康复方案的实体）
	 */
	public void updateExpertRecoveryScheme(TRecoveryScheme expertScheme);
	/**
	 * 检查在当前社区下是否有重名
	 * @param comHosId
	 * @return 返回查询数量
	 */
//	public long checkSchemeName(int comHosId,String schemeName);
	/**
	 *  根据社区id得到康复方案实体
	 * @return
	 */
	public List<TRecoveryScheme> getRecoverySchemesByHosId(int hosId,String disease);
}
