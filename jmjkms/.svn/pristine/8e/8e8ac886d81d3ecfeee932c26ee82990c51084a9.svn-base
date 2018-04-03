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
  <link rel="stylesheet" type="text/css" href="css/sweetalert.css"> 
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
      <h3 class="current-title">血氧档案-详细数据</h3>
       <input name="yemianname" value="02201" type="hidden"/>
       <div class="search-content">
          <div class="btn-content">
             <a href="HealthManagerAction!getBloodOxygenFromCloud.action?bloodForward=0&healthFileId=${localHealthFile.healthFileId }" class="btn btn-default">数据分析</a>
            <a href="HealthManagerAction!getBloodOxygenFromCloud.action?bloodForward=1&healthFileId=${localHealthFile.healthFileId }" class="btn btn-default">趋势分析</a>
            <a href="HealthManagerAction!getBloodOxygenFromCloud.action?bloodForward=2&healthFileId=${localHealthFile.healthFileId }" class="btn ">详细数据</a>
          </div>
      </div>
      <form action="HealthManagerAction!bloodOxygenDataDetail.action" method="post">
       <div class="search-item">
           <s:radio name="searchType" cssClass="type" list="#{'0':'按时间查询','1':'按数量查询'}" label="请选择查询类型" ></s:radio>
            <label><input type="hidden" name="healthFileId" value="${localHealthFile.healthFileId }" /></label>
             </div>
               <div class="search-item">
               <div id="time" style="display: inline-block;">
                  <label>时间:<input type="text" id="startTime" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" value="<fmt:formatDate value="${startTime }" pattern="yyyy-MM-dd HH:mm:ss"/>" name="startTime" onfocus="this.blur()">
                                                            至
                  <input type="text" id="endTime" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" value="<fmt:formatDate value="${endTime }" pattern="yyyy-MM-dd HH:mm:ss"/>" name="endTime" onfocus="this.blur()">
               </label>
               </div>
                  <div  id="size" style="display:none;">
                  <label >最近信息条数：</label>
                   <input type="text" class="w40" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength='10' 
                   name="totalSize" id="num" value="${ totalSize}">
                </div>
                 <input type="submit" id="sub" class="btn" value="查询">
                </div>
                </form>
       <!-- 表单表格 start -->
   <div class="table-content">
       <table class="table table-bordered">
         <tbody>
           <tr>
             <td colspan="9" class="title-td">详细数据</td>
           </tr>
           <tr>
             <td>姓名</td>
             <td>测量条件</td>
             <td>服用药物</td>
             <td>测量时间</td>
             <td>血氧值(%)</td>
             <td>脉搏率(次/min)</td>
             <td>异常报警</td>
             <td>血氧结果分析</td>
             <td class="caozuo">操作</td>
           </tr>
         <s:iterator value="bloodOxygenList" var="bol"> 
           <tr>
             <td>${localHealthFile.name}</td>
             <c:if test="${bol.meaState==0 }"><td>静息</td></c:if>
             <c:if test="${bol.meaState==1 }"><td>运动后</td></c:if>
             <c:if test="${bol.takeMed!= 1}"><td>未服</td></c:if>
             <c:if test="${bol.takeMed==1}"><td>${bol.medName}</td></c:if>
             <td>${bol.meaTime}</td>
             <td>${bol.oxygen}</td>
             <td>${bol.pulse}</td>
              <c:if test="${bol.abnAlarm==0 }"><td>报警</td></c:if>
             <c:if test="${bol.abnAlarm==1 }"><td>不警报</td></c:if>
             <td>${bol.analysisResult}</td>
             <td class="caozuo">
               <a class="btn-xiugai" href="HealthManagerAction!toEditBOCloud.action?bloodOxygen.meaTime=${bol.meaTime}&healthFileId=${localHealthFile.healthFileId }&bloodOxygen.id=${bol.id}&bloodOxygen.meaState=${bol.meaState}&bloodOxygen.oxygen=${bol.oxygen}&bloodOxygen.pulse=${bol.pulse}&bloodOxygen.takeMed=${bol.takeMed}&bloodOxygen.medName=${bol.medName}&bloodOxygen.abnAlarm=${bol.abnAlarm}&bloodOxygen.analysisResult=${bol.analysisResult}">修改</a>
               <a class="btn-shanchu" href="HealthManagerAction!deleteBloodOxygenDataCloud.action?cloudId=${bol.id}&healthFileId=${localHealthFile.healthFileId }" onclick="return confirm('确认删除')">删除</a>
              </td> 
           </tr>
         </s:iterator> 
         </tbody>
       </table>
        <div class="page">
				${pageHtml}
	    </div>
        <div class="btn-content">
             <a href="HealthManagerAction!getDataFromCloud.action?healthFileId=${localHealthFile.healthFileId}" class="btn btn-xianshi">返回</a>
        </div>
   </div>
   <!-- 表单表格 start -->
    </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>

<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<script src="js/sweetalert.min.js"></script> 
<script src="/jmjkms/js/healthManager.js"></script>
<script type="text/javascript">
	$(function(){
	var person=${person};
	 if(person=='0'){
		$('.caozuo').remove();
	  }
	});
</script>
<script type="text/javascript">
	$(function(){
		var searchType=${searchType};
		if(searchType==1){
		 document.getElementsByName('searchType')[1].checked=true; 
	 }	
	 else{
	 	 document.getElementsByName('searchType')[0].checked=true;
	 } 
	})
</script>
<script type="text/javascript">
 $("form").submit(function(){
    	var startTime0=$("#startTime").val();
    	var endTime0=$("#endTime").val();
    	if(startTime0 != ""||endTime0 != ""){
    	if(startTime0>endTime0){
      	 	$("#startTime").val("");
       		$("#endTime").val("");
       		alert("查询时间输入错误");
       		return false;
       	}
       	}
       	 if(startTime0=="" && endTime0=="" && $("#num").val()==""){
       		alert("请输入正确查询条件!")
       		return false;
       		}
       		if($("#num").val()!="" && $("#num").val()==0){
       			alert("请输入正确查询条件!")
       		return false;
       		}
    })
</script>
<script type="text/javascript">
$(function(){
          var value = ${searchType}+"";
          hiddenSearch(value);
     }); 
$(".type").change(function(){hiddenSearch($(this).val())});
function hiddenSearch(value){
	if(value==="0"){
	    $("#time").css("display","inline-block");
	    $("#size").css("display","none");
	}
    if(value==="1"){
	     $("#time").css("display","none");
	     $("#size").css("display","inline-block"); 
	}
}; 
</script>
</body>
</html>
