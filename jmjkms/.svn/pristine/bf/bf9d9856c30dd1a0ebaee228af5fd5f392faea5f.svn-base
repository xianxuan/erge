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
  <link type="text/css" href="/jmjkms/css/confirm.css">
  
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
            <label>
            	姓名：<c:out value="${vchronic.fileName}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;档案编号：<c:out value="${vchronic.fileNum}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;
            </label>


      </div>
      <!-- 结果容器 start -->
      <h3 class="current-title">编辑残疾障碍档案</h3>
      <form action="<%=basePath %>showOldChronicAction!editDisability.action" method="post" id="registerform">
      <div class="table-content">
        <table class="table table-bordered">
          <tbody>
           <tr>
             <td colspan="6" class="title-td">基本信息<input type = "hidden" name = "cjid"  value= "${vchronic.disabilityObstacleId}"></td>
           </tr>
           <tr>
             <td>视力残分级(有证)<input type="hidden" value="${chronicDisease.chronicDiseaseId}" name="chronicDisease.chronicDiseaseId"></td>
             <td colspan="1">
               <select name="disability.residualVisionGrading">
                 <option value="">请选择</option>
                 <s:iterator value="slcfj" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.residualVisionGrading}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>致残原因：<input type = "hidden" name = "htype"  value= "${vchronic.healthFileType}"></td>
             <td colspan="1">
               <select name="disability.visionDisabilityReason">
                 <option value="">请选择</option>
                  <s:iterator value="cjyy" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.visionDisabilityReason}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>视力障碍(无证)：</td>
             <td colspan="1">
               <select name="disability.visualImpairment">
                 <option value="">请选择</option>
                 <option value="有" <c:if test="${'有' eq vchronic.visualImpairment}">selected</c:if>>有</option>
                 <option value="无" <c:if test="${'无' eq vchronic.visualImpairment}">selected</c:if>>无</option>
               </select>
             </td>
           </tr>
          <tr>
             <td>听力残分级(有证)</td>
             <td colspan="1">
               <select name="disability.gradingOfAuditusDeformity">
                 <option value="">请选择</option>
                 <s:iterator value="tlcfj" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.gradingOfAuditusDeformity}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>致残原因：</td>
             <td colspan="1">
               <select name="disability.theHearingDisabilityReason">
                 <option value="">请选择</option>
                 <s:iterator value="cjyy" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.theHearingDisabilityReason}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>听力障碍(无证)：</td>
             <td colspan="1">
               <select name="disability.hearingDisorder">
                 <option value="">请选择</option>
                 <option value="有" <c:if test="${'有' eq vchronic.hearingDisorder}">selected</c:if>>有</option>
                 <option value="无" <c:if test="${'无' eq vchronic.hearingDisorder}">selected</c:if>>无</option>
               </select>
             </td>
           </tr>
          <tr>
             <td>是否带有助听器：</td>
             <td colspan="1">
               <select name="disability.hearingAid">
                 <option value="">请选择</option>
                 <option value="true" <c:if test="${vchronic.hearingAid eq 'true' }">selected</c:if> >是</option>
                 <option value="false" <c:if test="${vchronic.hearingAid eq 'false' }">selected</c:if> >否</option>
               </select>
             </td>
            
             <td colspan="5">    
             </td>
             
           </tr>

         <tr>
             <td>言语残分级(有证)</td>
             <td colspan="1">
               <select name="disability.speechResidualClassification">
                 <option value="">请选择</option>
                 <s:iterator value="yycjfj" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.speechResidualClassification}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>致残原因：</td>
             <td colspan="1">
               <select name="disability.speechDisabilityReason">
                 <option value="">请选择</option>
                 <s:iterator value="cjyy" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.speechDisabilityReason}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>言语障碍(无证)：</td>
             <td colspan="1">
               <select name="disability.speechDisorder">
                 <option value="">请选择</option>
                 <option value="有" <c:if test="${'有' eq vchronic.speechDisorder}">selected</c:if>>有</option>
                 <option value="无" <c:if test="${'无' eq vchronic.speechDisorder}">selected</c:if>>无</option>
               </select>
             </td>
           </tr>
              <tr>
             <td>智力残分级(有证)</td>
             <td colspan="1">
               <select name="disability.intelligenceResidualClassification">
                <option value="">请选择</option>
                 <s:iterator value="zlcjfj" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.intelligenceResidualClassification}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>致残原因：</td>
             <td colspan="1">
               <select name="disability.intellectualDisabilityReason">
                <option value="">请选择</option>
                <s:iterator value="cjyy" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.intellectualDisabilityReason}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>智力障碍(无证)：</td>
             <td colspan="1">
               <select name="disability.dysgnosia">
                 <option value="" >请选择</option>
                 <option value="有" <c:if test="${'有' eq vchronic.dysgnosia}">selected</c:if>>有</option>
                 <option value="无" <c:if test="${'无' eq vchronic.dysgnosia}">selected</c:if>>无</option>
               </select>
             </td>
           </tr>
              <tr>
             <td>肢体残分级(有证)</td>
             <td colspan="1">
               <select name="disability.bodyResidualClassification">
                 <option value="">请选择</option>
                  <s:iterator value="ztcfj" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.bodyResidualClassification}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>致残原因</td>
             <td colspan="1">
               <select name="disability.physicalCauses">
                 <option value="">请选择</option>
                  <s:iterator value="cjyy" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.physicalCauses}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>肢体残缺</td>
             <td colspan="1">
               <select name="disability.mutilation">
                 <option value="">请选择</option>
                 <option value="有" <c:if test="${'有' eq vchronic.mutilation}">selected</c:if>>有</option>
                 <option value="无" <c:if test="${'无' eq vchronic.mutilation}">selected</c:if>>无</option>
               </select>
             </td>
           </tr>
           <tr>
           	<td>肢体残分类(有证)</td>
            <td colspan="7">
            	<select name="disability.bodyResidualClassificatio">
                <option value="">请选择</option>
                  <s:iterator value="ztcfl" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.bodyResidualClassificatio}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
            </td>
           </tr>
              <tr>
             <td>精神病分级(有证)</td>
             <td colspan="1">
               <select name="disability.psychiatricClassification">
                  <option value="" >请选择</option>
                  <s:iterator value="jsbfj" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.psychiatricClassification}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>致残原因：</td>
             <td colspan="1">
               <select name="disability.causesMentalIllness">
                  <option value="">请选择</option>
                  <s:iterator value="cjyy" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.causesMentalIllness}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>精神障碍(无证)：</td>
             <td colspan="1">
               <select name="disability.psychogeny">
                  <option value="" >请选择</option>
                  <option value="有" <c:if test="${'有' eq vchronic.psychogeny}">selected</c:if>>有</option>
                  <option value="无" <c:if test="${'无' eq vchronic.psychogeny}">selected</c:if>>无</option>
               </select>
             </td>
           </tr>
              <tr>
             <td>精神病诊断结果：</td>
             <td colspan="1">
              <input  
               type="text" class="temp" name="disability.psychiatricDiagnosis" value="${vchronic.psychiatricDiagnosis}" maxlength="50">
             </td>
             <td><span class="required">*</span>诊断机构</td>
             <td colspan="1">
              <input  
               type="text" class="temp" name="disability.diagnoseOrganization" value="${vchronic.diagnoseOrganization}" maxlength="20" datatype="*" nullmsg="诊断机构不可为空">
             </td>
             <td>有无残疾证</td>
             <td colspan="1">
               <select name="disability.whetheDisability">
                 <option value="">请选择</option>
                 <option value="true" <c:if test="${vchronic.whetheDisability eq 'true' }">selected</c:if> >有</option>
                 <option value="false" <c:if test="${vchronic.whetheDisability eq 'false'}">selected</c:if> >无</option>
               </select>
             </td>
           </tr>

          <tr>
             <td>是否进行康复</td>
             <td colspan="1">
               <select name="disability.whetheGoRecovery">
                 <option value="">请选择</option>
                 <option value="true" <c:if test="${vchronic.whetheGoRecovery eq 'true' }">selected</c:if> >是</option>
                 <option value="false" <c:if test="${vchronic.whetheGoRecovery eq 'false' }">selected</c:if> >否</option>
               </select>
             </td>
             <td>康复机构</td>
             <td colspan="1">
               <select name="disability.recoveryOrganization">
                 <option value="">请选择</option>
                  <s:iterator value="kfjg" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.recoveryOrganization}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>不康复原因</td>
             <td colspan="1">
               <select name="disability.noRecoverReason">
                <option value="">请选择</option>
                 <s:iterator value="bkfyy" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.noRecoverReason}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
           </tr>
            <tr>
              <td colspan="6">
             	   备注：<textarea   name="disability.remark" id=""  class="textarea temp">${vchronic.remark}</textarea>
              </td>

            </tr>
			<tr>
			<td>是否添加到慢病管理
			<input type = "hidden" name = "disability.signatureDate"  value= "${vchronic.disabilityObstacleSignatureDate}">
			<input type = "hidden" name = "disability.checkDate"  value= "${vchronic.checkDate}">
			<input type = "hidden" name = "disability.respondent"  value= "${vchronic.respondent}">
			<input type = "hidden" name = "disability.checker"  value= "${vchronic.checker}">
			</td>
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
             <%-- <td>签名日期</td>
             <td colspan="1">
               <label><fmt:formatDate value="${vchronic.disabilityObstacleSignatureDate}" pattern="yyyy-MM-dd" /></label>  
               
             </td> --%>
             <td>建档日期</td>
             <td colspan="3">
                <label><fmt:formatDate value="${vchronic.chronicDiseaseFileDate}" pattern="yyyy-MM-dd" /></label>
             </td>
             <td>建档人</td>
             <td colspan="3">
               <label>${vchronic.chronicDiseaseFileName}</label>
             </td>
             <%-- <td>复核日期</td>
             <td colspan="1">
                <label><fmt:formatDate value="${vchronic.checkDate}" pattern="yyyy-MM-dd" /></label>  
                
             </td> --%>
           </tr>

           <!-- <tr> -->
             <%-- <td>被调查人</td>
             <td colspan="1">
               <label>${vchronic.respondent}</label>
               
             </td> --%>
             
             <%-- <td>复核人</td>
             <td colspan="1">
               <label>${vchronic.checker}</label>
               
             </td> --%>
           <!-- </tr> -->

          </tbody>
        </table>
        <div class="btn-content">
          <input type="submit" class="btn" value="保存">
          <a href="<%=basePath %>showOldChronicAction!firstShowChronic.action" class="btn">返回</a>
          <!-- <a href="javascript:;" class="btn btn-back">返回</a> -->
        </div>
      </div>
      </form>
      <!-- 结果容器 end -->
      </div>
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>

<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<%-- <script type="text/javascript" src="/jmjkms/js/yang/jquery-1.9.1.min.js"></script> --%>
<script type="text/javascript" src="/jmjkms/js/confirm/Validform_v5.3.2_min.js"></script>
<script type="text/javascript">
    $(function(){
      $("#registerform").Validform({
        showAllError:false,
        tiptype:function(msg){          
          alert(msg);
        }
      });
  });
	</script>


</body>
</html>
