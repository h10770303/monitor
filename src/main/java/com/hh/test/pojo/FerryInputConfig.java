package com.hh.test.pojo;

import java.util.List;

public class FerryInputConfig {
	
	private iNews inews;
	private List<Channel> channels;
	public iNews getInews() {
		return inews;
	}
	public void setInews(iNews inews) {
		this.inews = inews;
	}
	public List<Channel> getChannels() {
		return channels;
	}
	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}
	@Override
	public String toString() {
		return "FerryInputConfig [inews=" + inews + ", channels=" + channels + "]";
	}
	
}
