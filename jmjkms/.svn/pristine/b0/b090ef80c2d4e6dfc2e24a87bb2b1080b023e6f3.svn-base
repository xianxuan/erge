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
     <h3 class="current-title">健康教育 <br></h3>
      <div class="table-content">
      <input name="yemianname"  value="05201" type="hidden"/>
           <table class="table table-bordered" id="jqprint" style="word-break:break-all">
             <tbody>
            <c:if test="${session.comHospital.isHead==0 }">   <!-- 系统管理员 -->
              <tr>
                  <td>社区集团</td>
                  <td><c:out value="${healtEducation.communitygroup}"></c:out></td>
                  <td>社区医院</td>
                  <td><c:out value="${healtEducation.communityHospital}"></c:out></td>
              </tr>
            </c:if>
            <c:if test="${session.communityHospitalGroup !=null}">   <!-- 集团 -->
              <tr>
                  <td>社区医院</td>
                  <td><c:out value="${healtEducation.communityHospital}"></c:out></td>
              </tr>
            </c:if>
              <tr>
                  <td>负责人</td>
                  <td><c:out value="${healtEducation.health.TStaff.name}"></c:out></td>			   
                 <td>活动主题</td>
                 <td><c:out value="${healtEducation.health.activeTheme}"></c:out></td>               
               </tr>
               <tr>
                 <td>活动形式</td>
                 <td><c:out value="${healtEducation.health.activeType}"></c:out></td>
                 <td>活动对象</td>
                 <td><c:out value="${healtEducation.health.activePeople}"></c:out></td>
               </tr>
               <tr>
                 <td>组织者</td>
                 <td><c:out value="${healtEducation.health.organizer}"></c:out></td>
                 <td>宣教人</td>
                 <td><c:out value="${healtEducation.health.eduPeople}"></c:out></td>
               </tr>
               <tr>
                 <td>接受教育人员种类</td>
                 <td><c:out value="${healtEducation.health.peopleType}"></c:out></td>
                 <td>接受教育人数</td>
                 <td><c:out value="${healtEducation.health.peopleNumber}"></c:out></td>
               </tr>
               <tr>
                 <td>活动地点</td>
                 <td><c:out value="${healtEducation.health.activePlace}"></c:out></td>
                 <td>活动时间</td>
                 <td><fmt:formatDate value='${healtEducation.health.activeTime}' pattern='yyyy-MM-dd'/></td>
               </tr>
               <tr>
			     <td>填表时间</td>
			     <td colspan="3"><fmt:formatDate value='${healtEducation.health.fillFormTime}' pattern='yyyy-MM-dd'/></td>			     
			   </tr>
               <tr>
                 <td>活动内容</td>
                 <td colspan="7"><c:out value="${healtEducation.health.activeContent}"></c:out></td>
               </tr>
               <tr>
                 <td>活动评价</td>
                 <td colspan="7"><c:out value="${healtEducation.health.activeEvalut}"></c:out></td>
               </tr>
               <tr>
			      <td>存档资料</td>
			      <td colspan="3">
			      <c:if test="${empty  healtEducation.health.information}">
			     	<input type="button"  class="btn-unable"  value="下载文件" ></td>
			     </c:if>
			     <c:if test="${not empty healtEducation.health.information}">
			     	 <input type="button"  class="btn" onclick="return(downLoadFile())" value="下载文件"></td>
			     </c:if> 
             </tbody>
             </table>
           <div class="btn-content">
             <a href="javascript:;" class="btn btn-print">打印</a>
             <a href="javascript:;" class="btn btn-back">返回</a>
           </div>
     </div>



    </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>
  
  <script type="text/javascript">
    function downLoadFile()
    {
     	window.location.href="healthEducationAction!downLoadFile.action?healthEducationId=${healthEducation.healthEduId}";

    } 
  
 </script>

<script src="/jmjkms/js/jquery-1.4.4.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<script src="/jmjkms/js/jquery.jqprint-0.3.js"></script>
</body>
</html>
