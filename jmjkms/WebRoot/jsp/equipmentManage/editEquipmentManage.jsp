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
  <link  rel="stylesheet" href="/jmjkms/css/confirm.css">
  <link rel="stylesheet" href="/jmjkms/css/cssreset.css">
  <link rel="stylesheet" href="/jmjkms/select2/css/select2.css">
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
      <h3 class="current-title">设备管理 <br></h3>
        <div class="table-content"> 
        <input name="yemianname"  value="09100" type="hidden"/>
          <form id="registerform" action="equipmentManageAction!updateEquipmentManage.action" method="post" enctype="multipart/form-data"> 
            
				  <table class="table table-bordered">
				    <tbody>
			           <tr>
			           <td><span class="required">*</span>设备编号</td>
			             <td>
			             <input type="hidden" name="equipmentManageId" value="${equipmentManage.equipId}">			             
			             <input class="temp" type="text" name="equipmentManage.equipNumber" value="${equipmentManage.equipNumber}"  datatype="*" nullmsg="设备编号不可为空"></td>
			           <td><span class="required">*</span>设备型号</td>     
			           <td><input class="temp" type="text" maxLength="20" name="equipmentManage.equipModel" value="${equipmentManage.equipModel}" datatype="*" nullmsg="设备型号不可为空"></td>
			           </tr>
			           <tr>
			           <td><span class="required">*</span>状态</td>
			             <td><select name="equipmentManage.status" id="">
			             <option value="0" <c:if test="${equipmentManage.status=='0'}">selected</c:if>>正常</option>
			             <option value="1" <c:if test="${equipmentManage.status=='1'}">selected</c:if>>问题</option>
			            </select> 
			           </td>
			           <td><span class="required">*</span>设备名称</td>
			           <td><input class="temp"  type="text" maxLength="20" name="equipmentManage.equipName" value="${equipmentManage.equipName}" datatype="*" nullmsg="设备名称不可为空"></td>
			           </tr>
			           <tr>
			           <td>采购公司</td>
			             <td><input class="temp"  type="text" maxLength="20" name="equipmentManage.equipCompany" value="${equipmentManage.equipCompany}" ></td>
			           <td>采购合同</td>
			           <td><input class="temp" type="text" maxLength="500" name="equipmentManage.selectContract" value="${equipmentManage.selectContract}"></td>
			           </tr>
			           <tr>
			             <td><span class="required">*</span>设备采购人</td>
			           <td><input  class="temp" type="text" maxLength="15" name="equipmentManage.equipPeople" value="${equipmentManage.equipPeople}"  datatype="*" nullmsg="设备采购人不可为空"></td>			           
			             <td><span class="required">*</span>采购时间</td>
			             <td><input type="text" onfocus="this.blur()" id="time" name="equipmentManage.selectTime" value="<fmt:formatDate value="${equipmentManage.selectTime}"   pattern='yyyy-MM-dd'/>" 
			             class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"></td>
			           </tr>
			           <tr>
			             <td><span class="required">*</span>负责人</td>
			             <td>
			             <select class="js-example-basic-single" class="select2" style="width: 170px;" name="staffsId" id="" datatype="*" nullmsg="负责人不可为空">
			              <%-- <select class="js-example-basic-single" class="select2" style="width: 170px; name="staffsId" id="" datatype="*" nullmsg="负责人不可为空" > --%>
				                <s:iterator value="staffList"> 
		               				 <s:if test="staffsId==staffId">
		               					<option value="${staffId}" selected="selected">${name}</option> 
		               				</s:if>
		               				<s:else>
		               					<option value="${staffId}">${name}</option>
		               				</s:else> 
		              			 </s:iterator>
			             </select> 
			             </td>
 			            <%--  <input type="hidden" name="equipmentManage.communityHospitalId" value="${equipmentManage.communityHospitalId}">
 			             <input type="hidden" name="equipmentManage.equipmentManageId" value="${equipmentManage.equipmentManageId}"> --%>
			             <td><span class="required">*</span>联系方式</td>
			            <td><input onkeyup="value=value.replace(/[^\d-]/g,'')" type="text" maxLength="13" name="equipmentManage.contact" value="${equipmentManage.contact}" datatype="m" nullmsg="联系方式不可为空" errormsg="联系方式输入有误"></td>
			           </tr>
			           

                    </tbody> 
                  </table>
                 <div class="btn-content">
                    <input type="submit" class="btn" value="保存">
                    <a href="javascript:;" class="btn btn-back">返回</a>
                 </div>
             </form>
            </div> <!-- 表单表格 start -->
      


    </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>

<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<script type="text/javascript" src="/jmjkms/js/confirm/Validform_v5.3.2_min.js"></script>
<script src="/jmjkms/select2/js/select2.full.js"></script>

<script type="text/javascript">
	$(function(){
		$(".js-example-basic-single").select2();
	})
</script>
<script type="text/javascript">
	$("form").submit(function(){
		if($("#time").val()==""){
			alert("计划时间不可为空");
			return false;
		}
	})
</script>
<script type="text/javascript">
$(function(){
      $("#registerform").Validform({
        showAllError:false,
        tiptype:function(msg){          
          alert(msg);
        }
      });
  });
</script>
</body>
</html>
