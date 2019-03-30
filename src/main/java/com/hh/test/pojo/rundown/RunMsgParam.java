package com.hh.test.pojo.rundown;

public class RunMsgParam {
	
	private String startDt;
	private String endDt;
	public String getStartDt() {
		return startDt;
	}
	public void setStartDt(String startDt) {
		this.startDt = startDt;
	}
	public String getEndDt() {
		return endDt;
	}
	public void setEndDt(String endDt) {
		this.endDt = endDt;
	}
	@Override
	public String toString() {
		return "RunMshParam [startDt=" + startDt + ", endDt=" + endDt + "]";
	}
	
	

}
