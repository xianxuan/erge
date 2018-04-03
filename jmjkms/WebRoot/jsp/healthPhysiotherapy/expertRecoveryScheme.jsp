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
		<input name="yemianname" value="10202" type="hidden"/>
			<h3 class="current-title">专家康复方案</h3>
			<!-- 搜索容器 start -->
			
			<td colspan="8" class="title-td">查询条件</td>
			<div class="search-content">
				<form action="<%=basePath%>healthPhysiotherapyAction!getExpertScheme.action" method="post" enctype="multipart/form-data" name="myForm">
					<label>查询条件选项：</label> 
					<select name="mySelect" id="mySelect">
					<s:if test="trecoveryScheme.schemeName!=''">
						<option value="方案名称"selected="selected">方案名称</option>
						<option value="制定人">制定人</option>
						</s:if>
					<s:elseif test="trecoveryScheme.TStaff.name!=''">
					<option value="方案名称">方案名称</option>
						<option value="制定人"selected="selected">制定人</option>
					</s:elseif>
					<s:else>
					<option value="方案名称"selected="selected">方案名称</option>
						<option value="制定人">制定人</option>
					</s:else>
					</select> 
					<input   id="scheme" type="text" class="w150"name="trecoveryScheme.schemeName" value="${trecoveryScheme.schemeName }" > 
					<input   id="people" type="text" class="w150" name="trecoveryScheme.TStaff.name" value="${trecoveryScheme.TStaff.name }"> 
					<input type="submit" class="btn" name="submit" id="submit" value="查询">
					 <a	href="<%=basePath%>healthPhysiotherapyAction!jumpAddExpertScheme.action" class="btn btn-xinzeng">添加</a>
				</form>
			</div>
			<!-- 搜索容器 start -->
			<!-- 表格容器 start -->
			<form action="<%=basePath%>healthPhysiotherapyAction!expertExport.action"
				method="post">
			<td colspan="8" class="title-td">查询结果</td>
			<div class="table-content">
				<table class="table table-bordered" id="jqprint">
					<thead>
						<tr>
							<th>康复方案名称</th>
							<th>康复方案简介</th>
							<th>制定人</th>
							<th>日期</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="schemeList" var="list">
						<input type="hidden" name="ids"
									value="${list.recoverySchemeId }" />
							<tr>
								<td>${list.schemeName }</td>
								<td>
									 <span class="cspan">
                                     		${list.recoveryPaln } 
                                     </span>
                                </td>
								<td>${list.note}</td>
								<td><fmt:formatDate value="${list.constituteTime }" pattern="yyyy-MM-dd" /></td>
								<td>
								<a  href="healthPhysiotherapyAction!expertSchemeDetails.action?id=${list.recoverySchemeId }">详情</a>
								<a onclick="return confirm('是否删除？');" href="<%=basePath %>healthPhysiotherapyAction!deleteExpertSchemeById.action?id=${list.recoverySchemeId } "class="btn-shanchu">删除</a>
							   </td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
				<!-- 分页 Start -->
				<input type="hidden" name="flag" id="act" value=""></input>
				<div class="sum-btn">
					<div class="page">${pageHtml}</div>
					<!-- 分页 end -->
					<div class="btn-content2">
	
							<input type="submit" class="btn btn-daochu" value="导出全部"
								onclick="run01()"></input> <input type="submit"
								class="btn btn-daochu" value="导出本页" onclick="run02()"></input>
								
					</div> 
				</div>
			</div>
			<!-- 表格容器 end -->
			</form>
		</div>
		<!-- 主容器 end -->
		<!-- 底栏 Start-->
		<s:include value="/include/footer.jsp" />
		<!-- 底栏 Start-->
	</div>

    <script src="/jmjkms/js/jquery-1.4.4.min.js"></script>
  	<script src="/jmjkms/js/jquery.jqprint-0.3.js"></script>
	<script src="/jmjkms/js/laydate/laydate.js"></script>
	<script src="/jmjkms/js/base.js"></script>
	<script>
		var Obtn01 = document.getElementById("btn01");
		var Obtn02 = document.getElementById("btn02");
		var Obtn03 = document.getElementById("btn03");
		var Oact = document.getElementById("act");
		function run01() {
			Oact.value = 1;
		}
		function run02() {
			Oact.value = 2;
		}
		function run03() {
			Oact.value = 3;
		}
		
	</script>
	<script type="text/javascript">
		$(function() {
		
			if($("select[name=mySelect]").val() == "方案名称"){	
				$("#scheme").show();
				$("#people").hide();
				$("#people").val("");
				var input = $("#scheme").val();//获得input输入框的值，如果你要联动效果就要获取省份的ID进行判断
		       console.log(input);
				
			}else{
				$("#scheme").hide();
				$("#people").show();
				$("#scheme").val("");
			}
			$("select[name=mySelect]").bind("change", function changeInput() {
				if ($(this).val() == "方案名称") {
					$("#scheme").show();
					$("#people").hide();
					$("#people").val("");
				} else {
					$("#scheme").hide();
					$("#people").show();
					$("#scheme").val("");
				}
			});
			 if('${jsonString}'!="")
	     {
	      alert('该康复方案下有康复计划');
	     }
			
		});
	</script>
</body>
</html>
