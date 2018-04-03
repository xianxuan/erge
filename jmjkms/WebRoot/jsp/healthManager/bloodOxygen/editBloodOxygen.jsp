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
  <link type="text/css" href="/jmjkms/css/confirm.css">
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
      <h3 class="current-title">健康日常监测-血氧档案-修改血氧数据</h3>
       <input name="yemianname" value="02201" type="hidden"/>
      <!-- 表格容器 start -->
       <div class="search-content">
        <div class="search-item">
          <label>姓名：${localHealthFile.name}</label>
          &nbsp;&nbsp;&nbsp;&nbsp;<label>性别：<c:if test="${localHealthFile.sex==true }">男</c:if><c:if test="${localHealthFile.sex==false }">女</c:if></label>
          &nbsp;&nbsp;&nbsp;&nbsp;<label>身份证号：${localHealthFile.idNum}</label>
          &nbsp;&nbsp;&nbsp;&nbsp;<label>电话号码：${localHealthFile.IPhone}</label>
        </div>
      </div>
      <!-- begin -->
       <h3 class="title-td">血氧数据修改</h3>
       <div class="table-content">
       <!-- 血氧表单表格 start -->
         <form id="registerform" action="HealthManagerAction!editBOCloud.action"  method="post" id="bloodoxygen">
           <table class="table table-bordered">
             <tbody>
               <tr>
                 <td><span style="color:red">*</span>测量条件 <input  type="hidden" name="healthFileId" value="${healthFileId}"/>
                 <input  type="hidden"  name="cloudId" value="${bloodOxygen.id}"/></td>
                 <td><select name="bloodOxygen.meaState"  id="">
                     <option value="0" <c:if test="${bloodOxygen.meaState==0 }">selected</c:if>>静息</option>
                     <option value="1" <c:if test="${bloodOxygen.meaState==1 }">selected</c:if>>运动后</option>
                   </select>
                  </td>
                  <td><span style="color:red">*</span>是否服药</td>
                 <td>
                   <select name="bloodOxygen.takeMed">
                     <option value="0" <c:if test="${bloodOxygen.takeMed != 1 }">selected</c:if>>未服</option>
                     <option value="1" <c:if test="${bloodOxygen.takeMed eq 1 }">selected</c:if>>已服</option>
                   </select>
                 </td>
                <td>药物名称</td>
                <td>
                   <input type="text" name="bloodOxygen.medName" value="${bloodOxygen.medName }"   maxlength='20' />
                </td>
                 <td><span style="color:red">*</span>血氧值(%)</td>
                 <td><input type="text" id="xy" class="temp" name="bloodOxygen.oxygen"   datatype="*" nullmsg="血氧值不可为空" maxlength='5' value="${bloodOxygen.oxygen }"></td>
               
               </tr>
                  <tr>
                   <td><span style="color:red">*</span>脉搏率(次/min)</td>
                <td><input type="text" id="mbl" class="temp" name="bloodOxygen.pulse" value="${bloodOxygen.pulse }" maxlength='5'  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" datatype="*" nullmsg="脉率不可为空" ></td>
                   <td><span style="color:red">*</span>测量时间</td>
                   <td> 
                     <input type="text" class="w150"   name="bloodOxygen.meaTime" value="${bloodOxygen.meaTime}"   datatype="*" nullmsg="测量时间不可为空" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"   onfocus="this.blur()">
                   </td>
                 <td><span style="color:red">*</span>异常报警</td>
                 <td colspan="3"><select name="bloodOxygen.abnAlarm"  id="">
                     <option value="0" <c:if test="${bloodOxygen.abnAlarm==0 }">selected</c:if>>设为报警</option>
                     <option value="1" <c:if test="${bloodOxygen.abnAlarm==1 }">selected</c:if>>设为不报警</option>
                   </select></td>
                   </tr>
                   <tr>
                  <td><span style="color:red">*</span>血氧分析结果</td>
                  <td colspan="7">
                 	<textarea name="bloodOxygen.analysisResult" id=""  
					class="textarea temp" datatype="*" nullmsg="血氧分析结果不可为空">${bloodOxygen.analysisResult}</textarea>
				 </td>
                 </tr>
             </tbody>
           </table>
           <div class="btn-content">
               <input type="submit" class="btn" value="保存">
              <button class="btn" type="button" onclick="history.go(-1);">返回</button>
            </div>
         </form>
         <!-- 血氧表单表格 end -->
       </div>
       <!--end -->
    </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>
  <script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
 <script src="js/sweetalert.min.js"></script> 
<script src="/jmjkms/js/base.js"></script>
<script src="/jmjkms/js/healthManager.js"></script>
<script type="text/javascript" src="/jmjkms/js/confirm/Validform_v5.3.2_min.js"></script>
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
<script>
	function Num(obj){
	obj.value = obj.value.replace(/[^\d.]/g,"");
	obj.value = obj.value.replace(/^\./g,""); 
	obj.value = obj.value.replace(/\.{2,}/g,"."); 
	obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
        }
        

	$("form").submit(
			function() {
				if ($("#xy").val() > 999 || $("#mbl").val() > 999) {
					alert("数据值过大！")
					return false;
				}
				else
					return true;			
			})
</script>
</body>
</html>
