package com.jmjk.utils;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.jmjk.entity.TChronicFollow;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TOldStaffHos;
import com.jmjk.entity.TStaff;
import com.jmjk.entity.view.VChronic;
import com.jmjk.service.AllChronicDiseaseService;
import com.jmjk.service.ChronicFollowService;
import com.jmjk.service.HealthFileService;
import com.jmjk.service.StaffService;

/**
 * 慢病随访后台校验
 * @author hasee
 *
 */
@Controller("chronicverifyfollow")
public class ChronicVerifyFollow extends SpringBeanAutowiringSupport{

@Autowired
StaffService staffservice;
@Autowired
AllChronicDiseaseService allChronicDiseaseService;
@Autowired
ChronicFollowService chFollowService;//慢病随访总表	
@Autowired
HealthFileService healthFileService;


TOldStaffHos oldstaffhos = new TOldStaffHos();
VChronic vchronic = new VChronic();
TChronicFollow chronicFollow = new TChronicFollow();
private int cid;
private int hid;
private int cfid;




	public boolean verifyFollow(){
		
		HttpSession session = ServletActionContext.getRequest().getSession();
		TCommunityHospital admin = (TCommunityHospital) session.getAttribute("comHospital");//拿到session里面的管理员
		if(admin != null){//如果从session里面拿到的是管理员则进行下面的判断
			if(admin.getIsHead() == 0){//如果IsHead=0  则是平台管理员  无需限制()但是只能查看
				return true;
			}else{
				int adminid = admin.getCommunityHospitalId();//如果是社区负责人,则拿到该负责人所在的医院id
				if(hid != 0 && cid != 0 && cfid == 0){//如果 健康档案id!=0&&慢病档案id不等于0且随访id等于0
					oldstaffhos = staffservice.gethosByFileid(hid);//通过健康档案id拿到老人关系表实体
					if(oldstaffhos == null){return false;}//如果没拿到则返回false
					int old1 = oldstaffhos.getTCommunityHospital().getCommunityHospitalId();//如果拿到,则拿到该实体的社区医院id
					vchronic = allChronicDiseaseService.getVChronicByChronicDiseaseId(cid);//通过慢病档案id拿到慢病视图实体
					if(vchronic == null){return false;}//如果该实体为空,则返回false
					int old2 = vchronic.getCommunityHospitalId();//否则拿到该实体下的社区医院id
					if(old1 == adminid && old2 == adminid){return true;}//如果社区医院id都对应上了则返回true 
					else{return false;}//否则返回false
				}else if (hid != 0 && cid != 0 && cfid != 0) {//如果健康档案id,慢病档案id,慢病随访id都不等于0,则进行以下操作
					oldstaffhos = staffservice.gethosByFileid(hid);//通过健康档案id拿到老人关系表实体
					if(oldstaffhos == null){return false;}//如果该实体为空则返回false
					int old1 = oldstaffhos.getTCommunityHospital().getCommunityHospitalId();//否则拿到社区医院id
					vchronic = allChronicDiseaseService.getVChronicByChronicDiseaseId(cid);//通过慢病档案id拿到慢病视图实体
					if(vchronic == null){return false;}//如果该实体为空,则返回false
					int old2 = vchronic.getCommunityHospitalId();//否则拿到该实体下的社区医院id
					chronicFollow = chFollowService.getChronicFollowByMbsfId(cfid);//通过慢病随访id拿到对应的社区医院id
					vchronic = allChronicDiseaseService.getVChronicByChronicDiseaseId(chronicFollow.getTChronicDisease().getChronicDiseaseId());
					if(vchronic == null){return false;}
					int old3 = vchronic.getCommunityHospitalId();
					if(old1 == adminid && old2 == adminid && old3 == adminid){return true;}//如果所有的社区医院id和当前操作人的社区医院id都对应上,则返回true
					else{return false;}
				}
			}
		}else{
			TStaff staff = (TStaff)session.getAttribute("tstaff");//如果admin为空,则拿到员工实体
			int staffid = staff.getStaffId();//得到员工id
			int staffhosid = staffservice.getCommHospitalByStaffId(staffid);//得到给员工所在医院
			if(!healthFileService.getOldStaffHosByStaffId(staffid) ){//如果该返回值为null,则为护士
				if(hid != 0 && cid != 0 && cfid == 0){//一下进行的校验和上面一样(时间问题未考虑封装)
					oldstaffhos = staffservice.gethosByFileid(hid);
					if(oldstaffhos == null){return false;}
					int old1 = oldstaffhos.getTCommunityHospital().getCommunityHospitalId();
					vchronic = allChronicDiseaseService.getVChronicByChronicDiseaseId(cid);
					if(vchronic == null){return false;}
					int old2 = vchronic.getCommunityHospitalId();
					if(old1 == staffhosid && old2 == staffhosid){return true;}
					else{return false;}
				}else if (hid != 0 && cid != 0 && cfid != 0) {
					oldstaffhos = staffservice.gethosByFileid(hid);
					if(oldstaffhos == null){return false;}
					int old1 = oldstaffhos.getTCommunityHospital().getCommunityHospitalId();
					vchronic = allChronicDiseaseService.getVChronicByChronicDiseaseId(cid);
					if(vchronic == null){return false;}
					int old2 = vchronic.getCommunityHospitalId();
					chronicFollow = chFollowService.getChronicFollowByMbsfId(cfid);
					vchronic = allChronicDiseaseService.getVChronicByChronicDiseaseId(chronicFollow.getTChronicDisease().getChronicDiseaseId());
					if(vchronic == null){return false;}
					int old3 = vchronic.getCommunityHospitalId();
					if(old1 == staffhosid && old2 == staffhosid && old3 == staffhosid){return true;}
					else{return false;}
				}	
			}else{//到这里了 那这个人就是责任医生了
				int doctorid1 = 0;//初始化三个变量
				int doctorid2 = 0;
				int doctorid3 = 0;
				if(hid != 0 && cid != 0 && cfid == 0){
					vchronic = allChronicDiseaseService.getVChronicByChronicDiseaseId(cid);//通过慢病拿到慢病视图实体
					if(vchronic == null){
						return false;//如果为空则返回false,谁让你手贱去改地址栏上的id
					}else{
						doctorid1 = vchronic.getStaffId(); //如果不为空,则拿到这个老人对应的医生id
					}
					oldstaffhos = staffservice.gethosByFileid(hid);//通过健康档案id得到老人,医院,医生冠心病实体
					if(oldstaffhos==null){
						return false;//如果该实体为空,则返回false,因为没有这个老人
					}else{
						doctorid2 = oldstaffhos.getTStaff().getStaffId();//如果oldstaffhos不为空则拿到次老人对应的责任医生id
					}
					if(doctorid1 == staffid && doctorid2 == staffid){return true;}//如果得到的责任医生id和当前的责任医生id都对应上了,则返回true
					else{return false;}
				}else if (hid != 0 && cid != 0 && cfid != 0) {
					vchronic = allChronicDiseaseService.getVChronicByChronicDiseaseId(cid);//通过慢病拿到慢病视图实体
					if(vchronic == null){
						return false;//如果为空则返回false,谁让你手贱去改地址栏上的id
					}else{
						doctorid1 = vchronic.getStaffId(); //如果不为空,则拿到这个老人对应的医生id
					}
					oldstaffhos = staffservice.gethosByFileid(hid);//通过健康档案id得到老人,医院,医生冠心病实体
					if(oldstaffhos==null){
						return false;//如果该实体为空,则返回false,因为没有这个老人
					}else{
						doctorid2 = oldstaffhos.getTStaff().getStaffId();//如果oldstaffhos不为空则拿到次老人对应的责任医生id
					}
					chronicFollow = chFollowService.getChronicFollowByMbsfId(cfid);//通过慢病随访id拿到对应的责任医生id
					vchronic = allChronicDiseaseService.getVChronicByChronicDiseaseId(chronicFollow.getTChronicDisease().getChronicDiseaseId());
					if(vchronic == null){return false;}
					doctorid3 = vchronic.getStaffId();
					if(doctorid1 == staffid && doctorid2 == staffid && doctorid3 == staffid){return true;}//同理 拿到的医生id和当前医生的对应上,则返回true
					else{return false;}
				}
			}
		}
		return false;
		
	}
	
	
	
	
	
	
	
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public int getCfid() {
		return cfid;
	}

	public void setCfid(int cfid) {
		this.cfid = cfid;
	}


	
}
