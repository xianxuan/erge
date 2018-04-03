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
      <h3 class="current-title">慢病随访记录</h3>
      <%-- <div class="search-content">
       <label>姓名：${healthFile.name}&nbsp;&nbsp;&nbsp;&nbsp;档案编号：${healthFile.fileNum}</label>
     
         <label>重性精神疾病</label>
        &nbsp;&nbsp;&nbsp;&nbsp;

      </div> --%>
      <!-- 结果容器 start -->
      <!-- <h3 class="current-title">重性精神疾病随访记录</h3> -->
      <div class="table-content">
        <table id="jqprint" class="table table-bordered" style="word-break:break-all">
          <tbody>
          <tr>
      		<td colspan="8" class="title-td" >
      			<label>
      				重性精神疾病随访记录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      				姓名：${healthFile.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      				档案编号：${healthFile.fileNum}
      			</label>
      		</td>
     	 </tr>
           <tr>
             <td colspan="4" class="title-td">基本信息</td>
           </tr>
              <tr>
              <td>危险性：</td>
              <td><label><c:out value="${mentalfollowview.risk}"></c:out></label></td>
              <td>目前症状：</td>
              <td>
             <label><c:out value="${mentalfollowview.presentSymptom}"></c:out></label>
               </td>
            </tr>

        
              <tr>
              <td>自知力：</td>
              <td><label><c:out value="${mentalfollowview.selfKnowledge}"></c:out></label></td>
              <td>睡眠情况：</td>
              <td>
            <label><c:out value="${mentalfollowview.sleepQuality}"></c:out></label>
               </td>
            </tr>
            <tr>
               <td>饮食情况：</td>
              <td >
              <label><c:out value="${mentalfollowview.dietCondition}"></c:out></label>
               </td>
              <td  colspan="2"></td> 

            </tr>
            <tr>
             <td colspan="4" class="title-td">社会功能情况</td>
           </tr>

           <tr>
              <td>个人生活料理：</td>
              <td> <label><c:out value="${mentalfollowview.socialFunction}"></c:out></label></td>
              <td>家务劳动：</td>
              <td>
                <label><c:out value="${mentalfollowview.housework}"></c:out></label>
               </td>
            </tr>

           <tr>
              <td>生产劳动及工作：</td>
              <td> <label><c:out value="${mentalfollowview.productiveLaborAndWork}"></c:out></label></td>
              <td>学习能力：</td>
              <td>
               <label><c:out value="${mentalfollowview.learningAbility}"></c:out></label>
               </td>
            </tr>
             <tr>
              <td>社会人际交往：</td>
              <td><label><c:out value="${mentalfollowview.socialInterpersonal}"></c:out></label></td>
              <td  colspan="2"></td>
             
            </tr>
             <tr>
             <td colspan="4" class="title-td"></td>
           </tr>
             <tr>
              <td>患病对社会/家庭的影响：</td>
              <td> <label><c:out value="${mentalfollowview.influenceSocietyFamily}"></c:out></label>
                </td>
             <td>关锁情况：</td>
              <td><label><c:out value="${mentalfollowview.closeOrLock}"></c:out></label>
                </td>
             
            </tr>
             <tr>
              <td>住院情况：</td>
              <td> <label><c:out value="${mentalfollowview.hospitalization}"></c:out></label>
                </td>
             <td>实验室检查：</td>
              <td><label><c:out value="${mentalfollowview.laboratoryTests}"></c:out></label>
                </td>
             
            </tr>

          <tr>
             <td colspan="8" class="title-td">目前用药情况</td>
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
              <td>药物不良反应：</td>
              <td colspan="3">
             <label><c:out value="${mentalfollowview.adverseDrugReactions}"></c:out></label>
                </td>

             
            </tr>

           <tr>
              <td>药物依从性：</td>
              <td><label><c:out value="${mentalfollowview.medicationAdherence}"></c:out></label></td>
              <td>随访分类：</td>
              <td>
                <label><c:out value="${mentalfollowview.classification}"></c:out></label>
               </td>
            </tr>

           <tr>
              <td>康复措施</td>
              <td> <label><c:out value="${mentalfollowview.recoveryMeasure}"></c:out></label></td>
              <td>治疗效果</td>
              <td>
          <label><c:out value="${mentalfollowview.treatmentEffect}"></c:out></label>
               </td>
            </tr>
          <tr>
              <td>
       			   指导意见
               </td>
             <td colspan="7"><label><c:out value="${mentalfollowview.guidance}"></c:out></label></td>
            </tr>

  
        <tr>
        <td>是否转诊：</td>
        <td >
         <label><c:out value="${mentalfollowview.whetherTheReferral}"></c:out></label>
        </td>
        <td >下次随访日期： </td>
        <td><label><fmt:formatDate value="${mentalfollowview.nextDate}" pattern="yyyy-MM-dd" /></label></td>
       
      </tr>

        <tr>
        <td>随访医生：</td>
        <td >
          <label><c:out value="${mentalfollowview.followPeople}"></c:out></label>
        </td>
        <td >随访日期： </td>
        <td><label><fmt:formatDate value="${mentalfollowview.followDate}" pattern="yyyy-MM-dd" /></label></td>
       
      </tr>
      
          </tbody>
        </table>
        <div class="btn-content">
          <a href="javascript:;" class="btn btn-print">打印</a>
          <a href="<%=basePath %>oldChronicFollowAction!showOneAllFollow.action?cid=${chronicDisease.chronicDiseaseId}&hid=${healthFile.healthFileId}" class="btn">返回</a>
          <!-- <a href="javascript:;" class="btn btn-back">返回</a> -->
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
</body>
</html>
