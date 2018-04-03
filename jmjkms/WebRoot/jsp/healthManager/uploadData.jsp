<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ page import="java.text.*"%> 
<% 
String currentTime=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); //获取系统时间 
request.setAttribute("currentTime",currentTime);
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head><meta name="viewport" content="width=device-width, initial-scale=1.0"><meta http-equiv="X-UA-Compatible" content="ie=edge">
  <meta charset="UTF-8">
  <c:choose><c:when test="${session.comHospital.isHead==0}"><title>中电科社区健康管理平台</title></c:when><c:when test="${session.communityHospitalGroup!=null}"><title>社区健康管理系统</title></c:when><c:otherwise><title>社区健康服务站</title></c:otherwise></c:choose>
  <link rel="stylesheet" href="css/cssreset.css">
  <link rel="stylesheet" href="css/main.css">
  <link rel="stylesheet" type="text/css" href="css/sweetalert.css"> 
  <link type="text/css" href="/jmjkms/css/confirm.css">
  <script src="js/sweetalert.min.js"></script> 
 <style type="text/css">  
.blur {  
    border: 1px solid red;  
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
      <h3 class="current-title">老人健康信息采集</h3>
      
      <!-- 删除此行注释，在此添加对应的div -->
      <!-- 表格容器 start -->
       <div class="search-content">
       <input name="yemianname" value="02201" type="hidden"/>
        <div class="search-item">
          <label>姓名：${localHealthFile.name}</label>
          &nbsp;&nbsp;&nbsp;&nbsp;<label>性别：<c:if test="${localHealthFile.sex==false }">男</c:if><c:if test="${localHealthFile.sex==true }">女</c:if>
          </label>&nbsp;&nbsp;&nbsp;&nbsp;<label>电话号码：${localHealthFile.IPhone}</label>
        </div>
         <div class="btn-content">
                <a href="javascript:;" id="press" class="btn" onclick="uploadData('press')">血压监测</a>
                <a href="javascript:;" id="suger" class="btn btn-default " onclick="uploadData('suger')">血糖监测</a>
                <a href="javascript:;" id="oxygen" class="btn btn-default" onclick="uploadData('oxygen')">血氧监测</a>
          </div>
      </div>
      <!-- begin -->
       <h3 class="title-td">血压监测</h3>
       <fmt:formatDate value="${now}" type="both" dateStyle="long" pattern="yyyy-MM-dd" var="bb"/>
       
       <div class="table-content">
       <!-- 血压表单表格 start -->
         <form class="registerform"  action="HealthManagerAction!uploadBloodPressData.action" method="post" id="bloodpress">
           <table class="table table-bordered">
             <tbody>
               <tr>
                 <td><span style="color:red">*</span>测量条件
                          <input type="hidden"   name="healthFileId"  value="${localHealthFile.healthFileId}"   />
                 </td>
                 <td><select name="bloodPress.meaState">
                      <option value="0">安静</option>
                      <option value="1">饮酒后</option>
                      <option value="2">运动后</option>
                   </select>
                   </td>
                 <td><span style="color:red">*</span>是否服药物</td>
                 <td>
                   <select name="bloodPress.takeMed">
                     <option value="0">未服药</option>
                     <option value="1">已服药</option>
                   </select>
                 </td>
                 <td>药物名称</td>
                 <td>
                 	  <input type="text" class="w150 temp"   maxlength='20' name="bloodPress.medName"/>
                 </td>
                  <td> <span style="color:red">*</span>测量时间</td>
                 <td> <input type="text" id="ptime" class="w150"   onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"  name="bloodPress.meaTime" value="${currentTime }" onfocus="this.blur()""
                 ></td>
               </tr>
                <tr>
                <td><span style="color:red">*</span>测量手臂</td>
                 <td><select name="bloodPress.arm"  id="">
                     <option value="0">左手</option>
                     <option value="1">右手</option>
                   </select></td>
                 <td> <span style="color:red">*</span>脉率(次/min)</td>
                 <td><input type="text" id="ml" maxlength='3' datatype="*" nullmsg="脉率不可为空" name="bloodPress.pulse"
                onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"
                 ></td>
                 <td><span style="color:red">*</span>收缩压(mmHg)</td>
                <td><input type="text" id="ssy" onkeyup="Num(this)"  maxlength='6' datatype="*" nullmsg="收缩压不可为空" name="bloodPress.sysPre"></td>
                 <td><span style="color:red">*</span>舒张压(mmHg)</td>
                 <td> <input type="text" id="szy" onkeyup="Num(this)" maxlength='6' datatype="*" nullmsg="舒张压不可为空" name="bloodPress.diaPre" ></td>
               </tr>
             </tbody>
           </table>
           <div class="btn-content">
               <input type="submit" class="btn" value="保存">
              <a href="HealthManagerAction!getHealthFileList.action" class="btn btn-xianshi">返回</a>
            </div>
         </form>
         <!-- 血压表单表格 end -->
         <!-- 血糖表单表格 start -->
         <form class="registerform"  action="HealthManagerAction!uploadBloodSugerData.action" method="post"  id="bloodSuger" style="display:none">
           <table class="table table-bordered">
             <tbody>
               <tr>
                 <td><span style="color:red">*</span>测量条件<input  type="hidden"  name="healthFileId"  value="${localHealthFile.healthFileId}" /></td>
                 <td>
                   <select name="bloodSuger.meaState">
                     <option value="0">随机</option>
                     <option value="1">空腹</option>
                     <option value="2">餐后</option>
                   </select>
                  </td>
                  
                 <td><span style="color:red">*</span>是否服药物</td>
                 <td>
                   <select name="bloodSuger.takeMed">
                     <option value="0">未服</option>
                     <option value="1">已服</option>
                   </select>
                 </td>
                  <td>药物名称</td>
                   <td>
                   		<input type="text" class="temp" name="bloodSuger.medName"   maxlength='20'/>
                   </td>
                 <td> <span style="color:red">*</span>血糖值(mmoL/L )</td>
                   <td><input type="text" id="xt" name="bloodSuger.bloodSugar"  onkeyup="Num(this)" maxlength='6' datatype="*" nullmsg="血糖值不可为空"></td>
               </tr>
                <tr>
                 <td><span style="color:red">*</span>异常报警</td>
                 <td>
                 	<select name="bloodSuger.abnAlarm">
	                     <option value="0">设为报警</option>
	                     <option value="1">设为不报警</option>
                    </select>
                  </td>
                   <td><span style="color:red">*</span>测量时间</td>
                   <td> 
                   		<input type="text" id="stime" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})"  name="bloodSuger.meaTime" value="${currentTime }"  onfocus="this.blur()">
                   </td>
                <!--  <td colspan="4"></td>     -->           
               </tr>
               <tr>
                 <td><span style="color:red">*</span>血糖分析结果</td>
                 <td colspan="7">
                 	<textarea name="bloodSuger.analysisResult" id=""  
					class="textarea temp" datatype="*" nullmsg="血糖分析结果不可为空"></textarea>
				 </td>
               </tr>
             </tbody>
           </table>
           <div class="btn-content">
              <input type="submit" class="btn" value="保存">
              <a href="HealthManagerAction!getHealthFileList.action" class="btn btn-xianshi">返回</a>
            </div>
         </form>
         <!-- 血糖表单表格 end -->
         <!-- 血氧表单表格 start -->
         <form class="registerform"  action="HealthManagerAction!uploadBloodOxygen.action"  method="post" id="bloodoxygen" style="display:none">
           <table class="table table-bordered">
             <tbody>
               <tr>
                 <td><span style="color:red">*</span>测量条件 <input  type="hidden" name="healthFileId" value="${localHealthFile.healthFileId}"   /></td>
                 <td><select name="bloodOxygen.meaState">
                     <option value="0">静息</option>
                     <option value="1">运动后</option>
                   </select>
                 </td>
                 <td><span style="color:red">*</span>是否服药</td>
                 <td>
                   <select name="bloodOxygen.takeMed">
                     <option value="0">未服</option>
                     <option value="1">已服</option>
                   </select>
                 </td>
                <td>药物名称</td>
                <td>
                   <input type="text" class="temp" name="bloodOxygen.medName"   maxlength='20' />
                </td>
                <td><span style="color:red">*</span>脉搏率(次/min)</td>
                <td><input type="text" id="mbl" name="bloodOxygen.pulse" maxlength='6' datatype="*"  nullmsg="脉搏率不可为空" 
                onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"></td>
                 </tr>
                <tr>
                   <td><span style="color:red">*</span>异常报警</td>
                   <td><select name="bloodOxygen.abnAlarm">
                     <option value="0">设为报警</option>
                     <option value="1">设为不报警</option>
                   </select>
                   </td>
                   		<td><span style="color:red">*</span>测量时间</td>
                   <td> 
                   <input type="text" id="otime" class="w150"  onclick="laydate({istime: true, format: 'YYYY-MM-DD hh:mm:ss'})" name="bloodOxygen.meaTime" value="${currentTime }" onfocus="this.blur()">
                   </td>
                   <td><span style="color:red">*</span>血氧值(%)</td>
                   <td><input type="text" id="xy"  name="bloodOxygen.oxygen" datatype="*"  nullmsg="血氧值不可为空" maxlength='10' onkeyup="Num(this)"></td>
                   </tr>
                 <tr>
                  <td><span style="color:red">*</span>血氧分析结果</td>
                 <td colspan="7">
                 	<textarea   name="bloodOxygen.analysisResult"
					class="textarea temp" datatype="*" nullmsg="血氧分析结果不可为空"></textarea>
				 </td>
            	</tr>
             </tbody>
           </table>
           <div class="btn-content">
               <input type="submit" class="btn" value="保存">
              <a href="HealthManagerAction!getHealthFileList.action" class="btn btn-xianshi">返回</a>
            </div>
         </form>
         <!-- 血氧表单表格 end -->
       </div>
       <!--end -->
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
      $(".registerform").Validform({
        showAllError:false,
        tiptype:function(msg){          
          alert(msg);
        }
      });
  });
</script>
<script type="text/javascript">
	$("form").submit(function() {
		if ( $("#ptime").val() != ""&&$("#stime").val() != ""&&$("#otime").val() != "") {
			return true;
		}
		else{
			alert("测量时间不能为空");
			return false;
		}
	})
	$("form").submit(function(){
		if($("#ml").val()>999||$("#szy").val()>999||$("ssy").val()>999){
			alert("数据值过大！")
			return false;
		}
		if($("#xt").val()>999){
			alert("数据值过大！")
			return false;
		}
		if($("#xy").val()>999||$("#mbl").val()>999){
			alert("数据值过大！")
			return false;
		}
	})
</script>
<script type="text/javascript">
     alertMessage('${message}');
    $(function(){
   		uploadData('${uploadDataType}');
     });
     //弹框显示对接系统返回的信息
      function alertMessage(message){
           if(message ==="" || message ===null){
           			return ;
           }
           var myType = "" ;
           if(message.indexOf("成功")!=-1){
               myType="success";
           }else{
           		myType="error";
           }
      swal({  
                title: message,   
                type: myType,  
                showCancelButton: false,  
                showConfirmButton:true,
                confirmButtonColor:"#fc7c00",  
                animation: "slide-from-top",  
                }
      );}
     //不同表单之间的切换
     function uploadData(value){
         if(value==="press"){
            $(".title-td").html("血压监测");
         	$("#press").attr("class","btn");
         	$("#suger").attr("class","btn btn-default ");
         	$("#oxygen").attr("class","btn btn-default ");
         	$("#bloodpress").css("display","inline");
         	$("#bloodSuger").css("display","none");
         	$("#bloodoxygen").css("display","none");
         }else if(value==="suger"){
            $(".title-td").html("血糖监测");
            $("#press").attr("class","btn btn-default ");
         	$("#suger").attr("class","btn ");
         	$("#oxygen").attr("class","btn btn-default ");
         	$("#bloodpress").css("display","none");
         	$("#bloodSuger").css("display","inline");
         	$("#bloodoxygen").css("display","none");
         }else if(value==="oxygen"){
            $(".title-td").html("血氧监测");
            $("#press").attr("class","btn btn-default ");
         	$("#suger").attr("class","btn btn-default ");
         	$("#oxygen").attr("class","btn ");
         	$("#bloodpress").css("display","none");
         	$("#bloodSuger").css("display","none");
         	$("#bloodoxygen").css("display","inline");
         }else{
            $(".title-td").html("血压监测");
         	$("#press").attr("class","btn");
         	$("#suger").attr("class","btn btn-default ");
         	$("#oxygen").attr("class","btn btn-default ");
         	$("#bloodpress").css("display","inline");
         	$("#bloodSuger").css("display","none");
         	$("#bloodoxygen").css("display","none");
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

</body>
</html>
