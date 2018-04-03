<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <!-- 主菜单 start -->
    <s:include value="/include/nav.jsp" />
    <!-- 主菜单 end -->
    <!-- 主容器 start -->
    <div class="container">
	<h3 class="current-title">角色权限管理</h3>
      
		<!-- 删除此行注释，在此添加对应的div -->
		<div class="table-content">
		<input name="yemianname" value="10204" type="hidden"/>
		  	<s:form>
       		<table class="table table-bordered">
         		<thead>
           			<tr>
             			<th>角色</th>
             			<th>操作</th>
           			</tr>
         		</thead>
         		<tbody>
         		  <s:iterator value="listRoles" var="role">
           			<tr>
              			<td>${role.roleName}</td>
              			<td>
               				<a class="btn-xianshi" href="<%=basePath %>roleAction!jumpFindRoleInfo.action?roleId=${role.roleId}">查看权限</a>
               				<a class="btn-xiugai" href="<%=basePath %>roleAction!jumpEditRole.action?roleId=${role.roleId}">编辑</a>
               				<a class="btn-shanchu" onclick="return confirm('是否删除该角色？');" href="<%=basePath %>roleAction!deleteRole.action?roleId=${role.roleId}">删除</a>
              			</td>
           			</tr>
            	  </s:iterator>
         		</tbody>
       		</table>
       		</s:form>
       		<div class="btn-content">
          		<a class="btn btn-xinzeng" href="roleAction!jumpAddRole.action">新增角色</a>
      		</div>
     	</div>
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
