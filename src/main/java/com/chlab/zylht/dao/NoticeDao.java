package com.chlab.zylht.dao;

import org.apache.ibatis.annotations.Param;

import com.chlab.zylht.entity.Notice;
import com.github.pagehelper.Page;

/**
 * @author zyp
 * 公告
 */
public interface NoticeDao extends BaseDao {
	
	/**
	 * 获取公告列表
	 * @return
	 */
	Page<Notice> listNotice();
	
	/**
	 * 根据ID获取公告对象数据
	 * @param id 主键ID
	 * @return 公告对象 Announcement
	 */
	Notice getNoticeById(@Param("id")int id);

	/**
	 * 新增公告数据
	 * @param announcement 公告对象
	 */
	void addNotice(Notice notice);
	
	/**
	 * 修改公告数据
	 * @param announcement 公告对象
	 */
	void updateNotice(Notice notice);
	
	/**
	 * 修改公告顶置状态
	 * @param id 主键ID
	 */
	void updateStatus(@Param("status")int status ,@Param("id")int id);
	
	/**
	 * 删除公告
	 * @param id 主键ID
	 */
	void deleteNotice(int id);
}
