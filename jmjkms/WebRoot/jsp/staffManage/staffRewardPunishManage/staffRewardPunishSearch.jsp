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
   <link rel="stylesheet" href="/jmjkms/css/confirm.css">
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
      <h3 class="current-title">员工奖惩管理</h3>
      <input name="yemianname" value="07203" type="hidden"/>
      <!-- 搜索容器 start -->
      <div class="search-content">
        <form id="registerform" action="<%=basePath %>staffRewardPunishAction!search.action"  method="post">
          <div class="search-item">
            <label>查询日期选择：</label>     
               <select name="flag" id="date" >
              <option value="0" <c:if test="${flag==0}">selected</c:if>>请选择</option>
              <option value="1"  <c:if test="${flag==1}">selected</c:if> >本月</option>
              <option value="2"  <c:if test="${flag==2}">selected</c:if> >上月</option>
              <option value="3"  <c:if test="${flag==3}">selected</c:if> >本季度</option>
              <option value="4"  <c:if test="${flag==4}">selected</c:if> >本年</option>
              <option value="5"  <c:if test="${flag==5}">selected</c:if> >自定义</option>
         </select>
         	<span class="qz-data">
                    <label>起始日期：</label>
                    <input type="text" id="dateInput1" class="w150" name="fromDate" value="${start }"  onclick="laydate({istime: true, format: 'YYYY-MM-DD'} )"  onfocus="this.blur()"/>
                    <label>终止日期：</label>
                    <input type="text" id="dateInput2" class="w150" name="toDate" value="${end }" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()"/>
             </span>
               		<label>奖惩类型：</label>	
		            <select name="rewordPunishType"  id="">      
					  <option value="" <c:if test="${'' eq rewordPunishType}">selected</c:if>>请选择</option> 
					  <option value="年终奖" <c:if test="${'年终奖' eq rewordPunishType}">selected</c:if> >年终奖</option>     
					  <option value="加班奖" <c:if test="${'加班奖' eq rewordPunishType}">selected</c:if> >加班奖</option>  
					  <option value="救死扶伤奖" <c:if test="${'救死扶伤奖' eq rewordPunishType}">selected</c:if> >救死扶伤奖</option> 
					  <option value="迟到惩罚" <c:if test="${'迟到惩罚' eq rewordPunishType}">selected</c:if> >迟到惩罚</option> 
					 </select>  
               		<label>员工姓名：</label><!--可输可选的input框-->
            		<input type="text" name="name" value="<c:out value='${name }'></c:out>" style="width:120px " maxlength="20"/>      
            </div>
			          <div class="btn-content"> <!--下面的是查询的代码-->
			            <input type="submit"  id="submit"  value="查询" class="btn btn-xianshi">
			            <a href="<%=basePath%>staffRewardPunishAction!toAdd.action" class="btn btn-xinzeng">新增员工奖惩</a><!-- //传过来一个List -->
			          </div>
        </form>
      </div>
      <!-- 搜索容器 end -->
      <!-- 结果容器 start -->
      <div class="table-content">
       <form action="<%=basePath %>staffRewardPunishAction!function.action" method="post">
        <table class="table table-bordered">
          <thead>
            <tr>
              <th>员工编号</th>
              <th>姓名</th>
              <c:if test="${session.communityHospitalGroup!=null || session.comHospital.isHead==0}">
              <th>社区医院</th>
              </c:if>
              <c:if test="${session.comHospital.isHead==0}">
              <th>社区集团</th>
              </c:if>
              <th>日期</th>
              <th>奖惩类型</th>
              <th>奖惩原因</th>
              <th>金额</th>
              <th>操作</th>
            </tr>
          </thead>
          <tbody>
          <s:action  name="staffRewardPunishAction!getAllStaffRewardPunish"  namespace="/" var="h"></s:action>
         
         
           <s:iterator value="vstaffRewardPunishList" var="vstaff">
              <input type="hidden" name="ids" id="id" value="${vstaff.staffRewardPunishId}">
				
				<tr>
             
              <td> <span class="dspan"><c:out value="${vstaff.staffNumber }"></c:out></span></td>
              <td> <span class="dspan"><c:out value="${vstaff.name}"></c:out></span></td>
              <c:if test="${session.communityHospitalGroup!=null || session.comHospital.isHead==0}">
              <td> <span class="dspan"><c:out value="${vstaff.communityHospital}"></c:out></span></td>
              </c:if>
              <c:if test="${session.comHospital.isHead==0}">
              <td> <span class="dspan"><c:out value="${vstaff.groupName}"></c:out></span></td>
              </c:if>
              <td> <span class="dspan"><fmt:formatDate value="${vstaff.rewardPunishDate }" pattern='yyyy-MM-dd'/></span></td>
              <td> <span class="dspan"><c:out value="${vstaff.rewordPunishType}"></c:out></span></td>
              <td>
              		<span class="cspan"><c:out value="${vstaff.rewordPunishReason }"></c:out></span>
              		
              </td>
              <td> <span class="dspan"> <c:out  value= "${vstaff.rewordPunishAmount}"></c:out></span></td>
              <td>
                <a class="btn-xianshi" href="<%=basePath %>staffRewardPunishAction!staffRewardPunishDetail.action?srpId=${vstaff.staffRewardPunishId}" >详情</a>
                <a class="btn-xiugai" href="<%=basePath %>staffRewardPunishAction!jumpUpdateStaffRewardPunish.action?staffRewardPunishId=${vstaff.staffRewardPunishId}&staffId=${vstaff.staffId}">编辑</a>
                <a class="btn-shanchu" onclick="return confirm('是否删除')" href="<%=basePath %>staffRewardPunishAction!deletestaffRewardPunish.action?srpId= ${vstaff.staffRewardPunishId}">删除</a>
              </td>
            </tr>
            </s:iterator>
          </tbody>
                  
        </table>
         <input type="hidden" name="flag"  id="act" value=""/>
        <!-- 分页 Start -->
        <div class="sum-btn">
	        <div class="page">
	       		 ${ pageHtml }
	        </div>
	        <!-- 分页 end -->
	
	       		<div class="btn-content2">
	       		 <input type="submit" class="btn btn-daochu"  value="导出本页"  onclick="run01()"></input>
	          <input type="submit" class="btn btn-daochu"  value="导出全部"  onclick="run02()"></input>
	        </div>
        </div>
        </form>
       
      </div>
      <!-- 结果容器 end -->
    </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>

<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
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
<script type="text/javascript" src="/jmjkms/js/confirm/Validform_v5.3.2_min.js"></script>
<script type="text/javascript">
$(function(){
      $("#registerform").Validform({
        showAllError:false,
        tiptype:function(msg){          
          alert(msg);
        }
      });
      var dataVal = $("#date").val();
      if(dataVal == '5') {
      	$(".qz-data").show();//class用.
      } else {
      	$(".qz-data").hide();
      }
      $("#date").change(function(){ //id用#
      	if ($(this).val() == '5') {
      		$(".qz-data").show();
      	} else {
      		$(".qz-data").hide();
      	}
      });
  });
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
