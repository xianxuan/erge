<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String formAction = "";
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
  <input name="yemianname" value="01202" type="hidden"/>
    <!-- 主菜单 start -->
    <s:include value="/include/nav.jsp" />
    <!-- 主菜单 end -->
    <!-- 主容器 start -->
    <div class="container">
       <h3 class="current-title">慢性病档案</h3>
       <%-- <s:action name="<%=basePath %>mainTainAction!getGxyType" namespace="/" var="home"></s:action> --%>
       <div class="search-content">
        <%-- <form action="<%=basePath %>showOldChronicAction!searchOlder.action">
          <label>查询选项：</label>
            <select name="idOrfid">
              <option value="0">档案编号</option>
              <option value="1">身份证号</option>
            </select>            
            <input  type="text" class="w150" name="idcardOrfild" value="${idcardOrfild}"  maxlength='20' >
            <input type="submit" class="btn" value="查询" id='btn_alert'> --%>
            
            <label>
            	姓名：<c:out value="${healthFile.name}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;档案编号：<c:out value="${healthFile.fileNum}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;
            	已有疾病：<s:iterator value="vclist" var="vl"><s:if test="status!=9">${vl.diseaseName}</s:if>&nbsp;&nbsp;&nbsp;&nbsp; </s:iterator>
            </label>
        <!-- </form> -->

        <%-- <div class="btn-content">   
            <a href="<%=basePath %>showOldChronicAction!jumpOneHighBlood.action?helid=${healthFile.healthFileId}" class="btn">高血压</a>
            <a href="<%=basePath %>showOldChronicAction!jumpDiabete.action?helid=${healthFile.healthFileId}"class="btn btn-default">糖尿病</a>
            <a href="<%=basePath %>showOldChronicAction!jumpInsanityform.action?helid=${healthFile.healthFileId}" class="btn btn-default">重性精神疾病</a>
            <a href="<%=basePath %>showOldChronicAction!jumpCoronary.action?helid=${healthFile.healthFileId}" class="btn btn-default">冠心病</a>
            <a href="<%=basePath %>showOldChronicAction!jumpBronchial.action?helid=${healthFile.healthFileId}" class="btn btn-default">慢性支气管病</a>
            <a href="<%=basePath %>showOldChronicAction!jumpTumour.action?helid=${healthFile.healthFileId}" class="btn btn-default">肿瘤</a>
            <a href="<%=basePath %>showOldChronicAction!jumpHcvd.action?helid=${healthFile.healthFileId}" class="btn btn-default">心脑血管病</a>
            <a href="<%=basePath %>showOldChronicAction!jumpDisability.action?helid=${healthFile.healthFileId}" class="btn btn-default">残疾、障碍</a>
        </div> --%>
      </div>
      <!-- 结果容器 start -->
      <h3 class="current-title">新建高血压档案</h3>
      <c:choose>
        <c:when test="${embeded }">
          <%  formAction = basePath+"showOldChronicAction!addOneHighBloodFromEmbeded.action"; 
           %>
        </c:when>
        <c:otherwise>
          <%  formAction = basePath+"showOldChronicAction!addOneHighBlood.action"; %>
        </c:otherwise>
      </c:choose>
      <form action="<%=formAction %>" onsubmit="return dosubmit()" method="post" id="registerform">
      <div class="table-content">
        <table class="table table-bordered">
          <tbody>
           <tr>
             <td colspan="8" class="title-td">基本信息<input type = "hidden" name = "helid"  value= "${healthFile.healthFileId}" ></td>
           </tr>
           <tr>
             <td>高血压类型<input type="hidden" name="token" value="${token }" /></td>
             <td colspan="2">
               <select name = "highBloodPressure.highBloodTypr">
              	<s:iterator value="gxytype" var="g">
                 <option value = "${g.name}">${g.name}</option>
                </s:iterator>
               </select>
             </td>
             <td>高血压管理分级</td>
             <td colspan="2">
               <select name = "highBloodPressure.managementClass">
                 <option value = "">请选择</option>
                 <s:iterator value="gxyglfj" var="g">
                 <option value="${g.name}">${g.name}</option>
                 </s:iterator>
               </select>
             </td>
             <td>初次诊断时间</td>
             <td><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="highBloodPressure.initialDiagnosisTime" value="${highBloodPressure.initialDiagnosisTime}"></td>
           </tr>
           <tr>
             <td>目前主要症状</td>
             <td colspan="3" >
               <select name = "highBloodPressure.mainSymptoms">
                 <option value="">请选择</option>
                 <s:iterator value="mqzyzz" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>高血压并发症</td>
             <td colspan="3">
               <select name = "highBloodPressure.hypertensionComplication">
               	 <option value="">请选择</option>
               <s:iterator value="gxybfz" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
           </tr>
           <tr>
             <td>多长时间量一次血压</td>
             <td>
               <select name = "highBloodPressure.howLongTakeBlood">
                 <option value = "">请选择</option>
                 <s:iterator value="dcsjlycxy" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>是否服用降压药</td>
             <td>
               <select name = "highBloodPressure.takeMedication">
                 <option value = "">请选择</option>
                 <option value = "是">是</option>
                 <option value = "否">否</option>
               </select>
             </td>
             <td>不服或不规律服药原因</td>
             <td>
               <select name = "highBloodPressure.notTakeReason">
                 <option value="">请选择</option>
                 <s:iterator value="bfhbglfyyy" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>每日高血压药物费用</td>
             <td>
               <input onkeyup="Num(this)" type="text" name = "highBloodPressure.drugCost" maxlength='10'>
             </td>
           </tr>
           <tr>
             <td>非药物方法治疗高血压</td>
             <td colspan="3" > 
               <select name = "highBloodPressure.nonDrugTreatment">
                 <option value = "">请选择</option>
                 <s:iterator value="fywffzlgxy" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
            <td>家族中高血压患者</td>
              <td colspan="3">
               <select name = "highBloodPressure.familyWhitHighBlood">
                 <option value = "">请选择</option>
                 <s:iterator value="jzzgxyhz" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
           </tr>

           <tr>
                <td colspan="8" class="title-td">一般情况</td>
           </tr>
          <tr>
             <td >体温</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name = "generalCondition.temperature"  maxlength='10' ></td>
             <td >呼吸频率（次/分钟）</td>
             <td><input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text"  class="w40" name = "generalCondition.breathingRate"  maxlength='10' ></td>
             <td >舒张压（mmHg）</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name = "generalCondition.diastolicPressure"  maxlength='10' ></td>
             <td>收缩压（mmHg）</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name = "generalCondition.systolicPressure"  maxlength='10' ></td>
           </tr>
           <tr>
             
             <td >脉率（次/分钟）</td>
             <td><input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text"  class="w40" name = "generalCondition.pulseRate"  maxlength='10' ></td>
             <td >身高（CM）</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name = "generalCondition.height"  maxlength='10' ></td>
             <td>体重（kg)</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name = "generalCondition.weight"  maxlength='10' ></td>
             <td>体质指数</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name = "generalCondition.bmi"  maxlength='10' ></td>
           </tr>
           <tr>
              <td>腰围（CM）</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name = "generalCondition.waistline"  maxlength='10' ></td>
             <td>臀围（CM）</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name = "generalCondition.hip"  maxlength='10' ></td>
             <td >腰臀围比值</td>
             <td colspan="4"><input onkeyup="Num(this)" type="text"  name = "generalCondition.ratio"  maxlength='10' ></td>
           </tr>

           <tr>
                <td colspan="8" class="title-td">生活方式</td>
           </tr>
           <tr>
              <td>体育锻炼频率</td>
              <td > 
               <select name = "lifeStyle.exerciseFrequency">
                 <option value = "">请选择</option>
                 <s:iterator value="tydlpl" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
              <td>每次锻炼时间（分钟）</td>
             <td><input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text"  class="w40" name = "lifeStyle.exerciseTime"  maxlength='10' ></td>
              <td>坚持锻炼时间（年）</td>
             <td><input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text"  class="w40" name = "lifeStyle.allExerciseTime"  maxlength='10' ></td>
             <td>锻炼方式</td>
             <td> 
               <select name = "lifeStyle.exerciseType">
                 <option value = "">请选择</option>
                 <s:iterator value="dlfs" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
           </tr>
           <tr>
             <td>饮食习惯</td>
             <td colspan="3"> 
               <select name = "lifeStyle.dietaryHabit">
                 <option value = "">请选择</option>
                 <s:iterator value="ysxg" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>吸烟状况</td>
             <td colspan="3"> 
               <select name = "lifeStyle.smokingStatus">
                 <option value = "">请选择</option>
                 <s:iterator value="xyzk" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
           </tr>
            <tr>
             <td>日吸烟量平均（支）</td>
             <td><input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text"  class="w40" name = "lifeStyle.smokingOneday"  maxlength='10' ></td>
             <td>开始吸烟年龄（岁）</td>
             <td><input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text"  class="w40" name = "lifeStyle.startsmokingAge"  maxlength='10' ></td>
             <td>戒烟年龄（岁）</td>
             <td><input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text"  class="w40" name = "lifeStyle.giveupSmokingAge"  maxlength='10' ></td>
             <td>饮酒频率</td>
             <td > 
               <select name = "lifeStyle.drinkingFrequency">
                 <option value = "">请选择</option>
                 <s:iterator value="yjpl" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
           </tr>
            <tr>
             <td>日饮酒量平均（两）</td>
             <td><input onkeyup="Num(this)" type="text"  class="w40" name = "lifeStyle.monthlyDrinking"  maxlength='10' ></td>
             <td>是否戒酒</td>
             <td > 
               <select name = "lifeStyle.abstinence">
                 <option value = "">请选择</option>
                 <option value = "是">是</option>
                 <option value = "否">否</option>
               </select>
             </td>
             <td>开始饮酒年龄（岁）</td>
             <td><input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text"  class="w40" name = "lifeStyle.startDrinkingAge"  maxlength='10' ></td>
             <td>近一年是否曾醉酒</td>
             <td > 
               <select name = "lifeStyle.recentlyYearDrinking">
                 <option value="">请选择</option>
                 <option value = "true">是</option>
                 <option value = "false">否</option>
               </select>
             </td>
           </tr>
           <tr>
             <td>饮酒种类</td>
             <td colspan="7"> 
               <select name = "lifeStyle.drinkingType">
                 <option value = "">请选择</option>
                 <s:iterator value="yjzl" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
           </tr>
           <tr>
             <td>是否添加到慢病管理</td>
             <td colspan="7">
               <input id="yes" type="radio"  name="chronicDisease.status" value="2" checked><label for="yes">是</label>
               <input id="no" type="radio"  name="chronicDisease.status" value="0"><label for="no">否</label>
             </td>
          </tr>
           <tr>
             <td colspan="4"></td>
             <td ><span class="required">*</span>建档人 <input type = "hidden" name = "chronicDisease.diseaseName"  value= "高血压" ></input></td>
             <td>
             <label>${filename}</label>
              <input type = "hidden" name="chronicDisease.fileName"  value="${filename}" >
             	<%-- <input type="text" name="chronicDisease.fileName" value="${filename}" datatype="*" nullmsg="建档人不可为空"></input> --%>
             	<%-- <select name="chronicDisease.fileName">
                 <option value="王红">王红</option>
                 <option value="李梅">李梅</option>
               </select> --%>
             </td>
             <td>
             	<span class="required">*</span>建档日期<input type = "hidden" name = "dqillname"  value= "高血压" >
             </td>
             <td colspan="3">
             	<input type="text" id="time"   onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name = "chronicDisease.fileDate" value="${currentTime}">
             </td>
           </tr>
          
          </tbody>
        </table>
        <input type="hidden" value="${chid}" name="chid">
        <div class="btn-content">
          <input type="submit" id="submit" class="btn" value="保存">
          <%-- <a href="<%=basePath %>showOldChronicAction!firstShowChronic.action" class="btn">返回</a> --%>
          <a href="javascript:;" class="btn btn-back">返回</a>
        </div>
      </div>
      </form>
      <!-- 结果容器 end -->
    </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>
  	<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
	<script src="/jmjkms/js/laydate/laydate.js"></script>
	<script src="/jmjkms/js/base.js"></script>
	<%-- <script type="text/javascript" src="jmjkms/js/yang/jquery-1.9.1.min.js"></script> --%>
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
	$("form").submit(function(){
		if($("#time").val()==""){
		alert("建档日期不能为空");
			return false;
		}
		else{
			return true;
		}
	})
</script>
<script>
	function Num(obj){
	obj.value = obj.value.replace(/[^\d.]/g,"");
	obj.value = obj.value.replace(/^\./g,""); 
	obj.value = obj.value.replace(/\.{2,}/g,"."); 
	obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
}
</script>

<script type="text/javascript">
		var isCommitted = false;//表单是否已经提交标识，默认为false
		function dosubmit() {
			/* 此处还需要判断各个必填项校验是否通过*/
			//alert("1" + isCommitted);
			if (isCommitted == false
					&& document.getElementById('time').value != "") {
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

</body>
</html>
