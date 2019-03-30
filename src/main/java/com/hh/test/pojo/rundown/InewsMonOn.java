package com.hh.test.pojo.rundown;

import java.util.Date;

public class InewsMonOn {

	
	private String id;
	private int day;
	private String studio;
	private String time;
	private String inewsServer;
	private String createBy;
	private String queue;
	private Date createTime;
	private String remark;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getInewsServer() {
		return inewsServer;
	}
	public void setInewsServer(String inewsServer) {
		this.inewsServer = inewsServer;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getQueue() {
		return queue;
	}
	public void setQueue(String queue) {
		this.queue = queue;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStudio() {
		return studio;
	}
	public void setStudio(String studio) {
		this.studio = studio;
	}
	@Override
	public String toString() {
		return "InewsMonOn [id=" + id + ", day=" + day + ", studio=" + studio + ", time=" + time + ", inewsServer="
				+ inewsServer + ", createBy=" + createBy + ", queue=" + queue + ", createTime=" + createTime
				+ ", remark=" + remark + "]";
	}
	
}
