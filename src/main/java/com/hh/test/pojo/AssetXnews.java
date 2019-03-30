package com.hh.test.pojo;

import java.util.Date;

public class AssetXnews {
	
	
	private String assetType;
	private String assetName;
	private String assetSite;
//	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
	private Date time;
	public String getAssetType() {
		return assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public String getAssetSite() {
		return assetSite;
	}
	public void setAssetSite(String assetSite) {
		this.assetSite = assetSite;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "AssetXnews [assetType=" + assetType + ", assetName=" + assetName + ", assetSite=" + assetSite
				+ ", time=" + time + "]";
	}
	
	
}
