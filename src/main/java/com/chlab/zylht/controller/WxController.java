package com.chlab.zylht.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;
import com.chlab.zylht.entity.User;
import com.chlab.zylht.service.UserService;
import com.chlab.zylht.util.HttpsPost;

@RequestMapping("wx")
@Controller
public class WxController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	private final String APPID = "wxd8ca41ac12ebfd87";
	
	private final String SECRET = "77fc4491eb5cafe4289e866b967c4075";
	
	@RequestMapping(value = "getCode", method = RequestMethod.GET)
	public void getCode(HttpServletResponse response){
		String REDIRECT_URI = "http%3A%2F%2Fzyl.chlab.club";
		String url = "https://open.weixin.qq.com/connect/qrconnect?appid="+this.APPID+"&redirect_uri="+REDIRECT_URI+"&"
				+ "response_type=code&scope=snsapi_login&state=STATE#wechat_redirect";
		
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			try {
				response.getWriter().print("{\"msg\":\"获取登录信息失败\"}");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
	
	/**
	 * 用户允许授权后，将会重定向到redirect_uri的网址上，并且带上code和state参数
	 * redirect_uri?code=CODE&state=STATE
	 * 
	 * 若用户禁止授权，则重定向后不会带上code参数，仅会带上state参数
	 * redirect_uri?state=STATE
	 * 
	 * @param code
	 * @param state
	 */
	@RequestMapping(value = "callBack", method = RequestMethod.GET)
	public void callBack(String code, String state, HttpServletResponse response){
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		System.out.println("code: "+code);
		System.out.println("state "+state);
		if(null == code || "".equals(code)){
			return ;
		}
		//通过code获取access_token的接口。
		String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+this.APPID+"&secret="+this.SECRET+"&code="+code+"&grant_type=authorization_code"; 
		JSONObject json = null;
		try {
			String res= HttpsPost.httpRequest(url,"GET",null,"utf-8");
			json = JSONObject.parseObject(res);
		} catch (Exception e) {
			// TODO: handle exception
		}
		if(null != json && null != json.getString("openid")){
			String access_token = json.getString("access_token");
			//授权用户唯一标识
			String openid = json.getString("openid");
			//用户刷新access_token
			String refresh_token = json.getString("refresh_token");
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			System.out.println("openid "+openid);
			User user = userService.getUserByOpenid(openid);
			if(null != user){
				getSession().setAttribute("user", user);
				try {
					response.sendRedirect("../index.html");
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public Map<String, Object> getUserInfo(String openId,String access_token){
		String url = "https://api.weixin.qq.com/sns/userinfo?access_token="+access_token+"&openid="+openId;
		JSONObject json = null;
		try {
			String res= HttpsPost.httpRequest(url,"GET",null,"utf-8");
			json = JSONObject.parseObject(res);
		} catch (Exception e) {
			return failMsg();
		}
		if(null != json && null != json.getString("openid")){
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("openid", json.getString("openid"));
			map.put("nickname", json.getString("nickname"));
			map.put("sex", json.getString("sex"));
			map.put("headimgurl", json.getString("headimgurl"));
			map.put("city", json.getString("city"));
			map.put("unionid", json.getString("unionid"));
			
			return successMsg(map);
		}
		
		return failMsg(); 
	}
	
	

}
