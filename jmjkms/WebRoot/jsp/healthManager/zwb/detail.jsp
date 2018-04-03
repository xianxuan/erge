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
<link rel="stylesheet" href="/jmjkms/css/cssreset.css">
<link rel="stylesheet" href="/jmjkms/css/main.css">
<link rel="stylesheet"
	href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">
<script type="text/javascript" src="/jmjkms/js/jquery-1.4.4.min.js"></script>
<style>
/* #genTab tr{height:30px;}
  #genTab td{border-style:solid;border-color:#000;border-width:0px 1px 1px 0px;text-align:center;} */
/* #getTab table{width:100%;border-style:solid;border-color:#000;border-width:1px 0px 0px 1px;border-collapse:collapse;cellSpacing:0px;cellPadding:0px;font:12pt;}
 */
.nav,.container {
	margin-bottom: -10000px;
	padding-bottom: 10000px;
}
</style>
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
			<h3 class="current-title">治未病_详情</h3>

			<!-- 删除此行注释，在此添加对应的div -->





			<div class="table-content" style="border:0">
				<input name="yemianname" value="02207" type="hidden" />
				<form action="">
					<table id="jqprint" class="table table-bordered">
						<caption style="text-align:center;font-size:20px;font-weight:bold">中医一体机体检详细信息</caption>
						<tbody>

							<tr>
								<th width='10%'>设备编号</th>
								<td width='30%'><c:out value="${xkHealthMachine.machineID}"></c:out></td>
								<th width='10%'>检测时间</th>
								<td><c:out value="${xkHealthMachine.examTime}"></c:out></td>
							</tr>
							<tr>
								<th width='10%'>用户名</th>
								<td><c:out value="${xkHealthMachine.personName}"></c:out></td>
								<th width='10%'>检测项目</th>
								<td><c:out value="${xkHealthMachine.JCXM}"></c:out></td>
							</tr>
							<tr>
								<th width='10%'>身份证号</th>
								<td><c:out value="${xkHealthMachine.IDNumber}"></c:out></td>
								<th width='10%'>民族</th>
								<td><c:out value="${xkHealthMachine.nation}"></c:out></td>
							</tr>
							<tr>
								<th width='10%'>性别</th>
								<td><c:out value="${xkHealthMachine.sex}"></c:out></td>
								<th width='10%'>年龄</th>
								<td><c:out value="${xkHealthMachine.age}"></c:out></td>
							</tr>
							<tr>
								<th width='10%'>地址</th>
								<td><c:out value="${xkHealthMachine.address}"></c:out></td>
								<th width='10%'>电话</th>
								<td><c:out value="${xkHealthMachine.telephone}"></c:out></td>
							</tr>
							<tr>
								<th width='10%'>主诉</th>
								<td colspan="3"><c:out value="${xkHealthMachine.ZS}"></c:out></td>
							</tr>
							<tr>
								<th width='10%'>既往史</th>
								<td colspan="3"><c:out value="${xkHealthMachine.JWS}"></c:out></td>
							</tr>
							<tr>
								<th width='10%'>测试记录</th>
								<td colspan="3"><div id='genTab'>
										<span id='txtTestData'><c:out
												value="${xkHealthMachine.testData}"></c:out></span>
									</div></td>
							</tr>
							<tr>
								<th width='10%'>诊断报告</th>
								<td colspan="3"><span id='txtZDBG'><c:out
											value="${xkHealthMachine.ZDBG}"></c:out></span></td>
							</tr>
							<tr>
								<th width='10%'>解决方案</th>
								<td colspan="3"><span id='txtJJFA'><c:out
											value="${xkHealthMachine.JJFA}"></c:out></span></td>
							</tr>

						</tbody>
					</table>

					<div class="btn-content">

						<a href="javascript:;" class="btn btn-back">返回</a>

					</div>
				</form>
			</div>



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
	<script type="text/javascript">
		function displayTestData() {
			var obj = document.getElementById('txtTestData');
			var data = obj.innerHTML;
			if (data != "") {
				var arr = data.split(';');
				var myTable = document.createElement("table");
				myTable.setAttribute('class', 'table table-hover');
				//myTable.setAttribute('style','border:0px;width:100%;border-collapse:collapse;cellSpacing:0px;cellPadding:0px;font:12pt;');
				var tblLen = 0;
				var tr = myTable.insertRow(0);
				tr.setAttribute('style',
						'font-size:20px;font-weight:bold;color:red');
				var th1 = tr.insertCell(0);
				var th2 = tr.insertCell(1);
				var th3 = tr.insertCell(2);
				th3.setAttribute('style',
						"width:10%;border-right:3px solid #ddd");
				var th4 = tr.insertCell(3);
				var th5 = tr.insertCell(4);
				var th6 = tr.insertCell(5);
				th6.setAttribute('style', "width:10%;");
				th1.innerHTML = "穴位";
				th2.innerHTML = "数值";
				th3.innerHTML = "状态";
				th4.innerHTML = "穴位";
				th5.innerHTML = "数值";
				th6.innerHTML = "状态";
				var odd = true;
				for (var i = 0; i < arr.length - 1;) {
					tblLen = myTable.rows.length;
					if (odd) {
						odd = false;
					} else {
						odd = true;
					}
					(function(s, s2, tbl, flag) {
						var tr2 = tbl.insertRow(tbl.rows.length);
						//tr2.setAttribute('style',"height:20px;");
						/* 	if (odd) {
								tr2.setAttribute('style',
										'background-color:#F9BB71');
							} */
						var arr2 = s.split(',');
						tr2.insertCell(0).innerHTML = arr2[0].substring(arr2[0]
								.indexOf(":") + 1);
						tr2.insertCell(1).innerHTML = arr2[1].substring(arr2[1]
								.indexOf(":") + 1);
						tr2.insertCell(2).innerHTML = arr2[2].substring(arr2[2]
								.indexOf(":") + 1);
						//tr2.setAttribute('style',"border-right:3px solid #ddd")
						if (s2 != '') {
							arr2 = s2.split(',');
							tr2.insertCell(3).innerHTML = arr2[0]
									.substring(arr2[0].indexOf(":") + 1);
							tr2.insertCell(4).innerHTML = arr2[1]
									.substring(arr2[1].indexOf(":") + 1);
							tr2.insertCell(5).innerHTML = arr2[2]
									.substring(arr2[2].indexOf(":") + 1);
						} else {//插入空白表格
							tr2.insertCell(3);
							tr2.insertCell(4);
							tr2.insertCell(5);
						}

					})(arr[i], arr[i + 1], myTable, odd);
					i = i + 2;
				}

				obj.parentNode.insertBefore(myTable, obj);
				obj.parentNode.removeChild(obj);
			}
			$("#genTab tr td:nth-child(3)").css("border-right",
					"3px solid #ddd")
		}
		function displaySpanData(id) {
			var spanEl = document.getElementById(id);
			var td = spanEl.parentNode;
			td.removeChild(spanEl);
			td.innerHTML = spanEl.firstChild.nodeValue;
		}
		function checkEmptyContent(id) {
			var content = document.getElementById(id).innerHTML;
			return content != '';
		}
		function onloadProcess() {
			if (checkEmptyContent('txtTestData')) {
				displayTestData();
			}
			if (checkEmptyContent('txtJJFA')) {
				displaySpanData('txtJJFA');
			}
			if (checkEmptyContent('txtZDBG')) {
				displaySpanData('txtZDBG');
			}
		}
		window.onload = onloadProcess;
	</script>
</body>
</html>
