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
    width:90px; 
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
       <div class="container">
      <h3 class="current-title">员工信息管理</h3>
       <input name="yemianname" value="07201" type="hidden"/>
      <!-- 搜索容器 start -->
         <form action="<%=basePath %>staffAction!search.action" method="post" onsubmit="return onSubmit()">
      <div class="search-content">
          <div class="search-item">
            <label>查询选项：</label>
            <select name="flag" id="jiaoyan"><!--这边查询的flag是写死的  -->
			 <option value="0" <c:if test="${flag==0}">selected</c:if>>请选择</option>
			 <option value="3" <c:if test="${flag==3}">selected</c:if>>姓名</option>
              <option value="1" <c:if test="${flag==1}">selected</c:if>>身份证号</option>
               <option value="2" <c:if test="${flag==2}">selected</c:if>>员工编号</option>
               <!-- 超管和社区集体显示 -->
               <c:if test="${session.communityHospitalGroup!=null || session.comHospital.isHead==0}">
               <option value="4" <c:if test="${flag==4}">selected</c:if>>社区医院</option>
               </c:if>
            </select>
			
              <input type="text" name="value" value="${ value}"class="b" maxlength="20"/>
			 
               <label>状态选择：</label>
            <select name="state" id="zt">
                <option value="" <c:if test="${'' eq state}">selected</c:if>>请选择</option>
                 <option value="5" <c:if test="${'5' eq state}">selected</c:if>>在职</option>
               <option value="6" <c:if test="${'6' eq state}">selected</c:if>>离职</option>
               <option value="3" <c:if test="${'3' eq state}">selected</c:if>>退休</option>
                <option value="4" <c:if test="${'4' eq state}">selected</c:if>>实习</option>
            </select>
               <label>所属部门：</label>
            <select name="department" id="bm">
            	<option value="" <c:if test="${'' eq department}">selected</c:if>>请选择</option>
               	<option value="诊疗部门" <c:if test="${'诊疗部门' eq department}">selected</c:if>>诊疗部门</option>
               	<option value="辅助诊疗部门" <c:if test="${'辅助诊疗部门' eq department}">selected</c:if>>辅助诊疗部门</option>
               	<option value="护理部门" <c:if test="${'护理部门' eq department}">selected</c:if>>护理部门</option>
               	<option value="行政后勤部门" <c:if test="${'行政后勤部门' eq department}">selected</c:if>>行政后勤部门</option>
            </select>
          </div>
          <div class="btn-content"> <!--下面的是查询的代码-->
            <input type="submit" value="查询" class="btn">
            <c:if test="${session.tstaff != null || session.comHospital != null }">
            <a href="<%= basePath%>staffAction!toAdd.action" class="btn btn-xinzeng">新增员工</a>
       		 </c:if>
          </div>
        
      </div>
      </form>
      <!-- 搜索容器 end -->
     <form action="<%=basePath %>staffAction!test.action" method="post">
      <!-- 结果容器 start -->
      <div class="table-content">
       
        <table class="table table-bordered" >
          <thead>
            <tr>
              <th>员工编号</th>
              <th>姓名</th>
              <th>联系方式</th>
              <th>岗位</th>
              <th>职务</th>
              <th>部门</th>
              <c:if test="${session.communityHospitalGroup!=null || session.comHospital.isHead==0}">              
              <th>社区医院</th>
              </c:if>
              <c:if test="${session.comHospital.isHead==0}"> 
              <th>社区集团</th>
              </c:if>
              <th>人员状态</th>
              <th>操作</th>
            </tr>
          </thead>
          <tbody>
        
          <s:iterator value="staffSpecials" var="staff">
           <input type="hidden" name="ids" value="${staff.sta.staffId }" />
             <tr>
              <td> <span class="dspan"><c:out value="${staff.sta.staffNumber}"></c:out></span></td>
              <td> <span class="dspan"><c:out value="${staff.sta.name }"></c:out></span></td>
       			<td>
                  <span class="dspan"> <c:out value="${staff.sta.phone}"></c:out></span>
              </td>
              <td> <span class="dspan"><c:out value="${staff.sta.station }"></c:out></span></td>
              <td> <span class="dspan"><c:out value="${staff.sta.job }"></c:out></span></td>
               <td> <span class="dspan"><c:out value="${staff.sta.department }"></c:out></span></td>
               <c:if test="${session.communityHospitalGroup!=null || session.comHospital.isHead==0}">
               <td> <span class="dspan"><c:out value="${staff.comHos}"></c:out></span></td>
               </c:if>
               <c:if test="${session.comHospital.isHead==0}">
               <td> <span class="dspan"><c:out value="${staff.comGroup}"></c:out></span></td>
               </c:if>
              <td> <span class="dspan">
              	<c:if test="${'3' eq staff.sta.state}">退休</c:if>
              	<c:if test="${'4' eq staff.sta.state }">实习</c:if>
              	<c:if test="${'5' eq staff.sta.state}">在职</c:if>
              	<c:if test="${'6' eq staff.sta.state}">离职</c:if>
              	</span>
              </td>
              <td>
                <a class="btn-xianshi"   href="<%=basePath %>staffAction!showStaffInfo.action?staffId=${staff.sta.staffId}">详情</a>
                <a class="btn-xiugai"   href="<%=basePath %>staffAction!updateStaff.action?staffId=${staff.sta.staffId}">编辑</a>
                <a class="btn-shanchu"  onclick="return confirm('是否删除')"  href="<%=basePath %>staffAction!deleteStaff.action?staffId=${staff.sta.staffId}">删除</a>
              </td>
            </tr>
           </s:iterator>
           
    	
          </tbody>
         </table>
           <input type="hidden" name="flag"  id="act" value=""></input>
        <!-- 分页 Start -->
        <div class="sum-btn">
	        <div class="page"> 
	       		 ${ pageHtml }
	        </div>
	        <!-- 分页 end -->
			
	        <div class="btn-content2">
	          <input type="submit" class="btn btn-daochu"  value="导出全部"  onclick="run01()"></input>
	          <input type="submit" class="btn btn-daochu"  value="导出本页"  onclick="run02()"></input>
	        </div>
        </div>
      </div>
      <!-- 结果容器 end -->
    </form>
    </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>
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
function onSubmit()
{
	if($("#jiaoyan").val() == 0 && $("#zt").val()==''&&$("#bm").val()==''){
		return false;
	}
	return true;
}
</script>
<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
</body>
</html>
