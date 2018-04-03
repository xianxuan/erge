package com.jmjk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.hql.internal.ast.HqlASTFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.jmjk.dao.VCardiovascularFollowDao;
import com.jmjk.dao.VCoronaryFollowDao;
import com.jmjk.dao.VDiabetsFollowDao;
import com.jmjk.dao.VHypertensiveFollowDao;
import com.jmjk.dao.VMentalFollowDao;
import com.jmjk.dao.VOtherIllFollowDao;
import com.jmjk.entity.view.VCardiovascularFollow;
import com.jmjk.entity.view.VCoronaryFollow;
import com.jmjk.entity.view.VDiabetsFollow;
import com.jmjk.entity.view.VHypertensiveFollow;
import com.jmjk.entity.view.VMentalFollow;
import com.jmjk.entity.view.VOtherillFollow;
import com.jmjk.iservice.IVchronicFollowService;
import com.jmjk.utils.Page;

/**
 * 慢病随访视图接口实现
 * @author 李卓远
 *
 */
@Controller("vchronicFollowService")
public class VchronicFollowService implements IVchronicFollowService {
@Autowired
VCardiovascularFollowDao vcardiovascularfollowdao;
@Autowired
VCoronaryFollowDao vcoronaryfollowdao;
@Autowired
VHypertensiveFollowDao vhypertensivefollowdao;
@Autowired
VDiabetsFollowDao vdiabetsfollowdao;
@Autowired
VMentalFollowDao vmentalfollowdao;
@Autowired
VOtherIllFollowDao votherillfollowdao;
	@Override
	public VCardiovascularFollow getcardfollow(int mbfid, int sqid) {
		// TODO Auto-generated method stub
		String hql = "from VCardiovascularFollow vcf where vcf.chronicFollowId = " + mbfid + " and vcf.communityHospitalId = " + sqid;
		return vcardiovascularfollowdao.Get(hql);
	}

	@Override
	public VCardiovascularFollow getcardfollowForSupper(int mbfid) {
		// TODO Auto-generated method stub
		String hql = "from VCardiovascularFollow vcf where vcf.chronicFollowId = " + mbfid;
		return vcardiovascularfollowdao.Get(hql);
	}
	
	@Override
	public VCoronaryFollow getCoronaryFollow(int mbfid, int sqid) {
		// TODO Auto-generated method stub
		String hql = "from VCoronaryFollow vco where vco.chronicFollowId = " + mbfid + " and vco.communityHospitalId = " + sqid;
		return vcoronaryfollowdao.Get(hql);
	}

	public VCoronaryFollow getCoronaryFollowForSupper(int mbfid) {
		// TODO Auto-generated method stub
		String hql = "from VCoronaryFollow vco where vco.chronicFollowId = " + mbfid;
		return vcoronaryfollowdao.Get(hql);
	}
	
	@Override
	public VDiabetsFollow getDiabetsFollow(int mbfid, int sqid) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mbfid", mbfid);
		params.put("sqid", sqid);
		String hql = "from VDiabetsFollow vdf where vdf.chronicFollowId = :mbfid and vdf.communityHospitalId = :sqid";
		return vdiabetsfollowdao.Get(hql,params);
	}

	@Override
	public VDiabetsFollow getDiabetsFollowForSupper(int mbfid) {
		// TODO Auto-generated method stub
		String hql = "from VDiabetsFollow vdf where vdf.chronicFollowId = " + mbfid;
		return vdiabetsfollowdao.Get(hql);
	}
	
	@Override
	public VHypertensiveFollow getHypertensiveFollow(int mbfid, int sqid) {
		// TODO Auto-generated method stub
		String hql = "from VHypertensiveFollow vhf where vhf.chronicFollowId = " + mbfid + " and vhf.communityHospitalId = " + sqid;
		return vhypertensivefollowdao.Get(hql);
	}

	@Override
	public VHypertensiveFollow getHypertensiveFollowForSupper(int mbfid) {
		// TODO Auto-generated method stub
		String hql = "from VHypertensiveFollow vhf where vhf.chronicFollowId = " + mbfid;
		return vhypertensivefollowdao.Get(hql);
	}
	
	@Override
	public VMentalFollow getMentalFollow(int mbfid, int sqid) {
		// TODO Auto-generated method stub
		String hql = "from VMentalFollow vmf where vmf.chronicFollowId = " + mbfid + " and vmf.communityHospitalId = " + sqid;
		return vmentalfollowdao.Get(hql);
	}

	@Override
	public VMentalFollow getMentalFollowvForSupper(int mbfid) {
		// TODO Auto-generated method stub
		String hql = "from VMentalFollow vmf where vmf.chronicFollowId = " + mbfid;
		return vmentalfollowdao.Get(hql);
	}
	
	@Override
	public VOtherillFollow getOtherillFollow(int mbfid, int sqid) {
		// TODO Auto-generated method stub
		String hql = "from VOtherillFollow vof where vof.chronicFollowId = " + mbfid + " and vof.communityHospitalId = " + sqid;
		return votherillfollowdao.Get(hql);
	}

	@Override
	public VOtherillFollow getOtherillFollowForSupper(int mbfid) {
		// TODO Auto-generated method stub
		String hql = "from VOtherillFollow vof where vof.chronicFollowId = " + mbfid;
		return votherillfollowdao.Get(hql);
	}
	
	@Override
	public List<VCardiovascularFollow> getCardFollowList(int mbid, int sqid,
			Page<VCardiovascularFollow> page) {
		// TODO Auto-generated method stub、
		String hql = "from VCardiovascularFollow vcf where vcf.chronicDiseaseId = " + mbid + " and vcf.communityHospitalId = " + sqid + " order by vcf.chronicFollowId desc";
		List<VCardiovascularFollow> calist = vcardiovascularfollowdao.find(hql , page.getCurrentPage() , page.getPageSize());
		return calist;
	}

	@Override
	public List<VCardiovascularFollow> getCardFollowListForSupper(int mbid,
			Page<VCardiovascularFollow> page) {
		// TODO Auto-generated method stub
		String hql = "from VCardiovascularFollow vcf where vcf.chronicDiseaseId = " + mbid + " order by vcf.chronicFollowId desc";
		List<VCardiovascularFollow> calist = vcardiovascularfollowdao.find(hql , page.getCurrentPage() , page.getPageSize());
		return calist;
	}
	
	@Override
	public long getCardFollowListCount(int mbid) {
		// TODO Auto-generated method stub
		String hql = "select count (vcf.chronicDiseaseId) from VCardiovascularFollow vcf where vcf.chronicDiseaseId= " + mbid;
		return vcardiovascularfollowdao.count(hql);
	}

	@Override
	public List<VCoronaryFollow> getCoronaryFollowList(int mbid, int sqid,
			Page<VCoronaryFollow> page) {
		// TODO Auto-generated method stub
		String hql = "from VCoronaryFollow vco where vco.chronicDiseaseId = " + mbid + " and vco.communityHospitalId = " + sqid + " order by vco.chronicFollowId desc";
		List<VCoronaryFollow> cflist = vcoronaryfollowdao.find(hql , page.getCurrentPage() , page.getPageSize());
		return cflist;
	}
	
	@Override
	public List<VCoronaryFollow> getCoronaryFollowListForSupper(int mbid,
			Page<VCardiovascularFollow> page) {
		// TODO Auto-generated method stub
		String hql = "from VCoronaryFollow vco where vco.chronicDiseaseId = " + mbid + " order by vco.chronicFollowId desc";
		List<VCoronaryFollow> cflist = vcoronaryfollowdao.find(hql , page.getCurrentPage() , page.getPageSize());
		return cflist;
	}

	@Override
	public long getCoronaryFollowListCount(int mbid) {
		// TODO Auto-generated method stub
		String hql = "select count (vco.chronicDiseaseId) from VCoronaryFollow vco where vco.chronicDiseaseId= " + mbid;
		return vcoronaryfollowdao.count(hql);
	}

	@Override
	public List<VDiabetsFollow> getDiabetsFollowList(int mbid, int sqid,
			Page<VDiabetsFollow> page) {
		// TODO Auto-generated method stub
		String hql = "from VDiabetsFollow vdf where vdf.chronicDiseaseId = " + mbid + " and vdf.communityHospitalId = " + sqid + " order by vdf.chronicFollowId desc";
		List<VDiabetsFollow> dialist = vdiabetsfollowdao.find(hql , page.getCurrentPage() , page.getPageSize());
		return dialist;
	}
	
	@Override
	public List<VDiabetsFollow> getDiabetsFollowListForSupper(int mbid,
			Page<VDiabetsFollow> page) {
		// TODO Auto-generated method stub
		String hql = "from VDiabetsFollow vdf where vdf.chronicDiseaseId = " + mbid + " order by vdf.chronicFollowId desc";
		List<VDiabetsFollow> dialist = vdiabetsfollowdao.find(hql , page.getCurrentPage() , page.getPageSize());
		return dialist;
	}

	@Override
	public long getDiabetsFollowListCount(int mbid) {
		// TODO Auto-generated method stub
		String hql = "select count (vdf.chronicDiseaseId) from VDiabetsFollow vdf where vdf.chronicDiseaseId= " + mbid;
		return vdiabetsfollowdao.count(hql);
	}

	@Override
	public List<VHypertensiveFollow> getHypertensiveFollowList(int mbid,
			int sqid, Page<VHypertensiveFollow> page) {
		// TODO Auto-generated method stub
		String hql = "from VHypertensiveFollow vhf where vhf.chronicDiseaseId = " + mbid + " and vhf.communityHospitalId = " + sqid + " order by vhf.chronicFollowId desc";
		List<VHypertensiveFollow> hlist = vhypertensivefollowdao.find(hql , page.getCurrentPage() , page.getPageSize());
		return hlist;
	}
	
	@Override
	public List<VHypertensiveFollow> getHypertensiveFollowListForSupper(
			int mbid, Page<VHypertensiveFollow> page) {
		// TODO Auto-generated method stub
		String hql = "from VHypertensiveFollow vhf where vhf.chronicDiseaseId = " + mbid + " order by vhf.chronicFollowId desc";
		List<VHypertensiveFollow> hlist = vhypertensivefollowdao.find(hql , page.getCurrentPage() , page.getPageSize());
		return hlist;
	}

	@Override
	public long getHypertensiveFollowListCount(int mbid) {
		// TODO Auto-generated method stub
		String hql = "select count (vhf.chronicDiseaseId) from VHypertensiveFollow vhf where vhf.chronicDiseaseId = " + mbid;
		return vhypertensivefollowdao.count(hql);
	}

	@Override
	public List<VMentalFollow> getMentalFollowLIst(int mbid, int sqid,
			Page<VMentalFollow> page) {
		// TODO Auto-generated method stub
		String hql = "from VMentalFollow vmf where vmf.chronicDiseaseId = " + mbid + " and vmf.communityHospitalId = " + sqid + " order by vmf.chronicFollowId desc";
		List<VMentalFollow> mlist = vmentalfollowdao.find(hql ,page.getCurrentPage() , page.getPageSize());
		return mlist;
	}
	
	@Override
	public List<VMentalFollow> getMentalFollowLIstForSupper(int mbid,
			Page<VMentalFollow> page) {
		// TODO Auto-generated method stub
		String hql = "from VMentalFollow vmf where vmf.chronicDiseaseId = " + mbid + " order by vmf.chronicFollowId desc";
		List<VMentalFollow> mlist = vmentalfollowdao.find(hql ,page.getCurrentPage() , page.getPageSize());
		return mlist;
	}

	@Override
	public long getMentalFollowLIstCount(int mbid) {
		// TODO Auto-generated method stub
		String hql = "select count (vmf.chronicDiseaseId) from VMentalFollow vmf where vmf.chronicDiseaseId= " + mbid;
		return vmentalfollowdao.count(hql);
	}

	@Override
	public List<VOtherillFollow> getOtherillFollowList(int mbid, int sqid,
			Page<VOtherillFollow> page) {
		// TODO Auto-generated method stub
		String hql = "from VOtherillFollow vof where vof.chronicDiseaseId = " + mbid + " and vof.communityHospitalId = " + sqid + " order by vof.chronicFollowId desc";
		List<VOtherillFollow> olist = votherillfollowdao.find(hql , page.getCurrentPage() , page.getPageSize());
		return olist;
	}
	
	@Override
	public List<VOtherillFollow> getOtherillFollowListForSupper(int mbid,
			Page<VOtherillFollow> page) {
		// TODO Auto-generated method stub
		String hql = "from VOtherillFollow vof where vof.chronicDiseaseId = " + mbid + " order by vof.chronicFollowId desc";
		List<VOtherillFollow> olist = votherillfollowdao.find(hql , page.getCurrentPage() , page.getPageSize());
		return olist;
	}

	@Override
	public long getOtherillFollowListCount(int mbid) {
		// TODO Auto-generated method stub
		String hql = "select count (vof.chronicDiseaseId) from VOtherillFollow vof where vof.chronicDiseaseId= " + mbid;
		return votherillfollowdao.count(hql);
	}

	

	

	

	

	

	

	

	

	

	

	

	

}
