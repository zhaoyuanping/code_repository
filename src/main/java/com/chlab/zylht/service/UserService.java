package com.chlab.zylht.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.chlab.zylht.dao.UserDao;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Component
@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	
	public Page<Map<String, Object>> listUserInfo(String clubName, String uname, Integer pageNum, Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		return userDao.listUserInfo(clubName, uname);
	}
	
	public Page<Map<String, Object>> listUserScore(String uname, String startTime, String endTime, Integer pageNum, Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		
		return userDao.listUserScore(uname,startTime,endTime);
	}
}
