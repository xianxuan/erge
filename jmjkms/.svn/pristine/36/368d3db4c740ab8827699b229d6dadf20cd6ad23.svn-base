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
      <h3 class="current-title">高血压医生诊断编辑</h3>
 <!-- 表单表格 start -->
                 
         <div class="table-content">
         <input name="yemianname" value="02204" type="hidden"/>
          <s:form id="registerform" action="doctorDiagnosisAction!editDoctorDiagnosisAction.action" method="post">
            <input type="hidden" value="${yszdId}" name="yszdId">
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
												${session.tstaff.name}
										</c:if>
                                       </td>
                         </tr>
                           <tr>
                                      <td><span class="required">*</span>慢病名称</td>
                                       <td>
                                      	      <label>${chronicName}</label>
												<input type="hidden" name="chronicName" value="${chronicName}">
                                       </td>
                           </tr>
                           <tr>
                                      <td><span class="required">*</span>诊断意见</td>
                                      <td colspan="6">
                                      <textarea   name="opinion" id="" datatype="*" nullmsg="诊断意见不可为空" class="textarea"><c:out value="${doctorDiagnosis.opinion}"></c:out></textarea>
                 					  </td>
                           </tr>
                           <tr>       <td>建议</td>
                                      <td colspan="6">
                                     	 <textarea   name="advice" class="textarea"><c:out value="${doctorDiagnosis.advice}"></c:out></textarea>
                					       </td>

                           </tr>
                            <tr>
                                      <td><span class="required">*</span>日期</td>
                                      <td colspan="6"><input type="text" name="date" id="time"
                                       value="<fmt:formatDate value='${doctorDiagnosis.date}' pattern='yyyy-MM-dd'/>" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"></td>
                           </tr>
                       </tbody>
               </table>
                                 <div class="btn-content">
                                    
                                     
                                     <input type="submit" class="btn" value="保存">
                                     <button class="btn" type="button" onclick="history.go(-1);">返回</button>
                                     </div>
                   </s:form>
                                  </div>
                 <!-- 表单表格 start -->
    </div>
    <script type="text/javascript">  
   		 CKEDITOR.replace( 'explain' );  
   		  CKEDITOR.replace( 'explaina' );
	</script> 
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>
<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
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
			alert("日期不可为空");
			return false;
		}
	})
</script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
</body>
</html>
