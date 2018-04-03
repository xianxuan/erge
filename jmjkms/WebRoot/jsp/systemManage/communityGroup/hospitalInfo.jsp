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
  <link rel="stylesheet" type="text/css" href="/jmjkms/css/sweetalert.css"> 
  <link rel="stylesheet" href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">
  <script src="/jmjkms/js/sweetalert.min.js"></script>
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
    <input name="yemianname" value="10205" type="hidden"/>
      <h3 class="current-title">集团管理</h3>
      
      <!-- 删除此行注释，在此添加对应的div -->
		<div class="table-content">
			<table class="table table-bordered">
	        	<thead>
	           		<tr>
	             		<th>社区医院名称</th>
			            <th>医院地址</th>
			            <th>医院等级</th>
			            <th>负责人</th>
			            <th>账号</th>
			            <th>电话</th>
			            <th>状态</th>
		           </tr>
	         	</thead>
	         	<tbody>
	         	<s:iterator value="listHos" var="ccommunityHospital">
					<tr>
	             		<td>${ccommunityHospital.communityHospital }</td>
	             		<td>${ccommunityHospital.address }</td>
	             		<td>${ccommunityHospital.hospitalLevel }</td>
	             		<td>${ccommunityHospital.name }</td>
	             		<td>${ccommunityHospital.login }</td>
	             		<td>${ccommunityHospital.phone }</td>
	             		<td>
                      		<c:if test="${ccommunityHospital.status==0}">
                      			<lable>启用</lable>
                      		</c:if> 
                      		<c:if test="${ccommunityHospital.status==1}">
                      			<lable>禁用</lable>
                      		</c:if>
	             		</td>
	           		</tr>
	           		</s:iterator>
	           	
				</tbody>
			</table>
			<div class="sum-btn">
			<div class="btn-content2">
                 <a href="<%=basePath %>communityHospitalGroupAction!getHosGroupList.action" class="btn">返回</a>
            </div>
            
			<div class="page">
       		 ${ pageHtml }
        	</div>
        	</div>
		</div>
    </div>

    </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->

<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>

</body>
</html>
