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
      <h3 class="current-title">修改操作员信息</h3>
      <input name="yemianname" value="07204" type="hidden"/>
      <div class="table-content">
      <form action="<%=basePath %>oparetorAction!updateOperatorSave.action" method="post">
        <table class="table table-bordered">
          <tbody>
            <tr>
              <td>员工编号</td>
              <td>
                <label><font color="red"><c:out value="${staff.staffNumber }"></c:out></font></label>
              </td>
            </tr>
			  <tr>
              <td>员工姓名</td>
              <td>
                <label><font color="red"><c:out value="${staff.name }"></c:out></font></label>
              </td>
            </tr>
            <tr>
              <td>部门</td>
                <td> 
                <select name="department" id="">
	               	<option value="诊疗部门" <c:if test="${'诊疗部门' eq staff.department}">selected</c:if>>诊疗部门</option>
	               	<option value="辅助诊疗部门" <c:if test="${'辅助诊疗部门' eq staff.department}">selected</c:if>>辅助诊疗部门</option>
	               	<option value="护理部门" <c:if test="${'护理部门' eq staff.department}">selected</c:if>>护理部门</option>
	               	<option value="行政后勤部门" <c:if test="${'行政后勤部门' eq staff.department}">selected</c:if>>行政后勤部门</option>
                </select>
                </td>
            </tr>
            <tr>
              <td>角色</td>
                <s:action name="oparetorAction!getRoleList" namespace="/" var="home1"> </s:action>
                <td>
                     <select name="roleId" id="roleSelect" onchange="roleChange()">
                       <s:iterator value="#home1.listRoles" var="role">
                      <option value="${role.roleId }"  <c:if test="${staff.TRole.roleId  == role.roleId}">selected</c:if>> ${role.roleName }</option>
                     </s:iterator>                  
                     </select>
                </td>
            </tr>
          	<tr id="spe">
              <td>是否置为责任医生</td>
               <td>
                    <select  name="zerendoctor"  id="testSelect" onchange="gradeChange()">
                    	<option value="0" <c:if test="${'0' eq zerendoctor }">selected="selected"</c:if>>否</option>
                      	<option value="1" <c:if test="${'1' eq zerendoctor }">selected="selected"</c:if>>是</option>
                    </select>
                </td>
            </tr>
            <tr id="tr_1">
            <td>是否管理养老机构</td>
               <td>
                    <select  name="manageAgency"  id="">
                    	<option value="0" <c:if test="${'0' eq manageAgency}">selected="selected"</c:if>>否</option>
                      	<option value="1" <c:if test="${'1' eq manageAgency}">selected="selected"</c:if>>是</option>
                    </select>                    
                </td>
              </tr>
              <tr id="tr_2">
                <td>是否管理居家老人</td>
                <td>
                    <select  name="manageHome"  id="">
                    	<option value="0" <c:if test="${'0' eq manageHome}">selected="selected"</c:if>>否</option>
                      	<option value="1" <c:if test="${'1' eq manageHome}">selected="selected"</c:if> >是</option>
                    </select>                    
                </td> 
             </tr> 
            <tr>
              <td>状态</td>
               <td>
                    <select name="flag"  id="" >
                      <option value="0" <c:if test='${staff.operateState == 0}'>selected</c:if>>启用</option>
                      <option value="3" <c:if test='${staff.operateState == 1 || staff.operateState == 3}'>selected</c:if>>禁用</option>              
                    </select>
                </td>
            </tr>
            <tr>
              <td>登录名</td>
              <td>
                  <label><c:out value="${staff.loginName }"></c:out></label>
              </td>
            </tr>
            <tr >
              <td>说明</td>
               <td colspan="7">
                 <textarea name="note" id=""  class="textarea">${staff.note}</textarea>
              </td>
             </tr>
          </tbody>
          </table>
          <input type="hidden" name="staffId" value="${staff.staffId }">
          <div class="btn-content">
               <input  type="submit" class="btn" value="提交" />
                <a href="javascript:history.go(-1)" class="btn">返回</a>
          </div>
</form>
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
<script type="text/javascript">
function roleChange(){
	var s=$("#roleSelect option:selected").val();
	 console.log(s);
	 if(s!==null){
		 $("#spe").show();
	 }
	 else{
		 $("#spe").hide();
		 for(var i = 1; i < 3; i++){  
			    $("#tr_"+i).hide();  
			} 
	 }
	
}
/* 控制显示两个隐藏框 */

//console.log($('#testSelect option:selected') .val());
if($('#testSelect option:selected') .val()==1){
	for(var i = 1; i < 3; i++){  
	    $("#tr_"+i).show();  
	} 
} 
else{
	for(var i = 1; i < 3; i++){  
	    $("#tr_"+i).hide();  
	}  
}
$(".testSelect").bind("change",function(){
	/* var vs=$(this).val(); */
     var vs=$('#testSelect option:selected') .val(); 
     if(vs==1){
     	for(var i = 1; i < 3; i++){ 
     		$("#tr_"+i).show();  
       } 
      }
       else{
       	for(var i = 1; i < 3; i++){ 
     		$("#tr_"+i).hide();  
        } 
     }
});
 function gradeChange(){
    var vs=$('#testSelect option:selected') .val();
    if(vs==1){
    	for(var i = 1; i < 3; i++){ 
    		$("#tr_"+i).show();  
      } 
     }
      else{
      	for(var i = 1; i < 3; i++){ 
    		$("#tr_"+i).hide();  
       } 
    }
} 
</script>
</body>
</html>
            