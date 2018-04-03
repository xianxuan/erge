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
  <input name="yemianname" value="02206" type="hidden"/>
    <!-- 主菜单 start -->
    <s:include value="/include/nav.jsp" />
    <!-- 主菜单 end -->
    <!-- 主容器 start -->
    <div class="container">
      <h3 class="current-title">慢性病档案</h3>
      <!-- 搜索容器 start -->
      <h3 class="current-title">查看肿瘤档案</h3>
      <div class="table-content">
        <table id="jqprint" class="table table-bordered">
          <tr>
      			<td colspan="8" style="text-align:right;">姓名：<c:out value="${vchronic.fileName}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;档案编号：<c:out value="${vchronic.fileNum}"></c:out></td>
      		</tr>
           <tbody>
           <tr>
             <td colspan="8" class="title-td">诊断信息</td>
           </tr>
           <tr>
             <td>诊断信息</td>
             <td colspan="8" > <label><c:out value="${vchronic.diagnosticInformation}"></c:out></label> </td>
           </tr>
           <tr>  
             <td>出现日期</td>
             <td><label><fmt:formatDate value="${vchronic.emergenceDate}" pattern="yyyy-MM-dd" /></label></td>
             <td>就诊日期</td>
             <td><label><fmt:formatDate value="${vchronic.treatmentDate}" pattern="yyyy-MM-dd" /></label></td>
             <td>确诊日期</td>
             <td colspan="3"><label><fmt:formatDate value="${vchronic.tumourDiagnosisDate}" pattern="yyyy-MM-dd" /></label></td>
           </tr>
           <tr>
             <td>确诊医院</td>
             <td>
               <label><c:out value="${vchronic.tumourDiagnosedHospital}"></c:out></label>
             </td>
              <td>病理学类型</td>
             <td>
               <label><c:out value="${vchronic.tumourPathologicalType}"></c:out></label>
             </td>
             <td>确诊依据</td>
             <td colspan="3">
               <label><c:out value="${vchronic.confirmationBasis}"></c:out></label>
             </td>
           </tr>
           <tr>
             <td>确诊时期别</td>
             <td>
               <label><c:out value="${vchronic.diagnosisPeriod}"></c:out></label>
             </td>
             <td>门诊号</td>
             <td>
               <label><c:out value="${vchronic.outpatientNumber}"></c:out></label>
             </td>
             <td>住院号</td>
             <td colspan="3">
               <label><c:out value="${vchronic.inpatientNumber}"></c:out></label>
             </td>
           </tr>
           <tr>
             <td colspan="8" class="title-td">治疗情况</td>
           </tr>
           <tr>
             <td>治疗情况</td>
             <td colspan="3">
               <label><c:out value="${vchronic.treatment}"></c:out></label>
             </td>
             <td>转移情况</td>
             <td colspan="3">
               <label><c:out value="${vchronic.tranferSituation}"></c:out></label>
             </td>  
           </tr>
           <tr>
                <td>曾治疗情况</td>
             <td colspan="3">
               <label><c:out value="${vchronic.onceTreatment}"></c:out></label>
             </td>
             <td>目前治疗情况</td>
             <td colspan="3">
               <label><c:out value="${vchronic.currentTreatmentSituation}"></c:out></label>
             </td>  
           </tr>
           <tr>
             <td  class="title-td" colspan="8">经治医院</td>
             </tr>
             <tr>
             <td>手术医院</td>
             <td>
               <label><c:out value="${vchronic.surgicalHospital}"></c:out></label>
             </td>
             <td>化疗医院</td>
             <td>
               <label><c:out value="${vchronic.chemotherapyHospital}"></c:out></label>
             </td>
             <td>放疗医院</td>
             <td colspan="3">
               <label><c:out value="${vchronic.radiotherapyHospital}"></c:out></label>
             </td>
           </tr> 
           <tr>
              <td colspan="8" class="title-td">首次手术信息</td>
           </tr>
           <tr>
              <td>手术时间</td>
             <td><label><fmt:formatDate value="${vchronic.operateTime}" pattern="yyyy-MM-dd" /></label></td>
             <td>手术医院</td>
             <td>
               <label><c:out value="${vchronic.operateHospital}"></c:out></label>
             </td>
             <td>手术性质</td>
             <td>
               <label><c:out value="${vchronic.operateProperty}"></c:out></label>
             </td>
             <td>住院号</td>
             <td>
               <label><c:out value="${vchronic.admissionNum}"></c:out></label>
             </td>
           </tr>
           <tr>
              <td  class="title-td">复发时间</td>
              <td>第一次</td>
              <td><label><fmt:formatDate value="${vchronic.firstTime}" pattern="yyyy-MM-dd" /></label></td>
              <td>第二次</td>
              <td><label><fmt:formatDate value="${vchronic.secondTime}" pattern="yyyy-MM-dd" /></label></td>
              <td>第三次</td>
              <td colspan="2"><label><fmt:formatDate value="${vchronic.thirdTime}" pattern="yyyy-MM-dd" /></label></td>
           </tr>
            <tr>
             <td>肿瘤家族史</td>
             <td colspan="8" ><label><c:out value="${vchronic.cancerFamilyHistory}"></c:out></label></td>
           </tr>
           <tr>
              <td colspan="8" class="title-td">诊断更改</td>
           </tr>
           <tr>
             <td>更正日期</td>
             <td colspan="3"><label><fmt:formatDate value="${vchronic.changeDate}" pattern="yyyy-MM-dd" /></label></td>
             <td>更正诊断部位</td>
             <td colspan="3">
               <label><c:out value="${vchronic.changeDepartment}"></c:out></label>
             </td>
           </tr>
           <tr>
              <td colspan="8" class="title-td">肿瘤登记</td>
           </tr>
           <tr>
              <td class="title-td">死亡信息</td>
              <td>死亡日期</td>
              <td ><label><fmt:formatDate value="${vchronic.deathDate}" pattern="yyyy-MM-dd" /></label></td>
              <td>死亡原因</td>
              <td>
               <label><c:out value="${vchronic.deathReason}"></c:out></label>
              </td>
              <td>死亡地点</td>
              <td colspan="2">
               <label><c:out value="${vchronic.deathAddress}"></c:out></label>
              </td>
           </tr>
           <tr>
              <td>生存期</td>
              <td>
               <label><c:out value="${vchronic.TTumourYear}"></c:out></label>年<label><c:out value="${vchronic.mounth}"></c:out></label>月
              </td>
              <td>撤回随诊管理日期</td>
              <td colspan="2"><label><c:out value="${vchronic.withdrawalDate}"></c:out></label></td>
              <td>撤销随访管理原因</td>
              <td  colspan="2">
               <label><c:out value="${vchronic.withdrawalReason}"></c:out></label>
           </tr>
           <tr>
              <td colspan="8" class="title-td">原发性肺癌登记</td>
           </tr>
           <tr>
             <td>发现方式</td>
              <td  colspan="3">
               <label><c:out value="${vchronic.findWay}"></c:out></label>
              </td>
              <td>登记方式</td>
              <td  colspan="3">
               <label><c:out value="${vchronic.registrationWay}"></c:out></label>
              </td>
           </tr>
            <tr>
             <td>确诊依据（肺癌）</td>
              <td  colspan="3">
               <label><c:out value="${vchronic.diagnosisBasis}"></c:out></label>
              </td>
              <td>细胞学</td>
              <td  colspan="3">
               <label><c:out value="${vchronic.cytology}"></c:out></label>
              </td>
           </tr>
           <tr>
             <td>组织学</td>
              <td  colspan="3">
               <label><c:out value="${vchronic.hyphology}"></c:out></label>
              </td>
              <td>组织类型</td>
              <td  colspan="3">
               <label><c:out value="${vchronic.tumourHistologicalType}"></c:out></label>
              </td>
           </tr>
            <tr>
             <td>分期</td>
              <td  colspan="7">
               <label><c:out value="${vchronic.byStage}"></c:out></label>
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
             <td>签名日期</td>
             <td colspan="3"><label><fmt:formatDate value="${vchronic.tumourSignatureDate}" pattern="yyyy-MM-dd" /></label></td>
             <td>被调查人</td>
             <td colspan="3">
              <label><c:out value="${vchronic.tumourInvestigatedPerson}"></c:out></label>
             </td>
           </tr>
           <tr>
             <td>建档时间</td>
             <td colspan="3"><label><fmt:formatDate value="${vchronic.chronicDiseaseFileDate}" pattern="yyyy-MM-dd" /></label></td>
             <td>建档人</td>
             <td colspan="3">
              <label><c:out value="${vchronic.chronicDiseaseFileName}"></c:out></label>
             </td>
           </tr>
           <tr>
             <td>复核日期</td>
             <td colspan="3"><label><fmt:formatDate value="${vchronic.reviewDate}" pattern="yyyy-MM-dd" /></label></td>
             <td>复核人</td>
             <td colspan="3">
              <label><c:out value="${vchronic.reviewperson}"></c:out></label>
             </td>
           </tr>        
          </tbody>
        </table>
        <div class="btn-content">
          <a href="javascript:;" class="btn btn-print">打印</a>
          <a href="javascript:;" class="btn btn-back">返回</a>
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
