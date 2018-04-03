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
      <h3 class="current-title">慢性病档案</h3>
      
      <!-- 搜索容器 start -->
      <div class="search-content">
            <label>
            	姓名：<c:out value="${vchronic.fileName}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;档案编号：<c:out value="${vchronic.fileNum}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;
            </label>

      </div>
      <h3 class="current-title">编辑慢性支气管病档案</h3>
      <form action="<%=basePath %>showOldChronicAction!editBronchial.action" method="post" >
      <div class="table-content">
        <table class="table table-bordered">
          <tbody>
            <tr>            <!--下面的是慢性支气管病的id用隐藏域拿到  -->
              <td>确诊时间<input type = "hidden" name = "zqgid"  value= "${vchronic.chronicBronchialDiseaseId}"></td>
              <td><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" name="cbronchialDisease.diagnosisDate" onfocus="this.blur()" value="<fmt:formatDate value="${vchronic.chronicBronchialDiseaseDiagnosisDate}"  pattern="yyyy-MM-dd"/>"></td>
              <td>确诊医院</td>
              <td colspan="2">
              <input  class="temp" type="text" name="cbronchialDisease.diagnosedHospital" value="${vchronic.diagnosedHospital}" maxlength="10">
             </td>
             <td>每年发病次数<input type = "hidden" name = "htype"  value= "${vchronic.healthFileType}"></td>
               <td colspan="2"><input  type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" name="cbronchialDisease.annualIncidence" value="${vchronic.annualIncidence}" maxlength="80" ></td>
            </tr>
            <tr>					<!--下面是慢病总表的id  -->
              <td>每次发病治疗时间(天)<input type="hidden" value="${chronicDisease.chronicDiseaseId}" name="chronicDisease.chronicDiseaseId"></td>
              <td><input  type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" name="cbronchialDisease.eachTimeTreatment" maxlength="80"  value="${vchronic.eachTimeTreatment}"></td>
              <td>发病主要原因</td>
              <td colspan="3">
               <select name="cbronchialDisease.mainCausesDisease">
                 <s:iterator value="fbzyyy" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.mainCausesDisease}">selected</c:if>>${g.name}</option>
               </s:iterator> 
               </select>
              </td>
              <td>咳嗽程度</td>
              <td>
               <select name="cbronchialDisease.coughDegree">
                 <s:iterator value="kscd" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.coughDegree}">selected</c:if>>${g.name}</option>
               </s:iterator> 
               </select>
              </td>
            </tr>
            <tr>
              <td>咳嗽颜色</td>
              <td>
               <select name="cbronchialDisease.coughColor">
                 <s:iterator value="ksys" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.coughColor}">selected</c:if>>${g.name}</option>
               </s:iterator> 
               </select>
              </td>
              <td>是否伴有喘息</td>
              <td>
               <select name="cbronchialDisease.isAccompaniedWheezing">
                 <option value="否" <c:if test="${'否' eq vchronic.isAccompaniedWheezing}">selected</c:if>>否</option>
                 <option value="是" <c:if test="${'是' eq vchronic.isAccompaniedWheezing}">selected</c:if>>是</option>  
               </select>
              </td>
              <td>血常规</td>
              <td>
               <select name="cbronchialDisease.routineBloodTest">
                 <option value="">请选择</option>
                 <s:iterator value="xcg" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.routineBloodTest}">selected</c:if>>${g.name}</option>
               </s:iterator> 
               </select>
              </td>
              <td>X线</td>
              <td>
               <select name="cbronchialDisease.XRay">
                 <option value="">请选择</option>
                 <s:iterator value="xx" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.XRay}">selected</c:if>>${g.name}</option>
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
                 <option value="${g.name}" <c:if test="${ g.name eq vchronic.sputumSmearCulture}">selected</c:if>>${g.name}</option>
               </s:iterator> 
               </select>
              </td>
              <td>肺功能测定</td>
              <td colspan="5"><input type="text" class="temp" name="cbronchialDisease.lungFunctionTest" value="${vchronic.lungFunctionTest}" maxlength="80" ></td>
            </tr>
            <tr>
              <td>并发症</td>
              <td colspan="2">
               <select name="cbronchialDisease.complication">
                 <option value="">请选择</option>
                 <s:iterator value="mxzqgbbfz" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.chronicBronchialDiseaseComplication}">selected</c:if>>${g.name}</option>
               </s:iterator> 
               </select>
              </td>
              <td>自觉气短评定</td>
              <td colspan="4">
               <select name="cbronchialDisease.selefBreath">
                 <option value="" >请选择</option>
                 <s:iterator value="zjqdpd" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.selefBreath}">selected</c:if>>${g.name}</option>
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
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.heartClass}">selected</c:if>>${g.name}</option>
               </s:iterator> 
               </select>
             </td>
            </tr>
            <tr>
              <td>备注</td>
              <td colspan="7" ><textarea  
               class="textarea temp" name="cbronchialDisease.remarks" >${vchronic.chronicBronchialDiseaseRemarks}</textarea></td>
            </tr>
            <tr>
             <td>是否添加到慢病管理</td>
             <td colspan="7">
               <s:if test="vchronic.status==0">
               <label>否</label>
               </s:if>
               <s:if test="vchronic.status!=0">
               <label>是</label>
               </s:if>
               <input type="hidden" value="${vchronic.chronicBronchialDiseaseInvestigatedPerson}" name="cbronchialDisease.investigatedPerson"></input>
             </td>
            </tr>
            <tr>
             <td colspan="8" class="title-td"></td>
            </tr>
            <tr>
              <!-- <td colspan="2"></td> -->
              <%-- <td>被调查人</td>
              <td>
               <label>${vchronic.chronicBronchialDiseaseInvestigatedPerson}</label>
               
             </td> --%>
             <td>建档人</td>
              <td colspan="3">
               <label>${vchronic.chronicDiseaseFileName}</label>
             </td>
             <td>建档日期 </td>
              <td colspan="3">
               <label><fmt:formatDate value="${vchronic.chronicDiseaseFileDate}" pattern="yyyy-MM-dd" /></label>
             </td>
            </tr>
          </tbody>
        </table>
        <div class="btn-content">
          <input type="submit" class="btn" value="保存">
          <a href="<%=basePath %>showOldChronicAction!firstShowChronic.action" class="btn">返回</a>
          <!-- <a href="javascript:;" class="btn btn-back">返回</a> -->
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
<%-- <script type="text/javascript" src="jmjkms/js/yang/jquery-1.9.1.min.js"></script> --%>
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
</body>
</html>
