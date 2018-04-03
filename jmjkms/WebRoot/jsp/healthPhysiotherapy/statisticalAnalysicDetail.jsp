<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<!-- 主菜单 start -->
		<s:include value="/include/nav.jsp" />
		<!-- 主菜单 end -->
		<!-- 主容器 start -->
		<div class="container">
			<h3 class="current-title">统计分析详情页</h3>
			<!-- 搜索容器 start -->
			<div class="table-content">
			<input name="yemianname" value="04203" type="hidden"/>
				<table class="table table-bordered" id="jqprint">
					<tbody>
						<tr>
							<td>康复计划名称</td>
							<td colspan="2">${plan.planName }</td>
						</tr>
						<tr>
							<td><label>康复方案方案</label></td>
							<td>${plan.TRecoveryScheme.schemeName }</td>
						</tr>
						<tr>
							<td><label>老人</label></td>
							<td>${plan.TStaff.name }</td>
						</tr>
						<tr>
							<td><label>开始日期</label></td>
							<td> <fmt:formatDate value="${plan.beginTime }" pattern="yyyy-MM-dd" /></td>
						</tr>

						<tr>
							<td><label>结束日期</label></td>
							<td><fmt:formatDate value="${plan.overTime }" pattern="yyyy-MM-dd" /></td>
						</tr>
						<tr>
							<td><label>状态</label></td>
										
							<s:if test="plan.status==0">
								<td>未开始</td>
							</s:if>
							<s:if test="plan.status==1">
								<td>正在执行</td>
							</s:if>
							<s:if test="plan.status==2">
								<td>已完成</td>
							</s:if>
						</tr>
						<tr>
          <td>
                        <label>制定人</label>
                        </td>
                         <td>
                         <c:out value=" ${plan.TStaff.name }"></c:out>
                           
                         </td>
         </tr>
           <tr>
          <td>
                       <label>制定日期</label>
                       </td>
                       <td>
                       <fmt:formatDate value="${plan.constituteTime }" pattern="yyyy-MM-dd" />
                       </td>
                       </tr>
            <tr>
             <td>
                   <label>康复计划简介</label>
                </td>
              	<td colspan="2" style="word-break:break-all;word-break-word;">
									<c:out value=" ${plan.planContent }"></c:out>
              </td>
            </tr>
					</tbody>
				</table>
				<div class="btn-content">
					<a href="healthPhysiotherapyAction!getRecovery.action" class="btn">返回</a> 
					<a href="javascript:;" class="btn btn-print btn-dayin">打印</a>
				</div>
			</div>
			<!-- 表格容器 end -->
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
