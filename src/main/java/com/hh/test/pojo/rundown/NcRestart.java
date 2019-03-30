package com.hh.test.pojo.rundown;

import java.util.Date;

public class NcRestart {

	
	private Date start_time;
	private String output;
	private String host_id;
	private String alias;
	private String address;
	public Date getStart_time() {
		return start_time;
	}
	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}
	public String getOutput() {
		return output;
	}
	public void setOutput(String output) {
		this.output = output;
	}
	public String getHost_id() {
		return host_id;
	}
	public void setHost_id(String host_id) {
		this.host_id = host_id;
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
	@Override
	public String toString() {
		return "NcResart [start_time=" + start_time + ", output=" + output + ", host_id=" + host_id + ", alias=" + alias
				+ ", address=" + address + "]";
	}
	
}