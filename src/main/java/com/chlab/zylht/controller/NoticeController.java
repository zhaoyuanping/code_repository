package com.chlab.zylht.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.chlab.zylht.entity.Notice;
import com.chlab.zylht.service.NoticeService;
import com.chlab.zylht.util.PageData;
import com.github.pagehelper.Page;

/**
 * 公告控制类
 */
@Controller
@RequestMapping("notice")
public class NoticeController extends BaseController{
	
	@Autowired
	private NoticeService service;

	/**
	 * 获取公告列表数据
	 * @param pageNum 开始页数
	 * @param pageSize 页大小
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public PageData listAnnouncement(Integer pageNum, Integer pageSize){
		pageNum = pageNum == null? 1 : pageNum;
		pageSize = pageSize == null? 5 : pageSize;
		Page<Notice> page = service.listNotice(pageNum, pageSize);
		
		return pageData(page);
	}
	
	
	/**
	 * 根据ID获取公告对象数据
	 * @param id 主键ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getNoticeById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Object> getNoticeById(@RequestParam int id) {
		Notice notice = service.getNoticeById(id);
		
		return successMsg(notice);
	}
	
	/**
	 * 修改顶置状态
	 * @param id 主键ID
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/updateStatus", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Object> updateStatus(@RequestParam int status, @RequestParam int id) {
		try {
			service.updateStatus(status, id);
			
			return successMsg("保存成功");
		} catch (Exception e) {
			
			return failMsg("保存失败，请联系系统管理员!");
		}
	}
	
	/**
	 * 添加和修改公告接口
	 * @param announcement
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Object> update(Notice notice,@RequestParam MultipartFile file) {
		try {
			if(null != file && file.getBytes().length > 0) {
				byte[] bytes = file.getBytes();
				notice.setImage(bytes);
			}
			notice.setUserId(getLoginUser().getId());
			service.update(notice);
			
			return successMsg("添加成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return failMsg("添加失败，请联系系统管理员!");
		}
	}
	
	/**
	 * 删除公告
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Map<String, Object> delete(@RequestParam int id) {
		try {
			service.delete(id);
			
			return successMsg("删除成功");
		} catch (Exception e) {
			// TODO: handle exception
			return failMsg("删除失败，请联系系统管理员!");
		}
	}
	
	@RequestMapping(value = "/getImg", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public void getImg(HttpServletResponse response, @RequestParam int id) {
		ServletOutputStream out = null;
		Notice notice = service.getNoticeById(id);
		byte[] bytes = null;
		if(null != notice) {
			bytes = notice.getImage();
			try {
				if(null != bytes && bytes.length > 0) {
					out = response.getOutputStream();
		            out.write(bytes);  
		            out.flush(); 
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {  
				try {
					if(null != out) 
						out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        } 
		}
	}
	
}
