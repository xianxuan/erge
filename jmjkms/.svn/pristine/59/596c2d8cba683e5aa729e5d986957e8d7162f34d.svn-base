<%@page import="java.text.SimpleDateFormat"%>
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
  <script src="js/sweetalert.min.js"></script> 
</head>
<body>
  <!-- 顶栏 start -->
  <c:choose>
		<c:when test='${embeded }'>
		</c:when>
		<c:otherwise>
			<s:include value="/include/header.jsp" />
		</c:otherwise>
	</c:choose>
  <!-- 顶栏 end -->
  <div class="main-content clearfix">
    <!-- 主菜单 start -->
    <c:choose>
			<c:when test='${embeded }'>
			</c:when>
			<c:otherwise>
				<s:include value="/include/nav.jsp" />
			</c:otherwise>
		</c:choose>
    <!-- 主菜单 end -->
     <!-- 主容器 start -->
    <div class="container">
      <h3 class="current-title">健康一体机档案-详细数据</h3>
      <input name="yemianname" value="02201" type="hidden"/>
       <div class="search-content">
          <div class="btn-content">
            <a href="HealthManagerAction!getAllInOneFromCloud.action?bloodForward=0&healthFileId=${localHealthFile.healthFileId }&embeded=${embeded}" class="btn btn-default">数据分析</a>
            <a href="HealthManagerAction!getAllInOneFromCloud.action?bloodForward=1&healthFileId=${localHealthFile.healthFileId }&embeded=${embeded}" class="btn btn-default">趋势分析</a>
            <a href="HealthManagerAction!getAllInOneFromCloud.action?bloodForward=2&healthFileId=${localHealthFile.healthFileId }&embeded=${embeded}" class="btn">详细数据</a>
        </div>
      </div>
       <!-- 表单表格 start -->
   <div class="table-content">
     <form action="HealthManagerAction!allInOneDataDetail.action" method="post">
              <div class="search-item">   
           		<s:radio name="searchType" cssClass="type" list="#{'0':'按时间查询','1':'按数量查询'}" value="0" label="请选择查询类型" ></s:radio>
            	<label><input type="hidden" name="healthFileId" value="${localHealthFile.healthFileId }" /></label>
            </div>
               <div class="search-item">
               <div id="time" style="display: inline-block;">
                	<label>时间： <input type="text" id="startTime" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" value="<fmt:formatDate value="${startTime }" pattern="yyyy-MM-dd HH:mm:ss"/>" name="startTime" onfocus="this.blur()">
                                                            至
                  	<input type="text" id="endTime" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" value="<fmt:formatDate value="${endTime }" pattern="yyyy-MM-dd HH:mm:ss"/>" name="endTime" onfocus="this.blur()">
               		</label>
               </div>
                  <div id="size" style="display:none;">
                  <label >最近信息条数：</label>
                   <input type="text" class="w40" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength='10' 
                   name="totalSize" id="num"  value="${ totalSize}">
                  </div>
                  <input type="submit" id="sub" class="btn" value="查询">
                  <input type='hidden' id='embeded' name='embeded' value='${embeded}'/>
                </div>
             </form>
            <table  class="table table-bordered">
            <tbody>
               <tr>
             <td colspan="9" class="title-td">血压详细数据</td>
           </tr>
             <tr>
             <td>姓名</td>
             <td>身高(cm)</td>
             <td>体重(kg)</td>
             <td>基础代谢值(kcal)</td>
             <td>BMI值</td>
             <td>测量时间</td>
             <td>详细数据</td>
           </tr>
           <s:iterator value="aios" var="ao">
           <tr>
             <td>${localHealthFile.name}</td>
             <td>${ao.height*100}</td>
             <td>${ao.weight}</td>
             <td>${ao.muscle}</td>
             <td>${ao.bmi}</td>
             <td>${ao.meaTime}</td>
             <td>
               <a class="btn-xianshi" href="javascript:;" onclick="alertDetail('${ao.diaPre}','${ao.pulse}','${ao.temperature}','${ao.fbs}','${ao.pbs}','${ao.rbs}','${ao.oxygen}','${ao.fat}','${ao.height*100}','${ao.weight}','${ao.muscle}','${ao.bmi}','${ao.meaTime}','${ao.sysPre}')">详细</a>
             </td>
           </tr>
           </s:iterator>
         </tbody>
       </table>   
     <div class="btn-content">
        <c:choose>
						<c:when test='${embeded }'>
							<a href="HealthManagerAction!getAllInOneData.action?healthFileId=${localHealthFile.healthFileId }&embeded=${embeded }" class="btn btn-xianshi">返回</a>
						</c:when>
						<c:otherwise>
						<a href="HealthManagerAction!getAllInOneData.action?healthFileId=${localHealthFile.healthFileId }" class="btn btn-xianshi">返回</a>
						</c:otherwise>
					</c:choose>
         
      </div>
   </div>
   <!-- 表单表格 start -->
    </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <c:choose>
			<c:when test='${embeded }'>
			</c:when>
			<c:otherwise>
				<s:include value="/include/footer.jsp" />
			</c:otherwise>
		</c:choose>
    <!-- 底栏 Start-->
  </div>

<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<script src='/jmjkms/js/dkdhcommon.js'>
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
    	if(startTime0 != ""&&endTime0 != ""){
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
//隐藏显示搜索条件
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
$(function(){
          var value = ${searchType}+"";
          hiddenSearch(value);
     }); 
     
$(".type").change(function(){hiddenSearch($(this).val())});



function alertDetail(diaPre,pules,temperature,fbs,pbs,rbs,oxygen,fat,height,weight,muscle,bmi,meaTime,sysPre){
	 swal({  
            title: "一体机详细数据",   
            type: "info",
            html:true,
            text: "<table class='table table-bordered'>"+
             "<tr><td colspan='1'>舒张压:</td><td colspan='1'>"+diaPre+"mmHg</td><td colspan='1'>脉率:</td><td colspan='1'>"+pules+"次/分钟</td></tr>"+
             "<tr><td colspan='1'>收缩压:</td><td colspan='1'>"+sysPre+"mmHg</td><td colspan='1'>空腹血糖:</td><td colspan='1'>"+fbs+"mmol/L</td></tr>"+
             "<tr><td colspan='1'>餐后血糖:</td><td colspan='1'>"+pbs+"mmol/L</td><td colspan='1'>随机血糖:</td><td colspan='1'>"+rbs+"mmol/L</td></tr>"+
             "<tr><td colspan='1'>血氧:</td><td colspan='1'>"+oxygen+"%</td><td colspan='1'>脂肪含量:</td><td colspan='1'>"+fat+"</td></tr>"+
             "<tr><td colspan='1'>身   高:</td><td colspan='1'>"+height+"cm</td><td colspan='1'>体   重:</td><td colspan='1'>"+weight+"kg</td></tr>"+
             "<tr><td colspan='1'>基础代谢值:</td><td colspan='1'>"+muscle+"</td><td colspan='1'>BMI值:</td><td colspan='1'>"+bmi+"</td></tr>"+
             "<tr><td colspan='1'>体温:</td><td colspan='1'>"+temperature+"℃</td><td colspan='1'>测量时间:</td><td colspan='1'>"+meaTime+"</td></tr>"+
             "</table>",
            showCancelButton: false,  
            showConfirmButton:true,  
            animation: "slide-from-top",  
         });
}
</script>
</body>
</html>
