package com.chlab.zylht.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chlab.zylht.entity.User;
import com.chlab.zylht.service.UserService;
import com.chlab.zylht.util.PageData;
import com.github.pagehelper.Page;

@Controller
@RequestMapping("user")
public class UserController extends BaseController{

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Map<String, Object> login(@RequestParam String name, @RequestParam  String pwd){
		if("admin".equals(name) && "123456".equals(pwd)) {
			User user = new User();
			user.setUname(name);
			user.setId(0);
			getSession().setAttribute("user", user);
			
			return successMsg("登录成功");
		}
		return successMsg("登录失败");
	}
	
	@RequestMapping(value = "/listUserInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody PageData listUserInfo(String clubName, String uname, Integer pageNum, Integer pageSize){
		pageNum = pageNum == null? 1 : pageNum;
		pageSize = pageSize == null? 10 : pageSize;
		Page<Map<String, Object>> page = userService.listUserInfo(clubName, uname, pageNum, pageSize);
		
		return pageData(page);
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void logout(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().invalidate();
		try {
			response.sendRedirect("../login.jsp");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping(value = "/listUserScore", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody PageData listUserScore(String uname,String startTime, String endTime, Integer pageNum, Integer pageSize){
		pageNum = pageNum == null? 1 : pageNum;
		pageSize = pageSize == null? 10 : pageSize;
		Page<Map<String, Object>> page = userService.listUserScore(uname, startTime, endTime, pageNum, pageSize);
		
		return pageData(page);
	}
}
