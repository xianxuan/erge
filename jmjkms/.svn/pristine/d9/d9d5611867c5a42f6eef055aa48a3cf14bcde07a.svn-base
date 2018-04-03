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
      <h3 class="current-title">修改血糖数据</h3>
      <input name="yemianname" value="02205" type="hidden"/>
      <!-- 表格容器 start -->
       <div class="search-content">
        <div class="search-item">
          <label>姓名：${healthFile.name}</label>
          &nbsp;&nbsp;&nbsp;&nbsp;<label>性别：<c:if test="${healthFile.sex==true }">男</c:if><c:if test="${healthFile.sex==false }">女</c:if></label>
          &nbsp;&nbsp;&nbsp;&nbsp;<label>身份证号：${healthFile.idNum}</label>
          &nbsp;&nbsp;&nbsp;&nbsp;<label>电话号码：${healthFile.IPhone}</label>
        </div>
      </div>
      <!-- begin -->
       <h3 class="title-td">血压数据修改</h3>
       <div class="table-content">
       <!-- 血糖表单表格 start -->
         <form class="registerform" action="chronicManagerAction!editBSCloud.action" method="post">
                     <input  type="hidden"    name="healthFileId"  value="${healthFile.healthFileId}"  />
           <input  type="hidden"  name="cloudId" value="${cloudId}" />
           <table class="table table-bordered">
             <tbody>
               <tr>
                 <td><span style="color:red">*</span>测量条件</td>
                 <td>
                   <select name="bloodSuger.meaState" id="">
                     <option value="0" <c:if test="${meaState == 0}">selected</c:if>>随机血糖</option>
                     <option value="1" <c:if test="${meaState == 1}">selected</c:if>>空腹血糖</option>
                     <option value="2" <c:if test="${meaState == 2}">selected</c:if>>餐后血糖</option>
                   </select>
                  </td>
                   <td><span style="color:red">*</span>血糖值(mmoL/L )</td>
                 <td><input class="temp" type="text" name="bloodSuger.bloodSugar"   datatype="n" errormsg="请填写数字！" value="${bloodSugar }"></td>
                 
                 <td><span style="color:red">*</span>是否服药物</td>
                 <td>
                   <select name="bloodSuger.takeMed"  id="takeMedSelect">
                     <option value="0" <c:if test="${takeMed == 0}">selected</c:if>>未服</option>
                     <option value="1" <c:if test="${takeMed == 1}">selected</c:if>>已服</option>
                   </select>
                </td>
                 <td>药物名称</td>
                 <td>
                   <input class="temp" type="text" name="bloodSuger.medName" id="medName" datatype="*" nullmsg="药物名称不可为空" value="${medName}"/>
                 </td>
                  </tr>
                <tr>
                 <td><span style="color:red">*</span>异常报警</td>
                 <td><select name="bloodSuger.abnAlarm"  id="">
                     <option value="0"<c:if test="${abnAlarm eq 0}">selected</c:if>>设为报警</option>
                     <option value="1" <c:if test="${abnAlarm eq 1}">selected</c:if>>设为不报警</option>
                   </select></td>
                <td><span style="color:red">*</span>测量时间</td>
                 <td colspan="5"> <input type="text" class="w150" datatype="*" nullmsg="不可为空" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" value="${meaTime}" name="bloodSuger.meaTime"  onfocus="this.blur()"></td>
              
               </tr>
               <tr>
                  <td><span style="color:red">*</span>血糖分析结果</td>
                  <td colspan="7">
                  <textarea name="bloodSuger.analysisResult" id=""  
					class="textarea" datatype="*" nullmsg="血糖分析结果不可为空">${analysisResult}</textarea>
				 </td>
                </tr>
             </tbody>
           </table>
           <div class="btn-content">
              <input type="submit" class="btn" value="保存">
              <button class="btn" type="button" onclick="history.go(-1);">返回</button>
            </div>
         </form>
         <!-- 血糖表单表格 end -->
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
			showAllError : false,
			tiptype : function(msg) {
				alert(msg);
			}
		});
	});
</script>

<script type="text/javascript">
	function Num(obj){
	obj.value = obj.value.replace(/[^\d.]/g,"");
	obj.value = obj.value.replace(/^\./g,""); 
	obj.value = obj.value.replace(/\.{2,}/g,"."); 
	obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
        }
</script>

</body>
</html>
