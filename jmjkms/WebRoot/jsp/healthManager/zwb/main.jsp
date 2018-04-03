<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="css/cssreset.css">
<link rel="stylesheet" href="css/main.css">
  <link type="text/css" href="/jmjkms/css/confirm.css">
   <link rel="stylesheet" href="/jmjkms/select2/css/select2.css">
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
      <h3 class="current-title">中医治未病</h3>
 <!-- 搜索容器 start -->
			 <div class="search-content">
			  <input name="yemianname" value="02207" type="hidden"/>
			    <form action="xkHealthMachineAction!getListByCX.action" method="post">
			     <div class="search-item">
			       <input id="cp" type="hidden" name="cp" value="${cp}"> 
			      </div>
			      
			     <div class="search-item">
			       <label>检测日期：</label>
			       <input class="startTime" onfocus="this.blur()" name="startTime" type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"  value="<fmt:formatDate value="${startTime}"  pattern="yyyy-MM-dd"/>">
			       至
			       <input  class="endTime" onfocus="this.blur()" name="endTime" type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"  value="<fmt:formatDate value="${endTime}"  pattern="yyyy-MM-dd"/>">
			       <label>老人姓名：</label>
			       <input type="text" name="personName" value="${PersonName}">
			       <label>身份证号：</label>
			       <input type="text" name="IDNumber" value="${IDNumber}">
			       <label>检测项目：</label>
			       <input type="text" name="JCXM" value="${JCXM}">
			     </div>
			  	
			     <div class="btn-content">
			       <input type="submit" value="查询" id="" name="" class="btn">
			       <a id="news" href="javascript:;" class="btn">重置</a>
			  
			     </div>
			 	</form>
			 </div>
			 <!-- 搜索容器 end -->
    <!-- 表格容器 start -->
   <div class="table-content">
   
   <table class="table table-bordered">
     <thead>
       <tr>
         <th>老人姓名</th>
         <th>性别</th>
         <th>年龄</th>
         <th>身份证号</th>
         <th>地址</th>
         <th>电话</th>
         <th>检测时间</th>
         <th>检测项目</th>
         <th>检测详情</th>
       </tr>
     </thead>
     <tbody>
     <s:iterator value="theItems" var="xk">
       <tr>
         <td>${xk.personName}</td>
         <td>${xk.sex}</td>
         <td>${xk.age}</td>
         <td>${xk.IDNumber}</td>
         <td>${xk.address}</td>
         <td>${xk.telephone}</td>
         <td>${xk.examTime}</td>
         <td>${xk.JCXM}</td>
          <td>
           <a class="btn-xianshi" href="xkHealthMachineAction!showDetail.action?id=${xk.id}">查看详情</a>
          </td>
          
       </tr>
       </s:iterator>
     </tbody>
   </table>
   <!-- 分页 Start -->
   <div class="sum-btn">
				<div class="page">
					${pageHtml}
				</div>
	</div>
	<!-- 分页 end -->
 </div>
 <!-- 表格容器 end -->      
</div>
<!-- 主容器 end -->
<!-- 底栏 Start-->
<s:include value="/include/footer.jsp" />
<!-- 底栏 Start-->
</div>
<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/threecity/jq.js"></script>
<script src="/jmjkms/js/threecity/jquery.cityselect.js"></script>
<script src="/jmjkms/js/threecity/location.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<script src="/jmjkms/select2/js/select2.full.js"></script>
<script type="text/javascript" src="/jmjkms/js/confirm/Validform_v5.3.2_min.js"></script>
<script type="text/javascript">

<script type="text/javascript">
 $("form").submit(function(){
    	var startTime0=$(".startTime").eq(0).val();
    	var startTime1=$(".startTime").eq(1).val();
    	var endTime0=$(".endTime").eq(0).val();
    	var endTime1=$(".endTime").eq(1).val();
    	if(startTime0 != ""&&endTime0 != ""){
    	if(startTime0>endTime0){
      	 	$(".startTime").eq(0).val("");
       		$(".endTime").eq(0).val("");
       		alert("查询时间输入错误");
       		return false;
       	}
       	}
       	if(startTime1 != ""&&endTime1 != ""){
    	if(startTime1>endTime1){
      	 	$(".startTime").eq(1).val("");
       		$(".endTime").eq(1).val("");
       		alert("查询时间输入错误");
       		return false;
       	}
       	}
    });
</script>
</body>
</html>