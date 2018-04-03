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
  <link rel="stylesheet" type="text/css" href="/jmjkms/css/sweetalert.css"> 
  <link rel="stylesheet" href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css"> 
  <link rel="stylesheet" href="/jmjkms/css/bootstrap.min.css"> 
</head>
<style>
	#map-modal-sugar span,#map-modal span{display:inline-block;padding-right:12px}
	.container1{
  overflow: hidden;
  min-height: 800px;
  padding:12px;
  min-width: 1172px;
}
.nav{min-height:852px}
.nav,.container1{
  margin-bottom: 12px;
  padding-bottom: 232px;
}

</style>
<body>
  <!-- 顶栏 start -->
  <s:include value="/include/header.jsp" />
  <!-- 顶栏 end -->
  <div class="main-content clearfix">
    <!-- 主菜单 start -->
    <s:include value="/include/nav.jsp" />
    <!-- 主菜单 end -->
    <!-- 主容器 start -->
    <div class="container1">
      <h3 class="current-title" style="font-size:16px;">预警管理</h3>
      <div class="search-content">
      <input name="yemianname" value="02203" type="hidden"/>
        <form action="healthAlarmAction!getAlarmData.action" method="post">
          <div class="search-item">
          
            <label>预警处理日期：</label>
            <input type="text" id="startTime" name="startTime" id="dateInput1" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD '})"  value="${start }"  name="startTime" onfocus="this.blur()" style="height:28px;">
                                    至
            <input type="text" id="endTime" name="endTime" id="dateInput2" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD '})"  value="${end }"   name="endTime" onfocus="this.blur()" style="height:28px;">
          
            <input type="submit" value="查询" id="submit" class="btn btn-xianshi">
            
          </div>
        </form>
      </div>
      <!-- 搜索容器 end -->	
	 <!-- 表格容器 start -->
	  <form action="<%=basePath %>healthAlarmAction!export.action" method="post">
	 <h3 class="current-title" style="font-size:16px;">查询结果</h3>
	   <div class="table-content">	   	   
	   <table id="jqprint" class="table table-bordered">
	     <thead>
	       <tr>	         
	         <th>居民健康档案编号</th>
	         <th>姓名</th>
	         <th>性别</th>
	         <th>联系方式</th>
	         <th>预警指标</th>
	         <th>测量数据</th>
	         <th>预警级别</th>
	         <th>状态</th>
	         	         
	         <th style="text-align: center;">预警操作</th>	         
             </tr>
           </thead>
			<tbody>
			
		    <s:iterator value="alarmDataList" var="list" status="n">
		       
		       <input type="hidden" name="ids" value="${list.healthFileId}" />
		      
		        <tr>
		         <td>${list.fileNum}</td>
		         <td>${list.name}</td>
		         <c:if test="${list.sex==true}"><td>女</td></c:if>
		         <c:if test="${list.sex==false}"><td>男</td></c:if>
		         <td>${list.IPhone}</td>
		         <c:choose>
		           <c:when test="${list.alarmType==1  }"><!-- 血压 -->
		             <td><a style="cursor:pointer;" onclick="showBloodPressureDetail(${list.other3},${list.healthFileId})">${list.alarmQuota}</a></td>		
		             <td>收缩压(mmHg)：<fmt:formatNumber value="${list.other1 }" type="number" />&nbsp;&nbsp;舒张压(mmHg)：<fmt:formatNumber value="${list.other2 }" type="number" /></td>
		           </c:when>
		           <c:when	test="${list.alarmType==2 }"><!-- 血糖 -->
		            	<td><a style="cursor:pointer;" onclick="showBloodSugarDetail(${list.other3},${list.healthFileId})">${list.alarmQuota}</a></td>		
		         		<td>
		         		  <c:if test="${list.other1==1 }">餐前(mmoL/L)：</c:if>
		         		  <c:if test="${list.other1==2 }">餐后(mmoL/L)：</c:if>
		         		  ${list.other2 }
		         		</td>
		           </c:when>
		           <c:otherwise><!-- 没有alarmType标识的旧数据，默认展示 -->
		           		<td>${list.alarmQuota}</td>
		           		<td></td>
		           </c:otherwise>
		         </c:choose>		         
		                  
		         <td>${list.level}</td>
		         
		         <c:if test="${list.state==1}"><td>待处理</td></c:if>
		         <c:if test="${list.state==2}"><td>已处理</td></c:if>
		         <c:if test="${list.state==3}"><td>暂缓处理</td></c:if>
		         <c:if test="${list.state==4}"><td>不处理</td></c:if>
		         <c:if test="${list.state==0}"><td>无</td></c:if>
		         
		         <td>	          
		            <a id='btn_alert${n.index}'  herf="javascript:;" onclick="alertF(${n.index})" style="cursor: pointer;">预警处理</a>
		            <div id="mask_alert">
                    </div> 
                       <div id="demo_alert${n.index}" style="display:none;left: 50%;top: 50%;margin-left: -200px;position: fixed;margin-top: -75px;width: 480px;height: 150px;background-color: #fff;z-index: 10001;border:1px solid #ccc;border-radius: 5px;display: none;">
				        <div id="fa${n.index}" onclick="closeF(${n.index})" style="display:none;position:absolute;right: 20px;top:20px;cursor: pointer;">
				          <i class="fa fa-close"></i>
				        </div>
				        <div class="tan_tit">操作</div>
				        <div id="button_alert_2" >
				          <a href="healthAlarmAction!hanglehealthAlarm.action?alarmhandleresquest.status=1&alarmhandleresquest.id=${list.id}&alarmhandleresquest.meaTime=${list.meaTime }&alarmhandleresquest.devID=${list.devID}&alarmhandleresquest.level=${list.level }&alarmhandleresquest.alarmTime=${list.alarmTime }&alarmhandleresquest.alarmType=${list.alarmType }&alarmhandleresquest.alarmQuota=${list.alarmQuota }&beginTime=<fmt:formatDate value="${startTime }" pattern="yyyy-MM-dd"/>&overTime=<fmt:formatDate value="${endTime}" pattern="yyyy-MM-dd"/>"  class="btn" id="btn_write_off">待处理</a>
				          <a href="healthAlarmAction!hanglehealthAlarm.action?alarmhandleresquest.status=2&alarmhandleresquest.id=${list.id}&alarmhandleresquest.meaTime=${list.meaTime }&alarmhandleresquest.devID=${list.devID}&alarmhandleresquest.level=${list.level }&alarmhandleresquest.alarmTime=${list.alarmTime }&alarmhandleresquest.alarmType=${list.alarmType }&alarmhandleresquest.alarmQuota=${list.alarmQuota }&beginTime=<fmt:formatDate value="${startTime }" pattern="yyyy-MM-dd"/>&overTime=<fmt:formatDate value="${endTime}" pattern="yyyy-MM-dd"/>"  class="btn" id="btn_write_off">已处理</a>
				          <a href="healthAlarmAction!hanglehealthAlarm.action?alarmhandleresquest.status=3&alarmhandleresquest.id=${list.id}&alarmhandleresquest.meaTime=${list.meaTime }&alarmhandleresquest.devID=${list.devID}&alarmhandleresquest.level=${list.level }&alarmhandleresquest.alarmTime=${list.alarmTime }&alarmhandleresquest.alarmType=${list.alarmType }&alarmhandleresquest.alarmQuota=${list.alarmQuota }&beginTime=<fmt:formatDate value="${startTime }" pattern="yyyy-MM-dd"/>&overTime=<fmt:formatDate value="${endTime}" pattern="yyyy-MM-dd"/>" class="btn" id="btn_delete">暂缓处理</a>	         
				          <a href="healthAlarmAction!hanglehealthAlarm.action?alarmhandleresquest.status=4&alarmhandleresquest.id=${list.id}&alarmhandleresquest.meaTime=${list.meaTime }&alarmhandleresquest.devID=${list.devID}&alarmhandleresquest.level=${list.level }&alarmhandleresquest.alarmTime=${list.alarmTime }&alarmhandleresquest.alarmType=${list.alarmType }&alarmhandleresquest.alarmQuota=${list.alarmQuota }&beginTime=<fmt:formatDate value="${startTime }" pattern="yyyy-MM-dd"/>&overTime=<fmt:formatDate value="${endTime}" pattern="yyyy-MM-dd"/>"  class="btn" id="btn_regist" >不处理</a>
				        </div>
				        </div>
		            
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
		  </div>
	  <!-- 分页 end -->
	   
	   
	  
	 </div>
	    <!-- 表格容器 end -->
	 <div class="btn-content" style="text-align:center;">
	     <!-- <input type="file" id="file" class="select-file">
	      <input type="submit" class="btn"  value="导出全部"  onclick="run01()"></input> -->
          <!-- <input type="submit" class="btn"  value="导出本页"  onclick="run02()"></input>	 --> 
          <!-- <a href="healthAlarmAction!export.action" class="btn ">导出本页</a>  -->    
	   </div>

  </form>
    </div>
    <div  class="modal fade bs-example-modal-sm" id="map-modal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" >
            <div class="modal-header" >
                <h2 style="color:indianred">血压详情</h2>
            </div>
            <div class="modal-body">
                <div style="line-height:30px;padding:10px;border:1px solid #ddd"><b> 姓名：</b><span class="currName"></span> <b> 性别：</b><span class="currSex"></span> <b> 电话：</b><span class="currCall"></span></div>
                <div class="table-content">
				<!-- 血压表单表格 start -->
					<table class="table table-bordered">
						<tbody>
							<tr>
								<td class="thBg"><b style="color:#ffaf60">测量条件</b> <!--  
                          <input type="hidden"  value="${healthFileId}"  name="healthFileId" />
                          <input type="hidden"  value="${cloudId}"  name="cloudId" />
                          -->
								</td>
								<td class="meaState">
								</td>
								<td class="thBg"><b style="color:#ffaf60">测量时间</b></td>
								<td class="meaTime"></td>
							</tr>
							<tr>
								<td class="thBg"><b style="color:#ffaf60">是否服药</b></td>
								<td class="takeMed">
								</td>
								<td class="thBg"><b style="color:#ffaf60">药物名称</b></td>
								<td class="medName"></td>
							</tr>
							<tr>
								<td class="thBg"><b style="color:#ffaf60">测量手臂</b></td>
								<td class="arm"></td>
								<td class="thBg"><b style="color:#ffaf60">脉率(次/min)</b></td>
								<td class="pulse"></td>

							</tr>
							<tr>
								<td class="thBg"><b style="color:#ffaf60">收缩压(mmHg)</b></td>
								<td class="sysPre"></td>
								<td class="thBg"><b style="color:#ffaf60">舒张压(mmHg)</b></td>
								<td class="diaPre"></td>
							</tr>
						</tbody>
					</table>
					<div class="btn-content">
						<button class="btn" type="button" onclick="closeModal('map-modal')">关闭</button>
					</div>
				<!-- 血压表单表格 end -->
			</div>
            </div>
           
        </div>
    </div>
</div>
    <div  class="modal fade bs-example-modal-sm" id="map-modal-sugar" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content" >
            <div class="modal-header" >
                <h2 style="color:indianred">血糖详情</h2>
            </div>
            <div class="modal-body">
                <div style="line-height:30px;padding:10px;border:1px solid #ddd"><b>姓名：</b><span class="sugarName"></span><b>性别：</b><span class="sugarSex"></span><b>身份证号：</b><span class="sugarCardId"></span> <b>电话：</b><span class="sugarCall"></span></div>
                <div class="table-content">
       <!-- 血糖表单表格 start -->
           <table class="table table-bordered">
             <tbody>
               <tr>
                 <td width='120' class=""><b style="color:#ffaf60">测量条件</b></td>
                 <td class="sugar_meaState">
                  </td>
                   <td class="thBg"><b style="color:#ffaf60">测量时间</b></td>
                 <td class="sugar_meaTime"></td>
                </tr>
                <tr>
                	<td class="thBg"><b style="color:#ffaf60">是否服药物</b></td>
                 <td class="sugar_takeMed">
                   
                </td>
                 <td class="thBg"><b style="color:#ffaf60">药物名称</b></td>
                 <td class="sugar_medName">
                  
                 </td>
                </tr>
                <tr>
                 <td class="thBg"><b style="color:#ffaf60">血糖值(mmoL/L )</b></td>
                 <td class="bloodSugar"></td>
                 <td class="thBg"><b style="color:#ffaf60">异常报警</b></td>
                 <td class="abnAlarm">
                </td>
               
              
               </tr>
               <tr>
                  <td class="thBg"><b style="color:#ffaf60">血糖分析结果</b></td>
                  <td colspan="3">
                  <textarea style="min-width:416px" name="bloodSuger.analysisResult" id="analysisResult"  
					class="textarea temp" datatype="*" nullmsg="血糖分析结果不可为空" disabled></textarea>
				 </td>
                </tr>
             </tbody>
           </table>
           <div class="btn-content">
				<a class="btn" onclick="closeModal('map-modal-sugar')">关闭</a>
            </div>
         <!-- 血糖表单表格 end -->
       </div>
            </div>
           
        </div>
    </div>
</div>
    
    
    
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>


<script src="/jmjkms/js/jquery-1.9.1.min.js"></script>
<script src="/jmjkms/js/sweetalert.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<script src="/jmjkms/js/jquery.jqprint-0.3.js"></script>
<script src="/jmjkms/js/bootstrap.min.js"></script>
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

<script type="text/javascript" >
	$(function(){
    	if(${code}==0||${code}==2||${code}==3||${code}==4||${code}==0){
    		endisable('${message}');
    	}
    });
   function endisable(data){
	   swal({  
	    title: data,  
	    showConfirmButton:true,
	    confirmButtonText: "确定",    
       });
    };
    
</script> 

    
<script type="text/javascript">
    $("#menu").change(function(){
    	var value = $("#menu").val();
    	var url = $("#yuying").attr("href");
    	url = url +"&alarmhandleresquest.status="+value;
    	$("#yuying").attr("href",url);
    })
</script>
<script type="text/javascript">
/*  var oMask_alert=document.getElementById('mask_alert');
    var oDemo_alert=document.getElementById('demo_alert');
    var oBtn_alert=document.getElementById('btn_alert');
    var oFa=document.getElementById('fa');
    window.onload=function(){
      oBtn_alert.onclick=alert_01;
      function alert_01(){
        oMask_alert.style.display='block';
        oDemo_alert.style.display='block';
      } 
      oFa.onclick=alert_02;
      function alert_02(){
        oMask_alert.style.display='none';
        oDemo_alert.style.display='none';
      }
      
 } */
 function alertF(param){
     var targetDemo = "demo_alert"+param;
     var targetFa= "fa"+param;
     $("#"+targetDemo).css("display","block");
     $("#"+targetFa).css("display","block");
 }
 
 function closeF(param){
     var targetDemo = "demo_alert"+param;
     var targetFa= "fa"+param;
     $("#"+targetDemo).css("display","none");
     $("#"+targetFa).css("display","none");
 }
  
 </script>
 <script type="text/javascript">
 $("form").submit(function(){
    	var startTime0=$("#startTime").val();
    	var endTime0=$("#endTime").val();
    	if(startTime0 != ""||endTime0 != ""){
    	if(startTime0>endTime0){
      	 	$("#startTime").val("");
       		$("#endTime").val("");
       		alert("查询时间顺序输入错误");
       		return false;
       	}
       	}
       	 	if(startTime0=="" && endTime0=="" && $("#num").val()==""){
       		alert("请输入查询条件!")
       		return false;
       		}
    })
 
 function showBloodPressureDetail(bpID,healthFileId){
	 $("#map-modal").modal({backdrop: 'static', keyboard: false});
	   $.ajax({
           type:'get',
           dataType:'json',
           url:"healthAlarmAction!getBloodPressureDetail.action?bpID="+bpID+"&healthFileId="+healthFileId,
           error:function(){
               alert('error')
           },
           success:function(data){
        	var data=$.parseJSON(data);
        	   console.log(data.item)
           	$(".currCall").html(data.IPhone)
           	$(".currName").html(data.name)
           	if(data.sex){$(".currSex").html("女")}else{$(".currSex").html("男")}
        	if(data.item.meaState=="0"){$(".meaState").html("安静")}else if(data.item.meaState=="1"){$(".meaState").html("饮酒后")}else{$(".meaState").html("运动后")}
          	$(".meaTime").html(data.item.meaTime)
          	if(data.item.takeMed=="0"){$(".takeMed").html("未服药")}else{$(".takeMed").html("已服药")}
          	if(data.item.arm=="0"){$(".arm").html("左手")}else{$(".takeMed").html("右手")}
          	$(".medName").html(data.item.medName)
          	$(".pulse").html(data.item.pulse)
          	$(".sysPre").html(data.item.sysPre)
          	$(".diaPre").html(data.item.diaPre)
           	
           }
       }); 
  // var bpWindow = window.open("healthAlarmAction!getBloodPressureDetail.action?bpID="+bpID+"&healthFileId="+healthFileId, "_blank", "width=800,height=350,left=350,top=250,toolbar=no,status=no,scrollbars=no,menubar=no,", false);
 }
 function closeModal(a){
	 $("#"+a).modal('hide')
 }
 function showBloodSugarDetail(bsID,healthFileId){
   //var bsWindow = window.open("healthAlarmAction!getBloodSugarDetail.action?bsID="+bsID+"&healthFileId="+healthFileId, "_blank", "width=800,height=450,left=350,top=250,toolbar=no,status=no,scrollbars=no,menubar=no,", false);
   $("#map-modal-sugar").modal({backdrop: 'static', keyboard: false});
   $.ajax({
       type:'get',
       dataType:'json',
       url:"healthAlarmAction!getBloodSugarDetail.action?bsID="+bsID+"&healthFileId="+healthFileId,
       error:function(){
           alert('error')
       },
       success:function(data){
    	var data=$.parseJSON(data);
       	$(".sugarCall").html(data.IPhone+" ")
       	$(".sugarName").html(data.name+" ")
       	$(".sugarCardId").html(data.item.idCard+" ")
       	if(data.sex){$(".sugarSex").html("女 ")}else{$(".sugarSex").html("男 ")}
    	if(data.item.meaState=="0"){$(".sugar_meaState").html("随机")}else if(data.item.meaState=="1"){$(".sugar_meaState").html("空腹")}else{$(".sugar_meaState").html("餐后")}
      	$(".sugar_meaTime").html(data.item.meaTime)
      	if(data.item.takeMed=="0"){$(".sugar_takeMed").html("未服药")}else{$(".sugar_takeMed").html("已服药")}
      	if(data.item.abnAlarm=="0"){$(".abnAlarm").html("设为不报警")}else{$(".abnAlarm").html("设为报警")}
      	$(".sugar_medName").html(data.item.medName)
      	$(".bloodSugar").html(data.item.bloodSugar)
      	$("#analysisResult").html(data.item.analysisResult)
       	
       }
   }); 
 }
 </script>
</body>
</html>
