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
           		<label> 查询选项：</label>
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
            <a href="<%=basePath %>showOldChronicAction!jumpOneHighBlood.action?helid=${healthFile.healthFileId}" class="btn btn-default" >高血压</a>
            <a href="<%=basePath %>showOldChronicAction!jumpDiabete.action?helid=${healthFile.healthFileId}" class="btn btn-default">糖尿病</a>
            <a href="<%=basePath %>showOldChronicAction!jumpInsanityform.action?helid=${healthFile.healthFileId}" class="btn ">重性精神疾病</a>
            <a href="<%=basePath %>showOldChronicAction!jumpCoronary.action?helid=${healthFile.healthFileId}" class="btn btn-default">冠心病</a>
            <a href="<%=basePath %>showOldChronicAction!jumpBronchial.action?helid=${healthFile.healthFileId}" class="btn btn-default">慢性支气管病</a>
            <a href="<%=basePath %>showOldChronicAction!jumpTumour.action?helid=${healthFile.healthFileId}" class="btn btn-default">肿瘤</a>
            <a href="<%=basePath %>showOldChronicAction!jumpHcvd.action?helid=${healthFile.healthFileId}" class="btn btn-default">心脑血管病</a>
            <a href="<%=basePath %>showOldChronicAction!jumpDisability.action?helid=${healthFile.healthFileId}" class="btn btn-default">残疾、障碍</a>
          </div> --%>
      </div>
      <h3 class="current-title">新建重性精神疾病档案</h3>
      <form action="<%=basePath %>showOldChronicAction!addInsanity.action" onsubmit="return dosubmit()" method="post" id="registerform">
      <div class="table-content">
        <table class="table table-bordered">
          <tbody>
           <tr>
             <td>
             <input type="hidden" name="token" value="${token }" />
             <span class="required">*</span>监护人姓名</td>
             <td><input  
              type="text" class="temp" id="jhr" name="inForm.guardianName" maxlength="10" datatype="*" nullmsg="监护人姓名不可为空"><input type = "hidden" name = "helid"  value= "${healthFile.healthFileId}" ></td>
             <td>与患者关系</td>
             <td><input  
              type="text" class="temp" name="inForm.patientRelation" maxlength="10"><input type = "hidden" name = "chronicDisease.diseaseName"  value= "重性精神疾病" ></td>
             <td><span class="required">*</span>监护人地址</td>
             <td><input  
              id="jhrdz" class="temp" type="text" name="inForm.guardianAddress" maxlength="50" datatype="*" nullmsg="监护人地址不可为空"><input type="hidden" value="${chid}" name="chid"></td>
             <td><span class="required">*</span>监护人电话</td>
             <td><input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" id="dh1" name="inForm.guardianPhone" maxlength="20" datatype="*" nullmsg="监护人电话不可为空" ></td>
           </tr>
           <tr>
             <td><span class="required">*</span>辖区（村）居委会联系人</td>
             <td><input  
              type="text" id="xqlxr" class="temp" name="inForm.neighborhoodLinkman" maxlength="10" datatype="*" nullmsg="辖区（村）居委会联系人不可为空"></td>
             <td><span class="required">*</span>辖区联系电话</td>
             <td><input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" id="dh2" name="inForm.neighborhoodPhone" maxlength="20" datatype="*" nullmsg="辖区联系电话不可为空"></td>
             <td>初次发病时间</td>
             <td><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="inForm.firstAttackTime" value="${inForm.firstAttackTime}"></td>
             <td>既往主要症状</td>
             <td>
               <select name="inForm.beforeSymptom">
                 <option value="">请选择</option>
                  <s:iterator value="jwzyzz" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
              </td>
           </tr>
           <tr>
             <td>既往治疗情况（门诊）</td>
             <td colspan="3">
               <select name="inForm.beforeCureOutpatient">
                 <option value="">请选择</option>
                 <s:iterator value="jwzlqkmz" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator> 
               </select>
             </td>
             <td>既往治疗情况（住院）</td>
             <td>
               <div class="jia">
	               <select  id="di"  class="di">
	               		 <option style="display:none"></option>
	               		 <option value="">请选择</option>
	                   <s:iterator value="jwzlqkzy" var="g">
	                 	 <option value="${g.name}"> ${g.name}</option>
	                   </s:iterator>
	               </select>
	               <input type="text" id="gai" class="gai" name="inForm.beforeCureHospital" placeholder="请选择">
               </div>
             </td>
           </tr>
           <tr>
             <td>最近诊断情况</td>
             <td colspan="3"><input  
              type="text" class="temp" name="inForm.recentlyDiagnose" maxlength="80"></td>
             <td>确认医院</td>
             <td><input  
              type="text" class="temp" name="inForm.affirmHospital" maxlength="80"></td>
             <td>确诊时间</td>
             <td><input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="inForm.confirmedDate" value="${inForm.confirmedDate}"></td>
           </tr>
           <tr>
             <td>最后一次治疗效果</td>
             <td colspan="7">
           	   <select name="inForm.recentlyCureEffect">
                 <option value="">请选择</option>
                  <s:iterator value="zhyczlxg" var="g">
                 <option value = "${g.name}">${g.name}</option>
               </s:iterator>
               </select>
              </td>
           </tr>
           <tr>
             <td>患病对家庭/社会的影响</td>
             <td colspan="7">
                 <div class="jia">
                     <select  id="di"  class="di">
                     		<option style="display:none"></option>
                     		<option value="">请选择</option>
                     <s:iterator value="hbdjtshdyx" var="g">
                     		<option value = "${g.name}"> ${g.name}</option>
                     </s:iterator>
                     </select>
                     <input type="text" id="gai" class="gai" name="inForm.influence" placeholder="请选择">
                 </div>
              </td>
           </tr>
           <tr>
             <td>关锁情况</td>
             <td colspan="7">
               <select name="inForm.locks">
                 <option value="">请选择</option>
                 <s:iterator value="gsqk" var="g">
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
            <tr>
              <td colspan="4"></td>
              <td><span class="required">*</span>建档人</td>
              <td>
              <label>${filename}</label>
              <input type = "hidden" name="chronicDisease.fileName"  value="${filename}" >
              <%-- <input  
               type="text" name="chronicDisease.fileName" value="${filename}" datatype="*" nullmsg="建档人不可为空"></input> --%>
               <%-- <select name="chronicDisease.fileName">
                 <option value="王红">王红</option>
                 <option value="李梅">李梅</option>  
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
            <input type="submit" id="submit" class="btn" value="保存">
            <%-- <a href="<%=basePath %>showOldChronicAction!firstShowChronic.action" class="btn">返回</a> --%>
            <a href="javascript:;" class="btn btn-back">返回</a>  
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

<script>
	/* document.getElementById("dh1").onblur=function checkTel(){
	var isPhone = /^([0-9]{3,4}-)?[0-9]{7,8}$/;
	var isMob=/^((\+?86)|(\(\+86\)))?(13[012356789][0-9]{8}|15[012356789][0-9]{8}|18[02356789][0-9]{8}|147[0-9]{8}|1349[0-9]{7})$/;
	var value=document.getElementById("dh1").value.trim();
	if(isMob.test(value)||isPhone.test(value)){
		return true;
	}
	else{
		alert("电话格式有误！");
		return false;
	}
	}
	document.getElementById("dh2").onblur=function checkTel(){
	var isPhone = /^([0-9]{3,4}-)?[0-9]{7,8}$/;
	var isMob=/^((\+?86)|(\(\+86\)))?(13[012356789][0-9]{8}|15[012356789][0-9]{8}|18[02356789][0-9]{8}|147[0-9]{8}|1349[0-9]{7})$/;
	var value=document.getElementById("dh2").value.trim();
	if(isMob.test(value)||isPhone.test(value)){
		return true;
	}
	else{
		alert("您输入的电话格式有误！");
		return false;
	}
	} */
	/* $(".dh").onblur(function(){
	var isPhone = /^([0-9]{3,4}-)?[0-9]{7,8}$/;
	var isMob=/^((\+?86)|(\(\+86\)))?(13[012356789][0-9]{8}|15[012356789][0-9]{8}|18[02356789][0-9]{8}|147[0-9]{8}|1349[0-9]{7})$/;
	var value0=$(".dh")[0].value.trim();
	var value1=$(".dh")[1].value.trim();
	if(value0!="" || value1!=""){
	if(isMob.test(value0)||isPhone.test(value0)){
		return true;
	}
	if(isMob.test(value1)||isPhone.test(value1)){
		return true;
	}
	
	else{
		alert("电话格式有误！");
		return false;
	}
	alert(value0);
	alert(value1);
	}
	}) */
</script>

<script type="text/javascript">
function checkTel(value){
		var isPhone =/^0\d{2,3}-?\d{7,8}$/;
		var isMob=/^((\+?86)|(\(\+86\)))?(13[012356789][0-9]{8}|15[012356789][0-9]{8}|18[02356789][0-9]{8}|147[0-9]{8}|1349[0-9]{7})$/;
		
		if(isMob.test(value)||isPhone.test(value)){
			return true;
		}else{
			return false;
		}
	}
</script>

<script type="text/javascript">
 var valuePhone = document.getElementById('dh1'); 
 var valuePhone1 = document.getElementById('dh2');
/* 电话 checkIdNum(getvalue) */
	valuePhone.onchange=function getValue(){
    var getvalue = valuePhone.value;
	if(checkTel(getvalue)==false){
		 alert("请输入正确的固话或手机号码");
		 $("#dh1").val("");
	}
}		 
valuePhone1.onchange=function getValue(){
    var getvalue = valuePhone1.value;
	if(checkTel(getvalue)==false){
		 alert("请输入正确的固话或手机号码");
		 $("#dh2").val("");
	}
}		 
		
</script>

<script type="text/javascript">
		var isCommitted = false;//表单是否已经提交标识，默认为false
		function dosubmit() {
			/* 此处还需要判断各个必填项校验是否通过*/
			//alert("1" + isCommitted);
			if (isCommitted == false
					&& document.getElementById('jhr').value != ""&& document.getElementById('jhrdz').value != ""
					&& document.getElementById('dh1').value != ""&& document.getElementById('dh2').value != ""
					&& document.getElementById('xqlxr').value != ""&& document.getElementById('time').value != "") {
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
