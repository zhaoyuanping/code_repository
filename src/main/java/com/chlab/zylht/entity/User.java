package com.chlab.zylht.entity;

import java.util.Date;

public class User {

	private Integer id ;
	private String openid; //varchar(50) COLLATE utf8_bin NOT NULL COMMENT '微信openid',
	private String email; //varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱地址',
	private String phone; //varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '电话',
	private Date crtime; //datetime DEFAULT NULL COMMENT '创建时间',
	private Date uptime; //datetime DEFAULT NULL COMMENT '更新时间',
	private String himg; //varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '头像地址',
	private char utype; //char(1) COLLATE utf8_bin DEFAULT NULL COMMENT '1管理员2群主3玩家',
	private String uname; //varchar(50) COLLATE utf8_bin DEFAULT NULL COMMENT '用户昵称',

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getCrtime() {
		return crtime;
	}
	public void setCrtime(Date crtime) {
		this.crtime = crtime;
	}
	public Date getUptime() {
		return uptime;
	}
	public void setUptime(Date uptime) {
		this.uptime = uptime;
	}
	public String getHimg() {
		return himg;
	}
	public void setHimg(String himg) {
		this.himg = himg;
	}
	public char getUtype() {
		return utype;
	}
	public void setUtype(char utype) {
		this.utype = utype;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
