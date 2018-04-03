package com.chlab.zylht.entity;

import java.util.Date;

/**
 * 俱乐部
 */
public class Club {
	
	private Integer id;
	private String name;
	private int cruser;
	private String introduc; //简介
	private Date crTime;
	private Date upTime;
	private String inviteCode; //俱乐部邀请码
	
	private int score; //俱乐部剩余积分
	
	
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
	public int getCruser() {
		return cruser;
	}
	public void setCruser(int cruser) {
		this.cruser = cruser;
	}
	public String getIntroduc() {
		return introduc;
	}
	public void setIntroduc(String introduc) {
		this.introduc = introduc;
	}
	public Date getCrTime() {
		return crTime;
	}
	public void setCrTime(Date crTime) {
		this.crTime = crTime;
	}
	public Date getUpTime() {
		return upTime;
	}
	public void setUpTime(Date upTime) {
		this.upTime = upTime;
	}
	public String getInviteCode() {
		return inviteCode;
	}
	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
