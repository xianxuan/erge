<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
  <input name="yemianname" value="01202" type="hidden"/>
    <!-- 主菜单 start -->
    <s:include value="/include/nav.jsp" />
    <!-- 主菜单 end -->
    <!-- 主容器 start -->
    <div class="container">
      <h3 class="current-title">慢性病档案</h3>
      <div class="search-content">
       
             <label>
            	姓名：<c:out value="${vchronic.fileName}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;档案编号：<c:out value="${vchronic.fileNum}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;
 
            </label>
        
        
      </div>
      <!-- 结果容器 start -->
      <h3 class="current-title">编辑糖尿病档案</h3>
      <form action="<%=basePath %>showOldChronicAction!editDiabete.action" method="post" >
      <div class="table-content">
        <table class="table table-bordered">
          <tbody>
          <tr>
            <td>初次诊断时间</td>
            <td><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="diabete.initialDiagnosisTime" value="<fmt:formatDate value="${vchronic.diabeteInitialDiagnosisTime}"  pattern="yyyy-MM-dd"/>" ></td>
            <td>糖尿病程</td>
             <td colspan="2">
               <select name="diabete.coOfDia">
                 <option value="" >请选择</option>
                 <s:iterator value="tnbc" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.coOfDia}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>糖尿病类型</td>
             <td colspan="2">
               <select name="diabete.typOfDia">
                <s:iterator value="tnblx" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.typOfDia}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
          </tr>
          <tr>
            <td>每月治疗费用（元）<input type = "hidden" name = "htype"  value= "${vchronic.healthFileType}" maxlength='10'></td>
            <td><input onkeyup="Num(this)" type="text" name="diabete.costPerMonth" value="${vchronic.costPerMonth}" maxlength='10'></td>
            <td>目前主要症状</td>
             <td colspan="2">
               <select name="diabete.mainSyptm">
                 <option value="" >请选择</option>
                <s:iterator value="tnbmqzyzz" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.mainSyptm}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>糖尿病并发症</td>
             <td colspan="2">
               <select name="diabete.diaCompl">
                 <option value="" >请选择</option>
                 <s:iterator value="tnbbfz" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.diaCompl}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
          </tr>
          <tr>
            <td>糖尿病既往史</td>
            <td colspan="3">
               <select name="diabete.diaHistory">
                 <option value="" >请选择</option>
                 <s:iterator value="tnbjws" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.diaHistory}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>家庭中糖尿病患者</td>
             <td colspan="3">
               <select name="diabete.faMem">
                 <option value="" >请选择</option>
                 <s:iterator value="jtztnbhz" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.faMem}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
          </tr>
           <tr>
                <td colspan="8" class="title-td">一般状况</td>
           </tr>
          <tr>
             <td >体温（℃）</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name="generalCondition.temperature" value="${diabete.TGeneralCondition.temperature}"  maxlength='10' ></td>
             <td >呼吸频率（次/分钟）</td>
             <td><input  type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" class="w40" name="generalCondition.breathingRate" value="${diabete.TGeneralCondition.breathingRate}"  maxlength='10' ></td>
             <td >舒张压（mmHg）</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name="generalCondition.diastolicPressure" value="${diabete.TGeneralCondition.diastolicPressure}"  maxlength='10' ></td>
             <td>收缩压（mmHg）</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name="generalCondition.systolicPressure" value="${diabete.TGeneralCondition.systolicPressure}"  maxlength='10' ></td>
           </tr>
           <tr>
             
             <td >脉率（次/分钟）</td>
             <td><input  type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" class="w40" name="generalCondition.pulseRate" value="${diabete.TGeneralCondition.pulseRate}"  maxlength='10' ></td>
             <td >身高（CM）</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name="generalCondition.height" value="${diabete.TGeneralCondition.height}"  maxlength='10' ></td>
             <td>体重（kg)</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name="generalCondition.weight" value="${diabete.TGeneralCondition.weight}"  maxlength='10' ></td>
             <td>体质指数</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name="generalCondition.bmi" value="${diabete.TGeneralCondition.bmi}"  maxlength='10' ></td>
           </tr>
           <tr>
              <td>腰围（CM）</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name="generalCondition.waistline" value="${diabete.TGeneralCondition.waistline}"  maxlength='10' ></td>
             <td>臀围（CM）</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name="generalCondition.hip" value="${diabete.TGeneralCondition.hip}"  maxlength='10' ></td>
             <td >腰臀围比值</td>
             <td colspan="4"><input onkeyup="Num(this)" type="text"  name="generalCondition.ratio" value="${diabete.TGeneralCondition.ratio}"  maxlength='10' ></td>
           </tr>

           <tr>
                <td colspan="8" class="title-td">生活方式</td>
           </tr>
           <tr>
              <td>体育锻炼频率</td>
              <td > 
               <select name="lifeStyle.exerciseFrequency">
                    <option value="" >请选择</option>
                 <s:iterator value="tydlpl" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq diabete.TLifeStyle.exerciseFrequency}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
              <td>每次锻炼时间（分钟）</td>
             <td><input  type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" class="w40" name="lifeStyle.exerciseTime" value="${diabete.TLifeStyle.exerciseTime}" maxlength='10'></td>
              <td>坚持锻炼时间（年）</td>
             <td><input  type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" class="w40" name="lifeStyle.allExerciseTime"  value="${diabete.TLifeStyle.allExerciseTime}" maxlength='10'></td>
             <td>锻炼方式</td>
             <td> 
               <select name="lifeStyle.exerciseType">
                  <option value="" >请选择</option>
                 <s:iterator value="dlfs" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq diabete.TLifeStyle.exerciseType}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
           </tr>
           <tr>
             <td>饮食习惯</td>
             <td colspan="3"> 
               <select name="lifeStyle.dietaryHabit">
                 <option value="" >请选择</option>
                 <s:iterator value="ysxg" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq diabete.TLifeStyle.dietaryHabit}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>吸烟状况</td>
             <td colspan="3"> 
               <select name="lifeStyle.smokingStatus">
                 <option value="" >请选择</option>
                 <s:iterator value="xyzk" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq diabete.TLifeStyle.smokingStatus}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
           </tr>
            <tr>
             <td>日吸烟量平均（支）</td>
             <td><input  type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" class="w40" name="lifeStyle.smokingOneday"  value="${diabete.TLifeStyle.smokingOneday}"  maxlength='10' ></td>
             <td>开始吸烟年龄（岁）</td>
             <td><input  type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" class="w40" name="lifeStyle.startsmokingAge" value="${diabete.TLifeStyle.startsmokingAge}"  maxlength='10' ></td>
             <td>戒烟年龄（岁）</td>
             <td><input  type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" class="w40" name="lifeStyle.giveupSmokingAge" value="${diabete.TLifeStyle.giveupSmokingAge}"  maxlength='10' ></td>
             <td>饮酒频率</td>
             <td > 
               <select name="lifeStyle.drinkingFrequency">
                 <option value="" >请选择</option>
                 <s:iterator value="yjpl" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq diabete.TLifeStyle.drinkingFrequency}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
           </tr>
            <tr>
             <td>日饮酒量平均（两）</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name="lifeStyle.monthlyDrinking" value="${diabete.TLifeStyle.monthlyDrinking}"  maxlength='10' ></td>
             <td>是否戒酒</td>
             <td > 
               <select name="lifeStyle.abstinence">
                <option value="" >请选择</option>
                 <option value="是" <c:if test="${'是' eq diabete.TLifeStyle.abstinence}">selected</c:if>>是</option>
                 <option value="否" <c:if test="${'否' eq diabete.TLifeStyle.abstinence}">selected</c:if>>否</option>
               </select>
             </td>
             <td>开始饮酒年龄（岁）</td>
             <td><input type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" class="w40" name="lifeStyle.startDrinkingAge" value="${diabete.TLifeStyle.startDrinkingAge}"></td>
             <td>近一年是否曾醉酒</td>
             <td > 
               <select name="lifeStyle.recentlyYearDrinking">
                 <option value="">请选择</option>
                 <option value="true" <c:if test="${diabete.TLifeStyle.recentlyYearDrinking eq 'true'}">selected</c:if>>是</option>
                 <option value="false" <c:if test="${diabete.TLifeStyle.recentlyYearDrinking eq 'false'}">selected</c:if>>否</option>
               </select>
             </td>
           </tr>
           <tr>
             <td>饮酒种类</td>
             <td colspan="7"> 
               <select name="lifeStyle.drinkingType">
                <option value="" >请选择</option>
                 <s:iterator value="yjzl" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq diabete.TLifeStyle.drinkingType}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
           </tr>
          <tr>
                <td colspan="8" class="title-td">辅助检查</td>
          </tr>
          <tr>
            <td>空腹血糖（mmol/L）</td>
            <td><input onkeyup="Num(this)" type="text" name="auxiliaryExamination.fbg" value="${diabete.TAuxiliaryExamination.fbg}" maxlength='10' ></td>
            <td>糖化血红蛋白（%）</td>
            <td><input onkeyup="Num(this)" type="text" name="auxiliaryExamination.glycatedHemoglobin" value="${diabete.TAuxiliaryExamination.glycatedHemoglobin}" maxlength='10' ></td>
            <td>尿微量白蛋白（mg/dL）</td>
            <td><input onkeyup="Num(this)" type="text" name="auxiliaryExamination.mau" value="${diabete.TAuxiliaryExamination.mau}" maxlength='10' ></td>
            <td>尿蛋白</td>
            <td><input  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" name="auxiliaryExamination.urineProtein" value="${diabete.TAuxiliaryExamination.urineProtein}" maxlength='20' ></td>
          </tr>
          <tr>
            <td>尿糖</td>
            <td><input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"  type="text" name="auxiliaryExamination.urineGlucose" value="${diabete.TAuxiliaryExamination.urineGlucose}" maxlength='20'></td>
            <td>尿酮体</td>
            <td><input  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" name="auxiliaryExamination.ketone" value="${diabete.TAuxiliaryExamination.ketone}" maxlength='20'></td>
            <td>尿潜血</td>
            <td><input  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" name="auxiliaryExamination.ery" value="${diabete.TAuxiliaryExamination.ery}" maxlength='80'></td>
            <td>血清肌酐（umol/L）</td>
            <td><input onkeyup="Num(this)" type="text" name="auxiliaryExamination.cr" value="${diabete.TAuxiliaryExamination.cr}" maxlength='10' ></td>
          </tr>
          <tr>
            <td>血尿素氮（mmol/L）</td>
            <td><input onkeyup="Num(this)" type="text" name="auxiliaryExamination.bun" value="${diabete.TAuxiliaryExamination.bun}" maxlength='10' ></td>
            <td>血钾浓度（mmol/L）</td>
            <td><input onkeyup="Num(this)" type="text" name="auxiliaryExamination.serumPotassiumLevel" value="${diabete.TAuxiliaryExamination.serumPotassiumLevel}" maxlength='10' ></td>
            <td>血钠浓度（mmol/L）</td>
            <td><input onkeyup="Num(this)" type="text" name="auxiliaryExamination.serumNatriumLevel" value="${diabete.TAuxiliaryExamination.serumNatriumLevel}" maxlength='10' ></td>
            <td>总胆固醇（mmol/L）</td>
            <td><input onkeyup="Num(this)" type="text" name="auxiliaryExamination.totalCholesterol" value="${diabete.TAuxiliaryExamination.totalCholesterol}" maxlength='10' ></td>
          </tr>
          <tr>
            <td>甘油三酯（mmol/L）</td>
            <td><input onkeyup="Num(this)" type="text" name="auxiliaryExamination.triglyceride" value="${diabete.TAuxiliaryExamination.triglyceride}" maxlength='10' ></td>
            <td>血清低密度蛋白胆固醇（mmol/L）</td>
            <td><input onkeyup="Num(this)" type="text" name="auxiliaryExamination.ldlC" value="${diabete.TAuxiliaryExamination.ldlC}" maxlength='10' ></td>
            <td>血清高密度脂蛋白胆固醇（mmol/L）</td>
            <td colspan="3"><input onkeyup="Num(this)" type="text" name="auxiliaryExamination.hdlC" value="${diabete.TAuxiliaryExamination.hdlC}" maxlength='10' ></td>
          </tr>
          <tr>
            <td>是否添加到慢病管理</td>
             <td colspan="7">
               <s:if test="vchronic.status==0">
               <label>否</label>
               </s:if>
               <s:if test="vchronic.status!=0">
               <label>是</label>
               </s:if>
              </td>
          </tr>
          <tr>
            <td colspan="4"></td>
            <td>建档人</td>
             <td> 
               <label>${vchronic.chronicDiseaseFileName}</label>  
             </td>
             <td>建档日期 </td>
             <td>
           <fmt:formatDate value="${vchronic.chronicDiseaseFileDate}" pattern="yyyy-MM-dd"/></td>
             
           </tr>
          </tbody>
        </table>
         <!-- 慢性病总表Id  使用隐藏域-->
        <input type="hidden" value="${chronicDisease.chronicDiseaseId}" name="chronicDisease.chronicDiseaseId">
        <!-- 辅助检查表 -->
         <input type="hidden" value="${diabete.TAuxiliaryExamination.auxiliaryExaminationId}" name="auxiliaryExamination.auxiliaryExaminationId">
        <!-- 生活方式表ID -->
        <input type="hidden" value="${diabete.TLifeStyle.lifeId}" name="lifeStyle.lifeId">
        <!-- 生活方式表ID -->
        <input type="hidden" value="${diabete.TGeneralCondition.generalConditionId}" name="generalCondition.generalConditionId">
        <!-- 糖尿病总表ID -->
        <input type="hidden" value="${diabete.diabeteId}" name="diabete.diabeteId">
        
        
        <div class="btn-content">
          <input type="submit" class="btn" value="保存">
          <a href="<%=basePath %>showOldChronicAction!firstShowChronic.action" class="btn">返回</a>
          <!-- <a href="javascript:;" class="btn btn-back">返回</a> -->
        </div>
      </div>
      <!-- 结果容器 end -->
      </form>
    </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>

<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<script>
	function Num(obj){
	obj.value = obj.value.replace(/[^\d.]/g,"");
	obj.value = obj.value.replace(/^\./g,""); 
	obj.value = obj.value.replace(/\.{2,}/g,"."); 
	obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
	}
</script>
</body>
</html>
