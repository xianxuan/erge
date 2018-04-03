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
      <h3 class="current-title">健康一体机档案-趋势分析</h3>
      <input name="yemianname" value="02201" type="hidden"/>
       <div class="search-content">
          <div class="btn-content">
            <a href="HealthManagerAction!getAllInOneFromCloud.action?bloodForward=0&healthFileId=${localHealthFile.healthFileId }&embeded=${embeded}" class="btn btn-default">数据分析</a>
            <a href="HealthManagerAction!getAllInOneFromCloud.action?bloodForward=1&healthFileId=${localHealthFile.healthFileId }&embeded=${embeded}" class="btn">趋势分析</a>
            <a href="HealthManagerAction!getAllInOneFromCloud.action?bloodForward=2&healthFileId=${localHealthFile.healthFileId }&embeded=${embeded}" class="btn btn-default">详细数据</a>
         </div>
      </div>
       <!-- 表单表格 start -->
   <div class="table-content">
     <form action="HealthManagerAction!allInOneTendAnalysis.action" method="post">
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
                  <input type="submit" id="sub" class="btn" value="趋势分析">
                  <input type='hidden' id='embeded' name='embeded' value='${embeded}'/>
                </div>
             </form>
            <table  class="table table-bordered">
            <tbody>
           <tr>
             <td colspan="4">
                
             </td>
           </tr>
         </tbody>
       </table>
       <div id="container1"  style="height:450px;width:1200px;overflow:auto;">
       </div>  
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
<script type="text/javascript" src="http://cdn.hcharts.cn/jquery/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script> 
<script type="text/javascript" src="http://cdn.hcharts.cn/highcharts/exporting.js"></script>
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
      myHighchars();
      var value = ${searchType}+"";
      hiddenSearch(value);
      alertMessage('${message}');
 }); 
     
$(".type").change(function(){hiddenSearch($(this).val())});



//highchar展示
function myHighchars(){
    
    $('#container1').highcharts({
         chart: {
            type: 'spline'
        }, 
        title: {
            text: '${localHealthFile.name}的一体机数据趋势图'
        },
        xAxis: {
              categories: ${xAxis},
        },
        yAxis: {
            title: {
                text: '省略单位后的值'
            },
            labels: {
                formatter: function() {
                    return this.value +''
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
            name: '舒张压值',
            data: ${yAxisLow}
        }, {
            name: '收缩压值',
            data: ${yAxisHigh}
        }, {
            name: '脉率',
            data: ${yAxisPulse}
        },
        {
            name: '血氧值',
            data: ${yAxisOxygen}
        },
        {
            name: '空腹血糖值',
            data: ${yAxisFbs}
        },
        {
            name: '餐后血糖值',
            data: ${yAxisPbs}
        },
        {
            name: '随机血糖值',
            data: ${yAxisRbs}
        }
        ]
    });  
 	$("#highcharts-0").css("overflow-y","hidden");
    $("#highcharts-0").css("overflow-x","auto");
    if(${scrollLength}>1200){
     $("#highcharts-0").css("width",${scrollLength});
    }else{
       $("#highcharts-0").css("width",1200);
    }
}
</script>
<script type="text/javascript">
/*       $(function(){
           var value = ${searchType}+"";
           hiddenSearch(value);
           alertMessage('${message}');
      });  */
	$(".type").change(function(){hiddenSearch($(this).val())});
	
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
</script>
</body>
</html>
