package com.jmjk.iservice;

import java.util.List;

import com.jmjk.entity.TChronicDisease;
import com.jmjk.entity.view.VChronic;
import com.jmjk.utils.Page;
import com.jmjk.utils.SearchBean;
/**
 * 操作慢性表总表接口
 * @ 李卓远
 * 15530257686
 */
public interface IAllChronicDiseaseService {//

	/**
	 * 保存慢性病总表
	 * @param mb 慢病
	 * @return 预取的慢病总表id
	 */
    public int saveChronicDisease (TChronicDisease mb);

    /**
	 * 删除慢性病总表
	 * @param mb  慢病
	 */
    public void deleteChronicDisease (TChronicDisease mb);
       
    /**
	 * 编辑慢性病总表
	 * @param mb  慢病
	 */
    public void editChronicDisease (TChronicDisease mb);
    
    /**
     * 通过search工具类查找患慢病老人
     * @param se search工具类
     * @return 患病老人列表
     */
    public List<VChronic> findChronicPeople(SearchBean se , Page<VChronic> page);
    
    /**
     * 健康管理下的其他慢病管理查询老人接口
     * @param se search类
     * @param page 分页
     * @param status 慢病档案状态
     * @return 其他慢病老人集合
     */
    public List<VChronic> findHealther(SearchBean se , Page<VChronic> page ,int status );
    /**
    * 健康管理下的其他慢病管理查询老人接口
     * @param se search类
     * @param status 慢病档案状态
     * @return 其他慢病老人集合数量
     */
    public long findHealtherCount(SearchBean se, int status);
    public long findChronicPeopleCount(SearchBean se);
    
    /**
     * 通过慢病总表id拿到慢病总表实体并且可用于假删
     * @param mbid 慢病总表id
     * @return 慢病总表实体（能用于假删）
     */
    public TChronicDisease getChronicDiseaseByID (int mbid);
    
    /**
     * 通过社区医院id和档案档案状态拿到次社区所有患慢病人   首页展示慢病患者信息接口
     * @param sqid 社区医院id
     * @param zt 档案状态量（这里是正常）
     * @param page 分页
     * @return 所有患慢病者
     */
    public List<VChronic> firstGetAllVc(int sqid,int zt,Page<VChronic> page);
    
    /**
     * 通过社区id和档案状态拿到护士和社区管理员要导出的集合
     * @param sqid 社区id
     * @return 老人集合
     */
    public List<VChronic> someInformationForNurseAndSmalladmin(int sqid);
    
    /**
     * 通过社区医院id和档案状态 拿到首次展示所有慢病患者数量用于首次展示分页(社区管理员使用)
     * @param sqid 社区医院id
     * @param zt 档案状态量（这里是正常）
     * @return 所有患慢病患者数量 
     */
    public long getAllVcCount (int sqid , int zt);
    
    /**
     * 通过档案id sqid  拿到当前社区当前人的所有慢病
     * @param fid 档案id
     * @param status 慢病档案状态
     * @param sqid 社区医院id
     * @return 一个人所有病的集合
     */
    public List<VChronic> getPeoPleAllIll(int fid , int sqid , int status);

    /**
     * 通过健康档案id得到当前人的所有慢病,用于平台管理员查看用
     * @param fid 健康档案id
     * @param status 慢病档案状态
     * @return 一个人的所有慢病集合
     */
    public List<VChronic> getPeopleAllIllForSuper(int fid , int status);
    
    /**
     * 通过社区医院id和慢病档案总表id拿到当前人的慢病档案
     * @param sqid 社区医院id
     * @param mbid 慢病总表id
     * @return 慢病档案详情
     */
    public VChronic getOneVc(int sqid , int mbid);
    
    /**
     * 通过慢病id得到慢病实体,用于平台管理员查看
     * @param mbid 慢病id
     * @return 慢病实体
     */
    public VChronic getOneVcForSupper(int mbid);
    
    
    
    /**
     * 通过社区医院id拿到当前社区所有患慢病老人
     * @param sqid 社区id
     * @param illname 慢病名称
     * @return 所有患病老人集合
     */
    public List<VChronic> getAllPeople(int sqid , String illname,int flag);

    /**
     * 平台管理员查看慢病老人信息接口
     * @param zt 档案状态  废弃不用
     * @return 所有社区慢病首页信息
     */
    public List<VChronic> getAllPeopleForSupper(int zt , Page<VChronic> page);
    
    /**
     * 平台管理员导出专用
     * @param zt档案状态
     * @return 老人集合
     */
    public List<VChronic> getInformationForSupper(int zt);
    
    /**
     * 通过档案状态拿到所有社区慢病老人数量用于分页
     * @param zt 档案状态    目前没用到
     * @return 所有社区老人数量
     */
    public long getAllPeopleCountForSupper(int zt);
    
    
    /**
     * 责任医生查看慢病老人信息接口
     * @param zt 档案状态
     * @param zrid 责任医生id
     * @param sqid  社区id
     * @return 该责任医生管理的所有老人
     */
    public List<VChronic> getSomePeopleForDoctor(int zt , int zrid , int sqid , Page<VChronic> page);
    
    /**
     * 社区集团负责人查看慢病老人信息接口（用于首页首次展示）
     * @param gid 社区集团id
     * @param zt  档案状态
     * @param page	分页
     * @return 该社区集团下的所有老人
     */
    public List<VChronic> getAllPeopleForGroup(int gid , int zt , Page<VChronic> page);
    
    /**
     * 社区集团负责人首页展示条数
     * @param gid 社区集团id
     * @param zt 档案状态
     * @return 社区集团下慢病老人数量
     */
    public long getAllPeopleNumForGroup(int gid , int zt);
    
    /**
     * 社区集团导出全部慢病老人接口
     * @param gid 社区集团id
     * @param zt 档案状态
     * @return 社区集团全部慢病老人
     */
    public List<VChronic> getAllPeopleForGroup(int gid);
    /**
     * 责任医生打印接口
     * @param zrid 责任医生id
     * @param sqid 社区id
     * @return 责任医生的老人集合
     */
    public List<VChronic> getSomeInformationsForDoctor(int zrid , int sqid);
    
    /**
     * 通过责任医生id和档案状态
     * @param zt 档案状态
     * @param zrid 责任医生id
     * @param sqid 社区id
     * @return 该责任医生管理的人数量
     */
    public long getSomePeopleCountForDoctor(int zt , int zrid , int sqid);
    
    /////////////////////zdj
    /**
     * 通过慢病id得到某人唯一某病记录,得到视图唯一记录
     * @param cdid 慢病总表id
     * @return
     */
    public VChronic getVChronicByChronicDiseaseId(int cdid);
    
    /**
     * 得到所有加入某种慢病管理的管理的老人
     * @param a 加入慢病病管理状态
     * @param page 分页
     * @return
     */

    public List<VChronic> getAllDiabeteManager(int i, Page<VChronic> page);
    
    /**
     * 得到慢病总表中某人某种病的一条记录
     * @param daId 档案id
     * @param name 慢病名称
     * @return
     */
	public TChronicDisease getChronicDiseaseByNumName(int daId, String name);
	/**
	 * 得到该社区下加入某种慢病管理(status)档案正常状态的老人 
	 * @param sqid 社区ID
	 * @param zt  档案状态
	 * @param status 加入慢病管理状态 1:糖尿病管理 2:高血压管理
	 * @param page  分页
	 * @return
	 */
	public List<VChronic> getChronicManager(int sqid, int zt, int status,
			Page<VChronic> page);

	/**
	 * 得到该社区下加入其他慢病管理(status)档案正常状态的老人 
	 * @param sqid 社区ID
	 * @param zt 档案状态
	 * @param page 分页
	 * @return
	 */
	public List<VChronic> getOtherChronicManager(int sqid, int zt,
			Page<VChronic> page);
	/**
	 * 得到该社区下没加入(糖尿病\高血压)慢病管理(status)且档案正常状态的老人 
	 * @param sqid 社区id
	 * @param m    档案状态
	 * @param chronicName  慢病名称
	 * @param page   分页
	 * @return
	 */
	public List<VChronic> getNoDiabeteHighManager(int sqid, int m,
			String chronicName, Page<VChronic> page);
	/**
	 * 得到该社区下没加入(其他)慢病管理(status)且档案正常状态的老人 
	 * @param sqid   社区id
	 * @param m      档案状态
	 * @param diabeteName  糖尿病名称
	 * @param highName     高血压名称
	 * @param page         分页
	 * @return 
	 */
	public List<VChronic> getNoOtherManager(int sqid, int m, String diabeteName,
			String highName, Page<VChronic> page);
	/**
	 * 确认添加选中老人至糖尿病管理
	 * @param idList 糖尿病老人id集合，更新状态值
	 */
	public void addAnyDiabeteManager(List<Object> idList);
	/**
	 * 得到该社区下没加入(其他)慢病管理(status)且档案正常状态的老人 数量
	 * @param sqid  社区id
	 * @param m     档案状态
	 * @param diabeteName  糖尿病名称
	 * @param highName     高血压名称
	 * @return
	 */
	public long getcountNoOtherManager(int sqid, int m, String diabeteName,
			String highName);
	/**
	 * 得到该社区下没加入(高血压或糖尿病)慢病管理(status)且档案正常状态的老人 数量
	 * @param sqid   社区id
	 * @param m      档案状态
	 * @param chronicName  慢病名称(高血压、糖尿病其中一种)
	 * @return
	 */
	public long getcountNoDiabeteHighManager(int sqid, int m,
			String chronicName);
	/**
	 * 得到该社区下加入(高血压或糖尿病)慢病管理(status)且档案正常状态的老人 数量
	 * @param sqid  社区id
	 * @param zt    档案状态
	 * @param status 是否加入糖尿病、高血压管理状态值
	 * @return
	 */
	public long getcountChronicManager(int sqid, int zt, int status);
	/**
	 * 得到该社区下加入其他慢病管理且档案正常状态的老人 数量
	 * @param sqid  社区id
	 * @param zt    档案状态
	 * @return
	 */
	public long getcountOtherChronicManager(int sqid, int zt);
	/**
	 *  确认添加选中老人至高血压管理
	 * @param idList   老人健康id集合
	 */
	public void addAnyHighManager(List<Object> idList);
	/**
	 * 确认添加选中老人至其他慢病管理
	 * @param oldids  老人健康id集合
	 */
	public void addAnyOtherManager(List<Object> oldids);
	
   
   /**
    * 通过社区Id拿到   视图的List
    * @param sqid
    * @param zt
    * @param status
    * @return
    */
   public List<VChronic> getChronicManager(int sqid, int zt, int status );
    /*public chazhao*/
   /**
    * 得到管理员登入下的所有慢病(糖尿病/高血压)老人数量
    * @param zt  档案状态
    * @param status  加入糖尿病/高血压管理的老人
    * @return
    */
   public long getAdminCountChronicManager(int zt, int status);
   /**
    * 在责任医生登入状态下，得到该医生所管理高血压\糖尿病老人
    * @param hosId 社区id
    * @param person 登入状态
    * @param m  档案状态
    * @param status  加入糖尿病/高血压管理的老人状态
    * @param page
    * @return
    */
   public List<VChronic> getallDiabeteManagerSpecial(int hosId, int person, int m,
		int status, Page<VChronic> page);
   /**
    * 在责任医生登入状态下，得到该医生所管理高血压\糖尿病老人数量
    * @param hosId 社区id
    * @param person 登入状态
    * @param m  档案状态
    * @param status  加入糖尿病/高血压管理的老人状态
    * @return
    */
   public long getallCountDiabeteManagerSpecial(int hosId, int person, int m, int status);
   /**
    * 社区管理员得到所有其他慢病管理下的老人数量
    * @param zt
    * @param page
    * @return
    */
   public List<VChronic> getAdminOtherManager(int zt, Page<VChronic> page);
   /**
    * 社区管理员得到所有其他慢病管理下的老人
    * @param zt
    * @return
    */
   public long getAdminCountOtherManager(int zt);
   /**
    * 责任医生得到所有其他慢病管理下的老人
    * @param hosId
    * @param personOtherChronic
    * @param m
    * @param page
    * @return
    */
   public List<VChronic> getallOtherManagerSpecial(int hosId, int personOtherChronic,
		   int m, Page<VChronic> page);
   /**
    * 责任医生得到所有其他慢病管理下的老人数量
    * @param hosId
    * @param personOtherChronic
    * @param m
    * @return
    */
   public long getallCountOtherManagerSpecial(int hosId, int personOtherChronic, int m);

   /**
    * 责任医生得到所有糖尿病老人
    * @param hosId
    * @param person
    * @param m
    * @param status
    * @return
    */
   public List<VChronic> getallDiabeteManagerSpecialNoPage(int hosId, int person, int m,int status);

   public List<VChronic> getOtherChronicManagerNoPage(int sqid, int zt);
   /**
    * 得到集团下所有慢病老人数量
    * @param gId 集团gid
    * @param zt  档案状态
    * @param status 加入糖尿病/高血压标记值
    * @return
    */
   public long getGroupCountChronicManager(Integer gId, int zt, int status);
   /**
    * 得到集团下所有慢病老人分页
    * @param gId 集团gid
    * @param zt  档案状态
    * @param status 加入糖尿病/高血压标记值
    * @param page
    * @return
    */
   public List<VChronic> getGroupChronicManager(Integer gId, int zt, int status,
		Page<VChronic> page);
   /**
    * 系统管理员得到所有糖尿病或高血压老人不分页
    * @param zt
    * @param status
    * @return
    */
   public List<VChronic> getAdminChronicManager(int zt, int status);
   /**
    * 系统管理员得到所有糖尿病或高血压老人分页
    * @param zt
    * @param status 糖尿病或高血压
    * @param page
    * @return
    */
   public List<VChronic> getAdminChronicManagerPage(int zt, int status,
		Page<VChronic> page);

   





   
   
}
