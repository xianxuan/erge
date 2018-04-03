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
    width:150px; /这个宽度可以根据自己需要，大小自己决定/
    word-break:keep-all;/* 不换行 */  
    white-space:nowrap;/* 不换行 */  
    overflow:hidden;/* 内容超出宽度时隐藏超出部分的内容 */  
    text-overflow:ellipsis;/* 文本溢出时显示省略标记(...)与overflow:hidden;一起使用*/
}
span.dspan{
    display: inline-block; 
    width:80px; /这个宽度可以根据自己需要，大小自己决定/
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
      <h3 class="current-title">操作员管理</h3>
      <input name="yemianname" value="07204" type="hidden"/>
        <div class="search-content">
            <form action="<%=basePath %>oparetorAction!search.action" method="post">
              <label>搜索类型：</label>
                <select name="flag" id="">
                <option value="0"<c:if test="${flag==0}">selected</c:if>>请选择</option>
                  <option value="1" <c:if test="${flag==1}">selected</c:if>>编号</option>
                  <option value="2" <c:if test="${flag==2}">selected</c:if>>姓名</option>
                  <option value="3" <c:if test="${flag==3}">selected</c:if>>登录名</option>
                  <!-- 超管和社区集体显示 -->
               <c:if test="${session.communityHospitalGroup!=null || session.comHospital.isHead==0}">
                  <option value="4" <c:if test="${flag==4}">selected</c:if>>社区医院</option>
                  </c:if>
                </select>

                <input type="text" name = "value" value="${value }" class="w150" 
                 maxlength="20">


                <input type="submit" class="btn btn-xianshi" value="查询">
                   <c:if test="${session.comHospital != null&&session.comHospital.isHead==1 || session.tstaff!=null}">
                  <a  href="<%=basePath %>jsp/staffManage/operatorManage/addOperatorInfo.jsp" class="btn btn-xinzeng">添加操作员</a>
           		 </c:if>
                </form>
        </div>
       <div class="table-content">
        <table class="table table-bordered">
          <thead>
            <tr>
              <th>编号</th>
              <th>部门</th>
              <th>角色</th>
              <th>姓名</th>
              <th>登录名</th>
              <c:if test="${session.communityHospitalGroup!=null || session.comHospital.isHead==0}">
              <th>社区医院</th>
              </c:if>
              <c:if test="${session.comHospital.isHead==0}">
              <th>社区集团</th>
              </c:if>
              <th>状态</th>
              <th>说明</th>
              <c:if test="${session.comHospital.isHead ==1}"><!-- 社区管理员或者员工有权限 -->
              	 <th>操作</th>
              </c:if>
              <c:if test="${session.tstaff != null}"><!-- 社区管理员或者员工有权限 -->
              	 <th>操作</th>
              </c:if>
              </tr>
          </thead>
          
          <tbody>
           <s:iterator value="vstaffs" var="staff">
            <tr>
              <td>  <span class="dspan"><c:out value="${staff.staffNumber }"> </c:out></span></td>
              <td>  <span class="dspan"><c:out value="${staff.job }"> </c:out></span></td>
              <td>  <span class="dspan"><c:out value="${staff.roleName }"> </c:out></span></td>
              <td>  <span class="dspan"><c:out value="${staff.name }"> </c:out></span></td>
              <td>  <span class="dspan"><c:out value="${staff.loginName }"> </c:out></span></td>
              <c:if test="${session.communityHospitalGroup!=null || session.comHospital.isHead==0}">
               <td> <span class="dspan"><c:out value="${staff.communityHospital}"> </c:out></span></td>
               </c:if>
               <c:if test="${session.comHospital.isHead==0}">
              <td>  <span class="dspan"><c:out value="${staff.groupName }"> </c:out></span></td>
              </c:if>
             
               <c:if test="${ session.comHospital.isHead == 1}">
              	 <td>  <span class="dspan">
              	 
		             	 <c:if test="${staff.operateState == 0 }">
		                	<a href="<%=basePath %>oparetorAction!changeUperatorState.action?staffId=${staff.staffId}">禁用</a>
		                </c:if>
		                 <c:if test="${staff.operateState == 3 }">
		                	<a href="<%=basePath %>oparetorAction!changeUperatorState.action?staffId=${staff.staffId}">启用</a>
		                </c:if>
	                </span>
	              </td>
               </c:if>
               
                <c:if test="${ session.comHospital.isHead == 0}">
                 <td>  <span class="dspan">
	             	 <c:if test="${staff.operateState == 0 }">
	                	<label>启用</label>
	                </c:if>
	                 <c:if test="${staff.operateState == 3 }">
	               		<label>禁用</label>
	                </c:if>
	                </span> </td>
               </c:if>

               
               <c:if test="${ session.tstaff != null}">
               <td>  <span class="dspan">
	               		<c:if test="${staff.operateState == 0 }">
		                	<label>启用</label>
		                </c:if>
		                 <c:if test="${staff.operateState == 3 || staff.operateState == 1}">
		                  	<label> 禁用</label>
		                </c:if>
		             </span></td>
	            </c:if>
	            
	            <c:if test="${ session.communityHospitalGroup !=null}">
                 <td>  <span class="dspan">
	             	 <c:if test="${staff.operateState == 0 }">
	                	<label>启用</label>
	                </c:if>
	                 <c:if test="${staff.operateState == 3 }">
	               		<label>禁用</label>
	                </c:if>
	                </span> </td>
               </c:if>
	            
	            
              <td><span class="cspan"><c:out value="${staff.note }"> </c:out></span></td>
              
              	<c:if test="${session.tstaff == null}">
              		<c:if test="${ session.comHospital.isHead == 1}">
              			<td>
	               		<a  class="btn-xiugai" href="<%=basePath %>oparetorAction!recoverPassword.action?staffId=${staff.staffId}">密码恢复</a>
	                	<a class="btn-xiugai" href="<%=basePath %>oparetorAction!getUpdateOperatorById.action?staffId=${staff.staffId}" >修改</a>
                		<a class="btn-shanchu" href="<%=basePath %>oparetorAction!deleteOperator.action?staffId=${staff.staffId}" onclick="return confirm('是否删除')">删除</a>
             		</td>
             		 </c:if>	
             	</c:if>
              <c:if test="${session.tstaff != null}">
              <td>
	               		<a  class="btn-xiugai" href="<%=basePath %>oparetorAction!recoverPassword.action?staffId=${staff.staffId}">密码恢复</a>
	                	<a class="btn-xiugai" href="<%=basePath %>oparetorAction!getUpdateOperatorById.action?staffId=${staff.staffId}" >修改</a>
                		<a class="btn-shanchu" href="<%=basePath %>oparetorAction!deleteOperator.action?staffId=${staff.staffId}" onclick="return confirm('是否删除')">删除</a>
             		</td>
              </c:if>
            </tr>
           </s:iterator>
          </tbody>
        </table>
       
        <!-- 分页 Start -->
        <div class="sum-btn">
	        <div class="page">
	         ${pageHtml}
	        </div>
	     </div>
	    </div>
    <!-- 分页 end -->
      </div>
          <s:include value="/include/footer.jsp" />
    </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->

    <!-- 底栏 Start-->

<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
</body>
</html>
 