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
  <link type="text/css" href="/jmjkms/css/confirm.css">
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
      <h3 class="current-title">编辑重性精神疾病档案</h3>
      <form action="<%=basePath %>showOldChronicAction!editMental.action" method="post" id="registerform">
      <div class="table-content">
        <table class="table table-bordered">
          <tbody>
           <tr>
             <td><span class="required">*</span>监护人姓名</td>
             <td><input  
              type="text" class="temp" name="inForm.guardianName" value="${vchronic.guardianName}" datatype="*" nullmsg="监护人姓名不可为空" maxlength="10" ><input type = "hidden" name = "jsbid"  value= "${vchronic.insanityId}" ></td>
             <td>与患者关系<input type = "hidden" name = "htype"  value= "${vchronic.healthFileType}"></td>
             <td><input  
              type="text" class="temp" name="inForm.patientRelation" value="${vchronic.patientRelation}"  maxlength="10"></td>
             <td><span class="required">*</span>监护人地址</td>
             <td><input  
              type="text" class="temp" name="inForm.guardianAddress" value="${vchronic.guardianAddress}" datatype="*" nullmsg="监护人地址不可为空" maxlength="50"><input type="hidden" value="${chronicDisease.chronicDiseaseId}" name="chronicDisease.chronicDiseaseId"></td>
             <td><span class="required">*</span>监护人电话</td>
             <td><input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" name="inForm.guardianPhone" value="${vchronic.guardianPhone}" maxlength="20" datatype="*" nullmsg="监护人电话不可为空"></td>
           </tr>
           <tr>
             <td><span class="required">*</span>辖区（村）居委会联系人</td>
             <td><input  
              type="text" class="temp" name="inForm.neighborhoodLinkman" value="${vchronic.neighborhoodLinkman}" datatype="*" nullmsg="辖区（村）居委会联系人不可为空" maxlength="10"></td>
             <td><span class="required">*</span>辖区联系电话</td>
             <td><input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" name="inForm.neighborhoodPhone" value="${vchronic.neighborhoodPhone}"  maxlength="20" datatype="*" nullmsg="辖区联系电话不可为空"></td>
             <td>初次发病时间</td>
             <td><input type="text" class="w150" value="<fmt:formatDate value="${vchronic.firstAttackTime}"  pattern="yyyy-MM-dd"/>"  onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="inForm.firstAttackTime"></td>
             <td>既往主要症状</td>
             <td>
               <select name="inForm.beforeSymptom">
                 <option value="">请选择</option>
                  <s:iterator value="jwzyzz" var="g">
               <option value="${g.name}" <c:if test="${g.name eq vchronic.beforeSymptom}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
              </td>
           </tr>
           <tr>
             <td>既往治疗情况（门诊）</td>
             <td colspan="3">
               <select name="inForm.beforeCureOutpatient">
                  <s:iterator value="jwzlqkmz" var="g">
               <option value="${g.name}" <c:if test="${g.name eq vchronic.beforeCureOutpatient}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>既往治疗情况（住院）</td>
             <td>
               <div class="jia">
                <select  id="di"  class="di">
                   <option style="display:none" value=""></option>
                   <option value="">请选择</option>
                   <s:iterator value="jwzlqkzy" var="g">
                 	 <option value="${g.name}"> ${g.name}</option>
                   </s:iterator>
               </select>
               <input type="text" id="gai" class="gai" name="inForm.beforeCureHospital" value="${vchronic.beforeCureHospital}" placeholder="请选择">
               </div>
             </td>
           </tr>
           <tr>
             <td>最近诊断情况</td>
             <td colspan="3"><input  
              type="text" class="temp" name="inForm.recentlyDiagnose" value="${vchronic.recentlyDiagnose}"></td>
             <td>确认医院</td>
             <td><input  
              type="text" class="temp" name="inForm.affirmHospital"  value="${vchronic.affirmHospital}"></td>
             <td>确诊时间</td>
             <td><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="inForm.confirmedDate" value="<fmt:formatDate value="${vchronic.confirmedDate}"  pattern="yyyy-MM-dd"/>"></td>
           </tr>
           <tr>
             <td>最后一次治疗效果</td>
             <td colspan="7">
           	   <select name="inForm.recentlyCureEffect">
                 <option value="" >请选择</option>
                  <s:iterator value="zhyczlxg" var="g">
               <option value="${g.name}" <c:if test="${g.name eq vchronic.recentlyCureEffect}">selected</c:if>>${g.name}</option>
               </s:iterator>
               </select>
              </td>
           </tr>
           <tr>
             <td>患病对社会/家庭的影响</td>
             <td colspan="7">
                <div class="jia">
                     <select  id="di"  class="di">
                     <option style="display:none" value=""></option>
                     <option value="">请选择</option>
                     <s:iterator value="hbdjtshdyx" var="g">
                     		<option value="${g.name}">${g.name}</option>
                     </s:iterator>
                     </select>
                     <input type="text" id="gai" class="gai" name="inForm.influence"  value="${vchronic.influence}" placeholder="请选择">
                 </div>
              </td>
           </tr>
           <tr>
             <td>关锁情况</td>
             <td colspan="7">
               <select name="inForm.locks">
                  <option value="" >请选择</option>
                  <s:iterator value="gsqk" var="g">
                  <option value="${g.name}" <c:if test="${g.name eq vchronic.locks}">selected</c:if>>${g.name}</option>
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
             </td>
            </tr>
            <tr>
              <td colspan="4"></td>
              <td>建档人</td>
              <td>
               <label>${vchronic.chronicDiseaseFileName}</label>
             </td>
             <td>建档日期</td>
              <td>
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
      </div>
      
      <!-- 结果容器 end -->

    </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->


<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<%-- <script type="text/javascript" src="/jmjkms/js/confirm/jquery-1.9.1.min.js"></script> --%>
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
