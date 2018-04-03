package com.jmjk.iservice;

import java.util.List;

import com.jmjk.entity.TFileLifeStyle;

/**
 * 健康档案的子表--生活方式表
 * @author 苏东航
 *
 */
public interface IFileLifeStyleService {
	/**
	 *添加生活方式
	 * @param fileLifeStyle
	 */
	public void saveFileLifeStyle(TFileLifeStyle fileLifeStyle);
	/**
	 * 根据健康档案id删除相应的所有生活方式实体
	 * @param hFileid健康档案id
	 */
	public void deleteFileLifeStyle(int hFileid);
	/**
	 * 根据健康档案id得到生活方式
	 * @param hFileId 健康档案id
	 * @return
	 */
	public TFileLifeStyle getFileLifeStyleByhealthID(int hFileId);
	/**
	 * 根据健康档案id得到生活方式list
	 * @param hFileId
	 * @return
	 */
	public List<TFileLifeStyle> getFileLifeStyleListByhealthID(int hFileId);
}
