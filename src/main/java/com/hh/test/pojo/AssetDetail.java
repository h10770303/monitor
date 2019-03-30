package com.hh.test.pojo;

import java.util.Date;

public class AssetDetail {
	
	
	private String id;
	private String assetType;
	private String type;
	private String name;
	private String author;
	private Date assetTime;
	private Date createTime;
	private String remark;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 资产类型  ：clue topic tile
	 * @return
	 */
	public String getAssetType() {
		return assetType;
	}
	public void setAssetType(String assetType) {
		this.assetType = assetType;
	}
	/**
	 * 资产类型
	 * @return
	 */
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 资产名字
	 * @return
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 作者
	 * @return
	 */
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * 资产时间
	 * @return
	 */
	public Date getAssetTime() {
		return assetTime;
	}
	public void setAssetTime(Date assetTime) {
		this.assetTime = assetTime;
	}
	
	/**
	 * 创建时间
	 * @return
	 */
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 备注
	 * @return
	 */
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "AssetDetail [id=" + id + ", assetType=" + assetType + ", type=" + type + ", name=" + name + ", author="
				+ author + ", assetTime=" + assetTime + ", createTime=" + createTime + ", remark=" + remark + "]";
	}
	
	
	
}
