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
      <h3 class="current-title">慢性病随访记录</h3>
      
      <div class="search-content">
         <div class="search-item">
           	 当前人：<c:out value="${healthFile.name}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;档案编号：<c:out value="${healthFile.fileNum}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;
          <div class="btn-content"> 
             <lable class="btn">  
               		${chronicDisease.diseaseName}随访记录
               		<input type = "hidden" name="chronicFollow.diseasrName"  value= "${chronicDisease.diseaseName}" >
               		<input type = "hidden" name="cid"  value= "${chronicDisease.chronicDiseaseId}" >
               		<input type = "hidden" name="hid"  value= "${healthFile.healthFileType}">
             </lable>
           </div>
          </div>
      </div>
      <form action="<%=basePath %>oldChronicFollowAction!addCoronary.action?cid=${chronicDisease.chronicDiseaseId}&hid=${healthFile.healthFileId}" onsubmit="return dosubmit()" method="post" id="registerform">
       <div class="table-content">
        <table class="table table-bordered">
          <tbody>
           <tr>
             <td colspan="8" class="title-td">基本信息</td>
           </tr>
           <!-- <tr>
             <td colspan="8">疾病名称： &nbsp;&nbsp;<label>冠心病</label></td>
           </tr> -->
           <tr>
              <td  colspan="8">
            		   目前主要症状<input type="hidden" name="token" value="${token }" />
                <select name="cheart.mainSymptoms">
                  <option value="">请选择</option>
                  <s:iterator value="gxbzyzz" var="g">
                  <option value="${g.name}">${g.name}</option>
                  </s:iterator>
                </select>
              </td>
            <tr>
             <td>舒张压（mmHg）</td>
             <td>
               <input onkeyup="Num(this)" type="text" name="cheart.diastolicBloodPressure" maxlength="10" >
             </td>
             <td>收缩压（mmHg）</td>
             <td>
               <input onkeyup="Num(this)" type="text" name="cheart.systolicBloodPressure"  maxlength="10" >
             </td>
             <td>心率（次/分）</td>
             <td>
               <input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" name="cheart.heartRate"  maxlength="10" >
             </td>
             <td>体重（kg）</td>
             <td>
               <input onkeyup="Num(this)" type="text" name="cheart.weight"  maxlength="10" >
             </td>
            </tr>
            <tr>
              <td>是否有心律失常</td>
               <td>
               <select name="cheart.whetherArrhythmia">
                  <option value="">请选择</option>
                  <option value="true">是</option>
                  <option value="false">否</option>
                </select>
               </td>
               <td>是否定期测血压</td>
              <td>
               <select name="cheart.testingBloodPressure">
                  <option value="">请选择</option>
                  <s:iterator value="sfdqcxy" var="g">
                  <option value="${g.name}">${g.name}</option>
                  </s:iterator>
                </select>               
              </td>
               <td>平均测血压间隔时间（天）</td>
              <td>
               <input onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" name="cheart.averageMeasurementTime" maxlength="10">
              </td>
              <td>是否用药</td>
              <td>
               <select name="cheart.whetherDrug">
                  <option value="">请选择</option>
                  <s:iterator value="sfyy" var="g">
                  <option value="${g.name}">${g.name}</option>
                  </s:iterator>
                </select>
              </td>
            </tr>
            
             <tr>
              <td colspan="8" class="title-td">用药情况</td>
             </tr>
             <tr>
               <td colspan="8">
                 <table class="table table-bordered">
                    <tbody>
                      <tr>
                        <tr>
                         <td colspan="2"> 药品名称</td>
                         <td> 每次剂量(mg)</td>
                         <td colspan="2"> 给药途径</td>
                         <td> 不良反应</td>
                         <td colspan="2">操作</td>
                        </tr>
                       
                        <tr class="dyna-form">
                         <td colspan="2"> <input class="temp"  type="text" name="listdrug[0].drugName" maxlength="20"> </td>
                         <td> <input onkeyup="Num(this)" type="text" name="listdrug[0].dailyDose" maxlength="10"></td>
                         <td colspan="2"> <input class="temp"  type="text" name="listdrug[0].drugPath" maxlength="20"></td>
                         <td colspan="2"> <input class="temp"  type="text" name="listdrug[0].adverseReactions" maxlength="50"></td>
                         <td>
                         	<a href="javascript:;" class="btn-del">删除</a>
                            <a href="javascript:;" class="btn-add">添加</a>
                         </td>
                         
                      </tr> 
                    </tbody>
                 </table>
               </td>
             </tr>
             <tr>
               <td>饮食情况</td>
               <td>
               <select name="cheart.dietState">
                  <option value="">请选择</option>
                  <s:iterator value="ysxg" var="g">
                  <option value="${g.name}">${g.name}</option>
                  </s:iterator>
                </select>
               </td>
               <td>康复治疗情况</td>
              <td>
               <select name="cheart.treatment">
                  <option value="">请选择</option>
                  <s:iterator value="kfzlqk" var="g">
                  <option value="${g.name}">${g.name}</option>
                  </s:iterator>
                </select>
               </td>
               <td>下次随访预约时间</td>
               <td colspan="2">
               <input type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="cheart.appointmentTimeNext">
               </td>
             </tr>
             <tr>
              <td>随访指导意见</td>
               <td colspan="7"><textarea   name="cheart.guidance" id=""  class="textarea temp"></textarea></td>
             </tr>
             <tr>
               <td>备注</td>
               <td colspan="7">   <textarea   name="cheart.remark" id=""  class="textarea temp"></textarea></td>
             </tr>
             <tr>
              <td colspan="8" class="title-td"></td>
             </tr>
             <tr>
               <!-- <td colspan="2"></td> -->
               <%-- <td><span class="required">*</span>被随访人</td>
               <td><input   type="text" name="cheart.byFollowUp" maxlength="20" datatype="*" nullmsg="被随访人不可为空"></input></td> --%>
               <td><span class="required">*</span>随访医生</td>
               <td colspan="3">
			   	<input id="sfys" class="temp" type="text" name="chronicFollow.followPeople" maxlength="20" datatype="*" nullmsg="随访医生不可为空">
			   </td>
               <td><span class="required">*</span>随访日期</td>
               <td colspan="3"><input   type="text" id="time" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="chronicFollow.followDate" value="${currentTime}"></td>
             </tr>
          </tbody>
        </table>
        <div class="btn-content">
          <input type="submit" id="submit" class="btn" value="保存">
          <a href="<%=basePath %>showOldChronicAction!firstShowChronic.action" class="btn">返回</a>
          <!-- <a href="javascript:;" class="btn btn-back">返回</a> -->
        </div>
      </div>
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
<script type="text/javascript" src="/jmjkms/js/yang/jquery-1.9.1.min.js"></script>
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
			alert("随访日期不能为空");
			return false;
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
					&& document.getElementById('sfys').value != ""
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
