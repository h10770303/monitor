package com.hh.test.pojo;

public class Channel {

	private boolean cliponly;
	private int interval;
	private String ntmscandir;
	private String targetqueue;
	private String targetdir;
	private String presetguid;
	private String scanext;
	private String scandir;

	public boolean isCliponly() {
		return cliponly;
	}

	public void setCliponly(boolean cliponly) {
		this.cliponly = cliponly;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public String getNtmscandir() {
		return ntmscandir;
	}

	public void setNtmscandir(String ntmscandir) {
		this.ntmscandir = ntmscandir;
	}

	public String getTargetqueue() {
		return targetqueue;
	}

	public void setTargetqueue(String targetqueue) {
		this.targetqueue = targetqueue;
	}

	public String getTargetdir() {
		return targetdir;
	}

	public void setTargetdir(String targetdir) {
		this.targetdir = targetdir;
	}

	public String getPresetguid() {
		return presetguid;
	}

	public void setPresetguid(String presetguid) {
		this.presetguid = presetguid;
	}

	public String getScanext() {
		return scanext;
	}

	public void setScanext(String scanext) {
		this.scanext = scanext;
	}

	public String getScandir() {
		return scandir;
	}

	public void setScandir(String scandir) {
		this.scandir = scandir;
	}

	@Override
	public String toString() {
		return "Channel [cliponly=" + cliponly + ", interval=" + interval + ", ntmscandir=" + ntmscandir
				+ ", targetqueue=" + targetqueue + ", targetdir=" + targetdir + ", presetguid=" + presetguid
				+ ", scanext=" + scanext + ", scandir=" + scandir + "]";
	}

}
