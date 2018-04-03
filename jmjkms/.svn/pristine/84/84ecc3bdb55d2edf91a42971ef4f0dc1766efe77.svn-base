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
  <link rel="stylesheet" href="/jmjkms/css/confirm.css">
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
    <!-- 主容器 start -->
    <div class="container">
      <h3 class="current-title">员工奖惩添加</h3>
      <input name="yemianname" value="07203" type="hidden"/>
      <!--///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
      <!-- 结果容器 start -->
      <div class="table-content">
     
     <form id="registerform" action="<%=basePath %>staffRewardPunishAction!addRewardPunish.action"   method="post" onsubmit="return checkall()" >
     <input type="hidden" name="token" value="${token }" />
        <table class="table table-bordered">
          <tbody>
      <!--以下是一整行-->
      <tr><td colspan="4" class="title-td">详细信息</td></tr>
      <!--**********************少可输可选框************************-->
      <tr>
      
         <td><font color="red">*</font>员工编号：</td>
         <td> 
        	<select class="js-example-basic-single" class="select2" style="width: 170px;" onchange="getContent(this.value,this.options[this.selectedIndex].text)" >
			 	 <option value="" >请选择</option>
			 	<s:iterator value="AllStaffNumberList" var="List">
			  		<option value="${List.name }"><c:out value="${List.staffNumber }"></c:out></option>
				</s:iterator>
			</select>  
			<span id="staffNumberSpan"></span>
         </td>
         <td>员工姓名：</td>
         <td><label id="staffname"></label>
         	<!-- <input name="staff.name" type="text"/> -->
          </td>
      </tr>
         <tr>
              <td><font color="red">*</font>奖惩日期：</td>
              <td>
              	   <input type="text"  class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'}) " name="staffRewardPunish.rewardPunishDate"  id="rewardPunishDate"  ><span id="rewardPunishDateSpan"></span>  
               </td>
              <td>奖惩类型：</td>  
              
              <s:action name="staffAction!getKWHZD" namespace="/" var="home"> </s:action>
              <td> <select name="staffRewardPunish.rewordPunishType" id="">
         	     <s:iterator value="#home.jclx" var="jj">
                 <option value="${jj.name }" <c:if test="${jj.name eq staffRewardPunish.rewordPunishType}">selected</c:if>><c:out value="${jj.name }"></c:out></option>
             	</s:iterator>
             </select></td>
         </tr>
          <tr>
             <td><font color="red">*</font>奖惩金额：</td>
              <td colspan="3">
              <input maxlength="10" type="text"  name="staffRewardPunish.rewordPunishAmount" id="rewordPunishAmount" onkeyup="Num(this)" /> <span id="rewordPunishAmountSpan"></span> 
               </td>
            </tr>
	 <tr>
          <td>奖惩原因：</td>
          <td colspan="3" class="title-td">
           <textarea name="hhhString" id="hhhString"  class="textarea"  ></textarea>
          </td></tr>
          <tr>
			 <td>说明：</td><td colspan="3">
              <textarea   class="textarea"  name="staffRewardPunish.note"  > </textarea></td>
			  </tr>
      
          </tbody>
        </table>
        
         <input type="hidden" name="staffNumber" value="" id="staffNumber" />
        <div class="btn-content">
         <input  type="submit" class="btn" value="保存">
         <a href=" javascript:history.go(0) " class="btn" id="news">重置</a>
          <a href="javascript:history.go(-1)" class="btn">返回</a>
        </div>
        </form>
        
      </div>
      <!-- 结果容器 end -->
    </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>

 <script type="text/javascript">
   //表单验证
 function checkall(){
   	  var staffNumber = document.getElementById("staffNumber").value;
      var rewardPunishDate = document.getElementById("rewardPunishDate" ).value;
      var rewordPunishAmount = document.getElementById("rewordPunishAmount" ).value;
   	  var flag = 0;
      if (trim(staffNumber) == "") { 
          document.getElementById("staffNumberSpan" ).innerHTML = "<font color='red'>请选择员工编码</font>"; 
          flag++; 
      }else{
     	 document.getElementById("staffNumberSpan" ).innerHTML ="";
      }
     if (trim(rewardPunishDate) == "") { 
          document.getElementById("rewardPunishDateSpan" ).innerHTML = "<font color='red'>不能为空</font>"; 
          flag++; 
      }else{
       document.getElementById("rewardPunishDateSpan" ).innerHTML ="";
      }
      if (trim(rewordPunishAmount) == "" || !isInteger(rewordPunishAmount)) { 
          document.getElementById("rewordPunishAmountSpan" ).innerHTML = "<font color='red'>格式错误</font>"; 
          flag++; 
      }else{
      	document.getElementById("rewordPunishAmountSpan" ).innerHTML ="";
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
    	reg = /^[-+]?\d+$/;
    	if (!reg.test(obj)) {
      	  return false;
    	} else {
			if(obj*1>0)
				return true;
			else
				return false;
    	}
	}
</script>
<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<script src="/jmjkms/select2/js/select2.full.js"></script>
<script type="text/javascript">
    $(function(){
    	$("#staff").change(function(){
    		var value = $("#staff").val();
    		$.ajax({
			type : "POST",
			url:"staffRewardPunishAction!getStaffNumberPunish.action?staffNumber="+value,//传递参数
			dataType:"json",
			success:function(data){	
			  $("#staffName").html(data[0].name);
			}
			})
    	})
    })
    

</script>
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
<script>
	function Num(obj){
	obj.value = obj.value.replace(/[^\d.]/g,"");
	obj.value = obj.value.replace(/^\./g,""); 
	obj.value = obj.value.replace(/\.{2,}/g,"."); 
	obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
        }
</script>
<script type="text/javascript" src="/jmjkms/js/confirm/Validform_v5.3.2_min.js"></script>
</body>
</html>
