package com.hh.test.pojo;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import com.fasterxml.jackson.annotation.JsonFormat;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProgramNode", propOrder = { "programID", "programTitle", "bussinessID", "businessName", "createBy",
		"modifyBy", "createTime", "modifyTime","duration" })
public class ProgramNode {

	@XmlAttribute(name = "id")
	private String id;
	@XmlElement(name = "programID")
	private String programID;
	@XmlElement(name = "programTitle")
	private String programTitle;
	@XmlElement(name = "bussinessID")
	private String bussinessID;
	@XmlElement(name = "businessName")
	private String businessName;
	@XmlElement(name = "createBy")
	private String createBy;
	@XmlElement(name = "modifyBy")
	private String modifyBy;
	@XmlElement(name = "createTime")
	private String createTime;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@XmlAttribute(name="createTimed")
	private Date createTimed;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@XmlElement(name = "modifyTime")
	private String modifyTime;
	@XmlAttribute(name = "modifyTimed")
	private Date modifyTimed;
	@XmlElement(name = "duration")
	private String duration;
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
	public String getProgramTitle() {
		return programTitle;
	}
	public void setProgramTitle(String programTitle) {
		this.programTitle = programTitle;
	}
	public String getBussinessID() {
		return bussinessID;
	}
	public void setBussinessID(String bussinessID) {
		this.bussinessID = bussinessID;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public String getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	
	
	public Date getCreateTimed() {
		return createTimed;
	}
	public void setCreateTimed(Date createTimed) {
		this.createTimed = createTimed;
	}
	public Date getModifyTimed() {
		return modifyTimed;
	}
	public void setModifyTimed(Date modifyTimed) {
		this.modifyTimed = modifyTimed;
	}
	@Override
	public String toString() {
		return "ProgramNode [id=" + id + ", programID=" + programID + ", programTitle=" + programTitle
				+ ", bussinessID=" + bussinessID + ", businessName=" + businessName + ", createBy=" + createBy
				+ ", modifyBy=" + modifyBy + ", createTime=" + createTime + ", createTimed=" + createTimed
				+ ", modifyTime=" + modifyTime + ", modifyTimed=" + modifyTimed + ", duration=" + duration + "]";
	}
	
}