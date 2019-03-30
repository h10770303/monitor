package com.hh.test.pojo;

import java.util.Date;

public class XnewsData {

	private String moid;
	private String assetcategoryId;
	private String createdBy;
	private String bumen;
	private String assetName;
	private Date creationTime;
	private Date assetDate;
	private String target;
	private String platform;
	private String site;
	private String createdto;
	private String channelpath;
	private String videoFlag;
	private String picFlag;
	public String getMoid() {
		return moid;
	}
	public void setMoid(String moid) {
		this.moid = moid;
	}
	public String getAssetcategoryId() {
		return assetcategoryId;
	}
	public void setAssetcategoryId(String assetcategoryId) {
		this.assetcategoryId = assetcategoryId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getBumen() {
		return bumen;
	}
	public void setBumen(String bumen) {
		this.bumen = bumen;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public Date getAssetDate() {
		return assetDate;
	}
	public void setAssetDate(Date assetDate) {
		this.assetDate = assetDate;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getCreatedto() {
		return createdto;
	}
	public void setCreatedto(String createdto) {
		this.createdto = createdto;
	}
	public String getChannelpath() {
		return channelpath;
	}
	public void setChannelpath(String channelpath) {
		this.channelpath = channelpath;
	}
	public String getVideoFlag() {
		return videoFlag;
	}
	public void setVideoFlag(String videoFlag) {
		this.videoFlag = videoFlag;
	}
	public String getPicFlag() {
		return picFlag;
	}
	public void setPicFlag(String picFlag) {
		this.picFlag = picFlag;
	}
	@Override
	public String toString() {
		return "XnewsData [moid=" + moid + ", assetcategoryId=" + assetcategoryId + ", createdBy=" + createdBy
				+ ", bumen=" + bumen + ", assetName=" + assetName + ", creationTime=" + creationTime + ", assetDate="
				+ assetDate + ", target=" + target + ", platform=" + platform + ", site=" + site + ", createdto="
				+ createdto + ", channelpath=" + channelpath + ", videoFlag=" + videoFlag + ", picFlag=" + picFlag
				+ "]";
	}

}