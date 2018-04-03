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
  <link rel="stylesheet" type="text/css" href="../../../css/sweetalert.css"> 
  <script src="../../../js/sweetalert.min.js"></script> 
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
          <h3 class="current-title">高血压医生诊断</h3>
         
<!-- 搜索容器 start -->
  <div class="search-content">
  <input name="yemianname" value="02204" type="hidden"/>
    <form action="doctorDiagnosisAction!searchDoctorDiagnosis.action" method="post">
            <label>诊断日期：</label>
            <input type="hidden" value="${chronicName}" name="chronicName">
            <input type="hidden" value="${daId}" name="daId">
            <input type="text" value="${startTime}" name="startTime" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
            至
            <input type="text" value="${endTime}" name="endTime" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
        <input type="submit" id="submit"  class="btn btn-xianshi"  value="查询">
        <a class="btn btn-xinzeng"
        href="<c:url value='${basePath }doctorDiagnosisAction!addDoctorDiagnosis.action'>
              <c:param name='chronicName' value='${chronicName}'/>  
              <c:param name='daId' value='${daId}'/> </c:url>"
        
        
         <%-- href="doctorDiagnosisAction!addDoctorDiagnosis.action?daId=${daId}&chronicName=${chronicName}" --%>>添加诊断</a>
    </form>
    
  </div>
   <!-- 搜索容器 start -->

<!-- 表格容器 start -->
<h3 class="current-title">查询结果</h3>
 <div class="table-content">
   <table class="table table-bordered">
     <thead>
       <tr>
         <th>档案编号</th>
          <th>姓名</th>
         <th>诊断日期</th>
         <th>疾病名称</th> 
         <th>诊断医生</th>
          <th>操作</th>   
       </tr>
     </thead>
     <tbody>
    
       <s:iterator value="doctorDiagnosisList"  >
       <tr>
       	 <td><c:out value="${THealthFile.fileNum}"></c:out></td>
         <td><c:out value="${THealthFile.name}"></c:out></td>
         <td>
         <fmt:formatDate value='${date}' pattern='yyyy-MM-dd'/>
         </td>
         <td><c:out value="${chronic}"></c:out></td>
         <td><c:out value="${TStaff.name}"></c:out></td>
         <td>
           <a class="btn-xianshi" href="doctorDiagnosisAction!infoDoctorDiagnosis.action?yszdId=${doctorDiagnosisId}" >详情</a>
           <a class="btn-xiugai" href="doctorDiagnosisAction!editDoctorDiagnosis.action?yszdId=${doctorDiagnosisId}&daId=${daId}&chronicName=${chronic}">编辑</a>
           <a class="btn-shanchu" href="doctorDiagnosisAction!deleteDoctorDiagnosis.action?yszdId=${doctorDiagnosisId}&daId=${daId}&chronicName=${chronic}" onclick="return confirm('是否删除？')">删除</a>
         </td>
         </tr>
         </s:iterator>
       
 	</tbody>
   </table>
  			 <div class="page">
				${pageHtml}
	    	</div>
	    	 <div class="btn-content">
                    <a class="btn btn-xianshi" href="chronicManagerAction!getAllHighBloodManager.action">返回</a>
               </div>
   </div>
 <!-- 表格容器 end -->
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
