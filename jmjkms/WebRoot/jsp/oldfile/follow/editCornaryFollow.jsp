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
  <link type="text/css" href="jmjkms/css/yang/confirm.css">
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
      
      <div class="search-content">
         <div class="search-item">
           	当前人：<c:out value="${healthFile.name}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;档案编号：<c:out value="${healthFile.fileNum}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;
          <div class="btn-content"> 
             <label class="btn">  
               		编辑${chronicDisease.diseaseName}随访记录
               		
             </label>
           </div>
          </div>
      </div>
      <form action="<%=basePath %>oldChronicFollowAction!editCornaryFollow.action?" method="post">
       <div class="table-content">
        <table class="table table-bordered">
          <tbody>
           <tr>
             <td colspan="8" class="title-td">基本信息
             			<!--下面的隐藏域用来传送冠心病id(gxbid)冠心病主键,慢病档案id,健康档案id,慢病随访主键  -->
            		 <input type = "hidden" name="gxbid"  value= "${coronaryFollow.coronaryHeartDiseaseId}" >
            		 <input type = "hidden" name="cheart.coronaryHeartDiseaseId"  value="${coronaryFollow.coronaryHeartDiseaseId}" >
               		 <input type = "hidden" name="cid"  value= "${coronaryFollow.chronicDiseaseId}" >
             		 <input type = "hidden" name="hid"  value= "${coronaryFollow.healthFileId}">
             		 <input type = "hidden" name="chronicFollow.chronicFollowId"  value="${coronaryFollow.chronicFollowId}">
             		 <input type = "hidden" name = "htype"  value= "${healthFile.healthFileType}">
             </td>
           </tr>
           <!-- <tr>
             <td colspan="8">疾病名称： &nbsp;&nbsp;<label>冠心病</label></td>
           </tr> -->
           <tr>
              <td  colspan="8">
            		   目前主要症状
                <select name="cheart.mainSymptoms">
                  <option value="">请选择</option>
                  <s:iterator value="gxbzyzz" var="g">
                  <option value="${g.name}" <c:if test="${g.name eq coronaryFollow.mainSymptoms}">selected</c:if>>${g.name}</option>
                  </s:iterator>
                </select>
              </td>
            <tr>
             <td>舒张压（mmHg）</td>
             <td>
               <input onkeyup="Num(this)" type="text" name="cheart.diastolicBloodPressure" value="${coronaryFollow.diastolicBloodPressure}" maxlength="10" >
             </td>
             <td>收缩压（mmHg）</td>
             <td>
               <input onkeyup="Num(this)" type="text" name="cheart.systolicBloodPressure" value="${coronaryFollow.systolicBloodPressure}"  maxlength="10">
             </td>
             <td>心率（次/分）</td>
             <td>
               <input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" name="cheart.heartRate" value="${coronaryFollow.heartRate}"  maxlength="10" >
             </td>
             <td>体重（kg）</td>
             <td>
               <input onkeyup="Num(this)" type="text" name="cheart.weight" value="${coronaryFollow.weight}"  maxlength="10" >
             </td>
            </tr>
            <tr>
              <td>是否有心律失常</td>
               <td>
               <select name="cheart.whetherArrhythmia">
                  <option value="">请选择</option>
                  <option value="false" <c:if test="${coronaryFollow.whetherArrhythmia eq 'false'}">selected</c:if>>否</option>
                  <option value="true" <c:if test="${coronaryFollow.whetherArrhythmia eq 'true'}">selected</c:if>>是</option>
                </select>
               </td>
               <td>是否定期测血压</td>
              <td>
               <select name="cheart.testingBloodPressure">
                  <option value="">请选择</option>
                  <s:iterator value="sfdqcxy" var="g">
                  <option value="${g.name}" <c:if test="${g.name eq coronaryFollow.testingBloodPressure}">selected</c:if>>${g.name}</option>
                  </s:iterator>
                </select>               
              </td>
               <td>平均测血压间隔时间（天）</td>
              <td>
               <input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" name="cheart.averageMeasurementTime" value="${coronaryFollow.averageMeasurementTime}"  maxlength="10" >
              </td>
              <td>是否用药</td>
              <td>
               <select name="cheart.whetherDrug">
                  <option value="">请选择</option>
                  <s:iterator value="sfyy" var="g">
                  <option value="${g.name}" <c:if test="${g.name eq coronaryFollow.whetherDrug}">selected</c:if>>${g.name}</option>
                  </s:iterator>
                </select>
              </td>
            </tr>
            
             <tr>
              <td colspan="8" class="title-td">用药情况</td>
             </tr>
             <tr>
               <td colspan="8">
                 <table class="table table-bordered">
                    <tbody>
                      <tr>
                        <tr>
                         <td colspan="2"> 药品名称</td>
                         <td> 每次剂量(mg)</td>
                         <td colspan="2"> 给药途径</td>
                         <td colspan="2"> 不良反应</td>
                         <td>操作</td>
                        </tr>
                       
                        <s:iterator value="listdrug" status="n" var="ld">
                       <tr class="dyna-form">
                         <td colspan="2"> <input class="temp"  type="text" name="listdrug[0].drugName" value="${ld.drugName}"  maxlength="20" > </td>
                         <td> <input onkeyup="Num(this)" type="text" name="listdrug[0].dailyDose" value="${ld.dailyDose}"  maxlength="10" > </td>
                         <td colspan="2"> <input class="temp"  type="text" name="listdrug[0].drugPath" value="${ld.drugPath}"  maxlength="20" ></td>
                         <td colspan="2"> <input  class="temp" type="text" name="listdrug[0].adverseReactions" value="${ld.adverseReactions}"  maxlength="50" ></td>
                         <td>
                         	<a href="javascript:;" class="btn-del">删除</a>
                            <a href="javascript:;" class="btn-add">添加</a>
                         </td>  
                      </tr>
                      </s:iterator>
                    </tbody>
                 </table>
               </td>
             </tr>
             <tr>
               <td>饮食情况</td>
               <td>
               <select name="cheart.dietState">
                  <option value="">请选择</option>
                  <s:iterator value="ysxg" var="g">
                  <option value="${g.name}" <c:if test="${g.name eq coronaryFollow.dietState}">selected</c:if>>${g.name}</option>
                  </s:iterator>
                </select>
               </td>
               <td>康复治疗情况</td>
              <td>
               <select name="cheart.treatment">
                  <option value="">请选择</option>
                  <s:iterator value="kfzlqk" var="g">
                  <option value="${g.name}" <c:if test="${g.name eq coronaryFollow.treatment}">selected</c:if>>${g.name}</option>
                  </s:iterator>
                </select>
               </td>
               <td>下次随访预约时间</td>
               <td colspan="2">
               <input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="cheart.appointmentTimeNext" value="<fmt:formatDate value="${coronaryFollow.appointmentTimeNext}" pattern="yyyy-MM-dd"/>">
               </td>
             </tr>
             <tr>
              <td>随访指导意见</td>
               <td colspan="7"><textarea   name="cheart.guidance" id=""  class="textarea temp">${coronaryFollow.guidance}</textarea></td>
             </tr>
             <tr>
               <td>备注</td>
               <td colspan="7">   <textarea   name="cheart.remark" id=""  class="textarea temp">${coronaryFollow.remark}</textarea></td>
             </tr>
             <tr>
              <td colspan="8" class="title-td"></td>
             </tr>
             <tr>
               <!-- <td colspan="2"></td> -->
              <!--  <td>被随访人</td> -->											<!--下面的隐藏域用来传被随访人属性  -->
               <%-- <td><label>${coronaryFollow.byFollowUp}</label></td> --%>
               <td>随访医生
               
               <input type = "hidden" name="cheart.byFollowUp"  value="${coronaryFollow.byFollowUp}" >
               </td>
               <td colspan="3">
                  <label>${coronaryFollow.followPeople}</label>
			   </td>
               <td>随访日期</td>
               <td colspan="3"><label><fmt:formatDate value="${coronaryFollow.followDate}" pattern="yyyy-MM-dd" /></label></td>
             </tr>
          </tbody>
        </table>
        <div class="btn-content">
          <input type="submit" class="btn" value="保存">
          <a href="javascript:;" class="btn btn-back">返回</a>
        </div>
      </div>
	</form>
    </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>

<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<script type="text/javascript" src="jmjkms/js/yang/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="jmjkms/js/yang/Validform_v5.3.2_min.js"></script>
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
