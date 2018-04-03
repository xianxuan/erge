<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head><meta name="viewport" content="width=device-width, initial-scale=1.0"><meta http-equiv="X-UA-Compatible" content="ie=edge">
  <meta charset="UTF-8">
  <c:choose><c:when test="${session.comHospital.isHead==0}"><title>中电科社区健康管理平台</title></c:when><c:when test="${session.communityHospitalGroup!=null}"><title>社区健康管理系统</title></c:when><c:otherwise><title>社区健康服务站</title></c:otherwise></c:choose>
  <link type="text/css" href="/jmjkms/css/confirm.css">
  <link rel="stylesheet" href="/jmjkms/css/cssreset.css">
  <link rel="stylesheet" href="/jmjkms/css/main.css">
  <link rel="stylesheet" href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">
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
      <h3 class="current-title">员工请假编辑</h3>
      <input name="yemianname" value=07202 type="hidden"/>
      <form id="registerform" action="<%=basePath %>staffAction!updateStaffLeaveSave.action" method="post" onsubmit="return checkall()">
      <!--///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
      <!-- 结果容器 start -->
      <div class="table-content">
        <table class="table table-bordered">
          <tbody>
      <!--以下是一整行-->
      <tr><td colspan="4" class="title-td">详细信息</td></tr>
      <tr>
        <td>员工编码：</td><!--可输可选框-->
        <td> <font color="red"><c:out value="${ staffLeave.TStaff.staffNumber}"></c:out></font>            
         </td>    
         <td>员工姓名：</td>
        <td>   <font color="red"><c:out value="${ staffLeave.TStaff.name}"></c:out></font>  
         </td>  
      </tr>
         <tr>
              <td><font color="red">*</font>请假日期：</td>
              <td>
              <input type="text" class="w150" name="staffLeave.leaveDate" id="leaveDate" value="<fmt:formatDate value='${staffLeave.leaveDate }' pattern='yyyy-MM-dd'/>"onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"><span id="leaveDateSpan"></span> 
               </td>
           
              <td><font color="red">*</font>请假天数：</td>
              <td>
              <input maxlength="10"  type="text" name="staffLeave.days" id="days"  value="${staffLeave.days }"/> <span id="daysSpan"></span> 
               </td>
         </tr>
          <tr>
            
             <td><font color="red">*</font>请假事由：</td><td colspan="3">
              <input maxlength="100" class="temp"  type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" name="staffLeave.leaveReason" id="leaveReason" value="${ staffLeave.leaveReason}"/> <span id="leaveReasonSpan"></span></td>
            </tr>
          <tr>
          <td>说明：</td>
          <td colspan="3" class="title-td">
          
         <textarea name="staffLeave.note" id=""  class="textarea"> ${ staffLeave.note}</textarea>
          </td>
          </tr>
          </tbody>
        </table>
         
        <input type="hidden" name="staffLeave.staffLeaveId" value="${staffLeave.staffLeaveId }" />
        <input type="hidden" name="staffId" value="${staffLeave.TStaff.staffId }" />
        <div class="btn-content">
        <input type="submit" value="保存" class="btn" />
        <input type="reset" value="重置" class="btn">
         <!--  <a href=" javascript:history.go(0) " class="btn" id="news">重置</a> -->
          <a href="javascript:history.go(-1)" class="btn">返回</a>
        </div>
      </div>
      <!-- 结果容器 end -->
      </form>
    </div>
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
 function checkall(){
 	
      var leaveDate = document.getElementById("leaveDate" ).value;
      var days = document.getElementById("days" ).value;
      var leaveReason = document.getElementById("leaveReason" ).value;
      
      var flag = 0;
     if (trim(leaveDate) == "") { 
          document.getElementById("leaveDateSpan" ).innerHTML = "<font color='red'>不能为空</font>"; 
          flag++; 
      }
      if (trim(days) == "" || !isInteger(days)) { 
          document.getElementById("daysSpan" ).innerHTML = "<font color='red'>格式错误</font>"; 
          flag++; 
      }
      if (trim(leaveReason) == "") { 
          document.getElementById("leaveReasonSpan" ).innerHTML = "<font color='red'>不可为空</font>"; 
          flag++; 
      }
      if(flag != 0){
      	return false;
      }else{
   		  return true;
   	  }
	}

	function trim(str) { 
	    var strnew = str.replace(/^\s*|\s*$/g, ""); 
	    return strnew; 
	} 
	function isInteger(obj) {
 		return obj%1 === 0
	}
</script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
</body>
</html>
