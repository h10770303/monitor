package com.hh.test.manager;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import com.hh.test.pojo.GztParam;
import com.hh.test.pojo.rundown.CheckInterplay;

public interface SchedulerManager {

	/**
	 * 查询送看看数据并插入临时表
	 */
	void insertKankan(String string, String site, String beginTime, String endTime);
	
	/**
	 * 查询资产数据并插入临时表
	 */
	void insertTile(String string, String site, String beginTime, String endTime);

	void checkCptn(Date date);

	void checkRundown(Date date);

	
	void checkS9A10Del(String path)throws ParseException;

	GztParam checkGzt(GztParam gztParam)throws ParseException, IOException ;

	void checkInterplay(CheckInterplay check)throws ParseException;

	void getTestRun();


}
