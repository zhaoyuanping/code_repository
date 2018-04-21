(function(){
	$('#submit').click(function(){
		var name = $('#username').val();
		if(null == name || name == '' || name == undefined){
			$('.errormsg').html('账号不能为空');
			return;
		}
		var pwd = $('#psssword').val();
		if(null == pwd || pwd == '' || pwd == undefined){
			$('.errormsg').html('密码不能为空');
			return;
		}
		$.get('admin/login.do',{username:name,password:pwd},function(d){
			if(d.rst){
				window.location.href = 'index.html?'+d.msg.username;
			}
			else{
				$('.errormsg').html('登录失败，用户名或密码错误!');
			}
		});
	});
	
})();
