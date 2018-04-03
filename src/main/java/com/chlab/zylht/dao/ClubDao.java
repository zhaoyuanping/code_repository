package com.chlab.zylht.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.chlab.zylht.dao.BaseDao;
import com.chlab.zylht.entity.Club;
import com.github.pagehelper.Page;

public interface ClubDao extends BaseDao {

	/**
	 * 根据ID获取俱乐部
	 * @param id 俱乐部ID
	 * @return
	 */
	Club getClubById(@Param("id") int id);
	
	/**
	 * 获取所有俱乐部
	 * @return
	 */
	Page<Club> listClub();
	
	/**
	 * 根据用户ID获取俱乐部列表
	 * @param userId 用户ID
	 * @return
	 */
	Page<Club> listClubByUserId(@Param("userId") int userId);
	
	/**
	 * 添加俱乐部数据
	 * @param club 俱乐部模型对象
	 */
	int addClub(Club club);
	
	/**
	 * 修改俱乐部数据
	 * @param club 俱乐部模型对象
	 */
	void updateClub(Club club);
	
	/**
	 * 根据ID删除俱乐部
	 * @param id
	 */
	void deleteById(@Param("id") int id);
	
	/**
	 * 获取俱乐部牌局列表
	 * @param clubId 俱乐部ID
	 * @return
	 */
	Page<Map<String, Object>> listClubGame(@Param("clubId") Integer clubId,@Param("userId") Integer userId);
	
	/**
	 * 根据俱乐部邀请码查询俱乐部ID
	 * @param inviteCode 俱乐部邀请码
	 * @return
	 */
	Integer getClubByInviteCode(@Param("inviteCode") String inviteCode);
	
	int isExitsInviteCode(@Param("inviteCode") int inviteCode);
	
	/**
	 * 修改俱乐部剩余积分
	 * @param score 积分
	 * @param id 俱乐部ID
	 */
	void updateScore(@Param("score") int score,@Param("id") int id);
	
	/**
	 * 根据俱乐部ID获取俱乐部和俱乐部创建者头像信息
	 * @param clubId 俱乐部ID
	 * @return
	 */
	Map<String, Object> getClubAndUser(@Param("clubId") int clubId);
}
