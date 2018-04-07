package com.chlab.zylht.entity;

import java.util.Date;

public class Administrators {

	private Integer id ;//int(11) NOT NULL AUTO_INCREMENT,
	private String username ;// varchar(255) COLLATE utf8_bin NOT NULL,
	private String password ;// varchar(100) COLLATE utf8_bin NOT NULL,
	private String phone ;// varchar(11) COLLATE utf8_bin DEFAULT NULL COMMENT '联系电话',
	private String email ;// varchar(150) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
	private Integer status ;// int(11) NOT NULL COMMENT '是否禁用[0-禁用，1-启用]',
	private int type; //管理员类型
	private Date crtime ;// datetime NOT NULL,


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getCrtime() {
		return crtime;
	}
	public void setCrtime(Date crtime) {
		this.crtime = crtime;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}




}
