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
  <c:choose>
            <c:when test="${session.comHospital.isHead==0}">
             <title>中电科社区健康管理平台</title>
            </c:when>
            <c:when test="${session.communityHospitalGroup!=null}">
            <title>社区健康管理系统</title>
            </c:when>
            <c:otherwise><title>社区健康服务站</title></c:otherwise>
   </c:choose>
  
  <link rel="stylesheet" href="/jmjkms/css/cssreset.css">
  <link rel="stylesheet" href="/jmjkms/css/main.css">
  <style type="text/css">
	.clear {
    height: 50px;
    width: 100%;
    margin: 0;
    auto: 0;
    margin: 0 auto;
    font-size: 20px;
    font-family: "楷体";
    margin-left: 37.5%;
    margin-top: 20px;
    font-weight: bold;
    color: #8d3e1a;
    }
.box_center {
    margin: 0 auto;
    width: 300px;
    padding: 18px 20px;
    width: 200px;
    background: #e8edf6;
    background-clip: padding-box;
    border: 1px solid #dde1e9;
    border-bottom-color: #C6CCD5;
    border-radius: 5px;
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
      
      
      <!-- 删除此行注释，在此添加对应的div -->
      <div class="content-box">
            <div class="content-box-header">
                <div class="clear">
                    <c:choose>
            <c:when test="${session.comHospital.isHead==0}">
             <h3>欢迎登录社区健康管理平台！</h3>
            </c:when>
            <c:when test="${session.communityHospitalGroup!=null}">
            <h3>欢迎登录社区健康管理系统！</h3>
            </c:when>
            <c:otherwise><h3>欢迎登录社区健康服务站！</h3></c:otherwise>
      </c:choose>
                	 
                </div>
            </div>
            <div class="content-box-content">
                <img src="images/welcome.png"  style="display:block;margin:0px auto;"/>
                <p style="line-height: 50px;font-size: 16px;text-align:center">
                   &nbsp;1.请您按照实际情况如实填写信息!<br/>
                   2.祝您身体健康，工作愉快! &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                </p>
            </div>
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
</body>
</html>
