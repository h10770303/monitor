package com.hh.test.pojo.bean;

/**
 * 在线人数统计
 * @author smg
 *
 */
public class Logon {

	private String logonType;//登陆方式
	private int count;
	public String getLogonType() {
		return logonType;
	}
	public void setLogonType(String logonType) {
		this.logonType = logonType;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Logon [logonType=" + logonType + ", count=" + count + "]";
	}


}
