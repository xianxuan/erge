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
  <link  rel="stylesheet" href="/jmjkms/css/confirm.css">
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
      <h3 class="current-title">维修记录 <br></h3>
        <div class="table-content"> 
        <input name="yemianname"  value="09100" type="hidden"/>
          <form onsubmit="return dosubmit()" id="registerform" action="equipmentManageAction!saveMaintence.action" method="post" enctype="multipart/form-data"> 
               <input type="hidden" name="token" value="${token }" />
				  <table class="table table-bordered">
				    <tbody>			
			           <tr>
			           <td>设备名称</td>
			           <td><label>${equipmentManage.equipName}</label></td>
			           <td>设备编号</td>
			             <td><label>${equipmentManage.equipNumber}</label></td>
			           <input type="hidden" name="equipmentManageId"  value="${equipmentManageId }">
			           </tr> 
			           <tr>
			             <td><span class="required">*</span>维修时间</td>
			             <td><input class="temp" type="text" onfocus="this.blur()" id="time" name="maintenance.date" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" value="${currentTime}"></td>
			             <td>设备问题</td>
			             <td><input class="temp" type="text" maxLength="50" name="maintenance.problem"></td>
			           </tr>
			           <tr>
			           <td><span class="required">*</span>维修公司</td>
			             <td><input class="temp" id="wxgs" type="text" maxLength="50" name="maintenance.company" datatype="*"  nullmsg="维修公司不可为空"></td>
			           <td><span class="required">*</span>维修费用</td>
			           <td><input id="wxfy" type="text" maxLength="20" name="maintenance.fee"  onkeyup="value=value.replace(/[^\d.]/g,'')" datatype="*"  nullmsg="维修费用不可为空"></td>
			           </tr>
			           <tr>
			           <td>维修人员</td>
			             <td><input class="temp" type="text" maxLength="20" name="maintenance.person"></td>
			           <td>状态</td>
			             <td><select name="maintenance.state" id="">
				             <option value="1">已解决</option>
				             <option value="0">未解决</option>   
			            </select> 
			           </td>
			           </tr>
			           
                    </tbody> 
                  </table>
                 <div class="btn-content">
                    <input id="submit" type="submit" class="btn" value="保存" onclick='isNumber()'>
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
<script type="text/javascript">
		var isCommitted = false;//表单是否已经提交标识，默认为false
		function dosubmit() {
			/* 此处还需要判断各个必填项校验是否通过*/
			//alert("1" + isCommitted);
			if (isCommitted == false
					&& document.getElementById('time').value != "" && document.getElementById('wxgs').value != ""
					&& document.getElementById('wxfy').value != "") {
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
			alert("维修时间不可为空");
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
