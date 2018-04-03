<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head><meta name="viewport" content="width=device-width, initial-scale=1.0"><meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta charset="UTF-8">
<c:choose><c:when test="${session.comHospital.isHead==0}"><title>中电科社区健康管理平台</title></c:when><c:when test="${session.communityHospitalGroup!=null}"><title>社区健康管理系统</title></c:when><c:otherwise><title>社区健康服务站</title></c:otherwise></c:choose>
<link rel="stylesheet" href="/jmjkms/css/cssreset.css">
<link rel="stylesheet" href="/jmjkms/css/main.css">
<%-- <style type="text/css">
		.main-content .container  .highcharts-container{
				overflow: auto !important;
		}

</style> --%>
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
		<input name="yemianname" value="08202" type="hidden"/>
		<div class="container">
			<h3 class="current-title">健康设备使用情况</h3>
			<div class="search-content">
				<form   action="<%=basePath %>statisticsAction!deviceStatistics.action"    method="post">
					<div class="search-item">
						<label>请选择社区医院：</label>
						<div id="add">
						<input id="laoren" type="checkbox" onclick="return checkAll(this)" ><label for="laoren">全选</label></div>
					</div>
					<br>
					<div class="search-item">
						<label>健康设备类型</label> 
						<select name="select" id="device">
                           <s:if test="select==null">
                              <s:iterator value="deviceTypes" var="list">
                                 <s:if test="#list.code==select">
                                    <option value="${list.code}" selected="selected">${list.type }</option>
                                 </s:if>
                                    <option value="${list.code}" >${list.type }</option>
                              </s:iterator>
                           </s:if>
                           <s:else>
                              <s:iterator value="deviceTypes" var="list">
                                 <s:if test="#list.code==select">
                                     <option value="${list.code}" selected="selected">${list.type }</option>
                                 </s:if>
                                 <s:if test="#list.code!=select">
                                     <option value="${list.code}">${list.type }</option>
                                 </s:if>
                              </s:iterator>
                           </s:else>
                        </select>
						<label>时间区段</label> <select name="recent" id="">
							<s:if test="recent=='最近一年'">
								<option value="最近一年" selected="selected">最近一年</option>
								<option value="最近两年">最近两年</option>
							</s:if>
							<s:elseif test="recent=='最近两年'">
								<option value="最近一年">最近一年</option>
								<option value="最近两年" selected="selected">最近两年</option>
							</s:elseif>
							<s:else>
								<option value="最近一年">最近一年</option>
								<option value="最近两年">最近两年</option>
							</s:else>
						</select>
					</div>
					<div class="btn-content">
						<input type="submit" value="查询" class="btn">
					</div>
					</form>
			</div>
			<div id="container" style="min-width:400px; height: 400px;"></div>
			<div class="btn-content" style="text-align:center;">
				<a href="<%=basePath %>statisticsAction!jumpOldStatistics.action"  class="btn">老人详细统计</a>
			</div>
		</div>

<s:include value="/include/footer.jsp" />
	</div>
	<!-- 主容器 end -->
	<!-- 底栏 Start-->
	
	<!-- 底栏 Start-->
	</div>


	<script src="/jmjkms/js/jquery-1.4.4.min.js"></script>
	<script src="/jmjkms/js/laydate/laydate.js"></script>
	<script src="/jmjkms/js/base.js"></script>
	<script src="/jmjkms/js/jquery.jqprint-0.3.js"></script>
	<script type="text/javascript"
		src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script>
	<script type="text/javascript"
		src="http://cdn.hcharts.cn/highcharts/exporting.js"></script> 
	
	<script type="text/javascript">
		$(function() {
			
			
			var json = ${json};
			for (var i = 0; i < json.length; i++) {
				var TemO = document.getElementById("add");
				var label = document.createElement("label");
				var newInput = document.createElement("input");
				var putId = json[i].value;
				newInput.setAttribute("id", putId)
				label.setAttribute("for"," "+putId );
				newInput.setAttribute("class", "oldids");
				newInput.type = "checkbox";
				newInput.name = "communityHospitalIdList";
				newInput.value = json[i].value;
				var check = ${jsonString};
				if (check != "0") {
					for (var j = 0; j < check.length; j++) {
						if (check[j].value == json[i].value) {
							newInput.checked = check[j].checked;
						}
					}
				}
				TemO.appendChild(newInput);
				TemO.appendChild(label);
				label.innerText = json[i].text+"   ";
				/* if ((i + 1) % 10 == 0 && i + 1 > 9) {
					var br = document.createElement("br");
					TemO.appendChild(br);
				} */
				if(i==json.length){
                    var br = document.createElement("br");
                    TemO.appendChild(br);
                }
			}
			if ("${yiYuan}" != "") {
				alert("请选择医院");
				}
			
		});
	</script>
<%-- 	<script type="text/javascript">
		$(function() {
			//动态添加设备
			var equipment=${equipment};
			var select=${select};
			var mySelect=document.getElementById("device");
			mySelect.length=0;
			var opp=new Option("全部设备","全部设备");
			mySelect.add(opp);
			for (var i = 0; i < equipment.length; i++){
				var mySelect=document.getElementById("device");
				var opp=new Option(equipment[i].value,equipment[i].text);
				if(equipment[i].value==select[0].value)
				{
				opp.selected="selected";
				}
				mySelect.add(opp);
			}  
		});
	</script> --%>
	<script type="text/javascript"> 
	if ("${yiYuan}" == "") {
	
      var chart;
      $(document).ready(function() {
        var options = {
          chart: {
            renderTo: 'container',
            type: 'line',
          },
          credits: {  
              enabled:false  
          },
          title : {
					text : '设备统计分析'
				},
				subtitle : {
					text : ''
				},
				xAxis : {
					categories : ${time}
				},
				yAxis : {
					title : {
						text : '设备使用情况'
					}
				},
				plotOptions : {
					line : {
						dataLabels : {
							enabled : true
						},
						enableMouseTracking : false
					}
				},
          series: []
        }
        var equipment=${equipment};
        var statistics=${statistics};
        options.series = new Array();
        var i;
        for(i=0;i<equipment.length;i++)
        {
       	 var shuju=new Array();
           options.series[i] = new Object();
           options.series[i].name = equipment[i].text;
           for(var j=0;j<statistics.length;j++)
           {
           		if(equipment[i].value==statistics[j].value)
           		{
           			shuju.push(statistics[j].text);
           		}
           }
           options.series[i].data = shuju;
         }
       chart = new Highcharts.Chart(options);
       
     });
     }
  </script>
	<script type="text/javascript">
    	function checkAll(all){
    	
    		var allcli=document.getElementsByClassName("oldids");
    		
    		for(var i=0;i<allcli.length;i++){
    	
    			allcli[i].checked=all.checked;
    		}
    	}
    </script>
	
</body>
</html>
