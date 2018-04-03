<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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
  <link rel="stylesheet" href="/jmjkms/css/confirm.css">
  <link rel="stylesheet" href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">
  
 <style>
.msg-td{
	width:200px !important;
}
.pass{
	display:block;
	max-width: 100%;
	margin-bottom: 10px;
	border-spacing: 0;
	border-collapse: collapse;
	font-size: 15px;
	padding-top:30px;
	padding-left:50px;	
}
.pass td{
	height:40px;
	width:160px;
	float:left;
}
.pass tr{
	margin-bottom:200px;
}
#table-fu{
	background-color:#DCDCDC;
	border-radius:10px;
	width:570px;
	height:230px;
	margin-top:70px;
	margin-left:250px;
	margin-bottom:70px;
}
</style>
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
      <h3 class="current-title">修改密码</h3>
      <form id="registerform" action="<%=basePath %>LoginoutAction!adminChangePassword.action" method="post">
      <div class="table-content">
      	<input name="communityHospitalId" value="${session.comHospital.communityHospitalId}" type="hidden"/>
      	<input name="groupId" value="${session.communityHospitalGroup.GId}" type="hidden"/>
      <div id="table-fu">
        <table class="pass">
          <tbody>
            <tr>
              <td>输入旧口令</td>
              <td>
                <input type="password" maxlength="15" class="temp" name="prepassword"/>
              </td>
              <td class="msg-td">
	             <label class="Validform_checktip"></label>
	          </td>
            </tr>
            <tr>
              <td>输入新口令</td>
              <td>
                <input type="password" datatype="*6-18" errormsg="输入有误！" class="temp" id="password1" name="newpassword"/>
              </td>
              <td class="msg-td">
	              <label class="Validform_checktip">请输入6-18位字母、数字、下划线</label>
	          </td>
            </tr>
            <tr>
              <td>确认新口令</td>
              <td>
                <input type="password" datatype="*" errormsg="两次输入密码不一致" class="temp" id="password2" recheck="newpassword"/>
                <%-- <span id="tishi"></span> --%>
              </td>
              <td class="msg-td">
	             <label class="Validform_checktip"></label>
	          </td>
            </tr>
            </tbody>
            </table>  
             <div class="btn-content">
              <input type="submit" id="submit" class="btn" value="提交" />
              <!-- <a id="news" href="javascript:;" class="btn">重置</a> -->
              	<button class="btn"  type="button" onclick="history.go(-1);">返回</button>
             </div>
          </div>         
            
            </div>
</form>


    </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>

<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/confirm/Validform_v5.3.2_min原版.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>

<script type="text/javascript">
    $(function(){
      $("#registerform").Validform({
        showAllError:false,
        tiptype:2
      });
  });
</script>
 
  <%-- <script>
      function validate(){
    	var pw1=document.getElementById("password1").value;
    	var pw2=document.getElementById("password2").value;
    	
    	if(pw1==pw2){
    	document.getElementById("tishi").innerHTML="<font color='green'>两次密码相同</font>";
    	document.getElementById("submit").disable=false;
    	}
    	else{
    	document.getElementById("tishi").innerHTML="<font color='red'>两次密码不相同</font>";
    	document.getElementById("submit").disable=true;
    	}
    };    
 </script>  --%>	

  <script type="text/javascript">
	
	var result = ${result};
	if (result == 1) {
		alert("修改成功");
	}

	if (result ==2) {
		alert("原密码错误");
	}
	if (result == 3) {
		alert("与原密码相同请重新修改");}
	</script>   
</body>
</html>
