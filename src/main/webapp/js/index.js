(function(){
	$('#menu').tree({
		onClick: function(node){
			$('iframe').attr('src',node.url);
		}
	});


})();