$(function(){
	$('#dg').datagrid({    
		url:'../notice/list.do',  
		method:'get',
		queryParams: {
			pageSize: 10
		},
		loadFilter: function(data){
			if(data.datas.length > 0){
				return data.datas
			}
			else{
				return data;
			}
		},
		columns:[[    
		          {field:'id',title:'id',hidden:true}, 
		          {field:'title',title:'标题',width:120,align:'center'},    
		          {field:'content',title:'内容',width:150},    
		          {field:'userId',title:'创建用户',width:100,align:'center'} ,
		          {field:'status',title:'顶置状态',width:100,align:'center',order:'desc',formatter:function(value,row,index){
		        	  return value == 1?'顶置':'普通';
		          },styler:function(value,row,index){
		        	  if (value == 1){
		        		  return 'color:red;';
		        	  }
		          }},   
		          {field:'createTime',title:'创建时间',width:120,formatter:function(value,row,index){

		        	  return value;
		          }},  
		          {field:'cz',title:'操作',width:120,align:'center',formatter:function(value,row,index){
		        	  return '<a class="upnotice" data-id='+row.id+' href="javascript:;" style="text-decoration: none;">顶置</a> | '+
		        	  '<a class="updatanotice" data-id='+row.id+' href="javascript:;" style="text-decoration: none;">修改</a> | <a class="delnotice" data-id='+row.id+' href="javascript:;" style="text-decoration: none;">删除</a>';
		          }}
		          ]],
		          toolbar: [{
		        	  iconCls: 'icon-add',
		        	  text:'新增公告',
		        	  border:true,
		        	  handler: function(){
		        		  $('#win').window({   
		        			  	title:'新增公告',
		        			    width:880,    
		        			    height:570,    
		        			    modal:true,
		        			    collapsible:false,
		        			    minimizable:false,
	        			    	maximizable:false
		        			});  
		        		  $('#win').window('open');

		        	  }
		          }],
		          onLoadSuccess:function(data){
		        	  $('.upnotice').click(function(){
		        		  $.post('../notice/updateStatus.do',{status:1,id:$(this).attr('data-id')},function(d){
		        			  $('#dg').datagrid('reload');
		        			  $.messager.alert('提示',d.msg); 
		        		  });
		        	  });
		        	  $('.updatanotice').click(function(){
//		        		  $.post('notice/update.do',{status:1,id:$(this).attr('data-id')},function(d){
//		        		  $.messager.alert('提示',d.msg); 
//		        		  });
		        		  alert();
		        	  });
		        	  $('.delnotice').click(function(){
		        		  var _this = $(this);
		        		  $.messager.confirm('确认','您确认想要删除记录吗？',function(r){    
		        			  if (r){    
		        				  $.post('../notice/delete.do',{id:_this.attr('data-id')},function(d){
		        					  $('#dg').datagrid('reload');
								$.messager.alert('提示',d.msg); 
							});   
					    }    
					}); 
				});
			}
		});  
	//提交事件
	$('#submit').bind('click', function(){    
		 var _content = $('#frolal').froalaEditor('html.get'); 
		 console.log(_content);
    });  
	//window关闭
	$('#cancel').bind('click', function(){    
		$('#win').close();
   });    

});