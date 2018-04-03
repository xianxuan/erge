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
      <h3 class="current-title">集团管理</h3>
      
      <!-- 删除此行注释，在此添加对应的div -->
		<div class="search-content">
		<input name="yemianname" value="10205" type="hidden"/>
			<form class="search-form" action="<%=basePath %>communityHospitalGroupAction!getHosGroupList.action" method="post">
	        	<label>搜索类型：</label>
	            	<select name="field" id="select">
	              		<option <c:if test="${field=='groupName' }">
	                    	   selected="selected"
	                    	</c:if> value="groupName">社区集团名称</option>
	              		<option <c:if test="${field=='groupHostName' }">
	                    	   selected="selected"
	                    	</c:if> value="groupHostName">负责人</option>
	              		<option <c:if test="${field=='groupLoginname' }">
	                    	   selected="selected"
	                    	</c:if> value="groupLoginname">账号</option>
	              		<option <c:if test="${field=='groupPhone' }">
	                    	   selected="selected"

	                    	</c:if> value="groupPhone">电话</option>
	            	</select>
	            <input   class="text-input temp" type="text"  name="searchText" value="${searchText}">
	            <input type="submit" class="btn btn-xianshi" value="查询" />
	            <a class="btn-xinzeng btn" href="<%=basePath %>communityHospitalGroupAction!jumpAddHospitalGroup.action" class="btn" onclick="">新增</a>
	        </form>
			</div>
			<div class="table-content">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>社区集团名称</th>
							<th>集团地址</th>
							<th>医院个数</th>
							<th>负责人</th>
							<th>账号</th>
							<th>密码恢复</th>
							<th>电话</th>
							<th>状态</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="listGroups" var="ccommunityHospital">
							<tr>
								<td>${ccommunityHospital.groupName }</td>
								<td>${ccommunityHospital.groupAddress }</td>
								<td>
									<c:if test="${ccommunityHospital.groupHosptialCurrentNum!=0 }">
									   <a class="btn-xianshi"
                                    href="<%=basePath %>communityHospitalGroupAction!getHosInfo.action?GId=${ccommunityHospital.GId }">${ccommunityHospital.groupHosptialCurrentNum }</a>
									</c:if>
									<c:if test="${ccommunityHospital.groupHosptialCurrentNum==0 }">
                                       <a class="btn-xianshi">${ccommunityHospital.groupHosptialCurrentNum }</a>
                                    </c:if>
								</td>
								<td>${ccommunityHospital.groupHostName }</td>
								<td>${ccommunityHospital.groupLoginname }</td>
								<td><a onclick="return confirm('是否将该账号恢复为初始密码（即登录名）?');"
									href="<%=basePath %>communityHospitalGroupAction!changePassword.action?GId=${ccommunityHospital.GId }">密码恢复</a>
								</td>
								<td>${ccommunityHospital.groupPhone }</td>
								<td><c:if test="${ccommunityHospital.groupStatus==0}">
										<a class="changeStyle-04">启用</a>
										<a class="ck"
											onclick="return confirm('是否禁用？(禁用之后该集团的所有医院都将被禁用)');"
											href="<%=basePath %>communityHospitalGroupAction!changeState.action?GId=${ccommunityHospital.GId}&groupStatus='1'">禁用</a>
									</c:if> <c:if test="${ccommunityHospital.groupStatus==1}">
										<a class="ck" onclick="return confirm('是否启用？');"
											href="<%=basePath %>communityHospitalGroupAction!changeState.action?GId=${ccommunityHospital.GId}&groupStatus='0'">启用</a>
										<a class="changeStyle-04">禁用</a>
									</c:if></td>
								<td><a class="btn-xiugai"
									href="<%=basePath %>communityHospitalGroupAction!jumpEditHospitalGroup.action?GId=${ccommunityHospital.GId }">编辑</a>
									<a class="btn-shanchu"
									onclick="return confirm('是否删除？(删除之后该集团的所有医院同时被删除)');"
									href="<%=basePath %>communityHospitalGroupAction!deleteHosGroup.action?GId=${ccommunityHospital.GId }">删除</a>
								</td>
							</tr>
						</s:iterator>

					</tbody>
				</table>
				<div class="sum-btn">
				<div class="page">${ pageHtml }</div>
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
