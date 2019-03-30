package com.hh.test.pojo;

import java.util.Date;

public class AssetPojo {
	
	
	private String id;
	private String type;
	private String name;
	private Date createTime;
	private Integer number;
	private String remark;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "AssetByTime [id=" + id + ", type=" + type + ", name=" + name + ", createTime=" + createTime
				+ ", number=" + number + ", remark=" + remark + "]";
	}
	
	
}
