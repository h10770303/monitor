package com.hh.test.pojo.vote;

/**
 * 投票人
 * @author smg
 *
 */
public class Votor {
	
	private int id;
	private String userId;
	private String userName;
	private String partment;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPartment() {
		return partment;
	}
	public void setPartment(String partment) {
		this.partment = partment;
	}
	@Override
	public String toString() {
		return "Votor [id=" + id + ", userId=" + userId + ", userName=" + userName + ", partment=" + partment + "]";
	}
	
}
