package com.hh.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hh.test.pojo.XnewsData;

public interface XnewsSyDao {
	
	List<XnewsData> getAssetFromXnewsByTime(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
	void insertXnewsData(XnewsData xnewsData);

}
