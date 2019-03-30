package com.hh.test.pojo.weixin;

public class OpenId {

	private int id;
	private String userName;
	private String alias;
	private String openId;
	private String remarks;

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

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "OpenId [id=" + id + ", userName=" + userName + ", alias=" + alias + ", openId=" + openId + ", remarks="
				+ remarks + "]";
	}

}
