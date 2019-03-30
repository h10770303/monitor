package com.hh.test.pojo.weixin;

import java.util.Date;

public class Notify {

	private int plateForm;
	private String hostName;
	private String hostIp;
	private int notiType;
	private String serviceName;
	private String status;
	private String notiDetail;
	private String notiChinese;
	private String advice;
	private Date createTime;

	public Notify() {
	}

	public Notify(int plateForm, String hostName, String hostIp, int notiType, String serviceName, Date createTime) {
		this.plateForm = plateForm;
		this.hostName = hostName;
		this.hostIp = hostIp;
		this.notiType = notiType;
		this.serviceName = serviceName;
		this.createTime = createTime;
	}

	public int getPlateForm() {
		return plateForm;
	}

	public void setPlateForm(int plateForm) {
		this.plateForm = plateForm;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getHostIp() {
		return hostIp;
	}

	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}

	public int getNotiType() {
		return notiType;
	}

	public void setNotiType(int notiType) {
		this.notiType = notiType;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNotiDetail() {
		return notiDetail;
	}

	public void setNotiDetail(String notiDetail) {
		this.notiDetail = notiDetail;
	}

	public String getNotiChinese() {
		return notiChinese;
	}

	public void setNotiChinese(String notiChinese) {
		this.notiChinese = notiChinese;
	}

	public String getAdvice() {
		return advice;
	}

	public void setAdvice(String advice) {
		this.advice = advice;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	

}
