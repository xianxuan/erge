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
<style type="text/css">
		.main-content .container  .highcharts-container{
				overflow: auto !important;
		}

</style>
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
				<form id="registerform"  action="<%=basePath %>statisticsAction!oldStatistics.action"    method="post">
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
						<label>时间区段</label> <input type="text"
								    id="dateInput2"
									onclick="laydate({istime: true, format: 'YYYY-MM'})"
									name="time"
									onfocus="this.blur()" value="${time }" >
					</div>
					<div class="btn-content">
						<input type="submit" id="submit" value="查询" class="btn">
					</div>
					</form>
			</div>
			<s:if test="yiYuan!=' '">
			<div>
				<table class="table table-bordered" id="jqprint">
					<thead>
						<tr>
							<th>使用者</th>
							<th>设备类型</th>
							<th>设备编号</th>
							<th>使用次数</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="devicelist" var="list">
							<tr>
								<td>${list.users }</td>
								<s:iterator value="deviceTypes" var="ll">
									<s:if test="#ll.code==list.code">
										<td>${ll.type }</td>
									</s:if>
								</s:iterator>
								<td>${list.code}</td>
								<td>${list.rate }</td>
							</tr>

						</s:iterator>
					</tbody>
				</table>
			</div>
			</s:if>
			
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
				label.setAttribute("for",putId );
				newInput.type = "checkbox";
				newInput.setAttribute("class", "oldids");
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
				$("#submit").click(function(){
                     if($("#dateInput2").val()==null||$("#dateInput2").val()=="")
                     {
                     	alert("请选择时间");
                     	return false;
                     }
                     else{
                     	return true;
                     }
                    });
		});
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
