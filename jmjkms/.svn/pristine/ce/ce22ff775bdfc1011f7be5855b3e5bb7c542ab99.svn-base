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
  <link type="text/css" href="jmjkms/css/yang/confirm.css">
  
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
      <h3 class="current-title">编辑高血压档案</h3>
      <form action="<%=basePath %>showOldChronicAction!editHighBlood.action" method="post" >
      <div class="table-content">
        <table class="table table-bordered">
          <tbody>
           <tr>
             <td colspan="8" class="title-td">基本信息
             <input type = "hidden" name = "helid"  value= "${healthFile.healthFileId}" ></td>
           </tr>
           <tr>
             <td>高血压类型</td>
             <td colspan="2">
               <select name = "highBloodPressure.highBloodTypr">
                  <s:iterator value="gxytype" var="g">
               <option value="${g.name}" <c:if test="${g.name eq vchronic.highBloodTypr}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>高血压管理分级<input type = "hidden" name = "htype"  value= "${vchronic.healthFileType}"></td>
             <td colspan="2">
               <select name = "highBloodPressure.managementClass">
                 <option value = "">请选择</option>
                 <s:iterator value="gxyglfj" var="g">
                 <option value = "${g.name}" <c:if test="${g.name eq vchronic.managementClass}">selected</c:if>>${g.name}</option>
                 </s:iterator>
               </select>
             </td>
             <td>初次诊断时间</td>
             <td><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="highBloodPressure.initialDiagnosisTime" value="<fmt:formatDate value="${vchronic.highBloodInitialDiagnosisTime}"  pattern="yyyy-MM-dd"/>"></td>
           </tr>
           <tr>
             <td>目前主要症状</td>
             <td colspan="3" >
               <select name = "highBloodPressure.mainSymptoms">
                 <option value="" >请选择</option>
                  <s:iterator value="mqzyzz" var="g">
               <option value="${g.name}" <c:if test="${g.name eq vchronic.mainSymptoms}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>高血压并发症</td>
             <td colspan="3">
               <select name = "highBloodPressure.hypertensionComplication">
                   <option value="" >请选择</option>
                  <s:iterator value="gxybfz" var="g">
               <option value="${g.name}" <c:if test="${g.name eq vchronic.hypertensionComplication}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
           </tr>
           <tr>
             <td>多长时间量一次血压</td>
             <td>
               <select name = "highBloodPressure.howLongTakeBlood">
                  <option value="">请选择</option>
                  <s:iterator value="dcsjlycxy" var="g">
               <option value="${g.name}" <c:if test="${g.name eq vchronic.howLongTakeBlood}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>是否服用降压药</td>
             <td>
               <select name = "highBloodPressure.takeMedication">
	                 <option value = "">请选择</option>
	                 <option value = "是" <c:if test="${'是' eq vchronic.hcvdElectroencephalogram}">selected</c:if>>是</option>
	                 <option value = "否" <c:if test="${'否' eq vchronic.hcvdElectroencephalogram}">selected</c:if>>否</option>
               </select>
             </td>
             <td>不服或不规律服药原因</td>
             <td>
               <select name = "highBloodPressure.notTakeReason">
                  <option value="" >请选择</option>
                  <s:iterator value="bfhbglfyyy" var="g">
               <option value="${g.name}" <c:if test="${g.name eq vchronic.notTakeReason}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>每日高血压药物费用</td>
             <td>
               <input onkeyup="Num(this)" type="text" name = "highBloodPressure.drugCost" value="${vchronic.drugCost }" maxlength='10' >
             </td>
           </tr>
           <tr>
             <td>非药物方法治疗高血压</td>
             <td colspan="3" > 
               <select name = "highBloodPressure.nonDrugTreatment">
                 <option value="">请选择</option>
                  <s:iterator value="fywffzlgxy" var="g">
               <option value="${g.name}" <c:if test="${g.name eq vchronic.nonDrugTreatment}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
            <td>家族中高血压患者</td>
              <td colspan="3">
               <select name = "highBloodPressure.familyWhitHighBlood">
                 <option value="">请选择</option>
                  <s:iterator value="jzzgxyhz" var="g">
               <option value="${g.name}" <c:if test="${g.name eq vchronic.familyWhitHighBlood}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
           </tr>

           <tr>
                <td colspan="8" class="title-td">一般情况</td>
           </tr>
          <tr>
             <td >体温</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name = "generalCondition.temperature" value="${highBloodPressure.TGeneralCondition.temperature}" maxlength='10' ></td>
             <td >呼吸频率（次/分钟）</td>
             <td><input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text"  class="w40" name = "generalCondition.breathingRate" value="${highBloodPressure.TGeneralCondition.breathingRate}" maxlength='10' ></td>
             <td >舒张压（mmHg）</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name = "generalCondition.diastolicPressure" value="${highBloodPressure.TGeneralCondition.diastolicPressure}" maxlength='10' ></td>
             <td>收缩压（mmHg）</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name = "generalCondition.systolicPressure" value="${highBloodPressure.TGeneralCondition.systolicPressure}" maxlength='10'></td>
           </tr>
           <tr>
             
             <td >脉率（次/分钟）</td>
             <td><input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text"  class="w40" name = "generalCondition.pulseRate" value="${highBloodPressure.TGeneralCondition.pulseRate}" maxlength='10'></td>
             <td >身高（CM）</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name = "generalCondition.height" value="${highBloodPressure.TGeneralCondition.height}" maxlength='10'></td>
             <td>体重（kg)</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name = "generalCondition.weight" value="${highBloodPressure.TGeneralCondition.weight}" maxlength='10'></td>
             <td>体质指数</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name = "generalCondition.bmi" value="${highBloodPressure.TGeneralCondition.bmi}" maxlength='10'></td>
           </tr>
           <tr>
              <td>腰围（CM）</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name = "generalCondition.waistline" value="${highBloodPressure.TGeneralCondition.waistline}" maxlength="10" ></td>
             <td>臀围（CM）</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name = "generalCondition.hip" value="${highBloodPressure.TGeneralCondition.hip}" maxlength="10" ></td>
             <td >腰臀围比值</td>
             <td colspan="4"><input onkeyup="Num(this)" type="text"  name = "generalCondition.ratio" value="${highBloodPressure.TGeneralCondition.ratio}" maxlength="10" ></td>
           </tr>

           <tr>
                <td colspan="8" class="title-td">生活方式</td>
           </tr>
           <tr>
              <td>体育锻炼频率</td>
              <td > 
               <select name = "lifeStyle.exerciseFrequency">
                  <option value="" >请选择</option>
                  <s:iterator value="tydlpl" var="g">
               <option value="${g.name}" <c:if test="${g.name eq highBloodPressure.TLifeStyle.exerciseFrequency}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
              <td>每次锻炼时间（分钟）</td>
             <td><input type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" class="w40" name = "lifeStyle.exerciseTime" value="${highBloodPressure.TLifeStyle.exerciseTime}" maxlength="10" ></td>
              <td>坚持锻炼时间（年）</td>
             <td><input type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" class="w40" name = "lifeStyle.allExerciseTime" value="${highBloodPressure.TLifeStyle.allExerciseTime}" maxlength="10" ></td>
             <td>锻炼方式</td>
             <td> 
               <select name = "lifeStyle.exerciseType">
                 <option value="" >请选择</option>
                  <s:iterator value="dlfs" var="g">
               <option value="${g.name}" <c:if test="${g.name eq highBloodPressure.TLifeStyle.exerciseType}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
           </tr>
           <tr>
             <td>饮食习惯</td>
             <td colspan="3"> 
               <select name = "lifeStyle.dietaryHabit">
                  <option value="">请选择</option>
                  <s:iterator value="ysxg" var="g">
               <option value="${g.name}" <c:if test="${g.name eq highBloodPressure.TLifeStyle.dietaryHabit}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>吸烟状况</td>
             <td colspan="3"> 
               <select name = "lifeStyle.smokingStatus">
                 <option value="" >请选择</option>
                  <s:iterator value="xyzk" var="g">
               <option value="${g.name}" <c:if test="${g.name eq highBloodPressure.TLifeStyle.smokingStatus}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
           </tr>
            <tr>
             <td>日吸烟量平均（支）</td>
             <td><input  type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" class="w40" name = "lifeStyle.smokingOneday" value="${highBloodPressure.TLifeStyle.smokingOneday}" maxlength='10'></td>
             <td>开始吸烟年龄（岁）</td>
             <td><input  type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" class="w40" name = "lifeStyle.startsmokingAge" value="${highBloodPressure.TLifeStyle.startsmokingAge}" maxlength='10'></td>
             <td>戒烟年龄（岁）</td>
             <td><input  type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" class="w40" name = "lifeStyle.giveupSmokingAge" value="${highBloodPressure.TLifeStyle.giveupSmokingAge}" maxlength='10'></td>
             <td>饮酒频率</td>
             <td > 
               <select name = "lifeStyle.drinkingFrequency">
                <option value="" >请选择</option>
                  <s:iterator value="yjpl" var="g">
               <option value="${g.name}" <c:if test="${g.name eq highBloodPressure.TLifeStyle.drinkingFrequency}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
           </tr>
            <tr>
             <td>日饮酒量平均（两）</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name = "lifeStyle.monthlyDrinking" value="${highBloodPressure.TLifeStyle.monthlyDrinking}" maxlength='10'></td>
             <td>是否戒酒</td>
             <td > 
               <select name = "lifeStyle.abstinence">
                  <option value = "">请选择</option>
                 <option value = "是" <c:if test="${'是' eq highBloodPressure.TLifeStyle.abstinence}">selected</c:if>>是</option>
                 <option value = "否" <c:if test="${'否' eq highBloodPressure.TLifeStyle.abstinence}">selected</c:if>>否</option>
               </select>
             </td>
             <td>开始饮酒年龄（岁）</td>
             <td><input  type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" class="w40" name = "lifeStyle.startDrinkingAge" value="${highBloodPressure.TLifeStyle.startDrinkingAge}" maxlength='10' ></td>
             <td>近一年是否曾醉酒</td>
             <td > 
               <select name = "lifeStyle.recentlyYearDrinking">
                 <option value="">请选择</option>
                 <option value = "true" <c:if test="${highBloodPressure.TLifeStyle.recentlyYearDrinking eq 'true'}">selected</c:if>>是</option>
                 <option value = "false" <c:if test="${highBloodPressure.TLifeStyle.recentlyYearDrinking eq 'false'}">selected</c:if>>否</option>
               </select>
             </td>
           </tr>
           <tr>
             <td>饮酒种类</td>
             <td colspan="7"> 
               <select name = "lifeStyle.drinkingType">
                  <option value="" >请选择</option>
                  <s:iterator value="yjzl" var="g">
               <option value="${g.name}" <c:if test="${g.name eq highBloodPressure.TLifeStyle.drinkingType}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
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
             <td >建档人 </td>
             <td><label>${vchronic.chronicDiseaseFileName}  </label> </td>
             <td >建档日期 </td>
             <td colspan="3"><label><fmt:formatDate value="${vchronic.chronicDiseaseFileDate}" pattern="yyyy-MM-dd"/></label> </td>
             </tr>
          
          </tbody>
        </table>
        <!-- 慢性病总表Id  使用隐藏域-->
        <input type="hidden" value="${chronicDisease.chronicDiseaseId}" name="chronicDisease.chronicDiseaseId">
        <!-- 生活方式表ID -->
        <input type="hidden" value="${highBloodPressure.TLifeStyle.lifeId}" name="lifeStyle.lifeId">
        <!-- 生活方式表ID -->
        <input type="hidden" value="${highBloodPressure.TGeneralCondition.generalConditionId}" name="generalCondition.generalConditionId">
        <!-- 高血压总表ID -->
        <input type="hidden" value="${highBloodPressure.highBloodPressureId}" name="highBloodPressure.highBloodPressureId">
        <div class="btn-content">
          <input type="submit" class="btn" value="保存">
          <a href="<%=basePath %>showOldChronicAction!firstShowChronic.action" class="btn">返回</a>
          <!-- <a href="javascript:;" class="btn btn-back">返回</a> -->
        </div>
      </div>
      </form>
      <!-- 结果容器 end -->
    </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>

<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<script type="text/javascript" src="jmjkms/js/yang/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="jmjkms/js/yang/Validform_v5.3.2_min.js"></script>
	<script type="text/javascript">
    $(function(){
      $("#registerform").Validform({
        showAllError:false,
        tiptype:function(msg){          
          alert(msg);
        }
      });
  });
</script>
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
