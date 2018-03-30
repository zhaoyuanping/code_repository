package com.chlab.zylht.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author zyp
 * 公告模型对象
 */
public class Notice {

	private Integer id;
	private String title;     //公告标题
	private byte[] image;       //公告标题图片
	private String content;   //公告内容
	private int	userId;       //创建用户
	private Date createTime;  //创建时间
	private Date updateTime;  //发布时间
	private int status;       //顶置[1-顶置，0-普通]
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
}
