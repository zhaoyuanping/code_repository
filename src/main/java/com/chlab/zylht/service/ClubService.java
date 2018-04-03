package com.chlab.zylht.service;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chlab.zylht.dao.ClubDao;
import com.chlab.zylht.entity.Club;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class ClubService {
	
	@Autowired
	private ClubDao clubDao;

	/**
	 * 根据ID获取俱乐部
	 * @param id 俱乐部ID
	 * @return
	 */
	public Club getClubById(int id) {
		
		return clubDao.getClubById(id);
	}
	
	/**
	 * 获取所有俱乐部
	 * @return
	 */
	public Page<Club> listClub(Integer pageNum, Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		return clubDao.listClub();
	}
	
	
	/**
	 * 添加或修改俱乐部数据
	 * @param club 俱乐部模型对象
	 */
	public Club update(Club club, int userId) {
		if(null != club.getId()) {
			
			clubDao.updateClub(club);
		}
		
		return club;
	}
	
	/**
	 * 根据ID删除俱乐部
	 * @param id
	 */
	public void deleteById(int id) {
		clubDao.deleteById(id);
	}

	/**
	 * 获取俱乐部牌局列表
	 * @param clubId 俱乐部ID
	 * @return
	 */
	public Page<Map<String, Object>> listClubGame(Integer clubId, Integer userId,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		return clubDao.listClubGame(clubId, userId);
	}
	
	
	/**
	 * 根据俱乐部ID获取俱乐部和俱乐部创建者头像信息
	 * @param clubId 俱乐部ID
	 * @return
	 */
	public Map<String, Object> getClubAndUser(int clubId){
		
		return clubDao.getClubAndUser(clubId);
	}
	
}
