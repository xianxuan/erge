<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<!-- 主容器 start -->
		<div class="container">
		

			<div class="container">
			<input name="yemianname" value="08203" type="hidden"/>
				<h3 class="current-title">社区疾病状况分析</h3>
				<form
					action="<%=basePath%>statisticsAction!getComHosDiseaseAnalyse.action"
					method="post">
					<div class="search-content">
						<td colspan="8" class="title-td">所选医院： 
						<label id="box">
							<s:iterator value="selectHospitals" var="list">
									<input id="sq_1" type="hidden" name="communityHospitalIdList"
										value="${list.communityHospitalId}" />
									<label>${list.communityHospital}&nbsp;&nbsp;&nbsp;</label>
							</s:iterator>
						</label>
						<label style="display: none;" >
                            <s:iterator value="selectGroups" var="list">
                                <input  type="hidden" name="groupIdList"
                                    value="${list.GId}" />
                                <label>${list.groupName}&nbsp;&nbsp;&nbsp;</label>
                            </s:iterator>
                         </label>
						</td>
						<div class="search-item">
							<br> <label>请选择疾病种类：</label>
							<input id="laoren" type="checkbox" onclick="return checkAll(this)" ><label for="laoren">全选</label>
							<s:if test="diseasecjza=='残疾障碍'">
								<input id="cj_2" type="checkbox" name="chronicDiseaseIdList"
									value="'残疾障碍'" checked="checked" class="oldids">
								<label for="cj_2">残疾障碍</label>
							</s:if>
							<s:if test="diseasecjza==''">
                                <input id="cj_2" type="checkbox" name="chronicDiseaseIdList"
                                    value="'残疾障碍'"class="oldids">
                                <label for="cj_">残疾障碍</label>
                            </s:if>

                            <s:if test="diseasegxy==''">
                                <input id="gxy_2" type="checkbox" name="chronicDiseaseIdList"
                                    value="'高血压'"class="oldids">
                                <label for="gxy_2">高血压</label>
                            </s:if>

							<s:if test="diseasegxy=='高血压'">
								<input id="gxy_2" type="checkbox" name="chronicDiseaseIdList"
									value="'高血压'" checked="checked"class="oldids">
								<label for="gxy_2">高血压</label>
							</s:if>

							<s:if test="diseasetnb=='糖尿病'">
								<input id="tnb_2" type="checkbox" name="chronicDiseaseIdList"
									value="'糖尿病'" checked="checked"class="oldids">
								<label for="tnb_2">糖尿病</label>
							</s:if>
							<s:if test="diseasetnb==''">
                                <input id="tnb_2" type="checkbox" name="chronicDiseaseIdList"
                                    value="'糖尿病'"class="oldids">
                                <label for="tnb_2">糖尿病</label>
                            </s:if>

                            <s:if test="diseasegxb==''">
                                <input id="gxb_2" type="checkbox" name="chronicDiseaseIdList"
                                    value="'冠心病'"class="oldids">
                                <label for="gxb_2">冠心病</label>
                            </s:if>
							
							<s:if test="diseasegxb=='冠心病'">
                                <input id="gxb_2" type="checkbox" name="chronicDiseaseIdList"
                                    value="'冠心病'" checked="checked"class="oldids">
                                <label for="gxb_2">冠心病</label>
                            </s:if>

							<s:if test="diseasezxjsjb=='重性精神疾病'">
								<input id="jsjb_2" type="checkbox" name="chronicDiseaseIdList"
									value="'重性精神疾病'" checked="checked"class="oldids">
								<label for="jsjb_2">重性精神疾病</label>
							</s:if>
							<s:if test="diseasezxjsjb==''">
                                <input id="jsjb_2" type="checkbox" name="chronicDiseaseIdList"
                                    value="'重性精神疾病'"class="oldids">
                                <label for="jsjb_2">重性精神疾病</label>
                            </s:if>

                            <s:if test="diseasexnxgb==''">
                                <input id="xnxg_2" type="checkbox" name="chronicDiseaseIdList"
                                    value="'心脑血管病'"class="oldids">
                                <label for="xnxg_2">心脑血管病</label>
                            </s:if>

							<s:if test="diseasexnxgb=='心脑血管病'">
								<input id="xnxg_2" type="checkbox" name="chronicDiseaseIdList"
									value="'心脑血管病'" checked="checked"class="oldids">
								<label for="xnxg_2">心脑血管病</label>
							</s:if>

							<s:if test="diseasezl=='肿瘤'">
								<input id="zl_2" type="checkbox" name="chronicDiseaseIdList"
									value="'肿瘤'" checked="checked"class="oldids">
								<label for="zl_2">肿瘤</label>
							</s:if>
							<s:if test="diseasezl==''">
                                <input id="zl_2" type="checkbox" name="chronicDiseaseIdList"
                                    value="'肿瘤'"class="oldids">
                                <label for="zl_2">肿瘤</label>
                            </s:if>

                            <s:if test="diseasemxzqgb==''">
                                <input id="mxzqg_2" type="checkbox" name="chronicDiseaseIdList"
                                    value="'慢性支气管病'"class="oldids">
                                <label for="mxzqg_2">慢性支气管病</label>
                            </s:if>

							<s:if test="diseasemxzqgb=='慢性支气管病'">
								<input id="mxzqg_2" type="checkbox" name="chronicDiseaseIdList"
									value="'慢性支气管病'" checked="checked"class="oldids">
								<label for="mxzqg_2">慢性支气管病</label>
							</s:if>

						</div>
						<br>
						<div class="search-item">
							<label>时间区段</label> <select name="recent" id=""> <s:if
								test="recent=='最近一年'">
								<option value="最近一年" selected="selected">最近一年</option>
								<option value="最近两年">最近两年</option>
								</s:if>
								<s:elseif test="recent=='最近两年'">
								<option value="最近一年" >最近一年</option>
								<option value="最近两年"selected="selected">最近两年</option>
								</s:elseif>
								<s:else>
								<option value="最近一年" >最近一年</option>
								<option value="最近两年">最近两年</option>
								</s:else>
							</select>
						</div>

						<div class="btn-content">
							<input type="submit" value="查询"  class="btn btn-xianshi ">
						</div>
					</div>
				</form>
				<div id="jqprint">
					<div id="container1" style="min-width:400px;height:400px"></div>
					<div class="btn-content"></div>
					<div class="btn-content" style="text-align:center;">
					
					<a href="<%=basePath %>statisticsAction!staticticsList.action" class="btn">返回</a>
					</div>
				</div>
			</div>

		</div>


	</div>
	<!-- 主容器 end -->
	<!-- 底栏 Start-->
	<s:include value="/include/footer.jsp" />
	<!-- 底栏 Start-->



	<script src="/jmjkms/js/jquery-1.4.4.min.js"></script>
	<script src="/jmjkms/js/laydate/laydate.js"></script>
	<script src="/jmjkms/js/base.js"></script>
	<script src="/jmjkms/js/jquery.jqprint-0.3.js"></script>
	<script type="text/javascript"
		src="http://cdn.hcharts.cn/highcharts/highcharts.js"></script>
	<script type="text/javascript"
		src="http://cdn.hcharts.cn/highcharts/exporting.js"></script>
    <script type="text/javascript" src="/jmjkms/js/limittext.js"></script> 
    <script> 
        $(function show(){ 
            
            var box = document.getElementById("box"); 
            var text = box.innerHTML; 
            //var quanbu = "<font color=blue>...显示全部</font>";
            var newBox = document.createElement("label"); 
            var btn = document.createElement("a"); 
            btn.style="color:blue";
            newBox.innerHTML = text.substring(0,3200); //截取字符串200
            btn.innerHTML = text.length > 3200 ? "...显示全部" : ""; 
            //btn.href = "###"; 
            btn.href = "javascript:void(0)"; 
            btn.onclick = function(){ 
                //alert(btn.innerHTML);
                if (btn.innerHTML == "...显示全部"){ 
                        btn.innerHTML = "收起"; 
                        newBox.innerHTML = text; 
                }else{ 
                        btn.innerHTML = "...显示全部"; 
                        newBox.innerHTML = text.substring(0,3200); 
                } 
            } 
                box.innerHTML = ""; 
                box.appendChild(newBox); 
                box.appendChild(btn); 
        } );
    </script>
	<script type="text/javascript">
    $(document).ready(function(){
         if("${flag}"!="")
         {
         alert("${flag}");
         }
           hello();
    })
 
</script>
<script type="text/javascript">
var time =${time};
var cjza=${cjza};
var gxy=${gxy};
var tnb=${tnb};
var zxjsjb=${zxjsjb};
var gxb=${gxb};
var xnxgb=${xnxgb};
var zl=${zl};
var mxzqgb=${mxzqgb};

var obj=document.getElementsByName('chronicDiseaseIdList'); //选择所有name="'test'"的对象，返回数组 
var series = [];
    
if(obj[0].checked){series.push({"name":"残疾障碍","data":cjza})}
if(obj[1].checked){series.push({"name":"高血压","data":gxy})}
if(obj[2].checked){series.push({"name":"糖尿病","data":tnb})}
if(obj[3].checked){series.push({"name":"冠心病","data":gxb})}
if(obj[4].checked){series.push({"name":"重性精神疾病","data":zxjsjb})}
if(obj[5].checked){series.push({"name":"心脑血管病","data":xnxgb})}
if(obj[6].checked){series.push({"name":"肿瘤","data":zl})}
if(obj[7].checked){series.push({"name":"慢性支气管病","data":mxzqgb})}

function  hello(){
    $('#container1').highcharts({
            chart : {
                type : 'spline'
            },
            credits: {  
                enabled:false  
            },
            title : {
                text : '疾病比例曲线'
            },
            subtitle : {
                text : ''
            },
            xAxis : {
                categories : time
            },
            yAxis : {
                title : {
                    text : '人数'
                }
            },
            plotOptions : {
                line : {
                    dataLabels : {
                        enabled : true
                    },
                    enableMouseTracking : false
                }
            },
            series : series
        });
} 
 	
 	
</script>
<script type="text/javascript">
    	function checkAll(all){
    	
    		var allcli=document.getElementsByClassName("oldids");
    		
    		for(var i=0;i<allcli.length;i++){
    	
    			allcli[i].checked=all.checked;
    		}
    	}
    </script>
</body>
</html>