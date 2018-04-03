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
.addHospital{
	max-width: 100%;
	margin-bottom: 10px;
	border-spacing: 0;
	border-collapse: collapse;
	font-size: 12px;
}
.addHospital td{
	height:40px;
	/* width:100px; */
}
.addHospital tr{
	margin-bottom:100px;
}
.addHospital input,select{
	margin-left:25px;
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
		<h3 class="current-title">增加医院</h3>
      
		<!-- 删除此行注释，在此添加对应的div -->
		<div class="table-content">
		<input name="yemianname" value="10201" type="hidden"/>
			<form id="registerform" onsubmit="return dosubmit()" class="check-form" action="<%=basePath %>communityHospitalAction!addHospital.action" method="post">
        		<input type="hidden" name="token" value="${token }" />
        		<table class="addHospital">
         			<tbody>
            			<tr>
              				<td><span class="required">*</span>医院名称</td>
              				<td>	
                				<input class="temp"  id="com" type="text" maxlength="12" name="ccommunityHospital.communityHospital" value="<c:out value='${ccommunityHospital.communityHospital}'></c:out>" nullmsg="不可为空" datatype="*"></input>
              				</td>
              				<td>
              					<label class="Validform_checktip message-yiyuan"></label>
              					<label id="errormessage">&nbsp;&nbsp;<img src="/jmjkms/images/error.png">已存在该医院!</label>
              				</td>
            			</tr>
            			<tr>
              				<td><span class="required">*</span>医院编码</td>
              				<td>
                				<input id="code" type="text" onkeyup="value=value.replace(/[^\w]/ig,'')" name="ccommunityHospital.hospitalCode" value="<c:out value='${ccommunityHospital.hospitalCode}'></c:out>" nullmsg="不可为空" errormsg="请填写12位数字" maxlength="12" datatype="n12-12"></input>
              				</td>
              				<td>
              					<label class="Validform_checktip message-code"></label>
              					<label id="errormessage5">&nbsp;&nbsp;<img src="/jmjkms/images/error.png">该编码已经登记!</label>
              				</td>
            			</tr>
            			<tr>
              				<td><span class="required">*</span>医院地址</td>
              				<td>
                				<input class="temp"  id="address" type="text" maxlength="20" name="ccommunityHospital.address" value="<c:out value='${ccommunityHospital.address}'></c:out>" nullmsg="不可为空" datatype="*"></input>
              				</td>
              				<td>
              					<label class="Validform_checktip"></label>
              				</td>
            			</tr>            
            			<tr>
              				<td><span class="required">*</span>医院等级</td>
                			<td>
	                    		<select id="grade" name="ccommunityHospital.hospitalLevel" id="" nullmsg="不可为空" datatype="*">
	                      			<option value=""<c:if test="${'' eq ccommunityHospital.hospitalLevel}">selected="selected"</c:if>>请选择</option>
	                      			<s:iterator value="listDengJi" var="m1">
	                      			<option value="${m1.name}" <c:if test="${m1.name eq ccommunityHospital.hospitalLevel}">selected="selected"</c:if>>${m1.name}</option>
	                      			</s:iterator>
	                    		</select>
                			</td>
                			<td>
              					<label class="Validform_checktip"></label>
              				</td>
            			</tr>
            			<tr>
              				<td><span class="required">*</span>负责人</td>
              				<td>
                				<input class="temp"  id="host" type="text" name="ccommunityHospital.name" maxlength="10" value="<c:out value='${ccommunityHospital.name}'></c:out>" nullmsg="不可为空" datatype="*"></input>
				           	</td>
				           	<td>
              					<label class="Validform_checktip"></label>
              				</td>
						</tr>
						<tr>
							<td><span class="required">*</span>账号</td>
              				<td>
                				<input id="loginin" placeholder="填写6-18位字母 数字 下划线组合" style="font-size:10px; width:149px; height:20px;" onkeyup="value=value.replace(/[^\w]/ig,'')" type="text" maxlength="18" name="ccommunityHospital.login" value="<c:out value='${ccommunityHospital.login}'></c:out>" nullmsg="不可为空" errormsg="请填写6到18位数字、字母或下划线" datatype="*6-18"></input>
              				</td>
              				<td>
              					<label class="Validform_checktip message-login"></label>
              					<label id="errormessage1">&nbsp;&nbsp;<img src="/jmjkms/images/error.png">已存在该账号!</label>
              				</td>
            			</tr>
            			<tr>
              				<td><span class="required">*</span>电话</td>
              				<td>
                				<input id="phone" type="text" onkeyup="value=value.replace(/[^\w]/ig,'')" name="ccommunityHospital.phone" maxlength="15" value="<c:out value='${ccommunityHospital.phone}'></c:out>" nullmsg="不可为空" datatype="*"></input>
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
                    			<select name="ccommunityHospital.status" id="">
	                      				<!-- <option  value="0">启用</option>
	                      				<option  value="1">禁用</option> -->
	                      			<option value="0" <c:if test="${'0' eq ccommunityHospital.status}">selected="selected"</c:if>>启用</option>
                      				<option value="1" <c:if test="${'1' eq ccommunityHospital.status}">selected="selected"</c:if>>禁用</option>
                    			</select>
                			</td>
            			</tr>
            		</table>
            		<table class="table">
            			<tr>
              				<td>说明</td>
               				<td>
                 				<textarea name="ccommunityHospital.note" value="<c:out value='${ccommunityHospital.note}'></c:out>" id=""  class="textarea"></textarea>
              				</td>
             			</tr>
          			</tbody>
       			</table>
       			<div class="btn-content">
          			<input id="btnsubmit" onclick="checkagain();" type="submit" class="btn" value="确定">
          			<a href="<%=basePath %>communityHospitalAction!getHospitalList.action" class="btn">返回</a>
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
  <script type="text/javascript" src="/jmjkms/js/confirm/Validform_v5.3.2_min原版.js"></script>
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
<script type="text/javascript">
	function checkTel(){
		var value=$("input[name='ccommunityHospital.phone']").val();
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

</script>
<script type="text/javascript">
function hosname(){
	var name = $("input[name='ccommunityHospital.communityHospital']").val();
	var errormsg = $("#errormessage");
	var messageyiyuan = $(".message-yiyuan");
	var a=false;
	$.ajax({   
       type:"POST", //请求方式  
       url:"communityHospitalAction!ifHaveComHosName.action", //请求路径 
       data:{
		      "name":name,
		    },
	   async:false,
       dataType: "json",   //返回值类型  
       success:function(result){
       		if(result=="0")
       		{
	       		errormsg.show();
	       		messageyiyuan.hide();
	       		a = false;
       		}
       		else{
       			errormsg.hide();
       			messageyiyuan.show();
       			a = true;
       		}
       }
       });
	return a;
   };
   
function loginname(){
	var login =$("input[name='ccommunityHospital.login']").val();
	var errormsg1= $("#errormessage1");
	//var errormsg3= $("#errormessage3");
	var messagelogin = $(".message-login");
	var b=false;
	 $.ajax({
       type:"POST", //请求方式  
       url:"communityHospitalAction!ifHaveLogin.action", //请求路径 
       data:{
		      "login":login,
		    },
		    async:false,
       dataType: "json",   //返回值类型  
       success:function(result){
       		if(result=="0")
       		{
	       		errormsg1.show();
	       		messagelogin.hide();
	       		b=false;
       		}
       		else if(result=="1"){
       			errormsg1.hide();
       			messagelogin.show();
       			b=true;
       		}
       }
       });
	 return b;
   };
   
   function hospitalCode(){
	    var code =$("input[name='ccommunityHospital.hospitalCode']").val();
	    var errormsg5= $("#errormessage5");
	    //var errormsg3= $("#errormessage3");
	    var messagecode = $(".message-code");
	    var b=false;
	     $.ajax({
	       type:"POST", //请求方式  
	       url:"communityHospitalAction!ifHaveCode.action", //请求路径 
	       data:{
	              "hospitalCode":code,
	            },
	            async:false,
	       dataType: "json",   //返回值类型  
	       success:function(result){
	            if(result=="0")
	            {
	                errormsg5.show();
	                messagecode.hide();
	                b=false;
	            }
	            else if(result=="1"){
	                errormsg5.hide();
	                messagecode.show();
	                b=true;
	            }
	       }
	       });
	     return b;
	   };
</script>
<script type="text/javascript">
$(function (){
	hosname();
	loginname();
	$("input[name='ccommunityHospital.communityHospital']").blur(function(){document.getElementById("btnsubmit").disabled=false;hosname();});
	$("input[name='ccommunityHospital.login']").blur(function(){document.getElementById("btnsubmit").disabled=false;loginname();} );
	$("input[name='ccommunityHospital.phone']").blur(function(){document.getElementById("btnsubmit").disabled=false;checkTel();});
	$("input[name='ccommunityHospital.hospitalCode']").blur(function(){document.getElementById("btnsubmit").disabled=false;hospitalCode();});
});

function checkagain(){
	var a=hosname();
    var b=loginname();
    var c=checkTel();
    var d=hospitalCode();
    if(a&&b&&c&&d)
        {
        document.getElementById("btnsubmit").disabled=false;
        }
    else{
        document.getElementById("btnsubmit").disabled=true;
    }
}
</script>
<!--  防止表单提交 -->
	<script type="text/javascript">
		var isCommitted = false;//表单是否已经提交标识，默认为false
		function dosubmit() {
			/* 此处还需要判断各个必填项校验是否通过*/
			//alert("1" + isCommitted);
			if (isCommitted == false
					&& document.getElementById('com').value != ""
					&& document.getElementById('code').value != ""
					&& document.getElementById('address').value != ""
					&& document.getElementById('host').value != ""
					&& document.getElementById('grade').value != ""
					&& document.getElementById('loginin').value != ""
					&& document.getElementById('phone').value != "") {
				//提交表单后，将表单是否已经提交标识设置为true
				isCommitted = true;

			//获取表单提交按钮
		    var btnSubmit = document.getElementById("btnsubmit");
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
