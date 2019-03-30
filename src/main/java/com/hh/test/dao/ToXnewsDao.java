package com.hh.test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hh.test.pojo.AssetRelationships;
import com.hh.test.pojo.BussinessNode;
import com.hh.test.pojo.ProcessinstanceMod;
import com.hh.test.pojo.ProgramNode;
import com.hh.test.pojo.XnewsData;
import com.hh.test.pojo.bean.BussinessNodeBean;
import com.hh.test.pojo.bean.ProgramFlowBean;
import com.hh.test.pojo.bean.ToXnewsCnt;
import com.hh.test.util.SearchType;

public interface ToXnewsDao {

	void insertProgramNode(ProgramNode programNode);

	// 有问题，不能@param 与bean共存
	// void insertBussinessNode(@Param("programID") String
	// programID,BussinessNode bussinessNode);
	void insertBussinessNodeBean(BussinessNodeBean bussinessNodeBean);

	List<ProgramNode> getProgramNodeById(@Param("programID") String programID);
	
	ProgramFlowBean getProgramFlowBeanById(@Param("programID") String programID);

	List<BussinessNode> getBussinessNodeByProgramID(@Param("programID") String programID);
	BussinessNode getBussinessNodeByID(@Param("programID") String programID,@Param("nodeId") String nodeId);
	void delteBussinessNode(@Param("programID") String programID,@Param("nodeId") String nodeId);
	
	void updateProgramNode(ProgramFlowBean programFlowBean );

	List<ProgramNode> getProgramNodeByTime(@Param("beginTime") String beginTime, @Param("endTime") String endTime);
	List<ProgramFlowBean> getProgramFlowBeanByTime(@Param("beginTime") String beginTime, @Param("endTime") String endTime,@Param("pageNo")Integer pageNo,@Param("pageSize")Integer pageSize);
	int getProgramFlowBeanBySearchTypeCnt(SearchType searchType);
	List<ProgramFlowBean> getProgramFlowBeanBySearchType(SearchType searchType);
	List<ProgramFlowBean> getProgramFlowBeanByIsKankan(@Param("beginTime") String beginTime, @Param("endTime") String endTime);

	List<BussinessNodeBean> getBussinessNodeByTime(@Param("beginTime") String beginTime, @Param("endTime") String endTime);

	List<ProcessinstanceMod> getProcessinstanceModByName(@Param("processName")String processName,@Param("endTime")String endTime);
	List<ProcessinstanceMod> getProcessinstanceModByMoid(@Param("moId")String moId);

	
	List<ToXnewsCnt> getProgramnodeCnt(@Param("startDt") String startDt, @Param("endDt") String endDt);

	List<XnewsData> getXnewsDataByMoid(@Param("msgInfo") String msgInfo);

	/**
	 * 根据moid 反查 相关xnews 资源
	 * @param moid
	 * @return
	 */
	List<AssetRelationships> getRelationships(@Param("moid") String moid);

	
	List<BussinessNodeBean> getBussinessNode(@Param("beginTime") String beginTime, @Param("endTime") String endTime,
			@Param("nodeName") String nodeName,@Param("msgInfo") String msgInfo, @Param("isDeal") int isDeal);

	/**
	 * 更新businessNOde
	 * @param bean
	 */
	void updateBussiness(BussinessNodeBean bean);

}
