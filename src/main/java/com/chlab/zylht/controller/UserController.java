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

	/**
	 * 根据ID获取用户信息
	 * @param id 主键ID
	 * @return 
	 */
	@RequestMapping(value = "/getUserById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Map<String,Object>  getUserById(@RequestParam int id) {
		User user = userService.getUserById(id);
		getSession().setAttribute("user", user);
		
		return successMsg(user);
	}
	
	/**
	 * 获取用户列表数据
	 * @return 用户对象集合
	 */
	@RequestMapping(value = "/listUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody PageData listUser(Integer pageNum, Integer pageSize) {
		pageNum = pageNum == null? 1 : pageNum;
		pageSize = pageSize == null? 10 : pageSize;
		Page<User> page = userService.listUser(pageNum, pageSize);
		
//		return ResultInfoWithPage.getSuccessInfo(page, page.getTotal(), page.getPageNum());
		return pageData(page);
	}
	
	/**
	 * 新增用户或者修改用户信息
	 * @param user 用户模型对象
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Map<String,Object>  update(User user){
		if(null != user) {
			try {
				userService.update(user);
				
				return successMsg("修改成功");
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				return failMsg("修改失败!");
			}
		}
		
		return failMsg("修改失败,用户对象为空!");
	}
	
	/**
	 * 根据用户主键ID删除用户
	 * @param id
	 */
	@RequestMapping(value = "/deleteById", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Map<String,Object>  deleteById(@RequestParam int id) {
		try {
			userService.deleteById(id);
			
			return successMsg("删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			return failMsg("删除失败!");
		}
	}
	
	/**
	 * 获取用户和用户积分信息
	 * @param userId 用户id
	 * @return
	 */
	@RequestMapping(value = "/getUserAndScore", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Map<String, Object> getUserAndScore(@RequestParam int userId){
		
		return successMsg(userService.getUserAndScore(userId));
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
}
