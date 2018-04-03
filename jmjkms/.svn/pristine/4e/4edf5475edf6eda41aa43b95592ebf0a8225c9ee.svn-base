<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head><meta name="viewport" content="width=device-width, initial-scale=1.0"><meta http-equiv="X-UA-Compatible" content="ie=edge">
  <meta charset="UTF-8">
  <c:choose><c:when test="${session.comHospital.isHead==0}"><title>中电科社区健康管理平台</title></c:when><c:when test="${session.communityHospitalGroup!=null}"><title>社区健康管理系统</title></c:when><c:otherwise><title>社区健康服务站</title></c:otherwise></c:choose>
  <link rel="stylesheet" href="/jmjkms/css/cssreset.css">
  <link rel="stylesheet" href="/jmjkms/css/main.css">
  <style type="text/css">
  	.table_change tr td.bable_d{
  			width:100px;
  	}	
  	.table_change tr td.bable_c{
  			width:px;
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
      <h3 class="current-title">高血压医生诊断详情</h3>
 <!-- 表单表格 start -->
               
         <div class="table-content">
             <input name="yemianname" value="02204" type="hidden"/>
             <table class="table table-bordered table_change" id="jqprint">
                       <tbody>
                         <tr>
                         	<td class="bable_d">姓名</td>
                            <td class="bable_c" colspan="6"><c:out value="${doctorDiagnosis.THealthFile.name}"></c:out></td> 
                         </tr>
                         <tr>
                             <td>诊断医生</td>
                             <td colspan="6"><c:out value="${doctorDiagnosis.TStaff.name}"></c:out></td> 
                         </tr>
                         <tr>
                               <td>慢病名称</td>
                               <td colspan="6"><c:out value="${doctorDiagnosis.chronic}"></c:out></td>
                         </tr>
                         <tr>
                               <td>诊断意见</td>
                               <td colspan="6"><c:out value="${doctorDiagnosis.opinion}"></c:out></td>
                          </tr>
                          <tr>      
                           		<td>建议</td>
                                <td colspan="6"><c:out value="${doctorDiagnosis.advice}"></c:out></td>
                          </tr>
                          <tr>
                                <td>日期</td>
                                <td colspan="6">
                                      <fmt:formatDate value='${doctorDiagnosis.date}' pattern='yyyy-MM-dd'/>
                                </td>
                          </tr>
                       </tbody>
               </table>
             <div class="btn-content">
                   <a href="javascript:;" class="btn btn-print" class="btn btn-xianshi">打印</a>
                   <button class="btn" type="button" onclick="history.go(-1);">返回</button>
             </div>
         </div>
                 <!-- 表单表格 start -->
    <!-- 主容器 end -->
    </div>
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>

<script src="/jmjkms/js/jquery-1.4.4.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<script src="/jmjkms/js/jquery.jqprint-0.3.js"></script>
</body>
</html>
