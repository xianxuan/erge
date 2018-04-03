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
      <h3 class="current-title">家庭病床记录-新增</h3>
      
      <!-- 删除此行注释，在此添加对应的div -->
          <div class="search-content">
          <input name="yemianname" value="06206" type="hidden"/>
            <form  id="registerform1" action="familyBedHistoryAction!findFamilyBedHistory.action" method="post">
                 <label>查询选项：</label>
              <select name="flag" id="">
              	<option value="2" <c:if test="${flag eq 2}">selected</c:if>>姓名</option>
                <option value="0" <c:if test="${flag eq 0}">selected</c:if>>档案编号</option>
                <option value="1" <c:if test="${flag eq 1}">selected</c:if>>身份证号</option>
              </select>
              <input id="searchText"  datatype="*"  nullmsg="请输入查询信息"   type="text" class="w150" name="value" value="${value}" >
              <input type="submit" class="btn" value="查询">
              <span class="required">${str}</span>
              <label>姓名：<c:out value="${healthFile.name}"></c:out></label>
              <label>档案编号：<c:out value="${healthFile.fileNum}"></c:out></label>
           </form>
         </div>
         <c:if test="${conFlag==1}">
         <div class="table-content">
           <form action="familyBedHistoryAction!addFamilyBedHistory.action" method="post" id="registerform" onsubmit="return dosubmit()">
           <table class="table table-bordered">
             <tbody>
               <tr>
               <input type="hidden" name="token" value="${token }" />
                 <input type="hidden" name="healthFileId" value="${healthFile.healthFileId}" /> 
                  <td><span class="required">*</span>医疗机构名称</td>
                 <td ><input id="name" type="text"    name="familyBedHistory.institution" datatype="*" nullmsg="医疗机构名称不可为空"></td>
                  <td><span class="required">*</span>病案号</td>
                 <td ><input id="number" type="text"   name="familyBedHistory.medicalNum"  nullmsg="病案号不可为空" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"></td>
                 <td><span class="required">*</span>建床日期</td>
                 <td ><input type="text" class="startTime"  onfocus="this.blur()"  id="Date" name="familyBedHistory.buildBedDate" value="${currentTime}" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" ></td>
                 
                 <td>撤床时间</td>
                 <td ><input type="text" class="endTime" onfocus="this.blur()"  name="familyBedHistory.fromBedDate" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"></td>
               </tr>
                <tr>
                 <td>原因</td>
                 <td colspan="7"><textarea    name="familyBedHistory.reason" id=""  class="textarea"></textarea></td>
               </tr>
               <tr>
                 <td>备注</td>
                 <td colspan="7"><textarea    name="familyBedHistory.note" id=""  class="textarea"></textarea></td>
               </tr>
             </tbody>
            </table>

           <div class="btn-content">
             <input id="submit" type="submit" value="提交" class="btn">
              <a href="familyBedHistoryAction!showFamilyBedHistory.action" class="btn ">返回</a>
           </div>
           </form>
          </div>

</c:if>
	 <div id="showwindow" class="table-content"" id="button_alert_2">
 			<h3 class="current-title">查询结果</h3>
 			<table class="table table-bordered">
  			<thead>
			<tr>
				<th>姓名</th>
				<th>身份证号</th>
			</tr>
			</thead>
			<tbody>
				<s:iterator value="listolder" var="lo">
					<tr>
					<td><a href="<%=basePath %>familyBedHistoryAction!ReOlder.action?healthFileId=${lo.healthFileId}" id="btn_write_off">${lo.name}</a></td>
					<td>${lo.idNum}</td>
				</s:iterator>
			</tbody>
			</table>
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
	$("#registerform").submit(function(){
		if($("#Date").val()==""){
			alert("建床日期不可为空")
			return false;
			
		}
	})
</script>

 <script type="text/javascript">
		$(function() {
			$("#registerform1").Validform({
				//btnSubmit:".btn_sub",
				showAllError : false,
				tiptype : function(msg) {
					alert(msg);
				}
			});
		});
	</script>
		<%-- <script type="text/javascript">
		var isCommitted = false;//表单是否已经提交标识，默认为false
		function dosubmit() {
			/* 此处还需要判断各个必填项校验是否通过*/
			//alert("1" + isCommitted);
			if (isCommitted == false
					&& document.getElementById('Date').value != ""&& document.getElementById('name').value != ""&& document.getElementById('number').value != "") {
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
	$(function(){
		var show=${showwindow};
		if(show){
			$("#showwindow").css("display","block");
		}else
		{
			$("#showwindow").css("display","none");
		}
	})

</script>
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
