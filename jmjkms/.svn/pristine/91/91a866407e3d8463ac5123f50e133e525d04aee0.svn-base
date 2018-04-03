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
   <link rel="stylesheet" href="/jmjkms/css/confirm.css">
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
      
      <h3 class="current-title">长期用药记录-修改</h3>
      
      <!-- 删除此行注释，在此添加对应的div -->
         
               <label>姓名：${healthFile.name}</label>
              <label>档案编号：${healthFile.fileNum}</label>
     
         <div class="table-content">
         <input name="yemianname" value="06205" type="hidden"/>
           <form id="registerform" action="medicalRecordAction!updateMedicalRecord.action" method="post" onsubmit="return dosubmit()">

           <table class="table table-bordered">
             <tbody>
             <input type="hidden" name="token" value="${token }" />
               <input type="hidden" name="healthFileId" value="${healthFile.healthFileId}"/>
             <input type="hidden" name="medicalRecord.medicalRecordId" value="${medicalRecord.medicalRecordId}"/>
              
               <tr>
                <td><span class="required">*</span>药物名称</td>
                 <td ><input id="name" type="text"    name="medicalRecord.drugName" value="${medicalRecord.drugName}" datatype="*" nullmsg="药物名称不可为空"></td>
                 <td><span class="required">*</span>开始用药时间</td>
                 <td ><input class="startTime" type="text" id="Date" onfocus="this.blur()"  name="medicalRecord.beginDate"  value="${medicalRecord.beginDate}" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" ></td>
                 <td>停药时间</td>
                 <td ><input class="endTime" type="text" onfocus="this.blur()"  name="medicalRecord.stopDate" value="${medicalRecord.stopDate}" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"></td>
                
                 <td>用法</td>
                 <td ><input type="text"    name="medicalRecord.usages" value="${medicalRecord.usages}" ></td>
               </tr>
               <tr>
                 <td>用量</td>
                 <td ><input type="text"    name="medicalRecord.dosage" value="${medicalRecord.dosage}" ></td>
               </tr>
                <tr>
                 <td>药物依从性</td>
                 <td colspan="7"><textarea    name="medicalRecord.medicationAdherence" id=""  class="textarea">${medicalRecord.medicationAdherence}</textarea></td>
               </tr>
               <tr>
                 <td>备注</td>
                 <td colspan="7"><textarea    name="medicalRecord.note" id=""  class="textarea">${medicalRecord.note}</textarea></td>
               </tr>
             </tbody>
            </table>

           <div class="btn-content">
             <input id="submit" type="submit" value="提交" class="btn">
              <a href="medicalRecordAction!showMedicalRecord.action" class="btn btn-back">返回</a>
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
<script src="/jmjkms/js/confirm/Validform_v5.3.2_min.js"></script>
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
			alert("开始用药时间不可为空")
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
					&& document.getElementById('name').value != ""&& document.getElementById('Date').value != "") {
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
