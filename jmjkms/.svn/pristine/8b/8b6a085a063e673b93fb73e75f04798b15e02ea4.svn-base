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
  <link type="text/css" href="/jmjkms/css/confirm.css">
  <link rel="stylesheet" href="/jmjkms/css/cssreset.css">
  <link rel="stylesheet" href="/jmjkms/select2/css/select2.css">
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
    <input name="yemianname" value="07202" type="hidden"/>
    
      <!-- 主容器 start -->
      <div class="container">
      <h3 class="current-title">员工请假添加</h3>
      <!--///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
     <form  action="<%=basePath %>staffAction!addStaffLeave.action" method="post" onsubmit="return checkall();">
        <input type="hidden" name="token" value="${token }" />
      <!-- 结果容器 start -->
      <div class="table-content">
        <table class="table table-bordered">
          <tbody>
      <!--以下是一整行-->
      <tr><td colspan="4" class="title-td">详细信息</td></tr>
      <tr>
        <td><font color="red">*</font>员工编号：</td><!--可输可选框-->
        <td>  
			<select class="js-example-basic-single" class="select2" style="width: 170px;" onchange="getContent(this.value,this.options[this.selectedIndex].text)">
			 <option value="" >请选择</option>
			 <s:iterator value="staffs" var="staff">
			  <option value="${staff.name }"><c:out value="${staff.staffNumber }"></c:out></option>
			 </s:iterator>
			</select>  
			<span id="staffNumberSpan"></span>      
         </td>  
           
         <td>员工姓名：</td>
        <td> 
        	 <label id="staffname"></label>
			
         </td>  
      </tr>
         <tr>
              <td><font color="red">*</font>请假日期：</td>
              <td>
              <input datatype="*"  type="text" class="w150" name="staffLeave.leaveDate"  onfocus="this.blur()"
               onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" id="leaveDate">  
               <span id="leaveDateSpan"></span>
               </td>
           
              <td><font color="red">*</font>请假天数：</td>
              <td>
              <input type="text" class="temp"  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" name="staffLeave.days" id="days" datatype="*"  /><span id="daysSpan"></span>
               </td>
         </tr>
          <tr>
             <td><font color="red">*</font>请假事由：</td><td colspan="3">
              <input  type="text" datatype="*"  maxlength="100" name="staffLeave.leaveReason"  id="leaveReason"/> <span id="leaveReasonSpan"></span></td>
            
            </tr>
          <tr>
          <td>说明：</td>
          <td colspan="3" class="title-td">
         <textarea name="staffLeave.note" id=""  class="textarea"></textarea>
          </td>
          </tr>
          </tbody>
        </table>
      <input type="hidden" name="staffNumber" value="" id="staffNumber" />
        <div class="btn-content">
           <input  type="submit" class="btn" value="保存">
           <!-- <input type="reset" value="重置" class="btn"> -->
           <a href=" javascript:history.go(0) " class="btn" id="news">重置</a>
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

<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<script src="/jmjkms/select2/js/select2.full.js"></script>
 <script type="text/javascript">
 	
	 function getContent(value,content){
		 var Ostaffname =document.getElementById("staffname");
		 var OstaffNumber = document.getElementById("staffNumber");
		/*  alert("选中的值是"+value+"选中的内容是"+content);  */
		 Ostaffname.innerText= value;
		 OstaffNumber.value=content;
		 //OstaffNumber=content;
	 }



</script>
<script type="text/javascript">
	$(function(){
		$(".js-example-basic-single").select2();
	})
</script>

 <script type="text/javascript">
   //表单验证
 function checkall(){
   	  var staffNumber = document.getElementById("staffNumber").value;
      var leaveDate = document.getElementById("leaveDate" ).value;
      var days = document.getElementById("days" ).value;
      var leaveReason = document.getElementById("leaveReason" ).value;
      var flag = 0;
      if (trim(staffNumber) == "") { 
          document.getElementById("staffNumberSpan" ).innerHTML = "<font color='red'>请选择员工编码</font>"; 
          flag++; 
      }else{
       document.getElementById("staffNumberSpan" ).innerHTML ="";
      }
     if (trim(leaveDate) == "") { 
          document.getElementById("leaveDateSpan" ).innerHTML = "<font color='red'>不能为空</font>"; 
          flag++;; 
      }else{
       document.getElementById("leaveDateSpan" ).innerHTML ="";
      }
      if (trim(days) == "" || !isInteger(days)) { 
          document.getElementById("daysSpan" ).innerHTML = "<font color='red'>格式错误</font>"; 
          flag++;; 
      }else{
      	document.getElementById("daysSpan" ).innerHTML ="";
      }
      if (trim(leaveReason) == "") { 
          document.getElementById("leaveReasonSpan" ).innerHTML = "<font color='red'>不能为空</font>"; 
          flag++;; 
      }else{
     	 document.getElementById("leaveReasonSpan" ).innerHTML ="";
      }
      if(flag != 0){
      	return false;
      }
   	  return true;
	}

	function trim(str) { 
	    var strnew = str.replace(/^\s*|\s*$/g, ""); 
	    return strnew; 
	} 
	function isInteger(obj) {
 		return obj%1 === 0
	}
</script>

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
