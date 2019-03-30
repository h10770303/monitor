package com.hh.test.pojo.bean;

import java.util.List;

import com.hh.test.pojo.AssetByTime;

/**
 * 首页数据组合
 * 
 * @author smg
 *
 */
public class DashBord {

	private List<AssetByTime> assetByTimes;
	private List<ClueSite> clueSites;
	private List<Logon> logons;
	private List<ClueFrom> clueFroms;
	private List<TopicDesk> topicDesks;
	private List<TopicRefcount> topicRefcounts;
	private List<TitleTarget> titleTargets;
	

	public List<Logon> getLogons() {
		return logons;
	}

	public void setLogons(List<Logon> logons) {
		this.logons = logons;
	}

	public List<AssetByTime> getAssetByTimes() {
		return assetByTimes;
	}

	public void setAssetByTimes(List<AssetByTime> assetByTimes) {
		this.assetByTimes = assetByTimes;
	}

	public List<ClueSite> getClueSites() {
		return clueSites;
	}

	public void setClueSites(List<ClueSite> clueSites) {
		this.clueSites = clueSites;
	}

	public List<ClueFrom> getClueFroms() {
		return clueFroms;
	}

	public void setClueFroms(List<ClueFrom> clueFroms) {
		this.clueFroms = clueFroms;
	}

	public List<TopicDesk> getTopicDesks() {
		return topicDesks;
	}

	public void setTopicDesks(List<TopicDesk> topicDesks) {
		this.topicDesks = topicDesks;
	}

	public List<TopicRefcount> getTopicRefcounts() {
		return topicRefcounts;
	}

	public void setTopicRefcounts(List<TopicRefcount> topicRefcounts) {
		this.topicRefcounts = topicRefcounts;
	}
	

	public List<TitleTarget> getTitleTargets() {
		return titleTargets;
	}

	public void setTitleTargets(List<TitleTarget> titleTargets) {
		this.titleTargets = titleTargets;
	}

	@Override
	public String toString() {
		return "DashBord [assetByTimes=" + assetByTimes + ", clueSites=" + clueSites + ", logons=" + logons
				+ ", clueFroms=" + clueFroms + ", topicDesks=" + topicDesks + ", topicRefcounts=" + topicRefcounts
				+ ", titleTargets=" + titleTargets + "]";
	}

}
