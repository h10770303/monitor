package com.hh.test.util;

import java.util.List;

public class PageResult2<T> {

	private int total;// 总记录条数


	private List<T> rows;// 返回记录条数


	public PageResult2() {
	}



	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}



	public List<T> getRows() {
		return rows;
	}



	public void setRows(List<T> rows) {
		this.rows = rows;
	}



	@Override
	public String toString() {
		return "PageResult [total=" + total + ", rows=" + rows + "]";
	}
	
}