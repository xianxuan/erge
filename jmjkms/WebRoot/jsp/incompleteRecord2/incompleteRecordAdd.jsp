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
   <link rel="stylesheet" href="/jmjkms/css/confirm.css">
   <link rel="stylesheet" href="/jmjkms/select2/css/select2.css">
   <link rel="stylesheet" href="/jmjkms/css/jzjl.css">
   
<link rel="stylesheet" type="text/css"
	href="/jmjkms/js/extjs/resources/css/ext-all.css" />
<link rel="stylesheet" type="text/css"
	href="/jmjkms/js/extjs/resources/css/xtheme-light.css" />
<script type="text/javascript" src="/jmjkms/js/extjs/ext-base.js"></script>
<script type="text/javascript" src="/jmjkms/js/extjs/ext-all.js"></script>
<script type="text/javascript" src="/jmjkms/js/extjs/ext-lang-zh_CN.js"></script>
<script type="text/javascript" src="/jmjkms/js/jquery-1.9.1.min.js"></script>
<script language="JavaScript" type="text/JavaScript">
   function gxySearch(){
      //alert('gxy');
      $.ajax({
         type:"POST",
         url:"showOldChronicAction!checkHasChronic.action",
         data:{
             "searchbean.renqun": '1',
             "searchbean.selectFlag": '3',
	          "searchbean.selectValue":'${healthFile.fileNum}',
	          "embeded":true
         },
         dataType:"json",
         async:false,
         success:function(result){
            //alert(result);
            if(result<=0){//没有高血压慢性病档案，跳转到添加界面
               alert("请先创建高血压慢性病档案！");
               window.location.href = "showOldChronicAction!jumpOneHighBlood.action?embeded=true&helid="+${healthFile.healthFileId };
              // if(confirm("是否创建高血压慢性病档案？")){
             //    window.location.href = "showOldChronicAction!jumpOneHighBlood.action?embeded=true&helid="+${healthFile.healthFileId };
              // } else {
              //   tabs.setActiveTab("7");
             //  }
            } else if(result > 0){//有高血压慢性病档案，展示高血压随访界面
              // var gxyFrame = document.getElementById("gxyframe");
              // gxyFrame.src = "oldChronicFollowAction!jumpAddFollowFromEmbeded.action?cid="+result+"&hid="+${healthFile.healthFileId };
            }
         },
         error:function(){}
      });
     
	      
   }
   function tnbSearch(){
      //alert('tnb');
      $.ajax({
         type:"POST",
         url:"showOldChronicAction!checkHasChronic.action",
         data:{
             "searchbean.renqun": '2',
             "searchbean.selectFlag": '3',
	          "searchbean.selectValue":'${healthFile.fileNum}',
	          "embeded":true
         },
         dataType:"json",
         async:false,
         success:function(result){
            //alert(result);
            if(result<=0){//没有糖尿病慢性病档案，跳转到添加界面
               alert("请先创建糖尿病慢性病档案！");
               window.location.href = "showOldChronicAction!jumpDiabete.action?embeded=true&helid="+${healthFile.healthFileId };
              // if(confirm("是否创建糖尿病慢性病档案？")){
              //   window.location.href = "showOldChronicAction!jumpDiabete.action?embeded=true&helid="+${healthFile.healthFileId };
             //  } else {
             //    tabs.setActiveTab("7");
             //  }
            } else if(result > 0){//有糖尿病慢性病档案，展示糖尿病随访界面
               //var tnbFrame = document.getElementById("tnbframe");
              // tnbFrame.src = "oldChronicFollowAction!jumpAddFollowFromEmbeded.action?cid="+result+"&hid="+${healthFile.healthFileId };
            }
         },
         error:function(){}
      });
      
   }
   var tabs;
	Ext.onReady(function(){
		tabs = new Ext.TabPanel({
			renderTo: 'tabs',
			width:1500,
			activeTab: 7,
			frame:true,
			autoHeight: true,
			defaults:{autoHeight: true},
			items:[
				{contentEl:'jkda', title: '健康档案',autoHeight: true},
				{contentEl:'xyda', title: '血压档案',autoHeight: true},
				{contentEl:'xtda', title: '血糖档案',autoHeight: true},
				{contentEl:'jkytjda', title: '健康一体机档案',autoHeight: true},
				{contentEl:'ncgda', title: '尿常规档案',autoHeight: true},
				{contentEl:'xdda', title: '心电档案',autoHeight: true},
				{contentEl:'tjxx', title: '体检信息',autoHeight: true},
				{contentEl:'jiezhen', title: '接诊记录',autoHeight: true},
				{contentEl:'gxysf', title: '高血压随访',autoHeight: true,listeners:{show:function(){
			                   console.log('show event!高血压随访');
			                   gxySearch();
			               }
			        }},
				{contentEl:'tnbsf', title: '糖尿病随访',autoHeight: true,listeners:{show:function(){
			                   console.log('show event!糖尿病随访');
			                   tnbSearch();
			               }
			        }},
			],
			
		});
		//tabs.setActiveTab(document.getElementById('activeTab').value);
		//tabs.getItem('gxysf').activate  = gxyClick;
		//tabs.getItem('tnbsf').onclick = tnbClick;
	});
	// resize child iframe in parent page
function resizeChildIframe (childIframeID, extHeight){
	var targWin=document.getElementById(childIframeID);
	if(targWin!=null){
		var HeightValue=document.body.clientHeight-extHeight;
		if (bIsIE)
			targWin.style.pixelHeight=HeightValue;
		else if (bIsFF || bIsCH)
			targWin.style.height=HeightValue+"px";
		else
			targWin.style.height=HeightValue+"px";
		//alert(targWin.name +":" + HeightValue)
	}
}

function onloadProcess () {
    resizeChildIframe("jkdaframe", 150);
    resizeChildIframe("xydaframe", 150);
    resizeChildIframe("xtdaframe", 150);
    resizeChildIframe("jkytjdaframe", 150);
    resizeChildIframe("ncgdaframe", 150);
    resizeChildIframe("xddaframe", 150);
    resizeChildIframe("tjxxframe", 150);
    resizeChildIframe("gxyframe", 150);
    resizeChildIframe("tnbframe", 150);
    }
//window.onload = onloadProcess;
function onresizeProcess () {
    resizeChildIframe("jkdaframe", 150);
    resizeChildIframe("xydaframe", 150);
    resizeChildIframe("xtdaframe", 150);
    resizeChildIframe("jkytjdaframe", 150);
    resizeChildIframe("ncgdaframe", 150);
    resizeChildIframe("xddaframe", 150);
    resizeChildIframe("tjxxframe", 150);
    resizeChildIframe("gxyframe", 150);
    resizeChildIframe("tnbframe", 150);
    }
//window.onresize = onresizeProcess;
	</script>
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
      <h3 class="current-title">接诊记录-新增</h3>
      
           <!-- 删除此行注释，在此添加对应的div -->
        <div class="search-content">
          <form action="incompleteRecordAction2!findIncompleteRecord.action" method="post" id="registerform1">
            <label>查询选项：</label>
              <select name="flag" id="">
              	<option value="2" <c:if test="${flag eq 2}">selected</c:if>>姓名</option>
                <option value="0" <c:if test="${flag eq 0}">selected</c:if>>档案编号</option>
                <option value="1" <c:if test="${flag eq 1}">selected</c:if>>身份证号</option>
              </select>
              <input id="searchText"  datatype="*"  nullmsg="请输入查询信息"    type="text" class="w150" name="value" value="${value}" >
              <input type="submit" class="btn" value="查询">
              <span class="required">${str}</span>
              <label>姓名：<c:out value="${healthFile.name}"></c:out></label>
              <label>档案编号：<c:out value="${healthFile.fileNum}"></c:out></label>
          </form>
        </div>
         <input name="yemianname" value="06202" type="hidden"/>
        <c:if test="${conFlag==1}">
        <div class="table-content">
       <!-- 主容器 start -->
		<div class="container">
			<input name="yemianname"
				value="06202" type="hidden" /> <input name='activeTab'
				id='activeTab' value='${activeTab }' type='hidden'>
			<!-- 标签页 start -->
			<div id="tabs"
				style=" border:none; margin:1px 0px 0px;padding:0;width:100%;"
				class="table-content">

				<!-- 健康档案Start -->
				<div id='jkda' class="x-hide-display" style="margin:3px;">
				<iframe src="incompleteRecordAction2!turnToHealthFileView.action?healthFileId=${healthFile.healthFileId }"   name='jkdaframe' id='jkdaframe' scrolling='auto' height="2300"></iframe>
					<!--     <iframe src="healthFileAction!turnToHealthFileView.action?healthFileId=${healthFile.healthFileId }&embeded=true"   name='jkdaframe' id='jkdaframe' scrolling='no'></iframe>
            
            <c:if test="${healthFile.belongSystem=='2' }">
             <iframe src='healthFileAction!turnToHealthFileView.action?healthFileId=${healthFile.healthFileId }&healthCloudId=${-healthFile.id }&belongSystemQianDuan=2&embeded=true'   name='jkdaframe' id='jkdaframe' scrolling='no'></iframe>             
           </c:if>
            
           <c:if test="${healthFile.belongSystem=='3' }">
             <iframe src='healthFileAction!turnToHealthFileView.action?healthFileId=${healthFile.healthFileId }&healthCloudId=${-healthFile.id }&embeded=true'   name='jkdaframe' id='jkdaframe' scrolling='no'></iframe>
           </c:if>
           -->
				</div>
				<!-- 健康档案End -->

				<!-- 血压档案Start -->
				<div id='xyda' class="x-hide-display" style="margin:3px;">
					<iframe
						src='HealthManagerAction!getBloodPressFromCloud.action?healthFileId=${healthFile.healthFileId }&embeded=true'
						name='xydaframe' id='xydaframe' scrolling='auto' height="900"></iframe>
				</div>
				<!-- 血压档案End -->

				<!-- 血糖档案Start -->
				<div id='xtda' class="x-hide-display" style="margin:3px;">
					<iframe
						src='HealthManagerAction!getBloodSugerFromCloud.action?healthFileId=${healthFile.healthFileId }&embeded=true'
						name='xtdaframe' id='xtdaframe' scrolling='auto' height="900"></iframe>
				</div>
				<!-- 血糖档案End -->

				<!-- 健康一体机档案Start -->
				<div id='jkytjda' class="x-hide-display" style="margin:3px;">
					<iframe
						src='HealthManagerAction!getAllInOneData.action?healthFileId=${healthFile.healthFileId }&embeded=true'
						name='jkytjdaframe' id='jkytjdaframe' scrolling='auto' height="900"></iframe>
				</div>
				<!-- 健康一体机档案End -->

				<!-- 尿常规档案Start -->
				<div id='ncgda' class="x-hide-display" style="margin:3px;">
					<iframe
						src='UrineAction!getList.action?healthFileId=${healthFile.healthFileId }&embeded=true'
						name='ncgdaframe' id='ncgdaframe' scrolling='auto' height="900"></iframe>
				</div>
				<!-- 尿常规档案End -->


				<!-- 心电档案Start -->
				<div id='xdda' class="x-hide-display" style="margin:3px;">
					<iframe
						src='EcgAction!getList.action?healthFileId=${healthFile.healthFileId }&embeded=true'
						name='xddaframe' id='xddaframe' scrolling='auto' height="900"></iframe>
				</div>
				<!-- 心电档案End -->

				<!-- 体检信息Start -->
				<div id='tjxx' class="x-hide-display" style="margin:3px;">
					<iframe
						src='PhysicalExamAction!showPhysicalExamListBypersonal.action?healthFileId=${healthFile.healthFileId }&belongSystem=${healthFile.belongSystem }&jiGouFileNum=${healthFile.fileNum }&jiGouname=${healthFile.name }&jiGousex=${healthFile.sex }&embeded=true'
						name='tjxxframe' id='tjxxframe' scrolling='auto' height="900"></iframe>
				</div>
				<!-- 体检信息End -->

				<!-- 接诊记录 Start -->
				<div id="jiezhen" class="x-hide-display" style="margin:3px;">
					<%@ include file="addJzjlPart.jsp" %>
				</div>
				<!-- 接诊记录 End -->
				<!-- 高血压随访Start -->
				<div id='gxysf' class="x-hide-display" style="margin:3px;">
				    <!--  
					<iframe src='' name='gxyframe' id='gxyframe' scrolling='auto' height="900"></iframe>
					-->
					<%@ include file = "addGxysfPart.jsp" %>
				</div>
				<!-- 高血压随访End -->
				<!-- 糖尿病随访Start -->
				<div id='tnbsf' class="x-hide-display" style="margin:3px;">
					<!--  
					<iframe src='' name='tnbframe' id='tnbframe' scrolling='auto' height="1100"></iframe>
					-->
					<%@ include  file = "addTnbsfPart.jsp" %>
				</div>
				<!-- 糖尿病随访End -->
			</div>
			<!-- 标签页 end -->

		</div>
		<!-- 主容器 end -->
          </div>
      

</c:if>
	 <div id="showwindow" class="table-content"" id="button_alert_2">
 			<h3 class="current-title">查询结果</h3>
 			<table class="table table-bordered">
  			<thead>
			<tr>
				<th>姓名</th>
				<th>身份证号</th>
			</tr>
			</thead>
			<tbody>
				<s:iterator value="listolder" var="lo">
					<tr>
					<td><a href="<%=basePath %>incompleteRecordAction!ReOlder.action?healthFileId=${lo.healthFileId}" id="btn_write_off">${lo.name}</a></td>
					<td>${lo.idNum}</td>
				</s:iterator>
			</tbody>
			</table>
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
<script src="/jmjkms/js/confirm/Validform_v5.3.2_min.js"></script>
<script src="/jmjkms/select2/js/select2.full.js"></script>

<script type="text/javascript">
	$(function(){
		$(".js-example-basic-single").select2();
	})
</script>
		<script type="text/javascript">
		/*
		var isCommitted = false;//表单是否已经提交标识，默认为false
		function dosubmit() {
			// 此处还需要判断各个必填项校验是否通过
			//alert("1" + isCommitted);
			if (isCommitted == false
					&& document.getElementById('Doctor').value != ""&& document.getElementById('Date').value != "") {
				//提交表单后，将表单是否已经提交标识设置为true
				isCommitted = true;

			//获取表单提交按钮
		    var btnSubmit = document.getElementById("submit");
   			//将表单提交按钮设置为不可用，这样就可以避免用户再次点击提交按钮
   			btnSubmit.disabled= "disabled";
			return true;//返回true让表单正常提交
			} else {
				return false;//返回false那么表单将不提交
			}
		}
		*/
	</script>
	<script type="text/javascript">
	$(function(){
		var show=${showwindow};
		if(show){
			$("#showwindow").css("display","block");
		}else
		{
			$("#showwindow").css("display","none");
		}
	});
	//准备好高血压、糖尿病页面中下来菜单项
	window.onload = function(){
	  tnbDi();
	  gxyDi();
	};

</script>
</body>
</html>
