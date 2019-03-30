package com.hh.test.pojo.param;

public class RundownType {
	protected String cName;
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

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	@Override
	public String toString() {
		return "RundownType [cName=" + cName + ", pageNo=" + pageNo + ", pageSize=" + pageSize + ", sortName="
				+ sortName + ", sortOrder=" + sortOrder + "]";
	}


}