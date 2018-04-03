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
    <h3 class="current-title">慢性病档案</h3>
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
      <h3 class="current-title">查看残疾障碍档案</h3>
      <div class="table-content">
        <table id="jqprint" class="table table-bordered" style="word-break:break-all">
          <tbody>
          <tr>
             <td colspan="8">
             	<label>
             		姓名：${vchronic.fileName}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;档案编号：${vchronic.fileNum}
             		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;疾病名称：残疾障碍
             	</label>
             </td>
          </tr>
           <tr>
             <td colspan="6" class="title-td">基本信息</td>
           </tr>
           <tr>
             <td>视力残分级(有证)</td>
             <td colspan="1">
              <label><c:out value="${vchronic.residualVisionGrading}"></c:out></label>
             </td>
             <td>致残原因：</td>
             <td colspan="1">
               <label><c:out value="${vchronic.visionDisabilityReason}"></c:out></label>
             </td>
             <td>视力障碍(无证)：</td>
             <td colspan="1">
               <label><c:out value="${vchronic.visualImpairment}"></c:out></label>
             </td>
           </tr>
          <tr>
             <td>听力残分级(有证)</td>
             <td colspan="1">
              <label><c:out value="${vchronic.gradingOfAuditusDeformity}"></c:out></label>
             </td>
             <td>致残原因：</td>
             <td colspan="1">
               <label><c:out value="${vchronic.theHearingDisabilityReason}"></c:out></label>
             </td>
             <td>听力障碍(无证)：</td>
             <td colspan="1">
              <label><c:out value="${vchronic.hearingDisorder}"></c:out></label>
             </td>
           </tr>
          <tr>
             <td>是否带有助听器：</td>
             <td colspan="1">
               <label>
               <s:if test="vchronic.hearingAid==false"><c:out value="是"></c:out></s:if>
               <s:if test="vchronic.hearingAid==true"><c:out value="否"></c:out></s:if>
               </label>
             </td>
            
             <td colspan="5">    
             </td>
             
           </tr>

         <tr>
             <td>言语残分级(有证)</td>
             <td colspan="1">
               <label><c:out value="${vchronic.speechResidualClassification}"></c:out></label>
             </td>
             <td>致残原因：</td>
             <td colspan="1">
               <label><c:out value="${vchronic.speechDisabilityReason}"></c:out></label>
             </td>
             <td>言语障碍(无证)：</td>
             <td colspan="1">
               <label><c:out value="${vchronic.speechDisorder}"></c:out></label>
             </td>
           </tr>
              <tr>
             <td>智力残分级(有证)</td>
             <td colspan="1">
              <label><c:out value="${vchronic.intelligenceResidualClassification}"></c:out></label>
             </td>
             <td>致残原因：</td>
             <td colspan="1">
              <label><c:out value="${vchronic.intellectualDisabilityReason}"></c:out></label>
             </td>
             <td>智力障碍(无证)：</td>
             <td colspan="1">
               <label><c:out value="${vchronic.dysgnosia}"></c:out></label>
             </td>
           </tr>
              <tr>
             <td>肢体残分级(有证)</td>
             <td colspan="1">
               <label><c:out value="${vchronic.bodyResidualClassification}"></c:out></label>
             </td>
             <td>致残原因</td>
             <td colspan="1">
              <label><c:out value="${vchronic.physicalCauses}"></c:out></label>
             </td>
             <td>肢体残缺</td>
             <td colspan="1">
               <label><c:out value="${vchronic.mutilation}"></c:out></label>
             </td>
           </tr>
           <tr>
           	<td>
           		肢体残分类
           	</td>
           	<td colspan="7">
           	   <label><c:out value="${vchronic.bodyResidualClassificatio}"></c:out></label>
           	</td>
           </tr>
              <tr>
             <td>精神病分级(有证)</td>
             <td colspan="1">
              <label><c:out value="${vchronic.psychiatricClassification}"></c:out></label>
             </td>
             <td>致残原因：</td>
             <td colspan="1">
              <label><c:out value="${vchronic.causesMentalIllness}"></c:out></label>
             </td>
             <td>精神障碍(无证)：</td>
             <td colspan="1">
               <label><c:out value="${vchronic.psychogeny}"></c:out></label>
             </td>
           </tr>
              <tr>
             <td>精神病诊断结果：</td>
             <td colspan="1">
                <label><c:out value="${vchronic.psychiatricDiagnosis}"></c:out></label>
             </td>
             <td>诊断机构：</td>
             <td colspan="1">
                <label><c:out value="${vchronic.diagnoseOrganization}"></c:out></label>
             </td>
             <td>有无残疾证：</td>
             <td colspan="1">
               <label>
               <s:if test="vchronic.whetheDisability==false"><c:out value="有"></c:out></s:if>
               <s:if test="vchronic.whetheDisability==true"><c:out value="无"></c:out></s:if>
               </label>
             </td>
           </tr>

          <tr>
             <td>是否进行康复：</td>
             <td colspan="1">
              <label>
              <s:if test="vchronic.whetheGoRecovery==false"><c:out value="是"></c:out></s:if>
              <s:if test="vchronic.whetheGoRecovery==true"><c:out value="否"></c:out></s:if>
              </label>
             </td>
             <td>康复机构：</td>
             <td colspan="1">
               <label><c:out value="${vchronic.recoveryOrganization}"></c:out></label>
             </td>
             <td>不康复原因：</td>
             <td colspan="1">
               <label><c:out value="${vchronic.noRecoverReason}"></c:out></label>
             </td>
           </tr>
            <tr>
              <td>
           		     备注
              </td>
			  <td colspan="7">
				<label><c:out value="${vchronic.remark}"></c:out></label>
			  </td>
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
             <%-- <td>签名日期：</td>
             <td colspan="1">
             	<label><fmt:formatDate value="${vchronic.disabilityObstacleSignatureDate}" pattern="yyyy-MM-dd" /></label>
             </td> --%>
             <td>建档日期：</td>
             <td colspan="3">
                <label><fmt:formatDate value="${vchronic.chronicDiseaseFileDate}" pattern="yyyy-MM-dd" /></label>
             </td>
             <td>建档人：</td>
             <td colspan="3">
              <label><c:out value="${vchronic.chronicDiseaseFileName}"></c:out></label>
             </td>
             <%-- <td>复核日期：</td>
             <td colspan="1">
                <label><fmt:formatDate value="${vchronic.checkDate}" pattern="yyyy-MM-dd" /></label>
             </td> --%>
           </tr>

           <!-- <tr> -->
             <%-- <td>被调查人：</td>
             <td colspan="1">
              <label><c:out value="${vchronic.respondent}"></c:out></label>
             </td> --%>
             
             <%-- <td>复核人：</td>
             <td colspan="1">
               <label><c:out value="${vchronic.checker}"></c:out></label>
             </td> --%>
           <!-- </tr> -->
          
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
