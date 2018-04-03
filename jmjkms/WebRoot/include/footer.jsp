<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="footer" style="text-align:center;">
  <c:choose>
            <c:when test="${session.comHospital.isHead==0}">
             中电科社区健康管理平台
            </c:when>
            <c:when test="${session.communityHospitalGroup!=null}">
            社区健康管理系统
            </c:when>
            <c:otherwise>社区健康服务站</c:otherwise>
      </c:choose> @copyright 2016-2019
</div>