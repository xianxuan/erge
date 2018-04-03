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
<link rel="stylesheet" href="/jmjkms/select2/css/select2.css">
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
    <!-- 主菜单 start -->
    <s:include value="/include/nav.jsp" />
    <!-- 主菜单 end -->
    <!-- 主容器 start -->
    <div class="container">
      <h3 class="current-title">随诊记录-修改</h3>
      
           <!-- 删除此行注释，在此添加对应的div -->
       
          
              <label>姓名：${healthFile.name}</label>
              <label>档案编号：${healthFile.fileNum}</label>
         

            
      
       <div class="table-content">
       <input name="yemianname" value="06201" type="hidden"/>
          <form id="registerform" action="followRecordAction!updateFollowRecord.action" ,method="post" onsubmit="return dosubmit()">
           <table class="table table-bordered">

             <tbody>
             <input type="hidden" name="token" value="${token }" />
             <input type="hidden" name="healthFileId" value="${healthFile.healthFileId}"/>
             <input type="hidden" name="followRecord.followRecordId" value="${followRecord.followRecordId }"/>
               <tr>
                  <td><span class="required">*</span>随诊医生</td>
                  <td> <select name="followRecord.followDoctor" class="js-example-basic-single" class="select2" style="width: 170px;" id="Doctor" datatype="*" nullmsg="不可为空"  maxlength="5">
                           <s:iterator value="staffs"  status="n"  var="number">
                            <option value="${number.staffId}" <c:if test="${tstaff.staffId eq number.staffId}">selected</c:if>>${number.name}</option>
                           
                           <%-- <option value="${number.name}" <c:if test="${followRecord.followDoctor eq number.name}">selected</c:if>>${number.name}</option> --%>
                           </s:iterator>
                          </select>
                 </td>
                 <td><span class="required">*</span>随诊时间</td>
                 <td><input type="text" onfocus="this.blur()"  id="Date" value="${followRecord.time}" name="followRecord.time" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"></td>
                 <td>体重</td>
                 <td><input type="text" onkeyup="Num(this)" value="${followRecord.weight}" name="followRecord.weight" class="w40" onkeyup="value=value.replace(/[^\d.]/g,'')" nullmsg="1不可为空" errormsg="输入有误">KG</td>
                 <td>呼吸</td>
                 <td>
                   <input type="text" value="${followRecord.breathing}" name="followRecord.breathing"  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" nullmsg="2不可为空" errormsg="输入有误">次/分
                 </td>
               </tr>
               <tr>
                 <td>舒张压</td>
                 <td><input type="text" onkeyup="Num(this)" value="${followRecord.diastolicBloodPressure}" name="followRecord.diastolicBloodPressure" class="w40"onkeyup="value=value.replace(/[^\d.]/g,'')" nullmsg="不3可为空" errormsg="输入有误">mmgh</td>
                 <td>收缩压</td>
                 <td><input type="text" onkeyup="Num(this)" value="${followRecord.sysrolicBloodPressure}" name="followRecord.sysrolicBloodPressure" class="w40"onkeyup="value=value.replace(/[^\d.]/g,'')" nullmsg="4不可为空" errormsg="输入有误">mmgh</td>
                 <td>体温</td>
                 <td><input type="text" onkeyup="Num(this)" value="${followRecord.bodyTemperature}" name="followRecord.bodyTemperature"  onkeyup="value=value.replace(/[^\d.]/g,'')" nullmsg="5不可为空" errormsg="输入有误">摄氏度</td>
                 <td>脉搏</td>
                 <td><input type="text" value="${followRecord.pulse}"name="followRecord.pulse"  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" nullmsg="不可为空" errormsg="输入有误">次/分</td>
                 
                </tr>
               <tr rowspan="3">
               <td>现病史</td>
                 <td colspan="7"><textarea  name="followRecord.hip" id=""  class="textarea">${followRecord.hip}</textarea></td>
               </tr>
               <tr>
               <td>转归</td>
                <td>
                <div class="jia">
                       <select  id="di"  class="di">
                       		
                         <s:iterator value="zg" var="tbz">
               			  	<option value="${tbz.name}">${tbz.name}</option>
                		 </s:iterator>
                       </select>
                       <input type="text" id="gai" class="gai"   name="followRecord.outcome" value="${followRecord.outcome}" placeholder="请选择">
                     </div>
                </td>
               <!-- <td colspan="7"><textarea name="followRecord.outcome" id=""  class="textarea"></textarea></td> -->
                
               <td>主诉</td>
               
                <td>
                <div class="jia">
                       <select  id="di"  class="di">
                         <s:iterator value="zs" var="tbz">
               			  <option value="${tbz.name}">${tbz.name}</option>
                			 </s:iterator>
                       </select>
                       <input type="text" id="gai" class="gai"   name="followRecord.actionChief" value="${followRecord.actionChief}" placeholder="请选择">
                     </div>
                </td>
              <!--  <td colspan="7"><textarea name="followRecord.actionChief" id=""  class="textarea"></textarea></td> -->
                
               <td>诊断</td>
               <td>
                <div class="jia">
                       <select  id="di"  class="di">
                         <s:iterator value="zd" var="tbz">
               			  <option value="${tbz.name}">${tbz.name}</option>
                			 </s:iterator>
                       </select>
                       <input type="text" id="gai" class="gai"   name="followRecord.diagnosis" value="${followRecord.diagnosis}" placeholder="请选择">
                     </div>
                </td>
              <!--  <td colspan="7"><textarea name="followRecord.diagnosis" id=""  class="textarea"></textarea></td> -->
                
                 <td >处理情况</td>
                 <td>
                <div class="jia">
                       <select  id="di"  class="di">
                         <s:iterator value="clqk" var="tbz">
               			  <option value="${tbz.name}">${tbz.name}</option>
                			 </s:iterator>
                       </select>
                       <input type="text" id="gai" class="gai"   name="followRecord.dealWith" value="${followRecord.dealWith}" placeholder="请选择">
                     </div>
                </td>
                <!--  <td colspan="7"><textarea name="followRecord.dealWith" id=""  class="textarea"></textarea></td> -->
               </tr>
             </tbody>
             </table>

           <div class="btn-content">

            <input id="submit" type="submit" value="提交" class="btn">
              <a href="followRecordAction!showFollowRecord.action" class="btn btn-back">返回</a>
           </div>
           </form>
 </div>


    </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>
 <script type="text/javascript" src="/jmjkms/js/confirm/jquery-1.9.1.min.js"></script> 
<%-- <script src="/jmjkms/js/jquery-2.1.1.min.js"></script> --%>
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
<script type="text/javascript">
	//可输可选
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
<script>
	function Num(obj){
	obj.value = obj.value.replace(/[^\d.]/g,"");
	obj.value = obj.value.replace(/^\./g,""); 
	obj.value = obj.value.replace(/\.{2,}/g,"."); 
	obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
	}
</script>
<script type="text/javascript">
	$("form").submit(function(){
		if($("#Date").val()==""){
			alert("随诊时间不可为空")
			return false;
			
		}
	})
</script>
<script src="/jmjkms/select2/js/select2.full.js"></script> 

<script type="text/javascript">
	$(function(){
		$(".js-example-basic-single").select2();
	})
</script>
	<script type="text/javascript">
		var isCommitted = false;//表单是否已经提交标识，默认为false
		function dosubmit() {
			/* 此处还需要判断各个必填项校验是否通过*/
			//alert("1" + isCommitted);
			if (isCommitted == false
					&& document.getElementById('Doctor').value != ""&& document.getElementById('Date').value != "") {
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
