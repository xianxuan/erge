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
   <input name="yemianname" value="08201" type="hidden"/>
      <h3 class="current-title">社区医院统计分析</h3>
      <div class="search-content">
 		 <form   action="<%=basePath %>statisticsAction!getStatisticsList.action"    method="post">
     		<div class="search-item">
             
                <div id="add"></div>
          </div>
	           <div class="btn-content">
	               <!-- <input type="submit" value="查询" class="btn" onclick="checkform();"> -->
	           </div>
         </form>
      </div>
     <!-- 结果容器 start -->
   <h3 class="current-title">社区医院统计分析查询结果</h3>
      <div class="table-content">
       
        <table class="table table-bordered">
          <tbody>
           <tr>
             <td colspan="8" class="title-td">所选医院：
             <s:iterator value="selectHospitals" var="list">
             ${list.communityHospital},
             </s:iterator>
             </td>
             
           </tr>
           <tr>
             <td>总人数：</td>
             <td>${communityHospitalCount[0]}
            <s:if test="communityHospitalCount[0]!=null">
             <lable>人</lable>
             </s:if>
             </td>
          </tr>
           <tr>
             <td>老年人口数（55岁以上）：</td>
             <td>${communityHospitalCount[1]}
             <s:if test="communityHospitalCount[1]!=null">
             <lable>人</lable>
             </s:if>
             </td>
          </tr>
           <tr>
             <td>患病老人数：</td>
             <td>${communityHospitalCount[2]}
             <s:if test="communityHospitalCount[2]!=null">
             <lable>人</lable>
             </s:if>
             </td>
           </tr>
           <tr>
           		<td>发放健康设备数：</td>
           		<td>${count }</td>
           </tr>
           
          </tbody>
   
   
</table>

<div class="btn-content">
       <form action="<%=basePath %>statisticsAction!jumpCurrentCount.action"    method="post">
     		<div class="search-item">
                <s:iterator value="selectHospitals" var="ch">
                <input id="sq_1" type="hidden" name="communityHospitalIdList" value="${ch.communityHospitalId}" /><label for="sq_1"></label>
                </s:iterator>
          </div>
	           <div class="btn-content">
	               <input type="submit" value="统计各类疾病人数比例曲线" class="btn btn-xianshi ">
	            
	           </div>
         </form>
       
       
            </div>
     </div>
     </div>
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>

<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<script type="text/javascript">
	$(function () {
		
          
			var json=${json};
			for (var i = 0; i < json.length; i++) {
				var TemO = document.getElementById("add");
				var label = document.createElement("label");
				var newInput = document.createElement("input");
				var putId = json[i].value;
				newInput.setAttribute("id", putId)
				label.setAttribute("for",putId );				
				newInput.type = "checkbox";
				newInput.name = "communityHospitalIdList";
				newInput.value = json[i].value;
				var check=${jsonString};
				if(check!="0"){
					for(var j=0;j<check.length;j++)
					{
						if(check[j].value==json[i].value)
						{
							newInput.checked = check[j].checked;
						}
					}
				}
				//TemO.appendChild(newInput);
				TemO.appendChild(label);
				label.innerText = json[i].text;
				/* if ((i + 1) % 10 == 0 && i + 1 > 9) {
					var br = document.createElement("br");
					TemO.appendChild(br);
				} */
				if(i==json.length){
                    var br = document.createElement("br");
                    TemO.appendChild(br);
                }
			}
		
		
		
		
	});
	</script>
  <script type="text/javascript">
  window.onload = function(){
     var AllInput = document.getElementById('qbsq_0');
     var chk = document.getElementsByClassName('sq_1');
     AllInput.onclick = function(){
      if(AllInput.checked==true){
      		for(i=0;i<chk.length;i++){
      					chk[i].checked = true;
      		}
      }
      else{
     for(i=0;i<chk.length;i++){
      					chk[i].checked = false;
      		}
     }
   }
  }
  
    /*  function checkform() {
   var chk = document.getElementsByClassName('communityHospitalIdList');
   var j=0;
 
   for(i=0;i<chk.length;i++){
   if(	chk[i].checked == false){
   j++
   }
      	}
      	
    if(j==chk.length)
    {
    alert("请选择医院");
    return false;
    }
    else{
    return true;
    }
    
}
 */
  </script>

</body>
</html>
