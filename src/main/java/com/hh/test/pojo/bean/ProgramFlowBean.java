package com.hh.test.pojo.bean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 页面流程展示bean
 *
 */
public class ProgramFlowBean implements Comparable<ProgramFlowBean> {

	private String id;
	private String programID;
	private String programTitle;
	private String duration;
	private String createBy;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;
	private String createTimes;
	private long createStamp;
	private String diffTime;
	private String ifFinished;
	private String ifHasError;
	private String ifFinisheds;
	private String ifHasErrors;
	private String diffTimes;
	private String errorInfo;
	private int isKankan;
	private String isKankans;
	private int hits;
	private String hitsUrl;
	private String titleId;
	private String msgInfo;
	private int maxNode;//当前节点
	private String precent;

	public String getMsgInfo() {
		return msgInfo;
	}

	public void setMsgInfo(String msgInfo) {
		this.msgInfo = msgInfo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getHitsUrl() {
		return hitsUrl;
	}

	public void setHitsUrl(String hitsUrl) {
		this.hitsUrl = hitsUrl;
	}

	public String getTitleId() {
		return titleId;
	}

	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}

	public int getIsKankan() {
		return isKankan;
	}

	public void setIsKankan(int isKankan) {
		this.isKankan = isKankan;
	}

	public String getIsKankans() {
		if (isKankan == 1) {
			isKankans = "已推送看看";
		} else {
			isKankans = "-";
		}
		return isKankans;
	}

	public void setIsKankans(String isKankans) {
		this.isKankans = isKankans;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getCreateBy() {
		return createBy;
	}

	public String getDiffTimes() {
		if (diffTime != null) {
			diffTimes = Long.parseLong(diffTime) / 1000 + "秒";
		}
		return diffTimes;
	}

	public void setDiffTimes(String diffTimes) {
		this.diffTimes = diffTimes;
	}
	
	public long getCreateStamp() {
		
		return this.createTime.getTime();
	}

	public void setCreateStamp(long createStamp) {
		this.createStamp = createStamp;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getCreateTimes() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		createTimes = sdf.format(this.createTime);
		return createTimes;
	}

	public void setCreateTimes(String createTimes) {
		this.createTimes = createTimes;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getDiffTime() {
		return diffTime;
	}

	public void setDiffTime(String diffTime) {
		this.diffTime = diffTime;
	}

	public String getIfFinisheds() {
		if ("1".equals(ifFinished)) {
			ifFinished = "已完成";
		} else {
			ifFinished = "未完成";
		}
		return ifFinished;
	}

	public void setIfFinished(String ifFinished) {
		this.ifFinished = ifFinished;
	}

	public String getIfHasErrors() {
		if (("未完成").equals(ifFinished)) {
			if("0".equals(ifHasError)){
				ifHasError="未完成";
			}else {
				ifHasError="异常";
			}
		} else {
			if("0".equals(ifHasError)){
				ifHasError = "正常";
			}else{
				if("未能从inews中获取到文稿！".equals(this.errorInfo)){
					ifHasError = "正常";
				}else{
				ifHasError = "异常";
				}
			}

		}
		
		return ifHasError;
	}

	public String getIfFinished() {
		return ifFinished;
	}

	public void setIfFinisheds(String ifFinisheds) {
		this.ifFinisheds = ifFinisheds;
	}

	public String getIfHasError() {
		return ifHasError;
	}

	public void setIfHasErrors(String ifHasErrors) {
		this.ifHasErrors = ifHasErrors;
	}

	public void setIfHasError(String ifHasError) {
		this.ifHasError = ifHasError;
	}

	/**
	 * 安装hits进行排序
	 * 
	 * @param flowBean
	 * @return
	 */
	public int compareTo(ProgramFlowBean flowBean) {
		int i = flowBean.hits - this.hits;
		return i;
	}

	public String getErrorInfo() {
		if (duration!=null) {
		
			Date date=new Date();
			String[]durations=this.duration.split(":");
			int aa=0;
			aa=Integer.parseInt(durations[0])*3600+ Integer.parseInt(durations[1])*60+Integer.parseInt(durations[2]);
			
			if(("未完成").equals(ifHasError)){
				long diff=(date.getTime()-createTime.getTime())/(1000*60);
				if(diff>aa*1.5){
					errorInfo="反推流程未知异常，请联系管理员！";
				}
			}
		
		}
		return errorInfo;
	}

	public void setErrorInfo(String errorInfo) {
		this.errorInfo = errorInfo;
	}
	
	public int getMaxNode() {
		return maxNode;
	}

	public void setMaxNode(int maxNode) {
		this.maxNode = maxNode;
	}

	public String getPrecent() {
		
		switch (this.maxNode) {
		case 1:
			precent="5%";
			break;
		case 2:
			precent="40%";
			break;
		case 3:
			precent="70%";
			break;
		case 4:
			precent="80%";
			break;
		case 5:
			precent="85%";
			break;

		default:
			precent="100%";
			break;
		}
		return precent;
	}

	public void setPrecent(String precent) {
		this.precent = precent;
	}

	@Override
	public String toString() {
		return "ProgramFlowBean [id=" + id + ", programID=" + programID + ", programTitle=" + programTitle
				+ ", duration=" + duration + ", createBy=" + createBy + ", createTime=" + createTime + ", createTimes="
				+ createTimes + ", diffTime=" + diffTime + ", ifFinished=" + ifFinished + ", ifHasError=" + ifHasError
				+ ", ifFinisheds=" + ifFinisheds + ", ifHasErrors=" + ifHasErrors + ", diffTimes=" + diffTimes
				+ ", errorInfo=" + errorInfo + ", isKankan=" + isKankan + ", isKankans=" + isKankans + ", hits=" + hits
				+ ", hitsUrl=" + hitsUrl + ", titleId=" + titleId + ", msgInfo=" + msgInfo + ", maxNode=" + maxNode
				+ "]";
	}


}