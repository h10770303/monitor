package com.hh.test.pojo.bean;

/**
 * 线索各部门报片统计
 * 
 * @author smg
 *
 */
public class ClueFrom {

	private String bumen;
	private int count;
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
	@Override
	public String toString() {
		return "ClueFrom [bumen=" + bumen + ", count=" + count + "]";
	}


}
