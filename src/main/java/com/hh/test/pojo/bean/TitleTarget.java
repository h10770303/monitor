package com.hh.test.pojo.bean;

/**
 * 报道发布平台统计
 * 
 * @author smg
 *
 */
public class TitleTarget {

	private String target;
	private int count;

	@Override
	public String toString() {
		return "TitleTarget [target=" + target + ", count=" + count + "]";
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
