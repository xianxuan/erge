<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head><meta name="viewport" content="width=device-width, initial-scale=1.0"><meta http-equiv="X-UA-Compatible" content="ie=edge">

<meta charset="UTF-8">
<c:choose><c:when test="${session.comHospital.isHead==0}"><title>中电科社区健康管理平台</title></c:when><c:when test="${session.communityHospitalGroup!=null}"><title>社区健康管理系统</title></c:when><c:otherwise><title>社区健康服务站</title></c:otherwise></c:choose>
<link rel="stylesheet" href="css/cssreset.css">
<link rel="stylesheet" href="css/main.css">
 <link type="text/css" href="/jmjkms/css/confirm.css">
 <link rel="stylesheet" href="/jmjkms/select2/css/select2.css">
 <link rel="stylesheet" type="text/css" href="css/sweetalert.css"> 
 <script src="js/sweetalert.min.js"></script> 
 <style type="text/css">  
.blur {  
    border: 1px solid red;  
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
			<h3 class="current-title">医师健康建议 </h3>
	 		<%--  <a href="javascript:;" class="btn btn-xinzeng"  onclick="addSuggest('${healthFile.id}')">添加建议</a> --%>
			
			<input name="yemianname" value="02202" type="hidden" />
			<!-- 表格容器 start -->
			<div class="table-content">
				<table class="table table-bordered">
					<thead>
						<tr>
							<th>姓名</th>
							<th>身份证号</th>
							<th>责任医生</th>
							<th>建议日期</th>
							<th>建议内容</th>
							<th>删除</th>
							<th>修改</th>
						</tr>
					</thead>
					<tbody>
					<s:iterator value="suggestList" var="sl">
						<tr>
							<td>${sl.userName}</td>
							<td>${sl.idNum}</td>
							<td>${sl.doctorName}</td>
							<td>${sl.createTime}</td>
						    <td><a class="btn-xianshi" href="HealthManagerAction!jumpHealthAdviceInfo.action?userName=${sl.userName}&doctorName=${sl.doctorName}&wenti=${sl.problem }&doctorAdvice=${sl.doctorAdvice}&createTime=${sl.createTime}">详情</a>
							<td><a class="btn-shanchu" onclick="return confirm('是否删除？');" href="HealthManagerAction!deleteSuggests.action?id=${sl.id}&healthFileId=${healthFile.id}&userId=${userId}">删除</a></td>
<td><a href="HealthManagerAction!jumpEditHealthAdvice.action?suggestId=${sl.id}&userId=${sl.userId}&userName=${sl.userName}&doctorId=${sl.doctorId}&healthFileId=${healthFile.id }&belongSystem=${sl.belongSystem }&wenti=${sl.problem }&doctorAdvice=${sl.doctorAdvice}&createTime=${sl.createTime}" class="btn-xiugai" >修改</a>
				        </td>			<%-- onclick="editSuggest('${sl.id}','${sl.userName}','${sl.idNum}','${sl.doctorName}','${sl.doctorId}','${healthFile.id }','${sl.userId}','${sl.belongSystem }','${sl.problem }','${sl.doctorAdvice}')">修改建议</a> --%>
						</tr>
                    </s:iterator>
					</tbody>
				</table>
				
				<!-- 分页 Start -->
				<div class="page">
					${pageHtml}
				</div>
				 <div class="btn-content">
           <a href="HealthDailyCheckAction!getHealthFileList.action" class="btn btn-xianshi">返回</a>
        </div>
				<!-- 分页 end -->
			</div>
			<!-- 表格容器 end -->
		</div>
		<!-- 主容器 end -->
		<!-- 底栏 Start-->
		<s:include value="/include/footer.jsp" />
		<!-- 底栏 Start-->
	</div>


<%-- <script src="/jmjkms/js/jquery-2.1.1.min.js"></script> --%>
<!-- 3级联动 -->
<script type="text/javascript" src="/jmjkms/js/threecity/jq.js"></script>  
<script type="text/javascript" src="/jmjkms/js/threecity/jquery.cityselect.js"></script>
<script type="text/javascript" src="/jmjkms/js/threecity/location.js"></script>
<!-- 3级联动 -->
<script src="/jmjkms/select2/js/select2.full.js"></script>
<script type="text/javascript" src="/jmjkms/js/base.js"></script>
<script type="text/javascript" src="/jmjkms/js/laydate/laydate.js"></script>
<script type="text/javascript" src="/jmjkms/js/confirm/Validform_v5.3.2_min.js"></script>
 <script type="text/javascript">
function alertSuggest(wenti,doctorAdvice){
	swal({  
                title: "医师建议", 
                text: "现存主要健康问题：<label>"+wenti+"</label><br>指导意见：<label>"+doctorAdvice+"</label>",
                //text :'<lable>现存主要健康问题:</lable><input id="wenti" type="text"/><lable>指导意见</lable><input id="zhidaoyijian" type="text"/>',
                html:true,
                //text : message,
                type: "info",  
                showCancelButton: false,  
                showConfirmButton:true,
                confirmButtonColor:"#fc7c00",  
                animation: "slide-from-top",
                }
      );
}
</script>
<script type="text/javascript">
 
/*  alertMessage('${message}');
 
 function alertMessage(message){
      if(message !== ""){
      	 swal({  
               title: message, 
               type: "info",  
               showCancelButton: false,  
               showConfirmButton:true,  
               animation: "slide-from-top",  
               });
      }
  }
 
  */
 
 function editSuggest(id,userName,idNum,doctorName,doctorId,healthFileId,userId,belongSystem,wenti,doctorAdvice){
 		var wenti=wenti;
		swal({  
	                /* title: "修改建议", 
	                text :"请在此添加您要修改的建议",
	                input: "text", */
	                title: "修改建议", 
	                html:true, 
       				//text: "原数据项为：<label>"+ss+"</label><br><br>数据项修改为：", 
       				text :'<lable>现存主要健康问题:</lable><input id="wenti" type="text" /><lable>指导意见:</lable><input id="zhidaoyijian"  type="text"/>',       
       				type: "input", 
					showCancelButton: true, 
       				confirmButtonColor:"#fc7c00",
   	   				cancelButtonText: "取消",
   	   				animation: "slide-from-top", 
       				confirmButtonText: "保存",
       				inputPlaceholder: ""   
	          },function(inputValue){
	          		//var saveDataAry=[];
	          		//var suggestJson={"id":id,"userName":userName,"doctorId":"doctotId"
	          		//	,"idNum":"idNum","doctorName":"doctorName","belongSystem":"belongSystem","doctorAdvice":"doctorAdvice"}
	          		//saveDataAry.push(suggestJson);
	               //var value = $("input[tabindex='3']").val();
	               var zhidaoyijian=$("#zhidaoyijian").val();
	               $.ajax({
						type : "post",
						url : "HealthManagerAction!editSuggest.action",
						dataType: "json",
						 data: {
							suggestId:id,
							healthFileId:healthFileId,
							userId:userId,
							doctorAdvice:zhidaoyijian,
							wenti:inputValue
						}, 
						success : function(data) {
						    var message;
						    var type;
							if(data != null){
							if(data=="quxiao"){}
							else{
								message = data.message;
								type="success";
								swal({  
					                title: message, 
					                type: type,  
					                showCancelButton: false,  
					                showConfirmButton:true,
					                confirmButtonColor:"#fc7c00",  
					                animation: "slide-from-top",  
					          });
						url="HealthManagerAction!getSuggests.action?userId="+userId+"&healthFileId="+healthFileId;
			    	 	window.location.href=url;
			    	 }
					}else{
							  message = "未能修改数据！！";
							  alert("健康建议不能为空")
							  type="error";
							}
						}
		            });
	          }
	      );
	}
 </script>
</body>
</html>
