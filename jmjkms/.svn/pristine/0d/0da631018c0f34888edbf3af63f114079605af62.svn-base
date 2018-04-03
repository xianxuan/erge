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
    <style type='text/css'>
div#ecg{margin-top:15px;
     float:clear;
     padding:5px 0px;
     position:static;
     width:100%;    
}
#ecg>div{margin:25px 0px;
}
div#left{width:49%;
         position:relative;
         float:left;
         overflow:hidden;
         border-right:2px dotted red;
         }
#left div{
       width:100%;
       height:150px;
       position:relative;
       float:left;
       margin-top:30px;
}
div#right{width:50%;
          float:right;
          overflow:hidden;
          }
#right div{
       width:100%;
       height:150px;
       position:relative;
       float:right;
       margin-top:30px;
}
div#bottom{width:100%;
           height:20px;
           position:relative;
           float:left;
           left:0px;
           top:150px;
           overflow:hidden;}
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
      <h3 class="current-title">心电检查详情</h3>
      <input name="yemianname" value="02202" type="hidden"/>
      <!-- 表单表格 start -->
   <div class="table-content">
     <form action="#" method="post">
     <input type="hidden" name="healthFileId" value="${localHealthFile.healthFileId }">
      <input type="hidden" name="ecgId" value="${id }">
       <table class="table table-bordered">
         <tbody>
           <tr>
     <th width='10%'>检查时间</th>
     <td colspan='3'><c:out value="${meaTime }"></c:out> </td>
   </tr>
   <tr>
     <th>姓名</th>
     <td><c:out value="${name }"></c:out></td>
     <th width='10%'>身份证号</th>
     <td><c:out value="${idCard }"></c:out></td>
   </tr>
   <tr>
     <th>采样率（次/秒）</th>
     <td><c:out value="${sample }"></c:out></td>
     <th>采集时长（秒）</th>
     <td><c:out value="${duration }"></c:out></td>
   </tr>
   <tr>
     <th>诊断结果</th>
     <td colspan='3'><c:out value="${diagnosis }"></c:out></td>
   </tr>
         </tbody>
       </table>
       <div class="btn-content">
              <button class="btn" type="button" onclick="history.go(-1);">返回</button>
         </div>
<script type="text/javascript">

    </script>
 <div id='ecg'>
   <div id='left'>
     <div id='i'>I<span id='txtI'></span></div>
     <div id='ii'>II<span id='txtII'></span></div>
     <div id='iii'>III<span id='txtIII'></span></div>
     <div id='avr'>aVR<span id='txtAVR'></span></div>
     <div id='avl'>aVL<span id='txtAVL'></span></div>
     <div id='avf'>aVF<span id='txtAVF'></span></div>
   </div>
   <div id='right'>
     <div id='v1'>V1<span id='txtV1'></span></div>
     <div id='v2'>V2<span id='txtV2'></span></div>
     <div id='v3'>V3<span id='txtV3'></span></div>
     <div id='v4'>V4<span id='txtV4'></span></div>
     <div id='v5'>V5<span id='txtV5'></span></div>
     <div id='v6'>V6<span id='txtV6'></span></div>
   </div>
   <div id='bottom'><span id='txtInfo'></span></div>
 </div>
 <script type='text/javascript' language='javascript'>
    if(window.addEventListener){
         window.addEventListener("load",showEcg, false);
    } else if(window.attachEvent){
         window.attachEvent("onload",showEcg);
    } else {
         window.onload = showEcg;
    }
    
    function showEcg(){
        var f = document.forms['ecgForm'];
        var i = f.elements['hI'].value;
        var ii = f.elements['hII'].value;
        var iii = f.elements['hIII'].value;
        var avr = f.elements['hAVR'].value;
        var avl = f.elements['hAVL'].value;
        var avf = f.elements['hAVF'].value;
        var v1 = f.elements['hV1'].value;
        var v2 = f.elements['hV2'].value;
        var v3 = f.elements['hV3'].value;
        var v4 = f.elements['hV4'].value;
        var v5 = f.elements['hV5'].value;
        var v6 = f.elements['hV6'].value;
        if(i.length>0){
            $('#txtI').sparkline(i.split(','),{type: 'line',fillColor:'transparent',height:'150px',lineWidth:'1',width:'100%'} );
        }
        if(ii.length>0){
            $('#txtII').sparkline(ii.split(','),{type: 'line',fillColor:'transparent',height:'150px',lineWidth:'1',width:'100%'} );
        }
        if(iii.length>0){
            $('#txtIII').sparkline(iii.split(','),{type: 'line',fillColor:'transparent',height:'150px',lineWidth:'1',width:'100%'} );
        }
        if(avr.length>0){
            $('#txtAVR').sparkline(avr.split(','),{type: 'line',fillColor:'transparent',height:'150px',lineWidth:'1',width:'100%'} );
        }
        if(avl.length>0){
            $('#txtAVL').sparkline(avl.split(','),{type: 'line',fillColor:'transparent',height:'150px',lineWidth:'1',width:'100%'} );
        }
        if(avf.length>0){
            $('#txtAVF').sparkline(avf.split(','),{type: 'line',fillColor:'transparent',height:'150px',lineWidth:'1',width:'100%'} );
        }
        if(v1.length>0){
            $('#txtV1').sparkline(v1.split(','),{type: 'line',fillColor:'transparent',height:'150px',lineWidth:'1',width:'100%'} );
        }
        if(v2.length>0){
            $('#txtV2').sparkline(v2.split(','),{type: 'line',fillColor:'transparent',height:'150px',lineWidth:'1',width:'100%'} );
        }
        if(v3.length>0){
            $('#txtV3').sparkline(v3.split(','),{type: 'line',fillColor:'transparent',height:'150px',lineWidth:'1',width:'100%'} );
        }
        if(v4.length>0){
            $('#txtV4').sparkline(v4.split(','),{type: 'line',fillColor:'transparent',height:'150px',lineWidth:'1',width:'100%'} );
        }
        if(v5.length>0){
            $('#txtV5').sparkline(v5.split(','),{type: 'line',fillColor:'transparent',height:'150px',lineWidth:'1',width:'100%'} );
        }
        if(v6.length>0){
            $('#txtV6').sparkline(v6.split(','),{type: 'line',fillColor:'transparent',height:'150px',lineWidth:'1',width:'100%'} );
        }
    }
 </script>
     </form>
   </div>
   <!-- 表单表格 end -->
    </div>
    <!-- 主容器 end -->
    <form name='ecgForm' action='#'>
   <input type='hidden' id='hI' name='hI' value='${l }'>
   <input type='hidden' id='hII' name='hII' value='${ll }'>
   <input type='hidden' id='hIII' name='hIII' value='${lll }'>
   <input type='hidden' id='hAVR' name='hAVR' value='${avr }'>
   <input type='hidden' id='hAVL' name='hAVL' value='${avl }'>
   <input type='hidden' id='hAVF' name='hAVF' value='${avf }'>
   <input type='hidden' id='hV1' name='hV1' value='${v1 }'>
   <input type='hidden' id='hV2' name='hV2' value='${v2 }'>
   <input type='hidden' id='hV3' name='hV3' value='${v3 }'>
   <input type='hidden' id='hV4' name='hV4' value='${v4 }'>
   <input type='hidden' id='hV5' name='hV5' value='${v5 }'>
   <input type='hidden' id='hV6' name='hV6' value='${v6 }'>
 </form>
    <!-- 底栏 Start-->
    
    <s:include value="/include/footer.jsp" />
    <!-- 底栏 Start-->
  </div>

<script src="/jmjkms/js/jquery-2.1.1.min.js"></script>
<script src="/jmjkms/js/laydate/laydate.js"></script>
 <script src="/jmjkms/js/base.js"></script> 
<script src="/jmjkms/js/jquery-1.7.2.js"></script>
<script src="/jmjkms/js/jquery.sparkline.js"></script>
</body>
</html>
