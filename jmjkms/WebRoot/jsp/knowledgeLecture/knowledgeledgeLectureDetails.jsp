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
      <h3 class="current-title">知识讲座 <br></h3>
        <div class="table-content"> 
        <input name="yemianname"  value="05203" type="hidden"/>
		  <table class="table table-bordered" id="jqprint" style="word-break:break-all">
		     <tbody>
		   <c:if test="${session.comHospital.isHead==0 }">          <!--  系统 -->
		   <tr>
		   <td>社区集团</td>
		   <td><c:out value="${knowlectal.communitygroup}"></c:out></td>
		   <td>社区医院</td>
		   <td><c:out value="${knowlectal.communityHospital}"></c:out></td>
		   </tr>
		   </c:if>
		   <c:if test="${session.communityHospitalGroup !=null}">      <!-- 集团 -->
		   <tr>
		   <td>社区医院</td>
		   <td><c:out value="${knowlectal.communityHospital}"></c:out></td>
		   </tr>
		   </c:if>
           <tr>
           <td>讲座名称</td>
           <td><c:out value="${knowlectal.knowledge.lectureName}"></c:out></td>
           <td>对象</td>
           <td><c:out value="${knowlectal.knowledge.forPerson}"></c:out></td>
           </tr>
           <tr>
             <td>计划时间</td>
             <td><fmt:formatDate value='${knowlectal.knowledge.planTime}' pattern='yyyy-MM-dd'/></td>
             <td>制定时间</td>
             <td><fmt:formatDate value='${knowlectal.knowledge.formulateTime}' pattern='yyyy-MM-dd'/></td>
           </tr>
           <tr>
             <td>制定人</td>
          <td><c:out value="${knowlectal.knowledge.TStaff.name}"></c:out></td>
             <td>状态</td>
             <s:if test="knowlectal.knowledge.status==0">
             <td><c:out value="暂缓处理"></c:out></td>
             </s:if>
             <s:if test="knowlectal.knowledge.status==1">
             <td><c:out value="待处理"></c:out></td>
             </s:if>
             <s:if test="knowlectal.knowledge.status==2">
             <td><c:out value="不处理"></c:out></td>
             </s:if>
             <s:if test="knowlectal.knowledge.status==3">
             <td><c:out value="已处理"></c:out></td>
             </s:if>
           </tr>
           <tr>
             <td>参与者</td>
             <td><c:out value="${knowlectal.knowledge.participatePeople}"></c:out></td> 
           </tr>
           <tr>
             <td>记录讲座内容</td>
              <td colspan="3"><c:out value="${knowlectal.knowledge.content}"></c:out></td> 
           </tr>
           <tr>
             <td>备注</td>
             <td colspan="3"><c:out value="${knowlectal.knowledge.note}"></c:out></td> 
           </tr>
                 </tbody> 
            </table>
                 <div class="btn-content">
                    <a href="javascript:;" class="btn btn-print">打印</a>
                    <a href="javascript:;" class="btn btn-back">返回</a>
                 </div>
            </div> <!-- 表单表格 start -->
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
</body>
</html>
