package com.hh.test.pojo.bean;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ToXnewsCnt {
	
	
	private int count;
	private int kankanCnt;
	private Date createTime;
	private String createTimed;
	private String percent;
	

	public String getPercent() {
		DecimalFormat df = new DecimalFormat(".00");
		return df.format(this.kankanCnt/(this.count*1.0)*100);
	}
	public void setPercent(String percent) {
		this.percent = percent;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getKankanCnt() {
		return kankanCnt;
	}
	public void setKankanCnt(int kankanCnt) {
		this.kankanCnt = kankanCnt;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	public String getCreateTimed() {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		
		return sdf.format(getCreateTime());
	}
	public void setCreateTimed(String createTimed) {
		this.createTimed = createTimed;
	}
	@Override
	public String toString() {
		return "ToXnewsCnt [count=" + count + ", kankanCnt=" + kankanCnt + ", createTime=" + createTime
				+ ", createTimed=" + createTimed + ", percent=" + percent + "]";
	}
	
}
