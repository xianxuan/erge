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
      <h3 class="current-title">慢病随访记录</h3>
      
      <!-- 删除此行注释，在此添加对应的div -->
      
       <%-- <label>姓名：${healthFile.name}&nbsp;&nbsp;&nbsp;&nbsp;档案编号：${healthFile.fileNum}</label> --%>
      
       <div class="table-content">
        <table id="jqprint" class="table table-bordered" style="word-break:break-all">
          <tbody>
           <tr>
      <td colspan="8" class="title-td" >
      	<label>
      		冠心病随访记录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      		姓名：${healthFile.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      		档案编号：${healthFile.fileNum}
      	</label>
      </td>
      </tr>
           <tr>
             <td colspan="4">疾病名称： &nbsp;&nbsp;<label>冠心病</label></td>
             <td  colspan="4">
               	目前主要症状&nbsp;&nbsp;&nbsp;
               <label><c:out value="${coronaryFollow.mainSymptoms}"></c:out></label>
              </td>
           </tr>
           <%-- <tr>
              <td  colspan="8">
               	目前主要症状&nbsp;&nbsp;&nbsp;
               <label><c:out value="${coronaryFollow.mainSymptoms}"></c:out></label>
              </td>
           </tr> --%>
            <tr>
             <td>舒张压（mmHg）</td>
             <td>
               <label><c:out value="${coronaryFollow.diastolicBloodPressure}"></c:out></label>
             </td>
             <td>收缩压（mmHg）</td>
             <td>
               <label><c:out value="${coronaryFollow.systolicBloodPressure}"></c:out></label>
             </td>
             <td>心率（次/分）</td>
             <td>
               <label><c:out value="${coronaryFollow.heartRate}"></c:out></label>
             </td>
             <td>体重（kg）</td>
             <td>
               <label><c:out value="${coronaryFollow.weight}"></c:out></label>
             </td>
            </tr>
            <tr>
              <td>是否有心律失常</td>
               <td>
               <label>
               <s:if test="coronaryFollow.whetherArrhythmia==false"><c:out value="是"></c:out></s:if>
               <s:if test="coronaryFollow.whetherArrhythmia==true"><c:out value="否"></c:out></s:if>
               </label>
               </td>
               <td>是否定期测血压</td>
              <td>
               <label><c:out value="${coronaryFollow.testingBloodPressure}"></c:out></label>         
              </td>
               <td>平均测血压间隔时间（天）</td>
              <td>
              <label><c:out value="${coronaryFollow.averageMeasurementTime}"></c:out></label>
              </td>
              <td>是否用药</td>
              <td>
               <label><c:out value="${coronaryFollow.whetherDrug}"></c:out></label>
              </td>
            </tr>
            
             <tr>
              <td colspan="8" class="title-td">用药情况</td>
             </tr>
             <tr>
               <td colspan="8">
                 <!--二级框开始-->
          		<table  class="table table-bordered">
         		 <tbody>
          		  <tr>
               		<td> 药品名称</td>
               		<td> 每次剂量(mg)</td>
               		<td> 给药途径</td>
              		 <td> 不良反应</td>        
            	  </tr>
         	<s:iterator value="listdrug" var="ld">
               	 <tr>  
               		 <td><c:out value="${ld.drugName}"></c:out></td>
               		 <td><c:out value="${ld.dailyDose}"></c:out></td>
               		 <td><c:out value="${ld.drugPath}"></c:out></td>
              		 <td><c:out value="${ld.adverseReactions}"></c:out></td>      
                 </tr>
     		</s:iterator> 
        	 </tbody>
          	</table>
          <!--/二级框结束-->
               </td>
             </tr>
             <tr>
               <td>饮食情况</td>
               <td>
               <label><c:out value="${coronaryFollow.dietState}"></c:out></label>
               </td>
               <td>康复治疗情况</td>
              <td>
               <label><c:out value="${coronaryFollow.treatment}"></c:out></label>
               </td>
               <td>下次随访预约时间</td>
              <td> <label><fmt:formatDate value="${coronaryFollow.appointmentTimeNext}" pattern="yyyy-MM-dd" /></label></td>
             </tr>
             <tr>
              <td>随访指导意见</td>
               <td colspan="7"><label><c:out value="${coronaryFollow.guidance}"></c:out></label> </td>
  
             </tr>
             <tr>
               <td>备注</td>
               <td colspan="7">
               <label><c:out value="${coronaryFollow.remark}"></c:out></label></td>
             </tr>
             <tr>
              <td colspan="8" class="title-td"></td>
             </tr>
             <tr>
               <!-- <td colspan="2"></td> -->
               <%-- <td>被随访人</td>
               <td> <label><c:out value="${coronaryFollow.byFollowUp}"></c:out></label>  </td> --%>
               <td>随访医生</td>
               <td colspan="3"><label><c:out value="${coronaryFollow.followPeople}"></c:out></label></td>
               <td>随访时间</td>
               <td colspan="3"><label><fmt:formatDate value="${coronaryFollow.followDate}" pattern="yyyy-MM-dd" /></label></td>
             </tr>
          </tbody>
        </table>
        <div class="btn-content">
          <a href="javascript:;" class="btn btn-print">打印</a>
          <a href="<%=basePath %>oldChronicFollowAction!showOneAllFollow.action?cid=${chronicDisease.chronicDiseaseId}&hid=${healthFile.healthFileId}" class="btn">返回</a>
          <!-- <a href="javascript:;" class="btn btn-back">返回</a> -->
        </div>
      </div>

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
