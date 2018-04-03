package com.jmjk.utils;

import javax.servlet.http.HttpSession;



import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TStaff;
import com.jmjk.enums.Admin_IsHead;
import com.jmjk.service.StaffService;

/**
 * 通过session判断用户---  
 * 平台管理员(返回0)--- 
 * 社区负责人(返回 社区医院ID的负值 )---  
 * 社区其他员工(员工ID正值)  
 * @author 郑富良
 *
 */
public class GetSessionPerson {

	/**
	 * 通过session判断用户
	 * @return  平台管理员(返回0)--- 
	 *          社区负责人(返回 社区医院ID的负值)---  
	 *          社区其他员工(员工ID正值) 
	 */
	public  static int getPerson(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(session==null){
			return (Integer) null;	
		}
		TCommunityHospital tc=(TCommunityHospital)session.getAttribute("comHospital"); //拿医院实体  判断是 社区负责人  还是  管理员   
		if(session!=null){
		//如果是空   那就是 员工  
				if(tc==null){
					TStaff ts=(TStaff)session.getAttribute("tstaff"); //员工实体
					int a=ts.getStaffId(); 				  //返回  是员工的Id
					return a;
				}else{
					if(tc.getIsHead()==Admin_IsHead.shequfuzeren.getValue()){  //如果是 社区负责人  返回所在 社区ID 的负值 
						int b=tc.getCommunityHospitalId();
						b=b*(-1);
						return b;
					}if(tc.getIsHead()==Admin_IsHead.guanliyuan.getValue()){  //如果是 平台管理员  返回0
						return 0;
					}
				}
		}
		
		return (Integer) null;	
	}
	
}
