package com.hh.test.pojo.vote;

import java.util.Arrays;

/**
 *明星
 * @author smg
 *
 */
public class Star {
	
	private int starType;
	private String[] candidate;
	public int getStarType() {
		return starType;
	}
	public void setStarType(int starType) {
		this.starType = starType;
	}
	public String[] getCandidate() {
		return candidate;
	}
	public void setCandidate(String[] candidate) {
		this.candidate = candidate;
	}
	@Override
	public String toString() {
		return "Star [starType=" + starType + ", candidate=" + Arrays.toString(candidate) + "]";
	}
	

}
