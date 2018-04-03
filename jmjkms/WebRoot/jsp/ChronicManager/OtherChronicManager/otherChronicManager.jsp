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
        <!-- 主容器 start -->
    <div class="container">
      <h3 class="current-title">其他慢病管理</h3>     
      <!-- 删除此行注释，在此添加对应的div -->
<div class="search-content">
<input name="yemianname" value="02206" type="hidden"/>
  <form id="entity" action="<%=basePath %>showOldChronicAction!searchChronicPeople.action">
     <div class="search-item">
      <input id="cp" type="hidden" name="cp" value="${cp}">
			       <s:if test="issq==0">
       				<label>社区医院：</label>
       				<select name="searchbean.sqid">
       				<option value="">全部</option>
       	 			<s:iterator value="hospitals" var="h">
       				<option value="${h.communityHospitalId}" <c:if test="${h.communityHospitalId eq searchbean.sqid}">selected</c:if>>${h.communityHospital}</option>
       	 			</s:iterator>
       				</select>
       				</s:if>
       				
       				<s:if test="issq==1">
       				<label>集团：</label>
       				<select name="searchbean.sqid">
       				<option value="">全部</option>
       	 			<s:iterator value="groups" var="h">
       				<option value="${h.GId}" <c:if test="${h.GId eq searchbean.sqid}">selected</c:if>>${h.groupName}</option>
       	 			</s:iterator>
       				</select>
       				</s:if>
       <label>查询选项：<input type="hidden" name="issetsearch" value="true"></input></label>
       <select name="searchbean.selectFlag" >
        <%--  <option value="0" <c:if test="${'0' eq searchbean.selectFlag}">selected</c:if>>请选择</option> --%>
         <option value="1" <c:if test="${'1' eq searchbean.selectFlag}">selected</c:if>>姓名</option>
         <option value="2" <c:if test="${'2' eq searchbean.selectFlag}">selected</c:if>>身份证号</option>
         <option value="3" <c:if test="${'3' eq searchbean.selectFlag}">selected</c:if>>档案编号</option>
       </select>
       <input name="searchbean.selectValue"   maxlength='20' type="text" class="w150 temp" maxlength='20' value="${searchbean.selectValue}">
       <label>年龄：</label>
       <input  name="searchbean.lowAge" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength='3' type="text" class="w40 temp" value="<c:if test="${searchbean.lowAge!=0}">${searchbean.lowAge}</c:if>">至<input maxlength='3'   name="searchbean.highAge" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" value="<c:if test="${searchbean.highAge!=0}">${searchbean.highAge}</c:if>" type="text" class="w40">岁
     </div>
    <%--  <div class="search-item">
       <label>出生日期：</label>
       <input class="startTime" name="searchbean.lowBrithday" onfocus="this.blur()" type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" value="<fmt:formatDate value="${searchbean.lowBrithday}"  pattern="yyyy-MM-dd"/>">
       至
       <input class="endTime" name="searchbean.highBrithday" onfocus="this.blur()" type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" value="<fmt:formatDate value="${searchbean.highBrithday}"  pattern="yyyy-MM-dd"/>">
     </div> --%>
     <div class="search-item">
       <label>建档日期：</label>
       <input class="startTime" name="searchbean.lowFileDate" onfocus="this.blur()" type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" value="<fmt:formatDate value="${searchbean.lowFileDate}"  pattern="yyyy-MM-dd"/>">
       至
       <input class="endTime" name="searchbean.highFileDate" onfocus="this.blur()" type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" value="<fmt:formatDate value="${searchbean.highFileDate}"  pattern="yyyy-MM-dd"/>">
     </div>
      <s:if test="issq==2">
     <div class="search-item">
     <s:if test="flag==false">
       <label>责任医生：</label>
       <%-- <select name="searchbean.name">
       	 <option value="">请选择</option>
         <s:iterator value="staffs" var="s">
         <option value="${s.name}" <c:if test="${s.name eq searchbean.name}">selected</c:if>>${s.name}</option>
         </s:iterator>
       </select> --%>
       		<select name="searchbean.name" class="js-example-basic-single" class="select2" style="width: 170px;" >
			 <option value="">请选择</option>
         	 <s:iterator value="specialDoctor" var="s">
         	 	<option value="${s.name}" <c:if test="${s.name eq searchbean.name}">selected</c:if>>${s.name}</option>
			 </s:iterator>
			</select>
    
       <label>建档人：</label>
       <%-- <select name="searchbean.filePeople" class="js-example-basic-single" class="select2" style="width: 170px;">
         <option value="">请选择</option>
         <c:forEach  items="${staffs}" var="s">
         <option value="${s.name}" <c:if test="${s.name eq searchbean.filePeople}">selected</c:if>>${s.name}</option>
         </c:forEach>
       </select> --%>
       <select name="searchbean.filePeople" class="js-example-basic-single" class="select2" style="width: 170px;">
			<option value="">请选择</option>
         	<s:iterator value="staffs" var="s">
         	 	<option value="${s.name}" <c:if test="${s.name eq searchbean.filePeople}">selected</c:if>>${s.name}</option>
			</s:iterator>
	   </select>
       <label>录入人：</label>
       <%-- <select name="searchbean.enterPeople">
         <option value="">请选择</option>
         <c:forEach  items="${staffs}" var="s">
         <option value="${s.name}" <c:if test="${s.name eq searchbean.enterPeople}">selected</c:if>>${s.name}</option>
         </c:forEach>
       </select> --%>
       <select name="searchbean.enterPeople" class="js-example-basic-single" class="select2" style="width: 170px;">
			 <option value="">请选择</option>
         	 <s:iterator value="staffs" var="s">
         	 	<option value="${s.name}" <c:if test="${s.name eq searchbean.enterPeople}">selected</c:if>>${s.name}</option>
			 </s:iterator>
	   </select>
	   </s:if>
     </div>
      
     </s:if>
     <div class="search-item">
       <label>性别查询：</label>
       <input id="all-sex" type="radio" name="searchbean.sex" value="0" <c:if test="${searchbean.sex==null||searchbean.sex==0}"> checked</c:if> ><label for="all-sex">全部</label>
       <input id="man" type="radio"  name="searchbean.sex" value="2" <c:if test="${searchbean.sex==2 }"> checked</c:if>><label for="man">男</label>
       <input id="women" type="radio"  name="searchbean.sex" value="1" <c:if test="${searchbean.sex==1 }"> checked</c:if>><label for="women">女</label>
     </div>
     <div class="search-item">
       <label>慢病分类：</label>
       <input type="hidden" name="flagsear" value="flagOther">
        <input id="ncz" type="checkbox" name="searchbean.renqun" value="3" <s:iterator value="chlist" var="c"> <c:if test="${c==3}"> checked</c:if> </s:iterator>><label for="ncz">心脑血管病</label>
       <input id="gxb" type="checkbox" name="searchbean.renqun" value="4" <s:iterator value="chlist" var="c"> <c:if test="${c==4}"> checked</c:if> </s:iterator>><label for="gxb">冠心病</label>
       <input id="exzl" type="checkbox" name="searchbean.renqun" value="5" <s:iterator value="chlist" var="c"> <c:if test="${c==5}"> checked</c:if> </s:iterator>><label for="exzl">肿瘤</label>
       <input id="zxjsjb" type="checkbox" name="searchbean.renqun" value="6" <s:iterator value="chlist" var="c"> <c:if test="${c==6}"> checked</c:if> </s:iterator>><label for="zxjsjb">重性精神疾病</label>
       <input id="fjhb" type="checkbox" name="searchbean.renqun" value="7" <s:iterator value="chlist" var="c"> <c:if test="${c==7}"> checked</c:if> </s:iterator>><label for="fjhb">慢性支气管病</label>
       <input id="cjza" type="checkbox" name="searchbean.renqun" value="8" <s:iterator value="chlist" var="c"> <c:if test="${c==8}"> checked</c:if> </s:iterator>><label for="cjza">残疾障碍</label>
     </div>
       <div class="search-item">
       <label>档案状态：</label>
       <input id="zhengchang" type="radio" name="searchbean.danganzhuangtai" value="0" <c:if test="${searchbean.danganzhuangtai==null||searchbean.danganzhuangtai==0}"> checked</c:if>><label for="zhengchang">正常</label>
       <input id="zhuxiao" type="radio"  name="searchbean.danganzhuangtai" value="1" <c:if test="${searchbean.danganzhuangtai==1}"> checked</c:if>><label for="zhuxiao">注销</label>
       <input id="siwang" type="radio"  name="searchbean.danganzhuangtai" value="2" <c:if test="${searchbean.danganzhuangtai==2}"> checked</c:if>><label for="siwang">死亡</label>
     </div>
     <div class="btn-content">
       <input type="submit" value="查询" id="" name="" class="btn">
        <a id="news" href="javascript:;" class="btn">重置</a>
       <a href="chronicManagerAction!addOtherManager.action" class="btn btn-xinzeng">添加老人</a>
     </div>
       </form>
     </div>

     <h3 class="current-title">查询结果</h3>
        <div class="table-content">
        <table class="table table-bordered">
          <thead>
            <tr>
               <th>姓名</th>
               <th>性别</th>
              <th>居民健康档案编号</th>
               <th>联系方式</th>
               <th>现住址</th>
               <th>责任医生</th>
               <th>疾病详情</th>
               <th>医生诊断</th>
               <th>康复计划</th>
               <th>慢病操作</th>
            </tr>
          </thead>
          <tbody>
          <s:iterator value="vclist" var="vc" >
            <tr>
              <td>${vc.fileName}</td>
              <td>
                 <c:if test="${!vc.sex }">男</c:if>
                 <c:if test="${vc.sex}">女</c:if>
              </td>
              <td>${vc.fileNum}</td>
              <td>${vc.IPhone}</td>
              <td>${vc.currentProvince}</td>
              <td>${vc.name}</td>
              <td>${vc.diseaseName}</td>
              <td> <a class="btn-xianshi" href="doctorDiagnosisAction!showDoctorDiagnosis.action?chronicName=${vc.diseaseName}&daId=${vc.healthFileId}" >详情</a></td>
              <td> <a class="btn-xianshi" href="chronicManagerAction!searchRecoveryPlan.action?chronicId=${vc.chronicDiseaseId}" >详情</a></td>
              <td>
                <a class="btn-xianshi" href="chronicManagerAction!infoChronic.action?chronicId=${vc.chronicDiseaseId}" class="btn btn-xianshi">查看</a>
                <a class="btn-shanchu" href="chronicManagerAction!deleteOtherManager.action?daId=${vc.healthFileId}&chronicName=${vc.diseaseName}" onclick="return confirm('是否删除？')">删除</a>
              </td>
            </tr>
            </s:iterator>
          </tbody>
        </table>
        <div class="sum-btn">
       		 <div class="page">
				${pageHtml}
	    	</div>
	    </div>
	    	
       <!--  <div class="btn-content">
          <input type="submit" class="btn"  value="导出"  onclick=""></input>
        </div>  -->
	    	
      </div>
      <!-- 表格容器 end -->

 </div>
 <!-- 搜索容器 end -->
 <s:include value="/include/footer.jsp" />
    </div>
    <!-- 主容器 end -->
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
   
    <!-- 底栏 Start-->
<!-- 3级联动 -->
 <script type="text/javascript" src="/jmjkms/js/threecity/jq.js"></script>  
<script type="text/javascript" src="/jmjkms/js/threecity/jquery.cityselect.js"></script>
<script type="text/javascript" src="/jmjkms/js/threecity/location.js"></script>

<!-- 3级联动 -->

<%-- <script src="/jmjkms/js/jquery-2.1.1.min.js"></script> --%>
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
 $("form").submit(function(){
    	var startTime0=$(".startTime").eq(0).val();
    	var startTime1=$(".startTime").eq(1).val();
    	var endTime0=$(".endTime").eq(0).val();
    	var endTime1=$(".endTime").eq(1).val();
    	if(startTime0 != ""&&endTime0 != ""){
    	if(startTime0>endTime0){
      	 	$(".startTime").eq(0).val("");
       		$(".endTime").eq(0).val("");
       		alert("查询时间顺序输入错误");
       		return false;
       	}
       	}
       	if(startTime1 != ""&&endTime1 != ""){
    	if(startTime1>endTime1){
      	 	$(".startTime").eq(1).val("");
       		$(".endTime").eq(1).val("");
       		alert("查询时间顺序输入错误");
       		return false;
       	}
       	}
    })
</script>
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
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<script src="/jmjkms/select2/js/select2.full.js"></script>
<script type="text/javascript">
	$(function(){
		$(".js-example-basic-single").select2();
	})
</script>
</body>
</html>
