package com.chlab.zylht.dao;


import org.apache.ibatis.annotations.Param;

import com.chlab.zylht.entity.Administrators;
import com.github.pagehelper.Page;

public interface AdministratorsDao extends BaseDao {
	
	
	Administrators gettUserByUsername(@Param("username") String username);
	
	Administrators gettUserById(@Param("id") int id);

	/**
	 * 获取用户列表
	 * @return
	 */
	Page<Administrators> listUser();
	
	/**
	 * 根据用户名和密码获取用户对象
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	Administrators getUserByusernameAndpassword(@Param("username") String username, @Param("password") String password);
	
	void add(Administrators administrators);
	
	void update(Administrators administrators);
}
