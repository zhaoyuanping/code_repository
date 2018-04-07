package com.chlab.zylht.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chlab.zylht.dao.AdministratorsDao;
import com.chlab.zylht.entity.Administrators;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class AdministratorsService {

	@Autowired
	private AdministratorsDao administratorsDao;
	
	
	public Administrators gettUserById(int id) {
		
		return administratorsDao.gettUserById(id);
	}
	
	public Administrators getUserByUsername(String username) {
		
		return administratorsDao.gettUserByUsername(username);
	}
	
	/**
	 * 获取用户列表
	 * @return
	 */
	public Page<Administrators> listUser(Integer pageNum, Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		
		return administratorsDao.listUser();
	}
	
	/**
	 * 根据用户名和密码获取用户对象
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	public Administrators getUserByusernameAndpassword(String username,String password) {
		
		return administratorsDao.getUserByusernameAndpassword(username, password);
	}
	
	public void update(Administrators administrators) {
		if(null != administrators.getId()) {
			administratorsDao.update(administrators);
		}
		else {
			administratorsDao.add(administrators);
		}
	}
}
