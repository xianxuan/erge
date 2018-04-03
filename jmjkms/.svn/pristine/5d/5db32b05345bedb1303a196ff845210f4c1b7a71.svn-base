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
      <h3 class="current-title">血氧档案-趋势分析</h3>
       <input name="yemianname" value="02202" type="hidden"/>
       <div class="search-content">
          <div class="btn-content">
             <a href="HealthManagerAction!getBloodOxygenFromCloud.action?bloodForward=0&healthFileId=${healthFile.id }" class="btn btn-default">数据分析</a>
            <a href="HealthManagerAction!getBloodOxygenFromCloud.action?bloodForward=1&healthFileId=${healthFile.id}" class="btn ">趋势分析</a>
            <a href="HealthManagerAction!getBloodOxygenFromCloud.action?bloodForward=2&healthFileId=${healthFile.id }" class="btn btn-default">详细数据</a>
          </div>
      </div>
       <!-- 表单表格 start -->
   <div class="table-content">
     <form action="HealthManagerAction!bloodOxygenTendAnalysis.action" method="post">
     	   <div class="search-item">
           <s:radio name="searchType" cssClass="type" list="#{'0':'按时间查询','1':'按数量查询'}" label="请选择查询类型" ></s:radio>
            <label><input type="hidden" name="healthFileId" value="${healthFile.id }" /></label>
             </div>
               <div class="search-item">
               <div id="time" style="display: inline-block;">
                  <label>时间:<input type="text" id="startTime" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" value="<fmt:formatDate value="${startTime }" pattern="yyyy-MM-dd HH:mm:ss"/>" name="startTime" onfocus="this.blur()">
                                                            至
                  <input type="text" id="endTime" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" value="<fmt:formatDate value="${endTime }" pattern="yyyy-MM-dd HH:mm:ss"/>" name="endTime" onfocus="this.blur()">
               </label>
               </div>
                  <div id="size" style="display:none;">
                  <label >最近信息条数：</label>
                  <input type="text" class="w40" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength='10'  
                   name="totalSize" id="num" value="${ totalSize}">
                   </div>
                  <input type="submit" id="sub" class="btn" value="趋势分析">
                </div>
       </form>  
   <div class="table-content">
       <div id="container1"  style="height:450px;width:1200px;overflow:auto;">
       </div>
        <div class="btn-content">
             <a href="HealthDailyCheckAction!getHealthFileList.action" class="btn btn-xianshi">返回</a>
        </div>
   </div>
   <!-- 表单表格 start -->
    </div>
    <!-- 主容器 end -->
  </div>
     <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>
<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<script type="text/javascript" src="http://cdn.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>
 <script type="text/javascript" src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script> 
 <script type="text/javascript" src="http://cdn.hcharts.cn/highcharts/exporting.js"></script>
 <script type="text/javascript" src="/jmjkms/js/confirm/Validform_v5.3.2_min.js"></script>
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
 $(".type").change(function(){hiddenSearch($(this).val())});
//隐藏查询条件
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
   //页面刷新
   		$(function(){
           myHighchars();
          $("#highcharts-0").css("overflow-y","hidden");
          $("#highcharts-0").css("overflow-x","auto");
          if(${scrollLength}>1200){
     	     $("#highcharts-0").css("width",${scrollLength});
          }else{
             $("#highcharts-0").css("width",1200);
          } 
          var value = ${searchType}+"";
          hiddenSearch(value);
     }); 

 //单选框改变

//highchar展示
function myHighchars(){

    $('#container1').highcharts({
         chart: {
            type: 'spline'
        }, 
        title: {
            text: '${healthFile.name}的血压趋势图'
        },
        xAxis: {
              categories: ${xAxis},
        },
        yAxis: {
            title: {
                text: '血氧浓度'
            },
            labels: {
                formatter: function() {
                    return this.value +'mol/L'
                }
            }
        },
        tooltip: {
            crosshairs: true,
            shared: true
        },
        plotOptions: {
            spline: {
                marker: {
                    radius: 4,
                    lineColor: '#666666',
                    lineWidth: 1
                }
            }
        },
        series: [{
            name: '脉搏率',
            data: ${yAxisPulse}
        }, {
            name: '血氧值',
            data: ${yAxisOxygen}
        }
        ]
    });  
 	var scrollLength= ${scrollLength};
 	$("#highcharts-0").css("overflow-y","hidden");
    $("#highcharts-0").css("overflow-x","auto");
    if(${scrollLength}>1200){
     $("#highcharts-0").css("width",scrollLength);
    }else{
       $("#highcharts-0").css("width",1200);
    }
}
</script>
</body>
</html>
