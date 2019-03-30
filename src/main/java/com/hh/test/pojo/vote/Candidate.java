package com.hh.test.pojo.vote;

import com.hh.test.statics.VoteStatic;

/**
 * 投票候选人
 * @author smg
 *
 */
public class Candidate {
	
	private int id;
	private  int starType;
	private  String starTypes;
	private int userId;
	private String userName;
	private String partment;
	private int sex;
	private String sexs;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPartment() {
		return partment;
	}
	public void setPartment(String partment) {
		this.partment = partment;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getSexs() {
		sexs=this.sex==1?"男":"女";
		return sexs;
	}
	public void setSexs(String sexs) {
		this.sexs = sexs;
	}
	@Override
	public String toString() {
		return "Candidate [id=" + id + ", starType=" + starType + ", starTypes=" + starTypes + ", userId=" + userId
				+ ", userName=" + userName + ", partment=" + partment + ", sex=" + sex + ", sexs=" + sexs + "]";
	}

}
