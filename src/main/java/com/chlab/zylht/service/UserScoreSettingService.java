package com.chlab.zylht.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chlab.zylht.dao.UserScoreSettingDao;

@Service
public class UserScoreSettingService {
	
	@Autowired
	private UserScoreSettingDao scoreSettingDao;
	
	public List<Map<String, Object>> getScoreSetting(){
		
		return scoreSettingDao.getScoreSetting();
	}
	
	public void update(int score, int id) {
		
		scoreSettingDao.update(score, id);
	}

}
