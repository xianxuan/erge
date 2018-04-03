<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head><meta name="viewport" content="width=device-width, initial-scale=1.0"><meta http-equiv="X-UA-Compatible" content="ie=edge">
  <meta charset="UTF-8">
  <c:choose><c:when test="${session.comHospital.isHead==0}"><title>中电科社区健康管理平台</title></c:when><c:when test="${session.communityHospitalGroup!=null}"><title>社区健康管理系统</title></c:when><c:otherwise><title>社区健康服务站</title></c:otherwise></c:choose>
  <link rel="stylesheet" href="/jmjkms/select2/css/select2.css">
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
    <!-- 主菜单 start -->
    <s:include value="/include/nav.jsp" />
    <!-- 主菜单 end -->
    <!-- 主容器 start -->
    <div class="container">
      <h3 class="current-title">健康体检</h3>
      <!-- 搜索容器 start -->
      <div class="search-content">

      <input name="yemianname" value="03100" type="hidden"/>

     <form id="entity" action=PhysicalExamAction!searchMore.action>

     <input id="cp" type="hidden" name="cp1" value="${cp}">
     <div class="search-item">
    <s:if test="sq==0"><!-- 0是平台管理员登陆，1是集团登陆，2是其他登陆 -->
        <label>社区集团：</label>
       	<select name="searchbean.sqid">
       		<option value="">全部</option>
       	  <s:iterator value="groups" var="g">
       		<option value="${g.GId}" <c:if test="${g.GId eq searchbean.sqid}">selected</c:if>>${g.groupName}</option>
       	  </s:iterator>
       	</select>
       	</s:if>
     <s:if test="sq==1"><!-- 0是平台管理员登陆，1是集团登陆，2是其他登陆 -->
       <label>社区医院：</label>
       	<select name="searchbean.sqid">
       		<option value="">全部</option>
       	  <s:iterator value="hospitals" var="h">
       		<option value="${h.communityHospitalId}" <c:if test="${h.communityHospitalId eq searchbean.sqid}">selected</c:if>>${h.communityHospital}</option>
       	  </s:iterator>
       	</select>
       	</s:if>
       <label>查询选项：<input type="hidden" name="issetsearch" value="true"></input></label>
       <select name="searchbean.selectFlag" >
         <option value="1" <c:if test="${'1' eq searchbean.selectFlag}">selected</c:if>>姓名</option>
         <option value="2" <c:if test="${'2' eq searchbean.selectFlag}">selected</c:if>>身份证号</option>
         <option value="3" <c:if test="${'3' eq searchbean.selectFlag}">selected</c:if>>档案编号</option>
       </select>
       <input name="searchbean.selectValue" maxlength="18"   type="text" class="w150 temp" maxlength='20' value="${searchbean.selectValue}">
       <label>年龄：</label>
       <input  maxlength="4" name="searchbean.lowAge" type="text" class="w40 temp"  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" value="<c:if test="${searchbean.lowAge!=0}">${searchbean.lowAge}</c:if>">至<input   maxlength="4" name="searchbean.highAge"  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" value="<c:if test="${searchbean.highAge!=0}">${searchbean.highAge}</c:if>" type="text" class="w40">岁
     </div>
    <%--  <div class="search-item">
         <label>出生日期：</label>
      <input class="startTime" name="searchbean.lowBrithday" onfocus="this.blur()" type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" value="<fmt:formatDate value="${searchbean.lowBrithday}"  pattern="yyyy-MM-dd"/>" >
       至
       <input class="endTime"  name="searchbean.highBrithday" onfocus="this.blur()" type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" value="<fmt:formatDate value="${searchbean.highBrithday}"  pattern="yyyy-MM-dd"/>">
     </div> --%>
     <div class="search-item">
       <label>建档日期：</label>
       <input class="startTime" name="searchbean.lowFileDate" onfocus="this.blur()" type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" value="<fmt:formatDate value="${searchbean.lowFileDate}"  pattern="yyyy-MM-dd"/>">
       至
        <input class="endTime"  name="searchbean.highFileDate" onfocus="this.blur()" type="text" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" value="<fmt:formatDate value="${searchbean.highFileDate}"  pattern="yyyy-MM-dd"/>">
     </div>
     
     <c:if test="${flagPingTai==false}">
     <c:if test="${flag==false}">
     <div class="search-item">
       <label>责任医生：</label>
       <select name="searchbean.name" class="js-example-basic-single" class="select2" style="width: 170px;">
       	 <option value="">请选择</option>
         <s:iterator value="specialDoctor" var="s">
         <option value="${s.name}" <c:if test="${s.name eq searchbean.name}">selected</c:if>>${s.name}</option>
         </s:iterator>
       </select>
       
       <label>建档人：</label>
       
        <select name="searchbean.filePeople" class="js-example-basic-single" class="select2" style="width: 170px;">
         <option value="">请选择</option>
         <s:iterator value="staffs" var="s">
         <option value="${s.name}" <c:if test="${s.name eq searchbean.filePeople}">selected</c:if>>${s.name}</option>
         </s:iterator>
       </select>
       <label>录入人：</label>
       <select name="searchbean.enterPeople" class="js-example-basic-single" class="select2" style="width: 170px;">
          <option value="">请选择</option>
         <s:iterator value="staffs" var="s">
         <option value="${s.name}" <c:if test="${s.name eq searchbean.enterPeople}">selected</c:if>>${s.name}</option>
         </s:iterator>
       </select> 
       </div>
       </c:if>
       </c:if>
     
     <div class="search-item">
       <label>性别查询：</label>
       <input id="all-sex" type="radio" name="searchbean.sex" value="0" <c:if test="${searchbean.sex==null||searchbean.sex==0}"> checked</c:if> ><label for="all-sex">全部</label>
       <input id="man" type="radio"  name="searchbean.sex" value="2" <c:if test="${searchbean.sex==2 }"> checked</c:if>><label for="man">男</label>
       <input id="women" type="radio"  name="searchbean.sex" value="1" <c:if test="${searchbean.sex==1 }"> checked</c:if>><label for="women">女</label>
     </div>
     
     <div class="search-item">
       <label>档案状态：</label>
       <input id="zhengchang" type="radio" name="searchbean.danganzhuangtai" value="0" <c:if test="${searchbean.danganzhuangtai==null||searchbean.danganzhuangtai==0}"> checked</c:if>><label for="zhengchang">正常</label>
       <input id="zhuxiao" type="radio"  name="searchbean.danganzhuangtai" value="1" <c:if test="${searchbean.danganzhuangtai==1}"> checked</c:if>><label for="zhuxiao">注销</label>
       <input id="siwang" type="radio"  name="searchbean.danganzhuangtai" value="2" <c:if test="${searchbean.danganzhuangtai==2}"> checked</c:if>><label for="siwang">死亡</label>
     </div>
    <%--  <div class="search-item">
       <label>家庭住址：</label>
       <select name="searchbean.sheng">
         <option value="">河北省</option>
         <option value="">项目1</option>
       </select>
       <select name="searchbean.shi">
         <option value="">石家庄市</option>
         <option value="">项目1</option>
       </select>
       <select name="searchbean.qu">
         <option value="">桥西区</option>
         <option value="">项目1</option>
       </select>
       <input type="text" class="w150">
     </div> --%>
     <div class="btn-content">
       <input type="submit" value="查询" class="btn">
       <a id="news" href="javascript:;" class="btn">重置</a>
      <a class="btn btn-xinzeng"  href= /jmjkms/jsp/physicalExam/addPhysicalExam.jsp>添加</a>
      </div>
 	</form>
 	
 	 <div id="mask_alert" class="mask_alert">
    </div>
    <div id="demo_alert" class="demo_alert">
    <div id="fa" class="btn-close">
	    <i class="fa fa-close"></i>
    </div>
    <div id="button_alert_2">
     
    </div>   
    
    
      </div>
      <!-- 搜索容器 end -->
      <!-- 结果容器 start -->
      <div class="table-content">
     <form action="healthFileAction!fuction.action" method="post"> 
        <table class="table table-bordered">
          <thead>
            <tr>
              <!-- <th> <input type="checkbox"  id="all" name="allCK"
							onclick="javascript:allCheck()" ><label for="all-check">全选</label></th> -->
              
              <th>姓名</th>
              <th>性别</th>
              <th>出生日期</th>
              <th>档案编号</th>
              <th>居委会（村）</th>
              <th>家庭住址</th>
              <th>操作</th>
              <th>归属</th>
            </tr>
          </thead>
          <tbody>
         
           <s:iterator value="healthFileList" status="n">
           <input type="hidden" name="choice1" value="${healthFileId}"/>
            <tr>
             
             <%--  <td><input class="zyq qq" type="checkbox" name="allHealthFileId" id="ck_id" value="${healthFileId}"></td> --%>
              
              <td><c:out value="${name}"></c:out></td>
              <td>
              <c:if test="${sex==false}">男</c:if>
              <c:if test="${sex==true}">女</c:if>
              </td>
              <td><fmt:formatDate value="${birthDate}"  pattern="yyyy-MM-dd"/></td> 
              <td><c:out value="${fileNum}"></c:out></td>
              <%-- <td><c:out value="${birthDate}"></c:out></td> --%>
              <td><c:out value="${currentOffice}"></c:out></td>
              <td><c:out value="${currentResidentCommittee}"></c:out></td>
              <td>
                <a href="PhysicalExamAction!showPhysicalExamListBypersonal.action?healthFileId=${healthFileId}&belongSystem=${belongSystem}&fileNum=${fileNum}"  class="btn-xianshi">查看体检</a>
                <c:if test="${healthFileType==2 && belongSystem==1}"><a href="PhysicalExamAction!jumpAddPhysicalExam.action?fileNum=${fileNum}"  class="btn-xinzeng">新增体检</a> </c:if>
	          
				<div id="demo_alert" class="demo_alert">
					 
					<div class="tan_tit">姓名：${name}<br></div>
					 
				</div>
              </td>
              <td>社区医院</td>
            </tr>
            </s:iterator>
           
          </tbody>
        </table>
         <input type="hidden" name="conFlag"  id="act" value=""/>
        <!-- 分页 Start -->
        <div class="sum-btn">
	        <div class="page">
	          ${pageHtml}
	        </div>
	        <div class="btn-content2">
	       		 <input type="submit" class="btn btn-daochu"  value="导出本页"  onclick="run01()"></input>
	          <input type="submit" class="btn btn-daochu"  value="导出全部"  onclick="run02()"></input>
	        </div>
        </div>
        <!-- 分页 end -->
        
        </form> 
      </div>
</div>


    </div>
    
    
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>
	
		
<%-- <script src="/jmjkms/js/jquery-2.1.1.min.js"></script> --%>
<script src="/jmjkms/js/threecity/jq.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
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
function deleteHealthFile(){
		
		$.ajax({
			type : "post",
			url : "healthFileAction!getFileNumAuto.action",
			dataType: "json",
			success : function(data) {
			
			   $("#Auto").val(data.fileNumAuto);
			 
			}
		});
		
	}
function deleteHeathFile()
    {
     alert(1);
    document.formEdit.action="healthFileAction!deleteHealthFile.action?healthFileId="+$(".qq").val();
    alert($(".qq").val());
    document.formEdit.submit();
    } 


</script>
<script>
	$(function(){
		$('.btn_alert').click(function(){
			$(this).next().show();
			$(this).next().next().show();
		});
		$('.btn-close').click(function(){
			$(this).parent().hide();
			$(this).parent().prev().hide();
		});
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
       		alert("查询时间输入错误");
       		return false;
       	}
       	}
       	if(startTime1 != ""&&endTime1 != ""){
    	if(startTime1>endTime1){
      	 	$(".startTime").eq(1).val("");
       		$(".endTime").eq(1).val("");
       		alert("查询时间输入错误");
       		return false;
       	}
       	}
    })
</script>
<script language="javascript">
	bijiao.onclick = function compare(){

	 if(parseInt(document.getElementById("input1").value) > parseInt(document.getElementById("input2").value))
	 {
	  	
	  	alert("年龄输入有误！");
	  	document.getElementById("input1").value="";
	  	document.getElementById("input2").value="";
	 }

	}
</script>
 
<script type="text/javascript">
	$(function(){
		$(".js-example-basic-single").select2();
	})
</script>
</body>
</html>
