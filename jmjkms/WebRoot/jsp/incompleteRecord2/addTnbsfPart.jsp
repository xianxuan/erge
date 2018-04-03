<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<style type="text/css">
.jia {
	width: 150px;
	height: 30px;
	/*background: #ccc;*/
	position: relative;
}

.diTnb {
	width: 100px;
	height: 30px;
	position: absolute;
	top: 0;
	left: 0;
}

input[type="text"].gaiTnb {
	width: 70px;
	height: 22px;
	display: block;
	position: absolute;
	top: 0;
	left: 0;
}
</style>
<!-- 主容器 start -->
 <div id="tnbDiv">
	<!--  
               		<input type = "hidden" name="chronicFollow.diseasrName"  value= "${chronicDisease.diseaseName}" >
               		<input type = "hidden" name="tnbcid"  value= "${chronicDisease.chronicDiseaseId}" >
               		<input type = "hidden" name="tnbhtype"  value= "${healthFile.healthFileType}">
               		-->
  
	<form action="#"  method="post"
		id="registerformTnb">
		<input type="hidden" name="tnbCid" value="${tnbCid}">
        <input type="hidden" name="healthFileIdTnb"
				value="${healthFile.healthFileId }">
			<table class="table table-bordered">
				<tbody>
					<tr>
						<td colspan="8" class="title-td">基本信息</td>
					</tr>
					<tr>
						<td><input type="hidden" name="tokenTnb" value="${tokenTnb}" /><span
							class="required">*</span>随访日期</td>
						<td><input type="text" id="timeTnb"
							onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"
							onfocus="this.blur()" name="chronicFollow.followDate"
							value="${currentTime}"></td>
						<td>随访方式</td>
						<td><select name="diabetsFollow.method">
								<option value="">请选择</option>
								<s:iterator value="gxysffs" var="g">
									<option value="${g.name}">${g.name}</option>
								</s:iterator>
						</select></td>
						<td><span class="required">*</span>随访医生</td>
						<td colspan="3"><input id="sfysTnb" class="temp" type="text"
							name="chronicFollow.followPeople" maxlength="10" datatype="*"
							nullmsg="随访医生不可为空"></td>
					</tr>
					<tr>
						<td>目前主要症状</td>
						<td colspan="7"><select name="diabetsFollow.mainSymptom">
								<option value="">请选择</option>
								<s:iterator value="tnbmqzyzz" var="g">
									<option value="${g.name}">${g.name}</option>
								</s:iterator>
						</select></td>
					</tr>
					<tr>
						<td colspan="8" class="title-td">体征</td>
					</tr>
					<tr>
						<td>体重（kg）</td>
						<td><input onkeyup="Num(this)" type="text" name="signTnb.wight"
							maxlength="10"></td>
						<td>身高（cm）</td>
						<td><input onkeyup="Num(this)" type="text" name="signTnb.height"
							maxlength="10"></td>
						<td>体质指数</td>
						<td><input onkeyup="Num(this)" type="text" name="signTnb.bmi"
							maxlength="10"></td>
						<td>舒张压（mmhg）</td>
						<td><input onkeyup="Num(this)" type="text" class="w150"
							name="signTnb.bloodPressureH" maxlength="10"></td>
					</tr>
					<tr>
						<td>足背动脉搏动</td>
						<td>
							<!-- 这里应该加字段 --> <select name="signTnb.heartRate">
								<option value="">请选择</option>
								<option value="未触及">未触及</option>
								<option value="触及">触及</option>
						</select>
						</td>
						<td>其他</td>
						<td colspan="3"><input type="text" class="w150 temp"
							name="signTnb.others" maxlength="80"></td>
						<td>收缩压（mmhg）</td>
						<td><input onkeyup="Num(this)" type="text" class="w150"
							name="signTnb.bloodPressureL" maxlength="10"></td>
					<tr>
					<tr>
						<td colspan="8" class="title-td">生活方式指导</td>
					</tr>
					<tr>
						<td>日吸烟量平均（支）</td>
						<td colspan="2"><input
							onkeyup="this.value=this.value.replace(/\D/g,'')"
							onafterpaste="this.value=this.value.replace(/\D/g,'')"
							type="text" class="w40"
							name="lifestyleGuideTnb.dailyCigaretteSmoking" maxlength="10"></td>
						<td>日饮酒量平均（两）</td>
						<td colspan="2"><input onkeyup="Num(this)" type="text"
							class="w40" name="lifestyleGuideTnb.dailyDrinking" maxlength="10"></td>
						<td>主食(g/天)</td>
						<td colspan="2"><input onkeyup="Num(this)" type="text"
							class="w40" name="lifestyleGuideTnb.stapleFood" maxlength="10"></td>
					</tr>
					<tr>
						<td>运动</td>
						<td colspan="2"><input
							onkeyup="this.value=this.value.replace(/\D/g,'')"
							onafterpaste="this.value=this.value.replace(/\D/g,'')"
							type="text" class="w40" name="lifestyleGuideTnb.timesSports"
							maxlength="10">次/周<input
							onkeyup="this.value=this.value.replace(/\D/g,'')"
							onafterpaste="this.value=this.value.replace(/\D/g,'')"
							type="text" class="w40" name="lifestyleGuideTnb.exerciseDuration"
							maxlength="10">分钟/次</td>
						<td>心理调整</td>
						<td colspan="2"><select
							name="lifestyleGuideTnb.psychologicalAdjustment">
								<option value="">请选择</option>
								<s:iterator value="tnbxltz" var="g">
									<option value="${g.name}">${g.name}</option>
								</s:iterator>
						</select></td>
						<td>遵医行为</td>
						<td><select name="lifestyleGuideTnb.treatmentCompliance">
								<option value="0">请选择</option>
								<s:iterator value="zyxw" var="g">
									<option value="${g.name}">${g.name}</option>
								</s:iterator>
						</select></td>
					<tr>
					<tr>
						<td colspan="8" class="title-td">辅助检查</td>
					</tr>
					<tr>
						<td>空腹血糖（mmol/l）</td>
						<td colspan="2"><input onkeyup="Num(this)" type="text"
							name="diabetsFollow.fastingBloodGlucose" maxlength="10"></td>
						<td>糖化血红蛋白（%）</td>
						<td><input onkeyup="Num(this)" type="text"
							name="diabetsFollow.glycosylatedHemoglobin" maxlength="10"></td>
						<td>检查日期</td>
						<td colspan="2"><input type="text"
							onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"
							onfocus="this.blur()" name="diabetsFollow.inspectionDate">
						</td>
					</tr>
					<tr>
						<td>其他检查</td>
						<td colspan="3"><input class="temp" type="text"
							name="diabetsFollow.otherInspection" maxlength="80"></td>
						<td>低血糖反应</td>
						<td colspan="3"><select
							name="diabetsFollow.hypoglycemicReaction">
								<option value="">请选择</option>
								<s:iterator value="dxtfy" var="g">
									<option value="${g.name}">${g.name}</option>
								</s:iterator>
						</select></td>
					</tr>
					<tr>
						<td>服药依从性</td>
						<td colspan="2"><select
							name="diabetsFollow.medicationCompliance">
								<option value="">请选择</option>
								<s:iterator value="gxyfyycx" var="g">
									<option value="${g.name}">${g.name}</option>
								</s:iterator>
						</select></td>
						<td>药物不良反应</td>
						<td><select name="diabetsFollow.adverseDrugReactions">
								<option value="无">无</option>
								<option value="有">有</option>
						</select></td>
						<td>此次随访分类</td>
						<td colspan="2"><select name="diabetsFollow.classification">
								<option value="">请选择</option>
								<s:iterator value="gxysflx" var="g">
									<option value="${g.name}">${g.name}</option>
								</s:iterator>
						</select></td>
					<tr>
						<td colspan="8">用药情况</td>
					</tr>

					<tr>
						<td colspan="2" class="title-td">药品名称</td>
						<td class="title-td">每次剂量（mg）</td>
						<td colspan="2" class="title-td">给药途径</td>
						<td colspan="2" class="title-td">不良反应</td>
						<td class="title-td">操作</td>
					</tr>
					<tr class="dyna-form2">
						<td colspan="2"><input class="temp" type="text"
							name="listdrugTnb[0].drugName" maxlength="20"></td>
						<td><input onkeyup="Num(this)" type="text"
							name="listdrugTnb[0].dailyDose" maxlength="10"></td>
						<td colspan="2"><input class="temp" type="text"
							name="listdrugTnb[0].drugPath" maxlength="20"></td>
						<td colspan="2"><input class="temp" type="text"
							name="listdrugTnb[0].adverseReactions" maxlength="50"></td>
						<td><a href="javascript:;" class="btn-del2">删除</a> <a
							href="javascript:;" class="btn-add2">添加</a></td>
					</tr>
					<tr>
						<td>胰岛素</td>
						<td colspan="7">
							<div class="jia">
								<select id="di" class="diTnb">
									<option style="display:none"></option>
									<option value="">请选择</option>
									<option value="未用">未用</option>
									<option value="使用（种类：    时间：   剂量：  ）">使用（种类： 时间： 剂量：
										）</option>
								</select> <input type="text" id="gai" class="gaiTnb"
									name="diabetsFollow.insulin" placeholder="请选择">
							</div>
						</td>
					</tr>
					<tr>
						<td>转诊</td>
						<td colspan="3">
							<div class="jia">
								<select id="diTnb" class="diTnb">
									<option style="display:none"></option>
									<option value="">请选择</option>
									<option value="无">无</option>
									<option value="有：（转诊原因：              机构及科别：             ）">有：（转诊原因：
										机构及科别： ）</option>
								</select> 
								<input type="text" id="gaiTnb" class="gaiTnb"
									name="diabetsFollow.transfer" placeholder="请选择">
							</div>
						</td>
						<td>下次随访日期</td>
						<td colspan="3"><input type="text"
							onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"
							onfocus="this.blur()" name="diabetsFollow.nextFollow"></td>
					</tr>
					<tr rowspan="2">
						<td>备注</td>
						<td colspan="7"><textarea id="" class="textarea temp"
								name="diabetsFollow.note"></textarea></td>
					</tr>
				</tbody>
			</table>
			<div class="btn-content">
				<input type="button" id="submitTnb" class="btn" value="保存" onclick="submitTnb2();"> 
				<a href="javascript:;" class="btn btn-back">返回</a>
			</div>
	</form>
	<!-- 删除此行注释，在此添加对应的div -->

</div>
<!-- 主容器 end -->

<script>
	function submitTnb2() {
	    if($("#timeTnb").val() == ""){
	      alert("随访日期不能为空！");
	      return;
	    }
	    if($("#sfysTnb").val() == ""){
	      alert("随访医生不能为空！");
	      return;
	    }
		var flag = false;
		console.log($("#registerformTnb").serialize());
		$.ajax({
			type : "POST", //请求方式  
			url : "incompleteRecordAction2!addDiabetsFromEmbeded.action", //请求路径 
			data : $("#registerformTnb").serialize(),
			dataType : "json", //返回值类型  
			async : false,
			success : function(results) {
				if (results == "0" || results == "1") {
					flag = true;
					alert('糖尿病随访添加成功!')
					//document.getElementById("submitTnb").disabled = true;
					//alert("一体机注册成功");
				} else {
					//alert("网络连接错误,请稍后重试");
					alert("已提交！请勿重复提交。");
					flag = false;
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

		function tnbDi(){


					var di = document.getElementsByClassName("diTnb");
					var gai = document.getElementsByClassName("gaiTnb");

					for (var i = 0; i < di.length; i++) {
						
							di[i].di = i;
								 (function(j){
								  	gai[j].value = "请选择"; 
								 di[j].onchange = function(){
							gai[j].value = this.options[this.options.selectedIndex].value;
					
								 };	
								

							}(i));
							
					}
					};
$(function(){
//页面加载时，检查DynaForm2的个数
	  function checkDynaForm2 () {
	    var dynaForms = $('.dyna-form2');
	    //序号
	    var number = 0;
	    for(var i = 0; i < dynaForms.length;i++){
	      var currentTr = $(dynaForms[i]);
	      // var curInput = currentTr.find('input');
	      // console.log(curInput);
	      if (currentTr.next().attr('class') == undefined && currentTr.prev().attr('class') == undefined) {
	        currentTr.find('.btn-add2').show();
	        currentTr.find('.btn-del2').hide();
	      }else if(currentTr.next().attr('class') == undefined){
	        currentTr.find('.btn-del2').show();
	        currentTr.find('.btn-add2').show();
	      }else{
	        currentTr.find('.btn-add2').hide();
	      };
	      
	     
	    	//设置每个name不同，增加 | 编辑 都可以用
		    var curInput = currentTr.find('input');
		    curInput.each(function  (i) {
		        var curName = this.name;
		        this.name = curName.replace(/\d+/, function(n){return number});
		    });
		    number++;
	      
	    }
	  };

	  checkDynaForm2();

	  //增加
	  $('.btn-add2').click(function  () {
	    $(($(this).parent().parent())).clone(true).insertAfter(($(this).parent().parent()));
	    $(this).hide();
	    $(this).prev().show();
	    $(this).parent().parent().next().find('input').val('');

	    var $name = $(this).parent().parent().next().find('input');

	    // });
	    // $name.each(function  (i) {
	    //   var curName = this.name;
	    //   this.name = curName.replace(/\d+/, function(n){return ++n});
	    // });

	    checkDynaForm2();
	  });
	  //删除
	  $('.btn-del2').click(function() {
	    $(($(this).parent().parent())).remove();
	    checkDynaForm2();
	  });
});

</script>

