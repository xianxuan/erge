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
      
      <!-- 搜索容器 start -->
      <div class="search-content">
        <%-- <form action="<%=basePath %>showOldChronicAction!searchOlder.action">
          <label>查询选项：</label>
            <select name="idOrfid">
              <option value="0">档案编号</option>
              <option value="1">身份证号</option>
            </select>            
            <input  type="text" class="w150" name="idcardOrfild" maxlength="20"   value="${idcardOrfild}">
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
            <a href="<%=basePath %>showOldChronicAction!jumpBronchial.action?helid=${healthFile.healthFileId}" class="btn">慢性支气管病</a>
            <a href="<%=basePath %>showOldChronicAction!jumpTumour.action?helid=${healthFile.healthFileId}" class="btn btn-default">肿瘤</a>
            <a href="<%=basePath %>showOldChronicAction!jumpHcvd.action?helid=${healthFile.healthFileId}" class="btn btn-default">心脑血管病</a>
            <a href="<%=basePath %>showOldChronicAction!jumpDisability.action?helid=${healthFile.healthFileId}" class="btn btn-default">残疾、障碍</a>
          </div> --%>
      </div>
      <h3 class="current-title">新建慢性支气管病档案</h3>
      <form action="<%=basePath %>showOldChronicAction!addBronchial.action" onsubmit="return dosubmit()" method="post" id="registerform">
      <div class="table-content">
        <table class="table table-bordered">
          <tbody>
            <tr>
              <td>确诊时间
              <input type="hidden" name="token" value="${token }" />
              <input type = "hidden" name = "helid"  value= "${healthFile.healthFileId}"></td>
              <td><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" name="cbronchialDisease.diagnosisDate" onfocus="this.blur()" value="${cbronchialDisease.diagnosisDate}"></td>
              <td>确诊医院<input type = "hidden" name = "chronicDisease.diseaseName"  value= "慢性支气管病" ></td>
              <td colspan="2">
              <input class="temp"  type="text" name="cbronchialDisease.diagnosedHospital" maxlength="10">
             </td>
             <td>每年发病次数</td>
               <td colspan="2"><input type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" name="cbronchialDisease.annualIncidence" maxlength="10" ></td>
            </tr>
            <tr>
              <td>每次发病治疗时间(天)<input type="hidden" value="${chid}" name="chid"></td>
              <td><input  type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" name="cbronchialDisease.eachTimeTreatment" maxlength="10"></td>
              <td>发病主要原因</td>
              <td colspan="3">
               <select name="cbronchialDisease.mainCausesDisease">
                 <s:iterator value="fbzyyy" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator> 
               </select>
              </td>
              <td>咳嗽程度</td>
              <td>
               <select name="cbronchialDisease.coughDegree">
                 <s:iterator value="kscd" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>  
               </select>
              </td>
            </tr>
            <tr>
              <td>咳嗽颜色</td>
              <td>
               <select name="cbronchialDisease.coughColor">
                 <s:iterator value="ksys" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>  
               </select>
              </td>
              <td>是否伴有喘息</td>
              <td>
               <select name="cbronchialDisease.isAccompaniedWheezing">
                 <option value="否">否</option>
                 <option value="是">是</option>  
               </select>
              </td>
              <td>血常规</td>
              <td>
               <select name="cbronchialDisease.routineBloodTest">
                 <option value="">请选择</option>
                 <s:iterator value="xcg" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>  
               </select>
              </td>
              <td>X线</td>
              <td>
               <select name="cbronchialDisease.XRay">
                 <option value="">请选择</option>
                   <s:iterator value="xx" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator> 
               </select>
              </td>
            </tr>
            <tr>
              <td>痰涂片或培养</td>
              <td>
               <select name="cbronchialDisease.sputumSmearCulture">
                 <option value="">请选择</option>
                 <s:iterator value="ttphpy" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>  
               </select>
              </td>
              <td>肺功能测定</td>
              <td colspan="5"><input class="temp"  type="text" name="cbronchialDisease.lungFunctionTest" maxlength="80"></td>
            </tr>
            <tr>
              <td>慢性支气管病并发症</td>
              <td colspan="2">
               <select name="cbronchialDisease.">
                 <option value="">请选择</option>
                 <s:iterator value="mxzqgbbfz" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator> 
               </select>
              </td>
              <td>自觉气短评定</td>
              <td colspan="4">
               <select name="cbronchialDisease.selefBreath">
                 <option value="">请选择</option>
                   <s:iterator value="zjqdpd" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
            </tr>
            <tr>
            	<td>心脏功能分级</td>
             <td colspan="7">
               <select name="cbronchialDisease.heartClass">
                 <option value="">请选择</option>
                 <s:iterator value="xzgnfj" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator> 
               </select>
             </td>
            </tr>
            <tr>
              <td>备注</td>
              <td colspan="7" ><textarea  
               id=""  class="textarea temp" name="cbronchialDisease.remarks"></textarea></td>
            </tr>
            <tr>
             <td>是否添加到慢病管理</td>
             <td colspan="7">
               <input id="yes" type="radio"  name="chronicDisease.status" value="3" checked><label for="yes">是</label>
               <input id="no" type="radio"  name="chronicDisease.status" value="0"><label for="no">否</label>
             </td>
            </tr>
            <tr>
             <td colspan="8" class="title-td"></td>
            </tr>
            <tr>
              <%-- <td colspan="2"></td>
              <td><span class="required">*</span>被调查人</td>
              <td>
              <input   type="text" name="cbronchialDisease.investigatedPerson" maxlength="10" datatype="*" nullmsg="被调查人不可为空">
             </td> --%>
             <td><span class="required">*</span>建档人</td>
              <td>
              <label>${filename}</label>
              <input type = "hidden" name="chronicDisease.fileName"  value="${filename}" >
               <%-- <input   type="text" name="chronicDisease.fileName" value="${filename}" datatype="*" nullmsg="建档人不可为空"></input> --%>
               <%-- <select name="chronicDisease.fileName">
                 <option value="李华">李华</option>
                 <option value="王红">王红</option>
               </select> --%>
             </td>
             <td><span class="required">*</span>建档日期</td>
              <td>
               <input type="text" class="w150" id="time" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="chronicDisease.fileDate" value="${currentTime}">
             </td>
            </tr>
          </tbody>
        </table>
        <div class="btn-content">
          <input type="submit" class="btn" id="submit" value="保存">
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
