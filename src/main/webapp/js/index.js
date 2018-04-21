(function(){
	//防止页面后退
    history.pushState(null, null, document.URL);
    window.addEventListener('popstate', function () {
        history.pushState(null, null, document.URL);
    });
    var p = window.location.search;
    if(null != p && '' != p){
    	$('#uaccount').html(p.substring(1,p.length));
    }
	$('#menu').tree({
		onClick: function(node){
			$.get('admin/isNullUser.do',function(d){
				if(d.rst){
					$('iframe').attr('src',node.url);
				}
				else{
					window.location.reload();
				}
			});
			
		}
	});
	$('#logout').click(function(){
		$.get('admin/logout.do',function(d){
			window.location.reload();
		});
	});

})();