package com.hh.test.pojo.bean;

/**
 * 选题 desk 分类
 * @author smg
 *
 */
public class TopicRefcount {

	private String bumen;
	private int count;
	private int refcnt;
	public String getBumen() {
		return bumen;
	}
	public void setBumen(String bumen) {
		this.bumen = bumen;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getRefcnt() {
		return refcnt;
	}
	public void setRefcnt(int refcnt) {
		this.refcnt = refcnt;
	}
	@Override
	public String toString() {
		return "TopicRefcount [bumen=" + bumen + ", count=" + count + ", refcnt=" + refcnt + "]";
	}
	
}
