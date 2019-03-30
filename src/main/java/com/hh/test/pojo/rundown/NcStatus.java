package com.hh.test.pojo.rundown;

import java.util.Date;

public class NcStatus {

	
	private String id;
	private String alias;
	private String address;
	private Date createDate;
	private int status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "NcStatus [id=" + id + ", alias=" + alias + ", address=" + address + ", createDate=" + createDate
				+ ", status=" + status + "]";
	}
	
}