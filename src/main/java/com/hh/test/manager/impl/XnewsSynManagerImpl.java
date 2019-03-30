package com.hh.test.manager.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hh.test.dao.XnewsSyDao;
import com.hh.test.manager.XnewsSynManager;
import com.hh.test.pojo.XnewsData;

@Service
public class XnewsSynManagerImpl implements XnewsSynManager {

	Logger log = LoggerFactory.getLogger(getClass());
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Resource
	private XnewsSyDao xnewsSyDao;

	@Override
	@Transactional
	public void insertXnewsData(String beginTime,String endTime) throws RuntimeException {

		List<XnewsData> xnewsDatas=new ArrayList<XnewsData>();
		xnewsDatas=xnewsSyDao.getAssetFromXnewsByTime(beginTime, endTime);
		
		for (XnewsData xnewsData : xnewsDatas) {
			xnewsSyDao.insertXnewsData(xnewsData);
		}

	}

	
}
