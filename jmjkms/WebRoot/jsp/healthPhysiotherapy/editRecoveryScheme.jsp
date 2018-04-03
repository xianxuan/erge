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
		<input name="yemianname" value="04201" type="hidden"/>
			<h3 class="current-title">修改康复方案</h3>
			<!-- 搜索容器 start -->
			<form id="registerform"
				action="<%=basePath%>healthPhysiotherapyAction!editRecoveryScheme.action"
				method="post" enctype="multipart/form-data">
				<div class="table-content">
					<table class="table table-bordered">
						<tbody>
						<tr style="display:none;">
						<td><input type="hidden" class="w150"
									name="trecoveryScheme.recoverySchemeId"
									value="${trecoveryScheme.recoverySchemeId}"></td>
						</tr>
							<tr>
								<td><label>方案类型</label></td>
								<td><input type="hidden" class="w150"
									name="trecoveryScheme.type"
									value="${trecoveryScheme.type }"><label>个人方案</label></td>
							</tr>
							<tr>
								<td>方案名称</td>
								<td colspan="2"><input type="text" class="w150"
									name="trecoveryScheme.schemeName"datatype="*" nullmsg="不可为空" errormsg="输入有误"
									value="${trecoveryScheme.schemeName }"></td>
							</tr>
							<tr>
								<td><label>疾病类型</label></td>
								<td><select name="trecoveryScheme.disease" id="disease">
										
											<option value="残疾障碍" >残疾障碍</option>
										
											<option value="高血压" >高血压</option>
										
									
											<option value="糖尿病" >糖尿病</option>
									
								
											<option value="重性精神疾病" >重性精神疾病</option>
								
								
											<option value="冠心病" >冠心病</option>
								
									
											<option value="心脑血管病" >心脑血管病</option>
								
								
											<option value="肿瘤" >肿瘤</option>
										
										
											<option value="慢性支气管" >慢性支气管</option>
									
								</select></td>
							</tr>
							<tr>
								<td><label>方案制定人</label></td>
								<td><select name="select" id="">
										<s:iterator value="staffHosList" var="list">
											<s:if test="#list.staffId==trecoveryScheme.TStaff.staffId">
												<option value="${list.staffId}"  selected = "selected" >${list.name}</option>
											</s:if>
											<s:else>
											    <option value="${list.staffId}">${list.name}</option>
											</s:else>
										</s:iterator>
								</select></td>
							</tr>
							<tr>
								<td><label>制定日期</label></td>
								<td><input type="text"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"
									name="trecoveryScheme.constituteTime" value="${trecoveryScheme.constituteTime }"></td>
							</tr>
							<tr>
								<td><label>详细康复方案</label></td>
								<td><textarea name="trecoveryScheme.recoveryPaln" id=""
										class="textarea" value="#trecoveryScheme.recoveryPaln ">${trecoveryScheme.recoveryPaln }</textarea></td>
							</tr>
						</tbody>
					</table>
					<div class="btn-content">
						<input type="submit" class="btn" name="submit" id="submit" value="确定">
						<a href="<%=basePath %>healthPhysiotherapyAction.action" class="btn">取消</a>
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
	<script src="/jmjkms/jeasyui/jquery.easyui.min.js"></script>
	<script  type="text/javascript">
	$(function () {
				setSelectChecked()
		});
	function setSelectChecked(){  
    var select = document.getElementById("disease");  
    for(var i=0; i<select.options.length; i++){  
        if(select.options[i].innerHTML == "${trecoveryScheme.disease}"){  
            select.options[i].selected = true;  
            break;  
        }  
    }  
};  
	
	</script>
	<script type="text/javascript" src="/jmjkms/js/confirm/jquery-1.9.1.min.js"></script>
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
</body>
</html>
