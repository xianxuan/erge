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
      <h3 class="current-title">慢性病档案</h3>
      
      <!-- 搜索容器 start -->
      <div class="search-content">
             <label>
            	姓名：<c:out value="${vchronic.fileName}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;档案编号：<c:out value="${vchronic.fileNum}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;
            </label>
      </div>
      <h3 class="current-title">编辑冠心病档案</h3>
      <form action="<%=basePath %>showOldChronicAction!editCoronnary.action" method="post" >
      <div class="table-content">
        <table class="table table-bordered">
          <tbody>
          <tr>
            <td>冠心病类型<input type = "hidden" name = "helid"  value="${vchronic.healthFileId}" ></td>
              <td colspan="7">
               <select name="coronaryDisease.type">
                 <s:iterator value="gxblx" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.coronaryDiseaseType}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
          </tr>
          <tr>
              <td>首诊信息<input type = "hidden" name = "htype"  value= "${vchronic.healthFileType}"></td>
              <td colspan="7" ><textarea  
               name="coronaryDisease.fristDiagnose"   class="textarea temp" >${vchronic.coronaryDiseaseFristDiagnose}</textarea></td>
          </tr>
          <tr>
            <td>危险原因</td>
              <td colspan="3">
               <select name="coronaryDisease.cause">
                 <option value="" >请选择</option>
                 <s:iterator value="wxyy" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.coronaryDiseaseCause}">selected</c:if>>${g.name}</option>
               </s:iterator>  
               </select>
             </td>
             <td>起病形式</td>
              <td colspan="3">
               <select name="coronaryDisease.form" >
                 <option value="" >请选择</option>
                 <s:iterator value="qbxs" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.coronaryDiseaseForm}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
          </tr>
          <tr>
            <td>并发症</td>
              <td colspan="7">
               <select name="coronaryDisease.complication">
                  <option value="" >请选择</option>
                 <s:iterator value="bfz" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.coronaryDiseaseComplication}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
          </tr>
          <tr>
            <td>用药情况</td>
              <td colspan="3">
               <select name="coronaryDisease.useDrug">
                 <option value="" >请选择</option>
                 <s:iterator value="yyqk" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.coronaryDiseaseUseDrug}">selected</c:if>>${g.name}</option>
               </s:iterator> 
               </select>
             </td>
             <td>心电图</td>
              <td colspan="3">
               <select name="coronaryDisease.electrocardiogram">
                 <option value="" >请选择</option>
                 <s:iterator value="xdt" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.electrocardiogram}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
          </tr>
          <tr>
            <td>脑电图</td>
              <td colspan="3">
               <select name="coronaryDisease.electroencephalogram">
                 <option value="" >请选择</option>
                 <s:iterator value="ndt" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.electroencephalogram}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>X线</td>
              <td colspan="3">
               <select name="coronaryDisease.x">
                   <option value="">请选择</option>
                 <s:iterator value="xx" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.coronaryDiseaseX}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
          </tr>
          <tr>
            <td>CT</td>
              <td colspan="3">
               <select name="coronaryDisease.ct">
                 <option value="" >请选择</option>
                 <s:iterator value="ct" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.coronaryDiseaseCt}">selected</c:if>>${g.name}</option>
               </s:iterator> 
               </select>
             </td>
             <td>脑血管造影</td>
              <td colspan="3">
               <select name="coronaryDisease.cerebralBloodVessel">
                 <option value="" >请选择</option>
                 <s:iterator value="nxgzy" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.coronaryDiseaseCerebralBloodVessel}">selected</c:if>>${g.name}</option>
               </s:iterator> 
               </select>
             </td>
          </tr>
          <tr>
              <td>备注</td>
              <td colspan="7" ><textarea  
               name="coronaryDisease.remarks" id=""  class="textarea temp">${vchronic.coronaryDiseaseRemarks}</textarea></td>
          </tr>
          <tr>
             <td>是否添加到慢病管理</td>
             <td colspan="7">
              <s:if test="vchronic.status==0">
               <label>否</label>
               </s:if>
               <s:if test="vchronic.status!=0">
               <label>是</label>
               </s:if>
             </td>
          </tr>
          <tr>
             <!--  <td colspan="2"></td> -->
              <%-- <td>被调查人</td>
              <td>
              <label>${vchronic.ivestingPerson}</label>
              <input type="hidden" value="${vchronic.ivestingPerson}" name="coronaryDisease.ivestingPerson">
             </td> --%>
             <td>建档人</td>
              <td colspan="3">
              <label>${vchronic.chronicDiseaseFileName}</label>
             </td>
             <td>建档日期</td>
              <td colspan="3">
               <label><fmt:formatDate value="${vchronic.chronicDiseaseFileDate}" pattern="yyyy-MM-dd"/></label>
              </td>
            </tr>            
          </tbody>
        </table>
       
        
         <!-- 慢性病总表Id  使用隐藏域-->
        <input type="hidden" value="${chronicDisease.chronicDiseaseId}" name="chronicDisease.chronicDiseaseId">      
        <input type="hidden" value="${vchronic.coronaryDiseaseId}" name="coronaryDisease.coronaryDiseaseId">
        <div class="btn-content">
          <input type="submit" class="btn" value="保存">
          <a href="<%=basePath %>showOldChronicAction!firstShowChronic.action" class="btn">返回</a>
          <!-- <a href="javascript:;" class="btn btn-back">返回</a> -->
        </div>
      </div>
      </form>
      <!-- 结果容器 end -->




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
