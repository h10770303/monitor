package com.hh.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hh.test.pojo.AssetByTime;
import com.hh.test.pojo.LoginPojo;
import com.hh.test.pojo.bean.ClueFrom;
import com.hh.test.pojo.bean.ClueSite;
import com.hh.test.pojo.bean.Logon;
import com.hh.test.pojo.bean.TitleTarget;
import com.hh.test.pojo.bean.TopicDesk;
import com.hh.test.pojo.bean.TopicRefcount;
import com.hh.test.pojo.rundown.CheckInterplay;
import com.hh.test.util.SearchXnews;

public interface MonitorDao {

	/**
	 * 查询相应资产的数量
	 * 
	 * @param type
	 *            type:clue topic title
	 * @param site
	 *            信源等参数
	 * @param beginTime
	 * @param endTime
	 * @return
	 */

	long searchAssetCt(@Param("type") String type, @Param("site") String site, @Param("beginTime") String beginTime,
			@Param("endTime") String endTime);

	void insertAssetByTime(AssetByTime assetByTime);

	/**
	 * 查询线索资产
	 * 
	 * @param type
	 *            查询资产的类型
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	List<AssetByTime> searchClueCount(@Param("type") String type, @Param("beginTime") String beginTime,
			@Param("endTime") String endTime);

	/**
	 * 查询线索资产
	 * 
	 * @param type
	 *            查询资产的类型
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	List<AssetByTime> searchClueWebCount(@Param("type") String type, @Param("beginTime") String beginTime,
			@Param("endTime") String endTime);

	/**
	 * 查询选题资产
	 * 
	 * @param type
	 *            查询资产的类型
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	List<AssetByTime> searchTopicCount(@Param("type") String type, @Param("beginTime") String beginTime,
			@Param("endTime") String endTime);

	/**
	 * 查询报道资产
	 * 
	 * @param type
	 *            查询资产的类型
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	List<AssetByTime> searchTitleCount(@Param("type") String type, @Param("beginTime") String beginTime,
			@Param("endTime") String endTime);

	/**
	 * 送看看数量
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	long searchKankanCount(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
	
	/**
	 * 查询数据
	 */
	List<AssetByTime>searchClue(@Param("type") String type, @Param("beginTime") String beginTime,
			@Param("endTime") String endTime);
	/**
	 * 查询选题数量
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	List<AssetByTime>searchTopic(@Param("beginTime") String beginTime,
			@Param("endTime") String endTime);
	/**
	 * 查询报道数量
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	List<AssetByTime>searchTitle(@Param("beginTime") String beginTime,
			@Param("endTime") String endTime);
	

	/**
	 * 查询当前xnews在线人数
	 * @param type
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	List<LoginPojo> searchLogin(@Param("type") String type, @Param("beginTime") String beginTime,
			@Param("endTime") String endTime);

	/**
	 * 实时获取线索选题报道数量
	 * @param searchXnews
	 * @return
	 */
	List<AssetByTime> getNowClueCnt(SearchXnews searchXnews);
	
	List<ClueSite> getNowClueSite(SearchXnews searchXnews);

	List<Logon> getLogon(SearchXnews searchXnews);

	List<ClueFrom> getClueFroms(SearchXnews searchXnews);

	List<TopicDesk> getTopicDesk(SearchXnews searchXnews);

	List<TopicRefcount> getTopicRefcount(SearchXnews searchXnews);

	List<TopicRefcount> getTopicFroms(SearchXnews searchXnews);

	List<TitleTarget> getTitleTargets(SearchXnews searchXnews);

	int getCptn(@Param("site")String site, @Param("beginTime")String beginTime, @Param("endTime")String endTime);

	int checkRundown(@Param("string") String string, @Param("beginTime") String beginTime, @Param("endTime")String endTime);

	void insertCheckInterplay(CheckInterplay check);

	List<CheckInterplay> getCheckInterplay( @Param("beginTime") String beginTime, @Param("endTime")String endTime);
	
	

}
