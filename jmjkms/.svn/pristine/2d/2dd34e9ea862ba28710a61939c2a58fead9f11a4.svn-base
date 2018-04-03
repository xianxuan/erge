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
      <h3 class="current-title">健康数据录入-康复计划添加</h3>
       <input name="yemianname" value="02201" type="hidden"/>
<!-- 搜索容器 start -->
   <div class="table-content">
    <form id="registerform" action="HealthManagerAction!addBPRecoverPlan.action" method="post">
		<input type="hidden" name="token" value="${token }" />
		<input id="current" type="hidden" value="${currentTime}">      
       <input type="hidden" name="healthFileId"  value="${ healthFile.healthFileId}"/> 
        <table class="table table-bordered">
          <tbody>
           <tr>
                  <td><span class="required">*</span>计划名称:</td>
                   <td colspan="2">
                          <input type="text" datatype="*" nullmsg="计划名称不可为空"   class="w150" id="planName" name="planName" value="${recoveryPlan.planName}">
                    <span id="nameTip"  style="color: red;"></span>
                    </td>
         </tr>
        <tr>
       <td><label><span class="required">*</span>方案类型:</label></td>
       <td>
       <select name="recoveryPlan.TRecoveryScheme.type" id="schemeType">
         <option value="个人方案">个人方案</option>
         <option value="专家方案">专家方案</option>
       </select></td>
     </tr>
       <tr>
       <td><span class="required">*</span><label>疾病名称:</label></td>
       <td>
       <select name="recoveryPlan.TRecoveryScheme.disease" id="diseaseName">  
           <option value="">请选择</option>
           <option value="高血压">高血压</option>
           <option value="糖尿病">糖尿病</option>
       </select></td>
     </tr>
     <tr>
           <td>
                     <span class="required">*</span><label>方案名称:</label>
                      </td>
                      <td>
                     <select name="recoveryPlan.TRecoveryScheme.recoverySchemeId" id="scheme" datatype="*" nullmsg="请添加康复方案">
                       <option value="">请选择</option>
                      </select>
           </td>
    </tr>
     <tr>
             <td>
                  <span class="required">*</span><label>开始日期:</label>
                      </td>
                       <td>
                             <input type="text" id="time0" onfocus="this.blur()"  onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" name="recoveryPlan.beginTime" value="${currentTime }">
                               </td>
                               </tr>
     <tr>              <td>
                             <span class="required">*</span> <label>结束日期:</label>
                                </td>
                        <td>
                             <input type="text" id="time1" onfocus="this.blur()" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" name="recoveryPlan.overTime">
                     </td>
        </tr>
        <tr>
          <td>
                     <span class="required">*</span><label>制定人:</label>
                        </td>
                         <td>
                          	<label>${session.tstaff.name }</label>
                          	<input type="hidden" name="TRecoveryPlan.TStaff.name" value="张晓光">
                         </td>
         </tr>
          <tr>
          <td>
                      <span class="required">*</span> <label>制定日期:</label>
                       </td>
                       <td>
                        <input type="text" id="time2" onfocus="this.blur()" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" name="recoveryPlan.constituteTime" value="${currentTime }">
                       </td>
                       </tr>
              <tr>
          <td>
                      <span class="required">*</span> <label>详细康复计划:</label>
                       </td>
                       <td>
                       <textarea name="recoveryPlan.planContent"  datatype="*" nullmsg="详细康复计划不可为空" id=""   class="textarea temp"></textarea>
                       </td>
                       </tr>
         </tbody>
        </table>
   <div class="btn-content">
       <input type="submit"  value="确定" class="btn"> 
       <a href="javascript:;" class="btn btn-back">返回</a>
   </div>
 </form>      
 </div>
 <!-- 表格容器 end -->
    </div>
    <!-- 主容器 end -->
    <s:include value="/include/footer.jsp" />
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
<script>
	   $("#registerform").submit(function(){
	   if($("#time0").val()!=""&&$("#time1").val()!=""){
	   		if($("#time0").val()<$("#current").val()){
    		alert("开始日期小于当前时间");
    		return false;
    	}
	   		if($("#time0").val()>$("#time1").val()){
	   			alert("开始日期大于结束日期");
	   			$("#time0").val("").focus();
	   			return false;
	   		}
	   }
	   
      	if($("#time0").val()==null||$("#time0").val()==""){
      		$("#time0").val("").focus();
      		alert("开始日期不能为空!");
      		return false;
      	}
      	if($("#time1").val()==null||$("#time1").val()==""){
      		$("#time1").val("").focus();
      		alert("结束日期不能为空！");
      		return false;
      	}
      	if($("#time2").val()==null||$("#time2").val()==""){
      		$("#time2").val("").focus();
      		alert("制定日期不能为空");
      		return false;
      	}
      })
</script>
<script type="text/javascript">
 $("#schemeType").change(function(){
 	   $("#scheme").find("option").not(":first").remove();
       getSchema();
 });
 $("#diseaseName").change(function(){
		$("#scheme").find("option").not(":first").remove()
       getSchema();
 });
 
 function getSchema(){
     var type= $("#schemeType").val();
     var name = $("#diseaseName").val();
     if(type !== "" && name !== ""){
         showSchema(type,name);
     }
 }
 
 function showSchema(type,name){
     $.ajax({
		type : "post",
		url : "HealthManagerAction!getRecoverSchema.action",
		dataType: "json",
		data:{
						diseaseName:name,
						schemaType:type
					},
		success : function(data) {
		    if(data.length == 0){
		    	alert("请先去添加康复方案!!!!");  //选择发生变化弹出
		    	return ;
		    }
		    for(var i=0;i<data.length;++i){
		       $("#scheme").append("<option value="+data[i].recoverySchemeId+">"+data[i].schemeName+"</option>");
		    }
		}
	});
 }
 	$("#planName").change(function(){
				var planNameVal = $("#planName").val();
				$.ajax({
				type : "POST",
		        url:"<%=basePath%>chronicManagerAction!checkPlan.action",
				data:{
					planName:planNameVal
				},
				success : function(jsons)
				 {
					$("#nameTip").html(jsons);
				}
				});
			});
</script>

</body>
</html>
