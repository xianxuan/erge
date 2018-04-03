<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head><meta name="viewport" content="width=device-width, initial-scale=1.0"><meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta charset="UTF-8">
<c:choose><c:when test="${session.comHospital.isHead==0}"><title>中电科社区健康管理平台</title></c:when><c:when test="${session.communityHospitalGroup!=null}"><title>社区健康管理系统</title></c:when><c:otherwise><title>社区健康服务站</title></c:otherwise></c:choose>
<link rel="stylesheet" href="/jmjkms/css/cssreset.css">
<link rel="stylesheet" href="/jmjkms/select2/css/select2.css">
<link rel="stylesheet" href="/jmjkms/css/main.css">
<link rel="stylesheet"
	href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">
<link type="text/css" href="/jmjkms/css/confirm.css">

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
			<input name="yemianname" value="04201" type="hidden" />
			<h3 class="current-title">添加康复方案</h3>
			<!-- 搜索容器 start -->
			<form id="registerform"
				action="<%=basePath%>healthPhysiotherapyAction!addRecoveryScheme.action"
				method="post" onsubmit="return dosubmit()" enctype="multipart/form-data">
				<input type="hidden" name="token" value="${token }" />
				<div class="table-content">
					<table class="table table-bordered">
						<tbody>
							<tr>
								<td><span class="required">*</span><label>方案类型</label></td>
								<td><input  type="hidden" class="w150" id="type"
									name="trecoveryScheme.type" value="个人方案">个人方案
								</td>
							</tr>
							<tr>
								<td><span class="required">*</span>方案名称</td>
								<td colspan="2"><input   type="text" id="scheme" class="w150"
									name="trecoveryScheme.schemeName"
									value="${trecoveryScheme.schemeName }"nullmsg="方案名称不可为空" datatype="*"maxlength="15">
								</td>
							</tr>
							<tr>
								<td><span class="required">*</span><label>疾病类型</label></td>
								<td><select name="trecoveryScheme.disease" id="diseasetype">
										<s:iterator value="diseaseList" var="list">
											<s:if test="#list==trecoveryScheme.disease">
												<option value="${list }" selected="selected">${list }</option>
											</s:if>
											<s:else>
												<option value="${list}">${list }</option>
											</s:else>
										</s:iterator>
								</select>
								</td>
							</tr>
							<tr>
								<td><span class="required">*</span><label>方案制定人</label></td>
								<td>
								<c:if test="${staffRe==null}">
								<select name="select" class="js-example-basic-single"
									class="select2" style="width: 170px;"id="people"
									>
										<s:iterator value="staffHosList" var="list">
											<s:if test="#list.staffId==plan.TStaff.staffId">
												<%-- <option value="${list.staffId}" selected="selected">${list.name}</option> --%>
											<option value="${list.staffId}" <c:if test="${session.tstaff!=null}&&${session.tstaff.staffId eq list.staffId}">selected</c:if>>${list.name}</option>	
											</s:if>
											<s:else>
												<%-- <option value="${list.staffId}">${list.name}</option> --%>
												<option value="${list.staffId}" <c:if test="${tstaff.staffId eq list.staffId}">selected</c:if>>${list.name}</option>
											</s:else>
										</s:iterator>
								</select>
								</c:if>
								<c:if test="${staffRe!=null}">
								<label>${staffRe.name }</label>
								</c:if>
							</td>
							</tr>
							
							<tr>
								<td><span class="required">*</span><label>详细康复方案</label></td>
								<td><textarea name="trecoveryScheme.recoveryPaln" id="dtext"class="textarea" nullmsg="详细康复方案不可为空" datatype="*">${trecoveryScheme.recoveryPaln}</textarea>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="btn-content">
						<input type="submit" class="btn" name="submit" id="submit"
							value="保存">
					
					 <a href="javascript:;" class="btn btn-back">返回</a>
					
					</div>
				</div>
			</form>
			<!-- 表格容器 end -->
		</div>
		<!-- 主容器 end -->
		<!-- 底栏 Start-->
		<s:include value="/include/footer.jsp" />
		<!-- 底栏 Start-->

		<!-- <div class="tan-box" id="tan-one">
			<p>康复方案重名!</p>
			<br>
			<br>
			<br> <a href="javascript:;" onclick="$('#scheme').focus();"
				class="btn">确定</a>
		</div> -->
	</div>

	<script type="text/javascript"  src="/jmjkms/js/confirm/jquery-1.9.1.min.js"></script>  
	<script type="text/javascript"  src="/jmjkms/js/confirm/Validform_v5.3.2_min.js"></script> 
	<script src="/jmjkms/js/laydate/laydate.js"></script>
	<script src="/jmjkms/js/base.js"></script>
	<script src="/jmjkms/select2/js/select2.full.js"></script>
	<script type="text/javascript">
	$(function(){
		//可输可选
	
		$(".js-example-basic-single").select2();

		//康复方案判重
		<%-- $("#scheme").blur(function(){
	
	
			$.ajax({
			type : "POST",
	        url:"<%=basePath%>healthPhysiotherapyAction!checkScheme.action?schemeString="
													+ $("#scheme").val(),
											success : function(json) {
												if (json != "") {
													$("#submit").hide();
													$("#quxiao").hide();
													$("#tan-one").show();
												}
											}
										});

							});
			//关闭重名时弹框
			$("#tan-one a").click(function() {
				$("#tan-one").hide();
				$("#submit").show();
				$("#quxiao").show();
			});
			});
 --%>
	</script>
	
	<!--  防止表单提交 -->
    <script type="text/javascript">
       var isCommitted = false;//表单是否已经提交标识，默认为false
       function dosubmit() {
           /* 此处还需要判断各个必填项校验是否通过*/
           //alert("1" + isCommitted);
           if (isCommitted == false
                  && document.getElementById('type').value != ""
                  && document.getElementById('scheme').value != ""
                  && document.getElementById('diseasetype').value != ""
                 && document.getElementById('people').value != ""
                  && document.getElementById('dtext').value != ""
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
    </script>
    
	<script type="text/javascript">
    $(function(){
      $("#registerform").Validform({
        showAllError:false,
        tiptype:function(msg){          
          alert(msg);
        }
      });
   <%--   $("#submit").click(function(){
      			var jiaoyan="";
      			$.ajax({
			type : "POST",
	        url:"<%=basePath%>healthPhysiotherapyAction!checkScheme.action?schemeString="
													+ $("#scheme").val(),
											success : function(json) {
												if (json != "") {
													jiaoyan=" ";
													$("#submit").hide();
													$("#quxiao").hide();
													$("#tan-one").show();
													
												}
											}
										});
				if(jiaoyan==" "){
						return false;
					}
					else{
						return true;
					}
										
      });
      }); --%>
  
	</script>
	
</body>
</html>
