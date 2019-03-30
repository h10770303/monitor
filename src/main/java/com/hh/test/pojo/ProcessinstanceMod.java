package com.hh.test.pojo;

import java.util.Date;

/**
 * 送看看流程表
 * @author smg
 *
 */
public class ProcessinstanceMod {
	
	
	private String id;
	private String moid;
	private String processInstanceName;
	private String creator;
	private Date createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMoid() {
		return moid;
	}
	public void setMoid(String moid) {
		this.moid = moid;
	}
	public String getProcessInstanceName() {
		return processInstanceName;
	}
	public void setProcessInstanceName(String processInstanceName) {
		this.processInstanceName = processInstanceName;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "ProcessinstanceMod [id=" + id + ", moid=" + moid + ", processInstanceName=" + processInstanceName
				+ ", creator=" + creator + ", createTime=" + createTime + "]";
	}
	
}
