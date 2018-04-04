$(function(){
	$('#datagrid').datagrid({    
	    url:'../club/listClub.do',    
	    singleSelect:true,
		method:'get',
		loadFilter: function(data){
			if(data.datas.length > 0){
				return data.datas
			}
			else{
				return data;
			}
		},
	    columns:[[    
	        {field:'name',title:'名称',width:120},    
	        {field:'uname',title:'创建人',width:100},    
	        {field:'introduc',title:'简介',width:150,align:'left'},
	        {field:'score',title:'剩余积分',width:100},
	        {field:'status',title:'审核状态',width:100,formatter:function(value,row,index){
	        	return value == 0?'待审核':(value == 1?'通过':'不通过');
	        },styler:function(value,row,index){
	        	  if (value == 1){
	        		  return 'color:green;';
	        	  }
	        	  else if(value == 2){
	        		  return 'color:red;';
	        	  }
	          }},
	        {field:'inviteCode',title:'邀请码',width:100},
	        {field:'upTime',title:'修改时间',width:120},
	        {field:'crTime',title:'创建时间',width:120},
	        {field:'id',title:'操作',align:'center',width:120,formatter:function(value,row,index){
	        	var tg = '<a class="n-tg" data-id='+row.id+' href="javascript:;" style="text-decoration: none;">通过</a>';
	        	var btg = '<a class="n-btg" data-id='+row.id+' href="javascript:;" style="text-decoration: none;">不通过</a>';
	        	switch (row.status) {
				case 0:
					return tg + ' | ' + btg;
				case 1:	
					return btg;
				case 2:	
					return tg;
				}
	        }}
	    ]],
	    onLoadSuccess:function(data){
	    	//通过点击事件
	    	$('.n-tg').click(function(){
	    		$.post('../club/update.do',{id:$(this).attr('data-id'),status:1},function(d){
	    			$.messager.alert('提示', d.msg); 
	    			$('#datagrid').datagrid('reload');
	    		});
	    	});
	    	//不通过点击事件
	    	$('.n-btg').click(function(){
	    		 $('#win').window({   
     			  	title:'不通过说明',
     			    width:400,    
     			    height:200,    
     			    modal:true,
     			    collapsible:false,
     			    minimizable:false,
 			    	maximizable:false
     			});  
     		  $('#win').window('open');
     		 var _this = $(this);
     		  $('#btn-btg').click(function(){
     			  var v = $('#btgtextarea').val();
     			  if(v == '')
     				 $.messager.alert('提示', "说明不不能为空"); 
     			  if(v.length > 50)
     				 $.messager.alert('提示', "说明内容不能超过50字"); 
     			  $.post('../club/update.do',{id:_this.attr('data-id'),status:2,explain:v},function(d){
     				  $.messager.alert('提示', d.msg); 
     				  $('#datagrid').datagrid('reload');
     				  $('#win').window('close');
     			  });
     		  });
	    	});
	    },
	    toolbar: [{}]    
	}); 
});