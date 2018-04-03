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
      <h3 class="current-title">慢性病随访记录   </h3>
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
      <form action="<%=basePath %>oldChronicFollowAction!editOtherIllFollow.action" method="post">
       <div class="table-content">
        <table class="table table-bordered">
          <tbody>
           <tr>
             <td colspan="8" class="title-td">${chronicDisease.diseaseName}基本信息
             		<input type = "hidden" name="otherill.TRegOthDisId"  value= "${otherillFollow.TRegOthDisId}">
               		<input type = "hidden" name="cid"  value= "${otherillFollow.chronicDiseaseId}">
             		<input type = "hidden" name="hid"  value= "${otherillFollow.healthFileId}">
             		<input type = "hidden" name="qtid"  value= "${otherillFollow.TRegOthDisId}">
             		<input type = "hidden" name="sign.signId"  value= "${otherillFollow.signId}">
             		<input type = "hidden" name="signid"  value= "${otherillFollow.signId}">
             		<input type = "hidden" name="chronicFollow.chronicFollowId"  value= "${otherillFollow.chronicFollowId}">
             		<input type = "hidden" name = "htype"  value= "${healthFile.healthFileType}">
             
             
             </td>
           </tr>
           <%-- <tr>
             <td colspan="8">疾病名称： &nbsp;&nbsp;<label>${chronicDisease.diseaseName}</label></td>
           </tr> --%>
           <tr>
              <td  colspan="8">
            	    症状特点
                <select name="otherill.symptomCharacteristic">
                <s:if test='chronicDisease.diseaseName=="残疾障碍"'>
                  <option value="">请选择</option>
                  <option value="无法行走" <c:if test="${'无法行走' eq otherillFollow.symptomCharacteristic}">selected</c:if>>无法行走</option>
                  <option value="半身不遂" <c:if test="${'半身不遂' eq otherillFollow.symptomCharacteristic}">selected</c:if>>半身不遂</option>
                  </s:if>
                  <s:if test='chronicDisease.diseaseName=="肿瘤"'>
                  <option value="">请选择</option>
                  <option value="萎靡不振" <c:if test="${'萎靡不振' eq otherillFollow.symptomCharacteristic}">selected</c:if>>萎靡不振</option>
                  <option value="腹痛头晕" <c:if test="${'腹痛头晕' eq otherillFollow.symptomCharacteristic}">selected</c:if>>腹痛头晕</option>
                  </s:if>
                  <s:if test='chronicDisease.diseaseName=="慢性支气管病"'>
                  <option value="">请选择</option>
                  <option value="胸闷气短" <c:if test="${'胸闷气短' eq otherillFollow.symptomCharacteristic}">selected</c:if>>胸闷气短</option>
                  <option value="咳嗽" <c:if test="${'咳嗽' eq otherillFollow.symptomCharacteristic}">selected</c:if>>咳嗽</option>
                  </s:if>
                </select>
              </td>
            <tr>
              <td colspan="8" class="title-td">体征检查</td>
            </tr>
            <tr>
             <td>舒张压（mmHg）</td>
             <td>
               <input onkeyup="Num(this)" type="text" name="sign.bloodPressureH" value="${otherillFollow.bloodPressureH}" maxlength="10" >
             </td>
             <td>收缩压（mmHg）</td>
             <td>
               <input onkeyup="Num(this)" type="text" name="sign.bloodPressureL" value="${otherillFollow.bloodPressureL}"  maxlength="10" >
             </td>
             <td>身高（cm）</td>
             <td>
               <input onkeyup="Num(this)" type="text" name="sign.height" value="${otherillFollow.height}"  maxlength="10" >
             </td>
             <td>体重（kg）</td>
             <td>
               <input onkeyup="Num(this)" type="text" name="sign.wight" value="${otherillFollow.wight}"  maxlength="10" >
             </td>
            </tr>
            <tr>
              <td>体质指数</td>
              <td>
               <input onkeyup="Num(this)" type="text" name="sign.bmi" value="${otherillFollow.bmi}"  maxlength="10" >
              </td>
              <td>心率（次/分）</td>
              <td>
               <input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" name="sign.heartRate" value="${otherillFollow.heartRate}"  maxlength="10" >
              </td>
              <td>其他特征</td>
              <td colspan="3">
               <input  class="temp" type="text" name="sign.others" value="${otherillFollow.otherInspection}"  maxlength="80">
              </td>
            </tr>
            <tr>
              <td colspan="8" class="title-td">生活方式</td>
            </tr>
            <tr>
              <td>体育锻炼每周锻炼次数</td>
              <td>
               <input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" name="otherill.week" value="${otherillFollow.week}"  maxlength="10" >
              </td>
               <td>每次锻炼时间（分钟）</td>
              <td>
               <input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" name="otherill.everyTime" value="${otherillFollow.everyTime}"  maxlength="10" >
              </td>
              <td>摄盐情况(g/天)</td>
              <td>
               <input onkeyup="Num(this)" type="text" name="otherill.saltIntake" value="${otherillFollow.saltIntake}"  maxlength="10" >
              </td>
              <td>遵医行为</td>
              <td>
               <select name="otherill.medicalState">
                 <option value="">请选择</option>
                 <s:iterator value="zyxw" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq otherillFollow.medicalState}">selected</c:if>>${g.name}</option>
                 </s:iterator>
               	</select>
              </td>
            </tr>
            <tr>
              <td>饮食习惯</td>
              <td>
               <select name="otherill.eatingHabits">
                 <option value="">请选择</option>
                 <s:iterator value="ysxg" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq otherillFollow.eatingHabits}">selected</c:if>>${g.name}</option>
                 </s:iterator>
               </select>
              </td><td>心理状况</td>
              <td>
               <select name="otherill.metalState">
                 <option value="">请选择</option>
                 <s:iterator value="xlzk" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq otherillFollow.metalState}">selected</c:if>>${g.name}</option>
                 </s:iterator>
               </select>
              </td>
              <td>日吸烟平均(支)</td>
              <td>
               <input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" name="otherill.smoke" value="${otherillFollow.smoke}"  maxlength="10" >
              </td>
              <td>日饮酒平均(两)</td>
              <td>
               <input onkeyup="Num(this)" type="text" name="otherill.drink" value="${otherillFollow.drink}"  maxlength="10" >
              </td>
            </tr>
            <tr>
              <td colspan="8" class="title-td">辅助检查</td>
            </tr>
            <tr>
              <td>空腹血糖（mmol/L）</td>
              <td colspan="3">
               <input onkeyup="Num(this)" type="text" name="otherill.fastingBloodGlucose" value="${otherillFollow.fastingBloodGlucose}"  maxlength="10" >
              </td>
              <td>其他检查</td>
              <td colspan="3">
               <input  class="temp" type="text" name="otherill.otherInspection" value="${otherillFollow.otherInspection}"  maxlength="80" >
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
                         <td colspan="2"> <input class="temp"  type="text" name="listdrug[0].drugName" value="${ld.drugName}"  maxlength="20"> </td>
                         <td> <input onkeyup="Num(this)" type="text" name="listdrug[0].dailyDose" value="${ld.dailyDose}"  maxlength="10" > </td>
                         <td colspan="2"> <input class="temp"  type="text" name="listdrug[0].drugPath" value="${ld.drugPath}"  maxlength="20" ></td>
                         <td colspan="2"> <input class="temp"  type="text" name="listdrug[0].adverseReactions" value="${ld.adverseReactions}"  maxlength="50" ></td>
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
               <td>饮食控制情况</td>
               <td>
               <select name="otherill.dietControl">
                  <option value="">请选择</option>
                  <s:iterator value="yskzqk" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq otherillFollow.dietControl}">selected</c:if>>${g.name}</option>
                 </s:iterator>
                </select>
               </td>
               <td>其他治疗</td>
                <td colspan="2">
               <input  class="temp" type="text" name="otherill.otherTrett" value="${otherillFollow.otherTrett}"  maxlength="80" >
               </td>
               <td>下次随访预约时间</td>
               <td colspan="2">
               <input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="otherill.nextAppointmentDate" value="<fmt:formatDate value="${otherillFollow.nextAppointmentDate}" pattern="yyyy-MM-dd"/>" >
               </td>
             </tr>
             <tr>

               <td>随访指导意见</td>
               <td colspan="7"><textarea   class="textarea temp" name="otherill.followUpGuidance">${otherillFollow.followUpGuidance}</textarea></td>
               
             </tr>
             <tr>
               <td>备注</td>
               <td colspan="7"><textarea   name="otherill.note" id=""  class="textarea temp">${otherillFollow.note}</textarea></td>
             </tr>
             <tr>
              <td colspan="8" class="title-td">
              <input type = "hidden" name="otherill.followedUp"  value= "${otherillFollow.followedUp}"  >
              
              </td>
             </tr>
             <tr>
               <!-- <td colspan="4"></td> -->
               <%-- <td>被随访人</td>
               <td><label>${otherillFollow.followedUp}</label></td> --%>
               <td >随访医生</td>
               <td colspan="3"><label>${otherillFollow.followPeople}</label></td>
               <td>随访日期</td>
               <td colspan="3"><label><fmt:formatDate value="${otherillFollow.followDate}" pattern="yyyy-MM-dd" /></label></td>
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
