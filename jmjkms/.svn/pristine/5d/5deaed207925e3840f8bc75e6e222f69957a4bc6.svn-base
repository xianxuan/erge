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
  <input name="yemianname" value="01202" type="hidden"/>
    <!-- 主菜单 start -->
    <s:include value="/include/nav.jsp" />
    <!-- 主菜单 end -->
    <!-- 主容器 start -->
    <div class="container">
      <h3 class="current-title">查看慢性病档案</h3>
      <div class="search-content">
         <%-- <label>姓名：${vchronic.fileName}&nbsp;&nbsp;&nbsp;&nbsp;档案编号：${vchronic.fileNum}</label>&nbsp;&nbsp;&nbsp;&nbsp; --%>
            <s:iterator value="vclist" var="vl">
            <s:if test="status!=9">
         	<div class="btn">
            	<a href="<%=basePath %>showOldChronicAction!jumpShowChronic.action?chid=${vl.chronicDiseaseId}&helid=${vl.healthFileId}" class="btn" >${vl.diseaseName}</a>
         	</div>
         	</s:if>
            </s:iterator>
      </div>
      <!-- 结果容器 start -->
      <h3 class="current-title">查看心脑血管病档案</h3>
      <div class="table-content">
        <table id="jqprint" class="table table-bordered" style="word-break:break-all">
          <tbody>
          <tr>
             <td colspan="8">
             	<label>
             		姓名：${vchronic.fileName}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;档案编号：${vchronic.fileNum}
             		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;疾病名称：心脑血管病
             	</label>
             </td>
          </tr>
           <tr>
             <td colspan="8" class="title-td">基本信息</td>
           </tr>
           <tr>
             <td colspan="2">心脑血管病类型</td>
             <td colspan="6" >
              <label><c:out value="${vchronic.hcvdType}"></c:out></label>
             </td>  
           </tr>
           <tr>
             <td colspan="1">
              	首诊信息
             </td>
             <td colspan="7"><label><c:out value="${vchronic.hcvdFristDiagnose}"></c:out></label></td>
           </tr>
           <tr>
            
             <td colspan="2">
          	   危险原因：
             </td>
              <td colspan="2">
              <label><c:out value="${vchronic.hcvdCause}"></c:out></label>
             </td>
              <td colspan="2">
           	  起病形式：
             </td>
              <td colspan="2">
               <label><c:out value="${vchronic.hcvdForm}"></c:out></label>
             </td>
             
           </tr>

              <tr>
            
             <td colspan="1">
         	    并发症：
             </td>
              <td colspan="7">
              <label><c:out value="${vchronic.hcvdComplication}"></c:out></label>
             </td>
            
             
           </tr>
      
        <tr>
            
             <td colspan="2">
          	   用药情况：
             </td>
              <td colspan="2">
              <label><c:out value="${vchronic.hcvdUseDrug}"></c:out></label>
             </td>
              <td colspan="2">
          	   心电图：
             </td>
              <td colspan="2">
              <label><c:out value="${vchronic.hcvdElectrocardiogram}"></c:out></label>
             </td>
             
           </tr>
             <tr>
            
             <td colspan="2">
            	 脑电图：
             </td>
              <td colspan="2">
              <label><c:out value="${vchronic.hcvdElectroencephalogram}"></c:out></label>
             </td>
              <td colspan="2">
             X线：
             </td>
              <td colspan="2">
             <label><c:out value="${vchronic.hcvdX}"></c:out></label>
             </td>
             
           </tr>

             <tr>
            
             <td colspan="2">
             CT：
             </td>
              <td colspan="2">
              <label><c:out value="${vchronic.hcvdCt}"></c:out></label>
             </td>
              <td colspan="2">
           	  脑血管造影：
             </td>
              <td colspan="2">
               <label><c:out value="${vchronic.hcvdCerebralBloodVessel}"></c:out></label>
             </td>
             
           </tr>

          <tr>
            
            <td  colspan="1" >
              	备注
            </td>
            <td colspan="7"><label><c:out value="${vchronic.hcvdRemarks}"></c:out></label></td>
          </tr>
          
           <tr>
            
             <%-- <td >
        	     被调查人：
             </td>
              <td >
             <label><c:out value="${vchronic.hcvdInvestigatedPerson}"></c:out></label>
             </td> --%>
              <td >
         	    建档人：
             </td>
              <td >
              <label><c:out value="${vchronic.chronicDiseaseFileName}"></c:out></label>
             </td>
             
              <td >
             	建档时间
             </td>
              <td>
               <label><fmt:formatDate value="${vchronic.chronicDiseaseFileDate}" pattern="yyyy-MM-dd" /></label>
             </td>
              <td >
             	是否添加到慢病管理：
             </td>
              <td >
           		<s:if test="vchronic.status==0">
               <label><c:out value="否"></c:out></label>
               </s:if>
               <s:if test="vchronic.status!=0">
               <label><c:out value="是"></c:out></label>
            	</s:if>
             </td>
           </tr>




          </tbody>
        </table>
        <div class="btn-content">
          <a href="javascript:;" class="btn btn-print btn-dayin">打印</a>
          <a href="<%=basePath %>showOldChronicAction!firstShowChronic.action" class="btn">返回</a>
          <!-- <a href="javascript:;" class="btn btn-back">返回</a> -->
        </div>
      </div>
      <!-- 结果容器 end -->
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
