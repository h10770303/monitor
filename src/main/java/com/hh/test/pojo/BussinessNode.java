package com.hh.test.pojo;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonFormat;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BussinessNode", propOrder = { "nodeID", "nodeName", "startTime", "endTime", "ifFinished", "ifHasError",
		"errorInfo", "exeName", "nodeIP","msgInfo" })
public class BussinessNode {

	@XmlAttribute(name = "id")
	private String id;
	@XmlAttribute(name = "programID")
	private String programID;
	@XmlElement(name = "nodeID")
	private String nodeID;
	@XmlElement(name = "nodeName")
	private int nodeName;
	@XmlAttribute(name = "nodeNames")
	private String nodeNames;
	@XmlElement(name = "startTime")
	private String startTime;
	@XmlElement(name = "endTime")
	private String endTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@XmlAttribute(name = "startTimed")
	private Date startTimed;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@XmlAttribute(name = "endTimed")
	private Date endTimed;
	@XmlElement(name = "ifFinished")
	private String ifFinished;
	@XmlElement(name = "ifHasError")
	private String ifHasError;
	@XmlElement(name = "errorInfo")
	private String errorInfo;
	@XmlElement(name = "exeName")
	private String exeName;
	@XmlElement(name = "nodeIP")
	private String nodeIP;
	@XmlElement(name = "msgInfo")
	private String msgInfo;
	@XmlAttribute(name="diffTime")
	private String diffTime;
	
	
	public String getDiffTime() {
		long startDt=0,endDt = 0;
		if(this.startTimed!=null){
			startDt=this.startTimed.getTime();
		}else{
			diffTime="未完成";
		}
		if(this.getEndTimed()!=null){
			endDt=this.endTimed.getTime();
		}else{
			diffTime="未完成";
		}
		diffTime=(endDt-startDt)/1000+"秒";
		return diffTime;
	}

	public void setDiffTime(String diffTime) {
		this.diffTime = diffTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProgramID() {
		return programID;
	}

	public void setProgramID(String programID) {
		this.programID = programID;
	}

	public String getNodeID() {
		return nodeID;
	}

	public void setNodeID(String nodeID) {
		this.nodeID = nodeID;
	}

	public int getNodeName() {
		return nodeName;
	}

	public void setNodeName(int nodeName) {
		this.nodeName = nodeName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
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
//		if (errorInfo=="") {
//			errorInfo="";
//		}else{
//			this.startTime=null;
//		}
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

	public Date getStartTimed() {
		return startTimed;
	}

	public void setStartTimed(Date startTimed) {
		this.startTimed = startTimed;
	}

	public Date getEndTimed() {
		return endTimed;
	}

	public void setEndTimed(Date endTimed) {
		this.endTimed = endTimed;
	}

	public String getNodeNames() {
		switch (this.nodeName) {
		case 1:
			nodeNames = "创建任务";
			break;
		case 2:
			nodeNames = "STP打包";
			break;
		case 3:
			nodeNames = "虹软转码";
			break;
		case 4:
			nodeNames = "文稿获取";
			break;
		case 5:
			nodeNames = "合并导出";
			break;
		case 6:
			nodeNames = "xnews登记";
			break;
		case 7:
			nodeNames = "xnews线索";
			break;
		case 8:
			nodeNames = "xnews选题";
			break;
		case 9:
			nodeNames = "xnews报道";
			break;
		}
		return nodeNames;
	}

	public void setNodeNames(String nodeNames) {
		this.nodeNames = nodeNames;
	}
	

	/**
	 * xnews 线索id
	 * @return
	 */
	public String getMsgInfo() {
		return msgInfo;
	}

	/**
	 * xnews 线索id
	 * @param msgInfo
	 */
	public void setMsgInfo(String msgInfo) {
		this.msgInfo = msgInfo;
	}

	@Override
	public String toString() {
		return "BussinessNode [id=" + id + ", programID=" + programID + ", nodeID=" + nodeID + ", nodeName=" + nodeName
				+ ", nodeNames=" + nodeNames + ", startTime=" + startTime + ", endTime=" + endTime + ", startTimed="
				+ startTimed + ", endTimed=" + endTimed + ", ifFinished=" + ifFinished + ", ifHasError=" + ifHasError
				+ ", errorInfo=" + errorInfo + ", exeName=" + exeName + ", nodeIP=" + nodeIP + ", msgInfo=" + msgInfo
				+ ", diffTime=" + diffTime + "]";
	}

	
	
}