package com.hh.test.dao.entity;

import java.util.Date;

public class Xt_Apply {
	private String id;
	private String applyName;
	private String name_pinyin;
	private String userId;
	private String partment;
	private String columns;
	private String phoneNo;
	private String accountType;
	private String applyColum;
	private String applyColums;
	private String inews;
	private String videos;
	private String xnews;
	private String description;
	private String leaderName;
	private Date createDate;
	private int status;
	private Date approveDate;
	private String finsher;
	private Date finshDate;
	public String getApplyName() {
		return applyName;
	}
	public void setApplyName(String applyName) {
		this.applyName = applyName;
	}
	public String getName_pinyin() {
		return name_pinyin;
	}
	public void setName_pinyin(String name_pinyin) {
		this.name_pinyin = name_pinyin;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPartment() {
		return partment;
	}
	public void setPartment(String partment) {
		this.partment = partment;
	}
	
	public String getColumns() {
		return columns;
	}
	public void setColumns(String columns) {
		this.columns = columns;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getApplyColum() {
		return applyColum;
	}
	public void setApplyColum(String applyColum) {
		this.applyColum = applyColum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getInews() {
		return inews;
	}
	public void setInews(String inews) {
		this.inews = inews;
	}
	public String getVideos() {
		return videos;
	}
	public void setVideos(String videos) {
		this.videos = videos;
	}
	public String getXnews() {
		return xnews;
	}
	public void setXnews(String xnews) {
		this.xnews = xnews;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLeaderName() {
		return leaderName;
	}
	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getApproveDate() {
		return approveDate;
	}
	public void setApproveDate(Date approveDate) {
		this.approveDate = approveDate;
	}
	public String getFinsher() {
		return finsher;
	}
	public void setFinsher(String finsher) {
		this.finsher = finsher;
	}
	public Date getFinshDate() {
		return finshDate;
	}
	public void setFinshDate(Date finshDate) {
		this.finshDate = finshDate;
	}
	
	public String getApplyColums() {
		return applyColums;
	}
	public void setApplyColums(String applyColums) {
		this.applyColums = applyColums;
	}
	@Override
	public String toString() {
		return "Xt_Apply [id=" + id + ", applyName=" + applyName + ", name_pinyin=" + name_pinyin + ", userId=" + userId
				+ ", partment=" + partment + ", columns=" + columns + ", phoneNo=" + phoneNo + ", accountType="
				+ accountType + ", applyColum=" + applyColum + ", inews=" + inews + ", videos=" + videos + ", xnews="
				+ xnews + ", description=" + description + ", leaderName=" + leaderName + ", createDate=" + createDate
				+ ", status=" + status + ", approveDate=" + approveDate + ", finsher=" + finsher + ", finshDate="
				+ finshDate + "]";
	}
	
}
