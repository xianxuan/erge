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
      <h3 class="current-title">慢病年检</h3>
       	当前人：${healthFile.name}&nbsp;&nbsp;&nbsp;&nbsp;档案编号：${healthFile.fileNum}
      <div class="table-content">
   <table class="table table-bordered">
     <thead>
       <tr>
         <th>体检类型</th>
         <th>体检时间</th>
         <th>症状特点</th>
         <th>体检医生</th>
         <th>操作</th>
       </tr>
     </thead>
     <tbody>
     <s:iterator value="velist" var="vl">
       <tr>
         <td><c:out value="${vl.physicalExamType}"></c:out></td>
         <td><fmt:formatDate value="${vl.physicalExamDate}" pattern="yyyy-MM-dd" /></td>
         <td><c:out value="${vl.characteristicSymptom}"></c:out></td>
         <td><c:out value="${vl.responsibleDoctor}"></c:out></td>
         <td>
           <a href="<%=basePath %>PhysicalExamAction!showPhysicalExam.action?physicalExamId=${vl.physicalExamId}&isyear=true" class="btn-xianshi">查看</a>
         </td>
       </tr>
      </s:iterator>
     </tbody>
   </table>
   <div class="page">${pageHtml}</div>
   <div class="btn-content">
   <a href="<%=basePath %>showOldChronicAction!firstShowChronic.action" class="btn">返回</a>
	</div>
  
 </div>
	
    </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>
      <input type = "hidden" name = "helid"  value= "${healthFile.healthFileId}">
<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
</body>
</html>
