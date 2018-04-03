<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head><meta name="viewport" content="width=device-width, initial-scale=1.0"><meta http-equiv="X-UA-Compatible" content="ie=edge">

<meta charset="UTF-8">
<c:choose><c:when test="${session.comHospital.isHead==0}"><title>中电科社区健康管理平台</title></c:when><c:when test="${session.communityHospitalGroup!=null}"><title>社区健康管理系统</title></c:when><c:otherwise><title>社区健康服务站</title></c:otherwise></c:choose>
<link rel="stylesheet" href="css/cssreset.css">
<link rel="stylesheet" href="css/main.css">
 <link type="text/css" href="/jmjkms/css/confirm.css">
 <link rel="stylesheet" href="/jmjkms/select2/css/select2.css">
 <link rel="stylesheet" type="text/css" href="css/sweetalert.css"> 
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
			<h3 class="current-title">体检信息 </h3>
			<input name="yemianname" value="02202" type="hidden" />
			<form action="PhysicalExamAction!fuction.action" method="post">
 		<div class="table-content">
   			<table class="table table-bordered">
    		 <thead>
    		     <tr>		        
		         <th>体检时间</th>
		         <th>体检医生</th>
		         <th>居民健康档案编号</th>
		       	 <th>症状特点</th>	              
		         <th>体检查看</th>
		    	 
		       </tr>
		     </thead>
		     <tbody>
     
     <c:forEach items="${physicalExamBypersonal.page.result}" var="re">
	        <input type="hidden" name="ids" id="id" value="${re.physicalexamid}"/>
	      	 <tr>     	 
			      	<td>${re.physicalexamdate}</td> 
			     	<td>${re.responsibledoctor}</td>
			  		<td>${fileNum}</td>	
			     <td>${re.characteristicsymptom}</td>
			         <td> <a href="PhysicalExamAction!showPhysicalExam.action?physicalExamId=${-re.physicalexamid}&jiGouFileNum=${jiGouFileNum}&jiGouname=${jiGouname}&jiGousex=${jiGousex}" class="btn-xianshi">查看</a></td>
	         
	        </tr>
	</c:forEach>
     </tbody>
  </table>
   <input type="hidden" name="conFlag"  id="act" value=""/>
   <div class="sum-btn">
        <div class="page">
			${pageHtml}  
        </div>
		<div class="btn-content2">
       		 <input type="submit" class="btn btn-daochu"  value="导出本页"  onclick="run01()"></input>
          <input type="submit" class="btn btn-daochu"  value="导出全部"  onclick="run02()"></input>
               <a href="HealthDailyCheckAction!getHealthFileList.action" class="btn btn-xianshi">返回</a>
       </div>
      </div>
        </form>
 </div>
 <!-- 表格容器 end -->
		</div>
		<!-- 主容器 end -->
		<!-- 底栏 Start-->
		<s:include value="/include/footer.jsp" />
		<!-- 底栏 Start-->
	</div>


<%-- <script src="/jmjkms/js/jquery-2.1.1.min.js"></script> --%>
<!-- 3级联动 -->
<script type="text/javascript" src="/jmjkms/js/threecity/jq.js"></script>  
<script type="text/javascript" src="/jmjkms/js/threecity/jquery.cityselect.js"></script>
<script type="text/javascript" src="/jmjkms/js/threecity/location.js"></script>
<!-- 3级联动 -->
<script src="/jmjkms/select2/js/select2.full.js"></script>
<script type="text/javascript" src="/jmjkms/js/base.js"></script>
<script type="text/javascript" src="/jmjkms/js/laydate/laydate.js"></script>
<script type="text/javascript" src="/jmjkms/js/confirm/Validform_v5.3.2_min.js"></script>
<%-- <script type="text/javascript">
function alertSuggest(message){
	swal({  
                title: "医师建议", 
                text : message,
                type: "info",  
                showCancelButton: false,  
                showConfirmButton:true,  
                animation: "slide-from-top",  
                }
      );
}


function addSuggest(userId,userName){
	swal({  
                title: "添加建议", 
                text :"请在此添加您的建议",
                type: "input",  
                showCancelButton: false,  
                showConfirmButton:true,  
                animation: "slide-from-top",  
          },function(inputValue){
               $.ajax({
					type : "post",
					url : "HealthManagerAction!addSuggestByHealthFileId.action?userName="+userName+"&userId="+userId+"&doctorAdvice="+inputValue,
					dataType: "json",
					success : function(data) {
					    var message;
					    var type;
						if(data != null){
							message = data.message;
							type="success";
						}else{
						    message = "未能添加数据！！";
						    type="error";
						}
						
						swal({  
				                title: message, 
				                type: type,  
				                showCancelButton: false,  
				                showConfirmButton:true,  
				                animation: "slide-from-top",  
				          });
					}
	            });
          }
      );
}
</script>
<script type="text/javascript">
 
 alertMessage('${message}');
 
 function alertMessage(message){
      if(message !== ""){
      	 swal({  
               title: message, 
               type: "info",  
               showCancelButton: false,  
               showConfirmButton:true,  
               animation: "slide-from-top",  
               });
      }
  }
 </script> --%>
</body>
</html>
