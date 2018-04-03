<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head><meta name="viewport" content="width=device-width, initial-scale=1.0"><meta http-equiv="X-UA-Compatible" content="ie=edge">
  <meta charset="UTF-8">
  <c:choose><c:when test="${session.comHospital.isHead==0}"><title>中电科社区健康管理平台</title></c:when><c:when test="${session.communityHospitalGroup!=null}"><title>社区健康管理系统</title></c:when><c:otherwise><title>社区健康服务站</title></c:otherwise></c:choose>
  <link rel="stylesheet" href="/jmjkms/css/cssreset.css">
  <link rel="stylesheet" href="/jmjkms/css/main.css">
  <link rel="stylesheet" href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">
  <link type="text/css" href="jmjkms/css/confirm.css">
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
      <h3 class="current-title">高血压康复计划</h3>
      <div style="text-align: left;padding-bottom: 10px;">
        	档案编号：${vchronic.fileNum } &nbsp;&nbsp;姓名：${vchronic.fileName} 
      </div>

      
 <!-- 删除此行注释，在此添加对应的div -->
 <!-- 搜索容器 start -->
      <div class="search-content">
      <input name="yemianname" value="02204" type="hidden"/>
        <form id="registerform" action="chronicManagerAction!searchRecoveryPlan.action" method="post">
       	 <input type="hidden" name="chronicId" value="${chronicId}">
          <div class="search-item">
            <label>起始时间：</label>
            <input  name="startTime" onfocus="this.blur()"
             id="startTime" type="text" class="w150" value="<fmt:formatDate value="${startTime }" pattern="yyyy-MM-dd"/>" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" >
            至
            <input  name="endTime" onfocus="this.blur()"
             id="endTime" type="text" class="w150" value="<fmt:formatDate value="${endTime }" pattern="yyyy-MM-dd"/>" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
          </div>    
          <div class="search-item">
           <label>计划名称：</label>
            <input id="planName" type="text" name="planName"   maxlength='20'  errormsg="不能输入特殊字符！" class="w150" > 
          </div>
          <div class="search-item">
            <label>计划状态：</label>
            <select name="planState" id="planState">
              <option value="-1"  selected = "selected" >请选择</option>
       		 	<option value="0" <c:if test="${planState==0 }">selected</c:if>>未开始</option>
        		<option value="1" <c:if test="${planState==1 }">selected</c:if>>正在执行</option>
       			 <option value="2" <c:if test="${planState==2 }">selected</c:if>>已完成</option>
            </select>
          </div>

          <div class="btn-content">
            <input type="submit" value="查询" class="btn btn-xianshi">
            <a class="btn btn-xinzeng" id="tianjia"  href="chronicManagerAction!addRecoveryPlan.action?chronicId=${chronicId} ">添加计划</a>
          </div>
        </form>

      </div>
      <!-- 搜索容器 end -->

<!-- 表格容器 start -->
<h3 class="current-title">查询结果</h3>
 <div class="table-content">
   <table class="table table-bordered">
     <thead>
       <tr>
         <th>康复计划名称</th>
         <th>康复方案</th>
         <th>起始时间</th>
         <th>终止时间</th>
         <th>制定日期</th>
         <th>制定人</th>
        <th>状态</th>   
        <th>操作</th>
       </tr>
     </thead>
     <tbody>
     <s:iterator value="recoveryOldList" var="rec">
       <tr>
         <td><c:out value="${rec.TRecoveryPlan.planName }"></c:out></td>
         <td><c:out value="${rec.TRecoveryPlan.TRecoveryScheme.schemeName }"></c:out></td>
         <td><fmt:formatDate value='${rec.TRecoveryPlan.beginTime }' pattern='yyyy-MM-dd'/></td>
         <td><fmt:formatDate value='${rec.TRecoveryPlan.overTime }' pattern='yyyy-MM-dd'/></td>
         <td><fmt:formatDate value='${rec.TRecoveryPlan.constituteTime }' pattern='yyyy-MM-dd'/></td>
         <td><c:out value="${rec.TRecoveryPlan.TStaff.name }"></c:out></td>
       
        <c:if test="${rec.TRecoveryPlan.status ==0 }"><td>未开始</td></c:if>
        <c:if test="${rec.TRecoveryPlan.status ==1 }"><td>正在执行</td></c:if>
        <c:if test="${rec.TRecoveryPlan.status ==2 }"><td>已完成</td></c:if>
         <td>
             <c:if test="${rec.TRecoveryPlan.status ==2 }">
             <a class="btn-xiugai" href="javascript:cq(${rec.TRecoveryPlan.recoveryPlanId });">重启计划</a>
			</c:if> 
			<c:if test="${rec.TRecoveryPlan.status ==0 }">
			<a class="btn-xiugai" onclick="return confirm('是否开始计划？');"
			href="<%=basePath %>chronicManagerAction!changePlanStatus.action?recoveryPlanId=${rec.TRecoveryPlan.recoveryPlanId}&chronicId=${chronicId}">开始计划</a>
			</c:if> 
			<c:if test="${rec.TRecoveryPlan.status ==1 }">
			<a class="btn-xiugai" onclick="return confirm('是否停止计划？');"
			href="<%=basePath %>chronicManagerAction!changePlanStatus.action?recoveryPlanId=${rec.TRecoveryPlan.recoveryPlanId}&chronicId=${chronicId}">停止计划</a>
			</c:if>
           <a class="btn-xianshi" href="chronicManagerAction!jumpInfoRecoveryPlan.action?planId=${rec.TRecoveryPlan.recoveryPlanId }&chronicId=${chronicId}">详情</a>
           <a class="btn-shanchu" href="chronicManagerAction!deletePlanById.action?planId=${rec.TRecoveryPlan.recoveryPlanId }&chronicId=${chronicId}" onclick="return confirm('确认删除')">删除</a>
         </td>
        </tr>
      </s:iterator>
     </tbody>
   </table>
   <div id="tan-one" style="display:none" class="tan-box">
		<form id="restart" action="<%=basePath%>chronicManagerAction!changePlanStatus.action?healthFileId=${healthFileId }" method="post">
		<input type="hidden" name="chronicId" value="${chronicId }" />
			<input id="cq" type="hidden" name="recoveryPlan.recoveryPlanId"
				value="${rec.TRecoveryPlan.recoveryPlanId }">
			<table class="table table-bordered">
				<tbody>
					<tr>
						<td><label>开始日期：</label></td>
						<td><input type="text" id="start" 
							onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"
							name="recoveryPlan.beginTime" onfocus="this.blur()" value="${currentTime }"></td>
					</tr>
				</tbody>
				<tr>
					<td><label>结束日期：</label></td>
					<td><input type="text" id="end"
						onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"
						name="recoveryPlan.overTime" onfocus="this.blur()" value=""></td>
				</tr>
			</table>
			<input id="current" type="hidden" value="${currentTime }">
			<input type="submit" class="btn btn-xianshi" value="确定"> 
			<button class="btn" id="back" type="button" >返回</button>
		</form>
	</div>
    <div class="page">
				${pageHtml}
	</div>
   <div class="btn-content">
    <a class="btn btn-xianshi" href="chronicManagerAction!getAllHighBloodManager.action">返回</a>
   </div>
 </div>
 <!-- 表格容器 end -->
   
 
  

    </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
 
</div>
<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<script type="text/javascript" src="/jmjkms/js/confirm/Validform_v5.3.2_min.js"></script>
<script type="text/javascript">
$(function(){
      $("#registerform").Validform({
        showAllError:false,
        tiptype:function(msg){          
          alert(msg);
        }
      });
  });
</script>
<script type="text/javascript">
 $("form").submit(function(){
    	var startTime0=$("#startTime").val();
    	var endTime0=$("#endTime").val();
    	if(startTime0 != ""||endTime0 != ""){
    	if(startTime0>endTime0){
      	 	$("#startTime").val("");
       		$("#endTime").val("");
       		alert("查询时间输入错误");
       		return false;
       	}
       	}
    })
    
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
		function cq(id) {
			$("#cq").val(id);
			$("#tan-one").show();
			}
		$("#back").click(function(){
			$("#tan-one").hide();
			});
</script>

</body>
</html>
