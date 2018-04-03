package com.jmjk.iservice;

import java.math.BigInteger;
import java.util.List;

import javax.xml.crypto.Data;



import com.jmjk.entity.THealthFile;
import com.jmjk.utils.Page;
import com.jmjk.utils.SearchBean;

/**
 * 2016.8.4
 * @author 张晓光&赖清发&朱德江
 *
 */
public interface IHealthFileManageService {
	/**
	 *  健康管理查询档案老人的基本信息(缺少参数)
	 * @param page 分页
	 * @return
	 */
	public List<THealthFile> getHealthFileList(Page<THealthFile> page);
	
	/**
	 * 高血压档案下载数据
	 * @param diaPre 舒张压
	 * @param sysPre 收缩压
	 * @param pulse 脉搏
	 * @param takeMed 是否用药
	 * @param medName 用药名称
	 * @param devID 设备ID
	 * @param arm 测量手臂
	 * @param meaTime 测量时间
	 */
     public void downloadHighBloodPressureFile(double diaPre,double sysPre,int pulse,int takeMed,char medName,BigInteger devID,int arm,Data meaTime);
     
     /**
      * 高血糖档案从云端下载数据
      * @param bloodSugar 血糖值
      * @param meaState 测量状态
      * @param meaTime 测量时间
      * @param devID 测量设备ID
      * @param takeMed 是否服药
      * @param medName 用药名称
      */
     public void downloadHighBloodSugerFile(double bloodSugar,double meaState,Data meaTime,BigInteger devID ,int takeMed,char medName);
     /**
      * 心电档案 未做定义
      */
     public void downloadElectrocardioFile();
     /**
      * 血氧档案数据下载
      * @param oxygen 血氧值
      * @param pulse 脉搏
      * @param meaTime 测量时间
      * @param devID 测量设备ID
      * @param takeMed 是否服药
      * @param medName 用药名称
      */
     public void downloadBloodOxygen(double oxygen,int pulse,Data meaTime,BigInteger devID,int takeMed,char medName);
       /**
        * 健康一体机档案 
        * @param currentPage 当前页面
        * @param pageSize 每页显示条数
        */
     public void downloadHealthIntegratedMachineFile (int currentPage,int pageSize);
   
}
