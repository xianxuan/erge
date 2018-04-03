<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head><meta name="viewport" content="width=device-width, initial-scale=1.0"><meta http-equiv="X-UA-Compatible" content="ie=edge">
<base href="<%=basePath%>">
  <meta charset="UTF-8">
  <c:choose><c:when test="${session.comHospital.isHead==0}"><title>中电科社区健康管理平台</title></c:when><c:when test="${session.communityHospitalGroup!=null}"><title>社区健康管理系统</title></c:when><c:otherwise><title>社区健康服务站</title></c:otherwise></c:choose>
  <link rel="stylesheet" href="/jmjkms/css/cssreset.css">
  <link rel="stylesheet" href="/jmjkms/css/main.css">
  <link rel="stylesheet" href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">
  
</head>
<body>
  <!-- 顶栏 start -->
  <s:include value="/include/header.jsp" /> 
   <div class="main-content clearfix">
    <!-- 主菜单 start -->
  <s:include value="/include/nav.jsp" />
    <!-- 主菜单 end -->
    <!-- 主容器 start -->
    <div class="container">
   <h3 class="current-title">员工详情信息</h3>
         <input name="yemianname" value="07201" type="hidden"/>
           <div class="table-content">
             <form action="">
               <table class="table table-bordered" id="jqprint" style="word-break:break-all"
               >
                 <tbody>
                    <tr>
                      <td colspan="8" class="title-td">人员信息管理</td>
                    </tr>
                   <tr>
                     <td>单位：</td>
                      <td colspan="3">
						<c:out value="${cstaff.commName }"></c:out>
					</td> 
					  <td>员工编号：</td>
                     <td  colspan="3"><c:out value="${cstaff.staff.staffNumber}"></c:out></td>
                     </tr>
                     
                     <tr>
                     <td>姓名：</td>
                      <td colspan="3"><c:out value="${cstaff.staff.name}"></c:out></td> 
                     <td>性别：</td>
                     <td  colspan="3">
                     <c:if test="${!cstaff.staff.sex }">男</c:if>
                      <c:if test="${cstaff.staff.sex}">女</c:if>
                     </td>
                     </tr>
                      <tr>
                     <td>身份证号：</td>
                      <td colspan="3" id="idnum"><c:out value="${cstaff.staff.idCardNum}"></c:out>
                      </td> 
                      
                     <td>状态：</td>
                     <td  colspan="3">
                      <c:if test="${staff.state == 3 }">退休</c:if>
                      <c:if test="${staff.state == 4 }">实习</c:if>
                      <c:if test="${staff.state == 5 }">在职</c:if>
                      <c:if test="${staff.state == 6 }">离职</c:if>
                     </td>
                     </tr>
                      <tr>
                     <td>联系电话：</td>
                      <td colspan="3"><c:out value="${staff.phone}"></c:out></td> 
                     <td>出生日期：</td>
                     <td  colspan="3">
                     	<label id="shenfen"></label>
                     </td>
                     </tr>
                      <tr>
                     <td>毕业学校：</td>
                      <td colspan="3"><c:out value="${staff.graduateSchool}"></c:out></td> 
                     <td>学历：</td>
                     <td  colspan="3"><c:out value="${staff.eduBackground}"></c:out></td>
                     </tr>
                      <tr>
                     <td>专业：</td>
                      <td colspan="3"><c:out value="${staff.professional}"></c:out></td> 
                     <td>毕业时间：</td>
                     <td  colspan="3">
                     <fmt:formatDate value='${staff.graduateDate}' pattern='yyyy-MM-dd'/>
                     </td>
                     </tr>
                     
                     <tr>
								<td>地址</td>
								<td colspan="3">
									<c:out value="${staff.province}"></c:out>									
									<c:out	value="${staff.city}"></c:out> 
									<c:out value="${staff.county}"></c:out> 
									<c:out	value="${staff.detailAddress}"></c:out>
							  </td>
					 </tr>                    
                      <tr>
                      <td colspan="8" class="title-td">聘用信息</td>
                    </tr>
                   <tr>
                   <tr>
                     <td>职务：</td>
                      <td colspan="3"><c:out value="${staff.job}"></c:out></td> 
                     <td>入职时间：</td>
                     <td  colspan="3">
                     <fmt:formatDate value='${staff.cometoOfficeDate}' pattern='yyyy-MM-dd'/>
                     </td>
                     </tr>
                     <tr>			
                     <td>聘用开始时间：</td>
                      <td colspan="3">
                       <fmt:formatDate value='${staff.hireStratDate}' pattern='yyyy-MM-dd'/>
                      </td>
                     <td>聘用类型：</td>
                      <td colspan="3"><c:out value="${staff.hireType}"></c:out></td> 
                    
                     </tr>
                    
					 <tr>
					  <td> 部门：</td>
                      	<td colspan="3"><c:out value="${staff.department}"></c:out></td> 
                    	 <td>聘用结束时间：</td>
                      <td colspan="3">
                      <fmt:formatDate value='${staff.hireEndDate}' pattern='yyyy-MM-dd'/>
                      </td>   
                      </tr>   
                               
                    <tr>
                      <td colspan="8" class="title-td">职业资格相关信息</td>
                    </tr>
                   <tr>
                   <tr>
                     <td>执业资格证书类型：</td>
                      <td colspan="3"><c:out value="${staff.certificateType}"></c:out></td> 
                     <td>执业资格证书编号：</td>
                     <td  colspan="3"><c:out value="${staff.cerificateNum}" ></c:out></td>
                     </tr>
                     <tr>
                     <td>执业资格证书名称：</td>
                      <td colspan="3"><c:out value="${staff.certificateName}" ></c:out></td> 
                    <tr>
                      <td colspan="8" class="title-td">职称相关信息</td>
                    </tr>
                   <tr>
                    <tr>
                     <td>职称等级：</td>
                      <td colspan="3"><c:out value="${staff.jobTitleLevel}" ></c:out></td> 
                     <td>职称证书编号：</td>
                     <td  colspan="3"><c:out value="${staff.jobTitleNum}" ></c:out></td>
                     </tr>
                      <tr>
                     <td>职称证书：</td>
                      <td colspan="3"><c:out value="${staff.jobTitleCertificate}" ></c:out></td> 
                    <tr>
                      <td colspan="8" class="title-td">其他信息</td>
                    </tr>
                    <tr>
                    <td>上岗培训开始时间：</td>
                      <td colspan="3">
                      <fmt:formatDate value='${staff.trainStratDate}' pattern='yyyy-MM-dd'/>
                      </td> 
                     <td>是否取得全科医生培训证书：</td>
                     <td  colspan="3"><c:out value="${staff.gpTrain}" ></c:out></td>
                     </tr>
                     <tr>
                     <td>上岗培训结束时间：</td>
                      <td colspan="3">
                      <fmt:formatDate value='${staff.trainEndDate}' pattern='yyyy-MM-dd'/>
                      </td> 
                     </tr>
                     
                   <tr>
                 </tbody>
               </table>
               <div class="btn-content">
               <a href="javascript:;" class="btn btn-print btn-dayin">打印</a>
                  <a href="javascript:history.go(-1)"  class="btn">返回</a>
 				</div>
             
           
             </form>
           </div>
           <!-- 表单表格 start -->
   
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
<script>
	$(function(){
		var id=$("#idnum").text();
		var year = id.substring(6,10);
	    var month = id.substring(10,12);
		var date=id.substring(12,14);
		var birth=year+"-"+month+"-"+date;
		$("#shenfen").html(birth);
	})
   
</script>
</body>
</html>
