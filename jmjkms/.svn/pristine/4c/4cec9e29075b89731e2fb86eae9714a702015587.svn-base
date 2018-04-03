<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head><meta name="viewport" content="width=device-width, initial-scale=1.0"><meta http-equiv="X-UA-Compatible" content="ie=edge">
  <meta charset="UTF-8">
  <c:choose><c:when test="${session.comHospital.isHead==0}"><title>中电科社区健康管理平台</title></c:when><c:when test="${session.communityHospitalGroup!=null}"><title>社区健康管理系统</title></c:when><c:otherwise><title>社区健康服务站</title></c:otherwise></c:choose>
  <link rel="stylesheet" href="/jmjkms/css/cssreset.css">
  <link rel="stylesheet" href="/jmjkms/css/main.css">
  <link rel="stylesheet" href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">
  <link type="text/css" href="/jmjkms/css/yang/confirm.css">
  <style type="text/css">
  .jia{
    width: 150px;
    height: 30px;
    /*background: #ccc;*/
    position: relative;
   
  }
  .di{
    width: 100px;
    height: 30px;
    position: absolute;
    top: 0;
    left: 0;
  }
  input[type="text"].gai{
    width: 70px;
    height: 22px;
    display: block;
    position: absolute;
    top: 0;
    left: 0;
  }
  </style>
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
      <h3 class="current-title">编辑肿瘤档案</h3>
      <form action="<%=basePath %>showOldChronicAction!editTumour.action" method="post" >
      <div class="table-content">
        <table class="table table-bordered">
          <tbody>
           <tr>
             <td colspan="8" class="title-td">诊断信息<input type = "hidden" name = "zlid"  value="${vchronic.tumourId}"></td>
           </tr>
           <tr>
             <td>诊断信息<input type = "hidden" name = "htype"  value= "${vchronic.healthFileType}"></td>
             <td colspan="7" ><textarea  
              name="tumour.diagnosticInformation" id=""  class="textarea temp" >${vchronic.diagnosticInformation}</textarea></td>
           </tr>
           <tr>  
             <td>出现日期<input type="hidden" value="${chronicDisease.chronicDiseaseId}" name="chronicDisease.chronicDiseaseId"></td>
             <td><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="tumour.emergenceDate" value="<fmt:formatDate value="${vchronic.emergenceDate}"  pattern="yyyy-MM-dd"/>"></td>
             <td>就诊日期</td>
             <td><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="tumour.treatmentDate" value="<fmt:formatDate value="${vchronic.treatmentDate}"  pattern="yyyy-MM-dd"/>"></td>
             <td>确诊日期</td>
             <td><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="tumour.diagnosisDate" value="<fmt:formatDate value="${vchronic.tumourDiagnosisDate}"  pattern="yyyy-MM-dd"/>"></td>
           </tr>
           <tr>
             <td>确诊医院</td>
             <td>
             <input  
                type="text" class="temp" name="tumour.diagnosedHospital" value="${vchronic.tumourDiagnosedHospital}" maxlength="20">
             </td>
              <td>病理学类型</td>
             <td>
               <select name="tumour.pathologicalType">
                  <s:iterator value="blxlx" var="g">
               <option value="${g.name}" <c:if test="${g.name eq vchronic.tumourPathologicalType}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>确诊依据</td>
             <td colspan="2">
               <select name="tumour.confirmationBasis">
                  <s:iterator value="qzyj" var="g">
               <option value="${g.name}" <c:if test="${g.name eq vchronic.confirmationBasis}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
           </tr>
           <tr>
             <td>确诊时期别</td>
             <td>
               <select name="tumour.diagnosisPeriod">
                  <s:iterator value="qzsqb" var="g">
               <option value="${g.name}" <c:if test="${g.name eq vchronic.diagnosisPeriod}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>门诊号</td>
             <td>
               <input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" name="tumour.outpatientNumber" value="${vchronic.outpatientNumber}" maxlength="10" >
             </td>
             <td>住院号</td>
             <td>
               <input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" name="tumour.inpatientNumber" value="${vchronic.inpatientNumber}" maxlength="20" >
             </td>
           </tr>
           <tr>
             <td colspan="8" class="title-td">治疗情况</td>
           </tr>
           <tr>
             <td>治疗情况</td>
             <td colspan="3">
               <select name="tumour.treatment">
                <option value="">请选择</option>
                  <s:iterator value="zlqk" var="g">
               <option value="${g.name}" <c:if test="${g.name eq vchronic.treatment}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>转移情况</td>
             <td colspan="3">
               <div class="jia">
               <select id="di"  class="di">
                 <option style="display:none"></option>
                 <option value="">请选择</option>
                 <option value="有（转移部位：          ）">有（转移部位：          ）</option>
               </select>
               <input type="text" id="gai" class="gai"   name="tumour.tranferSituation" value="${vchronic.tranferSituation}" placeholder="请选择">
             </div>
             </td>  
           </tr>
           <tr>
                <td>曾治疗情况</td>
             <td colspan="3">
               <select name="tumour.onceTreatment">
                <option value="" >请选择</option>
                  <s:iterator value="cjzlqk" var="g">
               <option value="${g.name}" <c:if test="${g.name eq vchronic.onceTreatment}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>目前治疗情况</td>
             <td colspan="3">
               <select name="tumour.currentTreatmentSituation">
                  <option value="" >请选择</option>
                  <s:iterator value="mqzlqk" var="g">
               <option value="${g.name}" <c:if test="${g.name eq vchronic.currentTreatmentSituation}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>  
           </tr>

           <tr>
             <td  class="title-td">经治医院</td>
             <td>手术医院</td>
             <td>
               <input  
                type="text" class="temp" name="tumour.surgicalHospital" value="${vchronic.surgicalHospital}" maxlength="20" >
             </td>
             <td>化疗医院</td>
             <td>
               <input  
                type="text" class="temp" name="tumour.chemotherapyHospital" value="${vchronic.chemotherapyHospital}" maxlength="20" >
             </td>
             <td>放疗医院</td>
             <td>
               <input  
                type="text" class="temp" name="tumour.radiotherapyHospital" value="${vchronic.radiotherapyHospital}" maxlength="20" >
             </td>
           </tr> 
           <tr>
              <td colspan="8" class="title-td">首次手术信息</td>
           </tr>
           <tr>
              <td>手术时间</td>
             <td><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="tumour.operateTime" value="<fmt:formatDate value="${vchronic.operateTime}"  pattern="yyyy-MM-dd"/>"></td>
             <td>手术医院</td>
             <td>
               <input  
                type="text" class="temp" name="tumour.operateHospital" value="${vchronic.operateHospital}" maxlength="20" >
             </td>
             <td>住院号</td>
             <td>
               <input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" name="tumour.admissionNum" value="${vchronic.admissionNum}" maxlength="20" >
             </td>
             <td>手术性质</td>
             <td>
               <input  
                type="text" class="temp" name="tumour.operateProperty" value="${vchronic.operateProperty}" maxlength="80" >
             </td>
           </tr>
           <tr>
              <td  class="title-td">复发时间</td>
              <td>第一次</td>
              <td><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="tumour.firstTime" value="<fmt:formatDate value="${vchronic.firstTime}"  pattern="yyyy-MM-dd"/>"></td>
              <td>第二次</td>
              <td><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="tumour.secondTime" value="<fmt:formatDate value="${vchronic.secondTime}"  pattern="yyyy-MM-dd"/>"></td>
              <td>第三次</td>
              <td><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="tumour.thirdTime" value="<fmt:formatDate value="${vchronic.thirdTime}"  pattern="yyyy-MM-dd"/>"></td>
           </tr>
            <tr>
             <td>肿瘤家族史</td>
             <td colspan="8" ><textarea   name="tumour.cancerFamilyHistory" class="textarea temp">${vchronic.cancerFamilyHistory}</textarea></td>
           </tr>
           <tr>
              <td colspan="8" class="title-td">诊断更改</td>
           </tr>
           <tr>
             <td>更正日期</td>
             <td colspan="3"><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="tumour.changeDate" value="<fmt:formatDate value="${vchronic.changeDate}"  pattern="yyyy-MM-dd"/>"></td>
             <td>更正诊断部位</td>
             <td colspan="3">
               <input  
                type="text" class="temp" name="tumour.changeDepartment" value="${vchronic.changeDepartment}" maxlength="80" >
             </td>
           </tr>
           <tr>
              <td colspan="8" class="title-td">肿瘤登记</td>
           </tr>
           <tr>
              <td class="title-td">死亡信息</td>
              <td>死亡日期</td>
              <td ><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="tumour.deathDate" value="<fmt:formatDate value="${vchronic.deathDate}"  pattern="yyyy-MM-dd"/>"></td>
              <td>死亡原因</td>
              <td>
               <input  
                type="text" class="temp" name="tumour.deathReason" value="${vchronic.deathReason}" maxlength="80" >
              </td>
              <td>死亡地点</td>
              <td>
               <input  
                type="text" class="temp" name="tumour.deathAddress" value="${vchronic.deathAddress}" maxlength="80" >
              </td>
           </tr>
           <tr>
              <td>生存期</td>
              <td>
               <input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="3" type="text" class="w40" name="tumour.year" value="${vchronic.TTumourYear}">年<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" class="w40" name="tumour.mounth" maxlength="2" value="${vchronic.mounth}">个月
              </td>
              <td>撤回随诊管理日期</td>
              <td colspan="2"><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="tumour.withdrawalDate" value="${vchronic.withdrawalDate}"></td>
              <td>撤销随访记录原因</td>
              <td  colspan="2">
               <select name="tumour.withdrawalReason">
                  <option value="" >请选择</option>
                  <s:iterator value="cxsfjlyy" var="g">
               	  <option value="${g.name}" <c:if test="${g.name eq vchronic.withdrawalReason}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
           </tr>
           <tr>
              <td colspan="8" class="title-td">原发性肺癌登记</td>
           </tr>
           <tr>
             <td>发现方式</td>
              <td  colspan="3">
               <select name="tumour.findWay">
                 <option value="" >请选择</option>
                  <s:iterator value="fxfs" var="g">
               <option value="${g.name}" <c:if test="${g.name eq vchronic.findWay}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
              </td>
              <td>登记方式</td>
              <td  colspan="3">
               <select name="tumour.registrationWay">
                  <option value="">请选择</option>
                  <s:iterator value="djfs" var="g">
               <option value="${g.name}" <c:if test="${g.name eq vchronic.registrationWay}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
              </td>
           </tr>
            <tr>
             <td>确诊依据（肺癌）</td>
              <td  colspan="3">
               <select name="tumour.diagnosisBasis">
                <option value="">请选择</option>
                  <s:iterator value="qzyj" var="g">
               <option value="${g.name}" <c:if test="${g.name eq vchronic.diagnosisBasis}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
              </td>
              <td>细胞学</td>
              <td  colspan="3">
               <select name="tumour.cytology">
                 <option value="" >请选择</option>
                  <s:iterator value="xbx" var="g">
               <option value="${g.name}" <c:if test="${g.name eq vchronic.cytology}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
              </td>
           </tr>
           <tr>
             <td>组织学</td>
              <td  colspan="3">
               <select name="tumour.hyphology">
                 <option value="">请选择</option>
                  <s:iterator value="zzx" var="g">
               <option value="${g.name}" <c:if test="${g.name eq vchronic.hyphology}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
              </td>
              <td>组织类型</td>
              <td  colspan="3">
               <select name="tumour.histologicalType">
                 <option value="">请选择</option>
                  <s:iterator value="zzlx" var="g">
               <option value="${g.name}" <c:if test="${g.name eq vchronic.tumourHistologicalType}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
              </td>
           </tr>
            <tr>
             <td>分期</td>
              <td  colspan="7">
               <select name="tumour.byStage">
                 <option value="" >请选择</option>
                  <s:iterator value="fq" var="g">
                   <option value="${g.name}" <c:if test="${g.name eq vchronic.byStage}">selected</c:if>>${g.name}</option>
                  </s:iterator>
               </select>
              </td>
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
               </label>
               <input type = "hidden" name = "tumour.investigatedPerson"  value="${vchronic.tumourInvestigatedPerson}">
               <input type = "hidden" name = "tumour.reviewDate"  value="${vchronic.reviewDate}">
               <input type = "hidden" name = "tumour.signatureDate"  value="${vchronic.tumourSignatureDate}">
               <input type = "hidden" name = "tumour.reviewperson"  value="${vchronic.reviewperson}">
             </td>
           </tr>
           <%-- <tr>
             <td>签名日期</td>
             <td colspan="3"><label><fmt:formatDate value="${vchronic.tumourSignatureDate}" pattern="yyyy-MM-dd" /></td>
             <td>被调查人</td>
             <td colspan="3">
              <label>${vchronic.tumourInvestigatedPerson}</label>
             </td>
           </tr> --%>
           <tr>
             <td>建档时间</td>
             <td colspan="3"><label><fmt:formatDate value="${vchronic.chronicDiseaseFileDate}" pattern="yyyy-MM-dd" /></label></td>
             <td>建档人</td>
             <td colspan="3">
              <label>${vchronic.chronicDiseaseFileName}</label>
             </td>
           </tr>
           <%-- <tr>
             <td>复核日期</td>
             <td colspan="3"><label><fmt:formatDate value="${vchronic.reviewDate}" pattern="yyyy-MM-dd" /></label></td>
             <td>复核人</td>
             <td colspan="3">
              <label>${vchronic.reviewperson}</label>
              
             </td>
           </tr> --%>             
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
<script type="text/javascript">
		window.onload = function(){
					var di = document.getElementsByClassName("di");
					var gai = document.getElementsByClassName("gai");

					for (var i = 0; i < di.length; i++) {
						
							di[i].di = i;
								 (function(j){
								  	//gai[j].value = "无"; 
								 di[j].onchange = function(){
							gai[j].value = this.options[this.options.selectedIndex].value;
					
								 };	
							}(i));
							
					}
					}
</script>
</body>
</html>
