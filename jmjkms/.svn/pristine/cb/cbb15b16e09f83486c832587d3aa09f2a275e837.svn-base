package com.jmjk.iservice;

import java.util.List;

import com.jmjk.entity.TMedicalPayMethod;
/**
 * 
 * @author 苏东航
 *
 */
public interface IMedicalPayMethod {
	/**
	 * 添加全部付费方式
	 * @param mpm  付费方式实体
	 */
	public void saveMedicalPayMethod(List<TMedicalPayMethod> mpm);
	/**
	 * 根据健康档案Id删除全部付费方式
	 * @param hFileid 健康档案Id
	 */
	public void dedleteMedicalPayMethod(int hFileid);
	
	/**
	 * 根据健康档案Id得到付费方式
	 * @param hFileId  健康档案Id
	 * @return
	 */
	public List<TMedicalPayMethod> getMedicalPayMethodByHFileId(int hFileId);
}
