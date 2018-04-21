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
import org.springframework.web.bind.annotation.ResponseBody;

import com.chlab.zylht.entity.Administrators;
import com.chlab.zylht.service.AdministratorsService;
import com.chlab.zylht.util.PageData;
import com.github.pagehelper.Page;

@Controller
@RequestMapping("admin")
public class AdministratorsController extends BaseController{
	
	@Autowired
	private AdministratorsService administratorsService;
	
	@RequestMapping(value = "/isNullUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Map<String, Object> isNullUser(){
		Administrators u = getLoginUser();
		if(null != u) 
			return successMsg();
		
		return failMsg();
	}
	
	@RequestMapping(value = "/gettUserById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Map<String, Object> gettUserById(int id) {
		
		return successMsg(administratorsService.gettUserById(id));
	}
	
	@RequestMapping(value = "/getUserByUsername", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Map<String, Object> getUserByUsername(String username) {
		if(null != administratorsService.getUserByUsername(username)) {
			
			return successMsg();
		}
		return failMsg();
	}
	
	/**
	 * 获取用户列表
	 * @return
	 */
	@RequestMapping(value = "/listUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody PageData listUser(Integer pageNum, Integer pageSize){
		pageNum = pageNum == null? 1 : pageNum;
		pageSize = pageSize == null? 10 : Integer.MAX_VALUE;
		Page<Administrators> page = administratorsService.listUser(pageNum, pageSize);
		
		return pageData(page);
	}
	
	/**
	 * 根据用户名和密码获取用户对象
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Map<String, Object> getUserByusernameAndpassword(String username,String password) {
		Administrators administrators = administratorsService.getUserByusernameAndpassword(username, password);
		if(null != administrators) {
			getSession().setAttribute("user", administrators);
			
			return successMsg(administrators);
		}
		
		return failMsg();
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Map<String, Object> update(Administrators administrators,String mark) {
		try {
			if(null == administrators) {
				
				return failMsg("保存失败"); 
			}
			if(null != mark && "add".equals(mark) && 
					null != administratorsService.getUserByUsername(administrators.getUsername())) {
				
				return failMsg("用户名已存在");
			}
			administratorsService.update(administrators);
			
			return successMsg("保存成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return failMsg("保存失败"); 
		}
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Map<String, Object> logout(HttpServletRequest request,HttpServletResponse response) {
		request.getSession().invalidate();
		try {
			response.sendRedirect("../login.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return successMsg();
	}

}
