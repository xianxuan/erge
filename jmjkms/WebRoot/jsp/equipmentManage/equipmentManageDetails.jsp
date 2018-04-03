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
     <h3 class="current-title">设备管理 <br></h3>
      <div class="table-content">
      <input name="yemianname"  value="09100" type="hidden"/>
        <form action="equipmentManageAction!saveEquipmentManage.action" method="post" enctype="multipart/form-data"> 
      
           <table class="table table-bordered" id="jqprint" style="word-break:break-all">
             <tbody>
          <c:if test="${session.comHospital.isHead==0 }"> <!--  社区医院 -->
             <tr>
                 <td>社区集团</td>
                 <td><c:out value="${equipmentTal.communitygroup}"></c:out></td>
                 <td>社区医院</td>
                 <td><c:out value="${equipmentTal.communityHospital}"></c:out></td>
             </tr>
          </c:if>
          <c:if test="${session.communityHospitalGroup !=null}">   <!-- 集团 -->
             <tr>
                 <td>社区医院</td>
                 <td><c:out value="${equipmentTal.communityHospital}"></c:out></td>
             </tr>
          </c:if>
             <tr>
                 <td>设备编号</td>
                 <td><c:out value="${equipmentTal.equipment.equipNumber}"></c:out></td>
                 <td>设备型号</td>
                 <td><c:out value="${equipmentTal.equipment.equipModel}"></c:out></td>
             </tr>
             <tr>
                 <td>状态</td>
                 <s:if test="equipmentTal.equipment.status==0">
                 <td>正常</td>
                 </s:if>
                 <s:if test="equipmentTal.equipment.status==1">
                 <td>问题</td>
                 </s:if>
                 <td>设备名称</td>
                 <td><c:out value="${equipmentTal.equipment.equipName}"></c:out></td>
             </tr>
             <tr>
                 <td>采购公司</td>
                 <td><c:out value="${equipmentTal.equipment.equipCompany}"></c:out></td>
                 <td>采购合同</td>
                 <td><c:out value="${equipmentTal.equipment.selectContract}"></c:out></td>
             </tr>
             <tr>
                 <td>采购人</td>
                 <td><c:out value="${equipmentTal.equipment.equipPeople}"></c:out></td>
                 <td>采购时间</td>
                 <td><fmt:formatDate value='${equipmentTal.equipment.selectTime}' pattern='yyyy-MM-dd'/></td>
              </tr>
              <tr>
                  <td>负责人</td>
                  <td><c:out value="${equipmentTal.equipment.TStaff.name}"></c:out></td>			   
                 <td>联系方式</td>
                 <td><c:out value="${equipmentTal.equipment.contact}"></c:out></td>               
              </tr>
               
             </tbody>
             </table>
         </form>
         
         
      </div>
	 <h3 class="current-title">维修记录 <br></h3>
	 <div class="table-content">
			<table class="table table-bordered"> 
	        	 <thead>
	           		<tr>
	             		<th>维修时间</th>
			            <th>设备问题</th>
			            <th>维修公司</th>
			            <th>维修费用</th>
			            <th>维修人员</th>
			            <th>状态</th>
		           </tr>
	         	</thead> 
	         	<tbody>
	         	 <s:iterator value="maintenanceList" var="ml">
					<tr>
	             		<td><fmt:formatDate value='${ml.date}' pattern='yyyy-MM-dd'/></td>
	             		<td>${ml.problem}</td>
	             		<td>${ml.company}</td>
	             	    <td>${ml.fee}</td>
	             		<td>${ml.person}</td>
	             		<s:if test="#ml.state==0">
	             		<td>未解决</td>
	             		</s:if>
	             		<s:if test="#ml.state==1">
	             		<td>已解决</td>
	             		</s:if>
	           		</tr>
	           	</s:iterator> 
	           	
				 </tbody>
			</table> 
			 <div class="btn-content">
                    <a href="javascript:;" class="btn btn-print">打印</a>
                    <a href="javascript:;" class="btn btn-back">返回</a>
                 </div> 
			
			
			<div class="page">
				${pageHtml}
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
