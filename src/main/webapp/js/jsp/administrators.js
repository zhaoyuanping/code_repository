$(function(){
	$('#tt').datagrid({    
	    url:'../admin/listUser.do',    
	    method:'get',
	    singleSelect:true,
	    checkOnSelect:true,
	    loadFilter: function(data){
			if(data.datas.length > 0){
				return data.datas;
			}
			else{
				return data;
			}
		},
	    columns:[[    
	    	{field:'id',title:'id',hidden:true},   
	    	{field:'ck',checkbox:true},   
	        {field:'username',title:'用户名',width:180,align:'center'}, 
	        {field:'type',title:'类型',width:100,align:'center',formatter:function(value,row,index){
	        	
	        	return value == 1?'超级管理员':'管理员';
	        }},    
	        {field:'phone',title:'联系电话',width:120,align:'center'},
	        {field:'email',title:'邮箱',width:130,align:'center'} ,
	        {field:'status',title:'是否禁用',width:140,align:'center',formatter:function(value,row,index){
	        	
	        	return value == 1?'启用':'禁用';
	        }} ,
	        {field:'crtime',title:'创建时间',width:140,align:'center',formatter:function(v,r,i){
	        	
	        	return value(v);
	        }},
	        {field:'cz',title:'操作',width:100,align:'center',formatter:function(value,row,index){
	        	var qy = '<a class="upstatus" data-id='+row.id+' stat=1 href="javascript:;" style="text-decoration: none;">启用</a>';
	        	var jy = '<a class="upstatus" data-id='+row.id+' stat=0 href="javascript:;" style="text-decoration: none;">禁用</a>';
	        	
	        	return (row.status == 1?jy:qy) + ' | <a class="upinfo" data-id='+row.id+' href="javascript:;" style="text-decoration: none;">修改</a>';
	        			
	        }}
	    ]],
	    toolbar: [{
	    	iconCls: 'icon-add',
	    	text:'添加管理员',
	    	handler: function(){
	    		$('#addwin').window({   
	    			title:'添加管理员',
	    			width:450,    
	    			height:270,    
	    			modal:true,
	    			collapsible:false,
	    			minimizable:false,
	    			maximizable:false
	    		});  
	    		$('#addwin').window('open');
	    	}
	    },{
	    	iconCls: 'icon-edit',
	    	text:'修改密码',
	    	handler: function(){
	    		var rows = $('#tt').datagrid('getSelections');
	    		if(rows.length < 1){
	    			$.messager.alert('提示', '请选择要修改的数据行。'); 
					return;
	    		}
	    		$('#winpwd').window({   
	    			title:'修改密码',
	    			width:450,    
	    			height:220,    
	    			modal:true,
	    			collapsible:false,
	    			minimizable:false,
	    			maximizable:false
	    		});  
	    		$('#winpwd').window('open');
	    	}
	    }],
	    onLoadSuccess:function(data){
	    	$('.upstatus').click(function(){
	    		$.post('../admin/update.do',{id:$(this).attr('data-id'),status:$(this).attr('stat')},function(d){
	    			 $('#tt').datagrid('reload');
	    			$.messager.alert('提示', d.msg); 
	    		});
	    	});
	    	$('.upinfo').click(function(){
	    		$('#win').window({   
	    			title:'修改信息',
	    			width:450,    
	    			height:220,    
	    			modal:true,
	    			collapsible:false,
	    			minimizable:false,
	    			maximizable:false
	    		});  
	    		$('#win').window('open');
	    		$.get('../admin/gettUserById.do',{id:$(this).attr('data-id')},function(d){
	    			if(d.rst){
	    				$('#win').form('load',{
	    					phone:d.msg.phone,
	    					email:d.msg.email,
	    					status:d.msg.status,
	    					id:d.msg.id
	    				});
	    			}
	    		});
	    	});
	    	//修改
	    	$('#upsubmit').click(function(){
	    		$('#upff').form('submit', {    
					url:'../admin/update.do',    
					success:function(data){    
						$('#tt').datagrid('reload');
						$('#win').window('close');
						var d = JSON.parse(data);
						$.messager.alert('提示', d.msg); 
					}    
				});
	    	});
	    	//添加
	    	$('#addsubmit').click(function(){
	    		$('#addff').form('submit', {    
					url:'../admin/update.do',  
					onSubmit: function(param){    
				        param.mark = "add";    
				    }, 
					success:function(data){    
						var d = JSON.parse(data);
						if(!d.rst){
							$.messager.alert('提示', d.msg); 
							return;
						}
						$('#tt').datagrid('reload');
						$('#addwin').window('close');
					}    
				});
	    	});
	    	//修改密码
	    	$('#uppwdsubmit').click(function(){
	    		var rows = $('#tt').datagrid('getSelections');
	    		var id = rows[0].id;
	    		$('#pwdff').form('submit', {    
					url:'../admin/update.do',
					onSubmit: function(param){    
				        param.id = id;    
				    }, 
					success:function(data){    
						var d = JSON.parse(data);
						if(!d.rst){
							$.messager.alert('提示', d.msg); 
							return;
						}
						$('#tt').datagrid('reload');
						$('#winpwd').window('close');
						$.messager.alert('提示', d.msg); 
					}    
				});
	    	});
	    	
	    	$('#uppwdcancel').click(function(){
	    		$('#winpwd').window('close');
	    	});
	    	$('#upcancel').click(function(){
	    		$('#win').window('close');
	    	});
	    	$('#addcancel').click(function(){
	    		$('#addwin').window('close');
	    	});
	    }

	});  
	
	
	$.extend($.fn.validatebox.defaults.rules, {
		equals: {    
			validator: function(value,param){    
				return value == $(param[0]).val();    
			},    
			message: '密码匹配错误'   
		},    
		phoneNum: { //验证手机号    
			validator: function(value, param){  
				return /^1[3-8]+\d{9}$/.test(value);  
			},     
			message: '请输入正确的手机号码。'    
		},  

		telNum:{ //既验证手机号，又验证座机号  
			validator: function(value, param){  
				return /(^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$)|(^((\d3)|(\d{3}\-))?(1[358]\d{9})$)/.test(value);  
			},     
			message: '请输入正确的电话号码。'  
		}    
	});  
});