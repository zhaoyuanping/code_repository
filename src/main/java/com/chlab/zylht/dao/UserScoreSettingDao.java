package com.chlab.zylht.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface UserScoreSettingDao extends BaseDao {

	List<Map<String, Object>> getScoreSetting();
	
	void update(@Param("score") int score, @Param("id") int id);
}
