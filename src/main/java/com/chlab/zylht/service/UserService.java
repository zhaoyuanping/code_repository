package com.chlab.zylht.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.chlab.zylht.dao.UserDao;
import com.chlab.zylht.entity.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Component
@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	/**
	 * 根据ID获取用户信息
	 * @param id 主键ID
	 * @return 
	 */
	public User getUserById(int id) {
		
		return userDao.getUserById(id);
	}
	
	/**
	 * 根据openid获取用户信息
	 * @param Openid
	 * @return
	 */
	public User getUserByOpenid(String openid){
		
		return userDao.getUserByOpenid(openid);
	}
	
	/**
	 * 获取用户列表数据
	 * @return 用户对象集合
	 */
	public Page<User> listUser(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		return userDao.listUser();
	}
	
	/**
	 * 新增用户或者修改用户信息
	 * @param user 用户模型对象
	 */
	public void update(User user) {
		if(null != user.getId()) {
			userDao.update(user);
		}
		else {
			userDao.add(user);
		}
	}
	
	/**
	 * 根据用户主键ID删除用户
	 * @param id
	 */
	public void deleteById(int id) {
		userDao.deleteById(id);
	}
	
	/**
	 * 获取用户和用户积分信息
	 * @param userId 用户id
	 * @return
	 */
	public Map<String, Object> getUserAndScore(int userId){
		
		return userDao.getUserAndScore(userId);
	}
}
