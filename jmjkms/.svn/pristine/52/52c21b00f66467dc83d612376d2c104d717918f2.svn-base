<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">
<div class="header clearfix">
    <div class="logo">
      <img src="/jmjkms/images/logo.png" alt="">
      <c:choose>
			<c:when test="${session.comHospital.isHead==0}">
	         中电科社区健康管理平台
	        </c:when>
			<c:when test="${session.communityHospitalGroup!=null}">
	        社区健康管理系统
	        </c:when>
	        <c:otherwise>社区健康服务站</c:otherwise>
      </c:choose>
    </div>
    <div class="user-info" id="userInfo">
      <img src="/jmjkms/images/user.png" alt="" class="clearfix">
      <i class="fa fa-sort-desc fa-2x"></i>
    </div>
    <div class="hideCon" id="hideCon">
      <div class="detail" >
      	<c:if test="${session.tstaff!=null}">
      	<p>${session.tstaff.name}</p>
      	</c:if>
      	<c:if test="${session.comHospital!=null}">
      	<p>${session.comHospital.name}</p>
      	</c:if>
      	<c:if test="${session.communityHospitalGroup!=null}">
        <p>${session.communityHospitalGroup.groupHostName}</p>
        </c:if>
        
      	<c:if test="${session.tstaff!=null}">
        <p id="p2">${session.tstaff.TRole.roleName}</p>
        </c:if>
        <c:choose>
        <c:when test="${session.communityHospitalGroup!=null}"><p>社区集团管理员</p></c:when>
        <c:when test="${session.comHospital!=null&&session.comHospital.isHead==0}"><p>系统管理员</p></c:when>
        <c:when test="${session.comHospital!=null&&session.comHospital.isHead==1}"><p>社区医院管理员</p></c:when>
        </c:choose>
        
        <!-- comHosName在action中存入了 -->
        <c:if test="${session.tstaff!=null}">
        <p id="p1">${session.comHosName}</p>
        </c:if>
        <c:if test="${session.comHospital!=null}">
        <p id="p1">${session.comHospital.communityHospital}</p>
        </c:if>
       <c:if test="${session.communityHospitalGroup!=null}">
        <p id="p1">${session.communityHospitalGroup.groupName}</p>
        </c:if> 
      </div>
      <ul>
      
      <!-- 退出 -->
      <c:if test="${session.tstaff!=null}">
      <li class="set quit"><a href="<%=basePath %>LoginoutAction!logout.action"><i class="fa fa-circle-o-notch"></i>&nbsp;&nbsp;退出</a></li>
      </c:if>
      <c:if test="${session.comHospital!=null}"> 
	      <c:if test="${session.comHospital.isHead==0}"><!--0为系统管理员 -->
	       <li class="set quit"><a href="<%=basePath %>LoginoutAction!adminLogout.action"><i class="fa fa-circle-o-notch"></i>&nbsp;&nbsp;退出</a></li>
	      </c:if>
	      <c:if test="${session.comHospital.isHead==1}"><!--1为社区负责人 -->
           <li class="set quit"><a href="<%=basePath %>LoginoutAction!logout.action"><i class="fa fa-circle-o-notch"></i>&nbsp;&nbsp;退出</a></li>
          </c:if>
      </c:if> 
      <c:if test="${session.communityHospitalGroup!=null}">  
      <li class="set quit"><a href="<%=basePath %>LoginoutAction!adminLogout.action"><i class="fa fa-circle-o-notch"></i>&nbsp;&nbsp;退出</a></li>
      </c:if> 
      
      
      <!-- 修改密码 -->
      <c:if test="${session.tstaff!=null}">  
      <li class="set alter"><a href="LoginoutAction!jumpToChangePassword.action"><i class="fa fa-wrench"></i>&nbsp;&nbsp;修改密码</a></li>
      </c:if>  
      <c:if test="${session.comHospital!=null}">  
        <c:if test="${session.comHospital.isHead==0}"><!--0为系统管理员 -->
           <li class="set alter"><a href="LoginoutAction!jumpToadminChangePassword.action"><i class="fa fa-wrench"></i>&nbsp;&nbsp;修改密码</a></li>
          </c:if>
          <c:if test="${session.comHospital.isHead==1}"><!--1为社区负责人 -->
           <li class="set alter"><a href="LoginoutAction!jumpToChangePassword.action"><i class="fa fa-wrench"></i>&nbsp;&nbsp;修改密码</a></li>
          </c:if>
      </c:if>  
      <c:if test="${session.communityHospitalGroup!=null}">  
      <li class="set alter"><a href="LoginoutAction!jumpToadminChangePassword.action"><i class="fa fa-wrench"></i>&nbsp;&nbsp;修改密码</a></li>
      </c:if>         
      </ul>
    </div>
  </div>
  <script type="text/javascript">
    var oHidCon=document.getElementById('hideCon');
    var ouserInfo=document.getElementById('userInfo');
    ouserInfo.onmouseover=hov;
    oHidCon.onmouseover=hov;
    oHidCon.onmouseout=hid;
	ouserInfo.onmouseout=hid;
    function hov(){
    oHidCon.style.display="block";
    }
    function hid(){
    oHidCon.style.display="none";
    }
  </script>