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
	<div id="win" style="width:880px;height:570px;display: none;" >
		 <div class="easyui-layout" data-options="fit:true">   
	        <div data-options="region:'north',split:true,border:false" style="height:60px">
	       		<form id="ff" method="post" style="margin-left: 15px;" >
					<div style="margin-top: 8px;">   
				        <label for="score">赠送数量:</label>   
				        <input id="score" class="easyui-textbox" type="number" maxlength="10" name="score" />   
				    </div>   
				</form>
	        </div>   
	        <div data-options="region:'center'">   
           		<div style="padding-top: 10px;text-align: center;">
           			<a id="submit" href="#" class="easyui-linkbutton" >提交</a>  
           			<a id="cancel" href="#" class="easyui-linkbutton" style="margin-left: 50px;">取消</a>  
           		</div>
	        </div>   
	    </div>   
	</div>  
</body>	
<script type="text/javascript">
$(function(){
	$('#tt').datagrid({    
	    url:'../score/setting/getScoreSetting.do',    
	    method:'get',
	    singleSelect:true,
	    loadFilter: function(data){
	    	
	    	return data.msg;
		},
	    columns:[[    
	    	{field:'id',title:'id',hidden:true},    
	        {field:'score',title:'赠送数量',width:180,align:'center'}, 
	        {field:'uptime',title:'更新时间',width:140,align:'center',formatter:function(v,r,i){
	        	
	        	return value(v);
	        }} ,
	        {field:'crtime',title:'创建时间',width:140,align:'center',formatter:function(v,r,i){
	        	
	        	return value(v);
	        }} ,
	        {field:'cz',title:'操作',width:100,align:'center',formatter:function(v,row,index){
	        	return '<a class="upsetting" data-id='+row.id+' href="javascript:;" style="text-decoration: none;">修改</a>';
	        }}
	    ]],
	    onLoadSuccess:function(d){
	    	var id;
	    	$('.upsetting').click(function(){
	    		id = $(this).attr('data-id');
	    		$('#win').window({   
	    			title:'修改数据',
	    			width:450,    
	    			height:150,    
	    			modal:true,
	    			collapsible:false,
	    			minimizable:false,
	    			maximizable:false
	    		});  
	    		$('#win').window('open');
	    	});
	    	$('#submit').click(function(){
	    		$('#ff').form('submit', {    
					url:'../score/setting/update.do',   
					onSubmit: function(param){    
					    param.id = id;    
					    if($('#score').val() == '' || $('#score').val() == null){
			    			return false;
			    		}
					},
					success:function(data){    
						$('#tt').datagrid('reload');
						$('#win').window('close');
						var d = JSON.parse(data);
						$.messager.alert('提示', d.msg); 
					}    
				});
	    	});
	    	$('#cancel').click(function(){
	    		$('#win').window('close');
	    	});
	    }
// 	    toolbar: [{
// 				iconCls: 'icon-search',
// 				text:'修改赠送数量',
// 				handler: function(){
// 					$('#tt').datagrid('load',{
// 						clubName: $('#u-club').val(),
// 						uname: $('#u-name').val()
// 					});
// 				}
// 		}]

	});  
});
</script>
</html>