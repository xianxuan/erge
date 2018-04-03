<%@ page language="java"
	import="java.util.*, java.text.SimpleDateFormat" pageEncoding="utf-8"%>
<form id="registerform"
	action="incompleteRecordAction2!addIncompleteRecord.action"
	method="post" onsubmit="return dosubmit()">
	<input type="hidden" name="token" value="${token }" /> <input
		type="hidden" name="healthFileId" value="${ healthFile.healthFileId}" />
	<input type="hidden" name="incompleteRecord.incompleteRecordDate"
		value="<%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString() %>">
	<table class="table table-bordered">
		<tbody>
			<tr>
				<td colspan="10" class="title-td">基本信息</td>
			</tr>
			<tr>
				<td>身高（cm）</td>
				<td>${incompleteRecord.sg}</td>
				<td width='8%'>体重（kg）</td>
				<td>${incompleteRecord.tz}</td>
				<td>体脂</td>
				<td>${incompleteRecord.tizhi}</td>
				<td>体温(℃)</td>
				<td>${incompleteRecord.tw}</td>
				<td>心率(次/分)</td>
				<td>${incompleteRecord.xl}</td>
			</tr>
			<tr>
				<td>收缩压（mmhg）</td>
				<td>${incompleteRecord.ssy}</td>
				<td width='8%'>舒张压（mmhg）</td>
				<td>${incompleteRecord.szy}</td>
				<td>其他</td>
				<td colspan="5">${incompleteRecord.other}</td>
			</tr>
			<tr>
				<td>过敏史</td>
				<td colspan='3'>${incompleteRecord.gms}</td>
				<td>发病时间</td>
				<td colspan='5'>${incompleteRecord.fbsj}</td> 
			</tr>
		    <tr>
				<td>主观资料</td>
				<td colspan="9">${incompleteRecord.subInfor}</td>
			</tr>
			<tr>
				<td>诊断结果</td>
				<td colspan="9">${incompleteRecord.ZDJG}</td>
			</tr>  

			<tr>
				<td>处置计划</td>
				<td colspan="9">${incompleteRecord.disposalPlan}</td> 
			<tr> 
				<td colspan="10">用药情况</td>
			</tr>

			<tr>
				<td colspan="2" class="title-td">药品名称</td>
				<td colspan="3" class="title-td">每天服药次数</td>
				<td colspan="3" class="title-td">每天剂量（mg）</td>
				<td colspan="2" class="title-td">不良反应</td>
			</tr>
			<s:iterator value="listdrug" status="n" var="v">
            	<tr class="dyna-form1">
       	         <td colspan="2">${v.drugName}</td>
                 <td colspan="3">${v.timesTakeMedicineDaily}</td>
                 <td colspan="3">${v.dailyDose} </td>
                 <td colspan="2">${v.adverseReactions} </td>
             </tr>
      	     </s:iterator>
		</tbody>
	</table>
</form>
    <div class="btn-content">
		 <a href="javascript:;" class="btn btn-back">返回</a>
	</div>
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



