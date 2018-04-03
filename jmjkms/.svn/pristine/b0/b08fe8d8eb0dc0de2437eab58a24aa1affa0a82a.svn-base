package com.jmjk.iservice;

import java.sql.Date;
import java.util.List;

import javax.swing.Spring;

import jxl.write.DateTime;

public interface IViewChronicService {

	/*
   sqid社区医院id   zt档案状态  通过社区医院id和档案状态id拿到所有慢病档案实体 用于第一次首页展示
       
      public List<TC> firstFindAllCh(int sqid,char zt, Page<TC> page);
    
        通过社区医院id 拿到所有患有慢病的人
      public List<TC> firstFindAllCh (int sqid ,Page<TC> page);
    
        拿到该社区所有患慢病人的数量
      public long getAllChCount(int sqid);
    
    
    
   daid 健康档案档案id  通过健康档案id拿到一个人的所有慢病实体集合用于展示这个人 有几种病
    
      public List<TC> findCh(int daid);
    
   mbid慢病id  通过慢病id拿到当前慢病视图实体 用于慢病详情
    
      public TC getCh(int mbid,int sqid);
    
    
    
    
    
    
    
    
    下面是随访记录详情
    
        根据档案id拿到一个人有随访记录的所有病   并用社区医院id判断是否是当前医院的人  (在实现时用distinct去掉重复的字段)
     public List<TChFollow> findChFollow(int daid,int sqid);
    
    
    
       通过慢病随访id拿到一个人的一次随访记录   sqid判断是否是当前医院的人
     public TChFollow getChFollow(int mbfid , int sqid);
    
        通过随访时间、档案id、社区医院id、疾病名称   得到随访记录的某次记录
     public TChFollow getChFollowByDate (Date time  , int daid ,int sqid , string illname);
    
    */
	
	/**
	 * 
	 * @param iDcard 身份证号
	 * @param name  名字
	 * @prama filenum 档案编号
	 * @param age 年龄
	 * @param sbirth 生日开始时间
	 * @param ebirth 生日结束时间
	 * @param zdoctor 责任医生
	 * @param pfile 建档人
	 * @param sfiletime 建档时间开始
	 * @param efileTime 建档时间结束
	 * @param wsfiletime 录入时间开始
	 * @param wefiletime 录入时间结束
	 * @param wpeople 录入人
	 * @param sex 性别
	 * @param filestatus 档案状态
	 * @param province 省
	 * @param city 市
	 * @param county 县
	 * @param otheraddress  详细地址
	 * @param mbname 慢病名称  慢病分类
	 * @return
	 */
	/*public List<TVc> getAllVc(Spring iDcard,Spring name,String filenum , int age,Date sbirth ,Date ebirth,
			String zdoctor ,String pfile ,Date sfiletime,
			Date efileTime ,Date wsfiletime , Date wefiletime ,
			String wpeople ,Boolean sex ,String filestatus ,Spring province
			,Spring city,Spring county,Spring otheraddress ,String mbname);
	
	*/
}
