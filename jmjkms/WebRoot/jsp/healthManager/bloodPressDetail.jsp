<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta charset="UTF-8">
<title>血压详情</title>
<link rel="stylesheet" href="/jmjkms/css/cssreset.css">
<link rel="stylesheet" href="/jmjkms/css/main.css">
<link type="text/css" href="/jmjkms/css/confirm.css">
<style type="text/css">
.thBg{background-color:#F5F5F6;}
</style>
</head>
<body>
	<div class="main-content clearfix" style="min-width:500px;">

		<!-- 主容器 start -->
		<div class="container" style="min-width:500px;min-height:300px;">
			<h3 class="current-title title-td">血压详情</h3>
			<!-- 表格容器 start -->
			<div class="search-content">
				<div class="search-item">
					<label>姓名：${healthfile.name}</label> &nbsp;&nbsp;&nbsp;&nbsp;<label>性别：<c:if
							test="${healthfile.sex==false }">男</c:if>
						<c:if test="${healthfile.sex==true }">女</c:if></label>
					&nbsp;&nbsp;&nbsp;&nbsp;<label>电话号码：${healthfile.IPhone}</label>
				</div>
			</div>
			<!-- begin -->
			<div class="table-content">
				<!-- 血压表单表格 start -->
					<table class="table table-bordered">
						<tbody>
							<tr>
								<td class="thBg">测量条件 <!--  
                          <input type="hidden"  value="${healthFileId}"  name="healthFileId" />
                          <input type="hidden"  value="${cloudId}"  name="cloudId" />
                          -->
								</td>
								<td><c:choose>
										<c:when test="${meaState==0 }">安静</c:when>
										<c:when test="${meaState==1 }">饮酒后</c:when>
										<c:otherwise>运动后</c:otherwise>
									</c:choose>
								</td>
								<td class="thBg">测量时间</td>
								<td>${meaTime}</td>
							</tr>
							<tr>
								<td class="thBg">是否服药</td>
								<td><c:choose>
										<c:when test="${takeMed==0 }">未服药</c:when>
										<c:otherwise>已服药</c:otherwise>
									</c:choose>
								</td>
								<td class="thBg">药物名称</td>
								<td>${medName }</td>
							</tr>
							<tr>
								<td class="thBg">测量手臂</td>
								<td><c:choose>
										<c:when test="${arm==0 }">左手</c:when>
										<c:otherwise>右手</c:otherwise>
									</c:choose></td>
								<td class="thBg">脉率(次/min)</td>
								<td>${pulse }</td>

							</tr>
							<tr>
								<td class="thBg">收缩压(mmHg)</td>
								<td>${sysPre}</td>
								<td class="thBg">舒张压(mmHg)</td>
								<td>${diaPre }</td>
							</tr>
						</tbody>
					</table>
					<div class="btn-content">
						<button class="btn" type="button" onclick="window.close();">关闭</button>
					</div>
				<!-- 血压表单表格 end -->
			</div>
			<!--end -->
		</div>
		<!-- 主容器 end -->
	</div>
	<!--  
<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
  <script src="js/sweetalert.min.js"></script> 
<script src="/jmjkms/js/base.js"></script>
<script src="/jmjkms/js/healthManager.js"></script>
<script type="text/javascript" src="/jmjkms/js/confirm/Validform_v5.3.2_min.js"></script>
-->
</body>
</html>
