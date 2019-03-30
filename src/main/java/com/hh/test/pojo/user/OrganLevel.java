package com.hh.test.pojo.user;

public class OrganLevel {
	
	private String organizationId;
	private String organizationName;
	private String organizationType;
	private int level;
	private String level1;
	private String level2;
	private String level3;
	private String level4;
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
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public String getLevel1() {
		return level1;
	}
	public void setLevel1(String level1) {
		this.level1 = level1;
	}
	public String getLevel2() {
		return level2;
	}
	public void setLevel2(String level2) {
		this.level2 = level2;
	}
	public String getLevel3() {
		return level3;
	}
	public void setLevel3(String level3) {
		this.level3 = level3;
	}
	public String getLevel4() {
		return level4;
	}
	public void setLevel4(String level4) {
		this.level4 = level4;
	}
	@Override
	public String toString() {
		return "OrganLevel [organizationId=" + organizationId + ", organizationName=" + organizationName
				+ ", organizationType=" + organizationType + ", level=" + level + ", level1=" + level1 + ", level2="
				+ level2 + ", level3=" + level3 + ", level4=" + level4 + "]";
	}
	
	
}
