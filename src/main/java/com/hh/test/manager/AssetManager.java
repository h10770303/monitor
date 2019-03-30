package com.hh.test.manager;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hh.test.pojo.AssetXnews;

public interface AssetManager {

	List<AssetXnews> getAssetXnews();

	void insertAssetXnews(AssetXnews assetXnews);

	void deleteAssetXnews(@Param("assetName") String assetName);

	AssetXnews findAssetXnews(@Param("assetName") String assetName);

}
