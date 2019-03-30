package com.hh.test.manager.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hh.test.dao.ToXnewsDao;
import com.hh.test.db.CustomerContextHolder;
import com.hh.test.manager.ToXnewsManager;
import com.hh.test.pojo.AssetRelationships;
import com.hh.test.pojo.BussinessNode;
import com.hh.test.pojo.KankanInfo;
import com.hh.test.pojo.MonitorConf;
import com.hh.test.pojo.ProcessinstanceMod;
import com.hh.test.pojo.ProgramNode;
import com.hh.test.pojo.XnewsData;
import com.hh.test.pojo.bean.BussinessNodeBean;
import com.hh.test.pojo.bean.ProgramFlowBean;
import com.hh.test.pojo.bean.ToXnewsCnt;
import com.hh.test.util.JsonResult;
import com.hh.test.util.JsonResult;
import com.hh.test.util.MultiThreadedHttpClient;
import com.hh.test.util.SearchType;
import com.hh.test.util.UUIDRadom;

@Service
public class ToXnewsManagerImpl implements ToXnewsManager {

	Logger log = LoggerFactory.getLogger(getClass());
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Resource
	private ToXnewsDao toXnewsDao;

	@Override
	@Transactional
	public void insertMonitorConf(MonitorConf monitorConf) throws RuntimeException {

		ProgramNode programNode = monitorConf.getProgramNodes().get(0);
		BussinessNode bussinessNode = monitorConf.getBussinessNodes().getBussinessNode().get(0);
		List<ProgramNode> programNode_sql = new ArrayList<ProgramNode>();
		BussinessNodeBean bussinessNodeBean = new BussinessNodeBean();

		programNode_sql = insertProgramNode(programNode, bussinessNode);
		bussinessNodeBean = dealWithBussinessNode(programNode, bussinessNode);
		updateProgramByBusiness(programNode, bussinessNode, programNode_sql, bussinessNodeBean);

	}

	private void updateProgramByBusiness(ProgramNode programNode, BussinessNode bussinessNode,
			List<ProgramNode> programNode_sql, BussinessNodeBean bussinessNodeBean) {
		// 根据情况更新ProgramNode节点
		if (("1").equals(bussinessNode.getIfHasError())) {
			ProgramFlowBean programFlowBean = new ProgramFlowBean();
			programFlowBean.setProgramID(programNode.getProgramID());
			programFlowBean.setIfHasError("1");
			programFlowBean.setErrorInfo(bussinessNodeBean.getErrorInfo());
			CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
			toXnewsDao.updateProgramNode(programFlowBean);
			log.info("programFlowBean更新异常字段成功{}", programFlowBean);
		}

		if (bussinessNode.getNodeName() == 6 && ("1").equals(bussinessNode.getIfFinished())) {
			ProgramFlowBean programFlowBean = new ProgramFlowBean();
			programFlowBean.setProgramID(programNode.getProgramID());
			programFlowBean.setIfFinished(bussinessNode.getIfFinished());
			String startTime = programNode_sql.size() == 0 ? bussinessNode.getStartTime()
					: programNode_sql.get(0).getCreateTimed().getTime() + "";
//			log.info("获取耗时, programNode_sql.size:{},startTime:{},{}",programNode_sql.size(),startTime,bussinessNode);
			programFlowBean.setDiffTime(diffTime(startTime, bussinessNode.getEndTime()));
			CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
			toXnewsDao.updateProgramNode(programFlowBean);
//			log.info("programFlowBean更新耗时成功：{}", programFlowBean);
		}
	}

	/**
	 * 对bussinessNode表进行新增和更新
	 * 
	 * @param programNode
	 * @param bussinessNode
	 */
	private BussinessNodeBean dealWithBussinessNode(ProgramNode programNode, BussinessNode bussinessNode) {

		BussinessNode bussinessNode_sql = new BussinessNode();
		bussinessNode_sql = toXnewsDao.getBussinessNodeByID(programNode.getProgramID(), bussinessNode.getNodeID());
		if (bussinessNode_sql != null) {
			CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
			toXnewsDao.delteBussinessNode(programNode.getProgramID(), bussinessNode.getNodeID());
		}
		BussinessNodeBean bussinessNodeBean = new BussinessNodeBean();
		bussinessNodeBean.setId(UUIDRadom.getUUID());
		bussinessNodeBean.setProgramID(programNode.getProgramID());
		bussinessNodeBean.setNodeID(bussinessNode.getNodeID());
		bussinessNodeBean.setNodeName(bussinessNode.getNodeName());
		bussinessNodeBean.setStartTime(new Date(Long.parseLong(bussinessNode.getStartTime())));
		bussinessNodeBean.setEndTime(new Date(Long.parseLong(bussinessNode.getEndTime())));
		bussinessNodeBean.setIfFinished(bussinessNode.getIfFinished());
		bussinessNodeBean.setIfHasError(bussinessNode.getIfHasError());
		bussinessNodeBean.setErrorInfo(bussinessNode.getErrorInfo());
		bussinessNodeBean.setExeName(bussinessNode.getExeName());
		bussinessNodeBean.setNodeIP(bussinessNode.getNodeIP());
		bussinessNodeBean.setMsgInfo(bussinessNode.getMsgInfo());
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		toXnewsDao.insertBussinessNodeBean(bussinessNodeBean);
		return bussinessNodeBean;
	}

	/**
	 * ProgramNode 入库
	 */
	private List<ProgramNode> insertProgramNode(ProgramNode programNode, BussinessNode bussinessNode) {
		List<ProgramNode> programNode_sql = new ArrayList<ProgramNode>();
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		programNode_sql = toXnewsDao.getProgramNodeById(programNode.getProgramID());
//		log.info("ProgramID:{},programNode_sql=", programNode.getProgramID(), programNode_sql);
		if (programNode_sql.size() == 0) {
			programNode.setId(UUIDRadom.getUUID());
			programNode.setCreateTimed(new Date(Long.parseLong(programNode.getCreateTime())));
			programNode.setModifyTimed(new Date(Long.parseLong(programNode.getModifyTime())));
			CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
			toXnewsDao.insertProgramNode(programNode);
		} else {
			// if(bussinessNode.getNodeName()==1){
			// programNode_sql.get(0).setCreateTimed(new
			// Date(Long.parseLong(programNode.getCreateTime())));
			// CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
			// toXnewsDao.updateProgramNode(programFlowBean);
			// }
		}
		return programNode_sql;
	}

	/**
	 * 求两个时间段是差
	 * 由于webtm1上时间与 10.27.137.24上时间相差40s因此，再次减去40s时间
	 * 
	 * @param createTime
	 * @param endTime
	 * @return
	 */
	private String diffTime(String createTime, String endTime) {
		long createT = new Date(Long.parseLong(createTime)).getTime();
		long endT = new Date(Long.parseLong(endTime)).getTime();
		long diff = endT - createT;
//		log.info("耗时：endt{},creatD{},dff:{}", endTime, createTime, diff);
		return (diff-40) + "";
	}

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ToXnewsManagerImpl toImpl = new ToXnewsManagerImpl();
		String createTime = "2018-05-03 11:14:51";
		String endTime = "2018-05-03 11:19:28";
		System.out.println(sdf.parse(endTime));
		String diff=toImpl.diffTime("1525327334146", "1525327074607");
	
		System.out.println(diff);
	}

	@Override
	@Transactional
	public List<ProgramNode> getProgramNodeByTime(String beginTime, String endTime) {
		List<ProgramNode> programNodes = new ArrayList<ProgramNode>();
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		programNodes = toXnewsDao.getProgramNodeByTime(beginTime, endTime);
		return programNodes;
	}

	@Override
	@Transactional
	public List<BussinessNodeBean> getBussinessNodeBeans(String beginTime, String endTime) {
		List<BussinessNodeBean> bussinessNodeBeans = new ArrayList<BussinessNodeBean>();
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		bussinessNodeBeans = toXnewsDao.getBussinessNodeByTime(beginTime, endTime);
		return bussinessNodeBeans;
	}

	@Override
	@Transactional
	public List<BussinessNode> getBussinessNodeByProgramID(String programID) {
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		List<BussinessNode> bussinessNodes = new ArrayList<BussinessNode>();
		bussinessNodes=toXnewsDao.getBussinessNodeByProgramID(programID);
		return bussinessNodes;
	}

	@Override
	@Transactional
	public List<ProgramFlowBean> getProgramFlowBeanByTime(String beginTime, String endTime) {
		List<ProgramFlowBean> programFlowBeans = new ArrayList<ProgramFlowBean>();
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		programFlowBeans = toXnewsDao.getProgramFlowBeanByTime(beginTime, endTime, null, null);
		return programFlowBeans;
	}

	@Override
	@Transactional
	public List<ProgramFlowBean> getProgramFlowBeanByTime(String beginTime, String endTime, Integer pageNo,
			Integer pageSize) {
		List<ProgramFlowBean> programFlowBeans = new ArrayList<ProgramFlowBean>();
		
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		programFlowBeans = toXnewsDao.getProgramFlowBeanByTime(beginTime, endTime, pageNo, pageSize);
		if (programFlowBeans.size() > 0) {
			for (ProgramFlowBean programFlowBean : programFlowBeans) {
				if (programFlowBean.getIsKankan() == 1) {
					List<String> moids = new ArrayList<String>();
					moids.add(programFlowBean.getTitleId());
					List<KankanInfo> kankanInfos = queryKankanInfosByMoIDs(moids);
					if (kankanInfos != null && kankanInfos.size() > 0) {
						KankanInfo kankanInfo = kankanInfos.get(0);
						String hits = kankanInfos.get(0).getCount();
						if (hits != null) {
//							log.info("{}获取点击量:{}", programFlowBean.getProgramTitle(), hits);
							programFlowBean.setHits(Integer.parseInt(hits));
							programFlowBean.setHitsUrl(kankanInfo.getUrl());
						}
					}
				}
			}
		}
		return programFlowBeans;
	}
	
	@Override
	@Transactional
	public List<ProgramFlowBean> getProgramFlowBeanBySearchType(SearchType searchType) {
		List<ProgramFlowBean> programFlowBeans = new ArrayList<ProgramFlowBean>();
		
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		programFlowBeans = toXnewsDao.getProgramFlowBeanBySearchType(searchType);
		dealProgramHits(programFlowBeans);
		return programFlowBeans;
	}
	
	/**
	 * 实时获取programFlowBeans的点击量hits 字段
	 * @param programFlowBeans
	 */
	private void dealProgramHits(List<ProgramFlowBean> programFlowBeans) {
		if (programFlowBeans.size() > 0) {
			for (ProgramFlowBean programFlowBean : programFlowBeans) {
				if (programFlowBean.getIsKankan() == 1) {
					List<String> moids = new ArrayList<String>();
					moids.add(programFlowBean.getTitleId());
					List<KankanInfo> kankanInfos = queryKankanInfosByMoIDs(moids);
					if (kankanInfos != null && kankanInfos.size() > 0) {
						KankanInfo kankanInfo = kankanInfos.get(0);
						String hits = kankanInfos.get(0).getCount();
						if (hits != null) {
//							log.info("{}获取点击量:{}", programFlowBean.getProgramTitle(), hits);
							programFlowBean.setHits(Integer.parseInt(hits));
							programFlowBean.setHitsUrl(kankanInfo.getUrl());
						}
					}
				}
			}
		}
	}

	@Override
	public int getProgramFlowBeanBySearchTypeCnt(SearchType searchType) {
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		int count = toXnewsDao.getProgramFlowBeanBySearchTypeCnt(searchType);
		
		return count;
	}

	@Override
	@Transactional
	public List<ProgramFlowBean> getTopHits(String beginTime, String endTime) {
		List<ProgramFlowBean> programFlowBeans = new ArrayList<ProgramFlowBean>();
		List<ProgramFlowBean> programFlowBeans_hits = new ArrayList<ProgramFlowBean>();
		List<ProgramFlowBean> programFlowBeans_hits10 = new ArrayList<ProgramFlowBean>();
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		programFlowBeans = toXnewsDao.getProgramFlowBeanByTime(beginTime, endTime, null, null);
		if (programFlowBeans.size() > 0) {
			for (ProgramFlowBean programFlowBean : programFlowBeans) {
				if (programFlowBean.getIsKankan() == 1) {
					List<String> moids = new ArrayList<String>();
					moids.add(programFlowBean.getTitleId());
					List<KankanInfo> kankanInfos = queryKankanInfosByMoIDs(moids);
					if (kankanInfos != null && kankanInfos.size() > 0) {
						KankanInfo kankanInfo = kankanInfos.get(0);
						String hits = kankanInfo.getCount();
						if (hits != null) {
//							log.info("{}获取点击量:{}", programFlowBean.getProgramTitle(), hits);
							programFlowBean.setHits(Integer.parseInt(hits));
							programFlowBean.setHitsUrl(kankanInfo.getUrl());
						}
					}
					programFlowBeans_hits.add(programFlowBean);
				}
			}
			Collections.sort(programFlowBeans_hits);
			programFlowBeans_hits10 = programFlowBeans_hits.subList(0,
					programFlowBeans_hits.size() > 10 ? 10 : programFlowBeans_hits.size());
		}
		return programFlowBeans_hits10;
	}

	/**
	 * 根据titleId获取点击量
	 */
	public List<KankanInfo> queryKankanInfosByMoIDs(List<String> moIDs) {
		List<KankanInfo> list = new ArrayList<KankanInfo>();
		// TODO 待优化
		String kankanInfoURL = "http://api.kankanews.com/kkrss/xnews/kkstat/set.json";
		if (!StringUtils.hasText(kankanInfoURL)) {
		}
		if (moIDs.size() > 0 && StringUtils.hasText(kankanInfoURL)) {
			try {

				ObjectMapper objectMapper = new ObjectMapper();
				String moids = objectMapper.writeValueAsString(moIDs);
				HttpPost method = new HttpPost(kankanInfoURL);
				StringEntity reqEntity = new StringEntity(moids, ContentType.APPLICATION_JSON);
				method.setEntity(reqEntity);
				CloseableHttpClient httpClient = MultiThreadedHttpClient.getInstance4();
				CloseableHttpResponse response = httpClient.execute(method);
				HttpEntity resEntity = response.getEntity();
				JsonResult<List<KankanInfo>> result = objectMapper.readValue(resEntity.getContent(),
						new TypeReference<JsonResult<List<KankanInfo>>>() {
						});
				if (result.getCode() == JsonResult.SUCCESS) {
					list = result.getResult();
				} else {
					throw new Exception(result.getMessage());
				}
			} catch (Exception e) {
			}
		}
		return list;
	}

	@Override
	@Transactional
	public void checkKankan(String beginTime, String endTime) {
		List<ProgramFlowBean> programFlowBeans = new ArrayList<ProgramFlowBean>();
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		programFlowBeans = toXnewsDao.getProgramFlowBeanByIsKankan(beginTime, endTime);
		for (ProgramFlowBean programFlowBean : programFlowBeans) {
			List<ProcessinstanceMod> processinstanceMods = toXnewsDao.getProcessinstanceModByName(
					programFlowBean.getProgramTitle()+ "-对应报道", programFlowBean.getCreateTimes());
			if (processinstanceMods.size() > 0) {
				log.info(programFlowBean.getProgramTitle() + "已推送看看，id:" + programFlowBean.getProgramID());
				// TODO 点击量获取 需要适时更新因此在查询时再获取，此处不获取
				programFlowBean.setIsKankan(1);
				programFlowBean.setTitleId(processinstanceMods.get(0).getMoid());
				CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
				toXnewsDao.updateProgramNode(programFlowBean);
			}
		}

	}

	@Override
	public List<ToXnewsCnt> getProgramnodeCnt(String startDt, String endDt) {
		
		return toXnewsDao.getProgramnodeCnt( startDt,  endDt);
	}

	@Override
	@Transactional
	public void checkClue(String beginTime, String endTime, int nodeName, int isDeal) {

		List<BussinessNodeBean> bussinessNodeBeans = new ArrayList<BussinessNodeBean>();

		String msgInfo="11";
		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		bussinessNodeBeans = toXnewsDao.getBussinessNode(beginTime, endTime, nodeName + "", msgInfo,isDeal);

		for (BussinessNodeBean bean : bussinessNodeBeans) {
			List<XnewsData> xnewsDatas = new ArrayList<XnewsData>();
			List<AssetRelationships> assetRelationships = new ArrayList<AssetRelationships>();
			
			CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_XNEWS);
			xnewsDatas = toXnewsDao.getXnewsDataByMoid(bean.getMsgInfo());
			log.info("根据id获取xnews信息xnewsDatas：{},id:",xnewsDatas,bean.getMsgInfo());
			CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_XNEWS);
			assetRelationships = toXnewsDao.getRelationships(bean.getMsgInfo());
			log.info("assetRelationships:{}",assetRelationships);
			if (xnewsDatas.size() != 0) {
				for (XnewsData xnewsData : xnewsDatas) {
					BussinessNodeBean bussinessNodeBean = new BussinessNodeBean();
					bussinessNodeBean.setId(UUIDRadom.getUUID());
					bussinessNodeBean.setProgramID(bean.getProgramID());
					bussinessNodeBean.setNodeID(xnewsData.getMoid());
					bussinessNodeBean.setNodeName(nodeName + 1); // 7 线索 8 选题 9  报道
					bussinessNodeBean.setStartTime(xnewsData.getAssetDate());
					bussinessNodeBean.setEndTime(xnewsData.getAssetDate());
					bussinessNodeBean.setIfFinished("1");
					bussinessNodeBean.setIfHasError("0");
					bussinessNodeBean.setErrorInfo("");
					if (nodeName == 6) {
						bussinessNodeBean.setExeName("clue");
					} else if (nodeName == 7) {
						bussinessNodeBean.setExeName("topic");
					} else if (nodeName == 8) {
						bussinessNodeBean.setExeName("title");
					}
					if (assetRelationships.size() >0) {
						// TODO 多个情况
						bussinessNodeBean.setMsgInfo(assetRelationships.get(0).getMoid());
					}
					bean.setIsDeal(1);
					CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
					toXnewsDao.updateBussiness(bean);
					CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
					toXnewsDao.insertBussinessNodeBean(bussinessNodeBean);
				}

			}

		}
	}

	@Override
	public void checkKankan(String beginTime, String endTime, int nodeName, int isDeal) {

		List<BussinessNodeBean> bussinessNodeBeans = new ArrayList<BussinessNodeBean>();

		CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
		bussinessNodeBeans = toXnewsDao.getBussinessNode(beginTime, endTime, nodeName + "", null, isDeal);

		if(bussinessNodeBeans.size()>0){
			
			for (BussinessNodeBean bean : bussinessNodeBeans) {
				List<ProcessinstanceMod> processinstanceMods = new ArrayList<ProcessinstanceMod>();
				CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_XNEWS);
				processinstanceMods = toXnewsDao.getProcessinstanceModByMoid(bean.getNodeID());
				log.info("processinstanceMods:{}",processinstanceMods);
				if (processinstanceMods.size() > 0) {
					ProgramFlowBean programFlowBean = new ProgramFlowBean();
					CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
					programFlowBean = toXnewsDao.getProgramFlowBeanById(bean.getProgramID());
					programFlowBean.setIsKankan(1);
					programFlowBean.setTitleId(bean.getNodeID());
					CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
					toXnewsDao.updateProgramNode(programFlowBean);
				}
				if (processinstanceMods.size() > 0) {
					// TODO 多个情况
					bean.setIsDeal(1);
					CustomerContextHolder.setCustomerType(CustomerContextHolder.DATA_SOURCE_TEST);
					toXnewsDao.updateBussiness(bean);
				}
			}
		}

	}
		

	
}
