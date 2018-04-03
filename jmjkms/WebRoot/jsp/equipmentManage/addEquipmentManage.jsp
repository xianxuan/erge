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
  <!-- 添加下 -->
   <link  rel="stylesheet" href="/jmjkms/css/confirm.css">
   <!-- 添加上 -->
  <link rel="stylesheet" href="/jmjkms/css/cssreset.css">
  <link rel="stylesheet" href="/jmjkms/css/main.css">
  <link rel="stylesheet" href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="/jmjkms/select2/css/select2.css">
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
          <form onsubmit="return dosubmit()" id="registerform" action="equipmentManageAction!saveEquipmentManage.action" method="post" enctype="multipart/form-data"> 
            <!--上出  id为添加 -->
               <input type="hidden" name="token" value="${token }" />
				  <table class="table table-bordered" style="word-break:break-all">
				    <tbody>
			           <tr>
			           <td><span class="required">*</span>设备编号</td>
			             <td><input class="temp" id="sbbh"  type="text" maxLength="20" name="equipmentManage.equipNumber" datatype="*" nullmsg="设备编号不可为空"></td>
			           <td><span class="required">*</span>设备型号</td>
			           <td><input class="temp" id="sbxh" type="text" maxLength="20" name="equipmentManage.equipModel" datatype="*" nullmsg="设备型号不可为空"></td>
			           </tr>
			           <tr>
			             <td><span class="required">*</span>负责人</td>
			             <td>
			               <select name="staffsId" class="js-example-basic-single" class="select2" style="width: 170px;" id="fzr" datatype="*" nullmsg="负责人不可为空">
			                <s:iterator value="staffList" var="sta"> 
	               				<option value="${sta.staffId}" <c:if test="${tstaff.staffId eq sta.staffId}">selected</c:if>>${sta.name}</option>
	              			 </s:iterator>
			               </select>
			             </td>
			             <td><span class="required">*</span>设备名称</td>
			              <td><input class="temp" id="sbmc" type="text" maxLength="20" name="equipmentManage.equipName" datatype="*" nullmsg="设备名称不可为空"></td>			            
			           </tr>
			           <tr>
			           <td>采购公司</td>
			             <td><input class="temp" type="text" maxLength="20" name="equipmentManage.equipCompany"></td>
			           <td>采购合同</td>
			           <td><input class="temp" type="text" maxLength="30" name="equipmentManage.selectContract"></td>
			           </tr>
			           <tr>
			           <td><span class="required">*</span>设备采购人</td>
			             <td><input class="temp" id="sbcgr"  type="text" maxLength="15" name="equipmentManage.equipPeople" datatype="*" nullmsg="设备采购人不可为空"></td>
			           <td><span class="required">*</span>联系方式</td>
			           <td><input id="lxfs" onkeyup="value=value.replace(/[^\d-]/g,'')" type="text" maxLength="13" name="equipmentManage.contact"  datatype="m" nullmsg="联系方式不可为空" errormsg="联系方式输入有误"></td>
			           </tr>
			           <tr>
			             <td><span class="required">*</span>采购时间</td>
			             <td><input type="text" onfocus="this.blur()" id="time" name="equipmentManage.selectTime" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" value="${currentTime}"></td>
			             <td><span class="required">*</span>状态</td>
			           <td>
			             <select name="equipmentManage.status" id="zt" datatype="*" nullmsg="状态不可为空">
			                 <option value="">请选择</option>
				             <option value="0">正常</option>
				             <option value="1">问题</option>   
			            </select> 
			           </td>
			           </tr>

                    </tbody> 
                  </table>
                 <div class="btn-content">
                    <input id="submit" type="submit" class="btn" value="保存">
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
<!-- 以下为添加截止到scripe -->
<script type="text/javascript" src="/jmjkms/js/confirm/Validform_v5.3.2_min.js"></script>

<script type="text/javascript">
		var isCommitted = false;//表单是否已经提交标识，默认为false
		function dosubmit() {
			/* 此处还需要判断各个必填项校验是否通过*/
			//alert("1" + isCommitted);
			if (isCommitted == false
					&& document.getElementById('sbbh').value != "" && document.getElementById('sbxh').value != ""
					&& document.getElementById('fzr').value != "" && document.getElementById('sbmc').value != ""
					&& document.getElementById('sbcgr').value != "" && document.getElementById('lxfs').value != ""
					&& document.getElementById('time').value != "" && document.getElementById('zt').value != "") {
				//提交表单后，将表单是否已经提交标识设置为true
				isCommitted = true;

			//获取表单提交按钮
		    var btnSubmit = document.getElementById("submit");
   			//将表单提交按钮设置为不可用，这样就可以避免用户再次点击提交按钮
   			btnSubmit.disabled= "disabled";
			return true;//返回true让表单正常提交
			} else {
				return false;//返回false那么表单将不提交
			}
		}
	</script>
<script type="text/javascript">
	$("form").submit(function(){
		if($("#time").val()==""){
			alert("采购时间不可为空");
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
<script src="/jmjkms/select2/js/select2.full.js"></script>

<script type="text/javascript">
	$(function(){
		$(".js-example-basic-single").select2();
	})
</script>
</body>
</html>
