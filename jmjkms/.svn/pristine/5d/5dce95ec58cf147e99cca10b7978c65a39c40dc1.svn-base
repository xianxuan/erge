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
<%@taglib uri='/struts-tags' prefix='s'%>
<%@ page language="java"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.*"%>
<%
	String datetime = new SimpleDateFormat("yyyy-MM-dd")
			.format(Calendar.getInstance().getTime()); //获取系统时间
%>

<!DOCTYPE html>
<html lang="en">
<head><meta name="viewport" content="width=device-width, initial-scale=1.0"><meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta charset="UTF-8">
<c:choose><c:when test="${session.comHospital.isHead==0}"><title>中电科社区健康管理平台</title></c:when><c:when test="${session.communityHospitalGroup!=null}"><title>社区健康管理系统</title></c:when><c:otherwise><title>社区健康服务站</title></c:otherwise></c:choose>
<link rel="stylesheet" href="/jmjkms/css/cssreset.css">
<link rel="stylesheet" href="/jmjkms/css/main.css">
<link rel="stylesheet"
	href="/jmjkms/css/font-awesome-4.5.0/css/font-awesome.min.css">
<link type="text/css" href="/jmjkms/css/confirm.css">

<link rel="stylesheet" href="/jmjkms/select2/css/select2.css">
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
  input[type="text"].w50{
  width:66px;
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
		<form action="healthFileAction!addHealthFile.action" method="post"
					enctype="multipart/form-data" id="registerform"
					onsubmit="return dosubmit()">
		<!-- 主菜单 end -->
		<!-- 主容器 start -->
		<div class="container">


			<h3 class="current-title">健康档案添加</h3>
<!-- /////////////////////////////////////////////////////////////////////////////// -->
<!-- 搜索容器 start -->
  <div class="search-content">
    
     <div class="btn-content">
        <a id="change01" href="javascript:;" class="btn">基本信息</a>
        <a id="change02" href="javascript:;" class="btn btn-default">健康信息</a>
        <a id="change03" href="javascript:;" class="btn btn-default">用药记录</a>
        <input id="submit" value="保存" type="submit" class="btn " style="margin-left:650px;"> 
        <a  href="healthFileAction!showHealthFile.action" class="btn ">返回</a>
        <!-- <a id="" href="javascript:;" class="btn btn-default">全部保存</a> -->
      </div>
  </div>
   <!-- 搜索容器 start -->

<!-- /////////////////////////////////////////////////////////////////////////////// -->
      
      			
			
			
			
			
			
			<div id="table-content01" class="table-content">
				<input name="yemianname" value="01201" type="hidden" />
				<!-- 

				<form action="healthFileAction!addHealthFile.action" method="post"
					enctype="multipart/form-data" id="registerform"
					onsubmit="return dosubmit()"> -->

					<table class="table table-bordered">
						<tbody>
							<tr>
								<input type="hidden" name="token" value="${token }" />
								<td><span class="required">*</span>身份证号</td>
								<td><input type="text" id="idNum" name="healthFile.idNum"
									placeholder="请输入身份证号" datatype="*" nullmsg="身份证号不可为空"
									maxlength="18">
									<span id="idcardSpan"></span>
								</td>
								<td>居民档案编号<br>(若不输入则系统自动生成编号)
								</td>
								<td><input type="text" id="Auto" name="healthFile.fileNum"></td>
									
							</tr>
							<tr>
								<td><span class="required">*</span>姓名</td>

								<td><input id="Name" type="text" name="healthFile.name"
									datatype="*" nullmsg="姓名不可为空" maxlength="8"></td>

								<td><span class="required ">*</span>本人电话</td>
								<td><input id="IPhone" name="healthFile.IPhone" type="text"
									datatype="*" nullmsg="本人电话不可为空" errormsg="输入有误" maxlength="15">
								</td>
							</tr>
							<tr>
								<td><span class="required ">*</span><span class="required"></span>责任医生</td>
								<c:if test="${flag==false}">
									<td><select name="intId" class="js-example-basic-single"
										class="select2" style="width: 170px;" id="specialDoctor"
										maxlength="5" datatype="*" nullmsg="责任医生不可为空">
											<s:iterator value="specialDoctor" status="n" var="number">
												<option value="${number.staffId}"
													<c:if test="${tstaff.staffId eq number.staffId}">selected</c:if>>${number.name}</option>
											</s:iterator>
									    </select>
									</td>
								</c:if>
								<c:if test="${flag==true}">
									<td><input name="intId" type="hidden" class="NoAlter"
										value="${tstaff.staffId}"> <input type="text"
										class="NoAlter" value="${tstaff.name}">
									</td>
								</c:if>
								<td><span class="required">*</span><span class="required"></span>出生日期</td>
								<td><input name="healthFile.birthDate" type="text"
									id="birthDate" value=""
									onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
								</td>
							</tr>
							<tr>
								<td><span class="required"></span>乡镇（街道）名称</td>
								<td><input type="text" name="healthFile.currentOffice"
									maxlength="15">
								</td>
								<td><span class="required"></span>建档日期</td>
								<td><input type="text" name="healthFile.fileDate"
									id="datetime" value="${currentTime}"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
								</td>
							</tr>
							<tr>
								<td><span class="required"></span>村（居）委员名称</td>
								<td><input type="text"
									name="healthFile.currentResidentCommittee" maxlength="15">
								</td>
								<td><span class="required"></span>录入员</td>
								<c:if test="${flag==false}">
									<td><select name="healthFile.enterPeople"
										class="js-example-basic-single" class="select2"
										style="width: 170px;" id="">
											<s:iterator value="staffs" status="n" var="number">
												<%-- <option value="${number.name}" <c:if test="${tstaff.staffId eq number.staffId}">selected</c:if>>${number.name}</option> --%>
												<option value="${number.name}">${number.name}</option>
											</s:iterator>
										</select>
									</td>
								</c:if>
								<c:if test="${flag==true}">
									<td><input name="healthFile.enterPeople" class="NoAlter"
										value="${tstaff.name}">
									</td>
								</c:if>
							</tr>
							<tr>
								<td><span class="required"></span>建档人</td>
								<td colspan="3"><input type="text" class="NoAlter" value="${str}">
									<input type="hidden" name="healthFile.filePerson" value="${str}">
								</td>
							</tr>
							<tr>
								<td><span class="required"></span>户籍地址</td>
								<td colspan="3">
									<div id="city_5">
										<select id="prov" class="prov" name="healthFile.otherProvince" value="1"></select> <select id="city" class="city" name="healthFile.otherCity"
											disabled="disabled"></select> <select id="dist" class="dist"
											name="healthFile.otherCounty" disabled="disabled"></select>
										<input class="cityinput" name="healthFile.otherCommunity"
											type="text" maxlength="20">
									</div> 
								</td>
							</tr>
							<tr>
								<td><span class="required"></span>现住址</td>
								<td colspan="3">
									<div id="city_6">
										<select class="prov" name="healthFile.currentProvince"
											value="3"></select> <select class="city"
											name="healthFile.currentCity" disabled="disabled"></select> <select
											class="dist" name="healthFile.currentCounty"
											disabled="disabled"></select> <input
											name="healthFile.currentCommunity" type="text" maxlength="20">
									</div>
								</td>
							</tr>
							<tr>
								<td>照片</td>
								<td class="newleft04" colspan="3"><img id="first"
									src="/jmjkms/images/healthfile_default_pic.jpg" width="100px"
									height="100px"> <a href="javascript:" class="btn"
									onclick="document.getElementById('doc').click();">选择照片</a> <input
									type="file" name="upload" id="doc" style="display:none"
									onchange="javascript:setImagePreview();" />
								</td>
							</tr>
							<tr>
								<td><span class="required"></span>所在社区医院</td>
								<td>  
								<c:out value="${communityHospital.communityHospital}"></c:out>
                       			<input type="hidden" name="healthFile.hospital" value="${communityHospital.communityHospital}"> 
								</td>
								<td><span class="required"></span>建档单位</td>
								<td><input type="text" class="NoAlter"
									
									value="${communityHospital.communityHospital}" maxlength="15">
								</td>
								<input type="hidden" name="healthFile.workUnit" value="${communityHospital.communityHospital}">
							</tr>
							<tr>
								<td><span class="required"></span>联系人姓名</td>
								<td><input name="healthFile.otherName" type="text"
									maxlength="5"></td>
								<td><span class="required "></span>联系人电话</td>
								<td><input id="dianhua1" name="healthFile.otherPhone"
									type="text" errormsg="输入有误" maxlength="15">
								</td>
							</tr>
							<tr>
								<td>国籍</td>
								<td><input name="healthFile.country" type="text"></td>
								<td><span class="required"></span>性别</td>
								<td><select name="healthFile.sex" id="sex">
										<option value=false>男</option>
										<option value=true>女</option>

									</select>
								</td>

							</tr>
							<tr>
								<td>常驻类型</td>
								<td><select name="healthFile.permanentType" id="">
										<option value="0">户籍</option>
										<option value="1">非户籍</option>
									</select>
								</td>
								<td>民族</td>
								<td><select name="healthFile.nation" id="">
										<s:iterator value="mz" status="n" var="number">
											<option value="${number.name}">${number.name}</option>
										</s:iterator>
									</select>
								</td>
							</tr>
							<tr>
								<td>血型</td>
								<td><select name="healthFile.bloodTypr" id="">
										<option value="0">A型</option>
										<option value="1">B型</option>
										<option value="2">O型</option>
										<option value="3">AB型</option>
										<option value="4">不详</option>
									</select>
								</td>
								<td>RH阴性</td>
								<td><select name="healthFile.rhNegative" id="">
										<option value="0">否</option>
										<option value="1">是</option>
										<option value="2">不详</option>
									</select>
								</td>
							</tr>
							<tr>
								<td>职业</td>
								<td colspan="1"><select name="healthFile.job" id="">
										<s:iterator value="zy" status="n" var="number">
											<option value="${number.name}">${number.name}</option>
										</s:iterator>
									</select>
								</td>
								<td>工作单位</td>
								<td><input name="healthFile.work" type="text"></td>
							</tr>
							<tr>
								<td>婚姻状况</td>
								<td><select name="healthFile.maritalStatus" id="">
										<s:iterator value="hyzk" status="n" var="number">
											<option value="${number.name}">${number.name}</option>
										</s:iterator>
									</select>
								</td>
								<td>文化程度</td>
								<td><select name="healthFile.eduLevel" id="">
										<s:iterator value="whcd" status="n" var="number">
											<option value="${number.name}">${number.name}</option>
										</s:iterator>
									</select>
								</td>
							</tr>
							<tr>
								<td rowspan="2">医疗付费方式</td>
								<td colspan="3"><input type="checkbox" id="baoxian-01"
									name="medicalPayMethodName" value="城镇职工医疗保险"><label
									for="baoxian-01">城镇职工医疗保险</label> <input type="text"
									placeholder="请填写卡号" name="medicalPayMethodCardNum"> <input
									type="checkbox" id="baoxian-02" name="medicalPayMethodName"
									value="城镇居民医疗保险"><label for="baoxian-02">城镇居民医疗保险</label>
									<input type="text" placeholder="请填写卡号"
									name="medicalPayMethodCardNum"> <input type="checkbox"
									id="baoxian-03" name="medicalPayMethodName" value="新型农村合作医疗"><label
									for="baoxian-03">新型农村合作医疗</label> <input type="text"
									placeholder="请填写参合证" name="medicalPayMethodCardNum">
								</td>
							</tr>
							<tr>
								<td colspan="3"><input type="checkbox" id="pkjz"
									name="medicalPayMethodName" value="贫困救助"><label
									for="pkjz">贫困救助</label> <input type="checkbox" id="syylbx"
									name="medicalPayMethodName" value="商业医疗保险"><label
									for="syylbx">商业医疗保险</label> <input type="checkbox" id="qgf"
									name="medicalPayMethodName" value="全公费"><label
									for="qgf">全公费</label> <input type="checkbox" id="bfgf"
									name="medicalPayMethodName" value="部分公费"><label
									for="bfgf">部分公费</label> <input type="checkbox" id="qzf"
									name="medicalPayMethodName" value="全自费"><label
									for="qzf">全自费</label> <input type="checkbox" id="qita"
									name="medicalPayMethodName" value="其他"><label
									for="qita">其他</label>
								</td>
							</tr>
							<tr>
								<td>药物过敏史</td>
								<td colspan="3"><input class="check-wu" type="checkbox"
									value="无" name="choiceAllergyName" id="wu"><label
									for="wu">无</label> &nbsp;&nbsp;&nbsp;&nbsp;有： <input
									type="checkbox" value="青霉素" name="choiceAllergyName" id="qms"><label
									for="qms">青霉素</label> <input type="checkbox" value="磺胺"
									name="choiceAllergyName" id="ha"><label for="ha">磺胺</label>
									<input type="checkbox" value="链霉素" name="choiceAllergyName"
									id="lms"><label for="lms">链霉素</label> <input
									type="checkbox" value="其它" name="choiceAllergyName"
									id="qita-01"><label for="qita-01">其它</label> 
								</td>
							</tr>
							<tr>
								<td>暴露史</td>
								<td colspan="3"><input class="check-wu" type="checkbox"
									value="无" name="choiceExposeName" id="wu-01"><label
									for="wu-01">无</label> &nbsp;&nbsp;&nbsp;&nbsp;有： <input
									type="checkbox" value="化学品" name="choiceExposeName" id="hxp"><label
									for="hxp">化学品</label> <input type="checkbox" value="毒物"
									name="choiceExposeName" id="dw"><label for="dw">毒物</label>
									<input type="checkbox" value="射线" name="choiceExposeName"
									id="shexian"><label for="shexian">射线</label> 暴露史备注: <input
									name="healthFile.exposeNote" type="text">
								</td>
							</tr>
							<tr>
								<td colspan="4" class="title-td">个人基本身体信息</td>
							</tr>
							<tr>
								<td><span class="required"></span>身高</td>
								<td><input id="shengao" onkeyup="Num(this)" type="text"
									name="healthFile.height" class="w40"
									onkeyup="value=value.replace(/[^\d.]/g,'')" maxlength="3">cm
								</td>
								<td><span class="required"></span>体重</td>
								<td><input id="tizhong" onkeyup="Num(this)" type="text"
									name="healthFile.weihth" class="w40"
									onkeyup="value=value.replace(/[^\d.]/g,'')" maxlength="3">kg
								</td>
							</tr>
							<tr>
								<td><span class="required"></span>腰围</td>
								<td><input id="yaowei" onkeyup="Num(this)" type="text"
									name="healthFile.waistline" class="w40"
									onkeyup="value=value.replace(/[^\d.]/g,'')" maxlength="3">cm
								</td>
								<td><span class="required"></span>臀围</td>
								<td><input id="tunwei" onkeyup="Num(this)" type="text"
									name="healthFile.hipline" class="w40"
									onkeyup="value=value.replace(/[^\d.]/g,'')" maxlength="3">cm
								</td>
							</tr>
							<tr>
								<td><span class="required"></span>收缩压</td>
								<td><input id="shousuoya" onkeyup="Num(this)" type="text"
									name="healthFile.systolicBloodPressure" class="w40"
									onkeyup="value=value.replace(/[^\d.]/g,'')" maxlength="3">mmgh
								</td>
								<td><span class="required"></span>舒张压</td>
								<td><input id="shuzhangya" onkeyup="Num(this)" type="text"
									name="healthFile.diastolicBloodPressure" class="w40"
									onkeyup="value=value.replace(/[^\d.]/g,'')" maxlength="3">mmgh
								</td>
							</tr>
							<tr>
								<td><span class="required"></span>老人卡NFC编码</td>
								<td colspan="3">
									<input id="NFCbianma" type="text"
									value="${healthFile.nfc}" name="healthFile.nfc" maxlength="15">
								</td>
							</tr>
						</tbody>
        		</table>
						
	</div>					
<!--22222222222222222222222222222222222222222222222  -->	
<div id="table-content02" class="table-content" style="display:none;">
        <table class="table table-bordered">
          <tbody>  						
						 <tr>
                             <td colspan="4" class="title-td">生活方式</td>
                         </tr>
                                   <tr>
                                     <td>体育锻炼频率</td>
                                       <td>
                                       		<select name="tlifestyle.exerciseFrequency" id="" >
                                       		 <option value=" ">请选择</option> 
                                       			<s:iterator value="tydlplList" var="ty"> 
                                      		 <option value="${ty.name}">${ty.name}</option>
                                       </s:iterator>
                                       		</select>
                                       </td>
                                       <td>每次锻炼时间</td>
                                       <td><input maxlength="5" type="text" class="w40"  name="tlifestyle.exerciseTime">min</td> 
                                       </tr>
                                       <tr>
                                       <td>坚持锻炼时间</td>
                                       <td><input maxlength="5" type="text" class="w40"  name="tlifestyle.allExerciseTime">min</td> 
                                       <td>锻炼方式</td>
                                       <td>
                                       		<select name="tlifestyle.exerciseType" id="">
                                        		<option value="">请选择</option> 
                                        		<s:iterator value="dlfsList" var="dl"> 
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
                                       			<s:iterator value="ysxgList" var="ysxg"> 
                                      		 <option value="${ysxg.name}">${ysxg.name}</option>
                                       </s:iterator>
                                       		</select>
                                       </td> 
                                       <td>吸烟状况</td>
                                       <td>	
                                      
                                       		<select name="tlifestyle.smokingStatus" id="somke"  onclick="javascript:somker(this);"> 
                                       			<option value="">请选择</option>
                                        		<s:iterator value="xyzkList" var="xyzk"> 
                                      		 <option value="${xyzk.name}">${xyzk.name}</option>
                                       </s:iterator>
                                       		</select>
                                       </td>
                                       </tr>
                                       <tr>                                       
                                       <td>日吸烟量平均</td>
                                       <td><input maxlength="5" type="text" class="w40" id="somke1" name="tlifestyle.smokingOneday">根</td> 
                                       <td>开始吸烟年龄</td>
                                       <td><input maxlength="3" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" class="w40" id="somke2" name="tlifestyle.startsmokingAge">岁</td>  
                                   </tr>
                                   <tr>
                                       <td>戒烟年龄</td>
                                       <td><input maxlength="3" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text" class="w40" id="somke3" name="tlifestyle.giveupSmokingAge">岁</td>
                                        <td>饮酒频率</td>
<!-- /////////////////////////////////////--------------------- -->
                                       <td>
                                       		<select name="tlifestyle.drinkingFrequency" id="a" onclick="javascript:doit(this);"> 
                                       			<option value="">请选择</option> 
                                       			<s:iterator value="yjplList" var="yj"> 
                                      		 		<option value="${yj.name}">${yj.name}</option>
                                      			 </s:iterator>
                                       		</select>
                                       </td>
                                       </tr>
                                       <tr>
                                       <td>日饮酒量</td>
                                       <td><input maxlength="5" type="text" id="b" class="w40" name="tlifestyle.monthlyDrinking">两</td>
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
                                       <td><input maxlength="3" id="d" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"  type="text" class="w40" name="tlifestyle.startDrinkingAge">岁</td>
                                        <td>近一年内是否曾醉酒</td>
                                       <td><select name="tlifestyle.recentlyYearDrinking" id="e"> 
                                       <option value="false">否</option>
                                       <option value="true">是</option>
                                       </select>
                                       </td>
                                       </tr>
                                       <tr>
                                        <td>饮酒种类</td>
                                       <td colspan="1"><select name="tlifestyle.drinkingType" id="f"> 
                                       <option value="">请选择</option>
                                       <s:iterator value="yjzlList" var="yz"> 
                                      		 <option value="${yz.name}">${yz.name}</option>
                                       </s:iterator>
                                       </select>
                                       </td>
                                 
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
                                       </tr>
                                       <tr>
                                       <td>毒物种类</td>
                                       <td><input maxlength="20"  type="text" class="w40" name="tlifestyle.dust"></td>
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
                                       <td><input maxlength="20" type="text" class="w40" name="tlifestyle.radiogen"></td>
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
                                       </tr>
                                       <tr>
                                       <td>物理因素</td>
                                       <td><input maxlength="20" type="text" class="w40" name="tlifestyle.physicalFactor"></td>
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
                                       <td><input maxlength="20" type="text" class="w40" name="tlifestyle.chemicalSubstances"></td>
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
                                       </tr>
                                       <tr>
                                       <td>其他</td>
                                       <td><input maxlength="30" type="text" class="w40" name="tlifestyle.other"></td>
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
								<td colspan="4" class="title-td">既往史</td>
							</tr>
							<tr>
								<td rowspan="5">疾病</td>
								<td colspan="3"><input type="checkbox" name="diseaseName"
									value="无" id="no01"> <label for="no01">无</label></td>
							</tr>
							<tr>
								<td><input type="checkbox" name="diseaseName" value="冠心病"
									id="guanxinbing" class="nocheck"> <label
									for="guanxinbing">冠心病</label> <input class="not"
									name="diseaseTime" type="text" placeholder="请输入确诊时间"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
								</td>
								<td><input type="checkbox" name="diseaseName" value="高血压"
									id="gaoxueya" class="nocheck"> <label for="gaoxueya">高血压</label>
									<input class="not" name="diseaseTime" type="text"
									placeholder="请输入确诊时间"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
								</td>
								<td><input type="checkbox" name="diseaseName" value="糖尿病"
									id="tangniaobing" class="nocheck"> <label
									for="tangniaobing">糖尿病</label> <input class="not"
									name="diseaseTime" type="text" placeholder="请输入确诊时间"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
								</td>
							</tr>
							<tr>
								<td><input type="checkbox" name="diseaseName"
									value="慢性阻塞性肺疾病" id="mxzsxfjb" class="nocheck"> <label
									for="mxzsxfjb">慢性阻塞性肺疾病</label> <input class="not"
									name="diseaseTime" type="text" placeholder="请输入确诊时间"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
								</td>
								<td><input type="checkbox" name="diseaseName" value="恶性肿瘤"
									id="exzl" class="nocheck"> <label for="exzl">恶性肿瘤</label>
									<input class="not" name="diseaseTime" type="text"
									placeholder="请输入确诊时间"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
								</td>
								<td><input type="checkbox" name="diseaseName" value="脑卒中"
									id="naocuzhong" class="nocheck"> <label
									for="naocuzhong">脑卒中</label> <input class="not"
									name="diseaseTime" type="text" placeholder="请输入确诊时间"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
								</td>
							</tr>
							<tr>
								<td><input type="checkbox" name="diseaseName"
									value="重型精神疾病" id="zxjsjb" class="nocheck"> <label
									for="zxjsjb">重型精神疾病</label> <input class="not"
									name="diseaseTime" type="text" placeholder="请输入确诊时间"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
								</td>
								<td><input type="checkbox" name="diseaseName" value="结核病"
									id="jiehebing" class="nocheck"> <label for="jiehebing">结核病</label>
									<input class="not" name="diseaseTime" type="text"
									placeholder="请输入确诊时间"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
								</td>
								<td><input type="checkbox" name="diseaseName" value="肝炎"
									id="ganyan" class="nocheck"> <label for="ganyan">肝炎</label>
									<input class="not" name="diseaseTime" type="text"
									placeholder="请输入确诊时间"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
								</td>
							</tr>
							<tr>
								<td><input type="checkbox" name="diseaseName"
									value="其他法定传染病" id="qtfdcrb" class="nocheck"> <label
									for="qtfdcrb">其他法定传染病</label> <input class="not"
									name="diseaseTime" type="text" placeholder="请输入确诊时间"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
								</td>
								<td><input type="checkbox" name="diseaseName" value="职业病"
									id="zhiyebing" class="nocheck"> <label for="zhiyebing">职业病</label>
									<input class="not" name="diseaseTime" placeholder="请输入确诊时间"
									type="text"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
								</td>
								<td><input type="checkbox" name="diseaseName" value="其他"
									id="qita-02" class="nocheck"> <label for="qita-02">其他</label>
									<input class="not" name="diseaseTime" type="text"
									placeholder="请输入确诊时间"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD'})">
								</td>
							</tr>
							<tr>
								<td colspan="2">手术名称</td>
								<td>时间</td>
								<td>操作</td>
							</tr>
							<tr class="dyna-form">
								<td colspan="2"><input type="text"
									name="pastHistoryShouShuNameList"></td>
								<td><input type="text" name="pastHistoryShouShuTimeList"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"></td>
								<td><a href="javascript:;" class="btn-del">删除</a> <a
									href="javascript:;" class="btn-add">新增</a></td>
							</tr>
							<tr>
								<td colspan="2">外伤名称</td>
								<td>时间</td>
								<td>操作</td>
							</tr>
							<tr class="dyna-form">
								<td colspan="2"><input type="text"
									name="pastHistoryWaiShangNameList"></td>
								<td><input type="text" name="pastHistoryWaiShangTimeList"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"></td>
								<td><a href="javascript:;" class="btn-del">删除</a> <a
									href="javascript:;" class="btn-add">新增</a></td>
							</tr>
							<tr>
								<td colspan="2">输血原因</td>
								<td>时间</td>
								<td>操作</td>
							</tr>
							<tr class="dyna-form">
								<td colspan="2"><input type="text"
									name="pastHistoryShuXieNameList"></td>
								<td><input type="text" name="pastHistoryShuXieTimeList"
									onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"></td>
								<td><a href="javascript:;" class="btn-del">删除</a> <a
									href="javascript:;" class="btn-add">新增</a></td>
							</tr>
							<td colspan="4" class="title-td">家族史</td>
							</tr>
							<tr>
								<td>父亲</td>
								<td colspan="3"><input type="checkbox" name="choiceFather"
									value="无" id="wu-fq" class="check-wu"><label
									for="wu-fq">无</label> <input type="checkbox"
									name="choiceFather" value="冠心病" id="gxb-fq"><label
									for="gxb-fq">冠心病</label> <input type="checkbox"
									name="choiceFather" id="gxy-fq" value="高血压"><label
									for="gxy-fq">高血压</label> <input type="checkbox"
									name="choiceFather" id="tnb-fq" value="糖尿病"><label
									for="tnb-fq">糖尿病</label> <input type="checkbox"
									name="choiceFather" id="mxzs-fq" value="慢性阻塞性肺疾病"><label
									for="mxzs-fq">慢性阻塞性肺疾病</label> <input type="checkbox"
									name="choiceFather" id="zxjs-fq" value="重型精神疾病"><label
									for="zxjs-fq">重型精神疾病</label> <input type="checkbox"
									name="choiceFather" id="gy-fq" value="肝炎"><label
									for="gy-fq">肝炎</label> <input type="checkbox"
									name="choiceFather" id="jhb-fq" value="结核病"><label
									for="jhb-fq">结核病</label> <input type="checkbox"
									name="choiceFather" id="exzl-fq" value="恶性肿瘤"><label
									for="exzl-fq">恶性肿瘤</label> <input type="checkbox"
									name="choiceFather" id="ncz-fq" value="脑卒中"><label
									for="ncz-fq">脑卒中</label> <input type="checkbox"
									name="choiceFather" id="xtjx-fq" value="先天畸形"><label
									for="xtjx-fq">先天畸形</label> <!-- <input type="checkbox" name="choiceFather" id="qita-fq" value="其他"><label for="qita-fq">其他</label> -->
									其他：<input type="text" name="healthFile.one"></td>

							</tr>
							<tr>
								<td>母亲</td>
								<td colspan="3"><input type="checkbox" name="choiceMother"
									value="无" id="wu-fq1" class="check-wu"><label
									for="wu-fq1">无</label> <input type="checkbox"
									name="choiceMother" value="冠心病" id="gxb-fq1"><label
									for="gxb-fq1">冠心病</label> <input type="checkbox"
									name="choiceMother" id="gxy-fq1" value="高血压"><label
									for="gxy-fq1">高血压</label> <input type="checkbox"
									name="choiceMother" id="tnb-fq1" value="糖尿病"><label
									for="tnb-fq1">糖尿病</label> <input type="checkbox"
									name="choiceMother" id="mxzs-fq1" value="慢性阻塞性肺疾病"><label
									for="mxzs-fq1">慢性阻塞性肺疾病</label> <input type="checkbox"
									name="choiceMother" id="zxjs-fq1" value="重型精神疾病"><label
									for="zxjs-fq1">重型精神疾病</label> <input type="checkbox"
									name="choiceMother" id="gy-fq1" value="肝炎"><label
									for="gy-fq1">肝炎</label> <input type="checkbox"
									name="choiceMother" id="jhb-fq1" value="结核病"><label
									for="jhb-fq1">结核病</label> <input type="checkbox"
									name="choiceMother" id="exzl-fq1" value="恶性肿瘤"><label
									for="exzl-fq1">恶性肿瘤</label> <input type="checkbox"
									name="choiceMother" id="ncz-fq1" value="脑卒中"><label
									for="ncz-fq1">脑卒中</label> <input type="checkbox"
									name="choiceMother" id="xtjx-fq1" value="先天畸形"><label
									for="xtjx-fq1">先天畸形</label> <!-- <input type="checkbox" name="choiceMother" id="qita-fq1" value="其他"><label for="qita-fq1">其他</label> -->
									其他：<input type="text" name="healthFile.two"></td>
							</tr>
							<tr>
								<td>兄弟姐妹</td>
								<td colspan="3"><input type="checkbox" name="choiceBroSis"
									value="无" id="wu-fq2" class="check-wu"><label
									for="wu-fq">无</label> <input type="checkbox"
									name="choiceBroSis" value="冠心病" id="gxb-fq2"><label
									for="gxb-fq2">冠心病</label> <input type="checkbox"
									name="choiceBroSis" id="gxy-fq2" value="高血压"><label
									for="gxy-fq2">高血压</label> <input type="checkbox"
									name="choiceBroSis" id="tnb-fq2" value="糖尿病"><label
									for="tnb-fq2">糖尿病</label> <input type="checkbox"
									name="choiceBroSis" id="mxzs-fq2" value="慢性阻塞性肺疾病"><label
									for="mxzs-fq2">慢性阻塞性肺疾病</label> <input type="checkbox"
									name="choiceBroSis" id="zxjs-fq2" value="重型精神疾病"><label
									for="zxjs-fq2">重型精神疾病</label> <input type="checkbox"
									name="choiceBroSis" id="gy-fq2" value="肝炎"><label
									for="gy-fq2">肝炎</label> <input type="checkbox"
									name="choiceBroSis" id="jhb-fq2" value="结核病"><label
									for="jhb-fq2">结核病</label> <input type="checkbox"
									name="choiceBroSis" id="exzl-fq2" value="恶性肿瘤"><label
									for="exzl-fq2">恶性肿瘤</label> <input type="checkbox"
									name="choiceBroSis" id="ncz-fq2" value="脑卒中"><label
									for="ncz-fq2">脑卒中</label> <input type="checkbox"
									name="choiceBroSis" id="xtjx-fq2" value="先天畸形"><label
									for="xtjx-fq2">先天畸形</label> <!-- <input type="checkbox" name="choiceBroSis" id="qita-fq2" value="其他" ><label for="qita-fq2">其他</label> -->
									其他：<input type="text" name="healthFile.three"></td>
							</tr>
							<tr>
								<td>子女</td>
								<td colspan="3"><input type="checkbox" name="choiceChild"
									value="无" id="wu-fq3" class="check-wu"><label
									for="wu-fq">无</label> <input type="checkbox" name="choiceChild"
									value="冠心病" id="gxb-fq3"><label for="gxb-fq3">冠心病</label>
									<input type="checkbox" name="choiceChild" id="gxy-fq3"
									value="高血压"><label for="gxy-fq3">高血压</label> <input
									type="checkbox" name="choiceChild" id="tnb-fq3" value="糖尿病"><label
									for="tnb-fq3">糖尿病</label> <input type="checkbox"
									name="choiceChild" id="mxzs-fq3" value="慢性阻塞性肺疾病"><label
									for="mxzs-fq3">慢性阻塞性肺疾病</label> <input type="checkbox"
									name="choiceChild" id="zxjs-fq3" value="重型精神疾病"><label
									for="zxjs-fq3">重型精神疾病</label> <input type="checkbox"
									name="choiceChild" id="gy-fq3" value="肝炎"><label
									for="gy-fq3">肝炎</label> <input type="checkbox"
									name="choiceChild" id="jhb-fq3" value="结核病"><label
									for="jhb-fq3">结核病</label> <input type="checkbox"
									name="choiceChild" id="exzl-fq3" value="恶性肿瘤"><label
									for="exzl-fq3">恶性肿瘤</label> <input type="checkbox"
									name="choiceChild" id="ncz-fq3" value="脑卒中"><label
									for="ncz-fq3">脑卒中</label> <input type="checkbox"
									name="choiceChild" id="xtjx-fq3" value="先天畸形"><label
									for="xtjx-fq3">先天畸形</label> <!-- <input type="checkbox" name="choiceChild" id="qita-fq3" value="其他" ><label for="qita-fq3">其他</label> -->
									其他：<input type="text" name="healthFile.four"></td>
							</tr>
							<tr>
								<td>遗传病史</td>
								<td colspan="3"><input type="text"
									name="healthFile.geneticHistory" placeholder="无">(注明疾病名称)</td>
							</tr>
							<tr>
								<td>残疾情况</td>
								<td colspan="3"><input class="check-wu" type="checkbox"
									name="choiceDisabilityName" value="无残疾" id="wu-cjqk"><label
									for="wu-cjqk">无残疾</label> <input type="checkbox"
									name="choiceDisabilityName" value="视力残疾" id="gxb-cjqk"><label
									for="gxb-cjqk">视力残疾</label> <input type="checkbox"
									name="choiceDisabilityName" value="听力残疾" id="gxy-cjqk"><label
									for="gxy-cjqk">听力残疾</label> <input type="checkbox"
									name="choiceDisabilityName" value="言语残疾" id="tnb-cjqk"><label
									for="tnb-cjqk">言语残疾</label> <input type="checkbox"
									name="choiceDisabilityName" value="肢体残疾" id="mxzs-cjqk"><label
									for="mxzs-cjqk">肢体残疾</label> <input type="checkbox"
									name="choiceDisabilityName" value="智力残疾" id="zxjs-cjqk"><label
									for="zxjs-cjqk">智力残疾</label> <input type="checkbox"
									name="choiceDisabilityName" value="精神残疾" id="jhb-cjqk"><label
									for="jhb-cjqk">精神残疾</label> <input type="checkbox"
									name="choiceDisabilityName" value="其他残疾" id="exzl-cjqk"><label
									for="exzl-cjqk">其他残疾</label> 残疾证号 : <input
									name="healthFile.disabilitity" type="text"></td>
							</tr>
							<tr>
								<td colspan="4" class="title-td">生活环境</td>
							</tr>
							<tr>
								<td>厨房排风措施</td>
								<td><select name="healthFile.kitVenFac" id="">
										<s:iterator value="cfpfcs" status="n" var="number">
											<option value="${number.name}">${number.name}</option>
										</s:iterator>
								</select></td>
								<td>燃料类型</td>
								<td><select name="healthFile.fuelType" id="">
										<s:iterator value="rllx" status="n" var="number">
											<option value="${number.name}">${number.name}</option>
										</s:iterator>
								</select></td>
							</tr>
							<tr>
								<td>饮水</td>
								<td><select name="healthFile.drinkWater" id="">
										<s:iterator value="ys" status="n" var="number">
											<option value="${number.name}">${number.name}</option>
										</s:iterator>
								</select></td>
								<td>厕所</td>
								<td><select name="healthFile.toilet" id="">
										<s:iterator value="cs" status="n" var="number">
											<option value="${number.name}">${number.name}</option>
										</s:iterator>
								</select></td>
							</tr>
							<tr>
								<td>禽畜栏</td>
								<td colspan="3"><select name="healthFile.livestockBar"
									id="">
										<s:iterator value="qcl" status="n" var="number">
											<option value="${number.name}">${number.name}</option>
										</s:iterator>
								</select></td>

							</tr>
							<tr>
								<td>人群分类</td>
								<td colspan="3"><select name="healthFile.crowdClass" id="">
										<option value="0">健康人群</option>
										<option value="1">慢病高危人群</option>
										<option value="2">慢病患者人群</option>
								</select></td>
							</tr>

						</tbody>
					</table>
			</div>
<!--3333333333333333333333333333333333333333  -->
<div id="table-content03" class="table-content" style="display:none;">
        <table class="table table-bordered">
          <tbody>  
 				<tr><td colspan="8" class="title-td">用药记录</td></tr>         
			    <tr>
			         <td >药物名称</td>
                     <td>用法</td>
                     <td>用量</td>
                     <td>开始用药时间</td>
                     <td>服药依从性</td>
                     <td>不良反应</td>
                     <td>药品来源</td>
                     <td>操作</td>
			    </tr>
			    <tr class="dyna-form">
			         <td><input type="text" name="fileMedicalListName"></td>
                        <td><input class="w50" type="text" name="fileMedicalListUsages"></td>
                        <td><input class="w50" type="text" name="fileMedicalListDosage"></td>
                        <td><input class="w50" type="text" name="fileMedicalListBegin" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"></td>
                        <td><input class="w50" type="text" name="fileMedicalListMedicationAdherence"></td>
                        <td><input class="w50" type="text" name="fileMedicalListUntowardEffect"></td>
                        <td><input class="w50" type="text" name="fileMedicalListDrugSources"></td>
			        <td>
			             <a href="javascript:;" class="btn-del">删除</a>
			             <a href="javascript:;" class="btn-add">新增</a>
			         </td>
			     </tr> 
			</tbody>
	    </table>
</div>       
<!--333333333333333333333333333333333333333333  -->
		
</div><!-- container -->
	
		<s:include value="/include/footer.jsp" />
		</form>

	</div><!-- main-content -->
	<!-- 3级联动 -->
	<script type="text/javascript" src="/jmjkms/js/threecity/jq.js"></script>
	<script type="text/javascript" src="/jmjkms/js/threecity/jquery.cityselect.js"></script>
	<script type="text/javascript" src="/jmjkms/js/threecity/location.js"></script>

	<!-- 根据身份证号 获得户籍地址 -->
	<script type="text/javascript" src="/jmjkms/js/id_card_area.js"></script>

	<!-- 3级联动 -->
	<%-- <script src="/jmjkms/js/jquery-2.1.1.min.js"></script> --%>
	<script type="text/javascript" src="/jmjkms/js/confirm/Validform_v5.3.2_min.js"></script>
	<script src="/jmjkms/js/laydate/laydate.js"></script>
	<script src="/jmjkms/js/base.js"></script>
	<script type="text/javascript">
//change01
$("#change01").click(
    function(){
        $("#change01").removeClass("btn-default");
        $("#change02").addClass("btn-default");
        $("#change03").addClass("btn-default");
        $("#table-content01").show();
        $("#table-content02").hide();
        $("#table-content03").hide();
       
        }
    );
//change02
$("#change02").click(function(){
        $("#change02").removeClass("btn-default");
        $("#change01").addClass("btn-default");
        $("#change03").addClass("btn-default");
        $("#table-content02").show();
        $("#table-content01").hide();
        $("#table-content03").hide();
       
        
    });
//change03
$("#change03").click(function(){
        $("#change03").removeClass("btn-default");
        $("#change02").addClass("btn-default");
        $("#change01").addClass("btn-default");
        $("#table-content03").show();
        $("#table-content01").hide();
        $("#table-content02").hide();
        
        
    });
</script>
	<script type="text/javascript">
		$(function() {
			$("#registerform").Validform({
				//btnSubmit:".btn_sub",
				showAllError : false,
				tiptype : function(msg) {
					alert(msg);
				}
			});
		});
	</script>
	<script type="text/javascript">
		$(function() {
			$("form").submit(function() {
				var flag = false;
				flag = yitiji();
				if (flag) {
					var form = document.getElementById("registerform");
					return true;
				}
			});
		});
		function yitiji() {
			var flag = false;
			var uname = document.getElementById("IPhone").value;
			var rname = document.getElementById("Name").value;
			var height = document.getElementById("shengao").value;
			var weight = document.getElementById("tizhong").value;
			var yaowei = document.getElementById("yaowei").value;
			var tunwei = document.getElementById("tunwei").value;
			//var shousuoya=document.getElementById("shousuoya").value;
			//var shuzhangya=document.getElementById("shuzhangya").value;
			var nfc = document.getElementById("NFCbianma").value;
			var idcard = document.getElementById("idNum").value;
			var sex = document.getElementById("sex").value;
			var birthday = document.getElementById("birthDate").value;
			$.ajax({
				type : "POST", //请求方式  
				url : "healthFileAction!register.action", //请求路径 
				data : {
					"uname" : uname,
					"rname" : rname,
					"height" : height,
					"weight" : weight,
					"yaowei" : yaowei,
					"tunwei" : tunwei,
					"nfc" : nfc,
					"idcard" : idcard,
					"sex" : sex,
					"birthday" : birthday,
				},
				dataType : "json", //返回值类型  
				async : false,
				success : function(results) {
					if (results == "0" || results == "1") {
						flag = true;
						//alert("一体机注册成功");
					} else {
						//alert("网络连接错误,请稍后重试");
						flag = false;
						;
					}

				},
				error : function() {
					//alert("网络连接错误,请稍后重试");
				}
			});
			return flag;
		}
	</script>

	<script type="text/javascript">
		//下面用于图片上传预览功能
		function setImagePreview(avalue) {
			var docObj = document.getElementById("doc");

			var imgObjPreview = document.getElementById("first");
			if (docObj.files && docObj.files[0]) {
				//火狐下，直接设img属性
				//imgObjPreview.style.display = 'block';
				imgObjPreview.style.width = '100px';
				imgObjPreview.style.height = '100px';

				checkPic(docObj.value);
				//imgObjPreview.src = docObj.files[0].getAsDataURL();

				//火狐7以上版本不能用上面的getAsDataURL()方式获取，需要一下方式
				imgObjPreview.src = window.URL.createObjectURL(docObj.files[0]);
			} else {
				//IE下，使用滤镜
				docObj.select();
				var imgSrc = document.selection.createRange().text;
				var localImagId = document.getElementById("imgdiv");
				//必须设置初始大小
				localImagId.style.width = "100px";
				localImagId.style.height = "100px";
				//图片异常的捕捉，防止用户修改后缀来伪造图片
				try {
					localImagId.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
					localImagId.filters
							.item("DXImageTransform.Microsoft.AlphaImageLoader").src = imgSrc;
				} catch (e) {
					alert("您上传的图片格式不正确，请重新选择!");
					return false;
				}
				imgObjPreview.style.display = 'none';
				document.selection.empty();
			}
			return true;
		}
		//检查图片格式是否正确
		function checkPic(value) {

			$.ajax({
				type : "post",
				url : "healthFileAction!checkPic.action?picStr=" + value,
				dataType : "json",
				success : function(data) {

					if (data.checkResult == "no") {
						alert("照片格式不正确");

					}
				}
			});

		}
		//用于自动获取健康档案编号
		function showFileNumAuto() {

			$.ajax({
				type : "post",
				url : "healthFileAction!getFileNumAuto.action",
				dataType : "json",
				success : function(data) {

					$("#Auto").val(data.fileNumAuto);

				}
			});

		}
	</script>
	<script type="text/javascript">
		var valuePhone = document.getElementById('IPhone');
		var valuePhone1 = document.getElementById('dianhua1');
		var valueInput = document.getElementById('Auto');
		var valueIdNum = document.getElementById('idNum');

		valueInput.onchange = function getValue() {

			var getvalue = valueInput.value;

			checkFileNum(getvalue);
		}

		/* 身份证号 */
		valueIdNum.onchange = function getValue() {

			var getvalue = valueIdNum.value;

			//var result = isIdCard(getvalue);
			var result=true;//身份证的格式校验放进checkIdNum方法中了
			if (result == false) {
				alert("身份证号格式输入错误");
				$("#idNum").val("");
			} else if (checkIdNum(getvalue) == false) {
				return;
			} else {
				return;
				/* var birthDate = getBirthDate(getvalue);
				//	alert(birthDate);
				$("#birthDate").val(birthDate); */
			}
			;
		}
		/* 电话 checkIdNum(getvalue) */
		valuePhone.onchange = function getValue() {
			var getvalue = valuePhone.value;
			checkIphone(getvalue);

			if (checkTel(getvalue) == false) {
				alert("请输入正确的固话或手机号码");
				$("#IPhone").val("");
				return;
			}

		}
		valuePhone1.onchange = function getValue() {
			var getvalue = valuePhone1.value;
			if (checkTel(getvalue) == false) {
				alert("请输入正确的固话或手机号码");
				$("#dianhua1").val("");
			}
		}
	</script>
	<script>
		function checkFileNum(value) {
			$.ajax({
				type : "post",
				url : "healthFileAction!checkFileNum.action?fileNum=" + value,
				dataType : "json",
				success : function(data) {
					if (data.checkResult == "no") {
						alert("此健康档案编号已存在");
						$("#Auto").val("");
					}
					if (data.checkResult == "geshi") {
						alert("此健康档案编号格式错误");
						$("#Auto").val("");
					}
				}
			});

		}
		function checkIphone(value) {
			$.ajax({
				type : "post",
				url : "healthFileAction!checkIphone.action?iphone=" + value,
				dataType : "json",
				success : function(data) {

					if (data.checkResult == "no") {
						alert("此固话/手机号码已注册");
						$("#IPhone").val("");
						return false;
					} else {

						return true;
					}

				}
			});

		}
		function checkIdNum(value) {
			$.ajax({
				type : "post",
				url : "healthFileAction!checkIdNum.action?idNum=" + value,
				dataType : "json",
				success : function(data) {
					if (data.checkResult == "no") {
						alert("此身份证号已注册");
						$("#idNum").val("");
						return false;
					} else if(data.checkResult == "false"){
						alert("此身份证号格式错误");
						$("#idNum").val("");
						return false;
					}
					else {
						var txtparm = document.getElementById('idNum').value;
						if (txtparm.length == 18) {
							var year = txtparm.substring(6, 10);
							var month = txtparm.substring(10, 12);
							var date = txtparm.substring(12, 14);
							
							document.getElementById("birthDate").value = year
									+ "-" + month + "-" + date;
									
							var results=[];
						   results=id_card_area.getAreaByIdCard(txtparm);
						   var select = [];
						   select[0]= document.getElementById("prov"); 
						   $("#prov").val(results[0]);
						   $("#prov").change();
						   $("#city").val(results[1]);
						   $("#city").change();
						   $("#dist").val(results[2]);
						}
						if (txtparm.length == 15) {
							var year = txtparm.substring(6, 8);
							var month = txtparm.substring(8, 10);
							var date = txtparm.substring(10, 12);
							document.getElementById("birthDate").value = "19"+year
									+ "-" + month + "-" + date;
							
							var results=[];
						   results=id_card_area.getAreaByIdCard(txtparm);
						   var select = [];
						   select[0]= document.getElementById("prov"); 
						   $("#prov").val(results[0]);
						   $("#prov").change();
						   $("#city").val(results[1]);
						   $("#city").change();
						   $("#dist").val(results[2]);
						}
					}
				}
			});

		}

		function getBirthDate(value) {
			$.ajax({
				type : "post",
				url : "healthFileAction!getBirthDate.action?idNum=" + value,
				dataType : "json",
				success : function(data) {
					$("#birthDate").val(data.birthDateResult);
					return data.birthDateResult;

				}
			});

		}
		//从工具类里调用15/18位身份证号校验
		function isIdCard(value){
		
		$.ajax({
				type : "post",
				url : "healthFileAction!isIdCard.action?idNum=" + value,
				dataType : "json",
				success : function(data) {
					if (data.checkResult == "no") {
						return false;
					} else {
						return true;
					}

				}
			});
		}
		//风双写的身份证校验，可以进行18位身份证号的校验
		/* function isIdCard(code) {
			var city = {
				11 : "北京",
				12 : "天津",
				13 : "河北",
				14 : "山西",
				15 : "内蒙古",
				21 : "辽宁",
				22 : "吉林",
				23 : "黑龙江 ",
				31 : "上海",
				32 : "江苏",
				33 : "浙江",
				34 : "安徽",
				35 : "福建",
				36 : "江西",
				37 : "山东",
				41 : "河南",
				42 : "湖北 ",
				43 : "湖南",
				44 : "广东",
				45 : "广西",
				46 : "海南",
				50 : "重庆",
				51 : "四川",
				52 : "贵州",
				53 : "云南",
				54 : "西藏 ",
				61 : "陕西",
				62 : "甘肃",
				63 : "青海",
				64 : "宁夏",
				65 : "新疆",
				71 : "台湾",
				81 : "香港",
				82 : "澳门",
				91 : "国外 "
			};
			var tip = "";
			var pass = true;

			if (!code
					|| !/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[12])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i
							.test(code)) {
				tip = "身份证号格式错误";
				pass = false;
			}

			else if (!city[code.substr(0, 2)]) {
				tip = "地址编码错误";
				pass = false;
			} else {
				//18位身份证需要验证最后一位校验位
				if (code.length == 18) {
					code = code.split('');
					//∑(ai×Wi)(mod 11)
					//加权因子
					var factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5,
							8, 4, 2 ];
					//校验位
					var parity = [ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 ];
					var sum = 0;
					var ai = 0;
					var wi = 0;
					for (var i = 0; i < 17; i++) {
						ai = code[i];
						wi = factor[i];
						sum += ai * wi;
					}
					var last = parity[sum % 11];
					if (parity[sum % 11] != code[17]) {
						tip = "校验位错误";
						pass = false;
					}
				}
			}
			// if(!pass) alert(tip);
			return pass;
		} */
		//日期转字符串 返回日期格式20080808
		function dateToString(date) {
			if (date instanceof Date) {
				var year = date.getFullYear();
				var month = date.getMonth() + 1;
				month = month < 10 ? '0' + month : month;
				var day = date.getDate();
				day = day < 10 ? '0' + day : day;

				alert("内部year" + year);
				alert("内部month" + month);
				alert("内部day" + day);
				return year + month + day;
			}
			return '';
		}
	</script>
	<script type="text/javascript">
		
			//让所在社区医院的输入框为不可修改
			var Oinput = document.getElementsByClassName("NoAlter");
			// alert(Oinput.length);
			for (var i = 0; i < Oinput.length; i++) {
				Oinput[i].disabled = true;
			}

			//既往史
			var no01 = document.getElementById("no01");
			var Onot = document.getElementsByClassName("not");
			var nocheck = document.getElementsByClassName("nocheck");
			no01.onclick = function() {
				if (this.checked) {
					for (var i = 0; i < Onot.length; i++) {
						Onot[i].disabled = true;
						nocheck[i].disabled = true;
						nocheck[i].checked = false;
						//Onot[i].placeholder="请输入确诊时间";
						Onot[i].style.display = "none";
					}
				} else {
					for (var j = 0; j < Onot.length; j++) {
						Onot[j].disabled = false;
						nocheck[j].disabled = false;
						//Onot[j].style.display="block";

					}
				}
			}

		
	</script>
	<script>
		$(function() {
			$('.not').hide();
			$('.nocheck').click(function() {
				if ($(this).is(':checked')) {
					$(this).siblings('.not').show();
				} else {
					$(this).siblings('.not').hide();
				}
			});
			$('.check-wu').click(function() {
				if ($(this).is(':checked')) {
					$(this).siblings('input').attr('disabled', true);
					$(this).siblings('input').removeAttr('checked');
				} else {
					$(this).siblings('input').attr('disabled', false);
				}

			});
		});
	</script>

	<script type="text/javascript">
		function checkTel(value) {
			var isPhone = /^([0-9]{3,4}-)?[0-9]{7,8}$/;
			var isMob = /^((\+?86)|(\(\+86\)))?(13[012356789][0-9]{8}|15[012356789][0-9]{8}|18[02356789][0-9]{8}|147[0-9]{8}|1349[0-9]{7})$/;

			if (isMob.test(value) || isPhone.test(value)) {
				return true;
			} else {
				return false;
			}
		}
	</script>
	<script>
		function Num(obj) {
			obj.value = obj.value.replace(/[^\d.]/g, "");
			obj.value = obj.value.replace(/^\./g, "");
			obj.value = obj.value.replace(/\.{2,}/g, ".");
			obj.value = obj.value.replace(".", "$#$").replace(/\./g, "")
					.replace("$#$", ".");
		}
	</script>

	<script src="/jmjkms/select2/js/select2.full.js"></script>


	<script type="text/javascript">
		$(function() {
			$(".js-example-basic-single").select2();
		})
	</script>

	<!--  防止表单提交 -->
	<script type="text/javascript">
		var isCommitted = false;//表单是否已经提交标识，默认为false
		function dosubmit() {
			/* 此处还需要判断各个必填项校验是否通过*/
			//alert("1" + isCommitted);
			if (isCommitted == false
					&& document.getElementById('idNum').value != ""
					&& document.getElementById('Name').value != ""
					&& document.getElementById('IPhone').value != ""
					&& document.getElementById('birthDate').value != ""
					&& document.getElementById('specialDoctor').value != "") {
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
	</script>

	<script type="text/javascript">
	$("#registerform").submit(function(){
		if($("#birthDate").val()==""&&$("#idNum").val()!=""){
			alert("出生日期不可为空")
			return false;
			
		}
	})
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

  
</body>

</html>
