package com.hh.test.util;

/**
 * 查询xnews 的查询参数
 * @author smg
 *
 */
public class SearchXnews {
	protected String startDt;
	protected String endDt;
	protected String assetcategoryId;
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
	public String getAssetcategoryId() {
		return assetcategoryId;
	}
	public void setAssetcategoryId(String assetcategoryId) {
		this.assetcategoryId = assetcategoryId;
	}
	@Override
	public String toString() {
		return "SearchXnews [startDt=" + startDt + ", endDt=" + endDt + ", assetcategoryId=" + assetcategoryId + "]";
	}

}