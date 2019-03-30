package com.hh.test.manager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hh.test.dao.MonitorDao;
import com.hh.test.db.CustomerContextHolder;
import com.hh.test.manager.MonitorManager;
import com.hh.test.pojo.AssetByTime;
import com.hh.test.pojo.LoginPojo;
import com.hh.test.pojo.bean.ClueFrom;
import com.hh.test.pojo.bean.ClueSite;
import com.hh.test.pojo.bean.DashBord;
import com.hh.test.pojo.bean.Logon;
import com.hh.test.pojo.bean.TitleTarget;
import com.hh.test.pojo.bean.TopicDesk;
import com.hh.test.pojo.bean.TopicRefcount;
import com.hh.test.util.SearchXnews;
import com.hh.test.util.UUIDRadom;

@Service
public class MonitorManagerImpl implements MonitorManager {

	Logger log = LoggerFactory.getLogger(getClass());

	@Resource
	private MonitorDao monitorDao;

	@Override
	public void insertAssetBytime(String type, String site, String beginTime, String endTime) {

		long count = 0;
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_XNEWS);
		count = monitorDao.searchAssetCt(type, site, beginTime, endTime);
		System.out.println("数量为：" + count);

		AssetByTime assetByTime = new AssetByTime();
		assetByTime.setId(UUIDRadom.getUUID());
		assetByTime.setType(type);
		assetByTime.setName(site);
		assetByTime.setNumber((int) count);
		assetByTime.setCreateTime(new Date());
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		monitorDao.insertAssetByTime(assetByTime);

	}

	public static void main(String[] args) {
		System.out.println(UUIDRadom.getUUID());
	}

	@Override
	public void insertClueBytime(String type, String site, String beginTime, String endTime) {

		List<AssetByTime> assetByTimes = new ArrayList<AssetByTime>();
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_XNEWS);
		if (("clue").equals(type)) {
			if (site.isEmpty()) {
				assetByTimes = monitorDao.searchClueCount(type, beginTime, endTime);
			} else {
				assetByTimes = monitorDao.searchClueWebCount(type, beginTime, endTime);
			}
		} else if (("topic").equals(type)) {
			assetByTimes = monitorDao.searchTopicCount(type, beginTime, endTime);
		} else if (("title").equals(type)) {
			assetByTimes = monitorDao.searchTitleCount(type, beginTime, endTime);
			long kankanCt = monitorDao.searchKankanCount(beginTime, endTime);
			System.out.println("数量为：" + kankanCt);
			AssetByTime assetByTime_kankan = new AssetByTime();
			assetByTime_kankan.setId(UUIDRadom.getUUID());
			assetByTime_kankan.setType(type);
			assetByTime_kankan.setName("送看看");
			assetByTime_kankan.setNumber((int) kankanCt);
			assetByTime_kankan.setCreateTime(new Date());
			CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
			log.info("assetByTime==" + assetByTime_kankan.toString());
			monitorDao.insertAssetByTime(assetByTime_kankan);

		}
		for (AssetByTime assetByTime : assetByTimes) {
			assetByTime.setId(UUIDRadom.getUUID());
			assetByTime.setType(type);
			assetByTime.setCreateTime(new Date());
			log.info("assetByTime==" + assetByTime.toString());
			CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
			monitorDao.insertAssetByTime(assetByTime);
		}
	}

	@Override
	public List<AssetByTime> searchAsset(String type, String beginTime, String endTime) {
		List<AssetByTime> assetByTimes = new ArrayList<AssetByTime>();
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		assetByTimes = monitorDao.searchClue(type, beginTime, endTime);
		return assetByTimes;
	}

	@Override
	public void insertLogin(String type, String beginTime, String endTime) {
		long count = 0;
		List<LoginPojo> loginPojos = new ArrayList<LoginPojo>();
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_XNEWS);
		loginPojos = monitorDao.searchLogin(type, beginTime, endTime);
		System.out.println("数量为：" + loginPojos.size());

		AssetByTime assetByTime = new AssetByTime();
		assetByTime.setId(UUIDRadom.getUUID());
		assetByTime.setType(type);
		assetByTime.setNumber((int) count);
		assetByTime.setCreateTime(new Date());
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		monitorDao.insertAssetByTime(assetByTime);

	}

	@Override
	public List<AssetByTime> getNowClueCnt(SearchXnews searchXnews) {
		List<AssetByTime> assetByTimes = new ArrayList<>();
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_XNEWS);
		assetByTimes = monitorDao.getNowClueCnt(searchXnews);
		return assetByTimes;
	}

	@Override
	public List<ClueSite> getNowClueSite(SearchXnews searchXnews) {
		List<ClueSite> clueSites = new ArrayList<>();
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_XNEWS);
		clueSites = monitorDao.getNowClueSite(searchXnews);
		return clueSites;
	}

	@Override
	public List<Logon> getLogon(SearchXnews searchXnews) {
		List<Logon> logons = new ArrayList<Logon>();
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_XNEWS);
		logons = monitorDao.getLogon(searchXnews);
		return logons;
	}

	@Override
	public DashBord getDashBord(SearchXnews searchXnews) {
		DashBord dashBord = new DashBord();
		List<AssetByTime> assetByTimes = new ArrayList<AssetByTime>();
		List<ClueSite> clueSites = new ArrayList<ClueSite>();
		List<ClueFrom> clueFroms = new ArrayList<ClueFrom>();
		List<Logon> logons = new ArrayList<Logon>();
		List<TopicDesk> topicDesks = new ArrayList<TopicDesk>();
		List<TopicRefcount> topicRefcounts = new ArrayList<TopicRefcount>();
		List<TopicRefcount> topicFroms = new ArrayList<TopicRefcount>();
		List<TopicRefcount> topicRefcnts = new ArrayList<TopicRefcount>();
		List<TitleTarget>titleTargets=new ArrayList<TitleTarget>();
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_XNEWS);
		assetByTimes = monitorDao.getNowClueCnt(searchXnews);
		clueSites = monitorDao.getNowClueSite(searchXnews);
		logons = monitorDao.getLogon(searchXnews);
		clueFroms = monitorDao.getClueFroms(searchXnews);
		topicDesks = monitorDao.getTopicDesk(searchXnews);
		topicRefcounts = monitorDao.getTopicRefcount(searchXnews);
		topicFroms = monitorDao.getTopicFroms(searchXnews);
		topicRefcnts = dealTopicRefcounts(topicFroms, topicRefcounts);
		titleTargets=monitorDao.getTitleTargets(searchXnews);
		dashBord.setAssetByTimes(assetByTimes);
		dashBord.setClueFroms(clueFroms);
		dashBord.setClueSites(clueSites);
		dashBord.setLogons(logons);
		dashBord.setTopicDesks(topicDesks);
		dashBord.setTopicRefcounts(topicRefcnts);
		dashBord.setTitleTargets(titleTargets);
		return dashBord;
	}

	/**
	 * 将两个结果集进行和并
	 * 
	 * @param topicFroms
	 * @param topicRefcounts
	 * @return
	 */
	private List<TopicRefcount> dealTopicRefcounts(List<TopicRefcount> topicFroms, List<TopicRefcount> topicRefcounts) {
		for (TopicRefcount topicFrom : topicFroms) {
			for (TopicRefcount topicRefcount : topicRefcounts) {
				topicFrom.setRefcnt(topicRefcount.getRefcnt());
			}
		}
		return topicFroms;
	}

}
