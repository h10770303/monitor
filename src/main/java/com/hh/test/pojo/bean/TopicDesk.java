package com.hh.test.pojo.bean;

/**
 * 选题 desk 分类
 * @author smg
 *
 */
public class TopicDesk {

	private String createdto;
	private int count;
	public String getCreatedto() {
		return createdto;
	}
	public void setCreatedto(String createdto) {
		this.createdto = createdto;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "TopicDesk [createdto=" + createdto + ", count=" + count + "]";
	}
	


}
