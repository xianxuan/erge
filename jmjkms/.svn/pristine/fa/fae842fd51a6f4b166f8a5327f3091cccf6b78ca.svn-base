package com.jmjk.iservice;

import java.util.List;

import com.jmjk.entity.TPastHistory;

/**
 * 
 * @author 苏东航
 *
 */
public interface IPastHistoryService {
	/**
	 * 添加既往史
	 * @param pasthistory  既往史实体
	 */
	public void savePastHistory(TPastHistory pasthistory);
	/**
	 * 根据健康档案Id删除所有既往史
	 * @param hFileid 健康档案Id
	 */
	public void deletePastHistory(int hFileid);
	
	/**
	 * 根据健康档案Id还有既往史类型得到既往史
	 * @param hFileId健康档案Id，name既往史类型
	 * @return健康档案
	 */
	public List<TPastHistory> getPastHistory(int hFileId ,String name);
	/**
	 * 根据健康档案Id得到既往史
	 * @param hFileId健康档案Id
	 * @return健康档案
	 */
	public List<TPastHistory> getPastHistory(int hFileId );
}
