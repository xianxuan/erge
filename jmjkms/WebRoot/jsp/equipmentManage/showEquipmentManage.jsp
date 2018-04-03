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
  <%-- <link rel="stylesheet" type="text/css" href="../../../css/sweetalert.css"> 
  <script src="../../../js/sweetalert.min.js"></script> --%>
  <link rel="stylesheet" href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">
  
  <style type="text/css">
  span.cspan{
    display: inline-block;        
    width:150px; /这个宽度可以根据自己需要，大小自己决定/
    word-break:keep-all;/* 不换行 */  
    white-space:nowrap;/* 不换行 */  
    overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */  
    text-overflow:ellipsis;/* 文本溢出时显示省略标记(...)与overflow:hidden;一起使用*/
}
span.dspan{
    display: inline-block; 
    width:100px; /这个宽度可以根据自己需要，大小自己决定/
    word-break:keep-all;/* 不换行 */  
    white-space:nowrap;/* 不换行 */  
    overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */  
    text-overflow:ellipsis;
}
</style>


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
      <h3 class="current-title">设备管理</h3>
      
      <!-- 删除此行注释，在此添加对应的div -->
		<div class="search-content">
		<input name="yemianname"  value="09100" type="hidden"/>
			<form class="search-form" action="equipmentManageAction!getEquipmentManageBySearch.action" method="post">
	            	<label>查询选项：</label>
                <select name="strSearch" id="">
                    <option value="">请选择</option>
                   <option value="设备名称" <c:if test="${strSearch =='设备名称'}">selected</c:if>>设备名称</option>
                   <option value="设备型号" <c:if test="${strSearch =='设备型号'}">selected</c:if>>设备型号</option>
                   <option value="设备编号" <c:if test="${strSearch =='设备编号'}">selected</c:if>>设备编号</option>
                   <option value="设备采购人" <c:if test="${strSearch =='设备采购人'}">selected</c:if>>设备采购人</option>
                </select>
	            <input class="temp"  class="text-input" type="text"  name="strSearchText" value="${strSearchText}">	            
	           
	           
	            <input class="btn btn-xianshi" type="submit"  value="查询" />
	            <a class="btn btn-xinzeng" href="equipmentManageAction!addEquipmentManage.action" >添加设备</a>
	        </form>
		</div>
		<!-- 导出 -->
		<form action="equipmentManageAction!test.action" method="post">
		<div class="table-content">
			<table class="table table-bordered">
	        	<thead>
	           		<tr>
	           		 <c:if test="${session.comHospital.isHead==0 }"> <!--  社区医院 -->
	           		    <th>社区集团</th>
	           		    <th>社区医院</th>
	           		 </c:if>
	           		 <c:if test="${session.communityHospitalGroup !=null}">   <!-- 集团 -->
	           		    <th>社区医院</th>
	           		 </c:if>
	             		<th>设备编号</th>
			            <th>设备名称</th>
			            <th>设备型号</th>
			            <th>设备采购人</th>
			            <th>采购时间</th>
			            <th>负责人</th>
			            <th>联系方式</th>
			            <th>维修记录</th>
			            <th>操作</th>
			            
		           </tr>
	         	</thead>
	         	<tbody>
	         	<s:iterator value="equipmentListTal" var="em">
	         	<!-- 导出 -->
	         	<input type="hidden" name="ids" value="${em.equipment.equipId }" />
					<tr>
					<c:if test="${session.comHospital.isHead==0 }"> <!--  社区医院 -->
					    <td>${em.communitygroup}</td>
					    <td>${em.communityHospital}</td>
					</c:if>
					<c:if test="${session.communityHospitalGroup !=null}">   <!-- 集团 -->
					     <td>${em.communityHospital}</td>
					</c:if>
	             		<td><span class="dspan">${em.equipment.equipNumber}</span></td>
	             		<td><span class="dspan">${em.equipment.equipName}</span></td>
	             		<td><span class="dspan">${em.equipment.equipModel}</span></td>
	             	    <td><span class="dspan">${em.equipment.equipPeople}</span></td>
	             		<td><fmt:formatDate value='${em.equipment.selectTime}' pattern='yyyy-MM-dd'/></td>
	             		<td>${em.equipment.TStaff.name}</td>
	             		<td>${em.equipment.contact}</td>
	             	    <td><a href="equipmentManageAction!getMaintenanceListById.action?equipmentManageId=${em.equipment.equipId}">查看</a></td>
	             		<td>
	             		<a class="btn-xiugai" href="equipmentManageAction!editEquipmentManage.action?equipmentManageId=${em.equipment.equipId}" >修改</a>
	             		<a onclick="return confirm('是否删除？');" class="btn-shanchu" href="equipmentManageAction!deleteEquipmentManage.action?equipmentManageId=${em.equipment.equipId}" >删除</a>
	             		<a class="btn-xianshi" href="equipmentManageAction!getEquipmentManageDetails.action?equipmentManageId=${em.equipment.equipId}" >详情</a>
	             		</td>
	           		</tr>
	           		</s:iterator>
	           	
				</tbody>
			</table>
			<!-- 导出 -->
			<input type="hidden" name="flag"  id="act" value=""/>
			<div class="sum-btn">
				<div class="page">
					${pageHtml}
		    	</div>
		    	<div class="btn-content2">
		          <input type="submit" class="btn btn-daochu"  value="导出全部"  onclick="run01()">
		          <input type="submit" class="btn btn-daochu"  value="导出本页"  onclick="run02()">
	            </div>
	         </div>
		</div>
		</form>
    </div>

    
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
</div>
<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<!-- 导出 -->
	<script>
    var Obtn01=document.getElementById("btn01");
    var Obtn02=document.getElementById("btn02");
    var Obtn03=document.getElementById("btn03");
    var Oact  =document.getElementById("act");
    function run01(){
        Oact.value=1;
    }
    function run02(){
        Oact.value=2;
    }
    function run03(){
        Oact.value=3;
    }
</script>
</body>
</html>
