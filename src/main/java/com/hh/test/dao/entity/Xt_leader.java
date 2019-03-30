package com.hh.test.dao.entity;

public class Xt_leader {
	private int id;
	private String userName;
	private String channel;
	private int status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Xt_leader [id=" + id + ", userName=" + userName + ", channel=" + channel + ", status=" + status + "]";
	}

}
