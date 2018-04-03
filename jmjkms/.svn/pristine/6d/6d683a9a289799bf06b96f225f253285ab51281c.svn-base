package com.jmjk.iservice;

import com.jmjk.entity.TLifestyleGuide;
import com.jmjk.entity.TSign;
/**
 * 操作生活方式指导表接口
 * @author 李卓远
 * 15530257686
 */
public interface ILifeAndSignService {//
	
/***********生活方式指导表接口开始处************************************************/

	/**
	 * 添加生活方式指导表实体且返回自增的id
	 * @param lg 生活方式指导表实体
	 * @return 生活方式指导表主键下一个id
	 */
	public int saveLifeGuide(TLifestyleGuide lg);
	
	/**
	 * 删除生活方式指导表实体
	 * @param lg 生活方式指导表实体
	 */
	public void deleteLifeGuide(TLifestyleGuide lg);
	
	/**
	 * 编辑生活方式指导内容
	 * @param lg 生活方式指导表实体
	 */
	public void editLifeGuide(TLifestyleGuide lg);
	
	/**
	 * 通过生活方式指导表的id拿到生活方式指导表的实体
	 * @param lgid 生活方式指导表id
	 * @return 生活方式指导表实体
	 */
	public TLifestyleGuide getLifeGuideById(int lgid);

/**************生活方式指导表接口结束处************************************************/

/**************体征表接口开始处************************************************/
	
	/**
	 * 添加体征表实体且返回自增的主键id
	 * @param ts 体征表实体
	 * @return 体征表主键下一个id
	 */
 	public int saveSign(TSign ts);

 	/**
 	 * 删除体征表实体
 	 * @param ts 体征表实体
 	 */
 	public void deleteSign(TSign ts);
 	
 	/**
 	 * 编辑体征表
 	 * @param ts 体征表实体
 	 */
 	public void editSign(TSign ts);
 	
 	/**
 	 * 通过体征表id得到体征表对应的一个实体
 	 * @param sid 体征表实体
 	 * @return 体征表实体
 	 */
 	public TSign getSignById(int sid);
 	
 	
/**************体征表接口结束处************************************************/
 	
 	
}