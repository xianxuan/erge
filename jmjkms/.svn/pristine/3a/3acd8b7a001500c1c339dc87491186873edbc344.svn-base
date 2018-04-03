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
      <h3 class="current-title">血压管理</h3>
      <!-- 表格容器 start -->
       <div class="search-content">
       <input name="yemianname" value="02204" type="hidden"/>
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
       <!-- 血压表单表格 start -->
         <form id="registerform" action="chronicManagerAction!editBPCloud.action" method="post" >
           <table class="table table-bordered">
             <tbody>
               <tr>
                 <td>测量条件
                          <input  type="hidden"  value="${healthFile.healthFileId}"  name="healthFileId" />
                          <input  type="hidden"  value="${cloudId}"  name="cloudId" />
                 </td>
                 <td><select name="bloodPress.meaState"  id="" >
                     <option value="">请选择</option>
                      <option value="0"  <c:if test="${bloodPress.meaState==0 }">selected</c:if>>安静</option>
                      <option value="1" <c:if test="${bloodPress.meaState==1 }">selected</c:if>>饮酒后</option>
                      <option value="2" <c:if test="${bloodPress.meaState==2 }">selected</c:if>>运动后</option>
                   </select>
                   </td>
                 <td>药物</td>
                 <td>
                   <select name="bloodPress.takeMed"  id="">
                     <option value="">请选择</option>
                     <option value="0" <c:if test="${bloodPress.takeMed==0 }">selected</c:if>>未服药</option>
                     <option value="1" <c:if test="${bloodPress.takeMed==1 }">selected</c:if>>已服药</option>
                   </select>
                 </td>
                 <td>药物名称</td>
                 <td>
                 	  <input type="text" class="w150"  name="bloodPress.medName" datatype="s" nullmsg="不可为空"  errormsg="不能输入特殊字符！" value = "${bloodPress.medName }"/>
                 </td>
                  <td>测量时间</td>
                 <td> <input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" value="${ bloodPress.meaTime}" name="bloodPress.meaTime" onfocus="this.blur()"
                 ></td>
               </tr>
                <tr>
                <td>测量手臂</td>
                 <td><select name="bloodPress.arm"  id="">
                     <option value="">请选择</option>
                     <option value="0" <c:if test="${bloodPress.arm==0 }">selected</c:if>>左手</option>
                     <option value="1" <c:if test="${bloodPress.arm==1 }">selected</c:if>>右手</option>
                   </select></td>
                 <td>脉率(次/min)</td>
                 <td><input type="text" onkeyup="Num(this)" maxlength='10' name="bloodPress.pulse"  value="${bloodPress.pulse }"></td>
                 <td>收缩压(mmHg)</td>
                <td><input type="text" onkeyup="Num(this)" maxlength='10' name="bloodPress.sysPre" value="${ bloodPress.sysPre}"></td>
                 <td>舒张压(mmHg)</td>
                 <td> <input type="text" onkeyup="Num(this)" maxlength='10' name="bloodPress.diaPre"  value="${bloodPress.diaPre }"></td>
               </tr>
               <tr>                 
                 <td>设备</td>
                 <td>
                   <select name="bloodPress.devID"  id="">
                     <option value="">请选择</option>
                     <s:iterator value="vMaintainables" var="vmt">
                      <c:if test="${ vmt.devID==entryName}"><option value="${ entryName}" selected="selected">${entryName}</option></c:if>
                     <option value="${ entryName}" selected="selected">${entryName}</option>
                     </s:iterator>
                   </select>
                 </td> 
               </tr>
             </tbody>
           </table>
           <div class="btn-content">
               <input type="submit" class="btn" value="保存修改">
              <a href="javascript:;"   class="btn btn-back">返回</a>
            </div>
         </form>
         <!-- 血压表单表格 end -->
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
<script src="/jmjkms/js/base.js"></script>
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
</script>
</body>
</html>
