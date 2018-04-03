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
  <input name="yemianname" value="01202" type="hidden"/>
    <!-- 主菜单 start -->
    <s:include value="/include/nav.jsp" />
    <!-- 主菜单 end -->
    <!-- 主容器 start -->
    <div class="container">
      <div class="search-content">
          <h3 class="current-title">慢病随访记录</h3>
         <%-- <div class="search-item">
      			 <label>姓名：${healthFile.name}&nbsp;&nbsp;&nbsp;&nbsp;档案编号：${healthFile.fileNum}</label>
          </div> --%>
         
        
      </div>
      <div class="table-content">
        <table id="jqprint" class="table table-bordered" style="word-break:break-all">
          <tbody>
      	<tr>
      		<td colspan="8" class="title-td" >
      			<label>
      				高血压随访记录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      				姓名：${healthFile.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      				档案编号：${healthFile.fileNum}
      			</label>
      		</td>
     	 </tr>
           <tr>
             <td>随访日期</td>
               <td> <label><fmt:formatDate value="${hypertensiveFollow.followDate}" pattern="yyyy-MM-dd" /></label></td>
             <td>随访方式</td>
             <td >
               <label><c:out value="${hypertensiveFollow.way}"></c:out></label>
             </td>
             <td>随访医生</td>
             <td colspan="3">
               <label><c:out value="${hypertensiveFollow.followPeople}"></c:out></label>
             </td>
           </tr>
           <tr>
             <td>主要症状</td>
             <td colspan="7">
           <label><c:out value="${hypertensiveFollow.mainSymptom}"></c:out></label>
             </td>
           </tr>
           <tr>
             <td colspan="8" class="title-td">体征</td>
           </tr>
           <tr>
             <td>体重（kg）</td>
             <td >
               <label><c:out value="${hypertensiveFollow.wight}"></c:out></label>
             </td>
              <td>身高（cm）</td>
             <td >
              <label><c:out value="${hypertensiveFollow.height}"></c:out></label>
             </td>
             <td>体质指数</td>
             <td >
              <label><c:out value="${hypertensiveFollow.bmi}"></c:out></label>
             </td>
             <td>舒张压（mmhg）</td>
             <td><label><c:out value="${hypertensiveFollow.bloodPressureH}"></c:out></label></td>
           </tr>
           <tr>
             <td>心率(次/分)</td>
             <td><label><c:out value="${hypertensiveFollow.heartRate}"></c:out></label></td>
             <td>其他</td>
             <td colspan="3"><label><c:out value="${hypertensiveFollow.others}"></c:out></label></td>
             <td>收缩压（mmhg）</td>
             <td><label><c:out value="${hypertensiveFollow.bloodPressureL}"></c:out></label></td>
             <tr>
             <td colspan="8" class="title-td">生活方式指导</td>
           </tr>
           <tr>
             <td>日吸烟量平均（支）</td>
             <td colspan="2" ><label><c:out value="${hypertensiveFollow.dailyCigaretteSmoking}"></c:out></label></td>
             <td> 日饮酒量平均（两）</td>
             <td colspan="2"><label><c:out value="${hypertensiveFollow.dailyDrinking}"></c:out></label></td>
               <td>遵医行为</td>
                <td >
               <label><c:out value="${hypertensiveFollow.treatmentCompliance}"></c:out></label>
               </td>
            </tr>
             <tr>
             <td>摄盐情况</td>
             <td colspan="2" >
               <label><c:out value="${hypertensiveFollow.takenSaltSituation}"></c:out></label>
             </td>
             
               <td>运动</td>
                <td colspan="2"><label>每周<c:out value="${hypertensiveFollow.timesSports}次;每次${hypertensiveFollow.timesSports}"></c:out>分</label></td>
                <td>心理调整</td>
                <td >
              <label><c:out value="${hypertensiveFollow.psychologicalAdjustment}"></c:out></label>
               </td>
              
            </tr>
              
           <tr>
             <td colspan="8" class="title-td">其他</td>
           </tr>
            <tr>
            <td>辅助检查</td>
             <td colspan="7"><label><c:out value="${hypertensiveFollow.supplementaryExamination}"></c:out></label></td>
             </tr>
             <tr>
              <td>服药依从性</td>
                <td >
                <label><c:out value="${hypertensiveFollow.medicationCompliance}"></c:out></label>
               </td>
                <td>药物不良反应</td>
                <td colspan="2">
           <label><c:out value="${hypertensiveFollow.adverseDrugReactions}"></c:out></label>
               </td>
                <td>此次随访分类</td>
                <td colspan="2">
               <label><c:out value="${hypertensiveFollow.followType}"></c:out></label>
               </td>
        <!--  <div class="table-content"> -->
                <tr>
                  <td colspan="8">用药情况</td>
                </tr> 
                <tr>
       <td colspan="8">
       <!--二级框开始-->
          <table  class="table table-bordered">
          <tbody>
            <tr>
               <td> 药品名称</td>
               <td> 每天服药次数</td>
               <td> 每次剂量(mg)</td>
               <td> 不良反应</td>        
            </tr>
         <s:iterator value="listdrug" var="ld">
               <tr>  
                <td><c:out value="${ld.drugName}"></c:out></td>
                <td><c:out value="${ld.timesTakeMedicineDaily}"></c:out></td>
                <td><c:out value="${ld.dailyDose}"></c:out></td>
                <td><c:out value="${ld.adverseReactions}"></c:out></td>      
            </tr>
     	</s:iterator> 
           </tbody>
          </table>
          <!--/二级框结束-->
       </td>
       
       

       </tr>
                <tr>
                <td>转诊</td>
                <td colspan="3">
             <label><c:out value="${hypertensiveFollow.heartReferral}"></c:out></label>
               </td>
                <td>下次随访日期</td>
                <td colspan="3">
                  <label><fmt:formatDate value="${hypertensiveFollow.laterDate}" pattern="yyyy-MM-dd" /></label>
               </td>
               </tr>
                 <tr rowspan="2">
                <td>备注</td>
                <td colspan="7">
                <label><c:out value="${hypertensiveFollow.dailyTip}"></c:out></label>
                </td>
                </tr>
          </tbody>
        </table>
        <div class="btn-content">
          <a href="javascript:;" class="btn btn-print">打印</a>
          <a href="<%=basePath %>oldChronicFollowAction!showOneAllFollow.action?cid=${chronicDisease.chronicDiseaseId}&hid=${healthFile.healthFileId}" class="btn">返回</a>
          <!-- <a href="javascript:;" class="btn btn-back">返回</a> -->
        </div>
      </div>
      
      <!-- 删除此行注释，在此添加对应的div -->

   
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
