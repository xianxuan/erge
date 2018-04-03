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
  <base href="<%=basePath%>">
  <link rel="stylesheet" href="/jmjkms/css/confirm.css">
  <link rel="stylesheet" href="/jmjkms/css/cssreset.css">
  <link rel="stylesheet" href="/jmjkms/css/main.css">
  <link rel="stylesheet" href="/jmjkms/select2/css/select2.css">
  <link rel="stylesheet" href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">
  <style type="text/css">
  .jia{
    width: 150px;
    height: 30px;
    /*background: #ccc;*/
    position: relative;
   
  }
  .di{
    width: 100px;
    height: 30px;
    position: absolute;
    top: 0;
    left: 0;
  }
  input[type="text"].gai{
    width: 70px;
    height: 22px;
    display: block;
    position: absolute;
    top: 0;
    left: 0;
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
      <h3 class="current-title">体检添加 </h3>
      <%--  <h3>姓名：${thealthFile.name} 档案编号：${thealthFile.fileNum}</h3> --%>
      
        <div class="search-content"> 
    
      
          <form id="registerform1" action="<%=basePath%>PhysicalExamAction!addsearchPhysicalExam.action" method="post" enctype="multipart/form-data"> 
           
            <label>查询选项：</label> 
            <select name="searchMethod" id=""> 
            <option value="3">档案编号</option> 
            <option value="2"<c:if test="${searchMethod==2}">selected</c:if>>姓名</option> 
            <option value="1" <c:if test="${searchMethod==1}">selected</c:if>>身份证号</option> 
            </select> 
            <input id="searchText"  datatype="*"  nullmsg="请输入查询信息" type="text" class="w150 temp" name="searchNum" value="${searchNum}" > 
            <input type="submit" id="content-btn" class="btn" value="查询" >
            <span class="required">${str}</span>         
        	  姓名：${thealthFile.name} 档案编号：${thealthFile.fileNum}
          </form>  
        </div>
        
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
				<s:iterator value="thealthFileList" var="lo">
					<tr>
					<td><a href="<%=basePath%>PhysicalExamAction!jumpAddPhysicalExam.action?fileNum=${lo.fileNum}" id="btn_write_off">${lo.name}</a></td>
					<td>${lo.idNum}</td>
				</s:iterator>
			</tbody>
			</table>
		</div>	
        
        
        
        
        
        
        
        
        
        
        
            <s:action name="PhysicalExamAction!autoAction" namespace="/" var="auto"> </s:action>
        <input name="yemianname" value="03100" type="hidden"/> <!-- //权限隐藏框 -->
            <!-- 表单表格 start --> 
            <div class="table-content" id="content" style="display:none">
              <form id="registerform" action="PhysicalExamAction!addPhysicalExam.action" method="post" enctype="multipart/form-data"> 
                          <!--健康档案的ID 将其放入隐藏域 -->
               <input type="hidden" id="content-input" name="thealthFile.healthFileId" value="${thealthFile.healthFileId}">
               	 <input type="hidden" id="content-input" name="thealthFile.idNum" value="${thealthFile.idNum}">
                        		
               			<!--  令牌 -->
                <input type="hidden" name="addToken" value="${addToken}" />
                          <table class="table table-bordered">
                           <tbody>
                                   <tr>
                                        <td><span class="required temp">*</span>体检类型：
                                        </td> 
                                         <td colspan="3"><input id="exam-type" type="text" name="tphysicalexam.physicalExamType"  datatype="*1-20" nullmsg="体检类型不可为空" errormsg="体检类型输入有误"></td>
                                         <td><span class="required">*</span>体检日期:
                                         </td> 
                                         <td colspan="3" >
                                         <input type="text" id="time" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" datatype="*1-20" nullmsg="体检日期不可为空" errormsg="体检日期输入有误" onfocus="this.blur()" name="tphysicalexam.physicalExamDate" value="${currentTime }" 
                                         					minlength="1"	>
                                         </td>
                                       
                                   </tr>
                                  <s:action name="PhysicalExamAction!allDoctor" namespace="/" var="ad"> </s:action>
                                   <tr>
                                        <td><span class="required">*</span>体检医生:
                                        </td> 
                                         <td colspan="3">
                                         
                                         		<select name="tphysicalexam.responsibleDoctor"  class="js-example-basic-single" class="select2" style="width: 170px;" datatype="*" nullmsg="体检医生不可为空" onchange="getContent(this.value,this.options[this.selectedIndex].text)" >
                                         		
                                  		  		<!-- 	<option value=" "></option>  -->
			                          	 		<s:iterator value="#ad.doctorList" var="doctor"  status="n">
			                          	 		<option value="${doctor.name}" <c:if test="${session.tstaff.staffId eq doctor.staffId}">selected</c:if>>${doctor.name}</option>			                       
			                         	 		
			                             		<%-- <option value="${doctor.name}">${doctor.name}</option> --%>
			                            		 </s:iterator>
			                         		 </select>
                                         
                                         </td>
                                         <td><span class="required">*</span>录入员:
                                         </td> 
                                         <td colspan="3">
                                         		<select name="tphysicalexam.operator" datatype="*" class="js-example-basic-single" class="select2" style="width: 170px;" nullmsg="录入员不可为空" onchange="getContent(this.value,this.options[this.selectedIndex].text)" >
	                                  		 <!-- <option value="" ></option> -->
				                          	 <s:iterator value="#ad.doctorList" var="doctor"  status="n">
				                          	 <option value="${doctor.name}" <c:if test="${tstaff.staffId eq doctor.staffId}">selected</c:if>>${doctor.name}</option>
				                            <%--  <option value="${doctor.name}">${doctor.name}</option> --%>
				                             </s:iterator> 
			                         	 </select>
                                         </td>
 									</tr>
                                   <tr>
                                     <td colspan="8" class="title-td">症状、一般状况</td>
                                   </tr>
                                   <tr>
                                     <td><span class="required">*</span>症状特点
                                     </td>  
                                     <td>
                                     	<select name="tphysicalexam.characteristicSymptom" datatype="*"  class="js-example-basic-single" class="select2" style="width: 120px;" nullmsg="症状特点不可为空" onchange="getContent(this.value,this.options[this.selectedIndex].text)" >
										<!--  <option value=" "> </option>  -->
                                  	 <s:iterator value="#auto.zztdList" var="zz" status="n">
                                  	 <option value="${zz.name}">${zz.name}</option> 
                                 	 </s:iterator>
                                     	</select>  	
                                     </td>

                                     <td>体温</td> 
                                      <td>
                                      	<input type="text"  class="w40 temp" name="tgeneralcondition.temperature" maxlength="4"  onkeyup="Num(this)">℃
                                      </td>
                                       <td>呼吸频率</td>
                                       <td><input type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"  class="w40 temp" name="tgeneralcondition.breathingRate" maxlength="5" errormsg="呼吸频率输入有误"  ignore="ignore" >次/分</td> 
                                    
                                     <td>舒张压</td> 
                                      <td><input type="text" onkeyup="Num(this)"  class="w40 temp" name="tgeneralcondition.diastolicPressure" maxlength="5"  errormsg="舒张压输入有误"  ignore="ignore" >mmhg</td>
                                   </tr>
                                   <tr>
                                      <td>收缩压</td> 
                                      <td><input type="text" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"  class="w40 temp" name="tgeneralcondition.systolicPressure" maxlength="5"  errormsg="收缩压输入有误"  ignore="ignore" >mmhg</td>
                                       <td>脉搏</td>
                                       <td><input type="text"  class="w40 temp" name="tgeneralcondition.pulseRate" maxlength="5"  errormsg="脉搏输入有误"  ignore="ignore" >次/分</td> 
                                        <td>身高</td>
                                       <td><input onkeyup="Num(this)" type="text"  class="w40 temp" id="shengao" name="tgeneralcondition.height" maxlength="5"    errormsg="身高输入有误"  ignore="ignore">cm</td> 
                                        <td>体重</td>
                                       <td><input onkeyup="Num(this)"  type="text"  class="w40 temp" id="tizhong" name="tgeneralcondition.weight" maxlength="5"   errormsg="体重输入有误"  ignore="ignore">kg</td> 
                                   </tr>
                                   <tr>
                                    <td>体质指数</td>
                                       <td>
                                      <!--   <input onkeyup="Num(this)" type="text"  class="w40 temp" id="tizhi" name="tgeneralcondition.bmi"  maxlength="4"  > -->
                                      <label id="tizhi"></label>
                                     </td>
                                       <td>腰围</td>
                                       <td><input type="text" onkeyup="Num(this)"  class="w40 temp" id="yaowei" name="tgeneralcondition.waistline" maxlength="5"   errormsg="腰围输入有误"  ignore="ignore">cm</td> 
                                        <td>臀围</td>
                                       <td><input type="text" onkeyup="Num(this)"  class="w40 temp" id="tunwei" name="tgeneralcondition.hip" maxlength="5"    errormsg="臀围输入有误"  ignore="ignore">cm</td> 
                                        <td>腰臀围比例</td>
                                       <td><!-- <input type="text" onkeyup="Num(this)"   class="w40 temp" id="tybi" name="tgeneralcondition.ratio" maxlength="5"  errormsg="臀腰围比例输入有误"  ignore="ignore"> -->
                                       		<label id="tybi"></label>
                                       </td> 
                                   </tr>
                                  <tr>
                                     <td>老人健康状况自我评估</td>
                                       <td colspan="3"><select id=""  name="tgeneralcondition.healthAssessment"> 
                                       <option value=" ">请选择</option>
                                       <s:iterator value="#auto.lnrjkList" var="jk">
                                        <option value="${jk.name}" >${jk.name}</option>
                                        </s:iterator>
                                       </select>
                                       </td>
                                       <td>老人生活自理能力自我评估</td>
                                       <td colspan="3"><select id=""  name="tgeneralcondition.selfAssessment" > 
                                         <option value=" ">请选择</option>
                                       <s:iterator value="#auto.lnrzlList" var="zl"> 
                                       <option value="${zl.name}">${zl.name}</option>
                                       </s:iterator>
                                       </select>
                                       </td>
                                  </tr>
                                   <tr>
                                     <td>老年人认知功能</td>
                                       <td colspan="3">
                                       <select  id="" name="tgeneralcondition.cognitiveFunction"> 
                                         <option value=" ">请选择</option>
                                        <s:iterator value="#auto.lnrrzList" var="rz"> 
                                       <option value="${rz.name}">${rz.name}</option>
                                       </s:iterator>
                                       </select>
                                       </td>
                                       <td>老年人情感状况</td>
                                       <td colspan="3">
                                       <select  id="" name="tgeneralcondition.emotion"> 
                                         <option value=" ">请选择</option>
                                       <s:iterator value="#auto.lnrqgList" var="qg"> 
                                       <option value="${qg.name}">${qg.name}</option>
                                       </s:iterator>
                                       </select>
                                       </td>
                                   </tr>
                                   <tr>
                                     <td colspan="8" class="title-td">生活方式</td>
                                   </tr>
                                   <tr>
                                     <td>体育锻炼频率</td>
                                       <td>
                                       		<select name="tlifestyle.exerciseFrequency" id="" >
                                       		 <option value=" ">请选择</option> 
                                       			<s:iterator value="#auto.tydlplList" var="ty"> 
                                      		 <option value="${ty.name}">${ty.name}</option>
                                       </s:iterator>
                                       		</select>
                                       </td>
                                       <td>每次锻炼时间</td>
                                       <td><input maxlength="5" type="text"  class="w40 temp"  name="tlifestyle.exerciseTime">min</td> 
                                       <td>坚持锻炼时间</td>
                                       <td><input maxlength="5" type="text"  class="w40 temp"  name="tlifestyle.allExerciseTime">min</td> 
                                       <td>锻炼方式</td>
                                       <td>
                                       		<select name="tlifestyle.exerciseType" id="">
                                        		<option value="">请选择</option> 
                                        		<s:iterator value="#auto.dlfsList" var="dl"> 
                                      		 <option value="${dl.name}">${dl.name}</option>
                                       </s:iterator>
                                       		</select>
                                       </td> 
                                   </tr>
                                   <tr>
                                     <td>饮食习惯</td>
                                       <td>
                                       		<select name="tlifestyle.dietaryHabit" id=""> 
                                       			<option value="">请选择</option> 
                                       			<s:iterator value="#auto.ysxgList" var="ys"> 
                                      		 <option value="${ys.name}">${ys.name}</option>
                                       </s:iterator>
                                       		</select>
                                       </td> 
                                       <td>吸烟状况</td>
                                       <td>	
                                      
                                       		<select name="tlifestyle.smokingStatus" id="somke"  onclick="javascript:somker(this);"> 
                                       			<option value="">请选择</option>
                                        		<s:iterator value="#auto.xyzkList" var="xy"> 
                                      		 <option value="${xy.name}">${xy.name}</option>
                                       </s:iterator>
                                       		</select>
                                       </td>
                                       <td>日吸烟量平均</td>
                                       <td><input maxlength="5" type="text"  class="w40 temp" id="somke1" name="tlifestyle.smokingOneday">根</td> 
                                       <td>开始吸烟年龄</td>
                                       <td><input maxlength="3" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text"  class="w40 temp" id="somke2" name="tlifestyle.startsmokingAge">岁</td>  
                                   </tr>
                                   <tr>
                                       <td>戒烟年龄</td>
                                       <td><input maxlength="3" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text"  class="w40 temp" id="somke3" name="tlifestyle.giveupSmokingAge">岁</td>
                                        <td>饮酒频率</td>
<!-- /////////////////////////////////////--------------------- -->
                                       <td>
                                       		<select name="tlifestyle.drinkingFrequency" id="a" onclick="javascript:doit(this);"> 
                                       			<option value="">请选择</option> 
                                       			<s:iterator value="#auto.yjplList" var="yj"> 
                                      		 		<option value="${yj.name}">${yj.name}</option>
                                      			 </s:iterator>
                                       		</select>
                                       </td>
                                       <td>日饮酒量</td>
                                       <td><input maxlength="5" type="text" id="b"  class="w40 temp" name="tlifestyle.monthlyDrinking">两</td>
                                        <td>是否戒酒</td>
                                       <td>	
                                       		<select name="tlifestyle.abstinence" id="c"> 
                                       			<option value="">请选择</option> 
                                       			<option value="是">是</option>
                                       			<option value="否">否</option>
                                       		</select>
                                       </td>
                                   </tr>
                                   <tr>
                                     <td>开始饮酒年龄</td>
                                       <td><input maxlength="3" id="d" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"  type="text"  class="w40 temp" name="tlifestyle.startDrinkingAge">岁</td>
                                        <td>近一年内是否曾醉酒</td>
                                       <td><select name="tlifestyle.recentlyYearDrinking" id="e"> 
                                       <option value="false">否</option>
                                       <option value="true">是</option>
                                       </select>
                                       </td>
                                        <td>饮酒种类</td>
                                       <td colspan="2"><select name="tlifestyle.drinkingType" id="f"> 
                                       <option value="">请选择</option>
                                       <s:iterator value="#auto.yjzlList" var="yz"> 
                                      		 <option value="${yz.name}">${yz.name}</option>
                                       </s:iterator>
                                       </select>
                                       </td>
                                   </tr>
                                   
                                   <tr>
                                       <td>职业病危害因素接触史</td>
                                       <td colspan="2">
                                            <div class="jia">
                                                <select     class="di">
                                                  <option value="有:具体职业()从业()年">有:具体职业()从业()年</option>
                                                  <option value="无"  selected="selected">无</option>
                                                </select>
                                                <input maxlength="30" type="text"  class="gai"  name="tlifestyle.occupationalDisease">
                                            </div>
                                       </td>
                                       <td>毒物种类</td>
                                       <td><input maxlength="20"  type="text"  class="w40 temp" name="tlifestyle.dust"></td>
                                        <td>防护措施</td>
                                       <td colspan="2">
                                           <div class="jia">
                                                <select     class="di">
                                                  <option value="有:">有:</option>
                                                  <option value="无" selected="selected">无</option>
                                                </select>
                                                <input maxlength="30"  type="text"  class="gai"   name="tlifestyle.dustFence">
                                            </div>
                                       </td>
                                   </tr>
                                   <tr>
                                       <td>放射物质</td>
                                       <td><input maxlength="20" type="text"  class="w40 temp" name="tlifestyle.radiogen"></td>
                                        <td>防护措施</td>
                                       <td>
                                       <div class="jia">
                                                <select     class="di">
                                                  <option value="有:">有:</option>
                                                  <option value="无" selected="selected">无</option>
                                                </select>
                                                <input maxlength="30"  type="text"  class="gai"   name="tlifestyle.radiogenFence">
                                            </div>
                                       </td>
                                       <td>物理因素</td>
                                       <td><input maxlength="20" type="text"  class="w40 temp" name="tlifestyle.physicalFactor"></td>
                                        <td>防护措施</td>
                                        <td>
                                        <div class="jia">
                                                <select     class="di">
                                                  <option value="有:">有:</option>
                                                  <option value="无" selected="selected">无</option>
                                                </select>
                                                <input maxlength="30"  type="text"  class="gai"   name="tlifestyle.physicalFactorFence">
                                            </div>
                                       </td>
                                   </tr>
                                   <tr>
                                       <td>化学物质</td>
                                       <td><input maxlength="20" type="text"  class="w40 temp" name="tlifestyle.chemicalSubstances"></td>
                                        <td>防护措施</td>
                                       <td>
                                        <div class="jia">
                                                <select     class="di">
                                                  <option value="有:">有:</option>
                                                  <option value="无" selected="selected">无</option>
                                                </select>
                                                <input maxlength="30" type="text"  class="gai"   name="tlifestyle.chSubFence">
                                            </div>
                                       </td>
                                       <td>其他</td>
                                       <td><input maxlength="30" type="text"  class="w40 temp" name="tlifestyle.other"></td>
                                        <td>防护措施</td>
                                       <td> 
                                       <div class="jia">
                                                <select     class="di">
                                                  <option value="有:">有:</option>
                                                  <option value="无" selected="selected">无</option>
                                                </select>
                                                <input maxlength="30" type="text"  class="gai"   name="tlifestyle.otherFence">
                                            </div>
                                       </td>
                                   </tr>
                                   <tr>
                                     <td colspan="8" class="title-td">脏器功能</td>
                                   </tr>
                                   <tr>
                                     <td>口腔口齿</td>
                                       <td><select name="torganfunction.oralLip" id="">
                                        <option value=""> 请选择</option> 
                                        <s:iterator value="#auto.kqkcList" var="kqkc">
                                        <option value="${kqkc.name}">${kqkc.name}</option>
                                        </s:iterator>
                                       </select>
                                       </td>
                                       <td>齿列</td>
                                       <td><select name="torganfunction.dentition" id=""> 
                                     <!--   <option value=""> </option>  -->
                                       <s:iterator value="#auto.clList" var="cl">
                                        <option value="${cl.name}">${cl.name}</option>
                                        </s:iterator>
                                       </select>
                                       </td>
                                       <td>咽部</td>
                                       <td colspan="3" ><select name="torganfunction.pharynx" id=""> 
                                       <option value=" ">请选择</option> 
                                       <s:iterator value="#auto.ybList" var="yb">
                                        <option value="${yb.name}">${yb.name}</option>
                                        </s:iterator>
                                       </select>
                                       </td>
                                   </tr>
                                   <tr>
                                      <td>视力左眼</td>
                                       <td><input maxlength="10" type="text"  class="w40 temp" name="torganfunction.visionLeftEye"></td>
                                        <td>视力右眼</td>
                                       <td><input maxlength="10" type="text"  class="w40 temp" name="torganfunction.visionRightEye"></td>
                                        <td>矫正视力(左眼)</td>
                                       <td><input maxlength="10" type="text"  class="w40 temp" name="torganfunction.correctedVisionLeftEye"></td>
                                        <td>矫正视力(右眼)</td>
                                       <td><input maxlength="10" type="text"  class="w40 temp" name="torganfunction.correctedVisionRightEye"></td>
                                   </tr>
                                    <tr>
                                     <td>听力</td>
                                       <td colspan="3"><select name="torganfunction.hearing" id=""> 
                                       <option value="">请选择</option> 
                                       <s:iterator value="#auto.tlList" var="tl">
                                        <option value="${tl.name}">${tl.name}</option>
                                        </s:iterator>
                                       </select>
                                       </td>
                                       <td>运动功能</td>
                                       <td colspan="3"><select name="torganfunction.motorFunction" id="">
                                        <option value="">请选择 </option>
                                         <s:iterator value="#auto.ydgnList" var="ydgn">
                                        <option value="${ydgn.name}">${ydgn.name}</option>
                                        </s:iterator>
                                       </select>
                                       </td>
                                   </tr>
                                   <tr>
                                     <td colspan="8" class="title-td">查体</td>
                                   </tr>
                                   <tr>
                                       <td>皮肤</td>
                                       <td><select name="tcheck.skin" id=""> 
                                       <option value="">请选择 </option> 
                                      <s:iterator value="#auto.pfList" var="pf">
                                        <option value="${pf.name}">${pf.name}</option>
                                        </s:iterator>
                                       </select>
                                       </td>
                                       <td>巩膜</td>
                                       <td><select name="tcheck.sclera" id=""> 
                                       <option value="">请选择 </option>
                                       <s:iterator value="#auto.gmList" var="gm">
                                        <option value="${gm.name}">${gm.name}</option>
                                        </s:iterator>
                                       </select>
                                       </td>
                                       <td>淋巴结</td>
                                       <td ><select name="tcheck.lymphNode" id=""> 
                                       <option value="">请选择</option> 
                                      <s:iterator value="#auto.lbjList" var="lbj">
                                        <option value="${lbj.name}">${lbj.name}</option>
                                        </s:iterator>
                                       </select>
                                       </td>
                                       <td>肺：桶状胸</td>
                                       <td>
                                            <div class="jia">
                                                <select     class="di">
                                                  <option value="有:">有:</option>
                                                  <option value="无" selected="selected">无</option>
                                                </select>
                                                <input maxlength="30" type="text"  class="gai"   name="tcheck.barrelChest">
                                            </div>
                                       </td>
                                    </tr>
                                    <tr>
                                       <td>呼吸音</td>
                                       <td>
                                          <div class="jia">
                                            <select     class="di">
                                              <option value="有:">有:</option>
                                              <option value="无" selected="selected">无</option>
                                            </select>
                                            <input maxlength="30" type="text"  class="gai"   name="tcheck.breathSounds">
                                          </div>
                                       </td>
                                        <td>罗音</td>
                                       <td><select name="tcheck.rale" id=""> 
                                       <option value=" "> 请选择</option>
                                       <s:iterator value="#auto.lyList" var="ly">
                                        <option value="${ly.name}">${ly.name}</option>
                                        </s:iterator>
                                       </select>
                                       </td>
                                       <td>心率</td>
                                       <td><input maxlength="5"  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text"  class="w40 temp" name="tcheck.heartRate">次/分</td>
                                        <td>心律</td>
                                       <td>
                                          <div class="jia">
                                            <select     class="di">
                                              <option value="有:">有:</option>
                                              <option value="无" selected="selected">无</option>
                                            </select>
                                            <input maxlength="30" type="text"  class="gai"   name="tcheck.rhythmOfTheHeart">
                                          </div>
                                       <!-- <select name="tcheck.rhythmOfTheHeart" id=""> 
                                       <option value="">请选择</option> 
                                       <option value="良好">良好</option>
                                       </select> -->
                                       </td>
                                    </tr>
                                    <tr>
                                       <td>心脏杂音</td>
                                       <td>
                                        <div class="jia">
                                                <select     class="di">
                                                  <option value="有:">有:</option>
                                                  <option value="无" selected="selected">无</option>
                                                </select>
                                                <input maxlength="30" type="text"  class="gai"   name="tcheck.noise">
                                            </div>
                                       </td>
                                        <td>腹部：压痛</td>
                                       <td>
                                           <div class="jia">
                                            <select     class="di">
                                              <option value="有:">有:</option>
                                              <option value="无" selected="selected">无</option>
                                            </select>
                                            <input maxlength="30"  type="text"  class="gai"   name="tcheck.tenderness">
                                           </div>
                                       <!-- <select name="tcheck.tenderness" id=""> 
                                       <option value="">请选择</option> 
                                       <option value="良好">良好</option>
                                       </select> -->
                                       </td>
                                        <td>包块</td>
                                       <td>
                                          <div class="jia">
                                            <select     class="di">
                                              <option value="有:">有:</option>
                                              <option value="无" selected="selected">无</option>
                                            </select>
                                            <input maxlength="30" type="text"  class="gai"  name="tcheck.masses">
                                          </div>
                                       <!-- <select name="tcheck.masses" id=""> 
                                       <option value="">请选择</option>
                                        <option value="良好">良好</option>
                                       </select> -->
                                       </td>
                                        <td>肝大</td>
                                       <td>
                                          <div class="jia">
                                            <select     class="di">
                                              <option value="有:">有:</option>
                                              <option value="无" selected="selected">无</option>
                                            </select>
                                            <input maxlength="30" type="text"  class="gai"  name="tcheck.hepatomegaly">
                                          </div>
                                       <!-- <select name="tcheck.hepatomegaly" id="">
                                        <option value="">请选择</option> 
                                        <option value="良好">良好</option>
                                       </select> -->
                                       </td>
                                    </tr>
                                     <tr>
                                       <td>脾大</td>
                                       <td>
                                          <div class="jia">
                                            <select     class="di">
                                              <option value="有:">有:</option>
                                              <option value="无" selected="selected">无</option>
                                            </select>
                                            <input maxlength="30" type="text"  class="gai"   name="tcheck.splenomegaly">
                                          </div>
                                       </td>
                                        <td>移动性浊音</td>
                                       <td>
                                          <div class="jia">
                                            <select     class="di">
                                              <option value="有:">有:</option>
                                              <option value="无" selected="selected">无</option>
                                            </select>
                                            <input maxlength="30" type="text"  class="gai"  name="tcheck.shiftingDullness">
                                          </div>
                                       </td>
                                        <td>下肢水肿</td>
                                       <td><select name="tcheck.lowerExtremityEdema" id=""> 
                                       <option value="">请选择</option> 
                                        <s:iterator value="#auto.xzszList" var="xzsz">
                                        <option value="${xzsz.name}">${xzsz.name}</option>
                                        </s:iterator>
                                       </select>
                                       </td>
                                        <td>足背动脉搏动</td>
                                       <td><select name="tcheck.dorsalisPedisPulse" id=""> 
                                       <option value="">请选择</option> 
                                        <s:iterator value="#auto.zbdmbdList" var="zbdmbd">
                                        <option value="${zbdmbd.name}">${zbdmbd.name}</option>
                                        </s:iterator>
                                       </select>
                                       </td>
                                    </tr>
                                    <tr>
                                       <td>肛门指诊</td>
                                       <td><select name="tcheck.theAnusDre" id="">
                                        <option value="">请选择</option> 
                                          <s:iterator value="#auto.gmzzList" var="gmzz">
                                        <option value="${gmzz.name}">${gmzz.name}</option>
                                        </s:iterator>
                                       </select>
                                       </td>
                                        <td>眼底</td>
                                       <td>
                                          <div class="jia">
                                            <select     class="di">
                                              <option value="有:">有:</option>
                                              <option value="无" selected="selected">无</option>
                                            </select>
                                            <input maxlength="30" type="text"  class="gai"  name="tcheck.fundus">
                                          </div>
                                       <!-- <select name="tcheck.fundus" id=""> 
                                       <option value="">请选择</option>
                                        <option value="良好">良好</option>
                                       </select> -->
                                       </td>
                                        <td>乳腺</td>
                                       <td><select name="tcheck.mammaryGland" id=""> 
                                       <option value=" ">请选择</option> 
                                        <s:iterator value="#auto.lxList" var="lx">
                                        <option value="${lx.name}">${lx.name}</option>
                                        </s:iterator>
                                       </select>
                                       </td>
                                        <td>妇科外阴</td>
                                       <td>
                                          <div class="jia">
                                            <select     class="di">
                                              <option value="有:">有:</option>
                                              <option value="无" selected="selected">无</option>
                                            </select>
                                            <input maxlength="30" type="text"  class="gai"   name="tcheck.vulva">
                                          </div>
                                      <!--  <select name="tcheck.vulva" id=""> 
                                       <option value="">请选择</option> 
                                       <option value="良好">良好</option>
                                       </select> -->
                                       </td>
                                    </tr>
                                    
                                     <tr>
                                       <td>阴道</td>
                                       <td>
                                          <div class="jia">
                                            <select     class="di">
                                              <option value="有:">有:</option>
                                              <option value="无" selected="selected">无</option>
                                            </select>
                                            <input maxlength="30" type="text"  class="gai"  " name="tcheck.vagina">
                                          </div>
                                      <!--  <select name="tcheck.vagina" id=""> 
                                       <option value="">请选择</option> 
                                       <option value="良好">良好</option>
                                       </select> -->
                                       </td>
                                        <td>宫颈</td>
                                       <td>
                                          <div class="jia">
                                            <select     class="di">
                                              <option value="有:">有:</option>
                                              <option value="无" selected="selected">无</option>
                                            </select>
                                            <input maxlength="30" type="text"  class="gai"   name="tcheck.cervix">
                                          </div>
                                         <!-- <select name="tcheck.cervix" id=""> 
                                         <option value="">请选择</option> 
                                         <option value="良好">良好</option>
                                         </select> -->
                                       </td>
                                        <td>宫体</td>
                                       <td>
                                          <div class="jia">
                                            <select     class="di">
                                              <option value="有:">有:</option>
                                              <option value="无" selected="selected">无</option>
                                            </select>
                                            <input maxlength="30" type="text"  class="gai"   name="tcheck.corpus">
                                          </div>
                                         <!-- <select name="tcheck.corpus" id="">
                                          <option value="">请选择</option> 
                                          <option value="良好">良好</option>
                                         </select> -->
                                       </td>
                                        <td>附件</td>
                                       <td>
                                          <div class="jia">
                                            <select     class="di">
                                              <option value="有:">有:</option>
                                              <option value="无" selected="selected">无</option>
                                            </select>
                                            <input maxlength="30" type="text"  class="gai"   name="tcheck.attachment">
                                          </div>
                                       <!-- <select name="tcheck.attachment" id=""> 
                                       <option value="">请选择</option> 
                                       <option value="良好">良好</option>
                                       </select> -->
                                       </td>
                                    </tr>
                                    <tr>
                                       <td>其他</td>
                                       <td colspan="7"><input maxlength="30" type="text"  class="w40 temp" name="tcheck.others"></td>
                                    </tr>
                                     <tr>
                                     <td colspan="8" class="title-td">辅助检查</td>
                                   </tr>
                                   <tr>
                                     <td>空腹血糖</td>
                                       <td><input maxlength="6" type="text"  class="w40 temp" name="tauxiliaryexamination.fbg">mmol/L</td>
                                       <td>糖化血红蛋白</td>
                                       <td><input maxlength="6" type="text"  class="w40 temp" name="tauxiliaryexamination.glycatedHemoglobin">%</td>
                                       <td>乙型肝炎表面抗原</td>
                                       <td colspan="3">
                                          <div class="jia">
                                            <select     class="di">
                                              <option value="有:">有:</option>
                                              <option value="无" selected="selected">无</option>
                                            </select>
                                            <input maxlength="30" type="text"  class="gai" name="tauxiliaryexamination.hbsag">
                                          </div>
                                       <!-- <select name="tauxiliaryexamination.hbsag" id=""> <option value="">请选择</option> <option value="">项目1</option>
                                       </select> -->
                                       </td>
                                   </tr>
                                   <tr>
                                     <td>血常规</td>
                                       <td colspan="7"></td>
                                   </tr>
                                   <tr>
                                       <td>血红蛋白</td>
                                       <td><input maxlength="6" type="text"  class="w40 temp" name="tauxiliaryexamination.hemoglobin">g/L</td>
                                       <td>白细胞</td>
                                       <td><input maxlength="6" type="text"  class="w40 temp" name="tauxiliaryexamination.leukocyte">g/L</td>
                                       <td>血小板</td>
                                       <td><input maxlength="6" type="text"  class="w40 temp" name="tauxiliaryexamination.platelet">g/L</td>
                                   </tr>
                                   <tr>
                                     <td>其他</td>
                                       <td colspan="7"><input maxlength="30" type="text"  class="w40 temp" name="tauxiliaryexamination.othersRb"></td>
                                   </tr>
                                    <tr>
                                     <td>尿常规</td>
                                       <td colspan="7"></td>
                                   </tr>
                                   <tr>
                                       <td>尿蛋白</td>
                                       <td><input maxlength="6" type="text"  class="w40 temp" name="tauxiliaryexamination.urineProtein" ></td>
                                       <td>尿糖</td>
                                       <td><input maxlength="6" type="text"  class="w40 temp" name="tauxiliaryexamination.urineGlucose"></td>
                                       <td>尿酮体</td>
                                       <td><input maxlength="6" type="text"  class="w40 temp" name="tauxiliaryexamination.ketone"></td>
                                       <td>尿潜血</td>
                                       <td><input maxlength="6" type="text"  class="w40 temp" name="tauxiliaryexamination.ery">mg/dL</td>
                                   </tr>

									<tr>
                                   <td>其他</td>
                                       <td colspan="7"><input maxlength="3" type="text"  class="w40 temp" name="tauxiliaryexamination.othersRu" ></td>
                                   </tr>
                                   <tr>
                                   <td>尿微量白蛋白</td>
                                       <td colspan="3"><input maxlength="6" type="text"  class="w40 temp" name="tauxiliaryexamination.mau">mg/dL</td>
                                   
                                     <td>大便潜血</td>
                                       <td colspan="3">
                                          <div class="jia">
                                            <select    name="tauxiliaryexamination.sedOccultBlood">
                                              <option value="false">无</option>
                                              <option value="true">有</option>
                                            </select>
                                          </div>
                                       <!-- <select name="tauxiliaryexamination.sedOccultBlood" id=""> <option value="">请选择</option> 
                                       <option value="0">阴</option>
                                       <option value="1">阳</option>
                                       </select> -->
                                       </td> 
                                 </tr>
                                 <tr>
                                     <td> 肝功能</td>
                                       <td colspan="7"> </td>
                                   </tr>
                                   <tr>
                                     <td>血清谷丙转氨酸</td>
                                       <td><input maxlength="6" type="text"  class="w40 temp" name="tauxiliaryexamination.serumAlanineAminoAcid">U/L</td>
                                       <td>血清谷草转氨酸</td>
                                       <td><input maxlength="6" type="text"  class="w40 temp" name="tauxiliaryexamination.serumAspertateAminoAcid">U/L</td>
                                       <td>白蛋白</td> 
                                       <td><input maxlength="6" type="text"  class="w40 temp" name="tauxiliaryexamination.albumin">g/L</td>
                                       <td>总胆红素</td>
                                       <td><input maxlength="6" type="text"  class="w40 temp" name="tauxiliaryexamination.tbil">umol/L</td>
                                   </tr>
                                   <tr>
                                      <td>结合胆红素</td>
                                       <td><input maxlength="6" type="text"  class="w40 temp" name="tauxiliaryexamination.dbil">umol/L</td>
                                   </tr>
                                   <tr>
                                   <td>肾功能</td>
                                       <td colspan="7"> </td>
                                   </tr>
                                   <tr>
                                     <td>血清肌酐</td>
                                       <td><input maxlength="6" type="text"  class="w40 temp" name="tauxiliaryexamination.cr">mmol/L</td>
                                       <td>血尿素氨</td>
                                       <td><input maxlength="6" type="text"  class="w40 temp" name="tauxiliaryexamination.bun">mmol/L</td>
                                       <td>血钾浓度</td>
                                       <td><input maxlength="6" type="text"  class="w40 temp" name="tauxiliaryexamination.serumPotassiumLevel">mmol/L</td>
                                       <td>血钠浓度</td>
                                       <td><input maxlength="6" type="text"  class="w40 temp" name="tauxiliaryexamination.serumNatriumLevel">mmol/L</td>
                                   </tr>
                                   
                                    <tr>
                                   <td>血脂</td>
                                       <td colspan="7">  </td>
                                   </tr>
                                   <tr>
                                       <td>总胆固醇</td>
                                       <td><input maxlength="6" type="text"  class="w40 temp" name="tauxiliaryexamination.totalCholesterol">mmol/L</td>
                                       <td>血清低密度蛋白胆固醇</td>
                                       <td><input maxlength="6" type="text"  class="w40 temp" name="tauxiliaryexamination.ldlC">mmol/L</td>
                                       <td>甘油三酯</td>
                                       <td><input maxlength="6" type="text"  class="w40 temp" name="tauxiliaryexamination.triglyceride">mmol/L</td>
                                       <td>血清高密度脂蛋白胆固醇</td>
                                       <td><input maxlength="6" type="text"  class="w40 temp" name="tauxiliaryexamination.hdlC">mmol/L</td>
                                   </tr>
                                   <tr>
                                     <td>宫颈涂片</td>
                                       
                                       <td>
                                          <div class="jia">
                                            <select     class="di">
                                              <option value="有:">有:</option>
                                              <option value="无" selected="selected">无</option>
                                            </select>
                                            <input maxlength="30" type="text"  class="gai" name="tauxiliaryexamination.papSmear">
                                          </div>
                                       </td>
                                       
                                       <%-- <td>
                                          <div class="jia">
                                            <select     class="di">
                                              <option value="有:">有:</option>
                                              <option value="无" selected="selected">无</option>
                                            </select>
                                            <input maxlength="30" type="text"  class="gai" name="tauxiliaryexamination.papSmear">
                                          </div> --%>
                                      <!--  <select name="tauxiliaryexamination.papSmear" id=""> <option value="">请选择</option> <option value="">项目1</option>
                                       </select> -->
                                       <td>心电图</td>
                                       <td>
                                          <div class="jia">
                                            <select     class="di">
                                              <option value="有:">有:</option>
                                              <option value="无" selected="selected">无</option>
                                            </select>
                                            <input maxlength="30" type="text"  class="gai"  name="tauxiliaryexamination.ecg">
                                          </div>
                                       <!-- <select name="tauxiliaryexamination.ecg" id=""> <option value="">请选择</option> <option value="">项目1</option>
                                       </select> -->
                                       </td>
                                       <td>胸部X线片</td>
                                       <td>
                                            <div class="jia">
                                              <select     class="di">
                                                <option value="有:">有:</option>
                                                <option value="无" selected="selected">无</option>
                                              </select>
                                              <input maxlength="30"  type="text"  class="gai"   name="tauxiliaryexamination.chestXRay">
                                            </div>
                                       <!-- <select name="tauxiliaryexamination.chestXRay" id=""> <option value="">请选择</option> <option value="">项目1</option>
                                       </select> -->
                                       </td>
                                       <td>B超</td>
                                       <td>
                                            <div class="jia">
                                              <select     class="di">
                                                <option value="有:">有:</option>
                                                <option value="无" selected="selected">无</option>
                                              </select>
                                              <input maxlength="30" type="text"  class="gai"  name="tauxiliaryexamination.BScanUltrasonography">
                                            </div>
                                       <!-- <select name="tauxiliaryexamination.BScanUltrasonography" id=""> <option value="">请选择</option> <option value="">项目1</option>
                                       </select> -->
                                       </td>
                                   </tr>
                                
                                    <tr>
                                   <td>其他</td>
                                       <td colspan="7"><input maxlength="30" type="text"  class="w40 temp" name="tauxiliaryexamination.others" ></td>
                                   </tr>
                                     <tr>
                                     <td colspan="8" class="title-td">中医体辨识</td>
                                   </tr>
                                  
                                   <tr>
                                     <td>1、平和质</td>
                                       <td colspan="3">
                                          <div class="jia">
                                            <select     class="di">
                                              <option value="有:">有:</option>
                                                <option value="无" selected="selected">无</option>
                                            </select>
                                            <input maxlength="30" type="text"  class="gai" name="tchinamedicine.deficiency">
                                          </div>
                                      
                                       </td>
                                       <td>指导意见</td>
                                       <td colspan="3">
                                          <div class="jia">
                                            <select     class="di">
                                             <option value="无" selected="selected">无</option>
                                               <s:iterator value="#auto.phzList" var="phz">
                                      			  <option value="${phz.name}">${phz.name}</option>
                                       			 </s:iterator>
                                             
                                            </select>
                                            <input maxlength="30"  type="text"  class="gai" name="tchinamedicine.deficiencyGuidance">
                                          </div>
                                       </td>
                                   </tr>
                                   <tr>
                                     <td>2、气虚质</td>
                                       <td colspan="3">
                                          <div class="jia">
                                            <select     class="di">
                                              <option value="有:">有:</option>
                                              <option value="无" selected="selected">无</option>
                                            </select>
                                            <input maxlength="30" type="text"  class="gai"  name="tchinamedicine.qiDeficiency">
                                          </div>
                                        
                                       </td>
                                       <td>指导意见</td>
                                       <td colspan="3">
                                            <div class="jia">
                                              <select     class="di">
                                                <option value="无" selected="selected">无</option>
                                                <s:iterator value="#auto.qxzList" var="qxz">
                                      			  <option value="${qxz.name}">${qxz.name}</option>
                                       			 </s:iterator>
                                              </select>
                                              <input maxlength="30" type="text"  class="gai"  name="tchinamedicine.qiDeficiencyGuidance">
                                            </div>
                                       <!-- <select name="tchinamedicine.qiDeficiencyGuidance" id=""> <option value="">请选择</option> <option value="">项目1</option>
                                       </select> -->
                                       </td>
                                   </tr>
                                   <tr>
                                     <td>3、阳虚质</td>
                                       <td colspan="3">
                                            <div class="jia">
                                              <select     class="di">
                                                <option value="有:">有:</option>
                                                <option value="无" selected="selected">无</option>
                                              </select>
                                              <input maxlength="30" type="text"  class="gai"   name="tchinamedicine.yangDeficiency" >
                                            </div>
                                       <!-- <select name="tchinamedicine.yangDeficiency" id=""> <option value="">请选择</option> <option value="">项目1</option>
                                       </select> -->
                                       </td>
                                       <td>指导意见</td>
                                       <td colspan="3">
                                          <div class="jia">
                                            <select     class="di">
                                              <option value="无" selected="selected">无</option>
                                              <s:iterator value="#auto.yangxzList" var="yangxz">
                                      			  <option value="${yangxz.name}">${yangxz.name}</option>
                                       			 </s:iterator>
                                            </select>
                                            <input maxlength="30" type="text"  class="gai"  name="tchinamedicine.yangDeficiencyGuidance">
                                          </div>
                                       <!-- <select name="tchinamedicine.yangDeficiencyGuidance" id=""> <option value="">请选择</option> <option value="">项目1</option>
                                       </select> -->
                                       </td>
                                   </tr>
                                   <tr>
                                     <td>4、阴虚质</td>
                                       <td colspan="3">
                                          <div class="jia">
                                            <select     class="di">
                                              <option value="有:">有:</option>
                                              <option value="无" selected="selected">无</option>
                                            </select>
                                            <input maxlength="30" type="text"  class="gai" name="tchinamedicine.yingDecifiency" >
                                          </div>
                                       <!-- <select name="tchinamedicine.yingDecifiency" id=""> <option value="">请选择</option> <option value="">项目1</option>
                                       </select> -->
                                       </td>
                                       <td>指导意见</td>
                                       <td colspan="3">
                                            <div class="jia">
                                              <select     class="di">
                                                <option value="无" selected="selected">无</option>
                                                <s:iterator value="#auto.yinxzList" var="yinxz">
                                      			  <option value="${yinxz.name}">${yinxz.name}</option>
                                       			 </s:iterator>
                                              </select>
                                              <input maxlength="30" type="text"  class="gai"  name="tchinamedicine.yingDecifiencyGuidance">
                                            </div>
                                       <!-- <select name="tchinamedicine.yingDecifiencyGuidance" id=""> <option value="">请选择</option> <option value="">项目1</option>
                                       </select> -->
                                       </td>
                                   </tr>
                                   <tr>
                                     <td>5、痰湿质</td>
                                       <td colspan="3">
                                            <div class="jia">
                                              <select     class="di">
                                                <option value="有:">有:</option>
                                                <option value="无" selected="selected">无</option>
                                              </select>
                                              <input maxlength="30" type="text"  class="gai"  name="tchinamedicine.phlegmDampness" >
                                            </div>
                                       <!-- <select name="tchinamedicine.phlegmDampness" id=""> <option value="">请选择</option> <option value="">项目1</option>
                                       </select> -->
                                       </td>
                                       <td>指导意见</td>
                                       <td colspan="3">
                                            <div class="jia">
                                              <select     class="di">
                                                <option value="无" selected="selected">无</option>
                                                <s:iterator value="#auto.tszList" var="tsz">
                                      			  <option value="${tsz.name}">${tsz.name}</option>
                                       			 </s:iterator>
                                              </select>
                                              <input maxlength="30" type="text"  class="gai"  name="tchinamedicine.phlegmDampnessGuidance">
                                            </div>
                                       <!-- <select name="tchinamedicine.phlegmDampnessGuidance" id=""> <option value="">请选择</option> <option value="">项目1</option>
                                       </select> -->
                                       </td>
                                   </tr>
                                   <tr>
                                     <td>6、湿热质</td>
                                       <td colspan="3">
                                            <div class="jia">
                                              <select     class="di">
                                                <option value="有:">有:</option>
                                                <option value="无" selected="selected">无</option>
                                              </select>
                                              <input maxlength="30" type="text"  class="gai"   name="tchinamedicine.dampHeatConstitution">
                                            </div>
                                       <!-- <select name="tchinamedicine.dampHeatConstitution" id=""> <option value="">请选择</option> <option value="">项目1</option>
                                       </select> -->
                                       </td>
                                       <td>指导意见</td>
                                       <td colspan="3">
                                            <div class="jia">
                                              <select     class="di">
                                                <option value="无" selected="selected">无</option>
                                                <s:iterator value="#auto.srzList" var="srz">
                                      			  <option value="${srz.name}">${srz.name}</option>
                                       			 </s:iterator>
                                              </select>
                                              <input maxlength="30" type="text"  class="gai"  name="tchinamedicine.dampHeatConstitutionGuidance">
                                            </div>
                                       <!-- <select name="tchinamedicine.dampHeatConstitutionGuidance" id=""> <option value="">请选择</option> <option value="">项目1</option>
                                       </select> -->
                                       </td>
                                   </tr>
                                   <tr>
                                     <td>7、血瘀质</td>
                                       <td colspan="3">
                                          <div class="jia">
                                            <select     class="di">
                                              <option value="有:">有:</option>
                                              <option value="无" selected="selected">无</option>
                                            </select>
                                            <input maxlength="30"  type="text"  class="gai"   name="tchinamedicine.bloodySputum" >
                                          </div>
                                       <!-- <select name="tchinamedicine.bloodySputum" id=""> <option value="">请选择</option> <option value="">项目1</option>
                                       </select> -->
                                       </td>
                                       <td>指导意见</td>
                                       <td colspan="3">
                                                <div class="jia">
                                                  <select     class="di">
                                                    <option value="无" selected="selected">无</option>
                                                    <s:iterator value="#auto.xyzList" var="xyz">
                                      			  <option value="${xyz.name}">${xyz.name}</option>
                                       			 </s:iterator>
                                                  </select>
                                                  <input maxlength="30" type="text"  class="gai"  name="tchinamedicine.bloodySputumGuidance">
                                                </div>

                                       <!-- <select name="tchinamedicine.bloodySputumGuidance" id=""> <option value="">请选择</option> <option value="">项目1</option>
                                       </select> -->
                                       </td>
                                   </tr>
                                   <tr>
                                     <td>8、气郁质</td>
                                       <td colspan="3">
                                            <div class="jia">
                                              <select     class="di">
                                                <option value="有:">有:</option>
                                                <option value="无" selected="selected">无</option>
                                              </select>
                                              <input maxlength="30" type="text"  class="gai" name="tchinamedicine.qiStagnation">
                                            </div>
                                       <!-- <select name="tchinamedicine.qiStagnation" id=""> <option value="">请选择</option> <option value="">项目1</option>
                                       </select> -->
                                       </td>
                                       <td>指导意见</td>
                                       <td colspan="3">
                                            <div class="jia">
                                              <select     class="di">
                                                <option value="无" selected="selected">无</option>
                                                <s:iterator value="#auto.qyzList" var="qyz">
                                      			  <option value="${qyz.name}">${qyz.name}</option>
                                       			 </s:iterator>
                                              </select>
                                              <input maxlength="30" type="text"  class="gai"  name="tchinamedicine.qiStagnationGuidance">
                                            </div>
                                       <!-- <select name="tchinamedicine.qiStagnationGuidance" id=""> <option value="">请选择</option> <option value="">项目1</option>
                                       </select> -->
                                       </td>
                                   </tr>
                                    <tr>
                                     <td>9、特禀质</td>
                                       <td colspan="3">
                                          <div class="jia">
                                            <select     class="di">
                                              <option value="有:">有:</option>
                                              <option value="无" selected="selected">无</option>
                                            </select>
                                            <input maxlength="30" type="text"  class="gai"   name="tchinamedicine.grasp" >
                                          </div>
                                       <!-- <select name="tchinamedicine.grasp" id=""> <option value="">请选择</option> <option value="">项目1</option>
                                       </select> -->
                                       </td>
                                       <td>指导意见</td>
                                       <td colspan="3">
                                            <div class="jia">
                                              <select     class="di">
                                                <option value="无" selected="selected">无</option>
                                                <s:iterator value="#auto.tbzList" var="tbz">
                                      			  <option value="${tbz.name}">${tbz.name}</option>
                                       			 </s:iterator>
                                              </select>
                                              <input maxlength="30" type="text"  class="gai"   name="tchinamedicine.graspGuidance">
                                            </div>
                                       <!-- <select name="tchinamedicine.graspGuidance" id=""> <option value="">请选择</option> <option value="">项目1</option>
                                       </select> -->
                                       </td>
                                   </tr>
                                   <tr>
                                       <td colspan="8" class="title-td">现存主要健康问题</td>
                                       </tr>
                                       <tr>
                                       <td>脑血管疾病</td>
                                       <td colspan="3">
                                       <select name="thealthexting.cerebrovascularDisease" id=""> 
                                       <option value="">请选择</option> 
                                        <s:iterator value="#auto.nxgjbList" var="nxgjb">
                                        <option value="${nxgjb.name}">${nxgjb.name}</option>
                                        </s:iterator>
                                       </select>
                                       </td>
                                       <td>眼部疾病</td>
                                       <td colspan="3">
                                       <select name="thealthexting.ophthalmicDiseases" id=""> 
                                       <option value="">请选择</option> 
                                       <s:iterator value="#auto.ybjbList" var="ybjb">
                                        <option value="${ybjb.name}">${ybjb.name}</option>
                                        </s:iterator>
                                       </select>
                                       </td>
                                   </tr>
                                    <tr>
                                         <td>肾脏疾病</td>
                                       <td colspan="3">
                                       <select name="thealthexting.kidneyDisease" id=""> 
                                       <option value="">请选择</option> 
                                      <s:iterator value="#auto.szjbList" var="szjb">
                                        <option value="${szjb.name}">${szjb.name}</option>
                                        </s:iterator>
                                       </select>
                                       </td>
                                        <td>血管疾病</td>
                                       <td colspan="3">
                                       <select name="thealthexting.vascularDisease" id=""> 
                                       <option value="">请选择</option>
                                        <s:iterator value="#auto.xgjbList" var="xgjb">
                                        <option value="${xgjb.name}">${xgjb.name}</option>
                                        </s:iterator>
                                       </select>
                                       </td>
                                   </tr>
                                    <tr>
                                         <td>心脏疾病</td>
                                       <td colspan="3">
                                       <select name="thealthexting.heartDiseases" id=""> 
                                       <option value="">请选择</option>
                                        <s:iterator value="#auto.xzjbList" var="xz">
                                        <option value="${xz.name}">${xz.name}</option>
                                        </s:iterator>
                                       </select>
                                       </td>
                                       <td>神经系统疾病</td>
                                       <td colspan="3">
                                            <div class="jia">
                                              <select     class="di">
                                                <option value="有:">有:</option>
                                                <option value="无" <option value="有:">有:</option>>无</option>
                                              </select>
                                              <input maxlength="30" type="text"  class="gai" value="请选择" name="thealthexting.nervousSystemDisease" >
                                            </div>
                                       <!-- <select name="thealthexting.nervousSystemDisease" id=""> <option value="">请选择</option> <option value="">项目1</option>
                                       </select> -->
                                       </td>
                                      
                                   </tr>
                                   <tr>
                                   <td>其他系统疾病</td>
                                       <td colspan="7">
                                          <div class="jia">
                                            <select     class="di">
                                              <option value="有:">有:</option>
                                              <option value="无">无</option>
                                            </select>
                                            <input maxlength="30" type="text"  class="gai" value="请选择" name="thealthexting.otherNeurologicalDisorders">
                                          </div>
                                       <!-- <select name="thealthexting.otherNeurologicalDisorders" id=""> <option value="">请选择</option> <option value="">项目1</option>
                                       </select> -->
                                       </td>
                                   </tr>
                                   <tr>
                                        <td colspan="8" class="title-td">住院治疗室史</td>
                                       </tr>
                                       <tr>
                                         <td>住院史</td>
                                         <td colspan="7"> </td>
                                       </tr>
                                             <tr>
                                        <td>入院时间</td>
                                        <td>出院时间</td>
                                        <td>原因</td>
                                        <td>医疗机构名称</td>
                                        <td>病案号</td>
                                        <td colspan="3">操作</td>
                                      </tr>
                                      <tr class="dyna-form">
                                     	<td> <input type="text" name="listTHospitalHistory[0].admitHosTime" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"></td>
                                        <td><input type="text"  name="listTHospitalHistory[0].leaveHosTime" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"></td>
                                        <td><input maxlength="20" type="text" name="listTHospitalHistory[0].reason"  class="w40 temp"></td>
                                        <td><input maxlength="20" type="text" name="listTHospitalHistory[0].medicalInstitution"  class="w40 temp"></td>
                                        <td><input maxlength="20" type="text" name="listTHospitalHistory[0].medicalRecordNum"  class="w40 temp"></td>
                                        <td colspan="3">
                                        	<a href="javascript:;" class="btn-del">删除</a>
                                        	<a href="javascript:;" class="btn-add">增加</a>
                                        </td>
                                      </tr>

                                      <tr>
                                         <td>家庭病床史</td>
                                         <td colspan="7"> </td>
                                       </tr>
                                        <tr>
                                        <td>建床日期</td>
                                        <td>撤床日期</td>
                                        <td>原因</td>
                                        <td>医疗机构名称</td>
                                        <td>病案号</td>
                                        <td colspan="3">操作</td>
                                      </tr>
                                      <tr class="dyna-form">
                                        <td> <input type="text" name="listHF[0].createBedTime" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"></td>
                                        <td> <input type="text" name="listHF[0].revokeBedTime" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"></td>
                                        <td><input maxlength="20" type="text" name="listHF[0].reason"  class="w40 temp"></td>
                                        <td><input maxlength="20" type="text" name="listHF[0].medicalInstitution"  class="w40 temp"></td>
                                        <td><input maxlength="20" type="text" name="listHF[0].medicalRecordNum"  class="w40 temp"></td>
                                        <td colspan="3">
                                        	<a href="javascript:;" class="btn-del">删除</a>
                                        	<a href="javascript:;" class="btn-add">增加</a>
                                        </td>
                                      </tr>



                                   <tr>
                                        <td colspan="8" class="title-td">住院用药情况</td>
                                       </tr>
                                       <tr>
                                        <td>药物名称</td>
                                        <td>用法</td>
                                        <td>用量</td>
                                        <td>用药时间</td>
                                        <td>服药依从性</td>
                                        <td colspan="3">操作</td>
                                      </tr>
                                      <tr class="dyna-form">
                                        <td><input maxlength="30" name="listTMedicalUse[0].medicalName" type="text"  class="w40 temp"></td>
                                        <td><input maxlength="30" name="listTMedicalUse[0].useMethod" type="text"  class="w40 temp"></td>
                                        <td><input maxlength="30" name="listTMedicalUse[0].useAccount" type="text"  class="w40 temp"></td>
                                        <td><input maxlength="20" type="text" name="listTMedicalUse[0].useTime" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"></td>
                                        <td><input maxlength="30" name="listTMedicalUse[0].medicalComl" type="text"  class="w40 temp"></td>
                                        <td colspan="3">
                                        	<a href="javascript:;" class="btn-del">删除</a>
                                        	<a href="javascript:;" class="btn-add">增加</a>
                                        </td>
                                      </tr>
                                      <tr>
                                         <td colspan="8" class="title-td">非免疫规划预防接种史</td>
                                       </tr>
                                       <tr>
                                        <td>疫苗名称</td>
                                        <td>接种日期</td>
                                        <td>接种机构</td>
                                        <td colspan="5">操作</td>
                                      </tr>
                                      <tr class="dyna-form">
                                        <td><input maxlength="30" name="listTDefendInocu[0].vaccineName" type="text"  class="w40 temp"></td>
                                        <td><input maxlength="20" name="listTDefendInocu[0].vaccineTime" type="text" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"></td>
                                        <td><input maxlength="30" name="listTDefendInocu[0].vaccineInstit" type="text"  class="w40 temp"></td>
                                        <td colspan="5">
                                        	<a href="javascript:;" class="btn-del">删除</a>
                                        	<a href="javascript:;" class="btn-add">增加</a>
                                        </td>
                                      </tr>
                                       <tr>
                                        <td>
                                          <label>健康评价：</label>
                                        </td>
                                        <td>
                                              <div class="jia">
                                               <select     class="di">
                                              <option value="有:">有:</option>
                                              <option value="无" selected="selected">无</option>
                                            </select>
                                            <input maxlength="30" type="text"  class="gai"   name="tphysicalexam.healthAssessment" >
                                              </div>
                                        </td>
                                        <td>
                                         <label>危险因素控制：</label>
                                        </td>
                                        <td>
                                          <select name="tphysicalexam.riskFactorControl" id="">
                                            <option value="">请选择</option>
                                             <s:iterator value="#auto.wxysList" var="wxys">
                                        <option value="${wxys.name}">${wxys.name}</option>
                                        </s:iterator>
                                          </select>
                                        </td>
                                        <td>
                                          <label>健康指导：</label>
                                        </td>
                                        <td colspan="3">
                                          <select name="tphysicalexam.healthGuide" id="">
                                            <option value=""> </option>
                                             <s:iterator value="#auto.jkzdList" var="jkzd">
                                        <option value="${jkzd.name}">${jkzd.name}</option>
                                        </s:iterator>
                                          </select>
                                        </td>
                                  </tr>
                             </tbody> 
                             </table>
                          <div class="btn-content">
                                  <input type="submit" class="btn btn-xinzeng" value="提交">
                                  <input  class="btn" type="button" onclick="history.go(-1);" value="返回"> 

                            </div>
                       </form>
            </div> <!-- 表单表格 start -->
    </div>
    <!-- 主容器 end -->
    <!-- 底栏 Start-->
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>
<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<script src="/jmjkms/select2/js/select2.full.js"></script>
<script src="/jmjkms/js/confirm/Validform_v5.3.2_min.js"></script>
<script type="text/javascript">
    $(function(){
      $("#registerform").Validform({
        showAllError:false,
        tiptype:function(msg){          
          alert(msg);
        }
      });
  });
  /* $("form").submit(function(){
  		if($("#time").val()==""){
  			alert("体检日期不能为空")
  			return false;
  		}
  }) */
</script>
<script type="text/javascript">
	$(document).ready(function(){
		var inputValue = $("#content-input").val();
		if(inputValue.length != 0){
			$("#content").show();
		}
	});
</script>
<script type="text/javascript">
	
window.onload = function(){

					var di = document.getElementsByClassName("di");
					var gai = document.getElementsByClassName("gai");

					for (var i = 0; i < di.length; i++) {
						
							di[i].di = i;
								 (function(j){
								  	gai[j].value = "无"; 
								 di[j].onchange = function(){
							gai[j].value = this.options[this.options.selectedIndex].value;
					
								 };	
								

							}(i));
							
					}
					}
	</script>
<script>
	function Num(obj){
	obj.value = obj.value.replace(/[^\d.]/g,"");
	obj.value = obj.value.replace(/^\./g,""); 
	obj.value = obj.value.replace(/\.{2,}/g,"."); 
	obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
        }
</script>	
	
	
	
<script type="text/javascript">
	$(function(){
		$(".js-example-basic-single").select2();
	})
</script>
<script type="text/javascript">
		$("#tizhong").blur(function(){
			var tizhong=(Number($("#tizhong").val()));
			var shengao=(Number($("#shengao").val()/100));
			if(tizhong!=0 && shengao!= 0){
				var tizhi=tizhong/(shengao*shengao);
				$("#tizhi").html((Number(tizhi)).toFixed(2));
			}
			
		})
		$("#shengao").blur(function(){
			var tizhong=(Number($("#tizhong").val()));
			var shengao=(Number($("#shengao").val()/100));
			if(tizhong!=0 && shengao!=0){
				var tizhi=tizhong/(shengao*shengao);
				$("#tizhi").html((Number(tizhi)).toFixed(2));
			}
		})
		$("#tunwei").blur(function(){
			var tunwei=(Number($("#tunwei").val()));
			var yaowei=(Number($("#yaowei").val()));
			if(tunwei!=0&&yaowei!=0){
				var bi=yaowei/tunwei;
				$("#tybi").html((Number(bi)).toFixed(2));
			}
		})
		$("#yaowei").blur(function(){
			var tunwei=(Number($("#tunwei").val()));
			var yaowei=(Number($("#yaowei").val()));
			if(tunwei!=0&&yaowei!=0){
				var bi=yaowei/tunwei;
				$("#tybi").html((Number(bi)).toFixed(2));
			}
		})
	</script>
<script type="text/javascript">
function somker(o){
   if(o.options[o.selectedIndex].value=="从不吸烟"){
      document.getElementById("somke1").disabled=true;
      document.getElementById("somke2").disabled=true;
      document.getElementById("somke3").disabled=true;
   }else{
    
      document.getElementById("somke1").disabled=false;
      document.getElementById("somke2").disabled=false;
      document.getElementById("somke3").disabled=false;
      
   }
}
</script>

<script type="text/javascript">
function doit(o){
   if(o.options[o.selectedIndex].value=="从不"){
      document.getElementById("b").disabled=true;
      document.getElementById("c").disabled=true;
      document.getElementById("d").disabled=true;
      document.getElementById("e").disabled=true;
       document.getElementById("f").disabled=true;
   }else{
    
      document.getElementById("b").disabled=false;
      document.getElementById("c").disabled=false;
      document.getElementById("d").disabled=false;
      document.getElementById("e").disabled=false;
      document.getElementById("f").disabled=false;
      
   }
}
</script>
<%-- <script type="text/javascript">
	window.onload = function(){
		var nodrink = document.getElementById("nodrink");
		var drink = document.getElementById("drink");
		var nodrinks = nodrink.vlaue;
		
		nodrink.onchange =function(){
		alert(nodrinks);
			if(nodrinks == "从不"){
				drink.disabled = true;	
			}else{
				drink.disabled = false;
			} 
		}
	
	}

</script> --%>
 <script type="text/javascript">
		$(function() {
			$("#registerform1").Validform({
				//btnSubmit:".btn_sub",
				showAllError : false,
				tiptype : function(msg) {
					alert(msg);
				}
			});
		});
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
	})

</script>
</body>
</html>
