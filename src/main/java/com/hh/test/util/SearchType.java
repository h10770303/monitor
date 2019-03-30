package com.hh.test.util;

public class SearchType {
	protected String startDt;
	protected String endDt;
	protected String programTitle;
	protected int pageNo;
	protected int pageSize;
	
	private String sortName;
	private String sortOrder;
	
	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName=sortName.substring(0, sortName.length()-1);
//		this.sortName = sortName;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public int getPageNo() {
		int startRow = (this.pageNo - 1) * this.pageSize;
		return startRow;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getStartDt() {
		return startDt;
	}

	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}

	public String getEndDt() {
		return endDt;
	}

	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}

	public String getProgramTitle() {
		return programTitle;
	}

	public void setProgramTitle(String programTitle) {
		this.programTitle = programTitle;
	}

	@Override
	public String toString() {
		return "SearchType [startDt=" + startDt + ", endDt=" + endDt + ", programTitle=" + programTitle + ", pageNo="
				+ pageNo + ", pageSize=" + pageSize + ", sortName=" + sortName + ", sortOrder=" + sortOrder + "]";
	}

}