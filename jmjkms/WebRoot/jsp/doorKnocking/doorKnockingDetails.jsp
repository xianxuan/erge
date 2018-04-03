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
      <h3 class="current-title">上门随访 <br></h3>
        <div class="table-content"> 
        <input name="yemianname"  value="05202" type="hidden"/>
          <form action="doorKnockingAction!saveDoorKnocking.action" method="post" enctype="multipart/form-data"> 
            
				  <table class="table table-bordered" id="jqprint" style="word-break:break-all">
				    <tbody>
				    <c:if test="${session.comHospital.isHead==0 }">   <!-- 系统管理员 -->
				       <tr>
				       <td>社区集团</td>
				       <td><c:out value="${doorKnokingTal.communitygroup}"></c:out></td>
				       <td>社区医院</td>
				       <td><c:out value="${doorKnokingTal.communityHospital}"></c:out></td>
				       </tr>
				    </c:if>
				    <c:if test="${session.communityHospitalGroup !=null}">   <!-- 集团 -->
				       <tr>
				       <td>社区医院</td>
				       <td><c:out value="${doorKnokingTal.communityHospital}"></c:out></td>
				       </tr>
				    </c:if>
			           <tr>
			           <td>随访名称</td>
			           <td><c:out value="${doorKnokingTal.doornock.visiteName}"></c:out></td>
			           <td>随访对象</td>
			           <td><c:out value="${doorKnokingTal.doornock.visitePeople}"></c:out></td>
			           </tr>
			           <tr>
			             <td>计划时间</td>
			             <td><fmt:formatDate value='${doorKnokingTal.doornock.planTime}' pattern='yyyy-MM-dd'/></td>
			             <td>制定时间</td>
			             <td><fmt:formatDate value='${doorKnokingTal.doornock.formulateTime}' pattern='yyyy-MM-dd'/></td>
			           </tr>
			           <tr>
			             <td>制定人</td>
			             <td><c:out value="${doorKnokingTal.doornock.TStaff.name}"></c:out></td>
			             <td>状态</td>
			             <s:if test="doorKnokingTal.doornock.status==0">
			             <td><c:out value="暂缓处理"></c:out></td>
			             </s:if>
			             <s:if test="doorKnokingTal.doornock.status==1">
			             <td><c:out value="待处理"></c:out></td>
			             </s:if>
			             <s:if test="doorKnokingTal.doornock.status==2">
			             <td><c:out value="不处理"></c:out></td>
			             </s:if>
			             <s:if test="doorKnokingTal.doornock.status==3">
			             <td><c:out value="已处理"></c:out></td>
			             </s:if>
			           </tr>
			           <tr>
			             <td>参与者</td>
			             <td><c:out value="${doorKnokingTal.doornock.participatePeople}"></c:out></td> 
			           </tr>
			           
			           <tr>
			             <td>记录随访内容</td>
			              <td colspan="3"><c:out value="${doorKnokingTal.doornock.content}"></c:out></td> 
			           </tr>
			           
			           <tr>
			             <td>备注</td>
			             <td colspan="3"><c:out value="${doorKnokingTal.doornock.note}"></c:out></td> 
			           </tr>
			           

                    </tbody> 
                  </table>
                 <div class="btn-content">
                    <a href="javascript:;" class="btn btn-print">打印</a>
                    <a href="javascript:;" class="btn btn-back">返回</a>
                 </div>
             </form>
            </div> <!-- 表单表格 start -->
      


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
