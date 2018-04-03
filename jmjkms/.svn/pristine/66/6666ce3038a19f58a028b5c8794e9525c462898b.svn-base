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
       <h3 class="current-title">双向转诊记录-详情</h3>
      
      <!-- 删除此行注释，在此添加对应的div -->
       
         
                
                
          
       <div class="table-content">
       <input name="yemianname" value="06204" type="hidden"/>
           <table id="jqprint" class="table table-bordered">
            <label>姓名：${healthFile.name }</label>
                <label> 档案编号：${healthFile.fileNum}</label>
             <tbody>
               <tr>
                 <td>转出日期</td>
                 <td><c:out value="${dualReferralRecord.outTime}"></c:out>
                 </td>
                 <td>转出单位</td>
                 <td><c:out value="${dualReferralRecord.outUnit}"></c:out></td>
                 <td>转出转诊医生</td>
                 <td><c:out value="${dualReferralRecord.outReferralDoctor}"></c:out></td>
                 <td>转出接诊医生</td>
                 <td>
                   <c:out value="${dualReferralRecord.outAcceptDoctor}"></c:out>
                 </td>
               </tr>
               <tr>
                 <td>转至单位</td>
                 <td><c:out value="${dualReferralRecord.goUnit}"></c:out></td>
                 <td>转至科室</td>
                 <td><c:out value="${dualReferralRecord.goDepartment}"></c:out></td>
                 <td>转出电话</td>
                 <td><c:out value="${dualReferralRecord.outPhone}"></c:out></td>
                 <td>住院病案号
                 </td>
                 <td>
                   <c:out value="${dualReferralRecord.medicalNum}"></c:out>
                 </td>
               </tr>
               <tr>
                 <td>回转日期</td>
                 <td><c:out value="${dualReferralRecord.cbTime}"></c:out>
                 </td>
                 <td>回转转诊医生</td>
                 <td><c:out value="${dualReferralRecord.cbReferralDoctor}"></c:out></td>
                 <td>回转接诊医生</td>
                 <td><c:out value="${dualReferralRecord.cbAcceptDoctor}"></c:out></td>
                 <td>转入电话</td>
                 <td><c:out value="${dualReferralRecord.cbPhone}"></c:out></td>
               </tr>
               <tr >
               <td>初步印象</td>
               <td><c:out value="${dualReferralRecord.impression}"></c:out></td>
               </tr>
               <tr>
               <td>主要检查结果</td>
               <td colspan="7"><c:out value="${dualReferralRecord.checkResult}"></c:out></td>
               </tr>
               <tr>
               <td>诊断结果</td>
               <td colspan="7"><c:out value="${dualReferralRecord.result}"></c:out></td>
               </tr>
               <tr>
                 <td >主要既往史</td>
                 <td colspan="7"><c:out value="${dualReferralRecord.pastHistory}"></c:out></td>
               </tr>
               <tr>
                 <td >主要现病史（转出原因）</td>
                 <td colspan="7"><c:out value="${dualReferralRecord.outReason}"></c:out></td>
               </tr>
               <tr>
                 <td >治疗经过</td>
                 <td colspan="7"><c:out value="${dualReferralRecord.treatment}"></c:out></td>
               </tr>
               <tr>
                 <td >下一步治疗方案及康复建议</td>
                 <td colspan="7"><c:out value="${dualReferralRecord.goThroughNextAdvice}"></c:out></td>
               </tr>
             </tbody>
             </table>
           <div class="btn-content">
             
               <a href="javascript:;" class="btn btn-print">打印</a>
             <a class="btn btn-xiugai" href="dualReferralRecordAction!turnToUpdateDualReferralRecord.action?drrId=${dualReferralRecord.dualRefRecId}&healthFileId=${healthFile.healthFileId}" >修改</a>
           
              <a href="dualReferralRecordAction!showDualReferralRecord.action" class="btn btn-back">返回</a>
           </div>
       </div>
      


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
