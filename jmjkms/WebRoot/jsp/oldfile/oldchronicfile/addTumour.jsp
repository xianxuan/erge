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
            <a href="<%=basePath %>showOldChronicAction!jumpTumour.action?helid=${healthFile.healthFileId}" class="btn">肿瘤</a>
            <a href="<%=basePath %>showOldChronicAction!jumpHcvd.action?helid=${healthFile.healthFileId}" class="btn btn-default">心脑血管病</a>
            <a href="<%=basePath %>showOldChronicAction!jumpDisability.action?helid=${healthFile.healthFileId}" class="btn btn-default">残疾、障碍</a>
          </div> --%>
      </div>
      <h3 class="current-title">新建肿瘤档案</h3>
      <form action="<%=basePath %>showOldChronicAction!addTumour.action" onsubmit="return dosubmit()" method="post" id="registerform">
      <div class="table-content">
        <table class="table table-bordered">
          <tbody>
           <tr>
             <td colspan="8" class="title-td">诊断信息<input type = "hidden" name = "helid"  value= "${healthFile.healthFileId}"></td>
           </tr>
           <tr>
             <td>诊断信息
             <input type="hidden" name="token" value="${token }" />
             <input type = "hidden" name = "chronicDisease.diseaseName"  value= "肿瘤" ></td>
             <td colspan="7" ><textarea  
              name="tumour.diagnosticInformation" id=""  class="textarea temp" ></textarea></td>
           </tr>
           <tr>  
             <td>出现日期<input type="hidden" value="${chid}" name="chid"></td>
             <td><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="tumour.emergenceDate" value=""></td>
             <td>就诊日期</td>
             <td><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="tumour.treatmentDate" value=""></td>
             <td>确诊日期</td>
             <td><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="tumour.diagnosisDate" value=""></td>
           </tr>
           <tr>
             <td>确诊医院</td>
             <td>
             <input  
                type="text" class="temp" name="tumour.diagnosedHospital"  maxlength="20">
             </td>
              <td>病理学类型</td>
             <td>
               <select name="tumour.pathologicalType">
                 <s:iterator value="blxlx" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator> 
               </select>
             </td>
             <td>确诊依据</td>
             <td colspan="2">
               <select name="tumour.confirmationBasis">
                 <s:iterator value="qzyj" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator> 
               </select>
             </td>
           </tr>
           <tr>
             <td>确诊时期别</td>
             <td>
               <select name="tumour.diagnosisPeriod">
                  <s:iterator value="qzsqb" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
             </td>
             <td>门诊号</td>
             <td>
               <input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" name="tumour.outpatientNumber"  maxlength="10"  >
             </td>
             <td>住院号</td>
             <td>
               <input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" name="tumour.inpatientNumber"  maxlength="20" >
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
                 <option value = "${g.name}">${g.name}</option>
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
               <input type="text" id="gai" class="gai"   name="tumour.tranferSituation" placeholder="请选择">
             </div>
             </td>  
           </tr>
           <tr>
                <td>曾经治疗情况</td>
             <td colspan="3">
               <select name="tumour.onceTreatment">
                 <option value="">请选择</option>
                 <s:iterator value="cjzlqk" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>  
               </select>
             </td>
             <td>目前治疗情况</td>
             <td colspan="3">
               <select name="tumour.currentTreatmentSituation">
                 <option value="">请选择</option>
                 <s:iterator value="mqzlqk" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator> 
               </select>
             </td>  
           </tr>

           <tr>
             <td  class="title-td">经治医院</td>
             <td>手术医院</td>
             <td>
               <input  
                type="text" class="temp" name="tumour.surgicalHospital"  maxlength="20" >
             </td>
             <td>化疗医院</td>
             <td>
               <input  
                type="text" class="temp" name="tumour.chemotherapyHospital"  maxlength="20">
             </td>
             <td>放疗医院</td>
             <td>
               <input  
                type="text" class="temp" name="tumour.radiotherapyHospital"  maxlength="20">
             </td>
           </tr> 
           <tr>
              <td colspan="8" class="title-td">首次手术信息</td>
           </tr>
           <tr>
              <td>手术时间</td>
             <td><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="tumour.operateTime" value=""></td>
             <td>手术医院</td>
             <td>
               <input  
                type="text" class="temp" name="tumour.operateHospital"  maxlength="20">
             </td>
             <td>住院号</td>
             <td>
               <input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" name="tumour.admissionNum" maxlength="20"  >
             </td>
             <td>手术性质</td>
             <td>
               <input  
                type="text" class="temp" name="tumour.operateProperty" maxlength="80"  >
             </td>
           </tr>
           <tr>
              <td  class="title-td">复发时间</td>
              <td>第一次</td>
              <td><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="tumour.firstTime" value=""></td>
              <td>第二次</td>
              <td><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="tumour.secondTime" value=""></td>
              <td>第三次</td>
              <td><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="tumour.thirdTime" value=""></td>
           </tr>
            <tr>
             <td>肿瘤家族史</td>
             <td colspan="8" ><textarea   name="tumour.cancerFamilyHistory" id=""  class="textarea temp"></textarea></td>
           </tr>
           <tr>
              <td colspan="8" class="title-td">诊断更改</td>
           </tr>
           <tr>
             <td>更正日期</td>
             <td colspan="3"><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="tumour.changeDate" value=""></td>
             <td>更正诊断部位</td>
             <td colspan="3">
               <input  
                type="text" class="temp" name="tumour.changeDepartment" maxlength="80" >
             </td>
           </tr>
           <tr>
              <td colspan="8" class="title-td">肿瘤登记</td>
           </tr>
           <tr>
              <td class="title-td">死亡信息</td>
              <td>死亡日期</td>
              <td ><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="tumour.deathDate"></td>
              <td>死亡原因</td>
              <td>
               <input  
                type="text" class="temp" name="tumour.deathReason" maxlength="80" >
              </td>
              <td>死亡地点</td>
              <td>
               <input  
                type="text" class="temp" name="tumour.deathAddress" maxlength="80" >
              </td>
           </tr>
           <tr>
              <td>生存期</td>
              <td>
               <input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" class="w40" name="tumour.year" maxlength="3">年<input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" class="w40" name="tumour.mounth" maxlength="2"  >个月
              </td>
              <td>撤回随诊管理日期</td>
              <td colspan="2"><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="tumour.withdrawalDate"></td>
              <td>撤销随访记录原因</td>
              <td  colspan="2">
               <select name="tumour.withdrawalReason">
                 <option value="">请选择</option>
                 <s:iterator value="cxsfjlyy" var="g">
                 <option value = "${g.name}">${g.name}</option>
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
                 <option value="">请选择</option>
                 <s:iterator value="fxfs" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator> 
               </select>
              </td>
              <td>登记方式</td>
              <td  colspan="3">
               <select name="tumour.registrationWay">
                 <option value="">请选择</option>
                 <s:iterator value="djfs" var="g">
                 <option value = "${g.name}">${g.name}</option>
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
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>  
               </select>
              </td>
              <td>细胞学</td>
              <td  colspan="3">
               <select name="tumour.cytology">
                 <option value="">请选择</option>
                 <s:iterator value="xbx" var="g">
                 <option value = "${g.name}">${g.name}</option>
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
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator> 
               </select>
              </td>
              <td>组织类型</td>
              <td  colspan="3">
               <select name="tumour.histologicalType">
                 <option value="">请选择</option>
                 <s:iterator value="zzlx" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>  
               </select>
              </td>
           </tr>
            <tr>
             <td>分期</td>
              <td  colspan="7">
               <select name="tumour.byStage">
                 <option value="">请选择</option>
                 <s:iterator value="fq" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>  
               </select>
              </td>
           </tr>
           <tr>
             <td>是否添加到慢病管理</td>
             <td colspan="7">
               <input id="yes" type="radio"  name="chronicDisease.status" value="3" checked><label for="yes">是</label>
               <input id="no" type="radio"  name="chronicDisease.status" value="0"><label for="no">否</label>
             </td>
           </tr>
           <%-- <tr>
             <td><span class="required">*</span>签名日期</td>
             <td colspan="3"><input type="text" class="w150" id="time" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="tumour.signatureDate"></td>
             <td><span class="required">*</span>被调查人</td>
             <td colspan="3">
              <input  
               type="text" name="tumour.investigatedPerson" datatype="*" nullmsg="被调查人不可为空">
             </td>
           </tr> --%>
           <tr>
             <td><span class="required">*</span>建档日期</td>
             <td colspan="3"><input type="text" class="w150" id="time" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="chronicDisease.fileDate" value="${currentTime}"></td>
             <td><span class="required">*</span>建档人</td>
             <td colspan="3">
             <label>${filename}</label>
              <input type = "hidden" name="chronicDisease.fileName"  value="${filename}" >
             
             <%-- <input  
              type="text" name="chronicDisease.fileName" value="${filename}" datatype="*" nullmsg="建档人不可为空"></input> --%>
              <%-- <select name="chronicDisease.fileName">
                 <option value="王红">王红</option>
                 <option value="李梅">李梅</option>
               </select> --%>
             </td>
           </tr>
           <%-- <tr>
             <td><span class="required">*</span>复核日期</td>
             <td colspan="3"><input type="text" class="w150" id="time2" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="tumour.reviewDate"></td>
             <td><span class="required">*</span>复核人</td>
             <td colspan="3">
              <input  
               type="text" name="tumour.reviewperson" maxlength="10" datatype="*" nullmsg="复核人不可为空">
             </td>
           </tr> --%>             
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
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>
<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<%-- <script type="text/javascript" src="/jmjkms/js/yang/jquery-1.9.1.min.js"></script> --%>
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
	
		window.onload = function(){


					var di = document.getElementsByClassName("di");
					var gai = document.getElementsByClassName("gai");

					for (var i = 0; i < di.length; i++) {
						
							di[i].di = i;
								 (function(j){
								  	gai[j].value = "请选择"; 
								 di[j].onchange = function(){
							gai[j].value = this.options[this.options.selectedIndex].value;
					
								 };	
								

							}(i));
							
					}
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
