package com.hh.test.pojo.bean;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 当pojo与数据字段有不同时 创建bean
 * 
 * @author smg
 *
 */
public class BussinessNodeBean {

	private String id;
	private String nodeID;
	private String programID;
	private int nodeName;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date startTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date endTime;
	private String ifFinished;
	private String ifHasError;
	private String errorInfo;
	private String exeName;
	private String nodeIP;
	private String msgInfo;
	private int isDeal;
	

	public String getMsgInfo() {
		return msgInfo;
	}

	public void setMsgInfo(String msgInfo) {
		this.msgInfo = msgInfo;
	}

	public int getIsDeal() {
		return isDeal;
	}

	public void setIsDeal(int isDeal) {
		this.isDeal = isDeal;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNodeID() {
		return nodeID;
	}

	public void setNodeID(String nodeID) {
		this.nodeID = nodeID;
	}

	public String getProgramID() {
		return programID;
	}

	public void setProgramID(String programID) {
		this.programID = programID;
	}

	public int getNodeName() {
		return nodeName;
	}

	public void setNodeName(int nodeName) {
		this.nodeName = nodeName;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getIfFinished() {
		return ifFinished;
	}

	public void setIfFinished(String ifFinished) {
		this.ifFinished = ifFinished;
	}

	public String getIfHasError() {
		return ifHasError;
	}

	public void setIfHasError(String ifHasError) {
		this.ifHasError = ifHasError;
	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}

	public String getExeName() {
		return exeName;
	}

	public void setExeName(String exeName) {
		this.exeName = exeName;
	}

	public String getNodeIP() {
		return nodeIP;
	}

	public void setNodeIP(String nodeIP) {
		this.nodeIP = nodeIP;
	}

	@Override
	public String toString() {
		return "BussinessNodeBean [id=" + id + ", nodeID=" + nodeID + ", programID=" + programID + ", nodeName="
				+ nodeName + ", startTime=" + startTime + ", endTime=" + endTime + ", ifFinished=" + ifFinished
				+ ", ifHasError=" + ifHasError + ", errorInfo=" + errorInfo + ", exeName=" + exeName + ", nodeIP="
				+ nodeIP + ", msgInfo=" + msgInfo + ", isDeal=" + isDeal + "]";
	}


}