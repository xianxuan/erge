<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head><meta name="viewport" content="width=device-width, initial-scale=1.0"><meta http-equiv="X-UA-Compatible" content="ie=edge">
  <meta charset="UTF-8">
  <c:choose><c:when test="${session.comHospital.isHead==0}"><title>中电科社区健康管理平台</title></c:when><c:when test="${session.communityHospitalGroup!=null}"><title>社区健康管理系统</title></c:when><c:otherwise><title>社区健康服务站</title></c:otherwise></c:choose>
  <link rel="stylesheet" href="/jmjkms/css/cssreset.css">
  <link rel="stylesheet" href="/jmjkms/css/main.css">
  <link rel="stylesheet" href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">
</head>
<body>
  <!-- 顶栏 start -->
  <s:include value="/include/header.jsp" />
  <!-- 顶栏 end -->
  <div class="main-content clearfix">
  <input name="yemianname" value="02204" type="hidden"/>
    <!-- 主菜单 start -->
    <s:include value="/include/nav.jsp" />
    <!-- 主菜单 end -->
    <!-- 主容器 start -->
    <div class="container">
      <h3 class="current-title">高血压详情</h3>
      <div class="search-content">
         <label>姓名：${vchronic.fileName}&nbsp;&nbsp;&nbsp;&nbsp;档案编号：${vchronic.fileNum}</label>&nbsp;&nbsp;&nbsp;&nbsp;
            
      </div>
      <!-- 结果容器 start -->
      <h3 class="current-title">查看高血压档案</h3>
      <div class="table-content">
         <table id="jqprint" class="table table-bordered">
          <tbody>
           <tr>
             <td colspan="8" class="title-td">基本信息</td>
           </tr>
           <tr>
             <td>高血压类型</td>
             <td colspan="2">
               <label><c:out value="${vchronic.highBloodTypr}"></c:out></label>
             </td>
             <td>高血压管理分级</td>
             <td colspan="2">
               <label><c:out value="${vchronic.managementClass}"></c:out></label>
             </td>
             <td>初次诊断时间</td>
             <td>
                <label><fmt:formatDate value="${vchronic.highBloodInitialDiagnosisTime}" pattern="yyyy-MM-dd" /></label>
             </td>
           </tr>
           <tr>
             <td>目前主要症状</td>
             <td colspan="3">
               <label><c:out value="${vchronic.mainSymptoms}"></c:out></label>
             </td>
             <td>高血压并发症</td>
             <td colspan="3">
               <label><c:out value="${vchronic.hypertensionComplication}"></c:out></label>
             </td>
           </tr>
           <tr>
             <td>多长时间量一次血压</td>
             <td>
               <label><c:out value="${vchronic.howLongTakeBlood}"></c:out></label>
             </td>
             <td>是否服用降压药</td>
             <td>
               <label><c:out value="${vchronic.takeMedication}"></c:out></label>
             </td>
             <td>不服或不规律服药原因</td>
             <td>
               <label><c:out value="${vchronic.notTakeReason}"></c:out></label>
             </td>
             <td>每日高血压药物费用</td>
             <td>
               <label><c:out value="${vchronic.drugCost}"></c:out></label>
             </td>
           </tr>
           <tr>
             <td>非药物方法治疗高血压</td>
             <td colspan="3" > 
               <label><c:out value="${vchronic.nonDrugTreatment}"></c:out></label>
             </td>
            <td>家族中高血压患者</td>
             <td>
              <label><c:out value="${vchronic.familyWhitHighBlood}"></c:out></label>
             </td>
           </tr>

           <tr>
                <td colspan="8" class="title-td">一般情况</td>
           </tr>
          <tr>
             <td >体温(℃)</td>
             <td><label><c:out value="${highBloodPressure.TGeneralCondition.temperature}"></c:out></label></td>
             <td >呼吸频率（次/分钟）</td>
             <td><label><c:out value="${highBloodPressure.TGeneralCondition.breathingRate}"></c:out></label></td>
             <td >舒张压（mmhg）</td>
             <td><label><c:out value="${highBloodPressure.TGeneralCondition.diastolicPressure}"></c:out></label></td>
             <td>收张压（mmhg）</td>
             <td><label><c:out value="${highBloodPressure.TGeneralCondition.systolicPressure}"></c:out></label></td>
           </tr>
           <tr>
             
             <td >脉率（次/分钟）</td>
             <td><label><c:out value="${highBloodPressure.TGeneralCondition.pulseRate}"></c:out></label></td>
             <td >身高（cm）</td>
             <td><label><c:out value="${highBloodPressure.TGeneralCondition.height}"></c:out></label></td>
             <td>体重（kg)</td>
             <td><label><c:out value="${highBloodPressure.TGeneralCondition.weight}"></c:out></label></td>
             <td>体质指数</td>
             <td><label><c:out value="${highBloodPressure.TGeneralCondition.bmi}"></c:out></label></td>
           </tr>
           <tr>
              <td>腰围（cm）</td>
             <td><label><c:out value="${highBloodPressure.TGeneralCondition.waistline}"></c:out></label></td>
             <td>臀围（cm）</td>
             <td><label><c:out value="${highBloodPressure.TGeneralCondition.hip}"></c:out></label></td>
             <td >腰臀围比值</td>
             <td colspan="4"><label><c:out value="${highBloodPressure.TGeneralCondition.ratio}"></c:out></label></td>
           </tr>

            <tr>
                <td colspan="8" class="title-td">生活方式</td>
           </tr>
           <tr>
              <td>体育锻炼频率</td>
              <td > 
               <label><c:out value="${highBloodPressure.TLifeStyle.exerciseFrequency}"></c:out></label>
             </td>
              <td>每次锻炼时间（分钟）</td>
             <td><label><c:out value="${highBloodPressure.TLifeStyle.exerciseTime}"></c:out></label></td>
              <td>坚持锻炼时间（年）</td>
             <td><label><c:out value="${highBloodPressure.TLifeStyle.allExerciseTime}"></c:out></label></td>
             <td>锻炼方式</td>
             <td> 
               <label><c:out value="${highBloodPressure.TLifeStyle.exerciseType}"></c:out></label>
             </td>
           </tr>
           <tr>
             <td>饮食习惯</td>
             <td colspan="3"> 
               <label><c:out value="${highBloodPressure.TLifeStyle.dietaryHabit}"></c:out></label>
             </td>
             <td>吸烟状况</td>
             <td colspan="3"> 
               <label><c:out value="${highBloodPressure.TLifeStyle.smokingStatus}"></c:out></label>
             </td>
           </tr>
            <tr>
             <td>日吸烟量平均（支）</td>
             <td><label><c:out value="${highBloodPressure.TLifeStyle.smokingOneday}"></c:out></label></td>
             <td>开始吸烟年龄（岁）</td>
             <td><label><c:out value="${highBloodPressure.TLifeStyle.startsmokingAge}"></c:out></label></td>
             <td>戒烟年龄（岁）</td>
             <td><label><c:out value="${highBloodPressure.TLifeStyle.giveupSmokingAge}"></c:out></label></td>
             <td>饮酒频率</td>
             <td > 
               <label><c:out value="${highBloodPressure.TLifeStyle.drinkingFrequency}"></c:out></label>
             </td>
           </tr>
            <tr>
             <td>日饮酒量平均（两）</td>
             <td><label><c:out value="${highBloodPressure.TLifeStyle.monthlyDrinking}"></c:out></label></td>
             <td>是否戒酒</td>
             <td > 
               <label><c:out value="${highBloodPressure.TLifeStyle.abstinence}"></c:out></label>
             </td>
             <td>开始饮酒年龄（岁）</td>
             <td><label><c:out value="${highBloodPressure.TLifeStyle.startDrinkingAge}"></c:out></label></td>
             <td>近一年是否曾醉酒</td>
             <td > 
               <label>
               <s:if test="highBloodPressure.TLifeStyle.recentlyYearDrinking==false"><c:out value="是"></c:out></s:if>
               <s:if test="highBloodPressure.TLifeStyle.recentlyYearDrinking==true"><c:out value="否"></c:out></s:if>
               </label>
             </td>
           </tr>
           <tr>
             <td>饮酒种类</td>
             <td colspan="7"> 
               <label><c:out value="${highBloodPressure.TLifeStyle.drinkingType}"></c:out></label>
             </td>
             </tr> 
			 <tr>
             <td>是否添加到慢病管理</td>
             <td colspan="7"> 
               <s:if test="vchronic.status==0">
               <label><c:out value="否"></c:out></label>
               </s:if>
               <s:if test="vchronic.status!=0">
               <label><c:out value="是"></c:out></label>
               </s:if>
             </td>
             </tr>
             <tr>
             <td >建档人</td>
             <td colspan="3"><label><c:out value="${vchronic.chronicDiseaseFileName}"></c:out></label></td>
             <td >建档日期</td>
             <td colspan="3"><label> <fmt:formatDate value="${vchronic.chronicDiseaseFileDate}" pattern="yyyy-MM-dd" /></label></td>
             </tr>
          
          </tbody>
        </table>
        <div class="btn-content">
         <a href="javascript:;" class="btn btn-print">打印</a>
          <a href="javascript:;" class="btn btn-back">返回</a>
        </div>
      </div>
      <!-- 结果容器 end -->
    </div> 
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>

<script src="/jmjkms/js/jquery-1.4.4.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<script src="/jmjkms/js/jquery.jqprint-0.3.js"></script>
</body>
</html>
