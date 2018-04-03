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
  <link type="text/css" href="jmjkms/css/yang/confirm.css">
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
  <input name="yemianname" value="01202" type="hidden"/>
    <!-- 主菜单 start -->
    <s:include value="/include/nav.jsp" />
    <!-- 主菜单 end -->
    <!-- 主容器 start -->
    <div class="container">
      <h3 class="current-title">慢性病随访记录</h3>
      <div class="search-content">
      <!-- 搜索容器 start -->
      <div class="search-content">
         <div class="search-item">
           	 当前人：<c:out value="${healthFile.name}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;档案编号：<c:out value="${healthFile.fileNum}"></c:out>&nbsp;&nbsp;&nbsp;&nbsp;
          <div class="btn-content"> 
             <label class="btn">  
               		${chronicDisease.diseaseName}
               		
             </label>
           </div>
          </div>
      </div>
      
      <!-- 结果容器 start -->
      <h3 class="current-title">重性精神疾病随访记录</h3>
      <form action="<%=basePath %>oldChronicFollowAction!editMentalFollow.action" method="post">
      <div class="table-content">
        <table class="table table-bordered">
          <tbody>
           <tr>
             <td colspan="4" class="title-td">基本信息
            		<input type = "hidden" name="cid"  value= "${mentalfollowview.chronicDiseaseId}">
               		<input type = "hidden" name="hid"  value= "${mentalfollowview.healthFileId}">
               		<input type = "hidden" name="mentalFollow.mentalFollowId"  value= "${mentalfollowview.mentalFollowId}">
               		<input type = "hidden" name="chronicFollow.chronicFollowId"  value= "${mentalfollowview.chronicFollowId}">
               		<input type = "hidden" name="jsbid"  value= "${mentalfollowview.mentalFollowId}">
               		<input type = "hidden" name = "htype"  value= "${healthFile.healthFileType}">
             </td>
           </tr>
              <tr>
              <td>危险性：</td>
              <td> 
              	<select name="mentalFollow.risk" id="">
                  <option value="">请选择</option>
                  <s:iterator value="wxx" var="g">
                  <option value="${g.name}" <c:if test="${g.name eq mentalfollowview.risk}">selected</c:if>>${g.name}</option>
                  </s:iterator>
                </select>
              </td>
              <td>目前症状：</td>
              <td>
                <select name="mentalFollow.presentSymptom" id="">
                  <option value="">请选择</option>
                   <s:iterator value="zxjsbmqzz" var="g">
                  <option value="${g.name}" <c:if test="${g.name eq mentalfollowview.presentSymptom}">selected</c:if>>${g.name}</option>
                  </s:iterator>
                </select>
               </td>
            </tr>

        
              <tr>
              <td>自知力：</td>
              <td> 
              	<select name="mentalFollow.selfKnowledge" id="">
                  <option value="">请选择</option>
                  <s:iterator value="zzl" var="g">
                  <option value="${g.name}" <c:if test="${g.name eq mentalfollowview.selfKnowledge}">selected</c:if>>${g.name}</option>
                  </s:iterator>
                </select>
              </td>
              <td>睡眠情况：</td>
              <td>
                <select name="mentalFollow.sleepQuality" id="">
                  <option value="">请选择</option>
                  <s:iterator value="smqk" var="g">
                  <option value="${g.name}" <c:if test="${g.name eq mentalfollowview.sleepQuality}">selected</c:if>>${g.name}</option>
                  </s:iterator>
                </select>
               </td>
            </tr>
            <tr>
               <td>饮食情况：</td>
              <td >
                <select name="mentalFollow.dietCondition" id="">
                  <option value="">请选择</option>
                  <option value="规律" <c:if test="${'规律' eq mentalfollowview.dietCondition}">selected</c:if>>规律</option>
                  <option value="不规律" <c:if test="${'不规律' eq mentalfollowview.dietCondition}">selected</c:if>>不规律</option>
                </select>
               </td>
              <td  colspan="2"></td> 

            </tr>
            <tr>
             <td colspan="4" class="title-td">社会功能情况</td>
           </tr>

           <tr>
              <td>个人生活料理：</td>
              <td>
               <select name="mentalFollow.socialFunction" id="">
                  <option value="">请选择</option>
                  <s:iterator value="grshll" var="g">
                  <option value="${g.name}" <c:if test="${g.name eq mentalfollowview.socialFunction}">selected</c:if>>${g.name}</option>
                  </s:iterator>
                </select>
              </td>
              <td>家务劳动：</td>
              <td>
                <select name="mentalFollow.housework" id="">
                  <option value="">请选择</option>
                  <s:iterator value="jwld" var="g">
                  <option value="${g.name}" <c:if test="${g.name eq mentalfollowview.housework}">selected</c:if>>${g.name}</option>
                  </s:iterator>
                </select>
               </td>
            </tr>

           <tr>
              <td>生产劳动及工作：</td>
              <td>
               <select name="mentalFollow.productiveLaborAndWork" id="">
                  <option value="">请选择</option>
                  <s:iterator value="scld" var="g">
                  <option value="${g.name}" <c:if test="${g.name eq mentalfollowview.productiveLaborAndWork}">selected</c:if>>${g.name}</option>
                  </s:iterator>
                </select>
              </td>
              <td>学习能力：</td>
              <td>
                <select name="mentalFollow.learningAbility" id="">
                  <option value="">请选择</option>
                  <s:iterator value="xxnl" var="g">
                  <option value="${g.name}" <c:if test="${g.name eq mentalfollowview.learningAbility}">selected</c:if>>${g.name}</option>
                  </s:iterator>
                </select>
               </td>
            </tr>
             <tr>
              <td>社会人际交往：</td>
              <td>
               <select name="mentalFollow.socialInterpersonal" id="">
                  <option value="">请选择</option>
                  <s:iterator value="shjjnll" var="g">
                  <option value="${g.name}" <c:if test="${g.name eq mentalfollowview.socialInterpersonal}">selected</c:if>>${g.name}</option>
                  </s:iterator>
                </select>
              </td>
              <td  colspan="2"></td>
             
            </tr>
             <tr>
             <td colspan="4" class="title-td"></td>
           </tr>
             <tr>
              <td>患病对社会/家庭的影响：</td>
              <td>
              <div class="jia">
               <select  id="di" class="di">
               		<option style="display:none" value=""></option>
                  	<option value="">请选择</option>
                  <s:iterator value="hbdjtyx" var="g">
                  	<option value="${g.name}">${g.name}</option>
                  </s:iterator>
                </select>
                <input type="text" id="gai" class="gai" name="mentalFollow.influenceSocietyFamily" value="${mentalfollowview.influenceSocietyFamily}" placeholder="请选择">
                </div>
              </td>
             <td>关锁情况：</td>
              <td>
               <select name="mentalFollow.closeOrLock">
               <option value="">请选择</option>
               	  <s:iterator value="gsqk" var="g">
                  <option value="${g.name}" <c:if test="${g.name eq mentalfollowview.closeOrLock}">selected</c:if>>${g.name}</option>
                  </s:iterator>
                </select>
              </td>
             
            </tr>
             <tr>
              <td>住院情况：</td>
              <td>
              <div class="jia">
               <select  id="di" class="di">
                  	<option style="display:none" value=""></option>
                  	<option value="">请选择</option>
                  <s:iterator value="zyqk" var="g">
                  	<option value="${g.name}">${g.name}</option>
                  </s:iterator>
                </select>
                <input type="text" id="gai" class="gai" name="mentalFollow.hospitalization" value="${mentalfollowview.hospitalization}" placeholder="请选择">
                </div>
              </td>
             <td>实验室检查：</td>
              <td><input class="temp"  type="text" name="mentalFollow.laboratoryTests" value="${mentalfollowview.laboratoryTests}" maxlength="80">
                </td>
             
            </tr>

          <tr>
             <td colspan="8" class="title-td">目前用药情况</td>
           </tr>
            <tr>
              <td  colspan="8" >
                <table  class="table table-bordered">
                  <tbody>
                    <tr>
                        <td colspan="2">药品名称</td>
                        <td>每次剂量</td>
                        <td colspan="2">给药途径</td>
                        <td colspan="2">不良反应</td>
                    	<td>操作</td>
                    </tr>

               		   <s:iterator value="listdrug" status="n" var="ld">
                       <tr class="dyna-form">
                         <td colspan="2"> <input class="temp"  type="text" name="listdrug[0].drugName" value="${ld.drugName}" maxlength="20" > </td>
                         <td> <input onkeyup="Num(this)" type="text" name="listdrug[0].dailyDose" value="${ld.dailyDose}" maxlength="10" > </td>
                         <td colspan="2"> <input class="temp"  type="text" name="listdrug[0].drugPath" value="${ld.drugPath}" maxlength="20" ></td>
                         <td colspan="2"> <input class="temp"  type="text" name="listdrug[0].adverseReactions" value="${ld.adverseReactions}" maxlength="50" ></td>
                         <td>
                         	<a href="javascript:;" class="btn-del">删除</a>
                            <a href="javascript:;" class="btn-add">添加</a>
                         </td>  
                      </tr>
                      </s:iterator>
               </tbody>
                </table>

              </td>
            </tr>
              <tr>
              <td>药物不良反应：</td>
              <td colspan="3">
              <select name="mentalFollow.adverseDrugReactions" id="">
                  <option value="无" <c:if test="${'无' eq mentalfollowview.adverseDrugReactions}">selected</c:if>>无</option>
                  <option value="有" <c:if test="${'有' eq mentalfollowview.adverseDrugReactions}">selected</c:if>>有</option>
                </select>
                </td>

             
            </tr>

           <tr>
              <td>药物依从性：</td>
              <td>
               <select name="mentalFollow.medicationAdherence" id="">
                  <option value="">请选择</option>
                  <s:iterator value="zxjsbywycx" var="g">
                  <option value="${g.name}" <c:if test="${g.name eq mentalfollowview.medicationAdherence}">selected</c:if>>${g.name}</option>
                  </s:iterator>
                </select>
              </td>
              <td>随访分类：</td>
              <td>
                <select name="mentalFollow.classification" id="">
                  <option value="">请选择</option>
                  <s:iterator value="gxysflx" var="g">
                  <option value="${g.name}" <c:if test="${g.name eq mentalfollowview.classification}">selected</c:if>>${g.name}</option>
                  </s:iterator>
                </select>
               </td>
            </tr>

           <tr>
              <td>康复措施：</td>
              <td>
               <select name="mentalFollow.recoveryMeasure" id="">
                  <option value="">请选择</option>
                  <s:iterator value="kfcs" var="g">
                  <option value="${g.name}" <c:if test="${g.name eq mentalfollowview.recoveryMeasure}">selected</c:if>>${g.name}</option>
                  </s:iterator>
                </select>
              </td>
              <td>治疗效果：</td>
              <td>
                <select name="mentalFollow.treatmentEffect" id="">
                <option value="">请选择</option>
                  <s:iterator value="zlxg" var="g">
                  <option value="${g.name}" <c:if test="${g.name eq mentalfollowview.treatmentEffect}">selected</c:if>>${g.name}</option>
                  </s:iterator>
                </select>
               </td>
            </tr>
          <tr>
              <td>
             		 指导意见：
               </td>
             <td colspan="7">
             <textarea   name="mentalFollow.guidance" id=""  class="textarea temp">${mentalfollowview.guidance}</textarea></td>
            </tr>

  
        <tr>
        <td>转诊：</td>
        <td >
        <div class="jia">
               <select id="di" class="di">
                 <option style="display:none" value=""></option>
                 <option value="" >请选择</option>
                 <option value="无">无</option>
                 <option value="有：（转诊原因：              机构及科别：             ）">有：（转诊原因：              机构及科别：             ）</option>
               </select>
               <input type="text" id="gai" class="gai"   name="mentalFollow.whetherTheReferral" value="${mentalfollowview.whetherTheReferral}" placeholder="请选择">
               </div>
        </td>
        <td >下次随访日期： </td>
        <td><input type="text" onclick="laydate({istime: true, format: 'YYYY-MM-DD'})" onfocus="this.blur()" name="mentalFollow.nextDate" value="<fmt:formatDate value="${mentalfollowview.nextDate}"  pattern="yyyy-MM-dd"/>"></td>
       
      </tr>

        <tr>
        <td>随访医生：</td>
        <td >
          	   <label>${mentalfollowview.followPeople}</label>
        </td>
        <td >随访日期： </td>
        <td><label><fmt:formatDate value="${mentalfollowview.followDate}" pattern="yyyy-MM-dd" /></label></td>
       
      </tr>


          </tbody>
        </table>
        <div class="btn-content">
          <input type="submit" class="btn" value="保存">
          <a href="javascript:;" class="btn btn-back">返回</a>
        </div>
      </div>
      </form>
      <!-- 结果容器 end -->
    </div>
    <!-- 主容器 end -->
    </div>
    <!-- 底栏 Start-->
    <div class="footer">
  社区管理系统 @copyright 2016-2019
</div>
    <!-- 底栏 Start-->
  </div>

<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
<script src="/jmjkms/js/base.js"></script>
<script type="text/javascript" src="jmjkms/js/yang/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="jmjkms/js/yang/Validform_v5.3.2_min.js"></script>
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
								  	//gai[j].value = "请选择"; 
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
