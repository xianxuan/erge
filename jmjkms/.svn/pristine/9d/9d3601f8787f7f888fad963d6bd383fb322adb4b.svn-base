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
  <link rel="stylesheet" href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="/jmjkms/css/confirm.css">
  
<style>
.msg-td{
	width:150px !important;
}
.addHospital{
	max-width: 100%;
	margin-bottom: 10px;
	border-spacing: 0;
	border-collapse: collapse;
	font-size: 12px;
}
.addHospital td{
	height:40px;
	width:100px;
}
.addHospital tr{
	margin-bottom:100px;
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
      	<h3 class="current-title">编辑医院</h3>
      
      <!-- 删除此行注释，在此添加对应的div -->
		<div class="table-content">
		<input name="yemianname" value="10201" type="hidden"/>
		
      		<form id="registerform" onsubmit="return dosubmit()" action="<%=basePath %>communityHospitalAction!editHospital.action">
        		<input type="hidden" name="token" value="${token }" />
        		<table class="addHospital">
        		
         			<tbody>
            			<tr>
              				<td>
              					<input id="comHosId" type="hidden" value="${ ccommunityHospital.communityHospitalId}" name="comHosId"></input>
              				医院名称
              				</td>
              				<td>
                				<label><c:out value="${ccommunityHospital.communityHospital }"></c:out></label>
              				</td>
            			</tr>
            			<tr>
              				<td>医院编码</td>
              				<td>
                				<label><c:out value="${ccommunityHospital.hospitalCode}"></c:out></label>
              				</td>
            			</tr>
            			<tr>
	              			<td><span class="required">*</span>医院地址</td>
	              			<td>
	                			<input class="temp"  id="address" type="text" name="address" value="<c:out value='${ccommunityHospital.address}'></c:out>"  nullmsg="不可为空" datatype="*"></input>
	              			</td>
	              			<td class="msg-td">
	              				<label class="Validform_checktip"></label>
	              			</td>
            			</tr>            
            			<tr>
              				<td><span class="required">*</span>医院等级</td>
                			<td>
                    			<select id="grade" name="hospitalLevel" id="" >
	                      			<s:iterator value="listDengJi" var="m1">
	                      			<option value="${m1.name}"<c:if test="${m1.name eq ccommunityHospital.hospitalLevel}">selected="selected"</c:if>>${m1.name}</option>
	                      			</s:iterator>
                    			</select>
                			</td>
                			<td class="msg-td">
              					<label class="Validform_checktip"></label>
              				</td>
            			</tr>
            			<tr>
              				<td><span class="required">*</span>负责人</td>
              				<td>
                				<input class="temp"  id="host" type="text" name="name" value="<c:out value='${ccommunityHospital.name}'></c:out>"  nullmsg="不可为空" datatype="*">
              				</td>
              				<td class="msg-td">
              					<label class="Validform_checktip"></label>
              				</td>
            			</tr>
            			<tr>
              				<td>账号</td>
              				<td>
                				<label><c:out value="${ccommunityHospital.login}"></c:out></label>
              				</td>
            			</tr>
            			<tr>
              				<td><span class="required">*</span>电话</td>
              				<td>
                				<input id="phone" type="text" onkeyup="value=value.replace(/[^\w]/ig,'')" name="phone" maxlength="15" value="<c:out value='${ccommunityHospital.phone}'></c:out>" nullmsg="不可为空" datatype="*"></input>
              				</td>
              				<td>
              					<label class="Validform_checktip message-phone"></label>
              					<label id="errormessage2">&nbsp;&nbsp;<img src="/jmjkms/images/error.png">请填写正确的电话号码!</label>
              					<label id="errormessage6">&nbsp;&nbsp;<img src="/jmjkms/images/error.png">该电话号码已经登记!</label>
              				</td>
            			</tr>
            			<tr>
              				<td><span class="required">*</span>状态</td>
               				<td>
                    			<select name="status" id="" >
                      				<option value="0" <c:if test="${'0' eq ccommunityHospital.hospitalLevel }">selected="selected"</c:if>>启用</option>
                      				<option value="1" <c:if test="${'1' eq ccommunityHospital.hospitalLevel }">selected="selected"</c:if>>禁用</option>       
                    			</select>
                			</td>
                			<td class="msg-td">
              					<label class="Validform_checktip"></label>
              				</td>
            			</tr>
            			</table>
            			<table class="table">
            			<tr>
              				<td>说明</td>
               				<td>
                 				<textarea name="note" id=""  class="textarea"  ><c:out value="${ccommunityHospital.note }"></c:out></textarea>
              				</td>
             			</tr>
          			</tbody>
       			</table>
       			<div class="btn-content">
          			<input id="submit" type="submit" onclick="checkagain();" class="btn" value="确定">
          			<a href="<%=basePath %>communityHospitalAction!getHospitalList.action" class="btn btn-back">返回</a>
      			</div>
     		</form>
   		</div>	
	</div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>

<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<script type="text/javascript" src="/jmjkms/js/confirm/Validform_v5.3.2_min原版.js"></script>
<script type="text/javascript">
    $(function(){
    	$("input[name='phone']").blur(function(){document.getElementById("submit").disabled=false;checkTel();});
      $("#registerform").Validform({
        showAllError:false,
        tiptype:2
      });
  });
</script>
<script type="text/javascript">
	function checkTel(){
		var value=$("input[name='phone']").val();
		var comHosId=$("input[name='comHosId']").val();
		var errormsg = $("#errormessage2");
		var errormsg6 = $("#errormessage6");
		var messagephone = $(".message-phone");
		var isPhone =/^0\d{2,3}-?\d{7,8}$/; 
		var isMob=/^((\+?86)|(\(\+86\)))?(13[012356789][0-9]{8}|15[012356789][0-9]{8}|18[02356789][0-9]{8}|147[0-9]{8}|1349[0-9]{7})$/;
		var Mob400=/^400[0-9]{7}$/;
        var Mob958=/^95\d{6}$/;
        var Mob955=/^95\d{3}$/;
        if(isMob.test(value)||isPhone.test(value)||Mob400.test(value)||Mob958.test(value)||Mob955.test(value)){
            errormsg.hide();
            var a=false;
            $.ajax({   
                type:"POST", //请求方式  
                url:"communityHospitalAction!ifHavePhonenum.action", //请求路径 
                data:{
                       "phone":value,
                       "comHosId":comHosId,
                     },
                async:false,
                dataType: "json",   //返回值类型  
                success:function(result){
                     if(result=="0")
                     {
                         errormsg6.show();
                         messagephone.hide();
                         a = false;
                     }
                     else{
                         errormsg6.hide();
                         messagephone.show();
                         a = true;
                     }
                }
                });
            
            return a;
        }else{
            errormsg.show();
            errormsg6.hide();
            messagephone.hide();
            return false;
        }
    }

	function checkagain(){
	    var c=checkTel();
	    if(c)
	        {
	        document.getElementById("submit").disabled=false;
	        }
	    else{
	        document.getElementById("submit").disabled=true;
	    }
	}
</script>
</body>
</html>
