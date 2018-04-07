$(function(){
	$('#tt').datagrid({    
	    url:'../user/listUserScore.do',    
	    method:'get',
	    singleSelect:true,
	    pagination:true,
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
	        {field:'uname',title:'用户昵称',width:180,align:'center'}, 
	        {field:'himg',title:'头像',width:120,align:'center'},  
	        {field:'score',title:'充值积分',width:120,align:'center'},
	        {field:'crtime',title:'充值时间',width:140,align:'center',formatter:function(v,r,i){
	        	
	        	return value(v);
	        }}
	    ]],
	    toolbar: [{  
            	text: '用户昵称：<input type="text" id="u-name"/>'  
        	},{  
        		text: '开始月份： <input id="starttime" type="text" onclick="setmonth(this)" readonly="readonly" style="width:123px;"/> '  
        	},{  
        		text: '结束月份： <input id="endtime" type="text" onclick="setmonth(this)" readonly="readonly" style="width:123px;"/> '  
        	},{
				iconCls: 'icon-search',
				text:'查询',
				handler: function(){
					var startTime = $('#starttime').val();
					var endTime = $('#endtime').val();
					if(startTime != '' && endTime == ''){
						$.messager.alert('提示', '结束月份不能为空。'); 
						return;
					}
					if(startTime == '' && endTime != ''){
						$.messager.alert('提示', '开始月份不能为空。'); 
						return;
					}
					var st = new Date(startTime);
					var et = new Date(endTime);
					if(st.getTime() > et.getTime()){
						$.messager.alert('提示', '开始月份不能大于结束月份。'); 
						return;
					}
					
					$('#tt').datagrid('load',{
						uname: $('#u-name').val(),
						startTime:startTime,
						endTime:endTime
					});
				}
		}]

	});  
});
