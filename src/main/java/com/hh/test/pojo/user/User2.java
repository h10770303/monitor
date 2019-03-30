package com.hh.test.pojo.user;

import java.util.Date;

public class User2 {

	private String userId;
	private String userName;
	private String password;
	private String organizationId;
	private String organizationName;
	private Date createDate;

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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "User2 [userId=" + userId + ", userName=" + userName + ", password=" + password + ", organizationId="
				+ organizationId + ", organizationName=" + organizationName + ", createDate=" + createDate + "]";
	}
}
