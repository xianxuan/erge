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
  <link type="text/css" href="jmjkms/css/yang/confirm.css">
  
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
         <%-- <label>姓名：${vchronic.fileName}&nbsp;&nbsp;&nbsp;&nbsp;档案编号：${vchronic.fileNum}</label>&nbsp;&nbsp;&nbsp;&nbsp; --%>
            <s:iterator value="vclist" var="vl">
            <s:if test="status!=9">
         	<div class="btn">
            	<a href="<%=basePath %>showOldChronicAction!jumpShowChronic.action?chid=${vl.chronicDiseaseId}&helid=${vl.healthFileId}" class="btn" >${vl.diseaseName}</a>
         	</div>
         	</s:if>
            </s:iterator>
      </div>
      <h3 class="current-title">查看慢性支气管病档案</h3>
      <div class="table-content">
        <table id="jqprint" class="table table-bordered" style="word-break:break-all">
          <tbody>
          <tr>
             <td colspan="8">
             	<label>
             		姓名：${vchronic.fileName}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;档案编号：${vchronic.fileNum}
             		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;疾病名称：慢性支气管病
             	</label>
             </td>
          </tr>
            <tr>
              <td>确诊时间</td>
              <td>
              <fmt:formatDate value="${vchronic.chronicBronchialDiseaseDiagnosisDate}" pattern="yyyy-MM-dd" />
              </td>
              <td>确诊医院</td>
              <td colspan="2">
              	<label><c:out value="${vchronic.diagnosedHospital}"></c:out></label>
             </td>
             <td>每年发病次数</td>
               <td colspan="2"><label><c:out value="${vchronic.annualIncidence}"></c:out></label></td>
            </tr>
            <tr>
              <td>每次发病治疗时间(天)</td>
              <td><label><c:out value="${vchronic.eachTimeTreatment}"></c:out></label></td>
              <td>发病主要原因</td>
              <td colspan="3">
               <label><c:out value="${vchronic.mainCausesDisease}"></c:out></label>
              </td>
              <td>咳嗽程度</td>
              <td>
               <label><c:out value="${vchronic.coughDegree}"></c:out></label>
              </td>
            </tr>
            <tr>
              <td>咳嗽颜色</td>
              <td>
               <label><c:out value="${vchronic.coughColor}"></c:out></label>
              </td>
              <td>是否伴有喘息</td>
              <td>
               <label><c:out value="${vchronic.isAccompaniedWheezing}"></c:out></label>
              </td>
              <td>血常规</td>
              <td>
               <label><c:out value="${vchronic.routineBloodTest}"></c:out></label>
              </td>
              <td>X线</td>
              <td>
               <label><c:out value="${vchronic.XRay}"></c:out></label>
              </td>
            </tr>
            <tr>
              <td>痰涂片或培养</td>
              <td>
               <label><c:out value="${vchronic.sputumSmearCulture}"></c:out></label>
              </td>
              <td>肺功能测定</td>
              <td colspan="5"><c:out value="${vchronic.lungFunctionTest}"></c:out></td>
            </tr>
            <tr>
              <td>并发症</td>
              <td colspan="2">
                <label><c:out value="${vchronic.chronicBronchialDiseaseComplication}"></c:out></label>
              </td>
              <td>自觉气短评定</td>
              <td colspan="2">
               <label><c:out value="${vchronic.selefBreath}"></c:out></label>
             </td>
             <td>心脏功能分级</td>
             <td>
               <label><c:out value="${vchronic.heartClass}"></c:out></label>
             </td>

            </tr>
            <tr>
              <td>备注</td>
              <td colspan="7" ><label><c:out value="${vchronic.chronicBronchialDiseaseRemarks}"></c:out></label></td>
            </tr>
            <tr>
             <td>是否添加到慢病管理</td>
             <td colspan="7">
               <s:if test="vchronic.status==0">
               <label><c:out value="否"></c:out></label>
               </s:if>
               <s:if test="vchronic.status!=0">
               <label><c:out value="是"></c:out></label>
               </s:if>
             </td>
            </tr>
            <tr>
             <td colspan="8" class="title-td"></td>
            </tr>
            <tr>
              <!-- <td colspan="2"></td> -->
              <%-- <td>被调查人</td>
              <td>
               <label><c:out value="${vchronic.chronicBronchialDiseaseInvestigatedPerson}"></c:out></label>
             </td> --%>
             <td>建档人</td>
              <td colspan="3">
               <label><c:out value="${vchronic.chronicDiseaseFileName}"></c:out></label>
             </td>
             <td>建档日期</td>
              <td colspan="3">
               <label><fmt:formatDate value="${vchronic.chronicDiseaseFileDate}" pattern="yyyy-MM-dd" /></label>
             </td>
            </tr>
          </tbody>
        </table>
        <div class="btn-content">
          <a href="javascript:;" class="btn btn-print">打印</a>
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
<script type="text/javascript" src="jmjkms/js/yang/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="jmjkms/js/yang/Validform_v5.3.2_min.js"></script>
<script src="/jmjkms/js/jquery.jqprint-0.3.js"></script>

</body>
</html>
