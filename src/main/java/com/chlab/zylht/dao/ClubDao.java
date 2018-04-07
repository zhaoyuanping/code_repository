package com.chlab.zylht.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chlab.zylht.dao.BaseDao;
import com.chlab.zylht.entity.User;
import com.chlab.zylht.entity.vo.VClub;

public interface ClubDao extends BaseDao {
	
	List<VClub> listClub();
	
	List<User> listUser(@Param("id") int id);
	
}
