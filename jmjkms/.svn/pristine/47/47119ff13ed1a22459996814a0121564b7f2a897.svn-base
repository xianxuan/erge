
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
 <input name="yemianname" value="02205" type="hidden"/>
    <!-- 主菜单 start -->
    <s:include value="/include/nav.jsp" />
    <!-- 主菜单 end -->
    <!-- 主容器 start -->
    <div class="container">
      <h3 class="current-title">糖尿病详情</h3>
      <div class="search-content">
         <label>姓名：${vchronic.fileName}&nbsp;&nbsp;&nbsp;&nbsp;档案编号：${vchronic.fileNum}</label>&nbsp;&nbsp;&nbsp;&nbsp;
           
      </div>
      <!-- 结果容器 start -->
      <h3 class="current-title">查看糖尿病档案</h3>
      <div class="table-content">
        <table id="jqprint" class="table table-bordered">
          <tbody>
          <tr>
            <td>初次诊断时间</td>
            <td><label><fmt:formatDate value="${vchronic.diabeteInitialDiagnosisTime}" pattern="yyyy-MM-dd" /></label></td>
            <td>糖尿病程</td>
             <td colspan="2">
               <label><c:out value="${vchronic.coOfDia}"></c:out></label>
             </td>
             <td>糖尿病类型</td>
             <td colspan="2">
               <label><c:out value="${vchronic.typOfDia}"></c:out></label>
             </td>
          </tr>
          <tr>
            <td>每月治疗费用（元）</td>
            <td><label><c:out value="${vchronic.costPerMonth}"></c:out></label></td>
            <td>目前主要症状</td>
             <td colspan="2">
                <label><c:out value="${vchronic.mainSyptm}"></c:out></label>
             </td>
             <td>糖尿病并发症</td>
             <td colspan="2">
               <label><c:out value="${vchronic.diaCompl}"></c:out></label>
             </td>
          </tr>
          <tr>
            <td>糖尿病既往史</td>
            <td colspan="3">
               <label><c:out value="${vchronic.diaHistory}"></c:out></label>
             </td>
             <td>家庭中糖尿病患者</td>
             <td colspan="3">
               <label><c:out value="${vchronic.faMem}"></c:out></label>
             </td>
          </tr>
           <tr>
                <td colspan="8" class="title-td">一般状况</td>
           </tr>
          <tr>
             <td >体温（℃）</td>
             <td><label><c:out value="${diabete.TGeneralCondition.temperature}"></c:out></label></td>
             <td >呼吸频率（次/分钟）</td>
             <td><label><c:out value="${diabete.TGeneralCondition.breathingRate}"></c:out></label></td>
             <td >舒张压（mmHg）</td>
             <td><label><c:out value="${diabete.TGeneralCondition.diastolicPressure}"></c:out></label></td>
             <td>收缩压（mmHg）</td>
             <td><label><c:out value="${diabete.TGeneralCondition.systolicPressure}"></c:out></label></td>
           </tr>
           <tr>
             
             <td >脉率（次/分钟）</td>
             <td><label><c:out value="${diabete.TGeneralCondition.pulseRate}"></c:out></label></td>
             <td >身高（CM）</td>
             <td><label><c:out value="${diabete.TGeneralCondition.height}"></c:out></label></td>
             <td>体重（kg)</td>
             <td><label><c:out value="${diabete.TGeneralCondition.weight}"></c:out></label></td>
             <td>体质指数</td>
             <td><label><c:out value="${diabete.TGeneralCondition.bmi}"></c:out></label></td>
           </tr>
           <tr>
              <td>腰围（CM）</td>
             <td><label><c:out value="${diabete.TGeneralCondition.waistline}"></c:out></label></td>
             <td>臀围（CM）</td>
             <td><label><c:out value="${diabete.TGeneralCondition.hip}"></c:out></label></td>
             <td >腰臀围比值</td>
             <td colspan="4"><label><c:out value="${diabete.TGeneralCondition.ratio}"></c:out></label></td>
           </tr>

           <tr>
                <td colspan="8" class="title-td">生活方式</td>
           </tr>
           <tr>
              <td>体育锻炼频率</td>
              <td > 
               <label><c:out value="${diabete.TLifeStyle.exerciseFrequency}"></c:out></label>
             </td>
              <td>每次锻炼时间（分钟）</td>
             <td><label><c:out value="${diabete.TLifeStyle.exerciseTime}"></c:out></label></td>
              <td>坚持锻炼时间（年）</td>
             <td><label><c:out value="${diabete.TLifeStyle.allExerciseTime}"></c:out></label></td>
             <td>锻炼方式</td>
             <td> 
               <label><c:out value="${diabete.TLifeStyle.exerciseType}"></c:out></label>
             </td>
           </tr>
           <tr>
             <td>饮食习惯</td>
             <td colspan="3"> 
               <label><c:out value="${diabete.TLifeStyle.dietaryHabit}"></c:out></label>
             </td>
             <td>吸烟状况</td>
             <td colspan="3"> 
               <label><c:out value="${diabete.TLifeStyle.smokingStatus}"></c:out></label>
             </td>
           </tr>
            <tr>
             <td>日吸烟量平均（支）</td>
             <td><label><c:out value="${diabete.TLifeStyle.smokingOneday}"></c:out></label></td>
             <td>开始吸烟年龄（岁）</td>
             <td><label><c:out value="${diabete.TLifeStyle.startsmokingAge}"></c:out></label></td>
             <td>戒烟年龄（岁）</td>
             <td><label><c:out value="${diabete.TLifeStyle.giveupSmokingAge}"></c:out></label></td>
             <td>饮酒频率</td>
             <td> 
               <label><c:out value="${diabete.TLifeStyle.drinkingFrequency}"></c:out></label>
             </td>
           </tr>
            <tr>
             <td>日饮酒量平均（两）</td>
             <td><label><c:out value="${diabete.TLifeStyle.monthlyDrinking}"></c:out></label></td>
             <td>是否戒酒</td>
             <td > 
               <label><c:out value="${diabete.TLifeStyle.abstinence}"></c:out></label>
             </td>
             <td>开始饮酒年龄（岁）</td>
             <td><label><c:out value="${diabete.TLifeStyle.startDrinkingAge}"></c:out></label></td>
             <td>近一年是否曾醉酒</td>
             <td > 
               <label>
               <s:if test="diabete.TLifeStyle.recentlyYearDrinking==false"><c:out value="是"></c:out></s:if>
               <s:if test="diabete.TLifeStyle.recentlyYearDrinking==true"><c:out value="否"></c:out></s:if>
               </label>
             </td>
           </tr>
           <tr>
             <td>饮酒种类</td>
             <td colspan="7"> 
               <label><c:out value="${diabete.TLifeStyle.drinkingType}"></c:out></label>
             </td>
           </tr>
          <tr>
                <td colspan="8" class="title-td">辅助检查</td>
          </tr>
          <tr>
            <td>空腹血糖（mmol/L）</td>
            <td><label><c:out value="${diabete.TAuxiliaryExamination.fbg}"></c:out></label></td>
            <td>糖化血红蛋白（%）</td>
            <td><label><c:out value="${diabete.TAuxiliaryExamination.glycatedHemoglobin}"></c:out></label></td>
            <td>尿微量白蛋白（mg/dL）</td>
            <td><label><c:out value="${diabete.TAuxiliaryExamination.mau}"></c:out></label></td>
            <td>尿蛋白</td>
            <td><label><c:out value="${diabete.TAuxiliaryExamination.urineProtein}"></c:out></label></td>
          </tr>
          <tr>
            <td>尿糖</td>
            <td><label><c:out value="${diabete.TAuxiliaryExamination.urineGlucose}"></c:out></label></td>
            <td>尿酮体</td>
            <td><label><c:out value="${diabete.TAuxiliaryExamination.ketone}"></c:out></label></td>
            <td>尿潜血</td>
            <td><label><c:out value="${diabete.TAuxiliaryExamination.ery}"></c:out></label></td>
            <td>血清肌酐（umol/L）</td>
            <td><label><c:out value="${diabete.TAuxiliaryExamination.cr}"></c:out></label></td>
          </tr>
          <tr>
            <td>血尿素氮（mmol/L）</td>
            <td><label><c:out value="${diabete.TAuxiliaryExamination.bun}"></c:out></label></td>
            <td>血钾浓度（mmol/L）</td>
            <td><label><c:out value="${diabete.TAuxiliaryExamination.serumPotassiumLevel}"></c:out></label></td>
            <td>血钠浓度（mmol/L）</td>
            <td><label><c:out value="${diabete.TAuxiliaryExamination.serumNatriumLevel}"></c:out></label></td>
            <td>总胆固醇（mmol/L）</td>
            <td><label><c:out value="${diabete.TAuxiliaryExamination.totalCholesterol}"></c:out></label></td>
          </tr>
          <tr>
            <td>甘油三酯（mmol/L）</td>
            <td><label><c:out value="${diabete.TAuxiliaryExamination.triglyceride}"></c:out></label></td>
            <td>血清低密度蛋白胆固醇（mmol/L）</td>
            <td><label><c:out value="${diabete.TAuxiliaryExamination.ldlC}"></c:out></label></td>
            <td>血清高密度脂蛋白胆固醇（mmol/L）</td>
            <td colspan="3"><label><c:out value="${diabete.TAuxiliaryExamination.hdlC}"></c:out></label></td>
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
            <td colspan="4"></td>
            <td>建档人</td>
             <td> 
              <label><c:out value="${vchronic.chronicDiseaseFileName}"></c:out></label>
             </td>
             <td>建档日期</td>
              <td><label><fmt:formatDate value="${vchronic.chronicDiseaseFileDate}" pattern="yyyy-MM-dd" /></label></td>
          </tr>
          </tbody>
        </table>
        <div class="btn-content">
          <a href="javascript:;" class="btn btn-print btn-dayin">打印</a>
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
