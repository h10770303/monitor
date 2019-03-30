package com.hh.test.pojo.pd1000;

public class Pdduration {
	
	private String pddate;
	private String pdtime;
	private String date;
	private String time;
	private String content;
	private String duration;
	public String getPddate() {
		return pddate;
	}
	public void setPddate(String pddate) {
		this.pddate = pddate;
	}
	public String getPdtime() {
		return pdtime;
	}
	public void setPdtime(String pdtime) {
		this.pdtime = pdtime;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "Pdduration [pddate=" + pddate + ", pdtime=" + pdtime + ", date=" + date + ", time=" + time
				+ ", content=" + content + ", duration=" + duration + "]";
	}

}
