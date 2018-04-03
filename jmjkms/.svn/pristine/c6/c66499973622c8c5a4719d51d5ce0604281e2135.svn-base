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
<link rel="stylesheet"
	href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">
	<style type="text/css">
  span.cspan{
    display: inline-block;        
    width:150px; /这个宽度可以根据自己需要，大小自己决定/
    word-break:keep-all;/* 不换行 */  
    white-space:nowrap;/* 不换行 */  
    overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */  
    text-overflow:ellipsis;/* 文本溢出时显示省略标记(...)与overflow:hidden;一起使用*/
}
span.dspan{
    display: inline-block; 
    width:100px; /*这个宽度可以根据自己需要，大小自己决定*/
    word-break:keep-all;/* 不换行 */  
    white-space:nowrap;/* 不换行 */  
    overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */  
    text-overflow:ellipsis;
}
</style>
</head>
<body>
	<!-- 顶栏 start -->
	<s:include value="/include/header.jsp" />
	<!-- 顶栏 end -->
	<div class="main-content clearfix">
		<input name="yemianname" value="04202" type="hidden" />
		<!-- 主菜单 start -->
		<s:include value="/include/nav.jsp" />
		<!-- 主菜单 end -->
		<!-- 主容器 start -->
		<div class="container">
			<h3 class="current-title">康复计划</h3>
			<!-- 搜索容器 start -->
			<td colspan="8" class="title-td">查询条件</td>
			<div class="search-content">
				<form
					action="<%=basePath%>healthPhysiotherapyAction!getRecoveryPlan.action"
					method="post">
					<label>条件选择：</label> <select name="mySelect" id="mySelect">
						<s:if test="plan.planName!=''">
							<option value="计划名称" selected="selected">计划名称</option>
							<option value="制定人">制定人</option>
						</s:if>
						<s:elseif test="plan.TStaff.name!=''">
							<option value="计划名称">计划名称</option>
							<option value="制定人" selected="selected">制定人</option>
						</s:elseif>
						<s:else>
							<option value="计划名称" selected="selected">计划名称</option>
							<option value="制定人">制定人</option>
						</s:else>
					</select> <input   id="scheme" type="text" class="w150" name="plan.planName"
						value="${plan.planName }"  maxlength="15"> <input   id="people" type="text"
						class="w150 " name="plan.TStaff.name" value="${plan.TStaff.name }">
					<label>状态</label> <select name="plan.status" id="">
						<s:if test="plan.status==0">
							<option value="0" selected="selected">未开始</option>
							<option value="1">正在执行</option>
							<option value="2">已完成</option>
						</s:if>
						<s:elseif test="plan.status==1">
							<option value="0">未开始</option>
							<option value="1" selected="selected">正在执行</option>
							<option value="2">已完成</option>
						</s:elseif>
						<s:elseif test="plan.status==2">
							<option value="0">未开始</option>
							<option value="1">正在执行</option>
							<option value="2" selected="selected">已完成</option>
						</s:elseif>
						<s:else>
							<option value="0">未开始</option>
							<option value="1">正在执行</option>
							<option value="2">已完成</option>
						</s:else>

					</select> <input type="submit" class="btn btn-xianshi" value="查询"> <a
						href="<%=basePath%>healthPhysiotherapyAction!jumpAddPlan.action"
						class="btn btn-xinzeng">添加</a>

				</form>
			</div>
			<!-- 搜索容器 start -->
			<form action="<%=basePath%>healthPhysiotherapyAction!function.action"
				method="post">
				<!-- 表格容器 start -->
				<div>
					<td colspan="8" class="title-td">查询结果</td>
					<div class="table-content">
						<table class="table table-bordered" id="jqprint">
							<thead>
								<tr>
									<th>康复计划名称</th>
									<th>姓名</th>
									<th>开始日期</th>
									<th>结束日期</th>
									<th>制定人</th>
									<th>状态</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<s:iterator value="planList" var="list">
								<input type="hidden" name="ids"
									value="${list.recoveryPlanId }" />
									<tr>
										<td><span class="dspan"><c:out value="${list.planName }"></c:out></span></td>
										<td><c:out value="${list.one }"></c:out></td>
										<td>
											<fmt:formatDate value="${list.beginTime }"
												pattern="yyyy-MM-dd" />
										</td>
										<td><fmt:formatDate value="${list.overTime }"
												pattern="yyyy-MM-dd" /></td>
												
										<td><c:out value="${list.TStaff.name }"></c:out></td>
												
										<s:if test="#list.status==0">
											<td>未开始</td>
										</s:if>
										<s:if test="#list.status==1">
											<td>正在执行</td>
										</s:if>
										<s:if test="#list.status==2">
											<td>已完成</td>
										</s:if>
										<td><a
											href="healthPhysiotherapyAction!getPlanById.action?id=${list.recoveryPlanId}"
											class=" btn-xianshi">详情</a> <a
											onclick="return confirm('是否删除？');"
											href="<%=basePath %>healthPhysiotherapyAction!deletePlanById.action?id=${list.recoveryPlanId }"
											class=" btn-shanchu">删除</a> <s:if test="#list.status==2">
											<a class="btn-xiugai" href="javascript:cq(${list.recoveryPlanId });">重启计划</a>
											</s:if> <s:if test="#list.status==0">
												<a onclick="return confirm('是否开始计划？');"
													class="btn-xiugai" href="<%=basePath %>healthPhysiotherapyAction!changePlanStatus.action?id=${list.recoveryPlanId}">开始计划</a>
											</s:if> <s:if test="#list.status==1">
												<a onclick="return confirm('是否停止计划？');"
												 class="btn-xiugai"	href="<%=basePath %>healthPhysiotherapyAction!changePlanStatus.action?id=${list.recoveryPlanId}">停止计划</a>
											</s:if></td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
						<input type="hidden" name="flag" id="act" value=""></input>
						<!-- 分页 Start -->
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
				</div>
				</form>
				<!-- 表格容器 end -->
		</div>
		<!-- 主容器 end -->
		<!-- 底栏 Start-->
		<s:include value="/include/footer.jsp" />
		<!-- 底栏 Start-->
	</div>
	<div id="tan-one" style="display:none" class="tan-box">
		<form id="restart" action="healthPhysiotherapyAction!changePlanStatus.action"
			enctype="multipart/form-data" method="post">
			<input id="cq" type="hidden" name="plan.recoveryPlanId"
				value="${list.recoveryPlanId }">
			<table class="table table-bordered">
				<tbody>
					<tr>
						<td><label>开始日期：</label></td>
						<td><input type="text" id="start"
							onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"
							name="plan.beginTime" onfocus="this.blur()" value="${currentTime }"></td>
					</tr>
				</tbody>
				<tr>
					<td><label>结束日期：</label></td>
					<td><input type="text" id="end"
						onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"
						name="plan.overTime" onfocus="this.blur()" value=""></td>
				</tr>
			</table>
			<input id="current" type="hidden" value="${currentTime }">
			<input type="submit"id="submit" class="btn btn-xiugai" value="确定"> <a
				href="healthPhysiotherapyAction!getAllPlan.action" class="btn">取消</a>
		</form>
	</div>

	<script src="/jmjkms/js/jquery-1.4.4.min.js"></script>
	<script src="/jmjkms/js/laydate/laydate.js"></script>
	<script src="/jmjkms/js/base.js"></script>
	<script src="/jmjkms/js/jquery.jqprint-0.3.js"></script>
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
	
	<script>
		 $("#restart").submit(function(){
    	var start=$("#start").val();
    	var end=$("#end").val();
    	var currentTime=$("#current").val();
    	if(start != ""&&end != ""){
    	if(start<currentTime){
    		alert("开始日期小于当前日期")
    		return false;
    	}
    	if(start>end){
       		$("#end").val("");
       		alert("时间顺序输入错误");
       		return false;
       	}
       	}
       	if(start==""){
       		alert("起始日期不能为空")
       		return false;
       	}
       	if(end==""){
       		alert("结束日期不能为空")
       		return false;
       	}
    })
	</script>
	
	
	<script type="text/javascript">
		$(function() {
			if ($("select[name=mySelect]").val() == "计划名称") {
				$("#scheme").show();
				$("#people").hide();
				$("#people").val("");
				var input = $("#scheme").val();//获得input输入框的值，如果你要联动效果就要获取省份的ID进行判断
				console.log(input);

			} else {
				$("#scheme").hide();
				$("#people").show();
				$("#scheme").val("");
			}
			$("select[name=mySelect]").bind("change", function changeInput() {
				if ($(this).val() == "计划名称") {
					$("#scheme").show();
					$("#people").hide();
					$("#people").val("");
				} else {
					$("#scheme").hide();
					$("#people").show();
					$("#scheme").val("");
				}
			});
			if ('${jsonString}' != "") {
				alert('该康复计划正在执行');
			}

		});
	</script>
	<script type="text/javascript">
		function cq(id) {
			$("#cq").val(id);
			$("#tan-one").show();

		}
	</script>
</body>
</html>
