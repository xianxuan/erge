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
  <link rel="stylesheet" href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">
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
      <h3 class="current-title">住院记录-修改</h3>
      
      <!-- 删除此行注释，在此添加对应的div -->
      <label>姓名：${healthFile.name}</label>
         <label>档案编号：${healthFile.fileNum}</label>
      <div class="table-content">
      <input name="yemianname" value="06207" type="hidden"/>
        <form id="registerform" action="inHospitalHistoryAction!updateInHospitalHistory.action" ,method="post" onsubmit="return dosubmit()">
        <table class="table table-bordered">
          <tbody>
             <tr>
             <input type="hidden" name="token" value="${token }" />
              <input type="hidden" name="healthFileId" value="${healthFile.healthFileId}"/>
              <input type="hidden" name="inHospitalHistory.inHospitalHistoryId" value="${inHospitalHistory.inHospitalHistoryId}"/>
              <td ><span class="required">*</span>医疗机构名称</td>
                  <td>
                    <input id="name" type="text"    name="inHospitalHistory.institution" value="${inHospitalHistory.institution}" datatype="*" nullmsg="医疗机构名称不可为空"></input>
                  </td> 
                  <td ><span class="required">*</span>病案号</td>
                  <td>
                    <input  id="number" type="text"  name="inHospitalHistory.medicalRecord" value="${inHospitalHistory.medicalRecord}" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" datatype="*" nullmsg="病案号" errormsg="输入有误"></input>
                  </td> 
              <td><span class="required">*</span>入院时间</td>
              <td>
                    <input type="text" class="startTime" id="Date" onfocus="this.blur()" name="inHospitalHistory.inDate" value="${inHospitalHistory.inDate}" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" datatype="*" nullmsg="入院时间不可为空"></input>
              </td>
              <td>出院时间</td>
              <td>
                    <input type="text"  class="endTime" onfocus="this.blur()"  name="inHospitalHistory.outDate" value="${inHospitalHistory.outDate}" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"></input>
              </td>
              
                  
                 
               
                </tr>
                <tr>
                  <td>原因</td>
                  <td colspan="7">
                  <textarea    name="inHospitalHistory.reason" id=""  class="textarea">${inHospitalHistory.reason}</textarea>
                  </td>
                </tr>
                <tr>
                  <td>备注</td>
                  <td colspan="7">
                  <textarea    name="inHospitalHistory.note" id=""  class="textarea">${inHospitalHistory.note}</textarea>
                  </td>
            </tr>
            </tbody>
            </table>
             <div class="btn-content">
                <input id="submit" type="submit" value="提交" class="btn">
               <a href="inHospitalHistoryAction!showInHospitalHistory.action" class="btn btn-back">返回</a>
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
<script type="text/javascript" src="/jmjkms/js/confirm/jquery-1.9.1.min.js"></script>
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
		if($("#Date").val()==""){
			alert("入院时间不可为空")
			return false;
			
		}
	})
</script>
<%-- <script type="text/javascript">
		var isCommitted = false;//表单是否已经提交标识，默认为false
		function dosubmit() {
			/* 此处还需要判断各个必填项校验是否通过*/
			//alert("1" + isCommitted);
			if (isCommitted == false
					&& document.getElementById('number').value != ""&& document.getElementById('Date').value != ""&& document.getElementById('name').value != "") {
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
	</script> --%>
	<script type="text/javascript">
 $("form").submit(function(){
    	var startTime0=$(".startTime").eq(0).val();
    	var startTime1=$(".startTime").eq(1).val();
    	var endTime0=$(".endTime").eq(0).val();
    	var endTime1=$(".endTime").eq(1).val();
    	if(startTime0 != ""&&endTime0 != ""){
    	if(startTime0>endTime0){
      	 	$(".startTime").eq(0).val("");
       		$(".endTime").eq(0).val("");
       		alert("查询时间输入错误");
       		return false;
       	}
       	}
       	if(startTime1 != ""&&endTime1 != ""){
    	if(startTime1>endTime1){
      	 	$(".startTime").eq(1).val("");
       		$(".endTime").eq(1).val("");
       		alert("查询时间输入错误");
       		return false;
       	}
       	}
    })
</script>
</body>
</html>
