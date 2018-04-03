package com.jmjk.utils;

import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.dev.EFBiffViewer;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TOldStaffHos;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.view.VChronic;
import com.jmjk.service.AllChronicDiseaseService;
import com.jmjk.service.HealthFileService;
import com.jmjk.service.OldStaffHosService;
import com.jmjk.service.StaffService;

@Controller("chronicVerify")
public class ChronicVerify extends SpringBeanAutowiringSupport{
	
@Autowired
AllChronicDiseaseService allChronicDiseaseService;
@Autowired
StaffService staffservice;
@Autowired
HealthFileService healthFileService;
@Autowired
OldStaffHosService oldStaffHosService;



TOldStaffHos oldstaffhos = new TOldStaffHos();
VChronic vchronic = new VChronic();
private int chid;
private int helid;

	public boolean verify(){
		if(chid == 0 && helid ==0){return false;}
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospital admin = (TCommunityHospital) session.getAttribute("comHospital");//拿到session里面的管理员
		int adminhosid = 0;
		int oldhosid = 0;
		int sqid = 0;
		int doctorid = 0;
			if(admin==null){//如果没有管理员则拿到普通员工
				
				TStaff staff = (TStaff)session.getAttribute("tstaff");
				int uid = staff.getStaffId();//拿到普通员工的id
				if(healthFileService.getOldStaffHosByStaffId(uid)){//判断是否是责任医生,如果不为空,则是责任医生
					if(chid!=0 && helid==0){//如果慢病id不为0,则用慢病id进行校验
						vchronic = allChronicDiseaseService.getVChronicByChronicDiseaseId(chid);//通过慢病拿到慢病视图实体
						if(vchronic == null){
							return false;//如果为空则返回false,谁让你手贱去改地址栏上的id
						}else{
							doctorid = vchronic.getStaffId(); //如果不为空,则拿到这个老人对应的医生id
						}
					}else if (helid != 0 && chid == 0) {//如果慢病档案id是空,健康档案id不为空,则用健康档案id进行校验
						oldstaffhos = staffservice.gethosByFileid(helid);//通过健康档案id得到老人,医院,医生冠心病实体
						if(oldstaffhos==null){
							return false;//如果该实体为空,则返回false,因为没有这个老人
						}else{
							doctorid = oldstaffhos.getTStaff().getStaffId();//如果oldstaffhos不为空则拿到次老人对应的责任医生id
						}
					}else if (chid != 0 && helid != 0) {//如果两者都不为空
						int doctorid1 = 0;
						int doctorid2 = 0;
						vchronic = allChronicDiseaseService.getVChronicByChronicDiseaseId(chid);//通过慢病拿到慢病视图实体
						if(vchronic == null){
							return false;//如果为空则返回false,谁让你手贱去改地址栏上的id
						}else{
							doctorid1 = vchronic.getStaffId(); //如果不为空,则拿到这个老人对应的医生id
						}
						oldstaffhos = staffservice.gethosByFileid(helid);//通过健康档案id得到老人,医院,医生冠心病实体
						if(oldstaffhos==null){
							return false;//如果该实体为空,则返回false,因为没有这个老人
						}else{
							doctorid2 = oldstaffhos.getTStaff().getStaffId();//如果oldstaffhos不为空则拿到次老人对应的责任医生id
						}
						if(uid == doctorid1 && uid == doctorid2){//如果两者的医生id都能对应上则返回true
							return true;
						}
						return false;//如果健康档案id和慢病档案id都为0,则返回false
					}
					if(uid == doctorid){
						return true;//如果当前登录责任医生的id和该老人对应的医生id相同,则返回true,否则返回false
					}else{
						return false;
					}
						
				}
				int hosid=0;
				try {
					hosid = staffservice.getCommHospitalByStaffId(uid);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(chid!=0&&helid==0){//如果慢病档案有值则从慢病档案视图里面拿到对应的视图
				vchronic = allChronicDiseaseService.getVChronicByChronicDiseaseId(chid);
					if(vchronic==null){
						return false;
					}else{
				 	sqid = vchronic.getCommunityHospitalId();//拿到该慢病id对应的社区医院id
					}
					if(hosid == sqid){
						return true;//如果等于当前社区医院id则返回true
					}else{
						return false;//否则返回false
					}
				}else if (chid==0&&helid!=0){//如果慢病档案id不为空
					oldstaffhos = staffservice.gethosByFileid(helid);//拿到对应的员工医院关系表实体
					if(oldstaffhos==null){
							return false;
					}else{
						sqid = oldstaffhos.getTCommunityHospital().getCommunityHospitalId();//拿到对应的社区医院id
					}
					if(hosid == sqid){//如果和session里面的社区医院id相同则返回true
						return true;
					}else{
						return false;
					}
				}else if (chid!=0&&helid!=0) {//如果chid和helid都不为0则进行下面判断
					vchronic = allChronicDiseaseService.getVChronicByChronicDiseaseId(chid);
					int sqid1 = vchronic.getCommunityHospitalId();//通过慢病id得到社区医院id
					oldstaffhos = staffservice.gethosByFileid(helid);
					int sqid2 = oldstaffhos.getTCommunityHospital().getCommunityHospitalId();//通过健康档案id得到社区医院id
					if(sqid1 == hosid && sqid2 == hosid){//判断是否相等
						return true;
					}else{
						return false;
					}
				}
			}else if(admin.getIsHead()==0){//如果ishead等于0,则是平台管理员,无需判断直接返回true
				return true;
			}
			 adminhosid = admin.getCommunityHospitalId();//如果是社区负责人则进行一下判断
			 if(chid != 0 && helid ==0){//如果慢病id有值
				vchronic = allChronicDiseaseService.getVChronicByChronicDiseaseId(chid);//通过慢病id得到对应的慢病视图实体
				if(vchronic == null){//如果该实体为空,则返回false
					return false;
				}else{
					oldhosid = vchronic.getCommunityHospitalId();//若不为空,则返回该慢病id对应的社区医院id
				}
			}else if (helid != 0 && chid == 0) {//如果慢病id为0,健康档案id不为0,则利用健康档案id进行判断
				oldstaffhos = staffservice.gethosByFileid(helid);//通过健康档案id得到老人,医院,员工关系表实体
				if(oldstaffhos == null){//如果该实体为空,则返回false
					return false;
				}else{
					oldhosid = oldstaffhos.getTCommunityHospital().getCommunityHospitalId();//否则得到该实体下的社区医院id
				}
			}else if (chid != 0 && helid != 0) {//如果chid 和 helid同时为0,则返回false
				int oldhosid1 = 0;
				int oldhosid2 = 0;
				vchronic = allChronicDiseaseService.getVChronicByChronicDiseaseId(chid);//通过慢病id得到对应的慢病视图实体
				if(vchronic == null){//如果该实体为空,则返回false
					return false;
				}else{
					oldhosid1 = vchronic.getCommunityHospitalId();//若不为空,则返回该慢病id对应的社区医院id
				}
				oldstaffhos = staffservice.gethosByFileid(helid);//通过健康档案id得到老人,医院,员工关系表实体
				if(oldstaffhos == null){//如果该实体为空,则返回false
					return false;
				}else{
					oldhosid2 = oldstaffhos.getTCommunityHospital().getCommunityHospitalId();//否则得到该实体下的社区医院id
				}
				if(oldhosid1 == adminhosid && oldhosid2 == adminhosid){//如果两个id都能对应上则返回true
					return true;
				}else{
				return false;
				}
			}
			if(adminhosid == oldhosid){//否则进行判断,如果该社区负责人的医院id等于该老人对应的社区医院id则返回true
				return true;
			}else{
			return false;
			}
	}
			








	public int getChid() {
		return chid;
	}
	
	public void setChid(int chid) {
	this.chid = chid;
	}
	
	public int getHelid() {
	return helid;
	}
	
	public void setHelid(int helid) {
	this.helid = helid;
	}


	

}
