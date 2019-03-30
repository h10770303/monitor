package com.hh.test.manager;


import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.hh.test.pojo.BussinessNode;
import com.hh.test.pojo.MonitorConf;
import com.hh.test.pojo.ProgramNode;
import com.hh.test.pojo.bean.BussinessNodeBean;
import com.hh.test.pojo.bean.ProgramFlowBean;
import com.hh.test.pojo.bean.ToXnewsCnt;
import com.hh.test.util.SearchType;
@Service
public interface ToXnewsManager {

	
	/**
	 * 将解析的xml的数据进行处理入库
	 * @param monitorConf
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws Exception 
	 */
	void insertMonitorConf(MonitorConf monitorConf) throws RuntimeException;
	
	
	List<ProgramNode> getProgramNodeByTime(String beginTime, String endTime);
	List<BussinessNodeBean> getBussinessNodeBeans(String beginTime, String endTime);

	List<BussinessNode> getBussinessNodeByProgramID(String programID);

	/**
	 * avid反推数字页面查看
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	List<ProgramFlowBean> getProgramFlowBeanByTime(String beginTime, String endTime);
	List<ProgramFlowBean> getProgramFlowBeanByTime(String beginTime, String endTime,Integer pageNo,Integer pageSize);
	int getProgramFlowBeanBySearchTypeCnt(SearchType searchType);
	List<ProgramFlowBean> getProgramFlowBeanBySearchType(SearchType searchType);
	/**
	 * 获取评论数 前10 
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	List<ProgramFlowBean> getTopHits(String beginTime, String endTime);
	/**
	 * 当天内没有送看看的数据进行实时查询
	 */
	void checkKankan(String beginTime, String endTime);


	List<ToXnewsCnt> getProgramnodeCnt(String startDt, String endDt);


	/**
	 * avid 反推 生产线索情况
	 */
	void checkClue(String beginTime, String endTime,int nodeName,int isDeal);


	/**
	 * 扫描是否推送看看
	 */
	void checkKankan(String beginTime, String endTime, int nodeName, int isDeal);


}
