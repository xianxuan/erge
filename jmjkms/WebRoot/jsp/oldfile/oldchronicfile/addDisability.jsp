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
      <div class="search-content">
        <%-- <form action="<%=basePath %>showOldChronicAction!searchOlder.action">
          <label>查询选项：</label>
            <select name="idOrfid" id="">
              <option value="0">档案编号</option>
              <option value="1">身份证号</option>
            </select>            
            <input  type="text" class="w150" name="idcardOrfild" value="${idcardOrfild}" maxlength="20" >
            <input type="submit" class="btn" value="查询"> --%>
            <label>
            	姓名：<c:out value="${healthFile.name}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;档案编号：<c:out value="${healthFile.fileNum}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;
            	已有疾病：<s:iterator value="vclist" var="vl"><s:if test="status!=9">${vl.diseaseName}</s:if>&nbsp;&nbsp;&nbsp;&nbsp; </s:iterator>
            </label>
        <!-- </form> -->
        <%-- <div class="btn-content">
            <a href="<%=basePath %>showOldChronicAction!jumpOneHighBlood.action?helid=${healthFile.healthFileId}" class="btn btn-default">高血压</a>
            <a href="<%=basePath %>showOldChronicAction!jumpDiabete.action?helid=${healthFile.healthFileId}"class="btn btn-default">糖尿病</a>
            <a href="<%=basePath %>showOldChronicAction!jumpInsanityform.action?helid=${healthFile.healthFileId}" class="btn btn-default">重性精神疾病</a>
            <a href="<%=basePath %>showOldChronicAction!jumpCoronary.action?helid=${healthFile.healthFileId}" class="btn btn-default">冠心病</a>
            <a href="<%=basePath %>showOldChronicAction!jumpBronchial.action?helid=${healthFile.healthFileId}" class="btn btn-default">慢性支气管病</a>
            <a href="<%=basePath %>showOldChronicAction!jumpTumour.action?helid=${healthFile.healthFileId}" class="btn btn-default">肿瘤</a>
            <a href="<%=basePath %>showOldChronicAction!jumpHcvd.action?helid=${healthFile.healthFileId}" class="btn btn-default">心脑血管病</a>
            <a href="<%=basePath %>showOldChronicAction!jumpDisability.action?helid=${healthFile.healthFileId}" class="btn">残疾、障碍</a>
          </div> --%>
      </div>
      <!-- 结果容器 start -->
      <h3 class="current-title">新建残疾障碍档案</h3>
      <form action="<%=basePath %>showOldChronicAction!addDisability.action" onsubmit="return dosubmit()" method="post" id="registerform">
      <div class="table-content">
        <table class="table table-bordered">
          <tbody>
           <tr>
             <td colspan="6" class="title-td">基本信息<input type = "hidden" name = "helid"  value= "${healthFile.healthFileId}"></td>
           </tr>
           <tr>
             <td>视力残分级(有证)
             <input type="hidden" name="token" value="${token }" />
             <input type = "hidden" name = "chronicDisease.diseaseName"  value= "残疾障碍" ><input type="hidden" value="${chid}" name="chid"></td>
             <td colspan="1">
               <select name="disability.residualVisionGrading">
                 <option value="">请选择</option>
                 <s:iterator value="slcfj" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>致残原因：</td>
             <td colspan="1">
               <select name="disability.visionDisabilityReason">
                 <option value="">请选择</option>
                 <s:iterator value="cjyy" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>视力障碍(无证)：</td>
             <td colspan="1">
               <select name="disability.visualImpairment">
                 <option value="">请选择</option>
                 <option value="有">有</option>
                 <option value="无">无</option>
               </select>
             </td>
           </tr>
          <tr>
            <td>听力残分级(有证)</td>
             <td colspan="1">
               <select name="disability.gradingOfAuditusDeformity">
                 <option value="">请选择</option>
                 <s:iterator value="tlcfj" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>致残原因：</td>
             <td colspan="1">
               <select name="disability.theHearingDisabilityReason">
                 <option value="">请选择</option>
                 <s:iterator value="cjyy" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>听力障碍(无证)：</td>
             <td colspan="1">
               <select name="disability.hearingDisorder">
                 <option value="">请选择</option>
                 <option value="有">有</option>
                 <option value="无">无</option>
               </select>
             </td>
           </tr>
          <tr>
             <td>是否带有助听器：</td>
             <td colspan="1">
               <select name="disability.hearingAid">
                 <option value="">请选择</option>
                 <option value="true">是</option>
                 <option value="false">否</option>
               </select>
             </td>
            
             <td colspan="5">    
             </td>
             
           </tr>

         <tr>
             <td>言语残疾分级(有证)</td>
             <td colspan="1">
               <select name="disability.speechResidualClassification">
                 <option value="">请选择</option>
                 <s:iterator value="yycjfj" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>致残原因：</td>
             <td colspan="1">
               <select name="disability.speechDisabilityReason">
                 <option value="">请选择</option>
                 <s:iterator value="cjyy" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>言语障碍(无证)：</td>
             <td colspan="1">
               <select name="disability.speechDisorder">
                 <option value="">请选择</option>
                 <option value="有">有</option>
                 <option value="无">无</option>
               </select>
             </td>
           </tr>
              <tr>
             <td>智力残疾分级(有证)</td>
             <td colspan="1">
               <select name="disability.intelligenceResidualClassification">
                 <option value="">请选择</option>
                 <s:iterator value="zlcjfj" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>致残原因：</td>
             <td colspan="1">
               <select name="disability.intellectualDisabilityReason">
                 <option value="">请选择</option>
                 <s:iterator value="cjyy" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>智力障碍(无证)：</td>
             <td colspan="1">
               <select name="disability.dysgnosia">
                 <option value="">请选择</option>
                 <option value="有">有</option>
                 <option value="无">无</option>
               </select>
             </td>
           </tr>
              <tr>
             <td>肢体残分级(有证)</td>
             <td colspan="1">
               <select name="disability.bodyResidualClassification">
                 <option value="">请选择</option>
                 <s:iterator value="ztcfj" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>致残原因</td>
             <td colspan="1">
               <select name="disability.physicalCauses">
                 <option value="">请选择</option>
                 <s:iterator value="cjyy" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>肢体残缺</td>
             <td colspan="1">
               <select name="disability.mutilation">
                 <option value="">请选择</option>
                 <option value="有">有</option>
                 <option value="无">无</option>
               </select>
             </td>
           </tr>
           <tr>
           	<td>肢体残分类(有证)</td>
            <td colspan="7">
            	<select name="disability.bodyResidualClassificatio">
                 <option value="">请选择</option>
                 <s:iterator value="ztcfl" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
            </td>
           </tr>
              <tr>
             <td>精神病分级(有证)</td>
             <td colspan="1">
               <select name="disability.psychiatricClassification">
                 <option value="">请选择</option>
                 <s:iterator value="jsbfj" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>致残原因：</td>
             <td colspan="1">
               <select name="disability.causesMentalIllness">
                 <option value="">请选择</option>
                 <s:iterator value="cjyy" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>精神障碍(无证)：</td>
             <td colspan="1">
               <select name="disability.psychogeny">
                 <option value="">请选择</option>
                 <option value="有">有</option>
                 <option value="无">无</option>
               </select>
             </td>
           </tr>
              <tr>
             <td>精神病诊断结果：</td>
             <td colspan="1">
              <input  
               type="text" class="temp" name="disability.psychiatricDiagnosis" maxlength="50">
             </td>
             <td><span class="required">*</span>诊断机构</td>
             <td colspan="1">
              <input  
               type="text" class="temp" name="disability.diagnoseOrganization" id="zdjg" maxlength="20" datatype="*" nullmsg="诊断机构不可为空">
             </td>
             <td>有无残疾证</td>
             <td colspan="1">
               <select name="disability.whetheDisability">
               	 <option value="">请选择</option>
                 <option value="true">有</option>
                 <option value="false">无</option>
               </select>
             </td>
           </tr>

          <tr>
             <td>是否进行康复</td>
             <td colspan="1">
               <select name="disability.whetheGoRecovery">
               	 <option value="">请选择</option>
                 <option value="true">是</option>
                 <option value="false">否</option>
               </select>
             </td>
             <td>康复机构</td>
             <td colspan="1">
               <select name="disability.recoveryOrganization">
                 <option value="">请选择</option>
                 <s:iterator value="kfjg" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
            <td>不康复原因</td>
             <td colspan="1">
               <select name="disability.noRecoverReason">
                 <option value="">请选择</option>
                 <s:iterator value="bkfyy" var="g">
                 <option value="${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
           </tr>
            <tr>
              <td colspan="6">
                	备注：<textarea   name="disability.remark" id=""  class="textarea temp"></textarea>
              </td>

            </tr>
			<tr>
			<td>是否添加到慢病管理</td>
			<td colspan="7">
             <input id="yes" type="radio"  name="chronicDisease.status" value="3" checked><label for="yes">是</label>
             <input id="no" type="radio"  name="chronicDisease.status" value="0"><label for="no">否</label>
            </td>
			</tr>
             <tr>
             <%-- <td><span class="required">*</span>签名日期</td>
             <td colspan="1">
               <input type="text" class="w150" id="time" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="disability.signatureDate">  
             </td> --%>
             <td><span class="required">*</span>建档日期</td>
             <td colspan="3">
                <input type="text" class="w150" id="time" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="chronicDisease.fileDate" value="${currentTime}">  
             </td>
             <td><span class="required">*</span>建档人</td>
             <td colspan="3">
             <label>${filename}</label>
             <input type = "hidden" name="chronicDisease.fileName"  value="${filename}" >
             <%-- <input  
              type="text" name="chronicDisease.fileName" value="${filename}" datatype="*" nullmsg="建档人不可为空"></input> --%>
              </td>
             <%-- <td><span class="required">*</span>复核日期</td>
             <td colspan="1">
                <input type="text" class="w150" id="time2" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="disability.checkDate">  
             </td> --%>
           </tr>

           <!-- <tr> -->
             <%-- <td><span class="required">*</span>被调查人</td>
             <td colspan="1">
             <input  
              type="text" name="disability.respondent" maxlength="10" datatype="*" nullmsg="被调查人不可为空">
             </td> --%>
             
               <%-- <select name="chronicDisease.fileName">
                 <option value="李华">李华</option>
                 <option value="王梅">王梅</option>
               </select> --%>
             
             <%-- <td><span class="required">*</span>复核人</td>
             <td colspan="1">
             	<input  
             	 type="text" name="disability.checker" maxlength="10" datatype="*" nullmsg="复核人不可为空">
             </td> --%>
           <!-- </tr> -->

          </tbody>
        </table>
        <div class="btn-content">
          <input type="submit" id="submit" class="btn" value="保存">
          <%-- <a href="<%=basePath %>showOldChronicAction!firstShowChronic.action" class="btn">返回</a> --%>
          <a href="javascript:;" class="btn btn-back">返回</a>
        </div>
      </div>
      </form>
      <!-- 结果容器 end -->
      </div>
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>
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
	$("form").submit(function(){
		if($("#time").val()==""){
			alert("建档日期不能为空");
			return false;
		}
		/* if($("#time1").val()==""){
			alert("建档日期不能为空");
			return false;
		}
		if($("#time2").val()==""){
			alert("复核日期不能为空");
			return false;
		} */
		else{
			return true;
		}
	})
</script>

<script type="text/javascript">
		var isCommitted = false;//表单是否已经提交标识，默认为false
		function dosubmit() {
			/* 此处还需要判断各个必填项校验是否通过*/
			//alert("1" + isCommitted);
			if (isCommitted == false
					&& document.getElementById('zdjg').value != ""&& document.getElementById('time').value != "") {
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
