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
<link rel="stylesheet" type="text/css"
	href="/jmjkms/jeasyui/themes/icon.css" />
<link rel="stylesheet" type="text/css"
	href="/jmjkms/jeasyui/themes/gray/easyui.css" />
	 <link rel="stylesheet" href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">
<link type="text/css" href="/jmjkms/css/confirm.css">
</head>
<body>
	<!-- 顶栏 start -->
	<s:include value="/include/header.jsp" />
	<!-- 顶栏 end -->
	<div class="main-content clearfix">
	<input name="yemianname" value="04202" type="hidden"/>
		<!-- 主菜单 start -->
		<s:include value="/include/nav.jsp" />
		<!-- 主菜单 end -->
		<!-- 主容器 start -->
		<div class="container">
			<h3 class="current-title">修改康复计划</h3>

			<!-- 搜索容器 start -->
			<form id="registerform"
				action="<%=basePath%>healthPhysiotherapyAction!editRecoveryPlan.action"
				method="post" enctype="multipart/form-data">
				<div class="table-content">
					<table class="table table-bordered">
						<tbody>
						<tr>
						<td><input type="hidden" class="w150"
									name="plan.recoveryPlanId"
									value="${plan.recoveryPlanId}"></td>
						</tr>
							<tr>
								<td>计划名称</td>
								<td colspan="2"><input type="text" class="w150"
									name="plan.planName" value="${plan.planName }" datatype="*" nullmsg="不可为空"></td>
							</tr>
							<tr>
								<td><label>方案类型</label></td>
								<td><select name="type" id="type"
									data-options="onSelect:schemeShow" class="easyui-combobox">
										<s:if test="plan.TRecoveryScheme.type=='个人方案'">
											<option value="专家方案">专家方案</option>
											<option value="个人方案" selected="selected">个人方案</option>
										</s:if>
										<s:if test="plan.TRecoveryScheme.type=='专家方案'">
											<option value="专家方案" selected="selected">专家方案</option>
											<option value="个人方案">个人方案</option>
										</s:if>
								</select></td>
							</tr>
							<tr>
								<td><label>疾病名称</label></td>
								<td><select name="disease" id="disease"
									data-options="onSelect:tan" class="easyui-combobox">
										<s:if test="plan.TRecoveryScheme.disease=='残疾障碍'">
											<option value="残疾障碍"selected="selected">残疾障碍</option>
											<option value="高血压" >高血压</option>
											<option value="糖尿病">糖尿病</option>
											<option value="重性精神疾病">重性精神疾病</option>
											<option value="冠心病">冠心病</option>
											<option value="心脑血管病">心脑血管病</option>
											<option value="肿瘤">肿瘤</option>
											<option value="慢性支气管">慢性支气管</option>
										</s:if> 
										<s:if test="plan.TRecoveryScheme.disease=='高血压'">
											<option value="残疾障碍">残疾障碍</option>
											<option value="高血压" selected="selected">高血压</option>
											<option value="糖尿病">糖尿病</option>
											<option value="重性精神疾病">重性精神疾病</option>
											<option value="冠心病">冠心病</option>
											<option value="心脑血管病">心脑血管病</option>
											<option value="肿瘤">肿瘤</option>
											<option value="慢性支气管">慢性支气管</option>
										</s:if> 
										<s:if test="plan.TRecoveryScheme.disease=='糖尿病'">
											<option value="残疾障碍">残疾障碍</option>
											<option value="高血压" >高血压</option>
											<option value="糖尿病"selected="selected">糖尿病</option>
											<option value="重性精神疾病">重性精神疾病</option>
											<option value="冠心病">冠心病</option>
											<option value="心脑血管病">心脑血管病</option>
											<option value="肿瘤">肿瘤</option>
											<option value="慢性支气管">慢性支气管</option>
										</s:if> 
										<s:if test="plan.TRecoveryScheme.disease=='重性精神疾病'">
											<option value="残疾障碍">残疾障碍</option>
											<option value="高血压" >高血压</option>
											<option value="糖尿病">糖尿病</option>
											<option value="重性精神疾病"selected="selected">重性精神疾病</option>
											<option value="冠心病">冠心病</option>
											<option value="心脑血管病">心脑血管病</option>
											<option value="肿瘤">肿瘤</option>
											<option value="慢性支气管">慢性支气管</option>
										</s:if> 
										<s:if test="plan.TRecoveryScheme.disease=='冠心病'">
											<option value="残疾障碍">残疾障碍</option>
											<option value="高血压" >高血压</option>
											<option value="糖尿病">糖尿病</option>
											<option value="重性精神疾病">重性精神疾病</option>
											<option value="冠心病"selected="selected">冠心病</option>
											<option value="心脑血管病">心脑血管病</option>
											<option value="肿瘤">肿瘤</option>
											<option value="慢性支气管">慢性支气管</option>
										</s:if> 
										<s:if test="plan.TRecoveryScheme.disease=='心脑血管病'">
											<option value="残疾障碍">残疾障碍</option>
											<option value="高血压" >高血压</option>
											<option value="糖尿病">糖尿病</option>
											<option value="重性精神疾病">重性精神疾病</option>
											<option value="冠心病">冠心病</option>
											<option value="心脑血管病"selected="selected">心脑血管病</option>
											<option value="肿瘤">肿瘤</option>
											<option value="慢性支气管">慢性支气管</option>
										</s:if> 
										<s:if test="plan.TRecoveryScheme.disease=='肿瘤'">
											<option value="残疾障碍">残疾障碍</option>
											<option value="高血压" >高血压</option>
											<option value="糖尿病">糖尿病</option>
											<option value="重性精神疾病">重性精神疾病</option>
											<option value="冠心病">冠心病</option>
											<option value="心脑血管病">心脑血管病</option>
											<option value="肿瘤"selected="selected">肿瘤</option>
											<option value="慢性支气管">慢性支气管</option>
										</s:if> 
										<s:if test="plan.TRecoveryScheme.disease=='慢性支气管'">
											<option value="残疾障碍">残疾障碍</option>
											<option value="高血压" >高血压</option>
											<option value="糖尿病">糖尿病</option>
											<option value="重性精神疾病">重性精神疾病</option>
											<option value="冠心病">冠心病</option>
											<option value="心脑血管病">心脑血管病</option>
											<option value="肿瘤">肿瘤</option>
											<option value="慢性支气管"selected="selected">慢性支气管</option>
										</s:if> 
										
										</select></td> </tr>
									 <tr> <td><label>方案名称</label></td>
										<td id="xian"><select name="schemeString" id="fangan">
										<option value="${plan.TRecoveryScheme.schemeName }">${plan.TRecoveryScheme.schemeName }</option>
								     	<option value=""></option>
								     
								     </select></td>
								      <td id="yin"><select name="scheme" id="scheme"
									class="easyui-combobox"
									data-options="valueField:'value',textField:'text'">
										<option value="">请选择</option>
								</select></td>
							</tr>
							<tr>
								<td><label>老人：</label></td>
								<td>
									<div id="add"></div>
								</td>
							</tr>
							<tr>
								<td><label>开始日期：</label></td>
								<td><input type="text"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"
									name="plan.beginTime" value="${plan.beginTime }"
									datatype="*" nullmsg="时间不可为空"></td>
							</tr>
							<tr>
								<td><label>结束日期：</label></td>
								<td><input type="text"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"
									name="plan.overTime" value="${plan.overTime }"
									datatype="*" nullmsg="时间不可为空"></td>
							</tr>

							<tr>
								<td><label>制定人</label></td>
								<td><select name="select" id="">
										<s:iterator value="staffHosList" var="list">
											<s:if test="#list.staffId==plan.TStaff.staffId">
												<option value="${list.staffId}" selected="selected">${list.name}</option>
											</s:if>
											<s:else>
												<option value="${list.staffId}">${list.name}</option>
											</s:else>
										</s:iterator>
							</tr>
							<tr>
								<td><label>制定日期</label></td>
								<td><input type="text"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"
									name="plan.constituteTime" value="${plan.constituteTime }">
								</td>
							</tr>
							<tr>
								<td><label>详细康复计划</label></td>
								<td><textarea name="plan.planContent" id=""
										class="textarea">${plan.planContent }</textarea></td>
							</tr>

						</tbody>
					</table>
					<div class="btn-content">
						<input type="submit" class="btn" name="submit" id="submit" value="确定"> <a
							href="healthPhysiotherapyAction!getAllPlan.action" class="btn">取消</a>
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
	<script type="text/javascript">			
		$("#fangan").click (function(){
			fangan()
		});
		$(function () {  
			$("#xian").show();
			$("#yin").hide();
			
			schemeShow();
		
			$('#type').change(
				schemeShow()
			);			
			$('#disease').change(	
				tan()
			);		
		});
		function fangan(){
		$("#yin").show();
		$("#xian").hide();
		 var select = document.getElementById("fangan");
		select.options[1].selected = true;
		
		};
		function schemeShow (){ 
				$('#scheme').combobox('loadData', []);
				$('#scheme').combobox('setValue', null);
				$('#scheme').combobox(
							'reload',
							'<%=basePath%>healthPhysiotherapyAction!jsonChuan.action?data='
							+ $('#disease').combobox('getValue')+ '&type='
							+ $('#type').combobox('getValue'));
		};
		function tan() {
	       
			$('#add').empty();
			schemeShow();
		$.ajax({
		
			type : "POST",
	        url:"<%=basePath%>healthPhysiotherapyAction!getEditAddOld.action?data="
								+ $('#disease').combobox('getValue')+"&id="+${plan.recoveryPlanId}+"&disease=${plan.TRecoveryScheme.disease}",
						dataType : "json",
						success : function(json) {
							//console.log($('#disease').combobox('getValue'));
							console.log(json.length);
							AddElement(json)

						}
					});
		}
		function AddElement(json) {
			for (var i = 0; i < json.length; i++) {
				var TemO = document.getElementById("add");
				var label = document.createElement("label");
				var newInput = document.createElement("input");
				newInput.type = "checkbox";
				newInput.name = "checkbox";
				newInput.value = json[i].value;
				newInput.checked = json[i].checked;
				TemO.appendChild(newInput);
				TemO.appendChild(label);
				label.innerText = json[i].text;
				if ((i + 1) % 10 == 0 && i + 1 > 9) {
					var br = document.createElement("br");
					TemO.appendChild(br);
				}
			}
		}

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
