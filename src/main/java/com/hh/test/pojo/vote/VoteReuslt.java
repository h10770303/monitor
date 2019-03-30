package com.hh.test.pojo.vote;

import java.util.Date;

import com.hh.test.statics.VoteStatic;

/**
 * 投票结果
 * @author smg
 *
 */
public class VoteReuslt {
	
	private String id;
	private int partment;
	private String userName;
	private int starType;
	private String starTypes;
	private String candidate;
	private Date createTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPartment() {
		return partment;
	}
	public void setPartment(int partment) {
		this.partment = partment;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getStarType() {
		return starType;
	}
	public void setStarType(int starType) {
		this.starType = starType;
	}
	
	public String getStarTypes() {
		starTypes=(String) VoteStatic.starMap.get(this.starType);
		return starTypes;
	}
	public void setStarTypes(String starTypes) {
		this.starTypes = starTypes;
	}
	public String getCandidate() {
		return candidate;
	}
	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "VoteReuslt [id=" + id + ", partment=" + partment + ", userName=" + userName + ", starType=" + starType
				+ ", candidate=" + candidate + ", createTime=" + createTime + "]";
	}
	
}
