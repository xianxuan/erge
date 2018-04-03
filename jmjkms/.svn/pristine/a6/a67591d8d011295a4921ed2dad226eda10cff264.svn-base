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
  <link rel="stylesheet" type="text/css" href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">
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
      <h3 class="current-title">维修记录</h3>
      
      <!-- 删除此行注释，在此添加对应的div -->
		
		<div class="table-content">
		<input name="yemianname"  value="09100" type="hidden"/>
	 <form action="equipmentManageAction!getMaintenanceListById.action" method="post" enctype="multipart/form-data"> 
		
			<table class="table table-bordered">
	        	<thead>
	           		<tr>
	             		<th>设备编号</th>
			            <th>设备名称</th>
			            <th>维修时间</th>
			            <th>设备问题</th>
			            <th>维修公司</th>
			            <th>维修费用</th>
			            <th>维修人员</th>
			            <th>状态</th>
			            <th class="caozuo">操作</th>
			            
		           </tr>
	         	</thead>
	         	<tbody>
	         	<s:iterator value="maintenanceList" var="ml">
					<tr>
	             		<td>${ml.TEquipmentManage.equipNumber}</td>
	             		<td>${ml.TEquipmentManage.equipName}</td>
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
	             		<td class="caozuo">
	             		<a class="btn-xiugai" href="equipmentManageAction!editMaintenance.action?equipmentManageId=${ml.TEquipmentManage.equipId}&manitenanceId=${ml.manitenanceId}" >修改</a>
	             		<a onclick="return confirm('是否删除？');" class="btn-shanchu"  href="equipmentManageAction!deletMaintenance.action?equipmentManageId=${ml.TEquipmentManage.equipId}&manitenanceId=${ml.manitenanceId}">删除</a>
	             		</td>
	           		</tr>
	           		</s:iterator>
	           	
				</tbody>
			</table>
             </form>
			<div class="page">
				${pageHtml}
	    	</div>
	    	<div class="btn-content">
	    	        <a class="btn btn-xinzeng" href="equipmentManageAction!addMaintence.action?equipmentManageId=${equipmentManageId}" >添加</a>	    	
                    <a class="btn" href="equipmentManageAction!getEquipmentManageListById.action?equipmentManageId=${equipmentManageId}" >返回</a>
                    <!-- <a href="javascript:;" class="btn btn-back">返回</a> -->                
                 </div>
		</div>
		
    </div>

    </div>
  <%-- <!-- 弹框 -->
  <div id="mask">
	<div id="demo">
					<h2 id="h2">添加</h2>
					<div id="fa"><i class="fa fa-close"></i></div>
		<div class="libox">
			<label>维修时间：</label>
        	<input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})">
        </div>
        <div class="libox">
        	<label>设备问题：</label>
			<input type="text" class="w150" id="input_1" class="input_1" placeholder=""></input>
		</div>
		 <div class="libox">
		<label>维修公司：</label>
		<input type="text"  class="w150"  id="input_2" class="input_1" placeholder=""></input>
		</div>
		<div class="libox">
		<label>维修费用：</label>
		<input type="text"  class="w150"   id="input_3" class="input_1" placeholder=""></input>
		</div>
		<div class="libox">
		<label>维修人员：</label>
		<input type="text"  class="w150"  id="input_3" class="input_1" placeholder=""></input>
		</div>
		<div class="libox">
		 <form action="">
		 <label>状态：</label>
        <select name="" id="status">
          <option value="">未解决</option>
          <option value="">已解决</option>
        </select>
        </form>
        </div>
		<input type="button" value='确定' class="btn" id="btn_1">
		<input type="button" value='取消' class="btn" id="btn_2">
	</div>
	</div> --%>

	<%-- <script type="text/javascript">
		var oMask=document.getElementById('mask');
		var oBtn_1=document.getElementById('btn_1');
		var oBtn_2=document.getElementById('btn_2');
		var oFa=document.getElementById('fa');
		var oBut_01=document.getElementById('but_01');
		var oBut_02=document.getElementById('but_02');
		var oH2=document.getElementById('h2');
		var oH1=document.getElementById('h1');
		window.onload=function(){
			//添加
				oBut_01.onclick=Dialog_01;
				function Dialog_01(){
					oMask.style.display="block";
					oH1.style.display="none";
					oH2.style.display="block";
				}
				oFa.onclick=dia;
				function dia(){
				     oMask.style.display="none";
				}
				oBtn_1.onclick=dia;
				function dia(){
				     oMask.style.display="none";
				}
				//修改
				oBut_02.onclick=Dialog_02;
				function Dialog_02(){
					oMask.style.display="block";
					oH2.style.display="none";
					oH1.style.display="block";
				}
				oFa.onclick=dia;
				function dia(){
				     oMask.style.display="none";
				}
				oBtn_2.onclick=dia;
				function dia(){
				     oMask.style.display="none";
				}
		}
	</script>
 --%>
  
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->

<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>

<script type="text/javascript">
	$(function(){
	var userId=${userId};
	 if(userId=='0'){
		$('.caozuo').remove();
	  }
	});
	
</script>
</body>
</html>
