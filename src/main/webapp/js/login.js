(function(){
	$('#submit').click(function(){
		$.get('user/login.do',{name:$('#username').val(),pwd:$('#psssword').val()},function(d){
			if(d.rst){
				window.location.href = 'index.html';
			}
			else{
				alert('登录失败');
			}
		});
	});
	
})();
