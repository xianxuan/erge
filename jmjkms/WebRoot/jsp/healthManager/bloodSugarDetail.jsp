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
  <title>血糖详情</title>
  <link rel="stylesheet" href="/jmjkms/css/cssreset.css">
  <link rel="stylesheet" href="/jmjkms/css/main.css">
  <link type="text/css" href="/jmjkms/css/confirm.css">
  <style type="text/css">
.thBg{background-color:#F5F5F6;}
</style>
</head>
<body>
  <div class="main-content clearfix" style="min-width:500px;">
    <!-- 主容器 start -->
    <div class="container" style="min-width:500px;min-height:450px;">
      <h3 class="current-title title-td">血糖详情</h3>
      <!-- 表格容器 start -->
       <div class="search-content">
        <div class="search-item">
          <label>姓名：${healthfile.name}</label>
          &nbsp;&nbsp;&nbsp;&nbsp;<label>性别：<c:if test="${healthfile.sex==false }">男</c:if><c:if test="${healthfile.sex==true }">女</c:if></label>
          &nbsp;&nbsp;&nbsp;&nbsp;<label>身份证号：${healthfile.idNum}</label>
          &nbsp;&nbsp;&nbsp;&nbsp;<label>电话号码：${healthfile.IPhone}</label>
        </div>
      </div>
      <!-- begin -->
       <div class="table-content">
       <!-- 血糖表单表格 start -->
           <table class="table table-bordered">
             <tbody>
               <tr>
                 <td class="thBg">测量条件</td>
                 <td>
                 	<c:choose>
                   		<c:when test="${meaState==0 }">随机</c:when>
                   		<c:when test="${meaState==1 }">空腹</c:when>
                   		<c:otherwise>餐后</c:otherwise>
                   </c:choose>
                  </td>
                   <td class="thBg">测量时间</td>
                 <td>${meaTime}</td>
                </tr>
                <tr>
                	<td class="thBg">是否服药物</td>
                 <td>
                   <c:choose>
                   		<c:when test="${takeMed==0 }">未服药</c:when>
                   		<c:otherwise>已服药</c:otherwise>
                   </c:choose>
                </td>
                 <td class="thBg">药物名称</td>
                 <td>
                   ${medName}
                 </td>
                </tr>
                <tr>
                 <td class="thBg">血糖值(mmoL/L )</td>
                 <td>${bloodSugar }</td>
                 <td class="thBg">异常报警</td>
                 <td>
                  	<c:if test="${abnAlarm eq 0}">设为报警</c:if>
                  	<c:if test="${abnAlarm eq 1}">设为不报警</c:if>
                </td>
               
              
               </tr>
               <tr>
                  <td class="thBg">血糖分析结果</td>
                  <td colspan="3">
                  <textarea name="bloodSuger.analysisResult" id=""  
					class="textarea temp" datatype="*" nullmsg="血糖分析结果不可为空" disabled>${analysisResult}</textarea>
				 </td>
                </tr>
             </tbody>
           </table>
           <div class="btn-content">
				<a class="btn" onclick='window.close();'>关闭</a>
            </div>
         <!-- 血糖表单表格 end -->
       </div>
       <!--end -->
    </div>
    <!-- 主容器 end -->
  </div>
  <!--  
<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/sweetalert.min.js"></script> 
<script src="/jmjkms/js/base.js"></script>
<script src="/jmjkms/js/healthManager.js"></script>
<script type="text/javascript" src="/jmjkms/js/confirm/Validform_v5.3.2_min.js"></script>
<script src='/jmjkms/js/dkdhcommon.js'>
<script type="text/javascript">
$(function(){
      $("#registerform").Validform({
        showAllError:false,
        tiptype:function(msg){          
          alert(msg);
        }
      });
  });
   	$("form").submit(
			function() {
				if ($("#xt").val() > 999) {
					alert("数据值过大！")
					return false;
				}
			})
</script>
-->
</body>
</html>
