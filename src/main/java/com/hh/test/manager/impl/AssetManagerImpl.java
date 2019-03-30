package com.hh.test.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hh.test.dao.AssetDao;
import com.hh.test.db.CustomerContextHolder;
import com.hh.test.manager.AssetManager;
import com.hh.test.pojo.AssetXnews;

@Service
public class AssetManagerImpl implements AssetManager {

	Logger log = LoggerFactory.getLogger(getClass());

	@Resource
	private AssetDao assetDao;

	@Override
	public List<AssetXnews> getAssetXnews() {
		List<AssetXnews> assetXnews = new ArrayList<AssetXnews>();
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		assetXnews = assetDao.getAssetXnews();
		log.info("assetXnewss==" + assetXnews);
		return assetXnews;
	}

	@Override
	public void insertAssetXnews(AssetXnews assetXnews) {
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		assetDao.insertAssetXnews(assetXnews);

	}

	@Override
	public void deleteAssetXnews(String assetName) {
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		assetDao.deleteAssetXnews(assetName);
	}

	@Override
	public AssetXnews findAssetXnews(String assetName) {
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		return assetDao.findAssetXnews(assetName);
	}

}
