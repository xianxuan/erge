<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.text.*"%> 
<% 
String currentTime=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()); //获取系统时间 
request.setAttribute("currentTime",currentTime);
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head><meta name="viewport" content="width=device-width, initial-scale=1.0"><meta http-equiv="X-UA-Compatible" content="ie=edge">
  <meta charset="UTF-8">
  <c:choose><c:when test="${session.comHospital.isHead==0}"><title>中电科社区健康管理平台</title></c:when><c:when test="${session.communityHospitalGroup!=null}"><title>社区健康管理系统</title></c:when><c:otherwise><title>社区健康服务站</title></c:otherwise></c:choose>
  <link rel="stylesheet" href="/jmjkms/css/cssreset.css">
  <link rel="stylesheet" href="/jmjkms/css/main.css">
  <link rel="stylesheet" href="/jmjkms/select2/css/select2.css">
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
    <h3 class="current-title">糖尿病医生诊断添加</h3>
 <!-- 表单表格 start -->
                 
     <div class="table-content">
      <input name="yemianname" value="02205" type="hidden"/>
          <s:form id="registerform" action="doctorDiagnosisAction!addDoctorDiagnosisAction.action" method="post" onsubmit="return dosubmit()">
                 <input type="hidden" value="${token}" name="token">
                 <input type="hidden" value="${chronicName}" name="chronicName">
           		 <input type="hidden" value="${daId}" name="daId">
             <table class="table table-bordered">
                       <tbody>
                      
                         <tr>
                          
                                       <td><span class="required">*</span>诊断医生</td>
                                       <td>
                                       <c:if test="${flag0==true }">
										<select name="staffDoctor" class="js-example-basic-single"  class="select2"  style="width: 105px;">
											<s:iterator value="allDoctor" var="adc">
												<option value="${adc.staffId}" <c:if test="${session.comHospital.name eq adc.name}">selected</c:if>>${adc.name}</option>	
											</s:iterator>
										</select>
										</c:if>
										<c:if test="${flag0==false }">
												<label>${session.tstaff.name }</label>
										</c:if>
								</td>
                         </tr>
                           <tr>
                                      <td><span class="required">*</span>慢病名称</td>
										       <td>
                                      	        <label>${chronicName}</label>
												<input type="hidden" name="doctorDiagnosis.chronic" value="${chronicName}">
                                             </td>
                            </tr>
                           <tr>
                                      <td><span class="required">*</span>诊断意见</td>
                                      <td colspan="6">
                                      	<textarea   name="doctorDiagnosis.opinion" id="opinion" datatype="*" nullmsg="诊断意见不可为空" class="textarea"></textarea>   
                                      </td>
                           </tr>
                           <tr>                                      <td>建议</td>
                                      <td colspan="6">
                                      	<textarea   name="doctorDiagnosis.advice" class="textarea"></textarea>
                                      </td>
                           </tr>
                            <tr>
                                      <td><span class="required">*</span>日期</td>
                                      <td colspan="6"><input type="text" value="${currentTime }" name="doctorDiagnosis.date" id="time" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"></td>
                           </tr>
                       </tbody>
               </table>
               
                                     <div class="btn-content">
                                     <input type="submit" id="submit" class="btn" value="保存">
                                     <button class="btn" type="button" onclick="history.go(-1);">返回</button>
                                     </div>
                   </s:form>
                                  </div>
                 <!-- 表单表格 start -->
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
<script type="text/javascript">
	$("form").submit(function(){
		if($("#time").val()==""){
			alert("日期不可为空")
			return false;
		}
	})
</script>
<script type="text/javascript">
	$(function(){
		$(".js-example-basic-single").select2();
	})
</script>
<!--  防止表单提交 -->
	<script type="text/javascript">
		var isCommitted = false;//表单是否已经提交标识，默认为false
		function dosubmit() {
			/* 此处还需要判断各个必填项校验是否通过*/
			if (isCommitted == false
					&& document.getElementById('time').value != ""
					&& document.getElementById('opinion').value != "") {
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
