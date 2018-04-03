<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta charset="UTF-8">
<c:choose>
	<c:when test="${session.comHospital.isHead==0}">
		<title>中电科社区健康管理平台</title>
	</c:when>
	<c:when test="${session.communityHospitalGroup!=null}">
		<title>社区健康管理系统</title>
	</c:when>
	<c:otherwise>
		<title>社区健康服务站</title>
	</c:otherwise>
</c:choose>
<link rel="stylesheet" href="css/cssreset.css">
<link rel="stylesheet" href="css/main.css">
<link rel="stylesheet" type="text/css" href="css/sweetalert.css">
</head>
<body>
	<!-- 顶栏 start -->
	<c:choose>
		<c:when test='${embeded }'>
		</c:when>
		<c:otherwise>
			<s:include value="/include/header.jsp" />
		</c:otherwise>
	</c:choose>

	<!-- 顶栏 end -->
	<div class="main-content clearfix">
		<!-- 主菜单 start -->
		<c:choose>
			<c:when test='${embeded }'>
			</c:when>
			<c:otherwise>
				<s:include value="/include/nav.jsp" />
			</c:otherwise>
		</c:choose>
		<!-- 主菜单 end -->
		<!-- 主容器 start -->
		<div class="container">
			<h3 class="current-title">血压档案-数据分析</h3>
			<input name="yemianname" value="02201" type="hidden" />
			<div class="search-content">
				<div class="btn-content">
					<a
						href="HealthManagerAction!getBloodPressFromCloud.action?bloodForward=0&healthFileId=${localHealthFile.healthFileId }&embeded=${embeded}"
						class="btn">数据分析</a> <a
						href="HealthManagerAction!getBloodPressFromCloud.action?bloodForward=1&healthFileId=${localHealthFile.healthFileId}&embeded=${embeded}"
						class="btn btn-default">趋势分析</a> <a
						href="HealthManagerAction!getBloodPressFromCloud.action?bloodForward=2&healthFileId=${localHealthFile.healthFileId }&embeded=${embeded}"
						class="btn btn-default">详细数据</a>
					<%-- <a href="HealthManagerAction!getBloodPressFromCloud.action?bloodForward=3&healthFileId=${localHealthFile.healthFileId }" class="btn btn-default">康复计划</a> --%>
				</div>
			</div>
			<form action="HealthManagerAction!bloodPressDataAnalysis.action"
				method="post">
				<div class="search-item">
					<s:radio name="searchType" cssClass="type"
						list="#{'0':'按时间查询','1':'按数量查询'}" label="请选择查询类型"></s:radio>
					<label><input type="hidden" name="healthFileId"
						value="${localHealthFile.healthFileId }" /></label>
				</div>
				<div class="search-item">
					<div id="time" style="display: inline-block;">
						<label>时间:<input id="startTime" type="text" class="w150"
							onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"
							value="<fmt:formatDate value="${startTime }" pattern="yyyy-MM-dd HH:mm:ss"/>"
							name="startTime" onfocus="this.blur()"> 至 <input
							type="text" id="endTime" class="w150"
							onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"
							value="<fmt:formatDate value="${endTime }" pattern="yyyy-MM-dd HH:mm:ss"/>"
							name="endTime" onfocus="this.blur()">
						</label>
					</div>
					<div id="size" style="display:none;">
						<label>最近信息条数：</label> <input type="text" class="w40"
							onkeyup="this.value=this.value.replace(/\D/g,'')"
							onafterpaste="this.value=this.value.replace(/\D/g,'')"
							maxlength='10' name="totalSize" id="num" value="${ totalSize}">

					</div>
					<input type="submit" id="sub" class="btn" value="查询">
					<input type='hidden' id='embeded' name='embeded' value='${embeded}'/>
				</div>
			</form>
			<!-- 表单表格 start -->
			<div class="table-content">
				<table class="table table-bordered">
					<tbody>
						<tr>
							<td colspan="2">类别</td>
							<td colspan="2">收缩压(mmHg)</td>
							<td colspan="2">舒张压(mmHg)</td>
							<td colspan="2">脉率(次/min)</td>
						</tr>
						<tr>
							<td colspan="2">最高值</td>
							<td colspan="2">${bloodPresseList[0].sysPre }</td>
							<td colspan="2">${bloodPresseList[0].diaPre }</td>
							<td colspan="2">${bloodPresseList[0].pulse }</td>
						</tr>
						<tr>
							<td colspan="2">最低值</td>
							<td colspan="2">${bloodPresseList[1].sysPre }</td>
							<td colspan="2">${bloodPresseList[1].diaPre }</td>
							<td colspan="2">${bloodPresseList[1].pulse }</td>
						</tr>
						<tr>
							<td colspan="2">平均值</td>
							<td colspan="2">${bloodPresseList[2].sysPre }</td>
							<td colspan="2">${bloodPresseList[2].diaPre }</td>
							<td colspan="2">${bloodPresseList[2].pulse }</td>
						</tr>
						<tr>
							<td colspan="2">平均值6:00-9:00</td>
							<td colspan="2">${bloodPresseList[3].sysPre }</td>
							<td colspan="2">${bloodPresseList[3].diaPre }</td>
							<td colspan="2">${bloodPresseList[3].pulse }</td>
						</tr>
						<tr>
							<td colspan="2">平均值18:00-21:00</td>
							<td colspan="2">${bloodPresseList[4].sysPre }</td>
							<td colspan="2">${bloodPresseList[4].diaPre }</td>
							<td colspan="2">${bloodPresseList[4].pulse }</td>
						</tr>
					</tbody>
				</table>
				<div class="btn-content">
					<c:choose>
						<c:when test='${embeded }'>
							<a class="btn btn-xianshi" onclick='editReturn();'>返回</a>
						</c:when>
						<c:otherwise>
							<a
								href="HealthManagerAction!getDataFromCloud.action?healthFileId=${localHealthFile.healthFileId}"
								class="btn btn-xianshi">返回</a>
						</c:otherwise>
					</c:choose>


				</div>
			</div>
			<!-- 表单表格 start -->
		</div>
		<!-- 主容器 end -->
		<!-- 底栏 Start-->
		<c:choose>
			<c:when test='${embeded }'>
			</c:when>
			<c:otherwise>
				<s:include value="/include/footer.jsp" />
			</c:otherwise>
		</c:choose>

		<!-- 底栏 Start-->
	</div>
	<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
	<script src="js/sweetalert.min.js"></script>
	<script src="/jmjkms/js/laydate/laydate.js"></script>
	<script src="/jmjkms/js/base.js"></script>
	<script src="/jmjkms/js/healthManager.js"></script>
	<script src='/jmjkms/js/dkdhcommon.js'>
	<script type="text/javascript">
		$(function() {
			$("#registerform").Validform({
				showAllError : false,
				tiptype : function(msg) {
					alert(msg);
				}
			});
		});
	</script>
	<script type="text/javascript">
		$(function() {
			var searchType = ${searchType};
			if (searchType == 1) {
				document.getElementsByName('searchType')[1].checked = true;
			} else {
				document.getElementsByName('searchType')[0].checked = true;
			}
			var value = ${searchType} + "";
			hiddenSearch(value);
		})
	</script>
	<script type="text/javascript">
		$("form").submit(function() {
			var startTime0 = $("#startTime").val();
			var endTime0 = $("#endTime").val();
			if (startTime0 != "" || endTime0 != "") {
				if (startTime0 > endTime0) {
					$("#startTime").val("");
					$("#endTime").val("");
					alert("查询时间输入错误");
					return false;
				}
			}
			if (startTime0 == "" && endTime0 == "" && $("#num").val() == "") {
				alert("请输入正确查询条件!")
				return false;
			}
			if ($("#num").val() != "" && $("#num").val() == 0) {
				alert("请输入正确查询条件!")
				return false;
			}
		})
	</script>
	<script type="text/javascript">
		//单选框改变
		$(".type").change(function() {
			hiddenSearch($(this).val())
		});
		//隐藏查询条件
		function hiddenSearch(value) {
			if (value === "0") {
				$("#time").css("display", "inline-block");
				$("#size").css("display", "none");
			}
			if (value === "1") {
				$("#time").css("display", "none");
				$("#size").css("display", "inline-block");
			}
		};
	</script>
	<script>
		function Num(obj) {
			obj.value = obj.value.replace(/[^\d.]/g, "");
			obj.value = obj.value.replace(/^\./g, "");
			obj.value = obj.value.replace(/\.{2,}/g, ".");
			obj.value = obj.value.replace(".", "$#$").replace(/\./g, "")
					.replace("$#$", ".");
		}
	</script>
</body>
</html>