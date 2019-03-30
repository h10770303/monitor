package com.hh.test.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hh.test.dao.MapDao;
import com.hh.test.db.CustomerContextHolder;
import com.hh.test.manager.MapManager;
import com.hh.test.pojo.DeviceLbs;

@Service
public class MapManagerImpl implements MapManager {

	
	Logger log = LoggerFactory.getLogger(getClass());

	@Resource
	private MapDao mapDao;

	@Override
	public List<String> getDeviceLbsByDeviceId(String deviceId) {
		List<String> lbss=new ArrayList<String>();
		List<DeviceLbs> deviceLbs=new ArrayList<DeviceLbs>();
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_XNEWS);
		deviceLbs=mapDao.getDeviceLbsByDeviceId(deviceId);
		log.info(deviceLbs.toString());
		
		for (DeviceLbs deviceLbs2 : deviceLbs) {
			lbss.add(deviceLbs2.getLbs());
		}

		return lbss;
	}

}
