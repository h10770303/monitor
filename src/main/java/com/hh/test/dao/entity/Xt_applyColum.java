package com.hh.test.dao.entity;

public class Xt_applyColum {
	private int id;
	private String columName;
	private int status; //0 正常  1 已删除
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getColumName() {
		return columName;
	}
	public void setColumName(String columName) {
		this.columName = columName;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Xt_applyColum [id=" + id + ", columName=" + columName + ", status=" + status + "]";
	}
	
}
