<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<input name="staffId" value="${session.staff.staffId}" type="hidden"/>

<div class="nav">
	  <input name="staffId" value="${session.staff.staffId}" type="hidden"/>
      <!-- <ul class="nav-ul"> -->
      <ul class="nav-ul" style="display:none">
        <li name="01100" class="has-submenu"><a href="javascript:;"><i class="fa fa-book "></i>&nbsp;&nbsp;&nbsp;档案管理</a>
            <ul class="sub-menu">
              <li name="01201"><a href="<%=basePath %>healthFileAction!showHealthFile.action">健康档案</a></li>
              <li name="01202"><a href="<%=basePath %>showOldChronicAction!firstShowChronic.action">慢病档案</a></li>
            </ul> 
        </li>
        
        <li name="02100" class="has-submenu"><a href="javascript:;"><i class="fa fa-plus-square"></i>&nbsp;&nbsp;&nbsp;健康管理</a>
            <ul class="sub-menu">
              <li name="02201"><a href="<%=basePath%>HealthManagerAction!getHealthFileList.action">健康数据录入</a></li>
              <li name="02202"><a href="<%=basePath%>HealthDailyCheckAction!getHealthFileList.action">健康建议</a></li>
              <li name="02203"><a href="<%=basePath%>healthAlarmAction!toAlarmManager.action">健康预警管理</a></li>
              <li name="02204"><a href="<%=basePath%>chronicManagerAction!getAllHighBloodManager.action">高血压健康管理</a></li>
              <li name="02205"><a href="<%=basePath%>chronicManagerAction!getAllDiabeteManager.action">高血糖健康管理</a></li>
              <li name="02206"><a href="<%=basePath%>chronicManagerAction!getAllOtherManager.action">其他慢病管理</a></li>
              <li name="02207"><a href="<%=basePath%>xkHealthMachineAction!getList.action">中医治未病</a></li>
            </ul>
        </li>
        <li name="03100"><a href="<%=basePath %>PhysicalExamAction!firstIndexsearch.action"><i class="fa fa-stethoscope"></i>&nbsp;&nbsp;&nbsp;健康体检</a>
        </li>
        <li name="04100" class="has-submenu"><a href="javascript:;"><i class="fa fa-h-square"></i>&nbsp;&nbsp;&nbsp;健康理疗</a>
            <ul class="sub-menu">
              <li name="04201"><a href="<%=basePath%>healthPhysiotherapyAction.action">康复方案</a></li>
              <li name="04202"><a href="<%=basePath%>healthPhysiotherapyAction!getAllPlan.action">康复计划</a></li>
              <li name="04203"><a href="<%=basePath%>healthPhysiotherapyAction!getRecovery.action">统计分析</a></li>
            </ul>
        </li>
        <li name="05100" class="has-submenu"><a href="javascript:;"><i class="fa fa-heartbeat"></i>&nbsp;&nbsp;&nbsp;健康关怀</a>
            <ul class="sub-menu">
              <li name="05201"><a href="<%=basePath %>healthEducationAction!getHealthEducationList.action">健康教育</a></li>
              <li name="05202"><a href="<%=basePath %>doorKnockingAction!getDoorKnockingListById.action">上门随访</a></li>
              <li name="05203"><a href="<%=basePath %>knowledgeLectureAction!getKnowledgeLectureListById.action">知识讲座</a></li>
              <li name="05204"><a href="<%=basePath %>comminityClinicAction!getComminityClinicListById.action">社区义诊</a></li>
            </ul>
        </li>
        <li name="06100" class="has-submenu"><a href="javascript:;"><i class="fa fa-hospital-o"></i>&nbsp;&nbsp;&nbsp;门诊记录</a>
            <ul class="sub-menu">
              <li name="06201"><a href="<%=basePath %>followRecordAction!showFollowRecord.action">随诊记录</a></li>
              <li name="06202"><a href="<%=basePath %>incompleteRecordAction2!showIncompleteRecord.action">接诊记录</a></li>
              <li name="06203"><a href="<%=basePath %>consultationRecordAction!showConsultationRecord.action">会诊记录</a></li>
              <li name="06204"><a href="<%=basePath %>dualReferralRecordAction!showDualReferralRecord.action">双向转诊记录</a></li>
              <li name="06205"><a href="<%=basePath %>medicalRecordAction!showMedicalRecord.action">长期用药记录</a></li>
              <li name="06206"><a href="<%=basePath %>familyBedHistoryAction!showFamilyBedHistory.action">家庭病床记录</a></li>
              <li name="06207"><a href="<%=basePath %>inHospitalHistoryAction!showInHospitalHistory.action">住院记录</a></li>
            </ul>
        </li>
        <li name="07100" class="has-submenu"><a href="javascript:;"><i class="fa fa-user"></i>&nbsp;&nbsp;&nbsp;员工管理</a>
            <ul class="sub-menu">
              <li name="07201"><a href="<%=basePath%>staffAction.action">员工信息管理</a></li>
              <li name="07202"><a href="<%=basePath%>staffAction!getAllStaffLeaves.action">员工请假管理</a></li>
              <li name="07203"><a href="<%=basePath%>staffRewardPunishAction!getAllStaffRewardPunish.action">员工奖惩管理</a></li>
              <li name="07204"><a href="<%=basePath %>oparetorAction!getAllOperators.action">操作员管理</a></li>
            </ul>
        </li>
        <li name="08100" class="has-submenu"><a href="javascript:;"><i class="fa fa-database"></i>&nbsp;&nbsp;&nbsp;统计分析</a>
            <ul class="sub-menu">
            <c:if test="${session.comHospital.isHead==0 }">
                <li name="08201"><a href="<%=basePath%>statisticsAction!staticticsList.action">集团统计</a></li>
              </c:if>
              <c:if test="${session.comHospital.isHead!=0 }">
                <li name="08201"><a href="<%=basePath%>statisticsAction!staticticsList.action">医院统计</a></li>
              </c:if>
              
              <li name="08202"><a href="<%=basePath%>statisticsAction!jumpDeviceStatistics.action">设备统计</a></li>
              <li name="08203"><a href="<%=basePath%>statisticsAction!jumpALLCurrentCount.action">疾病分析</a></li>
            </ul>
        </li>
        <li name="09100"><a href="<%=basePath%>equipmentManageAction!getEquipmentManageListById.action"><i class="fa fa-cogs"></i>&nbsp;&nbsp;&nbsp;设备管理</a></li>
        <li name="10100" class="has-submenu"><a href="javascript:;"><i class="fa fa-sitemap"></i>&nbsp;&nbsp;&nbsp;系统管理</a>
            <ul class="sub-menu">
              <li name="10205"><a href="<%=basePath %>communityHospitalGroupAction!getHosGroupList.action">社区集团管理</a></li>
              <li name="10201"><a href="<%=basePath %>communityHospitalAction!getHospitalList.action">社区医院管理</a></li>
              <c:if test="${session.comHospital.isHead==0 }">
                <li name="10202"><a href="<%=basePath %>healthPhysiotherapyAction!getExpertScheme.action">专家康复方案</a></li>
              </c:if>
              <c:if test="${session.communityHospitalGroup!=null }">
                <li name="10202"><a href="<%=basePath %>healthPhysiotherapyAction!getExpertScheme.action">推荐康复方案</a></li>
              </c:if>
              <li name="10203"><a href="<%=basePath %>MaintainaleAction!getMaintainableByPage.action">数据字典维护</a></li>
              <li name="10204"><a href="<%=basePath %>roleAction!getRoleList.action">角色权限管理</a></li>
            </ul>
        </li>
      </ul>
    </div>
