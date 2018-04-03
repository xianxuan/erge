<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<style type="text/css">
.jia {
	width: 150px;
	height: 30px;
	/*background: #ccc;*/
	position: relative;
}

.diGxy {
	width: 100px;
	height: 30px;
	position: absolute;
	top: 0;
	left: 0;
}

input[type="text"].gaiGxy {
	width: 70px;
	height: 22px;
	display: block;
	position: absolute;
	top: 0;
	left: 0;
}
</style>
	<!-- 主容器 start -->
	<div id="gxyDiv">
		<!--   
   <input type = "hidden" name="chronicFollow.diseasrName"  value= "${chronicDisease.diseaseName}" >
               		<input type = "hidden" name="gxycid"  value= "${chronicDisease.chronicDiseaseId}">
               		<input type = "hidden" name="gxyhtype"  value= "${healthFile.healthFileType}">
            -->
		<form action="#"  method="post"
			id="registerformGxy">
			<input type="hidden" name="gxyCid" value="${gxyCid}"> 
			<input type="hidden" name="healthFileIdGxy"
				value="${healthFile.healthFileId }">
				<table class="table table-bordered">
					<tbody>
						<tr>
							<td colspan="8" class="title-td">基本信息</td>
						</tr>
						<tr>
							<td><span class="required">*</span>随访日期</td>
							<td><input type="hidden" name="tokenGxy"
								value="${tokenGxy }" /> <input type="text" id="timeGxy"
								onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"
								onfocus="this.blur()" name="chronicFollow.followDate"
								value="${currentTime}"></td>
							<td>随访方式</td>
							<td><select name="thypertensiveFollow.way">
									<option value="">请选择</option>
									<s:iterator value="gxysffs" var="g">
										<option value="${g.name}">${g.name}</option>
									</s:iterator>
							</select></td>
							<td><span class="required">*</span>随访医生</td>
							<td colspan="3"><input id="sfysGxy" class="temp" type="text"
								name="chronicFollow.followPeople" maxlength="10" datatype="*"
								nullmsg="随访医生不可为空"></td>
						</tr>
						<tr>
							<td>主要症状</td>
							<td colspan="7"><select
								name="thypertensiveFollow.mainSymptom">
									<option value="">请选择</option>
									<s:iterator value="mqzyzz" var="g">
										<option value="${g.name}">${g.name}</option>
									</s:iterator>
							</select></td>
						</tr>
						<tr>
							<td colspan="8" class="title-td">体征</td>
						</tr>
						<tr>
							<td>体重（kg）</td>
							<td><input onkeyup="Num(this)" type="text" name="signGxy.wight"
								maxlength="10"></td>
							<td>身高（cm）</td>
							<td><input onkeyup="Num(this)" type="text"
								name="signGxy.height" maxlength="10"></td>
							<td>体质指数</td>
							<td><input onkeyup="Num(this)" type="text" name="signGxy.bmi"
								maxlength="10"></td>
							<td>舒张压（mmhg）</td>
							<td><input onkeyup="Num(this)" type="text" class="w150"
								name="signGxy.bloodPressureH" maxlength="10"></td>
						</tr>
						<tr>
							<td>心率(次/分)</td>
							<td><input onkeyup="this.value=this.value.replace(/\D/g,'')"
								onafterpaste="this.value=this.value.replace(/\D/g,'')"
								type="text" class="w40" name="signGxy.heartRate" maxlength="10"></td>
							<td>其他</td>
							<td colspan="3"><input type="text" class="w150 temp"
								name="signGxy.others" maxlength="80"></td>
							<td>收缩压（mmhg）</td>
							<td><input onkeyup="Num(this)" type="text" class="w150"
								name="signGxy.bloodPressureL" maxlength="10"></td>
						</tr>
						<tr>
							<td colspan="8" class="title-td">生活方式指导</td>
						</tr>
						<tr>
							<td>日吸烟量平均（支）</td>
							<td colspan="2"><input
								onkeyup="this.value=this.value.replace(/\D/g,'')"
								onafterpaste="this.value=this.value.replace(/\D/g,'')"
								type="text" class="w40"
								name="lifestyleGuideGxy.dailyCigaretteSmoking" maxlength="10"></td>
							<td>日饮酒量平均（两）</td>
							<td colspan="2"><input onkeyup="Num(this)" type="text"
								class="w40" name="lifestyleGuideGxy.dailyDrinking" maxlength="10"></td>
							<td>遵医行为</td>
							<td><select name="lifestyleGuideGxy.treatmentCompliance">
									<s:iterator value="zyxw" var="g">
										<option value="${g.name}">${g.name}</option>
									</s:iterator>
							</select></td>
						</tr>
						<tr>
							<td>摄盐情况</td>
							<td colspan="2"><select
								name="lifestyleGuideGxy.takenSaltSituation">
									<option value="">请选择</option>
									<s:iterator value="gxyfsyqk" var="g">
										<option value="${g.name}">${g.name}</option>
									</s:iterator>
							</select></td>

							<td>运动</td>
							<td colspan="2"><input
								onkeyup="this.value=this.value.replace(/\D/g,'')"
								onafterpaste="this.value=this.value.replace(/\D/g,'')"
								type="text" class="w40" name="lifestyleGuideGxy.timesSports"
								maxlength="10">次/周<input
								onkeyup="this.value=this.value.replace(/\D/g,'')"
								onafterpaste="this.value=this.value.replace(/\D/g,'')"
								type="text" class="w40" name="lifestyleGuideGxy.exerciseDuration"
								maxlength="10">分钟/次</td>
							<td>心理调整</td>
							<td><select name="lifestyleGuideGxy.psychologicalAdjustment">
									<option value="">请选择</option>
									<s:iterator value="gxyfxl" var="g">
										<option value="${g.name}">${g.name}</option>
									</s:iterator>
							</select></td>
						<tr>
							<td colspan="8" class="title-td">其他</td>
						</tr>
						<tr>
							<td>辅助检查</td>
							<td colspan="7"><input type="text" class="w150 temp"
								name="thypertensiveFollow.supplementaryExamination"
								maxlength="80"></td>
						</tr>
						<tr>
							<td>服药依从性</td>
							<td><select name="thypertensiveFollow.medicationCompliance">
									<option value="">请选择</option>
									<s:iterator value="gxyfyycx" var="g">
										<option value="${g.name}">${g.name}</option>
									</s:iterator>
							</select></td>
							<td>药物不良反应</td>
							<td colspan="2"><select
								name="thypertensiveFollow.adverseDrugReactions">
									<option value="无">无</option>
									<option value="有">有</option>
							</select></td>
							<td>此次随访分类</td>
							<td colspan="2"><select
								name="thypertensiveFollow.followType">
									<option value="">请选择</option>
									<s:iterator value="gxysflx" var="g">
										<option value="${g.name}">${g.name}</option>
									</s:iterator>
							</select></td>
						</tr>
						<!--  <div class="table-content"> -->
						<tr>
							<td colspan="8">用药情况</td>
						</tr>

						<tr>
							<td colspan="2" class="title-td">药品名称</td>
							<td class="title-td">每天服药次数</td>
							<td colspan="2" class="title-td">每天剂量（mg）</td>
							<td colspan="2" class="title-td">不良反应</td>
							<td class="title-td">操作</td>
						</tr>
						<tr class="dyna-form1">
							<td colspan="2"><input class="temp" type="text"
								name="listdrugGxy[0].drugName" maxlength="20"></td>
							<td><input onkeyup="this.value=this.value.replace(/\D/g,'')"
								onafterpaste="this.value=this.value.replace(/\D/g,'')"
								type="text" name="listdrugGxy[0].timesTakeMedicineDaily"
								maxlength="10"></td>
							<td colspan="2"><input onkeyup="Num(this)" type="text"
								name="listdrugGxy[0].dailyDose" maxlength="10"></td>
							<td colspan="2"><input class="temp" type="text"
								name="listdrugGxy[0].adverseReactions" maxlength="50"></td>
							<td><a href="javascript:;" class="btn-del1">删除</a> <a
								href="javascript:;" class="btn-add1">添加</a></td>

						</tr>
						<tr>
							<td>转诊</td>
							<td colspan="3">
								<div class="jia">
									<select id="diGxy" class="diGxy">
										<option style="display:none"></option>
										<option value="">请选择</option>
										<option value="无">无</option>
										<option value="有：（转诊原因：              机构及科别：             ）">有：（转诊原因：
											机构及科别： ）</option>
									</select> 
									<input type="text" id="gaiGxy" class="gaiGxy"
										name="thypertensiveFollow.heartReferral" placeholder="请选择">
								</div>
							</td>
							<td>下次随访日期</td>
							<td colspan="3"><input type="text"
								onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"
								onfocus="this.blur()" name="thypertensiveFollow.laterDate">
							</td>
						</tr>
						<tr rowspan="2">
							<td>备注</td>
							<td colspan="7"><textarea id="" class="textarea temp"
									name="thypertensiveFollow.dailyTip"></textarea></td>
						</tr>

					</tbody>
				</table>
				<div class="btn-content">
					<input onclick="submitGxy2()" type="button" id="submitGxy" class="btn" value="保存">
					<a href="javascript:;" class="btn btn-back">返回</a>
				</div>
		</form>
		</div>
<script type="text/javascript">
	 function gxyDi() {

		var di = document.getElementsByClassName("diGxy");
		var gai = document.getElementsByClassName("gaiGxy");

		for (var i = 0; i < di.length; i++) {

			di[i].di = i;
			(function(j) {
				gai[j].value = "请选择";
				di[j].onchange = function() {
					gai[j].value = this.options[this.options.selectedIndex].value;

				};

			}(i));

		}
	};
</script>

<script type="text/javascript">
	function submitGxy2() {
	    if($("#timeGxy").val() == ""){
	      alert("随访日期不能为空！");
	      return;
	    }
	    if($("#sfysGxy").val() == ""){
	      alert("随访医生不能为空！");
	      return;
	    }
		var flag = false;
		console.log($("#registerformGxy").serialize());
		$.ajax({
			type : "POST", //请求方式  
			url : "incompleteRecordAction2!addHighFollowFromEmbeded.action", //请求路径 
			data : $("#registerformGxy").serialize(),
			dataType : "json", //返回值类型  
			async : false,
			success : function(results) {
				if (results == "0" || results == "1") {
					flag = true;
					alert('高血压随访添加成功!');
					//document.getElementById("submitGxy").disabled = true;
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
$(function(){
//页面加载时，检查DynaForm2的个数
	  function checkDynaForm1 () {
	    var dynaForms = $('.dyna-form1');
	    //序号
	    var number = 0;
	    for(var i = 0; i < dynaForms.length;i++){
	      var currentTr = $(dynaForms[i]);
	      // var curInput = currentTr.find('input');
	      // console.log(curInput);
	      if (currentTr.next().attr('class') == undefined && currentTr.prev().attr('class') == undefined) {
	        currentTr.find('.btn-add1').show();
	        currentTr.find('.btn-del1').hide();
	      }else if(currentTr.next().attr('class') == undefined){
	        currentTr.find('.btn-del1').show();
	        currentTr.find('.btn-add1').show();
	      }else{
	        currentTr.find('.btn-add1').hide();
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

	  checkDynaForm1();

	  //增加
	  $('.btn-add1').click(function  () {
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

	    checkDynaForm1();
	  });
	  //删除
	  $('.btn-del1').click(function() {
	    $(($(this).parent().parent())).remove();
	    checkDynaForm1();
	  });
});

</script>

