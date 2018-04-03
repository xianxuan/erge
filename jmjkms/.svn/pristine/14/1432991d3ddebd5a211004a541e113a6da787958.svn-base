package com.jmjk.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.jmjk.dao.OldStaffHosDao;
import com.jmjk.entity.TOldStaffHos;
import com.jmjk.iservice.IOldStaffHosService;
import com.jmjk.utils.Page;
@Controller("OldStaffHosService")
public class OldStaffHosService implements IOldStaffHosService{
	@Autowired
	OldStaffHosDao osdao;
	
	
	@Override
	public void deleteByDoctorId(int doctorId) {
		String hql = "delete from TOldStaffHos o where o.TStaff.staffId = "
				+ doctorId
				+ " and o.THealthFile.healthFileId in (select healthFileId from THealthFile thf where thf.fileNum='00000000000000000000' )";
		osdao.delete(hql);
	}

	
	
	public void addTOldStaffHos(TOldStaffHos oldStaffHos){
		osdao.Save(oldStaffHos);
	}

	@Override
	public List<TOldStaffHos> getAllDoctorByHosId(int HosId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long countAllStaffByCommunityHospitalId(int communityHospitalId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<TOldStaffHos> getAllStaffByCommunityHospitalId(
			int communityHospitalId, Page<TOldStaffHos> page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TOldStaffHos getOldStaffHosByHosIdAndHeathFileId(int HosId,
			int healthId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TOldStaffHos getOldStaffHosByStaffId(int staffId) {
	String hql="from TOldStaffHos to where to.TStaff.staffId="+staffId;
		return osdao.Get(hql);
	}
	public boolean getOldStaffHosByHealthIdAndHosId(int healthId,int hosId){
		String hql="from TOldStaffHos to where to.THealthFile.healthFileId="+healthId+" and to.TCommunityHospital.communityHospitalId="+hosId;
		if(osdao.Get(hql)!=null){
		return true;
		}else {
			return false;
		}
	}

	@Override
	public TOldStaffHos getOldStaffHosByHealthId(int fid) {
		// TODO Auto-generated method stub
		String hql="from TOldStaffHos to where to.THealthFile.healthFileId="+fid;
		return osdao.Get(hql);
	}
	

	@Override
	public TOldStaffHos getOldStaffHosByFileId(int fileId) {
		String hql="from TOldStaffHos to where to.THealthFile.healthFileId="+fileId;
		return osdao.Get(hql);
	}
	
	public Boolean oldInHos(int fileId,int HosId){
		String hql="from TOldStaffHos to where to.THealthFile.healthFileId="+fileId;
		//不存在
		if(osdao.Get(hql)==null){
			return false;
		}
		//在该社区
		if(osdao.Get(hql).getTCommunityHospital().getCommunityHospitalId()==HosId){
			return true;
		}
		//在其他社区
		else {
			return false;
		}
	}
	//登入的是责任医生
	public boolean oldInSpecialHos(int fileId,int staffId){
		if(fileId==0){
			return false;
		}
		String hql="from TOldStaffHos to where to.THealthFile.healthFileId="+fileId+" and to.TStaff.staffId=" +staffId;
		//没有该老人 或者老人不属于该责任医生
		if(osdao.Get(hql)==null){
			return false;
		}
		else {
			return true;          //说明该老人属于同一社区
		}
	}

	
}
