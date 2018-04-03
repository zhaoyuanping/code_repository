package com.chlab.zylht.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chlab.zylht.entity.Club;
import com.chlab.zylht.service.ClubService;
import com.chlab.zylht.service.UserService;
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
	@Autowired
	private UserService userService;
	
	
	/**
	 * 根据ID获取俱乐部
	 * @param id 俱乐部ID
	 * @return
	 */
	@RequestMapping(value = "/getClubById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Map<String, Object> getClubById(int id) {
		Club club = clubService.getClubById(id);
		
		return successMsg(club);
	}
	
	/**
	 * 获取所有俱乐部
	 * @return
	 */
	@RequestMapping(value = "/listClub", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody PageData listClub(Integer pageNum, Integer pageSize) {
		pageNum = pageNum == null? 1 : pageNum;
		pageSize = pageSize == null? 10 : pageSize;
		Page<Club> page = clubService.listClub(pageNum, pageSize);
		
		return pageData(page);
		
		
	}
	
	
	/**
	 * 添加或修改俱乐部数据
	 * @param club 俱乐部模型对象
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Map<String, Object> update(Club club) {
		if(null != club) {
			try {
				Club c = clubService.update(club, getLoginUser().getId());
				
				return successMsg(c);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
				return failMsg("保存失败!");
			}
		}
		return failMsg("保存失败,模型对象不完整!");
	}
	
	/**
	 * 根据ID删除俱乐部
	 * @param id
	 */
	@RequestMapping(value = "/deleteById", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Map<String, Object> deleteById(int id) {
		try {
			clubService.deleteById(id);
			
			return successMsg("删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			return failMsg("删除失败!");
		}
	}
	
	
	/**
	 * 获取俱乐部牌局列表
	 * @param clubId 俱乐部ID
	 * @return
	 */
	@RequestMapping(value = "/listClubGame", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody PageData listClubGame(Integer clubId, Integer userId, Integer pageNum,Integer pageSize,
			String mark) {
		pageNum = pageNum == null? 1 : pageNum;
		pageSize = pageSize == null? Integer.MAX_VALUE : pageSize;
		if(null != mark && "myAllClub".equals(mark.trim())) {
			userId = getLoginUser().getId();
		}
			
		Page<Map<String, Object>> page = clubService.listClubGame(clubId, userId, pageNum, pageSize);
		
		return pageData(page);
	}
	
}
