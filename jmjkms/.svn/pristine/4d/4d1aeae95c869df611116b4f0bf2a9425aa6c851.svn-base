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
  <link rel="stylesheet" href="/jmjkms/css/change.css">
  <link rel="stylesheet" type="text/css" href="css/sweetalert.css"> 
  <link rel="stylesheet" href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">

  <script src="/jmjkms/js/sweetalert.min.js"></script> 
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
	  <h3 class="current-title">数据字典维护-数据项操作</h3>
        <div class="search-content">
        <input name="yemianname"  class="hid" value="10204" type="hidden"/> 
            <form action="MaintainableEntryAction!updateMaintainableName.action" method="post">
              <label>可维护字段名称: </label>
              <input type="hidden" name="maintainableAttributeId" value="${maintainableAttributeId}"/>  
              <!--  不能添加特殊字符，可以添加汉字 -->   
              <input type="text" id="test" class="temp"  value="${tattribute.name}" name="newName" readonly="readonly">                
              <a href="javascript:;" onclick="xiu(${maintainableAttributeId})" class="btn btn-xiugai" id="chattr">修改可维护字段名称</a>
              <!-- <button>修改可维护字段名称</button>  -->           
                <!-- <button type="button" id="addBtn" class="btn" >增加数据项</button> -->               
               <a href="javascript:;" onclick="clickon(${maintainableAttributeId})" class="btn btn-xinzeng" >增加数据项</a>
            </form>
        </div>
        <div class="table-content">
        <table class="table table-bordered">
        <tbody id="append">
        <tr>
         <th>数据项名称</th>
         <th>操作</th>
        </tr>
        <s:iterator value="mateList" var="mte">
		<tr>       
          <td>${mte.name}</td>
          <td>
          	<a href="javascript:;" class="btn-xiugai"  onclick="tan(${maintainableAttributeId},${maintainableEntryId},'${mte.name}')">修改</a>
          	<a onclick="return confirm('是否删除？');" class="btn-shanchu"  href="MaintainableEntryAction!deleteEntry.action?maintainableEntryId=${mte.maintainableEntryId}&maintainableAttributeId=${maintainableAttributeId}">删除</a>
          </td>
        </tr>
		</s:iterator>
        </tbody>
         
         </table>
         </div>
         <div align="center">
         <a class="btn"  type="button" href="MaintainaleAction!getMaintainableByPage.action">返回</a>
         </div>
    </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>

 
<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
    <script type="text/javascript">  
    function clickon(canshu){
     swal({
   	   html:true,   
       title: "", 
       text: "添加数据项:",  
       type: "input", 
   	   showCancelButton: true, 
       animation: "slide-from-top", 
       confirmButtonText: "保存", 
       confirmButtonColor:"#fc7c00",
   	   cancelButtonText: "取消",
       inputPlaceholder: "" 
       },function(){
       		/* 前台传给后台 */
          var value = $("input[tabindex='3']").val();       
       	  $.ajax({
       	  	/* false使用同步的方式，true为异步 */
       	      async:true,
			  type : "post",
			  url : "MaintainableEntryAction!addEntry.action?entryName="+value+"&maintainableAttributeId="+canshu,
              dataType:"json",
			  success : function(data) {
			    /* alert(data.name); */
			    /* 后台传给前台  增加一行用.append*/
			    $("#append").append("<tr>"+
			                          "<td>"+data.name+"</td>"+		                          		
                                      "<td><a href='javascript:;' class='btn-xiugai' data-buteid='${maintainableAttributeId}' data-entryid='${maintainableEntryId}'>修改</a>"+
          	                             " <a onclick='return confirm(&quot;是否删除?&quot;);' class='btn-shanchu'  href='MaintainableEntryAction!deleteEntry.action?maintainableEntryId="+data.maintainableEntryId+"&maintainableAttributeId="+data.maintainableAttributeId+"'>删除</a>"+ 
                                      "</td>"+
                                    "</tr>");
                
                 //自动刷新
			     url="MaintainableEntryAction!getMaintainableEntry.action?maintainableAttributeId="+canshu;
			     window.location.href=url; 
                 
			  }
	     });
       }
       );
    };
 </script>   

<script type="text/javascript">
function xiu(pa){
swal({   
       title: "", 
       text: "可维护字段名称为:",  
       type: "input", 
   	   showCancelButton: true, 
       animation: "slide-from-top", 
       confirmButtonText: "保存", 
       confirmButtonColor:"#fc7c00",
   	   cancelButtonText: "取消",
       inputPlaceholder: "" 
       },function(){
       		/* 前台传给后台 */
          var value = $("input[tabindex='3']").val();  
                  
       	  $.ajax({      	  	
      	     
			  type : "post",
			  url : "MaintainableEntryAction!updateMaintainableName.action?newName="+value+"&maintainableAttributeId="+pa,
              dataType:"json",
			  success : function(json) {
			  							var name=json.name;
			  							/* id用# label标签获取值 通过.html*/
										/* $("#test").html(name); */
										$("input#test").val(name);										      
			  }			  
	     });
       }
       );
       };    
</script>
  <script type="text/javascript"> 
    function tan(parm,parms,name){
   	var ss=name;
     swal({
       title: " ",
       html:true, 
       text: "原数据项为：<label>"+ss+"</label><br><br>数据项修改为：",        
       type: "input", 
       animation: "slide-from-top", 
       confirmButtonText: "保存", 
       confirmButtonColor:"#fc7c00",
   	   showCancelButton: true, 
   	   confirmButtonColor:"#fc7c00",
   	   cancelButtonText: "取消",
       inputPlaceholder: "" 
       },function(){
       		/* 前台传给后台 */
          var value = $("input[tabindex='3']").val();
          /* alert(value);     */
           /* var oldNmae= $("#maintainableEntryId").attr('name');
              alert("name"); */ 
              
             /*  alert(name); */
       	  $.ajax({
       	  	/* false使用同步的方式，true为异步 */
       	  	
       	      async:true,
			  type : "post",
			  url : "MaintainableEntryAction!updateEntry.action?entryName="+value+"&maintainableAttributeId="+parm+"&maintainableEntryId="+parms,
              dataType:"json",
			  success : function(data) {
			    /* 后台传给前台 */
			    
			    //自动刷新
			     url="MaintainableEntryAction!getMaintainableEntry.action?maintainableAttributeId="+parm;
			     window.location.href=url;  
                
			  }
			  
	     });
       }
       );
    };
 </script>   
<%-- <script>
	;$(function(){
		$('#chentry').click(function(){
			var buteid = $(this).attr('data-buteid');
			var entryid = $(this).attr('data-entryid');
			var name = $(this).attr('data-name');
			 tan(buteid,entryid,name);
			
		});
	});
</script> --%>
<%-- <script type="text/javascript">
 var result=${result};
 $(function(){
 if (result ==0) {
	alert("添加的数据项已经存在");
	}
	
  })
</script> --%>

<%-- <script type="text/javascript">
function changetext(){
var myDiv=document.getElementById("test");
myDiv.innerText="保存";
}
</script> --%>
 <%-- <script type="text/javascript">
	$(function(){
		//alert("aaa");
		$("#light").css('display','none');
		//$("#addBtn").bind("click", function(event) { $("#light").show(); });
		$("#addBtn").click(function(){
		$("#light").show();
		})
	});
	
</script> --%>
		
<%-- <script type="text/javascript">
	$(function(){
		//alert("aaa");
		$("#light1").hide();
		//$("#addBtn").bind("click", function(event) { $("#light").show(); });
	$(".upd").click(function(){
		$("#light1").show();
	})
	});
	
</script> --%>

</body>
</html>
