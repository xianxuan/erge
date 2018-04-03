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
	<input name="yemianname" value="04202" type="hidden"/>
		<!-- 主菜单 start -->
		<s:include value="/include/nav.jsp" />
		<!-- 主菜单 end -->
		<!-- 主容器 start -->
		<div class="container">
			<h3 class="current-title">添加康复计划</h3>

			<!-- 搜索容器 start -->
			<form id="registerform" action="<%=basePath%>healthPhysiotherapyAction!addPlan.action"
				method="post" onsubmit="return dosubmit()" enctype="multipart/form-data">
				<input id="current" type="hidden" value="${currentTime }">
				<input type="hidden" name="token" value="${token }" />
				<div class="table-content">
					<table class="table table-bordered">
						<tbody>
							<tr>
								<td><span class="required">*</span>计划名称</td>
								<td colspan="2"><input   id="planName" type="text" class="w150"
									name="plan.planName" value="${plan.planName }" nullmsg="计划名称不可为空" datatype="*" maxlength="15" ></input>
						
									
									</td>
							</tr>
							<tr>
								<td><span class="required">*</span><label>方案类型</label></td>
								<td>
									<select name="type" id="type">
										<s:if test="type=='推荐方案'">
										<option value="个人方案">个人方案</option>
										<option value="专家方案">专家方案</option>
										<option value="推荐方案"selected="selected">推荐方案</option>
										</s:if>
										<s:if test="type=='专家方案'">
										<option value="个人方案">个人方案</option>
										<option value="专家方案"selected="selected">专家方案</option>
										<option value="推荐方案">推荐方案</option>
										</s:if>
										<s:else>
										<option value="个人方案" selected="selected">个人方案</option>
										<option value="专家方案">专家方案</option>
										<option value="推荐方案">推荐方案</option>
										</s:else>
										
									</select>
								
								</td>
							</tr>
							<tr>
								<td><span class="required">*</span><label>疾病名称</label></td>
								<td>
									<select  name="disease"  id="disease">
										<s:iterator value="diseaseList" var="list">
											<s:if test="#list==disease">
												<option value="${list }" selected="selected">${list }</option>
											</s:if>
											<s:else>
												<option value="${list}">${list }</option>
											</s:else>
										</s:iterator>
								</select>
							</tr>
							<tr>
								<td><span class="required">*</span><label>方案名称</label></td>
								<td><select name="scheme" id="scheme">
								</select>
							</tr>
							<tr>
								<td><span class="required">*</span><label>老人：</label></td>
								<td>
									<div id="add"></div>
									
								</td>
							</tr>
							<tr>
								<td><span class="required">*</span><label>开始日期：</label></td>
								<td><input type="text"
								    id="dateInput1"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"
									name="plan.beginTime"
									onfocus="this.blur()" value="${currentTime }">
								</td>
							</tr>
							<tr>
								<td><span class="required">*</span><label>结束日期：</label></td>
								<td><input type="text"
								    id="dateInput2"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"
									name="plan.overTime"
									onfocus="this.blur()" value="${plan.overTime}">
								</td>
							</tr>

							<tr>
								<td><span class="required">*</span><label>制定人</label></td>
								<td>
								<c:if test="${staffRe==null}">
										<select name="select"  id="people"  class="js-example-basic-single"  class="select2"  style="width: 170px;" onchange="getContent(this.value,this.options[this.selectedIndex].text)" >
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
								<td><span class="required">*</span><label>详细康复计划</label></td>
								<td>
									<textarea name="plan.planContent" id="dtext" class="textarea" nullmsg="计划详情不可为空" datatype="*" maxlength="15" >${plan.planContent}</textarea>
								</td>
							</tr>

						</tbody>
					</table>
					<div class="btn-content">
						<input type="submit"  class="btn"  name="submit"  id="submit"  value="确定">
						 <a	id="quxiao" href="healthPhysiotherapyAction!getAllPlan.action" class="btn">取消</a>
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
	<div id = "tan-one" class="tan-box">
			<p>康复计划重名!</p><br><br><br>
			<a href="javascript:;" onclick="$('#planName').focus();" class="btn">确定</a>
	</div>
	<script src="/jmjkms/js/confirm/jquery-1.9.1.min.js"></script>
	<script src="/jmjkms/js/laydate/laydate.js"></script>
	<script src="/jmjkms/js/base.js"></script>
	<script src="/jmjkms/select2/js/select2.full.js"></script>
	<script src="/jmjkms/js/confirm/Validform_v5.3.2_min.js"></script>
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
			tan();
			$('#type').change(function(){
				schemeShow();
				
			});			
			$('#disease').change(function(){
			schemeShow();
				tan();
			});	
			console.log(${jsonString});
			
			$("#submit").click(function(){
                     if($("#scheme").val()==null)
                     {
                     	alert("康复方案不能为空");
                     	return false;
                     }
                     else{
                    var planNameVal = $("#planName").val();
                    var jiaoyan="";
                     	$.ajax({
				type : "POST",
		        url:"<%=basePath%>healthPhysiotherapyAction!checkPlan.action?planName="
									+ planNameVal,
				success : function(jsons) {
											if(jsons!=""){
											$("#submit").hide();
												$("#quxiao").hide();
												$("#tan-one").show(); 
												jiaoyan=" ";
											}
										}
					});
					if(jiaoyan==" "){
						return false;
					}
					else{
						return true;
					}
					
                     }
			
	});	
	//取出对应康复方案
		function schemeShow (){
			$("#scheme").empty();
				$.ajax({
				type : "POST",
		        url:"<%=basePath%>healthPhysiotherapyAction!jsonChuan.action?data="
								+ $("#disease").val()+"&type="+$("#type").val(),
				dataType : "json",
				success : function(json) {
								//console.log(json.length);
								//console.log(json);
								$("#scheme").append("<option value='"+1+"'></option>");
								$("#scheme").empty();
								for (var i = 0; i < json.length; i++){
								$("#scheme").append("<option value='"+json[i].value+"'>"+json[i].text+"</option>");
								}
								
							}
				});
		};
		
		//取出对应老人
		function tan() {
			$('#add').empty();
			schemeShow();
			$.ajax({
			
				type : "POST",
		        url:"<%=basePath%>healthPhysiotherapyAction!getAddOld.action?data="
								+ $("#disease").val(),
				dataType : "json",
				success : function(json) {
								//console.log(json.length);
								//console.log(json);
								$('#add').empty();
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
				var putId = json[i].value;
				newInput.setAttribute("id", putId)
				label.setAttribute("for",putId );		
				newInput.value = json[i].value;
				var check=${jsonString};
				if(check!="0"){
					for(var j=0;j<check.length;j++)
					{
						if(check[j].value==json[i].value)
						{
							newInput.checked = check[j].checked;
						}
					}
				}
				TemO.appendChild(newInput);
				TemO.appendChild(label);
				label.innerText = json[i].text;
				if ((i + 1) % 10 == 0 && i + 1 > 9) {
					var br = document.createElement("br");
					TemO.appendChild(br);
				}
			}
		}
		
		
		//康复计划名判重
		$("#planName").blur(function(){
				var planNameVal = $("#planName").val();
				$.ajax({
				type : "POST",
		        url:"<%=basePath%>healthPhysiotherapyAction!checkPlan.action?planName="
									+ planNameVal,
				success : function(jsons) {
											if(jsons!=""){
											$("#submit").hide();
												$("#quxiao").hide();
												$("#tan-one").show(); 
											}
										}
					});
			});
			$(".tan-box a").click(function(){
			$(".tan-box").hide();
			$("#submit").show();
			$("#quxiao").show();
		});

		if('${oldString}'!="")
	  {
	  alert("请选择老人");
	  }
		
	
	});
	</script>
	<script type="text/javascript">
 /* $("form").submit(function(){
    	var startTime0=$("#dateInput1").val();
    	var endTime0=$("#dateInput2").val();
    	if(startTime0 != ""&&endTime0 != ""){
    	if(startTime0<$("#current").val()){
    		alert("开始日期小于当前时间");
    		return false;
    	}
    	if(startTime0>endTime0){
      	 	$("#dateInput1").val("").focus();
       		$("#dateInput2").val("");
       		alert("开始日期输入错误");
       		return false;
       	}
       	}
       if(startTime0==""){
			$("#dateInput1").val("").focus();
       		alert("请输入开始日期");
       		return false;
       	}
       	if(endTime0==""){
			$("#dateInput2").val("").focus();
       		alert("请输入结束日期");
       		return false;
       	}
    }) */
    
</script>
	<!--  防止表单提交 -->
    <script type="text/javascript">
       var isCommitted = false;//表单是否已经提交标识，默认为false
       function dosubmit() {
       var startTime0=$("#dateInput1").val();
    	var endTime0=$("#dateInput2").val();
    	if(startTime0 != ""&&endTime0 != ""){
    	if(startTime0<$("#current").val()){
    		alert("开始日期小于当前时间");
    		return false;
    	}
    	if(startTime0>endTime0){
      	 	$("#dateInput1").val("").focus();
       		$("#dateInput2").val("");
       		alert("开始日期输入错误");
       		return false;
       	}
       	}
       if(startTime0==""){
			$("#dateInput1").val("").focus();
       		alert("请输入开始日期");
       		return false;
       	}
       	if(endTime0==""){
			$("#dateInput2").val("").focus();
       		alert("请输入结束日期");
       		return false;
       	}
       	$("#registerform").Validform({
        showAllError:false,
        tiptype:function(msg){          
          alert(msg);
        }
      });
           /* 此处还需要判断各个必填项校验是否通过*/
           //alert("1" + isCommitted);
           if (isCommitted == false
                  && document.getElementById('planName').value != ""
                  && document.getElementById('type').value != ""
                  && document.getElementById('disease').value != ""
                  && document.getElementById('scheme').value != ""
                   && document.getElementById('dateInput1').value != ""
                    && document.getElementById('dateInput2').value != ""
                     && document.getElementById('people').value != ""
                      && document.getElementById('dtext').value != "") {
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
</body>
</html>
