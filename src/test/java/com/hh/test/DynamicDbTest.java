package com.hh.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hh.test.dao.ToXnewsDao;
import com.hh.test.db.CustomerContextHolder;
import com.hh.test.manager.MonitorManager;
import com.hh.test.manager.SchedulerManager;
import com.hh.test.pojo.AssetByTime;
import com.hh.test.pojo.BussinessNode;
import com.hh.test.util.SearchXnews;

public class DynamicDbTest extends BaseTest {
	
	@Resource
	private ToXnewsDao toXnewsDao;
	@Resource
	private MonitorManager monitorManager;
	@Resource
	private SchedulerManager schedulerManager;
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	
	@Test
	public void test(){
		
		String aa="1221";
		System.out.println(aa);
	}
	
	/**
	 * 测试数据源1
	 */
	@Test
	public void datasource1(){
		
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		 List<BussinessNode>BussinessNode= toXnewsDao.getBussinessNodeByProgramID("P20170809062724194");
		
		System.out.println("BussinessNode==+"+BussinessNode.size());
	}
	
	/**
	 * 测试数据源2
	 */
	@Test
	public void datasource2(){
		
		List<AssetByTime>assetByTimes=new ArrayList<>();
		SearchXnews searchXnews=new SearchXnews();
		searchXnews.setStartDt("2017-08-21");
		searchXnews.setEndDt("2017-08-22");
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_XNEWS);
		assetByTimes=monitorManager.getNowClueCnt(searchXnews);
		log.info("assetByTimes==",assetByTimes);
		
	}
	
	
	@Test
	public void checkCPTN(){
		Date date = new Date();
		schedulerManager.checkCptn(date);
	}

}
