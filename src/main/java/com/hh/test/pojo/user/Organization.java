package com.hh.test.pojo.user;

public class Organization {
	
	private String organizationId;
	private String organizationName;
	private String organizationType;
	private String parentId;
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
	public String getOrganizationType() {
		return organizationType;
	}
	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	@Override
	public String toString() {
		return "Organization [organizationId=" + organizationId + ", organizationName=" + organizationName
				+ ", organizationType=" + organizationType + ", parentId=" + parentId + "]";
	}
}
