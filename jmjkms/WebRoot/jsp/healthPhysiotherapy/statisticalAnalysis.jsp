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
	<input name="yemianname" value="04203" type="hidden"/>
		<!-- 主菜单 start -->
		<s:include value="/include/nav.jsp" />
		<!-- 主菜单 end -->
		<!-- 主容器 start -->
		 <div class="container">
      <h3 class="current-title">统计分析</h3>
            <!-- 搜索容器 start -->
            <td colspan="8" class="title-td">查询条件</td>
            <div class="search-content">
				 <form id="registerform" action="<%=basePath%>healthPhysiotherapyAction!getSearchRecovery.action">
             		<select name="mySelect" id="mySelect">
					<s:if test="mySelect=='开始日期'">
						<option value="开始日期"selected="selected">开始日期</option>
						<option value="结束日期">结束日期</option>
						</s:if>
					<s:elseif test="mySelect=='结束日期'">
					<option value="开始日期">开始日期</option>
						<option value="结束日期"selected="selected">结束日期</option>
					</s:elseif>
					<s:else>
					<option value="开始日期"selected="selected">开始日期</option>
						<option value="结束日期">结束日期</option>
					</s:else>
					</select> 
                    <input  type="text" class="startTime"  onfocus="this.blur()"id="startTime" name ="startTime" value="${st}" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
                    <lable>至</lable>
                    <input type="text" class="endTime" onfocus="this.blur()" id="endTime" name="endTime" value="${et}" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">  
             <input type="submit" class="btn btn-xianshi" value="查询" id="chaxun">
          
              </form>
            </div>
   <!-- 搜索容器 start -->
   <form action="<%=basePath %>healthPhysiotherapyAction!exportAnalysis.action" method="post">
			<!-- 表格容器 start -->
			<td colspan="8" class="title-td">查询结果</td>
			<div class="table-content">
				<table class="table table-bordered" id="jqprint">
     <thead>
       <tr>
         <th>康复计划名称</th>
         <th>康复方案名称</th>
         <th>老人</th>
         <th>开始日期</th>
         <th>结束日期</th>
         <th>状态</th>
         <th>操作</th>
        
       </tr>
     </thead>
     <tbody>
     <s:iterator value="planList" var="list">
    <input type="hidden" name="ids"
									value="${list.recoveryPlanId }" />
       <tr>
         <td>${list.planName }</td>
        <td>${list.TRecoveryScheme.schemeName }</td>
         <td>${list.one }</td>
         <td><fmt:formatDate value="${list.beginTime }"
												pattern="yyyy-MM-dd" /></td>
										<td><fmt:formatDate value="${list.overTime }"
												pattern="yyyy-MM-dd" /></td>
         <s:if test="#list.status==0">
					<td>未开始</td>
				</s:if>
				<s:if test="#list.status==1">
					<td>正在执行</td>
				</s:if>
				<s:if test="#list.status==2">
					<td>已完成</td>
				</s:if>
		<td>		
        <a onclick="return confirm('是否删除？');"
        href="<%=basePath %>healthPhysiotherapyAction!deletestStisticalById.action?id=${list.recoveryPlanId} " class="btn-shanchu">删除</a>
		
		<a href="<%=basePath %>healthPhysiotherapyAction!getRocoveryById.action?id=${list.recoveryPlanId}"class="btn-xianshi">详情</a>
		</td>							
       </tr>
      </s:iterator>
     </tbody>
   </table> <input type="hidden" name="flag"  id="act" value=""></input>
				<!-- 分页 Start -->
				<div class="sum-btn">
					<div class="page">${pageHtml}</div>
					<!-- 分页 end -->
					<div class="btn-content2">
				
						<input type="submit" class="btn btn-daochu"  value="导出全部"  onclick="run01()"></input>
	                    <input type="submit" class="btn btn-daochu"  value="导出本页"  onclick="run02()"></input>
						 
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

	<script src="/jmjkms/js/jquery-1.4.4.min.js"></script>
	<script src="/jmjkms/js/laydate/laydate.js"></script>
	<script src="/jmjkms/js/base.js"></script>
	<script src="/jmjkms/js/jquery.jqprint-0.3.js"></script>
	 <script>
    var Obtn01=document.getElementById("btn01");
    var Obtn02=document.getElementById("btn02");
    var Obtn03=document.getElementById("btn03");
    var Oact  =document.getElementById("act");
    function run01(){
        Oact.value=1;
    }
    function run02(){
        Oact.value=2;
    }
    function run03(){
        Oact.value=3;
    }
</script>
	<script type="text/javascript">
	$(function() {
			$("select[name=mySelect]").bind("change", function changeInput() {
				$("#startTime").val("");
				$("#endTime").val("");
				
			});
			  if('${json}'!="")
	     {
	      alert('该康复计划正在执行');
	     }
			 
			
		});
		</script>
	<script type="text/javascript">
 $("form").submit(function(){
    	var startTime0=$(".startTime").eq(0).val();
    	    	var endTime0=$(".endTime").eq(0).val();
    	    	if(startTime0 != ""||endTime0 != ""){
    	if(startTime0>endTime0){
      	 	$(".startTime").eq(0).val("");
       		$(".endTime").eq(0).val("");
       		alert("查询时间输入错误");
       		return false;
       	}
       	}
           })
</script>
	
</body>
</html>
