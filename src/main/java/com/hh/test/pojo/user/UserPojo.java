package com.hh.test.pojo.user;

public class UserPojo {
	
	private String userId;
	private String userName;
	private String organizationId;
	private String organizationName;
	private String parentId;
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
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	@Override
	public String toString() {
		return "UserPojo [userId=" + userId + ", userName=" + userName + ", organizationId=" + organizationId
				+ ", organizationName=" + organizationName + ", parentId=" + parentId + "]";
	}
	
	
}
