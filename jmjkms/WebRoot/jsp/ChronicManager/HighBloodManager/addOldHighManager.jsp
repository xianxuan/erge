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
      <h3 class="current-title">高血压管理</h3>
      <input name="yemianname" value="02204" type="hidden"/>
       <div class="table-content">
        <form action="chronicManagerAction!addHighConfirm.action" method="post">
        <table class="table table-bordered">
          <thead>
            <tr>
           	   <th><input id="laoren" type="checkbox" onclick="return checkAll(this)" ><label for="laoren">全选</label></th>
               <th>居民健康档案编号</th>
               <th>姓名</th>
               <th>性别</th>
               <th>慢病名称</th>
               <th>联系方式</th>
               <th>现住址</th>
               <th>录入员</th>
               <th>责任医生</th>
            </tr>
          </thead>
          <tbody>
          <s:iterator value="vcnoHighList">
            <tr>
              <td><input type="checkbox" name="oldids" value="${chronicDiseaseId}"></td>
              <td>${fileNum }</td>
              <td>${fileName }</td>
              <td>
                 <c:if test="${!sex }">男</c:if>
                 <c:if test="${sex}">女</c:if>
              </td>
              <td>${diseaseName }</td>
              <td>${IPhone }</td>
              <td>${currentCommunity }</td>
              <td>${filePerson }</td>
              <td>${name }</td>
            </tr>  
            </s:iterator>       
          </tbody>
         </table>
          <div class="page">
				${pageHtml}
	    	</div>
            <div class="btn-content">
          		<input type="submit" value="确认" class="btn">
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

<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
 <script type="text/javascript">
    	function checkAll(all){
    		var allcli=document.getElementsByName("oldids");
    		for(var i=0;i<allcli.length;i++){
    			allcli[i].checked=all.checked;
    		}
    	}
    </script>
</body>
</html>
