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
       	当前人：${healthFile.name}&nbsp;&nbsp;&nbsp;&nbsp;档案编号：${healthFile.fileNum}&nbsp;&nbsp;&nbsp;&nbsp;疾病名称:${chronicDisease.diseaseName}
      <div class="table-content">
   <table class="table table-bordered">
     <thead>
       <tr>
         <th>随访医生</th>
         <th>症状特点</th>
         <th>心理状况</th>
         <th>随访时间</th>
         <th>操作</th>
       </tr>
     </thead>
     <tbody>
     <s:iterator value="otlist" var="ol">
       <tr>
         <td><c:out value="${ol.followPeople}"></c:out></td>
         <td><c:out value="${ol.symptomCharacteristic}"></c:out></td>
         <td><c:out value="${ol.metalState}"></c:out></td>
         <td><fmt:formatDate value="${ol.followDate}" pattern="yyyy-MM-dd" /></td>
         <td>
           <a href="oldChronicFollowAction!jumpShowFollow.action?fcid=${ol.chronicFollowId}&cid=${ol.chronicDiseaseId}&hid=${ol.healthFileId}" class="btn-xianshi">查看</a>
           <s:if test='healthFile.healthFileType!="0"'>
		   <s:if test='healthFile.healthFileType!="1"'>
           <a class="btn-xiugai" href="oldChronicFollowAction!jumpEditFollow.action?fcid=${ol.chronicFollowId}&cid=${ol.chronicDiseaseId}&hid=${ol.healthFileId}">修改</a>
           </s:if>
           </s:if>
           <a onclick="return confirm('是否删除？');" class="btn-shanchu" href="oldChronicFollowAction!deleteFollow.action?cid=${ol.chronicDiseaseId}&fcid=${ol.chronicFollowId}&hid=${ol.healthFileId}">删除</a>
         </td>
       </tr>
      </s:iterator>
     </tbody>
   </table>
   <div class="page">${pageHtml} </div>
   <div class="btn-content">
   <a href="<%=basePath %>showOldChronicAction!firstShowChronic.action" class="btn">返回</a>
	</div>
 </div>
<!-- <a href="javascript:;" class="btn btn-back">返回</a> -->

    </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>
      <input type = "hidden" name="cid"  value= "${chronicDisease.chronicDiseaseId}" >
      <input type = "hidden" name = "hid"  value= "${healthFile.healthFileId}">
<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
</body>
</html>
