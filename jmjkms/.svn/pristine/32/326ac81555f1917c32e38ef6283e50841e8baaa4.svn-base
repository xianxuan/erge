<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page import="java.text.*"%> 
<% 
String currentTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); //获取系统时间 
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
    <h3 class="current-title">健康建议修改</h3>
 <!-- 表单表格 start -->
                 
    <div class="table-content">
        <input name="yemianname" value="02202" type="hidden"/>
          <form id="registerform" action="HealthManagerAction!editSuggest.action" method="post" onsubmit="return dosubmit()">
                 <input type="hidden" value="${token}" name="token">
                 <input type="hidden" value="${healthFileId}" name="healthFileId">
                 <input type="hidden" value="${suggestId}" name="suggestId">
                 <input type="hidden" value="${userId}" name="userId">
             <table class="table table-bordered">
                       <tbody>
                            <tr>
                                <td>现存主要健康问题</td>
                                <td>
                                    <input type="text" class="temp" name="wenti" value="${wenti}" datatype="*" nullmsg="现在健康问题不可为空"/>
                                </td>
                            </tr>
                           <tr>
                                      <td>指导意见</td>
                                      <td colspan="6">
                                        <textarea name="doctorAdvice"  datatype="*"  nullmsg="指导意见不可为空" class="textarea temp"><c:out value="${doctorAdvice}"></c:out></textarea>   
                                      </td>
                           </tr>
                          <tr>
                                      <td><span class="required">*</span>日期</td>
                                      <td colspan="6">${createTime }</td>
                           </tr>
                            
                       </tbody>
               </table>
                                     <div class="btn-content">
                                      <input type="submit" class="btn" id="submit" value="保存">
                                      <button class="btn" type="button" onclick="history.go(-1);">返回</button>
                                     </div>
                   </form>
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
            //alert("1" + isCommitted);
            return true;//返回true让表单正常提交
            } else {
                return false;//返回false那么表单将不提交
            }
        }
    </script>
</body>
</html>
