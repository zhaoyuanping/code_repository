(function(){
	var wx = new WxLogin({
		self_redirect : true,
		id : "login_container",
		appid : "wxd8ca41ac12ebfd87",
		scope : "snsapi_login",
		redirect_uri : encodeURIComponent("http://www.yingyongting.com/zylht/wx/callBack.do"),
		state : "STATE#wechat_redirect",
// 		style : "black",
// 		href : ""
	});
	
})();
