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
  <link rel="stylesheet" href="/jmjkms/select2/css/select2.css">
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
       <h3 class="current-title">会诊记录-新增</h3>
      
      <!-- 删除此行注释，在此添加对应的div -->
         <label>姓名：${healthFile.name}</label>
         <label>档案编号：${healthFile.fileNum}</label>
         
         <div class="table-content">
         <input name="yemianname" value="06203" type="hidden"/>
           <form action="consultationRecordAction!addConsultationRecord.action" method="post" id="registerform" onsubmit="return dosubmit()">
           <table class="table table-bordered">
             <tbody>
               <tr><input type="hidden" name="token" value="${token }" />
                 <input type="hidden" name="healthFileId" value="${ healthFile.healthFileId}" /> 
                 <td><span class="required">*</span>责任医生</td>
                  <td> <select name="consultationRecord.responsibleDoctor" class="js-example-basic-single" class="select2" style="width: 170px;" id="Doctor" datatype="*" nullmsg="责任医生不可为空"  maxlength="5">
                           <s:iterator value="staffs"  status="n"  var="number">
                           <%-- <option value="${number.name}">${number.name}</option> --%>
                           <option value="${number.name}" <c:if test="${tstaff.staffId eq number.staffId}">selected</c:if>>${number.name}</option>
                           </s:iterator>
                          </select>
                 </td>
                <td><span class="required">*</span>会诊时间</td>
                 <td ><input type="text" id="Date" onfocus="this.blur()"  name="consultationRecord.conRecDate" value="${currentTime}" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" ></td>
               </tr>
                <tr >
                 <td>会诊医生及其所在医疗机构</td>
                 <td colspan="7"><textarea   name="consultationRecord.consultationDoctorInstitution" id=""  class="textarea"></textarea></td>
               </tr>
               <tr >
                 <td>会诊原因</td>
                 <td colspan="7"><textarea   name="consultationRecord.consultationReason" id=""  class="textarea"></textarea></td>
               </tr>
               <tr>
                 <td>会诊意见</td>
                 <td colspan="7"><textarea   name="consultationRecord.consultationOpinion" id=""  class="textarea"></textarea></td>
               </tr>
             </tbody>
            </table>

           <div class="btn-content">
             <input  id="submit" type="submit" value="提交" class="btn">
              <a href="javascript:;" class="btn btn-back">返回</a>
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
			alert("会诊时间不可为空")
			return false;
			
		}
	})
</script>
<script src="/jmjkms/select2/js/select2.full.js"></script>

<script type="text/javascript">
	$(function(){
		$(".js-example-basic-single").select2();
	})
</script>
<script type="text/javascript">
		var isCommitted = false;//表单是否已经提交标识，默认为false
		function dosubmit() {
			/* 此处还需要判断各个必填项校验是否通过*/
			//alert("1" + isCommitted);
			if (isCommitted == false
					&& document.getElementById('Date').value != ""&& document.getElementById('Doctor').value != "") {
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
</body>
</html>
