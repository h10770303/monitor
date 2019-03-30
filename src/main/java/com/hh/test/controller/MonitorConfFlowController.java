package com.hh.test.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hh.test.manager.ToXnewsManager;
import com.hh.test.pojo.BussinessNode;
import com.hh.test.pojo.bean.DataShow;
import com.hh.test.pojo.bean.ProgramFlowBean;
import com.hh.test.pojo.bean.ToXnewsCnt;
import com.hh.test.util.JsonResult;
import com.hh.test.util.PageResult;
import com.hh.test.util.SearchType;

/**
 * avidToXnews流程监控数据展示
 * 
 * @author smg
 *
 */
@Controller
public class MonitorConfFlowController {

	Logger log = LoggerFactory.getLogger(getClass());
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Resource
	private ToXnewsManager toXnewsManager;

	/**
	 * avid反推管理员查看
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/monitorConfFlow")
	public String getMonitor(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入monitorConfFlow");
		return "toxnews/monitorConfflow";
	}
	
	/**
	 * avid反推管理员查看
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@RequestMapping("/avidtoxnews")
	public String avidtoxnews(HttpServletRequest req, HttpServletResponse resp) {
		log.info("进入avidtoxnews");
		return "toxnews/avidtoxnews";
	}

	/**
	 * 获取流程信息
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getMonitorConfFlow", method = RequestMethod.POST)
	public PageResult<ProgramFlowBean> getMonitorConfFlow(@RequestBody SearchType searchType, HttpServletRequest req,
			HttpServletResponse resp) {
		log.info("进入getMonitorConfFlow,pageNo={}", searchType);
		int cnt=toXnewsManager.getProgramFlowBeanBySearchTypeCnt(searchType);
		 PageResult<ProgramFlowBean> pageResult = new PageResult<>();
		List<ProgramFlowBean> programFlowBeansPage = toXnewsManager.getProgramFlowBeanBySearchType(searchType);
		pageResult.setTotal(cnt);
		pageResult.setRecords(programFlowBeansPage);
		return pageResult;
	}

	/**
	 * 获取top 10 评论数
	 * 
	 * @param req
	 * @param resp
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getTopHits", method = RequestMethod.GET)
	public PageResult<ProgramFlowBean> getTopHits(HttpServletRequest req) {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		String beginTime = sdf.format(date);
		String endTime = sdf.format(cal.getTime());
		PageResult<ProgramFlowBean> pageResult = new PageResult<>();
		List<ProgramFlowBean> programFlowBeans = toXnewsManager.getTopHits(beginTime, endTime);
		pageResult.setTotal(programFlowBeans.size());
		pageResult.setRecords(programFlowBeans);
		return pageResult;
	}
	
	@ResponseBody
	@RequestMapping(value = "/getTopHitsEchart", method = RequestMethod.POST)
	public JsonResult<DataShow> getTopHitsEchart(@RequestBody SearchType searchType,HttpServletRequest req) {
		log.info("进入getTopHitsEchart searchTpe{}",searchType);
		DataShow dataShow=new DataShow();
		List<ProgramFlowBean> programFlowBeans = toXnewsManager.getTopHits(searchType.getStartDt(), searchType.getEndDt());
		List<ToXnewsCnt> toXnewsCnts = toXnewsManager.getProgramnodeCnt(searchType.getStartDt(), searchType.getEndDt());
		dataShow.setProgramFlowBeans(programFlowBeans);
		dataShow.setToXnewsCnts(toXnewsCnts);
		return new JsonResult<DataShow>(dataShow).success();
	}
	
	/**
	 *  统计当天反推总量、与引用了量对比
	 * @param searchType
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/getProgramnodeCnt", method = RequestMethod.POST)
	public JsonResult<List<ToXnewsCnt>> getProgramnodeCnt(@RequestBody SearchType searchType,HttpServletRequest req) {
		log.info("进入getProgramnodeCnt searchTpe{}",searchType);
		List<ToXnewsCnt> toXnewsCnts = toXnewsManager.getProgramnodeCnt("2017-08-07", searchType.getEndDt());
		System.out.println(toXnewsCnts);
		return new JsonResult<List<ToXnewsCnt>>(toXnewsCnts).success();
	}

	/**
	 * 获取详细节点信息
	 * 
	 * @param programID
	 * @param req
	 * @param resp
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getBussinessNodeBeanByprogramID",method=RequestMethod.GET)
	public JsonResult<List<BussinessNode>> getBussinessNodeBeanByprogramID(@RequestParam("programID") String programID,
			HttpServletRequest req, HttpServletResponse resp) {
		List<BussinessNode> bussinessNodes = toXnewsManager.getBussinessNodeByProgramID(programID);
		return new JsonResult<List<BussinessNode>>(bussinessNodes).success();
	}

}
