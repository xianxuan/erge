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
  <input name="yemianname" value="01202" type="hidden"/>
    <!-- 主菜单 start -->
    <s:include value="/include/nav.jsp" />
    <!-- 主菜单 end -->
    <!-- 主容器 start -->
    <div class="container">
      <h3 class="current-title">慢性病随访记录</h3>
      
      <!-- 删除此行注释，在此添加对应的div -->
       <%-- <label>姓名：${healthFile.name}&nbsp;&nbsp;&nbsp;&nbsp;档案编号：${healthFile.fileNum}</label> --%>
       <div class="table-content">
        <table id="jqprint" class="table table-bordered" style="word-break:break-all">
          <tbody>
           <%-- <tr>
             <td colspan="8" class="title-td"><c:out value="${chronicDisease.diseaseName}"></c:out>随访记录</td>
           </tr> --%>
           <tr>
      		<td colspan="8" class="title-td" >
      			<label>
      				<c:out value="${chronicDisease.diseaseName}"></c:out>随访记录
      				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      				姓名：${healthFile.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      				档案编号：${healthFile.fileNum}
      			</label>
      		</td>
     	   </tr>
           <tr>
             <td colspan="1">疾病名称</td>
             <td colspan="3"><label><c:out value="${chronicDisease.diseaseName}"></c:out></label></td>
             <td  colspan="1">
             	  症状特点
              </td>
              <td colspan="3"> <label><c:out value="${otherillFollow.symptomCharacteristic}"></c:out></label> </td>
           </tr>
           <%-- <tr>
              <td  colspan="1">
             	  症状特点
              </td>
              <td colspan="3"> <label><c:out value="${otherillFollow.symptomCharacteristic}"></c:out></label> </td>
            </tr> --%>  
            <tr>
              <td colspan="8" class="title-td">体征检查</td>
            </tr>
            <tr>
             <td>舒张压（mmHg）</td>
             <td>
               <label><c:out value="${otherillFollow.bloodPressureH}"></c:out></label>
             </td>
             <td>收缩压（mmHg）</td>
             <td>
               <label><c:out value="${otherillFollow.bloodPressureL}"></c:out></label>
             </td>
             <td>身高（cm）</td>
             <td>
               <label><c:out value="${otherillFollow.height}"></c:out></label>
             </td>
             <td>体重（kg）</td>
             <td>
               <label><c:out value="${otherillFollow.wight}"></c:out></label>
             </td>
            </tr>
            <tr>
              <td>体质指数</td>
              <td>
               <label><c:out value="${otherillFollow.bmi}"></c:out></label>
              </td>
              <td>心率（次/分）</td>
              <td>
               <label><c:out value="${otherillFollow.heartRate}"></c:out></label>
              </td>
              <td>其他特征</td>
              <td colspan="3">
               <label><c:out value="${otherillFollow.otherInspection}"></c:out></label>
              </td>
            </tr>
            <tr>
              <td colspan="8" class="title-td">生活方式</td>
            </tr>
            <tr>
              <td>体育锻炼每周锻炼次数</td>
              <td>
               <label><c:out value="${otherillFollow.week}"></c:out></label>
              </td>
               <td>每次锻炼时间（分钟）</td>
              <td>
               <label><c:out value="${otherillFollow.everyTime}"></c:out></label>
              </td>
              <td>摄盐情况(g/天)</td>
              <td>
               <label><c:out value="${otherillFollow.saltIntake}"></c:out></label>
              </td>
              <td>遵医行为</td>
              <td>
               <label><c:out value="${otherillFollow.medicalState}"></c:out></label>
              </td>
            </tr>
            <tr>
              <td>饮食习惯</td>
              <td>
               <label><c:out value="${otherillFollow.eatingHabits}"></c:out></label>
              </td><td>心理状况</td>
              <td>
               <label><c:out value="${otherillFollow.metalState}"></c:out></label>
              </td>
              <td>日吸烟平均(支)</td>
              <td>
               <label><c:out value="${otherillFollow.smoke}"></c:out></label>
              </td><td>日饮酒平均(两)</td>
              <td>
               <label><c:out value="${otherillFollow.drink}"></c:out></label>
              </td>
            </tr>
            <tr>
              <td colspan="8" class="title-td">辅助检查</td>
            </tr>
            <tr>
              <td>空腹血糖（mmol/L）</td>
              <td colspan="3">
               <label><c:out value="${otherillFollow.fastingBloodGlucose}"></c:out></label>
              </td>
              <td>其他检查</td>
              <td colspan="3">
               <label><c:out value="${otherillFollow.otherInspection}"></c:out></label>
              </td>
             </tr>
             <tr>
              <td colspan="8" class="title-td">用药情况</td>
             </tr>
             <tr>
               <td colspan="8">
                 <!--二级框开始-->
          		<table  class="table table-bordered">
         		 <tbody>
          		  <tr>
               		<td> 药品名称</td>
               		<td> 每次剂量(mg)</td>
               		<td> 给药途径</td>
              		<td> 不良反应</td>        
            	  </tr>
         	<s:iterator value="listdrug" var="ld">
               	 <tr>  
               		 <td><c:out value="${ld.drugName}"></c:out></td>
               		 <td><c:out value="${ld.dailyDose}"></c:out></td>
               		 <td><c:out value="${ld.drugPath}"></c:out></td>
              		 <td><c:out value="${ld.adverseReactions}"></c:out></td>      
                 </tr>
     		</s:iterator> 
        	 </tbody>
          	</table>
          <!--/二级框结束-->
               </td>
             </tr>
             <tr>
               <td>饮食控制情况</td>
               <td>
               <label><c:out value="${otherillFollow.dietControl}"></c:out></label>
               </td>
               <td>其他治疗</td>
                <td colspan="2">
               <label><c:out value="${otherillFollow.otherTrett}"></c:out></label>
               </td>
               <td>下次随访预约时间</td>
               <td colspan="2">
               <label><fmt:formatDate value="${otherillFollow.nextAppointmentDate}" pattern="yyyy-MM-dd" /></label>
               </td>
             </tr>
             <tr>

               <td>随访指导意见</td>
               <td colspan="7"><label><c:out value="${otherillFollow.followUpGuidance}"></c:out></label></td>
             </tr>
             <tr>
               <td>备注</td>
               <td colspan="7"><label><c:out value="${otherillFollow.note}"></c:out></label></td>
             </tr>
             <tr>
              <td colspan="8" class="title-td"></td>
             </tr>
             <tr>
               <!-- <td colspan="4"></td> -->
               <%-- <td>被随访人</td>
               <td><label><c:out value="${otherillFollow.followedUp}"></c:out></label></td> --%>
               <td>随访人</td>
               <td colspan="3"><label><c:out value="${otherillFollow.followPeople}"></c:out></label></td>
               <td>随访时间</td>
               <td colspan="3"><label><fmt:formatDate value="${otherillFollow.followDate}" pattern="yyyy-MM-dd" /></label></td>
             </tr>
          </tbody>
        </table>
        <div class="btn-content">
          <a href="javascript:;" class="btn btn-print">打印</a>
          <a href="<%=basePath %>oldChronicFollowAction!showOneAllFollow.action?cid=${chronicDisease.chronicDiseaseId}&hid=${healthFile.healthFileId}" class="btn">返回</a>
          <!-- <a href="javascript:;" class="btn btn-back">返回</a> -->
        </div>
      </div>

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

</body>
</html>
