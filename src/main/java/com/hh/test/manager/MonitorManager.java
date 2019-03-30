package com.hh.test.manager;

import java.util.List;

import com.hh.test.pojo.AssetByTime;
import com.hh.test.pojo.bean.ClueSite;
import com.hh.test.pojo.bean.DashBord;
import com.hh.test.pojo.bean.Logon;
import com.hh.test.util.SearchXnews;

public interface MonitorManager {

	/**
	 * 查询xnews 生产数据库数据 插入本地数据库
	 */
	void insertAssetBytime(String type, String site, String beginTime, String endTime);

	/**
	 * 通过从生产数据库中查询数据网145数据库中进行插入
	 * 
	 * @param type
	 * @param site
	 * @param beginTime
	 * @param endTime
	 */
	void insertClueBytime(String type, String site, String beginTime, String endTime);

	/**
	 * 查询数据
	 */
	List<AssetByTime> searchAsset(String type, String beginTime, String endTime);

	/**
	 * 插入登陆在线人数统计
	 * @param type
	 * @param beginTime
	 * @param endTime
	 */
	void insertLogin(String type, String beginTime, String endTime);

	/**
	 * 实时获取线索选题报道数量
	 * @param searchXnews
	 * @return
	 */
	List<AssetByTime> getNowClueCnt(SearchXnews searchXnews);

	
	List<ClueSite> getNowClueSite(SearchXnews searchXnews);

	List<Logon> getLogon(SearchXnews searchXnews);

	/**
	 * 仪表盘数据获取
	 * @param searchXnews
	 * @return
	 */
	DashBord getDashBord(SearchXnews searchXnews);


}
