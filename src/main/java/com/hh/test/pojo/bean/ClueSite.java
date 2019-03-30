package com.hh.test.pojo.bean;

/**
 * 线索信源分类统计
 * 
 * @author smg
 *
 */
public class ClueSite {

	private String site;
	private int count;

	@Override
	public String toString() {
		return "ClueSite [site=" + site + ", count=" + count + "]";
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
