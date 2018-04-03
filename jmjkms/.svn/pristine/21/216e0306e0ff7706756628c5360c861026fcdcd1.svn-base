<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ page import="java.text.*"%>
<%
    String currentTime = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); //获取系统时间 
			application.setAttribute("currentTime", currentTime);
%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head><meta name="viewport" content="width=device-width, initial-scale=1.0"><meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta charset="UTF-8">
<c:choose><c:when test="${session.comHospital.isHead==0}"><title>中电科社区健康管理平台</title></c:when><c:when test="${session.communityHospitalGroup!=null}"><title>社区健康管理系统</title></c:when><c:otherwise><title>社区健康服务站</title></c:otherwise></c:choose>

<link rel="stylesheet"  href="/jmjkms/css/cssreset.css">
<link rel="stylesheet"  href="/jmjkms/css/main.css">
<link rel="stylesheet" href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">
<link type="text/css" href="/jmjkms/css/confirm.css">
<link rel="stylesheet" href="/jmjkms/select2/css/select2.css">
</head>
<body>
	<!-- 顶栏 start -->
	<s:include value="/include/header.jsp" />
	<!-- 顶栏 end -->
	<div class="main-content clearfix">
	<input name="yemianname" value="02205" type="hidden"/>
		<!-- 主菜单 start -->
		<s:include value="/include/nav.jsp" />
		<!-- 主菜单 end -->
		<!-- 主容器 start -->
		<div class="container">
			<h3 class="current-title">糖尿病康复计划添加</h3>

			<!-- 搜索容器 start -->
			<form id="registerform" action="<%=basePath%>chronicManagerAction!addPlan.action"
				method="post" enctype="multipart/form-data" onsubmit="dosubmit()">
				<input type="hidden" name="token" value="${token }" />
				<input id="current" type="hidden" value="${currentTime }">
				<input type="hidden" value="${chronicId }" name="chronicId">
				<input type="hidden" id="hiddenDiseaseName" value="${vchronic.diseaseName }" name="chronicName">
				<div class="table-content">
					<table class="table table-bordered">
						<tbody>
						<tr>
								<td><label>疾病名称:</label></td>
								<td>
									&nbsp${vchronic.diseaseName }
								</td>
						 </tr>
							<tr>
							<td><span class="required">*</span>计划名称:</td>
								<td colspan="2">
								<input   maxlength='20' id="planName" type="text" class="w150 temp"
								  	name="planName" value="${planName}" datatype="*" nullmsg="计划名称不可为空">
								<span id="nameTip"  style="color: red;"></span>
							</td>
							  </tr>
							<tr>
								<td><label><span class="required">*</span>方案类型:</label></td>
								<td>
									<select name="type" id="type">
										<option value="个人方案">个人方案</option>
										<option value="专家方案">专家方案</option>
										<option value="推荐方案">推荐方案</option>
									</select>
								</td>
							</tr>
							<tr>
								<td><label><span class="required">*</span>方案名称:</label></td>
								<td>
								<select name="scheme" id="scheme">
								   </select></td>
							</tr>
							<tr>
								<td><label><span class="required">*</span>开始日期:</label></td>
								<td><input type="text" onfocus="this.blur()"
									value="${currentTime }"
								    id="startTime"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"
									name="plan.beginTime"></td>
							</tr>
							<tr>
								<td><span class="required">*</span><label>结束日期:</label></td>
								<td><input type="text" onfocus="this.blur()"
								
								    id="endTime"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"
									name="plan.overTime"></td>
							</tr>

							<tr>
								<td><label><span class="required">*</span>制定人:</label></td>
								<td>
									<c:if test="${flag==false}">
										
										<select name="select"  id="people"  class="js-example-basic-single"  class="select2"  style="width: 170px;">
											<s:iterator value="staffHosList" var="list">
												<%-- <option value="${list.staffId}" selected="selected">${list.name}</option> --%>
											<option value="${list.staffId}" <c:if test="${session.comHospital.name eq list.name}">selected</c:if>>${list.name}</option>	
											
										</s:iterator>
										</select>
									</c:if>
								
									<c:if test="${flag==true}">
									<label>${session.tstaff.name }</label>
									<input type="hidden" name="TRecoveryPlan.TStaff.name">
									</c:if>
								</td>
							</tr>
							<tr>
								<td><label><span class="required">*</span>制定日期:</label></td>
								<td><input type="text" id="constituteTime" onfocus="this.blur()"
									value="${currentTime }"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"
									name="plan.constituteTime"></td>
							</tr>
							<tr>
								<td><label><span class="required">*</span>详细康复计划:</label></td>
								<td><textarea name="plan.planContent" id="planContent"
										class="textarea" datatype="*" nullmsg="计划不可为空"></textarea>
										<span id="plancontentTip"></span>
										</td>
								</tr>
						</tbody>
					</table>
					<div class="btn-content">
						<input type="submit"  class="btn"  name="submit"  id="submit"  value="确定">
						  <a href="javascript:;" class="btn btn-back">取消</a>
					</div>
				</div>
			</form>
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
	
	<script src="/jmjkms/select2/js/select2.full.js"></script>
  <%--  <script type="text/javascript" src="/jmjkms/js/confirm/jquery-1.9.1.min.js"></script> --%>
	<script type="text/javascript" src="/jmjkms/js/confirm/Validform_v5.3.2_min.js"></script>
	<script src="/jmjkms/js/recovery.js"></script>
<script type="text/javascript">
    $(function(){
      $("#registerform").Validform({
        showAllError:false,
        tiptype:function(msg){          
          alert(msg);
        }
      });
  	});
	</script>
<script type="text/javascript">
	$(function () {
		$(".js-example-basic-single").select2();
		schemeShow();
		$("#type").change(function(){
			$("#scheme").find("option").remove()
			schemeShow();
		});			
		function schemeShow (){
			var hiddenDiseaseName=$("#hiddenDiseaseName").val();
			$.ajax({
				type : "POST",
				url:"<%=basePath%>chronicManagerAction!jsonChuan.action",
					dataType : "json",
					data:{
						data:hiddenDiseaseName,
						type:$("#type").val()
					},
					success : function(json)
					{
						$("#scheme").append("<option value='"+1+"'></option>");
						$("#scheme").empty();
						for (var i = 0; i < json.length; i++){
							$("#scheme").append("<option value='"+json[i].value+"'>"+json[i].text+"</option>");
						}
					}
			});
		};
		});	
 </script>
<script type="text/javascript">
	$("form").submit(function(){
				
				var planNameVal = $("#planName").val();
				$.ajax({
				type : "POST",
		        url:"<%=basePath%>chronicManagerAction!checkPlan.action",
				data:{
					planName:planNameVal
				},
				success : function(jsons)
				 {
					if(jsons==""){
						return true;
					}
					else{
						alert("康复计划重名")
						return false;
					}
				}
				});
				
			});

</script>
<script type="text/javascript">
 $("form").submit(function(){
    	var startTime0=$("#startTime").val();
    	var endTime0=$("#endTime").val();
    	if(startTime0 != ""&&endTime0 != ""){
    	if(startTime0<$("#current").val()){
    		alert("开始日期小于当前日期");
    		return false;
    	}
    	if(startTime0>endTime0){
      	 	$("#endTime").val("").focus();
       		$("#endTime").val("");
       		alert("结束日期小于当前日期");
       		return false;
       	}
       	}
      if(startTime0==""){
      		$("#startTime").val("").focus();
      		alert("开始日期不能为空!");
      		return false;
      	}
      	if(endTime0==""){
      		$("#endTime").val("").focus();
      		alert("结束日期不能为空！");
      		return false;
      	}
      	if($("#constituteTime").val()==""){
      		$("#constituteTime").val("").focus();
      		alert("制定日期不能为空");
      		return false;
      	}
    })
</script>
<%-- <!--  防止表单提交 -->
	<script type="text/javascript">
		var isCommitted = false;//表单是否已经提交标识，默认为false
		function dosubmit() {
			/* 此处还需要判断各个必填项校验是否通过*/
			//alert("1" + isCommitted);
			if (isCommitted == false
					&& document.getElementById('planName').value != ""
					&& document.getElementById('startTime').value != ""
					&& document.getElementById('endTime').value != ""
					&& document.getElementById('constituteTime').value != ""
					 && document.getElementById('planContent').value != ""
			) {
				//提交表单后，将表单是否已经提交标识设置为true
				isCommitted = true;

			//获取表单提交按钮
		    var btnSubmit = document.getElementById("submit");
   			//将表单提交按钮设置为不可用，这样就可以避免用户再次点击提交按钮
   			btnSubmit.disabled= "disabled";
			return true;//返回true让表单正常提交
			} else {
				return false;//返回false那么表单将不提交
			}
		}
	</script> --%>
</body>
</html>
