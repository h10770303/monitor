package com.hh.test.pojo.diagnostics;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 两个studio 不同字段
 * @author smg
 *
 */
public class MessageDiff {
	
	private String hostName;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date time;
//
	public String getHostName() {
		return hostName;
	}
	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "MessageDiff [hostName=" + hostName + ", time=" + time + "]";
	}
	
}
