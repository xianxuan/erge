<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	  <h3 class="current-title">数据字典维护</h3>
       <div class="search-content">
       <%-- 	<s:action name="MaintainaleAction!getTypes" namespace="/" var="home" ></s:action> --%>
            <form action="<%=basePath %>MaintainaleAction!getMaintainableByPage.action" method="post">
              <label>搜索类型：</label>
              <!-- file，searchText，mainList与action中相对应 -->
                <select name="file" id="">
                  <option value="请选择" <c:if test="${'请选择' eq file}">selected</c:if>>请选择</option>
                  <s:iterator value="list" var="ty">
                  <option value="${ty}" <c:if test="${ty eq file}">selected</c:if>>${ty}</option>
                  </s:iterator>                  
                </select>          
                <input type="text"    class="w150 temp" name="searchText" maxlength="20" value="${searchText}">
                <input type="submit" class="btn" class="btn-xianshi" value="查询" >               
            </form>
       </div>
    <div class="table-content">
    <table class="table table-bordered">
     <thead>
       <tr>      
         <th>可维护字段名称</th>
         <th>内容</th>
         <th>操作</th>
       </tr>
       </thead>
		<s:iterator value="maintainableAttributes" var="mta">
		<tr>       
          <td>${mta.name}</td>
          <td id="entry">
   			<span class="cspan">
    			<s:iterator value="mateList" var="mte" status="st">  
		  		<c:if test="${mta.maintainableAttributeId == mte.TMaintainableAttribute.maintainableAttributeId}">
		  			${mte.name}、 		
		   		 </c:if> 		
		   	    </s:iterator> 	
   			</span>
		 </td>
		  <%-- <td id="entry">
		    <s:iterator value="mateEntryName" var="mte" status="st">  
		  		<c:if test="${mta.maintainableAttributeId == mte.TMaintainableAttribute.maintainableAttributeId}">
		  			${mte.name}   			
		   		 </c:if> 
		   	</s:iterator> 
		  </td> --%>
		  <td><a class="btn-xianshi" href="MaintainaleAction!getMaintainableEntry.action?maintainableAttributeId=${mta.maintainableAttributeId}">详情</a></td>
		</tr>
		</s:iterator>
     </table>
     <div class="sum-btn">
      <div class="page">
		${pageHtml}
	 </div> 
	 </div>
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

</body>
</html>
