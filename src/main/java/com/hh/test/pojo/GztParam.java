package com.hh.test.pojo;

public class GztParam {
	private String initFileSize;

	private String filePath;

	private String filterName;

	private String outputLog;
	private int initFlag = 0;
	private long lastFileSize;
	
	
	
	public GztParam() {
	}
	
	
	public GztParam(String initFileSize, String filePath, String filterName, int initFlag, long lastFileSize) {
		this.initFileSize = initFileSize;
		this.filePath = filePath;
		this.filterName = filterName;
		this.initFlag = initFlag;
		this.lastFileSize = lastFileSize;
	}


	public String getInitFileSize() {
		return initFileSize;
	}
	public void setInitFileSize(String initFileSize) {
		this.initFileSize = initFileSize;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFilterName() {
		return filterName;
	}
	public void setFilterName(String filterName) {
		this.filterName = filterName;
	}
	public String getOutputLog() {
		return outputLog;
	}
	public void setOutputLog(String outputLog) {
		this.outputLog = outputLog;
	}
	public int getInitFlag() {
		return initFlag;
	}
	public void setInitFlag(int initFlag) {
		this.initFlag = initFlag;
	}
	public long getLastFileSize() {
		return lastFileSize;
	}
	public void setLastFileSize(long lastFileSize) {
		this.lastFileSize = lastFileSize;
	}
	@Override
	public String toString() {
		return "GztParam [initFileSize=" + initFileSize + ", filePath=" + filePath + ", filterName=" + filterName
				+ ", outputLog=" + outputLog + ", initFlag=" + initFlag + ", lastFileSize=" + lastFileSize + "]";
	}
	
	
}
