$(function(){
	$('#tt').datagrid({    
	    url:'../user/listUserInfo.do',    
	    method:'get',
	    singleSelect:true,
	    pagination:true,
	    loadFilter: function(data){
			if(data.datas.length > 0){
				var o = {};
				o.rows = data.datas;
				o.total = data.total;
				return o;
			}
			else{
				return data;
			}
		},
	    columns:[[    
	    	{field:'id',title:'id',hidden:true},    
	        {field:'uname',title:'用户昵称',width:180,align:'center'}, 
	        {field:'utype',title:'身份',width:100,align:'center',formatter:function(value,row,index){
	        	
	        	return value == 1?'管理员':(value == 2?'<span style="color:red;">群主<span>':'玩家');
	        }},    
	        {field:'himg',title:'成员头像',width:120,align:'center',formatter:function(v,row,index){
	        	
	        	return '<img src='+ v +' width=35 height=35 style="padding: 5px;">';
	        }},  
//	        {field:'phone',title:'联系电话',width:120,align:'center'},
//	        {field:'email',title:'邮箱',width:130,align:'center'} ,
	        {field:'suoshu_club',title:'所属俱乐部',width:140,align:'center'} ,
	        {field:'clubscore',title:'俱乐部充值',width:230,align:'center'} ,
	        {field:'uscore',title:'个人充值',width:120,align:'center'} ,
	        {field:'create_club_count',title:'创建俱乐部数量',width:120,align:'center'} ,
	        {field:'club_renshu',title:'俱乐部成员数',width:120,align:'center'} ,
	        {field:'crtime',title:'创建时间',width:140,align:'center',formatter:function(v,r,i){
	        	
	        	return value(v);
	        }}
	    ]],
	    toolbar: [{  
            	text: '用户昵称：<input type="text" id="u-name"/>'  
        	},{  
        		text: '所属俱乐部：<input type="text" id="u-club"/>'  
        	},{
				iconCls: 'icon-search',
				text:'查询',
				handler: function(){
					$('#tt').datagrid('load',{
						clubName: $('#u-club').val(),
						uname: $('#u-name').val()
					});
				}
		}]

	});  
	var p = $('#tt').datagrid('getPager');
	$(p).pagination({
		pageSize:10,
		beforePageText:'第',
		afterPageText:'页 共 {pages} 页',
		displayMsg:'当前显示 {from} - {to} 条记录 共 {total} 条记录'
	});
});