<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head><meta name="viewport" content="width=device-width, initial-scale=1.0"><meta http-equiv="X-UA-Compatible" content="ie=edge">
  <meta charset="UTF-8">
  <title>健康日常监测-健康档案</title>
  <link rel="stylesheet" href="css/cssreset.css">
  <link rel="stylesheet" href="css/main.css">
</head>
<body>
  <!-- 顶栏 start -->
  <s:include value="/include/header.jsp" />
  <!-- 顶栏 end -->
  <div class="main-content clearfix">
    <!-- 主菜单 start -->
    <s:include value="/include/nav.jsp" />
    <!-- 主菜单 end -->
    <!-- 主容器 start -->
    <div class="container">
      <h3 class="current-title">${localHealthFile.name}的健康日常监测</h3>
 <!-- 表格容器 start -->
 <div class="table-content">
 
<input name="yemianname" value="02201" type="hidden"/>
   <table class="table -able-bordered">
     <thead>
       <tr>
         <th>居民健康档案编号</th>
         <th>姓名</th>
         <th>性别</th>
         <th>血压档案</th>
         <th>血糖档案</th>
         <th>血氧档案</th>
         <th>健康一体机档案</th>
         <th>尿常规档案</th>
         <th>心电档案</th>
        </tr>
     </thead>
     <tbody>
       <tr>
         <td>${localHealthFile.fileNum}</td>
         <td>${localHealthFile.name}</td>
         <c:if test="${ localHealthFile.sex==false}"><td>男</td></c:if>
		 <c:if test="${ localHealthFile.sex==true}"><td>女</td></c:if>
         <td>
           <a href="HealthManagerAction!getBloodPressFromCloud.action?healthFileId=${localHealthFile.healthFileId }">查看详情</a>
         </td>
         <td>
           <a href="HealthManagerAction!getBloodSugerFromCloud.action?healthFileId=${localHealthFile.healthFileId}">查看详情</a>
         </td>
         <td>
           <a href="HealthManagerAction!getBloodOxygenFromCloud.action?healthFileId=${localHealthFile.healthFileId }">查看详情</a>
         </td>
         <td>
           <a href="HealthManagerAction!getAllInOneData.action?healthFileId=${localHealthFile.healthFileId }">查看详情</a>
         </td>
          <td>
           <a href="UrineAction!getList.action?healthFileId=${localHealthFile.healthFileId }">查看详情</a>
         </td>
         <td>
           <a href="EcgAction!getList.action?healthFileId=${localHealthFile.healthFileId }">查看详情</a>
         </td>
          </tr>
     </tbody>
   </table>
   <div class="btn-content">
          		<a href="HealthManagerAction!getHealthFileList.action" class="btn btn-xianshi">返回</a>
    </div>
 </div>
 <!-- 表格容器 end -->      
 </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>

<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
</body>
</html>
