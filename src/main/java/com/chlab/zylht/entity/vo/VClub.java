package com.chlab.zylht.entity.vo;

import java.util.Date;
import java.util.List;

import com.chlab.zylht.entity.User;

public class VClub {
	
	private Integer id;  //俱乐部ID
	private String name; //俱乐部名称
	private String uname;   //创建人
	private String himg; //俱乐部头像
	private Date crTime; //创建时间
	private int clubpeople; // 俱乐部人数
	private List<User> listUser; //俱乐部用户
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCrTime() {
		return crTime;
	}
	public void setCrTime(Date crTime) {
		this.crTime = crTime;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getHimg() {
		return himg;
	}
	public void setHimg(String himg) {
		this.himg = himg;
	}
	public List<User> getListUser() {
		return listUser;
	}
	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}
	public int getClubpeople() {
		return clubpeople;
	}
	public void setClubpeople(int clubpeople) {
		this.clubpeople = clubpeople;
	}
	
	
}
