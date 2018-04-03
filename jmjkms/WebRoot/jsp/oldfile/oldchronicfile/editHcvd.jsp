
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
      <div class="search-content">

            <label>
            	姓名：<c:out value="${vchronic.fileName}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;档案编号：<c:out value="${vchronic.fileNum}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;
            </label>


      </div>
      <!-- 结果容器 start -->
      <h3 class="current-title">编辑心脑血管病档案</h3>
      <form action="<%=basePath %>showOldChronicAction!editHcvd.action" method="post" >
      <div class="table-content">
        <table class="table table-bordered">
          <tbody>
           <tr>
             <td colspan="8" class="title-td">基本信息<input type = "hidden" name = "xnid"  value= "${vchronic.hvcdId}"></td>
           </tr>
           <tr>
             <td colspan="2">心脑血管病类型<input type="hidden" value="${chronicDisease.chronicDiseaseId}" name="chronicDisease.chronicDiseaseId"></td>
             <td colspan="6" >
               <select name="hcvd.type">
                 <s:iterator value="xnxgblx" var="g">
                  <option value="${g.name}" <c:if test="${g.name eq vchronic.hcvdType}">selected</c:if>>${g.name}</option>
                 </s:iterator>
               </select>
             </td>
           
             
           </tr>
           <tr>
            
             <td colspan="8">
             	 首诊信息：  <textarea  
             	  name="hcvd.fristDiagnose" id=""  class="textarea temp" >${vchronic.hcvdFristDiagnose}</textarea>
             </td>
             
           </tr>
           <tr>
            
             <td colspan="2">
             	危险原因：                                                                                                  <input type = "hidden" name = "htype"  value= "${vchronic.healthFileType}">
             </td>
              <td colspan="2">
              <select name="hcvd.cause">
                 <option value="">请选择</option>
                 <s:iterator value="wxyy" var="g">
                  <option value="${g.name}" <c:if test="${g.name eq vchronic.hcvdCause}">selected</c:if>>${g.name}</option>
               </s:iterator>
                 </select>
             </td>
              <td colspan="2">
            	 起病形式：
             </td>
              <td colspan="2">
              <select name="hcvd.form">
                  <option value="">请选择</option>
                   <s:iterator value="qbxs" var="g">
                  <option value="${g.name}" <c:if test="${g.name eq vchronic.hcvdForm}">selected</c:if>>${g.name}</option>
               </s:iterator>
                </select>
             </td>
             
           </tr>

              <tr>
            
             <td colspan="3">
            	 并发症：
             </td>
              <td colspan="5">
              <select name="hcvd.complication">
                <option value="">请选择</option>
                   <s:iterator value="bfz" var="g">
                  <option value="${g.name}" <c:if test="${g.name eq vchronic.hcvdComplication}">selected</c:if>>${g.name}</option>
               </s:iterator>
              </select>
             </td> 
           </tr>
        <tr>
            
             <td colspan="2">
            	 用药情况：
             </td>
              <td colspan="2">
              <select name="hcvd.useDrug">
                 <option value="">请选择</option>
                  <s:iterator value="yyqk" var="g">
                  <option value="${g.name}" <c:if test="${g.name eq vchronic.hcvdUseDrug}">selected</c:if>>${g.name}</option>
               </s:iterator>
                </select>
             </td>
              <td colspan="2">
            	 心电图：
             </td>
              <td colspan="2">
              <select name="hcvd.electrocardiogram">
                  <option value="" >请选择</option>
                    <s:iterator value="xdt" var="g">
                 <option value="${g.name}" <c:if test="${g.name eq vchronic.hcvdElectrocardiogram}">selected</c:if>>${g.name}</option>
               </s:iterator>
                
           </select>
             </td>
             
           </tr>
             <tr>
            
             <td colspan="2">
             	脑电图：
             </td>
              <td colspan="2">
              <select name="hcvd.electroencephalogram">
                 <option value="">请选择</option>
                  <s:iterator value="ndt" var="g">
               <option value="${g.name}" <c:if test="${g.name eq vchronic.hcvdElectroencephalogram}">selected</c:if>>${g.name}</option>
               </s:iterator>
                </select>
             </td>
              <td colspan="2">
            	 X线：
             </td>
              <td colspan="2">
              <select name="hcvd.x">
                  <option value="">请选择</option>
                  <s:iterator value="xx" var="g">
               <option value="${g.name}" <c:if test="${g.name eq vchronic.hcvdElectroencephalogram}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
           </tr>
             <tr>
            
             <td colspan="2">
               CT：
             </td>
              <td colspan="2">
              <select name="hcvd.ct">
                <option value="">请选择</option>
                  <s:iterator value="ct" var="g">
               <option value="${g.name}" <c:if test="${g.name eq vchronic.hcvdElectroencephalogram}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
              <td colspan="2">
            	 脑血管造影：
             </td>
              <td colspan="2">
              <select name="hcvd.cerebralBloodVessel">
                 <option value="">请选择</option>
                  <s:iterator value="nxgzy" var="g">
               <option value="${g.name}" <c:if test="${g.name eq vchronic.hcvdElectroencephalogram}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             
           </tr>

          <tr>
            
            <td  colspan="8" >
            	  备注：<textarea  
            	   name="hcvd.remarks" id=""  class="textarea temp">${vchronic.hcvdRemarks}</textarea>
            </td>
          </tr>
          
           <tr>
            
             <%-- <td >
            	 被调查人
             </td>
              <td >
              <label>${vchronic.hcvdInvestigatedPerson}</label>
             </td> --%>
              <td >
              <input type = "hidden" name = "hcvd.investigatedPerson"  value= "${vchronic.hcvdInvestigatedPerson}">
         		    建档人
             </td>
              <td >
              <label>${vchronic.chronicDiseaseFileName}</label>
             </td>
             
              <td >
             	建档日期
             </td>
              <td >
               <label><fmt:formatDate value="${vchronic.chronicDiseaseFileDate}" pattern="yyyy-MM-dd" /></label> 
             </td>
              <td >
         		    是否添加到慢病管理：
             </td>
              <td >
             <s:if test="vchronic.status==0">
               <label>否</label>
               </s:if>
               <s:if test="vchronic.status!=0">
               <label>是</label>
            	</s:if>
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
      <!-- 结果容器 end -->
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

</body>
</html>
