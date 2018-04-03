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
  <link rel="stylesheet" type="text/css" href="css/sweetalert.css"> 
  <script src="js/sweetalert.min.js"></script> 
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
      <h3 class="current-title">健康档案-健康数据录入-血压档案-康复计划</h3>
      <input name="yemianname" value="02201" type="hidden"/>
      <div class="search-content">
          <div class="btn-content">
           <a href="HealthManagerAction!getBloodPressFromCloud.action?bloodForward=0&healthFileId=${healthFileId }" class="btn btn-default">数据分析</a>
            <a href="HealthManagerAction!getBloodPressFromCloud.action?bloodForward=1&healthFileId=${healthFileId }" class="btn btn-default">趋势分析</a>
            <a href="HealthManagerAction!getBloodPressFromCloud.action?bloodForward=2&healthFileId=${healthFileId }" class="btn btn-default">详细数据</a>
            <%-- <a href="HealthManagerAction!getBloodPressFromCloud.action?bloodForward=3&healthFileId=${healthFileId }" class="btn ">康复计划</a> --%>
          </div>
      </div>
      <!-- 搜索容器 start -->
 <div class="search-content">
   <form action="HealthManagerAction!searchBloodPressRecoverPlan.action" method="post" >
     <div class="search-item">
       <input type="hidden" name="healthFileId" value="${healthFileId }" />
       <input type="hidden" name="diseaseName" value="高血压">
     <label>起始时间：</label>
            <input  name="startTime" onfocus="this.blur()" id="startTime" type="text" class="w150" value="<fmt:formatDate value="${startTime }" pattern="yyyy-MM-dd hh:mm:ss"/>" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" >
            至
            <input  name="endTime" onfocus="this.blur()" id="endTime" type="text" class="w150" value="<fmt:formatDate value="${endTime }" pattern="yyyy-MM-dd hh:mm:ss"/>" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
          </div>
     <div class="search-item">
       <label>计划名称：</label>
       <input type="text"   maxlength='20' class="w150" name="planName" value="${planName }">
     </div>
     <div class="search-item">
       <label>计划状态：</label>
       <select name="planState"  id="">
        <option value="-1">请选择 </option>
        <option value="0" <c:if test="${planState==0 }">selected</c:if>>未开始</option>
        <option value="1" <c:if test="${planState==1 }">selected</c:if>>正在执行</option>
        <option value="2" <c:if test="${planState==2 }">selected</c:if>>已完成</option>
       </select>
     </div>
     <div class="btn-content">
       <input type="submit" value="查询" class="btn">
       		<a id="tianjia" class="btn btn-xinzeng" href="HealthManagerAction!toAddBPRecoverPlan.action?healthFileId=${healthFileId }">添加计划</a>
     </div>
   </form>
 </div>
 <!-- 搜索容器 end -->
<!-- 表单表格 start -->
   <h3 class="current-title">康复计划</h3>
   <div class="table-content">
       <table class="table table-bordered">
         <tbody>
           <tr>
             <td>姓名</td>
             <td>康复计划名称</td>
             <td>起始时间</td>
             <td>终止时间</td>
             <td>制定日期</td>
             <td>状态</td>
             <td>制定人</td>
             <td>操作</td>
           </tr>
           <s:iterator value="recoveryOldList" var="rol">
           <tr>
             <td><c:out value="${rol.THealthFile.name}"></c:out></td>
             <td><c:out value="${rol.TRecoveryPlan.planName }"></c:out></td>
             <td><fmt:formatDate value="${rol.TRecoveryPlan.beginTime }" pattern="yyyy-MM-dd"/></td>
			 <td><fmt:formatDate value="${rol.TRecoveryPlan.overTime }" pattern="yyyy-MM-dd"/></td>            
             <td><fmt:formatDate value="${rol.TRecoveryPlan.constituteTime }" pattern="yyyy-MM-dd"/></td>
             <c:if test="${rol.TRecoveryPlan.status ==0 }"><td>未开始</td></c:if>
             <c:if test="${rol.TRecoveryPlan.status ==1 }"><td>正在执行</td></c:if>
             <c:if test="${rol.TRecoveryPlan.status ==2 }"><td>已完成</td></c:if>
             <td>${rol.TRecoveryPlan.TStaff.name}</td>
            <td>
             <c:if test="${rol.TRecoveryPlan.status ==2 }">
             <a class="btn-xiugai" href="javascript:cq(${rol.TRecoveryPlan.recoveryPlanId });">重启计划</a>
			</c:if> 
			<c:if test="${rol.TRecoveryPlan.status ==0 }">
			<a class="btn-xiugai" onclick="return confirm('是否开始计划？');"
			href="<%=basePath %>HealthManagerAction!changePlanStatus.action?diseaseName=${rol.TRecoveryPlan.TRecoveryScheme.disease }&recoveryPlanId=${rol.TRecoveryPlan.recoveryPlanId}&healthFileId=${rol.THealthFile.healthFileId}">开始计划</a>
			</c:if> 
			<c:if test="${rol.TRecoveryPlan.status ==1 }">
			<a class="btn-xiugai" onclick="return confirm('是否停止计划？');"href="<%=basePath %>HealthManagerAction!changePlanStatus.action?diseaseName=${rol.TRecoveryPlan.TRecoveryScheme.disease }&recoveryPlanId=${rol.TRecoveryPlan.recoveryPlanId}&healthFileId=${rol.THealthFile.healthFileId}">停止计划</a>
			</c:if>
			 <a class="btn-xianshi" href="HealthManagerAction!jumpInfoRecoveryPlan.action?healthFileId=${healthFileId }&recoveryPlanId=${rol.TRecoveryPlan.recoveryPlanId }&diseaseName=${rol.TRecoveryPlan.TRecoveryScheme.disease }">详情</a>
             <a class="btn-shanchu" href="HealthManagerAction!deletePlanById.action?healthFileId=${healthFileId }&recoveryPlanId=${rol.TRecoveryPlan.recoveryPlanId }" onclick="return confirm('确认删除')">删除</a>
			</td>
        </tr>
         </s:iterator>
         </tbody>
       </table>
       <div class="page">
				${pageHtml}
	   </div>
        <div class="btn-content">
             <a href="HealthManagerAction!getHealthFileList.action" class="btn btn-xianshi">返回</a>
        </div>
   
   </div>
   <div id="tan-one" style="display:none" class="tan-box">
		<form id="restart" action="<%=basePath%>HealthManagerAction!changePlanStatus.action?healthFileId=${healthFileId }" method="post">
		<input type="hidden" name="diseaseName" value="${rol.TRecoveryPlan.TRecoveryScheme.disease }" />
		<%-- <input type="hidden" name="healthFileId" value="${healthFileId }" /> --%>
			<input id="cq" type="hidden" name="recoveryPlan.recoveryPlanId"
				value="${rol.TRecoveryPlan.recoveryPlanId }">
			<table class="table table-bordered">
				<tbody>
					<tr>
						<td><label>开始日期：</label></td>
						<td><input type="text" id="start"
							onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"
							name="recoveryPlan.beginTime" onfocus="this.blur()" value=""></td>
					</tr>
				</tbody>
				<tr>
					<td><label>结束日期：</label></td>
					<td><input type="text" id="end"
						onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"
						name="recoveryPlan.overTime" onfocus="this.blur()" value=""></td>
				</tr>
			</table>
			<input type="submit" class="btn btn-xianshi" value="确定"> 
			<button class="btn" id="back" type="button" >返回</button>
		</form>
	</div>
   <!-- 表单表格 start -->
    </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>

<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<script type="text/javascript">
	var person=${person};
	if(person<0){
		$("#tianjia").remove();
	}
function showDetail(content){
	 swal({  
                title: "计划详细内容",  
                text: content,  
                showCancelButton: false,  
                showConfirmButton:true,  
                confirmButtonColor: "#fc7c00",
                animation: "slide-from-top",  
                })
}
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
    	if(start != ""||end != ""){
    	if(start>end){
      	 	$("#start").val("");
       		$("#end").val("");
       		alert("时间顺序输入错误");
       		return false;
       	}
       	else{
       		alert("请输入时间");
       		return false;
       	}
       	}
       	else{
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
