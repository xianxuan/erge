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
<link rel="stylesheet" href="/jmjkms/css/main.css">
 <link rel="stylesheet" href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">
<link type="text/css" href="/jmjkms/css/confirm.css">
<link rel="stylesheet" href="/jmjkms/select2/css/select2.css">
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
		<input name="yemianname" value="10202" type="hidden"/>
			<h3 class="current-title">添加专家康复方案</h3>
			<!-- 搜索容器 start -->
			<form id="registerform" action="<%=basePath%>healthPhysiotherapyAction!addExpertScheme.action" 
			    method="post"   onsubmit="return dosubmit()"enctype="multipart/form-data">
	
			    <input type="hidden" name="token" value="${token }" />
				<div class="table-content">
					<table class="table table-bordered">
						<tbody>
						<input type="hidden" name="zhuanjia" value="${zhuanjia }" />
							<tr>
								<td><span class="required">*</span><label>方案类型</label></td>
								
								<td>
									<c:if test="${'0' eq zhuanjia}">
										<input type="text" class="w150" readOnly="true"
									id="recoverSType"	name="trecoveryScheme.type" value="推荐方案">
									</c:if>
									<c:if test="${'1' eq zhuanjia}">
									<input type="text" class="w150" readOnly="true"
									id="recoverSType"	name="trecoveryScheme.type" value="专家方案">
									</c:if>
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
							</tr>
							
							<tr>
								<td><span class="required">*</span><label>详细康复方案</label></td>
								<td><textarea name="trecoveryScheme.recoveryPaln" id="dtext"class="textarea"nullmsg="详细方案不可为空" datatype="*">${trecoveryScheme.recoveryPaln }</textarea>
							</tr>
						</tbody>
					</table>
					<div class="btn-content">
						<input type="submit" class="btn" name="submit" id="submit" value="确定">
						<a id="quxiao"  href="<%=basePath %>healthPhysiotherapyAction!getExpertScheme.action" class="btn">取消</a>
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
	<!-- <div class="tan-box"   id="tan-one">
			<p>康复方案重名!</p><br><br><br>
			<a href="javascript:;" onclick="$('#scheme').focus();" class="btn">确定</a>
		</div>
 -->
	<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
	<script src="/jmjkms/js/laydate/laydate.js"></script>
	<script src="/jmjkms/js/base.js"></script>
	<script type="text/javascript" src="/jmjkms/js/confirm/Validform_v5.3.2_min.js"></script>
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

	<script src="/jmjkms/select2/js/select2.full.js"></script>
	<!--  防止表单提交 -->
    <script type="text/javascript">
       var isCommitted = false;//表单是否已经提交标识，默认为false
       function dosubmit() {
           /* 此处还需要判断各个必填项校验是否通过*/
           //alert("1" + isCommitted);
           if (isCommitted == false
                  && document.getElementById('recoverSType').value != ""
                  && document.getElementById('scheme').value != ""
                  && document.getElementById('diseasetype').value != ""
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
	<%--  $("#submit").click(function(){
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
   --%>
   <%--  $(function(){
      $("#scheme").blur(function(){
	
			$.ajax({
			type : "POST",
	        url:"<%=basePath%>healthPhysiotherapyAction!checkScheme.action?schemeString="
								+ $("#scheme").val(),
						success : function(json) {
				
												if(json!="")
												{
												$("#submit").hide();
												$("#quxiao").hide();
												$("#tan-one").show();
												}
						}
		});
		
	});
	$("#tan-one a").click(function(){
			$("#tan-one").hide();
			$("#submit").show();
				$("#quxiao").show();
		});
  }); --%>
  
	</script>
</body>
</html>
