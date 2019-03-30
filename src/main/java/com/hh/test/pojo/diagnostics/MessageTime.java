package com.hh.test.pojo.diagnostics;

/**
 * avid 日志中message字段安装time 进分组
 * @author smg
 *
 */
public class MessageTime {
	
	private String time;
	private int cnt;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "MessageTime [time=" + time + ", cnt=" + cnt + "]";
	}
	
}
