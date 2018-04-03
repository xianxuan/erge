<%@ page language="java"
	import="java.util.*, java.text.SimpleDateFormat" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"  %>
<form id="registerform"
	action="incompleteRecordAction2!updateIncompleteRecord.action"
	method="post" onsubmit="return dosubmit()" name="registerform">
	<input type="hidden" name="token" value="${token }" /> <input
		type="hidden" name="healthFileId" value="${ healthFile.healthFileId}" />
		<input type="hidden" name="irId" value="${incompleteRecord.incompleteRecordId}"/>
	<input type="hidden" name="incompleteRecord.incompleteRecordDate"
		value="${incompleteRecord.incompleteRecordDate}">
	<table class="table table-bordered">
		<tbody>
			<tr>
				<td colspan="10" class="title-td">基本信息</td>
			</tr>
			<tr>
				<td>身高（cm）</td>
				<td><input onkeyup="Num(this)" type="text"
					name="incompleteRecord.sg" maxlength="10" value="${incompleteRecord.sg }"></td>
				<td width='8%'>体重（kg）</td>
				<td><input onkeyup="Num(this)" type="text"
					name="incompleteRecord.tz" maxlength="10" value="${incompleteRecord.tz }"></td>
				<td>体脂</td>
				<td><input onkeyup="Num(this)" type="text"
					name="incompleteRecord.tizhi" maxlength="10" value="${incompleteRecord.tizhi }"></td>
				<td>体温(℃)</td>
				<td><input onkeyup="Num(this)" type="text"
					name="incompleteRecord.tw" maxlength="10" value="${incompleteRecord.tw }"></td>
				<td>心率(次/分)</td>
				<td><input onkeyup="this.value=this.value.replace(/\D/g,'')"
					onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text"
					class="w40" name="incompleteRecord.xl" maxlength="10" value="${incompleteRecord.xl }"></td>
			</tr>
			<tr>
				<td>收缩压（mmhg）</td>
				<td><input onkeyup="Num(this)" type="text" class="w150"
					name="incompleteRecord.ssy" maxlength="10" value="${incompleteRecord.ssy }"></td>
				<td width='8%'>舒张压（mmhg）</td>
				<td><input onkeyup="Num(this)" type="text" class="w150"
					name="incompleteRecord.szy" maxlength="10" value="${incompleteRecord.szy }"></td>
				<td>其他</td>
				<td colspan="5"><input type="text" class="w150 temp"
					name="incompleteRecord.other" maxlength="80" size="80" value="${incompleteRecord.other }"></td>
			</tr>
			<tr>
				<td>过敏史</td>
				<td colspan='3'><input type="text" class="w150 temp"
					name="incompleteRecord.gms" maxlength="80" size='50' value="${incompleteRecord.gms }"></td>
				<td>发病时间</td>
				<td colspan='5'><input type="text" class="w150"
					onclick="laydate({istime: true, format: 'YYYY-MM-DD'})"
					onfocus="this.blur()" name="incompleteRecord.fbsj"
					value="${incompleteRecord.fbsj}"></td>
			</tr>
			<tr>
				<td>主观资料</td>
				<td colspan="9"><textarea name="incompleteRecord.subInfor"
						id="" class="textarea" cols='180' >${incompleteRecord.subInfor }</textarea></td>
			</tr>
			<tr>
				<td>诊断结果</td>
				<td colspan="9"><textarea name="incompleteRecord.ZDJG" id=""
						class="textarea" cols='180'>${incompleteRecord.ZDJG }</textarea></td>
			</tr>

			<tr>
				<td>处置计划</td>
				<td colspan="9"><textarea name="incompleteRecord.disposalPlan"
						id="" class="textarea" cols='180'>${incompleteRecord.disposalPlan }</textarea></td>
			</tr>
			<tr>
				<td colspan="10">用药情况</td>
			</tr>

			<tr>
				<td colspan="2" class="title-td">药品名称</td>
				<td colspan="2" class="title-td">每天服药次数</td>
				<td colspan="2" class="title-td">每天剂量（mg）</td>
				<td colspan="2" class="title-td">不良反应</td>
				<td colspan="2" class="title-td">操作</td>
			</tr>
			
			<s:iterator value="listdrug" status="n" var="ld">
			 <tr class="dyna-form">
				<td colspan="2"><input class="temp" type="text"
					name="listdrug[0].drugName" maxlength="20" value="${ld.drugName }"></td>
				<td colspan="2"><input
					onkeyup="this.value=this.value.replace(/\D/g,'')"
					onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text"
					name="listdrug[0].timesTakeMedicineDaily" maxlength="10" value="${ld.timesTakeMedicineDaily }"></td>
				<td colspan="2"><input onkeyup="Num(this)" type="text"
					name="listdrug[0].dailyDose" maxlength="10" value="${ld.dailyDose }"></td>
				<td colspan="2"><input class="temp" type="text"
					name="listdrug[0].adverseReactions" maxlength="50" value="${ld.adverseReactions }"></td>
				<td colspan="2">
					<a href="javascript:;" class="btn-del">删除</a> 
					<a href="javascript:;" class="btn-add">添加</a>
				</td>

			</tr>
			</s:iterator>
			<tr>
			</tr>
		</tbody>
	</table>

	<div class="btn-content">

		<input id="submit" type="submit" value="提交" class="btn"> <a
			href="javascript:;" class="btn btn-back">返回</a>
	</div>
</form>
<script src="/jmjkms/js/dkdhcommon.js"></script>
<script type="text/javascript">
    $(function(){
      $("#registerform").Validform({
        showAllError:false,
        tiptype:function(msg){          
          alert(msg);
        }
      });
      DKDH.addJzsj();
  });
	</script>
<script type="text/javascript">
	$("#registerform").submit(function(){
		if($("#Date").val()==""){
			alert("接诊日期不可为空")
			return false;
			
		}
	})
</script>
<script type="text/javascript">
		var isCommitted = false;//表单是否已经提交标识，默认为false
		function dosubmit() {
			/* 此处还需要判断各个必填项校验是否通过*/
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
	</script>



