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
<style type="text/css">
  span.cspan{
    display: inline-block;        
    width:150px; 
    word-break:keep-all;/* 不换行 */  
    white-space:nowrap;/* 不换行 */  
    overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */  
    text-overflow:ellipsis;/* 文本溢出时显示省略标记(...)与overflow:hidden;一起使用*/
}
span.dspan{
    display: inline-block; 
    width:100px;
    word-break:keep-all;/* 不换行 */  
    white-space:nowrap;/* 不换行 */  
    overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */  
    text-overflow:ellipsis;
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
      <h3 class="current-title">员工请假管理</h3>
      <input name="yemianname" value=07202 type="hidden"/>
      <!-- 搜索容器 start -->
      <div class="search-content">
          <div class="search-item">
          	 <form action="<%=basePath %>staffAction!selectStaffLeaves.action" method="post">
             <label>查询条件：</label><!--可输可选的input框-->
			 
            <select name="flagThree" id="xuanze" >
              <option value="1"  <c:if test="${flagThree==1}">selected</c:if>>请选择</option>
              <option value="2"  <c:if test="${flagThree==2}">selected</c:if>>员工姓名</option>
              <option value="3"  <c:if test="${flagThree==3}">selected</c:if>>员工编号</option>
              <!-- 超管和社区集体显示 -->
               <c:if test="${session.communityHospitalGroup!=null || session.comHospital.isHead==0}">
               <option value="6"  <c:if test="${flagThree==6}">selected</c:if>>社区医院</option>
               </c:if>
				<option value="4"  <c:if test="${flagThree==4}">selected</c:if>>请假日期</option>
               <option value="5"  <c:if test="${flagThree==5}">selected</c:if>>销假日期</option>
			</select>
			<span class="qita">
            		 <input type="text" name = "value"  value="${value }" maxlength="20" class="w150 temp"/>
             </span>
            <span class="qingjia">
                    <label>请假日期 :</label>
                    <input id="dateInput1" style="width:100px" type="text" class="w150" name ="leaveDateLow" value="<fmt:formatDate value='${leaveDateLow}' pattern='yyyy-MM-dd'/>" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
                    <label>至</label>
                    <input  id="dateInput2" style="width:100px" type="text" class="w150" name="leaveDateHigh" value="<fmt:formatDate value='${leaveDateHigh}' pattern='yyyy-MM-dd'/>" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">  
             </span>
             <span class="xiaojia">
             	   <label>销假日期 ：</label>
                    <input  id="dateInput2" type="text" style="width:100px" class="w150" name="comeBackDateLow" value="<fmt:formatDate value='${comeBackDateLow}' pattern='yyyy-MM-dd'/>" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">  
             		<label>至</label>
                    <input  id="dateInput2" type="text"  style="width:100px" class="w150" name="comeBackDateHigh" value="<fmt:formatDate value='${comeBackDateHigh}' pattern='yyyy-MM-dd'/>" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">  
             	</span>
          <div class="btn-content"> <!--下面的是查询的代码-->
            <input id="submit" type="submit" value="查询" class="btn btn-xianshi">
             <c:if test="${session.tstaff != null || session.comHospital != null}">
               <a href="<%=basePath %>staffAction!getAllStaffsBySQId.action" class="btn btn-xinzeng">新增员工请假</a>
         	</c:if>
          </div>
        </form>
      </div>
           
      <!-- 搜索容器 end -->
      <!-- 结果容器 start -->
        <form action="<%=basePath %>staffAction!function.action" method="post">
      <div class="table-content">
        <table class="table table-bordered" id="jqprint">
          <thead>
            <tr>
              <th>员工姓名</th>
              <c:if test="${session.communityHospitalGroup!=null || session.comHospital.isHead==0}">
              <th>社区医院</th>
              </c:if>
              <c:if test="${session.comHospital.isHead==0}">
              <th>社区集团</th>
              </c:if>
              <th>请假日期</th>
              <th>销假日期</th>
			   <th>请假天数</th>
			    <th>实际请假天数</th>
			    <th>员工编号</th>
              <th>操作</th>
            </tr>
          </thead>
          <tbody>
        
          <!-- 这里写遍历开始 -->
            <s:iterator value="vstaffleaves" var="s">
            <input type="hidden"   name = "ids" value="${s.staffLeaveId }">
            <tr>
              <td> <span class="dspan"><c:out value="${s.name }"> </c:out></span></td>
              <c:if test="${session.communityHospitalGroup!=null || session.comHospital.isHead==0}">
              <td> <span class="dspan"><c:out value="${s.communityHospital}"> </c:out></span></td>
              </c:if>
              <c:if test="${session.comHospital.isHead==0}">
              <td> <span class="dspan"><c:out value="${s.groupName }"> </c:out></span></td></td>
              </c:if>              
              <td>  <span class="dspan"><fmt:formatDate value='${s.leaveDate}' pattern='yyyy-MM-dd'/></span></td>
              <td>  <span class="dspan"><fmt:formatDate value='${s.comebackDate}' pattern='yyyy-MM-dd'/></span></td>
			   <td>  <span class="dspan"><c:out value="${s.days}"> </c:out></span></td>
			    <td>  <span class="dspan"><c:out value="${s.actualDays}"> </c:out></span></td>
			    <td>  <span class="dspan"><c:out value="${s.staffNumber}"> </c:out></span></td>
              <td>
                <a  class="btn-xianshi" href="<%=basePath %>staffAction!showStaffLeave.action?staffLeaveId=${s.staffLeaveId}">详情</a>
                <a class="btn-xiugai" href="<%=basePath %>staffAction!updateStaffLeaveById.action?staffLeaveId=${s.staffLeaveId}">编辑</a>
                 <a class="btn-shanchu" onclick="return confirm('是否删除')" href="<%=basePath %>staffAction!deleteStaffLeave.action?staffLeaveId=${s.staffLeaveId}">删除</a>
              	<c:if test="${s.comebackDate == null }" >
				<a class="btn-xiugai" href="<%=basePath %>staffAction!comeBack.action?staffLeaveId=${s.staffLeaveId}">销假</a>
				</c:if>
              </td>
            </tr>
           </s:iterator>
          <!-- 遍历结束 -->
       
          </tbody>
        </table>
          <input type="hidden" name="flag"  id="act" value=""></input>
        <!-- 分页 Start -->
        <div class="sum-btn">
	        <div class="page">
	            ${pageHtml }
	        </div>
	        <!-- 分页 end -->
	         <div class="btn-content2">
	          <input type="submit" class="btn btn-daochu"  value="导出本页"  onclick="run02()"></input>
	           <input type="submit" class="btn btn-daochu"  value="导出全部"  onclick="run03()"></input>
	        </div>
        </div>
      </div>
      <!-- 结果容器 end -->
      </form>
    </div>
    </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>


<script src="/jmjkms/js/jquery-1.4.4.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<script src="/jmjkms/js/jquery.jqprint-0.3.js"></script>
<script type="text/javascript"> 
//这个是全选框的函数
function checkAll(name) { 
var el = document.getElementsByTagName('input'); 
var len = el.length; 
for(var i=0; i<len; i++) { 
if((el[i].type=="checkbox") && (el[i].name==name)) { 
el[i].checked = true; 
} 
} 
} 
function clearAll(name) { 
var el = document.getElementsByTagName('input'); 
var len = el.length; 
for(var i=0; i<len; i++) { 
if((el[i].type=="checkbox") && (el[i].name==name)) { 
el[i].checked = false; 
} 
} 
} 
</script> 
<script type="text/javascript">
$(function(){
      var dataVal = $("#xuanze").val();
      if(dataVal != '5' && dataVal != '4') {
      	$(".qita").show();//class用.
      	$(".qingjia").hide();
      	$(".xiaojia").hide();
      } else {
      	$(".qita").hide();
      	if(dataVal =='4'){
      		$(".qingjia").show();
      	}else{
      		$(".qingjia").hide();
      	}
      	if(dataVal =='5'){
      		$(".xiaojia").show();
      	}else{
      		$(".xiaojia").hide();
      	}
      }
       $("#xuanze").change(function(){ //id用#
       var bt1 = 0,bt2 = 0;bt3 = 0;
      	if ($(this).val() == '4') {
      		$(".qingjia").show();
      		$(".xiaojia").hide();
      		$(".qita").hide();
      	} else if ($(this).val() == '5') {
      		$(".xiaojia").show();
      		$(".qingjia").hide();
      		$(".qita").hide();
      	} else if ($(this).val() == '1') {
      		$(".qita").show();
      		$(".qingjia").hide();
      		$(".xiaojia").hide();
      	} else if ($(this).val() == '2') {
      		$(".qita").show();
      		$(".qingjia").hide();
      		$(".xiaojia").hide();
      	}else if ($(this).val() == '3') {
      		$(".qita").show();
      		$(".qingjia").hide();
      		$(".xiaojia").hide();
      	} 
      	
      });
  });
</script>
<script type="text/javascript">
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
		var submit = document.getElementById('submit');
		var date1 = document.getElementById('dateInput1');  //获取起始日期input
		var date2 = document.getElementById('dateInput2');  //获取终止日期input
 	submit.onclick =function(){
		var dateValue1 = date1.value;		
		var dateValue2 = date2.value;
		var date1Arr = new Array();
		 date1Arr = dateValue1.split("-");  //起始时间拆分后的数组
		var date2Arr = new Array();
		 date2Arr = dateValue2.split("-");  //结束时间拆分后的数组
		if(dateValue1.length!=0 && dateValue2.length!=0){
			if(date1Arr[0]>date2Arr[0]){
				alert("起止日期输入有误！");
				return false;
			}
			else if(date1Arr[0]=date2Arr[0]){
				if(date1Arr[1]>date2Arr[1]){
					alert("起止日期输入有误！");
					return false;
				}
				else if(date1Arr[1]=date2Arr[1]){
					if(date1Arr[2]>date2Arr[2]){
						alert("起止日期输入有误！");
						return false;
					}
				}
			}
	    }
	    return true;
    }
	</script> 
</body>
</html>
