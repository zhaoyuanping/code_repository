package com.chlab.zylht.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chlab.zylht.entity.vo.VClub;
import com.chlab.zylht.service.ClubService;
import com.chlab.zylht.util.PageData;
import com.github.pagehelper.Page;

/**
 * 俱乐部控制器类
 */
@Controller
@RequestMapping("club")
public class ClubController extends BaseController {
	
	@Autowired
	private ClubService clubService;
	
	/**
	 * 获取所有俱乐部
	 * @return
	 */
	@RequestMapping(value = "/listClub", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody PageData listClub(Integer pageNum, Integer pageSize) {
		pageNum = pageNum == null? 1 : pageNum;
		pageSize = pageSize == null? 10 : pageSize;
		Page<VClub> page = clubService.listClub(pageNum, pageSize);
		
		return pageData(page);
	}
	
	/**
	 * 获取俱乐部下的用户
	 * @param id 俱乐部ID
	 * @return
	 */
	@RequestMapping(value = "/listUser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Map<String, Object> listUser(int id){
		
		return successMsg(clubService.listUser(id));
	}
	
}
