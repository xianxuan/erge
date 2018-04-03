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
  <link  rel="stylesheet" href="/jmjkms/css/confirm.css">
  <link rel="stylesheet" href="/jmjkms/css/cssreset.css">
  <link rel="stylesheet" href="/jmjkms/css/main.css">
<link rel="stylesheet" href="/jmjkms/select2/css/select2.css">
  <link rel="stylesheet" href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">
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
      <h3 class="current-title">健康教育 <br></h3>
        <div class="table-content"> 
        <input name="yemianname"  value="05201" type="hidden"/>
          <form onsubmit="return dosubmit()" id="registerform" action="healthEducationAction!saveHealthEducation.action" method="post" enctype="multipart/form-data"> 
              <input type="hidden" name="token" value="${token }" />
				  <table class="table table-bordered" style="word-break:break-all">
				    <tbody>
						 <tr>
			             <td><span class="required">*</span>负责人</td>
			             <td>
			               <select name="staffsId" id="fzr" datatype="*" nullmsg="负责人不可为空" class="js-example-basic-single" class="select2" style="width: 170px;">
			                <s:iterator value="staffList" var="st"> 			          
			                   <option value="${st.staffId}" <c:if test="${tstaff.staffId eq st.staffId}">selected</c:if>>${st.name}</option>
	              			 </s:iterator>
			               </select>
			             </td>
			             <td><span class="required">*</span>活动主题</td>
			             <td><input class="temp" id="hdzt"  type="text" maxLength="20" name="healthEducation.activeTheme" datatype="*" nullmsg="活动主题不可为空"></td>
			           </tr>
			           <tr>
			             <td><span class="required">*</span>活动形式</td>
			             <td><input class="temp" id="hdxs"  type="text" maxLength="20" name="healthEducation.activeType"  datatype="*" nullmsg="活动形式不可为空"></td>
			             <td>活动对象<br></td>
			             <td><input  class="temp" type="text" maxLength="15" name="healthEducation.activePeople"></td>
			           </tr>
			           <tr>
			             <td><span class="required">*</span>组织者</td>
			             <td><input class="temp" id="zzz"  type="text" maxLength="10" name="healthEducation.organizer" datatype="*" nullmsg="组织者不可为空"></td>
			             <td>宣教人</td>
			             <td><input  class="temp" type="text" maxLength="10" name="healthEducation.eduPeople"></td>
			           </tr>
			           <tr>
			             <td>接受教育人员种类</td>
			             <td><input class="temp"  type="text" maxLength="20"  name="healthEducation.peopleType"></td>
			             <td><span class="required">*</span>接受教育人数</td>
			             <td><input class="temp" id="jyrs" type="text" maxLength="10" name="healthEducation.peopleNumber" datatype="n" errormsg="接受教育人数请填写数字" nullmsg="接受教育人数不可为空"></td>
			           <tr>
			             <td>活动地点</td>
			             <td><input class="temp"  type="text" maxLength="20" name="healthEducation.activePlace"></td>
			             <td><span class="required">*</span>活动时间</td>
			             <td>
			           <input  type="text" onfocus="this.blur()" name="healthEducation.activeTime" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" id="time0" >
			           </td>
			           </tr>
			           <tr>
			             <td><span class="required">*</span>填表时间</td>
			             <td colspan="3"> <input  type="text" onfocus="this.blur()" name="healthEducation.fillFormTime"  class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" id="time1" value="${currentTime}"></td>  
			           </tr>
			           <tr>
			             <td>活动内容</td>
			             <td colspan="3"><textarea maxLength="300" name="healthEducation.activeContent" id=""  class="textarea"></textarea></td>
			           </tr>
			           <tr>
			             <td>活动评价</td>
			             <td colspan="3"><textarea maxLength="300" name="healthEducation.activeEvalut" id=""  class="textarea"></textarea></td>
			           </tr>
			           <tr>
			             <td>存档资料</td>
			             <td colspan="3">
			             	<input type="file" id="file" name="upload" class="select-file" onchange="fileChange(this);">
			             	<label for="file" class="btn op" >上传文件</label>
			             	<label id="path" style="display:inline-block;width:200px;height:21px;padding-top:5px;text-align:center;"></label>
			             </td>
			           </tr> 

                    </tbody> 
                  </table>
                 <div class="btn-content">
                    <input id="submit" type="submit" class="btn" value="保存">
                    <a href="javascript:;" class="btn btn-back">返回</a>

                 </div>
             </form>
            </div> <!-- 表单表格 start -->
      
 

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
		var isCommitted = false;//表单是否已经提交标识，默认为false
		function dosubmit() {
			/* 此处还需要判断各个必填项校验是否通过*/
			//alert("1" + isCommitted);
			if (isCommitted == false
					&& document.getElementById('fzr').value != "" && document.getElementById('hdzt').value != ""
					&& document.getElementById('hdxs').value != "" && document.getElementById('zzz').value != ""
					&& document.getElementById('jyrs').value != "" && document.getElementById('time0').value != ""
					&& document.getElementById('time0').value != "") {
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

<script type="text/javascript">
	$("form").submit(function(){
		if($("#time0").val()==""){
			alert("活动时间不可为空");
			return false;
		}
		if($("#time1").val()==""){
			alert("填表时间不可为空");
			return false;
		}
	})
</script>
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
	$("#file").change(function(){
	    var src = $("#file").val();
	    var value = (src+"").split("\\");
	    $("#path").text(value[value.length-1]);
	})
</script>
<script type="text/javascript">   
  var isIE = /msie/i.test(navigator.userAgent) && !window.opera;         
  function fileChange(target) {     
      
    var fileSize = 0;          
    if (isIE && !target.files) {      
      var filePath = target.value;      
      var fileSystem = new ActiveXObject("Scripting.FileSystemObject");         
      var file = fileSystem.GetFile (filePath);      
      fileSize = file.Size;     
    } else {     
     fileSize = target.files[0].size;      
     }    
     var size = fileSize / 1024;     
     if(size>100000){   
      alert("附件不能大于100M");   

        target.value =""; 
         return false; 
     }   
     if(size<=0){ 
    alert("附件大小不能为0M！"); 
    target.value =""; 
    return false; 
    } 
       
}    
</script>
<script src="/jmjkms/select2/js/select2.full.js"></script>

<script type="text/javascript">
	$(function(){
		$(".js-example-basic-single").select2();
	})
</script>
</body>
</html>
