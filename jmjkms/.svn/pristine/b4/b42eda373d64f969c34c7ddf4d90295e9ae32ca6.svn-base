<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head><meta name="viewport" content="width=device-width, initial-scale=1.0"><meta http-equiv="X-UA-Compatible" content="ie=edge">
  <meta charset="UTF-8">
  <c:choose><c:when test="${session.comHospital.isHead==0}"><title>中电科社区健康管理平台</title></c:when><c:when test="${session.communityHospitalGroup!=null}"><title>社区健康管理系统</title></c:when><c:otherwise><title>社区健康服务站</title></c:otherwise></c:choose>
  <link rel="stylesheet" href="/jmjkms/css/cssreset.css">
  <link rel="stylesheet" href="/jmjkms/css/main.css">
  <link rel="stylesheet" href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">
	<style type="text/css">
  span.cspan{
    display: inline-block;        
    width:150px; /这个宽度可以根据自己需要，大小自己决定/
    word-break:keep-all;/* 不换行 */  
    white-space:nowrap;/* 不换行 */  
    overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */  
    text-overflow:ellipsis;/* 文本溢出时显示省略标记(...)与overflow:hidden;一起使用*/
}
span.dspan{
    display: inline-block; 
    width:100px; /*这个宽度可以根据自己需要，大小自己决定*/
    word-break:keep-all;/* 不换行 */  
    white-space:nowrap;/* 不换行 */  
    overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */  
    text-overflow:ellipsis;
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
    <div class="container">
      <h3 class="current-title">健康教育</h3>
      
      <!-- 删除此行注释，在此添加对应的div -->
		<div class="search-content">
		<input name="yemianname"  value="05201" type="hidden"/>
			<form class="search-form" action="healthEducationAction!getHealthEducationBySearch.action" method="post">

	            <label>查询选项：</label>
                <select name="searchCondition" id="">
                    <option value="">请选择</option>
                   <option value="负责人" <c:if test="${searchCondition  eq '负责人'}">selected</c:if>>负责人</option>
                   <option value="组织者" <c:if test="${searchCondition eq '组织者'}">selected</c:if>>组织者</option>
                </select>

	            <input class="text-input temp" type="text"  name="searchText" value="${searchText}"> 

	            
	            <label>活动时间：</label>
			     <input type="text" onfocus="this.blur()" class="startTime" name="startDate" value="${startDate}"  class="w150"  onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">	    
	             <label>至</label>
			     <input type="text" onfocus="this.blur()" class="endTime" name="endDate" value="${endDate}" class="w150"  onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
	            <input class="btn btn-xianshi" id="submit" type="submit" value="查询" />
	            <a class="btn btn-xinzeng" href="healthEducationAction!addHealthEducation.action"  >新增</a>
	        </form>
		</div>
		<!-- 导出 -->
		<form action="healthEducationAction!test.action" method="post">
		
		<div class="table-content">
			<table class="table table-bordered">
	        	<thead>
	           		<tr>
	           		  <c:if test="${session.comHospital.isHead==0 }">  <!-- 系统管理员 -->
	           		    <th>社区集团</th>
	           		    <th>社区医院</th>
	           		  </c:if>
	           		  <c:if test="${session.communityHospitalGroup !=null }">  <!-- 集团 -->
	           		    <th>社区医院</th>
	           		  </c:if>
	           		    <th>活动主题</th>
	           		  	<th>活动地点</th>
			            <th>活动形式</th>
			            <th>活动时间</th>
			            <th>组织者</th>
			            <th>活动对象</th>
			            <!-- <th>接受健康教育人员种类</th>
			            <th>接受健康教育人数</th> -->
			            <th>负责人</th>
			            <th>操作</th>
			            
		           </tr>
	           </thead>
	         	<tbody>
	          <s:iterator value="healtEducatioList" var="he">
	         	<!-- 导出 -->
	         	   <input type="hidden" name="ids" value="${he.health.healthEduId }" />
					<tr>
						<c:if test="${session.comHospital.isHead==0 }">   <!-- 系统管理员 -->
					    <td>${he.communitygroup}</td>
					    <td>${he.communityHospital}</td>
					   	</c:if>
					   	<c:if test="${session.communityHospitalGroup !=null}">   <!-- 集团 -->
					    <td>${he.communityHospital}</td>
					   	</c:if>
					   	<td><span class="dspan">${he.health.activeTheme}</span></td>
	             		<td><span class="dspan">${he.health.activePlace}</span></td>
	             		<td><span class="dspan">${he.health.activeType}</span></td>
	             		<td><fmt:formatDate value='${he.health.activeTime}' pattern='yyyy-MM-dd'/></td>
	             		<td><span class="dspan">${he.health.organizer}</span></td>
	             		<td><span class="dspan">${he.health.activePeople}</span></td>
	             		<%-- <td><span class="dspan">${he.health.peopleType}</span></td>
	             		<td><span class="dspan">${he.health.peopleNumber}</span></td> --%>
	                    <td>${he.health.TStaff.name}</td>
	             		<td>
	             		<a class="btn-xiugai" href="healthEducationAction!editHealthEducation.action?healthEducationId=${he.health.healthEduId }"  >修改</a>
	             		<a onclick="return confirm('是否删除？');" class="btn-shanchu" href="healthEducationAction!deleteHealthEducation.action?healthEducationId=${he.health.healthEduId }" >删除</a>
	             		<a class="btn-xianshi" href="healthEducationAction!getHealthEducationDetail.action?healthEducationId=${he.health.healthEduId }" >详情</a>
	             		</td>
	           		</tr>
	           		</s:iterator>
	           	
				</tbody>
			</table>
			<!-- 导出 -->
			<input type="hidden" name="flag"  id="act" value=""/>
			<div class="sum-btn">
				<div class="page">
	                ${pageHtml}
		    	</div>
		    	<div class="btn-content2">
		          <input type="submit" class="btn btn-daochu"  value="导出全部"  onclick="run01()">
		          <input type="submit" class="btn btn-daochu"  value="导出本页"  onclick="run02()">
		        </div>
	        </div>
		</div>
		</form>
    </div>

   
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
 </div>
<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<script type="text/javascript">
 $("form").submit(function(){
    	var startTime0=$(".startTime").eq(0).val();
    	var startTime1=$(".startTime").eq(1).val();
    	var endTime0=$(".endTime").eq(0).val();
    	var endTime1=$(".endTime").eq(1).val();
    	 if(startTime0 != ""&& endTime0 != ""){ 
    	if(startTime0>endTime0){
      	 	$(".startTime").eq(0).val("");
       		$(".endTime").eq(0).val("");
       		alert("查询时间输入错误");
       		return false;
       	}
        	} 
      	if(startTime1 != "" && endTime1 != ""){ 
    	if(startTime1>endTime1){
      	 	$(".startTime").eq(1).val("");
       		$(".endTime").eq(1).val("");
       		alert("查询时间输入错误");
       		return false;
       	}
        }
    })
</script>
	<!-- 导出 -->
	<script>
    var Obtn01=document.getElementById("btn01");
    var Obtn02=document.getElementById("btn02");
    var Obtn03=document.getElementById("btn03");
    var Oact  =document.getElementById("act");
    function run01(){
        Oact.value=1;
    }
    function run02(){
        Oact.value=2;
    }
    function run03(){
        Oact.value=3;
    }
</script>
</body>
</html>
