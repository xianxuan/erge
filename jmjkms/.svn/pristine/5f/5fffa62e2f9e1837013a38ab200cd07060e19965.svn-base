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
  <meta charset="UTF-8">
  <c:choose><c:when test="${session.comHospital.isHead==0}"><title>中电科社区健康管理平台</title></c:when><c:when test="${session.communityHospitalGroup!=null}"><title>社区健康管理系统</title></c:when><c:otherwise><title>社区健康服务站</title></c:otherwise></c:choose>
  <link rel="stylesheet" href="/jmjkms/css/confirm.css">
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
    <!-- 主容器 start -->
    <div class="container">
      <h3 class="current-title">员工信息添加</h3>
      <input name="yemianname" value=07201 type="hidden"/>
      <!--///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-->
      <!-- 结果容器 start -->
      <div class="table-content">
      <form  action="<%=basePath %>staffAction!addStaff.action" method="post" onsubmit="return checkall();" id="registerform">
     
        <table class="table table-bordered">
          <tbody> <input type="hidden" name="token" value="${token }" />
          <!--以下是一整行-->
           <tr><td colspan="4" class="title-td">员工基本信息</td></tr>
           
            <tr><!-- 这个要根据登录员工的信息进行显示 -->
              <td>单位：</td>
              <td>
				<c:if test="${session.comHospital != null }"> ${session.comHospital.communityHospital }</c:if>
                <c:if test="${session.comHospital == null }"> ${session.comHosName }</c:if>
              </td>
              <td><font color="red">*</font>身份证号：</td>
              <td>
              	<input type="text" name="staff.idCardNum" id="idcard" value="${idcard}" maxlength="20" placeholder="请输入身份证号" datatype="*" nullmsg="身份证号不可为空"
              	>
              	<span id="idcardSpan" ></span>
              </td>
            </tr>
            <tr>
              <td><font color="red">*</font>姓名：</td>
              <td>
              <input type="text" name="staff.name" value="${ staff.name}" id="name" maxlength="10"  
               /><span id="nameSpan"></span>
              </td>
              <td><font color="red">*</font>性别：</td>
              <td>
			    <input  type="radio"  name="staff.sex" value="false"><label >男</label>
			    <input type="radio"  name="staff.sex" value="true"><label>女</label>
			    <span id="rad"></span >
			   </td>
            </tr>
            	<s:action name="staffAction!getKWHZD" namespace="/" var="home"> </s:action>
            <tr>
              <td>员工编号：</td>
             <td>
             <label><font color="red"><c:out value="系统自动分配,请牢记您的编号"></c:out></font></label><span id= "staffNumberSpan"></span ></td>
              <td>状态：</td>
             <td> <select name="staff.state" id="">
                 <option value="5" <c:if test="${'5' eq staff.state}">selected</c:if>>在职</option>
               <option value="6" <c:if test="${'6' eq staff.state}">selected</c:if>>离职</option>
               <option value="3" <c:if test="${'3' eq staff.state}">selected</c:if>>退休</option>
                <option value="4" <c:if test="${'4' eq staff.state}">selected</c:if>>实习</option>
             </select>
             </td>
            </tr>
            <tr>
              <td><font color="red">*</font>联系电话：</td>
              <td><input type="text"   maxlength="15"  name="staff.phone" id="phone" value="${staff.phone }" ><span id= "phoneSpan"></span ></td>
              <td>毕业时间：</td>
              <td>
              <input type="text" name="staff.graduateDate" class="w150" value="<fmt:formatDate value='${staff.graduateDate}' pattern='yyyy-MM-dd'/>" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()"  >  
               </td>
            </tr>
               <tr>
              <td><font color="red">*</font>毕业 院校：</td>
              <td><input type="text" maxlength="20" name="staff.graduateSchool" id="graduateSchool" value="${ staff.graduateSchool}"  ><span id="graduateSchoolSpan"></span></td>
              <td>学历：</td>
             <td>  <select name="staff.eduBackground" id="">
                <option value="" <c:if test="${'' eq staff.eduBackground}">selected</c:if>>请选择</option>
                <option value="不详" <c:if test="${'不详' eq staff.eduBackground}">selected</c:if>>不详</option>
                <option value="博士" <c:if test="${'博士' eq staff.eduBackground}">selected</c:if>>博士</option>
            	<option value="硕士" <c:if test="${'硕士' eq staff.eduBackground}">selected</c:if>>硕士</option>
            	<option value="学士/本科" <c:if test="${'学士/本科' eq staff.eduBackground}">selected</c:if>>学士/本科</option>
            	<option value="大专" <c:if test="${'大专' eq staff.eduBackground}">selected</c:if>>大专</option>
            	<option value="中专" <c:if test="${'中专' eq staff.eduBackground}">selected</c:if>>中专</option>
            	<option value="高中" <c:if test="${'高中' eq staff.eduBackground}">selected</c:if>>高中</option>
            	<option value="初中" <c:if test="${'初中' eq staff.eduBackground}">selected</c:if>>初中</option>
            	<option value="小学" <c:if test="${'小学' eq staff.eduBackground}">selected</c:if>>小学</option>
            	<option value="文盲及半文盲" <c:if test="${'文盲及半文盲' eq staff.eduBackground}">selected</c:if>>文盲及半文盲</option>
                </select>
                </td>
            </tr>
            <tr>
              <td><font color="red" colspan="1">*</font>专业：</td>
              <td><input type="text" maxlength="20" name="staff.professional"  id="professional" value="${ staff.professional}"  ><span id="professionalSpan"></span></td>
              <td>出生日期：</td>
              <td><input type="text" maxlength="20" name="staff.birthDate" id="birthday" value="<fmt:formatDate value='${staff.birthDate}' pattern='yyyy-MM-dd'/>" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()"/></td>
            </tr>
            <tr>
							
				<td><span class="required"></span>地址</td>
				<td colspan="3">
				
				
					<div id="city_5">
						<select id="prov" class="prov" name="staff.province" >
						</select> <select id="city" class="city" name="staff.city" disabled="disabled"></select> 
						<select id="dist" class="dist" name="staff.county" disabled="disabled"></select>
						<input class="cityinput" name="staff.detailAddress"
							type="text" maxlength="20">
					</div> 
			</tr>
			
      <tr><td colspan="4" class="title-td">聘用信息</td></tr>
      <tr>
               <td><font color="red">*</font>职务：</td>
               <td> <select name="staff.job" id="job">
            	  <s:iterator value="#home.zw" var="zz">
            	  <option value="${zz.name }" <c:if test="${zz.name eq staff.job}">selected</c:if> ><c:out value="${zz.name }"></c:out></option>
            	  </s:iterator>
                </select>
                <span id="jobSpan"></span>
                </td>
               <td>入职时间：</td>
                <td>
              <input type="text"  value="<fmt:formatDate value='${staff.cometoOfficeDate}' pattern='yyyy-MM-dd'/>" name="staff.cometoOfficeDate" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()"
              >  
               </td>
        </tr>
        <tr>
           <td>聘用类型：</td>
               <td> <select name="staff.hireType" id="">
                 <s:iterator value="#home.pylx" var="pp">
               	 	<option value="${pp.name }" <c:if test="${ pp.name  eq staff.hireType}">selected</c:if>><c:out value="${pp.name }"></c:out></option>
                </s:iterator>
                </select>
                </td>
           <td>聘用到期时间：</td>
                <td>
              <input type="text" class="w150" name="staff.hireEndDate" value="<fmt:formatDate value='${staff.hireEndDate}' pattern='yyyy-MM-dd'/>"  onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()"
              >  
               </td>
        </tr>
       <tr>
			<td>部门：</td>
               <td> <select name="staff.department" id="">
               	<option value="诊疗部门" <c:if test="${'诊疗部门' eq staff.department}">selected</c:if>>诊疗部门</option>
               	<option value="辅助诊疗部门" <c:if test="${'辅助诊疗部门' eq staff.department}">selected</c:if>>辅助诊疗部门</option>
               	<option value="护理部门" <c:if test="${'护理部门' eq staff.department}">selected</c:if>>护理部门</option>
               	<option value="行政后勤部门" <c:if test="${'行政后勤部门' eq staff.department}">selected</c:if>>行政后勤部门</option>
                </select>
                </td>
           <td>聘开始期时间：</td>
                <td>
              <input type="text"  name="staff.hireStratDate" value="<fmt:formatDate value='${staff.hireStratDate}' pattern='yyyy-MM-dd'/>"  class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()"
              >  
               </td>
        </tr>

     <!--以下是一整行-->
     <tr><td colspan="4" class="title-td">职业资格相关信息</td></tr>
           <tr>
               <td>职业资格证书类型：</td>
                <td> <select name="staff.certificateType" id="">
               <s:iterator value="#home.zyzgzslx" var="yy">
               	<option value="${yy.name }" <c:if test="${yy.name eq staff.certificateType}">selected</c:if>><c:out value="${yy.name }"></c:out></option>
                </s:iterator>
                </select>
                </td>
               <td>职业资格证书编号：</td>
                <td>
              <input type="text" name="staff.cerificateNum" maxlength="20"  value="${staff.cerificateNum }"   />  
               </td>
        </tr>
        <tr>
           <td>职业资格证书名称：</td>
               <td>  <input type="text" name="staff.certificateName" maxlength="20" value="${staff.certificateName }"   />  
                </td>
        </tr>
          
 <!--以下是一整行-->
     <tr><td colspan="4" class="title-td">职称相关信息</td></tr>
         <tr>
               <td>职称等级：</td>
                <td> <select name="staff.jobTitleLevel" id="">
              	  <s:iterator value="#home.zcdj" var="dd">
                  	<option value="${dd.name }" <c:if test="${dd.name eq staff.jobTitleLevel}">selected</c:if>><c:out value="${dd.name }"></c:out></option>
                 </s:iterator>
                 </select>
                </td>
               <td>职称证书编号：</td>
                <td>
              <input type="text" name="staff.jobTitleNum" maxlength="20" value="${staff.jobTitleNum }"  />  
               </td>
        </tr>
        <tr>
           <td>职称证书：</td>
            <td><input type="text" name="staff.jobTitleCertificate" maxlength="20"  value="${ staff.jobTitleCertificate}"  />  </td>
        </tr>

 <!--以下是一整行-->
     <tr><td colspan="4" class="title-td">其他信息</td></tr>
             <tr>
               <td>是否取得全科医生培训证书：</td><!-- 写死的 -->
               <td> <select name="staff.gpTrain" id="">
               <option  selected = "selected" value="">请选择</option>
                  <option value="是" <c:if test="${'是' eq staff.gpTrain}">selected</c:if>>是</option>
                  <option value="否" <c:if test="${'否' eq staff.gpTrain}">selected</c:if>>否</option>
                </select>
                </td>
               <td>上岗培训开始时间：</td>
                <td>
              <input type="text" class="w150" name="staff.trainStratDate"  value="<fmt:formatDate value='${staff.trainStratDate}' pattern='yyyy-MM-dd'/>" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()"
              >  
               </td>
        </tr>
        <tr>
           <td>岗位：</td><!-- 这个也是在数据库取出来的  -->
                    <td> <select name="staff.station" id="">
                     <s:iterator value="#home.gw" var="gg">
                       <option value="${gg.name }" <c:if test="${gg.name eq staff.station}">selected</c:if>><c:out value="${gg.name }"></c:out></option>
                     </s:iterator>
                 </select>
                </td>
           <td>上岗培训结束时间：</td>
                <td>
              <input type="text" name="staff.trainEndDate"  value="<fmt:formatDate value='${staff.trainEndDate}' pattern='yyyy-MM-dd'/>" class="w150" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()"
              >  
               </td>
        </tr>      
          </tbody>
        </table>
        <input type="hidden" value="${staff.staffId }" name="" />
        <input type="hidden" value="${flag }" name="flag" />
        <div class="btn-content">
      <input type="submit" class="btn" value="保存">
         <a href=" javascript:history.go(0) " class="btn" id="news">重置</a>
          <a href="javascript:history.go(-1)" class="btn">返回</a>
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

<!-- 3级联动 -->
<script type="text/javascript" src="/jmjkms/js/threecity/jq.js"></script>
<script type="text/javascript" src="/jmjkms/js/threecity/jquery.cityselect.js"></script>
<script type="text/javascript" src="/jmjkms/js/threecity/location.js"></script>

<!-- 注意jquery只能引用一个 -->
<%-- <script src="/jmjkms/js/jquery-2.1.1.min.js"></script> --%>
<script type="text/javascript" src="/jmjkms/js/confirm/Validform_v5.3.2_min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>

<script type="text/javascript">
//检验手机号或者电话是否正确
	function checkTel(value){
		var isPhone = /^([0-9]{3,4}-)?[0-9]{7,8}$/;
		var isMob=/^((\+?86)|(\(\+86\)))?(13[012356789][0-9]{8}|15[012356789][0-9]{8}|18[02356789][0-9]{8}|147[0-9]{8}|1349[0-9]{7})$/;
		if(isMob.test(value)||isPhone.test(value)){
			return true;
		}else{
			return false;
		}
	}
</script>
	
<script type="text/javascript">

	var valueIdNum = document.getElementById('idcard');
	var valuePhone = document.getElementById('phone');
	/* 身份证号 */
	valueIdNum.onchange=function getValue(){
	 
		var getvalue = valueIdNum.value;
		  var result = isIdCard(getvalue);
		  
		  if(result == false){
			    alert("身份证号格式输入错误");
				$("#idcard").val("");
			}	
		 else if(checkIdNum(getvalue)==false){
		     return;
		 }; 
		 }
		 
	/* 电话 checkIdNum(getvalue) */
		valuePhone.onchange=function getValue(){
		
	    var getvalue = valuePhone.value;
		if(checkTel(getvalue)==false){
			 alert("请输入正确的固话或手机号码");
			 $("#phone").val("");
		}
	}	

</script>

<script type="text/javascript">
	function trim(str) { 
	    var strnew = str.replace(/^\s*|\s*$/g, ""); 
	    return strnew; 
	} 
	
		function checkIdNum(value){
		$.ajax({
			type : "post",
			url : "<%=basePath%>staffAction!checkIdNum.action?idcard="+value,
			dataType: "json",
			success : function(data) {
				if(data.checkResult=="no"){
					alert("此身份证号已注册");
					$("#idcard").val("");
					return false;
				}else{
					var txtparm = document.getElementById('idcard').value;
					if(txtparm.length==18)
					{
						   var year = txtparm.substring(6,10);
						   var month = txtparm.substring(10,12);
						   var date=txtparm.substring(12,14);
						   document.getElementById("birthday").value=year+"-"+month+"-"+date;
					}
				
				}
			}
		});
		
	} 
	
	function isIdCard(code) { 
            var city={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "};
            var tip = "";
            var pass= true;
            
            if(!code || !/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[12])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i.test(code)){
                tip = "身份证号格式错误";
                pass = false;
            }
            
           else if(!city[code.substr(0,2)]){
                tip = "地址编码错误";
                pass = false;
            }
            else{
                //18位身份证需要验证最后一位校验位
                if(code.length == 18){
                    code = code.split('');
                    //∑(ai×Wi)(mod 11)
                    //加权因子
                    var factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
                    //校验位
                    var parity = [ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 ];
                    var sum = 0;
                    var ai = 0;
                    var wi = 0;
                    for (var i = 0; i < 17; i++)
                    {
                        ai = code[i];
                        wi = factor[i];
                        sum += ai * wi;
                    }
                    var last = parity[sum % 11];
                    if(parity[sum % 11] != code[17]){
                        tip = "校验位错误";
                        pass =false;
                    }
                }
            }
           // if(!pass) alert(tip);
            return pass;
        }
</script>




<script type="text/javascript">
  function ValidateNumber(e, pnumber){
		if (!/^\d+$/.test(pnumber)){
			$(e).val(/^\d+/.exec($(e).val()));
		}
	return false ;
}
 function checkall(){
 
   	  var idcard = document.getElementById("idcard").value;
      var name = document.getElementById("name" ).value;
      var phone = document.getElementById("phone" ).value;
      var job = document.getElementById("job").value;
      var sex=$('input:radio[name="staff.sex"]:checked').val();
      //console.log(sex);
      var professional = document.getElementById("professional").value;
      var graduateSchool = document.getElementById("graduateSchool").value;
      var flag = 0;
      
      if (trim(idcard) == "" || !isIdCard(idcard) ) { 
          document.getElementById("idcardSpan" ).innerHTML = "<font color='red'>格式错误</font>"; 
          flag ++; 
      }else{
    	  document.getElementById("idcardSpan" ).innerHTML = "";
      }
      
      if (trim(name) == "" ) { 
             document.getElementById("nameSpan" ).innerHTML = "<font color='red'>姓名不可为空</font>"; 
             flag ++; 
      }else{
      	 document.getElementById("nameSpan" ).innerHTML = "";
      }
      if (trim(phone) == "" || checkTel(phone) == false) { 
          document.getElementById("phoneSpan" ).innerHTML = "<font color='red'>格式错误</font>"; 
          flag ++; 
   	  }else{
   	  	document.getElementById("phoneSpan" ).innerHTML = "";
   	  }
   	  if (trim(professional) == "" ) { 
          document.getElementById("professionalSpan" ).innerHTML = "<font color='red'>不可为空</font>"; 
          flag ++; 
   	  }else{
   	  	document.getElementById("professionalSpan" ).innerHTML = "";
   	  }
      if (trim(graduateSchool) == "" ) { 
          document.getElementById("graduateSchoolSpan" ).innerHTML = "<font color='red'>不可为空</font>"; 
          flag ++; 
   	  }else{
   	  	  document.getElementById("graduateSchoolSpan" ).innerHTML = "";
   	  }
   	  if (trim(job) == "" ) { 
          document.getElementById("jobSpan" ).innerHTML = "<font color='red'>不可为空</font>"; 
          flag ++; 
   	  }else{
   	   	  document.getElementById("jobSpan" ).innerHTML = ""; 
   	  }
	  if (sex==null) { 
	        document.getElementById("rad" ).innerHTML = "<font color='red'>性别不可为空</font>"; 
	        flag ++; 
	 }
   	  if(flag != 0){
   	  	 return false;
   	  }else{
   	  	 return true;
   	  }
     }
   //日期转字符串 返回日期格式20080808
     function dateToString(date) {
         if (date instanceof Date) {
             var year = date.getFullYear();
             var month = date.getMonth() + 1;
             month = month < 10 ? '0' + month: month;
             var day = date.getDate();
             day = day < 10 ? '0' + day: day;
             return year + month + day;
      }
         return '';
     }
     $(function(){
      $("#registerform").Validform({
        showAllError:false,
        tiptype:function(msg){          
          alert(msg);
        }
      });
  });
  
</script>

</body>
</html>
             