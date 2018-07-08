<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title></title>
<link rel="stylesheet" type="text/css" href="../js/easyui/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="../js/easyui/themes/icon.css">
<script type="text/javascript" src="../js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="../js/easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
</head>
<body>
	<table id="tt" style="height:500px"></table>  
	<div>
		<p>总金额：<span id="summoney">0</span></p>
	</div>
<!-- 	<input id="myDate" name="myDate" class="easyui-datebox" data-options="formatter:myFormatter,parser:myParser"></input> -->
</body>	
<script type="text/javascript" src="../js/jsp/calendar.js"></script>
<script type="text/javascript" src="../js/jsp/statistics.js"></script>


<script type="text/javascript">
 /* function myFormatter(date){
            var y = date.getFullYear();
            var m = date.getMonth()+1;
            return y+'-'+(m<10?('0'+m):m);
        }


  function myParser(s){
  if(!s){
           return new Date();
  }
            var ss = s.split('-');
            var y = parseInt(ss[0],10);
            var m = parseInt(ss[1],10);
            if (!isNaN(y) && !isNaN(m)){
                return new Date(y,m-1);
            }
  }
 $(document).ready(function(){
	 
  if(!$("#myDate").datebox('getValue')){
	$("#myDate").datebox('setValue',myFormatter(new Date()));
  }
 }); */
</script>
</html>