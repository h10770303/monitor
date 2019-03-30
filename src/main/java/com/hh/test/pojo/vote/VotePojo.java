package com.hh.test.pojo.vote;

import java.util.Arrays;

/**
 * 页面序列化
 * @author smg
 *
 */
public class VotePojo {
	
	private int partment;
	private String userName;
	private Star[] stars;
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
	public Star[] getStars() {
		return stars;
	}
	public void setStars(Star[] stars) {
		this.stars = stars;
	}
	@Override
	public String toString() {
		return "VotePojo [partment=" + partment + ", userName=" + userName + ", stars=" + Arrays.toString(stars) + "]";
	}
	
}
