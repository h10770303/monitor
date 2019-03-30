package com.hh.test.scheduler;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hh.test.db.CustomerContextHolder;
import com.hh.test.manager.XnewsSynManager;
/**
 * xnews 数据同步到监控数据库
 * @author smg
 *
 */
@Service("xnewsSynScheduler")
public class XnewsSynScheduler {

	Logger log = LoggerFactory.getLogger(getClass());
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Resource
	private XnewsSynManager  xnSynManager;
	
	
	public void insertXnewsData(){
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		String beginTime = sdf.format(date);
		String endTime = sdf.format(cal.getTime());
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		xnSynManager.insertXnewsData(beginTime, endTime);
		
	}

	
	

}
