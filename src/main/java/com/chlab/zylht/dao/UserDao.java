package com.chlab.zylht.dao;


import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.Page;

public interface UserDao extends BaseDao {

	Page<Map<String, Object>> listUserInfo(@Param("clubName") String clubName,@Param("uname") String uname);
	
	Page<Map<String, Object>> listUserScore(@Param("uname") String uname,@Param("startTime") String startTime,@Param("endTime") String endTime);
	
	Map<String, Object> scoreCount();
}
