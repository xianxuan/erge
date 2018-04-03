<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java"%> 
<%@ page contentType="text/html; charset=utf-8"%> 
<%@ page import="java.util.*"%> <!-- //获取系统时间必须导入的  -->
<%@ page import="java.text.*"%> <!-- //获取系统时间必须导入的  -->
<% 
String datetime=new SimpleDateFormat("yyyy").format(Calendar.getInstance().getTime()); //获取系统时间 
request.setAttribute("currentTime",datetime);
%>
<!DOCTYPE html>
<html lang="en">

<head><meta name="viewport" content="width=device-width, initial-scale=1.0"><meta http-equiv="X-UA-Compatible" content="ie=edge">
  <meta charset="UTF-8">
  <c:choose><c:when test="${session.comHospital.isHead==0}"><title>中电科社区健康管理平台</title></c:when><c:when test="${session.communityHospitalGroup!=null}"><title>社区健康管理系统</title></c:when><c:otherwise><title>社区健康服务站</title></c:otherwise></c:choose>
  <base href="<%=basePath%>">
  <link rel="stylesheet" href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="/jmjkms/css/cssreset.css">
  <link rel="stylesheet" href="/jmjkms/css/main.css">
  <link rel="stylesheet" href="/jmjkms/css/confirm.css">
  <link rel="stylesheet" href="/jmjkms/select2/css/select2.css">
</head>
<body>
  <!-- 顶栏 start -->
  <c:choose>
		<c:when test='${embeded }'>
		</c:when>
		<c:otherwise>
			<s:include value="/include/header.jsp" />
		</c:otherwise>
	</c:choose>
  <!-- 顶栏 end -->
  <div class="main-content clearfix">
    <!-- 主菜单 start -->
    <c:choose>
			<c:when test='${embeded }'>
			</c:when>
			<c:otherwise>
				<s:include value="/include/nav.jsp" />
			</c:otherwise>
		</c:choose>
    <!-- 主菜单 end -->
    <div class="container">
      <h3 class="current-title">健康体检</h3>
      
      <%-- <!-- 搜索容器 start -->
 <div class="search-content">
 <form id="entity" action="<%=basePath %>PhysicalExamAction!searchMore.action" method="post">
  <input id="cp" type="hidden" name="cp1" value="${cp}">
       <s:action name="PhysicalExamAction!allDoctor" namespace="/" var="auto"></s:action>
     	<div class="search-item">
       
       <c:if test="${issq==true}">
       <label>社区医院：</label>
       	<select name="searchClass.sqId" id="">
       	 <option value="">全部</option>
       	   <s:iterator value="hospitalsList" var="hs">
       		<option value="${hs.communityHospitalId}" <c:if test='${searchClass.sqId eq hs.communityHospitalId}' >selected</c:if> >${hs.communityHospital}</option>
       	  </s:iterator>
       	</select>
       	</c:if>
       <label>查询选项：<input type="hidden" name="issetsearch" value="true"></input></label>
       <select name="searchClass.conditions" id="">
   <!--      <option value="">请选择</option> -->
         <option value="2" <c:if test="${searchClass.conditions eq 2}">selected</c:if> >姓名</option>
         <option value="1" <c:if test="${searchClass.conditions eq 1}">selected</c:if> >身份证号</option>
         <option value="3" <c:if test="${searchClass.conditions eq 3}">selected</c:if> >档案编号</option>
       </select>
       <input maxlength="20"   type="text" class="w150" name="searchClass.conditionsNum" value="${searchClass.conditionsNum}">
	   <label>年龄：</label>
       <input maxlength="3" type="text" class="w40" name="searchClass.ageStart" onkeyup="if(/\D/.test(this.value)){alert('只能输入数字');this.value='';}" value="<c:if test="${searchClass.ageStart!=0}">${searchClass.ageStart}</c:if>">至<input  maxlength="3" type="text" class="w40" onkeyup="if(/\D/.test(this.value)){alert('只能输入数字');this.value='';}" name="searchClass.ageEnd" value="<c:if test="${searchClass.ageEnd!=0}">${searchClass.ageEnd}</c:if>" >
      </div>
   <div class="search-item">
       <label>出生日期：</label>
       <input onfocus="this.blur()" class="startTime" id="dateInput1" type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD  '})" name="searchClass.birthDateStart" value="${searchClass.birthDateStart}">
       至
       <input onfocus="this.blur()" class="endTime" id="dateInput2" type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD  '})" name="searchClass.birthDateEnd"  value="${searchClass.birthDateEnd}" >
     </div>
     <div class="search-item">
       <label>建档日期：</label>
       <input onfocus="this.blur()" class="startTime" type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD  '})" name="searchClass.createdDateStart" value="${searchClass.createdDateStart}">
       至
       <input onfocus="this.blur()" class="endTime" type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD  '})" name="searchClass.createdDateEnd" value="${searchClass.createdDateEnd}">
     </div>
      <c:if test="${issq!=true}">
     <div class="search-item">
     <c:if test="${responsibility!=0}">
       <label>责任医生：</label>
       <select name="searchClass.responsibility" >
       <option value="0">请选择</option> 
		<s:iterator value="specialDoctor" var="doctor"  status="n">
		<option value="${doctor.staffId}"<c:if test="${searchClass.responsibility eq doctor.staffId}">selected=selected</c:if> >${doctor.name}
		</s:iterator>
		</select>
		</c:if>
		 <label>体检日期：</label>
       <input onfocus="this.blur()" class="startTime" type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD  '})" name="searchClass.physicalExamDateStart" value="${searchClass.physicalExamDateStart}">
       至
       <input onfocus="this.blur()" class="endTime" type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD  '})" name="searchClass.physicalExamDateEnd" value="${searchClass.physicalExamDateEnd}">
        
       
     </div>
     </c:if>
<c:if test="${responsibility!=0}">
     <div class="search-item">
     <label>建档人：</label>
          <select name="searchClass.filePerson" class="js-example-basic-single" class="select2" style="width: 170px;">
       <option value="">请选择</option> 
		<s:iterator value="doctorList" var="doctor"  status="n">
		<option value="${doctor.name}" <c:if test="${doctor.name eq searchClass.filePerson }">selected=selected</c:if>>${doctor.name}</option>
		</s:iterator>
		</select>
       <c:if test="${issq!=true}">
       <label>体检录入人：</label>
       <select name="searchClass.operator" id="" class="js-example-basic-single" class="select2" style="width: 170px;">
         <option value="">请选择</option>
         <s:iterator value="doctorList" var="doctor"  status="n">
		<option value="${doctor.name}" <c:if test="${searchClass.operator eq doctor.name}">selected</c:if>>${doctor.name}</option>
		</s:iterator>
		</select>
	</c:if>
	</div>
</c:if> 
     
     <div class="search-item">
       <label>性别查询：</label>
       <input id="all-sex" type="radio" value="0" name="searchClass.sex" <c:if test="${searchClass.sex==null || searchClass.sex==0}">checked</c:if>> <label for="all-sex"  >全部</label>
       <input id="man" type="radio" value="2" name="searchClass.sex" <c:if test="${searchClass.sex==2 }">checked</c:if> ><label for="man">男</label>
       <input id="women" type="radio" value="1" name="searchClass.sex" <c:if test="${searchClass.sex==1 }">checked</c:if>><label for="women">女</label>
     </div>
     <div class="search-item">
       <label>档案状态：</label>
       <input id="zhengchang" type="radio" value="8" name="searchClass.healthFileType" <c:if test="${searchClass.healthFileType==null || searchClass.healthFileType==8}">checked</c:if>><label for="zhengchang">正常</label>
       <input id="zhuxiao" type="radio" value="2" name="searchClass.healthFileType" <c:if test="${searchClass.healthFileType==2 }">checked</c:if>><label for="zhuxiao">注销</label>
       <input id="siwang" type="radio" value="4" name="searchClass.healthFileType" <c:if test="${searchClass.healthFileType==4 }">checked</c:if>><label for="siwang">死亡</label>
     </div>
     <div class="search-item">
       		<label style="display:inline-block;">现家庭住址：</label>
       		<div class="city_5">
			    <select class="prov" name="searchClass.currentProvince"><c:if test="${searchClass.currentProvince!=null}">${searchClass.currentProvince}</c:if> </select>
			    <select class="city" name="searchClass.currentCity" disabled="disabled" ><c:if test="${searchClass.currentCity!=null}">{searchClass.currentCity}</c:if></select>
			    <select class="dist" name="searchClass.currentCounty" disabled="disabled"><c:if test="${searchClass.currentCounty!=null}">${searchClass.currentCounty}</c:if> </select>
            </div>
             <input type="text" class="w150" name="searchClass.specific">
     </div>
     <div class="btn-content">
        <input type="submit" value="查询" class="btn" id="" name="">  
        <a id="news" href="javascript:;" class="btn">重置</a>
        <a class="btn btn-xinzeng"  href= /jmjkms/jsp/physicalExam/addPhysicalExam.jsp>添加</a>
     </div>
   </form>
 </div>
 <!-- 搜索容器 end --> --%>
    <!-- 表格容器 start -->
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
		    	 <th>体检操作</th>
		       </tr>
		     </thead>
		     <tbody>
    
     <c:forEach items="${physicalExamBypersonal.page.result}" var="re">
	        <input type="hidden" name="ids" id="id" value="${re.physicalexamid}"/>
	      	 <tr>     	 
			      	<td>${fn:substring(re.physicalexamdate,0,10)}</td> 
			     	<td>${re.responsibledoctor}</td>
			  		<td>${jiGouFileNum}</td>	
			     <td>${re.characteristicsymptom}</td>
			         <td> <a href="PhysicalExamAction!showPhysicalExam.action?physicalExamId=${re.physicalexamid}&jiGouFileNum=${jiGouFileNum}&jiGouname=${jiGouname}&jiGousex=${jiGousex}" class="btn-xianshi">查看</a></td>
	        <td>  
	          <c:if test="${belongSystem==1 && chaojiGuanLiYuanFlag!=true}"><a href="PhysicalExamAction!jumpAddPhysicalExam.action?fileNum=${jiGouFileNum}"  class="btn-xinzeng">新增</a> 
	          <a href="PhysicalExamAction!deletePhysicalExam.action?physicalExamId=${re.physicalexamid}" onclick="return confirm('是否删除？');" class="btn-shanchu">删除</a> 
	         </c:if>
	         </td>
	        </tr>
	</c:forEach>
	
	<c:forEach items="${vexamList}" var="ve">
	        <input type="hidden" name="ids" id="id"  value="${ve.physicalExamId}"/>
	      	 <tr>     	 
			      	<td>${fn:substring(ve.physicalExamDate,0,10)}</td> 
			     	<td>${ve.responsibleDoctor}</td>
			  		<td>${fileNum}</td>	
			     <td>${ve.characteristicSymptom}</td>
			         <td> <a href="PhysicalExamAction!showPhysicalExam.action?physicalExamId=${ve.physicalExamId}" class="btn-xianshi">查看</a></td>
	        <td>  
	         <c:if test="${belongSystem==1 && chaojiGuanLiYuanFlag!=true}"><a href="PhysicalExamAction!jumpAddPhysicalExam.action?fileNum=${fileNum}"  class="btn-xinzeng">新增</a> 
	          <a href="PhysicalExamAction!deletePhysicalExam.action?physicalExamId=${ve.physicalExamId}" onclick="return confirm('是否删除？');" class="btn-shanchu">删除</a> 
	         </c:if>
	         </td>
	        </tr>
	</c:forEach>
	
	
	
	
	
     </tbody>
  </table>
   <input type="hidden" name="conFlag"  id="act" value=""/>
   <input type='hidden' name='embeded' id='embeded' value='${embeded }'>
    <input type="hidden" name="healthFileId"  id="healthFileId" value="${healthFileId}"/>
   <div class="sum-btn">
        <div class="page">
			${pageHtml}  
        </div>
		<div class="btn-content2">
       		 <input type="submit" class="btn btn-daochu"  value="导出本页"  onclick="run01()"></input>
          <input type="submit" class="btn btn-daochu"  value="导出全部"  onclick="run02()"></input>
		<a href="javascript:;" class="btn" onclick="history.go(-1);">返回</a>       
	</div>
     </div>
        </form>
 </div>
 <!-- 表格容器 end -->
    </div>
    <div>
    <!-- 底栏 Start-->
    <c:choose>
			<c:when test='${embeded }'>
			</c:when>
			<c:otherwise>
				<s:include value="/include/footer.jsp" />
			</c:otherwise>
		</c:choose>
    <!-- 底栏 Start-->
  </div>

<%-- <script src="/jmjkms/js/jquery-2.1.1.min.js"></script> --%>
<script type="text/javascript" src="/jmjkms/js/threecity/jq.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
 <script type="text/javascript" src="/jmjkms/js/confirm/Validform_v5.3.2_min.js"></script>
 <script src="/jmjkms/select2/js/select2.full.js"></script>
<!-- 3级联动 -->

<script type="text/javascript" src="/jmjkms/js/threecity/jquery.cityselect.js"></script>
<script type="text/javascript" src="/jmjkms/js/threecity/location.js"></script>
<script>
function sumit(a){
		
			//document.getElementById("entity").submit();
			var g = /^[1-9]*[1-9][0-9]*$/;
            if(g.test(a)){
            		$("#cp").val(a);
            		$("#entity").submit();
            }
            else{
            	if($("#go").val()!=''){
            			if(g.test($("#go").val())){
								$("#cp").val($("#go").val());
								$("#entity").submit();
							}
					}
           	 }
}
</script>
<script type="text/javascript">
		$("#news").bind("click", function () {
                $("[name = searchbean.renqun]:checkbox").attr("checked", false);
               	$(":radio").eq(0).attr("checked", true);
                $(":radio").eq(3).attr("checked", true);
                 $(":text").val("");
    			$("textarea").val("");
    			$("select").val("");
            });
</script>
<script>
    var Obtn01=document.getElementById("btn01");
    var Obtn02=document.getElementById("btn02");
    var Obtn03=document.getElementById("btn03");
    var Oact  =document.getElementById("act");
    
    function run01(){
        Oact.value=1;
    }
    function run02(){
        Oact.value=2;
    }
    function run03(){
        Oact.value=3;
    }
</script>
<script type="text/javascript">
 $("form").submit(function(){
    	var startTime0=$(".startTime").eq(0).val();
    	var startTime1=$(".startTime").eq(1).val();
    	var endTime0=$(".endTime").eq(0).val();
    	var endTime1=$(".endTime").eq(1).val();
    	 if(startTime0 != ""&& endTime0 != ""){ 
    	if(startTime0>endTime0){
      	 	$(".startTime").eq(0).val("");
       		$(".endTime").eq(0).val("");
       		alert("查询时间输入错误");
       		return false;
       	}
        	} 
      	if(startTime1 != "" && endTime1 != ""){ 
    	if(startTime1>endTime1){
      	 	$(".startTime").eq(1).val("");
       		$(".endTime").eq(1).val("");
       		alert("查询时间输入错误");
       		return false;
       	}
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
<!-- 3级联动 -->

<script type="text/javascript">
	$(function(){
		$(".js-example-basic-single").select2();
	})
</script>

</body>
</html>
