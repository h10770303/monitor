package com.hh.test.pojo.vote;

import com.hh.test.statics.VoteStatic;

/**
 * 部门投票统计
 * @author smg
 *
 */
public class PartmentCnt {

	private int partment;
	private String partments;
	private String candidate;
	private int cnt;
	public int getPartment() {
		return partment;
	}
	public void setPartment(int partment) {
		this.partment = partment;
	}
	public String getPartments() {
		partments=(String) VoteStatic.voteMap.get(this.partment);
		return partments;
	}
	public void setPartments(String partments) {
		this.partments = partments;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
	public String getCandidate() {
		return candidate;
	}
	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}
	@Override
	public String toString() {
		return "PartmentCnt [partment=" + partment + ", partments=" + partments + ", candidate=" + candidate + ", cnt="
				+ cnt + "]";
	}
	
}
