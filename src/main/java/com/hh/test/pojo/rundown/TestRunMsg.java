package com.hh.test.pojo.rundown;

import java.util.List;

public class TestRunMsg {
	
	private List<NcStatus> ncStatus;
	private List<InewsMonOn> inewsMonOns;
	private List<CheckInterplay> checkInterplays;
	private List<String> messages;
	public List<NcStatus> getNcStatus() {
		return ncStatus;
	}
	public void setNcStatus(List<NcStatus> ncStatus) {
		this.ncStatus = ncStatus;
	}
	public List<InewsMonOn> getInewsMonOns() {
		return inewsMonOns;
	}
	public void setInewsMonOns(List<InewsMonOn> inewsMonOns) {
		this.inewsMonOns = inewsMonOns;
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	public List<CheckInterplay> getCheckInterplays() {
		return checkInterplays;
	}
	public void setCheckInterplays(List<CheckInterplay> checkInterplays) {
		this.checkInterplays = checkInterplays;
	}
	@Override
	public String toString() {
		return "TestRunMsg [ncStatus=" + ncStatus + ", inewsMonOns=" + inewsMonOns + ", checkInterplays="
				+ checkInterplays + ", messages=" + messages + "]";
	}
	
}
