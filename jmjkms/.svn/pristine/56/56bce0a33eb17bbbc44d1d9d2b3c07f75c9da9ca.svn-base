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
  <link rel="stylesheet" href="/jmjkms/css/main.css">
  <link rel="stylesheet" href="/jmjkms/select2/css/select2.css">
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
      <h3 class="current-title">社区义诊 <br></h3>
        <div class="table-content"> 
        <input name="yemianname"  value="05204" type="hidden"/>
          <form id="registerform" onsubmit="return dosubmit()" action="comminityClinicAction!saveComminityClinic.action"  method="post" enctype="multipart/form-data" > 
              <input type="hidden" name="token" value="${token }" />
				  <table class="table table-bordered" style="word-break:break-all">
				    <tbody>
			           <tr>
			           <td><span class="required">*</span>义诊对象</td>
			             <td><input class="temp" id="dx"  type="text" maxLength="10" name="comminityClinic.forPerson" datatype="*" nullmsg="义诊对象不可为空"></td>
			           <td><span class="required">*</span>参与者</td>
			           <td><input class="temp" id="cyz" type="text" maxLength="15" name="comminityClinic.participatePerson" datatype="*" nullmsg="参与者不可为空"></td>
			           </tr>
			           <tr>
			             <td><span class="required">*</span>计划时间</td>
			             <td>
			           <input id="jhsj" type="text" onfocus="this.blur()" name="comminityClinic.planTime" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" id="time0">
			           </td>
			             <td><span class="required">*</span>制定时间</td>
			             <td>
			           <input id="zdsj" type="text" onfocus="this.blur()" name="comminityClinic.formulateTime" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" id="time1" value="${currentTime}">
			           </td>
			           </tr>
			           <tr>
			             <td><span class="required">*</span>制定人</td>
			             <td>
			               <select name="staffsId" id="zdr" class="js-example-basic-single" class="select2" style="width: 170px;" datatype="*" nullmsg="制定人不可为空">
			                <s:iterator value="staffList" var="sta">
	               				<option value="${sta.staffId}" <c:if test="${tstaff.staffId eq sta.staffId}">selected</c:if>>${sta.name}</option> 
	              			 </s:iterator>
			               </select>
			             </td>
			             <td>状态</td>
			             <td><select name="comminityClinic.status" id="">
				             <option value="0">暂缓处理</option>
				             <option value="1">待处理</option>
				             <option value="2">不处理</option>
				             <option value="3">已处理</option>
				             
			            </select> 
			           </td>
			           </tr>
			           <tr>
			             <td>记录义诊内容</td>
			             <td colspan="3"><textarea maxLength="300" name="comminityClinic.content" id=""  class="textarea"></textarea></td>
			           </tr>
			           <tr>
			             <td>备注</td>
			             <td colspan="3"><textarea maxLength="300" name="comminityClinic.note" id=""  class="textarea"></textarea></td>
			           </tr>
			           

                    </tbody> 
                  </table>
                 <div class="btn-content">
                    <input id="submit" type="submit" class="btn" value="保存">
                    <a href="javascript:;" class="btn btn-back">返回</a>
                 </div>
             </form>
            </div> <!-- 表单表格 start -->
      


    </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>

<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<script type="text/javascript" src="/jmjkms/js/confirm/Validform_v5.3.2_min.js"></script>

<script type="text/javascript">
		var isCommitted = false;//表单是否已经提交标识，默认为false
		function dosubmit() {
			/* 此处还需要判断各个必填项校验是否通过*/
			//alert("1" + isCommitted);
			if (isCommitted == false
					&& document.getElementById('dx').value != "" && document.getElementById('cyz').value != ""
					&& document.getElementById('jhsj').value != "" && document.getElementById('zdsj').value != ""
					&& document.getElementById('zdr').value != "") {
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
	</script>

<script type="text/javascript">
	$("form").submit(function(){
		if($("#time0").val()==""){
			alert("计划时间不可为空");
			return false;
		}
		if($("#time1").val()==""){
			alert("制定时间不可为空");
			return false;
		}
	})
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
<script src="/jmjkms/select2/js/select2.full.js"></script>

<script type="text/javascript">
	$(function(){
		$(".js-example-basic-single").select2();
	})
</script>
</body>
</html>
