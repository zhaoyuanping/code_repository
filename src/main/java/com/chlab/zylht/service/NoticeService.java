package com.chlab.zylht.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.chlab.zylht.dao.NoticeDao;
import com.chlab.zylht.entity.Notice;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Component
@Service
public class NoticeService {
	
	@Autowired
	private NoticeDao dao;
	
	public Page<Notice> listNotice(Integer pageNum, Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		
		return dao.listNotice();
	}
	
	public Notice getNoticeById(int id) {
		
		return dao.getNoticeById(id);
	}
	
	public void update(Notice announcement) {
		if(null != announcement.getId()) {
			dao.updateNotice(announcement);
		}
		else {
			dao.addNotice(announcement);
		}
	}
	
	public void updateStatus(Integer status,Integer rack, int id) {
		dao.updateStatus(status, rack, id);
	}
	
	public int countStatus(){
		
		return dao.countStatus();
	}
	public int countRack() {
		
		return dao.countRack();
	}
	
	public void delete(int id) {
//		Announcement announcement = dao.getAnnouncementById(id);
//		if(null != announcement && announcement.getStatus() == 0) {
//			dao.deleteAnnouncement(id);
//			
//			return ResultInfo.getSuccessInfo("删除成功");
//		}
//		
//		return ResultInfo.getSuccessInfo("公告已发布，不能删除");
		dao.deleteNotice(id);
	}

}
