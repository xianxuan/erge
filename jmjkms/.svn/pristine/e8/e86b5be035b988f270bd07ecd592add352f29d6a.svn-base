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
    <link type="text/css" href="/jmjkms/css/confirm.css">
   <link rel="stylesheet" href="/jmjkms/css/cssreset.css">
  <link rel="stylesheet" href="/jmjkms/select2/css/select2.css">
  <link rel="stylesheet" href="/jmjkms/css/main.css">
  <link rel="stylesheet" href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">
  
</head>
<body>
  <!-- 顶栏 start -->
  <s:include value="/include/header.jsp" />
  <!-- 顶栏 end -->
  <div class="main-content clearfix">
    <!-- 主菜单 start -->
    <input name="yemianname" value="07204" type="hidden"/>
    <s:include value="/include/nav.jsp" />
    <!-- 主菜单 end -->
    <form id="registerform"  action="<%=basePath %>oparetorAction!addOperator.action" method="post" onsubmit="return checkAll()">
     <!-- 主容器 start -->
    <div class="container">
      <h3 class="current-title">添加操作员</h3>
      
      <div class="table-content">
      
      	<s:action name="oparetorAction!getAllStaffExceptOperator" namespace="/" var="home"> </s:action>
        <table class="table table-bordered">
          <tbody>
            <tr>
              <td><font color="red">*</font>员工编号</td>
              <td>
	               <select class="js-example-basic-single" id="select_staff" class="select2" style="width: 170px;"  onchange="getContent(this.value,this.options[this.selectedIndex].text)">
					    <option value="" >请选择</option>
					     <s:iterator value="#home.vstaffs" var="staff">
					     <option value="${staff.name }"><c:out value="${staff.staffNumber }"></c:out></option>
					      </s:iterator>
				   </select> 
				   <c:if test="${flag == 1}"><label><font color="red">该员工不存在 </font></label> </c:if>
			   </td>       
            </tr>
			<tr>
              <td>员工姓名</td>
              <td>
                 <label id="staffname"></label>
              </td>
            </tr>
          
            <tr>
              <td>角色</td>
              <s:action name="oparetorAction!getRoleList" namespace="/" var="home1"> </s:action>
                <td>
                    <select name="roleId" id="roleSelect" onchange="roleChange()">
                       <s:iterator value="#home1.listRoles" var="role">
                      <option value="${role.roleId }" > ${role.roleName }</option>
                     </s:iterator>
                    </select>
                </td>
            </tr>
            <tr id="spe">
              <td>是否置为责任医生</td>
               <td>
                    <select  name="zerendoctor"  id="testSelect" class="testSelect">
                    	<option value="0" <c:if test="${'0' eq zerendoctor}">selected="selected"</c:if>>否</option>
                        <option value="1" <c:if test="${'1' eq zerendoctor}">selected="selected"</c:if>>是</option>             
                    	<!-- <option value="0">否</option>
                      	<option value="1">是</option> -->
                    </select>                    
                   <!--  <font color="red">*一旦置为责任医生,则不能修改</font> -->
                </td>              
            </tr>
            <tr id="tr_1">
            <td>是否管理养老机构</td>
               <td>
                    <select  name="manageAgency"  id="">
                    	<option value="0" <c:if test="${'0' eq manageAgency}">selected="selected"</c:if>>否</option>
                    	<option value="1" <c:if test="${'1' eq manageAgency}">selected="selected"</c:if>>是</option>
                    	<!-- <option value="0">否</option>
                      	<option value="1">是</option> -->
                    </select>                    
                </td>
              </tr>
              <tr id="tr_2">
                <td>是否管理居家老人</td>
                <td>
                    <select  name="manageHome"  id="">
                    <!-- 这样写的话可以回显 -->
                    	<option value="0" <c:if test="${'0' eq manageHome}">selected="selected"</c:if>>否</option>
                    	<option value="1" <c:if test="${'1' eq manageHome}">selected="selected"</c:if>>是</option>
                    	<!-- <option value="0">否</option>
                      	<option value="1">是</option> -->
                    </select>                    
                </td> 
             </tr> 
            <tr>
              <td>状态</td>
               <td>
                    <select name="oparetorState"  id="">
                      <option value="0" <c:if test="${'0' eq oparetorState}">selected="selected"</c:if>>启用</option>
                      <option value="3" <c:if test="${'3' eq oparetorState}">selected="selected"</c:if>>禁用</option>             
                    </select>                    
                </td>
            </tr>
            <tr>
              <td><font color="red">*</font>登录名
              <td>
                <input type="text" id="loginName" value="${loginName }" name="loginName"  placeholder="登录名为6-18位字母,数字,下划线,初始密码与用户名相同" style="width:350px" maxlength="20"
                 ></input><span id="loginNameSpan"></span>
                <c:if test="${flag == 0}"><label><font color="red">该登录名存在</font></label></c:if>
              </td>
            </tr>
            <tr>
              <td>说明</td>
               <td colspan="7">
                 <textarea name="note" id=""  class="textarea" ></textarea>
              </td>
             </tr>
          </tbody>
          </table>
          
          <input type="hidden" name="stuffNumber" value="${stuffNumber }" id="staffNumber" />
           <div class="btn-content">
               <input  type="submit" class="btn" value="保存">
               <a href=" javascript:history.go(0) " class="btn" id="news">重置</a>
             <a href="javascript:history.go(-1)" class="btn">返回</a>
          </div>
        </div>
    </div>
    </form>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>
<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
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
    
    $(function(){
    	var flag = ${flag};
    	//alert(flag);
        if(flag == 0){
        	//接受后台传过来的staffNumber 和 staffname的值
        	var staffNumber = ${stuffNumber};
        	var staffname = '${staffname}';
        	//alert(staffNumber);
        	var op=document.getElementById("select_staff");
        	var selectedIndex;
        	$.ajax({   
		       type:"POST", //请求方式  
		       url:"oparetorAction!getAllStaffExceptOperator2", //请求路径 
		       dataType: "json",   //返回值类型  
		       async:false,
		       success:function(msg){
		    	   var options = eval("("+msg+")"); 
		    	   var i=0;
		        	
		        	for(i=0; i<options.length; i++){
		        		op[i+1].value=options[i].name;
		                //给option的text赋值,这就是你点开下拉框能够看到的东西
						op[i+1].text=options[i].staffNumber;
		        		if(options[i].name == staffname){
		        			selectedIndex = i+1;
		        		}
		        	}
		        	//选中
		        	document.getElementById("select_staff")[selectedIndex].selected=true
		        	//显示staffname的值
		        	document.getElementById("staffname").innerText=staffname;
		       }
		     });
        	
        	/* 
        	var  options =document.getElementById( "select_staff" );//拿到selectduixiang
        	//遍历获取被选中的元素
        	 */
        	
        }
    });
 </script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<script src="/jmjkms/select2/js/select2.full.js"></script>
<script type="text/javascript">
	function checkusername(s)
	{
	    var regex=/^[0-9A-Za-z_@]$/
	    return regex.exec(s);
	}
	 	function trim(str) { 
	    var strnew = str.replace(/^\s*|\s*$/g, ""); 
	    return strnew; 
	} 
	 	
	 function getContent(value,content){
		 var Ostaffname =document.getElementById("staffname");
		 var OstaffNumber = document.getElementById("staffNumber");
		/*  alert("选中的值是"+value+"选中的内容是"+content);  */
		 Ostaffname.innerText= value;
		 OstaffNumber.value=content;
		 //OstaffNumber=content;
	 }
	function checkAll(){
		var loginName = document.getElementById("loginName").value;
		loginName = trim(loginName);
		if(loginName.length<6 || loginName.length>20 || checkusername(loginName)){
			document.getElementById("loginNameSpan" ).innerHTML = "<font color='red'>请输入6-18位字母,数字,下划线</font>"; 
			return false;
		}else{
			return true;
		}
	}
	
	
	function roleChange(){
		 /* var s=$("#roleSelect").find("option:selected").text(); */
		 var s=$("#roleSelect option:selected").val();
		 console.log(s);
		 /* var b=" 医生"; */
		 if(s!==null){
			 $("#spe").show();
		 }
		 else{
			 $("#spe").hide();
			 for(var i = 1; i < 3; i++){  
				    $("#tr_"+i).hide();  
				} 
		 }
		
	}
	
    /* 控制显示两个隐藏框 */
    var cont=$('#testSelect option:selected') .val();
    if(cont==1){//选择责任医生了
    	for(var i = 1; i < 3; i++){  
      	     $("#tr_"+i).show();  
    	}
    }else{
   	 	for(var i = 1; i < 3; i++){  
   	     $("#tr_"+i).hide();  
    	}	
	}  
	/* function gradeChange(){ */
    $(".testSelect").bind("change",function(){
    	/* var vs=$(this).val(); */
	     var vs=$('#testSelect option:selected') .val(); 
         if(vs==1){
         	for(var i = 1; i < 3; i++){ 
	     		$("#tr_"+i).show();  
	       } 
	      }
	       else{
	       	for(var i = 1; i < 3; i++){ 
	     		$("#tr_"+i).hide();  
	        } 
         }
    });
    /* } */

</script>

<script type="text/javascript">
	$(function(){
		$(".js-example-basic-single").select2();
	})
</script>
</body>
</html>
          