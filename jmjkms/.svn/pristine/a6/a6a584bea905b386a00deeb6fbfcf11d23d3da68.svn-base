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
  <link rel="stylesheet" href="/jmjkms/css/grant-css.css">
  <link rel="stylesheet" href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">
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
    <input name="yemianname" value="10204" type="hidden"/>
		<h3 class="current-title">角色权限详情查看</h3>
		<!-- 删除此行注释，在此添加对应的div -->
        <div class="main_juese">
       	<div class="title_juese">
       		<label>角色：</label>
            <label class="rolename">${role.roleName }</label>
            <input type="text" style="display:none;" value="${role.roleId }">
       	</div>
       	<div class="rights-title"><span>显示</span><span>增加</span><span>修改</span><span>删除</span><span>导出</span><span>打印</span></div>
		<ul class="qx-ul">
			<s:iterator value="listmap" var="m1">
			<c:if test="${m1['children']!='[null]'}">
			<li>
				<div>
					<label style="color:#EF7C00;">${m1['module']}</label>
						<input type="checkbox">
						<input type="checkbox">
						<input type="checkbox">
						<input type="checkbox">
						<input type="checkbox">
						<input type="checkbox">
				</div>
					<ul>
						<c:forEach  items="${m1['children']}" var="m2">
							<li name="rightsTr">
								<label  module="${m2['module'] }" rightsName="${m2['rightsName'] }" rightsCode="${m2['rightsCode'] }">${m2["rightsName"]}</label>
								<c:forEach items="${m2['value']}" var="lis">
									<input type="checkbox" value="${lis}">
								</c:forEach>
							</li>
						</c:forEach>
					</ul>
				</li>
			</c:if>
			<c:if test="${m1['children']=='[null]'}">
				<div>
				<li name="rightsTr">
					<label style="color:#EF7C00;" module="${m1['module'] }" rightsName="${m1['rightsName'] }" rightsCode="${m1['rightsCode'] }">${m1["rightsName"]}</label>
						<c:forEach items="${m1['value']}" var="liss">
							<input type="checkbox" value="${liss}">
						</c:forEach>
				</li>
				</div>
			</c:if>
			</li>
			</s:iterator>
		</ul>
		<div class="btn-content">
			<a href="<%=basePath %>roleAction!getRoleList.action" style="margin-right: 360px;" class="btn btn_return">返回</a>
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
<script src="/jmjkms/js/quanxian.js"></script>
<script type="text/javascript">
$(function(){
	 $.ajax({   
        type:"POST", //请求方式  
        url:"<%=basePath %>roleAction!findRoleInfo.action?roleId=${roleId}", //请求路径 
        dataType: "json",   //返回值类型  
        success:function(msg){
        	var jsonm = eval("("+msg+")");
        	for(var i=0,l=jsonm.length;i<l;i++){
        			//alert(jsonm[i].module+"&&&"+jsonm[i].rightsCode+"&&&"+jsonm[i].rightsName+"&&&"+jsonm[i].rightsValue+"&&&");
        			var module=jsonm[i].module;
        			var rightsCode=jsonm[i].rightsCode;
        			var rightsName=jsonm[i].rightsName;
        			var rigvalue=jsonm[i].rightsValue;
        			var rrva=rigvalue.split(",");
        			//alert(rrva);
        			for(var j= 0;j<rrva.length;j++){
        				var value;
        				value=rrva[j];
						//alert(value);
						$("li[name='rightsTr']").each(function(){
								var firstTd = $(this).children().eq(0);
								if(rightsCode==$(firstTd).attr("rightsCode")){
									var values = $(this).find("input");
									//alert($(values).length)
									$(values).each(function(i){
										//alert(i);
										if(i < $(values).length){
											if($(this).attr("value")==value){
											//alert(value);
												$(this).attr('checked','checked');
											}
										}
										
									});
								}
							});
						
					}
			    }
			 },
       
        error:function(){  
            alert("error");  
            
        }    
      });
      //设置详情页为不可编辑
      $('input[type=checkbox]').attr('disabled', true);  
});
</script>
</body>
</html>
