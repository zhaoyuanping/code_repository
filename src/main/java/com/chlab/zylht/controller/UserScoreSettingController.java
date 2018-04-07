package com.chlab.zylht.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chlab.zylht.service.UserScoreSettingService;

@Controller
@RequestMapping("score/setting")
public class UserScoreSettingController extends BaseController {
	
	@Autowired
	private UserScoreSettingService scoreSettingService;
	
	@RequestMapping(value = "/getScoreSetting", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Map<String, Object> getScoreSetting(){
		
		return successMsg(scoreSettingService.getScoreSetting());
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody Map<String, Object> update(@RequestParam int score, @RequestParam int id) {
		try {
			scoreSettingService.update(score, id);
			
			return successMsg("保存成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return successMsg("保存失败");
		}
	}

}
