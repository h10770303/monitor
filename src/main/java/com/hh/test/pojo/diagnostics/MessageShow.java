package com.hh.test.pojo.diagnostics;

import java.util.List;

/**
 * avid 日志中message字段分解
 * 
 * @author smg
 *
 */
public class MessageShow {

	private String id;// 日志中di
	private String limits;
	private String marks;
	private String duration;
	private String diffTime;
	List<MessageDiff> diffs;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLimits() {
		return limits;
	}

	public void setLimits(String limits) {
		this.limits = limits;
	}

	public String getMarks() {
		return marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDiffTime() {
		return diffTime;
	}

	public void setDiffTime(String diffTime) {
		this.diffTime = diffTime;
	}

	public List<MessageDiff> getDiffs() {
		return diffs;
	}

	public void setDiffs(List<MessageDiff> diffs) {
		this.diffs = diffs;
	}
	

	@Override
	public String toString() {
		return "MessageShow [id=" + id + ", limits=" + limits + ", marks=" + marks + ", duration=" + duration
				+ ", diffTime=" + diffTime + ", diffs=" + diffs + "]";
	}
}
