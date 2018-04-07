package com.chlab.zylht.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chlab.zylht.dao.ClubDao;
import com.chlab.zylht.entity.User;
import com.chlab.zylht.entity.vo.VClub;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class ClubService {
	
	@Autowired
	private ClubDao clubDao;

	public Page<VClub> listClub(Integer pageNum, Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		return (Page<VClub>) clubDao.listClub();
	}
	
	public List<User> listUser(int id){
		
		return clubDao.listUser(id);
	}
}
