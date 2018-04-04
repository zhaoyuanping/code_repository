package com.chlab.zylht.dao;


import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.chlab.zylht.entity.User;
import com.github.pagehelper.Page;

public interface UserDao extends BaseDao {

	/**
	 * 根据ID获取用户信息
	 * @param id 主键ID
	 * @return 
	 */
	User getUserById(@Param("id")int id);
	
	/**
	 * 根据openid获取用户信息
	 * @param Openid
	 * @return
	 */
	User getUserByOpenid(@Param("openid") String openid);
	
	/**
	 * 获取用户列表数据
	 * @return 用户对象集合
	 */
	Page<User> listUser();
	
	/**
	 * 新增用户
	 * @param user 用户模型对象
	 */
	void add(User user);
	
	/**
	 * 修改用户信息
	 * @param user 用户模型对象
	 */
	void update(User user);
	
	/**
	 * 根据用户主键ID删除用户
	 * @param id
	 */
	void deleteById(int id);
	
	/**
	 * 获取用户和用户积分信息
	 * @param userId 用户id
	 * @return
	 */
	Map<String, Object> getUserAndScore(@Param("userId") int userId);
}
