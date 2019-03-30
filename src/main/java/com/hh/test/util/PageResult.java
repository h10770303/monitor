package com.hh.test.util;

import java.util.List;

public class PageResult<T> {

	private int total;// 总记录条数


	private List<T> records;// 返回记录条数


	public PageResult() {
	}



	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRecords() {
		return records;
	}

	public void setRecords(List<T> records) {
		this.records = records;
	}


	@Override
	public String toString() {
		return "PageResult [total=" + total + ", records=" + records + "]";
	}

}