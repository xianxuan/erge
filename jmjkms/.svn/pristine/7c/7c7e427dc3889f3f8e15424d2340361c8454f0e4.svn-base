package com.jmjk.iservice;

import java.util.List;


import com.jmjk.entity.view.VCardiovascularFollow;
import com.jmjk.entity.view.VCoronaryFollow;
import com.jmjk.entity.view.VDiabetsFollow;
import com.jmjk.entity.view.VHypertensiveFollow;
import com.jmjk.entity.view.VMentalFollow;
import com.jmjk.entity.view.VOtherillFollow;
import com.jmjk.utils.Page;

/**
 * 慢病随访视图接口
 * @author 李卓远
 *
 */
public interface IVchronicFollowService {
	
	/**
	 * 通过慢病随访id和社区医院id得到心脑血管随访记录视图实体
	 * @param mbfid 慢病随访id
	 * @param sqid 社区医院id
	 * @return 心脑血管视图实体
	 */
	public VCardiovascularFollow getcardfollow (int mbfid , int sqid);
	
	/**
	 * 通过慢病随访id得到心脑血管随访记录视图实体
	 * @param mbsfid 慢病随访id
	 * @return 心脑血管视图实体
	 */
	public VCardiovascularFollow getcardfollowForSupper(int mbfid);
	
	/**
	 * 通过慢病id和社区医院id得到心脑血管随访记录视图实体集合
	 * @param mbid 慢病id
	 * @param sqid 社区医院id
	 * @param page 分页
	 * @return 心脑血管随访记录视图实体集合
	 */
	public List<VCardiovascularFollow> getCardFollowList(int mbid , int sqid , Page<VCardiovascularFollow> page);
	
	/**
	 * 通过慢病id得到心脑血管随访记录视图实体集合
	 * @param mbid 慢病id
	 * @param page 分页
	 * @return 心脑血管随访记录视图实体集合
	 */
	public List<VCardiovascularFollow> getCardFollowListForSupper(int mbid , Page<VCardiovascularFollow> page);
	
	/**
	 * 通过慢病id得到心脑血管随访记录数量
	 * @param mbid 慢病id
	 * @return 心脑血管随访记录数量
	 */
	public long getCardFollowListCount(int mbid);
	
	/**
	 * 通过慢病随访id和社区医院id得到冠心病随访记录视图实体
	 * @param mbfid 慢病随访id
	 * @param sqid 社区医院id
	 * @return 冠心病视图实体
	 */
	public VCoronaryFollow getCoronaryFollow (int mbfid , int sqid);
	
	/**
	 * 通过慢病随访id得到冠心病随访记录视图实体
	 * @param mbfid 慢病随访id
	 * @return 冠心病视图实体
	 */
	public VCoronaryFollow getCoronaryFollowForSupper(int mbfid);
	
	/**
	 * 通过慢病id和社区医院id得到冠心病随访记录视图实体集合
	 * @param mbid 慢病id
	 * @param sqid 社区医院id
	 * @param page 分页
	 * @return 冠心病随访记录视图实体集合
	 */
	public List<VCoronaryFollow> getCoronaryFollowList(int mbid , int sqid , Page<VCoronaryFollow> page);
	
	/**
	 * 通过慢病id得到冠心病随访记录视图实体集合
	 * @param mbid 慢病id
	 * @param page 分页
	 * @return 冠心病随访记录视图实体集合
	 */
	public List<VCoronaryFollow> getCoronaryFollowListForSupper(int mbid , Page<VCardiovascularFollow> page);
	
	/**
	 * 通过慢病id得到冠心病随访记录数量
	 * @param mbid 慢病id
	 * @return 冠心病随访记录数量
	 */
	public long getCoronaryFollowListCount(int mbid);
	
	/**
	 * 通过慢病随访id和社区医院id得到糖尿病随访记录视图实体
	 * @param mbfid 慢病随访id
	 * @param sqid 社区医院id
	 * @return 糖尿病随访记录视图实体
	 */
	public VDiabetsFollow getDiabetsFollow (int mbfid , int sqid);
	
	/**
	 * 通过慢病随访id得到糖尿病随访记录视图实体
	 * @param mbfid 慢病随访id
	 * @return 糖尿病随访记录视图实体
	 */
	public VDiabetsFollow getDiabetsFollowForSupper(int mbfid);
	
	/**
	 * 通过慢病id和社区医院id得到糖尿病随访记录视图实体集合
	 * @param mbid 慢病id
	 * @param sqid 社区医院id
	 * @param page 分页
	 * @return 糖尿病随访记录视图实体集合
	 */
	public List<VDiabetsFollow> getDiabetsFollowList(int mbid , int sqid , Page<VDiabetsFollow> page);
	
	/**
	 * 通过慢病id得到糖尿病随访记录视图实体集合
	 * @param mbid 慢病id
	 * @param page 分页
	 * @return 糖尿病随访记录视图实体集合
	 */
	public List<VDiabetsFollow> getDiabetsFollowListForSupper(int mbid , Page<VDiabetsFollow> page);
	
	/**
	 * 通过慢病id得到糖尿病随访记录视图实体数量
	 * @param mbid
	 * @return 糖尿病随访记录视图实体数量
	 */
	public long getDiabetsFollowListCount(int mbid);
		
	/**
	 * 通过慢病随访id和社区医院id得到高血压随访记录视图实体
	 * @param mbfid 慢病随访id
	 * @param sqid 社区医院id
	 * @return 高血压随访记录视图实体
	 */
	public VHypertensiveFollow getHypertensiveFollow (int mbfid , int sqid);
	
	/**
	 * 通过慢病随访id得到对应高血压随访记录视图实体
	 * @param mbfid 慢病随访id
	 * @return 高血压随访记录视图实体
	 */
	public VHypertensiveFollow getHypertensiveFollowForSupper(int  mbfid);
	
	/**
	 * 通过慢病id和社区医院id得到高血压随访记录视图实体集合
	 * @param mbid 慢病id
	 * @param sqid 社区医院id
	 * @param page 分页
	 * @return 高血压随访记录视图实体集合
	 */
	public List<VHypertensiveFollow> getHypertensiveFollowList(int mbid , int sqid , Page<VHypertensiveFollow> page);
	
	/**
	 * 通过慢病id得到高血压随访记录视图实体集合
	 * @param mbid 慢病id
	 * @param page 分页
	 * @return 高血压随访记录视图实体集合
	 */
	public List<VHypertensiveFollow> getHypertensiveFollowListForSupper(int mbid , Page<VHypertensiveFollow> page);
	
	/**
	 * 通过慢病id得到高血压随访记录视图实体数量
	 * @param mbid 慢病id
	 * @return 高血压随访记录视图实体数量
	 */
	public long getHypertensiveFollowListCount(int mbid);
	
	/**
	 * 通过慢病随访id和社区医院id得到重性精神疾病随访记录视图实体
	 * @param mbfid 慢病随访id
	 * @param sqid 社区医院id
	 * @return 重性精神疾病随访记录视图实体
	 */
	public VMentalFollow getMentalFollow (int mbfid , int sqid);
	
	/**
	 * 通过慢病随访id得到重性精神疾病随访记录视图实体
	 * @param mbfid 慢病随访id
	 * @return 重性精神疾病随访记录视图实体
	 */
	public VMentalFollow getMentalFollowvForSupper(int mbfid);
	
	/**
	 * 通过慢病id和社区医院id得到重性精神疾病随访记录视图实体集合
	 * @param mbid 慢病id
	 * @param sqid 社区医院id
	 * @param page 分页
	 * @return 重性精神疾病随访记录视图实体集合
	 */
	public List<VMentalFollow> getMentalFollowLIst(int mbid , int sqid , Page<VMentalFollow> page);
	
	/**
	 * 通过慢病id得到重性精神疾病随访记录视图实体集合
	 * @param mbid 慢病id
	 * @param page 分页
	 * @return 重性精神疾病随访记录视图实体集合
	 */
	public List<VMentalFollow> getMentalFollowLIstForSupper(int mbid , Page<VMentalFollow> page);
	
	/**
	 * 通过慢病id得到重性精神疾病随访记录视图实体数量
	 * @param mbid 慢病id
	 * @return 重性精神疾病随访记录视图实体数量
	 */
	public long getMentalFollowLIstCount(int mbid);
	/**
	 * 通过慢病随访id和社区医院id得到其他慢病随访记录视图实体（包括  肿瘤、慢性支气管病、残疾障碍）
	 * @param mbfid 慢病随访id
	 * @param sqid 社区医院id
	 * @return 其他慢病随访记录视图实体（包括  肿瘤、慢性支气管病、残疾障碍）
	 */
	public VOtherillFollow getOtherillFollow (int mbfid , int sqid);
	
	/**
	 * 通过慢病随访id得到其他慢病随访记录视图实体（包括  肿瘤、慢性支气管病、残疾障碍）
	 * @param mbfid 慢病随访id
	 * @return 其他慢病随访记录视图实体（包括  肿瘤、慢性支气管病、残疾障碍）
	 */
	public VOtherillFollow getOtherillFollowForSupper(int mbfid);
	
	/**
	 * 通过慢病id和社区医院id得到其他慢病随访记录视图实体集合(包括慢性支气管病,肿瘤,残疾障碍)
	 * @param mbid 慢病id
	 * @param sqid 社区医院id
	 * @param page 分页
	 * @return 其他慢病随访记录视图实体集合
	 */
	public List<VOtherillFollow> getOtherillFollowList(int mbid , int sqid , Page<VOtherillFollow> page);
	
	/**
	 * 通过慢病id得到其他慢病随访记录视图实体集合(包括慢性支气管病,肿瘤,残疾障碍)
	 * @param mbid 慢病id
	 * @param page 分页
	 * @return 其他慢病随访记录视图实体集合
	 */
	public List<VOtherillFollow> getOtherillFollowListForSupper(int mbid , Page<VOtherillFollow> page);
	
	/**
	 * 通过慢病id得到其他慢病随访记录视图实体数量
	 * @param mbid 慢病id
	 * @return 其他慢病随访记录视图实体数量
	 */
	public long getOtherillFollowListCount(int mbid);
	
}
