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
   <link rel="stylesheet" href="/jmjkms/css/confirm.css">
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
      <h3 class="current-title">员工奖惩详情</h3>
      <input name="yemianname" value="07203" type="hidden"/>
      <!--///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
      <!-- 结果容器 start -->
      <div class="table-content">
        <table class="table table-bordered" id="jqprint" style="word-break:break-all" >
          <tbody>
      <!--以下是一整行-->
      <tr><td colspan="4" class="title-td">详细信息</td></tr>
      <!--**********************少可输可选框************************-->
      <tr>
        <td>员工姓名：</td><!--可输可选框-->
        <td><c:out value=" ${vstaffRewardPunish.name }"></c:out>           
         </td>    
         <td>员工编码：</td>
        <td><c:out value="${vstaffRewardPunish.staffNumber }"></c:out>
         </td>  
      </tr>
        <!--*******************************************************-->
        
         <tr>
              <td>奖惩日期：</td>
              <td>
              <c:out value="  ${vstaffRewardPunish.rewardPunishDate }"></c:out>          
               </td>
              <td>奖惩类型：</td>
               <td> 
                <c:out value=" ${vstaffRewardPunish.rewordPunishType } "></c:out>                
              </td>
         </tr>
          <tr>
             <td >奖惩金额：</td>
              <td colspan="3">
              <c:out value=" ${vstaffRewardPunish.rewordPunishAmount }  "></c:out>              
               </td>
            </tr>
            <tr>
             <td >说明：</td><td  colspan="3">
             <c:out value="  ${vstaffRewardPunish.rewardPunishNote } "></c:out>
             </td>
            </tr>
          <tr>
          <td>奖惩原因：</td>
          <td colspan="3" >
          <c:out value=" ${vstaffRewardPunish.rewordPunishReason } "></c:out>
   
          </td></tr>

 
          </tbody>
        </table>
        <div class="btn-content">

         <a  href="javascript:;" class="btn btn-print btn-dayin">打印</a>
          <a href="javascript:;" class="btn btn-back">返回</a>
        </div>
      </div>
      <!-- 结果容器 end -->
    </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>
<script src="/jmjkms/js/jquery-1.4.4.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<script src="/jmjkms/js/jquery.jqprint-0.3.js"></script>
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
</body>
</html>
