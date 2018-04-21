package com.chlab.zylht.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.chlab.zylht.entity.Administrators;
import com.chlab.zylht.util.PageData;
import com.github.pagehelper.Page;

public class BaseController {
	@Autowired  
	protected  HttpServletRequest request;  
	
	/**
	 * 获取当前登录用户
	 * @return
	 */
	public Administrators getLoginUser(){

		return (Administrators) getSession().getAttribute("user");
	}
	
	/**
	 * 获取项目根目录
	 * @return
	 */
	public String getRootPath(){
		
		return getRequest().getSession().getServletContext().getRealPath(File.separator);
	}
	
	/**
	 * 封装分页数据
	 * @param datas
	 * @return
	 */
	public PageData pageData(Page<?> datas){
		
		return new PageData(datas);
	} 
	
	/**
	 * 成功消息
	 * @return
	 */
	public Map<String,Object> successMsg(){
		
		return msg(true, "");
	}
	
	public Map<String,Object> successMsg(Object msg){
		
		return msg(true, msg);
	}
	
	/**
	 * 失败消息
	 * @return
	 */
	public Map<String,Object> failMsg(){
		
		return msg(false, "");
	}
	
	public Map<String,Object> failMsg(Object msg){
		
		return msg(false, msg);
	}
	
	/**
	 * 普通消息
	 * @param success 成功状态
	 * @param msg 消息内容
	 * @return
	 */
	public Map<String,Object> msg(boolean success,Object msg){
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("rst", success);
		m.put("msg", msg);
		return m;
	}
	
	public Map<String,Object> attrMsg(boolean success,Map<String,Object> attrs){
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("rst", success);
		m.putAll(attrs);
		return m;
	}
	
	public HttpServletRequest getRequest(){
		
		return request;
	}
	
	public HttpSession getSession(){
		
		return request.getSession();
	}
	
	public String getParameter(String param){
		
		return request.getParameter(param);
	}
	
	
	public ServletContext getApplication(){
		
		return this.getSession().getServletContext();
	}
	
	/**
	 * 获取ip
	 * @return
	 */
	public String getRemoteAddr(){
		return getRequest().getRemoteAddr();
	}
}
