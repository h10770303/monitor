package com.hh.test.pojo;

import java.util.Date;

public class DeviceLbs {

	private String moId;
	private String deviceId;
	private Date reportTime;
	private String lbs;
	private String description;

	public String getMoId() {
		return moId;
	}

	public void setMoId(String moId) {
		this.moId = moId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public Date getReporteTime() {
		return reportTime;
	}

	public void setReporteTime(Date reporteTime) {
		this.reportTime = reporteTime;
	}

	public String getLbs() {
		return lbs;
	}

	public void setLbs(String lbs) {
		this.lbs = lbs;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "DeviceLbs [moId=" + moId + ", deviceId=" + deviceId + ", reporteTime=" + reportTime + ", lbs=" + lbs
				+ ", description=" + description + "]";
	}

}
