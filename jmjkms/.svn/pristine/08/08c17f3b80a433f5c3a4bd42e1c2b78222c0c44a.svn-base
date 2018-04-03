package com.jmjk.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.druid.sql.dialect.oracle.ast.stmt.OracleIfStatement.Else;
import com.jmjk.dao.RecoverySchemeDao;
import com.jmjk.entity.TCommunityHospital;
import com.jmjk.entity.TRecoveryScheme;
import com.jmjk.entity.TStaff;
import com.jmjk.enums.Admin_IsHead;
import com.jmjk.enums.IS_DELETE;
import com.jmjk.iservice.IRecoverySchemeService;
import com.jmjk.utils.Page;
import com.jmjk.utils.TypeConverter;
import com.opensymphony.xwork2.ActionContext;

/**
 * 康复方案接口实现
 * 
 * @author wq 2016-08-01
 */
@Controller("recoverySchemeService")
public class RecoverySchemeService implements IRecoverySchemeService {

    @Autowired
    private RecoverySchemeDao recoverySchemeDao;
    
    @Autowired
    private CommunityHospitalService communityHospitalService;
    @Autowired
    private StaffService staffService;

    @Override
    public List<TRecoveryScheme> getAllRecoveryPlanForExport(int hosId) {

        Map<String, Object> params = new HashMap<String, Object>();
        String hql = "";
        if (hosId == -1) {
            params.put("hosId", hosId);
            hql = "from TRecoveryScheme trs where trs.idDelete=" + IS_DELETE.no_Delete.getValue();
        } else if (hosId == -2) {
            hql = "from TRecoveryScheme trs where  trs.type='" + "推荐方案" + "' and trs.idDelete="
                    + IS_DELETE.no_Delete.getValue();
        } else {
            params.put("hosId", hosId);
            hql = "from TRecoveryScheme trs where (trs.communityHospitalId=:hosId or trs.type='" + "推荐方案"
                    + "') and trs.idDelete=" + IS_DELETE.no_Delete.getValue();
        }

        hql += " order by trs.constituteTime desc";
        List<TRecoveryScheme> trs = this.recoverySchemeDao.find(hql, params);
        return trs;
    }

    @Override
    public List<TRecoveryScheme> getAllRecoveryScheme(int HosId, int groupId, Page<TRecoveryScheme> page) {
        Map<String, Object> params = new HashMap<String, Object>();

        String hql = "";
        if (groupId != 0) {

            hql = "from TRecoveryScheme trs where trs.idDelete=" + IS_DELETE.no_Delete.getValue()
                    + " and ((trs.groupId=" + groupId + " and trs.type!='" + "专家方案" + "') or trs.type='" + "专家方案"
                    + "')";
        }

        else if (HosId == -1) {
            hql = "from TRecoveryScheme trs where trs.idDelete=" + IS_DELETE.no_Delete.getValue();
        } else {
            HttpSession session = ServletActionContext.getRequest().getSession();
            TCommunityHospital tCommunityHospital = communityHospitalService.getCommunityHospitalById(HosId);
            int gId = tCommunityHospital.getTCommunityHospitalGroup().getGId();
            hql = "from TRecoveryScheme trs where ((trs.communityHospitalId=" + HosId + " and trs.type='" + "个人方案"
                    + "') or (trs.type='" + "推荐方案" + "' and trs.groupId=" + gId + ") or trs.type='" + "专家方案"
                    + "') and trs.idDelete=" + IS_DELETE.no_Delete.getValue();
        }
        hql += " order by trs.constituteTime desc";
        List<TRecoveryScheme> trs = this.recoverySchemeDao.find(hql, params, page.getCurrentPage(), page.getPageSize());
        return trs;
    }

    @Override
    public long getAllRecoverySchemeCount(int HosId, int groupId) {

        Map<String, Object> params = new HashMap<String, Object>();

        String hql = "";
        if (groupId != 0) {
            params.put("groupId", groupId);

            hql = "select count(*) from TRecoveryScheme trs where trs.idDelete=" + IS_DELETE.no_Delete.getValue()
                    + " and ( (trs.groupId=:groupId and trs.type!='" + "专家方案" + "') or trs.type='" + "专家方案" + "')";
        } else if (HosId == -1) {
            hql = "select count(*) from TRecoveryScheme trs where trs.idDelete=" + IS_DELETE.no_Delete.getValue();

        } else {

            HttpSession session = ServletActionContext.getRequest().getSession();
            TCommunityHospital tCommunityHospital = communityHospitalService.getCommunityHospitalById(HosId);
            int gId = tCommunityHospital.getTCommunityHospitalGroup().getGId();
            params.put("HosId", HosId);
            hql = "select count(*) from TRecoveryScheme trs where ((trs.communityHospitalId=:HosId and trs.type='"
                    + "个人方案" + "') or (trs.type='" + "推荐方案" + "' and trs.groupId=" + gId + ") or trs.type='" + "专家方案"
                    + "')and trs.idDelete=" + IS_DELETE.no_Delete.getValue();
        }
        long count = recoverySchemeDao.count(hql, params);
        return count;
    }

    @Override
    public TRecoveryScheme getRecoverySchemeById(int id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        String hql = "from TRecoveryScheme trs where trs.recoverySchemeId=:id";
        return recoverySchemeDao.Get(hql, params);
    }

    @Override
    public List<TRecoveryScheme> getRecoverySchemeByNameAndType(int hosId, String disease, String type) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("hosId", hosId);
        params.put("disease", disease);
        params.put("type", type);
        String hql = "from TRecoveryScheme trs where trs.communityHospitalId=:hosId and trs.disease=:disease and trs.type=:type and trs.idDelete="
                + IS_DELETE.no_Delete.getValue();
        return recoverySchemeDao.find(hql, params);
    }

    @Override
    public List<TRecoveryScheme> getTuIjianRecoverySchemeByNameAndType(String disease, String type) {
        Map<String, Object> params = new HashMap<String, Object>();
        
        TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext
                .getContext().getSession().get("comHospital");
        if(tCommunityHospital==null){
            TStaff tstaff = (TStaff) ActionContext.getContext().getSession()
                    .get("tstaff");  
            tCommunityHospital=communityHospitalService.getCommunityHospitalById(tstaff.getStaffId());
        }
        int gId=tCommunityHospital.getTCommunityHospitalGroup().getGId();
        params.put("disease", disease);
        params.put("type", type);
        String hql = "from TRecoveryScheme trs where trs.disease=:disease and trs.groupId="+gId +" and trs.type=:type and trs.idDelete="
                + IS_DELETE.no_Delete.getValue();
        return recoverySchemeDao.find(hql, params);
    }

    @Override
    public TRecoveryScheme getRecoverySchemeBySchemeName(String scheme, int comHosId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("scheme", scheme);
        params.put("comHosId", comHosId);
        String hql = "from TRecoveryScheme trs where trs.schemeName=：scheme and trs.communityHospitalId=:comHosId";
        return recoverySchemeDao.Get(hql, params);
    }

    @Override
    public List<TRecoveryScheme> getRecoveryScheme(TRecoveryScheme scheme, int groupId, Page<TRecoveryScheme> page) {
        // 集团
        if (groupId != 0) {

            String hql = "from TRecoveryScheme trs";
            if (scheme.getSchemeName() != null && !scheme.getSchemeName().equals("")) // 康复方案名称不为空时
            {
                hql += " where trs.schemeName like '%" + scheme.getSchemeName() + "%'";
                if (scheme.getType().equals("")) {
                    hql += " and  ((trs.groupId=" + groupId + " and trs.type!='" + "专家方案" + "') or trs.type='" + "专家方案"
                            + "')";
                } else if (scheme.getType().equals("专家方案")) {
                    hql += " and trs.type ='" + scheme.getType() + "'";
                } else if (scheme.getType().equals("推荐方案")) {
                    hql += " and trs.groupId=" + groupId + "and trs.type ='" + scheme.getType() + "'";
                } else if (scheme.getType().equals("个人方案")) {
                    hql += " and trs.groupId=" + groupId + " and trs.type ='" + scheme.getType() + "'";
                }
            }
            if (scheme.getTStaff().getName() != null && !scheme.getTStaff().getName().equals(""))// 指定人不为空时
            {
                if (scheme.getType().equals("")) {
                    hql += " where trs.note like '%" + scheme.getTStaff().getName() + "%'";
                    hql += " and  ((trs.groupId=" + groupId + " and trs.type!='" + "专家方案" + "') or trs.type='" + "专家方案"
                            + "')";
                } else if (scheme.getType().equals("专家方案")) {
                    hql += " where trs.note like '%" + scheme.getTStaff().getName() + "%'" + " and trs.type ='"
                            + scheme.getType() + "'";
                } else if (scheme.getType().equals("推荐方案")) {
                    hql += " where trs.groupId=" + groupId + " and trs.note like '%" + scheme.getTStaff().getName()
                            + "%' and trs.type ='" + scheme.getType() + "'";
                } else if (scheme.getType().equals("个人方案")) {
                    hql += " where trs.groupId=" + groupId + " and trs.note like '%" + scheme.getTStaff().getName()
                            + "%' and trs.type ='" + scheme.getType() + "'";
                }
            }
            if ((scheme.getSchemeName() == null || scheme.getSchemeName().equals(""))
                    && (scheme.getTStaff().getName() == null || scheme.getTStaff().getName().equals(""))) {
                if (scheme.getType().equals("")) {
                    hql += " where  ((trs.groupId=" + groupId + " and trs.type!='" + "专家方案" + "') or trs.type='"
                            + "专家方案" + "')";
                } else {
                    if (scheme.getType().equals("专家方案")) {
                        hql += " where";
                    } else {
                        hql += " where trs.groupId=" + groupId + " and";
                    }
                    hql += " trs.type ='" + scheme.getType() + "'";
                }
            }
            hql += " and trs.idDelete=" + IS_DELETE.no_Delete.getValue();
            hql += " order by trs.constituteTime desc";
            List<TRecoveryScheme> trs = this.recoverySchemeDao.find(hql, page.getCurrentPage(), page.getPageSize());

            return trs;
        } else {// 系统管理员或者社区负责人
            HttpSession session = ServletActionContext.getRequest().getSession();
            TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext.getContext().getSession()
                    .get("comHospital");
            int gId = 0;
            String hql = "from TRecoveryScheme trs";
            // 系统管理员
            if (tCommunityHospital.getIsHead() == Admin_IsHead.guanliyuan.getValue()) {
                if (scheme.getSchemeName() != null && !scheme.getSchemeName().equals("")) // 康复方案名称不为空时
                {
                    hql += " where trs.schemeName like '%" + scheme.getSchemeName() + "%'";
                    // hql += " and trs.type ='"+scheme.getType()+"'";
                    // 改可能的问题
                    /*
                     * String[] str = scheme.getType().split(","); hql +=
                     * " where (trs.type = '" + str[0] + "' or trs.type='" +
                     * str[1] + "') ";
                     */
                    if (scheme.getType().equals("")) {
                    } else if (scheme.getType().equals("专家方案")) {
                        hql += " and trs.type ='" + scheme.getType() + "'";
                    } else if (scheme.getType().equals("推荐方案")) {
                        hql += " and trs.type ='" + scheme.getType() + "'";
                    } else if (scheme.getType().equals("个人方案")) {
                        hql += " and trs.type ='" + scheme.getType() + "'";
                    }

                }

                if (scheme.getTStaff().getName() != null && !scheme.getTStaff().getName().equals(""))// 指定人不为空时
                {
                    if (scheme.getType().equals("专家方案")) {
                        hql += " where trs.note like '%" + scheme.getTStaff().getName() + "%'";
                    } else if (scheme.getType().equals("推荐方案")) {
                        hql += " where trs.note like '%" + scheme.getTStaff().getName() + "%'";
                    } else {
                        hql += " where trs.TStaff.name like '%" + scheme.getTStaff().getName() + "%'";
                    }
                    hql += " and trs.type ='" + scheme.getType() + "'";

                }

                if ((scheme.getSchemeName() == null || scheme.getSchemeName().equals(""))
                        && (scheme.getTStaff().getName() == null || scheme.getTStaff().getName().equals(""))) {

                    String[] str = scheme.getType().split(",");
                    if (str.length == 0) {
                        hql += " where  ((trs.groupId=" + gId + " and trs.type='" + "推荐方案"
                                + "') or((trs.communityHospitalId=" + tCommunityHospital.getCommunityHospitalId()
                                + " and trs.type='" + "个人方案" + "') or trs.type='" + "专家方案" + "')";
                        ;
                    } else if (str.length == 1) {
                        if (scheme.getType().equals("专家方案")) {
                            hql += " where trs.type ='" + str[0] + "'";
                        } else if (scheme.getType().equals("推荐方案")) {
                            hql += " where trs.groupId=" + gId + " and trs.type ='" + str[0] + "'";
                        } else if (scheme.getType().equals("个人方案")) {
                            hql += " where trs.communityHospitalId=" + scheme.getCommunityHospitalId()
                                    + " and trs.type ='" + str[0] + "'";
                        }
                    } else if (str.length == 2) {
                        hql += " where (";
                        for (int i = 0; i < str.length; i++) {
                            if (str[i].equals("专家方案")) {
                                hql += " (trs.type ='" + str[i] + "')";
                            } else if (str[i].equals("推荐方案")) {
                                hql += " (trs.groupId=" + gId + " and trs.type ='" + str[i] + "')";
                            }
                            if (i < str.length - 1) {
                                hql += " or";
                            } else {
                                hql += ")";
                            }
                        }
                    }

                }
            } else {// 社区负责人
                gId = tCommunityHospital.getTCommunityHospitalGroup().getGId();
                if (scheme.getSchemeName() != null && !scheme.getSchemeName().equals("")) // 康复方案名称不为空时
                {
                    hql += " where trs.schemeName like '%" + scheme.getSchemeName() + "%'";
                    if (scheme.getType().equals("")) {
                        hql += " and  ((trs.groupId=" + gId + " and trs.type='" + "推荐方案"
                                + "') or((trs.communityHospitalId=" + tCommunityHospital.getCommunityHospitalId()
                                + " and trs.type='" + "个人方案" + "') or trs.type='" + "专家方案" + "')";
                    } else if (scheme.getType().equals("专家方案")) {
                        hql += " and trs.type ='" + scheme.getType() + "'";
                    } else if (scheme.getType().equals("推荐方案")) {
                        hql += " and trs.groupId=" + gId + " and trs.type ='" + scheme.getType() + "'";
                    } else if (scheme.getType().equals("个人方案")) {
                        hql += " and trs.communityHospitalId=" + scheme.getCommunityHospitalId() + " and trs.type ='"
                                + scheme.getType() + "'";
                    }

                }

                if (scheme.getTStaff().getName() != null && !scheme.getTStaff().getName().equals(""))// 指定人不为空时
                {
                    if (scheme.getType().equals("")) {
                        hql += " and  ((trs.groupId=" + gId + " and trs.type='" + "推荐方案"
                                + "') or((trs.communityHospitalId=" + tCommunityHospital.getCommunityHospitalId()
                                + " and trs.type='" + "个人方案" + "') or trs.type='" + "专家方案" + "')";
                    } else if (scheme.getType().equals("专家方案")) {
                        hql += " where trs.note like '%" + scheme.getTStaff().getName() + "%'";
                    } else if (scheme.getType().equals("推荐方案")) {
                        hql += " where trs.note like '%" + scheme.getTStaff().getName() + "%' and trs.groupId=" + gId;
                    } else {
                        hql += " where trs.TStaff.name like '%" + scheme.getTStaff().getName()
                                + "%' and trs.communityHospitalId=" + scheme.getCommunityHospitalId();
                    }
                    hql += " and trs.type ='" + scheme.getType() + "'";

                }

                if ((scheme.getSchemeName() == null || scheme.getSchemeName().equals(""))
                        && (scheme.getTStaff().getName() == null || scheme.getTStaff().getName().equals(""))) {

                    String[] str = scheme.getType().split(",");
                    if (str.length == 0) {
                        hql += " where  ((trs.groupId=" + gId + " and trs.type='" + "推荐方案"
                                + "') or((trs.communityHospitalId=" + tCommunityHospital.getCommunityHospitalId()
                                + " and trs.type='" + "个人方案" + "') or trs.type='" + "专家方案" + "')";
                        ;
                    } else if (str.length == 1) {
                        if (scheme.getType().equals("专家方案")) {
                            hql += " where trs.type ='" + str[0] + "'";
                        } else if (scheme.getType().equals("推荐方案")) {
                            hql += " where trs.groupId=" + gId + " and trs.type ='" + str[0] + "'";
                        } else if (scheme.getType().equals("个人方案")) {
                            hql += " where trs.communityHospitalId=" + scheme.getCommunityHospitalId()
                                    + " and trs.type ='" + str[0] + "'";
                        }
                    } else if (str.length == 2) {
                        hql += " where (";
                        for (int i = 0; i < str.length; i++) {
                            if (str[i].equals("专家方案")) {
                                hql += " (trs.type ='" + str[i] + "')";
                            } else if (str[i].equals("推荐方案")) {
                                hql += " (trs.groupId=" + gId + " and trs.type ='" + str[i] + "')";
                            }
                            if (i < str.length - 1) {
                                hql += " or";
                            } else {
                                hql += ")";
                            }
                        }
                    }

                }
            }

            hql += "and trs.idDelete=" + IS_DELETE.no_Delete.getValue();
            hql += " order by trs.constituteTime desc";
            List<TRecoveryScheme> trs = this.recoverySchemeDao.find(hql, page.getCurrentPage(), page.getPageSize());

            return trs;
        }

    }

    @Override
    public List<TRecoveryScheme> getExpertRecoveryScheme(TRecoveryScheme scheme, int groupId,
            Page<TRecoveryScheme> page) {
        // 集团
        if (groupId != 0) {
            String hql = "from TRecoveryScheme trs";
            if (scheme.getSchemeName() != null && !scheme.getSchemeName().equals("")) // 康复方案名称不为空时
            {
                hql += " where trs.schemeName like '%" + scheme.getSchemeName() + "%'";

                if (scheme.getType().equals("")) {
                    hql += " and  ((trs.groupId=" + groupId + " and trs.type!='" + "专家方案" + "') or trs.type='" + "专家方案"
                            + "')";
                } else {
                    String[] str = scheme.getType().split(",");
                    int changdu = str.length;
                    if (changdu == 1) {
                        hql += " and (";
                        if (str[0].equals("推荐方案")) {
                            hql += " (trs.groupId=" + groupId + " and trs.type = '" + str[0] + "')";
                        } else if (str[0].equals("专家方案")) {
                            hql += " (trs.type = '" + str[0] + "')";
                        } else if (str[0].equals("个人方案")) {
                            hql += " and trs.groupId=" + groupId + " and trs.type = '" + str[0] + "'";
                        }
                        hql += ")";
                    } else if (changdu == 2) {
                        hql += " and (";
                        for (int i = 0; i < str.length; i++) {
                            if (str[i].equals("推荐方案")) {
                                hql += " (trs.groupId=" + groupId + " and trs.type = '" + str[i] + "')";
                            } else if (str[i].equals("专家方案")) {
                                hql += " (trs.type = '" + str[i] + "')";
                            } else if (str[i].equals("个人方案")) {
                                hql += " and trs.groupId=" + groupId + " and trs.type = '" + str[i] + "'";
                            }
                            if (i < str.length - 1) {
                                hql += " or";
                            } else
                                hql += ")";
                        }
                    }
                }

            }
            if (scheme.getTStaff().getName() != null && !scheme.getTStaff().getName().equals(""))// 指定人不为空时
            {
                if (scheme.getType().equals("")) {

                } else {
                    String[] str = scheme.getType().split(",");
                    int changdu = str.length;
                    if (changdu == 1) {
                        hql += " where trs.note like '%" + scheme.getTStaff().getName() + "%' and (";
                        if (str[0].equals("推荐方案")) {
                            hql += " (trs.groupId=" + groupId + " and trs.type = '" + str[0] + "')";
                        } else if (str[0].equals("专家方案")) {
                            hql += " (trs.type = '" + str[0] + "')";
                        } else if (str[0].equals("个人方案")) {
                            hql += " and trs.groupId=" + groupId + " and trs.type = '" + str[0] + "'";
                        }
                        hql += ")";
                    } else if (changdu == 2) {
                        hql += " where trs.note like '%" + scheme.getTStaff().getName() + "%' and (";
                        for (int i = 0; i < str.length; i++) {
                            if (str[i].equals("推荐方案")) {
                                hql += " (trs.groupId=" + groupId + " and trs.type = '" + str[i] + "')";
                            } else if (str[i].equals("专家方案")) {
                                hql += " (trs.type = '" + str[i] + "')";
                            } else if (str[i].equals("个人方案")) {
                                hql += " and trs.groupId=" + groupId + " and trs.type = '" + str[i] + "'";
                            }
                            if (i < str.length - 1) {
                                hql += " or";
                            } else
                                hql += ")";
                        }
                    }
                }

            }
            if ((scheme.getSchemeName() == null || scheme.getSchemeName().equals(""))
                    && (scheme.getTStaff().getName() == null || scheme.getTStaff().getName().equals(""))) {
                if (scheme.getType().equals("")) {

                } else {
                    String[] str = scheme.getType().split(",");
                    int changdu = str.length;
                    if (changdu == 1) {
                        hql += " where (";
                        if (str[0].equals("推荐方案")) {
                            hql += " (trs.groupId=" + groupId + " and trs.type = '" + str[0] + "')";
                        } else if (str[0].equals("专家方案")) {
                            hql += " (trs.type = '" + str[0] + "')";
                        } else if (str[0].equals("个人方案")) {
                            hql += " and trs.groupId=" + groupId + " and trs.type = '" + str[0] + "'";
                        }
                        hql += ")";
                    } else if (changdu == 2) {
                        hql += " where (";
                        for (int i = 0; i < str.length; i++) {
                            if (str[i].equals("推荐方案")) {
                                hql += " (trs.groupId=" + groupId + " and trs.type = '" + str[i] + "')";
                            } else if (str[i].equals("专家方案")) {
                                hql += " (trs.type = '" + str[i] + "')";
                            } else if (str[i].equals("个人方案")) {
                                hql += " and trs.groupId=" + groupId + " and trs.type = '" + str[i] + "'";
                            }
                            if (i < str.length - 1) {
                                hql += " or";
                            } else
                                hql += ")";
                        }
                    }
                }
            }
            if (scheme.getCommunityHospitalId() != null && scheme.getCommunityHospitalId() != -1) {
                if (scheme.getType().equals("专家方案")) {

                } else if (scheme.getType().equals("推荐方案")) {
                    hql += "and trs.groupId=" + groupId;
                } else {
                    hql += "and trs.communityHospitalId=" + scheme.getCommunityHospitalId();
                }

            }
            hql += " and trs.idDelete=" + IS_DELETE.no_Delete.getValue();
            hql += " order by trs.constituteTime desc";
            List<TRecoveryScheme> trs = this.recoverySchemeDao.find(hql, page.getCurrentPage(), page.getPageSize());
            return trs;
        }

        // 系统管理员
        else if (scheme.getCommunityHospitalId() == -1) {

            String hql = "from TRecoveryScheme trs";
            if (scheme.getSchemeName() != null && !scheme.getSchemeName().equals("")) // 康复方案名称不为空时
            {
                hql += " where trs.schemeName like '%" + scheme.getSchemeName() + "%'";
                if (scheme.getType().equals("")) {

                } else {
                    String[] str = scheme.getType().split(",");
                    int changdu = str.length;
                    if (changdu == 1) {
                        hql += " and trs.type = '" + str[0] + "'  ";
                    } else if (changdu == 2) {
                        hql += " and (trs.type = '" + str[0] + "' or trs.type='" + str[1] + "') ";
                    }
                }
            }
            if (scheme.getTStaff().getName() != null && !scheme.getTStaff().getName().equals(""))// 指定人不为空时
            {
                if (scheme.getType().equals("专家方案")) {
                    hql += " where trs.note like '%" + scheme.getTStaff().getName() + "%'";
                } else if (scheme.getType().equals("推荐方案")) {
                    hql += " where trs.note like '%" + scheme.getTStaff().getName() + "%'";
                } else {
                    // hql += " and trs.TStaff.name like
                    // '%"+scheme.getTStaff().getName()+"%'";
                    // 社区管理员用
                    hql += " where trs.note like '%" + scheme.getTStaff().getName() + "%'";
                }
                // hql += " and trs.type ='"+scheme.getType()+"'" ;
                if (scheme.getType().equals("")) {

                } else {
                    String[] str = scheme.getType().split(",");
                    int changdu = str.length;
                    if (changdu == 1) {
                        hql += " and trs.type = '" + str[0] + "'  ";
                    } else if (changdu == 2) {
                        hql += " and (trs.type = '" + str[0] + "' or trs.type='" + str[1] + "') ";
                    }
                }

            }
            if ((scheme.getSchemeName() == null || scheme.getSchemeName().equals(""))
                    && (scheme.getTStaff().getName() == null || scheme.getTStaff().getName().equals(""))) {

                if (scheme.getType().equals("")) {
                    hql += " where trs.idDelete=" + IS_DELETE.no_Delete.getValue();
                    hql += " order by trs.constituteTime desc";
                    List<TRecoveryScheme> trs = this.recoverySchemeDao.find(hql, page.getCurrentPage(), page.getPageSize());
                    return trs;
                } else {
                    String[] str = scheme.getType().split(",");
                    int changdu = str.length;
                    if (changdu == 1) {
                        hql += " where trs.type = '" + str[0] + "'  ";
                    } else if (changdu == 2) {
                        hql += " where (trs.type = '" + str[0] + "' or trs.type='" + str[1] + "') ";
                    }
                }
            }
            hql += " and trs.idDelete=" + IS_DELETE.no_Delete.getValue();
            hql += " order by trs.constituteTime desc";
            List<TRecoveryScheme> trs = this.recoverySchemeDao.find(hql, page.getCurrentPage(), page.getPageSize());
            return trs;
        }
        // 社区负责人
        else {
            String hql = "from TRecoveryScheme trs";
            HttpSession session = ServletActionContext.getRequest().getSession();
            TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext
                    .getContext().getSession().get("comHospital");
            if(tCommunityHospital==null){
                TStaff tstaff = (TStaff) ActionContext.getContext().getSession()
                        .get("tstaff");
                tCommunityHospital = communityHospitalService.getCommunityHospitalById(staffService.getCommHospitalByStaffId(tstaff.getStaffId()));
            }
            
            int gId = tCommunityHospital.getTCommunityHospitalGroup().getGId();

            if (scheme.getSchemeName() != null && !scheme.getSchemeName().equals("")) // 康复方案名称不为空时
            {
                hql += " where trs.schemeName like '%" + scheme.getSchemeName() + "%'";
                if (scheme.getType().equals("")) {
                    hql += " and  ((trs.groupId=" + gId + " and trs.type='" + "推荐方案" + "') or(trs.communityHospitalId="
                            + tCommunityHospital.getCommunityHospitalId() + " and trs.type='" + "个人方案"
                            + "') or trs.type='" + "专家方案" + "')";
                } else if (scheme.getType().equals("专家方案")) {
                    hql += " and trs.type ='" + scheme.getType() + "'";
                } else if (scheme.getType().equals("推荐方案")) {
                    hql += " and trs.groupId=" + gId + "and trs.type ='" + scheme.getType() + "'";
                } else if (scheme.getType().equals("个人方案")) {
                    hql += " and trs.communityHospitalId=" + scheme.getCommunityHospitalId() + " and trs.type ='"
                            + scheme.getType() + "'";
                }
            }
            if (scheme.getTStaff().getName() != null && !scheme.getTStaff().getName().equals(""))// 指定人不为空时
            {
                if (scheme.getType().equals("专家方案")) {
                    hql += " where trs.note like '%" + scheme.getTStaff().getName() + "%'";
                    hql += " and trs.type ='" + scheme.getType() + "'";
                } else if (scheme.getType().equals("推荐方案")) {
                    hql += " where trs.groupId=" + gId + " and trs.note like '%" + scheme.getTStaff().getName() + "%'";
                    hql += " and trs.type ='" + scheme.getType() + "'";
                } else if (scheme.getType().equals("个人方案")) {
                    hql += " where trs.communityHospitalId=" + scheme.getCommunityHospitalId() + " and trs.note like '%"
                            + scheme.getTStaff().getName() + "%'";
                    hql += " and trs.type ='" + scheme.getType() + "'";
                } else {
                    hql += " where trs.TStaff.name like '%" + scheme.getTStaff().getName() + "%'";
                }
            }

            if ((scheme.getSchemeName() == null || scheme.getSchemeName().equals(""))
                    && (scheme.getTStaff().getName() == null || scheme.getTStaff().getName().equals(""))) {

                if (scheme.getType().equals("")) {
                    hql+= " where  ((trs.groupId=" + gId + " and trs.type='" + "推荐方案" + "') or (trs.communityHospitalId=" + tCommunityHospital.getCommunityHospitalId() + " and trs.type='" + "个人方案" + "') or trs.type='" + "专家方案"
                            + "')";

                } else if (scheme.getType().equals("专家方案")) {
                    hql += " where trs.type ='" + scheme.getType() + "'";
                } else if (scheme.getType().equals("推荐方案")) {
                    hql += " where trs.groupId=" + gId + " and trs.type ='" + scheme.getType() + "'";
                } else if (scheme.getType().equals("个人方案")) {
                    hql += " where trs.communityHospitalId=" + scheme.getCommunityHospitalId() + " and trs.type ='"
                            + scheme.getType() + "'";
                }
            }
            hql += " and trs.idDelete=" + IS_DELETE.no_Delete.getValue();
            hql += " order by trs.constituteTime desc";
            List<TRecoveryScheme> trs = this.recoverySchemeDao.find(hql, page.getCurrentPage(), page.getPageSize());
            return trs;
        }
    }

    @Override
    public long getExpertRecoverySchemeCountBySearch(TRecoveryScheme scheme, int groupId) {
        if (groupId != 0) {

            String hql = "select count(*) from TRecoveryScheme trs ";
            if (scheme.getSchemeName() != null && !scheme.getSchemeName().equals("")) // 康复方案名称不为空时
            {
                hql += " where trs.schemeName like '%" + scheme.getSchemeName() + "%'";
                String[] str = scheme.getType().split(",");
                if (str.length != 0) {
                    hql += " and (";
                }
                for (int i = 0; i < str.length; i++) {
                    if (str[i].equals("推荐方案")) {
                        hql += " (trs.groupId=" + groupId + " and trs.type = '" + str[i] + "')";
                    } else if (str[i].equals("专家方案")) {
                        hql += " (trs.type = '" + str[i] + "')";
                    } else if (str[i].equals("个人方案")) {
                        hql += " and trs.groupId=" + groupId + " and trs.type = '" + str[i] + "'";
                    }
                    if (i < str.length - 1) {
                        hql += " or";
                    } else
                        hql += ")";
                }
                // hql +=" and (trs.type = '"+str[0]+"' or
                // trs.type='"+str[1]+"') ";

                // hql += " and trs.type ='"+scheme.getType()+"'" ;
            } else if (scheme.getTStaff().getName() != null && !scheme.getTStaff().getName().equals(""))// 指定人不为空时
            {
                if (scheme.getType().equals("专家方案")) {
                    hql += " where trs.note like '%" + scheme.getTStaff().getName() + "%'";

                } else if (scheme.getType().equals("推荐方案")) {
                    hql += " where trs.groupId=" + groupId + " and trs.note like '%" + scheme.getTStaff().getName()
                            + "%'";

                } else if (scheme.getType().equals("个人方案")) {
                    hql += " where trs.groupId=" + groupId + " and trs.note like '%" + scheme.getTStaff().getName()
                            + "%'";

                } else {
                    // hql += " and trs.TStaff.name like
                    // '%"+scheme.getTStaff().getName()+"%'";
                    hql += " where trs.note like '%" + scheme.getTStaff().getName() + "%'";
                }
                // hql += " and trs.type ='"+scheme.getType()+"'" ;
                String[] str = scheme.getType().split(",");
                if (str.length != 0) {
                    hql += " and (";
                }
                for (int i = 0; i < str.length; i++) {
                    if (str[i].equals("推荐方案")) {
                        hql += " (trs.groupId=" + groupId + " and trs.type = '" + str[i] + "')";
                    } else if (str[i].equals("专家方案")) {
                        hql += " (trs.type = '" + str[i] + "')";
                    } else if (str[i].equals("个人方案")) {
                        hql += " and trs.groupId=" + groupId + " and trs.type = '" + str[i] + "'";
                    }
                    if (i < str.length - 1) {
                        hql += " or";
                    } else
                        hql += ")";
                }

            }
            if ((scheme.getSchemeName() == null || scheme.getSchemeName().equals(""))
                    && (scheme.getTStaff().getName() == null || scheme.getTStaff().getName().equals(""))) {

                String[] str = scheme.getType().split(",");
                if (str.length != 0) {
                    hql += " where (";
                }
                for (int i = 0; i < str.length; i++) {
                    if (str[i].equals("推荐方案")) {
                        hql += " (trs.groupId=" + groupId + " and trs.type = '" + str[i] + "')";
                    } else if (str[i].equals("专家方案")) {
                        hql += " (trs.type = '" + str[i] + "')";
                    } else if (str[i].equals("个人方案")) {
                        hql += " and trs.groupId=" + groupId + " and trs.type = '" + str[i] + "'";
                    }
                    if (i < str.length - 1) {
                        hql += " or";
                    } else
                        hql += ")";
                }
                // hql +=" where (trs.type = '"+str[0]+"' or
                // trs.type='"+str[1]+"') ";

                // hql += " and trs.type ='"+scheme.getType()+"'" ;
            }

            if (scheme.getCommunityHospitalId() != null && scheme.getCommunityHospitalId() != -1) {

                if (scheme.getType().equals("推荐方案")) {

                } else if (scheme.getType().equals("个人方案")) {

                } else if (scheme.getType().equals("专家方案")) {

                } else {
                    hql += "and trs.communityHospitalId=" + scheme.getCommunityHospitalId();
                }
            }
            hql += "and trs.idDelete=" + IS_DELETE.no_Delete.getValue();
            return recoverySchemeDao.count(hql);

        } else {

            String hql = "select count(*) from TRecoveryScheme trs";
            if (scheme.getSchemeName() != null && !scheme.getSchemeName().equals("")) // 康复方案名称不为空时
            {
                hql += " where trs.schemeName like '%" + scheme.getSchemeName() + "%'";
                // hql += " and trs.type ='"+scheme.getType()+"'" ;

                String[] str = scheme.getType().split(",");
                hql += " and (trs.type = '" + str[0] + "' or trs.type='" + str[1] + "') ";

            }
            if (scheme.getTStaff().getName() != null && !scheme.getTStaff().getName().equals(""))// 指定人不为空时
            {
                if (scheme.getType().equals("专家方案")) {
                    hql += " where trs.note like '%" + scheme.getTStaff().getName() + "%'";

                } else if (scheme.getType().equals("推荐方案")) {
                    hql += " where trs.note like '%" + scheme.getTStaff().getName() + "%'";

                } else if (scheme.getType().equals("个人方案")) {
                    hql += " where trs.note like '%" + scheme.getTStaff().getName() + "%'";

                } else {
                    hql += " where trs.TStaff.name like '%" + scheme.getTStaff().getName() + "%'";
                }
                hql += " and trs.type ='" + scheme.getType() + "'";
            }
            if ((scheme.getSchemeName() == null || scheme.getSchemeName().equals(""))
                    && (scheme.getTStaff().getName() == null || scheme.getTStaff().getName().equals(""))) {

                String[] str = scheme.getType().split(",");
                hql += " where (trs.type = '" + str[0] + "' or trs.type='" + str[1] + "') ";

            }
            if (scheme.getCommunityHospitalId() != -1) {
                if (scheme.getType().equals("专家方案") || scheme.getType().equals("推荐方案")) {

                }

                else {
                    hql += "and trs.communityHospitalId=" + scheme.getCommunityHospitalId();
                }
            }
            hql += "and trs.idDelete=" + IS_DELETE.no_Delete.getValue();
            return recoverySchemeDao.count(hql);
        }
    }

    @Override
    public long getRecoverySchemeCountBySearch(TRecoveryScheme scheme, int groupId) {
        // 集团
        if (groupId != 0) {

            String hql = "select count(*) from TRecoveryScheme trs";
            if (scheme.getSchemeName() != null && !scheme.getSchemeName().equals("")) // 康复方案名称不为空时
            {

                hql += " where trs.schemeName like '%" + scheme.getSchemeName() + "%'";
                if (scheme.getType().equals("")) {
                    hql += " and  ((trs.groupId=" + groupId + " and trs.type!='" + "专家方案" + "') or trs.type='" + "专家方案"
                            + "')";
                } else if (scheme.getType().equals("专家方案")) {
                    hql += " and trs.type ='" + scheme.getType() + "'";
                } else if (scheme.getType().equals("推荐方案")) {
                    hql += " and trs.groupId=" + groupId + "and trs.type ='" + scheme.getType() + "'";
                } else if (scheme.getType().equals("个人方案")) {
                    hql += " and trs.groupId=" + groupId + " and trs.type ='" + scheme.getType() + "'";
                }
            } else if (scheme.getTStaff().getName() != null && !scheme.getTStaff().getName().equals(""))// 指定人不为空时
            {
                if (scheme.getType().equals("专家方案")) {
                    hql += " where trs.note like '%" + scheme.getTStaff().getName() + "%'";
                    hql += " and trs.type ='" + scheme.getType() + "'";
                } else if (scheme.getType().equals("推荐方案")) {
                    hql += " where trs.groupId=" + groupId + " and trs.note like '%" + scheme.getTStaff().getName()
                            + "%'";
                    hql += " and trs.type ='" + scheme.getType() + "'";
                } else if (scheme.getType().equals("个人方案")) {
                    hql += " where trs.groupId=" + groupId + " and trs.note like '%" + scheme.getTStaff().getName()
                            + "%'";
                    hql += " and trs.type ='" + scheme.getType() + "'";
                } else {
                    hql += " where  ((trs.groupId=" + groupId + " and trs.type!='" + "专家方案" + "') or trs.type='"
                            + "专家方案" + "')";
                    hql += " and trs.TStaff.name like '%" + scheme.getTStaff().getName() + "%'";
                }

            }
            if ((scheme.getSchemeName() == null || scheme.getSchemeName().equals(""))
                    && (scheme.getTStaff().getName() == null || scheme.getTStaff().getName().equals(""))) {
                /*
                 * String [] str = scheme.getType().split(","); hql
                 * +=" and (trs.type = '"+str[0]+"' or trs.type='"+str[1]+"') ";
                 */
                if (scheme.getType().equals("")) {
                    hql += " where  ((trs.groupId=" + groupId + " and trs.type!='" + "专家方案" + "') or trs.type='"
                            + "专家方案" + "')";
                } else {
                    if (scheme.getType().equals("专家方案")) {
                        hql += " where ";
                    } else if (scheme.getType().equals("推荐方案")) {
                        hql += " where trs.groupId=" + groupId + " and";
                    } else {
                        hql += " where trs.groupId=" + groupId + " and";
                    }
                    hql += " trs.type ='" + scheme.getType() + "'";
                }
            }
            hql += " and trs.idDelete=" + IS_DELETE.no_Delete.getValue();
            return recoverySchemeDao.count(hql);

        } else {// 系统管理员或者社区负责人
            String hql = "select count(*) from TRecoveryScheme trs";
            HttpSession session = ServletActionContext.getRequest().getSession();
            TCommunityHospital tCommunityHospital = (TCommunityHospital) ActionContext
                    .getContext().getSession().get("comHospital");
            int gId = 0;
            // 系统管理员
            if (tCommunityHospital!=null&&tCommunityHospital.getIsHead() == Admin_IsHead.guanliyuan.getValue()) {

                if (scheme.getSchemeName() != null && !scheme.getSchemeName().equals("")) // 康复方案名称不为空时
                {
                    hql += " where trs.schemeName like '%" + scheme.getSchemeName() + "%'";
                    if (scheme.getType().equals("")) {

                    } else
                        hql += " and trs.type ='" + scheme.getType() + "'";
                }
                if (scheme.getTStaff().getName() != null && !scheme.getTStaff().getName().equals(""))// 指定人不为空时
                {
                    if (scheme.getType().equals("专家方案")) {
                        hql += " where trs.note like '%" + scheme.getTStaff().getName() + "%'";
                        hql += " and trs.type ='" + scheme.getType() + "'";
                    } else if (scheme.getType().equals("推荐方案")) {
                        hql += " where trs.note like '%" + scheme.getTStaff().getName() + "%'";
                        hql += " and trs.type ='" + scheme.getType() + "'";
                    } else if (scheme.getType().equals("个人方案")) {
                        hql += " where trs.note like '%" + scheme.getTStaff().getName() + "%'";
                        hql += " and trs.type ='" + scheme.getType() + "'";
                    } else {
                        hql += " where trs.TStaff.name like '%" + scheme.getTStaff().getName() + "%'";
                    }
                }

                if ((scheme.getSchemeName() == null || scheme.getSchemeName().equals(""))
                        && (scheme.getTStaff().getName() == null || scheme.getTStaff().getName().equals(""))) {

                    if (scheme.getType().equals("")) {
                        hql+=" where trs.idDelete=" + IS_DELETE.no_Delete.getValue();
                        return recoverySchemeDao.count(hql);
                    } else
                        hql += " where trs.type ='" + scheme.getType() + "'";
                }

                hql += " and trs.idDelete=" + IS_DELETE.no_Delete.getValue();

            }
            // 社区负责人
            else {
                if(tCommunityHospital==null){
                    TStaff tstaff = (TStaff) ActionContext.getContext().getSession()
                            .get("tstaff");
                    tCommunityHospital = communityHospitalService.getCommunityHospitalById(staffService.getCommHospitalByStaffId(tstaff.getStaffId()));
                }
                gId = tCommunityHospital.getTCommunityHospitalGroup().getGId();

                if (scheme.getSchemeName() != null && !scheme.getSchemeName().equals("")) // 康复方案名称不为空时
                {
                    hql += " where trs.schemeName like '%" + scheme.getSchemeName() + "%'";
                    if (scheme.getType().equals("")) {
                        hql += " and  ((trs.groupId=" + gId + " and trs.type='" + "推荐方案"
                                + "') or (trs.communityHospitalId=" + tCommunityHospital.getCommunityHospitalId()
                                + " and trs.type='" + "个人方案" + "') or trs.type='" + "专家方案" + "')";
                    } else if (scheme.getType().equals("专家方案")) {
                        hql += " and trs.type ='" + scheme.getType() + "'";
                    } else if (scheme.getType().equals("推荐方案")) {
                        hql += " and trs.groupId=" + gId + "and trs.type ='" + scheme.getType() + "'";
                    } else if (scheme.getType().equals("个人方案")) {
                        hql += " and trs.communityHospitalId=" + tCommunityHospital.getCommunityHospitalId()
                                + " and trs.type ='" + scheme.getType() + "'";
                    }
                }
                if (scheme.getTStaff().getName() != null && !scheme.getTStaff().getName().equals(""))// 指定人不为空时
                {
                    if (scheme.getType().equals("专家方案")) {
                        hql += " where trs.note like '%" + scheme.getTStaff().getName() + "%'";
                        hql += " and trs.type ='" + scheme.getType() + "'";
                    } else if (scheme.getType().equals("推荐方案")) {
                        hql += " where trs.groupId=" + gId + " and trs.note like '%" + scheme.getTStaff().getName()
                                + "%'";
                        hql += " and trs.type ='" + scheme.getType() + "'";
                    } else if (scheme.getType().equals("个人方案")) {
                        hql += " where trs.communityHospitalId=" + tCommunityHospital.getCommunityHospitalId()
                                + " and trs.note like '%" + scheme.getTStaff().getName() + "%'";
                        hql += " and trs.type ='" + scheme.getType() + "'";
                    } else {
                        hql += " where trs.TStaff.name like '%" + scheme.getTStaff().getName() + "%'";
                        hql += " and  ((trs.groupId=" + gId + " and trs.type='" + "推荐方案"
                                + "') or (trs.communityHospitalId=" + tCommunityHospital.getCommunityHospitalId()
                                + " and trs.type='" + "个人方案" + "') or trs.type='" + "专家方案" + "')";
                    }
                }

                if ((scheme.getSchemeName() == null || scheme.getSchemeName().equals(""))
                        && (scheme.getTStaff().getName() == null || scheme.getTStaff().getName().equals(""))) {

                    if (scheme.getType().equals("")) {
                        hql += " where  ((trs.groupId=" + gId + " and trs.type='" + "推荐方案"
                                + "') or (trs.communityHospitalId=" + tCommunityHospital.getCommunityHospitalId()
                                + " and trs.type='" + "个人方案" + "') or trs.type='" + "专家方案" + "')";
                    } else if (scheme.getType().equals("专家方案")) {
                        hql += " where trs.type ='" + scheme.getType() + "'";
                    } else if (scheme.getType().equals("推荐方案")) {
                        hql += " where trs.groupId=" + gId + " and trs.type ='" + scheme.getType() + "'";
                    } else if (scheme.getType().equals("个人方案")) {
                        hql += " where trs.communityHospitalId=" + tCommunityHospital.getCommunityHospitalId()
                                + " and trs.type ='" + scheme.getType() + "'";
                    }
                }
                hql += " and trs.idDelete=" + IS_DELETE.no_Delete.getValue();
            }

            return recoverySchemeDao.count(hql);
        }
    }

    @Override
    public long getRecoverySchemeCountByGroupId(int groupId, TRecoveryScheme scheme) {
        // TODO Auto-generated method stub
        String hql = "select count(*) from TRecoveryScheme trs ";

        if (scheme.getSchemeName() != null && !scheme.getSchemeName().equals("")) // 康复方案名称不为空时
        {
            hql += " where trs.schemeName like '%" + scheme.getSchemeName() + "%'";
            if (scheme.getType().equals("")) {
            } else
                hql += " and trs.type ='" + scheme.getType() + "'";
        }
        if (scheme.getTStaff().getName() != null && !scheme.getTStaff().getName().equals(""))// 指定人不为空时
        {
            if (scheme.getType().equals("专家方案")) {
                hql += " where trs.note like '%" + scheme.getTStaff().getName() + "%'";

            } else if (scheme.getType().equals("推荐方案")) {

                hql += " where trs.groupId=" + groupId + "and trs.note like '%" + scheme.getTStaff().getName() + "%'";
            } else {
                hql += "  where trs.groupId=" + groupId + "and trs.TStaff.name like '%" + scheme.getTStaff().getName()
                        + "%'";
            }
            if (scheme.getType().equals("")) {
            } else
                hql += " and trs.type ='" + scheme.getType() + "'";
        }
        if ((scheme.getSchemeName() == null || scheme.getSchemeName().equals(""))
                && (scheme.getTStaff().getName() == null || scheme.getTStaff().getName().equals(""))) {
            hql += " where trs.type ='" + scheme.getType() + "'";
        }
        if (scheme.getCommunityHospitalId() != -1) {
            if (scheme.getType().equals("专家方案")) {

            } else if (scheme.getType().equals("推荐方案")) {
                hql += " where trs.groupId=" + groupId;
            } else {
                hql += " where trs.communityHospitalId=" + scheme.getCommunityHospitalId();
            }
        }
        hql += "and trs.idDelete=" + IS_DELETE.no_Delete.getValue();

        return recoverySchemeDao.count(hql);
    }

    @Override
    public void addRecoveryScheme(TRecoveryScheme scheme) {
        recoverySchemeDao.Save(scheme);

    }

    @Override
    public void deleteRecoverySchemeById(int id) {
        String hql = "update TRecoveryScheme rs set rs.idDelete=" + IS_DELETE.delete.getValue()
                + " where rs.recoverySchemeId=" + id;
        recoverySchemeDao.update(hql);
    }

    @Override
    public void deleteAnyRecoveryScheme(List<Object> idList) {
        String a = ",";
        String str = TypeConverter.convertList2String(idList, a);
        String hql = "delete from TRecoveryScheme ts where ts.recoverySchemeId in (" + str + ")";
    }

    @Override
    public void updateRecoveryScheme(TRecoveryScheme scheme) {
        recoverySchemeDao.update(scheme);
    }

    @Override
    public TRecoveryScheme getRecoveryScheme(String name) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", name);
        String hql = "from TRecoveryScheme trs where trs.SchemeName=:name";

        return recoverySchemeDao.Get(hql, params);
    }

    @Override
    public void addExpertRecoveryScheme(TRecoveryScheme expertscheme) {
        recoverySchemeDao.Save(expertscheme);

    }

    @Override
    public void deleteExpertRecoverySchemeById(int id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);

        String hql = "delete from TRecoveryScheme rs where rs.recoverySchemeId=: id ";

        recoverySchemeDao.delete(hql);

    }

    @Override
    public void updateExpertRecoveryScheme(TRecoveryScheme expertScheme) {
        recoverySchemeDao.update(expertScheme);

    }

    /*
     * @Override public long checkSchemeName(int comHosId,String schemeName) {
     * // TODO Auto-generated method stub Map<String, Object> params=new
     * HashMap<String, Object>(); params.put("schemeName", schemeName); String
     * hql=""; if(comHosId==-1) {
     * hql="select count(*) from TRecoveryScheme trs where trs.type='"
     * +"推荐方案"+"' and  trs.schemeName= :schemeName  and trs.idDelete="+IS_DELETE
     * .no_Delete.getValue() ; } else{ params.put("comHosId", comHosId);
     * hql="select count(*) from TRecoveryScheme trs where trs.communityHospitalId=:comHosId and trs.schemeName=:schemeName and trs.idDelete="
     * +IS_DELETE.no_Delete.getValue() ; } long
     * i=recoverySchemeDao.count(hql,params); return
     * recoverySchemeDao.count(hql,params); }
     */

    @Override
    public List<TRecoveryScheme> getRecoverySchemesByHosId(int hosId, String disease) {
        // TODO Auto-generated method stub
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("hosId", hosId);
        params.put("disease", disease);
        String hql = "from TRecoveryScheme trs where trs.communityHospitalId=:hosId and trs.idDelete="
                + IS_DELETE.no_Delete.getValue() + "and trs.disease=:disease ";

        return recoverySchemeDao.find(hql, params);
    }

}