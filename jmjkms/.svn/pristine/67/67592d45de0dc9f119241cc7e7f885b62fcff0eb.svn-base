<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head><meta name="viewport" content="width=device-width, initial-scale=1.0"><meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta charset="UTF-8">
<c:choose><c:when test="${session.comHospital.isHead==0}"><title>中电科社区健康管理平台</title></c:when><c:when test="${session.communityHospitalGroup!=null}"><title>社区健康管理系统</title></c:when><c:otherwise><title>社区健康服务站</title></c:otherwise></c:choose>
 <link type="text/css" href="/jmjkms/css/confirm.css">
<link rel="stylesheet" href="/jmjkms/css/cssreset.css">
<link rel="stylesheet" href="/jmjkms/css/main.css">
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
    border-radius:3px 0 0 3px;
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
		<div class="container">
			<h3 class="current-title">体检编辑</h3>
			<!-- 表单表格 start -->
			<div class="table-content">
				<form id="registerform" action="PhysicalExamAction!editPhysicalExam.action" method="post">
				<!-- 体检总表ID  -->
				<input type="hidden" name="tphysicalexam.physicalExamId" value="${VExam.physicalExamId}">
				<input type="hidden" name="tphysicalexam.belongSystem" value="${VExam.belongSystem}">
				
				<!--健康档案的ID和idNum 将其放入隐藏域 -->
              	 <input type="hidden" name="thealthFile.healthFileId" value="${VExam.healthFileId}">
              	 <input type="hidden" name="thealthFile.idNum" value="${VExam.idNum}">
              	  
              	 <!-- 一般状况的ID 将其放入隐藏域 -->
               	<input type="hidden" name="tgeneralcondition.generalConditionId" value="${VExam.generalConditionId}"> 
               	<!-- 脏器功能的ID 将其放入隐藏域 -->
               	<input type="hidden" name="torganfunction.organFunctionId" value="${VExam.organFunctionId}"> 
				<%-- <!-- 一般状况表的ID 将其放入隐藏域 -->
               	<input type="text" name="generalConditionId" value="${VExam.generalConditionId}"> 
               	 --%>
               	<!-- 辅助检查表的ID 将其放入隐藏域 -->
               	<input type="hidden" name=tauxiliaryexamination.auxiliaryExaminationId value="${VExam.auxiliaryExaminationId}"> 
               	<!-- 现存主要问题的ID 将其放入隐藏域 -->
               	<input type="hidden" name="thealthexting.healthExistingProblemsId" value="${VExam.healthExistingProblemsId}"> 
                <!-- 生活方式表的ID 将其放入隐藏域 -->
               	<input type="hidden" name="tlifestyle.lifeId" value="${VExam.lifeId}"> 
               	<!-- 中医体质辨识表的ID 将其放入隐藏域 -->
              	<input type="hidden" name="tchinamedicine.chinaMedicineId" value="${VExam.chinaMedicineId}"> 
               	<!-- 查体表的ID 将其放入隐藏域 -->
               	<input type="hidden" name="tcheck.checkId" value="${VExam.checkId}">
				<!-- 本地的体检ID  在对54服务器的one 字段中 -->
				 <input name="tphysicalexam.one" value="${VExam.one}" type="hidden"/>
				<!-- //权限隐藏框 -->
				<input name="yemianname" value="03100" type="hidden"/> 
				<!--  令牌 -->
                <input type="hidden" name="token" value="${token}" />
				    <s:action name="PhysicalExamAction!autoAction" namespace="/" var="auto"> </s:action>
				   
					<table class="table table-bordered">
						<tbody>
							<tr> 
                                        <td>档案编号</td> 
                                        <td>${VExam.fileNum}</td> 
                                        <td>姓名</td> 
                                        <td>${VExam.name}</td> 
                                        <td>性别</td> 
                                        <c:if test="${VExam.sex==true}">
										<td colspan="3">男</td>
							         	</c:if>
							        	 <c:if test="${VExam.sex==false}">
										<td colspan="3">女</td>
							         	</c:if>
                                        
                                   </tr>
							<tr>
								<td>体检类型：</td> 
                                <td colspan="3"> 
                                    <input type="hidden"  class="w40 temp"
									name="tphysicalexam.physicalExamType" value="${VExam.physicalExamType}">
									${VExam.physicalExamType}
								</td>
								<td>体检日期:</td> 
                                <td colspan="3"> 
                                     <input type="hidden"  class="w40 temp"
									name="tphysicalexam.physicalExamDate" value="${VExam.physicalExamDate}">
                                        <fmt:formatDate value="${VExam.physicalExamDate}"  pattern="yyyy-MM-dd"/>
                                 </td>
							</tr>

							<tr>
								<td>体检医生:</td>
								<td colspan="3" >
									<input type="hidden"  class="w40 temp"  name="tphysicalexam.responsibleDoctor" value="${VExam.responsibleDoctor}">
									${VExam.responsibleDoctor}
								</td>
								<td>录入员:</td>
								<td colspan="3" >
										<input type="hidden"  class="w40 temp" name="tphysicalexam.operator" value="${VExam.operator}">
										${VExam.operator}
								</td>

							</tr>
							<tr>
								<td colspan="8" class="title-td">症状、一般状况</td>
							</tr>
							<tr>
								<td>症状特点</td>

								<td>
								<select name="tphysicalexam.characteristicSymptom" class="js-example-basic-single" class="select2" style="width: 120px;" nullmsg="员工编码不可为空" onchange="getContent(this.value,this.options[this.selectedIndex].text)" >
									<option value=" ">  </option> 
                                  	 <s:iterator value="#auto.zztdList" var="zz" status="n">
                                  	 <option value="${zz.name}" <c:if test="${zz.name eq VExam.characteristicSymptom}">selected</c:if> >${zz.name}</option>
                                 	 </s:iterator>
                                     	</select>  	
								
										</td>
								<td>体温</td>
								<td><input type="text"  class="w40 temp" maxlength="5" onkeyup="value=value.replace(/[^\d.]/g,'')"  errormsg="体温输入有误" 
									name="tgeneralcondition.temperature" value="${VExam.temperature}"> ℃ </td>
								<td>呼吸频率</td>
								<td><input type="text"  class="w40 temp"  maxlength="5"  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" errormsg="呼吸频率输入有误"
									name="tgeneralcondition.breathingRate" value="${VExam.breathingRate}"> 次/分</td>

								<td>舒张压</td>
								<td><input type="text"  class="w40 temp"  maxlength="5" onkeyup="value=value.replace(/[^\d.]/g,'')" errormsg="舒张压输入有误" 
									name="tgeneralcondition.diastolicPressure" value="${VExam.diastolicPressure}"> mmhg</td>
							</tr>
							
							<tr>
								<td>收缩压</td>
								<td><input type="text"  class="w40 temp"  maxlength="5" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"  errormsg="收缩压输入有误" 
									name="tgeneralcondition.systolicPressure" value="${VExam.systolicPressure}">
									mmhg</td>
								<td>脉搏</td>
								<td><input type="text"  class="w40 temp"  maxlength="5" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"  errormsg="脉搏输入有误"
									name="tgeneralcondition.pulseRate" value="${VExam.pulseRate}"> 次/分</td>
								<td>身高</td>
								<td><input type="text"  class="w40 temp" id="shengao" maxlength="5" onkeyup="value=value.replace(/[^\d.]/g,'')"  errormsg="身高输入有误"
									name="tgeneralcondition.height" value="${VExam.height}"> cm</td>
								<td>体重</td>
								<td><input type="text"  class="w40 temp" id="tizhong"   maxlength="5" onkeyup="value=value.replace(/[^\d.]/g,'')"  errormsg="体重输入有误"
									name="tgeneralcondition.weight" value="${VExam.weight}"> kg</td>
							</tr>
							
							<tr>
								<td>体质指数</td>
								<td id="tizhi"><%-- <select id="" name="tgeneralcondition.bmi">
										<option value="">请选择</option>
										<option value="0" <c:if test="${0 eq VExam.bmi}">selected=selected</c:if> >0</option>
										<option value="1" <c:if test="${1 eq VExam.bmi}">selected=selected</c:if> >1</option>
										</select>  --%>
								</td>
								 <td>腰围</td>
								<td><input type="text" id="yaowei"  class="w40 temp"   maxlength="5" onkeyup="value=value.replace(/[^\d.]/g,'')"  errormsg="腰围输入有误"
									name="tgeneralcondition.waistline"  value="${VExam.waistline}"> cm</td>
								<td>臀围</td>
								<td><input type="text" id="tunwei"  class="w40 temp"   maxlength="5" onkeyup="value=value.replace(/[^\d.]/g,'')"  errormsg="臀围输入有误"
									name="tgeneralcondition.hip"  value="${VExam.hip}">cm</td>
								<td>臀腰围比例</td>
								<td  id="tybi"><%-- <input type="text"  class="w40 temp"   maxlength="5" onkeyup="value=value.replace(/[^\d.]/g,'')"  errormsg="臀腰围比例输入有误"
									name="tgeneralcondition.ratio"  value="${VExam.ratio}"> --%>
									
								</td>
							</tr>
							<tr>
								<td>老人健康状况自我评估</td>
								<td colspan="3"><select id=""
									name="tgeneralcondition.healthAssessment">
									<option value=" ">请选择</option>
									<s:iterator value="#auto.lnrjkList" var="jk">
									<option value="${jk.name}" <c:if test="${jk.name eq VExam.healthAssessment}">selected=selected</c:if> >${jk.name}</option>
                                        </s:iterator>
										</select></td>
								<td>老人生活自理能力自我评估</td>
								<td colspan="3"><select id=""
									name="tgeneralcondition.selfAssessment">
									  <option value=" ">请选择</option>
									  <s:iterator value="#auto.lnrzlList" var="zl"> 
										<option value="${zl.name}" <c:if test="${zl.name eq VExam.selfAssessment}">selected=selected</c:if> >${zl.name}</option>
									</s:iterator>
								 </select></td>
							</tr>
							<tr>
								<td>老年人认知功能</td>
								<td colspan="3"><select id="" name="tgeneralcondition.cognitiveFunction">
									<option value=" ">请选择</option> 
									<s:iterator value="#auto.lnrrzList" var="rz">		
								<option value="${rz.name}" <c:if test="${rz.name eq VExam.cognitiveFunction}">selected=selected</c:if> >${rz.name}</option>
								  </s:iterator>
								</select></td>
								<td>老年人情感状况</td>
								<td colspan="3">
								<select id="" name="tgeneralcondition.emotion">
								<option value=" ">请选择</option> 
								<s:iterator value="#auto.lnrqgList" var="qg"> 
								<option value="${qg.name}" <c:if test="${qg.name eq VExam.emotion}">selected=selected</c:if> >${qg.name}</option>
								</s:iterator>
								
								</select></td>
							</tr>
							<tr>
							<td colspan="8" class="title-td">生活方式</td>
							
							</tr>
							<tr>
								<td>体育锻炼频率</td>
								<td>
								<select name="tlifestyle.exerciseFrequency" id="">
									<option value=" ">请选择</option>
									<s:iterator value="#auto.tydlplList" var="ty"> 
                                      		 <option value="${ty.name}" <c:if test="${ty.name eq VExam.exerciseFrequency}">selected=selected</c:if>>${ty.name}</option>
                                       </s:iterator>
								<%-- <optionflue="良好" <c:if test="${'良好' eq VExam.exerciseFrequency}">selected=selected</c:if> >良好</option>
							 --%></select>
							
							</td>
								<td>每次锻炼时间</td>
								<td>
									<input type="text"  class="w40 temp"   maxlength="5"
									name="tlifestyle.exerciseTime" value="${VExam.exerciseTime} ">min
								</td>
								<td>坚持锻炼时间</td>
								<td><input type="text"  class="w40 temp"   maxlength="5"
									name="tlifestyle.allExerciseTime" value="${VExam.allExerciseTime}"> min</td>
								<td>锻炼方式</td>
								<td><select name="tlifestyle.exerciseType" id="">
										<option value=" ">请选择</option>
										
										<s:iterator value="#auto.dlfsList" var="dl"> 
                                      		 <option value="${dl.name}" <c:if test="${dl.name eq VExam.exerciseType}">selected=selected</c:if>>${dl.name}</option>
                                       </s:iterator>
										
									<%-- <option value="良好" <c:if test="${'良好' eq VExam.exerciseType}">selected=selected</c:if> >良好</option> --%>
								</select> </td>
							</tr>
							<tr>
								<td>饮食习惯</td>
								<td><select name="tlifestyle.dietaryHabit" id="">
										<option value=" ">请选择</option>
										<%-- <option value="良好" <c:if test="${'良好' eq VExam.dietaryHabit}">selected=selected</c:if> >良好</option> --%>
									<s:iterator value="#auto.ysxgList" var="ys"> 
                                      		 <option value="${ys.name}" <c:if test="${ys.name eq VExam.dietaryHabit}">selected=selected</c:if> >${ys.name}</option>
                                       </s:iterator>
								</select>
								</td>
								<td>吸烟状况</td>
								<td><select name="tlifestyle.smokingStatus" id="">
										<option value=" ">请选择</option>
										<s:iterator value="#auto.xyzkList" var="xy"> 
                                      		 <option value="${xy.name}" <c:if test="${xy.name eq VExam.smokingStatus}">selected=selected</c:if>>${xy.name}</option>
                                       </s:iterator>
										<%-- <option value="良好" <c:if test="${'良好' eq VExam.smokingStatus}">selected=selected</c:if> >良好</option> --%>
								</select></td>
								<td>日饮酒量平均</td>
								<td>
								<input type="text"  class="w40 temp"  maxlength="5"
									name="tlifestyle.smokingOneday" value="${VExam.smokingOneday}"> 两</td>
								<td>开始吸烟年龄</td>
								<td><input type="text"  class="w40 temp" maxlength="3" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"
									name="tlifestyle.startsmokingAge" value="${VExam.startsmokingAge}"> 岁</td>
							</tr>
							
							<tr>
								<td>戒烟年龄</td>
								<td><input type="text"  class="w40 temp" maxlength="3" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"
									name="tlifestyle.giveupSmokingAge" value="${VExam.giveupSmokingAge}"> 岁</td>
								<td>饮酒频率</td>
								<td><select name="tlifestyle.drinkingFrequency" id="">
										<option value=" ">请选择</option>
										<s:iterator value="#auto.yjplList" var="yj"> 
                                      		 <option value="${yj.name}" <c:if test="${yj.name eq VExam.drinkingFrequency}">selected=selected</c:if>>${yj.name}</option>
                                       </s:iterator>
									<%-- 	<option value="良好" <c:if test="${'良好' eq VExam.drinkingFrequency}">selected=selected</c:if> >良好</option> --%>
								</select></td>
								<td>日饮酒量</td>
								<td><input type="text"  class="w40 temp" maxlength="5"
									name="tlifestyle.monthlyDrinking" value="${VExam.monthlyDrinking}"> 两</td>
								<td>是否戒酒</td>
								<td><select name="tlifestyle.abstinence" id="">
										<option value=" ">请选择</option>
										<option value="是" <c:if test="${'是' eq VExam.abstinence}">selected=selected</c:if> >  是</option>
										<option value="否"<c:if test="${'否' eq VExam.abstinence}">selected=selected</c:if> >  否</option>
								</select>
								
								</td>
							</tr>
						<tr>
								<td>开始饮酒年龄</td>
								<td><input type="text"  class="w40 temp" maxlength="3" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"
									name="tlifestyle.startDrinkingAge" value="${VExam.startDrinkingAge}">岁</td>
								<td>近一年内是否曾醉酒</td>
								<td colspan="2"><select
									name="tlifestyle.recentlyYearDrinking" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.recentlyYearDrinking}">selected=selected</c:if> >良好</option>
								</select> </td>
								<td>饮酒种类</td>
								<td colspan="2"><select name="tlifestyle.drinkingType" id="">
										<option value="">请选择</option>
										<s:iterator value="#auto.yjzlList" var="yz"> 
                                      		 <option value="${yz.name}" <c:if test="${yz.name eq VExam.drinkingType}">selected=selected</c:if> >${yz.name}</option>
                                       </s:iterator>
										<%-- <option value="良好" <c:if test="${'良好' eq VExam.drinkingType}">selected=selected</c:if> >良好</option> --%>
								</select></td>
							</tr>

							<tr>
								<td>职业病危害因素接触史</td>
								<td colspan="2">
									<div class="jia">
                                                <select     class="di">
                                                  <option value="有:具体职业()从业()年">有:具体职业()从业()年</option>
                                                  <option value="无"  selected="selected">无</option>
                                                </select>
                                                <input maxlength="30" type="text"   class="gai"  name="tlifestyle.occupationalDisease" value="${VExam.occupationalDisease}" >
                                            </div>
									<%-- <div class="jia">
										<select     class="di">
											<option value="">请选择</option>
											<option value="有:">有:</option>
											<option value="无" >无</option>
										</select>
										<input type="text"   class="gai" name="tlifestyle.occupationalDisease"
											value="${VExam.occupationalDisease}" >
									</div> --%>
								</td>
								<td>毒物种类</td>
								<td>
									<input maxlength="20"  type="text"  class="w40 temp" name="tlifestyle.dust" value="${VExam.dust}">
								</td>
								<td>防护措施</td>
								<td colspan="2">
								<div class="jia">
										<select     class="di">
										 	<option value="有:" >有:</option>
											<option value="无" selected="selected">无</option>
										</select>
										<input type="text"   class="gai" name="tlifestyle.dustFence" value="${VExam.dustFence}" >
									</div>
								<%-- <select name="tlifestyle.dustFence" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.dustFence}">selected=selected</c:if> >良好</option>
								</select> --%>
								</td>
							</tr>
							<tr>
								<td>放射物质</td>
								<td>
									<input type="text"  class="w40 temp" maxlength="20" 
									name="tlifestyle.radiogen" value="${VExam.radiogen}">
									 </td>
								<td>防护措施</td>
								<td>
								<div class="jia">
										<select     class="di">
										 	<option value="有:" >有:</option>
											<option value="无" selected="selected">无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tlifestyle.radiogenFence" value="${VExam.radiogenFence}" >
									</div>
								
								<%-- <select name="tlifestyle.radiogenFence" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.radiogenFence}">selected=selected</c:if> >良好</option>
								</select> --%></td>
								<td>物理因素</td>
								<td>
									<input type="text"  class="w40 temp" maxlength="20"
									name="tlifestyle.physicalFactor" value="${VExam.physicalFactor}">
									</td>
								<td>防护措施</td>
								<td>
								<div class="jia">
										<select     class="di">
										 	<option value="有:" >有:</option>
											<option value="无" selected="selected">无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tlifestyle.physicalFactorFence" value="${VExam.physicalFactorFence}" >
									</div>
								<%-- <select name="tlifestyle.physicalFactorFence" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.physicalFactorFence}">selected=selected</c:if> >良好</option>
								</select> --%>
								</td>
							</tr>
							<tr>
								<td>化学物质</td> 
								<td><input type="text"  class="w40 temp"  maxlength="20"
									name="tlifestyle.chemicalSubstances" value="${VExam.chemicalSubstances}">
									
									</td>
								<td>防护措施</td>
								<td>
								<div class="jia">
										<select     class="di">
										 	<option value="有:" >有:</option>
											<option value="无" selected="selected">无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tlifestyle.chSubFence" value="${VExam.chSubFence}" >
									</div>
								<%-- <select name="tlifestyle.chSubFence" id="">
										<option value=""> </option>
										<option value="良好" <c:if test="${'良好' eq VExam.chSubFence}">selected=selected</c:if> >良好</option>
								</select> --%>
								</td>
								<td>其他</td>
								<td><input maxlength="30" type="text"  class="w40 temp" name="tlifestyle.other" value="${VExam.other}">
									</td>
								<td>防护措施</td>
								<td>
								<div class="jia">
										<select     class="di">
										 	<option value="有:" >有:</option>
											<option value="无" selected="selected">无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tlifestyle.otherFence" value="${VExam.otherFence}" >
									</div>
								<%-- <select name="tlifestyle.otherFence" id="">
										<option value=""> </option>
										<option value="良好" <c:if test="${'良好' eq VExam.otherFence}">selected=selected</c:if> >良好</option>
								</select> --%>
								</td>
							</tr>
							<tr>
								<td colspan="8" class="title-td">脏器功能</td>
							</tr>
							<tr>
								<td>口腔口齿</td>
								<td><select name="torganfunction.oralLip" id="">
										<option value=""> </option>
										 <s:iterator value="#auto.kqkcList" var="kqkc">
										<option value="${kqkc.name}" <c:if test="${kqkc.name eq VExam.oralLip}">selected=selected</c:if> >${kqkc.name}</option>
									</s:iterator>
								</select></td>
								<td>齿列</td>
								<td><select name="torganfunction.dentition" id="">
										<option value=""> </option>
										 <s:iterator value="#auto.clList" var="cl">
										<option value="${cl.name}" <c:if test="${cl.name eq VExam.dentition}">selected=selected</c:if> >${cl.name}</option>
										</s:iterator>
								</select></td>
								<td>咽部</td>
								<td colspan="3"><select name="torganfunction.pharynx" id="">
										<option value=" "> </option>
										<s:iterator value="#auto.ybList" var="yb">
										<option value="${yb.name}" <c:if test="${yb.name eq VExam.pharynx}">selected=selected</c:if> >${yb.name}</option>
										</s:iterator>
								</select></td>
							</tr>
							<tr>
								<td>视力左眼</td>
								<td><input type="text"  class="w40 temp" maxlength="10"
									name="torganfunction.visionLeftEye" value="${VExam.visionLeftEye}"></td>
								<td>视力右眼</td>
								<td><input type="text"  class="w40 temp" maxlength="10"
									name="torganfunction.visionRightEye" value="${VExam.visionRightEye}"></td>
								<td>矫正视力(左眼)</td>
								<td><input type="text"  class="w40 temp" maxlength="10"
									name="torganfunction.correctedVisionLeftEye" value="${VExam.correctedVisionLeftEye}"></td>
								<td>矫正视力(右眼)</td>
								<td><input type="text"  class="w40 temp" maxlength="10"
									name="torganfunction.correctedVisionRightEye" value="${VExam.correctedVisionRightEye}"></td>
							</tr>
							<tr>
								<td>听力</td>
								<td colspan="3"><select name="torganfunction.hearing" id="">
										<option value=""> </option>
										<s:iterator value="#auto.tlList" var="tl">
										<option value="${tl.name}" <c:if test="${tl.name eq VExam.hearing}">selected=selected</c:if> >${tl.name}</option>
										 </s:iterator>
										</select>  
									</td>
								<td>运动功能</td>
								<td colspan="3"><select name="torganfunction.motorFunction"
									id="">
										<option value=""> </option>
										<s:iterator value="#auto.ydgnList" var="ydgn">
										<option value="${ydgn.name}"<c:if test="${ydgn.name eq VExam.motorFunction}">selected=selected</c:if> >${ydgn.name}</option>
										</s:iterator>
								</select> </td>
							</tr>
							<tr>
								<td colspan="8" class="title-td">查体</td>
							</tr>
							<tr>
								<td>皮肤</td>
								<td><select name="tcheck.skin" id="">
										<option value=""> </option>
										<s:iterator value="#auto.pfList" var="pf">
										<option value="${pf.name}" <c:if test="${pf.name eq VExam.skin}">selected=selected</c:if> >${pf.name}</option>
										 </s:iterator>
								</select> </td>
								<td>巩膜</td>
								<td><select name="tcheck.sclera" id="">
										<option value=""> </option>
										 <s:iterator value="#auto.gmList" var="gm">
										<option value="${gm.name}" <c:if test="${gm.name eq VExam.sclera}">selected=selected</c:if> >${gm.name}</option>
										</s:iterator>
								</select>  </td>
								<td>淋巴结</td>
								<td><select name="tcheck.lymphNode" id="">
										<option value=""> </option>
										 <s:iterator value="#auto.lbjList" var="lbj">
										<option value="${lbj.name}" <c:if test="${lbj.name eq VExam.lymphNode}">selected=selected</c:if> >${lbj.name}</option>
										</s:iterator>
								</select></td>
								<td>肺：桶状胸</td>
								<td>
									<div class="jia">
										<select     class="di">
											<option value="">请选择</option>
											<option value="有:">有:</option>
											<option value="无" selected="selected">无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tcheck.barrelChest" value="${VExam.barrelChest}" >
									</div>
									<!-- <select name="tcheck.barrelChest" id="">
											<option value="">请选择</option>
											<option value="1" <c:if test="${'1' eq VExam.barrelChest}" >seleceted=seleceted</c:if> >否</option>
											<option value="0" <c:if test="${'0' eq VExam.barrelChest}" >seleceted=seleceted</c:if> >是</option>
									</select> -->
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
										<input maxlength="30" type="text"   class="gai" name="tcheck.breathSounds" value="${VExam.barrelChest}" >
									</div>
									<!-- <select name="tcheck.breathSounds" id="">
										<option value="">请选择</option>
										<option value="1" <c:if test="${'1' eq VExam.barrelChest}" >seleceted=seleceted</c:if> >是</option>
										<option value="0" <c:if test="${'0' eq VExam.barrelChest}" >seleceted=seleceted</c:if> >否</option>
								
									</select> ${VExam.breathSounds} -->
								</td>
								<td>罗音</td>
								<td><select name="tcheck.rale" id="">
										<option value=""> </option>
										<s:iterator value="#auto.lyList" var="ly">
										<option value="${ly.name}" <c:if test="${ly.name eq VExam.rale}">selected=selected</c:if> >良好</option>
										 </s:iterator>
								</select> </td>
								<td>心率</td>
								<td><input  onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" maxlength="5" type="text"  class="w40 temp" name="tcheck.heartRate" value="${VExam.heartRate}">
									 次/分</td>
								<td>心律</td>
								<td>
									<div class="jia">
										<select     class="di">
											<option value="有:">有:</option>
											<option value="无" selected="selected">无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tcheck.rhythmOfTheHeart" value="${VExam.rhythmOfTheHeart}" >
									</div>
								<!-- <select name="tcheck.rhythmOfTheHeart" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.rhythmOfTheHeart}">selected=selected</c:if> >良好</option>
								</select>  -->
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
										<input maxlength="30" type="text"   class="gai"  name="tcheck.noise" value="${VExam.noise}" >
									</div>
									<!-- <select name="tcheck.noise" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.noise}">selected=selected</c:if> >良好</option>
									</select>  -->
								</td>
								<td>腹部：压痛</td>
								<td>
									<div class="jia">
										<select     class="di">
											<option value="">请选择</option>
											<option value="有:">有:</option>
											<option value="无" >无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tcheck.tenderness" value="${VExam.tenderness}" >
									</div>
								<!-- <select name="tcheck.tenderness" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.tenderness}">selected=selected</c:if> >良好</option>
								</select> --> 
								</td>
								<td>包块</td>
								<td>
									<div class="jia">
										<select     class="di">
											<option value="">请选择</option>
											<option value="有:">有:</option>
											<option value="无" >无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tcheck.masses" value="${VExam.masses}" >
									</div>
									<!-- <select name="tcheck.masses" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.masses}">selected=selected</c:if> >良好</option>
									</select>  -->
								</td>
								<td>肝大</td>
								<td>
									<div class="jia">
										<select     class="di">
											<option value="">请选择</option>
											<option value="有:">有:</option>
											<option value="无" >无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tcheck.hepatomegaly" value="${VExam.hepatomegaly}" >
									</div>
								<!-- <select name="tcheck.hepatomegaly" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.hepatomegaly}">selected=selected</c:if> >良好</option>
								</select>  -->
								</td>
							</tr>
							<tr>
								<td>脾大</td>
								<td>
									<div class="jia">
										<select     class="di">
											<option value="">请选择</option>
											<option value="有:">有:</option>
											<option value="无" >无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tcheck.splenomegaly" value="${VExam.splenomegaly}" >
									</div>
								<!-- <select name="tcheck.splenomegaly" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.splenomegaly}">selected=selected</c:if> >良好</option>
								</select> --> 
								</td>
								<td>移动性浊音</td>
								<td>
									<div class="jia">
										<select     class="di">
											<option value="">请选择</option>
											<option value="有:">有:</option>
											<option value="无" >无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tcheck.shiftingDullness" value="${VExam.shiftingDullness}" >
									</div>
								<!-- <select name="tcheck.shiftingDullness" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.shiftingDullness}">selected=selected</c:if> >良好</option>
								</select>  -->
								</td>
								<td>下肢水肿</td>
								<td><select name="tcheck.lowerExtremityEdema" id="">
										<option value="">请选择</option>
										<s:iterator value="#auto.xzszList" var="xzsz">
										<option value="${xzsz.name}" <c:if test="${xzsz.name eq VExam.lowerExtremityEdema}">selected=selected</c:if> >${xzsz.name}</option>
										</s:iterator>
								</select> </td>
								<td>足背动脉搏动</td>
								<td><select name="tcheck.dorsalisPedisPulse" id="">
										<option value="">请选择</option>
										<s:iterator value="#auto.zbdmbdList" var="zbdmbd">
										<option value="${zbdmbd.name}" <c:if test="${zbdmbd.name eq VExam.rale}">selected=selected</c:if> >${zbdmbd.name}</option>
										</s:iterator>
								</select></td>
							</tr>
							<tr>
								<td>肛门指诊</td>
								<td><select name="tcheck.theAnusDre" id="">
										<option value="">请选择</option>
										<s:iterator value="#auto.gmzzList" var="gmzz">
										<option value="${gmzz.name}" <c:if test="${gmzz.name eq VExam.theAnusDre}">selected=selected</c:if> >${gmzz.name}</option>
										</s:iterator>
								</select>  </td>
								<td>眼底</td>
								<td>
									<div class="jia">
										<select     class="di">
											<option value="">请选择</option>
											<option value="有:">有:</option>
											<option value="无" >无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tcheck.fundus" value="${VExam.fundus}" >
									</div>
								<!-- <select name="tcheck.fundus" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.fundus}">selected=selected</c:if> >良好</option>
								</select> -->  
								</td>
								<td>乳腺</td>
								<td><select name="tcheck.mammaryGland" id="">
										<option value="">请选择</option>
										 <s:iterator value="#auto.lxList" var="lx">
										<option value="${lx.name}" <c:if test="${lx.name eq VExam.mammaryGland}">selected=selected</c:if> >${lx.name}</option>
										</s:iterator>
								</select>  </td>
								<td>妇科外阴</td>
								<td>
									<div class="jia">
										<select     class="di">
											<option value="">请选择</option>
										 	<option value="有:">有:</option>
											<option value="无" >无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tcheck.vulva" value="${VExam.vulva}" >
									</div>
								<!-- <select name="tcheck.vulva" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.vulva}">selected=selected</c:if> >良好</option>
								</select> -->  
								</td>
							</tr>

							<tr>
								<td>阴道</td>
								<td>
									<div class="jia">
										<select     class="di">
											<option value="">请选择</option>
											<option value="有:">有:</option>
											<option value="无" >无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tcheck.vagina" value="${VExam.vagina}" >
									</div>
								<!-- <select name="tcheck.vagina" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.vagina}">selected=selected</c:if> >良好</option>
								</select> --> 
								</td>
								<td>宫颈</td>
								<td>
									<div class="jia">
										<select     class="di">
											<option value="">请选择</option>
											<option value="有:">有:</option>
											<option value="无" >无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tcheck.cervix" value="${VExam.cervix}" >
									</div>
								<!-- <select name="tcheck.cervix" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.cervix}">selected=selected</c:if> >良好</option>
								</select> -->  
								</td>
								<td>宫体</td>
								<td>
									<div class="jia">
										<select     class="di">
											<option value="">请选择</option>
											<option value="有:">有:</option>
											<option value="无" >无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tcheck.corpus" value="${VExam.corpus}" >
									</div>
								<!-- <select name="tcheck.corpus" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.corpus}">selected=selected</c:if> >良好</option>
								</select> -->  
								</td>
								<td>附件</td>
								<td>
									<div class="jia">
										<select     class="di">
											<option value="有:">有:</option>
											<option value="无" >无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tcheck.attachment" value="${VExam.attachment}">
									</div>
								<!-- <select name="tcheck.attachment" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.attachment}">selected=selected</c:if> >良好</option>
								</select>  --> 
								</td>
							</tr>
							<tr>
								<td>其他</td>
								<td colspan="7"><input maxlength="30" type="text"  class="w40 temp"
									name="tcheck.others" value="${VExam.others}">
									 </td>
							</tr>
							<tr>


							<td colspan="8" class="title-td">辅助检查</td>
							</tr>
							<tr>
								<td>空腹血糖</td>
								<td>
									<input type="text"  class="w40 temp" maxlength="6"
									name="tauxiliaryexamination.fbg" value="${VExam.fbg}">mmol/L</td>
								<td>糖化血红蛋白</td>
								<td>
									<input type="text"  class="w40 temp" maxlength="6"
									name="tauxiliaryexamination.glycatedHemoglobin" value="${VExam.glycatedHemoglobin}">%
								</td>
								<td>乙型肝炎表面抗原</td>
								<td colspan="3">
									<div class="jia">
										<select     class="di">
											<option value="">请选择</option>
											<option value="有:">有:</option>
											<option value="无" >无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tauxiliaryexamination.hbsag" value="${VExam.hbsag}" >
									</div>
								<!-- <select name="tauxiliaryexamination.hbsag" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.hbsag}">selected=selected</c:if> >良好</option>
								</select> -->
								</td>
							</tr>
							<tr>
								<td>血常规</td>
								<td colspan="7">
								</td>
							</tr>
							<tr>
								<td>血红蛋白</td>
								<td>
									<input type="text"  class="w40 temp" maxlength="6"
									name="tauxiliaryexamination.hemoglobin" value="${VExam.hemoglobin}">g/L
									
								</td>
								<td>白细胞</td>
								<td>
									<input type="text"  class="w40 temp" maxlength="6"
									name="tauxiliaryexamination.leukocyte" value="${VExam.leukocyte}">g/L
								</td>
								<td>血小板</td>
								<td>
									<input type="text"  class="w40 temp" maxlength="6"
									name="tauxiliaryexamination.platelet" value="${VExam.platelet}">g/L
								</td>
							</tr>
							<tr>
								<td>其他</td>
								<td colspan="7">
									<input type="text"  class="w40 temp" maxlength="30"
									name="tauxiliaryexamination.othersRb" value="${VExam.auxiliaryExaminationOthersRb}">
								</td>
							</tr>

							<tr>
								<td>尿常规</td>
								<td colspan="7">
								</td>
							</tr>
							<tr>
								<td>尿蛋白</td>
								<td>
									<input type="text"  class="w40 temp" maxlength="6"
									name="tauxiliaryexamination.urineProtein" value="${VExam.urineProtein}">
								</td>
								<td>尿糖</td>
								<td>
									<input type="text"  class="w40 temp" maxlength="6"
									name="tauxiliaryexamination.urineGlucose" value="${VExam.urineGlucose}">
								</td>
								<td>尿酮体</td>
								<td>
									<input type="text"  class="w40 temp" maxlength="6"
									name="tauxiliaryexamination.ketone" value="${VExam.ketone}">
									
								</td>
								<td>尿潜血</td>
								<td>
									<input type="text"  class="w40 temp" maxlength="6" name="tauxiliaryexamination.ery" value="${VExam.ery}">mg/dL
								</td>
							</tr>

							<tr>
								<td>其他</td>
								<td colspan="7">
									<input type="text"  class="w40 temp" maxlength="6"
									name="tauxiliaryexamination.othersRu" value="${VExam.othersRu}">
								</td>
							</tr>
							<tr>
								<td>尿微量白蛋白</td>
								<td colspan="3">
									<input type="text"  class="w40 temp" maxlength="6"
									name="tauxiliaryexamination.mau" value="${VExam.mau}">mg/dL
								</td>
								<td>大便潜血</td>
								<td colspan="3" >
									<div class="jia">
										<select >
											<option value="false" <c:if test="${ VExam.sedOccultBlood==false }">selected=selected</c:if> >无</option>
											<option value="true" <c:if test="${ VExam.sedOccultBlood!=false }">selected=selected</c:if> >有</option>
											
										</select>
									</div> 
								</td>
							</tr>
							<tr>
								<td>肝功能</td>
								<td colspan="7">
								 </td>
							</tr>
							<tr>
								<td>血清谷丙转氨酸</td>
								<td>
									<input type="text"  class="w40 temp" maxlength="6"
									name="tauxiliaryexamination.serumAlanineAminoAcid" value="${VExam.serumAlanineAminoAcid}">U/L
								</td>
								<td>血清谷草转氨酸</td>
								<td>
									<input type="text"  class="w40 temp" maxlength="6"
									name="tauxiliaryexamination.serumAspertateAminoAcid" value="${VExam.serumAspertateAminoAcid}">U/L
								</td>
								<td>白蛋白</td>
								<td>
									<input type="text"  class="w40 temp" maxlength="6"
									name="tauxiliaryexamination.albumin" value="${VExam.albumin}">g/L
								</td>
								<td>总胆红素</td>
								<td>
									<input type="text"  class="w40 temp" maxlength="6"
									name="tauxiliaryexamination.tbil" value="${VExam.tbil}">umol/L
								</td>
							</tr>
							<tr>
								<td>结合胆红素</td>
								<td>
									<input type="text"  class="w40 temp" maxlength="6"
									name="tauxiliaryexamination.dbil" value="${VExam.dbil}">umol/L
								</td>
							</tr>
							<tr>
								<td>肾功能</td>
								<td colspan="7">
								 </td>
							</tr>
							<tr>
								<td>血清肌酐</td>
								<td>
									<input type="text"  class="w40 temp" maxlength="6"
									name="tauxiliaryexamination.cr" value="${VExam.cr}">mmol/L
									
								</td>
								<td>血尿素氨</td>
								<td>
									<input type="text"  class="w40 temp" maxlength="6"
									name="tauxiliaryexamination.bun" value="${VExam.bun}">mmol/L
								</td>
								<td>血钾浓度</td>
								<td>
									<input type="text"  class="w40 temp" maxlength="6"
									name="tauxiliaryexamination.serumPotassiumLevel" value="${VExam.serumPotassiumLevel}">mmol/L
								</td>
								<td>血钠浓度</td>
								<td>
									<input type="text"  class="w40 temp" maxlength="6"
									name="tauxiliaryexamination.serumNatriumLevel" value="${VExam.serumNatriumLevel}">mmol/L
									
								</td>
							</tr>
							<tr>
								<td>血脂</td>
								<td colspan="7"> </td>
							</tr>
							<tr>
								<td>总胆固醇</td>
								<td>
									<input type="text"  class="w40 temp" maxlength="6"
									name="tauxiliaryexamination.totalCholesterol" value="${VExam.totalCholesterol}">mmol/L
								</td>
								<td>血清低密度蛋白胆固醇</td>
								<td>
									<input type="text"  class="w40 temp" maxlength="6"
									name="tauxiliaryexamination.ldlC" value="${VExam.ldlC}">mmol/L
								</td>
								<td>甘油三酯</td>
								<td>
									<input type="text"  class="w40 temp" maxlength="6"
									name="tauxiliaryexamination.triglyceride" value="${VExam.triglyceride}">mmol/L
								</td>
								<td>血清高密度脂蛋白胆固醇</td>
								<td>
									<input type="text"  class="w40 temp" maxlength="6"
									name="tauxiliaryexamination.hdlC" value="${VExam.hdlC}">mmol/L
								</td>
							</tr>
							<tr>
							
								<td>宫颈涂片</td>
								<td>
									<div class="jia">
										<select     class="di">
											<option value="有:">有:</option>
											<option value="无" selected="selected">无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tauxiliaryexamination.papSmear" value="${VExam.papSmear}" >
									</div>
									<!-- <select name="tauxiliaryexamination.papSmear" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.papSmear}">selected=selected</c:if> >良好</option>
									</select>  -->
								</td>
								<td>心电图</td>
								<td>
									<div class="jia">
										<select     class="di">
											<option value="">请选择</option>
											<option value="有:">有:</option>
											<option value="无" selected="selected">无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tauxiliaryexamination.ecg" value="${VExam.ecg}">
									</div>
									<!-- <select name="tauxiliaryexamination.ecg" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.ecg}">selected=selected</c:if> >良好</option>
									</select> --> 
								</td>
								<td>胸部X线片</td>
								<td>
									<div class="jia">
										<select     class="di">
											<option value="">请选择</option>
											<option value="有:">有:</option>
											<option value="无" >无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tauxiliaryexamination.chestXRay" value="${VExam.chestXRay}" >
									</div>
									<!-- <select name="tauxiliaryexamination.chestXRay" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.chestXRay}">selected=selected</c:if> >良好</option>
									</select> -->
								</td>
								<td>B超</td>
								<td>
									<div class="jia">
										<select     class="di">
											<option value="">请选择</option>
											<option value="有:">有:</option>
											<option value="无" >无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tauxiliaryexamination.BScanUltrasonography"  value="${VExam.BScanUltrasonography}" >
									</div>
									<!-- <select name="tauxiliaryexamination.BScanUltrasonography" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.BScanUltrasonography}">selected=selected</c:if> >良好</option>
									</select> --> 
								</td>
							</tr>
							<tr>
								<td>其他</td>
								<td colspan="7">
									<input type="text"  class="w40 temp" maxlength="30"
									name="tauxiliaryexamination.others" value="${VExam.auxiliaryExaminationOthers}">
								</td>
							</tr>
							

<!-- ===================================================================================================================	
 -->							
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
										<input maxlength="30" type="text"   class="gai" name="tchinamedicine.deficiency" value="${VExam.deficiency}"
										placeholder="请选择">
									</div>
								<!-- <select name="tchinamedicine.deficiency"
									id="">
										 
										<option value="良好" <c:if test="${'良好' eq VExam.deficiency}">selected=selected</c:if> >良好</option>
								</select> -->
								</td>
								<td>指导意见</td>
								<td colspan="3">
									<div class="jia">
										<select     class="di">
											<option value="无" >无</option>
											<s:iterator value="#auto.phzList" var="phz">
											<option value="${phz.name}" <c:if test="${phz.name eq VExam.deficiencyGuidance}">selected=selected</c:if> >${phz.name}</option>
                                       			 </s:iterator>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tchinamedicine.deficiencyGuidance" value="${VExam.deficiencyGuidance}" >
									</div>
								
								</td>
							</tr>
							<tr>
								<td>2、气虚质</td>
								<td colspan="3">
									<div class="jia">
										<select     class="di">
										 	<option value="有:" >有:</option>
											<option value="无"  selected="selected">无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tchinamedicine.qiDeficiency" value="${VExam.qiDeficiency}" >
									</div>
								<!-- <select name="tchinamedicine.qiDeficiency"
									id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.qiDeficiency}">selected=selected</c:if> >良好</option>
								</select> --> 
								</td>
								<td>指导意见</td>
								<td colspan="3">
									<div class="jia">
										<select     class="di">
											<option value="无" >无</option>
											<s:iterator value="#auto.qxzList" var="qxz">
											<option value="${qxz.name}" <c:if test="${qxz.name eq VExam.deficiencyGuidance}">selected=selected</c:if> >${qxz.name}</option>
											</s:iterator>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tchinamedicine.qiDeficiencyGuidance" value="${VExam.qiDeficiencyGuidance}" >
									</div>
								</td>
							</tr>
							<tr>
								<td>3、阳虚质</td>
								<td colspan="3">
									<div class="jia">
										<select     class="di">
											<option value="有:">有:</option>
											<option value="无"  selected="selected">无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tchinamedicine.yangDeficiency" value="${VExam.yangDeficiency}" >
									</div>
								<!-- <select name="tchinamedicine.yangDeficiency" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.yangDeficiency}">selected=selected</c:if> >良好</option>
								</select> -->
								</td>
								<td>指导意见</td>
								<td colspan="3">
									<div class="jia">
										<select     class="di">
											<option value="无" >无</option>
											 <s:iterator value="#auto.yangxzList" var="yangxz">
											 <option value="${yangxz.name}" <c:if test="${yangxz.name eq VExam.deficiencyGuidance}">selected=selected</c:if> >${yangxz.name}</option>
											
											 </s:iterator>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tchinamedicine.yangDeficiencyGuidance" value="${VExam.yangDeficiencyGuidance}" >
									</div>
								<!-- <select name="tchinamedicine.yangDeficiencyGuidance" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.yangDeficiencyGuidance}">selected=selected</c:if> >良好</option>
								</select>  -->
								</td>
							</tr>
							<tr>
								<td>4、阴虚质</td>
								<td colspan="3">
									<div class="jia">
										<select     class="di">
											<option value="有:">有:</option>
											<option value="无"  selected="selected">无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tchinamedicine.yingDecifiency" value="${VExam.yingDecifiency}" >
									</div>
								<!-- <select name="tchinamedicine.yingDecifiency" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.yingDecifiency}">selected=selected</c:if> >良好</option>
								</select> -->  
								</td>
								<td>指导意见</td>
								<td colspan="3">
									<div class="jia">
										<select     class="di">
											<option value="无" >无</option>
											<s:iterator value="#auto.yinxzList" var="yinxz">
											<option value="${yinxz.name}" <c:if test="${yinxz.name eq VExam.deficiencyGuidance}">selected=selected</c:if> >${yinxz.name}</option>
											
											</s:iterator>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tchinamedicine.yingDecifiencyGuidance" value="${VExam.yingDecifiencyGuidance}" >
									</div>
								<!-- <select
									name="tchinamedicine.yingDecifiencyGuidance" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.yingDecifiencyGuidance}">selected=selected</c:if> >良好</option>
								</select>  --> 
							</td>
							</tr>
							<tr>
								<td>5、痰湿质</td>
								<td colspan="3">
									<div class="jia">
										<select     class="di">
											<option value="有:">有:</option>
											<option value="无"  selected="selected">无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tchinamedicine.phlegmDampness" value="${VExam.phlegmDampness}" >
									</div>
								<!-- <select
									name="tchinamedicine.phlegmDampness" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.phlegmDampness}">selected=selected</c:if> >良好</option>
								</select>  -->
							</td>
								<td>指导意见</td>
								<td colspan="3">
									<div class="jia">
										<select     class="di">
											<option value="无" >无</option>
											<s:iterator value="#auto.tszList" var="tsz">
											<option value="${tsz.name}" <c:if test="${tsz.name eq VExam.deficiencyGuidance}">selected=selected</c:if> >${tsz.name}</option>
											
											</s:iterator>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tchinamedicine.phlegmDampnessGuidance" value="${VExam.phlegmDampnessGuidance}" >
									</div>
								<!-- <select
									name="tchinamedicine.phlegmDampnessGuidance" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.phlegmDampnessGuidance}">selected=selected</c:if> >良好</option>
								</select> -->
							</td>
							</tr>
							<tr>
								<td>6、湿热质</td>
								<td colspan="3">
									<div class="jia">
										<select     class="di">
											<option value="有:">有:</option>
											<option value="无"  selected="selected">无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tchinamedicine.dampHeatConstitution" value="${VExam.dampHeatConstitution}" >
									</div>
								<!-- <select
									name="tchinamedicine.dampHeatConstitution" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.dampHeatConstitution}">selected=selected</c:if> >良好</option>
								</select> --> 
							</td>
								<td>指导意见</td>
								<td colspan="3">
									<div class="jia">
										<select     class="di">
											<option value="无" >无</option>
											<s:iterator value="#auto.srzList" var="srz">
											<option value="${srz.name}" <c:if test="${srz.name eq VExam.deficiencyGuidance}">selected=selected</c:if> >${srz.name}</option>
											</s:iterator>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tchinamedicine.dampHeatConstitutionGuidance" value="${VExam.dampHeatConstitutionGuidance}" >
									</div>
								<!-- <select
									name="tchinamedicine.dampHeatConstitutionGuidance" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.dampHeatConstitutionGuidance}">selected=selected</c:if> >良好</option>
								</select>  -->
							</td>
							</tr>
							<tr>
								<td>7、血瘀质</td>
								<td colspan="3">
									<div class="jia">
										<select     class="di">
											<option value="有:">有:</option>
											<option value="无" selected="selected" >无</option>
										</select>
										<input maxlength="30"  type="text"   class="gai"  name="tchinamedicine.bloodySputum" value="${VExam.bloodySputum}" >
									</div>
									<!-- <select name="tchinamedicine.bloodySputum"
									id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.bloodySputum}">selected=selected</c:if> >良好</option>
									</select> -->  
								</td>
								<td>指导意见</td>
								<td colspan="3">
									<div class="jia">
										<select     class="di">
											<option value="无" >无</option>
										 <s:iterator value="#auto.xyzList" var="xyz">
										<option value="${xyz.name}" <c:if test="${xyz.name eq VExam.deficiencyGuidance}">selected=selected</c:if> >${xyz.name}</option>
										</s:iterator>	
											</select>
										<input maxlength="30" type="text"   class="gai" name="tchinamedicine.bloodySputumGuidance" value="${VExam.bloodySputumGuidance}" >
									</div>
								<!-- <select
									name="tchinamedicine.bloodySputumGuidance" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.bloodySputumGuidance}">selected=selected</c:if> >良好</option>
								</select>  -->
							</td>
							</tr>
							<tr>
								<td>8、气郁质</td>
								<td colspan="3">
									<div class="jia">
										<select     class="di">
											<option value="有:">有:</option>
											<option value="无" selected="selected" >无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tchinamedicine.qiStagnation" value="${VExam.qiStagnation}" >
									</div>
								<!-- <select name="tchinamedicine.qiStagnation"
									id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.qiStagnation}">selected=selected</c:if> >良好</option>
								</select>  -->
							</td>
								<td>指导意见</td>
								<td colspan="3">
									<div class="jia">
										<select     class="di">
											<option value="无" >无</option>
											  <s:iterator value="#auto.qyzList" var="qyz">
										<option value="${qyz.name}" <c:if test="${qyz.name eq VExam.deficiencyGuidance}">selected=selected</c:if> >${qyz.name}</option>
										</s:iterator>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tchinamedicine.qiStagnationGuidance" value="${VExam.qiStagnationGuidance}" >
									</div>
								<!-- <select name="tchinamedicine.qiStagnationGuidance" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.qiStagnationGuidance}">selected=selected</c:if> >良好</option>
								</select>  -->
							</td>
							</tr>
							<tr>
								<td>9、特禀质</td>
								<td colspan="3">
									<div class="jia">
										<select     class="di">
											<option value="有:">有:</option>
											<option value="无"  selected="selected">无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tchinamedicine.grasp" value="${VExam.grasp}" >
									</div>
								<!-- <select name="tchinamedicine.grasp" id="">
										<option value="">请选择</option>
										<option value="">项目1</option>
								</select> ${VExam.grasp} -->
								</td>
								<td>指导意见</td>
								<td colspan="3">
									<div class="jia">
										<select     class="di">
											<option value="无" >无</option>
										 <s:iterator value="#auto.tbzList" var="tbz">
										 <option value="${tbz.name}" <c:if test="${tbz.name eq VExam.deficiencyGuidance}">selected=selected</c:if> >${tbz.name}</option>
										</s:iterator>
										</select>
										<input maxlength="30" type="text"   class="gai" name="tchinamedicine.graspGuidance" value="${VExam.graspGuidance}" >
									</div>
								<!-- <select name="tchinamedicine.graspGuidance"
									id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.graspGuidance}">selected=selected</c:if> >良好</option>
								</select>  -->
							</td>
							</tr>
							<tr>
								<td colspan="8" class="title-td">现存主要健康问题</td>
							</tr>
							<tr>
								<td>脑血管疾病</td>
								<td colspan="3"><select
									name="thealthexting.cerebrovascularDisease" id="">
										<option value="">请选择</option>
										<s:iterator value="#auto.nxgjbList" var="nxgjb">
										<option value="${nxgjb.name}" <c:if test="${nxgjb.name eq VExam.cerebrovascularDisease}">selected=selected</c:if> >${nxgjb.name}</option>
										</s:iterator>
							</select> </td>
								<td>眼部疾病</td>
								<td colspan="3"><select
									name="thealthexting.ophthalmicDiseases" id="">
										<option value="">请选择</option>
										 <s:iterator value="#auto.ybjbList" var="ybjb">
										<option value="${ybjb.name}" <c:if test="${ybjb.name eq VExam.ophthalmicDiseases}">selected=selected</c:if> >${ybjb.name}</option>
										</s:iterator>
							</select> </td>
							</tr>
							<tr>
								<td>肾脏疾病</td>
								<td colspan="3"><select name="thealthexting.kidneyDisease"
									id="">
										<option value="">请选择</option>
										<s:iterator value="#auto.szjbList" var="szjb">
										<option value="${szjb.name}" <c:if test="${szjb.name eq VExam.kidneyDisease}">selected=selected</c:if> >${szjb.name}</option>
										</s:iterator>
							</select> </td>
								
								 <td>血管疾病</td>
                                       <td colspan="3">
                                       <select name="thealthexting.vascularDisease" id=""> 
                                       <option value="">请选择</option>
                                        <s:iterator value="#auto.xgjbList" var="xgjb">
                                        <option value="${xgjb.name}" <c:if test="${xgjb.name eq VExam.vascularDisease}">selected=selected</c:if> >${szjb.name}</option>
                                        </s:iterator>
                                       </select>
                                       </td>
								
								
								<tr>
								<td>心脏疾病</td>
								<td colspan="3"><select name="thealthexting.heartDiseases" id="">
										<option value="">请选择</option>
										 <s:iterator value="#auto.xzjbList" var="xz">
										<option value="${xz.name}" <c:if test="${xz.name eq VExam.heartDiseases}">selected=selected</c:if> >${xz.name}</option>
										</s:iterator>
							</select> </td>
								<td>神经系统疾病</td>
								<td colspan="3">
									<div class="jia">
										<select     class="di">
											<option value="">请选择</option>
											<option value="有:">有:</option>
											<option value="无" >无</option>
										</select>
										<input maxlength="30" type="text"   class="gai" name="thealthexting.nervousSystemDisease" value="${VExam.nervousSystemDisease}" >
									</div>
								<!-- <select
									name="thealthexting.nervousSystemDisease" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.nervousSystemDisease}">selected=selected</c:if> >良好</option>
								</select>  -->
							</td>
							</tr>
							<tr>
								
								<td>其他系统疾病</td>
								<td colspan="7">
									<div class="jia">
										<select     class="di">
											<option value="">请选择</option>
											<option value="有:">有:</option>
											<option value="无" >无</option>
										</select>
										<input maxlength="30"  type="text"   class="gai" name="thealthexting.otherNeurologicalDisorders" value="${VExam.otherNeurologicalDisorders}" >
									</div>
								<!-- <select
									name="thealthexting.otherNeurologicalDisorders" id="">
										<option value="">请选择</option>
										<option value="良好" <c:if test="${'良好' eq VExam.otherNeurologicalDisorders}">selected=selected</c:if> >良好</option>
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
								 <%-- <c:if test="${listTHospitalHistory.size()==0}"> --%>
								 <c:if test="${empty listTHospitalHistory}">
                                      <tr class="dyna-form">
                                     	<td><input class="dateInput1" type="text" name="listTHospitalHistory[0].admitHosTime" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"></td>
                                        <td><input class="dateInput2" type="text"  name="listTHospitalHistory[0].leaveHosTime" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"></td>
                                        <td><input type="text" name="listTHospitalHistory[0].reason"  class="w40 temp"></td>
                                        <td><input type="text" name="listTHospitalHistory[0].medicalInstitution"  class="w40 temp"></td>
                                        <td><input type="text" name="listTHospitalHistory[0].medicalRecordNum"  class="w40 temp"></td>
                                        <td colspan="3">
                                        	<a href="javascript:;" class="btn-del">删除</a>
                                        	<a href="javascript:;" class="btn-add">增加</a>
                                        </td>
                                      </tr>
								</c:if>
								<%-- <c:if test="${listTHospitalHistory.size()!=0}"> --%>
								<c:if test="${not empty listTHospitalHistory}">
                                      <s:iterator value="listTHospitalHistory" status="n" var="thh">
                                      <tr class="dyna-form">
                                     	<td>
                                     	 <input maxlength="100" type="text" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" name=listTHospitalHistory[0].admitHosTime value="<fmt:formatDate value="${thh.admitHosTime}" type='date' pattern='yyyy-MM-dd'/>" >
                                     	</td>
                                        <td>
                                        <input maxlength="100" type="text" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" name=listTHospitalHistory[0].leaveHosTime value="<fmt:formatDate value="${thh.leaveHosTime}" type='date' pattern='yyyy-MM-dd'/>" >
                                        </td>
                                        <td><input type="text" name="listTHospitalHistory[0].reason"  class="w40 temp" value="${thh.reason}">
                                        </td>
                                        <td><input type="text" name="listTHospitalHistory[0].medicalInstitution"  class="w40 temp" value="${thh.medicalInstitution}"></td>
                                        <td><input type="text" name="listTHospitalHistory[0].medicalRecordNum"  class="w40 temp" value="${thh.medicalRecordNum}"></td>
                                         <td colspan="3">
				                          <a href="javascript:;" class="btn-del">删除</a>
				                          <a href="javascript:;" class="btn-add">增加</a>
				                        </td>
                                      </tr>
                                      </s:iterator>
                                 </c:if>

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
							<c:if test="${listHF.size()==0}">
							<tr class="dyna-form">
                                        <td> <input class="dateInput1" type="text" name="listHF[0].createBedTime" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"></td>
                                        <td> <input class="dateInput2" type="text" name="listHF[0].revokeBedTime" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"></td>
                                        <td><input maxlength="20" type="text" name="listHF[0].reason"  class="w40 temp"></td>
                                        <td><input maxlength="20" type="text" name="listHF[0].medicalInstitution"  class="w40 temp"></td>
                                        <td><input maxlength="20" type="text" name="listHF[0].medicalRecordNum"  class="w40 temp"></td>
                                        <td colspan="3">
                                        	<a href="javascript:;" class="btn-del">删除</a>
                                        	<a href="javascript:;" class="btn-add">增加</a>
                                        </td>
                                      </tr>
							</c:if>
							<c:if test="${listHF.size()!=0}">
							<s:iterator value="listHF" var="thf">
							<tr class="dyna-form">
										<td>
										<input maxlength="20" type="text" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" name="listHF[0].createBedTime" value="<fmt:formatDate value="${thf.createBedTime}" type='date' pattern='yyyy-MM-dd'/>" >
										</td>
                                        <td>
                                        <input maxlength="20" type="text" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" name="listHF[0].revokeBedTime" value="<fmt:formatDate value="${thf.revokeBedTime}" type='date' pattern='yyyy-MM-dd'/>" >
                                        </td>
                                         <td><input type="text" name="listHF[0].reason"  class="w40 temp" value="${thf.reason}"></td>
                                        <td><input type="text" name="listHF[0].medicalInstitution"  class="w40 temp" value="${thf.medicalInstitution}"></td>
                                        <td><input type="text" name="listHF[0].medicalRecordNum"  class="w40 temp" value="${thf.medicalRecordNum}"></td>
                                        <td colspan="3">
                                        	<a href="javascript:;" class="btn-del">删除</a>
                                        	<a href="javascript:;" class="btn-add">增加</a>
                                        </td>
							</tr>
							</s:iterator>
							</c:if>

							
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
							<c:if test="${listTMedicalUse.size()==0}">
							 <tr class="dyna-form">
                                        <td><input maxlength="30" name="listTMedicalUse[0].medicalName" type="text"  class="w40 temp"></td>
                                        <td><input maxlength="30" name="listTMedicalUse[0].useMethod" type="text"  class="w40 temp"></td>
                                        <td><input maxlength="30" name="listTMedicalUse[0].useAccount" type="text"  class="w40 temp"></td>
                                        <td><input maxlength="30" type="text" name="listTMedicalUse[0].useTime" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"></td>
                                        <td><input maxlength="30" name="listTMedicalUse[0].medicalComl" type="text"  class="w40 temp"></td>
                                        <td colspan="3">
                                        	<a href="javascript:;" class="btn-del">删除</a>
                                        	<a href="javascript:;" class="btn-add">增加</a>
                                        </td>
                                      </tr>
							
							</c:if>
							<c:if test="${listTMedicalUse.size()!=0}">
							<s:iterator value="listTMedicalUse" var="tm">
							<tr class="dyna-form">
								 <td><input maxlength="30" name="listTMedicalUse[0].medicalName" type="text"  class="w40 temp" value="${tm.medicalName}"></td>
                                        <td><input maxlength="30"  name="listTMedicalUse[0].useMethod" type="text"  class="w40 temp" value="${tm.useMethod}"></td>
                                        <td><input maxlength="30" name="listTMedicalUse[0].useAccount" type="text"  class="w40 temp" value="${tm.useAccount}"></td>
                                        <td>
                                         <input maxlength="30" type="text" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" name="listTMedicalUse[0].useTime" value="<fmt:formatDate value="${tm.useTime}" type='date' pattern='yyyy-MM-dd'/>" >
                                        </td>
                                        <td><input maxlength="30" name="listTMedicalUse[0].medicalComl" type="text"  class="w40 temp" value="${tm.medicalComl}"></td>
                                        <td colspan="3">
                                        	<a href="javascript:;" class="btn-del">删除</a>
                                        	<a href="javascript:;" class="btn-add">增加</a>
                                        </td>
							</tr>
							</s:iterator>
							</c:if>
							
							<tr>
								<td colspan="8" class="title-td">非免疫规划预防接种史</td>
							</tr>
							<tr>
								<td>疫苗名称</td>
								<td>接种日期</td>
								<td>接种机构</td>
								<td colspan="5">操作</td>
							</tr>
						    <c:if test="${listTDefendInocu.size()==0}">
							<tr class="dyna-form">
                                        <td><input maxlength="30" name="listTDefendInocu[0].vaccineName" type="text"  class="w40 temp"></td>
                                        <td>
                                        <input maxlength="30" name="listTDefendInocu[0].vaccineTime" type="text" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
                                        </td>
                                        <td><input maxlength="30" name="listTDefendInocu[0].vaccineInstit" type="text"  class="w40 temp"></td>
                                        <td colspan="5">
                                        	<a href="javascript:;" class="btn-del">删除</a>
                                        	<a href="javascript:;" class="btn-add">增加</a>
                                        </td>
                             </tr>
							</c:if>
							
							<c:if test="${listTDefendInocu.size()!=0}">
							<s:iterator value="listTDefendInocu" var="tdi">
							<tr class="dyna-form">
								 <td><input name="listTDefendInocu[0].vaccineName" type="text"  class="w40 temp" value="${tdi.vaccineName}"></td>
                                        <td>
                                        <input  type="text" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" name="listTDefendInocu[0].vaccineTime" value="<fmt:formatDate value='${tdi.vaccineTime}' type='date' pattern='yyyy-MM-dd'/>" >
                                         </td>
                                        <td><input name="listTDefendInocu[0].vaccineInstit" type="text"  class="w40 temp" value="${tdi.vaccineInstit}"></td>
                                        <td colspan="5">
                                        	<a href="javascript:;" class="btn-del">删除</a>
                                        	<a href="javascript:;" class="btn-add">增加</a>
                                        </td>
							</tr>
							</s:iterator>
								</c:if>
							
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
                                        		<input maxlength="30" type="text"   class="gai" name="tphysicalexam.healthAssessment">
                                        	</div>
                                          <!-- <select name="tphysicalexam.healthAssessment" id="">
                                            <option value="">请选择</option>
                                            <option value="">项目1</option>
                                            <option value="">项目2</option>
                                          </select> -->
                                        </td>
                                        <td>
                                         <label>危险因素控制：</label>
                                        </td>
                                        <td>
                                          <select name="tphysicalexam.riskFactorControl" id="">
                                            <option value="">请选择</option>
                                             <s:iterator value="#auto.wxysList" var="wxys">
                                             <option value="${wxys.name}" <c:if test="${wxys.name eq VExam.cerebrovascularDisease}">selected=selected</c:if> >${wxys.name}</option>
                                        </s:iterator>
                                          </select>
                                        </td>
                                        <td>
                                          <label>健康指导：</label>
                                        </td>
                                        <td colspan="3">
                                          <select name="tphysicalexam.healthGuide" id="">
                                           <s:iterator value="#auto.jkzdList" var="jkzd">
                                         <option value="${jkzd.name}" <c:if test="${jkzd.name eq VExam.cerebrovascularDisease}">selected=selected</c:if> >${jkzd.name}</option>
                                        </s:iterator>
                                          </select>
                                        </td>
                                  </tr> 

						</tbody>
					</table>
					<div class="btn-content">
						<input id=" " type="submit" class="btn btn-xinzeng" value="提交"> 
						<input type="button" onclick="history.go(-1);" class="btn" value="返回">
						
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
		<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
		<script src="/jmjkms/js/laydate/laydate.js"></script>
		<script src="/jmjkms/js/base.js"></script>
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
</script>
<script type="text/javascript">
window.onload = function(){
					var di = document.getElementsByClassName("di");
					var gai = document.getElementsByClassName("gai");
					for (var i = 0; i < di.length; i++) {
							di[i].di = i;
								 (function(j){
								 /* 	gai[j].value = "无"; */
								 di[j].onchange = function(){
							gai[j].value = this.options[this.options.selectedIndex].value;
								 };	
							}(i));
					}
					}
</script>
<script type="text/javascript">
		var submit = document.getElementById('submit');
		var date1 = document.getElementsByClassName('dateInput1');  //获取起始日期input
		var date2 = document.getElementsByClassName('dateInput2');  //获取终止日期input
 	submit.onclick =function(){ 
			 var dateValue11 = date1[0].value;
			 var dateValue12 = date1[1].value;
			 var date1Arr1 = new Array();
			 	date1Arr1 = dateValue11.split("-");
			 var date1Arr2 = new Array();
			 	date1Arr2 = dateValue12.split("-");   //拆分两个起始时间
			 	
			 var dateValue21 = date2[0].value;
			 var dateValue22 = date2[1].value;
			 var date2Arr1 = new Array();
			 	date2Arr1 = dateValue21.split("-");
			 var date2Arr2 = new Array();
			 	date2Arr2 = dateValue22.split("-");  	//拆分两个终止时间
			if(date1Arr1[0]>date2Arr1[0]){
				alert("起止日期输入有误！");
			}
			else if(date1Arr1[0]=date2Arr1[0]){
				if(date1Arr1[1]>date2Arr1[1]){
					alert("起止日期输入有误！");
				}
				else if(date1Arr1[1]=date2Arr1[1]){
					if(date1Arr1[2]>date2Arr1[2]){
						alert("起止日期输入有误！");
					}
				}
			}
			return false;
  }  
</script>
<script type="text/javascript">
		var yt=(Number(${VExam.waistline}/${VExam.hip}));
		var tizhi=(Number(${VExam.weight}/(${VExam.height}*${VExam.height}/10000)));
		$("#ytbi").html((Number(yt).toFixed(2)));
		$("#tizhi").html((Number(tizhi).toFixed(2)));

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
</body>
</html>
