<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      <h3 class="current-title">随诊记录-详情</h3>
      
        <!-- 删除此行注释，在此添加对应的div -->

      <div class="table-content">
      <input name="yemianname" value="06201" type="hidden"/>
           <table id="jqprint" class="table table-bordered">
           <label>姓名：${healthFile.name }</label>
           <label> 档案编号：${healthFile.fileNum}</label>
             <tbody>
              <tr>
                  <td>随诊医生</td>
                 <td>  <c:out value="${followRecord.followDoctor}"></c:out> </td>
                 <td>随诊时间</td>
                 <td><c:out value="${followRecord.time}"></c:out></td>
                 <td>体重</td>
                 <td><c:out value="${followRecord.weight}"></c:out>KG</td>
                 <td>呼吸</td>
                 <td>
                   <c:out value="${followRecord.breathing}"></c:out>次/分
                 </td>
               </tr>
               <tr>
                 <td>舒张压</td>
                 <td><c:out value="${followRecord.diastolicBloodPressure}"></c:out>mmgh</td>
                 <td>收缩压</td>
                 <td><c:out value="${followRecord.sysrolicBloodPressure}"></c:out>mmgh</td>
                 <td>体温</td>
                 <td><c:out value="${followRecord.bodyTemperature}"></c:out>摄氏度</td>
                 <td>脉搏</td>
                 <td><c:out value="${followRecord.pulse}"></c:out>次/分</td>
                 
               </tr>
               <tr rowspan="3">
               <td>现病史</td>
                 <td colspan="7"><c:out value="${followRecord.hip}"></c:out></td>
               </tr>
               <tr>
               <td>转归</td>
               <td colspan="7"><c:out value="${followRecord.outcome}"></c:out></td>
               </tr>
               <tr>
               <td>主诉</td>
               <td colspan="7"><c:out value="${followRecord.actionChief}"></c:out></td>
               </tr>
               <tr>
               <td>诊断</td>
               <td colspan="7"><c:out value="${followRecord.diagnosis}"></c:out></td>
               </tr>
               <tr>
                 <td >处理情况</td>
                 <td colspan="7"><c:out value="${followRecord.dealWith}"></c:out></td>
               </tr>
             </tbody>
             </table>
           <div class="btn-content">
               <a href="javascript:;" class="btn btn-print">打印</a>
             <a class="btn btn-xiugai" href="followRecordAction!turnToUpdateFollowRecord.action?followId=${followRecord.followRecordId}&healthFileId=${healthFile.healthFileId}" >修改</a>
            
              <a href="followRecordAction!showFollowRecord.action" class="btn btn-back">返回</a>
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
