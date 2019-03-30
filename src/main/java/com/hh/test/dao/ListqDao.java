package com.hh.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hh.test.pojo.rundown.InewsMonOn;
import com.hh.test.pojo.rundown.NcStatus;
import com.hh.test.pojo.rundown.TestRunAlert;

public interface ListqDao {

	
	List<InewsMonOn> getInewsMonOn(InewsMonOn inewsMonOn);
	
	List<InewsMonOn> getInewsMonOnByTime(@Param("beginTime")String beginTime, @Param("endTime")String endTime);

	List<NcStatus> getNCstatus(@Param("beginTime")String beginTime, @Param("endTime")String endTime);

	List<TestRunAlert> getTestRunAlert(@Param("beginTime")String beginTime, @Param("endTime")String endTime);

}
