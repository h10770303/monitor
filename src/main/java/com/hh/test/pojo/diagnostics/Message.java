package com.hh.test.pojo.diagnostics;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * avid 日志中message字段分解
 * @author smg
 *
 */
public class Message {
	
//	private String messageId;//主键
	private String id;// 日志中di
	private String limits;
	private String marks;
	private String duration;
	
	private String hostName;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date time;
//	private Date createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLimits() {
		return limits;
	}
	public void setLimits(String limits) {
		this.limits = limits;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
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
		return "Message [id=" + id + ", limits=" + limits + ", marks=" + marks + ", duration=" + duration
				+ ", hostName=" + hostName + ", time=" + time + "]";
	}
	
}
